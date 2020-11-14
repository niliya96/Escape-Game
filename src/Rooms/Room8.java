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
import Sprites.Clickable;
import Sprites.ClickedObject;
import Sprites.InventoryItem;
import Sprites.SoundEffect;
import Tools.ImageReader;
import Tools.InventoryPanel;
import Tools.MousePoint;
import Tools.Room8CodeHelper;
import Tools.Room8CodeHelper2;
import Tools.WallBegin;

public class Room8 extends JPanel implements Room {
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
	String keyS = "/key_sound.wav";
	String airS = "/air_sound.wav";
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
	// true if the books are close
	boolean ifBooksClose = false;
	// true if drawer1 is close
	boolean ifDrawer1Close = false;
	// true if code1 is correct
	boolean ifCode1 = false;
	// true if drawer2 is close
	boolean ifDrawer2Close = false;
	// true if code2 is correct
	boolean ifCode2 = false;
	// true if drawer3 is close
	boolean ifDrawer3Close = false;
	// true if code3 is correct
	boolean ifCode3 = false;
	// true if the screwdriver picked
	boolean ifScrewdriverPicked = false;
	// true if the screwdriver choose
	boolean ifScrewdriverChoose = false;
	// true if the remote picked
	boolean ifRemotePicked = false;
	// true if the remote choose
	boolean ifRemoteChoose = false;
	// true if the lantern picked
	boolean ifLanternPicked = false;
	// true if the lantern choose
	boolean ifLanternChoose = false;
	// true if the batteries picked
	boolean ifBatteriesPicked = false;
	// true if the batteries choose
	boolean ifBatteriesChoose = false;
	// true if the lamp is on
	boolean ifLampOn = true;
	// true if door is open
	boolean ifDoorOpen = false;
	// true if the chair is moves
	boolean ifChairMoved = false;
	// true if the bulb is picked
	boolean ifBulbPicked = false;
	// true if the bulb is choose
	boolean ifBulbChoose = false;
	// true if the bulb is in the lamp
	boolean ifBulbInLamp = false;
	// true if the lamp is up
	boolean ifLampUp = false;
	// lock the option that the lamp will be in up state in first turn that the bulb
	// is in the lamp
	boolean lock = false;
	// true if the batteries are in the remote
	boolean ifBatteriesIn = false;
	// true if the airconditioner is open
	boolean ifAirconditioner = false;
	// true if the key picked
	boolean ifKeyPicked = false;
	// true if the key choose
	boolean ifKeyChoose = false;
	// true if the key fall
	boolean ifKeyFall = false;
	// true if the batteries are in the inventory
	boolean ifBatteriesInInventory = false;
	// true if the bulb is deleted
	boolean ifBulbDeleted = false;
	// true if the remote is deleted
	boolean ifRemoteDeleted = false;
	// true if the lantern is deleted
	boolean ifLanternDeleted = false;
	// true if the screwdriver is deleted
	boolean ifScrewdriverDeleted = false;
	// true if the batteries is deleted
	boolean ifBatteriesDeleted = false;
	// true if the key is deleted
	boolean ifKeyDeleted = false;
	/**
	 * Clickables
	 */
	ClickedObject airConditioner;
	ClickedObject back1;
	ClickedObject back2;
	ClickedObject back3;
	ClickedObject back4;
	ClickedObject buttonA;
	ClickedObject buttonB;
	ClickedObject buttonC;
	ClickedObject button1;
	ClickedObject button2;
	ClickedObject button3;
	ClickedObject button4;
	ClickedObject num1;
	ClickedObject num2;
	ClickedObject num3;
	ClickedObject books;
	ClickedObject chair;
	Clickable codeA;
	Clickable codeB;
	Clickable desk;
	ClickedObject door;
	ClickedObject drawer2;
	ClickedObject drawer1;
	ClickedObject drawer3;
	ClickedObject deskLamp;
	ClickedObject lamp;
	Clickable window;
	ClickedObject menu;
	ClickedObject mirror;
	Clickable arrow;
	ClickedObject wantToExit;
	ClickedObject vi;
	ClickedObject x;
	Clickable switch_;
	InventoryItem screwdriver;
	InventoryItem lantern;
	InventoryItem batteries;
	InventoryItem bulb;
	InventoryItem remote;
	InventoryItem key;
	// others
	String b1 = "lightBlue";
	String b2 = "lightBlue";
	String b3 = "lightBlue";
	String a1 = "h";
	String a2 = "h";
	String a3 = "h";
	String a4 = "h";
	String accum = "";
	String code3 = "23311231";
	int count = 0;

	/**
	 * @param w
	 * @param game
	 * @param f
	 * @param i
	 */
	public Room8(WallBegin w, GamePanel game, JFrame f, InventoryPanel i) {
		super();
		this.inventory = i;
		this.wb = w;
		this.frame = f;
		this.game = game;
		this.message = this.game.panel.getText();
		String path = "/room8.png";
		this.background = new ImageReader(path);
		back1 = new ClickedObject("/back.png", new MousePoint(1430, 15), new MousePoint(1505, 85));
		back2 = new ClickedObject("/back.png", new MousePoint(1430, 15), new MousePoint(1505, 85));
		back3 = new ClickedObject("/back.png", new MousePoint(1430, 15), new MousePoint(1505, 85));
		back4 = new ClickedObject("/back.png", new MousePoint(1430, 15), new MousePoint(1505, 85));
		menu = new ClickedObject("/menu.png", new MousePoint(1275, 10), new MousePoint(1420, 95));
		wantToExit = new ClickedObject("/wantToExit.png", new MousePoint(300, 200), new MousePoint(1300, 800));
		vi = new ClickedObject("/vi.png", new MousePoint(600, 550), new MousePoint(700, 650));
		x = new ClickedObject("/x.png", new MousePoint(900, 550), new MousePoint(1000, 650));
		door = new ClickedObject("/door1.jpg", new MousePoint(700, 245), new MousePoint(1000, 763));
		listClickables.add(door);
		switch_ = new ClickedObject("/switch.png", new MousePoint(610, 460), new MousePoint(670, 515));
		listClickables.add(switch_);
		arrow = new ClickedObject("/arrow1.png", new MousePoint(1260, 305), new MousePoint(1440, 450));
		listClickables.add(arrow);
		desk = new ClickedObject("/desk5.png", new MousePoint(100, 520), new MousePoint(600, 800));
		listClickables.add(desk);
		codeA = new ClickedObject("/codeA.png", new MousePoint(20, 360), new MousePoint(150, 660));
		codeB = new ClickedObject("/codeB.png", new MousePoint(20, 120), new MousePoint(130, 420));
		airConditioner = new ClickedObject("/airConditioner.png", new MousePoint(70, 100), new MousePoint(600, 270));
		listClickables.add(airConditioner);
		deskLamp = new ClickedObject("/desk_lamp_down.png", new MousePoint(50, 350), new MousePoint(250, 550));
		listClickables.add(deskLamp);
		mirror = new ClickedObject("/mirror.png", new MousePoint(1050, 280), new MousePoint(1250, 555));
		listClickables.add(mirror);
		books = new ClickedObject("/books8.png", new MousePoint(420, 420), new MousePoint(560, 540));
		listClickables.add(books);
		chair = new ClickedObject("/chair8.png", new MousePoint(1200, 480), new MousePoint(1440, 840));
		listClickables.add(chair);
		lamp = new ClickedObject("/lampOn7.png", new MousePoint(760, 20), new MousePoint(960, 250));
		listClickables.add(lamp);
		drawer2 = new ClickedObject("/drawer5.png", new MousePoint(350, 400), new MousePoint(1250, 700));
		drawer3 = new ClickedObject("/drawer5.png", new MousePoint(350, 400), new MousePoint(1250, 700));
		buttonA = new ClickedObject("/lightBlue.png", new MousePoint(500, 530), new MousePoint(640, 670));
		buttonB = new ClickedObject("/lightBlue.png", new MousePoint(730, 530), new MousePoint(870, 670));
		buttonC = new ClickedObject("/lightBlue.png", new MousePoint(960, 530), new MousePoint(1100, 670));
		button1 = new ClickedObject("/h.png", new MousePoint(400, 530), new MousePoint(540, 670));
		button2 = new ClickedObject("/h.png", new MousePoint(620, 530), new MousePoint(760, 670));
		button3 = new ClickedObject("/h.png", new MousePoint(850, 530), new MousePoint(990, 670));
		button4 = new ClickedObject("/h.png", new MousePoint(1060, 530), new MousePoint(1205, 670));
		num1 = new ClickedObject("/1.5.png", new MousePoint(500, 530), new MousePoint(640, 670));
		num2 = new ClickedObject("/2.5.png", new MousePoint(730, 530), new MousePoint(870, 670));
		num3 = new ClickedObject("/3.5.png", new MousePoint(960, 530), new MousePoint(1100, 670));
		drawer1 = new ClickedObject("/drawer5.png", new MousePoint(250, 400), new MousePoint(1350, 700));
		// inventory items
		screwdriver = new InventoryItem("/screwdriver.png", new MousePoint(600, 410), new MousePoint(940, 580));
		remote = new InventoryItem("/remote.png", new MousePoint(675, 400), new MousePoint(875, 595));
		lantern = new InventoryItem("/lantern.png", new MousePoint(600, 410), new MousePoint(940, 580));
		batteries = new InventoryItem("/batteries.png", new MousePoint(10, 10), new MousePoint(120, 95));
		bulb = new InventoryItem("/bulb.png", new MousePoint(10, 10), new MousePoint(120, 95));
		key = new InventoryItem("/key2.png", new MousePoint(135, 745), new MousePoint(210, 780));
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
			/**
			 * inventory items
			 */
			if (key.ifChose(e) && ifKeyPicked && !ifKeyDeleted && !ifWantToExit) {
				ifKeyChoose = !ifKeyChoose;
				ifBulbChoose = false;
				ifLanternChoose = false;
				ifScrewdriverChoose = false;
				ifRemoteChoose = false;
				ifBatteriesChoose = false;
			}
			if (screwdriver.ifChose(e) && ifScrewdriverPicked && !ifScrewdriverDeleted && !ifWantToExit) {
				ifScrewdriverChoose = !ifScrewdriverChoose;
				ifBulbChoose = false;
				ifLanternChoose = false;
				ifRemoteChoose = false;
				ifBatteriesChoose = false;
				ifKeyChoose = false;
			}
			if (lantern.ifChose(e) && ifLanternPicked && !ifLanternDeleted && !ifWantToExit) {
				ifLanternChoose = !ifLanternChoose;
				ifBulbChoose = false;
				ifRemoteChoose = false;
				ifLanternChoose = false;
				ifBatteriesChoose = false;
				ifKeyChoose = false;
			}
			if (remote.ifChose(e) && ifRemotePicked && !ifRemoteDeleted && !ifWantToExit) {
				ifRemoteChoose = !ifRemoteChoose;
				ifBulbChoose = false;
				ifLanternChoose = false;
				ifScrewdriverChoose = false;
				ifKeyChoose = false;
			}
			if (batteries.ifChose(e) && ifBatteriesPicked && !ifBatteriesDeleted && !ifWantToExit) {
				ifBatteriesChoose = !ifBatteriesChoose;
				ifBulbChoose = false;
				ifLanternChoose = false;
				ifScrewdriverChoose = false;
				ifRemoteChoose = false;
				ifKeyChoose = false;
			}
			if (bulb.ifChose(e) && ifBulbPicked && !ifBulbDeleted && !ifWantToExit) {
				ifBulbChoose = !ifBulbChoose;
				ifScrewdriverChoose = false;
				ifLanternChoose = false;
				ifRemoteChoose = false;
				ifBatteriesChoose = false;
				ifKeyChoose = false;
			}
			if (ifKeyChoose) {
				key.setImg("/key2Choose.png");
			} else {
				key.setImg("/key2.png");
			}
			if (ifScrewdriverChoose) {
				screwdriver.setImg("/screwdriverChoose.png");
			} else {
				screwdriver.setImg("/screwdriver.png");
			}
			if (ifLanternChoose) {
				lantern.setImg("/lanternChoose.png");
			} else {
				lantern.setImg("/lantern.png");
			}
			if (ifRemoteChoose) {
				remote.setImg("/remoteChoose.png");
			} else {
				remote.setImg("/remote.png");
			}
			if (ifBatteriesChoose) {
				batteries.setImg("/batteriesChoose.png");
			} else {
				batteries.setImg("/batteries.png");
			}
			if (ifBulbChoose) {
				bulb.setImg("/bulbChoose.png");
			} else {
				bulb.setImg("/bulb.png");
			}
			message.setFont(new Font("Ariel", Font.BOLD, 25));
			if (ifMessageNoComment) {
				message.setText(" ");
			}
			if (ifDoorLocked) {
				if (ifKeyPicked && ifKeyChoose && door.ifClicked(e) && !ifWantToExit) {
					ifDoorLocked = false;
					ifKeyDeleted = true;
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
				door.setStart(new MousePoint(700, 245));
				door.setEnd(new MousePoint(1000, 777));
				door.setImg("/door1Open.png");
			}
			if (exitStatus) {
				exitRoom();
			}
			if (ifRemoteChoose) {
				if (airConditioner.ifClicked(e) && !ifWantToExit) {
					if (ifBatteriesIn) {
						airConditioner.setStart(new MousePoint(-60, 100));
						airConditioner.setEnd(new MousePoint(730, 270));
						airConditioner.setImg("/airconditionerOpen.png");
						se.setFile(airS);
						se.play();
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						ifAirconditioner = true;
						ifRemoteChoose = false;
						ifRemoteDeleted = true;
						inventory.deleteItem(remote);
						if (!ifKeyFall && !ifWantToExit) {
							se.setFile(keyS);
							se.play();
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						ifKeyFall = true;
					} else {
						message.setText("No batteries.");
					}
				}
			}
			if (ifBatteriesChoose && ifRemotePicked && ifBatteriesInInventory && !ifWantToExit) {
				if (remote.ifChose(e)) {
					ifBatteriesChoose = false;
					ifBatteriesDeleted = true;
					inventory.deleteItem(batteries);
					ifBatteriesInInventory = false;
					ifBatteriesIn = true;
					ifRemoteChoose = false;
					remote.setImg("/remote.png");
					message.setText("Now it can work..");
				}
			}
			if (ifScrewdriverChoose) {
				if (lantern.ifChose(e) && !ifBatteriesPicked && !ifWantToExit) {
					ifLanternDeleted = true;
					ifLanternChoose = false;
					ifScrewdriverDeleted = true;
					ifScrewdriverChoose = false;
					inventory.deleteItem(lantern);
					inventory.deleteItem(screwdriver);
					inventory.addItem(batteries);
					ifBatteriesInInventory = true;
					ifScrewdriverChoose = false;
					screwdriver.setImg("/screwdriver.png");
					message.setText("I got batteries.");
					ifBatteriesPicked = true;
				}
			}
			if (!ifCloseFrame) {
				if (ifKeyFall) {
					if (key.ifChose(e) && !ifKeyPicked && !ifWantToExit) {
						key.setStart(new MousePoint(10, 10));
						key.setEnd(new MousePoint(120, 95));
						inventory.addItem(key);
						ifKeyPicked = true;
					}
				}
				if (switch_.ifClicked(e) && !ifBulbPicked && !ifWantToExit) {
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
				if (ifDoorOpen) {
					exitStatus = true;
				}
				if (ifLampOn && !ifBulbPicked) {
					if (ifDoorLocked) {
						lamp.setImg("/lampOn7.png");
					}
				}
				if (!ifLampOn && !ifBulbPicked) {
					if (ifDoorLocked) {
						lamp.setImg("/lampOff7.png");
					}
				}
				if (books.ifClicked(e) && !ifWantToExit) {
					ifBooksClose = true;
				}
				if (mirror.ifClicked(e) && !ifDrawer1Close && !ifDrawer2Close && !ifDrawer3Close && !ifWantToExit) {
					message.setText("A mirror.");
				}
				if (deskLamp.ifClicked(e) && !ifWantToExit) {
					if (ifBulbChoose && !ifBulbInLamp) {
						ifBulbInLamp = true;
						ifBulbChoose = false;
						ifBulbDeleted = true;
						inventory.deleteItem(bulb);
						lock = true;
					}
				}
				if (deskLamp.ifClicked(e) && !ifDrawer1Close && !ifDrawer2Close && !ifDrawer3Close && !ifWantToExit) {
					if (!lock && ifBulbInLamp) {
						ifLampUp = !ifLampUp;
					}
					if (ifLampUp && !lock) {
						if (ifBulbInLamp) {
							deskLamp.setImg("/desk_lamp_up.png");
						} else {
							deskLamp.setImg("/desk_lamp_down.png");
							message.setText("Needs bulb.");
						}
					} else {
						if (ifBulbInLamp) {
							deskLamp.setImg("/desk_lamp_down.png");
						} else {
							deskLamp.setImg("/desk_lamp_down.png");
							message.setText("Needs bulb.");
						}
					}
					if (lock) {
						lock = false;
					}
				}
				if (ifBooksClose) {
					books.setStart(new MousePoint(600, 450));
					books.setEnd(new MousePoint(1000, 850));
					if (back1.ifClicked(e) && !ifWantToExit) {
						books.setStart(new MousePoint(420, 420));
						books.setEnd(new MousePoint(560, 540));
						ifBooksClose = false;
					}
				}
				if (door.ifClicked(e) && !ifDrawer1Close && !ifDrawer2Close && !ifDrawer3Close && ifDoorLocked
						&& !ifWantToExit && !ifChairMoved && !ifBooksClose) {
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
				if (chair.ifClicked(e) && !ifDrawer1Close && !ifDrawer2Close && !ifDrawer3Close && !ifWantToExit) {
					ifChairMoved = !ifChairMoved;
					if (ifChairMoved) {
						chair.setStart(new MousePoint(730, 480));
						chair.setEnd(new MousePoint(970, 840));
					} else {
						chair.setStart(new MousePoint(1200, 480));
						chair.setEnd(new MousePoint(1440, 840));
					}
				}
				if (ifChairMoved) {
					if (lamp.ifClicked(e) && !ifDrawer1Close && !ifDrawer2Close && !ifDrawer3Close && !ifWantToExit) {
						if (ifLampOn) {
							message.setText("Too warm, I can't do anything");
						} else {
							if (!ifBulbPicked && !ifWantToExit) {
								inventory.addItem(bulb);
								ifBulbPicked = true;
							}
							lamp.setImg("/lampOffWithoutBulb.png");
						}
					}
				}
				// drawer3
				if (ifDrawer3Close && !ifWantToExit) {
					if (num1.ifClicked(e) && !ifCode3) {
						count++;
						accum = accum + "1";
					}
					if (num2.ifClicked(e) && !ifCode3) {
						count++;
						accum = accum + "2";
					}
					if (num3.ifClicked(e) && !ifCode3) {
						count++;
						accum = accum + "3";
					}
					String print = accum;
					int left = 8 - accum.length(), i;
					for (i = 1; i <= left; i++) {
						print = print + '*';
					}
					if (!ifCode3) {
						message.setText(print);
					}
					if (code3.compareTo(accum) != 0 && count == 8 && !ifCode3) {
						message.setText("Wrong code.");
						accum = "";
						count = 0;
					}
					if (code3.compareTo(accum) == 0) {
						message.setText("Correct!");
						ifCode3 = true;
					}
					if (back4.ifClicked(e)) {
						accum = "";
						count = 0;
						message.setText(" ");
						ifDrawer3Close = false;
					}
					if (ifCode3) {
						drawer3.setStart(new MousePoint(10, 10));
						drawer3.setEnd(new MousePoint(1510, 1000));
						drawer3.setImg("/drawer8.3.png");
						if (!ifRemotePicked) {
							if (remote.ifChose(e)) {
								remote.setStart(new MousePoint(10, 10));
								remote.setEnd(new MousePoint(100, 115));
								message.setText("I picked a remote.");
								inventory.addItem(remote);
								ifRemotePicked = true;
							}
						}
					}
				}
				if (e.getX() >= 420 && e.getX() <= 585 && e.getY() >= 565 && e.getY() <= 620 && !ifDrawer1Close
						&& !ifDrawer2Close && !ifWantToExit) {
					ifDrawer3Close = true;
					message.setText("********");
				}
				// drawer2
				if (e.getX() >= 420 && e.getX() <= 585 && e.getY() >= 690 && e.getY() <= 795 && !ifDrawer1Close
						&& !ifDrawer3Close && !ifWantToExit) {
					ifDrawer2Close = true;
					a1 = "h";
					a2 = "h";
					a3 = "h";
					a4 = "h";
					button1.setImg("/h.png");
					button2.setImg("/h.png");
					button3.setImg("/h.png");
					button4.setImg("/h.png");
				}
				if (ifDrawer2Close && !ifWantToExit) {
					if (button1.ifClicked(e) && !ifCode2) {
						Room8CodeHelper2 helper = new Room8CodeHelper2(button1, a1);
						a1 = helper.getNewDirection();
						if (a1.compareTo("h") == 0) {
							button1.setImg("/h.png");
						}
						if (a1.compareTo("o") == 0) {
							button1.setImg("/o.png");
						}
						if (a1.compareTo("s") == 0) {
							button1.setImg("/s.png");
						}
						if (a1.compareTo("w") == 0) {
							button1.setImg("/w.png");
						}
					}
					if (button2.ifClicked(e) && !ifCode2) {
						Room8CodeHelper2 helper = new Room8CodeHelper2(button2, a2);
						a2 = helper.getNewDirection();
						if (a2.compareTo("h") == 0) {
							button2.setImg("/h.png");
						}
						if (a2.compareTo("o") == 0) {
							button2.setImg("/o.png");
						}
						if (a2.compareTo("s") == 0) {
							button2.setImg("/s.png");
						}
						if (a2.compareTo("w") == 0) {
							button2.setImg("/w.png");
						}
					}
					if (button3.ifClicked(e) && !ifCode2) {
						Room8CodeHelper2 helper = new Room8CodeHelper2(button3, a3);
						a3 = helper.getNewDirection();
						if (a3.compareTo("h") == 0) {
							button3.setImg("/h.png");
						}
						if (a3.compareTo("o") == 0) {
							button3.setImg("/o.png");
						}
						if (a3.compareTo("s") == 0) {
							button3.setImg("/s.png");
						}
						if (a3.compareTo("w") == 0) {
							button3.setImg("/w.png");
						}
					}
					if (button4.ifClicked(e) && !ifCode2) {
						Room8CodeHelper2 helper = new Room8CodeHelper2(button4, a4);
						a4 = helper.getNewDirection();
						if (a4.compareTo("h") == 0) {
							button4.setImg("/h.png");
						}
						if (a4.compareTo("o") == 0) {
							button4.setImg("/o.png");
						}
						if (a4.compareTo("s") == 0) {
							button4.setImg("/s.png");
						}
						if (a4.compareTo("w") == 0) {
							button4.setImg("/w.png");
						}
					}
					if (a1.compareTo("w") == 0 && a2.compareTo("o") == 0 && a3.compareTo("h") == 0
							&& a4.compareTo("s") == 0) {
						message.setText("Correct!");
						ifCode2 = true;
					}
					if (back3.ifClicked(e) && !ifWantToExit) {
						ifDrawer2Close = false;
					}
					if (ifCode2) {
						drawer2.setStart(new MousePoint(10, 10));
						drawer2.setEnd(new MousePoint(1510, 1000));
						drawer2.setImg("/drawer8.2.png");
						if (!ifScrewdriverPicked && !ifWantToExit) {
							if (screwdriver.ifChose(e)) {
								screwdriver.setStart(new MousePoint(10, 10));
								screwdriver.setEnd(new MousePoint(130, 105));
								message.setText("I picked a screwdriver.");
								inventory.addItem(screwdriver);
								ifScrewdriverPicked = true;
							}
						}
					}
				}
				// drawer1
				if (e.getX() >= 120 && e.getX() <= 415 && e.getY() >= 565 && e.getY() <= 620 && !ifDrawer2Close
						&& !ifDrawer3Close && !ifWantToExit) {
					ifDrawer1Close = true;
				}
				if (ifDrawer1Close && !ifWantToExit) {
					if (buttonA.ifClicked(e) && !ifCode1) {
						Room8CodeHelper helper = new Room8CodeHelper(buttonA, b1);
						b1 = helper.getNewDirection();
						if (b1.compareTo("lightBlue") == 0) {
							buttonA.setImg("/lightBlue.png");
						}
						if (b1.compareTo("pink") == 0) {
							buttonA.setImg("/pink.png");
						}
						if (b1.compareTo("orange") == 0) {
							buttonA.setImg("/orange.png");
						}
					}
					if (buttonB.ifClicked(e) && !ifCode1) {
						Room8CodeHelper helper = new Room8CodeHelper(buttonA, b2);
						b2 = helper.getNewDirection();
						if (b2.compareTo("lightBlue") == 0) {
							buttonB.setImg("/lightBlue.png");
						}
						if (b2.compareTo("pink") == 0) {
							buttonB.setImg("/pink.png");
						}
						if (b2.compareTo("orange") == 0) {
							buttonB.setImg("/orange.png");
						}
					}
					if (buttonC.ifClicked(e) && !ifCode1) {
						Room8CodeHelper helper = new Room8CodeHelper(buttonA, b3);
						b3 = helper.getNewDirection();
						if (b3.compareTo("lightBlue") == 0) {
							buttonC.setImg("/lightBlue.png");
						}
						if (b3.compareTo("pink") == 0) {
							buttonC.setImg("/pink.png");
						}
						if (b3.compareTo("orange") == 0) {
							buttonC.setImg("/orange.png");
						}
					}
					if (b1.compareTo("lightBlue") == 0 && b2.compareTo("orange") == 0 && b3.compareTo("pink") == 0) {
						message.setText("Correct!");
						ifCode1 = true;
					}
					if (back2.ifClicked(e) && !ifWantToExit) {
						ifDrawer1Close = false;
						buttonA.setImg("/lightBlue.png");
						buttonB.setImg("/lightBlue.png");
						buttonC.setImg("/lightBlue.png");
						b1 = "lightBlue";
						b2 = "lightBlue";
						b3 = "lightBlue";
					}
					if (ifCode1) {
						drawer1.setStart(new MousePoint(10, 10));
						drawer1.setEnd(new MousePoint(1510, 1000));
						drawer1.setImg("/drawer8.png");
					}
					if (!ifLanternPicked && ifCode1) {
						if (lantern.ifChose(e)) {
							lantern.setStart(new MousePoint(10, 10));
							lantern.setEnd(new MousePoint(200, 145));
							message.setText("I picked a flashlight.");
							inventory.addItem(lantern);
							ifLanternPicked = true;
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
			// num1 button
			if (e.getX() > 500 && e.getX() <= 640 && e.getY() >= 530 && e.getY() <= 670) {
				num1.setStart(new MousePoint(495, 525));
				num1.setEnd(new MousePoint(645, 675));
			} else {
				num1.setStart(new MousePoint(500, 530));
				num1.setEnd(new MousePoint(640, 670));
			}
			// num2 button
			if (e.getX() > 730 && e.getX() <= 870 && e.getY() >= 530 && e.getY() <= 670) {
				num2.setStart(new MousePoint(725, 525));
				num2.setEnd(new MousePoint(875, 675));
			} else {
				num2.setStart(new MousePoint(730, 530));
				num2.setEnd(new MousePoint(870, 670));
			}
			// num3 button
			if (e.getX() > 960 && e.getX() <= 1100 && e.getY() >= 530 && e.getY() <= 670) {
				num3.setStart(new MousePoint(955, 525));
				num3.setEnd(new MousePoint(1105, 675));
			} else {
				num3.setStart(new MousePoint(960, 530));
				num3.setEnd(new MousePoint(1100, 670));
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
		if (ifBooksClose) {
			back1.paintComponent(g);
		}
		if (ifDrawer2Close) {
			drawer2.paintComponent(g);
			back3.paintComponent(g);
			if (!ifCode2) {
				button1.paintComponent(g);
				button2.paintComponent(g);
				button3.paintComponent(g);
				button4.paintComponent(g);
			}
			if (ifCode2 && !ifScrewdriverPicked) {
				screwdriver.paintComponent(g);
			}
		}
		if (ifDrawer3Close) {
			drawer3.paintComponent(g);
			back4.paintComponent(g);
			if (!ifCode3) {
				num1.paintComponent(g);
				num2.paintComponent(g);
				num3.paintComponent(g);
			}
			if (ifCode3 && !ifRemotePicked) {
				remote.paintComponent(g);
			}
		}
		if (ifDrawer1Close) {
			drawer1.paintComponent(g);
			back2.paintComponent(g);
			if (!ifCode1) {
				buttonA.paintComponent(g);
				buttonB.paintComponent(g);
				buttonC.paintComponent(g);
			}
			if (ifCode1 && !ifLanternPicked) {
				lantern.paintComponent(g);
			}
		}
		if (ifLampUp) {
			if (ifBulbInLamp && !(ifCode1 && ifDrawer1Close) && !(ifCode2 && ifDrawer2Close)
					&& !(ifCode3 && ifDrawer3Close)) {
				codeB.paintComponent(g);
			} else {
			}
		} else {
			if (ifBulbInLamp && !(ifCode1 && ifDrawer1Close) && !(ifCode2 && ifDrawer2Close)
					&& !(ifCode3 && ifDrawer3Close)) {
				codeA.paintComponent(g);
			} else {
			}
		}
		if (ifKeyFall && !ifKeyPicked) {
			key.paintComponent(g);
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
