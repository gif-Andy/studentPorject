package Control;

import java.awt.Component;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.EventObject;


import javax.swing.ImageIcon;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import javax.swing.JTable;
import javax.swing.event.CellEditorListener;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;



public class SelectRender_4 implements TableCellEditor, TableCellRenderer{
	Object[][]datas =null;
	JLabel selectIcon;
	JTable table;

	public SelectRender_4(JTable table) {
		this.table = table;
		
		selectIcon = new JLabel();
		selectIcon.setIcon(new ImageIcon(getClass().getResource("/imgs/select-icon.png")));
		selectIcon.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				
				int n = SelectRender_4.this.table.getSelectedRow();//获取当前行
				if(n!=-1){
					
					datas =Notice.Noticeconvery("");//删除前的datas
				
					String nfitst = String.valueOf(datas[n][1]);//获取广告id
					String nsecond = String.valueOf(datas[n][2]);//获取广告id
					String nthird = String.valueOf(datas[n][3]);//获取广告id
					int res = JOptionPane.showConfirmDialog(null, "是否确认应用公告", "是否继续", JOptionPane.YES_NO_OPTION); 
					if(res==JOptionPane.YES_OPTION){  //确认执行的函数		
						try {
							Notice.setNotice(nfitst, nsecond, nthird);
							JOptionPane.showMessageDialog(null, "应用公告成功");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							JOptionPane.showMessageDialog(null, "应用公告失败");
						}
						
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
				
			}});
	}

	


	@Override
	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {
		// TODO Auto-generated method stub
		return selectIcon;
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
		return selectIcon;
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
		return selectIcon;
	}
	


}
