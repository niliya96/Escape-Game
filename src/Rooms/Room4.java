package Rooms;

import Tools.*;
import Sprites.*;
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

public class Room4 extends JPanel implements Room {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	String lockS = "/lock_sound.wav";
	String openDoor = "/door_open_sound.wav";
	String sprayS = "/spray_sound.wav";
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
	// true if the key picked
	boolean ifKeyPicked = false;
	// true if the key choose
	boolean ifKeyChoose = false;
	// true if the spray picked
	boolean ifSprayPicked = false;
	// true if the spray choose
	boolean ifSprayChoose = false;
	// true if the trash move
	boolean ifTrashMove = false;
	// true if the wall is close
	boolean ifCloseWall = false;
	// true if the upper drawer is close
	boolean ifDrawerCloseUp = false;
	// true if the down drawer is close
	boolean ifDrawerCloseDown = false;
	// true if code1 is complited
	boolean ifCode1 = false;
	// true if code2 is complited
	boolean ifCode2 = false;
	// true if the spray is deleted from inventory
	boolean ifSprayDelete = false;
	// true if the picture is close
	boolean ifPictureClose = false;
	// true if door is open
	boolean ifDoorOpen = false;
	/**
	 * Clickables
	 */
	Background closeWall;
	Background drawerCloseUp;
	Background drawerCloseDown;
	ClickedObject back1;
	ClickedObject back2;
	ClickedObject back3;
	ClickedObject back4;
	ClickedObject button1Down;
	ClickedObject button2Down;
	ClickedObject button3Down;
	ClickedObject button1Up;
	ClickedObject button2Up;
	ClickedObject button3Up;
	ClickedObject button4Down;
	ClickedObject blackboard;
	Clickable carpet;
	Clickable cactus;
	Clickable cupboard;
	ClickedObject door;
	Clickable lamp;
	ClickedObject picture;
	Clickable switch_;
	ClickedObject trash;
	ClickedObject menu;
	ClickedObject wantToExit;
	ClickedObject vi;
	ClickedObject x;
	/**
	 * inventory items
	 */
	InventoryItem spray;
	InventoryItem key;
	int num1 = 1;
	int num2 = 1;
	int num3 = 1;
	int num4 = 1;
	String n1 = "1";
	String n2 = "1";
	String n3 = "1";

	/**
	 * @param w
	 * @param game
	 * @param f
	 * @param i
	 */
	public Room4(WallBegin w, GamePanel game, JFrame f, InventoryPanel i) {
		super();
		this.inventory = i;
		this.wb = w;
		this.frame = f;
		this.game = game;
		this.message = this.game.panel.getText();
		String path = "/room4.png";
		this.background = new ImageReader(path);
		// back bottons
		back1 = new ClickedObject("/back.png", new MousePoint(1430, 15), new MousePoint(1505, 85));
		back2 = new ClickedObject("/back.png", new MousePoint(1430, 15), new MousePoint(1505, 85));
		back3 = new ClickedObject("/back.png", new MousePoint(1430, 15), new MousePoint(1505, 85));
		back4 = new ClickedObject("/back.png", new MousePoint(1430, 15), new MousePoint(1505, 85));
		menu = new ClickedObject("/menu.png", new MousePoint(1275, 10), new MousePoint(1420, 95));
		wantToExit = new ClickedObject("/wantToExit.png", new MousePoint(300, 200), new MousePoint(1300, 800));
		vi = new ClickedObject("/vi.png", new MousePoint(600, 550), new MousePoint(700, 650));
		x = new ClickedObject("/x.png", new MousePoint(900, 550), new MousePoint(1000, 650));
		door = new ClickedObject("/door2.jpg", new MousePoint(700, 245), new MousePoint(1000, 763));
		listClickables.add(door);
		blackboard = new ClickedObject("/blackboard.png", new MousePoint(120, 300), new MousePoint(620, 800));
		listClickables.add(blackboard);
		carpet = new ClickedObject("/carpet4.png", new MousePoint(560, 750), new MousePoint(1140, 870));
		listClickables.add(carpet);
		cupboard = new ClickedObject("/cupboard2.png", new MousePoint(1100, 530), new MousePoint(1320, 790));
		listClickables.add(cupboard);
		switch_ = new ClickedObject("/switch.png", new MousePoint(620, 460), new MousePoint(680, 515));
		listClickables.add(switch_);
		listClickables.add(carpet);
		lamp = new ClickedObject("/lampOn.png", new MousePoint(775, 30), new MousePoint(935, 250));
		listClickables.add(lamp);
		trash = new ClickedObject("/trash4.png", new MousePoint(530, 660), new MousePoint(660, 800));
		listClickables.add(trash);
		picture = new ClickedObject("/picture4.1.png", new MousePoint(1090, 225), new MousePoint(1330, 435));
		listClickables.add(picture);
		cactus = new ClickedObject("/cactus4.png", new MousePoint(1140, 400), new MousePoint(1275, 545));
		listClickables.add(cactus);
		closeWall = new Background("/closeWall4.png", new MousePoint(10, 10), new MousePoint(1510, 1000));
		drawerCloseUp = new Background("/drawerClose2.png", new MousePoint(350, 400), new MousePoint(1250, 700));
		drawerCloseDown = new Background("/drawerClose2.png", new MousePoint(350, 400), new MousePoint(1250, 700));
		button1Down = new ClickedObject("/tag1.png", new MousePoint(500, 500), new MousePoint(570, 675));
		button2Down = new ClickedObject("/tag1.png", new MousePoint(670, 500), new MousePoint(740, 675));
		button3Down = new ClickedObject("/tag1.png", new MousePoint(860, 500), new MousePoint(930, 675));
		button4Down = new ClickedObject("/tag1.png", new MousePoint(1030, 500), new MousePoint(1100, 675));
		button1Up = new ClickedObject("/1.4.png", new MousePoint(500, 550), new MousePoint(600, 650));
		button2Up = new ClickedObject("/1.4.png", new MousePoint(750, 550), new MousePoint(850, 650));
		button3Up = new ClickedObject("/1.4.png", new MousePoint(1000, 550), new MousePoint(1100, 650));
		// inventory items
		key = new InventoryItem("/key1.png", new MousePoint(600, 425), new MousePoint(900, 550));
		spray = new InventoryItem("/spray1.png", new MousePoint(620, 420), new MousePoint(900, 575));
		addMouseListener(new MyMouseListener());
		addMouseMotionListener(new MyMouseListener());
	}

	// an inner class. Here occur most of the interaction with the mouse.
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
			if (ifDoorLocked) {
				if (ifKeyPicked && ifKeyChoose && door.ifClicked(e) && !ifWantToExit) {
					ifDoorLocked = false;
					se.setFile(openDoor);
					se.play();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					inventory.deleteItem(key);
				}
			}
			if (!ifDoorLocked) {
				ifDoorOpen = true;
			}
			if (ifDoorOpen) {
				door.setStart(new MousePoint(700, 245));
				door.setEnd(new MousePoint(1000, 777));
				door.setImg("/door2Open.png");
			}
			if (exitStatus) {
				inventory.deleteItem(spray);
				exitRoom();
			}
			message.setFont(new Font("Ariel", Font.BOLD, 25));
			if (ifMessageNoComment) {
				message.setText(" ");
			}
			/**
			 * inventory items
			 */
			if (key.ifChose(e) && ifKeyPicked && !ifWantToExit) {
				ifKeyChoose = !ifKeyChoose;
				ifSprayChoose = false;
			}
			if (spray.ifChose(e) && ifSprayPicked && !ifWantToExit) {
				ifSprayChoose = !ifSprayChoose;
				ifKeyChoose = false;
			}
			if (ifKeyChoose) {
				key.setImg("/key1Choose.png");
			} else {
				key.setImg("/key1.png");
			}
			if (ifSprayChoose) {
				spray.setImg("/spray1Choose.png");
			} else {
				spray.setImg("/spray1.png");
			}
			/**
			 * other room
			 */
			if (ifCloseWall && ifTrashMove && !ifWantToExit) {
				if (back1.ifClicked(e)) {
					ifCloseFrame = false;
					ifCloseWall = false;
				}
			}
			if (!ifCloseFrame) {
				if (picture.ifClicked(e) && !ifDrawerCloseDown && !ifDrawerCloseUp && !ifDrawerCloseDown
						&& !ifDrawerCloseUp && !ifWantToExit) {
					ifPictureClose = true;
				}
				if (ifPictureClose && !ifWantToExit) {
					picture.setStart(new MousePoint(450, 200));
					picture.setEnd(new MousePoint(1150, 800));
					if (back4.ifClicked(e)) {
						picture.setStart(new MousePoint(1090, 225));
						picture.setEnd(new MousePoint(1330, 435));
						ifPictureClose = false;
					}
					if (e.getX() >= 490 && e.getX() <= 1105 && e.getY() >= 230 && e.getY() <= 760 && !ifWantToExit) {
						message.setText("Interesting.");
					}
				}
				if (ifTrashMove) {
					if (e.getX() >= 530 && e.getX() <= 645 && e.getY() >= 675 && e.getY() <= 755 && !ifWantToExit) {
						ifCloseFrame = true;
						ifCloseWall = true;
					}
				}
				if (trash.ifClicked(e) && !ifCloseFrame && !ifDrawerCloseDown && !ifDrawerCloseUp && !ifWantToExit) {
					ifTrashMove = !ifTrashMove;
				}
				if (door.ifClicked(e) && !ifCloseFrame && ifDoorLocked && !ifPictureClose && !ifDoorOpen
						&& !ifDrawerCloseDown && !ifDrawerCloseUp && !ifWantToExit && !trash.ifClicked(e)) {
					message.setText("It's locked.");
					se.setFile(lockS);
					se.play();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (ifDoorOpen) {
					exitStatus = true;
				}
				if (blackboard.ifClicked(e) && !ifCloseFrame && !ifPictureClose && !ifDrawerCloseDown
						&& !ifDrawerCloseUp && !ifWantToExit) {
					if (!ifSprayChoose) {
						message.setText("Nothing happens.");
					} else {
						if (!ifSprayDelete) {
							ifSprayChoose = false;
							ifSprayDelete = true;
						}
						se.setFile(sprayS);
						se.play();
						try {
							Thread.sleep(1500);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						blackboard.setImg("/blackboardCode.png");
					}
				}
				if (ifTrashMove) {
					trash.setStart(new MousePoint(670, 700));
					trash.setEnd(new MousePoint(800, 840));
				} else {
					trash.setStart(new MousePoint(530, 660));
					trash.setEnd(new MousePoint(660, 800));
				}
				// upper drawer
				if (e.getX() >= 1130 && e.getX() <= 1285 && e.getY() >= 595 && e.getY() <= 650 && !ifDrawerCloseDown
						&& !ifWantToExit) {
					ifDrawerCloseUp = true;
				}
				// down drawer
				if (e.getX() >= 1130 && e.getX() <= 1285 && e.getY() >= 685 && e.getY() <= 740 && !ifDrawerCloseUp
						&& !ifWantToExit) {
					ifDrawerCloseDown = true;
				}
				/**
				 * what happens if the uper drawer is close
				 */
				if (ifDrawerCloseUp && !ifWantToExit) {
					if (button1Up.ifClicked(e) && !ifCode2) {
						Room4CodeHelper2 helper = new Room4CodeHelper2(button1Up, n1);
						n1 = helper.getNewDirection();
						if (n1.compareTo("1") == 0) {
							button1Up.setImg("/1.4.png");
						}
						if (n1.compareTo("2") == 0) {
							button1Up.setImg("/2.4.png");
						}
						if (n1.compareTo("3") == 0) {
							button1Up.setImg("/3.4.png");
						}
						if (n1.compareTo("4") == 0) {
							button1Up.setImg("/4.4.png");
						}
						if (n1.compareTo("5") == 0) {
							button1Up.setImg("/5.4.png");
						}
						if (n1.compareTo("6") == 0) {
							button1Up.setImg("/6.4.png");
						}
						if (n1.compareTo("7") == 0) {
							button1Up.setImg("/7.4.png");
						}
						if (n1.compareTo("8") == 0) {
							button1Up.setImg("/8.4.png");
						}
						if (n1.compareTo("9") == 0) {
							button1Up.setImg("/9.4.png");
						}
						if (n1.compareTo("0") == 0) {
							button1Up.setImg("/0.4.png");
						}
						if (n1.compareTo("*") == 0) {
							button1Up.setImg("/asterisk.4.png");
						}
						if (n1.compareTo("#") == 0) {
							button1Up.setImg("/#.4.png");
						}
					}
					if (button2Up.ifClicked(e) && !ifCode2) {
						Room4CodeHelper2 helper = new Room4CodeHelper2(button2Up, n2);
						n2 = helper.getNewDirection();
						if (n2.compareTo("1") == 0) {
							button2Up.setImg("/1.4.png");
						}
						if (n2.compareTo("2") == 0) {
							button2Up.setImg("/2.4.png");
						}
						if (n2.compareTo("3") == 0) {
							button2Up.setImg("/3.4.png");
						}
						if (n2.compareTo("4") == 0) {
							button2Up.setImg("/4.4.png");
						}
						if (n2.compareTo("5") == 0) {
							button2Up.setImg("/5.4.png");
						}
						if (n2.compareTo("6") == 0) {
							button2Up.setImg("/6.4.png");
						}
						if (n2.compareTo("7") == 0) {
							button2Up.setImg("/7.4.png");
						}
						if (n2.compareTo("8") == 0) {
							button2Up.setImg("/8.4.png");
						}
						if (n2.compareTo("9") == 0) {
							button2Up.setImg("/9.4.png");
						}
						if (n2.compareTo("0") == 0) {
							button2Up.setImg("/0.4.png");
						}
						if (n2.compareTo("*") == 0) {
							button2Up.setImg("/asterisk.4.png");
						}
						if (n2.compareTo("#") == 0) {
							button2Up.setImg("/#.4.png");
						}
					}
					if (button3Up.ifClicked(e) && !ifCode2) {
						Room4CodeHelper2 helper = new Room4CodeHelper2(button3Up, n3);
						n3 = helper.getNewDirection();
						if (n3.compareTo("1") == 0) {
							button3Up.setImg("/1.4.png");
						}
						if (n3.compareTo("2") == 0) {
							button3Up.setImg("/2.4.png");
						}
						if (n3.compareTo("3") == 0) {
							button3Up.setImg("/3.4.png");
						}
						if (n3.compareTo("4") == 0) {
							button3Up.setImg("/4.4.png");
						}
						if (n3.compareTo("5") == 0) {
							button3Up.setImg("/5.4.png");
						}
						if (n3.compareTo("6") == 0) {
							button3Up.setImg("/6.4.png");
						}
						if (n3.compareTo("7") == 0) {
							button3Up.setImg("/7.4.png");
						}
						if (n3.compareTo("8") == 0) {
							button3Up.setImg("/8.4.png");
						}
						if (n3.compareTo("9") == 0) {
							button3Up.setImg("/9.4.png");
						}
						if (n3.compareTo("0") == 0) {
							button3Up.setImg("/0.4.png");
						}
						if (n3.compareTo("*") == 0) {
							button3Up.setImg("/asterisk.4.png");
						}
						if (n3.compareTo("#") == 0) {
							button3Up.setImg("/#.4.png");
						}
					}
					if (n1.compareTo("*") == 0 && n2.compareTo("0") == 0 && n3.compareTo("#") == 0) {
						ifCode2 = true;
					}
					if (ifCode2) {
						drawerCloseUp.setStart(new MousePoint(10, 10));
						drawerCloseUp.setEnd(new MousePoint(1510, 1000));
						drawerCloseUp.setImg("/upDrawerOpen4.png");
						if (!ifKeyPicked && !ifWantToExit) {
							if (key.ifChose(e)) {
								ifKeyPicked = true;
								key.setStart(new MousePoint(10, 10));
								key.setEnd(new MousePoint(120, 95));
								message.setText("I picked a key.");
								inventory.addItem(key);
							}
						}
					}
					if (back2.ifClicked(e) && !ifWantToExit) {
						ifDrawerCloseUp = false;
						button1Up.setImg("/1.4.png");
						button2Up.setImg("/1.4.png");
						button3Up.setImg("/1.4.png");
						n1 = "1";
						n2 = "1";
						n3 = "1";
					}
				}
				/**
				 * what happens if the down drawer is close
				 */
				if (ifDrawerCloseDown && !ifWantToExit) {
					if (button1Down.ifClicked(e) && !ifCode1) {
						Room4CodeHelper1 helper = new Room4CodeHelper1(button1Down, num1);
						num1 = helper.getNewDirection();
						if (num1 == 1) {
							button1Down.setImg("/tag1.png");
						}
						if (num1 == 2) {
							button1Down.setImg("/tag2.png");
						}
						if (num1 == 3) {
							button1Down.setImg("/tag3.png");
						}
						if (num1 == 4) {
							button1Down.setImg("/tag4.png");
						}
					}
					if (button2Down.ifClicked(e) && !ifCode1) {
						Room4CodeHelper1 helper = new Room4CodeHelper1(button2Down, num2);
						num2 = helper.getNewDirection();
						if (num2 == 1) {
							button2Down.setImg("/tag1.png");
						}
						if (num2 == 2) {
							button2Down.setImg("/tag2.png");
						}
						if (num2 == 3) {
							button2Down.setImg("/tag3.png");
						}
						if (num2 == 4) {
							button2Down.setImg("/tag4.png");
						}
					}
					if (button3Down.ifClicked(e) && !ifCode1) {
						Room4CodeHelper1 helper = new Room4CodeHelper1(button3Down, num3);
						num3 = helper.getNewDirection();
						if (num3 == 1) {
							button3Down.setImg("/tag1.png");
						}
						if (num3 == 2) {
							button3Down.setImg("/tag2.png");
						}
						if (num3 == 3) {
							button3Down.setImg("/tag3.png");
						}
						if (num3 == 4) {
							button3Down.setImg("/tag4.png");
						}
					}
					if (button4Down.ifClicked(e) && !ifCode1) {
						Room4CodeHelper1 helper = new Room4CodeHelper1(button4Down, num4);
						num4 = helper.getNewDirection();
						if (num4 == 1) {
							button4Down.setImg("/tag1.png");
						}
						if (num4 == 2) {
							button4Down.setImg("/tag2.png");
						}
						if (num4 == 3) {
							button4Down.setImg("/tag3.png");
						}
						if (num4 == 4) {
							button4Down.setImg("/tag4.png");
						}
					}
					if (num1 == 1 && num2 == 3 && num3 == 2 && num4 == 1) {
						ifCode1 = true;
					}
					if (ifCode1) {
						drawerCloseDown.setStart(new MousePoint(10, 10));
						drawerCloseDown.setEnd(new MousePoint(1510, 1000));
						drawerCloseDown.setImg("/downDrawerOpen4.png");
						if (!ifSprayPicked && !ifWantToExit) {
							if (spray.ifChose(e)) {
								ifSprayPicked = true;
								spray.setStart(new MousePoint(10, 10));
								spray.setEnd(new MousePoint(130, 105));
								message.setText("I picked a spray.");
								inventory.addItem(spray);
							}
						}
					}
					if (back3.ifClicked(e) && !ifWantToExit) {
						ifDrawerCloseDown = false;
						button1Down.setImg("/tag1.png");
						button2Down.setImg("/tag1.png");
						button3Down.setImg("/tag1.png");
						button4Down.setImg("/tag1.png");
						num1 = 1;
						num2 = 1;
						num3 = 1;
						num4 = 1;
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
			if (e.getX() >= 1430 && e.getX() <= 1505 && e.getY() >= 15 && e.getY() <= 85) {
				back1.setStart(new MousePoint(1425, 10));
				back1.setEnd(new MousePoint(1510, 90));
				back2.setStart(new MousePoint(1425, 10));
				back2.setEnd(new MousePoint(1510, 90));
				back3.setStart(new MousePoint(1425, 10));
				back3.setEnd(new MousePoint(1510, 90));
				back4.setStart(new MousePoint(1425, 10));
				back4.setEnd(new MousePoint(1510, 90));
			} else {
				back1.setStart(new MousePoint(1430, 15));
				back1.setEnd(new MousePoint(1505, 85));
				back2.setStart(new MousePoint(1430, 15));
				back2.setEnd(new MousePoint(1505, 85));
				back3.setStart(new MousePoint(1430, 15));
				back3.setEnd(new MousePoint(1505, 85));
				back4.setStart(new MousePoint(1430, 15));
				back4.setEnd(new MousePoint(1505, 85));
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
		if (ifCloseWall) {
			closeWall.paintComponent(g);
			back1.paintComponent(g);
		}
		if (ifPictureClose) {
			back4.paintComponent(g);
		}
		if (ifDrawerCloseUp) {
			drawerCloseUp.paintComponent(g);
			back2.paintComponent(g);
			if (!ifCode2) {
				button1Up.paintComponent(g);
				button2Up.paintComponent(g);
				button3Up.paintComponent(g);
			}
			if (ifCode2 && !ifKeyPicked) {
				key.paintComponent(g);
			}
		}
		if (ifDrawerCloseDown) {
			drawerCloseDown.paintComponent(g);
			back3.paintComponent(g);
			if (!ifCode1) {
				button1Down.paintComponent(g);
				button2Down.paintComponent(g);
				button3Down.paintComponent(g);
				button4Down.paintComponent(g);
			}
			if (ifCode1 && !ifSprayPicked) {
				spray.paintComponent(g);
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
