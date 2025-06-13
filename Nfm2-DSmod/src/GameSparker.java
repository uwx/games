import java.applet.Applet;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import netscape.javascript.JSObject;

public class GameSparker extends Applet implements Runnable {
   Graphics rd;
   Image offImage;
   Thread gamer;
   Control[] u = new Control[7];
   int mouses = 0;
   int xm = 0;
   int ym = 0;
   boolean lostfcs = false;
   boolean exwist = true;
   int nob = 0;
   int notb = 0;
   int view = 0;
   HashMap<String, Integer> properties;
   static Madness[] mads;

   @Override
   public boolean keyDown(Event event, int i) {
      if (!this.exwist) {
         if (i == 1004) {
            this.u[0].up = true;
         }

         if (i == 1005) {
            this.u[0].down = true;
         }

         if (i == 1007) {
            this.u[0].right = true;
         }

         if (i == 1006) {
            this.u[0].left = true;
         }

         if (i == 32) {
            this.u[0].handb = true;
         }

         if (i == 120 || i == 88) {
            this.u[0].lookback = -1;
         }

         if (i == 122 || i == 90) {
            this.u[0].lookback = 1;
         }

         if (i == 10 || i == 80 || i == 112 || i == 27) {
            this.u[0].enter = true;
         }

         if (i == 77 || i == 109) {
            if (this.u[0].mutem) {
               this.u[0].mutem = false;
            } else {
               this.u[0].mutem = true;
            }
         }

         if (i == 78 || i == 110) {
            if (this.u[0].mutes) {
               this.u[0].mutes = false;
            } else {
               this.u[0].mutes = true;
            }
         }

         if (i == 97 || i == 65) {
            if (this.u[0].arrace) {
               this.u[0].arrace = false;
            } else {
               this.u[0].arrace = true;
            }
         }

         if (i == 118 || i == 86) {
            this.view++;
            if (this.view == 3) {
               this.view = 0;
            }
         }

         if (i == 115 || i == 100) {
            this.u[0].skey = !this.u[0].skey;
         }
      }

      return false;
   }

   @Override
   public void stop() {
      if (this.getAppletContext() instanceof DesktopContext) {
         this.saveData();
      }
   }

   private void loadData() {
      try {
         this.properties = new HashMap<>();
         File localFile = new File("/files/Nfm2-DSmod/data/user.data");
         if (localFile.exists()) {
            BufferedReader in = new BufferedReader(new FileReader(localFile));

            String str;
            while ((str = in.readLine()) != null) {
               String key = str.substring(0, str.indexOf("("));
               String value = this.getstring(key, str, 0);
               this.properties.put(key, Integer.parseInt(value));
            }

            in.close();
         }

         System.out.println("User data loaded.");
      } catch (Exception var6) {
         System.out.println("Error while loading user data: " + var6.toString());
      }
   }

   private void saveData() {
      try {
         File localFile = new File("/files/Nfm2-DSmod/data/user.data");
         if (!localFile.exists()) {
            localFile.createNewFile();
         }

         PrintWriter out = new PrintWriter(localFile);

         for (Entry<String, Integer> entry : this.properties.entrySet()) {
            out.println(entry.getKey() + "(" + entry.getValue() + ")");
         }

         out.close();
         System.out.println("User data saved.");
      } catch (Exception var5) {
         System.out.println("Error while saving user data: " + var5.toString());
      }
   }

   @Override
   public boolean lostFocus(Event event, Object object) {
      if (!this.exwist && !this.lostfcs) {
         this.lostfcs = true;
         this.mouses = 0;
         this.u[0].falseo();
         this.setCursor(new Cursor(0));
      }

      return false;
   }

   @Override
   public boolean gotFocus(Event event, Object object) {
      if (!this.exwist && this.lostfcs) {
         this.lostfcs = false;
      }

      return false;
   }

   public String getstring(String string, String string_0_, int i) {
      int i_1_ = 0;
      String string_2_ = "";

      for (int i_3_ = string.length() + 1; i_3_ < string_0_.length(); i_3_++) {
         String string_4_ = "" + string_0_.charAt(i_3_);
         if (string_4_.equals(",") || string_4_.equals(")")) {
            i_1_++;
            i_3_++;
         }

         if (i_1_ == i) {
            string_2_ = string_2_ + string_0_.charAt(i_3_);
         }
      }

      return string_2_;
   }

   public int getint(String string, String string_5_, int i) {
      int i_6_ = 0;
      String string_7_ = "";

      for (int i_8_ = string.length() + 1; i_8_ < string_5_.length(); i_8_++) {
         String string_9_ = "" + string_5_.charAt(i_8_);
         if (string_9_.equals(",") || string_9_.equals(")")) {
            i_6_++;
            i_8_++;
         }

         if (i_6_ == i) {
            string_7_ = string_7_ + string_5_.charAt(i_8_);
         }
      }

      return Integer.valueOf(string_7_);
   }

   public int readcookie(String string) {
      int i = -1;
      boolean noCookie = false;

      try {
         JSObject jsobject = JSObject.getWindow(this);
         jsobject.eval("scook=GetCookie('" + string + "');");
         i = Integer.parseInt(String.valueOf(jsobject.getMember("scook")));
      } catch (NoClassDefFoundError var6) {
         noCookie = true;
      } catch (Exception var7) {
         noCookie = true;
      }

      if (noCookie) {
         try {
            if (this.properties == null) {
               return 17;
            }

            if (this.properties.containsKey(string)) {
               i = this.properties.get(string);
            } else {
               i = -1;
            }
         } catch (Exception var5) {
            i = 17;
         }
      }

      return i;
   }

   @Override
   public void paint(Graphics graphics) {
      graphics.drawImage(this.offImage, 0, 0, this);
   }

   public void loadbase(ContO[] contos, Medium medium, Trackers trackers, xtGraphics var_xtGraphics) {
      String[] strings = new String[]{
         "2000tornados",
         "formula7",
         "canyenaro",
         "lescrab",
         "nimi",
         "maxrevenge",
         "leadoxide",
         "firekat",
         "drifter",
         "policecops",
         "mustang",
         "king",
         "audir8",
         "masheen",
         "radicalone",
         "drmonster",
         "road",
         "froad",
         "twister2",
         "twister1",
         "turn",
         "offroad",
         "bumproad",
         "offturn",
         "nroad",
         "nturn",
         "roblend",
         "noblend",
         "rnblend",
         "roadend",
         "offroadend",
         "hpground",
         "ramp30",
         "cramp35",
         "dramp15",
         "dhilo15",
         "slide10",
         "takeoff",
         "sramp22",
         "offbump",
         "offramp",
         "sofframp",
         "halfpipe",
         "spikes",
         "rail",
         "thewall",
         "checkpoint",
         "fixpoint",
         "offcheckpoint",
         "sideoff",
         "bsideoff",
         "uprise",
         "riseroad",
         "sroad",
         "soffroad"
      };
      var_xtGraphics.dnload += 6;

      try {
         URL url = new URL(this.getCodeBase(), "data/models.radq");
         int i35 = url.openConnection().getContentLength();
         if (i35 == -1) {
            i35 = 119879;
         }

         DataInputStream datainputstream = new DataInputStream(url.openStream());
         byte[] arrayOfByte1 = new byte[i35];
         datainputstream.readFully(arrayOfByte1);
         ZipInputStream zipinputstream;
         if (arrayOfByte1[0] == 80 && arrayOfByte1[1] == 75 && arrayOfByte1[2] == 3) {
            zipinputstream = new ZipInputStream(new ByteArrayInputStream(arrayOfByte1));
         } else {
            for (int i40 = 0; i40 < i35; i40++) {
               if (arrayOfByte1[i40] == 75) {
                  arrayOfByte1[i40] = 85;
               } else if (arrayOfByte1[i40] == 15) {
                  arrayOfByte1[i40] = 45;
               } else if (arrayOfByte1[i40] == 25) {
                  arrayOfByte1[i40] = 55;
               } else if (arrayOfByte1[i40] == 35) {
                  arrayOfByte1[i40] = 65;
               } else if (arrayOfByte1[i40] == 45) {
                  arrayOfByte1[i40] = 15;
               } else if (arrayOfByte1[i40] == 55) {
                  arrayOfByte1[i40] = 25;
               } else if (arrayOfByte1[i40] == 65) {
                  arrayOfByte1[i40] = 35;
               } else if (arrayOfByte1[i40] == 85) {
                  arrayOfByte1[i40] = 75;
               }
            }

            zipinputstream = new ZipInputStream(new ByteArrayInputStream(arrayOfByte1));
         }

         ZipEntry zipentry = zipinputstream.getNextEntry();

         for (Object object = null; zipentry != null; zipentry = zipinputstream.getNextEntry()) {
            int i = 0;
            int i_10_ = 0;

            do {
               if (zipentry.getName().startsWith(strings[i_10_])) {
                  i = i_10_;
               }
            } while (++i_10_ < 55);

            i_10_ = (int)zipentry.getSize();
            byte[] is = new byte[i_10_];
            int i_11_ = 0;

            while (i_10_ > 0) {
               int i_12_ = zipinputstream.read(is, i_11_, i_10_);
               i_11_ += i_12_;
               i_10_ -= i_12_;
            }

            contos[i] = new ContO(is, medium, trackers);
            var_xtGraphics.dnload++;
         }

         datainputstream.close();
         zipinputstream.close();
      } catch (Exception var18) {
         System.out.println("Error Reading Models: " + var18);
      }

      System.gc();
   }

   @Override
   public void update(Graphics graphics) {
      this.paint(graphics);
   }

   public int sunytyp() {
      String string = System.getProperty("java.version");
      String string_13_ = "" + this.getAppletContext();
      if (!string_13_.startsWith("com.ms.")) {
         return !string.startsWith("1.3") && !string.startsWith("1.4") ? 2 : 1;
      } else {
         return 0;
      }
   }

   @Override
   public boolean keyUp(Event event, int i) {
      if (!this.exwist) {
         if (i == 1004) {
            this.u[0].up = false;
         }

         if (i == 1005) {
            this.u[0].down = false;
         }

         if (i == 1007) {
            this.u[0].right = false;
         }

         if (i == 1006) {
            this.u[0].left = false;
         }

         if (i == 32) {
            this.u[0].handb = false;
         }

         if (i == 120 || i == 88 || i == 122 || i == 90) {
            this.u[0].lookback = 0;
         }
      }

      return false;
   }

   @Override
   public void start() {
      if (this.gamer == null) {
         this.gamer = new Thread(this);
         this.gamer.start();
      }
   }

   @Override
   public boolean mouseDown(Event event, int i, int i_14_) {
      if (!this.exwist && this.mouses == 0) {
         this.xm = i;
         this.ym = i_14_;
         this.mouses = 1;
      }

      return false;
   }

   public void loadstage(
      ContO[] contos,
      ContO[] contos_15_,
      Medium medium,
      Trackers trackers,
      CheckPoints checkpoints,
      xtGraphics var_xtGraphics,
      Madness[] madnesses,
      Record record
   ) {
      trackers.nt = 0;
      this.nob = 7;
      this.notb = 0;
      checkpoints.n = 0;
      checkpoints.nsp = 0;
      checkpoints.fn = 0;
      checkpoints.haltall = false;
      checkpoints.wasted = 0;
      checkpoints.catchfin = 0;
      medium.lightson = false;
      medium.ground = 250;
      this.view = 0;
      int i = 0;
      int i_16_ = 100;
      int i_17_ = 0;
      int i_18_ = 100;
      if (!trackers.tracksReady) {
         this.TracksSetup(trackers);
      }

      String string = "";

      try {
         URL url = new URL(this.getCodeBase(), "tracks/" + checkpoints.stage + ".txt");
         DataInputStream datainputstream = new DataInputStream(url.openStream());

         String string_19_;
         while ((string_19_ = datainputstream.readLine()) != null) {
            string = "" + string_19_.trim();
            if (string.startsWith("snap")) {
               medium.setsnap(this.getint("snap", string, 0), this.getint("snap", string, 1), this.getint("snap", string, 2));
            }

            if (string.startsWith("sky")) {
               medium.setsky(this.getint("sky", string, 0), this.getint("sky", string, 1), this.getint("sky", string, 2));
               var_xtGraphics.snap(checkpoints.stage);
            }

            if (string.startsWith("ground")) {
               medium.setgrnd(this.getint("ground", string, 0), this.getint("ground", string, 1), this.getint("ground", string, 2));
            }

            if (string.startsWith("polys")) {
               medium.setpolys(this.getint("polys", string, 0), this.getint("polys", string, 1), this.getint("polys", string, 2));
            }

            if (string.startsWith("fog")) {
               medium.setfade(this.getint("fog", string, 0), this.getint("fog", string, 1), this.getint("fog", string, 2));
            }

            if (string.startsWith("density")) {
               medium.fogd = this.getint("density", string, 0);
            }

            if (string.startsWith("fadefrom")) {
               medium.fadfrom(this.getint("fadefrom", string, 0));
               medium.origfade = medium.fade[0];
            }

            if (string.startsWith("lightson")) {
               medium.lightson = true;
            }

            if (string.startsWith("set")) {
               try {
                  int i_20_ = this.getint("set", string, 0);
                  i_20_ += 6;
                  contos[this.nob] = new ContO(
                     contos_15_[i_20_],
                     this.getint("set", string, 1),
                     this.getint("set", string, 3),
                     this.getint("set", string, 2),
                     this.getint("set", string, 4)
                  );
                  if (string.indexOf(")p") != -1) {
                     checkpoints.x[checkpoints.n] = this.getint("chk", string, 1);
                     checkpoints.z[checkpoints.n] = this.getint("chk", string, 2);
                     checkpoints.y[checkpoints.n] = this.getint("chk", string, 3);
                     checkpoints.typ[checkpoints.n] = 0;
                     if (string.indexOf(")pt") != -1) {
                        checkpoints.typ[checkpoints.n] = -1;
                     }

                     if (string.indexOf(")pr") != -1) {
                        checkpoints.typ[checkpoints.n] = -2;
                     }

                     if (string.indexOf(")po") != -1) {
                        checkpoints.typ[checkpoints.n] = -3;
                     }

                     if (string.indexOf(")ph") != -1) {
                        checkpoints.typ[checkpoints.n] = -4;
                     }

                     if (string.indexOf("out") != -1) {
                        System.out.println("out: " + checkpoints.n);
                     }

                     checkpoints.n++;
                     this.notb = this.nob + 1;
                  }

                  this.nob++;
               } catch (Exception var21) {
                  int i_20_ = this.getint("set", string, 0);
                  i_20_ += 6;
                  contos[this.nob] = new ContO(
                     contos_15_[i_20_],
                     this.getint("set", string, 1),
                     medium.ground - contos_15_[i_20_].grat,
                     this.getint("set", string, 2),
                     this.getint("set", string, 3)
                  );
                  if (string.indexOf(")p") != -1) {
                     checkpoints.x[checkpoints.n] = this.getint("chk", string, 1);
                     checkpoints.z[checkpoints.n] = this.getint("chk", string, 2);
                     checkpoints.y[checkpoints.n] = 0;
                     checkpoints.typ[checkpoints.n] = 0;
                     if (string.indexOf(")pt") != -1) {
                        checkpoints.typ[checkpoints.n] = -1;
                     }

                     if (string.indexOf(")pr") != -1) {
                        checkpoints.typ[checkpoints.n] = -2;
                     }

                     if (string.indexOf(")po") != -1) {
                        checkpoints.typ[checkpoints.n] = -3;
                     }

                     if (string.indexOf(")ph") != -1) {
                        checkpoints.typ[checkpoints.n] = -4;
                     }

                     if (string.indexOf("out") != -1) {
                        System.out.println("out: " + checkpoints.n);
                     }

                     checkpoints.n++;
                     this.notb = this.nob + 1;
                  }

                  this.nob++;
               }
            }

            if (string.startsWith("chk")) {
               try {
                  int i_21_ = this.getint("chk", string, 0);
                  i_21_ += 6;
                  contos[this.nob] = new ContO(
                     contos_15_[i_21_],
                     this.getint("set", string, 1),
                     this.getint("set", string, 3),
                     this.getint("set", string, 2),
                     this.getint("set", string, 4)
                  );
                  checkpoints.x[checkpoints.n] = this.getint("chk", string, 1);
                  checkpoints.z[checkpoints.n] = this.getint("chk", string, 2);
                  checkpoints.y[checkpoints.n] = this.getint("chk", string, 3);
                  if (this.getint("chk", string, 3) == 0) {
                     checkpoints.typ[checkpoints.n] = 1;
                  } else {
                     checkpoints.typ[checkpoints.n] = 2;
                  }

                  checkpoints.pcs = checkpoints.n++;
                  contos[this.nob].checkpoint = checkpoints.nsp + 1;
                  checkpoints.nsp++;
                  this.nob++;
                  this.notb = this.nob;
               } catch (Exception var22) {
                  int i_21_ = this.getint("chk", string, 0);
                  i_21_ += 6;
                  contos[this.nob] = new ContO(
                     contos_15_[i_21_],
                     this.getint("chk", string, 1),
                     medium.ground - contos_15_[i_21_].grat,
                     this.getint("chk", string, 2),
                     this.getint("chk", string, 3)
                  );
                  checkpoints.x[checkpoints.n] = this.getint("chk", string, 1);
                  checkpoints.z[checkpoints.n] = this.getint("chk", string, 2);
                  checkpoints.y[checkpoints.n] = medium.ground - contos_15_[i_21_].grat;
                  if (this.getint("chk", string, 3) == 0) {
                     checkpoints.typ[checkpoints.n] = 1;
                  } else {
                     checkpoints.typ[checkpoints.n] = 2;
                  }

                  checkpoints.pcs = checkpoints.n++;
                  contos[this.nob].checkpoint = checkpoints.nsp + 1;
                  checkpoints.nsp++;
                  this.nob++;
                  this.notb = this.nob;
               }
            }

            if (string.startsWith("fix")) {
               int i_22_ = this.getint("fix", string, 0);
               i_22_ += 6;
               contos[this.nob] = new ContO(
                  contos_15_[i_22_], this.getint("fix", string, 1), this.getint("fix", string, 3), this.getint("fix", string, 2), this.getint("fix", string, 4)
               );
               checkpoints.fx[checkpoints.fn] = this.getint("fix", string, 1);
               checkpoints.fz[checkpoints.fn] = this.getint("fix", string, 2);
               checkpoints.fy[checkpoints.fn] = this.getint("fix", string, 3);
               contos[this.nob].elec = true;
               if (this.getint("fix", string, 4) != 0) {
                  checkpoints.roted[checkpoints.fn] = true;
                  contos[this.nob].roted = true;
               } else {
                  checkpoints.roted[checkpoints.fn] = false;
               }

               if (string.indexOf(")s") != -1) {
                  checkpoints.special[checkpoints.fn] = true;
               } else {
                  checkpoints.special[checkpoints.fn] = false;
               }

               checkpoints.fn++;
               this.nob++;
               this.notb = this.nob;
            }

            if (string.startsWith("nlaps")) {
               checkpoints.nlaps = this.getint("nlaps", string, 0);
            }

            if (string.startsWith("name")) {
               checkpoints.name = this.getstring("name", string, 0).replace('|', ',');
            }

            if (string.startsWith("maxr")) {
               int i_23_ = this.getint("maxr", string, 0);
               int i_24_ = this.getint("maxr", string, 1);
               i = i_24_;
               int i_25_ = this.getint("maxr", string, 2);

               for (int i_26_ = 0; i_26_ < i_23_; i_26_++) {
                  contos[this.nob] = new ContO(contos_15_[45], i_24_, medium.ground - contos_15_[45].grat, i_26_ * 4800 + i_25_, 0);
                  this.nob++;
               }

               trackers.y[trackers.nt] = -5000;
               trackers.rady[trackers.nt] = 7100;
               trackers.x[trackers.nt] = i_24_ + 500;
               trackers.radx[trackers.nt] = 600;
               trackers.z[trackers.nt] = i_23_ * 4800 / 2 + i_25_ - 2400;
               trackers.radz[trackers.nt] = i_23_ * 4800 / 2;
               trackers.xy[trackers.nt] = 90;
               trackers.zy[trackers.nt] = 0;
               trackers.dam[trackers.nt] = 1;
               trackers.nt++;
            }

            if (string.startsWith("maxl")) {
               int i_27_ = this.getint("maxl", string, 0);
               int i_28_ = this.getint("maxl", string, 1);
               i_16_ = i_28_;
               int i_29_ = this.getint("maxl", string, 2);

               for (int i_30_ = 0; i_30_ < i_27_; i_30_++) {
                  contos[this.nob] = new ContO(contos_15_[45], i_28_, medium.ground - contos_15_[45].grat, i_30_ * 4800 + i_29_, 0);
                  this.nob++;
               }

               trackers.y[trackers.nt] = -5000;
               trackers.rady[trackers.nt] = 7100;
               trackers.x[trackers.nt] = i_28_ - 500;
               trackers.radx[trackers.nt] = 600;
               trackers.z[trackers.nt] = i_27_ * 4800 / 2 + i_29_ - 2400;
               trackers.radz[trackers.nt] = i_27_ * 4800 / 2;
               trackers.xy[trackers.nt] = -90;
               trackers.zy[trackers.nt] = 0;
               trackers.dam[trackers.nt] = 1;
               trackers.nt++;
            }

            if (string.startsWith("maxt")) {
               int i_31_ = this.getint("maxt", string, 0);
               int i_32_ = this.getint("maxt", string, 1);
               i_17_ = i_32_;
               int i_33_ = this.getint("maxt", string, 2);

               for (int i_34_ = 0; i_34_ < i_31_; i_34_++) {
                  contos[this.nob] = new ContO(contos_15_[45], i_34_ * 4800 + i_33_, medium.ground - contos_15_[45].grat, i_32_, 90);
                  this.nob++;
               }

               trackers.y[trackers.nt] = -5000;
               trackers.rady[trackers.nt] = 7100;
               trackers.z[trackers.nt] = i_32_ + 500;
               trackers.radz[trackers.nt] = 600;
               trackers.x[trackers.nt] = i_31_ * 4800 / 2 + i_33_ - 2400;
               trackers.radx[trackers.nt] = i_31_ * 4800 / 2;
               trackers.zy[trackers.nt] = 90;
               trackers.xy[trackers.nt] = 0;
               trackers.dam[trackers.nt] = 1;
               trackers.nt++;
            }

            if (string.startsWith("maxb")) {
               int i_35_ = this.getint("maxb", string, 0);
               int i_36_ = this.getint("maxb", string, 1);
               i_18_ = i_36_;
               int i_37_ = this.getint("maxb", string, 2);

               for (int i_38_ = 0; i_38_ < i_35_; i_38_++) {
                  contos[this.nob] = new ContO(contos_15_[45], i_38_ * 4800 + i_37_, medium.ground - contos_15_[45].grat, i_36_, 90);
                  this.nob++;
               }

               trackers.y[trackers.nt] = -5000;
               trackers.rady[trackers.nt] = 7100;
               trackers.z[trackers.nt] = i_36_ - 500;
               trackers.radz[trackers.nt] = 600;
               trackers.x[trackers.nt] = i_35_ * 4800 / 2 + i_37_ - 2400;
               trackers.radx[trackers.nt] = i_35_ * 4800 / 2;
               trackers.zy[trackers.nt] = -90;
               trackers.xy[trackers.nt] = 0;
               trackers.dam[trackers.nt] = 1;
               trackers.nt++;
            }
         }

         datainputstream.close();
      } catch (Exception var23) {
         var_xtGraphics.fase = 3;
         System.out.println("Error in stage " + checkpoints.stage);
         System.out.println("" + var23);
         System.out.println("At line: " + string);
      }

      if (checkpoints.stage == 16) {
         medium.lightn = 0;
      } else {
         medium.lightn = -1;
      }

      if (checkpoints.stage == 1) {
         medium.nochekflk = false;
      } else {
         medium.nochekflk = true;
      }

      medium.newpolys(i_16_, i - i_16_, i_18_, i_17_ - i_18_, trackers);
      if (var_xtGraphics.fase == 2) {
         medium.trx = 0L;
         medium.trz = 0L;
         if (trackers.nt >= 4) {
            int i_39_ = 4;

            do {
               medium.trx = medium.trx + trackers.x[trackers.nt - i_39_];
               medium.trz = medium.trz + trackers.z[trackers.nt - i_39_];
            } while (--i_39_ > 0);
         }

         medium.trx /= 4L;
         medium.trz /= 4L;
         medium.ptr = 0;
         medium.ptcnt = -10;
         medium.hit = 45000;
         medium.fallen = 0;
         medium.nrnd = 0;
         medium.trk = true;
         var_xtGraphics.fase = 1;
         this.mouses = 0;
      }

      int i_40_ = 0;

      do {
         this.u[i_40_].reset(checkpoints, var_xtGraphics.sc[i_40_]);
      } while (++i_40_ < 7);

      var_xtGraphics.resetstat(checkpoints.stage);
      i_40_ = 0;

      do {
         contos[i_40_] = new ContO(
            contos_15_[var_xtGraphics.sc[i_40_]],
            var_xtGraphics.xstart[i_40_],
            250 - contos_15_[var_xtGraphics.sc[i_40_]].grat,
            var_xtGraphics.zstart[i_40_],
            0
         );
         madnesses[i_40_].reseto(var_xtGraphics.sc[i_40_], contos[i_40_], checkpoints);
      } while (++i_40_ < 7);

      record.reset(contos);
      System.gc();
   }

   public void TracksSetup(Trackers trackers) {
      try {
         JSObject jsobject = JSObject.getWindow(this);
         trackers.tracksReady = false;
         jsobject.eval("var strtp=''+top.location;");
         String string = String.valueOf(jsobject.getMember("strtp"));
//         int i = 0;
//         if (string.startsWith(trackers.sequ[1].substring(34, 40))) {
//            for (; i < string.length() - 1; i++) {
//               if (string.startsWith("dscore.webcindario.com", i) && trackers.sequ[2].length() == 43) {
                  trackers.tracksReady = true;
//               }
//            }
//         } else {
//            trackers.tracksReady = true;
//         }

         if (!trackers.tracksReady) {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.fillRect(0, 0, 670, 400);
            this.rd.setColor(new Color(255, 255, 255));
            this.rd.drawString(trackers.sequ[0], 30, 50);
            this.rd.drawString(trackers.sequ[1], 30, 100);
            this.rd.drawString("" + string, 30, 120);
            this.rd.drawString(trackers.sequ[2], 30, 200);
            this.repaint();
            jsobject.eval("window.open('http://www.radicalplay.com/madness/','_blank','menubar=1,toolbar=1,location=1,resizable=1,status=1,scrollbars=1');");
            this.gamer.stop();
         }
      } catch (NoClassDefFoundError var8) {
         trackers.tracksReady = false;
         String stringx = "" + this.getDocumentBase();
         int ix = 0;
         if (stringx.startsWith(trackers.sequ[1].substring(34, 40))) {
            for (; ix < stringx.length() - 1; ix++) {
               if (stringx.startsWith("dscore.webcindario.com", ix) && trackers.sequ[2].length() == 43) {
                  trackers.tracksReady = true;
               }
            }
         } else {
            trackers.tracksReady = true;
         }

         if (!trackers.tracksReady) {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.fillRect(0, 0, 670, 400);
            this.rd.setColor(new Color(255, 255, 255));
            this.rd.drawString(trackers.sequ[0], 30, 50);
            this.rd.drawString(trackers.sequ[1], 30, 100);
            this.rd.drawString("" + stringx, 30, 120);
            this.rd.drawString(trackers.sequ[2], 30, 200);
            this.repaint();

            try {
               URL url = new URL("http://www.radicalplay.com/madness/");
               this.getAppletContext().showDocument(url, "_blank");
            } catch (Exception var7) {
            }

            this.gamer.stop();
         }
      } catch (Exception var9) {
         trackers.tracksReady = false;
         String stringxx = "" + this.getDocumentBase();
         int ixx = 0;
         if (stringxx.startsWith(trackers.sequ[1].substring(34, 40))) {
            for (; ixx < stringxx.length() - 1; ixx++) {
               if (stringxx.startsWith("dscore.webcindario.com", ixx) && trackers.sequ[2].length() == 43) {
                  trackers.tracksReady = true;
               }
            }
         } else {
            trackers.tracksReady = true;
         }

         if (!trackers.tracksReady) {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.fillRect(0, 0, 670, 400);
            this.rd.setColor(new Color(255, 255, 255));
            this.rd.drawString(trackers.sequ[0], 30, 50);
            this.rd.drawString(trackers.sequ[1], 30, 100);
            this.rd.drawString("" + stringxx, 30, 120);
            this.rd.drawString(trackers.sequ[2], 30, 200);
            this.repaint();

            try {
               URL url = new URL("http://www.radicalplay.com/madness/");
               this.getAppletContext().showDocument(url, "_blank");
            } catch (Exception var6) {
            }

            this.gamer.stop();
         }
      }
   }

   @Override
   public void run() {
      this.rd.setColor(new Color(0, 0, 0));
      this.rd.fillRect(0, 0, 670, 400);
      this.repaint();
      Trackers trackers = new Trackers();
      this.TracksSetup(trackers);
      Medium medium = new Medium();
      int i = 5;
      int i_42_ = 530;
      int i_43_ = this.sunytyp();
      if (i_43_ != 0) {
         i = 15;
      }

      if (i_43_ != 2) {
         i_42_ = 500;
      }

      CheckPoints checkpoints = new CheckPoints();
      xtGraphics var_xtGraphics = new xtGraphics(medium, this.rd, this);
      var_xtGraphics.loaddata(i_43_);
      Record record = new Record(medium);
      ContO[] contos = new ContO[55];
      this.loadbase(contos, medium, trackers, var_xtGraphics);
      ContO[] contos_44_ = new ContO[330];
      Madness[] madnesses = new Madness[7];
      int i_45_ = 0;

      do {
         madnesses[i_45_] = new Madness(medium, record, var_xtGraphics, i_45_);
         this.u[i_45_] = new Control(medium);
      } while (++i_45_ < 7);

      boolean bool = false;
      float f = 35.0F;
      int i_46_ = 80;
      i_45_ = this.readcookie("unlocked");
      if (i_45_ >= 1 && i_45_ <= 17) {
         var_xtGraphics.unlocked = i_45_;
         if (var_xtGraphics.unlocked != 17) {
            checkpoints.stage = var_xtGraphics.unlocked;
         } else {
            checkpoints.stage = (int)(Math.random() * 17.0) + 1;
         }

         var_xtGraphics.opselect = 0;
      }

      i_45_ = this.readcookie("usercar");
      if (i_45_ >= 0 && i_45_ <= 15) {
         var_xtGraphics.sc[0] = i_45_;
      }

      i_45_ = this.readcookie("gameprfact");
      if (i_45_ != -1) {
         f = this.readcookie("gameprfact");
         i_46_ = 0;
      }

      bool = false;
      var_xtGraphics.stoploading();
      System.gc();
      Date date = new Date();
      long l = 0L;
      long l_47_ = date.getTime();
      float f_48_ = 30.0F;
      boolean bool_49_ = false;
      int i_50_ = 0;
      int i_51_ = 0;
      int i_52_ = 0;
      int i_53_ = 0;
      int i_54_ = 0;
      boolean bool_55_ = false;
      this.exwist = false;

      while (true) {
         mads = madnesses;
         date = new Date();
         long l_56_ = date.getTime();
         if (var_xtGraphics.fase == 111) {
            if (this.mouses == 1) {
               i_52_ = 800;
            }

            if (i_52_ < 800) {
               var_xtGraphics.clicknow();
               i_52_++;
            } else {
               i_52_ = 0;
               var_xtGraphics.spl = 0;
               var_xtGraphics.fase = 9;
               this.mouses = 0;
               this.lostfcs = false;
            }
         }

         if (var_xtGraphics.fase == 9) {
            if (var_xtGraphics.spl >= 0 && var_xtGraphics.spl < 100) {
               var_xtGraphics.showSplash();
               var_xtGraphics.spl++;
            } else if (i_52_ < 200) {
               var_xtGraphics.rad(i_52_);
               this.catchlink(0);
               if (this.mouses == 2) {
                  this.mouses = 0;
               }

               if (this.mouses == 1) {
                  this.mouses = 2;
               }

               i_52_++;
            } else {
               i_52_ = 0;
               var_xtGraphics.fase = 10;
               this.mouses = 0;
               this.u[0].falseo();
            }
         }

         if (var_xtGraphics.fase == -9) {
            if (i_52_ < 2) {
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.fillRect(0, 0, 670, 400);
               i_52_++;
            } else {
               var_xtGraphics.inishcarselect();
               i_52_ = 0;
               var_xtGraphics.fase = 7;
               this.mouses = 0;
            }
         }

         if (var_xtGraphics.fase == 8) {
            if (var_xtGraphics.spl >= 0 && var_xtGraphics.spl < 100) {
               var_xtGraphics.showSplash();
               var_xtGraphics.spl++;
            } else {
               var_xtGraphics.credits(this.u[0]);
               var_xtGraphics.ctachm(this.xm, this.ym, this.mouses, this.u[0]);
               if (var_xtGraphics.flipo <= 100) {
                  this.catchlink(0);
               }

               if (this.mouses == 2) {
                  this.mouses = 0;
               }

               if (this.mouses == 1) {
                  this.mouses = 2;
               }
            }
         }

         if (var_xtGraphics.fase == 10) {
            var_xtGraphics.maini(this.u[0]);
            var_xtGraphics.ctachm(this.xm, this.ym, this.mouses, this.u[0]);
            if (this.mouses == 2) {
               this.mouses = 0;
            }

            if (this.mouses == 1) {
               this.mouses = 2;
            }
         }

         if (var_xtGraphics.fase == 11) {
            var_xtGraphics.inst(this.u[0]);
            var_xtGraphics.ctachm(this.xm, this.ym, this.mouses, this.u[0]);
            if (this.mouses == 2) {
               this.mouses = 0;
            }

            if (this.mouses == 1) {
               this.mouses = 2;
            }
         }

         if (var_xtGraphics.fase == -5) {
            var_xtGraphics.finish(checkpoints, contos, this.u[0]);
            if (bool) {
               if (checkpoints.stage == var_xtGraphics.unlocked && var_xtGraphics.winner && var_xtGraphics.unlocked != 17) {
                  this.savecookie("unlocked", "" + (var_xtGraphics.unlocked + 1));
               }

               this.savecookie("gameprfact", "" + (int)f);
               this.savecookie("usercar", "" + var_xtGraphics.sc[0]);
               bool = false;
            }

            var_xtGraphics.ctachm(this.xm, this.ym, this.mouses, this.u[0]);
            if (checkpoints.stage == 17 && var_xtGraphics.winner) {
               this.catchlink(1);
            }

            if (this.mouses == 2) {
               this.mouses = 0;
            }

            if (this.mouses == 1) {
               this.mouses = 2;
            }
         }

         if (var_xtGraphics.fase == 7) {
            var_xtGraphics.carselect(this.u[0], contos, madnesses[0]);
            var_xtGraphics.ctachm(this.xm, this.ym, this.mouses, this.u[0]);
            if (this.mouses == 2) {
               this.mouses = 0;
            }

            if (this.mouses == 1) {
               this.mouses = 2;
            }
         }

         if (var_xtGraphics.fase == 6) {
            var_xtGraphics.musicomp(checkpoints.stage, this.u[0]);
            var_xtGraphics.ctachm(this.xm, this.ym, this.mouses, this.u[0]);
            if (this.mouses == 2) {
               this.mouses = 0;
            }

            if (this.mouses == 1) {
               this.mouses = 2;
            }
         }

         if (var_xtGraphics.fase == 5) {
            var_xtGraphics.loadmusic(checkpoints.stage, i_46_);
            if (!bool) {
               this.savecookie("usercar", "" + var_xtGraphics.sc[0]);
               bool = true;
            }
         }

         if (var_xtGraphics.fase == 4) {
            var_xtGraphics.cantgo(this.u[0]);
            var_xtGraphics.ctachm(this.xm, this.ym, this.mouses, this.u[0]);
            if (this.mouses == 2) {
               this.mouses = 0;
            }

            if (this.mouses == 1) {
               this.mouses = 2;
            }
         }

         if (var_xtGraphics.fase == 3) {
            var_xtGraphics.loadingfailed(checkpoints, this.u[0]);
            var_xtGraphics.ctachm(this.xm, this.ym, this.mouses, this.u[0]);
            if (this.mouses == 2) {
               this.mouses = 0;
            }

            if (this.mouses == 1) {
               this.mouses = 2;
            }
         }

         if (var_xtGraphics.fase == 2) {
            var_xtGraphics.loadingstage(checkpoints.stage);
            this.loadstage(contos_44_, contos, medium, trackers, checkpoints, var_xtGraphics, madnesses, record);
            this.u[0].falseo();
         }

         if (var_xtGraphics.fase == 1) {
            var_xtGraphics.trackbg(false);
            medium.aroundtrack(checkpoints);
            int i_57_ = 0;
            int[] is = new int[200];

            for (int i_58_ = 7; i_58_ < this.notb; i_58_++) {
               if (contos_44_[i_58_].dist != 0) {
                  is[i_57_] = i_58_;
                  i_57_++;
               } else {
                  contos_44_[i_58_].d(this.rd);
               }
            }

            int[] is_59_ = new int[i_57_];

            for (int i_60_ = 0; i_60_ < i_57_; i_60_++) {
               is_59_[i_60_] = 0;
            }

            for (int i_61_ = 0; i_61_ < i_57_; i_61_++) {
               for (int i_62_ = i_61_ + 1; i_62_ < i_57_; i_62_++) {
                  if (contos_44_[is[i_61_]].dist != contos_44_[is[i_62_]].dist) {
                     if (contos_44_[is[i_61_]].dist < contos_44_[is[i_62_]].dist) {
                        is_59_[i_61_]++;
                     } else {
                        is_59_[i_62_]++;
                     }
                  } else if (i_62_ > i_61_) {
                     is_59_[i_61_]++;
                  } else {
                     is_59_[i_62_]++;
                  }
               }
            }

            for (int i_63_ = 0; i_63_ < i_57_; i_63_++) {
               for (int i_64_ = 0; i_64_ < i_57_; i_64_++) {
                  if (is_59_[i_64_] == i_63_) {
                     contos_44_[is[i_64_]].d(this.rd);
                  }
               }
            }

            var_xtGraphics.ctachm(this.xm, this.ym, this.mouses, this.u[0]);
            if (this.mouses == 2) {
               this.mouses = 0;
            }

            if (this.mouses == 1) {
               this.mouses = 2;
            }

            var_xtGraphics.stageselect(checkpoints, this.u[0]);
         }

         if (var_xtGraphics.fase == 176) {
            medium.d(this.rd);
            int i_65_ = 0;
            int[] is = new int[200];

            for (int i_66_ = 0; i_66_ < this.nob; i_66_++) {
               if (contos_44_[i_66_].dist != 0) {
                  is[i_65_] = i_66_;
                  i_65_++;
               } else {
                  contos_44_[i_66_].d(this.rd);
               }
            }

            int[] is_67_ = new int[i_65_];

            for (int i_68_ = 0; i_68_ < i_65_; i_68_++) {
               is_67_[i_68_] = 0;
            }

            for (int i_69_ = 0; i_69_ < i_65_; i_69_++) {
               for (int i_70_ = i_69_ + 1; i_70_ < i_65_; i_70_++) {
                  if (contos_44_[is[i_69_]].dist != contos_44_[is[i_70_]].dist) {
                     if (contos_44_[is[i_69_]].dist < contos_44_[is[i_70_]].dist) {
                        is_67_[i_69_]++;
                     } else {
                        is_67_[i_70_]++;
                     }
                  } else if (i_70_ > i_69_) {
                     is_67_[i_69_]++;
                  } else {
                     is_67_[i_70_]++;
                  }
               }
            }

            for (int i_71_ = 0; i_71_ < i_65_; i_71_++) {
               for (int i_72_ = 0; i_72_ < i_65_; i_72_++) {
                  if (is_67_[i_72_] == i_71_) {
                     contos_44_[is[i_72_]].d(this.rd);
                  }
               }
            }

            medium.follow(contos_44_[0], 0, 0);
            var_xtGraphics.hipnoload(checkpoints.stage, false);
            if (i_46_ != 0) {
               i_46_--;
            } else {
               this.u[0].enter = false;
               this.u[0].handb = false;
               if (var_xtGraphics.loadedt[checkpoints.stage - 1]) {
                  var_xtGraphics.stracks[checkpoints.stage - 1].play();
               }

               this.setCursor(new Cursor(0));
               var_xtGraphics.fase = 6;
            }
         }

         if (var_xtGraphics.fase == 0) {
            int i_73_ = 0;

            do {
               if (madnesses[i_73_].newcar) {
                  int i_74_ = contos_44_[i_73_].xz;
                  int i_75_ = contos_44_[i_73_].xy;
                  int i_76_ = contos_44_[i_73_].zy;
                  contos_44_[i_73_] = new ContO(contos[madnesses[i_73_].cn], contos_44_[i_73_].x, contos_44_[i_73_].y, contos_44_[i_73_].z, 0);
                  contos_44_[i_73_].xz = i_74_;
                  contos_44_[i_73_].xy = i_75_;
                  contos_44_[i_73_].zy = i_76_;
                  madnesses[i_73_].newcar = false;
               }
            } while (++i_73_ < 7);

            medium.d(this.rd);
            i_73_ = 0;
            int[] is = new int[200];

            for (int i_77_ = 0; i_77_ < this.nob; i_77_++) {
               if (contos_44_[i_77_].dist != 0) {
                  is[i_73_] = i_77_;
                  i_73_++;
               } else {
                  contos_44_[i_77_].d(this.rd);
               }
            }

            int[] is_78_ = new int[i_73_];
            int[] is_79_ = new int[i_73_];

            for (int i_80_ = 0; i_80_ < i_73_; i_80_++) {
               is_78_[i_80_] = 0;
            }

            for (int i_81_ = 0; i_81_ < i_73_; is_79_[is_78_[i_81_]] = i_81_++) {
               for (int i_82_ = i_81_ + 1; i_82_ < i_73_; i_82_++) {
                  if (contos_44_[is[i_81_]].dist != contos_44_[is[i_82_]].dist) {
                     if (contos_44_[is[i_81_]].dist < contos_44_[is[i_82_]].dist) {
                        is_78_[i_81_]++;
                     } else {
                        is_78_[i_82_]++;
                     }
                  } else if (i_82_ > i_81_) {
                     is_78_[i_81_]++;
                  } else {
                     is_78_[i_82_]++;
                  }
               }
            }

            for (int i_83_ = 0; i_83_ < i_73_; i_83_++) {
               contos_44_[is[is_79_[i_83_]]].d(this.rd);
            }

            if (var_xtGraphics.starcnt == 0) {
               int i_84_ = 0;

               do {
                  int i_85_ = 0;

                  do {
                     if (i_85_ != i_84_) {
                        madnesses[i_84_].colide(contos_44_[i_84_], madnesses[i_85_], contos_44_[i_85_]);
                     }
                  } while (++i_85_ < 7);
               } while (++i_84_ < 7);

               i_84_ = 0;

               do {
                  madnesses[i_84_].drive(this.u[i_84_], contos_44_[i_84_], trackers, checkpoints);
               } while (++i_84_ < 7);

               i_84_ = 0;

               do {
                  record.rec(contos_44_[i_84_], i_84_, madnesses[i_84_].squash, madnesses[i_84_].lastcolido, madnesses[i_84_].cntdest);
               } while (++i_84_ < 7);

               checkpoints.checkstat(madnesses, contos_44_, record);
               i_84_ = 1;

               do {
                  this.u[i_84_].preform(madnesses[i_84_], contos_44_[i_84_], checkpoints, trackers);
               } while (++i_84_ < 7);
            } else {
               if (var_xtGraphics.starcnt == 130) {
                  medium.bcxz = -180;
                  medium.adv = 1900;
                  medium.zy = 40;
                  medium.vxz = 70;
                  this.rd.setColor(new Color(255, 255, 255));
                  this.rd.fillRect(0, 0, 670, 400);
               }

               if (var_xtGraphics.starcnt != 0) {
                  var_xtGraphics.starcnt += -1;
               }
            }

            if (var_xtGraphics.starcnt < 38) {
               if (this.view == 0) {
                  medium.follow(contos_44_[0], madnesses[0].cxz, this.u[0].lookback);
                  var_xtGraphics.stat(madnesses[0], checkpoints, this.u[0], true);
               }

               if (this.view == 1) {
                  medium.around(contos_44_[0], false);
                  var_xtGraphics.stat(madnesses[0], checkpoints, this.u[0], false);
               }

               if (this.view == 2) {
                  medium.watch(contos_44_[0], madnesses[0].mxz);
                  var_xtGraphics.stat(madnesses[0], checkpoints, this.u[0], false);
               }

               if (this.mouses == 1) {
                  this.u[0].enter = true;
                  this.mouses = 0;
               }

               if (var_xtGraphics.starcnt == 36) {
                  this.repaint();
               }
            } else {
               medium.around(contos_44_[3], true);
               if (this.u[0].enter || this.u[0].handb) {
                  var_xtGraphics.starcnt = 38;
                  this.u[0].enter = false;
                  this.u[0].handb = false;
               }

               if (var_xtGraphics.starcnt == 38) {
                  this.mouses = 0;
                  medium.vert = false;
                  medium.adv = 900;
                  medium.vxz = 180;
                  checkpoints.checkstat(madnesses, contos_44_, record);
                  medium.follow(contos_44_[0], madnesses[0].cxz, 0);
                  var_xtGraphics.stat(madnesses[0], checkpoints, this.u[0], true);
                  this.rd.setColor(new Color(255, 255, 255));
                  this.rd.fillRect(0, 0, 670, 400);
               }
            }
         }

         if (var_xtGraphics.fase == -1) {
            if (i_51_ == 0) {
               int i_86_ = 0;

               do {
                  record.ocar[i_86_] = contos_44_[i_86_];
                  contos_44_[i_86_] = new ContO(record.car[0][i_86_], 0, 0, 0, 0);
               } while (++i_86_ < 7);
            }

            medium.d(this.rd);
            int i_87_ = 0;
            int[] is = new int[100];

            for (int i_88_ = 0; i_88_ < this.nob; i_88_++) {
               if (contos_44_[i_88_].dist != 0) {
                  is[i_87_] = i_88_;
                  i_87_++;
               } else {
                  contos_44_[i_88_].d(this.rd);
               }
            }

            int[] is_89_ = new int[i_87_];

            for (int i_90_ = 0; i_90_ < i_87_; i_90_++) {
               is_89_[i_90_] = 0;
            }

            for (int i_91_ = 0; i_91_ < i_87_; i_91_++) {
               for (int i_92_ = i_91_ + 1; i_92_ < i_87_; i_92_++) {
                  if (contos_44_[is[i_91_]].dist != contos_44_[is[i_92_]].dist) {
                     if (contos_44_[is[i_91_]].dist < contos_44_[is[i_92_]].dist) {
                        is_89_[i_91_]++;
                     } else {
                        is_89_[i_92_]++;
                     }
                  } else if (i_92_ > i_91_) {
                     is_89_[i_91_]++;
                  } else {
                     is_89_[i_92_]++;
                  }
               }
            }

            for (int i_93_ = 0; i_93_ < i_87_; i_93_++) {
               for (int i_94_ = 0; i_94_ < i_87_; i_94_++) {
                  if (is_89_[i_94_] == i_93_) {
                     contos_44_[is[i_94_]].d(this.rd);
                  }
               }
            }

            if (this.u[0].enter || this.u[0].handb || this.mouses == 1) {
               i_51_ = 299;
               this.u[0].enter = false;
               this.u[0].handb = false;
               this.mouses = 0;
            }

            int i_95_ = 0;

            do {
               if (record.fix[i_95_] == i_51_) {
                  if (contos_44_[i_95_].dist == 0) {
                     contos_44_[i_95_].fcnt = 8;
                  } else {
                     contos_44_[i_95_].fix = true;
                  }
               }

               if (contos_44_[i_95_].fcnt == 7 || contos_44_[i_95_].fcnt == 8) {
                  contos_44_[i_95_] = new ContO(contos[madnesses[i_95_].cn], 0, 0, 0, 0);
                  record.cntdest[i_95_] = 0;
               }

               if (i_51_ == 299) {
                  contos_44_[i_95_] = record.ocar[i_95_];
               }

               record.play(contos_44_[i_95_], madnesses[i_95_], i_95_, i_51_);
            } while (++i_95_ < 7);

            if (++i_51_ == 300) {
               i_51_ = 0;
               var_xtGraphics.fase = -6;
            } else {
               var_xtGraphics.replyn();
            }

            medium.around(contos_44_[0], false);
         }

         if (var_xtGraphics.fase == -2) {
            if (record.hcaught && record.wasted == 0 && record.whenwasted != 229 && checkpoints.stage <= 2 && var_xtGraphics.looped != 0) {
               record.hcaught = false;
            }

            if (record.hcaught) {
               if (medium.random() > 0.45) {
                  medium.vert = false;
               } else {
                  medium.vert = true;
               }

               medium.adv = (int)(900.0F * medium.random());
               medium.vxz = (int)(360.0F * medium.random());
               i_51_ = 0;
               var_xtGraphics.fase = -3;
               i_52_ = 0;
               i_53_ = 0;
            } else {
               i_51_ = -2;
               var_xtGraphics.fase = -4;
            }
         }

         if (var_xtGraphics.fase == -3) {
            if (i_51_ == 0) {
               if (record.wasted == 0) {
                  if (record.whenwasted == 229) {
                     i_54_ = 67;
                     medium.vxz += 90;
                  } else {
                     i_54_ = (int)(medium.random() * 4.0F);
                     if (i_54_ == 1 || i_54_ == 3) {
                        i_54_ = 69;
                     }

                     if (i_54_ == 2 || i_54_ == 4) {
                        i_54_ = 30;
                     }
                  }
               } else if (record.closefinish != 0 && i_53_ != 0) {
                  medium.vxz += 90;
               }

               int i_96_ = 0;

               do {
                  contos_44_[i_96_] = new ContO(record.starcar[i_96_], 0, 0, 0, 0);
               } while (++i_96_ < 7);
            }

            medium.d(this.rd);
            int i_97_ = 0;
            int[] is = new int[1000];

            for (int i_98_ = 0; i_98_ < this.nob; i_98_++) {
               if (contos_44_[i_98_].dist != 0) {
                  is[i_97_] = i_98_;
                  i_97_++;
               } else {
                  contos_44_[i_98_].d(this.rd);
               }
            }

            int[] is_99_ = new int[i_97_];

            for (int i_100_ = 0; i_100_ < i_97_; i_100_++) {
               is_99_[i_100_] = 0;
            }

            for (int i_101_ = 0; i_101_ < i_97_; i_101_++) {
               for (int i_102_ = i_101_ + 1; i_102_ < i_97_; i_102_++) {
                  if (contos_44_[is[i_101_]].dist != contos_44_[is[i_102_]].dist) {
                     if (contos_44_[is[i_101_]].dist < contos_44_[is[i_102_]].dist) {
                        is_99_[i_101_]++;
                     } else {
                        is_99_[i_102_]++;
                     }
                  } else if (i_102_ > i_101_) {
                     is_99_[i_101_]++;
                  } else {
                     is_99_[i_102_]++;
                  }
               }
            }

            for (int i_103_ = 0; i_103_ < i_97_; i_103_++) {
               for (int i_104_ = 0; i_104_ < i_97_; i_104_++) {
                  if (is_99_[i_104_] == i_103_) {
                     contos_44_[is[i_104_]].d(this.rd);
                  }
               }
            }

            int i_105_ = 0;

            do {
               if (record.hfix[i_105_] == i_51_) {
                  if (contos_44_[i_105_].dist == 0) {
                     contos_44_[i_105_].fcnt = 8;
                  } else {
                     contos_44_[i_105_].fix = true;
                  }
               }

               if (contos_44_[i_105_].fcnt == 7 || contos_44_[i_105_].fcnt == 8) {
                  contos_44_[i_105_] = new ContO(contos[madnesses[i_105_].cn], 0, 0, 0, 0);
                  record.cntdest[i_105_] = 0;
               }

               record.playh(contos_44_[i_105_], madnesses[i_105_], i_105_, i_51_);
            } while (++i_105_ < 7);

            if (i_53_ == 2 && i_51_ == 299) {
               this.u[0].enter = true;
            }

            if (!this.u[0].enter && !this.u[0].handb) {
               var_xtGraphics.levelhigh(record.wasted, record.whenwasted, record.closefinish, i_51_, checkpoints.stage);
               if (i_51_ == 0 || i_51_ == 1 || i_51_ == 2) {
                  this.rd.setColor(new Color(0, 0, 0));
                  this.rd.fillRect(0, 0, 670, 400);
               }

               if (record.wasted != 0) {
                  if (record.closefinish != 0) {
                     if (record.closefinish == 1) {
                        if (i_52_ == 0) {
                           medium.around(contos_44_[0], false);
                        }

                        if (i_52_ > 0 && i_52_ < 20) {
                           medium.transaround(contos_44_[0], contos_44_[record.wasted], i_52_);
                        }

                        if (i_52_ == 20) {
                           medium.around(contos_44_[record.wasted], false);
                        }

                        if (i_52_ > 20 && i_52_ < 40) {
                           medium.transaround(contos_44_[record.wasted], contos_44_[0], i_52_ - 20);
                        }

                        if (i_52_ == 40) {
                           medium.around(contos_44_[0], false);
                        }

                        if (i_52_ > 40 && i_52_ < 60) {
                           medium.transaround(contos_44_[0], contos_44_[record.wasted], i_52_ - 40);
                        }

                        if (i_52_ == 60) {
                           medium.around(contos_44_[record.wasted], false);
                        }

                        if (i_51_ > 160 && i_52_ < 20) {
                           i_52_++;
                        }

                        if (i_51_ > 230 && i_52_ < 40) {
                           i_52_++;
                        }

                        if (i_51_ > 280 && i_52_ < 60) {
                           i_52_++;
                        }

                        if ((i_52_ == 0 || i_52_ == 20 || i_52_ == 40 || i_52_ == 60) && ++i_51_ == 300) {
                           i_51_ = 0;
                           i_52_ = 0;
                           i_53_++;
                        }
                     } else {
                        if (i_52_ == 0) {
                           medium.around(contos_44_[0], false);
                        }

                        if (i_52_ > 0 && i_52_ < 20) {
                           medium.transaround(contos_44_[0], contos_44_[record.wasted], i_52_);
                        }

                        if (i_52_ == 20) {
                           medium.around(contos_44_[record.wasted], false);
                        }

                        if (i_52_ > 20 && i_52_ < 40) {
                           medium.transaround(contos_44_[record.wasted], contos_44_[0], i_52_ - 20);
                        }

                        if (i_52_ == 40) {
                           medium.around(contos_44_[0], false);
                        }

                        if (i_52_ > 40 && i_52_ < 60) {
                           medium.transaround(contos_44_[0], contos_44_[record.wasted], i_52_ - 40);
                        }

                        if (i_52_ == 60) {
                           medium.around(contos_44_[record.wasted], false);
                        }

                        if (i_52_ > 60 && i_52_ < 80) {
                           medium.transaround(contos_44_[record.wasted], contos_44_[0], i_52_ - 60);
                        }

                        if (i_52_ == 80) {
                           medium.around(contos_44_[0], false);
                        }

                        if (i_51_ > 90 && i_52_ < 20) {
                           i_52_++;
                        }

                        if (i_51_ > 160 && i_52_ < 40) {
                           i_52_++;
                        }

                        if (i_51_ > 230 && i_52_ < 60) {
                           i_52_++;
                        }

                        if (i_51_ > 280 && i_52_ < 80) {
                           i_52_++;
                        }

                        if ((i_52_ == 0 || i_52_ == 20 || i_52_ == 40 || i_52_ == 60 || i_52_ == 80) && ++i_51_ == 300) {
                           i_51_ = 0;
                           i_52_ = 0;
                           i_53_++;
                        }
                     }
                  } else {
                     if (i_52_ == 9 || i_52_ == 11) {
                        this.rd.setColor(new Color(255, 255, 255));
                        this.rd.fillRect(0, 0, 670, 400);
                     }

                     if (i_52_ == 0) {
                        medium.around(contos_44_[0], false);
                     }

                     if (i_52_ > 0 && i_52_ < 20) {
                        medium.transaround(contos_44_[0], contos_44_[record.wasted], i_52_);
                     }

                     if (i_52_ == 20) {
                        medium.around(contos_44_[record.wasted], false);
                     }

                     if (i_51_ > record.whenwasted && i_52_ != 20) {
                        i_52_++;
                     }

                     if ((i_52_ == 0 || i_52_ == 20) && ++i_51_ == 300) {
                        i_51_ = 0;
                        i_52_ = 0;
                        i_53_++;
                     }
                  }
               } else {
                  if (i_54_ == 67 && (i_52_ == 3 || i_52_ == 31 || i_52_ == 66)) {
                     this.rd.setColor(new Color(255, 255, 255));
                     this.rd.fillRect(0, 0, 670, 400);
                  }

                  if (i_54_ == 69 && (i_52_ == 3 || i_52_ == 5 || i_52_ == 31 || i_52_ == 33 || i_52_ == 66 || i_52_ == 68)) {
                     this.rd.setColor(new Color(255, 255, 255));
                     this.rd.fillRect(0, 0, 670, 400);
                  }

                  if (i_54_ == 30 && i_52_ >= 1 && i_52_ < 30) {
                     if (i_52_ % (int)(2.0F + medium.random() * 3.0F) == 0 && !bool_55_) {
                        this.rd.setColor(new Color(255, 255, 255));
                        this.rd.fillRect(0, 0, 670, 400);
                        bool_55_ = true;
                     } else {
                        bool_55_ = false;
                     }
                  }

                  if (i_51_ > record.whenwasted && i_52_ != i_54_) {
                     i_52_++;
                  }

                  medium.around(contos_44_[0], false);
                  if ((i_52_ == 0 || i_52_ == i_54_) && ++i_51_ == 300) {
                     i_51_ = 0;
                     i_52_ = 0;
                     i_53_++;
                  }
               }
            } else {
               var_xtGraphics.fase = -4;
               this.u[0].enter = false;
               this.u[0].handb = false;
               i_51_ = -7;
            }
         }

         if (var_xtGraphics.fase == -4) {
            if (i_51_ <= 0) {
               this.rd.drawImage(var_xtGraphics.mdness, 224, 30, null);
               this.rd.drawImage(var_xtGraphics.dude[0], 70, 10, null);
            }

            if (i_51_ >= 0) {
               var_xtGraphics.fleximage(this.offImage, i_51_, checkpoints.stage);
            }

            if (checkpoints.stage == 17 && ++i_51_ == 10) {
               var_xtGraphics.fase = -5;
            }

            if (i_51_ == 12) {
               var_xtGraphics.fase = -5;
            }
         }

         if (var_xtGraphics.fase == -6) {
            this.repaint();
            var_xtGraphics.pauseimage(this.offImage);
            var_xtGraphics.fase = -7;
            this.mouses = 0;
         }

         if (var_xtGraphics.fase == -7) {
            var_xtGraphics.pausedgame(checkpoints.stage, this.u[0], record);
            if (i_51_ != 0) {
               i_51_ = 0;
            }

            var_xtGraphics.ctachm(this.xm, this.ym, this.mouses, this.u[0]);
            if (this.mouses == 2) {
               this.mouses = 0;
            }

            if (this.mouses == 1) {
               this.mouses = 2;
            }
         }

         if (var_xtGraphics.fase == -8) {
            var_xtGraphics.cantreply();
            i_51_++;
            if (i_51_ == 150 || this.u[0].enter || this.u[0].handb || this.mouses == 1) {
               var_xtGraphics.fase = -7;
               this.mouses = 0;
               this.u[0].enter = false;
               this.u[0].handb = false;
            }
         }

         if (this.lostfcs && var_xtGraphics.fase != 176 && var_xtGraphics.fase != 111) {
            if (var_xtGraphics.fase == 0) {
               this.u[0].enter = true;
            } else {
               var_xtGraphics.nofocus();
            }

            if (this.mouses == 1 || this.mouses == 2) {
               this.lostfcs = false;
            }
         }

         this.repaint();
         var_xtGraphics.playsounds(madnesses[0], this.u[0], checkpoints.stage);
         date = new Date();
         long l_106_ = date.getTime();
         if (var_xtGraphics.fase != 0 && var_xtGraphics.fase != -1 && var_xtGraphics.fase != -3) {
            if (bool_49_) {
               f = f_48_;
               bool_49_ = false;
               i_50_ = 0;
            }

            if (i_46_ != 0 && var_xtGraphics.fase == 176) {
               if (i_46_ == 79) {
                  f_48_ = f;
                  l_47_ = l_106_;
                  i_50_ = 0;
               }

               if (i_50_ == 10) {
                  if (l_106_ - l_47_ < i_42_) {
                     f_48_ += 5.0F;
                  } else {
                     f_48_ -= 5.0F;
                     if (f_48_ < 5.0F) {
                        f_48_ = 5.0F;
                     }
                  }

                  l_47_ = l_106_;
                  i_50_ = 0;
               } else {
                  i_50_++;
               }

               if (i_46_ == 1) {
                  f = f_48_;
               }
            } else if (i_50_ == 10) {
               if (l_106_ - l_47_ < 400L) {
                  f_48_ = (float)(f_48_ + 3.5);
               } else {
                  f_48_ = (float)(f_48_ - 3.5);
                  if (f_48_ < 5.0F) {
                     f_48_ = 5.0F;
                  }
               }

               l_47_ = l_106_;
               i_50_ = 0;
            } else {
               i_50_++;
            }
         } else {
            if (!bool_49_) {
               f_48_ = f;
               bool_49_ = true;
               i_50_ = 0;
            }

            if (i_50_ == 10) {
               if (l_106_ - l_47_ < i_42_) {
                  f_48_ = (float)(f_48_ + 0.5);
               } else {
                  f_48_ = (float)(f_48_ - 0.5);
                  if (f_48_ < 5.0F) {
                     f_48_ = 5.0F;
                  }
               }

               if (var_xtGraphics.starcnt == 0) {
                  medium.adjstfade(f_48_);
               }

               l_47_ = l_106_;
               i_50_ = 0;
            } else {
               i_50_++;
            }
         }

         l = Math.round(f_48_) - (l_106_ - l_56_);
         if (l < i) {
            l = i;
         }

         try {
            Thread.sleep(l);
         } catch (InterruptedException var37) {
         }
      }
   }

   @Override
   public void init() {
      if (this.getAppletContext() instanceof DesktopContext) {
         this.loadData();
      }

      this.offImage = this.createImage(670, 400);
      if (this.offImage != null) {
         this.rd = this.offImage.getGraphics();
      }

      this.validate();
   }

   public void savecookie(String string, String string_107_) {
      boolean noCookie = false;

      try {
         JSObject jsobject = JSObject.getWindow(this);
         jsobject.eval("SetCookie('" + string + "','" + string_107_ + "');");
      } catch (NoClassDefFoundError var5) {
         noCookie = true;
      } catch (Exception var6) {
         noCookie = true;
      }

      if (noCookie && this.properties != null) {
         this.properties.put(string, Integer.parseInt(string_107_));
      }
   }

   public void catchlink(int i) {
      if (!this.lostfcs) {
         if (i == 0) {
            if (this.xm > 0 && this.xm < 670 && this.ym > 110 && this.ym < 169 || this.xm > 210 && this.xm < 460 && this.ym > 240 && this.ym < 259) {
               this.setCursor(new Cursor(12));
               if (this.mouses == 2) {
                  try {
                     URL url = new URL("javascript:radicalplay();");
                     this.getAppletContext().showDocument(url);
                  } catch (Exception var4) {
                  }
               }
            } else {
               this.setCursor(new Cursor(0));
            }
         }

         if (i == 1) {
            if (this.xm > 0 && this.xm < 670 && this.ym > 205 && this.ym < 267) {
               this.setCursor(new Cursor(12));
               if (this.mouses == 2) {
                  try {
                     URL url = new URL("javascript:radicalplay();");
                     this.getAppletContext().showDocument(url);
                  } catch (Exception var3) {
                  }
               }
            } else {
               this.setCursor(new Cursor(0));
            }
         }
      }
   }

   @Override
   public boolean mouseMove(Event event, int x, int y) {
      if (!this.exwist && !this.lostfcs) {
         this.xm = x;
         this.ym = y;
      }

      return false;
   }
}
