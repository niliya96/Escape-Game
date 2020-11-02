package Tools;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
/**
 * ImageReader
 * @author Nili
 *This class helps to read a buffered image file and set the file of the image.
 */
public class ImageReader {
    private BufferedImage img;
    public ImageReader(String path) {
        try {
            this.img = ImageIO.read(getClass().getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public BufferedImage getImg() {
        return this.img;
    }
    public void setImg(String path) {
        try {
            this.img = ImageIO.read(getClass().getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
