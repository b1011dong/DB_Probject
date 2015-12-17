package gui.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
//import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import gui.data.GUIData;
import gui.simple.SimpleJPanel;

public class RightPanel extends SimpleJPanel{

	private static final long serialVersionUID = 2382632880666551084L;
	
	private AssignmentListPanel assignmentListPanel;
	private QnAListPanel qnAListPanel;
	
	private JLabel nameLabel;
	
	private JButton AssignmentButton;
	private JButton QnAButton;
	
	public RightPanel() {
		
	}
	
	public void addComponents(String subject, String professor) {
		nameLabel = new JLabel();
		nameLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 18));
		nameLabel.setForeground(new Color(60, 60, 60));
		nameLabel.setText(subject + " - " + professor);
		//nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		//nameLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, new Color(50, 50, 50), new Color(255, 255, 255)));
		nameLabel.setVisible(true);
		this.add(nameLabel).setBounds(10, 10, 830, 50);
		
		AssignmentButton = new JButton("°úÁ¦ °Ô½ÃÆÇ");
		AssignmentButton.setBackground(GUIData.buttonColorBlue);
		AssignmentButton.setForeground(Color.WHITE);
		AssignmentButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		AssignmentButton.setBorder(null);
		AssignmentButton.setOpaque(true);
		AssignmentButton.setFocusPainted(false);
		AssignmentButton.addActionListener(this);
		this.add(AssignmentButton).setBounds(600, 20, 100, 30);
		
		QnAButton = new JButton("Áú¹® °Ô½ÃÆÇ");
		QnAButton.setBackground(GUIData.buttonColorBlue);
		QnAButton.setForeground(Color.WHITE);
		QnAButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		QnAButton.setBorder(null);
		QnAButton.setOpaque(true);
		QnAButton.setFocusPainted(false);
		QnAButton.addActionListener(this);
		this.add(QnAButton).setBounds(720, 20, 100, 30);
	}
	
	public void addAssignmentListPanel() {
		removeComponents();
		
		assignmentListPanel = new AssignmentListPanel();
		
		QnAButton.setBackground(GUIData.buttonColorBlue);
		AssignmentButton.setBackground(GUIData.buttonColorOrange);
		
		assignmentListPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, new Color(50, 50, 50), new Color(255, 255, 255)));
		this.add(assignmentListPanel).setBounds(0, 70, this.getWidth(), this.getHeight() - 70);
		
		this.repaint();
	}
	
	public void addQnAListPanel() {
		removeComponents();
		
		qnAListPanel = new QnAListPanel();
		
		AssignmentButton.setBackground(GUIData.buttonColorBlue);
		QnAButton.setBackground(GUIData.buttonColorOrange);
		
		qnAListPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, new Color(50, 50, 50), new Color(255, 255, 255)));
		this.add(qnAListPanel).setBounds(0, 70, this.getWidth(), this.getHeight() - 70);
		
		this.repaint();
	}
	
	public void removeComponents() {
		if(qnAListPanel != null) this.remove(qnAListPanel);
		if(assignmentListPanel != null) this.remove(assignmentListPanel);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == AssignmentButton) {
			addAssignmentListPanel();
		}
		else if(e.getSource() == QnAButton) {
			addQnAListPanel();
		}
	}
	
}
