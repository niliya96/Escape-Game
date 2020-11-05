package Tools;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import Sprites.*;
/**
 * InventoryPanel
 * @author Nili
 *This object represents a list of Inventory items.
 *This is the list of items that the user can use in the game.
 *When empty, the user doesn't see anything on the screen.
 *When not empty, the user can see the available items he can use, on the left up corner.
 *The object is a kind of Panel, because we want to draw the items on the screen.
 */
public class InventoryPanel extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// a private list of InventoryItem objects.
    private List<InventoryItem> lst = new ArrayList<InventoryItem>();
    public void addItem(InventoryItem i) {
        this.lst.add(i);
    }
    public void deleteItem(InventoryItem i) {
        int index = this.lst.indexOf(i);
        if (this.lst.contains(i)) {
            this.lst.remove(index);
        }
    }
    @Override
    public void paintComponent(Graphics g) {
        // the first item always starts at point (15,15) (and this is also the begining of the panel).
        int currentX = 15;
        int currentY = 15;
        for (int i = 0; i < this.lst.size(); i++) {
            // draw the current item
            g.drawImage(lst.get(i).getImg(), currentX, currentY, lst.get(i).getWidth(), lst.get(i).getHeight(), null);
            lst.get(i).setEnd(new MousePoint(currentX + lst.get(i).getWidth(), currentY + lst.get(i).getHeight()));
            lst.get(i).setStart(new MousePoint(currentX, currentY));
            // draw the next item exactly after the previous one.
            // the hight of all the items is the same.
            currentX = currentX + lst.get(i).getWidth();
        }
    }
    public List<InventoryItem> getLst() {
        return this.lst;
    }
}
