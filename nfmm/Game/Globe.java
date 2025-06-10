import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.Calendar;

public class Globe implements Runnable {
   MediaTracker mt;
   Graphics2D rd;
   xtGraphics xt;
   FontMetrics ftm;
   ImageObserver ob;
   GameSparker gs;
   Login lg;
   CarDefine cd;
   Medium m;
   Graphics2D rdo;
   Image gImage;
   Thread connector;
   boolean domon = false;
   Socket socket;
   BufferedReader din;
   PrintWriter dout;
   int fase = 0;
   int open = 0;
   boolean upo = false;
   int tab = 3;
   boolean onp = false;
   int ptab = 0;
   int spos = 0;
   int lspos = 0;
   int mscro = 825;
   int spos2 = 0;
   int lspos2 = 0;
   int mscro2 = 825;
   int spos3 = 0;
   int lspos3 = 0;
   int mscro3 = 825;
   int spos4 = 208;
   int lspos4 = 0;
   int mscro4 = 825;
   int spos5 = 0;
   int lspos5 = 0;
   int mscro5 = 825;
   int overit = 0;
   int flk = 0;
   int flko = 0;
   boolean flg = false;
   int curs = 0;
   int waitlink = 0;
   int addstage = 0;
   boolean darker = false;
   int npo = -1;
   String[] pname = new String[900];
   int[] proom = new int[900];
   int[] pserver = new int[900];
   int[][] roomf = new int[3][5];
   int npf = -1;
   String[] fname = new String[900];
   String[] cnfname = new String[10];
   int ncnf = 0;
   int freq = 0;
   int sfreq = 0;
   String freqname = "";
   String sfreqname = "";
   int cntf = 0;
   String[] cnames = new String[21];
   String[] sentn = new String[21];
   String[] ctime = new String[21];
   long[] nctime = new long[21];
   int updatec = -1;
   String proname = "";
   boolean loadedp = false;
   int edit = 0;
   int upload = 0;
   int perc = 0;
   int playt = 0;
   int uploadt = 0;
   String filename = "";
   String msg = "";
   String trackname = "";
   boolean refresh = false;
   boolean logol = false;
   boolean avatarl = false;
   int sentchange = 0;
   boolean badlang = false;
   String[] aboutxt = new String[3];
   int nab = 0;
   Image clanlogo;
   Image avatar;
   int racing = 50;
   int wasting = 150;
   String themesong = "";
   String sentance = "";
   int trackvol = 0;
   int comesoon = 0;
   String proclan = "";
   int protab = 0;
   int loadpst = 0;
   String loadpstage = "";
   boolean loadedpstage = false;
   int nlg = 0;
   String[] logos = new String[200];
   boolean[] logon = new boolean[200];
   Image[] logoi = new Image[200];
   int loadmsgs = -1;
   String hasmsgs = "";
   String lastsub = "";
   int nm = 0;
   String[] mname = new String[200];
   String[] mconvo = new String[200];
   String[] msub = new String[200];
   int[] mtyp = new int[200];
   String[] mtime = new String[200];
   long[] mctime = new long[200];
   int openc = 0;
   int opy = 0;
   int addopy = 0;
   int oph = 0;
   int itemsel = 0;
   int loaditem = 0;
   String[] mline = new String[1000];
   int[] mlinetyp = new int[1000];
   long[] mctimes = new long[1000];
   String[] mtimes = new String[1000];
   int nml = 0;
   int readmsg = 0;
   String opname = "";
   String blockname = "";
   String unblockname = "";
   int sendmsg = 0;
   String[] wday = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
   String[] month = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
   int itab = 0;
   int litab = -1;
   int cadmin = 0;
   String[] cmline = new String[1000];
   int[] cmlinetyp = new int[1000];
   long[] cmctimes = new long[1000];
   String[] cmtimes = new String[1000];
   int cnml = 0;
   int readclan = 0;
   int sendcmsg = 0;
   int loadinter = -1;
   int ni = 0;
   String[] iclan = new String[200];
   String[] iconvo = new String[200];
   String[] isub = new String[200];
   String[] icheck = new String[200];
   String[] itime = new String[200];
   long[] ictime = new long[200];
   String[] istat = new String[200];
   String[] itcar = new String[200];
   String[] igcar = new String[200];
   String[] iwarn = new String[200];
   int openi = 0;
   int readint = 0;
   String intclan = "";
   String lastint = "";
   int dispi = 0;
   String dwarn = "";
   String dtcar = "";
   String dgcar = "";
   int nil = 0;
   String[] iline = new String[1000];
   int[] ilinetyp = new int[1000];
   long[] ictimes = new long[1000];
   String[] itimes = new String[1000];
   int intsel = 0;
   int isel = 0;
   int ifas = 0;
   int leader = -1;
   int sendint = 0;
   boolean inishsel = false;
   boolean redif = false;
   String imsg = "";
   int wag = 0;
   int iflk = 0;
   String itake = "";
   String igive = "";
   String viewcar = "";
   String warnum = "";
   boolean sendwarnum = false;
   String[] wstages = new String[5];
   int[] wlaps = new int[5];
   int[] wcars = new int[5];
   int[] wclass = new int[5];
   int[] wfix = new int[5];
   int nvgames1 = 0;
   int nvgames2 = 0;
   int viewgame1 = 0;
   int viewgame2 = 0;
   String viewwar1 = "";
   String viewwar2 = "";
   String xclan = "";
   String sendwar = "";
   boolean ichlng = false;
   String[] vwstages1 = new String[10];
   int[] vwlaps1 = new int[10];
   int[] vwcars1 = new int[10];
   int[] vwclass1 = new int[10];
   int[] vwfix1 = new int[10];
   String[] vwstages2 = new String[10];
   int[] vwlaps2 = new int[10];
   int[] vwcars2 = new int[10];
   int[] vwclass2 = new int[10];
   int[] vwfix2 = new int[10];
   String[] vwinner = new String[10];
   int vwscorex = 0;
   int vwscorei = 0;
   Image intclanbg = null;
   String intclanlo = "";
   boolean intclanbgloaded = false;
   Image myclanbg = null;
   int loadedmyclanbg = 0;
   int cfase = 0;
   boolean notclan = false;
   String claname = "EvilOnes";
   boolean loadedc = false;
   boolean clanbgl = false;
   Image clanbg;
   int editc = 0;
   int em = 0;
   int ctab = 0;
   int nmb = 0;
   String lccnam = "";
   String[] member = new String[20];
   int[] mlevel = new int[20];
   String[] mrank = new String[20];
   int nrmb = 0;
   String[] rmember = new String[100];
   boolean showreqs = false;
   int blocknote = 0;
   int blockb = 0;
   boolean loadedcm = false;
   int ncln = 0;
   String[] clname = new String[20];
   String smsg = "";
   String sltit = "";
   boolean attachetoclan = false;
   boolean loadedlink = false;
   int loadedcars = -1;
   int loadedcar = 0;
   String ltit = "";
   String ldes = "";
   String lurl = "";
   boolean forcsel = false;
   String selcar = "";
   String selstage = "";
   String perry = "";
   int mrot = 0;
   int loadedstages = -1;
   int loadedstage = 0;
   CheckPoints cp;
   ContO[] bco;
   ContO[] co;
   int mouson = -1;
   int nclns = 0;
   String[] clanlo = new String[20];
   int ntab = 0;
   int loadednews = 0;
   int spos6 = 0;
   int lspos6 = 0;
   String[] newplayers = new String[]{"", "", "", "", ""};
   int[] nwarbs = new int[]{-1, -1, -1, -1, -1};
   String[] nwclan = new String[5];
   String[] nlclan = new String[5];
   String[] nwinob = new String[5];
   int[] nwinp = new int[5];
   int[] nlosp = new int[5];
   String[] nwtime = new String[5];
   int il = 0;
   String[] nttime = new String[300];
   String[] text = new String[300];
   int[] nln = new int[300];
   String[][][] link = new String[300][4][2];
   int maxclans = 1000;
   int loadwstat = 0;
   int ncc = 0;
   int champ = -1;
   int leadsby = 0;
   String[] conclan;
   int[] totp;
   int[] ord;
   int[] nvc;
   int[][] points;
   String[][] verclan;
   int eng = -1;
   int engo = 0;
   boolean frkl = false;
   int underc = 0;
   float bgf = 0.0F;
   boolean bgup = false;
   int[] bgx = new int[]{0, 670, 1340};
   int flkn = 0;
   int cur = 0;
   int sdist = 0;
   int scro = 0;
   boolean donewc = false;
   boolean dosrch = false;
   boolean dorank = false;
   boolean doweb1 = false;
   boolean doweb2 = false;
   boolean dommsg = false;
   boolean donemsg = false;
   int doi = 0;
   int ados = 0;
   int lspos6w = 0;
   long ntime = 0L;
   int loadwbgames = 0;
   int warb = 0;
   int gameturn = -1;
   String warbnum = "";
   String vclan = "";
   String[] wbstages = new String[10];
   int[] wbstage = new int[10];
   int[] wblaps = new int[10];
   int[] wbcars = new int[10];
   int[] wbclass = new int[10];
   int[] wbfix = new int[10];
   String gameturndisp = "";
   int ascore = 0;
   int vscore = 0;
   String lwbwinner = "";
   boolean canredo = false;

   public Globe(Graphics2D var1, xtGraphics var2, Medium var3, Login var4, CarDefine var5, CheckPoints var6, ContO[] var7, ContO[] var8, GameSparker var9) {
      this.rd = var1;
      this.xt = var2;
      this.m = var3;
      this.gs = var9;
      this.lg = var4;
      this.cd = var5;
      this.cp = var6;
      this.bco = var7;
      this.co = var8;
      this.gImage = this.gs.createImage(560, 300);
      this.rdo = (Graphics2D)this.gImage.getGraphics();
      this.rdo.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
      this.rdo.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

      for (int var10 = 0; var10 < 21; var10++) {
         this.ctime[var10] = "";
         this.cnames[var10] = "";
         this.sentn[var10] = "";
         this.nctime[var10] = 0L;
      }

      for (int var11 = 0; var11 < 900; var11++) {
         this.pname[var11] = "";
      }

      for (int var12 = 0; var12 < 200; var12++) {
         this.logos[var12] = "";
         this.logon[var12] = false;
      }

      this.mt = new MediaTracker(this.gs);
      this.gs.sendtyp.setBackground(this.colorb2k(false, 210, 210, 210));
      this.gs.sendtyp.setForeground(new Color(0, 0, 0));
      this.gs.sendtyp.removeAll();
      this.gs.sendtyp.add(this.rd, "Write a Message");
      this.gs.sendtyp.add(this.rd, "Share a Custom Car");
      this.gs.sendtyp.add(this.rd, "Share a Custom Stage");
      this.gs.sendtyp.add(this.rd, "Send a Clan Invitation");
      this.gs.sendtyp.add(this.rd, "Share a Relative Date");
      this.gs.senditem.setBackground(this.colorb2k(false, 230, 230, 230));
      this.gs.senditem.setForeground(new Color(0, 0, 0));
      this.gs.proitem.setBackground(new Color(206, 171, 98));
      this.gs.proitem.setForeground(new Color(0, 0, 0));
      this.gs.datat.setBackground(this.colorb2k(false, 230, 230, 230));
      this.gs.datat.setForeground(new Color(0, 0, 0));
      this.gs.mmsg.setBackground(this.colorb2k(false, 240, 240, 240));
      this.gs.mmsg.setForeground(new Color(0, 0, 0));
      this.gs.clanlev.setBackground(this.colorb2k(false, 230, 230, 230));
      this.gs.clanlev.setForeground(new Color(0, 0, 0));
      this.gs.clcars.setBackground(new Color(0, 0, 0));
      this.gs.clcars.setForeground(new Color(255, 255, 255));
      this.gs.ilaps.setBackground(this.colorb2k(false, 220, 220, 220));
      this.gs.ilaps.setForeground(new Color(0, 0, 0));
      this.gs.icars.setBackground(this.colorb2k(false, 220, 220, 220));
      this.gs.icars.setForeground(new Color(0, 0, 0));
      if (!this.xt.clan.equals("")) {
         this.itab = 2;
      }
   }

   public void dome(int var1, int var2, int var3, boolean var4, Control var5) {
      boolean var6 = false;
      boolean var7 = false;
      this.dommsg = false;
      this.dorank = false;
      this.donewc = false;
      this.dosrch = false;
      this.doweb1 = false;
      this.doweb2 = false;
      if (this.open == 0) {
         boolean var8 = false;
         if (this.lg.nmsgs == 0 && this.lg.nfreq == 0 && this.lg.nconf == 0 && this.lg.ncreq == 0 && this.lg.clanapv.equals("")) {
            if (var3 > 425 && var3 < 450 && var2 < 568 && var2 > 232) {
               var8 = true;
            }

            int[] var34 = new int[]{0, 9, 232, 250, 550, 568, 791, 800};
            int[] var38 = new int[]{452, 443, 443, 425, 425, 443, 443, 452};
            if (var8) {
               this.rd.setColor(this.color2k(255, 255, 255));
            } else {
               this.rd.setColor(new Color(207, 177, 110));
            }

            this.rd.fillPolygon(var34, var38, 8);
            this.rd.setColor(new Color(103, 88, 55));
            this.rd.drawPolygon(var34, var38, 8);
            this.rd.drawImage(this.xt.dome, 311, 430, null);
         } else {
            String var9 = "You have ";
            if (!this.lg.clanapv.equals("")) {
               var9 = var9 + "been approved for a clan membership";
               if (this.lg.nmsgs != 0 || this.lg.nfreq != 0 || this.lg.nconf != 0) {
                  var9 = var9 + "! + You have ";
               }
            }

            if (this.lg.ncreq != 0) {
               var9 = var9 + "" + this.lg.ncreq + " clan membership requests";
               if (this.lg.nmsgs != 0 || this.lg.nfreq != 0 || this.lg.nconf != 0) {
                  var9 = var9 + "! + You have ";
               }
            }

            if (this.lg.nmsgs != 0) {
               var9 = var9 + "new interactions";
               if (this.lg.fclan > 0 && this.lg.fplayer > 0) {
                  String var10 = "";
                  String var11 = "";
                  if (this.lg.fplayer > 1) {
                     var10 = "s";
                  }

                  if (this.lg.fclan > 1) {
                     var11 = "s";
                  }

                  var9 = var9 + " from " + this.lg.fplayer + " player" + var10 + " & " + this.lg.fclan + " clan" + var11 + "";
               } else {
                  if (this.lg.fclan == 1) {
                     var9 = var9 + " from 1 clan";
                  }

                  if (this.lg.fclan > 1) {
                     var9 = var9 + " from " + this.lg.fclan + " clans";
                  }

                  if (this.lg.fplayer == 1) {
                     var9 = var9 + " from 1 player";
                  }

                  if (this.lg.fplayer > 1) {
                     var9 = var9 + " from " + this.lg.fplayer + " players";
                  }

                  if (this.lg.fclan == 0 && this.lg.fplayer == 0) {
                     var9 = var9 + " from your clan's discussion";
                  }
               }

               if (this.lg.nfreq != 0 && this.lg.nconf != 0) {
                  var9 = var9 + ", ";
               } else {
                  if (this.lg.nfreq != 0) {
                     var9 = var9 + " and ";
                  }

                  if (this.lg.nconf != 0) {
                     var9 = var9 + " and ";
                  }
               }
            }

            if (this.lg.nfreq != 0) {
               var9 = var9 + "" + this.lg.nfreq + " friend request";
               if (this.lg.nfreq > 1) {
                  var9 = var9 + "s";
               }

               if (this.lg.nconf != 0) {
                  var9 = var9 + " and ";
               }
            }

            if (this.lg.nconf != 0) {
               var9 = var9 + "" + this.lg.nconf + " friend confirmation";
               if (this.lg.nconf > 1) {
                  var9 = var9 + "s";
               }
            }

            var9 = var9 + "!";
            this.rd.setFont(new Font("Arial", 1, 12));
            this.ftm = this.rd.getFontMetrics();
            int var37 = 0;
            if (this.ftm.stringWidth(var9) > 280) {
               var37 = (this.ftm.stringWidth(var9) - 280) / 2;
            }

            if (var3 > 425 && var3 < 450 && var2 < 568 + var37 && var2 > 232 - var37) {
               var8 = true;
            }

            int[] var41 = new int[]{0, 9, 232 - var37, 250 - var37, 550 + var37, 568 + var37, 791, 800};
            int[] var12 = new int[]{452, 443, 443, 425, 425, 443, 443, 452};
            if (var8) {
               this.rd.setColor(this.color2k(255, 255, 255));
            } else {
               this.rd.setColor(new Color(207, 177, 110));
            }

            this.rd.fillPolygon(var41, var12, 8);
            this.rd.setColor(new Color(103, 88, 55));
            this.rd.drawPolygon(var41, var12, 8);
            if (this.flkn % 3 == 0) {
               this.rd.setColor(new Color(60, 30, 0));
            } else {
               this.rd.setColor(new Color(0, 100, 0));
            }

            this.rd.drawString(var9, 400 - this.ftm.stringWidth(var9) / 2, 442);
            if (this.flkn < 33) {
               this.flkn++;
            }
         }

         if (var8 && var4 && var1 < 2) {
            this.open = 2;
            this.upo = true;
            if (this.lg.nmsgs != 0) {
               this.tab = 2;
               if (this.lg.fplayer > 0) {
                  this.itab = 0;
               } else if (this.lg.fclan > 0) {
                  this.itab = 1;
               } else {
                  this.itab = 2;
               }

               this.litab = -1;
            }

            if (!this.lg.clanapv.equals("")) {
               this.claname = this.lg.clanapv;
               this.loadedc = false;
               this.spos5 = 0;
               this.lspos5 = 0;
               this.cfase = 3;
               this.tab = 3;
               this.ctab = 0;
            }

            if (this.lg.ncreq != 0) {
               this.claname = this.xt.clan;
               this.loadedc = false;
               this.spos5 = 0;
               this.lspos5 = 0;
               this.cfase = 3;
               this.tab = 3;
               this.ctab = 0;
            }

            if (this.lg.nfreq != 0 || this.lg.nconf != 0) {
               this.ptab = 1;
            }
         }

         if (this.xt.onviewpro) {
            this.proname = this.cd.viewname;
            this.open = 2;
            this.upo = true;
            this.tab = 1;
            this.xt.onviewpro = false;
         }
      } else if (this.flkn != 0) {
         this.flkn = 0;
      }

      if (this.open >= 2 && this.open < 452) {
         int[] var26 = new int[]{0, 0, 9, 232, 250, 550, 568, 791, 800, 800};
         int[] var35 = new int[]{
            902 - this.open,
            452 - this.open,
            443 - this.open,
            443 - this.open,
            425 - this.open,
            425 - this.open,
            443 - this.open,
            443 - this.open,
            452 - this.open,
            902 - this.open
         };
         float var39 = (this.open - 2.0F) / 450.0F;
         int var42 = (int)(255.0F * (1.0F - var39) + 216.0F * var39);
         if (var42 > 255) {
            var42 = 255;
         }

         if (var42 < 0) {
            var42 = 0;
         }

         int var52 = (int)(243.0F * (1.0F - var39) + 179.0F * var39);
         if (var52 > 255) {
            var52 = 255;
         }

         if (var52 < 0) {
            var52 = 0;
         }

         int var13 = (int)(179.0F * (1.0F - var39) + 100.0F * var39);
         if (var13 > 255) {
            var13 = 255;
         }

         if (var13 < 0) {
            var13 = 0;
         }

         this.rd.setColor(new Color(var42, var52, var13));
         this.rd.fillPolygon(var26, var35, 10);
         this.rd.drawImage(this.xt.dome, 311, 430 - this.open, null);
         if (this.upo) {
            this.open += 45;
         } else {
            this.open -= 45;
         }

         this.gs.hidefields();
         if (this.open == 452) {
            this.gs.setCursor(new Cursor(0));
            this.npo = -1;
            this.updatec = -1;
            this.domon = true;
            this.connector = new Thread(this);
            this.connector.start();
         }
      }

      if (this.open == 452) {
         if (this.xt.warning != 0 && this.xt.warning != 210) {
            this.xt.drawWarning();
            if (this.gs.cmsg.isShowing()) {
               this.gs.cmsg.hide();
               this.gs.requestFocus();
            }

            if (this.xt.warning > 220) {
               boolean var25 = false;

               try {
                  this.socket.close();
                  this.socket = null;
                  this.din.close();
                  this.din = null;
                  this.dout.close();
                  this.dout = null;
               } catch (Exception var24) {
               }
            }

            this.xt.warning++;
         } else {
            this.cur = 0;
            int var27 = (int)(255.0F * this.bgf + 191.0F * (1.0F - this.bgf));
            int var36 = (int)(176.0F * this.bgf + 184.0F * (1.0F - this.bgf));
            int var40 = (int)(67.0F * this.bgf + 124.0F * (1.0F - this.bgf));
            if (!this.bgup) {
               this.bgf += 0.02F;
               if (this.bgf > 0.9F) {
                  this.bgf = 0.9F;
                  this.bgup = true;
               }
            } else {
               this.bgf -= 0.02F;
               if (this.bgf < 0.2F) {
                  this.bgf = 0.2F;
                  this.bgup = false;
               }
            }

            this.rd.setColor(new Color(var27, var36, var40));
            this.rd.fillRect(0, 0, 800, 450);
            this.rd.setComposite(AlphaComposite.getInstance(3, 0.6F));
            this.rd.drawImage(this.xt.bgmain, this.bgx[0], 0, null);
            this.rd.drawImage(this.xt.bgmain, this.bgx[1], 0, null);
            this.rd.drawImage(this.xt.bgmain, this.bgx[2], 0, null);
            this.rd.drawImage(this.xt.bgmain, this.bgx[0], 400, null);
            this.rd.drawImage(this.xt.bgmain, this.bgx[1], 400, null);
            this.rd.drawImage(this.xt.bgmain, this.bgx[2], 400, null);
            this.rd.setComposite(AlphaComposite.getInstance(3, 0.1F));
            this.rd.drawImage(this.xt.bggo, 0, 0, null);
            this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));

            for (int var43 = 0; var43 < 3; var43++) {
               this.bgx[var43] = this.bgx[var43] - 5;
               if (this.bgx[var43] <= -670) {
                  this.bgx[var43] = 1340;
               }
            }

            if (this.drawbutton(this.xt.exit, 755, 17, var2, var3, var4) || var1 >= 2) {
               this.open = 450;
               this.upo = false;
               this.domon = false;
               this.onexit();
            }

            this.sdist = 0;
            this.scro = 0;
            if (!this.domon) {
               if (this.open == 452) {
                  this.rd.setColor(this.color2k(230, 230, 230));
                  this.rd.fillRoundRect(240, 170, 511, 90, 20, 20);
                  this.rd.setColor(new Color(0, 0, 0));
                  this.rd.drawRoundRect(240, 170, 511, 90, 20, 20);
                  this.rd.setColor(new Color(0, 0, 0));
                  this.rd.setFont(new Font("Arial", 1, 13));
                  this.ftm = this.rd.getFontMetrics();
                  this.rd
                     .drawString(
                        "Failed to connect to server at this time, please exit and try again later.",
                        495 - this.ftm.stringWidth("Failed to connect to server at this time, please exit and try again later.") / 2,
                        200
                     );
                  if (this.stringbutton(this.rd, "  Exit  ", 495, 230, 1, var2, var3, var4, 0, 0)) {
                     this.open = 450;
                     this.upo = false;
                     this.domon = false;
                  }
               }
            } else {
               if (this.tab == 0) {
                  this.rd.setColor(this.color2k(230, 230, 230));
                  this.rd.fillRoundRect(197, 40, 597, 404, 20, 20);
                  this.rd.setColor(new Color(0, 0, 0));
                  this.rd.drawRoundRect(197, 40, 597, 404, 20, 20);
                  if (this.updatec == -1) {
                     this.sdist = 0;
                     this.scro = 0;
                     this.spos2 = 275;
                     this.rd.setColor(new Color(0, 0, 0));
                     this.rd.setFont(new Font("Tahoma", 1, 11));
                     this.ftm = this.rd.getFontMetrics();
                     this.rd.drawString("Loading chat...", 498 - this.ftm.stringWidth("Loading chat...") / 2, 220);
                  } else {
                     String[] var44 = new String[42];
                     String[] var53 = new String[42];
                     String[] var67 = new String[42];
                     boolean[] var14 = new boolean[42];

                     for (int var15 = 0; var15 < 42; var15++) {
                        var44[var15] = "";
                        var53[var15] = "";
                        var67[var15] = "";
                        var14[var15] = false;
                     }

                     int var94 = 0;
                     this.rd.setFont(new Font("Tahoma", 0, 11));
                     this.ftm = this.rd.getFontMetrics();

                     for (int var16 = 0; var16 < 21; var16++) {
                        var44[var94] = "";
                        var53[var94] = this.cnames[var16];
                        var67[var94] = this.ctime[var16];
                        int var17 = 0;
                        int var18 = 0;
                        int var19 = 0;
                        int var20 = 0;

                        for (int var21 = 0; var17 < this.sentn[var16].length(); var17++) {
                           String var22 = "" + this.sentn[var16].charAt(var17);
                           if (var22.equals(" ")) {
                              var18 = var19;
                              var20 = var17;
                              var21++;
                           } else {
                              var21 = 0;
                           }

                           if (var21 <= 1) {
                              var44[var94] = var44[var94] + var22;
                              var19++;
                              if (this.ftm.stringWidth(var44[var94]) > 469) {
                                 if (var18 == 0) {
                                    var44[var94] = "";
                                    var19 = 0;
                                 } else {
                                    var44[var94] = var44[var94].substring(0, var18);
                                    if (var94 == 41) {
                                       for (int var23 = 0; var23 < 41; var23++) {
                                          var44[var23] = var44[var23 + 1];
                                          var53[var23] = var53[var23 + 1];
                                          var67[var23] = var67[var23 + 1];
                                          var14[var23] = var14[var23 + 1];
                                       }

                                       var44[var94] = "";
                                       var14[var94] = true;
                                    } else {
                                       var53[++var94] = this.cnames[var16];
                                       var67[var94] = this.ctime[var16];
                                    }

                                    var17 = var20;
                                    var19 = 0;
                                    var18 = 0;
                                 }
                              }
                           }
                        }

                        if (var94 == 41 && var16 != 20) {
                           for (int var126 = 0; var126 < 41; var126++) {
                              var44[var126] = var44[var126 + 1];
                              var53[var126] = var53[var126 + 1];
                              var67[var126] = var67[var126 + 1];
                              var14[var126] = var14[var126 + 1];
                           }
                        } else {
                           var94++;
                        }
                     }

                     String var108 = "";
                     int var119 = var94;

                     for (int var122 = 0; var122 < var94; var122++) {
                        if (!var108.equals(var53[var122])) {
                           if (var122 != 0) {
                              var119++;
                           }

                           var108 = var53[var122];
                        }
                     }

                     this.sdist = (int)((var119 - 21.5F) * 15.0F);
                     if (this.sdist < 0) {
                        this.sdist = 0;
                     }

                     this.scro = (int)(this.spos2 / 275.0F * this.sdist);
                     var119 = 0;
                     var108 = "";

                     for (int var123 = 0; var123 <= var94; var123++) {
                        if (var123 != var94) {
                           if (!var108.equals(var53[var123])) {
                              if (var123 != 0) {
                                 if (var119 * 15 - this.scro > -20 && var119 * 15 - this.scro < 345) {
                                    this.rd.setFont(new Font("Tahoma", 0, 11));
                                    this.rd.setColor(this.color2k(125, 125, 125));
                                    this.rd.drawString(var67[var123 - 1], 297, 82 + var119 * 15 - this.scro);
                                 }

                                 var119++;
                              }

                              if (var119 * 15 - this.scro > -20 && var119 * 15 - this.scro < 345) {
                                 this.rd.setFont(new Font("Tahoma", 1, 11));
                                 this.ftm = this.rd.getFontMetrics();
                                 this.rd.setColor(new Color(0, 0, 0));
                                 this.rd.drawString(var53[var123] + ":", 292 - this.ftm.stringWidth(var53[var123] + ":"), 82 + var119 * 15 - this.scro);
                              }

                              var108 = var53[var123];
                           }

                           if (var14[var123] && var123 == 0 && var44[var123].indexOf(" ") != -1) {
                              var44[var123] = "..." + var44[var123].substring(var44[var123].indexOf(" "), var44[var123].length()) + "";
                           }

                           if (var119 * 15 - this.scro > -20 && var119 * 15 - this.scro < 345) {
                              this.rd.setFont(new Font("Tahoma", 0, 11));
                              this.rd.setColor(new Color(0, 0, 0));
                              this.rd.drawString(var44[var123], 297, 82 + var119 * 15 - this.scro);
                           }

                           var119++;
                        } else if (var119 * 15 - this.scro > -20 && var119 * 15 - this.scro < 345) {
                           this.rd.setFont(new Font("Tahoma", 0, 11));
                           this.rd.setColor(this.color2k(125, 125, 125));
                           this.rd.drawString(var67[var123 - 1], 297, 82 + var119 * 15 - this.scro);
                        }
                     }
                  }

                  this.rd.setColor(this.color2k(205, 205, 205));
                  this.rd.fillRect(207, 46, 582, 25);
                  this.rd.setFont(new Font("Arial", 1, 12));
                  this.rd.setColor(this.color2k(40, 40, 40));
                  this.rd.drawString("Global Chat", 213, 62);
                  this.rd.setColor(this.color2k(150, 150, 150));
                  this.rd.drawLine(207, 68, 770, 68);
                  this.rd.setColor(this.color2k(205, 205, 205));
                  this.rd.fillRect(207, 411, 582, 28);
                  this.rd.setColor(this.color2k(150, 150, 150));
                  this.rd.drawLine(207, 413, 770, 413);
                  this.rd.setColor(this.color2k(205, 205, 205));
                  this.rd.fillRect(772, 88, 17, 306);
                  this.rd.setColor(this.color2k(205, 205, 205));
                  this.rd.fillRect(203, 46, 4, 393);
                  var6 = true;
                  if ((this.stringbutton(this.rd, "Send Message", 731, 430, 3, var2, var3, var4, 0, 0) || var5.enter)
                     && !this.gs.cmsg.getText().equals("Type here...")
                     && !this.gs.cmsg.getText().equals("")
                     && this.xt.acexp != -3) {
                     String var45 = this.gs.cmsg.getText().replace('|', ':');
                     if (var45.toLowerCase().indexOf(this.gs.tpass.getText().toLowerCase()) != -1) {
                        var45 = " ";
                     }

                     if (!this.xt.msgcheck(var45) && this.updatec > -12) {
                        for (int var54 = 0; var54 < 20; var54++) {
                           this.sentn[var54] = this.sentn[var54 + 1];
                           this.cnames[var54] = this.cnames[var54 + 1];
                           this.ctime[var54] = this.ctime[var54 + 1];
                        }

                        this.sentn[20] = var45;
                        this.cnames[20] = this.xt.nickname;
                        this.ctime[20] = "- just now";
                        if (this.updatec > -11) {
                           this.updatec = -11;
                        } else {
                           this.updatec--;
                        }

                        this.spos2 = 275;
                     } else {
                        this.xt.warning++;
                     }

                     this.gs.cmsg.setText("");
                     var5.enter = false;
                  }

                  if (this.mscro2 != 831 && this.sdist != 0) {
                     this.rd.setColor(this.color2k(220, 220, 220));
                     this.rd.fill3DRect(772, 71, 17, 17, true);
                  } else {
                     if (this.sdist == 0) {
                        this.rd.setColor(this.color2k(205, 205, 205));
                     } else {
                        this.rd.setColor(this.color2k(215, 215, 215));
                     }

                     this.rd.fillRect(772, 71, 17, 17);
                  }

                  if (this.sdist != 0) {
                     this.rd.drawImage(this.xt.asu, 777, 77, null);
                  }

                  if (this.mscro2 != 832 && this.sdist != 0) {
                     this.rd.setColor(this.color2k(220, 220, 220));
                     this.rd.fill3DRect(772, 394, 17, 17, true);
                  } else {
                     if (this.sdist == 0) {
                        this.rd.setColor(this.color2k(205, 205, 205));
                     } else {
                        this.rd.setColor(this.color2k(215, 215, 215));
                     }

                     this.rd.fillRect(772, 394, 17, 17);
                  }

                  if (this.sdist != 0) {
                     this.rd.drawImage(this.xt.asd, 777, 401, null);
                  }

                  if (this.sdist != 0) {
                     if (this.lspos2 != this.spos2) {
                        this.rd.setColor(this.color2k(215, 215, 215));
                        this.rd.fillRect(772, 88 + this.spos2, 17, 31);
                     } else {
                        if (this.mscro2 == 831) {
                           this.rd.setColor(this.color2k(215, 215, 215));
                        }

                        this.rd.fill3DRect(772, 88 + this.spos2, 17, 31, true);
                     }

                     this.rd.setColor(this.color2k(150, 150, 150));
                     this.rd.drawLine(777, 101 + this.spos2, 783, 101 + this.spos2);
                     this.rd.drawLine(777, 103 + this.spos2, 783, 103 + this.spos2);
                     this.rd.drawLine(777, 105 + this.spos2, 783, 105 + this.spos2);
                     if (this.mscro2 > 800 && this.lspos2 != this.spos2) {
                        this.lspos2 = this.spos2;
                     }

                     if (var4) {
                        if (this.mscro2 == 825 && var2 > 772 && var2 < 789 && var3 > 88 + this.spos2 && var3 < this.spos2 + 119) {
                           this.mscro2 = var3 - this.spos2;
                        }

                        if (this.mscro2 == 825 && var2 > 770 && var2 < 791 && var3 > 69 && var3 < 90) {
                           this.mscro2 = 831;
                        }

                        if (this.mscro2 == 825 && var2 > 770 && var2 < 791 && var3 > 392 && var3 < 413) {
                           this.mscro2 = 832;
                        }

                        if (this.mscro2 == 825 && var2 > 772 && var2 < 789 && var3 > 88 && var3 < 394) {
                           this.mscro2 = 103;
                           this.spos2 = var3 - this.mscro2;
                        }

                        int var46 = 2670 / this.sdist;
                        if (var46 < 1) {
                           var46 = 1;
                        }

                        if (this.mscro2 == 831) {
                           this.spos2 -= var46;
                           if (this.spos2 > 275) {
                              this.spos2 = 275;
                           }

                           if (this.spos2 < 0) {
                              this.spos2 = 0;
                           }

                           this.lspos2 = this.spos2;
                        }

                        if (this.mscro2 == 832) {
                           this.spos2 += var46;
                           if (this.spos2 > 275) {
                              this.spos2 = 275;
                           }

                           if (this.spos2 < 0) {
                              this.spos2 = 0;
                           }

                           this.lspos2 = this.spos2;
                        }

                        if (this.mscro2 < 800) {
                           this.spos2 = var3 - this.mscro2;
                           if (this.spos2 > 275) {
                              this.spos2 = 275;
                           }

                           if (this.spos2 < 0) {
                              this.spos2 = 0;
                           }
                        }

                        if (this.mscro2 == 825) {
                           this.mscro2 = 925;
                        }
                     } else if (this.mscro2 != 825) {
                        this.mscro2 = 825;
                     }
                  }
               }

               if (this.tab == 1) {
                  this.rd.setComposite(AlphaComposite.getInstance(3, 0.4F));
                  this.rd.setColor(new Color(255, 255, 255));
                  this.rd.fillRoundRect(207, 45, 577, 394, 20, 20);
                  this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
                  this.rd.setColor(new Color(0, 0, 0));
                  this.rd.drawRoundRect(207, 45, 577, 394, 20, 20);
                  if (!this.flg) {
                     this.flk += 5;
                  } else {
                     this.flk -= 5;
                  }

                  if (this.flk >= 100) {
                     this.flk = 100;
                     this.flg = true;
                  }

                  if (this.flk <= 60) {
                     this.flk = 60;
                     this.flg = false;
                  }

                  this.rd.setFont(new Font("Arial", 1, 13));
                  this.ftm = this.rd.getFontMetrics();
                  this.rd.setColor(new Color(0, 0, 0));
                  this.rd.setComposite(AlphaComposite.getInstance(3, this.flk / 100.0F));
                  boolean var47 = false;
                  if (this.protab == 2) {
                     if (this.proname.equals(this.xt.nickname)) {
                        this.rd.drawString("Your Stages", 227, 67);
                        var47 = true;
                     } else {
                        this.rd.drawString("" + this.proname + "'s", 227, 67);
                        this.rd.drawString("Stages", 227, 84);
                     }

                     this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
                     this.gs.proitem.move(496 - this.gs.proitem.getWidth() / 2, 60);
                     this.gs.proitem.show = true;
                     if (this.stringbutton(this.rd, "< Back to Profile", 715, 76, 1, var2, var3, var4, 0, 0)) {
                        this.protab = 0;
                        this.gs.proitem.show = false;
                        this.addstage = 0;
                     }

                     if (this.gs.proitem.sel != 0) {
                        if (this.gs.proitem.getSelectedItem().equals(this.loadpstage)) {
                           if (this.loadedpstage) {
                              this.m.trk = 4;
                              this.m.ih = -10;
                              this.m.iw = -10;
                              this.m.h = 320;
                              this.m.w = 580;
                              this.m.cx = 280;
                              this.m.cy = 150;
                              this.m.aroundtrack(this.cp);
                              this.rdo.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
                              this.m.d(this.rdo);
                              int var55 = 0;
                              int[] var68 = new int[1000];

                              for (int var79 = 0; var79 < this.gs.nob; var79++) {
                                 if (this.co[var79].dist != 0) {
                                    var68[var55] = var79;
                                    var55++;
                                 } else {
                                    this.co[var79].d(this.rdo);
                                 }
                              }

                              int[] var80 = new int[var55];

                              for (int var95 = 0; var95 < var55; var95++) {
                                 var80[var95] = 0;
                              }

                              for (int var96 = 0; var96 < var55; var96++) {
                                 for (int var110 = var96 + 1; var110 < var55; var110++) {
                                    if (this.co[var68[var96]].dist != this.co[var68[var110]].dist) {
                                       if (this.co[var68[var96]].dist < this.co[var68[var110]].dist) {
                                          var80[var96]++;
                                       } else {
                                          var80[var110]++;
                                       }
                                    } else if (var110 > var96) {
                                       var80[var96]++;
                                    } else {
                                       var80[var110]++;
                                    }
                                 }
                              }

                              for (int var97 = 0; var97 < var55; var97++) {
                                 for (int var111 = 0; var111 < var55; var111++) {
                                    if (var80[var111] == var97) {
                                       this.co[var68[var111]].d(this.rdo);
                                    }
                                 }
                              }

                              this.rdo.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                              this.m.trk = 0;
                              this.m.h = 450;
                              this.m.w = 800;
                              this.m.cx = 400;
                              this.m.cy = 225;
                              this.rdo.setComposite(AlphaComposite.getInstance(3, 0.5F));
                              this.rdo.setColor(new Color(255, 255, 255));
                              this.rdo.fillRoundRect(9, 44, 136, 39, 20, 20);
                              this.rdo.setComposite(AlphaComposite.getInstance(3, 1.0F));
                              this.rdo.setFont(new Font("Arial", 1, 12));
                              this.ftm = this.rdo.getFontMetrics();
                              this.rdo.setColor(new Color(0, 0, 0));
                              this.rdo.drawString("Created/Published by", 17, 59);
                              int var98 = 17 + this.ftm.stringWidth("Created/Published by") / 2 - this.ftm.stringWidth(this.cp.maker) / 2;
                              int var112 = var98 + this.ftm.stringWidth(this.cp.maker);
                              this.rdo.drawString(this.cp.maker, var98, 74);
                              this.rdo.drawLine(var98, 76, var112, 76);
                              if (var2 > var98 + 216 && var2 < var112 + 216 && var3 > 154 && var3 < 168) {
                                 this.cur = 12;
                                 if (var4) {
                                    this.tab = 1;
                                    if (!this.proname.equals(this.cp.maker)) {
                                       this.proname = this.cp.maker;
                                       this.loadedp = false;
                                       this.onexitpro();
                                    }
                                 }
                              }

                              if (this.gs.proitem.getSelectedIndex() != this.gs.proitem.no - 1
                                 && this.stringbutton(this.rdo, " Next > ", 510, 200, -3, var2, var3, var4 && !this.gs.openm, 216, 92)) {
                                 this.gs.proitem.sel++;
                              }

                              if (this.gs.proitem.getSelectedIndex() != 1
                                 && this.stringbutton(this.rdo, " < Prev ", 50, 200, -3, var2, var3, var4 && !this.gs.openm, 216, 92)) {
                                 this.gs.proitem.sel--;
                              }

                              if (this.cp.pubt > 0) {
                                 this.rd.setFont(new Font("Arial", 1, 12));
                                 this.ftm = this.rd.getFontMetrics();
                                 this.rd.setColor(new Color(0, 0, 0));
                                 if (this.addstage == 2) {
                                    this.rd.drawString("Adding Stage...", 496 - this.ftm.stringWidth("Adding Stage...") / 2, 419);
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
                                    this.rd
                                       .drawString(
                                          "[" + this.cd.onstage + "] has been added to your stages!",
                                          496 - this.ftm.stringWidth("[" + this.cd.onstage + "] has been added to your stages!") / 2,
                                          419
                                       );
                                 }

                                 if (this.addstage == 4) {
                                    this.rd.drawString("You already have this stage.", 496 - this.ftm.stringWidth("You already have this stage.") / 2, 419);
                                 }

                                 if (this.addstage == 5) {
                                    this.rd
                                       .drawString(
                                          "Cannot add more then 20 stages to your account!",
                                          496 - this.ftm.stringWidth("Cannot add more then 20 stages to your account!") / 2,
                                          419
                                       );
                                 }

                                 if (this.addstage == 6) {
                                    this.rd
                                       .drawString(
                                          "Failed to add stage!  Unknown error, please try again later.",
                                          496 - this.ftm.stringWidth("Failed to add stage!  Unknown error, please try again later.") / 2,
                                          419
                                       );
                                 }

                                 if (this.addstage == 1) {
                                    String var121 = "Upgrade to a full account to add custom stages!";
                                    int var124 = 496 - this.ftm.stringWidth(var121) / 2;
                                    int var125 = var124 + this.ftm.stringWidth(var121);
                                    this.rd.drawString(var121, var124, 419);
                                    if (this.waitlink != -1) {
                                       this.rd.drawLine(var124, 435, var125, 435);
                                    }

                                    if (var2 > var124 && var2 < var125 && var3 > 421 && var3 < 435) {
                                       if (this.waitlink != -1) {
                                          this.cur = 12;
                                       }

                                       if (var4 && this.waitlink == 0) {
                                          this.gs.editlink(this.xt.nickname, true);
                                          this.waitlink = -1;
                                       }
                                    }

                                    if (this.waitlink > 0) {
                                       this.waitlink--;
                                    }
                                 }

                                 if (this.addstage == 0
                                    && this.xt.drawcarb(true, null, " Add to My Stages ", 437, 401, var2, var3, var4 && this.blocknote == 0)) {
                                    if (this.xt.logged) {
                                       this.cd.onstage = this.loadpstage;
                                       this.cd.staction = 2;
                                       this.cd.sparkstageaction();
                                       this.addstage = 2;
                                    } else {
                                       this.addstage = 1;
                                       this.waitlink = 20;
                                    }
                                 }
                              } else {
                                 this.rd.setFont(new Font("Arial", 1, 12));
                                 this.ftm = this.rd.getFontMetrics();
                                 this.rd.setColor(new Color(0, 0, 0));
                                 this.rd.drawString("Private Stage", 496 - this.ftm.stringWidth("Private Stage") / 2, 419);
                              }
                           } else {
                              this.rdo.setColor(new Color(206, 171, 98));
                              this.rdo.fillRect(0, 0, 560, 300);
                              this.rdo.setColor(new Color(0, 0, 0));
                              this.rdo.setFont(new Font("Arial", 1, 12));
                              this.ftm = this.rdo.getFontMetrics();
                              this.rdo
                                 .drawString(
                                    "Failed to load stage, try again later or try another stage...",
                                    280 - this.ftm.stringWidth("Failed to load stage, try again later or try another stage...") / 2,
                                    140
                                 );
                           }
                        } else {
                           this.rdo.setColor(new Color(206, 171, 98));
                           this.rdo.fillRect(0, 0, 560, 300);
                           this.rdo.setColor(new Color(0, 0, 0));
                           this.rdo.setFont(new Font("Arial", 1, 12));
                           this.ftm = this.rdo.getFontMetrics();
                           this.rdo.drawString("Loading stage, please wait...", 280 - this.ftm.stringWidth("Loading stage, please wait...") / 2, 140);
                        }
                     } else {
                        this.rdo.setColor(new Color(206, 171, 98));
                        this.rdo.fillRect(0, 0, 560, 300);
                     }

                     this.rd.drawImage(this.gImage, 216, 92, null);
                  }

                  if (this.protab == 0) {
                     if (this.proname.equals(this.xt.nickname)) {
                        this.rd.drawString("Your Profile", 232, 67);
                        var47 = true;
                     } else {
                        this.rd.drawString("" + this.proname + "'s Profile", 232, 67);
                     }

                     this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
                     if (this.loadedp) {
                        if (!var47 && this.stringbutton(this.rd, "   My Profile   ", 715, 73, 1, var2, var3, var4, 0, 0)) {
                           this.proname = this.xt.nickname;
                           this.loadedp = false;
                           this.onexitpro();
                        }

                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.setFont(new Font("Arial", 0, 11));
                        this.ftm = this.rd.getFontMetrics();
                        if (this.logol) {
                           this.drawl(this.rd, this.proname, 236, 101, true);
                        } else {
                           this.rd.drawString("No logo available", 296 - this.ftm.stringWidth("No logo available") / 2, 121);
                        }

                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rd.getFontMetrics();
                        String var56 = "Logo";
                        if (var2 > 232 && var2 < 359 && var3 > 84 && var3 < 134 && this.edit == 0 && var47) {
                           var56 = "Edit Logo";
                           this.rd.drawLine(238, 98, 238 + this.ftm.stringWidth(var56), 98);
                           if (var2 > 238 && var2 < 238 + this.ftm.stringWidth(var56) && var3 > 85 && var3 < 100) {
                              this.cur = 12;
                              if (var4) {
                                 if (this.xt.logged) {
                                    this.edit = 1;
                                    this.msg = "Edit your Nickname's logo";
                                    this.flko = 0;
                                 } else {
                                    this.edit = 5;
                                 }
                              }
                           }
                        }

                        this.rd.drawString(var56, 238, 97);
                        this.rd.drawLine(232, 84, 232, 134);
                        this.rd.drawLine(232, 84, 238 + this.ftm.stringWidth(var56) + 2, 84);
                        this.rd.drawLine(238 + this.ftm.stringWidth(var56) + 2, 84, 238 + this.ftm.stringWidth(var56) + 15, 97);
                        this.rd.drawLine(238 + this.ftm.stringWidth(var56) + 15, 97, 359, 97);
                        this.rd.drawLine(359, 97, 359, 134);
                        this.rd.drawLine(232, 134, 359, 134);
                        if (var47 && !this.xt.clan.equals(this.proclan)) {
                           this.proclan = this.xt.clan;
                        }

                        if (!this.proclan.equals("")) {
                           if (!this.drawl(this.rd, "#" + this.proclan + "#", 406, 101, true)) {
                              this.rd.setFont(new Font("Arial", 1, 13));
                              this.ftm = this.rd.getFontMetrics();
                              this.rd.drawString("" + this.proclan + "", 581 - this.ftm.stringWidth("" + this.proclan + "") / 2, 121);
                           }
                        } else {
                           this.rd.setFont(new Font("Arial", 0, 11));
                           this.ftm = this.rd.getFontMetrics();
                           if (var47) {
                              this.rd.drawString("You have not joined a clan yet!", 416, 121);
                              if (this.stringbutton(this.rd, "   Find a clan to join   ", 663, 121, 1, var2, var3, var4, 0, 0)) {
                                 this.tab = 3;
                                 this.cfase = 2;
                                 this.em = 1;
                                 this.msg = "Clan Search";
                                 this.smsg = "Listing clans with recent activity...";
                                 this.nclns = 0;
                                 this.spos5 = 0;
                                 this.lspos5 = 0;
                                 this.flko = 0;
                              }
                           } else if (this.xt.clan.equals("")) {
                              this.rd.drawString("Has not joined a clan yet", 581 - this.ftm.stringWidth("Has not joined a clan yet") / 2, 121);
                           } else {
                              this.rd.drawString("Has not joined a clan yet", 430, 121);
                              if (this.stringbutton(this.rd, " Invite to join your clan ", 657, 121, 1, var2, var3, var4, 0, 0)) {
                                 this.tab = 2;
                                 this.itab = 0;
                                 this.litab = -1;
                                 this.openc = 10;
                                 if (!this.opname.equals(this.proname)) {
                                    this.opname = this.proname;
                                    this.lastsub = "";
                                    this.readmsg = 1;
                                 }

                                 this.itemsel = 3;
                                 this.forcsel = true;
                              }
                           }
                        }

                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rd.getFontMetrics();
                        var56 = "Clan";
                        if (var2 > 402 && var2 < 759 && var3 > 84 && var3 < 134 && !this.proclan.equals("") && this.edit == 0) {
                           var56 = "Clan :  " + this.proclan + "";
                           this.rd.drawLine(408, 98, 408 + this.ftm.stringWidth(var56), 98);
                           if (var2 > 408 && var2 < 408 + this.ftm.stringWidth(var56) && var3 > 85 && var3 < 100
                              || var2 > 406 && var2 < 756 && var3 > 101 && var3 < 131) {
                              this.cur = 12;
                              if (var4) {
                                 if (!this.claname.equals(this.proclan)) {
                                    this.claname = this.proclan;
                                    this.loadedc = false;
                                 }

                                 this.spos5 = 0;
                                 this.lspos5 = 0;
                                 this.cfase = 3;
                                 this.tab = 3;
                                 this.ctab = 0;
                              }
                           }
                        }

                        this.rd.drawString(var56, 408, 97);
                        this.rd.drawLine(402, 84, 402, 134);
                        this.rd.drawLine(402, 84, 408 + this.ftm.stringWidth(var56) + 2, 84);
                        this.rd.drawLine(408 + this.ftm.stringWidth(var56) + 2, 84, 408 + this.ftm.stringWidth(var56) + 15, 97);
                        this.rd.drawLine(408 + this.ftm.stringWidth(var56) + 15, 97, 759, 97);
                        this.rd.drawLine(759, 97, 759, 134);
                        this.rd.drawLine(402, 134, 759, 134);
                        this.rd.setFont(new Font("Arial", 0, 11));
                        this.ftm = this.rd.getFontMetrics();
                        if (this.avatarl) {
                           this.rd.drawImage(this.avatar, 236, 161, null);
                        } else {
                           this.rd.drawString("No avatar available", 336 - this.ftm.stringWidth("No avatar available") / 2, 255);
                        }

                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rd.getFontMetrics();
                        var56 = "Avatar";
                        if (var2 > 232 && var2 < 439 && var3 > 144 && var3 < 364 && this.edit == 0 && var47) {
                           var56 = "Edit Avatar";
                           this.rd.drawLine(238, 158, 238 + this.ftm.stringWidth(var56), 158);
                           if (var2 > 238 && var2 < 238 + this.ftm.stringWidth(var56) && var3 > 145 && var3 < 160) {
                              this.cur = 12;
                              if (var4) {
                                 if (this.xt.logged) {
                                    this.edit = 2;
                                    this.msg = "Edit your proflie avatar";
                                    this.flko = 0;
                                 } else {
                                    this.edit = 5;
                                 }
                              }
                           }
                        }

                        this.rd.drawString(var56, 238, 157);
                        this.rd.drawLine(232, 144, 232, 364);
                        this.rd.drawLine(232, 144, 238 + this.ftm.stringWidth(var56) + 2, 144);
                        this.rd.drawLine(238 + this.ftm.stringWidth(var56) + 2, 144, 238 + this.ftm.stringWidth(var56) + 15, 157);
                        this.rd.drawLine(238 + this.ftm.stringWidth(var56) + 15, 157, 439, 157);
                        this.rd.drawLine(439, 157, 439, 364);
                        this.rd.drawLine(232, 364, 439, 364);
                        var56 = "About";
                        if (var2 > 459 && var2 < 759 && var3 > 144 && var3 < 364 && this.edit == 0 && var47) {
                           var56 = "Edit About";
                           this.rd.drawLine(465, 158, 465 + this.ftm.stringWidth(var56), 158);
                           if (var2 > 465 && var2 < 465 + this.ftm.stringWidth(var56) && var3 > 145 && var3 < 160) {
                              this.cur = 12;
                              if (var4) {
                                 if (this.xt.logged) {
                                    this.edit = 3;
                                    this.msg = "";
                                    this.flko = 0;
                                    this.sentchange = 0;
                                    this.badlang = false;
                                 } else {
                                    this.edit = 5;
                                 }
                              }
                           }
                        }

                        this.rd.drawString(var56, 465, 157);
                        this.rd.drawLine(459, 144, 459, 364);
                        this.rd.drawLine(459, 144, 465 + this.ftm.stringWidth(var56) + 2, 144);
                        this.rd.drawLine(465 + this.ftm.stringWidth(var56) + 2, 144, 465 + this.ftm.stringWidth(var56) + 15, 157);
                        this.rd.drawLine(465 + this.ftm.stringWidth(var56) + 15, 157, 759, 157);
                        this.rd.drawLine(759, 157, 759, 364);
                        this.rd.drawLine(459, 364, 759, 364);
                        if (this.nab != 0) {
                           this.rd.setFont(new Font("Tahoma", 1, 11));
                           short var69 = 200;
                           if (this.nab == 2) {
                              var69 = 192;
                           }

                           if (this.nab == 3) {
                              var69 = 185;
                           }

                           for (int var81 = 0; var81 < this.nab; var81++) {
                              this.rd.drawString(this.aboutxt[var81], 469, var69 + var81 * 15);
                           }
                        } else {
                           this.rd.setFont(new Font("Arial", 0, 11));
                           this.ftm = this.rd.getFontMetrics();
                           this.rd.drawString("No description available", 609 - this.ftm.stringWidth("No description available") / 2, 200);
                        }

                        this.rd.drawLine(489, 230, 729, 230);
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("Racing", 532 - this.ftm.stringWidth("Racing") / 2, 253);
                        this.rd.drawString("VS", 532 - this.ftm.stringWidth("VS") / 2, 270);
                        this.rd.drawString("Wasting", 532 - this.ftm.stringWidth("Wasting") / 2, 287);
                        float var70 = this.racing;
                        float var82 = this.wasting;
                        if (this.racing > 10 && this.racing > this.wasting) {
                           var70 = 10.0F;
                           var82 = this.wasting / (this.racing / 10.0F);
                        }

                        if (this.wasting > 10 && this.wasting >= this.racing) {
                           var82 = 10.0F;
                           var70 = this.racing / (this.wasting / 10.0F);
                        }

                        var70 *= 14.0F;
                        var82 *= 14.0F;

                        for (int var99 = 0; var99 < 5; var99++) {
                           if (var70 != 0.0F) {
                              this.rd.setColor(new Color(0, var99 * 50, 255));
                              this.rd.drawLine(569, 245 + var99, (int)(569.0F + var70), 245 + var99);
                              this.rd.drawLine(569, 254 - var99, (int)(569.0F + var70), 254 - var99);
                           }

                           if (var82 != 0.0F) {
                              this.rd.setColor(new Color(255, var99 * 50, 0));
                              this.rd.drawLine(569, 279 + var99, (int)(569.0F + var82), 279 + var99);
                              this.rd.drawLine(569, 288 - var99, (int)(569.0F + var82), 288 - var99);
                           }
                        }

                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawRect(569, 244, 140, 11);
                        this.rd.drawRect(569, 278, 140, 11);
                        this.rd.drawLine(489, 304, 729, 304);
                        if (!this.themesong.equals("") && this.trackvol != 0) {
                           if (this.playt == 1) {
                              this.rd
                                 .drawString("Loading theme song, please wait...", 609 - this.ftm.stringWidth("Loading theme song, please wait...") / 2, 340);
                           }

                           if (this.playt == 0 && this.stringbutton(this.rd, " Play Theme Song ", 609, 340, 1, var2, var3, var4, 0, 0) && this.edit == 0) {
                              this.playt = 1;
                           }

                           if (this.playt == 2) {
                              this.rd.drawString("Theme song playing...", 609 - this.ftm.stringWidth("Theme song playing...") / 2, 325);
                              if (this.stringbutton(this.rd, " Stop ", 609, 350, 2, var2, var3, var4, 0, 0)) {
                                 this.xt.strack.unload();
                                 this.playt = 0;
                              }
                           }
                        } else {
                           this.rd.setFont(new Font("Arial", 0, 11));
                           this.ftm = this.rd.getFontMetrics();
                           this.rd.drawString("No theme song available", 609 - this.ftm.stringWidth("No theme song available") / 2, 340);
                        }

                        if (!var47) {
                           if (this.sfreq != 0) {
                              this.rd.setColor(new Color(236, 215, 140));
                              this.rd.fillRect(232, 378, 527, 50);
                              this.rd.setColor(new Color(0, 0, 0));
                              this.rd.drawRect(232, 378, 527, 50);
                              this.rd.setFont(new Font("Arial", 1, 12));
                              this.ftm = this.rd.getFontMetrics();
                              if (this.sfreq == 1) {
                                 this.rd
                                    .drawString(
                                       "Sending a friend request to " + this.proname + ", please wait...",
                                       495 - this.ftm.stringWidth("Sending a friend request to " + this.proname + ", please wait...") / 2,
                                       408
                                    );
                              }

                              if (this.sfreq == 2) {
                                 this.rd
                                    .drawString(
                                       "Friend request sent, waiting for " + this.proname + "'s approval.",
                                       495 - this.ftm.stringWidth("Friend request sent, waiting for " + this.proname + "'s approval.") / 2,
                                       408
                                    );
                                 if (this.stringbutton(this.rd, "  OK  ", 690, 408, 1, var2, var3, var4, 0, 0)) {
                                    this.sfreq = 0;
                                 }
                              }

                              if (this.sfreq == 3) {
                                 this.rd
                                    .drawString(
                                       "Failed to send friend request, please try again later.",
                                       495 - this.ftm.stringWidth("Failed to send friend request, please try again later.") / 2,
                                       408
                                    );
                                 if (this.stringbutton(this.rd, "  OK  ", 690, 408, 1, var2, var3, var4, 0, 0)) {
                                    this.sfreq = 0;
                                 }
                              }

                              if (this.sfreq == 4) {
                                 this.rd
                                    .drawString(
                                       "Removing " + this.proname + " from firends, please wait...",
                                       495 - this.ftm.stringWidth("Removing " + this.proname + " from firends, please wait...") / 2,
                                       408
                                    );
                              }

                              if (this.sfreq == 5) {
                                 this.rd
                                    .drawString(
                                       "You are no longer friends with " + this.proname + ".",
                                       495 - this.ftm.stringWidth("You are no longer friends with " + this.proname + ".") / 2,
                                       408
                                    );
                                 if (this.stringbutton(this.rd, "  OK  ", 690, 408, 1, var2, var3, var4, 0, 0)) {
                                    this.sfreq = 0;
                                 }
                              }

                              if (this.sfreq == 6) {
                                 this.rd
                                    .drawString(
                                       "Failed to remove friend, please try again later.",
                                       495 - this.ftm.stringWidth("Failed to remove friend, please try again later.") / 2,
                                       408
                                    );
                                 if (this.stringbutton(this.rd, "  OK  ", 690, 408, 1, var2, var3, var4, 0, 0)) {
                                    this.sfreq = 0;
                                 }
                              }
                           } else {
                              this.rd.drawRect(232, 378, 527, 50);
                              boolean var100 = false;

                              for (int var113 = 0; var113 < this.npf; var113++) {
                                 if (this.proname.toLowerCase().equals(this.fname[var113].toLowerCase())) {
                                    var100 = true;
                                    break;
                                 }
                              }

                              if (var100) {
                                 if (this.stringbutton(this.rd, "    Un-friend    ", 313, 408, 1, var2, var3, var4, 0, 0)) {
                                    this.sfreq = 4;
                                 }
                              } else if (this.stringbutton(this.rd, "   Add Friend   ", 313, 408, 1, var2, var3, var4, 0, 0)) {
                                 this.sfreq = 1;
                              }

                              if (this.stringbutton(this.rd, "   Send Message   ", 436, 408, 1, var2, var3, var4, 0, 0)) {
                                 this.tab = 2;
                                 this.openc = 10;
                                 this.itab = 0;
                                 this.litab = -1;
                                 if (!this.opname.equals(this.proname)) {
                                    this.opname = this.proname;
                                    this.lastsub = "";
                                    this.readmsg = 1;
                                 }
                              }

                              if (this.stringbutton(this.rd, "   View Cars   ", 558, 408, 1, var2, var3, var4, 0, 0)) {
                                 this.cd.viewname = this.proname;
                                 this.onexitpro();
                                 this.cd.action = 100;
                                 this.xt.cfase = 100;
                                 this.xt.onviewpro = true;
                                 this.xt.fase = 23;
                              }

                              if (this.stringbutton(this.rd, "   View Stages   ", 673, 408, 1, var2, var3, var4, 0, 0)) {
                                 this.protab = 2;
                                 this.loadpst = 0;
                                 this.gs.proitem.removeAll();
                                 this.gs.proitem.add(this.gs.rd, "Loading stages, please wait...");
                              }
                           }
                        }

                        if (this.edit == 1 || this.edit == 2) {
                           this.rd.setColor(new Color(244, 232, 204));
                           this.rd.fillRoundRect(265, 92, 460, 220, 20, 20);
                           this.rd.setColor(new Color(0, 0, 0));
                           this.rd.drawRoundRect(265, 92, 460, 220, 20, 20);
                           String[] var101 = new String[]{"logo", "120x30", "4 : 1"};
                           if (this.edit == 2) {
                              var101[0] = "avatar";
                              var101[1] = "200x200";
                              var101[2] = "1 : 1";
                           }

                           this.rd.setFont(new Font("Arial", 1, 12));
                           this.ftm = this.rd.getFontMetrics();
                           if (this.flko % 4 != 0 || this.flko == 0) {
                              this.rd.drawString(this.msg, 495 - this.ftm.stringWidth(this.msg) / 2, 115);
                           }

                           if (this.flko != 0) {
                              this.flko--;
                           }

                           this.rd.setFont(new Font("Arial", 0, 12));
                           this.rd.drawString("The " + var101[0] + " image is " + var101[1] + " pixels.", 275, 140);
                           this.rd.drawString("Any image uploaded will be resized to that width and height. For the best results", 275, 160);
                           this.rd.drawString("try to upload an image that is bigger or equal to " + var101[1] + " and has the scale of", 275, 180);
                           this.rd.drawString("[ " + var101[2] + " ]  in  [ Width : Height ].", 275, 200);
                           this.rd.drawString("Image uploaded must be less than 1MB and in the format of JPEG, GIF or PNG.", 275, 220);
                           if (this.upload == 0) {
                              if (this.stringbutton(this.rd, "  Upload Image  ", 495, 250, 0, var2, var3, var4, 0, 0)) {
                                 FileDialog var114 = new FileDialog(new Frame(), "Upload Image");
                                 var114.setMode(0);
                                 var114.setVisible(true);
                                 this.filename = "" + var114.getDirectory() + "" + var114.getFile() + "";
                                 if (!this.filename.equals("nullnull")) {
                                    this.upload = 1;
                                 }
                              }
                           } else {
                              this.rd.setFont(new Font("Arial", 1, 12));
                              this.ftm = this.rd.getFontMetrics();
                              if (this.upload == 1) {
                                 this.rd.drawString("Checking image...", 495 - this.ftm.stringWidth("Checking image...") / 2, 250);
                              }

                              if (this.upload == 2) {
                                 this.rd.drawString("Authenticating...", 495 - this.ftm.stringWidth("Authenticating...") / 2, 250);
                              }

                              if (this.upload == 3) {
                                 this.rd.drawString("Uploading image :  " + this.perc + " %", 495 - this.ftm.stringWidth("Uploading image :  80 %") / 2, 250);
                              }

                              if (this.upload == 4) {
                                 this.rd.drawString("Creating image online...", 495 - this.ftm.stringWidth("Creating image online...") / 2, 250);
                              }

                              if (this.upload == 5) {
                                 this.rd.drawString("Done", 495 - this.ftm.stringWidth("Done") / 2, 250);
                              }
                           }

                           if (this.stringbutton(this.rd, " Cancel ", 495, 290, 2, var2, var3, var4, 0, 0)) {
                              if (this.upload == 0) {
                                 this.edit = 0;
                              } else {
                                 this.upload = 0;
                              }
                           }
                        }

                        if (this.edit == 3) {
                           this.rd.setColor(new Color(244, 232, 204));
                           this.rd.fillRoundRect(265, 38, 460, 390, 20, 20);
                           this.rd.setColor(new Color(0, 0, 0));
                           this.rd.drawRoundRect(265, 38, 460, 390, 20, 20);
                           this.rd.setFont(new Font("Arial", 1, 12));
                           this.ftm = this.rd.getFontMetrics();
                           this.rd.drawString("Edit your about section", 495 - this.ftm.stringWidth("Edit your about section") / 2, 61);
                           this.rd.setFont(new Font("Arial", 0, 12));
                           if (!this.badlang) {
                              this.rd.drawString("Type in a sentence that best describes you and your playing style in the game :", 275, 86);
                           } else {
                              this.rd.setFont(new Font("Arial", 1, 12));
                              this.rd.drawString("The sentence must not contain bad language!", 275, 86);
                              this.rd.setFont(new Font("Arial", 0, 12));
                           }

                           var7 = true;
                           this.rd.drawLine(315, 123, 675, 123);
                           this.rd.drawString("The ( Racing VS Wasting ) is comparison between your multiplayer wins by", 275, 146);
                           this.rd.drawString("racing versus wasting.", 275, 166);
                           this.rd.drawString("It does not in anyway signify if you are better or worse than another player!", 275, 186);
                           this.rd.drawString("It simply shows whether you have a tendency to win games by racing or by", 275, 206);
                           this.rd.drawString("wasting, it shows what you are better at.", 275, 226);
                           this.rd.drawLine(315, 241, 675, 241);
                           this.rd.drawString("Upload your very own theme song!", 275, 264);
                           this.rd.drawString("The theme song must be a Module Track that is in a zip file and less than 700KB.", 275, 284);
                           this.rd.drawString("You can find lots of Module Tracks at modarchive.org.", 275, 304);
                           this.rd.setFont(new Font("Arial", 1, 12));
                           this.ftm = this.rd.getFontMetrics();
                           if (this.uploadt == 0) {
                              if (this.msg.equals("")) {
                                 if (!this.themesong.equals("") && this.trackvol != 0) {
                                    this.rd
                                       .drawString(
                                          "Current Track : " + this.themesong + "",
                                          495 - this.ftm.stringWidth("Current Track : " + this.themesong + "") / 2,
                                          324
                                       );
                                 } else {
                                    this.rd.setFont(new Font("Arial", 0, 12));
                                    this.rd.drawString("[ No theme song uploaded... ]", 495 - this.ftm.stringWidth("[ No theme song uploaded... ]") / 2, 324);
                                 }
                              } else {
                                 if (this.flko % 4 != 0 || this.flko == 0) {
                                    this.rd.drawString(this.msg, 495 - this.ftm.stringWidth(this.msg) / 2, 324);
                                 }

                                 if (this.flko != 0) {
                                    this.flko--;
                                 }
                              }

                              if (this.stringbutton(this.rd, "  Upload Track  ", 495, 354, 0, var2, var3, var4, 0, 0)) {
                                 FileDialog var102 = new FileDialog(new Frame(), "Upload Track");
                                 var102.setMode(0);
                                 var102.setFile("*.zip");
                                 var102.setVisible(true);
                                 this.filename = "" + var102.getDirectory() + "" + var102.getFile() + "";
                                 if (!this.filename.equals("nullnull")) {
                                    this.trackname = var102.getFile().substring(0, var102.getFile().length() - 4);
                                    this.uploadt = 1;
                                 }
                              }
                           } else {
                              if (this.uploadt == 1) {
                                 this.rd.drawString("Checking MOD Track...", 495 - this.ftm.stringWidth("Checking MOD Track...") / 2, 354);
                              }

                              if (this.uploadt == 2) {
                                 this.rd.drawString("Authenticating...", 495 - this.ftm.stringWidth("Authenticating...") / 2, 354);
                              }

                              if (this.uploadt == 3) {
                                 this.rd.drawString("Uploading track, please wait...", 495 - this.ftm.stringWidth("Uploading track, please wait...") / 2, 354);
                              }

                              if (this.uploadt == 4) {
                                 this.rd.drawString("Adding track to your profile...", 495 - this.ftm.stringWidth("Adding track to your profile...") / 2, 354);
                              }

                              if (this.uploadt == 5) {
                                 this.rd.drawString("Done", 495 - this.ftm.stringWidth("Done") / 2, 354);
                              }
                           }

                           this.rd.drawLine(315, 376, 675, 376);
                           if (this.stringbutton(this.rd, "        Done        ", 495, 407, 1, var2, var3, var4, 0, 0)) {
                              this.edit = 0;
                              if (this.sentchange == 1) {
                                 if (!this.xt.msgcheck(this.sentance)
                                    && this.sentance.toLowerCase().indexOf(this.gs.tpass.getText().toLowerCase()) == -1
                                    && this.xt.acexp != -3) {
                                    this.sentchange = 2;
                                 } else {
                                    this.edit = 3;
                                    this.sentchange = 0;
                                    this.sentance = "";
                                    this.gs.cmsg.setText(this.sentance);
                                    this.badlang = true;
                                 }

                                 this.trunsent();
                              }
                           }
                        }

                        if (this.edit == 5) {
                           this.rd.setColor(new Color(244, 232, 204));
                           this.rd.fillRoundRect(265, 187, 460, 125, 20, 20);
                           this.rd.setColor(new Color(0, 0, 0));
                           this.rd.drawRoundRect(265, 187, 460, 125, 20, 20);
                           this.rd.setFont(new Font("Arial", 1, 12));
                           this.ftm = this.rd.getFontMetrics();
                           this.rd
                              .drawString(
                                 "You need to upgrade your account to a full account to have a profile!",
                                 495 - this.ftm.stringWidth("You need to upgrade your account to a full account to have a profile!") / 2,
                                 209
                              );
                           this.rd.setColor(new Color(206, 171, 98));
                           this.rd.fillRoundRect(405, 222, 180, 50, 20, 20);
                           if (this.drawbutton(this.xt.upgrade, 495, 247, var2, var3, var4)) {
                              this.gs.editlink(this.xt.nickname, true);
                           }

                           if (this.stringbutton(this.rd, "  Cancel  ", 495, 297, 2, var2, var3, var4, 0, 0)) {
                              this.edit = 0;
                           }
                        }
                     } else {
                        this.rd.drawString("Loading profile, please wait...", 495 - this.ftm.stringWidth("Loading profile, please wait...") / 2, 222);
                     }
                  }
               } else {
                  this.edit = 0;
                  this.uploadt = 0;
                  this.sentchange = 0;
                  this.underc = 0;
                  this.protab = 0;
                  if (this.gs.proitem.show) {
                     this.gs.proitem.show = false;
                     this.addstage = 0;
                  }
               }

               if (this.tab == 2) {
                  this.dotab2(var2, var3, var4);
               } else {
                  if (this.gs.sendtyp.isShowing()) {
                     this.gs.sendtyp.hide();
                  }

                  if (this.gs.senditem.isShowing()) {
                     this.gs.senditem.hide();
                  }

                  if (this.gs.datat.isShowing()) {
                     this.gs.datat.hide();
                  }

                  this.gs.ilaps.hide();
                  this.gs.icars.hide();
                  this.gs.sclass.hide();
                  this.gs.sfix.hide();
               }

               if (this.tab == 3) {
                  this.dotab3(var2, var3, var4);
               } else {
                  if (this.gs.clcars.isShowing()) {
                     this.gs.clcars.hide();
                  }

                  if (this.editc != 0) {
                     this.editc = 0;
                     if (this.gs.clanlev.isShowing()) {
                        this.gs.clanlev.hide();
                     }
                  }

                  if (this.cfase == 1) {
                     this.cfase = 0;
                  }
               }

               if (this.ptab == 0) {
                  if (this.npo != -1) {
                     this.sdist = (this.npo - 7) * 50;
                     if (this.sdist < 0) {
                        this.sdist = 0;
                     }

                     this.scro = (int)(this.spos / 345.0F * this.sdist);

                     for (int var48 = 0; var48 < this.npo; var48++) {
                        if (57 + 50 * var48 - this.scro > 0 && 57 + 50 * (var48 - 1) - this.scro < 438) {
                           boolean var60 = false;
                           if (var2 > 26
                              && var2 < 146
                              && var3 > 38 + 50 * var48 - this.scro
                              && var3 < 68 + 50 * var48 - this.scro
                              && !this.onp
                              && this.overit == 0) {
                              var60 = true;
                              this.cur = 12;
                              if (var4) {
                                 this.tab = 1;
                                 if (!this.proname.equals(this.pname[var48])) {
                                    this.proname = this.pname[var48];
                                    this.loadedp = false;
                                    this.onexitpro();
                                 }
                              }
                           }

                           boolean var72 = this.drawl(this.rd, this.pname[var48], 26, 38 + 50 * var48 - this.scro, var60);
                           if (!var60 || !var72) {
                              this.rd.setFont(new Font("Arial", 1, 12));
                              this.ftm = this.rd.getFontMetrics();
                              this.rd.setColor(new Color(0, 0, 0));
                              this.rd.drawString(this.pname[var48], 86 - this.ftm.stringWidth(this.pname[var48]) / 2, 49 + 50 * var48 - this.scro);
                              this.rd.setFont(new Font("Arial", 1, 11));
                              this.ftm = this.rd.getFontMetrics();
                              String var84 = "Not in any room...";
                              if (this.pserver[var48] >= 0 && this.pserver[var48] <= 2 && this.proom[var48] >= 0 && this.proom[var48] <= 4) {
                                 var84 = "" + this.lg.snames[this.pserver[var48]] + " :: Room " + (this.proom[var48] + 1) + "";
                                 this.rd.setColor(new Color(49, 79, 0));
                              }

                              this.rd.drawString(var84, 86 - this.ftm.stringWidth(var84) / 2, 65 + 50 * var48 - this.scro);
                           }

                           this.rd.setColor(this.color2k(150, 150, 150));
                           this.rd.drawLine(5, 77 + 50 * var48 - this.scro, 167, 77 + 50 * var48 - this.scro);
                        }
                     }
                  } else {
                     this.rd.setColor(new Color(0, 0, 0));
                     this.rd.setFont(new Font("Arial", 1, 12));
                     this.ftm = this.rd.getFontMetrics();
                     this.rd.drawString("Loading players...", 86 - this.ftm.stringWidth("Loading players...") / 2, 200);
                  }
               }

               if (this.ptab == 1) {
                  if (this.npf >= 0) {
                     this.sdist = (this.npf - 7) * 50;
                     if (this.sdist < 0) {
                        this.sdist = 0;
                     }

                     this.scro = (int)(this.spos / 345.0F * this.sdist);
                     int var49 = 0;
                     if (this.npf == 0) {
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("No friends added yet.", 86 - this.ftm.stringWidth("No friends added yet.") / 2, 200);
                     } else {
                        for (int var61 = 0; var61 < this.npf; var61++) {
                           int var73 = -1;

                           for (int var85 = 0; var85 < this.npo; var85++) {
                              if (this.pname[var85].toLowerCase().equals(this.fname[var61].toLowerCase())) {
                                 var73 = var85;
                                 break;
                              }
                           }

                           if (var73 != -1) {
                              if (57 + 50 * var49 - this.scro > 0 && 57 + 50 * (var49 - 1) - this.scro < 438) {
                                 boolean var86 = false;
                                 if (var2 > 26
                                    && var2 < 146
                                    && var3 > 38 + 50 * var49 - this.scro
                                    && var3 < 68 + 50 * var49 - this.scro
                                    && !this.onp
                                    && this.overit == 0
                                    && this.freq <= 0) {
                                    var86 = true;
                                    this.cur = 12;
                                    if (var4) {
                                       this.tab = 1;
                                       if (!this.proname.equals(this.fname[var61])) {
                                          this.proname = this.fname[var61];
                                          this.loadedp = false;
                                          this.onexitpro();
                                       }
                                    }
                                 }

                                 boolean var103 = this.drawl(this.rd, this.fname[var61], 26, 38 + 50 * var49 - this.scro, var86);
                                 if (!var86 || !var103) {
                                    this.rd.setFont(new Font("Arial", 1, 12));
                                    this.ftm = this.rd.getFontMetrics();
                                    this.rd.setColor(new Color(0, 0, 0));
                                    this.rd.drawString(this.fname[var61], 86 - this.ftm.stringWidth(this.fname[var61]) / 2, 49 + 50 * var49 - this.scro);
                                    this.rd.setFont(new Font("Arial", 1, 11));
                                    this.ftm = this.rd.getFontMetrics();
                                    String var115 = "Not in any room...";
                                    if (this.pserver[var73] >= 0 && this.pserver[var73] <= 2 && this.proom[var73] >= 0 && this.proom[var73] <= 4) {
                                       var115 = "" + this.lg.snames[this.pserver[var73]] + " :: Room " + (this.proom[var73] + 1) + "";
                                       this.rd.setColor(new Color(49, 79, 0));
                                    }

                                    this.rd.drawString(var115, 86 - this.ftm.stringWidth(var115) / 2, 65 + 50 * var49 - this.scro);
                                 }

                                 this.rd.setColor(this.color2k(150, 150, 150));
                                 this.rd.drawLine(5, 77 + 50 * var49 - this.scro, 167, 77 + 50 * var49 - this.scro);
                              }

                              var49++;
                           }
                        }

                        for (int var62 = 0; var62 < this.npf; var62++) {
                           int var74 = -1;

                           for (int var87 = 0; var87 < this.npo; var87++) {
                              if (this.pname[var87].toLowerCase().equals(this.fname[var62].toLowerCase())) {
                                 var74 = var87;
                                 break;
                              }
                           }

                           if (var74 == -1) {
                              if (57 + 50 * var49 - this.scro > 0 && 57 + 50 * (var49 - 1) - this.scro < 438) {
                                 boolean var88 = false;
                                 if (var2 > 26
                                    && var2 < 146
                                    && var3 > 38 + 50 * var49 - this.scro
                                    && var3 < 68 + 50 * var49 - this.scro
                                    && !this.onp
                                    && this.overit == 0
                                    && this.freq <= 0) {
                                    var88 = true;
                                    this.cur = 12;
                                    if (var4) {
                                       this.tab = 1;
                                       if (!this.proname.equals(this.fname[var62])) {
                                          this.proname = this.fname[var62];
                                          this.loadedp = false;
                                          this.onexitpro();
                                       }
                                    }
                                 }

                                 boolean var104 = this.drawl(this.rd, this.fname[var62], 26, 38 + 50 * var49 - this.scro, var88);
                                 if (!var88 || !var104) {
                                    this.rd.setFont(new Font("Arial", 1, 12));
                                    this.ftm = this.rd.getFontMetrics();
                                    this.rd.setColor(new Color(0, 0, 0));
                                    this.rd.drawString(this.fname[var62], 86 - this.ftm.stringWidth(this.fname[var62]) / 2, 49 + 50 * var49 - this.scro);
                                    this.rd.setFont(new Font("Arial", 0, 11));
                                    this.ftm = this.rd.getFontMetrics();
                                    String var116 = "Player Offline";
                                    this.rd.drawString(var116, 86 - this.ftm.stringWidth(var116) / 2, 65 + 50 * var49 - this.scro);
                                 }

                                 this.rd.setColor(this.color2k(150, 150, 150));
                                 this.rd.drawLine(5, 77 + 50 * var49 - this.scro, 167, 77 + 50 * var49 - this.scro);
                              }

                              var49++;
                           }
                        }
                     }

                     if (this.freq == 1) {
                        this.rd.setColor(new Color(236, 215, 140));
                        this.rd.fillRect(-10, 28, 200, 130);
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawRect(-10, 28, 200, 130);
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("Friend request from:", 86 - this.ftm.stringWidth("Friend request from:") / 2, 45);
                        this.rd.setColor(new Color(240, 222, 164));
                        this.rd.fillRect(26, 51, 119, 29);
                        if (!this.drawl(this.rd, this.freqname, 26, 51, true)) {
                           this.rd.setColor(new Color(0, 0, 0));
                           this.rd.drawString(this.freqname, 86 - this.ftm.stringWidth(this.freqname) / 2, 70);
                           this.rd.setColor(this.color2k(150, 150, 150));
                           this.rd.drawRect(26, 51, 119, 29);
                        }

                        if (var2 > 26 && var2 < 146 && var3 > 51 && var3 < 81) {
                           this.cur = 12;
                           if (var4) {
                              this.tab = 1;
                              if (!this.proname.equals(this.freqname)) {
                                 this.proname = this.freqname;
                                 this.loadedp = false;
                                 this.onexitpro();
                              }
                           }
                        }

                        if (this.stringbutton(this.rd, "    Confirm    ", 86, 107, 0, var2, var3, var4, 0, 0)) {
                           this.freq = 2;
                        }

                        if (this.stringbutton(this.rd, "Cancel", 86, 140, 2, var2, var3, var4, 0, 0)) {
                           this.freq = 3;
                        }
                     }

                     if (this.freq == -1) {
                        this.rd.setColor(new Color(236, 215, 140));
                        this.rd.fillRect(-10, 28, 200, 25);
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawRect(-10, 28, 200, 25);
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("Failed to confirm friend!", 86 - this.ftm.stringWidth("Failed to confirm friend!") / 2, 45);
                        this.cntf--;
                        if (this.cntf <= 0) {
                           this.freq = 0;
                        }
                     }

                     if (this.freq == -2) {
                        this.rd.setColor(new Color(236, 215, 140));
                        this.rd.fillRect(-10, 28, 200, 25);
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawRect(-10, 28, 200, 25);
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("Failed to cancel request!", 86 - this.ftm.stringWidth("Failed to cancel request!") / 2, 45);
                        this.cntf--;
                        if (this.cntf <= 0) {
                           this.freq = 0;
                        }
                     }

                     if (this.freq == 2) {
                        this.rd.setColor(new Color(236, 215, 140));
                        this.rd.fillRect(-10, 28, 200, 25);
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawRect(-10, 28, 200, 25);
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("Confirming friend...", 86 - this.ftm.stringWidth("Confirming friend...") / 2, 45);
                     }

                     if (this.freq == 3) {
                        this.rd.setColor(new Color(236, 215, 140));
                        this.rd.fillRect(-10, 28, 200, 25);
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawRect(-10, 28, 200, 25);
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("Canceling...", 86 - this.ftm.stringWidth("Canceling...") / 2, 45);
                     }

                     if (this.freq == 6) {
                        this.rd.setColor(new Color(236, 215, 140));
                        this.rd.fillRect(-10, 28, 200, 61 + this.ncnf * 35);
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawRect(-10, 28, 200, 61 + this.ncnf * 35);
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("Friend Confirmation(s):", 86 - this.ftm.stringWidth("Friend Confirmation(s):") / 2, 45);

                        for (int var63 = 0; var63 < this.ncnf; var63++) {
                           this.rd.setColor(new Color(240, 222, 164));
                           this.rd.fillRect(26, 51 + 35 * var63, 119, 29);
                           if (!this.drawl(this.rd, this.cnfname[var63], 26, 51 + 35 * var63, true)) {
                              this.rd.setColor(new Color(0, 0, 0));
                              this.rd.drawString(this.cnfname[var63], 86 - this.ftm.stringWidth(this.cnfname[var63]) / 2, 70 + 35 * var63);
                              this.rd.setColor(this.color2k(150, 150, 150));
                              this.rd.drawRect(26, 51 + 35 * var63, 119, 29);
                           }

                           if (var2 > 26 && var2 < 146 && var3 > 51 + 35 * var63 && var3 < 81 + 35 * var63) {
                              this.cur = 12;
                              if (var4) {
                                 this.tab = 1;
                                 if (!this.proname.equals(this.cnfname[var63])) {
                                    this.proname = this.cnfname[var63];
                                    this.loadedp = false;
                                    this.onexitpro();
                                 }
                              }
                           }
                        }

                        if (this.stringbutton(this.rd, "  OK  ", 86, 107 + 35 * (this.ncnf - 1), 0, var2, var3, var4, 0, 0)) {
                           this.freq = -6;
                        }
                     }
                  } else {
                     if (this.npf == -1) {
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("Loading friends...", 86 - this.ftm.stringWidth("Loading friends...") / 2, 200);
                     }

                     if (this.npf == -2) {
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("Failed to load friends!", 86 - this.ftm.stringWidth("Failed to load friends!") / 2, 200);
                     }
                  }
               }

               if (this.ptab == 2) {
                  if (this.xt.clan.equals("")) {
                     this.rd.setColor(new Color(0, 0, 0));
                     this.rd.setFont(new Font("Arial", 1, 12));
                     this.ftm = this.rd.getFontMetrics();
                     this.rd.drawString("Not in a Clan", 86 - this.ftm.stringWidth("Not in a Clan") / 2, 200);
                     this.rd.setFont(new Font("Arial", 0, 11));
                     this.ftm = this.rd.getFontMetrics();
                     this.rd.drawString("You haven't joined and clan yet.", 86 - this.ftm.stringWidth("You haven't joined and clan yet.") / 2, 220);
                  } else if (!this.loadedcm) {
                     this.rd.setColor(new Color(0, 0, 0));
                     this.rd.setFont(new Font("Arial", 1, 12));
                     this.ftm = this.rd.getFontMetrics();
                     this.rd.drawString("Loading clan mates...", 86 - this.ftm.stringWidth("Loading clan mates...") / 2, 200);
                  } else {
                     this.sdist = (this.ncln - 7) * 50;
                     if (this.sdist < 0) {
                        this.sdist = 0;
                     }

                     this.scro = (int)(this.spos / 345.0F * this.sdist);
                     int var50 = 0;

                     for (int var64 = 0; var64 < this.ncln; var64++) {
                        int var75 = -1;

                        for (int var89 = 0; var89 < this.npo; var89++) {
                           if (this.pname[var89].toLowerCase().equals(this.clname[var64].toLowerCase())) {
                              var75 = var89;
                              break;
                           }
                        }

                        if (var75 != -1) {
                           if (57 + 50 * var50 - this.scro > 0 && 57 + 50 * (var50 - 1) - this.scro < 438) {
                              boolean var90 = false;
                              if (var2 > 26
                                 && var2 < 146
                                 && var3 > 38 + 50 * var50 - this.scro
                                 && var3 < 68 + 50 * var50 - this.scro
                                 && !this.onp
                                 && this.overit == 0
                                 && this.freq <= 0) {
                                 var90 = true;
                                 this.cur = 12;
                                 if (var4) {
                                    this.tab = 1;
                                    if (!this.proname.equals(this.clname[var64])) {
                                       this.proname = this.clname[var64];
                                       this.loadedp = false;
                                       this.onexitpro();
                                    }
                                 }
                              }

                              boolean var105 = this.drawl(this.rd, this.clname[var64], 26, 38 + 50 * var50 - this.scro, var90);
                              if (!var90 || !var105) {
                                 this.rd.setFont(new Font("Arial", 1, 12));
                                 this.ftm = this.rd.getFontMetrics();
                                 this.rd.setColor(new Color(0, 0, 0));
                                 this.rd.drawString(this.clname[var64], 86 - this.ftm.stringWidth(this.clname[var64]) / 2, 49 + 50 * var50 - this.scro);
                                 this.rd.setFont(new Font("Arial", 1, 11));
                                 this.ftm = this.rd.getFontMetrics();
                                 String var117 = "Not in any room...";
                                 if (this.pserver[var75] >= 0 && this.pserver[var75] <= 2 && this.proom[var75] >= 0 && this.proom[var75] <= 4) {
                                    var117 = "" + this.lg.snames[this.pserver[var75]] + " :: Room " + (this.proom[var75] + 1) + "";
                                    this.rd.setColor(new Color(49, 79, 0));
                                 }

                                 this.rd.drawString(var117, 86 - this.ftm.stringWidth(var117) / 2, 65 + 50 * var50 - this.scro);
                              }

                              this.rd.setColor(this.color2k(150, 150, 150));
                              this.rd.drawLine(5, 77 + 50 * var50 - this.scro, 167, 77 + 50 * var50 - this.scro);
                           }

                           var50++;
                        }
                     }

                     for (int var65 = 0; var65 < this.ncln; var65++) {
                        int var76 = -1;

                        for (int var91 = 0; var91 < this.npo; var91++) {
                           if (this.pname[var91].toLowerCase().equals(this.clname[var65].toLowerCase())) {
                              var76 = var91;
                              break;
                           }
                        }

                        if (var76 == -1) {
                           if (57 + 50 * var50 - this.scro > 0 && 57 + 50 * (var50 - 1) - this.scro < 438) {
                              boolean var92 = false;
                              if (var2 > 26
                                 && var2 < 146
                                 && var3 > 38 + 50 * var50 - this.scro
                                 && var3 < 68 + 50 * var50 - this.scro
                                 && !this.onp
                                 && this.overit == 0
                                 && this.freq <= 0) {
                                 var92 = true;
                                 this.cur = 12;
                                 if (var4) {
                                    this.tab = 1;
                                    if (!this.proname.equals(this.clname[var65])) {
                                       this.proname = this.clname[var65];
                                       this.loadedp = false;
                                       this.onexitpro();
                                    }
                                 }
                              }

                              boolean var106 = this.drawl(this.rd, this.clname[var65], 26, 38 + 50 * var50 - this.scro, var92);
                              if (!var92 || !var106) {
                                 this.rd.setFont(new Font("Arial", 1, 12));
                                 this.ftm = this.rd.getFontMetrics();
                                 this.rd.setColor(new Color(0, 0, 0));
                                 this.rd.drawString(this.clname[var65], 86 - this.ftm.stringWidth(this.clname[var65]) / 2, 49 + 50 * var50 - this.scro);
                                 this.rd.setFont(new Font("Arial", 0, 11));
                                 this.ftm = this.rd.getFontMetrics();
                                 String var118 = "Player Offline";
                                 this.rd.drawString(var118, 86 - this.ftm.stringWidth(var118) / 2, 65 + 50 * var50 - this.scro);
                              }

                              this.rd.setColor(this.color2k(150, 150, 150));
                              this.rd.drawLine(5, 77 + 50 * var50 - this.scro, 167, 77 + 50 * var50 - this.scro);
                           }

                           var50++;
                        }
                     }
                  }
               }
            }

            int[] var51 = new int[]{193, 193, 295, 318};
            int[] var66 = new int[]{33, 10, 10, 33};

            for (int var77 = 0; var77 < 4; var77++) {
               boolean var93 = false;
               if (this.tab == 3 && var77 == 0) {
                  var93 = true;
               }

               if (this.tab == 1 && var77 == 1) {
                  var93 = true;
               }

               if (this.tab == 2 && var77 == 2) {
                  var93 = true;
               }

               if (this.tab == 0 && var77 == 3) {
                  var93 = true;
               }

               this.rd.setColor(new Color(255, 255, 255));
               if (var93) {
                  this.rd.setComposite(AlphaComposite.getInstance(3, 0.6F));
               } else {
                  this.rd.setComposite(AlphaComposite.getInstance(3, 0.2F));
               }

               if (var3 >= 12 && var3 <= 32 && var2 > var51[0] && var2 < var51[3]) {
                  this.rd.setComposite(AlphaComposite.getInstance(3, 0.4F));
                  if (var4 && !this.gs.openm) {
                     if (var77 == 0) {
                        this.tab = 3;
                     }

                     if (var77 == 1 || var77 == 2) {
                        this.tab = var77;
                     }

                     if (var77 == 3) {
                        this.tab = 0;
                     }

                     if (this.tab == 1 && this.proname.equals("")) {
                        this.proname = this.xt.nickname;
                        this.loadedp = false;
                        this.onexitpro();
                     }
                  }
               }

               this.rd.fillPolygon(var51, var66, 4);
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawPolygon(var51, var66, 4);
               this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
               if (var77 == 0) {
                  var66[1] = 13;
                  var66[2] = 13;
                  var51[2] = 298;
               }

               for (int var107 = 0; var107 < 4; var107++) {
                  var51[var107] += 125;
               }
            }

            this.rd.drawImage(this.xt.cnmc, 224, 15, null);
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawLine(191, 34, 800, 34);
            this.rd.setColor(this.color2k(200, 200, 200));
            this.rd.fillRect(0, 0, 190, 28);
            this.rd.setColor(this.color2k(150, 150, 150));
            this.rd.drawLine(0, 25, 170, 25);
            this.rd.setColor(this.color2k(200, 200, 200));
            this.rd.fillRect(0, 438, 190, 12);
            this.rd.setColor(this.color2k(150, 150, 150));
            this.rd.drawLine(0, 440, 170, 440);
            this.rd.setColor(this.color2k(200, 200, 200));
            this.rd.fillRect(173, 28, 17, 410);
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawLine(191, 0, 191, 450);
            if (var2 > 0 && var2 < 171 && var3 > 2 && var3 < 23) {
               if (!this.onp) {
                  this.rd.setColor(this.color2k(220, 220, 220));
                  this.rd.fillRect(2, 2, 146, 21);
               }

               this.rd.setColor(this.color2k(255, 255, 255));
               if (var4 && this.overit == 0 && !this.onp) {
                  this.onp = true;
                  this.overit = 5;
               }
            } else {
               this.rd.setColor(this.color2k(235, 235, 235));
            }

            if (this.overit < 0) {
               this.overit++;
            }

            this.rd.fillRect(150, 2, 20, 20);
            this.rd.setColor(this.color2k(150, 150, 150));
            this.rd.drawRect(150, 2, 20, 20);
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawLine(157, 10, 157, 11);
            this.rd.drawLine(158, 11, 158, 12);
            this.rd.drawLine(159, 12, 159, 13);
            this.rd.drawLine(160, 13, 160, 14);
            this.rd.drawLine(161, 12, 161, 13);
            this.rd.drawLine(162, 11, 162, 12);
            this.rd.drawLine(163, 10, 163, 11);
            if (this.ptab == 0) {
               this.rd.drawImage(this.xt.players, 7, 5, null);
            }

            if (this.ptab == 1) {
               this.rd.drawImage(this.xt.myfr, 21, 4, null);
            }

            if (this.ptab == 2) {
               this.rd.drawImage(this.xt.mycl, 34, 4, null);
            }

            if (this.onp) {
               this.rd.setColor(this.color2k(200, 200, 200));
               this.rd.fillRect(0, 25, 170, 67);
               this.rd.setColor(this.color2k(150, 150, 150));
               this.rd.drawRect(0, 25, 170, 67);
               if (var2 > 0 && var2 < 171 && var3 >= 26 && var3 < 48) {
                  this.rd.setColor(this.color2k(235, 235, 235));
                  this.rd.fillRect(1, 26, 169, 22);
                  if (var4) {
                     this.ptab = 0;
                  }
               }

               if (var2 > 0 && var2 < 171 && var3 >= 48 && var3 < 70) {
                  this.rd.setColor(this.color2k(235, 235, 235));
                  this.rd.fillRect(1, 48, 169, 22);
                  if (var4) {
                     this.ptab = 1;
                     this.npf = -1;
                  }
               }

               if (var2 > 0 && var2 < 171 && var3 >= 70 && var3 < 92) {
                  this.rd.setColor(this.color2k(235, 235, 235));
                  this.rd.fillRect(1, 70, 169, 22);
                  if (var4) {
                     this.ptab = 2;
                  }
               }

               this.rd.drawImage(this.xt.players, 7, 30, null);
               this.rd.drawImage(this.xt.myfr, 21, 51, null);
               this.rd.drawImage(this.xt.mycl, 34, 73, null);
               if (var4 && this.overit == 0) {
                  this.onp = false;
                  this.overit = -5;
               }

               if (this.overit > 0) {
                  this.overit--;
               }
            }

            if (this.mscro != 831 && this.sdist != 0) {
               this.rd.setColor(this.color2k(220, 220, 220));
               this.rd.fill3DRect(173, 28, 17, 17, true);
            } else {
               if (this.sdist == 0) {
                  this.rd.setColor(this.color2k(205, 205, 205));
               } else {
                  this.rd.setColor(this.color2k(215, 215, 215));
               }

               this.rd.fillRect(173, 28, 17, 17);
            }

            if (this.sdist != 0) {
               this.rd.drawImage(this.xt.asu, 178, 34, null);
            }

            if (this.mscro != 832 && this.sdist != 0) {
               this.rd.setColor(this.color2k(220, 220, 220));
               this.rd.fill3DRect(173, 421, 17, 17, true);
            } else {
               if (this.sdist == 0) {
                  this.rd.setColor(this.color2k(205, 205, 205));
               } else {
                  this.rd.setColor(this.color2k(215, 215, 215));
               }

               this.rd.fillRect(173, 421, 17, 17);
            }

            if (this.sdist != 0) {
               this.rd.drawImage(this.xt.asd, 178, 428, null);
            }

            if (this.sdist != 0) {
               if (this.lspos != this.spos) {
                  this.rd.setColor(this.color2k(215, 215, 215));
                  this.rd.fillRect(173, 45 + this.spos, 17, 31);
               } else {
                  if (this.mscro == 831) {
                     this.rd.setColor(this.color2k(215, 215, 215));
                  }

                  this.rd.fill3DRect(173, 45 + this.spos, 17, 31, true);
               }

               this.rd.setColor(this.color2k(150, 150, 150));
               this.rd.drawLine(178, 58 + this.spos, 184, 58 + this.spos);
               this.rd.drawLine(178, 60 + this.spos, 184, 60 + this.spos);
               this.rd.drawLine(178, 62 + this.spos, 184, 62 + this.spos);
               if (this.mscro > 800 && this.lspos != this.spos) {
                  this.lspos = this.spos;
               }

               if (var4) {
                  if (this.mscro == 825 && var2 > 173 && var2 < 190 && var3 > 45 + this.spos && var3 < this.spos + 76) {
                     this.mscro = var3 - this.spos;
                  }

                  if (this.mscro == 825 && var2 > 171 && var2 < 192 && var3 > 26 && var3 < 47) {
                     this.mscro = 831;
                  }

                  if (this.mscro == 825 && var2 > 171 && var2 < 192 && var3 > 419 && var3 < 440) {
                     this.mscro = 832;
                  }

                  if (this.mscro == 825 && var2 > 173 && var2 < 190 && var3 > 45 && var3 < 421) {
                     this.mscro = 60;
                     this.spos = var3 - this.mscro;
                  }

                  int var78 = 2670 / this.sdist;
                  if (var78 < 1) {
                     var78 = 1;
                  }

                  if (this.mscro == 831) {
                     this.spos -= var78;
                     if (this.spos > 345) {
                        this.spos = 345;
                     }

                     if (this.spos < 0) {
                        this.spos = 0;
                     }

                     this.lspos = this.spos;
                  }

                  if (this.mscro == 832) {
                     this.spos += var78;
                     if (this.spos > 345) {
                        this.spos = 345;
                     }

                     if (this.spos < 0) {
                        this.spos = 0;
                     }

                     this.lspos = this.spos;
                  }

                  if (this.mscro < 800) {
                     this.spos = var3 - this.mscro;
                     if (this.spos > 345) {
                        this.spos = 345;
                     }

                     if (this.spos < 0) {
                        this.spos = 0;
                     }
                  }

                  if (this.mscro == 825) {
                     this.mscro = 925;
                  }
               } else if (this.mscro != 825) {
                  this.mscro = 825;
               }
            }

            if (this.cur != this.curs) {
               this.gs.setCursor(new Cursor(this.cur));
               this.curs = this.cur;
            }
         }
      }

      if (var6) {
         this.gs.movefieldd(this.gs.cmsg, 207, 414, 462, 22, true);
         if (this.gs.cmsg.getText().equals("Type here...") && var2 > 197 && var2 < 679 && var3 > 404 && var3 < 446) {
            this.gs.cmsg.setText("");
         }

         if (this.gs.cmsg.getText().length() > 200) {
            this.gs.cmsg.setText(this.gs.cmsg.getText().substring(0, 200));
            this.gs.cmsg.select(200, 200);
         }
      }

      if (var7) {
         if (!this.gs.cmsg.isShowing()) {
            this.gs.cmsg.show();
            this.gs.cmsg.setText(this.sentance);
            this.gs.cmsg.requestFocus();
         }

         this.gs.movefield(this.gs.cmsg, 275, 91, 440, 22);
         if (!this.sentance.equals(this.gs.cmsg.getText())) {
            this.sentchange = 1;
            this.rd.setFont(new Font("Tahoma", 1, 11));
            this.ftm = this.rd.getFontMetrics();
            if (this.ftm.stringWidth(this.gs.cmsg.getText()) > 800) {
               this.gs.cmsg.setText(this.sentance);
            } else {
               this.sentance = this.gs.cmsg.getText();
            }
         }
      }

      if (this.dorank) {
         if (!this.gs.cmsg.isShowing()) {
            this.gs.cmsg.show();
            this.gs.cmsg.setText(this.mrank[this.em]);
            this.gs.cmsg.requestFocus();
         }

         this.gs.movefield(this.gs.cmsg, 402, 131, 300, 22);
         this.rd.setFont(new Font("Arial", 1, 11));
         this.ftm = this.rd.getFontMetrics();
         if (this.ftm.stringWidth(this.gs.cmsg.getText()) > 270) {
            int var28 = this.gs.cmsg.getText().length() - 1;
            if (var28 < 0) {
               var28 = 0;
            }

            this.gs.cmsg.setText(this.gs.cmsg.getText().substring(0, var28));
            this.gs.cmsg.select(var28, var28);
         }
      }

      if (this.donewc) {
         if (!this.gs.temail.isShowing()) {
            this.gs.temail.show();
            this.gs.temail.setText("");
            this.gs.temail.requestFocus();
         }

         this.gs.movefield(this.gs.temail, 473, 141, 150, 22);
         this.rd.setFont(new Font("Arial", 1, 13));
         this.ftm = this.rd.getFontMetrics();
         if (this.ftm.stringWidth(this.gs.temail.getText()) > 150) {
            int var29 = this.gs.temail.getText().length() - 1;
            if (var29 < 0) {
               var29 = 0;
            }

            this.gs.temail.setText(this.gs.temail.getText().substring(0, var29));
            this.gs.temail.select(var29, var29);
         }

         if (!this.gs.temail.getText().equals(this.lccnam)) {
            this.lg.fixtext(this.gs.temail);
            this.lccnam = this.gs.temail.getText();
         }

         if (this.xt.msgcheck(this.gs.temail.getText())) {
            this.gs.temail.setText("");
         }
      }

      if (this.dosrch) {
         if (!this.gs.temail.isShowing()) {
            this.gs.temail.show();
            this.gs.temail.setText("");
            this.gs.temail.requestFocus();
         }

         this.gs.movefield(this.gs.temail, 371, 88, 150, 22);
         this.rd.setFont(new Font("Arial", 1, 13));
         this.ftm = this.rd.getFontMetrics();
         if (this.ftm.stringWidth(this.gs.temail.getText()) > 150) {
            int var30 = this.gs.temail.getText().length() - 1;
            if (var30 < 0) {
               var30 = 0;
            }

            this.gs.temail.setText(this.gs.temail.getText().substring(0, var30));
            this.gs.temail.select(var30, var30);
         }

         if (!this.gs.temail.getText().equals(this.lccnam)) {
            this.lg.fixtext(this.gs.temail);
            this.lccnam = this.gs.temail.getText();
         }

         if (this.xt.msgcheck(this.gs.temail.getText())) {
            this.gs.temail.setText("");
         }
      }

      if (this.doweb1) {
         if (!this.gs.temail.isShowing()) {
            this.gs.temail.show();
            this.gs.temail.setText(this.ltit);
            this.gs.temail.requestFocus();
         }

         this.gs.movefield(this.gs.temail, 411, 174, 150, 22);
         this.rd.setFont(new Font("Arial", 1, 13));
         this.ftm = this.rd.getFontMetrics();
         if (this.ftm.stringWidth(this.gs.temail.getText()) > 200) {
            int var31 = this.gs.temail.getText().length() - 1;
            if (var31 < 0) {
               var31 = 0;
            }

            this.gs.temail.setText(this.gs.temail.getText().substring(0, var31));
            this.gs.temail.select(var31, var31);
         }

         if (this.xt.msgcheck(this.gs.temail.getText())) {
            this.gs.temail.setText("");
         }

         if (!this.gs.cmsg.isShowing()) {
            this.gs.cmsg.show();
            this.gs.cmsg.setText(this.ldes);
         }

         this.gs.movefield(this.gs.cmsg, 411, 204, 300, 22);
         this.rd.setFont(new Font("Arial", 0, 12));
         this.ftm = this.rd.getFontMetrics();
         if (this.ftm.stringWidth(this.gs.cmsg.getText()) > 400) {
            int var32 = this.gs.cmsg.getText().length() - 1;
            if (var32 < 0) {
               var32 = 0;
            }

            this.gs.cmsg.setText(this.gs.cmsg.getText().substring(0, var32));
            this.gs.cmsg.select(var32, var32);
         }

         if (this.xt.msgcheck(this.gs.cmsg.getText())) {
            this.gs.cmsg.setText("");
         }
      }

      if (this.doweb2) {
         if (!this.gs.temail.isShowing()) {
            this.gs.temail.show();
            this.gs.temail.requestFocus();
         }

         this.gs.movefield(this.gs.temail, 354, 134, 350, 22);
      }

      if (this.dommsg) {
         if (!this.donemsg) {
            this.gs.mmsg.setText(" ");
            if (!this.gs.applejava) {
               this.gs.mmsg.show();
               this.gs.mmsg.requestFocus();
            }

            this.donemsg = true;
         }

         this.gs.movefielda(this.gs.mmsg, 207, 389, 450, 50);
      } else {
         if (this.gs.mmsg.isShowing()) {
            this.gs.mmsg.hide();
         }

         if (this.donemsg) {
            this.donemsg = false;
         }
      }

      if (!this.dosrch && !this.donewc && !this.doweb1 && !this.doweb2 && this.gs.temail.isShowing()) {
         this.gs.temail.hide();
      }

      if (!var6 && !var7 && !this.dorank && !this.doweb1 && this.open == 452 && this.gs.cmsg.isShowing()) {
         this.gs.cmsg.hide();
      }
   }

   public void dotab3(int var1, int var2, boolean var3) {
      if (this.cfase == 0) {
         this.rd.setColor(new Color(0, 0, 0));
         this.rd.drawRect(214, 44, 160, 50);
         this.rd.setFont(new Font("Arial", 1, 13));
         this.ftm = this.rd.getFontMetrics();
         short var4 = 239;
         int var5 = this.ftm.stringWidth("Search for a clan");
         this.rd.fillRect(225, 57, 4, 4);
         this.rd.drawString("Search for a clan", var4, 63);
         if (var1 > var4 && var1 < var4 + var5 && var2 > 46 && var2 < 65 && this.editc == 0) {
            this.rd.drawLine(var4, 65, var4 + var5, 65);
            this.cur = 12;
            if (var3) {
               this.cfase = 2;
               this.em = 1;
               this.msg = "Clan Search";
               this.smsg = "Listing clans with recent activity...";
               this.nclns = 0;
               this.spos5 = 0;
               this.lspos5 = 0;
               this.flko = 0;
            }
         }

         var4 = 239;
         var5 = this.ftm.stringWidth("Create a new clan");
         this.rd.fillRect(225, 77, 4, 4);
         this.rd.drawString("Create a new clan", var4, 83);
         if (var1 > var4 && var1 < var4 + var5 && var2 > 66 && var2 < 85 && this.editc == 0) {
            this.rd.drawLine(var4, 85, var4 + var5, 85);
            this.cur = 12;
            if (var3) {
               this.cfase = 1;
               this.em = 0;
               this.msg = "Start a new Need for Madness clan,";
               this.flko = 0;
            }
         }

         if (!this.xt.clan.equals("")) {
            byte var6 = -40;
            byte var7 = 19;
            if (!this.drawl(this.rd, "#" + this.xt.clan + "#", 406 + var7, 101 + var6, true)) {
               this.rd.setFont(new Font("Arial", 1, 13));
               this.ftm = this.rd.getFontMetrics();
               this.rd.drawString("" + this.xt.clan + "", 581 + var7 - this.ftm.stringWidth("" + this.xt.clan + "") / 2, 121 + var6);
            }

            this.rd.setFont(new Font("Arial", 1, 12));
            this.ftm = this.rd.getFontMetrics();
            String var8 = "Your Clan";
            if (var1 > 402 + var7 && var1 < 759 + var7 && var2 > 84 + var6 && var2 < 134 + var6) {
               var8 = "Clan :  " + this.xt.clan + "";
               this.rd.drawLine(408 + var7, 98 + var6, 408 + var7 + this.ftm.stringWidth(var8), 98 + var6);
               if (var1 > 408 + var7 && var1 < 408 + var7 + this.ftm.stringWidth(var8) && var2 > 85 + var6 && var2 < 100 + var6
                  || var1 > 406 + var7 && var1 < 756 + var7 && var2 > 101 + var6 && var2 < 131 + var6) {
                  this.cur = 12;
                  if (var3) {
                     if (!this.claname.equals(this.xt.clan)) {
                        this.claname = this.xt.clan;
                        this.loadedc = false;
                     }

                     this.spos5 = 0;
                     this.lspos5 = 0;
                     this.cfase = 3;
                     this.ctab = 0;
                     this.blocknote = 10;
                  }
               }
            }

            this.rd.drawString(var8, 408 + var7, 97 + var6);
            this.rd.drawLine(402 + var7, 84 + var6, 402 + var7, 134 + var6);
            this.rd.drawLine(402 + var7, 84 + var6, 408 + var7 + this.ftm.stringWidth(var8) + 2, 84 + var6);
            this.rd.drawLine(408 + var7 + this.ftm.stringWidth(var8) + 2, 84 + var6, 408 + var7 + this.ftm.stringWidth(var8) + 15, 97 + var6);
            this.rd.drawLine(408 + var7 + this.ftm.stringWidth(var8) + 15, 97 + var6, 759 + var7, 97 + var6);
            this.rd.drawLine(759 + var7, 97 + var6, 759 + var7, 134 + var6);
            this.rd.drawLine(402 + var7, 134 + var6, 759 + var7, 134 + var6);
         }

         this.rd.setFont(new Font("Arial", 1, 13));
         this.ftm = this.rd.getFontMetrics();
         if (this.ntab == 0) {
            int[] var28 = new int[]{214, 225 + this.ftm.stringWidth("Game News"), 225 + this.ftm.stringWidth("Game News") + 23, 778, 778, 214};
            int[] var33 = new int[]{112, 112, 135, 135, 443, 443};
            this.rd.setColor(new Color(206, 171, 98));
            this.rd.fillPolygon(var28, var33, 6);
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawPolygon(var28, var33, 6);
         }

         if (this.ntab == 1) {
            int[] var29 = new int[]{
               214,
               225 + this.ftm.stringWidth("Game News") + 23,
               225 + this.ftm.stringWidth("Game News") + 23,
               236 + this.ftm.stringWidth("Game News") + 23 + this.ftm.stringWidth("Wars World Championship"),
               236 + this.ftm.stringWidth("Game News") + 23 + this.ftm.stringWidth("Wars World Championship") + 23,
               778,
               778,
               214
            };
            int[] var34 = new int[]{135, 135, 112, 112, 135, 135, 443, 443};
            this.rd.setColor(new Color(206, 171, 98));
            this.rd.fillPolygon(var29, var34, 8);
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawPolygon(var29, var34, 8);
         }

         int var30 = 223;
         int var35 = this.ftm.stringWidth("Game News");
         byte var42 = 23;
         this.rd.drawString("Game News", var30, 107 + var42);
         if (var1 > var30 && var1 < var30 + var35 && var2 > 90 + var42 && var2 < 109 + var42) {
            this.rd.drawLine(var30, 109 + var42, var30 + var35, 109 + var42);
            this.cur = 12;
            if (var3) {
               this.ntab = 0;
               this.spos6 = 0;
            }
         }

         var30 += var35 + 35;
         var35 = this.ftm.stringWidth("Wars World Championship");
         this.rd.drawString("Wars World Championship", var30, 107 + var42);
         if (var1 > var30 && var1 < var30 + var35 && var2 > 90 + var42 && var2 < 109 + var42) {
            this.rd.drawLine(var30, 109 + var42, var30 + var35, 109 + var42);
            this.cur = 12;
            if (var3) {
               this.ntab = 1;
               this.spos6 = 0;
            }
         }

         this.rdo.setColor(new Color(206, 171, 98));
         this.rdo.fillRect(0, 0, 560, 300);
         this.darker = true;
         if (this.stringbutton(this.rd, "  Refresh  ", 738, 125, 3, var1, var2, var3, 0, 0)) {
            if (this.ntab == 0) {
               this.loadednews = 0;
            }

            if (this.ntab == 1) {
               this.loadwstat = 0;
            }
         }

         this.darker = false;
         if (this.ntab == 0) {
            if (this.loadednews == 1) {
               int var9 = 0;

               for (int var10 = 0; var10 < 5; var10++) {
                  if (this.nwarbs[var10] > 0) {
                     var9++;
                  }
               }

               if (var9 == 0) {
                  var9 = 1;
               }

               this.sdist = 100 + 35 * var9 + this.doi * 16 - 200;
               if (this.sdist < 0) {
                  this.sdist = 0;
               }

               this.scro = (int)(this.spos6 / 229.0F * this.sdist);
               if (this.scro < 55) {
                  this.rdo.setFont(new Font("Tahoma", 1, 11));
                  this.rdo.setColor(new Color(0, 0, 0));
                  this.rdo.drawString("A big welcome to the latest players to join the game with full accounts!", 18, 15 - this.scro);

                  for (int var67 = 0; var67 < 4; var67++) {
                     boolean var11 = false;
                     boolean var12 = false;
                     if (var1 > 234 + 128 * var67 && var1 < 354 + 128 * var67 && var2 > 159 - this.scro && var2 < 189 - this.scro && var2 > 139 && var2 < 439) {
                        var12 = true;
                        this.cur = 12;
                        if (var3) {
                           this.tab = 1;
                           if (!this.proname.equals(this.newplayers[var67])) {
                              this.proname = this.newplayers[var67];
                              this.loadedp = false;
                              this.onexitpro();
                           }
                        }
                     }

                     if (!var12) {
                        var11 = this.drawl(this.rdo, this.newplayers[var67], 18 + 128 * var67, 20 - this.scro, true);
                     } else {
                        this.drawl(this.rdo, this.newplayers[var67], 18 + 128 * var67, 20 - this.scro, false);
                     }

                     if (!var11) {
                        this.rdo.setComposite(AlphaComposite.getInstance(3, 0.2F));
                        this.rdo.setColor(new Color(255, 255, 255));
                        this.rdo.fillRect(18 + 128 * var67, 20 - this.scro, 119, 29);
                        this.rdo.setComposite(AlphaComposite.getInstance(3, 1.0F));
                        this.rdo.setColor(new Color(0, 0, 0));
                        this.rdo.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rdo.getFontMetrics();
                        this.rdo.drawRect(18 + 128 * var67, 20 - this.scro, 119, 29);
                        this.rdo.drawString(this.newplayers[var67], 78 + 128 * var67 - this.ftm.stringWidth(this.newplayers[var67]) / 2, 39 - this.scro);
                     }
                  }
               }

               if (75 + 35 * var9 - this.scro > 0) {
                  this.rdo.setFont(new Font("Tahoma", 1, 11));
                  this.rdo.setColor(new Color(0, 0, 0));
                  this.rdo.drawString("Recent clan wars & battles:", 18, 70 - this.scro);
                  var9 = 0;

                  for (int var68 = 0; var68 < 5; var68++) {
                     if (this.nwarbs[var68] > 0) {
                        this.rdo.setComposite(AlphaComposite.getInstance(3, 0.2F));
                        boolean var82 = false;
                        var82 = this.drawl(this.rdo, "#" + this.nwclan[var68] + "#", 18, 75 - this.scro + 35 * var9, true);
                        if (!var82) {
                           this.rdo.setColor(new Color(255, 255, 255));
                           this.rdo.fillRect(18, 75 - this.scro + 35 * var9, 350, 30);
                        }

                        this.rdo.setComposite(AlphaComposite.getInstance(3, 0.1F));
                        this.rdo.setColor(new Color(255, 255, 255));
                        this.rdo.fillRect(368, 75 - this.scro + 35 * var9, 154, 30);
                        this.rdo.setComposite(AlphaComposite.getInstance(3, 1.0F));
                        this.rdo.setColor(new Color(0, 0, 0));
                        this.rdo.setFont(new Font("Tahoma", 1, 11));
                        String var95 = "war";
                        if (this.nwarbs[var68] == 2) {
                           var95 = "car battle";
                        }

                        if (this.nwarbs[var68] == 3) {
                           var95 = "stage battle";
                        }

                        String var13 = "" + this.nwclan[var68] + " defeated " + this.nlclan[var68] + " in a " + var95 + "!";
                        this.rdo.drawString(var13, 22, 87 - this.scro + 35 * var9);
                        this.tlink(this.rdo, 22, 87 - this.scro + 35 * var9, var13, this.nwclan[var68], var1, var2, var3, 216, 139, 1, this.nwclan[var68], "");
                        this.tlink(this.rdo, 22, 87 - this.scro + 35 * var9, var13, this.nlclan[var68], var1, var2, var3, 216, 139, 1, this.nlclan[var68], "");
                        if (this.nwarbs[var68] == 1 && this.nwinp[var68] != -1 && this.nlosp[var68] != -1) {
                           if (this.nwinob[var68].equals("champ")) {
                              String var14 = "" + this.nwclan[var68] + " has taken the clan wars world championship title!";
                              this.rdo.setFont(new Font("Tahoma", 0, 11));
                              this.rdo.drawString(var14, 22, 100 - this.scro + 35 * var9);
                              this.tlink(
                                 this.rdo, 22, 100 - this.scro + 35 * var9, var14, "clan wars world championship title", var1, var2, var3, 216, 139, 5, "", ""
                              );
                           } else if (this.nwinob[var68].equals("re-champ")) {
                              String var116 = "" + this.nwclan[var68] + " has defended and re-claimed the clan wars world championship title!";
                              this.rdo.setFont(new Font("Tahoma", 0, 11));
                              this.rdo.drawString(var116, 22, 100 - this.scro + 35 * var9);
                              this.tlink(
                                 this.rdo, 22, 100 - this.scro + 35 * var9, var116, "clan wars world championship title", var1, var2, var3, 216, 139, 5, "", ""
                              );
                           } else {
                              String var117 = ""
                                 + this.nwclan[var68]
                                 + " won: [ "
                                 + this.nwinp[var68]
                                 + " points ]  & "
                                 + this.nlclan[var68]
                                 + " lost: [ "
                                 + this.nlosp[var68]
                                 + " points ]";
                              this.rdo.setFont(new Font("Tahoma", 0, 11));
                              this.rdo.drawString(var117, 22, 100 - this.scro + 35 * var9);
                              this.tlink(
                                 this.rdo, 22, 100 - this.scro + 35 * var9, var117, "" + this.nwinp[var68] + " points", var1, var2, var3, 216, 139, 5, "", ""
                              );
                              this.tlink(
                                 this.rdo, 22, 100 - this.scro + 35 * var9, var117, "" + this.nlosp[var68] + " points", var1, var2, var3, 216, 139, 5, "", ""
                              );
                           }
                        }

                        if (this.nwarbs[var68] == 2) {
                           String var118 = "" + this.nwclan[var68] + " took car [" + this.nwinob[var68] + "] from " + this.nlclan[var68] + ".";
                           this.rdo.setFont(new Font("Tahoma", 0, 11));
                           this.rdo.drawString(var118, 22, 100 - this.scro + 35 * var9);
                           this.tlink(
                              this.rdo,
                              22,
                              100 - this.scro + 35 * var9,
                              var118,
                              this.nwinob[var68],
                              var1,
                              var2,
                              var3,
                              216,
                              139,
                              3,
                              this.nwinob[var68],
                              this.nwclan[var68]
                           );
                        }

                        if (this.nwarbs[var68] == 3) {
                           String var119 = this.nwinob[var68];
                           if (var119.length() > 20) {
                              var119 = "" + var119.substring(0, 20) + "...";
                           }

                           String var15 = "" + this.nwclan[var68] + " took stage [" + var119 + "] from " + this.nlclan[var68] + ".";
                           this.rdo.setFont(new Font("Tahoma", 0, 11));
                           this.rdo.drawString(var15, 22, 100 - this.scro + 35 * var9);
                           this.tlink(
                              this.rdo, 22, 100 - this.scro + 35 * var9, var15, var119, var1, var2, var3, 216, 139, 4, this.nwinob[var68], this.nwclan[var68]
                           );
                        }

                        this.rdo.setColor(new Color(98, 76, 29));
                        this.rdo.setFont(new Font("Tahoma", 0, 11));
                        this.ftm = this.rdo.getFontMetrics();
                        this.rdo.drawString(this.nwtime[var68], 518 - this.ftm.stringWidth(this.nwtime[var68]), 87 - this.scro + 35 * var9);
                        var9++;
                     }
                  }

                  if (var9 == 0) {
                     this.rdo.setColor(new Color(0, 0, 0));
                     this.rdo.setFont(new Font("Tahoma", 0, 11));
                     this.ftm = this.rdo.getFontMetrics();
                     this.rdo
                        .drawString(
                           "(No recent clan wars or battles have been played yet...)",
                           280 - this.ftm.stringWidth("(No recent clan wars or battles have been played yet...)") / 2,
                           91 - this.scro
                        );
                     var9 = 1;
                  }
               }

               int var69 = 70 + 35 * var9 - this.scro;
               if (var69 + 25 > 0) {
                  this.rdo.setFont(new Font("Tahoma", 1, 11));
                  this.rdo.setColor(new Color(0, 0, 0));
                  this.rdo.drawString("Recent clan activity:", 18, var69 + 20);
               }

               boolean var84 = false;
               String var96 = "";
               this.doi = 0;

               for (int var108 = 0; var108 < this.il; var108++) {
                  if (!this.text[var108].equals(var96)) {
                     if (!var84) {
                        var84 = true;
                     } else {
                        var84 = false;
                     }

                     if (var69 + this.doi * 16 + 38 > 0 && var69 + this.doi * 16 + 18 < 300) {
                        if (var84) {
                           this.rdo.setComposite(AlphaComposite.getInstance(3, 0.1F));
                           this.rdo.setColor(new Color(255, 255, 255));
                           this.rdo.fillRect(18, var69 + this.doi * 16 + 24, 504, 16);
                           this.rdo.setComposite(AlphaComposite.getInstance(3, 1.0F));
                        }

                        this.rdo.setFont(new Font("Tahoma", 0, 11));
                        this.ftm = this.rdo.getFontMetrics();
                        if (this.text[var108].startsWith("Battle")) {
                           this.rdo.setFont(new Font("Tahoma", 1, 11));
                        } else {
                           this.rdo.setColor(new Color(98, 76, 29));
                           this.rdo.drawString(this.nttime[var108], 518 - this.ftm.stringWidth(this.nttime[var108]), var69 + this.doi * 16 + 36);
                        }

                        if (this.text[var108].indexOf("started") != -1) {
                           this.rdo.setFont(new Font("Tahoma", 1, 11));
                           if (this.text[var108].indexOf("war") == -1) {
                              if (!var84) {
                                 var84 = true;
                              } else {
                                 var84 = false;
                              }
                           }
                        }

                        if (this.text[var108].indexOf("clan wars world champion") != -1) {
                           this.rdo.setFont(new Font("Tahoma", 1, 11));
                           if (!var84) {
                              var84 = true;
                           } else {
                              var84 = false;
                           }
                        }

                        this.rdo.setColor(new Color(0, 0, 0));
                        this.rdo.drawString(this.text[var108], 22, var69 + this.doi * 16 + 36);

                        for (int var120 = 0; var120 < this.nln[var108]; var120++) {
                           this.tlink(
                              this.rdo,
                              22,
                              var69 + this.doi * 16 + 36,
                              this.text[var108],
                              this.link[var108][var120][0],
                              var1,
                              var2,
                              var3,
                              216,
                              139,
                              this.getvalue(this.link[var108][var120][1], 0),
                              this.getSvalue(this.link[var108][var120][1], 1),
                              this.getSvalue(this.link[var108][var120][1], 2)
                           );
                        }
                     }

                     var96 = this.text[var108];
                     this.doi++;
                  }
               }
            } else {
               this.sdist = 0;
            }

            if (this.loadednews == 0) {
               this.rdo.setFont(new Font("Tahoma", 1, 11));
               this.ftm = this.rdo.getFontMetrics();
               this.rdo.setColor(new Color(0, 0, 0));
               this.rdo.drawString("Loading game news, please wait...", 280 - this.ftm.stringWidth("Loading game news, please wait...") / 2, 140);
            }

            if (this.loadednews == -1) {
               this.rdo.setFont(new Font("Tahoma", 1, 11));
               this.ftm = this.rdo.getFontMetrics();
               this.rdo.setColor(new Color(0, 0, 0));
               this.rdo
                  .drawString(
                     "Failed to load game news, please try again later...",
                     280 - this.ftm.stringWidth("Failed to load game news, please try again later...") / 2,
                     140
                  );
            }
         }

         if (this.ntab == 1) {
            this.darker = true;
            if (this.stringbutton(this.rd, "  About Championship  ", 617, 125, 3, var1, var2, var3, 0, 0)) {
               this.ntab = 2;
            }

            this.darker = false;
            if (this.loadwstat == 1) {
               if (this.eng == -1) {
                  int var48 = this.ncc;
                  if (this.champ >= 0) {
                     var48--;
                  }

                  if (var48 < 0) {
                     var48 = 0;
                  }

                  this.sdist = 154 + var48 * 45 - 260;
                  if (this.sdist < 0) {
                     this.sdist = 0;
                  }

                  this.scro = (int)(this.spos6 / 229.0F * this.sdist);
                  this.rdo.setFont(new Font("Tahoma", 1, 11));
                  this.ftm = this.rdo.getFontMetrics();
                  int var70 = this.ftm.stringWidth("Engagement Stats");
                  this.rdo.setColor(new Color(0, 0, 0));
                  this.rdo.drawString("Current World Champion", 10, 20 - this.scro);
                  this.rdo.setColor(new Color(228, 177, 31));
                  this.rdo.fillRoundRect(10, 28 - this.scro, 520, 70, 20, 20);
                  this.rdo.setColor(new Color(199, 154, 63));
                  this.rdo.fillRoundRect(13, 33 - this.scro, 514, 60, 20, 20);
                  this.rdo.setColor(new Color(255, 198, 0));
                  this.rdo.drawRoundRect(13, 33 - this.scro, 514, 60, 20, 20);
                  this.rdo.setColor(new Color(0, 0, 0));
                  this.rdo.drawRoundRect(10, 28 - this.scro, 520, 70, 20, 20);
                  if (this.champ == -1) {
                     this.rdo.setFont(new Font("Tahoma", 0, 11));
                     this.ftm = this.rdo.getFontMetrics();
                     this.rdo
                        .drawString(
                           "No current world champion because no contender has attained or surpassed 3 points yet!",
                           270 - this.ftm.stringWidth("No current world champion because no contender has attained or surpassed 3 points yet!") / 2,
                           65 - this.scro
                        );
                  }

                  if (this.champ == -2) {
                     this.rdo.setFont(new Font("Tahoma", 0, 11));
                     this.ftm = this.rdo.getFontMetrics();
                     this.rdo
                        .drawString(
                           "No current world champion at this moment because the top contenders are tied in points!",
                           270 - this.ftm.stringWidth("No current world champion at this moment because the top contenders are tied in points!") / 2,
                           65 - this.scro
                        );
                  }

                  if (this.champ >= 0) {
                     if (!this.drawl(this.rdo, "#" + this.conclan[this.champ] + "#", 21, 40 - this.scro, true)) {
                        this.rdo.setColor(new Color(100, 77, 31));
                        this.rdo.drawRect(21, 40 - this.scro, 349, 29);
                        this.rdo.setFont(new Font("Arial", 1, 13));
                        this.ftm = this.rdo.getFontMetrics();
                        this.rdo.drawString(this.conclan[this.champ], 196 - this.ftm.stringWidth(this.conclan[this.champ]) / 2, 59 - this.scro);
                     }

                     if (var1 > 237 && var1 < 587 && var2 > 179 - this.scro && var2 < 209 - this.scro && var2 > 139 && var2 < 439) {
                        this.cur = 12;
                        if (var3) {
                           if (!this.claname.equals(this.conclan[this.champ])) {
                              this.claname = this.conclan[this.champ];
                              this.loadedc = false;
                           }

                           this.spos5 = 0;
                           this.lspos5 = 0;
                           this.cfase = 3;
                           this.ctab = 0;
                        }
                     }

                     this.rdo.setFont(new Font("Tahoma", 0, 11));
                     this.rdo.setColor(new Color(0, 0, 0));
                     this.rdo
                        .drawString(
                           "" + this.conclan[this.champ] + " is leading the championship by " + this.leadsby + " points difference from the first contender!",
                           22,
                           85 - this.scro
                        );
                     this.rdo.setFont(new Font("Tahoma", 1, 11));
                     this.rdo.drawString("Attained points:  [ " + this.totp[this.champ] + " ]", 383, 51 - this.scro);
                     this.rdo.drawString("Engagement Stats", 383, 66 - this.scro);
                     this.rdo.drawLine(383, 68 - this.scro, 383 + var70, 68 - this.scro);
                     if (var1 > 599 && var1 < 383 + var70 + 216 && var2 > 195 - this.scro && var2 < 208 - this.scro && var2 > 139 && var2 < 439) {
                        this.cur = 12;
                        if (var3) {
                           this.eng = this.champ;
                           this.engo = 40 - this.scro;
                           this.lspos6w = this.spos6;
                           this.spos6 = 0;
                        }
                     }
                  }

                  this.rdo.setColor(new Color(0, 0, 0));
                  this.rdo.setFont(new Font("Tahoma", 1, 11));
                  this.ftm = this.rdo.getFontMetrics();
                  this.rdo.drawString("Contenders", 10, 125 - this.scro);
                  if (var48 > 3) {
                     var48 = 160 + 45 * (var48 - 3);
                  } else {
                     var48 = 160;
                  }

                  this.rdo.drawRoundRect(10, 133 - this.scro, 520, var48, 20, 20);
                  if (this.ncc != 0 && (this.ncc != 1 || this.champ != 0)) {
                     this.rdo.setFont(new Font("Tahoma", 0, 11));
                     this.ftm = this.rdo.getFontMetrics();
                     this.rdo.setColor(new Color(0, 0, 0));
                     this.rdo
                        .drawString(
                           "To become a contender, a clan must get points by winning a war against any other clan.",
                           270 - this.ftm.stringWidth("To become a contender, a clan must get points by winning a war against any other clan.") / 2,
                           147 - this.scro
                        );
                     int var85 = 0;

                     for (int var97 = 0; var97 < this.ncc; var97++) {
                        if (this.ord[var97] != this.champ) {
                           this.rdo.setColor(new Color(199, 154, 63));
                           this.rdo.fillRect(11, 154 + var85 * 45 - this.scro, 519, 40);
                           if (!this.drawl(this.rdo, "#" + this.conclan[this.ord[var97]] + "#", 21, 159 + var85 * 45 - this.scro, true)) {
                              this.rdo.setColor(new Color(100, 77, 31));
                              this.rdo.drawRect(21, 159 + var85 * 45 - this.scro, 349, 29);
                              this.rdo.setFont(new Font("Arial", 1, 13));
                              this.ftm = this.rdo.getFontMetrics();
                              this.rdo
                                 .drawString(
                                    this.conclan[this.ord[var97]], 196 - this.ftm.stringWidth(this.conclan[this.ord[var97]]) / 2, 178 + var85 * 45 - this.scro
                                 );
                           }

                           if (var1 > 237
                              && var1 < 587
                              && var2 > 159 + var85 * 45 + 139 - this.scro
                              && var2 < 189 + var85 * 45 + 139 - this.scro
                              && var2 > 139
                              && var2 < 439) {
                              this.cur = 12;
                              if (var3) {
                                 if (!this.claname.equals(this.conclan[this.ord[var97]])) {
                                    this.claname = this.conclan[this.ord[var97]];
                                    this.loadedc = false;
                                 }

                                 this.spos5 = 0;
                                 this.lspos5 = 0;
                                 this.cfase = 3;
                                 this.ctab = 0;
                              }
                           }

                           this.rdo.setColor(new Color(0, 0, 0));
                           this.rdo.setFont(new Font("Tahoma", 1, 11));
                           this.rdo.drawString("Attained points:  [ " + this.totp[this.ord[var97]] + " ]", 383, 170 + var85 * 45 - this.scro);
                           this.rdo.drawString("Engagement Stats", 383, 185 + var85 * 45 - this.scro);
                           this.rdo.drawLine(383, 187 + var85 * 45 - this.scro, 383 + var70, 187 + var85 * 45 - this.scro);
                           if (var1 > 599
                              && var1 < 383 + var70 + 216
                              && var2 > 175 + var85 * 45 + 139 - this.scro
                              && var2 < 188 + var85 * 45 + 139 - this.scro
                              && var2 > 139
                              && var2 < 439) {
                              this.cur = 12;
                              if (var3) {
                                 this.eng = this.ord[var97];
                                 this.engo = 159 + var85 * 45 - this.scro;
                                 this.lspos6w = this.spos6;
                                 this.spos6 = 0;
                              }
                           }

                           var85++;
                        }
                     }
                  } else {
                     this.rdo.drawString("No contenders...", 270 - this.ftm.stringWidth("No contenders...") / 2, 160 - this.scro);
                     this.rdo.setFont(new Font("Tahoma", 0, 11));
                     this.ftm = this.rdo.getFontMetrics();
                     this.rdo.setColor(new Color(0, 0, 0));
                     this.rdo
                        .drawString(
                           "To become a contender, a clan must get points by winning a war against any other clan.",
                           270 - this.ftm.stringWidth("To become a contender, a clan must get points by winning a war against any other clan.") / 2,
                           185 - this.scro
                        );
                  }
               } else {
                  if (this.engo == 15) {
                     this.sdist = 87 + this.ados + this.nvc[this.eng] * 17 - 260;
                     if (this.sdist < 0) {
                        this.sdist = 0;
                     }

                     this.scro = (int)(this.spos6 / 229.0F * this.sdist);
                     this.ados = 0;
                     this.rdo.setFont(new Font("Tahoma", 1, 11));
                     this.rdo.setColor(new Color(0, 0, 0));
                     this.rdo.drawString("Engagement Stats", 385, 40 - this.scro);
                     String var50 = "s";
                     if (!this.xt.clan.equals("") && !this.xt.clan.toLowerCase().equals(this.conclan[this.eng].toLowerCase())) {
                        this.ados = 116;
                        int var71 = -1;
                        int var86 = 0;

                        for (int var98 = 0; var98 < this.ncc; var98++) {
                           if (this.xt.clan.toLowerCase().equals(this.conclan[var98].toLowerCase())) {
                              var86 = this.totp[var98];
                              var71 = var98;
                              break;
                           }
                        }

                        int var99 = this.totp[this.eng] + 1;
                        int var109 = var86 + 1;
                        if (var109 > this.totp[this.eng]) {
                           var109 = this.totp[this.eng];
                        }

                        if (var71 != -1) {
                           for (int var121 = 0; var121 < this.nvc[var71]; var121++) {
                              if (this.conclan[this.eng].toLowerCase().equals(this.verclan[var71][var121].toLowerCase())) {
                                 var99 -= this.points[var71][var121];
                                 if (var99 < 0) {
                                    var99 = 0;
                                 }
                                 break;
                              }
                           }
                        }

                        this.rdo.setFont(new Font("Tahoma", 1, 11));
                        this.rdo.setColor(new Color(0, 0, 0));
                        this.rdo.drawString("If your clan " + this.xt.clan + " engages & defeats " + this.conclan[this.eng] + " in a war:", 27, 70 - this.scro);
                        this.rdo.setFont(new Font("Tahoma", 0, 11));
                        var50 = "s";
                        if (var99 == 1) {
                           var50 = "";
                        }

                        this.rdo.drawString("- Your clan will get:  [ " + var99 + " point" + var50 + " ]", 47, 87 - this.scro);
                        var50 = "s";
                        if (var109 == 1) {
                           var50 = "";
                        }

                        this.rdo.drawString("- " + this.conclan[this.eng] + " will lose:  [ " + var109 + " point" + var50 + " ]", 47, 104 - this.scro);
                        if (var99 + var86 > 3
                           && var99 + var86 > this.totp[this.ord[0]]
                           && !this.xt.clan.toLowerCase().equals(this.conclan[this.ord[0]].toLowerCase())) {
                           if (this.frkl) {
                              this.rdo.setColor(new Color(0, 0, 0));
                              this.frkl = false;
                           } else {
                              this.rdo.setColor(new Color(106, 80, 0));
                              this.frkl = true;
                           }

                           if (this.champ >= 0) {
                              this.rdo.drawString("- Your clan would take the championship title from " + this.conclan[this.champ] + " !", 47, 121 - this.scro);
                           } else {
                              this.rdo.drawString("- Your clan would take the champion ship title!", 42, 121 - this.scro);
                           }

                           this.ados += 17;
                        }

                        this.rdo.setColor(new Color(0, 0, 0));
                        var99 = var86 + 1;
                        var109 = this.totp[this.eng] + 1;
                        if (var109 > var86) {
                           var109 = var86;
                        }

                        for (int var122 = 0; var122 < this.nvc[this.eng]; var122++) {
                           if (this.xt.clan.toLowerCase().equals(this.verclan[this.eng][var122].toLowerCase())) {
                              var99 -= this.points[this.eng][var122];
                              if (var99 < 0) {
                                 var99 = 0;
                              }
                              break;
                           }
                        }

                        this.rdo.setFont(new Font("Tahoma", 1, 11));
                        this.rdo.setColor(new Color(0, 0, 0));
                        this.rdo.drawString("If your clan loses a war against " + this.conclan[this.eng] + ":", 27, 12 + this.ados - this.scro);
                        this.rdo.setFont(new Font("Tahoma", 0, 11));
                        var50 = "s";
                        if (var109 == 1) {
                           var50 = "";
                        }

                        this.rdo.drawString("- Your clan will lose:  [ " + var109 + " point" + var50 + " ]", 47, 29 + this.ados - this.scro);
                        var50 = "s";
                        if (var99 == 1) {
                           var50 = "";
                        }

                        this.rdo.drawString("- " + this.conclan[this.eng] + " will get:  [ " + var99 + " point" + var50 + " ]", 47, 46 + this.ados - this.scro);
                     }

                     this.rdo.setFont(new Font("Tahoma", 1, 11));
                     this.rdo.setColor(new Color(0, 0, 0));
                     this.rdo.drawString("" + this.conclan[this.eng] + " has attained its points from clan wars:", 27, 70 + this.ados - this.scro);
                     this.rdo.setFont(new Font("Tahoma", 0, 11));

                     for (int var72 = 0; var72 < this.nvc[this.eng]; var72++) {
                        var50 = "s";
                        if (this.points[this.eng][var72] == 1) {
                           var50 = "";
                        }

                        this.rdo
                           .drawString(
                              "Versus clan " + this.verclan[this.eng][var72] + ":  [ " + this.points[this.eng][var72] + " point" + var50 + " ]",
                              47,
                              87 + this.ados + var72 * 17 - this.scro
                           );
                     }

                     this.rdo.setFont(new Font("Tahoma", 1, 11));
                     this.rdo.setColor(new Color(0, 0, 0));
                     this.rdo.drawString("Total attained points:  [ " + this.totp[this.eng] + " ]", 47, 87 + this.ados + this.nvc[this.eng] * 17 - this.scro);
                  } else if (Math.abs(this.engo - 15) < 20) {
                     this.engo = 15;
                  } else if (this.engo < 15) {
                     this.engo += 20;
                  } else {
                     this.engo -= 20;
                  }

                  if (!this.drawl(this.rdo, "#" + this.conclan[this.eng] + "#", 21, this.engo - this.scro, true)) {
                     this.rdo.setColor(new Color(100, 77, 31));
                     this.rdo.drawRect(21, this.engo - this.scro, 349, 29);
                     this.rdo.setFont(new Font("Arial", 1, 13));
                     this.ftm = this.rdo.getFontMetrics();
                     this.rdo.drawString(this.conclan[this.champ], 196 - this.ftm.stringWidth(this.conclan[this.champ]) / 2, this.engo + 19 - this.scro);
                  }

                  if (this.engo == 15) {
                     this.darker = true;
                     if (!this.xt.clan.equals("")
                        && !this.xt.clan.toLowerCase().equals(this.conclan[this.eng].toLowerCase())
                        && this.stringbutton(this.rdo, "   Declare War  >   ", 459, 176, 1, var1, var2, var3, 216, 139)) {
                        this.tab = 2;
                        this.itab = 1;
                        this.litab = -1;
                        this.openi = 10;
                        this.viewgame2 = 0;
                        if (!this.intclan.equals(this.conclan[this.eng])) {
                           this.intclan = this.conclan[this.eng];
                           this.dispi = 0;
                           this.nil = 0;
                           this.lastint = "";
                           this.readint = 1;
                        }

                        this.redif = true;
                        this.intsel = 4;
                        this.eng = -1;
                        this.spos6 = this.lspos6w;
                     }

                     if (this.stringbutton(this.rdo, "   <  Back   ", 480, 110, 1, var1, var2, var3, 216, 139)) {
                        this.eng = -1;
                        this.spos6 = this.lspos6w;
                     }

                     this.darker = false;
                  }
               }
            } else {
               this.sdist = 0;
            }

            if (this.loadwstat == 0) {
               this.rdo.setFont(new Font("Tahoma", 1, 11));
               this.ftm = this.rdo.getFontMetrics();
               this.rdo.setColor(new Color(0, 0, 0));
               this.rdo.drawString("Loading championship, please wait...", 280 - this.ftm.stringWidth("Loading championship, please wait...") / 2, 140);
            }

            if (this.loadwstat == -1) {
               this.rdo.setFont(new Font("Tahoma", 1, 11));
               this.ftm = this.rdo.getFontMetrics();
               this.rdo.setColor(new Color(0, 0, 0));
               this.rdo
                  .drawString(
                     "Failed to load championship, please try again later...",
                     280 - this.ftm.stringWidth("Failed to load championship, please try again later...") / 2,
                     140
                  );
            }
         }

         if (this.ntab == 2) {
            this.rdo.setFont(new Font("Tahoma", 1, 11));
            this.ftm = this.rdo.getFontMetrics();
            this.rdo.setColor(new Color(0, 0, 0));
            this.rdo.drawString("About the Championship", 280 - this.ftm.stringWidth("About the Championship") / 2, 40);
            this.rdo.setFont(new Font("Tahoma", 0, 11));
            this.rdo.drawString("The clan wars world championship is ongoing championship that does not end!", 7, 70);
            this.rdo.drawString("Every clan always has a chance to claim & re-claim the championship title from the current winner.", 7, 85);
            this.rdo.drawString("The champion clan is the clan that is at the current moment attaining the most points.", 7, 115);
            this.rdo.drawString("Clans get points by defeating other clans in wars, but not every clan you defeat earns you the same amount of", 7, 130);
            this.rdo.drawString("points. It depends on how much points that clan has and from which wars where these points attained.", 7, 145);
            this.rdo.drawString("The points system is designed to deliver a fair & balanced championship that is also fun, exiting and never ending!", 7, 160);
            this.rdo.setFont(new Font("Tahoma", 1, 11));
            this.rdo.drawString("Currently there are no rewards in the game for claiming or re-claiming the championship title, but", 7, 190);
            this.rdo.drawString("in the coming updates there will be rewards that can be used to 'super power' clan cars!", 7, 205);
            this.rdo.setFont(new Font("Tahoma", 0, 11));
            this.rdo.drawString("Stay tuned for the rewards system to come!", 7, 220);
            this.rdo.setFont(new Font("Tahoma", 1, 11));
            this.ftm = this.rdo.getFontMetrics();
            this.rdo.drawString("Good Luck!", 280 - this.ftm.stringWidth("Good Luck!") / 2, 250);
            this.darker = true;
            if (this.stringbutton(this.rdo, "   <  Back   ", 280, 280, 1, var1, var2, var3, 216, 139)) {
               this.ntab = 1;
            }

            this.darker = false;
         }

         if (this.sdist != 0) {
            byte var56 = 27;
            this.rdo.setColor(this.color2k(200, 200, 200));
            this.rdo.fillRect(540, 20, 17, 260);
            if (this.mscro5 == 831) {
               this.rdo.setColor(this.color2k(215, 215, 215));
               this.rdo.fillRect(540, 3, 17, 17);
            } else {
               this.rdo.setColor(this.color2k(220, 220, 220));
               this.rdo.fill3DRect(540, 3, 17, 17, true);
            }

            this.rdo.drawImage(this.xt.asu, 545, 9, null);
            if (this.mscro5 == 832) {
               this.rdo.setColor(this.color2k(215, 215, 215));
               this.rdo.fillRect(540, 280, 17, 17);
            } else {
               this.rdo.setColor(this.color2k(220, 220, 220));
               this.rdo.fill3DRect(540, 280, 17, 17, true);
            }

            this.rdo.drawImage(this.xt.asd, 545, 287, null);
            if (this.lspos6 != this.spos6) {
               this.rdo.setColor(this.color2k(215, 215, 215));
               this.rdo.fillRect(540, 20 + this.spos6, 17, 31);
            } else {
               if (this.mscro5 == 831) {
                  this.rdo.setColor(this.color2k(215, 215, 215));
               }

               this.rdo.fill3DRect(540, 20 + this.spos6, 17, 31, true);
            }

            this.rdo.setColor(this.color2k(150, 150, 150));
            this.rdo.drawLine(545, 33 + this.spos6, 551, 33 + this.spos6);
            this.rdo.drawLine(545, 35 + this.spos6, 551, 35 + this.spos6);
            this.rdo.drawLine(545, 37 + this.spos6, 551, 37 + this.spos6);
            if (this.mscro5 > 800 && this.lspos6 != this.spos6) {
               this.lspos6 = this.spos6;
            }

            if (var3) {
               if (this.mscro5 == 825 && var1 > 756 && var1 < 773 && var2 > 132 + var56 + this.spos6 && var2 < this.spos6 + var56 + 163) {
                  this.mscro5 = var2 - this.spos6;
               }

               if (this.mscro5 == 825 && var1 > 754 && var1 < 775 && var2 > 26 + var56 && var2 < 134 + var56) {
                  this.mscro5 = 831;
               }

               if (this.mscro5 == 825 && var1 > 754 && var1 < 775 && var2 > 390 + var56 && var2 < 411 + var56) {
                  this.mscro5 = 832;
               }

               if (this.mscro5 == 825 && var1 > 756 && var1 < 773 && var2 > 132 + var56 && var2 < 392 + var56) {
                  this.mscro5 = 152 + var56;
                  this.spos6 = var2 - this.mscro5;
               }

               int var73 = 2670 / this.sdist;
               if (var73 < 1) {
                  var73 = 1;
               }

               if (this.mscro5 == 831) {
                  this.spos6 -= var73;
                  if (this.spos6 > 229) {
                     this.spos6 = 229;
                  }

                  if (this.spos6 < 0) {
                     this.spos6 = 0;
                  }

                  this.lspos6 = this.spos6;
               }

               if (this.mscro5 == 832) {
                  this.spos6 += var73;
                  if (this.spos6 > 229) {
                     this.spos6 = 229;
                  }

                  if (this.spos6 < 0) {
                     this.spos6 = 0;
                  }

                  this.lspos6 = this.spos6;
               }

               if (this.mscro5 < 800) {
                  this.spos6 = var2 - this.mscro5;
                  if (this.spos6 > 229) {
                     this.spos6 = 229;
                  }

                  if (this.spos6 < 0) {
                     this.spos6 = 0;
                  }
               }

               if (this.mscro5 == 825) {
                  this.mscro5 = 925;
               }
            } else if (this.mscro5 != 825) {
               this.mscro5 = 825;
            }
         }

         this.rd.drawImage(this.gImage, 216, 139, null);
      }

      if (this.cfase == 1) {
         if (this.xt.logged) {
            if (this.xt.clan.equals("")) {
               this.rd.setComposite(AlphaComposite.getInstance(3, 0.4F));
               this.rd.setColor(new Color(255, 255, 255));
               this.rd.fillRoundRect(232, 90, 527, 176, 20, 20);
               this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawRoundRect(232, 90, 527, 176, 20, 20);
               this.rd.setFont(new Font("Arial", 1, 13));
               this.ftm = this.rd.getFontMetrics();
               if (this.flko % 4 != 0 || this.flko == 0) {
                  this.rd.drawString(this.msg, 495 - this.ftm.stringWidth(this.msg) / 2, 120);
               }

               if (this.flko != 0) {
                  this.flko--;
               }

               this.rd.drawString("Clan name :", 462 - this.ftm.stringWidth("Clan name :"), 156);
               this.donewc = true;
               if (this.em != 1) {
                  if (this.stringbutton(this.rd, "     Create     ", 495, 204, 0, var1, var2, var3, 0, 0)) {
                     if (!this.gs.temail.getText().equals("")) {
                        this.em = 1;
                     } else {
                        this.msg = "Please enter a clan name!";
                        this.flko = 45;
                     }
                  }

                  if (this.stringbutton(this.rd, " Cancel ", 495, 244, 2, var1, var2, var3, 0, 0)) {
                     this.cfase = 0;
                  }
               } else {
                  this.rd.drawString("Creating, please wait...", 495 - this.ftm.stringWidth("Creating, please wait...") / 2, 224);
               }
            } else {
               this.rd.setComposite(AlphaComposite.getInstance(3, 0.4F));
               this.rd.setColor(new Color(255, 255, 255));
               this.rd.fillRoundRect(232, 90, 527, 136, 20, 20);
               this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawRoundRect(232, 90, 527, 136, 20, 20);
               this.rd.setFont(new Font("Arial", 1, 13));
               this.ftm = this.rd.getFontMetrics();
               this.rd
                  .drawString(
                     "You are already a member of a clan (" + this.xt.clan + ").",
                     495 - this.ftm.stringWidth("You are already a member of a clan (" + this.xt.clan + ").") / 2,
                     120
                  );
               this.rd
                  .drawString(
                     "You need to leave your clan first in order to create a new one.",
                     495 - this.ftm.stringWidth("You need to leave your clan first in order to create a new one.") / 2,
                     140
                  );
               if (this.stringbutton(this.rd, "   OK   ", 495, 204, 0, var1, var2, var3, 0, 0)) {
                  this.cfase = 0;
               }
            }
         } else {
            this.rd.setComposite(AlphaComposite.getInstance(3, 0.4F));
            this.rd.setColor(new Color(255, 255, 255));
            this.rd.fillRoundRect(232, 90, 527, 176, 20, 20);
            this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawRoundRect(232, 90, 527, 176, 20, 20);
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            this.rd.drawString("You are currently using a trial account.", 495 - this.ftm.stringWidth("You are currently using a trial account.") / 2, 120);
            this.rd
               .drawString(
                  "You need to upgrade to be able participate in any NFM clan activity.",
                  495 - this.ftm.stringWidth("You need to upgrade to be able participate in any NFM clan activity.") / 2,
                  140
               );
            this.rd.setColor(new Color(206, 171, 98));
            this.rd.fillRoundRect(405, 163, 180, 50, 20, 20);
            if (this.drawbutton(this.xt.upgrade, 495, 188, var1, var2, var3)) {
               this.gs.editlink(this.xt.nickname, true);
            }

            if (this.stringbutton(this.rd, " Cancel ", 495, 244, 2, var1, var2, var3, 0, 0)) {
               this.cfase = 0;
            }
         }
      }

      if (this.cfase == 2) {
         this.rd.setColor(new Color(0, 0, 0));
         this.rd.setFont(new Font("Arial", 1, 13));
         this.ftm = this.rd.getFontMetrics();
         if (this.flko % 4 != 0 || this.flko == 0) {
            this.rd.drawString(this.msg, 495 - this.ftm.stringWidth(this.msg) / 2, 60);
         }

         if (this.flko != 0) {
            this.flko--;
         }

         this.rd.setComposite(AlphaComposite.getInstance(3, 0.2F));
         this.rd.setColor(new Color(255, 255, 255));
         this.rd.fillRoundRect(197, 73, 597, 371, 20, 20);
         this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
         this.rd.setColor(new Color(0, 0, 0));
         this.rd.drawRoundRect(197, 73, 597, 371, 20, 20);
         this.dosrch = true;
         this.darker = true;
         if (this.stringbutton(this.rd, "   Search   ", 579, 104, 2, var1, var2, var3, 0, 0)) {
            if (!this.gs.temail.getText().equals("")) {
               this.em = 2;
               this.smsg = "Searching for '" + this.gs.temail.getText() + "' in clans...";
               this.nclns = 0;
               this.spos5 = 0;
               this.lspos5 = 0;
            } else {
               this.msg = "Please enter a search phrase!";
               this.flko = 45;
            }
         }

         this.rd.setColor(new Color(0, 0, 0));
         this.rd.setFont(new Font("Arial", 1, 13));
         this.rd.drawString(this.smsg, 218, 135);
         if (this.stringbutton(this.rd, " <   Back to Main  ", 725, 60, 2, var1, var2, var3, 0, 0)) {
            this.cfase = 0;
         }

         this.darker = false;
         this.rdo.setColor(new Color(206, 171, 98));
         this.rdo.fillRect(0, 0, 560, 300);
         this.sdist = (int)((this.nclns - 4.5F) * 55.0F);
         if (this.sdist < 0 || this.nclns == 0) {
            this.sdist = 0;
         }

         this.scro = (int)(this.spos5 / 229.0F * this.sdist);
         this.rdo.setFont(new Font("Arial", 1, 13));
         this.ftm = this.rd.getFontMetrics();

         for (int var20 = 0; var20 < this.nclns; var20++) {
            if (60 + var20 * 55 - this.scro > 0 && 20 + var20 * 55 - this.scro < 300) {
               boolean var24 = true;
               if (var1 > 308 && var1 < 683 && var2 > 159 + var20 * 55 - this.scro && var2 < 199 + var20 * 55 - this.scro) {
                  this.cur = 12;
                  var24 = false;
                  if (var3) {
                     if (!this.claname.equals(this.clanlo[var20])) {
                        this.claname = this.clanlo[var20];
                        this.loadedc = false;
                     }

                     this.spos5 = 0;
                     this.lspos5 = 0;
                     this.cfase = 3;
                     this.ctab = 0;
                  }
               }

               this.rdo.setColor(new Color(0, 0, 0));
               this.rdo.drawRoundRect(92, 20 + var20 * 55 - this.scro, 375, 40, 20, 20);
               if (!this.drawl(this.rdo, "#" + this.clanlo[var20] + "#", 105, 25 + var20 * 55 - this.scro, var24) || !var24) {
                  this.rdo.drawString("" + this.clanlo[var20] + "", 280 - this.ftm.stringWidth("" + this.clanlo[var20] + "") / 2, 45 + var20 * 55 - this.scro);
               }
            }
         }

         if (this.sdist != 0) {
            byte var21 = 27;
            this.rdo.setColor(this.color2k(200, 200, 200));
            this.rdo.fillRect(540, 20, 17, 260);
            if (this.mscro5 == 831) {
               this.rdo.setColor(this.color2k(215, 215, 215));
               this.rdo.fillRect(540, 3, 17, 17);
            } else {
               this.rdo.setColor(this.color2k(220, 220, 220));
               this.rdo.fill3DRect(540, 3, 17, 17, true);
            }

            this.rdo.drawImage(this.xt.asu, 545, 9, null);
            if (this.mscro5 == 832) {
               this.rdo.setColor(this.color2k(215, 215, 215));
               this.rdo.fillRect(540, 280, 17, 17);
            } else {
               this.rdo.setColor(this.color2k(220, 220, 220));
               this.rdo.fill3DRect(540, 280, 17, 17, true);
            }

            this.rdo.drawImage(this.xt.asd, 545, 287, null);
            if (this.lspos5 != this.spos5) {
               this.rdo.setColor(this.color2k(215, 215, 215));
               this.rdo.fillRect(540, 20 + this.spos5, 17, 31);
            } else {
               if (this.mscro5 == 831) {
                  this.rdo.setColor(this.color2k(215, 215, 215));
               }

               this.rdo.fill3DRect(540, 20 + this.spos5, 17, 31, true);
            }

            this.rdo.setColor(this.color2k(150, 150, 150));
            this.rdo.drawLine(545, 33 + this.spos5, 551, 33 + this.spos5);
            this.rdo.drawLine(545, 35 + this.spos5, 551, 35 + this.spos5);
            this.rdo.drawLine(545, 37 + this.spos5, 551, 37 + this.spos5);
            if (this.mscro5 > 800 && this.lspos5 != this.spos5) {
               this.lspos5 = this.spos5;
            }

            if (var3) {
               if (this.mscro5 == 825 && var1 > 756 && var1 < 773 && var2 > 132 + var21 + this.spos5 && var2 < this.spos5 + var21 + 163) {
                  this.mscro5 = var2 - this.spos5;
               }

               if (this.mscro5 == 825 && var1 > 754 && var1 < 775 && var2 > 26 + var21 && var2 < 134 + var21) {
                  this.mscro5 = 831;
               }

               if (this.mscro5 == 825 && var1 > 754 && var1 < 775 && var2 > 390 + var21 && var2 < 411 + var21) {
                  this.mscro5 = 832;
               }

               if (this.mscro5 == 825 && var1 > 756 && var1 < 773 && var2 > 132 + var21 && var2 < 392 + var21) {
                  this.mscro5 = 152 + var21;
                  this.spos5 = var2 - this.mscro5;
               }

               int var25 = 2670 / this.sdist;
               if (var25 < 1) {
                  var25 = 1;
               }

               if (this.mscro5 == 831) {
                  this.spos5 -= var25;
                  if (this.spos5 > 229) {
                     this.spos5 = 229;
                  }

                  if (this.spos5 < 0) {
                     this.spos5 = 0;
                  }

                  this.lspos5 = this.spos5;
               }

               if (this.mscro5 == 832) {
                  this.spos5 += var25;
                  if (this.spos5 > 229) {
                     this.spos5 = 229;
                  }

                  if (this.spos5 < 0) {
                     this.spos5 = 0;
                  }

                  this.lspos5 = this.spos5;
               }

               if (this.mscro5 < 800) {
                  this.spos5 = var2 - this.mscro5;
                  if (this.spos5 > 229) {
                     this.spos5 = 229;
                  }

                  if (this.spos5 < 0) {
                     this.spos5 = 0;
                  }
               }

               if (this.mscro5 == 825) {
                  this.mscro5 = 925;
               }
            } else if (this.mscro5 != 825) {
               this.mscro5 = 825;
            }
         }

         this.rd.drawImage(this.gImage, 216, 139, null);
      }

      if (this.cfase == 3) {
         this.rd.setComposite(AlphaComposite.getInstance(3, 0.4F));
         this.rd.setColor(new Color(255, 255, 255));
         this.rd.fillRoundRect(197, 40, 597, 404, 20, 20);
         this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
         this.rd.setColor(new Color(0, 0, 0));
         this.rd.drawRoundRect(197, 40, 597, 404, 20, 20);
         this.rd.setFont(new Font("Arial", 1, 13));
         this.ftm = this.rd.getFontMetrics();
         if (this.loadedc) {
            int var22 = -1;

            for (int var26 = 0; var26 < this.nmb; var26++) {
               if (this.member[var26].toLowerCase().equals(this.xt.nickname.toLowerCase()) && (this.mlevel[var26] == 7 || var26 == 0)) {
                  var22 = var26;
               }
            }

            boolean var27 = false;
            if (var1 > 197 && var1 < 563 && var2 > 40 && var2 < 83 && this.editc == 0) {
               var27 = true;
            }

            boolean var32 = this.drawl(this.rd, "#" + this.claname + "#", 206, 47, !var27);
            if (!var32 || var27) {
               this.rd.drawString("Clan :  " + this.claname + "", 381 - this.ftm.stringWidth("Clan :  " + this.claname + "") / 2, 67);
               if (var22 != -1) {
                  this.rd.setFont(new Font("Arial", 1, 11));
                  this.ftm = this.rd.getFontMetrics();
                  this.rd.drawString("Edit Logo", 505, 74);
                  this.rd.drawLine(505, 76, 505 + this.ftm.stringWidth("Edit Logo"), 76);
                  if (var1 > 505 && var1 < 505 + this.ftm.stringWidth("Edit Logo") && var2 > 62 && var2 < 77 && this.editc == 0) {
                     this.cur = 12;
                     if (var3) {
                        this.editc = 1;
                        this.msg = "Edit Clan's Logo Image";
                        this.flko = 0;
                     }
                  }
               }
            }

            this.rd.drawLine(563, 40, 563, 83);
            this.rd.drawLine(563, 83, 197, 83);
            if (this.stringbutton(this.rd, "   <   Back to Main  ", 688, 69, 1, var1, var2, var3, 0, 0)) {
               this.cfase = 0;
            }

            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            int var37 = 220;
            int var43 = this.ftm.stringWidth("Members");
            if (this.ctab != 0) {
               this.rd.setComposite(AlphaComposite.getInstance(3, 0.6F));
            }

            this.rd.drawString("Members", var37, 107);
            if (this.ctab != 0) {
               this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
            }

            if (var1 > var37 && var1 < var37 + var43 && var2 > 90 && var2 < 109 && this.editc == 0) {
               this.rd.drawLine(var37, 109, var37 + var43, 109);
               this.cur = 12;
               if (var3) {
                  this.ctab = 0;
               }
            }

            var37 += var43 + 20;
            var43 = this.ftm.stringWidth("Cars");
            if (this.ctab != 2) {
               this.rd.setComposite(AlphaComposite.getInstance(3, 0.6F));
            }

            this.rd.drawString("Cars", var37, 107);
            if (this.ctab != 2) {
               this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
            }

            if (var1 > var37 && var1 < var37 + var43 && var2 > 90 && var2 < 109 && this.editc == 0 && !this.notclan) {
               this.rd.drawLine(var37, 109, var37 + var43, 109);
               this.cur = 12;
               if (var3) {
                  this.ctab = 2;
                  this.loadedcars = -1;
               }
            }

            var37 += var43 + 20;
            var43 = this.ftm.stringWidth("Stages");
            if (this.ctab != 3) {
               this.rd.setComposite(AlphaComposite.getInstance(3, 0.6F));
            }

            this.rd.drawString("Stages", var37, 107);
            if (this.ctab != 3) {
               this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
            }

            if (var1 > var37 && var1 < var37 + var43 && var2 > 90 && var2 < 109 && this.editc == 0 && !this.notclan) {
               this.rd.drawLine(var37, 109, var37 + var43, 109);
               this.cur = 12;
               if (var3) {
                  this.ctab = 3;
                  this.loadedstages = -1;
               }
            }

            var37 += var43 + 20;
            var43 = this.ftm.stringWidth("Interact");
            if (this.ctab != 1) {
               this.rd.setComposite(AlphaComposite.getInstance(3, 0.6F));
            }

            this.rd.drawString("Interact", var37, 107);
            if (this.ctab != 1) {
               this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
            }

            if (var1 > var37 && var1 < var37 + var43 && var2 > 90 && var2 < 109 && this.editc == 0 && !this.notclan) {
               this.rd.drawLine(var37, 109, var37 + var43, 109);
               this.cur = 12;
               if (var3) {
                  this.ctab = 1;
               }
            }

            var37 += var43 + 20;
            var43 = this.ftm.stringWidth("Web Presence");
            if (this.ctab != 4) {
               this.rd.setComposite(AlphaComposite.getInstance(3, 0.6F));
            }

            this.rd.drawString("Web Presence", var37, 107);
            if (this.ctab != 4) {
               this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
            }

            if (var1 > var37 && var1 < var37 + var43 && var2 > 90 && var2 < 109 && this.editc == 0 && !this.notclan) {
               this.rd.drawLine(var37, 109, var37 + var43, 109);
               this.cur = 12;
               if (var3) {
                  this.ctab = 4;
                  this.loadedlink = false;
               }
            }

            this.rdo.setColor(new Color(206, 171, 98));
            this.rdo.fillRect(0, 0, 560, 300);
            if (this.clanbgl) {
               this.rdo.drawImage(this.clanbg, 0, 0, null);
            }

            if (this.notclan) {
               this.rdo.setColor(new Color(0, 0, 0));
               this.rdo.setFont(new Font("Arial", 1, 13));
               this.ftm = this.rdo.getFontMetrics();
               this.rdo.drawString("[  Clan Removed  ]", 280 - this.ftm.stringWidth("[  Clan Removed  ]") / 2, 40);
               this.rdo
                  .drawString(
                     "This clan has been abandoned by its members and no longer exists...",
                     280 - this.ftm.stringWidth("This clan has been abandoned by its members and no longer exists...") / 2,
                     140
                  );
            }

            if (var22 != -1 && var1 > 216 && var1 < 776 && var2 > 92 && var2 < 412 && this.editc == 0) {
               this.rd.setFont(new Font("Arial", 1, 11));
               this.ftm = this.rd.getFontMetrics();
               this.rd.drawString("Edit Background", 688, 107);
               this.rd.drawLine(688, 109, 688 + this.ftm.stringWidth("Edit Background"), 109);
               if (var1 > 688 && var1 < 688 + this.ftm.stringWidth("Edit Background") && var2 > 95 && var2 < 110 && this.editc == 0) {
                  this.cur = 12;
                  if (var3) {
                     this.editc = 2;
                     this.msg = "Edit Clan's Background Display Image";
                     this.flko = 0;
                  }
               }
            }

            if (this.ctab == 0) {
               if (!this.showreqs) {
                  this.sdist = (int)((this.nmb - 4.0F) * 55.0F);
                  if (this.sdist < 0 || this.nmb < 5) {
                     this.sdist = 0;
                  }
               } else {
                  this.sdist = (int)((this.nrmb - 4.0F) * 40.0F);
                  if (this.sdist < 0) {
                     this.sdist = 0;
                  }
               }
            }

            if (this.ctab == 1 || this.ctab == 2 || this.ctab == 3 || this.ctab == 4) {
               this.sdist = 0;
               if (this.sdist < 0) {
                  this.sdist = 0;
               }
            }

            this.scro = (int)(this.spos5 / 229.0F * this.sdist);
            if (this.ctab == 0) {
               if (!this.showreqs) {
                  int var58 = 0;

                  for (int var75 = 0; var75 < this.nmb; var75++) {
                     boolean var88 = false;

                     for (int var101 = 0; var101 < this.npo; var101++) {
                        if (this.member[var75].toLowerCase().equals(this.pname[var101].toLowerCase())) {
                           var88 = true;
                           var58++;
                        }
                     }

                     if (60 + var75 * 55 - this.scro > 0 && 20 + var75 * 55 - this.scro < 300) {
                        byte var102 = 0;
                        float var111 = 0.5F;
                        if (var1 > 266 && var1 < 726 && var2 > 132 + var75 * 55 - this.scro && var2 < 172 + var75 * 55 - this.scro && this.editc == 0) {
                           var111 = 0.8F;
                           if (var75 >= var22 && var22 != -1) {
                              var102 = 1;
                           }

                           if (this.xt.nickname.toLowerCase().equals(this.member[var75].toLowerCase()) && var102 == 0) {
                              var102 = 2;
                           }
                        }

                        this.rdo.setComposite(AlphaComposite.getInstance(3, var111));
                        this.rdo.setColor(new Color(255, 255, 255));
                        this.rdo.fillRoundRect(50, 20 + var75 * 55 - this.scro, 460, 40, 20, 20);
                        this.rdo.setColor(new Color(0, 0, 0));
                        if (var88) {
                           this.rdo.setColor(new Color(123, 200, 0));
                        }

                        this.rdo.drawRoundRect(50, 20 + var75 * 55 - this.scro, 460, 40, 20, 20);
                        this.rdo.setComposite(AlphaComposite.getInstance(3, 1.0F));
                        boolean var123 = false;
                        boolean var130 = false;
                        if (var1 > 276
                           && var1 < 396
                           && var2 > 137 + var75 * 55 - this.scro
                           && var2 < 167 + var75 * 55 - this.scro
                           && var2 > 112
                           && var2 < 412
                           && this.editc == 0) {
                           var130 = true;
                           this.cur = 12;
                           if (var3) {
                              this.tab = 1;
                              if (!this.proname.equals(this.member[var75])) {
                                 this.proname = this.member[var75];
                                 this.loadedp = false;
                                 this.onexitpro();
                              }
                           }
                        }

                        if (!var130) {
                           var123 = this.drawl(this.rdo, this.member[var75], 60, 25 + var75 * 55 - this.scro, true);
                        } else {
                           this.drawl(this.rdo, this.member[var75], 60, 25 + var75 * 55 - this.scro, false);
                        }

                        if (!var123) {
                           this.rdo.setComposite(AlphaComposite.getInstance(3, 0.5F));
                           this.rdo.setColor(new Color(255, 255, 255));
                           this.rdo.fillRect(60, 25 + var75 * 55 - this.scro, 119, 29);
                           this.rdo.setComposite(AlphaComposite.getInstance(3, 1.0F));
                           this.rdo.setColor(new Color(0, 0, 0));
                           this.rdo.setFont(new Font("Arial", 1, 12));
                           this.ftm = this.rdo.getFontMetrics();
                           this.rdo.drawRect(60, 25 + var75 * 55 - this.scro, 119, 29);
                           this.rdo.drawString(this.member[var75], 120 - this.ftm.stringWidth(this.member[var75]) / 2, 44 + var75 * 55 - this.scro);
                        }

                        this.rdo.setColor(new Color(0, 0, 0));
                        this.rdo.setFont(new Font("Arial", 1, 11));
                        this.ftm = this.rdo.getFontMetrics();
                        String var16 = "";
                        if (var75 == 0) {
                           var16 = "  ( Clan Leader / Admin )";
                        } else if (this.mlevel[var75] == 7) {
                           var16 = "  ( Admin )";
                        }

                        this.rdo.drawString("Level :  " + this.mlevel[var75] + "" + var16 + "", 190, 36 + var75 * 55 - this.scro);
                        this.rdo.drawString("Rank :  " + this.mrank[var75] + "", 190, 52 + var75 * 55 - this.scro);
                        if (var102 != 0) {
                           if (var102 == 1) {
                              this.rdo.drawString("Edit", 424, 36 + var75 * 55 - this.scro);
                              this.rdo.drawLine(424, 38 + var75 * 55 - this.scro, 424 + this.ftm.stringWidth("Edit"), 38 + var75 * 55 - this.scro);
                              if (var1 > 640
                                 && var1 < 640 + this.ftm.stringWidth("Edit")
                                 && var2 > 136 + var75 * 55 - this.scro
                                 && var2 < 151 + var75 * 55 - this.scro
                                 && this.editc == 0) {
                                 this.cur = 12;
                                 if (var3) {
                                    this.em = var75;
                                    this.editc = 3;
                                 }
                              }
                           }

                           String var17 = "Remove";
                           if (this.xt.nickname.toLowerCase().equals(this.member[var75].toLowerCase())) {
                              var17 = "Leave";
                           }

                           this.rdo.drawString(var17, 454, 36 + var75 * 55 - this.scro);
                           this.rdo.drawLine(454, 38 + var75 * 55 - this.scro, 454 + this.ftm.stringWidth(var17), 38 + var75 * 55 - this.scro);
                           if (var1 > 670
                              && var1 < 670 + this.ftm.stringWidth(var17)
                              && var2 > 136 + var75 * 55 - this.scro
                              && var2 < 151 + var75 * 55 - this.scro
                              && this.editc == 0) {
                              this.cur = 12;
                              if (var3) {
                                 this.em = var75;
                                 this.editc = 4;
                              }
                           }
                        } else if (var88) {
                           this.rdo.setColor(new Color(49, 79, 0));
                           this.rdo.drawString("Online", 454, 36 + var75 * 55 - this.scro);
                        }
                     }
                  }

                  if (this.nmb == 1 && var22 != -1) {
                     float var76 = 0.5F;
                     if (var1 > 266 && var1 < 726 && var2 > 187 - this.scro && var2 < 287 - this.scro && this.editc == 0) {
                        var76 = 0.8F;
                     }

                     this.rdo.setComposite(AlphaComposite.getInstance(3, var76));
                     this.rdo.setColor(new Color(255, 255, 255));
                     this.rdo.fillRoundRect(50, 75 - this.scro, 460, 100, 20, 20);
                     this.rdo.setColor(new Color(0, 0, 0));
                     this.rdo.drawRoundRect(50, 75 - this.scro, 460, 100, 20, 20);
                     this.rdo.setComposite(AlphaComposite.getInstance(3, 1.0F));
                     this.rdo.setFont(new Font("Arial", 1, 12));
                     this.ftm = this.rdo.getFontMetrics();
                     this.rdo.drawString("Welcome to your clan " + this.claname + "!", 60, 91 - this.scro);
                     this.rdo.drawString("Now you will need to invite other players to join this clan.", 60, 121 - this.scro);
                     this.rdo.drawString("To invite, visit a player's profile and in the clan area click 'Invite to Join...'.", 60, 136 - this.scro);
                     this.rdo.drawString("(That is if the player is not already a member of another clan).", 60, 151 - this.scro);
                     this.rdo.drawString("The maximum number of members a clan can have is 20.", 60, 166 - this.scro);
                  } else if (this.nmb > 1) {
                     this.rdo.setComposite(AlphaComposite.getInstance(3, 0.8F));
                     this.rdo.setColor(new Color(255, 255, 255));
                     this.rdo.fillRoundRect(212, 20 + this.nmb * 55 - this.scro, 136, 27, 20, 20);
                     this.rdo.setColor(new Color(0, 0, 0));
                     this.rdo.drawRoundRect(212, 20 + this.nmb * 55 - this.scro, 136, 27, 20, 20);
                     this.rdo.setComposite(AlphaComposite.getInstance(3, 1.0F));
                     this.rdo.setFont(new Font("Arial", 1, 11));
                     this.ftm = this.rdo.getFontMetrics();
                     this.rdo
                        .drawString(
                           "" + var58 + " player(s) online", 280 - this.ftm.stringWidth("" + var58 + " player(s) online") / 2, 37 + this.nmb * 55 - this.scro
                        );
                  }
               } else {
                  this.rdo.setComposite(AlphaComposite.getInstance(3, 0.8F));
                  this.rdo.setColor(new Color(244, 232, 204));
                  this.rdo.fillRoundRect(70, 20 - this.scro, 420, 80 + this.nrmb * 40, 20, 20);
                  this.rdo.setColor(new Color(0, 0, 0));
                  this.rdo.drawRoundRect(70, 20 - this.scro, 420, 80 + this.nrmb * 40, 20, 20);
                  this.rdo.setComposite(AlphaComposite.getInstance(3, 1.0F));
                  this.rdo.setFont(new Font("Arial", 1, 13));
                  this.ftm = this.rdo.getFontMetrics();
                  this.rdo.drawString("Membership Requests", 280 - this.ftm.stringWidth("Membership Requests") / 2, 45 - this.scro);
                  this.darker = true;

                  for (int var57 = 0; var57 < this.nrmb; var57++) {
                     boolean var74 = false;
                     boolean var87 = false;
                     if (var1 > 356
                        && var1 < 476
                        && var2 > 172 + var57 * 40 - this.scro
                        && var2 < 202 + var57 * 55 - this.scro
                        && var2 > 112
                        && var2 < 412
                        && this.editc == 0) {
                        var87 = true;
                        this.cur = 12;
                        if (var3) {
                           this.tab = 1;
                           if (!this.proname.equals(this.rmember[var57])) {
                              this.proname = this.rmember[var57];
                              this.loadedp = false;
                              this.onexitpro();
                           }
                        }
                     }

                     if (!var87) {
                        var74 = this.drawl(this.rdo, this.rmember[var57], 140, 60 + var57 * 40 - this.scro, true);
                     } else {
                        this.drawl(this.rdo, this.rmember[var57], 140, 60 + var57 * 40 - this.scro, false);
                     }

                     if (!var74) {
                        this.rdo.setComposite(AlphaComposite.getInstance(3, 0.5F));
                        this.rdo.setColor(new Color(255, 255, 255));
                        this.rdo.fillRect(140, 60 + var57 * 40 - this.scro, 119, 29);
                        this.rdo.setComposite(AlphaComposite.getInstance(3, 1.0F));
                        this.rdo.setColor(new Color(0, 0, 0));
                        this.rdo.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rdo.getFontMetrics();
                        this.rdo.drawRect(140, 60 + var57 * 40 - this.scro, 119, 29);
                        this.rdo.drawString(this.rmember[var57], 200 - this.ftm.stringWidth(this.rmember[var57]) / 2, 79 + var57 * 40 - this.scro);
                     }

                     if (this.stringbutton(this.rdo, "  Approve  ", 310, 79 + var57 * 40 - this.scro, 3, var1, var2, var3 && this.editc == 0, 216, 112)) {
                        this.em = var57;
                        this.editc = 66;
                     }

                     if (this.stringbutton(this.rdo, "  Deny  ", 391, 79 + var57 * 40 - this.scro, 3, var1, var2, var3 && this.editc == 0, 216, 112)) {
                        this.em = var57;
                        this.editc = 77;
                     }
                  }

                  if (this.stringbutton(
                     this.rdo, "    Decide Later    ", 280, 80 + this.nrmb * 40 - this.scro, 1, var1, var2, var3 && this.editc == 0, 216, 112
                  )) {
                     this.spos5 = 0;
                     this.lspos5 = 0;
                     this.showreqs = false;
                  }

                  this.darker = false;
               }
            }

            if (this.ctab == 1) {
               this.rdo.setComposite(AlphaComposite.getInstance(3, 0.25F));
               this.rdo.setColor(new Color(255, 255, 255));
               this.rdo.fillRoundRect(20, 246, 520, 39, 20, 20);
               this.rdo.setColor(new Color(0, 0, 0));
               this.rdo.drawRoundRect(20, 246, 520, 39, 20, 20);
               this.rdo.setComposite(AlphaComposite.getInstance(3, 1.0F));
               if (this.xt.clan.toLowerCase().equals(this.claname.toLowerCase())) {
                  if (this.stringbutton(this.rdo, "       Open your clan's discussion       ", 280, 270, -1, var1, var2, var3 && !this.gs.openm, 216, 112)) {
                     this.tab = 2;
                     this.itab = 2;
                     this.litab = -1;
                  }
               } else {
                  if (this.stringbutton(
                     this.rdo, "       Declare war on " + this.claname + "       ", 162, 270, -1, var1, var2, var3 && !this.gs.openm, 216, 112
                  )) {
                     this.tab = 2;
                     this.itab = 1;
                     this.litab = -1;
                     this.openi = 10;
                     this.viewgame2 = 0;
                     if (!this.intclan.equals(this.claname)) {
                        this.intclan = this.claname;
                        this.dispi = 0;
                        this.nil = 0;
                        this.lastint = "";
                        this.readint = 1;
                     }

                     this.redif = true;
                     this.intsel = 4;
                  }

                  if (this.stringbutton(this.rdo, "    Talk with " + this.claname + "    ", 422, 270, -1, var1, var2, var3 && !this.gs.openm, 216, 112)) {
                     this.tab = 2;
                     this.itab = 1;
                     this.litab = -1;
                     this.openi = 10;
                     this.viewgame2 = 0;
                     if (!this.intclan.equals(this.claname)) {
                        this.intclan = this.claname;
                        this.dispi = 0;
                        this.nil = 0;
                        this.lastint = "";
                        this.readint = 1;
                     }
                  }
               }
            }

            if (this.ctab == 3) {
               if (this.loadedstages != 1 && this.loadedstages != 5) {
                  this.rdo.setComposite(AlphaComposite.getInstance(3, 0.7F));
                  this.rdo.setColor(new Color(255, 255, 255));
                  this.rdo.fillRoundRect(60, 70, 440, 100, 20, 20);
                  this.rdo.setColor(new Color(0, 0, 0));
                  this.rdo.drawRoundRect(60, 70, 440, 100, 20, 20);
                  this.rdo.setComposite(AlphaComposite.getInstance(3, 1.0F));
               }

               this.rdo.setFont(new Font("Arial", 1, 12));
               this.ftm = this.rdo.getFontMetrics();
               if (this.loadedstages == -2) {
                  this.rdo
                     .drawString(
                        "Failed to load clan stages, connection error, try again later...",
                        280 - this.ftm.stringWidth("Failed to load clan stages, connection error, try again later...") / 2,
                        125
                     );
               }

               if (this.loadedstages == -1) {
                  this.rdo.drawString("Loading clan stages, please wait...", 280 - this.ftm.stringWidth("Loading clan stages, please wait...") / 2, 125);
               }

               if (this.loadedstages == 0) {
                  this.rdo
                     .drawString(
                        "No custom clan stages have been added yet!", 280 - this.ftm.stringWidth("No custom clan stages have been added yet!") / 2, 125
                     );
               }

               if (this.loadedstages == 2) {
                  this.rdo
                     .drawString(
                        "Searching for and loading stages created by you,  " + this.perry + "  ...",
                        280 - this.ftm.stringWidth("Searching for and loading stages created by you,  " + this.perry + "  ...") / 2,
                        125
                     );
               }

               if (this.loadedstages == 3) {
                  this.rdo.drawString("Found no stages that can be added!", 280 - this.ftm.stringWidth("Found no stages that can be added!") / 2, 95);
                  this.rdo
                     .drawString(
                        "Found no stages created by you that also do not already belong to a clan.",
                        280 - this.ftm.stringWidth("Found no stages created by you that also do not already belong to a clan.") / 2,
                        115
                     );
                  if (this.stringbutton(this.rdo, " OK ", 280, 155, -3, var1, var2, var3 && !this.gs.openm, 216, 112)) {
                     this.loadedstages = -1;
                  }
               }

               if (this.loadedstages == 4) {
                  this.rdo
                     .drawString(
                        "Failed to load stages created by you, connection error, try again later...",
                        280 - this.ftm.stringWidth("Failed to load stages created by you, connection error, try again later...") / 2,
                        110
                     );
                  if (this.stringbutton(this.rdo, " OK ", 280, 140, -3, var1, var2, var3 && !this.gs.openm, 216, 112)) {
                     this.loadedstages = -1;
                  }
               }

               if (this.loadedstages == 6) {
                  this.rdo
                     .drawString(
                        "Adding stage to your clan's stages, please wait...",
                        280 - this.ftm.stringWidth("Adding stage to your clan's stages, please wait...") / 2,
                        125
                     );
               }

               if (this.loadedstages == 7) {
                  this.rdo
                     .drawString(
                        "Failed to add stage, server error, try again later...",
                        280 - this.ftm.stringWidth("Failed to add stage, server error, try again later...") / 2,
                        110
                     );
                  if (this.stringbutton(this.rdo, " OK ", 280, 140, -3, var1, var2, var3 && !this.gs.openm, 216, 112)) {
                     this.loadedstages = -1;
                  }
               }

               if (this.loadedstages == 8) {
                  this.rdo
                     .drawString(
                        "Removing stage from your clan's cars, please wait...",
                        280 - this.ftm.stringWidth("Removing stage from your clan's cars, please wait...") / 2,
                        125
                     );
               }

               if (this.loadedstages == 9) {
                  this.rdo
                     .drawString(
                        "Failed to remove stage, server error, try again later...",
                        280 - this.ftm.stringWidth("Failed to remove stage, server error, try again later...") / 2,
                        110
                     );
                  if (this.stringbutton(this.rdo, " OK ", 280, 140, -3, var1, var2, var3 && !this.gs.openm, 216, 112)) {
                     this.loadedstages = -1;
                  }
               }

               if (this.loadedstages == 10) {
                  this.rdo
                     .drawString(
                        "Are you sure you want to remove this stage from your clan's stages?",
                        280 - this.ftm.stringWidth("Are you sure you want to remove this stage from your clan's stages?") / 2,
                        93
                     );
                  if (this.stringbutton(this.rdo, "    Yes    ", 280, 128, -2, var1, var2, var3 && !this.gs.openm, 216, 112)) {
                     this.loadedstages = 8;
                  }

                  if (this.stringbutton(this.rdo, "  No  ", 280, 158, -3, var1, var2, var3 && !this.gs.openm, 216, 112)) {
                     this.loadedstages = 1;
                  }
               }

               if (this.loadedstages == 5) {
                  this.rdo.setComposite(AlphaComposite.getInstance(3, 0.7F));
                  this.rdo.setColor(new Color(255, 255, 255));
                  this.rdo.fillRoundRect(60, 58, 440, 162, 20, 20);
                  this.rdo.setColor(new Color(0, 0, 0));
                  this.rdo.drawRoundRect(60, 58, 440, 162, 20, 20);
                  this.rdo.setComposite(AlphaComposite.getInstance(3, 1.0F));
                  this.rdo.drawString("Select a stage to add.", 280 - this.ftm.stringWidth("Select a stage to add.") / 2, 80);
                  this.gs.clcars.move(496 - this.gs.clcars.getWidth() / 2, 206);
                  if (this.editc == 0) {
                     if (!this.gs.clcars.isShowing()) {
                        this.gs.clcars.show();
                        this.gs.clcars.select(0);
                     }
                  } else {
                     this.gs.clcars.hide();
                  }

                  if (!this.gs.clcars.getSelectedItem().equals(this.selstage)) {
                     this.selstage = this.gs.clcars.getSelectedItem();
                  }

                  if (this.gs.clcars.open) {
                     this.blocknote = 20;
                  }

                  if (this.stringbutton(this.rdo, "     Add Stage     ", 280, 150, -2, var1, var2, var3 && !this.gs.openm, 216, 112)) {
                     this.loadedstages = 6;
                  }

                  if (this.stringbutton(this.rdo, "  Cancel  ", 280, 200, -3, var1, var2, var3 && !this.gs.openm, 216, 112)) {
                     this.loadedstages = -1;
                  }
               }

               if (this.loadedstages == 1) {
                  if (this.editc == 0) {
                     if (!this.gs.clcars.isShowing()) {
                        this.gs.clcars.show();
                        this.selstage = this.gs.clcars.getSelectedItem();
                     }
                  } else {
                     this.gs.clcars.hide();
                  }

                  this.gs.clcars.move(496 - this.gs.clcars.getWidth() / 2, 122);
                  if (!this.gs.clcars.getSelectedItem().equals(this.selstage)) {
                     this.selstage = this.gs.clcars.getSelectedItem();
                     this.loadedstage = 0;
                     this.addstage = 0;
                  }

                  if (this.gs.clcars.open) {
                     this.blocknote = 20;
                  }

                  if (!this.selstage.equals("Select Stage")) {
                     if (this.loadedstage > 0) {
                        this.m.trk = 3;
                        this.m.ih = 0;
                        this.m.iw = 0;
                        this.m.h = 300;
                        this.m.w = 560;
                        this.m.cx = 280;
                        this.m.cy = 150;
                        this.m.aroundtrack(this.cp);
                        this.rdo.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
                        int var59 = 0;
                        int[] var77 = new int[200];

                        for (int var89 = 0; var89 < this.gs.nob; var89++) {
                           if (this.co[var89].dist != 0) {
                              var77[var59] = var89;
                              var59++;
                           } else {
                              this.co[var89].d(this.rdo);
                           }
                        }

                        int[] var90 = new int[var59];

                        for (int var103 = 0; var103 < var59; var103++) {
                           var90[var103] = 0;
                        }

                        for (int var104 = 0; var104 < var59; var104++) {
                           for (int var112 = var104 + 1; var112 < var59; var112++) {
                              if (this.co[var77[var104]].dist != this.co[var77[var112]].dist) {
                                 if (this.co[var77[var104]].dist < this.co[var77[var112]].dist) {
                                    var90[var104]++;
                                 } else {
                                    var90[var112]++;
                                 }
                              } else if (var112 > var104) {
                                 var90[var104]++;
                              } else {
                                 var90[var112]++;
                              }
                           }
                        }

                        for (int var105 = 0; var105 < var59; var105++) {
                           for (int var113 = 0; var113 < var59; var113++) {
                              if (var90[var113] == var105) {
                                 this.co[var77[var113]].d(this.rdo);
                              }
                           }
                        }

                        this.rdo.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                        this.m.trk = 0;
                        this.m.h = 450;
                        this.m.w = 800;
                        this.m.cx = 400;
                        this.m.cy = 225;
                        this.rdo.setComposite(AlphaComposite.getInstance(3, 0.5F));
                        this.rdo.setColor(new Color(255, 255, 255));
                        this.rdo.fillRoundRect(9, 44, 136, 39, 20, 20);
                        this.rdo.setComposite(AlphaComposite.getInstance(3, 1.0F));
                        this.rdo.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rdo.getFontMetrics();
                        this.rdo.setColor(new Color(0, 0, 0));
                        this.rdo.drawString("Created/Published by", 17, 59);
                        int var106 = 17 + this.ftm.stringWidth("Created/Published by") / 2 - this.ftm.stringWidth(this.cp.maker) / 2;
                        int var114 = var106 + this.ftm.stringWidth(this.cp.maker);
                        this.rdo.drawString(this.cp.maker, var106, 74);
                        this.rdo.drawLine(var106, 76, var114, 76);
                        if (var1 > var106 + 216 && var1 < var114 + 216 && var2 > 174 && var2 < 188) {
                           this.cur = 12;
                           if (var3) {
                              this.tab = 1;
                              if (!this.proname.equals(this.cp.maker)) {
                                 this.proname = this.cp.maker;
                                 this.loadedp = false;
                                 this.onexitpro();
                              }
                           }
                        }

                        if ((var22 != -1 || this.cp.maker.toLowerCase().equals(this.xt.nickname.toLowerCase()))
                           && this.stringbutton(this.rdo, " Remove X ", 510, 27, -3, var1, var2, var3 && !this.gs.openm, 216, 112)) {
                           this.loadedstages = 10;
                        }

                        if (this.gs.clcars.getSelectedIndex() != this.gs.clcars.no - 1
                           && this.stringbutton(this.rdo, " Next > ", 520, 137, -3, var1, var2, var3 && !this.gs.openm, 216, 112)) {
                           this.gs.clcars.sel++;
                        }

                        if (this.gs.clcars.getSelectedIndex() != 1
                           && this.stringbutton(this.rdo, " < Prev ", 40, 137, -3, var1, var2, var3 && !this.gs.openm, 216, 112)) {
                           this.gs.clcars.sel--;
                        }

                        if (this.cp.pubt <= 0) {
                           this.rd.setFont(new Font("Arial", 1, 12));
                           this.ftm = this.rd.getFontMetrics();
                           this.rd.setColor(new Color(0, 0, 0));
                           this.rd.drawString("Private Stage", 496 - this.ftm.stringWidth("Private Stage") / 2, 432);
                        } else {
                           this.rd.setFont(new Font("Arial", 1, 12));
                           this.ftm = this.rd.getFontMetrics();
                           this.rd.setColor(new Color(0, 0, 0));
                           if (this.addstage == 2) {
                              this.rd.drawString("Adding Stage...", 496 - this.ftm.stringWidth("Adding Stage...") / 2, 432);
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
                              this.rd
                                 .drawString(
                                    "[" + this.cd.onstage + "] has been added to your stages!",
                                    496 - this.ftm.stringWidth("[" + this.cd.onstage + "] has been added to your stages!") / 2,
                                    432
                                 );
                           }

                           if (this.addstage == 4) {
                              this.rd.drawString("You already have this stage.", 496 - this.ftm.stringWidth("You already have this stage.") / 2, 432);
                           }

                           if (this.addstage == 5) {
                              this.rd
                                 .drawString(
                                    "Cannot add more then 20 stages to your account!",
                                    496 - this.ftm.stringWidth("Cannot add more then 20 stages to your account!") / 2,
                                    432
                                 );
                           }

                           if (this.addstage == 6) {
                              this.rd
                                 .drawString(
                                    "Failed to add stage!  Unknown error, please try again later.",
                                    496 - this.ftm.stringWidth("Failed to add stage!  Unknown error, please try again later.") / 2,
                                    432
                                 );
                           }

                           if (this.addstage == 1) {
                              String var124 = "Upgrade to a full account to add custom stages!";
                              int var131 = 496 - this.ftm.stringWidth(var124) / 2;
                              int var137 = var131 + this.ftm.stringWidth(var124);
                              this.rd.drawString(var124, var131, 432);
                              if (this.waitlink != -1) {
                                 this.rd.drawLine(var131, 435, var137, 435);
                              }

                              if (var1 > var131 && var1 < var137 && var2 > 421 && var2 < 435) {
                                 if (this.waitlink != -1) {
                                    this.cur = 12;
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

                           if (this.addstage == 0 && this.xt.drawcarb(true, null, " Add to My Stages ", 437, 414, var1, var2, var3 && this.blocknote == 0)) {
                              if (this.xt.logged) {
                                 this.cd.onstage = this.selstage;
                                 this.cd.staction = 2;
                                 this.cd.sparkstageaction();
                                 this.addstage = 2;
                              } else {
                                 this.addstage = 1;
                                 this.waitlink = 20;
                              }
                           }
                        }
                     }

                     if (this.loadedstage == 0) {
                        this.rdo.setComposite(AlphaComposite.getInstance(3, 0.7F));
                        this.rdo.setColor(new Color(255, 255, 255));
                        this.rdo.fillRoundRect(150, 100, 260, 40, 20, 20);
                        this.rdo.setColor(new Color(0, 0, 0));
                        this.rdo.drawRoundRect(150, 100, 260, 40, 20, 20);
                        this.rdo.setComposite(AlphaComposite.getInstance(3, 1.0F));
                        this.rdo.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rdo.getFontMetrics();
                        this.rdo.setColor(new Color(0, 0, 0));
                        this.rdo.drawString("Loading...", 280 - this.ftm.stringWidth("Loading...") / 2, 125);
                     }

                     if (this.loadedstage == -1) {
                        this.rdo.setComposite(AlphaComposite.getInstance(3, 0.7F));
                        this.rdo.setColor(new Color(255, 255, 255));
                        this.rdo.fillRoundRect(50, 100, 460, 40, 20, 20);
                        this.rdo.setColor(new Color(0, 0, 0));
                        this.rdo.drawRoundRect(50, 100, 460, 40, 20, 20);
                        this.rdo.setComposite(AlphaComposite.getInstance(3, 1.0F));
                        this.rdo.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rdo.getFontMetrics();
                        this.rdo.setColor(new Color(0, 0, 0));
                        this.rdo
                           .drawString(
                              "Error loading stage, try again later...", 280 - this.ftm.stringWidth("Error loading stage, try again later...") / 2, 125
                           );
                     }
                  }
               }

               if (this.loadedstages != 1 && this.loadedstages != 5 && this.gs.clcars.isShowing()) {
                  this.gs.clcars.hide();
               }

               if (this.xt.clan.toLowerCase().equals(this.claname.toLowerCase())) {
                  if (this.loadedstages >= 0
                     && this.loadedstages < 2
                     && this.stringbutton(
                        this.rdo, "     Add a stage of yours to the clan's stages     ", 280, 286, -2, var1, var2, var3 && !this.gs.openm, 216, 112
                     )) {
                     this.loadedstages = 2;
                     this.perry = "0 %";
                  }
               } else if (this.loadedstages == 1
                  && !this.selstage.equals("Select Stage")
                  && this.loadedstage > 0
                  && this.stringbutton(this.rdo, "     Battle with clan over this stage!     ", 280, 286, -2, var1, var2, var3 && !this.gs.openm, 216, 112)) {
                  this.tab = 2;
                  this.itab = 1;
                  this.litab = -1;
                  this.openi = 10;
                  if (!this.intclan.equals(this.claname)) {
                     this.intclan = this.claname;
                     this.dispi = 0;
                     this.nil = 0;
                     this.lastint = "";
                     this.readint = 1;
                  }

                  this.redif = true;
                  this.intsel = 2;
               }
            }

            if (this.ctab == 2) {
               float var60 = 0.7F;
               if (this.loadedcars == 1) {
                  var60 = 0.5F;
               }

               this.rdo.setComposite(AlphaComposite.getInstance(3, var60));
               this.rdo.setColor(new Color(255, 255, 255));
               this.rdo.fillRoundRect(40, 20, 480, 245, 20, 20);
               this.rdo.setColor(new Color(0, 0, 0));
               this.rdo.drawRoundRect(40, 20, 480, 245, 20, 20);
               this.rdo.setComposite(AlphaComposite.getInstance(3, 1.0F));
               this.rdo.setFont(new Font("Arial", 1, 12));
               this.ftm = this.rdo.getFontMetrics();
               if (this.loadedcars == -2) {
                  this.rdo
                     .drawString(
                        "Failed to load clan cars, connection error, try again later...",
                        280 - this.ftm.stringWidth("Failed to load clan cars, connection error, try again later...") / 2,
                        125
                     );
               }

               if (this.loadedcars == -1) {
                  this.rdo.drawString("Loading clan cars, please wait...", 280 - this.ftm.stringWidth("Loading clan cars, please wait...") / 2, 125);
               }

               if (this.loadedcars == 0) {
                  this.rdo
                     .drawString("No custom clan cars have been added yet!", 280 - this.ftm.stringWidth("No custom clan cars have been added yet!") / 2, 125);
               }

               if (this.loadedcars == 2) {
                  this.rdo
                     .drawString(
                        "Searching for and loading cars created by you,  " + this.perry + "  ...",
                        280 - this.ftm.stringWidth("Searching for and loading cars created by you,  " + this.perry + "  ...") / 2,
                        125
                     );
               }

               if (this.loadedcars == 3) {
                  this.rdo.drawString("Found no cars that can be added!", 280 - this.ftm.stringWidth("Found no cars that can be added!") / 2, 105);
                  this.rdo
                     .drawString(
                        "Found no cars created by you that also do not already belong to a clan.",
                        280 - this.ftm.stringWidth("Found no cars created by you that also do not already belong to a clan.") / 2,
                        125
                     );
                  if (this.stringbutton(this.rdo, " OK ", 280, 155, -3, var1, var2, var3 && !this.gs.openm, 216, 112)) {
                     this.loadedcars = -1;
                  }
               }

               if (this.loadedcars == 4) {
                  this.rdo
                     .drawString(
                        "Failed to load cars created by you, connection error, try again later...",
                        280 - this.ftm.stringWidth("Failed to load cars created by you, connection error, try again later...") / 2,
                        125
                     );
                  if (this.stringbutton(this.rdo, " OK ", 280, 155, -3, var1, var2, var3 && !this.gs.openm, 216, 112)) {
                     this.loadedcars = -1;
                  }
               }

               if (this.loadedcars == 6) {
                  this.rdo
                     .drawString(
                        "Adding " + this.selcar + " to your clan's cars, please wait...",
                        280 - this.ftm.stringWidth("Adding " + this.selcar + " to your clan's cars, please wait...") / 2,
                        125
                     );
               }

               if (this.loadedcars == 7) {
                  this.rdo
                     .drawString(
                        "Failed to add car, server error, try again later...",
                        280 - this.ftm.stringWidth("Failed to add car, server error, try again later...") / 2,
                        125
                     );
                  if (this.stringbutton(this.rdo, " OK ", 280, 155, -3, var1, var2, var3 && !this.gs.openm, 216, 112)) {
                     this.loadedcars = -1;
                  }
               }

               if (this.loadedcars == 8) {
                  this.rdo
                     .drawString(
                        "Removing " + this.selcar + " from your clan's cars, please wait...",
                        280 - this.ftm.stringWidth("Removing " + this.selcar + " from your clan's cars, please wait...") / 2,
                        125
                     );
               }

               if (this.loadedcars == 9) {
                  this.rdo
                     .drawString(
                        "Failed to remove car, server error, try again later...",
                        280 - this.ftm.stringWidth("Failed to remove car, server error, try again later...") / 2,
                        125
                     );
                  if (this.stringbutton(this.rdo, " OK ", 280, 155, -3, var1, var2, var3 && !this.gs.openm, 216, 112)) {
                     this.loadedcars = -1;
                  }
               }

               if (this.loadedcars == 10) {
                  this.rdo
                     .drawString(
                        "Are you sure you want to remove " + this.selcar + " from your clan's cars?",
                        280 - this.ftm.stringWidth("Are you sure you want to remove " + this.selcar + " from your clan's cars?") / 2,
                        100
                     );
                  if (this.stringbutton(this.rdo, "    Yes    ", 280, 135, -2, var1, var2, var3 && !this.gs.openm, 216, 112)) {
                     this.loadedcars = 8;
                  }

                  if (this.stringbutton(this.rdo, "  No  ", 280, 165, -3, var1, var2, var3 && !this.gs.openm, 216, 112)) {
                     this.loadedcars = 1;
                  }
               }

               if (this.loadedcars == 5) {
                  this.rdo.drawString("Select a car to add.", 280 - this.ftm.stringWidth("Select a car to add.") / 2, 80);
                  this.gs.clcars.move(496 - this.gs.clcars.getWidth() / 2, 206);
                  if (this.editc == 0) {
                     if (!this.gs.clcars.isShowing()) {
                        this.gs.clcars.show();
                        this.gs.clcars.select(0);
                     }
                  } else {
                     this.gs.clcars.hide();
                  }

                  if (!this.gs.clcars.getSelectedItem().equals(this.selcar)) {
                     this.selcar = this.gs.clcars.getSelectedItem();
                  }

                  if (this.gs.clcars.open) {
                     this.blocknote = 20;
                  }

                  if (this.stringbutton(this.rdo, "     Add Car     ", 280, 150, -2, var1, var2, var3 && !this.gs.openm, 216, 112)) {
                     this.loadedcars = 6;
                  }

                  if (this.stringbutton(this.rdo, "  Cancel  ", 280, 200, -3, var1, var2, var3 && !this.gs.openm, 216, 112)) {
                     this.loadedcars = -1;
                  }
               }

               if (this.loadedcars == 1) {
                  if (this.editc == 0) {
                     if (!this.gs.clcars.isShowing()) {
                        this.gs.clcars.show();
                        this.selcar = this.gs.clcars.getSelectedItem();
                     }
                  } else {
                     this.gs.clcars.hide();
                  }

                  this.gs.clcars.move(496 - this.gs.clcars.getWidth() / 2, 140);
                  if (!this.gs.clcars.getSelectedItem().equals(this.selcar)) {
                     this.selcar = this.gs.clcars.getSelectedItem();
                     this.loadedcar = 0;
                     this.cd.action = 0;
                  }

                  if (this.gs.clcars.open) {
                     this.blocknote = 20;
                  }

                  if (!this.selcar.equals("Select Car")) {
                     if (this.loadedcar > 0) {
                        this.rdo.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rdo.getFontMetrics();
                        this.rdo.setColor(new Color(0, 0, 0));
                        this.rdo.drawString("Created/Published by", 63, 37);
                        int var78 = 63 + this.ftm.stringWidth("Created/Published by") / 2 - this.ftm.stringWidth(this.cd.createdby[19 + this.cd.haltload]) / 2;
                        int var91 = var78 + this.ftm.stringWidth(this.cd.createdby[19 + this.cd.haltload]);
                        this.rdo.drawString(this.cd.createdby[19 + this.cd.haltload], var78, 52);
                        this.rdo.drawLine(var78, 54, var91, 54);
                        if (var1 > var78 + 216 && var1 < var91 + 216 && var2 > 152 && var2 < 166) {
                           this.cur = 12;
                           if (var3) {
                              this.tab = 1;
                              if (!this.proname.equals(this.cd.createdby[19 + this.cd.haltload])) {
                                 this.proname = this.cd.createdby[19 + this.cd.haltload];
                                 this.loadedp = false;
                                 this.onexitpro();
                              }
                           }
                        }

                        String var107 = "Class C";
                        if (this.cd.cclass[35 + this.cd.haltload] == 1) {
                           var107 = "Class B&C";
                        }

                        if (this.cd.cclass[35 + this.cd.haltload] == 2) {
                           var107 = "Class B";
                        }

                        if (this.cd.cclass[35 + this.cd.haltload] == 3) {
                           var107 = "Class A&B";
                        }

                        if (this.cd.cclass[35 + this.cd.haltload] == 4) {
                           var107 = "Class A";
                        }

                        this.rdo.drawString(var107, 389 - this.ftm.stringWidth(var107) / 2, 45);
                        if ((var22 != -1 || this.cd.createdby[19 + this.cd.haltload].toLowerCase().equals(this.xt.nickname.toLowerCase()))
                           && this.stringbutton(this.rdo, " Remove X ", 466, 45, -3, var1, var2, var3 && !this.gs.openm, 216, 112)) {
                           this.loadedcars = 10;
                        }

                        this.m.crs = true;
                        this.m.focus_point = 400;
                        this.m.x = -335;
                        this.m.y = 0;
                        this.m.z = -50;
                        this.m.xz = 0;
                        this.m.zy = 20;
                        this.m.ground = -2000;
                        this.m.cx = 280;
                        this.m.cy = 150;
                        this.bco[35 + this.cd.haltload].z = 1000;
                        this.bco[35 + this.cd.haltload].y = 480 - this.bco[35 + this.cd.haltload].grat;
                        this.bco[35 + this.cd.haltload].x = -52;
                        this.bco[35 + this.cd.haltload].zy = 0;
                        this.bco[35 + this.cd.haltload].xz = this.mrot;
                        this.mrot -= 5;
                        if (this.mrot < -360) {
                           this.mrot += 360;
                        }

                        this.bco[35 + this.cd.haltload].xy = 0;
                        this.bco[35 + this.cd.haltload].wzy -= 10;
                        if (this.bco[35 + this.cd.haltload].wzy < -45) {
                           this.bco[35 + this.cd.haltload].wzy += 45;
                        }

                        this.rdo.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
                        this.bco[35 + this.cd.haltload].d(this.rdo);
                        this.rdo.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                        this.m.cx = 400;
                        this.m.cy = 225;
                        short var115 = 137;
                        if (this.xt.sc[0] == 35 + this.cd.haltload) {
                           var115 = 255;
                        }

                        if (this.gs.clcars.getSelectedIndex() != this.gs.clcars.no - 1
                           && this.stringbutton(this.rdo, " Next > ", 476, var115, -3, var1, var2, var3 && !this.gs.openm, 216, 112)) {
                           this.gs.clcars.sel++;
                        }

                        if (this.gs.clcars.getSelectedIndex() != 1
                           && this.stringbutton(this.rdo, " < Prev ", 84, var115, -3, var1, var2, var3 && !this.gs.openm, 216, 112)) {
                           this.gs.clcars.sel--;
                        }

                        if (this.xt.sc[0] == 35 + this.cd.haltload && var1 >= 256 && var1 <= 736 && var2 >= 132 && var2 <= 377) {
                           byte var126 = -20;
                           short var133 = -220;
                           this.rdo.setFont(new Font("Arial", 1, 10));
                           this.ftm = this.rd.getFontMetrics();
                           this.rdo.drawString("Hue  | ", 97 + var126, 70);
                           this.rdo.drawImage(this.xt.brt, 137 + var126, 63, null);
                           this.rdo.drawString("Intensity", 121 + var126, 219);
                           this.rdo.drawString("Hue  | ", 647 + var133, 70);
                           this.rdo.drawImage(this.xt.brt, 687 + var133, 63, null);
                           this.rdo.drawString("Intensity", 671 + var133, 219);

                           for (int var139 = 0; var139 < 161; var139++) {
                              this.rdo.setColor(Color.getHSBColor((float)(var139 * 0.00625), 1.0F, 1.0F));
                              this.rdo.drawLine(102 + var126, 75 + var139, 110 + var126, 75 + var139);
                              if (var139 <= 128) {
                                 this.rdo.setColor(Color.getHSBColor(1.0F, 0.0F, (float)(1.0 - var139 * 0.00625)));
                                 this.rdo.drawLine(137 + var126, 75 + var139, 145 + var126, 75 + var139);
                              }

                              this.rdo.setColor(Color.getHSBColor((float)(var139 * 0.00625), 1.0F, 1.0F));
                              this.rdo.drawLine(652 + var133, 75 + var139, 660 + var133, 75 + var139);
                              if (var139 <= 128) {
                                 this.rdo.setColor(Color.getHSBColor(1.0F, 0.0F, (float)(1.0 - var139 * 0.00625)));
                                 this.rdo.drawLine(687 + var133, 75 + var139, 695 + var133, 75 + var139);
                              }
                           }

                           for (int var140 = 0; var140 < 40; var140++) {
                              this.rdo.setColor(Color.getHSBColor(this.xt.arnp[0], (float)(var140 * 0.025), 1.0F - this.xt.arnp[2]));
                              this.rdo.drawLine(121 + var140 + var126, 224, 121 + var140 + var126, 230);
                              this.rdo.setColor(Color.getHSBColor(this.xt.arnp[3], (float)(var140 * 0.025), 1.0F - this.xt.arnp[5]));
                              this.rdo.drawLine(671 + var140 + var133, 224, 671 + var140 + var133, 230);
                           }

                           this.rdo.drawImage(this.xt.arn, 110 + var126, 71 + (int)(this.xt.arnp[0] * 160.0F), null);
                           this.rdo.drawImage(this.xt.arn, 145 + var126, 71 + (int)(this.xt.arnp[2] * 160.0F), null);
                           this.rdo.drawImage(this.xt.arn, 660 + var133, 71 + (int)(this.xt.arnp[3] * 160.0F), null);
                           this.rdo.drawImage(this.xt.arn, 695 + var133, 71 + (int)(this.xt.arnp[5] * 160.0F), null);
                           this.rdo.setColor(new Color(0, 0, 0));
                           this.rdo.fillRect(120 + var126 + (int)(this.xt.arnp[1] * 40.0F), 222, 3, 3);
                           this.rdo.drawLine(121 + var126 + (int)(this.xt.arnp[1] * 40.0F), 224, 121 + var126 + (int)(this.xt.arnp[1] * 40.0F), 230);
                           this.rdo.fillRect(120 + var126 + (int)(this.xt.arnp[1] * 40.0F), 230, 3, 3);
                           this.rdo.fillRect(670 + var133 + (int)(this.xt.arnp[4] * 40.0F), 222, 3, 3);
                           this.rdo.drawLine(671 + var133 + (int)(this.xt.arnp[4] * 40.0F), 224, 671 + var133 + (int)(this.xt.arnp[4] * 40.0F), 230);
                           this.rdo.fillRect(670 + var133 + (int)(this.xt.arnp[4] * 40.0F), 230, 3, 3);
                           if (var3) {
                              if (this.mouson == -1) {
                                 this.mouson = -2;
                                 if (var1 > 335 + var126 && var1 < 379 + var126 && var2 > 334 && var2 < 344) {
                                    this.mouson = 1;
                                 }

                                 if (var1 > 885 + var133 && var1 < 929 + var133 && var2 > 334 && var2 < 344) {
                                    this.mouson = 4;
                                 }

                                 if (var1 > 314 + var126 && var1 < 338 + var126 && var2 > 181 && var2 < 353 && this.mouson == -2) {
                                    this.mouson = 0;
                                 }

                                 if (var1 > 349 + var126 && var1 < 373 + var126 && var2 > 181 && var2 < 321 && this.mouson == -2) {
                                    this.mouson = 2;
                                 }

                                 if (var1 > 864 + var133 && var1 < 888 + var133 && var2 > 181 && var2 < 353 && this.mouson == -2) {
                                    this.mouson = 3;
                                 }

                                 if (var1 > 899 + var133 && var1 < 923 + var133 && var2 > 181 && var2 < 321 && this.mouson == -2) {
                                    this.mouson = 5;
                                 }
                              }
                           } else if (this.mouson != -1) {
                              this.mouson = -1;
                           }

                           if (this.mouson >= 0 && this.mouson <= 5) {
                              this.blocknote = 20;
                           }

                           if (this.mouson == 0 || this.mouson == 2 || this.mouson == 3 || this.mouson == 5) {
                              this.xt.arnp[this.mouson] = (float)((var2 - 187.0F) * 0.00625);
                              if (this.mouson != 2 && this.mouson != 5) {
                                 if (this.xt.arnp[this.mouson] > 1.0F) {
                                    this.xt.arnp[this.mouson] = 1.0F;
                                 }
                              } else if (this.xt.arnp[this.mouson] > 0.8) {
                                 this.xt.arnp[this.mouson] = 0.8F;
                              }

                              if (this.xt.arnp[this.mouson] < 0.0F) {
                                 this.xt.arnp[this.mouson] = 0.0F;
                              }
                           }

                           if (this.mouson == 1) {
                              this.xt.arnp[this.mouson] = (float)(((float)var1 - (337 + var126)) * 0.025);
                              if (this.xt.arnp[this.mouson] > 1.0F) {
                                 this.xt.arnp[this.mouson] = 1.0F;
                              }

                              if (this.xt.arnp[this.mouson] < 0.0F) {
                                 this.xt.arnp[this.mouson] = 0.0F;
                              }
                           }

                           if (this.mouson == 4) {
                              this.xt.arnp[this.mouson] = (float)(((float)var1 - (887 + var133)) * 0.025);
                              if (this.xt.arnp[this.mouson] > 1.0F) {
                                 this.xt.arnp[this.mouson] = 1.0F;
                              }

                              if (this.xt.arnp[this.mouson] < 0.0F) {
                                 this.xt.arnp[this.mouson] = 0.0F;
                              }
                           }

                           Color var141 = Color.getHSBColor(this.xt.arnp[0], this.xt.arnp[1], 1.0F - this.xt.arnp[2]);
                           Color var151 = Color.getHSBColor(this.xt.arnp[3], this.xt.arnp[4], 1.0F - this.xt.arnp[5]);

                           for (int var152 = 0; var152 < this.bco[36].npl; var152++) {
                              if (this.bco[36].p[var152].colnum == 1) {
                                 this.bco[36].p[var152].hsb[0] = this.xt.arnp[0];
                                 this.bco[36].p[var152].hsb[1] = this.xt.arnp[1];
                                 this.bco[36].p[var152].hsb[2] = 1.0F - this.xt.arnp[2];
                                 this.bco[36].p[var152].c[0] = var141.getRed();
                                 this.bco[36].p[var152].c[1] = var141.getGreen();
                                 this.bco[36].p[var152].c[2] = var141.getBlue();
                                 this.bco[36].p[var152].oc[0] = var141.getRed();
                                 this.bco[36].p[var152].oc[1] = var141.getGreen();
                                 this.bco[36].p[var152].oc[2] = var141.getBlue();
                              }

                              if (this.bco[36].p[var152].colnum == 2) {
                                 this.bco[36].p[var152].hsb[0] = this.xt.arnp[3];
                                 this.bco[36].p[var152].hsb[1] = this.xt.arnp[4];
                                 this.bco[36].p[var152].hsb[2] = 1.0F - this.xt.arnp[5];
                                 this.bco[36].p[var152].c[0] = var151.getRed();
                                 this.bco[36].p[var152].c[1] = var151.getGreen();
                                 this.bco[36].p[var152].c[2] = var151.getBlue();
                                 this.bco[36].p[var152].oc[0] = var151.getRed();
                                 this.bco[36].p[var152].oc[1] = var151.getGreen();
                                 this.bco[36].p[var152].oc[2] = var151.getBlue();
                              }
                           }

                           if (this.stringbutton(this.rdo, "    Play >    ", 280, 220, -1, var1, var2, var3 && !this.gs.openm, 216, 112)) {
                              this.open = 450;
                              this.upo = false;
                              this.domon = false;
                              this.onexit();
                           }
                        } else {
                           this.rdo.setFont(new Font("Arial", 1, 11));
                           this.ftm = this.rdo.getFontMetrics();
                           this.rdo.setColor(new Color(0, 0, 0));
                           byte var125 = -36;
                           short var132 = -181;
                           short var138 = -155;
                           this.rdo.drawString("Top Speed:", 98 + var125, 343 + var138);
                           this.rdo.drawImage(this.xt.statb, 162 + var125, 337 + var138, null);
                           this.rdo.drawString("Acceleration:", 88 + var125, 358 + var138);
                           this.rdo.drawImage(this.xt.statb, 162 + var125, 352 + var138, null);
                           this.rdo.drawString("Handling:", 110 + var125, 373 + var138);
                           this.rdo.drawImage(this.xt.statb, 162 + var125, 367 + var138, null);
                           this.rdo.drawString("Stunts:", 495 + var132, 343 + var138);
                           this.rdo.drawImage(this.xt.statb, 536 + var132, 337 + var138, null);
                           this.rdo.drawString("Strength:", 483 + var132, 358 + var138);
                           this.rdo.drawImage(this.xt.statb, 536 + var132, 352 + var138, null);
                           this.rdo.drawString("Endurance:", 473 + var132, 373 + var138);
                           this.rdo.drawImage(this.xt.statb, 536 + var132, 367 + var138, null);
                           this.rdo.setColor(new Color(0, 0, 0));
                           float var145 = (this.cd.swits[35 + this.cd.haltload][2] - 220) / 90.0F;
                           if (var145 < 0.2) {
                              var145 = 0.2F;
                           }

                           this.rdo.fillRect((int)(162.0F + 156.0F * var145) + var125, 337 + var138, (int)(156.0F * (1.0F - var145) + 1.0F), 7);
                           var145 = this.cd.acelf[35 + this.cd.haltload][1]
                              * this.cd.acelf[35 + this.cd.haltload][0]
                              * this.cd.acelf[35 + this.cd.haltload][2]
                              * this.cd.grip[35 + this.cd.haltload]
                              / 7700.0F;
                           if (var145 > 1.0F) {
                              var145 = 1.0F;
                           }

                           this.rdo.fillRect((int)(162.0F + 156.0F * var145) + var125, 352 + var138, (int)(156.0F * (1.0F - var145) + 1.0F), 7);
                           var145 = this.cd.dishandle[35 + this.cd.haltload];
                           this.rdo.fillRect((int)(162.0F + 156.0F * var145) + var125, 367 + var138, (int)(156.0F * (1.0F - var145) + 1.0F), 7);
                           var145 = (this.cd.airc[35 + this.cd.haltload] * this.cd.airs[35 + this.cd.haltload] * this.cd.bounce[35 + this.cd.haltload] + 28.0F)
                              / 139.0F;
                           if (var145 > 1.0F) {
                              var145 = 1.0F;
                           }

                           this.rdo.fillRect((int)(536.0F + 156.0F * var145) + var132, 337 + var138, (int)(156.0F * (1.0F - var145) + 1.0F), 7);
                           float var18 = 0.5F;
                           var145 = (this.cd.moment[35 + this.cd.haltload] + var18) / 2.6F;
                           if (var145 > 1.0F) {
                              var145 = 1.0F;
                           }

                           this.rdo.fillRect((int)(536.0F + 156.0F * var145) + var132, 352 + var138, (int)(156.0F * (1.0F - var145) + 1.0F), 7);
                           var145 = this.cd.outdam[35 + this.cd.haltload];
                           this.rdo.fillRect((int)(536.0F + 156.0F * var145) + var132, 367 + var138, (int)(156.0F * (1.0F - var145) + 1.0F), 7);
                           this.rdo.drawImage(this.xt.statbo, 162 + var125, 337 + var138, null);
                           this.rdo.drawImage(this.xt.statbo, 162 + var125, 352 + var138, null);
                           this.rdo.drawImage(this.xt.statbo, 162 + var125, 367 + var138, null);
                           this.rdo.drawImage(this.xt.statbo, 536 + var132, 337 + var138, null);
                           this.rdo.drawImage(this.xt.statbo, 536 + var132, 352 + var138, null);
                           this.rdo.drawImage(this.xt.statbo, 536 + var132, 367 + var138, null);
                        }

                        if (this.xt.clan.toLowerCase().equals(this.claname.toLowerCase())) {
                           if (this.xt.sc[0] != 36) {
                              if (this.stringbutton(this.rdo, "     Switch to using clan cars     ", 280, 250, -2, var1, var2, var3 && !this.gs.openm, 216, 112)
                                 )
                               {
                                 this.xt.sc[0] = 36;
                                 boolean var127 = false;

                                 for (int var134 = 0; var134 < this.bco[36].npl && !var127; var134++) {
                                    if (this.bco[36].p[var134].colnum == 1) {
                                       float[] var142 = new float[3];
                                       Color.RGBtoHSB(this.bco[36].p[var134].c[0], this.bco[36].p[var134].c[1], this.bco[36].p[var134].c[2], var142);
                                       this.xt.arnp[0] = var142[0];
                                       this.xt.arnp[1] = var142[1];
                                       this.xt.arnp[2] = 1.0F - var142[2];
                                       var127 = true;
                                    }
                                 }

                                 var127 = false;

                                 for (int var135 = 0; var135 < this.bco[36].npl && !var127; var135++) {
                                    if (this.bco[36].p[var135].colnum == 2) {
                                       float[] var143 = new float[3];
                                       Color.RGBtoHSB(this.bco[36].p[var135].c[0], this.bco[36].p[var135].c[1], this.bco[36].p[var135].c[2], var143);
                                       this.xt.arnp[3] = var143[0];
                                       this.xt.arnp[4] = var143[1];
                                       this.xt.arnp[5] = 1.0F - var143[2];
                                       var127 = true;
                                    }
                                 }
                              }
                           } else {
                              this.rdo.setFont(new Font("Arial", 1, 12));
                              this.ftm = this.rdo.getFontMetrics();
                              this.rdo.setColor(new Color(0, 0, 0));
                              this.rdo
                                 .drawString(
                                    "You are currently using your clan's cars.",
                                    280 - this.ftm.stringWidth("You are currently using your clan's cars.") / 2,
                                    250
                                 );
                           }
                        }

                        if (this.cd.publish[19 + this.cd.haltload] <= 0) {
                           this.rd.setFont(new Font("Arial", 1, 12));
                           this.ftm = this.rd.getFontMetrics();
                           this.rd.setColor(new Color(0, 0, 0));
                           this.rd.drawString("Private Car", 496 - this.ftm.stringWidth("Private Car") / 2, 432);
                        } else {
                           this.rd.setFont(new Font("Arial", 1, 12));
                           this.ftm = this.rd.getFontMetrics();
                           this.rd.setColor(new Color(0, 0, 0));
                           if (this.cd.action == -9) {
                              this.rd
                                 .drawString(
                                    "Failed to add car!  Unknown error, please try again later.",
                                    496 - this.ftm.stringWidth("Failed to add car!  Unknown error, please try again later.") / 2,
                                    432
                                 );
                           }

                           if (this.cd.action == -8) {
                              this.rd
                                 .drawString(
                                    "Cannot add more then 20 cars to your account!",
                                    496 - this.ftm.stringWidth("Cannot add more then 20 cars to your account!") / 2,
                                    432
                                 );
                           }

                           if (this.cd.action == 7) {
                              this.rd
                                 .drawString(
                                    "[" + this.cd.acname + "] has been added to your cars!",
                                    496 - this.ftm.stringWidth("[" + this.cd.acname + "] has been added to your cars!") / 2,
                                    432
                                 );
                           }

                           if (this.cd.action == -7) {
                              this.rd.drawString("You already have this car.", 496 - this.ftm.stringWidth("You already have this car.") / 2, 432);
                           }

                           if (this.cd.action == 6) {
                              this.rd.drawString("Adding Car...", 496 - this.ftm.stringWidth("Adding Car...") / 2, 432);
                           }

                           if (this.cd.action == -6) {
                              String var129 = "Upgrade to a full account to add custom cars!";
                              int var136 = 496 - this.ftm.stringWidth(var129) / 2;
                              int var144 = var136 + this.ftm.stringWidth(var129);
                              this.rd.drawString(var129, var136, 432);
                              if (this.waitlink != -1) {
                                 this.rd.drawLine(var136, 435, var144, 435);
                              }

                              if (var1 > var136 && var1 < var144 && var2 > 421 && var2 < 435) {
                                 if (this.waitlink != -1) {
                                    this.cur = 12;
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

                           if (this.cd.action == 0 && this.xt.drawcarb(true, null, " Add to My Cars ", 437, 414, var1, var2, var3 && this.blocknote == 0)) {
                              if (this.xt.logged) {
                                 this.cd.action = 6;
                                 this.cd.ac = -1;
                                 this.cd.acname = this.selcar;
                                 this.cd.sparkactionloader();
                              } else {
                                 this.cd.action = -6;
                                 this.waitlink = 20;
                              }
                           }
                        }
                     }

                     if (this.loadedcar == 0) {
                        this.rdo.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rdo.getFontMetrics();
                        this.rdo.setColor(new Color(0, 0, 0));
                        this.rdo.drawString("Loading...", 280 - this.ftm.stringWidth("Loading...") / 2, 125);
                     }

                     if (this.loadedcar == -1) {
                        this.rdo.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rdo.getFontMetrics();
                        this.rdo.setColor(new Color(0, 0, 0));
                        this.rdo
                           .drawString("Error loading car, try again later...", 280 - this.ftm.stringWidth("Error loading car, try again later...") / 2, 125);
                     }
                  }
               }

               if (this.loadedcars != 1 && this.loadedcars != 5 && this.gs.clcars.isShowing()) {
                  this.gs.clcars.hide();
               }

               if (this.xt.clan.toLowerCase().equals(this.claname.toLowerCase())) {
                  if (this.loadedcars >= 0
                     && this.loadedcars < 2
                     && this.stringbutton(
                        this.rdo, "     Add a car of yours to the clan's cars     ", 280, 286, -2, var1, var2, var3 && !this.gs.openm, 216, 112
                     )) {
                     this.loadedcars = 2;
                     this.perry = "0 %";
                  }
               } else if (this.loadedcars == 1
                  && !this.selcar.equals("Select Car")
                  && this.loadedcar > 0
                  && this.stringbutton(this.rdo, "     Battle with clan over this car!     ", 280, 286, -2, var1, var2, var3 && !this.gs.openm, 216, 112)) {
                  this.tab = 2;
                  this.itab = 1;
                  this.litab = -1;
                  this.openi = 10;
                  if (!this.intclan.equals(this.claname)) {
                     this.intclan = this.claname;
                     this.dispi = 0;
                     this.nil = 0;
                     this.lastint = "";
                     this.readint = 1;
                  }

                  this.redif = true;
                  this.intsel = 3;
               }
            }

            if (this.ctab != 2 && this.ctab != 3 && this.gs.clcars.isShowing()) {
               this.gs.clcars.hide();
            }

            if (this.ctab == 4) {
               boolean var61 = false;
               if (var1 > 266 && var1 < 726 && var2 > 162 && var2 < 223 && this.editc == 0) {
                  var61 = true;
               }

               this.rdo.setComposite(AlphaComposite.getInstance(3, 0.7F));
               this.rdo.setColor(new Color(255, 255, 255));
               this.rdo.fillRoundRect(50, 50, 460, 61, 20, 20);
               this.rdo.setColor(new Color(0, 0, 0));
               this.rdo.drawRoundRect(50, 50, 460, 61, 20, 20);
               this.rdo.setComposite(AlphaComposite.getInstance(3, 1.0F));
               if (this.loadedlink) {
                  if (var22 != -1 && var61) {
                     this.rdo.setFont(new Font("Arial", 1, 11));
                     this.ftm = this.rdo.getFontMetrics();
                     this.rdo.drawString("Edit", 480, 66);
                     this.rdo.drawLine(480, 68, 480 + this.ftm.stringWidth("Edit"), 68);
                     if (var1 > 696 && var1 < 696 + this.ftm.stringWidth("Edit") && var2 > 166 && var2 < 181 && this.editc == 0) {
                        this.cur = 12;
                        if (var3) {
                           this.editc = 6;
                           this.msg = "Edit Clan's Web Presence";
                           this.flko = 0;
                           var3 = false;
                        }
                     }
                  }

                  if (!this.ltit.equals("") && !this.lurl.equals("")) {
                     this.rdo.setFont(new Font("Arial", 1, 13));
                     this.ftm = this.rdo.getFontMetrics();
                     this.rdo.drawString(this.ltit, 70, 74);
                     if (var61) {
                        this.rdo.drawLine(70, 76, 70 + this.ftm.stringWidth(this.ltit), 76);
                     }

                     this.rdo.setFont(new Font("Arial", 0, 12));
                     this.ftm = this.rdo.getFontMetrics();
                     this.rdo.drawString(this.ldes, 70, 94);
                     if (var61 && this.editc == 0) {
                        this.cur = 12;
                        if (var3) {
                           this.gs.openurl(this.lurl);
                        }
                     }
                  } else {
                     this.rdo.setFont(new Font("Arial", 1, 12));
                     this.ftm = this.rdo.getFontMetrics();
                     this.rdo
                        .drawString(
                           "" + this.claname + " has no external online presence.",
                           280 - this.ftm.stringWidth("" + this.claname + " has no external online presence.") / 2,
                           85
                        );
                  }
               } else {
                  this.rdo.setFont(new Font("Arial", 1, 12));
                  this.ftm = this.rdo.getFontMetrics();
                  this.rdo.drawString("Loading...", 280 - this.ftm.stringWidth("Loading...") / 2, 85);
               }
            }

            if (this.sdist != 0) {
               this.rdo.setColor(this.color2k(200, 200, 200));
               this.rdo.fillRect(540, 20, 17, 260);
               if (this.mscro5 == 831) {
                  this.rdo.setColor(this.color2k(215, 215, 215));
                  this.rdo.fillRect(540, 3, 17, 17);
               } else {
                  this.rdo.setColor(this.color2k(220, 220, 220));
                  this.rdo.fill3DRect(540, 3, 17, 17, true);
               }

               this.rdo.drawImage(this.xt.asu, 545, 9, null);
               if (this.mscro5 == 832) {
                  this.rdo.setColor(this.color2k(215, 215, 215));
                  this.rdo.fillRect(540, 280, 17, 17);
               } else {
                  this.rdo.setColor(this.color2k(220, 220, 220));
                  this.rdo.fill3DRect(540, 280, 17, 17, true);
               }

               this.rdo.drawImage(this.xt.asd, 545, 287, null);
               if (this.lspos5 != this.spos5) {
                  this.rdo.setColor(this.color2k(215, 215, 215));
                  this.rdo.fillRect(540, 20 + this.spos5, 17, 31);
               } else {
                  if (this.mscro5 == 831) {
                     this.rdo.setColor(this.color2k(215, 215, 215));
                  }

                  this.rdo.fill3DRect(540, 20 + this.spos5, 17, 31, true);
               }

               this.rdo.setColor(this.color2k(150, 150, 150));
               this.rdo.drawLine(545, 33 + this.spos5, 551, 33 + this.spos5);
               this.rdo.drawLine(545, 35 + this.spos5, 551, 35 + this.spos5);
               this.rdo.drawLine(545, 37 + this.spos5, 551, 37 + this.spos5);
               if (this.mscro5 > 800 && this.lspos5 != this.spos5) {
                  this.lspos5 = this.spos5;
               }

               if (var3) {
                  if (this.mscro5 == 825 && var1 > 756 && var1 < 773 && var2 > 132 + this.spos5 && var2 < this.spos5 + 163) {
                     this.mscro5 = var2 - this.spos5;
                  }

                  if (this.mscro5 == 825 && var1 > 754 && var1 < 775 && var2 > 26 && var2 < 134) {
                     this.mscro5 = 831;
                  }

                  if (this.mscro5 == 825 && var1 > 754 && var1 < 775 && var2 > 390 && var2 < 411) {
                     this.mscro5 = 832;
                  }

                  if (this.mscro5 == 825 && var1 > 756 && var1 < 773 && var2 > 132 && var2 < 392) {
                     this.mscro5 = 152;
                     this.spos5 = var2 - this.mscro5;
                  }

                  int var62 = 2670 / this.sdist;
                  if (var62 < 1) {
                     var62 = 1;
                  }

                  if (this.mscro5 == 831) {
                     this.spos5 -= var62;
                     if (this.spos5 > 229) {
                        this.spos5 = 229;
                     }

                     if (this.spos5 < 0) {
                        this.spos5 = 0;
                     }

                     this.lspos5 = this.spos5;
                  }

                  if (this.mscro5 == 832) {
                     this.spos5 += var62;
                     if (this.spos5 > 229) {
                        this.spos5 = 229;
                     }

                     if (this.spos5 < 0) {
                        this.spos5 = 0;
                     }

                     this.lspos5 = this.spos5;
                  }

                  if (this.mscro5 < 800) {
                     this.spos5 = var2 - this.mscro5;
                     if (this.spos5 > 229) {
                        this.spos5 = 229;
                     }

                     if (this.spos5 < 0) {
                        this.spos5 = 0;
                     }
                  }

                  if (this.mscro5 == 825) {
                     this.mscro5 = 925;
                  }
               } else if (this.mscro5 != 825) {
                  this.mscro5 = 825;
               }
            }

            this.rd.drawImage(this.gImage, 216, 112, null);
            if (this.ctab != 2 && this.ctab != 3 && this.xt.clan.equals("")) {
               boolean var63 = false;

               for (int var79 = 0; var79 < this.nmb; var79++) {
                  if (this.xt.nickname.toLowerCase().equals(this.member[var79].toLowerCase())) {
                     var63 = true;
                     break;
                  }
               }

               if (!var63) {
                  boolean var80 = false;

                  for (int var92 = 0; var92 < this.nrmb; var92++) {
                     if (this.xt.nickname.toLowerCase().equals(this.rmember[var92].toLowerCase())) {
                        var80 = true;
                        break;
                     }
                  }

                  this.rd.setFont(new Font("Arial", 1, 12));
                  this.ftm = this.rd.getFontMetrics();
                  if (var80) {
                     int var94 = this.ftm.stringWidth("You have requested to join this clan, waiting for admin to approve your membership.");
                     this.rd.drawString("You have requested to join this clan, waiting for admin to approve your membership.", 496 - var94 / 2, 432);
                     this.rd.setColor(new Color(0, 0, 0));
                     this.rd.drawRoundRect(496 - var94 / 2 - 20, 415, var94 + 40, 24, 20, 20);
                  } else {
                     if (this.stringbutton(this.rd, "      Request to Join this Clan      ", 496, 432, 3, var1, var2, var3 && !this.gs.openm, 0, 0)) {
                        if (this.xt.logged) {
                           this.editc = 99;
                        } else {
                           this.editc = 101;
                        }
                     }

                     int var93 = this.ftm.stringWidth("      Request to Join this Clan      ");
                     this.rd.setColor(new Color(0, 0, 0));
                     this.rd.drawRoundRect(496 - var93 / 2 - 20, 415, var93 + 40, 24, 20, 20);
                  }
               }
            }

            if (this.editc == 1 || this.editc == 2) {
               this.rd.setColor(new Color(244, 232, 204));
               this.rd.fillRoundRect(265, 92, 460, 220, 20, 20);
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawRoundRect(265, 92, 460, 220, 20, 20);
               String[] var64 = new String[]{"logo", "350x30", "35 : 3"};
               if (this.editc == 2) {
                  var64[0] = "background";
                  var64[1] = "560x300";
                  var64[2] = "56 : 30";
               }

               this.rd.setFont(new Font("Arial", 1, 12));
               this.ftm = this.rd.getFontMetrics();
               if (this.flko % 4 != 0 || this.flko == 0) {
                  this.rd.drawString(this.msg, 495 - this.ftm.stringWidth(this.msg) / 2, 115);
               }

               if (this.flko != 0) {
                  this.flko--;
               }

               this.rd.setFont(new Font("Arial", 0, 12));
               this.rd.drawString("The " + var64[0] + " image is " + var64[1] + " pixels.", 275, 140);
               this.rd.drawString("Any image uploaded will be resized to that width and height. For the best results", 275, 160);
               this.rd.drawString("try to upload an image that is bigger or equal to " + var64[1] + " and has the scale of", 275, 180);
               this.rd.drawString("[ " + var64[2] + " ]  in  [ Width : Height ].", 275, 200);
               this.rd.drawString("Image uploaded must be less than 1MB and in the format of JPEG, GIF or PNG.", 275, 220);
               if (this.upload == 0) {
                  if (this.stringbutton(this.rd, "  Upload Image  ", 495, 250, 0, var1, var2, var3, 0, 0)) {
                     FileDialog var81 = new FileDialog(new Frame(), "Upload Image");
                     var81.setMode(0);
                     var81.setVisible(true);
                     this.filename = "" + var81.getDirectory() + "" + var81.getFile() + "";
                     if (!this.filename.equals("nullnull")) {
                        this.upload = 1;
                     }
                  }
               } else {
                  this.rd.setFont(new Font("Arial", 1, 12));
                  this.ftm = this.rd.getFontMetrics();
                  if (this.upload == 1) {
                     this.rd.drawString("Checking image...", 495 - this.ftm.stringWidth("Checking image...") / 2, 250);
                  }

                  if (this.upload == 2) {
                     this.rd.drawString("Authenticating...", 495 - this.ftm.stringWidth("Authenticating...") / 2, 250);
                  }

                  if (this.upload == 3) {
                     this.rd.drawString("Uploading image :  " + this.perc + " %", 495 - this.ftm.stringWidth("Uploading image :  80 %") / 2, 250);
                  }

                  if (this.upload == 4) {
                     this.rd.drawString("Creating image online...", 495 - this.ftm.stringWidth("Creating image online...") / 2, 250);
                  }

                  if (this.upload == 5) {
                     this.rd.drawString("Done", 495 - this.ftm.stringWidth("Done") / 2, 250);
                  }
               }

               if (this.stringbutton(this.rd, " Cancel ", 495, 290, 2, var1, var2, var3, 0, 0)) {
                  if (this.upload == 0) {
                     this.editc = 0;
                  } else {
                     this.upload = 0;
                  }
               }
            }

            if (this.editc == 3) {
               this.rd.setColor(new Color(244, 232, 204));
               this.rd.fillRoundRect(245, 92, 500, 190, 20, 20);
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawRoundRect(245, 92, 500, 190, 20, 20);
               this.rd.setFont(new Font("Arial", 1, 12));
               this.ftm = this.rd.getFontMetrics();
               String var65 = "" + this.member[this.em] + "'s";
               if (this.xt.nickname.toLowerCase().equals(this.member[this.em].toLowerCase())) {
                  var65 = "Your";
               }

               this.rd.drawString("Edit " + var65 + " Clan Membership", 495 - this.ftm.stringWidth("Edit " + var65 + "'s Clan Membership") / 2, 115);
               this.rd.drawString("Rank Description :", 399 - this.ftm.stringWidth("Membership Level :"), 146);
               this.dorank = true;
               this.rd.drawString("Membership Level :", 503 - this.ftm.stringWidth("Membership Level :"), 176);
               this.gs.clanlev.move(513, 159);
               if (!this.gs.clanlev.isShowing()) {
                  this.gs.clanlev.select(this.mlevel[this.em] - 1);
                  if (this.em == 0 && this.mlevel[this.em] == 7) {
                     this.gs.clanlev.disable();
                  } else {
                     this.gs.clanlev.enable();
                  }

                  this.gs.clanlev.show();
               }

               if (this.stringbutton(this.rd, "     Save     ", 495, 220, 0, var1, var2, var3, 0, 0)) {
                  this.gs.clanlev.hide();
                  this.editc = 33;
               }

               if (this.stringbutton(this.rd, " Cancel ", 495, 260, 2, var1, var2, var3, 0, 0)) {
                  this.editc = 0;
                  this.gs.clanlev.hide();
               }
            }

            if (this.editc == 4) {
               this.rd.setColor(new Color(244, 232, 204));
               this.rd.fillRoundRect(220, 92, 550, 155, 20, 20);
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawRoundRect(220, 92, 550, 155, 20, 20);
               this.rd.setFont(new Font("Arial", 1, 13));
               this.ftm = this.rd.getFontMetrics();
               String var66 = "" + this.member[this.em] + "";
               if (this.xt.nickname.toLowerCase().equals(this.member[this.em].toLowerCase())) {
                  var66 = "yourself";
               }

               this.rd
                  .drawString(
                     "Are you sure you want to remove " + var66 + " from the clan?",
                     495 - this.ftm.stringWidth("Are you sure you want to remove " + var66 + " from the clan?") / 2,
                     120
                  );
               if (this.xt.nickname.toLowerCase().equals(this.member[this.em].toLowerCase()) && this.em == 0) {
                  this.rd.setFont(new Font("Arial", 0, 12));
                  this.ftm = this.rd.getFontMetrics();
                  if (this.nmb > 1) {
                     this.rd
                        .drawString(
                           "Note: This will result in the second high ranking player (" + this.member[1] + ") becoming the new Clan Leader!",
                           495
                              - this.ftm
                                    .stringWidth(
                                       "Note: This will result in the second high ranking player (" + this.member[1] + ") becoming the new Clan Leader!"
                                    )
                                 / 2,
                           140
                        );
                  } else {
                     this.rd
                        .drawString(
                           "Note: This will result in the deletion of this clan since you are the only player in it.",
                           495 - this.ftm.stringWidth("Note: This will result in the deletion of this clan since you are the only player in it.") / 2,
                           140
                        );
                  }
               }

               if (this.stringbutton(this.rd, "     Yes     ", 495, 185, 0, var1, var2, var3, 0, 0)) {
                  this.editc = 44;
               }

               if (this.stringbutton(this.rd, " No, Cancel ", 495, 225, 2, var1, var2, var3, 0, 0)) {
                  this.editc = 0;
               }
            }

            if (this.editc == 6) {
               this.rd.setColor(new Color(244, 232, 204));
               this.rd.fillRoundRect(245, 92, 500, 225, 20, 20);
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawRoundRect(245, 92, 500, 225, 20, 20);
               this.rd.setFont(new Font("Arial", 1, 12));
               this.ftm = this.rd.getFontMetrics();
               if (this.flko % 4 != 0 || this.flko == 0) {
                  this.rd.drawString(this.msg, 495 - this.ftm.stringWidth(this.msg) / 2, 115);
               }

               if (this.flko != 0) {
                  this.flko--;
               }

               this.rd.setFont(new Font("Arial", 0, 12));
               this.rd.drawString("Does your clan have an online forum, a Facebook group, a website or any online", 255, 140);
               this.rd.drawString("presence at all beyond the game?  If so, you can link to it from here!", 255, 160);
               this.rd.setFont(new Font("Arial", 1, 12));
               this.ftm = this.rd.getFontMetrics();
               this.rd.drawString("Link Title :", 400 - this.ftm.stringWidth("Link Title :"), 190);
               this.rd.drawString("Link Description :", 400 - this.ftm.stringWidth("Link Description :"), 220);
               this.doweb1 = true;
               if (this.stringbutton(this.rd, "     Next >     ", 495, 255, 0, var1, var2, var3, 0, 0)) {
                  if (!this.gs.temail.getText().equals("") && !this.gs.cmsg.getText().equals("")) {
                     this.sltit = this.gs.temail.getText();
                     if (!this.lurl.equals("") && this.lurl.toLowerCase().startsWith("http")) {
                        this.gs.temail.setText(this.lurl);
                     } else {
                        this.gs.temail.setText("http://");
                     }

                     this.msg = "Edit Clan's Web Presence";
                     this.flko = 0;
                     this.editc = 7;
                  } else {
                     this.msg = "Please enter a link title and a link description!";
                     this.flko = 45;
                  }
               }

               if (this.stringbutton(this.rd, " Cancel ", 495, 295, 2, var1, var2, var3, 0, 0)) {
                  this.editc = 0;
               }
            }

            if (this.editc == 7) {
               this.rd.setColor(new Color(244, 232, 204));
               this.rd.fillRoundRect(245, 92, 500, 225, 20, 20);
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawRoundRect(245, 92, 500, 225, 20, 20);
               this.rd.setFont(new Font("Arial", 1, 12));
               this.ftm = this.rd.getFontMetrics();
               if (this.flko % 4 != 0 || this.flko == 0) {
                  this.rd.drawString(this.msg, 495 - this.ftm.stringWidth(this.msg) / 2, 115);
               }

               if (this.flko != 0) {
                  this.flko--;
               }

               this.rd.drawString("Link URL :", 343 - this.ftm.stringWidth("Link URL :"), 150);
               this.doweb2 = true;
               this.rd.drawString("WARNING :", 255, 180);
               this.rd.setFont(new Font("Arial", 0, 12));
               this.rd.drawString("Any link placed that contains inappropriate, spam or unrelated content will result in", 255, 200);
               this.rd.drawString("instant clan deletion and permanent account banning!", 255, 220);
               if (this.stringbutton(this.rd, "     Save     ", 495, 255, 0, var1, var2, var3, 0, 0)) {
                  if (!this.gs.temail.getText().equals("") && !this.gs.temail.getText().equals("http://")) {
                     this.editc = 55;
                  } else {
                     this.msg = "Please enter a link URL!";
                     this.flko = 45;
                  }
               }

               if (this.stringbutton(this.rd, " Cancel ", 495, 295, 2, var1, var2, var3, 0, 0)) {
                  this.editc = 0;
               }
            }

            if (this.editc == 33 || this.editc == 44 || this.editc == 66 || this.editc == 77 || this.editc == 99 || this.editc == 55) {
               this.rd.setColor(new Color(244, 232, 204));
               this.rd.fillRoundRect(345, 92, 300, 40, 20, 20);
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawRoundRect(345, 92, 300, 40, 20, 20);
               this.rd.setFont(new Font("Arial", 1, 12));
               this.ftm = this.rd.getFontMetrics();
               this.rd.drawString("One moment...", 495 - this.ftm.stringWidth("One moment...") / 2, 117);
            }

            if (this.editc == 5) {
               this.rd.setColor(new Color(244, 232, 204));
               this.rd.fillRoundRect(265, 92, 460, 115, 20, 20);
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawRoundRect(265, 92, 460, 115, 20, 20);
               this.rd.setFont(new Font("Arial", 1, 12));
               this.ftm = this.rd.getFontMetrics();
               this.rd
                  .drawString(
                     "Server error occurred or was unable to authorize this action.",
                     495 - this.ftm.stringWidth("Server error occurred or was unable to authorize this action.") / 2,
                     120
                  );
               this.rd.drawString("Please try again later.", 495 - this.ftm.stringWidth("Please try again later.") / 2, 150);
               if (this.stringbutton(this.rd, "     OK     ", 495, 185, 2, var1, var2, var3, 0, 0)) {
                  this.editc = 0;
               }
            }

            if (this.editc == 101) {
               this.rd.setColor(new Color(244, 232, 204));
               this.rd.fillRoundRect(232, 90, 527, 176, 20, 20);
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawRoundRect(232, 90, 527, 176, 20, 20);
               this.rd.setFont(new Font("Arial", 1, 13));
               this.ftm = this.rd.getFontMetrics();
               this.rd.drawString("You are currently using a trial account.", 495 - this.ftm.stringWidth("You are currently using a trial account.") / 2, 120);
               this.rd
                  .drawString(
                     "You need to upgrade to be able participate in any NFM clan activity.",
                     495 - this.ftm.stringWidth("You need to upgrade to be able participate in any NFM clan activity.") / 2,
                     140
                  );
               this.rd.setColor(new Color(206, 171, 98));
               this.rd.fillRoundRect(405, 163, 180, 50, 20, 20);
               if (this.drawbutton(this.xt.upgrade, 495, 188, var1, var2, var3)) {
                  this.gs.editlink(this.xt.nickname, true);
               }

               if (this.stringbutton(this.rd, " Cancel ", 495, 244, 2, var1, var2, var3, 0, 0)) {
                  this.editc = 0;
               }
            }
         } else {
            this.rd
               .drawString(
                  "Loading clan: " + this.claname + ", please wait...",
                  495 - this.ftm.stringWidth("Loading clan: " + this.claname + ", please wait...") / 2,
                  222
               );
         }
      } else {
         if (this.gs.clcars.isShowing()) {
            this.gs.clcars.hide();
         }

         if (this.editc != 0) {
            this.editc = 0;
            if (this.gs.clanlev.isShowing()) {
               this.gs.clanlev.hide();
            }
         }
      }
   }

   public void dotab2(int var1, int var2, boolean var3) {
      if (this.itab == 0) {
         if (this.litab != this.itab) {
            this.spos3 = 0;
            this.gs.senditem.hide();
            this.gs.datat.hide();
            this.gs.sendtyp.removeAll();
            this.gs.sendtyp.add(this.rd, "Write a Message");
            this.gs.sendtyp.add(this.rd, "Share a Custom Car");
            this.gs.sendtyp.add(this.rd, "Share a Custom Stage");
            this.gs.sendtyp.add(this.rd, "Send a Clan Invitation");
            this.gs.sendtyp.add(this.rd, "Share a Relative Date");
            if (!this.forcsel) {
               this.gs.sendtyp.select(0);
            } else {
               this.gs.sendtyp.select(this.itemsel);
            }

            this.forcsel = false;
            this.flko = 0;
            this.itemsel = 0;
            this.flko = 0;
            this.litab = this.itab;
         }

         if (this.openc != 10) {
            this.rd.setColor(this.color2k(230, 230, 230));
            this.rd.fillRoundRect(197, 40, 597, 404, 20, 20);
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawRoundRect(197, 40, 597, 404, 20, 20);
            if (this.loadmsgs != 0 && this.loadmsgs != -2 && this.loadmsgs != -1) {
               this.sdist = (this.nm - 10) * 31;
               if (this.sdist < 0) {
                  this.sdist = 0;
               }

               this.scro = (int)(this.spos3 / 268.0F * this.sdist);
               int var15 = 0;

               for (int var62 = 0; var62 < this.nm; var62++) {
                  if (this.mtyp[var62] != 3) {
                     if (76 + 31 * var15 - this.scro < 408 && 107 + 31 * var15 - this.scro > 76) {
                        boolean var111 = false;
                        if (var1 > 207 && var1 < 770 && var2 > 76 + 31 * var15 - this.scro && var2 < 106 + 31 * var15 - this.scro) {
                           var111 = true;
                           this.cur = 12;
                           if (var3 && this.openc == 0) {
                              this.opy = 70 + 31 * var15 - this.scro;
                              this.addopy = (40 - this.opy) / 10;
                              this.oph = 44;
                              this.openc = 1;
                              if (!this.opname.equals(this.mname[var62])) {
                                 this.opname = this.mname[var62];
                                 this.lastsub = "";
                                 this.readmsg = 1;
                              }
                           }
                        }

                        if (this.mtyp[var62] == 1) {
                           this.rd.setColor(this.color2k(240, 240, 240));
                           this.rd.fillRect(207, 77 + 31 * var15 - this.scro, 564, 30);
                        }

                        if (var111) {
                           this.rd.setColor(this.color2k(250, 250, 250));
                           this.rd.fillRect(207, 77 + 31 * var15 - this.scro, 564, 30);
                        }

                        boolean var131 = this.drawl(this.rd, this.mname[var62], 207, 77 + 31 * var15 - this.scro, var111);
                        if (!var111 || !var131) {
                           this.rd.setFont(new Font("Arial", 1, 12));
                           this.ftm = this.rd.getFontMetrics();
                           this.rd.setColor(new Color(0, 0, 0));
                           this.rd.drawString(this.mname[var62], 267 - this.ftm.stringWidth(this.mname[var62]) / 2, 96 + 31 * var15 - this.scro);
                        }

                        int[] var146 = new int[]{0, 5, 5, 14, 14, 5, 5};
                        int[] var9 = new int[]{0, -5, -2, -2, 3, 3, 5};
                        if (this.mtyp[var62] != 2) {
                           for (int var163 = 0; var163 < 7; var163++) {
                              var146[var163] += 335;
                              var9[var163] += 98 + 31 * var15 - this.scro;
                           }

                           this.rd.setColor(new Color(0, 128, 0));
                        } else {
                           for (int var10 = 0; var10 < 7; var10++) {
                              var146[var10] = 349 - var146[var10];
                              var9[var10] += 98 + 31 * var15 - this.scro;
                           }

                           this.rd.setColor(new Color(0, 0, 128));
                        }

                        this.rd.fillPolygon(var146, var9, 7);
                        this.rd.setFont(new Font("Tahoma", 0, 11));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.setColor(this.color2k(125, 125, 125));
                        this.rd.drawString(this.mtime[var62], 760 - this.ftm.stringWidth(this.mtime[var62]), 102 + 31 * var15 - this.scro);
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawString(this.msub[var62], 335, 89 + 31 * var15 - this.scro);
                        this.rd.setColor(this.color2k(150, 150, 150));
                        this.rd.drawLine(207, 107 + 31 * var15 - this.scro, 770, 107 + 31 * var15 - this.scro);
                     }

                     var15++;
                  }
               }

               for (int var63 = 0; var63 < this.nm; var63++) {
                  if (this.mtyp[var63] == 3) {
                     if (76 + 31 * var15 - this.scro < 408 && 107 + 31 * var15 - this.scro > 76) {
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rd.getFontMetrics();
                        boolean var112 = false;
                        if (var1 > 207 && var1 < 770 && var2 > 76 + 31 * var15 - this.scro && var2 < 106 + 31 * var15 - this.scro) {
                           var112 = true;
                        }

                        boolean var132 = this.drawl(this.rd, this.mname[var63], 207, 77 + 31 * var15 - this.scro, var112);
                        if (!var112 || !var132) {
                           this.rd.setColor(new Color(0, 0, 0));
                           this.rd.drawString(this.mname[var63], 267 - this.ftm.stringWidth(this.mname[var63]) / 2, 96 + 31 * var15 - this.scro);
                        }

                        this.rd.setColor(this.color2k(100, 100, 100));
                        this.rd.fillRect(327, 77 + 31 * var15 - this.scro, 444, 30);
                        this.rd.setColor(this.color2k(200, 200, 200));
                        if (this.unblockname.equals("")) {
                           this.rd.drawString("Blocked", 337, 96 + 31 * var15 - this.scro);
                        } else {
                           this.rd.drawString("Unblocking...", 337, 96 + 31 * var15 - this.scro);
                        }

                        if (var112
                           && this.stringbutton(this.rd, "   Unblock  ", 724, 96 + 31 * var15 - this.scro, 3, var1, var2, var3, 0, 0)
                           && this.unblockname.equals("")) {
                           this.unblockname = this.mname[var63];
                        }

                        this.rd.setColor(this.color2k(150, 150, 150));
                        this.rd.drawLine(207, 107 + 31 * var15 - this.scro, 770, 107 + 31 * var15 - this.scro);
                     }

                     var15++;
                  }
               }

               this.rd.setColor(this.color2k(205, 205, 205));
               this.rd.fillRect(207, 46, 582, 30);
               this.rd.setFont(new Font("Arial", 1, 12));
               this.ftm = this.rd.getFontMetrics();
               String[] var64 = new String[]{"Player Interaction", "Clan Interaction", "Your Clan's Discussion"};
               int[] var113 = new int[]{207, 390, 368, 207};
               int[] var133 = new int[]{73, 73, 51, 51};

               for (int var147 = 0; var147 < 3; var147++) {
                  if (this.itab == var147) {
                     this.rd.setColor(this.color2k(230, 230, 230));
                     this.rd.fillPolygon(var113, var133, 4);
                  } else if (var1 > var113[0] && var1 < var113[2] && var2 > 51 && var2 < 73) {
                     this.rd.setColor(this.color2k(217, 217, 217));
                     this.rd.fillPolygon(var113, var133, 4);
                     if (var3) {
                        this.itab = var147;
                     }
                  }

                  this.rd.setColor(this.color2k(150, 150, 150));
                  this.rd.drawPolygon(var113, var133, 4);
                  this.rd.setColor(this.color2k(40, 40, 40));
                  this.rd.drawString(var64[var147], var113[0] + 80 - this.ftm.stringWidth(var64[var147]) / 2, 67);

                  for (int var158 = 0; var158 < 4; var158++) {
                     var113[var158] += 183;
                  }
               }

               this.rd.setColor(this.color2k(150, 150, 150));
               this.rd.drawLine(207, 73, 770, 73);
               this.rd.setColor(this.color2k(205, 205, 205));
               this.rd.fillRect(207, 409, 582, 30);
               this.rd.setColor(this.color2k(150, 150, 150));
               this.rd.drawLine(207, 411, 770, 411);
               this.rd.setColor(this.color2k(205, 205, 205));
               this.rd.fillRect(772, 93, 17, 299);
               this.rd.setColor(this.color2k(205, 205, 205));
               this.rd.fillRect(203, 46, 4, 393);
               if (this.mscro3 != 831 && this.sdist != 0) {
                  this.rd.setColor(this.color2k(220, 220, 220));
                  this.rd.fill3DRect(772, 76, 17, 17, true);
               } else {
                  if (this.sdist == 0) {
                     this.rd.setColor(this.color2k(205, 205, 205));
                  } else {
                     this.rd.setColor(this.color2k(215, 215, 215));
                  }

                  this.rd.fillRect(772, 76, 17, 17);
               }

               if (this.sdist != 0) {
                  this.rd.drawImage(this.xt.asu, 777, 82, null);
               }

               if (this.mscro3 != 832 && this.sdist != 0) {
                  this.rd.setColor(this.color2k(220, 220, 220));
                  this.rd.fill3DRect(772, 392, 17, 17, true);
               } else {
                  if (this.sdist == 0) {
                     this.rd.setColor(this.color2k(205, 205, 205));
                  } else {
                     this.rd.setColor(this.color2k(215, 215, 215));
                  }

                  this.rd.fillRect(772, 392, 17, 17);
               }

               if (this.sdist != 0) {
                  this.rd.drawImage(this.xt.asd, 777, 399, null);
               }

               if (this.sdist != 0) {
                  if (this.lspos3 != this.spos3) {
                     this.rd.setColor(this.color2k(215, 215, 215));
                     this.rd.fillRect(772, 93 + this.spos3, 17, 31);
                  } else {
                     if (this.mscro3 == 831) {
                        this.rd.setColor(this.color2k(215, 215, 215));
                     }

                     this.rd.fill3DRect(772, 93 + this.spos3, 17, 31, true);
                  }

                  this.rd.setColor(this.color2k(150, 150, 150));
                  this.rd.drawLine(777, 106 + this.spos3, 783, 106 + this.spos3);
                  this.rd.drawLine(777, 108 + this.spos3, 783, 108 + this.spos3);
                  this.rd.drawLine(777, 110 + this.spos3, 783, 110 + this.spos3);
                  if (this.mscro3 > 800 && this.lspos3 != this.spos3) {
                     this.lspos3 = this.spos3;
                  }

                  if (var3 && this.openc == 0) {
                     if (this.mscro3 == 825 && var1 > 772 && var1 < 789 && var2 > 93 + this.spos3 && var2 < this.spos3 + 124) {
                        this.mscro3 = var2 - this.spos3;
                     }

                     if (this.mscro3 == 825 && var1 > 770 && var1 < 791 && var2 > 74 && var2 < 95) {
                        this.mscro3 = 831;
                     }

                     if (this.mscro3 == 825 && var1 > 770 && var1 < 791 && var2 > 390 && var2 < 411) {
                        this.mscro3 = 832;
                     }

                     if (this.mscro3 == 825 && var1 > 772 && var1 < 789 && var2 > 93 && var2 < 392) {
                        this.mscro3 = 108;
                        this.spos3 = var2 - this.mscro3;
                     }

                     int var148 = 2670 / this.sdist;
                     if (var148 < 1) {
                        var148 = 1;
                     }

                     if (this.mscro3 == 831) {
                        this.spos3 -= var148;
                        if (this.spos3 > 268) {
                           this.spos3 = 268;
                        }

                        if (this.spos3 < 0) {
                           this.spos3 = 0;
                        }

                        this.lspos3 = this.spos3;
                     }

                     if (this.mscro3 == 832) {
                        this.spos3 += var148;
                        if (this.spos3 > 268) {
                           this.spos3 = 268;
                        }

                        if (this.spos3 < 0) {
                           this.spos3 = 0;
                        }

                        this.lspos3 = this.spos3;
                     }

                     if (this.mscro3 < 800) {
                        this.spos3 = var2 - this.mscro3;
                        if (this.spos3 > 268) {
                           this.spos3 = 268;
                        }

                        if (this.spos3 < 0) {
                           this.spos3 = 0;
                        }
                     }

                     if (this.mscro3 == 825) {
                        this.mscro3 = 925;
                     }
                  } else if (this.mscro3 != 825) {
                     this.mscro3 = 825;
                  }
               }
            } else {
               this.rd.setColor(this.color2k(205, 205, 205));
               this.rd.fillRect(207, 46, 582, 30);
               this.rd.setFont(new Font("Arial", 1, 12));
               this.ftm = this.rd.getFontMetrics();
               String[] var14 = new String[]{"Player Interaction", "Clan Interaction", "Your Clan's Discussion"};
               int[] var61 = new int[]{207, 390, 368, 207};
               int[] var110 = new int[]{73, 73, 51, 51};

               for (int var130 = 0; var130 < 3; var130++) {
                  if (this.itab == var130) {
                     this.rd.setColor(this.color2k(230, 230, 230));
                     this.rd.fillPolygon(var61, var110, 4);
                  } else if (var1 > var61[0] && var1 < var61[2] && var2 > 51 && var2 < 73) {
                     this.rd.setColor(this.color2k(217, 217, 217));
                     this.rd.fillPolygon(var61, var110, 4);
                     if (var3) {
                        this.itab = var130;
                     }
                  }

                  this.rd.setColor(this.color2k(150, 150, 150));
                  this.rd.drawPolygon(var61, var110, 4);
                  this.rd.setColor(this.color2k(40, 40, 40));
                  this.rd.drawString(var14[var130], var61[0] + 80 - this.ftm.stringWidth(var14[var130]) / 2, 67);

                  for (int var145 = 0; var145 < 4; var145++) {
                     var61[var145] += 183;
                  }
               }

               this.rd.setColor(this.color2k(150, 150, 150));
               this.rd.drawLine(207, 73, 770, 73);
               this.rd.setColor(this.color2k(205, 205, 205));
               this.rd.fillRect(207, 409, 582, 30);
               this.rd.setColor(this.color2k(150, 150, 150));
               this.rd.drawLine(207, 411, 770, 411);
               this.rd.setColor(this.color2k(205, 205, 205));
               this.rd.fillRect(772, 76, 17, 333);
               this.rd.setColor(this.color2k(205, 205, 205));
               this.rd.fillRect(203, 46, 4, 393);
               if (this.loadmsgs == 0) {
                  this.rd.setFont(new Font("Arial", 1, 11));
                  this.ftm = this.rd.getFontMetrics();
                  this.rd.setColor(new Color(0, 0, 0));
                  this.rd
                     .drawString(
                        "You have not started any conversations yet.", 487 - this.ftm.stringWidth("You have not started any conversations yet.") / 2, 200
                     );
               }

               if (this.loadmsgs == -2) {
                  this.rd.setFont(new Font("Arial", 1, 11));
                  this.ftm = this.rd.getFontMetrics();
                  this.rd.setColor(new Color(0, 0, 0));
                  this.rd
                     .drawString(
                        "Failed to load conversations, will try again now...",
                        487 - this.ftm.stringWidth("Failed to load conversations, will try again now...") / 2,
                        200
                     );
               }

               if (this.loadmsgs == -1) {
                  this.rd.setFont(new Font("Arial", 1, 11));
                  this.ftm = this.rd.getFontMetrics();
                  this.rd.setColor(new Color(0, 0, 0));
                  this.rd.drawString("Loading conversations, please wait...", 487 - this.ftm.stringWidth("Loading conversation, please wait...") / 2, 200);
               }
            }

            if (this.gs.sendtyp.isShowing()) {
               this.gs.sendtyp.hide();
               this.gs.sendtyp.select(0);
               this.flko = 0;
            }

            if (this.gs.senditem.isShowing()) {
               this.gs.senditem.hide();
            }

            if (this.gs.datat.isShowing()) {
               this.gs.datat.hide();
            }
         } else {
            this.rd.setColor(this.color2k(240, 240, 240));
            this.rd.fillRoundRect(197, 40, 597, 404, 20, 20);
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawRoundRect(197, 40, 597, 404, 20, 20);
            this.rd.setColor(this.color2k(250, 250, 250));
            this.rd.fillRect(207, 86, 577, 274);
            this.sdist = (int)((this.nml - 14.75F) * 17.0F);
            if (this.sdist < 0) {
               this.sdist = 0;
            }

            this.scro = (int)(this.spos4 / 208.0F * this.sdist);
            if (this.readmsg == 2) {
               if (this.gs.openm) {
                  this.blockb = 10;
               } else if (this.blockb != 0) {
                  this.blockb--;
               }

               for (int var4 = 0; var4 < this.nml; var4++) {
                  if (86 + 17 * var4 - this.scro < 360 && 125 + 17 * var4 - this.scro > 86 && this.mlinetyp[var4] != 167) {
                     this.rd.setColor(new Color(0, 0, 0));
                     if (this.mlinetyp[var4] != 10 && this.mlinetyp[var4] != 20 && this.mlinetyp[var4] != 30) {
                        if (this.mlinetyp[var4] != 0
                           && this.mlinetyp[var4] != 1
                           && this.mlinetyp[var4] != 2
                           && this.mlinetyp[var4] != 3
                           && this.mlinetyp[var4] != 4) {
                           this.rd.setFont(new Font("Tahoma", 0, 11));
                        } else {
                           this.rd.setFont(new Font("Tahoma", 1, 11));
                        }

                        this.rd.drawString(this.mline[var4], 217, 103 + 17 * var4 - this.scro);
                        if (this.mlinetyp[var4] == 0
                           || this.mlinetyp[var4] == 1
                           || this.mlinetyp[var4] == 2
                           || this.mlinetyp[var4] == 3
                           || this.mlinetyp[var4] == 4) {
                           this.rd.setFont(new Font("Tahoma", 0, 11));
                           this.ftm = this.rd.getFontMetrics();
                           this.rd.setColor(this.color2k(125, 125, 125));
                           this.rd.drawString(this.mtimes[var4], 757 - this.ftm.stringWidth(this.mtimes[var4]), 103 + 17 * var4 - this.scro);
                        }
                     } else {
                        if (this.mlinetyp[var4] == 30) {
                           boolean var5 = true;
                           if (var1 > 217 && var1 < 567 && var2 > 93 + var4 * 17 - this.scro && var2 < 123 + var4 * 17 - this.scro && this.blockb == 0) {
                              this.cur = 12;
                              var5 = false;
                              if (var3) {
                                 if (!this.claname.equals(this.mline[var4])) {
                                    this.claname = this.mline[var4];
                                    this.loadedc = false;
                                 }

                                 this.tab = 3;
                                 this.spos5 = 0;
                                 this.lspos5 = 0;
                                 this.cfase = 3;
                                 this.ctab = 0;
                              }
                           }

                           if (!this.drawl(this.rd, "#" + this.mline[var4] + "#", 217, 93 + var4 * 17 - this.scro, var5) || !var5) {
                              this.rd.setColor(new Color(0, 0, 0));
                              this.rd.drawRect(217, 93 + var4 * 17 - this.scro, 349, 29);
                              this.rd.setFont(new Font("Arial", 1, 13));
                              this.ftm = this.rd.getFontMetrics();
                              this.rd
                                 .drawString(
                                    "" + this.mline[var4] + "", 392 - this.ftm.stringWidth("" + this.mline[var4] + "") / 2, 113 + var4 * 17 - this.scro
                                 );
                           }
                        }

                        if (this.mlinetyp[var4] == 10) {
                           if (this.cd.acname.equals(this.mline[var4])) {
                              this.rd.setFont(new Font("Arial", 1, 12));
                              this.ftm = this.rd.getFontMetrics();
                              if (this.cd.action == -9) {
                                 this.rd.drawString("Failed to add car!  Unknown error, please try again later.", 217, 109 + 17 * var4 - this.scro);
                              }

                              if (this.cd.action == -8) {
                                 this.rd.drawString("Cannot add more then 20 cars to your account!", 217, 109 + 17 * var4 - this.scro);
                              }

                              if (this.cd.action == 7) {
                                 this.rd.setColor(new Color(94, 170, 0));
                                 this.rd.drawString("[" + this.mline[var4] + "] has been added to your cars!", 217, 109 + 17 * var4 - this.scro);
                              }

                              if (this.cd.action == -7) {
                                 this.rd.drawString("You already have this car.", 217, 109 + 17 * var4 - this.scro);
                              }

                              if (this.cd.action == 6) {
                                 this.rd.drawString("Adding Car...", 217, 109 + 17 * var4 - this.scro);
                              }

                              if (this.cd.action == -6) {
                                 this.rd.setColor(new Color(193, 106, 0));
                                 String var56 = "Upgrade to a full account to add custom cars!";
                                 short var6 = 217;
                                 int var7 = var6 + this.ftm.stringWidth(var56);
                                 this.rd.drawString(var56, var6, 109 + 17 * var4 - this.scro);
                                 if (this.waitlink != -1) {
                                    this.rd.drawLine(var6, 111 + 17 * var4 - this.scro, var7, 111 + 17 * var4 - this.scro);
                                 }

                                 if (var1 > var6 && var1 < var7 && var2 > 98 + 17 * var4 - this.scro && var2 < 111 + 17 * var4 - this.scro) {
                                    if (this.waitlink != -1) {
                                       this.cur = 12;
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
                           }

                           if (this.cd.action == 0 || !this.cd.acname.equals(this.mline[var4])) {
                              this.rd.setFont(new Font("Arial", 1, 12));
                              this.rd.drawString("[  " + this.mline[var4] + "  ]", 340, 109 + 17 * var4 - this.scro);
                              if (this.xt.drawcarb(true, null, " Add to My Cars ", 217, 90 + 17 * var4 - this.scro, var1, var2, var3 && this.blockb == 0)) {
                                 if (this.xt.logged) {
                                    this.cd.action = 6;
                                    this.cd.ac = -1;
                                    this.cd.acname = this.mline[var4];
                                    this.cd.sparkactionloader();
                                 } else {
                                    this.cd.acname = this.mline[var4];
                                    this.cd.action = -6;
                                    this.waitlink = 20;
                                 }
                              }
                           }
                        }

                        if (this.mlinetyp[var4] == 20) {
                           if (this.cd.onstage.equals(this.mline[var4])) {
                              this.rd.setFont(new Font("Arial", 1, 12));
                              this.ftm = this.rd.getFontMetrics();
                              if (this.addstage == 2) {
                                 this.rd.drawString("Adding stage...", 217, 109 + 17 * var4 - this.scro);
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
                                 this.rd.setColor(new Color(94, 170, 0));
                                 this.rd.drawString("[" + this.mline[var4] + "] has been added to your stages!", 217, 109 + 17 * var4 - this.scro);
                              }

                              if (this.addstage == 4) {
                                 this.rd.drawString("You already have this stage.", 217, 109 + 17 * var4 - this.scro);
                              }

                              if (this.addstage == 5) {
                                 this.rd.drawString("Cannot add more then 20 stages to your account!", 217, 109 + 17 * var4 - this.scro);
                              }

                              if (this.addstage == 6) {
                                 this.rd.drawString("Failed to add stage!  Unknown error, please try again later.", 217, 109 + 17 * var4 - this.scro);
                              }

                              if (this.addstage == 1) {
                                 this.rd.setColor(new Color(193, 106, 0));
                                 String var57 = "Upgrade to a full account to add custom stages!";
                                 short var106 = 217;
                                 int var126 = var106 + this.ftm.stringWidth(var57);
                                 this.rd.drawString(var57, var106, 109 + 17 * var4 - this.scro);
                                 if (this.waitlink != -1) {
                                    this.rd.drawLine(var106, 111 + 17 * var4 - this.scro, var126, 111 + 17 * var4 - this.scro);
                                 }

                                 if (var1 > var106 && var1 < var126 && var2 > 98 + 17 * var4 - this.scro && var2 < 111 + 17 * var4 - this.scro) {
                                    if (this.waitlink != -1) {
                                       this.cur = 12;
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
                           }

                           if (this.addstage == 0 || !this.cd.onstage.equals(this.mline[var4])) {
                              this.rd.setFont(new Font("Arial", 1, 12));
                              this.rd.drawString("[  " + this.mline[var4] + "  ]", 355, 109 + 17 * var4 - this.scro);
                              if (this.xt.drawcarb(true, null, " Add to My Stages ", 217, 90 + 17 * var4 - this.scro, var1, var2, var3 && this.blockb == 0)) {
                                 if (this.xt.logged) {
                                    this.cd.onstage = this.mline[var4];
                                    this.cd.staction = 2;
                                    this.cd.sparkstageaction();
                                    this.addstage = 2;
                                 } else {
                                    this.cd.onstage = this.mline[var4];
                                    this.addstage = 1;
                                    this.waitlink = 20;
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }

            if (this.readmsg == 1) {
               this.rd.setFont(new Font("Tahoma", 1, 11));
               this.ftm = this.rd.getFontMetrics();
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawString("Reading...", 487 - this.ftm.stringWidth("Reading...") / 2, 200);
            }

            if (this.readmsg == 3) {
               this.rd.setFont(new Font("Tahoma", 1, 11));
               this.ftm = this.rd.getFontMetrics();
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawString("Failed to fetch and load conversation.", 487 - this.ftm.stringWidth("Failed to fetch and load conversation.") / 2, 200);
            }

            if (this.readmsg == 4) {
               this.rd.setFont(new Font("Tahoma", 1, 11));
               this.ftm = this.rd.getFontMetrics();
               this.rd.setColor(new Color(0, 0, 0));
               this.rd
                  .drawString(
                     "Failed to load conversation, server error, please try again later.",
                     487 - this.ftm.stringWidth("Failed to load conversation, please try again later.") / 2,
                     200
                  );
            }

            if (this.readmsg == 5) {
               this.rd.setFont(new Font("Tahoma", 1, 11));
               this.ftm = this.rd.getFontMetrics();
               this.rd.setColor(new Color(0, 0, 0));
               this.rd
                  .drawString(
                     "Failed to send message, server error, please try again later.",
                     487 - this.ftm.stringWidth("Failed to send message, server error, please try again later.") / 2,
                     200
                  );
            }

            this.rd.setColor(this.color2k(240, 240, 240));
            this.rd.fillRect(207, 47, 577, 39);
            this.rd.fillRect(207, 360, 577, 39);
            this.rd.setColor(this.color2k(205, 205, 205));
            this.rd.drawLine(207, 86, 783, 86);
            this.rd.drawLine(207, 86, 207, 360);
            this.rd.drawLine(207, 360, 783, 360);
            this.rd.fillRect(767, 104, 17, 239);
            if (this.mscro4 != 831 && this.sdist != 0) {
               this.rd.setColor(this.color2k(220, 220, 220));
               this.rd.fill3DRect(767, 87, 17, 17, true);
            } else {
               if (this.sdist == 0) {
                  this.rd.setColor(this.color2k(205, 205, 205));
               } else {
                  this.rd.setColor(this.color2k(215, 215, 215));
               }

               this.rd.fillRect(767, 87, 17, 17);
            }

            if (this.sdist != 0) {
               this.rd.drawImage(this.xt.asu, 772, 93, null);
            }

            if (this.mscro4 != 832 && this.sdist != 0) {
               this.rd.setColor(this.color2k(220, 220, 220));
               this.rd.fill3DRect(767, 343, 17, 17, true);
            } else {
               if (this.sdist == 0) {
                  this.rd.setColor(this.color2k(205, 205, 205));
               } else {
                  this.rd.setColor(this.color2k(215, 215, 215));
               }

               this.rd.fillRect(767, 343, 17, 17);
            }

            if (this.sdist != 0) {
               this.rd.drawImage(this.xt.asd, 772, 350, null);
            }

            if (this.sdist != 0) {
               if (this.lspos4 != this.spos4) {
                  this.rd.setColor(this.color2k(215, 215, 215));
                  this.rd.fillRect(767, 104 + this.spos4, 17, 31);
               } else {
                  if (this.mscro4 == 831) {
                     this.rd.setColor(this.color2k(215, 215, 215));
                  }

                  this.rd.fill3DRect(767, 104 + this.spos4, 17, 31, true);
               }

               this.rd.setColor(this.color2k(150, 150, 150));
               this.rd.drawLine(772, 117 + this.spos4, 778, 117 + this.spos4);
               this.rd.drawLine(772, 119 + this.spos4, 778, 119 + this.spos4);
               this.rd.drawLine(772, 121 + this.spos4, 778, 121 + this.spos4);
               if (this.mscro4 > 800 && this.lspos4 != this.spos4) {
                  this.lspos4 = this.spos4;
               }

               if (var3) {
                  if (this.mscro4 == 825 && var1 > 767 && var1 < 784 && var2 > 104 + this.spos4 && var2 < this.spos4 + 135) {
                     this.mscro4 = var2 - this.spos4;
                  }

                  if (this.mscro4 == 825 && var1 > 765 && var1 < 786 && var2 > 85 && var2 < 106) {
                     this.mscro4 = 831;
                  }

                  if (this.mscro4 == 825 && var1 > 765 && var1 < 786 && var2 > 341 && var2 < 362) {
                     this.mscro4 = 832;
                  }

                  if (this.mscro4 == 825 && var1 > 767 && var1 < 784 && var2 > 104 && var2 < 343) {
                     this.mscro4 = 119;
                     this.spos4 = var2 - this.mscro4;
                  }

                  int var12 = 2670 / this.sdist;
                  if (var12 < 1) {
                     var12 = 1;
                  }

                  if (this.mscro4 == 831) {
                     this.spos4 -= var12;
                     if (this.spos4 > 208) {
                        this.spos4 = 208;
                     }

                     if (this.spos4 < 0) {
                        this.spos4 = 0;
                     }

                     this.lspos4 = this.spos4;
                  }

                  if (this.mscro4 == 832) {
                     this.spos4 += var12;
                     if (this.spos4 > 208) {
                        this.spos4 = 208;
                     }

                     if (this.spos4 < 0) {
                        this.spos4 = 0;
                     }

                     this.lspos4 = this.spos4;
                  }

                  if (this.mscro4 < 800) {
                     this.spos4 = var2 - this.mscro4;
                     if (this.spos4 > 208) {
                        this.spos4 = 208;
                     }

                     if (this.spos4 < 0) {
                        this.spos4 = 0;
                     }
                  }

                  if (this.mscro4 == 825) {
                     this.mscro4 = 925;
                  }
               } else if (this.mscro4 != 825) {
                  this.mscro4 = 825;
               }
            }

            this.rd.setFont(new Font("Arial", 1, 12));
            this.ftm = this.rd.getFontMetrics();
            if (!this.drawl(this.rd, this.opname, 207, 47, true)) {
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawString(this.opname, 267 - this.ftm.stringWidth(this.opname) / 2, 66);
               this.rd.setColor(this.color2k(150, 150, 150));
               this.rd.drawRect(207, 47, 119, 29);
            }

            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawString("::  Conversation with " + this.opname + "", 336, 72);
            if (var1 > 207 && var1 < 327 && var2 > 47 && var2 < 77) {
               this.cur = 12;
               if (var3) {
                  this.tab = 1;
                  if (!this.proname.equals(this.opname)) {
                     this.proname = this.opname;
                     this.loadedp = false;
                     this.onexitpro();
                  }
               }
            }

            if (this.stringbutton(this.rd, "Block / Ignore", 665, 66, 0, var1, var2, var3, 0, 0)) {
               this.openc = 0;
               this.blockname = this.opname;
            }

            if (this.stringbutton(this.rd, "Close X", 752, 66, 0, var1, var2, var3, 0, 0)) {
               this.openc = 0;
               this.readmsg = 0;
            }

            if (!this.gs.sendtyp.isShowing()) {
               this.gs.sendtyp.show();
            }

            this.gs.sendtyp.move(207, 365);
            if (this.sendmsg != 0) {
               this.gs.sendtyp.disable();
            } else {
               this.gs.sendtyp.enable();
            }

            String var13 = "";
            if (this.gs.sendtyp.getSelectedIndex() == 0) {
               this.dommsg = true;
               if (this.loaditem != 0) {
                  this.loaditem = 0;
               }
            }

            if (this.gs.sendtyp.getSelectedIndex() == 1) {
               var13 = "car";
               this.rd.setFont(new Font("Arial", 0, 12));
               this.rd.drawString("Send a public car you have or a private car that belongs to you.", 376, 382);
            }

            if (this.gs.sendtyp.getSelectedIndex() == 2) {
               var13 = "stage";
               this.rd.setFont(new Font("Arial", 0, 12));
               this.rd.drawString("Send a public stage you have or a private stage that belongs to you.", 376, 382);
            }

            if (this.gs.sendtyp.getSelectedIndex() == 3) {
               this.rd.setFont(new Font("Arial", 0, 12));
               this.rd.drawString("Send an invitation to " + this.opname + " to join your clan.", 376, 382);
            }

            if (this.gs.sendtyp.getSelectedIndex() == 4) {
               this.rd.setFont(new Font("Arial", 0, 12));
               this.rd.drawString("A date that gets converted to the local time of the person previewing it.", 376, 382);
            }

            if (this.itemsel != this.gs.sendtyp.getSelectedIndex()) {
               this.gs.senditem.hide();
               this.gs.datat.hide();
               this.itemsel = this.gs.sendtyp.getSelectedIndex();
            }

            if (this.gs.sendtyp.getSelectedIndex() == 0) {
               if (this.sendmsg == 0) {
                  if (this.stringbutton(this.rd, "   Send  >  ", 723, 408, 0, var1, var2, var3, 0, 0)
                     && !this.gs.mmsg.getText().trim().equals("")
                     && this.gs.mmsg.getText().toLowerCase().indexOf(this.gs.tpass.getText().toLowerCase()) == -1
                     && this.xt.acexp != -3) {
                     if (!this.xt.msgcheck(this.gs.mmsg.getText())) {
                        this.sendmsg = 1;
                     } else {
                        this.gs.sendtyp.hide();
                        this.xt.warning++;
                     }
                  }
               } else {
                  this.rd.setFont(new Font("Arial", 1, 12));
                  this.ftm = this.rd.getFontMetrics();
                  this.rd.drawString("Sending...", 723 - this.ftm.stringWidth("Sending...") / 2, 408);
               }
            }

            if (this.gs.sendtyp.getSelectedIndex() == 1 || this.gs.sendtyp.getSelectedIndex() == 2) {
               this.rd.setFont(new Font("Arial", 1, 12));
               this.ftm = this.rd.getFontMetrics();
               this.rd.drawString("Select " + var13 + " to share:", 207, 420);
               if (!this.gs.senditem.isShowing()) {
                  this.gs.senditem.removeAll();
                  if (this.xt.logged) {
                     this.gs.senditem.add(this.rd, "Loading your " + var13 + " list, please wait...");
                     this.loaditem = this.gs.sendtyp.getSelectedIndex();
                  } else {
                     this.gs.senditem.add(this.rd, "You need to upgrade to have custom " + var13 + "s!");
                  }

                  this.gs.senditem.select(0);
                  this.gs.senditem.show();
               }

               this.gs.senditem.move(207 + this.ftm.stringWidth("Select " + var13 + " to share:") + 11, 403);
               if (this.loaditem == 10 && this.gs.sendtyp.getSelectedIndex() == 1
                  || this.loaditem == 20 && this.gs.sendtyp.getSelectedIndex() == 2
                  || !this.xt.logged) {
                  if (this.xt.logged) {
                     if (this.sendmsg == 0) {
                        if (this.stringbutton(this.rd, "   Send  >  ", 723, 420, 0, var1, var2, var3, 0, 0)) {
                           this.sendmsg = 1;
                        }
                     } else {
                        this.rd.drawString("Sending...", 723 - this.ftm.stringWidth("Sending...") / 2, 420);
                     }
                  } else {
                     this.rd.setColor(new Color(206, 171, 98));
                     this.rd.fillRoundRect(651, 391, 136, 46, 20, 20);
                     if (this.drawbutton(this.xt.upgrade, 719, 414, var1, var2, var3)) {
                        this.gs.editlink(this.xt.nickname, true);
                     }
                  }
               }
            }

            if (this.gs.sendtyp.getSelectedIndex() == 3) {
               if (!this.xt.clan.equals("")) {
                  short var58 = 306;
                  short var107 = -195;
                  if (!this.drawl(this.rd, "#" + this.xt.clan + "#", 406 + var107, 101 + var58, true)) {
                     this.rd.setFont(new Font("Arial", 1, 13));
                     this.ftm = this.rd.getFontMetrics();
                     this.rd.drawString("" + this.xt.clan + "", 581 + var107 - this.ftm.stringWidth("" + this.xt.clan + "") / 2, 121 + var58);
                  }

                  this.rd.setFont(new Font("Arial", 1, 12));
                  this.ftm = this.rd.getFontMetrics();
                  String var127 = "Your Clan";
                  if (var1 > 402 + var107 && var1 < 759 + var107 && var2 > 84 + var58 && var2 < 134 + var58) {
                     var127 = "Clan :  " + this.xt.clan + "";
                     this.rd.drawLine(408 + var107, 98 + var58, 408 + var107 + this.ftm.stringWidth(var127), 98 + var58);
                     if (var1 > 408 + var107 && var1 < 408 + var107 + this.ftm.stringWidth(var127) && var2 > 85 + var58 && var2 < 100 + var58
                        || var1 > 406 + var107 && var1 < 756 + var107 && var2 > 101 + var58 && var2 < 131 + var58) {
                        this.cur = 12;
                        if (var3 && this.sendmsg == 0) {
                           if (!this.claname.equals(this.xt.clan)) {
                              this.claname = this.xt.clan;
                              this.loadedc = false;
                           }

                           this.tab = 3;
                           this.spos5 = 0;
                           this.lspos5 = 0;
                           this.cfase = 3;
                           this.ctab = 0;
                        }
                     }
                  }

                  this.rd.drawString(var127, 408 + var107, 97 + var58);
                  this.rd.drawLine(402 + var107, 84 + var58, 402 + var107, 134 + var58);
                  this.rd.drawLine(402 + var107, 84 + var58, 408 + var107 + this.ftm.stringWidth(var127) + 2, 84 + var58);
                  this.rd.drawLine(408 + var107 + this.ftm.stringWidth(var127) + 2, 84 + var58, 408 + var107 + this.ftm.stringWidth(var127) + 15, 97 + var58);
                  this.rd.drawLine(408 + var107 + this.ftm.stringWidth(var127) + 15, 97 + var58, 759 + var107, 97 + var58);
                  this.rd.drawLine(759 + var107, 97 + var58, 759 + var107, 134 + var58);
                  this.rd.drawLine(402 + var107, 134 + var58, 759 + var107, 134 + var58);
               } else if (!this.xt.logged) {
                  this.rd.setFont(new Font("Arial", 1, 12));
                  this.ftm = this.rd.getFontMetrics();
                  this.rd.drawString("You need to upgrade to a full account to participate in NFM clan's activities.", 207, 420);
                  this.rd.setColor(new Color(206, 171, 98));
                  this.rd.fillRoundRect(651, 391, 136, 46, 20, 20);
                  if (this.drawbutton(this.xt.upgrade, 719, 414, var1, var2, var3)) {
                     this.gs.editlink(this.xt.nickname, true);
                  }
               } else {
                  this.rd.setFont(new Font("Arial", 1, 12));
                  this.ftm = this.rd.getFontMetrics();
                  if (this.flko % 4 != 0 || this.flko == 0) {
                     this.rd.drawString("You are not a member of any clan yet!", 376 - this.ftm.stringWidth("You are not a member of any clan yet!") / 2, 417);
                  }

                  if (this.flko != 0) {
                     this.flko--;
                  }
               }

               if (this.xt.logged) {
                  if (this.sendmsg == 0) {
                     if (this.stringbutton(this.rd, "   Send  >  ", 723, 408, 0, var1, var2, var3, 0, 0)) {
                        if (!this.xt.clan.equals("")) {
                           this.sendmsg = 1;
                        } else {
                           this.flko = 45;
                        }
                     }
                  } else {
                     this.rd.setFont(new Font("Arial", 1, 12));
                     this.ftm = this.rd.getFontMetrics();
                     this.rd.drawString("Sending...", 723 - this.ftm.stringWidth("Sending...") / 2, 408);
                  }
               }
            }

            if (this.gs.sendtyp.getSelectedIndex() == 4) {
               if (!this.gs.senditem.isShowing()) {
                  this.gs.senditem.removeAll();
                  Calendar var59 = Calendar.getInstance();
                  boolean var108 = false;

                  for (int var128 = 0; var128 < 20; var128++) {
                     String var8 = this.wday[var59.get(7) - 1];
                     if (!var108) {
                        var8 = "Today";
                        var108 = true;
                     }

                     this.gs.senditem.add(this.rd, "" + var8 + "  -  " + this.month[var59.get(2)] + " " + var59.get(5) + "");
                     var59.roll(5, true);
                  }

                  this.gs.senditem.select(0);
                  this.gs.senditem.show();
               }

               if (!this.gs.datat.isShowing()) {
                  this.gs.datat.removeAll();
                  int var60 = 12;
                  String var109 = "PM";

                  for (int var129 = 0; var129 < 24; var129++) {
                     this.gs.datat.add(this.rd, "" + var60 + " " + var109 + "");
                     if (++var60 == 12) {
                        var109 = "AM";
                     }

                     if (var60 == 13) {
                        var60 = 1;
                     }
                  }

                  this.gs.datat.select(0);
                  this.gs.datat.show();
               }

               this.gs.senditem.move(300, 395);
               this.gs.datat.move(491, 395);
               this.rd.setFont(new Font("Arial", 1, 12));
               this.ftm = this.rd.getFontMetrics();
               this.rd.drawString("Date is displayed based on your computer calendar's date/time, please make sure it is correct.", 207, 435);
               if (this.sendmsg == 0) {
                  if (this.stringbutton(this.rd, "   Send  >  ", 723, 408, 0, var1, var2, var3, 0, 0)) {
                     this.sendmsg = 1;
                  }
               } else {
                  this.rd.setFont(new Font("Arial", 1, 12));
                  this.ftm = this.rd.getFontMetrics();
                  this.rd.drawString("Sending...", 723 - this.ftm.stringWidth("Sending...") / 2, 408);
               }
            }
         }

         if (this.openc >= 1 && this.openc < 10) {
            this.rd.setColor(this.color2k(240, 240, 230));
            this.rd.fillRoundRect(197, this.opy, 597, this.oph, 20, 20);
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawRoundRect(197, this.opy, 597, this.oph, 20, 20);
            if (!this.drawl(this.rd, this.opname, 207, this.opy + 7, true)) {
               this.rd.setFont(new Font("Arial", 1, 12));
               this.ftm = this.rd.getFontMetrics();
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawString(this.opname, 267 - this.ftm.stringWidth(this.opname) / 2, this.opy + 26);
               this.rd.setColor(this.color2k(150, 150, 150));
               this.rd.drawRect(207, this.opy + 7, 119, 29);
            }

            this.opy = this.opy + this.addopy;
            this.oph += 36;
            this.openc++;
         }
      }

      if (this.itab == 1) {
         if (this.litab != this.itab) {
            this.spos3 = 0;
            this.gs.senditem.hide();
            this.gs.datat.hide();
            this.gs.sendtyp.removeAll();
            this.gs.sendtyp.add(this.rd, "Write a Message");
            this.gs.sendtyp.add(this.rd, "Share a Relative Date");
            this.gs.sendtyp.add(this.rd, "Battle over Stage");
            this.gs.sendtyp.add(this.rd, "Battle over Car");
            this.gs.sendtyp.add(this.rd, "Declare War");
            if (!this.redif) {
               this.gs.sendtyp.select(0);
            } else {
               this.gs.sendtyp.select(this.intsel);
               if (this.intsel == 4) {
                  this.redif = false;
               }
            }

            if (this.sendwarnum) {
               this.gs.sendtyp.sel = this.intsel;
            }

            this.intsel = 0;
            this.litab = this.itab;
         }

         if (!this.xt.clan.equals("")) {
            if (this.openi != 10) {
               this.rd.setColor(this.color2k(230, 230, 230));
               this.rd.fillRoundRect(197, 40, 597, 404, 20, 20);
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawRoundRect(197, 40, 597, 404, 20, 20);
               if (this.loadinter != 0 && this.loadinter != -2 && this.loadinter != -1) {
                  this.sdist = (this.ni - 10) * 31;
                  if (this.sdist < 0) {
                     this.sdist = 0;
                  }

                  this.scro = (int)(this.spos3 / 268.0F * this.sdist);
                  int var52 = 0;

                  for (int var94 = 0; var94 < this.ni; var94++) {
                     if (76 + 31 * var52 - this.scro < 408 && 107 + 31 * var52 - this.scro > 76) {
                        boolean var122 = false;
                        if (var1 > 207 && var1 < 770 && var2 > 76 + 31 * var52 - this.scro && var2 < 106 + 31 * var52 - this.scro) {
                           var122 = true;
                           this.cur = 12;
                           if (var3 && this.openc == 0) {
                              this.opy = 70 + 31 * var52 - this.scro;
                              this.addopy = (40 - this.opy) / 10;
                              this.oph = 44;
                              this.openi = 1;
                              if (!this.intclan.equals(this.iclan[var94])) {
                                 this.intclan = this.iclan[var94];
                                 this.dispi = 0;
                                 this.nil = 0;
                                 this.lastint = "";
                                 this.readint = 1;
                              }
                           }
                        }

                        if (this.icheck[var94].toLowerCase().indexOf(this.xt.nickname.toLowerCase()) == -1) {
                           this.rd.setColor(this.color2k(240, 240, 240));
                           this.rd.fillRect(207, 77 + 31 * var52 - this.scro, 564, 30);
                        }

                        if (var122) {
                           this.rd.setColor(this.color2k(250, 250, 250));
                           this.rd.fillRect(207, 77 + 31 * var52 - this.scro, 564, 30);
                        }

                        boolean var137 = this.drawl(this.rd, "#" + this.iclan[var94] + "#", 207, 77 + 31 * var52 - this.scro, var122);
                        if (!var122 || !var137) {
                           this.rd.setFont(new Font("Arial", 1, 12));
                           this.ftm = this.rd.getFontMetrics();
                           this.rd.setColor(new Color(0, 0, 0));
                           this.rd.drawString(this.iclan[var94], 382 - this.ftm.stringWidth(this.iclan[var94]) / 2, 96 + 31 * var52 - this.scro);
                        }

                        this.rd.setFont(new Font("Tahoma", 0, 11));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.setColor(this.color2k(125, 125, 125));
                        this.rd.drawString(this.itime[var94], 760 - this.ftm.stringWidth(this.itime[var94]), 102 + 31 * var52 - this.scro);
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawString(this.isub[var94], 565, 89 + 31 * var52 - this.scro);
                        this.rd.setFont(new Font("Arial", 1, 11));
                        this.rd.setColor(new Color(117, 67, 0));
                        this.rd.drawString(this.istat[var94], 565, 102 + 31 * var52 - this.scro);
                        this.rd.setColor(this.color2k(150, 150, 150));
                        this.rd.drawLine(207, 107 + 31 * var52 - this.scro, 770, 107 + 31 * var52 - this.scro);
                     }

                     var52++;
                  }

                  this.rd.setColor(this.color2k(205, 205, 205));
                  this.rd.fillRect(207, 46, 582, 30);
                  this.rd.setFont(new Font("Arial", 1, 12));
                  this.ftm = this.rd.getFontMetrics();
                  String[] var95 = new String[]{"Player Interaction", "Clan Interaction", "Your Clan's Discussion"};
                  int[] var123 = new int[]{207, 390, 368, 207};
                  int[] var138 = new int[]{73, 73, 51, 51};

                  for (int var151 = 0; var151 < 3; var151++) {
                     if (this.itab == var151) {
                        this.rd.setColor(this.color2k(230, 230, 230));
                        this.rd.fillPolygon(var123, var138, 4);
                     } else if (var1 > var123[0] && var1 < var123[2] && var2 > 51 && var2 < 73) {
                        this.rd.setColor(this.color2k(217, 217, 217));
                        this.rd.fillPolygon(var123, var138, 4);
                        if (var3) {
                           this.itab = var151;
                        }
                     }

                     this.rd.setColor(this.color2k(150, 150, 150));
                     this.rd.drawPolygon(var123, var138, 4);
                     this.rd.setColor(this.color2k(40, 40, 40));
                     this.rd.drawString(var95[var151], var123[0] + 80 - this.ftm.stringWidth(var95[var151]) / 2, 67);

                     for (int var159 = 0; var159 < 4; var159++) {
                        var123[var159] += 183;
                     }
                  }

                  this.rd.setColor(this.color2k(150, 150, 150));
                  this.rd.drawLine(207, 73, 770, 73);
                  this.rd.setColor(this.color2k(205, 205, 205));
                  this.rd.fillRect(207, 409, 582, 30);
                  this.rd.setColor(this.color2k(150, 150, 150));
                  this.rd.drawLine(207, 411, 770, 411);
                  this.rd.setColor(this.color2k(205, 205, 205));
                  this.rd.fillRect(772, 93, 17, 299);
                  this.rd.setColor(this.color2k(205, 205, 205));
                  this.rd.fillRect(203, 46, 4, 393);
                  if (this.mscro3 != 831 && this.sdist != 0) {
                     this.rd.setColor(this.color2k(220, 220, 220));
                     this.rd.fill3DRect(772, 76, 17, 17, true);
                  } else {
                     if (this.sdist == 0) {
                        this.rd.setColor(this.color2k(205, 205, 205));
                     } else {
                        this.rd.setColor(this.color2k(215, 215, 215));
                     }

                     this.rd.fillRect(772, 76, 17, 17);
                  }

                  if (this.sdist != 0) {
                     this.rd.drawImage(this.xt.asu, 777, 82, null);
                  }

                  if (this.mscro3 != 832 && this.sdist != 0) {
                     this.rd.setColor(this.color2k(220, 220, 220));
                     this.rd.fill3DRect(772, 392, 17, 17, true);
                  } else {
                     if (this.sdist == 0) {
                        this.rd.setColor(this.color2k(205, 205, 205));
                     } else {
                        this.rd.setColor(this.color2k(215, 215, 215));
                     }

                     this.rd.fillRect(772, 392, 17, 17);
                  }

                  if (this.sdist != 0) {
                     this.rd.drawImage(this.xt.asd, 777, 399, null);
                  }

                  if (this.sdist != 0) {
                     if (this.lspos3 != this.spos3) {
                        this.rd.setColor(this.color2k(215, 215, 215));
                        this.rd.fillRect(772, 93 + this.spos3, 17, 31);
                     } else {
                        if (this.mscro3 == 831) {
                           this.rd.setColor(this.color2k(215, 215, 215));
                        }

                        this.rd.fill3DRect(772, 93 + this.spos3, 17, 31, true);
                     }

                     this.rd.setColor(this.color2k(150, 150, 150));
                     this.rd.drawLine(777, 106 + this.spos3, 783, 106 + this.spos3);
                     this.rd.drawLine(777, 108 + this.spos3, 783, 108 + this.spos3);
                     this.rd.drawLine(777, 110 + this.spos3, 783, 110 + this.spos3);
                     if (this.mscro3 > 800 && this.lspos3 != this.spos3) {
                        this.lspos3 = this.spos3;
                     }

                     if (var3 && this.openc == 0) {
                        if (this.mscro3 == 825 && var1 > 772 && var1 < 789 && var2 > 93 + this.spos3 && var2 < this.spos3 + 124) {
                           this.mscro3 = var2 - this.spos3;
                        }

                        if (this.mscro3 == 825 && var1 > 770 && var1 < 791 && var2 > 74 && var2 < 95) {
                           this.mscro3 = 831;
                        }

                        if (this.mscro3 == 825 && var1 > 770 && var1 < 791 && var2 > 390 && var2 < 411) {
                           this.mscro3 = 832;
                        }

                        if (this.mscro3 == 825 && var1 > 772 && var1 < 789 && var2 > 93 && var2 < 392) {
                           this.mscro3 = 108;
                           this.spos3 = var2 - this.mscro3;
                        }

                        int var152 = 2670 / this.sdist;
                        if (var152 < 1) {
                           var152 = 1;
                        }

                        if (this.mscro3 == 831) {
                           this.spos3 -= var152;
                           if (this.spos3 > 268) {
                              this.spos3 = 268;
                           }

                           if (this.spos3 < 0) {
                              this.spos3 = 0;
                           }

                           this.lspos3 = this.spos3;
                        }

                        if (this.mscro3 == 832) {
                           this.spos3 += var152;
                           if (this.spos3 > 268) {
                              this.spos3 = 268;
                           }

                           if (this.spos3 < 0) {
                              this.spos3 = 0;
                           }

                           this.lspos3 = this.spos3;
                        }

                        if (this.mscro3 < 800) {
                           this.spos3 = var2 - this.mscro3;
                           if (this.spos3 > 268) {
                              this.spos3 = 268;
                           }

                           if (this.spos3 < 0) {
                              this.spos3 = 0;
                           }
                        }

                        if (this.mscro3 == 825) {
                           this.mscro3 = 925;
                        }
                     } else if (this.mscro3 != 825) {
                        this.mscro3 = 825;
                     }
                  }
               } else {
                  this.rd.setColor(this.color2k(205, 205, 205));
                  this.rd.fillRect(207, 46, 582, 30);
                  this.rd.setFont(new Font("Arial", 1, 12));
                  this.ftm = this.rd.getFontMetrics();
                  String[] var51 = new String[]{"Player Interaction", "Clan Interaction", "Your Clan's Discussion"};
                  int[] var93 = new int[]{207, 390, 368, 207};
                  int[] var121 = new int[]{73, 73, 51, 51};

                  for (int var136 = 0; var136 < 3; var136++) {
                     if (this.itab == var136) {
                        this.rd.setColor(this.color2k(230, 230, 230));
                        this.rd.fillPolygon(var93, var121, 4);
                     } else if (var1 > var93[0] && var1 < var93[2] && var2 > 51 && var2 < 73) {
                        this.rd.setColor(this.color2k(217, 217, 217));
                        this.rd.fillPolygon(var93, var121, 4);
                        if (var3) {
                           this.itab = var136;
                        }
                     }

                     this.rd.setColor(this.color2k(150, 150, 150));
                     this.rd.drawPolygon(var93, var121, 4);
                     this.rd.setColor(this.color2k(40, 40, 40));
                     this.rd.drawString(var51[var136], var93[0] + 80 - this.ftm.stringWidth(var51[var136]) / 2, 67);

                     for (int var150 = 0; var150 < 4; var150++) {
                        var93[var150] += 183;
                     }
                  }

                  this.rd.setColor(this.color2k(150, 150, 150));
                  this.rd.drawLine(207, 73, 770, 73);
                  this.rd.setColor(this.color2k(205, 205, 205));
                  this.rd.fillRect(207, 409, 582, 30);
                  this.rd.setColor(this.color2k(150, 150, 150));
                  this.rd.drawLine(207, 411, 770, 411);
                  this.rd.setColor(this.color2k(205, 205, 205));
                  this.rd.fillRect(772, 76, 17, 333);
                  this.rd.setColor(this.color2k(205, 205, 205));
                  this.rd.fillRect(203, 46, 4, 393);
                  if (this.loadinter == 0) {
                     this.rd.setFont(new Font("Arial", 1, 11));
                     this.ftm = this.rd.getFontMetrics();
                     this.rd.setColor(new Color(0, 0, 0));
                     this.rd
                        .drawString(
                           "You have not started any interactions with other clans yet.",
                           487 - this.ftm.stringWidth("You have not started any interactions with other clans yet.") / 2,
                           200
                        );
                  }

                  if (this.loadinter == -2) {
                     this.rd.setFont(new Font("Arial", 1, 11));
                     this.ftm = this.rd.getFontMetrics();
                     this.rd.setColor(new Color(0, 0, 0));
                     this.rd
                        .drawString(
                           "Failed to load interactions, will try again now...",
                           487 - this.ftm.stringWidth("Failed to load interactions, will try again now...") / 2,
                           200
                        );
                  }

                  if (this.loadinter == -1) {
                     this.rd.setFont(new Font("Arial", 1, 11));
                     this.ftm = this.rd.getFontMetrics();
                     this.rd.setColor(new Color(0, 0, 0));
                     this.rd.drawString("Loading interactions, please wait...", 487 - this.ftm.stringWidth("Loading interactions, please wait...") / 2, 200);
                  }
               }

               if (this.gs.sendtyp.isShowing()) {
                  this.gs.sendtyp.hide();
               }

               if (this.gs.senditem.isShowing()) {
                  this.gs.senditem.hide();
               }

               if (this.gs.datat.isShowing()) {
                  this.gs.datat.hide();
               }

               this.gs.ilaps.hide();
               this.gs.icars.hide();
               this.gs.sclass.hide();
               this.gs.sfix.hide();
               if (this.gs.sendtyp.getSelectedIndex() != 0) {
                  this.gs.sendtyp.select(0);
                  this.intsel = 0;
               }
            } else {
               this.rd.setColor(this.color2k(240, 240, 240));
               this.rd.fillRoundRect(197, 40, 597, 404, 20, 20);
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawRoundRect(197, 40, 597, 404, 20, 20);
               this.rd.setColor(this.color2k(250, 250, 250));
               this.rd.fillRect(207, 86, 577, 274);
               if (this.intclanlo.equals(this.intclan) && this.intclanbgloaded) {
                  this.rd.setComposite(AlphaComposite.getInstance(3, 0.1F));
                  this.rd.drawImage(this.intclanbg, 207, 86, null);
                  this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
               }

               this.sdist = 0;
               if ((this.readint == 2 || this.readint == 1) && this.viewgame2 == 0) {
                  this.sdist = (int)((this.nil - 14.75F) * 17.0F);
                  if (this.sdist < 0) {
                     this.sdist = 0;
                  }

                  this.scro = (int)(this.spos4 / 208.0F * this.sdist);
                  if (this.gs.openm) {
                     this.blockb = 10;
                  } else if (this.blockb != 0) {
                     this.blockb--;
                  }

                  for (int var16 = 0; var16 < this.nil; var16++) {
                     if (86 + 17 * var16 - this.scro < 360 && 125 + 17 * var16 - this.scro > 86 && this.ilinetyp[var16] != 167) {
                        this.rd.setColor(new Color(0, 0, 0));
                        if (this.ilinetyp[var16] != 20
                           && this.ilinetyp[var16] != 30
                           && this.ilinetyp[var16] != 40
                           && this.ilinetyp[var16] != 80
                           && this.ilinetyp[var16] != 90
                           && this.ilinetyp[var16] != 100) {
                           if (this.ilinetyp[var16] >= 0) {
                              this.rd.setFont(new Font("Tahoma", 1, 11));
                           } else {
                              this.rd.setFont(new Font("Tahoma", 0, 11));
                           }

                           this.rd.drawString(this.iline[var16], 217, 103 + 17 * var16 - this.scro);
                           if (this.ilinetyp[var16] >= 0) {
                              this.rd.setFont(new Font("Tahoma", 0, 11));
                              this.ftm = this.rd.getFontMetrics();
                              this.rd.setColor(this.color2k(125, 125, 125));
                              this.rd.drawString(this.itimes[var16], 757 - this.ftm.stringWidth(this.itimes[var16]), 103 + 17 * var16 - this.scro);
                           }
                        } else {
                           if (this.ilinetyp[var16] == 40) {
                              if (this.stringbutton(this.rd, "  View War Declaration  ", 300, 112 + 17 * var16 - this.scro, 0, var1, var2, var3, 0, 0)) {
                                 this.viewgame2 = 1;
                                 this.nvgames2 = 4;
                                 this.viewwar2 = this.getSvalue(this.iline[var16], 1);
                                 if (this.iline[var16].startsWith("I|")) {
                                    this.ichlng = true;
                                 } else {
                                    this.ichlng = false;
                                 }
                              }

                              if (!this.iline[var16].endsWith("|out|")) {
                                 if (this.iline[var16].startsWith("Y|")
                                    && this.stringbutton(this.rd, "  Accept War  ", 441, 112 + 17 * var16 - this.scro, 0, var1, var2, var3, 0, 0)) {
                                    this.gs.sendtyp.sel = 7;
                                    this.sendwar = this.getSvalue(this.iline[var16], 1);
                                 }
                              } else {
                                 this.rd.setColor(this.color2k(170, 170, 170));
                                 this.rd
                                    .drawString(
                                       "[ Accepted or interaction replaced. ]",
                                       490 - this.ftm.stringWidth("[ Accepted or interaction replaced. ]") / 2,
                                       112 + 17 * var16 - this.scro
                                    );
                              }
                           }

                           if (this.ilinetyp[var16] == 30) {
                              if (this.stringbutton(this.rd, "  View Car Battle  ", 282, 112 + 17 * var16 - this.scro, 0, var1, var2, var3, 0, 0)) {
                                 this.viewgame2 = 1;
                                 this.nvgames2 = 2;
                                 this.viewwar2 = this.getSvalue(this.iline[var16], 3);
                                 if (this.iline[var16].startsWith("I|")) {
                                    this.ichlng = true;
                                 } else {
                                    this.ichlng = false;
                                 }
                              }

                              if (!this.iline[var16].endsWith("|out|")) {
                                 if (this.iline[var16].startsWith("Y|")
                                    && this.stringbutton(this.rd, "  Accept Battle  ", 410, 112 + 17 * var16 - this.scro, 0, var1, var2, var3, 0, 0)) {
                                    this.gs.sendtyp.sel = 6;
                                    this.itake = this.getSvalue(this.iline[var16], 1);
                                    this.igive = this.getSvalue(this.iline[var16], 2);
                                    this.sendwar = this.getSvalue(this.iline[var16], 3);
                                 }
                              } else {
                                 this.rd.setColor(this.color2k(170, 170, 170));
                                 this.rd
                                    .drawString(
                                       "[ Accepted or interaction replaced. ]",
                                       454 - this.ftm.stringWidth("[ Accepted or interaction replaced. ]") / 2,
                                       112 + 17 * var16 - this.scro
                                    );
                              }

                              this.rd.setFont(new Font("Tahoma", 0, 11));
                              this.ftm = this.rd.getFontMetrics();
                              if (this.stringbutton(
                                 this.rd,
                                 "  View Car  ",
                                 217 + this.ftm.stringWidth(this.iline[var16 + 2]) + 47,
                                 137 + 17 * var16 - this.scro,
                                 6,
                                 var1,
                                 var2,
                                 var3,
                                 0,
                                 0
                              )) {
                                 this.viewcar = this.getSvalue(this.iline[var16], 1);
                                 if (!this.claname.equals(this.intclan)) {
                                    this.claname = this.intclan;
                                    this.loadedc = false;
                                 }

                                 this.spos5 = 0;
                                 this.lspos5 = 0;
                                 this.cfase = 3;
                                 this.loadedcars = -1;
                                 this.loadedcar = 0;
                                 this.ctab = 2;
                                 this.tab = 3;
                              }

                              this.rd.setFont(new Font("Tahoma", 0, 11));
                              this.ftm = this.rd.getFontMetrics();
                              if (this.stringbutton(
                                 this.rd,
                                 "  View Car  ",
                                 217 + this.ftm.stringWidth(this.iline[var16 + 3]) + 47,
                                 154 + 17 * var16 - this.scro,
                                 6,
                                 var1,
                                 var2,
                                 var3,
                                 0,
                                 0
                              )) {
                                 this.viewcar = this.getSvalue(this.iline[var16], 2);
                                 if (!this.claname.equals(this.xt.clan)) {
                                    this.claname = this.xt.clan;
                                    this.loadedc = false;
                                 }

                                 this.spos5 = 0;
                                 this.lspos5 = 0;
                                 this.cfase = 3;
                                 this.loadedcars = -1;
                                 this.loadedcar = 0;
                                 this.ctab = 2;
                                 this.tab = 3;
                              }
                           }

                           if (this.ilinetyp[var16] == 20) {
                              if (this.stringbutton(this.rd, "  View Stage Battle  ", 289, 112 + 17 * var16 - this.scro, 0, var1, var2, var3, 0, 0)) {
                                 this.viewgame2 = 1;
                                 this.nvgames2 = 2;
                                 this.viewwar2 = this.getSvalue(this.iline[var16], 3);
                                 if (this.iline[var16].startsWith("I|")) {
                                    this.ichlng = true;
                                 } else {
                                    this.ichlng = false;
                                 }
                              }

                              if (!this.iline[var16].endsWith("|out|")) {
                                 if (this.iline[var16].startsWith("Y|")
                                    && this.stringbutton(this.rd, "  Accept Battle  ", 424, 112 + 17 * var16 - this.scro, 0, var1, var2, var3, 0, 0)) {
                                    this.gs.sendtyp.sel = 5;
                                    this.itake = this.getSvalue(this.iline[var16], 1);
                                    this.igive = this.getSvalue(this.iline[var16], 2);
                                    this.sendwar = this.getSvalue(this.iline[var16], 3);
                                 }
                              } else {
                                 this.rd.setColor(this.color2k(170, 170, 170));
                                 this.rd
                                    .drawString(
                                       "[ Accepted or interaction replaced. ]",
                                       468 - this.ftm.stringWidth("[ Accepted or interaction replaced. ]") / 2,
                                       112 + 17 * var16 - this.scro
                                    );
                              }

                              this.rd.setFont(new Font("Tahoma", 0, 11));
                              this.ftm = this.rd.getFontMetrics();
                              if (this.stringbutton(
                                 this.rd,
                                 "  View Stage  ",
                                 217 + this.ftm.stringWidth(this.iline[var16 + 2]) + 54,
                                 137 + 17 * var16 - this.scro,
                                 6,
                                 var1,
                                 var2,
                                 var3,
                                 0,
                                 0
                              )) {
                                 this.viewcar = this.getSvalue(this.iline[var16], 1);
                                 if (!this.claname.equals(this.intclan)) {
                                    this.claname = this.intclan;
                                    this.loadedc = false;
                                 }

                                 this.spos5 = 0;
                                 this.lspos5 = 0;
                                 this.cfase = 3;
                                 this.loadedstages = -1;
                                 this.loadedstage = 0;
                                 this.ctab = 3;
                                 this.tab = 3;
                              }

                              this.rd.setFont(new Font("Tahoma", 0, 11));
                              this.ftm = this.rd.getFontMetrics();
                              if (this.stringbutton(
                                 this.rd,
                                 "  View Stage  ",
                                 217 + this.ftm.stringWidth(this.iline[var16 + 3]) + 54,
                                 154 + 17 * var16 - this.scro,
                                 6,
                                 var1,
                                 var2,
                                 var3,
                                 0,
                                 0
                              )) {
                                 this.viewcar = this.getSvalue(this.iline[var16], 2);
                                 if (!this.claname.equals(this.xt.clan)) {
                                    this.claname = this.xt.clan;
                                    this.loadedc = false;
                                 }

                                 this.spos5 = 0;
                                 this.lspos5 = 0;
                                 this.cfase = 3;
                                 this.loadedstages = -1;
                                 this.loadedstage = 0;
                                 this.ctab = 3;
                                 this.tab = 3;
                              }
                           }

                           if (this.ilinetyp[var16] == 80) {
                              if (this.stringbutton(this.rd, "        View War        ", 284, 112 + 17 * var16 - this.scro, 0, var1, var2, var3, 0, 0)) {
                                 this.viewgame2 = 1;
                                 this.nvgames2 = 9;
                                 this.viewwar2 = this.getSvalue(this.iline[var16], 0);
                              }

                              if (this.stringbutton(this.rd, "  View Championship  ", 432, 112 + 17 * var16 - this.scro, 0, var1, var2, var3, 0, 0)) {
                                 this.cfase = 0;
                                 this.ntab = 1;
                                 this.loadwstat = 0;
                                 this.tab = 3;
                              }
                           }

                           if (this.ilinetyp[var16] == 90) {
                              if (this.stringbutton(this.rd, "        View Battle        ", 284, 112 + 17 * var16 - this.scro, 0, var1, var2, var3, 0, 0)) {
                                 this.viewgame2 = 1;
                                 this.nvgames2 = 5;
                                 this.viewwar2 = this.getSvalue(this.iline[var16], 0);
                              }

                              if (this.stringbutton(this.rd, "        View Car        ", 424, 112 + 17 * var16 - this.scro, 0, var1, var2, var3, 0, 0)) {
                                 this.viewcar = this.getSvalue(this.iline[var16], 1);
                                 String var65 = this.getSvalue(this.iline[var16], 2);
                                 if (!this.claname.equals(var65)) {
                                    this.claname = var65;
                                    this.loadedc = false;
                                 }

                                 this.spos5 = 0;
                                 this.lspos5 = 0;
                                 this.cfase = 3;
                                 this.loadedcars = -1;
                                 this.loadedcar = 0;
                                 this.ctab = 2;
                                 this.tab = 3;
                              }
                           }

                           if (this.ilinetyp[var16] == 100) {
                              if (this.stringbutton(this.rd, "        View Battle        ", 284, 112 + 17 * var16 - this.scro, 0, var1, var2, var3, 0, 0)) {
                                 this.viewgame2 = 1;
                                 this.nvgames2 = 5;
                                 this.viewwar2 = this.getSvalue(this.iline[var16], 0);
                              }

                              if (this.stringbutton(this.rd, "        View Stage        ", 431, 112 + 17 * var16 - this.scro, 0, var1, var2, var3, 0, 0)) {
                                 this.viewcar = this.getSvalue(this.iline[var16], 1);
                                 String var66 = this.getSvalue(this.iline[var16], 2);
                                 if (!this.claname.equals(var66)) {
                                    this.claname = var66;
                                    this.loadedc = false;
                                 }

                                 this.spos5 = 0;
                                 this.lspos5 = 0;
                                 this.cfase = 3;
                                 this.loadedstages = -1;
                                 this.loadedstage = 0;
                                 this.ctab = 3;
                                 this.tab = 3;
                              }
                           }
                        }
                     }
                  }
               }

               if (this.readint == 1) {
                  this.rd.setColor(this.color2k(240, 240, 240));
                  this.rd.fillRoundRect(387, 140, 200, 30, 20, 20);
                  this.rd.setColor(new Color(0, 0, 0));
                  this.rd.drawRoundRect(387, 140, 200, 30, 20, 20);
                  this.rd.setFont(new Font("Tahoma", 1, 11));
                  this.ftm = this.rd.getFontMetrics();
                  this.rd.drawString("Reading...", 487 - this.ftm.stringWidth("Reading...") / 2, 160);
               }

               if (this.readint == 3) {
                  this.rd.setFont(new Font("Tahoma", 1, 11));
                  this.ftm = this.rd.getFontMetrics();
                  this.rd.setColor(new Color(0, 0, 0));
                  this.rd.drawString("Failed to fetch and load interaction.", 487 - this.ftm.stringWidth("Failed to fetch and load interaction.") / 2, 200);
               }

               if (this.readint == 4) {
                  this.rd.setFont(new Font("Tahoma", 1, 11));
                  this.ftm = this.rd.getFontMetrics();
                  this.rd.setColor(new Color(0, 0, 0));
                  this.rd
                     .drawString(
                        "Failed to load interaction, server error, please try again later.",
                        487 - this.ftm.stringWidth("Failed to load interaction, server error, please try again later.") / 2,
                        200
                     );
               }

               if (this.readint == 5) {
                  this.rd.setFont(new Font("Tahoma", 1, 11));
                  this.ftm = this.rd.getFontMetrics();
                  this.rd.setColor(new Color(0, 0, 0));
                  this.rd
                     .drawString(
                        "Failed to send interaction, please try again later.",
                        487 - this.ftm.stringWidth("Failed to send interaction, please try again later.") / 2,
                        200
                     );
               }

               if (this.readint == 6) {
                  this.rd.setFont(new Font("Tahoma", 1, 11));
                  this.ftm = this.rd.getFontMetrics();
                  this.rd.setColor(new Color(0, 0, 0));
                  this.rd
                     .drawString(
                        "The war or battle you are trying to engage has expired or was not found...",
                        487 - this.ftm.stringWidth("The war or battle you are trying to engage has expired or was not found...") / 2,
                        200
                     );
               }

               this.rd.setColor(this.color2k(240, 240, 240));
               this.rd.fillRect(207, 47, 577, 39);
               this.rd.fillRect(207, 360, 577, 70);
               this.rd.setColor(this.color2k(205, 205, 205));
               this.rd.drawLine(207, 86, 783, 86);
               this.rd.drawLine(207, 86, 207, 360);
               this.rd.drawLine(207, 360, 783, 360);
               this.rd.fillRect(767, 104, 17, 239);
               if (this.mscro4 != 831 && this.sdist != 0) {
                  this.rd.setColor(this.color2k(220, 220, 220));
                  this.rd.fill3DRect(767, 87, 17, 17, true);
               } else {
                  if (this.sdist == 0) {
                     this.rd.setColor(this.color2k(205, 205, 205));
                  } else {
                     this.rd.setColor(this.color2k(215, 215, 215));
                  }

                  this.rd.fillRect(767, 87, 17, 17);
               }

               if (this.sdist != 0) {
                  this.rd.drawImage(this.xt.asu, 772, 93, null);
               }

               if (this.mscro4 != 832 && this.sdist != 0) {
                  this.rd.setColor(this.color2k(220, 220, 220));
                  this.rd.fill3DRect(767, 343, 17, 17, true);
               } else {
                  if (this.sdist == 0) {
                     this.rd.setColor(this.color2k(205, 205, 205));
                  } else {
                     this.rd.setColor(this.color2k(215, 215, 215));
                  }

                  this.rd.fillRect(767, 343, 17, 17);
               }

               if (this.sdist != 0) {
                  this.rd.drawImage(this.xt.asd, 772, 350, null);
               }

               if (this.sdist != 0) {
                  if (this.lspos4 != this.spos4) {
                     this.rd.setColor(this.color2k(215, 215, 215));
                     this.rd.fillRect(767, 104 + this.spos4, 17, 31);
                  } else {
                     if (this.mscro4 == 831) {
                        this.rd.setColor(this.color2k(215, 215, 215));
                     }

                     this.rd.fill3DRect(767, 104 + this.spos4, 17, 31, true);
                  }

                  this.rd.setColor(this.color2k(150, 150, 150));
                  this.rd.drawLine(772, 117 + this.spos4, 778, 117 + this.spos4);
                  this.rd.drawLine(772, 119 + this.spos4, 778, 119 + this.spos4);
                  this.rd.drawLine(772, 121 + this.spos4, 778, 121 + this.spos4);
                  if (this.mscro4 > 800 && this.lspos4 != this.spos4) {
                     this.lspos4 = this.spos4;
                  }

                  if (var3) {
                     if (this.mscro4 == 825 && var1 > 767 && var1 < 784 && var2 > 104 + this.spos4 && var2 < this.spos4 + 135) {
                        this.mscro4 = var2 - this.spos4;
                     }

                     if (this.mscro4 == 825 && var1 > 765 && var1 < 786 && var2 > 85 && var2 < 106) {
                        this.mscro4 = 831;
                     }

                     if (this.mscro4 == 825 && var1 > 765 && var1 < 786 && var2 > 341 && var2 < 362) {
                        this.mscro4 = 832;
                     }

                     if (this.mscro4 == 825 && var1 > 767 && var1 < 784 && var2 > 104 && var2 < 343) {
                        this.mscro4 = 119;
                        this.spos4 = var2 - this.mscro4;
                     }

                     int var17 = 2670 / this.sdist;
                     if (var17 < 1) {
                        var17 = 1;
                     }

                     if (this.mscro4 == 831) {
                        this.spos4 -= var17;
                        if (this.spos4 > 208) {
                           this.spos4 = 208;
                        }

                        if (this.spos4 < 0) {
                           this.spos4 = 0;
                        }

                        this.lspos4 = this.spos4;
                     }

                     if (this.mscro4 == 832) {
                        this.spos4 += var17;
                        if (this.spos4 > 208) {
                           this.spos4 = 208;
                        }

                        if (this.spos4 < 0) {
                           this.spos4 = 0;
                        }

                        this.lspos4 = this.spos4;
                     }

                     if (this.mscro4 < 800) {
                        this.spos4 = var2 - this.mscro4;
                        if (this.spos4 > 208) {
                           this.spos4 = 208;
                        }

                        if (this.spos4 < 0) {
                           this.spos4 = 0;
                        }
                     }

                     if (this.mscro4 == 825) {
                        this.mscro4 = 925;
                     }
                  } else if (this.mscro4 != 825) {
                     this.mscro4 = 825;
                  }
               }

               if (this.dispi != 0) {
                  short var18 = 558;
                  if (this.viewgame2 != 0) {
                     var18 = 577;
                  }

                  this.rd.setColor(this.color2k(220, 220, 220));
                  this.rd.fillRect(207, 86, var18, 41);
                  this.rd.setColor(this.color2k(150, 150, 150));
                  this.rd.drawRect(207, 86, var18, 41);
                  this.rd.setFont(new Font("Arial", 1, 12));
                  this.rd.setColor(new Color(0, 0, 0));
                  if (this.dispi == 1) {
                     this.rd.drawString("Car battle with " + this.intclan + " is on!", 215, 101);
                     this.rd.setFont(new Font("Arial", 0, 11));
                     this.ftm = this.rd.getFontMetrics();
                     this.rd.drawString("You win: [ " + this.dtcar + " ]", 215, 118);
                     int var67 = 215 + this.ftm.stringWidth("You win: [ " + this.dtcar + " ]") + 44;
                     if (this.stringbutton(this.rd, "View Car", var67, 119, 6, var1, var2, var3, 0, 0)) {
                        this.viewcar = this.dtcar;
                        if (!this.claname.equals(this.intclan)) {
                           this.claname = this.intclan;
                           this.loadedc = false;
                        }

                        this.spos5 = 0;
                        this.lspos5 = 0;
                        this.cfase = 3;
                        this.loadedcars = -1;
                        this.loadedcar = 0;
                        this.ctab = 2;
                        this.tab = 3;
                     }

                     var67 += 44;
                     this.rd.setFont(new Font("Arial", 0, 11));
                     this.ftm = this.rd.getFontMetrics();
                     this.rd.drawString("You lose: [ " + this.dgcar + " ]", var67, 118);
                     var67 += this.ftm.stringWidth("You lose: [ " + this.dgcar + " ]") + 44;
                     if (this.stringbutton(this.rd, "View Car", var67, 119, 6, var1, var2, var3, 0, 0)) {
                        this.viewcar = this.dgcar;
                        if (!this.claname.equals(this.xt.clan)) {
                           this.claname = this.xt.clan;
                           this.loadedc = false;
                        }

                        this.spos5 = 0;
                        this.lspos5 = 0;
                        this.cfase = 3;
                        this.loadedcars = -1;
                        this.loadedcar = 0;
                        this.ctab = 2;
                        this.tab = 3;
                     }

                     if (this.stringbutton(this.rd, "View Battle", 714, 111, 0, var1, var2, var3, 0, 0)) {
                        this.viewgame2 = 1;
                        this.nvgames2 = 5;
                        this.viewwar2 = this.dwarn;
                     }
                  }

                  if (this.dispi == 2) {
                     this.rd.drawString("Stage battle with " + this.intclan + " is on!", 215, 101);
                     this.rd.setFont(new Font("Arial", 0, 11));
                     this.ftm = this.rd.getFontMetrics();
                     String var70 = this.dtcar;
                     if (var70.length() > 10) {
                        var70 = "" + var70.substring(0, 10) + "...";
                     }

                     this.rd.drawString("You win: [ " + var70 + " ]", 215, 118);
                     int var114 = 215 + this.ftm.stringWidth("You win: [ " + var70 + " ]") + 51;
                     if (this.stringbutton(this.rd, "View Stage", var114, 119, 6, var1, var2, var3, 0, 0)) {
                        this.viewcar = this.dtcar;
                        if (!this.claname.equals(this.intclan)) {
                           this.claname = this.intclan;
                           this.loadedc = false;
                        }

                        this.spos5 = 0;
                        this.lspos5 = 0;
                        this.cfase = 3;
                        this.loadedstages = -1;
                        this.loadedstage = 0;
                        this.ctab = 3;
                        this.tab = 3;
                     }

                     var114 += 51;
                     this.rd.setFont(new Font("Arial", 0, 11));
                     this.ftm = this.rd.getFontMetrics();
                     var70 = this.dgcar;
                     if (var70.length() > 10) {
                        var70 = "" + var70.substring(0, 10) + "...";
                     }

                     this.rd.drawString("You lose: [ " + var70 + " ]", var114, 118);
                     var114 += this.ftm.stringWidth("You lose: [ " + var70 + " ]") + 51;
                     if (this.stringbutton(this.rd, "View Stage", var114, 119, 6, var1, var2, var3, 0, 0)) {
                        this.viewcar = this.dgcar;
                        if (!this.claname.equals(this.xt.clan)) {
                           this.claname = this.xt.clan;
                           this.loadedc = false;
                        }

                        this.spos5 = 0;
                        this.lspos5 = 0;
                        this.cfase = 3;
                        this.loadedstages = -1;
                        this.loadedstage = 0;
                        this.ctab = 3;
                        this.tab = 3;
                     }

                     if (this.stringbutton(this.rd, "View Battle", 714, 111, 0, var1, var2, var3, 0, 0)) {
                        this.viewgame2 = 1;
                        this.nvgames2 = 5;
                        this.viewwar2 = this.dwarn;
                     }
                  }

                  if (this.dispi == 3) {
                     this.rd.drawString("War between your clan and " + this.intclan + " has started!", 227, 111);
                     if (this.stringbutton(this.rd, "         View War         ", 670, 111, 0, var1, var2, var3, 0, 0)) {
                        this.viewgame2 = 1;
                        this.nvgames2 = 9;
                        this.viewwar2 = this.dwarn;
                     }
                  }
               }

               if (this.viewgame2 != 0) {
                  this.rd.setColor(this.color2k(210, 210, 210));
                  this.rd.fillRoundRect(204, 127, 583, 230, 20, 20);
                  this.rd.setColor(this.color2k(150, 150, 150));
                  this.rd.drawRoundRect(204, 127, 583, 230, 20, 20);
                  this.rd.setFont(new Font("Tahoma", 1, 11));
                  this.ftm = this.rd.getFontMetrics();
                  this.rd.setColor(new Color(0, 0, 0));
                  if (this.nvgames2 == 4) {
                     this.rd.drawString("War declaration, your clan " + this.xt.clan + " versus " + this.intclan + ".", 215, 145);
                     if (this.viewgame2 == 2) {
                        if (this.ichlng) {
                           this.rd
                              .drawString(
                                 "" + this.intclan + " would create 5 more games and the first clan to win 5 games wins the war!",
                                 215,
                                 210 + this.nvgames2 * 18
                              );
                        } else {
                           this.rd
                              .drawString("Your clan would create 5 more games and the first clan to win 5 games wins the war!", 215, 210 + this.nvgames2 * 18);
                        }
                     }
                  }

                  if (this.nvgames2 == 2) {
                     this.rd.drawString("Battle, your clan " + this.xt.clan + " versus " + this.intclan + ".", 215, 145);
                     if (this.viewgame2 == 2) {
                        if (this.ichlng) {
                           this.rd
                              .drawString(
                                 "" + this.intclan + " would create 3 more games and the first clan to win 3 games wins the battle!",
                                 215,
                                 210 + this.nvgames2 * 18
                              );
                        } else {
                           this.rd
                              .drawString(
                                 "Your clan would create 3 more games and the first clan to win 3 games wins the battle!", 215, 210 + this.nvgames2 * 18
                              );
                        }
                     }
                  }

                  if ((this.nvgames2 == 9 || this.nvgames2 == 5) && this.viewgame2 == 2) {
                     this.rd
                        .drawString(
                           "" + this.xt.clan + "  " + this.vwscorex + "           |           " + this.intclan + "  " + this.vwscorei + "",
                           505
                              - this.ftm
                                    .stringWidth(
                                       "" + this.xt.clan + "  " + this.vwscorex + "           |           " + this.intclan + "  " + this.vwscorei + ""
                                    )
                                 / 2,
                           145
                        );
                     this.rd.drawRect(320, 131, 370, 19);
                  }

                  if (this.stringbutton(this.rd, "Close X", 749, 148, 3, var1, var2, var3, 0, 0)) {
                     this.viewgame2 = 0;
                  }

                  this.rd.setFont(new Font("Tahoma", 1, 11));
                  this.ftm = this.rd.getFontMetrics();
                  this.rd.setColor(new Color(0, 0, 0));
                  if (this.viewgame2 == 2) {
                     this.rd.drawString("Game", 246 - this.ftm.stringWidth("Game") / 2, 175);
                     this.rd.drawString("Stage", 412 - this.ftm.stringWidth("Stage") / 2, 175);
                     this.rd.drawString("Laps", 564 - this.ftm.stringWidth("Laps") / 2, 175);
                     this.rd.drawString("Type of Cars", 653 - this.ftm.stringWidth("Type of Cars") / 2, 175);
                     this.rd.drawString("Fixing", 751 - this.ftm.stringWidth("Fixing") / 2, 175);
                     int var19 = 1;
                     byte var72 = 1;
                     if (this.nvgames2 == 4 || this.nvgames2 == 2) {
                        var19 = 2;
                        var72 = 2;
                     }

                     for (int var117 = 0; var117 < this.nvgames2; var117++) {
                        if (!this.vwinner[var117].equals("")) {
                           this.rd.setColor(this.color2k(220, 220, 220));
                           this.rd.fillRect(213, 180 + var117 * 18, 565, 18);
                           this.rd.setColor(new Color(0, 0, 0));
                        }

                        this.rd.setFont(new Font("Tahoma", 0, 11));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("# " + var19 + "", 246 - this.ftm.stringWidth("# " + var19 + "") / 2, 193 + var117 * 18);
                        var19 += var72;
                        this.rd.drawString(this.vwstages2[var117], 412 - this.ftm.stringWidth(this.vwstages2[var117]) / 2, 193 + var117 * 18);
                        this.rd.drawString("" + this.vwlaps2[var117] + "", 564 - this.ftm.stringWidth("" + this.vwlaps2[var117] + "") / 2, 193 + var117 * 18);
                        String var134 = "All Cars";
                        if (this.vwcars2[var117] == 2) {
                           var134 = "Clan Cars";
                        }

                        if (this.vwcars2[var117] == 3) {
                           var134 = "Game Cars";
                        }

                        if (this.vwclass2[var117] == 0) {
                           var134 = var134 + ", All Classes";
                        }

                        if (this.vwclass2[var117] == 1) {
                           var134 = var134 + ", Class C";
                        }

                        if (this.vwclass2[var117] == 2) {
                           var134 = var134 + ", Class B & C";
                        }

                        if (this.vwclass2[var117] == 3) {
                           var134 = var134 + ", Class B";
                        }

                        if (this.vwclass2[var117] == 4) {
                           var134 = var134 + ", Class A & B";
                        }

                        if (this.vwclass2[var117] == 5) {
                           var134 = var134 + ", Class A";
                        }

                        this.rd.drawString(var134, 653 - this.ftm.stringWidth(var134) / 2, 193 + var117 * 18);
                        String var149 = "Infinite";
                        if (this.vwfix2[var117] == 1) {
                           var149 = "4 Fixes";
                        }

                        if (this.vwfix2[var117] == 2) {
                           var149 = "3 Fixes";
                        }

                        if (this.vwfix2[var117] == 3) {
                           var149 = "2 Fixes";
                        }

                        if (this.vwfix2[var117] == 4) {
                           var149 = "1 Fix";
                        }

                        if (this.vwfix2[var117] == 5) {
                           var149 = "No Fixing";
                        }

                        this.rd.drawString(var149, 751 - this.ftm.stringWidth(var149) / 2, 193 + var117 * 18);
                        this.rd.drawRect(213, 180 + var117 * 18, 565, 18);
                     }

                     this.rd.drawLine(213, 162, 213, 180 + this.nvgames2 * 18);
                     this.rd.drawLine(279, 162, 279, 180 + this.nvgames2 * 18);
                     this.rd.drawLine(546, 162, 546, 180 + this.nvgames2 * 18);
                     this.rd.drawLine(583, 162, 583, 180 + this.nvgames2 * 18);
                     this.rd.drawLine(723, 162, 723, 180 + this.nvgames2 * 18);
                     this.rd.drawLine(778, 162, 778, 180 + this.nvgames2 * 18);

                     for (int var118 = 0; var118 < this.nvgames2; var118++) {
                        if (var1 > 213 && var1 < 778 && var2 > 180 + var118 * 18 && var2 < 198 + var118 * 18 && !this.vwinner[var118].equals("")) {
                           this.rd.setColor(this.color2k(230, 230, 230));
                           this.rd.fillRect(213, 180 + var118 * 18, 565, 18);
                           this.rd.setColor(new Color(0, 0, 0));
                           this.rd.setFont(new Font("Tahoma", 1, 11));
                           this.ftm = this.rd.getFontMetrics();
                           this.rd
                              .drawString(
                                 "" + this.vwinner[var118] + "  Wins!",
                                 495 - this.ftm.stringWidth("" + this.vwinner[var118] + "  Wins!") / 2,
                                 193 + var118 * 18
                              );
                           this.rd.drawRect(213, 180 + var118 * 18, 565, 18);
                        }
                     }
                  }

                  if (this.viewgame2 == 1) {
                     this.rd.drawString("Loading...", 495 - this.ftm.stringWidth("Loading...") / 2, 242);
                  }

                  if (this.viewgame2 == 3) {
                     if (this.nvgames2 == 4 || this.nvgames2 == 9) {
                        this.rd
                           .drawString(
                              "This war has expired and no longer exists.", 495 - this.ftm.stringWidth("This war has expired and no longer exists.") / 2, 232
                           );
                     }

                     if (this.nvgames2 == 2 || this.nvgames2 == 5) {
                        this.rd
                           .drawString(
                              "This battle has expired and no longer exists.",
                              495 - this.ftm.stringWidth("This battle has expired and no longer exists.") / 2,
                              232
                           );
                     }

                     if (this.nvgames2 != 9 && this.nvgames2 != 5) {
                        this.rd.drawString("(Suggestions expire after 90 days.)", 495 - this.ftm.stringWidth("(Suggestions expire after 90 days.)") / 2, 252);
                     } else {
                        this.rd
                           .drawString(
                              "(Started/finished wars and battles expire after 180 days.)",
                              495 - this.ftm.stringWidth("(Started/finished wars and battles expire after 180 days.)") / 2,
                              252
                           );
                     }
                  }

                  if (this.viewgame2 == 4) {
                     this.rd
                        .drawString(
                           "Error loading games, please try again later...",
                           495 - this.ftm.stringWidth("Error loading games, please try again later...") / 2,
                           242
                        );
                  }
               }

               this.rd.setFont(new Font("Arial", 1, 12));
               this.ftm = this.rd.getFontMetrics();
               if (!this.drawl(this.rd, "#" + this.intclan + "#", 207, 47, true)) {
                  this.rd.setColor(new Color(0, 0, 0));
                  this.rd.drawString(this.intclan, 382 - this.ftm.stringWidth(this.intclan) / 2, 66);
                  this.rd.setColor(this.color2k(150, 150, 150));
                  this.rd.drawRect(207, 47, 349, 29);
               }

               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawString("::  Versus your clan", 566, 72);
               if (var1 > 207 && var1 < 557 && var2 > 47 && var2 < 77) {
                  this.cur = 12;
                  if (var3) {
                     if (!this.claname.equals(this.intclan)) {
                        this.claname = this.intclan;
                        this.loadedc = false;
                     }

                     this.spos5 = 0;
                     this.lspos5 = 0;
                     this.cfase = 3;
                     this.ctab = 0;
                     this.tab = 3;
                  }
               }

               if (this.stringbutton(this.rd, "Close X", 752, 66, 0, var1, var2, var3, 0, 0)) {
                  this.openi = 0;
                  this.readint = 0;
                  this.viewgame2 = 0;
               }

               if (this.gs.sendtyp.getSelectedIndex() < 5) {
                  if (!this.gs.sendtyp.isShowing()) {
                     this.gs.sendtyp.show();
                  }

                  this.gs.sendtyp.move(207, 365);
               } else {
                  this.gs.sendtyp.hide();
                  this.rd.setFont(new Font("Arial", 1, 12));
                  this.rd.setColor(new Color(0, 0, 0));
                  if (this.gs.sendtyp.getSelectedIndex() == 5) {
                     this.rd.drawString("::  Accept Stage Battle", 207, 382);
                  }

                  if (this.gs.sendtyp.getSelectedIndex() == 6) {
                     this.rd.drawString("::  Accept Car Battle", 207, 382);
                  }

                  if (this.gs.sendtyp.getSelectedIndex() == 7) {
                     this.rd.drawString("::  Accept War", 207, 382);
                  }

                  if (this.stringbutton(this.rd, "  Cancel  ", 742, 382, 3, var1, var2, var3, 0, 0)) {
                     this.gs.sendtyp.select(0);
                  }
               }

               if (this.sendint != 0) {
                  this.gs.sendtyp.disable();
               } else {
                  this.gs.sendtyp.enable();
               }

               if (this.intsel != this.gs.sendtyp.getSelectedIndex()) {
                  this.gs.senditem.hide();
                  this.gs.datat.hide();
                  this.gs.ilaps.hide();
                  this.gs.icars.hide();
                  this.gs.sclass.hide();
                  this.gs.sfix.hide();
                  this.gs.senditem.enable();
                  this.gs.datat.enable();
                  this.gs.ilaps.enable();
                  this.gs.icars.enable();
                  this.gs.sclass.enable();
                  this.gs.sfix.enable();
                  this.intsel = this.gs.sendtyp.getSelectedIndex();
                  this.inishsel = true;
               }

               if (this.gs.sendtyp.getSelectedIndex() == 0) {
                  this.dommsg = true;
                  if (this.sendint == 0) {
                     if (this.stringbutton(this.rd, "   Send  >  ", 723, 408, 0, var1, var2, var3, 0, 0)
                        && !this.gs.mmsg.getText().trim().equals("")
                        && this.gs.mmsg.getText().toLowerCase().indexOf(this.gs.tpass.getText().toLowerCase()) == -1
                        && this.xt.acexp != -3) {
                        if (!this.xt.msgcheck(this.gs.mmsg.getText())) {
                           this.sendint = 1;
                        } else {
                           this.gs.sendtyp.hide();
                           this.xt.warning++;
                        }
                     }
                  } else {
                     this.rd.setFont(new Font("Arial", 1, 12));
                     this.ftm = this.rd.getFontMetrics();
                     this.rd.setColor(new Color(0, 0, 0));
                     this.rd.drawString("Sending...", 723 - this.ftm.stringWidth("Sending...") / 2, 408);
                  }
               }

               if (this.gs.sendtyp.getSelectedIndex() == 1) {
                  this.rd.setFont(new Font("Arial", 0, 12));
                  this.rd.drawString("A date that gets converted to the local time of any person previewing it.", 376, 382);
                  if (!this.gs.senditem.isShowing()) {
                     this.gs.senditem.removeAll();
                     Calendar var20 = Calendar.getInstance();
                     boolean var73 = false;

                     for (int var119 = 0; var119 < 20; var119++) {
                        String var135 = this.wday[var20.get(7) - 1];
                        if (!var73) {
                           var135 = "Today";
                           var73 = true;
                        }

                        this.gs.senditem.add(this.rd, "" + var135 + "  -  " + this.month[var20.get(2)] + " " + var20.get(5) + "");
                        var20.roll(5, true);
                     }

                     this.gs.senditem.select(0);
                     this.gs.senditem.show();
                  }

                  if (!this.gs.datat.isShowing()) {
                     this.gs.datat.removeAll();
                     int var21 = 12;
                     String var74 = "PM";

                     for (int var120 = 0; var120 < 24; var120++) {
                        this.gs.datat.add(this.rd, "" + var21 + " " + var74 + "");
                        if (++var21 == 12) {
                           var74 = "AM";
                        }

                        if (var21 == 13) {
                           var21 = 1;
                        }
                     }

                     this.gs.datat.select(0);
                     this.gs.datat.show();
                  }

                  this.gs.senditem.move(300, 395);
                  this.gs.datat.move(491, 395);
                  this.rd.setFont(new Font("Arial", 1, 12));
                  this.ftm = this.rd.getFontMetrics();
                  this.rd.drawString("Date is displayed based on your computer calendar's date/time, please make sure it is correct.", 207, 435);
                  if (this.sendint == 0) {
                     if (this.stringbutton(this.rd, "   Send  >  ", 723, 408, 0, var1, var2, var3, 0, 0)) {
                        this.sendint = 1;
                     }
                  } else {
                     this.rd.setFont(new Font("Arial", 1, 12));
                     this.ftm = this.rd.getFontMetrics();
                     this.rd.drawString("Sending...", 723 - this.ftm.stringWidth("Sending...") / 2, 408);
                  }
               }

               if (this.gs.sendtyp.getSelectedIndex() == 2) {
                  if (this.inishsel) {
                     if (this.redif) {
                        this.ifas = 1;
                        this.gs.datat.removeAll();

                        for (int var22 = 0; var22 < this.gs.clcars.getItemCount(); var22++) {
                           this.gs.datat.add(this.rd, this.gs.clcars.getItem(var22));
                        }

                        this.gs.datat.select(this.gs.clcars.getSelectedIndex());
                        this.redif = false;
                     } else {
                        this.ifas = 0;
                        this.gs.datat.removeAll();
                        this.gs.datat.add(this.rd, "Loading " + this.intclan + "'s stages, please wait...");
                     }

                     this.imsg = "Battle over a stage that belongs to " + this.intclan + " to take it.";
                     this.iflk = 0;
                     if (this.sendwarnum) {
                        this.ifas = 4;
                        this.sendint = 1;
                        this.gs.senditem.disable();
                        this.gs.datat.disable();
                        this.gs.ilaps.disable();
                        this.gs.icars.disable();
                        this.gs.sclass.disable();
                        this.gs.sfix.disable();
                     }
                  }

                  this.rd.setFont(new Font("Arial", 0, 12));
                  if (this.iflk % 3 != 0 || this.iflk == 0) {
                     this.rd.drawString(this.imsg, 376, 382);
                  }

                  if (this.iflk != 0) {
                     this.iflk--;
                  }

                  if (this.ifas == 0 || this.ifas == 1) {
                     this.rd.setFont(new Font("Arial", 1, 12));
                     this.rd.drawString("Choose the stage of " + this.intclan + " you want to take to your clan, if you win!", 207, 402);
                     if (!this.gs.datat.isShowing()) {
                        this.gs.datat.show();
                     }

                     this.gs.datat.move(495 - this.gs.datat.getWidth() / 2, 410);
                  }

                  if (this.ifas == 2 || this.ifas == 3) {
                     this.rd.setFont(new Font("Arial", 1, 12));
                     this.rd.drawString("Choose a stage of your clan that you would give to " + this.intclan + ", if you lose!", 207, 402);
                     if (!this.gs.datat.isShowing()) {
                        this.gs.datat.show();
                     }

                     this.gs.datat.move(495 - this.gs.datat.getWidth() / 2, 410);
                  }

                  if (this.ifas == 4 || this.ifas == 5) {
                     if (this.ifas == 4) {
                        this.isel = 0;
                        this.gs.senditem.removeAll();
                        this.gs.senditem.add(this.rd, " NFM Multiplayer ");
                        this.gs.senditem.add(this.rd, " NFM 2     ");
                        this.gs.senditem.add(this.rd, " NFM 1     ");
                        this.gs.senditem.add(this.rd, " Clan Stages ");
                        this.gs.senditem.select(0);
                        this.gs.datat.removeAll();
                        this.gs.datat.add(this.rd, "Select Stage");

                        for (int var23 = 0; var23 < 5; var23++) {
                           this.gs.datat.add(this.rd, " Stage " + (var23 + 1) + "");
                        }

                        this.gs.datat.select(0);
                        this.gs.ilaps.hide();
                        this.gs.icars.hide();
                        this.gs.sclass.hide();
                        this.gs.sfix.hide();
                        this.ifas = 5;
                     }

                     this.rd.setFont(new Font("Arial", 0, 12));
                     if (this.iflk % 3 != 0 || this.iflk == 0) {
                        this.rd.drawString(this.imsg, 376, 382);
                     }

                     if (this.iflk != 0) {
                        this.iflk--;
                     }

                     this.rd.setFont(new Font("Arial", 1, 12));
                     this.rd.drawString("Game #" + (this.wag * 2 + 2) + " :", 207, 407);
                     if (!this.gs.senditem.isShowing()) {
                        this.gs.senditem.show();
                     }

                     this.gs.senditem.move(280, 390);
                     if (!this.gs.datat.isShowing()) {
                        this.gs.datat.show();
                     }

                     this.gs.datat.move(286 + this.gs.senditem.getWidth(), 390);
                     int var24 = 207;
                     if (!this.gs.ilaps.isShowing()) {
                        this.gs.ilaps.show();
                        this.gs.ilaps.select(0);
                     }

                     this.gs.ilaps.move(var24, 415);
                     var24 += 6 + this.gs.ilaps.getWidth();
                     if (!this.gs.icars.isShowing()) {
                        this.gs.icars.show();
                        this.gs.icars.select(0);
                     }

                     this.gs.icars.move(var24, 415);
                     var24 += 6 + this.gs.icars.getWidth();
                     if (!this.gs.sclass.isShowing()) {
                        this.gs.sclass.show();
                        this.gs.sclass.select(0);
                     }

                     this.gs.sclass.move(var24, 415);
                     this.gs.sclass.revup = true;
                     var24 += 6 + this.gs.sclass.getWidth();
                     if (!this.gs.sfix.isShowing()) {
                        this.gs.sfix.show();
                        this.gs.sfix.select(0);
                     }

                     this.gs.sfix.move(var24, 415);
                     this.gs.sfix.revup = true;
                     this.gs.datat.setSize(var24 + this.gs.sfix.getWidth() - 286 - this.gs.senditem.getWidth(), 22);
                     if (this.gs.senditem.getSelectedIndex() == 0 && this.isel != 0) {
                        this.gs.datat.removeAll();
                        this.gs.datat.add(this.rd, "Select Stage");

                        for (int var75 = 0; var75 < 5; var75++) {
                           this.gs.datat.add(this.rd, " Stage " + (var75 + 1) + "");
                        }

                        this.gs.datat.select(0);
                        this.isel = 0;
                     }

                     if (this.gs.senditem.getSelectedIndex() == 1 && this.isel != 1) {
                        this.gs.datat.removeAll();
                        this.gs.datat.add(this.rd, "Select Stage");

                        for (int var76 = 0; var76 < 17; var76++) {
                           this.gs.datat.add(this.rd, " Stage " + (var76 + 1) + "");
                        }

                        this.gs.datat.select(0);
                        this.isel = 1;
                     }

                     if (this.gs.senditem.getSelectedIndex() == 2 && this.isel != 2) {
                        this.gs.datat.removeAll();
                        this.gs.datat.add(this.rd, "Select Stage");

                        for (int var77 = 0; var77 < 10; var77++) {
                           this.gs.datat.add(this.rd, " Stage " + (var77 + 1) + "");
                        }

                        this.gs.datat.select(0);
                        this.isel = 2;
                     }

                     if (this.gs.senditem.getSelectedIndex() == 3 && this.isel < 3) {
                        this.gs.datat.removeAll();
                        this.gs.datat.add(this.rd, "Loading stages, please wait...");
                        this.gs.datat.select(0);
                        this.isel = 3;
                     }
                  }

                  if (this.sendint == 0) {
                     String var28 = "  Next >  ";
                     if (this.ifas == 5 && this.wag == 1) {
                        var28 = "   Done   ";
                     }

                     if (this.stringbutton(this.rd, var28, 742, 417, 0, var1, var2, var3, 0, 0)) {
                        if (this.ifas == 4 || this.ifas == 5) {
                           if (this.gs.datat.getSelectedIndex() != 0) {
                              if (this.gs.ilaps.getSelectedIndex() != 0) {
                                 if (this.gs.icars.getSelectedIndex() != 0) {
                                    if (this.gs.senditem.getSelectedIndex() == 0) {
                                       this.wstages[this.wag] = "#" + (this.gs.datat.getSelectedIndex() + 27) + "";
                                    }

                                    if (this.gs.senditem.getSelectedIndex() == 1) {
                                       this.wstages[this.wag] = "#" + (this.gs.datat.getSelectedIndex() + 10) + "";
                                    }

                                    if (this.gs.senditem.getSelectedIndex() == 2) {
                                       this.wstages[this.wag] = "#" + this.gs.datat.getSelectedIndex() + "";
                                    }

                                    if (this.gs.senditem.getSelectedIndex() == 3) {
                                       this.wstages[this.wag] = "" + this.gs.datat.getSelectedItem() + "";
                                    }

                                    this.wlaps[this.wag] = this.gs.ilaps.getSelectedIndex();
                                    this.wcars[this.wag] = this.gs.icars.getSelectedIndex();
                                    this.wclass[this.wag] = this.gs.sclass.getSelectedIndex();
                                    this.wfix[this.wag] = this.gs.sfix.getSelectedIndex();
                                    this.wag++;
                                    if (this.wag < 2) {
                                       this.ifas = 4;
                                       this.imsg = "Create second game.";
                                    } else {
                                       this.wag--;
                                       this.sendint = 1;
                                       this.gs.senditem.disable();
                                       this.gs.datat.disable();
                                       this.gs.ilaps.disable();
                                       this.gs.icars.disable();
                                       this.gs.sclass.disable();
                                       this.gs.sfix.disable();
                                    }
                                 } else {
                                    this.imsg = "Please choose a type of cars for this game!";
                                    this.iflk = 40;
                                 }
                              } else {
                                 this.imsg = "Please select a number of laps!";
                                 this.iflk = 40;
                              }
                           } else {
                              this.imsg = "Please select a stage!";
                              this.iflk = 40;
                           }
                        }

                        if (this.ifas == 2 || this.ifas == 3) {
                           if (this.gs.datat.getSelectedIndex() == 0) {
                              this.imsg = "Please choose a stage to give to " + this.intclan + " if you lose!";
                              this.iflk = 40;
                           } else {
                              this.imsg = "Create 2 games and " + this.intclan + " will create another 3.";
                              this.iflk = 0;
                              this.igive = this.gs.datat.getSelectedItem();
                              this.ifas = 4;
                              this.wag = 0;
                           }
                        }

                        if (this.ifas == 0 || this.ifas == 1) {
                           if (this.gs.datat.getSelectedIndex() == 0) {
                              this.imsg = "Please choose a stage to battle over!";
                              this.iflk = 40;
                           } else {
                              this.imsg = "Battle over a stage that belongs to " + this.intclan + " to take it.";
                              this.iflk = 0;
                              this.itake = this.gs.datat.getSelectedItem();
                              this.gs.datat.removeAll();
                              this.gs.datat.add(this.rd, "Loading your clan's stages, please wait...");
                              this.ifas = 2;
                           }
                        }
                     }
                  } else {
                     this.imsg = "Sending stage battle, pleas wait...";
                     this.rd.setFont(new Font("Arial", 1, 12));
                     this.ftm = this.rd.getFontMetrics();
                     this.rd.setColor(new Color(0, 0, 0));
                     this.rd.drawString("Sending...", 742 - this.ftm.stringWidth("Sending...") / 2, 417);
                  }
               }

               if (this.gs.sendtyp.getSelectedIndex() == 3) {
                  if (this.inishsel) {
                     if (this.redif) {
                        this.ifas = 1;
                        this.gs.datat.removeAll();

                        for (int var29 = 0; var29 < this.gs.clcars.getItemCount(); var29++) {
                           this.gs.datat.add(this.rd, this.gs.clcars.getItem(var29));
                        }

                        this.gs.datat.select(this.gs.clcars.getSelectedIndex());
                        this.redif = false;
                     } else {
                        this.ifas = 0;
                        this.gs.datat.removeAll();
                        this.gs.datat.add(this.rd, "Loading " + this.intclan + "'s cars, please wait...");
                     }

                     this.imsg = "Battle over a car that belongs to " + this.intclan + " to take it.";
                     this.iflk = 0;
                     if (this.sendwarnum) {
                        this.ifas = 4;
                        this.sendint = 1;
                        this.gs.senditem.disable();
                        this.gs.datat.disable();
                        this.gs.ilaps.disable();
                        this.gs.icars.disable();
                        this.gs.sclass.disable();
                        this.gs.sfix.disable();
                     }
                  }

                  this.rd.setFont(new Font("Arial", 0, 12));
                  if (this.iflk % 3 != 0 || this.iflk == 0) {
                     this.rd.drawString(this.imsg, 376, 382);
                  }

                  if (this.iflk != 0) {
                     this.iflk--;
                  }

                  if (this.ifas == 0 || this.ifas == 1) {
                     this.rd.setFont(new Font("Arial", 1, 12));
                     this.rd.drawString("Choose the car of " + this.intclan + " you want to take to your clan, if you win!", 207, 402);
                     if (!this.gs.datat.isShowing()) {
                        this.gs.datat.show();
                     }

                     this.gs.datat.move(495 - this.gs.datat.getWidth() / 2, 410);
                  }

                  if (this.ifas == 2 || this.ifas == 3) {
                     this.rd.setFont(new Font("Arial", 1, 12));
                     this.rd.drawString("Choose a car of your clan that you would give to " + this.intclan + ", if you lose!", 207, 402);
                     if (!this.gs.datat.isShowing()) {
                        this.gs.datat.show();
                     }

                     this.gs.datat.move(495 - this.gs.datat.getWidth() / 2, 410);
                  }

                  if (this.ifas == 4 || this.ifas == 5) {
                     if (this.ifas == 4) {
                        this.isel = 0;
                        this.gs.senditem.removeAll();
                        this.gs.senditem.add(this.rd, " NFM Multiplayer ");
                        this.gs.senditem.add(this.rd, " NFM 2     ");
                        this.gs.senditem.add(this.rd, " NFM 1     ");
                        this.gs.senditem.add(this.rd, " Clan Stages ");
                        this.gs.senditem.select(0);
                        this.gs.datat.removeAll();
                        this.gs.datat.add(this.rd, "Select Stage");

                        for (int var30 = 0; var30 < 5; var30++) {
                           this.gs.datat.add(this.rd, " Stage " + (var30 + 1) + "");
                        }

                        this.gs.datat.select(0);
                        this.gs.ilaps.hide();
                        this.gs.icars.hide();
                        this.gs.sclass.hide();
                        this.gs.sfix.hide();
                        this.ifas = 5;
                     }

                     this.rd.setFont(new Font("Arial", 0, 12));
                     if (this.iflk % 3 != 0 || this.iflk == 0) {
                        this.rd.drawString(this.imsg, 376, 382);
                     }

                     if (this.iflk != 0) {
                        this.iflk--;
                     }

                     this.rd.setFont(new Font("Arial", 1, 12));
                     this.rd.drawString("Game #" + (this.wag * 2 + 2) + " :", 207, 407);
                     if (!this.gs.senditem.isShowing()) {
                        this.gs.senditem.show();
                     }

                     this.gs.senditem.move(280, 390);
                     if (!this.gs.datat.isShowing()) {
                        this.gs.datat.show();
                     }

                     this.gs.datat.move(286 + this.gs.senditem.getWidth(), 390);
                     int var31 = 207;
                     if (!this.gs.ilaps.isShowing()) {
                        this.gs.ilaps.show();
                        this.gs.ilaps.select(0);
                     }

                     this.gs.ilaps.move(var31, 415);
                     var31 += 6 + this.gs.ilaps.getWidth();
                     if (!this.gs.icars.isShowing()) {
                        this.gs.icars.show();
                        this.gs.icars.select(0);
                     }

                     this.gs.icars.move(var31, 415);
                     var31 += 6 + this.gs.icars.getWidth();
                     if (!this.gs.sclass.isShowing()) {
                        this.gs.sclass.show();
                        this.gs.sclass.select(0);
                     }

                     this.gs.sclass.move(var31, 415);
                     this.gs.sclass.revup = true;
                     var31 += 6 + this.gs.sclass.getWidth();
                     if (!this.gs.sfix.isShowing()) {
                        this.gs.sfix.show();
                        this.gs.sfix.select(0);
                     }

                     this.gs.sfix.move(var31, 415);
                     this.gs.sfix.revup = true;
                     this.gs.datat.setSize(var31 + this.gs.sfix.getWidth() - 286 - this.gs.senditem.getWidth(), 22);
                     if (this.gs.senditem.getSelectedIndex() == 0 && this.isel != 0) {
                        this.gs.datat.removeAll();
                        this.gs.datat.add(this.rd, "Select Stage");

                        for (int var78 = 0; var78 < 5; var78++) {
                           this.gs.datat.add(this.rd, " Stage " + (var78 + 1) + "");
                        }

                        this.gs.datat.select(0);
                        this.isel = 0;
                     }

                     if (this.gs.senditem.getSelectedIndex() == 1 && this.isel != 1) {
                        this.gs.datat.removeAll();
                        this.gs.datat.add(this.rd, "Select Stage");

                        for (int var79 = 0; var79 < 17; var79++) {
                           this.gs.datat.add(this.rd, " Stage " + (var79 + 1) + "");
                        }

                        this.gs.datat.select(0);
                        this.isel = 1;
                     }

                     if (this.gs.senditem.getSelectedIndex() == 2 && this.isel != 2) {
                        this.gs.datat.removeAll();
                        this.gs.datat.add(this.rd, "Select Stage");

                        for (int var80 = 0; var80 < 10; var80++) {
                           this.gs.datat.add(this.rd, " Stage " + (var80 + 1) + "");
                        }

                        this.gs.datat.select(0);
                        this.isel = 2;
                     }

                     if (this.gs.senditem.getSelectedIndex() == 3 && this.isel < 3) {
                        this.gs.datat.removeAll();
                        this.gs.datat.add(this.rd, "Loading stages, please wait...");
                        this.gs.datat.select(0);
                        this.isel = 3;
                     }
                  }

                  if (this.sendint == 0) {
                     String var35 = "  Next >  ";
                     if (this.ifas == 5 && this.wag == 1) {
                        var35 = "   Done   ";
                     }

                     if (this.stringbutton(this.rd, var35, 742, 417, 0, var1, var2, var3, 0, 0)) {
                        if (this.ifas == 4 || this.ifas == 5) {
                           if (this.gs.datat.getSelectedIndex() != 0) {
                              if (this.gs.ilaps.getSelectedIndex() != 0) {
                                 if (this.gs.icars.getSelectedIndex() != 0) {
                                    if (this.gs.senditem.getSelectedIndex() == 0) {
                                       this.wstages[this.wag] = "#" + (this.gs.datat.getSelectedIndex() + 27) + "";
                                    }

                                    if (this.gs.senditem.getSelectedIndex() == 1) {
                                       this.wstages[this.wag] = "#" + (this.gs.datat.getSelectedIndex() + 10) + "";
                                    }

                                    if (this.gs.senditem.getSelectedIndex() == 2) {
                                       this.wstages[this.wag] = "#" + this.gs.datat.getSelectedIndex() + "";
                                    }

                                    if (this.gs.senditem.getSelectedIndex() == 3) {
                                       this.wstages[this.wag] = "" + this.gs.datat.getSelectedItem() + "";
                                    }

                                    this.wlaps[this.wag] = this.gs.ilaps.getSelectedIndex();
                                    this.wcars[this.wag] = this.gs.icars.getSelectedIndex();
                                    this.wclass[this.wag] = this.gs.sclass.getSelectedIndex();
                                    this.wfix[this.wag] = this.gs.sfix.getSelectedIndex();
                                    this.wag++;
                                    if (this.wag < 2) {
                                       this.ifas = 4;
                                       this.imsg = "Create second game.";
                                    } else {
                                       this.wag--;
                                       this.sendint = 1;
                                       this.gs.senditem.disable();
                                       this.gs.datat.disable();
                                       this.gs.ilaps.disable();
                                       this.gs.icars.disable();
                                       this.gs.sclass.disable();
                                       this.gs.sfix.disable();
                                    }
                                 } else {
                                    this.imsg = "Please choose a type of cars for this game!";
                                    this.iflk = 40;
                                 }
                              } else {
                                 this.imsg = "Please select a number of laps!";
                                 this.iflk = 40;
                              }
                           } else {
                              this.imsg = "Please select a stage!";
                              this.iflk = 40;
                           }
                        }

                        if (this.ifas == 2 || this.ifas == 3) {
                           if (this.gs.datat.getSelectedIndex() == 0) {
                              this.imsg = "Please choose a car to give to " + this.intclan + " if you lose!";
                              this.iflk = 40;
                           } else {
                              this.imsg = "Create 2 games and " + this.intclan + " will create another 3.";
                              this.iflk = 0;
                              this.igive = this.gs.datat.getSelectedItem();
                              this.ifas = 4;
                              this.wag = 0;
                           }
                        }

                        if (this.ifas == 0 || this.ifas == 1) {
                           if (this.gs.datat.getSelectedIndex() == 0) {
                              this.imsg = "Please choose a car to battle over!";
                              this.iflk = 40;
                           } else {
                              this.imsg = "Battle over a car that belongs to " + this.intclan + " to take it.";
                              this.iflk = 0;
                              this.itake = this.gs.datat.getSelectedItem();
                              this.gs.datat.removeAll();
                              this.gs.datat.add(this.rd, "Loading your clan's cars, please wait...");
                              this.ifas = 2;
                           }
                        }
                     }
                  } else {
                     this.imsg = "Sending car battle, pleas wait...";
                     this.rd.setFont(new Font("Arial", 1, 12));
                     this.ftm = this.rd.getFontMetrics();
                     this.rd.setColor(new Color(0, 0, 0));
                     this.rd.drawString("Sending...", 742 - this.ftm.stringWidth("Sending...") / 2, 417);
                  }
               }

               if (this.gs.sendtyp.getSelectedIndex() == 4) {
                  if (this.inishsel || this.redif) {
                     this.isel = 0;
                     this.gs.senditem.removeAll();
                     this.gs.senditem.add(this.rd, " NFM Multiplayer ");
                     this.gs.senditem.add(this.rd, " NFM 2     ");
                     this.gs.senditem.add(this.rd, " NFM 1     ");
                     this.gs.senditem.add(this.rd, " Clan Stages ");
                     this.gs.senditem.select(0);
                     this.gs.datat.removeAll();
                     this.gs.datat.add(this.rd, "Select Stage");

                     for (int var36 = 0; var36 < 5; var36++) {
                        this.gs.datat.add(this.rd, " Stage " + (var36 + 1) + "");
                     }

                     this.gs.datat.select(0);
                     if (!this.redif) {
                        this.wag = 0;
                        this.imsg = "Create 4 games and " + this.intclan + " will create another 5.";
                        this.iflk = 0;
                     } else {
                        this.imsg = "Create next game.";
                        if (this.wag == 3) {
                           this.imsg = "Create last game.";
                        }

                        this.iflk = 0;
                        this.gs.ilaps.hide();
                        this.gs.icars.hide();
                        this.gs.sclass.hide();
                        this.gs.sfix.hide();
                     }

                     if (this.sendwarnum) {
                        this.sendint = 1;
                        this.gs.senditem.disable();
                        this.gs.datat.disable();
                        this.gs.ilaps.disable();
                        this.gs.icars.disable();
                        this.gs.sclass.disable();
                        this.gs.sfix.disable();
                     }

                     this.redif = false;
                  }

                  this.rd.setFont(new Font("Arial", 0, 12));
                  if (this.iflk % 3 != 0 || this.iflk == 0) {
                     this.rd.drawString(this.imsg, 376, 382);
                  }

                  if (this.iflk != 0) {
                     this.iflk--;
                  }

                  this.rd.setFont(new Font("Arial", 1, 12));
                  this.rd.drawString("Game #" + (this.wag * 2 + 2) + " :", 207, 407);
                  if (!this.gs.senditem.isShowing()) {
                     this.gs.senditem.show();
                  }

                  this.gs.senditem.move(280, 390);
                  if (!this.gs.datat.isShowing()) {
                     this.gs.datat.show();
                  }

                  this.gs.datat.move(286 + this.gs.senditem.getWidth(), 390);
                  int var37 = 207;
                  if (!this.gs.ilaps.isShowing()) {
                     this.gs.ilaps.show();
                     this.gs.ilaps.select(0);
                  }

                  this.gs.ilaps.move(var37, 415);
                  var37 += 6 + this.gs.ilaps.getWidth();
                  if (!this.gs.icars.isShowing()) {
                     this.gs.icars.show();
                     this.gs.icars.select(0);
                  }

                  this.gs.icars.move(var37, 415);
                  var37 += 6 + this.gs.icars.getWidth();
                  if (!this.gs.sclass.isShowing()) {
                     this.gs.sclass.show();
                     this.gs.sclass.select(0);
                  }

                  this.gs.sclass.move(var37, 415);
                  this.gs.sclass.revup = true;
                  var37 += 6 + this.gs.sclass.getWidth();
                  if (!this.gs.sfix.isShowing()) {
                     this.gs.sfix.show();
                     this.gs.sfix.select(0);
                  }

                  this.gs.sfix.move(var37, 415);
                  this.gs.sfix.revup = true;
                  this.gs.datat.setSize(var37 + this.gs.sfix.getWidth() - 286 - this.gs.senditem.getWidth(), 22);
                  if (this.gs.senditem.getSelectedIndex() == 0 && this.isel != 0) {
                     this.gs.datat.removeAll();
                     this.gs.datat.add(this.rd, "Select Stage");

                     for (int var81 = 0; var81 < 5; var81++) {
                        this.gs.datat.add(this.rd, " Stage " + (var81 + 1) + "");
                     }

                     this.gs.datat.select(0);
                     this.isel = 0;
                  }

                  if (this.gs.senditem.getSelectedIndex() == 1 && this.isel != 1) {
                     this.gs.datat.removeAll();
                     this.gs.datat.add(this.rd, "Select Stage");

                     for (int var82 = 0; var82 < 17; var82++) {
                        this.gs.datat.add(this.rd, " Stage " + (var82 + 1) + "");
                     }

                     this.gs.datat.select(0);
                     this.isel = 1;
                  }

                  if (this.gs.senditem.getSelectedIndex() == 2 && this.isel != 2) {
                     this.gs.datat.removeAll();
                     this.gs.datat.add(this.rd, "Select Stage");

                     for (int var83 = 0; var83 < 10; var83++) {
                        this.gs.datat.add(this.rd, " Stage " + (var83 + 1) + "");
                     }

                     this.gs.datat.select(0);
                     this.isel = 2;
                  }

                  if (this.gs.senditem.getSelectedIndex() == 3 && this.isel < 3) {
                     this.gs.datat.removeAll();
                     this.gs.datat.add(this.rd, "Loading stages, please wait...");
                     this.gs.datat.select(0);
                     this.isel = 3;
                  }

                  if (this.sendint == 0) {
                     String var84 = "  Next >  ";
                     if (this.wag == 3) {
                        var84 = "   Done   ";
                     }

                     if (this.stringbutton(this.rd, var84, 742, 417, 0, var1, var2, var3, 0, 0)) {
                        if (this.gs.datat.getSelectedIndex() != 0) {
                           if (this.gs.ilaps.getSelectedIndex() != 0) {
                              if (this.gs.icars.getSelectedIndex() != 0) {
                                 if (this.gs.senditem.getSelectedIndex() == 0) {
                                    this.wstages[this.wag] = "#" + (this.gs.datat.getSelectedIndex() + 27) + "";
                                 }

                                 if (this.gs.senditem.getSelectedIndex() == 1) {
                                    this.wstages[this.wag] = "#" + (this.gs.datat.getSelectedIndex() + 10) + "";
                                 }

                                 if (this.gs.senditem.getSelectedIndex() == 2) {
                                    this.wstages[this.wag] = "#" + this.gs.datat.getSelectedIndex() + "";
                                 }

                                 if (this.gs.senditem.getSelectedIndex() == 3) {
                                    this.wstages[this.wag] = "" + this.gs.datat.getSelectedItem() + "";
                                 }

                                 this.wlaps[this.wag] = this.gs.ilaps.getSelectedIndex();
                                 this.wcars[this.wag] = this.gs.icars.getSelectedIndex();
                                 this.wclass[this.wag] = this.gs.sclass.getSelectedIndex();
                                 this.wfix[this.wag] = this.gs.sfix.getSelectedIndex();
                                 this.wag++;
                                 if (this.wag < 4) {
                                    this.redif = true;
                                 } else {
                                    this.wag--;
                                    this.sendint = 1;
                                    this.gs.senditem.disable();
                                    this.gs.datat.disable();
                                    this.gs.ilaps.disable();
                                    this.gs.icars.disable();
                                    this.gs.sclass.disable();
                                    this.gs.sfix.disable();
                                 }
                              } else {
                                 this.imsg = "Please choose a type of cars for this game!";
                                 this.iflk = 40;
                              }
                           } else {
                              this.imsg = "Please select a number of laps!";
                              this.iflk = 40;
                           }
                        } else {
                           this.imsg = "Please select a stage!";
                           this.iflk = 40;
                        }
                     }
                  } else {
                     this.imsg = "Sending war declaration, pleas wait...";
                     this.rd.setFont(new Font("Arial", 1, 12));
                     this.ftm = this.rd.getFontMetrics();
                     this.rd.setColor(new Color(0, 0, 0));
                     this.rd.drawString("Sending...", 742 - this.ftm.stringWidth("Sending...") / 2, 417);
                  }
               }

               if (this.gs.sendtyp.getSelectedIndex() == 5 || this.gs.sendtyp.getSelectedIndex() == 6) {
                  if (this.inishsel || this.redif) {
                     this.isel = 0;
                     this.gs.senditem.removeAll();
                     this.gs.senditem.add(this.rd, " NFM Multiplayer ");
                     this.gs.senditem.add(this.rd, " NFM 2     ");
                     this.gs.senditem.add(this.rd, " NFM 1     ");
                     this.gs.senditem.add(this.rd, " Clan Stages ");
                     this.gs.senditem.select(0);
                     this.gs.datat.removeAll();
                     this.gs.datat.add(this.rd, "Select Stage");

                     for (int var41 = 0; var41 < 5; var41++) {
                        this.gs.datat.add(this.rd, " Stage " + (var41 + 1) + "");
                     }

                     this.gs.datat.select(0);
                     if (!this.redif) {
                        this.wag = 0;
                        this.imsg = "Create 3 games to be added to the battle.";
                        this.iflk = 0;
                     } else {
                        this.imsg = "Create next game.";
                        if (this.wag == 2) {
                           this.imsg = "Create last game.";
                        }

                        this.iflk = 0;
                        this.gs.ilaps.hide();
                        this.gs.icars.hide();
                        this.gs.sclass.hide();
                        this.gs.sfix.hide();
                     }

                     if (this.sendwarnum) {
                        this.sendint = 1;
                        this.gs.senditem.disable();
                        this.gs.datat.disable();
                        this.gs.ilaps.disable();
                        this.gs.icars.disable();
                        this.gs.sclass.disable();
                        this.gs.sfix.disable();
                     }

                     this.redif = false;
                  }

                  this.rd.setFont(new Font("Arial", 0, 12));
                  if (this.iflk % 3 != 0 || this.iflk == 0) {
                     this.rd.drawString(this.imsg, 350, 382);
                  }

                  if (this.iflk != 0) {
                     this.iflk--;
                  }

                  this.rd.setFont(new Font("Arial", 1, 12));
                  this.rd.drawString("Game #" + (this.wag * 2 + 1) + " :", 207, 407);
                  if (!this.gs.senditem.isShowing()) {
                     this.gs.senditem.show();
                  }

                  this.gs.senditem.move(280, 390);
                  if (!this.gs.datat.isShowing()) {
                     this.gs.datat.show();
                  }

                  this.gs.datat.move(286 + this.gs.senditem.getWidth(), 390);
                  int var42 = 207;
                  if (!this.gs.ilaps.isShowing()) {
                     this.gs.ilaps.show();
                     this.gs.ilaps.select(0);
                  }

                  this.gs.ilaps.move(var42, 415);
                  var42 += 6 + this.gs.ilaps.getWidth();
                  if (!this.gs.icars.isShowing()) {
                     this.gs.icars.show();
                     this.gs.icars.select(0);
                  }

                  this.gs.icars.move(var42, 415);
                  var42 += 6 + this.gs.icars.getWidth();
                  if (!this.gs.sclass.isShowing()) {
                     this.gs.sclass.show();
                     this.gs.sclass.select(0);
                  }

                  this.gs.sclass.move(var42, 415);
                  this.gs.sclass.revup = true;
                  var42 += 6 + this.gs.sclass.getWidth();
                  if (!this.gs.sfix.isShowing()) {
                     this.gs.sfix.show();
                     this.gs.sfix.select(0);
                  }

                  this.gs.sfix.move(var42, 415);
                  this.gs.sfix.revup = true;
                  this.gs.datat.setSize(var42 + this.gs.sfix.getWidth() - 286 - this.gs.senditem.getWidth(), 22);
                  if (this.gs.senditem.getSelectedIndex() == 0 && this.isel != 0) {
                     this.gs.datat.removeAll();
                     this.gs.datat.add(this.rd, "Select Stage");

                     for (int var85 = 0; var85 < 5; var85++) {
                        this.gs.datat.add(this.rd, " Stage " + (var85 + 1) + "");
                     }

                     this.gs.datat.select(0);
                     this.isel = 0;
                  }

                  if (this.gs.senditem.getSelectedIndex() == 1 && this.isel != 1) {
                     this.gs.datat.removeAll();
                     this.gs.datat.add(this.rd, "Select Stage");

                     for (int var86 = 0; var86 < 17; var86++) {
                        this.gs.datat.add(this.rd, " Stage " + (var86 + 1) + "");
                     }

                     this.gs.datat.select(0);
                     this.isel = 1;
                  }

                  if (this.gs.senditem.getSelectedIndex() == 2 && this.isel != 2) {
                     this.gs.datat.removeAll();
                     this.gs.datat.add(this.rd, "Select Stage");

                     for (int var87 = 0; var87 < 10; var87++) {
                        this.gs.datat.add(this.rd, " Stage " + (var87 + 1) + "");
                     }

                     this.gs.datat.select(0);
                     this.isel = 2;
                  }

                  if (this.gs.senditem.getSelectedIndex() == 3 && this.isel < 3) {
                     this.gs.datat.removeAll();
                     this.gs.datat.add(this.rd, "Loading stages, please wait...");
                     this.gs.datat.select(0);
                     this.isel = 3;
                  }

                  if (this.sendint == 0) {
                     String var88 = "  Next >  ";
                     if (this.wag == 2) {
                        var88 = "   Done   ";
                     }

                     if (this.stringbutton(this.rd, var88, 742, 417, 0, var1, var2, var3, 0, 0)) {
                        if (this.gs.datat.getSelectedIndex() != 0) {
                           if (this.gs.ilaps.getSelectedIndex() != 0) {
                              if (this.gs.icars.getSelectedIndex() != 0) {
                                 if (this.gs.senditem.getSelectedIndex() == 0) {
                                    this.wstages[this.wag] = "#" + (this.gs.datat.getSelectedIndex() + 27) + "";
                                 }

                                 if (this.gs.senditem.getSelectedIndex() == 1) {
                                    this.wstages[this.wag] = "#" + (this.gs.datat.getSelectedIndex() + 10) + "";
                                 }

                                 if (this.gs.senditem.getSelectedIndex() == 2) {
                                    this.wstages[this.wag] = "#" + this.gs.datat.getSelectedIndex() + "";
                                 }

                                 if (this.gs.senditem.getSelectedIndex() == 3) {
                                    this.wstages[this.wag] = "" + this.gs.datat.getSelectedItem() + "";
                                 }

                                 this.wlaps[this.wag] = this.gs.ilaps.getSelectedIndex();
                                 this.wcars[this.wag] = this.gs.icars.getSelectedIndex();
                                 this.wclass[this.wag] = this.gs.sclass.getSelectedIndex();
                                 this.wfix[this.wag] = this.gs.sfix.getSelectedIndex();
                                 this.wag++;
                                 if (this.wag < 3) {
                                    this.redif = true;
                                 } else {
                                    this.wag--;
                                    this.sendint = 1;
                                    this.gs.senditem.disable();
                                    this.gs.datat.disable();
                                    this.gs.ilaps.disable();
                                    this.gs.icars.disable();
                                    this.gs.sclass.disable();
                                    this.gs.sfix.disable();
                                 }
                              } else {
                                 this.imsg = "Please choose a type of cars for this game!";
                                 this.iflk = 40;
                              }
                           } else {
                              this.imsg = "Please select a number of laps!";
                              this.iflk = 40;
                           }
                        } else {
                           this.imsg = "Please select a stage!";
                           this.iflk = 40;
                        }
                     }
                  } else {
                     this.imsg = "Sending war declaration, pleas wait...";
                     this.rd.setFont(new Font("Arial", 1, 12));
                     this.ftm = this.rd.getFontMetrics();
                     this.rd.setColor(new Color(0, 0, 0));
                     this.rd.drawString("Sending...", 742 - this.ftm.stringWidth("Sending...") / 2, 417);
                  }
               }

               if (this.gs.sendtyp.getSelectedIndex() == 7) {
                  if (this.inishsel || this.redif) {
                     this.isel = 0;
                     this.gs.senditem.removeAll();
                     this.gs.senditem.add(this.rd, " NFM Multiplayer ");
                     this.gs.senditem.add(this.rd, " NFM 2     ");
                     this.gs.senditem.add(this.rd, " NFM 1     ");
                     this.gs.senditem.add(this.rd, " Clan Stages ");
                     this.gs.senditem.select(0);
                     this.gs.datat.removeAll();
                     this.gs.datat.add(this.rd, "Select Stage");

                     for (int var46 = 0; var46 < 5; var46++) {
                        this.gs.datat.add(this.rd, " Stage " + (var46 + 1) + "");
                     }

                     this.gs.datat.select(0);
                     if (!this.redif) {
                        this.wag = 0;
                        this.imsg = "Create 5 games to be added to the war.";
                        this.iflk = 0;
                     } else {
                        this.imsg = "Create next game.";
                        if (this.wag == 4) {
                           this.imsg = "Create last game.";
                        }

                        this.iflk = 0;
                        this.gs.ilaps.hide();
                        this.gs.icars.hide();
                        this.gs.sclass.hide();
                        this.gs.sfix.hide();
                     }

                     if (this.sendwarnum) {
                        this.sendint = 1;
                        this.gs.senditem.disable();
                        this.gs.datat.disable();
                        this.gs.ilaps.disable();
                        this.gs.icars.disable();
                        this.gs.sclass.disable();
                        this.gs.sfix.disable();
                     }

                     this.redif = false;
                  }

                  this.rd.setFont(new Font("Arial", 0, 12));
                  if (this.iflk % 3 != 0 || this.iflk == 0) {
                     this.rd.drawString(this.imsg, 350, 382);
                  }

                  if (this.iflk != 0) {
                     this.iflk--;
                  }

                  this.rd.setFont(new Font("Arial", 1, 12));
                  this.rd.drawString("Game #" + (this.wag * 2 + 1) + " :", 207, 407);
                  if (!this.gs.senditem.isShowing()) {
                     this.gs.senditem.show();
                  }

                  this.gs.senditem.move(280, 390);
                  if (!this.gs.datat.isShowing()) {
                     this.gs.datat.show();
                  }

                  this.gs.datat.move(286 + this.gs.senditem.getWidth(), 390);
                  int var47 = 207;
                  if (!this.gs.ilaps.isShowing()) {
                     this.gs.ilaps.show();
                     this.gs.ilaps.select(0);
                  }

                  this.gs.ilaps.move(var47, 415);
                  var47 += 6 + this.gs.ilaps.getWidth();
                  if (!this.gs.icars.isShowing()) {
                     this.gs.icars.show();
                     this.gs.icars.select(0);
                  }

                  this.gs.icars.move(var47, 415);
                  var47 += 6 + this.gs.icars.getWidth();
                  if (!this.gs.sclass.isShowing()) {
                     this.gs.sclass.show();
                     this.gs.sclass.select(0);
                  }

                  this.gs.sclass.move(var47, 415);
                  this.gs.sclass.revup = true;
                  var47 += 6 + this.gs.sclass.getWidth();
                  if (!this.gs.sfix.isShowing()) {
                     this.gs.sfix.show();
                     this.gs.sfix.select(0);
                  }

                  this.gs.sfix.move(var47, 415);
                  this.gs.sfix.revup = true;
                  this.gs.datat.setSize(var47 + this.gs.sfix.getWidth() - 286 - this.gs.senditem.getWidth(), 22);
                  if (this.gs.senditem.getSelectedIndex() == 0 && this.isel != 0) {
                     this.gs.datat.removeAll();
                     this.gs.datat.add(this.rd, "Select Stage");

                     for (int var89 = 0; var89 < 5; var89++) {
                        this.gs.datat.add(this.rd, " Stage " + (var89 + 1) + "");
                     }

                     this.gs.datat.select(0);
                     this.isel = 0;
                  }

                  if (this.gs.senditem.getSelectedIndex() == 1 && this.isel != 1) {
                     this.gs.datat.removeAll();
                     this.gs.datat.add(this.rd, "Select Stage");

                     for (int var90 = 0; var90 < 17; var90++) {
                        this.gs.datat.add(this.rd, " Stage " + (var90 + 1) + "");
                     }

                     this.gs.datat.select(0);
                     this.isel = 1;
                  }

                  if (this.gs.senditem.getSelectedIndex() == 2 && this.isel != 2) {
                     this.gs.datat.removeAll();
                     this.gs.datat.add(this.rd, "Select Stage");

                     for (int var91 = 0; var91 < 10; var91++) {
                        this.gs.datat.add(this.rd, " Stage " + (var91 + 1) + "");
                     }

                     this.gs.datat.select(0);
                     this.isel = 2;
                  }

                  if (this.gs.senditem.getSelectedIndex() == 3 && this.isel < 3) {
                     this.gs.datat.removeAll();
                     this.gs.datat.add(this.rd, "Loading stages, please wait...");
                     this.gs.datat.select(0);
                     this.isel = 3;
                  }

                  if (this.sendint == 0) {
                     String var92 = "  Next >  ";
                     if (this.wag == 4) {
                        var92 = "   Done   ";
                     }

                     if (this.stringbutton(this.rd, var92, 742, 417, 0, var1, var2, var3, 0, 0)) {
                        if (this.gs.datat.getSelectedIndex() != 0) {
                           if (this.gs.ilaps.getSelectedIndex() != 0) {
                              if (this.gs.icars.getSelectedIndex() != 0) {
                                 if (this.gs.senditem.getSelectedIndex() == 0) {
                                    this.wstages[this.wag] = "#" + (this.gs.datat.getSelectedIndex() + 27) + "";
                                 }

                                 if (this.gs.senditem.getSelectedIndex() == 1) {
                                    this.wstages[this.wag] = "#" + (this.gs.datat.getSelectedIndex() + 10) + "";
                                 }

                                 if (this.gs.senditem.getSelectedIndex() == 2) {
                                    this.wstages[this.wag] = "#" + this.gs.datat.getSelectedIndex() + "";
                                 }

                                 if (this.gs.senditem.getSelectedIndex() == 3) {
                                    this.wstages[this.wag] = "" + this.gs.datat.getSelectedItem() + "";
                                 }

                                 this.wlaps[this.wag] = this.gs.ilaps.getSelectedIndex();
                                 this.wcars[this.wag] = this.gs.icars.getSelectedIndex();
                                 this.wclass[this.wag] = this.gs.sclass.getSelectedIndex();
                                 this.wfix[this.wag] = this.gs.sfix.getSelectedIndex();
                                 this.wag++;
                                 if (this.wag < 5) {
                                    this.redif = true;
                                 } else {
                                    this.wag--;
                                    this.sendint = 1;
                                    this.gs.senditem.disable();
                                    this.gs.datat.disable();
                                    this.gs.ilaps.disable();
                                    this.gs.icars.disable();
                                    this.gs.sclass.disable();
                                    this.gs.sfix.disable();
                                 }
                              } else {
                                 this.imsg = "Please choose a type of cars for this game!";
                                 this.iflk = 40;
                              }
                           } else {
                              this.imsg = "Please select a number of laps!";
                              this.iflk = 40;
                           }
                        } else {
                           this.imsg = "Please select a stage!";
                           this.iflk = 40;
                        }
                     }
                  } else {
                     this.imsg = "Sending war declaration, pleas wait...";
                     this.rd.setFont(new Font("Arial", 1, 12));
                     this.ftm = this.rd.getFontMetrics();
                     this.rd.setColor(new Color(0, 0, 0));
                     this.rd.drawString("Sending...", 742 - this.ftm.stringWidth("Sending...") / 2, 417);
                  }
               }

               if (this.inishsel) {
                  this.inishsel = false;
               }
            }

            if (this.openi >= 1 && this.openi < 10) {
               this.rd.setColor(this.color2k(240, 240, 230));
               this.rd.fillRoundRect(197, this.opy, 597, this.oph, 20, 20);
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawRoundRect(197, this.opy, 597, this.oph, 20, 20);
               if (!this.drawl(this.rd, "#" + this.intclan + "#", 207, this.opy + 7, true)) {
                  this.rd.setFont(new Font("Arial", 1, 12));
                  this.ftm = this.rd.getFontMetrics();
                  this.rd.setColor(new Color(0, 0, 0));
                  this.rd.drawString(this.intclan, 382 - this.ftm.stringWidth(this.intclan) / 2, this.opy + 26);
                  this.rd.setColor(this.color2k(150, 150, 150));
                  this.rd.drawRect(207, this.opy + 7, 349, 29);
               }

               this.opy = this.opy + this.addopy;
               this.oph += 36;
               this.openi++;
            }
         } else {
            this.rd.setColor(this.color2k(230, 230, 230));
            this.rd.fillRoundRect(197, 40, 597, 404, 20, 20);
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawRoundRect(197, 40, 597, 404, 20, 20);
            if (this.xt.logged) {
               this.rd.setFont(new Font("Arial", 1, 12));
               this.ftm = this.rd.getFontMetrics();
               this.rd.setColor(new Color(0, 0, 0));
               this.rd
                  .drawString(
                     "You are not a member of any clan.  You need to join a clan first to have access to this.",
                     487 - this.ftm.stringWidth("You are not a member of any clan.  You need to join a clan first to have access to this.") / 2,
                     200
                  );
               if (this.stringbutton(this.rd, "   Find a clan to join   ", 487, 230, 1, var1, var2, var3, 0, 0)) {
                  this.tab = 3;
                  this.cfase = 2;
                  this.em = 1;
                  this.msg = "Clan Search";
                  this.smsg = "Listing clans with recent activity...";
                  this.nclns = 0;
                  this.spos5 = 0;
                  this.lspos5 = 0;
                  this.flko = 0;
               }
            } else {
               this.rd.setFont(new Font("Arial", 1, 13));
               this.ftm = this.rd.getFontMetrics();
               this.rd.drawString("You are currently using a trial account.", 495 - this.ftm.stringWidth("You are currently using a trial account.") / 2, 180);
               this.rd
                  .drawString(
                     "You need to upgrade to be able participate in NFM clan's activities.",
                     495 - this.ftm.stringWidth("You need to upgrade to be able participate in NFM clan's activities.") / 2,
                     200
                  );
               this.rd.setColor(new Color(206, 171, 98));
               this.rd.fillRoundRect(405, 223, 180, 50, 20, 20);
               if (this.drawbutton(this.xt.upgrade, 495, 248, var1, var2, var3)) {
                  this.gs.editlink(this.xt.nickname, true);
               }
            }

            this.rd.setColor(this.color2k(205, 205, 205));
            this.rd.fillRect(207, 46, 582, 30);
            this.rd.setFont(new Font("Arial", 1, 12));
            this.ftm = this.rd.getFontMetrics();
            String[] var53 = new String[]{"Player Interaction", "Clan Interaction", "Your Clan's Discussion"};
            int[] var96 = new int[]{207, 390, 368, 207};
            int[] var124 = new int[]{73, 73, 51, 51};

            for (int var139 = 0; var139 < 3; var139++) {
               if (this.itab == var139) {
                  this.rd.setColor(this.color2k(230, 230, 230));
                  this.rd.fillPolygon(var96, var124, 4);
               } else if (var1 > var96[0] && var1 < var96[2] && var2 > 51 && var2 < 73) {
                  this.rd.setColor(this.color2k(217, 217, 217));
                  this.rd.fillPolygon(var96, var124, 4);
                  if (var3) {
                     this.itab = var139;
                  }
               }

               this.rd.setColor(this.color2k(150, 150, 150));
               this.rd.drawPolygon(var96, var124, 4);
               this.rd.setColor(this.color2k(40, 40, 40));
               this.rd.drawString(var53[var139], var96[0] + 80 - this.ftm.stringWidth(var53[var139]) / 2, 67);

               for (int var153 = 0; var153 < 4; var153++) {
                  var96[var153] += 183;
               }
            }

            this.rd.setColor(this.color2k(150, 150, 150));
            this.rd.drawLine(207, 73, 770, 73);
            this.rd.setColor(this.color2k(205, 205, 205));
            this.rd.fillRect(207, 409, 582, 30);
            this.rd.setColor(this.color2k(150, 150, 150));
            this.rd.drawLine(207, 411, 770, 411);
            this.rd.setColor(this.color2k(205, 205, 205));
            this.rd.fillRect(772, 76, 17, 333);
            this.rd.setColor(this.color2k(205, 205, 205));
            this.rd.fillRect(203, 46, 4, 393);
         }
      }

      if (this.itab == 2) {
         if (this.litab != this.itab) {
            if (this.readclan > 0) {
               this.spos3 = 219;
            }

            this.gs.senditem.hide();
            this.gs.datat.hide();
            this.gs.ilaps.hide();
            this.gs.icars.hide();
            this.gs.sclass.hide();
            this.gs.sfix.hide();
            this.gs.senditem.enable();
            this.gs.datat.enable();
            this.gs.ilaps.enable();
            this.gs.icars.enable();
            this.gs.sclass.enable();
            this.gs.sfix.enable();
            this.gs.sendtyp.removeAll();
            this.gs.sendtyp.add(this.rd, "Write a Message");
            this.gs.sendtyp.add(this.rd, "Share a Relative Date");
            this.gs.sendtyp.select(0);
            this.litab = this.itab;
         }

         this.rd.setColor(this.color2k(230, 230, 230));
         this.rd.fillRoundRect(197, 40, 597, 404, 20, 20);
         this.rd.setColor(new Color(0, 0, 0));
         this.rd.drawRoundRect(197, 40, 597, 404, 20, 20);
         if (!this.xt.clan.equals("")) {
            this.rd.setColor(this.color2k(250, 250, 250));
            this.rd.fillRect(207, 76, 565, 300);
         }

         if (this.loadedmyclanbg == 1) {
            this.rd.setComposite(AlphaComposite.getInstance(3, 0.1F));
            this.rd.drawImage(this.myclanbg, 207, 76, 565, 300, null);
            this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
         }

         this.rd.setColor(new Color(0, 0, 0));
         this.sdist = 0;
         if (!this.xt.clan.equals("")) {
            if (this.gs.openm) {
               this.blockb = 10;
            } else if (this.blockb != 0) {
               this.blockb--;
            }

            if ((this.readclan > 0 || this.readclan == -3) && this.viewgame1 == 0) {
               this.sdist = (int)((this.cnml - 14.75F) * 17.0F);
               if (this.sdist < 0) {
                  this.sdist = 0;
               }

               this.scro = (int)(this.spos3 / 219.0F * this.sdist);

               for (int var54 = 0; var54 < this.cnml; var54++) {
                  if (86 + 17 * var54 - this.scro < 360 && 125 + 17 * var54 - this.scro > 76 && this.cmlinetyp[var54] != 167) {
                     if (this.cmlinetyp[var54] != 20
                        && this.cmlinetyp[var54] != 30
                        && this.cmlinetyp[var54] != 40
                        && this.cmlinetyp[var54] != 50
                        && this.cmlinetyp[var54] != 60
                        && this.cmlinetyp[var54] != 70
                        && this.cmlinetyp[var54] != 80) {
                        this.rd.setColor(new Color(0, 0, 0));
                        if (this.cmlinetyp[var54] >= 0) {
                           this.rd.setFont(new Font("Tahoma", 1, 11));
                        } else {
                           this.rd.setFont(new Font("Tahoma", 0, 11));
                        }

                        this.rd.drawString(this.cmline[var54], 217, 103 + 17 * var54 - this.scro);
                        if (this.cmlinetyp[var54] >= 0) {
                           this.rd.setFont(new Font("Tahoma", 0, 11));
                           this.ftm = this.rd.getFontMetrics();
                           this.rd.setColor(this.color2k(125, 125, 125));
                           this.rd.drawString(this.cmtimes[var54], 757 - this.ftm.stringWidth(this.cmtimes[var54]), 103 + 17 * var54 - this.scro);
                        }
                     } else {
                        if (this.cmlinetyp[var54] == 20 || this.cmlinetyp[var54] == 50) {
                           if (this.stringbutton(this.rd, "  View Clan  ", 267, 112 + 17 * var54 - this.scro, 0, var1, var2, var3, 0, 0)) {
                              String var97 = this.getSvalue(this.cmline[var54], 0);
                              if (!this.claname.equals(var97)) {
                                 this.claname = var97;
                                 this.loadedc = false;
                              }

                              this.spos5 = 0;
                              this.lspos5 = 0;
                              this.cfase = 3;
                              this.ctab = 0;
                              this.tab = 3;
                           }

                           if (this.stringbutton(this.rd, "  View War Suggestion  ", 403, 112 + 17 * var54 - this.scro, 0, var1, var2, var3, 0, 0)) {
                              this.viewgame1 = 1;
                              if (this.cmlinetyp[var54] == 20) {
                                 this.nvgames1 = 4;
                              } else {
                                 this.nvgames1 = 9;
                              }

                              this.xclan = this.getSvalue(this.cmline[var54], 0);
                              this.viewwar1 = this.getSvalue(this.cmline[var54], 1);
                           }

                           if (!this.cmline[var54].endsWith("|out|")) {
                              if (this.cadmin == 1
                                 && this.stringbutton(this.rd, "  Approve War  ", 548, 112 + 17 * var54 - this.scro, 0, var1, var2, var3, 0, 0)) {
                                 this.tab = 2;
                                 this.itab = 1;
                                 this.litab = -1;
                                 this.openi = 10;
                                 String var98 = this.getSvalue(this.cmline[var54], 0);
                                 if (!this.intclan.equals(var98)) {
                                    this.intclan = var98;
                                    this.dispi = 0;
                                    this.nil = 0;
                                    this.lastint = "";
                                    this.readint = 1;
                                 }

                                 this.warnum = this.getSvalue(this.cmline[var54], 1);
                                 this.sendwarnum = true;
                                 if (this.cmlinetyp[var54] == 20) {
                                    this.intsel = 4;
                                 } else {
                                    this.intsel = 7;
                                 }
                              }
                           } else {
                              this.rd.setColor(this.color2k(170, 170, 170));
                              this.rd
                                 .drawString(
                                    "[ Approved or interaction replaced. ]",
                                    597 - this.ftm.stringWidth("[ Approved or interaction replaced. ]") / 2,
                                    112 + 17 * var54 - this.scro
                                 );
                           }
                        }

                        if (this.cmlinetyp[var54] == 30 || this.cmlinetyp[var54] == 60) {
                           if (this.stringbutton(this.rd, "  View Clan  ", 267, 112 + 17 * var54 - this.scro, 0, var1, var2, var3, 0, 0)) {
                              String var99 = this.getSvalue(this.cmline[var54], 0);
                              if (!this.claname.equals(var99)) {
                                 this.claname = var99;
                                 this.loadedc = false;
                              }

                              this.spos5 = 0;
                              this.lspos5 = 0;
                              this.cfase = 3;
                              this.ctab = 0;
                              this.tab = 3;
                           }

                           if (this.stringbutton(this.rd, "  View Battle Suggestion  ", 407, 112 + 17 * var54 - this.scro, 0, var1, var2, var3, 0, 0)) {
                              this.viewgame1 = 1;
                              if (this.cmlinetyp[var54] == 30) {
                                 this.nvgames1 = 2;
                              } else {
                                 this.nvgames1 = 5;
                              }

                              this.xclan = this.getSvalue(this.cmline[var54], 0);
                              this.viewwar1 = this.getSvalue(this.cmline[var54], 3);
                           }

                           if (!this.cmline[var54].endsWith("|out|")) {
                              if (this.cadmin == 1
                                 && this.stringbutton(this.rd, "  Approve Battle  ", 560, 112 + 17 * var54 - this.scro, 0, var1, var2, var3, 0, 0)) {
                                 this.tab = 2;
                                 this.itab = 1;
                                 this.litab = -1;
                                 this.openi = 10;
                                 String var100 = this.getSvalue(this.cmline[var54], 0);
                                 if (!this.intclan.equals(var100)) {
                                    this.intclan = var100;
                                    this.dispi = 0;
                                    this.nil = 0;
                                    this.lastint = "";
                                    this.readint = 1;
                                 }

                                 this.itake = this.getSvalue(this.cmline[var54], 1);
                                 this.igive = this.getSvalue(this.cmline[var54], 2);
                                 this.warnum = this.getSvalue(this.cmline[var54], 3);
                                 this.sendwarnum = true;
                                 if (this.cmlinetyp[var54] == 30) {
                                    this.intsel = 3;
                                 } else {
                                    this.intsel = 6;
                                 }
                              }
                           } else {
                              this.rd.setColor(this.color2k(170, 170, 170));
                              this.rd
                                 .drawString(
                                    "[ Approved or interaction replaced. ]",
                                    604 - this.ftm.stringWidth("[ Approved or interaction replaced. ]") / 2,
                                    112 + 17 * var54 - this.scro
                                 );
                           }

                           this.rd.setFont(new Font("Tahoma", 0, 11));
                           this.ftm = this.rd.getFontMetrics();
                           if (this.stringbutton(
                              this.rd,
                              "  View Car  ",
                              217 + this.ftm.stringWidth(this.cmline[var54 + 2]) + 47,
                              137 + 17 * var54 - this.scro,
                              6,
                              var1,
                              var2,
                              var3,
                              0,
                              0
                           )) {
                              this.viewcar = this.getSvalue(this.cmline[var54], 1);
                              String var101 = this.getSvalue(this.cmline[var54], 0);
                              if (!this.claname.equals(var101)) {
                                 this.claname = var101;
                                 this.loadedc = false;
                              }

                              this.spos5 = 0;
                              this.lspos5 = 0;
                              this.cfase = 3;
                              this.loadedcars = -1;
                              this.loadedcar = 0;
                              this.ctab = 2;
                              this.tab = 3;
                           }

                           this.rd.setFont(new Font("Tahoma", 0, 11));
                           this.ftm = this.rd.getFontMetrics();
                           if (this.stringbutton(
                              this.rd,
                              "  View Car  ",
                              217 + this.ftm.stringWidth(this.cmline[var54 + 3]) + 47,
                              154 + 17 * var54 - this.scro,
                              6,
                              var1,
                              var2,
                              var3,
                              0,
                              0
                           )) {
                              this.viewcar = this.getSvalue(this.cmline[var54], 2);
                              if (!this.claname.equals(this.xt.clan)) {
                                 this.claname = this.xt.clan;
                                 this.loadedc = false;
                              }

                              this.spos5 = 0;
                              this.lspos5 = 0;
                              this.cfase = 3;
                              this.loadedcars = -1;
                              this.loadedcar = 0;
                              this.ctab = 2;
                              this.tab = 3;
                           }
                        }

                        if (this.cmlinetyp[var54] == 40 || this.cmlinetyp[var54] == 70) {
                           if (this.stringbutton(this.rd, "  View Clan  ", 267, 112 + 17 * var54 - this.scro, 0, var1, var2, var3, 0, 0)) {
                              String var102 = this.getSvalue(this.cmline[var54], 0);
                              if (!this.claname.equals(var102)) {
                                 this.claname = var102;
                                 this.loadedc = false;
                              }

                              this.spos5 = 0;
                              this.lspos5 = 0;
                              this.cfase = 3;
                              this.ctab = 0;
                              this.tab = 3;
                           }

                           if (this.stringbutton(this.rd, "  View Battle Suggestion  ", 407, 112 + 17 * var54 - this.scro, 0, var1, var2, var3, 0, 0)) {
                              this.viewgame1 = 1;
                              if (this.cmlinetyp[var54] == 40) {
                                 this.nvgames1 = 2;
                              } else {
                                 this.nvgames1 = 5;
                              }

                              this.xclan = this.getSvalue(this.cmline[var54], 0);
                              this.viewwar1 = this.getSvalue(this.cmline[var54], 3);
                           }

                           if (!this.cmline[var54].endsWith("|out|")) {
                              if (this.cadmin == 1
                                 && this.stringbutton(this.rd, "  Approve Battle  ", 560, 112 + 17 * var54 - this.scro, 0, var1, var2, var3, 0, 0)) {
                                 this.tab = 2;
                                 this.itab = 1;
                                 this.litab = -1;
                                 this.openi = 10;
                                 String var103 = this.getSvalue(this.cmline[var54], 0);
                                 if (!this.intclan.equals(var103)) {
                                    this.intclan = var103;
                                    this.dispi = 0;
                                    this.nil = 0;
                                    this.lastint = "";
                                    this.readint = 1;
                                 }

                                 this.itake = this.getSvalue(this.cmline[var54], 1);
                                 this.igive = this.getSvalue(this.cmline[var54], 2);
                                 this.warnum = this.getSvalue(this.cmline[var54], 3);
                                 this.sendwarnum = true;
                                 if (this.cmlinetyp[var54] == 40) {
                                    this.intsel = 2;
                                 } else {
                                    this.intsel = 5;
                                 }
                              }
                           } else {
                              this.rd.setColor(this.color2k(170, 170, 170));
                              this.rd
                                 .drawString(
                                    "[ Approved or interaction replaced. ]",
                                    604 - this.ftm.stringWidth("[ Approved or interaction replaced. ]") / 2,
                                    112 + 17 * var54 - this.scro
                                 );
                           }

                           this.rd.setFont(new Font("Tahoma", 0, 11));
                           this.ftm = this.rd.getFontMetrics();
                           if (this.stringbutton(
                              this.rd,
                              "  View Stage  ",
                              217 + this.ftm.stringWidth(this.cmline[var54 + 2]) + 54,
                              137 + 17 * var54 - this.scro,
                              6,
                              var1,
                              var2,
                              var3,
                              0,
                              0
                           )) {
                              this.viewcar = this.getSvalue(this.cmline[var54], 1);
                              String var104 = this.getSvalue(this.cmline[var54], 0);
                              if (!this.claname.equals(var104)) {
                                 this.claname = var104;
                                 this.loadedc = false;
                              }

                              this.spos5 = 0;
                              this.lspos5 = 0;
                              this.cfase = 3;
                              this.loadedstages = -1;
                              this.loadedstage = 0;
                              this.ctab = 3;
                              this.tab = 3;
                           }

                           this.rd.setFont(new Font("Tahoma", 0, 11));
                           this.ftm = this.rd.getFontMetrics();
                           if (this.stringbutton(
                              this.rd,
                              "  View Stage  ",
                              217 + this.ftm.stringWidth(this.cmline[var54 + 3]) + 54,
                              154 + 17 * var54 - this.scro,
                              6,
                              var1,
                              var2,
                              var3,
                              0,
                              0
                           )) {
                              this.viewcar = this.getSvalue(this.cmline[var54], 2);
                              if (!this.claname.equals(this.xt.clan)) {
                                 this.claname = this.xt.clan;
                                 this.loadedc = false;
                              }

                              this.spos5 = 0;
                              this.lspos5 = 0;
                              this.cfase = 3;
                              this.loadedstages = -1;
                              this.loadedstage = 0;
                              this.ctab = 3;
                              this.tab = 3;
                           }
                        }

                        if (this.cmlinetyp[var54] == 80
                           && this.stringbutton(this.rd, "  View Championship  ", 295, 112 + 17 * var54 - this.scro, 0, var1, var2, var3, 0, 0)) {
                           this.cfase = 0;
                           this.ntab = 1;
                           this.loadwstat = 0;
                           this.tab = 3;
                        }
                     }
                  }
               }
            }

            if (this.readclan == -3) {
               this.rd.setColor(this.color2k(240, 240, 240));
               this.rd.fillRoundRect(387, 140, 200, 30, 20, 20);
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawRoundRect(387, 140, 200, 30, 20, 20);
               this.rd.setFont(new Font("Tahoma", 1, 11));
               this.ftm = this.rd.getFontMetrics();
               this.rd.drawString("Reading...", 487 - this.ftm.stringWidth("Reading...") / 2, 160);
            }

            if (this.readclan == -1) {
               this.rd.setFont(new Font("Arial", 1, 11));
               this.ftm = this.rd.getFontMetrics();
               this.rd.setColor(new Color(0, 0, 0));
               this.rd
                  .drawString(
                     "Failed to load clan's conversation, please try again later...",
                     487 - this.ftm.stringWidth("Failed to load clan's conversation, please try again later...") / 2,
                     200
                  );
            }

            if (this.readclan == -2) {
               this.rd.setFont(new Font("Arial", 1, 11));
               this.ftm = this.rd.getFontMetrics();
               this.rd.setColor(new Color(0, 0, 0));
               this.rd
                  .drawString(
                     "Failed to send data, please try again later...", 487 - this.ftm.stringWidth("Failed to send data, please try again later...") / 2, 200
                  );
            }

            this.rd.setColor(this.color2k(205, 205, 205));
            this.rd.fillRect(207, 76, 357, 36);
            if (!this.drawl(this.rd, "#" + this.xt.clan + "#", 209, 78, true)) {
               this.rd.drawRect(209, 78, 349, 29);
               this.rd.setFont(new Font("Arial", 1, 13));
               this.ftm = this.rd.getFontMetrics();
               this.rd.drawString("" + this.xt.clan + "", 384 - this.ftm.stringWidth("" + this.xt.clan + "") / 2, 98);
            }

            if (var1 > 209 && var1 < 559 && var2 > 78 && var2 < 108 && this.blockb == 0) {
               this.cur = 12;
               if (var3) {
                  if (!this.claname.equals(this.xt.clan)) {
                     this.claname = this.xt.clan;
                     this.loadedc = false;
                  }

                  this.spos5 = 0;
                  this.lspos5 = 0;
                  this.cfase = 3;
                  this.ctab = 0;
                  this.tab = 3;
               }
            }
         } else if (this.xt.logged) {
            this.rd.setFont(new Font("Arial", 1, 12));
            this.ftm = this.rd.getFontMetrics();
            this.rd.setColor(new Color(0, 0, 0));
            this.rd
               .drawString(
                  "You are not a member of any clan.  You need to join a clan first to have access to this.",
                  487 - this.ftm.stringWidth("You are not a member of any clan.  You need to join a clan first to have access to this.") / 2,
                  170
               );
            if (this.stringbutton(this.rd, "   Find a clan to join   ", 487, 200, 1, var1, var2, var3, 0, 0)) {
               this.tab = 3;
               this.cfase = 2;
               this.em = 1;
               this.msg = "Clan Search";
               this.smsg = "Listing clans with recent activity...";
               this.nclns = 0;
               this.spos5 = 0;
               this.lspos5 = 0;
               this.flko = 0;
            }
         } else {
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            this.rd.drawString("You are currently using a trial account.", 495 - this.ftm.stringWidth("You are currently using a trial account.") / 2, 150);
            this.rd
               .drawString(
                  "You need to upgrade to be able participate in NFM clan's activities.",
                  495 - this.ftm.stringWidth("You need to upgrade to be able participate in NFM clan's activities.") / 2,
                  170
               );
            this.rd.setColor(new Color(206, 171, 98));
            this.rd.fillRoundRect(405, 193, 180, 50, 20, 20);
            if (this.drawbutton(this.xt.upgrade, 495, 218, var1, var2, var3)) {
               this.gs.editlink(this.xt.nickname, true);
            }
         }

         this.rd.setColor(this.color2k(205, 205, 205));
         this.rd.fillRect(207, 46, 582, 30);
         this.rd.setFont(new Font("Arial", 1, 12));
         this.ftm = this.rd.getFontMetrics();
         String[] var55 = new String[]{"Player Interaction", "Clan Interaction", "Your Clan's Discussion"};
         int[] var105 = new int[]{207, 390, 368, 207};
         int[] var125 = new int[]{73, 73, 51, 51};

         for (int var140 = 0; var140 < 3; var140++) {
            if (this.itab == var140) {
               this.rd.setColor(this.color2k(230, 230, 230));
               this.rd.fillPolygon(var105, var125, 4);
            } else if (var1 > var105[0] && var1 < var105[2] && var2 > 51 && var2 < 73) {
               this.rd.setColor(this.color2k(217, 217, 217));
               this.rd.fillPolygon(var105, var125, 4);
               if (var3) {
                  this.itab = var140;
               }
            }

            this.rd.setColor(this.color2k(150, 150, 150));
            this.rd.drawPolygon(var105, var125, 4);
            this.rd.setColor(this.color2k(40, 40, 40));
            this.rd.drawString(var55[var140], var105[0] + 80 - this.ftm.stringWidth(var55[var140]) / 2, 67);

            for (int var154 = 0; var154 < 4; var154++) {
               var105[var154] += 183;
            }
         }

         this.rd.setColor(this.color2k(150, 150, 150));
         this.rd.drawLine(207, 73, 770, 73);
         this.rd.setColor(this.color2k(205, 205, 205));
         this.rd.fillRect(207, 360, 582, 79);
         this.rd.setColor(this.color2k(150, 150, 150));
         this.rd.drawLine(207, 362, 770, 362);
         this.rd.setColor(this.color2k(205, 205, 205));
         this.rd.fillRect(772, 76, 17, 333);
         this.rd.setColor(this.color2k(205, 205, 205));
         this.rd.fillRect(203, 46, 4, 393);
         if (this.mscro3 != 831 && this.sdist != 0) {
            this.rd.setColor(this.color2k(220, 220, 220));
            this.rd.fill3DRect(772, 76, 17, 17, true);
         } else {
            if (this.sdist == 0) {
               this.rd.setColor(this.color2k(205, 205, 205));
            } else {
               this.rd.setColor(this.color2k(215, 215, 215));
            }

            this.rd.fillRect(772, 76, 17, 17);
         }

         if (this.sdist != 0) {
            this.rd.drawImage(this.xt.asu, 777, 82, null);
         }

         if (this.mscro3 != 832 && this.sdist != 0) {
            this.rd.setColor(this.color2k(220, 220, 220));
            this.rd.fill3DRect(772, 343, 17, 17, true);
         } else {
            if (this.sdist == 0) {
               this.rd.setColor(this.color2k(205, 205, 205));
            } else {
               this.rd.setColor(this.color2k(215, 215, 215));
            }

            this.rd.fillRect(772, 343, 17, 17);
         }

         if (this.sdist != 0) {
            this.rd.drawImage(this.xt.asd, 777, 350, null);
         }

         if (this.sdist != 0) {
            if (this.lspos3 != this.spos3) {
               this.rd.setColor(this.color2k(215, 215, 215));
               this.rd.fillRect(772, 93 + this.spos3, 17, 31);
            } else {
               if (this.mscro3 == 831) {
                  this.rd.setColor(this.color2k(215, 215, 215));
               }

               this.rd.fill3DRect(772, 93 + this.spos3, 17, 31, true);
            }

            this.rd.setColor(this.color2k(150, 150, 150));
            this.rd.drawLine(777, 106 + this.spos3, 783, 106 + this.spos3);
            this.rd.drawLine(777, 108 + this.spos3, 783, 108 + this.spos3);
            this.rd.drawLine(777, 110 + this.spos3, 783, 110 + this.spos3);
            if (this.mscro3 > 800 && this.lspos3 != this.spos3) {
               this.lspos3 = this.spos3;
            }

            if (var3 && this.openc == 0) {
               if (this.mscro3 == 825 && var1 > 772 && var1 < 789 && var2 > 93 + this.spos3 && var2 < this.spos3 + 124) {
                  this.mscro3 = var2 - this.spos3;
               }

               if (this.mscro3 == 825 && var1 > 770 && var1 < 791 && var2 > 74 && var2 < 95) {
                  this.mscro3 = 831;
               }

               if (this.mscro3 == 825 && var1 > 770 && var1 < 791 && var2 > 341 && var2 < 362) {
                  this.mscro3 = 832;
               }

               if (this.mscro3 == 825 && var1 > 772 && var1 < 789 && var2 > 93 && var2 < 343) {
                  this.mscro3 = 108;
                  this.spos3 = var2 - this.mscro3;
               }

               int var141 = 2670 / this.sdist;
               if (var141 < 1) {
                  var141 = 1;
               }

               if (this.mscro3 == 831) {
                  this.spos3 -= var141;
                  if (this.spos3 > 219) {
                     this.spos3 = 219;
                  }

                  if (this.spos3 < 0) {
                     this.spos3 = 0;
                  }

                  this.lspos3 = this.spos3;
               }

               if (this.mscro3 == 832) {
                  this.spos3 += var141;
                  if (this.spos3 > 219) {
                     this.spos3 = 219;
                  }

                  if (this.spos3 < 0) {
                     this.spos3 = 0;
                  }

                  this.lspos3 = this.spos3;
               }

               if (this.mscro3 < 800) {
                  this.spos3 = var2 - this.mscro3;
                  if (this.spos3 > 219) {
                     this.spos3 = 219;
                  }

                  if (this.spos3 < 0) {
                     this.spos3 = 0;
                  }
               }

               if (this.mscro3 == 825) {
                  this.mscro3 = 925;
               }
            } else if (this.mscro3 != 825) {
               this.mscro3 = 825;
            }
         }

         if (this.viewgame1 != 0) {
            this.rd.setColor(this.color2k(210, 210, 210));
            this.rd.fillRoundRect(204, 127, 583, 230, 20, 20);
            this.rd.setColor(this.color2k(150, 150, 150));
            this.rd.drawRoundRect(204, 127, 583, 230, 20, 20);
            this.rd.setFont(new Font("Tahoma", 1, 11));
            this.ftm = this.rd.getFontMetrics();
            this.rd.setColor(new Color(0, 0, 0));
            if (this.nvgames1 == 4) {
               this.rd.drawString("War declaration, your clan " + this.xt.clan + " versus " + this.xclan + ".", 215, 145);
               if (this.viewgame1 == 2) {
                  this.rd
                     .drawString("" + this.xclan + " would create 5 more games and the first clan to win 5 games wins the war!", 215, 210 + this.nvgames1 * 18);
               }
            }

            if (this.nvgames1 == 2) {
               this.rd.drawString("Battle, your clan " + this.xt.clan + " versus " + this.xclan + ".", 215, 145);
               if (this.viewgame1 == 2) {
                  this.rd
                     .drawString(
                        "" + this.xclan + " would create 3 more games and the first clan to win 3 games wins the battle!", 215, 210 + this.nvgames1 * 18
                     );
               }
            }

            if (this.nvgames1 == 9) {
               this.rd.drawString("Suggestion to accept war, your clan " + this.xt.clan + " versus " + this.xclan + ".", 215, 145);
            }

            if (this.nvgames1 == 5) {
               this.rd.drawString("Suggestion to accept to battle, your clan " + this.xt.clan + " versus " + this.xclan + ".", 215, 145);
            }

            if (this.stringbutton(this.rd, "Close X", 749, 148, 3, var1, var2, var3, 0, 0)) {
               this.viewgame1 = 0;
            }

            this.rd.setFont(new Font("Tahoma", 1, 11));
            this.ftm = this.rd.getFontMetrics();
            this.rd.setColor(new Color(0, 0, 0));
            if (this.viewgame1 == 2) {
               this.rd.drawString("Game", 246 - this.ftm.stringWidth("Game") / 2, 175);
               this.rd.drawString("Stage", 412 - this.ftm.stringWidth("Stage") / 2, 175);
               this.rd.drawString("Laps", 564 - this.ftm.stringWidth("Laps") / 2, 175);
               this.rd.drawString("Type of Cars", 653 - this.ftm.stringWidth("Type of Cars") / 2, 175);
               this.rd.drawString("Fixing", 751 - this.ftm.stringWidth("Fixing") / 2, 175);
               int var142 = 1;
               byte var155 = 1;
               if (this.nvgames1 == 4 || this.nvgames1 == 2) {
                  var142 = 2;
                  var155 = 2;
               }

               for (int var160 = 0; var160 < this.nvgames1; var160++) {
                  this.rd.setFont(new Font("Tahoma", 0, 11));
                  this.ftm = this.rd.getFontMetrics();
                  this.rd.drawString("# " + var142 + "", 246 - this.ftm.stringWidth("# " + var142 + "") / 2, 193 + var160 * 18);
                  var142 += var155;
                  this.rd.drawString(this.vwstages1[var160], 412 - this.ftm.stringWidth(this.vwstages1[var160]) / 2, 193 + var160 * 18);
                  this.rd.drawString("" + this.vwlaps1[var160] + "", 564 - this.ftm.stringWidth("" + this.vwlaps1[var160] + "") / 2, 193 + var160 * 18);
                  String var164 = "All Cars";
                  if (this.vwcars1[var160] == 2) {
                     var164 = "Clan Cars";
                  }

                  if (this.vwcars1[var160] == 3) {
                     var164 = "Game Cars";
                  }

                  if (this.vwclass1[var160] == 0) {
                     var164 = var164 + ", All Classes";
                  }

                  if (this.vwclass1[var160] == 1) {
                     var164 = var164 + ", Class C";
                  }

                  if (this.vwclass1[var160] == 2) {
                     var164 = var164 + ", Class B & C";
                  }

                  if (this.vwclass1[var160] == 3) {
                     var164 = var164 + ", Class B";
                  }

                  if (this.vwclass1[var160] == 4) {
                     var164 = var164 + ", Class A & B";
                  }

                  if (this.vwclass1[var160] == 5) {
                     var164 = var164 + ", Class A";
                  }

                  this.rd.drawString(var164, 653 - this.ftm.stringWidth(var164) / 2, 193 + var160 * 18);
                  String var11 = "Infinite";
                  if (this.vwfix1[var160] == 1) {
                     var11 = "4 Fixes";
                  }

                  if (this.vwfix1[var160] == 2) {
                     var11 = "3 Fixes";
                  }

                  if (this.vwfix1[var160] == 3) {
                     var11 = "2 Fixes";
                  }

                  if (this.vwfix1[var160] == 4) {
                     var11 = "1 Fix";
                  }

                  if (this.vwfix1[var160] == 5) {
                     var11 = "No Fixing";
                  }

                  this.rd.drawString(var11, 751 - this.ftm.stringWidth(var11) / 2, 193 + var160 * 18);
                  this.rd.drawRect(213, 180 + var160 * 18, 565, 18);
               }

               this.rd.drawLine(213, 162, 213, 180 + this.nvgames1 * 18);
               this.rd.drawLine(279, 162, 279, 180 + this.nvgames1 * 18);
               this.rd.drawLine(546, 162, 546, 180 + this.nvgames1 * 18);
               this.rd.drawLine(583, 162, 583, 180 + this.nvgames1 * 18);
               this.rd.drawLine(723, 162, 723, 180 + this.nvgames1 * 18);
               this.rd.drawLine(778, 162, 778, 180 + this.nvgames1 * 18);
            }

            if (this.viewgame1 == 1) {
               this.rd.drawString("Loading...", 495 - this.ftm.stringWidth("Loading...") / 2, 242);
            }

            if (this.viewgame1 == 3) {
               if (this.nvgames1 == 4 || this.nvgames1 == 9) {
                  this.rd
                     .drawString(
                        "This war suggestion has expired and no longer exists.",
                        495 - this.ftm.stringWidth("This war suggestion has expired and no longer exists.") / 2,
                        232
                     );
               }

               if (this.nvgames1 == 2 || this.nvgames1 == 5) {
                  this.rd
                     .drawString(
                        "This battle suggestion has expired and no longer exists.",
                        495 - this.ftm.stringWidth("This battle suggestion has expired and no longer exists.") / 2,
                        232
                     );
               }

               this.rd.drawString("(Suggestions expire after 90 days.)", 495 - this.ftm.stringWidth("(Suggestions expire after 90 days.)") / 2, 252);
            }

            if (this.viewgame1 == 4) {
               this.rd
                  .drawString(
                     "Error loading suggestion, please try again later...",
                     495 - this.ftm.stringWidth("Error loading suggestion, please try again later...") / 2,
                     242
                  );
            }
         }

         if (!this.xt.clan.equals("")) {
            if (!this.gs.sendtyp.isShowing()) {
               this.gs.sendtyp.show();
               this.gs.sendtyp.select(0);
            }

            this.gs.sendtyp.move(207, 365);
            if (this.sendcmsg != 0) {
               this.gs.sendtyp.disable();
            } else {
               this.gs.sendtyp.enable();
            }

            this.darker = true;
            if (this.gs.sendtyp.getSelectedIndex() == 0) {
               this.dommsg = true;
               if (this.sendcmsg == 0) {
                  if (this.stringbutton(this.rd, "   Send  >  ", 723, 408, 0, var1, var2, var3, 0, 0)
                     && !this.gs.mmsg.getText().trim().equals("")
                     && this.gs.mmsg.getText().toLowerCase().indexOf(this.gs.tpass.getText().toLowerCase()) == -1
                     && this.xt.acexp != -3) {
                     if (!this.xt.msgcheck(this.gs.mmsg.getText())) {
                        this.sendcmsg = 1;
                        this.viewgame1 = 0;
                     } else {
                        this.gs.sendtyp.hide();
                        this.xt.warning++;
                     }
                  }
               } else {
                  this.rd.setFont(new Font("Arial", 1, 12));
                  this.ftm = this.rd.getFontMetrics();
                  this.rd.setColor(new Color(0, 0, 0));
                  this.rd.drawString("Sending...", 723 - this.ftm.stringWidth("Sending...") / 2, 408);
               }
            }

            if (this.gs.sendtyp.getSelectedIndex() != 1) {
               if (this.gs.senditem.isShowing()) {
                  this.gs.senditem.hide();
               }

               if (this.gs.datat.isShowing()) {
                  this.gs.datat.hide();
               }
            } else {
               this.rd.setFont(new Font("Arial", 0, 12));
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawString("A date that gets converted to the local time of any person previewing it.", 376, 382);
               if (!this.gs.senditem.isShowing()) {
                  this.gs.senditem.removeAll();
                  Calendar var143 = Calendar.getInstance();
                  boolean var156 = false;

                  for (int var161 = 0; var161 < 20; var161++) {
                     String var165 = this.wday[var143.get(7) - 1];
                     if (!var156) {
                        var165 = "Today";
                        var156 = true;
                     }

                     this.gs.senditem.add(this.rd, "" + var165 + "  -  " + this.month[var143.get(2)] + " " + var143.get(5) + "");
                     var143.roll(5, true);
                  }

                  this.gs.senditem.select(0);
                  this.gs.senditem.show();
               }

               if (!this.gs.datat.isShowing()) {
                  this.gs.datat.removeAll();
                  int var144 = 12;
                  String var157 = "PM";

                  for (int var162 = 0; var162 < 24; var162++) {
                     this.gs.datat.add(this.rd, "" + var144 + " " + var157 + "");
                     if (++var144 == 12) {
                        var157 = "AM";
                     }

                     if (var144 == 13) {
                        var144 = 1;
                     }
                  }

                  this.gs.datat.select(0);
                  this.gs.datat.show();
               }

               this.gs.senditem.move(300, 395);
               this.gs.datat.move(491, 395);
               this.rd.setFont(new Font("Arial", 1, 12));
               this.ftm = this.rd.getFontMetrics();
               this.rd.drawString("Date is displayed based on your computer calendar's date/time, please make sure it is correct.", 207, 435);
               if (this.sendcmsg == 0) {
                  if (this.stringbutton(this.rd, "   Send  >  ", 723, 408, 0, var1, var2, var3, 0, 0)) {
                     this.sendcmsg = 1;
                     this.viewgame1 = 0;
                  }
               } else {
                  this.rd.setFont(new Font("Arial", 1, 12));
                  this.ftm = this.rd.getFontMetrics();
                  this.rd.drawString("Sending...", 723 - this.ftm.stringWidth("Sending...") / 2, 408);
               }
            }

            this.darker = false;
         }
      }
   }

   @Override
   public void run() {
      try {
         this.socket = new Socket(this.lg.servers[0], 7061);
         this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
         this.dout = new PrintWriter(this.socket.getOutputStream(), true);
      } catch (Exception var71) {
         this.domon = false;
      }

      while (this.domon) {
         String var1 = "";
         String var2 = "";
         var1 = "101|0|" + this.xt.nickname + ":" + this.xt.nickey + "|";

         try {
            this.dout.println(var1);
            var2 = this.din.readLine();
            if (var2 == null) {
               this.domon = false;
            }
         } catch (Exception var70) {
            this.domon = false;
         }

         if (this.domon) {
            this.ntime = this.getLvalue(var2, 0);
            this.maxclans = this.getvalue(var2, 1);

            for (int var3 = 0; var3 < 3; var3++) {
               for (int var4 = 0; var4 < 5; var4++) {
                  this.roomf[var3][var4] = 0;
               }
            }

            int var145 = 0;
            byte var176 = 2;

            for (boolean var5 = false; !var5; var176 += 3) {
               String var6 = this.getSvalue(var2, var176);
               if (!var6.equals("")) {
                  int var7 = this.getvalue(var2, var176 + 1);
                  int var8 = this.getvalue(var2, var176 + 2);
                  if ((var7 == -1 || var8 == -1) && var145 < 900) {
                     this.pname[var145] = var6;
                     this.proom[var145] = var7;
                     this.pserver[var145] = var8;
                     var145++;
                  }
               } else {
                  var5 = true;
               }
            }

            var176 = 2;

            for (boolean var239 = false; !var239; var176 += 3) {
               String var316 = this.getSvalue(var2, var176);
               if (!var316.equals("")) {
                  int var348 = this.getvalue(var2, var176 + 1);
                  int var381 = this.getvalue(var2, var176 + 2);
                  if (var348 >= 0 && var348 <= 4 && var381 >= 0 && var381 <= 2) {
                     this.roomf[var381][var348]++;
                     if (var145 < 900) {
                        this.pname[var145] = var316;
                        this.proom[var145] = var348;
                        this.pserver[var145] = var381;
                        var145++;
                     }
                  }
               } else {
                  var239 = true;
               }
            }

            this.npo = var145;
         }

         if (this.ptab == 1) {
            if (this.freq == 2) {
               var1 = "101|14|" + this.xt.nickname + "|" + this.xt.nickey + "|" + this.freqname + "|";

               try {
                  this.dout.println(var1);
                  var2 = this.din.readLine();
               } catch (Exception var69) {
               }

               if (var2.equals("OK")) {
                  this.freq = 0;
                  this.npf = -1;
               } else {
                  this.freq = -1;
                  this.cntf = 40;
               }
            }

            if (this.freq == 3) {
               var1 = "101|15|" + this.xt.nickname + "|" + this.xt.nickey + "|" + this.freqname + "|";

               try {
                  this.dout.println(var1);
                  var2 = this.din.readLine();
               } catch (Exception var68) {
               }

               if (var2.equals("OK")) {
                  this.freq = 0;
                  this.npf = -1;
               } else {
                  this.freq = -2;
                  this.cntf = 40;
               }
            }

            if (this.freq == -6) {
               var1 = "101|18|" + this.xt.nickname + "|" + this.xt.nickey + "|";

               try {
                  this.dout.println(var1);
                  var2 = this.din.readLine();
               } catch (Exception var67) {
               }

               this.freq = 0;
            }

            this.loadfriends();
         }

         if (this.sfreq == 1) {
            var1 = "101|16|" + this.xt.nickname + "|" + this.xt.nickey + "|" + this.proname + "|";

            try {
               this.dout.println(var1);
               var2 = this.din.readLine();
            } catch (Exception var66) {
            }

            if (var2.equals("OK")) {
               this.sfreq = 2;
            } else {
               this.sfreq = 3;
            }
         }

         if (this.sfreq == 4) {
            var1 = "101|17|" + this.xt.nickname + "|" + this.xt.nickey + "|" + this.proname + "|";

            try {
               this.dout.println(var1);
               var2 = this.din.readLine();
            } catch (Exception var65) {
            }

            if (var2.equals("OK")) {
               this.sfreq = 5;
               this.npf = -1;
            } else {
               this.sfreq = 6;
            }
         }

         if (this.sentchange == 2 && this.domon) {
            var1 = "101|5|" + this.gs.tnick.getText() + "|" + this.gs.tpass.getText() + "|" + this.sentance + "|";

            try {
               this.dout.println(var1);
               var2 = this.din.readLine();
            } catch (Exception var64) {
            }

            this.sentchange = 0;
         }

         if (this.tab == 2 && this.domon) {
            if (this.itab == 0) {
               if (!this.blockname.equals("")) {
                  for (int var146 = 0; var146 < this.nm; var146++) {
                     if (this.mname[var146].equals(this.blockname)) {
                        this.mtyp[var146] = 3;
                        break;
                     }
                  }

                  try {
                     var1 = "101|11|" + this.gs.tnick.getText() + "|" + this.gs.tpass.getText() + "|" + this.blockname + "|";
                     this.dout.println(var1);
                     var2 = this.din.readLine();
                  } catch (Exception var63) {
                  }

                  this.blockname = "";
               }

               if (!this.unblockname.equals("")) {
                  for (int var147 = 0; var147 < this.nm; var147++) {
                     if (this.mname[var147].equals(this.unblockname)) {
                        this.mtyp[var147] = 0;
                        break;
                     }
                  }

                  try {
                     var1 = "101|12|" + this.gs.tnick.getText() + "|" + this.gs.tpass.getText() + "|" + this.unblockname + "|";
                     this.dout.println(var1);
                     var2 = this.din.readLine();
                  } catch (Exception var62) {
                  }

                  this.unblockname = "";
               }

               try {
                  var1 = "101|13|" + this.xt.nickname + "|" + this.xt.nickey + "|" + this.loadmsgs + "|";
                  this.dout.println(var1);
                  var2 = this.din.readLine();
                  if (var2.startsWith("MSGS")) {
                     this.loadmsgs = this.getvalue(var2, 1);
                     DataInputStream var148 = new DataInputStream(this.socket.getInputStream());
                     byte[] var178 = new byte[this.loadmsgs];
                     var148.readFully(var178);
                     var2 = this.din.readLine();
                     var148 = new DataInputStream(new ByteArrayInputStream(var178));
                     String var240 = "";

                     for (this.nm = 0; (var240 = var148.readLine()) != null && this.nm < 200; this.nm++) {
                        this.mname[this.nm] = this.getSvalue(var240, 0);
                        this.mtyp[this.nm] = this.getvalue(var240, 1);
                        this.mconvo[this.nm] = this.getSvalue(var240, 2);
                        this.msub[this.nm] = this.getSvalue(var240, 3);
                        this.mctime[this.nm] = this.getLvalue(var240, 4);
                        this.mtime[this.nm] = "";
                     }
                  } else if (var2.equals("NOMSGS")) {
                     this.loadmsgs = 0;
                  }
               } catch (Exception var89) {
                  this.loadmsgs = -2;
               }

               if (this.loadmsgs > 0) {
                  for (int var150 = 0; var150 < this.nm; var150++) {
                     if (this.mctime[var150] > 0L) {
                        try {
                           long var179 = this.ntime - this.mctime[var150];
                           String var317 = "Received";
                           if (this.mtyp[var150] == 2) {
                              var317 = "Sent";
                           }

                           if (var179 >= 1000L && var179 < 60000L) {
                              this.mtime[var150] = "" + var317 + " seconds ago";
                           }

                           if (var179 >= 60000L && var179 < 3600000L) {
                              int var349 = (int)(var179 / 60000L);
                              String var382 = "s";
                              if (var349 == 1) {
                                 var382 = "";
                              }

                              this.mtime[var150] = "" + var317 + " " + var349 + " minute" + var382 + " ago";
                           }

                           if (var179 >= 3600000L && var179 < 86400000L) {
                              int var350 = (int)(var179 / 3600000L);
                              String var383 = "s";
                              if (var350 == 1) {
                                 var383 = "";
                              }

                              this.mtime[var150] = "" + var317 + " " + var350 + " hour" + var383 + " ago";
                           }

                           if (var179 >= 86400000L) {
                              int var351 = (int)(var179 / 86400000L);
                              String var384 = "s";
                              if (var351 == 1) {
                                 var384 = "";
                              }

                              this.mtime[var150] = "" + var317 + " " + var351 + " day" + var384 + " ago";
                           }
                        } catch (Exception var61) {
                           this.mtime[var150] = "";
                        }
                     } else {
                        this.mtime[var150] = "";
                     }
                  }
               }

               if (this.openc != 0) {
                  boolean var151 = false;
                  int var180 = -1;

                  for (int var242 = 0; var242 < this.nm; var242++) {
                     if (this.mname[var242].equals(this.opname)) {
                        var180 = var242;
                        break;
                     }
                  }

                  if (var180 != -1 && this.readmsg != 3 && this.readmsg != 4 && this.readmsg != 5) {
                     if (!this.lastsub.equals("" + this.mctime[var180])) {
                        var151 = true;
                        this.readmsg = 1;
                     } else {
                        this.readmsg = 2;
                     }
                  } else {
                     this.lastsub = "";
                     if (this.readmsg == 1) {
                        this.readmsg = 0;
                        this.nml = 0;
                     }
                  }

                  if (var151) {
                     try {
                        var1 = "101|8|" + this.xt.nickname + "|" + this.xt.nickey + "|" + this.mconvo[var180] + "";
                        this.dout.println(var1);
                        var2 = this.din.readLine();
                        if (!var2.startsWith("RECIVE")) {
                           this.readmsg = 3;
                        } else {
                           for (int var243 = 0; var243 < this.nml; var243++) {
                              this.mline[var243] = null;
                              this.mlinetyp[var243] = 0;
                              this.mctimes[var243] = 0L;
                              this.mtimes[var243] = null;
                           }

                           this.nml = 0;
                           this.cd.acname = "";
                           this.cd.action = 0;
                           this.cd.onstage = "";
                           this.addstage = 0;
                           this.nclns = 0;
                           int var244 = this.getvalue(var2, 1);
                           DataInputStream var318 = new DataInputStream(this.socket.getInputStream());
                           byte[] var352 = new byte[var244];
                           var318.readFully(var352);
                           var2 = this.din.readLine();
                           var318 = new DataInputStream(new ByteArrayInputStream(var352));
                           String var385 = "";

                           while ((var385 = var318.readLine()) != null) {
                              if (var385.startsWith("|")) {
                                 if (this.nml != 0) {
                                    this.mline[this.nml] = "";
                                    this.mlinetyp[this.nml] = 167;
                                    this.nml++;
                                 }

                                 String var409 = this.getSvalue(var385, 1);
                                 if (var409.toLowerCase().equals(this.xt.nickname.toLowerCase())) {
                                    var409 = "You";
                                 }

                                 this.mlinetyp[this.nml] = this.getvalue(var385, 2);
                                 int var424 = this.mlinetyp[this.nml];
                                 if (var424 == 0) {
                                    this.mline[this.nml] = "" + var409 + " wrote:";
                                    this.mctimes[this.nml] = this.getLvalue(var385, 3);
                                    this.mtimes[this.nml] = "";
                                    this.nml++;
                                 }

                                 if (var424 == 1) {
                                    this.mline[this.nml] = "" + var409 + " shared a car:";
                                    this.mctimes[this.nml] = this.getLvalue(var385, 3);
                                    this.mtimes[this.nml] = "";
                                    this.nml++;
                                    this.mline[this.nml] = this.getSvalue(var385, 4);
                                    this.mlinetyp[this.nml] = 10;
                                    this.nml++;
                                    this.mline[this.nml] = "";
                                    this.mlinetyp[this.nml] = 167;
                                    this.nml++;
                                 }

                                 if (var424 == 2) {
                                    this.mline[this.nml] = "" + var409 + " shared a stage:";
                                    this.mctimes[this.nml] = this.getLvalue(var385, 3);
                                    this.mtimes[this.nml] = "";
                                    this.nml++;
                                    this.mline[this.nml] = this.getSvalue(var385, 4);
                                    this.mlinetyp[this.nml] = 20;
                                    this.nml++;
                                    this.mline[this.nml] = "";
                                    this.mlinetyp[this.nml] = 167;
                                    this.nml++;
                                 }

                                 if (var424 == 3) {
                                    if (var409.equals("You")) {
                                       this.mline[this.nml] = "You have invited " + this.mname[var180] + " to join your clan:";
                                    } else {
                                       this.mline[this.nml] = "" + var409 + " has invited you to join clan:";
                                    }

                                    this.mctimes[this.nml] = this.getLvalue(var385, 3);
                                    this.mtimes[this.nml] = "";
                                    this.nml++;
                                    this.mline[this.nml] = this.getSvalue(var385, 4);
                                    if (this.nclns < 20) {
                                       this.clanlo[this.nclns] = this.mline[this.nml];
                                       this.nclns++;
                                    }

                                    this.mlinetyp[this.nml] = 30;
                                    this.nml++;
                                    this.mline[this.nml] = "";
                                    this.mlinetyp[this.nml] = 167;
                                    this.nml++;
                                    if (!var409.equals("You")) {
                                       if (this.xt.clan.equals("")) {
                                          this.mline[this.nml] = "(If you would like join this clan, visit that clan's page and click 'Request to Join..'.)";
                                       } else {
                                          this.mline[this.nml] = "(You will need to leave your clan " + this.xt.clan + " first before being able to join...)";
                                       }

                                       this.mlinetyp[this.nml] = -1;
                                       this.nml++;
                                    }
                                 }

                                 if (var424 == 4) {
                                    if (var409.equals("You")) {
                                       this.mline[this.nml] = "You have shared the following date:";
                                    } else {
                                       this.mline[this.nml] = "" + var409 + " has shared the following date:";
                                    }

                                    this.mctimes[this.nml] = this.getLvalue(var385, 3);
                                    this.mtimes[this.nml] = "";
                                    Calendar var11 = Calendar.getInstance();
                                    long var12 = var11.getTimeInMillis() - (this.ntime - this.mctimes[this.nml]) + this.getLvalue(var385, 4);
                                    if (var12 > 0L) {
                                       var11.setTimeInMillis(var12);
                                    }

                                    this.nml++;
                                    int var14 = var11.get(11);
                                    String var15 = "AM";
                                    if (var11.get(12) > 30) {
                                       if (++var14 == 24) {
                                          var14 -= 24;
                                       }
                                    }

                                    if (var14 >= 12) {
                                       var15 = "PM";
                                    }

                                    if (var14 > 12) {
                                       var14 -= 12;
                                    }

                                    if (var14 == 0) {
                                       var14 = 12;
                                    }

                                    try {
                                       this.mline[this.nml] = "[  "
                                          + this.wday[var11.get(7) - 1]
                                          + "  -  "
                                          + this.month[var11.get(2)]
                                          + " "
                                          + var11.get(5)
                                          + ",  "
                                          + var14
                                          + " "
                                          + var15
                                          + "  ]";
                                    } catch (Exception var60) {
                                       this.mline[this.nml] = "Error occurred while calculating this date.";
                                    }

                                    this.mlinetyp[this.nml] = -1;
                                    this.nml++;
                                    this.mline[this.nml] = "(Please make sure your computer's calendar/clock is adjusted correctly, to read this date in your local time.)";
                                    this.mlinetyp[this.nml] = -1;
                                    this.nml++;
                                 }
                              } else {
                                 this.mline[this.nml] = var385;

                                 try {
                                    this.rd.setFont(new Font("Tahoma", 0, 11));
                                    this.ftm = this.rd.getFontMetrics();
                                    int var9 = 0;

                                    String var10;
                                    for (var10 = ""; var9 < var385.length(); var9++) {
                                       var10 = var10 + var385.charAt(var9);
                                       if (this.ftm.stringWidth(var10) > 540) {
                                          if (var10.lastIndexOf(" ") != -1) {
                                             this.mline[this.nml] = var10.substring(0, var10.lastIndexOf(" "));
                                             var10 = var10.substring(var10.lastIndexOf(" ") + 1, var10.length());
                                          } else {
                                             this.mline[this.nml] = var10;
                                             var10 = "";
                                          }

                                          this.mlinetyp[this.nml] = -1;
                                          this.nml++;
                                       }
                                    }

                                    this.mline[this.nml] = var10;
                                 } catch (Exception var87) {
                                 }

                                 this.mlinetyp[this.nml] = -1;
                                 this.nml++;
                              }
                           }

                           this.readmsg = 2;
                           this.lastsub = "" + this.mctime[var180];
                           if (this.mtyp[var180] == 1) {
                              this.mtyp[var180] = 0;

                              try {
                                 this.dout.println("101|10|" + this.xt.nickname + "|" + this.opname + "|");
                                 var2 = this.din.readLine();
                              } catch (Exception var59) {
                              }
                           }

                           this.spos4 = 208;
                        }
                     } catch (Exception var88) {
                        this.readmsg = 4;
                     }
                  }

                  if (this.readmsg == 2) {
                     for (int var245 = 0; var245 < this.nml; var245++) {
                        if ((
                              this.mlinetyp[var245] == 0
                                 || this.mlinetyp[var245] == 1
                                 || this.mlinetyp[var245] == 2
                                 || this.mlinetyp[var245] == 3
                                 || this.mlinetyp[var245] == 4
                           )
                           && this.mctimes[var245] > 0L) {
                           try {
                              long var320 = this.ntime - this.mctimes[var245];
                              if (var320 >= 1000L && var320 < 60000L) {
                                 this.mtimes[var245] = "seconds ago";
                              }

                              if (var320 >= 60000L && var320 < 3600000L) {
                                 int var387 = (int)(var320 / 60000L);
                                 String var410 = "s";
                                 if (var387 == 1) {
                                    var410 = "";
                                 }

                                 this.mtimes[var245] = "" + var387 + " minute" + var410 + " ago";
                              }

                              if (var320 >= 3600000L && var320 < 86400000L) {
                                 int var388 = (int)(var320 / 3600000L);
                                 String var411 = "s";
                                 if (var388 == 1) {
                                    var411 = "";
                                 }

                                 this.mtimes[var245] = "" + var388 + " hour" + var411 + " ago";
                              }

                              if (var320 >= 86400000L) {
                                 int var389 = (int)(var320 / 86400000L);
                                 String var412 = "s";
                                 if (var389 == 1) {
                                    var412 = "";
                                 }

                                 this.mtimes[var245] = "" + var389 + " day" + var412 + " ago";
                              }
                           } catch (Exception var58) {
                              this.mtimes[var245] = "";
                           }
                        } else {
                           this.mtimes[var245] = "";
                        }
                     }
                  }
               }

               if (this.sendmsg == 2) {
                  this.gs.mmsg.setText(" ");
                  this.sendmsg = 0;
               }

               if (this.openc == 10) {
                  if (this.loaditem == 1) {
                     int var152 = 0;
                     String[] var181 = new String[700];

                     try {
                        URL var246 = new URL(
                           "http://multiplayer.needformadness.com/cars/lists/" + this.gs.tnick.getText() + ".txt?reqlo=" + (int)(Math.random() * 1000.0) + ""
                        );
                        var246.openConnection().setConnectTimeout(2000);
                        String var322 = "";
                        DataInputStream var353 = new DataInputStream(var246.openStream());

                        while ((var322 = var353.readLine()) != null) {
                           var322 = "" + var322.trim();
                           if (var322.startsWith("mycars")) {
                              boolean var390 = true;

                              while (var390 && var152 < 700) {
                                 var181[var152] = this.getfuncSvalue("mycars", var322, var152);
                                 if (var181[var152].equals("")) {
                                    var390 = false;
                                 } else {
                                    var152++;
                                 }
                              }
                           }
                        }

                        var353.close();
                     } catch (Exception var86) {
                        String var321 = "" + var86;
                        if (var321.indexOf("FileNotFound") != -1) {
                           var152 = 0;
                        } else {
                           var152 = -1;
                        }
                     }

                     if (var152 == -1) {
                        this.gs.senditem.removeAll();
                        this.gs.senditem.add(this.rd, "Failed to load your cars, please try again later.");
                        this.loaditem = 0;
                     }

                     if (var152 == 0) {
                        this.gs.senditem.removeAll();
                        this.gs.senditem.add(this.rd, "You have no added or published cars to load.");
                        this.loaditem = 0;
                     }

                     if (var152 > 0) {
                        String[] var247 = new String[700];
                        int var325 = 0;

                        for (int var354 = 0; var354 < var152; var354++) {
                           this.gs.senditem.removeAll();
                           this.gs.senditem.add(this.rd, "Loading shareable cars,  " + (int)((float)var354 / var152 * 100.0F) + " %");

                           try {
                              String var391 = "http://multiplayer.needformadness.com/cars/"
                                 + var181[var354]
                                 + ".txt?reqlo="
                                 + (int)(Math.random() * 1000.0)
                                 + "";
                              var391 = var391.replace(' ', '_');
                              URL var413 = new URL(var391);
                              var413.openConnection().setConnectTimeout(2000);
                              String var425 = "";
                              DataInputStream var438 = new DataInputStream(var413.openStream());

                              while ((var425 = var438.readLine()) != null) {
                                 var425 = "" + var425.trim();
                                 if (var425.startsWith("details")) {
                                    String var445 = this.getfuncSvalue("details", var425, 0);
                                    int var13 = this.getfuncvalue("details", var425, 1);
                                    if (var13 > 0 || var445.toLowerCase().equals(this.gs.tnick.getText().toLowerCase())) {
                                       var247[var325] = var181[var354];
                                       var325++;
                                    }
                                 }
                              }

                              var438.close();
                           } catch (Exception var85) {
                           }
                        }

                        this.gs.senditem.removeAll();
                        if (var325 > 0) {
                           for (int var355 = 0; var355 < var325; var355++) {
                              this.gs.senditem.add(this.rd, var247[var355]);
                           }

                           this.loaditem = 10;
                        } else {
                           this.gs.senditem.add(this.rd, "You have no cars that can be shared.");
                           this.loaditem = 0;
                        }
                     }
                  }

                  if (this.loaditem == 2) {
                     int var153 = 0;
                     String[] var182 = new String[700];

                     try {
                        URL var248 = new URL(
                           "http://multiplayer.needformadness.com/tracks/lists/" + this.gs.tnick.getText() + ".txt?reqlo=" + (int)(Math.random() * 1000.0) + ""
                        );
                        var248.openConnection().setConnectTimeout(2000);
                        String var327 = "";
                        DataInputStream var356 = new DataInputStream(var248.openStream());

                        while ((var327 = var356.readLine()) != null) {
                           var327 = "" + var327.trim();
                           if (var327.startsWith("mystages")) {
                              boolean var393 = true;

                              while (var393 && var153 < 700) {
                                 var182[var153] = this.getfuncSvalue("mystages", var327, var153);
                                 if (var182[var153].equals("")) {
                                    var393 = false;
                                 } else {
                                    var153++;
                                 }
                              }
                           }
                        }

                        var356.close();
                     } catch (Exception var84) {
                        String var326 = "" + var84;
                        if (var326.indexOf("FileNotFound") != -1) {
                           var153 = 0;
                        } else {
                           var153 = -1;
                        }
                     }

                     if (var153 == -1) {
                        this.gs.senditem.removeAll();
                        this.gs.senditem.add(this.rd, "Failed to load your stages, please try again later.");
                        this.loaditem = 0;
                     }

                     if (var153 == 0) {
                        this.gs.senditem.removeAll();
                        this.gs.senditem.add(this.rd, "You have no added or published stages to load.");
                        this.loaditem = 0;
                     }

                     if (var153 > 0) {
                        String[] var249 = new String[700];
                        int var330 = 0;

                        for (int var357 = 0; var357 < var153; var357++) {
                           this.gs.senditem.removeAll();
                           this.gs.senditem.add(this.rd, "Loading shareable stages,  " + (int)((float)var357 / var153 * 100.0F) + " %");

                           try {
                              String var394 = "http://multiplayer.needformadness.com/tracks/"
                                 + var182[var357]
                                 + ".txt?reqlo="
                                 + (int)(Math.random() * 1000.0)
                                 + "";
                              var394 = var394.replace(' ', '_');
                              URL var414 = new URL(var394);
                              var414.openConnection().setConnectTimeout(2000);
                              String var428 = "";
                              DataInputStream var439 = new DataInputStream(var414.openStream());

                              while ((var428 = var439.readLine()) != null) {
                                 var428 = "" + var428.trim();
                                 if (var428.startsWith("details")) {
                                    String var446 = this.getfuncSvalue("details", var428, 0);
                                    int var451 = this.getfuncvalue("details", var428, 1);
                                    if (var451 > 0 || var446.toLowerCase().equals(this.gs.tnick.getText().toLowerCase())) {
                                       var249[var330] = var182[var357];
                                       var330++;
                                    }
                                 }
                              }

                              var439.close();
                           } catch (Exception var83) {
                           }
                        }

                        this.gs.senditem.removeAll();
                        if (var330 > 0) {
                           for (int var358 = 0; var358 < var330; var358++) {
                              this.gs.senditem.add(this.rd, var249[var358]);
                           }

                           this.loaditem = 20;
                        } else {
                           this.gs.senditem.add(this.rd, "You have no stages that can be shared.");
                           this.loaditem = 0;
                        }
                     }
                  }

                  if (this.gs.sendtyp.getSelectedIndex() == 3 && !this.xt.clan.equals("")) {
                     this.clanlogopng(this.xt.clan);
                  }

                  if (this.sendmsg == 1) {
                     try {
                        String var154 = "#nada#";

                        for (int var183 = 0; var183 < this.nm; var183++) {
                           if (this.mname[var183].equals(this.opname)) {
                              var154 = this.mconvo[var183];
                              break;
                           }
                        }

                        var1 = "101|9|"
                           + this.xt.nickname
                           + "|"
                           + this.xt.nickey
                           + "|"
                           + this.opname
                           + "|"
                           + var154
                           + "|"
                           + this.gs.sendtyp.getSelectedIndex()
                           + "|";
                        if (this.gs.sendtyp.getSelectedIndex() == 0) {
                           String var184 = this.gs.mmsg.getText().replace("|", ":");
                           var184 = var184.replaceAll("[\\t\\n\\r]", "|");
                           String var250 = "";
                           int var331 = 0;

                           for (int var359 = 0; var331 < var184.length(); var331++) {
                              String var396 = "" + var184.charAt(var331);
                              if (var396.equals("|")) {
                                 var359++;
                              } else {
                                 var359 = 0;
                              }

                              if (var359 <= 1) {
                                 var250 = var250 + var396;
                              }
                           }

                           var1 = var1 + "" + var250 + "||";
                        }

                        if (this.gs.sendtyp.getSelectedIndex() == 1 || this.gs.sendtyp.getSelectedIndex() == 2) {
                           var1 = var1 + "" + this.gs.senditem.getSelectedItem() + "|";
                        }

                        if (this.gs.sendtyp.getSelectedIndex() == 3) {
                           var1 = var1 + "" + this.xt.clan + "|";
                        }

                        if (this.gs.sendtyp.getSelectedIndex() == 4) {
                           Calendar var186 = Calendar.getInstance();
                           long var251 = var186.getTimeInMillis();
                           var186.roll(5, this.gs.senditem.getSelectedIndex());
                           int var360 = this.gs.datat.getSelectedIndex() + 12;
                           if (var360 >= 24) {
                              var360 -= 24;
                           }

                           var186.set(var186.get(1), var186.get(2), var186.get(5), var360, 0);
                           var251 = var186.getTimeInMillis() - var251;
                           var1 = var1 + "" + var251 + "|";
                        }

                        this.dout.println(var1);
                        var2 = this.din.readLine();
                        if (var2.equals("OK")) {
                           this.sendmsg = 2;
                        } else {
                           this.readmsg = 5;
                           this.sendmsg = 0;
                        }
                     } catch (Exception var82) {
                        this.readmsg = 5;
                        this.sendmsg = 0;
                     }
                  }
               }
            }

            if (this.itab == 1 && !this.xt.clan.equals("")) {
               try {
                  var1 = "101|38|" + this.xt.clan + "|" + this.xt.clankey + "|" + this.loadinter + "|";
                  this.dout.println(var1);
                  var2 = this.din.readLine();
                  if (var2.startsWith("INTER")) {
                     this.loadinter = this.getvalue(var2, 1);
                     DataInputStream var155 = new DataInputStream(this.socket.getInputStream());
                     byte[] var187 = new byte[this.loadinter];
                     var155.readFully(var187);
                     var2 = this.din.readLine();
                     var155 = new DataInputStream(new ByteArrayInputStream(var187));
                     String var253 = "";

                     for (this.ni = 0; (var253 = var155.readLine()) != null && this.ni < 200; this.ni++) {
                        this.iclan[this.ni] = this.getSvalue(var253, 0);
                        this.icheck[this.ni] = this.getSvalue(var253, 1);
                        this.iconvo[this.ni] = this.getSvalue(var253, 2);
                        this.isub[this.ni] = this.getSvalue(var253, 3);
                        this.ictime[this.ni] = this.getLvalue(var253, 4);
                        this.itime[this.ni] = "";
                        this.istat[this.ni] = this.getSvalue(var253, 5);
                        if (this.istat[this.ni].equals("War")) {
                           this.iwarn[this.ni] = this.getSvalue(var253, 6);
                        }

                        if (this.istat[this.ni].equals("Car Battle") || this.istat[this.ni].equals("Stage Battle")) {
                           this.iwarn[this.ni] = this.getSvalue(var253, 6);
                           this.itcar[this.ni] = this.getSvalue(var253, 7);
                           this.igcar[this.ni] = this.getSvalue(var253, 8);
                        }
                     }
                  } else if (var2.equals("NOINTER")) {
                     this.loadinter = 0;
                  }
               } catch (Exception var81) {
                  this.loadmsgs = -2;
               }

               if (this.loadinter > 0) {
                  for (int var157 = 0; var157 < this.ni; var157++) {
                     if (this.ictime[var157] > 0L) {
                        try {
                           long var188 = this.ntime - this.ictime[var157];
                           if (var188 >= 1000L && var188 < 60000L) {
                              this.itime[var157] = "Seconds ago";
                           }

                           if (var188 >= 60000L && var188 < 3600000L) {
                              int var332 = (int)(var188 / 60000L);
                              String var361 = "s";
                              if (var332 == 1) {
                                 var361 = "";
                              }

                              this.itime[var157] = "" + var332 + " minute" + var361 + " ago";
                           }

                           if (var188 >= 3600000L && var188 < 86400000L) {
                              int var333 = (int)(var188 / 3600000L);
                              String var362 = "s";
                              if (var333 == 1) {
                                 var362 = "";
                              }

                              this.itime[var157] = "" + var333 + " hour" + var362 + " ago";
                           }

                           if (var188 >= 86400000L) {
                              int var334 = (int)(var188 / 86400000L);
                              String var363 = "s";
                              if (var334 == 1) {
                                 var363 = "";
                              }

                              this.itime[var157] = "" + var334 + " day" + var363 + " ago";
                           }
                        } catch (Exception var57) {
                           this.itime[var157] = "";
                        }
                     } else {
                        this.itime[var157] = "";
                     }
                  }
               }

               if (this.loadwstat == 0) {
                  this.loadchamps();
               }

               if (this.openi != 0) {
                  boolean var158 = false;
                  int var189 = -1;

                  for (int var255 = 0; var255 < this.ni; var255++) {
                     if (this.iclan[var255].equals(this.intclan)) {
                        var189 = var255;
                        break;
                     }
                  }

                  if (this.readint == 6) {
                     try {
                        Thread.sleep(2000L);
                     } catch (InterruptedException var56) {
                     }
                  }

                  if (var189 != -1 && this.readint != 3 && this.readint != 4 && this.readint != 5) {
                     if (!this.lastint.equals("" + this.ictime[var189])) {
                        var158 = true;
                        this.readint = 1;
                     } else {
                        this.readint = 2;
                     }
                  } else {
                     this.lastint = "";
                     if (this.readint == 1) {
                        this.readint = 0;
                        this.nil = 0;
                     }
                  }

                  if (var158 && this.sendint != 1) {
                     try {
                        var1 = "101|40|" + this.xt.clan + "|" + this.xt.clankey + "|" + this.iconvo[var189] + "|";
                        this.dout.println(var1);
                        var2 = this.din.readLine();
                        if (!var2.startsWith("RECIVE")) {
                           this.readint = 3;
                        } else {
                           if (this.istat[var189].equals("Car Battle")) {
                              this.dispi = 1;
                              this.dwarn = this.iwarn[var189];
                              this.dtcar = this.itcar[var189];
                              this.dgcar = this.igcar[var189];
                           }

                           if (this.istat[var189].equals("Stage Battle")) {
                              this.dispi = 2;
                              this.dwarn = this.iwarn[var189];
                              this.dtcar = this.itcar[var189];
                              this.dgcar = this.igcar[var189];
                           }

                           if (this.istat[var189].equals("War")) {
                              this.dispi = 3;
                              this.dwarn = this.iwarn[var189];
                           }

                           int var256 = 0;
                           String[] var335 = new String[1000];
                           int[] var364 = new int[1000];
                           long[] var397 = new long[1000];
                           String[] var415 = new String[1000];
                           if (this.dispi != 0) {
                              var335[var256] = "";
                              var364[var256] = 167;
                              var335[++var256] = "";
                              var364[var256] = 167;
                              var256++;
                           }

                           int var431 = this.getvalue(var2, 1);
                           DataInputStream var440 = new DataInputStream(this.socket.getInputStream());
                           byte[] var447 = new byte[var431];
                           var440.readFully(var447);
                           var2 = this.din.readLine();
                           var440 = new DataInputStream(new ByteArrayInputStream(var447));
                           String var452 = "";

                           while ((var452 = var440.readLine()) != null) {
                              if (var452.startsWith("|")) {
                                 if (var256 != 0) {
                                    var335[var256] = "";
                                    var364[var256] = 167;
                                    var256++;
                                 }

                                 String var457 = this.getSvalue(var452, 1);
                                 if (var457.toLowerCase().equals(this.xt.nickname.toLowerCase())) {
                                    var457 = "You";
                                 }

                                 var364[var256] = this.getvalue(var452, 2);
                                 int var468 = var364[var256];
                                 if (var468 == 0) {
                                    var335[var256] = "" + var457 + " wrote:";
                                    var397[var256] = this.getLvalue(var452, 3);
                                    var415[var256] = "";
                                    var256++;
                                 }

                                 if (var468 == 1) {
                                    if (var457.equals("You")) {
                                       var335[var256] = "You have shared the following date:";
                                    } else {
                                       var335[var256] = "" + var457 + " has shared the following date:";
                                    }

                                    var397[var256] = this.getLvalue(var452, 3);
                                    var415[var256] = "";
                                    Calendar var16 = Calendar.getInstance();
                                    long var17 = var16.getTimeInMillis() - (this.ntime - var397[var256]) + this.getLvalue(var452, 4);
                                    if (var17 > 0L) {
                                       var16.setTimeInMillis(var17);
                                    }

                                    var256++;
                                    int var19 = var16.get(11);
                                    String var20 = "AM";
                                    if (var16.get(12) > 30) {
                                       if (++var19 == 24) {
                                          var19 -= 24;
                                       }
                                    }

                                    if (var19 >= 12) {
                                       var20 = "PM";
                                    }

                                    if (var19 > 12) {
                                       var19 -= 12;
                                    }

                                    if (var19 == 0) {
                                       var19 = 12;
                                    }

                                    try {
                                       var335[var256] = "[  "
                                          + this.wday[var16.get(7) - 1]
                                          + "  -  "
                                          + this.month[var16.get(2)]
                                          + " "
                                          + var16.get(5)
                                          + ",  "
                                          + var19
                                          + " "
                                          + var20
                                          + "  ]";
                                    } catch (Exception var55) {
                                       var335[var256] = "Error occurred while calculating this date.";
                                    }

                                    var364[var256] = -1;
                                    var335[++var256] = "(Please make sure your computer's calendar/clock is adjusted correctly, to read this date in your local time.)";
                                    var364[var256] = -1;
                                    var256++;
                                 }

                                 if (var468 == 4) {
                                    if (var457.toLowerCase().equals(this.xt.clan.toLowerCase())) {
                                       var335[var256] = "Your clan has declared war on " + this.intclan + ":";
                                       var397[var256] = this.getLvalue(var452, 3);
                                       var415[var256] = "";
                                       var335[++var256] = "I|" + this.getSvalue(var452, 4) + "|" + this.getSvalue(var452, 5) + "|";
                                       var364[var256] = 40;
                                       var335[++var256] = "";
                                       var364[var256] = 167;
                                       var256++;
                                       if (this.loadwstat == 1 && !var452.endsWith("|out|")) {
                                          int var478 = -1;
                                          int var491 = 0;
                                          int var498 = -1;
                                          int var504 = 0;

                                          for (int var515 = 0; var515 < this.ncc; var515++) {
                                             if (this.xt.clan.toLowerCase().equals(this.conclan[var515].toLowerCase())) {
                                                var491 = this.totp[var515];
                                                var478 = var515;
                                             }

                                             if (this.intclan.toLowerCase().equals(this.conclan[var515].toLowerCase())) {
                                                var504 = this.totp[var515];
                                                var498 = var515;
                                             }
                                          }

                                          int var516 = var504 + 1;
                                          int var526 = var491 + 1;
                                          if (var526 > var504) {
                                             var526 = var504;
                                          }

                                          if (var478 != -1) {
                                             for (int var535 = 0; var535 < this.nvc[var478]; var535++) {
                                                if (this.intclan.toLowerCase().equals(this.verclan[var478][var535].toLowerCase())) {
                                                   var516 -= this.points[var478][var535];
                                                   if (var516 < 0) {
                                                      var516 = 0;
                                                   }
                                                   break;
                                                }
                                             }
                                          }

                                          var335[var256] = "If you win this war, your clan would get:  [ "
                                             + var516
                                             + " points ]   &  "
                                             + this.intclan
                                             + " would lose:  [ "
                                             + var526
                                             + " points ]";
                                          var364[var256] = -1;
                                          var256++;
                                          var516 = var491 + 1;
                                          var526 = var504 + 1;
                                          if (var526 > var491) {
                                             var526 = var491;
                                          }

                                          if (var498 != -1) {
                                             for (int var536 = 0; var536 < this.nvc[var498]; var536++) {
                                                if (this.xt.clan.toLowerCase().equals(this.verclan[var498][var536].toLowerCase())) {
                                                   var516 -= this.points[var498][var536];
                                                   if (var516 < 0) {
                                                      var516 = 0;
                                                   }
                                                   break;
                                                }
                                             }
                                          }

                                          var335[var256] = "If you lose this war, your clan would lose:  [ "
                                             + var526
                                             + " points ]   &  "
                                             + this.intclan
                                             + " would get:  [ "
                                             + var516
                                             + " points ]";
                                          var364[var256] = -1;
                                          var256++;
                                       }

                                       if (!var452.endsWith("|out|")) {
                                          var335[var256] = "(Waiting for " + this.intclan + " to accept this war declaration and create 5 more games.)";
                                          var364[var256] = -1;
                                          var256++;
                                       }
                                    } else {
                                       var335[var256] = "" + this.intclan + " has declaring war on your clan:";
                                       var397[var256] = this.getLvalue(var452, 3);
                                       var415[var256] = "";
                                       var335[++var256] = "Y|" + this.getSvalue(var452, 4) + "|" + this.getSvalue(var452, 5) + "|";
                                       var364[var256] = 40;
                                       var335[++var256] = "";
                                       var364[var256] = 167;
                                       var256++;
                                       if (this.loadwstat == 1 && !var452.endsWith("|out|")) {
                                          int var477 = -1;
                                          int var490 = 0;
                                          int var18 = -1;
                                          int var503 = 0;

                                          for (int var512 = 0; var512 < this.ncc; var512++) {
                                             if (this.xt.clan.toLowerCase().equals(this.conclan[var512].toLowerCase())) {
                                                var490 = this.totp[var512];
                                                var477 = var512;
                                             }

                                             if (this.intclan.toLowerCase().equals(this.conclan[var512].toLowerCase())) {
                                                var503 = this.totp[var512];
                                                var18 = var512;
                                             }
                                          }

                                          int var513 = var503 + 1;
                                          int var21 = var490 + 1;
                                          if (var21 > var503) {
                                             var21 = var503;
                                          }

                                          if (var477 != -1) {
                                             for (int var22 = 0; var22 < this.nvc[var477]; var22++) {
                                                if (this.intclan.toLowerCase().equals(this.verclan[var477][var22].toLowerCase())) {
                                                   var513 -= this.points[var477][var22];
                                                   if (var513 < 0) {
                                                      var513 = 0;
                                                   }
                                                   break;
                                                }
                                             }
                                          }

                                          var335[var256] = "If you win this war, your clan would get:  [ "
                                             + var513
                                             + " points ]   &  "
                                             + this.intclan
                                             + " would lose:  [ "
                                             + var21
                                             + " points ]";
                                          var364[var256] = -1;
                                          var256++;
                                          var513 = var490 + 1;
                                          var21 = var503 + 1;
                                          if (var21 > var490) {
                                             var21 = var490;
                                          }

                                          if (var18 != -1) {
                                             for (int var534 = 0; var534 < this.nvc[var18]; var534++) {
                                                if (this.xt.clan.toLowerCase().equals(this.verclan[var18][var534].toLowerCase())) {
                                                   var513 -= this.points[var18][var534];
                                                   if (var513 < 0) {
                                                      var513 = 0;
                                                   }
                                                   break;
                                                }
                                             }
                                          }

                                          var335[var256] = "If you lose this war, your clan would lose:  [ "
                                             + var21
                                             + " points ]   &  "
                                             + this.intclan
                                             + " would get:  [ "
                                             + var513
                                             + " points ]";
                                          var364[var256] = -1;
                                          var256++;
                                       }

                                       if (!var452.endsWith("|out|")) {
                                          var335[var256] = "(You accept this war declaration by creating 5 more games to be added to it.)";
                                          var364[var256] = -1;
                                          var256++;
                                       }
                                    }
                                 }

                                 if (var468 == 3) {
                                    if (var457.toLowerCase().equals(this.xt.clan.toLowerCase())) {
                                       var335[var256] = "Your clan has challenged " + this.intclan + " to a car battle:";
                                       var397[var256] = this.getLvalue(var452, 3);
                                       var415[var256] = "";
                                       var335[++var256] = "I|"
                                          + this.getSvalue(var452, 4)
                                          + "|"
                                          + this.getSvalue(var452, 5)
                                          + "|"
                                          + this.getSvalue(var452, 6)
                                          + "|"
                                          + this.getSvalue(var452, 7)
                                          + "|";
                                       var364[var256] = 30;
                                       var335[++var256] = "";
                                       var364[var256] = 167;
                                       var335[++var256] = "If you win you will take " + this.intclan + "'s car :  [ " + this.getSvalue(var452, 4) + " ]";
                                       var364[var256] = -1;
                                       var335[++var256] = "If you lose you will give "
                                          + this.intclan
                                          + " your clan's car :  [ "
                                          + this.getSvalue(var452, 5)
                                          + " ]";
                                       var364[var256] = -1;
                                       var256++;
                                       if (!var452.endsWith("|out|")) {
                                          var335[var256] = "(Waiting for " + this.intclan + " to accept this car battle and create 3 more games.)";
                                          var364[var256] = -1;
                                          var256++;
                                       }
                                    } else {
                                       var335[var256] = "" + this.intclan + " has challenged your clan to a car battle:";
                                       var397[var256] = this.getLvalue(var452, 3);
                                       var415[var256] = "";
                                       var335[++var256] = "Y|"
                                          + this.getSvalue(var452, 5)
                                          + "|"
                                          + this.getSvalue(var452, 4)
                                          + "|"
                                          + this.getSvalue(var452, 6)
                                          + "|"
                                          + this.getSvalue(var452, 7)
                                          + "|";
                                       var364[var256] = 30;
                                       var335[++var256] = "";
                                       var364[var256] = 167;
                                       var335[++var256] = "If you win you will take " + this.intclan + "'s car :  [ " + this.getSvalue(var452, 5) + " ]";
                                       var364[var256] = -1;
                                       var335[++var256] = "If you lose you will give "
                                          + this.intclan
                                          + " your clan's car :  [ "
                                          + this.getSvalue(var452, 4)
                                          + " ]";
                                       var364[var256] = -1;
                                       var256++;
                                       if (!var452.endsWith("|out|")) {
                                          var335[var256] = "(You accept this car battle by creating 3 more games to be added to it.)";
                                          var364[var256] = -1;
                                          var256++;
                                       }
                                    }
                                 }

                                 if (var468 == 2) {
                                    if (var457.toLowerCase().equals(this.xt.clan.toLowerCase())) {
                                       var335[var256] = "Your clan has challenged " + this.intclan + " to a stage battle:";
                                       var397[var256] = this.getLvalue(var452, 3);
                                       var415[var256] = "";
                                       var335[++var256] = "I|"
                                          + this.getSvalue(var452, 4)
                                          + "|"
                                          + this.getSvalue(var452, 5)
                                          + "|"
                                          + this.getSvalue(var452, 6)
                                          + "|"
                                          + this.getSvalue(var452, 7)
                                          + "|";
                                       var364[var256] = 20;
                                       var335[++var256] = "";
                                       var364[var256] = 167;
                                       var256++;
                                       String var479 = this.getSvalue(var452, 4);
                                       if (var479.length() > 20) {
                                          var479 = "" + var479.substring(0, 20) + "...";
                                       }

                                       var335[var256] = "If you win you will take " + this.intclan + "'s stage :  [ " + var479 + " ]";
                                       var364[var256] = -1;
                                       var256++;
                                       var479 = this.getSvalue(var452, 5);
                                       if (var479.length() > 20) {
                                          var479 = "" + var479.substring(0, 20) + "...";
                                       }

                                       var335[var256] = "If you lose you will give " + this.intclan + " your clan's stage :  [ " + var479 + " ]";
                                       var364[var256] = -1;
                                       var256++;
                                       if (!var452.endsWith("|out|")) {
                                          var335[var256] = "(Waiting for " + this.intclan + " to accept this stage battle and create 3 more games.)";
                                          var364[var256] = -1;
                                          var256++;
                                       }
                                    } else {
                                       var335[var256] = "" + this.intclan + " has challenged your clan to a stage battle:";
                                       var397[var256] = this.getLvalue(var452, 3);
                                       var415[var256] = "";
                                       var335[++var256] = "Y|"
                                          + this.getSvalue(var452, 5)
                                          + "|"
                                          + this.getSvalue(var452, 4)
                                          + "|"
                                          + this.getSvalue(var452, 6)
                                          + "|"
                                          + this.getSvalue(var452, 7)
                                          + "|";
                                       var364[var256] = 20;
                                       var335[++var256] = "";
                                       var364[var256] = 167;
                                       var256++;
                                       String var481 = this.getSvalue(var452, 5);
                                       if (var481.length() > 20) {
                                          var481 = "" + var481.substring(0, 20) + "...";
                                       }

                                       var335[var256] = "If you win you will take " + this.intclan + "'s stage :  [ " + var481 + " ]";
                                       var364[var256] = -1;
                                       var256++;
                                       var481 = this.getSvalue(var452, 4);
                                       if (var481.length() > 20) {
                                          var481 = "" + var481.substring(0, 20) + "...";
                                       }

                                       var335[var256] = "If you lose you will give " + this.intclan + " your clan's stage :  [ " + var481 + " ]";
                                       var364[var256] = -1;
                                       var256++;
                                       if (!var452.endsWith("|out|")) {
                                          var335[var256] = "(You accept this stage battle by creating 3 more games to be added to it.)";
                                          var364[var256] = -1;
                                          var256++;
                                       }
                                    }
                                 }

                                 if (var468 == 5) {
                                    var335[var256] = "A stage battle has now started between your clan and " + this.intclan + " !";
                                    var397[var256] = this.getLvalue(var452, 3);
                                    var415[var256] = "";
                                    var335[++var256] = "(See the bar at the top of the page for more details.)";
                                    var364[var256] = -1;
                                    var335[++var256] = "Arrange to meet "
                                       + this.intclan
                                       + " at a chosen room in a server on a specific date to play the battle.";
                                    var364[var256] = -1;
                                    var335[++var256] = "Use the 'Share a Relative Date' option to help you organize a time that is suitable for all.";
                                    var364[var256] = -1;
                                    var256++;
                                 }

                                 if (var468 == 6) {
                                    var335[var256] = "A car battle has now started between your clan and " + this.intclan + " !";
                                    var397[var256] = this.getLvalue(var452, 3);
                                    var415[var256] = "";
                                    var335[++var256] = "(See the bar at the top of the page for more details.)";
                                    var364[var256] = -1;
                                    var335[++var256] = "Arrange to meet "
                                       + this.intclan
                                       + " at a chosen room in a server on a specific date to play the battle.";
                                    var364[var256] = -1;
                                    var335[++var256] = "Use the 'Share a Relative Date' option to help you organize a time that is suitable for all.";
                                    var364[var256] = -1;
                                    var256++;
                                 }

                                 if (var468 == 7) {
                                    var335[var256] = "A war has now started between your clan and " + this.intclan + " !";
                                    var397[var256] = this.getLvalue(var452, 3);
                                    var415[var256] = "";
                                    var256++;
                                    if (this.loadwstat == 1) {
                                       int var483 = -1;
                                       int var492 = 0;
                                       int var499 = -1;
                                       int var505 = 0;

                                       for (int var518 = 0; var518 < this.ncc; var518++) {
                                          if (this.xt.clan.toLowerCase().equals(this.conclan[var518].toLowerCase())) {
                                             var492 = this.totp[var518];
                                             var483 = var518;
                                          }

                                          if (this.intclan.toLowerCase().equals(this.conclan[var518].toLowerCase())) {
                                             var505 = this.totp[var518];
                                             var499 = var518;
                                          }
                                       }

                                       int var519 = var505 + 1;
                                       int var528 = var492 + 1;
                                       if (var528 > var505) {
                                          var528 = var505;
                                       }

                                       if (var483 != -1) {
                                          for (int var537 = 0; var537 < this.nvc[var483]; var537++) {
                                             if (this.intclan.toLowerCase().equals(this.verclan[var483][var537].toLowerCase())) {
                                                var519 -= this.points[var483][var537];
                                                if (var519 < 0) {
                                                   var519 = 0;
                                                }
                                                break;
                                             }
                                          }
                                       }

                                       var335[var256] = "If you win this war, your clan would get:  [ "
                                          + var519
                                          + " points ]   &  "
                                          + this.intclan
                                          + " would lose:  [ "
                                          + var528
                                          + " points ]";
                                       var364[var256] = -1;
                                       var256++;
                                       var519 = var492 + 1;
                                       var528 = var505 + 1;
                                       if (var528 > var492) {
                                          var528 = var492;
                                       }

                                       if (var499 != -1) {
                                          for (int var538 = 0; var538 < this.nvc[var499]; var538++) {
                                             if (this.xt.clan.toLowerCase().equals(this.verclan[var499][var538].toLowerCase())) {
                                                var519 -= this.points[var499][var538];
                                                if (var519 < 0) {
                                                   var519 = 0;
                                                }
                                                break;
                                             }
                                          }
                                       }

                                       var335[var256] = "If you lose this war, your clan would lose:  [ "
                                          + var528
                                          + " points ]   &  "
                                          + this.intclan
                                          + " would get:  [ "
                                          + var519
                                          + " points ]";
                                       var364[var256] = -1;
                                       var256++;
                                    }

                                    var335[var256] = "(See the bar at the top of the page for more details.)";
                                    var364[var256] = -1;
                                    var335[++var256] = "Arrange to meet " + this.intclan + " at a chosen room in a server on a specific date to play the war.";
                                    var364[var256] = -1;
                                    var335[++var256] = "Use the 'Share a Relative Date' option to help you organize a time that is suitable for all.";
                                    var364[var256] = -1;
                                    var256++;
                                 }

                                 if (var468 == 8) {
                                    if (var457.toLowerCase().equals(this.xt.clan.toLowerCase())) {
                                       var335[var256] = "Your clan has defeated " + this.intclan + " in the war, congratulations!";
                                    } else {
                                       var335[var256] = "Your clan has lost the war against " + this.intclan + ".";
                                    }

                                    var397[var256] = this.getLvalue(var452, 3);
                                    var415[var256] = "";
                                    var256++;
                                    if (var457.toLowerCase().equals(this.xt.clan.toLowerCase())) {
                                       var335[var256] = "Your clan won:  [ "
                                          + this.getSvalue(var452, 5)
                                          + " points ]   &  "
                                          + this.intclan
                                          + " lost:  [ "
                                          + this.getSvalue(var452, 6)
                                          + " points ]";
                                    } else {
                                       var335[var256] = "Your clan lost:  [ "
                                          + this.getSvalue(var452, 6)
                                          + " points ]   &  "
                                          + this.intclan
                                          + " won:  [ "
                                          + this.getSvalue(var452, 5)
                                          + " points ]";
                                    }

                                    var364[var256] = -1;
                                    var335[++var256] = "" + this.getSvalue(var452, 4) + "|";
                                    var364[var256] = 80;
                                    var335[++var256] = "";
                                    var364[var256] = 167;
                                    var256++;
                                 }

                                 if (var468 == 9) {
                                    String var484 = "";
                                    if (var457.toLowerCase().equals(this.xt.clan.toLowerCase())) {
                                       var335[var256] = "Your clan has defeated " + this.intclan + " in the car battle, congratulations!";
                                       var397[var256] = this.getLvalue(var452, 3);
                                       var415[var256] = "";
                                       var335[++var256] = "You took " + this.intclan + "'s car :  [ " + this.getSvalue(var452, 5) + " ] !";
                                       var364[var256] = -1;
                                       var256++;
                                       var484 = this.xt.clan;
                                    } else {
                                       var335[var256] = "Your clan has lost the car battle against " + this.intclan + ".";
                                       var397[var256] = this.getLvalue(var452, 3);
                                       var415[var256] = "";
                                       var335[++var256] = "" + this.intclan + " took your car :  [ " + this.getSvalue(var452, 5) + " ] !";
                                       var364[var256] = -1;
                                       var256++;
                                       var484 = this.intclan;
                                    }

                                    var335[var256] = "" + this.getSvalue(var452, 4) + "|" + this.getSvalue(var452, 5) + "|" + var484 + "|";
                                    var364[var256] = 90;
                                    var335[++var256] = "";
                                    var364[var256] = 167;
                                    var256++;
                                 }

                                 if (var468 == 10) {
                                    String var486 = "";
                                    if (var457.toLowerCase().equals(this.xt.clan.toLowerCase())) {
                                       var335[var256] = "Your clan has defeated " + this.intclan + " in the stage battle, congratulations!";
                                       var397[var256] = this.getLvalue(var452, 3);
                                       var415[var256] = "";
                                       var256++;
                                       String var493 = this.getSvalue(var452, 5);
                                       if (var493.length() > 20) {
                                          var493 = "" + var493.substring(0, 20) + "...";
                                       }

                                       var335[var256] = "You took " + this.intclan + "'s stage :  [ " + var493 + " ] !";
                                       var364[var256] = -1;
                                       var256++;
                                       var486 = this.xt.clan;
                                    } else {
                                       var335[var256] = "Your clan has lost the stage battle against " + this.intclan + ".";
                                       var397[var256] = this.getLvalue(var452, 3);
                                       var415[var256] = "";
                                       var256++;
                                       String var494 = this.getSvalue(var452, 5);
                                       if (var494.length() > 20) {
                                          var494 = "" + var494.substring(0, 20) + "...";
                                       }

                                       var335[var256] = "" + this.intclan + " took your stage :  [ " + var494 + " ] !";
                                       var364[var256] = -1;
                                       var256++;
                                       var486 = this.intclan;
                                    }

                                    var335[var256] = "" + this.getSvalue(var452, 4) + "|" + this.getSvalue(var452, 5) + "|" + var486 + "|";
                                    var364[var256] = 100;
                                    var335[++var256] = "";
                                    var364[var256] = 167;
                                    var256++;
                                 }
                              } else {
                                 var335[var256] = var452;

                                 try {
                                    this.rd.setFont(new Font("Tahoma", 0, 11));
                                    this.ftm = this.rd.getFontMetrics();
                                    int var456 = 0;

                                    String var467;
                                    for (var467 = ""; var456 < var452.length(); var456++) {
                                       var467 = var467 + var452.charAt(var456);
                                       if (this.ftm.stringWidth(var467) > 540) {
                                          if (var467.lastIndexOf(" ") != -1) {
                                             var335[var256] = var467.substring(0, var467.lastIndexOf(" "));
                                             var467 = var467.substring(var467.lastIndexOf(" ") + 1, var467.length());
                                          } else {
                                             var335[var256] = var467;
                                             var467 = "";
                                          }

                                          var364[var256] = -1;
                                          var256++;
                                       }
                                    }

                                    var335[var256] = var467;
                                 } catch (Exception var79) {
                                 }

                                 var364[var256] = -1;
                                 var256++;
                              }
                           }

                           for (int var458 = 0; var458 < var256; var458++) {
                              this.iline[var458] = var335[var458];
                              this.ilinetyp[var458] = var364[var458];
                              this.ictimes[var458] = var397[var458];
                              this.itimes[var458] = var415[var458];
                           }

                           this.nil = var256;
                           this.readint = 2;
                           this.lastint = "" + this.ictime[var189];
                           if (this.icheck[var189].toLowerCase().indexOf(this.xt.nickname.toLowerCase()) == -1) {
                              this.icheck[var189] = this.icheck[var189] + "#" + this.xt.nickname + "#";

                              try {
                                 this.dout.println("101|41|" + this.xt.nickname + "|" + this.xt.clan + "|" + this.intclan + "|");
                                 var2 = this.din.readLine();
                              } catch (Exception var54) {
                              }
                           }

                           this.spos4 = 208;
                        }
                     } catch (Exception var80) {
                        this.readint = 4;
                     }
                  }

                  if (this.readint == 2) {
                     for (int var303 = 0; var303 < this.nil; var303++) {
                        if (this.ilinetyp[var303] >= 0 && this.ilinetyp[var303] != 167 && this.ictimes[var303] > 0L) {
                           try {
                              long var336 = this.ntime - this.ictimes[var303];
                              if (var336 >= 1000L && var336 < 60000L) {
                                 this.itimes[var303] = "seconds ago";
                              }

                              if (var336 >= 60000L && var336 < 3600000L) {
                                 int var398 = (int)(var336 / 60000L);
                                 String var416 = "s";
                                 if (var398 == 1) {
                                    var416 = "";
                                 }

                                 this.itimes[var303] = "" + var398 + " minute" + var416 + " ago";
                              }

                              if (var336 >= 3600000L && var336 < 86400000L) {
                                 int var399 = (int)(var336 / 3600000L);
                                 String var417 = "s";
                                 if (var399 == 1) {
                                    var417 = "";
                                 }

                                 this.itimes[var303] = "" + var399 + " hour" + var417 + " ago";
                              }

                              if (var336 >= 86400000L) {
                                 int var400 = (int)(var336 / 86400000L);
                                 String var418 = "s";
                                 if (var400 == 1) {
                                    var418 = "";
                                 }

                                 this.itimes[var303] = "" + var400 + " day" + var418 + " ago";
                              }
                           } catch (Exception var53) {
                              this.itimes[var303] = "";
                           }
                        } else {
                           this.itimes[var303] = "";
                        }
                     }
                  }

                  this.intclanbgpng(this.intclan);
               }

               if (this.sendint == 2) {
                  this.gs.mmsg.setText(" ");
                  this.sendint = 0;
                  if (this.gs.sendtyp.getSelectedIndex() > 1) {
                     this.gs.sendtyp.select(0);
                  }
               }

               if (this.openi == 10) {
                  if (this.viewgame2 == 1) {
                     this.vwscorex = 0;
                     this.vwscorei = 0;
                     String var159 = "pending_war";
                     if (this.nvgames2 == 2) {
                        var159 = "pending_battle";
                     }

                     if (this.nvgames2 == 9) {
                        var159 = "war";
                     }

                     if (this.nvgames2 == 5) {
                        var159 = "battle";
                     }

                     try {
                        URL var190 = new URL("http://multiplayer.needformadness.com/interact/" + var159 + "/" + this.viewwar2 + ".txt");
                        var190.openConnection().setConnectTimeout(2000);
                        String var304 = var190.openConnection().getContentType();
                        if (var304.equals("text/plain")) {
                           DataInputStream var337 = new DataInputStream(var190.openStream());
                           String var365 = "";

                           int var401;
                           for (var401 = 0; (var365 = var337.readLine()) != null && var401 < this.nvgames2; var401++) {
                              String var419 = this.getSvalue(var365, 0);
                              if (var419.startsWith("#")) {
                                 int var432 = 1;

                                 try {
                                    var432 = Integer.valueOf(var419.substring(1));
                                 } catch (Exception var52) {
                                    var432 = 1;
                                 }

                                 var419 = "NFM 1  -  Stage " + var432 + "";
                                 if (var432 > 10) {
                                    var419 = "NFM 2  -  Stage " + (var432 - 10) + "";
                                 }

                                 if (var432 > 27) {
                                    var419 = "NFM Multiplayer  -  Stage " + (var432 - 27) + "";
                                 }
                              }

                              this.vwstages2[var401] = var419;
                              this.vwlaps2[var401] = this.getvalue(var365, 1);
                              this.vwcars2[var401] = this.getvalue(var365, 2);
                              this.vwclass2[var401] = this.getvalue(var365, 3);
                              this.vwfix2[var401] = this.getvalue(var365, 4);
                              this.vwinner[var401] = this.getSvalue(var365, 5);
                              if (this.vwinner[var401].toLowerCase().equals(this.xt.clan.toLowerCase())) {
                                 this.vwscorex++;
                              }

                              if (this.vwinner[var401].toLowerCase().equals(this.intclan.toLowerCase())) {
                                 this.vwscorei++;
                              }
                           }

                           var337.close();
                           if (var401 != 0) {
                              this.viewgame2 = 2;
                           } else {
                              this.viewgame2 = 4;
                           }
                        } else {
                           this.viewgame2 = 3;
                        }
                     } catch (Exception var78) {
                        this.viewgame2 = 4;
                     }
                  }

                  if ((
                        this.gs.sendtyp.getSelectedIndex() == 4
                           || this.gs.sendtyp.getSelectedIndex() == 5
                           || this.gs.sendtyp.getSelectedIndex() == 6
                           || this.gs.sendtyp.getSelectedIndex() == 7
                     )
                     && this.gs.senditem.getSelectedIndex() == 3
                     && this.isel == 3) {
                     this.loadiclanstages(this.xt.clan);
                     this.isel = 4;
                  }

                  if (this.gs.sendtyp.getSelectedIndex() == 3 && this.ifas == 0) {
                     this.loadiclancars(this.intclan);
                     this.ifas = 1;
                  }

                  if (this.gs.sendtyp.getSelectedIndex() == 3 && this.ifas == 2) {
                     this.loadiclancars(this.xt.clan);
                     this.ifas = 3;
                  }

                  if (this.gs.sendtyp.getSelectedIndex() == 3 && this.gs.senditem.getSelectedIndex() == 3 && this.ifas == 5 && this.isel == 3) {
                     this.loadiclanstages(this.xt.clan);
                     this.isel = 4;
                  }

                  if (this.gs.sendtyp.getSelectedIndex() == 2 && this.ifas == 0) {
                     this.loadiclanstages(this.intclan);
                     this.ifas = 1;
                  }

                  if (this.gs.sendtyp.getSelectedIndex() == 2 && this.ifas == 2) {
                     this.loadiclanstages(this.xt.clan);
                     this.ifas = 3;
                  }

                  if (this.gs.sendtyp.getSelectedIndex() == 2 && this.gs.senditem.getSelectedIndex() == 3 && this.ifas == 5 && this.isel == 3) {
                     this.loadiclanstages(this.xt.clan);
                     this.isel = 4;
                  }

                  if (this.sendint == 1) {
                     try {
                        String var160 = "#nada#";

                        for (int var191 = 0; var191 < this.ni; var191++) {
                           if (this.iclan[var191].equals(this.intclan)) {
                              var160 = this.iconvo[var191];
                              break;
                           }
                        }

                        var1 = "101|39|"
                           + this.xt.nickname
                           + "|"
                           + this.xt.nickey
                           + "|"
                           + this.xt.clan
                           + "|"
                           + this.xt.clankey
                           + "|"
                           + this.intclan
                           + "|"
                           + var160
                           + "|"
                           + this.gs.sendtyp.getSelectedIndex()
                           + "|";
                        if (this.gs.sendtyp.getSelectedIndex() == 0) {
                           String var192 = this.gs.mmsg.getText().replace("|", ":");
                           var192 = var192.replaceAll("[\\t\\n\\r]", "|");
                           String var305 = "";
                           int var338 = 0;

                           for (int var367 = 0; var338 < var192.length(); var338++) {
                              String var402 = "" + var192.charAt(var338);
                              if (var402.equals("|")) {
                                 var367++;
                              } else {
                                 var367 = 0;
                              }

                              if (var367 <= 1) {
                                 var305 = var305 + var402;
                              }
                           }

                           var1 = var1 + "" + var305 + "||";
                        }

                        if (this.gs.sendtyp.getSelectedIndex() == 1) {
                           Calendar var194 = Calendar.getInstance();
                           long var306 = var194.getTimeInMillis();
                           var194.roll(5, this.gs.senditem.getSelectedIndex());
                           int var368 = this.gs.datat.getSelectedIndex() + 12;
                           if (var368 >= 24) {
                              var368 -= 24;
                           }

                           var194.set(var194.get(1), var194.get(2), var194.get(5), var368, 0);
                           var306 = var194.getTimeInMillis() - var306;
                           var1 = var1 + "" + var306 + "|";
                        }

                        if (this.gs.sendtyp.getSelectedIndex() == 2 || this.gs.sendtyp.getSelectedIndex() == 3) {
                           var1 = var1 + "" + this.itake + "|" + this.igive + "|";
                           if (!this.sendwarnum) {
                              for (int var195 = 0; var195 < 2; var195++) {
                                 var1 = var1
                                    + ""
                                    + this.wstages[var195]
                                    + "|"
                                    + this.wlaps[var195]
                                    + "|"
                                    + this.wcars[var195]
                                    + "|"
                                    + this.wclass[var195]
                                    + "|"
                                    + this.wfix[var195]
                                    + "|";
                              }
                           } else {
                              var1 = var1 + "warnum#|" + this.warnum + "|";
                              this.sendwarnum = false;
                           }
                        }

                        if (this.gs.sendtyp.getSelectedIndex() == 4) {
                           if (!this.sendwarnum) {
                              for (int var196 = 0; var196 < 4; var196++) {
                                 var1 = var1
                                    + ""
                                    + this.wstages[var196]
                                    + "|"
                                    + this.wlaps[var196]
                                    + "|"
                                    + this.wcars[var196]
                                    + "|"
                                    + this.wclass[var196]
                                    + "|"
                                    + this.wfix[var196]
                                    + "|";
                              }
                           } else {
                              var1 = var1 + "warnum#|" + this.warnum + "|";
                              this.sendwarnum = false;
                           }
                        }

                        if (this.gs.sendtyp.getSelectedIndex() == 5 || this.gs.sendtyp.getSelectedIndex() == 6) {
                           var1 = var1 + "" + this.itake + "|" + this.igive + "|";
                           if (!this.sendwarnum) {
                              var1 = var1 + "" + this.sendwar + "|";

                              for (int var197 = 0; var197 < 3; var197++) {
                                 var1 = var1
                                    + ""
                                    + this.wstages[var197]
                                    + "|"
                                    + this.wlaps[var197]
                                    + "|"
                                    + this.wcars[var197]
                                    + "|"
                                    + this.wclass[var197]
                                    + "|"
                                    + this.wfix[var197]
                                    + "|";
                              }
                           } else {
                              var1 = var1 + "warnum#|" + this.warnum + "|";
                              this.sendwarnum = false;
                           }
                        }

                        if (this.gs.sendtyp.getSelectedIndex() == 7) {
                           if (!this.sendwarnum) {
                              var1 = var1 + "" + this.sendwar + "|";

                              for (int var198 = 0; var198 < 5; var198++) {
                                 var1 = var1
                                    + ""
                                    + this.wstages[var198]
                                    + "|"
                                    + this.wlaps[var198]
                                    + "|"
                                    + this.wcars[var198]
                                    + "|"
                                    + this.wclass[var198]
                                    + "|"
                                    + this.wfix[var198]
                                    + "|";
                              }
                           } else {
                              var1 = var1 + "warnum#|" + this.warnum + "|";
                              this.sendwarnum = false;
                           }
                        }

                        this.dout.println(var1);
                        var2 = this.din.readLine();
                        if (var2.equals("OK")) {
                           this.sendint = 2;
                        } else if (var2.equals("SUJ")) {
                           this.itab = 2;
                           this.sendint = 0;
                           this.openi = 0;
                           this.readint = 0;
                        } else if (var2.equals("failfile")) {
                           this.readint = 6;
                           this.sendint = 0;
                           this.gs.mmsg.setText(" ");
                           this.gs.sendtyp.select(0);
                        } else {
                           this.readint = 5;
                           this.sendint = 0;
                        }
                     } catch (Exception var77) {
                        this.readint = 5;
                        this.sendint = 0;
                     }
                  }
               }
            }

            if (this.itab == 2 && !this.xt.clan.equals("")) {
               try {
                  var1 = "101|36|" + this.xt.clan + "|" + this.xt.clankey + "|" + this.readclan + "|" + this.xt.nickname + "|";
                  this.dout.println(var1);
                  var2 = this.din.readLine();
                  if (var2.startsWith("RECIVE")) {
                     this.readclan = -3;
                     if (this.loadwstat == 0) {
                        this.loadchamps();
                     }

                     int var161 = this.getvalue(var2, 1);
                     this.cadmin = this.getvalue(var2, 2);
                     int var199 = 0;
                     String[] var308 = new String[1000];
                     int[] var339 = new int[1000];
                     long[] var369 = new long[1000];
                     String[] var403 = new String[1000];
                     var308[var199] = "";
                     var339[var199] = 167;
                     var199++;
                     DataInputStream var420 = new DataInputStream(this.socket.getInputStream());
                     byte[] var434 = new byte[var161];
                     var420.readFully(var434);
                     var2 = this.din.readLine();
                     var420 = new DataInputStream(new ByteArrayInputStream(var434));
                     String var442 = "";

                     while ((var442 = var420.readLine()) != null) {
                        if (var442.startsWith("|")) {
                           var308[var199] = "";
                           var339[var199] = 167;
                           var199++;
                           String var449 = this.getSvalue(var442, 1);
                           if (var449.toLowerCase().equals(this.xt.nickname.toLowerCase())) {
                              var449 = "You";
                           }

                           var339[var199] = this.getvalue(var442, 2);
                           int var455 = var339[var199];
                           if (var455 == 0) {
                              var308[var199] = "" + var449 + " wrote:";
                              var369[var199] = this.getLvalue(var442, 3);
                              var403[var199] = "";
                              var199++;
                           }

                           if (var455 == 1) {
                              if (var449.equals("You")) {
                                 var308[var199] = "You have shared the following date:";
                              } else {
                                 var308[var199] = "" + var449 + " has shared the following date:";
                              }

                              var369[var199] = this.getLvalue(var442, 3);
                              var403[var199] = "";
                              Calendar var459 = Calendar.getInstance();
                              long var469 = var459.getTimeInMillis() - (this.ntime - var369[var199]) + this.getLvalue(var442, 4);
                              if (var469 > 0L) {
                                 var459.setTimeInMillis(var469);
                              }

                              var199++;
                              int var495 = var459.get(11);
                              String var500 = "AM";
                              if (var459.get(12) > 30) {
                                 if (++var495 == 24) {
                                    var495 -= 24;
                                 }
                              }

                              if (var495 >= 12) {
                                 var500 = "PM";
                              }

                              if (var495 > 12) {
                                 var495 -= 12;
                              }

                              if (var495 == 0) {
                                 var495 = 12;
                              }

                              try {
                                 var308[var199] = "[  "
                                    + this.wday[var459.get(7) - 1]
                                    + "  -  "
                                    + this.month[var459.get(2)]
                                    + " "
                                    + var459.get(5)
                                    + ",  "
                                    + var495
                                    + " "
                                    + var500
                                    + "  ]";
                              } catch (Exception var51) {
                                 var308[var199] = "Error occurred while calculating this date.";
                              }

                              var339[var199] = -1;
                              var308[++var199] = "(Please make sure your computer's calendar/clock is adjusted correctly, to read this date in your local time.)";
                              var339[var199] = -1;
                              var199++;
                           }

                           if (var455 == 2) {
                              String var460 = this.getSvalue(var442, 4);
                              if (var449.equals("You")) {
                                 var308[var199] = "You have suggested declaring war on [ " + var460 + " ] :";
                              } else {
                                 var308[var199] = "" + var449 + " suggested declaring war on [ " + var460 + " ] :";
                              }

                              var369[var199] = this.getLvalue(var442, 3);
                              var403[var199] = "";
                              var308[++var199] = "" + var460 + "|" + this.getSvalue(var442, 5) + "|" + this.getSvalue(var442, 6) + "|";
                              var339[var199] = 20;
                              var308[++var199] = "";
                              var339[var199] = 167;
                              var199++;
                              if (this.loadwstat == 1 && !var442.endsWith("|out|")) {
                                 int var470 = -1;
                                 int var488 = 0;
                                 int var496 = -1;
                                 int var501 = 0;

                                 for (int var506 = 0; var506 < this.ncc; var506++) {
                                    if (this.xt.clan.toLowerCase().equals(this.conclan[var506].toLowerCase())) {
                                       var488 = this.totp[var506];
                                       var470 = var506;
                                    }

                                    if (var460.toLowerCase().equals(this.conclan[var506].toLowerCase())) {
                                       var501 = this.totp[var506];
                                       var496 = var506;
                                    }
                                 }

                                 int var507 = var501 + 1;
                                 int var521 = var488 + 1;
                                 if (var521 > var501) {
                                    var521 = var501;
                                 }

                                 if (var470 != -1) {
                                    for (int var530 = 0; var530 < this.nvc[var470]; var530++) {
                                       if (var460.toLowerCase().equals(this.verclan[var470][var530].toLowerCase())) {
                                          var507 -= this.points[var470][var530];
                                          if (var507 < 0) {
                                             var507 = 0;
                                          }
                                          break;
                                       }
                                    }
                                 }

                                 var308[var199] = "If you win this war, your clan would get:  [ "
                                    + var507
                                    + " points ]   &  "
                                    + var460
                                    + " would lose:  [ "
                                    + var521
                                    + " points ]";
                                 var339[var199] = -1;
                                 var199++;
                                 var507 = var488 + 1;
                                 var521 = var501 + 1;
                                 if (var521 > var488) {
                                    var521 = var488;
                                 }

                                 if (var496 != -1) {
                                    for (int var531 = 0; var531 < this.nvc[var496]; var531++) {
                                       if (this.xt.clan.toLowerCase().equals(this.verclan[var496][var531].toLowerCase())) {
                                          var507 -= this.points[var496][var531];
                                          if (var507 < 0) {
                                             var507 = 0;
                                          }
                                          break;
                                       }
                                    }
                                 }

                                 var308[var199] = "If you lose this war, your clan would lose:  [ "
                                    + var521
                                    + " points ]   &  "
                                    + var460
                                    + " would get:  [ "
                                    + var507
                                    + " points ]";
                                 var339[var199] = -1;
                                 var199++;
                              }

                              if (!var442.endsWith("|out|")) {
                                 var308[var199] = "(This needs to be approved by the Clan Leader or an Admin to be declared on " + var460 + ".)";
                                 var339[var199] = -1;
                                 var199++;
                              }
                           }

                           if (var455 == 3) {
                              String var461 = this.getSvalue(var442, 4);
                              if (var449.equals("You")) {
                                 var308[var199] = "You have suggested to car battle with [ " + var461 + " ] :";
                              } else {
                                 var308[var199] = "" + var449 + " suggested to car battle with [ " + var461 + " ] :";
                              }

                              var369[var199] = this.getLvalue(var442, 3);
                              var403[var199] = "";
                              var308[++var199] = ""
                                 + var461
                                 + "|"
                                 + this.getSvalue(var442, 5)
                                 + "|"
                                 + this.getSvalue(var442, 6)
                                 + "|"
                                 + this.getSvalue(var442, 7)
                                 + "|"
                                 + this.getSvalue(var442, 8)
                                 + "|";
                              var339[var199] = 30;
                              var308[++var199] = "";
                              var339[var199] = 167;
                              var308[++var199] = "If you win you will take " + var461 + "'s car :  [ " + this.getSvalue(var442, 5) + " ]";
                              var339[var199] = -1;
                              var308[++var199] = "If you lose you will give " + var461 + " your clan's car :  [ " + this.getSvalue(var442, 6) + " ]";
                              var339[var199] = -1;
                              var199++;
                              if (!var442.endsWith("|out|")) {
                                 var308[var199] = "(This needs to be approved by the Clan Leader or an Admin to be sent to " + var461 + ".)";
                                 var339[var199] = -1;
                                 var199++;
                              }
                           }

                           if (var455 == 4) {
                              String var462 = this.getSvalue(var442, 4);
                              if (var449.equals("You")) {
                                 var308[var199] = "You have suggested to stage battle with [ " + var462 + " ] :";
                              } else {
                                 var308[var199] = "" + var449 + " suggested to stage battle with [ " + var462 + " ] :";
                              }

                              var369[var199] = this.getLvalue(var442, 3);
                              var403[var199] = "";
                              var308[++var199] = ""
                                 + var462
                                 + "|"
                                 + this.getSvalue(var442, 5)
                                 + "|"
                                 + this.getSvalue(var442, 6)
                                 + "|"
                                 + this.getSvalue(var442, 7)
                                 + "|"
                                 + this.getSvalue(var442, 8)
                                 + "|";
                              var339[var199] = 40;
                              var308[++var199] = "";
                              var339[var199] = 167;
                              var199++;
                              String var471 = this.getSvalue(var442, 5);
                              if (var471.length() > 20) {
                                 var471 = "" + var471.substring(0, 20) + "...";
                              }

                              var308[var199] = "If you win you will take " + var462 + "'s stage :  [ " + var471 + " ]";
                              var339[var199] = -1;
                              var199++;
                              var471 = this.getSvalue(var442, 6);
                              if (var471.length() > 20) {
                                 var471 = "" + var471.substring(0, 20) + "...";
                              }

                              var308[var199] = "If you lose you will give " + var462 + " your clan's stage :  [ " + var471 + " ]";
                              var339[var199] = -1;
                              var199++;
                              if (!var442.endsWith("|out|")) {
                                 var308[var199] = "(This needs to be approved by the Clan Leader or an Admin to be sent to " + var462 + ".)";
                                 var339[var199] = -1;
                                 var199++;
                              }
                           }

                           if (var455 == 5) {
                              String var463 = this.getSvalue(var442, 4);
                              if (var449.equals("You")) {
                                 var308[var199] = "You have suggested accepting to go to war with [ " + var463 + " ] :";
                              } else {
                                 var308[var199] = "" + var449 + " suggested accepting to go to war with [ " + var463 + " ] :";
                              }

                              var369[var199] = this.getLvalue(var442, 3);
                              var403[var199] = "";
                              var308[++var199] = "" + var463 + "|" + this.getSvalue(var442, 5) + "|" + this.getSvalue(var442, 6) + "|";
                              var339[var199] = 50;
                              var308[++var199] = "";
                              var339[var199] = 167;
                              var199++;
                              if (this.loadwstat == 1 && !var442.endsWith("|out|")) {
                                 int var473 = -1;
                                 int var489 = 0;
                                 int var497 = -1;
                                 int var502 = 0;

                                 for (int var509 = 0; var509 < this.ncc; var509++) {
                                    if (this.xt.clan.toLowerCase().equals(this.conclan[var509].toLowerCase())) {
                                       var489 = this.totp[var509];
                                       var473 = var509;
                                    }

                                    if (var463.toLowerCase().equals(this.conclan[var509].toLowerCase())) {
                                       var502 = this.totp[var509];
                                       var497 = var509;
                                    }
                                 }

                                 int var510 = var502 + 1;
                                 int var523 = var489 + 1;
                                 if (var523 > var502) {
                                    var523 = var502;
                                 }

                                 if (var473 != -1) {
                                    for (int var532 = 0; var532 < this.nvc[var473]; var532++) {
                                       if (var463.toLowerCase().equals(this.verclan[var473][var532].toLowerCase())) {
                                          var510 -= this.points[var473][var532];
                                          if (var510 < 0) {
                                             var510 = 0;
                                          }
                                          break;
                                       }
                                    }
                                 }

                                 var308[var199] = "If you win this war, your clan would get:  [ "
                                    + var510
                                    + " points ]   &  "
                                    + var463
                                    + " would lose:  [ "
                                    + var523
                                    + " points ]";
                                 var339[var199] = -1;
                                 var199++;
                                 var510 = var489 + 1;
                                 var523 = var502 + 1;
                                 if (var523 > var489) {
                                    var523 = var489;
                                 }

                                 if (var497 != -1) {
                                    for (int var533 = 0; var533 < this.nvc[var497]; var533++) {
                                       if (this.xt.clan.toLowerCase().equals(this.verclan[var497][var533].toLowerCase())) {
                                          var510 -= this.points[var497][var533];
                                          if (var510 < 0) {
                                             var510 = 0;
                                          }
                                          break;
                                       }
                                    }
                                 }

                                 var308[var199] = "If you lose this war, your clan would lose:  [ "
                                    + var523
                                    + " points ]   &  "
                                    + var463
                                    + " would get:  [ "
                                    + var510
                                    + " points ]";
                                 var339[var199] = -1;
                                 var199++;
                              }

                              if (!var442.endsWith("|out|")) {
                                 var308[var199] = "(This needs to be approved by the Clan Leader or an Admin to be declared on " + var463 + ".)";
                                 var339[var199] = -1;
                                 var199++;
                              }
                           }

                           if (var455 == 6) {
                              String var464 = this.getSvalue(var442, 4);
                              if (var449.equals("You")) {
                                 var308[var199] = "You have suggested accepting to car battle with [ " + var464 + " ] :";
                              } else {
                                 var308[var199] = "" + var449 + " suggested accepting to car battle with [ " + var464 + " ] :";
                              }

                              var369[var199] = this.getLvalue(var442, 3);
                              var403[var199] = "";
                              var308[++var199] = ""
                                 + var464
                                 + "|"
                                 + this.getSvalue(var442, 5)
                                 + "|"
                                 + this.getSvalue(var442, 6)
                                 + "|"
                                 + this.getSvalue(var442, 7)
                                 + "|"
                                 + this.getSvalue(var442, 8)
                                 + "|";
                              var339[var199] = 60;
                              var308[++var199] = "";
                              var339[var199] = 167;
                              var308[++var199] = "If you win you will take " + var464 + "'s car :  [ " + this.getSvalue(var442, 5) + " ]";
                              var339[var199] = -1;
                              var308[++var199] = "If you lose you will give " + var464 + " your clan's car :  [ " + this.getSvalue(var442, 6) + " ]";
                              var339[var199] = -1;
                              var199++;
                              if (!var442.endsWith("|out|")) {
                                 var308[var199] = "(This needs to be approved by the Clan Leader or an Admin to be sent to " + var464 + ".)";
                                 var339[var199] = -1;
                                 var199++;
                              }
                           }

                           if (var455 == 7) {
                              String var465 = this.getSvalue(var442, 4);
                              if (var449.equals("You")) {
                                 var308[var199] = "You have suggested accepting to stage battle with [ " + var465 + " ] :";
                              } else {
                                 var308[var199] = "" + var449 + " suggested accepting to stage battle with [ " + var465 + " ] :";
                              }

                              var369[var199] = this.getLvalue(var442, 3);
                              var403[var199] = "";
                              var308[++var199] = ""
                                 + var465
                                 + "|"
                                 + this.getSvalue(var442, 5)
                                 + "|"
                                 + this.getSvalue(var442, 6)
                                 + "|"
                                 + this.getSvalue(var442, 7)
                                 + "|"
                                 + this.getSvalue(var442, 8)
                                 + "|";
                              var339[var199] = 70;
                              var308[++var199] = "";
                              var339[var199] = 167;
                              var199++;
                              String var474 = this.getSvalue(var442, 5);
                              if (var474.length() > 20) {
                                 var474 = "" + var474.substring(0, 20) + "...";
                              }

                              var308[var199] = "If you win you will take " + var465 + "'s stage :  [ " + var474 + " ]";
                              var339[var199] = -1;
                              var199++;
                              var474 = this.getSvalue(var442, 6);
                              if (var474.length() > 20) {
                                 var474 = "" + var474.substring(0, 20) + "...";
                              }

                              var308[var199] = "If you lose you will give " + var465 + " your clan's stage :  [ " + var474 + " ]";
                              var339[var199] = -1;
                              var199++;
                              if (!var442.endsWith("|out|")) {
                                 var308[var199] = "(This needs to be approved by the Clan Leader or an Admin to be sent to " + var465 + ".)";
                                 var339[var199] = -1;
                                 var199++;
                              }
                           }

                           if (var455 == 8) {
                              int var466 = this.getvalue(var442, 4);
                              String var476 = "taken";
                              if (var466 == 2) {
                                 var476 = "re-claimed";
                              }

                              var308[var199] = "Congratulations!!  Your clan has " + var476 + " the clan wars world championship title!";
                              var369[var199] = this.getLvalue(var442, 3);
                              var403[var199] = "";
                              var199++;
                              if (var466 == 1) {
                                 var308[var199] = "Your recent win in the war against " + this.getSvalue(var442, 6) + " has given you the championship title!";
                                 var339[var199] = -1;
                                 var199++;
                              }

                              if (var466 == 2) {
                                 var308[var199] = "You have successfully defended your championship title against " + this.getSvalue(var442, 6) + "!";
                                 var339[var199] = -1;
                                 var199++;
                              }

                              if (var466 == 3) {
                                 var308[var199] = "A recent war between "
                                    + this.getSvalue(var442, 5)
                                    + " and "
                                    + this.getSvalue(var442, 6)
                                    + " has resulted in a change of points!";
                                 var339[var199] = -1;
                                 var199++;
                              }

                              if (var466 == 4) {
                                 var308[var199] = "Clan "
                                    + this.getSvalue(var442, 5)
                                    + " removed itself from the game which resulted in a change of points, giving you the title!";
                                 var339[var199] = -1;
                                 var199++;
                              }

                              if (var466 != 2) {
                                 var308[var199] = "" + this.xt.clan + " is now the new champion of the world in Need for Madness!";
                                 var339[var199] = -1;
                                 var199++;
                              } else {
                                 var308[var199] = "" + this.xt.clan + " still remains the champion of the world in Need for Madness!";
                                 var339[var199] = -1;
                                 var199++;
                              }

                              var339[var199] = 80;
                              var308[++var199] = "";
                              var339[var199] = 167;
                              var199++;
                           }
                        } else {
                           var308[var199] = var442;

                           try {
                              this.rd.setFont(new Font("Tahoma", 0, 11));
                              this.ftm = this.rd.getFontMetrics();
                              int var448 = 0;

                              String var454;
                              for (var454 = ""; var448 < var442.length(); var448++) {
                                 var454 = var454 + var442.charAt(var448);
                                 if (this.ftm.stringWidth(var454) > 540) {
                                    if (var454.lastIndexOf(" ") != -1) {
                                       var308[var199] = var454.substring(0, var454.lastIndexOf(" "));
                                       var454 = var454.substring(var454.lastIndexOf(" ") + 1, var454.length());
                                    } else {
                                       var308[var199] = var454;
                                       var454 = "";
                                    }

                                    var339[var199] = -1;
                                    var199++;
                                 }
                              }

                              var308[var199] = var454;
                           } catch (Exception var75) {
                           }

                           var339[var199] = -1;
                           var199++;
                        }
                     }

                     for (int var450 = 0; var450 < var199; var450++) {
                        this.cmline[var450] = var308[var450];
                        this.cmlinetyp[var450] = var339[var450];
                        this.cmctimes[var450] = var369[var450];
                        this.cmtimes[var450] = var403[var450];
                     }

                     this.cnml = var199;
                     this.readclan = var161;
                     this.spos3 = 219;
                  }
               } catch (Exception var76) {
                  this.readclan = -1;
               }

               if (this.readclan > 0) {
                  for (int var162 = 0; var162 < this.cnml; var162++) {
                     if (this.cmlinetyp[var162] >= 0 && this.cmlinetyp[var162] != 167 && this.cmctimes[var162] > 0L) {
                        try {
                           long var228 = this.ntime - this.cmctimes[var162];
                           if (var228 >= 1000L && var228 < 60000L) {
                              this.cmtimes[var162] = "seconds ago";
                           }

                           if (var228 >= 60000L && var228 < 3600000L) {
                              int var340 = (int)(var228 / 60000L);
                              String var370 = "s";
                              if (var340 == 1) {
                                 var370 = "";
                              }

                              this.cmtimes[var162] = "" + var340 + " minute" + var370 + " ago";
                           }

                           if (var228 >= 3600000L && var228 < 86400000L) {
                              int var341 = (int)(var228 / 3600000L);
                              String var371 = "s";
                              if (var341 == 1) {
                                 var371 = "";
                              }

                              this.cmtimes[var162] = "" + var341 + " hour" + var371 + " ago";
                           }

                           if (var228 >= 86400000L) {
                              int var342 = (int)(var228 / 86400000L);
                              String var372 = "s";
                              if (var342 == 1) {
                                 var372 = "";
                              }

                              this.cmtimes[var162] = "" + var342 + " day" + var372 + " ago";
                           }
                        } catch (Exception var50) {
                           this.cmtimes[var162] = "";
                        }
                     } else {
                        this.cmtimes[var162] = "";
                     }
                  }
               }

               this.clanlogopng(this.xt.clan);
               if (this.sendcmsg == 2) {
                  this.gs.mmsg.setText(" ");
                  this.sendcmsg = 0;
               }

               if (this.viewgame1 == 1) {
                  try {
                     String var163 = "pending_war";
                     if (this.nvgames1 == 2 || this.nvgames1 == 5) {
                        var163 = "pending_battle";
                     }

                     URL var229 = new URL("http://multiplayer.needformadness.com/interact/" + var163 + "/" + this.viewwar1 + ".txt");
                     var229.openConnection().setConnectTimeout(2000);
                     String var309 = var229.openConnection().getContentType();
                     if (!var309.equals("text/plain")) {
                        this.viewgame1 = 3;
                     } else {
                        DataInputStream var343 = new DataInputStream(var229.openStream());
                        String var373 = "";

                        int var404;
                        for (var404 = 0; (var373 = var343.readLine()) != null && var404 < this.nvgames1; var404++) {
                           String var422 = this.getSvalue(var373, 0);
                           if (var422.startsWith("#")) {
                              int var435 = 1;

                              try {
                                 var435 = Integer.valueOf(var422.substring(1));
                              } catch (Exception var49) {
                                 var435 = 1;
                              }

                              var422 = "NFM 1  -  Stage " + var435 + "";
                              if (var435 > 10) {
                                 var422 = "NFM 2  -  Stage " + (var435 - 10) + "";
                              }

                              if (var435 > 27) {
                                 var422 = "NFM Multiplayer  -  Stage " + (var435 - 27) + "";
                              }
                           }

                           this.vwstages1[var404] = var422;
                           this.vwlaps1[var404] = this.getvalue(var373, 1);
                           this.vwcars1[var404] = this.getvalue(var373, 2);
                           this.vwclass1[var404] = this.getvalue(var373, 3);
                           this.vwfix1[var404] = this.getvalue(var373, 4);
                        }

                        var343.close();
                        if (var404 != 0) {
                           this.viewgame1 = 2;
                        } else {
                           this.viewgame1 = 4;
                        }
                     }
                  } catch (Exception var74) {
                     this.viewgame1 = 4;
                  }
               }

               if (this.sendcmsg == 1) {
                  try {
                     var1 = "101|37|"
                        + this.xt.nickname
                        + "|"
                        + this.xt.nickey
                        + "|"
                        + this.xt.clan
                        + "|"
                        + this.xt.clankey
                        + "|"
                        + this.gs.sendtyp.getSelectedIndex()
                        + "|";
                     if (this.gs.sendtyp.getSelectedIndex() == 0) {
                        String var164 = this.gs.mmsg.getText().replace("|", ":");
                        var164 = var164.replaceAll("[\\t\\n\\r]", "|");
                        String var230 = "";
                        int var310 = 0;

                        for (int var344 = 0; var310 < var164.length(); var310++) {
                           String var375 = "" + var164.charAt(var310);
                           if (var375.equals("|")) {
                              var344++;
                           } else {
                              var344 = 0;
                           }

                           if (var344 <= 1) {
                              var230 = var230 + var375;
                           }
                        }

                        var1 = var1 + "" + var230 + "||";
                     }

                     if (this.gs.sendtyp.getSelectedIndex() == 1) {
                        Calendar var166 = Calendar.getInstance();
                        long var231 = var166.getTimeInMillis();
                        var166.roll(5, this.gs.senditem.getSelectedIndex());
                        int var345 = this.gs.datat.getSelectedIndex() + 12;
                        if (var345 >= 24) {
                           var345 -= 24;
                        }

                        var166.set(var166.get(1), var166.get(2), var166.get(5), var345, 0);
                        var231 = var166.getTimeInMillis() - var231;
                        var1 = var1 + "" + var231 + "|";
                     }

                     this.dout.println(var1);
                     var2 = this.din.readLine();
                     if (var2.equals("OK")) {
                        this.sendcmsg = 2;
                     } else {
                        this.readclan = -2;
                        this.sendcmsg = 0;
                     }
                  } catch (Exception var73) {
                     this.readclan = -2;
                     this.sendcmsg = 0;
                  }
               }

               this.loadmyclanbg();
            }
         }

         if (this.lg.nmsgs != 0 || this.lg.nfreq != 0 || this.lg.nconf != 0 || this.lg.ncreq != 0 || !this.lg.clanapv.equals("")) {
            var1 = "101|19|" + this.xt.nickname + "|" + this.xt.nickey + "|";

            try {
               this.dout.println(var1);
               var2 = this.din.readLine();
            } catch (Exception var48) {
            }

            this.lg.nmsgs = 0;
            this.lg.nfreq = 0;
            this.lg.nconf = 0;
            this.lg.ncreq = 0;
            this.lg.clanapv = "";
         }

         if (this.tab == 0 && this.domon) {
            var1 = "101|101|" + this.updatec + "|";
            if (this.updatec <= -11) {
               for (int var167 = 0; var167 < -this.updatec - 10; var167++) {
                  var1 = var1 + "" + this.cnames[20 - var167] + "|" + this.sentn[20 - var167] + "|";
               }

               this.updatec = -2;
            }

            try {
               this.dout.println(var1);
               var2 = this.din.readLine();
               if (var2 == null) {
                  this.domon = false;
               }
            } catch (Exception var47) {
               this.domon = false;
            }

            if (this.domon) {
               int var168 = this.getvalue(var2, 0);
               if (this.updatec != var168 && this.updatec >= -2) {
                  for (int var233 = 0; var233 < 21; var233++) {
                     this.cnames[var233] = this.getSvalue(var2, 1 + var233 * 3);
                     this.sentn[var233] = this.getSvalue(var2, 2 + var233 * 3);
                     this.nctime[var233] = this.getLvalue(var2, 3 + var233 * 3);
                  }

                  this.updatec = var168;
               }

               for (int var234 = 0; var234 < 21; var234++) {
                  if (this.nctime[var234] > 0L) {
                     long var311 = this.ntime - this.nctime[var234];
                     if (var311 < 1000L) {
                        this.ctime[var234] = "- just now";
                     }

                     if (var311 >= 1000L && var311 < 60000L) {
                        this.ctime[var234] = "- seconds ago";
                     }

                     if (var311 >= 60000L && var311 < 3600000L) {
                        int var376 = (int)(var311 / 60000L);
                        String var405 = "s";
                        if (var376 == 1) {
                           var405 = "";
                        }

                        this.ctime[var234] = "- " + var376 + " minute" + var405 + " ago";
                     }

                     if (var311 >= 3600000L && var311 < 86400000L) {
                        int var377 = (int)(var311 / 3600000L);
                        String var406 = "s";
                        if (var377 == 1) {
                           var406 = "";
                        }

                        this.ctime[var234] = "- " + var377 + " hour" + var406 + " ago";
                     }

                     if (var311 >= 86400000L) {
                        int var378 = (int)(var311 / 86400000L);
                        String var407 = "s";
                        if (var378 == 1) {
                           var407 = "";
                        }

                        this.ctime[var234] = "- " + var378 + " day" + var407 + " ago";
                     }
                  } else {
                     this.ctime[var234] = "";
                  }
               }
            }
         }

         if (this.tab == 1) {
            if (this.upload == 5) {
               this.upload = 0;
               this.loadedp = false;
               this.edit = 0;
               this.refresh = true;
            }

            if (!this.loadedp) {
               if (!this.refresh) {
                  this.loadproinfo();
                  this.trunsent();
               }

               this.logopng();
               this.avatarpng();
               this.clanlogopng(this.proclan);
               this.refresh = false;
               this.protab = 0;
               this.loadedp = true;
            }

            if (this.protab == 2) {
               if (this.loadpst == 0) {
                  this.loadprostages();
               }

               if (this.loadpst == 1 && !this.gs.proitem.getSelectedItem().equals(this.loadpstage) && this.gs.proitem.sel != 0) {
                  this.addstage = 0;
                  if (this.gs.loadstagePreview(-2, this.gs.proitem.getSelectedItem(), this.co, this.bco, this.m, this.cp)) {
                     this.loadedpstage = true;
                     this.m.hit = 20000;
                     this.m.fallen = 0;
                  } else {
                     this.loadedpstage = false;
                  }

                  this.loadpstage = this.gs.proitem.getSelectedItem();
               }
            }
         }

         if (this.ptab == 2 && !this.xt.clan.equals("") && !this.loadedcm) {
            this.loadfclan();
            this.loadedcm = true;
         }

         if (this.tab == 3) {
            if (this.cfase == 0) {
               if (!this.xt.clan.equals("")) {
                  this.clanlogopng(this.xt.clan);
               }

               if (this.ntab == 0 && this.loadednews == 0) {
                  this.loadnews();
               }

               if (this.ntab == 1 && this.loadwstat == 0) {
                  this.loadchamps();
               }
            }

            if (this.cfase == 1 && this.em == 1) {
               String var169 = this.gs.temail.getText();
               var1 = "101|26|" + this.gs.tnick.getText() + "|" + this.gs.tpass.getText() + "|" + var169 + "|";

               try {
                  this.dout.println(var1);
                  var2 = this.din.readLine();
               } catch (Exception var46) {
                  var2 = "fail";
               }

               if (var2.startsWith("OK")) {
                  this.xt.clan = var169;
                  this.xt.clankey = this.getSvalue(var2, 1);
                  this.spos5 = 0;
                  this.lspos5 = 0;
                  this.cfase = 3;
                  this.claname = var169;
                  this.loadedc = false;
                  this.ctab = 0;
                  this.em = 0;
               } else if (var2.equals("FOUND")) {
                  this.msg = "The name '" + var169 + "' is already used by another clan!";
                  this.flko = 45;
                  this.em = 0;
               } else {
                  this.msg = "Server error authorizing clan creation, please try again later...";
                  this.flko = 45;
                  this.em = 0;
               }
            }

            if (this.cfase == 2) {
               if (this.em == 1) {
                  var1 = "101|27|";

                  try {
                     this.dout.println(var1);
                     var2 = this.din.readLine();
                  } catch (Exception var45) {
                     var2 = "";
                  }

                  this.nclns = 0;

                  for (String var170 = this.getSvalue(var2, this.nclns); !var170.equals("") && this.nclns < 20; var170 = this.getSvalue(var2, this.nclns)) {
                     this.clanlo[this.nclns] = var170;
                     this.nclns++;
                  }

                  if (this.nclns != 0) {
                     this.smsg = "Clans with recent activity:";
                  } else {
                     this.smsg = "Found no clans with recent activity.";
                  }

                  this.em = 0;
               }

               if (this.em == 2) {
                  var1 = "101|28|" + this.gs.temail.getText() + "";

                  try {
                     this.dout.println(var1);
                     var2 = this.din.readLine();
                  } catch (Exception var44) {
                     var2 = "";
                  }

                  this.nclns = 0;

                  for (String var171 = this.getSvalue(var2, this.nclns); !var171.equals("") && this.nclns < 20; var171 = this.getSvalue(var2, this.nclns)) {
                     this.clanlo[this.nclns] = var171;
                     this.nclns++;
                  }

                  if (this.nclns != 0) {
                     this.smsg = "Search result for '" + this.gs.temail.getText() + "' in clans:";
                  } else {
                     this.smsg = "Found no clans with the phrase '" + this.gs.temail.getText() + "' in them.";
                  }

                  this.em = 0;
               }
            }

            if (this.cfase == 3) {
               if (this.editc == 33) {
                  var1 = "101|24|"
                     + this.gs.tnick.getText()
                     + "|"
                     + this.gs.tpass.getText()
                     + "|"
                     + this.claname
                     + "|"
                     + this.member[this.em]
                     + "|"
                     + (this.gs.clanlev.getSelectedIndex() + 1)
                     + "|"
                     + this.gs.cmsg.getText()
                     + "|";

                  try {
                     this.dout.println(var1);
                     var2 = this.din.readLine();
                  } catch (Exception var43) {
                     var2 = "fail";
                  }

                  if (var2.equals("OK")) {
                     this.editc = 0;
                     this.loadedc = false;
                  } else {
                     this.editc = 5;
                  }
               }

               if (this.editc == 66) {
                  var1 = "101|24|"
                     + this.gs.tnick.getText()
                     + "|"
                     + this.gs.tpass.getText()
                     + "|"
                     + this.claname
                     + "|"
                     + this.rmember[this.em]
                     + "|1|New member - just approved.|";

                  try {
                     this.dout.println(var1);
                     var2 = this.din.readLine();
                  } catch (Exception var42) {
                     var2 = "fail";
                  }

                  if (var2.equals("OK")) {
                     this.editc = 0;
                     if (this.nrmb == 1) {
                        this.spos5 = 0;
                        this.lspos5 = 0;
                     }

                     this.loadedc = false;
                  } else {
                     this.editc = 5;
                  }
               }

               if (this.editc == 44) {
                  var1 = "101|25|" + this.gs.tnick.getText() + "|" + this.gs.tpass.getText() + "|" + this.claname + "|" + this.member[this.em] + "|";

                  try {
                     this.dout.println(var1);
                     var2 = this.din.readLine();
                  } catch (Exception var41) {
                     var2 = "fail";
                  }

                  if (var2.equals("OK")) {
                     this.editc = 0;
                     this.loadedc = false;
                     if (this.member[this.em].toLowerCase().equals(this.xt.nickname.toLowerCase())) {
                        if (this.proname.equals(this.xt.nickname)) {
                           this.proclan = "";
                        }

                        this.xt.clan = "";
                        this.xt.clankey = "";
                        if (this.nmb == 1) {
                           this.cfase = 0;
                        }
                     }
                  } else {
                     this.editc = 5;
                  }
               }

               if (this.editc == 77) {
                  var1 = "101|25|" + this.gs.tnick.getText() + "|" + this.gs.tpass.getText() + "|" + this.claname + "|" + this.rmember[this.em] + "|";

                  try {
                     this.dout.println(var1);
                     var2 = this.din.readLine();
                  } catch (Exception var40) {
                     var2 = "fail";
                  }

                  if (var2.equals("OK")) {
                     this.editc = 0;
                     if (this.nrmb == 1) {
                        this.spos5 = 0;
                        this.lspos5 = 0;
                     }

                     this.loadedc = false;
                  } else {
                     this.editc = 5;
                  }
               }

               if (this.editc == 99) {
                  var1 = "101|30|" + this.gs.tnick.getText() + "|" + this.gs.tpass.getText() + "|" + this.claname + "|";

                  try {
                     this.dout.println(var1);
                     var2 = this.din.readLine();
                  } catch (Exception var39) {
                     var2 = "fail";
                  }

                  if (var2.equals("OK")) {
                     this.editc = 0;
                     this.loadedc = false;
                  } else {
                     this.editc = 5;
                  }
               }

               if (this.upload == 5) {
                  this.upload = 0;
                  this.loadedc = false;
                  if (this.editc == 2) {
                     this.loadedmyclanbg = -1;
                  }

                  this.editc = 0;
                  this.refresh = true;
               }

               if (!this.loadedc) {
                  if (!this.refresh) {
                     this.loadclan();
                  }

                  this.clanlogopng(this.claname);
                  this.clanbgpng();
                  this.refresh = false;
                  this.loadedc = true;
               }

               if (this.attachetoclan) {
                  var1 = "101|29|" + this.gs.tnick.getText() + "|" + this.gs.tpass.getText() + "|" + this.claname + "|";

                  try {
                     this.dout.println(var1);
                     var2 = this.din.readLine();
                  } catch (Exception var38) {
                     var2 = "fail";
                  }

                  if (var2.indexOf("|") != -1) {
                     this.xt.clan = this.getSvalue(var2, 0);
                     this.xt.clankey = this.getSvalue(var2, 1);
                  }

                  this.attachetoclan = false;
               }

               if (this.editc == 55) {
                  var1 = "101|31|"
                     + this.gs.tnick.getText()
                     + "|"
                     + this.gs.tpass.getText()
                     + "|"
                     + this.claname
                     + "|"
                     + this.sltit
                     + "|"
                     + this.gs.cmsg.getText()
                     + "|"
                     + this.gs.temail.getText()
                     + "|";

                  try {
                     this.dout.println(var1);
                     var2 = this.din.readLine();
                  } catch (Exception var37) {
                     var2 = "fail";
                  }

                  if (var2.equals("OK")) {
                     this.editc = 0;
                     this.loadedlink = false;
                  } else {
                     this.editc = 5;
                  }
               }

               if (this.ctab == 2) {
                  if (this.loadedcars == 6) {
                     var1 = "101|32|" + this.gs.tnick.getText() + "|" + this.gs.tpass.getText() + "|" + this.claname + "|" + this.selcar + "|";

                     try {
                        this.dout.println(var1);
                        var2 = this.din.readLine();
                     } catch (Exception var36) {
                        var2 = "fail";
                     }

                     if (var2.equals("OK")) {
                        this.loadedcars = -1;
                     } else {
                        this.loadedcars = 7;
                     }
                  }

                  if (this.loadedcars == 8) {
                     var1 = "101|33|" + this.gs.tnick.getText() + "|" + this.gs.tpass.getText() + "|" + this.claname + "|" + this.selcar + "|";

                     try {
                        this.dout.println(var1);
                        var2 = this.din.readLine();
                     } catch (Exception var35) {
                        var2 = "fail";
                     }

                     if (var2.equals("OK")) {
                        this.loadedcars = -1;
                     } else {
                        this.loadedcars = 9;
                     }
                  }

                  if (this.loadedcars == -1) {
                     this.loadedcars = this.loadclancars();
                  }

                  if (this.loadedcars == 1 && !this.selcar.equals("Select Car") && this.loadedcar == 0) {
                     if (this.xt.sc[0] == 36 && !this.xt.clan.toLowerCase().equals(this.claname.toLowerCase())) {
                        this.cd.haltload = 2;
                     } else {
                        this.cd.haltload = 1;
                     }

                     while (this.cd.haltload == this.cd.onloadingcar) {
                     }

                     this.loadedcar = this.cd.loadonlinecar(this.selcar, 35 + this.cd.haltload);
                     if (this.xt.sc[0] == 36 && this.cd.haltload == 1 && this.loadedcar > 0) {
                        boolean var172 = false;

                        for (int var235 = 0; var235 < this.bco[36].npl && !var172; var235++) {
                           if (this.bco[36].p[var235].colnum == 1) {
                              float[] var312 = new float[3];
                              Color.RGBtoHSB(this.bco[36].p[var235].c[0], this.bco[36].p[var235].c[1], this.bco[36].p[var235].c[2], var312);
                              this.xt.arnp[0] = var312[0];
                              this.xt.arnp[1] = var312[1];
                              this.xt.arnp[2] = 1.0F - var312[2];
                              var172 = true;
                           }
                        }

                        var172 = false;

                        for (int var236 = 0; var236 < this.bco[36].npl && !var172; var236++) {
                           if (this.bco[36].p[var236].colnum == 2) {
                              float[] var313 = new float[3];
                              Color.RGBtoHSB(this.bco[36].p[var236].c[0], this.bco[36].p[var236].c[1], this.bco[36].p[var236].c[2], var313);
                              this.xt.arnp[3] = var313[0];
                              this.xt.arnp[4] = var313[1];
                              this.xt.arnp[5] = 1.0F - var313[2];
                              var172 = true;
                           }
                        }
                     }
                  }

                  if (this.loadedcars == 2) {
                     this.loadedcars = this.loadaddcars();
                  }
               }

               if (this.ctab == 3) {
                  if (this.loadedstages == 6) {
                     var1 = "101|34|" + this.gs.tnick.getText() + "|" + this.gs.tpass.getText() + "|" + this.claname + "|" + this.selstage + "|";

                     try {
                        this.dout.println(var1);
                        var2 = this.din.readLine();
                     } catch (Exception var34) {
                        var2 = "fail";
                     }

                     if (var2.equals("OK")) {
                        this.loadedstages = -1;
                     } else {
                        this.loadedstages = 7;
                     }
                  }

                  if (this.loadedstages == 8) {
                     var1 = "101|35|" + this.gs.tnick.getText() + "|" + this.gs.tpass.getText() + "|" + this.claname + "|" + this.selstage + "|";

                     try {
                        this.dout.println(var1);
                        var2 = this.din.readLine();
                     } catch (Exception var33) {
                        var2 = "fail";
                     }

                     if (var2.equals("OK")) {
                        this.loadedstages = -1;
                     } else {
                        this.loadedstages = 9;
                     }
                  }

                  if (this.loadedstages == -1) {
                     this.loadedstages = this.loadclanstages();
                  }

                  if (this.loadedstages == 1 && !this.selstage.equals("Select Stage") && this.loadedstage == 0) {
                     this.cd.t.nt = 0;
                     if (this.gs.loadstagePreview(-2, this.selstage, this.co, this.bco, this.m, this.cp)) {
                        this.loadedstage = 1;
                        this.m.ptr = 0;
                        this.m.ptcnt = -10;
                        this.m.hit = 45000;
                        this.m.fallen = 0;
                        this.m.nrnd = 0;
                     } else {
                        this.loadedstage = -1;
                     }
                  }

                  if (this.loadedstages == 2) {
                     this.loadedstages = this.loadaddstages();
                  }
               }

               if (this.ctab == 4 && !this.loadedlink) {
                  this.loadclanlink();
                  this.loadedlink = true;
               }
            }
         }

         if (this.upload != 0) {
            if (!this.filename.toLowerCase().endsWith(".gif")
               && !this.filename.toLowerCase().endsWith(".jpg")
               && !this.filename.toLowerCase().endsWith(".jpeg")
               && !this.filename.toLowerCase().endsWith(".png")) {
               this.msg = "Uploaded image must be JPEG, GIF or PNG!";
               this.flko = 45;
               this.upload = 0;
            } else {
               File var174 = new File(this.filename);
               if (var174.exists()) {
                  int var237 = (int)var174.length();
                  if (var237 < 1048576) {
                     if (this.upload != 0) {
                        this.upload = 2;

                        try {
                           byte var314 = 2;
                           if (this.tab == 1 && this.edit == 2) {
                              var314 = 3;
                           }

                           String var346 = "";
                           if (this.tab == 3) {
                              if (this.editc == 1) {
                                 var314 = 22;
                              }

                              if (this.editc == 2) {
                                 var314 = 23;
                              }

                              var346 = "" + this.claname + "|";
                           }

                           var1 = "101|" + var314 + "|" + this.gs.tnick.getText() + "|" + this.gs.tpass.getText() + "|" + var237 + "|" + var346 + "";
                           this.dout.println(var1);
                           var2 = this.din.readLine();
                           if (var2.equals("OK")) {
                              FileInputStream var379 = new FileInputStream(var174);
                              byte[] var408 = new byte[var237];
                              var379.read(var408);
                              var379.close();
                              DataOutputStream var423 = new DataOutputStream(this.socket.getOutputStream());
                              if (this.upload != 0) {
                                 this.upload = 3;
                              }

                              this.perc = 0;

                              for (int var437 = 0; var437 < var237 && this.upload != 0; this.perc = (int)((float)var437 / var237 * 100.0F)) {
                                 int var444 = 10240;
                                 if (var437 + var444 > var237) {
                                    var444 = var237 - var437;
                                 }

                                 var423.write(var408, var437, var444);
                                 var437 += var444;
                              }

                              if (this.upload != 0) {
                                 var2 = this.din.readLine();
                                 if (var2.equals("CR")) {
                                    this.upload = 4;
                                 } else {
                                    this.msg = "Failed to create image online, server error!";
                                    this.flko = 45;
                                    this.upload = 0;
                                 }

                                 var2 = this.din.readLine();
                                 if (var2.equals("OK")) {
                                    this.upload = 5;
                                 }
                              } else {
                                 try {
                                    this.socket.close();
                                    this.socket = null;
                                    this.din.close();
                                    this.din = null;
                                    this.dout.close();
                                    this.dout = null;
                                    this.connector = null;
                                 } catch (Exception var32) {
                                 }

                                 try {
                                    this.socket = new Socket(this.lg.servers[0], 7061);
                                    this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                                    this.dout = new PrintWriter(this.socket.getOutputStream(), true);
                                 } catch (Exception var31) {
                                 }
                              }
                           } else {
                              this.msg = "Failed to authenticate to start an uploading connection!";
                              this.flko = 45;
                              this.upload = 0;
                           }
                        } catch (Exception var72) {
                           this.msg = "Failed to upload image, unknown error!";
                           this.flko = 45;
                           this.upload = 0;

                           try {
                              this.socket.close();
                              this.socket = null;
                              this.din.close();
                              this.din = null;
                              this.dout.close();
                              this.dout = null;
                              this.connector = null;
                           } catch (Exception var30) {
                           }

                           try {
                              this.socket = new Socket(this.lg.servers[0], 7061);
                              this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                              this.dout = new PrintWriter(this.socket.getOutputStream(), true);
                           } catch (Exception var29) {
                           }
                        }
                     }
                  } else {
                     this.msg = "Uploaded image must be less than 1MB in size!";
                     this.flko = 45;
                     this.upload = 0;
                  }
               } else {
                  this.msg = "The file chosen is invalid or does not exist!";
                  this.flko = 45;
                  this.upload = 0;
               }
            }
         }

         if (this.uploadt == 5) {
            this.uploadt = 0;
            this.msg = "";
         }

         if (this.uploadt != 0) {
            File var175 = new File(this.filename);
            if (var175.exists()) {
               int var238 = (int)var175.length();
               if (var238 < 716800) {
                  this.xt.strack = new RadicalMod(this.filename, true);
                  if (this.xt.strack.loaded == 2) {
                     this.trackvol = (int)(220.0F / (this.xt.strack.rvol / 3750.0F));
                     this.xt.strack.unload();
                     if (this.uploadt != 0) {
                        this.uploadt = 2;

                        try {
                           var1 = "101|4|"
                              + this.gs.tnick.getText()
                              + "|"
                              + this.gs.tpass.getText()
                              + "|"
                              + this.trackname
                              + "|"
                              + this.trackvol
                              + "|"
                              + var238
                              + "|";
                           this.dout.println(var1);
                           var2 = this.din.readLine();
                           if (var2.equals("OK")) {
                              var2 = this.din.readLine();
                              if (this.uploadt != 0) {
                                 if (var2.equals("UPLOAD")) {
                                    this.uploadt = 3;
                                    FileInputStream var315 = new FileInputStream(var175);
                                    byte[] var347 = new byte[var238];
                                    var315.read(var347);
                                    var315.close();
                                    DataOutputStream var380 = new DataOutputStream(this.socket.getOutputStream());
                                    var380.write(var347, 0, var238);
                                    this.uploadt = 4;
                                    var2 = this.din.readLine();
                                 }

                                 if (var2.equals("FOUND")) {
                                    this.uploadt = 4;
                                    var2 = this.din.readLine();
                                 }

                                 if (var2.equals("OK")) {
                                    this.themesong = this.trackname;
                                    this.uploadt = 5;
                                 } else if (var2.equals("EXIST")) {
                                    this.msg = "Another track with the same name already exists, please rename you file!";
                                    this.flko = 45;
                                    this.uploadt = 0;
                                 } else {
                                    this.msg = "Failed to add MOD Track to your profile, unknown error!";
                                    this.flko = 45;
                                    this.uploadt = 0;
                                 }
                              } else {
                                 try {
                                    this.socket.close();
                                    this.socket = null;
                                    this.din.close();
                                    this.din = null;
                                    this.dout.close();
                                    this.dout = null;
                                    this.connector = null;
                                 } catch (Exception var27) {
                                 }

                                 try {
                                    this.socket = new Socket(this.lg.servers[0], 7061);
                                    this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                                    this.dout = new PrintWriter(this.socket.getOutputStream(), true);
                                 } catch (Exception var26) {
                                 }
                              }
                           } else {
                              this.msg = "Failed to authenticate to start an uploading connection!";
                              this.flko = 45;
                              this.uploadt = 0;
                           }
                        } catch (Exception var28) {
                           this.msg = "Failed to upload track, unknown error!";
                           this.flko = 45;
                           this.uploadt = 0;

                           try {
                              this.socket.close();
                              this.socket = null;
                              this.din.close();
                              this.din = null;
                              this.dout.close();
                              this.dout = null;
                              this.connector = null;
                           } catch (Exception var25) {
                           }

                           try {
                              this.socket = new Socket(this.lg.servers[0], 7061);
                              this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                              this.dout = new PrintWriter(this.socket.getOutputStream(), true);
                           } catch (Exception var24) {
                           }
                        }
                     }
                  } else {
                     this.xt.strack.unload();
                     this.msg = "The file choosen is not a valid MOD Track!";
                     this.flko = 45;
                     this.uploadt = 0;
                  }
               } else {
                  this.msg = "Uploaded file must be less than 250KB in size!";
                  this.flko = 45;
                  this.uploadt = 0;
               }
            } else {
               this.msg = "The file chosen is invalid or does not exist!";
               this.flko = 45;
               this.uploadt = 0;
            }
         }

         if (this.playt == 1) {
            this.xt.strack = new RadicalMod(this.themesong, this.trackvol, 8000, 125, false, true);
            this.xt.strack.play();
            this.playt = 2;
         }

         this.domelogos();

         try {
            Thread.sleep(600L);
         } catch (InterruptedException var23) {
         }
      }

      this.onexit();
   }

   public void onexit() {
      this.onexitpro();
      this.gs.hidefields();
      this.cd.acname = "";
      this.cd.action = 0;
      this.cd.staction = 0;
      this.cd.onstage = "";
      this.addstage = 0;
      this.npf = -1;
      this.editc = 0;
      this.openc = 0;
      this.readmsg = 0;
      this.loadmsgs = -1;
      this.readclan = 0;
      if (this.cd.haltload == 2) {
         this.cd.haltload = 1;
         this.cd.lcardate[1] = 0;
      }

      if (this.cd.haltload == 1) {
         if (this.xt.sc[0] == 36) {
            if (!this.xt.clan.toLowerCase().equals(this.claname.toLowerCase())) {
               this.loadedcars = -1;
            }
         } else {
            this.cd.haltload = 0;
            this.cd.lcardate[0] = 0;
         }
      }

      this.m.crs = true;
      this.m.focus_point = 400;
      this.m.x = -335;
      this.m.y = 0;
      this.m.z = -50;
      this.m.xz = 0;
      this.m.zy = 20;
      this.m.ground = -2000;

      try {
         this.socket.close();
         this.socket = null;
         this.din.close();
         this.din = null;
         this.dout.close();
         this.dout = null;
         this.connector = null;
      } catch (Exception var2) {
      }
   }

   public void onexitpro() {
      this.edit = 0;
      this.upload = 0;
      this.uploadt = 0;
      this.sfreq = 0;
      if (this.playt == 2) {
         this.xt.strack.unload();
         this.playt = 0;
      }

      this.protab = 0;
      this.gs.proitem.show = false;
      this.addstage = 0;
   }

   public void stopallnow() {
      if (this.connector != null) {
         this.connector.stop();
         this.connector = null;
      }

      try {
         this.socket.close();
         this.socket = null;
         this.din.close();
         this.din = null;
         this.dout.close();
         this.dout = null;
         this.connector = null;
      } catch (Exception var2) {
      }
   }

   public void trunsent() {
      for (int var1 = 0; var1 < 3; var1++) {
         this.aboutxt[var1] = "";
      }

      if (!this.sentance.equals("")) {
         this.rd.setFont(new Font("Tahoma", 1, 11));
         this.ftm = this.rd.getFontMetrics();
         int var7 = 0;
         int var2 = 0;
         int var3 = 0;
         int var4 = 0;

         for (boolean var5 = false; var2 < this.sentance.length(); var2++) {
            String var6 = "" + this.sentance.charAt(var2);
            if (var6.equals(" ")) {
               var3 = var2;
            }

            if (var7 < 3) {
               this.aboutxt[var7] = this.aboutxt[var7] + var6;
               if (this.ftm.stringWidth(this.aboutxt[var7]) > 276) {
                  if (var3 != var4) {
                     this.aboutxt[var7] = this.sentance.substring(var4, var3);
                     var2 = var3;
                     var4 = var3;
                  } else if (var7 == 2) {
                     var5 = true;
                  }

                  var7++;
               }
            } else {
               if (var5) {
                  this.aboutxt[2] = this.aboutxt[2].substring(0, this.aboutxt[2].length() - 3);
               }

               this.aboutxt[2] = this.aboutxt[2] + "...";
               var2 = this.sentance.length();
            }
         }
      }

      this.nab = 0;

      for (int var8 = 0; var8 < 3 && !this.aboutxt[var8].equals(""); var8++) {
         this.aboutxt[var8] = this.aboutxt[var8].trim();
         this.nab++;
      }
   }

   public void roomlogos(String[] var1, int var2) {
      for (int var3 = 0; var3 < 2; var3++) {
         boolean var4 = true;
         String var5 = "";

         for (int var6 = 0; var6 < var2; var6++) {
            var4 = false;

            for (int var7 = 0; var7 < this.nlg; var7++) {
               if (var1[var6].toLowerCase().equals(this.logos[var7].toLowerCase())) {
                  var4 = true;
                  break;
               }
            }

            if (!var4) {
               var5 = var1[var6].toLowerCase();
               break;
            }
         }

         if (var4) {
            break;
         }

         this.logos[this.nlg] = var5;
         this.logon[this.nlg] = false;

         try {
            URL var9 = new URL("http://multiplayer.needformadness.com/profiles/" + this.logos[this.nlg] + "/logo.png");
            var9.openConnection().setConnectTimeout(2000);
            String var10 = var9.openConnection().getContentType();
            if (var10.equals("image/png")) {
               this.logoi[this.nlg] = Toolkit.getDefaultToolkit().createImage(var9);
               this.mt.addImage(this.logoi[this.nlg], this.nlg);
               this.logon[this.nlg] = true;
            }
         } catch (Exception var8) {
         }

         this.nlg++;
         if (this.nlg == 200) {
            this.nlg = 0;
         }
      }
   }

   public void domelogos() {
      for (int var1 = 0; var1 < 5; var1++) {
         boolean var2 = true;
         boolean var3 = false;
         String var4 = "";
         String var5 = "";
         if (this.freq == 1) {
            var2 = false;

            for (int var6 = 0; var6 < this.nlg; var6++) {
               if (this.freqname.toLowerCase().equals(this.logos[var6].toLowerCase())) {
                  var2 = true;
                  break;
               }
            }

            if (!var2) {
               var4 = this.freqname.toLowerCase();
            }
         }

         if (var2 && this.loadednews == 1) {
            for (int var10 = 0; var10 < 4; var10++) {
               if (!this.newplayers[var10].equals("")) {
                  var2 = false;

                  for (int var7 = 0; var7 < this.nlg; var7++) {
                     if (this.newplayers[var10].toLowerCase().equals(this.logos[var7].toLowerCase())) {
                        var2 = true;
                        break;
                     }
                  }

                  if (!var2) {
                     var4 = this.newplayers[var10].toLowerCase();
                     break;
                  }
               }
            }
         }

         if (var2 && this.loadednews == 1) {
            for (int var11 = 0; var11 < 5; var11++) {
               if (this.nwarbs[var11] > 0) {
                  var2 = false;
                  String var22 = "#" + this.nwclan[var11] + "#";

                  for (int var8 = 0; var8 < this.nlg; var8++) {
                     if (var22.toLowerCase().equals(this.logos[var8].toLowerCase())) {
                        var2 = true;
                        break;
                     }
                  }

                  if (!var2) {
                     var4 = var22.toLowerCase();
                     var3 = true;
                     var5 = this.nwclan[var11];
                     break;
                  }
               }
            }
         }

         if (var2 && this.loadwstat == 1) {
            for (int var12 = 0; var12 < 5; var12++) {
               if (this.ncc > 0) {
                  var2 = false;
                  String var23 = "#" + this.conclan[var12] + "#";

                  for (int var33 = 0; var33 < this.nlg; var33++) {
                     if (var23.toLowerCase().equals(this.logos[var33].toLowerCase())) {
                        var2 = true;
                        break;
                     }
                  }

                  if (!var2) {
                     var4 = var23.toLowerCase();
                     var3 = true;
                     var5 = this.conclan[var12];
                     break;
                  }
               }
            }
         }

         if (var2 && this.ni > 0) {
            for (int var13 = 0; var13 < this.ni; var13++) {
               var2 = false;
               String var24 = "#" + this.iclan[var13] + "#";

               for (int var34 = 0; var34 < this.nlg; var34++) {
                  if (var24.toLowerCase().equals(this.logos[var34].toLowerCase())) {
                     var2 = true;
                     break;
                  }
               }

               if (!var2) {
                  var4 = var24.toLowerCase();
                  var3 = true;
                  var5 = this.iclan[var13];
                  break;
               }
            }
         }

         if (var2 && this.nclns > 0) {
            for (int var14 = 0; var14 < this.nclns; var14++) {
               var2 = false;
               String var25 = "#" + this.clanlo[var14] + "#";

               for (int var35 = 0; var35 < this.nlg; var35++) {
                  if (var25.toLowerCase().equals(this.logos[var35].toLowerCase())) {
                     var2 = true;
                     break;
                  }
               }

               if (!var2) {
                  var4 = var25.toLowerCase();
                  var3 = true;
                  var5 = this.clanlo[var14];
                  break;
               }
            }
         }

         if (var2 && this.nrmb > 0 && this.showreqs) {
            for (int var15 = 0; var15 < this.nrmb; var15++) {
               var2 = false;

               for (int var26 = 0; var26 < this.nlg; var26++) {
                  if (this.rmember[var15].toLowerCase().equals(this.logos[var26].toLowerCase())) {
                     var2 = true;
                     break;
                  }
               }

               if (!var2) {
                  var4 = this.rmember[var15].toLowerCase();
                  break;
               }
            }
         }

         if (var2 && this.nmb > 0) {
            for (int var16 = 0; var16 < this.nmb; var16++) {
               var2 = false;

               for (int var27 = 0; var27 < this.nlg; var27++) {
                  if (this.member[var16].toLowerCase().equals(this.logos[var27].toLowerCase())) {
                     var2 = true;
                     break;
                  }
               }

               if (!var2) {
                  var4 = this.member[var16].toLowerCase();
                  break;
               }
            }
         }

         if (var2 && this.nclns > 0) {
            for (int var17 = 0; var17 < this.ncln; var17++) {
               var2 = false;

               for (int var28 = 0; var28 < this.nlg; var28++) {
                  if (this.clname[var17].toLowerCase().equals(this.logos[var28].toLowerCase())) {
                     var2 = true;
                     break;
                  }
               }

               if (!var2) {
                  var4 = this.clname[var17].toLowerCase();
                  break;
               }
            }
         }

         if (var2 && this.npf > 0) {
            for (int var18 = 0; var18 < this.npf; var18++) {
               var2 = false;

               for (int var29 = 0; var29 < this.nlg; var29++) {
                  if (this.fname[var18].toLowerCase().equals(this.logos[var29].toLowerCase())) {
                     var2 = true;
                     break;
                  }
               }

               if (!var2) {
                  var4 = this.fname[var18].toLowerCase();
                  break;
               }
            }
         }

         if (var2 && this.nm > 0) {
            for (int var19 = 0; var19 < this.nm; var19++) {
               var2 = false;

               for (int var30 = 0; var30 < this.nlg; var30++) {
                  if (this.mname[var19].toLowerCase().equals(this.logos[var30].toLowerCase())) {
                     var2 = true;
                     break;
                  }
               }

               if (!var2) {
                  var4 = this.mname[var19].toLowerCase();
                  break;
               }
            }
         }

         if (var2) {
            for (int var20 = 0; var20 < this.npo; var20++) {
               var2 = false;

               for (int var31 = 0; var31 < this.nlg; var31++) {
                  if (this.pname[var20].toLowerCase().equals(this.logos[var31].toLowerCase())) {
                     var2 = true;
                     break;
                  }
               }

               if (!var2) {
                  var4 = this.pname[var20].toLowerCase();
                  break;
               }
            }
         }

         if (var2) {
            break;
         }

         this.logos[this.nlg] = var4;
         this.logon[this.nlg] = false;

         try {
            String var21 = "http://multiplayer.needformadness.com/profiles/" + this.logos[this.nlg] + "/logo.png";
            if (var3) {
               var21 = "http://multiplayer.needformadness.com/clans/" + var5 + "/logo.png";
            }

            URL var32 = new URL(var21);
            var32.openConnection().setConnectTimeout(2000);
            String var36 = var32.openConnection().getContentType();
            if (var36.equals("image/png")) {
               this.logoi[this.nlg] = Toolkit.getDefaultToolkit().createImage(var32);
               this.mt.addImage(this.logoi[this.nlg], this.nlg);
               this.logon[this.nlg] = true;
            }
         } catch (Exception var9) {
         }

         this.nlg++;
         if (this.nlg == 200) {
            this.nlg = 0;
         }
      }
   }

   public boolean drawl(Graphics2D var1, String var2, int var3, int var4, boolean var5) {
      boolean var6 = false;
      int var7 = -1;

      for (int var8 = 0; var8 < this.nlg; var8++) {
         if (var2.toLowerCase().equals(this.logos[var8].toLowerCase())) {
            var7 = var8;
            break;
         }
      }

      if (var7 != -1 && this.logon[var7]) {
         if (!var5) {
            var1.setComposite(AlphaComposite.getInstance(3, 0.1F));
         }

         var1.drawImage(this.logoi[var7], var3, var4, null);
         var6 = this.mt.checkID(var7);
         if (!var5) {
            var1.setComposite(AlphaComposite.getInstance(3, 1.0F));
         }
      }

      return var6;
   }

   public void logopng() {
      int var1 = -1;
      boolean var2 = false;

      for (int var3 = 0; var3 < this.nlg; var3++) {
         if (this.proname.toLowerCase().equals(this.logos[var3].toLowerCase())) {
            var1 = var3;
            if (this.logon[var3] && !this.refresh) {
               var2 = true;
               this.logol = true;
            }
            break;
         }
      }

      if (!var2) {
         if (var1 == -1) {
            var1 = this.nlg++;
            if (this.nlg == 200) {
               this.nlg = 0;
            }
         }

         this.logos[var1] = this.proname.toLowerCase();

         try {
            String var7 = "";
            if (this.refresh) {
               var7 = "?req=" + (int)(Math.random() * 1000.0) + "";
            }

            URL var4 = new URL("http://multiplayer.needformadness.com/profiles/" + this.proname + "/logo.png" + var7 + "");
            var4.openConnection().setConnectTimeout(2000);
            String var5 = var4.openConnection().getContentType();
            if (var5.equals("image/png")) {
               this.logoi[var1] = Toolkit.getDefaultToolkit().createImage(var4);
               this.mt.addImage(this.logoi[var1], var1);
               this.logon[var1] = true;
            } else {
               this.logon[var1] = false;
            }
         } catch (Exception var6) {
         }

         this.logol = this.logon[var1];
      }
   }

   public void clanlogopng(String var1) {
      int var2 = -1;
      boolean var3 = false;
      String var4 = "#" + var1.toLowerCase() + "#";

      for (int var5 = 0; var5 < this.nlg; var5++) {
         if (var4.equals(this.logos[var5])) {
            var2 = var5;
            if (this.logon[var5] && !this.refresh) {
               var3 = true;
            }
            break;
         }
      }

      if (!var3) {
         if (var2 == -1) {
            var2 = this.nlg++;
            if (this.nlg == 200) {
               this.nlg = 0;
            }
         }

         this.logos[var2] = var4;

         try {
            String var9 = "";
            if (this.refresh) {
               var9 = "?req=" + (int)(Math.random() * 1000.0) + "";
            }

            URL var6 = new URL("http://multiplayer.needformadness.com/clans/" + var1 + "/logo.png" + var9 + "");
            var6.openConnection().setConnectTimeout(2000);
            String var7 = var6.openConnection().getContentType();
            if (var7.equals("image/png")) {
               this.logoi[var2] = Toolkit.getDefaultToolkit().createImage(var6);
               this.mt.addImage(this.logoi[var2], var2);
               this.logon[var2] = true;
            } else {
               this.logon[var2] = false;
            }
         } catch (Exception var8) {
         }
      }
   }

   public void avatarpng() {
      this.avatarl = false;
      String var1 = "";
      if (this.refresh) {
         var1 = "?req=" + (int)(Math.random() * 1000.0) + "";
      }

      try {
         URL var2 = new URL("http://multiplayer.needformadness.com/profiles/" + this.proname + "/avatar.png" + var1 + "");
         var2.openConnection().setConnectTimeout(2000);
         String var3 = var2.openConnection().getContentType();
         if (var3.equals("image/png")) {
            this.avatar = Toolkit.getDefaultToolkit().createImage(var2);
            this.avatarl = true;
         }
      } catch (Exception var4) {
      }
   }

   public void clanbgpng() {
      this.clanbgl = false;
      String var1 = "";
      if (this.refresh) {
         var1 = "?req=" + (int)(Math.random() * 1000.0) + "";
      }

      try {
         URL var2 = new URL("http://multiplayer.needformadness.com/clans/" + this.claname + "/bg.jpg" + var1 + "");
         var2.openConnection().setConnectTimeout(2000);
         String var3 = var2.openConnection().getContentType();
         if (var3.equals("image/jpeg")) {
            this.clanbg = Toolkit.getDefaultToolkit().createImage(var2);
            this.clanbgl = true;
         }
      } catch (Exception var4) {
      }
   }

   public void intclanbgpng(String var1) {
      if (!this.intclanlo.equals(var1)) {
         this.intclanbgloaded = false;

         try {
            URL var2 = new URL("http://multiplayer.needformadness.com/clans/" + var1 + "/bg.jpg");
            var2.openConnection().setConnectTimeout(2000);
            String var3 = var2.openConnection().getContentType();
            if (var3.equals("image/jpeg")) {
               this.intclanbg = Toolkit.getDefaultToolkit().createImage(var2);
               this.intclanbgloaded = true;
            }
         } catch (Exception var4) {
         }

         this.intclanlo = var1;
      }
   }

   public void loadmyclanbg() {
      if (this.loadedmyclanbg <= 0) {
         String var1 = "";
         if (this.loadedmyclanbg == -1) {
            var1 = "?req=" + (int)(Math.random() * 1000.0) + "";
         }

         this.loadedmyclanbg = 2;

         try {
            URL var2 = new URL("http://multiplayer.needformadness.com/clans/" + this.xt.clan + "/bg.jpg" + var1 + "");
            var2.openConnection().setConnectTimeout(2000);
            String var3 = var2.openConnection().getContentType();
            if (var3.equals("image/jpeg")) {
               this.myclanbg = Toolkit.getDefaultToolkit().createImage(var2);
               this.loadedmyclanbg = 1;
            }
         } catch (Exception var4) {
         }
      }
   }

   public void loadclan() {
      this.notclan = false;
      int var1 = 0;
      String[] var2 = new String[20];
      int[] var3 = new int[20];
      String[] var4 = new String[20];
      this.showreqs = false;
      this.nrmb = 0;

      try {
         URL var5 = new URL("http://multiplayer.needformadness.com/clans/" + this.claname + "/members.txt?req=" + (int)(Math.random() * 1000.0) + "");
         var5.openConnection().setConnectTimeout(2000);
         String var6 = var5.openConnection().getContentType();
         if (var6.equals("text/plain")) {
            DataInputStream var7 = new DataInputStream(var5.openStream());
            String var8 = "";

            while ((var8 = var7.readLine()) != null && var1 < 20) {
               var8 = var8.trim();
               String var9 = this.getSvalue(var8, 0);
               if (!var9.equals("")) {
                  int var10 = this.getvalue(var8, 1);
                  if (var10 != 0) {
                     var2[var1] = var9;
                     var3[var1] = var10;
                     var4[var1] = this.getSvalue(var8, 2);
                     var1++;
                  } else if (this.nrmb < 100) {
                     this.rmember[this.nrmb] = var9;
                     this.nrmb++;
                  }
               }
            }

            var7.close();
         } else {
            this.notclan = true;
         }
      } catch (Exception var11) {
      }

      this.nmb = 0;
      if (!this.notclan) {
         for (int var12 = 7; var12 > 0; var12--) {
            for (int var15 = 0; var15 < var1; var15++) {
               if (var3[var15] == var12) {
                  this.member[this.nmb] = var2[var15];
                  this.mrank[this.nmb] = var4[var15];
                  this.mlevel[this.nmb] = var3[var15];
                  this.nmb++;
               }
            }
         }

         for (int var13 = 0; var13 < this.nmb; var13++) {
            if (this.xt.nickname.toLowerCase().equals(this.member[var13].toLowerCase())) {
               if ((this.mlevel[var13] == 7 || var13 == 0) && this.nrmb != 0) {
                  this.showreqs = true;
               }

               if (!this.xt.clan.toLowerCase().equals(this.claname.toLowerCase())) {
                  this.attachetoclan = true;
               }
            }
         }

         if (this.xt.clan.toLowerCase().equals(this.claname.toLowerCase())) {
            for (int var14 = 0; var14 < var1; var14++) {
               this.clname[var14] = var2[var14];
            }

            this.ncln = var1;
            this.loadedcm = true;
         }
      }
   }

   public void loadclanlink() {
      this.ltit = "";
      this.ldes = "";
      this.lurl = "";

      try {
         URL var1 = new URL("http://multiplayer.needformadness.com/clans/" + this.claname + "/link.txt?req=" + (int)(Math.random() * 1000.0) + "");
         var1.openConnection().setConnectTimeout(2000);
         String var2 = var1.openConnection().getContentType();
         if (var2.equals("text/plain")) {
            DataInputStream var3 = new DataInputStream(var1.openStream());
            String var4 = "";

            for (int var5 = 0; (var4 = var3.readLine()) != null && var5 < 3; var5++) {
               var4 = var4.trim();
               if (var5 == 0) {
                  this.ltit = var4;
               }

               if (var5 == 1) {
                  this.ldes = var4;
               }

               if (var5 == 2) {
                  this.lurl = var4;
               }
            }

            var3.close();
         }
      } catch (Exception var6) {
         this.ltit = "";
         this.ldes = "";
         this.lurl = "";
      }
   }

   public void loadfclan() {
      this.ncln = 0;

      try {
         URL var1 = new URL("http://multiplayer.needformadness.com/clans/" + this.xt.clan + "/members.txt?req=" + (int)(Math.random() * 1000.0) + "");
         var1.openConnection().setConnectTimeout(2000);
         DataInputStream var2 = new DataInputStream(var1.openStream());
         String var3 = "";

         while ((var3 = var2.readLine()) != null && this.ncln < 20) {
            var3 = var3.trim();
            String var4 = this.getSvalue(var3, 0);
            if (!var4.equals("") && this.getvalue(var3, 1) != 0) {
               this.clname[this.ncln] = var4;
               this.ncln++;
            }
         }

         var2.close();
      } catch (Exception var5) {
      }
   }

   public int loadclancars() {
      this.m.csky[0] = 170;
      this.m.csky[1] = 220;
      this.m.csky[2] = 255;
      this.m.cfade[0] = 255;
      this.m.cfade[1] = 220;
      this.m.cfade[2] = 220;
      this.m.snap[0] = 0;
      this.m.snap[1] = 0;
      this.m.snap[2] = 0;
      byte var1 = 0;
      this.gs.clcars.removeAll();
      this.gs.clcars.add(this.rd, "Select Car");

      try {
         URL var2 = new URL("http://multiplayer.needformadness.com/clans/" + this.claname + "/cars.txt?req=" + (int)(Math.random() * 1000.0) + "");
         var2.openConnection().setConnectTimeout(2000);
         String var3 = var2.openConnection().getContentType();
         if (var3.equals("text/plain")) {
            DataInputStream var4 = new DataInputStream(var2.openStream());
            String var5 = "";
            int var6 = 0;

            while ((var5 = var4.readLine()) != null && var6 < 700) {
               this.gs.clcars.add(this.rd, var5);
               var6++;
               if (var1 != 1) {
                  var1 = 1;
               }
            }

            var4.close();
         }
      } catch (Exception var7) {
         var1 = -2;
      }

      if (var1 == 1) {
         if (this.viewcar.equals("")) {
            this.gs.clcars.select(0);
         } else {
            this.gs.clcars.select(this.viewcar);
            this.viewcar = "";
         }

         this.selcar = this.gs.clcars.getSelectedItem();
      }

      return var1;
   }

   public int loadaddcars() {
      byte var1 = 3;
      int var2 = 0;
      String[] var3 = new String[700];

      try {
         URL var4 = new URL("http://multiplayer.needformadness.com/cars/lists/" + this.gs.tnick.getText() + ".txt?reqlo=" + (int)(Math.random() * 1000.0) + "");
         var4.openConnection().setConnectTimeout(2000);
         DataInputStream var15 = new DataInputStream(var4.openStream());
         String var6 = "";

         while ((var6 = var15.readLine()) != null) {
            var6 = "" + var6.trim();
            if (var6.startsWith("mycars")) {
               boolean var7 = true;

               while (var7 && var2 < 700) {
                  var3[var2] = this.getfuncSvalue("mycars", var6, var2);
                  if (var3[var2].equals("")) {
                     var7 = false;
                  } else {
                     var2++;
                  }
               }
            }
         }

         var15.close();
      } catch (Exception var13) {
         String var5 = "" + var13;
         if (var5.indexOf("FileNotFound") != -1) {
            var2 = 0;
            var1 = 3;
         } else {
            var2 = -1;
            var1 = 4;
         }
      }

      if (var2 > 0) {
         String[] var14 = new String[700];
         int var16 = 0;

         for (int var19 = 0; var19 < var2; var19++) {
            this.perry = "" + (int)((float)var19 / var2 * 100.0F) + " %";

            try {
               String var21 = "http://multiplayer.needformadness.com/cars/" + var3[var19] + ".txt?reqlo=" + (int)(Math.random() * 1000.0) + "";
               var21 = var21.replace(' ', '_');
               URL var8 = new URL(var21);
               var8.openConnection().setConnectTimeout(2000);
               DataInputStream var9 = new DataInputStream(var8.openStream());
               String var10 = "";

               while ((var10 = var9.readLine()) != null) {
                  var10 = "" + var10.trim();
                  if (var10.startsWith("details")) {
                     String var11 = this.getfuncSvalue("details", var10, 0);
                     if (var11.toLowerCase().equals(this.gs.tnick.getText().toLowerCase()) && var10.indexOf("Clan#") == -1) {
                        var14[var16] = var3[var19];
                        var16++;
                     }
                  }
               }

               var9.close();
            } catch (Exception var12) {
            }
         }

         if (var16 > 0) {
            this.gs.clcars.removeAll();

            for (int var20 = 0; var20 < var16; var20++) {
               this.gs.clcars.add(this.rd, var14[var20]);
            }

            var1 = 5;
         } else {
            var1 = 3;
         }
      }

      return var1;
   }

   public void loadiclancars(String var1) {
      try {
         URL var2 = new URL("http://multiplayer.needformadness.com/clans/" + var1 + "/cars.txt");
         var2.openConnection().setConnectTimeout(2000);
         String var3 = var2.openConnection().getContentType();
         if (var3.equals("text/plain")) {
            this.gs.datat.removeAll();
            this.gs.datat.add(this.rd, "Select Car");
            DataInputStream var4 = new DataInputStream(var2.openStream());
            String var5 = "";

            for (int var6 = 0; (var5 = var4.readLine()) != null && var6 < 700; var6++) {
               this.gs.datat.add(this.rd, var5);
            }

            var4.close();
         } else {
            this.gs.datat.removeAll();
            this.gs.datat.add(this.rd, "No clan cars where found.");
         }
      } catch (Exception var7) {
         this.gs.datat.removeAll();
         this.gs.datat.add(this.rd, "Failed to load cars, try again later...");
      }

      this.gs.datat.select(0);
   }

   public int loadclanstages() {
      byte var1 = 0;
      this.gs.clcars.removeAll();
      this.gs.clcars.add(this.rd, "Select Stage");

      try {
         URL var2 = new URL("http://multiplayer.needformadness.com/clans/" + this.claname + "/stages.txt?req=" + (int)(Math.random() * 1000.0) + "");
         var2.openConnection().setConnectTimeout(2000);
         String var3 = var2.openConnection().getContentType();
         if (var3.equals("text/plain")) {
            DataInputStream var4 = new DataInputStream(var2.openStream());
            String var5 = "";
            int var6 = 0;

            while ((var5 = var4.readLine()) != null && var6 < 700) {
               this.gs.clcars.add(this.rd, var5);
               var6++;
               if (var1 != 1) {
                  var1 = 1;
               }
            }

            var4.close();
         }
      } catch (Exception var7) {
         var1 = -2;
      }

      if (var1 == 1) {
         if (this.viewcar.equals("")) {
            this.gs.clcars.select(0);
         } else {
            this.gs.clcars.select(this.viewcar);
            this.viewcar = "";
         }

         this.selstage = this.gs.clcars.getSelectedItem();
      }

      return var1;
   }

   public int loadaddstages() {
      byte var1 = 3;
      int var2 = 0;
      String[] var3 = new String[700];

      try {
         URL var4 = new URL(
            "http://multiplayer.needformadness.com/tracks/lists/" + this.gs.tnick.getText() + ".txt?reqlo=" + (int)(Math.random() * 1000.0) + ""
         );
         var4.openConnection().setConnectTimeout(2000);
         DataInputStream var15 = new DataInputStream(var4.openStream());
         String var6 = "";

         while ((var6 = var15.readLine()) != null) {
            var6 = "" + var6.trim();
            if (var6.startsWith("mystages")) {
               boolean var7 = true;

               while (var7 && var2 < 700) {
                  var3[var2] = this.getfuncSvalue("mystages", var6, var2);
                  if (var3[var2].equals("")) {
                     var7 = false;
                  } else {
                     var2++;
                  }
               }
            }
         }

         var15.close();
      } catch (Exception var13) {
         String var5 = "" + var13;
         if (var5.indexOf("FileNotFound") != -1) {
            var2 = 0;
            var1 = 3;
         } else {
            var2 = -1;
            var1 = 4;
         }
      }

      if (var2 > 0) {
         String[] var14 = new String[700];
         int var16 = 0;

         for (int var19 = 0; var19 < var2; var19++) {
            this.perry = "" + (int)((float)var19 / var2 * 100.0F) + " %";

            try {
               String var21 = "http://multiplayer.needformadness.com/tracks/" + var3[var19] + ".txt?reqlo=" + (int)(Math.random() * 1000.0) + "";
               var21 = var21.replace(' ', '_');
               URL var8 = new URL(var21);
               var8.openConnection().setConnectTimeout(2000);
               DataInputStream var9 = new DataInputStream(var8.openStream());
               String var10 = "";

               while ((var10 = var9.readLine()) != null) {
                  var10 = "" + var10.trim();
                  if (var10.startsWith("details")) {
                     String var11 = this.getfuncSvalue("details", var10, 0);
                     if (var11.toLowerCase().equals(this.gs.tnick.getText().toLowerCase()) && var10.indexOf("Clan#") == -1) {
                        var14[var16] = var3[var19];
                        var16++;
                     }
                  }
               }

               var9.close();
            } catch (Exception var12) {
            }
         }

         if (var16 > 0) {
            this.gs.clcars.removeAll();

            for (int var20 = 0; var20 < var16; var20++) {
               this.gs.clcars.add(this.rd, var14[var20]);
            }

            var1 = 5;
         } else {
            var1 = 3;
         }
      }

      return var1;
   }

   public void loadiclanstages(String var1) {
      try {
         URL var2 = new URL("http://multiplayer.needformadness.com/clans/" + var1 + "/stages.txt");
         var2.openConnection().setConnectTimeout(2000);
         String var3 = var2.openConnection().getContentType();
         if (var3.equals("text/plain")) {
            this.gs.datat.removeAll();
            this.gs.datat.add(this.rd, "Select Stage");
            DataInputStream var4 = new DataInputStream(var2.openStream());
            String var5 = "";

            for (int var6 = 0; (var5 = var4.readLine()) != null && var6 < 700; var6++) {
               this.gs.datat.add(this.rd, var5);
            }

            var4.close();
         } else {
            this.gs.datat.removeAll();
            this.gs.datat.add(this.rd, "No clan stages where found.");
         }
      } catch (Exception var7) {
         this.gs.datat.removeAll();
         this.gs.datat.add(this.rd, "Failed to load stages, try again later...");
      }

      this.gs.datat.select(0);
   }

   public void loadproinfo() {
      if (!this.proname.equals(this.xt.nickname) && this.npf == -1) {
         this.loadfriends();
      }

      this.racing = 0;
      this.wasting = 0;
      this.themesong = "";
      this.trackvol = 0;
      this.sentance = "";
      this.proclan = "";

      try {
         String var1 = "";
         if (this.proname.equals(this.xt.nickname)) {
            var1 = "?req=" + (int)(Math.random() * 1000.0) + "";
         }

         URL var2 = new URL("http://multiplayer.needformadness.com/profiles/" + this.proname + "/info.txt" + var1 + "");
         var2.openConnection().setConnectTimeout(2000);
         String var3 = var2.openConnection().getContentType();
         if (var3.equals("text/plain")) {
            DataInputStream var4 = new DataInputStream(var2.openStream());
            String var5 = "";

            for (int var6 = 0; (var5 = var4.readLine()) != null && var6 < 9; var6++) {
               var5 = var5.trim();
               if (var6 == 0) {
                  this.themesong = var5;
               }

               if (var6 == 1) {
                  int var7 = 0;

                  try {
                     var7 = Integer.valueOf(var5);
                  } catch (Exception var11) {
                     var7 = 0;
                  }

                  this.trackvol = var7;
               }

               if (var6 == 2) {
                  int var16 = 0;

                  try {
                     var16 = Integer.valueOf(var5);
                  } catch (Exception var10) {
                     var16 = 0;
                  }

                  this.racing = var16;
               }

               if (var6 == 3) {
                  int var18 = 0;

                  try {
                     var18 = Integer.valueOf(var5);
                  } catch (Exception var9) {
                     var18 = 0;
                  }

                  this.wasting = var18;
               }

               if (var6 == 4) {
                  this.proclan = var5;
               }

               if (var6 == 8) {
                  this.sentance = var5;
               }
            }

            var4.close();
         }
      } catch (Exception var12) {
         this.sentance = "Failed to load profile info, server error!";
      }
   }

   public void loadprostages() {
      String[] var1 = new String[700];
      int var2 = 0;
      String var3 = "";

      try {
         URL var4 = new URL("http://multiplayer.needformadness.com/tracks/lists/" + this.proname + ".txt?reqlo=" + (int)(Math.random() * 1000.0) + "");
         DataInputStream var11 = new DataInputStream(var4.openStream());

         while ((var3 = var11.readLine()) != null) {
            var3 = "" + var3.trim();
            if (var3.startsWith("mystages")) {
               boolean var6 = true;

               while (var6 && var2 < 700) {
                  var1[var2] = this.getfuncSvalue("mystages", var3, var2);
                  if (var1[var2].equals("")) {
                     var6 = false;
                  } else {
                     var2++;
                  }
               }
            }
         }

         if (var2 > 0) {
            this.loadpst = 1;
         } else {
            this.loadpst = -2;
         }

         var11.close();
      } catch (Exception var7) {
         String var5 = "" + var7;
         if (var5.indexOf("FileNotFound") != -1) {
            this.loadpst = -2;
         } else {
            this.loadpst = -1;
         }
      }

      if (this.loadpst == 1) {
         this.gs.proitem.removeAll();
         this.gs.proitem.add(this.gs.rd, "Select Stage");

         for (int var10 = 0; var10 < var2; var10++) {
            this.gs.proitem.add(this.gs.rd, var1[var10]);
         }

         this.gs.proitem.select(0);
         this.loadpstage = "Select Stage";
         this.gs.proitem.show();
      }

      if (this.loadpst == -2) {
         this.gs.proitem.removeAll();
         this.gs.proitem.add(this.gs.rd, "No published or added stages found...");
         this.gs.proitem.select(0);
         this.gs.proitem.show();
      }

      if (this.loadpst == -1) {
         this.gs.proitem.removeAll();
         this.gs.proitem.add(this.gs.rd, "Failed to load stages, please try again later.");
         this.gs.proitem.select(0);
         this.gs.proitem.show();
      }

      System.gc();
   }

   public void loadfriends() {
      if (this.npf == -1) {
         this.freq = 0;

         try {
            URL var1 = new URL("http://multiplayer.needformadness.com/profiles/" + this.xt.nickname + "/friends.txt?req=" + (int)(Math.random() * 1000.0) + "");
            var1.openConnection().setConnectTimeout(2000);
            String var2 = var1.openConnection().getContentType();
            if (var2.equals("text/plain")) {
               int var3 = 0;
               DataInputStream var4 = new DataInputStream(var1.openStream());
               String var5 = "";

               for (int var6 = 0; (var5 = var4.readLine()) != null && var6 < 3; var6++) {
                  var5 = var5.trim();
                  if (var6 == 0) {
                     for (String var7 = this.getSvalue(var5, var3); !var7.equals("") && this.npf < 900; var7 = this.getSvalue(var5, ++var3)) {
                        this.fname[var3] = var7;
                     }
                  }

                  if (var6 == 1) {
                     this.freqname = this.getSvalue(var5, 0);
                     if (!this.freqname.equals("")) {
                        this.freq = 1;
                     }
                  }

                  if (var6 == 2 && this.freq != 1) {
                     this.ncnf = 0;

                     for (String var11 = this.getSvalue(var5, this.ncnf); !var11.equals("") && this.ncnf < 10; var11 = this.getSvalue(var5, this.ncnf)) {
                        this.cnfname[this.ncnf] = var11;
                        this.ncnf++;
                     }

                     if (this.ncnf != 0) {
                        this.freq = 6;
                     }
                  }
               }

               var4.close();
               this.npf = var3;
            } else {
               this.npf = 0;
            }
         } catch (Exception var8) {
            this.npf = -2;
         }
      }
   }

   public void loadnews() {
      try {
         URL var1 = new URL("http://multiplayer.needformadness.com/interact/news.txt?req=" + (int)(Math.random() * 1000.0) + "");
         var1.openConnection().setConnectTimeout(2000);
         DataInputStream var2 = new DataInputStream(var1.openStream());
         String var3 = "";
         int var4 = 0;
         String var5 = "";

         for (this.il = 0; (var3 = var2.readLine()) != null && var4 < 300; var4++) {
            var3 = var3.trim();
            if (var4 == 0) {
               for (int var6 = 0; var6 < 4; var6++) {
                  this.newplayers[var6] = this.getSvalue(var3, var6);
               }
            }

            if (var4 >= 1 && var4 <= 5) {
               this.nwtime[var4 - 1] = this.contime(this.getLvalue(var3, 0));
               this.nwarbs[var4 - 1] = this.getvalue(var3, 1);
               this.nwclan[var4 - 1] = this.getSvalue(var3, 2);
               this.nlclan[var4 - 1] = this.getSvalue(var3, 3);
               this.nwinob[var4 - 1] = this.getSvalue(var3, 4);
               this.nwinp[var4 - 1] = this.getvalue(var3, 5);
               this.nlosp[var4 - 1] = this.getvalue(var3, 6);
            }

            if (var4 >= 6 && this.il < 300) {
               this.nttime[this.il] = this.contime(this.getLvalue(var3, 0));
               int var13 = this.getvalue(var3, 1);
               if (var13 == 4) {
                  int var7 = this.getvalue(var3, 4);
                  if (var7 <= 0) {
                     this.text[this.il] = "" + this.getSvalue(var3, 2) + " has joined clan " + this.getSvalue(var3, 3) + ".";
                  } else {
                     int var8 = this.getvalue(var3, 5);
                     if (var8 == var7) {
                        this.text[this.il] = "" + this.getSvalue(var3, 2) + " got a new rank in clan " + this.getSvalue(var3, 3) + ".";
                     } else {
                        String var9 = "promoted";
                        if (var8 - var7 < 0) {
                           var9 = "demoted";
                        }

                        if (var8 != 7) {
                           this.text[this.il] = ""
                              + this.getSvalue(var3, 2)
                              + " has been "
                              + var9
                              + " in clan "
                              + this.getSvalue(var3, 3)
                              + " to a level "
                              + var8
                              + " member.";
                        } else {
                           this.text[this.il] = "" + this.getSvalue(var3, 2) + " has been " + var9 + " in clan " + this.getSvalue(var3, 3) + " to Clan Admin!";
                        }
                     }
                  }

                  this.nln[this.il] = 2;
                  this.link[this.il][0][0] = this.getSvalue(var3, 2);
                  this.link[this.il][0][1] = "0|" + this.getSvalue(var3, 2) + "|";
                  this.link[this.il][1][0] = this.getSvalue(var3, 3);
                  this.link[this.il][1][1] = "1|" + this.getSvalue(var3, 3) + "|";
                  this.il++;
               }

               if (var13 == 5) {
                  String var14 = this.getSvalue(var3, 2);
                  String var17 = this.getSvalue(var3, 4);
                  String var19 = "left";
                  if (!var14.toLowerCase().equals(var17.toLowerCase())) {
                     var19 = "been removed from";
                  }

                  this.text[this.il] = "" + var14 + " has " + var19 + " clan " + this.getSvalue(var3, 3) + ".";
                  this.nln[this.il] = 2;
                  this.link[this.il][0][0] = this.getSvalue(var3, 2);
                  this.link[this.il][0][1] = "0|" + this.getSvalue(var3, 2) + "|";
                  this.link[this.il][1][0] = this.getSvalue(var3, 3);
                  this.link[this.il][1][1] = "1|" + this.getSvalue(var3, 3) + "|";
                  this.il++;
               }

               if (var13 == 6) {
                  this.text[this.il] = "" + this.getSvalue(var3, 2) + " has updated clan " + this.getSvalue(var3, 3) + "'s web presence.";
                  this.nln[this.il] = 3;
                  this.link[this.il][0][0] = this.getSvalue(var3, 2);
                  this.link[this.il][0][1] = "0|" + this.getSvalue(var3, 2) + "|";
                  this.link[this.il][1][0] = this.getSvalue(var3, 3);
                  this.link[this.il][1][1] = "1|" + this.getSvalue(var3, 3) + "|";
                  this.link[this.il][2][0] = "web presence";
                  this.link[this.il][2][1] = "2|" + this.getSvalue(var3, 3) + "|";
                  this.il++;
               }

               if (var13 == 7 && var5.indexOf("#" + this.getSvalue(var3, 4) + "#") == -1) {
                  this.text[this.il] = "" + this.getSvalue(var3, 2) + " has added car " + this.getSvalue(var3, 4) + " to clan " + this.getSvalue(var3, 3) + ".";
                  this.nln[this.il] = 3;
                  this.link[this.il][0][0] = this.getSvalue(var3, 2);
                  this.link[this.il][0][1] = "0|" + this.getSvalue(var3, 2) + "|";
                  this.link[this.il][1][0] = this.getSvalue(var3, 3);
                  this.link[this.il][1][1] = "1|" + this.getSvalue(var3, 3) + "|";
                  this.link[this.il][2][0] = this.getSvalue(var3, 4);
                  this.link[this.il][2][1] = "3|" + this.getSvalue(var3, 4) + "|" + this.getSvalue(var3, 3) + "|";
                  var5 = var5 + "#" + this.getSvalue(var3, 4) + "#";
                  this.il++;
               }

               if (var13 == 8 && var5.indexOf("#" + this.getSvalue(var3, 4) + "#") == -1) {
                  String var15 = this.getSvalue(var3, 4);
                  if (var15.length() > 20) {
                     var15 = "" + var15.substring(0, 20) + "...";
                  }

                  this.text[this.il] = "" + this.getSvalue(var3, 2) + " has added stage " + var15 + " to clan " + this.getSvalue(var3, 3) + ".";
                  this.nln[this.il] = 3;
                  this.link[this.il][0][0] = this.getSvalue(var3, 2);
                  this.link[this.il][0][1] = "0|" + this.getSvalue(var3, 2) + "|";
                  this.link[this.il][1][0] = this.getSvalue(var3, 3);
                  this.link[this.il][1][1] = "1|" + this.getSvalue(var3, 3) + "|";
                  this.link[this.il][2][0] = var15;
                  this.link[this.il][2][1] = "4|" + this.getSvalue(var3, 4) + "|" + this.getSvalue(var3, 3) + "|";
                  var5 = var5 + "#" + this.getSvalue(var3, 4) + "#";
                  this.il++;
               }

               if (var13 == 9) {
                  String var16 = this.getSvalue(var3, 2);
                  if (var16.startsWith("War")) {
                     this.text[this.il] = "Clans " + this.getSvalue(var3, 7) + " & " + this.getSvalue(var3, 8) + " have now started a war!";
                     this.nln[this.il] = 2;
                     this.link[this.il][0][0] = this.getSvalue(var3, 7);
                     this.link[this.il][0][1] = "1|" + this.getSvalue(var3, 7) + "|";
                     this.link[this.il][1][0] = this.getSvalue(var3, 8);
                     this.link[this.il][1][1] = "1|" + this.getSvalue(var3, 8) + "|";
                     this.il++;
                  }

                  if (var16.startsWith("Car")) {
                     this.text[this.il] = "Clans " + this.getSvalue(var3, 7) + " & " + this.getSvalue(var3, 8) + " have started a car battle!";
                     this.nln[this.il] = 2;
                     this.link[this.il][0][0] = this.getSvalue(var3, 7);
                     this.link[this.il][0][1] = "1|" + this.getSvalue(var3, 7) + "|";
                     this.link[this.il][1][0] = this.getSvalue(var3, 8);
                     this.link[this.il][1][1] = "1|" + this.getSvalue(var3, 8) + "|";
                     this.il++;
                     if (this.il < 300) {
                        this.text[this.il] = "Battle over cars: [" + this.getSvalue(var3, 4) + "] & [" + this.getSvalue(var3, 5) + "]";
                        this.nln[this.il] = 2;
                        this.link[this.il][0][0] = this.getSvalue(var3, 4);
                        this.link[this.il][0][1] = "3|" + this.getSvalue(var3, 4) + "|" + this.getSvalue(var3, 8) + "|";
                        this.link[this.il][1][0] = this.getSvalue(var3, 5);
                        this.link[this.il][1][1] = "3|" + this.getSvalue(var3, 5) + "|" + this.getSvalue(var3, 7) + "|";
                        this.nttime[this.il] = "";
                        this.il++;
                     }
                  }

                  if (var16.startsWith("Stage")) {
                     String var18 = this.getSvalue(var3, 4);
                     if (var18.length() > 20) {
                        var18 = "" + var18.substring(0, 20) + "...";
                     }

                     String var20 = this.getSvalue(var3, 5);
                     if (var20.length() > 20) {
                        var20 = "" + var20.substring(0, 20) + "...";
                     }

                     this.text[this.il] = "Clans " + this.getSvalue(var3, 7) + " & " + this.getSvalue(var3, 8) + " have started a stage battle!";
                     this.nln[this.il] = 2;
                     this.link[this.il][0][0] = this.getSvalue(var3, 7);
                     this.link[this.il][0][1] = "1|" + this.getSvalue(var3, 7) + "|";
                     this.link[this.il][1][0] = this.getSvalue(var3, 8);
                     this.link[this.il][1][1] = "1|" + this.getSvalue(var3, 8) + "|";
                     this.il++;
                     if (this.il < 300) {
                        this.text[this.il] = "Battle over stages: [" + var18 + "] & [" + var20 + "]";
                        this.nln[this.il] = 2;
                        this.link[this.il][0][0] = var18;
                        this.link[this.il][0][1] = "4|" + this.getSvalue(var3, 4) + "|" + this.getSvalue(var3, 8) + "|";
                        this.link[this.il][1][0] = var20;
                        this.link[this.il][1][1] = "4|" + this.getSvalue(var3, 5) + "|" + this.getSvalue(var3, 7) + "|";
                        this.nttime[this.il] = "";
                        this.il++;
                     }
                  }
               }

               if (var13 == 10 || var13 == 11 || var13 == 12 || var13 == 13) {
                  if (var13 == 11) {
                     this.text[this.il] = "" + this.getSvalue(var3, 2) + " has re-claimed its title as clan wars world champion!";
                  } else {
                     this.text[this.il] = "" + this.getSvalue(var3, 2) + " has now become the new clan wars world champion!";
                  }

                  this.nln[this.il] = 2;
                  this.link[this.il][0][0] = this.getSvalue(var3, 2);
                  this.link[this.il][0][1] = "1|" + this.getSvalue(var3, 2) + "|";
                  this.link[this.il][1][0] = "clan wars world champion";
                  this.link[this.il][1][1] = "5|championship|";
                  if (this.getSvalue(var3, 2).equals("")) {
                     this.text[this.il] = "No one is currently the clan wars world champion!";
                     this.nln[this.il] = 1;
                     this.link[this.il][0][0] = "clan wars world champion";
                     this.link[this.il][0][1] = "5|championship|";
                  }

                  this.il++;
                  if (var13 == 10) {
                     this.text[this.il] = ""
                        + this.getSvalue(var3, 2)
                        + " recent win against "
                        + this.getSvalue(var3, 4)
                        + " has given it the championship title!";
                  }

                  if (var13 == 11) {
                     this.text[this.il] = ""
                        + this.getSvalue(var3, 2)
                        + " has successfully defended its championship title against "
                        + this.getSvalue(var3, 4)
                        + "!";
                  }

                  if (var13 == 12) {
                     this.text[this.il] = "A recent war between "
                        + this.getSvalue(var3, 3)
                        + " and "
                        + this.getSvalue(var3, 4)
                        + " has resulted in a change of points!";
                  }

                  if (var13 == 13) {
                     this.text[this.il] = "Clan " + this.getSvalue(var3, 3) + " removed itself from the game which resulted in a change of points!";
                  }

                  this.nttime[this.il] = "";
                  this.nln[this.il] = 0;
                  this.il++;
               }
            }
         }

         var2.close();
         this.spos6 = 0;
         this.loadednews = 1;
      } catch (Exception var10) {
         this.loadednews = -1;
      }
   }

   public void loadchamps() {
      this.eng = -1;
      this.engo = 0;
      if (this.maxclans <= 0) {
         this.maxclans = 1000;
      }

      this.ncc = 0;
      this.champ = -1;
      int var1 = 0;
      this.conclan = new String[this.maxclans];
      this.totp = new int[this.maxclans];
      this.nvc = new int[this.maxclans];
      this.points = new int[this.maxclans][this.maxclans];
      this.verclan = new String[this.maxclans][this.maxclans];

      try {
         URL var2 = new URL("http://multiplayer.needformadness.com/interact/clanstat.txt?req=" + (int)(Math.random() * 1000.0) + "");
         var2.openConnection().setConnectTimeout(2000);
         DataInputStream var9 = new DataInputStream(var2.openStream());
         String var4 = "";

         while ((var4 = var9.readLine()) != null && this.ncc < this.maxclans) {
            this.conclan[this.ncc] = this.getSvalue(var4, 0);
            if (!this.conclan[this.ncc].equals("")) {
               this.totp[this.ncc] = 0;
               this.nvc[this.ncc] = 0;

               for (int var5 = this.getpvalue(var4, 1);
                  var5 != 0 && this.nvc[this.ncc] < this.maxclans;
                  var5 = this.getpvalue(var4, 1 + this.nvc[this.ncc] * 2)
               ) {
                  this.totp[this.ncc] = this.totp[this.ncc] + var5;
                  this.points[this.ncc][this.nvc[this.ncc]] = var5;
                  this.verclan[this.ncc][this.nvc[this.ncc]] = this.getSvalue(var4, 2 + this.nvc[this.ncc] * 2);
                  this.nvc[this.ncc]++;
               }

               if (this.totp[this.ncc] >= var1 && this.totp[this.ncc] >= 3) {
                  if (this.totp[this.ncc] == var1) {
                     this.champ = -2;
                  } else {
                     var1 = this.totp[this.ncc];
                     this.champ = this.ncc;
                  }
               }

               this.ncc++;
            }
         }

         var9.close();
         this.ord = new int[this.ncc];
         int[] var11 = new int[this.ncc];
         this.leadsby = var1;

         for (int var6 = 0; var6 < this.ncc; var6++) {
            if (var6 != this.champ && var1 - this.totp[var6] < this.leadsby) {
               this.leadsby = var1 - this.totp[var6];
            }

            var11[var6] = 0;
         }

         for (int var12 = 0; var12 < this.ncc; this.ord[var11[var12]] = var12++) {
            for (int var7 = var12 + 1; var7 < this.ncc; var7++) {
               if (this.totp[var12] < this.totp[var7]) {
                  var11[var12]++;
               } else {
                  var11[var7]++;
               }
            }
         }

         this.spos6 = 0;
         this.loadwstat = 1;
      } catch (Exception var8) {
         String var3 = "" + var8;
         if (var3.indexOf("java.io.FileNotFoundException") != -1) {
            this.loadwstat = 1;
         } else {
            this.loadwstat = -1;
         }
      }
   }

   public String contime(long var1) {
      String var3 = "";
      if (var1 != -1L) {
         try {
            long var4 = this.ntime - var1;
            if (var4 >= 1000L && var4 < 60000L) {
               var3 = "seconds ago";
            }

            if (var4 >= 60000L && var4 < 3600000L) {
               int var6 = (int)(var4 / 60000L);
               String var7 = "s";
               if (var6 == 1) {
                  var7 = "";
               }

               var3 = "" + var6 + " minute" + var7 + " ago";
            }

            if (var4 >= 3600000L && var4 < 86400000L) {
               int var9 = (int)(var4 / 3600000L);
               String var11 = "s";
               if (var9 == 1) {
                  var11 = "";
               }

               var3 = "" + var9 + " hour" + var11 + " ago";
            }

            if (var4 >= 86400000L) {
               int var10 = (int)(var4 / 86400000L);
               String var12 = "s";
               if (var10 == 1) {
                  var12 = "";
               }

               var3 = "" + var10 + " day" + var12 + " ago";
            }
         } catch (Exception var8) {
            var3 = "";
         }
      }

      return var3;
   }

   public void tlink(
      Graphics2D var1,
      int var2,
      int var3,
      String var4,
      String var5,
      int var6,
      int var7,
      boolean var8,
      int var9,
      int var10,
      int var11,
      String var12,
      String var13
   ) {
      this.ftm = this.rdo.getFontMetrics();
      int var14 = 0;
      int var15 = 0;
      int var16 = var4.indexOf(var5);
      if (var16 != -1) {
         var14 = this.ftm.stringWidth(var4.substring(0, var16)) + var2;
         var15 = var14 + this.ftm.stringWidth(var5) - 2;
      }

      this.rdo.drawLine(var14, var3 + 1, var15, var3 + 1);
      if (var6 > var14 + var9 && var6 < var15 + var9 && var7 > var3 - 11 + var10 && var7 < var3 + 1 + var10) {
         this.cur = 12;
         if (var8) {
            if (var11 == 0) {
               this.tab = 1;
               if (!this.proname.equals(var12)) {
                  this.proname = var12;
                  this.loadedp = false;
                  this.onexitpro();
               }
            }

            if (var11 == 1) {
               if (!this.claname.equals(var12)) {
                  this.claname = var12;
                  this.loadedc = false;
               }

               this.spos5 = 0;
               this.lspos5 = 0;
               this.cfase = 3;
               this.ctab = 0;
               this.tab = 3;
            }

            if (var11 == 2) {
               if (!this.claname.equals(var12)) {
                  this.claname = var12;
                  this.loadedc = false;
               }

               this.spos5 = 0;
               this.lspos5 = 0;
               this.cfase = 3;
               this.loadedlink = false;
               this.ctab = 4;
               this.tab = 3;
            }

            if (var11 == 3) {
               this.viewcar = var12;
               if (!this.claname.equals(var13)) {
                  this.claname = var13;
                  this.loadedc = false;
               }

               this.spos5 = 0;
               this.lspos5 = 0;
               this.cfase = 3;
               this.loadedcars = -1;
               this.loadedcar = 0;
               this.ctab = 2;
               this.tab = 3;
            }

            if (var11 == 4) {
               this.viewcar = var12;
               if (!this.claname.equals(var13)) {
                  this.claname = var13;
                  this.loadedc = false;
               }

               this.spos5 = 0;
               this.lspos5 = 0;
               this.cfase = 3;
               this.loadedstages = -1;
               this.loadedstage = 0;
               this.ctab = 3;
               this.tab = 3;
            }

            if (var11 == 5) {
               this.loadwstat = 0;
               this.ntab = 1;
            }
         }
      }
   }

   public void loadwarb() {
      try {
         URL var1 = new URL("http://multiplayer.needformadness.com/clans/" + this.xt.clan + "/inter.txt?req=" + (int)(Math.random() * 1000.0) + "");
         var1.openConnection().setConnectTimeout(2000);
         String var2 = var1.openConnection().getContentType();
         this.gs.warb.removeAll();
         this.gs.warb.add(this.rd, " Select  War / Battle");
         if (var2.equals("text/plain")) {
            DataInputStream var3 = new DataInputStream(var1.openStream());
            String var4 = "";
            int var5 = 0;

            boolean var6;
            for (var6 = false; (var4 = var3.readLine()) != null && var5 < 100; var5++) {
               var4 = var4.trim();
               String var7 = this.getSvalue(var4, 5);
               if (var7.equals("War")) {
                  this.gs.warb.addw(" War with " + this.getSvalue(var4, 0) + "", "" + this.getSvalue(var4, 6) + "|" + this.getSvalue(var4, 0) + "|");
                  var6 = true;
               }

               if (var7.equals("Car Battle")) {
                  this.gs.warb.addw(" Car battle with " + this.getSvalue(var4, 0) + "", "" + this.getSvalue(var4, 6) + "|" + this.getSvalue(var4, 0) + "|");
                  var6 = true;
               }

               if (var7.equals("Stage Battle")) {
                  this.gs.warb.addw(" Stage battle with " + this.getSvalue(var4, 0) + "", "" + this.getSvalue(var4, 6) + "|" + this.getSvalue(var4, 0) + "|");
                  var6 = true;
               }
            }

            var3.close();
            if (!var6) {
               this.gs.warb.removeAll();
               this.gs.warb.add(this.rd, "Your clan has not started any new wars or battles.");
            }
         } else {
            this.gs.warb.removeAll();
            this.gs.warb.add(this.rd, "Your clan has not started any wars or battles yet.");
         }
      } catch (Exception var8) {
         this.gs.warb.removeAll();
         this.gs.warb.add(this.rd, "Error occurred while loading, please try again later.");
      }

      this.gs.warb.select(0);
   }

   public void loadwgames() {
      this.canredo = false;
      this.gameturn = -1;
      this.lwbwinner = "";
      this.ascore = 0;
      this.vscore = 0;
      this.gs.pgame.removeAll();
      this.gs.pgame.add(this.rd, " Select Game");
      byte var1 = 5;
      String var2 = "battle";
      this.warb = 2;
      if (this.gs.warb.sopts[this.gs.warb.sel].startsWith(" War with")) {
         var1 = 9;
         var2 = "war";
         this.warb = 1;
      }

      if (this.gs.warb.sopts[this.gs.warb.sel].startsWith(" Stage battle with")) {
         this.warb = 3;
      }

      this.warbnum = this.getSvalue(this.gs.warb.opts[this.gs.warb.sel], 0);
      this.vclan = this.getSvalue(this.gs.warb.opts[this.gs.warb.sel], 1);

      try {
         URL var3 = new URL("http://multiplayer.needformadness.com/interact/" + var2 + "/" + this.warbnum + ".txt?req=" + (int)(Math.random() * 1000.0) + "");
         var3.openConnection().setConnectTimeout(2000);
         String var4 = var3.openConnection().getContentType();
         if (var4.equals("text/plain")) {
            DataInputStream var5 = new DataInputStream(var3.openStream());
            String var6 = "";

            int var7;
            for (var7 = 0; (var6 = var5.readLine()) != null && var7 < var1; var7++) {
               String var8 = this.getSvalue(var6, 0);
               if (var8.startsWith("#")) {
                  int var9 = 1;

                  try {
                     var9 = Integer.valueOf(var8.substring(1));
                  } catch (Exception var14) {
                     var9 = 1;
                  }

                  this.wbstage[var7] = var9;
                  var8 = "NFM 1 - Stage " + var9 + "";
                  if (var9 > 10) {
                     var8 = "NFM 2 - Stage " + (var9 - 10) + "";
                  }

                  if (var9 > 27) {
                     var8 = "NFM Multiplayer - Stage " + (var9 - 27) + "";
                  }
               } else {
                  this.wbstage[var7] = 101;
               }

               this.wbstages[var7] = var8;
               this.wblaps[var7] = this.getvalue(var6, 1);
               this.wbcars[var7] = this.getvalue(var6, 2);
               this.wbclass[var7] = this.getvalue(var6, 3);
               this.wbfix[var7] = this.getvalue(var6, 4);
               String var18 = this.getSvalue(var6, 5);
               String var10 = "";
               if (this.wbcars[var7] == 2) {
                  var10 = ",  Clan Cars";
               }

               if (this.wbcars[var7] == 3) {
                  var10 = ",  Game Cars";
               }

               if (this.wbclass[var7] == 1) {
                  var10 = var10 + ",  Class C";
               }

               if (this.wbclass[var7] == 2) {
                  var10 = var10 + ",  Class B & C";
               }

               if (this.wbclass[var7] == 3) {
                  var10 = var10 + ",  Class B";
               }

               if (this.wbclass[var7] == 4) {
                  var10 = var10 + ",  Class A & B";
               }

               if (this.wbclass[var7] == 5) {
                  var10 = var10 + ",  Class A";
               }

               String var11 = "";
               if (this.wbfix[var7] == 1) {
                  var11 = ",  4 Fixes";
               }

               if (this.wbfix[var7] == 2) {
                  var11 = ",  3 Fixes";
               }

               if (this.wbfix[var7] == 3) {
                  var11 = ",  2 Fixes";
               }

               if (this.wbfix[var7] == 4) {
                  var11 = ",  1 Fix";
               }

               if (this.wbfix[var7] == 5) {
                  var11 = ",  No Fixing";
               }

               this.rd.setFont(new Font("Arial", 1, 12));
               this.ftm = this.rd.getFontMetrics();
               String var12 = this.wbstages[var7];

               String var13;
               for (var13 = "Game #" + (var7 + 1) + ":  " + var12 + "" + var10 + "" + var11 + ",  " + this.wblaps[var7] + " Laps";
                  this.ftm.stringWidth(var13) > 400;
                  var13 = "Game #" + (var7 + 1) + ":  " + var12 + "..." + var10 + "" + var11 + ",  " + this.wblaps[var7] + " Laps"
               ) {
                  var12 = var12.substring(0, var12.length() - 1);
               }

               if (this.gameturn == -1) {
                  if (!var18.equals("") && !var18.equals("#redo#")) {
                     if (var18.toLowerCase().equals(this.xt.clan.toLowerCase())) {
                        this.ascore++;
                     }

                     if (var18.toLowerCase().equals(this.vclan.toLowerCase())) {
                        this.vscore++;
                     }

                     this.lwbwinner = var18;
                  } else {
                     if (!var18.equals("#redo#") && var7 > 0) {
                        this.canredo = true;
                     }

                     this.gameturn = var7;
                     this.gameturndisp = var13;
                  }
               }

               this.gs.pgame.add(this.rd, " " + var13 + "");
            }

            var5.close();
            if (var7 != 0) {
               this.loadwbgames = 2;
            } else {
               this.loadwbgames = 3;
            }
         } else {
            this.loadwbgames = 4;
         }
      } catch (Exception var15) {
         this.loadwbgames = 3;
      }
   }

   public void redogame() {
      try {
         this.socket = new Socket(this.lg.servers[0], 7061);
         this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
         this.dout = new PrintWriter(this.socket.getOutputStream(), true);
         String var1 = "101|43|" + this.warb + "|" + this.warbnum + "|";
         this.dout.println(var1);
         String var2 = this.din.readLine();
         if (!var2.equals("OK")) {
            this.loadwbgames = 6;
         }

         this.socket.close();
         this.socket = null;
         this.din.close();
         this.din = null;
         this.dout.close();
         this.dout = null;
      } catch (Exception var3) {
         this.loadwbgames = 6;
      }

      if (this.loadwbgames != 6) {
         this.loadwgames();
      }
   }

   public boolean drawbutton(Image var1, int var2, int var3, int var4, int var5, boolean var6) {
      boolean var7 = false;
      boolean var8 = false;
      int var9 = var1.getWidth(this.ob);
      if (Math.abs(var4 - var2) < var9 / 2 + 12 && Math.abs(var5 - var3) < 14 && var6) {
         var8 = true;
      }

      if (Math.abs(var4 - var2) < var9 / 2 + 12 && Math.abs(var5 - var3) < 14 && this.gs.mouses <= -1) {
         var7 = true;
         this.gs.mouses = 0;
      }

      if (!var8) {
         this.rd.drawImage(var1, var2 - var9 / 2, var3 - var1.getHeight(this.ob) / 2, null);
         this.rd.drawImage(this.xt.bols, var2 - var9 / 2 - 15, var3 - 13, null);
         this.rd.drawImage(this.xt.bors, var2 + var9 / 2 + 9, var3 - 13, null);
         this.rd.drawImage(this.xt.bot, var2 - var9 / 2 - 9, var3 - 13, var9 + 18, 3, null);
         this.rd.drawImage(this.xt.bob, var2 - var9 / 2 - 9, var3 + 10, var9 + 18, 3, null);
      } else {
         this.rd.drawImage(var1, var2 - var9 / 2 + 1, var3 - var1.getHeight(this.ob) / 2 + 1, null);
         this.rd.drawImage(this.xt.bolps, var2 - var9 / 2 - 15, var3 - 13, null);
         this.rd.drawImage(this.xt.borps, var2 + var9 / 2 + 9, var3 - 13, null);
         this.rd.drawImage(this.xt.bob, var2 - var9 / 2 - 9, var3 - 13, var9 + 18, 3, null);
         this.rd.drawImage(this.xt.bot, var2 - var9 / 2 - 9, var3 + 10, var9 + 18, 3, null);
      }

      return var7;
   }

   public boolean stringbutton(Graphics2D var1, String var2, int var3, int var4, int var5, int var6, int var7, boolean var8, int var9, int var10) {
      boolean var11 = false;
      boolean var12 = false;
      var1.setFont(new Font("Arial", 1, 12));
      this.ftm = var1.getFontMetrics();
      if (var5 == 6) {
         var1.setFont(new Font("Arial", 1, 11));
         this.ftm = var1.getFontMetrics();
      }

      int var13 = this.ftm.stringWidth(var2);
      if (Math.abs(var6 - var9 - var3) < var13 / 2 + 12 && Math.abs(var7 - var10 - var4) < 14 && var8) {
         var12 = true;
      }

      if (Math.abs(var6 - var9 - var3) < var13 / 2 + 12
         && Math.abs(var7 - var10 - var4) < 14
         && this.gs.mouses <= -1
         && this.blocknote == 0
         && this.blockb == 0
         && !this.gs.openm
         && (this.editc == 0 || var9 == 0)) {
         var11 = true;
         this.gs.mouses = 0;
      }

      if (this.blocknote != 0) {
         this.blocknote--;
      }

      boolean var14 = false;
      if (var5 < 0) {
         var5 *= -1;
         var14 = true;
      }

      if (var14) {
         this.rdo.setComposite(AlphaComposite.getInstance(3, 0.7F));
      }

      if (!var12) {
         var1.setColor(this.colorb2k(var14, 220, 220, 220));
         var1.fillRect(var3 - var13 / 2 - 10, var4 - (17 - var5), var13 + 20, 25 - var5 * 2);
         var1.setColor(this.colorb2k(var14, 240, 240, 240));
         var1.drawLine(var3 - var13 / 2 - 10, var4 - (17 - var5), var3 + var13 / 2 + 10, var4 - (17 - var5));
         var1.drawLine(var3 - var13 / 2 - 10, var4 - (18 - var5), var3 + var13 / 2 + 10, var4 - (18 - var5));
         var1.drawLine(var3 - var13 / 2 - 9, var4 - (19 - var5), var3 + var13 / 2 + 9, var4 - (19 - var5));
         var1.setColor(this.colorb2k(var14, 200, 200, 200));
         var1.drawLine(var3 + var13 / 2 + 10, var4 - (17 - var5), var3 + var13 / 2 + 10, var4 + (7 - var5));
         var1.drawLine(var3 + var13 / 2 + 11, var4 - (17 - var5), var3 + var13 / 2 + 11, var4 + (7 - var5));
         var1.drawLine(var3 + var13 / 2 + 12, var4 - (16 - var5), var3 + var13 / 2 + 12, var4 + (6 - var5));
         var1.drawLine(var3 - var13 / 2 - 10, var4 + (7 - var5), var3 + var13 / 2 + 10, var4 + (7 - var5));
         var1.drawLine(var3 - var13 / 2 - 10, var4 + (8 - var5), var3 + var13 / 2 + 10, var4 + (8 - var5));
         var1.drawLine(var3 - var13 / 2 - 9, var4 + (9 - var5), var3 + var13 / 2 + 9, var4 + (9 - var5));
         var1.setColor(this.colorb2k(var14, 240, 240, 240));
         var1.drawLine(var3 - var13 / 2 - 10, var4 - (17 - var5), var3 - var13 / 2 - 10, var4 + (7 - var5));
         var1.drawLine(var3 - var13 / 2 - 11, var4 - (17 - var5), var3 - var13 / 2 - 11, var4 + (7 - var5));
         var1.drawLine(var3 - var13 / 2 - 12, var4 - (16 - var5), var3 - var13 / 2 - 12, var4 + (6 - var5));
         if (var14) {
            this.rdo.setComposite(AlphaComposite.getInstance(3, 1.0F));
         }

         var1.setColor(new Color(0, 0, 0));
         var1.drawString(var2, var3 - var13 / 2, var4);
      } else {
         var1.setColor(this.colorb2k(var14, 210, 210, 210));
         var1.fillRect(var3 - var13 / 2 - 10, var4 - (17 - var5), var13 + 20, 25 - var5 * 2);
         var1.setColor(this.colorb2k(var14, 200, 200, 200));
         var1.drawLine(var3 - var13 / 2 - 10, var4 - (17 - var5), var3 + var13 / 2 + 10, var4 - (17 - var5));
         var1.drawLine(var3 - var13 / 2 - 10, var4 - (18 - var5), var3 + var13 / 2 + 10, var4 - (18 - var5));
         var1.drawLine(var3 - var13 / 2 - 9, var4 - (19 - var5), var3 + var13 / 2 + 9, var4 - (19 - var5));
         var1.drawLine(var3 + var13 / 2 + 10, var4 - (17 - var5), var3 + var13 / 2 + 10, var4 + (7 - var5));
         var1.drawLine(var3 + var13 / 2 + 11, var4 - (17 - var5), var3 + var13 / 2 + 11, var4 + (7 - var5));
         var1.drawLine(var3 + var13 / 2 + 12, var4 - (16 - var5), var3 + var13 / 2 + 12, var4 + (6 - var5));
         var1.drawLine(var3 - var13 / 2 - 10, var4 + (7 - var5), var3 + var13 / 2 + 10, var4 + (7 - var5));
         var1.drawLine(var3 - var13 / 2 - 10, var4 + (8 - var5), var3 + var13 / 2 + 10, var4 + (8 - var5));
         var1.drawLine(var3 - var13 / 2 - 9, var4 + (9 - var5), var3 + var13 / 2 + 9, var4 + (9 - var5));
         var1.drawLine(var3 - var13 / 2 - 10, var4 - (17 - var5), var3 - var13 / 2 - 10, var4 + (7 - var5));
         var1.drawLine(var3 - var13 / 2 - 11, var4 - (17 - var5), var3 - var13 / 2 - 11, var4 + (7 - var5));
         var1.drawLine(var3 - var13 / 2 - 12, var4 - (16 - var5), var3 - var13 / 2 - 12, var4 + (6 - var5));
         if (var14) {
            this.rdo.setComposite(AlphaComposite.getInstance(3, 1.0F));
         }

         var1.setColor(new Color(0, 0, 0));
         var1.drawString(var2, var3 - var13 / 2 + 1, var4);
      }

      return var11;
   }

   public Color color2k(int var1, int var2, int var3) {
      Color var4 = new Color(var1, var2, var3);
      float[] var5 = new float[3];
      Color.RGBtoHSB(var4.getRed(), var4.getGreen(), var4.getBlue(), var5);
      var5[0] = 0.13F;
      var5[1] = 0.35F;
      return Color.getHSBColor(var5[0], var5[1], var5[2]);
   }

   public Color colorb2k(boolean var1, int var2, int var3, int var4) {
      Color var5 = new Color(var2, var3, var4);
      if (!var1) {
         float[] var6 = new float[3];
         Color.RGBtoHSB(var5.getRed(), var5.getGreen(), var5.getBlue(), var6);
         var6[0] = 0.13F;
         var6[1] = 0.35F;
         if (this.darker) {
            var6[2] *= 0.9F;
         }

         var5 = Color.getHSBColor(var6[0], var6[1], var6[2]);
      } else {
         var5 = new Color((int)(var2 * 0.9F), (int)(var3 * 0.9F), (int)(var4 * 0.9F));
      }

      return var5;
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

   public long getLvalue(String var1, int var2) {
      long var3 = -1L;

      try {
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

         if (var9.equals("")) {
            var9 = "-1";
         }

         var3 = Long.valueOf(var9);
      } catch (Exception var10) {
      }

      return var3;
   }

   public int getpvalue(String var1, int var2) {
      int var3 = 0;

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
            var8 = "0";
         }

         var3 = Integer.valueOf(var8);
      } catch (Exception var9) {
      }

      return var3;
   }

   public int getfuncvalue(String var1, String var2, int var3) {
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

      return Float.valueOf(var7).intValue();
   }

   public String getfuncSvalue(String var1, String var2, int var3) {
      String var4 = "";
      int var5 = 0;

      for (int var6 = var1.length() + 1; var6 < var2.length() && var5 <= var3; var6++) {
         String var7 = "" + var2.charAt(var6);
         if (var7.equals(",") || var7.equals(")")) {
            var5++;
         } else if (var5 == var3) {
            var4 = var4 + var7;
         }
      }

      return var4;
   }
}
