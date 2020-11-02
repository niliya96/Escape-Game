package Rooms;
import Tools.*;
import Sprites.*;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import MainMenu.GamePanel;
import MainMenu.Menu;
import Rooms.Room8.MyMouseListener;
import Tools.*;
public class Room1 extends JPanel implements Room {
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
    String lock = ".//res//lock.wav";
    String openDoor = ".//res//openDoorRooms.wav";
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
    // true if the upper drawer is open
    boolean ifUpperDrawerOpen = false;
    // true if the down drawer is close
    boolean ifdownDrawerClose = false;
    // true if the user pressed the wright code
    boolean ifCode = false;
    // true if the key picked
    boolean ifKeyPicked = false;
    // true if the key chose
    boolean ifKeyChoose = true;
    // true if the lamp is on
    boolean ifLampOn = false;
    // true if door is open
    boolean ifDoorOpen = false;
    /**
     * backgrounds
     */
    Background upperDrawerClose;
    /**
     * Clickables
     */
    ClickedObject back1;
    ClickedObject back2;
    Clickable board;
    ClickedObject button1;
    ClickedObject button2;
    ClickedObject button3;
    ClickedObject button4;
    Clickable cactus;
    Clickable carpet;
    Clickable cupboard;
    ClickedObject door;
    ClickedObject drawerClose;
    Clickable globe;
    ClickedObject lamp;
    Clickable picture;
    Clickable switch_;
    ClickedObject menu;
    ClickedObject wantToExit;
    ClickedObject vi;
    ClickedObject x;
    /**
     * inventory items
     */
    InventoryItem key;
    // buttons
    String direction1 = "north";
    String direction2 = "north";
    String direction3 = "north";
    String direction4 = "north";
    /**
     * @param w
     * @param game
     * @param f
     * @param i
     */
    public Room1(WallBegin w, GamePanel game, JFrame f, InventoryPanel i) {
        super();
        this.inventory = i;
        this.wb = w;
        this.frame = f;
        this.game = game;
        this.message = this.game.panel.getText();
        String path = "/room1.png";
        this.background = new ImageReader(path);
        // back buttons
        back1 = new ClickedObject("/back.png", new MousePoint(1430, 15), new MousePoint(1505, 85));
        back2 = new ClickedObject("/back.png", new MousePoint(1430, 15), new MousePoint(1505, 85));
        menu = new ClickedObject("/menu.png", new MousePoint(1275, 10), new MousePoint(1420, 95));
        wantToExit = new ClickedObject("/wantToExit.png", new MousePoint(300, 200), new MousePoint(1300, 800));
        vi = new ClickedObject("/vi.png", new MousePoint(600, 550), new MousePoint(700, 650));
        x = new ClickedObject("/x.png", new MousePoint(900, 550), new MousePoint(1000, 650));
        // backgrounds
        upperDrawerClose = new Background("/uperDrawerOpen1.png", new MousePoint(10, 10), new MousePoint(1510, 1000));
        // other clickabels
        door = new ClickedObject("/door1.jpg", new MousePoint(600, 245), new MousePoint(900, 763));
        listClickables.add(door);
        picture = new ClickedObject("/picture1.png", new MousePoint(635, 105), new MousePoint(865, 230));
        listClickables.add(picture);
        cupboard = new ClickedObject("/cupboard1.png", new MousePoint(1025, 530), new MousePoint(1245, 790));
        listClickables.add(cupboard);
        carpet = new ClickedObject("/carpet1.png", new MousePoint(310, 775), new MousePoint(1180, 1000));
        listClickables.add(carpet);
        board = new ClickedObject("/board1.png", new MousePoint(215, 265), new MousePoint(540, 465));
        listClickables.add(board);
        cactus = new ClickedObject("/cactus1.png", new MousePoint(255, 350), new MousePoint(450, 805));
        listClickables.add(cactus);
        globe = new ClickedObject("/globe1.png", new MousePoint(1070, 410), new MousePoint(1200, 560));
        listClickables.add(globe);
        drawerClose = new ClickedObject("/drawerClose1.png", new MousePoint(350, 400), new MousePoint(1250, 700));
        button1 = new ClickedObject("/up.png", new MousePoint(525, 545), new MousePoint(625, 635));
        button2 = new ClickedObject("/up.png", new MousePoint(687, 545), new MousePoint(787, 635));
        button3 = new ClickedObject("/up.png", new MousePoint(838, 545), new MousePoint(938, 635));
        button4 = new ClickedObject("/up.png", new MousePoint(1000, 545), new MousePoint(1100, 635));
        // inventory items
        key = new InventoryItem("/key1.png", new MousePoint(600, 425), new MousePoint(900, 550));
        lamp = new ClickedObject("/lampOff.png", new MousePoint(1050, 40), new MousePoint(1250, 300));
        listClickables.add(lamp);
        switch_ = new ClickedObject("/switch.png", new MousePoint(920, 460), new MousePoint(980, 515));
        listClickables.add(switch_);
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
                if (ifKeyPicked && ifKeyChoose && door.ifClicked(e) && !ifCloseFrame && !ifdownDrawerClose) {
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
                door.setStart(new MousePoint(600, 245));
                door.setEnd(new MousePoint(900, 777));
                door.setImg("/door1Open.png");
            }
            if (exitStatus) {
                exitRoom();
            }
            message.setFont(new Font("Ariel", Font.BOLD, 25));
            if (ifMessageNoComment) {
                message.setText(" ");
            }
            /**
             * inventory items
             */
            if (key.ifChose(e) && ifKeyPicked) {
                ifKeyChoose = !ifKeyChoose;
                if (ifKeyChoose) {
                    key.setImg("/key1Choose.png");
                } else {
                    key.setImg("/key1.png");
                }
            }
            /**
             * other room
             */
            if (!ifCloseFrame) {
                if (switch_.ifClicked(e)) {
                    ifLampOn = !ifLampOn;
                }
                if (ifLampOn) {
                    if (ifDoorLocked && !ifdownDrawerClose && !ifUpperDrawerOpen) {
                        lamp.setImg("/lampOn.png");
                    }
                } else {
                    if (ifDoorLocked && !ifdownDrawerClose && !ifUpperDrawerOpen) {
                        lamp.setImg("/lampOff.png");
                    }
                }
                if (globe.ifClicked(e)) {
                    if (ifDoorLocked && !ifdownDrawerClose && !ifUpperDrawerOpen) {
                        message.setText("Just an ancient globe.");
                    }
                }
                if (board.ifClicked(e)) {
                    if (ifDoorLocked && !ifdownDrawerClose && !ifUpperDrawerOpen) {
                        message.setText("Is something special going to happen on first of january?");
                    }
                }
                if (door.ifClicked(e) && !ifDoorOpen) {
                    if (ifDoorLocked && !ifdownDrawerClose && !ifUpperDrawerOpen && !ifWantToExit) {
                        message.setText("It's locked.");
                        se.setFile(lock);
                        se.play();
                    }
                }
                if (door.ifClicked(e) && ifDoorOpen) {
                    exitStatus = true;
                }
                if (picture.ifClicked(e)) {
                    if (ifDoorLocked && !ifdownDrawerClose && !ifUpperDrawerOpen) {
                        message.setText("A clue?");
                    }
                }
                // upper drawer
                if (!ifdownDrawerClose && e.getX() >= 1055 && e.getX() <= 1210 && e.getY() >= 595 && e.getY() <= 650) {
                    ifCloseFrame = true;
                    ifUpperDrawerOpen = true;
                }
                // down drawer
                if (e.getX() >= 1055 && e.getX() <= 1210 && e.getY() >= 685 && e.getY() <= 745) {
                    ifdownDrawerClose = true;
                }
            }
            if (ifUpperDrawerOpen) {
                if (back1.ifClicked(e)) {
                    ifCloseFrame = false;
                    ifUpperDrawerOpen = false;
                }
            }
            if (ifdownDrawerClose) {
                if (button1.ifClicked(e) && !ifCode) {
                    Room1CodeHelper helper = new Room1CodeHelper(button1, direction1);
                    direction1 = helper.getNewDirection();
                    if (direction1.compareTo("north") == 0) {
                        button1.setImg("/up.png");
                    }
                    if (direction1.compareTo("east") == 0) {
                        button1.setImg("/right.png");
                    }
                    if (direction1.compareTo("west") == 0) {
                        button1.setImg("/left.png");
                    }
                    if (direction1.compareTo("south") == 0) {
                        button1.setImg("/down.png");
                    }
                }
                if (button2.ifClicked(e) && !ifCode) {
                    Room1CodeHelper helper = new Room1CodeHelper(button2, direction2);
                    direction2 = helper.getNewDirection();
                    if (direction2.compareTo("north") == 0) {
                        button2.setImg("/up.png");
                    }
                    if (direction2.compareTo("east") == 0) {
                        button2.setImg("/right.png");
                    }
                    if (direction2.compareTo("west") == 0) {
                        button2.setImg("/left.png");
                    }
                    if (direction2.compareTo("south") == 0) {
                        button2.setImg("/down.png");
                    }
                }
                if (button3.ifClicked(e) && !ifCode) {
                    Room1CodeHelper helper = new Room1CodeHelper(button3, direction3);
                    direction3 = helper.getNewDirection();
                    if (direction3.compareTo("north") == 0) {
                        button3.setImg("/up.png");
                    }
                    if (direction3.compareTo("east") == 0) {
                        button3.setImg("/right.png");
                    }
                    if (direction3.compareTo("west") == 0) {
                        button3.setImg("/left.png");
                    }
                    if (direction3.compareTo("south") == 0) {
                        button3.setImg("/down.png");
                    }
                }
                if (button4.ifClicked(e) && !ifCode) {
                    Room1CodeHelper helper = new Room1CodeHelper(button4, direction4);
                    direction4 = helper.getNewDirection();
                    if (direction4.compareTo("north") == 0) {
                        button4.setImg("/up.png");
                    }
                    if (direction4.compareTo("east") == 0) {
                        button4.setImg("/right.png");
                    }
                    if (direction4.compareTo("west") == 0) {
                        button4.setImg("/left.png");
                    }
                    if (direction4.compareTo("south") == 0) {
                        button4.setImg("/down.png");
                    }
                }
                if (direction1.compareTo("north") == 0 && direction2.compareTo("east") == 0
                        && direction3.compareTo("west") == 0 && direction4.compareTo("south") == 0) {
                    ifCode = true;
                }
                if (ifCode) {
                    drawerClose.setStart(new MousePoint(10, 10));
                    drawerClose.setEnd(new MousePoint(1510, 1000));
                    drawerClose.setImg("/downDrawerOpen1.png");
                    if (!ifKeyPicked) {
                        if (key.ifChose(e)) {
                            ifKeyPicked = true;
                            key.setStart(new MousePoint(10, 10));
                            key.setEnd(new MousePoint(120, 95));
                            ifKeyChoose = false;
                            message.setText("I picked a key.");
                            inventory.addItem(key);
                        }
                    }
                }
                if (back2.ifClicked(e)) {
                    ifdownDrawerClose = false;
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
            } else {
                back1.setStart(new MousePoint(1430, 15));
                back1.setEnd(new MousePoint(1505, 85));
                back2.setStart(new MousePoint(1430, 15));
                back2.setEnd(new MousePoint(1505, 85));
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
        if (ifUpperDrawerOpen) {
            upperDrawerClose.paintComponent(g);
            back1.paintComponent(g);
        }
        if (ifdownDrawerClose) {
            drawerClose.paintComponent(g);
            back2.paintComponent(g);
            if (!ifCode) {
                button1.paintComponent(g);
                button2.paintComponent(g);
                button3.paintComponent(g);
                button4.paintComponent(g);
            } else {
                if (!ifKeyPicked) {
                    key.paintComponent(g);
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