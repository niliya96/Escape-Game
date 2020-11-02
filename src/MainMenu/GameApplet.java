package MainMenu;
import javax.swing.JApplet;
import javax.swing.SwingUtilities;

public class GameApplet extends JApplet{
    //Called when this applet is loaded into the browser.
    public void init() {
        //Execute a job on the event-dispatching thread; creating this applet's GUI.
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    GameRunner gameRunner = new GameRunner();
                    setContentPane(gameRunner);
                }
            });
        } catch (Exception e) {
            System.err.println("createGUI didn't complete successfully");
        }
    }

}