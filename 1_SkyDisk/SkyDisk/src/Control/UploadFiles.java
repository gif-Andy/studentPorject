package Control;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


public class UploadFiles {
	
	public static void eventOnImport(JButton uploadBtn) {
		JFileChooser chooser = new JFileChooser();
		chooser.setMultiSelectionEnabled(true);
		/** 过滤文件类型 * */
		FileNameExtensionFilter filter = new FileNameExtensionFilter("xml","xls","txt");
		chooser.setFileFilter(filter);
		if (chooser.showOpenDialog(uploadBtn) == JFileChooser.APPROVE_OPTION) {
			/** 得到选择的文件* */
			File[] arrfiles = chooser.getSelectedFiles();
			if (arrfiles == null || arrfiles.length == 0) {
				return;
			}
			FileInputStream input = null;
			FileOutputStream out = null;
			String path = "./files";
			try {
				for (File f : arrfiles) {
					File dir = new File(path);
					/** 目标文件夹 * */
					File[] fs = dir.listFiles();
					HashSet<String> set = new HashSet<String>();
					for (File file : fs) {
						set.add(file.getName());
					}
					/** 判断是否已有该文件* */
					if (set.contains(f.getName())) {
						JOptionPane.showMessageDialog(new JDialog(), "已有该文件！");
						return;
					}
					input = new FileInputStream(f);
					byte[] buffer = new byte[1024];
					File des = new File(path, f.getName());
					out = new FileOutputStream(des);
					int len = 0;
					while (-1 != (len = input.read(buffer))) {
						out.write(buffer, 0, len);
					}
					out.close();
					input.close();
				}
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}

