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



public class MyRender_4 implements TableCellEditor, TableCellRenderer{
	Object[][]datas =null;
	JLabel deleteIcon;
	JTable table;
	TableModel tablemodel;
	JScrollPane jsl;
	public MyRender_4(JTable table,TableModel tablemodel,JScrollPane jsl) {
		this.table = table;
		this.tablemodel=tablemodel;
		this.jsl = jsl;
		deleteIcon = new JLabel();
		deleteIcon.setIcon(new ImageIcon(getClass().getResource("/imgs/delete.png")));
		deleteIcon.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				
				int n = MyRender_4.this.table.getSelectedRow();//获取当前行
				if(n!=-1){
					
					datas =File.convery(User.getUserid(),"");//删除前的datas
					String fid = String.valueOf(datas[n][6]);//获取文件id
					int res = JOptionPane.showConfirmDialog(null, "是否确认删除该课程", "是否继续", JOptionPane.YES_NO_OPTION); 
					if(res==JOptionPane.YES_OPTION){  //确认执行的函数		
						boolean isDelete;
					
						try {
							
							isDelete = File.deleteFile(fid);
							if(isDelete){
								 datas =File.convery(User.getUserid(),"");//删除后的datas
								 MyRender_4.this.tablemodel.setRowValues(datas);
								 MyRender_4.this.jsl.invalidate();
								JOptionPane.showMessageDialog(null, "删除成功");
							}
							
							
						} catch (SQLException e1) {
							e1.printStackTrace();
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
		return deleteIcon;
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
		return deleteIcon;
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
		return deleteIcon;
	}
	


}
