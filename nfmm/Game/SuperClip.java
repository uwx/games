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
   int rollBackPos = 0;
   int rollBackTrig = 0;
   boolean changeGain = false;

   public SuperClip(byte[] var1, int var2, int var3) {
      this.stoped = 2;
      this.skiprate = var3;
      this.stream = new ByteArrayInputStream(var1, 0, var2);
   }

   @Override
   public void run() {
      try {
         AudioFormat var1 = new AudioFormat(Encoding.PCM_SIGNED, this.skiprate, 16, 1, 2, this.skiprate, false);
         Info var2 = new Info(SourceDataLine.class, var1);
         this.source = (SourceDataLine)AudioSystem.getLine(var2);
         this.source.open(var1);
         this.source.start();
      } catch (Exception var7) {
         this.stoped = 1;
      }

      boolean var9 = false;

      while (this.stoped == 0) {
         try {
            int var10 = this.skiprate;
            int var3 = this.stream.available();
            if (var3 % 2 != 0) {
               var3++;
            }

            byte[] var4 = new byte[var3 > var10 ? var10 : var3];
            int var5 = this.stream.read(var4, 0, var4.length);
            if (var5 == -1 || this.rollBackPos != 0 && var3 < this.rollBackTrig) {
               var9 = true;
            }

            if (var9) {
               if (var5 != -1) {
                  this.source.write(var4, 0, var4.length);
               }

               this.stream.reset();
               if (this.rollBackPos != 0) {
                  this.stream.skip(this.rollBackPos);
               }

               var3 = this.stream.available();
               if (var3 % 2 != 0) {
                  var3++;
               }

               var4 = new byte[var3 > var10 ? var10 : var3];
               this.stream.read(var4, 0, var4.length);
               var9 = false;
            }

            this.source.write(var4, 0, var4.length);
         } catch (Exception var8) {
            System.out.println("Play error: " + var8);
            this.stoped = 1;
         }

         try {
            Thread.sleep(200L);
         } catch (InterruptedException var6) {
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
