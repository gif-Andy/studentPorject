package Control;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EventObject;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import com.ftp.Config;
import com.ftp.FtpClientUtil;

public class MyRender_5 implements TableCellEditor, TableCellRenderer{
	
	JLabel downloadIcon;
	JTable table;
	public MyRender_5(JTable table) {
		this.table = table;
		downloadIcon = new JLabel();
		downloadIcon.setIcon(new ImageIcon(getClass().getResource("/imgs/download.png")));
		downloadIcon.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				String filename;
				Object[][]datas =File.shareConvery("");
				int n = MyRender_5.this.table.getSelectedRow();//获取当前行
				if(n!=1){
					String fname = String.valueOf(datas[n][1]);//获取文件名字
					String ftype = String.valueOf(datas[n][3]);//获取文件类型
					if(ftype.equals("Directory")){
						filename = fname;
					}else {
						filename = fname+"."+ftype;
					}
					try {
						boolean ifDownload = ModelFactory.download(filename,"public");
						if(ifDownload){
							JOptionPane.showMessageDialog(null, "下载成功");
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "下载失败");
						e1.printStackTrace();
					}
				}
				
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			
		});
	}

	
	@Override
	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {
		// TODO Auto-generated method stub
		return downloadIcon;
	}

	@Override
	public void addCellEditorListener(CellEditorListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelCellEditing() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		return downloadIcon;
	}
	
	@Override
	public boolean isCellEditable(EventObject anEvent) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void removeCellEditorListener(CellEditorListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean shouldSelectCell(EventObject anEvent) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean stopCellEditing() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		// TODO Auto-generated method stub
		return downloadIcon;
	}
	

}
