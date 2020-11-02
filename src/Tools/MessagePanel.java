package Tools;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * MessagePanel
 * @author Nili
 *This object is the message panel o the game.
 *The user gets a message when he do something (not always, depands on where he clicked).
 *Every level (Room) class gets a message panel and can set it's text depands on where the user clicked.
 *This object has a JLable, so we can get\set the text.
 */
public class MessagePanel extends JPanel {
    public JLabel lable;

    public MessagePanel() {
        lable = new JLabel();
        add(lable);
    }

    public JLabel getText() {
        return lable;
    }
}
