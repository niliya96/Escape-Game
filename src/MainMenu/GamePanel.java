package MainMenu;
import Tools.*;
import Sprites.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * GamePanel
 * @author Nili
 * This is the game panel. This is the panel on which the game is
 * played. Initializes message and inventory panel. Also initializes
 * the WallBegin object, the wall that begins the game.
 */
public class GamePanel extends JPanel {
    List<ClickedObject> clicked = new ArrayList<ClickedObject>();
    public MessagePanel panel;
    public WallBegin wb;
    public JFrame frame;
    public InventoryPanel inventory;
    public GamePanel(JFrame f) {
        super();
        frame = f;
        setBackground(new Color(77, 77, 77));
        setLayout(new BorderLayout());
        panel = new MessagePanel();
        add(panel, BorderLayout.NORTH);
        inventory = new InventoryPanel();
        wb = new WallBegin(this, frame, inventory);
        add(wb, BorderLayout.CENTER);
    }
    public void addClickable(ClickedObject c) {
        this.clicked.add(c);
    }
}
