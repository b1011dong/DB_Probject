package gui.simple;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class SimpleJPanel extends JPanel implements ActionListener, FocusListener, MouseListener, MouseMotionListener, MouseWheelListener{

	private static final long serialVersionUID = 2005215760098311471L;

	public SimpleJPanel() {
		this.setLayout(null);

		this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, new Color(50, 50, 50), new Color(255, 255, 255)));
		this.setBackground(Color.WHITE);
		this.setVisible(true);
	}
	
	public SimpleJPanel(int width, int height) {
		this.setLayout(null);

		this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, new Color(50, 50, 50), new Color(255, 255, 255)));
		this.setBackground(Color.BLUE);
		this.setSize(width, height);
		this.setVisible(true);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
