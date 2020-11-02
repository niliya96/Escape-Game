package Rooms;
import Tools.*;
import Sprites.*;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.RenderingHints.Key;
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
public class Room3 extends JPanel implements Room {
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
    // true if the lamp is on
    boolean ifLampOn = true;
    // true if the carpet is folded
    boolean ifCarpetFolded = false;
    // true if the chair is moves
    boolean ifChairMoved = false;
    // true if the key picked
    boolean ifKeyPicked = false;
    // true if the key choose
    boolean ifKeyChoose = false;
    // true if the key fall
    boolean ifKeyFall = false;
    // true if door is open
    boolean ifDoorOpen = false;
    /**
     * Clickables
     */
    Clickable books;
    ClickedObject carpet;
    ClickedObject chair;
    Clickable computer;
    Clickable desk;
    ClickedObject door;
    ClickedObject lamp;
    Clickable picture;
    Clickable switch_;
    Clickable window;
    ClickedObject menu;
    ClickedObject wantToExit;
    ClickedObject vi;
    ClickedObject x;
    /**
     * inventory items
     */
    InventoryItem key;
    /**
     * @param w
     * @param game
     * @param f
     * @param i
     */
    public Room3(WallBegin w, GamePanel game, JFrame f, InventoryPanel i) {
        super();
        this.inventory = i;
        this.wb = w;
        this.frame = f;
        this.game = game;
        this.message = this.game.panel.getText();
        String path = "/room3.png";
        this.background = new ImageReader(path);
        menu = new ClickedObject("/menu.png", new MousePoint(1275, 10), new MousePoint(1420, 95));
        wantToExit = new ClickedObject("/wantToExit.png", new MousePoint(300, 200), new MousePoint(1300, 800));
        vi = new ClickedObject("/vi.png", new MousePoint(600, 550), new MousePoint(700, 650));
        x = new ClickedObject("/x.png", new MousePoint(900, 550), new MousePoint(1000, 650));
        door = new ClickedObject("/door1.jpg", new MousePoint(700, 245), new MousePoint(1000, 763));
        listClickables.add(door);
        picture = new ClickedObject("/picture3.png", new MousePoint(265, 250), new MousePoint(480, 400));
        listClickables.add(picture);
        switch_ = new ClickedObject("/switch.png", new MousePoint(620, 460), new MousePoint(680, 515));
        listClickables.add(switch_);
        desk = new ClickedObject("/desk3.png", new MousePoint(100, 520), new MousePoint(600, 800));
        listClickables.add(desk);
        computer = new ClickedObject("/computer3.png", new MousePoint(150, 375), new MousePoint(365, 545));
        listClickables.add(computer);
        chair = new ClickedObject("/chair3.png", new MousePoint(250, 510), new MousePoint(490, 870));
        listClickables.add(chair);
        key = new InventoryItem("/key2.png", new MousePoint(835, 845), new MousePoint(910, 880));
        carpet = new ClickedObject("/carpet1.png", new MousePoint(415, 775), new MousePoint(1285, 1000));
        listClickables.add(carpet);
        lamp = new ClickedObject("/lampOn.png", new MousePoint(775, 30), new MousePoint(935, 250));
        listClickables.add(lamp);
        window = new ClickedObject("/window3.png", new MousePoint(1060, 285), new MousePoint(1375, 570));
        listClickables.add(window);
        books = new ClickedObject("/books3.png", new MousePoint(430, 415), new MousePoint(550, 540));
        listClickables.add(books);
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
                if (ifKeyPicked && ifKeyChoose && door.ifClicked(e)) {
                    ifDoorLocked = false;
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
                    key.setImg("/key2Choose.png");
                } else {
                    key.setImg("/key2.png");
                }
            }
            /**
             * other room
             */
            if (!ifCloseFrame) {
                if (picture.ifClicked(e)) {
                    message.setText("Just an interesting picture of shapes.");
                }
                if (computer.ifClicked(e)) {
                    message.setText("Maybe a code will help.");
                }
                if (books.ifClicked(e)) {
                    message.setText("I don't have time to read.");
                }
                if (switch_.ifClicked(e)) {
                    ifLampOn = !ifLampOn;
                }
                if (ifLampOn) {
                    lamp.setImg("/lampOn.png");
                } else {
                    lamp.setImg("/lampOff.png");
                }
                if (e.getX() >= 610 && e.getX() <= 725 && e.getY() >= 810 && e.getY() <= 1000 && !ifCarpetFolded) {
                    if (!ifCarpetFolded) {
                        ifCarpetFolded = true;
                    }
                }
                if (e.getX() >= 940 && e.getX() <= 1025 && e.getY() >= 810 && e.getY() <= 1000 && ifCarpetFolded) {
                    if (ifCarpetFolded && !ifChairMoved) {
                        ifCarpetFolded = false;
                    }
                    if (ifCarpetFolded && ifChairMoved) {
                        message.setText("Can't open it.");
                    }
                }
                if (ifCarpetFolded) {
                    carpet.setImg("/carpetFolded1.png");
                    if (chair.ifClicked(e) && !key.ifChose(e)) {
                        ifChairMoved = !ifChairMoved;
                    }
                    if (ifKeyFall && ifCarpetFolded) {
                        if (key.ifChose(e) && !ifKeyPicked) {
                            key.setStart(new MousePoint(10, 10));
                            key.setEnd(new MousePoint(120, 95));
                            message.setText("I picked a key.");
                            inventory.addItem(key);
                            ifKeyPicked = true;
                        }
                    }
                    if (ifChairMoved) {
                        chair.setStart(new MousePoint(710, 530));
                        chair.setEnd(new MousePoint(950, 890));
                        if (lamp.ifClicked(e)) {
                            if (ifLampOn) {
                                message.setText("Too warm.");
                            } else {
                                    ifKeyFall = true;
                            }
                        }
                    } else {
                        chair.setStart(new MousePoint(250, 510));
                        chair.setEnd(new MousePoint(490, 870));
                    }
                } else {
                    carpet.setImg("/carpet1.png");
                    if (chair.ifClicked(e)) {
                        message.setText("Just a chair.");
                    }
                }
                if (door.ifClicked(e) && !ifKeyChoose && !ifDoorOpen) {
                    message.setText("It's locked.");
                }
                if (ifDoorOpen) {
                    exitStatus = true;
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
        if (!ifKeyPicked && ifKeyFall) {
            key.paintComponent(g);
            carpet.paintComponent(g);
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
