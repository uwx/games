import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Panel;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.MemoryImageSource;
import java.awt.image.PixelGrabber;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class xtGraphics extends Panel implements Runnable {
   Graphics2D rd;
   Medium m;
   CarDefine cd;
   FontMetrics ftm;
   ImageObserver ob;
   GameSparker app;
   int fase = 111;
   int oldfase = 0;
   int starcnt = 0;
   boolean mtop = false;
   int opselect = 0;
   int dropf = 0;
   int cfase = 0;
   boolean firstime = true;
   boolean shaded = false;
   int flipo = 0;
   int nextc = 0;
   int multion = 0;
   int gmode = 0;
   int[] unlocked = new int[]{1, 1};
   int[] scm = new int[]{0, 0};
   int looped = 1;
   int warning = 0;
   boolean newparts = false;
   boolean logged = false;
   boolean gotlog = false;
   boolean autolog = false;
   boolean nofull = false;
   int nfreeplays = 0;
   int ndisco = 0;
   int hours = 8;
   boolean onviewpro = false;
   int playingame = -1;
   int onjoin = -1;
   int ontyp = 0;
   boolean lan = false;
   float[] arnp = new float[]{0.5F, 0.0F, 0.0F, 1.0F, 0.5F, 0.0F};
   String nickname = "";
   String clan = "";
   String nickey = "";
   String clankey = "";
   String backlog = "";
   String server = "69.195.146.194";
   String localserver = "";
   String servername = "Madness";
   int servport = 7071;
   int gameport = 7001;
   int acexp = 0;
   int discon = 0;
   int cntptrys = 5;
   int[] delays = new int[]{600, 600, 600};
   int nplayers = 7;
   int im = 0;
   String[] plnames = new String[]{"", "", "", "", "", "", "", ""};
   int osc = 10;
   int minsl = 0;
   int maxsl = 15;
   int[] sc = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
   int[] xstart = new int[]{0, -350, 350, 0, -350, 350, 0, 0};
   int[] zstart = new int[]{-760, -380, -380, 0, 380, 380, 760, 0};
   float[][] allrnp = new float[8][6];
   boolean[] isbot = new boolean[8];
   int clangame = 0;
   boolean clanchat = false;
   String[] pclan = new String[]{"", "", "", "", "", "", "", ""};
   String gaclan = "";
   int lcarx = 0;
   int lcary = 0;
   int lcarz = 0;
   int[] dcrashes = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
   int beststunt = 0;
   int laptime = 0;
   int fastestlap = 0;
   int sendstat = 0;
   int testdrive = 0;
   boolean holdit = false;
   int holdcnt = 0;
   boolean winner = true;
   int[] flexpix = null;
   int[] smokey = new int[94132];
   Image fleximg;
   int flatrstart = 0;
   Thread runner;
   int runtyp = 0;
   int forstart = 0;
   int exitm = 0;
   Image odmg;
   Image opwr;
   Image opos;
   Image osped;
   Image owas;
   Image olap;
   Image oyourwasted;
   Image odisco;
   Image ogamefinished;
   Image oyoulost;
   Image oyouwon;
   Image oyouwastedem;
   Image ogameh;
   Image owgame;
   Image oloadingmusic;
   Image oflaot;
   Image oexitgame;
   Image mload;
   Image dmg;
   Image pwr;
   Image pos;
   Image sped;
   Image was;
   Image lap;
   Image br;
   Image select;
   Image loadingmusic;
   Image yourwasted;
   Image disco;
   Image gamefinished;
   Image youlost;
   Image youwon;
   Image youwastedem;
   Image gameh;
   Image wgame;
   Image congrd;
   Image gameov;
   Image carsbg;
   Image carsbgc;
   Image selectcar;
   Image statb;
   Image statbo;
   Image mdness;
   Image paused;
   Image radicalplay;
   Image logocars;
   Image logomadnes;
   Image logomadbg;
   Image byrd;
   Image bggo;
   Image opback;
   Image nfmcoms;
   Image opti;
   Image opti2;
   Image bgmain;
   Image rpro;
   Image nfmcom;
   Image flaot;
   Image brt;
   Image arn;
   Image exitgame;
   Image pgate;
   Image fixhoop;
   Image sarrow;
   Image stunts;
   Image racing;
   Image wasting;
   Image plus;
   Image space;
   Image arrows;
   Image chil;
   Image ory;
   Image kz;
   Image kx;
   Image kv;
   Image km;
   Image kn;
   Image ks;
   Image kenter;
   Image nfm;
   Image login;
   Image register;
   Image play;
   Image sdets;
   Image cancel;
   Image bob;
   Image bot;
   Image bol;
   Image bolp;
   Image bor;
   Image borp;
   Image logout;
   Image change;
   Image pln;
   Image pon;
   Image dome;
   Image upgrade;
   Image bols;
   Image bolps;
   Image bors;
   Image borps;
   Image games;
   Image exit;
   Image chat;
   Image players;
   Image cgame;
   Image ccar;
   Image lanm;
   Image asu;
   Image asd;
   Image pls;
   Image sts;
   Image gmc;
   Image stg;
   Image crd;
   Image roomp;
   Image myfr;
   Image mycl;
   Image cnmc;
   Image redy;
   Image ntrg;
   Image[] bcl = new Image[2];
   Image[] bcr = new Image[2];
   Image[] bc = new Image[2];
   Image cmc;
   Image myc;
   Image gac;
   Image yac;
   Image ycmc;
   Image top20s;
   Image[] trackbg = new Image[2];
   Image[] dude = new Image[3];
   int duds = 0;
   int dudo = 0;
   Image[] next = new Image[2];
   Image[] back = new Image[2];
   Image[] contin = new Image[2];
   Image[] ostar = new Image[2];
   Image[] star = new Image[3];
   int pcontin = 0;
   int pnext = 0;
   int pback = 0;
   int pstar = 0;
   Image[] orank = new Image[8];
   Image[] rank = new Image[8];
   Image[] ocntdn = new Image[4];
   Image[] cntdn = new Image[4];
   int gocnt = 0;
   soundClip[][] engs = new soundClip[5][5];
   boolean[] pengs = new boolean[5];
   soundClip[] air = new soundClip[6];
   boolean aird = false;
   boolean grrd = false;
   soundClip[] crash = new soundClip[3];
   soundClip[] lowcrash = new soundClip[3];
   soundClip tires;
   soundClip checkpoint;
   soundClip carfixed;
   soundClip powerup;
   soundClip three;
   soundClip two;
   soundClip one;
   soundClip go;
   soundClip wastd;
   soundClip firewasted;
   boolean pwastd = false;
   soundClip[] skid = new soundClip[3];
   soundClip[] dustskid = new soundClip[3];
   soundClip[] scrape = new soundClip[4];
   boolean mutes = false;
   RadicalMod intertrack;
   RadicalMod strack;
   boolean loadedt = false;
   boolean mutem = false;
   boolean badmac = false;
   boolean arrace = false;
   int alocked = -1;
   int lalocked = -1;
   int cntflock = 0;
   boolean onlock = false;
   int ana = 0;
   int cntan = 0;
   int cntovn = 0;
   boolean flk = false;
   int tcnt = 30;
   boolean tflk = false;
   String say = "";
   boolean wasay = false;
   int clear = 0;
   int posit = 0;
   int wasted = 0;
   int laps = 0;
   int[] dested = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
   int dmcnt = 0;
   boolean dmflk = false;
   int pwcnt = 0;
   boolean pwflk = false;
   String[][] adj = new String[][]{
      {"Cool", "Alright", "Nice"},
      {"Wicked", "Amazing", "Super"},
      {"Awesome", "Ripping", "Radical"},
      {"What the...?", "You're a super star!!!!", "Who are you again...?"},
      {"surf style", "off the lip", "bounce back"}
   };
   String[] exlm = new String[]{"!", "!!", "!!!"};
   String loop = "";
   String spin = "";
   String asay = "";
   int auscnt = 45;
   boolean aflk = false;
   int[] sndsize = new int[]{
      39, 128, 23, 58, 106, 140, 81, 135, 38, 141, 106, 76, 56, 116, 92, 208, 70, 80, 152, 102, 27, 65, 52, 30, 151, 129, 80, 44, 57, 123, 202, 210, 111
   };
   Image hello;
   Image sign;
   Image loadbar;
   int kbload = 0;
   int dnload = 0;
   float shload = 0.0F;
   Socket socket;
   BufferedReader din;
   PrintWriter dout;
   int radpx = 212;
   int pin = 60;
   int[] trkx = new int[]{65, 735};
   int trkl = 0;
   int trklim = (int)(Math.random() * 40.0);
   int lmode = 0;
   int[] bgmy = new int[]{0, -400};
   float bgf = 0.0F;
   boolean bgup = false;
   int[] ovx = new int[]{0, 0, 0, 0};
   int[] ovy = new int[]{0, 0, 0, 0};
   int[] ovw = new int[]{0, 0, 0, 0};
   int[] ovh = new int[]{0, 0, 0, 0};
   int[] ovsx = new int[]{0, 0, 0, 0};
   int removeds = 0;
   int nfmtab = 0;
   boolean justwon1 = false;
   boolean justwon2 = false;
   int lfrom = 0;
   int lockcnt = 0;
   boolean showtf = false;
   int ransay = 0;
   String[][] cnames = new String[][]{{"", "", "", "", "", "", "Game Chat  "}, {"", "", "", "", "", "", "Your Clan's Chat  "}};
   String[][] sentn = new String[][]{{"", "", "", "", "", "", ""}, {"", "", "", "", "", "", ""}};
   int[] updatec = new int[]{-1, -1};
   int[] movepos = new int[]{0, 0};
   int[] pointc = new int[]{6, 6};
   int[] floater = new int[]{0, 0};
   int[] cntchatp = new int[]{0, 0};
   int[] msgflk = new int[]{0, 0};
   String[] lcmsg = new String[]{"", ""};
   int flkat = 0;
   int movly = 0;
   int gxdu = 0;
   int gydu = 0;
   int muhi = 0;
   int lsc = -1;
   int mouson = -1;
   int onmsc = -1;
   boolean remi = false;
   int basefase = 0;
   boolean noclass = false;
   int gatey = 300;
   int[] pgatx = new int[]{211, 240, 280, 332, 399, 466, 517, 558, 586};
   int[] pgaty = new int[]{193, 213, 226, 237, 244, 239, 228, 214, 196};
   int[] pgady = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
   boolean[] pgas = new boolean[]{false, false, false, false, false, false, false, false, false};
   int waitlink = 0;
   int lxm = -10;
   int lym = -10;
   int pwait = 7;
   int stopcnt = 0;
   int cntwis = 0;
   int lcn = 0;
   int crshturn = 0;
   int bfcrash = 0;
   int bfskid = 0;
   boolean crashup = false;
   boolean skidup = false;
   int skflg = 0;
   int dskflg = 0;
   int bfscrape = 0;
   int sturn0 = 0;
   int sturn1 = 0;
   int bfsc1 = 0;
   int bfsc2 = 0;
   int flatr = 0;
   int flyr = 0;
   int flyrdest = 0;
   int flang = 0;

   public xtGraphics(Medium var1, CarDefine var2, Graphics2D var3, GameSparker var4) {
      this.m = var1;
      this.cd = var2;
      this.app = var4;
      this.rd = var3;
      this.hello = this.getImage("data/hello.gif");
      this.sign = this.getImage("data/sign.gif");
      this.loadbar = this.getImage("data/loadbar.gif");

      for (int var5 = 0; var5 < 5; var5++) {
         this.pengs[var5] = false;
      }

      this.nofull = false;
      SecurityManager var9 = System.getSecurityManager();
      if (var9 != null) {
         try {
            var9.checkConnect("needformadness.com", -1);
         } catch (Exception var8) {
            String var7 = "" + var8;
            if (var7.indexOf("access denied") != -1) {
               this.nofull = true;
            }
         }
      }

      this.badmac = false;
   }

   public void loaddata() {
      this.kbload = 637;
      this.runtyp = 176;
      this.runner = new Thread(this);
      this.runner.start();
      this.loadimages();
      this.intertrack = new RadicalMod("music/interface.zip");
      this.dnload += 44;
      this.loadsounds();
   }

   public void loadsounds() {
      this.dnload += 3;

      try {
         File var1 = new File("" + Madness.fpath + "data/sounds.zip");
         FileInputStream var2 = new FileInputStream(var1);
         ZipInputStream var3 = new ZipInputStream(var2);

         for (ZipEntry var4 = var3.getNextEntry(); var4 != null; var4 = var3.getNextEntry()) {
            int var5 = (int)var4.getSize();
            String var6 = var4.getName();
            byte[] var7 = new byte[var5];
            int var8 = 0;

            while (var5 > 0) {
               int var9 = var3.read(var7, var8, var5);
               var8 += var9;
               var5 -= var9;
            }

            for (int var10 = 0; var10 < 5; var10++) {
               for (int var11 = 0; var11 < 5; var11++) {
                  if (var6.equals("" + var11 + "" + var10 + ".wav")) {
                     this.engs[var11][var10] = new soundClip(var7);
                  }
               }
            }

            for (int var13 = 0; var13 < 6; var13++) {
               if (var6.equals("air" + var13 + ".wav")) {
                  this.air[var13] = new soundClip(var7);
               }
            }

            for (int var14 = 0; var14 < 3; var14++) {
               if (var6.equals("crash" + (var14 + 1) + ".wav")) {
                  this.crash[var14] = new soundClip(var7);
               }
            }

            for (int var15 = 0; var15 < 3; var15++) {
               if (var6.equals("lowcrash" + (var15 + 1) + ".wav")) {
                  this.lowcrash[var15] = new soundClip(var7);
               }
            }

            for (int var16 = 0; var16 < 3; var16++) {
               if (var6.equals("skid" + (var16 + 1) + ".wav")) {
                  this.skid[var16] = new soundClip(var7);
               }
            }

            for (int var17 = 0; var17 < 3; var17++) {
               if (var6.equals("dustskid" + (var17 + 1) + ".wav")) {
                  this.dustskid[var17] = new soundClip(var7);
               }
            }

            for (int var18 = 0; var18 < 3; var18++) {
               if (var6.equals("scrape" + (var18 + 1) + ".wav")) {
                  this.scrape[var18] = new soundClip(var7);
                  if (var18 == 2) {
                     this.scrape[3] = new soundClip(var7);
                  }
               }
            }

            if (var6.equals("powerup.wav")) {
               this.powerup = new soundClip(var7);
            }

            if (var6.equals("tires.wav")) {
               this.tires = new soundClip(var7);
            }

            if (var6.equals("checkpoint.wav")) {
               this.checkpoint = new soundClip(var7);
            }

            if (var6.equals("carfixed.wav")) {
               this.carfixed = new soundClip(var7);
            }

            if (var6.equals("three.wav")) {
               this.three = new soundClip(var7);
            }

            if (var6.equals("two.wav")) {
               this.two = new soundClip(var7);
            }

            if (var6.equals("one.wav")) {
               this.one = new soundClip(var7);
            }

            if (var6.equals("go.wav")) {
               this.go = new soundClip(var7);
            }

            if (var6.equals("wasted.wav")) {
               this.wastd = new soundClip(var7);
            }

            if (var6.equals("firewasted.wav")) {
               this.firewasted = new soundClip(var7);
            }

            this.dnload += 5;
         }

         var2.close();
         var3.close();
      } catch (Exception var12) {
         System.out.println("Error Loading Sounds: " + var12);
      }

      System.gc();
   }

   public void loadimages() {
      Toolkit var1 = Toolkit.getDefaultToolkit();
      MediaTracker var2 = new MediaTracker(this.app);
      Image var3 = null;
      Image var4 = null;
      this.dnload += 8;

      try {
         File var5 = new File("" + Madness.fpath + "data/images.zip");
         FileInputStream var6 = new FileInputStream(var5);
         ZipInputStream var7 = new ZipInputStream(var6);

         for (ZipEntry var8 = var7.getNextEntry(); var8 != null; var8 = var7.getNextEntry()) {
            int var9 = (int)var8.getSize();
            String var10 = var8.getName();
            byte[] var11 = new byte[var9];
            int var12 = 0;

            while (var9 > 0) {
               int var13 = var7.read(var11, var12, var9);
               var12 += var13;
               var9 -= var13;
            }

            if (var10.equals("cars.gif")) {
               this.carsbg = this.loadBimage(var11, var2, var1, 1);
            }

            if (var10.equals("color.gif")) {
               var3 = this.loadBimage(var11, var2, var1, 0);
            }

            if (var10.equals("class.gif")) {
               var4 = this.loadBimage(var11, var2, var1, 0);
            }

            if (var10.equals("smokey.gif")) {
               this.smokeypix(var11, var2, var1);
            }

            if (var10.equals("1.gif")) {
               this.orank[0] = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("gameh.gif")) {
               this.ogameh = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("wgame.gif")) {
               this.owgame = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("gameov.gif")) {
               this.gameov = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("lap.gif")) {
               this.olap = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("paused.gif")) {
               this.paused = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("select.gif")) {
               this.select = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("yourwasted.gif")) {
               this.oyourwasted = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("disco.gif")) {
               this.odisco = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("youwastedem.gif")) {
               this.oyouwastedem = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("gamefinished.gif")) {
               this.ogamefinished = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("exitgame.gif")) {
               this.oexitgame = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("pgate.gif")) {
               this.pgate = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("d1.png")) {
               this.dude[0] = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("d2.png")) {
               this.dude[1] = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("d3.png")) {
               this.dude[2] = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("float.gif")) {
               this.oflaot = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("1c.gif")) {
               this.ocntdn[1] = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("2c.gif")) {
               this.ocntdn[2] = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("3c.gif")) {
               this.ocntdn[3] = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("2.gif")) {
               this.orank[1] = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("3.gif")) {
               this.orank[2] = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("4.gif")) {
               this.orank[3] = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("5.gif")) {
               this.orank[4] = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("6.gif")) {
               this.orank[5] = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("7.gif")) {
               this.orank[6] = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("8.gif")) {
               this.orank[7] = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("bgmain.jpg")) {
               this.bgmain = this.loadBimage(var11, var2, var1, 2);
            }

            if (var10.equals("br.png")) {
               this.br = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("loadingmusic.gif")) {
               this.oloadingmusic = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("radicalplay.gif")) {
               this.radicalplay = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("back.gif")) {
               this.back[0] = this.loadimage(var11, var2, var1);
               this.back[1] = this.bressed(this.back[0]);
            }

            if (var10.equals("continue.gif")) {
               this.contin[0] = this.loadimage(var11, var2, var1);
               this.contin[1] = this.bressed(this.contin[0]);
            }

            if (var10.equals("next.gif")) {
               this.next[0] = this.loadimage(var11, var2, var1);
               this.next[1] = this.bressed(this.next[0]);
            }

            if (var10.equals("rpro.gif")) {
               this.rpro = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("selectcar.gif")) {
               this.selectcar = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("track.jpg")) {
               this.trackbg[0] = this.loadBimage(var11, var2, var1, 3);
               this.trackbg[1] = this.dodgen(this.trackbg[0]);
            }

            if (var10.equals("youlost.gif")) {
               this.oyoulost = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("youwon.gif")) {
               this.oyouwon = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("0c.gif")) {
               this.ocntdn[0] = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("damage.gif")) {
               this.odmg = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("power.gif")) {
               this.opwr = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("position.gif")) {
               this.opos = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("speed.gif")) {
               this.osped = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("wasted.gif")) {
               this.owas = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("start1.gif")) {
               this.ostar[0] = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("start2.gif")) {
               this.ostar[1] = this.loadimage(var11, var2, var1);
               this.star[2] = this.pressed(this.ostar[1]);
            }

            if (var10.equals("congrad.gif")) {
               this.congrd = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("statb.gif")) {
               this.statb = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("statbo.gif")) {
               this.statbo = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("madness.gif")) {
               this.mdness = this.loadude(var11, var2, var1);
            }

            if (var10.equals("fixhoop.png")) {
               this.fixhoop = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("arrow.gif")) {
               this.sarrow = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("stunts.png")) {
               this.stunts = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("racing.gif")) {
               this.racing = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("wasting.gif")) {
               this.wasting = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("plus.gif")) {
               this.plus = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("space.gif")) {
               this.space = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("arrows.gif")) {
               this.arrows = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("chil.gif")) {
               this.chil = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("ory.gif")) {
               this.ory = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("kz.gif")) {
               this.kz = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("kx.gif")) {
               this.kx = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("kv.gif")) {
               this.kv = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("km.gif")) {
               this.km = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("kn.gif")) {
               this.kn = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("ks.gif")) {
               this.ks = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("kenter.gif")) {
               this.kenter = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("nfm.gif")) {
               this.nfm = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("options.png")) {
               this.opti = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("options2.png")) {
               this.opti2 = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("opback.png")) {
               this.opback = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("logocars.png")) {
               this.logocars = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("logomad.png")) {
               this.logomadnes = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("logomadbg.jpg")) {
               this.logomadbg = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("byrd.png")) {
               this.byrd = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("bggo.jpg")) {
               this.bggo = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("nfmcoms.png")) {
               this.nfmcoms = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("nfmcom.gif")) {
               this.nfmcom = this.loadBimage(var11, var2, var1, 0);
            }

            if (var10.equals("brit.gif")) {
               this.brt = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("arn.gif")) {
               this.arn = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("mload.gif")) {
               this.mload = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("login.gif")) {
               this.login = this.loadBimage(var11, var2, var1, 0);
            }

            if (var10.equals("play.gif")) {
               this.play = this.loadBimage(var11, var2, var1, 0);
            }

            if (var10.equals("cancel.gif")) {
               this.cancel = this.loadBimage(var11, var2, var1, 0);
            }

            if (var10.equals("dome.gif")) {
               this.dome = this.loadBimage(var11, var2, var1, 0);
            }

            if (var10.equals("register.gif")) {
               this.register = this.loadBimage(var11, var2, var1, 0);
            }

            if (var10.equals("upgrade.gif")) {
               this.upgrade = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("sdets.gif")) {
               this.sdets = this.loadBimage(var11, var2, var1, 0);
            }

            if (var10.equals("bob.gif")) {
               this.bob = this.loadBimage(var11, var2, var1, 1);
            }

            if (var10.equals("bot.gif")) {
               this.bot = this.loadBimage(var11, var2, var1, 1);
            }

            if (var10.equals("bol.gif")) {
               this.bol = this.loadBimage(var11, var2, var1, 0);
            }

            if (var10.equals("bolp.gif")) {
               this.bolp = this.loadBimage(var11, var2, var1, 0);
            }

            if (var10.equals("bor.gif")) {
               this.bor = this.loadBimage(var11, var2, var1, 0);
            }

            if (var10.equals("borp.gif")) {
               this.borp = this.loadBimage(var11, var2, var1, 0);
            }

            if (var10.equals("logout.gif")) {
               this.logout = this.loadBimage(var11, var2, var1, 0);
            }

            if (var10.equals("change.gif")) {
               this.change = this.loadBimage(var11, var2, var1, 0);
            }

            if (var10.equals("pln.gif")) {
               this.pln = this.loadBimage(var11, var2, var1, 0);
            }

            if (var10.equals("pon.gif")) {
               this.pon = this.loadBimage(var11, var2, var1, 0);
            }

            if (var10.equals("bols.gif")) {
               this.bols = this.loadBimage(var11, var2, var1, 0);
            }

            if (var10.equals("bolps.gif")) {
               this.bolps = this.loadBimage(var11, var2, var1, 0);
            }

            if (var10.equals("bors.gif")) {
               this.bors = this.loadBimage(var11, var2, var1, 0);
            }

            if (var10.equals("borps.gif")) {
               this.borps = this.loadBimage(var11, var2, var1, 0);
            }

            if (var10.equals("games.gif")) {
               this.games = this.loadBimage(var11, var2, var1, 0);
            }

            if (var10.equals("exit.gif")) {
               this.exit = this.loadBimage(var11, var2, var1, 0);
            }

            if (var10.equals("chat.gif")) {
               this.chat = this.loadBimage(var11, var2, var1, 0);
            }

            if (var10.equals("players.gif")) {
               this.players = this.loadBimage(var11, var2, var1, 0);
            }

            if (var10.equals("roomp.gif")) {
               this.roomp = this.loadBimage(var11, var2, var1, 0);
            }

            if (var10.equals("myfr.gif")) {
               this.myfr = this.loadBimage(var11, var2, var1, 0);
            }

            if (var10.equals("mycl.gif")) {
               this.mycl = this.loadBimage(var11, var2, var1, 0);
            }

            if (var10.equals("cnmc.gif")) {
               this.cnmc = this.loadBimage(var11, var2, var1, 0);
            }

            if (var10.equals("ready.gif")) {
               this.redy = this.loadBimage(var11, var2, var1, 0);
            }

            if (var10.equals("notreg.gif")) {
               this.ntrg = this.loadBimage(var11, var2, var1, 0);
            }

            if (var10.equals("cgame.gif")) {
               this.cgame = this.loadBimage(var11, var2, var1, 0);
            }

            if (var10.equals("ccar.gif")) {
               this.ccar = this.loadBimage(var11, var2, var1, 0);
            }

            if (var10.equals("lanm.gif")) {
               this.lanm = this.loadBimage(var11, var2, var1, 0);
            }

            if (var10.equals("asu.gif")) {
               this.asu = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("asd.gif")) {
               this.asd = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("pls.gif")) {
               this.pls = this.loadBimage(var11, var2, var1, 0);
            }

            if (var10.equals("sts.gif")) {
               this.sts = this.loadBimage(var11, var2, var1, 0);
            }

            if (var10.equals("gmc.gif")) {
               this.gmc = this.loadBimage(var11, var2, var1, 0);
            }

            if (var10.equals("stg.gif")) {
               this.stg = this.loadBimage(var11, var2, var1, 0);
            }

            if (var10.equals("crd.gif")) {
               this.crd = this.loadBimage(var11, var2, var1, 0);
            }

            if (var10.equals("bcl.gif")) {
               this.bcl[0] = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("bcr.gif")) {
               this.bcr[0] = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("bc.gif")) {
               this.bc[0] = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("pbcl.gif")) {
               this.bcl[1] = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("pbcr.gif")) {
               this.bcr[1] = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("pbc.gif")) {
               this.bc[1] = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("cmc.gif")) {
               this.cmc = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("myc.gif")) {
               this.myc = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("gac.gif")) {
               this.gac = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("yac.gif")) {
               this.yac = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("ycmc.gif")) {
               this.ycmc = this.loadimage(var11, var2, var1);
            }

            if (var10.equals("top20s.gif")) {
               this.top20s = this.loadimage(var11, var2, var1);
            }

            this.dnload += 2;
         }

         var6.close();
         var7.close();
      } catch (Exception var14) {
         System.out.println("Error Loading Images: " + var14);
      }

      this.makecarsbgc(var3, var4);
      System.gc();
   }

   @Override
   public void run() {
      boolean var1 = false;

      while (this.runtyp > 0) {
         if (this.runtyp >= 1 && this.runtyp <= 140) {
            this.hipnoload(this.runtyp, false);
         }

         if (this.runtyp == 176) {
            this.loading();
            var1 = true;
         }

         this.app.repaint();

         try {
            Thread.sleep(20L);
         } catch (InterruptedException var17) {
         }
      }

      if (var1) {
//         this.pingstat();
         var1 = false;
      }

      boolean[] var2 = new boolean[]{true, true};

      while ((this.runtyp == -101 || this.sendstat == 1) && !this.lan) {
         String var3 = "3|" + this.playingame + "|" + this.updatec[0] + "|";
         if (this.clanchat) {
            var3 = var3 + "" + this.updatec[1] + "|" + this.clan + "|" + this.clankey + "|";
         } else {
            var3 = var3 + "0|||";
         }

         if (this.updatec[0] <= -11) {
            for (int var4 = 0; var4 < -this.updatec[0] - 10; var4++) {
               var3 = var3 + "" + this.cnames[0][6 - var4] + "|" + this.sentn[0][6 - var4] + "|";
            }

            this.updatec[0] = -2;
         }

         if (this.clanchat && this.updatec[1] <= -11) {
            for (int var21 = 0; var21 < -this.updatec[1] - 10; var21++) {
               var3 = var3 + "" + this.cnames[1][6 - var21] + "|" + this.sentn[1][6 - var21] + "|";
            }

            this.updatec[1] = -2;
         }

         if (this.sendstat == 1) {
            var3 = "5|" + this.playingame + "|" + this.im + "|" + this.beststunt + "|" + this.fastestlap + "|";

            for (int var22 = 0; var22 < this.nplayers; var22++) {
               var3 = var3 + "" + this.dcrashes[var22] + "|";
            }

            this.sendstat = 2;
         }

         boolean var23 = false;
         String var5 = "";

         try {
            this.dout.println(var3);
            var5 = this.din.readLine();
            if (var5 == null) {
               var23 = true;
            }
         } catch (Exception var16) {
            var23 = true;
         }

         if (var23) {
            try {
               this.socket.close();
               this.socket = null;
               this.din.close();
               this.din = null;
               this.dout.close();
               this.dout = null;
            } catch (Exception var15) {
            }

            try {
               this.socket = new Socket(this.server, this.servport);
               this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
               this.dout = new PrintWriter(this.socket.getOutputStream(), true);
               this.dout.println(var3);
               var5 = this.din.readLine();
               if (var5 != null) {
                  var23 = false;
               }
            } catch (Exception var14) {
            }
         }

         if (var23) {
            try {
               this.socket.close();
               this.socket = null;
            } catch (Exception var13) {
            }

            this.runtyp = 0;
            if (this.app.cmsg.isShowing()) {
               this.app.cmsg.hide();
               this.app.requestFocus();
            }

            this.runner.stop();
         }

         if (this.sendstat != 2) {
            int var6 = 2;
            byte var7 = 1;
            if (this.clanchat) {
               var7 = 2;
            }

            for (int var8 = 0; var8 < var7; var8++) {
               int var9 = this.getvalue(var5, var8);
               if (this.updatec[var8] != var9 && this.updatec[var8] >= -2 && this.pointc[var8] == 6) {
                  for (int var10 = 0; var10 < 7; var10++) {
                     this.cnames[var8][var10] = this.getSvalue(var5, var6);
                     this.sentn[var8][var10] = this.getSvalue(var5, ++var6);
                     var6++;
                  }

                  if (this.cnames[var8][6].equals("")) {
                     if (var8 == 0) {
                        this.cnames[var8][6] = "Game Chat  ";
                     } else {
                        this.cnames[var8][6] = "" + this.clan + "'s Chat  ";
                     }
                  }

                  if (this.updatec[var8] != -2) {
                     this.floater[var8] = 1;
                     if (var2[var8]) {
                        this.msgflk[var8] = 67;
                        var2[var8] = false;
                     } else {
                        this.msgflk[var8] = 110;
                     }
                  }

                  this.updatec[var8] = var9;
               }
            }
         } else {
            this.sendstat = 3;
         }

         try {
            Thread.sleep(1000L);
         } catch (InterruptedException var12) {
         }
      }

      if (this.runtyp == -167 || this.runtyp == -168) {
         try {
            this.socket = new Socket("69.195.146.194", 7061);
            this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            this.dout = new PrintWriter(this.socket.getOutputStream(), true);
            this.dout.println("101|" + (this.runtyp + 174) + "|" + this.app.tnick.getText() + "|" + this.app.tpass.getText() + "|");
            String var20 = this.din.readLine();
            this.socket.close();
            this.socket = null;
            this.din.close();
            this.din = null;
            this.dout.close();
            this.dout = null;
         } catch (Exception var11) {
         }

         this.runtyp = 0;
      }

      if (this.runtyp == -166 || this.runtyp == -167 || this.runtyp == -168) {
         this.pingstat();
      }
   }

   public void stopchat() {
      this.clanchat = false;
      this.clangame = 0;
      if (this.runtyp == -101) {
         this.runtyp = 0;

         try {
            this.socket.close();
            this.socket = null;
            this.din.close();
            this.din = null;
            this.dout.close();
            this.dout = null;
         } catch (Exception var2) {
         }
      }
   }

   public void sendwin(CheckPoints var1) {
      if (!this.logged || this.multion != 1 || !this.winner) {
         this.runtyp = -166;
      } else if (var1.wasted == this.nplayers - 1) {
         this.runtyp = -167;
      } else {
         this.runtyp = -168;
      }

      this.runner = new Thread(this);
      this.runner.start();
   }

   public void loading() {
      this.rd.setColor(new Color(0, 0, 0));
      this.rd.fillRect(0, 0, 800, 450);
      this.rd.drawImage(this.sign, 362, 35, this);
      this.rd.drawImage(this.hello, 125, 105, this);
      this.rd.setColor(new Color(198, 214, 255));
      this.rd.fillRoundRect(250, 340, 300, 80, 30, 70);
      this.rd.setColor(new Color(128, 167, 255));
      this.rd.drawRoundRect(250, 340, 300, 80, 30, 70);
      this.rd.drawImage(this.loadbar, 281, 365, this);
      this.rd.setFont(new Font("Arial", 1, 11));
      this.ftm = this.rd.getFontMetrics();
      this.drawcs(358, "Loading game, please wait.", 0, 0, 0, 3);
      this.rd.setColor(new Color(255, 255, 255));
      this.rd.fillRect(295, 398, 210, 17);
      this.shload = this.shload + (this.dnload + 10.0F - this.shload) / 100.0F;
      if (this.shload > this.kbload) {
         this.shload = this.kbload;
      }

      if (this.dnload == this.kbload) {
         this.shload = this.kbload;
      }

      this.drawcs(
         410,
         "" + (int)((26.0F + this.shload / this.kbload * 200.0F) / 226.0F * 100.0F) + " % loaded    |    " + (this.kbload - (int)this.shload) + " KB remaining",
         32,
         64,
         128,
         3
      );
      this.rd.setColor(new Color(32, 64, 128));
      this.rd.fillRect(287, 371, 26 + (int)(this.shload / this.kbload * 200.0F), 10);
   }

   public void stoploading() {
      this.loading();
      this.app.repaint();
      this.runtyp = 0;
   }

   public void clicknow() {
      this.rd.setColor(new Color(198, 214, 255));
      this.rd.fillRoundRect(250, 340, 300, 80, 30, 70);
      this.rd.setColor(new Color(128, 167, 255));
      this.rd.drawRoundRect(250, 340, 300, 80, 30, 70);
      if (this.aflk) {
         this.drawcs(380, "Click here to Start", 0, 0, 0, 3);
         this.aflk = false;
      } else {
         this.drawcs(380, "Click here to Start", 0, 67, 200, 3);
         this.aflk = true;
      }
   }

   public void stopallnow() {
      if (this.runner != null) {
         this.runner.stop();
         this.runner = null;
      }

      this.runtyp = 0;
      if (this.loadedt) {
         this.strack.unload();
         this.strack = null;
         this.loadedt = false;
      }

      for (int var1 = 0; var1 < 5; var1++) {
         for (int var2 = 0; var2 < 5; var2++) {
            this.engs[var1][var2].stop();
            this.engs[var1][var2] = null;
         }
      }

      for (int var3 = 0; var3 < 6; var3++) {
         this.air[var3].stop();
         this.air[var3] = null;
      }

      this.wastd.stop();
      this.intertrack.unload();
      this.intertrack = null;
   }

   public void resetstat(int var1) {
      this.arrace = false;
      this.alocked = -1;
      this.lalocked = -1;
      this.cntflock = 90;
      this.onlock = false;
      this.ana = 0;
      this.cntan = 0;
      this.cntovn = 0;
      this.tcnt = 30;
      this.wasay = false;
      this.clear = 0;
      this.dmcnt = 0;
      this.pwcnt = 0;
      this.auscnt = 45;
      this.pnext = 0;
      this.pback = 0;
      this.starcnt = 130;
      this.gocnt = 3;
      this.grrd = true;
      this.aird = true;
      this.bfcrash = 0;
      this.bfscrape = 0;
      this.cntwis = 0;
      this.bfskid = 0;
      this.pwait = 7;
      this.forstart = 200;
      this.exitm = 0;
      this.holdcnt = 0;
      this.holdit = false;
      this.winner = false;
      this.wasted = 0;

      for (int var2 = 0; var2 < 8; var2++) {
         this.dested[var2] = 0;
         this.isbot[var2] = false;
         this.dcrashes[var2] = 0;
      }

      this.runtyp = 0;
      this.discon = 0;
      this.dnload = 0;
      this.beststunt = 0;
      this.laptime = 0;
      this.fastestlap = 0;
      this.sendstat = 0;
      if (this.fase == 2 || this.fase == -22) {
         this.sortcars(var1);
      }

      if (this.fase == 22) {
         for (int var4 = 0; var4 < 2; var4++) {
            for (int var3 = 0; var3 < 7; var3++) {
               this.cnames[var4][var3] = "";
               this.sentn[var4][var3] = "";
            }

            if (var4 == 0) {
               this.cnames[var4][6] = "Game Chat  ";
            } else {
               this.cnames[var4][6] = "" + this.clan + "'s Chat  ";
            }

            this.updatec[var4] = -1;
            this.movepos[var4] = 0;
            this.pointc[var4] = 6;
            this.floater[var4] = 0;
            this.cntchatp[var4] = 0;
            this.msgflk[var4] = 0;
            this.lcmsg[var4] = "";
         }

         if (this.multion == 3) {
            this.ransay = 4;
         } else if (this.ransay == 0) {
            this.ransay = 1 + (int)(Math.random() * 3.0);
         } else {
            this.ransay++;
            if (this.ransay > 3) {
               this.ransay = 1;
            }
         }
      }
   }

   public void setbots(boolean[] var1, int[][] var2) {
      for (int var3 = 0; var3 < this.nplayers; var3++) {
         if (this.plnames[var3].indexOf("MadBot") != -1) {
            var1[var3] = true;
            this.isbot[var3] = true;
         }
      }
   }

   public void rad(int var1) {
      if (var1 == 0) {
         this.powerup.play();
         this.radpx = 212;
         this.pin = 0;
      }

      this.trackbg(false);
      this.rd.setColor(new Color(0, 0, 0));
      this.rd.fillRect(65, 135, 670, 59);
      if (this.pin != 0) {
         this.rd.drawImage(this.radicalplay, this.radpx + (int)(8.0 * Math.random() - 4.0), 135, null);
      } else {
         this.rd.drawImage(this.radicalplay, 212, 135, null);
      }

      if (this.radpx != 212) {
         this.radpx += 40;
         if (this.radpx > 735) {
            this.radpx = -388;
         }
      } else if (this.pin != 0) {
         this.pin--;
      }

      if (var1 == 40) {
         this.radpx = 213;
         this.pin = 7;
      }

      if (this.radpx == 212) {
         this.rd.setFont(new Font("Arial", 1, 11));
         this.ftm = this.rd.getFontMetrics();
         this.drawcs(185 + (int)(5.0F * this.m.random()), "Radicalplay.com", 112, 120, 143, 3);
      }

      this.rd.setFont(new Font("Arial", 1, 11));
      this.ftm = this.rd.getFontMetrics();
      if (this.aflk) {
         this.drawcs(215, "And we are never going to find the new unless we get a little crazy...", 112, 120, 143, 3);
         this.aflk = false;
      } else {
         this.drawcs(217, "And we are never going to find the new unless we get a little crazy...", 150, 150, 150, 3);
         this.aflk = true;
      }

      this.rd.drawImage(this.rpro, 275, 265, null);
      this.rd.setColor(new Color(0, 0, 0));
      this.rd.fillRect(0, 0, 65, 450);
      this.rd.fillRect(735, 0, 65, 450);
      this.rd.fillRect(65, 0, 670, 25);
      this.rd.fillRect(65, 425, 670, 25);
   }

   public void credits(Control var1, int var2, int var3, int var4) {
      if (this.flipo == 0) {
         this.powerup.play();
         this.flipo = 1;
      }

      if (this.flipo >= 1 && this.flipo <= 100) {
         this.rad(this.flipo);
         this.flipo++;
         if (this.flipo == 100) {
            this.flipo = 1;
         }
      }

      if (this.flipo == 101) {
         this.mainbg(-1);
         this.rd.drawImage(this.mdness, 283, 32, null);
         this.rd.setFont(new Font("Arial", 1, 13));
         this.ftm = this.rd.getFontMetrics();
         this.drawcs(90, "At Radicalplay.com", 0, 0, 0, 3);
         this.drawcs(165, "Cartoon 3D Engine, Game Programming, 3D Models, Graphics and Sound Effects", 0, 0, 0, 3);
         this.drawcs(185, "By Omar Waly", 40, 60, 0, 3);
         this.rd.setFont(new Font("Arial", 1, 13));
         this.ftm = this.rd.getFontMetrics();
         this.drawcs(225, "Special Thanks!", 0, 0, 0, 3);
         this.rd.setFont(new Font("Arial", 1, 11));
         this.ftm = this.rd.getFontMetrics();
         this.drawcs(245, "Thanks to Dany Fernandez Diaz (DragShot) for imporving the game’s music player to play more mod formats & effects!", 66, 98, 0, 3);
         this.drawcs(260, "Thanks to Badie El Zaman (Kingofspeed) for helping make the trees & cactus 3D models.", 66, 98, 0, 3);
         this.drawcs(275, "Thanks to Timothy Audrain Hardin (Legnak) for making hazard designs on stage parts & the new fence 3D model.", 66, 98, 0, 3);
         this.drawcs(290, "Thanks to Alex Miles (A-Mile) & Jaroslav Beleren (Phyrexian) for making trailer videos for the game.", 66, 98, 0, 3);
         this.drawcs(305, "A big thank you to everyone playing the game for sending their feedback, supporting the game and helping it improve!", 66, 98, 0, 3);
         this.rd.setFont(new Font("Arial", 1, 13));
         this.ftm = this.rd.getFontMetrics();
         this.drawcs(345, "Music from ModArchive.org", 0, 0, 0, 3);
         this.rd.setFont(new Font("Arial", 1, 11));
         this.ftm = this.rd.getFontMetrics();
         this.drawcs(365, "Most of the tracks where remixed by Omar Waly to match the game.", 66, 98, 0, 3);
         this.drawcs(380, "More details about the tracks and their original composers at:", 66, 98, 0, 3);
         this.drawcs(395, "http://multiplayer.needformadness.com/music.html", 33, 49, 0, 3);
         this.rd
            .drawLine(
               400 - this.ftm.stringWidth("http://multiplayer.needformadness.com/music.html") / 2,
               396,
               this.ftm.stringWidth("http://multiplayer.needformadness.com/music.html") / 2 + 400,
               396
            );
         if (var2 > 258 && var2 < 542 && var3 > 385 && var3 < 399) {
            this.app.setCursor(new Cursor(12));
            if (var4 == 2) {
               this.app.musiclink();
            }
         } else {
            this.app.setCursor(new Cursor(0));
         }
      }

      if (this.flipo == 102) {
         this.mainbg(0);
         this.rd.drawImage(this.nfmcom, 190, 195, null);
         if (var2 > 190 && var2 < 609 && var3 > 195 && var3 < 216) {
            this.app.setCursor(new Cursor(12));
            if (var4 == 2) {
               this.app.madlink();
            }
         } else {
            this.app.setCursor(new Cursor(0));
         }
      }

      this.rd.drawImage(this.next[this.pnext], 665, 395, null);
      if (var1.enter || var1.handb || var1.right) {
         if (this.flipo >= 1 && this.flipo <= 100) {
            this.flipo = 101;
            this.app.setCursor(new Cursor(0));
         } else {
            this.flipo++;
         }

         if (this.flipo == 103) {
            this.flipo = 0;
            this.fase = 10;
         }

         var1.enter = false;
         var1.handb = false;
         var1.right = false;
      }
   }

   public void trackbg(boolean var1) {
      byte var2 = 0;
      this.trkl++;
      if (this.trkl > this.trklim) {
         var2 = 1;
         this.trklim = (int)(Math.random() * 40.0);
         this.trkl = 0;
      }

      if (var1) {
         var2 = 0;
      }

      for (int var3 = 0; var3 < 2; var3++) {
         this.rd.drawImage(this.trackbg[var2], this.trkx[var3], 25, null);
         this.trkx[var3] = this.trkx[var3] - 10;
         if (this.trkx[var3] <= -605) {
            this.trkx[var3] = 735;
         }
      }

      this.rd.setColor(new Color(0, 0, 0));
      this.rd.fillRect(0, 0, 65, 450);
      this.rd.fillRect(735, 0, 65, 450);
      this.rd.fillRect(65, 0, 670, 25);
      this.rd.fillRect(65, 425, 670, 25);
   }

   public void mainbg(int var1) {
      byte var2 = 2;
      this.rd.setColor(new Color(191, 184, 124));
      if (var1 == -1) {
         if (var1 != this.lmode) {
            this.bgmy[0] = 0;
            this.bgmy[1] = -400;
            this.bgup = false;
            this.bgf = 0.0F;
            this.lmode = var1;
         }

         this.rd.setColor(new Color(144, 222, 9));
         var2 = 8;
      }

      if (var1 == 0) {
         if (var1 != this.lmode) {
            this.bgmy[0] = 0;
            this.bgmy[1] = -400;
            this.bgup = false;
            this.bgf = 0.0F;
            this.lmode = var1;
         }

         int var3 = (int)(255.0F * this.bgf + 191.0F * (1.0F - this.bgf));
         int var4 = (int)(176.0F * this.bgf + 184.0F * (1.0F - this.bgf));
         int var5 = (int)(67.0F * this.bgf + 124.0F * (1.0F - this.bgf));
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

         this.rd.setColor(new Color(var3, var4, var5));
         var2 = 4;
      }

      if (var1 == 1) {
         if (var1 != this.lmode) {
            this.bgmy[0] = 0;
            this.bgmy[1] = -400;
            this.lmode = var1;
         }

         this.rd.setColor(new Color(255, 176, 67));
         var2 = 8;
      }

      if (var1 == 2) {
         if (var1 != this.lmode) {
            this.bgmy[0] = 0;
            this.bgmy[1] = -400;
            this.lmode = var1;
            this.bgf = 0.2F;
         }

         this.rd.setColor(new Color(188, 170, 122));
         if (this.flipo == 16) {
            int var6 = (int)(176.0F * this.bgf + 191.0F * (1.0F - this.bgf));
            int var11 = (int)(202.0F * this.bgf + 184.0F * (1.0F - this.bgf));
            int var13 = (int)(255.0F * this.bgf + 124.0F * (1.0F - this.bgf));
            this.rd.setColor(new Color(var6, var11, var13));
            this.bgf += 0.025F;
            if (this.bgf > 0.85F) {
               this.bgf = 0.85F;
            }
         } else {
            this.bgf = 0.2F;
         }

         var2 = 2;
      }

      if (var1 == 3) {
         if (var1 != this.lmode) {
            this.bgmy[0] = 0;
            this.bgmy[1] = -400;
            this.bgup = false;
            this.bgf = 0.0F;
            this.lmode = var1;
         }

         int var7 = (int)(255.0F * this.bgf + 191.0F * (1.0F - this.bgf));
         int var12 = (int)(176.0F * this.bgf + 184.0F * (1.0F - this.bgf));
         int var14 = (int)(67.0F * this.bgf + 124.0F * (1.0F - this.bgf));
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

         this.rd.setColor(new Color(var7, var12, var14));
         var2 = 2;
      }

      if (var1 != -101) {
         if (var1 == 4) {
            this.rd.setColor(new Color(216, 177, 100));
            this.rd.fillRect(65, 0, 670, 425);
         } else {
            this.rd.fillRect(65, 25, 670, 400);
         }
      }

      if (var1 == 4) {
         if (var1 != this.lmode) {
            this.bgmy[0] = 0;
            this.bgmy[1] = 400;

            for (int var8 = 0; var8 < 4; var8++) {
               this.ovw[var8] = (int)(50.0 + 150.0 * Math.random());
               this.ovh[var8] = (int)(50.0 + 150.0 * Math.random());
               this.ovy[var8] = (int)(400.0 * Math.random());
               this.ovx[var8] = (int)(Math.random() * 670.0);
               this.ovsx[var8] = (int)(5.0 + Math.random() * 10.0);
            }

            this.lmode = var1;
         }

         for (int var9 = 0; var9 < 4; var9++) {
            this.rd.setColor(new Color(235, 176, 84));
            this.rd
               .fillOval(
                  (int)(65 + this.ovx[var9] - this.ovw[var9] * 1.5 / 2.0),
                  (int)(25 + this.ovy[var9] - this.ovh[var9] * 1.5 / 2.0),
                  (int)(this.ovw[var9] * 1.5),
                  (int)(this.ovh[var9] * 1.5)
               );
            this.rd.setColor(new Color(255, 176, 67));
            this.rd.fillOval(65 + this.ovx[var9] - this.ovh[var9] / 2, 25 + this.ovy[var9] - this.ovh[var9] / 2, this.ovw[var9], this.ovh[var9]);
            this.ovx[var9] = this.ovx[var9] - this.ovsx[var9];
            if (this.ovx[var9] + this.ovw[var9] * 1.5 / 2.0 < 0.0) {
               this.ovw[var9] = (int)(50.0 + 150.0 * Math.random());
               this.ovh[var9] = (int)(50.0 + 150.0 * Math.random());
               this.ovy[var9] = (int)(400.0 * Math.random());
               this.ovx[var9] = (int)(670.0 + this.ovw[var9] * 1.5 / 2.0);
               this.ovsx[var9] = (int)(5.0 + Math.random() * 10.0);
            }
         }
      }

      if (var1 != -101 && var1 != 4) {
         for (int var10 = 0; var10 < 2; var10++) {
            if (var1 != 2 || this.flipo != 16) {
               this.rd.drawImage(this.bgmain, 65, 25 + this.bgmy[var10], null);
            }

            this.bgmy[var10] = this.bgmy[var10] + var2;
            if (this.bgmy[var10] >= 400) {
               this.bgmy[var10] = -400;
            }
         }
      }

      this.rd.setColor(new Color(0, 0, 0));
      this.rd.fillRect(0, 0, 65, 450);
      this.rd.fillRect(735, 0, 65, 450);
      if (var1 != 4) {
         this.rd.fillRect(65, 0, 670, 25);
      }

      this.rd.fillRect(65, 425, 670, 25);
   }

   public void inishstageselect(CheckPoints var1) {
      if (var1.stage == -2 && (this.cd.msloaded != 1 || !this.logged)) {
         var1.stage = (int)(Math.random() * 27.0) + 1;
         var1.top20 = 0;
      }

      if (var1.stage > 27) {
         var1.stage = (int)(Math.random() * 27.0) + 1;
      }

      if (var1.stage == -2) {
         boolean var2 = false;

         for (int var3 = 1; var3 < this.app.mstgs.getItemCount(); var3++) {
            if (this.app.mstgs.getItem(var3).equals(var1.name)) {
               var2 = true;
            }
         }

         if (!var2) {
            var1.stage = (int)(Math.random() * 27.0) + 1;
         }
      }

      if (this.gmode == 1) {
         if (this.unlocked[0] != 11 || this.justwon1) {
            var1.stage = this.unlocked[0];
         } else if (this.winner || var1.stage > 11) {
            var1.stage = (int)(Math.random() * 11.0) + 1;
         }

         if (var1.stage == 11) {
            var1.stage = 27;
         }
      }

      if (this.gmode == 2) {
         if (this.unlocked[0] != 17 || this.justwon2) {
            var1.stage = this.unlocked[1] + 10;
         } else if (this.winner || var1.stage < 11) {
            var1.stage = (int)(Math.random() * 17.0) + 11;
         }
      }

      this.app.sgame.setBackground(new Color(0, 0, 0));
      this.app.sgame.setForeground(new Color(47, 179, 255));
      this.app.snfm1.setBackground(new Color(0, 0, 0));
      this.app.snfm1.setForeground(new Color(47, 179, 255));
      this.app.snfm2.setBackground(new Color(0, 0, 0));
      this.app.snfm2.setForeground(new Color(47, 179, 255));
      this.app.mstgs.setBackground(new Color(0, 0, 0));
      this.app.mstgs.setForeground(new Color(47, 179, 255));
      this.app.gmode.setBackground(new Color(49, 49, 0));
      this.app.gmode.setForeground(new Color(148, 167, 0));
      this.app.sgame.removeAll();
      this.app.sgame.add(this.rd, " NFM 1     ");
      this.app.sgame.add(this.rd, " NFM 2     ");
      this.app.sgame.add(this.rd, " My Stages ");
      this.app.sgame.add(this.rd, " Weekly Top20 ");
      this.app.sgame.add(this.rd, " Monthly Top20 ");
      this.app.sgame.add(this.rd, " Stage Maker ");
      if (var1.stage > 0 && var1.stage <= 10) {
         this.app.sgame.select(0);
         this.nfmtab = 0;
      }

      if (var1.stage > 10) {
         this.app.sgame.select(1);
         this.nfmtab = 1;
      }

      if (var1.stage == -2) {
         this.app.sgame.select(2);
         this.nfmtab = 2;
      }

      if (var1.stage == -1) {
         this.app.sgame.select(5);
         this.nfmtab = 5;
      }

      this.removeds = 0;
      this.lfrom = 0;
      this.cd.staction = 0;
      this.fase = 2;
   }

   public void loadingstage(int var1, boolean var2) {
      this.trackbg(true);
      this.rd.drawImage(this.br, 65, 25, null);
      this.rd.setColor(new Color(212, 214, 138));
      this.rd.fillRoundRect(265, 201, 270, 26, 20, 40);
      this.rd.setColor(new Color(57, 64, 8));
      this.rd.drawRoundRect(265, 201, 270, 26, 20, 40);
      this.rd.setFont(new Font("Arial", 1, 12));
      this.ftm = this.rd.getFontMetrics();
      this.drawcs(219, "Loading, please wait...", 58, 61, 17, 3);
      if (var2) {
         this.rd.drawImage(this.select, 338, 35, null);
      }

      this.app.repaint();
      if (this.cd.staction != 0) {
         this.app.tnick.hide();
         this.app.tpass.hide();
         this.cd.staction = 0;
      }

      this.removeds = 0;
   }

   public void cantgo(Control var1) {
      this.pnext = 0;
      this.trackbg(false);
      this.rd.drawImage(this.br, 65, 25, null);
      this.rd.drawImage(this.select, 338, 35, null);
      this.rd.setFont(new Font("Arial", 1, 13));
      this.ftm = this.rd.getFontMetrics();
      this.drawcs(130, "This stage will be unlocked when stage " + this.unlocked[this.gmode - 1] + " is complete!", 177, 177, 177, 3);

      for (int var2 = 0; var2 < 9; var2++) {
         this.rd.drawImage(this.pgate, 277 + var2 * 30, 215, null);
      }

      this.rd.setFont(new Font("Arial", 1, 12));
      this.ftm = this.rd.getFontMetrics();
      if (this.aflk) {
         this.drawcs(185, "[ Stage " + (this.unlocked[this.gmode - 1] + 1) + " Locked ]", 255, 128, 0, 3);
         this.aflk = false;
      } else {
         this.drawcs(185, "[ Stage " + (this.unlocked[this.gmode - 1] + 1) + " Locked ]", 255, 0, 0, 3);
         this.aflk = true;
      }

      this.rd.drawImage(this.back[this.pback], 370, 345, null);
      this.lockcnt--;
      if (this.lockcnt == 0 || var1.enter || var1.handb || var1.left) {
         var1.left = false;
         var1.handb = false;
         var1.enter = false;
         this.fase = 1;
      }
   }

   public void stageselect(CheckPoints var1, Control var2, int var3, int var4, boolean var5) {
      this.rd.drawImage(this.br, 65, 25, null);
      this.rd.drawImage(this.select, 338, 35, null);
      if (this.testdrive != 3 && this.testdrive != 4) {
         if (var1.stage > 0 && this.cd.staction == 0) {
            if (var1.stage != 1 && (var1.stage != 11 || this.gmode != 2)) {
               this.rd.drawImage(this.back[this.pback], 115, 135, null);
            }

            if (var1.stage != 27) {
               this.rd.drawImage(this.next[this.pnext], 625, 135, null);
            }
         }

         if (this.gmode == 0) {
            boolean var12 = false;
            byte var7 = 0;
            if (this.nfmtab != this.app.sgame.getSelectedIndex()) {
               this.nfmtab = this.app.sgame.getSelectedIndex();
               this.app.snfm1.select(0);
               this.app.snfm2.select(0);
               this.app.mstgs.select(0);
               this.app.requestFocus();
               var12 = true;
            }

            if (this.cd.staction == 5) {
               if (this.lfrom == 0) {
                  this.cd.staction = 0;
                  this.removeds = 1;
                  var12 = true;
               } else {
                  this.cd.onstage = var1.name;
                  this.cd.staction = 2;
                  this.dnload = 2;
               }

               this.nickname = this.app.tnick.getText();
               this.backlog = this.nickname;
               this.nickey = this.cd.tnickey;
               this.clan = this.cd.tclan;
               this.clankey = this.cd.tclankey;
               this.app.setloggedcookie();
               this.logged = true;
               this.gotlog = true;
               if (this.cd.reco == 0) {
                  this.acexp = 0;
               }

               if (this.cd.reco > 10) {
                  this.acexp = this.cd.reco - 10;
               }

               if (this.cd.reco == 3) {
                  this.acexp = -1;
               }

               if (this.cd.reco == 111) {
                  if (!this.backlog.toLowerCase().equals(this.nickname.toLowerCase())) {
                     this.acexp = -3;
                  } else {
                     this.acexp = 0;
                  }
               }
            }

            if (this.nfmtab == 2 && this.cd.staction == 0 && this.removeds == 1) {
               var1.stage = -3;
            }

            if (this.app.openm && this.cd.staction == 3) {
               this.app.tnick.hide();
               this.app.tpass.hide();
               this.cd.staction = 0;
            }

            int var8 = 0;
            this.app.sgame.setSize(131, 22);
            if (this.app.sgame.getSelectedIndex() == 0) {
               var8 = 400 - (this.app.sgame.getWidth() + 6 + this.app.snfm1.getWidth()) / 2;
            }

            if (this.app.sgame.getSelectedIndex() == 1) {
               var8 = 400 - (this.app.sgame.getWidth() + 6 + this.app.snfm2.getWidth()) / 2;
            }

            if (this.app.sgame.getSelectedIndex() == 2) {
               this.app.mstgs.setSize(338, 22);
               if (var12) {
                  if (this.logged) {
                     if (this.cd.msloaded != 1) {
                        this.app.mstgs.removeAll();
                        this.app.mstgs.add(this.rd, "Loading your stages now, please wait...");
                        this.app.mstgs.select(0);
                        var7 = 1;
                     }
                  } else {
                     this.app.mstgs.removeAll();
                     this.app.mstgs.add(this.rd, "Please login first to load your stages...");
                     this.app.mstgs.select(0);
                     this.cd.msloaded = 0;
                     this.lfrom = 0;
                     this.cd.staction = 3;
                     this.showtf = false;
                     this.tcnt = 0;
                     this.cntflock = 0;
                     this.cd.reco = -2;
                  }
               }

               var8 = 400 - (this.app.sgame.getWidth() + 6 + this.app.mstgs.getWidth()) / 2;
            }

            if (this.app.sgame.getSelectedIndex() == 3) {
               this.app.mstgs.setSize(338, 22);
               if (var12 && this.cd.msloaded != 3) {
                  this.app.mstgs.removeAll();
                  this.app.mstgs.add(this.rd, "Loading Top20 list, please wait...");
                  this.app.mstgs.select(0);
                  var7 = 3;
               }

               var8 = 400 - (this.app.sgame.getWidth() + 6 + this.app.mstgs.getWidth()) / 2;
            }

            if (this.app.sgame.getSelectedIndex() == 4) {
               this.app.mstgs.setSize(338, 22);
               if (var12 && this.cd.msloaded != 4) {
                  this.app.mstgs.removeAll();
                  this.app.mstgs.add(this.rd, "Loading Top20 list, please wait...");
                  this.app.mstgs.select(0);
                  var7 = 4;
               }

               var8 = 400 - (this.app.sgame.getWidth() + 6 + this.app.mstgs.getWidth()) / 2;
            }

            if (this.app.sgame.getSelectedIndex() == 5) {
               if (this.cd.staction != 0) {
                  this.app.tnick.hide();
                  this.app.tpass.hide();
                  this.cd.staction = 0;
               }

               this.app.mstgs.setSize(338, 22);
               if (var12 && this.cd.msloaded != 2) {
                  this.app.mstgs.removeAll();
                  this.app.mstgs.add(this.rd, "Loading Stage Maker stages, please wait...");
                  this.app.mstgs.select(0);
                  var7 = 2;
               }

               var8 = 400 - (this.app.sgame.getWidth() + 6 + this.app.mstgs.getWidth()) / 2;
            }

            if (!this.app.sgame.isShowing()) {
               this.app.sgame.show();
            }

            this.app.sgame.move(var8, 62);
            var8 += this.app.sgame.getWidth() + 6;
            if (this.nfmtab == 0) {
               if (!this.app.snfm1.isShowing()) {
                  this.app.snfm1.show();
                  if (!var12 && var1.stage > 0) {
                     this.app.snfm1.select(var1.stage);
                  }
               }

               this.app.snfm1.move(var8, 62);
               if (this.app.snfm2.isShowing()) {
                  this.app.snfm2.hide();
               }

               if (this.app.mstgs.isShowing()) {
                  this.app.mstgs.hide();
               }
            }

            if (this.nfmtab == 1) {
               if (!this.app.snfm2.isShowing()) {
                  this.app.snfm2.show();
                  if (!var12 && var1.stage > 10) {
                     this.app.snfm2.select(var1.stage - 10);
                  }
               }

               this.app.snfm2.move(var8, 62);
               if (this.app.snfm1.isShowing()) {
                  this.app.snfm1.hide();
               }

               if (this.app.mstgs.isShowing()) {
                  this.app.mstgs.hide();
               }
            }

            if (this.nfmtab == 2 || this.nfmtab == 3 || this.nfmtab == 4 || this.nfmtab == 5) {
               if (!this.app.mstgs.isShowing()) {
                  this.app.mstgs.show();
                  if (!var12) {
                     this.app.mstgs.select(var1.name);
                  }
               }

               this.app.mstgs.move(var8, 62);
               if (this.app.snfm1.isShowing()) {
                  this.app.snfm1.hide();
               }

               if (this.app.snfm2.isShowing()) {
                  this.app.snfm2.hide();
               }
            }

            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            if (this.cd.staction == 0 || this.cd.staction == 6) {
               if (var1.stage != -3) {
                  String var9 = "";
                  if (var1.top20 >= 3) {
                     var9 = "N#" + var1.nto + "  ";
                  }

                  if (this.aflk) {
                     this.drawcs(132, var9 + var1.name, 240, 240, 240, 3);
                     this.aflk = false;
                  } else {
                     this.drawcs(132, var9 + var1.name, 176, 176, 176, 3);
                     this.aflk = true;
                  }

                  if (var1.stage == -2 && this.cd.staction == 0) {
                     this.rd.setFont(new Font("Arial", 1, 11));
                     this.ftm = this.rd.getFontMetrics();
                     this.rd.setColor(new Color(255, 176, 85));
                     if (var1.maker.equals(this.nickname)) {
                        this.rd.drawString("Created by You", 70, 115);
                     } else {
                        this.rd.drawString("Created by :  " + var1.maker + "", 70, 115);
                     }

                     if (var1.top20 >= 3) {
                        this.rd.drawString("Added by :  " + this.cd.top20adds[var1.nto - 1] + " Players", 70, 135);
                     }
                  }
               } else if (this.removeds != 1) {
                  this.rd.setFont(new Font("Arial", 1, 13));
                  this.ftm = this.rd.getFontMetrics();
                  this.drawcs(132, "Failed to load stage...", 255, 138, 0, 3);
                  this.rd.setFont(new Font("Arial", 1, 11));
                  this.ftm = this.rd.getFontMetrics();
                  if (this.nfmtab == 5) {
                     this.drawcs(155, "Please Test Drive this stage in the Stage Maker to make sure it can be loaded!", 255, 138, 0, 3);
                  }

                  if (this.nfmtab == 2 || this.nfmtab == 3 || this.nfmtab == 4) {
                     this.drawcs(155, "It could be a connection error, please try again later.", 255, 138, 0, 3);
                  }

                  if (this.nfmtab == 1 || this.nfmtab == 0) {
                     this.drawcs(155, "Will try to load another stage...", 255, 138, 0, 3);
                     this.app.repaint();

                     try {
                        Thread.sleep(5000L);
                     } catch (InterruptedException var11) {
                     }

                     if (this.nfmtab == 0) {
                        this.app.snfm1.select(1 + (int)(Math.random() * 10.0));
                     }

                     if (this.nfmtab == 1) {
                        this.app.snfm2.select(1 + (int)(Math.random() * 17.0));
                     }
                  }
               }
            }

            if (this.cd.staction == 3) {
               this.drawdprom(145, 170);
               if (this.cd.reco == -2) {
                  if (this.lfrom == 0) {
                     this.drawcs(171, "Login to Retrieve your Account Stages", 0, 0, 0, 3);
                  } else {
                     this.drawcs(171, "Login to add this stage to your account.", 0, 0, 0, 3);
                  }
               }

               if (this.cd.reco == -1) {
                  this.drawcs(171, "Unable to connect to server, try again later!", 0, 8, 0, 3);
               }

               if (this.cd.reco == 1) {
                  this.drawcs(171, "Sorry.  The Nickname you have entered is incorrect.", 0, 0, 0, 3);
               }

               if (this.cd.reco == 2) {
                  this.drawcs(171, "Sorry.  The Password you have entered is incorrect.", 0, 0, 0, 3);
               }

               if (this.cd.reco == -167 || this.cd.reco == -177) {
                  if (this.cd.reco == -167) {
                     this.nickname = this.app.tnick.getText();
                     this.backlog = this.nickname;
                     this.cd.reco = -177;
                  }

                  this.drawcs(171, "You are currently using a trial account.", 0, 0, 0, 3);
               }

               if (this.cd.reco == -3 && (this.tcnt % 3 != 0 || this.tcnt > 20)) {
                  this.drawcs(171, "Please enter your Nickname!", 0, 0, 0, 3);
               }

               if (this.cd.reco == -4 && (this.tcnt % 3 != 0 || this.tcnt > 20)) {
                  this.drawcs(171, "Please enter your Password!", 0, 0, 0, 3);
               }

               if (!this.showtf) {
                  this.app.tnick.setBackground(new Color(206, 237, 255));
                  if (this.cd.reco != 1) {
                     if (this.cd.reco != 2) {
                        this.app.tnick.setText(this.nickname);
                     }

                     this.app.tnick.setForeground(new Color(0, 0, 0));
                  } else {
                     this.app.tnick.setForeground(new Color(255, 0, 0));
                  }

                  this.app.tnick.requestFocus();
                  this.app.tpass.setBackground(new Color(206, 237, 255));
                  if (this.cd.reco != 2) {
                     if (!this.autolog) {
                        this.app.tpass.setText("");
                     }

                     this.app.tpass.setForeground(new Color(0, 0, 0));
                  } else {
                     this.app.tpass.setForeground(new Color(255, 0, 0));
                  }

                  if (!this.app.tnick.getText().equals("") && this.cd.reco != 1) {
                     this.app.tpass.requestFocus();
                  }

                  this.showtf = true;
               }

               this.rd.drawString("Nickname:", 376 - this.ftm.stringWidth("Nickname:") - 14, 201);
               this.rd.drawString("Password:", 376 - this.ftm.stringWidth("Password:") - 14, 231);
               this.app.movefieldd(this.app.tnick, 376, 185, 129, 23, true);
               this.app.movefieldd(this.app.tpass, 376, 215, 129, 23, true);
               if (this.tcnt < 30) {
                  this.tcnt++;
                  if (this.tcnt == 30) {
                     if (this.cd.reco == 2) {
                        this.app.tpass.setText("");
                     }

                     this.app.tnick.setForeground(new Color(0, 0, 0));
                     this.app.tpass.setForeground(new Color(0, 0, 0));
                  }
               }

               if (this.cd.reco != -177) {
                  if ((this.drawcarb(true, null, "       Login       ", 347, 247, var3, var4, var5) || var2.handb || var2.enter) && this.tcnt > 5) {
                     this.tcnt = 0;
                     if (!this.app.tnick.getText().equals("") && !this.app.tpass.getText().equals("")) {
                        this.autolog = false;
                        this.app.tnick.hide();
                        this.app.tpass.hide();
                        this.app.requestFocus();
                        this.cd.staction = 4;
                        this.cd.sparkstageaction();
                     } else {
                        if (this.app.tpass.getText().equals("")) {
                           this.cd.reco = -4;
                        }

                        if (this.app.tnick.getText().equals("")) {
                           this.cd.reco = -3;
                        }
                     }
                  }
               } else if (this.drawcarb(true, null, "  Upgrade to have your own stages!  ", 277, 247, var3, var4, var5) && this.cntflock == 0) {
                  this.app.editlink(this.nickname, true);
                  this.cntflock = 100;
               }

               if (this.drawcarb(true, null, "  Cancel  ", 409, 282, var3, var4, var5)) {
                  this.app.tnick.hide();
                  this.app.tpass.hide();
                  this.app.requestFocus();
                  this.cd.staction = 0;
               }

               if (this.drawcarb(true, null, "  Register!  ", 316, 282, var3, var4, var5)) {
                  if (this.cntflock == 0) {
                     this.app.reglink();
                     this.cntflock = 100;
                  }
               } else if (this.cntflock != 0) {
                  this.cntflock--;
               }
            }

            if (this.cd.staction == 4) {
               this.drawdprom(145, 170);
               this.drawcs(195, "Logging in to your account...", 0, 0, 0, 3);
            }

            if (var1.stage == -2 && this.cd.msloaded == 1 && var1.top20 < 3 && !this.app.openm && this.drawcarb(true, null, "X", 609, 113, var3, var4, var5)) {
               this.cd.staction = 6;
            }

            if (this.cd.staction == -1 && var1.top20 < 3) {
               this.removeds = 0;
               this.drawdprom(145, 95);
               this.drawcs(175, "Failed to remove stage from your account, try again later.", 0, 0, 0, 3);
               if (this.drawcarb(true, null, " OK ", 379, 195, var3, var4, var5)) {
                  this.cd.staction = 0;
               }
            }

            if (this.cd.staction == 1) {
               this.drawdprom(145, 95);
               this.drawcs(195, "Removing stage from your account...", 0, 0, 0, 3);
               this.removeds = 1;
            }

            if (this.cd.staction == 6) {
               this.drawdprom(145, 95);
               this.drawcs(175, "Remove this stage from your account?", 0, 0, 0, 3);
               if (this.drawcarb(true, null, " Yes ", 354, 195, var3, var4, var5)) {
                  this.cd.onstage = this.app.mstgs.getSelectedItem();
                  this.cd.staction = 1;
                  this.cd.sparkstageaction();
               }

               if (this.drawcarb(true, null, " No ", 408, 195, var3, var4, var5)) {
                  this.cd.staction = 0;
               }
            }

            if (var7 == 1) {
               this.app.drawms();
               this.app.repaint();
               this.cd.loadmystages(var1);
            }

            if (var7 >= 3) {
               this.app.drawms();
               this.app.repaint();
               this.cd.loadtop20(var7);
            }

            if (var7 == 2) {
               this.app.drawms();
               this.app.repaint();
               this.cd.loadstagemaker();
            }

            if (var1.stage != -3 && this.cd.staction == 0 && var1.top20 < 3) {
               this.rd.drawImage(this.contin[this.pcontin], 355, 360, null);
            } else {
               this.pcontin = 0;
            }

            if (var1.top20 >= 3 && this.cd.staction != 3 && this.cd.staction != 4) {
               this.rd.setFont(new Font("Arial", 1, 11));
               this.ftm = this.rd.getFontMetrics();
               if (this.dnload == 0 && this.drawcarb(true, null, " Add to My Stages ", 334, 355, var3, var4, var5)) {
                  if (this.logged) {
                     this.cd.onstage = var1.name;
                     this.cd.staction = 2;
                     this.cd.sparkstageaction();
                     this.dnload = 2;
                  } else {
                     this.lfrom = 1;
                     this.cd.staction = 3;
                     this.showtf = false;
                     this.tcnt = 0;
                     this.cntflock = 0;
                     this.cd.reco = -2;
                  }
               }

               if (this.dnload == 2) {
                  this.drawcs(370, "Adding stage please wait...", 193, 106, 0, 3);
                  if (this.cd.staction == 0) {
                     this.dnload = 3;
                  }

                  if (this.cd.staction == -2) {
                     this.dnload = 4;
                  }

                  if (this.cd.staction == -3) {
                     this.dnload = 5;
                  }

                  if (this.cd.staction == -1) {
                     this.dnload = 6;
                  }

                  if (this.dnload != 2) {
                     this.cd.staction = 0;
                  }
               }

               if (this.dnload == 3) {
                  this.drawcs(370, "Stage has been successfully added to your stages!", 193, 106, 0, 3);
               }

               if (this.dnload == 4) {
                  this.drawcs(370, "You already have this stage!", 193, 106, 0, 3);
               }

               if (this.dnload == 5) {
                  this.drawcs(370, "Cannot add more then 20 stages to your account!", 193, 106, 0, 3);
               }

               if (this.dnload == 6) {
                  this.drawcs(370, "Failed to add stage, unknown error, please try again later.", 193, 106, 0, 3);
               }
            }

            if (this.testdrive == 0 && var1.top20 < 3) {
               if (!this.app.gmode.isShowing()) {
                  this.app.gmode.select(0);
                  this.app.gmode.show();
               }

               this.app.gmode.move(400 - this.app.gmode.getWidth() / 2, 395);
               if (this.app.gmode.getSelectedIndex() == 0 && this.nplayers != 7) {
                  this.nplayers = 7;
                  this.fase = 2;
                  this.app.requestFocus();
               }

               if (this.app.gmode.getSelectedIndex() == 1 && this.nplayers != 1) {
                  this.nplayers = 1;
                  this.fase = 2;
                  this.app.requestFocus();
               }
            } else if (this.app.gmode.isShowing()) {
               this.app.gmode.hide();
            }

            if (this.nfmtab == 0 && this.app.snfm1.getSelectedIndex() != var1.stage && this.app.snfm1.getSelectedIndex() != 0) {
               var1.stage = this.app.snfm1.getSelectedIndex();
               var1.top20 = 0;
               var1.nto = 0;
               this.hidos();
               this.fase = 2;
               this.app.requestFocus();
            }

            if (this.nfmtab == 1 && this.app.snfm2.getSelectedIndex() != var1.stage - 10 && this.app.snfm2.getSelectedIndex() != 0) {
               var1.stage = this.app.snfm2.getSelectedIndex() + 10;
               var1.top20 = 0;
               var1.nto = 0;
               this.hidos();
               this.fase = 2;
               this.app.requestFocus();
            }

            if ((this.nfmtab == 2 || this.nfmtab == 5) && !this.app.mstgs.getSelectedItem().equals(var1.name) && this.app.mstgs.getSelectedIndex() != 0) {
               if (this.nfmtab == 2) {
                  var1.stage = -2;
               } else {
                  var1.stage = -1;
               }

               var1.name = this.app.mstgs.getSelectedItem();
               var1.top20 = 0;
               var1.nto = 0;
               this.hidos();
               this.fase = 2;
               this.app.requestFocus();
            }

            if (this.nfmtab == 3 || this.nfmtab == 4) {
               String var14 = "";
               int var10 = this.app.mstgs.getSelectedItem().indexOf(" ") + 1;
               if (var10 > 0) {
                  var14 = this.app.mstgs.getSelectedItem().substring(var10);
               }

               if (!var14.equals("") && !var14.equals(var1.name) && this.app.mstgs.getSelectedIndex() != 0) {
                  var1.stage = -2;
                  var1.name = var14;
                  var1.top20 = -this.cd.msloaded;
                  var1.nto = this.app.mstgs.getSelectedIndex();
                  this.hidos();
                  this.fase = 2;
                  this.app.requestFocus();
               }
            }
         } else {
            this.rd.setFont(new Font("SansSerif", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            if (var1.stage != 27) {
               int var6 = var1.stage;
               if (var6 > 10) {
                  var6 -= 10;
               }

               this.drawcs(80, "Stage " + var6 + "  >", 255, 128, 0, 3);
            } else {
               this.drawcs(80, "Final Party Stage  >", 255, 128, 0, 3);
            }

            if (this.aflk) {
               this.drawcs(100, "| " + var1.name + " |", 240, 240, 240, 3);
               this.aflk = false;
            } else {
               this.drawcs(100, "| " + var1.name + " |", 176, 176, 176, 3);
               this.aflk = true;
            }

            if (var1.stage != -3) {
               this.rd.drawImage(this.contin[this.pcontin], 355, 360, null);
            } else {
               this.pcontin = 0;
            }
         }

         if (this.cd.staction == 0) {
            if ((var2.handb || var2.enter) && var1.stage != -3 && var1.top20 < 3) {
               this.app.gmode.hide();
               this.hidos();
               this.dudo = 150;
               this.fase = 5;
               var2.handb = false;
               var2.enter = false;
               this.intertrack.stop();
               this.intertrack.unloadimod();
            }

            if (var1.stage > 0) {
               if (var2.right) {
                  if (this.gmode != 0
                     && (this.gmode != 1 || var1.stage == this.unlocked[0])
                     && (this.gmode != 2 || var1.stage == this.unlocked[1] + 10)
                     && var1.stage != 27) {
                     this.fase = 4;
                     this.lockcnt = 100;
                  } else if (var1.stage != 27) {
                     this.hidos();
                     var1.stage++;
                     if (this.gmode == 1 && var1.stage == 11) {
                        var1.stage = 27;
                     }

                     if (var1.stage > 10) {
                        this.app.sgame.select(1);
                        this.nfmtab = 1;
                     } else {
                        this.app.sgame.select(0);
                        this.nfmtab = 0;
                     }

                     this.fase = 2;
                  }

                  var2.right = false;
               }

               if (var2.left && var1.stage != 1 && (var1.stage != 11 || this.gmode != 2)) {
                  this.hidos();
                  var1.stage--;
                  if (this.gmode == 1 && var1.stage == 26) {
                     var1.stage = 10;
                  }

                  if (var1.stage > 10) {
                     this.app.sgame.select(1);
                     this.nfmtab = 1;
                  } else {
                     this.app.sgame.select(0);
                     this.nfmtab = 0;
                  }

                  this.fase = 2;
                  var2.left = false;
               }
            }
         }
      } else {
         if (this.aflk) {
            this.drawcs(132, var1.name, 240, 240, 240, 3);
            this.aflk = false;
         } else {
            this.drawcs(132, var1.name, 176, 176, 176, 3);
            this.aflk = true;
         }

         this.rd.drawImage(this.contin[this.pcontin], 355, 360, null);
         if (var2.handb || var2.enter) {
            this.dudo = 150;
            this.fase = 5;
            var2.handb = false;
            var2.enter = false;
            this.intertrack.stop();
            this.intertrack.unloadimod();
         }
      }

      if (this.drawcarb(true, null, " Exit X ", 670, 30, var3, var4, var5)) {
         this.fase = 102;
         if (this.gmode == 0) {
            this.opselect = 3;
         }

         if (this.gmode == 1) {
            this.opselect = 0;
         }

         if (this.gmode == 2) {
            this.opselect = 1;
         }

         this.app.gmode.hide();
         this.hidos();
         this.app.tnick.hide();
         this.app.tpass.hide();
         this.intertrack.stop();
      }
   }

   public void hidos() {
      this.app.sgame.hide();
      this.app.snfm1.hide();
      this.app.snfm2.hide();
      this.app.mstgs.hide();
   }

   public void hipnoload(int var1, boolean var2) {
      int[] var3 = new int[]{this.m.snap[0], this.m.snap[1], this.m.snap[2]};

      while (var3[0] + var3[1] + var3[2] < -30) {
         for (int var4 = 0; var4 < 3; var4++) {
            if (var3[var4] < 50) {
               var3[var4]++;
            }
         }
      }

      int var9 = (int)(230.0F - 230.0F * (var3[0] / 100.0F));
      if (var9 > 255) {
         var9 = 255;
      }

      if (var9 < 0) {
         var9 = 0;
      }

      int var5 = (int)(230.0F - 230.0F * (var3[1] / 100.0F));
      if (var5 > 255) {
         var5 = 255;
      }

      if (var5 < 0) {
         var5 = 0;
      }

      int var6 = (int)(230.0F - 230.0F * (var3[2] / 100.0F));
      if (var6 > 255) {
         var6 = 255;
      }

      if (var6 < 0) {
         var6 = 0;
      }

      this.rd.setColor(new Color(var9, var5, var6));
      this.rd.fillRect(65, 25, 670, 400);
      this.rd.setComposite(AlphaComposite.getInstance(3, 0.3F));
      this.rd.drawImage(this.bggo, 0, -25, null);
      this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
      this.rd.setColor(new Color(0, 0, 0));
      this.rd.fillRect(0, 0, 65, 450);
      this.rd.fillRect(735, 0, 65, 450);
      this.rd.fillRect(65, 0, 670, 25);
      this.rd.fillRect(65, 425, 670, 25);
      this.rd.setFont(new Font("Arial", 1, 13));
      this.ftm = this.rd.getFontMetrics();
      this.drawcs(50, this.asay, 0, 0, 0, 3);
      byte var7 = -90;
      if (this.multion == 0) {
         if (var1 == 1 || var1 == 2 || var1 == 3 || var1 == 4 || var1 == 5 || var1 == 10) {
            var7 = 0;
         }

         if (var1 == 11
            || var1 == 12
            || var1 == 13
            || var1 == 14
            || var1 == 17
            || var1 == 18
            || var1 == 19
            || var1 == 20
            || var1 == 22
            || var1 == 23
            || var1 == 26) {
            var7 = 0;
         }

         if (var1 < 0 && this.nplayers != 1 && this.newparts) {
            var7 = 0;
         }
      } else if (this.ransay == 1 || this.ransay == 2 || this.ransay == 3 || this.ransay == 4 || var1 == 10) {
         var7 = 0;
      }

      if (var7 == 0) {
         if (this.dudo > 0) {
            if (this.aflk) {
               if (Math.random() > Math.random()) {
                  this.duds = (int)(Math.random() * 3.0);
               } else {
                  this.duds = (int)(Math.random() * 2.0);
               }

               this.aflk = false;
            } else {
               this.aflk = true;
            }

            this.dudo--;
         } else {
            this.duds = 0;
         }

         this.rd.setComposite(AlphaComposite.getInstance(3, 0.3F));
         this.rd.drawImage(this.dude[this.duds], 95, 35, null);
         this.rd.setComposite(AlphaComposite.getInstance(3, 0.7F));
         this.rd.drawImage(this.flaot, 192, 67, null);
         this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
         var9 = (int)(80.0F - 80.0F * (var3[0] / 100.0F));
         if (var9 > 255) {
            var9 = 255;
         }

         if (var9 < 0) {
            var9 = 0;
         }

         var5 = (int)(80.0F - 80.0F * (var3[1] / 100.0F));
         if (var5 > 255) {
            var5 = 255;
         }

         if (var5 < 0) {
            var5 = 0;
         }

         var6 = (int)(80.0F - 80.0F * (var3[2] / 100.0F));
         if (var6 > 255) {
            var6 = 255;
         }

         if (var6 < 0) {
            var6 = 0;
         }

         this.rd.setColor(new Color(var9, var5, var6));
         this.rd.setFont(new Font("Arial", 1, 13));
         if (this.multion != 0) {
            if (this.ransay == 1 && var1 != 10) {
               this.rd.drawString("Multiplayer Tip:  Press [ C ] to access chat quickly during the game!", 262, 92);
            }

            if (this.ransay == 2 && var1 != 10) {
               this.rd.drawString("Multiplayer Tip:  Press [ A ] to make Guidance Arrow point to cars and", 262, 92);
               this.rd.drawString("click any of the players listed on the right to lock the Arrow on!", 262, 112);
            }

            if (this.ransay == 3 && var1 != 10) {
               this.rd.drawString("Multiplayer Tip:  When wasting in multiplayer it's better to aim slightly", 262, 92);
               this.rd.drawString("ahead of the other player's car to compensate for internet delay.", 262, 112);
            }

            if (this.ransay == 4) {
               this.rd.drawString("When watching a game, click any player listed on the right of the", 262, 92);
               this.rd.drawString("screen to follow and watch.", 262, 112);
               this.rd.drawString("Press [ V ] to change the viewing mode!", 262, 132);
            }

            if (var1 == 10 && this.ransay != 4) {
               if (this.tflk) {
                  this.rd.setColor(new Color(200, var5, var6));
                  this.tflk = false;
               } else {
                  this.tflk = true;
               }

               this.rd.drawString("NOTE: Guidance Arrow and opponent status is disabled in this stage!", 262, 92);
            }
         } else {
            if (var1 < 0 && this.nplayers != 1 && this.newparts) {
               this.rd.drawString("Please note, the computer car's AI has not yet been trained to handle", 262, 92);
               this.rd.drawString("some of the new stage parts such as the 'Rollercoaster Road' and the", 262, 112);
               this.rd.drawString("'Tunnel Side Ramp'.", 262, 132);
               this.rd.drawString("(Those new parts where mostly designed for the multiplayer game.)", 262, 152);
               this.rd.drawString("The AI will be trained and ready in the future releases of the game!", 262, 172);
            }

            if (var1 == 1 || var1 == 11) {
               this.rd.drawString("Hey!  Don't forget, to complete a lap you must pass through", 262, 92);
               this.rd.drawString("all checkpoints in the track!", 262, 112);
            }

            if (var1 == 2 || var1 == 12) {
               this.rd.drawString("Remember, the more power you have the faster your car will be!", 262, 92);
            }

            if (var1 == 3) {
               this.rd.drawString("> Hint: its easier to waste the other cars then to race in this stage!", 262, 92);
               this.rd.drawString("Press [ A ] to make the guidance arrow point to cars instead of to", 262, 112);
               this.rd.drawString("the track.", 262, 132);
            }

            if (var1 == 4) {
               this.rd.drawString("Remember, the better the stunt you perform the more power you get!", 262, 92);
            }

            if (var1 == 5) {
               this.rd.drawString("Remember, the more power you have the stronger your car is!", 262, 92);
            }

            if (var1 == 10) {
               if (this.tflk) {
                  this.rd.setColor(new Color(200, var5, var6));
                  this.tflk = false;
               } else {
                  this.tflk = true;
               }

               this.rd.drawString("NOTE: Guidance Arrow is disabled in this stage!", 262, 92);
            }

            if (var1 == 13) {
               this.rd.drawString("Watch out!  Look out!  The policeman might be out to get you!", 262, 92);
               this.rd.drawString("Don't upset him or you'll be arrested!", 262, 112);
               this.rd.drawString("Better run, run, run.", 262, 152);
            }

            if (var1 == 14) {
               this.rd.drawString("Don't waste your time.  Waste them instead!", 262, 92);
               this.rd.drawString("Try a taste of sweet revenge here (if you can)!", 262, 112);
               this.rd.drawString("Press [ A ] to make the guidance arrow point to cars instead of to", 262, 152);
               this.rd.drawString("the track.", 262, 172);
            }

            if (var1 == 17) {
               this.rd.drawString("Welcome to the realm of the king...", 262, 92);
               this.rd.drawString("The key word here is 'POWER'.  The more you have of it the faster", 262, 132);
               this.rd.drawString("and STRONGER you car will be!", 262, 152);
            }

            if (var1 == 18) {
               this.rd.drawString("Watch out, EL KING is out to get you now!", 262, 92);
               this.rd.drawString("He seems to be seeking revenge?", 262, 112);
               this.rd.drawString("(To fly longer distances in the air try drifting your car on the ramp", 262, 152);
               this.rd.drawString("before take off).", 262, 172);
            }

            if (var1 == 19) {
               this.rd.drawString("It’s good to be the king!", 262, 92);
            }

            if (var1 == 20) {
               this.rd.drawString("Remember, forward loops give your car a push forwards in the air", 262, 92);
               this.rd.drawString("and help in racing.", 262, 112);
               this.rd.drawString("(You may need to do more forward loops here.  Also try keeping", 262, 152);
               this.rd.drawString("your power at maximum at all times.  Try not to miss a ramp).", 262, 172);
            }

            if (var1 == 22) {
               this.rd.drawString("Watch out!  Beware!  Take care!", 262, 92);
               this.rd.drawString("MASHEEN is hiding out there some where, don't get mashed now!", 262, 112);
            }

            if (var1 == 23) {
               this.rd.drawString("Anyone for a game of Digger?!", 262, 92);
               this.rd.drawString("You can have fun using MASHEEN here!", 262, 112);
            }

            if (var1 == 26) {
               this.rd.drawString("This is it!  This is the toughest stage in the game!", 262, 92);
               this.rd.drawString("This track is actually a 4D object projected onto the 3D world.", 262, 132);
               this.rd.drawString("It's been broken down, separated and, in many ways, it is also a", 262, 152);
               this.rd.drawString("maze!  GOOD LUCK!", 262, 172);
            }
         }
      }

      this.rd.setComposite(AlphaComposite.getInstance(3, 0.8F));
      this.rd.drawImage(this.loadingmusic, 289, 205 + var7, null);
      this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
      this.rd.setFont(new Font("Arial", 1, 11));
      this.ftm = this.rd.getFontMetrics();
      int var8 = var1 - 1;
      if (var8 < 0) {
         var8 = 32;
      }

      if (!var2) {
         this.drawcs(340 + var7, "" + this.sndsize[var8] + " KB", 0, 0, 0, 3);
         this.drawcs(375 + var7, " Please Wait...", 0, 0, 0, 3);
      } else {
         this.drawcs(365 + var7, "Loading complete!  Press Start to begin...", 0, 0, 0, 3);
         this.rd.setComposite(AlphaComposite.getInstance(3, 0.5F));
         this.rd.drawImage(this.star[this.pstar], 359, 385 + var7, null);
         this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
         if (this.pstar != 2) {
            if (this.pstar == 0) {
               this.pstar = 1;
            } else {
               this.pstar = 0;
            }
         }

         if (this.multion != 0) {
            this.drawcs(380 + var7, "" + this.forstart / 20, 0, 0, 0, 3);
         }
      }
   }

   public void loadmusic(int var1, String var2, int var3) {
      this.hipnoload(var1, false);
      this.app.setCursor(new Cursor(3));
      this.app.repaint();
      boolean var4 = false;
      if (this.multion == 0) {
         if (var1 == 1 || var1 == 2 || var1 == 3 || var1 == 4 || var1 == 5 || var1 == 10) {
            var4 = true;
         }

         if (var1 == 11
            || var1 == 12
            || var1 == 13
            || var1 == 14
            || var1 == 17
            || var1 == 18
            || var1 == 19
            || var1 == 20
            || var1 == 22
            || var1 == 23
            || var1 == 26) {
            var4 = true;
         }

         if (var1 < 0 && this.nplayers != 1 && this.newparts) {
            var4 = true;
         }
      } else if (this.ransay == 1 || this.ransay == 2 || this.ransay == 3 || this.ransay == 4 || var1 == 10) {
         var4 = true;
      }

      if (var4) {
         this.runtyp = var1;
         this.runner = new Thread(this);
         this.runner.start();
      }

      this.loadstrack(var1, var2, var3);
      if (var4) {
         this.runner.stop();
         this.runner = null;
         this.runtyp = 0;
      }

      System.gc();
      if (this.multion == 0 && this.app.applejava) {
         try {
            Thread.sleep(1000L);
         } catch (InterruptedException var7) {
         }
      }

      if (!this.lan) {
         this.strack.play();
      } else if (this.im != 0) {
         try {
            Thread.sleep(1000L);
         } catch (InterruptedException var6) {
         }
      }

      this.app.setCursor(new Cursor(0));
      this.pcontin = 0;
      this.mutem = false;
      this.mutes = false;
      this.fase = 6;
   }

   public void loadstrack(int var1, String var2, int var3) {
      if (var1 == 1) {
         this.strack = new RadicalMod("music/stage" + var1 + ".zip", 240, 8400, 135, false, false);
      }

      if (var1 == 2) {
         this.strack = new RadicalMod("music/stage" + var1 + ".zip", 190, 9000, 145, false, false);
      }

      if (var1 == 3) {
         this.strack = new RadicalMod("music/stage" + var1 + ".zip", 170, 8500, 145, false, false);
      }

      if (var1 == 4) {
         this.strack = new RadicalMod("music/stage" + var1 + ".zip", 205, 7500, 125, false, false);
      }

      if (var1 == 5) {
         this.strack = new RadicalMod("music/stage" + var1 + ".zip", 170, 7900, 125, false, false);
      }

      if (var1 == 6) {
         this.strack = new RadicalMod("music/stage" + var1 + ".zip", 370, 7900, 125, false, false);
      }

      if (var1 == 7) {
         this.strack = new RadicalMod("music/stage" + var1 + ".zip", 205, 7500, 125, false, false);
      }

      if (var1 == 8) {
         this.strack = new RadicalMod("music/stage" + var1 + ".zip", 230, 7900, 125, false, false);
      }

      if (var1 == 9) {
         this.strack = new RadicalMod("music/stage" + var1 + ".zip", 180, 7900, 125, false, false);
      }

      if (var1 == 10) {
         this.strack = new RadicalMod("music/stage" + var1 + ".zip", 280, 8100, 145, false, false);
      }

      if (var1 == 11) {
         this.strack = new RadicalMod("music/stage" + var1 + ".zip", 120, 8000, 125, false, false);
      }

      if (var1 == 12) {
         this.strack = new RadicalMod("music/stage" + var1 + ".zip", 260, 7200, 125, false, false);
      }

      if (var1 == 13) {
         this.strack = new RadicalMod("music/stage" + var1 + ".zip", 270, 8000, 125, false, false);
      }

      if (var1 == 14) {
         this.strack = new RadicalMod("music/stage" + var1 + ".zip", 190, 8000, 125, false, false);
      }

      if (var1 == 15) {
         this.strack = new RadicalMod("music/stage" + var1 + ".zip", 162, 7800, 125, false, false);
      }

      if (var1 == 16) {
         this.strack = new RadicalMod("music/stage" + var1 + ".zip", 220, 7600, 125, false, false);
      }

      if (var1 == 17) {
         this.strack = new RadicalMod("music/stage" + var1 + ".zip", 300, 7500, 125, false, false);
      }

      if (var1 == 18) {
         this.strack = new RadicalMod("music/stage" + var1 + ".zip", 200, 7900, 125, false, false);
      }

      if (var1 == 19) {
         this.strack = new RadicalMod("music/stage" + var1 + ".zip", 200, 7900, 125, false, false);
      }

      if (var1 == 20) {
         this.strack = new RadicalMod("music/stage" + var1 + ".zip", 232, 7300, 125, false, false);
      }

      if (var1 == 21) {
         this.strack = new RadicalMod("music/stage" + var1 + ".zip", 370, 7900, 125, false, false);
      }

      if (var1 == 22) {
         this.strack = new RadicalMod("music/stage" + var1 + ".zip", 290, 7900, 125, false, false);
      }

      if (var1 == 23) {
         this.strack = new RadicalMod("music/stage" + var1 + ".zip", 222, 7600, 125, false, false);
      }

      if (var1 == 24) {
         this.strack = new RadicalMod("music/stage" + var1 + ".zip", 230, 8000, 125, false, false);
      }

      if (var1 == 25) {
         this.strack = new RadicalMod("music/stage" + var1 + ".zip", 220, 8000, 125, false, false);
      }

      if (var1 == 26) {
         this.strack = new RadicalMod("music/stage" + var1 + ".zip", 261, 8000, 125, false, false);
      }

      if (var1 == 27) {
         if (this.gmode == 2) {
            this.strack = new RadicalMod("music/party.zip", 400, 7600, 125, false, false);
         } else {
            this.strack = new RadicalMod("music/stage" + var1 + ".zip", 276, 8800, 145, false, false);
         }
      }

      if (var1 == 28) {
         this.strack = new RadicalMod("music/stage" + var1 + ".zip", 182, 8000, 125, false, false);
      }

      if (var1 == 29) {
         this.strack = new RadicalMod("music/stage" + var1 + ".zip", 220, 8000, 125, false, false);
      }

      if (var1 == 30) {
         this.strack = new RadicalMod("music/stage" + var1 + ".zip", 200, 8000, 125, false, false);
      }

      if (var1 == 31) {
         this.strack = new RadicalMod("music/stage" + var1 + ".zip", 350, 7900, 125, false, false);
      }

      if (var1 == 32) {
         this.strack = new RadicalMod("music/stage" + var1 + ".zip", 310, 8000, 125, false, false);
      }

      if (var1 < 0) {
         if (!var2.equals("")) {
            if (var1 != -2) {
               this.strack = new RadicalMod("mystages/mymusic/" + var2 + ".zip", var3, 8000, 125, false, false);
            } else {
               this.strack = new RadicalMod(var2, var3, 8000, 125, false, true);
            }
         } else {
            this.strack = new RadicalMod();
         }
      }

      this.loadedt = true;
   }

   public void musicomp(int var1, Control var2) {
      this.hipnoload(var1, true);
      if (this.multion != 0) {
         this.forstart--;
         if (this.lan && this.im == 0) {
            this.forstart = 0;
         }
      }

      if (var2.handb || var2.enter || this.forstart == 0) {
         System.gc();
         this.m.trk = 0;
         this.m.crs = false;
         this.m.ih = 0;
         this.m.iw = 0;
         this.m.h = 450;
         this.m.w = 800;
         this.m.focus_point = 400;
         this.m.cx = 400;
         this.m.cy = 225;
         this.m.cz = 50;
         this.rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
         this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
         if (this.multion == 0) {
            this.fase = 0;
         } else {
            this.fase = 7001;
            this.forstart = 0;
            if (!this.lan) {
               try {
                  this.socket = new Socket(this.server, this.servport);
                  this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                  this.dout = new PrintWriter(this.socket.getOutputStream(), true);
                  this.runtyp = -101;
                  this.runner = new Thread(this);
                  this.runner.start();
               } catch (Exception var4) {
               }
            }
         }

         if (Math.random() > Math.random()) {
            this.dudo = 250;
         } else {
            this.dudo = 428;
         }

         var2.handb = false;
         var2.enter = false;
      }
   }

   public void waitenter() {
      if (this.forstart < 690) {
         this.rd.setFont(new Font("Arial", 1, 13));
         this.ftm = this.rd.getFontMetrics();
         this.drawcs(70, "Waiting for all players to finish loading!", 0, 0, 0, 0);
         if (this.forstart <= 640) {
            this.drawcs(90, "" + (640 - this.forstart) / 32 + "", 0, 0, 0, 0);
         } else {
            this.drawcs(90, "Your connection to game may have been lost...", 0, 0, 0, 0);
         }

         this.rd.setFont(new Font("Arial", 1, 11));
         this.ftm = this.rd.getFontMetrics();
         if (this.tflk) {
            this.drawcs(125, "Get Ready!", 0, 0, 0, 0);
            this.tflk = false;
         } else {
            this.drawcs(125, "Get Ready!", 0, 128, 255, 0);
            this.tflk = true;
         }
      }

      this.forstart++;
      if (this.forstart == 700) {
         this.fase = -2;
         this.winner = false;
      }
   }

   public void multistat(Control var1, CheckPoints var2, int var3, int var4, boolean var5, UDPMistro var6) {
      int var7 = -1;
      if (this.fase != -2) {
         if (this.exitm != 0 && !this.holdit) {
            if (this.lan && this.im == 0) {
               this.rd.setFont(new Font("Arial", 1, 13));
               this.ftm = this.rd.getFontMetrics();
               this.drawcs(125, "You cannot exit game.  Your computer is the LAN server!", 0, 0, 0, 0);
               this.msgflk[0]++;
               if (this.msgflk[0] == 67 || var5) {
                  this.msgflk[0] = 0;
                  this.exitm = 0;
               }

               this.rd.setFont(new Font("Arial", 1, 11));
               this.ftm = this.rd.getFontMetrics();
            } else {
               if (var5) {
                  if (var3 > 357 && var3 < 396 && var4 > 162 && var4 < 179) {
                     this.exitm = 2;
                     if (this.multion == 1 && !this.lan && this.sendstat == 0) {
                        this.sendstat = 1;
                        if (this.runtyp != -101) {
                           if (this.runner != null) {
                              this.runner.stop();
                           }

                           this.runner = new Thread(this);
                           this.runner.start();
                        }
                     }
                  } else {
                     this.exitm = 0;
                  }
               }

               float[] var20 = new float[3];
               Color.RGBtoHSB(this.m.cgrnd[0], this.m.cgrnd[1], this.m.cgrnd[2], var20);
               var20[1] = (float)(var20[1] - 0.15);
               if (var20[1] < 0.0F) {
                  var20[1] = 0.0F;
               }

               var20[2] = (float)(var20[2] + 0.15);
               if (var20[2] > 1.0F) {
                  var20[2] = 1.0F;
               }

               this.rd.setColor(Color.getHSBColor(var20[0], var20[1], var20[2]));
               this.rd.fillRect(357, 169, 39, 10);
               this.rd.fillRect(403, 169, 39, 10);
               var20[1] = (float)(var20[1] - 0.07);
               if (var20[1] < 0.0F) {
                  var20[1] = 0.0F;
               }

               var20[2] = (float)(var20[2] + 0.07);
               if (var20[2] > 1.0F) {
                  var20[2] = 1.0F;
               }

               this.rd.setColor(Color.getHSBColor(var20[0], var20[1], var20[2]));
               this.rd.fillRect(357, 162, 39, 7);
               this.rd.fillRect(403, 162, 39, 7);
               this.drawhi(this.exitgame, 116);
               if (var3 > 357 && var3 < 396 && var4 > 162 && var4 < 179) {
                  this.rd.setColor(new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]));
                  this.rd.fillRect(357, 162, 39, 17);
               }

               if (var3 > 403 && var3 < 442 && var4 > 162 && var4 < 179) {
                  this.rd.setColor(new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]));
                  this.rd.fillRect(403, 162, 39, 17);
               }

               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawString("Yes", 366, 175);
               this.rd.drawString("No", 416, 175);
               this.rd.setColor(new Color(this.m.csky[0] / 2, this.m.csky[1] / 2, this.m.csky[2] / 2));
               this.rd.drawRect(403, 162, 39, 17);
               this.rd.drawRect(357, 162, 39, 17);
            }
         } else if (this.exitm == 4) {
            if (var5) {
               if (var3 > 357 && var3 < 396 && var4 > 362 && var4 < 379) {
                  this.alocked = -1;
                  this.lalocked = -1;
                  this.multion = 2;
                  var1.multion = this.multion;
                  this.holdit = false;
                  this.exitm = 0;
                  var1.chatup = 0;
               }

               if ((!this.lan || this.im != 0) && var3 > 403 && var3 < 442 && var4 > 362 && var4 < 379) {
                  this.holdcnt = 600;
                  this.exitm = 0;
                  var1.chatup = 0;
               }
            }

            float[] var8 = new float[3];
            Color.RGBtoHSB(this.m.cgrnd[0], this.m.cgrnd[1], this.m.cgrnd[2], var8);
            var8[1] = (float)(var8[1] - 0.15);
            if (var8[1] < 0.0F) {
               var8[1] = 0.0F;
            }

            var8[2] = (float)(var8[2] + 0.15);
            if (var8[2] > 1.0F) {
               var8[2] = 1.0F;
            }

            this.rd.setColor(Color.getHSBColor(var8[0], var8[1], var8[2]));
            this.rd.fillRect(357, 369, 39, 10);
            if (!this.lan || this.im != 0) {
               this.rd.fillRect(403, 369, 39, 10);
            }

            var8[1] = (float)(var8[1] - 0.07);
            if (var8[1] < 0.0F) {
               var8[1] = 0.0F;
            }

            var8[2] = (float)(var8[2] + 0.07);
            if (var8[2] > 1.0F) {
               var8[2] = 1.0F;
            }

            this.rd.setColor(Color.getHSBColor(var8[0], var8[1], var8[2]));
            this.rd.fillRect(357, 362, 39, 7);
            if (!this.lan || this.im != 0) {
               this.rd.fillRect(403, 362, 39, 7);
            }

            this.rd.setColor(new Color(0, 0, 0));
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            if (this.lan && this.im == 0) {
               this.drawcs(140, "( You cannot exit game.  Your computer is the LAN server... )", 0, 0, 0, 0);
            }

            this.rd.drawString("Continue watching this game?", 155, 375);
            if (var3 > 357 && var3 < 396 && var4 > 362 && var4 < 379) {
               this.rd.setColor(new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]));
               this.rd.fillRect(357, 362, 39, 17);
            }

            if ((!this.lan || this.im != 0) && var3 > 403 && var3 < 442 && var4 > 362 && var4 < 379) {
               this.rd.setColor(new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]));
               this.rd.fillRect(403, 362, 39, 17);
            }

            this.rd.setFont(new Font("Arial", 1, 11));
            this.ftm = this.rd.getFontMetrics();
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawString("Yes", 366, 375);
            if (!this.lan || this.im != 0) {
               this.rd.drawString("No", 416, 375);
            }

            this.rd.setColor(new Color(this.m.csky[0] / 2, this.m.csky[1] / 2, this.m.csky[2] / 2));
            if (this.lan && this.im == 0) {
               this.rd.drawRoundRect(147, 357, 262, 27, 7, 20);
            } else {
               this.rd.drawRoundRect(147, 357, 301, 27, 7, 20);
            }

            this.rd.drawRect(357, 362, 39, 17);
            if (!this.lan || this.im != 0) {
               this.rd.drawRect(403, 362, 39, 17);
            }
         }

         if (this.runtyp == -101 && !this.lan) {
            if (this.warning != 0 && this.warning != 210) {
               this.drawWarning();
               if (this.app.cmsg.isShowing()) {
                  this.app.cmsg.hide();
                  this.app.requestFocus();
               }

               this.warning++;
            } else {
               byte var21 = 0;
               byte var9 = 0;
               if (this.clanchat) {
                  var21 = 1;
                  var9 = -23;
               } else if (var1.chatup == 2) {
                  var1.chatup = 1;
               }

               for (int var10 = var21; var10 >= 0; var10--) {
                  boolean var11 = false;
                  if (var3 > 5 && var3 < 33 && var4 > 423 + var9 && var4 < 446 + var9) {
                     var11 = true;
                     if (var1.chatup != 0) {
                        var1.chatup = 0;
                     }
                  } else if (this.pointc[var10] != 6) {
                     this.pointc[var10] = 6;
                     this.floater[var10] = 1;
                  }

                  if (var3 > 33 && var3 < 666 && var4 > 423 + var9 && var4 < 446 + var9 && this.lxm != var3 && var4 != this.lym && this.lxm != -100) {
                     var1.chatup = var10 + 1;
                     this.cntchatp[var10] = 0;
                  }

                  if (var10 == 0) {
                     this.lxm = var3;
                     this.lym = var4;
                  }

                  if (this.exitm != 0 && this.exitm != 4) {
                     var1.chatup = 0;
                  }

                  boolean var12 = false;
                  if (var1.enter && var1.chatup == var10 + 1) {
                     var12 = true;
                     var1.chatup = 0;
                     var1.enter = false;
                     this.lxm = -100;
                  }

                  if (var5) {
                     if (this.mouson == 0) {
                        if (var3 > 676 && var3 < 785 && var4 > 426 + var9 && var4 < 443 + var9 && var1.chatup == var10 + 1) {
                           var12 = true;
                           var1.chatup = 0;
                        }

                        if (var11 && this.pointc[var10] > 0) {
                           this.pointc[var10]--;
                           this.floater[var10] = 1;
                        }

                        if (var10 == 0) {
                           this.mouson = 1;
                        }
                     }

                     if (var10 == 0) {
                        var1.chatup = 0;
                     }
                  } else if (var10 == 0 && this.mouson != 0) {
                     this.mouson = 0;
                  }

                  if (var12) {
                     String var13 = "";
                     int var14 = 0;

                     for (int var15 = 1; var14 < this.lcmsg[var10].length(); var14++) {
                        String var16 = "" + this.lcmsg[var10].charAt(var14);
                        if (var16.equals(" ")) {
                           var15++;
                        } else {
                           var15 = 0;
                        }

                        if (var15 < 2) {
                           var13 = var13 + var16;
                        }
                     }

                     if (!var13.equals("")) {
                        var13 = var13.replace('|', ':');
                        if (var13.toLowerCase().indexOf(this.app.tpass.getText().toLowerCase()) != -1) {
                           var13 = " ";
                        }

                        if (!this.msgcheck(var13) && this.updatec[var10] > -12) {
                           if (this.cnames[var10][6].equals("Game Chat  ") || this.cnames[var10][6].equals("" + this.clan + "'s Chat  ")) {
                              this.cnames[var10][6] = "";
                           }

                           for (int var66 = 0; var66 < 6; var66++) {
                              this.sentn[var10][var66] = this.sentn[var10][var66 + 1];
                              this.cnames[var10][var66] = this.cnames[var10][var66 + 1];
                           }

                           this.sentn[var10][6] = var13;
                           this.cnames[var10][6] = this.nickname;
                           if (this.pointc[var10] != 6) {
                              this.pointc[var10] = 6;
                              this.floater[var10] = 1;
                           }

                           this.msgflk[var10] = 110;
                           if (this.updatec[var10] > -11) {
                              this.updatec[var10] = -11;
                           } else {
                              this.updatec[var10]--;
                           }
                        } else {
                           this.warning++;
                        }
                     }
                  }

                  if (var11 || this.floater[var10] != 0 || var1.chatup == var10 + 1 || this.msgflk[var10] != 0) {
                     float[] var42 = new float[3];
                     Color.RGBtoHSB(this.m.cgrnd[0], this.m.cgrnd[1], this.m.cgrnd[2], var42);
                     var42[1] = (float)(var42[1] - 0.15);
                     if (var42[1] < 0.0F) {
                        var42[1] = 0.0F;
                     }

                     var42[2] = (float)(var42[2] + 0.15);
                     if (var42[2] > 1.0F) {
                        var42[2] = 1.0F;
                     }

                     this.rd.setColor(Color.getHSBColor(var42[0], var42[1], var42[2]));
                     this.rd.fillRect(33, 423 + var9, 761, 23);
                  }

                  if (var1.chatup == 0 && this.app.cmsg.isShowing()) {
                     this.app.cmsg.hide();
                     this.app.requestFocus();
                  }

                  if (var1.chatup == var10 + 1) {
                     this.msgflk[var10] = 0;
                     var7 = var10;
                  } else {
                     int var43 = 0;
                     int var55 = (int)(48.0F + 48.0F * (this.m.snap[1] / 100.0F));
                     if (var55 > 255) {
                        var55 = 255;
                     }

                     if (var55 < 0) {
                        var55 = 0;
                     }

                     int var64 = (int)(96.0F + 96.0F * (this.m.snap[2] / 100.0F));
                     if (var64 > 255) {
                        var64 = 255;
                     }

                     if (var64 < 0) {
                        var64 = 0;
                     }

                     if (this.floater[var10] != 0) {
                        for (int var68 = 6; var68 >= 0; var68--) {
                           if (this.pointc[var10] == var68) {
                              if (Math.abs(var43 + this.movepos[var10]) > 10) {
                                 this.floater[var10] = (this.movepos[var10] + var43) / 4;
                                 if (this.floater[var10] > -5 && this.floater[var10] < 0) {
                                    this.floater[var10] = -5;
                                 }

                                 if (this.floater[var10] < 10 && this.floater[var10] > 0) {
                                    this.floater[var10] = 10;
                                 }

                                 this.movepos[var10] = this.movepos[var10] - this.floater[var10];
                              } else {
                                 this.movepos[var10] = -var43;
                                 this.floater[var10] = 0;
                              }
                           }

                           if (this.pointc[var10] >= var68) {
                              this.rd.setColor(new Color(0, var55, var64));
                              this.rd.setFont(new Font("Tahoma", 1, 11));
                              this.ftm = this.rd.getFontMetrics();
                              this.rd.drawString(this.cnames[var10][var68] + ": ", 39 + var43 + this.movepos[var10], 439 + var9);
                              var43 += this.ftm.stringWidth(this.cnames[var10][var68] + ": ");
                              this.rd.setColor(new Color(0, 0, 0));
                              this.rd.setFont(new Font("Tahoma", 0, 11));
                              this.ftm = this.rd.getFontMetrics();
                              this.rd.drawString(this.sentn[var10][var68] + "   ", 39 + var43 + this.movepos[var10], 439 + var9);
                              var43 += this.ftm.stringWidth(this.sentn[var10][var68] + "   ");
                           } else {
                              var43 += this.ftm.stringWidth(this.cnames[var10][var68] + ": ");
                              var43 += this.ftm.stringWidth(this.sentn[var10][var68] + "   ");
                           }
                        }

                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.fillRect(0, 423 + var9, 5, 24);
                        this.rd.fillRect(794, 423 + var9, 6, 24);
                     } else {
                        for (int var67 = this.pointc[var10]; var67 >= 0; var67--) {
                           if (var67 == 6 && this.msgflk[var10] != 0) {
                              this.msgflk[var10]--;
                           }

                           this.rd.setColor(new Color(0, var55, var64));
                           this.rd.setFont(new Font("Tahoma", 1, 11));
                           this.ftm = this.rd.getFontMetrics();
                           if (this.ftm.stringWidth(this.cnames[var10][var67] + ": ") + 39 + var43 >= 775) {
                              String var71 = "";

                              for (int var73 = 0; this.ftm.stringWidth(var71) + 39 + var43 < 775 && var73 < this.cnames[var10][var67].length(); var73++) {
                                 var71 = var71 + this.cnames[var10][var67].charAt(var73);
                              }

                              var71 = var71 + "...";
                              if (var67 != 6 || this.msgflk[var10] < 67 || this.msgflk[var10] % 3 != 0) {
                                 this.rd.drawString(var71, 39 + var43, 439 + var9);
                              }
                              break;
                           }

                           if (var67 != 6 || this.msgflk[var10] < 67 || this.msgflk[var10] % 3 != 0) {
                              this.rd.drawString(this.cnames[var10][var67] + ": ", 39 + var43, 439 + var9);
                           }

                           var43 += this.ftm.stringWidth(this.cnames[var10][var67] + ": ");
                           this.rd.setColor(new Color(0, 0, 0));
                           this.rd.setFont(new Font("Tahoma", 0, 11));
                           this.ftm = this.rd.getFontMetrics();
                           if (this.ftm.stringWidth(this.sentn[var10][var67]) + 39 + var43 >= 775) {
                              String var17 = "";

                              for (int var18 = 0; this.ftm.stringWidth(var17) + 39 + var43 < 775 && var18 < this.sentn[var10][var67].length(); var18++) {
                                 var17 = var17 + this.sentn[var10][var67].charAt(var18);
                              }

                              var17 = var17 + "...";
                              if (var67 != 6 || this.msgflk[var10] < 67 || this.msgflk[var10] % 3 != 0) {
                                 this.rd.drawString(var17, 39 + var43, 439 + var9);
                              }
                              break;
                           }

                           if (var67 != 6 || this.msgflk[var10] < 67 || this.msgflk[var10] % 3 != 0) {
                              this.rd.drawString(this.sentn[var10][var67] + "   ", 39 + var43, 439 + var9);
                           }

                           var43 += this.ftm.stringWidth(this.sentn[var10][var67] + "   ");
                        }
                     }
                  }

                  if (var11 || this.floater[var10] != 0) {
                     float[] var47 = new float[3];
                     Color.RGBtoHSB(this.m.cgrnd[0], this.m.cgrnd[1], this.m.cgrnd[2], var47);
                     var47[1] = (float)(var47[1] - 0.076);
                     if (var47[1] < 0.0F) {
                        var47[1] = 0.0F;
                     }

                     var47[2] = (float)(var47[2] + 0.076);
                     if (var47[2] > 1.0F) {
                        var47[2] = 1.0F;
                     }

                     this.rd.setColor(Color.getHSBColor(var47[0], var47[1], var47[2]));
                     this.rd.fillRect(5, 423 + var9, 28, 23);
                  }

                  if (var11) {
                     this.rd.setColor(new Color(0, 0, 0));
                  } else {
                     this.rd.setColor(new Color((int)(this.m.cgrnd[0] / 2.0F), (int)(this.m.cgrnd[1] / 2.0F), (int)(this.m.cgrnd[2] / 2.0F)));
                  }

                  this.rd.setFont(new Font("Tahoma", 1, 11));
                  this.rd.drawString("<<", 10, 439 + var9);
                  this.rd.setColor(new Color(0, 0, 0));
                  this.rd.drawRect(5, 423 + var9, 789, 23);
                  this.rd.drawLine(33, 423 + var9, 33, 446 + var9);
                  var9 += 23;
               }

               if (var3 > 775 && var3 < 794 && var4 > 409 - var21 * 23 && var4 < 423 - var21 * 23) {
                  this.rd.drawRect(775, 409 - var21 * 23, 19, 14);
                  this.rd.setColor(new Color(200, 0, 0));
                  if (var5) {
                     var1.chatup = 0;
                     if (this.app.cmsg.isShowing()) {
                        this.app.cmsg.hide();
                        this.app.requestFocus();
                     }

                     this.runtyp = 0;

                     try {
                        this.socket.close();
                        this.socket = null;
                        this.din.close();
                        this.din = null;
                        this.dout.close();
                        this.dout = null;
                     } catch (Exception var19) {
                     }
                  }
               }

               this.rd.setFont(new Font("Arial", 1, 12));
               this.rd.drawString("x", 782, 420 - var21 * 23);
            }

            this.rd.setFont(new Font("Arial", 1, 11));
            this.ftm = this.rd.getFontMetrics();
         } else if (var1.chatup != 0) {
            var1.chatup = 0;
            if (!this.lan) {
               this.runtyp = -101;
               if (this.runner != null) {
                  this.runner.stop();
               }

               this.runner = new Thread(this);
               this.runner.start();
            }
         }

         if (this.holdit && this.multion == 1 && !this.lan && this.sendstat == 0) {
            this.sendstat = 1;
            if (this.runtyp != -101) {
               if (this.runner != null) {
                  this.runner.stop();
               }

               this.runner = new Thread(this);
               this.runner.start();
            }
         }

         if (var1.arrace && this.starcnt < 38 && !this.holdit && var2.stage != 10 || this.multion >= 2) {
            if (this.alocked != -1 && var2.dested[this.alocked] != 0) {
               this.alocked = -1;
               this.lalocked = -1;
            }

            if (this.multion >= 2) {
               if (this.alocked != -1 && !this.holdit) {
                  this.cntflock = 0;
               } else {
                  if (this.cntflock == 100) {
                     for (int var22 = 0; var22 < this.nplayers; var22++) {
                        if (this.holdit) {
                           if (var2.pos[var22] == 0) {
                              this.alocked = var22;
                              this.im = var22;
                           }
                        } else if (var2.dested[var22] == 0) {
                           this.alocked = var22;
                           this.im = var22;
                        }
                     }
                  }

                  this.cntflock++;
               }

               if (this.lan) {
                  boolean var23 = true;

                  for (int var27 = 0; var27 < this.nplayers; var27++) {
                     if (this.dested[var27] == 0 && this.plnames[var27].indexOf("MadBot") == -1) {
                        var23 = false;
                     }
                  }

                  if (var23) {
                     this.exitm = 2;
                  }
               }
            }

            int var24 = this.nplayers;

            for (int var28 = 0; var28 < var24; var28++) {
               boolean var31 = false;

               for (int var33 = 0; var33 < this.nplayers; var33++) {
                  if (var2.pos[var33] == var28 && var2.dested[var33] == 0 && !var31) {
                     int var34 = 0;
                     int var48 = 0;
                     int var56 = 0;
                     var56 = (int)(100.0F + 100.0F * (this.m.snap[2] / 100.0F));
                     if (var56 > 255) {
                        var56 = 255;
                     }

                     if (var56 < 0) {
                        var56 = 0;
                     }

                     this.rd.setColor(new Color(0, 0, var56));
                     if (var28 == 0) {
                        this.rd.drawString("1st", 673, 76 + 30 * var28);
                     }

                     if (var28 == 1) {
                        this.rd.drawString("2nd", 671, 76 + 30 * var28);
                     }

                     if (var28 == 2) {
                        this.rd.drawString("3rd", 671, 76 + 30 * var28);
                     }

                     if (var28 >= 3) {
                        this.rd.drawString("" + (var28 + 1) + "th", 671, 76 + 30 * var28);
                     }

                     if (this.clangame != 0) {
                        short var58;
                        if (this.pclan[var33].toLowerCase().equals(this.gaclan.toLowerCase())) {
                           var34 = (short)255;
                           var48 = (short)128;
                           var58 = 0;
                        } else {
                           var34 = (short)0;
                           var48 = (short)128;
                           var58 = 255;
                        }

                        var34 = (int)(var34 + var34 * (this.m.snap[0] / 100.0F));
                        if (var34 > 255) {
                           var34 = 255;
                        }

                        if (var34 < 0) {
                           var34 = 0;
                        }

                        var48 = (int)(var48 + var48 * (this.m.snap[1] / 100.0F));
                        if (var48 > 255) {
                           var48 = 255;
                        }

                        if (var48 < 0) {
                           var48 = 0;
                        }

                        var58 = (short)(var58 + var58 * (this.m.snap[2] / 100.0F));
                        if (var58 > 255) {
                           var58 = 255;
                        }

                        if (var58 < 0) {
                           var58 = 0;
                        }

                        this.rd.setColor(new Color(var34, var48, var58));
                        this.rd.drawString(this.plnames[var33], 731 - this.ftm.stringWidth(this.plnames[var33]) / 2, 70 + 30 * var28);
                     }

                     this.rd.setColor(new Color(0, 0, 0));
                     this.rd.drawString(this.plnames[var33], 730 - this.ftm.stringWidth(this.plnames[var33]) / 2, 70 + 30 * var28);
                     int var65 = (int)(60.0F * var2.magperc[var33]);
                     int var37 = 244;
                     var48 = 244;
                     int var60 = 11;
                     if (var65 > 20) {
                        var48 = (int)(244.0F - 233.0F * ((var65 - 20) / 40.0F));
                     }

                     var37 = (int)(var37 + var37 * (this.m.snap[0] / 100.0F));
                     if (var37 > 255) {
                        var37 = 255;
                     }

                     if (var37 < 0) {
                        var37 = 0;
                     }

                     var48 = (int)(var48 + var48 * (this.m.snap[1] / 100.0F));
                     if (var48 > 255) {
                        var48 = 255;
                     }

                     if (var48 < 0) {
                        var48 = 0;
                     }

                     var60 = (int)(var60 + var60 * (this.m.snap[2] / 100.0F));
                     if (var60 > 255) {
                        var60 = 255;
                     }

                     if (var60 < 0) {
                        var60 = 0;
                     }

                     this.rd.setColor(new Color(var37, var48, var60));
                     this.rd.fillRect(700, 74 + 30 * var28, var65, 5);
                     this.rd.setColor(new Color(0, 0, 0));
                     this.rd.drawRect(700, 74 + 30 * var28, 60, 5);
                     boolean var69 = false;
                     if ((this.im != var33 || this.multion >= 2) && var3 > 661 && var3 < 775 && var4 > 58 + 30 * var28 && var4 < 83 + 30 * var28) {
                        var69 = true;
                        if (!var5) {
                           if (this.onlock) {
                              this.onlock = false;
                           }
                        } else {
                           if (!this.onlock) {
                              if (this.alocked == var33 && this.multion < 2) {
                                 this.alocked = -1;
                              } else {
                                 this.alocked = var33;
                                 if (this.multion >= 2) {
                                    this.im = var33;
                                 }
                              }
                           }

                           this.onlock = true;
                        }
                     }

                     if (this.alocked == var33) {
                        var37 = (int)(159.0F + 159.0F * (this.m.snap[0] / 100.0F));
                        if (var37 > 255) {
                           var37 = 255;
                        }

                        if (var37 < 0) {
                           var37 = 0;
                        }

                        var48 = (int)(207.0F + 207.0F * (this.m.snap[1] / 100.0F));
                        if (var48 > 255) {
                           var48 = 255;
                        }

                        if (var48 < 0) {
                           var48 = 0;
                        }

                        var60 = (int)(255.0F + 255.0F * (this.m.snap[2] / 100.0F));
                        if (var60 > 255) {
                           var60 = 255;
                        }

                        if (var60 < 0) {
                           var60 = 0;
                        }

                        this.rd.setColor(new Color(var37, var48, var60));
                        this.rd.drawRect(661, 58 + 30 * var28, 114, 25);
                        this.rd.drawRect(662, 59 + 30 * var28, 112, 23);
                     }

                     if (var69 && !this.onlock) {
                        if (this.alocked == var33) {
                           var37 = (int)(120.0F + 120.0F * (this.m.snap[0] / 100.0F));
                           if (var37 > 255) {
                              var37 = 255;
                           }

                           if (var37 < 0) {
                              var37 = 0;
                           }

                           var48 = (int)(114.0F + 114.0F * (this.m.snap[1] / 100.0F));
                           if (var48 > 255) {
                              var48 = 255;
                           }

                           if (var48 < 0) {
                              var48 = 0;
                           }

                           var60 = (int)(255.0F + 255.0F * (this.m.snap[2] / 100.0F));
                           if (var60 > 255) {
                              var60 = 255;
                           }

                           if (var60 < 0) {
                              var60 = 0;
                           }
                        } else {
                           var37 = (int)(140.0F + 140.0F * (this.m.snap[0] / 100.0F));
                           if (var37 > 255) {
                              var37 = 255;
                           }

                           if (var37 < 0) {
                              var37 = 0;
                           }

                           var48 = (int)(160.0F + 160.0F * (this.m.snap[1] / 100.0F));
                           if (var48 > 255) {
                              var48 = 255;
                           }

                           if (var48 < 0) {
                              var48 = 0;
                           }

                           var60 = (int)(255.0F + 255.0F * (this.m.snap[2] / 100.0F));
                           if (var60 > 255) {
                              var60 = 255;
                           }

                           if (var60 < 0) {
                              var60 = 0;
                           }
                        }

                        this.rd.setColor(new Color(var37, var48, var60));
                        this.rd.drawRect(660, 57 + 30 * var28, 116, 27);
                     }

                     var31 = true;
                  }
               }
            }
         }

         if (var6.go && var6.runon == 1 && !this.holdit) {
            int var25 = 0;
            int var29 = 0;

            for (int var32 = 0; var32 < this.nplayers; var32++) {
               if (var32 != var6.im) {
                  var29++;
                  if (var6.lframe[var32] != var6.lcframe[var32] && var6.force[var32] != 7) {
                     var6.lcframe[var32] = var6.lframe[var32];
                  } else {
                     var25++;
                  }
               }
            }

            if (var25 == var29) {
               this.discon++;
            } else if (this.discon != 0) {
               this.discon = 0;
            }

            if (this.discon == 240) {
               var6.runon = 2;
            }
         }
      }

      if (var7 != -1) {
         float[] var26 = new float[3];
         Color.RGBtoHSB(this.m.cgrnd[0], this.m.cgrnd[1], this.m.cgrnd[2], var26);
         var26[1] = (float)(var26[1] - 0.22);
         if (var26[1] < 0.0F) {
            var26[1] = 0.0F;
         }

         var26[2] = (float)(var26[2] + 0.22);
         if (var26[2] > 1.0F) {
            var26[2] = 1.0F;
         }

         Color var30 = Color.getHSBColor(var26[0], var26[1], var26[2]);
         this.rd.setColor(var30);
         this.rd.fillRect(676, 426 - var7 * 23, 109, 7);
         this.rd.setColor(new Color(0, 0, 0));
         this.rd.setFont(new Font("Tahoma", 1, 11));
         this.rd.drawString("Send Message  >", 684, 439 - var7 * 23);
         this.rd.setColor(new Color((int)(this.m.cgrnd[0] / 1.2F), (int)(this.m.cgrnd[1] / 1.2F), (int)(this.m.cgrnd[2] / 1.2F)));
         this.rd.drawRect(676, 426 - var7 * 23, 109, 17);
         if (!this.app.cmsg.isShowing()) {
            this.app.cmsg.show();
            this.app.cmsg.requestFocus();
            this.lcmsg[var7] = "";
            this.app.cmsg.setText("");
            this.app.cmsg.setBackground(var30);
         }

         this.app.movefield(this.app.cmsg, 34, 424 - var7 * 23, 633, 22);
         if (this.app.cmsg.getText().equals(this.lcmsg[var7])) {
            this.cntchatp[var7]++;
         } else {
            this.cntchatp[var7] = -200;
         }

         this.lcmsg[var7] = "" + this.app.cmsg.getText();
         if (this.cntchatp[var7] == 67) {
            var1.chatup = 0;
         }

         if (this.app.cmsg.getText().length() > 100) {
            this.app.cmsg.setText(this.app.cmsg.getText().substring(0, 100));
            this.app.cmsg.select(100, 100);
         }

         this.rd.setFont(new Font("Arial", 1, 11));
         this.ftm = this.rd.getFontMetrics();
      }
   }

   public void levelhigh(int var1, int var2, int var3, int var4, int var5) {
      this.rd.drawImage(this.gameh, 301, 20, null);
      byte var6 = 16;
      short var7 = 48;
      short var8 = 96;
      if (var4 < 50) {
         if (this.aflk) {
            var6 = 106;
            var7 = 176;
            var8 = 255;
            this.aflk = false;
         } else {
            this.aflk = true;
         }
      }

      if (var1 != this.im) {
         if (var3 == 0) {
            this.drawcs(60, "You Wasted 'em!", var6, var7, var8, 0);
         } else if (var3 == 1) {
            this.drawcs(60, "Close Finish!", var6, var7, var8, 0);
         } else {
            this.drawcs(60, "Close Finish!  Almost got it!", var6, var7, var8, 0);
         }
      } else if (var2 == 229) {
         if (this.discon != 240) {
            this.drawcs(60, "Wasted!", var6, var7, var8, 0);
         } else {
            this.drawcs(60, "Disconnected!", var6, var7, var8, 0);
         }
      } else if (var5 <= 2 && var5 >= 0) {
         this.drawcs(60, "Best Stunt!", var6, var7, var8, 0);
      } else {
         this.drawcs(60, "Stunts!", var6, var7, var8, 0);
      }

      this.drawcs(380, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
   }

   public void inst(Control var1) {
      if (this.flipo == 0) {
         this.flipo = 1;
      }

      if (this.flipo == 2) {
         this.flipo = 3;
         this.dudo = 200;
      }

      if (this.flipo == 4) {
         this.flipo = 5;
         this.dudo = 250;
      }

      if (this.flipo == 6) {
         this.flipo = 7;
         this.dudo = 200;
      }

      if (this.flipo == 8) {
         this.flipo = 9;
         this.dudo = 250;
      }

      if (this.flipo == 10) {
         this.flipo = 11;
         this.dudo = 200;
      }

      if (this.flipo == 12) {
         this.flipo = 13;
         this.dudo = 200;
      }

      if (this.flipo == 14) {
         this.flipo = 15;
         this.dudo = 100;
      }

      this.mainbg(2);
      this.rd.setComposite(AlphaComposite.getInstance(3, 0.3F));
      this.rd.drawImage(this.bggo, 65, 25, null);
      this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
      this.rd.setColor(new Color(0, 0, 0));
      this.rd.fillRect(735, 0, 65, 450);
      this.rd.fillRect(65, 425, 670, 25);
      if (this.aflk) {
         this.aflk = false;
      } else {
         this.aflk = true;
      }

      if (this.flipo != 1 && this.flipo != 16) {
         if (this.dudo > 0) {
            if (this.aflk) {
               if (Math.random() > Math.random()) {
                  this.duds = (int)(Math.random() * 3.0);
               } else {
                  this.duds = (int)(Math.random() * 2.0);
               }
            }

            this.dudo--;
         } else {
            this.duds = 0;
         }

         this.rd.setComposite(AlphaComposite.getInstance(3, 0.4F));
         this.rd.drawImage(this.dude[this.duds], 95, 15, null);
         this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
         this.rd.drawImage(this.oflaot, 192, 42, null);
      }

      this.rd.setColor(new Color(0, 64, 128));
      this.rd.setFont(new Font("Arial", 1, 13));
      if (this.flipo == 3 || this.flipo == 5) {
         if (this.flipo == 3) {
            this.rd.drawString("Hello!  Welcome to the world of", 262, 67);
            this.rd.drawString("!", 657, 67);
            this.rd.drawImage(this.nfm, 469, 55, null);
            this.rd.drawString("In this game there are two ways to complete a stage.", 262, 107);
            this.rd.drawString("One is by racing and finishing in first place, the other is by", 262, 127);
            this.rd.drawString("wasting and crashing all the other cars in the stage!", 262, 147);
         } else {
            this.rd.setColor(new Color(0, 128, 255));
            this.rd.drawString("While racing, you will need to focus on going fast and passing", 262, 67);
            this.rd.drawString("through all the checkpoints in the track. To complete a lap, you", 262, 87);
            this.rd.drawString("must not miss a checkpoint.", 262, 107);
            this.rd.drawString("While wasting, you will just need to chase the other cars and", 262, 127);
            this.rd.drawString("crash into them (without worrying about track and checkpoints).", 262, 147);
         }

         this.rd.setColor(new Color(0, 0, 0));
         this.rd.drawImage(this.racing, 165, 185, null);
         this.rd.drawImage(this.ory, 429, 235, null);
         this.rd.drawImage(this.wasting, 492, 185, null);
         this.rd.setFont(new Font("Arial", 1, 11));
         this.rd.drawString("Checkpoint", 392, 189);
         this.rd.setFont(new Font("Arial", 1, 13));
         this.rd.drawString("Drive your car using the Arrow Keys and Spacebar", 125, 320);
         this.rd.drawImage(this.space, 171, 355, null);
         this.rd.drawImage(this.arrows, 505, 323, null);
         this.rd.setFont(new Font("Arial", 1, 11));
         this.rd.drawString("(When your car is on the ground Spacebar is for Handbrake)", 125, 341);
         this.rd.drawString("Accelerate", 515, 319);
         this.rd.drawString("Brake/Reverse", 506, 397);
         this.rd.drawString("Turn left", 454, 375);
         this.rd.drawString("Turn right", 590, 375);
         this.rd.drawString("Handbrake", 247, 374);
      }

      if (this.flipo == 7 || this.flipo == 9) {
         if (this.flipo == 7) {
            this.rd.drawString("Whether you are racing or wasting the other cars you will need", 262, 67);
            this.rd.drawString("to power up your car.", 262, 87);
            this.rd.drawString("=> More 'Power' makes your car become faster and stronger!", 262, 107);
            this.rd.drawString("To power up your car (and keep it powered up) you will need to", 262, 127);
            this.rd.drawString("perform stunts!", 262, 147);
            this.rd.drawImage(this.chil, 167, 295, null);
         } else {
            this.rd.drawString("The better the stunt the more power you get!", 262, 67);
            this.rd.setColor(new Color(0, 128, 255));
            this.rd.drawString("Forward looping pushes your car forwards in the air and helps", 262, 87);
            this.rd.drawString("when racing. Backward looping pushes your car upwards giving it", 262, 107);
            this.rd.drawString("more hang time in the air making it easier to control its landing.", 262, 127);
            this.rd.drawString("Left and right rolls shift your car in the air left and right slightly.", 262, 147);
            if (this.aflk || this.dudo < 150) {
               this.rd.drawImage(this.chil, 167, 295, null);
            }
         }

         this.rd.setColor(new Color(0, 0, 0));
         this.rd.drawImage(this.stunts, 105, 175, null);
         this.rd.drawImage(this.opwr, 540, 253, null);
         this.rd.setFont(new Font("Arial", 1, 13));
         this.rd.drawString("To perform stunts. When your car is in the AIR:", 125, 310);
         this.rd.drawString("Press combo Spacebar + Arrow Keys", 125, 330);
         this.rd.drawImage(this.space, 185, 355, null);
         this.rd.drawImage(this.plus, 405, 358, null);
         this.rd.drawImage(this.arrows, 491, 323, null);
         this.rd.setFont(new Font("Arial", 1, 11));
         this.rd.setColor(new Color(0, 0, 0));
         this.rd.drawString("Forward Loop", 492, 319);
         this.rd.drawString("Backward Loop", 490, 397);
         this.rd.drawString("Left Roll", 443, 375);
         this.rd.drawString("Right Roll", 576, 375);
         this.rd.drawString("Spacebar", 266, 374);
         this.rd.setColor(new Color(140, 243, 244));
         this.rd.fillRect(602, 257, 76, 9);
      }

      if (this.flipo == 11 || this.flipo == 13) {
         if (this.flipo == 11) {
            this.rd.drawString("When wasting cars, to help you find the other cars in the stage,", 262, 67);
            this.rd.drawString("press [ A ] to toggle the guidance arrow from pointing to the track", 262, 87);
            this.rd.drawString("to pointing to the cars.", 262, 107);
            this.rd.drawString("When your car is damaged. You fix it (and reset its 'Damage') by", 262, 127);
            this.rd.drawString("jumping through the electrified hoop.", 262, 147);
         } else {
            this.rd.setColor(new Color(0, 128, 255));
            this.rd.drawString("You will find that in some stages it's easier to waste the other cars", 262, 67);
            this.rd.drawString("and in some others it's easier to race and finish in first place.", 262, 87);
            this.rd.drawString("It is up to you to decide when to waste and when to race.", 262, 107);
            this.rd.drawString("And remember, 'Power' is an important factor in the game. You", 262, 127);
            this.rd.drawString("will need it whether you are racing or wasting!", 262, 147);
         }

         this.rd.setColor(new Color(0, 0, 0));
         this.rd.drawImage(this.fixhoop, 185, 218, null);
         this.rd.drawImage(this.sarrow, 385, 228, null);
         this.rd.setFont(new Font("Arial", 1, 11));
         this.rd.drawString("The Electrified Hoop", 192, 216);
         this.rd.drawString("Jumping through it fixes your car.", 158, 338);
         this.rd.drawString("Make guidance arrow point to cars.", 385, 216);
      }

      if (this.flipo == 15) {
         this.rd.drawString("And if you don’t know who I am,", 262, 67);
         this.rd.drawString("I am Coach Insano, I am the coach and narrator of this game!", 262, 87);
         this.rd.drawString("I recommended starting with NFM 1 if it’s your first time to play.", 262, 127);
         this.rd.drawString("Good Luck & Have Fun!", 262, 147);
         this.rd.setColor(new Color(0, 0, 0));
         this.rd.drawString("Other Controls :", 155, 205);
         this.rd.setFont(new Font("Arial", 1, 11));
         this.rd.drawImage(this.kz, 169, 229, null);
         this.rd.drawString("OR", 206, 251);
         this.rd.drawImage(this.kx, 229, 229, null);
         this.rd.drawString("To look behind you while driving.", 267, 251);
         this.rd.drawImage(this.kv, 169, 279, null);
         this.rd.drawString("Change Views", 207, 301);
         this.rd.drawImage(this.kenter, 169, 329, null);
         this.rd.drawString("Navigate & Pause Game", 275, 351);
         this.rd.drawImage(this.km, 489, 229, null);
         this.rd.drawString("Mute Music", 527, 251);
         this.rd.drawImage(this.kn, 489, 279, null);
         this.rd.drawString("Mute Sound Effects", 527, 301);
         this.rd.drawImage(this.ks, 489, 329, null);
         this.rd.drawString("Toggle radar / map", 527, 351);
      }

      if (this.flipo == 1 || this.flipo == 16) {
         this.rd.setFont(new Font("Arial", 1, 13));
         this.ftm = this.rd.getFontMetrics();
         this.rd.setColor(new Color(0, 0, 0));
         if (this.flipo == 16) {
            this.rd
               .drawString("M A I N    C O N T R O L S   -   once again!", 400 - this.ftm.stringWidth("M A I N    C O N T R O L S   -   once again!") / 2, 49);
         } else {
            this.rd.drawString("M A I N    C O N T R O L S", 400 - this.ftm.stringWidth("M A I N    C O N T R O L S") / 2, 49);
         }

         this.rd.drawString("Drive your car using the Arrow Keys:", 125, 80);
         this.rd.drawString("On the GROUND Spacebar is for Handbrake", 125, 101);
         this.rd.drawImage(this.space, 171, 115, null);
         this.rd.drawImage(this.arrows, 505, 83, null);
         this.rd.setFont(new Font("Arial", 1, 11));
         this.ftm = this.rd.getFontMetrics();
         this.rd.drawString("Accelerate", 515, 79);
         this.rd.drawString("Brake/Reverse", 506, 157);
         this.rd.drawString("Turn left", 454, 135);
         this.rd.drawString("Turn right", 590, 135);
         this.rd.drawString("Handbrake", 247, 134);
         this.drawcs(
            175,
            "----------------------------------------------------------------------------------------------------------------------------------------------------",
            0,
            64,
            128,
            3
         );
         this.rd.setColor(new Color(0, 0, 0));
         this.rd.setFont(new Font("Arial", 1, 13));
         this.ftm = this.rd.getFontMetrics();
         this.rd.drawString("To perform STUNTS:", 125, 200);
         this.rd.drawString("In the AIR press combo Spacebar + Arrow Keys", 125, 220);
         this.rd.drawImage(this.space, 185, 245, null);
         this.rd.drawImage(this.plus, 405, 248, null);
         this.rd.drawImage(this.arrows, 491, 213, null);
         this.rd.setFont(new Font("Arial", 1, 11));
         this.ftm = this.rd.getFontMetrics();
         this.rd.setColor(new Color(0, 0, 0));
         this.rd.drawString("Forward Loop", 492, 209);
         this.rd.drawString("Backward Loop", 490, 287);
         this.rd.drawString("Left Roll", 443, 265);
         this.rd.drawString("Right Roll", 576, 265);
         this.rd.drawString("Spacebar", 266, 264);
         this.rd.drawImage(this.stunts, 125, 285, null);
      }

      if (this.flipo >= 1 && this.flipo <= 15) {
         this.rd.drawImage(this.next[this.pnext], 665, 395, null);
      }

      if (this.flipo >= 3 && this.flipo <= 16) {
         this.rd.drawImage(this.back[this.pback], 75, 395, null);
      }

      if (this.flipo == 16) {
         this.rd.drawImage(this.contin[this.pcontin], 565, 395, null);
      }

      if (var1.enter || var1.right) {
         if (var1.enter && this.flipo == 16) {
            this.flipo = 0;
            this.fase = this.oldfase;
            this.rd.setFont(new Font("Arial", 1, 11));
            this.ftm = this.rd.getFontMetrics();
         }

         var1.enter = false;
         var1.right = false;
         if (this.flipo >= 1 && this.flipo <= 15) {
            this.flipo++;
         }
      }

      if (var1.left) {
         if (this.flipo >= 3 && this.flipo <= 15) {
            this.flipo -= 3;
         }

         if (this.flipo == 16) {
            this.flipo--;
         }

         var1.left = false;
      }
   }

   public void maini(Control var1) {
      if (this.flipo == 0) {
         this.app.setCursor(new Cursor(0));
         this.flipo++;
      }

      this.mainbg(1);
      this.rd.setComposite(AlphaComposite.getInstance(3, 0.6F));
      this.rd.drawImage(this.logomadbg, 65, 25, null);
      this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
      this.rd.drawImage(this.logomadnes, 233, 186, null);
      float var2 = this.flkat / 800.0F;
      if (var2 > 0.2) {
         var2 = 0.2F;
      }

      if (this.flkat > 200) {
         var2 = (400 - this.flkat) / 1000.0F;
         if (var2 < 0.0F) {
            var2 = 0.0F;
         }
      }

      this.flkat++;
      if (this.flkat == 400) {
         this.flkat = 0;
      }

      this.rd.setComposite(AlphaComposite.getInstance(3, var2));
      this.rd.drawImage(this.dude[0], 351 + this.gxdu, 28 + this.gydu, null);
      this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
      if (this.movly == 0) {
         this.gxdu = (int)(5.0 - 11.0 * Math.random());
         this.gydu = (int)(5.0 - 11.0 * Math.random());
      }

      this.movly++;
      if (this.movly == 2) {
         this.movly = 0;
      }

      this.rd.drawImage(this.logocars, 66, 33, null);
      this.rd.drawImage(this.opback, 247, 237, null);
      if (this.muhi < 0) {
         this.rd.setColor(new Color(140, 70, 0));
         this.rd.fillRoundRect(335, 293, 114, 19, 7, 20);
      }

      this.muhi--;
      if (this.muhi < -5) {
         this.muhi = 50;
      }

      if (var1.up) {
         this.opselect--;
         if (this.opselect == -1) {
            this.opselect = 3;
         }

         var1.up = false;
      }

      if (var1.down) {
         this.opselect++;
         if (this.opselect == 4) {
            this.opselect = 0;
         }

         var1.down = false;
      }

      if (this.opselect == 0) {
         if (this.shaded) {
            this.rd.setColor(new Color(140, 70, 0));
            this.rd.fillRect(343, 261, 110, 22);
            this.aflk = false;
         }

         if (this.aflk) {
            this.rd.setColor(new Color(200, 200, 0));
            this.aflk = false;
         } else {
            this.rd.setColor(new Color(255, 128, 0));
            this.aflk = true;
         }

         this.rd.drawRoundRect(343, 261, 110, 22, 7, 20);
      } else {
         this.rd.setColor(new Color(0, 0, 0));
         this.rd.drawRoundRect(343, 261, 110, 22, 7, 20);
      }

      if (this.opselect == 1) {
         if (this.shaded) {
            this.rd.setColor(new Color(140, 70, 0));
            this.rd.fillRect(288, 291, 221, 22);
            this.aflk = false;
         }

         if (this.aflk) {
            this.rd.setColor(new Color(200, 191, 0));
            this.aflk = false;
         } else {
            this.rd.setColor(new Color(255, 95, 0));
            this.aflk = true;
         }

         this.rd.drawRoundRect(288, 291, 221, 22, 7, 20);
      } else {
         this.rd.setColor(new Color(0, 0, 0));
         this.rd.drawRoundRect(288, 291, 221, 22, 7, 20);
      }

      if (this.opselect == 2) {
         if (this.shaded) {
            this.rd.setColor(new Color(140, 70, 0));
            this.rd.fillRect(301, 321, 196, 22);
            this.aflk = false;
         }

         if (this.aflk) {
            this.rd.setColor(new Color(200, 128, 0));
            this.aflk = false;
         } else {
            this.rd.setColor(new Color(255, 128, 0));
            this.aflk = true;
         }

         this.rd.drawRoundRect(301, 321, 196, 22, 7, 20);
      } else {
         this.rd.setColor(new Color(0, 0, 0));
         this.rd.drawRoundRect(301, 321, 196, 22, 7, 20);
      }

      if (this.opselect == 3) {
         if (this.shaded) {
            this.rd.setColor(new Color(140, 70, 0));
            this.rd.fillRect(357, 351, 85, 22);
            this.aflk = false;
         }

         if (this.aflk) {
            this.rd.setColor(new Color(200, 0, 0));
            this.aflk = false;
         } else {
            this.rd.setColor(new Color(255, 128, 0));
            this.aflk = true;
         }

         this.rd.drawRoundRect(357, 351, 85, 22, 7, 20);
      } else {
         this.rd.setColor(new Color(0, 0, 0));
         this.rd.drawRoundRect(357, 351, 85, 22, 7, 20);
      }

      this.rd.drawImage(this.opti, 294, 265, null);
      if (var1.enter || var1.handb) {
         if (this.opselect == 1) {
            this.mtop = true;
            this.multion = 1;
            this.gmode = 0;
            if (this.firstime) {
               this.oldfase = -9;
               this.fase = 11;
               this.firstime = false;
            } else {
               this.fase = -9;
            }
         }

         if (this.opselect == 2) {
            this.oldfase = 10;
            this.fase = 11;
            this.firstime = false;
         }

         if (this.opselect == 3) {
            this.fase = 8;
         }

         if (this.opselect == 0) {
            if (this.unlocked[0] == 11) {
               if (this.unlocked[1] != 17) {
                  this.opselect = 1;
               } else {
                  this.opselect = 2;
               }
            }

            if (this.firstime) {
               this.oldfase = 102;
               this.fase = 11;
               this.firstime = false;
            } else {
               this.fase = 102;
            }
         }

         this.flipo = 0;
         var1.enter = false;
         var1.handb = false;
      }

      this.rd.drawImage(this.byrd, 72, 410, null);
      this.rd.drawImage(this.nfmcoms, 567, 410, null);
      if (this.shaded) {
         this.app.repaint();

         try {
            Thread.sleep(200L);
         } catch (InterruptedException var4) {
         }
      }
   }

   public void maini2(Control var1, int var2, int var3, int var4) {
      this.mainbg(1);
      this.rd.setComposite(AlphaComposite.getInstance(3, 0.6F));
      this.rd.drawImage(this.logomadbg, 65, 25, null);
      this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
      this.rd.drawImage(this.logomadnes, 233, 186, null);
      float var5 = this.flkat / 800.0F;
      if (var5 > 0.2) {
         var5 = 0.2F;
      }

      if (this.flkat > 200) {
         var5 = (400 - this.flkat) / 1000.0F;
         if (var5 < 0.0F) {
            var5 = 0.0F;
         }
      }

      this.flkat++;
      if (this.flkat == 400) {
         this.flkat = 0;
      }

      this.rd.setComposite(AlphaComposite.getInstance(3, var5));
      this.rd.drawImage(this.dude[0], 351 + this.gxdu, 28 + this.gydu, null);
      this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
      if (this.movly == 0) {
         this.gxdu = (int)(5.0 - 11.0 * Math.random());
         this.gydu = (int)(5.0 - 11.0 * Math.random());
      }

      this.movly++;
      if (this.movly == 2) {
         this.movly = 0;
      }

      this.rd.drawImage(this.logocars, 66, 33, null);
      this.rd.drawImage(this.opback, 247, 237, null);
      if (var1.up) {
         this.opselect--;
         if (this.opselect == -1) {
            this.opselect = 3 - this.dropf / 15;
         }

         var1.up = false;
      }

      if (var1.down) {
         this.opselect++;
         if (this.opselect == 4 - this.dropf / 15) {
            this.opselect = 0;
         }

         var1.down = false;
      }

      if (this.opselect == 0) {
         if (this.shaded) {
            this.rd.setColor(new Color(140, 70, 0));
            this.rd.fillRect(358, 262 + this.dropf, 82, 22);
            this.aflk = false;
         }

         if (this.aflk) {
            this.rd.setColor(new Color(200, 64, 0));
            this.aflk = false;
         } else {
            this.rd.setColor(new Color(255, 128, 0));
            this.aflk = true;
         }

         this.rd.drawRoundRect(358, 262 + this.dropf, 82, 22, 7, 20);
      } else {
         this.rd.setColor(new Color(0, 0, 0));
         this.rd.drawRoundRect(358, 262 + this.dropf, 82, 22, 7, 20);
      }

      if (this.opselect == 1) {
         if (this.shaded) {
            this.rd.setColor(new Color(140, 70, 0));
            this.rd.fillRect(358, 290 + this.dropf, 82, 22);
            this.aflk = false;
         }

         if (this.aflk) {
            this.rd.setColor(new Color(200, 64, 0));
            this.aflk = false;
         } else {
            this.rd.setColor(new Color(255, 95, 0));
            this.aflk = true;
         }

         this.rd.drawRoundRect(358, 290 + this.dropf, 82, 22, 7, 20);
      } else {
         this.rd.setColor(new Color(0, 0, 0));
         this.rd.drawRoundRect(358, 290 + this.dropf, 82, 22, 7, 20);
      }

      if (this.opselect == 2) {
         if (this.shaded) {
            this.rd.setColor(new Color(140, 70, 0));
            this.rd.fillRect(333, 318 + this.dropf, 132, 22);
            this.aflk = false;
         }

         if (this.aflk) {
            this.rd.setColor(new Color(200, 255, 0));
            this.aflk = false;
         } else {
            this.rd.setColor(new Color(255, 128, 0));
            this.aflk = true;
         }

         this.rd.drawRoundRect(333, 318 + this.dropf, 132, 22, 7, 20);
      } else {
         this.rd.setColor(new Color(0, 0, 0));
         this.rd.drawRoundRect(333, 318 + this.dropf, 132, 22, 7, 20);
      }

      if (this.dropf == 0) {
         if (this.opselect == 3) {
            if (this.shaded) {
               this.rd.setColor(new Color(140, 70, 0));
               this.rd.fillRect(348, 346, 102, 22);
               this.aflk = false;
            }

            if (this.aflk) {
               this.rd.setColor(new Color(200, 64, 0));
               this.aflk = false;
            } else {
               this.rd.setColor(new Color(255, 128, 0));
               this.aflk = true;
            }

            this.rd.drawRoundRect(348, 346, 102, 22, 7, 20);
         } else {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawRoundRect(348, 346, 102, 22, 7, 20);
         }
      }

      this.rd.drawImage(this.opti2, 346, 265 + this.dropf, null);
      if (this.dropf != 0) {
         this.rd.setColor(new Color(58, 30, 8));
         this.rd.fillRect(357, 365, 87, 15);
      }

      if (var1.enter || var1.handb) {
         this.mtop = false;
         if (this.opselect == 0) {
            this.multion = 0;
            this.clangame = 0;
            this.gmode = 1;
            this.fase = -9;
         }

         if (this.opselect == 1) {
            this.multion = 0;
            this.clangame = 0;
            this.gmode = 2;
            this.fase = -9;
            this.opselect = 0;
         }

         if (this.dropf == 0 && this.opselect == 3) {
            this.multion = 0;
            this.clangame = 0;
            this.gmode = 0;
            this.fase = -9;
            this.opselect = 0;
         }

         if (this.opselect == 2) {
            this.multion = 1;
            this.gmode = 0;
            if (this.firstime) {
               this.oldfase = -9;
               this.fase = 11;
               this.firstime = false;
            } else {
               this.fase = -9;
            }
         }

         this.flipo = 0;
         var1.enter = false;
         var1.handb = false;
      }

      this.rd.drawImage(this.byrd, 72, 410, null);
      this.rd.drawImage(this.nfmcoms, 567, 410, null);
      boolean var6 = false;
      if (var4 == 2) {
         var6 = true;
      }

      if (this.drawcarb(true, null, "   < Back   ", 161, 313, var2, var3, var6)) {
         this.opselect = 0;
         this.fase = 10;
      }

      if (this.shaded) {
         this.app.repaint();

         try {
            Thread.sleep(200L);
         } catch (InterruptedException var8) {
         }
      }
   }

   public void pausedgame(int var1, Control var2, Record var3) {
      if (!this.badmac) {
         this.rd.drawImage(this.fleximg, 0, 0, null);
      } else {
         this.rd.setColor(new Color(30, 67, 110));
         this.rd.fillRect(281, 8, 237, 188);
      }

      if (var2.up) {
         this.opselect--;
         if (this.opselect == -1) {
            this.opselect = 3;
         }

         var2.up = false;
      }

      if (var2.down) {
         this.opselect++;
         if (this.opselect == 4) {
            this.opselect = 0;
         }

         var2.down = false;
      }

      if (this.opselect == 0) {
         this.rd.setColor(new Color(64, 143, 223));
         this.rd.fillRoundRect(329, 45, 137, 22, 7, 20);
         if (this.shaded) {
            this.rd.setColor(new Color(225, 200, 255));
         } else {
            this.rd.setColor(new Color(0, 89, 223));
         }

         this.rd.drawRoundRect(329, 45, 137, 22, 7, 20);
      }

      if (this.opselect == 1) {
         this.rd.setColor(new Color(64, 143, 223));
         this.rd.fillRoundRect(320, 73, 155, 22, 7, 20);
         if (this.shaded) {
            this.rd.setColor(new Color(225, 200, 255));
         } else {
            this.rd.setColor(new Color(0, 89, 223));
         }

         this.rd.drawRoundRect(320, 73, 155, 22, 7, 20);
      }

      if (this.opselect == 2) {
         this.rd.setColor(new Color(64, 143, 223));
         this.rd.fillRoundRect(303, 99, 190, 22, 7, 20);
         if (this.shaded) {
            this.rd.setColor(new Color(225, 200, 255));
         } else {
            this.rd.setColor(new Color(0, 89, 223));
         }

         this.rd.drawRoundRect(303, 99, 190, 22, 7, 20);
      }

      if (this.opselect == 3) {
         this.rd.setColor(new Color(64, 143, 223));
         this.rd.fillRoundRect(341, 125, 109, 22, 7, 20);
         if (this.shaded) {
            this.rd.setColor(new Color(225, 200, 255));
         } else {
            this.rd.setColor(new Color(0, 89, 223));
         }

         this.rd.drawRoundRect(341, 125, 109, 22, 7, 20);
      }

      this.rd.drawImage(this.paused, 281, 8, null);
      if (var2.enter || var2.handb) {
         if (this.opselect == 0) {
            if (this.loadedt && !this.mutem) {
               this.strack.resume();
            }

            this.fase = 0;
         }

         if (this.opselect == 1) {
            if (var3.caught >= 300) {
               if (this.loadedt && !this.mutem) {
                  this.strack.resume();
               }

               this.fase = -1;
            } else {
               this.fase = -8;
            }
         }

         if (this.opselect == 2) {
            if (this.loadedt) {
               this.strack.stop();
            }

            this.oldfase = -7;
            this.fase = 11;
         }

         if (this.opselect == 3) {
            if (this.loadedt) {
               this.strack.unload();
            }

            this.fase = 102;
            if (this.gmode == 0) {
               this.opselect = 3;
            }

            if (this.gmode == 1) {
               this.opselect = 0;
            }

            if (this.gmode == 2) {
               this.opselect = 1;
            }

            this.rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
         }

         var2.enter = false;
         var2.handb = false;
      }
   }

   public void replyn() {
      if (this.aflk) {
         this.drawcs(30, "Replay  > ", 0, 0, 0, 0);
         this.aflk = false;
      } else {
         this.drawcs(30, "Replay  >>", 0, 128, 255, 0);
         this.aflk = true;
      }
   }

   public void cantreply() {
      this.rd.setColor(new Color(64, 143, 223));
      this.rd.fillRoundRect(200, 73, 400, 23, 7, 20);
      this.rd.setColor(new Color(0, 89, 223));
      this.rd.drawRoundRect(200, 73, 400, 23, 7, 20);
      this.drawcs(89, "Sorry not enough replay data to play available, please try again later.", 255, 255, 255, 1);
   }

   public void nofocus() {
      this.rd.setColor(new Color(255, 255, 255));
      this.rd.fillRect(0, 0, 800, 20);
      this.rd.fillRect(0, 0, 20, 450);
      this.rd.fillRect(0, 430, 800, 20);
      this.rd.fillRect(780, 0, 20, 450);
      this.rd.setColor(new Color(192, 192, 192));
      this.rd.drawRect(20, 20, 760, 410);
      this.rd.setColor(new Color(0, 0, 0));
      this.rd.drawRect(22, 22, 756, 406);
      this.rd.setFont(new Font("Arial", 1, 11));
      this.ftm = this.rd.getFontMetrics();
      this.drawcs(14, "Game lost its focus.   Click screen with mouse to continue.", 100, 100, 100, 3);
      this.drawcs(445, "Game lost its focus.   Click screen with mouse to continue.", 100, 100, 100, 3);
   }

   public void inishcarselect(ContO[] var1) {
      this.nplayers = 7;
      this.im = 0;
      this.xstart[0] = 0;
      this.xstart[1] = -350;
      this.xstart[2] = 350;
      this.xstart[3] = 0;
      this.xstart[4] = -350;
      this.xstart[5] = 350;
      this.xstart[6] = 0;
      this.zstart[0] = -760;
      this.zstart[1] = -380;
      this.zstart[2] = -380;
      this.zstart[3] = 0;
      this.zstart[4] = 380;
      this.zstart[5] = 380;
      this.zstart[6] = 760;
      this.onmsc = -1;
      this.remi = false;
      this.basefase = 0;
      this.noclass = false;
      if (this.testdrive != 1 && this.testdrive != 2) {
         if (this.gmode != 0) {
            this.cfase = 0;
            this.sc[0] = this.scm[this.gmode - 1];
         }

         if (this.gmode == 0) {
            this.sc[0] = this.osc;
         }

         if (this.cd.lastload != 1 || this.cfase != 3) {
            this.onmsc = this.sc[0];
         }

         if (this.cfase == 0 && this.sc[0] > 15) {
            this.sc[0] = 15;
            if (this.multion != 0) {
               this.cfase = -1;
            }
         }

         if (this.onjoin != -1 && this.multion != 0) {
            if (this.ontyp <= -2) {
               this.cfase = 0;
            }

            if (this.ontyp >= 20) {
               this.ontyp -= 20;
               this.cfase = 0;
            }

            if (this.ontyp >= 10) {
               this.ontyp -= 10;
               if (this.cd.lastload != 2) {
                  this.cfase = -1;
                  this.onjoin = -1;
               } else {
                  this.cfase = 3;
               }
            }
         }

         if (this.cfase == 11 || this.cfase == 101) {
            if (this.sc[0] >= 16 && this.cd.lastload == 2 && this.sc[0] < 36) {
               this.cfase = 3;
            } else {
               this.cfase = 0;
            }
         }

         if (this.cfase == 3) {
            if (this.multion != 0 && this.cd.lastload == 1) {
               this.sc[0] = 15;
               this.minsl = 0;
               this.maxsl = 15;
               this.cfase = 0;
            }

            if (this.cd.lastload == 0) {
               this.sc[0] = 15;
               this.minsl = 0;
               this.maxsl = 15;
               this.cfase = 0;
            }

            if (this.cd.lastload == 2) {
               this.minsl = 16;
               this.maxsl = this.cd.nlocars - 1;
               if (this.sc[0] < this.minsl) {
                  this.sc[0] = this.minsl;
               }

               if (this.sc[0] > this.maxsl) {
                  this.sc[0] = this.maxsl;
               }

               if (this.onjoin != -1 && this.multion != 0 && this.ontyp > 0 && this.ontyp <= 5) {
                  boolean var2 = false;

                  for (int var3 = 16; var3 < this.cd.nlocars; var3++) {
                     if (Math.abs(this.cd.cclass[var3] - (this.ontyp - 1)) <= 1) {
                        if (!var2) {
                           this.minsl = var3;
                           var2 = true;
                        }

                        if (var2) {
                           this.maxsl = var3;
                        }
                     }
                  }

                  if (!var2) {
                     this.onjoin = -1;
                     this.noclass = true;
                  } else {
                     if (this.sc[0] < this.minsl) {
                        this.sc[0] = this.minsl;
                     }

                     if (this.sc[0] > this.maxsl) {
                        this.sc[0] = this.maxsl;
                     }

                     if (Math.abs(this.cd.cclass[this.sc[0]] - (this.ontyp - 1)) > 1) {
                        this.sc[0] = this.minsl;
                     }
                  }
               }
            }

            if (this.cd.lastload == -2 && this.logged) {
               this.cfase = 5;
               this.showtf = false;
               this.cd.action = 3;
               this.cd.sparkactionloader();
            }
         }

         if (this.cfase == 0) {
            this.minsl = 0;
            this.maxsl = 15;
            if (this.onjoin != -1 && this.multion != 0) {
               if (this.ontyp == 1) {
                  this.minsl = 0;
                  this.maxsl = 5;
               }

               if (this.ontyp == 2) {
                  this.minsl = 0;
                  this.maxsl = 9;
               }

               if (this.ontyp == 3) {
                  this.minsl = 5;
                  this.maxsl = 10;
               }

               if (this.ontyp == 4) {
                  this.minsl = 6;
                  this.maxsl = 15;
               }

               if (this.ontyp == 5) {
                  this.minsl = 10;
                  this.maxsl = 15;
               }

               if (this.ontyp <= -2) {
                  this.minsl = Math.abs(this.ontyp + 2);
                  this.maxsl = Math.abs(this.ontyp + 2);
               }
            }

            if (this.sc[0] < this.minsl) {
               this.sc[0] = this.minsl;
            }

            if (this.sc[0] > this.maxsl) {
               this.sc[0] = this.maxsl;
            }
         }
      } else {
         this.minsl = this.sc[0];
         this.maxsl = this.sc[0];
      }

      this.app.mcars.setBackground(new Color(0, 0, 0));
      this.app.mcars.setForeground(new Color(47, 179, 255));
      this.app.mcars.alphad = true;
      this.app.mcars.carsel = true;
      this.carsbginflex();
      this.flatrstart = 0;
      this.m.lightson = false;
      this.pnext = 0;
      this.pback = 0;
      this.lsc = -1;
      this.mouson = -1;
      if (this.multion == 0) {
         this.app.mycar.setLabel(" Include in this game.");
         this.app.mycar.setBackground(new Color(198, 179, 129));
         this.app.mycar.setForeground(new Color(0, 0, 0));
         int var6 = 16;
         if (this.cd.lastload == 2) {
            var6 = this.cd.nlocars;
         }

         for (int var7 = 0; var7 < var6; var7++) {
            float[] var4 = new float[3];
            Color.RGBtoHSB(var1[var7].fcol[0], var1[var7].fcol[1], var1[var7].fcol[2], var4);

            for (int var5 = 0; var5 < var1[var7].npl; var5++) {
               if (var1[var7].p[var5].colnum == 1) {
                  var1[var7].p[var5].hsb[0] = var4[0];
                  var1[var7].p[var5].hsb[1] = var4[1];
                  var1[var7].p[var5].hsb[2] = var4[2];
                  var1[var7].p[var5].oc[0] = var1[var7].fcol[0];
                  var1[var7].p[var5].oc[1] = var1[var7].fcol[1];
                  var1[var7].p[var5].oc[2] = var1[var7].fcol[2];
               }
            }

            Color.RGBtoHSB(var1[var7].scol[0], var1[var7].scol[1], var1[var7].scol[2], var4);

            for (int var9 = 0; var9 < var1[var7].npl; var9++) {
               if (var1[var7].p[var9].colnum == 2) {
                  var1[var7].p[var9].hsb[0] = var4[0];
                  var1[var7].p[var9].hsb[1] = var4[1];
                  var1[var7].p[var9].hsb[2] = var4[2];
                  var1[var7].p[var9].oc[0] = var1[var7].scol[0];
                  var1[var7].p[var9].oc[1] = var1[var7].scol[1];
                  var1[var7].p[var9].oc[2] = var1[var7].scol[2];
               }
            }

            var1[var7].xy = 0;
         }

         for (int var8 = 0; var8 < 6; var8++) {
            this.arnp[var8] = -1.0F;
         }
      }

      this.m.trk = 0;
      this.m.crs = true;
      this.m.x = -400;
      this.m.y = -525;
      this.m.z = -50;
      this.m.xz = 0;
      this.m.zy = 10;
      this.m.ground = 495;
      this.m.ih = 0;
      this.m.iw = 0;
      this.m.h = 450;
      this.m.w = 800;
      this.m.focus_point = 400;
      this.m.cx = 400;
      this.m.cy = 225;
      this.m.cz = 50;
      if (this.multion == 0) {
         this.intertrack.loadimod(false);
         this.intertrack.play();
      }
   }

   public void carselect(Control var1, ContO[] var2, Mad var3, int var4, int var5, boolean var6) {
      this.rd.setColor(new Color(0, 0, 0));
      this.rd.fillRect(0, 0, 65, 450);
      this.rd.fillRect(735, 0, 65, 450);
      this.rd.fillRect(65, 0, 670, 25);
      this.rd.fillRect(65, 425, 670, 25);
      if (this.flatrstart == 6) {
         if (this.multion == 0 && this.testdrive != 1 && this.testdrive != 2) {
            this.rd.drawImage(this.carsbg, 65, 25, null);
         } else {
            this.rd.drawImage(this.carsbgc, 65, 25, null);
         }
      } else if (this.flatrstart <= 1) {
         this.drawSmokeCarsbg();
      } else {
         this.rd.setColor(new Color(255, 255, 255));
         this.rd.fillRect(65, 25, 670, 400);
         this.carsbginflex();
         this.flatrstart = 6;
      }

      this.rd.drawImage(this.selectcar, 321, 37, null);
      if (this.cfase == 3 || this.cfase == 7 || this.remi) {
         if (this.cd.lastload == 1) {
            this.rd.drawImage(this.ycmc, 337, 58, null);
         }

         if (this.cd.lastload == 2) {
            this.rd.drawImage(this.yac, 323, 58, null);
         }
      }

      if (this.cfase == 11) {
         this.rd.setFont(new Font("Arial", 1, 13));
         this.ftm = this.rd.getFontMetrics();
         String var7 = "Top 20 Cars";
         int var8 = this.cd.loadlist;
         String var9 = "Weekly";

         while (var8 > 6) {
            var8 -= 6;
            if (var9.equals("Semi-Annual")) {
               var9 = "Annual";
            }

            if (var9.equals("Monthly")) {
               var9 = "Semi-Annual";
            }

            if (var9.equals("Weekly")) {
               var9 = "Monthly";
            }
         }

         if (var8 == 1) {
            var7 = "" + var9 + " Top 20 Cars";
         }

         if (var8 == 2) {
            var7 = "" + var9 + " Top 20 Class A Cars";
         }

         if (var8 == 3) {
            var7 = "" + var9 + " Top 20 Class A & B Cars";
         }

         if (var8 == 4) {
            var7 = "" + var9 + " Top 20 Class B Cars";
         }

         if (var8 == 5) {
            var7 = "" + var9 + " Top 20 Class B & C Cars";
         }

         if (var8 == 6) {
            var7 = "" + var9 + " Top 20 Class C Cars";
         }

         this.drawcs(69, var7, 120, 176, 255, 3);
      }

      if (this.cfase == 101) {
         this.rd.setFont(new Font("Arial", 1, 13));
         this.ftm = this.rd.getFontMetrics();
         this.drawcs(69, "" + this.cd.viewname + "'s account cars!", 220, 112, 33, 3);
      }

      if (!this.remi) {
         this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
         var2[this.sc[0]].d(this.rd);
         this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      }

      if (this.cfase == 8) {
         this.drawprom(150, 85);
         this.rd.setFont(new Font("Arial", 1, 13));
         this.ftm = this.rd.getFontMetrics();
         this.drawcs(195, "Removing Car...", 0, 0, 0, 3);
         if (this.cd.action != 10) {
            if (this.cd.action != -10) {
               this.cfase = 5;
               this.showtf = false;
            } else {
               this.cfase = 9;
            }
         }
      }

      if ((this.multion != 0 || this.testdrive == 1 || this.testdrive == 2) && this.lsc != this.sc[0]) {
         if (var2[this.sc[0]].xy != 0) {
            var2[this.sc[0]].xy = 0;
         }

         boolean var17 = false;

         for (int var20 = 0; var20 < var2[this.sc[0]].npl && !var17; var20++) {
            if (var2[this.sc[0]].p[var20].colnum == 1) {
               float[] var23 = new float[3];
               Color.RGBtoHSB(var2[this.sc[0]].p[var20].c[0], var2[this.sc[0]].p[var20].c[1], var2[this.sc[0]].p[var20].c[2], var23);
               this.arnp[0] = var23[0];
               this.arnp[1] = var23[1];
               this.arnp[2] = 1.0F - var23[2];
               var17 = true;
            }
         }

         var17 = false;

         for (int var21 = 0; var21 < var2[this.sc[0]].npl && !var17; var21++) {
            if (var2[this.sc[0]].p[var21].colnum == 2) {
               float[] var24 = new float[3];
               Color.RGBtoHSB(var2[this.sc[0]].p[var21].c[0], var2[this.sc[0]].p[var21].c[1], var2[this.sc[0]].p[var21].c[2], var24);
               this.arnp[3] = var24[0];
               this.arnp[4] = var24[1];
               this.arnp[5] = 1.0F - var24[2];
               var17 = true;
            }
         }

         Color var25 = Color.getHSBColor(this.arnp[0], this.arnp[1], 1.0F - this.arnp[2]);
         Color var10 = Color.getHSBColor(this.arnp[3], this.arnp[4], 1.0F - this.arnp[5]);

         for (int var11 = 0; var11 < var2[this.sc[0]].npl; var11++) {
            if (var2[this.sc[0]].p[var11].colnum == 1) {
               var2[this.sc[0]].p[var11].hsb[0] = this.arnp[0];
               var2[this.sc[0]].p[var11].hsb[1] = this.arnp[1];
               var2[this.sc[0]].p[var11].hsb[2] = 1.0F - this.arnp[2];
               var2[this.sc[0]].p[var11].c[0] = var25.getRed();
               var2[this.sc[0]].p[var11].c[1] = var25.getGreen();
               var2[this.sc[0]].p[var11].c[2] = var25.getBlue();
               var2[this.sc[0]].p[var11].oc[0] = var25.getRed();
               var2[this.sc[0]].p[var11].oc[1] = var25.getGreen();
               var2[this.sc[0]].p[var11].oc[2] = var25.getBlue();
            }

            if (var2[this.sc[0]].p[var11].colnum == 2) {
               var2[this.sc[0]].p[var11].hsb[0] = this.arnp[3];
               var2[this.sc[0]].p[var11].hsb[1] = this.arnp[4];
               var2[this.sc[0]].p[var11].hsb[2] = 1.0F - this.arnp[5];
               var2[this.sc[0]].p[var11].c[0] = var10.getRed();
               var2[this.sc[0]].p[var11].c[1] = var10.getGreen();
               var2[this.sc[0]].p[var11].c[2] = var10.getBlue();
               var2[this.sc[0]].p[var11].oc[0] = var10.getRed();
               var2[this.sc[0]].p[var11].oc[1] = var10.getGreen();
               var2[this.sc[0]].p[var11].oc[2] = var10.getBlue();
            }
         }

         this.lsc = this.sc[0];
      }

      int var19 = -1;
      int var22 = 0;
      boolean var26 = false;
      if (this.flipo == 0) {
         this.rd.setFont(new Font("Arial", 1, 13));
         this.ftm = this.rd.getFontMetrics();
         byte var27 = 0;
         if (this.flatrstart < 6) {
            var27 = 2;
         }

         if (!this.remi && (this.cfase != 10 || this.cd.action != 0 && this.cd.action < 14)) {
            if (this.cfase == 3 && this.cd.lastload == 2) {
               this.app.mcars.move(400 - this.app.mcars.w / 2, 78);
               this.app.mcars.show = true;
               if (!this.app.mcars.getSelectedItem().equals(this.cd.names[this.sc[0]])) {
                  for (int var29 = 16; var29 < this.cd.nlocars; var29++) {
                     if (this.cd.names[var29].equals(this.app.mcars.getSelectedItem())) {
                        var19 = var29;
                     }
                  }

                  if (var19 == -1) {
                     this.cfase = 5;
                     this.cd.action = 4;
                     this.cd.sparkactionloader();
                  }
               }
            } else {
               this.app.mcars.show = false;
               String var28 = "";
               if (this.cfase == 11) {
                  var28 = "N#" + (this.sc[0] - 35) + "  ";
               }

               if (this.aflk) {
                  this.drawcs(95 + var27, var28 + this.cd.names[this.sc[0]], 240, 240, 240, 3);
                  this.aflk = false;
               } else {
                  this.drawcs(95, var28 + this.cd.names[this.sc[0]], 176, 176, 176, 3);
                  this.aflk = true;
               }
            }
         } else {
            this.app.mcars.show = false;
         }

         var2[this.sc[0]].z = 950;
         if (this.sc[0] == 13) {
            var2[this.sc[0]].z = 1000;
         }

         var2[this.sc[0]].y = -34 - var2[this.sc[0]].grat;
         var2[this.sc[0]].x = 0;
         if (this.mouson >= 0 && this.mouson <= 3) {
            var2[this.sc[0]].xz += 2;
         } else {
            var2[this.sc[0]].xz += 5;
         }

         if (var2[this.sc[0]].xz > 360) {
            var2[this.sc[0]].xz -= 360;
         }

         var2[this.sc[0]].zy = 0;
         var2[this.sc[0]].wzy -= 10;
         if (var2[this.sc[0]].wzy < -30) {
            var2[this.sc[0]].wzy += 30;
         }

         if (!this.remi) {
            if (this.sc[0] != this.minsl) {
               this.rd.drawImage(this.back[this.pback], 95, 275, null);
            }

            if (this.sc[0] != this.maxsl) {
               this.rd.drawImage(this.next[this.pnext], 645, 275, null);
            }
         }

         if (this.gmode == 1) {
            if (this.sc[0] == 5 && this.unlocked[0] <= 2) {
               var22 = 2;
            }

            if (this.sc[0] == 6 && this.unlocked[0] <= 4) {
               var22 = 4;
            }

            if (this.sc[0] == 11 && this.unlocked[0] <= 6) {
               var22 = 6;
            }

            if (this.sc[0] == 14 && this.unlocked[0] <= 8) {
               var22 = 8;
            }

            if (this.sc[0] == 15 && this.unlocked[0] <= 10) {
               var22 = 10;
            }
         }

         if (this.gmode == 2 && this.sc[0] >= 8 && this.unlocked[1] <= (this.sc[0] - 7) * 2) {
            var22 = (this.sc[0] - 7) * 2;
         }

         if (var22 != 0) {
            if (this.gatey == 300) {
               for (int var30 = 0; var30 < 9; var30++) {
                  this.pgas[var30] = false;
                  this.pgady[var30] = 0;
               }

               this.pgas[0] = true;
            }

            for (int var31 = 0; var31 < 9; var31++) {
               this.rd.drawImage(this.pgate, this.pgatx[var31], this.pgaty[var31] + this.pgady[var31] - this.gatey, null);
               if (this.flatrstart == 6) {
                  if (this.pgas[var31]) {
                     this.pgady[var31] = this.pgady[var31] - (80 + 100 / (var31 + 1) - Math.abs(this.pgady[var31])) / 3;
                     if (this.pgady[var31] < -(70 + 100 / (var31 + 1))) {
                        this.pgas[var31] = false;
                        if (var31 != 8) {
                           this.pgas[var31 + 1] = true;
                        }
                     }
                  } else {
                     this.pgady[var31] = this.pgady[var31] + (80 + 100 / (var31 + 1) - Math.abs(this.pgady[var31])) / 3;
                     if (this.pgady[var31] > 0) {
                        this.pgady[var31] = 0;
                     }
                  }
               }
            }

            if (this.gatey != 0) {
               this.gatey -= 100;
            }

            if (this.flatrstart == 6) {
               this.drawcs(355, "[ Car Locked ]", 210, 210, 210, 3);
               this.drawcs(375, "This car unlocks when stage " + var22 + " is completed...", 255, 96, 0, 3);
            }
         } else {
            if (this.flatrstart == 6) {
               if (this.cfase == 10) {
                  if (this.cd.action == 13) {
                     this.minsl = 36;
                     this.maxsl = this.cd.xnlocars - 1;
                     var19 = 36;
                     this.cd.action = 0;
                     this.cfase = 11;
                  }

                  if (this.cd.action == 12) {
                     int var32 = this.cd.loadlist;
                     String var12 = "Top 20 Cars";
                     String var13 = "Weekly";

                     while (var32 > 6) {
                        var32 -= 6;
                        if (var13.equals("Semi-Annual")) {
                           var13 = "Annual";
                        }

                        if (var13.equals("Monthly")) {
                           var13 = "Semi-Annual";
                        }

                        if (var13.equals("Weekly")) {
                           var13 = "Monthly";
                        }
                     }

                     if (var32 == 1) {
                        var12 = "" + var13 + " Top 20 Cars";
                     }

                     if (var32 == 2) {
                        var12 = "" + var13 + " Top 20 Class A Cars";
                     }

                     if (var32 == 3) {
                        var12 = "" + var13 + " Top 20 Class A & B Cars";
                     }

                     if (var32 == 4) {
                        var12 = "" + var13 + " Top 20 Class B Cars";
                     }

                     if (var32 == 5) {
                        var12 = "" + var13 + " Top 20 Class B & C Cars";
                     }

                     if (var32 == 6) {
                        var12 = "" + var13 + " Top 20 Class C Cars";
                     }

                     this.drawprom(145, 170);
                     this.drawcs(195, "[  Loading " + var12 + "  ]", 0, 0, 0, 3);
                     if (this.cd.nl > 0 && this.cd.nl <= 20) {
                        this.drawcs(235, "Loading :  " + this.cd.loadnames[this.cd.nl - 1] + "", 0, 0, 0, 3);
                     }
                  }

                  if (this.cd.action == 11) {
                     this.drawprom(145, 170);
                     this.drawcs(195, "Loading List, Please Wait...", 0, 0, 0, 3);
                  }

                  if (this.cd.action == -1) {
                     this.drawprom(145, 170);
                     this.drawcs(195, "Failed to Load List.", 0, 0, 0, 3);
                     this.drawcs(225, "Unknown Error.  Please try again later.", 0, 0, 0, 3);
                     if (this.drawcarb(true, null, "   OK   ", 371, 255, var4, var5, var6)) {
                        this.cd.action = 0;
                        this.cfase = this.basefase;
                     }
                  }

                  if (this.cd.action == 0 || this.cd.action == 14 || this.cd.action == 15 || this.cd.action == 16 || this.cd.action == 17) {
                     this.drawprom(65, 250);
                     if (this.drawcarb(true, null, " X ", 557, 70, var4, var5, var6)) {
                        this.cd.action = 0;
                        this.cfase = this.basefase;
                     }

                     this.drawcs(305, "The lists get updated every 24 hours!", 0, 0, 0, 3);
                     if (this.cd.action == 14 || this.cd.action == 15 || this.cd.action == 16 || this.cd.action == 17) {
                        if (!var6 && this.cntflock == 20) {
                           this.cntflock = 0;
                        }

                        if (this.cd.action == 14) {
                           this.drawcs(91, "Weekly Top 20 Cars", 0, 0, 0, 3);
                        }

                        if (this.cd.action == 15) {
                           this.drawcs(91, "Monthly Top 20 Cars", 0, 0, 0, 3);
                        }

                        if (this.cd.action == 16) {
                           this.drawcs(91, "Semi-Annual Top 20 Cars", 0, 0, 0, 3);
                        }

                        if (this.cd.action == 17) {
                           this.drawcs(91, "Annual Top 20 Cars", 0, 0, 0, 3);
                        }

                        if (this.drawcarb(true, null, "   All Cars, All Classes   ", 318, 105, var4, var5, var6) && this.cntflock == 0) {
                           this.cd.loadlist = 1 + (this.cd.action - 14) * 6;
                           this.cd.action = 11;
                           this.cd.sparkactionloader();
                        }

                        if (this.drawcarb(true, null, "Class A Cars", 337, 135, var4, var5, var6) && this.cntflock == 0) {
                           this.cd.loadlist = 2 + (this.cd.action - 14) * 6;
                           this.cd.action = 11;
                           this.cd.sparkactionloader();
                        }

                        if (this.drawcarb(true, null, "Class A & B Cars", 337, 165, var4, var5, var6) && this.cntflock == 0) {
                           this.cd.loadlist = 3 + (this.cd.action - 14) * 6;
                           this.cd.action = 11;
                           this.cd.sparkactionloader();
                        }

                        if (this.drawcarb(true, null, "Class B Cars", 337, 195, var4, var5, var6) && this.cntflock == 0) {
                           this.cd.loadlist = 4 + (this.cd.action - 14) * 6;
                           this.cd.action = 11;
                           this.cd.sparkactionloader();
                        }

                        if (this.drawcarb(true, null, "Class B & C Cars", 337, 225, var4, var5, var6) && this.cntflock == 0) {
                           this.cd.loadlist = 5 + (this.cd.action - 14) * 6;
                           this.cd.action = 11;
                           this.cd.sparkactionloader();
                        }

                        if (this.drawcarb(true, null, "Class C Cars", 337, 255, var4, var5, var6) && this.cntflock == 0) {
                           this.cd.loadlist = 6 + (this.cd.action - 14) * 6;
                           this.cd.action = 11;
                           this.cd.sparkactionloader();
                        }
                     }

                     if (this.cd.action == 0) {
                        this.drawcs(91, "Top 20 Most Added Public Custom Cars", 0, 0, 0, 3);
                        if (this.drawcarb(true, null, "  Weekly Top 20  ", 338, 125, var4, var5, var6)) {
                           this.cd.action = 14;
                        }

                        if (this.drawcarb(true, null, "  Monthly Top 20  ", 337, 165, var4, var5, var6)) {
                           this.cd.action = 15;
                        }

                        if (this.drawcarb(true, null, "  Semi-Annual Top 20  ", 321, 205, var4, var5, var6)) {
                           this.cd.action = 16;
                        }

                        if (this.drawcarb(true, null, "  Annual Top 20  ", 339, 245, var4, var5, var6)) {
                           this.cd.action = 17;
                        }

                        if (this.cntflock != 20) {
                           this.cntflock = 20;
                        }
                     }
                  }
               }

               if (this.cfase == 100) {
                  if (this.cd.action == -1) {
                     this.drawprom(145, 170);
                     this.drawcs(195, "Failed to Load List.", 0, 0, 0, 3);
                     this.drawcs(225, "Unknown Error.  Please try again later.", 0, 0, 0, 3);
                     if (this.drawcarb(true, null, "   OK   ", 371, 255, var4, var5, var6)) {
                        if (this.sc[0] >= 16 && this.cd.lastload == 2 && this.sc[0] < 36) {
                           this.cfase = 3;
                        } else {
                           this.cfase = 0;
                        }
                     }
                  }

                  if (this.cd.action == -2) {
                     this.drawprom(145, 170);
                     this.drawcs(195, "No account cars found.", 0, 0, 0, 3);
                     this.drawcs(225, "" + this.cd.viewname + " does not have any published or added cars.", 0, 0, 0, 3);
                     if (this.drawcarb(true, null, "   OK   ", 371, 255, var4, var5, var6)) {
                        if (this.sc[0] >= 16 && this.cd.lastload == 2 && this.sc[0] < 36) {
                           this.cfase = 3;
                        } else {
                           this.cfase = 0;
                        }
                     }
                  }

                  if (this.cd.action == 100) {
                     this.cd.action = 101;
                     this.cd.sparkactionloader();
                  }

                  if (this.cd.action == 101) {
                     this.drawprom(145, 170);
                     this.drawcs(195, "Loading " + this.cd.viewname + "'s account cars, please wait...", 0, 0, 0, 3);
                  }

                  if (this.cd.action == 102) {
                     this.drawprom(145, 170);
                     this.drawcs(195, "Loading " + this.cd.viewname + "'s account cars, please wait...", 0, 0, 0, 3);
                     if (this.cd.nl > 0 && this.cd.nl <= 20) {
                        this.drawcs(235, "Loading :  " + this.cd.loadnames[this.cd.nl - 1] + "", 0, 0, 0, 3);
                     }
                  }

                  if (this.cd.action == 103) {
                     this.minsl = 36;
                     this.maxsl = this.cd.xnlocars - 1;
                     var19 = 36;
                     this.cd.action = 0;
                     this.cfase = 101;
                  }
               }

               if (this.cfase == 0 && this.testdrive != 1 && this.testdrive != 2 && this.gmode == 0) {
                  short var33 = 95;
                  byte var42 = 5;
                  if (this.multion != 0) {
                     var33 = 185;
                     var42 = 0;
                  }

                  if (this.multion == 0 && this.drawcarb(false, this.cmc, "", 95, 70, var4, var5, var6)) {
                     if (this.cd.lastload != 1) {
                        this.cfase = 1;
                     } else {
                        this.minsl = 16;
                        this.maxsl = this.cd.nlcars - 1;
                        var19 = 16;
                        this.cfase = 3;
                     }
                  }

                  if (this.drawcarb(false, this.myc, "", var33, 105 + var42, var4, var5, var6)) {
                     if (this.cd.lastload != 2) {
                        this.cfase = 5;
                        this.showtf = false;
                        if (!this.logged) {
                           this.cd.action = 0;
                           this.cd.reco = -2;
                           this.tcnt = 5;
                           this.cntflock = 0;
                        } else {
                           this.cd.action = 3;
                           this.cd.sparkactionloader();
                        }
                     } else {
                        this.minsl = 16;
                        this.maxsl = this.cd.nlocars - 1;
                        if (this.onmsc >= this.minsl && this.onmsc <= this.maxsl) {
                           var19 = this.onmsc;
                        } else {
                           var19 = 16;
                        }

                        this.cfase = 3;
                     }
                  }

                  if ((this.multion == 0 || this.onjoin == -1) && this.drawcarb(false, this.top20s, "", var33, (var33 - 95) / 7 + 25 + var42, var4, var5, var6)
                     )
                   {
                     this.cd.action = 0;
                     this.cfase = 10;
                  }

                  if (this.remi) {
                     this.remi = false;
                  }
               }

               if (this.cfase == -1) {
                  if (this.autolog) {
                     this.autolog = false;
                     this.cfase = 5;
                     this.cd.action = 1;
                     this.cd.sparkactionloader();
                  } else if (this.cd.lastload != 2) {
                     this.cfase = 5;
                     this.showtf = false;
                     if (!this.logged) {
                        this.cd.action = 0;
                        this.cd.reco = -2;
                        this.tcnt = 5;
                        this.cntflock = 0;
                     } else {
                        this.cd.action = 3;
                        this.cd.sparkactionloader();
                     }
                  } else {
                     this.minsl = 16;
                     this.maxsl = this.cd.nlocars - 1;
                     if (this.onmsc >= this.minsl && this.onmsc <= this.maxsl) {
                        var19 = this.onmsc;
                     } else {
                        var19 = 16;
                     }

                     this.cfase = 3;
                  }
               }

               if (this.cfase == 9) {
                  this.drawprom(145, 95);
                  this.drawcs(175, "Failed to remove car.  Unkown Error.  Try again laster.", 0, 0, 0, 3);
                  if (this.drawcarb(true, null, "   OK   ", 371, 195, var4, var5, var6)) {
                     this.minsl = 16;
                     this.maxsl = this.cd.nlocars - 1;
                     if (this.onmsc >= this.minsl && this.onmsc <= this.maxsl) {
                        var19 = this.onmsc;
                     } else {
                        var19 = 16;
                     }

                     this.cfase = 3;
                  }
               }

               if (this.cfase == 7) {
                  if (this.app.mycar.isShowing()) {
                     this.app.mycar.hide();
                  }

                  this.drawprom(145, 95);
                  this.drawcs(175, "Remove this car from your account?", 0, 0, 0, 3);
                  if (this.drawcarb(true, null, " Yes ", 354, 195, var4, var5, var6)) {
                     this.remi = true;
                     this.minsl = 0;
                     this.maxsl = 15;
                     var19 = 15;
                     this.cfase = 8;
                     this.onmsc = this.sc[0];
                     this.cd.ac = this.sc[0];
                     this.cd.action = 10;
                     this.cd.sparkactionloader();
                  }

                  if (this.drawcarb(true, null, " No ", 408, 195, var4, var5, var6)) {
                     this.cfase = 3;
                  }
               }

               if (this.cfase == 3 && var19 == -1) {
                  short var34 = 95;
                  byte var43 = 5;
                  if (this.multion != 0) {
                     var34 = 185;
                     var43 = 0;
                  }

                  if (this.drawcarb(false, this.gac, "", var34, 105 + var43, var4, var5, var6)) {
                     this.minsl = 0;
                     this.maxsl = 15;
                     if (this.onmsc >= this.minsl && this.onmsc <= this.maxsl) {
                        var19 = this.onmsc;
                     } else {
                        var19 = 15;
                     }

                     this.cfase = 0;
                  }

                  if (this.multion == 0) {
                     if (!this.app.openm) {
                        if (!this.app.mycar.isShowing()) {
                           this.app.mycar.show();
                           this.app.mycar.setState(this.cd.include[this.sc[0] - 16]);
                        }
                     } else {
                        this.app.mycar.hide();
                     }

                     this.rd.setColor(new Color(198, 179, 129));
                     this.rd.fillRoundRect(305, 302, 190, 24, 7, 20);
                     this.rd.setColor(new Color(0, 0, 0));
                     this.rd.drawRoundRect(305, 302, 190, 24, 7, 20);
                     this.app.movefield(this.app.mycar, 334, 306, 150, 17);
                     if (this.app.mycar.getState() != this.cd.include[this.sc[0] - 16]) {
                        this.cd.include[this.sc[0] - 16] = this.app.mycar.getState();
                        this.app.requestFocus();
                     }
                  }

                  if ((this.multion == 0 || this.onjoin == -1) && this.drawcarb(false, this.top20s, "", var34, (var34 - 95) / 7 + 25 + var43, var4, var5, var6)
                     )
                   {
                     this.cd.action = 0;
                     this.cfase = 10;
                     if (this.app.mycar.isShowing()) {
                        this.app.mycar.hide();
                     }
                  }

                  if (this.cd.lastload == 2) {
                     if (this.drawcarb(true, null, "X", 567, 135, var4, var5, var6)) {
                        this.cfase = 7;
                     }

                     this.rd.setFont(new Font("Arial", 1, 12));
                     this.ftm = this.rd.getFontMetrics();
                     this.rd.setColor(new Color(0, 0, 0));
                     if (!this.cd.createdby[this.sc[0] - 16].equals(this.nickname)) {
                        var26 = this.clink(this.cd.createdby[this.sc[0] - 16], var4, var5, var6);
                     } else {
                        this.rd.drawString("Created by You", 241, 160);
                     }
                  }

                  if (this.remi) {
                     this.remi = false;
                  }

                  if (this.noclass) {
                     this.drawprom(200, 95);
                     this.rd.setFont(new Font("Arial", 1, 13));
                     this.ftm = this.rd.getFontMetrics();
                     String var46 = "Class C";
                     if (this.ontyp == 2) {
                        var46 = "Class B or C";
                     }

                     if (this.ontyp == 3) {
                        var46 = "Class B";
                     }

                     if (this.ontyp == 4) {
                        var46 = "Class A or B";
                     }

                     if (this.ontyp == 5) {
                        var46 = "Class A";
                     }

                     this.drawcs(230, "You do not have a " + var46 + " car in your account cars.", 0, 0, 0, 3);
                     if (this.drawcarb(true, null, "   OK   ", 371, 250, var4, var5, var6)) {
                        this.noclass = false;
                     }
                  }
               }

               if ((this.cfase == 11 || this.cfase == 101) && var19 == -1) {
                  if (this.cd.action == -9) {
                     this.drawprom(145, 95);
                     this.drawcs(175, "Unknown error!  Failed to add car.  Try again later.", 0, 0, 0, 3);
                     if (this.drawcarb(true, null, " OK ", 379, 195, var4, var5, var6)) {
                        this.cd.action = 0;
                     }
                  }

                  if (this.cd.action == -8) {
                     this.drawprom(145, 95);
                     this.drawcs(175, "Failed.  You already have 20 cars in your account!", 0, 0, 0, 3);
                     if (this.drawcarb(true, null, " OK ", 379, 195, var4, var5, var6)) {
                        this.cd.action = 0;
                     }
                  }

                  if (this.cd.action == -7) {
                     this.drawprom(145, 95);
                     this.drawcs(175, "You already have this car!", 0, 0, 0, 3);
                     if (this.drawcarb(true, null, " OK ", 379, 195, var4, var5, var6)) {
                        this.cd.action = 0;
                     }
                  }

                  if (this.cd.action == 7) {
                     this.drawprom(145, 95);
                     this.drawcs(175, "" + this.cd.names[this.cd.ac] + " has been successfully added to your cars!", 0, 0, 0, 3);
                     if (this.drawcarb(true, null, " OK ", 379, 195, var4, var5, var6)) {
                        this.cd.action = 0;
                     }
                  }

                  if (this.cd.action == 6) {
                     this.drawprom(145, 95);
                     this.drawcs(195, "Adding " + this.cd.names[this.cd.ac] + " to your cars...", 0, 0, 0, 3);
                  }

                  short var35 = 95;
                  byte var44 = 5;
                  if (this.multion != 0) {
                     var35 = 185;
                     var44 = 0;
                  }

                  if (this.onmsc < 16 || this.cd.lastload != 2 && this.cd.lastload != -2) {
                     if (this.drawcarb(false, this.gac, "", var35, 105 + var44, var4, var5, var6)) {
                        this.cd.action = 0;
                        this.minsl = 0;
                        this.maxsl = 15;
                        if (this.onmsc >= this.minsl && this.onmsc <= this.maxsl) {
                           var19 = this.onmsc;
                        } else {
                           var19 = 15;
                        }

                        this.cfase = 0;
                        this.app.moused = false;
                     }
                  } else if (this.drawcarb(false, this.myc, "", var35, 105 + var44, var4, var5, var6)) {
                     if (this.cd.lastload != 2) {
                        this.cfase = 5;
                        this.showtf = false;
                        if (!this.logged) {
                           this.cd.action = 0;
                           this.cd.reco = -2;
                           this.tcnt = 5;
                           this.cntflock = 0;
                        } else {
                           this.cd.action = 3;
                           this.cd.sparkactionloader();
                        }
                     } else {
                        this.cd.action = 0;
                        this.minsl = 16;
                        this.maxsl = this.cd.nlocars - 1;
                        if (this.onmsc >= this.minsl && this.onmsc <= this.maxsl) {
                           var19 = this.onmsc;
                        } else {
                           var19 = 16;
                        }

                        this.cfase = 3;
                     }

                     this.app.moused = false;
                  }

                  if (this.drawcarb(false, this.top20s, "", var35, (var35 - 95) / 7 + 25 + var44, var4, var5, var6)) {
                     this.cd.action = 0;
                     this.cfase = 10;
                  }

                  if (this.cd.action == 0) {
                     this.rd.setFont(new Font("Arial", 1, 12));
                     this.ftm = this.rd.getFontMetrics();
                     this.rd.setColor(new Color(0, 0, 0));
                     if (!this.cd.createdby[this.sc[0] - 16].equals(this.nickname)) {
                        var26 = this.clink(this.cd.createdby[this.sc[0] - 16], var4, var5, var6);
                     } else {
                        this.rd.drawString("Created by You", 241, 160);
                     }

                     if (this.cfase != 101) {
                        this.rd.setFont(new Font("Arial", 1, 11));
                        this.rd.drawString("Added by :  " + this.cd.adds[this.sc[0] - 36] + " Players", 241, 180);
                     }
                  }
               }

               if (this.cfase == 5) {
                  this.drawprom(145, 170);
                  if (this.cd.action == 5) {
                     this.minsl = 16;
                     this.maxsl = this.cd.nlocars - 1;
                     if (this.cd.inslot != -1) {
                        this.onmsc = this.cd.inslot;
                        this.cd.inslot = -1;
                     }

                     if (this.onmsc >= this.minsl && this.onmsc <= this.maxsl) {
                        var19 = this.onmsc;
                     } else {
                        var19 = 16;
                     }

                     this.cfase = 3;
                  }

                  if (this.cd.action == 4) {
                     this.drawcs(195, "[  Loading Car  ]", 0, 0, 0, 3);
                     this.drawcs(235, "Loading :  " + this.app.mcars.getSelectedItem() + "", 0, 0, 0, 3);
                  }

                  if (this.cd.action == -2) {
                     this.drawcs(195, "Unknown Connection Error", 0, 0, 0, 3);
                     this.drawcs(225, "Failed to connect to server, try again later!", 0, 0, 0, 3);
                     if (this.drawcarb(true, null, "   OK   ", 371, 255, var4, var5, var6)) {
                        this.cfase = 0;
                     }
                  }

                  if (this.cd.action == -1) {
                     this.drawcs(195, "No published cars found...", 0, 0, 0, 3);
                     this.drawcs(225, "You have no added cars to your account yet!", 0, 0, 0, 3);
                     if (this.drawcarb(true, null, "   OK   ", 371, 255, var4, var5, var6)) {
                        this.cfase = 0;
                     }
                  }

                  if (this.cd.action == 2 || this.cd.action == 3) {
                     this.drawcs(195, "Loading your Account Cars list...", 0, 0, 0, 3);
                     if (this.cd.action == 2) {
                        this.nickname = this.app.tnick.getText();
                        this.backlog = this.nickname;
                        this.nickey = this.cd.tnickey;
                        this.clan = this.cd.tclan;
                        this.clankey = this.cd.tclankey;
                        this.app.setloggedcookie();
                        this.logged = true;
                        this.gotlog = true;
                        if (this.cd.reco == 0) {
                           this.acexp = 0;
                        }

                        if (this.cd.reco > 10) {
                           this.acexp = this.cd.reco - 10;
                        }

                        if (this.cd.reco == 3) {
                           this.acexp = -1;
                        }

                        if (this.cd.reco == 111) {
                           if (!this.backlog.toLowerCase().equals(this.nickname.toLowerCase())) {
                              this.acexp = -3;
                           } else {
                              this.acexp = 0;
                           }
                        }

                        if (this.basefase == 0) {
                           this.cd.action = 3;
                        }

                        if (this.basefase == 11) {
                           this.cd.action = 6;
                           this.cfase = 11;
                        }

                        if (this.basefase == 101) {
                           this.cd.action = 6;
                           this.cfase = 101;
                        }
                     }
                  }

                  if (this.cd.action == 1) {
                     this.drawcs(195, "Logging in to your account...", 0, 0, 0, 3);
                  }

                  if (this.cd.action == 0) {
                     if (this.cd.reco == -5) {
                        this.drawcs(171, "Login to Add this Car to your Account", 0, 0, 0, 3);
                     }

                     if (this.cd.reco == -2) {
                        this.drawcs(171, "Login to Retrieve your Account Cars", 0, 0, 0, 3);
                     }

                     if (this.cd.reco == -1) {
                        this.drawcs(171, "Unable to connect to server, try again later!", 0, 8, 0, 3);
                     }

                     if (this.cd.reco == 1) {
                        this.drawcs(171, "Sorry.  The Nickname you have entered is incorrect.", 0, 0, 0, 3);
                     }

                     if (this.cd.reco == 2) {
                        this.drawcs(171, "Sorry.  The Password you have entered is incorrect.", 0, 0, 0, 3);
                     }

                     if (this.cd.reco == -167 || this.cd.reco == -177) {
                        if (this.cd.reco == -167) {
                           this.nickname = this.app.tnick.getText();
                           this.backlog = this.nickname;
                           this.cd.reco = -177;
                        }

                        this.drawcs(171, "You are currently using a trial account.", 0, 0, 0, 3);
                     }

                     if (this.cd.reco == -3 && (this.tcnt % 3 != 0 || this.tcnt > 20)) {
                        this.drawcs(171, "Please enter your Nickname!", 0, 0, 0, 3);
                     }

                     if (this.cd.reco == -4 && (this.tcnt % 3 != 0 || this.tcnt > 20)) {
                        this.drawcs(171, "Please enter your Password!", 0, 0, 0, 3);
                     }

                     if (!this.showtf) {
                        this.app.tnick.show();
                        this.app.tnick.setBackground(new Color(206, 237, 255));
                        if (this.cd.reco != 1) {
                           if (this.cd.reco != 2) {
                              this.app.tnick.setText(this.nickname);
                           }

                           this.app.tnick.setForeground(new Color(0, 0, 0));
                        } else {
                           this.app.tnick.setForeground(new Color(255, 0, 0));
                        }

                        this.app.tnick.requestFocus();
                        this.app.tpass.show();
                        this.app.tpass.setBackground(new Color(206, 237, 255));
                        if (this.cd.reco != 2) {
                           if (!this.autolog) {
                              this.app.tpass.setText("");
                           }

                           this.app.tpass.setForeground(new Color(0, 0, 0));
                        } else {
                           this.app.tpass.setForeground(new Color(255, 0, 0));
                        }

                        if (!this.app.tnick.getText().equals("") && this.cd.reco != 1) {
                           this.app.tpass.requestFocus();
                        }

                        this.showtf = true;
                     }

                     this.rd.drawString("Nickname:", 376 - this.ftm.stringWidth("Nickname:") - 14, 201);
                     this.rd.drawString("Password:", 376 - this.ftm.stringWidth("Password:") - 14, 231);
                     this.app.movefieldd(this.app.tnick, 376, 185, 129, 23, true);
                     this.app.movefieldd(this.app.tpass, 376, 215, 129, 23, true);
                     if (this.tcnt < 30) {
                        this.tcnt++;
                        if (this.tcnt == 30) {
                           if (this.cd.reco == 2) {
                              this.app.tpass.setText("");
                           }

                           this.app.tnick.setForeground(new Color(0, 0, 0));
                           this.app.tpass.setForeground(new Color(0, 0, 0));
                        }
                     }

                     if (this.cd.reco != -177) {
                        if (this.drawcarb(true, null, "       Login       ", 347, 247, var4, var5, var6) && this.tcnt > 5) {
                           this.tcnt = 0;
                           if (!this.app.tnick.getText().equals("") && !this.app.tpass.getText().equals("")) {
                              this.autolog = false;
                              this.app.tnick.hide();
                              this.app.tpass.hide();
                              this.app.requestFocus();
                              this.cd.action = 1;
                              this.cd.sparkactionloader();
                           } else {
                              if (this.app.tpass.getText().equals("")) {
                                 this.cd.reco = -4;
                              }

                              if (this.app.tnick.getText().equals("")) {
                                 this.cd.reco = -3;
                              }
                           }
                        }
                     } else if (this.drawcarb(true, null, "  Upgrade to have your own cars!  ", 284, 247, var4, var5, var6) && this.cntflock == 0) {
                        this.app.editlink(this.nickname, true);
                        this.cntflock = 100;
                     }

                     if (this.drawcarb(true, null, "  Cancel  ", 409, 282, var4, var5, var6)) {
                        this.app.tnick.hide();
                        this.app.tpass.hide();
                        this.app.requestFocus();
                        this.cfase = this.basefase;
                     }

                     if (this.drawcarb(true, null, "  Register!  ", 316, 282, var4, var5, var6)) {
                        if (this.cntflock == 0) {
                           this.app.reglink();
                           this.cntflock = 100;
                        }
                     } else if (this.cntflock != 0) {
                        this.cntflock--;
                     }
                  }
               }

               if (this.cfase == 4) {
                  this.drawprom(145, 150);
                  this.rd.setColor(new Color(0, 0, 0));
                  this.rd.drawString("Failed to find any ready car in your ‘mycars’ folder!", 215, 175);
                  this.rd.drawString("Please ‘Test Drive’ your cars in the Car Maker to make", 215, 215);
                  this.rd.drawString("sure they are ready.", 215, 235);
                  if (this.drawcarb(true, null, "   OK   ", 371, 255, var4, var5, var6)) {
                     this.cfase = 0;
                  }
               }

               if (this.cfase == 2) {
                  this.drawprom(165, 70);
                  this.drawcs(205, "Loading Car Maker Cars...", 0, 0, 0, 3);
                  this.app.repaint();
                  this.cd.loadcarmaker();
                  if (this.cd.nlcars > 16) {
                     this.minsl = 16;
                     this.maxsl = this.cd.nlcars - 1;
                     var19 = 16;
                     this.cfase = 3;
                  } else {
                     this.cfase = 4;
                  }
               }

               if (this.cfase == 1) {
                  this.drawprom(145, 170);
                  this.rd.setColor(new Color(0, 0, 0));
                  this.rd.drawString("The game will now load all the cars that can be loaded", 215, 170);
                  this.rd.drawString("from your ‘mycars’ folder.", 215, 190);
                  this.rd.drawString("If a car is not loaded, then it is not ready (not finished).", 215, 210);
                  this.rd.drawString("Perform a ‘Test Drive’ on any car to see if it is ready or not.", 215, 230);
                  this.rd.drawString("The maximum number of cars that can be loaded is  40 !", 215, 260);
                  if (this.drawcarb(true, null, "   OK   ", 371, 275, var4, var5, var6)) {
                     this.cfase = 2;
                  }
               }

               this.rd.setFont(new Font("Arial", 1, 11));
               this.ftm = this.rd.getFontMetrics();
               this.rd.setColor(new Color(181, 120, 40));
               this.rd.drawString("Top Speed:", 98, 343);
               this.rd.drawImage(this.statb, 162, 337, null);
               this.rd.drawString("Acceleration:", 88, 358);
               this.rd.drawImage(this.statb, 162, 352, null);
               this.rd.drawString("Handling:", 110, 373);
               this.rd.drawImage(this.statb, 162, 367, null);
               this.rd.drawString("Stunts:", 495, 343);
               this.rd.drawImage(this.statb, 536, 337, null);
               this.rd.drawString("Strength:", 483, 358);
               this.rd.drawImage(this.statb, 536, 352, null);
               this.rd.drawString("Endurance:", 473, 373);
               this.rd.drawImage(this.statb, 536, 367, null);
               this.rd.setColor(new Color(0, 0, 0));
               float var36 = (this.cd.swits[this.sc[0]][2] - 220) / 90.0F;
               if (var36 < 0.2) {
                  var36 = 0.2F;
               }

               this.rd.fillRect((int)(162.0F + 156.0F * var36), 337, (int)(156.0F * (1.0F - var36) + 1.0F), 7);
               var36 = this.cd.acelf[this.sc[0]][1] * this.cd.acelf[this.sc[0]][0] * this.cd.acelf[this.sc[0]][2] * this.cd.grip[this.sc[0]] / 7700.0F;
               if (var36 > 1.0F) {
                  var36 = 1.0F;
               }

               this.rd.fillRect((int)(162.0F + 156.0F * var36), 352, (int)(156.0F * (1.0F - var36) + 1.0F), 7);
               var36 = this.cd.dishandle[this.sc[0]];
               this.rd.fillRect((int)(162.0F + 156.0F * var36), 367, (int)(156.0F * (1.0F - var36) + 1.0F), 7);
               var36 = (this.cd.airc[this.sc[0]] * this.cd.airs[this.sc[0]] * this.cd.bounce[this.sc[0]] + 28.0F) / 139.0F;
               if (var36 > 1.0F) {
                  var36 = 1.0F;
               }

               this.rd.fillRect((int)(536.0F + 156.0F * var36), 337, (int)(156.0F * (1.0F - var36) + 1.0F), 7);
               float var45 = 0.5F;
               var36 = (this.cd.moment[this.sc[0]] + var45) / 2.6F;
               if (var36 > 1.0F) {
                  var36 = 1.0F;
               }

               this.rd.fillRect((int)(536.0F + 156.0F * var36), 352, (int)(156.0F * (1.0F - var36) + 1.0F), 7);
               var36 = this.cd.outdam[this.sc[0]];
               this.rd.fillRect((int)(536.0F + 156.0F * var36), 367, (int)(156.0F * (1.0F - var36) + 1.0F), 7);
               this.rd.drawImage(this.statbo, 162, 337, null);
               this.rd.drawImage(this.statbo, 162, 352, null);
               this.rd.drawImage(this.statbo, 162, 367, null);
               this.rd.drawImage(this.statbo, 536, 337, null);
               this.rd.drawImage(this.statbo, 536, 352, null);
               this.rd.drawImage(this.statbo, 536, 367, null);
               if (this.multion != 0 || this.testdrive == 1 || this.testdrive == 2) {
                  this.rd.setFont(new Font("Arial", 1, 13));
                  this.ftm = this.rd.getFontMetrics();
                  String var47 = "Class C";
                  if (this.cd.cclass[this.sc[0]] == 1) {
                     var47 = "Class B & C";
                  }

                  if (this.cd.cclass[this.sc[0]] == 2) {
                     var47 = "Class B";
                  }

                  if (this.cd.cclass[this.sc[0]] == 3) {
                     var47 = "Class A & B";
                  }

                  if (this.cd.cclass[this.sc[0]] == 4) {
                     var47 = "Class A";
                  }

                  if (this.kbload < 7) {
                     this.rd.setColor(new Color(0, 0, 0));
                     this.kbload++;
                  } else {
                     this.rd.setColor(new Color(176, 41, 0));
                     this.kbload = 0;
                  }

                  if (this.cfase != 10 || this.cd.action != 0 && this.cd.action < 14) {
                     this.rd.drawString(var47, 549 - this.ftm.stringWidth(var47) / 2, 95);
                  }

                  this.rd.setFont(new Font("Arial", 1, 12));
                  this.ftm = this.rd.getFontMetrics();
                  this.rd.setColor(new Color(0, 0, 0));
                  this.rd.drawString("1st Color", 100, 55);
                  this.rd.drawString("2nd Color", 649, 55);
                  this.rd.setFont(new Font("Arial", 1, 10));
                  this.ftm = this.rd.getFontMetrics();
                  this.rd.drawString("Hue  | ", 97, 70);
                  this.rd.drawImage(this.brt, 137, 63, null);
                  this.rd.drawString("Hue  | ", 647, 70);
                  this.rd.drawImage(this.brt, 687, 63, null);
                  this.rd.drawString("Intensity", 121, 219);
                  this.rd.drawString("Intensity", 671, 219);
                  this.rd.drawString("Reset", 110, 257);
                  this.rd.drawString("Reset", 660, 257);

                  for (int var14 = 0; var14 < 161; var14++) {
                     this.rd.setColor(Color.getHSBColor((float)(var14 * 0.00625), 1.0F, 1.0F));
                     this.rd.drawLine(102, 75 + var14, 110, 75 + var14);
                     if (var14 <= 128) {
                        this.rd.setColor(Color.getHSBColor(1.0F, 0.0F, (float)(1.0 - var14 * 0.00625)));
                        this.rd.drawLine(137, 75 + var14, 145, 75 + var14);
                     }

                     this.rd.setColor(Color.getHSBColor((float)(var14 * 0.00625), 1.0F, 1.0F));
                     this.rd.drawLine(652, 75 + var14, 660, 75 + var14);
                     if (var14 <= 128) {
                        this.rd.setColor(Color.getHSBColor(1.0F, 0.0F, (float)(1.0 - var14 * 0.00625)));
                        this.rd.drawLine(687, 75 + var14, 695, 75 + var14);
                     }
                  }

                  for (int var48 = 0; var48 < 40; var48++) {
                     this.rd.setColor(Color.getHSBColor(this.arnp[0], (float)(var48 * 0.025), 1.0F - this.arnp[2]));
                     this.rd.drawLine(121 + var48, 224, 121 + var48, 230);
                     this.rd.setColor(Color.getHSBColor(this.arnp[3], (float)(var48 * 0.025), 1.0F - this.arnp[5]));
                     this.rd.drawLine(671 + var48, 224, 671 + var48, 230);
                  }

                  this.rd.drawImage(this.arn, 110, 71 + (int)(this.arnp[0] * 160.0F), null);
                  this.rd.drawImage(this.arn, 145, 71 + (int)(this.arnp[2] * 160.0F), null);
                  this.rd.drawImage(this.arn, 660, 71 + (int)(this.arnp[3] * 160.0F), null);
                  this.rd.drawImage(this.arn, 695, 71 + (int)(this.arnp[5] * 160.0F), null);
                  this.rd.setColor(new Color(0, 0, 0));
                  this.rd.fillRect(120 + (int)(this.arnp[1] * 40.0F), 222, 3, 3);
                  this.rd.drawLine(121 + (int)(this.arnp[1] * 40.0F), 224, 121 + (int)(this.arnp[1] * 40.0F), 230);
                  this.rd.fillRect(120 + (int)(this.arnp[1] * 40.0F), 230, 3, 3);
                  this.rd.fillRect(670 + (int)(this.arnp[4] * 40.0F), 222, 3, 3);
                  this.rd.drawLine(671 + (int)(this.arnp[4] * 40.0F), 224, 671 + (int)(this.arnp[4] * 40.0F), 230);
                  this.rd.fillRect(670 + (int)(this.arnp[4] * 40.0F), 230, 3, 3);
                  if (var6) {
                     if (this.mouson == -1) {
                        if (var4 > 96 && var4 < 152 && var5 > 248 && var5 < 258) {
                           float[] var49 = new float[3];
                           Color.RGBtoHSB(var2[this.sc[0]].fcol[0], var2[this.sc[0]].fcol[1], var2[this.sc[0]].fcol[2], var49);
                           this.arnp[0] = var49[0];
                           this.arnp[1] = var49[1];
                           this.arnp[2] = 1.0F - var49[2];
                        }

                        if (var4 > 646 && var4 < 702 && var5 > 248 && var5 < 258) {
                           float[] var50 = new float[3];
                           Color.RGBtoHSB(var2[this.sc[0]].scol[0], var2[this.sc[0]].scol[1], var2[this.sc[0]].scol[2], var50);
                           this.arnp[3] = var50[0];
                           this.arnp[4] = var50[1];
                           this.arnp[5] = 1.0F - var50[2];
                        }

                        this.mouson = -2;
                        if (var4 > 119 && var4 < 163 && var5 > 222 && var5 < 232) {
                           this.mouson = 1;
                        }

                        if (var4 > 669 && var4 < 713 && var5 > 222 && var5 < 232) {
                           this.mouson = 4;
                        }

                        if (var4 > 98 && var4 < 122 && var5 > 69 && var5 < 241 && this.mouson == -2) {
                           this.mouson = 0;
                        }

                        if (var4 > 133 && var4 < 157 && var5 > 69 && var5 < 209 && this.mouson == -2) {
                           this.mouson = 2;
                        }

                        if (var4 > 648 && var4 < 672 && var5 > 69 && var5 < 241 && this.mouson == -2) {
                           this.mouson = 3;
                        }

                        if (var4 > 683 && var4 < 707 && var5 > 69 && var5 < 209 && this.mouson == -2) {
                           this.mouson = 5;
                        }
                     }
                  } else if (this.mouson != -1) {
                     this.mouson = -1;
                  }

                  if (this.mouson == 0 || this.mouson == 2 || this.mouson == 3 || this.mouson == 5) {
                     this.arnp[this.mouson] = (float)((var5 - 75.0F) * 0.00625);
                     if (this.mouson != 2 && this.mouson != 5) {
                        if (this.arnp[this.mouson] > 1.0F) {
                           this.arnp[this.mouson] = 1.0F;
                        }
                     } else if (this.arnp[this.mouson] > 0.8) {
                        this.arnp[this.mouson] = 0.8F;
                     }

                     if (this.arnp[this.mouson] < 0.0F) {
                        this.arnp[this.mouson] = 0.0F;
                     }
                  }

                  if (this.mouson == 1) {
                     this.arnp[this.mouson] = (float)((var4 - 121.0F) * 0.025);
                     if (this.arnp[this.mouson] > 1.0F) {
                        this.arnp[this.mouson] = 1.0F;
                     }

                     if (this.arnp[this.mouson] < 0.0F) {
                        this.arnp[this.mouson] = 0.0F;
                     }
                  }

                  if (this.mouson == 4) {
                     this.arnp[this.mouson] = (float)((var4 - 671.0F) * 0.025);
                     if (this.arnp[this.mouson] > 1.0F) {
                        this.arnp[this.mouson] = 1.0F;
                     }

                     if (this.arnp[this.mouson] < 0.0F) {
                        this.arnp[this.mouson] = 0.0F;
                     }
                  }

                  if (this.cfase != 10 && this.cfase != 5 && var19 == -1) {
                     Color var51 = Color.getHSBColor(this.arnp[0], this.arnp[1], 1.0F - this.arnp[2]);
                     Color var15 = Color.getHSBColor(this.arnp[3], this.arnp[4], 1.0F - this.arnp[5]);

                     for (int var16 = 0; var16 < var2[this.sc[0]].npl; var16++) {
                        if (var2[this.sc[0]].p[var16].colnum == 1) {
                           var2[this.sc[0]].p[var16].hsb[0] = this.arnp[0];
                           var2[this.sc[0]].p[var16].hsb[1] = this.arnp[1];
                           var2[this.sc[0]].p[var16].hsb[2] = 1.0F - this.arnp[2];
                           var2[this.sc[0]].p[var16].c[0] = var51.getRed();
                           var2[this.sc[0]].p[var16].c[1] = var51.getGreen();
                           var2[this.sc[0]].p[var16].c[2] = var51.getBlue();
                           var2[this.sc[0]].p[var16].oc[0] = var51.getRed();
                           var2[this.sc[0]].p[var16].oc[1] = var51.getGreen();
                           var2[this.sc[0]].p[var16].oc[2] = var51.getBlue();
                        }

                        if (var2[this.sc[0]].p[var16].colnum == 2) {
                           var2[this.sc[0]].p[var16].hsb[0] = this.arnp[3];
                           var2[this.sc[0]].p[var16].hsb[1] = this.arnp[4];
                           var2[this.sc[0]].p[var16].hsb[2] = 1.0F - this.arnp[5];
                           var2[this.sc[0]].p[var16].c[0] = var15.getRed();
                           var2[this.sc[0]].p[var16].c[1] = var15.getGreen();
                           var2[this.sc[0]].p[var16].c[2] = var15.getBlue();
                           var2[this.sc[0]].p[var16].oc[0] = var15.getRed();
                           var2[this.sc[0]].p[var16].oc[1] = var15.getGreen();
                           var2[this.sc[0]].p[var16].oc[2] = var15.getBlue();
                        }
                     }
                  }
               }
            }

            if (!this.remi && this.cfase != 10 && this.cfase != 11 && this.cfase != 100 && this.cfase != 101) {
               this.rd.drawImage(this.contin[this.pcontin], 355, 385, null);
            } else {
               if ((this.cfase == 11 || this.cfase == 101) && this.drawcarb(true, null, "Race this car", 505, 385, var4, var5, var6) && this.cd.action == 0) {
                  var1.handb = true;
               }

               if (this.cfase == 11 && this.drawcarb(true, null, "Add to My Cars", 345, 385, var4, var5, var6) && this.cd.action == 0) {
                  this.cd.ac = this.sc[0];
                  if (this.logged) {
                     this.cd.action = 6;
                     this.cd.sparkactionloader();
                  } else {
                     this.cd.reco = -5;
                     this.cfase = 5;
                     this.showtf = false;
                  }
               }

               if (this.cfase == 101 && var19 == -1) {
                  if (this.cd.publish[this.sc[0] - 16] != 1 && this.cd.publish[this.sc[0] - 16] != 2) {
                     this.rd.setFont(new Font("Arial", 1, 12));
                     this.ftm = this.rd.getFontMetrics();
                     this.drawcs(405, "Private Car", 193, 106, 0, 3);
                  } else if (this.drawcarb(true, null, "Add to My Cars", 345, 385, var4, var5, var6) && this.cd.action == 0) {
                     this.cd.ac = this.sc[0];
                     if (this.logged) {
                        this.cd.action = 6;
                        this.cd.sparkactionloader();
                     } else {
                        this.cd.reco = -5;
                        this.cfase = 5;
                        this.showtf = false;
                     }
                  }
               }
            }
         }
      } else {
         if (this.cfase == 11 || this.cfase == 101) {
            this.cd.action = 0;
         }

         if (this.app.mycar.isShowing()) {
            this.app.mycar.hide();
         }

         this.pback = 0;
         this.pnext = 0;
         this.gatey = 300;
         if (this.flipo > 10) {
            var2[this.sc[0]].y -= 100;
            if (this.nextc == 1) {
               var2[this.sc[0]].zy += 20;
            }

            if (this.nextc == -1) {
               var2[this.sc[0]].zy -= 20;
            }
         } else {
            if (this.flipo == 10) {
               if (this.nextc >= 20) {
                  this.sc[0] = this.nextc - 20;
                  this.lsc = -1;
               }

               if (this.nextc == 1) {
                  this.sc[0]++;
                  if (this.gmode == 1) {
                     if (this.sc[0] == 7) {
                        this.sc[0] = 11;
                     }

                     if (this.sc[0] == 12) {
                        this.sc[0] = 14;
                     }
                  }

                  if (this.multion != 0 && this.onjoin != -1 && this.ontyp > 0 && this.ontyp <= 5) {
                     while (this.sc[0] < this.maxsl && Math.abs(this.cd.cclass[this.sc[0]] - (this.ontyp - 1)) > 1) {
                        this.sc[0]++;
                     }
                  }
               }

               if (this.nextc == -1) {
                  this.sc[0]--;
                  if (this.gmode == 1) {
                     if (this.sc[0] == 13) {
                        this.sc[0] = 11;
                     }

                     if (this.sc[0] == 10) {
                        this.sc[0] = 6;
                     }
                  }

                  if (this.multion != 0 && this.onjoin != -1 && this.ontyp > 0 && this.ontyp <= 5) {
                     while (this.sc[0] > this.minsl && Math.abs(this.cd.cclass[this.sc[0]] - (this.ontyp - 1)) > 1) {
                        this.sc[0]--;
                     }
                  }
               }

               if (this.cfase == 3 && this.cd.lastload == 2) {
                  this.app.mcars.select(this.cd.names[this.sc[0]]);
               }

               var2[this.sc[0]].z = 950;
               var2[this.sc[0]].y = -34 - var2[this.sc[0]].grat - 1100;
               var2[this.sc[0]].x = 0;
               var2[this.sc[0]].zy = 0;
            }

            var2[this.sc[0]].y += 100;
         }

         this.flipo--;
      }

      if (this.cfase != 0 && this.cfase != 3 && this.cfase != 11 && this.cfase != 101) {
         this.pback = 0;
         this.pnext = 0;
         this.pcontin = 0;
         if (this.cfase == 8 && var19 != -1) {
            if (this.flatrstart > 1) {
               this.flatrstart = 0;
            }

            this.nextc = var19 + 20;
            this.flipo = 20;
         }

         if (this.cfase == 5 && this.cd.action == 0 && var1.enter) {
            this.tcnt = 0;
            if (!this.app.tnick.getText().equals("") && !this.app.tpass.getText().equals("")) {
               this.app.tnick.hide();
               this.app.tpass.hide();
               this.app.requestFocus();
               this.cd.action = 1;
               this.cd.sparkactionloader();
            } else {
               if (this.app.tpass.getText().equals("")) {
                  this.cd.reco = -4;
               }

               if (this.app.tnick.getText().equals("")) {
                  this.cd.reco = -3;
               }
            }

            var1.enter = false;
         }
      } else {
         this.basefase = this.cfase;
         if (var19 != -1) {
            if (this.flatrstart > 1) {
               this.flatrstart = 0;
            }

            this.nextc = var19 + 20;
            this.flipo = 20;
         }

         if (var1.right) {
            var1.right = false;
            if (this.sc[0] != this.maxsl && this.flipo == 0) {
               if (this.flatrstart > 1) {
                  this.flatrstart = 0;
               }

               this.nextc = 1;
               this.flipo = 20;
            }
         }

         if (var1.left) {
            var1.left = false;
            if (this.sc[0] != this.minsl && this.flipo == 0) {
               if (this.flatrstart > 1) {
                  this.flatrstart = 0;
               }

               this.nextc = -1;
               this.flipo = 20;
            }
         }

         if (/*this.cfase != 11 && this.cfase != 101 &&*/ var22 == 0 && this.flipo < 10 && (var1.handb || var1.enter)) {
            this.m.crs = false;
            this.app.mcars.show = false;
            if (this.multion != 0) {
               this.fase = 1177;
               this.intertrack.stop();
            } else if (this.testdrive != 3 && this.testdrive != 4) {
               this.fase = 3;
            } else {
               this.fase = -22;
            }

            if (this.sc[0] < 16 || this.cd.lastload == 2) {
               this.app.setcarcookie(this.sc[0], this.cd.names[this.sc[0]], this.arnp, this.gmode, this.unlocked, this.mtop);
            }

            if (this.cd.haltload != 0) {
               if (this.cd.haltload == 2) {
                  this.cd.lcardate[1] = 0;
               }

               this.cd.lcardate[0] = 0;
               this.cd.haltload = 0;
            }

            if (this.gmode == 0) {
               this.osc = this.sc[0];
            }

            if (this.gmode == 1) {
               this.scm[0] = this.sc[0];
            }

            if (this.gmode == 2) {
               this.scm[1] = this.sc[0];
            }

            if (this.app.mycar.isShowing()) {
               this.app.mycar.hide();
            }

            this.flexpix = null;
            var1.handb = false;
            var1.enter = false;
         }
      }

      if (var1.handb || var1.enter) {
         var1.handb = false;
         var1.enter = false;
      }

      if (var26) {
         this.app.mouses = 0;
         this.onviewpro = true;
         this.cd.viewname = this.cd.createdby[this.sc[0] - 16];
         this.m.crs = false;
         this.fase = 1177;
         this.intertrack.stop();
         this.sc[0] = this.onmsc;
         if (this.sc[0] >= 16 && this.cd.lastload != 2 || this.sc[0] >= 36) {
            this.sc[0] = 15;
         }

         this.osc = this.sc[0];
         this.multion = 1;
         this.gmode = 0;
         if (this.app.mycar.isShowing()) {
            this.app.mycar.hide();
         }

         this.flexpix = null;
         var1.handb = false;
         var1.enter = false;
      }
   }

   public void colorCar(ContO var1, int var2) {
      if (this.plnames[var2].indexOf("MadBot") == -1) {
         for (int var3 = 0; var3 < var1.npl; var3++) {
            if (var1.p[var3].colnum == 1) {
               Color var4 = Color.getHSBColor(this.allrnp[var2][0], this.allrnp[var2][1], 1.0F - this.allrnp[var2][2]);
               var1.p[var3].oc[0] = var4.getRed();
               var1.p[var3].oc[1] = var4.getGreen();
               var1.p[var3].oc[2] = var4.getBlue();
            }

            if (var1.p[var3].colnum == 2) {
               Color var6 = Color.getHSBColor(this.allrnp[var2][3], this.allrnp[var2][4], 1.0F - this.allrnp[var2][5]);
               var1.p[var3].oc[0] = var6.getRed();
               var1.p[var3].oc[1] = var6.getGreen();
               var1.p[var3].oc[2] = var6.getBlue();
            }
         }
      } else {
         for (int var5 = 0; var5 < var1.npl; var5++) {
            if (var1.p[var5].colnum == 1) {
               var1.p[var5].oc[0] = var1.fcol[0];
               var1.p[var5].oc[1] = var1.fcol[1];
               var1.p[var5].oc[2] = var1.fcol[2];
            }

            if (var1.p[var5].colnum == 2) {
               var1.p[var5].oc[0] = var1.scol[0];
               var1.p[var5].oc[1] = var1.scol[1];
               var1.p[var5].oc[2] = var1.scol[2];
            }
         }
      }
   }

   public boolean clink(String var1, int var2, int var3, boolean var4) {
      boolean var5 = false;
      this.rd.drawString("Created by :  " + var1 + "", 241, 160);
      int var6 = this.ftm.stringWidth(var1);
      int var7 = 241 + this.ftm.stringWidth("Created by :  " + var1 + "") - var6;
      this.rd.drawLine(var7, 162, var7 + var6 - 2, 162);
      if (var2 > var7 - 2 && var2 < var7 + var6 && var3 > 147 && var3 < 164) {
         if (var4) {
            var5 = true;
         }

         if (this.waitlink != 1) {
            this.app.setCursor(new Cursor(12));
            this.waitlink = 1;
         }
      } else if (this.waitlink != 0) {
         this.app.setCursor(new Cursor(0));
         this.waitlink = 0;
      }

      return var5;
   }

   public void drawprom(int var1, int var2) {
      this.rd.setComposite(AlphaComposite.getInstance(3, 0.76F));
      this.rd.setColor(new Color(129, 203, 237));
      this.rd.fillRoundRect(205, var1, 390, var2, 30, 30);
      this.rd.setColor(new Color(0, 0, 0));
      this.rd.drawRoundRect(205, var1, 390, var2, 30, 30);
      this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
   }

   public void drawdprom(int var1, int var2) {
      this.rd.setComposite(AlphaComposite.getInstance(3, 0.9F));
      this.rd.setColor(new Color(129, 203, 237));
      this.rd.fillRoundRect(205, var1, 390, var2, 30, 30);
      this.rd.setColor(new Color(0, 0, 0));
      this.rd.drawRoundRect(205, var1, 390, var2, 30, 30);
      this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
   }

   public void drawlprom(int var1, int var2) {
      this.rd.setComposite(AlphaComposite.getInstance(3, 0.5F));
      this.rd.setColor(new Color(129, 203, 237));
      this.rd.fillRoundRect(277, var1, 390, var2, 30, 30);
      this.rd.setColor(new Color(0, 0, 0));
      this.rd.drawRoundRect(277, var1, 390, var2, 30, 30);
      this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
   }

   public void finish(CheckPoints var1, ContO[] var2, Control var3, int var4, int var5, boolean var6) {
      if (!this.badmac) {
         this.rd.drawImage(this.fleximg, 0, 0, null);
      } else {
         this.rd.setColor(new Color(0, 0, 0));
         this.rd.setComposite(AlphaComposite.getInstance(3, 0.1F));
         this.rd.fillRect(0, 0, 800, 450);
         this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
      }

      this.rd.setFont(new Font("Arial", 1, 11));
      this.ftm = this.rd.getFontMetrics();
      short var7 = 0;
      String var8 = ":";
      if (var1.stage > 0) {
         int var9 = var1.stage;
         if (var9 > 10) {
            var9 -= 10;
         }

         var8 = " " + var9 + "!";
      }

      if (this.multion < 3) {
         if (this.winner) {
            this.rd.drawImage(this.congrd, 265, 87, null);
            this.drawcs(137, "You Won!  At Stage" + var8 + "", 255, 161, 85, 3);
            this.drawcs(154, "" + var1.name + "", 255, 115, 0, 3);
            var7 = 154;
         } else {
            this.rd.drawImage(this.gameov, 315, 117, null);
            if (this.multion == 0 || this.forstart != 700 && this.discon != 240) {
               this.drawcs(167, "You Lost!  At Stage" + var8 + "", 255, 161, 85, 3);
               this.drawcs(184, "" + var1.name + "", 255, 115, 0, 3);
               var7 = 184;
            } else {
               this.drawcs(167, "Sorry, You where Disconnected from Game!", 255, 161, 85, 3);
               this.drawcs(184, "Please check your connection!", 255, 115, 0, 3);
            }
         }
      } else {
         this.rd.drawImage(this.gameov, 315, 117, null);
         this.drawcs(167, "Finished Watching Game!  At Stage" + var8 + "", 255, 161, 85, 3);
         this.drawcs(184, "" + var1.name + "", 255, 115, 0, 3);
         var7 = 184;
      }

      if (this.winner && this.multion == 0 && this.gmode != 0 && (var1.stage == this.unlocked[this.gmode - 1] + (this.gmode - 1) * 10 || var1.stage == 27)) {
         byte var12 = 0;
         short var10 = 0;
         this.pin = 60;
         if (this.gmode == 1) {
            if (var1.stage == 2) {
               var12 = 5;
               var10 = 365;
               this.pin = -20;
               this.scm[0] = 5;
            }

            if (var1.stage == 4) {
               var12 = 6;
               var10 = 320;
               this.pin = -20;
               this.scm[0] = 6;
            }

            if (var1.stage == 6) {
               var12 = 11;
               var10 = 326;
               this.pin = -20;
               this.scm[0] = 11;
            }

            if (var1.stage == 8) {
               var12 = 14;
               var10 = 350;
               this.pin = -20;
               this.scm[0] = 14;
            }

            if (var1.stage == 10) {
               var12 = 15;
               var10 = 370;
               this.pin = -20;
               this.scm[0] = 15;
            }
         }

         if (this.gmode == 2) {
            if (var1.stage == 12) {
               var12 = 8;
               var10 = 365;
               this.pin = -20;
               this.scm[1] = 8;
            }

            if (var1.stage == 14) {
               var12 = 9;
               var10 = 320;
               this.pin = -20;
               this.scm[1] = 9;
            }

            if (var1.stage == 16) {
               var12 = 10;
               var10 = 370;
               this.pin = -20;
               this.scm[1] = 10;
            }

            if (var1.stage == 18) {
               var12 = 11;
               var10 = 326;
               this.pin = -20;
               this.scm[1] = 11;
            }

            if (var1.stage == 20) {
               var12 = 12;
               var10 = 310;
               this.pin = -20;
               this.scm[1] = 12;
            }

            if (var1.stage == 22) {
               var12 = 13;
               var10 = 310;
               this.pin = -20;
               this.scm[1] = 13;
            }

            if (var1.stage == 24) {
               var12 = 14;
               var10 = 350;
               this.pin = -20;
               this.scm[1] = 14;
            }

            if (var1.stage == 26) {
               var12 = 15;
               var10 = 370;
               this.pin = -20;
               this.scm[1] = 15;
            }
         }

         if (var1.stage != 27) {
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            if (this.aflk) {
               this.drawcs(200 + this.pin, "Stage " + (var1.stage + 1 - (this.gmode - 1) * 10) + " is now unlocked!", 196, 176, 0, 3);
            } else {
               this.drawcs(200 + this.pin, "Stage " + (var1.stage + 1 - (this.gmode - 1) * 10) + " is now unlocked!", 255, 247, 165, 3);
            }

            if (var12 != 0) {
               if (this.aflk) {
                  this.drawcs(200, "And:", 196, 176, 0, 3);
               } else {
                  this.drawcs(200, "And:", 255, 247, 165, 3);
               }

               this.rd.setColor(new Color(236, 226, 202));
               if (Math.random() > 0.5) {
                  this.rd.setComposite(AlphaComposite.getInstance(3, 0.5F));
                  this.rd.fillRect(226, 211, 344, 125);
                  this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
               }

               this.rd.setColor(new Color(0, 0, 0));
               this.rd.fillRect(226, 211, 348, 4);
               this.rd.fillRect(226, 211, 4, 125);
               this.rd.fillRect(226, 332, 348, 4);
               this.rd.fillRect(570, 211, 4, 125);
               var2[var12].y = var10;
               this.m.crs = true;
               this.m.x = -400;
               this.m.y = 0;
               this.m.z = -50;
               this.m.xz = 0;
               this.m.zy = 0;
               this.m.ground = 2470;
               var2[var12].z = 1000;
               var2[var12].x = 0;
               var2[var12].xz += 5;
               var2[var12].zy = 0;
               var2[var12].wzy -= 10;
               this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
               var2[var12].d(this.rd);
               this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
               if (Math.random() < 0.5) {
                  this.rd.setComposite(AlphaComposite.getInstance(3, 0.4F));
                  this.rd.setColor(new Color(236, 226, 202));

                  for (int var11 = 0; var11 < 30; var11++) {
                     this.rd.drawLine(230, 215 + 4 * var11, 569, 215 + 4 * var11);
                  }

                  this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
               }

               String var15 = "";
               if (var12 == 13) {
                  var15 = " ";
               }

               if (this.aflk) {
                  this.drawcs(320, "" + this.cd.names[var12] + "" + var15 + " has been unlocked!", 196, 176, 0, 3);
               } else {
                  this.drawcs(320, "" + this.cd.names[var12] + "" + var15 + " has been unlocked!", 255, 247, 165, 3);
               }

               this.pin = 140;
            }

            this.rd.setFont(new Font("Arial", 1, 11));
            this.ftm = this.rd.getFontMetrics();
            this.drawcs(220 + this.pin, "GAME SAVED", 230, 167, 0, 3);
            if (this.pin == 60) {
               this.pin = 30;
            } else {
               this.pin = 0;
            }
         } else {
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            if (this.aflk) {
               this.drawcs(180, "Woohoooo you finished NFM" + this.gmode + " !!!", 144, 167, 255, 3);
            } else {
               this.drawcs(180, "Woohoooo you finished NFM" + this.gmode + " !!!", 228, 240, 255, 3);
            }

            if (this.aflk) {
               this.drawcs(210, "You're Awesome!", 144, 167, 255, 3);
            } else {
               this.drawcs(212, "You're Awesome!", 228, 240, 255, 3);
            }

            if (this.aflk) {
               this.drawcs(240, "You're truly a RADICAL GAMER!", 144, 167, 255, 3);
            } else {
               this.drawcs(240, "You're truly a RADICAL GAMER!", 255, 100, 100, 3);
            }

            this.rd.setColor(new Color(0, 0, 0));
            this.rd.fillRect(0, 255, 800, 62);
            this.rd.drawImage(this.radicalplay, this.radpx + (int)(8.0 * Math.random() - 4.0), 255, null);
            if (this.radpx != 212) {
               this.radpx += 40;
               if (this.radpx > 800) {
                  this.radpx = -468;
               }
            }

            if (this.flipo == 40) {
               this.radpx = 213;
            }

            this.flipo++;
            if (this.flipo == 70) {
               this.flipo = 0;
            }

            if (this.radpx == 212) {
               this.rd.setFont(new Font("Arial", 1, 11));
               this.ftm = this.rd.getFontMetrics();
               if (this.aflk) {
                  this.drawcs(309, "A Game by Radicalplay.com", 144, 167, 255, 3);
               } else {
                  this.drawcs(309, "A Game by Radicalplay.com", 228, 240, 255, 3);
               }
            }

            if (this.aflk) {
               this.drawcs(350, "Now get up and dance!", 144, 167, 255, 3);
            } else {
               this.drawcs(350, "Now get up and dance!", 228, 240, 255, 3);
            }

            this.pin = 0;
         }

         if (this.aflk) {
            this.aflk = false;
         } else {
            this.aflk = true;
         }
      }

      if (this.multion != 0 && var1.stage == -2 && var7 != 0) {
         this.drawcs(var7 + 17, "Created by: " + var1.maker + "", 255, 161, 85, 3);
         if (var1.pubt > 0) {
            if (var1.pubt == 2) {
               this.drawcs(310, "Super Public Stage", 41, 177, 255, 3);
            } else {
               this.drawcs(310, "Public Stage", 41, 177, 255, 3);
            }

            if (this.dnload == 0 && this.drawcarb(true, null, " Add to My Stages ", 334, 317, var4, var5, var6)) {
               if (this.logged) {
                  this.cd.onstage = var1.name;
                  this.cd.staction = 2;
                  this.cd.sparkstageaction();
                  this.dnload = 2;
               } else {
                  this.dnload = 1;
                  this.waitlink = 20;
               }
            }

            if (this.dnload == 1) {
               this.rd.setColor(new Color(193, 106, 0));
               String var13 = "Upgrade to a full account to add custom stages!";
               int var14 = 400 - this.ftm.stringWidth(var13) / 2;
               int var16 = var14 + this.ftm.stringWidth(var13);
               this.rd.drawString(var13, var14, 332);
               if (this.waitlink != -1) {
                  this.rd.drawLine(var14, 334, var16, 334);
               }

               if (var4 > var14 && var4 < var16 && var5 > 321 && var5 < 334) {
                  if (this.waitlink != -1) {
                     this.app.setCursor(new Cursor(12));
                  }

                  if (var6 && this.waitlink == 0) {
                     this.app.editlink(this.nickname, true);
                     this.waitlink = -1;
                  }
               } else {
                  this.app.setCursor(new Cursor(0));
               }

               if (this.waitlink > 0) {
                  this.waitlink--;
               }
            }

            if (this.dnload == 2) {
               this.drawcs(332, "Adding stage please wait...", 193, 106, 0, 3);
               if (this.cd.staction == 0) {
                  this.dnload = 3;
               }

               if (this.cd.staction == -2) {
                  this.dnload = 4;
               }

               if (this.cd.staction == -3) {
                  this.dnload = 5;
               }

               if (this.cd.staction == -1) {
                  this.dnload = 6;
               }
            }

            if (this.dnload == 3) {
               this.drawcs(332, "Stager has been successfully added to your stages!", 193, 106, 0, 3);
            }

            if (this.dnload == 4) {
               this.drawcs(332, "You already have this stage!", 193, 106, 0, 3);
            }

            if (this.dnload == 5) {
               this.drawcs(332, "Cannot add more then 20 stages to your account!", 193, 106, 0, 3);
            }

            if (this.dnload == 6) {
               this.drawcs(332, "Failed to add stage, unknown error, please try again later.", 193, 106, 0, 3);
            }
         } else {
            this.drawcs(342, "Private Stage", 193, 106, 0, 3);
         }
      }

      this.rd.drawImage(this.contin[this.pcontin], 355, 380, null);
      if (var3.enter || var3.handb) {
         if (this.loadedt) {
            this.strack.unload();
         }

         if (this.multion == 0) {
            this.opselect = 3;
            if (this.gmode == 1) {
               this.opselect = 0;
               if (this.winner && var1.stage == this.unlocked[this.gmode - 1] + (this.gmode - 1) * 10 && var1.stage != 27) {
                  this.unlocked[this.gmode - 1]++;
                  this.justwon1 = true;
               } else {
                  this.justwon1 = false;
               }
            }

            if (this.gmode == 2) {
               this.opselect = 1;
               if (this.winner && var1.stage == this.unlocked[this.gmode - 1] + (this.gmode - 1) * 10 && var1.stage != 27) {
                  this.unlocked[this.gmode - 1]++;
                  this.justwon2 = true;
               } else {
                  this.justwon2 = false;
               }
            }

            if (var1.stage == 27 && this.gmode == 0) {
               var1.stage = (int)(Math.random() * 27.0) + 1;
            }

            this.fase = 102;
         } else if (this.cd.haltload == 1) {
            this.sc[0] = 36;
            this.fase = 1177;
         } else if (this.mtop && (this.nfreeplays < 5 || this.logged)) {
            this.fase = -9;
         } else {
            this.opselect = 2;
            this.fase = 102;
         }

         if (this.multion == 0 && this.winner && var1.stage != 27 && var1.stage > 0) {
            var1.stage++;
         }

         if (!this.winner && this.multion != 0 && (this.forstart == 700 || this.discon == 240) && this.ndisco < 5) {
            this.ndisco++;
         }

         this.flipo = 0;
         var3.enter = false;
         var3.handb = false;
      }
   }

   public void sortcars(int var1) {
      if (var1 != 0) {
         for (int var2 = 1; var2 < 7; var2++) {
            this.sc[var2] = -1;
         }

         boolean[] var11 = new boolean[7];
         if (var1 < 0) {
            var1 = 27;
         }

         byte var3 = 7;
         if (this.gmode == 1) {
            var3 = 5;
         }

         boolean var4 = false;
         if (var1 <= 10) {
            byte var5 = 6;
            if (this.gmode == 1) {
               var5 = 4;
            }

            if ((var1 == 1 || var1 == 2) && this.sc[0] != 5) {
               this.sc[var5] = 5;
               var3 = var5;
            }

            if ((var1 == 3 || var1 == 4) && this.sc[0] != 6) {
               this.sc[var5] = 6;
               var3 = var5;
            }

            if ((var1 == 5 || var1 == 6) && this.sc[0] != 11) {
               this.sc[var5] = 11;
               var3 = var5;
            }

            if ((var1 == 7 || var1 == 8) && this.sc[0] != 14) {
               this.sc[var5] = 14;
               var3 = var5;
            }

            if ((var1 == 9 || var1 == 10) && this.sc[0] != 15) {
               this.sc[var5] = 15;
               var3 = var5;
            }
         } else {
            var1 -= 10;
            var4 = true;
            if (this.sc[0] != 7 + (var1 + 1) / 2 && var1 != 17) {
               this.sc[6] = 7 + (var1 + 1) / 2;
               var3 = 6;
            }
         }

         int var12 = 16;
         int var6 = 1;
         int var7 = 2;

         for (int var8 = 1; var8 < var3; var8++) {
            var11[var8] = false;

            while (!var11[var8]) {
               float var9 = 10.0F;
               if (var4) {
                  var9 = 17.0F;
               }

               this.sc[var8] = (int)(Math.random() * (24.0F + 8.0F * (var1 / var9)));
               if (this.sc[var8] >= 16) {
                  this.sc[var8] = this.sc[var8] - 16;
               }

               var11[var8] = true;

               for (int var10 = 0; var10 < 7; var10++) {
                  if (var8 != var10 && this.sc[var8] == this.sc[var10]) {
                     var11[var8] = false;
                  }
               }

               if (var4) {
                  var9 = 16.0F;
               }

               float var35 = (15 - this.sc[var8]) / 15.0F * (var1 / var9);
               if (var35 > 0.8) {
                  var35 = 0.8F;
               }

               if (var1 == 17 && var35 > 0.5) {
                  var35 = 0.5F;
               }

               if (var35 > Math.random()) {
                  var11[var8] = false;
               }

               if (this.gmode == 1) {
                  if (this.sc[var8] >= 7 && this.sc[var8] <= 10) {
                     var11[var8] = false;
                  }

                  if (this.sc[var8] == 12 || this.sc[var8] == 13) {
                     var11[var8] = false;
                  }

                  if (this.sc[var8] > 5 && this.unlocked[0] <= 2) {
                     var11[var8] = false;
                  }

                  if (this.sc[var8] > 6 && this.unlocked[0] <= 4) {
                     var11[var8] = false;
                  }

                  if (this.sc[var8] > 11 && this.unlocked[0] <= 6) {
                     var11[var8] = false;
                  }

                  if (this.sc[var8] > 14 && this.unlocked[0] <= 8) {
                     var11[var8] = false;
                  }
               }

               if (this.gmode == 2) {
                  if ((this.sc[var8] - 7) * 2 > this.unlocked[1]) {
                     var11[var8] = false;
                  }

                  if (var1 == 16 && this.unlocked[1] == 16 && this.sc[var8] < 9) {
                     var11[var8] = false;
                  }
               }
            }

            if (this.sc[var8] < var12) {
               var12 = this.sc[var8];
               if (var6 != var8) {
                  var7 = var6;
                  var6 = var8;
               }
            }
         }

         if (!var4 && var1 == 10) {
            boolean var13 = false;

            for (int var24 = 0; var24 < 7; var24++) {
               if (this.sc[var24] == 11) {
                  var13 = true;
               }
            }

            if (!var13 && (Math.random() > Math.random() || this.gmode != 0)) {
               this.sc[var6] = 11;
            }

            var13 = false;

            for (int var25 = 0; var25 < 7; var25++) {
               if (this.sc[var25] == 14) {
                  var13 = true;
               }
            }

            if (!var13 && (Math.random() > Math.random() || this.gmode != 0)) {
               this.sc[var7] = 14;
            }
         }

         if (var1 == 12) {
            boolean var15 = false;

            for (int var26 = 0; var26 < 7; var26++) {
               if (this.sc[var26] == 11) {
                  var15 = true;
               }
            }

            if (!var15) {
               this.sc[var6] = 11;
            }
         }

         if (var1 == 14) {
            boolean var16 = false;

            for (int var27 = 0; var27 < 7; var27++) {
               if (this.sc[var27] == 12) {
                  var16 = true;
               }
            }

            if (!var16 && (Math.random() > Math.random() || this.gmode != 0)) {
               this.sc[var6] = 12;
            }

            var16 = false;

            for (int var28 = 0; var28 < 7; var28++) {
               if (this.sc[var28] == 10) {
                  var16 = true;
               }
            }

            if (!var16 && (Math.random() > Math.random() || this.gmode != 0)) {
               this.sc[var7] = 10;
            }
         }

         if (var1 == 15) {
            boolean var18 = false;

            for (int var29 = 0; var29 < 7; var29++) {
               if (this.sc[var29] == 11) {
                  var18 = true;
               }
            }

            if (!var18 && (Math.random() > Math.random() || this.gmode != 0)) {
               this.sc[var6] = 11;
            }

            var18 = false;

            for (int var30 = 0; var30 < 7; var30++) {
               if (this.sc[var30] == 13) {
                  var18 = true;
               }
            }

            if (!var18 && (Math.random() > Math.random() || this.gmode != 0)) {
               this.sc[var7] = 13;
            }
         }

         if (var1 == 16) {
            boolean var20 = false;

            for (int var31 = 0; var31 < 7; var31++) {
               if (this.sc[var31] == 13) {
                  var20 = true;
               }
            }

            if (!var20 && (Math.random() > Math.random() || this.gmode != 0)) {
               this.sc[var6] = 13;
            }

            var20 = false;

            for (int var32 = 0; var32 < 7; var32++) {
               if (this.sc[var32] == 12) {
                  var20 = true;
               }
            }

            if (!var20 && (Math.random() > Math.random() || this.gmode != 0)) {
               this.sc[var7] = 12;
            }
         }

         if (this.cd.lastload == 1) {
            int var22 = 0;

            for (int var33 = 0; var33 < this.cd.nlcars - 16; var33++) {
               if (var22 == 0) {
                  for (int var36 = 1; var36 < var3; var36++) {
                     var11[var36] = false;
                  }
               }

               if (this.cd.include[var33] && this.sc[0] != var33 + 16) {
                  int var37 = (int)(1.0 + Math.random() * (var3 - 1));

                  while (var11[var37]) {
                     var37 = (int)(1.0 + Math.random() * (var3 - 1));
                  }

                  var11[var37] = true;
                  this.sc[var37] = var33 + 16;
                  if (++var22 == var3 - 1) {
                     var22 = 0;
                  }
               }
            }
         }

         if (this.cd.lastload == 2) {
            int var23 = 0;

            for (int var34 = 0; var34 < this.cd.nlocars - 16; var34++) {
               if (var23 == 0) {
                  for (int var38 = 1; var38 < var3; var38++) {
                     var11[var38] = false;
                  }
               }

               if (this.cd.include[var34] && this.sc[0] != var34 + 16) {
                  int var39 = (int)(1.0 + Math.random() * (var3 - 1));

                  while (var11[var39]) {
                     var39 = (int)(1.0 + Math.random() * (var3 - 1));
                  }

                  var11[var39] = true;
                  this.sc[var39] = var34 + 16;
                  if (++var23 == var3 - 1) {
                     var23 = 0;
                  }
               }
            }
         }
      }
   }

   public void ctachm(int var1, int var2, int var3, Control var4) {
      if (this.fase == 1) {
         if (var3 == 1) {
            if (this.over(this.next[0], var1, var2, 625, 135)) {
               this.pnext = 1;
            }

            if (this.over(this.back[0], var1, var2, 115, 135)) {
               this.pback = 1;
            }

            if (this.over(this.contin[0], var1, var2, 355, 360)) {
               this.pcontin = 1;
            }
         }

         if (var3 == 2) {
            if (this.pnext == 1) {
               var4.right = true;
            }

            if (this.pback == 1) {
               var4.left = true;
            }

            if (this.pcontin == 1) {
               var4.enter = true;
            }
         }
      }

      if (this.fase == 3) {
         if (var3 == 1 && this.over(this.contin[0], var1, var2, 355, 350)) {
            this.pcontin = 1;
         }

         if (var3 == 2 && this.pcontin == 1) {
            var4.enter = true;
            this.pcontin = 0;
         }
      }

      if (this.fase == 4) {
         if (var3 == 1 && this.over(this.back[0], var1, var2, 370, 345)) {
            this.pback = 1;
         }

         if (var3 == 2 && this.pback == 1) {
            var4.enter = true;
            this.pback = 0;
         }
      }

      if (this.fase == 6) {
         if (var3 == 1 && (this.over(this.star[0], var1, var2, 359, 385) || this.over(this.star[0], var1, var2, 359, 295))) {
            this.pstar = 2;
         }

         if (var3 == 2 && this.pstar == 2) {
            var4.enter = true;
            this.pstar = 1;
         }
      }

      if (this.fase == 7) {
         if (var3 == 1) {
            if (this.over(this.next[0], var1, var2, 645, 275)) {
               this.pnext = 1;
            }

            if (this.over(this.back[0], var1, var2, 95, 275)) {
               this.pback = 1;
            }

            if (this.over(this.contin[0], var1, var2, 355, 385) && !this.app.openm) {
               this.pcontin = 1;
            }
         }

         if (var3 == 2) {
            if (this.pnext == 1) {
               var4.right = true;
            }

            if (this.pback == 1) {
               var4.left = true;
            }

            if (this.pcontin == 1) {
               var4.enter = true;
               this.pcontin = 0;
            }
         }
      }

      if (this.fase == -5) {
         this.lxm = var1;
         this.lym = var2;
         if (var3 == 1 && this.over(this.contin[0], var1, var2, 355, 380)) {
            this.pcontin = 1;
         }

         if (var3 == 2 && this.pcontin == 1) {
            var4.enter = true;
            this.pcontin = 0;
         }
      }

      if (this.fase == -7) {
         if (var3 == 1) {
            if (this.overon(329, 45, 137, 22, var1, var2)) {
               this.opselect = 0;
               this.shaded = true;
            }

            if (this.overon(320, 73, 155, 22, var1, var2)) {
               this.opselect = 1;
               this.shaded = true;
            }

            if (this.overon(303, 99, 190, 22, var1, var2)) {
               this.opselect = 2;
               this.shaded = true;
            }

            if (this.overon(341, 125, 109, 22, var1, var2)) {
               this.opselect = 3;
               this.shaded = true;
            }
         }

         if (var3 == 2 && this.shaded) {
            var4.enter = true;
            this.shaded = false;
         }

         if (var3 == 0 && (var1 != this.lxm || var2 != this.lym)) {
            if (this.overon(329, 45, 137, 22, var1, var2)) {
               this.opselect = 0;
            }

            if (this.overon(320, 73, 155, 22, var1, var2)) {
               this.opselect = 1;
            }

            if (this.overon(303, 99, 190, 22, var1, var2)) {
               this.opselect = 2;
            }

            if (this.overon(341, 125, 109, 22, var1, var2)) {
               this.opselect = 3;
            }

            this.lxm = var1;
            this.lym = var2;
         }
      }

      if (this.fase == 10) {
         if (var3 == 1) {
            if (this.overon(343, 261, 110, 22, var1, var2)) {
               this.opselect = 0;
               this.shaded = true;
            }

            if (this.overon(288, 291, 221, 22, var1, var2)) {
               this.opselect = 1;
               this.shaded = true;
            }

            if (this.overon(301, 321, 196, 22, var1, var2)) {
               this.opselect = 2;
               this.shaded = true;
            }

            if (this.overon(357, 351, 85, 22, var1, var2)) {
               this.opselect = 3;
               this.shaded = true;
            }
         }

         if (var3 == 2 && this.shaded) {
            var4.enter = true;
            this.shaded = false;
         }

         if (var3 == 0 && (var1 != this.lxm || var2 != this.lym)) {
            if (this.overon(343, 261, 110, 22, var1, var2)) {
               this.opselect = 0;
            }

            if (this.overon(288, 291, 221, 22, var1, var2)) {
               this.opselect = 1;
            }

            if (this.overon(301, 321, 196, 22, var1, var2)) {
               this.opselect = 2;
            }

            if (this.overon(357, 351, 85, 22, var1, var2)) {
               this.opselect = 3;
            }

            this.lxm = var1;
            this.lym = var2;
         }
      }

      if (this.fase == 102) {
         if (var3 == 1) {
            if (this.overon(358, 262 + this.dropf, 82, 22, var1, var2)) {
               this.opselect = 0;
               this.shaded = true;
            }

            if (this.overon(358, 290 + this.dropf, 82, 22, var1, var2)) {
               this.opselect = 1;
               this.shaded = true;
            }

            if (this.overon(333, 318 + this.dropf, 132, 22, var1, var2)) {
               this.opselect = 2;
               this.shaded = true;
            }

            if (this.dropf == 0 && this.overon(348, 346, 102, 22, var1, var2)) {
               this.opselect = 3;
               this.shaded = true;
            }
         }

         if (var3 == 2 && this.shaded) {
            var4.enter = true;
            this.shaded = false;
         }

         if (var3 == 0 && (var1 != this.lxm || var2 != this.lym)) {
            if (this.overon(358, 262 + this.dropf, 82, 22, var1, var2)) {
               this.opselect = 0;
            }

            if (this.overon(358, 290 + this.dropf, 82, 22, var1, var2)) {
               this.opselect = 1;
            }

            if (this.overon(333, 318 + this.dropf, 132, 22, var1, var2)) {
               this.opselect = 2;
            }

            if (this.dropf == 0 && this.overon(348, 346, 102, 22, var1, var2)) {
               this.opselect = 3;
            }

            this.lxm = var1;
            this.lym = var2;
         }
      }

      if (this.fase == 11) {
         if (this.flipo >= 1 && this.flipo <= 15) {
            if (var3 == 1 && this.over(this.next[0], var1, var2, 665, 395)) {
               this.pnext = 1;
            }

            if (var3 == 2 && this.pnext == 1) {
               var4.right = true;
               this.pnext = 0;
            }
         }

         if (this.flipo >= 3 && this.flipo <= 16) {
            if (var3 == 1 && this.over(this.back[0], var1, var2, 75, 395)) {
               this.pback = 1;
            }

            if (var3 == 2 && this.pback == 1) {
               var4.left = true;
               this.pback = 0;
            }
         }

         if (this.flipo == 16) {
            if (var3 == 1 && this.over(this.contin[0], var1, var2, 565, 395)) {
               this.pcontin = 1;
            }

            if (var3 == 2 && this.pcontin == 1) {
               var4.enter = true;
               this.pcontin = 0;
            }
         }
      }

      if (this.fase == 8) {
         if (var3 == 1 && this.over(this.next[0], var1, var2, 665, 395)) {
            this.pnext = 1;
         }

         if (var3 == 2 && this.pnext == 1) {
            var4.enter = true;
            this.pnext = 0;
         }
      }
   }

   public void stat(Mad var1, ContO var2, CheckPoints var3, Control var4, boolean var5) {
      if (this.holdit) {
         short var6 = 250;
         if (this.fase == 7001) {
            if (this.exitm != 4) {
               this.exitm = 0;
               var6 = 600;
            } else {
               var6 = 1200;
            }
         }

         if (this.exitm != 4 || !this.lan || this.im != 0) {
            this.holdcnt++;
            if ((var4.enter || this.holdcnt > var6) && (var4.chatup == 0 || this.fase != 7001)) {
               this.fase = -2;
               var4.enter = false;
            }
         } else if (var4.enter) {
            var4.enter = false;
         }
      } else {
         if (this.holdcnt != 0) {
            this.holdcnt = 0;
         }

         if (var4.enter || var4.exit) {
            if (this.fase == 0) {
               if (this.loadedt) {
                  this.strack.stop();
               }

               this.fase = -6;
            } else if (this.starcnt == 0 && var4.chatup == 0 && (this.multion < 2 || !this.lan)) {
               if (this.exitm == 0) {
                  this.exitm = 1;
               } else {
                  this.exitm = 0;
               }
            }

            if (var4.chatup == 0 || this.fase != 7001) {
               var4.enter = false;
            }

            var4.exit = false;
         }
      }

      if (this.exitm == 2) {
         this.fase = -2;
         this.winner = false;
      }

      if (this.fase != -2) {
         this.holdit = false;
         if (var3.haltall) {
            var3.haltall = false;
         }

         boolean var12 = false;
         String var7 = "";
         String var8 = "";
         if (this.clangame != 0 && (!var1.dest || this.multion >= 2)) {
            var12 = true;

            for (int var9 = 0; var9 < this.nplayers; var9++) {
               if (var3.dested[var9] == 0) {
                  if (var7.equals("")) {
                     var7 = this.pclan[var9];
                  } else if (!var7.toLowerCase().equals(this.pclan[var9].toLowerCase())) {
                     var12 = false;
                     break;
                  }
               }
            }
         }

         if (this.clangame > 1) {
            boolean var14 = false;
            String var10 = "";
            if (var12) {
               for (int var11 = 0; var11 < this.nplayers; var11++) {
                  if (!var7.toLowerCase().equals(this.pclan[var11].toLowerCase())) {
                     var8 = this.pclan[var11];
                     break;
                  }
               }

               if (this.clangame == 2) {
                  var14 = true;
                  var10 = "Clan " + var8 + " wasted, nobody won becuase this is a racing only game!";
               }

               if (this.clangame == 4 && !var7.toLowerCase().equals(this.gaclan.toLowerCase())) {
                  var14 = true;
                  var10 = "Clan " + var8 + " wasted, nobody won becuase " + var7 + " should have raced in this racing vs wasting game!";
               }

               if (this.clangame == 5 && var7.toLowerCase().equals(this.gaclan.toLowerCase())) {
                  var14 = true;
                  var10 = "Clan " + var8 + " wasted, nobody won becuase " + var7 + " should have raced in this racing vs wasting game!";
               }
            }

            for (int var29 = 0; var29 < this.nplayers; var29++) {
               if (var3.clear[var29] == var3.nlaps * var3.nsp && var3.pos[var29] == 0) {
                  if (this.clangame == 3) {
                     var14 = true;
                     var10 = "" + this.plnames[var29] + " of clan " + this.pclan[var29] + " finished first, nobody won becuase this is a wasting only game!";
                  }

                  if (this.clangame == 4 && this.pclan[var29].toLowerCase().equals(this.gaclan.toLowerCase())) {
                     var14 = true;
                     var10 = ""
                        + this.plnames[var29]
                        + " of clan "
                        + this.pclan[var29]
                        + " finished first, nobody won becuase "
                        + this.pclan[var29]
                        + " should have wasted in this racing vs wasting game!";
                  }

                  if (this.clangame == 5 && !this.pclan[var29].toLowerCase().equals(this.gaclan.toLowerCase())) {
                     var14 = true;
                     var10 = ""
                        + this.plnames[var29]
                        + " of clan "
                        + this.pclan[var29]
                        + " finished first, nobody won becuase "
                        + this.pclan[var29]
                        + " should have wasted in this racing vs wasting game!";
                  }
               }
            }

            if (var14) {
               this.drawhi(this.gamefinished, 70);
               if (this.aflk) {
                  this.drawcs(120, var10, 0, 0, 0, 0);
                  this.aflk = false;
               } else {
                  this.drawcs(120, var10, 0, 128, 255, 0);
                  this.aflk = true;
               }

               this.drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
               var3.haltall = true;
               this.holdit = true;
               this.winner = false;
            }
         }

         if (this.multion < 2) {
            if (!this.holdit && (var3.wasted == this.nplayers - 1 && this.nplayers != 1 || var12)) {
               this.drawhi(this.youwastedem, 70);
               if (!var12) {
                  if (this.aflk) {
                     this.drawcs(120, "You Won, all cars have been wasted!", 0, 0, 0, 0);
                     this.aflk = false;
                  } else {
                     this.drawcs(120, "You Won, all cars have been wasted!", 0, 128, 255, 0);
                     this.aflk = true;
                  }
               } else if (this.aflk) {
                  this.drawcs(120, "Your clan " + var7 + " has wasted all the cars!", 0, 0, 0, 0);
                  this.aflk = false;
               } else {
                  this.drawcs(120, "Your clan " + var7 + " has wasted all the cars!", 0, 128, 255, 0);
                  this.aflk = true;
               }

               this.drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
               var3.haltall = true;
               this.holdit = true;
               this.winner = true;
            }

            if (!this.holdit && var1.dest && this.cntwis == 8) {
               if (this.discon != 240) {
                  this.drawhi(this.yourwasted, 70);
               } else {
                  this.drawhi(this.disco, 70);
                  this.stopchat();
               }

               boolean var17 = false;
               if (this.lan) {
                  var17 = true;

                  for (int var26 = 0; var26 < this.nplayers; var26++) {
                     if (var26 != this.im && this.dested[var26] == 0 && this.plnames[var26].indexOf("MadBot") == -1) {
                        var17 = false;
                     }
                  }
               }

               if (this.fase == 7001 && this.nplayers - (var3.wasted + 1) >= 2 && this.discon != 240 && !var17) {
                  this.exitm = 4;
               } else {
                  if (this.exitm == 4) {
                     this.exitm = 0;
                  }

                  this.drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
               }

               this.holdit = true;
               this.winner = false;
            }

            if (!this.holdit) {
               for (int var18 = 0; var18 < this.nplayers; var18++) {
                  if (var3.clear[var18] == var3.nlaps * var3.nsp && var3.pos[var18] == 0) {
                     if (this.clangame == 0) {
                        if (var18 == this.im) {
                           this.drawhi(this.youwon, 70);
                           if (this.aflk) {
                              this.drawcs(120, "You finished first, nice job!", 0, 0, 0, 0);
                              this.aflk = false;
                           } else {
                              this.drawcs(120, "You finished first, nice job!", 0, 128, 255, 0);
                              this.aflk = true;
                           }

                           this.winner = true;
                        } else {
                           this.drawhi(this.youlost, 70);
                           if (this.fase != 7001) {
                              if (this.aflk) {
                                 this.drawcs(120, "" + this.cd.names[this.sc[var18]] + " finished first, race over!", 0, 0, 0, 0);
                                 this.aflk = false;
                              } else {
                                 this.drawcs(120, "" + this.cd.names[this.sc[var18]] + " finished first, race over!", 0, 128, 255, 0);
                                 this.aflk = true;
                              }
                           } else if (this.aflk) {
                              this.drawcs(120, "" + this.plnames[var18] + " finished first, race over!", 0, 0, 0, 0);
                              this.aflk = false;
                           } else {
                              this.drawcs(120, "" + this.plnames[var18] + " finished first, race over!", 0, 128, 255, 0);
                              this.aflk = true;
                           }

                           this.winner = false;
                        }
                     } else if (this.pclan[var18].toLowerCase().equals(this.pclan[this.im].toLowerCase())) {
                        this.drawhi(this.youwon, 70);
                        if (this.aflk) {
                           this.drawcs(120, "Your clan " + this.pclan[this.im] + " finished first, nice job!", 0, 0, 0, 0);
                           this.aflk = false;
                        } else {
                           this.drawcs(120, "Your clan " + this.pclan[this.im] + " finished first, nice job!", 0, 128, 255, 0);
                           this.aflk = true;
                        }

                        this.winner = true;
                     } else {
                        this.drawhi(this.youlost, 70);
                        if (this.aflk) {
                           this.drawcs(120, "" + this.plnames[var18] + " of clan " + this.pclan[var18] + " finished first, race over!", 0, 0, 0, 0);
                           this.aflk = false;
                        } else {
                           this.drawcs(120, "" + this.plnames[var18] + " of clan " + this.pclan[var18] + " finished first, race over!", 0, 128, 255, 0);
                           this.aflk = true;
                        }

                        this.winner = false;
                     }

                     this.drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
                     var3.haltall = true;
                     this.holdit = true;
                  }
               }
            }
         } else {
            if (!this.holdit && (var3.wasted >= this.nplayers - 1 || var12)) {
               String var15 = "Someone";
               if (!var12) {
                  for (int var25 = 0; var25 < this.nplayers; var25++) {
                     if (var3.dested[var25] == 0) {
                        var15 = this.plnames[var25];
                     }
                  }
               } else {
                  var15 = "Clan " + var7 + "";
               }

               this.drawhi(this.gamefinished, 70);
               if (this.aflk) {
                  this.drawcs(120, "" + var15 + " has wasted all the cars!", 0, 0, 0, 0);
                  this.aflk = false;
               } else {
                  this.drawcs(120, "" + var15 + " has wasted all the cars!", 0, 128, 255, 0);
                  this.aflk = true;
               }

               this.drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
               var3.haltall = true;
               this.holdit = true;
               this.winner = false;
            }

            if (!this.holdit) {
               for (int var16 = 0; var16 < this.nplayers; var16++) {
                  if (var3.clear[var16] == var3.nlaps * var3.nsp && var3.pos[var16] == 0) {
                     this.drawhi(this.gamefinished, 70);
                     if (this.clangame == 0) {
                        if (this.aflk) {
                           this.drawcs(120, "" + this.plnames[var16] + " finished first, race over!", 0, 0, 0, 0);
                           this.aflk = false;
                        } else {
                           this.drawcs(120, "" + this.plnames[var16] + " finished first, race over!", 0, 128, 255, 0);
                           this.aflk = true;
                        }
                     } else if (this.aflk) {
                        this.drawcs(120, "Clan " + this.pclan[var16] + " finished first, race over!", 0, 0, 0, 0);
                        this.aflk = false;
                     } else {
                        this.drawcs(120, "Clan " + this.pclan[var16] + " finished first, race over!", 0, 128, 255, 0);
                        this.aflk = true;
                     }

                     this.drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
                     var3.haltall = true;
                     this.holdit = true;
                     this.winner = false;
                  }
               }
            }

            if (!this.holdit && this.discon == 240) {
               this.drawhi(this.gamefinished, 70);
               if (this.aflk) {
                  this.drawcs(120, "Game got disconnected!", 0, 0, 0, 0);
                  this.aflk = false;
               } else {
                  this.drawcs(120, "Game got disconnected!", 0, 128, 255, 0);
                  this.aflk = true;
               }

               this.drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
               var3.haltall = true;
               this.holdit = true;
               this.winner = false;
            }

            if (!this.holdit) {
               this.rd.drawImage(this.wgame, 311, 20, null);
               if (!this.clanchat) {
                  this.drawcs(397, "Click any player on the right to follow!", 0, 0, 0, 0);
                  if (!this.lan) {
                     this.drawcs(412, "Press [V] to change view.  Press [Enter] to exit.", 0, 0, 0, 0);
                  } else {
                     this.drawcs(412, "Press [V] to change view.", 0, 0, 0, 0);
                  }
               }
            }
         }

         if (var5) {
            if (var3.stage != 10 && this.multion < 2 && this.nplayers != 1 && this.arrace != var4.arrace) {
               this.arrace = var4.arrace;
               if (this.multion == 1 && this.arrace) {
                  var4.radar = true;
               }

               if (this.arrace) {
                  this.wasay = true;
                  this.say = " Arrow now pointing at >  CARS";
                  if (this.multion == 1) {
                     this.say = this.say + "    Press [S] to toggle Radar!";
                  }

                  this.tcnt = -5;
               }

               if (!this.arrace) {
                  this.wasay = false;
                  this.say = " Arrow now pointing at >  TRACK";
                  if (this.multion == 1) {
                     this.say = this.say + "    Press [S] to toggle Radar!";
                  }

                  this.tcnt = -5;
                  this.cntan = 20;
                  this.alocked = -1;
                  this.alocked = -1;
               }
            }

            if (!this.holdit && this.fase != -6 && this.starcnt == 0 && this.multion < 2 && var3.stage != 10) {
               this.arrow(var1.point, var1.missedcp, var3, this.arrace);
               if (!this.arrace) {
                  if (this.auscnt == 45 && var1.capcnt == 0 && this.exitm == 0) {
                     if (var1.missedcp > 0) {
                        if (var1.missedcp > 15 && var1.missedcp < 50) {
                           if (this.flk) {
                              this.drawcs(70, "Checkpoint Missed!", 255, 0, 0, 0);
                           } else {
                              this.drawcs(70, "Checkpoint Missed!", 255, 150, 0, 2);
                           }
                        }

                        var1.missedcp++;
                        if (var1.missedcp == 70) {
                           var1.missedcp = -2;
                        }
                     } else if (var1.mtouch && this.cntovn < 70) {
                        if (Math.abs(this.ana) > 100) {
                           this.cntan++;
                        } else if (this.cntan != 0) {
                           this.cntan--;
                        }

                        if (this.cntan > 40) {
                           this.cntovn++;
                           this.cntan = 40;
                           if (this.flk) {
                              this.drawcs(70, "Wrong Way!", 255, 150, 0, 0);
                              this.flk = false;
                           } else {
                              this.drawcs(70, "Wrong Way!", 255, 0, 0, 2);
                              this.flk = true;
                           }
                        }
                     }
                  }
               } else if (this.alocked != this.lalocked) {
                  if (this.alocked != -1) {
                     this.wasay = true;
                     this.say = " Arrow Locked on >  " + this.plnames[this.alocked] + "";
                     this.tcnt = -5;
                  } else {
                     this.wasay = true;
                     this.say = "Arrow Unlocked!";
                     this.tcnt = 10;
                  }

                  this.lalocked = this.alocked;
               }
            }

            if (this.m.darksky) {
               new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]);
               float[] var27 = new float[3];
               Color.RGBtoHSB(this.m.csky[0], this.m.csky[1], this.m.csky[2], var27);
               var27[2] = 0.6F;
               Color var19 = Color.getHSBColor(var27[0], var27[1], var27[2]);
               this.rd.setColor(var19);
               this.rd.fillRect(602, 9, 54, 14);
               this.rd.drawLine(601, 10, 601, 21);
               this.rd.drawLine(600, 12, 600, 19);
               this.rd.fillRect(607, 29, 49, 14);
               this.rd.drawLine(606, 30, 606, 41);
               this.rd.drawLine(605, 32, 605, 39);
               this.rd.fillRect(18, 6, 155, 14);
               this.rd.drawLine(17, 7, 17, 18);
               this.rd.drawLine(16, 9, 16, 16);
               this.rd.drawLine(173, 7, 173, 18);
               this.rd.drawLine(174, 9, 174, 16);
               this.rd.fillRect(40, 26, 107, 21);
               this.rd.drawLine(39, 27, 39, 45);
               this.rd.drawLine(38, 29, 38, 43);
               this.rd.drawLine(147, 27, 147, 45);
               this.rd.drawLine(148, 29, 148, 43);
            }

            this.rd.drawImage(this.dmg, 600, 7, null);
            this.rd.drawImage(this.pwr, 600, 27, null);
            this.rd.drawImage(this.lap, 19, 7, null);
            this.rd.setColor(new Color(0, 0, 100));
            this.rd.drawString("" + (var1.nlaps + 1) + " / " + var3.nlaps + "", 51, 18);
            this.rd.drawImage(this.was, 92, 7, null);
            this.rd.setColor(new Color(0, 0, 100));
            this.rd.drawString("" + var3.wasted + " / " + (this.nplayers - 1) + "", 150, 18);
            this.rd.drawImage(this.pos, 42, 27, null);
            this.rd.drawImage(this.rank[var3.pos[var1.im]], 110, 28, null);
            this.drawstat(this.cd.maxmag[var1.cn], var1.hitmag, var1.newcar, var1.power);
            if (var4.radar && var3.stage != 10) {
               this.radarstat(var1, var2, var3);
            }
         }

         if (!this.holdit) {
            if (this.starcnt != 0 && this.starcnt <= 35) {
               if (this.starcnt == 35 && !this.mutes) {
                  this.three.play();
               }

               if (this.starcnt == 24) {
                  this.gocnt = 2;
                  if (!this.mutes) {
                     this.two.play();
                  }
               }

               if (this.starcnt == 13) {
                  this.gocnt = 1;
                  if (!this.mutes) {
                     this.one.play();
                  }
               }

               if (this.starcnt == 2) {
                  this.gocnt = 0;
                  if (!this.mutes) {
                     this.go.play();
                  }
               }

               this.duds = 0;
               if (this.starcnt <= 37 && this.starcnt > 32) {
                  this.duds = 1;
               }

               if (this.starcnt <= 26 && this.starcnt > 21) {
                  this.duds = 1;
               }

               if (this.starcnt <= 15 && this.starcnt > 10) {
                  this.duds = 1;
               }

               if (this.starcnt <= 4) {
                  this.duds = 2;
               }

               if (this.dudo != -1) {
                  this.rd.setComposite(AlphaComposite.getInstance(3, 0.3F));
                  this.rd.drawImage(this.dude[this.duds], this.dudo, 0, null);
                  this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
               }

               if (this.gocnt != 0) {
                  this.rd.drawImage(this.cntdn[this.gocnt], 385, 50, null);
               } else {
                  this.rd.drawImage(this.cntdn[this.gocnt], 363, 50, null);
               }
            }

            if (this.looped != 0 && var1.loop == 2) {
               this.looped = 0;
            }

            if (var1.power < 45.0F) {
               if (this.tcnt == 30 && this.auscnt == 45 && var1.mtouch && var1.capcnt == 0 && this.exitm == 0) {
                  if (this.looped != 2) {
                     if (this.pwcnt < 70 || this.pwcnt < 100 && this.looped != 0) {
                        if (this.pwflk) {
                           this.drawcs(110, "Power low, perform stunt!", 0, 0, 200, 0);
                           this.pwflk = false;
                        } else {
                           this.drawcs(110, "Power low, perform stunt!", 255, 100, 0, 0);
                           this.pwflk = true;
                        }
                     }
                  } else if (this.pwcnt < 100) {
                     String var20 = "";
                     if (this.multion == 0) {
                        var20 = "  (Press Enter)";
                     }

                     if (this.pwflk) {
                        this.drawcs(110, "Please read the Game Instructions!" + var20 + "", 0, 0, 200, 0);
                        this.pwflk = false;
                     } else {
                        this.drawcs(110, "Please read the Game Instructions!" + var20 + "", 255, 100, 0, 0);
                        this.pwflk = true;
                     }
                  }

                  this.pwcnt++;
                  if (this.pwcnt == 300) {
                     this.pwcnt = 0;
                     if (this.looped != 0) {
                        this.looped++;
                        if (this.looped == 4) {
                           this.looped = 2;
                        }
                     }
                  }
               }
            } else if (this.pwcnt != 0) {
               this.pwcnt = 0;
            }

            if (var1.capcnt == 0) {
               if (this.tcnt < 30) {
                  if (this.exitm == 0) {
                     if (this.tflk) {
                        if (!this.wasay) {
                           this.drawcs(105, this.say, 0, 0, 0, 0);
                        } else {
                           this.drawcs(105, this.say, 0, 0, 0, 0);
                        }

                        this.tflk = false;
                     } else {
                        if (!this.wasay) {
                           this.drawcs(105, this.say, 0, 128, 255, 0);
                        } else {
                           this.drawcs(105, this.say, 255, 128, 0, 0);
                        }

                        this.tflk = true;
                     }
                  }

                  this.tcnt++;
               } else if (this.wasay) {
                  this.wasay = false;
               }

               if (this.auscnt < 45) {
                  if (this.exitm == 0) {
                     if (this.aflk) {
                        this.drawcs(85, this.asay, 98, 176, 255, 0);
                        this.aflk = false;
                     } else {
                        this.drawcs(85, this.asay, 0, 128, 255, 0);
                        this.aflk = true;
                     }
                  }

                  this.auscnt++;
               }
            } else if (this.exitm == 0) {
               if (this.tflk) {
                  this.drawcs(110, "Bad Landing!", 0, 0, 200, 0);
                  this.tflk = false;
               } else {
                  this.drawcs(110, "Bad Landing!", 255, 100, 0, 0);
                  this.tflk = true;
               }
            }

            if (var1.trcnt == 10) {
               this.loop = "";
               this.spin = "";
               this.asay = "";

               int var21;
               for (var21 = 0; var1.travzy > 225; var21++) {
                  var1.travzy -= 360;
               }

               while (var1.travzy < -225) {
                  var1.travzy += 360;
                  var21--;
               }

               if (var21 == 1) {
                  this.loop = "Forward loop";
               }

               if (var21 == 2) {
                  this.loop = "double Forward";
               }

               if (var21 == 3) {
                  this.loop = "triple Forward";
               }

               if (var21 >= 4) {
                  this.loop = "massive Forward looping";
               }

               if (var21 == -1) {
                  this.loop = "Backloop";
               }

               if (var21 == -2) {
                  this.loop = "double Back";
               }

               if (var21 == -3) {
                  this.loop = "triple Back";
               }

               if (var21 <= -4) {
                  this.loop = "massive Back looping";
               }

               if (var21 == 0) {
                  if (var1.ftab && var1.btab) {
                     this.loop = "Tabletop and reversed Tabletop";
                  } else if (var1.ftab || var1.btab) {
                     this.loop = "Tabletop";
                  }
               }

               if (var21 > 0 && var1.btab) {
                  this.loop = "Hanged " + this.loop;
               }

               if (var21 < 0 && var1.ftab) {
                  this.loop = "Hanged " + this.loop;
               }

               if (this.loop != "") {
                  this.asay = this.asay + " " + this.loop;
               }

               var21 = 0;

               for (var1.travxy = Math.abs(var1.travxy); var1.travxy > 270; var21++) {
                  var1.travxy -= 360;
               }

               if (var21 == 0 && var1.rtab) {
                  if (this.loop == "") {
                     this.spin = "Tabletop";
                  } else {
                     this.spin = "Flipside";
                  }
               }

               if (var21 == 1) {
                  this.spin = "Rollspin";
               }

               if (var21 == 2) {
                  this.spin = "double Rollspin";
               }

               if (var21 == 3) {
                  this.spin = "triple Rollspin";
               }

               if (var21 >= 4) {
                  this.spin = "massive Roll spinning";
               }

               var21 = 0;
               boolean var28 = false;
               var1.travxz = Math.abs(var1.travxz);

               while (var1.travxz > 90) {
                  var1.travxz -= 180;
                  var21 += 180;
                  if (var21 > 900) {
                     var21 = 900;
                     var28 = true;
                  }
               }

               if (var21 != 0) {
                  if (this.loop == "" && this.spin == "") {
                     this.asay = this.asay + " " + var21;
                     if (var28) {
                        this.asay = this.asay + " and beyond";
                     }
                  } else {
                     if (this.spin != "") {
                        if (this.loop == "") {
                           this.asay = this.asay + " " + this.spin;
                        } else {
                           this.asay = this.asay + " with " + this.spin;
                        }
                     }

                     this.asay = this.asay + " by " + var21;
                     if (var28) {
                        this.asay = this.asay + " and beyond";
                     }
                  }
               } else if (this.spin != "") {
                  if (this.loop == "") {
                     this.asay = this.asay + " " + this.spin;
                  } else {
                     this.asay = this.asay + " by " + this.spin;
                  }
               }

               if (this.asay != "") {
                  this.auscnt -= 15;
               }

               if (this.loop != "") {
                  this.auscnt -= 25;
               }

               if (this.spin != "") {
                  this.auscnt -= 25;
               }

               if (var21 != 0) {
                  this.auscnt -= 25;
               }

               if (this.auscnt < 45) {
                  if (!this.mutes) {
                     this.powerup.play();
                  }

                  if (this.auscnt < -20) {
                     this.auscnt = -20;
                  }

                  byte var30 = 0;
                  if (var1.powerup > 20.0F) {
                     var30 = 1;
                  }

                  if (var1.powerup > 40.0F) {
                     var30 = 2;
                  }

                  if (var1.powerup > 150.0F) {
                     var30 = 3;
                  }

                  if (var1.surfer) {
                     this.asay = " " + this.adj[4][(int)(this.m.random() * 3.0F)] + this.asay;
                  }

                  if (var30 != 3) {
                     this.asay = this.adj[var30][(int)(this.m.random() * 3.0F)] + this.asay + this.exlm[var30];
                  } else {
                     this.asay = this.adj[var30][(int)(this.m.random() * 3.0F)];
                  }

                  if (!this.wasay) {
                     this.tcnt = this.auscnt;
                     if (var1.power != 98.0F) {
                        this.say = "Power Up " + (int)(100.0F * var1.powerup / 98.0F) + "%";
                     } else {
                        this.say = "Power To The MAX";
                     }

                     if (this.skidup) {
                        this.skidup = false;
                     } else {
                        this.skidup = true;
                     }
                  }
               }
            }

            if (var1.newcar) {
               if (!this.wasay) {
                  this.say = "Car Fixed";
                  this.tcnt = 0;
               }

               if (this.crashup) {
                  this.crashup = false;
               } else {
                  this.crashup = true;
               }
            }

            for (int var24 = 0; var24 < this.nplayers; var24++) {
               if (this.dested[var24] != var3.dested[var24] && var24 != this.im) {
                  this.dested[var24] = var3.dested[var24];
                  if (this.fase != 7001) {
                     if (this.dested[var24] == 1) {
                        this.wasay = true;
                        this.say = "" + this.cd.names[this.sc[var24]] + " has been wasted!";
                        this.tcnt = -15;
                     }

                     if (this.dested[var24] == 2) {
                        this.wasay = true;
                        this.say = "You wasted " + this.cd.names[this.sc[var24]] + "!";
                        this.tcnt = -15;
                     }
                  } else {
                     if (this.dested[var24] == 1) {
                        this.wasay = true;
                        this.say = "" + this.plnames[var24] + " has been wasted!";
                        this.tcnt = -15;
                     }

                     if (this.dested[var24] == 2) {
                        this.wasay = true;
                        if (this.multion < 2) {
                           this.say = "You wasted " + this.plnames[var24] + "!";
                        } else {
                           this.say = "" + this.plnames[this.im] + " wasted " + this.plnames[var24] + "!";
                        }

                        this.tcnt = -15;
                     }

                     if (this.dested[var24] == 3) {
                        this.wasay = true;
                        this.say = "" + this.plnames[var24] + " has been wasted! (Disconnected)";
                        this.tcnt = -15;
                     }
                  }
               }
            }

            if (this.multion >= 2 && this.alocked != this.lalocked) {
               if (this.alocked != -1) {
                  this.wasay = false;
                  this.say = "Now following " + this.plnames[this.alocked] + "!";
                  this.tcnt = -15;
               }

               this.lalocked = this.alocked;
               this.clear = var1.clear;
            }

            if (this.clear != var1.clear && var1.clear != 0) {
               if (!this.wasay) {
                  this.say = "Checkpoint!";
                  this.tcnt = 15;
               }

               this.clear = var1.clear;
               if (!this.mutes) {
                  this.checkpoint.play();
               }

               this.cntovn = 0;
               if (this.cntan != 0) {
                  this.cntan = 0;
               }
            }
         }
      }

      if (this.m.lightn != -1) {
         int var13 = this.strack.sClip.stream.available();
         this.m.lton = false;
         if (var13 <= 6380001 && var13 > 5368001) {
            this.m.lton = true;
         }

         if (var13 <= 2992001 && var13 > 1320001) {
            this.m.lton = true;
         }
      }
   }

   public void drawstat(int var1, int var2, boolean var3, float var4) {
      int[] var5 = new int[4];
      int[] var6 = new int[4];
      if (var2 > var1) {
         var2 = var1;
      }

      int var7 = (int)(98.0F * ((float)var2 / var1));
      var5[0] = 662;
      var6[0] = 11;
      var5[1] = 662;
      var6[1] = 20;
      var5[2] = 662 + var7;
      var6[2] = 20;
      var5[3] = 662 + var7;
      var6[3] = 11;
      int var8 = 244;
      int var9 = 244;
      int var10 = 11;
      if (var7 > 33) {
         var9 = (int)(244.0F - 233.0F * ((var7 - 33) / 65.0F));
      }

      if (var7 > 70) {
         if (this.dmcnt < 10) {
            if (this.dmflk) {
               var9 = 170;
               this.dmflk = false;
            } else {
               this.dmflk = true;
            }
         }

         this.dmcnt++;
         if (this.dmcnt > 167.0 - var7 * 1.5) {
            this.dmcnt = 0;
         }
      }

      var8 = (int)(var8 + var8 * (this.m.snap[0] / 100.0F));
      if (var8 > 255) {
         var8 = 255;
      }

      if (var8 < 0) {
         var8 = 0;
      }

      var9 = (int)(var9 + var9 * (this.m.snap[1] / 100.0F));
      if (var9 > 255) {
         var9 = 255;
      }

      if (var9 < 0) {
         var9 = 0;
      }

      var10 = (int)(var10 + var10 * (this.m.snap[2] / 100.0F));
      if (var10 > 255) {
         var10 = 255;
      }

      if (var10 < 0) {
         var10 = 0;
      }

      this.rd.setColor(new Color(var8, var9, var10));
      this.rd.fillPolygon(var5, var6, 4);
      var5[0] = 662;
      var6[0] = 31;
      var5[1] = 662;
      var6[1] = 40;
      var5[2] = (int)(662.0F + var4);
      var6[2] = 40;
      var5[3] = (int)(662.0F + var4);
      var6[3] = 31;
      int var12 = 128;
      if (var4 == 98.0F) {
         var12 = 64;
      }

      var9 = (int)(190.0 + var4 * 0.37);
      int var18 = 244;
      if (this.auscnt < 45 && this.aflk) {
         var12 = 128;
         var9 = 244;
         var18 = 244;
      }

      var12 = (int)(var12 + var12 * (this.m.snap[0] / 100.0F));
      if (var12 > 255) {
         var12 = 255;
      }

      if (var12 < 0) {
         var12 = 0;
      }

      var9 = (int)(var9 + var9 * (this.m.snap[1] / 100.0F));
      if (var9 > 255) {
         var9 = 255;
      }

      if (var9 < 0) {
         var9 = 0;
      }

      var18 = (int)(var18 + var18 * (this.m.snap[2] / 100.0F));
      if (var18 > 255) {
         var18 = 255;
      }

      if (var18 < 0) {
         var18 = 0;
      }

      this.rd.setColor(new Color(var12, var9, var18));
      this.rd.fillPolygon(var5, var6, 4);
   }

   public void drawhi(Image var1, int var2) {
      if (this.m.darksky) {
         new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]);
         float[] var4 = new float[3];
         Color.RGBtoHSB(this.m.csky[0], this.m.csky[1], this.m.csky[2], var4);
         var4[2] = 0.6F;
         Color var3 = Color.getHSBColor(var4[0], var4[1], var4[2]);
         this.rd.setColor(var3);
         this.rd.fillRoundRect(390 - var1.getWidth(this.ob) / 2, var2 - 2, var1.getWidth(this.ob) + 20, var1.getHeight(this.ob) + 2, 7, 20);
         this.rd.setColor(new Color((int)(var3.getRed() / 1.1), (int)(var3.getGreen() / 1.1), (int)(var3.getBlue() / 1.1)));
         this.rd.drawRoundRect(390 - var1.getWidth(this.ob) / 2, var2 - 2, var1.getWidth(this.ob) + 20, var1.getHeight(this.ob) + 2, 7, 20);
      }

      this.rd.drawImage(var1, 400 - var1.getWidth(this.ob) / 2, var2, null);
   }

   public void drawcs(int var1, String var2, int var3, int var4, int var5, int var6) {
      if (var6 != 3 && var6 != 4 && var6 != 5) {
         var3 = (int)(var3 + var3 * (this.m.snap[0] / 100.0F));
         if (var3 > 255) {
            var3 = 255;
         }

         if (var3 < 0) {
            var3 = 0;
         }

         var4 = (int)(var4 + var4 * (this.m.snap[1] / 100.0F));
         if (var4 > 255) {
            var4 = 255;
         }

         if (var4 < 0) {
            var4 = 0;
         }

         var5 = (int)(var5 + var5 * (this.m.snap[2] / 100.0F));
         if (var5 > 255) {
            var5 = 255;
         }

         if (var5 < 0) {
            var5 = 0;
         }
      }

      if (var6 == 4) {
         var3 = (int)(var3 - var3 * (this.m.snap[0] / 100.0F));
         if (var3 > 255) {
            var3 = 255;
         }

         if (var3 < 0) {
            var3 = 0;
         }

         var4 = (int)(var4 - var4 * (this.m.snap[1] / 100.0F));
         if (var4 > 255) {
            var4 = 255;
         }

         if (var4 < 0) {
            var4 = 0;
         }

         var5 = (int)(var5 - var5 * (this.m.snap[2] / 100.0F));
         if (var5 > 255) {
            var5 = 255;
         }

         if (var5 < 0) {
            var5 = 0;
         }
      }

      if (var6 == 1) {
         this.rd.setColor(new Color(0, 0, 0));
         this.rd.drawString(var2, 400 - this.ftm.stringWidth(var2) / 2 + 1, var1 + 1);
      }

      if (var6 == 2) {
         var3 = (var3 * 2 + this.m.csky[0] * 1) / 3;
         if (var3 > 255) {
            var3 = 255;
         }

         if (var3 < 0) {
            var3 = 0;
         }

         var4 = (var4 * 2 + this.m.csky[1] * 1) / 3;
         if (var4 > 255) {
            var4 = 255;
         }

         if (var4 < 0) {
            var4 = 0;
         }

         var5 = (var5 * 2 + this.m.csky[2] * 1) / 3;
         if (var5 > 255) {
            var5 = 255;
         }

         if (var5 < 0) {
            var5 = 0;
         }
      }

      if (var6 == 5) {
         this.rd.setColor(new Color(this.m.csky[0] / 2, this.m.csky[1] / 2, this.m.csky[2] / 2));
         this.rd.drawString(var2, 400 - this.ftm.stringWidth(var2) / 2 + 1, var1 + 1);
      }

      this.rd.setColor(new Color(var3, var4, var5));
      this.rd.drawString(var2, 400 - this.ftm.stringWidth(var2) / 2, var1);
   }

   public void arrow(int var1, int var2, CheckPoints var3, boolean var4) {
      int[] var5 = new int[7];
      int[] var6 = new int[7];
      int[] var7 = new int[7];
      short var8 = 400;
      byte var9 = -90;
      short var10 = 700;

      for (int var11 = 0; var11 < 7; var11++) {
         var6[var11] = var9;
      }

      var5[0] = var8;
      var7[0] = var10 + 110;
      var5[1] = var8 - 35;
      var7[1] = var10 + 50;
      var5[2] = var8 - 15;
      var7[2] = var10 + 50;
      var5[3] = var8 - 15;
      var7[3] = var10 - 50;
      var5[4] = var8 + 15;
      var7[4] = var10 - 50;
      var5[5] = var8 + 15;
      var7[5] = var10 + 50;
      var5[6] = var8 + 35;
      var7[6] = var10 + 50;
      int var16 = 0;
      if (!var4) {
         short var12 = 0;
         if (var3.x[var1] - var3.opx[this.im] >= 0) {
            var12 = 180;
         }

         var16 = (int)(90 + var12 + Math.atan((double)(var3.z[var1] - var3.opz[this.im]) / (var3.x[var1] - var3.opx[this.im])) / (Math.PI / 180.0));
      } else {
         int var20 = 0;
         if (this.multion != 0 && this.alocked != -1) {
            var20 = this.alocked;
         } else {
            int var13 = -1;
            boolean var14 = false;

            for (int var15 = 0; var15 < this.nplayers; var15++) {
               if (var15 != this.im
                  && (this.py(var3.opx[this.im] / 100, var3.opx[var15] / 100, var3.opz[this.im] / 100, var3.opz[var15] / 100) < var13 || var13 == -1)
                  && (!var14 || var3.onscreen[var15] != 0)
                  && var3.dested[var15] == 0) {
                  var20 = var15;
                  var13 = this.py(var3.opx[this.im] / 100, var3.opx[var15] / 100, var3.opz[this.im] / 100, var3.opz[var15] / 100);
                  if (var3.onscreen[var15] != 0) {
                     var14 = true;
                  }
               }
            }
         }

         short var25 = 0;
         if (var3.opx[var20] - var3.opx[this.im] >= 0) {
            var25 = 180;
         }

         var16 = (int)(90 + var25 + Math.atan((double)(var3.opz[var20] - var3.opz[this.im]) / (var3.opx[var20] - var3.opx[this.im])) / (Math.PI / 180.0));
         if (this.multion == 0) {
            this.drawcs(13, "[                                ]", 76, 67, 240, 0);
            this.drawcs(13, this.cd.names[this.sc[var20]], 0, 0, 0, 0);
         } else {
            this.rd.setFont(new Font("Arial", 1, 12));
            this.ftm = this.rd.getFontMetrics();
            this.drawcs(17, "[                                ]", 76, 67, 240, 0);
            this.drawcs(12, this.plnames[var20], 0, 0, 0, 0);
            this.rd.setFont(new Font("Arial", 0, 10));
            this.ftm = this.rd.getFontMetrics();
            this.drawcs(24, this.cd.names[this.sc[var20]], 0, 0, 0, 0);
            this.rd.setFont(new Font("Arial", 1, 11));
            this.ftm = this.rd.getFontMetrics();
         }
      }

      var16 += this.m.xz;

      while (var16 < 0) {
         var16 += 360;
      }

      while (var16 > 180) {
         var16 -= 360;
      }

      if (!var4) {
         if (var16 > 130) {
            var16 = 130;
         }

         if (var16 < -130) {
            var16 = -130;
         }
      } else {
         if (var16 > 100) {
            var16 = 100;
         }

         if (var16 < -100) {
            var16 = -100;
         }
      }

      if (Math.abs(this.ana - var16) < 180) {
         if (Math.abs(this.ana - var16) < 10) {
            this.ana = var16;
         } else if (this.ana < var16) {
            this.ana += 10;
         } else {
            this.ana -= 10;
         }
      } else {
         if (var16 < 0) {
            this.ana += 15;
            if (this.ana > 180) {
               this.ana -= 360;
            }
         }

         if (var16 > 0) {
            this.ana -= 15;
            if (this.ana < -180) {
               this.ana += 360;
            }
         }
      }

      this.rot(var5, var7, var8, var10, this.ana, 7);
      var16 = Math.abs(this.ana);
      this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      if (!var4) {
         if (var16 > 7 || var2 > 0 || var2 == -2 || this.cntan != 0) {
            for (int var21 = 0; var21 < 7; var21++) {
               var5[var21] = this.xs(var5[var21], var7[var21]);
               var6[var21] = this.ys(var6[var21], var7[var21]);
            }

            int var22 = (int)(190.0F + 190.0F * (this.m.snap[0] / 100.0F));
            if (var22 > 255) {
               var22 = 255;
            }

            if (var22 < 0) {
               var22 = 0;
            }

            int var26 = (int)(255.0F + 255.0F * (this.m.snap[1] / 100.0F));
            if (var26 > 255) {
               var26 = 255;
            }

            if (var26 < 0) {
               var26 = 0;
            }

            int var31 = 0;
            if (var2 <= 0) {
               if (var16 <= 45 && var2 != -2 && this.cntan == 0) {
                  var22 = (var22 * var16 + this.m.csky[0] * (45 - var16)) / 45;
                  var26 = (var26 * var16 + this.m.csky[1] * (45 - var16)) / 45;
                  var31 = (var31 * var16 + this.m.csky[2] * (45 - var16)) / 45;
               }

               if (var16 >= 90) {
                  int var35 = (int)(255.0F + 255.0F * (this.m.snap[0] / 100.0F));
                  if (var35 > 255) {
                     var35 = 255;
                  }

                  if (var35 < 0) {
                     var35 = 0;
                  }

                  var22 = (var22 * (140 - var16) + var35 * (var16 - 90)) / 50;
                  if (var22 > 255) {
                     var22 = 255;
                  }
               }
            } else if (this.flk) {
               var22 = (int)(255.0F + 255.0F * (this.m.snap[0] / 100.0F));
               if (var22 > 255) {
                  var22 = 255;
               }

               if (var22 < 0) {
                  var22 = 0;
               }

               this.flk = false;
            } else {
               var22 = (int)(255.0F + 255.0F * (this.m.snap[0] / 100.0F));
               if (var22 > 255) {
                  var22 = 255;
               }

               if (var22 < 0) {
                  var22 = 0;
               }

               var26 = (int)(220.0F + 220.0F * (this.m.snap[1] / 100.0F));
               if (var26 > 255) {
                  var26 = 255;
               }

               if (var26 < 0) {
                  var26 = 0;
               }

               this.flk = true;
            }

            this.rd.setColor(new Color(var22, var26, var31));
            this.rd.fillPolygon(var5, var6, 7);
            var22 = (int)(115.0F + 115.0F * (this.m.snap[0] / 100.0F));
            if (var22 > 255) {
               var22 = 255;
            }

            if (var22 < 0) {
               var22 = 0;
            }

            var26 = (int)(170.0F + 170.0F * (this.m.snap[1] / 100.0F));
            if (var26 > 255) {
               var26 = 255;
            }

            if (var26 < 0) {
               var26 = 0;
            }

            var31 = 0;
            if (var2 <= 0) {
               if (var16 <= 45 && var2 != -2 && this.cntan == 0) {
                  var22 = (var22 * var16 + this.m.csky[0] * (45 - var16)) / 45;
                  var26 = (var26 * var16 + this.m.csky[1] * (45 - var16)) / 45;
                  var31 = (var31 * var16 + this.m.csky[2] * (45 - var16)) / 45;
               }
            } else if (this.flk) {
               var22 = (int)(255.0F + 255.0F * (this.m.snap[0] / 100.0F));
               if (var22 > 255) {
                  var22 = 255;
               }

               if (var22 < 0) {
                  var22 = 0;
               }

               var26 = 0;
            }

            this.rd.setColor(new Color(var22, var26, var31));
            this.rd.drawPolygon(var5, var6, 7);
         }
      } else {
         byte var24 = 0;
         if (this.multion != 0) {
            var24 = 8;
         }

         for (int var28 = 0; var28 < 7; var28++) {
            var5[var28] = this.xs(var5[var28], var7[var28]);
            var6[var28] = this.ys(var6[var28], var7[var28]) + var24;
         }

         int var29 = (int)(159.0F + 159.0F * (this.m.snap[0] / 100.0F));
         if (var29 > 255) {
            var29 = 255;
         }

         if (var29 < 0) {
            var29 = 0;
         }

         int var33 = (int)(207.0F + 207.0F * (this.m.snap[1] / 100.0F));
         if (var33 > 255) {
            var33 = 255;
         }

         if (var33 < 0) {
            var33 = 0;
         }

         int var36 = (int)(255.0F + 255.0F * (this.m.snap[2] / 100.0F));
         if (var36 > 255) {
            var36 = 255;
         }

         if (var36 < 0) {
            var36 = 0;
         }

         this.rd.setColor(new Color(var29, var33, var36));
         this.rd.fillPolygon(var5, var6, 7);
         var29 = (int)(120.0F + 120.0F * (this.m.snap[0] / 100.0F));
         if (var29 > 255) {
            var29 = 255;
         }

         if (var29 < 0) {
            var29 = 0;
         }

         var33 = (int)(114.0F + 114.0F * (this.m.snap[1] / 100.0F));
         if (var33 > 255) {
            var33 = 255;
         }

         if (var33 < 0) {
            var33 = 0;
         }

         var36 = (int)(255.0F + 255.0F * (this.m.snap[2] / 100.0F));
         if (var36 > 255) {
            var36 = 255;
         }

         if (var36 < 0) {
            var36 = 0;
         }

         this.rd.setColor(new Color(var29, var33, var36));
         this.rd.drawPolygon(var5, var6, 7);
      }

      this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
   }

   public void radarstat(Mad var1, ContO var2, CheckPoints var3) {
      this.rd.setComposite(AlphaComposite.getInstance(3, 0.5F));
      this.rd.setColor(new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]));
      this.rd.fillRoundRect(10, 55, 172, 172, 30, 30);
      this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
      this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      this.rd.setColor(new Color(this.m.csky[0] / 2, this.m.csky[1] / 2, this.m.csky[2] / 2));

      for (int var4 = 0; var4 < var3.n; var4++) {
         int var5 = var4 + 1;
         if (var4 == var3.n - 1) {
            var5 = 0;
         }

         boolean var6 = false;
         if (var3.typ[var5] == -3) {
            var5 = 0;
            var6 = true;
         }

         int[] var7 = new int[]{(int)(96.0F - (var3.opx[this.im] - var3.x[var4]) / var3.prox), (int)(96.0F - (var3.opx[this.im] - var3.x[var5]) / var3.prox)};
         int[] var8 = new int[]{(int)(141.0F - (var3.z[var4] - var3.opz[this.im]) / var3.prox), (int)(141.0F - (var3.z[var5] - var3.opz[this.im]) / var3.prox)};
         this.rot(var7, var8, 96, 141, var1.cxz, 2);
         this.rd.drawLine(var7[0], var8[0], var7[1], var8[1]);
         if (var6) {
            break;
         }
      }

      int var13 = 0;
      int var18 = 0;
      int var23 = 0;
      if (this.arrace || this.multion > 1) {
         int[] var28 = new int[this.nplayers];
         int[] var31 = new int[this.nplayers];

         for (int var9 = 0; var9 < this.nplayers; var9++) {
            var28[var9] = (int)(96.0F - (var3.opx[this.im] - var3.opx[var9]) / var3.prox);
            var31[var9] = (int)(141.0F - (var3.opz[var9] - var3.opz[this.im]) / var3.prox);
         }

         this.rot(var28, var31, 96, 141, var1.cxz, this.nplayers);
         var13 = 0;
         var18 = (int)(80.0F + 80.0F * (this.m.snap[1] / 100.0F));
         if (var18 > 255) {
            var18 = 255;
         }

         if (var18 < 0) {
            var18 = 0;
         }

         var23 = (int)(159.0F + 159.0F * (this.m.snap[2] / 100.0F));
         if (var23 > 255) {
            var23 = 255;
         }

         if (var23 < 0) {
            var23 = 0;
         }

         for (int var34 = 0; var34 < this.nplayers; var34++) {
            if (var34 != this.im && var3.dested[var34] == 0) {
               if (this.clangame != 0) {
                  short var15;
                  byte var20;
                  short var25;
                  if (this.pclan[var34].toLowerCase().equals(this.gaclan.toLowerCase())) {
                     var15 = 159;
                     var20 = 80;
                     var25 = 0;
                  } else {
                     var15 = 0;
                     var20 = 80;
                     var25 = 159;
                  }

                  var13 = (int)(var15 + var15 * (this.m.snap[0] / 100.0F));
                  if (var13 > 255) {
                     var13 = 255;
                  }

                  if (var13 < 0) {
                     var13 = 0;
                  }

                  var18 = (int)(var20 + var20 * (this.m.snap[1] / 100.0F));
                  if (var18 > 255) {
                     var18 = 255;
                  }

                  if (var18 < 0) {
                     var18 = 0;
                  }

                  var23 = (int)(var25 + var25 * (this.m.snap[2] / 100.0F));
                  if (var23 > 255) {
                     var23 = 255;
                  }

                  if (var23 < 0) {
                     var23 = 0;
                  }
               }

               byte var10 = 2;
               if (this.alocked == var34) {
                  var10 = 3;
                  this.rd.setColor(new Color(var13, var18, var23));
               } else {
                  this.rd.setColor(new Color((var13 + this.m.csky[0]) / 2, (this.m.csky[1] + var18) / 2, (var23 + this.m.csky[2]) / 2));
               }

               this.rd.drawLine(var28[var34] - var10, var31[var34], var28[var34] + var10, var31[var34]);
               this.rd.drawLine(var28[var34], var31[var34] + var10, var28[var34], var31[var34] - var10);
               this.rd.setColor(new Color(var13, var18, var23));
               this.rd.fillRect(var28[var34] - 1, var31[var34] - 1, 3, 3);
            }
         }
      }

      var13 = (int)(159.0F + 159.0F * (this.m.snap[0] / 100.0F));
      if (var13 > 255) {
         var13 = 255;
      }

      if (var13 < 0) {
         var13 = 0;
      }

      var18 = 0;
      var23 = 0;
      if (this.clangame != 0) {
         short var17;
         byte var22;
         short var27;
         if (this.pclan[this.im].toLowerCase().equals(this.gaclan.toLowerCase())) {
            var17 = 159;
            var22 = 80;
            var27 = 0;
         } else {
            var17 = 0;
            var22 = 80;
            var27 = 159;
         }

         var13 = (int)(var17 + var17 * (this.m.snap[0] / 100.0F));
         if (var13 > 255) {
            var13 = 255;
         }

         if (var13 < 0) {
            var13 = 0;
         }

         var18 = (int)(var22 + var22 * (this.m.snap[1] / 100.0F));
         if (var18 > 255) {
            var18 = 255;
         }

         if (var18 < 0) {
            var18 = 0;
         }

         var23 = (int)(var27 + var27 * (this.m.snap[2] / 100.0F));
         if (var23 > 255) {
            var23 = 255;
         }

         if (var23 < 0) {
            var23 = 0;
         }
      }

      this.rd.setColor(new Color((var13 + this.m.csky[0]) / 2, (this.m.csky[1] + var18) / 2, (var23 + this.m.csky[2]) / 2));
      this.rd.drawLine(96, 139, 96, 143);
      this.rd.drawLine(94, 141, 98, 141);
      this.rd.setColor(new Color(var13, var18, var23));
      this.rd.fillRect(95, 140, 3, 3);
      this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
      if (this.m.darksky) {
         new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]);
         float[] var32 = new float[3];
         Color.RGBtoHSB(this.m.csky[0], this.m.csky[1], this.m.csky[2], var32);
         var32[2] = 0.6F;
         Color var29 = Color.getHSBColor(var32[0], var32[1], var32[2]);
         this.rd.setColor(var29);
         this.rd.fillRect(5, 232, 181, 17);
         this.rd.drawLine(4, 233, 4, 247);
         this.rd.drawLine(3, 235, 3, 245);
         this.rd.drawLine(186, 233, 186, 247);
         this.rd.drawLine(187, 235, 187, 245);
      }

      this.rd.drawImage(this.sped, 7, 234, null);
      int var30 = var2.x - this.lcarx;
      this.lcarx = var2.x;
      int var33 = var2.y - this.lcary;
      this.lcary = var2.y;
      int var35 = var2.z - this.lcarz;
      this.lcarz = var2.z;
      float var36 = (float)Math.sqrt(var30 * var30 + var35 * var35);
      float var11 = var36 * 1.4F * 21.0F * 60.0F * 60.0F / 100000.0F;
      float var12 = var11 * 0.621371F;
      this.rd.setColor(new Color(0, 0, 100));
      this.rd.drawString("" + (int)var11, 62, 245);
      this.rd.drawString("" + (int)var12, 132, 245);
   }

   public void playsounds(Mad var1, Control var2, int var3) {
      if ((this.fase == 0 || this.fase == 7001) && this.starcnt < 35 && this.cntwis != 8 && !this.mutes) {
         boolean var4 = var2.up && var1.speed > 0.0F || var2.down && var1.speed < 10.0F;
         boolean var5 = var1.skid == 1 && var2.handb
            || Math.abs(var1.scz[0] - (var1.scz[1] + var1.scz[0] + var1.scz[2] + var1.scz[3]) / 4.0F) > 1.0F
            || Math.abs(var1.scx[0] - (var1.scx[1] + var1.scx[0] + var1.scx[2] + var1.scx[3]) / 4.0F) > 1.0F;
         boolean var6 = false;
         if (var2.up && var1.speed < 10.0F) {
            var5 = true;
            var4 = true;
            var6 = true;
         }

         if (var4 && var1.mtouch) {
            if (!var1.capsized) {
               if (!var5) {
                  if (var1.power != 98.0F) {
                     if (Math.abs(var1.speed) > 0.0F && Math.abs(var1.speed) <= this.cd.swits[var1.cn][0]) {
                        int var7 = (int)(3.0F * Math.abs(var1.speed) / this.cd.swits[var1.cn][0]);
                        if (var7 == 2) {
                           if (this.pwait == 0) {
                              var7 = 0;
                           } else {
                              this.pwait--;
                           }
                        } else {
                           this.pwait = 7;
                        }

                        this.sparkeng(var7, var1.cn);
                     }

                     if (Math.abs(var1.speed) > this.cd.swits[var1.cn][0] && Math.abs(var1.speed) <= this.cd.swits[var1.cn][1]) {
                        int var8 = (int)(3.0F * (Math.abs(var1.speed) - this.cd.swits[var1.cn][0]) / (this.cd.swits[var1.cn][1] - this.cd.swits[var1.cn][0]));
                        if (var8 == 2) {
                           if (this.pwait == 0) {
                              var8 = 0;
                           } else {
                              this.pwait--;
                           }
                        } else {
                           this.pwait = 7;
                        }

                        this.sparkeng(var8, var1.cn);
                     }

                     if (Math.abs(var1.speed) > this.cd.swits[var1.cn][1] && Math.abs(var1.speed) <= this.cd.swits[var1.cn][2]) {
                        int var9 = (int)(3.0F * (Math.abs(var1.speed) - this.cd.swits[var1.cn][1]) / (this.cd.swits[var1.cn][2] - this.cd.swits[var1.cn][1]));
                        this.sparkeng(var9, var1.cn);
                     }
                  } else {
                     byte var10 = 2;
                     if (this.pwait == 0) {
                        if (Math.abs(var1.speed) > this.cd.swits[var1.cn][1]) {
                           var10 = 3;
                        }
                     } else {
                        this.pwait--;
                     }

                     this.sparkeng(var10, var1.cn);
                  }
               } else {
                  this.sparkeng(-1, var1.cn);
                  if (var6) {
                     if (this.stopcnt <= 0) {
                        this.air[5].loop();
                        this.stopcnt = 10;
                     }
                  } else if (this.stopcnt <= -2) {
                     this.air[2 + (int)(this.m.random() * 3.0F)].loop();
                     this.stopcnt = 7;
                  }
               }
            } else {
               this.sparkeng(3, var1.cn);
            }

            this.grrd = false;
            this.aird = false;
         } else {
            this.pwait = 15;
            if (!var1.mtouch && !this.grrd && this.m.random() > 0.4) {
               this.air[(int)(this.m.random() * 4.0F)].loop();
               this.stopcnt = 5;
               this.grrd = true;
            }

            if (!var1.wtouch && !this.aird) {
               this.stopairs();
               this.air[(int)(this.m.random() * 4.0F)].loop();
               this.stopcnt = 10;
               this.aird = true;
            }

            this.sparkeng(-1, var1.cn);
         }

         if (var1.cntdest != 0 && this.cntwis < 7) {
            if (!this.pwastd) {
               this.wastd.loop();
               this.pwastd = true;
            }
         } else {
            if (this.pwastd) {
               this.wastd.stop();
               this.pwastd = false;
            }

            if (this.cntwis == 7 && !this.mutes) {
               this.firewasted.play();
            }
         }
      } else {
         this.sparkeng(-2, var1.cn);
         if (this.pwastd) {
            this.wastd.stop();
            this.pwastd = false;
         }
      }

      if (this.stopcnt != -20) {
         if (this.stopcnt == 1) {
            this.stopairs();
         }

         this.stopcnt--;
      }

      if (this.bfcrash != 0) {
         this.bfcrash--;
      }

      if (this.bfscrape != 0) {
         this.bfscrape--;
      }

      if (this.bfsc1 != 0) {
         this.bfsc1--;
      }

      if (this.bfsc2 != 0) {
         this.bfsc2--;
      }

      if (this.bfskid != 0) {
         this.bfskid--;
      }

      if (var1.newcar) {
         this.cntwis = 0;
      }

      if (this.fase == 0 || this.fase == 7001 || this.fase == 6 || this.fase == -1 || this.fase == -2 || this.fase == -3 || this.fase == -4 || this.fase == -5) {
         if (this.mutes != var2.mutes) {
            this.mutes = var2.mutes;
         }

         if (var2.mutem != this.mutem) {
            this.mutem = var2.mutem;
            if (this.mutem) {
               if (this.loadedt) {
                  this.strack.stop();
               }
            } else if (this.loadedt) {
               this.strack.resume();
            }
         }
      }

      if (var1.cntdest != 0 && this.cntwis < 7) {
         if (var1.dest) {
            this.cntwis++;
         }
      } else {
         if (var1.cntdest == 0) {
            this.cntwis = 0;
         }

         if (this.cntwis == 7) {
            this.cntwis = 8;
         }
      }

      if (this.app.applejava) {
         this.closesounds();
      }
   }

   public void stopairs() {
      for (int var1 = 0; var1 < 6; var1++) {
         this.air[var1].stop();
      }
   }

   public void sparkeng(int var1, int var2) {
      if (this.lcn != var2) {
         for (int var3 = 0; var3 < 5; var3++) {
            if (this.pengs[var3]) {
               this.engs[this.cd.enginsignature[this.lcn]][var3].stop();
               this.pengs[var3] = false;
            }
         }

         this.lcn = var2;
      }

      var1++;

      for (int var5 = 0; var5 < 5; var5++) {
         if (var1 == var5) {
            if (!this.pengs[var5]) {
               this.engs[this.cd.enginsignature[var2]][var5].loop();
               this.pengs[var5] = true;
            }
         } else if (this.pengs[var5]) {
            this.engs[this.cd.enginsignature[var2]][var5].stop();
            this.pengs[var5] = false;
         }
      }
   }

   public void crash(float var1, int var2) {
      if (this.bfcrash == 0) {
         if (var2 == 0) {
            if (Math.abs(var1) > 25.0F && Math.abs(var1) < 170.0F) {
               if (!this.mutes) {
                  this.lowcrash[this.crshturn].play();
               }

               this.bfcrash = 2;
            }

            if (Math.abs(var1) >= 170.0F) {
               if (!this.mutes) {
                  this.crash[this.crshturn].play();
               }

               this.bfcrash = 2;
            }

            if (Math.abs(var1) > 25.0F) {
               if (this.crashup) {
                  this.crshturn--;
               } else {
                  this.crshturn++;
               }

               if (this.crshturn == -1) {
                  this.crshturn = 2;
               }

               if (this.crshturn == 3) {
                  this.crshturn = 0;
               }
            }
         }

         if (var2 == -1) {
            if (Math.abs(var1) > 25.0F && Math.abs(var1) < 170.0F) {
               if (!this.mutes) {
                  this.lowcrash[2].play();
               }

               this.bfcrash = 2;
            }

            if (Math.abs(var1) > 170.0F) {
               if (!this.mutes) {
                  this.crash[2].play();
               }

               this.bfcrash = 2;
            }
         }

         if (var2 == 1) {
            if (!this.mutes) {
               this.tires.play();
            }

            this.bfcrash = 3;
         }
      }
   }

   public void skid(int var1, float var2) {
      if (this.bfcrash == 0 && this.bfskid == 0 && var2 > 150.0F) {
         if (var1 == 0) {
            if (!this.mutes) {
               this.skid[this.skflg].play();
            }

            if (this.skidup) {
               this.skflg++;
            } else {
               this.skflg--;
            }

            if (this.skflg == 3) {
               this.skflg = 0;
            }

            if (this.skflg == -1) {
               this.skflg = 2;
            }
         } else {
            if (!this.mutes) {
               this.dustskid[this.dskflg].play();
            }

            if (this.skidup) {
               this.dskflg++;
            } else {
               this.dskflg--;
            }

            if (this.dskflg == 3) {
               this.dskflg = 0;
            }

            if (this.dskflg == -1) {
               this.dskflg = 2;
            }
         }

         this.bfskid = 35;
      }
   }

   public void scrape(int var1, int var2, int var3) {
      if (this.bfscrape == 0 && Math.sqrt(var1 * var1 + var2 * var2 + var3 * var3) / 10.0 > 10.0) {
         byte var4 = 0;
         if (this.m.random() > this.m.random()) {
            var4 = 1;
         }

         if (var4 == 0) {
            this.sturn1 = 0;
            this.sturn0++;
            if (this.sturn0 == 3) {
               var4 = 1;
               this.sturn1 = 1;
               this.sturn0 = 0;
            }
         } else {
            this.sturn0 = 0;
            this.sturn1++;
            if (this.sturn1 == 3) {
               var4 = 0;
               this.sturn0 = 1;
               this.sturn1 = 0;
            }
         }

         if (!this.mutes) {
            this.scrape[var4].play();
         }

         this.bfscrape = 5;
      }
   }

   public void gscrape(int var1, int var2, int var3) {
      if ((this.bfsc1 == 0 || this.bfsc2 == 0) && Math.sqrt(var1 * var1 + var2 * var2 + var3 * var3) / 10.0 > 15.0) {
         if (this.bfsc1 == 0) {
            if (!this.mutes) {
               this.scrape[2].stop();
               this.scrape[2].play();
            }

            this.bfsc1 = 12;
            this.bfsc2 = 6;
         } else {
            if (!this.mutes) {
               this.scrape[3].stop();
               this.scrape[3].play();
            }

            this.bfsc2 = 12;
            this.bfsc1 = 6;
         }
      }
   }

   public void closesounds() {
      for (int var1 = 0; var1 < 5; var1++) {
         for (int var2 = 0; var2 < 5; var2++) {
            this.engs[var1][var2].checkopen();
         }
      }

      for (int var3 = 0; var3 < 6; var3++) {
         this.air[var3].checkopen();
      }

      this.tires.checkopen();
      this.checkpoint.checkopen();
      this.carfixed.checkopen();
      this.powerup.checkopen();
      this.three.checkopen();
      this.two.checkopen();
      this.one.checkopen();
      this.go.checkopen();
      this.wastd.checkopen();
      this.firewasted.checkopen();

      for (int var4 = 0; var4 < 3; var4++) {
         this.skid[var4].checkopen();
         this.dustskid[var4].checkopen();
         this.crash[var4].checkopen();
         this.lowcrash[var4].checkopen();
         this.scrape[var4].checkopen();
      }
   }

   public void rot(int[] var1, int[] var2, int var3, int var4, int var5, int var6) {
      if (var5 != 0) {
         for (int var7 = 0; var7 < var6; var7++) {
            int var8 = var1[var7];
            int var9 = var2[var7];
            var1[var7] = var3 + (int)((var8 - var3) * this.m.cos(var5) - (var9 - var4) * this.m.sin(var5));
            var2[var7] = var4 + (int)((var8 - var3) * this.m.sin(var5) + (var9 - var4) * this.m.cos(var5));
         }
      }
   }

   public int xs(int var1, int var2) {
      if (var2 < 50) {
         var2 = 50;
      }

      return (var2 - this.m.focus_point) * (this.m.cx - var1) / var2 + var1;
   }

   public int ys(int var1, int var2) {
      if (var2 < 50) {
         var2 = 50;
      }

      return (var2 - this.m.focus_point) * (this.m.cy - var1) / var2 + var1;
   }

   public int py(int var1, int var2, int var3, int var4) {
      return (var1 - var2) * (var1 - var2) + (var3 - var4) * (var3 - var4);
   }

   public float pys(int var1, int var2, int var3, int var4) {
      return (float)Math.sqrt((var1 - var2) * (var1 - var2) + (var3 - var4) * (var3 - var4));
   }

   public void snap(int var1) {
      this.dmg = this.loadsnap(this.odmg);
      this.pwr = this.loadsnap(this.opwr);
      this.was = this.loadsnap(this.owas);
      this.lap = this.loadsnap(this.olap);
      this.pos = this.loadsnap(this.opos);
      this.sped = this.loadsnap(this.osped);

      for (int var2 = 0; var2 < 8; var2++) {
         this.rank[var2] = this.loadsnap(this.orank[var2]);
      }

      for (int var3 = 0; var3 < 4; var3++) {
         this.cntdn[var3] = this.loadsnap(this.ocntdn[var3]);
      }

      if (this.multion != 0) {
         this.wgame = this.loadsnap(this.owgame);
         this.exitgame = this.loadsnap(this.oexitgame);
         this.gamefinished = this.loadsnap(this.ogamefinished);
         this.disco = this.loadsnap(this.odisco);
      }

      this.yourwasted = this.loadsnap(this.oyourwasted);
      this.youlost = this.loadsnap(this.oyoulost);
      this.youwon = this.loadsnap(this.oyouwon);
      this.youwastedem = this.loadsnap(this.oyouwastedem);
      this.gameh = this.loadsnap(this.ogameh);
      this.loadingmusic = this.loadopsnap(this.oloadingmusic, var1, 76);
      this.star[0] = this.loadopsnap(this.ostar[0], var1, 0);
      this.star[1] = this.loadopsnap(this.ostar[1], var1, 0);
      this.flaot = this.loadopsnap(this.oflaot, var1, 1);
   }

   public boolean overon(int var1, int var2, int var3, int var4, int var5, int var6) {
      return var5 > var1 && var5 < var1 + var3 && var6 > var2 && var6 < var2 + var4;
   }

   public boolean over(Image var1, int var2, int var3, int var4, int var5) {
      int var6 = var1.getHeight(this.ob);
      int var7 = var1.getWidth(this.ob);
      return var2 > var4 - 5 && var2 < var4 + var7 + 5 && var3 > var5 - 5 && var3 < var5 + var6 + 5;
   }

   public void fleximage(Image var1, int var2, int var3) {
      if (!this.badmac) {
         if (var2 == 0) {
            this.flexpix = new int[360000];
            PixelGrabber var4 = new PixelGrabber(var1, 0, 0, 800, 450, this.flexpix, 0, 800);

            try {
               var4.grabPixels();
            } catch (InterruptedException var19) {
            }
         }

         int var20 = 0;
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         int var8 = (int)(Math.random() * 128.0);
         int var9 = (int)(5.0 + Math.random() * 15.0);

         for (int var10 = 0; var10 < 360000; var10++) {
            Color var11 = new Color(this.flexpix[var10]);
            int var12 = 0;
            int var13 = 0;
            int var14 = 0;
            if (var20 == 0) {
               var12 = var11.getRed();
               var5 = var12;
               var13 = var11.getGreen();
               var6 = var13;
               var14 = var11.getBlue();
               var7 = var14;
            } else {
               var12 = (int)((var11.getRed() + var5 * 0.38F * var2) / (1.0F + 0.38F * var2));
               var5 = var12;
               var13 = (int)((var11.getGreen() + var6 * 0.38F * var2) / (1.0F + 0.38F * var2));
               var6 = var13;
               var14 = (int)((var11.getBlue() + var7 * 0.38F * var2) / (1.0F + 0.38F * var2));
               var7 = var14;
            }

            if (++var20 == 800) {
               var20 = 0;
            }

            int var15 = (int)((var12 * 17 + var13 + var14 + var8) / 21.0F);
            int var16 = (int)((var13 * 17 + var12 + var14 + var8) / 22.0F);
            int var17 = (int)((var14 * 17 + var12 + var13 + var8) / 24.0F);
            if (--var9 == 0) {
               var8 = (int)(Math.random() * 128.0);
               var9 = (int)(5.0 + Math.random() * 15.0);
            }

            Color var18 = new Color(var15, var16, var17);
            this.flexpix[var10] = var18.getRGB();
         }

         this.fleximg = this.createImage(new MemoryImageSource(800, 450, this.flexpix, 0, 800));
         this.rd.drawImage(this.fleximg, 0, 0, null);
      } else {
         this.rd.setColor(new Color(0, 0, 0));
         this.rd.setComposite(AlphaComposite.getInstance(3, 0.1F));
         this.rd.fillRect(0, 0, 800, 450);
         this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
      }
   }

   private Image loadsnap(Image var1) {
      int var2 = var1.getHeight(this.ob);
      int var3 = var1.getWidth(this.ob);
      int[] var4 = new int[var3 * var2];
      PixelGrabber var5 = new PixelGrabber(var1, 0, 0, var3, var2, var4, 0, var3);

      try {
         var5.grabPixels();
      } catch (InterruptedException var12) {
      }

      for (int var6 = 0; var6 < var3 * var2; var6++) {
         Color var7 = new Color(var4[var3 * var2 - 1]);
         Color var8 = new Color(var4[var6]);
         if (var8.getRed() != var8.getGreen() && var8.getGreen() != var8.getBlue()) {
            int var14 = (int)(var8.getRed() + var8.getRed() * (this.m.snap[0] / 100.0F));
            if (var14 > 255) {
               var14 = 255;
            }

            if (var14 < 0) {
               var14 = 0;
            }

            int var10 = (int)(var8.getGreen() + var8.getGreen() * (this.m.snap[1] / 100.0F));
            if (var10 > 255) {
               var10 = 255;
            }

            if (var10 < 0) {
               var10 = 0;
            }

            int var11 = (int)(var8.getBlue() + var8.getBlue() * (this.m.snap[2] / 100.0F));
            if (var11 > 255) {
               var11 = 255;
            }

            if (var11 < 0) {
               var11 = 0;
            }

            var4[var6] = 0xFF000000 | var14 << 16 | var10 << 8 | var11;
         } else {
            int var9 = (int)((float)(var7.getRed() - var8.getRed()) / var7.getRed() * 255.0F);
            if (var9 > 255) {
               var9 = 255;
            }

            if (var9 < 0) {
               var9 = 0;
            }

            var4[var6] = var9 << 24 | 0 | 0 | 0;
         }
      }

      BufferedImage var13 = new BufferedImage(var3, var2, 2);
      var13.setRGB(0, 0, var3, var2, var4, 0, var3);
      return var13;
   }

   private Image loadopsnap(Image var1, int var2, int var3) {
      int var4 = var1.getHeight(this.ob);
      int var5 = var1.getWidth(this.ob);
      int[] var6 = new int[var5 * var4];
      PixelGrabber var7 = new PixelGrabber(var1, 0, 0, var5, var4, var6, 0, var5);

      try {
         var7.grabPixels();
      } catch (InterruptedException var16) {
      }

      if (var2 < 0) {
         var2 = 33;
      }

      int var8 = 0;
      if (var3 == 1) {
         var8 = var6['\uf229'];
      }

      int[] var9 = new int[]{this.m.snap[0], this.m.snap[1], this.m.snap[2]};

      while (var9[0] + var9[1] + var9[2] < -30) {
         for (int var10 = 0; var10 < 3; var10++) {
            if (var9[var10] < 50) {
               var9[var10]++;
            }
         }
      }

      for (int var17 = 0; var17 < var5 * var4; var17++) {
         if (var6[var17] != var6[var3]) {
            Color var11 = new Color(var6[var17]);
            int var12 = 0;
            int var13 = 0;
            int var14 = 0;
            if (var3 == 1 && var6[var17] == var8) {
               var12 = (int)(237.0F - 237.0F * (var9[0] / 150.0F));
               if (var12 > 255) {
                  var12 = 255;
               }

               if (var12 < 0) {
                  var12 = 0;
               }

               var13 = (int)(237.0F - 237.0F * (var9[1] / 150.0F));
               if (var13 > 255) {
                  var13 = 255;
               }

               if (var13 < 0) {
                  var13 = 0;
               }

               var14 = (int)(237.0F - 237.0F * (var9[2] / 150.0F));
               if (var14 > 255) {
                  var14 = 255;
               }

               if (var14 < 0) {
                  var14 = 0;
               }

               if (var2 == 11) {
                  var12 = 250;
                  var13 = 250;
                  var14 = 250;
               }
            } else {
               var12 = (int)(var11.getRed() - var11.getRed() * (var9[0] / 100.0F));
               if (var12 > 255) {
                  var12 = 255;
               }

               if (var12 < 0) {
                  var12 = 0;
               }

               var13 = (int)(var11.getGreen() - var11.getGreen() * (var9[1] / 100.0F));
               if (var13 > 255) {
                  var13 = 255;
               }

               if (var13 < 0) {
                  var13 = 0;
               }

               var14 = (int)(var11.getBlue() - var11.getBlue() * (var9[2] / 100.0F));
               if (var14 > 255) {
                  var14 = 255;
               }

               if (var14 < 0) {
                  var14 = 0;
               }
            }

            Color var15 = new Color(var12, var13, var14);
            var6[var17] = var15.getRGB();
         }
      }

      return this.createImage(new MemoryImageSource(var5, var4, var6, 0, var5));
   }

   private Image pressed(Image var1) {
      int var2 = var1.getHeight(this.ob);
      int var3 = var1.getWidth(this.ob);
      int[] var4 = new int[var3 * var2];
      PixelGrabber var5 = new PixelGrabber(var1, 0, 0, var3, var2, var4, 0, var3);

      try {
         var5.grabPixels();
      } catch (InterruptedException var7) {
      }

      for (int var6 = 0; var6 < var3 * var2; var6++) {
         if (var4[var6] != var4[var3 * var2 - 1]) {
            var4[var6] = -16777216;
         }
      }

      return this.createImage(new MemoryImageSource(var3, var2, var4, 0, var3));
   }

   private Image bressed(Image var1) {
      int var2 = var1.getHeight(this.ob);
      int var3 = var1.getWidth(this.ob);
      int[] var4 = new int[var3 * var2];
      PixelGrabber var5 = new PixelGrabber(var1, 0, 0, var3, var2, var4, 0, var3);

      try {
         var5.grabPixels();
      } catch (InterruptedException var8) {
      }

      Color var6 = new Color(247, 255, 165);

      for (int var7 = 0; var7 < var3 * var2; var7++) {
         if (var4[var7] != var4[var3 * var2 - 1]) {
            var4[var7] = var6.getRGB();
         }
      }

      return this.createImage(new MemoryImageSource(var3, var2, var4, 0, var3));
   }

   public void pauseimage(Image var1) {
      if (!this.badmac) {
         int[] var2 = new int[360000];
         PixelGrabber var3 = new PixelGrabber(var1, 0, 0, 800, 450, var2, 0, 800);

         try {
            var3.grabPixels();
         } catch (InterruptedException var15) {
         }

         int var4 = 0;
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;

         for (int var8 = 0; var8 < 360000; var8++) {
            Color var9 = new Color(var2[var8]);
            int var10 = 0;
            if (var7 == 0) {
               var10 = (var9.getRed() + var9.getGreen() + var9.getBlue()) / 3;
               var6 = var10;
            } else {
               var10 = (var9.getRed() + var9.getGreen() + var9.getBlue() + var6 * 30) / 33;
               var6 = var10;
            }

            if (++var7 == 800) {
               var7 = 0;
            }

            if (var8 > 800 * (8 + var5) + 281 && var5 < 188) {
               int var17 = (var10 + 60) / 3;
               int var12 = (var10 + 135) / 3;
               int var13 = (var10 + 220) / 3;
               if (++var4 == 237) {
                  var5++;
                  var4 = 0;
               }

               Color var14 = new Color(var17, var12, var13);
               var2[var8] = var14.getRGB();
            } else {
               Color var11 = new Color(var10, var10, var10);
               var2[var8] = var11.getRGB();
            }
         }

         this.fleximg = this.createImage(new MemoryImageSource(800, 450, var2, 0, 800));
         this.rd.drawImage(this.fleximg, 0, 0, null);
      } else {
         this.rd.setColor(new Color(0, 0, 0));
         this.rd.setComposite(AlphaComposite.getInstance(3, 0.5F));
         this.rd.fillRect(0, 0, 800, 450);
         this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
      }
   }

   public void jflexo() {
      if (!this.badmac) {
         int[] var1 = new int[360000];
         PixelGrabber var2 = new PixelGrabber(this.app.offImage, 0, 0, 800, 450, var1, 0, 800);

         try {
            var2.grabPixels();
         } catch (InterruptedException var13) {
         }

         int var3 = 0;
         int var4 = 0;
         int var5 = 0;
         int var6 = 0;

         for (int var7 = 0; var7 < 360000; var7++) {
            Color var8 = new Color(var1[var7]);
            int var9 = 0;
            int var10 = 0;
            int var11 = 0;
            if (var6 == 0) {
               var9 = var8.getRed();
               var3 = var9;
               var10 = var8.getGreen();
               var5 = var10;
               var11 = var8.getBlue();
               var4 = var11;
            } else {
               var9 = (var8.getRed() + var3 * 10) / 11;
               var3 = var9;
               var10 = (var8.getGreen() + var5 * 10) / 11;
               var5 = var10;
               var11 = (var8.getBlue() + var4 * 10) / 11;
               var4 = var11;
            }

            if (++var6 == 800) {
               var6 = 0;
            }

            Color var12 = new Color(var9, var10, var11);
            var1[var7] = var12.getRGB();
         }

         Image var14 = this.createImage(new MemoryImageSource(800, 450, var1, 0, 800));
         this.rd.drawImage(var14, 0, 0, null);
      } else {
         this.rd.setColor(new Color(0, 0, 0));
         this.rd.setComposite(AlphaComposite.getInstance(3, 0.5F));
         this.rd.fillRect(0, 0, 800, 450);
         this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
      }
   }

   public void pingstat() {
      int var1 = (int)(100.0 * Math.random());

      try {
         URL var2 = new URL("http://c.statcounter.com/9994681/0/14bb645e/1/?reco=" + var1 + "");
         var2.openConnection().setConnectTimeout(5000);
         Image var3 = Toolkit.getDefaultToolkit().createImage(var2);
         MediaTracker var4 = new MediaTracker(this.app);
         var4.addImage(var3, 0);
         var4.waitForID(0);
         var4.removeImage(var3, 0);
         Object var7 = null;
         var3 = null;
      } catch (Exception var5) {
      }
   }

   public Image getImage(String var1) {
      Image var2 = Toolkit.getDefaultToolkit().createImage("" + Madness.fpath + "" + var1 + "");
      MediaTracker var3 = new MediaTracker(this.app);
      var3.addImage(var2, 0);

      try {
         var3.waitForID(0);
      } catch (Exception var5) {
      }

      return var2;
   }

   private Image loadimage(byte[] var1, MediaTracker var2, Toolkit var3) {
      Image var4 = var3.createImage(var1);
      var2.addImage(var4, 0);

      try {
         var2.waitForID(0);
      } catch (Exception var6) {
      }

      return var4;
   }

   private Image loadude(byte[] var1, MediaTracker var2, Toolkit var3) {
      Image var4 = var3.createImage(var1);
      var2.addImage(var4, 0);

      try {
         var2.waitForID(0);
      } catch (Exception var13) {
      }

      int var5 = var4.getHeight(this.ob);
      int var6 = var4.getWidth(this.ob);
      int[] var7 = new int[var6 * var5];
      PixelGrabber var8 = new PixelGrabber(var4, 0, 0, var6, var5, var7, 0, var6);

      try {
         var8.grabPixels();
      } catch (InterruptedException var12) {
      }

      for (int var9 = 0; var9 < var6 * var5; var9++) {
         Color var10 = new Color(var7[var9]);
         if (var10.getGreen() > var10.getRed() + 5 && var10.getGreen() > var10.getBlue() + 5) {
            int var11 = (int)(255.0F - (var10.getGreen() - (var10.getRed() + var10.getBlue()) / 2) * 1.5F);
            if (var11 > 255) {
               var11 = 255;
            }

            if (var11 < 0) {
               var11 = 0;
            }

            var7[var9] = var11 << 24 | 0 | 0 | 0;
         }
      }

      BufferedImage var15 = new BufferedImage(var6, var5, 2);
      var15.setRGB(0, 0, var6, var5, var7, 0, var6);
      Object var14 = null;
      return var15;
   }

   private Image loadBimage(byte[] var1, MediaTracker var2, Toolkit var3, int var4) {
      Image var5 = var3.createImage(var1);
      var2.addImage(var5, 0);

      try {
         var2.waitForID(0);
      } catch (Exception var15) {
      }

      int var6 = var5.getHeight(this.ob);
      int var7 = var5.getWidth(this.ob);
      int[] var8 = new int[var7 * var6];
      PixelGrabber var9 = new PixelGrabber(var5, 0, 0, var7, var6, var8, 0, var7);

      try {
         var9.grabPixels();
      } catch (InterruptedException var14) {
      }

      for (int var10 = 0; var10 < var7 * var6; var10++) {
         if (var8[var10] != var8[0] || var4 != 0) {
            Color var11 = new Color(var8[var10]);
            float[] var12 = new float[3];
            Color.RGBtoHSB(var11.getRed(), var11.getGreen(), var11.getBlue(), var12);
            var12[0] = 0.12F;
            var12[1] = 0.45F;
            if (var4 == 3) {
               var12[0] = 0.13F;
               var12[1] = 0.45F;
            }

            Color var13 = Color.getHSBColor(var12[0], var12[1], var12[2]);
            var8[var10] = var13.getRGB();
         }
      }

      if (var4 == 2) {
         Color var17 = new Color(var8[0]);
         int var21 = 1073741824 | var17.getRed() << 16 | var17.getGreen() << 8 | var17.getBlue();
         var17 = new Color(var8[1]);
         int var23 = -2147483648 | var17.getRed() << 16 | var17.getGreen() << 8 | var17.getBlue();

         for (int var24 = 2; var24 < var7 * var6; var24++) {
            if (var8[var24] == var8[0]) {
               var8[var24] = var21;
            }

            if (var8[var24] == var8[1]) {
               var8[var24] = var23;
            }
         }

         var8[0] = var21;
         var8[1] = var23;
      }

      Object var19 = null;
      if (var4 == 2) {
         BufferedImage var22 = new BufferedImage(var7, var6, 2);
         var22.setRGB(0, 0, var7, var6, var8, 0, var7);
         var19 = var22;
      } else {
         var19 = this.createImage(new MemoryImageSource(var7, var6, var8, 0, var7));
      }

      Object var16 = null;
      return (Image)var19;
   }

   private Image dodgen(Image var1) {
      int var2 = var1.getHeight(this.ob);
      int var3 = var1.getWidth(this.ob);
      int[] var4 = new int[var3 * var2];
      PixelGrabber var5 = new PixelGrabber(var1, 0, 0, var3, var2, var4, 0, var3);

      try {
         var5.grabPixels();
      } catch (InterruptedException var12) {
      }

      for (int var6 = 0; var6 < var3 * var2; var6++) {
         Color var7 = new Color(var4[var6]);
         int var8 = var7.getRed() * 4 + 90;
         if (var8 > 255) {
            var8 = 255;
         }

         if (var8 < 0) {
            var8 = 0;
         }

         int var9 = var7.getGreen() * 4 + 90;
         if (var9 > 255) {
            var9 = 255;
         }

         if (var9 < 0) {
            var9 = 0;
         }

         int var10 = var7.getBlue() * 4 + 90;
         if (var10 > 255) {
            var10 = 255;
         }

         if (var10 < 0) {
            var10 = 0;
         }

         Color var11 = new Color(var8, var9, var10);
         var4[var6] = var11.getRGB();
      }

      return this.createImage(new MemoryImageSource(var3, var2, var4, 0, var3));
   }

   private void smokeypix(byte[] var1, MediaTracker var2, Toolkit var3) {
      Image var4 = var3.createImage(var1);
      var2.addImage(var4, 0);

      try {
         var2.waitForID(0);
      } catch (Exception var11) {
      }

      PixelGrabber var5 = new PixelGrabber(var4, 0, 0, 466, 202, this.smokey, 0, 466);

      try {
         var5.grabPixels();
      } catch (InterruptedException var10) {
      }

      for (int var6 = 0; var6 < 94132; var6++) {
         if (this.smokey[var6] != this.smokey[0]) {
            Color var7 = new Color(this.smokey[var6]);
            float[] var8 = new float[3];
            Color.RGBtoHSB(var7.getRed(), var7.getGreen(), var7.getBlue(), var8);
            var8[0] = 0.11F;
            var8[1] = 0.45F;
            Color var9 = Color.getHSBColor(var8[0], var8[1], var8[2]);
            this.smokey[var6] = var9.getRGB();
         }
      }
   }

   private void makecarsbgc(Image var1, Image var2) {
      int[] var3 = new int[268000];
      PixelGrabber var4 = new PixelGrabber(this.carsbg, 0, 0, 670, 400, var3, 0, 670);

      try {
         var4.grabPixels();
      } catch (InterruptedException var19) {
      }

      int[] var5 = new int[20700];
      PixelGrabber var6 = new PixelGrabber(var1, 0, 0, 92, 225, var5, 0, 92);

      try {
         var6.grabPixels();
      } catch (InterruptedException var18) {
      }

      int[] var7 = new int[2112];
      PixelGrabber var8 = new PixelGrabber(var2, 0, 0, 88, 24, var7, 0, 88);

      try {
         var8.grabPixels();
      } catch (InterruptedException var17) {
      }

      for (int var9 = 0; var9 < 670; var9++) {
         for (int var10 = 0; var10 < 400; var10++) {
            if (var9 > 14 && var9 < 106 && var10 > 11 && var10 < 236 && var5[var9 - 14 + (var10 - 11) * 92] != var5[0]) {
               Color var11 = new Color(var3[var9 + var10 * 670]);
               Color var12 = new Color(var5[var9 - 14 + (var10 - 11) * 92]);
               int var13 = (int)(var11.getRed() * 0.33 + var12.getRed() * 0.67);
               if (var13 > 255) {
                  var13 = 255;
               }

               if (var13 < 0) {
                  var13 = 0;
               }

               int var14 = (int)(var11.getGreen() * 0.33 + var12.getGreen() * 0.67);
               if (var14 > 255) {
                  var14 = 255;
               }

               if (var14 < 0) {
                  var14 = 0;
               }

               int var15 = (int)(var11.getBlue() * 0.33 + var12.getBlue() * 0.67);
               if (var15 > 255) {
                  var15 = 255;
               }

               if (var15 < 0) {
                  var15 = 0;
               }

               Color var16 = new Color(var13, var14, var15);
               var3[var9 + var10 * 670] = var16.getRGB();
            }

            if (var9 > 564 && var9 < 656 && var10 > 11 && var10 < 236 && var5[var9 - 564 + (var10 - 11) * 92] != var5[0]) {
               Color var20 = new Color(var3[var9 + var10 * 670]);
               Color var22 = new Color(var5[var9 - 564 + (var10 - 11) * 92]);
               int var24 = (int)(var20.getRed() * 0.33 + var22.getRed() * 0.67);
               if (var24 > 255) {
                  var24 = 255;
               }

               if (var24 < 0) {
                  var24 = 0;
               }

               int var26 = (int)(var20.getGreen() * 0.33 + var22.getGreen() * 0.67);
               if (var26 > 255) {
                  var26 = 255;
               }

               if (var26 < 0) {
                  var26 = 0;
               }

               int var28 = (int)(var20.getBlue() * 0.33 + var22.getBlue() * 0.67);
               if (var28 > 255) {
                  var28 = 255;
               }

               if (var28 < 0) {
                  var28 = 0;
               }

               Color var30 = new Color(var24, var26, var28);
               var3[var9 + var10 * 670] = var30.getRGB();
            }

            if (var9 > 440 && var9 < 528 && var10 > 53 && var10 < 77 && var7[var9 - 440 + (var10 - 53) * 88] != var7[0]) {
               Color var21 = new Color(var3[var9 + var10 * 670]);
               Color var23 = new Color(var7[var9 - 440 + (var10 - 53) * 88]);
               int var25 = (int)(var21.getRed() * 0.33 + var23.getRed() * 0.67);
               if (var25 > 255) {
                  var25 = 255;
               }

               if (var25 < 0) {
                  var25 = 0;
               }

               int var27 = (int)(var21.getGreen() * 0.33 + var23.getGreen() * 0.67);
               if (var27 > 255) {
                  var27 = 255;
               }

               if (var27 < 0) {
                  var27 = 0;
               }

               int var29 = (int)(var21.getBlue() * 0.33 + var23.getBlue() * 0.67);
               if (var29 > 255) {
                  var29 = 255;
               }

               if (var29 < 0) {
                  var29 = 0;
               }

               Color var31 = new Color(var25, var27, var29);
               var3[var9 + var10 * 670] = var31.getRGB();
            }
         }
      }

      this.carsbgc = this.createImage(new MemoryImageSource(670, 400, var3, 0, 670));
   }

   public void carsbginflex() {
      if (!this.badmac) {
         this.flatr = 0;
         this.flyr = (int)(this.m.random() * 160.0F - 80.0F);
         this.flyrdest = (int)(this.flyr + this.m.random() * 160.0F - 80.0F);
         this.flang = 1;
         this.flexpix = new int[268000];
         PixelGrabber var1 = new PixelGrabber(this.carsbg, 0, 0, 670, 400, this.flexpix, 0, 670);

         try {
            var1.grabPixels();
         } catch (InterruptedException var3) {
         }
      }
   }

   public void drawSmokeCarsbg() {
      if (!this.badmac) {
         if (Math.abs(this.flyr - this.flyrdest) > 20) {
            if (this.flyr > this.flyrdest) {
               this.flyr -= 20;
            } else {
               this.flyr += 20;
            }
         } else {
            this.flyr = this.flyrdest;
            this.flyrdest = (int)(this.flyr + this.m.random() * 160.0F - 80.0F);
         }

         if (this.flyr > 160) {
            this.flyr = 160;
         }

         if (this.flatr > 170) {
            this.flatrstart++;
            this.flatr = this.flatrstart * 3;
            this.flyr = (int)(this.m.random() * 160.0F - 80.0F);
            this.flyrdest = (int)(this.flyr + this.m.random() * 160.0F - 80.0F);
            this.flang = 1;
         }

         for (int var1 = 0; var1 < 466; var1++) {
            for (int var2 = 0; var2 < 202; var2++) {
               if (this.smokey[var1 + var2 * 466] != this.smokey[0]) {
                  float var3 = this.pys(var1, 233, var2, this.flyr);
                  int var4 = (int)((var1 - 233) / var3 * this.flatr);
                  int var5 = (int)((var2 - this.flyr) / var3 * this.flatr);
                  int var6 = var1 + var4 + 100 + (var2 + var5 + 110) * 670;
                  if (var1 + var4 + 100 < 670 && var1 + var4 + 100 > 0 && var2 + var5 + 110 < 400 && var2 + var5 + 110 > 0 && var6 < 268000 && var6 >= 0) {
                     Color var7 = new Color(this.flexpix[var6]);
                     Color var8 = new Color(this.smokey[var1 + var2 * 466]);
                     float var9 = (255.0F - var8.getRed()) / 255.0F;
                     float var10 = (255.0F - var8.getGreen()) / 255.0F;
                     float var11 = (255.0F - var8.getBlue()) / 255.0F;
                     int var12 = (int)((var7.getRed() * (this.flang * var9) + var8.getRed() * (1.0F - var9)) / (this.flang * var9 + (1.0F - var9)));
                     int var13 = (int)((var7.getGreen() * (this.flang * var10) + var8.getGreen() * (1.0F - var10)) / (this.flang * var10 + (1.0F - var10)));
                     int var14 = (int)((var7.getBlue() * (this.flang * var11) + var8.getBlue() * (1.0F - var11)) / (this.flang * var11 + (1.0F - var11)));
                     if (var12 > 255) {
                        var12 = 255;
                     }

                     if (var12 < 0) {
                        var12 = 0;
                     }

                     if (var13 > 255) {
                        var13 = 255;
                     }

                     if (var13 < 0) {
                        var13 = 0;
                     }

                     if (var14 > 255) {
                        var14 = 255;
                     }

                     if (var14 < 0) {
                        var14 = 0;
                     }

                     Color var15 = new Color(var12, var13, var14);
                     this.flexpix[var6] = var15.getRGB();
                  }
               }
            }
         }

         this.flang += 2;
         this.flatr = this.flatr + 10 + this.flatrstart * 2;
         Image var16 = this.createImage(new MemoryImageSource(670, 400, this.flexpix, 0, 670));
         this.rd.drawImage(var16, 65, 25, null);
      } else {
         this.rd.drawImage(this.carsbg, 65, 25, null);
         this.flatrstart++;
      }
   }

   public boolean msgcheck(String var1) {
      boolean var2 = false;
      var1 = var1.toLowerCase();
      String[] var3 = new String[]{
         "fu ",
         " rape",
         "slut ",
         "screw ",
         "redtube",
         "fuck",
         "fuk",
         "f*ck",
         "fu*k",
         "f**k",
         "ass hole",
         "asshole",
         "dick",
         "dik",
         "cock",
         "cok ",
         "shit",
         "damn",
         "sex",
         "anal",
         "whore",
         "bitch",
         "biatch",
         "bich",
         " ass",
         "bastard",
         "cunt",
         "dildo",
         "fag",
         "homo",
         "mothaf",
         "motherf",
         "negro",
         "nigga",
         "nigger",
         "pussy",
         "gay",
         "homo",
         "you punk",
         "i will kill you"
      };

      for (int var4 = 0; var4 < var3.length; var4++) {
         if (var1.indexOf(var3[var4]) != -1) {
            var2 = true;
         }
      }

      if (var1.startsWith("ass ")) {
         var2 = true;
      }

      if (var1.equals("ass")) {
         var2 = true;
      }

      if (var1.equals("rape")) {
         var2 = true;
      }

      if (var1.equals("fu")) {
         var2 = true;
      }

      String var11 = "";
      String var5 = "";
      int var6 = 0;
      boolean var7 = false;

      boolean var8;
      for (var8 = false; var6 < var1.length() && !var8; var6++) {
         if (!var7) {
            var11 = var11 + "" + var1.charAt(var6);
            var7 = true;
         } else {
            var7 = false;
            if (!var5.equals("") && !var5.equals("" + var1.charAt(var6))) {
               var8 = true;
            }

            var5 = "" + var1.charAt(var6);
         }
      }

      if (!var8) {
         for (int var9 = 0; var9 < var3.length; var9++) {
            if (var11.indexOf(var3[var9]) != -1) {
               var2 = true;
            }
         }
      }

      var11 = "";
      var5 = "";
      var6 = 0;
      var7 = true;

      for (var8 = false; var6 < var1.length() && !var8; var6++) {
         if (!var7) {
            var11 = var11 + "" + var1.charAt(var6);
            var7 = true;
         } else {
            var7 = false;
            if (!var5.equals("") && !var5.equals("" + var1.charAt(var6))) {
               var8 = true;
            }

            var5 = "" + var1.charAt(var6);
         }
      }

      if (!var8) {
         for (int var32 = 0; var32 < var3.length; var32++) {
            if (var11.indexOf(var3[var32]) != -1) {
               var2 = true;
            }
         }
      }

      var11 = "";
      var5 = "";
      var6 = 0;
      int avar7 = 0;

      for (var8 = false; var6 < var1.length() && !var8; var6++) {
         if (avar7 == 0) {
            var11 = var11 + "" + var1.charAt(var6);
            avar7 = 2;
         } else {
            avar7--;
            if (!var5.equals("") && !var5.equals("" + var1.charAt(var6))) {
               var8 = true;
            }

            var5 = "" + var1.charAt(var6);
         }
      }

      if (!var8) {
         for (int var33 = 0; var33 < var3.length; var33++) {
            if (var11.indexOf(var3[var33]) != -1) {
               var2 = true;
            }
         }
      }

      var11 = "";
      var5 = "";
      var6 = 0;
      avar7 = 1;

      for (var8 = false; var6 < var1.length() && !var8; var6++) {
         if (avar7 == 0) {
            var11 = var11 + "" + var1.charAt(var6);
            avar7 = 2;
         } else {
            avar7--;
            if (!var5.equals("") && !var5.equals("" + var1.charAt(var6))) {
               var8 = true;
            }

            var5 = "" + var1.charAt(var6);
         }
      }

      if (!var8) {
         for (int var34 = 0; var34 < var3.length; var34++) {
            if (var11.indexOf(var3[var34]) != -1) {
               var2 = true;
            }
         }
      }

      var11 = "";
      var5 = "";
      var6 = 0;
      avar7 = 2;

      for (var8 = false; var6 < var1.length() && !var8; var6++) {
         if (avar7 == 0) {
            var11 = var11 + "" + var1.charAt(var6);
            avar7 = 2;
         } else {
            avar7--;
            if (!var5.equals("") && !var5.equals("" + var1.charAt(var6))) {
               var8 = true;
            }

            var5 = "" + var1.charAt(var6);
         }
      }

      if (!var8) {
         for (int var35 = 0; var35 < var3.length; var35++) {
            if (var11.indexOf(var3[var35]) != -1) {
               var2 = true;
            }
         }
      }

      return var2;
   }

   public boolean drawcarb(boolean var1, Image var2, String var3, int var4, int var5, int var6, int var7, boolean var8) {
      boolean var9 = false;
      int var10 = 0;
      this.rd.setFont(new Font("Arial", 1, 13));
      this.ftm = this.rd.getFontMetrics();
      if (var1) {
         var10 = this.ftm.stringWidth(var3);
         if (var3.startsWith("Class")) {
            var10 = 112;
         }
      } else {
         var10 = var2.getWidth(this.ob);
      }

      byte var11 = 0;
      if (var6 > var4 && var6 < var4 + var10 + 14 && var7 > var5 && var7 < var5 + 28) {
         var11 = 1;
         if (var8) {
            var9 = true;
         }
      }

      this.rd.drawImage(this.bcl[var11], var4, var5, null);
      this.rd.drawImage(this.bc[var11], var4 + 4, var5, var10 + 6, 28, null);
      this.rd.drawImage(this.bcr[var11], var4 + var10 + 10, var5, null);
      if (!var1 && var10 == 73) {
         var5--;
      }

      if (var1) {
         if (var3.equals("X") && var11 == 1) {
            this.rd.setColor(new Color(255, 0, 0));
         } else {
            this.rd.setColor(new Color(0, 0, 0));
         }

         if (var3.startsWith("Class")) {
            this.rd.drawString(var3, 400 - this.ftm.stringWidth(var3) / 2, var5 + 19);
         } else {
            this.rd.drawString(var3, var4 + 7, var5 + 19);
         }
      } else {
         this.rd.drawImage(var2, var4 + 7, var5 + 7, null);
      }

      return var9;
   }

   public void drawWarning() {
      this.rd.setColor(new Color(0, 0, 0));
      this.rd.fillRect(0, 0, 800, 450);
      this.rd.setFont(new Font("Arial", 1, 22));
      this.ftm = this.rd.getFontMetrics();
      this.drawcs(100, "Warning!", 255, 0, 0, 3);
      this.rd.setFont(new Font("Arial", 1, 18));
      this.ftm = this.rd.getFontMetrics();
      this.drawcs(150, "Bad language and flooding is strictly prohibited in this game!", 255, 255, 255, 3);
      this.rd.setFont(new Font("Arial", 1, 13));
      this.ftm = this.rd.getFontMetrics();
      if (this.warning < 210) {
         this.drawcs(200, "If you continue typing bad language or flooding your game will shut down.", 200, 200, 200, 3);
      }

      if (this.warning > 210) {
         this.drawcs(200, "Sorry. This was your second warring your game has shut down.", 200, 200, 200, 3);
      }

      if (this.warning > 250) {
         this.stopallnow();
         this.runtyp = 0;
         this.app.repaint();
         this.app.gamer.stop();
      }
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
}
