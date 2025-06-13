import java.applet.Applet;
import java.io.ByteArrayInputStream;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import sun.audio.AudioPlayer;

public class RadicalMod {
   byte[] modf;
   SuperStream stream;
   SuperClip sClip;
   boolean suny = false;
   boolean playing = false;
   int loaded = 0;

   public void stop() {
      if (this.playing && this.loaded == 2) {
         if (this.suny) {
            this.sClip.stop();
         } else {
            try {
               AudioPlayer.player.stop(this.stream);
            } catch (Exception var2) {
            }
         }

         this.playing = false;
      }
   }

   public RadicalMod(String s, Applet applet) {
      this.loaded = 1;

      try {
         URL url = new URL(applet.getCodeBase(), s);
         ZipInputStream zipinputstream = new ZipInputStream(url.openStream());
         ZipEntry zipentry = zipinputstream.getNextEntry();
         int i = (int)zipentry.getSize();
         this.modf = new byte[i];
         int j = 0;

         while (i > 0) {
            int k = zipinputstream.read(this.modf, j, i);
            j += k;
            i -= k;
         }
      } catch (Exception var9) {
         System.out.println("Error loading Mod from zip file: " + var9);
         this.loaded = 0;
      }
   }

   public void resume() {
      if (!this.playing && this.loaded == 2) {
         if (this.suny) {
            this.sClip.resume();
            if (this.sClip.stoped == 0) {
               this.playing = true;
            }
         } else {
            try {
               AudioPlayer.player.start(this.stream);
            } catch (Exception var2) {
            }

            this.playing = true;
         }
      }
   }

   protected void unloadAll() {
      if (this.playing && this.loaded == 2) {
         if (this.suny) {
            this.sClip.stop();
         } else {
            try {
               AudioPlayer.player.stop(this.stream);
            } catch (Exception var4) {
            }
         }
      }

      try {
         if (this.suny) {
            this.sClip.close();
            this.sClip = null;
         } else {
            this.stream.close();
            this.stream = null;
         }
      } catch (Exception var3) {
      }

      try {
         this.modf = null;
      } catch (Exception var2) {
      }

      System.gc();
   }

   public void play() {
      if (!this.playing && this.loaded == 2) {
         if (this.suny) {
            this.sClip.play();
            if (this.sClip.stoped == 0) {
               this.playing = true;
            }
         } else {
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
   }

   protected void unloadMod() {
      if (this.loaded == 2) {
         if (this.playing) {
            if (this.suny) {
               this.sClip.stop();
            } else {
               try {
                  AudioPlayer.player.stop(this.stream);
               } catch (Exception var3) {
               }
            }

            this.playing = false;
         }

         try {
            if (this.suny) {
               this.sClip.close();
               this.sClip = null;
            } else {
               this.stream.close();
               this.stream = null;
            }
         } catch (Exception var2) {
         }

         System.gc();
         this.loaded = 1;
      }
   }

   public void loadMod(int i, int j, int k, boolean flag, boolean flag1) {
      if (this.loaded == 1) {
         this.loaded = 2;
         this.suny = flag;
         int l = 22000;
         if (flag1) {
            this.suny = false;
         }

         if (this.suny) {
            j = (int)(j / 8000.0F * 2.0F * l);
         }

         if (!this.suny) {
            if (!flag1) {
               i = (int)(i * 1.5);
            } else {
               i = (int)(i * 2.2);
            }
         }

         Mod mod = new Mod(new ByteArrayInputStream(this.modf));
         ModSlayer modslayer = new ModSlayer(mod, j, i, k);

         try {
            if (this.suny) {
               byte[] abyte0 = modslayer.turnbytesNorm();
               this.sClip = new SuperClip(abyte0, modslayer.oln, l);
            } else {
               byte[] abyte1 = modslayer.turnbytesUlaw();
               this.stream = new SuperStream(abyte1);
            }

            Object obj1 = null;
            Object obj = null;
            ModSlayer var12 = null;
         } catch (Exception var11) {
            System.out.println("Error making a Mod: " + var11);
            this.loaded = 0;
         }

         System.runFinalization();
         System.gc();
      }
   }
}
