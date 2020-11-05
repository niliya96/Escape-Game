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

public class Room6 extends JPanel implements Room {
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
	String shalterS = "/shalter_sound.wav";
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
	// true if the teddy is close
	boolean ifTeddyClose = false;
	// true if the star picked
	boolean ifStarPicked = false;
	// true if the star is chosed
	boolean ifStarChoose = false;
	// true if the star is in the box
	boolean ifStarInBox = false;
	// true if the hexagon picked
	boolean ifHexagonPicked = false;
	// true if the hexagon is chosed
	boolean ifHexagonChoose = false;
	// true if the hexagon is in the box
	boolean ifHexagonInBox = false;
	// true if the heart picked
	boolean ifHeartPicked = false;
	// true if the heart is chosed
	boolean ifHeartChoose = false;
	// true if the heart is in the box
	boolean ifHeartInBox = false;
	// true if the circle picked
	boolean ifCirclePicked = false;
	// true if the circle is chosed
	boolean ifCircleChoose = false;
	// true if the circle is in the box
	boolean ifCircleInBox = false;
	// true if the sicssors picked
	boolean ifSicssorsPicked = false;
	// true if the sicssors is chosed
	boolean ifSicssorsChoose = false;
	// true if the key picked
	boolean ifKeyPicked = false;
	// true if the key is chosed
	boolean ifKeyChoose = false;
	// true if the pillow moved - initializes to true to avoid bugs
	boolean ifPillowMoved = true;
	// true if the sofa is close
	boolean ifCloseSofa = false;
	// true if the books are close
	boolean ifBooksClose = false;
	// true if book1 is close
	boolean ifBook1Close = false;
	// true if the box is close
	boolean ifBoxClose = false;
	// true if the box is open
	boolean ifBoxOpen = false;
	// true if the down drawer is close
	boolean ifDrawerDownClose = false;;
	// true if thr code of the drawer is solved
	boolean ifCode = false;
	// true if the sofa is close with hole
	boolean ifCloseHole = false;
	// true if the hole made
	boolean ifHoleMade = false;
	// true if door is open
	boolean ifDoorOpen = false;
	// true if scissors deleted
	boolean ifScissorsDeleted = false;
	// true if star deleted
	boolean ifStarDeleted = false;
	// true if heart deleted
	boolean ifHeartDeleted = false;
	// true if Hexagon deleted
	boolean ifHexagonDeleted = false;
	// true if circle deleted
	boolean ifCircleDeleted = false;
	// true if key deleted
	boolean ifKeyDeleted = false;
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
	ClickedObject books;
	ClickedObject box;
	ClickedObject boxClose;
	ClickedObject buttonHeart;
	ClickedObject buttonCircle;
	ClickedObject buttonSquare;
	ClickedObject buttonStar;
	Clickable cactus;
	Background closeSofa;
	Background closeHole;
	Clickable cupboard;
	Clickable dices;
	ClickedObject door;
	ClickedObject drawerDown;
	Clickable lamp;
	ClickedObject pillow;
	Clickable shelf;
	ClickedObject sofa;
	ClickedObject teddyBear;
	ClickedObject menu;
	ClickedObject wantToExit;
	ClickedObject vi;
	ClickedObject x;
	/**
	 * inventory items
	 */
	InventoryItem star;
	InventoryItem hexagon;
	InventoryItem heart;
	InventoryItem circle;
	InventoryItem sicssors;
	InventoryItem key;
	// others
	int counterCode = 0;
	String accumulated = "";
	String theCode = "HSRC";

	/**
	 * @param w
	 * @param game
	 * @param f
	 * @param i
	 */
	public Room6(WallBegin w, GamePanel game, JFrame f, InventoryPanel i) {
		super();
		this.inventory = i;
		this.wb = w;
		this.frame = f;
		this.game = game;
		this.message = this.game.panel.getText();
		String path = "/room6.png";
		this.background = new ImageReader(path);
		// back button
		back1 = new ClickedObject("/back.png", new MousePoint(1430, 15), new MousePoint(1505, 85));
		back2 = new ClickedObject("/back.png", new MousePoint(1430, 15), new MousePoint(1505, 85));
		back3 = new ClickedObject("/back.png", new MousePoint(1430, 15), new MousePoint(1505, 85));
		back4 = new ClickedObject("/back.png", new MousePoint(1430, 15), new MousePoint(1505, 85));
		back5 = new ClickedObject("/back.png", new MousePoint(1430, 15), new MousePoint(1505, 85));
		back6 = new ClickedObject("/back.png", new MousePoint(1430, 15), new MousePoint(1505, 85));
		back7 = new ClickedObject("/back.png", new MousePoint(1430, 15), new MousePoint(1505, 85));
		// clickables
		menu = new ClickedObject("/menu.png", new MousePoint(1275, 10), new MousePoint(1420, 95));
		wantToExit = new ClickedObject("/wantToExit.png", new MousePoint(300, 200), new MousePoint(1300, 800));
		vi = new ClickedObject("/vi.png", new MousePoint(600, 550), new MousePoint(700, 650));
		x = new ClickedObject("/x.png", new MousePoint(900, 550), new MousePoint(1000, 650));
		door = new ClickedObject("/door2.jpg", new MousePoint(950, 245), new MousePoint(1250, 763));
		listClickables.add(door);
		cupboard = new ClickedObject("/cupboard6.png", new MousePoint(700, 530), new MousePoint(920, 790));
		listClickables.add(cupboard);
		box = new ClickedObject("/box6.png", new MousePoint(725, 435), new MousePoint(895, 555));
		listClickables.add(box);
		sofa = new ClickedObject("/sofa6.png", new MousePoint(150, 490), new MousePoint(700, 800));
		listClickables.add(sofa);
		shelf = new ClickedObject("/shelf6.png", new MousePoint(180, 280), new MousePoint(670, 340));
		listClickables.add(shelf);
		pillow = new ClickedObject("/pillow2.png", new MousePoint(250, 555), new MousePoint(360, 650));
		listClickables.add(pillow);
		closeSofa = new Background("/closeSofaWithShape.png", new MousePoint(10, 10), new MousePoint(1510, 1000));
		closeHole = new Background("/sofaHoleWithCircle.png", new MousePoint(10, 10), new MousePoint(1510, 1000));
		dices = new ClickedObject("/dices1Shapes.png", new MousePoint(220, 650), new MousePoint(650, 860));
		listClickables.add(dices);
		cactus = new ClickedObject("/cactus4.png", new MousePoint(355, 165), new MousePoint(465, 293));
		listClickables.add(cactus);
		lamp = new ClickedObject("/lamp2.png", new MousePoint(1250, 300), new MousePoint(1440, 800));
		listClickables.add(lamp);
		teddyBear = new ClickedObject("/teddy1.png", new MousePoint(480, 150), new MousePoint(620, 300));
		listClickables.add(teddyBear);
		books = new ClickedObject("/books3.png", new MousePoint(210, 165), new MousePoint(330, 290));
		listClickables.add(books);
		drawerDown = new ClickedObject("/Drawer6Code.png", new MousePoint(500, 500), new MousePoint(1100, 750));
		boxClose = new ClickedObject("/boxClose.png", new MousePoint(10, 10), new MousePoint(1510, 1000));
		buttonCircle = new ClickedObject("/circle.png", new MousePoint(705, 640), new MousePoint(780, 705));
		buttonHeart = new ClickedObject("/heart.png", new MousePoint(910, 640), new MousePoint(985, 705));
		buttonStar = new ClickedObject("/star.png", new MousePoint(605, 640), new MousePoint(680, 705));
		buttonSquare = new ClickedObject("/square.png", new MousePoint(810, 640), new MousePoint(885, 705));
		// inventory items
		star = new InventoryItem("/star1.png", new MousePoint(50, 50), new MousePoint(150, 140));
		hexagon = new InventoryItem("/hexagon1.png", new MousePoint(50, 50), new MousePoint(152, 135));
		heart = new InventoryItem("/heart1.png", new MousePoint(860, 435), new MousePoint(1075, 580));
		circle = new InventoryItem("/circle1.png", new MousePoint(50, 50), new MousePoint(150, 140));
		sicssors = new InventoryItem("/scissors.png", new MousePoint(360, 440), new MousePoint(770, 570));
		key = new InventoryItem("/key2.png", new MousePoint(630, 525), new MousePoint(855, 650));
		addMouseListener(new MyMouseListener());
		addMouseMotionListener(new MyMouseListener());
	}

	// an inner class. Here occur most of the interaction with the mouse.
	class MyMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			message.setFont(new Font("Ariel", Font.BOLD, 25));
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
			if (ifMessageNoComment) {
				message.setText(" ");
			}
			if (ifDoorLocked && !ifWantToExit) {
				if (ifKeyPicked && ifKeyChoose && door.ifClicked(e)) {
					ifDoorLocked = false;
					ifKeyChoose = false;
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
				door.setStart(new MousePoint(950, 245));
				door.setEnd(new MousePoint(1250, 777));
				door.setImg("/door2Open.png");
			}
			if (exitStatus) {
				exitRoom();
			}
			/**
			 * inventory items
			 */
			if (star.ifChose(e) && ifStarPicked && !ifStarDeleted && !ifWantToExit) {
				ifStarChoose = !ifStarChoose;
				ifHexagonChoose = false;
				ifHeartChoose = false;
				ifCircleChoose = false;
				ifKeyChoose = false;
				ifSicssorsChoose = false;
			}
			if (hexagon.ifChose(e) && ifHexagonPicked && !ifHexagonDeleted && !ifWantToExit) {
				ifHexagonChoose = !ifHexagonChoose;
				ifStarChoose = false;
				ifHeartChoose = false;
				ifCircleChoose = false;
				ifKeyChoose = false;
				ifSicssorsChoose = false;
			}
			if (heart.ifChose(e) && ifHeartPicked && !ifHeartDeleted && !ifWantToExit) {
				ifHeartChoose = !ifHeartChoose;
				ifHexagonChoose = false;
				ifStarChoose = false;
				ifCircleChoose = false;
				ifKeyChoose = false;
				ifSicssorsChoose = false;
			}
			if (circle.ifChose(e) && ifCirclePicked && !ifCircleDeleted && !ifWantToExit) {
				ifCircleChoose = !ifCircleChoose;
				ifHexagonChoose = false;
				ifHeartChoose = false;
				ifStarChoose = false;
				ifKeyChoose = false;
				ifSicssorsChoose = false;
			}
			if (sicssors.ifChose(e) && ifSicssorsPicked && !ifScissorsDeleted && !ifWantToExit) {
				ifSicssorsChoose = !ifSicssorsChoose;
				ifHexagonChoose = false;
				ifHeartChoose = false;
				ifCircleChoose = false;
				ifKeyChoose = false;
				ifStarChoose = false;
			}
			if (key.ifChose(e) && ifKeyPicked && !ifKeyDeleted && !ifWantToExit) {
				ifKeyChoose = !ifKeyChoose;
				ifHexagonChoose = false;
				ifHeartChoose = false;
				ifCircleChoose = false;
				ifSicssorsChoose = false;
				ifStarChoose = false;
			}
			if (ifStarChoose) {
				star.setImg("/star1Choose.png");
			} else {
				star.setImg("/star1.png");
			}
			if (ifHexagonChoose) {
				hexagon.setImg("/hexagon1Choose.png");
			} else {
				hexagon.setImg("/hexagon1.png");
			}
			if (ifHeartChoose) {
				heart.setImg("/heart1Choose.png");
			} else {
				heart.setImg("/heart1.png");
			}
			if (ifCircleChoose) {
				circle.setImg("/circle1Choose.png");
			} else {
				circle.setImg("/circle1.png");
			}
			if (ifSicssorsChoose) {
				sicssors.setImg("/scissorsChoose.png");
			} else {
				sicssors.setImg("/scissors.png");
			}
			if (ifKeyChoose) {
				key.setImg("/key2Choose.png");
			} else {
				key.setImg("/key2.png");
			}
			if (!ifCloseFrame) {
				if (dices.ifClicked(e) && !ifTeddyClose && !ifBooksClose && !ifDrawerDownClose && !ifWantToExit) {
					message.setText("Dices or a coffee table?");
				}
				if (door.ifClicked(e) && !ifTeddyClose && !ifBooksClose && !ifDrawerDownClose && ifDoorLocked
						&& !ifDoorOpen && !ifWantToExit) {
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
				if (cactus.ifClicked(e) && !ifTeddyClose && !ifBooksClose && !ifDrawerDownClose && !ifWantToExit) {
					message.setText("I don't want to tuch it.");
				}
				if (lamp.ifClicked(e) && !ifTeddyClose && !ifBooksClose && !ifDrawerDownClose && !ifWantToExit) {
					message.setText("Light is on.");
				}
				if (teddyBear.ifClicked(e) && !ifBook1Close && !ifBooksClose && !ifWantToExit) {
					ifTeddyClose = true;
				}
				// upper drawer
				if (e.getX() >= 730 && e.getX() <= 885 && e.getY() >= 595 && e.getY() <= 650 && !ifTeddyClose
						&& !ifBooksClose && !ifDrawerDownClose && !ifWantToExit) {
					message.setText("Nothing happens.");
				}
				if (ifTeddyClose) {
					teddyBear.setStart(new MousePoint(500, 200));
					teddyBear.setEnd(new MousePoint(1100, 800));
					if (back1.ifClicked(e) && !ifWantToExit) {
						teddyBear.setStart(new MousePoint(480, 150));
						teddyBear.setEnd(new MousePoint(620, 300));
						ifTeddyClose = false;
					}
					if (e.getX() >= 775 && e.getX() <= 820 && e.getY() >= 345 && e.getY() <= 400 && !ifWantToExit) {
						if (!ifStarPicked) {
							inventory.addItem(star);
						}
						ifStarPicked = true;
						teddyBear.setImg("/teddy1WithoutEye.png");
					}
				}
				if (!ifPillowMoved) {
					if (e.getX() >= 250 && e.getX() <= 355 && e.getY() >= 545 && e.getY() <= 645 && !ifWantToExit) {
						ifCloseSofa = true;
						ifCloseFrame = true;
					}
				}
				if (ifHoleMade) {
					if (e.getX() >= 510 && e.getX() <= 590 && e.getY() >= 625 && e.getY() <= 660 && !ifWantToExit) {
						ifCloseHole = true;
						ifCloseFrame = true;
					}
				}
				if (pillow.ifClicked(e) && !ifWantToExit) {
					if (ifPillowMoved) {
						pillow.setStart(new MousePoint(350, 555));
						pillow.setEnd(new MousePoint(460, 650));
						ifPillowMoved = false;
					} else {
						pillow.setStart(new MousePoint(250, 555));
						pillow.setEnd(new MousePoint(360, 650));
						ifPillowMoved = true;
					}
				}
				if (books.ifClicked(e) && !ifTeddyClose && !ifWantToExit) {
					ifBooksClose = true;
				}
				if (ifBooksClose) {
					books.setStart(new MousePoint(600, 450));
					books.setEnd(new MousePoint(1000, 850));
					if (back3.ifClicked(e) && !ifWantToExit) {
						books.setStart(new MousePoint(210, 165));
						books.setEnd(new MousePoint(330, 290));
						ifBooksClose = false;
					}
					if (e.getX() >= 730 && e.getX() <= 810 && e.getY() >= 465 && e.getY() <= 840 && !ifTeddyClose
							&& !ifWantToExit) {
						ifBook1Close = true;
					}
				}
				if (ifBook1Close) {
					books.setStart(new MousePoint(600, 100));
					books.setEnd(new MousePoint(1450, 700));
					books.setImg("/closeBook6.png");
					if (back4.ifClicked(e) && !ifWantToExit) {
						ifBooksClose = false;
						ifBook1Close = false;
						books.setStart(new MousePoint(210, 165));
						books.setEnd(new MousePoint(330, 290));
						books.setImg("/books3.png");
					}
				}
				if (box.ifClicked(e) && !ifTeddyClose && !ifBooksClose && !ifDrawerDownClose && !ifWantToExit) {
					ifBoxClose = true;
					ifCloseFrame = true;
				}
				if (e.getX() >= 730 && e.getX() <= 885 && e.getY() >= 685 && e.getY() <= 745 && !ifWantToExit) {
					ifDrawerDownClose = true;
				}
				if (ifDrawerDownClose && !ifWantToExit) {
					if (back5.ifClicked(e) && !ifWantToExit) {
						accumulated = "";
						counterCode = 0;
						message.setText(" ");
						ifDrawerDownClose = false;
					}
					Room6CodeHelper pressHelper = new Room6CodeHelper();
					if (!ifCode) {
						if (pressHelper.ifStar(e)) {
							accumulated = accumulated + "S";
							counterCode++;
						}
						if (pressHelper.ifCircle(e)) {
							accumulated = accumulated + "C";
							counterCode++;
						}
						if (pressHelper.ifSquer(e)) {
							accumulated = accumulated + "R";
							counterCode++;
						}
						if (pressHelper.ifHeart(e)) {
							accumulated = accumulated + "H";
							counterCode++;
						}
						String print = accumulated;
						int left = 4 - accumulated.length(), i;
						for (i = 1; i <= left; i++) {
							print = print + '*';
						}
						if (!ifCode) {
							message.setText(print);
						}
						if (accumulated.compareTo("HSRC") == 0) {
							message.setText("Correct!");
							ifCode = true;
						}
						if (counterCode >= 4 && accumulated.compareTo(theCode) != 0) {
							message.setText("Wrong code.");
							counterCode = 0;
							accumulated = "";
						}
					}
					if (ifCode) {
						drawerDown.setImg("/drawer6down.png");
						drawerDown.setStart(new MousePoint(10, 10));
						drawerDown.setEnd(new MousePoint(1510, 1000));
						if (heart.ifChose(e) && !ifHeartPicked && !ifWantToExit) {
							heart.setStart(new MousePoint(50, 50));
							heart.setEnd(new MousePoint(150, 140));
							inventory.addItem(heart);
							ifHeartPicked = true;
						}
						if (sicssors.ifChose(e) && !ifSicssorsPicked && !ifWantToExit) {
							sicssors.setStart(new MousePoint(50, 50));
							sicssors.setEnd(new MousePoint(165, 150));
							inventory.addItem(sicssors);
							ifSicssorsPicked = true;
						}
					}
					if (back5.ifClicked(e) && !ifWantToExit) {
						message.setText(" ");
					}
				}
				// sofa - where we make hole
				if (e.getX() >= 430 && e.getX() <= 625 && e.getY() >= 625 && e.getY() <= 670 && !ifWantToExit) {
					if (ifSicssorsChoose) {
						sofa.setImg("/sofa6Hole.png");
						ifHoleMade = true;
						ifSicssorsChoose = false;
						ifScissorsDeleted = true;
						inventory.deleteItem(sicssors);
					}
				}
			} else {
				// a close frame of the sofa
				if (ifCloseSofa) {
					if (back2.ifClicked(e) && !ifWantToExit) {
						ifCloseSofa = false;
						ifCloseFrame = false;
					}
					// close sofa where we pick the hexagon
					if (e.getX() >= 695 && e.getX() <= 770 && e.getY() >= 430 && e.getY() <= 495 && !ifWantToExit) {
						if (!ifHexagonPicked) {
							inventory.addItem(hexagon);
						}
						ifHexagonPicked = true;
						closeSofa.setImg("/closeSofaWithoutShape.png");
					}
				}
				// a close frame of the Hole
				if (ifCloseHole) {
					if (back7.ifClicked(e) && !ifWantToExit) {
						ifCloseHole = false;
						ifCloseFrame = false;
					}
					// close sofa where we pick the circle
					if (e.getX() >= 680 && e.getX() <= 920 && e.getY() >= 480 && e.getY() <= 670 && !ifWantToExit) {
						if (!ifCirclePicked) {
							inventory.addItem(circle);
						}
						ifCirclePicked = true;
						closeHole.setImg("/sofaHoleWithoutCircle.png");
					}
				}
				// a close frame of the box
				if (ifBoxOpen && !ifWantToExit) {
					if (key.ifChose(e) && !ifKeyPicked) {
						key.setStart(new MousePoint(10, 10));
						key.setEnd(new MousePoint(120, 95));
						inventory.addItem(key);
						ifKeyPicked = true;
					}
					if (back5.ifClicked(e) && !ifWantToExit) {
						ifBoxClose = false;
						ifCloseFrame = false;
					}
				}
				if (ifBoxClose && !ifBoxOpen && !ifWantToExit) {
					int flag = 0;
					if (ifHeartChoose) {
						if (e.getX() >= 875 && e.getX() <= 995 && e.getY() >= 425 && e.getY() <= 545) {
							ifHeartInBox = true;
							flag = 1;
							ifHeartChoose = false;
							ifHeartDeleted = true;
							inventory.deleteItem(heart);
						}
					}
					if (ifHexagonChoose) {
						if (e.getX() >= 550 && e.getX() <= 700 && e.getY() >= 425 && e.getY() <= 545) {
							ifHexagonInBox = true;
							flag = 1;
							ifHexagonChoose = false;
							ifHexagonDeleted = true;
							inventory.deleteItem(hexagon);
						}
					}
					if (ifStarChoose) {
						if (e.getX() >= 865 && e.getX() <= 1010 && e.getY() >= 190 && e.getY() <= 315) {
							ifStarInBox = true;
							flag = 1;
							ifStarChoose = false;
							ifStarDeleted = true;
							inventory.deleteItem(star);
						}
					}
					if (ifCircleChoose) {
						if (e.getX() >= 565 && e.getX() <= 685 && e.getY() >= 200 && e.getY() <= 300) {
							ifCircleInBox = true;
							flag = 1;
							ifCircleChoose = false;
							ifCircleDeleted = true;
							inventory.deleteItem(circle);
						}
					}
					if (e.getX() >= 365 && e.getX() <= 1120 && e.getY() >= 120 && e.getY() <= 950 && flag == 0
							&& !(ifHeartInBox && ifHexagonInBox && ifStarInBox && ifCircleInBox)) {
						message.setText("Can't open it right now.");
					}
					if (!ifHeartInBox && !ifStarInBox && !ifCircleInBox && !ifHexagonInBox) {
						boxClose.setImg("/boxClose.png");
					}
					if (ifHeartInBox && !ifStarInBox && !ifCircleInBox && !ifHexagonInBox) {
						boxClose.setImg("/boxCloseH.png");
					}
					if (!ifHeartInBox && !ifStarInBox && !ifCircleInBox && ifHexagonInBox) {
						boxClose.setImg("/boxCloseM.png");
					}
					if (!ifHeartInBox && ifStarInBox && !ifCircleInBox && !ifHexagonInBox) {
						boxClose.setImg("/boxCloseS.png");
					}
					if (ifHeartInBox && !ifStarInBox && !ifCircleInBox && ifHexagonInBox) {
						boxClose.setImg("/boxCloseHM.png");
					}
					if (ifHeartInBox && ifStarInBox && !ifCircleInBox && !ifHexagonInBox) {
						boxClose.setImg("/boxCloseHS.png");
					}
					if (ifHeartInBox && ifStarInBox && !ifCircleInBox && ifHexagonInBox) {
						boxClose.setImg("/boxCloseHSM.png");
					}
					if (!ifHeartInBox && ifStarInBox && !ifCircleInBox && ifHexagonInBox) {
						boxClose.setImg("/boxCloseSM.png");
					}
					if (!ifHeartInBox && !ifStarInBox && ifCircleInBox && !ifHexagonInBox) {
						boxClose.setImg("/boxCloseC.png");
					}
					if (!ifHeartInBox && ifStarInBox && ifCircleInBox && ifHexagonInBox) {
						boxClose.setImg("/boxCloseSMC.png");
					}
					if (ifHeartInBox && !ifStarInBox && ifCircleInBox && ifHexagonInBox) {
						boxClose.setImg("/boxCloseHMC.png");
					}
					if (ifHeartInBox && ifStarInBox && ifCircleInBox && !ifHexagonInBox) {
						boxClose.setImg("/boxCloseHSC.png");
					}
					if (!ifHeartInBox && !ifStarInBox && ifCircleInBox && ifHexagonInBox) {
						boxClose.setImg("/boxCloseMC.png");
					}
					if (!ifHeartInBox && ifStarInBox && ifCircleInBox && !ifHexagonInBox) {
						boxClose.setImg("/boxCloseSC.png");
					}
					if (ifHeartInBox && !ifStarInBox && ifCircleInBox && !ifHexagonInBox) {
						boxClose.setImg("/boxCloseHC.png");
					}
					if (ifHeartInBox && ifStarInBox && ifCircleInBox && ifHexagonInBox) {
						boxClose.setImg("/boxCloseHSMC.png");
						if (e.getX() >= 390 && e.getX() <= 440 && e.getY() >= 310 && e.getY() <= 490) {
							ifBoxOpen = true;
							boxClose.setImg("/boxCloseOpen6.png");
						}
					}
					flag = 0;
					if (back5.ifClicked(e) && !ifWantToExit) {
						ifBoxClose = false;
						ifCloseFrame = false;
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
			if (ifDrawerDownClose) {
				if (!ifCode) {
					// star
					if (e.getX() >= 605 && e.getX() <= 680 && e.getY() >= 640 && e.getY() <= 705) {
						buttonStar.setStart(new MousePoint(600, 635));
						buttonStar.setEnd(new MousePoint(685, 710));
					} else {
						buttonStar.setStart(new MousePoint(605, 640));
						buttonStar.setEnd(new MousePoint(680, 705));
					}
					// circle
					if (e.getX() >= 705 && e.getX() <= 780 && e.getY() >= 640 && e.getY() <= 705) {
						buttonCircle.setStart(new MousePoint(700, 635));
						buttonCircle.setEnd(new MousePoint(785, 710));
					} else {
						buttonCircle.setStart(new MousePoint(705, 640));
						buttonCircle.setEnd(new MousePoint(780, 705));
					}
					// square
					if (e.getX() >= 810 && e.getX() <= 885 && e.getY() >= 640 && e.getY() <= 705) {
						buttonSquare.setStart(new MousePoint(805, 635));
						buttonSquare.setEnd(new MousePoint(890, 710));
					} else {
						buttonSquare.setStart(new MousePoint(810, 640));
						buttonSquare.setEnd(new MousePoint(885, 705));
					}
					// heart
					if (e.getX() >= 910 && e.getX() <= 985 && e.getY() >= 640 && e.getY() <= 705) {
						buttonHeart.setStart(new MousePoint(905, 635));
						buttonHeart.setEnd(new MousePoint(990, 710));
					} else {
						buttonHeart.setStart(new MousePoint(910, 640));
						buttonHeart.setEnd(new MousePoint(985, 705));
					}
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
		if (ifTeddyClose) {
			back1.paintComponent(g);
		}
		if (ifCloseSofa) {
			closeSofa.paintComponent(g);
			back2.paintComponent(g);
		}
		if (ifCloseHole) {
			closeHole.paintComponent(g);
			back7.paintComponent(g);
		}
		if (ifBooksClose) {
			back3.paintComponent(g);
		}
		if (ifBook1Close) {
			back4.paintComponent(g);
		}
		if (ifBoxClose) {
			boxClose.paintComponent(g);
			back5.paintComponent(g);
		}
		if (ifDrawerDownClose) {
			drawerDown.paintComponent(g);
			if (!ifCode) {
				buttonCircle.paintComponent(g);
				buttonHeart.paintComponent(g);
				buttonSquare.paintComponent(g);
				buttonStar.paintComponent(g);
			}
			back6.paintComponent(g);
			if (!ifHeartPicked && ifCode) {
				heart.paintComponent(g);
			}
			if (!ifSicssorsPicked && ifCode) {
				sicssors.paintComponent(g);
			}
		}
		if (ifBoxOpen) {
			if (!ifKeyPicked) {
				key.paintComponent(g);
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
