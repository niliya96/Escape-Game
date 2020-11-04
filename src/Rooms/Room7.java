package Rooms;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import MainMenu.GamePanel;
import MainMenu.Menu;
import Rooms.Room6.MyMouseListener;
import Sprites.Clickable;
import Sprites.ClickedObject;
import Sprites.SoundEffect;
import Tools.ImageReader;
import Tools.InventoryPanel;
import Tools.MousePoint;
import Tools.WallBegin;

public class Room7 extends JPanel implements Room {
	ImageReader background;
	GamePanel game;
	JLabel message;
	WallBegin wb;
	InventoryPanel inventory;
	JFrame frame;
	List<Clickable> listClickables = new ArrayList<Clickable>();
	/**
	 * Sounds
	 */
	SoundEffect se = new SoundEffect();
    String lockS = ".//res//lock_sound.wav";
	String openDoor = ".//res//door_open_sound.wav";
	String shalterS = ".//res//shalter_sound.wav";
	/**
	 * /** Booleans
	 */
	// true if want to exit
	boolean ifWantToExit = false;
	// true if the last click has no comment
	boolean ifMessageNoComment = true;
	// true if the user can exit the room
	boolean exitStatus = false;
	// true if it's a close frame
	boolean ifCloseFrame = false;
	// true if the door is locked
	boolean ifDoorLocked = true;
	// true if the pillow is moved
	boolean ifPillowMoved = false;
	// true if the woodman is right
	boolean ifWwoodmanRight = false;
	// true if the lamp is on
	boolean ifLampOn = false;
	// true if door is open
	boolean ifDoorOpen = false;
	// false if the there wasn't sound of door
	boolean flagSound = false;
	/**
	 * Clickables
	 */
	Clickable armchair;
	Clickable books;
	Clickable cupboard;
	ClickedObject door;
	ClickedObject lamp;
	Clickable picture1;
	Clickable picture2;
	ClickedObject pillow;
	Clickable switch_;
	ClickedObject window;
	ClickedObject woodMan;
	ClickedObject menu;
	ClickedObject wantToExit;
	ClickedObject vi;
	ClickedObject x;

	/**
	 * @param w
	 * @param game
	 * @param f
	 * @param i
	 */
	public Room7(WallBegin w, GamePanel game, JFrame f, InventoryPanel i) {
		super();
		this.inventory = i;
		this.wb = w;
		this.frame = f;
		this.game = game;
		this.message = this.game.panel.getText();
		String path = "/room7.png";
		this.background = new ImageReader(path);
		menu = new ClickedObject("/menu.png", new MousePoint(1275, 10), new MousePoint(1420, 95));
		wantToExit = new ClickedObject("/wantToExit.png", new MousePoint(300, 200), new MousePoint(1300, 800));
		vi = new ClickedObject("/vi.png", new MousePoint(600, 550), new MousePoint(700, 650));
		x = new ClickedObject("/x.png", new MousePoint(900, 550), new MousePoint(1000, 650));
		door = new ClickedObject("/door2.jpg", new MousePoint(600, 245), new MousePoint(900, 763));
		listClickables.add(door);
		switch_ = new ClickedObject("/switch.png", new MousePoint(510, 460), new MousePoint(570, 515));
		listClickables.add(switch_);
		window = new ClickedObject("/window5.png", new MousePoint(1020, 235), new MousePoint(1335, 520));
		listClickables.add(window);
		cupboard = new ClickedObject("/cupboard7.png", new MousePoint(1025, 580), new MousePoint(1335, 795));
		listClickables.add(cupboard);
		picture1 = new ClickedObject("/picture5.png", new MousePoint(240, 295), new MousePoint(400, 425));
		listClickables.add(picture1);
		picture2 = new ClickedObject("/picture7.png", new MousePoint(620, 100), new MousePoint(870, 220));
		listClickables.add(picture2);
		armchair = new ClickedObject("/armchair7.png", new MousePoint(150, 495), new MousePoint(470, 800));
		listClickables.add(armchair);
		pillow = new ClickedObject("/pillow7.png", new MousePoint(225, 560), new MousePoint(325, 645));
		listClickables.add(pillow);
		woodMan = new ClickedObject("/woodMan.png", new MousePoint(1165, 400), new MousePoint(1365, 605));
		listClickables.add(woodMan);
		books = new ClickedObject("/books5.png", new MousePoint(1060, 500), new MousePoint(1190, 595));
		listClickables.add(books);
		lamp = new ClickedObject("/lampOff7.png", new MousePoint(240, 20), new MousePoint(420, 250));
		listClickables.add(lamp);
		addMouseListener(new MyMouseListener());
		addMouseMotionListener(new MyMouseListener());
	}

	class MyMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			if (menu.ifClicked(e)) {
				ifWantToExit = true;
				message.setText("");
			}
			if (ifWantToExit) {
				if (vi.ifClicked(e)) {
					frame.setContentPane(new Menu(frame));
					frame.pack();
					setVisible(true);
				}
				if (x.ifClicked(e)) {
					ifWantToExit = false;
					message.setText("");
				}
			}
			message.setFont(new Font("Ariel", Font.BOLD, 25));
			if (ifMessageNoComment) {
				message.setText(" ");
			}
			if (ifDoorOpen) {
				door.setStart(new MousePoint(600, 245));
				door.setEnd(new MousePoint(900, 777));
				door.setImg("/door2Open.png");
				if (door.ifClicked(e)) {
					exitStatus = true;
				}
			}
			if (exitStatus) {
				exitRoom();
			}
			if (ifDoorOpen) {
				if (door.ifClicked(e)) {
					exitStatus = true;
				}
			}
			if (!ifCloseFrame) {
				if (switch_.ifClicked(e)) {
					se.setFile(shalterS);
					se.play();
					try {
						Thread.sleep(300);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ifLampOn = !ifLampOn;
				}
				if (ifLampOn) {
					if (ifDoorLocked) {
						lamp.setImg("/lampOn7.png");
					}
				} else {
					if (ifDoorLocked) {
						lamp.setImg("/lampOff7.png");
					}
				}
				if (door.ifClicked(e)) {
					if (!flagSound) {
	                	se.setFile(openDoor);
	                    se.play();
	                    try {
	                        Thread.sleep(1000);
	                    } catch (InterruptedException e1) {
	                        // TODO Auto-generated catch block
	                        e1.printStackTrace();
	                    }
	                    flagSound = true;
	            	}
					ifDoorOpen = true;
					door.setStart(new MousePoint(600, 245));
					door.setEnd(new MousePoint(900, 777));
					door.setImg("/door2Open.png");
				}
				if (books.ifClicked(e)) {
					message.setText("Which book is the most interesting?");
				}
				if (woodMan.ifClicked(e)) {
					ifWwoodmanRight = !ifWwoodmanRight;
				}
				if (ifWwoodmanRight) {
					woodMan.setImg("/woodManRight.png");
				} else {
					woodMan.setImg("/woodMan.png");
				}
				if (picture1.ifClicked(e)) {
					message.setText("Unreachable.");
				}
				if (picture2.ifClicked(e)) {
					message.setText("A clue?");
				}
				if (pillow.ifClicked(e)) {
					ifPillowMoved = !ifPillowMoved;
				}
				if (ifPillowMoved) {
					pillow.setStart(new MousePoint(275, 560));
					pillow.setEnd(new MousePoint(375, 645));
				} else {
					pillow.setStart(new MousePoint(225, 560));
					pillow.setEnd(new MousePoint(325, 645));
				}
				if (e.getX() >= 1060 && e.getX() <= 1300 && e.getY() >= 605 && e.getY() <= 660) {
					message.setText("It's locked, Maybe a key will help.");
					se.setFile(lockS);
                    se.play();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
				}
			}
			repaint();
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			if (e.getX() >= 1275 && e.getX() <= 1420 && e.getY() >= 10 && e.getY() <= 95) {
				menu.setStart(new MousePoint(1270, 5));
				menu.setEnd(new MousePoint(1425, 100));
				menu.setImg("/menuBig.png");
			} else {
				menu.setStart(new MousePoint(1275, 10));
				menu.setEnd(new MousePoint(1420, 95));
				menu.setImg("/menu.png");
			}
			if (ifWantToExit) {
				if (e.getX() >= 600 && e.getX() <= 700 && e.getY() >= 550 && e.getY() <= 650) {
					vi.setStart(new MousePoint(595, 545));
					vi.setEnd(new MousePoint(705, 655));
				} else {
					vi.setStart(new MousePoint(600, 550));
					vi.setEnd(new MousePoint(700, 650));
				}
				if (e.getX() >= 900 && e.getX() <= 1000 && e.getY() >= 550 && e.getY() <= 650) {
					x.setStart(new MousePoint(895, 545));
					x.setEnd(new MousePoint(1005, 655));
				} else {
					x.setStart(new MousePoint(900, 550));
					x.setEnd(new MousePoint(1000, 650));
				}
			}
			repaint();
		}
	}

	// a method of JPanel. Draws the room and the objects on the panel.
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		ImageIcon icon = new ImageIcon(this.background.getImg());
		Image img = icon.getImage();
		g.drawImage(img, 10, 10, this);
		if (!ifCloseFrame) {
			for (Clickable c : listClickables) {
				c.paintComponent(g);
			}
		}
		inventory.paintComponent(g);
		menu.paintComponent(g);
		if (ifWantToExit) {
			wantToExit.paintComponent(g);
			vi.paintComponent(g);
			x.paintComponent(g);
		}
	}

	public void exitRoom() {
		wb.getCl().removeLayoutComponent(this);
	}

	public boolean getExitStatus() {
		return this.exitStatus;
	}

	public void setExitStatus(boolean b) {
		this.exitStatus = b;
	}
}
