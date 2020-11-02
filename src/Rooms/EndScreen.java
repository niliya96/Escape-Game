package Rooms;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import MainMenu.GamePanel;
import MainMenu.Menu;
import Sprites.Background;
import Sprites.ClickedObject;
import Tools.MousePoint;
public class EndScreen extends JPanel {
    private JFrame frame;
    Background b;
    ClickedObject exitsign;
    ClickedObject menusign;
    ClickedObject text;
    public EndScreen(JFrame frame) {
        super();
        this.frame = frame;
        b = new Background("/endScreen2.png", new MousePoint(10, 10), new MousePoint(1510, 1000));
        exitsign = new ClickedObject("/exitEnd.png", new MousePoint(510, 355), new MousePoint(750, 515));
        menusign = new ClickedObject("/menuEnd.png", new MousePoint(810, 355), new MousePoint(1050, 515));
        text = new ClickedObject("/youDidIt.png", new MousePoint(330, 150), new MousePoint(1200, 350));
        addMouseListener(new MyMouseListener(this.frame, this));
        addMouseMotionListener(new MyMouseListener(this.frame, this));
    }
    class MyMouseListener extends MouseAdapter {
        JFrame frame;
        EndScreen es;
        public MyMouseListener(JFrame f, EndScreen es) {
            this.frame = f;
            this.es = es;
        }
        @Override
        public void mouseClicked(MouseEvent e) {
            if (exitsign.ifClicked(e)) {
                System.exit(0);
            }
            if (menusign.ifClicked(e)) {
                frame.setContentPane(new Menu(frame));
                frame.pack();
                setVisible(true);
            }
            repaint();
        }
        @Override
        public void mouseMoved(MouseEvent e) {
            if (e.getX() >= 810 && e.getX() <= 1050 && e.getY() >= 355 && e.getY() <= 515) {
                menusign.setStart(new MousePoint(805, 350));
                menusign.setEnd(new MousePoint(1055, 520));
                menusign.setImg("/menuEndBig.png");
            } else {
                menusign.setStart(new MousePoint(810, 355));
                menusign.setEnd(new MousePoint(1050, 515));
                menusign.setImg("/menuEnd.png");
            }
            if (e.getX() >= 510 && e.getX() <= 750 && e.getY() >= 355 && e.getY() <= 515) {
                exitsign.setStart(new MousePoint(505, 350));
                exitsign.setEnd(new MousePoint(755, 520));
                exitsign.setImg("/exitEndBig.png");
            } else {
                exitsign.setStart(new MousePoint(510, 355));
                exitsign.setEnd(new MousePoint(750, 515));
                exitsign.setImg("/exitEnd.png");
            }
            repaint();
        }
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        b.paintComponent(g);
        exitsign.paintComponent(g);
        menusign.paintComponent(g);
        text.paintComponent(g);
    }
}
