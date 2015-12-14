package gui.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import gui.simple.SimpleJPanel;

public class SubjectListPanel extends SimpleJPanel{

	private static final long serialVersionUID = -4536399276963790054L;
	private static final int MAX_LIST_NUM = 9;
	
	private JLabel remainedAboveLabel;
	private JLabel remainedBelowLabel;
	private ArrayList<JButton> subjectListButton;
	
	private int currentIndex;
	
	public SubjectListPanel(ActionListener motherListener) {
		subjectListButton = new ArrayList<JButton>();
		
		getSubjectListFromServer(motherListener);
		
		currentIndex = 0;
	}

	public void getSubjectListFromServer(ActionListener motherListener) {
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
		tempButton.addActionListener(motherListener);
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
			tempButton.addActionListener(motherListener);
			getSubjectListButton().add(tempButton);
		}
		
		viewList(currentIndex);
	}
	
	public void viewList(int index) {
		this.removeAll();
		int j = 0;
		
		for(int i = currentIndex; i < currentIndex + MAX_LIST_NUM; i++) {
			if(i >= getSubjectListButton().size()) break;
			
			this.add(getSubjectListButton().get(i)).setBounds(2, 62 * j + 30, 347, 62);
			j++;
		}
		
		remainedAboveLabel = new JLabel();
		remainedAboveLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 14));
		remainedAboveLabel.setForeground(new Color(60, 60, 60));
		remainedAboveLabel.setText("¿ß∑Œ " + Integer.toString(currentIndex) + "∞≥");
		remainedAboveLabel.setVisible(true);
		remainedAboveLabel.setHorizontalAlignment(SwingConstants.CENTER);
		remainedAboveLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, new Color(50, 50, 50), new Color(255, 255, 255)));
		this.add(remainedAboveLabel).setBounds(0, 0, 350, 30);
		
		int below = getSubjectListButton().size() - currentIndex - MAX_LIST_NUM;
		if(below <= 0) below = 0;
		
		remainedBelowLabel = new JLabel();
		remainedBelowLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 14));
		remainedBelowLabel.setForeground(new Color(60, 60, 60));
		remainedBelowLabel.setText("æ∆∑°∑Œ " + Integer.toString(below) + "∞≥");
		remainedBelowLabel.setVisible(true);
		remainedBelowLabel.setHorizontalAlignment(SwingConstants.CENTER);
		remainedBelowLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, new Color(50, 50, 50), new Color(255, 255, 255)));
		this.add(remainedBelowLabel).setBounds(0, 590, 350, 30);
		
		this.repaint();
	}

	public ArrayList<JButton> getSubjectListButton() {
		return subjectListButton;
	}

	public void setSubjectListButton(ArrayList<JButton> subjectListButton) {
		this.subjectListButton = subjectListButton;
	}
	
	public int getCurrentIndex() {
		return this.currentIndex;
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		for(int i = currentIndex; i < currentIndex + MAX_LIST_NUM; i++) {
			if(i >= getSubjectListButton().size()) break;
			if(e.getSource() == getSubjectListButton().get(i)) {
				getSubjectListButton().get(i).grabFocus();
			}
		}
	}
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		for(int i = currentIndex; i < currentIndex + MAX_LIST_NUM; i++) {
			if(e.getSource() == getSubjectListButton().get(i)) {
				if(e.getWheelRotation() < 0) {
					if(currentIndex > 0)
						currentIndex--;
					viewList(currentIndex);
					break;
				}
				else if(e.getWheelRotation() > 0) {
					if(currentIndex < getSubjectListButton().size() - MAX_LIST_NUM)
						currentIndex++;
					viewList(currentIndex);
					break;
				}
			}
		}
	}

}
