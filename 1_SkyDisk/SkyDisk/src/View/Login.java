package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.*;

import Control.Admin;

import Control.ModelFactory;
import Control.MyClient;
import Control.User;


public class Login extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	JButton loginBtn;
	JLabel register;
	JRadioButton userBtn;
	JRadioButton admBtn;
	JTextField nameTxt;
	JPasswordField passTxt;
	ButtonGroup bg;

	public Login() {

		Image icon = Toolkit.getDefaultToolkit().getImage("sec//icon.jpg");

		JPanel mainPanel = new JPanel(null);
		ImageIcon background = new ImageIcon(getClass().getResource(
				"/imgs/4.gif"));
		JLabel backgroundLabel = new JLabel(background);
		backgroundLabel.setBounds(-8, 0, 460, 130);
		JLabel userName = new JLabel("用户名:");
		userName.setBounds(100, 132, 60, 30);
		userName.setFont(new Font("微软雅黑", Font.CENTER_BASELINE, 14));

		JLabel password = new JLabel("密   码:");
		password.setBounds(100, 172, 60, 30);
		password.setFont(new Font("微软雅黑", Font.CENTER_BASELINE, 14));

		nameTxt = new JTextField("请输入用户名", 30);
		nameTxt.setBounds(160, 136, 180, 27);
		nameTxt.setFont(new Font("微软雅黑", Font.CENTER_BASELINE, 14));
		nameTxt.setForeground(Color.GRAY);

		nameTxt.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				if(nameTxt.getText().equals("请输入用户名")){
					nameTxt.setText("");
				}
			}
			public void focusLost(java.awt.event.FocusEvent evt) {
				if(nameTxt.getText().equals("")){
					nameTxt.setText("请输入用户名");
				}
			}
		});

		passTxt = new JPasswordField("请输入密码", 30);
		passTxt.setBounds(160, 175, 180, 25);
		passTxt.setFont(new Font("微软雅黑", Font.CENTER_BASELINE, 14));
		passTxt.setForeground(Color.GRAY);
		passTxt.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				if(new String(passTxt.getPassword()).equals("请输入密码")){
					passTxt.setText("");
				}
			}
			public void focusLost(java.awt.event.FocusEvent evt) {
				if(new String(passTxt.getPassword()).equals("")){
					passTxt.setText("请输入密码");
				}
			}
		});
		userBtn = new JRadioButton("用户");
		userBtn.setBounds(140, 215, 62, 25);
		userBtn.setFont(new Font("微软雅黑", Font.CENTER_BASELINE, 14));
		admBtn = new JRadioButton("管理员");
		admBtn.setBounds(240, 215, 82, 25);
		admBtn.setFont(new Font("微软雅黑", Font.CENTER_BASELINE, 14));
		bg = new ButtonGroup();
		
		loginBtn = new JButton("登录");
		loginBtn.setBounds(100, 250, 245, 35);
		loginBtn.setFont(new Font("微软雅黑", Font.CENTER_BASELINE, 14));

		register = new JLabel("注册账号");
		register.setBounds(10, 290, 70, 30);
		register.setFont(new Font("微软雅黑", Font.CENTER_BASELINE, 12));
		register.setForeground(Color.GRAY);

		register.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new UserRegister();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});

		loginBtn.addActionListener(this);
		admBtn.addActionListener(this);
		this.add(mainPanel);

		// northPanel.add(userName);
		mainPanel.add(backgroundLabel);
		mainPanel.add(userName);
		mainPanel.add(nameTxt);
		mainPanel.add(password);
		mainPanel.add(passTxt);
		mainPanel.add(userBtn);
		mainPanel.add(admBtn);
		bg.add(userBtn);
		bg.add(admBtn);
		mainPanel.add(loginBtn);
		mainPanel.add(register);
		this.setSize(500, 400);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("SkyDisk，让美好永远陪伴");
		this.setIconImage(icon);

	}

	public static void main(String[] args) {
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelFactory.InitGlobalFont(new Font("微软雅黑", Font.CENTER_BASELINE, 12));

		new Login();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String name = this.nameTxt.getText();
		String password = new String(this.passTxt.getPassword());

		if (e.getActionCommand().equals("登录")) {

			if (name.equals("") || password.equals("")
					|| (name.equals("") && password.equals("")) ||  (name.equals("请输入用户名") && password.equals("请输入密码"))) {
				JOptionPane.showMessageDialog(this, "请输入用户名或者密码");
				System.out.println("1");
				return ;
			} else if (!this.userBtn.isSelected() && !this.admBtn.isSelected()) {
				JOptionPane.showMessageDialog(this, "请选择登录类型");
				return ;
			}

			if (userBtn.isSelected()) {
				User u =null ;
				
				try {
					//MyClient client = new MyClient();
					// u = client.login(name, password);

					u = ModelFactory.uLogin(name, password);
					 System.out.println(u);
					if(u!=null){		
						dispose();
				
						JOptionPane.showMessageDialog(this, "登录成功,欢迎使用SkyDisk");
						new UserFrame("","");
					}else{
						JOptionPane.showMessageDialog(this, "用户名或者密码错误");
						this.nameTxt.setText("");
						this.passTxt.setText("");
						this.bg.clearSelection();		
					}
				} catch (Exception e1) {
					//JOptionPane.showMessageDialog(this, e1.getMessage());
					e1.printStackTrace();
					this.nameTxt.setText("");
					this.passTxt.setText("");
					this.bg.clearSelection();
				}
				//运行看看，上传下载试试
			} else if (admBtn.isSelected()) {
				Admin a = new Admin();
				try {
					a = ModelFactory.alogin(name, password);
					if(a!=null){		
						dispose();
						JOptionPane.showMessageDialog(this, "登录成功,SkyDisk管理后台");
						new AdminFrame();
					}else{
						JOptionPane.showMessageDialog(this, "用户名或者密码错误");
						this.nameTxt.setText("");
						this.passTxt.setText("");
						this.bg.clearSelection();		
					}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(this, e1.getMessage());
					e1.printStackTrace();
					this.nameTxt.setText("");
					this.passTxt.setText("");
					this.bg.clearSelection();
				}
			}
		}
	}

}
