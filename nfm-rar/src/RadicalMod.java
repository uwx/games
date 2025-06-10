import java.applet.Applet;
import sun.audio.AudioPlayer;

public class RadicalMod {
   SuperStream stream;
   boolean playing = false;

   public void stop() {
      if (this.playing) {
         try {
            AudioPlayer.player.stop(this.stream);
         } catch (Exception var1) {
         }

         this.playing = false;
      }
   }

   protected void outwithit() {
      if (this.playing) {
         try {
            AudioPlayer.player.stop(this.stream);
         } catch (Exception var2) {
         }

         this.playing = false;
      }

      try {
         if (this.stream != null) {
            this.stream.close();
         }
      } catch (Exception var1) {
      }
   }

   public RadicalMod(String var1, int var2, int var3, int var4, GameSparker var5) {
      Mod var6 = new Mod(var1, var5);
      ModSlayer var7 = new ModSlayer(var6, var3, var2, var4);

      try {
         byte[] var8 = var7.turnbytes();
         this.stream = new SuperStream(var8);
      } catch (Exception var9) {
         this.stream = null;
         System.out.println("Error Loading Mod: " + var9);
      }

      System.gc();
   }

   public void resume() {
      if (!this.playing) {
         try {
            AudioPlayer.player.start(this.stream);
         } catch (Exception var1) {
         }

         this.playing = true;
      }
   }

   public void play() {
      if (!this.playing) {
         if (this.stream != null) {
            this.stream.reset();
         }

         try {
            AudioPlayer.player.start(this.stream);
         } catch (Exception var1) {
         }

         this.playing = true;
      }
   }

   public int posit() {
      return this.stream.available();
   }
}
