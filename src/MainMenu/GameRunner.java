package MainMenu;
import javax.swing.JFrame;
/**
 * GameRunner
 * @author Nili
 * This is the runner of the game. Includes the main of the program,
 * Operates a Menu object.
 */
public class GameRunner extends JFrame {
    public static void main(String[] args) {
        // runs the game
        new GameRunner();
    }
    // an inner class
    private GameRunner() {
        super();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // calls to the menu
        setContentPane(new Menu(this));
        pack();
        setVisible(true);
    }
}
