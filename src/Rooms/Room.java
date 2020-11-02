package Rooms;

/**
 * Room
 * @author Nili
 *This is an interface to a room panel. An object that inherents this interface represents a "level" 
 *in the game.
 */
public interface Room {
    public void exitRoom();
    public boolean getExitStatus();
    public void setExitStatus(boolean b);   
}
