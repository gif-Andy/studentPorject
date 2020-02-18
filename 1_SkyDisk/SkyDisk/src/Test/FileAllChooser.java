package Test;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class FileAllChooser extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	JButton open=null;
	public static void main(String[] args) {
		new FileAllChooser();
	}
	
	
	public FileAllChooser(){
		open=new JButton("open");
		this.add(open);
		this.setBounds(400, 200, 100, 100);
		this.setSize(500,500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		open.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//String target = "F:\Files";
		// TODO Auto-generated method stub
		JFileChooser jfc=new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
		jfc.showDialog(new JLabel(), "选择");
		File file=jfc.getSelectedFile();
		String fileName = file.getName();
		String diskName ="";
		if(file.isDirectory()){
			diskName = fileName;
			
		}else if(file.isFile()){
			diskName =fileName.substring(0,fileName.lastIndexOf("."));
		}
	
		try {
			
			String target  = "G:\\SkyDisk\\"+diskName+".zip";
			String resource = file.getAbsolutePath();
			
			long start = System.currentTimeMillis();
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(target));
		
			//使用缓冲流
			BufferedOutputStream bufout = new BufferedOutputStream(out);
			//ZipEntry ziptmp = new ZipEntry(jfc.getSelectedFile().getName());
			//out.putNextEntry(ziptmp);
			if(file.isDirectory()){
				System.out.println("文件夹:"+file.getAbsolutePath());
				
			}else if(file.isFile()){
				System.out.println("文件:"+file.getAbsolutePath());
			}
			FileAllChooser.zip(out, file, file.getName(), bufout);
			bufout.close();
			out.close();
			long end = System.currentTimeMillis();
			
			System.out.println("压缩结束,时间为:"+(end-start)+"毫秒");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	public static void zip(ZipOutputStream zipOut, File file,String base,BufferedOutputStream bufout) throws IOException{
		if(file.isDirectory()){
			File[] childFiles = file.listFiles();
			if(childFiles.length==0){
				zipOut.putNextEntry(new ZipEntry(file.getName()));
			}
			//遍历子文件列表
			for(int i=0;i<childFiles.length;i++){
				zip(zipOut, childFiles[i], base+"/"+childFiles[i].getName(), bufout);
			}
		}else {
			zipOut.putNextEntry(new ZipEntry(base));
			System.out.println("压缩"+file.getAbsolutePath()+"文件");
			FileInputStream in = new FileInputStream(file);
			BufferedInputStream bufin = new BufferedInputStream(in);
			int b;
			while ((b=bufin.read())!=-1){
				bufout.write(b);
			}
			System.out.println("结束");
			bufin.close();
			in.close();
			bufout.flush();
			zipOut.flush();
		}
	}

}

