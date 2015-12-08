package gui.main;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;

import gui.data.GUIControler;
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
	
	private JLabel userNameLabel;
	
	public MainFrame() {
		super("MainFrame", 1280, 720);
		
		addComponents();
		
		this.minimizeButton.addActionListener(this);
		this.exitButton.addActionListener(this);
	}

	public void addComponents() {
		
		String name = "박영철";
		
		//if(professor) {
		userNameLabel = GUIControler.addSmallLabel(this, userNameLabel, "교수 " + name, 20, 0);
		//}
		//else if(assistant) {
		//	userNameLabel = GUIControler.addSmallLabel(this, userNameLabel, "조교 " + name, 20, 0);
		//}
		//else if(student) {
		//	userNameLabel = GUIControler.addSmallLabel(this, userNameLabel, "학생 " + name, 20, 0);
		//}
	}
	
	public void subjectListPanel() {
		
	}
	
	public void assignmentListPanel() {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == minimizeButton) {
			this.setState(Frame.ICONIFIED);
		}
		else if(e.getSource() == exitButton) {
			this.dispose();
		}
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

}
