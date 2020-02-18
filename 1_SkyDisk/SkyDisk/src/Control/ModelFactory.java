package Control;

import java.awt.Font;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import com.ftp.Config;
import com.ftp.FtpClientUtil;
import com.ftp.FtpUtil;




public class ModelFactory {
	
	
	
	/***
	 * 
	 * @param userid
	 * @param userpassword
	 * @return
	 * @throws SQLException
	 */
 /*public static User ulogin(String uname,String upw) throws Exception{
		
		u=u.login(uname, upw);
		if(u==null){
			System.out.println("u是空值null");
		}
		return u;
		
	}*/
	
	public static User uLogin(String userid,String userpassword) throws SQLException{
		User u= null;
		String sql= "select * from user where userid ='"+userid+"' and userpassword='"+userpassword+"'";
		ResultSet rs= DataConnection.getStat().executeQuery(sql);
		
		if(rs.next()&&!rs.getString(1).equals("")){
			System.out.println("查询数据库成功");
			u = new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
			return u;
		}
		return null;
	}
	

/***
 * 
 * @param adminid
 * @param adminpassword
 * @return
 * @throws SQLException
 */
	public static Admin alogin(String adminid,String adminpassword) throws SQLException{
		String sql = "select * from admin where adminid='"+adminid+"'and adminpassword='"+adminpassword+"'";
		ResultSet rs= DataConnection.getCon().createStatement().executeQuery(sql);
		if(rs.next()){
			return new Admin(rs.getString(1),rs.getString(2),rs.getString(3));
		}
		return null;
	}

	
	

	
	/***
	 * 计算文件的大小
	 * @param file
	 * @return
	 */
		public static String getFilesSize(String fsize){
			String size = ""; 
		    long fileS = Long.valueOf(fsize);
		      DecimalFormat df = new DecimalFormat("#.00"); 
		      	   if(fileS<=0){
		      		   size = "";
		      	  }else if (fileS < 1024) {
		               size = df.format((double) fileS) + "B";
		           } else if (fileS < 1048576) {
		               size = df.format((double) fileS / 1024) + "KB";
		           } else if (fileS < 1073741824) {
		               size = df.format((double) fileS / 1048576) + "MB";
		           } else {
		               size = df.format((double) fileS / 1073741824) +"GB";
		           }
		    
		    return size;
		}
	
	/***
	 * 文件夹压缩上传
	 * @param zipOut
	 * @param file
	 * @param base
	 * @param bufout
	 * @throws IOException
	 */
	public static void zip(ZipOutputStream zipOut, File file,String base,BufferedOutputStream bufout) throws IOException{
		if(file.isDirectory()){
			File[] childFiles = file.listFiles();
			if(childFiles.length==0){
				zipOut.putNextEntry(new ZipEntry(file.getName()));
			}
			//遍历子文件列表
			for(int i=0;i<childFiles.length;i++){
				zip(zipOut, childFiles[i], base+"/"+childFiles[i].getName(), bufout);
			}
		}else {
			zipOut.putNextEntry(new ZipEntry(base));
			System.out.println("压缩"+file.getAbsolutePath()+"文件");
			FileInputStream in = new FileInputStream(file);
			BufferedInputStream bufin = new BufferedInputStream(in);
			int b;
			while ((b=bufin.read())!=-1){
				bufout.write(b);
			}
			System.out.println("结束");
			bufin.close();
			in.close();
			bufout.flush();
			zipOut.flush();
		}
	}
	
	/***
	 *  用户文件上传/用户分享文件
	 * @param type ,用户文件就file ,分享文件就share_file
	 * @param typeResult ,用户文件就result ,分享文件就share_result
	 * @param isUser ,用户上传文件就传入User.getUserid(),分享文件就public
	 * @return
	 */
	public static String uploadFile (String type,String typeResult,String isUser){
		JFileChooser jfc=new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
		int value = jfc.showDialog(new JLabel(), "选择");
		if(value==JFileChooser.APPROVE_OPTION){ //判断窗口是否点的是打开或保存
			File file=jfc.getSelectedFile();	
			String fpath = file.getAbsolutePath();
				/*文件名字处理*/
				String fileName = file.getName();
				String diskName ="";
				String fileType = "";
				String fsize ="";
				boolean isFiles ;
				if(file.isDirectory()){
					diskName = fileName;
					fileType = "Directory";
				}else if(file.isFile()){
					diskName =fileName.substring(0,fileName.lastIndexOf("."));
					fileType = fileName.substring(fileName.lastIndexOf(".")+1);
				}
				fsize= String.valueOf(file.length());
				if(ModelFactory.isMemory(fsize,User.getUserid())){ //判断内存是否够
					try {
						isFiles = Control.File.isFiles(User.getUserid(),diskName, fsize, fileType);
						if(isFiles){ //判断该文件是否存在
						
							if(file.isDirectory()){
								long start = System.currentTimeMillis();//计算初始时间
								FtpUtil fu = new FtpUtil(Config.FTP.HOST_IP, Config.FTP.HOST_PORT, Config.FTP.FTP_USERNAME, Config.FTP.FTP_PASSWD);
								fu.connectServer();
								boolean isUpload = fu.upload(file.getAbsolutePath(), "/tmp/"+isUser+"/"+file.getName());
								fu.closeServer();
								if(isUpload){
									Control.File.insertFiles(diskName,fsize,fileType,type);
									Control.File.insertResult(diskName, fsize, fileType,type,typeResult);
									return "文件上传成功";
								}
								System.out.println("文件夹:"+file.getAbsolutePath());
								long end = System.currentTimeMillis();//计算结束时间
								System.out.println("文件夹上传结束,时间为:"+(end-start)+"毫秒");
								
								}else if(file.isFile()){
									long start = System.currentTimeMillis();//计算初始时间
									FtpClientUtil ftp = new FtpClientUtil(Config.FTP.HOST_IP, Config.FTP.HOST_PORT, Config.FTP.FTP_USERNAME, Config.FTP.FTP_PASSWD);
									ftp.open();
									boolean isUpload = ftp.upload(file.getAbsolutePath(), file.getName(), "/tmp/"+isUser+"/");
									ftp.close(); 
									if(isUpload){
										Control.File.insertFiles(diskName,fsize,fileType,type);
										Control.File.insertResult(diskName, fsize, fileType,type,typeResult);
										return "文件上传成功";
									}
									System.out.println("文件:"+file.getAbsolutePath());
									long end = System.currentTimeMillis();//计算结束时间
									System.out.println("文件上传结束,时间为:"+(end-start)+"毫秒");
							}
						}else{
							return "文件已存在";
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}else{
					return "内存空间不足";
				}
				//return "文件上传成功11";
		}else {
			return "未选择文件";
		}
		
		return "能不能别选C盘的文件夹和别选中文啊啊";	
		
	}
	/***
	 * 文件下载
	 * @param fname
	 * @return
	 * @throws Exception
	 */
	public static boolean download(String fname,String isUser) throws Exception{
		JFileChooser jfc=new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
		jfc.showDialog(new JLabel(), "选择");
		File file=jfc.getSelectedFile();
		FtpClientUtil ftp = new FtpClientUtil(Config.FTP.HOST_IP, Config.FTP.HOST_PORT, Config.FTP.FTP_USERNAME, Config.FTP.FTP_PASSWD);
		ftp.open();
		//ftp.download("/"+User.getUserid()+"/"+fname,file.getAbsolutePath()+fname);
		long a = ftp.download("/tmp/"+isUser+"/"+fname,file.getAbsolutePath()+"/"+fname);
		ftp.close();
		if(a==0){
			return false;
		}
		return true;
		
	}
	
	/***
	 * 判断用户内存是否已满
	 * @param currentMemory
	 * @param allMemory
	 * @return
	 * @throws SQLException 
	 */
	public static boolean isMemory (String filesize,String uid) {
		try {
			String allMemory = User.getUserAllSize(uid);
			long aMemory = Long.parseLong(allMemory);
			long fsize = Long.parseLong(filesize);
			String currentMemory = Control.File.getAllFilesSize(User.getUserid());
			long cMemory = Long.parseLong(currentMemory);
			if(aMemory-cMemory>=fsize)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
		
	}
	/***
	 * 验证邮箱是否合格
	 * @param email
	 * @return
	 */
	public static boolean emailFormat(String email) { 
        boolean tag = true; 
        String regex = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$"; 
        Pattern p = Pattern.compile(regex); 
        Matcher m = p.matcher(email); 
        if (!m.find()) { 
            tag = false; //不符合邮箱格式
        } 
        return tag; 
    } 
	
	/***
	 * 验证用户ID是否是数字8-10位
	 * @param uid
	 * @return
	 */
	public static boolean UseridFormat(String uid) { 
        boolean tag = true; 
        String regex="^[0-9]{8,10}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(uid);
        if (!m.find()) { 
            tag = false; //不符合数字8-10位
        } 
        return tag; 
    } 
	
/***
 * 验证用户手机号码正确性
 * @param phone
 * @return
 */
	public static boolean PhoneFormat(String phone){  
		boolean tag = true; 
		 String regex="^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
		Pattern p = Pattern.compile(regex);  
		Matcher m = p.matcher(phone); 
		 if (!m.find()) { 
	            tag = false; //不符合数字8-10位
	        } 
	        return tag; 
		  
		}  
	
	/***
	 * 判断用户真实姓名
	 * @param uname
	 * @return
	 */
	public static boolean UserNameFormat(String uname){  
		boolean tag = true; 
		 String regex="-?[0-9]+\\.?[0-9]*";
		Pattern p = Pattern.compile(regex);  
		Matcher m = p.matcher(uname); 
		 if (!m.find()) { 
	            tag = false; //
	        } 
	        return tag; 
		  
		}  
	
	/***
	 * 复制图片
	 * @param src
	 * @param target
	 */
	public static void copyFile(String src,String target)  
    {     
           File srcFile = new File(src);    
           File targetFile = new File(target);    
           try {    
               InputStream in = new FileInputStream(srcFile);     
               OutputStream out = new FileOutputStream(targetFile);    
               byte[] bytes = new byte[1024];    
               int len = -1;    
               while((len=in.read(bytes))!=-1)  
               {    
                   out.write(bytes, 0, len);    
               }    
               in.close();    
               out.close();    
           } catch (FileNotFoundException e) {    
               e.printStackTrace();    
           } catch (IOException e) {    
               e.printStackTrace();    
           }    
           System.out.println("文件复制成功");   


    }  
	
	
	/***
	 * 设置统一字体
	 * @param font
	 */
	public static void InitGlobalFont(Font font) {  
		  FontUIResource fontRes = new FontUIResource(font);  
		  for (Enumeration<Object> keys = UIManager.getDefaults().keys();  
		  keys.hasMoreElements(); ) {  
			  Object key = keys.nextElement();  
			  Object value = UIManager.get(key);  
			  if (value instanceof FontUIResource) {  
				  UIManager.put(key, fontRes);  
			  }  
		  }  
	}  

	
	public static void main(String[] args) {
		String adUrl = "C://Users//阿单//Desktop//delete.png";
		
		String adUrlString = adUrl.replaceAll("\\\\", "//");
		String imgName = adUrlString.substring(adUrlString.lastIndexOf(".")+1);

		//ModelFactory.copyFile( "C://Users//阿单//Desktop//icon.jpg", "G://新建文件夹//SkyDisk//src//imgs//icon.jpg");
		//ModelFactory.copyFile( "C://Users//阿单//Desktop//icon.jpg", "src/imgs/icon1.jpg");
		//String imgUrl = adUrl.substring(adUrl.lastIndexOf("/")+1);
		System.out.println(imgName);
	}
	
	
}
