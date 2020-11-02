package Tools;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Rooms.*;
import MainMenu.*;
/**
 * WallBegin
 * @author Nili
 *This class represents the wall that begins the game.
 *On this wall i produced all the levels and screens in the game, initialized them, and
 *decided which levels/screens to show and what is the order of them.
 *To show levels i used a CardLayout object.
 */
public class WallBegin extends JPanel {
    public CardLayout cl;
    public GamePanel game;
    public InventoryPanel inventory;
    public JFrame frame;
    Room1 room1;
    Room2 room2;
    Room3 room3;
    Room4 room4;
    Room5 room5;
    Room6 room6;
    Room7 room7;
    Room8 room8;
    Room9 room9;
    Room10 room10;
    EndScreen es;
    public WallBegin(GamePanel g, JFrame f, InventoryPanel i) {
        game = g;
        inventory = i;
        frame = f;
        setBackground(Color.BLACK);
        cl = new CardLayout();
        setLayout(cl);
        this.game.panel.getText().setFont(new Font("Ariel", Font.BOLD, 25));
        this.game.panel.getText().setText("Click around.");;
        room1 = new Room1(this, game, frame, inventory);
        room2 = new Room2(this, game, frame, inventory);
        room3 = new Room3(this, game, frame, inventory);
        room4 = new Room4(this, game, frame, inventory);
        room5 = new Room5(this, game, frame, inventory);
        room6 = new Room6(this, game, frame, inventory);
        room7 = new Room7(this, game, frame, inventory);
        room8 = new Room8(this, game, frame, inventory);
        room9 = new Room9(this, game, frame, inventory);
        room10 = new Room10(this, game, frame, inventory);
        es = new EndScreen(frame);
        // add rooms to the game
        add(room1, "room1");
        add(room2, "room2");
        add(room3, "room3");
        // TODO from here
        add(room4, "room4");
        add(room5, "room5");
        add(room6, "room6");
        add(room7, "room7");
        add(room8, "room8");
        add(room9, "room9");
        add(room10, "room10");
        add(es, "endScreen");
    }
    public CardLayout getCl() {
        return cl;
    }
}
