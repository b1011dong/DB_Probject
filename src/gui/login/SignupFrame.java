package gui.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;

import gui.data.GUIData;
import gui.simple.SimpleJFrame;

public class SignupFrame extends SimpleJFrame implements ActionListener, KeyListener{

	private static final long serialVersionUID = -2859575932051396428L;

	private JButton okButton;
	private JButton cancelButton;
	
	public SignupFrame() {
		super("SignupFrame", 400, 500);
		
		addComponents();
	}
	
	public void addComponents() {
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
		cancelButton.addActionListener(this);
		this.add(cancelButton).setBounds(155, 230, 80, 30);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource() == okButton) {
			
		}
		else if(e.getSource() == cancelButton) {
			this.dispose();
		}
	}

}
