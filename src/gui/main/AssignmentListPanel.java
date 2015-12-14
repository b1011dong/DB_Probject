package gui.main;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import gui.simple.SimpleJPanel;

public class AssignmentListPanel extends SimpleJPanel{

	private static final long serialVersionUID = 2382632880666551084L;
	
	private JLabel nameLabel;
	
	public AssignmentListPanel() {
		
	}

	public void addComponents(String subject, String professor) {
		nameLabel = new JLabel();
		nameLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 18));
		nameLabel.setForeground(new Color(60, 60, 60));
		nameLabel.setText(subject + " - " + professor);
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, new Color(50, 50, 50), new Color(255, 255, 255)));
		nameLabel.setVisible(true);
		this.add(nameLabel).setBounds(10, 10, 830, 50);
		
		
	}
	
	public void getSubjectDataFromServer(String subject) {
		// TODO get selected subject data from server and set the panel
		addComponents(subject, "¹Ú¿µÃ¶");
	}
	
}
