package Control;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.activation.DataSource;

public class Admin implements Serializable{
	private static String adminid;
	private static String adminname;
	private static String adminpassword;
	private static String mMemory;
	private static String mAd;
	//public static String adUrl = "C://Users//阿单//Desktop//play.png";
	public static String adUrl ;
	public Admin(){}
	
	public Admin(String adminid, String adminname,String adminpassword) {
		super();
		Admin.adminid = adminid;
		Admin.adminname = adminname;
		Admin.adminpassword = adminpassword;

	}
	
	
	public static String getAdminid() {
		return adminid;
	}
	public static void setAdminid(String adminid) {
		Admin.adminid = adminid;
	}
	public static String getAdminname() {
		return adminname;
	}
	public static void setAdminname(String adminname) {
		Admin.adminname = adminname;
	}
	public static String getAdminpassword() {
		return adminpassword;
	}
	public static void setAdminpassword(String adminpassword) {
		Admin.adminpassword = adminpassword;
	}
	public static String getmMemory() {
		return mMemory;
	}
	public static void setmMemory(String mMemory) {
		Admin.mMemory = mMemory;
	}
	public static String getmAd() {
		return mAd;
	}
	public static void setmAd(String mAd) {
		Admin.mAd = mAd;
	}
	
	/***
	 * 获取用户文件信息
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public  ArrayList<File> getFileMessages(String searchTxt) throws SQLException, ClassNotFoundException {
		ArrayList<File> filesList = new ArrayList<File>(); 
		String sql = "select user.userid,file.fileid,file.filename,file.filesize,file.filetype,file.filecomment,file.filedate " +
				"from result,user,file  where result.fileid=file.fileid and result.userid=user.userid and file.filename like  '%" +searchTxt+"%'" ;
		ResultSet rs = DataConnection.getStat().executeQuery(sql);
		File files = null;
		while (rs.next()) {
			files = new File();
			files.setFileownerid(rs.getString(1));
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
	 * 将文件信息转为二维数组
	 * @return
	 */
	public static Object[][] convery(String searchTxt){
		Admin admin= new Admin();
		Object datas[][] = null ;
		ArrayList<File> List = new ArrayList<File>(); 
		try {
			List = admin.getFileMessages(searchTxt);
			
			datas = new Object[List.size()][7];  
			for(int i=0;i<List.size();i++){
				File data = List.get(i);
				datas[i][0] = data.getFileownerid();
				datas[i][1] = data.getFileid();
				datas[i][2] = data.getFilename();
				datas[i][3] = data.getFilesize();
				datas[i][4] = data.getFiletype();
				datas[i][5] = data.getFiledate();
				datas[i][6] = 0;
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
	 * 输出用户信息
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public  ArrayList<User> getUserMessages(String searchTxt) throws SQLException, ClassNotFoundException {
		ArrayList<User> UsersList = new ArrayList<User>(); 
		String sql = "select * from user where username like  '%" +searchTxt+"%'" ;
		ResultSet rs = DataConnection.getStat().executeQuery(sql);
		User user;
		while (rs.next()) {
			user = new User();
			user.setUid(rs.getString(1));
			user.setUname(rs.getString(2));
			user.setUpassword(rs.getString(3));
			user.setUmemory(rs.getString(4));
			user.setUphone(rs.getString(5));
			user.setUemail(rs.getString(6));
			UsersList.add(user);
		}

		return UsersList;
	}
	
	/***
	 * 获取全部User信息
	 * @param searchTxt
	 * @return
	 */
	public static Object[][] Userconvery(String searchTxt){
		Admin admin= new Admin();
		Object datas[][] = null ;
		ArrayList<User> List = new ArrayList<User>(); 
		try {
			List = admin.getUserMessages(searchTxt);
			
			datas = new Object[List.size()][7];  
			for(int i=0;i<List.size();i++){
				User data = List.get(i);
				datas[i][0] = data.getUid();
				datas[i][1] = data.getUname();
				datas[i][2] = data.getUpassword();
				datas[i][3] = ModelFactory.getFilesSize(data.getUmemory());
				datas[i][4] = data.getUemail();
				datas[i][5] = data.getUemail();
				datas[i][6] = 0;
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
	 * 设置用户内存
	 * @param memory
	 * @param uid
	 * @throws SQLException
	 */
	public static boolean updateMemory (String memory,String uid) throws SQLException{
		String sql = "select userid from user where userid='"+ uid+"'";
		ResultSet rs = DataConnection.getStat().executeQuery(sql);
		if(rs.next()){
			sql = "update user set memory = '"+ memory+ "' where userid= '"+uid+"'";
			Statement stmt=DataConnection.getCon().createStatement();
			stmt.executeUpdate(sql);
			return true;
		}
		return false;
		
	} 
	/***
	 * 计算用户的总数
	 * @return
	 * @throws SQLException
	 */
	public static int  getAllUser() throws SQLException{
		String sql = "select count(userid) as sum from user";
		ResultSet rs = DataConnection.getStat().executeQuery(sql);
		if(rs.next()){
			int sum = rs.getInt("sum");
			return sum;
		}
		return 0;
		//return rs.getInt(1);
	}
	
	/***
	 * 计算广告的总数
	 * @return
	 * @throws SQLException
	 */
	public static int  getAllAd() throws SQLException{
		String sql = "select count(adid) as sum from ad";
		ResultSet rs = DataConnection.getStat().executeQuery(sql);
		if(rs.next()){
			int sum = rs.getInt("sum");
			return sum;
		}
		return 0;
		//return rs.getInt(1);
	}
	
	/***
	 * 删除result
	 * @param uid
	 * @throws SQLException
	 */
	public static void deleteResult(String uid) throws SQLException{
		String sql = "select * from result where userid='"+uid+"'";
		ResultSet rs = DataConnection.getStat().executeQuery(sql);
		if(rs.next()){
			sql = "delete from result where userid='"+uid+"'";
	        PreparedStatement ptmt = DataConnection.getCon().prepareStatement(sql);
	        ptmt.execute();
	 
		}
	
	}
	/***
	 * 删除share_result
	 * @param uid
	 * @throws SQLException
	 */
	public static void deleteShareResult(String uid) throws SQLException{
		String sql = "select * from share_result where userid='"+uid+"'";
		ResultSet rs = DataConnection.getStat().executeQuery(sql);
		if(rs.next()){
			sql = "delete from share_result where userid='"+uid+"'";
	        PreparedStatement ptmt = DataConnection.getCon().prepareStatement(sql);
	        ptmt.execute();
	
		}

	}
	/***
	 * 注销用户
	 * @param uid
	 * @throws SQLException
	 */
	public static void deleteUser(String uid) throws SQLException{
		String sql = "delete from user where userid='"+uid+"'";
        PreparedStatement ptmt = DataConnection.getCon().prepareStatement(sql);
        ptmt.execute();
	}
	
	/***
	 * 
	 * @param fid
	 * @throws SQLException
	 */
	public static void deleteFilesResult(String fid) throws SQLException{
		String sql = "select * from result where fileid='"+fid+"'";
		ResultSet rs = DataConnection.getStat().executeQuery(sql);
		if(rs.next()){
			sql = "delete from result where fileid='"+fid+"'";
	        PreparedStatement ptmt = DataConnection.getCon().prepareStatement(sql);
	        ptmt.execute();
	 
		}
	
	}
	/***
	 * 删除该文件在共享文件的
	 * @param fid
	 * @throws SQLException
	 */
	public static void deleteFileShareResult(String fid) throws SQLException{
		String sql = "select * from share_result where fileid='"+fid+"'";
		ResultSet rs = DataConnection.getStat().executeQuery(sql);
		if(rs.next()){
			sql = "delete from share_result where fileid='"+fid+"'";
	        PreparedStatement ptmt = DataConnection.getCon().prepareStatement(sql);
	        ptmt.execute();
	
		}

	}
	
	/***
	 * 删除文件
	 * @param fid
	 * @throws SQLException
	 */
	public static void deleteFiles(String fid) throws SQLException{
		String sql = "delete from file where fileid='"+fid+"'";
        PreparedStatement ptmt = DataConnection.getCon().prepareStatement(sql);
        ptmt.execute();
		
	}
	
	/***
	 * 获取全部文件数
	 * @return
	 * @throws SQLException
	 */
	public static int getAllFiles() throws SQLException{
		String sql = "select count(fileid) as sum from file";
		ResultSet rs = DataConnection.getStat().executeQuery(sql);
		if(rs.next()){
			int sum = rs.getInt("sum");
			return sum;
		}
		return 0;
		
	}
	
	/***
	 * 添加广告
	 * @param uname
	 * @param companyName
	 * @param phone
	 * @param email
	 * @param adName
	 * @param adUrl
	 * @throws SQLException
	 */
	public static void insertAd(String uname,String companyName,String phone,String email,String adName,String adUrl) throws SQLException{
		String sql = "insert into ad (adowner,adcompany,adphone,ademail,adname,adurl) values(?,?,?,?,?,?) " ;
		PreparedStatement ptmt = DataConnection.getCon().prepareStatement(sql);
		ptmt.setString(1, uname);
		ptmt.setString(2, companyName);
		ptmt.setString(3, phone);
		ptmt.setString(4, email);
		ptmt.setString(5, adName);
		ptmt.setString(6, adUrl);
		ptmt.execute();
	}
	
	/**
	 * 删除广告
	 * @param adid
	 * @throws SQLException
	 */
	public static void deleteAd(int adid) throws SQLException{
		String sql = "delete from ad where adid="+adid;
        PreparedStatement ptmt = DataConnection.getCon().prepareStatement(sql);
        ptmt.execute();
		
	}
	/**
	 * 删除公告
	 * @param adid
	 * @throws SQLException
	 */
	public static void deleteNotice(int noticeid) throws SQLException{
		String sql = "delete from notice where adid="+noticeid;
        PreparedStatement ptmt = DataConnection.getCon().prepareStatement(sql);
        ptmt.execute();
		
	}
	
	/***
	 * 获取所有的文档信息
	 * @return
	 * @throws SQLException
	 */
	public static int getAllDocument() throws SQLException{
		String sql = "SELECT Count(file.filetype) as sum FROM file WHERE "+
		"file.filetype='txt' OR "+
		"file.filetype='doc' OR "+
		"file.filetype='docx' OR "+
		"file.filetype='htm' OR "+
		"file.filetype='html' OR "+
		"file.filetype='jsp' OR "+
		"file.filetype='rtf' OR "+
		"file.filetype='wpd' OR "+
		"file.filetype='pdf' OR "+
		"file.filetype='php' OR "+
		"file.filetype='java' OR "+
		"file.filetype='ppt' ";
		ResultSet rs = DataConnection.getStat().executeQuery(sql);
		if(rs.next()){
			return rs.getInt("sum");
		}
		return 0;
	}
	
	/***
	 * 获取所有的图片信息
	 * @return
	 * @throws SQLException
	 */
	public static int getAllPicture() throws SQLException{
		String sql = "SELECT Count(file.filetype) as sum FROM file WHERE "+
		"file.filetype='bmp' OR"+
		"file.filetype='jpg' OR"+
		"file.filetype='jpeg' OR"+
		"file.filetype='png' OR"+
		"file.filetype='tiff' OR"+
		"file.filetype='gif' OR"+
		"file.filetype='tga' OR"+
		"file.filetype='exif' OR"+
		"file.filetype='fpx' OR"+
		"file.filetype='svg' OR"+
		"file.filetype='psd' OR"+
		"file.filetype='cdr' OR"+
		"file.filetype='pcd' OR"+
		"file.filetype='dxf' OR"+
		"file.filetype='ufo' OR"+
		"file.filetype='eps' OR"+
		"file.filetype='ai' OR"+
		"file.filetype='raw' OR"+
		"file.filetype='wmf' ";
		ResultSet rs = DataConnection.getStat().executeQuery(sql);
		if(rs.next()){
			return rs.getInt("sum");
		}
		
		return 0;
	}
	
	/***
	 * 获取所有的音频
	 * @return
	 * @throws SQLException
	 */
	public static int getAllAudio() throws SQLException{
		String sql = "SELECT Count(file.filetype) as sum FROM file WHERE "
		+"file.filetype='mp3' OR "
		+"file.filetype='wma' OR "
		+"file.filetype='wav' OR "
		+"file.filetype='mod' OR "
		+"file.filetype='ra' OR "
		+"file.filetype='cd' OR "
		+"file.filetype='ms' OR "
		+"file.filetype='acc' OR "
		+"file.filetype='vqf' OR "
		+"file.filetype='ape' OR "
		+"file.filetype='mid' OR "
		+"file.filetype='ogg' ";
		
		ResultSet rs = DataConnection.getStat().executeQuery(sql);
		if(rs.next()){
			return rs.getInt("sum");
		}
		
		return 0;
	}
	
	/***
	 * 获取所有其他文件类型总数
	 * @return
	 * @throws SQLException
	 */
	public static int getAllOther() throws SQLException{
		String sql = "SELECT Count(file.filetype) as sum FROM file WHERE "
		+"file.filetype<>'png' AND "
		+"file.filetype<>'mp3' AND "
		+"file.filetype<>'wma' AND "
		+"file.filetype<>'wav' AND "
		+"file.filetype<>'mod' AND "
		+"file.filetype<>'ra' AND "
		+"file.filetype<>'cd' AND "
		+"file.filetype<>'ms' AND "
		+"file.filetype<>'acc' AND "
		+"file.filetype<>'vqf' AND "
		+"file.filetype<>'ape' AND "
		+"file.filetype<>'mid' AND "
		+"file.filetype<>'ogg' AND "
		+"file.filetype<>'mp4' AND "
		+"file.filetype<>'avi' AND "
		+"file.filetype<>'mov' AND "
		+"file.filetype<>'wmv' AND "
		+"file.filetype<>'asf' AND "
		+"file.filetype<>'navi' AND "
		+"file.filetype<>'3gp' AND "
		+"file.filetype<>'mkv' AND "
		+"file.filetype<>'f4v' AND "
		+"file.filetype<>'rmvb' AND "
		+"file.filetype<>'webm' AND " 
		+"file.filetype<>'txt' AND "
		+"file.filetype<>'doc' AND "
		+"file.filetype<>'docx' AND "
		+"file.filetype<>'htm' AND "
		+"file.filetype<>'html' AND "
		+"file.filetype<>'jsp' AND "
		+"file.filetype<>'rtf' AND "
		+"file.filetype<>'wpd' AND "
		+"file.filetype<>'pdf' AND "
		+"file.filetype<>'ppt' AND " 
		+"file.filetype<>'bmp' AND "
		+"file.filetype<>'jpg' AND "
		+"file.filetype<>'jpeg' AND "
		+"file.filetype<>'png' AND "
		+"file.filetype<>'tiff' AND "
		+"file.filetype<>'gif' AND "
		+"file.filetype<>'tga' AND "
		+"file.filetype<>'exif' AND "
		+"file.filetype<>'fpx' AND "
		+"file.filetype<>'svg' AND "
		+"file.filetype<>'psd' AND "
		+"file.filetype<>'cdr' AND "
		+"file.filetype<>'pcd' AND "
		+"file.filetype<>'dxf' AND "
		+"file.filetype<>'ufo' AND "
		+"file.filetype<>'eps' AND "
		+"file.filetype<>'ai' AND "
		+"file.filetype<>'raw' AND "
		+"file.filetype<>'wmf' ";
		
		ResultSet rs = DataConnection.getStat().executeQuery(sql);
		if(rs.next()){
			return rs.getInt("sum");
		}
		
		return 0;
	}

}
