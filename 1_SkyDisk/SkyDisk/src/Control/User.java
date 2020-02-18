package Control;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class User implements Serializable {
	private static String userid;
	private static String username;
	private static String userpassword;
	private static String memory;
	private static String phone;
	private static String email;
	private  String uid;
	private  String uname;
	private  String upassword;
	private  String umemory;
	private  String uphone;
	private  String uemail;
	
	
	
	public User() {
	}
	
	public User(String userid, String username,String userpassword,String usermemory,String userphone,String useremail) {
		super();
		User.userid = userid;
		User.username = username;
		User.userpassword = userpassword;
		User.memory = usermemory;
		User.phone = userphone;
		User.email = useremail;

	}
	
	

	
	public static String getUserid() {
		return userid;
	}
	public static void setUserid(String userid) {
		User.userid = userid;
	}
	public static String getUsername() {
		return username;
	}
	public static void setUsername(String username) {
		User.username = username;
	}
	public static String getUserpassword() {
		return userpassword;
	}
	public static void setUserpassword(String userpassword) {
		User.userpassword = userpassword;
	}
	public static String getMemory() {
		return memory;
	}
	public static void setMemory(String memory) {
		User.memory = memory;
	}
	public static String getPhone() {
		return phone;
	}
	public static void setPhone(String phone) {
		User.phone = phone;
	}
	public static String getEmail() {
		return email;
	}
	public static void setEmail(String email) {
		User.email = email;
	}
	
	
	
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpassword() {
		return upassword;
	}

	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}

	public String getUmemory() {
		return umemory;
	}

	public void setUmemory(String umemory) {
		this.umemory = umemory;
	}

	public String getUphone() {
		return uphone;
	}

	public void setUphone(String uphone) {
		this.uphone = uphone;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	/***
	 * 用户注册
	 * @param userid
	 * @param uName
	 * @param password
	 * @param uPhone
	 * @param uEmail
	 * @return
	 * @throws SQLException
	 */
	public  static String uRegister(String userid,String uName,String password,String uPhone,String uEmail) throws SQLException{
		String result=null;
		User u = new User();
		
		String sql = "select userid from user where userid ="+userid;
		ResultSet rs = DataConnection.getStat().executeQuery(sql);
		if(rs.next()){
			result = "用户ID已存在";
			return result;
		}else {
			sql = "insert into user(userid,username,userpassword,phone,email) values(?,?,?,?,?) " ;
			PreparedStatement ptmt = DataConnection.getCon().prepareStatement(sql);
			ptmt.setString(1, userid);
			ptmt.setString(2, uName);
			ptmt.setString(3, password);
			ptmt.setString(4, uPhone);
			ptmt.setString(5, uEmail);
			ptmt.execute();
			result = "注册成功";
			return result;
		}
		
	}
	/***
	 * 获取用户信息给列表
	 * @return
	 * @throws SQLException
	 */
	public static  ArrayList<User> searchUser() throws SQLException{
		ArrayList<User> userList = new ArrayList<User>(); 
		User u =null;
		String sql = "select * from user ";
		ResultSet rs = DataConnection.getStat().executeQuery(sql);
		while(rs.next()){
			u= new User(); //重要，不能放在外面声明，不然会导致数据只读取最后一行
			u.setUid(rs.getString(1));
			u.setUname(rs.getString(2));
			u.setUpassword(rs.getString(3));
			u.setUmemory(rs.getString(4));
			u.setUphone(rs.getString(5));
			u.setUemail(rs.getString(6));
			userList.add(u);
		}
		return userList;
	}
	
	public static Object[][] convery(){
		User u= new User();
		Object datas[][] = null ;
		ArrayList<User> List = new ArrayList<User>(); 
		try {
			List = User.searchUser();
			
			datas = new Object[List.size()][6];  
			for(int i=0;i<List.size();i++){
				User data = List.get(i);
				datas[i][0] = data.getUid();
				datas[i][1] = data.getUname();
				datas[i][2] = data.getUpassword();
				datas[i][3] = data.getUmemory();
				datas[i][4] = data.getUphone();
				datas[i][5] = data.getUemail();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return datas;
	}
	
	/***
	 * 判断userid是否存在
	 * @param uid
	 * @return
	 * @throws SQLException
	 */
	public static boolean isUserid (String uid) throws SQLException{
		String sql = "select userid from user where userid='"+uid+"'";
		ResultSet rs = DataConnection.getStat().executeQuery(sql);
		if(rs.next())
			return false;
		return true;
	}
	
	/***
	 * 更新用户数据信息
	 * @param uname
	 * @param upass
	 * @param phone
	 * @param email
	 * @param uid
	 * @return
	 * @throws SQLException
	 */
	public static void updateUserMessage(String uname,String upass,String phone,String email,String uid) throws SQLException{
		String sql = "update user set username='"+uname+"' ,userpassword='"+upass+"' ,phone='"+phone+"' ,email='"+email+"' where userid='"+uid+"'";
		Statement stmt=DataConnection.getCon().createStatement();
		stmt.executeUpdate(sql);

	}
	
	/***
	 * 获取用户自身存储空间大小
	 * @param uid
	 * @return
	 * @throws SQLException
	 */
	public static String getUserSize(String uid) throws SQLException{
		String sql = "select memory from user where userid='"+uid+"'";
		ResultSet rs = DataConnection.getStat().executeQuery(sql);
		if(rs.next()){
			return rs.getString(1);
		}
		return "0";
	}
	
	/***
	 * 获取某个用户的总容量
	 * @param uid
	 * @return
	 * @throws SQLException
	 */
	public static String  getUserAllSize(String uid) throws SQLException{
		String sql = "select memory from user where userid='"+uid+"'";
		ResultSet rs = DataConnection.getStat().executeQuery(sql);
		if(rs.next()){
			return rs.getString(1);
		}
		return "0";
	}
	
	public static String  getImgUrl() throws SQLException{
		String sql = "select imgname from imgUrl";
		ResultSet rs = DataConnection.getStat().executeQuery(sql);
		if(rs.next()){
			return rs.getString(1);
		}
		return "0";
	}
	
	/***
	 * 更新广告
	 * @param imgname
	 * @throws SQLException
	 */
	public static void  setImgUrl(String imgname) throws SQLException{
		String sql = "update imgUrl set imgname='"+imgname+"'";
		Statement stmt=DataConnection.getCon().createStatement();
		stmt.executeUpdate(sql);
		
	}
	
}
