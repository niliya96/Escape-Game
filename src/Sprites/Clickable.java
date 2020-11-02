package Sprites;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import Tools.MousePoint;
/**
 * Clickable
 * @author Nili
 *Clickable object is the main component of my game.
 *Every object that can be clicked in the game is a Clickable
 *operations:
 *1. check if an object is clicked by the mouse.
 *2. paint the object on the screen.
 *3. set the image represents the clickable.
 *4. set start and end point (move a clickable on the screen).
 */
public interface Clickable {
    boolean ifClicked(MouseEvent e);
    void paintComponent(Graphics g);
    void setImg(String path);
    void setStart(MousePoint p);
    void setEnd(MousePoint p);
}
