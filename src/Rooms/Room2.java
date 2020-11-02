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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import MainMenu.GamePanel;
import MainMenu.Menu;
import Rooms.Room8.MyMouseListener;
public class Room2 extends JPanel implements Room {
    ImageReader background;
    GamePanel game;
    JLabel message;
    WallBegin wb;
    InventoryPanel inventory;
    JFrame frame;
    List<Clickable> listClickables = new ArrayList<Clickable>();
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
    // true if the box is close
    boolean ifBoxClose = false;
    // true if the light is off
    boolean ifLightOff = true;
    // true if the pillow moved
    boolean ifPillowMoved = false;
    // true if the user pressed the wright code
    boolean ifCode = false;
    // true if the first key is picked
    boolean ifFirstKeyPicked = false;
    // true if the first key is choose
    boolean ifFirstKeyChoose = false;
    // true if the second key is picked
    boolean ifSecondKeyPicked = false;
    // true if the second key is choose
    boolean ifSecondKeyChoose = false;
    // true if the uper drawer is oepen
    boolean ifUperDrawerOpen = false;
    // true if the drawer is unlocked
    boolean unlockDrawer = false;
    // true if door is open
    boolean ifDoorOpen = false;
    /**
     * Clickables
     */
    // back buttons
    ClickedObject back1;
    ClickedObject back2;
    ClickedObject button1;
    ClickedObject button2;
    ClickedObject button3;
    ClickedObject button4;
    ClickedObject armchair;
    ClickedObject box;
    ClickedObject carpet;
    ClickedObject cupboard;
    ClickedObject door;
    Background drawerOpen;
    ClickedObject lamp;
    ClickedObject picture;
    ClickedObject pillow;
    ClickedObject switch_;
    ClickedObject menu;
    ClickedObject wantToExit;
    ClickedObject vi;
    ClickedObject x;
    // numbers for the buttons
    int num1 = 1;
    int num2 = 1;
    int num3 = 1;
    int num4 = 1;
    /**
     * inventory items
     */
    InventoryItem keyCupboard;
    InventoryItem keyDoor;
    /**
     * @param w
     * @param game
     * @param f
     * @param i
     */
    public Room2(WallBegin w, GamePanel game, JFrame f, InventoryPanel i) {
        super();
        this.inventory = i;
        this.wb = w;
        this.frame = f;
        this.game = game;
        this.message = this.game.panel.getText();
        String path = "/room2.png";
        this.background = new ImageReader(path);
        // back buttons
        back1 = new ClickedObject("/back.png",  new MousePoint(1430, 15), new MousePoint(1505, 85));
        back2 = new ClickedObject("/back.png",  new MousePoint(1430, 15), new MousePoint(1505, 85));
        menu = new ClickedObject("/menu.png", new MousePoint(1275, 10), new MousePoint(1420, 95));
        wantToExit = new ClickedObject("/wantToExit.png", new MousePoint(300, 200), new MousePoint(1300, 800));
        vi = new ClickedObject("/vi.png", new MousePoint(600, 550), new MousePoint(700, 650));
        x = new ClickedObject("/x.png", new MousePoint(900, 550), new MousePoint(1000, 650));
        door = new ClickedObject("/door2.jpg", new MousePoint(600, 245), new MousePoint(900, 763));
        listClickables.add(door);
        armchair = new ClickedObject("/armchair2.png", new MousePoint(100, 495), new MousePoint(420, 800));
        listClickables.add(armchair);
        switch_ = new ClickedObject("/switch.png", new MousePoint(920, 460), new MousePoint(980, 515));
        listClickables.add(switch_);
        picture = new ClickedObject("/picture2.png", new MousePoint(1100, 295), new MousePoint(1260, 425));
        listClickables.add(picture);
        pillow = new ClickedObject("/pillow2.png", new MousePoint(150, 555), new MousePoint(260, 650));
        listClickables.add(pillow);
        lamp = new ClickedObject("/lamp2.png", new MousePoint(390, 300), new MousePoint(580, 800));
        listClickables.add(lamp);
        carpet = new ClickedObject("/carpet2.png", new MousePoint(310, 775), new MousePoint(1180, 1000));
        listClickables.add(carpet);
        cupboard = new ClickedObject("/cupboard2.png", new MousePoint(1075, 530), new MousePoint(1295, 790));
        listClickables.add(cupboard);
        box = new ClickedObject("/box2.png", new MousePoint(1100, 460), new MousePoint(1265, 550));
        listClickables.add(box);
        button1 = new ClickedObject("/1.png", new MousePoint(555, 380), new MousePoint(655, 480));
        button2 = new ClickedObject("/1.png", new MousePoint(555, 530), new MousePoint(655, 630));
        button3 = new ClickedObject("/1.png", new MousePoint(830, 380), new MousePoint(930, 480));
        button4 = new ClickedObject("/1.png", new MousePoint(830, 530), new MousePoint(930, 630));
        drawerOpen = new Background("/uperDrawerOpen2.png", new MousePoint(10, 10), new MousePoint(1510, 1000));
        keyCupboard = new InventoryItem("/key2.png", new MousePoint(650, 565), new MousePoint(825, 640));
        keyDoor = new InventoryItem("/key1.png", new MousePoint(650, 425), new MousePoint(825, 555));
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
                if (ifSecondKeyPicked && ifSecondKeyChoose && door.ifClicked(e) && !ifCloseFrame) {
                    ifDoorLocked = false;
                    inventory.deleteItem(keyDoor);
                }
            }
            if (!ifDoorLocked) {
                ifDoorOpen = true;
            }
            if (ifDoorOpen) {
                door.setStart(new MousePoint(600, 245));
                door.setEnd(new MousePoint(900, 777));
                door.setImg("/door2Open.png");
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
            if (keyCupboard.ifChose(e) && ifFirstKeyPicked) {
                ifFirstKeyChoose = !ifFirstKeyChoose;
                if (ifFirstKeyChoose) {
                    keyCupboard.setImg("/key2Choose.png");
                }
                else {
                    keyCupboard.setImg("/key2.png");
                }
            }
            if (keyDoor.ifChose(e) && ifSecondKeyPicked) {
                ifSecondKeyChoose = !ifSecondKeyChoose;
                if (ifSecondKeyChoose) {
                    keyDoor.setImg("/key1Choose.png");
                }
                else {
                    keyDoor.setImg("/key1.png");
                }
            }
            /**
             * other room
             */
            if (ifUperDrawerOpen) {
                if (back2.ifClicked(e)) {
                    ifCloseFrame = false;
                    ifUperDrawerOpen = false;      
                }
                if (keyDoor.ifChose(e) && !ifSecondKeyPicked) {
                    keyDoor.setStart(new MousePoint(10, 10));
                    keyDoor.setEnd(new MousePoint(120, 95));
                    message.setText("I picked another key.");
                    inventory.addItem(keyDoor);
                    ifSecondKeyPicked = true;
                }
            }
            if (!ifCloseFrame) {
                if (pillow.ifClicked(e)) {
                    ifPillowMoved = !ifPillowMoved;
                }
                if (ifPillowMoved) {
                    pillow.setStart(new MousePoint(210, 555));
                    pillow.setEnd(new MousePoint(320, 650));
                }
                else {
                    pillow.setStart(new MousePoint(150, 555));
                    pillow.setEnd(new MousePoint(260, 650));
                }
                if (door.ifClicked(e) && !ifDoorOpen) {
                    if (ifDoorLocked) {
                        message.setText("It's locked.");
                    }
                }
                if (door.ifClicked(e) && ifDoorOpen) {
                    exitStatus = true;
                }
                if (picture.ifClicked(e)) {
                    message.setText("Just a picture on the wall.");
                }
                if (armchair.ifClicked(e) && !pillow.ifClicked(e)) {
                    message.setText("I d'ont have time to sit now.");
                }
                if (e.getX() >= 1105 && e.getX() <= 1260 && e.getY() >= 595 && e.getY() <= 650) {
                    if (ifFirstKeyChoose && !unlockDrawer) {
                        inventory.deleteItem(keyCupboard);
                        unlockDrawer = true;
                    }
                    if (!ifFirstKeyChoose && !unlockDrawer) {
                        message.setText("It's locked.");
                    }
                    if (unlockDrawer) {
                        ifCloseFrame = true;
                        ifUperDrawerOpen = true;
                    }
                }
                // down drawer
                if (e.getX() >= 1105 && e.getX() <= 1260 && e.getY() >= 685 && e.getY() <= 740) {
                    message.setText("Nothing happens.");
                }
                if (box.ifClicked(e) && !ifBoxClose) {
                    ifBoxClose = true;
                }
                if (ifBoxClose) {
                    box.setImg("/boxClose2.png");
                    box.setStart(new MousePoint(300, 300));
                    box.setEnd(new MousePoint(1200, 800));
                    if (button1.ifClicked(e) && !ifCode) {
                        Room2CodeHelper helper = new Room2CodeHelper(button1, num1);
                        num1 = helper.getNewDirection();
                        if (num1 == 1) {
                            button1.setImg("/1.png");
                        }
                        if (num1 == 2) {
                            button1.setImg("/2.png");
                        }
                        if (num1 == 3) {
                            button1.setImg("/3.png");
                        }
                        if (num1 == 4) {
                            button1.setImg("/4.png");
                        }
                        if (num1 == 5) {
                            button1.setImg("/5.png");
                        }
                        if (num1 == 6) {
                            button1.setImg("/6.png");
                        }
                        if (num1 == 7) {
                            button1.setImg("/7.png");
                        }
                        if (num1 == 8) {
                            button1.setImg("/8.png");
                        }
                        if (num1 == 9) {
                            button1.setImg("/9.png");
                        }
                    }
                    if (button2.ifClicked(e) && !ifCode) {
                        Room2CodeHelper helper = new Room2CodeHelper(button2, num2);
                        num2 = helper.getNewDirection();
                        if (num2 == 1) {
                            button2.setImg("/1.png");
                        }
                        if (num2 == 2) {
                            button2.setImg("/2.png");
                        }
                        if (num2 == 3) {
                            button2.setImg("/3.png");
                        }
                        if (num2 == 4) {
                            button2.setImg("/4.png");
                        }
                        if (num2 == 5) {
                            button2.setImg("/5.png");
                        }
                        if (num2 == 6) {
                            button2.setImg("/6.png");
                        }
                        if (num2 == 7) {
                            button2.setImg("/7.png");
                        }
                        if (num2 == 8) {
                            button2.setImg("/8.png");
                        }
                        if (num2 == 9) {
                            button2.setImg("/9.png");
                        }
                    }
                    if (button3.ifClicked(e) && !ifCode) {
                        Room2CodeHelper helper = new Room2CodeHelper(button3, num3);
                        num3 = helper.getNewDirection();
                        if (num3 == 1) {
                            button3.setImg("/1.png");
                        }
                        if (num3 == 2) {
                            button3.setImg("/2.png");
                        }
                        if (num3 == 3) {
                            button3.setImg("/3.png");
                        }
                        if (num3 == 4) {
                            button3.setImg("/4.png");
                        }
                        if (num3 == 5) {
                            button3.setImg("/5.png");
                        }
                        if (num3 == 6) {
                            button3.setImg("/6.png");
                        }
                        if (num3 == 7) {
                            button3.setImg("/7.png");
                        }
                        if (num3 == 8) {
                            button3.setImg("/8.png");
                        }
                        if (num3 == 9) {
                            button3.setImg("/9.png");
                        }
                    }
                    if (button4.ifClicked(e) && !ifCode) {
                        Room2CodeHelper helper = new Room2CodeHelper(button4, num4);
                        num4 = helper.getNewDirection();
                        if (num4 == 1) {
                            button4.setImg("/1.png");
                        }
                        if (num4 == 2) {
                            button4.setImg("/2.png");
                        }
                        if (num4 == 3) {
                            button4.setImg("/3.png");
                        }
                        if (num4 == 4) {
                            button4.setImg("/4.png");
                        }
                        if (num4 == 5) {
                            button4.setImg("/5.png");
                        }
                        if (num4 == 6) {
                            button4.setImg("/6.png");
                        }
                        if (num4 == 7) {
                            button4.setImg("/7.png");
                        }
                        if (num4 == 8) {
                            button4.setImg("/8.png");
                        }
                        if (num4 == 9) {
                            button4.setImg("/9.png");
                        }
                    }
                    if (num1 == 4 && num2 == 3 && num3 == 5 && num4 == 6) {
                        ifCode = true;
                    }
                    if (ifCode) {
                        box.setImg("/boxCloseOpen.png");
                        if (keyCupboard.ifChose(e) && !ifFirstKeyPicked) {
                            keyCupboard.setStart(new MousePoint(10, 10));
                            keyCupboard.setEnd(new MousePoint(120, 95));
                            inventory.addItem(keyCupboard);
                            ifFirstKeyPicked = true;
                        }
                    }
                    if (back1.ifClicked(e)) {
                        ifBoxClose = false;
                        if (ifLightOff) {
                            box.setImg("/box2.png");
                        }
                        else {
                            box.setImg("/box2Dark.png");
                        }
                        box.setStart(new MousePoint(1100, 460));
                        box.setEnd(new MousePoint(1265, 550));
                    }
                }
                if (switch_.ifClicked(e) && !ifBoxClose) {
                    ifLightOff = !ifLightOff;
                    if (ifLightOff) {
                        background.setImg("/room2.png");
                        picture.setImg("/picture2.png");
                        switch_.setImg("/switch.png");
                        lamp.setImg("/lamp2.png");
                        pillow.setImg("/pillow2.png");
                        armchair.setImg("/armchair2.png");
                        carpet.setImg("/carpet2.png");
                        cupboard.setImg("/cupboard2.png");
                        box.setImg("/box2.png");
                        door.setImg("/door2.jpg");
                    }
                    else {  
                        background.setImg("/room2Dark.png");
                        picture.setImg("/picture2Dark.png");
                        switch_.setImg("/switchDark.png");
                        lamp.setImg("/lamp2Dark.png");
                        pillow.setImg("/pillow2Dark.png");
                        armchair.setImg("/armchair2Dark.png");
                        carpet.setImg("/carpet2Dark.png");
                        cupboard.setImg("/cupboard2Dark.png");
                        box.setImg("/box2Dark.png");
                        door.setImg("/door2Dark.jpg");
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
            }
            else {
                menu.setStart(new MousePoint(1275, 10));
                menu.setEnd(new MousePoint(1420, 95));
                menu.setImg("/menu.png");
            }
            if (ifWantToExit) {
                if (e.getX() >= 600 && e.getX() <= 700 && e.getY() >= 550 && e.getY() <= 650) {
                    vi.setStart(new MousePoint(595, 545));
                    vi.setEnd(new MousePoint(705, 655));
                }
                else {
                    vi.setStart(new MousePoint(600, 550));
                    vi.setEnd(new MousePoint(700, 650));
                }
                if (e.getX() >= 900 && e.getX() <= 1000 && e.getY() >= 550 && e.getY() <= 650) {
                    x.setStart(new MousePoint(895, 545));
                    x.setEnd(new MousePoint(1005, 655));
                }
                else {
                    x.setStart(new MousePoint(900, 550));
                    x.setEnd(new MousePoint(1000, 650));
                }
            }
            if (e.getX() >= 1430 && e.getX() <= 1505 && e.getY() >= 15 && e.getY() <= 85) {
                back1.setStart(new MousePoint(1425, 10));
                back1.setEnd(new MousePoint(1510, 90));
                back2.setStart(new MousePoint(1425, 10));
                back2.setEnd(new MousePoint(1510, 90));
            }
            else {
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
        if (ifBoxClose) {
            back1.paintComponent(g);
            if (!ifCode) {
                button1.paintComponent(g);
                button2.paintComponent(g);
                button3.paintComponent(g);
                button4.paintComponent(g);   
            }
            if (!ifFirstKeyPicked && ifCode) {
                keyCupboard.paintComponent(g);
            }
        }
        if (ifUperDrawerOpen) {
            drawerOpen.paintComponent(g);
            back2.paintComponent(g);
            if (!ifSecondKeyPicked) {
                keyDoor.paintComponent(g);
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
