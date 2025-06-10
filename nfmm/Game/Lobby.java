import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.ImageObserver;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Date;

public class Lobby implements Runnable {
   Graphics2D rd;
   Login lg;
   Globe gb;
   xtGraphics xt;
   CarDefine cd;
   Medium m;
   FontMetrics ftm;
   ImageObserver ob;
   GameSparker gs;
   Thread connector;
   int conon = 0;
   boolean regnow = false;
   boolean lanlogged = false;
   int fase = 0;
   int stage = 0;
   int laps = 3;
   String stagename = "";
   int nfix = 0;
   boolean notb = false;
   boolean[] pessd = new boolean[]{false, false, false, false, false, false, false, false};
   int[] bx = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
   int[] by = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
   int[] bw = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
   int btn = 0;
   int pbtn = 0;
   int nflk = 0;
   int ncnt = 0;
   int rerr = 0;
   int pback = 0;
   int cflk = 0;
   int sflk = 0;
   String msg = "";
   String lmsg = "| Searching/Waiting for other LAN Players |";
   int opselect = 0;
   boolean lloaded = false;
   int npo = 0;
   String[] pnames = new String[200];
   int[] pcars = new int[200];
   String[] pcarnames = new String[200];
   String[] pclan = new String[200];
   int[] pgames = new int[200];
   float[][] pcols = new float[200][6];
   int prnpo = 0;
   String[] prnames = new String[]{"", "", "", "", "", "", "", ""};
   int[] ppos = new int[]{6, 6, 6, 6, 6, 6, 6, 6};
   int[] plap = new int[]{6, 6, 6, 6, 6, 6, 6, 6};
   int[] ppow = new int[]{50, 50, 50, 50, 50, 50, 50, 50};
   int[] pdam = new int[]{50, 50, 50, 50, 50, 50, 50, 50};
   int prevloaded = -1;
   String stuntname = "";
   String lapsname = "";
   String wastename = "";
   int ngm = 0;
   int[] gnum = new int[500];
   int[] gstgn = new int[500];
   String[] gstages = new String[500];
   int[] gnlaps = new int[500];
   int[] mnpls = new int[500];
   int[] mnbts = new int[500];
   int[] wait = new int[500];
   int[] gcrs = new int[500];
   int[] gclss = new int[500];
   int[] gfx = new int[500];
   int[] gntb = new int[500];
   String[] gplyrs = new String[500];
   int[] gwarb = new int[500];
   String[] gwarbnum = new String[500];
   int[] gameturn = new int[500];
   String[] gaclan = new String[500];
   String[] gvclan = new String[500];
   int[] gascore = new int[500];
   int[] gvscore = new int[500];
   int[] gwtyp = new int[500];
   String[] gmaker = new String[500];
   int[] npls = new int[500];
   int ongame = -1;
   int join = -1;
   int chalngd = -1;
   int im = 0;
   int longame = -1;
   int onjoin = -1;
   int ontyp = 0;
   int dispcar = -1;
   int forcar = -1;
   int addstage = 0;
   ContO dispco = null;
   boolean fstart = false;
   boolean jflexo = false;
   String chalby = "";
   int ctime = 0;
   boolean invo = false;
   String[] invos = new String[]{"", "", "", "", "", "", "", ""};
   String[] dinvi = new String[]{"", "", "", "", "", "", "", ""};
   String[] cnames = new String[]{"", "", "", "", "", "", ""};
   String[] sentn = new String[]{"", "", "", "", "", "", ""};
   int updatec = -1;
   int loadstage = 0;
   int gstage = 0;
   int gstagelaps = 0;
   int gnpls = 8;
   int gwait = 0;
   int gnbts = 0;
   int gcars;
   int gclass = 0;
   int gfix = 0;
   int gnotp = 0;
   int remstage = 0;
   int msload = 0;
   int sgflag = 0;
   String gstagename = "";
   String gplayers = "";
   boolean inwab = false;
   boolean loadwarb = false;
   int warbsel = 0;
   int cancreate = 0;
   int pgamesel = 0;
   int cntchkn = 0;
   Socket socket;
   BufferedReader din;
   PrintWriter dout;
   int spos = 0;
   int spos2 = 0;
   int spos3 = 28;
   int mscro = 125;
   int lspos = 0;
   int mscro2 = 145;
   int lspos2 = 0;
   int mscro3 = 345;
   int lspos3 = 0;
   int clicked = -1;
   int opengame = 0;
   int britchl = 0;
   boolean zeromsw = false;
   int mousonp = -1;
   int cmonp = -1;
   long ptime = 0L;
   int pcurs = 0;
   boolean grprsd = false;
   int pend = 0;
   int mrot = 0;
   boolean pendb = false;
   int[] cac = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1};
   int[] cax = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
   int[] cay = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
   boolean mousedout = false;
   int flks = 0;
   int waitlink = 0;
   boolean pre1 = false;
   boolean pre2 = false;
   int prereq = 0;
   int plsndt = 0;
   int lxm = 0;
   int lym = 0;

   public Lobby(Medium var1, Graphics2D var2, Login var3, Globe var4, xtGraphics var5, CarDefine var6, GameSparker var7) {
      this.m = var1;
      this.rd = var2;
      this.xt = var5;
      this.cd = var6;
      this.gs = var7;
      this.lg = var3;
      this.gb = var4;
      this.gs.cmsg.setBackground(this.color2k(240, 240, 240));
      this.gs.swait.setBackground(this.color2k(220, 220, 220));
      this.gs.snpls.setBackground(this.color2k(220, 220, 220));
      this.gs.snbts.setBackground(this.color2k(220, 220, 220));
      this.gs.sgame.setBackground(this.color2k(200, 200, 200));
      this.gs.wgame.setBackground(this.color2k(200, 200, 200));
      this.gs.pgame.setBackground(this.color2k(200, 200, 200));
      this.gs.vnpls.setBackground(this.color2k(200, 200, 200));
      this.gs.vtyp.setBackground(this.color2k(200, 200, 200));
      this.gs.warb.setBackground(this.color2k(200, 200, 200));
      this.gs.snfmm.setBackground(this.color2k(200, 200, 200));
      this.gs.snfm1.setBackground(this.color2k(200, 200, 200));
      this.gs.snfm2.setBackground(this.color2k(200, 200, 200));
      this.gs.mstgs.setBackground(this.color2k(230, 230, 230));
      this.gs.slaps.setBackground(this.color2k(200, 200, 200));
      this.gs.sclass.setBackground(this.color2k(220, 220, 220));
      this.gs.scars.setBackground(this.color2k(220, 220, 220));
      this.gs.sfix.setBackground(this.color2k(220, 220, 220));
      this.gs.mycar.setBackground(this.color2k(255, 255, 255));
      this.gs.notp.setBackground(this.color2k(255, 255, 255));
      this.gs.rooms.setBackground(this.color2k(170, 170, 170));
      this.gs.swait.setForeground(new Color(0, 0, 0));
      this.gs.snpls.setForeground(new Color(0, 0, 0));
      this.gs.snbts.setForeground(new Color(0, 0, 0));
      this.gs.sgame.setForeground(new Color(0, 0, 0));
      this.gs.wgame.setForeground(new Color(0, 0, 0));
      this.gs.pgame.setForeground(new Color(0, 0, 0));
      this.gs.vnpls.setForeground(new Color(0, 0, 0));
      this.gs.vtyp.setForeground(new Color(0, 0, 0));
      this.gs.warb.setForeground(new Color(0, 0, 0));
      this.gs.snfmm.setForeground(new Color(0, 0, 0));
      this.gs.snfm1.setForeground(new Color(0, 0, 0));
      this.gs.slaps.setForeground(new Color(0, 0, 0));
      this.gs.snfm2.setForeground(new Color(0, 0, 0));
      this.gs.mstgs.setForeground(new Color(0, 0, 0));
      this.gs.sclass.setForeground(new Color(0, 0, 0));
      this.gs.scars.setForeground(new Color(0, 0, 0));
      this.gs.sfix.setForeground(new Color(0, 0, 0));
      this.gs.mycar.setForeground(new Color(0, 0, 0));
      this.gs.notp.setForeground(new Color(0, 0, 0));
      this.gs.rooms.setForeground(new Color(0, 0, 0));
      this.gs.sgame.removeAll();
      this.gs.sgame.add(this.rd, " NFM Multiplayer ");
      this.gs.sgame.add(this.rd, " NFM 2     ");
      this.gs.sgame.add(this.rd, " NFM 1     ");
      this.gs.sgame.add(this.rd, " My Stages ");
      this.gs.sgame.add(this.rd, " My Clan Stages ");
      this.gs.sgame.add(this.rd, " Weekly Top 20 ");
      this.gs.sgame.add(this.rd, " Monthly Top 20 ");
   }

   public void inishlobby() {
      this.gs.tnick.hide();
      this.gs.tpass.hide();
      this.gs.temail.hide();
      this.hideinputs();
      this.gs.mycar.setBackground(this.color2k(255, 255, 255));
      this.gs.mycar.setForeground(new Color(0, 0, 0));
      this.gs.rooms.removeAll();
      this.gs.rooms.add(this.rd, "" + this.xt.servername + " :: " + (this.xt.servport - 7070) + "");
      this.gs.rooms.select(0);
      this.gs.requestFocus();
      this.cd.loadready();

      for (int var1 = 0; var1 < 500; var1++) {
         this.gnum[var1] = -2;
         this.gstgn[var1] = 0;
         this.gstages[var1] = "";
         this.gnlaps[var1] = 0;
         this.mnpls[var1] = 0;
         this.mnbts[var1] = 0;
         this.wait[var1] = 0;
         this.gmaker[var1] = "";
         this.gcrs[var1] = 0;
         this.gclss[var1] = 0;
         this.gfx[var1] = 0;
         this.gntb[var1] = 0;
         this.gplyrs[var1] = "";
         this.npls[var1] = 0;
         this.gwarb[var1] = 0;
         this.gwarbnum[var1] = "";
         this.gameturn[var1] = 0;
         this.gaclan[var1] = "";
         this.gvclan[var1] = "";
         this.gascore[var1] = 0;
         this.gvscore[var1] = 0;
         this.gwtyp[var1] = 0;
      }

      for (int var4 = 0; var4 < 200; var4++) {
         this.pnames[var4] = "";
         this.pcars[var4] = 0;
         this.pcarnames[var4] = "";
         this.pgames[var4] = -1;
         this.pclan[var4] = "";

         for (int var2 = 0; var2 < 6; var2++) {
            this.pcols[var4][var2] = 0.0F;
         }
      }

      this.ongame = -1;
      this.join = -1;
      this.onjoin = -1;
      this.chalngd = -1;
      this.dispcar = -1;
      this.forcar = -1;
      this.chalby = "";
      this.im = 0;
      this.fstart = false;
      this.updatec = -1;
      this.prevloaded = -1;
      this.spos = 0;
      this.spos2 = 0;
      this.spos3 = 0;
      this.ngm = 0;
      this.npo = 0;
      this.fase = 1;
      this.lloaded = false;
      this.lg.gamec = -1;

      try {
         this.socket = new Socket(this.xt.server, this.xt.servport);
         this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
         this.dout = new PrintWriter(this.socket.getOutputStream(), true);
      } catch (Exception var3) {
      }

      this.conon = 1;
      this.connector = new Thread(this);
      this.connector.start();
   }

   @Override
   public void run() {
      int var1 = -1;

      while (this.conon == 1) {
         Date var2 = new Date();
         long var3 = var2.getTime();
         if (!this.lloaded) {
            this.gs.setCursor(new Cursor(3));
         }

         if (!this.xt.logged && !this.xt.lan && this.xt.nfreeplays - this.xt.ndisco >= 5) {
            if (this.join >= 0) {
               this.join = -1;
               this.regnow = true;
            }

            if (this.pgames[this.im] != -1) {
               this.join = -2;
               this.regnow = true;
            }
         }

         if ((this.join >= 0 || this.pgames[this.im] != -1) && !this.regnow) {
            int var5 = -1;

            for (int var6 = 0; var6 < this.ngm; var6++) {
               if (this.join == this.gnum[var6] || this.pgames[this.im] == this.gnum[var6]) {
                  var5 = var6;
               }
            }

            if (var5 != -1) {
               boolean var48 = false;
               this.ontyp = 0;
               if (this.gcrs[var5] == 1 && this.pcars[this.im] < 16) {
                  var48 = true;
                  this.ontyp = 10;
                  if (this.gclss[var5] > 0 && this.gclss[var5] <= 5) {
                     this.ontyp = this.ontyp + this.gclss[var5];
                  }
               }

               if (this.gcrs[var5] == 2 && this.pcars[this.im] >= 16) {
                  var48 = true;
                  this.ontyp = 20;
                  if (this.gclss[var5] > 0 && this.gclss[var5] <= 5) {
                     this.ontyp = this.ontyp + this.gclss[var5];
                  }
               }

               if (this.gcrs[var5] == 1 && this.gwarb[var5] != 0 && this.xt.sc[0] != 36) {
                  var48 = true;
                  this.ontyp = 30;
                  if (this.gclss[var5] > 0 && this.gclss[var5] <= 5) {
                     this.ontyp = this.ontyp + this.gclss[var5];
                  }
               }

               if (this.gclss[var5] > 0 && this.gclss[var5] <= 5 && Math.abs(this.cd.cclass[this.pcars[this.im]] - (this.gclss[var5] - 1)) > 1) {
                  var48 = true;
                  if (this.gcrs[var5] == 1) {
                     if (this.gwarb[var5] == 0) {
                        this.ontyp = 10;
                     } else {
                        this.ontyp = 30;
                     }
                  }

                  if (this.gcrs[var5] == 2) {
                     this.ontyp = 20;
                  }

                  this.ontyp = this.ontyp + this.gclss[var5];
               }

               if (this.gclss[var5] <= -2 && this.pcars[this.im] != Math.abs(this.gclss[var5] + 2)) {
                  var48 = true;
                  this.ontyp = this.gclss[var5];
               }

               if (this.gstgn[var5] == -2 && !this.xt.logged) {
                  var48 = true;
                  this.ontyp = 76;
               }

               if (var48) {
                  this.onjoin = this.gnum[var5];
                  this.jflexo = false;
                  if (this.join >= 0) {
                     this.join = -1;
                  }

                  if (this.pgames[this.im] != -1) {
                     this.join = -2;
                  }
               }
            }
         }

         if (this.xt.onjoin != -1) {
            this.join = this.xt.onjoin;
            this.ongame = this.xt.onjoin;
            this.xt.onjoin = -1;
         }

         if (this.updatec < -17) {
            this.updatec = -17;
         }

         boolean var45 = false;
         if (this.lloaded) {
            var1 = this.pgames[this.im];
            if (var1 != -1) {
               for (int var49 = 0; var49 < this.ngm; var49++) {
                  if (var1 == this.gnum[var49]) {
                     this.laps = this.gnlaps[var49];
                     this.stage = this.gstgn[var49];
                     this.stagename = this.gstages[var49];
                     this.nfix = this.gfx[var49];
                     if (this.gntb[var49] == 1) {
                        this.notb = true;
                     } else {
                        this.notb = false;
                     }
                  }
               }
            }
         }

         String var50 = "" + this.xt.sc[0] + "";
         if (this.xt.sc[0] >= 16) {
            var50 = "C" + this.cd.names[this.xt.sc[0]] + "";
         }

         String var7 = "1|"
            + this.xt.nickname
            + ":"
            + this.xt.nickey
            + "|"
            + this.xt.clan
            + "|"
            + this.xt.clankey
            + "|"
            + var50
            + "|"
            + this.join
            + "|"
            + (int)(this.xt.arnp[0] * 100.0F)
            + "|"
            + (int)(this.xt.arnp[1] * 100.0F)
            + "|"
            + (int)(this.xt.arnp[2] * 100.0F)
            + "|"
            + (int)(this.xt.arnp[3] * 100.0F)
            + "|"
            + (int)(this.xt.arnp[4] * 100.0F)
            + "|"
            + (int)(this.xt.arnp[5] * 100.0F)
            + "|"
            + this.ongame
            + "|";
         if (this.xt.lan) {
            String var64 = "Nonex";

            try {
               var64 = InetAddress.getLocalHost().getHostName();
               if (var64.indexOf("|") != -1) {
                  var64 = InetAddress.getLocalHost().getHostAddress();
               }
            } catch (Exception var37) {
               var64 = "Nonex";
            }

            byte var9 = 0;
            if (this.xt.logged) {
               var9 = 1;
            }

            var7 = var7 + "" + var64 + "|" + var9 + "|";
         } else {
            var7 = var7 + "" + this.updatec + "|";
            if (this.updatec <= -11) {
               for (int var8 = 0; var8 < -this.updatec - 10; var8++) {
                  var7 = var7 + "" + this.cnames[6 - var8] + "|" + this.sentn[6 - var8] + "|";
               }

               this.updatec = -2;
            }
         }

         if (this.fstart) {
            var7 = var7 + "3|";
            var45 = true;
         }

         if (this.chalngd == -5 && !this.fstart) {
            var7 = var7
               + "11|"
               + this.gstage
               + "|"
               + this.gstagename
               + "|"
               + this.gstagelaps
               + "|"
               + this.gnpls
               + "|"
               + this.gwait
               + "|"
               + this.pnames[this.im]
               + "|"
               + this.gcars
               + "|"
               + this.gclass
               + "|"
               + this.gfix
               + "|"
               + this.gnotp
               + "|"
               + this.gplayers
               + "|";
            if (this.xt.lan) {
               var7 = var7 + "" + this.gnbts + "|";
            }
         }

         if (this.ongame != -1 && this.chalngd != -5 && !this.fstart) {
            boolean var66 = false;

            for (int var78 = 0; var78 < 7; var78++) {
               if (!this.invos[var78].equals("") && !this.dinvi[var78].equals(this.invos[var78])) {
                  if (!var66) {
                     var7 = var7 + "2|" + this.ongame + "|";
                     var66 = true;
                  }

                  var7 = var7 + "" + this.invos[var78] + "|";
                  this.dinvi[var78] = this.invos[var78];
               }
            }
         }

         String var67 = "";
         boolean var79 = false;

         try {
            this.dout.println(var7);
            var67 = this.din.readLine();
            if (var67 == null) {
               var79 = true;
            }
         } catch (Exception var36) {
            var79 = true;
         }

         if (var79) {
            try {
               this.socket.close();
               this.socket = null;
               this.din.close();
               this.din = null;
               this.dout.close();
               this.dout = null;
            } catch (Exception var35) {
            }

            try {
               this.socket = new Socket(this.xt.server, this.xt.servport);
               this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
               this.dout = new PrintWriter(this.socket.getOutputStream(), true);
               this.dout.println(var7);
               var67 = this.din.readLine();
               if (var67 != null) {
                  var79 = false;
               }
            } catch (Exception var34) {
            }
         }

         if (var79) {
            try {
               this.socket.close();
               this.socket = null;
            } catch (Exception var33) {
            }

            this.conon = 0;
            this.lg.exitfromlobby();
            this.hideinputs();
            this.connector.stop();
         }

         if (this.regnow && this.join == -2) {
            this.join = -1;
         }

         this.npo = this.getvalue(var67, 0);
         if (this.npo < 0) {
            this.npo = 0;
         }

         this.im = this.getvalue(var67, 1);
         if (this.im < 0) {
            this.im = 0;
         }

         for (int var10 = 0; var10 < this.npo; var10++) {
            this.pnames[var10] = this.getSvalue(var67, 2 + var10 * 10);
            if (this.pnames[var10].equals("")) {
               this.pnames[var10] = "Unknown";
            }

            String var11 = this.getSvalue(var67, 3 + var10 * 10);
            if (!var11.startsWith("C")) {
               this.pcars[var10] = this.getvalue(var67, 3 + var10 * 10);
               if (this.pcars[var10] == -1) {
                  this.pcars[var10] = 0;
               }

               this.pcarnames[var10] = this.cd.names[this.pcars[var10]];
            } else {
               this.pcarnames[var10] = var11.substring(1);
               if (this.pcarnames[var10].equals("")) {
                  this.pcars[var10] = 0;
                  this.pcarnames[var10] = this.cd.names[this.pcars[var10]];
               } else {
                  int var12 = 0;

                  for (int var13 = 16; var13 < 56; var13++) {
                     if (this.pcarnames[var10].equals(this.cd.names[var13])) {
                        var12 = var13;
                        break;
                     }
                  }

                  if (var12 != 0) {
                     this.pcars[var10] = var12;
                  } else {
                     this.pcars[var10] = -1;
                     boolean var119 = false;

                     for (int var14 = 0; var14 < this.cd.nl; var14++) {
                        if (this.pcarnames[var10].equals(this.cd.loadnames[var14])) {
                           var119 = true;
                        }
                     }

                     if (!var119 && this.cd.nl < 20 && this.cd.nl >= 0) {
                        this.cd.loadnames[this.cd.nl] = this.pcarnames[var10];
                        this.cd.nl++;
                     }

                     this.cd.sparkcarloader();
                  }
               }
            }

            this.pclan[var10] = this.getSvalue(var67, 4 + var10 * 10);
            this.pgames[var10] = this.getvalue(var67, 5 + var10 * 10);
            this.pcols[var10][0] = this.getvalue(var67, 6 + var10 * 10) / 100.0F;
            if (this.pcols[var10][0] == -1.0F) {
               this.pcols[var10][0] = 0.0F;
            }

            this.pcols[var10][1] = this.getvalue(var67, 7 + var10 * 10) / 100.0F;
            if (this.pcols[var10][1] == -1.0F) {
               this.pcols[var10][1] = 0.0F;
            }

            this.pcols[var10][2] = this.getvalue(var67, 8 + var10 * 10) / 100.0F;
            if (this.pcols[var10][2] == -1.0F) {
               this.pcols[var10][2] = 0.0F;
            }

            this.pcols[var10][3] = this.getvalue(var67, 9 + var10 * 10) / 100.0F;
            if (this.pcols[var10][3] == -1.0F) {
               this.pcols[var10][3] = 0.0F;
            }

            this.pcols[var10][4] = this.getvalue(var67, 10 + var10 * 10) / 100.0F;
            if (this.pcols[var10][4] == -1.0F) {
               this.pcols[var10][4] = 0.0F;
            }

            this.pcols[var10][5] = this.getvalue(var67, 11 + var10 * 10) / 100.0F;
            if (this.pcols[var10][5] == -1.0F) {
               this.pcols[var10][5] = 0.0F;
            }
         }

         int var90 = 12 + (this.npo - 1) * 10;
         this.ngm = this.getvalue(var67, var90);
         if (this.ngm < 0) {
            this.ngm = 0;
         }

         byte var100 = 12;
         if (this.xt.lan) {
            var100 = 13;
         }

         for (int var107 = 0; var107 < this.ngm; var107++) {
            this.gnum[var107] = this.getvalue(var67, var90 + 1 + var107 * var100);
            this.gstgn[var107] = this.getvalue(var67, var90 + 2 + var107 * var100);
            this.gstgn[var107] = Math.abs(this.gstgn[var107]);
            if (this.gstgn[var107] > 100) {
               this.gstgn[var107] = -2;
            }

            this.gstages[var107] = this.getSvalue(var67, var90 + 3 + var107 * var100);
            this.gnlaps[var107] = this.getvalue(var67, var90 + 4 + var107 * var100);
            this.mnpls[var107] = this.getvalue(var67, var90 + 5 + var107 * var100);
            this.wait[var107] = this.getvalue(var67, var90 + 6 + var107 * var100);
            this.gmaker[var107] = this.getSvalue(var67, var90 + 7 + var107 * var100);
            this.gcrs[var107] = this.getvalue(var67, var90 + 8 + var107 * var100);
            this.gclss[var107] = this.getvalue(var67, var90 + 9 + var107 * var100);
            this.gfx[var107] = this.getvalue(var67, var90 + 10 + var107 * var100);
            this.gntb[var107] = this.getvalue(var67, var90 + 11 + var107 * var100);
            this.gplyrs[var107] = this.getSvalue(var67, var90 + 12 + var107 * var100);
            if (!this.gplyrs[var107].startsWith("#warb#")) {
               this.gwarb[var107] = 0;
               this.gwarbnum[var107] = "";
               this.gameturn[var107] = 0;
               this.gaclan[var107] = "";
               this.gvclan[var107] = "";
               this.gascore[var107] = 0;
               this.gvscore[var107] = 0;
               this.gwtyp[var107] = 0;
            } else {
               this.gwarb[var107] = this.getHvalue(this.gplyrs[var107], 2);
               this.gwarbnum[var107] = this.getHSvalue(this.gplyrs[var107], 3);
               this.gameturn[var107] = this.getHvalue(this.gplyrs[var107], 4);
               this.gaclan[var107] = this.getHSvalue(this.gplyrs[var107], 5);
               this.gvclan[var107] = this.getHSvalue(this.gplyrs[var107], 6);
               this.gascore[var107] = this.getHvalue(this.gplyrs[var107], 7);
               this.gvscore[var107] = this.getHvalue(this.gplyrs[var107], 8);
               this.gwtyp[var107] = this.getHvalue(this.gplyrs[var107], 9);
               if (this.gwtyp[var107] < 1 || this.gwtyp[var107] > 5) {
                  this.gwtyp[var107] = 1;
               }

               this.gplyrs[var107] = "";
            }

            if (this.xt.lan) {
               this.mnbts[var107] = this.getvalue(var67, var90 + 13 + var107 * var100);
            }

            if (this.xt.playingame > -1 && this.xt.playingame == this.gnum[var107] && !this.xt.lan) {
               this.ongame = this.gnum[var107];
            }

            if (var1 == this.gnum[var107] && this.wait[var107] == 0 && this.lloaded && var1 != -1) {
               for (int var120 = 0; var120 < this.npo; var120++) {
                  if (this.pgames[var120] == this.gnum[var107] && this.pnames[var120].equals(this.xt.nickname)) {
                     this.im = var120;
                     break;
                  }
               }

               this.conon = 2;
               this.gs.setCursor(new Cursor(3));
            }
         }

         for (int var108 = 0; var108 < this.ngm; var108++) {
            this.npls[var108] = 0;

            for (int var121 = 0; var121 < this.npo; var121++) {
               if (this.pgames[var121] == this.gnum[var108]) {
                  this.npls[var108]++;
               }
            }
         }

         if (this.conon != 0 && this.xt.playingame != -1) {
            this.xt.playingame = -1;
         }

         if (this.ongame != -1) {
            boolean var109 = false;

            for (int var122 = 0; var122 < this.ngm; var122++) {
               if (this.ongame == this.gnum[var122]) {
                  var109 = true;
               }
            }

            if (!var109) {
               this.britchl = -1;
            }
         }

         if (this.join > -1) {
            boolean var110 = false;

            for (int var123 = 0; var123 < this.ngm; var123++) {
               if (this.join == this.gnum[var123]) {
                  var110 = true;
               }
            }

            if (!var110) {
               this.join = -1;
            }
         }

         for (int var111 = 0; var111 < this.npo; var111++) {
            if (this.pgames[var111] != -1) {
               boolean var124 = false;

               for (int var131 = 0; var131 < this.ngm; var131++) {
                  if (this.pgames[var111] == this.gnum[var131]) {
                     var124 = true;
                  }
               }

               if (!var124) {
                  this.pgames[var111] = -1;
               }
            }
         }

         if (this.xt.lan) {
            var90 += 14 + (this.ngm - 1) * 13;
         } else {
            var90 += 13 + (this.ngm - 1) * 12;
         }

         if (this.xt.lan) {
            int var113 = this.getvalue(var67, var90);
            if (var113 == 1) {
               this.lanlogged = true;
            } else {
               this.lanlogged = false;
            }

            var90++;
         } else {
            int var112 = this.getvalue(var67, var90);
            int var125 = this.getvalue(var67, var90 + 1);
            var90 += 2;
            if (this.updatec != var112 && this.updatec >= -2 && var125 == this.ongame) {
               for (int var132 = 0; var132 < 7; var132++) {
                  this.cnames[var132] = this.getSvalue(var67, var90 + var132 * 2);
                  this.sentn[var132] = this.getSvalue(var67, var90 + 1 + var132 * 2);
               }

               this.updatec = var112;
               if (this.ongame == -1) {
                  this.spos3 = 28;
               }

               var90 += 14;
            }

            if (this.ongame != -1) {
               if (this.prevloaded != -1) {
                  this.prevloaded = -1;
               }

               boolean var133 = false;

               for (int var15 = 0; var15 < this.ngm; var15++) {
                  if (this.ongame == this.gnum[var15] && this.wait[var15] <= 0) {
                     var133 = true;
                  }
               }

               if (var133) {
                  this.prevloaded = this.getvalue(var67, var90);
                  var90++;
                  if (this.prevloaded == 1) {
                     this.prnpo = this.getvalue(var67, var90);
                     var90++;

                     for (int var140 = 0; var140 < this.prnpo; var140++) {
                        this.prnames[var140] = this.getSvalue(var67, var90);
                        var90++;
                     }

                     for (int var141 = 0; var141 < this.prnpo; var141++) {
                        this.ppos[var141] = this.getvalue(var67, var90);
                        var90++;
                     }

                     for (int var142 = 0; var142 < this.prnpo; var142++) {
                        this.plap[var142] = this.getvalue(var67, var90);
                        var90++;
                     }

                     for (int var143 = 0; var143 < this.prnpo; var143++) {
                        this.ppow[var143] = (int)(this.getvalue(var67, var90) / 9800.0F * 55.0F);
                        var90++;
                     }

                     for (int var144 = 0; var144 < this.prnpo; var144++) {
                        int var16 = this.getvalue(var67, var90);
                        if (var16 != -17) {
                           this.pdam[var144] = (int)(var16 / 100.0F * 55.0F);
                        } else {
                           this.pdam[var144] = -17;
                        }

                        var90++;
                     }

                     this.stuntname = this.getSvalue(var67, var90);
                     this.lapsname = this.getSvalue(var67, ++var90);
                     this.wastename = this.getSvalue(var67, ++var90);
                     var90++;
                  }
               }
            }
         }

         int var114 = this.getvalue(var67, var90);
         if (var114 != -1) {
            int var126 = 0;

            for (int var134 = 0; var134 < this.ngm; var134++) {
               if (var114 == this.gnum[var134]) {
                  var126 = var134;
               }
            }

            boolean var135 = false;
            if (this.gwarb[var126] != 0) {
               if (this.xt.clan.toLowerCase().equals(this.gaclan[var126].toLowerCase()) || this.xt.clan.toLowerCase().equals(this.gvclan[var126].toLowerCase())
                  )
                {
                  var135 = true;
               }
            } else {
               var135 = true;
            }

            if ((this.pgames[this.im] != this.ongame || this.ongame == -1)
               && var114 != this.ongame
               && this.chalngd == -1
               && this.join == -1
               && this.fase == 1
               && this.wait[var126] > 0
               && var135) {
               this.chalngd = var114;
               this.chalby = this.getSvalue(var67, var90 + 1);
               this.cflk = 20;
               this.ctime = 20;
               this.ptime = 0L;
               this.longame = this.ongame;
               if (this.gs.rooms.open) {
                  this.gs.rooms.open = false;
               }

               if (this.ongame != -1) {
                  this.britchl = -1;
               }
            }

            var90++;
         }

         if (!this.xt.lan) {
            int var127 = 1;

            for (int var136 = 1; var136 < 6; var136++) {
               if (var136 != this.xt.servport - 7070) {
                  int var145 = this.getvalue(var67, var90 + var136);
                  if (var145 != -1) {
                     this.gs.rooms.sopts[var127] = "Room " + var136 + "  ::  " + var145 + "";
                     this.gs.rooms.opts[var127] = "";
                     this.gs.rooms.iroom[var127] = var136;
                     var127++;
                  }
               }
            }

            for (int var137 = 0; var137 < this.lg.nservers; var137++) {
               if (!this.xt.server.equals(this.lg.servers[var137]) && this.xt.delays[var137] < 300) {
                  this.gs.rooms.sopts[var127] = ":: " + this.lg.snames[var137] + "";
                  this.gs.rooms.opts[var127] = "";
                  this.gs.rooms.iroom[var127] = 1000 + var137;
                  var127++;
               }
            }

            this.gs.rooms.no = var127;
         }

         if (this.join > -1) {
            boolean var128 = false;

            for (int var138 = 0; var138 < this.ngm; var138++) {
               if (this.join == this.gnum[var138] && this.wait[var138] == 0) {
                  var128 = true;
               }
            }

            if (this.pgames[this.im] == this.join || var128) {
               this.join = -1;
               this.nflk = 3;
            }
         }

         if (this.join == -2) {
            boolean var129 = false;

            for (int var139 = 0; var139 < this.ngm; var139++) {
               if (this.pgames[this.im] == this.gnum[var139] && this.wait[var139] == 0) {
                  var129 = true;
               }
            }

            if (this.pgames[this.im] == -1 || var129) {
               this.join = -1;
               if (!var129) {
                  this.ongame = -1;
               }
            }
         }

         if (this.chalngd == -5 && this.pgames[this.im] != -1) {
            this.ongame = this.pgames[this.im];
            this.chalngd = -1;
            if (!this.xt.lan && this.gplayers.equals("")) {
               this.lg.gamealert();
            }
         }

         if (this.fstart && var45) {
            this.fstart = false;
         }

         this.rerr = 0;
         if (!this.lloaded) {
            this.gs.setCursor(new Cursor(0));
            this.lloaded = true;
         }

         if (!this.gb.domon) {
            this.gb.roomlogos(this.pnames, this.npo);
            if (this.ongame == -1) {
               if (this.cntchkn == 5) {
                  this.lg.checkgamealerts();
               }
            } else if (this.lg.gamec != -1) {
               this.lg.gamec = -1;
            }

            if (this.cntchkn == 5) {
               this.lg.checknotifcations();
               this.cntchkn = 0;
            } else {
               this.cntchkn++;
            }
         } else if (this.lg.gamec != -1) {
            this.lg.gamec = -1;
         }

         var2 = new Date();
         long var130 = var2.getTime();
         int var146 = 700 - (int)(var130 - var3);
         if (var146 < 50) {
            var146 = 50;
         }

         try {
            Thread.sleep(var146);
         } catch (InterruptedException var32) {
         }
      }

      if (this.conon == 2) {
         int var39 = 20;
         this.xt.playingame = -1;

         while (var39 != 0) {
            String var41 = "2|" + var1 + "|";
            String var4 = "";
            boolean var46 = false;

            try {
               this.dout.println(var41);
               var4 = this.din.readLine();
               if (var4 == null) {
                  var46 = true;
               }
            } catch (Exception var31) {
               var46 = true;
            }

            if (var46) {
               try {
                  this.socket.close();
                  this.socket = null;
                  this.din.close();
                  this.din = null;
                  this.dout.close();
                  this.dout = null;
               } catch (Exception var30) {
               }

               try {
                  this.socket = new Socket(this.xt.server, this.xt.servport);
                  this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                  this.dout = new PrintWriter(this.socket.getOutputStream(), true);
                  this.dout.println(var41);
                  var4 = this.din.readLine();
                  if (var4 != null) {
                     var46 = false;
                  }
               } catch (Exception var29) {
               }
            }

            if (var46) {
               try {
                  this.socket.close();
                  this.socket = null;
               } catch (Exception var28) {
               }

               this.conon = 0;
               this.lg.exitfromlobby();
               this.hideinputs();
               this.connector.stop();
            }

            if (!this.xt.lan) {
               this.xt.gameport = this.getvalue(var4, 0);
            } else {
               this.xt.gameport = -1;
               this.xt.localserver = this.getSevervalue(var4, 0);
               if (!this.xt.localserver.equals("")) {
                  this.xt.gameport = 0;
               }
            }

            if (this.xt.gameport == -1) {
               var39--;
            } else {
               int var51 = 0;
               this.xt.im = -1;
               this.xt.nplayers = this.getvalue(var4, 1);
               if (this.xt.nplayers < 1) {
                  this.xt.nplayers = 1;
               }

               if (this.xt.nplayers > 8) {
                  this.xt.nplayers = 8;
               }

               for (int var54 = 0; var54 < this.xt.nplayers; var54++) {
                  this.xt.plnames[var54] = this.getSvalue(var4, 2 + var54);
                  if (this.xt.nickname.equals(this.xt.plnames[var54])) {
                     this.xt.im = var54;
                  }
               }

               int var55 = 2 + this.xt.nplayers;

               for (int var68 = 0; var68 < this.xt.nplayers; var68++) {
                  String var80 = this.getSvalue(var4, var55 + var68);
                  if (!var80.startsWith("C")) {
                     this.xt.sc[var68] = this.getvalue(var4, var55 + var68);
                     if (this.xt.sc[var68] == -1) {
                        this.xt.im = -1;
                     }
                  } else {
                     var80 = var80.substring(1);
                     if (var80.equals("")) {
                        this.xt.im = -1;
                     } else {
                        int var96 = 0;

                        for (int var101 = 16; var101 < 56; var101++) {
                           if (var80.equals(this.cd.names[var101])) {
                              var96 = var101;
                              break;
                           }
                        }

                        while (var96 == 0 && var51 < 100) {
                           boolean var102 = false;

                           for (int var115 = 0; var115 < this.cd.nl; var115++) {
                              if (var80.equals(this.cd.loadnames[var115])) {
                                 var102 = true;
                              }
                           }

                           if (!var102 && this.cd.nl < 20) {
                              this.cd.loadnames[this.cd.nl] = var80;
                              this.cd.nl++;
                           }

                           this.cd.sparkcarloader();

                           try {
                              Thread.sleep(100L);
                           } catch (InterruptedException var27) {
                           }

                           for (int var116 = 16; var116 < 56; var116++) {
                              if (var80.equals(this.cd.names[var116])) {
                                 var96 = var116;
                              }
                           }

                           var51++;
                        }

                        if (var96 != 0) {
                           this.xt.sc[var68] = var96;

                           for (int var103 = 0; var103 < this.npo; var103++) {
                              if (this.pcarnames[var103].equals(var80)) {
                                 this.pcars[var103] = var96;
                              }
                           }
                        } else {
                           this.xt.im = -1;
                        }
                     }
                  }
               }

               var55 += this.xt.nplayers;

               for (int var69 = 0; var69 < this.xt.nplayers; var69++) {
                  this.xt.xstart[var69] = this.getvalue(var4, var55 + var69);
               }

               var55 += this.xt.nplayers;

               for (int var70 = 0; var70 < this.xt.nplayers; var70++) {
                  this.xt.zstart[var70] = this.getvalue(var4, var55 + var70);
               }

               var55 += this.xt.nplayers;

               for (int var71 = 0; var71 < this.xt.nplayers; var71++) {
                  for (int var82 = 0; var82 < 6; var82++) {
                     this.xt.allrnp[var71][var82] = this.getvalue(var4, var55 + var71 * 6 + var82) / 100.0F;
                  }
               }

               if (this.xt.im != -1) {
                  this.xt.playingame = var1;
                  int var72 = 0;

                  for (int var83 = 0; var83 < this.ngm; var83++) {
                     if (var1 == this.gnum[var83]) {
                        var72 = var83;
                     }
                  }

                  if (this.gwarb[var72] != 0) {
                     this.xt.clangame = this.gwtyp[var72];
                     this.xt.clanchat = true;
                     this.xt.gaclan = this.gaclan[var72];

                     for (int var84 = 0; var84 < this.xt.nplayers; var84++) {
                        for (int var97 = 0; var97 < this.npo; var97++) {
                           if (this.xt.plnames[var84].equals(this.pnames[var97]) && this.pgames[var97] == var1) {
                              this.xt.pclan[var84] = this.pclan[var97];
                           }
                        }
                     }
                  } else {
                     this.xt.clangame = 0;
                  }
               } else {
                  this.xt.playingame = -1;
                  this.xt.im = 0;
               }

               var39 = 0;
            }

            try {
               Thread.sleep(1000L);
            } catch (InterruptedException var26) {
            }
         }

         try {
            this.socket.close();
            this.socket = null;
            this.din.close();
            this.din = null;
            this.dout.close();
            this.dout = null;
         } catch (Exception var25) {
         }

         if (this.xt.playingame != -1) {
            if (!this.xt.lan && !this.xt.logged) {
               this.xt.nfreeplays++;

               try {
                  this.socket = new Socket(this.lg.servers[0], 7061);
                  this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                  this.dout = new PrintWriter(this.socket.getOutputStream(), true);
                  this.dout.println("7|" + this.xt.nfreeplays + "|");
                  String var42 = this.din.readLine();
                  this.xt.hours = this.getvalue(var42, 0);
                  this.socket.close();
                  this.socket = null;
                  this.din.close();
                  this.din = null;
                  this.dout.close();
                  this.dout = null;
               } catch (Exception var24) {
               }
            }

            this.hideinputs();
            this.xt.multion = 1;
            this.fase = 76;
            System.gc();
         } else {
            this.inishlobby();
         }
      }

      if (this.conon == 3) {
         int var40 = 20;
         this.xt.playingame = -1;

         while (var40 != 0) {
            String var43 = "4|" + this.ongame + "|";
            String var44 = "";
            boolean var47 = false;

            try {
               this.dout.println(var43);
               var44 = this.din.readLine();
               if (var44 == null) {
                  var47 = true;
               }
            } catch (Exception var23) {
               var47 = true;
            }

            if (var47) {
               try {
                  this.socket.close();
                  this.socket = null;
                  this.din.close();
                  this.din = null;
                  this.dout.close();
                  this.dout = null;
               } catch (Exception var22) {
               }

               try {
                  this.socket = new Socket(this.xt.server, this.xt.servport);
                  this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                  this.dout = new PrintWriter(this.socket.getOutputStream(), true);
                  this.dout.println(var43);
                  var44 = this.din.readLine();
                  if (var44 != null) {
                     var47 = false;
                  }
               } catch (Exception var21) {
               }
            }

            if (var47) {
               try {
                  this.socket.close();
                  this.socket = null;
               } catch (Exception var20) {
               }

               this.conon = 0;
               this.lg.exitfromlobby();
               this.hideinputs();
               this.connector.stop();
            }

            if (!this.xt.lan) {
               this.xt.gameport = this.getvalue(var44, 0);
            } else {
               this.xt.gameport = -1;
               this.xt.localserver = this.getSevervalue(var44, 0);
               if (!this.xt.localserver.equals("")) {
                  this.xt.gameport = 0;
               }
            }

            if (this.xt.gameport == -1) {
               var40--;
            } else {
               int var52 = 0;
               this.xt.nplayers = this.getvalue(var44, 1);
               if (this.xt.nplayers < 1) {
                  this.xt.nplayers = 1;
               }

               if (this.xt.nplayers > 8) {
                  this.xt.nplayers = 8;
               }

               this.xt.im = this.getvalue(var44, 2) + this.xt.nplayers;

               for (int var59 = 0; var59 < this.xt.nplayers; var59++) {
                  this.xt.plnames[var59] = this.getSvalue(var44, 3 + var59);
               }

               int var60 = 3 + this.xt.nplayers;

               for (int var73 = 0; var73 < this.xt.nplayers; var73++) {
                  String var85 = this.getSvalue(var44, var60 + var73);
                  if (!var85.startsWith("C")) {
                     this.xt.sc[var73] = this.getvalue(var44, var60 + var73);
                     if (this.xt.sc[var73] == -1) {
                        this.xt.im = -1;
                     }
                  } else {
                     var85 = var85.substring(1);
                     if (var85.equals("")) {
                        this.xt.im = -1;
                     } else {
                        int var98 = 0;

                        for (int var104 = 16; var104 < 56; var104++) {
                           if (var85.equals(this.cd.names[var104])) {
                              var98 = var104;
                              break;
                           }
                        }

                        while (var98 == 0 && var52 < 100) {
                           boolean var105 = false;

                           for (int var117 = 0; var117 < this.cd.nl; var117++) {
                              if (var85.equals(this.cd.loadnames[var117])) {
                                 var105 = true;
                              }
                           }

                           if (!var105 && this.cd.nl < 20) {
                              this.cd.loadnames[this.cd.nl] = var85;
                              this.cd.nl++;
                           }

                           this.cd.sparkcarloader();

                           try {
                              Thread.sleep(100L);
                           } catch (InterruptedException var19) {
                           }

                           for (int var118 = 16; var118 < 56; var118++) {
                              if (var85.equals(this.cd.names[var118])) {
                                 var98 = var118;
                              }
                           }

                           var52++;
                        }

                        if (var98 != 0) {
                           this.xt.sc[var73] = var98;

                           for (int var106 = 0; var106 < this.npo; var106++) {
                              if (this.pcarnames[var106].equals(var85)) {
                                 this.pcars[var106] = var98;
                              }
                           }
                        } else {
                           this.xt.im = -1;
                        }
                     }
                  }
               }

               var60 += this.xt.nplayers;

               for (int var74 = 0; var74 < this.xt.nplayers; var74++) {
                  this.xt.xstart[var74] = this.getvalue(var44, var60 + var74);
               }

               var60 += this.xt.nplayers;

               for (int var75 = 0; var75 < this.xt.nplayers; var75++) {
                  this.xt.zstart[var75] = this.getvalue(var44, var60 + var75);
               }

               var60 += this.xt.nplayers;

               for (int var76 = 0; var76 < this.xt.nplayers; var76++) {
                  for (int var87 = 0; var87 < 6; var87++) {
                     this.xt.allrnp[var76][var87] = this.getvalue(var44, var60 + var76 * 6 + var87) / 100.0F;
                  }
               }

               if (this.xt.im >= this.xt.nplayers && this.xt.im < this.xt.nplayers + 3) {
                  this.xt.playingame = this.ongame;
                  int var77 = 0;

                  for (int var88 = 0; var88 < this.ngm; var88++) {
                     if (this.ongame == this.gnum[var88]) {
                        var77 = var88;
                     }
                  }

                  if (this.gwarb[var77] != 0) {
                     this.xt.clangame = this.gwtyp[var77];
                     this.xt.gaclan = this.gaclan[var77];
                     if (this.xt.clan.toLowerCase().equals(this.gaclan[var77].toLowerCase())
                        || this.xt.clan.toLowerCase().equals(this.gvclan[var77].toLowerCase())) {
                        this.xt.clanchat = true;
                     }

                     for (int var89 = 0; var89 < this.xt.nplayers; var89++) {
                        for (int var99 = 0; var99 < this.npo; var99++) {
                           if (this.xt.plnames[var89].equals(this.pnames[var99]) && this.pgames[var99] == this.ongame) {
                              this.xt.pclan[var89] = this.pclan[var99];
                           }
                        }
                     }
                  } else {
                     this.xt.clangame = 0;
                  }
               } else {
                  this.xt.playingame = -1;
                  this.xt.im = 0;
               }

               var40 = 0;
            }

            try {
               Thread.sleep(1000L);
            } catch (InterruptedException var18) {
            }
         }

         try {
            this.socket.close();
            this.socket = null;
            this.din.close();
            this.din = null;
            this.dout.close();
            this.dout = null;
         } catch (Exception var17) {
         }

         if (this.xt.playingame != -1) {
            this.hideinputs();
            this.xt.multion = 3;
            this.fase = 76;
            System.gc();
         } else {
            this.inishlobby();
         }
      }
   }

   public void stopallnow() {
      this.conon = 0;

      try {
         this.socket.close();
         this.socket = null;
         this.din.close();
         this.din = null;
         this.dout.close();
         this.dout = null;
      } catch (Exception var2) {
      }

      if (this.connector != null) {
         this.connector.stop();
         this.connector = null;
      }
   }

   public void lobby(int var1, int var2, boolean var3, int var4, CheckPoints var5, Control var6, ContO[] var7) {
      this.pre1 = false;
      this.pre2 = false;
      byte var8 = 0;
      if (this.xt.warning != 0 && this.xt.warning != 210) {
         this.xt.drawWarning();
         if (this.gs.cmsg.isShowing()) {
            this.gs.cmsg.hide();
            this.gs.requestFocus();
         }

         if (this.xt.warning > 220) {
            this.conon = 0;

            try {
               this.socket.close();
               this.socket = null;
               this.din.close();
               this.din = null;
               this.dout.close();
               this.dout = null;
            } catch (Exception var36) {
            }
         }

         this.xt.warning++;
      } else if (this.regnow) {
         this.xt.mainbg(3);
         this.btn = 0;
         if (this.gs.cmsg.isShowing()) {
            this.gs.cmsg.hide();
            this.gs.requestFocus();
         }

         this.rd.setComposite(AlphaComposite.getInstance(3, 0.2F));
         this.rd.drawImage(this.xt.bggo, 0, 0, null);
         this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
         this.rd.setColor(new Color(0, 0, 0));
         this.rd.fillRect(65, 425, 670, 25);
         this.rd.fillRect(0, 0, 65, 450);
         this.rd.fillRect(735, 0, 65, 450);
         this.rd.fillRect(65, 0, 670, 25);
         float var9 = 1.0F - (this.lg.flipo - 10) / 80.0F;
         if (var9 > 1.0F) {
            var9 = 1.0F;
         }

         if (var9 < 0.0F) {
            var9 = 0.0F;
         }

         this.rd.setComposite(AlphaComposite.getInstance(3, var9));
         if (this.lg.flipo <= 10) {
            this.rd.drawImage(this.xt.logomadnes, 97, 36, null);
         } else {
            this.rd.drawImage(this.xt.logomadnes, 97 + (int)(2.0 - Math.random() * 4.0), 36 + (int)(2.0 - Math.random() * 4.0), null);
         }

         this.lg.flipo++;
         if (this.lg.flipo > 50) {
            this.lg.flipo = 0;
         }

         byte var10 = 30;
         this.rd.setComposite(AlphaComposite.getInstance(3, 0.25F));
         this.rd.setColor(new Color(203, 227, 253));
         this.rd.fillRoundRect(115, 57 + var10, 570, 307, 20, 20);
         this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
         this.rd.setColor(this.color2k(90, 90, 90));
         this.rd.drawRoundRect(115, 57 + var10, 570, 307, 20, 20);
         this.rd.setFont(new Font("Arial", 1, 13));
         this.ftm = this.rd.getFontMetrics();
         this.rd.setColor(this.color2k(0, 0, 0));
         this.rd.drawString("You are allowed 5 multiplayer turns per day to try the game with your trial account.", 135, 85 + var10);
         this.rd.drawString("Upgrade your account to a full account to purchase and play the multiplayer game.", 135, 105 + var10);
         this.drawSbutton(this.xt.upgrade, 400, 130 + var10);
         this.rd.setColor(new Color(30, 70, 110));
         this.rd.drawString("You can upgrade your account by just sharing the game & posting about it online!", 135, 165 + var10);
         this.rd.drawString("Click 'Upgrade' for more details.", 135, 185 + var10);
         this.rd.drawString("Or try the multiplayer again tomorrow.", 135, 205 + var10);
         this.rd.setColor(this.color2k(0, 0, 0));
         this.rd.drawString("For now to preview and try the multiplayer more, with your trial account you can:", 135, 245 + var10);
         this.rd.setColor(new Color(30, 70, 110));
         this.rd.drawString("-  Watch online multiplayer games.", 135, 265 + var10);
         this.rd.drawString("-  Access the multiplayer dome.", 135, 285 + var10);
         this.rd.drawString("-  Play LAN multiplayer games (unlimitedly).", 135, 305 + var10);
         this.drawSbutton(this.xt.exit, 400, 336 + var10);
      } else if (this.onjoin != -1) {
         if (!this.jflexo) {
            this.xt.jflexo();
            this.jflexo = true;
         }

         this.btn = 0;
         if (this.gs.cmsg.isShowing()) {
            this.gs.cmsg.hide();
            this.gs.requestFocus();
         }

         this.rd.setColor(this.color2k(255, 255, 255));
         this.rd.fillRoundRect(155, 148, 490, 127, 20, 20);
         this.rd.setColor(new Color(0, 0, 0));
         this.rd.drawRoundRect(155, 148, 490, 127, 20, 20);
         if (this.ontyp == 76) {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            this.rd.drawString(": :   Custom Stage   : :", 400 - this.ftm.stringWidth(": :   Custom Stage   : :") / 2, 175);
            this.rd
               .drawString(
                  "You need to upgrade to a full account to join this game!",
                  400 - this.ftm.stringWidth("You need to upgrade to a full account to join this game!") / 2,
                  202
               );
            this.rd.setColor(this.color2k(200, 200, 200));
            this.rd.fillRoundRect(310, 215, 180, 50, 20, 20);
            this.drawSbutton(this.xt.upgrade, 400, 240);
            this.stringbutton("  Cancel X  ", 593, 259, 2);
         } else {
            String var37 = "";
            byte var41 = 0;
            if (this.ontyp >= 10) {
               var41 = 10;
               var37 = "Custom Cars";
               if (this.ontyp > 10) {
                  var37 = var37 + ", ";
               }
            }

            if (this.ontyp >= 20) {
               var41 = 20;
               var37 = "Game Cars";
               if (this.ontyp > 20) {
                  var37 = var37 + ", ";
               }
            }

            if (this.ontyp >= 30) {
               var41 = 30;
               var37 = "Clan Cars";
               if (this.ontyp > 30) {
                  var37 = var37 + ", ";
               }
            }

            if (this.ontyp - var41 == 1) {
               var37 = var37 + "Class C";
            }

            if (this.ontyp - var41 == 2) {
               var37 = var37 + "Class B & C";
            }

            if (this.ontyp - var41 == 3) {
               var37 = var37 + "Class B";
            }

            if (this.ontyp - var41 == 4) {
               var37 = var37 + "Class A & B";
            }

            if (this.ontyp - var41 == 5) {
               var37 = var37 + "Class A";
            }

            if (this.ontyp <= -2) {
               if (Math.abs(this.ontyp + 2) != 13) {
                  var37 = "" + this.cd.names[Math.abs(this.ontyp + 2)] + " Game";
               } else {
                  var37 = " " + this.cd.names[Math.abs(this.ontyp + 2)] + "  Game";
               }
            }

            this.rd.setColor(new Color(0, 0, 0));
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            this.rd.drawString(": :   " + var37 + "   : :", 400 - this.ftm.stringWidth(": :   " + var37 + "   : :") / 2, 175);
            var37 = "a";
            if (this.ontyp - var41 == 1) {
               var37 = "a class C";
            }

            if (this.ontyp - var41 == 2) {
               var37 = "a class B or C";
            }

            if (this.ontyp - var41 == 3) {
               var37 = "a class B";
            }

            if (this.ontyp - var41 == 4) {
               var37 = "a class A or B";
            }

            if (this.ontyp - var41 == 5) {
               var37 = "a class A";
            }

            if (var41 == 0) {
               var37 = var37 + " car";
            }

            if (var41 == 10) {
               var37 = var37 + " custom car";
            }

            if (var41 == 20) {
               var37 = var37 + " game car";
            }

            if (var41 == 30) {
               var37 = var37 + " clan car";
            }

            if (this.ontyp <= -2) {
               if (Math.abs(this.ontyp + 2) != 13) {
                  var37 = "" + this.cd.names[Math.abs(this.ontyp + 2)] + "";
               } else {
                  var37 = " " + this.cd.names[Math.abs(this.ontyp + 2)] + " ";
               }
            }

            this.rd
               .drawString(
                  "To join this game you need to have " + var37 + "!", 400 - this.ftm.stringWidth("To join this game you need to have " + var37 + "!") / 2, 206
               );
            this.stringbutton("  Get " + var37 + " now  ", 400, 247, 0);
            this.stringbutton("  Cancel X  ", 593, 259, 2);
            if (this.gb.open > 0 && this.gb.upo) {
               this.onjoin = -1;
            }
         }
      } else {
         this.xt.mainbg(3);
         if (this.britchl == -1) {
            this.ongame = -1;
            this.britchl = 0;
         }

         this.btn = 0;
         this.pbtn = 0;
         this.zeromsw = false;
         int var39 = this.npo;
         if (this.invo) {
            var39 = 0;

            for (int var42 = 0; var42 < this.npo; var42++) {
               if (this.pgames[var42] == -1) {
                  var39++;
               }
            }

            var39 += 2;
         }

         int var43 = (var39 - 11) * 30;
         if (var43 < 0) {
            var43 = 0;
         }

         int var11 = (int)(this.spos / 295.0F * var43);
         int var12 = 0;
         int var13 = -1;
         int var14 = -1;
         if (this.conon == 1) {
            if (!this.invo) {
               for (int var15 = 0; var15 < this.npo; var15++) {
                  if (this.pgames[var15] != -1) {
                     int var16 = 0;

                     for (int var17 = 0; var17 < this.ngm; var17++) {
                        if (this.pgames[var15] == this.gnum[var17]) {
                           var16 = var17;
                        }
                     }

                     if (this.wait[var16] > 0) {
                        if (82 + 30 * var12 - var11 > 50 && 82 + 30 * (var12 - 1) - var11 < 415) {
                           boolean var80 = false;
                           if (var1 > 70 && var1 < 185 && var2 > 52 + 30 * var12 - var11 && var2 < 82 + 30 * var12 - var11) {
                              if (this.pgames[this.im] == -1 && this.join == -1 && this.chalngd >= -1) {
                                 if (!var3 && this.mousonp != var15) {
                                    this.rd.setColor(this.color2k(220, 220, 220));
                                 } else {
                                    this.rd.setColor(this.color2k(255, 255, 255));
                                    this.mousonp = var15;
                                    var14 = 52 + 30 * var12 - var11;
                                    if (!var3) {
                                       if (this.cmonp == -1) {
                                          this.ongame = -1;
                                          this.cmonp = var15;
                                       }

                                       if (this.ongame == this.pgames[var15]) {
                                          this.mousonp = -1;
                                       }
                                    } else {
                                       if (this.cmonp == var15) {
                                          this.ongame = this.pgames[var15];
                                       }

                                       this.chalngd = -1;
                                    }
                                 }

                                 this.rd.fillRect(70, 53 + 30 * var12 - var11, 116, 29);
                                 var13 = var15;
                              }

                              var80 = true;
                              if (var6.handb) {
                                 this.gs.cmsg.setText(this.gs.cmsg.getText() + "" + this.pnames[var15]);
                                 var6.handb = false;
                              }
                           }

                           if (this.pgames[this.im] == -1 && this.join == -1 && this.chalngd >= -1) {
                              this.rd.setColor(new Color(49, 79, 0));
                           } else {
                              this.rd.setColor(new Color(34, 55, 0));
                           }

                           boolean var18 = this.gb.drawl(this.rd, this.pnames[var15], 68, 53 + 30 * var12 - var11, var80);
                           if (!var80 || !var18) {
                              this.rd.setFont(new Font("Arial", 1, 12));
                              this.ftm = this.rd.getFontMetrics();
                              this.rd.drawString(this.pnames[var15], 127 - this.ftm.stringWidth(this.pnames[var15]) / 2, 66 + 30 * var12 - var11);
                              this.rd.setFont(new Font("Arial", 0, 10));
                              this.ftm = this.rd.getFontMetrics();
                              this.rd.drawString(this.pcarnames[var15], 127 - this.ftm.stringWidth(this.pcarnames[var15]) / 2, 78 + 30 * var12 - var11);
                           }

                           this.rd.setColor(this.color2k(150, 150, 150));
                           this.rd.drawLine(70, 82 + 30 * var12 - var11, 185, 82 + 30 * var12 - var11);
                        }

                        var12++;
                     }
                  }
               }
            }

            int var49 = -1;
            if (this.invo) {
               for (int var61 = 0; var61 < this.ngm; var61++) {
                  if (this.gwarb[var61] != 0 && this.pgames[this.im] == this.gnum[var61]) {
                     var49 = var61;
                  }
               }

               this.rd.setColor(new Color(0, 0, 0));
               this.rd.setFont(new Font("Arial", 1, 12));
               this.ftm = this.rd.getFontMetrics();
               if (var49 != -1) {
                  this.rd.drawString("Members of Clans", 127 - this.ftm.stringWidth("Members of Clans") / 2, 75 - var11);
               } else {
                  this.rd.drawString("Free Players", 127 - this.ftm.stringWidth("Free Players") / 2, 75 - var11);
               }

               this.rd.setFont(new Font("Arial", 0, 10));
               this.ftm = this.rd.getFontMetrics();
               this.rd.drawString("Click a player to invite:", 127 - this.ftm.stringWidth("Click a player to invite:") / 2, 92 - var11);
               this.rd.setColor(this.color2k(150, 150, 150));
               this.rd.drawLine(70, 112 - var11, 185, 112 - var11);
               var12 += 2;
            }

            for (int var62 = 0; var62 < this.npo; var62++) {
               boolean var81 = false;
               if (this.invo) {
                  if (this.im == var62) {
                     var81 = true;
                  }

                  for (int var96 = 0; var96 < 7; var96++) {
                     if (this.invos[var96].equals(this.pnames[var62]) && !var81) {
                        var81 = true;
                     }
                  }

                  if (var49 != -1
                     && !this.pclan[var62].toLowerCase().equals(this.gaclan[var49].toLowerCase())
                     && !this.pclan[var62].toLowerCase().equals(this.gvclan[var49].toLowerCase())) {
                     var81 = true;
                  }
               }

               if (this.pgames[var62] == -1 && !var81) {
                  if (82 + 30 * var12 - var11 > 50 && 82 + 30 * (var12 - 1) - var11 < 415) {
                     boolean var97 = false;
                     if (var1 > 70 && var1 < 185 && var2 > 52 + 30 * var12 - var11 && var2 < 82 + 30 * var12 - var11) {
                        if (!this.invo) {
                           if (this.pgames[this.im] == -1 && this.join == -1 && this.chalngd >= -1) {
                              var8 = 12;
                              if (var3) {
                                 if (!this.gb.proname.equals(this.pnames[var62])) {
                                    this.gb.proname = this.pnames[var62];
                                    this.gb.loadedp = false;
                                 }

                                 this.gb.tab = 1;
                                 this.gb.open = 2;
                                 this.gb.upo = true;
                              }
                           }
                        } else {
                           if (var3) {
                              this.rd.setColor(this.color2k(255, 255, 255));
                              this.mousonp = var62;
                           } else {
                              this.rd.setColor(this.color2k(220, 220, 220));
                              if (this.mousonp == var62) {
                                 int var19 = 0;

                                 for (boolean var20 = false; var19 < 7 && !var20; var19++) {
                                    if (this.invos[var19].equals("")) {
                                       this.invos[var19] = this.pnames[var62];
                                       var20 = true;
                                    }
                                 }

                                 this.mousonp = -1;
                                 this.invo = false;
                              }
                           }

                           this.rd.fillRect(70, 53 + 30 * var12 - var11, 116, 29);
                           var13 = var62;
                        }

                        var97 = true;
                        if (var6.handb) {
                           this.gs.cmsg.setText(this.gs.cmsg.getText() + "" + this.pnames[var62]);
                           var6.handb = false;
                        }
                     }

                     if (!this.invo) {
                        this.rd.setColor(new Color(0, 0, 0));
                     } else {
                        this.rd.setColor(new Color(62, 98, 0));
                     }

                     boolean var113 = this.gb.drawl(this.rd, this.pnames[var62], 68, 53 + 30 * var12 - var11, var97);
                     if (!var97 || !var113) {
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString(this.pnames[var62], 127 - this.ftm.stringWidth(this.pnames[var62]) / 2, 66 + 30 * var12 - var11);
                        this.rd.setFont(new Font("Arial", 0, 10));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString(this.pcarnames[var62], 127 - this.ftm.stringWidth(this.pcarnames[var62]) / 2, 78 + 30 * var12 - var11);
                     }

                     this.rd.setColor(this.color2k(150, 150, 150));
                     this.rd.drawLine(70, 82 + 30 * var12 - var11, 185, 82 + 30 * var12 - var11);
                  }

                  var12++;
               }
            }

            if (this.invo && var12 == 2) {
               this.invo = false;
            }

            if (!this.invo) {
               for (int var63 = this.npo - 1; var63 >= 0; var63--) {
                  if (this.pgames[var63] != -1) {
                     int var82 = 0;

                     for (int var98 = 0; var98 < this.ngm; var98++) {
                        if (this.pgames[var63] == this.gnum[var98]) {
                           var82 = var98;
                        }
                     }

                     if (this.wait[var82] <= 0) {
                        boolean var99 = false;

                        for (int var114 = 0; var114 < this.npo; var114++) {
                           if (var63 != var114 && this.pnames[var63].equals(this.pnames[var114])) {
                              if (this.pgames[var114] != -1) {
                                 for (int var129 = 0; var129 < this.ngm; var129++) {
                                    if (this.pgames[var114] == this.gnum[var129] && this.wait[var129] > 0) {
                                       var99 = true;
                                    }
                                 }
                              } else {
                                 var99 = true;
                              }
                           }
                        }

                        if (!var99) {
                           if (82 + 30 * var12 - var11 > 50 && 82 + 30 * (var12 - 1) - var11 < 415) {
                              boolean var115 = false;
                              if (var1 > 70 && var1 < 185 && var2 > 52 + 30 * var12 - var11 && var2 < 82 + 30 * var12 - var11) {
                                 if (this.pgames[this.im] == -1 && this.join == -1 && this.chalngd >= -1) {
                                    if (!var3 && this.mousonp != var63) {
                                       this.rd.setColor(this.color2k(220, 220, 220));
                                    } else {
                                       this.rd.setColor(this.color2k(255, 255, 255));
                                       this.mousonp = var63;
                                       var14 = 52 + 30 * var12 - var11;
                                       if (!var3) {
                                          if (this.cmonp == -1) {
                                             this.ongame = -1;
                                             this.cmonp = var63;
                                          }

                                          if (this.ongame == this.pgames[var63]) {
                                             this.mousonp = -1;
                                          }
                                       } else {
                                          if (this.cmonp == var63) {
                                             this.ongame = this.pgames[var63];
                                          }

                                          this.chalngd = -1;
                                       }
                                    }

                                    this.rd.fillRect(70, 53 + 30 * var12 - var11, 116, 29);
                                    var13 = var63;
                                 }

                                 var115 = true;
                                 if (var6.handb) {
                                    this.gs.cmsg.setText(this.gs.cmsg.getText() + "" + this.pnames[var63]);
                                    var6.handb = false;
                                 }
                              }

                              if (this.pgames[this.im] == -1 && this.join == -1 && this.chalngd >= -1) {
                                 if (this.wait[var82] != 0) {
                                    this.rd.setColor(this.color2k(0, 28, 102));
                                 } else {
                                    this.rd.setColor(new Color(117, 67, 0));
                                 }
                              } else if (this.wait[var82] != 0) {
                                 this.rd.setColor(this.color2k(0, 20, 71));
                              } else {
                                 this.rd.setColor(new Color(82, 47, 0));
                              }

                              boolean var130 = this.gb.drawl(this.rd, this.pnames[var63], 68, 53 + 30 * var12 - var11, var115);
                              if (!var115 || !var130) {
                                 this.rd.setFont(new Font("Arial", 1, 12));
                                 this.ftm = this.rd.getFontMetrics();
                                 this.rd.drawString(this.pnames[var63], 127 - this.ftm.stringWidth(this.pnames[var63]) / 2, 66 + 30 * var12 - var11);
                                 this.rd.setFont(new Font("Arial", 0, 10));
                                 this.ftm = this.rd.getFontMetrics();
                                 this.rd.drawString(this.pcarnames[var63], 127 - this.ftm.stringWidth(this.pcarnames[var63]) / 2, 78 + 30 * var12 - var11);
                              }

                              this.rd.setColor(this.color2k(150, 150, 150));
                              this.rd.drawLine(70, 82 + 30 * var12 - var11, 185, 82 + 30 * var12 - var11);
                           }

                           var12++;
                        }
                     }
                  }
               }
            }
         }

         if (this.mousonp != var13) {
            this.mousonp = -1;
            this.cmonp = -1;
         }

         if (this.npo == 0) {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.setFont(new Font("Arial", 1, 12));
            this.ftm = this.rd.getFontMetrics();
            this.rd.drawString("|  Loading Players  |", 127 - this.ftm.stringWidth("|  Loading Players  |") / 2, 95);
         }

         this.rd.setColor(this.color2k(205, 205, 205));
         this.rd.fillRect(65, 25, 145, 28);
         this.rd.setColor(this.color2k(150, 150, 150));
         this.rd.drawLine(65, 50, 190, 50);
         this.rd.setColor(this.color2k(205, 205, 205));
         this.rd.fillRect(65, 413, 145, 12);
         this.rd.setColor(this.color2k(150, 150, 150));
         this.rd.drawLine(65, 415, 190, 415);
         this.rd.setColor(this.color2k(205, 205, 205));
         this.rd.fillRect(193, 53, 17, 360);
         this.rd.setColor(new Color(0, 0, 0));
         this.rd.drawLine(211, 25, 211, 425);
         this.rd.drawImage(this.xt.roomp, 72, 30, null);
         if (this.mscro != 131 && var43 != 0) {
            this.rd.setColor(this.color2k(220, 220, 220));
            this.rd.fill3DRect(193, 53, 17, 17, true);
         } else {
            if (var43 != 0) {
               this.rd.setColor(this.color2k(215, 215, 215));
            } else {
               this.rd.setColor(this.color2k(205, 205, 205));
            }

            this.rd.fillRect(193, 53, 17, 17);
         }

         if (var43 != 0) {
            this.rd.drawImage(this.xt.asu, 198, 59, null);
         }

         if (this.mscro != 132 && var43 != 0) {
            this.rd.setColor(this.color2k(220, 220, 220));
            this.rd.fill3DRect(193, 396, 17, 17, true);
         } else {
            if (var43 != 0) {
               this.rd.setColor(this.color2k(215, 215, 215));
            } else {
               this.rd.setColor(this.color2k(205, 205, 205));
            }

            this.rd.fillRect(193, 396, 17, 17);
         }

         if (var43 != 0) {
            this.rd.drawImage(this.xt.asd, 198, 403, null);
         }

         if (var43 != 0 && this.conon == 1) {
            if (this.lspos == this.spos) {
               if (this.mscro == 131) {
                  this.rd.setColor(this.color2k(215, 215, 215));
               }

               this.rd.fill3DRect(193, 70 + this.spos, 17, 31, true);
            } else {
               this.rd.setColor(this.color2k(215, 215, 215));
               this.rd.fillRect(193, 70 + this.spos, 17, 31);
            }

            this.rd.setColor(this.color2k(150, 150, 150));
            this.rd.drawLine(198, 83 + this.spos, 204, 83 + this.spos);
            this.rd.drawLine(198, 85 + this.spos, 204, 85 + this.spos);
            this.rd.drawLine(198, 87 + this.spos, 204, 87 + this.spos);
            if (this.mscro > 101 && this.lspos != this.spos) {
               this.lspos = this.spos;
            }

            if (!var3) {
               if (this.mscro != 125) {
                  this.mscro = 125;
               }
            } else {
               if (this.mscro == 125 && var1 > 193 && var1 < 210 && var2 > 70 + this.spos && var2 < this.spos + 101) {
                  this.mscro = var2 - this.spos;
               }

               if (this.mscro == 125 && var1 > 191 && var1 < 212 && var2 > 51 && var2 < 72) {
                  this.mscro = 131;
               }

               if (this.mscro == 125 && var1 > 191 && var1 < 212 && var2 > 394 && var2 < 415) {
                  this.mscro = 132;
               }

               if (this.mscro == 125 && var1 > 193 && var1 < 210 && var2 > 70 && var2 < 396) {
                  this.mscro = 85;
                  this.spos = var2 - this.mscro;
               }

               int var50 = 1350 / var43;
               if (var50 < 1) {
                  var50 = 1;
               }

               if (this.mscro == 131) {
                  this.spos -= var50;
                  if (this.spos > 295) {
                     this.spos = 295;
                  }

                  if (this.spos < 0) {
                     this.spos = 0;
                  }

                  this.lspos = this.spos;
               }

               if (this.mscro == 132) {
                  this.spos += var50;
                  if (this.spos > 295) {
                     this.spos = 295;
                  }

                  if (this.spos < 0) {
                     this.spos = 0;
                  }

                  this.lspos = this.spos;
               }

               if (this.mscro <= 101) {
                  this.spos = var2 - this.mscro;
                  if (this.spos > 295) {
                     this.spos = 295;
                  }

                  if (this.spos < 0) {
                     this.spos = 0;
                  }
               }

               if (this.mscro == 125) {
                  this.mscro = 225;
               }
            }

            if (var4 != 0 && var1 > 65 && var1 < 170 && var2 > 93 && var2 < 413) {
               this.spos -= var4;
               this.zeromsw = true;
               if (this.spos > 295) {
                  this.spos = 295;
                  this.zeromsw = false;
               }

               if (this.spos < 0) {
                  this.spos = 0;
                  this.zeromsw = false;
               }

               this.lspos = this.spos;
            }
         }

         if (this.ongame != -1) {
            if (this.opengame >= 26) {
               this.rd.setColor(this.color2k(255, 255, 255));
               this.rd.fillRoundRect(225, 1, 495, 417, 20, 20);
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawRoundRect(225, 1, 495, 417, 20, 20);
               if ((this.join <= -1 || this.pgames[this.im] == this.join) && this.join != -2) {
                  int var51 = 0;

                  for (int var64 = 0; var64 < this.ngm; var64++) {
                     if (this.ongame == this.gnum[var64]) {
                        var51 = var64;
                     }
                  }

                  this.rd.setFont(new Font("Arial", 1, 11));
                  this.ftm = this.rd.getFontMetrics();
                  this.rd.setColor(new Color(0, 0, 0));
                  byte var65 = 23;
                  byte var83 = 0;
                  if (this.gwarb[var51] != 0) {
                     var65 = 28;
                     var83 = 2;
                     String var100 = "Clan war";
                     if (this.gwarb[var51] == 2) {
                        var100 = "Car battle";
                     }

                     if (this.gwarb[var51] == 3) {
                        var100 = "Stage battle";
                     }

                     this.rd.drawString("" + var100 + " between " + this.gaclan[var51] + " and " + this.gvclan[var51] + "", 243, 14);
                  }

                  String var101 = "";
                  String var116 = "";
                  String var131 = "";
                  if (this.conon != 1) {
                     this.rd.drawString("Status:", 241 + var83, var65);
                     this.rd.setColor(new Color(128, 73, 0));
                     this.rd.drawString("Starting...", 286 + var83, var65);
                  } else {
                     if (this.wait[var51] > 0) {
                        if (this.gwarb[var51] != 0) {
                           String var21 = "Game #" + this.gameturn[var51] + "";
                           if (this.gcrs[var51] == 1) {
                              var21 = var21 + " | Clan Cars";
                           }

                           if (this.gcrs[var51] == 2) {
                              var21 = var21 + " | Game Cars";
                           }

                           if (this.gclss[var51] == 1) {
                              var21 = var21 + " | Class C";
                           }

                           if (this.gclss[var51] == 2) {
                              var21 = var21 + " | Class B & C";
                           }

                           if (this.gclss[var51] == 3) {
                              var21 = var21 + " | Class B";
                           }

                           if (this.gclss[var51] == 4) {
                              var21 = var21 + " | Class A & B";
                           }

                           if (this.gclss[var51] == 5) {
                              var21 = var21 + " | Class A";
                           }

                           if (this.gfx[var51] == 1) {
                              var21 = var21 + " | 4 Fixes";
                           }

                           if (this.gfx[var51] == 2) {
                              var21 = var21 + " | 3 Fixes";
                           }

                           if (this.gfx[var51] == 3) {
                              var21 = var21 + " | 2 Fixes";
                           }

                           if (this.gfx[var51] == 4) {
                              var21 = var21 + " | 1 Fix";
                           }

                           if (this.gfx[var51] == 5) {
                              var21 = var21 + " | No Fixing";
                           }

                           this.rd.setColor(new Color(80, 128, 0));
                           this.rd.drawString(var21, 243, 28);
                        } else {
                           String var138 = "";
                           if (!this.gplyrs[var51].equals("")) {
                              var138 = "Private Game";
                           } else {
                              var138 = "Public Game";
                           }

                           if (this.gfx[var51] == 1) {
                              var138 = var138 + " | 4 Fixes";
                           }

                           if (this.gfx[var51] == 2) {
                              var138 = var138 + " | 3 Fixes";
                           }

                           if (this.gfx[var51] == 3) {
                              var138 = var138 + " | 2 Fixes";
                           }

                           if (this.gfx[var51] == 4) {
                              var138 = var138 + " | 1 Fix";
                           }

                           if (this.gfx[var51] == 5) {
                              var138 = var138 + " | No Fixing";
                           }

                           String var22 = "";
                           if (this.gclss[var51] <= -2) {
                              var22 = "" + this.cd.names[Math.abs(this.gclss[var51] + 2)] + "";
                           } else {
                              if (this.gcrs[var51] == 1) {
                                 var22 = "Custom Cars";
                              }

                              if (this.gcrs[var51] == 2) {
                                 var22 = "Game Cars";
                              }

                              String var23 = "";
                              if (this.gclss[var51] == 1) {
                                 var23 = "Class C";
                              }

                              if (this.gclss[var51] == 2) {
                                 var23 = "Class B & C";
                              }

                              if (this.gclss[var51] == 3) {
                                 var23 = "Class B";
                              }

                              if (this.gclss[var51] == 4) {
                                 var23 = "Class A & B";
                              }

                              if (this.gclss[var51] == 5) {
                                 var23 = "Class A";
                              }

                              if (!var22.equals("") && !var23.equals("")) {
                                 var22 = var22 + " | " + var23;
                              } else {
                                 var22 = var22 + var23;
                              }
                           }

                           if (!var22.equals("")) {
                              this.rd.drawString("Type:", 243, 14);
                              this.rd.drawString("Cars:", 244, 28);
                              this.rd.setColor(new Color(80, 128, 0));
                              this.rd.drawString(var138, 279, 14);
                              this.rd.drawString(var22, 279, 28);
                           } else {
                              this.rd.drawString("Type:", 243, 23);
                              this.rd.setColor(new Color(80, 128, 0));
                              this.rd.drawString(var138, 279, 23);
                           }
                        }
                     }

                     if (this.wait[var51] == 0) {
                        this.rd.drawString("Status:", 241 + var83, var65);
                        this.rd.setColor(new Color(128, 73, 0));
                        if (this.prevloaded != 0) {
                           this.rd.drawString("Started", 286 + var83, var65);
                        } else {
                           this.rd.drawString("Starting...", 286 + var83, var65);
                        }
                     }

                     if (this.wait[var51] == -1) {
                        this.rd.drawString("Status:", 241 + var83, var65);
                        this.rd.setColor(this.color2k(100, 100, 100));
                        this.rd.drawString("Finished", 286 + var83, var65);
                     }
                  }

                  if (this.gwarb[var51] != 0) {
                     if (this.wait[var51] == 0 || this.wait[var51] == -1 || this.conon != 1) {
                        this.rd.setColor(this.color2k(200, 200, 200));
                        this.rd.drawRect(349, 16, 253, 16);
                        this.rd.setFont(new Font("Arial", 0, 11));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.setColor(new Color(0, 0, 0));
                        byte var140 = 0;
                        byte var146 = 0;
                        if (this.wait[var51] == -1) {
                           String[] var151 = new String[]{"", "", "", "", "", "", "", ""};

                           for (int var24 = 0; var24 < this.prnpo; var24++) {
                              for (int var25 = 0; var25 < this.npo; var25++) {
                                 if (this.prnames[var24].equals(this.pnames[var25]) && this.pgames[var25] == this.gnum[var51]) {
                                    var151[var24] = this.pclan[var25];
                                 }
                              }
                           }

                           for (int var167 = 0; var167 < this.prnpo; var167++) {
                              if (this.ppos[var167] == 0) {
                                 var101 = var151[var167];
                                 break;
                              }
                           }

                           if (var101.equals("")) {
                              var131 = "No one finished first - no one survived!";
                           } else {
                              if (this.gwtyp[var51] == 2) {
                                 boolean var168 = false;

                                 for (int var190 = 0; var190 < this.prnpo; var190++) {
                                    if (!var151[var190].toLowerCase().equals(var101.toLowerCase()) && this.pdam[var190] < 55 && this.pdam[var190] != -17) {
                                       var168 = true;
                                       break;
                                    }
                                 }

                                 if (!var168) {
                                    var131 = "" + var101 + " should have raced in this game!";
                                    var101 = "";
                                 }
                              }

                              if (this.gwtyp[var51] == 3) {
                                 boolean var169 = true;

                                 for (int var191 = 0; var191 < this.prnpo; var191++) {
                                    if (!var151[var191].toLowerCase().equals(var101.toLowerCase()) && this.pdam[var191] < 55 && this.pdam[var191] != -17) {
                                       var169 = false;
                                       break;
                                    }
                                 }

                                 if (!var169) {
                                    var131 = "" + var101 + " should have wasted in this game!";
                                    var101 = "";
                                 }
                              }

                              if (this.gwtyp[var51] == 4) {
                                 if (!var101.toLowerCase().equals(this.gaclan[var51].toLowerCase())) {
                                    boolean var170 = false;

                                    for (int var192 = 0; var192 < this.prnpo; var192++) {
                                       if (!var151[var192].toLowerCase().equals(var101.toLowerCase()) && this.pdam[var192] < 55 && this.pdam[var192] != -17) {
                                          var170 = true;
                                          break;
                                       }
                                    }

                                    if (!var170) {
                                       var131 = "" + var101 + " should have raced in this game!";
                                       var101 = "";
                                    }
                                 } else {
                                    boolean var171 = true;

                                    for (int var193 = 0; var193 < this.prnpo; var193++) {
                                       if (!var151[var193].toLowerCase().equals(var101.toLowerCase()) && this.pdam[var193] < 55 && this.pdam[var193] != -17) {
                                          var171 = false;
                                          break;
                                       }
                                    }

                                    if (!var171) {
                                       var131 = "" + var101 + " should have wasted in this game!";
                                       var101 = "";
                                    }
                                 }
                              }

                              if (this.gwtyp[var51] == 5) {
                                 if (var101.toLowerCase().equals(this.gaclan[var51].toLowerCase())) {
                                    boolean var173 = false;

                                    for (int var195 = 0; var195 < this.prnpo; var195++) {
                                       if (!var151[var195].toLowerCase().equals(var101.toLowerCase()) && this.pdam[var195] < 55 && this.pdam[var195] != -17) {
                                          var173 = true;
                                          break;
                                       }
                                    }

                                    if (!var173) {
                                       var131 = "" + var101 + " should have raced in this game!";
                                       var101 = "";
                                    }
                                 } else {
                                    boolean var172 = true;

                                    for (int var194 = 0; var194 < this.prnpo; var194++) {
                                       if (!var151[var194].toLowerCase().equals(var101.toLowerCase()) && this.pdam[var194] < 55 && this.pdam[var194] != -17) {
                                          var172 = false;
                                          break;
                                       }
                                    }

                                    if (!var172) {
                                       var131 = "" + var101 + " should have wasted in this game!";
                                       var101 = "";
                                    }
                                 }
                              }
                           }

                           if (var101.toLowerCase().equals(this.gaclan[var51].toLowerCase())) {
                              var140 = 1;
                           }

                           if (var101.toLowerCase().equals(this.gvclan[var51].toLowerCase())) {
                              var146 = 1;
                           }
                        }

                        this.rd
                           .drawString(
                              ""
                                 + this.gaclan[var51]
                                 + " : "
                                 + (this.gascore[var51] + var140)
                                 + "     |     "
                                 + this.gvclan[var51]
                                 + " : "
                                 + (this.gvscore[var51] + var146)
                                 + "",
                              474
                                 - this.ftm
                                       .stringWidth(
                                          ""
                                             + this.gaclan[var51]
                                             + " : "
                                             + this.gascore[var51]
                                             + "     |     "
                                             + this.gvclan[var51]
                                             + " : "
                                             + this.gvscore[var51]
                                             + ""
                                       )
                                    / 2,
                              28
                           );
                        if (this.gwarb[var51] != 1) {
                           if (this.gascore[var51] + var140 >= 3) {
                              var116 = "" + this.gaclan[var51] + " wins the battle!";
                           }

                           if (this.gvscore[var51] + var146 >= 3) {
                              var116 = "" + this.gvclan[var51] + " wins the battle!";
                           }
                        } else {
                           if (this.gascore[var51] + var140 >= 5) {
                              var116 = "" + this.gaclan[var51] + " wins the war!";
                           }

                           if (this.gvscore[var51] + var146 >= 5) {
                              var116 = "" + this.gvclan[var51] + " wins the war!";
                           }
                        }
                     }
                  } else {
                     this.rd.setColor(new Color(0, 0, 0));
                     if (!this.gmaker[var51].equals(this.pnames[this.im])) {
                        this.rd.drawString("Created by", 449, 23);
                        this.rd.drawString(":", 511, 23);
                        this.rd.drawString(this.gmaker[var51], 520, 23);
                     } else {
                        this.rd.drawString("Created by You", 449, 23);
                     }
                  }

                  this.rd.setColor(this.color2k(200, 200, 200));
                  this.rd.drawLine(233, 32, 602, 32);
                  this.rd.drawLine(602, 7, 602, 32);
                  if (this.conon == 1) {
                     if (this.pgames[this.im] != this.ongame) {
                        this.stringbutton("Close X", 679, 26, 0);
                     } else {
                        this.stringbutton("Leave Game X", 660, 26, 0);
                     }
                  }

                  this.rd.drawImage(this.xt.pls, 292, 39, null);
                  if (this.opengame != 27) {
                     this.m.crs = true;
                     this.m.x = -335;
                     this.m.y = 0;
                     this.m.z = -50;
                     this.m.xz = 0;
                     this.m.zy = 20;
                     this.m.ground = -2000;
                     this.pend = 0;
                     this.pendb = false;
                     this.ptime = 0L;
                     this.opengame = 27;
                  }

                  int var141 = 0;
                  int var147 = -1;

                  for (int var152 = 0; var152 < this.npo; var152++) {
                     if (this.pgames[var152] == this.ongame) {
                        this.rd.setColor(this.color2k(240, 240, 240));
                        if (var152 == this.im && this.wait[var51] != -1) {
                           if (this.nflk != 0 && this.conon != 2) {
                              this.nflk--;
                           } else {
                              this.rd.setColor(this.color2k(255, 255, 255));
                              this.nflk = 3;
                           }
                        }

                        this.rd.fillRect(237, 54 + var141 * 42, 170, 40);
                        this.rd.setColor(this.color2k(200, 200, 200));
                        if (this.gwarb[var51] == 0) {
                           if (this.wait[var51] == -1 && this.prevloaded == 1) {
                              for (int var174 = 0; var174 < this.prnpo; var174++) {
                                 if (this.pnames[var152].equals(this.prnames[var174]) && this.ppos[var174] == 0 && this.nflk == 0) {
                                    this.rd.setColor(new Color(0, 0, 0));
                                 }
                              }
                           }
                        } else {
                           if (this.pclan[var152].toLowerCase().equals(this.gaclan[var51].toLowerCase())) {
                              this.rd.setColor(new Color(255, 128, 0));
                           }

                           if (this.pclan[var152].toLowerCase().equals(this.gvclan[var51].toLowerCase())) {
                              this.rd.setColor(new Color(0, 128, 255));
                           }

                           if (this.wait[var51] == -1
                              && this.prevloaded == 1
                              && var101.toLowerCase().equals(this.pclan[var152].toLowerCase())
                              && this.nflk == 0) {
                              this.rd.setColor(new Color(0, 0, 0));
                           }
                        }

                        this.rd.drawRect(237, 54 + var141 * 42, 170, 40);
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString(this.pnames[var152], 282 - this.ftm.stringWidth(this.pnames[var152]) / 2, 72 + var141 * 42);
                        this.rd.setFont(new Font("Arial", 0, 10));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString(this.pcarnames[var152], 282 - this.ftm.stringWidth(this.pcarnames[var152]) / 2, 84 + var141 * 42);
                        this.m.crs = true;
                        this.m.x = -335;
                        this.m.y = 0;
                        this.m.z = -50;
                        this.m.xz = 0;
                        this.m.zy = 20;
                        this.m.ground = -2000;
                        if (this.pcars[var152] == -1) {
                           this.rd.setFont(new Font("Arial", 1, 11));
                           this.rd.setColor(this.color2k(80, 80, 80));
                           this.rd.drawString("Loading...", 339, 77 + var141 * 42);
                        } else {
                           for (int var175 = 0; var175 < var7[this.pcars[var152]].npl; var175++) {
                              var7[this.pcars[var152]].p[var175].flx = 0;
                              if (var7[this.pcars[var152]].p[var175].colnum == 1) {
                                 var7[this.pcars[var152]].p[var175].hsb[0] = this.pcols[var152][0];
                                 var7[this.pcars[var152]].p[var175].hsb[1] = this.pcols[var152][1];
                                 var7[this.pcars[var152]].p[var175].hsb[2] = 1.0F - this.pcols[var152][2];
                              }

                              if (var7[this.pcars[var152]].p[var175].colnum == 2) {
                                 var7[this.pcars[var152]].p[var175].hsb[0] = this.pcols[var152][3];
                                 var7[this.pcars[var152]].p[var175].hsb[1] = this.pcols[var152][4];
                                 var7[this.pcars[var152]].p[var175].hsb[2] = 1.0F - this.pcols[var152][5];
                              }
                           }

                           if (this.cac[var141] != this.pcars[var152]) {
                              int var176 = var7[this.pcars[var152]].p[0].oz[0];
                              int var196 = var176;
                              int var26 = var7[this.pcars[var152]].p[0].oy[0];
                              int var27 = var26;

                              for (int var28 = 0; var28 < var7[this.pcars[var152]].npl; var28++) {
                                 for (int var29 = 0; var29 < var7[this.pcars[var152]].p[var28].n; var29++) {
                                    if (var7[this.pcars[var152]].p[var28].oz[var29] < var176) {
                                       var176 = var7[this.pcars[var152]].p[var28].oz[var29];
                                    }

                                    if (var7[this.pcars[var152]].p[var28].oz[var29] > var196) {
                                       var196 = var7[this.pcars[var152]].p[var28].oz[var29];
                                    }

                                    if (var7[this.pcars[var152]].p[var28].oy[var29] < var26) {
                                       var26 = var7[this.pcars[var152]].p[var28].oy[var29];
                                    }

                                    if (var7[this.pcars[var152]].p[var28].oy[var29] > var27) {
                                       var27 = var7[this.pcars[var152]].p[var28].oy[var29];
                                    }
                                 }
                              }

                              this.cax[var141] = (var196 + var176) / 2;
                              this.cay[var141] = (var27 + var26) / 2;
                              this.cac[var141] = this.pcars[var152];
                           }

                           if (var1 > 327 && var1 < 402 && var2 > 57 + var141 * 42 && var2 < 91 + var141 * 42) {
                              var8 = 12;
                              var147 = var152;

                              for (int var177 = 0; var177 < var7[this.pcars[var152]].npl; var177++) {
                                 var7[this.pcars[var152]].p[var177].flx = 77;
                              }
                           }

                           var7[this.pcars[var152]].z = 2500 - var141 * 80;
                           var7[this.pcars[var152]].y = 150 + 250 * var141 - this.cay[var141];
                           var7[this.pcars[var152]].x = -145 - this.cax[var141];
                           var7[this.pcars[var152]].zy = 0;
                           var7[this.pcars[var152]].xz = -90;
                           var7[this.pcars[var152]].xy = this.pend - var141 * 5;
                           this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
                           var7[this.pcars[var152]].d(this.rd);
                           this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                        }

                        var141++;
                     }
                  }

                  if (this.pendb) {
                     this.pend -= 2;
                     if (this.pend < -10) {
                        this.pendb = false;
                     }
                  } else {
                     this.pend += 2;
                     if (this.pend > 80) {
                        this.pendb = true;
                     }
                  }

                  if (var147 == -1) {
                     if (this.mousedout) {
                        this.mousedout = false;
                     }
                  } else if (!var3) {
                     if (this.mousedout) {
                        if (this.dispcar != var147 && var147 != -1 && this.cd.action != 6) {
                           this.cd.action = 0;
                           this.dispcar = var147;
                           this.forcar = this.pcars[var147];
                           this.dispco = null;
                           System.gc();
                           this.dispco = new ContO(var7[this.forcar], 0, 0, 0, 0);
                        } else {
                           this.dispcar = -1;
                        }

                        this.mousedout = false;
                     }
                  } else {
                     this.mousedout = true;
                  }

                  for (int var153 = 0; var153 < 7; var153++) {
                     for (int var178 = 0; var178 < this.npo; var178++) {
                        if (this.pgames[var178] == this.ongame
                           && this.invos[var153].equals(this.pnames[var178])
                           && this.dinvi[var153].equals(this.invos[var153])) {
                           for (int var197 = var153; var197 < 6; var197++) {
                              this.invos[var197] = this.invos[var197 + 1];
                              this.dinvi[var197] = this.dinvi[var197 + 1];
                           }

                           this.invos[6] = "";
                           this.dinvi[6] = "";
                        }
                     }
                  }

                  if (this.wait[var51] > 0) {
                     int var154 = 0;

                     for (int var179 = var141; var179 < this.mnpls[var51]; var179++) {
                        this.rd.setColor(this.color2k(200, 200, 200));
                        this.rd.drawRect(237, 54 + var179 * 42, 170, 40);
                        boolean var198 = false;
                        if (this.pgames[this.im] != this.ongame) {
                           if (this.gwarb[var51] != 0) {
                              if (!this.xt.clan.toLowerCase().equals(this.gaclan[var51].toLowerCase())
                                 && !this.xt.clan.toLowerCase().equals(this.gvclan[var51].toLowerCase())) {
                                 var198 = true;
                              }
                           } else if (!this.gplyrs[var51].equals("") && this.gplyrs[var51].indexOf(this.pnames[this.im]) == -1) {
                              var198 = true;
                           }
                        } else if (!this.gplyrs[var51].equals("")) {
                           var198 = true;
                        }

                        if (var1 > 237 && var1 < 407 && var2 > 54 + var179 * 42 && var2 < 94 + var179 * 42 && !var198) {
                           if (this.pgames[this.im] != this.ongame) {
                              this.stringbutton("    Join Game    ", 322, 79 + var179 * 42, 0);
                           } else {
                              this.stringbutton("<     Invite Player      ", 322, 79 + var179 * 42, 0);
                           }

                           this.pbtn = 1;
                        } else if (!this.invos[var154].equals("")) {
                           if (this.dinvi[var154].equals(this.invos[var154])) {
                              this.rd.setColor(new Color(0, 0, 0));
                              this.rd.setFont(new Font("Arial", 0, 12));
                              this.ftm = this.rd.getFontMetrics();
                              this.rd.drawString("Player Invited!", 322 - this.ftm.stringWidth("Player Invited!") / 2, 71 + var179 * 42);
                              this.rd.setFont(new Font("Arial", 1, 12));
                              this.ftm = this.rd.getFontMetrics();
                              this.rd.drawString(this.invos[var154], 322 - this.ftm.stringWidth(this.invos[var154]) / 2, 87 + var179 * 42);
                           } else if (this.nflk != 0) {
                              this.rd.setColor(new Color(0, 0, 0));
                              this.rd.setFont(new Font("Arial", 0, 12));
                              this.ftm = this.rd.getFontMetrics();
                              this.rd.drawString("Inviting player...", 322 - this.ftm.stringWidth("Inviting player...") / 2, 79 + var179 * 42);
                           }
                        } else {
                           this.rd.setColor(new Color(0, 0, 0));
                           this.rd.setFont(new Font("Arial", 1, 12));
                           this.ftm = this.rd.getFontMetrics();
                           this.rd.drawString("Empty", 322 - this.ftm.stringWidth("Empty") / 2, 72 + var179 * 42);
                           this.rd.setFont(new Font("Arial", 0, 10));
                           this.ftm = this.rd.getFontMetrics();
                           this.rd.drawString("Waiting for player...", 322 - this.ftm.stringWidth("Waiting for player...") / 2, 84 + var179 * 42);
                        }

                        var154++;
                     }
                  }

                  if (this.xt.lan && this.mnbts[var51] != 0) {
                     this.rd.setColor(new Color(0, 0, 0));
                     this.rd.setFont(new Font("Arial", 1, 12));
                     this.ftm = this.rd.getFontMetrics();
                     this.rd
                        .drawString(
                           "Plus " + this.mnbts[var51] + " MadBots!",
                           322 - this.ftm.stringWidth("Plus " + this.mnbts[var51] + " MadBots!") / 2,
                           73 + this.mnpls[var51] * 42
                        );
                  }

                  if (this.dispcar != -1 && this.conon == 1) {
                     if (this.gs.cmsg.isShowing()) {
                        this.gs.cmsg.hide();
                     }

                     if (this.pcars[this.dispcar] == this.forcar && this.forcar != -1) {
                        this.rd.drawImage(this.xt.crd, 517, 81, null);
                        this.rd.setColor(new Color(16, 198, 255));
                        this.rd.drawRect(415, 96, 293, 315);
                        this.rd.setColor(this.color2k(240, 240, 240));
                        this.rd.fillRect(416, 97, 4, 314);
                        this.rd.fillRect(704, 97, 4, 314);
                        this.rd.fillRect(416, 97, 292, 4);
                        this.rd.fillRect(416, 407, 292, 4);
                        if (this.flks < 0) {
                           this.rd.setColor(new Color(224, 226, 176));
                           this.flks--;
                           if (this.flks < -4) {
                              this.flks = 0;
                           }
                        } else {
                           this.rd.setColor(new Color(239, 234, 177));
                           this.flks++;
                           if (this.flks > 3) {
                              this.flks = -1;
                           }
                        }

                        this.rd.fillRect(445, 120, 233, 127);
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.setFont(new Font("Arial", 1, 13));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString(this.cd.names[this.forcar], 561 - this.ftm.stringWidth(this.cd.names[this.forcar]) / 2, 117);

                        for (int var163 = 0; var163 < this.dispco.npl; var163++) {
                           if (var7[this.forcar].p[var163].colnum == 1) {
                              this.dispco.p[var163].hsb[0] = this.pcols[this.dispcar][0];
                              this.dispco.p[var163].hsb[1] = this.pcols[this.dispcar][1];
                              this.dispco.p[var163].hsb[2] = 1.0F - this.pcols[this.dispcar][2];
                           }

                           if (var7[this.forcar].p[var163].colnum == 2) {
                              this.dispco.p[var163].hsb[0] = this.pcols[this.dispcar][3];
                              this.dispco.p[var163].hsb[1] = this.pcols[this.dispcar][4];
                              this.dispco.p[var163].hsb[2] = 1.0F - this.pcols[this.dispcar][5];
                           }
                        }

                        this.m.cx = 561;
                        this.dispco.z = 1200;
                        this.dispco.y = 605 - this.dispco.grat;
                        this.dispco.x = 225;
                        this.dispco.zy = 0;
                        this.dispco.xz = this.mrot;
                        this.mrot -= 5;
                        if (this.mrot < -360) {
                           this.mrot += 360;
                        }

                        this.dispco.xy = 0;
                        this.dispco.wzy -= 10;
                        if (this.dispco.wzy < -45) {
                           this.dispco.wzy += 45;
                        }

                        this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
                        this.dispco.d(this.rd);
                        this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                        this.m.cx = 400;
                        this.rd.setFont(new Font("Arial", 1, 11));
                        short var164 = 424;
                        byte var187 = -55;
                        this.rd.setColor(new Color(0, 63, 128));
                        this.rd.drawString("Top Speed:", 30 + var164, 318 + var187);
                        this.rd.drawImage(this.xt.statb, 97 + var164, 312 + var187, null);
                        this.rd.drawString("Acceleration:", 20 + var164, 333 + var187);
                        this.rd.drawImage(this.xt.statb, 97 + var164, 327 + var187, null);
                        this.rd.setColor(this.color2k(255, 255, 255));
                        float var206 = (this.cd.swits[this.forcar][2] - 220) / 90.0F;
                        if (var206 < 0.2) {
                           var206 = 0.2F;
                        }

                        this.rd.fillRect((int)(97.0F + 156.0F * var206) + var164, 312 + var187, (int)(156.0F * (1.0F - var206) + 1.0F), 7);
                        var206 = this.cd.acelf[this.forcar][1]
                           * this.cd.acelf[this.forcar][0]
                           * this.cd.acelf[this.forcar][2]
                           * this.cd.grip[this.forcar]
                           / 7700.0F;
                        if (var206 > 1.0F) {
                           var206 = 1.0F;
                        }

                        this.rd.fillRect((int)(97.0F + 156.0F * var206) + var164, 327 + var187, (int)(156.0F * (1.0F - var206) + 1.0F), 7);
                        this.rd.drawImage(this.xt.statbo, 97 + var164, 312 + var187, null);
                        this.rd.drawImage(this.xt.statbo, 97 + var164, 327 + var187, null);
                        byte var165 = 50;
                        var187 = -25;
                        this.rd.setColor(new Color(0, 63, 128));
                        this.rd.drawString("Stunts:", 427 + var165, 318 + var187);
                        this.rd.drawImage(this.xt.statb, 471 + var165, 312 + var187, null);
                        this.rd.drawString("Strength:", 415 + var165, 333 + var187);
                        this.rd.drawImage(this.xt.statb, 471 + var165, 327 + var187, null);
                        this.rd.drawString("Endurance:", 405 + var165, 348 + var187);
                        this.rd.drawImage(this.xt.statb, 471 + var165, 342 + var187, null);
                        this.rd.setColor(this.color2k(255, 255, 255));
                        var206 = (this.cd.airc[this.forcar] * this.cd.airs[this.forcar] * this.cd.bounce[this.forcar] + 28.0F) / 139.0F;
                        if (var206 > 1.0F) {
                           var206 = 1.0F;
                        }

                        this.rd.fillRect((int)(471.0F + 156.0F * var206) + var165, 312 + var187, (int)(156.0F * (1.0F - var206) + 1.0F), 7);
                        float var220 = 0.5F;
                        var206 = (this.cd.moment[this.forcar] + var220) / 2.6F;
                        if (var206 > 1.0F) {
                           var206 = 1.0F;
                        }

                        this.rd.fillRect((int)(471.0F + 156.0F * var206) + var165, 327 + var187, (int)(156.0F * (1.0F - var206) + 1.0F), 7);
                        var206 = this.cd.outdam[this.forcar];
                        this.rd.fillRect((int)(471.0F + 156.0F * var206) + var165, 342 + var187, (int)(156.0F * (1.0F - var206) + 1.0F), 7);
                        this.rd.drawImage(this.xt.statbo, 471 + var165, 312 + var187, null);
                        this.rd.drawImage(this.xt.statbo, 471 + var165, 327 + var187, null);
                        this.rd.drawImage(this.xt.statbo, 471 + var165, 342 + var187, null);
                        this.rd.setColor(new Color(0, 0, 0));
                        if (this.forcar >= 16) {
                           this.rd.setFont(new Font("Arial", 1, 12));
                           this.ftm = this.rd.getFontMetrics();
                           if (this.cd.createdby[this.forcar - 16].equals(this.xt.nickname)) {
                              this.rd.drawString("Created by You", 561 - this.ftm.stringWidth("Created by You") / 2, 347);
                           } else {
                              this.rd
                                 .drawString(
                                    "Created by :  " + this.cd.createdby[this.forcar - 16] + "",
                                    561 - this.ftm.stringWidth("Created by :  " + this.cd.createdby[this.forcar - 16] + "") / 2,
                                    347
                                 );
                              int var226 = this.ftm.stringWidth(this.cd.createdby[this.forcar - 16]);
                              int var233 = 561
                                 - this.ftm.stringWidth("Created by :  " + this.cd.createdby[this.forcar - 16] + "") / 2
                                 + this.ftm.stringWidth("Created by :  " + this.cd.createdby[this.forcar - 16] + "")
                                 - var226;
                              this.rd.drawLine(var233, 349, var233 + var226 - 2, 349);
                              if (var1 > var233 - 2 && var1 < var233 + var226 && var2 > 334 && var2 < 351) {
                                 if (var3) {
                                    if (!this.gb.proname.equals(this.cd.createdby[this.forcar - 16])) {
                                       this.gb.proname = this.cd.createdby[this.forcar - 16];
                                       this.gb.loadedp = false;
                                    }

                                    this.gb.tab = 1;
                                    this.gb.open = 2;
                                    this.gb.upo = true;
                                 }

                                 var8 = 12;
                              }
                           }

                           this.rd.setColor(new Color(128, 73, 0));
                           String var227 = "";
                           if (this.cd.cclass[this.forcar] == 0) {
                              var227 = "Class C ,  ";
                           }

                           if (this.cd.cclass[this.forcar] == 1) {
                              var227 = "Class B & C ,  ";
                           }

                           if (this.cd.cclass[this.forcar] == 2) {
                              var227 = "Class B ,  ";
                           }

                           if (this.cd.cclass[this.forcar] == 3) {
                              var227 = "Class A & B ,  ";
                           }

                           if (this.cd.cclass[this.forcar] == 4) {
                              var227 = "Class A ,  ";
                           }

                           if (this.cd.publish[this.forcar - 16] == 0) {
                              var227 = var227 + "Private Car";
                           }

                           if (this.cd.publish[this.forcar - 16] == 1) {
                              var227 = var227 + "Public Car";
                              this.rd.setColor(new Color(0, 64, 128));
                           }

                           if (this.cd.publish[this.forcar - 16] == 2) {
                              var227 = var227 + "Super Public Car";
                              this.rd.setColor(new Color(0, 64, 128));
                           }

                           this.rd.drawString(var227, 561 - this.ftm.stringWidth(var227) / 2, 367);
                           this.rd.setColor(new Color(0, 0, 0));
                           this.rd.setFont(new Font("Arial", 0, 12));
                           this.ftm = this.rd.getFontMetrics();
                           if (this.cd.publish[this.forcar - 16] != 1 && this.cd.publish[this.forcar - 16] != 2) {
                              this.rd
                                 .drawString(
                                    "Private Car.  Cannot be added to account.",
                                    561 - this.ftm.stringWidth("Private Car.  Cannot be added to account.") / 2,
                                    395
                                 );
                           } else {
                              if (this.cd.action == -9) {
                                 this.rd
                                    .drawString("Failed to add car!  Unknown error!", 561 - this.ftm.stringWidth("Failed to add car!  Unknown error!") / 2, 395);
                              }

                              if (this.cd.action == -8) {
                                 this.rd
                                    .drawString("Failed!  You already have 20 cars!", 561 - this.ftm.stringWidth("Failed!  You already have 20 cars!") / 2, 395);
                              }

                              if (this.cd.action == 7) {
                                 this.rd
                                    .drawString(
                                       "" + this.cd.names[this.cd.ac] + " has been added to your cars!",
                                       561 - this.ftm.stringWidth("" + this.cd.names[this.cd.ac] + " has been added to your cars!") / 2,
                                       395
                                    );
                              }

                              if (this.cd.action == -7) {
                                 this.rd.drawString("You already have this car.", 561 - this.ftm.stringWidth("You already have this car.") / 2, 395);
                              }

                              if (this.cd.action == 6) {
                                 this.rd.drawString("Adding Car...", 561 - this.ftm.stringWidth("Adding Car...") / 2, 395);
                              }

                              if (this.cd.action == -6) {
                                 String var234 = "Upgrade to a full account to add custom cars!";
                                 int var239 = 561 - this.ftm.stringWidth(var234) / 2;
                                 int var240 = var239 + this.ftm.stringWidth(var234);
                                 this.rd.drawString(var234, var239, 395);
                                 if (this.waitlink != -1) {
                                    this.rd.drawLine(var239, 396, var240, 396);
                                 }

                                 if (var1 > var239 && var1 < var240 && var2 > 384 && var2 < 397) {
                                    if (this.waitlink != -1) {
                                       var8 = 12;
                                    }

                                    if (var3 && this.waitlink == 0) {
                                       this.gs.editlink(this.xt.nickname, true);
                                       this.waitlink = -1;
                                    }
                                 }

                                 if (this.waitlink > 0) {
                                    this.waitlink--;
                                 }
                              }

                              if (this.cd.action == 0 && this.xt.drawcarb(true, null, " Add to My Cars ", 503, 375, var1, var2, var3)) {
                                 if (!this.xt.logged) {
                                    this.cd.action = -6;
                                    this.waitlink = 20;
                                 } else if (this.cd.lastload == 2 && this.forcar < 36) {
                                    this.cd.action = -7;
                                 } else {
                                    this.cd.action = 6;
                                    this.cd.ac = this.forcar;
                                    this.cd.sparkactionloader();
                                 }
                              }
                           }
                        } else {
                           this.rd.setFont(new Font("Arial", 1, 12));
                           this.ftm = this.rd.getFontMetrics();
                           this.rd.drawString("Created by Radicalplay.com", 561 - this.ftm.stringWidth("Created by Radicalplay.com") / 2, 347);
                           String var225 = "Game Car";
                           if (this.cd.cclass[this.forcar] == 0) {
                              var225 = "Class C ,  Game Car";
                           }

                           if (this.cd.cclass[this.forcar] == 1) {
                              var225 = "Class B & C ,  Game Car";
                           }

                           if (this.cd.cclass[this.forcar] == 2) {
                              var225 = "Class B ,  Game Car";
                           }

                           if (this.cd.cclass[this.forcar] == 3) {
                              var225 = "Class A & B ,  Game Car";
                           }

                           if (this.cd.cclass[this.forcar] == 4) {
                              var225 = "Class A ,  Game Car";
                           }

                           this.rd.drawString(var225, 561 - this.ftm.stringWidth(var225) / 2, 367);
                           this.rd.setColor(new Color(0, 0, 0));
                           this.rd.setFont(new Font("Arial", 0, 12));
                           this.ftm = this.rd.getFontMetrics();
                           this.rd.drawString("You already have this car.", 561 - this.ftm.stringWidth("You already have this car.") / 2, 395);
                        }

                        if (this.xt.drawcarb(true, null, "X", 682, 99, var1, var2, var3)) {
                           this.dispcar = -1;
                        }
                     } else {
                        this.dispcar = -1;
                     }
                  } else {
                     this.rd.drawImage(this.xt.sts, 537, 39, null);
                     this.rd.setColor(this.color2k(200, 200, 200));
                     this.rd.drawRect(415, 54, 293, 166);
                     if (this.conon != 1) {
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rd.getFontMetrics();
                        if (this.conon == 2) {
                           this.rd.drawString("Starting Game Now!", 561 - this.ftm.stringWidth("Starting Game Now!") / 2, 124);
                        }

                        if (this.conon == 3) {
                           this.rd.drawString("Opening Game Now!", 561 - this.ftm.stringWidth("Opening Game Now!") / 2, 124);
                        }

                        this.rd.setFont(new Font("Arial", 0, 12));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("Please Wait...", 561 - this.ftm.stringWidth("Please Wait...") / 2, 154);
                     } else if (this.wait[var51] <= 0) {
                        if (this.prevloaded != 1) {
                           this.rd.setColor(new Color(0, 0, 0));
                           this.rd.setFont(new Font("Arial", 1, 12));
                           this.ftm = this.rd.getFontMetrics();
                           if (this.prevloaded != -1) {
                              this.rd.drawString("About to Start...", 561 - this.ftm.stringWidth("About to Start...") / 2, 134);
                           } else if (this.xt.lan) {
                              if (this.pgames[this.im] != this.ongame) {
                                 this.rd.drawString("Game Started", 561 - this.ftm.stringWidth("Game Started") / 2, 117);
                                 this.stringbutton("    Watch this Game    ", 561, 154, 0);
                              } else {
                                 this.rd.drawString("About to Start...", 561 - this.ftm.stringWidth("About to Start...") / 2, 134);
                              }
                           } else {
                              this.rd.drawString("Loading Info...", 561 - this.ftm.stringWidth("Loading Info...") / 2, 134);
                           }
                        } else {
                           int var158 = (int)(80.0 + this.rerr / 1.243);
                           if (var158 > 255) {
                              var158 = 255;
                           }

                           if (var158 < 0) {
                              var158 = 0;
                           }

                           int var183 = (int)(128.0 + this.rerr / 2.428);
                           if (var183 > 255) {
                              var183 = 255;
                           }

                           if (var183 < 0) {
                              var183 = 0;
                           }

                           int var202 = this.rerr;
                           if (var202 > 255) {
                              var202 = 255;
                           }

                           if (var202 < 0) {
                              var202 = 0;
                           }

                           if (this.wait[var51] == 0) {
                              this.rd.setColor(new Color(var158, var183, var202));
                              this.rd.setFont(new Font("Arial", 1, 12));
                              this.rd.drawString("Live Info!", 621, 51);
                              this.rd.drawString("Live Info!", 451, 51);
                           }

                           this.rd.setColor(new Color(0, 0, 0));
                           this.rd.setFont(new Font("Tahoma", 1, 11));
                           this.rd.drawString("Player       Position   Laps      Power        Damage", 439, 69);
                           this.rd.setColor(this.color2k(200, 200, 200));
                           this.rd.drawLine(489, 61, 489, 162);
                           this.rd.drawLine(542, 61, 542, 162);
                           this.rd.drawLine(579, 61, 579, 162);
                           this.rd.drawLine(641, 61, 641, 162);
                           this.rd.drawLine(422, 72, 702, 72);
                           this.rd.drawLine(422, 163, 702, 163);
                           var141 = 0;

                           for (int var216 = 0; var216 < this.prnpo; var216++) {
                              for (int var222 = 0; var222 < this.prnpo; var222++) {
                                 if (this.ppos[var222] == var216) {
                                    this.rd.setFont(new Font("Tahoma", 0, 11));
                                    this.ftm = this.rd.getFontMetrics();
                                    this.rd.setColor(new Color(0, 44, 124));
                                    this.rd.drawString(this.prnames[var222], 455 - this.ftm.stringWidth(this.prnames[var222]) / 2, 83 + 11 * var141);
                                    if (this.pdam[var222] < 55 && this.pdam[var222] != -17) {
                                       this.rd.setColor(new Color(80, 128, 0));
                                       String var228 = "th";
                                       if (this.ppos[var222] == 0) {
                                          var228 = "st";
                                       }

                                       if (this.ppos[var222] == 1) {
                                          var228 = "nd";
                                       }

                                       if (this.ppos[var222] == 2) {
                                          var228 = "rd";
                                       }

                                       this.rd
                                          .drawString(
                                             "" + (this.ppos[var222] + 1) + "" + var228,
                                             515 - this.ftm.stringWidth("" + (this.ppos[var222] + 1) + "" + var228) / 2,
                                             83 + 11 * var141
                                          );
                                       this.rd.setColor(new Color(128, 73, 0));
                                       if (this.plap[var222] > this.gnlaps[var51] - 1) {
                                          this.plap[var222] = this.gnlaps[var51] - 1;
                                       }

                                       this.rd
                                          .drawString(
                                             "" + (this.plap[var222] + 1) + " / " + this.gnlaps[var51] + "",
                                             560 - this.ftm.stringWidth("" + (this.plap[var222] + 1) + " / " + this.gnlaps[var51] + "") / 2,
                                             83 + 11 * var141
                                          );
                                       this.rd.setColor(new Color(0, 128, 255));
                                       this.rd.drawRect(582, 76 + 11 * var141, 56, 6);
                                       this.rd.fillRect(583, 79 + 11 * var141, this.ppow[var222], 3);
                                       this.rd.setColor(new Color(128, 210, 255));
                                       this.rd.fillRect(583, 77 + 11 * var141, this.ppow[var222], 2);
                                       this.rd.setColor(new Color(255, 0, 0));
                                       this.rd.drawRect(645, 76 + 11 * var141, 56, 6);
                                       this.rd.fillRect(646, 79 + 11 * var141, this.pdam[var222], 3);
                                       this.rd.setColor(new Color(255, 155, 64));
                                       this.rd.fillRect(646, 77 + 11 * var141, this.pdam[var222], 2);
                                    } else {
                                       var158 = (int)(85.0 + this.rerr * 2 / 1.5);
                                       if (var158 > 255) {
                                          var158 = 255;
                                       }

                                       if (var158 < 0) {
                                          var158 = 0;
                                       }

                                       this.rd.setColor(this.color2k(var158, var158, var158));
                                       this.rd.fillRect(490, 75 + 11 * var141, 213, 9);
                                       this.rd.setFont(new Font("Tahoma", 1, 11));
                                       this.ftm = this.rd.getFontMetrics();
                                       var158 = 255 - this.rerr * 2;
                                       if (var158 > 255) {
                                          var158 = 255;
                                       }

                                       if (var158 < 0) {
                                          var158 = 0;
                                       }

                                       var183 = (int)(155.0 - this.rerr * 2 / 1.645);
                                       if (var183 > 255) {
                                          var183 = 255;
                                       }

                                       if (var183 < 0) {
                                          var183 = 0;
                                       }

                                       var202 = (int)(64.0 - this.rerr * 2 / 3.984);
                                       if (var202 > 255) {
                                          var202 = 255;
                                       }

                                       if (var202 < 0) {
                                          var202 = 0;
                                       }

                                       this.rd.setColor(new Color(var158, var183, var202));
                                       if (this.pdam[var222] == -17) {
                                          this.rd
                                             .drawString(
                                                "=   =   =   DISCONNECTED   =   =   =",
                                                597 - this.ftm.stringWidth("=   =   =   DISCONNECTED   =   =   =") / 2,
                                                84 + 11 * var141
                                             );
                                       } else {
                                          this.rd
                                             .drawString(
                                                "=   =   =   =    W A S T E D    =   =   =   =",
                                                597 - this.ftm.stringWidth("=   =   =   =    W A S T E D    =   =   =   =") / 2,
                                                84 + 11 * var141
                                             );
                                       }
                                    }

                                    var141++;
                                 }
                              }
                           }

                           if (this.wait[var51] != 0) {
                              this.rd.setColor(new Color(0, 0, 0));
                              this.rd.setFont(new Font("Arial", 1, 12));
                              this.ftm = this.rd.getFontMetrics();
                              short var217 = 186;
                              if (!this.lapsname.equals("") && !this.wastename.equals("") && !this.stuntname.equals("")) {
                                 var217 = 183;
                              }

                              if (this.gwarb[var51] != 0) {
                                 if (!var116.equals("")) {
                                    if (this.nflk != 0) {
                                       this.nflk--;
                                    } else {
                                       this.rd.setColor(new Color(255, 176, 67));
                                       this.nflk = 3;
                                    }

                                    this.rd.drawString(var116, 561 - this.ftm.stringWidth(var116) / 2, 196);
                                 } else if (!var101.equals("")) {
                                    this.rd
                                       .drawString(
                                          "Game Finished!    " + var101 + "  Wins!",
                                          561 - this.ftm.stringWidth("Game Finished!    " + var101 + "  Wins!") / 2,
                                          196
                                       );
                                    if (this.nflk != 0) {
                                       this.nflk--;
                                    } else {
                                       this.rd.setColor(new Color(255, 176, 67));
                                       this.nflk = 3;
                                    }

                                    this.rd
                                       .drawString(
                                          "" + var101 + "",
                                          561
                                             - this.ftm.stringWidth("Game Finished!    " + var101 + "  Wins!") / 2
                                             + this.ftm.stringWidth("Game Finished!    "),
                                          196
                                       );
                                 } else {
                                    this.rd.drawString("Game Finished!    Nobody Won!", 561 - this.ftm.stringWidth("Game Finished!    Nobody Won!") / 2, 186);
                                    this.rd.setFont(new Font("Arial", 1, 11));
                                    this.ftm = this.rd.getFontMetrics();
                                    this.rd.drawString(var131, 561 - this.ftm.stringWidth(var131) / 2, 206);
                                 }
                              } else {
                                 String var223 = "";

                                 for (int var229 = 0; var229 < this.prnpo; var229++) {
                                    if (this.ppos[var229] == 0) {
                                       var223 = this.prnames[var229];
                                       break;
                                    }
                                 }

                                 if (!var223.equals("")) {
                                    this.rd
                                       .drawString(
                                          "Game Finished!    Winner:  " + var223 + "",
                                          561 - this.ftm.stringWidth("Game Finished!    Winner:  " + var223 + "") / 2,
                                          var217
                                       );
                                    if (this.nflk != 0) {
                                       this.nflk--;
                                    } else {
                                       this.rd.setColor(new Color(255, 176, 67));
                                       this.nflk = 3;
                                    }

                                    this.rd
                                       .drawString(
                                          "" + var223 + "",
                                          561
                                             - this.ftm.stringWidth("Game Finished!    Winner:  " + var223 + "") / 2
                                             + this.ftm.stringWidth("Game Finished!    Winner:  "),
                                          var217
                                       );
                                 } else {
                                    this.rd
                                       .drawString("Game Finished!    Nobody Won!", 561 - this.ftm.stringWidth("Game Finished!    Nobody Won!") / 2, var217);
                                 }

                                 this.rd.setColor(new Color(0, 0, 0));
                                 this.rd.setFont(new Font("Arial", 0, 11));
                                 this.ftm = this.rd.getFontMetrics();
                                 String var230 = "    ";
                                 int var235 = 0;
                                 if (!this.lapsname.equals("")) {
                                    var230 = var230 + "Fastest lap: " + this.lapsname + "    ";
                                    var235++;
                                 }

                                 if (!this.wastename.equals("")) {
                                    var230 = var230 + "Deadliest waster: " + this.wastename + "    ";
                                    var235++;
                                 }

                                 if (var235 != 2) {
                                    if (!this.stuntname.equals("")) {
                                       var230 = var230 + "Best stunt: " + this.stuntname + "    ";
                                    }

                                    this.rd.drawString(var230, 561 - this.ftm.stringWidth(var230) / 2, 206);
                                 } else if (this.stuntname.equals("")) {
                                    this.rd.drawString(var230, 561 - this.ftm.stringWidth(var230) / 2, 206);
                                 } else {
                                    this.rd.drawString(var230, 561 - this.ftm.stringWidth(var230) / 2, 199);
                                    this.rd
                                       .drawString(
                                          "Best stunt: " + this.stuntname + "", 561 - this.ftm.stringWidth("Best stunt: " + this.stuntname + "") / 2, 213
                                       );
                                 }
                              }
                           } else {
                              this.stringbutton("    Watch Live Now!    ", 561, 196, 0);
                           }

                           this.rerr += 3;
                        }
                     } else {
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rd.getFontMetrics();
                        if (this.gwarb[var51] != 0) {
                           String var157 = "s";
                           if (this.mnpls[var51] - this.npls[var51] == 1) {
                              var157 = "";
                           }

                           this.rd
                              .drawString(
                                 "Waiting for " + (this.mnpls[var51] - this.npls[var51]) + " clan member" + var157 + " to join to start.",
                                 561
                                    - this.ftm
                                          .stringWidth("Waiting for " + (this.mnpls[var51] - this.npls[var51]) + " clan member" + var157 + " to join to start.")
                                       / 2,
                                 72
                              );
                           int var182 = this.mnpls[var51] / 2;
                           int var201 = this.mnpls[var51] / 2;

                           for (int var214 = 0; var214 < this.npo; var214++) {
                              if (this.pgames[var214] == this.gnum[var51]) {
                                 if (this.pclan[var214].toLowerCase().equals(this.gaclan[var51].toLowerCase())) {
                                    if (--var182 < 0) {
                                       var182 = 0;
                                    }
                                 }

                                 if (this.pclan[var214].toLowerCase().equals(this.gvclan[var51].toLowerCase())) {
                                    if (--var201 < 0) {
                                       var201 = 0;
                                    }
                                 }
                              }
                           }

                           this.rd.setFont(new Font("Arial", 0, 12));
                           this.ftm = this.rd.getFontMetrics();
                           this.rd
                              .drawString(
                                 "( " + var182 + " of " + this.gaclan[var51] + "  &  " + var201 + " of " + this.gvclan[var51] + " )",
                                 561
                                    - this.ftm.stringWidth("( " + var182 + " of " + this.gaclan[var51] + "  &  " + var201 + " of " + this.gvclan[var51] + " )")
                                       / 2,
                                 87
                              );
                           this.rd.drawString(this.gaclan[var51], 491 - this.ftm.stringWidth(this.gaclan[var51]) / 2, 125);
                           this.rd.drawString(this.gvclan[var51], 631 - this.ftm.stringWidth(this.gvclan[var51]) / 2, 125);
                           this.rd.setFont(new Font("Arial", 1, 12));
                           this.ftm = this.rd.getFontMetrics();
                           String var215 = "War";
                           if (this.gwarb[var51] > 1) {
                              var215 = "Battle";
                           }

                           this.rd.drawString("" + var215 + " Score", 561 - this.ftm.stringWidth("" + var215 + " Score") / 2, 107);
                           this.rd.drawString("" + this.gascore[var51] + "", 491 - this.ftm.stringWidth("" + this.gascore[var51] + "") / 2, 139);
                           this.rd.drawString("" + this.gvscore[var51] + "", 631 - this.ftm.stringWidth("" + this.gascore[var51] + "") / 2, 139);
                           this.rd.drawRect(421, 111, 280, 33);
                           this.rd.drawLine(561, 111, 561, 144);
                           this.rd.setColor(new Color(255, 128, 0));
                           this.rd.drawRect(422, 112, 138, 31);
                           this.rd.setColor(new Color(0, 128, 255));
                           this.rd.drawRect(562, 112, 138, 31);
                           if (this.pgames[this.im] == this.ongame) {
                              if (this.gmaker[var51].equals(this.pnames[this.im]) && this.npls[var51] > 1) {
                                 this.stringbutton("    Start this Game Now!    ", 561, -1000, 0);
                              }

                              this.rd.setColor(new Color(80, 128, 0));
                              this.rd.drawString("You have joined this game.", 561 - this.ftm.stringWidth("You have joined this game.") / 2, 198);
                           } else if (!this.xt.clan.toLowerCase().equals(this.gaclan[var51].toLowerCase())
                              && !this.xt.clan.toLowerCase().equals(this.gvclan[var51].toLowerCase())) {
                              this.rd.setColor(new Color(128, 73, 0));
                              this.rd
                                 .drawString(
                                    "You must be a member of either clan to join.",
                                    561 - this.ftm.stringWidth("You must be a member of either clan to join.") / 2,
                                    198
                                 );
                           } else {
                              this.stringbutton("    Join this Game    ", 561, 200, 0);
                           }

                           this.rd.setFont(new Font("Arial", 1, 12));
                           this.ftm = this.rd.getFontMetrics();
                           if (this.gwtyp[var51] == 1) {
                              this.rd.setColor(new Color(0, 0, 0));
                              this.rd.drawString("This is a normal clan game.", 561 - this.ftm.stringWidth("This is a normal clan game.") / 2, 161);
                              this.rd.setFont(new Font("Arial", 0, 12));
                              this.ftm = this.rd.getFontMetrics();
                              this.rd.setColor(new Color(0, 0, 0));
                              this.rd
                                 .drawString(
                                    "Any clan can win by racing or wasting.", 561 - this.ftm.stringWidth("Any clan can win by racing or wasting.") / 2, 176
                                 );
                           }

                           if (this.gwtyp[var51] == 2) {
                              if (this.sflk == 0) {
                                 this.sflk = 3;
                                 this.rd.setColor(new Color(117, 67, 0));
                              } else {
                                 this.sflk--;
                                 this.rd.setColor(new Color(0, 0, 0));
                              }

                              this.rd.drawString("This is a racing only game!", 561 - this.ftm.stringWidth("This is a racing only game!") / 2, 161);
                              this.rd.setFont(new Font("Arial", 0, 12));
                              this.ftm = this.rd.getFontMetrics();
                              this.rd.setColor(new Color(0, 0, 0));
                              this.rd.drawString("A clan can only win by racing.", 561 - this.ftm.stringWidth("A clan can only win by racing.") / 2, 176);
                           }

                           if (this.gwtyp[var51] == 3) {
                              if (this.sflk == 0) {
                                 this.sflk = 3;
                                 this.rd.setColor(new Color(117, 67, 0));
                              } else {
                                 this.sflk--;
                                 this.rd.setColor(new Color(0, 0, 0));
                              }

                              this.rd.drawString("This is a wasting only game!", 561 - this.ftm.stringWidth("This is a wasting only game!") / 2, 161);
                              this.rd.setFont(new Font("Arial", 0, 12));
                              this.ftm = this.rd.getFontMetrics();
                              this.rd.setColor(new Color(0, 0, 0));
                              this.rd.drawString("A clan can only win by wasting.", 561 - this.ftm.stringWidth("A clan can only win by wasting.") / 2, 176);
                           }

                           if (this.gwtyp[var51] == 4) {
                              if (this.sflk == 0) {
                                 this.sflk = 3;
                                 this.rd.setColor(new Color(117, 67, 0));
                              } else {
                                 this.sflk--;
                                 this.rd.setColor(new Color(0, 0, 0));
                              }

                              this.rd.drawString("This is Racers VS Wasters game!", 561 - this.ftm.stringWidth("This is Racers VS Wasters game!") / 2, 161);
                              this.rd
                                 .drawString(
                                    "" + this.gaclan[var51] + " wastes & " + this.gvclan[var51] + " races.",
                                    561 - this.ftm.stringWidth("" + this.gaclan[var51] + " wastes & " + this.gvclan[var51] + " races.") / 2,
                                    176
                                 );
                           }

                           if (this.gwtyp[var51] == 5) {
                              if (this.sflk == 0) {
                                 this.sflk = 3;
                                 this.rd.setColor(new Color(117, 67, 0));
                              } else {
                                 this.sflk--;
                                 this.rd.setColor(new Color(0, 0, 0));
                              }

                              this.rd.drawString("This is Racers VS Wasters game!", 561 - this.ftm.stringWidth("This is Racers VS Wasters game!") / 2, 161);
                              this.rd
                                 .drawString(
                                    "" + this.gaclan[var51] + " races & " + this.gvclan[var51] + " wastes.",
                                    561 - this.ftm.stringWidth("" + this.gaclan[var51] + " races & " + this.gvclan[var51] + " wastes.") / 2,
                                    176
                                 );
                           }
                        } else {
                           if (this.wait[var51] <= 30 && this.npls[var51] > 1) {
                              Date var156 = new Date();
                              long var181 = var156.getTime();
                              if (this.ptime == 0L || var181 > this.ptime + 1500L) {
                                 if (this.ptime != 0L) {
                                    this.wait[var51]--;
                                    if (this.wait[var51] < 1) {
                                       this.wait[var51] = 1;
                                    }
                                 }

                                 this.ptime = var181;
                              }

                              if (this.pgames[this.im] != this.ongame && this.nflk == 0) {
                                 if (this.pgames[this.im] != this.ongame) {
                                    this.nflk = 3;
                                 }
                              } else {
                                 this.rd
                                    .drawString(
                                       "Game starts in " + this.wait[var51] + " seconds!",
                                       561 - this.ftm.stringWidth("Game starts in " + this.wait[var51] + " seconds!") / 2,
                                       124
                                    );
                                 if (this.pgames[this.im] != this.ongame) {
                                    this.nflk--;
                                 }
                              }
                           } else {
                              String var155 = "s";
                              if (this.mnpls[var51] - this.npls[var51] == 1) {
                                 var155 = "";
                              }

                              this.rd
                                 .drawString(
                                    "Waiting for " + (this.mnpls[var51] - this.npls[var51]) + " more player" + var155 + " to join to start.",
                                    561
                                       - this.ftm
                                             .stringWidth(
                                                "Waiting for " + (this.mnpls[var51] - this.npls[var51]) + " more player" + var155 + " to join to start."
                                             )
                                          / 2,
                                    98
                                 );
                              this.rd.setFont(new Font("Arial", 0, 12));
                              this.ftm = this.rd.getFontMetrics();
                              short var180 = 134;
                              if (!this.gmaker[var51].equals("Coach Insano") && !this.gmaker[var51].equals(this.pnames[this.im])) {
                                 boolean var199 = false;

                                 for (int var213 = 0; var213 < this.npo; var213++) {
                                    if (this.pgames[var213] == this.ongame && this.gmaker[var51].equals(this.pnames[var213])) {
                                       var199 = true;
                                    }
                                 }

                                 if (var199) {
                                    var180 = 144;
                                    this.rd
                                       .drawString(
                                          "" + this.gmaker[var51] + " can start this game at anytime.",
                                          561 - this.ftm.stringWidth("" + this.gmaker[var51] + " can start this game at anytime.") / 2,
                                          124
                                       );
                                 }
                              }

                              if (this.npls[var51] > 1) {
                                 String var200 = "" + this.wait[var51] + " seconds";
                                 if (this.wait[var51] > 60) {
                                    var200 = "" + (int)(this.wait[var51] / 60.0F * 100.0F) / 100.0F + " minutes";
                                 }

                                 this.rd
                                    .drawString(
                                       "( Waiting " + var200 + " maximum! )", 561 - this.ftm.stringWidth("( Waiting " + var200 + " maximum! )") / 2, var180
                                    );
                              }
                           }

                           if (this.pgames[this.im] == this.ongame) {
                              if (!this.gmaker[var51].equals(this.pnames[this.im])) {
                                 this.rd.setFont(new Font("Arial", 1, 12));
                                 this.ftm = this.rd.getFontMetrics();
                                 this.rd.setColor(new Color(80, 128, 0));
                                 this.rd.drawString("You have joined this game.", 561 - this.ftm.stringWidth("You have joined this game.") / 2, 180);
                              } else if (this.npls[var51] <= 1) {
                                 this.rd.setFont(new Font("Arial", 1, 12));
                                 this.ftm = this.rd.getFontMetrics();
                                 this.rd.setColor(new Color(128, 73, 0));
                                 this.rd.drawString("You have created this game.", 561 - this.ftm.stringWidth("You have created this game.") / 2, 180);
                              } else if (this.fstart) {
                                 this.stringbutton("    Starting game now, one moment...    ", 561, 182, 0);
                              } else {
                                 this.stringbutton("    Start this Game Now!    ", 561, 182, 0);
                              }
                           } else if (!this.gplyrs[var51].equals("") && this.gplyrs[var51].indexOf(this.pnames[this.im]) == -1) {
                              this.rd.setFont(new Font("Arial", 1, 12));
                              this.ftm = this.rd.getFontMetrics();
                              this.rd.setColor(new Color(128, 73, 0));
                              this.rd
                                 .drawString(
                                    "Private Game, only specific players allowed.",
                                    561 - this.ftm.stringWidth("Private Game, only specific players allowed.") / 2,
                                    180
                                 );
                              this.stringbutton("    Join this Game    ", 561, -1000, 0);
                           } else {
                              this.stringbutton("    Join this Game    ", 561, 182, 0);
                           }
                        }
                     }

                     this.rd.setColor(this.color2k(200, 200, 200));
                     this.rd.drawRect(415, 222, 293, 40);
                     this.rd.drawImage(this.xt.stg, 422, 227, null);
                     this.rd.setColor(new Color(0, 0, 0));
                     this.rd.setFont(new Font("Arial", 1, 10));
                     this.ftm = this.rd.getFontMetrics();
                     this.rd.drawString("Laps: " + this.gnlaps[var51] + "", 660, 235);
                     if (var1 > 415 && var1 < 708 && var2 > 222 && var2 < 262 && (this.wait[var51] > 0 || this.gstgn[var51] < 0) && this.conon == 1) {
                        this.stringbutton("       Preview Stage       ", 562, 247, 0);
                        this.pbtn = 2;
                     } else {
                        if (this.gstgn[var51] <= 0) {
                           this.rd.drawString("Custom Stage", 562 - this.ftm.stringWidth("Custom Stage") / 2, 237);
                        } else {
                           String var161 = "NFM 1";
                           int var185 = this.gstgn[var51];
                           if (this.gstgn[var51] > 10) {
                              var161 = "NFM 2";
                              var185 = this.gstgn[var51] - 10;
                           }

                           if (this.gstgn[var51] > 27) {
                              var161 = "Multiplayer";
                              var185 = this.gstgn[var51] - 27;
                           }

                           this.rd
                              .drawString("" + var161 + " - Stage " + var185 + "", 562 - this.ftm.stringWidth("" + var161 + " - Stage " + var185 + "") / 2, 237);
                        }

                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString(this.gstages[var51], 562 - this.ftm.stringWidth(this.gstages[var51]) / 2, 254);
                     }

                     if (!this.xt.lan) {
                        short var162 = 237;
                        short var186 = 471;
                        if (this.wait[var51] <= 0) {
                           if (this.npls[var51] > 5) {
                              var162 = 415;
                              var186 = 293;
                           }
                        } else if (this.mnpls[var51] > 5) {
                           var162 = 415;
                           var186 = 293;
                        }

                        this.rd.setColor(this.color2k(200, 200, 200));
                        this.rd.drawRect(var162, 264, var186, 124);
                        this.rd.setColor(this.color2k(240, 240, 240));
                        this.rd.fillRect(var162 + 1, 265, var186 - 1, 21);
                        this.rd.drawImage(this.xt.gmc, var162 + 7, 269, null);
                        this.rd.setFont(new Font("Tahoma", 0, 11));
                        this.rd.setColor(this.color2k(110, 110, 110));
                        this.rd.drawString("( Game Chat )", var162 + 57, 278);
                        this.rd.setColor(new Color(0, 0, 0));
                        if (this.updatec == -1) {
                           this.rd.drawString("Loading chat...", var162 + var186 / 2 - this.ftm.stringWidth("Loading chat...") / 2, 315);
                        } else {
                           String[] var204 = new String[7];
                           String[] var218 = new String[7];
                           boolean[] var224 = new boolean[]{false, false, false, false, false, false, false};

                           for (int var231 = 0; var231 < 7; var231++) {
                              var204[var231] = "";
                              var218[var231] = this.cnames[var231];
                              int var236 = 0;
                              int var30 = 0;
                              int var31 = 0;
                              int var32 = 0;

                              for (int var33 = 0; var236 < this.sentn[var231].length(); var236++) {
                                 String var34 = "" + this.sentn[var231].charAt(var236);
                                 if (!var34.equals(" ")) {
                                    var33 = 0;
                                 } else {
                                    var30 = var31;
                                    var32 = var236;
                                    var33++;
                                 }

                                 if (var33 <= 1) {
                                    var204[var231] = var204[var231] + var34;
                                    var31++;
                                    if (this.ftm.stringWidth(var204[var231]) > var186 - 94) {
                                       if (var30 == 0) {
                                          var204[var231] = "";
                                          var31 = 0;
                                       } else {
                                          var204[var231] = var204[var231].substring(0, var30);

                                          for (int var35 = 0; var35 < var231; var35++) {
                                             var204[var35] = var204[var35 + 1];
                                             var218[var35] = var218[var35 + 1];
                                             var224[var35] = var224[var35 + 1];
                                          }

                                          var204[var231] = "";
                                          var224[var231] = true;
                                          var236 = var32;
                                          var31 = 0;
                                          var30 = 0;
                                       }
                                    }
                                 }
                              }
                           }

                           String var232 = "";
                           this.rd.setFont(new Font("Tahoma", 1, 11));
                           this.ftm = this.rd.getFontMetrics();

                           for (int var237 = 0; var237 < 7; var237++) {
                              if (!var232.equals(var218[var237])) {
                                 this.rd.drawString(var218[var237] + ":", var162 + 84 - this.ftm.stringWidth(var218[var237] + ":"), 299 + var237 * 14);
                                 var232 = var218[var237];
                              }
                           }

                           this.rd.setFont(new Font("Tahoma", 0, 11));

                           for (int var238 = 0; var238 < 7; var238++) {
                              if (var224[var238] && var238 == 0 && var204[var238].indexOf(" ") != -1) {
                                 var204[var238] = "..." + var204[var238].substring(var204[var238].indexOf(" "), var204[var238].length()) + "";
                              }

                              this.rd.drawString(var204[var238], var162 + 88, 299 + var238 * 14);
                           }
                        }

                        if (this.conon != 1) {
                           this.hideinputs();
                        } else {
                           this.pre2 = true;
                        }

                        if (var6.enter && !this.gs.cmsg.getText().equals("Type here...") && !this.gs.cmsg.getText().equals("")) {
                           this.pessd[this.btn] = true;
                           var6.enter = false;
                           String var205 = this.gs.cmsg.getText().replace('|', ':');
                           if (var205.toLowerCase().indexOf(this.gs.tpass.getText().toLowerCase()) != -1) {
                              var205 = " ";
                           }

                           if (!this.xt.msgcheck(var205) && this.updatec > -12) {
                              for (int var219 = 0; var219 < 6; var219++) {
                                 this.sentn[var219] = this.sentn[var219 + 1];
                                 this.cnames[var219] = this.cnames[var219 + 1];
                              }

                              this.sentn[6] = var205;
                              this.cnames[6] = this.pnames[this.im];
                              if (this.updatec <= -11) {
                                 this.updatec--;
                              } else {
                                 this.updatec = -11;
                              }
                           } else {
                              this.xt.warning++;
                           }

                           this.gs.cmsg.setText("");
                        }

                        this.stringbutton("Send Message", 655, 405, 3);
                     }
                  }
               } else {
                  if (this.join > -1 && this.pgames[this.im] != this.join) {
                     this.rd.setFont(new Font("Arial", 1, 13));
                     this.ftm = this.rd.getFontMetrics();
                     this.rd.drawString(this.msg, 472 - this.ftm.stringWidth(this.msg) / 2, 195);
                     if (this.msg.equals(". . . | Joining Game | . . .") && this.ncnt == 0) {
                        this.msg = "| Joining Game |";
                        this.ncnt = 5;
                     }

                     if (this.msg.equals(". . | Joining Game | . .") && this.ncnt == 0) {
                        this.msg = ". . . | Joining Game | . . .";
                        this.ncnt = 5;
                     }

                     if (this.msg.equals(". | Joining Game | .") && this.ncnt == 0) {
                        this.msg = ". . | Joining Game | . .";
                        this.ncnt = 5;
                     }

                     if (this.msg.equals("| Joining Game |") && this.ncnt == 0) {
                        this.msg = ". | Joining Game | .";
                        this.ncnt = 5;
                     }

                     if (this.ncnt != 0) {
                        this.ncnt--;
                     }
                  }

                  if (this.join == -2) {
                     this.rd.setFont(new Font("Arial", 1, 13));
                     this.ftm = this.rd.getFontMetrics();
                     this.rd.drawString(this.msg, 472 - this.ftm.stringWidth(this.msg) / 2, 195);
                     if (this.msg.equals(". . . | Leaving Game | . . .") && this.ncnt == 0) {
                        this.msg = "| Leaving Game |";
                        this.ncnt = 5;
                     }

                     if (this.msg.equals(". . | Leaving Game | . .") && this.ncnt == 0) {
                        this.msg = ". . . | Leaving Game | . . .";
                        this.ncnt = 5;
                     }

                     if (this.msg.equals(". | Leaving Game | .") && this.ncnt == 0) {
                        this.msg = ". . | Leaving Game | . .";
                        this.ncnt = 5;
                     }

                     if (this.msg.equals("| Leaving Game |") && this.ncnt == 0) {
                        this.msg = ". | Leaving Game | .";
                        this.ncnt = 5;
                     }

                     if (this.ncnt != 0) {
                        this.ncnt--;
                     }
                  }

                  if (this.gs.cmsg.isShowing()) {
                     this.gs.cmsg.hide();
                     this.gs.requestFocus();
                  }
               }
            } else {
               int var52 = 229 + this.opengame;
               if (var52 > 255) {
                  var52 = 255;
               }

               if (var52 < 0) {
                  var52 = 0;
               }

               this.rd.setColor(this.color2k(var52, var52, var52));
               this.rd.fillRoundRect(225, 59 - (int)(this.opengame * 2.23F), 495, 200 + this.opengame * 8, 20, 20);
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawRoundRect(225, 59 - (int)(this.opengame * 2.23F), 495, 200 + this.opengame * 8, 20, 20);
               if (!this.xt.lan) {
                  this.rd.setColor(this.color2k(217, 217, 217));
                  this.rd.fillRoundRect(225, 263 + this.opengame * 7, 495, 157, 20, 20);
                  this.rd.setColor(new Color(0, 0, 0));
                  this.rd.drawRoundRect(225, 263 + this.opengame * 7, 495, 157, 20, 20);
               }

               this.btn = 0;
               if (this.prevloaded != -1) {
                  this.prevloaded = -1;
               }

               if (this.updatec != -1) {
                  this.updatec = -1;
               }

               if (this.gs.cmsg.isShowing()) {
                  this.gs.cmsg.hide();
                  this.gs.requestFocus();
               }

               if (this.gs.rooms.isShowing()) {
                  this.gs.rooms.hide();
               }

               if (this.fstart) {
                  this.fstart = false;
               }

               for (int var66 = 0; var66 < 9; var66++) {
                  if (this.cac[var66] != -1) {
                     this.cac[var66] = -1;
                  }
               }

               if (this.dispcar != -1) {
                  this.dispcar = -1;
               }

               this.opengame += 2;
            }
         } else if (this.opengame < 2) {
            if (this.xt.lan) {
               this.rd.drawImage(this.xt.lanm, 241, 31, null);
               if (this.npo > 1) {
                  if (this.lanlogged) {
                     this.rd.setColor(this.color2k(90, 90, 90));
                     this.rd.setFont(new Font("Arial", 1, 12));
                     this.ftm = this.rd.getFontMetrics();
                     this.rd.drawString("[  " + var12 + " Players Connected  ]", 472 - this.ftm.stringWidth("[  " + var12 + " Players Connected  ]") / 2, 295);
                     this.drawSbutton(this.xt.cgame, 472, 325);
                  } else {
                     this.rd.setColor(new Color(0, 0, 0));
                     this.rd.setFont(new Font("Arial", 1, 13));
                     this.ftm = this.rd.getFontMetrics();
                     this.rd
                        .drawString(
                           "You have played the allowed 3 LAN games per day!",
                           472 - this.ftm.stringWidth("You have played the allowed 3 LAN games per day!") / 2,
                           295
                        );
                     this.rd.setColor(this.color2k(70, 70, 70));
                     this.rd.drawString("There needs to be at least one of the LAN players in the lobby with a registered", 225, 325);
                     this.rd.drawString("account to be able to play LAN unlimitedly...", 225, 345);
                     this.rd.drawString("Just one registered user allows everyone in the LAN game to play unlimitedly!", 225, 365);
                     this.rd.drawString("Please register now!", 225, 385);
                     this.drawSbutton(this.xt.register, 472, 395);
                  }
               } else {
                  this.drawSbutton(this.xt.cgame, 292, -1000);
                  this.rd.setColor(new Color(0, 0, 0));
                  if (this.ncnt == 0) {
                     this.rd.setColor(new Color(188, 111, 0));
                  }

                  this.rd.setFont(new Font("Arial", 1, 13));
                  this.ftm = this.rd.getFontMetrics();
                  this.rd.drawString(this.lmsg, 472 - this.ftm.stringWidth(this.lmsg) / 2, 295);
                  if (this.lmsg.equals(". . . | Searching/Waiting for other LAN Players | . . .") && this.ncnt == 0) {
                     this.lmsg = "| Searching/Waiting for other LAN Players |";
                     this.ncnt = 5;
                  }

                  if (this.lmsg.equals(". . | Searching/Waiting for other LAN Players | . .") && this.ncnt == 0) {
                     this.lmsg = ". . . | Searching/Waiting for other LAN Players | . . .";
                     this.ncnt = 5;
                  }

                  if (this.lmsg.equals(". | Searching/Waiting for other LAN Players | .") && this.ncnt == 0) {
                     this.lmsg = ". . | Searching/Waiting for other LAN Players | . .";
                     this.ncnt = 5;
                  }

                  if (this.lmsg.equals("| Searching/Waiting for other LAN Players |") && this.ncnt == 0) {
                     this.lmsg = ". | Searching/Waiting for other LAN Players | .";
                     this.ncnt = 5;
                  }

                  if (this.ncnt != 0) {
                     this.ncnt--;
                  }

                  this.rd.setColor(this.color2k(70, 70, 70));
                  this.rd.drawString("So far, you are the only player connected to this network!", 225, 325);
                  this.rd.drawString("There needs to be at least one more player logged in here with your same", 225, 345);
                  this.rd.drawString("internet connection...", 225, 365);
               }

               this.drawSbutton(this.xt.ccar, 442, -1000);
            } else {
               this.drawSbutton(this.xt.cgame, 292, 42);
               this.drawSbutton(this.xt.ccar, 442, 42);
               this.rd.setFont(new Font("Arial", 1, 13));
               this.ftm = this.rd.getFontMetrics();
               this.rd.setColor(this.color2k(60, 60, 60));
               if (!this.gs.rooms.isShowing()) {
                  this.gs.rooms.show();
               }

               this.gs.rooms.move(580 - this.gs.rooms.w / 2, 29);
               if (this.gs.rooms.sel != 0) {
                  this.stopallnow();
                  int var53 = this.gs.rooms.iroom[this.gs.rooms.sel];
                  if (var53 >= 1000) {
                     var53 -= 1000;
                     if (var53 >= 0 && var53 < this.lg.nservers) {
                        this.xt.servport = 7071;
                        this.xt.server = this.lg.servers[var53];
                        this.xt.servername = this.lg.snames[var53];
                     }
                  } else if (var53 >= 1 && var53 <= 5) {
                     this.xt.servport = 7070 + var53;
                  }

                  this.inishlobby();
                  this.gs.rooms.kmoused = 20;
               }

               if (this.gs.rooms.kmoused != 0) {
                  var1 = -1;
                  var2 = -1;
                  var3 = false;
                  this.gs.rooms.kmoused--;
               }
            }

            this.drawSbutton(this.xt.exit, 690, 42);
            if (var6.enter && !this.gs.cmsg.getText().equals("Type here...") && !this.gs.cmsg.getText().equals("")) {
               if (this.chalngd != -1) {
                  this.pessd[5] = true;
               } else {
                  this.pessd[2] = true;
               }

               var6.enter = false;
               String var55 = this.gs.cmsg.getText().replace('|', ':');
               if (var55.toLowerCase().indexOf(this.gs.tpass.getText().toLowerCase()) != -1) {
                  var55 = " ";
               }

               if (!this.xt.msgcheck(var55) && this.updatec > -12) {
                  for (int var67 = 0; var67 < 6; var67++) {
                     this.sentn[var67] = this.sentn[var67 + 1];
                     this.cnames[var67] = this.cnames[var67 + 1];
                  }

                  this.sentn[6] = var55;
                  this.cnames[6] = this.pnames[this.im];
                  if (this.updatec <= -11) {
                     this.updatec--;
                  } else {
                     this.updatec = -11;
                  }

                  this.spos3 = 28;
               } else {
                  this.xt.warning++;
               }

               this.gs.cmsg.setText("");
            }

            if (this.chalngd != -1) {
               int var57 = 230 + this.britchl;
               if (var57 > 255) {
                  var57 = 255;
               }

               if (var57 < 0) {
                  var57 = 0;
               }

               this.rd.setColor(this.color2k(var57, var57, var57));
               this.rd.fillRoundRect(225, 59, 495, 200, 20, 20);
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawRoundRect(225, 59, 495, 200, 20, 20);
               if (this.britchl < 25) {
                  this.britchl += 5;
               }

               if (this.chalngd <= -1) {
                  if (this.chalngd != -5) {
                     this.stringbutton(" Cancel X ", 669, 85, 2);
                  }

                  if (this.chalngd == -6) {
                     this.rd.setColor(new Color(0, 0, 0));
                     this.rd.setFont(new Font("Arial", 1, 13));
                     this.rd.drawString("This room already has a game that has started.", 288, 120);
                     this.rd.drawString("Please switch to another room to create a new game.", 288, 140);
                     this.rd.drawString("Or wait for the game to finish.", 288, 160);
                     this.rd.drawString("Use the dropdown menu above to change room or server.", 288, 180);
                     int[] var70 = new int[]{580, 569, 576, 576, 584, 584, 591};
                     int[] var91 = new int[]{66, 77, 77, 102, 102, 77, 77};
                     this.rd.fillPolygon(var70, var91, 7);
                     this.stringbutton("     OK     ", 472, 215, 1);
                  }

                  if (this.chalngd == -2) {
                     boolean var71 = false;
                     boolean var92 = false;
                     if (!this.gs.wgame.isShowing()) {
                        this.gs.wgame.show();
                     }

                     this.gs.wgame.move(236, 68);
                     if (this.gs.wgame.getSelectedIndex() != 0) {
                        if (!this.inwab) {
                           this.gs.sgame.hide();
                           this.gs.mstgs.hide();
                           this.gs.slaps.hide();
                           this.gs.snfm1.hide();
                           this.gs.snfmm.hide();
                           this.gs.snfm2.hide();
                        }

                        if (this.xt.clan.equals("")) {
                           this.rd.setColor(new Color(0, 0, 0));
                           this.rd.setFont(new Font("Arial", 1, 12));
                           this.ftm = this.rd.getFontMetrics();
                           this.rd
                              .drawString(
                                 "You must join a clan first to play wars and battles!",
                                 472 - this.ftm.stringWidth("You must join a clan first to play wars and battles!") / 2,
                                 145
                              );
                           this.stringbutton("    Find a clan to join    ", 472, 185, 2);
                        } else if (this.inwab) {
                           if (!this.gs.warb.isShowing()) {
                              this.gs.warb.show();
                           }

                           this.gs.warb.move(472 - this.gs.warb.w / 2, 105);
                           if (this.gs.warb.sel != 0) {
                              if (this.gs.warb.sel == this.warbsel) {
                                 if (this.gb.loadwbgames == 7) {
                                    this.rd.setColor(new Color(0, 0, 0));
                                    this.rd.setFont(new Font("Arial", 1, 12));
                                    this.ftm = this.rd.getFontMetrics();
                                    this.rd
                                       .drawString(
                                          "Redoing last game, please wait...", 472 - this.ftm.stringWidth("Redoing last game, please wait...") / 2, 155
                                       );
                                 }

                                 if (this.gb.loadwbgames == 2) {
                                    this.rd.setColor(new Color(0, 0, 0));
                                    this.rd.setFont(new Font("Arial", 1, 12));
                                    this.ftm = this.rd.getFontMetrics();
                                    if (this.gs.wgame.getSelectedIndex() == 1) {
                                       this.rd
                                          .drawString(
                                             "[ " + this.gb.gameturndisp + " ]", 472 - this.ftm.stringWidth("[ " + this.gb.gameturndisp + " ]") / 2, 155
                                          );
                                       var92 = true;
                                       int var108 = 472 - (this.gs.vnpls.w + this.gs.vtyp.w + 10) / 2;
                                       this.gs.vnpls.move(var108, 168);
                                       var108 += this.gs.vnpls.w + 10;
                                       this.gs.vtyp.move(var108, 168);
                                       if (this.gb.lwbwinner.toLowerCase().equals(this.xt.clan.toLowerCase())) {
                                          if (this.sflk == 0) {
                                             this.sflk = 4;
                                             this.rd.setColor(new Color(117, 67, 0));
                                          } else {
                                             this.sflk--;
                                          }

                                          this.rd
                                             .drawString(
                                                "Your clan won the last game.  " + this.gb.vclan + " must create this game!",
                                                472 - this.ftm.stringWidth("Your clan won the last game.  " + this.gb.vclan + " must create this game!") / 2,
                                                211
                                             );
                                       } else if (this.gs.vnpls.sel != 0) {
                                          if (this.pgamesel != -this.gs.vnpls.sel) {
                                             this.gstagename = this.gb.wbstages[this.gb.gameturn];
                                             this.cancreate = 0;
                                             this.pgamesel = -this.gs.vnpls.sel;
                                          }

                                          if (this.cancreate == 1) {
                                             this.cancreate = 2;
                                          }

                                          if (this.cancreate == 0) {
                                             if (this.gb.wbstage[this.gb.gameturn] != 101) {
                                                this.loadstage = this.gb.wbstage[this.gb.gameturn];
                                                this.cancreate = 1;
                                             } else {
                                                this.cancreate = 2;
                                             }
                                          }

                                          if (this.cancreate == 1) {
                                             this.rd.drawString("Loading...", 472 - this.ftm.stringWidth("Loading...") / 2, 235);
                                          }

                                          if (this.cancreate == 2) {
                                             this.stringbutton("   Create Game   ", 472, 235, 1);
                                          }
                                       }

                                       if (this.gb.canredo) {
                                          this.stringbutton(" Redo last game  < ", 644, 242, 1);
                                       }
                                    }

                                    if (this.gs.wgame.getSelectedIndex() == 2) {
                                       var71 = true;
                                       this.gs.pgame.move(472 - this.gs.pgame.w / 2, 150);
                                       if (this.gs.pgame.sel != 0) {
                                          if (this.pgamesel != this.gs.pgame.sel) {
                                             this.gstagename = this.gb.wbstages[this.gs.pgame.sel - 1];
                                             this.cancreate = 0;
                                             this.pgamesel = this.gs.pgame.sel;
                                          }

                                          if (this.cancreate == 1) {
                                             this.cancreate = 2;
                                          }

                                          if (this.cancreate == 0) {
                                             if (this.gb.wbstage[this.gs.pgame.sel - 1] != 101) {
                                                this.loadstage = this.gb.wbstage[this.gs.pgame.sel - 1];
                                                this.cancreate = 1;
                                             } else {
                                                this.cancreate = 2;
                                             }
                                          }

                                          if (this.cancreate == 1) {
                                             this.rd.drawString("Loading...", 472 - this.ftm.stringWidth("Loading...") / 2, 235);
                                          }

                                          if (this.cancreate == 2) {
                                             this.stringbutton("   Create Practice Game   ", 472, 235, 1);
                                          }
                                       }
                                    }
                                 }

                                 if (this.gb.loadwbgames == 3) {
                                    this.rd
                                       .drawString(
                                          "Failed to load scheduled games, please try again later...",
                                          472 - this.ftm.stringWidth("Failed to load scheduled games, please try again later...") / 2,
                                          165
                                       );
                                 }

                                 if (this.gb.loadwbgames == 4) {
                                    this.rd
                                       .drawString(
                                          "This war or battle was not found, it may have been expired.",
                                          472 - this.ftm.stringWidth("This war or battle was not found, it may have been expired.") / 2,
                                          165
                                       );
                                 }

                                 if (this.gb.loadwbgames == 6) {
                                    this.rd
                                       .drawString(
                                          "Failed to undo the last game, please try again later...",
                                          472 - this.ftm.stringWidth("Failed to undo the last game, please try again later...") / 2,
                                          165
                                       );
                                 }
                              } else {
                                 this.gb.loadwbgames = 1;
                                 this.rd.setColor(new Color(0, 0, 0));
                                 this.rd.setFont(new Font("Arial", 1, 12));
                                 this.ftm = this.rd.getFontMetrics();
                                 this.rd
                                    .drawString(
                                       "Loading scheduled games, please wait...",
                                       472 - this.ftm.stringWidth("Loading scheduled games, please wait...") / 2,
                                       165
                                    );
                                 this.warbsel = this.gs.warb.sel;
                                 this.gs.vnpls.sel = 0;
                                 this.gs.vtyp.sel = 0;
                                 this.pgamesel = 0;
                                 this.cancreate = 0;
                              }
                           }
                        } else {
                           this.rd.setColor(new Color(0, 0, 0));
                           this.rd.setFont(new Font("Arial", 1, 12));
                           this.ftm = this.rd.getFontMetrics();
                           this.rd
                              .drawString(
                                 "Loading your clan's wars and battles, please wait...",
                                 472 - this.ftm.stringWidth("Loading your clan's wars and battles, please wait...") / 2,
                                 155
                              );
                           this.loadwarb = true;
                           this.warbsel = 0;
                           this.cancreate = 0;
                        }

                        if (!this.inwab) {
                           this.inwab = true;
                        }
                     } else {
                        if (this.inwab) {
                           this.inwab = false;
                           this.gs.warb.hide();
                           this.loadstage = 0;
                        }

                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.setFont(new Font("Arial", 1, 13));
                        this.ftm = this.rd.getFontMetrics();
                        if (this.sflk % 4 != 0 || this.sflk == 0) {
                           this.rd.drawString("Select Stage", 472 - this.ftm.stringWidth("Select Stage") / 2, 85);
                        }

                        if (this.sflk != 0) {
                           this.sflk--;
                        }

                        int var106 = 0;
                        this.gs.sgame.setSize(139, 22);
                        if (this.gs.sgame.getSelectedIndex() == 0) {
                           var106 = 472 - (this.gs.sgame.getWidth() + 6 + this.gs.snfmm.getWidth()) / 2;
                           this.sgflag = 0;
                        }

                        if (this.gs.sgame.getSelectedIndex() == 1) {
                           var106 = 472 - (this.gs.sgame.getWidth() + 6 + this.gs.snfm1.getWidth()) / 2;
                           this.sgflag = 1;
                        }

                        if (this.gs.sgame.getSelectedIndex() == 2) {
                           var106 = 472 - (this.gs.sgame.getWidth() + 6 + this.gs.snfm2.getWidth()) / 2;
                           this.sgflag = 2;
                        }

                        if (this.gs.sgame.getSelectedIndex() == 3) {
                           this.gs.mstgs.setSize(338, 22);
                           if (this.sgflag != 3) {
                              this.gstage = 0;
                              if (!this.xt.logged) {
                                 this.gs.mstgs.removeAll();
                                 this.gs.mstgs.add(this.rd, "You need to have a full account to access this.");
                                 this.gs.mstgs.select(0);
                                 this.cd.msloaded = 0;
                              } else if (this.cd.msloaded != 1) {
                                 this.gs.mstgs.removeAll();
                                 this.gs.mstgs.add(this.rd, "Loading your stages now, please wait...");
                                 this.gs.mstgs.select(0);
                                 this.msload = 1;
                              }

                              this.sgflag = 3;
                           }

                           var106 = 472 - (this.gs.sgame.getWidth() + 6 + this.gs.mstgs.getWidth()) / 2;
                        }

                        if (this.gs.sgame.getSelectedIndex() == 4) {
                           this.gs.mstgs.setSize(338, 22);
                           if (this.sgflag != 4) {
                              this.gstage = 0;
                              if (!this.xt.logged) {
                                 this.gs.mstgs.removeAll();
                                 this.gs.mstgs.add(this.rd, "You need to have a full account to access this.");
                                 this.gs.mstgs.select(0);
                                 this.cd.msloaded = 0;
                              } else if (this.cd.msloaded != 7) {
                                 this.gs.mstgs.removeAll();
                                 this.gs.mstgs.add(this.rd, "Loading your stages now, please wait...");
                                 this.gs.mstgs.select(0);
                                 this.msload = 7;
                              }

                              this.sgflag = 4;
                           }

                           var106 = 472 - (this.gs.sgame.getWidth() + 6 + this.gs.mstgs.getWidth()) / 2;
                        }

                        if (this.gs.sgame.getSelectedIndex() == 5) {
                           this.gs.mstgs.setSize(338, 22);
                           if (this.sgflag != 5) {
                              this.gstage = 0;
                              if (!this.xt.logged) {
                                 this.gs.mstgs.removeAll();
                                 this.gs.mstgs.add(this.rd, "You need to have a full account to access this.");
                                 this.gs.mstgs.select(0);
                                 this.cd.msloaded = 0;
                              } else if (this.cd.msloaded != 3) {
                                 this.gs.mstgs.removeAll();
                                 this.gs.mstgs.add(this.rd, "Loading your stages now, please wait...");
                                 this.gs.mstgs.select(0);
                                 this.msload = 3;
                              }

                              this.sgflag = 5;
                           }

                           var106 = 472 - (this.gs.sgame.getWidth() + 6 + this.gs.mstgs.getWidth()) / 2;
                        }

                        if (this.gs.sgame.getSelectedIndex() == 6) {
                           this.gs.mstgs.setSize(338, 22);
                           if (this.sgflag != 6) {
                              this.gstage = 0;
                              if (!this.xt.logged) {
                                 this.gs.mstgs.removeAll();
                                 this.gs.mstgs.add(this.rd, "You need to have a full account to access this.");
                                 this.gs.mstgs.select(0);
                                 this.cd.msloaded = 0;
                              } else if (this.cd.msloaded != 4) {
                                 this.gs.mstgs.removeAll();
                                 this.gs.mstgs.add(this.rd, "Loading your stages now, please wait...");
                                 this.gs.mstgs.select(0);
                                 this.msload = 4;
                              }

                              this.sgflag = 6;
                           }

                           var106 = 472 - (this.gs.sgame.getWidth() + 6 + this.gs.mstgs.getWidth()) / 2;
                        }

                        if (!this.gs.sgame.isShowing()) {
                           this.gs.sgame.show();
                           this.remstage = 0;
                           if (this.loadstage == 0) {
                              int var123 = (int)(Math.random() * 3.0);
                              if (var123 == 3) {
                                 var123 = 2;
                              }

                              this.gs.sgame.select(var123);
                           }
                        }

                        this.gs.sgame.move(var106, 105);
                        var106 += this.gs.sgame.getWidth() + 6;
                        if (this.gs.sgame.getSelectedIndex() == 0) {
                           if (!this.gs.snfmm.isShowing()) {
                              this.gs.snfmm.show();
                              if (this.loadstage == 0) {
                                 this.gs.snfmm.select(0);
                              }
                           }

                           this.gs.snfmm.move(var106, 105);
                           if (this.gs.snfm1.isShowing()) {
                              this.gs.snfm1.hide();
                           }

                           if (this.gs.snfm2.isShowing()) {
                              this.gs.snfm2.hide();
                           }

                           if (this.gs.mstgs.isShowing()) {
                              this.gs.mstgs.hide();
                           }
                        }

                        if (this.gs.sgame.getSelectedIndex() == 0
                           && this.gs.snfmm.getSelectedIndex() != 0
                           && this.gstage != this.gs.snfmm.getSelectedIndex() + 27) {
                           this.loadstage = this.gs.snfmm.getSelectedIndex() + 27;
                           this.gstage = this.loadstage;
                           this.gs.requestFocus();
                        }

                        if (this.gs.sgame.getSelectedIndex() == 1) {
                           if (!this.gs.snfm2.isShowing()) {
                              this.gs.snfm2.show();
                              if (this.loadstage == 0) {
                                 this.gs.snfm2.select(0);
                              }
                           }

                           this.gs.snfm2.move(var106, 105);
                           if (this.gs.snfmm.isShowing()) {
                              this.gs.snfmm.hide();
                           }

                           if (this.gs.snfm1.isShowing()) {
                              this.gs.snfm1.hide();
                           }

                           if (this.gs.mstgs.isShowing()) {
                              this.gs.mstgs.hide();
                           }
                        }

                        if (this.gs.sgame.getSelectedIndex() == 1
                           && this.gs.snfm2.getSelectedIndex() != 0
                           && this.gstage != this.gs.snfm2.getSelectedIndex() + 10) {
                           this.loadstage = this.gs.snfm2.getSelectedIndex() + 10;
                           this.gstage = this.loadstage;
                           this.gs.requestFocus();
                        }

                        if (this.gs.sgame.getSelectedIndex() == 2) {
                           if (!this.gs.snfm1.isShowing()) {
                              this.gs.snfm1.show();
                              if (this.loadstage == 0) {
                                 this.gs.snfm1.select(0);
                              }
                           }

                           this.gs.snfm1.move(var106, 105);
                           if (this.gs.snfmm.isShowing()) {
                              this.gs.snfmm.hide();
                           }

                           if (this.gs.snfm2.isShowing()) {
                              this.gs.snfm2.hide();
                           }

                           if (this.gs.mstgs.isShowing()) {
                              this.gs.mstgs.hide();
                           }
                        }

                        if (this.gs.sgame.getSelectedIndex() == 2 && this.gs.snfm1.getSelectedIndex() != 0 && this.gstage != this.gs.snfm1.getSelectedIndex()) {
                           this.loadstage = this.gs.snfm1.getSelectedIndex();
                           this.gstage = this.loadstage;
                           this.gs.requestFocus();
                        }

                        if (this.gs.sgame.getSelectedIndex() == 3) {
                           if (!this.gs.mstgs.isShowing()) {
                              this.gs.mstgs.show();
                              if (this.loadstage == 0) {
                                 this.gs.mstgs.select(0);
                              }
                           }

                           this.gs.mstgs.move(var106, 105);
                           if (this.gs.snfmm.isShowing()) {
                              this.gs.snfmm.hide();
                           }

                           if (this.gs.snfm1.isShowing()) {
                              this.gs.snfm1.hide();
                           }

                           if (this.gs.snfm2.isShowing()) {
                              this.gs.snfm2.hide();
                           }
                        }

                        if (this.remstage != 2) {
                           if (this.gs.sgame.getSelectedIndex() == 3 && this.gs.mstgs.getSelectedIndex() != 0) {
                              if (this.gstage != this.gs.mstgs.getSelectedIndex() + 100) {
                                 this.loadstage = this.gs.mstgs.getSelectedIndex() + 100;
                                 this.gstage = this.loadstage;
                                 this.gs.requestFocus();
                                 this.remstage = 0;
                              }

                              if (this.loadstage <= 0 && this.remstage == 0 && this.xt.drawcarb(true, null, "X", 674, 136, var1, var2, var3)) {
                                 this.remstage = 1;
                              }
                           } else if (this.remstage != 0) {
                              this.remstage = 0;
                           }
                        }

                        if (this.gs.sgame.getSelectedIndex() >= 4) {
                           if (!this.gs.mstgs.isShowing()) {
                              this.gs.mstgs.show();
                              if (this.loadstage == 0) {
                                 this.gs.mstgs.select(0);
                              }
                           }

                           this.gs.mstgs.move(var106, 105);
                           if (this.gs.snfmm.isShowing()) {
                              this.gs.snfmm.hide();
                           }

                           if (this.gs.snfm1.isShowing()) {
                              this.gs.snfm1.hide();
                           }

                           if (this.gs.snfm2.isShowing()) {
                              this.gs.snfm2.hide();
                           }
                        }

                        if (this.gs.sgame.getSelectedIndex() >= 4
                           && this.gs.mstgs.getSelectedIndex() != 0
                           && this.gstage != this.gs.mstgs.getSelectedIndex() + 100) {
                           this.loadstage = this.gs.mstgs.getSelectedIndex() + 100;
                           this.gstage = this.loadstage;
                           this.gs.requestFocus();
                        }

                        if (this.loadstage > 0 && this.remstage == 0) {
                           this.rd.setColor(new Color(0, 0, 0));
                           this.rd.setFont(new Font("Arial", 1, 12));
                           this.ftm = this.rd.getFontMetrics();
                           this.rd.drawString("Loading stage, please wait...", 472 - this.ftm.stringWidth("Loading Stage, please wait...") / 2, 165);
                        }

                        if (this.gs.sgame.getSelectedIndex() >= 3 && !this.xt.logged) {
                           this.rd.setColor(new Color(0, 0, 0));
                           this.rd.setFont(new Font("Arial", 1, 12));
                           this.ftm = this.rd.getFontMetrics();
                           this.rd
                              .drawString(
                                 "You are currently using a trial account.", 472 - this.ftm.stringWidth("You are currently using a trial account.") / 2, 155
                              );
                           this.rd
                              .drawString(
                                 "You need to upgrade your account to access and publish custom stages!",
                                 472 - this.ftm.stringWidth("You need to upgrade your account to access and publish custom stages!") / 2,
                                 175
                              );
                           this.rd.setColor(this.color2k(200, 200, 200));
                           this.rd.fillRoundRect(382, 185, 180, 50, 20, 20);
                           this.drawSbutton(this.xt.upgrade, 472, 210);
                           if (this.gs.slaps.isShowing()) {
                              this.gs.slaps.hide();
                           }
                        } else {
                           if (this.loadstage < 0 && this.remstage == 0) {
                              this.rd.setColor(new Color(0, 0, 0));
                              this.rd.setFont(new Font("Arial", 1, 12));
                              this.ftm = this.rd.getFontMetrics();
                              this.rd
                                 .drawString(
                                    "" + this.gstagename + "  -  Laps:              ",
                                    472 - this.ftm.stringWidth("" + this.gstagename + "  -  Laps:              ") / 2,
                                    155
                                 );
                              if (!this.gs.slaps.isShowing()) {
                                 this.gs.slaps.show();
                                 this.gs.slaps.select(this.gstagelaps - 1);
                              }

                              this.gs.slaps.move(472 + this.ftm.stringWidth("" + this.gstagename + "  -  Laps:              ") / 2 - 35, 138);
                              if (this.gs.slaps.getSelectedIndex() != this.gstagelaps - 1) {
                                 this.gstagelaps = this.gs.slaps.getSelectedIndex() + 1;
                                 this.gs.requestFocus();
                              }

                              this.stringbutton("    Preview Stage    ", 472, 185, 2);
                           } else if (this.gs.slaps.isShowing()) {
                              this.gs.slaps.hide();
                           }

                           if (this.remstage == 3) {
                              if (this.loadstage < 0) {
                                 this.stringbutton("    Preview Stage    ", 472, -160, 2);
                              }

                              this.rd.setColor(new Color(0, 0, 0));
                              this.rd.setFont(new Font("Arial", 1, 13));
                              this.ftm = this.rd.getFontMetrics();
                              this.xt.drawlprom(135, 75);
                              this.rd
                                 .drawString(
                                    "Failed to remove stage, server error, please try again later.",
                                    472 - this.ftm.stringWidth("Failed to remove stage, server error, please try again later.") / 2,
                                    155
                                 );
                              if (this.xt.drawcarb(true, null, " OK ", 451, 175, var1, var2, var3)) {
                                 this.remstage = 0;
                                 this.gs.mouses = 0;
                              }
                           }

                           if (this.remstage == 2) {
                              if (this.loadstage < 0) {
                                 this.stringbutton("    Preview Stage    ", 472, -160, 2);
                              }

                              this.rd.setColor(new Color(0, 0, 0));
                              this.rd.setFont(new Font("Arial", 1, 13));
                              this.ftm = this.rd.getFontMetrics();
                              this.xt.drawlprom(135, 75);
                              this.rd
                                 .drawString("Removing stage from your account...", 472 - this.ftm.stringWidth("Removing stage from your account...") / 2, 175);
                              if (this.cd.staction == 0) {
                                 this.gstage = 0;
                                 this.loadstage = 0;
                                 this.remstage = 0;
                              }

                              if (this.cd.staction == -1) {
                                 this.remstage = 3;
                                 this.gs.mouses = 0;
                              }
                           }

                           if (this.remstage == 1) {
                              if (this.loadstage < 0) {
                                 this.stringbutton("    Preview Stage    ", 472, -160, 2);
                              }

                              this.xt.drawlprom(135, 75);
                              this.rd.setColor(new Color(0, 0, 0));
                              this.rd.setFont(new Font("Arial", 1, 13));
                              this.ftm = this.rd.getFontMetrics();
                              this.rd
                                 .drawString(
                                    "Remove this stage from your account?", 472 - this.ftm.stringWidth("Remove this stage from your account?") / 2, 155
                                 );
                              if (this.xt.drawcarb(true, null, " Yes ", 426, 175, var1, var2, var3)) {
                                 this.remstage = 2;
                                 this.cd.onstage = this.gs.mstgs.getSelectedItem();
                                 this.cd.staction = 1;
                                 this.cd.sparkstageaction();
                                 this.gs.mouses = 0;
                              }

                              if (this.xt.drawcarb(true, null, " No ", 480, 175, var1, var2, var3)) {
                                 this.remstage = 0;
                                 this.gs.mouses = 0;
                              }
                           }

                           this.stringbutton("   Next >   ", 472, 235, 1);
                        }
                     }

                     if (!var71) {
                        this.gs.pgame.hide();
                     } else {
                        this.gs.pgame.show();
                     }

                     if (!var92) {
                        this.gs.vnpls.hide();
                        this.gs.vtyp.hide();
                     } else {
                        this.gs.vnpls.show();
                        this.gs.vtyp.show();
                     }
                  }

                  if (this.chalngd == -3) {
                     this.rd.setColor(new Color(0, 0, 0));
                     this.rd.setFont(new Font("Arial", 1, 13));
                     this.ftm = this.rd.getFontMetrics();
                     if (this.sflk % 4 != 0 || this.sflk == 0) {
                        this.rd.drawString("Select Number of Players", 472 - this.ftm.stringWidth("Select Number of Players") / 2, 85);
                     }

                     if (this.sflk != 0) {
                        this.sflk--;
                     }

                     byte var72 = 0;
                     if (this.xt.lan) {
                        var72 = 59;
                     }

                     this.rd.drawString("Players", 413 - var72, 122);
                     if (!this.gs.snpls.isShowing()) {
                        this.gs.snpls.show();
                        this.gs.snpls.select(this.gnpls - 1);
                     }

                     this.gs.snpls.move(467 - var72, 105);
                     boolean var93 = false;
                     if (this.gs.snpls.getSelectedIndex() != 0 && this.gs.snpls.getSelectedIndex() != this.gnpls - 1) {
                        this.gnpls = this.gs.snpls.getSelectedIndex() + 1;
                        var93 = true;
                        this.gs.swait.hide();
                     }

                     if (this.xt.lan) {
                        this.rd.drawString("Bots", 490, 122);
                        if (!this.gs.snbts.isShowing()) {
                           this.gs.snbts.show();
                           this.gs.snbts.select(0);
                           this.gnbts = 0;
                        }

                        this.gs.snbts.move(524, 105);
                        if (this.gs.snbts.getSelectedIndex() != this.gnbts || var93) {
                           this.gnbts = this.gs.snbts.getSelectedIndex();

                           while (this.gnbts + this.gnpls > 8) {
                              this.gnbts--;
                           }

                           this.gs.snbts.select(this.gnbts);
                        }
                     }

                     this.rd.drawString("Wait", 414, 162);
                     if (!this.gs.swait.isShowing()) {
                        this.gs.swait.show();
                        if (this.gwait == 0) {
                           this.gs.swait.select(1);
                        }
                     }

                     this.gs.swait.move(451, 145);
                     if ((this.gs.swait.getSelectedIndex() + 1) * 60 != this.gwait) {
                        this.gwait = (this.gs.swait.getSelectedIndex() + 1) * 60;
                     }

                     this.rd.setColor(this.color2k(90, 90, 90));
                     this.rd.setFont(new Font("Arial", 0, 11));
                     this.ftm = this.rd.getFontMetrics();
                     this.rd
                        .drawString(
                           "( Maximum time to wait for all players to `join. )",
                           472 - this.ftm.stringWidth("( Maximum time to wait for all players to join. )") / 2,
                           179
                        );
                     this.stringbutton("   < Back   ", 422, 235, 1);
                     this.stringbutton("   Next >   ", 522, 235, 1);
                  }

                  if (this.chalngd == -4) {
                     this.rd.setColor(new Color(0, 0, 0));
                     this.rd.setFont(new Font("Arial", 1, 13));
                     this.ftm = this.rd.getFontMetrics();
                     if (this.sflk % 4 != 0 || this.sflk == 0) {
                        this.rd.drawString("Game Options", 472 - this.ftm.stringWidth("Game Options") / 2, 85);
                     }

                     if (this.sflk != 0) {
                        this.sflk--;
                     }

                     int var73 = 472 - (this.gs.scars.getWidth() + this.gs.sclass.getWidth() + this.gs.sfix.getWidth() + 16) / 2;
                     if (!this.gs.scars.isShowing()) {
                        this.gs.scars.show();
                        if (this.gcars >= 0 && this.gcars <= 2) {
                           this.gs.scars.select(this.gcars);
                        } else {
                           this.gs.scars.select(0);
                        }
                     }

                     this.gs.scars.move(var73, 105);
                     var73 += this.gs.scars.getWidth() + 8;
                     if (!this.gs.sclass.isShowing()) {
                        this.gs.sclass.show();
                        if (this.gclass >= 0 && this.gclass <= 5) {
                           this.gs.sclass.select(this.gclass);
                        } else {
                           this.gs.sclass.select(0);
                        }
                     }

                     this.gs.sclass.move(var73, 105);
                     var73 += this.gs.sclass.getWidth() + 8;
                     if (!this.gs.sfix.isShowing()) {
                        this.gs.sfix.show();
                        if (this.gfix >= 0 && this.gfix <= 5) {
                           this.gs.sfix.select(this.gfix);
                        } else {
                           this.gs.sfix.select(0);
                        }
                     }

                     this.gs.sfix.move(var73, 105);
                     var73 += this.gs.sfix.getWidth();
                     if (this.gs.openm) {
                        this.gs.movefield(this.gs.notp, var73 - 112, -2000, 150, 17);
                     } else {
                        this.gs.movefield(this.gs.notp, var73 - 112, 131, 150, 17);
                     }

                     if (!this.gs.notp.isShowing()) {
                        this.gs.notp.show();
                        if (this.gnotp != 0) {
                           this.gs.notp.setState(true);
                        } else {
                           this.gs.notp.setState(false);
                        }
                     }

                     if (this.xt.sc[0] >= 16) {
                        if (this.gs.mycar.getState()) {
                           this.gs.mycar.setState(false);
                        }
                     } else {
                        if (this.gs.openm) {
                           this.gs.movefield(this.gs.mycar, 410, -2000, 150, 17);
                        } else {
                           this.gs
                              .movefield(
                                 this.gs.mycar, 472 - (this.gs.scars.getWidth() + this.gs.sclass.getWidth() + this.gs.sfix.getWidth() + 16) / 2, 131, 150, 17
                              );
                        }

                        if (!this.gs.mycar.isShowing()) {
                           this.gs.mycar.show();
                           this.gs.mycar.setLabel("" + this.cd.names[this.xt.sc[0]] + " Game!");
                           if (this.gclass > -2) {
                              this.gs.mycar.setState(false);
                           } else {
                              this.gs.mycar.setState(true);
                           }
                        }
                     }

                     if (!this.gs.mycar.getState()) {
                        if (!this.gs.sclass.isEnabled()) {
                           this.gs.sclass.enable();
                        }

                        if (!this.gs.scars.isEnabled()) {
                           this.gs.scars.enable();
                        }

                        if (this.gs.sclass.getSelectedIndex() != this.gclass) {
                           this.gclass = this.gs.sclass.getSelectedIndex();
                           this.gs.mycar.hide();
                        }

                        if (this.gs.scars.getSelectedIndex() != this.gcars) {
                           this.gcars = this.gs.scars.getSelectedIndex();
                        }
                     } else {
                        if (this.gs.sclass.isEnabled()) {
                           this.gs.sclass.disable();
                        }

                        if (this.gs.scars.isEnabled()) {
                           this.gs.scars.disable();
                        }
                     }

                     if (this.gs.sfix.getSelectedIndex() != this.gfix) {
                        this.gfix = this.gs.sfix.getSelectedIndex();
                     }

                     String var94 = "Public Game, anyone can join...";
                     int var110 = 0;

                     for (int var124 = 0; var124 < 7; var124++) {
                        if (!this.invos[var124].equals("")) {
                           var110++;
                        }
                     }

                     if (var110 > 0) {
                        var94 = "Players Allowed:  ";
                        int var125 = 0;

                        for (int var134 = 0; var134 < 7; var134++) {
                           if (!this.invos[var134].equals("")) {
                              var94 = var94 + this.invos[var134];
                              if (++var125 != var110) {
                                 if (var125 != var110 - 1) {
                                    var94 = var94 + ", ";
                                 } else {
                                    var94 = var94 + " and ";
                                 }
                              }
                           }
                        }
                     }

                     this.rd.setColor(new Color(0, 0, 0));
                     if (var110 >= this.gnpls - 1) {
                        this.rd.setFont(new Font("Arial", 1, 13));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd
                           .drawString(
                              "" + var110 + " Allowed Players Selected", 472 - this.ftm.stringWidth("" + var110 + " Allowed Players Selected") / 2, 180
                           );
                        this.rd.setFont(new Font("Tahoma", 0, 11));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString(var94, 472 - this.ftm.stringWidth(var94) / 2, 203);
                     } else {
                        this.rd.setFont(new Font("Arial", 1, 13));
                        this.rd.drawString("Private Game, only specific players allowed to join?  " + var110 + "/" + (this.gnpls - 1) + "", 330, 180);
                        this.stringbutton("<   Select   ", 281, 180, 2);
                        this.rd.setFont(new Font("Tahoma", 0, 11));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString(var94, 472 - this.ftm.stringWidth(var94) / 2, 203);
                     }

                     this.stringbutton("   < Back   ", 422, 235, 1);
                     this.stringbutton("   Finish!   ", 522, 235, 1);
                  }

                  if (this.chalngd == -5) {
                     if (this.fstart) {
                        this.fstart = false;
                     }

                     this.rd.setFont(new Font("Arial", 1, 13));
                     this.ftm = this.rd.getFontMetrics();
                     this.rd.drawString(this.msg, 472 - this.ftm.stringWidth(this.msg) / 2, 145);
                     if (this.msg.equals(". . . | Creating Game | . . .") && this.ncnt == 0) {
                        this.msg = "| Creating Game |";
                        this.ncnt = 5;
                     }

                     if (this.msg.equals(". . | Creating Game | . .") && this.ncnt == 0) {
                        this.msg = ". . . | Creating Game | . . .";
                        this.ncnt = 5;
                     }

                     if (this.msg.equals(". | Creating Game | .") && this.ncnt == 0) {
                        this.msg = ". . | Creating Game | . .";
                        this.ncnt = 5;
                     }

                     if (this.msg.equals("| Creating Game |") && this.ncnt == 0) {
                        this.msg = ". | Creating Game | .";
                        this.ncnt = 5;
                     }

                     if (this.ncnt != 0) {
                        this.ncnt--;
                     }
                  }
               } else {
                  int var69 = 0;

                  for (int var89 = 0; var89 < this.ngm; var89++) {
                     if (this.chalngd == this.gnum[var89]) {
                        var69 = var89;
                     }
                  }

                  if (this.cflk % 4 != 0 || this.cflk == 0) {
                     this.rd.setColor(new Color(0, 0, 0));
                     this.rd.setFont(new Font("Arial", 1, 13));
                     this.ftm = this.rd.getFontMetrics();
                     this.rd
                        .drawString(
                           "You have been invited by " + this.chalby + " to join a game!",
                           472 - this.ftm.stringWidth("You have been invited by " + this.chalby + " to join a game!") / 2,
                           95
                        );
                     this.rd.setColor(new Color(117, 67, 0));
                     this.rd
                        .drawString(
                           this.chalby,
                           472
                              - this.ftm.stringWidth("You have been invited by " + this.chalby + " to join a game!") / 2
                              + this.ftm.stringWidth("You have been invited by "),
                           95
                        );
                  }

                  if (this.cflk != 0) {
                     this.cflk--;
                  }

                  this.rd.setColor(new Color(0, 0, 0));
                  this.rd.setFont(new Font("Arial", 1, 12));
                  this.ftm = this.rd.getFontMetrics();
                  this.rd
                     .drawString(
                        "Stage:  " + this.gstages[var69] + " ,  Laps: " + this.gnlaps[var69] + "",
                        472 - this.ftm.stringWidth("Stage:  " + this.gstages[var69] + " ,  Laps: " + this.gnlaps[var69] + "") / 2,
                        130
                     );
                  this.rd.setColor(new Color(62, 98, 0));
                  this.rd
                     .drawString(
                        this.gstages[var69],
                        472
                           - this.ftm.stringWidth("Stage:  " + this.gstages[var69] + " ,  Laps: " + this.gnlaps[var69] + "") / 2
                           + this.ftm.stringWidth("Stage:  "),
                        130
                     );
                  this.rd
                     .drawString(
                        "" + this.gnlaps[var69] + "",
                        472
                           - this.ftm.stringWidth("Stage:  " + this.gstages[var69] + " ,  Laps: " + this.gnlaps[var69] + "") / 2
                           + this.ftm.stringWidth("Stage:  " + this.gstages[var69] + " ,  Laps: "),
                        130
                     );
                  this.rd.setColor(new Color(0, 0, 0));
                  this.rd.drawString("Players:  " + this.mnpls[var69] + "", 472 - this.ftm.stringWidth("Players:  " + this.mnpls[var69] + "") / 2, 150);
                  this.rd.setColor(new Color(62, 98, 0));
                  this.rd
                     .drawString(
                        "" + this.mnpls[var69] + "",
                        472 - this.ftm.stringWidth("Players:  " + this.mnpls[var69] + "") / 2 + this.ftm.stringWidth("Players:  "),
                        150
                     );
                  Date var90 = new Date();
                  long var105 = var90.getTime();
                  if (this.ptime == 0L || var105 > this.ptime + 1000L) {
                     if (this.ptime != 0L) {
                        this.ctime--;
                     }

                     this.ptime = var105;
                  }

                  this.rd.setColor(new Color(0, 0, 0));
                  this.rd.setFont(new Font("Arial", 0, 12));
                  this.ftm = this.rd.getFontMetrics();
                  this.rd.drawString("( " + this.ctime + " )", 472 - this.ftm.stringWidth("( " + this.ctime + " )") / 2, 170);
                  if (this.ctime == 0) {
                     this.ongame = this.longame;
                     this.chalngd = -1;
                     this.longame = -1;
                  }

                  this.stringbutton("   View Game   ", 352, 215, 2);
                  this.stringbutton("   Join Game   ", 462, 215, 2);
                  this.stringbutton("   Decline X   ", 599, 215, 2);
               }
            } else {
               this.rd.setColor(this.color2k(230, 230, 230));
               this.rd.fillRoundRect(225, 59, 495, 200, 20, 20);
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawRoundRect(225, 59, 495, 200, 20, 20);
               if (this.britchl != 0) {
                  this.britchl = 0;
               }

               var43 = (this.ngm - 5) * 24;
               if (var43 < 0) {
                  var43 = 0;
               }

               var11 = (int)(this.spos2 / 82.0F * var43 - 2.0F);
               int[] var56 = new int[this.ngm];
               int[] var68 = new int[this.ngm];

               for (int var84 = 0; var84 < this.ngm; var84++) {
                  var56[var84] = 0;
               }

               for (int var85 = 0; var85 < this.ngm; var68[var56[var85]] = var85++) {
                  for (int var102 = var85 + 1; var102 < this.ngm; var102++) {
                     if (this.wait[var85] == this.wait[var102]) {
                        if (var102 >= var85) {
                           var56[var102]++;
                        } else {
                           var56[var85]++;
                        }
                     } else if (this.wait[var85] <= 0 && this.wait[var102] <= 0) {
                        if (this.wait[var85] >= this.wait[var102]) {
                           var56[var102]++;
                        } else {
                           var56[var85]++;
                        }
                     } else if ((this.wait[var85] > this.wait[var102] || this.wait[var85] <= 0) && this.wait[var102] > 0) {
                        var56[var85]++;
                     } else {
                        var56[var102]++;
                     }
                  }
               }

               if (var6.down) {
                  this.opselect++;

                  for (boolean var86 = false; 80 + 24 * this.opselect - var11 > 202 && !var86; var11 = (int)(this.spos2 / 82.0F * var43 - 2.0F)) {
                     this.spos2++;
                     if (this.spos2 > 82) {
                        this.spos2 = 82;
                        var86 = true;
                     }

                     if (this.spos2 < 0) {
                        this.spos2 = 0;
                        var86 = true;
                     }
                  }

                  var6.down = false;
               }

               if (var6.up) {
                  this.opselect--;

                  for (boolean var87 = false; 80 + 24 * this.opselect - var11 < 80 && !var87; var11 = (int)(this.spos2 / 82.0F * var43 - 2.0F)) {
                     this.spos2--;
                     if (this.spos2 > 82) {
                        this.spos2 = 82;
                        var87 = true;
                     }

                     if (this.spos2 < 0) {
                        this.spos2 = 0;
                        var87 = true;
                     }
                  }

                  var6.up = false;
               }

               int var88 = -1;
               if (this.mousonp != -1) {
                  int var103 = 0;

                  for (int var117 = 0; var117 < this.ngm; var117++) {
                     if (this.pgames[this.mousonp] == this.gnum[var117]) {
                        var103 = var117;
                     }
                  }

                  var88 = 91 + 24 * var56[var103] - var11;
                  if (80 + 24 * var56[var103] - var11 > 202) {
                     int var118 = 1000 / var43;
                     if (var118 < 1) {
                        var118 = 1;
                     }

                     this.spos2 += var118;
                     var88 = -1;
                  }

                  if (80 + 24 * var56[var103] - var11 < 80) {
                     int var119 = 1000 / var43;
                     if (var119 < 1) {
                        var119 = 1;
                     }

                     this.spos2 -= var119;
                     var88 = -1;
                  }

                  if (this.spos2 > 82) {
                     this.spos2 = 82;
                  }

                  if (this.spos2 < 0) {
                     this.spos2 = 0;
                  }

                  var11 = (int)(this.spos2 / 82.0F * var43 - 2.0F);
                  this.opselect = var56[var103];
               }

               if (this.opselect <= -1) {
                  this.opselect = 0;
               }

               if (this.opselect >= this.ngm) {
                  this.opselect = this.ngm - 1;
               }

               int var104 = 0;

               for (int var120 = 0; var120 < this.ngm; var120++) {
                  if (80 + 24 * var120 - var11 < 224 && 80 + 24 * var120 - var11 > 56) {
                     if (this.opselect == var120) {
                        if (80 + 24 * var120 - var11 >= 224) {
                           this.opselect--;
                        }

                        if (80 + 24 * var120 - var11 < 62) {
                           this.opselect++;
                        }
                     }

                     boolean var132 = false;
                     boolean var143 = false;
                     if (!this.gs.openm) {
                        if (var1 > 241 && var1 < 692 && var2 > 92 + 24 * var120 - var11 && var2 < 110 + 24 * var120 - var11) {
                           if (this.lxm != var1 || this.lym != var2) {
                              this.opselect = var120;
                           }

                           var132 = true;
                           if (!var3) {
                              if (this.clicked == var68[var120]) {
                                 this.ongame = this.gnum[var68[var120]];
                                 this.opengame = 0;
                                 if (var1 >= 641
                                    && var1 <= 689
                                    && var2 > 92 + 24 * var120 - var11
                                    && var2 < 110 + 24 * var120 - var11
                                    && this.wait[var68[var120]] > 0) {
                                    boolean var148 = false;
                                    if (this.gwarb[var68[var120]] != 0) {
                                       if (this.xt.clan.toLowerCase().equals(this.gaclan[var68[var120]].toLowerCase())
                                          || this.xt.clan.toLowerCase().equals(this.gvclan[var68[var120]].toLowerCase())) {
                                          var148 = true;
                                       }
                                    } else if (this.gplyrs[var68[var120]].equals("") || this.gplyrs[var68[var120]].indexOf(this.pnames[this.im]) != -1) {
                                       var148 = true;
                                    }

                                    if (var148) {
                                       this.join = this.gnum[var68[var120]];
                                       this.msg = "| Joining Game |";
                                       this.spos = 0;
                                    }
                                 }

                                 this.clicked = -1;
                              }

                              var104++;
                           } else if (this.clicked == -1) {
                              this.clicked = var68[var120];
                           }
                        } else {
                           var104++;
                        }

                        if (var1 >= 641 && var1 <= 689 && var2 > 92 + 24 * var120 - var11 && var2 < 110 + 24 * var120 - var11 && var3) {
                           var143 = true;
                        }
                     }

                     if (this.opselect == var120) {
                        if ((!var132 || !var3) && !var6.enter) {
                           this.rd.setColor(this.color2k(255, 255, 255));
                        } else {
                           this.rd.setColor(this.color2k(200, 200, 200));
                           if (var6.enter) {
                              this.ongame = this.gnum[var68[var120]];
                              this.opengame = 0;
                              var6.enter = false;
                           }
                        }

                        this.rd.fillRect(241, 92 + 24 * var120 - var11, 451, 18);
                        if (var132) {
                           this.rd.setColor(this.color2k(150, 150, 150));
                           this.rd.drawRect(239, 90 + 24 * var120 - var11, 454, 21);
                        }
                     }

                     this.rd.setColor(new Color(0, 0, 0));
                     this.rd.setFont(new Font("Arial", 1, 12));
                     this.ftm = this.rd.getFontMetrics();
                     this.rd.drawString(this.gstages[var68[var120]], 382 - this.ftm.stringWidth(this.gstages[var68[var120]]) / 2, 105 + 24 * var120 - var11);
                     this.rd.drawString("|", 525, 105 + 24 * var120 - var11);
                     this.rd.drawString("|", 584, 105 + 24 * var120 - var11);
                     if (this.wait[var68[var120]] <= 0) {
                        this.rd
                           .drawString(
                              "" + this.npls[var68[var120]] + "", 556 - this.ftm.stringWidth("" + this.npls[var68[var120]] + "") / 2, 105 + 24 * var120 - var11
                           );
                        this.rd.setFont(new Font("Arial", 0, 12));
                        this.ftm = this.rd.getFontMetrics();
                        if (this.wait[var68[var120]] != 0) {
                           this.rd.setColor(this.color2k(100, 100, 100));
                           this.rd.drawString("Finished", 590, 105 + 24 * var120 - var11);
                        } else {
                           this.rd.setColor(new Color(128, 73, 0));
                           this.rd.drawString("Started", 594, 105 + 24 * var120 - var11);
                        }

                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rd.getFontMetrics();
                        if (var143) {
                           this.rd.setColor(this.color2k(230, 230, 230));
                           this.rd.fillRect(641, 92 + 24 * var120 - var11, 48, 18);
                        } else {
                           this.rd.setColor(this.color2k(230, 230, 230));
                           this.rd.fill3DRect(641, 92 + 24 * var120 - var11, 48, 18, true);
                        }

                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawString("View", 665 - this.ftm.stringWidth("View") / 2, 105 + 24 * var120 - var11);
                     } else {
                        this.rd
                           .drawString(
                              "" + this.npls[var68[var120]] + " / " + this.mnpls[var68[var120]] + "",
                              556 - this.ftm.stringWidth("" + this.npls[var68[var120]] + " / " + this.mnpls[var68[var120]] + "") / 2,
                              105 + 24 * var120 - var11
                           );
                        this.rd.setFont(new Font("Arial", 0, 12));
                        this.rd.setColor(new Color(80, 128, 0));
                        this.rd.drawString("Waiting", 593, 105 + 24 * var120 - var11);
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rd.getFontMetrics();
                        if (var143) {
                           this.rd.setColor(this.color2k(230, 230, 230));
                           this.rd.fillRect(641, 92 + 24 * var120 - var11, 48, 18);
                        } else {
                           this.rd.setColor(this.color2k(230, 230, 230));
                           this.rd.fill3DRect(641, 92 + 24 * var120 - var11, 48, 18, true);
                           this.rd.fill3DRect(642, 93 + 24 * var120 - var11, 46, 16, true);
                        }

                        this.rd.setColor(new Color(0, 0, 0));
                        boolean var149 = false;
                        if (this.gwarb[var68[var120]] != 0) {
                           if (this.xt.clan.toLowerCase().equals(this.gaclan[var68[var120]].toLowerCase())
                              || this.xt.clan.toLowerCase().equals(this.gvclan[var68[var120]].toLowerCase())) {
                              var149 = true;
                           }
                        } else if (this.gplyrs[var68[var120]].equals("") || this.gplyrs[var68[var120]].indexOf(this.pnames[this.im]) != -1) {
                           var149 = true;
                        }

                        if (!var149) {
                           this.rd.drawString("View", 665 - this.ftm.stringWidth("View") / 2, 105 + 24 * var120 - var11);
                        } else {
                           this.rd.drawString("Join", 665 - this.ftm.stringWidth("Join") / 2, 105 + 24 * var120 - var11);
                        }
                     }
                  } else {
                     if (this.opselect == var120) {
                        if (80 + 24 * var120 - var11 >= 224) {
                           this.opselect--;
                        }

                        if (80 + 24 * var120 - var11 <= 56) {
                           this.opselect++;
                        }
                     }

                     var104++;
                  }
               }

               if (var104 == this.ngm && this.clicked != -1) {
                  this.clicked = -1;
               }

               this.rd.setColor(new Color(0, 0, 0));
               this.rd.setFont(new Font("Arial", 1, 12));
               this.ftm = this.rd.getFontMetrics();
               if (this.ngm == 0) {
                  if (this.lloaded) {
                     if (!this.xt.lan) {
                        this.rd.drawString("No Games Created", 472 - this.ftm.stringWidth("No Games Created") / 2, 165);
                     }
                  } else {
                     this.rd.drawString("|  Loading Games  |", 472 - this.ftm.stringWidth("|  Loading Games  |") / 2, 165);
                  }
               }

               this.rd.setColor(this.color2k(205, 205, 205));
               this.rd.fillRect(235, 65, 480, 25);
               this.rd.drawImage(this.xt.games, 241, 69, null);
               this.rd.setColor(this.color2k(70, 70, 70));
               this.rd.drawString("Stage Name", 382 - this.ftm.stringWidth("Stage Name") / 2, 81);
               this.rd.drawString("|", 525, 81);
               this.rd.drawString("Players", 556 - this.ftm.stringWidth("Players") / 2, 81);
               this.rd.drawString("|", 584, 81);
               this.rd.drawString("Status", 641 - this.ftm.stringWidth("Status") / 2, 81);
               this.rd.setColor(this.color2k(150, 150, 150));
               this.rd.drawLine(235, 87, 696, 87);
               this.rd.setColor(this.color2k(205, 205, 205));
               this.rd.fillRect(235, 237, 480, 17);
               this.rd.setColor(this.color2k(150, 150, 150));
               this.rd.drawLine(235, 239, 696, 239);
               this.rd.setColor(this.color2k(205, 205, 205));
               this.rd.fillRect(698, 107, 17, 113);
               this.rd.setColor(this.color2k(205, 205, 205));
               this.rd.fillRect(231, 65, 4, 189);
               if (this.mscro2 != 141 && var43 != 0) {
                  this.rd.setColor(this.color2k(220, 220, 220));
                  this.rd.fill3DRect(698, 90, 17, 17, true);
               } else {
                  if (var43 != 0) {
                     this.rd.setColor(this.color2k(215, 215, 215));
                  } else {
                     this.rd.setColor(this.color2k(205, 205, 205));
                  }

                  this.rd.fillRect(698, 90, 17, 17);
               }

               if (var43 != 0) {
                  this.rd.drawImage(this.xt.asu, 703, 96, null);
               }

               if (this.mscro2 != 142 && var43 != 0) {
                  this.rd.setColor(this.color2k(220, 220, 220));
                  this.rd.fill3DRect(698, 220, 17, 17, true);
               } else {
                  if (var43 != 0) {
                     this.rd.setColor(this.color2k(215, 215, 215));
                  } else {
                     this.rd.setColor(this.color2k(205, 205, 205));
                  }

                  this.rd.fillRect(698, 220, 17, 17);
               }

               if (var43 != 0) {
                  this.rd.drawImage(this.xt.asd, 703, 226, null);
               }

               if (var43 != 0) {
                  if (this.lspos2 == this.spos2) {
                     if (this.mscro2 == 141) {
                        this.rd.setColor(this.color2k(215, 215, 215));
                     }

                     this.rd.fill3DRect(698, 107 + this.spos2, 17, 31, true);
                  } else {
                     this.rd.setColor(this.color2k(215, 215, 215));
                     this.rd.fillRect(698, 107 + this.spos2, 17, 31);
                  }

                  this.rd.setColor(this.color2k(150, 150, 150));
                  this.rd.drawLine(703, 120 + this.spos2, 709, 120 + this.spos2);
                  this.rd.drawLine(703, 122 + this.spos2, 709, 122 + this.spos2);
                  this.rd.drawLine(703, 124 + this.spos2, 709, 124 + this.spos2);
                  if (this.mscro2 > 138 && this.lspos2 != this.spos2) {
                     this.lspos2 = this.spos2;
                  }

                  if (!var3) {
                     if (this.mscro2 != 145) {
                        this.mscro2 = 145;
                     }
                  } else {
                     if (this.mscro2 == 145 && var1 > 698 && var1 < 715 && var2 > 107 + this.spos2 && var2 < this.spos2 + 138) {
                        this.mscro2 = var2 - this.spos2;
                     }

                     if (this.mscro2 == 145 && var1 > 696 && var1 < 717 && var2 > 88 && var2 < 109) {
                        this.mscro2 = 141;
                     }

                     if (this.mscro2 == 145 && var1 > 696 && var1 < 717 && var2 > 218 && var2 < 239) {
                        this.mscro2 = 142;
                     }

                     if (this.mscro2 == 145 && var1 > 698 && var1 < 715 && var2 > 107 && var2 < 220) {
                        this.mscro2 = 122;
                        this.spos2 = var2 - this.mscro2;
                     }

                     int var121 = 400 / var43;
                     if (var121 < 1) {
                        var121 = 1;
                     }

                     if (this.mscro2 == 141) {
                        this.spos2 -= var121;
                        if (this.spos2 > 82) {
                           this.spos2 = 82;
                        }

                        if (this.spos2 < 0) {
                           this.spos2 = 0;
                        }

                        this.lspos2 = this.spos2;
                     }

                     if (this.mscro2 == 142) {
                        this.spos2 += var121;
                        if (this.spos2 > 82) {
                           this.spos2 = 82;
                        }

                        if (this.spos2 < 0) {
                           this.spos2 = 0;
                        }

                        this.lspos2 = this.spos2;
                     }

                     if (this.mscro2 <= 138) {
                        this.spos2 = var2 - this.mscro2;
                        if (this.spos2 > 82) {
                           this.spos2 = 82;
                        }

                        if (this.spos2 < 0) {
                           this.spos2 = 0;
                        }
                     }

                     if (this.mscro2 == 145) {
                        this.mscro2 = 225;
                     }
                  }

                  if (var4 != 0 && var1 > 235 && var1 < 698 && var2 > 87 && var2 < 239) {
                     this.spos2 -= var4;
                     this.zeromsw = true;
                     if (this.spos2 > 82) {
                        this.spos2 = 82;
                        this.zeromsw = false;
                     }

                     if (this.spos2 < 0) {
                        this.spos2 = 0;
                        this.zeromsw = false;
                     }

                     this.lspos2 = this.spos2;
                  }
               }

               if (this.mousonp != -1 && var88 != -1) {
                  this.rd.setColor(this.color2k(255, 255, 255));
                  int[] var122 = new int[]{185, 241, 241, 185};
                  int[] var133 = new int[]{var14, var88, var88 + 19, var14 + 30};
                  this.rd.fillPolygon(var122, var133, 4);
                  this.rd.setColor(this.color2k(150, 150, 150));
                  this.rd.drawLine(185, var14, 241, var88);
                  this.rd.drawLine(185, var14 + 30, 241, var88 + 19);
                  this.rd.drawLine(241, var88, 692, var88);
                  this.rd.drawLine(241, var88 + 19, 692, var88 + 19);
               }
            }

            if (!this.xt.lan) {
               this.rd.setColor(this.color2k(230, 230, 230));
               this.rd.fillRoundRect(225, 263, 495, 157, 20, 20);
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawRoundRect(225, 263, 495, 157, 20, 20);
               String[] var58 = new String[14];
               String[] var77 = new String[14];
               boolean[] var95 = new boolean[14];

               for (int var111 = 0; var111 < 14; var111++) {
                  var58[var111] = "";
                  var77[var111] = "";
                  var95[var111] = false;
               }

               int var112 = 0;
               this.rd.setFont(new Font("Tahoma", 0, 11));
               this.ftm = this.rd.getFontMetrics();
               if (this.updatec == -1) {
                  var43 = 0;
                  boolean var47 = false;
                  this.rd.drawString("Loading chat...", 465 - this.ftm.stringWidth("Loading chat...") / 2, 325);
               } else {
                  for (int var126 = 0; var126 < 7; var126++) {
                     var58[var112] = "";
                     var77[var112] = this.cnames[var126];
                     int var135 = 0;
                     int var144 = 0;
                     int var150 = 0;
                     int var166 = 0;

                     for (int var189 = 0; var135 < this.sentn[var126].length(); var135++) {
                        String var211 = "" + this.sentn[var126].charAt(var135);
                        if (!var211.equals(" ")) {
                           var189 = 0;
                        } else {
                           var144 = var150;
                           var166 = var135;
                           var189++;
                        }

                        if (var189 <= 1) {
                           var58[var112] = var58[var112] + var211;
                           var150++;
                           if (this.ftm.stringWidth(var58[var112]) > 367) {
                              if (var144 == 0) {
                                 var58[var112] = "";
                                 var150 = 0;
                              } else {
                                 var58[var112] = var58[var112].substring(0, var144);
                                 if (var112 != 13) {
                                    var77[++var112] = this.cnames[var126];
                                 } else {
                                    for (int var221 = 0; var221 < 13; var221++) {
                                       var58[var221] = var58[var221 + 1];
                                       var77[var221] = var77[var221 + 1];
                                       var95[var221] = var95[var221 + 1];
                                    }

                                    var58[var112] = "";
                                    var95[var112] = true;
                                 }

                                 var135 = var166;
                                 var150 = 0;
                                 var144 = 0;
                              }
                           }
                        }
                     }

                     if (var112 == 13 && var126 != 6) {
                        for (int var212 = 0; var212 < 13; var212++) {
                           var58[var212] = var58[var212 + 1];
                           var77[var212] = var77[var212 + 1];
                           var95[var212] = var95[var212 + 1];
                        }
                     } else {
                        var112++;
                     }
                  }

                  var43 = (var112 - 6) * 15;
                  if (var43 < 0) {
                     var43 = 0;
                  }

                  var11 = (int)(this.spos3 / 28.0F * var43);
                  String var127 = "";
                  this.rd.setFont(new Font("Tahoma", 1, 11));
                  this.ftm = this.rd.getFontMetrics();

                  for (int var136 = 0; var136 < var112; var136++) {
                     if (!var127.equals(var77[var136])) {
                        if (280 + var136 * 15 - var11 > 266 && 280 + var136 * 15 - var11 < 370) {
                           this.rd.drawString(var77[var136] + ":", 320 - this.ftm.stringWidth(var77[var136] + ":"), 305 + var136 * 15 - var11);
                        }

                        var127 = var77[var136];
                     }
                  }

                  this.rd.setFont(new Font("Tahoma", 0, 11));

                  for (int var137 = 0; var137 < var112; var137++) {
                     if (var95[var137] && var137 == 0 && var58[var137].indexOf(" ") != -1) {
                        var58[var137] = "..." + var58[var137].substring(var58[var137].indexOf(" "), var58[var137].length()) + "";
                     }

                     if (280 + var137 * 15 - var11 > 266 && 280 + var137 * 15 - var11 < 370) {
                        this.rd.drawString(var58[var137], 325, 305 + var137 * 15 - var11);
                     }
                  }
               }

               this.rd.setColor(this.color2k(205, 205, 205));
               this.rd.fillRect(235, 269, 480, 25);
               this.rd.drawImage(this.xt.chat, 241, 273, null);
               this.rd.setFont(new Font("Arial", 1, 12));
               this.rd.setColor(this.color2k(120, 120, 120));
               this.rd.drawString("( Room Chat )", 299, 285);
               this.rd.setColor(this.color2k(150, 150, 150));
               this.rd.drawLine(235, 291, 696, 291);
               this.rd.setColor(this.color2k(205, 205, 205));
               this.rd.fillRect(235, 387, 480, 28);
               this.rd.setColor(this.color2k(150, 150, 150));
               this.rd.drawLine(235, 389, 696, 389);
               this.rd.setColor(this.color2k(205, 205, 205));
               this.rd.fillRect(698, 311, 17, 59);
               this.rd.setColor(this.color2k(205, 205, 205));
               this.rd.fillRect(231, 269, 4, 146);
               if (this.mscro3 != 351 && var43 != 0) {
                  this.rd.setColor(this.color2k(220, 220, 220));
                  this.rd.fill3DRect(698, 294, 17, 17, true);
               } else {
                  if (var43 != 0) {
                     this.rd.setColor(this.color2k(215, 215, 215));
                  } else {
                     this.rd.setColor(this.color2k(205, 205, 205));
                  }

                  this.rd.fillRect(698, 294, 17, 17);
               }

               if (var43 != 0) {
                  this.rd.drawImage(this.xt.asu, 703, 300, null);
               }

               if (this.mscro3 != 352 && var43 != 0) {
                  this.rd.setColor(this.color2k(220, 220, 220));
                  this.rd.fill3DRect(698, 370, 17, 17, true);
               } else {
                  if (var43 != 0) {
                     this.rd.setColor(this.color2k(215, 215, 215));
                  } else {
                     this.rd.setColor(this.color2k(205, 205, 205));
                  }

                  this.rd.fillRect(698, 370, 17, 17);
               }

               if (var43 != 0) {
                  this.rd.drawImage(this.xt.asd, 703, 376, null);
               }

               if (var43 != 0) {
                  if (this.lspos3 == this.spos3) {
                     if (this.mscro3 == 141) {
                        this.rd.setColor(this.color2k(215, 215, 215));
                     }

                     this.rd.fill3DRect(698, 311 + this.spos3, 17, 31, true);
                  } else {
                     this.rd.setColor(this.color2k(215, 215, 215));
                     this.rd.fillRect(698, 311 + this.spos3, 17, 31);
                  }

                  this.rd.setColor(this.color2k(150, 150, 150));
                  this.rd.drawLine(703, 324 + this.spos3, 709, 324 + this.spos3);
                  this.rd.drawLine(703, 326 + this.spos3, 709, 326 + this.spos3);
                  this.rd.drawLine(703, 328 + this.spos3, 709, 328 + this.spos3);
                  if (this.mscro3 > 342 && this.lspos3 != this.spos3) {
                     this.lspos3 = this.spos3;
                  }

                  if (!var3) {
                     if (this.mscro3 != 345) {
                        this.mscro3 = 345;
                     }
                  } else {
                     if (this.mscro3 == 345 && var1 > 698 && var1 < 715 && var2 > 311 + this.spos3 && var2 < this.spos3 + 342) {
                        this.mscro3 = var2 - this.spos3;
                     }

                     if (this.mscro3 == 345 && var1 > 696 && var1 < 717 && var2 > 292 && var2 < 313) {
                        this.mscro3 = 351;
                     }

                     if (this.mscro3 == 345 && var1 > 696 && var1 < 717 && var2 > 368 && var2 < 389) {
                        this.mscro3 = 352;
                     }

                     if (this.mscro3 == 345 && var1 > 698 && var1 < 715 && var2 > 311 && var2 < 370) {
                        this.mscro3 = 326;
                        this.spos3 = var2 - this.mscro3;
                     }

                     int var128 = 100 / var43;
                     if (var128 < 1) {
                        var128 = 1;
                     }

                     if (this.mscro3 == 351) {
                        this.spos3 -= var128;
                        if (this.spos3 > 28) {
                           this.spos3 = 28;
                        }

                        if (this.spos3 < 0) {
                           this.spos3 = 0;
                        }

                        this.lspos3 = this.spos3;
                     }

                     if (this.mscro3 == 352) {
                        this.spos3 += var128;
                        if (this.spos3 > 28) {
                           this.spos3 = 28;
                        }

                        if (this.spos3 < 0) {
                           this.spos3 = 0;
                        }

                        this.lspos3 = this.spos3;
                     }

                     if (this.mscro3 <= 342) {
                        this.spos3 = var2 - this.mscro3;
                        if (this.spos3 > 28) {
                           this.spos3 = 28;
                        }

                        if (this.spos3 < 0) {
                           this.spos3 = 0;
                        }
                     }

                     if (this.mscro3 == 345) {
                        this.mscro3 = 425;
                     }
                  }

                  if (var4 != 0 && var1 > 235 && var1 < 698 && var2 > 291 && var2 < 389) {
                     this.spos3 -= var4 / 2;
                     this.zeromsw = true;
                     if (this.spos3 > 28) {
                        this.spos3 = 28;
                        this.zeromsw = false;
                     }

                     if (this.spos3 < 0) {
                        this.spos3 = 0;
                        this.zeromsw = false;
                     }

                     this.lspos3 = this.spos3;
                  }
               }

               this.pre1 = true;
               this.stringbutton("Send Message", 657, 406, 3);
            }

            if ((this.chalngd == -1 || this.chalngd == -6) && this.lg.gamec != -1) {
               if (this.lg.cntgame >= 0 && this.lg.cntgame < 10) {
                  this.rd.setComposite(AlphaComposite.getInstance(3, this.lg.cntgame / 10.0F));
               }

               if (this.lg.cntgame > 390 && this.lg.cntgame < 400) {
                  this.rd.setComposite(AlphaComposite.getInstance(3, (400 - this.lg.cntgame) / 10.0F));
               }

               this.rd.setColor(this.color2k(245, 245, 245));
               this.rd.fillRoundRect(383, 242, 337, 46, 20, 20);
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawRoundRect(383, 242, 337, 46, 20, 20);
               this.rd.setFont(new Font("Arial", 1, 12));
               this.ftm = this.rd.getFontMetrics();
               this.rd
                  .drawString(
                     "" + this.lg.gmaker + " created a game in " + this.lg.gservern + " :: Room " + this.lg.groom + "",
                     551 - this.ftm.stringWidth("" + this.lg.gmaker + " created a game in " + this.lg.gservern + " :: Room " + this.lg.groom + "") / 2,
                     260
                  );
               if (var1 > 488 && var1 < 614 && var2 > 264 && var2 < 287) {
                  if (var3) {
                     this.grprsd = true;
                  } else if (this.grprsd) {
                     for (int var59 = 0; var59 < this.lg.nservers; var59++) {
                        if (this.lg.gservern.equals(this.lg.snames[var59])) {
                           this.stopallnow();
                           this.xt.server = this.lg.servers[var59];
                           this.xt.servername = this.lg.snames[var59];
                           this.xt.servport = 7070 + this.lg.groom;
                           this.inishlobby();
                           break;
                        }
                     }

                     this.grprsd = false;
                  }
               } else if (this.grprsd) {
                  this.grprsd = false;
               }

               if (this.grprsd) {
                  this.rd.setColor(this.color2k(230, 230, 230));
                  this.rd.fillRect(490, 266, 122, 19);
                  this.rd.setColor(this.color2k(60, 60, 60));
               } else {
                  this.rd.setColor(this.color2k(230, 230, 230));
                  this.rd.fill3DRect(490, 266, 122, 19, true);
                  this.rd.setColor(new Color(0, 0, 0));
               }

               this.rd.drawString("View / Join Game", 551 - this.ftm.stringWidth("View / Join Game") / 2, 280);
               if (this.lg.cntgame >= 0 && this.lg.cntgame < 10 || this.lg.cntgame > 390 && this.lg.cntgame < 400) {
                  this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
               }

               this.lg.cntgame++;
               if (this.lg.cntgame == 400) {
                  this.lg.gamec = -1;
               }
            }
         } else {
            if (this.opengame >= 27) {
               this.opengame = 26;
            }

            int var60 = 229 + this.opengame;
            if (var60 > 255) {
               var60 = 255;
            }

            if (var60 < 0) {
               var60 = 0;
            }

            this.rd.setColor(this.color2k(var60, var60, var60));
            this.rd.fillRoundRect(225, 59 - (int)(this.opengame * 2.23F), 495, 200 + this.opengame * 8, 20, 20);
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawRoundRect(225, 59 - (int)(this.opengame * 2.23F), 495, 200 + this.opengame * 8, 20, 20);
            if (!this.xt.lan) {
               this.rd.setColor(this.color2k(217, 217, 217));
               this.rd.fillRoundRect(225, 263 + this.opengame * 7, 495, 157, 20, 20);
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawRoundRect(225, 263 + this.opengame * 7, 495, 157, 20, 20);
            }

            this.btn = 0;
            if (this.prevloaded != -1) {
               this.prevloaded = -1;
            }

            if (this.updatec != -1) {
               this.updatec = -1;
            }

            if (this.gs.cmsg.isShowing()) {
               this.gs.cmsg.hide();
               this.gs.requestFocus();
            }

            this.opengame -= 2;
            if (this.opengame == 0 && this.longame != -1 && this.chalngd == -1) {
               this.ongame = this.longame;
               this.longame = -1;
            }

            if (this.invo) {
               this.invo = false;
            }

            for (int var78 = 0; var78 < 7; var78++) {
               if (!this.invos[var78].equals("")) {
                  this.invos[var78] = "";
               }

               if (!this.dinvi[var78].equals("")) {
                  this.dinvi[var78] = "";
               }
            }

            if (this.fstart) {
               this.fstart = false;
            }

            for (int var79 = 0; var79 < 9; var79++) {
               if (this.cac[var79] != -1) {
                  this.cac[var79] = -1;
               }
            }

            if (this.dispcar != -1) {
               this.dispcar = -1;
            }
         }
      }

      if (var8 != this.pcurs) {
         this.gs.setCursor(new Cursor(var8));
         this.pcurs = var8;
      }
   }

   public void preforma(int var1, int var2) {
      if (this.pre1) {
         boolean var3 = false;
         if (!this.gs.openm && this.gb.open == 0) {
            if (this.conon != 0) {
               var3 = true;
            }
         } else if (this.gs.cmsg.isShowing()) {
            this.gs.cmsg.hide();
         }

         this.gs.movefieldd(this.gs.cmsg, 235, 390, 360, 22, var3);
         if (this.gs.cmsg.getText().equals("Type here...") && var1 > 234 && var1 < 603 && var2 > 385 && var2 < 417) {
            this.gs.cmsg.setText("");
         }
      }

      if (this.pre2) {
         boolean var4 = false;
         if (!this.gs.openm && this.gb.open == 0) {
            var4 = true;
         } else if (this.gs.cmsg.isShowing()) {
            this.gs.cmsg.hide();
         }

         this.gs.movefieldd(this.gs.cmsg, 237, 390, 360, 22, var4);
         if (this.gs.cmsg.getText().equals("Type here...") && var1 > 232 && var1 < 601 && var2 > 385 && var2 < 417) {
            this.gs.cmsg.setText("");
         }
      }

      if (this.pre1 || this.pre2) {
         if (this.gs.cmsg.getText().length() > 100) {
            this.gs.cmsg.setText(this.gs.cmsg.getText().substring(0, 100));
            this.gs.cmsg.select(100, 100);
         }

         this.pre1 = false;
         this.pre2 = false;
      }
   }

   public void stageselect(CheckPoints var1, Control var2, int var3, int var4, boolean var5) {
      this.rd.setColor(new Color(0, 0, 0));
      this.rd.fillRect(0, 0, 65, 450);
      this.rd.fillRect(735, 0, 65, 450);
      this.rd.fillRect(65, 0, 670, 25);
      this.rd.fillRect(65, 425, 670, 25);
      this.btn = 0;
      byte var6 = 0;
      this.rd.drawImage(this.xt.br, 65, 25, null);
      if (this.britchl == -1) {
         this.ongame = -1;
         this.britchl = 0;
      }

      int var7 = 0;

      for (int var8 = 0; var8 < this.ngm; var8++) {
         if (this.ongame == this.gnum[var8]) {
            var7 = var8;
         }
      }

      if (this.chalngd != -2 && this.ongame != -1) {
         this.rd.setColor(this.color2k(20, 20, 20));
         this.rd.fillRect(80, 0, 640, 40);
         this.rd.setColor(this.color2k(70, 70, 70));
         this.rd.drawLine(80, 40, 720, 40);
         this.rd.drawLine(80, 40, 80, 0);
         this.rd.drawLine(720, 40, 720, 0);
         this.rd.setColor(new Color(193, 106, 0));
         this.rd.setFont(new Font("Arial", 1, 12));
         this.ftm = this.rd.getFontMetrics();
         if (this.wait[var7] > 0) {
            if (this.gwarb[var7] != 0) {
               this.rd.drawString("Waiting for " + (this.mnpls[var7] - this.npls[var7]) + " clan members to join to start this game!", 95, 23);
            } else if (this.wait[var7] <= 30 && this.npls[var7] > 1) {
               Date var13 = new Date();
               long var17 = var13.getTime();
               if (this.ptime == 0L || var17 > this.ptime + 1500L) {
                  if (this.ptime != 0L) {
                     this.wait[var7]--;
                     if (this.wait[var7] < 1) {
                        this.wait[var7] = 1;
                     }
                  }

                  this.ptime = var17;
               }

               if (this.pgames[this.im] == this.ongame || this.nflk != 0) {
                  this.rd
                     .drawString(
                        "Game starts in " + this.wait[var7] + " seconds!",
                        400 - this.ftm.stringWidth("Game starts in " + this.wait[var7] + " seconds!") / 2,
                        23
                     );
                  if (this.pgames[this.im] != this.ongame) {
                     this.nflk--;
                  }
               } else if (this.pgames[this.im] != this.ongame) {
                  this.nflk = 3;
               }
            } else {
               String var12 = "";
               if (this.npls[var7] > 1) {
                  Date var9 = new Date();
                  long var10 = var9.getTime();
                  if (this.ptime == 0L || var10 > this.ptime + 1500L) {
                     if (this.ptime != 0L) {
                        this.wait[var7]--;
                        if (this.wait[var7] < 1) {
                           this.wait[var7] = 1;
                        }
                     }

                     this.ptime = var10;
                  }

                  var12 = " (waiting " + this.wait[var7] + " seconds maximum)";
                  if (this.wait[var7] > 60) {
                     var12 = " (waiting " + (int)(this.wait[var7] / 60.0F * 100.0F) / 100.0F + " minutes maximum)";
                  }
               }

               this.rd.drawString("Waiting for " + (this.mnpls[var7] - this.npls[var7]) + " more players to join to start this game" + var12 + "!", 95, 15);
               this.rd.setFont(new Font("Arial", 0, 12));
               if (!this.gmaker[var7].equals("Coach Insano") && !this.gmaker[var7].equals(this.pnames[this.im])) {
                  boolean var16 = false;

                  for (int var20 = 0; var20 < this.npo; var20++) {
                     if (this.pgames[var20] == this.ongame && this.gmaker[var7].equals(this.pnames[var20])) {
                        var16 = true;
                     }
                  }

                  if (var16) {
                     this.rd.drawString("" + this.gmaker[var7] + " can start this game at anytime (the game creator)...", 95, 31);
                  }
               }
            }

            if (this.pgames[this.im] != this.ongame) {
               boolean var14 = false;
               if (this.gwarb[var7] == 0) {
                  if (this.gplyrs[var7].equals("") || this.gplyrs[var7].indexOf(this.pnames[this.im]) != -1) {
                     var14 = true;
                  }
               } else if (this.xt.clan.toLowerCase().equals(this.gaclan[var7].toLowerCase())
                  || this.xt.clan.toLowerCase().equals(this.gvclan[var7].toLowerCase())) {
                  var14 = true;
               }

               if (var14) {
                  this.stringbutton(" Join Game ", 660, 23, 2);
               }
            }
         } else {
            this.rd.setColor(this.color2k(120, 120, 120));
            if (this.wait[var7] == 0) {
               this.rd.drawString("Game Started", 400 - this.ftm.stringWidth("Game Started") / 2, 20);
            } else {
               this.rd.drawString("Game Finished", 400 - this.ftm.stringWidth("Game Finished") / 2, 20);
            }
         }
      }

      this.rd.setFont(new Font("Arial", 1, 11));
      this.xt.ftm = this.rd.getFontMetrics();
      this.ftm = this.rd.getFontMetrics();
      String var15 = "";
      if (var1.stage < 0) {
         var15 = "Custom Stage";
      }

      if (var1.stage > 0 && var1.stage <= 10) {
         var15 = "Stage " + var1.stage + " NFM 1";
      }

      if (var1.stage > 10 && var1.stage <= 27) {
         var15 = "Stage " + (var1.stage - 10) + " NFM 2";
      }

      if (var1.stage > 27) {
         var15 = "Multiplayer Stage " + (var1.stage - 27) + "";
      }

      this.xt.drawcs(85, "Previewing " + var15 + "  >", 255, 138, 0, 5);
      this.xt.drawcs(105, "| " + var1.name + " |", 255, 176, 85, 5);
      this.rd.drawImage(this.xt.back[this.pback], 532, 285, null);
      if (this.plsndt == 0) {
         String var18 = "Play Soundtrack >";
         int var21 = 562 - this.ftm.stringWidth(var18) / 2;
         int var11 = var21 + this.ftm.stringWidth(var18);
         this.rd.setColor(new Color(0, 0, 0));
         this.rd.drawString(var18, var21 + 1, 326);
         this.rd.drawLine(var21 + 1, 328, var11 + 1, 328);
         this.rd.setColor(new Color(255, 138, 0));
         this.rd.drawString(var18, var21, 325);
         this.rd.drawLine(var21, 327, var11, 327);
         if (var3 > var21 && var3 < var11 && var4 > 314 && var4 < 327) {
            var6 = 12;
            if (var5) {
               this.plsndt = 1;
            }
         }
      }

      if (this.plsndt == 1) {
         this.xt.drawcs(190, "Loading Soundtrack, please wait...", 255, 138, 0, 5);
      }

      if (var1.stage < 0) {
         this.rd.setColor(new Color(255, 138, 0));
         this.rd.drawString("Created by: " + var1.maker + "", 85, 413);
         if (var1.pubt > 0) {
            if (var1.pubt == 2) {
               this.xt.drawcs(413, "Super Public Stage", 41, 177, 255, 3);
            } else {
               this.xt.drawcs(413, "Public Stage", 41, 177, 255, 3);
            }

            if (this.addstage == 0 && this.xt.drawcarb(true, null, " Add to My Stages ", 334, 420, var3, var4, var5)) {
               if (this.xt.logged) {
                  this.cd.onstage = var1.name;
                  this.cd.staction = 2;
                  this.cd.sparkstageaction();
                  this.addstage = 2;
               } else {
                  this.addstage = 1;
                  this.waitlink = 20;
               }
            }

            if (this.addstage == 1) {
               this.rd.setFont(new Font("Arial", 1, 11));
               this.ftm = this.rd.getFontMetrics();
               this.rd.setColor(new Color(193, 106, 0));
               String var19 = "Upgrade to a full account to add custom stages!";
               int var22 = 400 - this.ftm.stringWidth(var19) / 2;
               int var23 = var22 + this.ftm.stringWidth(var19);
               this.rd.drawString(var19, var22, 435);
               if (this.waitlink != -1) {
                  this.rd.drawLine(var22, 437, var23, 437);
               }

               if (var3 > var22 && var3 < var23 && var4 > 424 && var4 < 437) {
                  if (this.waitlink != -1) {
                     var6 = 12;
                  }

                  if (var5 && this.waitlink == 0) {
                     this.gs.editlink(this.xt.nickname, true);
                     this.waitlink = -1;
                  }
               }

               if (this.waitlink > 0) {
                  this.waitlink--;
               }
            }

            if (this.addstage == 2) {
               this.xt.drawcs(435, "Adding stage please wait...", 193, 106, 0, 3);
               if (this.cd.staction == 0) {
                  this.addstage = 3;
               }

               if (this.cd.staction == -2) {
                  this.addstage = 4;
               }

               if (this.cd.staction == -3) {
                  this.addstage = 5;
               }

               if (this.cd.staction == -1) {
                  this.addstage = 6;
               }
            }

            if (this.addstage == 3) {
               this.xt.drawcs(435, "Stage has been successfully added to your stages!", 193, 106, 0, 3);
            }

            if (this.addstage == 4) {
               this.xt.drawcs(435, "You already have this stage!", 193, 106, 0, 3);
            }

            if (this.addstage == 5) {
               this.xt.drawcs(435, "Cannot add more then 20 stages to your account!", 193, 106, 0, 3);
            }

            if (this.addstage == 6) {
               this.xt.drawcs(435, "Failed to add stage, unknown error, please try again later.", 193, 106, 0, 3);
            }
         } else {
            this.xt.drawcs(435, "Private Stage", 193, 106, 0, 3);
         }
      }

      if (var2.enter || this.conon == 2 || this.ongame == -1 && this.chalngd != -2) {
         this.m.trk = 0;
         if (this.xt.loadedt) {
            this.xt.strack.unload();
         }

         this.m.focus_point = 400;
         this.m.crs = true;
         this.m.x = -335;
         this.m.y = 0;
         this.m.z = -50;
         this.m.xz = 0;
         this.m.zy = 20;
         this.m.ground = -2000;
         this.fase = 1;
         var2.enter = false;
      }

      if (var6 != this.pcurs) {
         this.gs.setCursor(new Cursor(var6));
         this.pcurs = var6;
      }
   }

   public void ctachm(int var1, int var2, int var3, Control var4) {
      int var5 = -1;
      if (this.fase == 1 || this.fase == 4) {
         for (int var6 = 0; var6 < this.btn; var6++) {
            if (Math.abs(var1 - this.bx[var6]) >= this.bw[var6] / 2 + 12 || Math.abs(var2 - this.by[var6]) >= 14 || var3 != 1 && var3 != 11) {
               this.pessd[var6] = false;
            } else {
               this.pessd[var6] = true;
            }

            if (Math.abs(var1 - this.bx[var6]) < this.bw[var6] / 2 + 12 && Math.abs(var2 - this.by[var6]) < 14 && var3 <= -1) {
               var5 = var6;
               this.gs.mouses = 0;
            }
         }
      }

      if (this.conon == 1) {
         if (!this.regnow) {
            if (this.onjoin == -1) {
               if (this.fase == 4) {
                  if (var1 <= 532 || var1 >= 592 || var2 <= 285 || var2 >= 306 || var3 != 1 && var3 != 11) {
                     this.pback = 0;
                  } else {
                     this.pback = 1;
                  }

                  if (var1 > 532 && var1 < 592 && var2 > 285 && var2 < 306 && var3 <= -1) {
                     this.gs.mouses = 0;
                     this.m.trk = 0;
                     if (this.xt.loadedt) {
                        this.xt.strack.unload();
                     }

                     this.m.focus_point = 400;
                     this.m.crs = true;
                     this.m.x = -335;
                     this.m.y = 0;
                     this.m.z = -50;
                     this.m.xz = 0;
                     this.m.zy = 20;
                     this.m.ground = -2000;
                     this.fase = 1;
                  }

                  if (var5 == 0 && this.chalngd == -1) {
                     var5 = -1;
                     this.join = this.ongame;
                     this.msg = "| Joining Game |";
                     this.spos = 0;
                     this.m.trk = 0;
                     if (this.xt.loadedt) {
                        this.xt.strack.unload();
                     }

                     this.m.focus_point = 400;
                     this.m.crs = true;
                     this.m.x = -335;
                     this.m.y = 0;
                     this.m.z = -50;
                     this.m.xz = 0;
                     this.m.zy = 20;
                     this.m.ground = -2000;
                     this.fase = 1;
                  }
               }

               if (this.fase == 1) {
                  if (this.ongame == -1) {
                     if (var5 == 0) {
                        if (this.chalngd == -1) {
                           if (this.xt.lan && !this.lanlogged) {
                              this.gs.reglink();
                           } else {
                              boolean var12 = false;

                              for (int var7 = 0; var7 < this.ngm; var7++) {
                                 if (this.wait[var7] == 0) {
                                    var12 = true;
                                    break;
                                 }
                              }

                              if (var12 && !this.xt.lan) {
                                 this.chalngd = -6;
                              } else {
                                 this.loadstage = 0;
                                 this.remstage = 0;
                                 this.gstage = 0;
                                 this.gnpls = 8;
                                 this.gwait = 0;
                                 this.gnbts = 0;
                                 this.gclass = 0;
                                 this.gcars = 0;
                                 this.gfix = 0;
                                 this.gnotp = 0;
                                 this.gplayers = "";
                                 this.gs.wgame.select(0);
                                 this.chalngd = -2;
                              }
                           }
                        } else if (this.chalngd != -5) {
                           if (this.invo) {
                              this.invo = false;
                           }

                           for (int var11 = 0; var11 < 7; var11++) {
                              if (!this.invos[var11].equals("")) {
                                 this.invos[var11] = "";
                              }

                              if (!this.dinvi[var11].equals("")) {
                                 this.dinvi[var11] = "";
                              }
                           }

                           this.gs.swait.hide();
                           this.gs.snpls.hide();
                           this.gs.snbts.hide();
                           this.gs.sgame.hide();
                           this.gs.wgame.hide();
                           this.gs.pgame.hide();
                           this.gs.vnpls.hide();
                           this.gs.vtyp.hide();
                           this.gs.warb.hide();
                           this.gs.mstgs.hide();
                           this.gs.slaps.hide();
                           this.gs.snfm1.hide();
                           this.gs.snfmm.hide();
                           this.gs.snfm2.hide();
                           this.gs.sclass.hide();
                           this.gs.scars.hide();
                           this.gs.sfix.hide();
                           this.gs.mycar.hide();
                           this.gs.notp.hide();
                           this.gs.requestFocus();
                           this.chalngd = -1;
                        }
                     }

                     if (var5 == 1) {
                        this.xt.fase = 23;
                     }

                     if (var5 == 2) {
                        this.conon = 0;
                        this.lg.exitfromlobby();

                        try {
                           this.socket.close();
                           this.socket = null;
                           this.din.close();
                           this.din = null;
                           this.dout.close();
                           this.dout = null;
                        } catch (Exception var10) {
                        }

                        this.hideinputs();
                     }

                     byte var13 = 3;
                     if (this.chalngd > -1) {
                        if (var5 == 3) {
                           this.ongame = this.chalngd;
                           this.chalngd = -1;
                        }

                        if (var5 == 4) {
                           this.ongame = this.chalngd;
                           this.join = this.chalngd;
                           this.msg = "| Joining Game |";
                           this.chalngd = -1;
                           this.longame = -1;
                        }

                        if (var5 == 5) {
                           this.ongame = this.longame;
                           this.chalngd = -1;
                           this.longame = -1;
                        }

                        var13 = 6;
                     } else {
                        if (this.chalngd != -1 && this.chalngd != -5 && var5 == 3) {
                           if (this.invo) {
                              this.invo = false;
                           }

                           for (int var15 = 0; var15 < 7; var15++) {
                              if (!this.invos[var15].equals("")) {
                                 this.invos[var15] = "";
                              }

                              if (!this.dinvi[var15].equals("")) {
                                 this.dinvi[var15] = "";
                              }
                           }

                           this.gs.swait.hide();
                           this.gs.snpls.hide();
                           this.gs.snbts.hide();
                           this.gs.sgame.hide();
                           this.gs.wgame.hide();
                           this.gs.pgame.hide();
                           this.gs.vnpls.hide();
                           this.gs.vtyp.hide();
                           this.gs.warb.hide();
                           this.gs.mstgs.hide();
                           this.gs.slaps.hide();
                           this.gs.snfm1.hide();
                           this.gs.snfmm.hide();
                           this.gs.snfm2.hide();
                           this.gs.sclass.hide();
                           this.gs.scars.hide();
                           this.gs.sfix.hide();
                           this.gs.mycar.hide();
                           this.gs.notp.hide();
                           this.gs.requestFocus();
                           this.chalngd = -1;
                        }

                        if (this.chalngd == -6 && var5 == 4) {
                           this.chalngd = -1;
                        }

                        if (this.chalngd == -2) {
                           if (this.gs.wgame.getSelectedIndex() == 0) {
                              if (this.gs.sgame.getSelectedIndex() >= 3 && !this.xt.logged) {
                                 if (var5 == 4) {
                                    this.gs.editlink(this.xt.nickname, true);
                                 }

                                 var13 = 5;
                              } else {
                                 if (var5 == 4) {
                                    if (this.loadstage < 0) {
                                       this.rd.setColor(new Color(0, 0, 0));
                                       this.rd.fillRect(0, 0, 670, 400);
                                       this.gs.repaint();
                                       this.gs.rooms.hide();
                                       this.gs.cmsg.hide();
                                       this.gs.sgame.hide();
                                       this.gs.wgame.hide();
                                       this.gs.warb.hide();
                                       this.gs.pgame.hide();
                                       this.gs.vnpls.hide();
                                       this.gs.vtyp.hide();
                                       this.gs.mstgs.hide();
                                       this.gs.slaps.hide();
                                       this.gs.snfm1.hide();
                                       this.gs.snfmm.hide();
                                       this.gs.snfm2.hide();
                                       this.gs.requestFocus();
                                       this.m.ptr = 0;
                                       this.m.ptcnt = -10;
                                       this.m.hit = 20000;
                                       this.m.fallen = 0;
                                       this.m.nrnd = 0;
                                       this.m.ih = 25;
                                       this.m.iw = 65;
                                       this.m.h = 425;
                                       this.m.w = 735;
                                       this.m.trk = 4;
                                       this.plsndt = 0;
                                       this.addstage = 0;
                                       this.fase = 4;
                                    } else {
                                       this.sflk = 25;
                                    }
                                 }

                                 if (this.loadstage >= 0) {
                                    var13 = 5;
                                 } else {
                                    if (var5 == 5) {
                                       if (this.gstage != 0) {
                                          this.gs.sgame.hide();
                                          this.gs.wgame.hide();
                                          this.gs.pgame.hide();
                                          this.gs.vnpls.hide();
                                          this.gs.vtyp.hide();
                                          this.gs.warb.hide();
                                          this.gs.mstgs.hide();
                                          this.gs.slaps.hide();
                                          this.gs.snfm1.hide();
                                          this.gs.snfmm.hide();
                                          this.gs.snfm2.hide();
                                          this.gs.requestFocus();
                                          this.chalngd = -3;
                                          var5 = -1;
                                       } else {
                                          this.sflk = 25;
                                       }
                                    }

                                    var13 = 6;
                                 }
                              }
                           } else if (!this.xt.clan.equals("")) {
                              int var16 = 4;
                              if (this.gs.warb.sel != 0 && this.gb.loadwbgames == 2) {
                                 if (this.gs.wgame.getSelectedIndex() == 1 && this.gs.vnpls.sel != 0 && this.cancreate == 2) {
                                    if (var5 == 4) {
                                       if (this.invo) {
                                          this.invo = false;
                                       }

                                       this.msg = "| Creating Game |";
                                       this.gplayers = "#warb#"
                                          + this.gb.warb
                                          + "#"
                                          + this.gb.warbnum
                                          + "#"
                                          + (this.gb.gameturn + 1)
                                          + "#"
                                          + this.xt.clan
                                          + "#"
                                          + this.gb.vclan
                                          + "#"
                                          + this.gb.ascore
                                          + "#"
                                          + this.gb.vscore
                                          + "#"
                                          + (this.gs.vtyp.sel + 1)
                                          + "#";
                                       this.gstage = this.gb.wbstage[this.gb.gameturn];
                                       this.gstagelaps = this.gb.wblaps[this.gb.gameturn];
                                       this.gcars = this.gb.wbcars[this.gb.gameturn] - 1;
                                       this.gclass = this.gb.wbclass[this.gb.gameturn];
                                       this.gfix = this.gb.wbfix[this.gb.gameturn];
                                       this.gnpls = 8;
                                       if (this.gs.vnpls.sel == 1) {
                                          this.gnpls = 4;
                                       }

                                       if (this.gs.vnpls.sel == 2) {
                                          this.gnpls = 6;
                                       }

                                       this.gwait = 120;
                                       this.gnotp = 0;
                                       this.gs.wgame.hide();
                                       this.gs.pgame.hide();
                                       this.gs.vnpls.hide();
                                       this.gs.vtyp.hide();
                                       this.gs.warb.hide();
                                       this.gs.requestFocus();
                                       this.chalngd = -5;
                                    }

                                    var16++;
                                 }

                                 if (this.gs.wgame.getSelectedIndex() == 2 && this.gs.pgame.sel != 0 && var5 == 4) {
                                    if (this.invo) {
                                       this.invo = false;
                                    }

                                    this.msg = "| Creating Game |";
                                    this.gstage = this.gb.wbstage[this.gs.pgame.sel - 1];
                                    this.gstagelaps = this.gb.wblaps[this.gs.pgame.sel - 1];
                                    this.gcars = this.gb.wbcars[this.gs.pgame.sel - 1] - 1;
                                    this.gclass = this.gb.wbclass[this.gs.pgame.sel - 1];
                                    this.gfix = this.gb.wbfix[this.gs.pgame.sel - 1];
                                    this.gnpls = 8;
                                    this.gwait = 120;
                                    this.gnotp = 0;
                                    this.gplayers = "";
                                    this.gs.wgame.hide();
                                    this.gs.pgame.hide();
                                    this.gs.vnpls.hide();
                                    this.gs.vtyp.hide();
                                    this.gs.warb.hide();
                                    this.gs.requestFocus();
                                    this.chalngd = -5;
                                 }

                                 if (this.gs.wgame.getSelectedIndex() == 1 && this.gb.canredo && var5 == var16) {
                                    this.gb.loadwbgames = 7;
                                 }
                              }
                           } else if (var5 == 4) {
                              this.gb.tab = 3;
                              this.gb.cfase = 2;
                              this.gb.em = 1;
                              this.gb.msg = "Clan Search";
                              this.gb.smsg = "Listing clans with recent activity...";
                              this.gb.nclns = 0;
                              this.gb.spos5 = 0;
                              this.gb.lspos5 = 0;
                              this.gb.flko = 0;
                              this.gb.open = 2;
                              this.gb.upo = true;
                           }
                        }

                        if (this.chalngd == -3) {
                           if (var5 == 4) {
                              this.chalngd = -2;
                              this.gs.snpls.hide();
                              this.gs.snbts.hide();
                              this.gs.swait.hide();
                              this.gs.requestFocus();
                           }

                           if (var5 == 5) {
                              if (this.gnpls != 0 && this.gs.snpls.getSelectedIndex() != 0) {
                                 this.chalngd = -4;

                                 for (int var17 = 0; var17 < 7; var17++) {
                                    if (!this.invos[var17].equals("")) {
                                       this.invos[var17] = "";
                                    }

                                    if (!this.dinvi[var17].equals("")) {
                                       this.dinvi[var17] = "";
                                    }
                                 }

                                 var5 = -1;
                                 this.gs.snpls.hide();
                                 this.gs.snbts.hide();
                                 this.gs.swait.hide();
                                 this.gs.requestFocus();
                              } else {
                                 this.sflk = 25;
                              }
                           }

                           var13 = 6;
                        }

                        if (this.chalngd == -4) {
                           var13 = 7;
                           int var18 = 0;

                           for (int var8 = 0; var8 < 7; var8++) {
                              if (!this.invos[var8].equals("")) {
                                 var18++;
                              }
                           }

                           if (var18 < this.gnpls - 1) {
                              if (var5 == 4) {
                                 if (!this.invo) {
                                    this.invo = true;
                                 } else {
                                    this.invo = false;
                                 }
                              }
                           } else {
                              var13 = 6;
                           }

                           if (var5 == var13 - 2) {
                              if (this.invo) {
                                 this.invo = false;
                              }

                              if (this.gs.mycar.getState() && this.xt.sc[0] < 16) {
                                 this.gclass = -(this.xt.sc[0] + 2);
                                 this.gcars = 0;
                              }

                              if (this.gs.notp.getState()) {
                                 this.gnotp = 1;
                              } else {
                                 this.gnotp = 0;
                              }

                              this.gplayers = "";
                              this.gs.sclass.hide();
                              this.gs.scars.hide();
                              this.gs.sfix.hide();
                              this.gs.mycar.hide();
                              this.gs.notp.hide();
                              this.gs.requestFocus();
                              this.chalngd = -3;
                           }

                           if (var5 == var13 - 1) {
                              if (this.invo) {
                                 this.invo = false;
                              }

                              this.msg = "| Creating Game |";
                              if (this.gs.mycar.getState() && this.xt.sc[0] < 16) {
                                 this.gclass = -(this.xt.sc[0] + 2);
                                 this.gcars = 0;
                              }

                              if (this.gclass != 0) {
                                 this.gwait = 120;
                              }

                              if (this.gs.notp.getState()) {
                                 this.gnotp = 1;
                              } else {
                                 this.gnotp = 0;
                              }

                              this.gplayers = "";
                              if (var18 != 0) {
                                 this.gnpls = var18 + 1;
                                 this.gplayers = "" + this.pnames[this.im] + "#";

                                 for (int var22 = 0; var22 < var18; var22++) {
                                    this.gplayers = this.gplayers + this.invos[var22] + "#";
                                 }
                              }

                              this.gs.sclass.hide();
                              this.gs.scars.hide();
                              this.gs.sfix.hide();
                              this.gs.mycar.hide();
                              this.gs.notp.hide();
                              this.gs.requestFocus();
                              this.chalngd = -5;
                           }
                        }
                     }

                     if (var5 == var13 && !this.xt.lan && !this.gs.cmsg.getText().equals("Type here...") && !this.gs.cmsg.getText().equals("")) {
                        String var19 = this.gs.cmsg.getText().replace('|', ':');
                        if (var19.toLowerCase().indexOf(this.gs.tpass.getText().toLowerCase()) != -1) {
                           var19 = " ";
                        }

                        if (!this.xt.msgcheck(var19) && this.updatec > -12) {
                           for (int var23 = 0; var23 < 6; var23++) {
                              this.sentn[var23] = this.sentn[var23 + 1];
                              this.cnames[var23] = this.cnames[var23 + 1];
                           }

                           this.sentn[6] = var19;
                           this.cnames[6] = this.pnames[this.im];
                           if (this.updatec > -11) {
                              this.updatec = -11;
                           } else {
                              this.updatec--;
                           }

                           this.spos3 = 28;
                        } else {
                           this.xt.warning++;
                        }

                        this.gs.cmsg.setText("");
                     }
                  } else if (this.dispcar == -1) {
                     int var14 = 0;

                     for (int var20 = 0; var20 < this.ngm; var20++) {
                        if (this.ongame == this.gnum[var20]) {
                           var14 = var20;
                        }
                     }

                     boolean var21 = false;
                     if (this.gwarb[var14] == 0) {
                        if (!this.gplyrs[var14].equals("") && this.gplyrs[var14].indexOf(this.pnames[this.im]) == -1) {
                           var21 = true;
                        }
                     } else if (!this.xt.clan.toLowerCase().equals(this.gaclan[var14].toLowerCase())
                        && !this.xt.clan.toLowerCase().equals(this.gvclan[var14].toLowerCase())) {
                        var21 = true;
                     }

                     if (var4.enter && this.wait[var14] > 0 && this.pgames[this.im] == -1 && !var21) {
                        this.join = this.ongame;
                        this.msg = "| Joining Game |";
                        this.spos = 0;
                        if (this.pbtn == 0) {
                           this.pessd[1] = true;
                        }
                     }

                     if (this.wait[var14] == -1 && this.pgames[this.im] == -1 && var4.enter) {
                        var5 = 0;
                        this.pessd[0] = true;
                     }

                     if (this.pgames[this.im] == -1 && var4.exit) {
                        var5 = 0;
                        this.pessd[0] = true;
                     }

                     if (var5 == 0) {
                        if (this.pgames[this.im] == -1) {
                           this.ongame = -1;
                           this.chalngd = -1;
                        } else {
                           this.join = -2;
                           this.msg = "| Leaving Game |";
                           this.longame = -1;
                        }
                     }

                     if (this.pbtn == 0) {
                        if (var5 == 1) {
                           if (this.wait[var14] > 0) {
                              if (this.pgames[this.im] == -1) {
                                 this.join = this.ongame;
                                 this.msg = "| Joining Game |";
                                 this.spos = 0;
                              } else if (this.gmaker[var14].equals(this.pnames[this.im]) && this.npls[var14] > 1) {
                                 this.fstart = true;
                              } else {
                                 var5 = 2;
                              }
                           } else {
                              if (this.wait[var14] == 0 && this.prevloaded == 1) {
                                 this.laps = this.gnlaps[var14];
                                 this.stage = this.gstgn[var14];
                                 this.stagename = this.gstages[var14];
                                 this.nfix = this.gfx[var14];
                                 if (this.gntb[var14] == 1) {
                                    this.notb = true;
                                 } else {
                                    this.notb = false;
                                 }

                                 this.gs.setCursor(new Cursor(3));
                                 this.conon = 3;
                              } else {
                                 var5 = 2;
                              }

                              if (this.wait[var14] == 0 && this.xt.lan) {
                                 this.laps = this.gnlaps[var14];
                                 this.stage = this.gstgn[var14];
                                 this.stagename = this.gstages[var14];
                                 this.nfix = this.gfx[var14];
                                 if (this.gntb[var14] == 1) {
                                    this.notb = true;
                                 } else {
                                    this.notb = false;
                                 }

                                 this.gs.setCursor(new Cursor(3));
                                 this.conon = 3;
                              }
                           }
                        }

                        if (var5 == 2 && !this.xt.lan && !this.gs.cmsg.getText().equals("Type here...") && !this.gs.cmsg.getText().equals("")) {
                           String var24 = this.gs.cmsg.getText().replace('|', ':');
                           if (var24.toLowerCase().indexOf(this.gs.tpass.getText().toLowerCase()) != -1) {
                              var24 = " ";
                           }

                           if (!this.xt.msgcheck(var24) && this.updatec > -12) {
                              for (int var9 = 0; var9 < 6; var9++) {
                                 this.sentn[var9] = this.sentn[var9 + 1];
                                 this.cnames[var9] = this.cnames[var9 + 1];
                              }

                              this.sentn[6] = var24;
                              this.cnames[6] = this.pnames[this.im];
                              if (this.updatec > -11) {
                                 this.updatec = -11;
                              } else {
                                 this.updatec--;
                              }
                           } else {
                              this.xt.warning++;
                           }

                           this.gs.cmsg.setText("");
                        }
                     }

                     if (this.pbtn == 1 && var5 == 1) {
                        if (this.pgames[this.im] == -1) {
                           this.join = this.ongame;
                           this.msg = "| Joining Game |";
                           this.spos = 0;
                        } else if (!this.invo) {
                           this.invo = true;
                        } else {
                           this.invo = false;
                        }
                     }

                     if (this.pbtn == 2 && (var5 == 1 || var5 == 2)) {
                        this.fase = 2;
                        this.m.ptr = 0;
                        this.m.ptcnt = -10;
                        this.m.hit = 20000;
                        this.m.fallen = 500;
                        this.m.nrnd = 0;
                        this.m.ih = 25;
                        this.m.iw = 65;
                        this.m.h = 425;
                        this.m.w = 735;
                        this.m.trk = 4;
                        this.plsndt = 0;
                        if (this.gs.cmsg.isShowing()) {
                           this.gs.cmsg.hide();
                           this.gs.requestFocus();
                        }
                     }
                  } else {
                     if (var5 == 0) {
                        if (this.pgames[this.im] == -1) {
                           this.ongame = -1;
                           this.chalngd = -1;
                        } else {
                           this.join = -2;
                           this.msg = "| Leaving Game |";
                           this.longame = -1;
                        }
                     }

                     if (this.pbtn == 1 && var5 == 1) {
                        if (this.pgames[this.im] == -1) {
                           this.join = this.ongame;
                           this.msg = "| Joining Game |";
                           this.spos = 0;
                        } else if (!this.invo) {
                           this.invo = true;
                        } else {
                           this.invo = false;
                        }
                     }
                  }
               }
            } else if (this.ontyp != 76) {
               if (var5 == 0) {
                  if (this.ontyp < 30) {
                     this.xt.onjoin = this.onjoin;
                     this.xt.ontyp = this.ontyp;
                     this.xt.playingame = -101;
                     this.xt.fase = 23;
                  } else {
                     if (!this.gb.claname.equals(this.xt.clan)) {
                        this.gb.claname = this.xt.clan;
                        this.gb.loadedc = false;
                     }

                     this.gb.spos5 = 0;
                     this.gb.lspos5 = 0;
                     this.gb.cfase = 3;
                     this.gb.loadedcars = -1;
                     this.gb.loadedcar = 0;
                     this.gb.ctab = 2;
                     this.gb.tab = 3;
                     this.gb.open = 2;
                     this.gb.upo = true;
                     this.onjoin = -1;
                  }
               }

               if (var5 == 1) {
                  this.onjoin = -1;
               }
            } else {
               if (var5 == 0) {
                  this.gs.editlink(this.xt.nickname, true);
                  this.onjoin = -1;
               }

               if (var5 == 1) {
                  this.onjoin = -1;
               }
            }
         } else {
            if (var5 == 0) {
               this.gs.editlink(this.xt.nickname, true);
            }

            if (var5 == 1) {
               this.regnow = false;
            }
         }
      }

      this.lxm = var1;
      this.lym = var2;
      var4.enter = false;
      var4.exit = false;
   }

   public void hideinputs() {
      this.gs.cmsg.hide();
      this.gs.swait.hide();
      this.gs.snpls.hide();
      this.gs.snbts.hide();
      this.gs.sgame.hide();
      this.gs.wgame.hide();
      this.gs.pgame.hide();
      this.gs.vnpls.hide();
      this.gs.vtyp.hide();
      this.gs.warb.hide();
      this.gs.mstgs.hide();
      this.gs.snfm1.hide();
      this.gs.snfmm.hide();
      this.gs.slaps.hide();
      this.gs.snfm2.hide();
      this.gs.sclass.hide();
      this.gs.scars.hide();
      this.gs.sfix.hide();
      this.gs.mycar.hide();
      this.gs.notp.hide();
      this.gs.rooms.hide();
      this.gs.requestFocus();
   }

   public void drawSbutton(Image var1, int var2, int var3) {
      this.bx[this.btn] = var2;
      this.by[this.btn] = var3;
      this.bw[this.btn] = var1.getWidth(this.ob);
      if (!this.pessd[this.btn]) {
         this.rd.drawImage(var1, var2 - this.bw[this.btn] / 2, var3 - var1.getHeight(this.ob) / 2 - 1, null);
         this.rd.drawImage(this.xt.bols, var2 - this.bw[this.btn] / 2 - 15, var3 - 13, null);
         this.rd.drawImage(this.xt.bors, var2 + this.bw[this.btn] / 2 + 9, var3 - 13, null);
         this.rd.drawImage(this.xt.bot, var2 - this.bw[this.btn] / 2 - 9, var3 - 13, this.bw[this.btn] + 18, 3, null);
         this.rd.drawImage(this.xt.bob, var2 - this.bw[this.btn] / 2 - 9, var3 + 10, this.bw[this.btn] + 18, 3, null);
      } else {
         this.rd.drawImage(var1, var2 - this.bw[this.btn] / 2 + 1, var3 - var1.getHeight(this.ob) / 2, null);
         this.rd.drawImage(this.xt.bolps, var2 - this.bw[this.btn] / 2 - 15, var3 - 13, null);
         this.rd.drawImage(this.xt.borps, var2 + this.bw[this.btn] / 2 + 9, var3 - 13, null);
         this.rd.drawImage(this.xt.bob, var2 - this.bw[this.btn] / 2 - 9, var3 - 13, this.bw[this.btn] + 18, 3, null);
         this.rd.drawImage(this.xt.bot, var2 - this.bw[this.btn] / 2 - 9, var3 + 10, this.bw[this.btn] + 18, 3, null);
      }

      this.btn++;
   }

   public void stringbutton(String var1, int var2, int var3, int var4) {
      this.rd.setFont(new Font("Arial", 1, 12));
      this.ftm = this.rd.getFontMetrics();
      this.bx[this.btn] = var2;
      this.by[this.btn] = var3 - 5;
      this.bw[this.btn] = this.ftm.stringWidth(var1);
      if (!this.pessd[this.btn]) {
         this.rd.setColor(this.color2k(220, 220, 220));
         this.rd.fillRect(var2 - this.bw[this.btn] / 2 - 10, var3 - (17 - var4), this.bw[this.btn] + 20, 25 - var4 * 2);
         this.rd.setColor(this.color2k(240, 240, 240));
         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 10, var3 - (17 - var4), var2 + this.bw[this.btn] / 2 + 10, var3 - (17 - var4));
         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 10, var3 - (18 - var4), var2 + this.bw[this.btn] / 2 + 10, var3 - (18 - var4));
         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 9, var3 - (19 - var4), var2 + this.bw[this.btn] / 2 + 9, var3 - (19 - var4));
         this.rd.setColor(this.color2k(200, 200, 200));
         this.rd.drawLine(var2 + this.bw[this.btn] / 2 + 10, var3 - (17 - var4), var2 + this.bw[this.btn] / 2 + 10, var3 + (7 - var4));
         this.rd.drawLine(var2 + this.bw[this.btn] / 2 + 11, var3 - (17 - var4), var2 + this.bw[this.btn] / 2 + 11, var3 + (7 - var4));
         this.rd.drawLine(var2 + this.bw[this.btn] / 2 + 12, var3 - (16 - var4), var2 + this.bw[this.btn] / 2 + 12, var3 + (6 - var4));
         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 10, var3 + (7 - var4), var2 + this.bw[this.btn] / 2 + 10, var3 + (7 - var4));
         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 10, var3 + (8 - var4), var2 + this.bw[this.btn] / 2 + 10, var3 + (8 - var4));
         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 9, var3 + (9 - var4), var2 + this.bw[this.btn] / 2 + 9, var3 + (9 - var4));
         this.rd.setColor(this.color2k(240, 240, 240));
         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 10, var3 - (17 - var4), var2 - this.bw[this.btn] / 2 - 10, var3 + (7 - var4));
         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 11, var3 - (17 - var4), var2 - this.bw[this.btn] / 2 - 11, var3 + (7 - var4));
         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 12, var3 - (16 - var4), var2 - this.bw[this.btn] / 2 - 12, var3 + (6 - var4));
         this.rd.setColor(new Color(0, 0, 0));
         this.rd.drawString(var1, var2 - this.bw[this.btn] / 2, var3);
      } else {
         this.rd.setColor(this.color2k(210, 210, 210));
         this.rd.fillRect(var2 - this.bw[this.btn] / 2 - 10, var3 - (17 - var4), this.bw[this.btn] + 20, 25 - var4 * 2);
         this.rd.setColor(this.color2k(200, 200, 200));
         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 10, var3 - (17 - var4), var2 + this.bw[this.btn] / 2 + 10, var3 - (17 - var4));
         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 10, var3 - (18 - var4), var2 + this.bw[this.btn] / 2 + 10, var3 - (18 - var4));
         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 9, var3 - (19 - var4), var2 + this.bw[this.btn] / 2 + 9, var3 - (19 - var4));
         this.rd.drawLine(var2 + this.bw[this.btn] / 2 + 10, var3 - (17 - var4), var2 + this.bw[this.btn] / 2 + 10, var3 + (7 - var4));
         this.rd.drawLine(var2 + this.bw[this.btn] / 2 + 11, var3 - (17 - var4), var2 + this.bw[this.btn] / 2 + 11, var3 + (7 - var4));
         this.rd.drawLine(var2 + this.bw[this.btn] / 2 + 12, var3 - (16 - var4), var2 + this.bw[this.btn] / 2 + 12, var3 + (6 - var4));
         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 10, var3 + (7 - var4), var2 + this.bw[this.btn] / 2 + 10, var3 + (7 - var4));
         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 10, var3 + (8 - var4), var2 + this.bw[this.btn] / 2 + 10, var3 + (8 - var4));
         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 9, var3 + (9 - var4), var2 + this.bw[this.btn] / 2 + 9, var3 + (9 - var4));
         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 10, var3 - (17 - var4), var2 - this.bw[this.btn] / 2 - 10, var3 + (7 - var4));
         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 11, var3 - (17 - var4), var2 - this.bw[this.btn] / 2 - 11, var3 + (7 - var4));
         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 12, var3 - (16 - var4), var2 - this.bw[this.btn] / 2 - 12, var3 + (6 - var4));
         this.rd.setColor(new Color(0, 0, 0));
         this.rd.drawString(var1, var2 - this.bw[this.btn] / 2 + 1, var3);
      }

      this.btn++;
   }

   public Color color2k(int var1, int var2, int var3) {
      Color var4 = new Color(var1, var2, var3);
      float[] var5 = new float[3];
      Color.RGBtoHSB(var4.getRed(), var4.getGreen(), var4.getBlue(), var5);
      var5[0] = 0.13F;
      var5[1] = 0.35F;
      return Color.getHSBColor(var5[0], var5[1], var5[2]);
   }

   public int getvalue(String var1, int var2) {
      int var3 = -1;

      try {
         int var4 = 0;
         int var5 = 0;
         byte var6 = 0;
         String var7 = "";

         String var8;
         for (var8 = ""; var4 < var1.length() && var6 != 2; var4++) {
            var7 = "" + var1.charAt(var4);
            if (var7.equals("|")) {
               if (var6 == 1 || ++var5 > var2) {
                  var6 = 2;
               }
            } else if (var5 == var2) {
               var8 = var8 + var7;
               var6 = 1;
            }
         }

         if (var8.equals("")) {
            var8 = "-1";
         }

         var3 = Integer.valueOf(var8);
      } catch (Exception var9) {
      }

      return var3;
   }

   public String getSvalue(String var1, int var2) {
      String var3 = "";

      try {
         int var4 = 0;
         int var5 = 0;
         byte var6 = 0;
         String var7 = "";

         String var8;
         for (var8 = ""; var4 < var1.length() && var6 != 2; var4++) {
            var7 = "" + var1.charAt(var4);
            if (var7.equals("|")) {
               if (var6 == 1 || ++var5 > var2) {
                  var6 = 2;
               }
            } else if (var5 == var2) {
               var8 = var8 + var7;
               var6 = 1;
            }
         }

         var3 = var8;
      } catch (Exception var9) {
      }

      return var3;
   }

   public int getHvalue(String var1, int var2) {
      int var3 = -1;

      try {
         int var4 = 0;
         int var5 = 0;
         byte var6 = 0;
         String var7 = "";

         String var8;
         for (var8 = ""; var4 < var1.length() && var6 != 2; var4++) {
            var7 = "" + var1.charAt(var4);
            if (var7.equals("#")) {
               if (var6 == 1 || ++var5 > var2) {
                  var6 = 2;
               }
            } else if (var5 == var2) {
               var8 = var8 + var7;
               var6 = 1;
            }
         }

         if (var8.equals("")) {
            var8 = "-1";
         }

         var3 = Integer.valueOf(var8);
      } catch (Exception var9) {
      }

      return var3;
   }

   public String getHSvalue(String var1, int var2) {
      String var3 = "";

      try {
         int var4 = 0;
         int var5 = 0;
         byte var6 = 0;
         String var7 = "";

         String var8;
         for (var8 = ""; var4 < var1.length() && var6 != 2; var4++) {
            var7 = "" + var1.charAt(var4);
            if (var7.equals("#")) {
               if (var6 == 1 || ++var5 > var2) {
                  var6 = 2;
               }
            } else if (var5 == var2) {
               var8 = var8 + var7;
               var6 = 1;
            }
         }

         var3 = var8;
      } catch (Exception var9) {
      }

      return var3;
   }

   public String getSevervalue(String var1, int var2) {
      String var3 = "";
      if (!var1.equals("")) {
         try {
            boolean var4 = false;
            int var5 = 0;
            int var6 = 0;
            byte var7 = 0;
            String var8 = "";

            String var9;
            for (var9 = ""; var5 < var1.length() && var7 != 2; var5++) {
               var8 = "" + var1.charAt(var5);
               if (var8.equals("|")) {
                  if (var7 == 1 || ++var6 > var2) {
                     var7 = 2;
                  }
               } else if (var6 == var2) {
                  var9 = var9 + var8;
                  var7 = 1;
               }
            }

            var3 = var9;
         } catch (Exception var10) {
            var3 = "";
         }
      }

      return var3;
   }
}
