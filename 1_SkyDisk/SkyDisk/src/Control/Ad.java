package Control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Ad {
	private String adid;
	private String adowner;
	private String adcompany;
	private String adphone;
	private String ademail;
	private String adname;
	private String adurl;
	public static String imgUrl  ;


	public Ad(){}
	
	public Ad(String imgUrl){
		Ad.imgUrl = imgUrl;
		
	}

	
	public Ad(String adid, String adowner, String adcompany, String adphone,
			String ademail, String adname, String adurl) {
		super();
		this.adid = adid;
		this.adowner = adowner;
		this.adcompany = adcompany;
		this.adphone = adphone;
		this.ademail = ademail;
		this.adname = adname;
		this.adurl = adurl;
	}

	
	
	public static String getImgUrl() {
		return imgUrl;
	}

	public static void setImgUrl(String imgUrl) {
		Ad.imgUrl = imgUrl;
	}

	public String getAdid() {
		return adid;
	}

	public void setAdid(String adid) {
		this.adid = adid;
	}

	public String getAdowner() {
		return adowner;
	}

	public void setAdowner(String adowner) {
		this.adowner = adowner;
	}

	public String getAdcompany() {
		return adcompany;
	}

	public void setAdcompany(String adcompany) {
		this.adcompany = adcompany;
	}

	public String getAdphone() {
		return adphone;
	}

	public void setAdphone(String adphone) {
		this.adphone = adphone;
	}

	public String getAdemail() {
		return ademail;
	}

	public void setAdemail(String ademail) {
		this.ademail = ademail;
	}

	public String getAdname() {
		return adname;
	}

	public void setAdname(String adname) {
		this.adname = adname;
	}

	public String getAdurl() {
		return adurl;
	}

	public void setAdurl(String adurl) {
		this.adurl = adurl;
	}
	
	
	/***
	 * 获取广告信息
	 * @param searchTxt
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public  ArrayList<Ad> getAdMessages(String searchTxt) throws SQLException, ClassNotFoundException {
		ArrayList<Ad> UsersList = new ArrayList<Ad>(); 
		String sql = "select * from ad where adname like  '%" +searchTxt+"%'" ;
		ResultSet rs = DataConnection.getStat().executeQuery(sql);
		Ad ad;
		while (rs.next()) {
			ad = new Ad();
			ad.setAdid(rs.getInt(1)+"");
			ad.setAdowner(rs.getString(2));
			ad.setAdcompany(rs.getString(3));
			ad.setAdphone(rs.getString(4));
			ad.setAdemail(rs.getString(5));
			ad.setAdname(rs.getString(6));
			ad.setAdurl(rs.getString(7));
			UsersList.add(ad);
		}

		return UsersList;
	}
	
	
	
	
	/***
	 * 广告信息转化为二维数组
	 * @param searchTxt
	 * @return
	 */
	public static Object[][] Adconvery(String searchTxt){
		Ad ad= new Ad();
		Object datas[][] = null ;
		ArrayList<Ad> List = new ArrayList<Ad>(); 
		try {
			List = ad.getAdMessages(searchTxt);
			
			datas = new Object[List.size()][9];  
			for(int i=0;i<List.size();i++){
				Ad data = List.get(i);
				datas[i][0] = data.getAdid();
				datas[i][1] = data.getAdowner();
				datas[i][2] = data.getAdcompany();
				datas[i][3] = data.getAdphone();
				datas[i][4] = data.getAdemail();
				datas[i][5] = data.getAdname();
				datas[i][6] = data.getAdurl();
				datas[i][7] = 0;
				datas[i][8] = 0;
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


	

}
