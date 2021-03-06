package Tools;

import Sprites.Clickable;

public class Room9CodeHelper {
	private String l;

	public Room9CodeHelper(Clickable button1, String letter) {
		this.l = letter;
	}

	public String getNewDirection() {
		if (this.l.compareTo("h") == 0) {
			return "f";
		}
		if (this.l.compareTo("f") == 0) {
			return "s";
		}
		if (this.l.compareTo("s") == 0) {
			return "i";
		}
		if (this.l.compareTo("i") == 0) {
			return "h";
		}
		// avoid errors
		return "error";
	}
}
