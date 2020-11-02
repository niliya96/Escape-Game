package Tools;
import Sprites.Clickable;

public class Room2CodeHelper {
    private Clickable c;
    private int num;
    public Room2CodeHelper(Clickable button1,int num) {
        this.c = button1;
        this.num = num;
    }
    public int getNewDirection() {
        if (this.num == 1) {
            return 2;
        }
        if (this.num == 2) {
            return 3;
        }
        if (this.num == 3) {
            return 4;
        }
        if (this.num == 4) {
            return 5;
        }
        if (this.num == 5) {
            return 6;
        }
        if (this.num == 6) {
            return 7;
        }
        if (this.num == 7) {
            return 8;
        }
        if (this.num == 8) {
            return 9;
        }
        if (this.num == 9) {
            return 1;
        }
        // avoid errors
        return 0;
    }
}
