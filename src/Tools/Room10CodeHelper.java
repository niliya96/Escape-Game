package Tools;
import Sprites.ClickedObject;

public class Room10CodeHelper {
    private ClickedObject c;
    private int number;
    public Room10CodeHelper(ClickedObject c, int number) {
        this.c = c;
        this.number = number;
    }
    public int getNewNumber() {
        if (this.number == 12) {
            return 3;
        }
        if (this.number == 3) {
            return 6;
        }
        if (this.number == 6) {
            return 9;
        }
        if (this.number == 9) {
            return 12;
        }
        // avoid errors
        return 12;
    }
}
