package gui.login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import gui.data.GUIControler;
import gui.main.MainFrame;
import gui.simple.*;

/**
 * Frame for login view
 * @author Dongwon
 *
 */
public class LoginFrame extends SimpleJFrame implements ActionListener, KeyListener {
	
	private static final long serialVersionUID = -7950017324115720179L;
	
	private JLabel mainLabel;
	private JLabel idLabel;
	private JLabel passwordLabel;
	
	private JTextField idField;
	private JPasswordField passwordField;
	
	private JButton okButton;
	private JButton cancelButton;
	private JButton signupButton;
	
	public LoginFrame(){
		super("LoginFrame", 400, 300);
		
		addComponents();
		
		idField.grabFocus();
	}
	
	public void addComponents() {
		
		mainLabel = GUIControler.addBigLabel(this, mainLabel, "과제 제출 시스템", 110, 30);
		
		idLabel = GUIControler.addSmallLabel(this, idLabel, "아이디", 40, 90);
		passwordLabel = GUIControler.addSmallLabel(this, passwordLabel, "비밀번호", 40, 150);
		
		idField = GUIControler.addTextField(this, idField, 40, 130, 310, 30);
		passwordField = GUIControler.addPasswordField(this, passwordField, 40, 190, 310, 30);
		
		okButton = GUIControler.addButton(this, okButton, " 확 인 ", 40, 240);
		cancelButton = GUIControler.addButton(this, cancelButton, " 취 소 ", 155, 240);
		signupButton = GUIControler.addButton(this, signupButton, " 가 입 ", 270, 240);
		
		this.minimizeButton.addActionListener(this);
		this.exitButton.addActionListener(this);
	}

	public void openSystemFrame() {
		// TODO opening frame branch control by identification authority type
		/*
		 * if admin then open admin frame
		 * else if supervisor then open supervisor frame ... 1
		 * else if student then open student frame ... 2
		 * else then no user on database warning
		 * 
		 * note: 1 and 2 probably the same
		 */
		//JOptionPane.showMessageDialog(this, "Login!");
		
		/*if(Login Sucess)*/ {
			@SuppressWarnings("unused")
			MainFrame mainFrame = new MainFrame();
		}
	}
	
	public void openSignupFrame() {
		@SuppressWarnings("unused")
		SignupFrame signupFrame = new SignupFrame();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == okButton) {
			openSystemFrame();
			
			this.dispose();
		}
		else if(e.getSource() == cancelButton) {
			this.dispose();
		}
		else if(e.getSource() == signupButton) {
			openSignupFrame();
			
			this.dispose();
		}
		else if(e.getSource() == minimizeButton) {
			this.setState(Frame.ICONIFIED);
		}
		else if(e.getSource() == exitButton) {
			this.dispose();
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(e.getSource() == idField) {
				passwordField.grabFocus();
			}
			else if(e.getSource() == passwordField) {
				openSystemFrame();
			}
		}
		else if(e.getKeyCode() == KeyEvent.VK_UP) {
			if(e.getSource() == passwordField) {
				idField.grabFocus();
			}
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			if(e.getSource() == idField) {
				passwordField.grabFocus();
			}
		}
		else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			this.dispose();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
}
