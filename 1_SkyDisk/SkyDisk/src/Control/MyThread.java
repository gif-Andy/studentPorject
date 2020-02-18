package Control;



import com.ftp.Config;
import com.ftp.FtpUtil;



public class MyThread extends Thread{
	
	 

	public void run(String fileName,String newName) {
		FtpUtil fu = new FtpUtil(Config.FTP.HOST_IP, Config.FTP.HOST_PORT, Config.FTP.FTP_USERNAME, Config.FTP.FTP_PASSWD);
		fu.upload(fileName, newName);
		
	}
	
	
	
	public static void main(String[] args) {
	
	}

}
