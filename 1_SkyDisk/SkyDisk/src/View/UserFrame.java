/*
 * UserFrame.java
 *
 * Created on __DATE__, __TIME__
 */

package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import com.ftp.Config;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;


import Control.Ad;
import Control.Admin;
import Control.File;
import Control.FileChooser;
import Control.FontControl;
import Control.ModelFactory;
import Control.MyRender_3;
import Control.MyRender_4;
import Control.MyRender_5;
import Control.Notice;
import Control.ShareTableModel;
import Control.TableModel;
import Control.UploadFiles;

import Control.MyRender_2;
import Control.User;

/**
 * 
 * @author __USER__
 */
public class UserFrame extends javax.swing.JFrame implements TableModelListener{

	private static final long serialVersionUID = 1L;
	/** Creates new form UserFrame */
	Object[][] datas = null;
	String userid = User.getUserid();
	TableModel tablemodel ;
	ShareTableModel shareTableModel ;
	String currentMemory;
	String currentSize;
	String allMemory;
	String allSize;
	static String adUrl="sec//baidubear.png";

	public UserFrame(String searchTxt,String shareTxt) {
		initComponents(searchTxt,shareTxt);

		Image icon = Toolkit.getDefaultToolkit().getImage("imgs//icon.jpg");

		this.setTitle("欢迎使用SkyDisk");
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(icon);
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents(String sTxt,String shareTxt) {

		jPanel1 = new javax.swing.JPanel();
		jTabbedPane1 = new javax.swing.JTabbedPane();
		jPanel2 = new javax.swing.JPanel();
		jButton1 = new javax.swing.JButton();
		jPanel5 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jLabel10 = new javax.swing.JLabel();
		jLabel11 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jButton2 = new javax.swing.JButton();
		jPanel3 = new javax.swing.JPanel();
		jScrollPane2 = new javax.swing.JScrollPane();
		jTable2 = new javax.swing.JTable();
		jButton3 = new javax.swing.JButton();
		jTextField2 = new javax.swing.JTextField();
		jButton4 = new javax.swing.JButton();
		jLabel9 = new javax.swing.JLabel();
		jPanel4 = new javax.swing.JPanel();
		jTabbedPane2 = new javax.swing.JTabbedPane();
		jPanel7 = new javax.swing.JPanel();
		jButton5 = new javax.swing.JButton();
		jLabel13 = new javax.swing.JLabel();
		jLabel14 = new javax.swing.JLabel();
		jLabel15 = new javax.swing.JLabel();
		jLabel16 = new javax.swing.JLabel();
		jLabel17 = new javax.swing.JLabel();
		jLabel18 = new javax.swing.JLabel();
		jLabel19 = new javax.swing.JLabel();
		jLabel20 = new javax.swing.JLabel();
		jLabel21 = new javax.swing.JLabel();
		jLabel22 = new javax.swing.JLabel();
		jButton6 = new javax.swing.JButton();
		jButton7 = new javax.swing.JButton();
		imageJpanel2 = new View.ImageJpanel();
		jPanel8 = new javax.swing.JPanel();
		imageJpanel1 = new View.ImageJpanel();
		jButton11 = new javax.swing.JButton();
		jButton12 = new javax.swing.JButton();
		jButton13 = new javax.swing.JButton();
		jButton14 = new javax.swing.JButton();
		jButton15 = new javax.swing.JButton();
		jButton16 = new javax.swing.JButton();
		jLabel12 = new javax.swing.JLabel();
		jLabel23 = new javax.swing.JLabel();
		jLabel24 = new javax.swing.JLabel();
		jLabel25 = new javax.swing.JLabel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jPanel6 = new javax.swing.JPanel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jProgressBar1 = new javax.swing.JProgressBar();
		jLabel8 = new javax.swing.JLabel();
		jButton11.setContentAreaFilled(false); 
		jButton12.setContentAreaFilled(false);
		jButton13.setContentAreaFilled(false);
		jButton14.setContentAreaFilled(false);
		jButton15.setContentAreaFilled(false);
		jButton16.setContentAreaFilled(false);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jButton1.setText("\u2227\u4e0a\u4f20");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		tablemodel = new TableModel(userid,sTxt);
		
		 
		jTable1 = new javax.swing.JTable(tablemodel);
		tablemodel.addTableModelListener(this);
		jTable1.getColumn("下载").setCellEditor(new MyRender_3(jTable1));
		jTable1.getColumn("下载").setCellRenderer(new MyRender_3(jTable1));
		jTable1.getColumn("删除").setCellEditor(new MyRender_4(jTable1,tablemodel,jScrollPane1));
		jTable1.getColumn("删除").setCellRenderer(new MyRender_4(jTable1,tablemodel,jScrollPane1));
		jTable1.setRowHeight(30);
		jTable1.setToolTipText("");
		jTable1.setPreferredScrollableViewportSize(new Dimension(480,200));
		
		
		
		jScrollPane1.setViewportView(jTable1);

		jLabel10.setText("\u4e0b\u8f7d\u6587\u4ef6");

		jLabel11.setText("\u5220\u9664\u6587\u4ef6");

		javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(
				jPanel5);
		jPanel5.setLayout(jPanel5Layout);
		jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING,
				javax.swing.GroupLayout.DEFAULT_SIZE, 986, Short.MAX_VALUE)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel5Layout.createSequentialGroup().addContainerGap(
								773, Short.MAX_VALUE).addComponent(jLabel11)
								.addGap(57, 57, 57).addComponent(jLabel10)
								.addGap(36, 36, 36)));
		jPanel5Layout
				.setVerticalGroup(jPanel5Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel5Layout
										.createSequentialGroup()
										.addComponent(
												jScrollPane1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												468,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												11, Short.MAX_VALUE)
										.addGroup(
												jPanel5Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel10)
														.addComponent(jLabel11))));

		/*文件搜索框*/
		jTextField1.setText("\u641c\u7d22\u6211\u7684\u7f51\u76d8\u6587\u4ef6");
		jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				jTextField1.setText("");
			}
			public void focusLost(java.awt.event.FocusEvent evt) {
				if(jTextField1.getText().equals("")){
					jTextField1.setText("\u641c\u7d22\u6211\u7684\u7f51\u76d8\u6587\u4ef6");
				}
			}
		});
		/*文件搜索按钮*/
		jButton2.setText("\u67e5\u627e");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

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
										.addComponent(jButton1)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												532, Short.MAX_VALUE)
										.addComponent(
												jTextField1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												178,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jButton2).addGap(131,
												131, 131)).addComponent(
								jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE));
		jPanel2Layout
				.setVerticalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jButton1)
														.addComponent(
																jTextField1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jButton2))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(
												jPanel5,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		jTabbedPane1.addTab("\u6587\u4ef6\u7ba1\u7406", jPanel2);


		/*分享的文件的表格*/
		shareTableModel = new ShareTableModel(sTxt);
		
		jTable2 = new javax.swing.JTable(shareTableModel);
		jTable2.getColumn("下载").setCellEditor(new MyRender_5(jTable2));
		jTable2.getColumn("下载").setCellRenderer(new MyRender_5(jTable2));
		jTable2.setRowHeight(30);
		jTable2.setToolTipText("");
		jScrollPane2.setViewportView(jTable2);

		jButton3.setText("\u5206\u4eab\u6587\u4ef6");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jTextField2.setText("搜索用户分享文件名");
		jTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				if(jTextField2.getText().equals("搜索用户分享文件名")){
					jTextField2.setText("");
				}
			}
			public void focusLost(java.awt.event.FocusEvent evt) {
				if(jTextField2.getText().equals("")){
					jTextField2.setText("搜索用户分享文件名");
				}
			}
		});

		jButton4.setText("\u67e5\u627e");
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});
		
		jLabel9.setText("\u4e0b\u8f7d\u6587\u4ef6");

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
										.addContainerGap()
										.addComponent(jButton3)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												521, Short.MAX_VALUE)
										.addComponent(
												jTextField2,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												178,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jButton4).addGap(107,
												107, 107)).addComponent(
								jScrollPane2,
								javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, 986,
								Short.MAX_VALUE).addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel3Layout.createSequentialGroup()
										.addContainerGap(900, Short.MAX_VALUE)
										.addComponent(jLabel9).addGap(26, 26,
												26)));
		jPanel3Layout
				.setVerticalGroup(jPanel3Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel3Layout
										.createSequentialGroup()
										.addContainerGap(17, Short.MAX_VALUE)
										.addGroup(
												jPanel3Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jButton3)
														.addComponent(
																jTextField2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jButton4))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(
												jScrollPane2,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												469,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jLabel9)));

		jTabbedPane1.addTab("\u6587\u4ef6\u5206\u4eab", jPanel3);

		jButton5.setText("修改头像");
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton5ActionPerformed(evt);
			}
		});

		jLabel13.setText("\u8d26\u53f7\uff1a");

		jLabel14.setText("\u7528\u6237\u540d\uff1a");

		jLabel15.setText("总容量");

		jLabel16.setText(userid);

		jLabel17.setText(User.getUsername());

		

		jLabel19.setText("\u4e2a\u4eba\u7535\u8bdd\uff1a");

		jLabel20.setText(User.getPhone());

		jLabel21.setText("\u4e2a\u4eba\u90ae\u7bb1\uff1a");

		jLabel22.setText(User.getEmail());

		jButton6.setText("修改信息");
		jButton6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton6ActionPerformed(evt);
			}
		});

		jButton7.setText("退出登录");
		jButton7.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton7ActionPerformed(evt);
			}
		});

		imageJpanel2.setImage(new ImageIcon(adUrl).getImage());
		

		javax.swing.GroupLayout imageJpanel2Layout = new javax.swing.GroupLayout(
				imageJpanel2);
		imageJpanel2.setLayout(imageJpanel2Layout);
		imageJpanel2Layout.setHorizontalGroup(imageJpanel2Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 190, Short.MAX_VALUE));
		imageJpanel2Layout.setVerticalGroup(imageJpanel2Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 189, Short.MAX_VALUE));

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
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								jPanel7Layout
																										.createSequentialGroup()
																										.addGap(
																												102,
																												102,
																												102)
																										.addComponent(
																												jButton5))
																						.addGroup(
																								jPanel7Layout
																										.createSequentialGroup()
																										.addGap(
																												52,
																												52,
																												52)
																										.addComponent(
																												imageJpanel2,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												javax.swing.GroupLayout.PREFERRED_SIZE)))
																		.addGap(
																				57,
																				57,
																				57)
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
																																javax.swing.GroupLayout.Alignment.LEADING)
																														.addComponent(
																																jLabel14)
																														.addComponent(
																																jLabel15)
																														.addComponent(
																																jLabel19)
																														.addComponent(
																																jLabel21))
																										.addGap(
																												115,
																												115,
																												115)
																										.addGroup(
																												jPanel7Layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING)
																														.addComponent(
																																jLabel17)
																														.addComponent(
																																jLabel18)
																														.addComponent(
																																jLabel20)
																														.addComponent(
																																jLabel22)
																														.addComponent(
																																jLabel16)))
																						.addComponent(
																								jLabel13)))
														.addGroup(
																jPanel7Layout
																		.createSequentialGroup()
																		.addGap(
																				248,
																				248,
																				248)
																		.addComponent(
																				jButton6)
																		.addGap(
																				209,
																				209,
																				209)
																		.addComponent(
																				jButton7,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				101,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(330, Short.MAX_VALUE)));
		jPanel7Layout
				.setVerticalGroup(jPanel7Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel7Layout
										.createSequentialGroup()
										.addGap(58, 58, 58)
										.addGroup(
												jPanel7Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel16)
														.addGroup(
																jPanel7Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel13)
																		.addGap(
																				51,
																				51,
																				51)
																		.addGroup(
																				jPanel7Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								jLabel14)
																						.addComponent(
																								jLabel17))
																		.addGap(
																				49,
																				49,
																				49)
																		.addGroup(
																				jPanel7Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								jLabel15)
																						.addComponent(
																								jLabel18))
																		.addGap(
																				39,
																				39,
																				39)
																		.addGroup(
																				jPanel7Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								jLabel19)
																						.addComponent(
																								jLabel20))
																		.addGap(
																				46,
																				46,
																				46)
																		.addGroup(
																				jPanel7Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								jLabel21)
																						.addComponent(
																								jLabel22))))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												81, Short.MAX_VALUE)
										.addGroup(
												jPanel7Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jButton6)
														.addComponent(jButton7))
										.addGap(73, 73, 73)).addGroup(
								jPanel7Layout.createSequentialGroup().addGap(
										41, 41, 41).addComponent(imageJpanel2,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(35, 35, 35).addComponent(
												jButton5).addContainerGap(232,
												Short.MAX_VALUE)));

		jTabbedPane2.addTab("\u4e2a\u4eba\u8d44\u6599", jPanel7);

		imageJpanel1.setImage(new ImageIcon("sec//diskback.jpg").getImage());
		imageJpanel1.setInheritsPopupMenu(true);

		jLabel12.setText("\u603b\u5bb9\u91cf\uff1a");

		

		jLabel24.setText("\u5df2\u7528\u5bb9\u91cf\uff1a");

		

		javax.swing.GroupLayout imageJpanel1Layout = new javax.swing.GroupLayout(
				imageJpanel1);
		imageJpanel1.setLayout(imageJpanel1Layout);
		imageJpanel1Layout
				.setHorizontalGroup(imageJpanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								imageJpanel1Layout
										.createSequentialGroup()
										.addGap(136, 136, 136)
										.addGroup(
												imageJpanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(
																jLabel24,
																javax.swing.GroupLayout.Alignment.TRAILING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																jLabel12,
																javax.swing.GroupLayout.Alignment.TRAILING))
										.addGap(74, 74, 74)
										.addGroup(
												imageJpanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel23)
														.addComponent(jLabel25))
										.addContainerGap(635, Short.MAX_VALUE))
						.addGroup(
								imageJpanel1Layout
										.createSequentialGroup()
										.addGap(64, 64, 64)
										.addGroup(
												imageJpanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jButton13,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																184,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jButton14,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																184,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												129, Short.MAX_VALUE)
										.addGroup(
												imageJpanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jButton11,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																184,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jButton15,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																184,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(131, 131, 131)
										.addGroup(
												imageJpanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jButton12,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																193,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jButton16,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																193,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(96, 96, 96)));
		imageJpanel1Layout
				.setVerticalGroup(imageJpanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								imageJpanel1Layout
										.createSequentialGroup()
										.addGap(36, 36, 36)
										.addGroup(
												imageJpanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel12)
														.addComponent(jLabel23))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												imageJpanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jLabel24,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																19,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel25))
										.addGap(49, 49, 49)
										.addGroup(
												imageJpanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jButton13,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																161,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jButton12,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																161,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jButton11,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																161,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												imageJpanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(
																jButton16,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																jButton15,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																176,
																Short.MAX_VALUE)
														.addComponent(
																jButton14,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addContainerGap(37, Short.MAX_VALUE)));

		javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(
				jPanel8);
		jPanel8.setLayout(jPanel8Layout);
		jPanel8Layout.setHorizontalGroup(jPanel8Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				imageJpanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		jPanel8Layout.setVerticalGroup(jPanel8Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				imageJpanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		jTabbedPane2.addTab("\u4e2a\u4eba\u7f51\u76d8", jPanel8);

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(
				jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 986,
				Short.MAX_VALUE));
		jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jTabbedPane2));

		jTabbedPane1.addTab("\u7528\u6237\u4e2d\u5fc3", jPanel4);

		jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/imgs/skydisk2.jpg"))); // NOI18N

		/*jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/imgs/advert.jpg"))); // NOI18N*/
		String imgUrl;
		//String imgType;
		try {
			imgUrl = User.getImgUrl();
		
		//	String imgName = Admin.getImgName(n);
			
			jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource(
					"/imgs/adimg"+imgUrl))); // NOI18N
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	
	
		jLabel3.setText(User.getUsername());

		jLabel4.setText("     SkyDisk,只为更安全的服务");
		jLabel4.setFont(new Font("微软雅黑",Font.CENTER_BASELINE,15));
		jLabel4.setForeground(new Color(125,0,0));
		try {
			Notice.getNotice();
		
			jLabel5.setText(Notice.getNfirst());
			jLabel5.setFont(new Font("微软雅黑",Font.CENTER_BASELINE,13));
			jLabel6.setText(Notice.getNsecond());
			jLabel6.setFont(new Font("微软雅黑",Font.CENTER_BASELINE,13));
			jLabel7.setText(Notice.getNthird());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

		javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(
				jPanel6);
		jPanel6.setLayout(jPanel6Layout);
		jPanel6Layout
				.setHorizontalGroup(jPanel6Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel6Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel6Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel6Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel6Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addComponent(
																								jLabel6,
																								javax.swing.GroupLayout.Alignment.LEADING,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								209,
																								Short.MAX_VALUE)
																						.addComponent(
																								jLabel5,
																								javax.swing.GroupLayout.Alignment.LEADING,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								209,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addContainerGap(
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE))
														.addGroup(
																jPanel6Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel7,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				209,
																				Short.MAX_VALUE)
																		.addContainerGap())
														.addComponent(
																jLabel4,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																224,
																Short.MAX_VALUE))));
		jPanel6Layout
				.setVerticalGroup(jPanel6Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel6Layout
										.createSequentialGroup()
										.addComponent(
												jLabel4,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												28,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jLabel5,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												31,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jLabel6,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												29,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												10, Short.MAX_VALUE)
										.addComponent(
												jLabel7,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												29,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap()));
		/*进度条*/
		jProgressBar1.setBackground(new java.awt.Color(125, 125, 125));
		jProgressBar1.setMinimum(0);
		jProgressBar1.setMaximum(100);
		
		try {
			currentMemory = File.getAllFilesSize(userid);
			currentSize = ModelFactory.getFilesSize(currentMemory);
			allMemory = User.getUserSize(userid);//管理员提供的数据
			allSize = ModelFactory.getFilesSize(allMemory);
			jLabel23.setText(allSize);
			jLabel25.setText(currentSize);
			jLabel18.setText(allSize);
			jLabel8.setText(currentSize+"/"+allSize);/*试试长整型*/
			float progressBarValue = Float.parseFloat(currentMemory)/Float.parseFloat(allMemory);
			int currentMemoryValue = (int)(progressBarValue*100);
			jProgressBar1.setValue(currentMemoryValue);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

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
														.addComponent(
																jPanel6,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																216,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				jLabel3))
														.addGroup(
																jPanel1Layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING,
																				false)
																		.addComponent(
																				jLabel2,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				208,
																				Short.MAX_VALUE)
																		.addGroup(
																				jPanel1Layout
																						.createSequentialGroup()
																						.addGap(
																								31,
																								31,
																								31)
																						.addComponent(
																								jLabel1,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								141,
																								javax.swing.GroupLayout.PREFERRED_SIZE)))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jProgressBar1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				164,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jLabel8)))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jTabbedPane1,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												991, Short.MAX_VALUE)));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGap(24, 24, 24)
										.addComponent(
												jLabel1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												112,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(23, 23, 23)
										.addComponent(jLabel3)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jProgressBar1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel8))
										.addGap(16, 16, 16)
										.addComponent(
												jPanel6,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jLabel2,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												193,
												javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(jTabbedPane1,
								javax.swing.GroupLayout.Alignment.TRAILING));

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
	
		/*分享按钮*/	
	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		String uploadResult = ModelFactory.uploadFile("share","share_result","public");
		if(uploadResult.equals("文件上传成功")){
			JOptionPane.showMessageDialog(this, "分享文件成功");
			//表格数据更新
			datas = File.shareConvery("");
			shareTableModel.setRowValues(datas);
			jScrollPane2.invalidate();	
		}
		
	}
	
	/*文件上传按钮按钮*/	
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {	
		
			String uploadResult = ModelFactory.uploadFile("file", "result",userid);
			if(uploadResult.equals("文件上传成功")){
				JOptionPane.showMessageDialog(this, uploadResult);
				//表格数据更新
				datas = File.convery(userid, "");
				tablemodel.setRowValues(datas);
				jScrollPane1.invalidate();	
				
				try {
					currentMemory = File.getAllFilesSize(userid);
					currentSize = ModelFactory.getFilesSize(currentMemory);
					//allMemory = "20485760";//管理员提供的数据
					allMemory = User.getUserSize(userid);//管理员提供的数据
					allSize = ModelFactory.getFilesSize(allMemory);
					jLabel8.setText(currentSize+"/"+allSize);/*试试长整型*/
					float progressBarValue = Float.parseFloat(currentMemory)/Float.parseFloat(allMemory);
					int currentMemoryValue = (int)(progressBarValue*100);
					jProgressBar1.setValue(currentMemoryValue);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else{
				JOptionPane.showMessageDialog(this, uploadResult);
			}
		
		
		

	}

	/*用户文件搜索按钮*/
	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		String searchTxt = jTextField1.getText();
		
		if(searchTxt.equals("搜索我的网盘文件")){
			datas = File.convery(userid, "");
			tablemodel.setRowValues(datas);
			jScrollPane1.invalidate();	
		}else{
			datas = File.convery(userid, searchTxt);
			tablemodel.setRowValues(datas);
			jScrollPane1.invalidate();	
			
		}
		
	}
	
	/*分享文件搜索按钮*/
	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
		String shareTxt = jTextField2.getText();
		if(shareTxt.equals("搜索用户分享文件名")){
			datas = File.shareConvery("");
			shareTableModel.setRowValues(datas);
			jScrollPane2.invalidate();	
		}else{
			datas = File.shareConvery(shareTxt);
			shareTableModel.setRowValues(datas);
			jScrollPane2.invalidate();	
		}
		
	}
	/***
	 * 用户修改头像
	 * @param evt
	 */
	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
		JFileChooser jfc = new JFileChooser();
		
		int value = jfc.showDialog(new JLabel(), "选择");
		if(value==JFileChooser.APPROVE_OPTION){
			String path = jfc.getSelectedFile().getAbsolutePath();
			imageJpanel2.setImage(new ImageIcon(path).getImage());
		}
	
		
	}
	
	private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
		new UserUpdate();
		
		//jButton5.setIcon(new ImageIcon(path));
		
	}
	/***
	 * 用户退出登录
	 * @param evt
	 */
	private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
		this.dispose();
		new Login();
		
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
				ModelFactory.InitGlobalFont(new Font("微软雅黑",
						Font.CENTER_BASELINE, 13)); // 统一设置字体
				new UserFrame("","").setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private View.ImageJpanel imageJpanel1;
	private View.ImageJpanel imageJpanel2;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton11;
	private javax.swing.JButton jButton12;
	private javax.swing.JButton jButton13;
	private javax.swing.JButton jButton14;
	private javax.swing.JButton jButton15;
	private javax.swing.JButton jButton16;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton5;
	private javax.swing.JButton jButton6;
	private javax.swing.JButton jButton7;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel15;
	private javax.swing.JLabel jLabel16;
	private javax.swing.JLabel jLabel17;
	private javax.swing.JLabel jLabel18;
	private javax.swing.JLabel jLabel19;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel20;
	private javax.swing.JLabel jLabel21;
	private javax.swing.JLabel jLabel22;
	private javax.swing.JLabel jLabel23;
	private javax.swing.JLabel jLabel24;
	private javax.swing.JLabel jLabel25;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel15;
	private javax.swing.JPanel jPanel16;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JPanel jPanel6;
	private javax.swing.JPanel jPanel7;
	private javax.swing.JPanel jPanel8;
	private javax.swing.JProgressBar jProgressBar1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTabbedPane jTabbedPane1;
	private javax.swing.JTabbedPane jTabbedPane2;
	private javax.swing.JTable jTable1;
	private javax.swing.JTable jTable2;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	// End of variables declaration//GEN-END:variables

	@Override
	public void tableChanged(TableModelEvent e) {
		/*datas = File.convery(userid, "");
		int row = e.getFirstRow();
		int col = e.getColumn();
		String fname = (String) datas[row][0];
		String ftype = (String) tablemodel.getValueAt(row, 2);*/
		//String fsize = (String) datas[row][1];
		/*String nowvalue = (String) tablemodel.getValueAt(row, col);
		//JOptionPane.showMessageDialog(this, fsize);
		
		try {
			//boolean isModify = File.updateFile(nowvalue,userid,fname, ftype,fsize);要获取文件大小或者直接获取文件id
			
			boolean isModify = File.updateFile(nowvalue,userid,fname, ftype);
			if(isModify){
				JOptionPane.showMessageDialog(this, "文件重命名成功");
			}else{
				JOptionPane.showMessageDialog(this, "文件重命名失败");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog(this, "文件重命名失败");
		}*/
		
		
	}
}