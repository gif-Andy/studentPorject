package Control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Notice {
	
	private String noticeid;
	private String noticefirst;
	private String noticesecond;
	private String noticethird;
	private static String nfirst;
	private static String nsecond;
	private static String nthird;
	public Notice(){}

	public Notice(String noticeid, String noticefirst, String noticesecond,
			String noticethird) {
		super();
		this.noticeid = noticeid;
		this.noticefirst = noticefirst;
		this.noticesecond = noticesecond;
		this.noticethird = noticethird;
	}

	public static String getNfirst() {
		return nfirst;
	}

	public static void setNfirst(String nfirst) {
		Notice.nfirst = nfirst;
	}

	public static String getNsecond() {
		return nsecond;
	}

	public static void setNsecond(String nsecond) {
		Notice.nsecond = nsecond;
	}

	public static String getNthird() {
		return nthird;
	}

	public static void setNthird(String nthird) {
		Notice.nthird = nthird;
	}

	public String getNoticeid() {
		return noticeid;
	}

	public void setNoticeid(String noticeid) {
		this.noticeid = noticeid;
	}

	public String getNoticefirst() {
		return noticefirst;
	}

	public void setNoticefirst(String noticefirst) {
		this.noticefirst = noticefirst;
	}

	public String getNoticesecond() {
		return noticesecond;
	}

	public void setNoticesecond(String noticesecond) {
		this.noticesecond = noticesecond;
	}

	public String getNoticethird() {
		return noticethird;
	}

	public void setNoticethird(String noticethird) {
		this.noticethird = noticethird;
	}
	
	
	public  ArrayList<Notice> getNoticeMessages(String searchTxt) throws SQLException, ClassNotFoundException {
		ArrayList<Notice> NoticeList = new ArrayList<Notice>(); 
		String sql = "select * from notice where noticefirst like  '%" +searchTxt+"%'" ;
		ResultSet rs = DataConnection.getStat().executeQuery(sql);
		Notice notice;
		while (rs.next()) {
			notice = new Notice();
			notice.setNoticeid(rs.getInt(1)+"");
			notice.setNoticefirst(rs.getString(2));
			notice.setNoticesecond(rs.getString(3));
			notice.setNoticethird(rs.getString(4));
			NoticeList.add(notice);
		}

		return NoticeList;
	}
	
	public static Object[][] Noticeconvery(String searchTxt){
		Notice notice= new Notice();
		Object datas[][] = null ;
		ArrayList<Notice> List = new ArrayList<Notice>(); 
		try {
			List = notice.getNoticeMessages(searchTxt);
			
			datas = new Object[List.size()][6];  
			for(int i=0;i<List.size();i++){
				Notice data = List.get(i);
				datas[i][0] = data.getNoticeid();
				datas[i][1] = data.getNoticefirst();
				datas[i][2] = data.getNoticesecond();
				datas[i][3] = data.getNoticethird();
				datas[i][4] = 0;
				datas[i][5] = 0;
			
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

	
	public static void  setNotice(String first,String second,String third) throws SQLException{
		String sql = "update imgUrl set noticefirst='"+first+"' , noticesecond='"+second+"' ,noticethird='"+third+"'";
		Statement stmt=DataConnection.getCon().createStatement();
		stmt.executeUpdate(sql);
		
	}
	
	public static void  getNotice() throws SQLException{
		String sql = "select  noticefirst,noticesecond,noticethird from imgUrl";
		ResultSet rs = DataConnection.getStat().executeQuery(sql);
	
		if(rs.next()){
			Notice.setNfirst(rs.getString(1));
			Notice.setNsecond(rs.getString(2));
			Notice.setNthird(rs.getString(3));
			
		}
		
	}
	

}
