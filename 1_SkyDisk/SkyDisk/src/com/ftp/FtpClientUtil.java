package com.ftp;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import sun.net.TelnetInputStream;
import sun.net.TelnetOutputStream;
import sun.net.ftp.FtpClient;

public class FtpClientUtil {
 FtpClient ftpClient;
 private String server;
 private int port;
 private String userName;
 private String userPassword;
 
 public FtpClientUtil(String server,int port,String userName,String userPassword)
 {
  this.server=server;
  this.port=port;
  this.userName=userName;
  this.userPassword=userPassword;
 }
 /**
  * 链接到服务器
  * @return
  */
 public boolean open()
 {
  if(ftpClient!=null&&ftpClient.serverIsOpen())
   return true;
  try
  {
      ftpClient= new FtpClient();
      ftpClient.openServer(server,port);
      ftpClient.login(userName, userPassword);
      ftpClient.binary();
      return true;
  }
  catch(Exception e)
  {
   e.printStackTrace();
   ftpClient=null;
   return false;
  }
 }
 
 public boolean cd(String dir){
  boolean f = false;
  try {
   ftpClient.cd(dir);
  } catch (IOException e) {
   
   return f;
  }
  return true;
 }
 
 /**
  * 上传文件到FTP服务器
  * @param localPathAndFileName 本地文件目录和文件名
  * @param ftpFileName  上传后的文件名
  * @param ftpDirectory FTP目录如:/path1/pathb2/,如果目录不存在回自动创建目录
  * @throws Exception
  */
 public boolean upload(String localDirectoryAndFileName,String ftpFileName,String ftpDirectory)throws Exception {
	  if(!open())
		  return false;
	  FileInputStream is=null;
	  TelnetOutputStream os=null;
	  try
	  {
		   char ch = ' ';
		   if (ftpDirectory.length() > 0)
			   ch = ftpDirectory.charAt(ftpDirectory.length() - 1);
		   for (; ch == '/' || ch == '\\'; ch = ftpDirectory.charAt(ftpDirectory.length() - 1))
			   ftpDirectory = ftpDirectory.substring(0, ftpDirectory.length() - 1);
		 
		   int slashIndex = ftpDirectory.indexOf(47);
		   int backslashIndex = ftpDirectory.indexOf(92);
		   int index = slashIndex;
		   String dirall = ftpDirectory;
		   
		   if (backslashIndex != -1 && (index == -1 || index > backslashIndex))
			   index = backslashIndex;
		   
		   String directory = "";
		   while (index != -1) {
			    if (index > 0) {
				     String dir = dirall.substring(0, index);
				     directory = directory + "/" + dir;
				     ftpClient.sendServer("XMKD " + directory + "\r\n");
				     ftpClient.readServerResponse();
			    }
			    dirall = dirall.substring(index + 1);
			    slashIndex = dirall.indexOf(47);
			    backslashIndex = dirall.indexOf(92);
			    index = slashIndex;
			    if (backslashIndex != -1 && (index == -1 || index > backslashIndex))
			    	index = backslashIndex;
		   }
		   ftpClient.sendServer("XMKD " + ftpDirectory + "\r\n");
		   ftpClient.readServerResponse();
		 
		   os = ftpClient.put(ftpDirectory + "/"
		     + ftpFileName);
		   File file_in = new File(localDirectoryAndFileName);
		   is = new FileInputStream(file_in);
		   byte bytes[] = new byte[1024];
		   int i;
		   while ((i = is.read(bytes)) != -1)
		    os.write(bytes, 0, i);
		   //清理垃圾
		return true;
		 }
		  catch(Exception e)
		  {
		   e.printStackTrace();
		   return false;
		  }
		  finally
		  {
		   if (is != null) 
		      is.close();
		   if (os != null) 
		      os.close();
		  }
 }
 /**
  * 从FTP服务器上下载文件并返回下载文件长度
  * @param ftpDirectoryAndFileName
  * @param localDirectoryAndFileName
  * @return
  * @throws Exception
  */
 public long download(String ftpDirectoryAndFileName,String localDirectoryAndFileName)throws Exception 
 {
  long result = 0; 
  if(!open())
   return result;
  TelnetInputStream is = null; 
  FileOutputStream os = null;
  try  
  { 
        is = ftpClient.get(ftpDirectoryAndFileName);        
        java.io.File outfile = new java.io.File(localDirectoryAndFileName); 
        os = new FileOutputStream(outfile); 
        byte[] bytes = new byte[1024]; 
        int c; 
        while ((c = is.read(bytes)) != -1) 
        { 
            os.write(bytes, 0, c); 
            result = result + c; 
        } 
     }
  catch (Exception e)  
  { 
         throw e;
  } 
  finally 
  { 
      if (is != null) 
        is.close();
      if (os != null) 
        os.close();
      
   }
      return result; 
 } 
 /**
  * 返回FTP目录下的文件列表
  * @param ftpDirectory
  * @return
  */
  public List<String> getFileNameList(String ftpDirectory) 
  { 
     List<String> list = new ArrayList<String>(); 
     if(!open())
   return list;
     try  
     { 
        DataInputStream dis = new  DataInputStream(ftpClient.nameList(ftpDirectory)); 
        String filename = ""; 
        while((filename=dis.readLine())!=null)   
        {
          list.add(filename);         
        }   
     } catch (Exception e)  
     { 
        e.printStackTrace(); 
     } 
     return list; 
  }
  /**
   * 删除FTP上的文件
   * @param ftpDirAndFileName
   */
  public boolean deleteFile(String ftpDirAndFileName)
  {
   if(!open())
   return false;
   ftpClient.sendServer("DELE "+ftpDirAndFileName+"\r\n");
   return true;
  }
  /**
   * 删除FTP目录
   * @param ftpDirectory
   */
  public boolean deleteDirectory(String ftpDirectory)
  {
   if(!open())
   return false;
   ftpClient.sendServer("XRMD "+ftpDirectory+"\r\n");
   return true;
  }
  /**
   * 关闭链接
   */
  public void close()
  {
   try
   {
       if(ftpClient!=null&&ftpClient.serverIsOpen())
        ftpClient.closeServer();
   }catch(Exception e)
   {
    
   }
  }
  public static void main(String[] args) throws Exception {
	FtpClientUtil f= new FtpClientUtil("ftp.sinacloud.com", 21, "onzkymo2zy", "52zm02l0422w2hll14m54105jw02hl0j23mx55kh");
	f.open(); 
	//f.deleteFile("/tmp/happy/test.txt");
	//System.out.println(f.download("/tmp/happy/test.txt", "D:/Temp/骑士.txt"));
	f.upload("C:/Users/as/Desktop/中国.txt", "中国.txt", "/tmp/happy");
	f.close();
  }
  
  
  
  
  
  
  
  
  
}