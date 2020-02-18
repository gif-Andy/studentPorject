package Control;

import javax.swing.table.AbstractTableModel;

public class ShareTableModel extends AbstractTableModel{
	Object[][] datas = null;
	Object[] title = {"用户名","文件名","文件大小","文件类型","修改时间","下载"};
	
	public ShareTableModel(String shareTxt){
		datas = File.shareConvery(shareTxt);
	}

	@Override
	public int getColumnCount() {
		
		return title.length;
	}

	@Override
	public int getRowCount() {
	
		return datas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		return datas[rowIndex][columnIndex];
	}
	  

	public String getColumnName(int col) {
        return (String) title[col];
    }

      @Override
      public boolean isCellEditable(int rowIndex, int columnIndex) {
          if(columnIndex==0&&columnIndex==1&&columnIndex==2&&columnIndex==3)
              return false;//第几列不可以点击
		return true;
    	 	
      }

      @Override
      public void setValueAt(Object value, int row, int col) {
          datas[row][col] = value;
          fireTableCellUpdated(row, col);
      }

      public void mySetValueAt(Object value, int row, int col) {
          datas[row][col] = value;
      }
      
      public void setRowValues(Object[][] datas) {
          this.datas = datas;
          fireTableDataChanged();
      }
      
}
