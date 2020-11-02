package Sprites;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import Tools.*;
/**
 * Background
 * @author Nili
 *Background is an implementation of Clickable interface.
 *This is an object for background in the game.
 *path- the path for the picture of the backgrond (in res).
 *start, end- represents the top right and bottom left corners of the object.
 */
public class Background implements Clickable {
    protected BufferedImage img;
    protected MousePoint start;
    protected MousePoint end;
    public Background(String path, MousePoint start, MousePoint end) {
        ImageReader reader = new ImageReader(path);
        this.img = reader.getImg();
        this.start = start;
        this.end = end;
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
    @Override
    public boolean ifClicked(MouseEvent e) {
        // always true
        return true;
    }
}
