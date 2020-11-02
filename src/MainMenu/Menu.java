package MainMenu;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Sprites.Background;
import Sprites.ClickedObject;
import Sprites.SoundEffect;
import Tools.MousePoint;
/**
 * Menu
 * @author Nili
 *This is the main menu of the game. The menu includes 3 operations:
 *start a new game, exit the game, read the instructions of the game.
 */
public class Menu extends JPanel {
    private JFrame frame;
    SoundEffect se = new SoundEffect();
    String enter = ".//res//openDoor.wav";
    String exit = ".//res//exit.wav";
    Background b;
    // here all the clickables are doors that functioning as buttons, and sign with the operation on each door.
    ClickedObject newGameDoor;
    ClickedObject exitDoor;
    ClickedObject instructionsDoor;
    ClickedObject exitsign;
    ClickedObject playsign;
    ClickedObject instructionsSign;
    public Menu(JFrame frame) {
        super();
        this.frame = frame;
        b = new Background("/startScreenBackground.png", new MousePoint(10, 10), new MousePoint(1510, 1000));
        newGameDoor = new ClickedObject("/doorScreen.png", new MousePoint(590, 235), new MousePoint(930, 867));
        exitDoor = new ClickedObject("/doorScreen.png", new MousePoint(1020, 235), new MousePoint(1360, 867));
        instructionsDoor = new ClickedObject("/doorScreen.png", new MousePoint(160, 235), new MousePoint(500, 867));
        exitsign = new ClickedObject("/exit.png", new MousePoint(1070, 355), new MousePoint(1310, 515));
        playsign = new ClickedObject("/play.png", new MousePoint(640, 355), new MousePoint(880, 515));
        instructionsSign = new ClickedObject("/instructions.png", new MousePoint(210, 355), new MousePoint(450, 515));
        setPreferredSize(new Dimension(1520, 1000));
        setMaximumSize(new Dimension(1540, 1000));
        setMinimumSize(new Dimension(1540, 1000));
        GridBagLayout gl = new GridBagLayout();
        setLayout(gl);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.ipady = 20;
        c.ipadx = 300;
        c.insets = new Insets(20, 0, 0, 0);
        frame.setDefaultCloseOperation(0);
        frame.setResizable(false);
        addMouseListener(new MyMouseListener(this.frame, this));
        addMouseMotionListener(new MyMouseListener(this.frame, this));
    }
    
    class MyMouseListener extends MouseAdapter {
        JFrame frame;
        Menu menu;
        public MyMouseListener(JFrame f, Menu m) {
            this.frame = f;
            this.menu = m;
        }
        /**
         * Responsable for the operations when an object is clicked.
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            // exit door is clicked
            if (exitDoor.ifClicked(e)) {
                se.setFile(exit);
                se.play();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                // exit operation
                System.exit(0);
            }
            // new game door is clicked
            if (newGameDoor.ifClicked(e)) {
                se.setFile(enter);
                se.play();
                // new game operation
                setVisible(false);
                frame.setContentPane(new GamePanel(this.frame));
                frame.getContentPane().remove(this.menu);
            }
        }
        /**
         * Responsable for the effects when the mouse is moved on a clickable object (not pressed).
         */
        @Override
        public void mouseMoved(MouseEvent e) {
            // new Game button
            if (e.getX() >= 590 && e.getX() <= 930 && e.getY() >= 235 && e.getY() <= 867) {
                newGameDoor.setStart(new MousePoint(585, 230));
                newGameDoor.setEnd(new MousePoint(935, 870));
                playsign.setStart(new MousePoint(635, 350));
                playsign.setEnd(new MousePoint(885, 520));
                playsign.setImg("/playBig.png");
            } else {
                newGameDoor.setStart(new MousePoint(590, 235));
                newGameDoor.setEnd(new MousePoint(930, 867));
                playsign.setStart(new MousePoint(640, 355));
                playsign.setEnd(new MousePoint(880, 515));
                playsign.setImg("/play.png");
            }
            // exit Game button
            if (e.getX() >= 1020 && e.getX() <= 1360 && e.getY() >= 235 && e.getY() <= 867) {
                exitDoor.setStart(new MousePoint(1015, 230));
                exitDoor.setEnd(new MousePoint(1365, 870));
                exitsign.setStart(new MousePoint(1065, 350));
                exitsign.setEnd(new MousePoint(1315, 520));
                exitsign.setImg("/exitBig.png");
            } else {
                exitDoor.setStart(new MousePoint(1020, 235));
                exitDoor.setEnd(new MousePoint(1360, 867));
                exitsign.setStart(new MousePoint(1070, 355));
                exitsign.setEnd(new MousePoint(1310, 515));
                exitsign.setImg("/exit.png");
            }
            // instruction button
            if (e.getX() >= 160 && e.getX() <= 500 && e.getY() >= 235 && e.getY() <= 867) {
                instructionsDoor.setStart(new MousePoint(155, 230));
                instructionsDoor.setEnd(new MousePoint(505, 870));
                instructionsSign.setStart(new MousePoint(205, 350));
                instructionsSign.setEnd(new MousePoint(455, 520));
                instructionsSign.setImg("/instructionsBig.png");
            } else {
                instructionsDoor.setStart(new MousePoint(160, 235));
                instructionsDoor.setEnd(new MousePoint(500, 867));
                instructionsSign.setStart(new MousePoint(210, 355));
                instructionsSign.setEnd(new MousePoint(450, 515));
                instructionsSign.setImg("/instructions.png");
            }
            repaint();
        }
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        b.paintComponent(g);
        newGameDoor.paintComponent(g);
        instructionsDoor.paintComponent(g);
        exitDoor.paintComponent(g);
        exitsign.paintComponent(g);
        playsign.paintComponent(g);
        instructionsSign.paintComponent(g);
    }
}