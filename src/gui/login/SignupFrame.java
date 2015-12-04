package gui.login;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import gui.data.GUIControler;
import gui.data.GUIData;
import gui.simple.SimpleJFrame;

/**
 * This frame is for viewing the signup page
 * @author Dongwon
 *
 */
public class SignupFrame extends SimpleJFrame implements ActionListener, KeyListener, FocusListener{

	private static final long serialVersionUID = -2859575932051396428L;

	private JLabel mainLabel;
	
	private JLabel idLabel;
	private JLabel passwordLabel;
	private JLabel passwordCheckLabel;
	private JLabel authortyLabel;
	private JLabel majorLabel;
	private JLabel numberLabel;
	private JLabel nameLabel;
	private JLabel phoneLabel;
	private JLabel emailLabel_pre;
	private JLabel emailLabel_at;
	
	private JTextField idField;
	private JPasswordField passwordField;
	private JPasswordField passwordCheckField;
	private JTextField majorField;
	private JTextField numberField;
	private JTextField nameField;
	private JTextField phoneField;
	private JTextField emailField_pre;
	private JTextField emailField_post;
	
	private ButtonGroup authorityButtonGroup;
	
	private JRadioButton professorRadioButton;
	private JRadioButton assistantRadioButton;
	private JRadioButton studentRadioButton;
	
	private JButton okButton;
	private JButton cancelButton;
	
	public SignupFrame() {
		super("SignupFrame", 400, 750);
		
		addComponents();
		
		idField.grabFocus();
	}
	
	public void addComponents() {
		
		mainLabel = GUIControler.addBigLabel(this, mainLabel, "회원 가입", 150, 30);
		
		idLabel = GUIControler.addSmallLabel(this, idLabel, "ID", 40, 90);
		passwordLabel = GUIControler.addSmallLabel(this, passwordLabel, "PASSWORD", 40, 150);
		passwordCheckLabel = GUIControler.addSmallLabel(this, passwordCheckLabel, "PASSWORD CHECK", 40, 210);
		authortyLabel = GUIControler.addSmallLabel(this, authortyLabel, "AUTHORITY", 40, 270);
		majorLabel = GUIControler.addSmallLabel(this, majorLabel, "MAJOR", 40, 330);
		numberLabel = GUIControler.addSmallLabel(this, numberLabel, "STUDENT ID", 40, 390);
		nameLabel = GUIControler.addSmallLabel(this, nameLabel, "NAME", 40, 450);
		phoneLabel = GUIControler.addSmallLabel(this, phoneLabel, "PHONE", 40, 510);
		emailLabel_pre = GUIControler.addSmallLabel(this, emailLabel_pre, "EMAIL", 40, 570);
		emailLabel_at = GUIControler.addSmallLabel(this, emailLabel_at, "@", 190, 600);
		
		idField = GUIControler.addTextField(this, idField, 40, 130, 310, 30);
		passwordField = GUIControler.addPasswordField(this, passwordField, 40, 190, 310, 30);
		passwordCheckField = GUIControler.addPasswordField(this, passwordCheckField, 40, 250, 310, 30);
		majorField = GUIControler.addTextField(this, majorField, 40, 370, 310, 30);
		numberField = GUIControler.addTextField(this, numberField, 40, 430, 310, 30);
		nameField = GUIControler.addTextField(this, nameField, 40, 490, 310, 30);
		phoneField = GUIControler.addTextField(this, phoneField, 40, 550, 310, 30);
		emailField_pre = GUIControler.addTextField(this, emailField_pre, 40, 610, 140, 30);
		emailField_post = GUIControler.addTextField(this, emailField_post, 210, 610, 140, 30);
		
		okButton = GUIControler.addButton(this, okButton, " 확 인 ", 90, 690);
		cancelButton = GUIControler.addButton(this, cancelButton, " 취 소 ", 230, 690);
		
		authorityButtonGroup = new ButtonGroup();
		
		professorRadioButton = GUIControler.addJRadioButton(this, authorityButtonGroup, professorRadioButton, "PROFESSOR", 40, 310);
		assistantRadioButton = GUIControler.addJRadioButton(this, authorityButtonGroup, assistantRadioButton, "ASSISTANT", 150, 310);
		studentRadioButton = GUIControler.addJRadioButton(this, authorityButtonGroup, studentRadioButton, "STUDENT", 260, 310);
		
		phoneField.addFocusListener(this);
		phoneField.setText("ex) 01012345678");
		phoneField.setForeground(new Color(150, 150, 150));
		
		this.minimizeButton.addActionListener(this);
		this.exitButton.addActionListener(this);
	}
	
	public void signup() {
		JOptionPane.showMessageDialog(this, "Signup!");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == okButton) {
			@SuppressWarnings("unused")
			LoginFrame loginFrame = new LoginFrame();
			
			signup();
			
			this.dispose();
		}
		else if(e.getSource() == cancelButton) {
			@SuppressWarnings("unused")
			LoginFrame loginFrame = new LoginFrame();
			
			this.dispose();
		}
		else if(e.getSource() == minimizeButton) {
			this.setState(Frame.ICONIFIED);
		}
		else if(e.getSource() == exitButton) {
			@SuppressWarnings("unused")
			LoginFrame loginFrame = new LoginFrame();
			
			this.dispose();
		}
		else if(e.getSource() == professorRadioButton) {
			numberLabel.setText("PROFESSOR ID");
		}
		else if(e.getSource() == assistantRadioButton) {
			numberLabel.setText("ASSISTANT ID");
		}
		else if(e.getSource() == studentRadioButton) {
			numberLabel.setText("STUDENT ID");
		}
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			
		}
		else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			@SuppressWarnings("unused")
			LoginFrame loginFrame = new LoginFrame();
			
			this.dispose();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void focusGained(FocusEvent e) {
		if(e.getSource() == phoneField) {
			if(phoneField.getText().equals("ex) 01012345678")) {
				phoneField.setText("");
				phoneField.setForeground(new Color(0, 0, 0));
			}
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(e.getSource() == phoneField) {
			if(phoneField.getText().equals("ex) 01012345678") || phoneField.getText().equals("")) {
				phoneField.setText("ex) 01012345678");
				phoneField.setForeground(GUIData.grayColor);
			}
		}
	}

}
