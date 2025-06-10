import java.applet.Applet;
import java.awt.AlphaComposite;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URI;
import java.net.URL;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class GameSparker extends Applet implements Runnable {
   Graphics2D rd;
   Image offImage;
   Thread gamer;
   int mload = 1;
   boolean exwist = false;
   int apx = 0;
   int apy = 0;
   float apmult = 1.0F;
   float reqmult = 0.0F;
   int smooth = 0;
   int moto = 0;
   int lastw = 0;
   int lasth = 0;
   boolean onbar = false;
   boolean oncarm = false;
   boolean onstgm = false;
   boolean onfulls = false;
   Image sizebar;
   Image blb;
   Image fulls;
   Image[] chkbx = new Image[2];
   Image[] carmaker = new Image[2];
   Image[] stagemaker = new Image[2];
   int showsize = 0;
   Control[] u = new Control[8];
   int mouses = 0;
   int xm = 0;
   int ym = 0;
   int mousew = 0;
   boolean lostfcs = false;
   boolean moused = false;
   int fcscnt = 0;
   int nob = 0;
   int notb = 0;
   int view = 0;
   int mvect = 100;
   int lmxz = 0;
   int shaka = 0;
   boolean applejava = false;
   TextField tnick;
   TextField tpass;
   TextField temail;
   TextField cmsg;
   TextArea mmsg;
   Checkbox mycar;
   Checkbox notp;
   Checkbox keplo;
   boolean openm = false;
   Smenu sgame = new Smenu(8);
   Smenu wgame = new Smenu(4);
   Smenu warb = new Smenu(102);
   Smenu pgame = new Smenu(11);
   Smenu vnpls = new Smenu(5);
   Smenu vtyp = new Smenu(6);
   Smenu snfmm = new Smenu(12);
   Smenu snfm1 = new Smenu(12);
   Smenu snfm2 = new Smenu(19);
   Smenu mstgs = new Smenu(707);
   Smenu mcars = new Smenu(707);
   Smenu slaps = new Smenu(17);
   Smenu snpls = new Smenu(9);
   Smenu snbts = new Smenu(8);
   Smenu swait = new Smenu(6);
   Smenu sclass = new Smenu(7);
   Smenu scars = new Smenu(4);
   Smenu sfix = new Smenu(7);
   Smenu gmode = new Smenu(3);
   Smenu rooms = new Smenu(7);
   Smenu sendtyp = new Smenu(6);
   Smenu senditem = new Smenu(707);
   Smenu clanlev = new Smenu(8);
   Smenu clcars = new Smenu(707);
   Smenu datat = new Smenu(26);
   Smenu ilaps = new Smenu(18);
   Smenu icars = new Smenu(5);
   Smenu proitem = new Smenu(707);

   private static final String datapath = "/files/";

   @Override
   public void run() {
      this.rd.setColor(new Color(0, 0, 0));
      this.rd.fillRect(0, 0, 800, 450);
      this.repaint();
      this.requestFocus();
      if (System.getProperty("java.vendor").toLowerCase().indexOf("apple") != -1) {
         this.applejava = true;
      }

      Medium var1 = new Medium();
      Trackers var2 = new Trackers();
      CheckPoints var3 = new CheckPoints();
      ContO[] var4 = new ContO[124];
      CarDefine var5 = new CarDefine(var4, var1, var2, this);
      xtGraphics var6 = new xtGraphics(var1, var5, this.rd, this);
      this.sizebar = var6.getImage("data/sizebar.gif");
      this.blb = var6.getImage("data/b.gif");
      this.fulls = var6.getImage("data/fullscreen.gif");
      this.chkbx[0] = var6.getImage("data/checkbox1.gif");
      this.chkbx[1] = var6.getImage("data/checkbox2.gif");
      this.carmaker[0] = var6.getImage("data/carmaker1.gif");
      this.carmaker[1] = var6.getImage("data/carmaker2.gif");
      this.stagemaker[0] = var6.getImage("data/stagemaker1.gif");
      this.stagemaker[1] = var6.getImage("data/stagemaker2.gif");
      var6.loaddata();
      Login var7 = null;
      Lobby var8 = null;
      Globe var9 = null;
      boolean var10 = false;
      UDPMistro var11 = new UDPMistro();
      Record var12 = new Record(var1);
      this.loadbase(var4, var1, var2, var6, false);
      ContO[] var13 = new ContO[610];
      Mad[] var14 = new Mad[8];

      for (int var15 = 0; var15 < 8; var15++) {
         var14[var15] = new Mad(var5, var1, var12, var6, var15);
         this.u[var15] = new Control(var1);
      }

      float var40 = 47.0F;
      this.readcookies(var6, var5, var4);
      var6.testdrive = Madness.testdrive;
      if (var6.testdrive != 0) {
         if (var6.testdrive <= 2) {
            var6.sc[0] = var5.loadcar(Madness.testcar, 16);
            if (var6.sc[0] != -1) {
               var6.fase = -9;
            } else {
               Madness.testcar = "Failx12";
               Madness.carmaker();
            }
         } else {
            var3.name = Madness.testcar;
            var6.fase = -9;
         }
      }

      var6.stoploading();
      this.requestFocus();
      if (var6.testdrive == 0 && var6.firstime) {
         this.setupini();
      }

      System.gc();
      Date var16 = new Date();
      long var17 = 0L;
      long var19 = var16.getTime();
      float var21 = 30.0F;
      boolean var22 = false;
      byte var23 = 30;
      short var24 = 530;
      int var25 = 0;
      int var26 = 0;
      int var27 = 0;
      int var28 = 0;
      int var29 = 0;
      boolean var30 = false;

      while (true) {
         var16 = new Date();
         long var31 = var16.getTime();
         if (var6.fase == 111) {
            if (this.mouses == 1) {
               var27 = 800;
            }

            if (var27 < 800) {
               var6.clicknow();
               var27++;
            } else {
               var27 = 0;
               if (!this.exwist) {
                  var6.fase = 9;
               }

               this.mouses = 0;
               this.lostfcs = false;
            }
         }

         if (var6.fase == 9) {
            if (var27 < 76) {
               var6.rad(var27);
               this.catchlink();
               if (this.mouses == 2) {
                  this.mouses = 0;
               }

               if (this.mouses == 1) {
                  this.mouses = 2;
               }

               var27++;
            } else {
               var27 = 0;
               var6.fase = 10;
               this.mouses = 0;
               this.u[0].falseo(0);
            }
         }

         if (var6.fase == -9) {
            if (var6.loadedt) {
               var6.mainbg(-101);
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.fillRect(0, 0, 800, 450);
               this.repaint();
               var6.strack.unload();
               var6.strack = null;
               var6.flexpix = null;
               var6.fleximg = null;
               System.gc();
               var6.loadedt = false;
            }

            if (var27 < 2) {
               var6.mainbg(-101);
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.fillRect(65, 25, 670, 400);
               var27++;
            } else {
               this.checkmemory(var6);
               var6.inishcarselect(var4);
               var27 = 0;
               var6.fase = 7;
               this.mvect = 50;
               this.mouses = 0;
            }
         }

         if (var6.fase == 8) {
            var6.credits(this.u[0], this.xm, this.ym, this.mouses);
            var6.ctachm(this.xm, this.ym, this.mouses, this.u[0]);
            if (var6.flipo <= 100) {
               this.catchlink();
            }

            if (this.mouses == 2) {
               this.mouses = 0;
            }

            if (this.mouses == 1) {
               this.mouses = 2;
            }
         }

         if (var6.fase == 10) {
            this.mvect = 100;
            var6.maini(this.u[0]);
            var6.ctachm(this.xm, this.ym, this.mouses, this.u[0]);
            if (this.mouses == 2) {
               this.mouses = 0;
            }

            if (this.mouses == 1) {
               this.mouses = 2;
            }
         }

         if (var6.fase == 102) {
            this.mvect = 100;
            if (var6.loadedt) {
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.fillRect(0, 0, 800, 450);
               this.repaint();
               this.checkmemory(var6);
               var6.strack.unload();
               var6.strack = null;
               var6.flexpix = null;
               var6.fleximg = null;
               System.gc();
               var6.loadedt = false;
            }

            if (var6.testdrive == 1 || var6.testdrive == 2) {
               Madness.carmaker();
            }

            if (var6.testdrive == 3 || var6.testdrive == 4) {
               Madness.stagemaker();
            }

            var6.maini2(this.u[0], this.xm, this.ym, this.mouses);
            var6.ctachm(this.xm, this.ym, this.mouses, this.u[0]);
            if (this.mouses == 2) {
               this.mouses = 0;
            }

            if (this.mouses == 1) {
               this.mouses = 2;
            }
         }

         if (var6.fase == -22) {
            var3.name = Madness.testcar;
            var3.stage = -1;
            this.loadstage(var13, var4, var1, var2, var3, var6, var14, var12);
            if (var3.stage == -3) {
               Madness.testcar = "Failx12";
               Madness.stagemaker();
            }
         }

         if (var6.fase == 11) {
            var6.inst(this.u[0]);
            var6.ctachm(this.xm, this.ym, this.mouses, this.u[0]);
            if (this.mouses == 2) {
               this.mouses = 0;
            }

            if (this.mouses == 1) {
               this.mouses = 2;
            }
         }

         if (var6.fase == -5) {
            this.mvect = 100;
            var6.finish(var3, var4, this.u[0], this.xm, this.ym, this.moused);
            var6.ctachm(this.xm, this.ym, this.mouses, this.u[0]);
            if (this.mouses == 2) {
               this.mouses = 0;
            }

            if (this.mouses == 1) {
               this.mouses = 2;
            }
         }

         if (var6.fase == 7) {
            var6.carselect(this.u[0], var4, var14[0], this.xm, this.ym, this.moused);
            var6.ctachm(this.xm, this.ym, this.mouses, this.u[0]);
            if (this.mouses == 2) {
               this.mouses = 0;
            }

            if (this.mouses == 1) {
               this.mouses = 2;
            }

            this.drawms();
         }

         if (var6.fase == 6) {
            var6.musicomp(var3.stage, this.u[0]);
            var6.ctachm(this.xm, this.ym, this.mouses, this.u[0]);
            if (this.mouses == 2) {
               this.mouses = 0;
            }

            if (this.mouses == 1) {
               this.mouses = 2;
            }
         }

         if (var6.fase == 5) {
            this.mvect = 100;
            var6.loadmusic(var3.stage, var3.trackname, var3.trackvol);
         }

         if (var6.fase == 4) {
            var6.cantgo(this.u[0]);
            var6.ctachm(this.xm, this.ym, this.mouses, this.u[0]);
            if (this.mouses == 2) {
               this.mouses = 0;
            }

            if (this.mouses == 1) {
               this.mouses = 2;
            }
         }

         if (var6.fase == 3) {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.fillRect(65, 25, 670, 400);
            this.repaint();
            var6.inishstageselect(var3);
         }

         if (var6.fase == 2) {
            this.mvect = 100;
            var6.loadingstage(var3.stage, true);
            var3.nfix = 0;
            var3.notb = false;
            this.loadstage(var13, var4, var1, var2, var3, var6, var14, var12);
            this.u[0].falseo(0);
            var11.freg = 0.0F;
            this.mvect = 20;
         }

         if (var6.fase == 1) {
            var6.trackbg(false);
            this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
            if (var3.stage != -3) {
               var1.aroundtrack(var3);
               if (var1.hit == 5000 && this.mvect < 40) {
                  this.mvect++;
               }

               int var33 = 0;
               int[] var34 = new int[1000];

               for (int var35 = var6.nplayers; var35 < this.notb; var35++) {
                  if (var13[var35].dist != 0) {
                     var34[var33] = var35;
                     var33++;
                  } else {
                     var13[var35].d(this.rd);
                  }
               }

               int[] var64 = new int[var33];

               for (int var36 = 0; var36 < var33; var36++) {
                  var64[var36] = 0;
               }

               for (int var79 = 0; var79 < var33; var79++) {
                  for (int var37 = var79 + 1; var37 < var33; var37++) {
                     if (var13[var34[var79]].dist != var13[var34[var37]].dist) {
                        if (var13[var34[var79]].dist < var13[var34[var37]].dist) {
                           var64[var79]++;
                        } else {
                           var64[var37]++;
                        }
                     } else if (var37 > var79) {
                        var64[var79]++;
                     } else {
                        var64[var37]++;
                     }
                  }
               }

               for (int var80 = 0; var80 < var33; var80++) {
                  for (int var95 = 0; var95 < var33; var95++) {
                     if (var64[var95] == var80) {
                        var13[var34[var95]].d(this.rd);
                     }
                  }
               }
            }

            if (!this.openm) {
               var6.ctachm(this.xm, this.ym, this.mouses, this.u[0]);
            }

            if (this.mouses == 2) {
               this.mouses = 0;
            }

            if (this.mouses == 1) {
               this.mouses = 2;
            }

            this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            var6.stageselect(var3, this.u[0], this.xm, this.ym, this.moused);
            this.drawms();
         }

         if (var6.fase == 1177) {
            this.mvect = 100;
            if (!var10) {
               if (var6.loadedt) {
                  this.rd.setColor(new Color(0, 0, 0));
                  this.rd.fillRect(0, 0, 800, 450);
                  this.repaint();
                  this.checkmemory(var6);
                  var6.strack.unload();
                  var6.strack = null;
                  var6.flexpix = null;
                  var6.fleximg = null;
                  System.gc();
                  var6.loadedt = false;
               }

               var6.intertrack.unloadimod();
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.fillRect(65, 25, 670, 400);
               if (this.mload > 0) {
                  this.rd.drawImage(var6.mload, 259, 195, this);
               }

               this.repaint();
               if (this.mload == 2) {
                  var5.loadready();
                  this.loadbase(var4, var1, var2, var6, true);
                  this.readcookies(var6, var5, var4);
                  this.mload = -1;
               }

               System.gc();
               var7 = new Login(var1, this.rd, var6, this);
               var9 = new Globe(this.rd, var6, var1, var7, var5, var3, var4, var13, this);
               var8 = new Lobby(var1, this.rd, var7, var9, var6, var5, this);
               var10 = true;
            }

            if (var7.fase != 18) {
               boolean var45 = false;
               if (var7.fase == 0) {
                  var7.inishmulti();
               }

               if (var7.fase >= 1 && var7.fase <= 11) {
                  var7.multistart(var4, this.xm, this.ym, this.moused);
               }

               if (var7.fase >= 12 && var7.fase <= 17) {
                  if (var9.open != 452) {
                     var7.multimode(var4);
                  } else {
                     var45 = true;
                  }

                  var9.dome(0, this.xm, this.ym, this.moused, this.u[0]);
               }

               if (var7.justlog) {
                  if (!var6.clan.equals("")) {
                     var9.itab = 2;
                  }

                  var7.justlog = false;
               }

               if (!var45) {
                  var7.ctachm(this.xm, this.ym, this.mouses, this.u[0], var8);
                  this.mvect = 50;
               } else {
                  this.drawms();
                  this.mvect = 100;
               }

               if (this.mouses == 1) {
                  this.mouses = 11;
               }

               if (this.mouses <= -1) {
                  this.mouses--;
                  if (this.mouses == -4) {
                     this.mouses = 0;
                  }
               }

               if (this.mousew != 0) {
                  if (this.mousew > 0) {
                     this.mousew--;
                  } else {
                     this.mousew++;
                  }
               }
            } else {
               boolean var44 = false;
               if (var8.fase == 0) {
                  var8.inishlobby();
                  this.mvect = 100;
               }

               if (var8.fase == 1) {
                  if (var9.open >= 2 && var9.open < 452) {
                     this.openm = true;
                  }

                  if (var9.open != 452) {
                     var8.lobby(this.xm, this.ym, this.moused, this.mousew, var3, this.u[0], var4);
                  } else {
                     var44 = true;
                  }

                  var9.dome(var8.conon, this.xm, this.ym, this.moused, this.u[0]);
                  if (var8.loadstage > 0) {
                     this.setCursor(new Cursor(3));
                     this.drawms();
                     this.repaint();
                     var2.nt = 0;
                     if (this.loadstagePreview(var8.loadstage, "", var13, var4, var1, var3)) {
                        var8.gstagename = var3.name;
                        var8.gstagelaps = var3.nlaps;
                        var8.loadstage = -var8.loadstage;
                     } else {
                        var8.loadstage = 0;
                        var3.name = "";
                     }

                     this.setCursor(new Cursor(0));
                  }

                  if (var8.msload != 0) {
                     this.setCursor(new Cursor(3));
                     this.drawms();
                     this.repaint();
                     if (var8.msload == 1) {
                        var5.loadmystages(var3);
                     }

                     if (var8.msload == 7) {
                        var5.loadclanstages(var6.clan);
                     }

                     if (var8.msload == 3 || var8.msload == 4) {
                        var5.loadtop20(var8.msload);
                     }

                     var8.msload = 0;
                     this.setCursor(new Cursor(0));
                  }
               }

               if (var8.fase == 3) {
                  var6.trackbg(false);
                  var1.trk = 0;
                  var1.focus_point = 400;
                  var1.crs = true;
                  var1.x = -335;
                  var1.y = 0;
                  var1.z = -50;
                  var1.xz = 0;
                  var1.zy = 20;
                  var1.ground = -2000;
                  this.mvect = 100;
                  var8.fase = 1;
               }

               if (var8.fase == 4) {
                  this.mvect = 50;
                  this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
                  var1.d(this.rd);
                  var1.aroundtrack(var3);
                  int var56 = 0;
                  int[] var65 = new int[1000];

                  for (int var81 = 0; var81 < this.nob; var81++) {
                     if (var13[var81].dist != 0) {
                        var65[var56] = var81;
                        var56++;
                     } else {
                        var13[var81].d(this.rd);
                     }
                  }

                  int[] var82 = new int[var56];

                  for (int var96 = 0; var96 < var56; var96++) {
                     var82[var96] = 0;
                  }

                  for (int var97 = 0; var97 < var56; var97++) {
                     for (int var38 = var97 + 1; var38 < var56; var38++) {
                        if (var13[var65[var97]].dist != var13[var65[var38]].dist) {
                           if (var13[var65[var97]].dist < var13[var65[var38]].dist) {
                              var82[var97]++;
                           } else {
                              var82[var38]++;
                           }
                        } else if (var38 > var97) {
                           var82[var97]++;
                        } else {
                           var82[var38]++;
                        }
                     }
                  }

                  for (int var98 = 0; var98 < var56; var98++) {
                     for (int var122 = 0; var122 < var56; var122++) {
                        if (var82[var122] == var98) {
                           var13[var65[var122]].d(this.rd);
                        }
                     }
                  }

                  this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                  var8.stageselect(var3, this.u[0], this.xm, this.ym, this.moused);
                  if (var8.plsndt == 1) {
                     this.mvect = 70;
                     this.repaint();
                     this.setCursor(new Cursor(3));
                     var6.loadstrack(var3.stage, var3.trackname, var3.trackvol);
                     var6.strack.play();
                     var8.plsndt = 2;
                     this.moused = false;
                     this.mouses = 0;
                  }
               }

               if (var8.fase == 2) {
                  int var57 = 0;

                  for (int var66 = 0; var66 < var8.ngm; var66++) {
                     if (var8.ongame == var8.gnum[var66]) {
                        var57 = var66;
                     }
                  }

                  boolean var67 = false;
                  if (var8.gstgn[var57] > 0) {
                     if (var8.gstgn[var57] == -var8.loadstage) {
                        var67 = true;
                     }
                  } else if (var8.gstages[var57].equals(var3.name)) {
                     var67 = true;
                  }

                  if (var67) {
                     var8.fase = 4;
                     var8.addstage = 0;
                  } else {
                     var6.loadingstage(var8.gstgn[var57], false);
                     var2.nt = 0;
                     if (this.loadstagePreview(var8.gstgn[var57], var8.gstages[var57], var13, var4, var1, var3)) {
                        var8.loadstage = -var8.gstgn[var57];
                        var8.fase = 4;
                        var8.addstage = 0;
                     } else {
                        var8.loadstage = 0;
                        var3.name = "";
                        var8.fase = 3;
                     }
                  }
               }

               if (var8.fase == 76) {
                  var3.nlaps = var8.laps;
                  var3.stage = var8.stage;
                  var3.name = var8.stagename;
                  var3.nfix = var8.nfix;
                  var3.notb = var8.notb;
                  var6.fase = 21;
                  this.u[0].multion = var6.multion;
               }

               if (var9.loadwbgames == 7) {
                  this.repaint();
                  var9.redogame();
               }

               if (!this.openm) {
                  if (!var44) {
                     var8.ctachm(this.xm, this.ym, this.mouses, this.u[0]);
                  }
               } else {
                  this.mouses = 0;
               }

               this.drawms();
               if (var8.fase == 1) {
                  var8.preforma(this.xm, this.ym);
               }

               if (var8.loadwarb) {
                  this.repaint();
                  var9.loadwarb();
                  var8.loadwarb = false;
               }

               if (var9.loadwbgames == 1) {
                  this.repaint();
                  var9.loadwgames();
               }

               if (this.mouses == 1) {
                  this.mouses = 11;
               }

               if (this.mouses <= -1) {
                  this.mouses--;
                  if (this.mouses == -4) {
                     this.mouses = 0;
                  }
               }

               if (this.mousew != 0) {
                  if (this.mousew > 0) {
                     this.mousew--;
                  } else {
                     this.mousew++;
                  }

                  if (!var8.zeromsw) {
                     this.mousew = 0;
                  }
               }
            }
         }

         if (var6.fase == 24) {
            var7.endcons();
            var7 = null;
            var8 = null;
            var9 = null;
            var10 = false;
            System.gc();
            System.runFinalization();
            if (!var6.mtop) {
               var6.fase = 102;
               var6.opselect = 2;
            } else {
               var6.fase = 10;
               var6.opselect = 1;
            }
         }

         if (var6.fase == 23) {
            if (var7.fase == 18) {
               var6.playingame = -101;
            }

            var7.stopallnow();
            var8.stopallnow();
            var9.stopallnow();
            var7 = null;
            var8 = null;
            var9 = null;
            this.hidefields();
            var10 = false;
            System.gc();
            System.runFinalization();
            var6.fase = -9;
         }

         if (var6.fase == 22) {
            this.loadstage(var13, var4, var1, var2, var3, var6, var14, var12);
            if (var3.stage != -3) {
               if (var6.lan && var6.im == 0) {
                  var11.UDPLanServer(var6.nplayers, var6.server, var6.servport, var6.playingame);
               }

               this.u[0].falseo(2);
               this.requestFocus();
            } else {
               var6.fase = 1177;
            }
         }

         if (var6.fase == 21) {
            var7.endcons();
            var7 = null;
            var8 = null;
            var9 = null;
            var10 = false;
            System.gc();
            System.runFinalization();
            var6.fase = 22;
         }

         if (var6.fase == 0) {
            for (int var46 = 0; var46 < var6.nplayers; var46++) {
               if (var14[var46].newcar) {
                  int var58 = var13[var46].xz;
                  int var68 = var13[var46].xy;
                  int var83 = var13[var46].zy;
                  var13[var46] = new ContO(var4[var14[var46].cn], var13[var46].x, var13[var46].y, var13[var46].z, 0);
                  var13[var46].xz = var58;
                  var13[var46].xy = var68;
                  var13[var46].zy = var83;
                  var14[var46].newcar = false;
               }
            }

            var1.d(this.rd);
            int var47 = 0;
            int[] var59 = new int[200];

            for (int var69 = 0; var69 < this.nob; var69++) {
               if (var13[var69].dist != 0) {
                  var59[var47] = var69;
                  var47++;
               } else {
                  var13[var69].d(this.rd);
               }
            }

            int[] var70 = new int[var47];
            int[] var84 = new int[var47];

            for (int var99 = 0; var99 < var47; var99++) {
               var70[var99] = 0;
            }

            for (int var100 = 0; var100 < var47; var84[var70[var100]] = var100++) {
               for (int var123 = var100 + 1; var123 < var47; var123++) {
                  if (var13[var59[var100]].dist < var13[var59[var123]].dist) {
                     var70[var100]++;
                  } else {
                     var70[var123]++;
                  }
               }
            }

            for (int var101 = 0; var101 < var47; var101++) {
               var13[var59[var84[var101]]].d(this.rd);
            }

            if (var6.starcnt == 0) {
               for (int var102 = 0; var102 < var6.nplayers; var102++) {
                  for (int var124 = 0; var124 < var6.nplayers; var124++) {
                     if (var124 != var102) {
                        var14[var102].colide(var13[var102], var14[var124], var13[var124]);
                     }
                  }
               }

               for (int var103 = 0; var103 < var6.nplayers; var103++) {
                  var14[var103].drive(this.u[var103], var13[var103], var2, var3);
               }

               for (int var104 = 0; var104 < var6.nplayers; var104++) {
                  var12.rec(var13[var104], var104, var14[var104].squash, var14[var104].lastcolido, var14[var104].cntdest, 0);
               }

               var3.checkstat(var14, var13, var12, var6.nplayers, var6.im, 0);

               for (int var105 = 1; var105 < var6.nplayers; var105++) {
                  this.u[var105].preform(var14[var105], var13[var105], var3, var2);
               }
            } else {
               if (var6.starcnt == 130) {
                  var1.adv = 1900;
                  var1.zy = 40;
                  var1.vxz = 70;
                  this.rd.setColor(new Color(255, 255, 255));
                  this.rd.fillRect(0, 0, 800, 450);
               }

               if (var6.starcnt != 0) {
                  var6.starcnt--;
               }
            }

            if (var6.starcnt < 38) {
               if (this.view == 0) {
                  var1.follow(var13[0], var14[0].cxz, this.u[0].lookback);
                  var6.stat(var14[0], var13[0], var3, this.u[0], true);
                  if (var14[0].outshakedam > 0) {
                     this.shaka = var14[0].outshakedam / 20;
                     if (this.shaka > 25) {
                        this.shaka = 25;
                     }
                  }

                  this.mvect = 65 + Math.abs(this.lmxz - var1.xz) / 5 * 100;
                  if (this.mvect > 90) {
                     this.mvect = 90;
                  }

                  this.lmxz = var1.xz;
               }

               if (this.view == 1) {
                  var1.around(var13[0], false);
                  var6.stat(var14[0], var13[0], var3, this.u[0], false);
                  this.mvect = 80;
               }

               if (this.view == 2) {
                  var1.watch(var13[0], var14[0].mxz);
                  var6.stat(var14[0], var13[0], var3, this.u[0], false);
                  this.mvect = 65 + Math.abs(this.lmxz - var1.xz) / 5 * 100;
                  if (this.mvect > 90) {
                     this.mvect = 90;
                  }

                  this.lmxz = var1.xz;
               }

               if (this.mouses == 1) {
                  this.u[0].enter = true;
                  this.mouses = 0;
               }
            } else {
               byte var106 = 3;
               if (var6.nplayers == 1) {
                  var106 = 0;
               }

               var1.around(var13[var106], true);
               this.mvect = 80;
               if (this.u[0].enter || this.u[0].handb) {
                  var6.starcnt = 38;
                  this.u[0].enter = false;
                  this.u[0].handb = false;
               }

               if (var6.starcnt == 38) {
                  this.mouses = 0;
                  var1.vert = false;
                  var1.adv = 900;
                  var1.vxz = 180;
                  var3.checkstat(var14, var13, var12, var6.nplayers, var6.im, 0);
                  var1.follow(var13[0], var14[0].cxz, 0);
                  var6.stat(var14[0], var13[0], var3, this.u[0], true);
                  this.rd.setColor(new Color(255, 255, 255));
                  this.rd.fillRect(0, 0, 800, 450);
               }
            }
         }

         if (var6.fase == 7001) {
            for (int var48 = 0; var48 < var6.nplayers; var48++) {
               if (var14[var48].newedcar == 0 && var14[var48].newcar) {
                  int var60 = var13[var48].xz;
                  int var71 = var13[var48].xy;
                  int var85 = var13[var48].zy;
                  var6.colorCar(var4[var14[var48].cn], var48);
                  var13[var48] = new ContO(var4[var14[var48].cn], var13[var48].x, var13[var48].y, var13[var48].z, 0);
                  var13[var48].xz = var60;
                  var13[var48].xy = var71;
                  var13[var48].zy = var85;
                  var14[var48].newedcar = 20;
               }
            }

            var1.d(this.rd);
            int var49 = 0;
            int[] var61 = new int[200];

            for (int var72 = 0; var72 < this.nob; var72++) {
               if (var13[var72].dist != 0) {
                  var61[var49] = var72;
                  var49++;
               } else {
                  var13[var72].d(this.rd);
               }
            }

            int[] var73 = new int[var49];
            int[] var86 = new int[var49];

            for (int var107 = 0; var107 < var49; var107++) {
               var73[var107] = 0;
            }

            for (int var108 = 0; var108 < var49; var86[var73[var108]] = var108++) {
               for (int var125 = var108 + 1; var125 < var49; var125++) {
                  if (var13[var61[var108]].dist < var13[var61[var125]].dist) {
                     var73[var108]++;
                  } else {
                     var73[var125]++;
                  }
               }
            }

            for (int var109 = 0; var109 < var49; var109++) {
               if (var61[var86[var109]] < var6.nplayers && var61[var86[var109]] != var6.im) {
                  var11.readContOinfo(var13[var61[var86[var109]]], var61[var86[var109]]);
               }

               var13[var61[var86[var109]]].d(this.rd);
            }

            if (var6.starcnt == 0) {
               if (var6.multion == 1) {
                  int var111 = 1;

                  for (int var126 = 0; var126 < var6.nplayers; var126++) {
                     if (var6.im != var126) {
                        var11.readinfo(var14[var126], var13[var126], this.u[var111], var126, var3.dested);
                        var111++;
                     }
                  }
               } else {
                  for (int var110 = 0; var110 < var6.nplayers; var110++) {
                     var11.readinfo(var14[var110], var13[var110], this.u[var110], var110, var3.dested);
                  }
               }

               for (int var112 = 0; var112 < var6.nplayers; var112++) {
                  for (int var127 = 0; var127 < var6.nplayers; var127++) {
                     if (var127 != var112) {
                        var14[var112].colide(var13[var112], var14[var127], var13[var127]);
                     }
                  }
               }

               if (var6.multion != 1) {
                  for (int var114 = 0; var114 < var6.nplayers; var114++) {
                     var14[var114].drive(this.u[var114], var13[var114], var2, var3);
                  }
               } else {
                  int var113 = 1;

                  for (int var128 = 0; var128 < var6.nplayers; var128++) {
                     if (var6.im != var128) {
                        var14[var128].drive(this.u[var113], var13[var128], var2, var3);
                        var113++;
                     } else {
                        var14[var128].drive(this.u[0], var13[var128], var2, var3);
                     }
                  }

                  for (int var129 = 0; var129 < var6.nplayers; var129++) {
                     var12.rec(var13[var129], var129, var14[var129].squash, var14[var129].lastcolido, var14[var129].cntdest, var6.im);
                  }
               }

               var3.checkstat(var14, var13, var12, var6.nplayers, var6.im, var6.multion);
            } else {
               if (var6.starcnt == 130) {
                  var1.adv = 1900;
                  var1.zy = 40;
                  var1.vxz = 70;
                  this.rd.setColor(new Color(255, 255, 255));
                  this.rd.fillRect(0, 0, 800, 450);
                  this.repaint();
                  if (var6.lan) {
                     var11.UDPConnectLan(var6.localserver, var6.nplayers, var6.im);
                     if (var6.im == 0) {
                        var6.setbots(var11.isbot, var11.frame);
                     }
                  } else {
                     var11.UDPConnectOnline(var6.server, var6.gameport, var6.nplayers, var6.im);
                  }

                  if (var6.multion >= 2) {
                     var6.im = (int)(Math.random() * var6.nplayers);
                     var6.starcnt = 0;
                  }
               }

               if (var6.starcnt == 50) {
                  var11.frame[var11.im][0] = 0;
               }

               if (var6.starcnt != 39 && var6.starcnt != 0) {
                  var6.starcnt--;
               }

               if (var11.go && var6.starcnt >= 39) {
                  var6.starcnt = 38;
                  if (var6.lan) {
                     int var115 = var3.stage;
                     if (var115 < 0) {
                        byte var116 = 33;
                     }

                     if (var6.loadedt) {
                        var6.strack.play();
                     }
                  }
               }
            }

            if (var6.lan && var11.im == 0) {
               for (int var117 = 2; var117 < var6.nplayers; var117++) {
                  if (var11.isbot[var117]) {
                     this.u[var117].preform(var14[var117], var13[var117], var3, var2);
                     var11.setinfo(var14[var117], var13[var117], this.u[var117], var3.pos[var117], var3.magperc[var117], false, var117);
                  }
               }
            }

            if (var6.starcnt < 38) {
               if (var6.multion == 1) {
                  var11.setinfo(var14[var6.im], var13[var6.im], this.u[0], var3.pos[var6.im], var3.magperc[var6.im], var6.holdit, var6.im);
                  if (this.view == 0) {
                     var1.follow(var13[var6.im], var14[var6.im].cxz, this.u[0].lookback);
                     var6.stat(var14[var6.im], var13[var6.im], var3, this.u[0], true);
                     if (var14[var6.im].outshakedam > 0) {
                        this.shaka = var14[var6.im].outshakedam / 20;
                        if (this.shaka > 25) {
                           this.shaka = 25;
                        }
                     }

                     this.mvect = 65 + Math.abs(this.lmxz - var1.xz) / 5 * 100;
                     if (this.mvect > 90) {
                        this.mvect = 90;
                     }

                     this.lmxz = var1.xz;
                  }

                  if (this.view == 1) {
                     var1.around(var13[var6.im], false);
                     var6.stat(var14[var6.im], var13[var6.im], var3, this.u[0], false);
                     this.mvect = 80;
                  }

                  if (this.view == 2) {
                     var1.watch(var13[var6.im], var14[var6.im].mxz);
                     var6.stat(var14[var6.im], var13[var6.im], var3, this.u[0], false);
                     this.mvect = 65 + Math.abs(this.lmxz - var1.xz) / 5 * 100;
                     if (this.mvect > 90) {
                        this.mvect = 90;
                     }

                     this.lmxz = var1.xz;
                  }
               } else {
                  if (this.view == 0) {
                     var1.getaround(var13[var6.im]);
                     this.mvect = 80;
                  }

                  if (this.view == 1) {
                     var1.getfollow(var13[var6.im], var14[var6.im].cxz, this.u[0].lookback);
                     this.mvect = 65 + Math.abs(this.lmxz - var1.xz) / 5 * 100;
                     if (this.mvect > 90) {
                        this.mvect = 90;
                     }

                     this.lmxz = var1.xz;
                  }

                  if (this.view == 2) {
                     var1.watch(var13[var6.im], var14[var6.im].mxz);
                     this.mvect = 65 + Math.abs(this.lmxz - var1.xz) / 5 * 100;
                     if (this.mvect > 90) {
                        this.mvect = 90;
                     }

                     this.lmxz = var1.xz;
                  }

                  var6.stat(var14[var6.im], var13[var6.im], var3, this.u[0], true);
               }

               if (this.mouses == 1) {
                  if (var6.holdit && var6.exitm != 4 && var6.multion == 1) {
                     this.u[0].enter = true;
                  }

                  this.mouses = 0;
               }
            } else {
               var1.around(var13[var6.im], true);
               this.mvect = 80;
               if (var6.starcnt == 39) {
                  var6.waitenter();
               }

               if (var6.starcnt == 38) {
                  var6.forstart = 0;
                  this.mouses = 0;
                  var1.vert = false;
                  var1.adv = 900;
                  var1.vxz = 180;
                  var3.checkstat(var14, var13, var12, var6.nplayers, var6.im, var6.multion);
                  var1.follow(var13[var6.im], var14[var6.im].cxz, 0);
                  var6.stat(var14[var6.im], var13[var6.im], var3, this.u[0], true);
                  this.rd.setColor(new Color(255, 255, 255));
                  this.rd.fillRect(0, 0, 800, 450);
               }
            }

            var6.multistat(this.u[0], var3, this.xm, this.ym, this.moused, var11);
         }

         if (var6.fase == -1) {
            if (var26 == 0) {
               for (int var50 = 0; var50 < var6.nplayers; var50++) {
                  var12.ocar[var50] = new ContO(var13[var50], 0, 0, 0, 0);
                  var13[var50] = new ContO(var12.car[0][var50], 0, 0, 0, 0);
               }
            }

            var1.d(this.rd);
            int var51 = 0;
            int[] var62 = new int[200];

            for (int var74 = 0; var74 < this.nob; var74++) {
               if (var13[var74].dist != 0) {
                  var62[var51] = var74;
                  var51++;
               } else {
                  var13[var74].d(this.rd);
               }
            }

            int[] var75 = new int[var51];

            for (int var87 = 0; var87 < var51; var87++) {
               var75[var87] = 0;
            }

            for (int var88 = 0; var88 < var51; var88++) {
               for (int var118 = var88 + 1; var118 < var51; var118++) {
                  if (var13[var62[var88]].dist != var13[var62[var118]].dist) {
                     if (var13[var62[var88]].dist < var13[var62[var118]].dist) {
                        var75[var88]++;
                     } else {
                        var75[var118]++;
                     }
                  } else if (var118 > var88) {
                     var75[var88]++;
                  } else {
                     var75[var118]++;
                  }
               }
            }

            for (int var89 = 0; var89 < var51; var89++) {
               for (int var119 = 0; var119 < var51; var119++) {
                  if (var75[var119] == var89) {
                     var13[var62[var119]].d(this.rd);
                  }
               }
            }

            if (this.u[0].enter || this.u[0].handb || this.mouses == 1) {
               var26 = 299;
               this.u[0].enter = false;
               this.u[0].handb = false;
               this.mouses = 0;
            }

            for (int var90 = 0; var90 < var6.nplayers; var90++) {
               if (var12.fix[var90] == var26) {
                  if (var13[var90].dist == 0) {
                     var13[var90].fcnt = 8;
                  } else {
                     var13[var90].fix = true;
                  }
               }

               if (var13[var90].fcnt == 7 || var13[var90].fcnt == 8) {
                  var13[var90] = new ContO(var4[var14[var90].cn], 0, 0, 0, 0);
                  var12.cntdest[var90] = 0;
               }

               if (var26 == 299) {
                  var13[var90] = new ContO(var12.ocar[var90], 0, 0, 0, 0);
               }

               var12.play(var13[var90], var14[var90], var90, var26);
            }

            if (++var26 == 300) {
               var26 = 0;
               var6.fase = -6;
            } else {
               var6.replyn();
            }

            var1.around(var13[0], false);
         }

         if (var6.fase == -2) {
            if (var6.multion >= 2) {
               var12.hcaught = false;
            }

            this.u[0].falseo(3);
            if (var12.hcaught && var12.wasted == 0 && var12.whenwasted != 229 && (var3.stage == 1 || var3.stage == 2) && var6.looped != 0) {
               var12.hcaught = false;
            }

            if (var12.hcaught) {
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.fillRect(0, 0, 800, 450);
               this.repaint();
            }

            if (var6.multion != 0) {
               var11.UDPquit();
               var6.stopchat();
               if (this.cmsg.isShowing()) {
                  this.cmsg.hide();
               }

               this.cmsg.setText("");
               this.requestFocus();
            }

            if (var12.hcaught) {
               if (var1.random() > 0.45) {
                  var1.vert = false;
               } else {
                  var1.vert = true;
               }

               var1.adv = (int)(900.0F * var1.random());
               var1.vxz = (int)(360.0F * var1.random());
               var26 = 0;
               var6.fase = -3;
               var27 = 0;
               var28 = 0;
            } else {
               var26 = -2;
               var6.fase = -4;
            }
         }

         if (var6.fase == -3) {
            if (var26 == 0) {
               if (var12.wasted == 0) {
                  if (var12.whenwasted == 229) {
                     var29 = 67;
                     var1.vxz += 90;
                  } else {
                     var29 = (int)(var1.random() * 4.0F);
                     if (var29 == 1 || var29 == 3) {
                        var29 = 69;
                     }

                     if (var29 == 2 || var29 == 4) {
                        var29 = 30;
                     }
                  }
               } else if (var12.closefinish != 0 && var28 != 0) {
                  var1.vxz += 90;
               }

               for (int var52 = 0; var52 < var6.nplayers; var52++) {
                  var13[var52] = new ContO(var12.starcar[var52], 0, 0, 0, 0);
               }
            }

            var1.d(this.rd);
            int var53 = 0;
            int[] var63 = new int[200];

            for (int var76 = 0; var76 < this.nob; var76++) {
               if (var13[var76].dist != 0) {
                  var63[var53] = var76;
                  var53++;
               } else {
                  var13[var76].d(this.rd);
               }
            }

            int[] var77 = new int[var53];

            for (int var91 = 0; var91 < var53; var91++) {
               var77[var91] = 0;
            }

            for (int var92 = 0; var92 < var53; var92++) {
               for (int var120 = var92 + 1; var120 < var53; var120++) {
                  if (var13[var63[var92]].dist != var13[var63[var120]].dist) {
                     if (var13[var63[var92]].dist < var13[var63[var120]].dist) {
                        var77[var92]++;
                     } else {
                        var77[var120]++;
                     }
                  } else if (var120 > var92) {
                     var77[var92]++;
                  } else {
                     var77[var120]++;
                  }
               }
            }

            for (int var93 = 0; var93 < var53; var93++) {
               for (int var121 = 0; var121 < var53; var121++) {
                  if (var77[var121] == var93) {
                     var13[var63[var121]].d(this.rd);
                  }
               }
            }

            for (int var94 = 0; var94 < var6.nplayers; var94++) {
               if (var12.hfix[var94] == var26) {
                  if (var13[var94].dist == 0) {
                     var13[var94].fcnt = 8;
                  } else {
                     var13[var94].fix = true;
                  }
               }

               if (var13[var94].fcnt == 7 || var13[var94].fcnt == 8) {
                  var13[var94] = new ContO(var4[var14[var94].cn], 0, 0, 0, 0);
                  var12.cntdest[var94] = 0;
               }

               var12.playh(var13[var94], var14[var94], var94, var26, var6.im);
            }

            if (var28 == 2 && var26 == 299) {
               this.u[0].enter = true;
            }

            if (!this.u[0].enter && !this.u[0].handb) {
               var6.levelhigh(var12.wasted, var12.whenwasted, var12.closefinish, var26, var3.stage);
               if (var26 == 0 || var26 == 1 || var26 == 2) {
                  this.rd.setColor(new Color(0, 0, 0));
                  this.rd.fillRect(0, 0, 800, 450);
               }

               if (var12.wasted != var6.im) {
                  if (var12.closefinish != 0) {
                     if (var12.closefinish == 1) {
                        if (var27 == 0) {
                           var1.around(var13[var6.im], false);
                        }

                        if (var27 > 0 && var27 < 20) {
                           var1.transaround(var13[var6.im], var13[var12.wasted], var27);
                        }

                        if (var27 == 20) {
                           var1.around(var13[var12.wasted], false);
                        }

                        if (var27 > 20 && var27 < 40) {
                           var1.transaround(var13[var12.wasted], var13[var6.im], var27 - 20);
                        }

                        if (var27 == 40) {
                           var1.around(var13[var6.im], false);
                        }

                        if (var27 > 40 && var27 < 60) {
                           var1.transaround(var13[var6.im], var13[var12.wasted], var27 - 40);
                        }

                        if (var27 == 60) {
                           var1.around(var13[var12.wasted], false);
                        }

                        if (var26 > 160 && var27 < 20) {
                           var27++;
                        }

                        if (var26 > 230 && var27 < 40) {
                           var27++;
                        }

                        if (var26 > 280 && var27 < 60) {
                           var27++;
                        }

                        if ((var27 == 0 || var27 == 20 || var27 == 40 || var27 == 60) && ++var26 == 300) {
                           var26 = 0;
                           var27 = 0;
                           var28++;
                        }
                     } else {
                        if (var27 == 0) {
                           var1.around(var13[var6.im], false);
                        }

                        if (var27 > 0 && var27 < 20) {
                           var1.transaround(var13[var6.im], var13[var12.wasted], var27);
                        }

                        if (var27 == 20) {
                           var1.around(var13[var12.wasted], false);
                        }

                        if (var27 > 20 && var27 < 40) {
                           var1.transaround(var13[var12.wasted], var13[var6.im], var27 - 20);
                        }

                        if (var27 == 40) {
                           var1.around(var13[var6.im], false);
                        }

                        if (var27 > 40 && var27 < 60) {
                           var1.transaround(var13[var6.im], var13[var12.wasted], var27 - 40);
                        }

                        if (var27 == 60) {
                           var1.around(var13[var12.wasted], false);
                        }

                        if (var27 > 60 && var27 < 80) {
                           var1.transaround(var13[var12.wasted], var13[var6.im], var27 - 60);
                        }

                        if (var27 == 80) {
                           var1.around(var13[var6.im], false);
                        }

                        if (var26 > 90 && var27 < 20) {
                           var27++;
                        }

                        if (var26 > 160 && var27 < 40) {
                           var27++;
                        }

                        if (var26 > 230 && var27 < 60) {
                           var27++;
                        }

                        if (var26 > 280 && var27 < 80) {
                           var27++;
                        }

                        if ((var27 == 0 || var27 == 20 || var27 == 40 || var27 == 60 || var27 == 80) && ++var26 == 300) {
                           var26 = 0;
                           var27 = 0;
                           var28++;
                        }
                     }
                  } else {
                     if (var27 == 9 || var27 == 11) {
                        this.rd.setColor(new Color(255, 255, 255));
                        this.rd.fillRect(0, 0, 800, 450);
                     }

                     if (var27 == 0) {
                        var1.around(var13[var6.im], false);
                     }

                     if (var27 > 0 && var27 < 20) {
                        var1.transaround(var13[var6.im], var13[var12.wasted], var27);
                     }

                     if (var27 == 20) {
                        var1.around(var13[var12.wasted], false);
                     }

                     if (var26 > var12.whenwasted && var27 != 20) {
                        var27++;
                     }

                     if ((var27 == 0 || var27 == 20) && ++var26 == 300) {
                        var26 = 0;
                        var27 = 0;
                        var28++;
                     }
                  }
               } else {
                  if (var29 == 67 && (var27 == 3 || var27 == 31 || var27 == 66)) {
                     this.rd.setColor(new Color(255, 255, 255));
                     this.rd.fillRect(0, 0, 800, 450);
                  }

                  if (var29 == 69 && (var27 == 3 || var27 == 5 || var27 == 31 || var27 == 33 || var27 == 66 || var27 == 68)) {
                     this.rd.setColor(new Color(255, 255, 255));
                     this.rd.fillRect(0, 0, 800, 450);
                  }

                  if (var29 == 30 && var27 >= 1 && var27 < 30) {
                     if (var27 % (int)(2.0F + var1.random() * 3.0F) == 0 && !var30) {
                        this.rd.setColor(new Color(255, 255, 255));
                        this.rd.fillRect(0, 0, 800, 450);
                        var30 = true;
                     } else {
                        var30 = false;
                     }
                  }

                  if (var26 > var12.whenwasted && var27 != var29) {
                     var27++;
                  }

                  var1.around(var13[var6.im], false);
                  if ((var27 == 0 || var27 == var29) && ++var26 == 300) {
                     var26 = 0;
                     var27 = 0;
                     var28++;
                  }
               }
            } else {
               var6.fase = -4;
               this.u[0].enter = false;
               this.u[0].handb = false;
               var26 = -7;
            }
         }

         if (var6.fase == -4) {
            if (var26 == 0) {
               var6.sendwin(var3);
               if (var6.winner
                  && var6.multion == 0
                  && var6.gmode != 0
                  && var3.stage != 27
                  && var3.stage == var6.unlocked[var6.gmode - 1] + (var6.gmode - 1) * 10) {
                  var6.unlocked[var6.gmode - 1]++;
                  this.setcarcookie(var6.sc[0], var5.names[var6.sc[0]], var6.arnp, var6.gmode, var6.unlocked, false);
                  var6.unlocked[var6.gmode - 1]--;
               }
            }

            if (var26 <= 0) {
               this.rd.drawImage(var6.mdness, 289, 30, null);
               this.rd.drawImage(var6.dude[0], 135, 10, null);
            }

            if (var26 >= 0) {
               var6.fleximage(this.offImage, var26, var3.stage);
            }

            if (++var26 == 7) {
               var6.fase = -5;
               this.rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
               this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            }
         }

         if (var6.fase == -6) {
            this.repaint();
            var6.pauseimage(this.offImage);
            var6.fase = -7;
            this.mouses = 0;
         }

         if (var6.fase == -7) {
            var6.pausedgame(var3.stage, this.u[0], var12);
            if (var26 != 0) {
               var26 = 0;
            }

            var6.ctachm(this.xm, this.ym, this.mouses, this.u[0]);
            if (this.mouses == 2) {
               this.mouses = 0;
            }

            if (this.mouses == 1) {
               this.mouses = 2;
            }
         }

         if (var6.fase == -8) {
            var6.cantreply();
            var26++;
            if (var26 == 150 || this.u[0].enter || this.u[0].handb || this.mouses == 1) {
               var6.fase = -7;
               this.mouses = 0;
               this.u[0].enter = false;
               this.u[0].handb = false;
            }
         }

         if (this.lostfcs && var6.fase == 7001) {
            if (this.fcscnt == 0) {
               if (this.u[0].chatup == 0) {
                  this.requestFocus();
               }

               this.fcscnt = 10;
            } else {
               this.fcscnt--;
            }
         }

         this.repaint();
         if (var6.im > -1 && var6.im < 8) {
            int var54 = 0;
            if (var6.multion == 2 || var6.multion == 3) {
               var54 = var6.im;
               this.u[var54].mutem = this.u[0].mutem;
               this.u[var54].mutes = this.u[0].mutes;
            }

            var6.playsounds(var14[var6.im], this.u[var54], var3.stage);
         }

         var16 = new Date();
         long var55 = var16.getTime();
         if (var6.fase != 0 && var6.fase != -1 && var6.fase != -3 && var6.fase != 7001) {
            if (var22) {
               var23 = 30;
               var40 = var21;
               var22 = false;
               var25 = 0;
            }

            if (var25 == 10) {
               if (var55 - var19 < 400L) {
                  var21 = (float)(var21 + 3.5);
               } else {
                  var21 = (float)(var21 - 3.5);
                  if (var21 < 5.0F) {
                     var21 = 5.0F;
                  }
               }

               var19 = var55;
               var25 = 0;
            } else {
               var25++;
            }
         } else {
            if (!var22) {
               var23 = 15;
               var21 = var40;
               if (var40 < 30.0F) {
                  var21 = 30.0F;
               }

               var22 = true;
               var25 = 0;
            }

            if (var25 == 10) {
               float var78 = (var24 + var11.freg - (float)(var55 - var19)) / 20.0F;
               if (var78 > 40.0F) {
                  var78 = 40.0F;
               }

               if (var78 < -40.0F) {
                  var78 = -40.0F;
               }

               var21 += var78;
               if (var21 < 5.0F) {
                  var21 = 5.0F;
               }

               var1.adjstfade(var21, var78, var6.starcnt, this);
               var19 = var55;
               var25 = 0;
            } else {
               var25++;
            }
         }

         if (this.exwist) {
            this.rd.dispose();
            var6.stopallnow();
            var5.stopallnow();
            var11.UDPquit();
            if (var10) {
               var8.stopallnow();
               var7.stopallnow();
               var9.stopallnow();
            }

            System.gc();
            if (Madness.endadv == 2) {
               Madness.advopen();
            }

            this.gamer.stop();
            this.gamer = null;
         }

         var17 = Math.round(var21) - (var55 - var31);
         if (var17 < var23) {
            var17 = var23;
         }

         try {
            Thread.sleep(var17);
         } catch (InterruptedException var39) {
         }
      }
   }

   public void checkmemory(xtGraphics var1) {
      if (this.applejava || Runtime.getRuntime().freeMemory() / 1048576L < 50L) {
         var1.badmac = true;
      }
   }

   @Override
   public void paint(Graphics var1) {
      Graphics2D var2 = (Graphics2D)var1;
      if (this.lastw != this.getWidth() || this.lasth != this.getHeight()) {
         this.lastw = this.getWidth();
         this.lasth = this.getHeight();
         this.showsize = 100;
         if (this.lastw <= 800 || this.lasth <= 550) {
            this.reqmult = 0.0F;
         }

         if (Madness.fullscreen) {
            this.apx = (int)(this.getWidth() / 2 - 400.0F * this.apmult);
            this.apy = (int)(this.getHeight() / 2 - 225.0F * this.apmult);
         }
      }

      int var3 = 0;
      int var4 = 0;
      if (this.moto == 1 && this.shaka > 0) {
         var3 = (int)((this.shaka * 2 * Math.random() - this.shaka) * this.apmult);
         var4 = (int)((this.shaka * 2 * Math.random() - this.shaka) * this.apmult);
         this.shaka--;
      }

      if (!Madness.fullscreen) {
         if (this.showsize != 0) {
            if (this.showsize == 100 || this.showsize == 70) {
               var2.clearRect(0, 0, this.getWidth(), this.getHeight());
            }

            float var5 = (this.getWidth() - 40) / 800.0F - 1.0F;
            if (var5 > (this.getHeight() - 70) / 450.0F - 1.0F) {
               var5 = (this.getHeight() - 70) / 450.0F - 1.0F;
            }

            if (var5 > 1.0F) {
               var5 = 1.0F;
            }

            if (var5 < 0.0F) {
               var5 = 0.0F;
            }

            this.apmult = 1.0F + var5 * this.reqmult;
            if (!this.oncarm) {
               var2.drawImage(this.carmaker[0], 50, 14, this);
            } else {
               var2.drawImage(this.carmaker[1], 50, 14, this);
            }

            if (!this.onstgm) {
               var2.drawImage(this.stagemaker[0], this.getWidth() - 208, 14, this);
            } else {
               var2.drawImage(this.stagemaker[1], this.getWidth() - 208, 14, this);
            }

            var2.drawImage(this.sizebar, this.getWidth() / 2 - 230, 23, this);
            var2.drawImage(this.blb, (int)(this.getWidth() / 2 - 222 + 141.0F * this.reqmult), 23, this);
            var2.drawImage(this.chkbx[this.smooth], this.getWidth() / 2 - 53, 23, this);
            var2.setFont(new Font("Arial", 1, 11));
            var2.setColor(new Color(74, 99, 125));
            var2.drawString("Screen Size:", this.getWidth() / 2 - 224, 17);
            var2.drawString("Smooth", this.getWidth() / 2 - 36, 34);
            var2.drawImage(this.fulls, this.getWidth() / 2 + 27, 15, this);
            var2.setColor(new Color(94, 126, 159));
            var2.drawString("Fullscreen", this.getWidth() / 2 + 63, 30);
            var2.drawImage(this.chkbx[Madness.anti], this.getWidth() / 2 + 135, 9, this);
            var2.drawString("Antialiasing", this.getWidth() / 2 + 152, 20);
            var2.drawImage(this.chkbx[this.moto], this.getWidth() / 2 + 135, 26, this);
            var2.drawString("Motion Effects", this.getWidth() / 2 + 152, 37);
            var2.setColor(new Color(0, 0, 0));
            var2.fillRect(this.getWidth() / 2 - 153, 5, 80, 16);
            var2.setColor(new Color(121, 135, 152));
            String var6 = "" + (int)(this.apmult * 100.0F) + "%";
            if (this.reqmult == 0.0F) {
               var6 = "Original";
            }

            if (this.reqmult == 1.0F) {
               var6 = "Maximum";
            }

            var2.drawString(var6, this.getWidth() / 2 - 150, 17);
            if (!this.oncarm && !this.onstgm) {
               this.showsize--;
            }

            if (this.showsize == 0) {
               var2.setColor(new Color(0, 0, 0));
               var2.fillRect(this.getWidth() / 2 - 260, 0, 520, 40);
               var2.fillRect(50, 14, 142, 23);
               var2.fillRect(this.getWidth() - 208, 14, 158, 23);
            }
         }

         this.apx = (int)(this.getWidth() / 2 - 400.0F * this.apmult);
         this.apy = (int)(this.getHeight() / 2 - 225.0F * this.apmult - 50.0F);
         if (this.apy < 50) {
            this.apy = 50;
         }

         if (this.apmult > 1.0F) {
            if (this.smooth == 1) {
               var2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
               if (this.moto == 1) {
                  var2.setComposite(AlphaComposite.getInstance(3, this.mvect / 100.0F));
                  this.rd.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED);
                  var2.drawImage(this.offImage, this.apx + var3, this.apy + var4, (int)(800.0F * this.apmult), (int)(450.0F * this.apmult), this);
                  this.cropit(var2, var3, var4);
               } else {
                  var2.drawImage(this.offImage, this.apx, this.apy, (int)(800.0F * this.apmult), (int)(450.0F * this.apmult), this);
               }
            } else if (this.moto == 1) {
               var2.setComposite(AlphaComposite.getInstance(3, this.mvect / 100.0F));
               this.rd.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED);
               var2.drawImage(this.offImage, this.apx + var3, this.apy + var4, (int)(800.0F * this.apmult), (int)(450.0F * this.apmult), this);
               this.cropit(var2, var3, var4);
            } else {
               var2.drawImage(this.offImage, this.apx, this.apy, (int)(800.0F * this.apmult), (int)(450.0F * this.apmult), this);
            }
         } else if (this.moto == 1) {
            var2.setComposite(AlphaComposite.getInstance(3, this.mvect / 100.0F));
            this.rd.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED);
            var2.drawImage(this.offImage, this.apx + var3, this.apy + var4, this);
            this.cropit(var2, var3, var4);
         } else {
            var2.drawImage(this.offImage, this.apx, this.apy, this);
         }
      } else if (this.moto == 1) {
         var2.setComposite(AlphaComposite.getInstance(3, this.mvect / 100.0F));
         this.rd.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED);
         var2.drawImage(this.offImage, this.apx + var3, this.apy + var4, this);
         this.cropit(var2, var3, var4);
      } else {
         var2.drawImage(this.offImage, this.apx, this.apy, this);
      }
   }

   public void cropit(Graphics2D var1, int var2, int var3) {
      if (var2 != 0 || var3 != 0) {
         var1.setComposite(AlphaComposite.getInstance(3, 1.0F));
         var1.setColor(new Color(0, 0, 0));
      }

      if (var2 != 0) {
         if (var2 < 0) {
            var1.fillRect(this.apx + var2, this.apy - (int)(25.0F * this.apmult), Math.abs(var2), (int)(500.0F * this.apmult));
         } else {
            var1.fillRect(this.apx + (int)(800.0F * this.apmult), this.apy - (int)(25.0F * this.apmult), var2, (int)(500.0F * this.apmult));
         }
      }

      if (var3 != 0) {
         if (var3 < 0) {
            var1.fillRect(this.apx - (int)(25.0F * this.apmult), this.apy + var3, (int)(850.0F * this.apmult), Math.abs(var3));
         } else {
            var1.fillRect(this.apx - (int)(25.0F * this.apmult), this.apy + (int)(450.0F * this.apmult), (int)(850.0F * this.apmult), var3);
         }
      }
   }

   @Override
   public void update(Graphics var1) {
      this.paint(var1);
   }

   @Override
   public void init() {
      this.setBackground(new Color(0, 0, 0));
      this.offImage = this.createImage(800, 450);
      if (this.offImage != null) {
         this.rd = (Graphics2D)this.offImage.getGraphics();
      }

      this.rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
      this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      this.setLayout(null);
      this.tnick = new TextField("Nickbname");
      this.tnick.setFont(new Font("Arial", 1, 13));
      this.tpass = new TextField("");
      this.tpass.setFont(new Font("Arial", 1, 13));
      this.tpass.setEchoCharacter('*');
      this.temail = new TextField("");
      this.temail.setFont(new Font("Arial", 1, 13));
      this.cmsg = new TextField("");
      if (System.getProperty("java.vendor").toLowerCase().indexOf("oracle") != -1) {
         this.cmsg.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent var1) {
            }

            @Override
            public void keyTyped(KeyEvent var1) {
            }

            @Override
            public void keyPressed(KeyEvent var1) {
               if (var1.getKeyCode() == 10 && GameSparker.this.u[0] != null) {
                  GameSparker.this.u[0].enter = true;
               }
            }
         });
      }

      this.mmsg = new TextArea("", 200, 20, 3);
      this.cmsg.setFont(new Font("Tahoma", 0, 11));
      this.mmsg.setFont(new Font("Tahoma", 0, 11));
      this.mycar = new Checkbox("Sword of Justice Game!");
      this.notp = new Checkbox("No Trees & Piles");
      this.keplo = new Checkbox("Stay logged in");
      this.keplo.setState(true);
      this.add(this.tnick);
      this.add(this.tpass);
      this.add(this.temail);
      this.add(this.cmsg);
      this.add(this.mmsg);
      this.add(this.mycar);
      this.add(this.notp);
      this.add(this.keplo);
      this.sgame.setFont(new Font("Arial", 1, 13));
      this.wgame.setFont(new Font("Arial", 1, 13));
      this.warb.setFont(new Font("Arial", 1, 13));
      this.pgame.setFont(new Font("Arial", 1, 12));
      this.vnpls.setFont(new Font("Arial", 1, 13));
      this.vtyp.setFont(new Font("Arial", 1, 13));
      this.snfmm.setFont(new Font("Arial", 1, 13));
      this.snfm1.setFont(new Font("Arial", 1, 13));
      this.snfm2.setFont(new Font("Arial", 1, 13));
      this.mstgs.setFont(new Font("Arial", 1, 13));
      this.mcars.setFont(new Font("Arial", 1, 13));
      this.slaps.setFont(new Font("Arial", 1, 13));
      this.snpls.setFont(new Font("Arial", 0, 13));
      this.snbts.setFont(new Font("Arial", 0, 13));
      this.swait.setFont(new Font("Arial", 0, 12));
      this.sclass.setFont(new Font("Arial", 1, 12));
      this.scars.setFont(new Font("Arial", 1, 12));
      this.sfix.setFont(new Font("Arial", 1, 12));
      this.mycar.setFont(new Font("Arial", 1, 12));
      this.notp.setFont(new Font("Arial", 1, 12));
      this.keplo.setFont(new Font("Arial", 1, 12));
      this.gmode.setFont(new Font("Arial", 1, 13));
      this.rooms.setFont(new Font("Arial", 1, 13));
      this.sendtyp.setFont(new Font("Arial", 1, 12));
      this.senditem.setFont(new Font("Arial", 1, 12));
      this.datat.setFont(new Font("Arial", 1, 12));
      this.clanlev.setFont(new Font("Arial", 1, 12));
      this.clcars.setFont(new Font("Arial", 1, 12));
      this.clcars.alphad = true;
      this.ilaps.setFont(new Font("Arial", 1, 13));
      this.icars.setFont(new Font("Arial", 1, 12));
      this.proitem.setFont(new Font("Arial", 1, 12));
      this.sgame.add(this.rd, " NFM 1     ");
      this.sgame.add(this.rd, " NFM 2     ");
      this.sgame.add(this.rd, " My Stages ");
      this.sgame.add(this.rd, " Weekly Top20 ");
      this.sgame.add(this.rd, " Monthly Top20 ");
      this.sgame.add(this.rd, " All Time Top20 ");
      this.sgame.add(this.rd, " Stage Maker ");
      this.wgame.add(this.rd, " Normal Game");
      this.wgame.add(this.rd, " War / Battle");
      this.wgame.add(this.rd, " War / Battle - Practice");
      this.warb.add(this.rd, " Loading your clan's wars and battles, please wait...");
      this.pgame.add(this.rd, " Select the game you want to practice");
      this.vnpls.add(this.rd, "Players");
      this.vnpls.add(this.rd, " 2 VS 2");
      this.vnpls.add(this.rd, " 3 VS 3");
      this.vnpls.add(this.rd, " 4 VS 4");
      this.vtyp.add(this.rd, "Normal clan game");
      this.vtyp.add(this.rd, "Racing only");
      this.vtyp.add(this.rd, "Wasting only");
      this.vtyp.add(this.rd, "Racers VS Wasters - my clan wastes");
      this.vtyp.add(this.rd, "Racers VS Wasters - my clan races");
      this.snfmm.add(this.rd, "Select Stage");
      this.snfm1.add(this.rd, "Select Stage");
      this.snfm2.add(this.rd, "Select Stage");
      this.mstgs.add(this.rd, "Suddenly the King becomes Santa's Little Helper");
      this.mcars.add(this.rd, "Sword of Justice");
      this.snpls.add(this.rd, "Select");
      this.swait.add(this.rd, "1 Minute");
      this.ilaps.add(this.rd, "Laps");
      this.ilaps.add(this.rd, "1 Lap");

      for (int var1 = 0; var1 < 5; var1++) {
         this.snfmm.add(this.rd, " Stage " + (var1 + 1) + "");
      }

      for (int var2 = 0; var2 < 10; var2++) {
         this.snfm1.add(this.rd, " Stage " + (var2 + 1) + "");
      }

      for (int var3 = 0; var3 < 17; var3++) {
         this.snfm2.add(this.rd, " Stage " + (var3 + 1) + "");
      }

      for (int var4 = 0; var4 < 7; var4++) {
         this.snpls.add(this.rd, "    " + (var4 + 2) + "");
      }

      for (int var5 = 0; var5 < 7; var5++) {
         this.snbts.add(this.rd, "    " + var5 + "    ");
      }

      for (int var6 = 0; var6 < 2; var6++) {
         this.swait.add(this.rd, "" + (var6 + 2) + " Minutes");
      }

      for (int var7 = 0; var7 < 15; var7++) {
         this.slaps.add(this.rd, "" + (var7 + 1) + "");
      }

      for (int var8 = 0; var8 < 14; var8++) {
         this.ilaps.add(this.rd, "" + (var8 + 2) + " Laps");
      }

      this.sclass.add(this.rd, "All Classes");
      this.sclass.add(this.rd, "Class C Cars");
      this.sclass.add(this.rd, "Class B & C Cars");
      this.sclass.add(this.rd, "Class B Cars");
      this.sclass.add(this.rd, "Class A & B Cars");
      this.sclass.add(this.rd, "Class A Cars");
      this.scars.add(this.rd, "All Cars");
      this.scars.add(this.rd, "Custom Cars");
      this.scars.add(this.rd, "Game Cars");
      this.sfix.add(this.rd, "Unlimited Fixing");
      this.sfix.add(this.rd, "4 Fixes");
      this.sfix.add(this.rd, "3 Fixes");
      this.sfix.add(this.rd, "2 Fixes");
      this.sfix.add(this.rd, "1 Fix");
      this.sfix.add(this.rd, "No Fixing");
      this.icars.add(this.rd, "Type of Cars");
      this.icars.add(this.rd, "All Cars");
      this.icars.add(this.rd, "Clan Cars");
      this.icars.add(this.rd, "Game Cars");
      this.icars.w = 140;
      this.gmode.add(this.rd, " Normal Game ");
      this.gmode.add(this.rd, " Practice Game ");
      this.rooms.rooms = true;
      this.rooms.add(this.rd, "Ghostrider :: 1");
      this.sendtyp.add(this.rd, "Write a Message");
      this.sendtyp.add(this.rd, "Share a Custom Car");
      this.sendtyp.add(this.rd, "Share a Custom Stage");
      this.sendtyp.add(this.rd, "Send a Clan Invitation");
      this.sendtyp.add(this.rd, "Share a Relative Date");
      this.senditem.add(this.rd, "Suddenly the King becomes Santa's Little Helper");

      for (int var9 = 0; var9 < 6; var9++) {
         this.clanlev.add(this.rd, "" + (var9 + 1) + "");
      }

      this.clanlev.add(this.rd, "7 - Admin");
      this.hidefields();
   }

   public void hidefields() {
      this.ilaps.hide();
      this.icars.hide();
      this.proitem.hide();
      this.clcars.hide();
      this.clanlev.hide();
      this.mmsg.hide();
      this.datat.hide();
      this.senditem.hide();
      this.sendtyp.hide();
      this.rooms.hide();
      this.mcars.hide();
      this.mstgs.hide();
      this.gmode.hide();
      this.sclass.hide();
      this.scars.hide();
      this.sfix.hide();
      this.mycar.hide();
      this.notp.hide();
      this.keplo.hide();
      this.tnick.hide();
      this.tpass.hide();
      this.temail.hide();
      this.cmsg.hide();
      this.sgame.hide();
      this.wgame.hide();
      this.pgame.hide();
      this.vnpls.hide();
      this.vtyp.hide();
      this.warb.hide();
      this.slaps.hide();
      this.snfm1.hide();
      this.snfmm.hide();
      this.snfm2.hide();
      this.snpls.hide();
      this.snbts.hide();
      this.swait.hide();
   }

   public void drawms() {
      this.openm = false;
      if (this.gmode.draw(this.rd, this.xm, this.ym, this.moused, 450, true)) {
         this.openm = true;
      }

      if (this.swait.draw(this.rd, this.xm, this.ym, this.moused, 450, false)) {
         this.openm = true;
      }

      if (this.slaps.draw(this.rd, this.xm, this.ym, this.moused, 450, false)) {
         this.openm = true;
      }

      if (this.snpls.draw(this.rd, this.xm, this.ym, this.moused, 450, false)) {
         this.openm = true;
      }

      if (this.snbts.draw(this.rd, this.xm, this.ym, this.moused, 450, false)) {
         this.openm = true;
      }

      if (this.scars.draw(this.rd, this.xm, this.ym, this.moused, 450, false)) {
         this.openm = true;
      }

      if (this.sgame.draw(this.rd, this.xm, this.ym, this.moused, 450, false)) {
         this.openm = true;
      }

      if (this.snfm1.draw(this.rd, this.xm, this.ym, this.moused, 450, false)) {
         this.openm = true;
      }

      if (this.snfm2.draw(this.rd, this.xm, this.ym, this.moused, 450, false)) {
         this.openm = true;
      }

      if (this.snfmm.draw(this.rd, this.xm, this.ym, this.moused, 450, false)) {
         this.openm = true;
      }

      if (this.mstgs.draw(this.rd, this.xm, this.ym, this.moused, 450, false)) {
         this.openm = true;
      }

      if (this.mcars.draw(this.rd, this.xm, this.ym, this.moused, 450, false)) {
         this.openm = true;
      }

      if (this.pgame.draw(this.rd, this.xm, this.ym, this.moused, 450, false)) {
         this.openm = true;
      }

      if (this.vnpls.draw(this.rd, this.xm, this.ym, this.moused, 450, false)) {
         this.openm = true;
      }

      if (this.vtyp.draw(this.rd, this.xm, this.ym, this.moused, 450, false)) {
         this.openm = true;
      }

      if (this.warb.draw(this.rd, this.xm, this.ym, this.moused, 450, false)) {
         this.openm = true;
      }

      if (this.wgame.draw(this.rd, this.xm, this.ym, this.moused, 450, false)) {
         this.openm = true;
      }

      if (this.rooms.draw(this.rd, this.xm, this.ym, this.moused, 450, false)) {
         this.openm = true;
      }

      if (this.sendtyp.draw(this.rd, this.xm, this.ym, this.moused, 450, true)) {
         this.openm = true;
      }

      if (this.senditem.draw(this.rd, this.xm, this.ym, this.moused, 450, true)) {
         this.openm = true;
      }

      if (this.datat.draw(this.rd, this.xm, this.ym, this.moused, 450, true)) {
         this.openm = true;
      }

      if (this.clanlev.draw(this.rd, this.xm, this.ym, this.moused, 450, false)) {
         this.openm = true;
      }

      if (this.clcars.draw(this.rd, this.xm, this.ym, this.moused, 450, false)) {
         this.openm = true;
      }

      if (this.ilaps.draw(this.rd, this.xm, this.ym, this.moused, 450, true)) {
         this.openm = true;
      }

      if (this.icars.draw(this.rd, this.xm, this.ym, this.moused, 450, true)) {
         this.openm = true;
      }

      if (this.proitem.draw(this.rd, this.xm, this.ym, this.moused, 450, false)) {
         this.openm = true;
      }

      if (this.sfix.draw(this.rd, this.xm, this.ym, this.moused, 450, false)) {
         this.openm = true;
      }

      if (this.sclass.draw(this.rd, this.xm, this.ym, this.moused, 450, false)) {
         this.openm = true;
      }
   }

   public void movefield(Component var1, int var2, int var3, int var4, int var5) {
      if (var4 != 360 && var4 != 576) {
         var2 = (int)(var2 * this.apmult + this.apx);
         var3 = (int)(var3 * this.apmult + this.apy + 12.0F * (this.apmult - 1.0F));
      } else {
         var2 = (int)(var2 * this.apmult + this.apx + var1.getWidth() / 2 * (this.apmult - 1.0F));
         var3 = (int)(var3 * this.apmult + this.apy + 12.0F * (this.apmult - 1.0F));
      }

      if (var1.getX() != var2 || var1.getY() != var3) {
         var1.setBounds(var2, var3, var4, var5);
      }
   }

   public void movefieldd(TextField var1, int var2, int var3, int var4, int var5, boolean var6) {
      if (this.applejava) {
         if (var6) {
            if ((this.xm <= var2 || this.xm >= var2 + var4 || this.ym <= var3 || this.ym >= var3 + var5) && var1.getText().equals("")) {
               if (var1.isShowing()) {
                  var1.hide();
                  this.requestFocus();
               }

               this.rd.setColor(var1.getBackground());
               this.rd.fillRect(var2, var3, var4 - 1, var5 - 1);
               this.rd.setColor(var1.getBackground().darker());
               this.rd.drawRect(var2, var3, var4 - 1, var5 - 1);
            } else {
               if (!var1.isShowing()) {
                  var1.show();
                  var1.requestFocus();
               }

               if (var4 != 360 && var4 != 576) {
                  var2 = (int)(var2 * this.apmult + this.apx);
                  var3 = (int)(var3 * this.apmult + this.apy + 12.0F * (this.apmult - 1.0F));
               } else {
                  var2 = (int)(var2 * this.apmult + this.apx + var1.getWidth() / 2 * (this.apmult - 1.0F));
                  var3 = (int)(var3 * this.apmult + this.apy + 12.0F * (this.apmult - 1.0F));
               }

               if (var1.getX() != var2 || var1.getY() != var3) {
                  var1.setBounds(var2, var3, var4, var5);
               }
            }
         }
      } else {
         if (var6 && !var1.isShowing()) {
            var1.show();
         }

         this.movefield(var1, var2, var3, var4, var5);
      }
   }

   public void movefielda(TextArea var1, int var2, int var3, int var4, int var5) {
      if (this.applejava) {
         if ((this.xm <= var2 || this.xm >= var2 + var4 || this.ym <= var3 || this.ym >= var3 + var5) && var1.getText().equals(" ")) {
            if (var1.isShowing()) {
               var1.hide();
               this.requestFocus();
            }

            this.rd.setColor(var1.getBackground());
            this.rd.fillRect(var2, var3, var4 - 1, var5 - 1);
            this.rd.setColor(var1.getBackground().darker());
            this.rd.drawRect(var2, var3, var4 - 1, var5 - 1);
         } else {
            if (!var1.isShowing()) {
               var1.show();
               var1.requestFocus();
            }

            if (var4 != 360 && var4 != 576) {
               var2 = (int)(var2 * this.apmult + this.apx);
               var3 = (int)(var3 * this.apmult + this.apy + 12.0F * (this.apmult - 1.0F));
            } else {
               var2 = (int)(var2 * this.apmult + this.apx + var1.getWidth() / 2 * (this.apmult - 1.0F));
               var3 = (int)(var3 * this.apmult + this.apy + 12.0F * (this.apmult - 1.0F));
            }

            if (var1.getX() != var2 || var1.getY() != var3) {
               var1.setBounds(var2, var3, var4, var5);
            }
         }
      } else {
         if (!var1.isShowing()) {
            var1.show();
         }

         this.movefield(var1, var2, var3, var4, var5);
      }
   }

   public void loadstage(ContO[] var1, ContO[] var2, Medium var3, Trackers var4, CheckPoints var5, xtGraphics var6, Mad[] var7, Record var8) {
      if (var6.testdrive == 2 || var6.testdrive == 4) {
         var6.nplayers = 1;
      }

      if (var6.gmode == 1) {
         var6.nplayers = 5;
         var6.xstart[4] = 0;
         var6.zstart[4] = 760;
      }

      var4.nt = 0;
      this.nob = var6.nplayers;
      this.notb = 0;
      var5.n = 0;
      var5.nsp = 0;
      var5.fn = 0;
      var5.trackname = "";
      var5.haltall = false;
      var5.wasted = 0;
      var5.catchfin = 0;
      var3.resdown = 0;
      var3.rescnt = 5;
      var3.lightson = false;
      var3.noelec = 0;
      var3.ground = 250;
      var3.trk = 0;
      this.view = 0;
      int var9 = 0;
      int var10 = 100;
      int var11 = 0;
      int var12 = 100;
      var6.newparts = false;
      String var14 = "";

      try {
         DataInputStream var15 = null;
         if (var6.multion == 0 && var5.stage != -2) {
            String var34 = "stages/" + var5.stage + "";
            if (var5.stage == -1) {
               var34 = "mystages/" + var5.name + "";
            }

            File var45 = new File("" + Madness.fpath + "" + var34 + ".txt");
            var15 = new DataInputStream(new FileInputStream(var45));
         } else if (var5.stage > 0) {
            URL var33 = new URL("http://multiplayer.needformadness.com/stages/" + var5.stage + ".txt");
            var15 = new DataInputStream(var33.openStream());
         } else {
            String var16 = "http://multiplayer.needformadness.com/tracks/" + var5.name + ".radq";
            var16 = var16.replace(' ', '_');
            URL var17 = new URL(var16);
            int var18 = var17.openConnection().getContentLength();
            DataInputStream var19 = new DataInputStream(var17.openStream());
            byte[] var20 = new byte[var18];
            var19.readFully(var20);
            ZipInputStream var21;
            if (var20[0] == 80 && var20[1] == 75 && var20[2] == 3) {
               var21 = new ZipInputStream(new ByteArrayInputStream(var20));
            } else {
               byte[] var22 = new byte[var18 - 40];

               for (int var23 = 0; var23 < var18 - 40; var23++) {
                  byte var24 = 20;
                  if (var23 >= 500) {
                     var24 = 40;
                  }

                  var22[var23] = var20[var23 + var24];
               }

               var21 = new ZipInputStream(new ByteArrayInputStream(var22));
            }

            ZipEntry var60 = var21.getNextEntry();
            int var61 = Integer.valueOf(var60.getName());
            byte[] var62 = new byte[var61];
            int var25 = 0;

            while (var61 > 0) {
               int var26 = var21.read(var62, var25, var61);
               var25 += var26;
               var61 -= var26;
            }

            var21.close();
            var19.close();
            var15 = new DataInputStream(new ByteArrayInputStream(var62));
         }

         String var13;
         while ((var13 = var15.readLine()) != null) {
            var14 = "" + var13.trim();
            if (var14.startsWith("snap")) {
               var3.setsnap(this.getint("snap", var14, 0), this.getint("snap", var14, 1), this.getint("snap", var14, 2));
            }

            if (var14.startsWith("sky")) {
               var3.setsky(this.getint("sky", var14, 0), this.getint("sky", var14, 1), this.getint("sky", var14, 2));
               var6.snap(var5.stage);
            }

            if (var14.startsWith("ground")) {
               var3.setgrnd(this.getint("ground", var14, 0), this.getint("ground", var14, 1), this.getint("ground", var14, 2));
            }

            if (var14.startsWith("polys")) {
               var3.setpolys(this.getint("polys", var14, 0), this.getint("polys", var14, 1), this.getint("polys", var14, 2));
            }

            if (var14.startsWith("fog")) {
               var3.setfade(this.getint("fog", var14, 0), this.getint("fog", var14, 1), this.getint("fog", var14, 2));
            }

            if (var14.startsWith("texture")) {
               var3.setexture(
                  this.getint("texture", var14, 0), this.getint("texture", var14, 1), this.getint("texture", var14, 2), this.getint("texture", var14, 3)
               );
            }

            if (var14.startsWith("clouds")) {
               var3.setcloads(
                  this.getint("clouds", var14, 0),
                  this.getint("clouds", var14, 1),
                  this.getint("clouds", var14, 2),
                  this.getint("clouds", var14, 3),
                  this.getint("clouds", var14, 4)
               );
            }

            if (var14.startsWith("density")) {
               var3.fogd = (this.getint("density", var14, 0) + 1) * 2 - 1;
               if (var3.fogd < 1) {
                  var3.fogd = 1;
               }

               if (var3.fogd > 30) {
                  var3.fogd = 30;
               }
            }

            if (var14.startsWith("fadefrom")) {
               var3.fadfrom(this.getint("fadefrom", var14, 0));
            }

            if (var14.startsWith("lightson")) {
               var3.lightson = true;
            }

            if (var14.startsWith("mountains")) {
               var3.mgen = this.getint("mountains", var14, 0);
            }

            if (var14.startsWith("set")) {
               int var35 = this.getint("set", var14, 0);
               if (var6.nplayers == 8) {
                  if (var35 == 47) {
                     var35 = 76;
                  }

                  if (var35 == 48) {
                     var35 = 77;
                  }
               }

               boolean var46 = true;
               if (var35 >= 65 && var35 <= 75 && var5.notb) {
                  var46 = false;
               }

               if (var46) {
                  if (var35 == 49 || var35 == 64 || var35 >= 56 && var35 <= 61) {
                     var6.newparts = true;
                  }

                  if ((var5.stage < 0 || var5.stage >= 28) && var35 >= 10 && var35 <= 25) {
                     var3.loadnew = true;
                  }

                  var35 += 46;
                  var1[this.nob] = new ContO(
                     var2[var35], this.getint("set", var14, 1), var3.ground - var2[var35].grat, this.getint("set", var14, 2), this.getint("set", var14, 3)
                  );
                  if (var14.indexOf(")p") != -1) {
                     var5.x[var5.n] = this.getint("set", var14, 1);
                     var5.z[var5.n] = this.getint("set", var14, 2);
                     var5.y[var5.n] = 0;
                     var5.typ[var5.n] = 0;
                     if (var14.indexOf(")pt") != -1) {
                        var5.typ[var5.n] = -1;
                     }

                     if (var14.indexOf(")pr") != -1) {
                        var5.typ[var5.n] = -2;
                     }

                     if (var14.indexOf(")po") != -1) {
                        var5.typ[var5.n] = -3;
                     }

                     if (var14.indexOf(")ph") != -1) {
                        var5.typ[var5.n] = -4;
                     }

                     if (var14.indexOf("out") != -1) {
                        System.out.println("out: " + var5.n);
                     }

                     var5.n++;
                     this.notb = this.nob + 1;
                  }

                  this.nob++;
                  if (var3.loadnew) {
                     var3.loadnew = false;
                  }
               }
            }

            if (var14.startsWith("chk")) {
               int var37 = this.getint("chk", var14, 0);
               var37 += 46;
               int var47 = var3.ground - var2[var37].grat;
               if (var37 == 110) {
                  var47 = this.getint("chk", var14, 4);
               }

               var1[this.nob] = new ContO(var2[var37], this.getint("chk", var14, 1), var47, this.getint("chk", var14, 2), this.getint("chk", var14, 3));
               var5.x[var5.n] = this.getint("chk", var14, 1);
               var5.z[var5.n] = this.getint("chk", var14, 2);
               var5.y[var5.n] = var47;
               if (this.getint("chk", var14, 3) == 0) {
                  var5.typ[var5.n] = 1;
               } else {
                  var5.typ[var5.n] = 2;
               }

               var5.pcs = var5.n++;
               var1[this.nob].checkpoint = var5.nsp + 1;
               var5.nsp++;
               this.nob++;
               this.notb = this.nob;
            }

            if (var5.nfix != 5 && var14.startsWith("fix")) {
               int var39 = this.getint("fix", var14, 0);
               var39 += 46;
               var1[this.nob] = new ContO(
                  var2[var39], this.getint("fix", var14, 1), this.getint("fix", var14, 3), this.getint("fix", var14, 2), this.getint("fix", var14, 4)
               );
               var5.fx[var5.fn] = this.getint("fix", var14, 1);
               var5.fz[var5.fn] = this.getint("fix", var14, 2);
               var5.fy[var5.fn] = this.getint("fix", var14, 3);
               var1[this.nob].elec = true;
               if (this.getint("fix", var14, 4) != 0) {
                  var5.roted[var5.fn] = true;
                  var1[this.nob].roted = true;
               } else {
                  var5.roted[var5.fn] = false;
               }

               if (var14.indexOf(")s") != -1) {
                  var5.special[var5.fn] = true;
               } else {
                  var5.special[var5.fn] = false;
               }

               var5.fn++;
               this.nob++;
               this.notb = this.nob;
            }

            if (!var5.notb && var14.startsWith("pile")) {
               var1[this.nob] = new ContO(
                  this.getint("pile", var14, 0),
                  this.getint("pile", var14, 1),
                  this.getint("pile", var14, 2),
                  var3,
                  var4,
                  this.getint("pile", var14, 3),
                  this.getint("pile", var14, 4),
                  var3.ground
               );
               this.nob++;
            }

            if (var6.multion == 0 && var14.startsWith("nlaps")) {
               var5.nlaps = this.getint("nlaps", var14, 0);
               if (var5.nlaps < 1) {
                  var5.nlaps = 1;
               }

               if (var5.nlaps > 15) {
                  var5.nlaps = 15;
               }
            }

            if (var5.stage > 0 && var14.startsWith("name")) {
               var5.name = this.getstring("name", var14, 0).replace('|', ',');
            }

            if (var14.startsWith("stagemaker")) {
               var5.maker = this.getstring("stagemaker", var14, 0);
            }

            if (var14.startsWith("publish")) {
               var5.pubt = this.getint("publish", var14, 0);
            }

            if (var14.startsWith("soundtrack")) {
               var5.trackname = this.getstring("soundtrack", var14, 0);
               var5.trackvol = this.getint("soundtrack", var14, 1);
               if (var5.trackvol < 50) {
                  var5.trackvol = 50;
               }

               if (var5.trackvol > 300) {
                  var5.trackvol = 300;
               }

               var6.sndsize[32] = this.getint("soundtrack", var14, 2);
            }

            if (var14.startsWith("maxr")) {
               int var41 = this.getint("maxr", var14, 0);
               int var48 = this.getint("maxr", var14, 1);
               var9 = var48;
               int var52 = this.getint("maxr", var14, 2);

               for (int var56 = 0; var56 < var41; var56++) {
                  var1[this.nob] = new ContO(var2[85], var48, var3.ground - var2[85].grat, var56 * 4800 + var52, 0);
                  this.nob++;
               }

               var4.y[var4.nt] = -5000;
               var4.rady[var4.nt] = 7100;
               var4.x[var4.nt] = var48 + 500;
               var4.radx[var4.nt] = 600;
               var4.z[var4.nt] = var41 * 4800 / 2 + var52 - 2400;
               var4.radz[var4.nt] = var41 * 4800 / 2;
               var4.xy[var4.nt] = 90;
               var4.zy[var4.nt] = 0;
               var4.dam[var4.nt] = 167;
               var4.decor[var4.nt] = false;
               var4.skd[var4.nt] = 0;
               var4.nt++;
            }

            if (var14.startsWith("maxl")) {
               int var42 = this.getint("maxl", var14, 0);
               int var49 = this.getint("maxl", var14, 1);
               var10 = var49;
               int var53 = this.getint("maxl", var14, 2);

               for (int var57 = 0; var57 < var42; var57++) {
                  var1[this.nob] = new ContO(var2[85], var49, var3.ground - var2[85].grat, var57 * 4800 + var53, 180);
                  this.nob++;
               }

               var4.y[var4.nt] = -5000;
               var4.rady[var4.nt] = 7100;
               var4.x[var4.nt] = var49 - 500;
               var4.radx[var4.nt] = 600;
               var4.z[var4.nt] = var42 * 4800 / 2 + var53 - 2400;
               var4.radz[var4.nt] = var42 * 4800 / 2;
               var4.xy[var4.nt] = -90;
               var4.zy[var4.nt] = 0;
               var4.dam[var4.nt] = 167;
               var4.decor[var4.nt] = false;
               var4.skd[var4.nt] = 0;
               var4.nt++;
            }

            if (var14.startsWith("maxt")) {
               int var43 = this.getint("maxt", var14, 0);
               int var50 = this.getint("maxt", var14, 1);
               var11 = var50;
               int var54 = this.getint("maxt", var14, 2);

               for (int var58 = 0; var58 < var43; var58++) {
                  var1[this.nob] = new ContO(var2[85], var58 * 4800 + var54, var3.ground - var2[85].grat, var50, 90);
                  this.nob++;
               }

               var4.y[var4.nt] = -5000;
               var4.rady[var4.nt] = 7100;
               var4.z[var4.nt] = var50 + 500;
               var4.radz[var4.nt] = 600;
               var4.x[var4.nt] = var43 * 4800 / 2 + var54 - 2400;
               var4.radx[var4.nt] = var43 * 4800 / 2;
               var4.zy[var4.nt] = 90;
               var4.xy[var4.nt] = 0;
               var4.dam[var4.nt] = 167;
               var4.decor[var4.nt] = false;
               var4.skd[var4.nt] = 0;
               var4.nt++;
            }

            if (var14.startsWith("maxb")) {
               int var44 = this.getint("maxb", var14, 0);
               int var51 = this.getint("maxb", var14, 1);
               var12 = var51;
               int var55 = this.getint("maxb", var14, 2);

               for (int var59 = 0; var59 < var44; var59++) {
                  var1[this.nob] = new ContO(var2[85], var59 * 4800 + var55, var3.ground - var2[85].grat, var51, -90);
                  this.nob++;
               }

               var4.y[var4.nt] = -5000;
               var4.rady[var4.nt] = 7100;
               var4.z[var4.nt] = var51 - 500;
               var4.radz[var4.nt] = 600;
               var4.x[var4.nt] = var44 * 4800 / 2 + var55 - 2400;
               var4.radx[var4.nt] = var44 * 4800 / 2;
               var4.zy[var4.nt] = -90;
               var4.xy[var4.nt] = 0;
               var4.dam[var4.nt] = 167;
               var4.decor[var4.nt] = false;
               var4.skd[var4.nt] = 0;
               var4.nt++;
            }
         }

         var15.close();
         var3.newpolys(var10, var9 - var10, var12, var11 - var12, var4, this.notb);
         var3.newclouds(var10, var9, var12, var11);
         var3.newmountains(var10, var9, var12, var11);
         var3.newstars();
         var4.devidetrackers(var10, var9 - var10, var12, var11 - var12);
      } catch (Exception var27) {
         var5.stage = -3;
         System.out.println("Error in stage " + var5.stage);
         System.out.println("" + var27);
         System.out.println("At line: " + var14);
      }

      if (var5.nsp < 2) {
         var5.stage = -3;
      }

      if (var3.nrw * var3.ncl >= 16000) {
         var5.stage = -3;
      }

      if (var5.stage != -3) {
         var5.top20 = Math.abs(var5.top20);
         if (var5.stage == 26) {
            var3.lightn = 0;
         } else {
            var3.lightn = -1;
         }

         if (var5.stage != 1 && var5.stage != 11) {
            var3.nochekflk = true;
         } else {
            var3.nochekflk = false;
         }

         for (int var29 = 0; var29 < var6.nplayers; var29++) {
            this.u[var29].reset(var5, var6.sc[var29]);
         }

         var6.resetstat(var5.stage);
         var5.calprox();

         for (int var30 = 0; var30 < var6.nplayers; var30++) {
            if (var6.fase == 22) {
               var6.colorCar(var2[var6.sc[var30]], var30);
            }

            var1[var30] = new ContO(var2[var6.sc[var30]], var6.xstart[var30], 250 - var2[var6.sc[var30]].grat, var6.zstart[var30], 0);
            var7[var30].reseto(var6.sc[var30], var1[var30], var5);
         }

         if (var6.fase == 2 || var6.fase == -22) {
            var3.trx = (var10 + var9) / 2;
            var3.trz = (var11 + var12) / 2;
            var3.ptr = 0;
            var3.ptcnt = -10;
            var3.hit = 45000;
            var3.fallen = 0;
            var3.nrnd = 0;
            var3.trk = 1;
            var3.ih = 25;
            var3.iw = 65;
            var3.h = 425;
            var3.w = 735;
            var6.fase = 1;
            this.mouses = 0;
         }

         if (var6.fase == 22) {
            var3.crs = false;
            var6.fase = 5;
         }

         if (var5.stage > 0) {
            int var31 = var5.stage;
            if (var31 > 27) {
               var31 -= 27;
            } else if (var31 > 10) {
               var31 -= 10;
            }

            var6.asay = "Stage " + var31 + ":  " + var5.name + " ";
         } else {
            var6.asay = "Custom Stage:  " + var5.name + " ";
         }

         var8.reset(var1);
      } else if (var6.fase == 2) {
         var6.fase = 1;
      }

      System.gc();
   }

   public boolean loadstagePreview(int var1, String var2, ContO[] var3, ContO[] var4, Medium var5, CheckPoints var6) {
      boolean var7 = true;
      if (var1 < 100) {
         var6.stage = var1;
         if (var6.stage < 0) {
            var6.name = var2;
         }
      } else {
         var6.stage = -2;
         if (this.sgame.getSelectedIndex() != 3 && this.sgame.getSelectedIndex() != 4) {
            int var8 = this.mstgs.getSelectedItem().indexOf(" ") + 1;
            if (var8 > 0) {
               var6.name = this.mstgs.getSelectedItem().substring(var8);
            }
         } else {
            var6.name = this.mstgs.getSelectedItem();
         }
      }

      this.nob = 0;
      var6.n = 0;
      var6.nsp = 0;
      var6.fn = 0;
      var6.haltall = false;
      var6.wasted = 0;
      var6.catchfin = 0;
      var5.ground = 250;
      this.view = 0;
      var5.trx = 0L;
      var5.trz = 0L;
      int var27 = 0;
      int var9 = 100;
      int var10 = 0;
      int var11 = 100;
      String var13 = "";

      try {
         DataInputStream var14 = null;
         if (var6.stage > 0) {
            URL var30 = new URL("http://multiplayer.needformadness.com/stages/" + var6.stage + ".txt");
            var14 = new DataInputStream(var30.openStream());
         } else {
            String var15 = "http://multiplayer.needformadness.com/tracks/" + var6.name + ".radq";
            var15 = var15.replace(' ', '_');
            URL var16 = new URL(var15);
            int var17 = var16.openConnection().getContentLength();
            DataInputStream var18 = new DataInputStream(var16.openStream());
            byte[] var19 = new byte[var17];
            var18.readFully(var19);
            ZipInputStream var20;
            if (var19[0] == 80 && var19[1] == 75 && var19[2] == 3) {
               var20 = new ZipInputStream(new ByteArrayInputStream(var19));
            } else {
               byte[] var21 = new byte[var17 - 40];

               for (int var22 = 0; var22 < var17 - 40; var22++) {
                  byte var23 = 20;
                  if (var22 >= 500) {
                     var23 = 40;
                  }

                  var21[var22] = var19[var22 + var23];
               }

               var20 = new ZipInputStream(new ByteArrayInputStream(var21));
            }

            ZipEntry var42 = var20.getNextEntry();
            int var43 = Integer.valueOf(var42.getName());
            byte[] var44 = new byte[var43];
            int var24 = 0;

            while (var43 > 0) {
               int var25 = var20.read(var44, var24, var43);
               var24 += var25;
               var43 -= var25;
            }

            var20.close();
            var18.close();
            var14 = new DataInputStream(new ByteArrayInputStream(var44));
         }

         String var12;
         while ((var12 = var14.readLine()) != null) {
            var13 = "" + var12.trim();
            if (var13.startsWith("snap")) {
               var5.setsnap(this.getint("snap", var13, 0), this.getint("snap", var13, 1), this.getint("snap", var13, 2));
            }

            if (var13.startsWith("sky")) {
               var5.setsky(this.getint("sky", var13, 0), this.getint("sky", var13, 1), this.getint("sky", var13, 2));
            }

            if (var13.startsWith("ground")) {
               var5.setgrnd(this.getint("ground", var13, 0), this.getint("ground", var13, 1), this.getint("ground", var13, 2));
            }

            if (var13.startsWith("polys")) {
               var5.setpolys(this.getint("polys", var13, 0), this.getint("polys", var13, 1), this.getint("polys", var13, 2));
            }

            if (var13.startsWith("fog")) {
               var5.setfade(this.getint("fog", var13, 0), this.getint("fog", var13, 1), this.getint("fog", var13, 2));
            }

            if (var13.startsWith("texture")) {
               var5.setexture(
                  this.getint("texture", var13, 0), this.getint("texture", var13, 1), this.getint("texture", var13, 2), this.getint("texture", var13, 3)
               );
            }

            if (var13.startsWith("clouds")) {
               var5.setcloads(
                  this.getint("clouds", var13, 0),
                  this.getint("clouds", var13, 1),
                  this.getint("clouds", var13, 2),
                  this.getint("clouds", var13, 3),
                  this.getint("clouds", var13, 4)
               );
            }

            if (var13.startsWith("density")) {
               var5.fogd = (this.getint("density", var13, 0) + 1) * 2 - 1;
               if (var5.fogd < 1) {
                  var5.fogd = 1;
               }

               if (var5.fogd > 30) {
                  var5.fogd = 30;
               }
            }

            if (var13.startsWith("fadefrom")) {
               var5.fadfrom(this.getint("fadefrom", var13, 0));
            }

            if (var13.startsWith("lightson")) {
               var5.lightson = true;
            }

            if (var13.startsWith("mountains")) {
               var5.mgen = this.getint("mountains", var13, 0);
            }

            if (var13.startsWith("soundtrack")) {
               var6.trackname = this.getstring("soundtrack", var13, 0);
               var6.trackvol = this.getint("soundtrack", var13, 1);
               if (var6.trackvol < 50) {
                  var6.trackvol = 50;
               }

               if (var6.trackvol > 300) {
                  var6.trackvol = 300;
               }
            }

            if (var13.startsWith("set")) {
               int var31 = this.getint("set", var13, 0);
               var31 += 46;
               var3[this.nob] = new ContO(
                  var4[var31], this.getint("set", var13, 1), var5.ground - var4[var31].grat, this.getint("set", var13, 2), this.getint("set", var13, 3)
               );
               var3[this.nob].t.nt = 0;
               if (var13.indexOf(")p") != -1) {
                  var6.x[var6.n] = this.getint("chk", var13, 1);
                  var6.z[var6.n] = this.getint("chk", var13, 2);
                  var6.y[var6.n] = 0;
                  var6.typ[var6.n] = 0;
                  if (var13.indexOf(")pt") != -1) {
                     var6.typ[var6.n] = -1;
                  }

                  if (var13.indexOf(")pr") != -1) {
                     var6.typ[var6.n] = -2;
                  }

                  if (var13.indexOf(")po") != -1) {
                     var6.typ[var6.n] = -3;
                  }

                  if (var13.indexOf(")ph") != -1) {
                     var6.typ[var6.n] = -4;
                  }

                  if (var13.indexOf("out") != -1) {
                     System.out.println("out: " + var6.n);
                  }

                  var6.n++;
               }

               this.nob++;
            }

            if (var13.startsWith("chk")) {
               int var33 = this.getint("chk", var13, 0);
               var33 += 46;
               int var41 = var5.ground - var4[var33].grat;
               if (var33 == 110) {
                  var41 = this.getint("chk", var13, 4);
               }

               var3[this.nob] = new ContO(var4[var33], this.getint("chk", var13, 1), var41, this.getint("chk", var13, 2), this.getint("chk", var13, 3));
               var6.x[var6.n] = this.getint("chk", var13, 1);
               var6.z[var6.n] = this.getint("chk", var13, 2);
               var6.y[var6.n] = var41;
               if (this.getint("chk", var13, 3) == 0) {
                  var6.typ[var6.n] = 1;
               } else {
                  var6.typ[var6.n] = 2;
               }

               var6.pcs = var6.n++;
               var3[this.nob].checkpoint = var6.nsp + 1;
               var6.nsp++;
               this.nob++;
            }

            if (var13.startsWith("fix")) {
               int var35 = this.getint("fix", var13, 0);
               var35 += 46;
               var3[this.nob] = new ContO(
                  var4[var35], this.getint("fix", var13, 1), this.getint("fix", var13, 3), this.getint("fix", var13, 2), this.getint("fix", var13, 4)
               );
               var6.fx[var6.fn] = this.getint("fix", var13, 1);
               var6.fz[var6.fn] = this.getint("fix", var13, 2);
               var6.fy[var6.fn] = this.getint("fix", var13, 3);
               var3[this.nob].elec = true;
               if (this.getint("fix", var13, 4) != 0) {
                  var6.roted[var6.fn] = true;
                  var3[this.nob].roted = true;
               } else {
                  var6.roted[var6.fn] = false;
               }

               if (var13.indexOf(")s") != -1) {
                  var6.special[var6.fn] = true;
               } else {
                  var6.special[var6.fn] = false;
               }

               var6.fn++;
               this.nob++;
            }

            if (var13.startsWith("nlaps")) {
               var6.nlaps = this.getint("nlaps", var13, 0);
               if (var6.nlaps < 1) {
                  var6.nlaps = 1;
               }

               if (var6.nlaps > 15) {
                  var6.nlaps = 15;
               }
            }

            if (var6.stage > 0 && var13.startsWith("name")) {
               var6.name = this.getstring("name", var13, 0).replace('|', ',');
            }

            if (var13.startsWith("stagemaker")) {
               var6.maker = this.getstring("stagemaker", var13, 0);
            }

            if (var13.startsWith("publish")) {
               var6.pubt = this.getint("publish", var13, 0);
            }

            if (var13.startsWith("maxr")) {
               int var37 = this.getint("maxr", var13, 1);
               var27 = var37;
            }

            if (var13.startsWith("maxl")) {
               int var38 = this.getint("maxl", var13, 1);
               var9 = var38;
            }

            if (var13.startsWith("maxt")) {
               int var39 = this.getint("maxt", var13, 1);
               var10 = var39;
            }

            if (var13.startsWith("maxb")) {
               int var40 = this.getint("maxb", var13, 1);
               var11 = var40;
            }
         }

         var14.close();
         var5.newpolys(var9, var27 - var9, var11, var10 - var11, null, this.notb);
         var5.newclouds(var9, var27, var11, var10);
         var5.newmountains(var9, var27, var11, var10);
         var5.newstars();
      } catch (Exception var26) {
         var7 = false;
         System.out.println("Error in stage " + var6.stage);
         System.out.println("" + var26);
         System.out.println("At line: " + var13);
      }

      if (var6.nsp < 2) {
         var7 = false;
      }

      if (var5.nrw * var5.ncl >= 16000) {
         var7 = false;
      }

      var5.trx = (var9 + var27) / 2;
      var5.trz = (var10 + var11) / 2;
      System.gc();
      return var7;
   }

   public void loadbase(ContO[] var1, Medium var2, Trackers var3, xtGraphics var4, boolean var5) {
      String[] var6 = new String[]{
         "2000tornados",
         "formula7",
         "canyenaro",
         "lescrab",
         "nimi",
         "maxrevenge",
         "leadoxide",
         "koolkat",
         "drifter",
         "policecops",
         "mustang",
         "king",
         "audir8",
         "masheen",
         "radicalone",
         "drmonster"
      };
      String[] var7 = new String[]{
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
         "soffroad",
         "tside",
         "launchpad",
         "thenet",
         "speedramp",
         "offhill",
         "slider",
         "uphill",
         "roll1",
         "roll2",
         "roll3",
         "roll4",
         "roll5",
         "roll6",
         "opile1",
         "opile2",
         "aircheckpoint",
         "tree1",
         "tree2",
         "tree3",
         "tree4",
         "tree5",
         "tree6",
         "tree7",
         "tree8",
         "cac1",
         "cac2",
         "cac3",
         "8sroad",
         "8soffroad"
      };
      int var8 = 0;
      var4.dnload += 6;

      try {
         ZipInputStream var9 = null;
         if (!var5) {
            File var10 = new File("" + Madness.fpath + "data/models.zip");
            var9 = new ZipInputStream(new FileInputStream(var10));
         } else {
            URL var18 = new URL("http://multiplayer.needformadness.com/data/models.zip");
            var9 = new ZipInputStream(var18.openStream());
         }

         ZipEntry var19 = var9.getNextEntry();

         for (Object var11 = null; var19 != null; var19 = var9.getNextEntry()) {
            int var12 = 0;

            for (int var13 = 0; var13 < 16; var13++) {
               if (var19.getName().startsWith(var6[var13])) {
                  var12 = var13;
               }
            }

            for (int var21 = 0; var21 < 68; var21++) {
               if (var19.getName().startsWith(var7[var21])) {
                  var12 = var21 + 56;
               }
            }

            int var22 = (int)var19.getSize();
            var8 += var22;
            var11 = new byte[var22];
            int var14 = 0;

            while (var22 > 0) {
               int var15 = var9.read((byte[])var11, var14, var22);
               var14 += var15;
               var22 -= var15;
            }

            var1[var12] = new ContO((byte[])var11, var2, var3);
            var4.dnload++;
         }

         var9.close();
      } catch (Exception var16) {
         System.out.println("Error Reading Models: " + var16);
      }

      System.gc();
      if (this.mload != -1 && var8 != 615671) {
         this.mload = 2;
      }
   }

   public int getint(String var1, String var2, int var3) {
      int var5 = 0;
      String var7 = "";

      for (int var4 = var1.length() + 1; var4 < var2.length(); var4++) {
         String var6 = "" + var2.charAt(var4);
         if (var6.equals(",") || var6.equals(")")) {
            var5++;
            var4++;
         }

         if (var5 == var3) {
            var7 = var7 + var2.charAt(var4);
         }
      }

      return Integer.valueOf(var7);
   }

   public String getstring(String var1, String var2, int var3) {
      int var5 = 0;
      String var7 = "";

      for (int var4 = var1.length() + 1; var4 < var2.length(); var4++) {
         String var6 = "" + var2.charAt(var4);
         if (var6.equals(",") || var6.equals(")")) {
            var5++;
            var4++;
         }

         if (var5 == var3) {
            var7 = var7 + var2.charAt(var4);
         }
      }

      return var7;
   }

   @Override
   public void start() {
      if (this.gamer == null) {
         this.gamer = new Thread(this);
      }

      this.gamer.start();
   }

   @Override
   public void stop() {
      if (this.exwist && this.gamer != null) {
         System.gc();
         this.gamer.stop();
         this.gamer = null;
      }

      this.exwist = true;
   }

   public void setcarcookie(int var1, String var2, float[] var3, int var4, int[] var5, boolean var6) {
      try {
         File var7 = new File("" + datapath + "data/user.data");
         String[] var8 = new String[]{"", "", "", "", ""};
         if (var7.exists()) {
            BufferedReader var9 = new BufferedReader(new FileReader(var7));
            Object var10 = null;

            for (int var11 = 0; (var10 = var9.readLine()) != null && var11 < 5; var11++) {
               var8[var11] = (String)var10;
            }

            var9.close();
            Object var13 = null;
         }

         if (var4 == 0) {
            var8[1] = "lastcar("
               + var1
               + ","
               + (int)(var3[0] * 100.0F)
               + ","
               + (int)(var3[1] * 100.0F)
               + ","
               + (int)(var3[2] * 100.0F)
               + ","
               + (int)(var3[3] * 100.0F)
               + ","
               + (int)(var3[4] * 100.0F)
               + ","
               + (int)(var3[5] * 100.0F)
               + ","
               + var2
               + ")";
         }

         if (var4 == 1) {
            var8[2] = "NFM1(" + var1 + "," + var5[0] + ")";
         }

         if (var4 == 2) {
            var8[3] = "NFM2(" + var1 + "," + var5[1] + ")";
         }

         var8[4] = "graphics(" + this.moto + "," + Madness.anti + ")";
         BufferedWriter var14 = new BufferedWriter(new FileWriter(var7));

         for (int var17 = 0; var17 < 5; var17++) {
            var14.write(var8[var17]);
            var14.newLine();
         }

         var14.close();
         Object var15 = null;
      } catch (Exception var12) {
      }
   }

   public void setloggedcookie() {
      try {
         File var1 = new File("" + datapath + "data/user.data");
         String[] var2 = new String[]{"", "", "", "", ""};
         if (var1.exists()) {
            BufferedReader var3 = new BufferedReader(new FileReader(var1));
            Object var4 = null;

            for (int var5 = 0; (var4 = var3.readLine()) != null && var5 < 5; var5++) {
               var2[var5] = (String)var4;
            }

            var3.close();
            Object var7 = null;
         }

         if (this.keplo.getState()) {
            var2[0] = "lastuser(" + this.tnick.getText() + "," + this.tpass.getText() + ")";
         } else {
            var2[0] = "lastuser(" + this.tnick.getText() + ")";
         }

         BufferedWriter var8 = new BufferedWriter(new FileWriter(var1));

         for (int var11 = 0; var11 < 5; var11++) {
            var8.write(var2[var11]);
            var8.newLine();
         }

         var8.close();
         Object var9 = null;
      } catch (Exception var6) {
      }
   }

   public void readcookies(xtGraphics var1, CarDefine var2, ContO[] var3) {
      var1.nickname = "";

      try {
         File var4 = new File("" + datapath + "data/user.data");
         String[] var5 = new String[]{"", "", "", "", ""};
         if (var4.exists()) {
            BufferedReader var6 = new BufferedReader(new FileReader(var4));
            Object var7 = null;

            for (int var8 = 0; (var7 = var6.readLine()) != null && var8 < 5; var8++) {
               var5[var8] = (String)var7;
            }

            var6.close();
            Object var13 = null;
         }

         if (var5[0].startsWith("lastuser")) {
            var1.nickname = this.getstring("lastuser", var5[0], 0);
            if (!var1.nickname.equals("")) {
               var1.opselect = 1;
            }

            String var14 = "";

            try {
               var14 = this.getstring("lastuser", var5[0], 1);
            } catch (Exception var11) {
               var14 = "";
            }

            if (!var14.equals("")) {
               this.tnick.setText(var1.nickname);
               this.tpass.setText(var14);
               var1.autolog = true;
            }
         }

         if (var5[2].startsWith("NFM1")) {
            int var16 = this.getint("NFM1", var5[2], 0);
            if (var16 >= 0 && var16 < 16) {
               var1.scm[0] = var16;
               var1.firstime = false;
            }

            var16 = this.getint("NFM1", var5[2], 1);
            if (var16 >= 1 && var16 <= 11) {
               var1.unlocked[0] = var16;
            }
         }

         if (var5[3].startsWith("NFM2")) {
            int var18 = this.getint("NFM2", var5[3], 0);
            if (var18 >= 0 && var18 < 16) {
               var1.scm[1] = var18;
               var1.firstime = false;
            }

            var18 = this.getint("NFM2", var5[3], 1);
            if (var18 >= 1 && var18 <= 17) {
               var1.unlocked[1] = var18;
            }
         }

         if (var5[4].startsWith("graphics")) {
            int var20 = this.getint("graphics", var5[4], 0);
            if (var20 >= 0 && var20 <= 1) {
               this.moto = var20;
            }

            var20 = this.getint("graphics", var5[4], 1);
            if (var20 >= 0 && var20 <= 1) {
               Madness.anti = var20;
            }
         }

         if (var5[1].startsWith("lastcar")) {
            int var22 = this.getint("lastcar", var5[1], 0);
            var2.lastcar = this.getstring("lastcar", var5[1], 7);
            if (var22 >= 0 && var22 < 36) {
               var1.osc = var22;
               var1.firstime = false;
            }

            int var25 = 0;

            for (int var26 = 0; var26 < 6; var26++) {
               var22 = this.getint("lastcar", var5[1], var26 + 1);
               if (var22 >= 0 && var22 <= 100) {
                  var1.arnp[var26] = var22 / 100.0F;
                  var25++;
               }
            }

            if (var25 == 6 && var1.osc >= 0 && var1.osc <= 15) {
               Color var27 = Color.getHSBColor(var1.arnp[0], var1.arnp[1], 1.0F - var1.arnp[2]);
               Color var9 = Color.getHSBColor(var1.arnp[3], var1.arnp[4], 1.0F - var1.arnp[5]);

               for (int var10 = 0; var10 < var3[var1.osc].npl; var10++) {
                  if (var3[var1.osc].p[var10].colnum == 1) {
                     var3[var1.osc].p[var10].c[0] = var27.getRed();
                     var3[var1.osc].p[var10].c[1] = var27.getGreen();
                     var3[var1.osc].p[var10].c[2] = var27.getBlue();
                  }
               }

               for (int var28 = 0; var28 < var3[var1.osc].npl; var28++) {
                  if (var3[var1.osc].p[var28].colnum == 2) {
                     var3[var1.osc].p[var28].c[0] = var9.getRed();
                     var3[var1.osc].p[var28].c[1] = var9.getGreen();
                     var3[var1.osc].p[var28].c[2] = var9.getBlue();
                  }
               }
            }
         }
      } catch (Exception var12) {
      }
   }

   public void regprom() {
   }

   @Override
   public boolean mouseUp(Event var1, int var2, int var3) {
      if (!this.exwist) {
         if (this.mouses == 11) {
            this.xm = (int)((var2 - this.apx) / this.apmult);
            this.ym = (int)((var3 - this.apy) / this.apmult);
            this.mouses = -1;
         }

         this.moused = false;
      }

      if (!Madness.fullscreen) {
         if (var2 > this.getWidth() / 2 - 55 && var2 < this.getWidth() / 2 + 7 && var3 > 21 && var3 < 38 && !this.onbar) {
            if (this.smooth == 1) {
               this.smooth = 0;
            } else {
               this.smooth = 1;
            }

            this.showsize = 60;
         }

         if (var2 > this.getWidth() / 2 + 133 && var2 < this.getWidth() / 2 + 231 && var3 > 7 && var3 < 24 && !this.onbar) {
            if (Madness.anti == 0) {
               Madness.anti = 1;
            } else {
               Madness.anti = 0;
            }

            this.showsize = 60;
         }

         if (var2 > this.getWidth() / 2 + 133 && var2 < this.getWidth() / 2 + 231 && var3 > 24 && var3 < 41 && !this.onbar) {
            if (this.moto == 0) {
               this.moto = 1;
            } else {
               this.moto = 0;
            }

            this.showsize = 60;
         }

         if (this.oncarm) {
            Madness.carmaker();
         }

         if (this.onstgm) {
            Madness.stagemaker();
         }

         if (this.onfulls) {
            Madness.gofullscreen();
         }

         this.onbar = false;
      }

      return false;
   }

   @Override
   public boolean mouseDown(Event var1, int var2, int var3) {
      this.requestFocus();
      if (!this.exwist) {
         if (this.mouses == 0) {
            this.xm = (int)((var2 - this.apx) / this.apmult);
            this.ym = (int)((var3 - this.apy) / this.apmult);
            this.mouses = 1;
         }

         this.moused = true;
      }

      if (!Madness.fullscreen) {
         this.sizescreen(var2, var3);
      }

      return false;
   }

   @Override
   public boolean mouseMove(Event var1, int var2, int var3) {
      if (!this.exwist && !this.lostfcs) {
         this.xm = (int)((var2 - this.apx) / this.apmult);
         this.ym = (int)((var3 - this.apy) / this.apmult);
      }

      if (!Madness.fullscreen) {
         if (this.showsize < 20) {
            this.showsize = 20;
         }

         if (var2 > 50 && var2 < 192 && var3 > 14 && var3 < 37) {
            if (!this.oncarm) {
               this.oncarm = true;
               this.setCursor(new Cursor(12));
            }
         } else if (this.oncarm) {
            this.oncarm = false;
            this.setCursor(new Cursor(0));
         }

         if (var2 > this.getWidth() - 208 && var2 < this.getWidth() - 50 && var3 > 14 && var3 < 37) {
            if (!this.onstgm) {
               this.onstgm = true;
               this.setCursor(new Cursor(12));
            }
         } else if (this.onstgm) {
            this.onstgm = false;
            this.setCursor(new Cursor(0));
         }

         if (var2 > this.getWidth() / 2 + 22 && var2 < this.getWidth() / 2 + 122 && var3 > 14 && var3 < 37) {
            if (!this.onfulls) {
               this.onfulls = true;
               this.setCursor(new Cursor(12));
            }
         } else if (this.onfulls) {
            this.onfulls = false;
            this.setCursor(new Cursor(0));
         }
      }

      return false;
   }

   @Override
   public boolean mouseDrag(Event var1, int var2, int var3) {
      if (!this.exwist && !this.lostfcs) {
         this.xm = (int)((var2 - this.apx) / this.apmult);
         this.ym = (int)((var3 - this.apy) / this.apmult);
      }

      if (!Madness.fullscreen) {
         this.sizescreen(var2, var3);
      }

      return false;
   }

   @Override
   public boolean lostFocus(Event var1, Object var2) {
      if (!this.exwist && !this.lostfcs) {
         this.lostfcs = true;
         this.fcscnt = 10;
         if (this.u[0] != null) {
            if (this.u[0].multion == 0) {
               this.u[0].falseo(1);
            } else if (this.u[0].chatup == 0) {
               this.requestFocus();
            }

            this.setCursor(new Cursor(0));
         }
      }

      return false;
   }

   @Override
   public boolean gotFocus(Event var1, Object var2) {
      if (!this.exwist && this.lostfcs) {
         this.lostfcs = false;
      }

      return false;
   }

   public void mouseW(int var1) {
      if (!this.exwist) {
         this.mousew += var1 * 4;
      }
   }

   public void sizescreen(int var1, int var2) {
      if (var1 > this.getWidth() / 2 - 230 && var1 < this.getWidth() / 2 - 68 && var2 > 21 && var2 < 39 || this.onbar) {
         this.reqmult = (var1 - (this.getWidth() / 2 - 222)) / 141.0F;
         if (this.reqmult < 0.1) {
            this.reqmult = 0.0F;
         }

         if (this.reqmult > 1.0F) {
            this.reqmult = 1.0F;
         }

         this.onbar = true;
         this.showsize = 100;
      }
   }

   public void catchlink() {
      if (!this.lostfcs) {
         if (this.xm > 65 && this.xm < 735 && this.ym > 135 && this.ym < 194 || this.xm > 275 && this.xm < 525 && this.ym > 265 && this.ym < 284) {
            this.setCursor(new Cursor(12));
            if (this.mouses == 2) {
               this.openurl("http://www.radicalplay.com/");
            }
         } else {
            this.setCursor(new Cursor(0));
         }
      }
   }

   public void musiclink() {
      this.openurl("http://multiplayer.needformadness.com/music.html");
   }

   public void reglink() {
      this.openurl("http://multiplayer.needformadness.com/register.html?ref=game");
   }

   public void madlink() {
      this.openurl("http://www.needformadness.com/");
   }

   public void editlink(String var1, boolean var2) {
      String var3 = "";
      if (var2) {
         var3 = "?display=upgrade";
      }

      this.openurl("http://multiplayer.needformadness.com/edit.pl" + var3 + "#" + var1 + "");
   }

   public void regnew() {
      this.openurl("http://multiplayer.needformadness.com/registernew.pl");
   }

   public void multlink() {
      this.openurl("http://multiplayer.needformadness.com/");
   }

   public void setupini() {
      Madness.inisetup = true;

      try {
         File var1 = new File("" + Madness.fpath + "Madness.ini");
         if (var1.exists()) {
            String[] var2 = new String[40];
            int var3 = 0;
            BufferedReader var4 = new BufferedReader(new FileReader(var1));

            String var10;
            for (var10 = null; (var10 = var4.readLine()) != null && var3 < 40; var3++) {
               var2[var3] = var10;
               if (var2[var3].startsWith("Class Path")) {
                  if (var2[var3].indexOf("madapps.jar") != -1) {
                     var2[var3] = "Class Path=\\data\\madapps.jar;";
                  } else {
                     var2[var3] = "Class Path=\\data\\madapp.jar;";
                  }
               }

               if (var2[var3].startsWith("JRE Path")) {
                  var2[var3] = "JRE Path=data\\jre\\";
               }
            }

            var4.close();
            Object var9 = null;
            BufferedWriter var6 = new BufferedWriter(new FileWriter(var1));

            for (int var7 = 0; var7 < var3; var7++) {
               var6.write(var2[var7]);
               var6.newLine();
            }

            var6.close();
            Object var11 = null;
         }
      } catch (Exception var8) {
      }

      Madness.inisetup = false;
   }

   public void openurl(String var1) {
      if (Desktop.isDesktopSupported()) {
         try {
            Desktop.getDesktop().browse(new URI(var1));
         } catch (Exception var4) {
         }
      } else {
         try {
            Runtime.getRuntime().exec("" + Madness.urlopen() + " " + var1 + "");
         } catch (Exception var3) {
         }
      }
   }

   @Override
   public boolean keyDown(Event var1, int var2) {
      if (!this.exwist) {
         if (this.u[0].multion < 2) {
            if (var2 == 1004) {
               this.u[0].up = true;
            }

            if (var2 == 1005) {
               this.u[0].down = true;
            }

            if (var2 == 1007) {
               this.u[0].right = true;
            }

            if (var2 == 1006) {
               this.u[0].left = true;
            }

            if (var2 == 32) {
               this.u[0].handb = true;
            }
         }

         if (var2 == 10) {
            this.u[0].enter = true;
         }

         if (var2 == 27) {
            this.u[0].exit = true;
            if (this.u[0].chatup != 0) {
               this.u[0].chatup = 0;
            }
         }

         if ((var2 == 67 || var2 == 99) && this.u[0].multion != 0 && this.u[0].chatup == 0) {
            this.u[0].chatup = 2;
            this.view = 0;
         }

         if (this.u[0].chatup == 0) {
            if (var2 == 120 || var2 == 88) {
               this.u[0].lookback = -1;
            }

            if (var2 == 122 || var2 == 90) {
               this.u[0].lookback = 1;
            }

            if (var2 == 77 || var2 == 109) {
               if (this.u[0].mutem) {
                  this.u[0].mutem = false;
               } else {
                  this.u[0].mutem = true;
               }
            }

            if (var2 == 78 || var2 == 110) {
               if (this.u[0].mutes) {
                  this.u[0].mutes = false;
               } else {
                  this.u[0].mutes = true;
               }
            }

            if (var2 == 97 || var2 == 65) {
               if (this.u[0].arrace) {
                  this.u[0].arrace = false;
               } else {
                  this.u[0].arrace = true;
               }
            }

            if (var2 == 115 || var2 == 83) {
               if (this.u[0].radar) {
                  this.u[0].radar = false;
               } else {
                  this.u[0].radar = true;
               }
            }

            if (var2 == 118 || var2 == 86) {
               this.view++;
               if (this.view == 3) {
                  this.view = 0;
               }
            }
         }
      }

      return false;
   }

   @Override
   public boolean keyUp(Event var1, int var2) {
      if (!this.exwist) {
         if (this.u[0].multion < 2) {
            if (var2 == 1004) {
               this.u[0].up = false;
            }

            if (var2 == 1005) {
               this.u[0].down = false;
            }

            if (var2 == 1007) {
               this.u[0].right = false;
            }

            if (var2 == 1006) {
               this.u[0].left = false;
            }

            if (var2 == 32) {
               this.u[0].handb = false;
            }
         }

         if (var2 == 27) {
            this.u[0].exit = false;
            if (Madness.fullscreen) {
               Madness.exitfullscreen();
            }
         }

         if (var2 == 120 || var2 == 88 || var2 == 122 || var2 == 90) {
            this.u[0].lookback = 0;
         }
      }

      return false;
   }
}
