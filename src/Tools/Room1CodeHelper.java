package Tools;

import Sprites.Clickable;
import Sprites.ClickedObject;

public class Room1CodeHelper {
    private Clickable c;
    private String direction;
    public Room1CodeHelper(Clickable button1,String direction) {
        this.c = button1;
        this.direction = direction;
    }
    public String getNewDirection() {
        if (this.direction.compareTo("north") == 0) {
            return "east";
        }
        if (this.direction.compareTo("south") == 0) {
            return "west";
        }
        if (this.direction.compareTo("east") == 0) {
            return "south";
        }
        if (this.direction.compareTo("west") == 0) {
            return "north";
        }
        // avoid errors
        return "error";
    }
}
