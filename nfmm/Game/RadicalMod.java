import ds.nfm.Module;
import ds.nfm.ModuleLoader;
import ds.nfm.ModuleSlayer;
import java.net.URL;

public class RadicalMod {
   SuperClip sClip;
   boolean playing = false;
   int loaded = 0;
   int rvol = 0;
   String imod = "";
   String pmod = "";

   public RadicalMod() {
      this.loaded = 0;
      System.gc();
   }

   public RadicalMod(String var1, int var2, int var3, int var4, boolean var5, boolean var6) {
      short var7 = 22000;
      var3 = (int)(var3 / 8000.0F * 2.0F * var7);
      var2 = (int)(var2 * 0.8F);

      try {
         Object var8 = null;
         if (!var6) {
            var8 = ModuleLoader.loadMod("" + Madness.fpath + "" + var1 + "");
         } else {
            var1 = var1.replace(' ', '_');
            URL var9 = new URL("http://multiplayer.needformadness.com/tracks/music/" + var1 + ".zip");
            var8 = ModuleLoader.loadMod(var9);
         }

         if (((Module)var8).isLoaded()) {
            ModuleSlayer var17 = ModuleLoader.prepareSlayer((Module)var8, var3, var2, var4);
            byte[] var10 = var17.turnbytesNorm(var5);
            if (var5) {
               this.rvol = var17.olav;
            }

            this.sClip = new SuperClip(var10, var17.oln, var7);
            this.sClip.rollBackPos = var17.rollBackPos;
            this.sClip.rollBackTrig = var17.oln - var17.rollBackTrig;
            var10 = null;
            var8 = null;
            Object var18 = null;
            this.loaded = 2;
         }
      } catch (Exception var11) {
         System.out.println("Error downloading and making Mod: " + var11.toString());
         this.loaded = 0;
      }

      System.runFinalization();
      System.gc();
   }

   public RadicalMod(String var1) {
      this.loaded = 1;
      this.imod = "" + Madness.fpath + "" + var1 + "";
   }

   public void loadimod(boolean var1) {
      if (this.loaded == 1) {
         char var2 = 'ꯠ';
         short var3 = 160;
         if (var1) {
            var3 = 300;
         }

         byte var4 = 125;

         try {
            Module var5 = ModuleLoader.loadMod(this.imod);
            if (var5.isLoaded()) {
               ModuleSlayer var6 = ModuleLoader.prepareSlayer(var5, var2, var3, var4);
               byte[] var7 = var6.turnbytesNorm(var1);
               if (var1) {
                  this.rvol = var6.olav;
               }

               this.sClip = new SuperClip(var7, var6.oln, 22000);
               this.sClip.rollBackPos = var6.rollBackPos;
               this.sClip.rollBackTrig = var6.oln - var6.rollBackTrig;
               var7 = null;
               var5 = null;
               Object var10 = null;
               this.loaded = 2;
            }
         } catch (Exception var8) {
            System.out.println("Error making a imod: " + var8.toString());
            this.loaded = 0;
         }

         System.runFinalization();
         System.gc();
      }
   }

   public void loadpmod(boolean var1) {
      if (this.loaded == 1) {
         char var2 = 'ꯠ';
         short var3 = 160;
         if (var1) {
            var3 = 300;
         }

         byte var4 = 125;

         try {
            Module var5 = ModuleLoader.loadMod(this.pmod);
            if (var5.isLoaded()) {
               ModuleSlayer var6 = ModuleLoader.prepareSlayer(var5, var2, var3, var4);
               byte[] var7 = var6.turnbytesNorm(var1);
               if (var1) {
                  this.rvol = var6.olav;
               }

               this.sClip = new SuperClip(var7, var6.oln, 22000);
               this.sClip.rollBackPos = var6.rollBackPos;
               this.sClip.rollBackTrig = var6.oln - var6.rollBackTrig;
               var7 = null;
               var5 = null;
               Object var10 = null;
               this.loaded = 2;
            }
         } catch (Exception var8) {
            System.out.println("Error making a imod: " + var8.toString());
            this.loaded = 0;
         }

         System.runFinalization();
         System.gc();
      }
   }

   public RadicalMod(String var1, boolean var2) {
      this.loaded = 1;
      this.pmod = var1;
      this.loadpmod(true);
   }

   public void play() {
      if (!this.playing && this.loaded == 2) {
         this.sClip.play();
         if (this.sClip.stoped == 0) {
            this.playing = true;
         }
      }
   }

   public void resume() {
      if (!this.playing && this.loaded == 2) {
         this.sClip.resume();
         if (this.sClip.stoped == 0) {
            this.playing = true;
         }
      }
   }

   public void stop() {
      if (this.playing && this.loaded == 2) {
         this.sClip.stop();
         this.playing = false;
      }
   }

   protected void unloadimod() {
      if (this.loaded == 2) {
         if (this.playing) {
            this.sClip.stop();
            this.playing = false;
         }

         try {
            this.sClip.close();
            this.sClip = null;
         } catch (Exception var2) {
         }

         System.gc();
         this.loaded = 1;
      }
   }

   protected void unload() {
      if (this.playing && this.loaded == 2) {
         this.sClip.stop();
         this.playing = false;
      }

      try {
         this.sClip.close();
         this.sClip = null;
      } catch (Exception var3) {
      }

      try {
         this.imod = null;
      } catch (Exception var2) {
      }

      System.gc();
      this.loaded = 0;
   }
}
