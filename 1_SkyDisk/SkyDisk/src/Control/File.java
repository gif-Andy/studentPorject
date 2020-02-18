package Control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;



public class File {
	private String fileid;
	private String filename;
	private String filetype;
	private String filesize;
	private String filecomment;
	private String filedate;
	private String sharefilename;
	private String fileowner;
	private String fileownerid;
	
	public File() {}
	
	public String getFileid() {
		return fileid;
	}

	public void setFileid(String fileid) {
		this.fileid = fileid;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	public String getFilesize() {
		return filesize;
	}

	public void setFilesize(String filesize) {
		this.filesize = filesize;
	}

	public String getFilecomment() {
		return filecomment;
	}

	public void setFilecomment(String filecomment) {
		this.filecomment = filecomment;
	}

	public String getFiledate() {
		return filedate;
	}

	public void setFiledate(String filedate) {
		this.filedate = filedate;
	}

	public String getSharefilename() {
			return sharefilename;
	}

	public void setSharefilename(String sharefilename) {
		this.sharefilename = sharefilename;
	}
	

	public String getFileowner() {
		return fileowner;
	}

	public void setFileowner(String fileowner) {
		this.fileowner = fileowner;
	}

	public String getFileownerid() {
		return fileownerid;
	}

	public void setFileownerid(String fileownerid) {
		this.fileownerid = fileownerid;
	}

/***
 * 输出所有文件信息
 * @param fname
 * @return filesList
 * @throws SQLException
 * @throws ClassNotFoundException
 */
		public  ArrayList<File> searchFiles(String fname) throws SQLException, ClassNotFoundException {
			ArrayList<File> filesList = new ArrayList<File>(); 
			String sql = "select * from file where filename like '%" +fname+"%'" ;
			ResultSet rs = DataConnection.getStat().executeQuery(sql);
			File files = null;
			while (rs.next()) {
				files = new File();
				files.setFileid(String.valueOf(rs.getInt(1)));
				files.setFilename(rs.getString(2));
				files.setFilesize(rs.getString(3));
				files.setFiletype(rs.getString(4));
				files.setFilecomment(rs.getString(5));
				files.setFiledate(rs.getString(6));
				filesList.add(files);
			}

			return filesList;
		}
		
		/***
		 * 输出某用户的文件信息
		 * @param uid
		 * @return filesList
		 * @throws SQLException
		 * @throws ClassNotFoundException
		 */
		
		public  ArrayList<File> personFiles(String uid,String searchTxt) throws SQLException, ClassNotFoundException {
			ArrayList<File> filesList = new ArrayList<File>(); 
			String sql = "select file.fileid,filename,filesize,filetype,filecomment,filedate" +
					" from result,file where  result.fileid=file.fileid and result.userid="+uid+" and file.filename like '%" +searchTxt+"%'" ;
			ResultSet rs = DataConnection.getStat().executeQuery(sql);
			File files = null;
			while (rs.next()) {
				files = new File();
				files.setFileid(String.valueOf(rs.getInt(1)));//String 类型  数据库是int类型
				files.setFilename(rs.getString(2));
				files.setFilesize(ModelFactory.getFilesSize(rs.getString(3)));
				files.setFiletype(rs.getString(4));
				files.setFilecomment(rs.getString(5));
				files.setFiledate(rs.getString(6));
				filesList.add(files);
			}

			return filesList;
		}
		
		
		/***
		 * 输出用户的分享文件的信息
		 * @param uid
		 * @return filesList
		 * @throws SQLException
		 * @throws ClassNotFoundException
		 */
		
		public  ArrayList<File> shareFiles(String searchTxt) throws SQLException, ClassNotFoundException {
			ArrayList<File> filesList = new ArrayList<File>(); 
			String sql = "select user.username,share.fileid,share.filename,share.filesize,share.filetype,share.filecomment,share.filedate " +
					"from share_result,share,user  " +
					"where  share_result.fileid=share.fileid and share_result.userid=user.userid and share.filename like '%" +searchTxt+"%'" ;
			ResultSet rs = DataConnection.getStat().executeQuery(sql);
			File files = null;
			while (rs.next()) {
				files = new File();
				files.setSharefilename(rs.getString(1));
				files.setFileid(String.valueOf(rs.getInt(2)));
				files.setFilename(rs.getString(3));
				files.setFilesize(ModelFactory.getFilesSize(rs.getString(4)));
				files.setFiletype(rs.getString(5));
				files.setFilecomment(rs.getString(6));
				files.setFiledate(rs.getString(7));
				filesList.add(files);
			}

			return filesList;
		}
		/***
		 * 文件集合转化为二维数组
		 * @param uid
		 * @return datas
		 */
		
		public static Object[][] convery(String uid,String searchTxt){
			File f= new File();
			Object datas[][] = null ;
			ArrayList<File> List = new ArrayList<File>(); 
			try {
				List = f.personFiles(uid,searchTxt);
				
				datas = new Object[List.size()][7];  
				for(int i=0;i<List.size();i++){
					File data = List.get(i);
					datas[i][0] = data.getFilename();
					datas[i][1] = data.getFilesize();
					datas[i][2] = data.getFiletype();
					datas[i][3] = data.getFiledate();
					datas[i][4] = 0;
					datas[i][5] = 0;
					datas[i][6] = data.getFileid();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return datas;
		}
		
		/***
		 * 分享文件集合转化为二维数组
		 * @param uid
		 * @return datas
		 */
		
		public static Object[][] shareConvery(String searchTxt){
			File f= new File();
			Object datas[][] = null ;
			ArrayList<File> List = new ArrayList<File>(); 
			try {
				List = f.shareFiles(searchTxt);
				
				datas = new Object[List.size()][7];  
				for(int i=0;i<List.size();i++){
					File data = List.get(i);
					datas[i][0] = data.getSharefilename();
					datas[i][1] = data.getFilename();
					datas[i][2] = data.getFilesize();
					datas[i][3] = data.getFiletype();
					datas[i][4] = data.getFiledate();
					datas[i][5] = 0;
					datas[i][6] = data.getFileid();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return datas;
		}
		
		
		/***
		 * 判断文件id
		 * @param fid
		 * @return boolean
		 * @throws SQLException
		 */
		public boolean isFiles(String fid) throws SQLException{
			int fileid = Integer.parseInt(fid);
			String sql = "select * from file where fileid ="+fileid;
			ResultSet rs = DataConnection.getStat().executeQuery(sql);
			if(rs.next()){
					return true;
				}else {
					return false;
				}
			
		}
			
			/***
			 * 
			 * 将用户上传的文件添加到文件数据库
			 * @param fname
			 * @param fsize
			 * @param ftype
			 * @return
			 * @throws SQLException
			 */
		public static void insertFiles(String fname,String fsize,String ftype,String type) throws SQLException{
			String sql ="select * from "+type+" where filename ='"+fname+"' and filesize='"+fsize+"' and filetype ='"+ftype+"'";
			ResultSet rs = DataConnection.getStat().executeQuery(sql);
			if(!rs.next()){
				sql = "insert into "+ type +" (filename,filesize,filetype) values(?,?,?) " ;
				PreparedStatement ptmt = DataConnection.getCon().prepareStatement(sql);
				ptmt.setString(1, fname);
				ptmt.setString(2, fsize);
				ptmt.setString(3, ftype);
				ptmt.execute();
				
			}
		}
		
		/***
		 * 判断文件是否存在
		 * @param uid
		 * @param fname
		 * @param fsize
		 * @param ftype
		 * @return
		 * @throws SQLException
		 */
		public static boolean isFiles(String uid,String fname,String fsize,String ftype) throws SQLException{
			String sql = "select * from file,result where filename ='"+fname+"' and filetype='"+ftype+"' and filesize= '"+fsize+"' and file.fileid = result.fileid and result.userid='"+uid+"'";
			ResultSet rs = DataConnection.getStat().executeQuery(sql);
			if(rs.next()){
				return false;  //该文件已存在
			}
			return true;//该文件不存在
			
		}
		/***
		 * 插入到用户展示界面result
		 * @param fname
		 * @param fsize
		 * @param ftype
		 * @throws SQLException
		 */
		public static void insertResult(String fname,String fsize,String ftype,String type,String type_result) throws SQLException{
			
			String sql = "select fileid from "+type+" where filename ='"+fname+"' and filesize='"+fsize+"' and filetype ='"+ftype+"'";
			ResultSet rs = DataConnection.getStat().executeQuery(sql);
			while(rs.next()){
				sql = "insert into "+ type_result +" (userid,fileid) values(?,?) " ;
				PreparedStatement ptmt = DataConnection.getCon().prepareStatement(sql);
				ptmt.setString(1, User.getUserid());
				ptmt.setInt(2, rs.getInt(1));
				ptmt.execute();
			}

		}
		/***
		 * 获取全部文件的大小
		 * @param uid
		 * @return
		 * @throws SQLException
		 */
		public static String getAllFilesSize(String uid) throws SQLException{
			int fsize=0;
			String sql = "select file.filesize from file,user,result where result.fileid=file.fileid and result.userid=user.userid and result.userid=" + uid;
			ResultSet rs = DataConnection.getStat().executeQuery(sql);
			while (rs.next()) {
				fsize = fsize +Integer.parseInt(rs.getString(1));			
			}
			return String.valueOf(fsize);
		}
		
		/***
		 * 用户重命名文件
		 * @param nowvalue
		 * @param uid
		 * @param fname
		 * @param ftype
		 * @return
		 * @throws SQLException
		 */
		public static boolean updateFile(String nowvalue ,String uid,String fname,String ftype) throws SQLException{
			String sql = "update file,result set filename='"+nowvalue+"' where result.userid='"+uid+"' and result.fileid=file.fileid and filename ='"+fname+"' and filetype='"+ftype+"'";
			try {
				Statement stmt=DataConnection.getCon().createStatement();
				stmt.executeUpdate(sql);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		
		/***
		 * 用户删除文件
		 * @param fileid
		 * @return
		 * @throws SQLException
		 */
		public static boolean deleteFile(String fileid ) throws SQLException{
				String sql = "delete from result where fileid='"+fileid+"'";
		        PreparedStatement ptmt = DataConnection.getCon().prepareStatement(sql);
		        ptmt.execute();
		        
		        return true;		
			
		}
		
		public  ArrayList<File> getFileType(String uid,String filetype) throws SQLException, ClassNotFoundException {
			ArrayList<File> filesList = new ArrayList<File>(); 
			String sql = "select file.fileid,filename,filesize,filetype,filecomment,filedate" +
					" from result,file where  result.fileid=file.fileid and result.userid="+uid+" and file.filetype like '%" +filetype+"%'" ;
			ResultSet rs = DataConnection.getStat().executeQuery(sql);
			File files = null;
			while (rs.next()) {
				files = new File();
				files.setFileid(String.valueOf(rs.getInt(1)));//String 类型  数据库是int类型
				files.setFilename(rs.getString(2));
				files.setFilesize(ModelFactory.getFilesSize(rs.getString(3)));
				files.setFiletype(rs.getString(4));
				files.setFilecomment(rs.getString(5));
				files.setFiledate(rs.getString(6));
				filesList.add(files);
			}

			return filesList;
		}
		
		
}
