
import java.io.ByteArrayInputStream;
import javax.sound.sampled.*;

class Music {

 Clip clp = null;
 AudioInputStream snd;

 Music(byte[] b) {
  ByteArrayInputStream bs;
  try {
   bs = new ByteArrayInputStream(b);
   snd = AudioSystem.getAudioInputStream(bs);
   snd.mark(b.length);
   DataLine.Info i = new DataLine.Info(Clip.class, snd.getFormat());
   clp = ((Clip) AudioSystem.getLine(i));
  } catch (Exception e) {
   System.out.println("Music loading error: " + e);
  }
 }

 void lop() {
  if (!clp.isOpen()) {
   try {
    clp.open(snd);
   } catch (Exception e) {
   }
  }
  if (!clp.isRunning()) {
   clp.loop(-1);
  }
 }

 void stp() {
  if (clp.isRunning()) {
   clp.stop();
  }
 }
}
