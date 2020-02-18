package Control;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


import javax.swing.JFileChooser;
import javax.swing.JLabel;
public class FileChooser{
	
	/*public static void main(String[] args) {
		FileChooser.uploadFile();
	}*/
	
	
	
	public static boolean uploadFile (String type){
		JFileChooser jfc=new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
		jfc.showDialog(new JLabel(), "选择");
		File file=jfc.getSelectedFile();
		
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
		fsize=String.valueOf(file.length());
		
		try {
			String target  = "G:\\SkyDisk\\"+diskName+".zip";
			//String resource = file.getAbsolutePath();
			
			long start = System.currentTimeMillis();
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(target));
		
			//使用缓冲流
			BufferedOutputStream bufout = new BufferedOutputStream(out);
			//ZipEntry ziptmp = new ZipEntry(jfc.getSelectedFile().getName());
			//out.putNextEntry(ziptmp);
			if(file.isDirectory()){
				System.out.println("文件夹:"+file.getAbsolutePath());
				
			}else if(file.isFile()){
				System.out.println("文件:"+file.getAbsolutePath());
			}

		/*	isFiles = Control.File.insertFiles(diskName, fsize, fileType,type);
			if(isFiles){
				FileChooser.zip(out, file, file.getName(), bufout);
				bufout.close();
				out.close();
				long end = System.currentTimeMillis();
				System.out.println("压缩结束,时间为:"+(end-start)+"毫秒");
				return true;
			}
			else{
				return false;
			}*/
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return false;
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
}

