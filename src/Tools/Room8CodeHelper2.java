package Tools;

import Sprites.Clickable;
import Sprites.ClickedObject;

public class Room8CodeHelper2 {
    private Clickable c;
    private String l;
    public Room8CodeHelper2(Clickable button1,String letter) {
        this.c = button1;
        this.l = letter;
    }
    public String getNewDirection() {
        if (this.l.compareTo("a") == 0) {
            return "h";
        }
        if (this.l.compareTo("h") == 0) {
            return "o";
        }
        if (this.l.compareTo("o") == 0) {
            return "p";
        }
        if (this.l.compareTo("p") == 0) {
            return "r";
        }
        if (this.l.compareTo("r") == 0) {
            return "s";
        }
        if (this.l.compareTo("s") == 0) {
            return "w";
        }
        if (this.l.compareTo("w") == 0) {
            return "a";
        }
        // avoid errors
        return "error";
    }
}
