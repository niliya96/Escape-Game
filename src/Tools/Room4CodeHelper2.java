package Tools;

import Sprites.Clickable;

public class Room4CodeHelper2 {
    private String num;
    public Room4CodeHelper2(Clickable button1,String num) {
        this.num = num;
    }
    public String getNewDirection() {
        if (this.num.compareTo("1") == 0) {
            return "2";
        }
        if (this.num.compareTo("2") == 0) {
            return "3";
        }
        if (this.num.compareTo("3") == 0) {
            return "4";
        }
        if (this.num.compareTo("4") == 0) {
            return "5";
        }
        if (this.num.compareTo("5") == 0) {
            return "6";
        }
        if (this.num.compareTo("6") == 0) {
            return "7";
        }
        if (this.num.compareTo("7") == 0) {
            return "8";
        }
        if (this.num.compareTo("8") == 0) {
            return "9";
        }
        if (this.num.compareTo("9") == 0) {
            return "0";
        }
        if (this.num.compareTo("0") == 0) {
            return "*";
        }
        if (this.num.compareTo("*") == 0) {
            return "#";
        }
        if (this.num.compareTo("#") == 0) {
            return "1";
        }
        // avoid errors
        return "error";
    }
}
