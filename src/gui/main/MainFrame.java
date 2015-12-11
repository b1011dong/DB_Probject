package gui.main;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import gui.data.GUIControler;
import gui.data.GUIData;
import gui.login.LoginFrame;
import gui.simple.SimpleJFrame;

/**
 * This frame is for main system view
 * @author Dongwon
 *
 */
public class MainFrame extends SimpleJFrame implements ActionListener, KeyListener {

	private static final long serialVersionUID = -4004556136944490550L;

	private SubjectListPanel subjectListPanel;
	private AssignmentListPanel assignmentListPanel;
	
	private JButton backToLoginButton;
	private JButton backButton;
	
	private JLabel userNameLabel;
	
	public MainFrame(String userName) {
		super("MainFrame", 1280, 720);
		
		addComponents(userName);
		
		this.minimizeButton.addActionListener(this);
		this.exitButton.addActionListener(this);
	}

	public void addComponents(String userName) {

		userNameLabel = GUIControler.addSmallLabel(this, userNameLabel, userName, 110, 0);
		
		subjectList();
		assignmentList();
		
		backToLoginButton = GUIControler.addButton(this, backToLoginButton, "로그아웃", 20, 10);
		backButton = GUIControler.addButton(this, backButton, " 뒤 로 ", 400, 10);
	}
	
	public void subjectList() {
		subjectListPanel = new SubjectListPanel(this);
		
		this.add(subjectListPanel).setBounds(20, 50, 350, 620);
	}
	
	public void assignmentList() {
		assignmentListPanel = new AssignmentListPanel();
		
		this.add(assignmentListPanel).setBounds(400, 50, 850, 620);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == minimizeButton) {
			this.setState(Frame.ICONIFIED);
		}
		else if(e.getSource() == exitButton) {
			this.dispose();
		}
		else if(e.getSource() == backToLoginButton) {
			@SuppressWarnings("unused")
			LoginFrame loginFrame = new LoginFrame();
			
			// TODO logout need to be implemented
			
			this.dispose();
		}
		else if(e.getSource() == backButton) {
			// TODO back need to be implemented
		}
		
		for(int i = 0; i < subjectListPanel.getSubjectListButton().size(); i++) {
			subjectListPanel.getSubjectListButton().get(i).setBackground(Color.WHITE);
			if(e.getSource() == subjectListPanel.getSubjectListButton().get(i)) {
				subjectListPanel.getSubjectListButton().get(i).setBackground(GUIData.buttonColorOrange);
				
				assignmentListPanel.removeAll();
				assignmentListPanel.getSubjectDataFromServer(subjectListPanel.getSubjectListButton().get(i).getText());
			}
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
