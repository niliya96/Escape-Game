package Sprites;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import Tools.ImageReader;
import Tools.MousePoint;
/**
 * InventoryItem
 * @author Nili
 *An InventoryItem is an item in the game that the user can picked and use.
 *All the items are added to the InventoryPanel, an object with a list that includes all the items that
 *the user can use.
 *ifChose - a method that returns true if the user requests to use the item.
 */
public class InventoryItem extends JPanel {
    protected BufferedImage img;
    protected MousePoint start;
    protected MousePoint end;
    public InventoryItem(String path, MousePoint start, MousePoint end) {
        ImageReader reader = new ImageReader(path);
        this.img = reader.getImg();
        this.start = start;
        this.end = end;
    }
    public boolean ifChose(MouseEvent e) {
        if ((e.getX() >= this.start.getX()) && (e.getX() <= this.end.getX())) {
            if ((e.getY() >= this.start.getY()) && (e.getY() <= this.end.getY())) {
                return true;
            }
        }
        return false;
    }
    public void paintComponent(Graphics g) {
        int width = this.getEnd().getX() - this.getStart().getX();
        int length = this.getEnd().getY() - this.getStart().getY();
        g.drawImage(this.getImg(), this.getStart().getX(), this.getStart().getY(), width, length, null);
    }
    public MousePoint getStart() {
        return this.start;
    }
    public MousePoint getEnd() {
        return this.end;
    }
    public BufferedImage getImg() {
        return this.img;
    }
    public int getWidth() {
        return this.end.getX() - this.start.getX();
    }
    public int getHeight() {
        return this.end.getY() - this.start.getY();
    }
    public void setStart(MousePoint p) {
        this.start = p;
    }
    public void setEnd(MousePoint p) {
        this.end = p;
    }
    public void setImg(String path) {
        ImageReader reader = new ImageReader(path);
        this.img = reader.getImg();
    }
}
