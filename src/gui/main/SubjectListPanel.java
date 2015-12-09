package gui.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;

import javax.swing.JButton;

import gui.simple.SimpleJPanel;

public class SubjectListPanel extends SimpleJPanel{

	private static final long serialVersionUID = -4536399276963790054L;

	private ArrayList<JButton> subjectListButton;
	private int currentIndex;
	
	public SubjectListPanel() {
		subjectListButton = new ArrayList<JButton>();
		
		getSubjectListFromServer();
		
		currentIndex = 0;
	}

	public void getSubjectListFromServer() {
		// TODO get subject list from server and make the list
		String subjectName = null;
		JButton tempButton = null;
		
		tempButton = new JButton("µ•¿Ã≈∏ ∫£¿ÃΩ∫");
		tempButton.setBackground(Color.WHITE);
		tempButton.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 16));
		tempButton.setBorder(null);
		tempButton.setOpaque(true);
		tempButton.setFocusPainted(false);
		tempButton.addFocusListener(this);
		tempButton.addMouseWheelListener(this);
		tempButton.addMouseListener(this);
		//tempButton.setForeground(Color.WHITE);
		//tempButton.setBackground(GUIData.buttonColorBlue);
		getSubjectListButton().add(tempButton);
		
		for(int i = 0; i < 15; i++) {
			subjectName = "Subject List #" + i;
			
			tempButton = new JButton(subjectName);
			tempButton.setBackground(Color.WHITE);
			tempButton.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 16));
			tempButton.setBorder(null);
			tempButton.setOpaque(true);
			tempButton.setFocusPainted(false);
			tempButton.addFocusListener(this);
			tempButton.addMouseWheelListener(this);
			tempButton.addMouseListener(this);
			//tempButton.setForeground(Color.WHITE);
			//tempButton.setBackground(GUIData.buttonColorBlue);
			getSubjectListButton().add(tempButton);
		}
		
		viewList(currentIndex);
	}
	
	public void viewList(int index) {
		this.removeAll();
		int j = 0;
		
		for(int i = currentIndex; i < currentIndex + 10; i++) {
			if(i >= getSubjectListButton().size()) break;
			
			this.add(getSubjectListButton().get(i)).setBounds(2, 61 * j + 5, 347, 61);
			j++;
		}
		
		this.repaint();
	}

	public ArrayList<JButton> getSubjectListButton() {
		return subjectListButton;
	}

	public void setSubjectListButton(ArrayList<JButton> subjectListButton) {
		this.subjectListButton = subjectListButton;
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		for(int i = currentIndex; i < currentIndex + 10; i++) {
			if(i >= getSubjectListButton().size()) break;
			if(e.getSource() == getSubjectListButton().get(i)) {
				getSubjectListButton().get(i).grabFocus();
			}
		}
	}
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		for(int i = currentIndex; i < currentIndex + 10; i++) {
			if(e.getSource() == getSubjectListButton().get(i)) {
				if(e.getWheelRotation() < 0) {
					if(currentIndex > 0)
						currentIndex--;
					viewList(currentIndex);
					break;
				}
				else if(e.getWheelRotation() > 0) {
					if(currentIndex < getSubjectListButton().size() - 10)
						currentIndex++;
					viewList(currentIndex);
					break;
				}
			}
		}
	}

}
