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
import Sprites.Background;
import Sprites.Clickable;
import Sprites.ClickedObject;
import Sprites.InventoryItem;
import Sprites.SoundEffect;
import Tools.ImageReader;
import Tools.InventoryPanel;
import Tools.MousePoint;
import Tools.Room10CodeHelper;
import Tools.WallBegin;

public class Room10 extends JPanel implements Room {
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
	List<Clickable> listClickables1 = new ArrayList<Clickable>();
	List<Clickable> listClickables2 = new ArrayList<Clickable>();
	List<Clickable> listClickablesSecrete = new ArrayList<Clickable>();
	/**
	 * Sounds
	 */
	SoundEffect se = new SoundEffect();
	String lockS = "/lock_sound.wav";
	String openDoor = "/door_open_sound.wav";
	String glassS = "/glass_sound.wav";
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
	// true if the desk is close
	boolean ifDeskClose = false;
	// true if the drawer is close
	boolean ifDrawerClose = false;
	// true if the codeDrawer is corect
	boolean ifCodeDrawer = false;
	// true if first wall is shown
	boolean ifFirstWall = true;
	// true if the globe is choose
	boolean ifGlobeChoose = false;
	// true if the globe is picked
	boolean ifGlobePicked = false;
	// true if a close frame outside the window
	boolean Outside = false;
	// true if the laibrary is close
	boolean ifLaibraryClose = false;
	// true if the book is full of dust
	boolean fullOfDust = true;
	// true if the mirror is broken
	boolean ifMirrorBroken = false;
	// true if the box is locked
	boolean ifBoxLocked = true;
	// true if the sofa is close
	boolean ifSofaClose = false;
	// true if the napkin is choose
	boolean ifNapkinChoose = false;
	// true if the napkin is picked
	boolean ifNapkinPicked = false;
	// true if the key is choose
	boolean ifKeyChoose = false;
	// true if the key is picked
	boolean ifKeyPicked = false;
	// true if the final key is choose
	boolean ifFinalKeyChoose = false;
	// true if the final key is picked
	boolean ifFinalKeyPicked = false;
	// true if the lantern is choose
	boolean ifLanternChoose = false;
	// true if the lantern is picked
	boolean ifLanternPicked = false;
	// true if the binoculars is choose
	boolean ifBinocularsChoose = false;
	// true if the binoculars is picked
	boolean ifBinocularsPicked = false;
	// true if the book is choose
	boolean ifBookChoose = false;
	// true if the book is picked
	boolean ifBookPicked = false;
	// true if the code of the laibrary is close
	boolean ifCodeLaibraryClose = false;
	// true if the code of the laibrary is close twice
	boolean ifCodeLaibraryCloseTwice = false;
	// true if the book is close
	boolean ifBookClose = false;
	// true if the code of the laibrary is correct
	boolean ifCodeLaibrary = false;
	// true if it's second time of opening the laibrary drawer
	boolean ifSecondTimeOpen = false;
	// true if we are now in the secrete room
	boolean ifSecreteRoom = false;
	// true if we have access to the secrete room
	boolean accessToSecreteRoom = false;
	// true if dark
	boolean ifDark = true;
	// true if the spider moved
	boolean ifSpiderMoved = false;
	// true if the cupboard is close
	boolean ifCloseCupboard = false;
	// a flag
	boolean ifCloseCupboardFlag = false;
	// true if the clock code is valid
	boolean validityOfClock = false;
	// true if the book is in it's place in the laibrary
	boolean ifBookIn = false;
	// true if the laibtrary is moved
	boolean ifLaibraryMoved = false;
	// true if the coat stand is close
	boolean ifStandClose = false;
	// true if door is open
	boolean ifDoorOpen = false;
	// true if the book is deleted
	boolean ifBookDeleted = false;
	// true if the napkin is deleted
	boolean ifNapkinDeleted = false;
	// true if the globe is deleted
	boolean ifGlobeDeleted = false;
	// true if the lantern is deleted
	boolean ifLanternDeleted = false;
	// true if the binoculars is deleted
	boolean ifBinocularsDeleted = false;
	// true if the key deleted
	boolean ifKeyDeleted = false;
	// true if the final key is deleted
	boolean ifFinalKeyDeleted = false;
	// true if we entered the laibrary again agter the code
	boolean ifAgain = false;

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
	ClickedObject backWall;
	ClickedObject box;
	ClickedObject button1;
	ClickedObject button2;
	ClickedObject button3;
	ClickedObject button4;
	ClickedObject button5;
	ClickedObject button6;
	ClickedObject button7;
	ClickedObject button8;
	ClickedObject button9;
	ClickedObject c1;
	ClickedObject c2;
	ClickedObject c3;
	ClickedObject c4;
	ClickedObject chair;
	Background closeLaibrary;
	Background closeSofa;
	Background closeCoatStand;
	Background closeCodeLaibrary;
	Background closeCodeLaibraryTwice;
	Background closeBook;
	Clickable coatStend;
	Clickable coffeeTable;
	ClickedObject cupboard;
	ClickedObject doorFinal;
	Clickable door;
	ClickedObject drawer;
	ClickedObject laibrary;
	ClickedObject menu;
	ClickedObject mirror;
	ClickedObject nextWall;
	Background outside;
	Clickable picture;
	Clickable picture2;
	ClickedObject pillow;
	Background secreteRoom;
	Clickable sofa;
	ClickedObject spider;
	ClickedObject wantToExit;
	Clickable window;
	ClickedObject vi;
	ClickedObject x;
	// inventory
	InventoryItem globe;
	InventoryItem napkin;
	InventoryItem lantern;
	InventoryItem key;
	InventoryItem finalKey;
	InventoryItem binoculars;
	InventoryItem book;
	// others
	final String theCode = "YBGW";
	String accum = "";
	int b1 = 12;
	int b2 = 12;
	int b3 = 12;
	int b4 = 12;

	/**
	 * @param w
	 * @param game
	 * @param f
	 * @param i
	 */
	public Room10(WallBegin w, GamePanel game, JFrame f, InventoryPanel i) {
		super();
		this.inventory = i;
		this.wb = w;
		this.frame = f;
		this.game = game;
		this.message = this.game.panel.getText();
		String path = "/room10.png";
		this.background = new ImageReader(path);
		back1 = new ClickedObject("/back.png", new MousePoint(1430, 15), new MousePoint(1505, 85));
		back2 = new ClickedObject("/back.png", new MousePoint(1430, 15), new MousePoint(1505, 85));
		back3 = new ClickedObject("/back.png", new MousePoint(1430, 15), new MousePoint(1505, 85));
		back4 = new ClickedObject("/back.png", new MousePoint(1430, 15), new MousePoint(1505, 85));
		back5 = new ClickedObject("/back.png", new MousePoint(1430, 15), new MousePoint(1505, 85));
		back6 = new ClickedObject("/back.png", new MousePoint(1430, 15), new MousePoint(1505, 85));
		back7 = new ClickedObject("/back.png", new MousePoint(1430, 15), new MousePoint(1505, 85));
		nextWall = new ClickedObject("/goLeft.png", new MousePoint(50, 855), new MousePoint(125, 925));
		backWall = new ClickedObject("/goRight.png", new MousePoint(1400, 855), new MousePoint(1475, 925));
		menu = new ClickedObject("/menu.png", new MousePoint(1275, 10), new MousePoint(1420, 95));
		wantToExit = new ClickedObject("/wantToExit.png", new MousePoint(300, 200), new MousePoint(1300, 800));
		vi = new ClickedObject("/vi.png", new MousePoint(600, 550), new MousePoint(700, 650));
		x = new ClickedObject("/x.png", new MousePoint(900, 550), new MousePoint(1000, 650));
		doorFinal = new ClickedObject("/door2.jpg", new MousePoint(1100, 245), new MousePoint(1400, 763));
		listClickables1.add(doorFinal);
		window = new ClickedObject("/window10.png", new MousePoint(110, 250), new MousePoint(660, 765));
		listClickables1.add(window);
		sofa = new ClickedObject("/sofa9.png", new MousePoint(105, 490), new MousePoint(655, 800));
		listClickables1.add(sofa);
		picture = new ClickedObject("/picture10.png", new MousePoint(815, 335), new MousePoint(1040, 475));
		listClickables1.add(picture);
		laibrary = new ClickedObject("/laibrary10.png", new MousePoint(980, 100), new MousePoint(1540, 900));
		listClickables1.add(laibrary);
		coffeeTable = new ClickedObject("/coffeeTable.png", new MousePoint(130, 730), new MousePoint(590, 900));
		listClickables1.add(coffeeTable);
		pillow = new ClickedObject("/pillow2.png", new MousePoint(215, 545), new MousePoint(330, 640));
		listClickables1.add(pillow);
		outside = new Background("/outside.png", new MousePoint(10, 10), new MousePoint(1510, 1000));
		closeLaibrary = new Background("/closeLaibrary.png", new MousePoint(10, 10), new MousePoint(1510, 1000));
		closeSofa = new Background("/sofaCloseWithNapkin.png", new MousePoint(10, 10), new MousePoint(1510, 1000));
		closeCodeLaibrary = new Background("/closeCodeLaibrary.png", new MousePoint(10, 10),
				new MousePoint(1510, 1000));
		closeCodeLaibraryTwice = new Background("/closeCodeTwice.png", new MousePoint(10, 10),
				new MousePoint(1510, 1000));
		closeCoatStand = new Background("/closeCoatStendWithKey.png", new MousePoint(10, 10),
				new MousePoint(1510, 1000));
		closeBook = new Background("/closeBook.png", new MousePoint(10, 10), new MousePoint(1510, 1000));
		button1 = new ClickedObject("/B.png", new MousePoint(280, 200), new MousePoint(440, 345));
		button2 = new ClickedObject("/G.png", new MousePoint(700, 200), new MousePoint(865, 345));
		button3 = new ClickedObject("/O.10.png", new MousePoint(1090, 200), new MousePoint(1260, 345));
		button4 = new ClickedObject("/P.10.png", new MousePoint(280, 430), new MousePoint(440, 575));
		button5 = new ClickedObject("/R.10.png", new MousePoint(700, 430), new MousePoint(865, 575));
		button6 = new ClickedObject("/W.10.png", new MousePoint(1090, 430), new MousePoint(1260, 575));
		button7 = new ClickedObject("/..10.png", new MousePoint(280, 665), new MousePoint(440, 805));
		button8 = new ClickedObject("/Y.png", new MousePoint(700, 665), new MousePoint(865, 805));
		button9 = new ClickedObject("/ok.png", new MousePoint(1090, 665), new MousePoint(1260, 805));
		/**
		 * second wall
		 */
		door = new ClickedObject("/door2.jpg", new MousePoint(1100, 245), new MousePoint(1400, 763));
		listClickables2.add(door);
		mirror = new ClickedObject("/mirror10.png", new MousePoint(800, 280), new MousePoint(1050, 655));
		listClickables2.add(mirror);
		box = new ClickedObject("/treasureBox.png", new MousePoint(150, 550), new MousePoint(470, 800));
		listClickables2.add(box);
		coatStend = new ClickedObject("/coatStend.png", new MousePoint(400, 250), new MousePoint(720, 800));
		listClickables2.add(coatStend);
		secreteRoom = new Background("/secreteDark.jpg", new MousePoint(10, 10), new MousePoint(1510, 1000));
		/**
		 * secrete room
		 */
		chair = new ClickedObject("/chair10.png", new MousePoint(520, 330), new MousePoint(770, 670));
		listClickablesSecrete.add(chair);
		cupboard = new ClickedObject("/cupboard10.png", new MousePoint(100, 470), new MousePoint(500, 820));
		listClickablesSecrete.add(cupboard);
		spider = new ClickedObject("/spider.png", new MousePoint(190, 490), new MousePoint(310, 580));
		listClickablesSecrete.add(spider);
		picture2 = new ClickedObject("/picture10.2.png", new MousePoint(1060, 450), new MousePoint(1460, 850));
		listClickablesSecrete.add(picture2);
		drawer = new ClickedObject("/drawer10.png", new MousePoint(300, 300), new MousePoint(1300, 800));
		c1 = new ClickedObject("/12.10.png", new MousePoint(400, 530), new MousePoint(540, 670));
		c2 = new ClickedObject("/12.10.png", new MousePoint(620, 530), new MousePoint(760, 670));
		c3 = new ClickedObject("/12.10.png", new MousePoint(850, 530), new MousePoint(990, 670));
		c4 = new ClickedObject("/12.10.png", new MousePoint(1060, 530), new MousePoint(1205, 670));
		// inventory
		globe = new InventoryItem("/globe1.png", new MousePoint(310, 630), new MousePoint(440, 780));
		napkin = new InventoryItem("/napkin.png", new MousePoint(10, 10), new MousePoint(140, 115));
		binoculars = new InventoryItem("/binoculars.png", new MousePoint(800, 500), new MousePoint(1200, 800));
		key = new InventoryItem("/key2.png", new MousePoint(300, 580), new MousePoint(700, 850));
		finalKey = new InventoryItem("/key1.png", new MousePoint(10, 10), new MousePoint(120, 95));
		lantern = new InventoryItem("/lantern.png", new MousePoint(300, 580), new MousePoint(450, 680));
		book = new InventoryItem("/book.png", new MousePoint(610, 400), new MousePoint(950, 580));
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
			/**
			 * inventory
			 */
			if (globe.ifChose(e) && ifGlobePicked && !ifGlobeDeleted && !ifWantToExit) {
				ifGlobeChoose = !ifGlobeChoose;
				ifNapkinChoose = false;
				ifBinocularsChoose = false;
				ifBookChoose = false;
				ifFinalKeyChoose = false;
				ifKeyChoose = false;
				ifLanternChoose = false;
			}
			if (napkin.ifChose(e) && ifNapkinPicked && !ifNapkinDeleted && !ifWantToExit) {
				ifNapkinChoose = !ifNapkinChoose;
				ifGlobeChoose = false;
				ifBinocularsChoose = false;
				ifBookChoose = false;
				ifFinalKeyChoose = false;
				ifKeyChoose = false;
				ifLanternChoose = false;
			}
			if (key.ifChose(e) && ifKeyPicked && !ifKeyDeleted && !ifWantToExit) {
				ifKeyChoose = !ifKeyChoose;
				ifNapkinChoose = false;
				ifBinocularsChoose = false;
				ifBookChoose = false;
				ifFinalKeyChoose = false;
				ifGlobeChoose = false;
				ifLanternChoose = false;
			}
			if (finalKey.ifChose(e) && ifFinalKeyPicked && !ifFinalKeyDeleted && !ifWantToExit) {
				ifFinalKeyChoose = !ifFinalKeyChoose;
				ifNapkinChoose = false;
				ifBinocularsChoose = false;
				ifBookChoose = false;
				ifGlobeChoose = false;
				ifKeyChoose = false;
				ifLanternChoose = false;
			}
			if (binoculars.ifChose(e) && ifBinocularsPicked && !ifBinocularsDeleted && !ifWantToExit) {
				ifBinocularsChoose = !ifBinocularsChoose;
				ifNapkinChoose = false;
				ifGlobeChoose = false;
				ifBookChoose = false;
				ifFinalKeyChoose = false;
				ifKeyChoose = false;
				ifLanternChoose = false;
			}
			if (lantern.ifChose(e) && ifLanternPicked && !ifLanternDeleted && !ifWantToExit) {
				ifLanternChoose = !ifLanternChoose;
				ifNapkinChoose = false;
				ifBinocularsChoose = false;
				ifBookChoose = false;
				ifFinalKeyChoose = false;
				ifKeyChoose = false;
				ifGlobeChoose = false;
			}
			if (book.ifChose(e) && ifBookPicked && !ifBookDeleted && !ifWantToExit) {
				ifBookChoose = !ifBookChoose;
				ifNapkinChoose = false;
				ifBinocularsChoose = false;
				ifLanternChoose = false;
				ifFinalKeyChoose = false;
				ifKeyChoose = false;
				ifGlobeChoose = false;
			}
			if (ifGlobeChoose) {
				globe.setImg("/globe1Choose.png");
			} else {
				globe.setImg("/globe1.png");
			}
			if (ifNapkinChoose) {
				napkin.setImg("/napkinChoose.png");
			} else {
				napkin.setImg("/napkin.png");
			}
			if (ifKeyChoose) {
				key.setImg("/key2Choose.png");
			} else {
				key.setImg("/key2.png");
			}
			if (ifBinocularsChoose) {
				binoculars.setImg("/binocularsChoose.png");
			} else {
				binoculars.setImg("/binoculars.png");
			}
			if (ifLanternChoose) {
				lantern.setImg("/lanternChoose.png");
			} else {
				lantern.setImg("/lantern.png");
			}
			if (ifFinalKeyChoose) {
				finalKey.setImg("/key1Choose.png");
			} else {
				finalKey.setImg("/key1.png");
			}
			if (ifBookChoose) {
				book.setImg("/bookChoose.png");
			} else {
				book.setImg("/book.png");
			}
			if (ifDoorLocked) {
				if (ifFinalKeyPicked && ifFinalKeyChoose && doorFinal.ifClicked(e) && ifLaibraryMoved
						&& !ifWantToExit) {
					ifDoorLocked = false;
					ifFinalKeyChoose = false;
					ifFinalKeyDeleted = true;
					se.setFile(openDoor);
					se.play();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					inventory.deleteItem(finalKey);
				}
				if (doorFinal.ifClicked(e) && ifLaibraryMoved && !ifFinalKeyChoose && !ifDoorOpen && ifDoorLocked
						&& !ifWantToExit) {
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

			}
			if (!ifDoorLocked) {
				ifDoorOpen = true;
			}
			if (ifDoorOpen) {
				doorFinal.setStart(new MousePoint(1100, 245));
				doorFinal.setEnd(new MousePoint(1400, 777));
				doorFinal.setImg("/door2Open.png");
			}
			if (exitStatus) {
				message.setText("");
				exitRoom();
			}
			/**
			 * first wall
			 */
			if (ifFirstWall) {
				if (nextWall.ifClicked(e) && !ifCloseFrame && !ifWantToExit) {
					ifFirstWall = false;
				}
				// not close frame
				if (!ifCloseFrame) {
					if (ifDoorOpen) {
						exitStatus = true;
					}
					if (ifBookIn && !ifWantToExit) {
						if (laibrary.ifClicked(e)) {
							laibrary.setStart(new MousePoint(660, 100));
							laibrary.setEnd(new MousePoint(1200, 900));
							ifLaibraryMoved = true;
						}
					}
					if (globe.ifChose(e) && !ifGlobePicked && !ifWantToExit) {
						inventory.addItem(globe);
						globe.setStart(new MousePoint(10, 10));
						globe.setEnd(new MousePoint(100, 120));
						message.setText("I picked an ancient globe.");
						ifGlobePicked = true;
					}
					// outside
					if (e.getX() >= 110 && e.getX() <= 650 && e.getY() >= 250 && e.getY() <= 480 && !ifWantToExit) {
						ifCloseFrame = true;
						Outside = true;
					}
					// close laibrary
					if (e.getX() >= 1120 && e.getX() <= 1380 && e.getY() >= 430 && e.getY() <= 580 && !ifBookIn
							&& !ifWantToExit) {
						ifCloseFrame = true;
						ifLaibraryClose = true;
					}
					if (picture.ifClicked(e) && !ifWantToExit) {
						message.setText("Sometimes you just need to complete the missing piece.");
					}
					// close sofa
					if (e.getX() >= 440 && e.getX() <= 640 && e.getY() >= 505 && e.getY() <= 730 && !ifWantToExit) {
						ifCloseFrame = true;
						ifSofaClose = true;
					}
					// close code laibrary
					if (e.getX() >= 1115 && e.getX() <= 1385 && e.getY() >= 595 && e.getY() <= 760 && !ifBookIn
							&& !ifWantToExit) {
						if (ifCodeLaibrary) {
							closeCodeLaibrary.setImg("/openLaibrary.png");
							ifSecondTimeOpen = true;
						}
						ifCloseFrame = true;
						ifCodeLaibraryClose = true;
					}
				} else {
					if (Outside) {
						if (back1.ifClicked(e) && !ifWantToExit) {
							Outside = false;
							ifCloseFrame = false;
							outside.setImg("/outside.png");
						}
						if (e.getX() >= 65 && e.getX() <= 210 && e.getY() >= 405 && e.getY() <= 590
								&& ifBinocularsChoose && ifBinocularsPicked && !ifWantToExit) {
							outside.setImg("/outsideClose.png");
						} else {
							message.setText("Too far.");
							outside.setImg("/outside.png");
						}
					}
					if (ifLaibraryClose) {
						if (back2.ifClicked(e) && !ifWantToExit) {
							ifLaibraryClose = false;
							ifBookClose = false;
							ifCloseFrame = false;
						}
						if (!fullOfDust) {
							if (e.getX() >= 280 && e.getX() <= 560 && e.getY() >= 385 && e.getY() <= 470
									&& !ifWantToExit) {
								ifBookClose = true;
							}
						}
						if (e.getX() >= 280 && e.getX() <= 560 && e.getY() >= 385 && e.getY() <= 470 && ifNapkinChoose
								&& !ifWantToExit) {
							fullOfDust = false;
							ifNapkinChoose = false;
							ifNapkinDeleted = true;
							inventory.deleteItem(napkin);
						}
						if (e.getX() >= 280 && e.getX() <= 560 && e.getY() >= 385 && e.getY() <= 470 && !ifWantToExit) {
							if (fullOfDust) {
								message.setText("Full of dust.");
							} else {
								closeLaibrary.setImg("/closeLaibraryPuzzle.png");
							}
						}
						// box
						if (e.getX() >= 565 && e.getX() <= 940 && e.getY() >= 260 && e.getY() <= 465 && !ifWantToExit) {
							message.setText("It's locked.");
						}
						if (e.getX() >= 675 && e.getX() <= 830 && e.getY() >= 620 && e.getY() <= 860 && !ifWantToExit) {
							if (ifBookChoose && !ifBookIn && !fullOfDust) {
								closeLaibrary.setImg("/closeLaibraryWithBook.png");
								laibrary.setImg("/finalLaibrary.png");
								ifBookIn = true;
								ifBookChoose = false;
								ifBookDeleted = true;
								inventory.deleteItem(book);
							}
							if (ifBookChoose && !ifBookIn && fullOfDust) {
								message.setText("Clean dust first.");
							}
						}
					}
					if (ifSofaClose) {
						if (back3.ifClicked(e) && !ifWantToExit) {
							ifSofaClose = false;
							ifCloseFrame = false;
						}
						if (e.getX() >= 800 && e.getX() <= 895 && e.getY() >= 480 && e.getY() <= 615 && !ifWantToExit) {
							if (!ifNapkinPicked) {
								inventory.addItem(napkin);
								ifNapkinPicked = true;
								closeSofa.setImg("/sofaCloseWithoutNapkin.png");
							}
						}
					}
					if (ifCodeLaibraryClose) {
						if (back4.ifClicked(e) && !ifWantToExit) {
							message.setText(" ");
							ifCloseFrame = false;
							ifCodeLaibraryClose = false;
							ifCodeLaibraryCloseTwice = false;
							if (!ifCodeLaibrary) {
								closeCodeLaibraryTwice.setImg("/closeCodeTwice.png");
							}
							if (ifCodeLaibrary && !ifAgain) {
								ifAgain = true;
							}
						}
						if (ifCodeLaibrary && ifAgain && !ifWantToExit) {
							if (!ifBinocularsPicked) {
								if (binoculars.ifChose(e) && !ifWantToExit) {
									binoculars.setStart(new MousePoint(800, 500));
									binoculars.setEnd(new MousePoint(950, 600));
									inventory.addItem(binoculars);
									ifBinocularsPicked = true;
									message.setText("I picked binoculars.");
								}
							}
							if (!ifKeyPicked && !ifWantToExit) {
								if (key.ifChose(e)) {
									key.setStart(new MousePoint(10, 10));
									key.setEnd(new MousePoint(120, 95));
									inventory.addItem(key);
									ifKeyPicked = true;
									message.setText("I picked a key.");
								}
							}
						}
						if (ifCodeLaibraryCloseTwice && !ifWantToExit) {
							if (button1.ifClicked(e) && !ifCodeLaibrary) {
								accum = accum + "B";
							}
							if (button2.ifClicked(e) && !ifCodeLaibrary) {
								accum = accum + "G";
							}
							if (button3.ifClicked(e) && !ifCodeLaibrary) {
								accum = accum + "O";
							}
							if (button4.ifClicked(e) && !ifCodeLaibrary) {
								accum = accum + "P";
							}
							if (button5.ifClicked(e) && !ifCodeLaibrary) {
								accum = accum + "R";
							}
							if (button6.ifClicked(e) && !ifCodeLaibrary) {
								accum = accum + "W";
							}
							if (button7.ifClicked(e) && !ifCodeLaibrary) {
								accum = accum + "*";
							}
							if (button8.ifClicked(e) && !ifCodeLaibrary) {
								accum = accum + "Y";
							}
							String print = accum;
							int left = 4 - accum.length(), i;
							for (i = 1; i <= left; i++) {
								print = print + '*';
							}
							print = print + " press ok";
							if (!ifCodeLaibrary) {
								message.setText(print);
							}
							if (accum.length() > 4) {
								message.setText("Wrong code.");
								closeCodeLaibraryTwice.setImg("/closeCodeLaibraryNotCorrect.png");
								accum = "";
							}
							// ok button
							if (button9.ifClicked(e) && !ifCodeLaibrary) {
								if (theCode.compareTo(accum) == 0) {
									ifCodeLaibrary = true;
									message.setText("Correct!");
									closeCodeLaibraryTwice.setImg("/closeCodeLaibraryCorrect.png");
								} else {
									message.setText("Wrong code.");
									closeCodeLaibraryTwice.setImg("/closeCodeLaibraryNotCorrect.png");
									accum = "";
								}
							}
						}
						if (e.getX() >= 1015 && e.getX() <= 1210 && e.getY() >= 135 && e.getY() <= 270
								&& !ifCodeLaibrary) {
							message.setText("**** press ok");
							ifCodeLaibraryCloseTwice = true;
						}

					}
				}
			}
			/**
			 * second wall
			 */
			else {
				if (backWall.ifClicked(e) && !ifCloseFrame && !ifWantToExit) {
					ifFirstWall = true;
				}
				// not close frame
				if (!ifCloseFrame) {
					if (e.getX() >= 615 && e.getX() <= 705 && e.getY() >= 500 && e.getY() <= 580 && !ifWantToExit) {
						ifStandClose = true;
						ifCloseFrame = true;
					}
					if (door.ifClicked(e) && !ifWantToExit) {
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
					if (mirror.ifClicked(e) && !ifWantToExit) {
						if (ifMirrorBroken) {
							if (accessToSecreteRoom) {
								ifSecreteRoom = true;
								ifCloseFrame = true;
							}
						}
					}
					if (mirror.ifClicked(e) && ifGlobeChoose && !ifWantToExit) {
						se.setFile(glassS);
						se.play();
						try {
							Thread.sleep(100);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						ifMirrorBroken = true;
					}
					if (ifMirrorBroken && !ifWantToExit) {
						mirror.setImg("/mirror10Broken.png");
						ifGlobeChoose = false;
						ifGlobeDeleted = true;
						inventory.deleteItem(globe);
						accessToSecreteRoom = true;
					}
					if (mirror.ifClicked(e) && !ifWantToExit) {
						if (!ifMirrorBroken) {
							message.setText("An ancient mirror.");
						}
					}
					if (!ifBoxLocked && !ifWantToExit) {
						if (box.ifClicked(e) && !ifLanternPicked) {
							inventory.addItem(lantern);
							ifLanternPicked = true;
							message.setText("I picked a flashlight.");
						}
					}
					if (box.ifClicked(e) && !ifWantToExit) {
						if (ifKeyChoose) {
							ifBoxLocked = false;
							ifKeyChoose = false;
							ifKeyDeleted = true;
							inventory.deleteItem(key);
							box.setImg("/treasureBoxUnlock.png");
						}
						if (ifBoxLocked) {
							message.setText("It's locked.");
						}
					}
				} else {
					if (ifStandClose) {
						if (back7.ifClicked(e) && !ifWantToExit) {
							ifCloseFrame = false;
							ifStandClose = false;
						}
						if (e.getX() >= 965 && e.getX() <= 1045 && e.getY() >= 360 && e.getY() <= 465
								&& !ifWantToExit) {
							if (!ifFinalKeyPicked) {
								closeCoatStand.setImg("/closeCoatStendWithoutKey.png");
								inventory.addItem(finalKey);
								message.setText("I picked a key.");
								ifFinalKeyPicked = true;
							}
						}
					}
					if (ifSecreteRoom && !ifWantToExit) {
						if (back5.ifClicked(e) && !ifCloseCupboard && !ifWantToExit) {
							ifSecreteRoom = false;
							ifCloseFrame = false;
							ifLanternChoose = false;
							lantern.setImg("/lantern.png");
						}
						if (spider.ifClicked(e) && !ifCloseCupboard && !ifWantToExit) {
							ifSpiderMoved = !ifSpiderMoved;
							if (ifSpiderMoved == false) {
								spider.setStart(new MousePoint(190, 490));
								spider.setEnd(new MousePoint(310, 580));
							}
							if (ifSpiderMoved == true) {
								spider.setStart(new MousePoint(300, 750));
								spider.setEnd(new MousePoint(410, 840));
							}
						}
						if (picture2.ifClicked(e) && !ifCloseCupboard && !ifWantToExit) {
							message.setText("Hmmm...Wonder if i saw it befor.");
						}
						if (ifCloseCupboardFlag) {
							if (validityOfClock) {
								if (book.ifChose(e) && !ifBookPicked && !ifWantToExit) {
									ifBookPicked = true;
									book.setStart(new MousePoint(800, 850));
									book.setEnd(new MousePoint(950, 950));
									inventory.addItem(book);
								}
							}
							if (back6.ifClicked(e) && !ifWantToExit) {
								c1.setImg("/12.10.png");
								c2.setImg("/12.10.png");
								c3.setImg("/12.10.png");
								c4.setImg("/12.10.png");
								b1 = 12;
								b2 = 12;
								b3 = 12;
								b4 = 12;
								ifCloseCupboard = false;
							}
							if (c1.ifClicked(e) && validityOfClock == false) {
								Room10CodeHelper helper = new Room10CodeHelper(c1, b1);
								b1 = helper.getNewNumber();
								if (b1 == 12) {
									c1.setImg("/12.10.png");
								}
								if (b1 == 3) {
									c1.setImg("/3.10.png");
								}
								if (b1 == 6) {
									c1.setImg("/6.10.png");
								}
								if (b1 == 9) {
									c1.setImg("/9.10.png");
								}
							}
							if (c2.ifClicked(e) && validityOfClock == false) {
								Room10CodeHelper helper = new Room10CodeHelper(c2, b2);
								b2 = helper.getNewNumber();
								if (b2 == 12) {
									c2.setImg("/12.10.png");
								}
								if (b2 == 3) {
									c2.setImg("/3.10.png");
								}
								if (b2 == 6) {
									c2.setImg("/6.10.png");
								}
								if (b2 == 9) {
									c2.setImg("/9.10.png");
								}
							}
							if (c3.ifClicked(e) && validityOfClock == false) {
								Room10CodeHelper helper = new Room10CodeHelper(c3, b3);
								b3 = helper.getNewNumber();
								if (b3 == 12) {
									c3.setImg("/12.10.png");
								}
								if (b3 == 3) {
									c3.setImg("/3.10.png");
								}
								if (b3 == 6) {
									c3.setImg("/6.10.png");
								}
								if (b3 == 9) {
									c3.setImg("/9.10.png");
								}
							}
							if (c4.ifClicked(e) && validityOfClock == false) {
								Room10CodeHelper helper = new Room10CodeHelper(c4, b4);
								b4 = helper.getNewNumber();
								if (b4 == 12) {
									c4.setImg("/12.10.png");
								}
								if (b4 == 3) {
									c4.setImg("/3.10.png");
								}
								if (b4 == 6) {
									c4.setImg("/6.10.png");
								}
								if (b4 == 9) {
									c4.setImg("/9.10.png");
								}
							}
							if (b1 == 3 && b2 == 6 && b3 == 3 && b4 == 9) {
								validityOfClock = true;
							}
							if (validityOfClock) {
								drawer.setImg("/openDrawer10.png");
								drawer.setStart(new MousePoint(10, 10));
								drawer.setEnd(new MousePoint(1510, 1000));
							}
						}
						if (cupboard.ifClicked(e)) {
							if (e.getX() >= 290 && e.getX() <= 435 && e.getY() >= 614 && e.getY() <= 680
									&& !ifWantToExit) {
								ifCloseCupboard = true;
							}
						}
						if (ifCloseCupboard && !ifWantToExit) {
							ifCloseCupboardFlag = true;
						}
						if (ifLanternChoose) {
							ifDark = false;
						} else {
							ifDark = true;
						}
						if (ifDark) {
							secreteRoom.setImg("/secreteDark.jpg");
							message.setText("It's too dark. I can't see anything.");
						} else {
							secreteRoom.setImg("/secreteNotDark.jpg");
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
		}
		if (!ifCloseFrame && !ifFirstWall && !ifSecreteRoom) {
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
				if (!ifGlobePicked) {
					globe.paintComponent(g);
				}
			}
			if (Outside) {
				outside.paintComponent(g);
				back1.paintComponent(g);
			}
			if (ifLaibraryClose) {
				if (ifBookClose) {
					closeBook.paintComponent(g);
				} else {
					closeLaibrary.paintComponent(g);
				}
				back2.paintComponent(g);
			}
			if (ifSofaClose) {
				closeSofa.paintComponent(g);
				back3.paintComponent(g);
			}
			if (ifCodeLaibraryClose) {
				if (!ifCodeLaibraryCloseTwice) {
					closeCodeLaibrary.paintComponent(g);
				} else {
					closeCodeLaibraryTwice.paintComponent(g);
					button1.paintComponent(g);
					button2.paintComponent(g);
					button3.paintComponent(g);
					button4.paintComponent(g);
					button5.paintComponent(g);
					button6.paintComponent(g);
					button7.paintComponent(g);
					button8.paintComponent(g);
					button9.paintComponent(g);
				}
				if (ifCodeLaibrary) {
					if (!ifBinocularsPicked && ifSecondTimeOpen) {
						binoculars.paintComponent(g);
					}
					if (!ifKeyPicked && ifSecondTimeOpen) {
						key.paintComponent(g);
					}
				}
				back4.paintComponent(g);
			}
		}
		/**
		 * second wall
		 */
		else {
			if (!ifCloseFrame) {
				backWall.paintComponent(g);
			} else {
				if (ifStandClose) {
					closeCoatStand.paintComponent(g);
					back7.paintComponent(g);
				}
				if (ifSecreteRoom) {
					secreteRoom.paintComponent(g);
					if (!ifCloseCupboard) {
						back5.paintComponent(g);
					}
					if (!ifDark && !(ifCloseCupboard && validityOfClock)) {
						for (Clickable c : listClickablesSecrete) {
							c.paintComponent(g);
						}
					}
					if (ifCloseCupboard && !ifDark) {
						drawer.paintComponent(g);
						back6.paintComponent(g);
						if (!validityOfClock) {
							c1.paintComponent(g);
							c2.paintComponent(g);
							c3.paintComponent(g);
							c4.paintComponent(g);
						}
						if (validityOfClock && !ifBookPicked) {
							book.paintComponent(g);
						}
					}
				}
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
