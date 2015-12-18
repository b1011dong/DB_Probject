package gui.main;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


import gui.data.GUIData;
import gui.simple.SimpleJPanel;
import gui.simple.SimpleScrollPane;

public class AssignmentPanel extends SimpleJPanel{

	private static final long serialVersionUID = -3636565510108305472L;
	
	private JLabel nameLabel;
	private JLabel contentLabel;
	private JLabel fileLabel;
	
	private JTextField nameTextField;
	private JTextArea contentTextArea;
	
	private JButton filePathButton;
	private JButton okButton;
	private JButton cancelButton;
	
	private String fileName;
	private String filePath;
	
	public AssignmentPanel(String name, String content, String file) {
		addComponents(name, content, file);
	}
	
	public void addComponents(String name, String content, String file) {
		
		nameTextField = new JTextField(name);
		nameTextField.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 16));
		nameTextField.setHorizontalAlignment(JTextField.LEFT);
		nameTextField.setBorder(GUIData.buttonBorder2);
		this.add(nameTextField).setBounds(150, 50, 600, 30);
		
		contentTextArea = new JTextArea(" ");
		contentTextArea.setText(content);
		contentTextArea.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 16));
		contentTextArea.setLineWrap(true);
		contentTextArea.setSize(700, 300);
		
		filePathButton = new JButton(file);
		filePathButton.setBackground(Color.WHITE);
		filePathButton.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 16));
		filePathButton.setHorizontalAlignment(JTextField.LEFT);
		filePathButton.setBorder(GUIData.buttonBorder2);
		filePathButton.setFocusPainted(false);
		filePathButton.addActionListener(this);
		this.add(filePathButton).setBounds(150, 420, 600, 30);
		
		if(filePathButton.getText().toString().equals("")) {
			filePathButton.setForeground(GUIData.grayColor);
			filePathButton.setText("∆ƒ¿œ √∑∫Œ∏¶ ¿ß«ÿ ≈¨∏Ø«ÿ ¡÷ººø‰.");
		}
		
		SimpleScrollPane scroll = new SimpleScrollPane(contentTextArea);
		scroll.setVisible(true);
		scroll.setBorder(GUIData.buttonBorder2);
		this.add(scroll).setBounds(150, 100, 600, 300);
		
		nameLabel = new JLabel();
		nameLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 18));
		nameLabel.setForeground(new Color(60, 60, 60));
		nameLabel.setText("¡¶ ∏Ò");
		nameLabel.setVisible(true);
		nameLabel.setHorizontalAlignment(JLabel.RIGHT);
		//nameLabel.setBorder(GUIData.buttonBorder2);
		this.add(nameLabel).setBounds(50, 50, 100, 30);
		
		contentLabel = new JLabel();
		contentLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 18));
		contentLabel.setForeground(new Color(60, 60, 60));
		contentLabel.setText("≥ª øÎ");
		contentLabel.setVisible(true);
		contentLabel.setHorizontalAlignment(JLabel.RIGHT);
		//contentLabel.setBorder(GUIData.buttonBorder2);
		this.add(contentLabel).setBounds(50, 100, 100, 30);
		
		fileLabel = new JLabel();
		fileLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 18));
		fileLabel.setForeground(new Color(60, 60, 60));
		fileLabel.setText("√∑∫Œ∆ƒ¿œ");
		fileLabel.setVisible(true);
		fileLabel.setHorizontalAlignment(JLabel.RIGHT);
		//fileLabel.setBorder(GUIData.buttonBorder2);
		this.add(fileLabel).setBounds(50, 420, 100, 30);
		
		fileName = new String();
		filePath = new String();
		
		okButton = new JButton("»Æ ¿Œ");
		okButton.setBackground(Color.WHITE);
		okButton.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 14));
		okButton.setBorder(null);
		okButton.setOpaque(true);
		okButton.setFocusPainted(false);
		okButton.setForeground(Color.WHITE);
		okButton.setBackground(GUIData.buttonColorBlue);
		okButton.addActionListener(this);
		this.add(okButton).setBounds(570, 460, 80, 30);
		
		cancelButton = new JButton("√Î º“");
		cancelButton.setBackground(Color.WHITE);
		cancelButton.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 14));
		cancelButton.setBorder(null);
		cancelButton.setOpaque(true);
		cancelButton.setFocusPainted(false);
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setBackground(GUIData.buttonColorBlue);
		cancelButton.addActionListener(this);
		this.add(cancelButton).setBounds(670, 460, 80, 30);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == filePathButton) {
			FileDialog fd = new FileDialog(new JFrame(), "∆ƒ¿œ √∑∫Œ",FileDialog.LOAD);
			fd.setVisible(true);
			
			if((fileName = fd.getFile()) != null) {
				filePath = fd.getDirectory();
				filePathButton.setText(filePath + fileName);
			}
		}
		else if(e.getSource() == okButton) {
			// TODO ok∏¶ ¥≠∑∂¿ª ∞ÊøÏ DBø° µ•¿Ã≈Õ∏¶ ø√∏∞¥Ÿ.
		}
	}
	
	public JButton getOkButton() {
		return okButton;
	}
	
	public JButton getCancelButton() {
		return cancelButton;
	}
}
