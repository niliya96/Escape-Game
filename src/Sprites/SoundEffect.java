package Sprites;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
/**
 * SoundEffect
 * @author Nili
 *A SoundEffect object has two methods:
 *1. setFile- gets a string represents the path to the url, and tries to open it.
 *2. play- play the sound after setFile method succeded.
 */
public class SoundEffect {
    Clip clip;
    URL url;
    public void setFile(String soundFile) {
        try {
        	url = getClass().getResource(soundFile);
        	AudioInputStream as = AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            clip.open(as);
        } catch (Exception e) {
        }
    }
    public void play() {
        clip.setFramePosition(0);
        clip.start();
    }
}
