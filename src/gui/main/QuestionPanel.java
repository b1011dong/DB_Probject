package gui.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


import gui.data.GUIData;
import gui.simple.SimpleJPanel;
import gui.simple.SimpleScrollPane;

public class QuestionPanel extends SimpleJPanel{

	private static final long serialVersionUID = -7252469424631288697L;

	private JLabel nameLabel;
	private JLabel questionLabel;
	private JLabel answerLabel;
	
	private JTextField nameTextField;
	private JTextArea questionTextArea;
	private JTextArea answerTextArea;
	
	private JButton okButton;
	private JButton cancelButton;
	
	public QuestionPanel(String name, String content, String file) {
		addComponents(name, content, file);
	}
	
	public void addComponents(String name, String content, String file) {
		
		nameTextField = new JTextField(name);
		nameTextField.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 16));
		nameTextField.setHorizontalAlignment(JTextField.LEFT);
		nameTextField.setBorder(GUIData.buttonBorder2);
		this.add(nameTextField).setBounds(150, 50, 600, 30);
		
		questionTextArea = new JTextArea(" ");
		questionTextArea.setText(content);
		questionTextArea.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 16));
		questionTextArea.setLineWrap(true);
		questionTextArea.setSize(700, 300);

		answerTextArea = new JTextArea(" ");
		answerTextArea.setText(content);
		answerTextArea.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 16));
		answerTextArea.setLineWrap(true);
		answerTextArea.setSize(700, 300);
		
		SimpleScrollPane questionScroll = new SimpleScrollPane(questionTextArea);
		questionScroll.setVisible(true);
		questionScroll.setBorder(GUIData.buttonBorder2);
		this.add(questionScroll).setBounds(150, 100, 600, 160);
		
		SimpleScrollPane answerScroll = new SimpleScrollPane(answerTextArea);
		answerScroll.setVisible(true);
		answerScroll.setBorder(GUIData.buttonBorder2);
		this.add(answerScroll).setBounds(150, 280, 600, 160);
		
		nameLabel = new JLabel();
		nameLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 18));
		nameLabel.setForeground(new Color(60, 60, 60));
		nameLabel.setText("¡¶ ∏Ò");
		nameLabel.setVisible(true);
		nameLabel.setHorizontalAlignment(JLabel.RIGHT);
		//nameLabel.setBorder(GUIData.buttonBorder2);
		this.add(nameLabel).setBounds(50, 50, 100, 30);
		
		questionLabel = new JLabel();
		questionLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 18));
		questionLabel.setForeground(new Color(60, 60, 60));
		questionLabel.setText("¡˙ πÆ");
		questionLabel.setVisible(true);
		questionLabel.setHorizontalAlignment(JLabel.RIGHT);
		//contentLabel.setBorder(GUIData.buttonBorder2);
		this.add(questionLabel).setBounds(50, 100, 100, 30);
		
		answerLabel = new JLabel();
		answerLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 18));
		answerLabel.setForeground(new Color(60, 60, 60));
		answerLabel.setText("¥‰ ∫Ø");
		answerLabel.setVisible(true);
		answerLabel.setHorizontalAlignment(JLabel.RIGHT);
		//contentLabel.setBorder(GUIData.buttonBorder2);
		this.add(answerLabel).setBounds(50, 270, 100, 30);
		
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
		if(e.getSource() == okButton) {
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
