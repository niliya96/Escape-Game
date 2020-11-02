package Tools;
import java.awt.event.MouseEvent;

public class Room6CodeHelper {
        public boolean ifStar(MouseEvent e) {
            if (e.getX() >= 605 && e.getX() <= 680) {
                if (e.getY() >= 640 && e.getY() <= 705) {
                    return true;
                }
            }
            return false;
        }
        public boolean ifCircle(MouseEvent e) {
            if (e.getX() >= 705 && e.getX() <= 780) {
                if (e.getY() >= 640 && e.getY() <= 705) {
                    return true;
                }
            }
            return false;
        }
        public boolean ifSquer(MouseEvent e) {
            if (e.getX() >= 810 && e.getX() <= 885) {
                if (e.getY() >= 640 && e.getY() <= 705) {
                    return true;
                }   
            }
            return false;
        }
        public boolean ifHeart(MouseEvent e) {
            if (e.getX() >= 910  && e.getX() <= 985) {
                if (e.getY() >= 640 && e.getY() <= 705) {
                    return true;
                }
            }
            return false;
        }
}
