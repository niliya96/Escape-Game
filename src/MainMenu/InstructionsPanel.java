package MainMenu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Sprites.Background;
import Sprites.ClickedObject;
import Tools.MousePoint;

/**
 * InstructionsPanel
 * 
 * @author Nili This is the instructions panel.
 **/
public class InstructionsPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// true if the first screen of instructions if shown
	boolean firstScreen = false;
	public JFrame frame;
	Background b1;
	Background b2;
	ClickedObject menu;
	ClickedObject arrow1;
	ClickedObject arrow2;
	ClickedObject back;

	public InstructionsPanel(JFrame f) {
		super();
		frame = f;
		setBackground(new Color(77, 77, 77));
		setLayout(new BorderLayout());
		b1 = new Background("/instructions1.png", new MousePoint(10, 10), new MousePoint(1510, 1000));
		b2 = new Background("/instructions2.png", new MousePoint(10, 10), new MousePoint(1510, 1000));
		menu = new ClickedObject("/menuEnd.png", new MousePoint(1220, 60), new MousePoint(1460, 215));
		arrow1 = new ClickedObject("/goLeft.png", new MousePoint(1400, 855), new MousePoint(1475, 925));
		arrow2 = new ClickedObject("/goRight.png", new MousePoint(1400, 855), new MousePoint(1475, 925));
        back = new ClickedObject("/back.png", new MousePoint(130, 445), new MousePoint(205, 515));
		addMouseListener(new MyMouseListener());
		addMouseMotionListener(new MyMouseListener());
	}

	class MyMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			if (menu.ifClicked(e)) {
				frame.setContentPane(new Menu(frame));
				frame.pack();
				setVisible(true);
			}
			if (firstScreen) {
				if (arrow1.ifClicked(e)) {
					firstScreen = false;
				}
			} else {
				if (arrow2.ifClicked(e)) {
					firstScreen = true;
				}
			}
			repaint();
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			if (e.getX() >= 1220 && e.getX() <= 1460 && e.getY() >= 60 && e.getY() <= 215) {
				menu.setStart(new MousePoint(1215, 55));
				menu.setEnd(new MousePoint(1465, 220));
				menu.setImg("/menuEndBig.png");
			} else {
				menu.setStart(new MousePoint(1220, 60));
				menu.setEnd(new MousePoint(1460, 215));
				menu.setImg("/menuEnd.png");
			}
			repaint();
		}
	}

	// a method of JPanel. Draws the panel.
	@Override
	public void paintComponent(Graphics g) {
		if (firstScreen) {
			b2.paintComponent(g);
			arrow1.paintComponent(g);
			back.paintComponent(g);
		} else {
			b1.paintComponent(g);
			arrow2.paintComponent(g);
		}
		menu.paintComponent(g);
	}
}
