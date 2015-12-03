package gui.simple;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.EtchedBorder;

public class SimpleJFrame extends JFrame implements MouseListener, MouseMotionListener{

	private static final long serialVersionUID = -4326089716290673478L;
	
	protected JButton exitButton;
	protected JButton minimizeButton;
	
	protected int WIDTH;
	protected int HEIGHT;
	protected int x;
	protected int y;
	protected int tempX;
	protected int tempY;
	
	public SimpleJFrame(String frameName, int width, int height) {
		super(frameName);
		WIDTH = width;
		HEIGHT = height;
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLayout(null);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		
		// Ã¢ ±âº» ¼³Á¤
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getRootPane().setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, new Color(50, 50, 50), new Color(255, 255, 255))); // frame¿¡ Å×µÎ¸® Àû¿ë
		this.getContentPane().setBackground(Color.WHITE);
		this.setSize(WIDTH, HEIGHT);
		this.setLocation(x = screen.width / 2 - WIDTH/2, y = screen.height / 2 - HEIGHT/2);
		this.setResizable(false);
		this.setVisible(true);
		
		exitButton = new JButton("x");
		exitButton.setBackground(Color.WHITE);
		exitButton.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 20));
		exitButton.setBorder(null);
		exitButton.setOpaque(true);
		//exitButton.addActionListener(this);
		exitButton.setFocusPainted(false);
		this.add(exitButton).setBounds(WIDTH - 40, 0, 30, 30);
		
		minimizeButton = new JButton("-");
		minimizeButton.setBackground(Color.WHITE);
		minimizeButton.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 26));
		minimizeButton.setBorder(null);
		minimizeButton.setOpaque(true);
		//minimizeButton.addActionListener(this);
		minimizeButton.setFocusPainted(false);
		this.add(minimizeButton).setBounds(WIDTH - 80, 0, 30, 30);
	}

	public void mouseClicked(MouseEvent arg0) {
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mouseMoved(MouseEvent arg0) {
	}

	public void mouseReleased(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
		tempX = arg0.getX();
		tempY = arg0.getY();
	}

	public void mouseDragged(MouseEvent arg0) {
		x = arg0.getXOnScreen() - tempX;
		y = arg0.getYOnScreen() - tempY;
		
		this.setBounds(x, y, WIDTH, HEIGHT);
	}
	
}
