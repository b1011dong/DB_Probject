package gui.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import gui.data.GUIData;
import gui.simple.SimpleJPanel;

abstract public class RightContentPanel extends SimpleJPanel{

	private static final long serialVersionUID = 4587125230757189276L;
	protected static final int MAX_LIST_NUM = 8;

	private AssignmentPanel assignmentPanel;
	private QuestionPanel questionPanel;
	
	private JLabel remainedAboveLabel;
	private JLabel remainedBelowLabel;
	
	private ArrayList<JButton> listButton;
	
	private JButton writeButton;
	
	private int currentIndex;
	
	public RightContentPanel() {
		addComponents();
	}
	
	abstract public void makeList();
	abstract public void openEditPanel();
	abstract public void openEditPanel(int index);
	
	public void addComponents() {
		listButton = new ArrayList<JButton>();
		
		setCurrentIndex(0);
		
		makeList();
		
		viewList(getCurrentIndex());
	}
	
	public void viewList(int index) {
		this.removeAll();
		int j = 0;
		
		for(int i = currentIndex; i < currentIndex + MAX_LIST_NUM; i++) {
			if(i >= listButton.size()) break;
			
			this.add(listButton.get(i)).setBounds(10, 52 * j + 30, 830, 52);
			j++;
		}
		
		remainedAboveLabel = new JLabel();
		remainedAboveLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
		remainedAboveLabel.setForeground(new Color(60, 60, 60));
		remainedAboveLabel.setText("À§·Î " + Integer.toString(currentIndex) + "°³");
		remainedAboveLabel.setVisible(true);
		remainedAboveLabel.setHorizontalAlignment(SwingConstants.CENTER);
		remainedAboveLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, new Color(50, 50, 50), new Color(255, 255, 255)));
		this.add(remainedAboveLabel).setBounds(0, 0, 850, 30);
		
		int below = listButton.size() - currentIndex - MAX_LIST_NUM;
		if(below <= 0) below = 0;
		
		remainedBelowLabel = new JLabel();
		remainedBelowLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
		remainedBelowLabel.setForeground(new Color(60, 60, 60));
		remainedBelowLabel.setText("¾Æ·¡·Î " + Integer.toString(below) + "°³");
		remainedBelowLabel.setVisible(true);
		remainedBelowLabel.setHorizontalAlignment(SwingConstants.CENTER);
		remainedBelowLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, new Color(50, 50, 50), new Color(255, 255, 255)));
		this.add(remainedBelowLabel).setBounds(0, 445, 850, 30);
		
		writeButton = new JButton("±Û¾²±â");
		writeButton.setBackground(Color.WHITE);
		writeButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		writeButton.setBorder(null);
		writeButton.setOpaque(true);
		writeButton.setFocusPainted(false);
		writeButton.setForeground(Color.WHITE);
		writeButton.setBackground(GUIData.buttonColorBlue);
		writeButton.addActionListener(this);
		this.add(writeButton).setBounds(730, 500, 80, 30);
		
		this.repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == writeButton) {
			openEditPanel();
		}
		else {
			for(int i = 0; i < listButton.size(); i++) {
				if(e.getSource() == listButton.get(i)) {
					openEditPanel(i);
				}
			}
		}
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		for(int i = currentIndex; i < currentIndex + MAX_LIST_NUM; i++) {
			if(i >= listButton.size()) break;
			if(e.getSource() == listButton.get(i)) {
				listButton.get(i).grabFocus();
			}
		}
	}
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		for(int i = currentIndex; i < currentIndex + MAX_LIST_NUM; i++) {
			if(e.getSource() == listButton.get(i)) {
				if(e.getWheelRotation() < 0) {
					if(currentIndex > 0)
						currentIndex--;
					viewList(currentIndex);
					break;
				}
				else if(e.getWheelRotation() > 0) {
					if(currentIndex < listButton.size() - MAX_LIST_NUM)
						currentIndex++;
					viewList(currentIndex);
					break;
				}
			}
		}
	}

	public JLabel getRemainedAboveLabel() {
		return remainedAboveLabel;
	}

	public void setRemainedAboveLabel(JLabel remainedAboveLabel) {
		this.remainedAboveLabel = remainedAboveLabel;
	}

	public JLabel getRemainedBelowLabel() {
		return remainedBelowLabel;
	}

	public void setRemainedBelowLabel(JLabel remainedBelowLabel) {
		this.remainedBelowLabel = remainedBelowLabel;
	}

	public ArrayList<JButton> getListButton() {
		return listButton;
	}

	public void setListButton(ArrayList<JButton> listButton) {
		this.listButton = listButton;
	}

	public int getCurrentIndex() {
		return currentIndex;
	}

	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}
	
	public JButton getWriteButton() {
		return this.writeButton;
	}

	public AssignmentPanel getAssignmentPanel() {
		return assignmentPanel;
	}

	public void setAssignmentPanel(AssignmentPanel assignmentPanel) {
		this.assignmentPanel = assignmentPanel;
	}

	public QuestionPanel getQuestionPanel() {
		return questionPanel;
	}

	public void setQuestionPanel(QuestionPanel questionPanel) {
		this.questionPanel = questionPanel;
	}
}
