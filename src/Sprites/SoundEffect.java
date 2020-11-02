package Sprites;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
/**
 * SoundEffect
 * @author Nili
 *A SoundEffect object has two methods:
 *1. setFile- gets a string represents the path to the file, and tries to open it.
 *2. play- play the sound after setFile method succeded.
 */
public class SoundEffect {
    Clip clip;
    public void setFile(String soundFile) {
        try {
            File file = new File(soundFile);
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
        } catch (Exception e) {
        }
    }
    public void play() {
        clip.setFramePosition(0);
        clip.start();
    }
}
