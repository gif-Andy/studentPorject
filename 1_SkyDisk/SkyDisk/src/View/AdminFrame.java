/*
 * AdminFrame.java

 *
 * Created on __DATE__, __TIME__
 */

package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Control.Ad;
import Control.AdTableModel;
import Control.Admin;
import Control.DeteleRender;
import Control.DeteleRender_2;
import Control.DeteleRender_3;
import Control.DeteleRender_4;
import Control.File;
import Control.FilesTableModel;
import Control.FontControl;
import Control.ModelFactory;
import Control.MyRender_4;
import Control.NoticeTableModel;
import Control.SelectRender_3;
import Control.SelectRender_4;
import Control.User;
import Control.UserTableModel;

/**
 * 
 * @author __USER__
 */
public class AdminFrame extends javax.swing.JFrame {

	String adminid = Admin.getAdminid();
	FilesTableModel ftm;
	UserTableModel utm;
	AdTableModel atm;
	NoticeTableModel ntm;
	Object[][] datas = null;


	/** Creates new form AdminFrame */
	public AdminFrame() {
		Image icon = Toolkit.getDefaultToolkit().getImage("imgs//icon.jpg");
		initComponents();
		this.setTitle("SkyDisk网盘后台管理");
		this.setVisible(true);
		//this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(icon);
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
		

		jPanel1 = new javax.swing.JPanel();
		jTabbedPane1 = new javax.swing.JTabbedPane();
		jPanel2 = new javax.swing.JPanel();
		jTextField4 = new javax.swing.JTextField();
		jButton12 = new javax.swing.JButton();
		jLabel10 = new javax.swing.JLabel();
		jScrollPane4 = new javax.swing.JScrollPane();
		jTable4 = new javax.swing.JTable();
		jLabel1 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel11 = new javax.swing.JLabel();
		jLabel14 = new javax.swing.JLabel();
		jLabel15 = new javax.swing.JLabel();
		jLabel16 = new javax.swing.JLabel();
		jLabel17 = new javax.swing.JLabel();
		jPanel3 = new javax.swing.JPanel();
		jButton7 = new javax.swing.JButton();
		jTextField2 = new javax.swing.JTextField();
		jButton8 = new javax.swing.JButton();
		jLabel4 = new javax.swing.JLabel();
		jScrollPane2 = new javax.swing.JScrollPane();
		jTable2 = new javax.swing.JTable();
		jLabel6 = new javax.swing.JLabel();
		jLabel18 = new javax.swing.JLabel();
		jPanel4 = new javax.swing.JPanel();
		jLabel7 = new javax.swing.JLabel();
		jScrollPane3 = new javax.swing.JScrollPane();
		jTable3 = new javax.swing.JTable();
		jLabel9 = new javax.swing.JLabel();
		jButton9 = new javax.swing.JButton();
		jTextField3 = new javax.swing.JTextField();
		jButton10 = new javax.swing.JButton();
		jLabel19 = new javax.swing.JLabel();
		jPanel5 = new javax.swing.JPanel();
		jTabbedPane2 = new javax.swing.JTabbedPane();
		jPanel6 = new javax.swing.JPanel();
		jTextField5 = new javax.swing.JTextField();
		jButton13 = new javax.swing.JButton();
		jScrollPane5 = new javax.swing.JScrollPane();
		jTable5 = new javax.swing.JTable();
		jPanel7 = new javax.swing.JPanel();
		jLabel5 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jTextField6 = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();
		jPanel8 = new javax.swing.JPanel();
		jScrollPane6 = new javax.swing.JScrollPane();
		jTable6 = new javax.swing.JTable();
		jLabel13 = new javax.swing.JLabel();
		jButton14 = new javax.swing.JButton();
		jTextField7 = new javax.swing.JTextField();
		jButton15 = new javax.swing.JButton();
		jTextField9 = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		imageJpanel1 = new View.ImageJpanel();
		imageJpanel2 = new View.ImageJpanel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jTextField4.setText("搜索文件");
		jTextField4.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				if(jTextField4.getText().equals("搜索文件")){
					jTextField4.setText("");
				}
			}
			public void focusLost(java.awt.event.FocusEvent evt) {
				if(jTextField4.getText().equals("")){
					jTextField4.setText("搜索文件");
				}
			}
		});
		

		jButton12.setText("\u641c\u7d22");
		jButton12.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton12ActionPerformed(evt);
			}
		});

		jLabel10.setText("\u5df2\u6709\u6587\u4ef6\u6570\uff1a");

		ftm = new FilesTableModel("");
		jTable4.setRowHeight(30);
		jTable4 = new javax.swing.JTable(ftm);
		jTable4.getColumn("删除").setCellEditor(new DeteleRender_2(jTable4,ftm,jScrollPane4));
		jTable4.getColumn("删除").setCellRenderer(new DeteleRender_2(jTable4,ftm,jScrollPane4));

		jScrollPane4.setViewportView(jTable4);

		try {
			jLabel1.setText(Admin.getAllFiles()+"");
			jLabel18.setText(Admin.getAllUser()+"");
			/*已记录广告数量*/
			jLabel19.setText(Admin.getAllAd()+"");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		jLabel3.setText("\u6587\u6863\u7c7b\uff1a");

		try {
			jLabel11.setText(Admin.getAllDocument()+"");
			jLabel15.setText(Admin.getAllAudio()+"");
			jLabel17.setText(Admin.getAllOther()+"");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		jLabel14.setText("\u89c6\u9891\u7c7b\uff1a");

	
		jLabel16.setText("\u5176\u5b83\u7c7b\uff1a");

	
		

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout
				.setHorizontalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addGap(25, 25, 25)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addGroup(
																jPanel2Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel10)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabel1)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				490,
																				Short.MAX_VALUE))
														.addGroup(
																jPanel2Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel3)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabel11)
																		.addGap(
																				26,
																				26,
																				26)
																		.addComponent(
																				jLabel14)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				jLabel15)
																		.addGap(
																				24,
																				24,
																				24)
																		.addComponent(
																				jLabel16)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				jLabel17)
																		.addGap(
																				102,
																				102,
																				102)
																		.addComponent(
																				jTextField4,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				139,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
										.addGap(18, 18, 18).addComponent(
												jButton12).addGap(57, 57, 57))
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addComponent(
												jScrollPane4,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												755, Short.MAX_VALUE)
										.addContainerGap()));
		jPanel2Layout
				.setVerticalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel2Layout
										.createSequentialGroup()
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addGroup(
																jPanel2Layout
																		.createSequentialGroup()
																		.addGap(
																				29,
																				29,
																				29)
																		.addGroup(
																				jPanel2Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								jLabel10,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								jLabel1))
																		.addGap(
																				7,
																				7,
																				7)
																		.addGroup(
																				jPanel2Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								jLabel3)
																						.addComponent(
																								jLabel11)
																						.addComponent(
																								jLabel15)
																						.addComponent(
																								jLabel17)
																						.addComponent(
																								jLabel14)
																						.addComponent(
																								jLabel16)))
														.addGroup(
																jPanel2Layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addGroup(
																				jPanel2Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								jButton12,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								jTextField4,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE))))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jScrollPane4,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												406,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(77, 77, 77)));

		jTabbedPane1.addTab("\u6587\u4ef6\u7ba1\u7406", jPanel2);

		jButton7.setText("+\u6dfb\u52a0");
		jButton7.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton7ActionPerformed(evt);
			}

			
		});

		jTextField2.setText("搜索用户");
		jTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				if(jTextField2.getText().equals("搜索用户")){
					jTextField2.setText("");
				}
			}
			public void focusLost(java.awt.event.FocusEvent evt) {
				if(jTextField2.getText().equals("")){
					jTextField2.setText("搜索用户");
				}
			}
		});
		jButton8.setText("\u641c\u7d22");
		jButton8.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton8ActionPerformed(evt);
			}

			
		});

		jLabel4.setText("\u5df2\u6709\u7528\u6237\u6570\uff1a");

	
		utm = new UserTableModel("");

		jTable2.setRowHeight(30);
		jTable2 = new javax.swing.JTable(utm);
		jTable2.getColumn("删除").setCellEditor(new DeteleRender(jTable2,utm,jScrollPane2));
		jTable2.getColumn("删除").setCellRenderer(new DeteleRender(jTable2,utm,jScrollPane2));
		jScrollPane2.setViewportView(jTable2);

		jLabel6.setText("\u5220\u9664\u7528\u6237");

			//int allUser = Admin.getAllUser();
		
		
	

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(
				jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout
				.setHorizontalGroup(jPanel3Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel3Layout
										.createSequentialGroup()
										.addGap(58, 58, 58)
										.addComponent(
												jButton7,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												85,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(161, 161, 161)
										.addComponent(
												jTextField2,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												139,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(1, 1, 1)
										.addComponent(jButton8)
										.addGap(89, 89, 89)
										.addComponent(jLabel4)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(jLabel18)
										.addContainerGap(33, Short.MAX_VALUE))
						.addComponent(jScrollPane2,
								javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, 755,
								Short.MAX_VALUE).addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel3Layout.createSequentialGroup()
										.addContainerGap(695, Short.MAX_VALUE)
										.addComponent(jLabel6)
										.addContainerGap()));
		jPanel3Layout
				.setVerticalGroup(jPanel3Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel3Layout
										.createSequentialGroup()
										.addContainerGap(67, Short.MAX_VALUE)
										.addGroup(
												jPanel3Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																false)
														.addComponent(
																jTextField2,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																30,
																Short.MAX_VALUE)
														.addComponent(
																jButton7,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																30,
																Short.MAX_VALUE)
														.addGroup(
																jPanel3Layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(
																				jButton8,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				jLabel4,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				jLabel18)))
										.addGap(32, 32, 32)
										.addComponent(
												jScrollPane2,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												406,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(9, 9, 9).addComponent(jLabel6)));

		jTabbedPane1.addTab("\u7528\u6237\u7ba1\u7406", jPanel3);

		jLabel7.setText("\u5220\u9664\u5e7f\u544a");
		
		atm = new AdTableModel("");
		jTable3.setRowHeight(30);
		jTable3 = new javax.swing.JTable(atm);
		jTable3.getColumn("删除").setCellEditor(new DeteleRender_3(jTable3,atm,jScrollPane3));
		jTable3.getColumn("删除").setCellRenderer(new DeteleRender_3(jTable3,atm,jScrollPane3));
		jTable3.getColumn("应用").setCellEditor(new SelectRender_3(jTable3));
		jTable3.getColumn("应用").setCellRenderer(new SelectRender_3(jTable3));
		jScrollPane3.setViewportView(jTable3);

		jLabel9.setText("\u5df2\u6709\u5e7f\u544a\u6570\uff1a");

		/*广告搜索*/
		jButton9.setText("搜索");
		jButton9.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton9ActionPerformed(evt);
			}
		});
		
		/*搜索广告文本框*/
		jTextField3.setText("搜索广告名字");
		jTextField3.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				if(jTextField3.getText().equals("搜索广告名字")){
					jTextField3.setText("");
				}
			}
			public void focusLost(java.awt.event.FocusEvent evt) {
				if(jTextField3.getText().equals("")){
					jTextField3.setText("搜索广告名字");
				}
			}
		});

		/*添加广告按钮*/
		jButton10.setText("+\u6dfb\u52a0");
		jButton10.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton10ActionPerformed(evt);
			}

			
		});
		/*已记录广告数量*/
		//jLabel19.setText(Admin.getAllAd());

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(
				jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel4Layout.createSequentialGroup().addGap(58, 58, 58)
						.addComponent(jButton10,
								javax.swing.GroupLayout.PREFERRED_SIZE, 85,
								javax.swing.GroupLayout.PREFERRED_SIZE).addGap(
								161, 161, 161).addComponent(jTextField3,
								javax.swing.GroupLayout.PREFERRED_SIZE, 139,
								javax.swing.GroupLayout.PREFERRED_SIZE).addGap(
								1, 1, 1).addComponent(jButton9).addGap(75, 75,
								75).addComponent(jLabel9).addGap(18, 18, 18)
						.addComponent(jLabel19).addContainerGap(41,
								Short.MAX_VALUE)).addComponent(jScrollPane3,
				javax.swing.GroupLayout.Alignment.TRAILING,
				javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel4Layout.createSequentialGroup().addContainerGap(
								695, Short.MAX_VALUE).addComponent(jLabel7)
								.addContainerGap()));
		jPanel4Layout
				.setVerticalGroup(jPanel4Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel4Layout
										.createSequentialGroup()
										.addContainerGap(67, Short.MAX_VALUE)
										.addGroup(
												jPanel4Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																false)
														.addGroup(
																jPanel4Layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(
																				jButton9,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				jLabel9,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				jLabel19))
														.addComponent(
																jTextField3,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																30,
																Short.MAX_VALUE)
														.addComponent(
																jButton10,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																30,
																Short.MAX_VALUE))
										.addGap(32, 32, 32)
										.addComponent(
												jScrollPane3,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												406,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(9, 9, 9).addComponent(jLabel7)));

		jTabbedPane1.addTab("\u5e7f\u544a\u7ba1\u7406", jPanel4);

		jTextField5.setText("\u641c\u7d22\u5df2\u53d1\u5e03\u7684\u516c\u544a");

		jButton13.setText("\u641c\u7d22");

		ntm = new NoticeTableModel("");
		jTable5.setRowHeight(30);
		jTable5 = new javax.swing.JTable(ntm);
		jTable5.getColumn("删除").setCellEditor(new DeteleRender_4(jTable5,ntm,jScrollPane5));
		jTable5.getColumn("删除").setCellRenderer(new DeteleRender_4(jTable5,ntm,jScrollPane5));
		jTable5.getColumn("应用").setCellEditor(new SelectRender_4(jTable5));
		jTable5.getColumn("应用").setCellRenderer(new SelectRender_4(jTable5));
	
		
		jScrollPane5.setViewportView(jTable5);

		javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(
				jPanel6);
		jPanel6.setLayout(jPanel6Layout);
		jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel6Layout.createSequentialGroup().addContainerGap(514,
						Short.MAX_VALUE).addComponent(jTextField5,
						javax.swing.GroupLayout.PREFERRED_SIZE, 139,
						javax.swing.GroupLayout.PREFERRED_SIZE).addGap(28, 28,
						28).addComponent(jButton13).addContainerGap())
				.addComponent(jScrollPane5,
						javax.swing.GroupLayout.Alignment.TRAILING,
						javax.swing.GroupLayout.DEFAULT_SIZE, 750,
						Short.MAX_VALUE));
		jPanel6Layout
				.setVerticalGroup(jPanel6Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel6Layout
										.createSequentialGroup()
										.addGap(33, 33, 33)
										.addGroup(
												jPanel6Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jButton13,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																35,
																Short.MAX_VALUE)
														.addComponent(
																jTextField5,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																31,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(33, 33, 33)
										.addComponent(
												jScrollPane5,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												415,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap()));

		jTabbedPane2.addTab("\u66f4\u6539\u65b0\u516c\u544a", jPanel6);

		jLabel5.setText("   \u7528\u6237ID");

		jLabel8.setText("\u4e91\u76d8\u5b58\u50a8\u91cf");

		jTextField1.setText("\u8f93\u5165\u7528\u6237ID");
		jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				if(jTextField1.getText().equals("\u8f93\u5165\u7528\u6237ID")){
					jTextField1.setText("");
				}
			}
			public void focusLost(java.awt.event.FocusEvent evt) {
				if(jTextField1.getText().equals("")){
					jTextField1.setText("\u8f93\u5165\u7528\u6237ID");
				}
			}
		});

		jTextField6
				.setText("\u8f93\u5165\u60a8\u60f3\u4fee\u6539\u7684\u5b58\u50a8\u91cf");
		jTextField6.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				if(jTextField6.getText().equals("\u8f93\u5165\u60a8\u60f3\u4fee\u6539\u7684\u5b58\u50a8\u91cf")){
					jTextField6.setText("");
				}
			}
			public void focusLost(java.awt.event.FocusEvent evt) {
				if(jTextField6.getText().equals("")){
					jTextField6.setText("\u8f93\u5165\u60a8\u60f3\u4fee\u6539\u7684\u5b58\u50a8\u91cf");
				}
			}
		});

		jButton1.setText("\u786e\u5b9a\u8bbe\u7f6e");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});


		javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(
				jPanel7);
		jPanel7.setLayout(jPanel7Layout);
		jPanel7Layout
				.setHorizontalGroup(jPanel7Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel7Layout
										.createSequentialGroup()
										.addGap(183, 183, 183)
										.addGroup(
												jPanel7Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel7Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel7Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								false)
																						.addComponent(
																								jLabel5,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								jLabel8))
																		.addGap(
																				92,
																				92,
																				92)
																		.addGroup(
																				jPanel7Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								false)
																						.addComponent(
																								jTextField1)
																						.addComponent(
																								jTextField6,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								236,
																								javax.swing.GroupLayout.PREFERRED_SIZE)))
														.addGroup(
																jPanel7Layout
																		.createSequentialGroup()
																		.addGap(
																				143,
																				143,
																				143)
																		.addComponent(
																				jButton1)))
										.addContainerGap(179, Short.MAX_VALUE)));
		jPanel7Layout
				.setVerticalGroup(jPanel7Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel7Layout
										.createSequentialGroup()
										.addGap(129, 129, 129)
										.addGroup(
												jPanel7Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jTextField1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel5))
										.addGap(52, 52, 52)
										.addGroup(
												jPanel7Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jTextField6,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel8))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												185, Short.MAX_VALUE)
										.addComponent(jButton1).addGap(93, 93,
												93)));

		jTabbedPane2.addTab("\u8bbe\u7f6e\u4e91\u76d8\u5927\u5c0f", jPanel7);

		jTable6.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null },
						{ null, null, null, null } }, new String[] { "Title 1",
						"Title 2", "Title 3", "Title 4" }));
		jScrollPane6.setViewportView(jTable6);

		jLabel13.setText("\u5220\u9664\u5173\u952e\u5b57");

		jButton14.setText("+\u6dfb\u52a0");

		jTextField7.setText("\u641c\u7d22\u5173\u952e\u5b57");

		jButton15.setText("\u641c\u7d22");

		jTextField9.setText("\u8f93\u5165\u65b0\u5173\u952e\u5b57");

		javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(
				jPanel8);
		jPanel8.setLayout(jPanel8Layout);
		jPanel8Layout
				.setHorizontalGroup(jPanel8Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel8Layout.createSequentialGroup()
										.addContainerGap(678, Short.MAX_VALUE)
										.addComponent(jLabel13)
										.addContainerGap())
						.addComponent(jScrollPane6,
								javax.swing.GroupLayout.DEFAULT_SIZE, 750,
								Short.MAX_VALUE)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel8Layout
										.createSequentialGroup()
										.addContainerGap(53, Short.MAX_VALUE)
										.addComponent(
												jTextField9,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												153,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jButton14,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												85,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(201, 201, 201)
										.addComponent(
												jTextField7,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												139,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(1, 1, 1)
										.addComponent(jButton15).addGap(54, 54,
												54)));
		jPanel8Layout
				.setVerticalGroup(jPanel8Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel8Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel8Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																false)
														.addGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																jPanel8Layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(
																				jTextField7,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				30,
																				Short.MAX_VALUE)
																		.addComponent(
																				jButton14,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				30,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				jTextField9,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addComponent(jButton15))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												54, Short.MAX_VALUE)
										.addComponent(
												jScrollPane6,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												406,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jLabel13)));

		jTabbedPane2.addTab("\u5173\u952e\u5b57\u9ed1\u540d\u5355", jPanel8);

		javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(
				jPanel5);
		jPanel5.setLayout(jPanel5Layout);
		jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 755,
				Short.MAX_VALUE));
		jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jTabbedPane2));

		jTabbedPane1.addTab("\u5176\u4ed6\u7ba1\u7406", jPanel5);

		jLabel2.setText("\u7ba1\u7406\u5458ID");

		imageJpanel1.setImage(new ImageIcon("sec//skydisk2.jpg").getImage());

		javax.swing.GroupLayout imageJpanel1Layout = new javax.swing.GroupLayout(
				imageJpanel1);
		imageJpanel1.setLayout(imageJpanel1Layout);
		imageJpanel1Layout.setHorizontalGroup(imageJpanel1Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 148, Short.MAX_VALUE));
		imageJpanel1Layout.setVerticalGroup(imageJpanel1Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 138, Short.MAX_VALUE));

		imageJpanel2.setImage(new ImageIcon("sec//admin.jpg").getImage());

		javax.swing.GroupLayout imageJpanel2Layout = new javax.swing.GroupLayout(
				imageJpanel2);
		imageJpanel2.setLayout(imageJpanel2Layout);
		imageJpanel2Layout.setHorizontalGroup(imageJpanel2Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 184, Short.MAX_VALUE));
		imageJpanel2Layout.setVerticalGroup(imageJpanel2Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 164, Short.MAX_VALUE));

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(
																				67,
																				67,
																				67)
																		.addComponent(
																				jLabel2))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(
																				26,
																				26,
																				26)
																		.addComponent(
																				imageJpanel1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				imageJpanel2,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jTabbedPane1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												760,
												javax.swing.GroupLayout.PREFERRED_SIZE)));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGap(25, 25, 25)
										.addComponent(
												imageJpanel1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(27, 27, 27)
										.addComponent(jLabel2)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												137, Short.MAX_VALUE)
										.addComponent(
												imageJpanel2,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(84, 84, 84)).addComponent(
								jTabbedPane1,
								javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, 592,
								Short.MAX_VALUE));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents


	/*设置用户云盘大小*/
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		String uidTxt = jTextField1.getText();
		String memoryTxt = jTextField6.getText();
		if(uidTxt.equals("")||memoryTxt.equals("")){
			JOptionPane.showMessageDialog(this, "信息不能为空");
		}
		try {
			boolean isTrue = Admin.updateMemory(memoryTxt, uidTxt);
			if (isTrue) {
				JOptionPane.showMessageDialog(this, "修改成功");
				//数据更新
				datas = Admin.Userconvery("");
				utm.setRowValues(datas);
				jScrollPane2.invalidate();	
			
			} else {
				JOptionPane.showMessageDialog(this, "该用户不存在");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

	
	/*添加人员按钮*/
	private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
		new UserRegister();
	
	}
	
	
	
	/***
	 * 管理员搜搜索用户按钮
	 * @param evt
	 */
	private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {
		String searchTxt = jTextField2.getText();
		if(searchTxt.equals("搜索用户")){
			datas = Admin.Userconvery("");
			utm.setRowValues(datas);
			jScrollPane2.invalidate();	
		}else{
			datas = Admin.Userconvery(searchTxt);
			utm.setRowValues(datas);
			jScrollPane2.invalidate();	
		}
		

	}
	
	/*广告搜索按钮*/
	private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {
		String searchTxT = jTextField3.getText();
		if(searchTxT.equals("搜索广告名字")){
			datas = Ad.Adconvery("");
			atm.setRowValues(datas);
			jScrollPane3.invalidate();	
		}else{
			datas = Ad.Adconvery(searchTxT);
			atm.setRowValues(datas);
			jScrollPane3.invalidate();	
		}

	}
	
	/*添加广告按钮*/
	private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {
	
		
		new AddAd(atm,datas,jScrollPane3);
		
	}
	
	/***
	 * 管理员搜索文件按钮
	 * @param evt
	 */
	private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {
		String searchTxT = jTextField4.getText();
		if(searchTxT.equals("搜索文件")){
			datas = Admin.convery("");
			ftm.setRowValues(datas);
			jScrollPane4.invalidate();	
		}else{
			datas = Admin.convery(searchTxT);
			ftm.setRowValues(datas);
			jScrollPane4.invalidate();	
		}
		

	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper
							.launchBeautyEyeLNF();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				FontControl fontControl = new FontControl();
				fontControl.InitGlobalFont(new Font("微软雅黑",
						Font.CENTER_BASELINE, 13)); // 统一设置字体
				new AdminFrame().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private View.ImageJpanel imageJpanel1;
	private View.ImageJpanel imageJpanel2;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton10;
	private javax.swing.JButton jButton12;
	private javax.swing.JButton jButton13;
	private javax.swing.JButton jButton14;
	private javax.swing.JButton jButton15;
	private javax.swing.JButton jButton7;
	private javax.swing.JButton jButton8;
	private javax.swing.JButton jButton9;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel15;
	private javax.swing.JLabel jLabel16;
	private javax.swing.JLabel jLabel17;
	private javax.swing.JLabel jLabel18;
	private javax.swing.JLabel jLabel19;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JPanel jPanel6;
	private javax.swing.JPanel jPanel7;
	private javax.swing.JPanel jPanel8;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JScrollPane jScrollPane4;
	private javax.swing.JScrollPane jScrollPane5;
	private javax.swing.JScrollPane jScrollPane6;
	private javax.swing.JTabbedPane jTabbedPane1;
	private javax.swing.JTabbedPane jTabbedPane2;
	private javax.swing.JTable jTable2;
	private javax.swing.JTable jTable3;
	private javax.swing.JTable jTable4;
	private javax.swing.JTable jTable5;
	private javax.swing.JTable jTable6;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	private javax.swing.JTextField jTextField4;
	private javax.swing.JTextField jTextField5;
	private javax.swing.JTextField jTextField6;
	private javax.swing.JTextField jTextField7;
	private javax.swing.JTextField jTextField9;
	// End of variables declaration//GEN-END:variables

}