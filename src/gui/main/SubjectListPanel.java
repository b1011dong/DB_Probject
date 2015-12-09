package gui.main;

import java.util.ArrayList;

import javax.swing.JButton;

import gui.data.GUIControler;
import gui.simple.SimpleJPanel;

public class SubjectListPanel extends SimpleJPanel{

	private static final long serialVersionUID = -4536399276963790054L;

	private ArrayList<JButton> subjectListButton;
	
	public SubjectListPanel() {
		subjectListButton = new ArrayList<JButton>();
		
		getSubjectListFromServer();
	}

	public void getSubjectListFromServer() {
		// TODO get subject list from server and make the list
		JButton tempButton = new JButton();
		getSubjectListButton().add(tempButton);
	}

	public ArrayList<JButton> getSubjectListButton() {
		return subjectListButton;
	}

	public void setSubjectListButton(ArrayList<JButton> subjectListButton) {
		this.subjectListButton = subjectListButton;
	}

}
