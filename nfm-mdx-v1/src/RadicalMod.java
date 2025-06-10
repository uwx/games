import sun.audio.AudioPlayer;

public class RadicalMod {
   SuperStream stream;
   boolean playing = false;

   public void stop() {
      if (this.playing) {
         try {
            AudioPlayer.player.stop(this.stream);
         } catch (Exception var2) {
         }

         this.playing = false;
      }
   }

   protected void outwithit() {
      if (this.playing) {
         try {
            AudioPlayer.player.stop(this.stream);
         } catch (Exception var3) {
         }

         this.playing = false;
      }

      try {
         if (this.stream != null) {
            this.stream.close();
         }
      } catch (Exception var2) {
      }
   }

   public RadicalMod(String s, int i, int j, int k) {
      Mod mod = new Mod(s);
      ModSlayer modslayer = new ModSlayer(mod, j, i, k);

      try {
         byte[] abyte0 = modslayer.turnbytes();
         this.stream = new SuperStream(abyte0);
      } catch (Exception var8) {
         this.stream = null;
         System.out.println("Error Loading Mod: " + var8);
      }

      System.gc();
   }

   public void resume() {
      if (!this.playing) {
         try {
            AudioPlayer.player.start(this.stream);
         } catch (Exception var2) {
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
         } catch (Exception var2) {
         }

         this.playing = true;
      }
   }

   public int posit() {
      return this.stream.available();
   }
}
