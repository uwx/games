import java.io.ByteArrayInputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine.Info;

public class soundClip {
   Clip clip = null;
   AudioInputStream sound;
   boolean loaded = false;
   int lfrpo = -1;
   int cntcheck = 0;

   public soundClip(byte[] var1) {
      try {
         ByteArrayInputStream var2 = new ByteArrayInputStream(var1);
         this.sound = AudioSystem.getAudioInputStream(var2);
         this.sound.mark(var1.length);
         Info var3 = new Info(Clip.class, this.sound.getFormat());
         this.clip = (Clip)AudioSystem.getLine(var3);
         this.loaded = true;
      } catch (Exception var4) {
         System.out.println("Loading Clip error: " + var4);
         this.loaded = false;
      }
   }

   public void play() {
      if (this.loaded) {
         try {
            if (!this.clip.isOpen()) {
               try {
                  this.clip.open(this.sound);
               } catch (Exception var2) {
               }

               this.clip.loop(0);
            } else {
               this.clip.loop(1);
            }

            this.lfrpo = -1;
            this.cntcheck = 5;
         } catch (Exception var3) {
         }
      }
   }

   public void loop() {
      if (this.loaded) {
         try {
            if (!this.clip.isOpen()) {
               try {
                  this.clip.open(this.sound);
               } catch (Exception var2) {
               }
            }

            this.clip.loop(70);
            this.lfrpo = -2;
            this.cntcheck = 0;
         } catch (Exception var3) {
         }
      }
   }

   public void stop() {
      if (this.loaded) {
         try {
            this.clip.stop();
            this.lfrpo = -1;
         } catch (Exception var2) {
         }
      }
   }

   public void checkopen() {
      if (this.loaded && this.clip.isOpen() && this.lfrpo != -2) {
         if (this.cntcheck == 0) {
            int var1 = this.clip.getFramePosition();
            if (this.lfrpo == var1 && !this.clip.isRunning()) {
               try {
                  this.clip.close();
                  this.sound.reset();
               } catch (Exception var3) {
               }

               this.lfrpo = -1;
            } else {
               this.lfrpo = var1;
            }
         } else {
            this.cntcheck--;
         }
      }
   }
}
