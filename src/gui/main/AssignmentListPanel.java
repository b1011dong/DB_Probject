package gui.main;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class AssignmentListPanel extends RightContentPanel{

	private static final long serialVersionUID = 2382632880666551084L;
	
	public AssignmentListPanel() {
		super();
		
		// TODO if student, remove writeButton
		// getWriteButton().setVisible(false);
	}
	
	@Override
	public void makeList() {
		String assignmentName = null;
		JButton tempButton = null;
		
		for(int i = 0; i < 15; i++) {
			assignmentName = "Assignment List #" + i;
			
			tempButton = new JButton(assignmentName);
			tempButton.setBackground(Color.WHITE);
			tempButton.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
			tempButton.setBorder(null);
			//tempButton.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, new Color(50, 50, 50), new Color(255, 255, 255)));
			tempButton.setOpaque(true);
			tempButton.setFocusPainted(false);
			tempButton.addFocusListener(this);
			tempButton.addMouseWheelListener(this);
			tempButton.addMouseListener(this);
			tempButton.addActionListener(this);
			getListButton().add(tempButton);
		}
		
		viewList(getCurrentIndex());
	}

	@Override
	public void openEditPanel() {
		this.removeAll();
		
		setAssignmentPanel(new AssignmentPanel("", "", ""));
		this.add(getAssignmentPanel()).setBounds(0, 0, this.getWidth(), this.getHeight());
		
		getAssignmentPanel().getOkButton().addActionListener(this);
		getAssignmentPanel().getCancelButton().addActionListener(this);
		
		this.repaint();
	}

	@Override
	public void openEditPanel(int index) {
		this.removeAll();
		
		setAssignmentPanel(new AssignmentPanel(this.getListButton().get(getCurrentIndex()).getText(), "", ""));
		this.add(getAssignmentPanel()).setBounds(0, 0, this.getWidth(), this.getHeight());
		
		getAssignmentPanel().getOkButton().addActionListener(this);
		getAssignmentPanel().getCancelButton().addActionListener(this);
		
		this.repaint();
	}
}
