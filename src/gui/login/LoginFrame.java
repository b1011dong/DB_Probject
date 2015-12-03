package gui.login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import gui.data.GUIData;
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
		mainLabel = new JLabel();
		mainLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 24));
		mainLabel.setForeground(new Color(60, 60, 60));
		mainLabel.setText("∞˙¡¶ ¡¶√‚ Ω√Ω∫≈€");
		mainLabel.setVisible(true);
		this.add(mainLabel).setBounds(110, 30, 200, 50);
		
		idLabel = new JLabel();
		idLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 14));
		idLabel.setForeground(new Color(60, 60, 60));
		idLabel.setText("ID");
		idLabel.setVisible(true);
		this.add(idLabel).setBounds(40, 90, 100, 50);
		
		passwordLabel = new JLabel();
		passwordLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 14));
		passwordLabel.setForeground(new Color(60, 60, 60));
		passwordLabel.setText("PASSWORD");
		passwordLabel.setVisible(true);
		this.add(passwordLabel).setBounds(40, 150, 100, 50);
		
		idField = new JTextField();
		idField.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 16));
		idField.setHorizontalAlignment(JPasswordField.LEFT);
		idField.setBorder(GUIData.buttonBorder2);
		idField.addKeyListener(this);
		this.add(idField).setBounds(40, 130, 310, 30);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 16));
		passwordField.setHorizontalAlignment(JPasswordField.LEFT);
		passwordField.setBorder(GUIData.buttonBorder2);
		passwordField.addKeyListener(this);
		this.add(passwordField).setBounds(40, 190, 310, 30);
		
		okButton = new JButton(" »Æ ¿Œ ");
		okButton.setBackground(Color.WHITE);
		okButton.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 14));
		okButton.setBorder(null);
		okButton.setOpaque(true);
		okButton.setFocusPainted(false);
		okButton.setForeground(Color.WHITE);
		okButton.setBackground(GUIData.buttonColor);
		okButton.addKeyListener(this);
		okButton.addActionListener(this);
		this.add(okButton).setBounds(40, 230, 80, 30);
		
		cancelButton = new JButton(" √Î º“ ");
		cancelButton.setBackground(Color.WHITE);
		cancelButton.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 14));
		cancelButton.setBorder(null);
		cancelButton.setOpaque(true);
		cancelButton.addActionListener(this);
		cancelButton.setFocusPainted(false);
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setBackground(GUIData.buttonColor);
		this.add(cancelButton).setBounds(155, 230, 80, 30);
		
		signupButton = new JButton(" ∞° ¿‘ ");
		signupButton.setBackground(Color.WHITE);
		signupButton.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 14));
		signupButton.setBorder(null);
		signupButton.setOpaque(true);
		signupButton.addActionListener(this);
		signupButton.setFocusPainted(false);
		signupButton.setForeground(Color.WHITE);
		signupButton.setBackground(GUIData.buttonColor);
		this.add(signupButton).setBounds(270, 230, 80, 30);
		
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
	}
	
	public void openSignupFrame() {
		@SuppressWarnings("unused")
		SignupFrame signupFrame = new SignupFrame();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == okButton) {
			
		}
		else if(e.getSource() == cancelButton) {
			this.dispose();
		}
		else if(e.getSource() == signupButton) {
			openSignupFrame();
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
