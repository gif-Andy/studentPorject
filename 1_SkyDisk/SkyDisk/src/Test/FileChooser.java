package Test;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class FileChooser extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	JButton open=null;
	public static void main(String[] args) {
		new FileChooser();
	}
	
	
	public FileChooser(){
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
		System.out.println(jfc.getSelectedFile());
		try {
			String target  = "F:\\Files.zip";
			String resource = file.getAbsolutePath();
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(target));
		
			//使用缓冲流
			BufferedOutputStream bufout = new BufferedOutputStream(out);
			ZipEntry ziptmp = new ZipEntry(jfc.getSelectedFile().getName());
			out.putNextEntry(ziptmp);
			if(file.isDirectory()){
				System.out.println("文件夹:"+file.getAbsolutePath());
				
			}else if(file.isFile()){
				System.out.println("文件:"+file.getAbsolutePath());
			}
			FileInputStream in = new FileInputStream(file);
			BufferedInputStream bufin = new BufferedInputStream(in);
			int b;
			while ((b=bufin.read())!=-1){
				bufout.write(b);
			}
			bufin.close();
			in.close();
			bufout.close();
			out.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}

