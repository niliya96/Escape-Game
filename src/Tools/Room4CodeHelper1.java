package Tools;
import Sprites.Clickable;

public class Room4CodeHelper1 {
    private int num;
    public Room4CodeHelper1(Clickable button1,int num) {
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
            return 1;
        }
        // avoid errors
        return 0;
    }
}
