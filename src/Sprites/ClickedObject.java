package Sprites;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import Tools.*;
/**
 * ClickedObject
 * @author Nili
 *ClickedObject is an implementation of Clickable interface.
 *img- the image object for the picture of the backgrond (in res).
 *start, end- represents the top right and bottom left corners of the object.
 */
public class ClickedObject extends JPanel implements Clickable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected BufferedImage img;
    protected MousePoint start;
    protected MousePoint end;
    public ClickedObject(String path, MousePoint start, MousePoint end) {
        ImageReader reader = new ImageReader(path);
        this.img = reader.getImg();
        this.start = start;
        this.end = end;
    }
    public boolean ifClicked(MouseEvent e) {
        if ((e.getX() >= this.start.getX()) && (e.getX() <= this.end.getX())) {
            if ((e.getY() >= this.start.getY()) && (e.getY() <= this.end.getY())) {
                return true;
            }
        }
        return false;
    }
    @Override
    public void paintComponent(Graphics g) {
        int width = this.getEnd().getX() - this.getStart().getX();
        int length = this.getEnd().getY() - this.getStart().getY();
        g.drawImage(this.getImg(), this.getStart().getX(), this.getStart().getY(), width, length, null);
    }
    @Override
    public void setImg(String path) {
        ImageReader reader = new ImageReader(path);
        this.img = reader.getImg();
    }
    @Override
    public void setStart(MousePoint p) {
        this.start = p;
    }
    @Override
    public void setEnd(MousePoint p) {
        this.end = p;
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
}