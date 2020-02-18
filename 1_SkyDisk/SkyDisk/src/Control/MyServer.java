package Control;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;





public class MyServer {
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	
	/**
	 * @throws Exception 
	 */
	public MyServer() throws Exception{
		
		int port=3212;
		
		ServerSocket serverSocket = new ServerSocket(port);
		System.out.println("服务器创建中");
		int count=1;
		while(true){
			Socket socket = serverSocket.accept();
			System.out.println("第"+count+"个用户正在访问"+socket.getInetAddress());
			count++;
			ois = new ObjectInputStream (socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
			int command = ois.readInt();
			if(command ==1001){
				ulogin();
			}else {
				tlogin();
			}
		}
	}
	
	/***
	 * 获取用户的登录信息
	 * @throws Exception 
	 */
		public void ulogin() throws Exception{
			
			User u  = null;
			String name = ois.readUTF();
			String pw = ois.readUTF();
			//u = UserTest.Login(name, pw);
			u = ModelFactory.uLogin(name, pw);
			oos.writeObject(u);
			oos.flush();
		}
		
		public void tlogin() throws Exception{
			
	     Admin a  = null;
			String name = ois.readUTF();
			String pw = ois.readUTF();
			//u = UserTest.Login(name, pw);
			a = ModelFactory.alogin(name, pw);
			oos.writeObject(a);
			oos.flush();
		}
		
		public static void main(String[] args) throws Exception {
			try {
				new MyServer();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
	
}
