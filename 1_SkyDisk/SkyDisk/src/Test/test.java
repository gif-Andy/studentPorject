package Test;

import java.io.File;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFileChooser;
import javax.swing.JLabel;

public class test {
	public static void main(String[] args) {
		
		
		
		JFileChooser jfc=new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
		jfc.showDialog(new JLabel(), "Ñ¡Ôñ");
		File file=jfc.getSelectedFile();
		String fsizeString = String.valueOf(file.length());
		System.out.println(test.getFilesSize(fsizeString));
	}
	
	public static String getFilesSize(String fsize){
		String size = ""; 
	    long fileS = Long.valueOf(fsize);
	    System.out.println(fileS);
	      DecimalFormat df = new DecimalFormat("#.00"); 
	           if (fileS < 1024) {
	               size = df.format((double) fileS) + "B";
	           } else if (fileS < 1048576) {
	               size = df.format((double) fileS / 1024) + "KB";
	           } else if (fileS < 1073741824) {
	               size = df.format((double) fileS / 1048576) + "MB";
	           } else {
	               size = df.format((double) fileS / 1073741824) +"GB";
	           }
	    
	    return size;
	}
}
