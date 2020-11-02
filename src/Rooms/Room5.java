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
import Rooms.Room3.MyMouseListener;
public class Room5 extends JPanel implements Room {
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
    // true if it's a close frame of the computer
    boolean ifComputerClose = false;
    // true if the disk on key is in the computer
    boolean ifDiskOnKey = false;
    // true if the books are moved
    boolean ifBooksMove = false;
    // true if the picture is close
    boolean ifPictureClose = false;
    // true if drawer1 is close
    boolean ifDrawer1 = false;
    // true if drawer2 is close
    boolean ifDrawer2 = false;
    // true if the spray choose
    boolean ifSprayChoose = false;
    // true if the spray added
    boolean ifSprayAdded = false;
    // true if the cable picked
    boolean ifCablePicked = false;
    // true if the cable choose
    boolean ifCableChoose = false;
    // true if the disk picked
    boolean ifDiskPicked = false;
    // true if the disk choose
    boolean ifDiskChoose = false;
    // true if the code is done
    boolean ifCode1 = false;
    // true if the code is done
    boolean ifCode2 = false;
    // true if the wall close
    boolean ifCloseWall = false;
    // true if the cable in the socket
    boolean ifCableIn = false;
    // true if the code of the computer is good
    boolean ifCodeComputer = false;
    // true if door is open
    boolean ifDoorOpen = false;
    /**
     * Clickables
     */
    ClickedObject back1;
    ClickedObject back2;
    ClickedObject back3;
    ClickedObject back4;
    ClickedObject back5;
    ClickedObject books;
    ClickedObject button1;
    ClickedObject button2;
    ClickedObject buttonA;
    ClickedObject buttonB;
    ClickedObject buttonC;
    ClickedObject buttonPassword;
    ClickedObject cableIn;
    Clickable carpet;
    Clickable closeWall;
    ClickedObject computer;
    Clickable cupboard;
    Clickable desk;
    ClickedObject door;
    ClickedObject drawer1;
    ClickedObject drawer2;
    Clickable kettle;
    ClickedObject picture;
    Clickable socket;
    Clickable switch_;
    ClickedObject window;
    ClickedObject menu;
    ClickedObject wantToExit;
    ClickedObject vi;
    ClickedObject x;
    /**
     * inventory items
     */
    InventoryItem spray;
    InventoryItem cable;
    InventoryItem disk;
    // others
    String accum = "";
    String code = "BBWBWB";
    int count = 0;
    int num1 = 1;
    int num2 = 1;
    int num3 = 1;
    /**
     * @param w
     * @param game
     * @param f
     * @param i
     */
    public Room5(WallBegin w, GamePanel game, JFrame f, InventoryPanel i) {
        super();
        this.inventory = i;
        this.wb = w;
        this.frame = f;
        this.game = game;
        this.message = this.game.panel.getText();
        String path = "/room5Start.png";
        this.background = new ImageReader(path);
        back1 = new ClickedObject("/back.png", new MousePoint(1430, 15), new MousePoint(1505, 85));
        back2 = new ClickedObject("/back.png", new MousePoint(1430, 15), new MousePoint(1505, 85));
        back3 = new ClickedObject("/back.png", new MousePoint(1430, 15), new MousePoint(1505, 85));
        back4 = new ClickedObject("/back.png", new MousePoint(1430, 15), new MousePoint(1505, 85));
        back5 = new ClickedObject("/back.png", new MousePoint(1430, 15), new MousePoint(1505, 85));
        // clickables
        menu = new ClickedObject("/menu.png", new MousePoint(1275, 10), new MousePoint(1420, 95));
        wantToExit = new ClickedObject("/wantToExit.png", new MousePoint(300, 200), new MousePoint(1300, 800));
        vi = new ClickedObject("/vi.png", new MousePoint(600, 550), new MousePoint(700, 650));
        x = new ClickedObject("/x.png", new MousePoint(900, 550), new MousePoint(1000, 650));
        socket = new ClickedObject("/socket.png", new MousePoint(230, 660), new MousePoint(290, 715));
        listClickables.add(socket);
        cableIn = new ClickedObject("/cableIn.png", new MousePoint(200, 600), new MousePoint(290, 750));
        carpet = new ClickedObject("/carpet2.png", new MousePoint(310, 775), new MousePoint(1180, 1000));
        listClickables.add(carpet);
        door = new ClickedObject("/door1.jpg", new MousePoint(550, 245), new MousePoint(850, 763));
        listClickables.add(door);
        desk = new ClickedObject("/desk5.png", new MousePoint(900, 520), new MousePoint(1400, 800));
        listClickables.add(desk);
        window = new ClickedObject("/window5.png", new MousePoint(160, 235), new MousePoint(475, 520));
        listClickables.add(window);
        cupboard = new ClickedObject("/cupboard5.png", new MousePoint(160, 540), new MousePoint(475, 810));
        listClickables.add(cupboard);
        switch_ = new ClickedObject("/switch.png", new MousePoint(880, 460), new MousePoint(940, 515));
        listClickables.add(switch_);
        books = new ClickedObject("/books5.png", new MousePoint(210, 637), new MousePoint(370, 750));
        listClickables.add(books);
        picture = new ClickedObject("/picture5.2.png", new MousePoint(1000, 250), new MousePoint(1270, 420));
        listClickables.add(picture);
        computer = new ClickedObject("/computer5.png", new MousePoint(960, 400), new MousePoint(1200, 580));
        listClickables.add(computer);
        kettle = new ClickedObject("/kettle5.png", new MousePoint(250, 440), new MousePoint(400, 565));
        listClickables.add(kettle);
        drawer1 = new ClickedObject("/drawer5.png", new MousePoint(350, 400), new MousePoint(1250, 700));
        drawer2 = new ClickedObject("/drawer5.png", new MousePoint(250, 400), new MousePoint(1350, 700));
        button1 = new ClickedObject("/white.png", new MousePoint(600, 530), new MousePoint(740, 670));
        button2 = new ClickedObject("/black.png", new MousePoint(850, 530), new MousePoint(990, 670));
        buttonA = new ClickedObject("/1.5.png", new MousePoint(500, 530), new MousePoint(640, 670));
        buttonB = new ClickedObject("/1.5.png", new MousePoint(730, 530), new MousePoint(870, 670));
        buttonC = new ClickedObject("/1.5.png", new MousePoint(960, 530), new MousePoint(1100, 670));
        closeWall = new ClickedObject("/closeWall5.png", new MousePoint(10, 10), new MousePoint(1510, 1000));
        buttonPassword = new ClickedObject("/code.png", new MousePoint(600, 470), new MousePoint(875, 550));
        // inventory items
        spray = new InventoryItem("/spray1.png", new MousePoint(10, 10), new MousePoint(130, 105));
        cable = new InventoryItem("/cable.png", new MousePoint(610, 400), new MousePoint(970, 560));
        disk = new InventoryItem("/diskOnKey.png", new MousePoint(610, 400), new MousePoint(970, 560));
        addMouseListener(new MyMouseListener());
        addMouseMotionListener(new MyMouseListener());
    }
    // an inner class. Here occur most of the interaction with the mouse.
    class MyMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            background.setImg("/room5.png");
            System.out.println(e.getX() + " " + e.getY());
            message.setFont(new Font("Ariel", Font.BOLD, 25));
            if (menu.ifClicked(e)) {
                ifWantToExit = true;
                message.setText("");
            }
            if (!ifCloseFrame) {
                if (door.ifClicked(e) && !ifComputerClose && !ifPictureClose && !ifDrawer1 && !ifDrawer2) {
                    if (ifCodeComputer) {
                        ifDoorLocked = false;
                    }
                }
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
            if (!ifDoorLocked) {
                ifDoorOpen = true;
            }
            if (ifDoorOpen) {
                door.setStart(new MousePoint(550, 245));
                door.setEnd(new MousePoint(850, 777));
                door.setImg("/door1Open.png");
            }
            if (exitStatus) {
                exitRoom();
            }
            if (!ifSprayAdded) {
                inventory.addItem(spray);
                ifSprayAdded = true;
            }
            /**
             * inventory items
             */
            if (spray.ifChose(e)) {
                ifSprayChoose = !ifSprayChoose;
                ifCableChoose = false;
                ifDiskChoose = false;
            }
            if (cable.ifChose(e) && ifCablePicked) {
                ifCableChoose = !ifCableChoose;
                ifSprayChoose = false;
                ifDiskChoose = false;
            }
            if (disk.ifChose(e) && ifDiskPicked) {
                ifDiskChoose = !ifDiskChoose;
                ifCableChoose = false;
                ifSprayChoose = false;
            }
            if (ifSprayChoose) {
                spray.setImg("/spray1Choose.png");
            } else {
                spray.setImg("/spray1.png");
            }
            if (ifCableChoose) {
                cable.setImg("/cableChoose.png");
            } else {
                cable.setImg("/cable.png");
            }
            if (ifDiskChoose) {
                disk.setImg("/diskOnKeyChoose.png");
            } else {
                disk.setImg("/diskOnKey.png");
            }
            if (ifCloseWall) {
                if (back4.ifClicked(e)) {
                    ifCloseFrame = false;
                    ifCloseWall = false;
                }
            }
            /**
             * other room
             */
            if (!ifCloseFrame) {
                if (door.ifClicked(e) && !ifComputerClose && !ifPictureClose && !ifDrawer1 && !ifDrawer2 && !ifDoorOpen) {
                    if (!ifCodeComputer) {
                        message.setText("It's locked.");
                    }
                }
                if (ifDoorOpen) {
                    exitStatus = true;
                }
                if (buttonPassword.ifClicked(e) && ifDiskOnKey && !ifCodeComputer) {
                    String password = JOptionPane.showInputDialog("enter password");
                    if (password != null) {
                        if (password.compareTo("x to unlock") == 0 || password.compareTo("17 to unlock") == 0) {
                            ifCodeComputer = true;
                        }   
                    }
                    else {
                    }
                }
                if (ifComputerClose) {
                    if (ifDiskChoose && computer.ifClicked(e)) {
                        ifDiskOnKey = true;
                    }
                }
                if (ifDiskOnKey) {
                    if (ifComputerClose) {
                        computer.setImg("/computerDisk.png");
                    }
                    inventory.deleteItem(disk);
                } else {
                    if (!ifComputerClose) {
                        computer.setImg("/computer5.png");
                    }
                }
                if (computer.ifClicked(e) && !picture.ifClicked(e) && !ifDrawer1 && !ifDrawer2) {
                    computer.setStart(new MousePoint(200, 150));
                    computer.setEnd(new MousePoint(1300, 900));
                    ifComputerClose = true;
                }
                if (ifComputerClose) {
                    if (!ifDiskOnKey) {
                        computer.setImg("/computer5NeedsDisk.png");
                    } else {
                        if (!ifCodeComputer) {
                            computer.setImg("/computerDisk.png");
                        } else {
                            computer.setImg("/computer5Success.png");
                        }
                    }
                    if (back1.ifClicked(e)) {
                        computer.setStart(new MousePoint(960, 400));
                        computer.setEnd(new MousePoint(1200, 580));
                        if (ifDiskOnKey) {
                            computer.setImg("/computerSmallDisk.png");
                        } else {
                            computer.setImg("/computer5.png");
                        }
                        ifComputerClose = false;
                    }
                }
                if (picture.ifClicked(e) && ifSprayChoose && ifPictureClose) {
                    picture.setImg("/picture5.2Sloved.png");
                    inventory.deleteItem(spray);
                }
                if (picture.ifClicked(e) && !computer.ifClicked(e) && !ifDrawer1 && !ifDrawer2) {
                    ifPictureClose = true;
                }
                if (ifPictureClose) {
                    picture.setStart(new MousePoint(400, 200));
                    picture.setEnd(new MousePoint(1200, 800));
                    if (back2.ifClicked(e)) {
                        picture.setStart(new MousePoint(1000, 250));
                        picture.setEnd(new MousePoint(1270, 420));
                        ifPictureClose = false;
                    }
                }
                // close wall
                if (e.getX() >= 1000 && e.getX() <= 1200 && e.getY() >= 660 && e.getY() <= 755) {
                    ifCloseFrame = true;
                    ifCloseWall = true;
                }
                // middle drawer
                if (e.getX() >= 1220 && e.getX() <= 1380 && e.getY() >= 620 && e.getY() <= 695 && !ifDrawer2
                        && !ifPictureClose && !ifComputerClose) {
                    ifDrawer1 = true;
                }
                if (ifDrawer1) {
                    if (button1.ifClicked(e) && !ifCode1) {
                        count++;
                        accum = accum + "W";
                    }
                    if (button2.ifClicked(e) && !ifCode1) {
                        count++;
                        accum = accum + "B";
                    }
                    if (code.compareTo(accum) != 0 && count == 6 && !ifCode1) {
                        message.setText("Wrong code...I should try again.");
                        accum = "";
                        count = 0;
                    }
                    if (code.compareTo(accum) == 0) {
                        ifCode1 = true;
                    }
                    if (back3.ifClicked(e)) {
                        accum = "";
                        count = 0;
                        ifDrawer1 = false;
                    }
                }
                if (ifDrawer2) {
                    if (buttonA.ifClicked(e) && !ifCode2) {
                        Room2CodeHelper helper = new Room2CodeHelper(buttonA, num1);
                        num1 = helper.getNewDirection();
                        if (num1 == 1) {
                            buttonA.setImg("/1.5.png");
                        }
                        if (num1 == 2) {
                            buttonA.setImg("/2.5.png");
                        }
                        if (num1 == 3) {
                            buttonA.setImg("/3.5.png");
                        }
                        if (num1 == 4) {
                            buttonA.setImg("/4.5.png");
                        }
                        if (num1 == 5) {
                            buttonA.setImg("/5.5.png");
                        }
                        if (num1 == 6) {
                            buttonA.setImg("/6.5.png");
                        }
                        if (num1 == 7) {
                            buttonA.setImg("/7.5.png");
                        }
                        if (num1 == 8) {
                            buttonA.setImg("/8.5.png");
                        }
                        if (num1 == 9) {
                            buttonA.setImg("/9.5.png");
                        }
                    }
                    if (buttonB.ifClicked(e) && !ifCode2) {
                        Room2CodeHelper helper = new Room2CodeHelper(buttonB, num2);
                        num2 = helper.getNewDirection();
                        if (num2 == 1) {
                            buttonB.setImg("/1.5.png");
                        }
                        if (num2 == 2) {
                            buttonB.setImg("/2.5.png");
                        }
                        if (num2 == 3) {
                            buttonB.setImg("/3.5.png");
                        }
                        if (num2 == 4) {
                            buttonB.setImg("/4.5.png");
                        }
                        if (num2 == 5) {
                            buttonB.setImg("/5.5.png");
                        }
                        if (num2 == 6) {
                            buttonB.setImg("/6.5.png");
                        }
                        if (num2 == 7) {
                            buttonB.setImg("/7.5.png");
                        }
                        if (num2 == 8) {
                            button2.setImg("/8.5.png");
                        }
                        if (num2 == 9) {
                            buttonB.setImg("/9.5.png");
                        }
                    }
                    if (buttonC.ifClicked(e) && !ifCode2) {
                        Room2CodeHelper helper = new Room2CodeHelper(buttonC, num3);
                        num3 = helper.getNewDirection();
                        if (num3 == 1) {
                            buttonC.setImg("/1.5.png");
                        }
                        if (num3 == 2) {
                            buttonC.setImg("/2.5.png");
                        }
                        if (num3 == 3) {
                            buttonC.setImg("/3.5.png");
                        }
                        if (num3 == 4) {
                            buttonC.setImg("/4.5.png");
                        }
                        if (num3 == 5) {
                            buttonC.setImg("/5.5.png");
                        }
                        if (num3 == 6) {
                            buttonC.setImg("/6.5.png");
                        }
                        if (num3 == 7) {
                            buttonC.setImg("/7.5.png");
                        }
                        if (num3 == 8) {
                            buttonC.setImg("/8.5.png");
                        }
                        if (num3 == 9) {
                            buttonC.setImg("/9.5.png");
                        }
                    }
                    if (num1 == 3 && num2 == 2 && num3 == 7) {
                        ifCode2 = true;
                    }
                    if (ifCode2) {
                        drawer2.setStart(new MousePoint(10, 10));
                        drawer2.setEnd(new MousePoint(1510, 1000));
                        drawer2.setImg("/drawer5.2.png");
                    }
                    if (disk.ifChose(e)) {
                        if (!ifDiskPicked) {
                            disk.setStart(new MousePoint(10, 10));
                            disk.setEnd(new MousePoint(140, 105));
                            inventory.addItem(disk);
                            ifDiskPicked = true;
                        }
                    }
                    if (back5.ifClicked(e)) {
                        ifDrawer2 = false;
                    }
                }
                // uper drawer
                if (e.getX() >= 920 && e.getX() <= 1220 && e.getY() >= 565 && e.getY() <= 620 && !ifPictureClose
                        && !ifComputerClose && !ifDrawer1) {
                    ifDrawer2 = true;
                }
                if (ifCode1) {
                    drawer1.setStart(new MousePoint(10, 10));
                    drawer1.setEnd(new MousePoint(1510, 1000));
                    drawer1.setImg("/drawer5.1.png");
                    if (cable.ifChose(e) && !ifCablePicked) {
                        ifCablePicked = true;
                        cable.setStart(new MousePoint(800, 850));
                        cable.setEnd(new MousePoint(950, 930));
                        inventory.addItem(cable);
                    }
                }
                if (kettle.ifClicked(e) && !ifComputerClose && !ifPictureClose && !ifDrawer1 && !ifDrawer2) {
                    if (ifCableIn) {
                        if (e.getX() >= 342 && e.getX() <= 349 && e.getY() >= 538 && e.getY() <= 542) {
                            window.setImg("/window5Code.png");
                        } else {
                            message.setText("It would be nice to have a cup of coffee.");
                        }
                    } else {
                        message.setText("It would be nice to have a cup of coffee.");
                    }
                }
                // the drawer of the cupboard
                if (e.getX() >= 195 && e.getX() <= 435 && e.getY() >= 570 && e.getY() <= 640) {
                    message.setText("It's locked.");
                }
                if (ifBooksMove) {
                    if (ifCableChoose && socket.ifClicked(e)) {
                        ifCableIn = true;
                        inventory.deleteItem(cable);
                    }
                }
                if (books.ifClicked(e) && !ifComputerClose && !ifPictureClose && !ifDrawer1 && !ifDrawer2) {
                    if (!ifCableIn) {
                        ifBooksMove = !ifBooksMove;
                    } else {
                        if (ifBooksMove) {
                            message.setText("Can't move books.");
                        }
                    }
                }
                if (ifBooksMove) {
                    books.setStart(new MousePoint(290, 637));
                    books.setEnd(new MousePoint(450, 750));
                } else {
                    books.setStart(new MousePoint(210, 637));
                    books.setEnd(new MousePoint(370, 750));
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
            // black button
            if (e.getX() >= 850 && e.getX() <= 990 && e.getY() >= 530 && e.getY() <= 670) {
                button2.setStart(new MousePoint(845, 525));
                button2.setEnd(new MousePoint(995, 675));
            } else {
                button2.setStart(new MousePoint(850, 530));
                button2.setEnd(new MousePoint(990, 670));
            }
            // white button
            if (e.getX() > 600 && e.getX() <= 740 && e.getY() >= 530 && e.getY() <= 670) {
                button1.setStart(new MousePoint(595, 525));
                button1.setEnd(new MousePoint(745, 675));
            } else {
                button1.setStart(new MousePoint(600, 530));
                button1.setEnd(new MousePoint(740, 670));
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
        if (ifCableIn) {
            socket.paintComponent(g);
            cableIn.paintComponent(g);
            cupboard.paintComponent(g);
        }
        if (!ifCloseFrame) {
            for (Clickable c : listClickables) {
                if (c != computer && c != socket) {
                    c.paintComponent(g);
                }
                if (c == computer) {
                    if (!ifPictureClose) {
                        c.paintComponent(g);
                    }
                }
                if (c == socket) {
                    if (!ifCableIn) {
                        socket.paintComponent(g);
                    }
                }
            }
        }
        if (ifComputerClose) {
            back1.paintComponent(g);
            if (ifDiskOnKey && !ifCodeComputer) {
                buttonPassword.paintComponent(g);
            }
        }
        if (ifPictureClose) {
            back2.paintComponent(g);
        }
        if (ifDrawer1) {
            drawer1.paintComponent(g);
            back3.paintComponent(g);
            if (!ifCode1) {
                button1.paintComponent(g);
                button2.paintComponent(g);
            }
            if (ifCode1 && !ifCablePicked) {
                cable.paintComponent(g);
            }
        }
        if (ifCloseWall) {
            closeWall.paintComponent(g);
            back4.paintComponent(g);
        }
        if (ifDrawer2) {
            drawer2.paintComponent(g);
            back5.paintComponent(g);
            if (!ifCode2) {
                buttonA.paintComponent(g);
                buttonB.paintComponent(g);
                buttonC.paintComponent(g);
            }
            if (!ifDiskPicked && ifCode2) {
                disk.paintComponent(g);
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
