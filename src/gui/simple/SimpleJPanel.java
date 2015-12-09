package gui.simple;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class SimpleJPanel extends JPanel {

	private static final long serialVersionUID = 2005215760098311471L;

	public SimpleJPanel() {
		this.setLayout(null);

		this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, new Color(50, 50, 50), new Color(255, 255, 255))); // frame에 테두리 적용
		this.setBackground(Color.WHITE);
		this.setVisible(true);
	}
	
	public SimpleJPanel(int width, int height) {
		this.setLayout(null);

		this.getRootPane().setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, new Color(50, 50, 50), new Color(255, 255, 255))); // frame에 테두리 적용
		this.setBackground(Color.BLUE);
		this.setSize(width, height);
		this.setVisible(true);
	}
}
