package gui.main;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import gui.data.GUIData;
import gui.simple.SimpleJPanel;

public class AssignmentPanel extends SimpleJPanel{

	private static final long serialVersionUID = -3636565510108305472L;
	
	private JTextField nameTextField;
	private JTextArea contentTextArea;
	
	private JButton okButton;
	private JButton cancelButton;
	
	public AssignmentPanel() {
		addComponents();
	}
	
	public void addComponents() {
		nameTextField = new JTextField();
		nameTextField.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		nameTextField.setHorizontalAlignment(JPasswordField.LEFT);
		nameTextField.setBorder(GUIData.buttonBorder2);
		this.add(nameTextField).setBounds(100, 50, 700, 30);
		
		contentTextArea = new JTextArea();
		contentTextArea.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		contentTextArea.setEditable(true);
		contentTextArea.setBorder(null);
		contentTextArea.setLineWrap(true);
		
		JScrollPane scroll = new JScrollPane(contentTextArea);
		scroll.setBorder(GUIData.buttonBorder2);
		scroll.setEnabled(true);
		
		this.add(scroll).setBounds(100, 100, 700, 305);
		
		validate();
	}
}
