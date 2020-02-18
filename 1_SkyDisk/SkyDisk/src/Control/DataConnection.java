package Control;

import java.sql.*;

public class DataConnection {
	private static Statement stat = null;
	private static Connection con = null;
	public static void init() {
	
	
    
    
	try{
		Class.forName("com.mysql.jdbc.Driver") ;
		System.out.println("load ok");
		String url = "jdbc:mysql://127.0.0.1:3306/skydisk" ;    
		String username = "root" ;   
		String password = "humingshan";   
		con = DriverManager.getConnection(url , username , password );
		System.out.println("connnect ok");
		stat = con.createStatement();
		}catch(SQLException h)
		{
			System.out.println("MySQL操作错误");
			h.printStackTrace();
		}
		catch (Exception e) 
		{	
			e.printStackTrace();
		}
		
}
	public static Statement getStat() {
		if(stat==null)
			init();
		return stat;
	}
	
	public static Connection getCon() {
		if(con==null)
			init();
		return con;
	}
}
