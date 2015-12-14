package gui.login;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

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
	private JLabel warningLabel;
	
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
		
		mainLabel = GUIControler.addBigLabel(this, mainLabel, "ȸ�� ����", 150, 30);
		
		idLabel = GUIControler.addSmallLabel(this, idLabel, "���̵�", 40, 90);
		passwordLabel = GUIControler.addSmallLabel(this, passwordLabel, "��й�ȣ", 40, 150);
		passwordCheckLabel = GUIControler.addSmallLabel(this, passwordCheckLabel, "��й�ȣ Ȯ��", 40, 210);
		authortyLabel = GUIControler.addSmallLabel(this, authortyLabel, "����", 40, 270);
		majorLabel = GUIControler.addSmallLabel(this, majorLabel, "����/�Ҽ�", 40, 330);
		numberLabel = GUIControler.addSmallLabel(this, numberLabel, "�л� ��ȣ", 40, 390);
		nameLabel = GUIControler.addSmallLabel(this, nameLabel, "�̸�", 40, 450);
		phoneLabel = GUIControler.addSmallLabel(this, phoneLabel, "��ȭ��ȣ", 40, 510);
		emailLabel_pre = GUIControler.addSmallLabel(this, emailLabel_pre, "�̸���", 40, 570);
		emailLabel_at = GUIControler.addSmallLabel(this, emailLabel_at, "@", 190, 600);
		warningLabel = GUIControler.addSmallLabel(this, warningLabel, "", 100, 60);
		warningLabel.setHorizontalAlignment(SwingConstants.CENTER);
		warningLabel.setForeground(Color.RED);
		
		idField = GUIControler.addTextField(this, idField, 40, 130, 310, 30);
		passwordField = GUIControler.addPasswordField(this, passwordField, 40, 190, 310, 30);
		passwordCheckField = GUIControler.addPasswordField(this, passwordCheckField, 40, 250, 310, 30);
		majorField = GUIControler.addTextField(this, majorField, 40, 370, 310, 30);
		numberField = GUIControler.addTextField(this, numberField, 40, 430, 310, 30);
		nameField = GUIControler.addTextField(this, nameField, 40, 490, 310, 30);
		phoneField = GUIControler.addTextField(this, phoneField, 40, 550, 310, 30);
		emailField_pre = GUIControler.addTextField(this, emailField_pre, 40, 610, 140, 30);
		emailField_post = GUIControler.addTextField(this, emailField_post, 210, 610, 140, 30);
		
		okButton = GUIControler.addButton(this, okButton, " Ȯ �� ", 90, 690);
		cancelButton = GUIControler.addButton(this, cancelButton, " �� �� ", 230, 690);
		
		authorityButtonGroup = new ButtonGroup();
		
		professorRadioButton = GUIControler.addJRadioButton(this, authorityButtonGroup, professorRadioButton, "����", 40, 310);
		assistantRadioButton = GUIControler.addJRadioButton(this, authorityButtonGroup, assistantRadioButton, "����", 150, 310);
		studentRadioButton = GUIControler.addJRadioButton(this, authorityButtonGroup, studentRadioButton, "�л�", 260, 310);
		
		phoneField.addFocusListener(this);
		phoneField.setText("��) 01012345678");
		phoneField.setForeground(new Color(150, 150, 150));
		
		this.minimizeButton.addActionListener(this);
		this.exitButton.addActionListener(this);
	}
	
	public void signup() {
		if(validCheck() == true) {
		// TODO signup need to be implemented
		
		@SuppressWarnings("unused")
		LoginFrame loginFrame = new LoginFrame();
		
		this.dispose();
		}
	}
	
	public boolean validCheck() {
		JComponent nullComponent = nullCheck();
		
		if(nullComponent != null) {
			nullComponent.grabFocus();
			
			return false;
		}
		
		if(passwordCheck() == false) return false;
		
		return true;
	}
	
	public boolean passwordCheck() {
		
		if(Arrays.equals(passwordField.getPassword(), passwordCheckField.getPassword()))
			return true;
		
		warningLabel.setText("Ȯ�� ��й�ȣ�� �ٸ��ϴ�.");
		
		passwordCheckField.setText("");
		passwordCheckField.grabFocus();
		
		return false;
	}
	
	public JComponent nullCheck() {
		JComponent nullComponent = null;
		String nullName = null;
		
		if(idField.getText().isEmpty()) {
			nullName = "���̵�";
			nullComponent = idField;
		}
		else if(passwordField.getPassword().length == 0) {
			nullName = "��й�ȣ";
			nullComponent = passwordField;
		}
		else if(authorityButtonGroup.getSelection() == null) {
			nullName = "����";
			nullComponent = professorRadioButton;
		}
		else if(majorField.getText().isEmpty()) {
			nullName = "����/�Ҽ�";
			nullComponent = majorField;
		}
		else if(numberField.getText().isEmpty()) {
			nullName = "��ȣ";
			nullComponent = numberField;
		}
		else if(nameField.getText().isEmpty()) {
			nullName = "�̸�";
			nullComponent = nameField;
		}
		else if(phoneField.getText().isEmpty() || phoneField.getText().equals("��) 01012345678")) {
			nullName = "��ȭ��ȣ";
			nullComponent = phoneField;
		}
		else if(emailField_pre.getText().isEmpty()) {
			nullName = "�̸���";
			nullComponent = emailField_pre;
		}
		else if(emailField_post.getText().isEmpty()) {
			nullName = "�̸���";
			nullComponent = emailField_post;
		}
		
		if(nullComponent != null)
			warningLabel.setText(nullName + " �׸��� ������ϴ�.");
		
		return nullComponent;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == okButton) {
			signup();
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
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(e.getSource() == idField) {
				passwordField.grabFocus();
			}
			else if(e.getSource() == passwordField) {
				passwordCheckField.grabFocus();
			}
			else if(e.getSource() == passwordCheckField) {
				if(authorityButtonGroup.getSelection() == professorRadioButton.getModel()) {
					professorRadioButton.grabFocus();
				}
				else if(authorityButtonGroup.getSelection() == assistantRadioButton.getModel()) {
					assistantRadioButton.grabFocus();
				}
				else if(authorityButtonGroup.getSelection() == studentRadioButton.getModel()) {
					studentRadioButton.grabFocus();
				}
				else {
					professorRadioButton.grabFocus();
				}
			}
			else if(e.getSource() == professorRadioButton) {
				majorField.grabFocus();
			}
			else if(e.getSource() == assistantRadioButton) {
				majorField.grabFocus();	
			}
			else if(e.getSource() == studentRadioButton) {
				majorField.grabFocus();
			}
			else if(e.getSource() == majorField) {
				numberField.grabFocus();
			}
			else if(e.getSource() == numberField) {
				nameField.grabFocus();
			}
			else if(e.getSource() == nameField) {
				phoneField.grabFocus();
			}
			else if(e.getSource() == phoneField) {
				emailField_pre.grabFocus();
			}
			else if(e.getSource() == emailField_pre) {
				emailField_post.grabFocus();
			}
			else if(e.getSource() == emailField_post) {
				signup();
			}
		}
		else if(e.getKeyCode() == KeyEvent.VK_UP) {
			if(e.getSource() == passwordField) {
				idField.grabFocus();
			}
			else if(e.getSource() == passwordCheckField) {
				passwordField.grabFocus();
			}
			else if(e.getSource() == majorField) {
				if(authorityButtonGroup.getSelection() == professorRadioButton.getModel()) {
					professorRadioButton.grabFocus();
				}
				else if(authorityButtonGroup.getSelection() == assistantRadioButton.getModel()) {
					assistantRadioButton.grabFocus();
				}
				else if(authorityButtonGroup.getSelection() == studentRadioButton.getModel()) {
					studentRadioButton.grabFocus();
				}
				else {
					professorRadioButton.grabFocus();
				}
			}
			else if(e.getSource() == numberField) {
				majorField.grabFocus();
			}
			else if(e.getSource() == nameField) {
				numberField.grabFocus();
			}
			else if(e.getSource() == phoneField) {
				nameField.grabFocus();
			}
			else if(e.getSource() == emailField_pre) {
				phoneField.grabFocus();
			}
			else if(e.getSource() == emailField_post) {
				emailField_pre.grabFocus();
			}
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			if(e.getSource() == idField) {
				passwordField.grabFocus();
			}
			else if(e.getSource() == passwordField) {
				passwordCheckField.grabFocus();
			}
			else if(e.getSource() == passwordCheckField) {
				if(authorityButtonGroup.getSelection() == professorRadioButton.getModel()) {
					professorRadioButton.grabFocus();
				}
				else if(authorityButtonGroup.getSelection() == assistantRadioButton.getModel()) {
					assistantRadioButton.grabFocus();
				}
				else if(authorityButtonGroup.getSelection() == studentRadioButton.getModel()) {
					studentRadioButton.grabFocus();
				}
				else {
					professorRadioButton.grabFocus();
				}
			}
			else if(e.getSource() == majorField) {
				numberField.grabFocus();
			}
			else if(e.getSource() == numberField) {
				nameField.grabFocus();
			}
			else if(e.getSource() == nameField) {
				phoneField.grabFocus();
			}
			else if(e.getSource() == phoneField) {
				emailField_pre.grabFocus();
			}
			else if(e.getSource() == emailField_pre) {
				emailField_post.grabFocus();
			}
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
			if(phoneField.getText().equals("��) 01012345678")) {
				phoneField.setText("");
				phoneField.setForeground(new Color(0, 0, 0));
			}
		}
		
		if(e.getSource() == professorRadioButton) {
			numberLabel.setText("���� ��ȣ");
		}
		else if(e.getSource() == assistantRadioButton) {
			numberLabel.setText("���� ��ȣ");
		}
		else if(e.getSource() == studentRadioButton) {
			numberLabel.setText("�л� ��ȣ");
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(e.getSource() == phoneField) {
			if(phoneField.getText().equals("��) 01012345678") || phoneField.getText().equals("")) {
				phoneField.setText("��) 01012345678");
				phoneField.setForeground(GUIData.grayColor);
			}
		}
	}

}
