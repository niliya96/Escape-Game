package Tools;

import Sprites.Clickable;

public class Room8CodeHelper {
    private String color;
    public Room8CodeHelper(Clickable button1,String color) {
        this.color = color;
    }
    public String getNewDirection() {
        if (this.color.compareTo("lightBlue") == 0) {
            return "pink";
        }
        if (this.color.compareTo("pink") == 0) {
            return "orange";
        }
        if (this.color.compareTo("orange") == 0) {
            return "lightBlue";
        }
        // avoid errors
        return "error";
    }
}
