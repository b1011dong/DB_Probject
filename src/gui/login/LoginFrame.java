package gui.login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import gui.data.GUIData;
import gui.simple.*;

public class LoginFrame extends SimpleJFrame implements ActionListener, KeyListener {
	
	private static final long serialVersionUID = -7950017324115720179L;
	
	private JLabel mainLabel;
	private JLabel idLabel;
	private JLabel passwordLabel;
	
	private JTextField idField;
	private JPasswordField passwordField;
	
	private JButton okButton;
	private JButton cancelButton;
	
	public LoginFrame(){
		super("LoginFrame", 300, 250);
		
		addComponents();
		
		idField.grabFocus();
	}
	
	public void addComponents() {
		mainLabel = new JLabel();
		mainLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 24));
		mainLabel.setForeground(new Color(60, 60, 60));
		mainLabel.setText("∞˙¡¶ ¡¶√‚ Ω√Ω∫≈€");
		mainLabel.setVisible(true);
		this.add(mainLabel).setBounds(55, 10, 200, 50);
		
		idLabel = new JLabel();
		idLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 14));
		idLabel.setForeground(new Color(60, 60, 60));
		idLabel.setText("ID");
		idLabel.setVisible(true);
		this.add(idLabel).setBounds(40, 60, 100, 50);
		
		passwordLabel = new JLabel();
		passwordLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 14));
		passwordLabel.setForeground(new Color(60, 60, 60));
		passwordLabel.setText("PASSWORD");
		passwordLabel.setVisible(true);
		this.add(passwordLabel).setBounds(40, 120, 100, 50);
		
		idField = new JTextField();
		idField.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 16));
		idField.setHorizontalAlignment(JPasswordField.LEFT);
		idField.setBorder(GUIData.buttonBorder2);
		idField.addKeyListener(this);
		this.add(idField).setBounds(40, 100, 210, 30);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 16));
		passwordField.setHorizontalAlignment(JPasswordField.LEFT);
		passwordField.setBorder(GUIData.buttonBorder2);
		passwordField.addKeyListener(this);
		this.add(passwordField).setBounds(40, 160, 210, 30);
		
		okButton = new JButton(" »Æ ¿Œ ");
		okButton.setBackground(Color.WHITE);
		okButton.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 14));
		okButton.setBorder(null);
		okButton.setOpaque(true);
		okButton.addActionListener(this);
		okButton.setFocusPainted(false);
		okButton.setForeground(Color.WHITE);
		okButton.setBackground(GUIData.buttonColor);
		okButton.addActionListener(this);
		okButton.addKeyListener(this);
		this.add(okButton).setBounds(40, 200, 80, 30);
		
		cancelButton = new JButton(" √Î º“ ");
		cancelButton.setBackground(Color.WHITE);
		cancelButton.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 14));
		cancelButton.setBorder(null);
		cancelButton.setOpaque(true);
		cancelButton.addActionListener(this);
		cancelButton.setFocusPainted(false);
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setBackground(GUIData.buttonColor);
		cancelButton.addActionListener(this);
		this.add(cancelButton).setBounds(170, 200, 80, 30);
	}
	
	public void openSystemFrame() {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == okButton) {
			
		}
		else if(e.getSource() == cancelButton) {
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
