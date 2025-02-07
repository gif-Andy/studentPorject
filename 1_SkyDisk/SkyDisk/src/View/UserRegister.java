/*
 * UserRegister.java
 *
 * Created on __DATE__, __TIME__
 */

package View;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Control.Admin;
import Control.FontControl;
import Control.ModelFactory;
import Control.User;

/**
 * 
 * @author __USER__
 */
public class UserRegister extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;

	/** Creates new form UserRegister */
	public UserRegister() {
		initComponents();
		Image icon = Toolkit.getDefaultToolkit().getImage("imgs//icon.jpg");
		this.setTitle("用户注册");
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setIconImage(icon);

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jPanel2 = new javax.swing.JPanel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		uidTxt = new javax.swing.JTextField();
		phoneTxt = new javax.swing.JTextField();
		upassTxt = new javax.swing.JPasswordField();
		registerBtn = new javax.swing.JButton();
		emailTxt = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		unameTxt = new javax.swing.JTextField();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/imgs/user-icon.png"))); // NOI18N

		jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/imgs/pass-icon.png"))); // NOI18N

		jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/imgs/tel-icon.png"))); // NOI18N

		uidTxt.setForeground(new java.awt.Color(153, 153, 153));
		uidTxt.setText("请输入8-10位数字");
		uidTxt.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				if(uidTxt.getText().equals("请输入8-10位数字")){
					uidTxt.setText("");
				}
			}
			public void focusLost(java.awt.event.FocusEvent evt) {
				if(uidTxt.getText().equals("")){
					uidTxt.setText("请输入8-10位数字");
				}
			}
		});

		phoneTxt.setForeground(new java.awt.Color(153, 153, 153));
		phoneTxt
				.setText("请输入正确的电话号码");
		phoneTxt.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				if(phoneTxt.getText().equals("请输入正确的电话号码")){
					phoneTxt.setText("");
				}
			}
			public void focusLost(java.awt.event.FocusEvent evt) {
				if(phoneTxt.getText().equals("")){
					phoneTxt.setText("请输入正确的电话号码");
				}
			}
		});
		upassTxt.setForeground(new java.awt.Color(153, 153, 153));
		upassTxt.setText("请输入密码");
		upassTxt.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				if(new String(upassTxt.getPassword()).equals("请输入密码")){
					upassTxt.setText("");
				}
			}
			public void focusLost(java.awt.event.FocusEvent evt) {
				if(new String(upassTxt.getPassword()).equals("")){
					upassTxt.setText("请输入密码");
				}
			}
		});
		registerBtn.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24));
		registerBtn.setText("\u7acb\u5373\u6ce8\u518c");
		registerBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				registerBtnActionPerformed(evt);
			}
		});

		emailTxt.setForeground(new java.awt.Color(153, 153, 153));
		emailTxt
				.setText("请输入有效的邮箱");
		emailTxt.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				if(emailTxt.getText().equals("请输入有效的邮箱")){
					emailTxt.setText("");
				}
			}
			public void focusLost(java.awt.event.FocusEvent evt) {
				if(emailTxt.getText().equals("")){
					emailTxt.setText("请输入有效的邮箱");
				}
			}
		});
		jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/imgs/mail-icon.png"))); // NOI18N

		jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18));
		jLabel2
				.setText("\u521b\u5efa\u4f60\u7684\u8d26\u53f7\uff0c\u662f\u4f60\u7684\u7b2c\u4e00\u6b65");

		jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18));
		jLabel3.setText("\u6b22\u8fce\u4f7f\u7528SkyDisk");

		jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/imgs/id.png"))); // NOI18N

		unameTxt.setForeground(new java.awt.Color(153, 153, 153));
		unameTxt.setText("请输入你的用户名");
		unameTxt.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				if(unameTxt.getText().equals("请输入你的用户名")){
					unameTxt.setText("");
				}
			}
			public void focusLost(java.awt.event.FocusEvent evt) {
				if(unameTxt.getText().equals("")){
					unameTxt.setText("请输入你的用户名");
				}
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
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel2Layout
										.createSequentialGroup()
										.addContainerGap(97, Short.MAX_VALUE)
										.addComponent(
												jLabel3,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												191,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(65, 65, 65))
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel2Layout
										.createSequentialGroup()
										.addContainerGap(65, Short.MAX_VALUE)
										.addComponent(
												jLabel2,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												276,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addGap(56, 56, 56)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel2Layout
																		.createSequentialGroup()
																		.addComponent(
																				registerBtn,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				225,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addContainerGap())
														.addGroup(
																jPanel2Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel2Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addComponent(
																								jLabel6)
																						.addComponent(
																								jLabel7)
																						.addComponent(
																								jLabel1)
																						.addComponent(
																								jLabel4)
																						.addComponent(
																								jLabel5))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				jPanel2Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								upassTxt,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								220,
																								Short.MAX_VALUE)
																						.addGroup(
																								jPanel2Layout
																										.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.LEADING,
																												false)
																										.addComponent(
																												emailTxt)
																										.addComponent(
																												phoneTxt)
																										.addComponent(
																												unameTxt)
																										.addComponent(
																												uidTxt,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												220,
																												javax.swing.GroupLayout.PREFERRED_SIZE)))
																		.addGap(
																				47,
																				47,
																				47)))));
		jPanel2Layout
				.setVerticalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addGap(39, 39, 39)
										.addComponent(jLabel3)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jLabel2,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												33,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel4)
														.addComponent(
																uidTxt,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jLabel5,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																23,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																unameTxt,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(11, 11, 11)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																false)
														.addComponent(upassTxt)
														.addComponent(jLabel6))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(jLabel7)
														.addComponent(
																phoneTxt,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(jLabel1)
														.addComponent(
																emailTxt,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(34, 34, 34)
										.addComponent(
												registerBtn,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												38,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(36, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {
		String userid = uidTxt.getText();
		String userName = unameTxt.getText();
		String userPass = new String(this.upassTxt.getPassword());
		String userphone = phoneTxt.getText();
		String useremail = emailTxt.getText();
		if (userid.equals("") || userName.equals("输入你的用户名") || userPass.equals("请输入密码")
				|| userphone.equals("请输入您的电话号码") || useremail.equals(("请输入您的邮箱地址"))) {
			JOptionPane.showMessageDialog(this, "请填写完整信息");
		} else {
			if(!ModelFactory.UseridFormat(userid)){
				JOptionPane.showMessageDialog(this, "用户ID必须是8-10数字");
			}else if(!ModelFactory.PhoneFormat(userphone)){
				JOptionPane.showMessageDialog(this, "请输入正确的电话号码");
			}else if(!ModelFactory.emailFormat(useremail)){
				JOptionPane.showMessageDialog(this, "请输入正确的邮箱");
			}else{
				try {
					
					if(User.isUserid(userid)){
						String result = User.uRegister(userid, userName, userPass,
								userphone, useremail);
						JOptionPane.showMessageDialog(this, result);
						if (result.equals("注册成功")) {
							new Login();
					
						}	
					}else {
						JOptionPane.showMessageDialog(this, "此ID已存在");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}		
			}
			
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
				ModelFactory.InitGlobalFont(new Font("微软雅黑",
						Font.CENTER_BASELINE, 12));
				new UserRegister().setVisible(true);

			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JTextField emailTxt;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JTextField phoneTxt;
	private javax.swing.JButton registerBtn;
	private javax.swing.JTextField uidTxt;
	private javax.swing.JTextField unameTxt;
	private javax.swing.JPasswordField upassTxt;
	// End of variables declaration//GEN-END:variables

}