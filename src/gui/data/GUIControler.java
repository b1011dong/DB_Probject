package gui.data;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * This class manipulates commonly used GUI components
 * @author Dongwon
 *
 */
public class GUIControler {

	public GUIControler() {
		
	}
	
	static public JLabel addBigLabel(JFrame frame, JLabel label, String message, int x, int y) {
		label = new JLabel();
		label.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 24));
		label.setForeground(new Color(60, 60, 60));
		label.setText(message);
		label.setVisible(true);
		frame.add(label).setBounds(x, y, 200, 50);
		
		return label;
	}
	
	static public JLabel addBigLabel(JFrame frame, JLabel label, String message, int x, int y, int width, int height) {
		label = new JLabel();
		label.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 24));
		label.setForeground(new Color(60, 60, 60));
		label.setText(message);
		label.setVisible(true);
		frame.add(label).setBounds(x, y, width, height);
		
		return label;
	}
	
	static public JLabel addSmallLabel(JFrame frame, JLabel label, String message, int x, int y) {
		label = new JLabel();
		label.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
		label.setForeground(new Color(60, 60, 60));
		label.setText(message);
		label.setVisible(true);
		frame.add(label).setBounds(x, y, 200, 50);
		
		return label;
	}
	
	static public JLabel addSmallLabel(JFrame frame, JLabel label, String message, int x, int y, int width, int height) {
		label = new JLabel();
		label.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
		label.setForeground(new Color(60, 60, 60));
		label.setText(message);
		label.setVisible(true);
		frame.add(label).setBounds(x, y, width, height);
		
		return label;
	}
	
	static public JTextField addTextField(JFrame frame, JTextField textField, int x, int y) {
		textField = new JTextField();
		textField.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		textField.setHorizontalAlignment(JPasswordField.LEFT);
		textField.setBorder(GUIData.buttonBorder2);
		textField.addKeyListener((KeyListener) frame);
		frame.add(textField).setBounds(x, y, 310, 30);
		
		return textField;
	}
	
	static public JTextField addTextField(JFrame frame, JTextField textField, int x, int y, int width, int height) {
		textField = new JTextField();
		textField.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		textField.setHorizontalAlignment(JPasswordField.LEFT);
		textField.setBorder(GUIData.buttonBorder2);
		textField.addKeyListener((KeyListener) frame);
		frame.add(textField).setBounds(x, y, width, height);
		
		return textField;
	}
	
	static public JPasswordField addPasswordField(JFrame frame, JPasswordField passwordField, int x, int y) {
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		passwordField.setHorizontalAlignment(JPasswordField.LEFT);
		passwordField.setBorder(GUIData.buttonBorder2);
		passwordField.addKeyListener((KeyListener) frame);
		frame.add(passwordField).setBounds(x, y, 310, 30);
		
		return passwordField;
	}
	
	static public JPasswordField addPasswordField(JFrame frame, JPasswordField passwordField, int x, int y, int width, int height) {
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		passwordField.setHorizontalAlignment(JPasswordField.LEFT);
		passwordField.setBorder(GUIData.buttonBorder2);
		passwordField.addKeyListener((KeyListener) frame);
		frame.add(passwordField).setBounds(x, y, width, height);
		
		return passwordField;
	}
	
	static public JButton addButton(JFrame frame, JButton button, String message, int x, int y) {
		button = new JButton(message);
		button.setBackground(Color.WHITE);
		button.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		button.setBorder(null);
		button.setOpaque(true);
		button.addActionListener((ActionListener) frame);
		button.setFocusPainted(false);
		button.setForeground(Color.WHITE);
		button.setBackground(GUIData.buttonColorBlue);
		frame.add(button).setBounds(x, y, 80, 30);
		
		return button;
	}
	
	static public JButton addButton(JFrame frame, JButton button, String message, int x, int y, int width, int height) {
		button = new JButton(message);
		button.setBackground(Color.WHITE);
		button.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 14));
		button.setBorder(null);
		button.setOpaque(true);
		button.addActionListener((ActionListener) frame);
		button.setFocusPainted(false);
		button.setForeground(Color.WHITE);
		button.setBackground(GUIData.buttonColorBlue);
		frame.add(button).setBounds(x, y, width, height);
		
		return button;
	}
	
	static public JRadioButton addJRadioButton(JFrame frame, ButtonGroup buttonGroup, JRadioButton radioButton, String message, int x, int y) {
		radioButton = new JRadioButton(message);
		radioButton.setBackground(Color.WHITE);
		radioButton.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
		buttonGroup.add(radioButton);
		radioButton.setBounds(x, y, 110, 30);
		radioButton.addActionListener((ActionListener) frame);
		frame.add(radioButton);
		
		return radioButton;
	}
	
	static public JRadioButton addJRadioButton(JFrame frame, ButtonGroup buttonGroup, JRadioButton radioButton, String message, int x, int y, int width, int height) {
		radioButton = new JRadioButton(message);
		radioButton.setBackground(Color.WHITE);
		radioButton.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
		buttonGroup.add(radioButton);
		radioButton.setBounds(x, y, width, height);
		radioButton.addActionListener((ActionListener) frame);
		frame.add(radioButton);
		
		return radioButton;
	}
}
