package Tools;

import Sprites.Clickable;

public class Room8CodeHelper2 {
    private String l;
    public Room8CodeHelper2(Clickable button1,String letter) {
        this.l = letter;
    }
    public String getNewDirection() {
        if (this.l.compareTo("h") == 0) {
            return "o";
        }
        if (this.l.compareTo("o") == 0) {
            return "s";
        }
        if (this.l.compareTo("s") == 0) {
            return "w";
        }
        if (this.l.compareTo("w") == 0) {
            return "h";
        }
        // avoid errors
        return "error";
    }
}
