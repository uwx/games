import java.io.ByteArrayInputStream;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.AudioFormat.Encoding;
import javax.sound.sampled.DataLine.Info;

public class SuperClip implements Runnable {
   int skiprate = 0;
   Thread cliper;
   int stoped = 1;
   SourceDataLine source = null;
   ByteArrayInputStream stream;

   public SuperClip(byte[] abyte0, int i, int j) {
      this.stoped = 2;
      this.skiprate = j;
      this.stream = new ByteArrayInputStream(abyte0, 0, i);
   }

   @Override
   public void run() {
      boolean flag = false;

      try {
         Info info = new Info(SourceDataLine.class, new AudioFormat(Encoding.PCM_SIGNED, -1.0F, 16, 2, 4, -1.0F, true));
         this.source = (SourceDataLine)AudioSystem.getLine(info);
         this.source.open(new AudioFormat(this.skiprate, 16, 1, false, false));
         this.source.start();
      } catch (Exception var5) {
         this.stoped = 1;
      }

      while (this.stoped == 0) {
         try {
            if (this.source.available() < this.skiprate || !flag) {
               byte[] abyte0 = new byte[this.skiprate];
               int i = this.stream.read(abyte0, 0, abyte0.length);
               if (i == -1) {
                  this.stream.reset();
                  this.stream.read(abyte0, 0, abyte0.length);
               }

               this.source.write(abyte0, 0, abyte0.length);
               flag = true;
            }
         } catch (Exception var6) {
            System.out.println("play error: " + var6);
            this.stoped = 1;
         }

         try {
            Thread _tmp = this.cliper;
            Thread.sleep(200L);
         } catch (InterruptedException var4) {
         }
      }

      this.source.stop();
      this.source.close();
      this.source = null;
      this.stoped = 2;
   }

   public void play() {
      if (this.stoped == 2) {
         this.stoped = 0;

         try {
            this.stream.reset();
         } catch (Exception var2) {
         }

         this.cliper = new Thread(this);
         this.cliper.start();
      }
   }

   public void resume() {
      if (this.stoped == 2) {
         this.stoped = 0;
         this.cliper = new Thread(this);
         this.cliper.start();
      }
   }

   public void stop() {
      if (this.stoped == 0) {
         this.stoped = 1;
         if (this.source != null) {
            this.source.stop();
         }
      }
   }

   public void close() {
      try {
         this.stream.close();
         this.stream = null;
      } catch (Exception var2) {
      }
   }
}
