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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import MainMenu.GamePanel;
import MainMenu.Menu;
import Rooms.Room8.MyMouseListener;
import Sprites.Background;
import Sprites.Clickable;
import Sprites.ClickedObject;
import Sprites.InventoryItem;
import Sprites.SoundEffect;
import Tools.ImageReader;
import Tools.InventoryPanel;
import Tools.MousePoint;
import Tools.Room2CodeHelper;
import Tools.Room9CodeHelper;
import Tools.Room9CodeHelper2;
import Tools.WallBegin;

public class Room9 extends JPanel implements Room {
	ImageReader background;
	GamePanel game;
	JLabel message;
	WallBegin wb;
	InventoryPanel inventory;
	JFrame frame;
	List<Clickable> listClickables1 = new ArrayList<Clickable>();
	List<Clickable> listClickables2 = new ArrayList<Clickable>();
	/**
	 * Sounds
	 */
	SoundEffect se = new SoundEffect();
    String lockS = ".//res//lock_sound.wav";
	String openDoor = ".//res//door_open_sound.wav";
	String glassS = ".//res//glass_sound.wav";
	/**
	 * Booleans
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
	// true if door is open
	boolean ifDoorOpen = false;
	// true if the desk is close
	boolean ifDeskClose = false;
	// true if the drawer is close
	boolean ifDrawerClose = false;
	// true if the codeDrawer is corect
	boolean ifCodeDrawer = false;
	// true if the second drawer is close
	boolean ifDrawer2Close = false;
	// true if the codeDrawer of second drawer is corect
	boolean ifCodeDrawer2 = false;
	// true if first wall is shown
	boolean ifFirstWall = true;
	// true if the tv is close
	boolean ifTVClose = false;
	// true if the tv is open
	boolean ifTVOpen = false;
	// true if the board is close
	boolean ifBoardClose = false;
	// true if the computer is close
	boolean ifComputerClose = false;
	// true if the computer is on
	boolean ifComputerOn = false;
	// true if the computer is onCodeMode
	boolean ifComputerCodeMode = false;
	// true if the remote is picked
	boolean ifRemotePicked = false;
	// true if the remote choose
	boolean ifRemoteChoose = false;
	// true if the hamer is picked
	boolean ifHamerPicked = false;
	// true if the hamer choose
	boolean ifHamerChoose = false;
	// true if code door is close
	boolean ifCodeDoor = false;
	// true if the code of the door is correct
	boolean ifCodeCorrect = false;
	// true if the coin is picked
	boolean ifPiggyBankBroken = false;
	// true if the code of the door is correct
	boolean ifCoinPicked = false;
	// true if the coin is choose
	boolean ifCoinChoose = false;
	// true if the door is close
	boolean ifDoorClose = false;
	// true if the hamer deleted
	boolean ifHamerDeleted = false;
	// true if the remote deleted
	boolean ifRemoteDeleted = false;
	// true if the coin deleted
	boolean ifCoinDeleted = false;
	// true if trash is moved
	boolean ifTrashMove = false;
	/**
	 * Clickables
	 */
	ClickedObject back1;
	ClickedObject back2;
	ClickedObject back3;
	ClickedObject back4;
	ClickedObject back5;
	ClickedObject back6;
	ClickedObject back7;
	ClickedObject back8;
	ClickedObject backWall;
	Clickable board;
	ClickedObject buttonUsername;
	Background closeBoard;
	ClickedObject codeDoor;
	ClickedObject button1;
	ClickedObject button2;
	ClickedObject button3;
	ClickedObject button4;
	ClickedObject d1;
	ClickedObject d2;
	ClickedObject d3;
	ClickedObject d4;
	ClickedObject d5;
	ClickedObject d6;
	ClickedObject d7;
	ClickedObject d8;
	ClickedObject d9;
	ClickedObject b1;
	ClickedObject b2;
	ClickedObject b3;
	Clickable coffeeTable;
	Background closeDesk;
	Background closeDoor;
	ClickedObject computer;
	Clickable desk;
	ClickedObject door;
	ClickedObject drawer;
	ClickedObject drawer2;
	Clickable drinkMashine;
	Clickable laibrary;
	ClickedObject menu;
	ClickedObject nextWall;
	Clickable picture;
	ClickedObject pictureBoard;
	ClickedObject piggybank;
	Clickable plant;
	Clickable shelf;
	ClickedObject tv;
	Background tvClose;
	Clickable trash;
	ClickedObject wantToExit;
	Clickable window;
	ClickedObject vi;
	ClickedObject x;
	// inventory
	InventoryItem remote;
	InventoryItem hamer;
	InventoryItem coin;
	// others
	String l1 = "h";
	String l2 = "h";
	String l3 = "h";
	String l4 = "h";
	int n1 = 0;
	int n2 = 0;
	int n3 = 0;
	String name = "Mikel";
	String code1 = "fish";
	String codeOfDoor = "7229";
	String accum = "";
	int count = 0;

	/**
	 * @param w
	 * @param game
	 * @param f
	 * @param i
	 */
	public Room9(WallBegin w, GamePanel game, JFrame f, InventoryPanel i) {
		super();
		this.inventory = i;
		this.wb = w;
		this.frame = f;
		this.game = game;
		this.message = this.game.panel.getText();
		String path = "/room9.png";
		this.background = new ImageReader(path);
		back1 = new ClickedObject("/back.png", new MousePoint(1430, 15), new MousePoint(1505, 85));
		back2 = new ClickedObject("/back.png", new MousePoint(1430, 15), new MousePoint(1505, 85));
		back3 = new ClickedObject("/back.png", new MousePoint(1430, 15), new MousePoint(1505, 85));
		back4 = new ClickedObject("/back.png", new MousePoint(1430, 15), new MousePoint(1505, 85));
		back5 = new ClickedObject("/back.png", new MousePoint(1430, 15), new MousePoint(1505, 85));
		back6 = new ClickedObject("/back.png", new MousePoint(1430, 15), new MousePoint(1505, 85));
		back7 = new ClickedObject("/back.png", new MousePoint(1430, 15), new MousePoint(1505, 85));
		back8 = new ClickedObject("/back.png", new MousePoint(1430, 15), new MousePoint(1505, 85));
		menu = new ClickedObject("/menu.png", new MousePoint(1275, 10), new MousePoint(1420, 95));
		wantToExit = new ClickedObject("/wantToExit.png", new MousePoint(300, 200), new MousePoint(1300, 800));
		vi = new ClickedObject("/vi.png", new MousePoint(600, 550), new MousePoint(700, 650));
		x = new ClickedObject("/x.png", new MousePoint(900, 550), new MousePoint(1000, 650));
		desk = new ClickedObject("/desk3.png", new MousePoint(380, 520), new MousePoint(880, 800));
		listClickables1.add(desk);
		trash = new ClickedObject("/trash9.png", new MousePoint(420, 685), new MousePoint(520, 800));
		listClickables1.add(trash);
		door = new ClickedObject("/door2.jpg", new MousePoint(1100, 245), new MousePoint(1400, 763));
		listClickables1.add(door);
		laibrary = new ClickedObject("/laibrary2.png", new MousePoint(50, 100), new MousePoint(420, 815));
		listClickables1.add(laibrary);
		shelf = new ClickedObject("/shelf2.png", new MousePoint(360, 125), new MousePoint(880, 230));
		listClickables1.add(shelf);
		picture = new ClickedObject("/picture9.png", new MousePoint(500, 250), new MousePoint(750, 420));
		listClickables1.add(picture);
		piggybank = new ClickedObject("/piggybank.png", new MousePoint(705, 425), new MousePoint(870, 555));
		listClickables1.add(piggybank);
		computer = new ClickedObject("/computer3.png", new MousePoint(450, 375), new MousePoint(665, 545));
		listClickables1.add(computer);
		closeDesk = new Background("/deskClose9.png", new MousePoint(10, 10), new MousePoint(1510, 1000));
		closeDoor = new Background("/closeDoor.png", new MousePoint(10, 10), new MousePoint(1510, 1000));
		drawer = new ClickedObject("/drawer5.png", new MousePoint(250, 400), new MousePoint(1350, 700));
		drawer2 = new ClickedObject("/drawer5.png", new MousePoint(350, 400), new MousePoint(1250, 700));
		button1 = new ClickedObject("/h.png", new MousePoint(400, 530), new MousePoint(540, 670));
		button2 = new ClickedObject("/h.png", new MousePoint(620, 530), new MousePoint(760, 670));
		button3 = new ClickedObject("/h.png", new MousePoint(850, 530), new MousePoint(990, 670));
		button4 = new ClickedObject("/h.png", new MousePoint(1060, 530), new MousePoint(1205, 670));
		b1 = new ClickedObject("/0.5.png", new MousePoint(500, 530), new MousePoint(640, 670));
		b2 = new ClickedObject("/0.5.png", new MousePoint(720, 530), new MousePoint(860, 670));
		b3 = new ClickedObject("/0.5.png", new MousePoint(950, 530), new MousePoint(1090, 670));
		nextWall = new ClickedObject("/goLeft.png", new MousePoint(50, 855), new MousePoint(125, 925));
		backWall = new ClickedObject("/goRight.png", new MousePoint(1400, 855), new MousePoint(1475, 925));
		buttonUsername = new ClickedObject("/code.png", new MousePoint(600, 620), new MousePoint(875, 700));
		codeDoor = new ClickedObject("/codeDoor.jpg", new MousePoint(1015, 430), new MousePoint(1075, 500));
		d1 = new ClickedObject("/1.png", new MousePoint(620, 370), new MousePoint(720, 470));
		d2 = new ClickedObject("/2.png", new MousePoint(750, 370), new MousePoint(850, 470));
		d3 = new ClickedObject("/3.png", new MousePoint(880, 370), new MousePoint(980, 470));
		d4 = new ClickedObject("/4.png", new MousePoint(620, 520), new MousePoint(720, 620));
		d5 = new ClickedObject("/5.png", new MousePoint(750, 520), new MousePoint(850, 620));
		d6 = new ClickedObject("/6.png", new MousePoint(880, 520), new MousePoint(980, 620));
		d7 = new ClickedObject("/7.png", new MousePoint(620, 670), new MousePoint(720, 770));
		d8 = new ClickedObject("/8.png", new MousePoint(750, 670), new MousePoint(850, 770));
		d9 = new ClickedObject("/9.png", new MousePoint(880, 670), new MousePoint(980, 770));
		// wall2
		drinkMashine = new ClickedObject("/drinksMachine.png", new MousePoint(1100, 200), new MousePoint(1445, 800));
		listClickables2.add(drinkMashine);
		coffeeTable = new ClickedObject("/coffeeTable.png", new MousePoint(110, 630), new MousePoint(520, 800));
		listClickables2.add(coffeeTable);
		window = new ClickedObject("/window3.png", new MousePoint(700, 255), new MousePoint(1080, 540));
		listClickables2.add(window);
		plant = new ClickedObject("/cactus1.png", new MousePoint(925, 415), new MousePoint(1100, 805));
		listClickables2.add(plant);
		tv = new ClickedObject("/tv.png", new MousePoint(80, 410), new MousePoint(570, 700));
		listClickables2.add(tv);
		tvClose = new Background("/tvCloseOff.png", new MousePoint(10, 10), new MousePoint(1510, 1000));
		board = new ClickedObject("/board9.png", new MousePoint(150, 180), new MousePoint(500, 400));
		listClickables2.add(board);
		closeBoard = new Background("/boardClose.png", new MousePoint(10, 10), new MousePoint(1510, 1000));
		// inventory
		remote = new InventoryItem("/tvRemote.png", new MousePoint(685, 410), new MousePoint(865, 590));
		hamer = new InventoryItem("/hamer.png", new MousePoint(630, 410), new MousePoint(880, 590));
		coin = new InventoryItem("/coin.png", new MousePoint(10, 10), new MousePoint(110, 100));
		addMouseListener(new MyMouseListener());
		addMouseMotionListener(new MyMouseListener());
	}

	class MyMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			message.setFont(new Font("Ariel", Font.BOLD, 25));
			if (ifMessageNoComment) {
				message.setText(" ");
			}
			if (menu.ifClicked(e)) {
				ifWantToExit = true;
				message.setText(" ");
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
			if (!ifDoorLocked) {
				ifDoorOpen = true;
			}
			if (ifDoorOpen) {
				door.setStart(new MousePoint(1100, 245));
				door.setEnd(new MousePoint(1400, 777));
				door.setImg("/door2Open.png");
			}
			if (exitStatus) {
				se.setFile(openDoor);
				se.play();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				exitRoom();
			}
			/**
			 * inventory
			 */
			if (remote.ifChose(e) && ifRemotePicked && !ifRemoteDeleted) {
				ifRemoteChoose = !ifRemoteChoose;
				ifHamerChoose = false;
				ifCoinChoose = false;
			}
			if (hamer.ifChose(e) && ifHamerPicked && !ifHamerDeleted) {
				ifHamerChoose = !ifHamerChoose;
				ifRemoteChoose = false;
				ifCoinChoose = false;
			}
			if (coin.ifChose(e) && ifCoinPicked && !ifCoinDeleted) {
				ifCoinChoose = !ifCoinChoose;
				ifRemoteChoose = false;
				ifHamerChoose = false;
			}
			if (ifRemoteChoose) {
				remote.setImg("/tvRemoteChoose.png");
			} else {
				remote.setImg("/tvRemote.png");
			}
			if (ifHamerChoose) {
				hamer.setImg("/hamerChoose.png");
			} else {
				hamer.setImg("/hamer.png");
			}
			if (ifCoinChoose) {
				coin.setImg("/coinChoose.png");
			} else {
				coin.setImg("/coin.png");
			}
			/**
			 * first wall
			 */
			if (ifFirstWall) {
				if (nextWall.ifClicked(e) && !ifCloseFrame) {
					ifTrashMove = false;
					ifFirstWall = false;
				}
				if (door.ifClicked(e) && ifDoorOpen) {
					exitStatus = true;
				}
				if (door.ifClicked(e) && !ifCloseFrame && !ifDoorOpen && !ifDrawer2Close && !ifDrawerClose
						&& !ifComputerClose && !ifDeskClose) {
					if (!ifCodeCorrect) {
						message.setText("It's locked.");
						se.setFile(lockS);
                        se.play();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
					} else {
						message.setText("Still locked.");
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
				if (trash.ifClicked(e) && !ifCloseFrame && !ifDoorOpen && !ifDrawer2Close && !ifDrawerClose
						&& !ifComputerClose && !ifDeskClose) {
					ifTrashMove = !ifTrashMove;
				}
				if (ifTrashMove) {
					trash.setStart(new MousePoint(550, 685));
					trash.setEnd(new MousePoint(650, 800));
				} else {
					trash.setStart(new MousePoint(420, 685));
					trash.setEnd(new MousePoint(520, 800));
				}
				if (picture.ifClicked(e) && !ifCloseFrame && !ifDoorOpen && !ifDrawer2Close && !ifDrawerClose
						&& !ifComputerClose && !ifDeskClose) {
					message.setText("Just picture of numbers.");
				}
				if (ifPiggyBankBroken) {
					if (piggybank.ifClicked(e) && !ifCoinPicked && !ifDrawerClose && !ifDrawer2Close && !ifComputerClose
							&& !ifCodeDoor && !ifDoorClose) {
						inventory.addItem(coin);
						ifCoinPicked = true;
					}
				}
				if (ifHamerChoose && piggybank.ifClicked(e)) {
					ifHamerDeleted = true;
					ifHamerChoose = false;
					se.setFile(glassS);
					se.play();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					inventory.deleteItem(hamer);
					piggybank.setImg("/piggybankBroken.png");
					ifPiggyBankBroken = true;
				}
				// not close frame
				if (!ifCloseFrame) {
					if (e.getX() >= 1115 && e.getX() <= 1210 && e.getY() >= 500 && e.getY() <= 575 && !ifDoorOpen) {
						ifDoorClose = true;
						ifCloseFrame = true;
					}
					if (codeDoor.ifClicked(e) && !ifComputerClose && !ifDrawer2Close && !ifDrawerClose && !ifDeskClose
							&& !ifDoorClose) {
						ifCodeDoor = true;
					}
					// code of door
					if (ifCodeDoor) {
						codeDoor.setStart(new MousePoint(500, 200));
						codeDoor.setEnd(new MousePoint(1100, 900));
						if (d1.ifClicked(e) && !ifCodeCorrect) {
							count++;
							accum = accum + "1";
						}
						if (d2.ifClicked(e) && !ifCodeCorrect) {
							count++;
							accum = accum + "2";
						}
						if (d3.ifClicked(e) && !ifCodeCorrect) {
							count++;
							accum = accum + "3";
						}
						if (d4.ifClicked(e) && !ifCodeCorrect) {
							count++;
							accum = accum + "4";
						}
						if (d5.ifClicked(e) && !ifCodeCorrect) {
							count++;
							accum = accum + "5";
						}
						if (d6.ifClicked(e) && !ifCodeCorrect) {
							count++;
							accum = accum + "6";
						}
						if (d7.ifClicked(e) && !ifCodeCorrect) {
							count++;
							accum = accum + "7";
						}
						if (d8.ifClicked(e) && !ifCodeCorrect) {
							count++;
							accum = accum + "8";
						}
						if (d9.ifClicked(e) && !ifCodeCorrect) {
							count++;
							accum = accum + "9";
						}
						String print = accum;
						int left = 4 - accum.length(), i;
						for (i = 1; i <= left; i++) {
							print = print + '*';
						}
						if (!ifCodeCorrect) {
							message.setText(print);
						}
						if (codeOfDoor.compareTo(accum) != 0 && count == 4 && !ifCodeCorrect) {
							message.setText("Wrong code.");
							accum = "";
							count = 0;
						}
						if (codeOfDoor.compareTo(accum) == 0) {
							ifCodeCorrect = true;
							message.setText("Correct, but maybe another action is needed.");
							codeDoor.setImg("/codeDoorOk.jpg");
						}
						if (back7.ifClicked(e)) {
							accum = "";
							message.setText(" ");
							count = 0;
							ifCodeDoor = false;
							codeDoor.setStart(new MousePoint(1015, 430));
							codeDoor.setEnd(new MousePoint(1075, 500));
						}
					}
					// computer
					if (computer.ifClicked(e) && !ifDrawerClose && !ifCloseFrame && !ifDrawer2Close && !ifCodeDoor
							&& !ifDoorClose) {
						ifComputerClose = true;
					}
					if (ifComputerClose) {
						computer.setStart(new MousePoint(350, 300));
						computer.setEnd(new MousePoint(1150, 900));
						if (e.getX() >= 745 && e.getX() <= 765 && e.getY() >= 785 && e.getY() <= 800) {
							ifComputerOn = true;
						}
						if (ifComputerOn) {
							computer.setImg("/computer9username.png");
							if (buttonUsername.ifClicked(e) && !ifComputerCodeMode) {
								String password = JOptionPane.showInputDialog(null, "enter password");
								if (password != null) {
									if (password.compareTo("mikel") == 0) {
										ifComputerCodeMode = true;
									}
									else {
										message.setText("Wrong code.");
									}
								} else {
								}
							}
						}
						if (ifComputerCodeMode) {
							computer.setImg("/computer9code.png");
						}
						if (back5.ifClicked(e)) {
							ifComputerClose = false;
							computer.setStart(new MousePoint(450, 375));
							computer.setEnd(new MousePoint(665, 545));
							computer.setImg("/computer3.png");
						}
					}
					// under desk
					if (e.getX() >= 415 && e.getX() <= 690 && e.getY() >= 625 && e.getY() <= 665 && !ifComputerClose
							&& !ifDrawerClose && !ifDrawer2Close && !ifCodeDoor && !ifDoorClose) {
						ifDeskClose = true;
						ifCloseFrame = true;
					}
					if (ifDrawerClose) {
						if (button1.ifClicked(e) && !ifCodeDrawer) {
							Room9CodeHelper helper = new Room9CodeHelper(button1, l1);
							l1 = helper.getNewDirection();
							if (l1.compareTo("f") == 0) {
								button1.setImg("/f.png");
							}
							if (l1.compareTo("i") == 0) {
								button1.setImg("/i.png");
							}
							if (l1.compareTo("h") == 0) {
								button1.setImg("/h.png");
							}
							if (l1.compareTo("s") == 0) {
								button1.setImg("/s.png");
							}
						}
						if (button2.ifClicked(e) && !ifCodeDrawer) {
							Room9CodeHelper helper = new Room9CodeHelper(button2, l2);
							l2 = helper.getNewDirection();
							if (l2.compareTo("f") == 0) {
								button2.setImg("/f.png");
							}
							if (l2.compareTo("i") == 0) {
								button2.setImg("/i.png");
							}
							if (l2.compareTo("h") == 0) {
								button2.setImg("/h.png");
							}
							if (l2.compareTo("s") == 0) {
								button2.setImg("/s.png");
							}
						}
						if (button3.ifClicked(e) && !ifCodeDrawer) {
							Room9CodeHelper helper = new Room9CodeHelper(button3, l3);
							l3 = helper.getNewDirection();
							if (l3.compareTo("f") == 0) {
								button3.setImg("/f.png");
							}
							if (l3.compareTo("i") == 0) {
								button3.setImg("/i.png");
							}
							if (l3.compareTo("h") == 0) {
								button3.setImg("/h.png");
							}
							if (l3.compareTo("s") == 0) {
								button3.setImg("/s.png");
							}
						}
						if (button4.ifClicked(e) && !ifCodeDrawer) {
							Room9CodeHelper helper = new Room9CodeHelper(button4, l4);
							l4 = helper.getNewDirection();
							if (l4.compareTo("f") == 0) {
								button4.setImg("/f.png");
							}
							if (l4.compareTo("i") == 0) {
								button4.setImg("/i.png");
							}
							if (l4.compareTo("h") == 0) {
								button4.setImg("/h.png");
							}
							if (l4.compareTo("s") == 0) {
								button4.setImg("/s.png");
							}
						}
						if (l1.compareTo("f") == 0 && l2.compareTo("i") == 0 && l3.compareTo("s") == 0
								&& l4.compareTo("h") == 0) {
							ifCodeDrawer = true;
						}
						if (back2.ifClicked(e)) {
							ifDrawerClose = false;
							l1 = "h";
							l2 = "h";
							l3 = "h";
							l4 = "h";
							button1.setImg("/h.png");
							button2.setImg("/h.png");
							button3.setImg("/h.png");
							button4.setImg("/h.png");
						}
						if (ifCodeDrawer) {
							drawer.setStart(new MousePoint(10, 10));
							drawer.setEnd(new MousePoint(1510, 1000));
							drawer.setImg("/drawer9.png");
						}
						if (!ifHamerPicked && ifCodeDrawer) {
							if (hamer.ifChose(e)) {
								hamer.setStart(new MousePoint(10, 10));
								hamer.setEnd(new MousePoint(130, 105));
								message.setText("I picked a hamer.");
								inventory.addItem(hamer);
								ifHamerPicked = true;
							}
						}
					}
					// first drawer
					if (e.getX() >= 400 && e.getX() <= 695 && e.getY() >= 570 && e.getY() <= 620 && !ifComputerClose
							&& !ifDeskClose && !ifDrawer2Close && !ifCodeDoor && !ifDoorClose) {
						ifDrawerClose = true;
					}
					/**
					 * drawer2
					 */
					if (ifDrawer2Close) {
						if (b1.ifClicked(e) && !ifCodeDrawer2) {
							Room9CodeHelper2 helper = new Room9CodeHelper2(b1, n1);
							n1 = helper.getNewDirection();
							if (n1 == 0) {
								b1.setImg("/0.5.png");
							}
							if (n1 == 1) {
								b1.setImg("/1.5.png");
							}
							if (n1 == 2) {
								b1.setImg("/2.5.png");
							}
							if (n1 == 3) {
								b1.setImg("/3.5.png");
							}
							if (n1 == 4) {
								b1.setImg("/4.5.png");
							}
							if (n1 == 5) {
								b1.setImg("/5.5.png");
							}
							if (n1 == 6) {
								b1.setImg("/6.5.png");
							}
							if (n1 == 7) {
								b1.setImg("/7.5.png");
							}
							if (n1 == 8) {
								b1.setImg("/8.5.png");
							}
							if (n1 == 9) {
								b1.setImg("/9.5.png");
							}
						}
						if (b2.ifClicked(e) && !ifCodeDrawer2) {
							Room9CodeHelper2 helper = new Room9CodeHelper2(b2, n2);
							n2 = helper.getNewDirection();
							if (n2 == 0) {
								b2.setImg("/0.5.png");
							}
							if (n2 == 1) {
								b2.setImg("/1.5.png");
							}
							if (n2 == 2) {
								b2.setImg("/2.5.png");
							}
							if (n2 == 3) {
								b2.setImg("/3.5.png");
							}
							if (n2 == 4) {
								b2.setImg("/4.5.png");
							}
							if (n2 == 5) {
								b2.setImg("/5.5.png");
							}
							if (n2 == 6) {
								b2.setImg("/6.5.png");
							}
							if (n2 == 7) {
								b2.setImg("/7.5.png");
							}
							if (n2 == 8) {
								b2.setImg("/8.5.png");
							}
							if (n2 == 9) {
								b2.setImg("/9.5.png");
							}
						}
						if (b3.ifClicked(e) && !ifCodeDrawer2) {
							Room9CodeHelper2 helper = new Room9CodeHelper2(b3, n3);
							n3 = helper.getNewDirection();
							if (n3 == 0) {
								b3.setImg("/0.5.png");
							}
							if (n3 == 1) {
								b3.setImg("/1.5.png");
							}
							if (n3 == 2) {
								b3.setImg("/2.5.png");
							}
							if (n3 == 3) {
								b3.setImg("/3.5.png");
							}
							if (n3 == 4) {
								b3.setImg("/4.5.png");
							}
							if (n3 == 5) {
								b3.setImg("/5.5.png");
							}
							if (n3 == 6) {
								b3.setImg("/6.5.png");
							}
							if (n3 == 7) {
								b3.setImg("/7.5.png");
							}
							if (n3 == 8) {
								b3.setImg("/8.5.png");
							}
							if (n3 == 9) {
								b3.setImg("/9.5.png");
							}
						}
						if (back6.ifClicked(e)) {
							ifDrawer2Close = false;
							n1 = 0;
							n2 = 0;
							n3 = 0;
							b1.setImg("/0.5.png");
							b2.setImg("/0.5.png");
							b3.setImg("/0.5.png");
						}
						if (n1 == 0 && n2 == 3 && n3 == 7) {
							message.setText("Correct!");
							ifCodeDrawer2 = true;
						}
						if (ifCodeDrawer2) {
							drawer2.setStart(new MousePoint(10, 10));
							drawer2.setEnd(new MousePoint(1510, 1000));
							drawer2.setImg("/drawer9.2.png");
						}
						if (!ifRemotePicked && ifCodeDrawer2) {
							if (remote.ifChose(e)) {
								remote.setStart(new MousePoint(10, 10));
								remote.setEnd(new MousePoint(130, 130));
								message.setText("I picked a tv remote.");
								inventory.addItem(remote);
								ifRemotePicked = true;
							}
						}
					}
					// second drawer
					if (e.getX() >= 700 && e.getX() <= 865 && e.getY() >= 620 && e.getY() <= 695 && !ifComputerClose
							&& !ifDeskClose && !ifDrawerClose && !ifCodeDoor && !ifDoorClose) {
						ifDrawer2Close = true;
					}
				}
				// close frame
				else {
					if (ifDeskClose) {
						if (back1.ifClicked(e)) {
							ifDeskClose = false;
							ifCloseFrame = false;
						}
					}
					if (ifDoorClose) {
						if (back8.ifClicked(e)) {
							ifDoorClose = false;
							ifCloseFrame = false;
						}
						// door close try coin
						if (e.getX() >= 390 && e.getX() <= 490 && e.getY() >= 465 && e.getY() <= 550) {
							if (ifCodeCorrect && ifCoinChoose) {
								ifDoorLocked = false;
								ifCoinChoose = false;
								ifCoinDeleted = true;
								inventory.deleteItem(coin);
							}
							if (ifCodeCorrect && !ifCoinChoose && !ifCoinDeleted) {
								message.setText("Nothing happens.");
							}
							if (!ifCodeCorrect && ifCoinChoose && !ifCoinDeleted) {
								message.setText("Code first.");
							}
							if (!ifCodeCorrect && !ifCoinChoose && !ifCoinDeleted) {
								message.setText("Nothing happens.");
							}
						}
					}
				}
			}
			/**
			 * second wall
			 */
			else {
				if (backWall.ifClicked(e) && !ifCloseFrame) {
					ifFirstWall = true;
				}
				if (!ifCloseFrame) {
					if (tv.ifClicked(e)) {
						ifTVClose = true;
						ifCloseFrame = true;
					}
					if (board.ifClicked(e)) {
						ifBoardClose = true;
						ifCloseFrame = true;
					}
					if (drinkMashine.ifClicked(e)) {
						if (ifCoinChoose) {
							message.setText("Out of order.");
						} else {
							message.setText("I don't have money.");
						}
					}
				} else {
					if (ifTVClose) {
						if (back3.ifClicked(e)) {
							ifTVClose = false;
							ifCloseFrame = false;
						}
						if (ifRemoteChoose) {
							if (e.getX() >= 195 && e.getX() <= 1260 && e.getY() >= 120 && e.getY() <= 670) {
								tvClose.setImg("/tvCloseOpen.png");
								ifRemoteChoose = false;
								ifRemoteDeleted = true;
								inventory.deleteItem(remote);
							}
						}
					}
					if (ifBoardClose) {
						if (back4.ifClicked(e)) {
							ifBoardClose = false;
							ifCloseFrame = false;
						}
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
			if (ifCodeDoor) {
				if (e.getX() >= 620 && e.getX() <= 720 && e.getY() >= 370 && e.getY() <= 470) {
					d1.setStart(new MousePoint(615, 365));
					d1.setEnd(new MousePoint(725, 475));
				} else {
					d1.setStart(new MousePoint(620, 370));
					d1.setEnd(new MousePoint(720, 470));
				}
				if (e.getX() >= 750 && e.getX() <= 850 && e.getY() >= 370 && e.getY() <= 470) {
					d2.setStart(new MousePoint(745, 365));
					d2.setEnd(new MousePoint(855, 475));
				} else {
					d2.setStart(new MousePoint(750, 370));
					d2.setEnd(new MousePoint(850, 470));
				}
				if (e.getX() >= 880 && e.getX() <= 980 && e.getY() >= 370 && e.getY() <= 470) {
					d3.setStart(new MousePoint(875, 365));
					d3.setEnd(new MousePoint(985, 475));
				} else {
					d3.setStart(new MousePoint(880, 370));
					d3.setEnd(new MousePoint(980, 470));
				}
				if (e.getX() >= 620 && e.getX() <= 720 && e.getY() >= 520 && e.getY() <= 620) {
					d4.setStart(new MousePoint(615, 515));
					d4.setEnd(new MousePoint(725, 625));
				} else {
					d4.setStart(new MousePoint(620, 520));
					d4.setEnd(new MousePoint(720, 620));
				}
				if (e.getX() >= 750 && e.getX() <= 850 && e.getY() >= 520 && e.getY() <= 620) {
					d5.setStart(new MousePoint(745, 515));
					d5.setEnd(new MousePoint(855, 625));
				} else {
					d5.setStart(new MousePoint(750, 520));
					d5.setEnd(new MousePoint(850, 620));
				}
				if (e.getX() >= 880 && e.getX() <= 980 && e.getY() >= 520 && e.getY() <= 620) {
					d6.setStart(new MousePoint(875, 515));
					d6.setEnd(new MousePoint(985, 625));
				} else {
					d6.setStart(new MousePoint(880, 520));
					d6.setEnd(new MousePoint(980, 620));
				}
				if (e.getX() >= 620 && e.getX() <= 720 && e.getY() >= 670 && e.getY() <= 770) {
					d7.setStart(new MousePoint(615, 665));
					d7.setEnd(new MousePoint(725, 775));
				} else {
					d7.setStart(new MousePoint(620, 670));
					d7.setEnd(new MousePoint(720, 770));
				}
				if (e.getX() >= 750 && e.getX() <= 850 && e.getY() >= 670 && e.getY() <= 770) {
					d8.setStart(new MousePoint(745, 665));
					d8.setEnd(new MousePoint(855, 775));
				} else {
					d8.setStart(new MousePoint(750, 670));
					d8.setEnd(new MousePoint(850, 770));
				}
				if (e.getX() >= 880 && e.getX() <= 980 && e.getY() >= 670 && e.getY() <= 770) {
					d9.setStart(new MousePoint(875, 665));
					d9.setEnd(new MousePoint(985, 775));
				} else {
					d9.setStart(new MousePoint(880, 670));
					d9.setEnd(new MousePoint(980, 770));
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
				back5.setStart(new MousePoint(1425, 10));
				back5.setEnd(new MousePoint(1510, 90));
				back6.setStart(new MousePoint(1425, 10));
				back6.setEnd(new MousePoint(1510, 90));
				back7.setStart(new MousePoint(1425, 10));
				back7.setEnd(new MousePoint(1510, 90));
				back8.setStart(new MousePoint(1425, 10));
				back8.setEnd(new MousePoint(1510, 90));
			} else {
				back1.setStart(new MousePoint(1430, 15));
				back1.setEnd(new MousePoint(1505, 85));
				back2.setStart(new MousePoint(1430, 15));
				back2.setEnd(new MousePoint(1505, 85));
				back3.setStart(new MousePoint(1430, 15));
				back3.setEnd(new MousePoint(1505, 85));
				back4.setStart(new MousePoint(1430, 15));
				back4.setEnd(new MousePoint(1505, 85));
				back5.setStart(new MousePoint(1430, 15));
				back5.setEnd(new MousePoint(1505, 85));
				back6.setStart(new MousePoint(1430, 15));
				back6.setEnd(new MousePoint(1505, 85));
				back7.setStart(new MousePoint(1430, 15));
				back7.setEnd(new MousePoint(1505, 85));
				back8.setStart(new MousePoint(1430, 15));
				back8.setEnd(new MousePoint(1505, 85));
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
		if (!ifCloseFrame && ifFirstWall) {
			for (Clickable c : listClickables1) {
				c.paintComponent(g);
			}
			if (!ifComputerClose) {
				codeDoor.paintComponent(g);
			}
		}
		if (!ifCloseFrame && !ifFirstWall) {
			for (Clickable c : listClickables2) {
				c.paintComponent(g);
			}
		}
		/**
		 * first wall
		 */
		if (ifFirstWall) {
			if (!ifCloseFrame) {
				nextWall.paintComponent(g);
			}
			if (ifDeskClose) {
				closeDesk.paintComponent(g);
				back1.paintComponent(g);
			}
			if (ifDoorClose) {
				closeDoor.paintComponent(g);
				back8.paintComponent(g);
			}
			if (ifDrawerClose) {
				drawer.paintComponent(g);
				back2.paintComponent(g);
				if (!ifCodeDrawer) {
					button1.paintComponent(g);
					button2.paintComponent(g);
					button3.paintComponent(g);
					button4.paintComponent(g);
				}
				if (!ifHamerPicked && ifCodeDrawer) {
					hamer.paintComponent(g);
				}
			}
			if (ifDrawer2Close) {
				drawer2.paintComponent(g);
				back6.paintComponent(g);
				if (!ifCodeDrawer2) {
					b1.paintComponent(g);
					b2.paintComponent(g);
					b3.paintComponent(g);
				}
				if (!ifRemotePicked && ifCodeDrawer2) {
					remote.paintComponent(g);
				}
			}
			if (ifComputerClose) {
				back5.paintComponent(g);
				if (ifComputerOn && !ifComputerCodeMode) {
					buttonUsername.paintComponent(g);
				}
			}
			if (ifCodeDoor) {
				back7.paintComponent(g);
				d1.paintComponent(g);
				d2.paintComponent(g);
				d3.paintComponent(g);
				d4.paintComponent(g);
				d5.paintComponent(g);
				d6.paintComponent(g);
				d7.paintComponent(g);
				d8.paintComponent(g);
				d9.paintComponent(g);
			}
		}
		/**
		 * second wall
		 */
		else {
			if (!ifCloseFrame) {
				backWall.paintComponent(g);
			}
			if (ifTVClose) {
				tvClose.paintComponent(g);
				back3.paintComponent(g);
			}
			if (ifBoardClose) {
				closeBoard.paintComponent(g);
				back4.paintComponent(g);
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