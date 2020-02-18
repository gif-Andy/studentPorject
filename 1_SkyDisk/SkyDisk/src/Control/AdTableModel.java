package Control;

import javax.swing.table.AbstractTableModel;

public class AdTableModel extends AbstractTableModel{
	Object[] title = {"广告ID","广告负责人", "广告公司", "联系电话", "电子邮箱", "广告名字", "广告地址","删除","应用"};
	Object [][] datas;
	
	public AdTableModel(String text){
		datas = Ad.Adconvery(text);
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
