package Control;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;


public class MyClient {
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	
	public MyClient() throws UnknownHostException, IOException{
		String ip = "10.12.5.173";
		int port = 3212;
		Socket socket  = new Socket(ip,port);
		oos = new ObjectOutputStream(socket.getOutputStream());
		ois = new ObjectInputStream(socket.getInputStream());
	}
	
	/***
	 * 用户输入登录信息
	 */
	public User login(String name ,String pw) throws IOException, ClassNotFoundException{
		oos.writeInt(1001);
		oos.flush();
		oos.writeUTF(name);
		oos.flush();
		oos.writeUTF(pw);
		oos.flush();
		User u = (User) ois.readObject();
		return u;
	}
	
	public static void main(String[] args) {
		try {
			new MyClient();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
