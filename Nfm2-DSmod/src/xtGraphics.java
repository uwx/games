import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.awt.image.MemoryImageSource;
import java.awt.image.PixelGrabber;
import java.io.DataInputStream;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class xtGraphics extends Panel implements Runnable {
   int spl = 0;
   Image dslog;
   Graphics rd;
   Medium m;
   FontMetrics ftm;
   ImageObserver ob;
   Applet app;
   int fase;
   int oldfase;
   int starcnt;
   int unlocked;
   int lockcnt;
   int opselect;
   boolean shaded;
   int flipo;
   boolean nextc;
   int gatey;
   int looped;
   int[] sc;
   int[] xstart = new int[]{0, -350, 350, 0, -350, 350, 0};
   int[] zstart = new int[]{-760, -380, -380, 0, 380, 380, 760};
   float[] proba = new float[]{0.6F, 0.7F, 0.4F, 0.3F, 0.8F, 0.0F, 0.3F, 0.3F, 0.3F, 0.1F, 0.1F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F};
   float[] dishandle = new float[]{0.65F, 0.6F, 0.55F, 0.77F, 0.62F, 0.9F, 0.6F, 0.72F, 0.45F, 0.8F, 0.95F, 0.4F, 0.87F, 0.42F, 1.0F, 0.95F};
   float[] outdam = new float[]{0.67F, 0.35F, 0.8F, 0.5F, 0.42F, 0.76F, 0.82F, 0.76F, 0.72F, 0.62F, 0.79F, 0.95F, 0.77F, 1.0F, 0.85F, 1.0F};
   boolean holdit;
   int holdcnt;
   boolean winner;
   int[] flexpix;
   int[] smokey;
   Image fleximg;
   int flatrstart;
   Thread runner;
   int runtyp;
   Image odmg;
   Image opwr;
   Image opos;
   Image owas;
   Image olap;
   Image oyourwasted;
   Image oyoulost;
   Image oyouwon;
   Image oyouwastedem;
   Image ogameh;
   Image oloadingmusic;
   Image oflaot;
   Image dmg;
   Image pwr;
   Image pos;
   Image was;
   Image lap;
   Image br;
   Image select;
   Image loadingmusic;
   Image yourwasted;
   Image youlost;
   Image youwon;
   Image youwastedem;
   Image gameh;
   Image congrd;
   Image gameov;
   Image carsbg;
   Image pgate;
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
   Image opback;
   Image nfmcoms;
   Image opti;
   Image bgmain;
   Image rpro;
   Image nfmcom;
   Image flaot;
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
   Image kp;
   Image km;
   Image kn;
   Image kenter;
   Image nfm;
   Image[][] trackbg;
   Image[] dude;
   int duds;
   int dudo;
   Image[] next;
   Image[] back;
   Image[] contin;
   Image[] ostar;
   Image[] star;
   int pcontin;
   int pnext;
   int pback;
   int pstar;
   Image[] orank;
   Image[] rank;
   Image[] ocntdn;
   Image[] cntdn;
   int gocnt;
   AudioClip[][] engs;
   boolean[] pengs;
   int[] enginsignature = new int[]{0, 1, 2, 1, 0, 3, 2, 2, 1, 0, 3, 4, 1, 4, 0, 3};
   AudioClip[] air;
   boolean aird;
   boolean grrd;
   AudioClip[] crash;
   AudioClip[] lowcrash;
   AudioClip tires;
   AudioClip checkpoint;
   AudioClip carfixed;
   AudioClip powerup;
   AudioClip three;
   AudioClip two;
   AudioClip one;
   AudioClip go;
   AudioClip wastd;
   AudioClip firewasted;
   AudioClip warnp;
   boolean pwastd;
   AudioClip[] skid;
   AudioClip[] dustskid;
   boolean mutes;
   RadicalMod stages;
   RadicalMod cars;
   RadicalMod[] stracks;
   boolean[] loadedt;
   int lastload;
   boolean mutem;
   boolean sunny;
   boolean macn;
   boolean arrace;
   int ana;
   int cntan;
   int cntovn;
   boolean flk;
   int tcnt;
   boolean tflk;
   String say;
   boolean wasay;
   int clear;
   int posit;
   int wasted;
   int laps;
   int[] dested;
   String[] names = new String[]{
      "Tornado Shark",
      "Formula Zero",
      "Ground Jeep",
      "La Vite Crab",
      "Mr. Tico",
      "MAD Revenge",
      "Lead Oxide",
      "Fireky Cadillac",
      "Drifter Z",
      "Sword of Justice",
      "Low Rider",
      "Armoured King",
      "Mighty Eight",
      "DS Wasting Machine",
      "The Radical One",
      "DR Monstaa"
   };
   String[] shortnam = new String[]{
      "T-Shark",
      "F-Zero",
      "Ground Jeep",
      "La Vite Crab",
      "Mr. Tico",
      "MAD Revenge",
      "Lead Oxide",
      "FireCad",
      "Drifter Z",
      "SoJ",
      "Low Rider",
      "A-King",
      "Mighty Eight",
      "DS W-Machine",
      "Radical One",
      "DR Monstaa"
   };
   int dmcnt;
   boolean dmflk;
   int pwcnt;
   boolean pwflk;
   String[][] adj = new String[][]{
      {"Cool", "Alright", "Nice"},
      {"Wicked", "Amazing", "Super"},
      {"Awesome", "Crazy", "Radical"},
      {"What the...?", "That was trully awesome!", "How do you do that?"},
      {"surf style", "off the lip", "bounce back"}
   };
   String[] exlm = new String[]{"!", "!!", "!!!"};
   String loop;
   String spin;
   String asay;
   int auscnt;
   boolean aflk;
   int[] sndsize = new int[]{36, 36, 31, 153, 153, 141, 41, 110, 152, 103, 104, 66, 53, 136, 175, 128, 145};
   Image hello;
   Image sign;
   Image loadbar;
   int kbload;
   int dnload;
   float shload;
   int radpx;
   int pin;
   int[] bgmy = new int[]{0, 400};
   int[] trkx = new int[]{0, 670};
   int trkl;
   int trklim;
   float[] hipno = new float[]{1.0F, 1.0F, 3.0F, 1.0F, 1.2F, 1.0F, 1.7F, 1.0F, 1.0F, 8.0F, 1.5F, 2.0F, 1.2F, 10.0F, 1.8F, 1.4F, 2.0F};
   int flkat;
   int movly;
   int xdu;
   int ydu;
   int gxdu;
   int gydu;
   int[] pgatx = new int[]{146, 175, 215, 267, 334, 401, 452, 493, 521};
   int[] pgaty = new int[]{168, 188, 201, 212, 219, 214, 203, 189, 171};
   int[] pgady;
   boolean[] pgas;
   int lxm;
   int lym;
   int pwait;
   int stopcnt;
   int cntwis;
   int crshturn;
   int bfcrash;
   int bfskid;
   boolean crashup;
   boolean skidup;
   int skflg;
   int dskflg;
   int flatr;
   int flyr;
   int flyrdest;
   int flang;
   int flangados;
   float blackn;
   float blacknados;
   String[] sndtrck = new String[]{
      "DragShot - Saxorush",
      "Xenox - Technostyle III",
      "Badlands",
      "Mystic - Infection 2",
      "Raymon Braumuller - Intex",
      "Paminaro",
      "Cold Fury (DSmix)",
      "Between the eyes",
      "Adrenochrome (nfmMix)",
      "Death-angel (DSmix)",
      "Destruct",
      "Winds (nfmMix)",
      "Ace/Copperteam - Space walk",
      "Johan Claesson - Legendaric",
      "Laxical&ACME - Veiled Sky",
      "Future Dimension",
      "DragShot - DS Electro Party"
   };
   float pre_speed = 0.0F;

   public boolean over(Image image, int i, int j, int k, int l) {
      int i1 = image.getHeight(this.ob);
      int j1 = image.getWidth(this.ob);
      return i > k - 5 && i < k + j1 + 5 && j > l - 5 && j < l + i1 + 5;
   }

   public void cantgo(Control control) {
      this.pnext = 0;
      this.trackbg(false);
      this.rd.setFont(new Font("SansSerif", 1, 13));
      this.ftm = this.rd.getFontMetrics();
      this.drawcs(110, "This stage will be unlocked when stage " + this.unlocked + " is complete!", 177, 177, 177, 3);
      int i = 0;

      do {
         this.rd.drawImage(this.pgate, 212 + i * 30, 190, null);
      } while (++i < 9);

      this.rd.setFont(new Font("SansSerif", 1, 11));
      this.ftm = this.rd.getFontMetrics();
      if (this.aflk) {
         this.drawcs(160, "[ Stage " + (this.unlocked + 1) + " Locked ]", 255, 128, 0, 3);
         this.aflk = false;
      } else {
         this.drawcs(160, "[ Stage " + (this.unlocked + 1) + " Locked ]", 255, 0, 0, 3);
         this.aflk = true;
      }

      this.rd.drawImage(this.select, 273, 45, null);
      this.rd.drawImage(this.br, 0, 0, null);
      this.rd.drawImage(this.back[this.pback], 305, 320, null);
      this.rd.setFont(new Font("SansSerif", 1, 11));
      this.ftm = this.rd.getFontMetrics();
      this.drawcs(396, "You can also use Keyboard Arrows and Enter to navigate.", 82, 90, 0, 3);
      this.lockcnt--;
      if (this.lockcnt == 0 || control.enter || control.handb || control.left) {
         control.left = false;
         control.handb = false;
         control.enter = false;
         this.fase = 1;
      }
   }

   public void loadingstage(int i) {
      this.trackbg(true);
      this.rd.setColor(new Color(177, 177, 177));
      this.rd.fillRoundRect(200, 150, 270, 52, 20, 40);
      this.rd.setColor(new Color(120, 120, 120));
      this.rd.drawRoundRect(200, 150, 270, 52, 20, 40);
      this.rd.setFont(new Font("SansSerif", 1, 13));
      this.ftm = this.rd.getFontMetrics();
      this.drawcs(180, "Loading Stage " + i + ", please wait...", 0, 0, 0, 3);
      this.rd.drawImage(this.select, 273, 45, null);
      this.rd.drawImage(this.br, 0, 0, null);
      this.rd.setFont(new Font("SansSerif", 1, 11));
      this.ftm = this.rd.getFontMetrics();
      this.drawcs(396, "You can also use Keyboard Arrows and Enter to navigate.", 82, 90, 0, 3);
      this.app.repaint();
      if (this.stages.loaded == 1) {
         this.stages.loadMod(135, 7800, 125, this.sunny, this.macn);
         this.stages.play();
      }

      if (this.stages.loaded == 2 && !this.stages.playing) {
         this.stages.play();
      }
   }

   public void inst(Control control) {
      if (this.flipo == 0) {
         this.flipo = 1;
         this.bgmy[0] = 0;
         this.bgmy[1] = 400;
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

      int i = 0;

      do {
         this.rd.drawImage(this.bgmain, 0, this.bgmy[i], null);
         this.bgmy[i] = this.bgmy[i] - 2;
         if (this.bgmy[i] <= -400) {
            this.bgmy[i] = 400;
         }
      } while (++i < 2);

      if (this.aflk) {
         this.aflk = false;
      } else {
         this.aflk = true;
      }

      if (this.flipo != 1) {
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

         this.rd.drawImage(this.dude[this.duds], 30, -10, null);
         this.rd.drawImage(this.oflaot, 127, 17, null);
      }

      this.rd.setColor(new Color(0, 0, 0));
      this.rd.setFont(new Font("SansSerif", 1, 13));
      if (this.flipo == 3 || this.flipo == 5) {
         if (this.flipo == 3) {
            this.rd.drawString("Hello!  Welcome to the world of", 197, 42);
            this.rd.drawString("!", 592, 42);
            this.rd.drawImage(this.nfm, 404, 30, null);
            this.rd.drawString("In this game there are two ways to complete a stage.", 197, 82);
            this.rd.drawString("One is by racing and finishing in first place, the other is by", 197, 102);
            this.rd.drawString("wasting and crashing all the other cars in the stage!", 197, 122);
         } else {
            this.rd.setColor(new Color(100, 100, 100));
            this.rd.drawString("While racing, you will need to focus on going fast and passing", 197, 42);
            this.rd.drawString("through all the checkpoints in the track. To complete a lap, you", 197, 62);
            this.rd.drawString("must not miss a checkpoint.", 197, 82);
            this.rd.drawString("While wasting, you will just need to chase the other cars and", 197, 102);
            this.rd.drawString("crash into them (without worrying about track and checkpoints).", 197, 122);
            this.rd.setColor(new Color(0, 0, 0));
         }

         this.rd.drawImage(this.racing, 100, 160, null);
         this.rd.drawImage(this.ory, 364, 210, null);
         this.rd.drawImage(this.wasting, 427, 160, null);
         this.rd.setFont(new Font("SansSerif", 1, 11));
         this.rd.drawString("Checkpoint", 327, 164);
         this.rd.setFont(new Font("SansSerif", 1, 13));
         this.rd.drawString("Drive your car using the Arrow Keys and Spacebar :", 60, 295);
         this.rd.drawImage(this.space, 106, 330, null);
         this.rd.drawImage(this.arrows, 440, 298, null);
         this.rd.setFont(new Font("SansSerif", 1, 11));
         this.rd.drawString("(When your car is on the ground Spacebar is for Handbrake)", 60, 316);
         this.rd.drawString("Accelerate", 450, 294);
         this.rd.drawString("Brake/Reverse", 441, 372);
         this.rd.drawString("Turn left", 389, 350);
         this.rd.drawString("Turn right", 525, 350);
         this.rd.drawString("Handbrake", 182, 349);
      }

      if (this.flipo == 7 || this.flipo == 9) {
         if (this.flipo == 7) {
            this.rd.drawString("Whether you are racing or wasting the other cars you will need", 197, 42);
            this.rd.drawString("to power up your car.", 197, 62);
            this.rd.drawString("=> More 'Power' makes your car become faster and stronger!", 197, 82);
            this.rd.drawString("To power up your car (and keep it powered up) you will need to", 197, 102);
            this.rd.drawString("perform stunts!", 197, 122);
            this.rd.drawImage(this.chil, 102, 270, null);
         } else {
            this.rd.drawString("The better the stunt the more power you get!", 197, 42);
            this.rd.setColor(new Color(100, 100, 100));
            this.rd.drawString("Forward looping pushes your car forwards in the air and helps", 197, 62);
            this.rd.drawString("when racing. Backward looping pushes your car upwards giving it", 197, 82);
            this.rd.drawString("more hang time in the air making it easier to control its landing.", 197, 102);
            this.rd.drawString("Left and right rolls shift your car in the air left and right slightly.", 197, 122);
            if (this.aflk || this.dudo < 150) {
               this.rd.drawImage(this.chil, 102, 270, null);
            }

            this.rd.setColor(new Color(0, 0, 0));
         }

         this.rd.drawImage(this.stunts, 40, 150, null);
         this.rd.drawImage(this.opwr, 475, 228, null);
         this.rd.setFont(new Font("SansSerif", 1, 13));
         this.rd.drawString("To perform stunts. When your car is in the AIR;", 60, 285);
         this.rd.drawString("Press combo Spacebar + Arrow Keys :", 60, 305);
         this.rd.drawImage(this.space, 120, 330, null);
         this.rd.drawImage(this.plus, 340, 333, null);
         this.rd.drawImage(this.arrows, 426, 298, null);
         this.rd.setFont(new Font("SansSerif", 1, 11));
         this.rd.setColor(new Color(0, 0, 0));
         this.rd.drawString("Forward Loop", 427, 294);
         this.rd.drawString("Backward Loop", 425, 372);
         this.rd.drawString("Left Roll", 378, 350);
         this.rd.drawString("Right Roll", 511, 350);
         this.rd.drawString("Spacebar", 201, 349);
         this.rd.setColor(new Color(140, 243, 244));
         this.rd.fillRect(537, 232, 76, 9);
      }

      if (this.flipo == 11 || this.flipo == 13) {
         if (this.flipo == 11) {
            this.rd.drawString("When wasting cars, to help you find the other cars in the stage,", 197, 42);
            this.rd.drawString("press [ A ] to toggle the guidance arrow from pointing to the track", 197, 62);
            this.rd.drawString("to pointing to the cars.", 197, 82);
            this.rd.drawString("When your car is damaged. You fix it (and reset its 'Damage') by", 197, 102);
            this.rd.drawString("jumping through the electrified hoop.", 197, 122);
         } else {
            this.rd.setColor(new Color(100, 100, 100));
            this.rd.drawString("You will find that in some stages it's easier to waste the other cars", 197, 42);
            this.rd.drawString("and in some others it's easier to race and finish in first place.", 197, 62);
            this.rd.drawString("It is up to you to decide when to waste and when to race.", 197, 82);
            this.rd.drawString("And remember, 'Power' is an important factor in the game. You", 197, 102);
            this.rd.drawString("will need it whether you are racing or wasting!", 197, 122);
            this.rd.setColor(new Color(0, 0, 0));
         }

         this.rd.drawImage(this.fixhoop, 120, 193, null);
         this.rd.drawImage(this.sarrow, 320, 203, null);
         this.rd.setFont(new Font("SansSerif", 1, 11));
         this.rd.drawString("The Electrified Hoop", 127, 191);
         this.rd.drawString("Jumping through it fixes your car.", 93, 313);
         this.rd.drawString("Make guidance arrow point to cars.", 320, 191);
      }

      if (this.flipo == 15) {
         this.rd.drawString("There is a total of 17 stages!", 197, 42);
         this.rd.drawString("Every two stages completed a new car will be unlocked!", 197, 62);
         this.rd.drawString("I am Coach Insano by the way.", 197, 102);
         this.rd.drawString("I am your coach and narrator in this game!  Good Luck!", 197, 122);
         this.rd.drawString("Other Controls :", 90, 180);
         this.rd.setFont(new Font("SansSerif", 1, 11));
         this.rd.drawImage(this.kz, 100, 200, null);
         this.rd.drawString("OR", 141, 226);
         this.rd.drawImage(this.kx, 160, 200, null);
         this.rd.drawString("=> To look behind you while driving.", 202, 226);
         this.rd.drawImage(this.kv, 100, 250, null);
         this.rd.drawString("Change Views", 142, 276);
         this.rd.drawImage(this.kp, 100, 300, null);
         this.rd.drawString("OR", 141, 326);
         this.rd.drawImage(this.kenter, 160, 300, null);
         this.rd.drawString("Pause Game", 287, 326);
         this.rd.drawImage(this.km, 420, 200, null);
         this.rd.drawString("Mute Music", 462, 226);
         this.rd.drawImage(this.kn, 420, 250, null);
         this.rd.drawString("Mute Sound Effects", 462, 276);
      }

      if (this.flipo == 1) {
         this.rd.setFont(new Font("SansSerif", 1, 13));
         this.ftm = this.rd.getFontMetrics();
         this.drawcs(20, "Main Game Controls", 0, 0, 0, 3);
         this.rd.drawString("Drive your car using the Arrow Keys:", 60, 55);
         this.rd.drawString("On the GROUND Spacebar is for Handbrake", 60, 76);
         this.rd.drawImage(this.space, 106, 90, null);
         this.rd.drawImage(this.arrows, 440, 58, null);
         this.rd.setFont(new Font("SansSerif", 1, 11));
         this.ftm = this.rd.getFontMetrics();
         this.rd.drawString("Accelerate", 450, 54);
         this.rd.drawString("Brake/Reverse", 441, 132);
         this.rd.drawString("Turn left", 389, 110);
         this.rd.drawString("Turn right", 525, 110);
         this.rd.drawString("Handbrake", 182, 109);
         this.drawcs(
            150,
            "----------------------------------------------------------------------------------------------------------------------------------------------------",
            0,
            0,
            0,
            3
         );
         this.rd.setFont(new Font("SansSerif", 1, 13));
         this.ftm = this.rd.getFontMetrics();
         this.rd.drawString("To perform stunts:", 60, 175);
         this.rd.drawString("In the AIR press combo Spacebar + Arrow Keys :", 60, 195);
         this.rd.drawImage(this.space, 120, 220, null);
         this.rd.drawImage(this.plus, 340, 223, null);
         this.rd.drawImage(this.arrows, 426, 188, null);
         this.rd.setFont(new Font("SansSerif", 1, 11));
         this.ftm = this.rd.getFontMetrics();
         this.rd.setColor(new Color(0, 0, 0));
         this.rd.drawString("Forward Loop", 427, 184);
         this.rd.drawString("Backward Loop", 425, 262);
         this.rd.drawString("Left Roll", 378, 240);
         this.rd.drawString("Right Roll", 511, 240);
         this.rd.drawString("Spacebar", 201, 239);
         this.rd.drawImage(this.stunts, 60, 260, null);
      }

      if (this.flipo >= 1 && this.flipo <= 13) {
         this.rd.drawImage(this.next[this.pnext], 600, 370, null);
      }

      if (this.flipo >= 3 && this.flipo <= 15) {
         this.rd.drawImage(this.back[this.pback], 10, 370, null);
      }

      if (this.flipo == 15) {
         this.rd.drawImage(this.contin[this.pcontin], 500, 370, null);
      }

      if (control.enter || control.right) {
         if (this.flipo >= 1 && this.flipo <= 13) {
            this.flipo++;
         }

         if (control.enter && this.flipo == 15) {
            this.flipo = 0;
            this.fase = this.oldfase;
            this.rd.setFont(new Font("SansSerif", 1, 11));
            this.ftm = this.rd.getFontMetrics();
         }

         control.enter = false;
         control.right = false;
      }

      if (control.left) {
         if (this.flipo >= 3 && this.flipo <= 15) {
            this.flipo -= 3;
         }

         control.left = false;
      }
   }

   public void fleximage(Image image, int i, int j) {
      if (i == 0) {
         PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, 670, 400, this.flexpix, 0, 670);

         try {
            pixelgrabber.grabPixels();
         } catch (InterruptedException var19) {
         }
      }

      int k = 0;
      int l = 0;
      int i1 = 0;
      int j1 = 0;
      int k1 = (int)(Math.random() * 128.0);
      int l1 = (int)(5.0 + Math.random() * 15.0);
      int i2 = 0;

      do {
         Color color = new Color(this.flexpix[i2]);
         int j2 = 0;
         int k2 = 0;
         int l2 = 0;
         if (k == 0) {
            j2 = color.getRed();
            l = j2;
            k2 = color.getGreen();
            i1 = k2;
            l2 = color.getBlue();
            j1 = l2;
         } else {
            j2 = (int)((color.getRed() + l * 0.38F * i) / (1.0F + 0.38F * i));
            l = j2;
            k2 = (int)((color.getGreen() + i1 * 0.38F * i) / (1.0F + 0.38F * i));
            i1 = k2;
            l2 = (int)((color.getBlue() + j1 * 0.38F * i) / (1.0F + 0.38F * i));
            j1 = l2;
         }

         if (++k == 670) {
            k = 0;
         }

         int i3 = (j2 * 17 + k2 + l2 + k1) / 22;
         int j3 = (k2 * 17 + j2 + l2 + k1) / 22;
         int k3 = (l2 * 17 + j2 + k2 + k1) / 22;
         if (j == 17) {
            i3 = (j2 * 17 + k2 + l2 + k1) / 22;
            j3 = (k2 * 17 + j2 + l2 + k1) / 21;
            k3 = (l2 * 17 + j2 + k2 + k1) / 20;
         }

         if (--l1 == 0) {
            k1 = (int)(Math.random() * 128.0);
            l1 = (int)(5.0 + Math.random() * 15.0);
         }

         Color color1 = new Color(i3, j3, k3);
         this.flexpix[i2] = color1.getRGB();
      } while (++i2 < 268000);

      this.fleximg = this.createImage(new MemoryImageSource(670, 400, this.flexpix, 0, 670));
      this.rd.drawImage(this.fleximg, 0, 0, null);
   }

   public void arrow(int i, int j, CheckPoints checkpoints, boolean flag, Madness madness, boolean skey) {
      int[] ai = new int[7];
      int[] ai1 = new int[7];
      int[] ai2 = new int[7];
      char c = 335;
      byte byte0 = -90;
      char c1 = 700;
      int k = 0;

      do {
         ai1[k] = byte0;
      } while (++k < 7);

      ai[0] = c;
      ai2[0] = c1 + 'n';
      ai[1] = c - '#';
      ai2[1] = c1 + '2';
      ai[2] = c - 15;
      ai2[2] = c1 + '2';
      ai[3] = c - 15;
      ai2[3] = c1 - '2';
      ai[4] = c + 15;
      ai2[4] = c1 - '2';
      ai[5] = c + 15;
      ai2[5] = c1 + '2';
      ai[6] = c + '#';
      ai2[6] = c1 + '2';
      int var25 = 0;
      if (!flag) {
         char c2 = 0;
         if (checkpoints.x[i] - checkpoints.opx[0] >= 0) {
            c2 = 180;
         }

         var25 = (int)('Z' + c2 + Math.atan((double)(checkpoints.z[i] - checkpoints.opz[0]) / (checkpoints.x[i] - checkpoints.opx[0])) / (Math.PI / 180.0));
         this.rd.setColor(new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]));
         if (this.m.flex == 2) {
            this.rd.fillRect(500, 5, 180, 55);
         }

         if (!this.m.darksky) {
            this.rd.setColor(new Color(0, 0, 70));
         } else {
            this.rd.setColor(new Color(100, 100, 170));
         }

         this.rd.drawString("Cleared: ", 500, 15);
         this.rd.drawString("Total: ", 500, 35);
         this.rd.drawString("Pending: ", 500, 55);
         if (!this.m.darksky) {
            this.rd.setColor(new Color(20, 20, 20));
         } else {
            this.rd.setColor(new Color(180, 180, 180));
         }

         this.rd.drawString(madness.clear + " checks", 570, 15);
         this.rd.drawString(checkpoints.nlaps * checkpoints.nsp + " checks", 570, 35);
         this.rd.drawString(checkpoints.nlaps * checkpoints.nsp - madness.clear + " checks", 570, 55);
      } else {
         int l = 0;
         int k1 = -1;
         boolean flag1 = false;
         int l2 = 1;
         DecimalFormat dc = new DecimalFormat("#0.00");

         do {
            if ((this.py(checkpoints.opx[0] / 100, checkpoints.opx[l2] / 100, checkpoints.opz[0] / 100, checkpoints.opz[l2] / 100) < k1 || k1 == -1)
               && (!flag1 || checkpoints.onscreen[l2] != 0)
               && checkpoints.dested[l2] == 0) {
               l = l2;
               k1 = this.py(checkpoints.opx[0] / 100, checkpoints.opx[l2] / 100, checkpoints.opz[0] / 100, checkpoints.opz[l2] / 100);
               if (checkpoints.onscreen[l2] != 0) {
                  flag1 = true;
               }
            }
         } while (++l2 < 7);

         int var44 = 0;
         if (checkpoints.opx[l] - checkpoints.opx[0] >= 0) {
            var44 = 180;
         }

         var25 = (int)(
            90 + var44 + Math.atan((double)(checkpoints.opz[l] - checkpoints.opz[0]) / (checkpoints.opx[l] - checkpoints.opx[0])) / (Math.PI / 180.0)
         );
         this.drawcs(13, "[                                          ]", 76, 67, 240, 0);
         if (checkpoints.stage != 14) {
            this.drawcs(13, this.names[this.sc[l]], 0, 0, 0, 0);
         } else {
            this.drawcs(13, this.names[this.sc[l]], 180, 180, 180, 4);
         }

         this.rd.setColor(new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]));
         if (this.m.flex == 2) {
            this.rd.fillRect(500, 5, 180, 40);
         }

         if (checkpoints.stage != 14) {
            this.rd.setColor(new Color(50, 0, 0));
         } else {
            this.rd.setColor(new Color(150, 50, 50));
         }

         this.rd.drawString("Distance: ", 500, 15);
         if (skey) {
            this.rd.drawString("Positions and Damage:", 500, 49);
         } else {
            this.rd.drawString("Damage:", 500, 49);
            int i_66_ = (int)(60.0F * ((float)GameSparker.mads[l].hitmag / madness.maxmag[this.sc[l]]));
            int i_67_ = 244;
            int i_68_ = 244;
            int i_69_ = 11;
            if (i_66_ > 20) {
               i_68_ = (int)(244.0F - 233.0F * ((i_66_ - 20) / 40.0F));
            }

            i_67_ = (int)(i_67_ + i_67_ * (this.m.snap[0] / 100.0F));
            if (i_67_ > 255) {
               i_67_ = 255;
            }

            if (i_67_ < 0) {
               i_67_ = 0;
            }

            i_68_ = (int)(i_68_ + i_68_ * (this.m.snap[1] / 100.0F));
            if (i_68_ > 255) {
               i_68_ = 255;
            }

            if (i_68_ < 0) {
               i_68_ = 0;
            }

            i_69_ = (int)(i_69_ + i_69_ * (this.m.snap[2] / 100.0F));
            if (i_69_ > 255) {
               i_69_ = 255;
            }

            if (i_69_ < 0) {
               i_69_ = 0;
            }

            this.rd.setColor(new Color(i_67_, i_68_, i_69_));
            this.rd.fillRect(570, 42, i_66_, 5);
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawRect(570, 42, 60, 5);
            i_67_ = (int)(140.0F + 140.0F * (this.m.snap[0] / 100.0F));
            if (i_67_ > 255) {
               i_67_ = 255;
            }

            if (i_67_ < 0) {
               i_67_ = 0;
            }

            i_68_ = (int)(160.0F + 160.0F * (this.m.snap[1] / 100.0F));
            if (i_68_ > 255) {
               i_68_ = 255;
            }

            if (i_68_ < 0) {
               i_68_ = 0;
            }

            i_69_ = (int)(255.0F + 255.0F * (this.m.snap[2] / 100.0F));
            if (i_69_ > 255) {
               i_69_ = 255;
            }

            if (i_69_ < 0) {
               i_69_ = 0;
            }

            this.rd.setColor(new Color(i_67_, i_68_, i_69_));
            this.rd.drawRoundRect(650, 80, 50, 20, 10, 10);
            this.rd.setColor(new Color(100, 120, 255));
            this.rd.drawString("S", 658, 95);
         }

         if (checkpoints.stage != 14) {
            this.rd.setColor(new Color(50, 0, 0));
         } else {
            this.rd.setColor(new Color(150, 50, 50));
         }

         this.rd.drawString("Power: ", 500, 32);
         if (checkpoints.stage != 14) {
            this.rd.setColor(new Color(20, 20, 20));
         } else {
            this.rd.setColor(new Color(180, 180, 180));
         }

         double dist = Math.sqrt(Math.pow(checkpoints.opz[l] - checkpoints.opz[0], 2.0) + Math.pow(checkpoints.opx[l] - checkpoints.opx[0], 2.0));
         this.rd.drawString(dc.format(dist / 100.0).replace(",", ".") + " mts", 570, 15);
         int i_66_x = (int)(60.0F * (GameSparker.mads[l].power / 98.0F));
         int r = 128;
         int i1 = 244;
         int j1 = 244;
         r = (int)(r + r * (this.m.snap[0] / 100.0F));
         if (r > 255) {
            r = 255;
         }

         if (r < 0) {
            r = 0;
         }

         i1 = (int)(i1 + i1 * (this.m.snap[1] / 100.0F));
         if (i1 > 255) {
            i1 = 255;
         }

         if (i1 < 0) {
            i1 = 0;
         }

         j1 = (int)(j1 + j1 * (this.m.snap[2] / 100.0F));
         if (j1 > 255) {
            j1 = 255;
         }

         if (j1 < 0) {
            j1 = 0;
         }

         this.rd.setColor(new Color(r, i1, j1));
         this.rd.fillRect(570, 26, i_66_x, 5);
         this.rd.setColor(new Color(0, 0, 0));
         this.rd.drawRect(570, 26, 60, 5);
      }

      var25 += this.m.xz;

      while (var25 < 0) {
         var25 += 360;
      }

      while (var25 > 180) {
         var25 -= 360;
      }

      if (!flag) {
         if (var25 > 130) {
            var25 = 130;
         }

         if (var25 < -130) {
            var25 = -130;
         }
      } else {
         if (var25 > 100) {
            var25 = 100;
         }

         if (var25 < -100) {
            var25 = -100;
         }
      }

      if (Math.abs(this.ana - var25) < 180) {
         if (Math.abs(this.ana - var25) < 10) {
            this.ana = var25;
         } else if (this.ana < var25) {
            this.ana += 10;
         } else {
            this.ana -= 10;
         }
      } else {
         if (var25 < 0) {
            this.ana += 15;
            if (this.ana > 180) {
               this.ana -= 360;
            }
         }

         if (var25 > 0) {
            this.ana -= 15;
            if (this.ana < -180) {
               this.ana += 360;
            }
         }
      }

      this.rot(ai, ai2, c, c1, this.ana, 7);
      var25 = Math.abs(this.ana);
      if (!flag) {
         if (var25 > 7 || j > 0 || j == -2 || this.cntan != 0) {
            int i1x = 0;

            do {
               ai[i1x] = this.xs(ai[i1x], ai2[i1x]);
               ai1[i1x] = this.ys(ai1[i1x], ai2[i1x]);
            } while (++i1x < 7);

            i1x = (int)(190.0F + 190.0F * (this.m.snap[0] / 100.0F));
            if (i1x > 255) {
               i1x = 255;
            }

            if (i1x < 0) {
               i1x = 0;
            }

            int l1 = (int)(255.0F + 255.0F * (this.m.snap[1] / 100.0F));
            if (l1 > 255) {
               l1 = 255;
            }

            if (l1 < 0) {
               l1 = 0;
            }

            int j2 = 0;
            if (j <= 0) {
               if (var25 <= 45 && j != -2 && this.cntan == 0) {
                  i1x = (i1x * var25 + this.m.csky[0] * (45 - var25)) / 45;
                  l1 = (l1 * var25 + this.m.csky[1] * (45 - var25)) / 45;
                  j2 = (j2 * var25 + this.m.csky[2] * (45 - var25)) / 45;
               }

               if (var25 >= 90) {
                  int i3 = (int)(255.0F + 255.0F * (this.m.snap[0] / 100.0F));
                  if (i3 > 255) {
                     i3 = 255;
                  }

                  if (i3 < 0) {
                     i3 = 0;
                  }

                  i1x = (i1x * (140 - var25) + i3 * (var25 - 90)) / 50;
                  if (i1x > 255) {
                     i1x = 255;
                  }
               }
            } else if (this.flk) {
               i1x = (int)(255.0F + 255.0F * (this.m.snap[0] / 100.0F));
               if (i1x > 255) {
                  i1x = 255;
               }

               if (i1x < 0) {
                  i1x = 0;
               }

               this.flk = false;
            } else {
               i1x = (int)(255.0F + 255.0F * (this.m.snap[0] / 100.0F));
               if (i1x > 255) {
                  i1x = 255;
               }

               if (i1x < 0) {
                  i1x = 0;
               }

               l1 = (int)(220.0F + 220.0F * (this.m.snap[1] / 100.0F));
               if (l1 > 255) {
                  l1 = 255;
               }

               if (l1 < 0) {
                  l1 = 0;
               }

               this.flk = true;
            }

            this.rd.setColor(new Color(i1x, l1, j2));
            this.rd.fillPolygon(ai, ai1, 7);
            i1x = (int)(115.0F + 115.0F * (this.m.snap[0] / 100.0F));
            if (i1x > 255) {
               i1x = 255;
            }

            if (i1x < 0) {
               i1x = 0;
            }

            l1 = (int)(170.0F + 170.0F * (this.m.snap[1] / 100.0F));
            if (l1 > 255) {
               l1 = 255;
            }

            if (l1 < 0) {
               l1 = 0;
            }

            j2 = 0;
            if (j <= 0) {
               if (var25 <= 45 && j != -2 && this.cntan == 0) {
                  i1x = (i1x * var25 + this.m.csky[0] * (45 - var25)) / 45;
                  l1 = (l1 * var25 + this.m.csky[1] * (45 - var25)) / 45;
                  j2 = (j2 * var25 + this.m.csky[2] * (45 - var25)) / 45;
               }
            } else if (this.flk) {
               i1x = (int)(255.0F + 255.0F * (this.m.snap[0] / 100.0F));
               if (i1x > 255) {
                  i1x = 255;
               }

               if (i1x < 0) {
                  i1x = 0;
               }

               l1 = 0;
            }

            this.rd.setColor(new Color(i1x, l1, j2));
            this.rd.drawPolygon(ai, ai1, 7);
         }
      } else {
         int j1x = 0;

         do {
            ai[j1x] = this.xs(ai[j1x], ai2[j1x]);
            ai1[j1x] = this.ys(ai1[j1x], ai2[j1x]);
         } while (++j1x < 7);

         j1x = (int)(159.0F + 159.0F * (this.m.snap[0] / 100.0F));
         if (j1x > 255) {
            j1x = 255;
         }

         if (j1x < 0) {
            j1x = 0;
         }

         int i2 = (int)(207.0F + 207.0F * (this.m.snap[1] / 100.0F));
         if (i2 > 255) {
            i2 = 255;
         }

         if (i2 < 0) {
            i2 = 0;
         }

         int k2 = (int)(255.0F + 255.0F * (this.m.snap[2] / 100.0F));
         if (k2 > 255) {
            k2 = 255;
         }

         if (k2 < 0) {
            k2 = 0;
         }

         this.rd.setColor(new Color(j1x, i2, k2));
         this.rd.fillPolygon(ai, ai1, 7);
         j1x = (int)(120.0F + 120.0F * (this.m.snap[0] / 100.0F));
         if (j1x > 255) {
            j1x = 255;
         }

         if (j1x < 0) {
            j1x = 0;
         }

         i2 = (int)(114.0F + 114.0F * (this.m.snap[1] / 100.0F));
         if (i2 > 255) {
            i2 = 255;
         }

         if (i2 < 0) {
            i2 = 0;
         }

         k2 = (int)(255.0F + 255.0F * (this.m.snap[2] / 100.0F));
         if (k2 > 255) {
            k2 = 255;
         }

         if (k2 < 0) {
            k2 = 0;
         }

         this.rd.setColor(new Color(j1x, i2, k2));
         this.rd.drawPolygon(ai, ai1, 7);
      }
   }

   public void levelhigh(int i, int j, int k, int l, int i1) {
      this.rd.drawImage(this.gameh, 236, 20, null);
      byte byte0 = 16;
      char c = '0';
      char c1 = '`';
      if (l < 50) {
         if (this.aflk) {
            byte0 = 106;
            c = 176;
            c1 = 255;
            this.aflk = false;
         } else {
            this.aflk = true;
         }
      }

      if (i != 0) {
         if (k == 0) {
            this.drawcs(60, "You Wasted 'em!", byte0, c, c1, 0);
         } else if (k == 1) {
            this.drawcs(60, "Close Finish!", byte0, c, c1, 0);
         } else {
            this.drawcs(60, "Close Finish!  Almost got it", byte0, c, c1, 0);
         }
      } else if (j == 229) {
         this.drawcs(60, "Wasted!", byte0, c, c1, 0);
      } else if (i1 > 2) {
         this.drawcs(60, "Stunts!", byte0, c, c1, 0);
      } else {
         this.drawcs(60, "Best Stunt!", byte0, c, c1, 0);
      }

      this.drawcs(380, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
   }

   public void playsounds(Madness madness, Control control, int i) {
      if (this.fase == 0 && this.starcnt < 35 && this.cntwis != 8 && !this.mutes) {
         boolean flag = control.up && madness.speed > 0.0F || control.down && madness.speed < 10.0F;
         boolean flag1 = madness.skid == 1 && control.handb
            || Math.abs(madness.scz[0] - (madness.scz[1] + madness.scz[0] + madness.scz[2] + madness.scz[3]) / 4.0F) > 1.0F
            || Math.abs(madness.scx[0] - (madness.scx[1] + madness.scx[0] + madness.scx[2] + madness.scx[3]) / 4.0F) > 1.0F;
         boolean flag2 = false;
         if (control.up && madness.speed < 10.0F) {
            flag1 = true;
            flag = true;
            flag2 = true;
         }

         if (flag && madness.mtouch) {
            if (!madness.capsized) {
               if (!flag1) {
                  if (madness.power != 98.0F) {
                     if (Math.abs(madness.speed) > 0.0F && Math.abs(madness.speed) <= madness.swits[madness.cn][0]) {
                        int j = (int)(3.0F * Math.abs(madness.speed) / madness.swits[madness.cn][0]);
                        if (j == 2) {
                           if (this.pwait == 0) {
                              j = 0;
                           } else {
                              this.pwait--;
                           }
                        } else {
                           this.pwait = 7;
                        }

                        this.sparkeng(j);
                     }

                     if (Math.abs(madness.speed) > madness.swits[madness.cn][0] && Math.abs(madness.speed) <= madness.swits[madness.cn][1]) {
                        int k = (int)(
                           3.0F * (Math.abs(madness.speed) - madness.swits[madness.cn][0]) / (madness.swits[madness.cn][1] - madness.swits[madness.cn][0])
                        );
                        if (k == 2) {
                           if (this.pwait == 0) {
                              k = 0;
                           } else {
                              this.pwait--;
                           }
                        } else {
                           this.pwait = 7;
                        }

                        this.sparkeng(k);
                     }

                     if (Math.abs(madness.speed) > madness.swits[madness.cn][1] && Math.abs(madness.speed) <= madness.swits[madness.cn][2]) {
                        int l = (int)(
                           3.0F * (Math.abs(madness.speed) - madness.swits[madness.cn][1]) / (madness.swits[madness.cn][2] - madness.swits[madness.cn][1])
                        );
                        this.sparkeng(l);
                     }
                  } else {
                     byte byte0 = 2;
                     if (this.pwait == 0) {
                        if (Math.abs(madness.speed) > madness.swits[madness.cn][1]) {
                           byte0 = 3;
                        }
                     } else {
                        this.pwait--;
                     }

                     this.sparkeng(byte0);
                  }
               } else {
                  this.sparkeng(-1);
                  if (flag2) {
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
               this.sparkeng(3);
            }

            this.grrd = false;
            this.aird = false;
         } else {
            this.pwait = 15;
            if (!madness.mtouch && !this.grrd && this.m.random() > 0.4) {
               this.air[(int)(this.m.random() * 4.0F)].loop();
               this.stopcnt = 5;
               this.grrd = true;
            }

            if (!madness.wtouch && !this.aird) {
               this.stopairs();
               this.air[(int)(this.m.random() * 4.0F)].loop();
               this.stopcnt = 10;
               this.aird = true;
            }

            this.sparkeng(-1);
         }

         if (madness.cntdest != 0 && this.cntwis < 7) {
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
         this.sparkeng(-2);
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

      if (this.bfskid != 0) {
         this.bfskid--;
      }

      if (madness.newcar) {
         this.cntwis = 0;
      }

      if (this.fase == 0 || this.fase == 6 || this.fase == -1 || this.fase == -2 || this.fase == -3 || this.fase == -4 || this.fase == -5) {
         if (this.mutes != control.mutes) {
            this.mutes = control.mutes;
         }

         if (control.mutem != this.mutem) {
            this.mutem = control.mutem;
            if (this.mutem) {
               if (this.loadedt[i - 1]) {
                  this.stracks[i - 1].stop();
               }
            } else if (this.loadedt[i - 1]) {
               this.stracks[i - 1].resume();
            }
         }
      }

      if (madness.cntdest != 0 && this.cntwis < 7) {
         if (madness.dest) {
            this.cntwis++;
         }
      } else {
         if (madness.cntdest == 0) {
            this.cntwis = 0;
         }

         if (this.cntwis == 7) {
            this.cntwis = 8;
         }
      }
   }

   public void crash(float f, int i) {
      if (this.bfcrash == 0) {
         if (i == 0) {
            if (Math.abs(f) > 25.0F && Math.abs(f) < 170.0F) {
               if (!this.mutes) {
                  this.lowcrash[this.crshturn].play();
               }

               this.bfcrash = 2;
            }

            if (Math.abs(f) >= 170.0F) {
               if (!this.mutes) {
                  this.crash[this.crshturn].play();
               }

               this.bfcrash = 2;
            }

            if (Math.abs(f) > 25.0F) {
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

         if (i == -1) {
            if (Math.abs(f) > 25.0F && Math.abs(f) < 170.0F) {
               if (!this.mutes) {
                  this.lowcrash[2].play();
               }

               this.bfcrash = 2;
            }

            if (Math.abs(f) > 170.0F) {
               if (!this.mutes) {
                  this.crash[2].play();
               }

               this.bfcrash = 2;
            }
         }

         if (i == 1) {
            if (!this.mutes) {
               this.tires.play();
            }

            this.bfcrash = 3;
         }
      }
   }

   public int ys(int i, int j) {
      if (j < 50) {
         j = 50;
      }

      return (j - this.m.focus_point) * (this.m.cy - i) / j + i;
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

   private Image pressed(Image image) {
      int i = image.getHeight(this.ob);
      int j = image.getWidth(this.ob);
      int[] ai = new int[j * i];
      PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, j, i, ai, 0, j);

      try {
         pixelgrabber.grabPixels();
      } catch (InterruptedException var7) {
      }

      for (int k = 0; k < j * i; k++) {
         if (ai[k] != ai[j * i - 1]) {
            ai[k] = -16777216;
         }
      }

      return this.createImage(new MemoryImageSource(j, i, ai, 0, j));
   }

   private Image dodgen(Image image) {
      int i = image.getHeight(this.ob);
      int j = image.getWidth(this.ob);
      int[] ai = new int[j * i];
      PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, j, i, ai, 0, j);

      try {
         pixelgrabber.grabPixels();
      } catch (InterruptedException var12) {
      }

      for (int k = 0; k < j * i; k++) {
         Color color = new Color(ai[k]);
         int l = color.getRed() * 3 + 90;
         if (l > 255) {
            l = 255;
         }

         if (l < 0) {
            l = 0;
         }

         int i1 = color.getGreen() * 3 + 90;
         if (i1 > 255) {
            i1 = 255;
         }

         if (i1 < 0) {
            i1 = 0;
         }

         int j1 = color.getBlue() * 3 + 90;
         if (j1 > 255) {
            j1 = 255;
         }

         if (j1 < 0) {
            j1 = 0;
         }

         Color color1 = new Color(l, i1, j1);
         ai[k] = color1.getRGB();
      }

      return this.createImage(new MemoryImageSource(j, i, ai, 0, j));
   }

   private void smokeypix(byte[] abyte0, MediaTracker mediatracker, Toolkit toolkit) {
      Image image = toolkit.createImage(abyte0);
      mediatracker.addImage(image, 0);

      try {
         mediatracker.waitForID(0);
      } catch (Exception var8) {
      }

      PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, 466, 202, this.smokey, 0, 466);

      try {
         pixelgrabber.grabPixels();
      } catch (InterruptedException var7) {
      }
   }

   public void stoploading() {
      this.loading();
      this.app.repaint();
      this.runner.stop();
      this.runner = null;
      this.runtyp = 0;
   }

   public void nofocus() {
      this.rd.setColor(new Color(255, 255, 255));
      this.rd.fillRect(0, 0, 670, 20);
      this.rd.fillRect(0, 0, 20, 400);
      this.rd.fillRect(0, 380, 670, 20);
      this.rd.fillRect(650, 0, 20, 400);
      this.rd.setColor(new Color(192, 192, 192));
      this.rd.drawRect(20, 20, 630, 360);
      this.rd.setColor(new Color(0, 0, 0));
      this.rd.drawRect(22, 22, 626, 356);
      this.rd.setFont(new Font("SansSerif", 1, 11));
      this.ftm = this.rd.getFontMetrics();
      this.drawcs(14, "Are you busy? Want a rest?  We'll wait you while you come back.", 100, 100, 100, 3);
      this.drawcs(395, "Game lost its focus.  Click screen with mouse to continue.", 100, 100, 100, 3);
   }

   public void rot(int[] ai, int[] ai1, int i, int j, int k, int l) {
      if (k != 0) {
         for (int i1 = 0; i1 < l; i1++) {
            int j1 = ai[i1];
            int k1 = ai1[i1];
            ai[i1] = i + (int)((j1 - i) * this.m.cos(k) - (k1 - j) * this.m.sin(k));
            ai1[i1] = j + (int)((j1 - i) * this.m.sin(k) + (k1 - j) * this.m.cos(k));
         }
      }
   }

   public boolean overon(int i, int j, int k, int l, int i1, int j1) {
      return i1 > i && i1 < i + k && j1 > j && j1 < j + l;
   }

   public void pauseimage(Image image) {
      PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, 670, 400, this.flexpix, 0, 670);

      try {
         pixelgrabber.grabPixels();
      } catch (InterruptedException var14) {
      }

      int i = 0;
      int j = 0;
      int k = 0;
      int l = 0;
      int i1 = 0;

      do {
         Color color = new Color(this.flexpix[i1]);
         int j1 = 0;
         if (l == 0) {
            j1 = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
            k = j1;
         } else {
            j1 = (color.getRed() + color.getGreen() + color.getBlue() + k * 30) / 33;
            k = j1;
         }

         if (++l == 670) {
            l = 0;
         }

         if (i1 > 670 * (8 + j) + 216 && j < 188) {
            int k1 = (j1 + 60) / 3;
            int l1 = (j1 + 135) / 3;
            int i2 = (j1 + 220) / 3;
            if (++i == 237) {
               j++;
               i = 0;
            }

            Color color2 = new Color(k1, l1, i2);
            this.flexpix[i1] = color2.getRGB();
         } else {
            Color color1 = new Color(j1, j1, j1);
            this.flexpix[i1] = color1.getRGB();
         }
      } while (++i1 < 268000);

      this.fleximg = this.createImage(new MemoryImageSource(670, 400, this.flexpix, 0, 670));
      this.rd.drawImage(this.fleximg, 0, 0, null);
      this.m.flex = 0;
   }

   public void loadmusic(int i, int j) {
      this.hipnoload(i, false);
      this.app.setCursor(new Cursor(3));
      this.app.repaint();
      boolean flag = false;
      if (i == this.unlocked && (i == 1 || i == 2 || i == 3 || i == 4 || i == 7 || i == 8 || i == 9 || i == 10 || i == 12 || i == 13 || i == 16)) {
         flag = true;
      }

      if (flag) {
         this.runtyp = i;
         this.runner = new Thread(this);
         this.runner.start();
      }

      if (!this.loadedt[i - 1]) {
         this.stracks[i - 1] = new RadicalMod("music/stage" + i + ".radq", this.app);
         if (this.stracks[i - 1].loaded == 1) {
            this.loadedt[i - 1] = true;
         }
      }

      if (i == 1) {
         this.stracks[0].loadMod(130, 8000, 125, this.sunny, this.macn);
      }

      if (i == 2) {
         this.stracks[1].loadMod(260, 7200, 125, this.sunny, this.macn);
      }

      if (i == 3) {
         this.stracks[2].loadMod(270, 8000, 125, this.sunny, this.macn);
      }

      if (i == 4) {
         this.stracks[3].loadMod(190, 8000, 125, this.sunny, this.macn);
      }

      if (i == 5) {
         this.stracks[4].loadMod(300, 8000, 125, this.sunny, this.macn);
      }

      if (i == 6) {
         this.stracks[5].loadMod(220, 7900, 125, this.sunny, this.macn);
      }

      if (i == 7) {
         this.stracks[6].loadMod(300, 7500, 125, this.sunny, this.macn);
      }

      if (i == 8) {
         this.stracks[7].loadMod(200, 7900, 125, this.sunny, this.macn);
      }

      if (i == 9) {
         this.stracks[8].loadMod(200, 7900, 125, this.sunny, this.macn);
      }

      if (i == 10) {
         this.stracks[9].loadMod(232, 8100, 125, this.sunny, this.macn);
      }

      if (i == 11) {
         this.stracks[10].loadMod(240, 7900, 125, this.sunny, this.macn);
      }

      if (i == 12) {
         this.stracks[11].loadMod(290, 7900, 125, this.sunny, this.macn);
      }

      if (i == 13) {
         this.stracks[12].loadMod(450, 8100, 125, this.sunny, this.macn);
      }

      if (i == 14) {
         this.stracks[13].loadMod(380, 8000, 125, this.sunny, this.macn);
      }

      if (i == 15) {
         this.stracks[14].loadMod(220, 8000, 125, this.sunny, this.macn);
      }

      if (i == 16) {
         this.stracks[15].loadMod(261, 8000, 125, this.sunny, this.macn);
      }

      if (i == 17) {
         this.stracks[16].loadMod(400, 7600, 125, this.sunny, this.macn);
      }

      if (flag) {
         this.runner.stop();
         this.runner = null;
         this.runtyp = 0;
      }

      System.gc();
      this.lastload = i - 1;
      if (j == 0) {
         if (this.loadedt[i - 1]) {
            this.stracks[i - 1].play();
         }

         this.app.setCursor(new Cursor(0));
         this.fase = 6;
      } else {
         this.fase = 176;
      }

      this.pcontin = 0;
      this.mutem = false;
      this.mutes = false;
   }

   public void loadimages() {
      Toolkit toolkit = Toolkit.getDefaultToolkit();
      MediaTracker mediatracker = new MediaTracker(this.app);
      this.dnload += 12;

      try {
         URL url = new URL(this.app.getCodeBase(), "data/images.radq");
         DataInputStream datainputstream = new DataInputStream(url.openStream());
         ZipInputStream zipinputstream = new ZipInputStream(datainputstream);

         for (ZipEntry zipentry = zipinputstream.getNextEntry(); zipentry != null; zipentry = zipinputstream.getNextEntry()) {
            int i = (int)zipentry.getSize();
            String s = zipentry.getName();
            byte[] abyte0 = new byte[i];
            int j = 0;

            while (i > 0) {
               int k = zipinputstream.read(abyte0, j, i);
               j += k;
               i -= k;
            }

            if (s.equals("dslog.gif")) {
               this.dslog = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("cars.gif")) {
               this.carsbg = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("smokey.gif")) {
               this.smokeypix(abyte0, mediatracker, toolkit);
            }

            if (s.equals("1.gif")) {
               this.orank[0] = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("gameh.gif")) {
               this.ogameh = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("gameov.gif")) {
               this.gameov = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("lap.gif")) {
               this.olap = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("paused.gif")) {
               this.paused = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("select.gif")) {
               this.select = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("yourwasted.gif")) {
               this.oyourwasted = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("youwastedem.gif")) {
               this.oyouwastedem = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("d1.gif")) {
               this.dude[0] = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("d2.gif")) {
               this.dude[1] = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("d3.gif")) {
               this.dude[2] = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("float.gif")) {
               this.oflaot = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("1c.gif")) {
               this.ocntdn[1] = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("2c.gif")) {
               this.ocntdn[2] = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("3c.gif")) {
               this.ocntdn[3] = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("2.gif")) {
               this.orank[1] = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("3.gif")) {
               this.orank[2] = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("4.gif")) {
               this.orank[3] = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("5.gif")) {
               this.orank[4] = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("6.gif")) {
               this.orank[5] = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("7.gif")) {
               this.orank[6] = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("bgmain.jpg")) {
               this.bgmain = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("br.gif")) {
               this.br = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("loadingmusic.gif")) {
               this.oloadingmusic = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("radicalplay.gif")) {
               this.radicalplay = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("back.gif")) {
               this.back[0] = this.loadimage(abyte0, mediatracker, toolkit);
               this.back[1] = this.bressed(this.back[0]);
            }

            if (s.equals("continue2.gif")) {
               this.contin[0] = this.loadimage(abyte0, mediatracker, toolkit);
               this.contin[1] = this.bressed(this.contin[0]);
            }

            if (s.equals("next.gif")) {
               this.next[0] = this.loadimage(abyte0, mediatracker, toolkit);
               this.next[1] = this.bressed(this.next[0]);
            }

            if (s.equals("pgate.gif")) {
               this.pgate = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("rpro.gif")) {
               this.rpro = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("selectcar.gif")) {
               this.selectcar = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("track1.jpg")) {
               this.trackbg[0][0] = this.loadimage(abyte0, mediatracker, toolkit);
               this.trackbg[1][0] = this.dodgen(this.trackbg[0][0]);
            }

            if (s.equals("track2.jpg")) {
               this.trackbg[0][1] = this.loadimage(abyte0, mediatracker, toolkit);
               this.trackbg[1][1] = this.dodgen(this.trackbg[0][1]);
            }

            if (s.equals("youlost.gif")) {
               this.oyoulost = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("youwon.gif")) {
               this.oyouwon = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("0c.gif")) {
               this.ocntdn[0] = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("damage.gif")) {
               this.odmg = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("power.gif")) {
               this.opwr = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("position.gif")) {
               this.opos = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("wasted.gif")) {
               this.owas = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("start1.gif")) {
               this.ostar[0] = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("start2.gif")) {
               this.ostar[1] = this.loadimage(abyte0, mediatracker, toolkit);
               this.star[2] = this.pressed(this.ostar[1]);
            }

            if (s.equals("congrad.gif")) {
               this.congrd = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("statb.gif")) {
               this.statb = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("statbo.gif")) {
               this.statbo = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("madness.gif")) {
               this.mdness = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("fixhoop.gif")) {
               this.fixhoop = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("arrow.gif")) {
               this.sarrow = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("stunts.gif")) {
               this.stunts = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("racing.gif")) {
               this.racing = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("wasting.gif")) {
               this.wasting = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("plus.gif")) {
               this.plus = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("space.gif")) {
               this.space = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("arrows.gif")) {
               this.arrows = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("chil.gif")) {
               this.chil = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("ory.gif")) {
               this.ory = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("kz.gif")) {
               this.kz = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("kx.gif")) {
               this.kx = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("kv.gif")) {
               this.kv = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("kp.gif")) {
               this.kp = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("km.gif")) {
               this.km = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("kn.gif")) {
               this.kn = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("kenter.gif")) {
               this.kenter = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("nfm.gif")) {
               this.nfm = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("options.gif")) {
               this.opti = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("opback.gif")) {
               this.opback = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("logocars.gif")) {
               this.logocars = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("logomadmess.gif")) {
               this.logomadnes = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("logomadbg.gif")) {
               this.logomadbg = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("byrd.gif")) {
               this.byrd = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("nfmcoms.gif")) {
               this.nfmcoms = this.loadimage(abyte0, mediatracker, toolkit);
            }

            if (s.equals("nfmcom.gif")) {
               this.nfmcom = this.loadimage(abyte0, mediatracker, toolkit);
            }

            this.dnload += 3;
         }

         datainputstream.close();
         zipinputstream.close();
      } catch (Exception var12) {
         System.out.println("Error Loading Images: " + var12);
      }

      System.gc();
   }

   public void pausedgame(int i, Control control, Record record) {
      this.rd.drawImage(this.fleximg, 0, 0, null);
      if (control.up) {
         this.opselect--;
         if (this.opselect == -1) {
            this.opselect = 3;
         }

         control.up = false;
      }

      if (control.down) {
         this.opselect++;
         if (this.opselect == 4) {
            this.opselect = 0;
         }

         control.down = false;
      }

      if (this.opselect == 0) {
         this.rd.setColor(new Color(64, 143, 223));
         this.rd.fillRoundRect(264, 45, 137, 22, 7, 20);
         if (this.shaded) {
            this.rd.setColor(new Color(225, 200, 255));
         } else {
            this.rd.setColor(new Color(0, 89, 223));
         }

         this.rd.drawRoundRect(264, 45, 137, 22, 7, 20);
      }

      if (this.opselect == 1) {
         this.rd.setColor(new Color(64, 143, 223));
         this.rd.fillRoundRect(255, 73, 155, 22, 7, 20);
         if (this.shaded) {
            this.rd.setColor(new Color(225, 200, 255));
         } else {
            this.rd.setColor(new Color(0, 89, 223));
         }

         this.rd.drawRoundRect(255, 73, 155, 22, 7, 20);
      }

      if (this.opselect == 2) {
         this.rd.setColor(new Color(64, 143, 223));
         this.rd.fillRoundRect(238, 99, 190, 22, 7, 20);
         if (this.shaded) {
            this.rd.setColor(new Color(225, 200, 255));
         } else {
            this.rd.setColor(new Color(0, 89, 223));
         }

         this.rd.drawRoundRect(238, 99, 190, 22, 7, 20);
      }

      if (this.opselect == 3) {
         this.rd.setColor(new Color(64, 143, 223));
         this.rd.fillRoundRect(276, 125, 109, 22, 7, 20);
         if (this.shaded) {
            this.rd.setColor(new Color(225, 200, 255));
         } else {
            this.rd.setColor(new Color(0, 89, 223));
         }

         this.rd.drawRoundRect(276, 125, 109, 22, 7, 20);
      }

      this.rd.drawImage(this.paused, 216, 8, null);
      if (control.enter || control.handb) {
         if (this.opselect == 0) {
            if (this.loadedt[i - 1] && !this.mutem) {
               this.stracks[i - 1].resume();
            }

            this.fase = 0;
         }

         if (this.opselect == 1) {
            if (record.caught >= 300) {
               if (this.loadedt[i - 1] && !this.mutem) {
                  this.stracks[i - 1].resume();
               }

               this.fase = -1;
            } else {
               this.fase = -8;
            }
         }

         if (this.opselect == 2) {
            if (this.loadedt[i - 1]) {
               this.stracks[i - 1].stop();
            }

            this.oldfase = -7;
            this.fase = 11;
         }

         if (this.opselect == 3) {
            if (this.loadedt[i - 1]) {
               this.stracks[i - 1].stop();
            }

            this.fase = 10;
            this.opselect = 0;
         }

         control.enter = false;
         control.handb = false;
      }
   }

   public void showSplash() {
      this.rd.drawImage(this.dslog, 0, 0, null);
   }

   public void credits(Control control) {
      if (this.flipo == 0) {
         this.powerup.play();
         this.flipo = 1;
         this.bgmy[0] = 0;
         this.bgmy[1] = 400;
      }

      if (this.flipo >= 1 && this.flipo <= 100) {
         this.rad(this.flipo);
         this.flipo++;
         if (this.flipo == 100) {
            this.flipo = 1;
         }
      }

      if (this.flipo == 101) {
         int i = 0;

         do {
            this.rd.drawImage(this.bgmain, 0, this.bgmy[i], null);
            this.bgmy[i] = this.bgmy[i] - 10;
            if (this.bgmy[i] <= -400) {
               this.bgmy[i] = 400;
            }
         } while (++i < 2);

         this.rd.drawImage(this.mdness, 218, 7, null);
         this.rd.setFont(new Font("SansSerif", 1, 13));
         this.ftm = this.rd.getFontMetrics();
         this.drawcs(65, "At Radicalplay.com", 0, 0, 0, 3);
         this.drawcs(100, "Cartoon 3D Engine, Game Programming, 3D Models, Graphics and Sound Effects", 0, 0, 0, 3);
         this.drawcs(120, "Everything at original version By Omar Waly", 70, 70, 70, 3);
         this.drawcs(140, "Custom Content by Dany Fernández (DragShot)", 70, 70, 70, 3);
         this.rd.setFont(new Font("SansSerif", 1, 13));
         this.ftm = this.rd.getFontMetrics();
         this.drawcs(180, "Special Thanks to:", 0, 0, 0, 3);
         this.rd.setFont(new Font("SansSerif", 1, 11));
         this.ftm = this.rd.getFontMetrics();
         this.drawcs(200, "Soufy H Abutaleb, Sherif Abouzeid,Kareem Mansour, Youssef Wahby,", 90, 90, 90, 3);
         this.drawcs(215, "Taymour Farid, Mahmoud Waly and Mahmoud Ezzeldin (Turbo) by tsting the official game", 90, 90, 90, 3);
         this.drawcs(230, "JuanRaúl Rejas, Sebastián Cares, Ryan Albano, Dominykas Gedminas, Shahar Berenson", 90, 90, 90, 3);
         this.drawcs(245, "Omar Wally and anybody that wasn't mentioned here", 90, 90, 90, 3);
         this.drawcs(260, "Thanks those people I got the necessary resources to make this game", 20, 20, 20, 3);
         this.rd.setFont(new Font("SansSerif", 1, 13));
         this.ftm = this.rd.getFontMetrics();
         this.drawcs(340, "Music was obtained from the ModArchive.org and other sources", 0, 0, 0, 3);
         this.rd.setFont(new Font("SansSerif", 1, 11));
         this.ftm = this.rd.getFontMetrics();
         this.drawcs(360, "Some tracks where remixed to fit the game by DragShot", 90, 90, 90, 3);
         this.drawcs(380, "For more details about the music: http://www.radicalplay.com/madcars/music.html", 90, 90, 90, 3);
      }

      if (this.flipo == 102) {
         int j = 0;

         do {
            this.rd.drawImage(this.bgmain, 0, this.bgmy[j], null);
            this.bgmy[j] = this.bgmy[j] - 16;
            if (this.bgmy[j] <= -400) {
               this.bgmy[j] = 400;
            }
         } while (++j < 2);

         this.rd.drawImage(this.nfmcom, 125, 90, null);
      }

      this.rd.drawImage(this.next[this.pnext], 600, 370, null);
      if (control.enter || control.handb || control.right) {
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

         control.enter = false;
         control.handb = false;
         control.right = false;
      }
   }

   public float pys(int i, int j, int k, int l) {
      return (float)Math.sqrt((i - j) * (i - j) + (k - l) * (k - l));
   }

   public void stat(Madness madness, CheckPoints checkpoints, Control control, boolean flag) {
      if (this.holdit) {
         this.holdcnt++;
         if (this.m.flex != 0) {
            this.m.flex = 0;
         }

         if (control.enter || this.holdcnt > 250) {
            this.fase = -2;
            control.enter = false;
         }
      } else {
         if (this.holdcnt != 0) {
            this.holdcnt = 0;
         }

         if (control.enter) {
            if (this.loadedt[checkpoints.stage - 1]) {
               this.stracks[checkpoints.stage - 1].stop();
            }

            this.fase = -6;
            control.enter = false;
         }
      }

      if (this.fase != -2) {
         this.holdit = false;
         if (checkpoints.wasted == 6) {
            if (this.m.flex != 2) {
               this.rd.setColor(new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]));
               this.rd.fillRect(226, 70, this.youwastedem.getWidth(this.ob), this.youwastedem.getHeight(this.ob));
               this.rd.setColor(new Color(this.m.cfade[0], this.m.cfade[1], this.m.cfade[2]));
               this.rd.drawRect(226, 70, this.youwastedem.getWidth(this.ob), this.youwastedem.getHeight(this.ob));
            }

            this.rd.drawImage(this.youwastedem, 226, 70, null);
            if (this.aflk) {
               this.drawcs(120, "You Won, all cars have been wasted!", 0, 0, 0, 0);
               this.aflk = false;
            } else {
               this.drawcs(120, "You Won, all cars have been wasted!", 0, 128, 255, 0);
               this.aflk = true;
            }

            this.drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
            checkpoints.haltall = true;
            this.holdit = true;
            this.winner = true;
         }

         if (!this.holdit && madness.dest && this.cntwis == 8) {
            if (this.m.flex != 2) {
               this.rd.setColor(new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]));
               this.rd.fillRect(232, 70, this.yourwasted.getWidth(this.ob), this.yourwasted.getHeight(this.ob));
               this.rd.setColor(new Color(this.m.cfade[0], this.m.cfade[1], this.m.cfade[2]));
               this.rd.drawRect(232, 70, this.yourwasted.getWidth(this.ob), this.yourwasted.getHeight(this.ob));
            }

            this.rd.drawImage(this.yourwasted, 232, 70, null);
            this.drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
            this.holdit = true;
            this.winner = false;
         }

         if (!this.holdit) {
            int i = 0;

            do {
               if (checkpoints.clear[i] == checkpoints.nlaps * checkpoints.nsp && checkpoints.pos[i] == 0) {
                  if (i == 0) {
                     if (this.m.flex != 2) {
                        this.rd.setColor(new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]));
                        this.rd.fillRect(268, 70, this.youwon.getWidth(this.ob), this.youwon.getHeight(this.ob));
                        this.rd.setColor(new Color(this.m.cfade[0], this.m.cfade[1], this.m.cfade[2]));
                        this.rd.drawRect(268, 70, this.youwon.getWidth(this.ob), this.youwon.getHeight(this.ob));
                     }

                     this.rd.drawImage(this.youwon, 268, 70, null);
                     if (this.aflk) {
                        this.drawcs(120, "Whoohoo! You finished first, nice job!", 0, 0, 0, 0);
                        this.aflk = false;
                     } else {
                        this.drawcs(120, "Whoohoo! You finished first, nice job!", 0, 128, 255, 0);
                        this.aflk = true;
                     }

                     this.winner = true;
                  } else {
                     if (this.m.flex != 2) {
                        this.rd.setColor(new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]));
                        this.rd.fillRect(271, 70, this.youlost.getWidth(this.ob), this.youlost.getHeight(this.ob));
                        this.rd.setColor(new Color(this.m.cfade[0], this.m.cfade[1], this.m.cfade[2]));
                        this.rd.drawRect(271, 70, this.youlost.getWidth(this.ob), this.youlost.getHeight(this.ob));
                     }

                     this.rd.drawImage(this.youlost, 271, 70, null);
                     if (this.aflk) {
                        this.drawcs(120, "" + this.names[this.sc[i]] + " finished first, race over!", 0, 0, 0, 0);
                        this.aflk = false;
                     } else {
                        this.drawcs(120, "" + this.names[this.sc[i]] + " finished first, race over!", 0, 128, 255, 0);
                        this.aflk = true;
                     }

                     this.winner = false;
                  }

                  this.drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
                  checkpoints.haltall = true;
                  this.holdit = true;
               }
            } while (++i < 7);
         }

         if (flag) {
            if (checkpoints.stage != 16 && this.arrace != control.arrace) {
               this.arrace = control.arrace;
               if (this.arrace) {
                  this.wasay = true;
                  this.say = " Arrow now pointing at  Cars  <";
                  this.tcnt = -5;
               }

               if (!this.arrace) {
                  this.wasay = false;
                  this.say = " Arrow now pointing at  Track  <";
                  this.tcnt = -5;
                  this.cntan = 20;
               }
            }

            if (!this.holdit && this.fase != -6 && this.starcnt == 0 && checkpoints.stage != 16) {
               int i_62_ = 7;

               for (int i_63_ = 0; i_63_ < i_62_ && this.arrace && control.skey; i_63_++) {
                  boolean bool_64_ = false;

                  for (int i_65_ = 0; i_65_ < 7; i_65_++) {
                     if (checkpoints.pos[i_65_] == i_63_ && checkpoints.dested[i_65_] == 0 && !bool_64_) {
                        this.rd.setColor(new Color(0, 0, 100));
                        if (i_63_ == 0) {
                           this.rd.drawString("1st", 543, 76 + 30 * i_63_);
                        }

                        if (i_63_ == 1) {
                           this.rd.drawString("2nd", 541, 76 + 30 * i_63_);
                        }

                        if (i_63_ == 2) {
                           this.rd.drawString("3rd", 541, 76 + 30 * i_63_);
                        }

                        if (i_63_ >= 3) {
                           this.rd.drawString("" + (i_63_ + 1) + "th", 541, 76 + 30 * i_63_);
                        }

                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawString(this.shortnam[this.sc[i_65_]], 600 - this.ftm.stringWidth(this.shortnam[this.sc[i_65_]]) / 2, 70 + 30 * i_63_);
                        int i_66_ = (int)(60.0F * ((float)GameSparker.mads[i_65_].hitmag / madness.maxmag[this.sc[i_65_]]));
                        int i_67_ = 244;
                        int i_68_ = 244;
                        int i_69_ = 11;
                        if (i_66_ > 20) {
                           i_68_ = (int)(244.0F - 233.0F * ((i_66_ - 20) / 40.0F));
                        }

                        i_67_ = (int)(i_67_ + i_67_ * (this.m.snap[0] / 100.0F));
                        if (i_67_ > 255) {
                           i_67_ = 255;
                        }

                        if (i_67_ < 0) {
                           i_67_ = 0;
                        }

                        i_68_ = (int)(i_68_ + i_68_ * (this.m.snap[1] / 100.0F));
                        if (i_68_ > 255) {
                           i_68_ = 255;
                        }

                        if (i_68_ < 0) {
                           i_68_ = 0;
                        }

                        i_69_ = (int)(i_69_ + i_69_ * (this.m.snap[2] / 100.0F));
                        if (i_69_ > 255) {
                           i_69_ = 255;
                        }

                        if (i_69_ < 0) {
                           i_69_ = 0;
                        }

                        this.rd.setColor(new Color(i_67_, i_68_, i_69_));
                        this.rd.fillRect(570, 74 + 30 * i_63_, i_66_, 5);
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawRect(570, 74 + 30 * i_63_, 60, 5);
                        if (madness.im != i_65_) {
                           i_67_ = (int)(140.0F + 140.0F * (this.m.snap[0] / 100.0F));
                           if (i_67_ > 255) {
                              i_67_ = 255;
                           }

                           if (i_67_ < 0) {
                              i_67_ = 0;
                           }

                           i_68_ = (int)(160.0F + 160.0F * (this.m.snap[1] / 100.0F));
                           if (i_68_ > 255) {
                              i_68_ = 255;
                           }

                           if (i_68_ < 0) {
                              i_68_ = 0;
                           }

                           i_69_ = (int)(255.0F + 255.0F * (this.m.snap[2] / 100.0F));
                           if (i_69_ > 255) {
                              i_69_ = 255;
                           }

                           if (i_69_ < 0) {
                              i_69_ = 0;
                           }

                           this.rd.setColor(new Color(i_67_, i_68_, i_69_));
                           this.rd.drawRect(530, 57 + 30 * i_63_, 116, 27);
                        } else {
                           i_67_ = (int)(159.0F + 159.0F * (this.m.snap[0] / 100.0F));
                           if (i_67_ > 255) {
                              i_67_ = 255;
                           }

                           if (i_67_ < 0) {
                              i_67_ = 0;
                           }

                           i_68_ = (int)(207.0F + 207.0F * (this.m.snap[1] / 100.0F));
                           if (i_68_ > 255) {
                              i_68_ = 255;
                           }

                           if (i_68_ < 0) {
                              i_68_ = 0;
                           }

                           i_69_ = (int)(255.0F + 255.0F * (this.m.snap[2] / 100.0F));
                           if (i_69_ > 255) {
                              i_69_ = 255;
                           }

                           if (i_69_ < 0) {
                              i_69_ = 0;
                           }

                           this.rd.setColor(new Color(i_67_, i_68_, i_69_));
                           this.rd.drawRect(531, 58 + 30 * i_63_, 114, 25);
                           this.rd.drawRect(532, 59 + 30 * i_63_, 112, 23);
                        }

                        bool_64_ = true;
                     }
                  }
               }

               this.arrow(madness.point, madness.missedcp, checkpoints, this.arrace, madness, control.skey);
               if (!this.arrace && this.auscnt == 45 && madness.capcnt == 0) {
                  if (madness.missedcp > 0) {
                     if (madness.missedcp > 15 && madness.missedcp < 50) {
                        if (this.flk) {
                           this.drawcs(70, "Checkpoint Missed! Go back!", 255, 0, 0, 0);
                        } else {
                           this.drawcs(70, "Checkpoint Missed! Go back!", 255, 150, 0, 2);
                        }
                     }

                     madness.missedcp++;
                     if (madness.missedcp == 70) {
                        madness.missedcp = -2;
                     }
                  } else if (madness.mtouch && this.cntovn < 70) {
                     if (Math.abs(this.ana) > 100) {
                        this.cntan++;
                     } else if (this.cntan != 0) {
                        this.cntan--;
                     }

                     if (this.cntan > 40) {
                        this.cntovn++;
                        this.cntan = 40;
                        if (this.flk) {
                           this.drawcs(70, "Wrong Way! What are you doing?", 255, 150, 0, 0);
                           this.flk = false;
                        } else {
                           this.drawcs(70, "Wrong Way! What are you doing?", 255, 0, 0, 2);
                           this.flk = true;
                        }
                     }
                  }
               }
            } else if (checkpoints.stage == 16 && this.m.flex != 2 && !this.holdit) {
               this.rd.setColor(new Color(250, 50, 50));
               this.rd.drawString("[NO DATA]", 580, 30);
            }

            if (!this.holdit && !this.mutem) {
               this.drawcs(380, "Now listening: " + this.sndtrck[checkpoints.stage - 1], 0, 0, 0, 3);
            }

            int r = this.m.csky[0];
            int g = this.m.csky[1];
            int b = this.m.csky[2];
            if (this.m.darksky) {
               r += 30;
               g += 30;
               b += 30;
            }

            if (r > 255) {
               r = 255;
            }

            if (g > 255) {
               g = 255;
            }

            if (b > 255) {
               b = 255;
            }

            this.rd.setColor(new Color(r, g, b));
            this.rd.fillRect(17, 349, 54, 14);
            this.rd.drawLine(16, 350, 16, 361);
            this.rd.drawLine(15, 352, 15, 359);
            this.rd.fillRect(22, 369, 49, 14);
            this.rd.drawLine(21, 370, 21, 381);
            this.rd.drawLine(20, 372, 20, 379);
            this.rd.drawImage(this.dmg, 15, 347, null);
            this.rd.drawImage(this.pwr, 15, 367, null);
            this.rd.setColor(new Color(r, g, b));
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
            this.rd.drawImage(this.lap, 19, 7, null);
            this.rd.setColor(new Color(0, 0, 100));
            this.rd.drawString("" + (madness.nlaps + 1) + " / " + checkpoints.nlaps + "", 51, 18);
            this.rd.drawImage(this.was, 92, 7, null);
            this.rd.setColor(new Color(0, 0, 100));
            this.rd.drawString("" + checkpoints.wasted + " / 6", 150, 18);
            this.rd.drawImage(this.pos, 42, 27, null);
            this.rd.drawImage(this.rank[checkpoints.pos[madness.im]], 110, 28, null);
            this.m.flex++;
            if (this.posit != checkpoints.pos[madness.im]) {
               this.posit = checkpoints.pos[madness.im];
            }

            if (this.wasted != checkpoints.wasted) {
               this.wasted = checkpoints.wasted;
            }

            if (this.laps != madness.nlaps) {
               this.laps = madness.nlaps;
            }

            this.drawstat(madness.maxmag[madness.cn], madness.hitmag, madness.newcar, madness.power);
            DecimalFormat dc = new DecimalFormat("##0.00");
            if (!this.holdit) {
               this.rd.setColor(new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]));
               this.rd.setColor(new Color(0, 0, 100));
               this.rd.drawString("Speed:", 485, 372);
               this.rd.setFont(new Font("SansSerif", 1, 22));
               this.rd.setColor(new Color(0, 0, 0));
               float speed = Math.min(this.pre_speed, madness.speed);
               if (speed >= 0.0F) {
                  this.rd.drawString("" + dc.format(speed).replace(",", ".") + " Km/h", 528, 380);
               } else {
                  this.rd.drawString("" + dc.format(Math.abs(speed)).replace(",", ".") + " Km/h", 528, 380);
                  this.rd.setFont(new Font("SansSerif", 1, 11));
                  this.rd.setColor(new Color(100, 140, 10));
                  this.rd.drawString("[Rev]", 495, 382);
               }

               this.pre_speed = madness.speed;
               this.rd.setFont(new Font("SansSerif", 1, 11));
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
                  this.m.flex = 0;
               }

               if (this.dudo != -1) {
                  ((Graphics2D)this.rd).setComposite(AlphaComposite.getInstance(3, 0.3F));
                  this.rd.drawImage(this.dude[this.duds], this.dudo, 0, null);
                  ((Graphics2D)this.rd).setComposite(AlphaComposite.getInstance(3, 1.0F));
               }

               if (this.gocnt != 0) {
                  this.rd.drawImage(this.cntdn[this.gocnt], 320, 50, null);
               } else {
                  this.rd.drawImage(this.cntdn[this.gocnt], 298, 50, null);
               }
            }

            if (this.looped != 0 && madness.loop == 2) {
               this.looped = 0;
            }

            if (madness.power < 45.0F) {
               if (this.tcnt == 30 && this.auscnt == 45 && madness.mtouch && madness.capcnt == 0) {
                  if (this.looped != 2) {
                     if (this.pwcnt < 70 || this.pwcnt < 160 && this.looped != 0) {
                        if (this.pwflk) {
                           this.drawcs(110, "Your Power is low, time to perform stunts!", 0, 0, 200, 0);
                           this.pwflk = false;
                        } else {
                           this.drawcs(110, "Your Power is low, time to perform stunts!", 255, 100, 0, 0);
                           this.pwflk = true;
                        }
                     }
                  } else if (this.pwcnt < 250) {
                     if (this.pwflk) {
                        this.drawcs(105, "> >  Press Enter for GAME INSTRUCTIONS!  < <", 0, 0, 200, 0);
                        this.drawcs(120, "To learn how to preform STUNTS!", 0, 0, 200, 0);
                        this.pwflk = false;
                     } else {
                        this.drawcs(105, "> >  Press Enter for GAME INSTRUCTIONS!  < <", 255, 100, 0, 0);
                        this.drawcs(120, "To learn how to preform STUNTS!", 255, 100, 0, 0);
                        this.pwflk = true;
                     }
                  }

                  this.pwcnt++;
                  if (this.pwcnt == 300) {
                     this.pwcnt = 0;
                     if (this.looped != 0) {
                        this.looped++;
                        if (this.looped == 3) {
                           this.looped = 1;
                        }
                     }
                  }
               }
            } else if (this.pwcnt != 0) {
               this.pwcnt = 0;
            }

            if (madness.capcnt == 0) {
               if (this.tcnt < 30) {
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

                  this.tcnt++;
               } else if (this.wasay) {
                  this.wasay = false;
               }

               if (this.auscnt < 45) {
                  if (this.aflk) {
                     this.drawcs(85, this.asay, 98, 176, 255, 0);
                     this.aflk = false;
                  } else {
                     this.drawcs(85, this.asay, 0, 128, 255, 0);
                     this.aflk = true;
                  }

                  this.auscnt++;
               }
            } else if (this.tflk) {
               this.drawcs(110, "Epic Fail! Try again", 0, 0, 200, 0);
               this.tflk = false;
            } else {
               this.drawcs(110, "Epic Fail! Try again", 255, 100, 0, 0);
               this.tflk = true;
            }

            if (madness.trcnt == 10) {
               this.loop = "";
               this.spin = "";
               this.asay = "";

               int j;
               for (j = 0; madness.travzy > 225; j++) {
                  madness.travzy -= 360;
               }

               while (madness.travzy < -225) {
                  madness.travzy += 360;
                  j--;
               }

               if (j == 1) {
                  this.loop = "Forward loop";
               }

               if (j == 2) {
                  this.loop = "double Forward";
               }

               if (j == 3) {
                  this.loop = "triple Forward";
               }

               if (j >= 4) {
                  this.loop = "massive Forward looping";
               }

               if (j == -1) {
                  this.loop = "Backloop";
               }

               if (j == -2) {
                  this.loop = "double Back";
               }

               if (j == -3) {
                  this.loop = "triple Back";
               }

               if (j <= -4) {
                  this.loop = "massive Back looping";
               }

               if (j == 0) {
                  if (madness.ftab && madness.btab) {
                     this.loop = "Tabletop and reversed Tabletop";
                  } else if (madness.ftab || madness.btab) {
                     this.loop = "Tabletop";
                  }
               }

               if (j > 0 && madness.btab) {
                  this.loop = "Hanged " + this.loop;
               }

               if (j < 0 && madness.ftab) {
                  this.loop = "Hanged " + this.loop;
               }

               if (this.loop != "") {
                  this.asay = this.asay + " " + this.loop;
               }

               j = 0;

               for (madness.travxy = Math.abs(madness.travxy); madness.travxy > 270; j++) {
                  madness.travxy -= 360;
               }

               if (j == 0 && madness.rtab) {
                  if (this.loop == "") {
                     this.spin = "Tabletop";
                  } else {
                     this.spin = "Flipside";
                  }
               }

               if (j == 1) {
                  this.spin = "Rollspin";
               }

               if (j == 2) {
                  this.spin = "double Rollspin";
               }

               if (j == 3) {
                  this.spin = "triple Rollspin";
               }

               if (j >= 4) {
                  this.spin = "massive Roll spinning";
               }

               j = 0;
               boolean flag1 = false;
               madness.travxz = Math.abs(madness.travxz);

               while (madness.travxz > 90) {
                  madness.travxz -= 180;
                  j += 180;
                  if (j > 900) {
                     j = 900;
                     flag1 = true;
                  }
               }

               if (j != 0) {
                  if (this.loop == "" && this.spin == "") {
                     this.asay = this.asay + " " + j;
                     if (flag1) {
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

                     this.asay = this.asay + " by " + j;
                     if (flag1) {
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

               if (j != 0) {
                  this.auscnt -= 25;
               }

               if (this.auscnt < 45) {
                  if (!this.mutes) {
                     this.powerup.play();
                  }

                  if (this.auscnt < -20) {
                     this.auscnt = -20;
                  }

                  byte byte0 = 0;
                  if (madness.powerup > 20.0F) {
                     byte0 = 1;
                  }

                  if (madness.powerup > 40.0F) {
                     byte0 = 2;
                  }

                  if (madness.powerup > 150.0F) {
                     byte0 = 3;
                  }

                  if (madness.surfer) {
                     this.asay = " " + this.adj[4][(int)(this.m.random() * 3.0F)] + this.asay;
                  }

                  if (byte0 != 3) {
                     this.asay = this.adj[byte0][(int)(this.m.random() * 3.0F)] + this.asay + this.exlm[byte0];
                  } else {
                     this.asay = this.adj[byte0][(int)(this.m.random() * 3.0F)];
                  }

                  if (!this.wasay) {
                     this.tcnt = this.auscnt;
                     if (madness.power != 98.0F) {
                        this.say = "Power Up " + (int)(100.0F * madness.powerup / 98.0F) + "%";
                     } else {
                        this.say = "Power To The MAX!!!";
                     }

                     if (this.skidup) {
                        this.skidup = false;
                     } else {
                        this.skidup = true;
                     }
                  }
               }
            }

            if (madness.newcar) {
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

            if (this.clear != madness.clear && madness.clear != 0) {
               if (!this.wasay) {
                  if (madness.clear == (checkpoints.nlaps - 1) * checkpoints.nsp) {
                     this.say = "Final lap!!!";
                  } else {
                     this.say = "Checkpoint!";
                  }

                  this.tcnt = 15;
               }

               this.clear = madness.clear;
               if (!this.mutes) {
                  this.checkpoint.play();
               }

               this.cntovn = 0;
               if (this.cntan != 0) {
                  this.cntan = 0;
               }
            }

            int k = 1;

            do {
               if (this.dested[k] != checkpoints.dested[k]) {
                  this.dested[k] = checkpoints.dested[k];
                  if (this.dested[k] == 1) {
                     this.wasay = true;
                     this.say = "" + this.names[this.sc[k]] + " has been wasted!";
                     this.tcnt = -15;
                  }

                  if (this.dested[k] == 2) {
                     this.wasay = true;
                     this.say = "You wasted " + this.names[this.sc[k]] + "!";
                     this.tcnt = -15;
                  }
               }
            } while (++k < 7);
         }
      }
   }

   public void finish(CheckPoints checkpoints, ContO[] aconto, Control control) {
      this.rd.drawImage(this.fleximg, 0, 0, null);
      if (this.winner) {
         if (checkpoints.stage == this.unlocked) {
            if (checkpoints.stage != 17) {
               this.rd.drawImage(this.congrd, 200, 30, null);
               this.drawcs(80, "Stage " + checkpoints.stage + " Completed!", 170, 170, 170, 3);
            } else {
               this.rd.drawImage(this.congrd, 195 + (int)(this.m.random() * 10.0F), 30, null);
            }

            byte byte0 = 0;
            int i = 0;
            this.pin = 60;
            if (checkpoints.stage == 2) {
               byte0 = 8;
               i = 265;
               this.pin = 0;
               this.sc[0] = 8;
            }

            if (checkpoints.stage == 4) {
               byte0 = 9;
               i = 240;
               this.pin = 0;
               this.sc[0] = 9;
            }

            if (checkpoints.stage == 6) {
               byte0 = 10;
               i = 290;
               this.pin = 0;
               this.sc[0] = 10;
            }

            if (checkpoints.stage == 8) {
               byte0 = 11;
               i = 226;
               this.pin = 0;
               this.sc[0] = 11;
            }

            if (checkpoints.stage == 10) {
               byte0 = 12;
               i = 200;
               this.pin = 0;
               this.sc[0] = 12;
            }

            if (checkpoints.stage == 12) {
               byte0 = 13;
               i = 200;
               this.pin = 0;
               this.sc[0] = 13;
            }

            if (checkpoints.stage == 14) {
               byte0 = 14;
               i = 270;
               this.pin = 0;
               this.sc[0] = 14;
            }

            if (checkpoints.stage == 16) {
               byte0 = 15;
               i = 290;
               this.pin = 0;
               this.sc[0] = 15;
            }

            if (checkpoints.stage != 17) {
               this.rd.setFont(new Font("SansSerif", 1, 13));
               this.ftm = this.rd.getFontMetrics();
               if (this.aflk) {
                  this.drawcs(120 + this.pin, "Stage " + (checkpoints.stage + 1) + " is now unlocked!", 176, 196, 0, 3);
               } else {
                  this.drawcs(120 + this.pin, "Stage " + (checkpoints.stage + 1) + " is now unlocked!", 247, 255, 165, 3);
               }

               if (byte0 != 0) {
                  if (this.aflk) {
                     this.drawcs(140, "And:", 176, 196, 0, 3);
                  } else {
                     this.drawcs(140, "And:", 247, 255, 165, 3);
                  }

                  this.rd.setColor(new Color(236, 226, 202));
                  float f = (float)Math.random();
                  if (f < 0.7) {
                     this.rd.drawRect(160, 150, 349, 126);
                  } else {
                     this.rd.fillRect(160, 150, 350, 127);
                  }

                  this.rd.setColor(new Color(255, 209, 89));
                  this.rd.fillRect(161, 151, 348, 4);
                  this.rd.fillRect(161, 151, 4, 125);
                  this.rd.fillRect(161, 272, 348, 4);
                  this.rd.fillRect(505, 151, 4, 125);
                  aconto[byte0].y = i;
                  this.m.crs = true;
                  this.m.x = -335;
                  this.m.y = 0;
                  this.m.z = -50;
                  this.m.xz = 0;
                  this.m.zy = 0;
                  this.m.ground = 2470;
                  aconto[byte0].z = 1000;
                  aconto[byte0].x = 0;
                  aconto[byte0].xz += 5;
                  aconto[byte0].zy = 0;
                  aconto[byte0].wzy -= 10;
                  aconto[byte0].d(this.rd);
                  if (f < 0.1) {
                     this.rd.setColor(new Color(236, 226, 202));
                     int j = 0;

                     do {
                        this.rd.drawLine(165, 155 + 4 * j, 504, 155 + 4 * j);
                     } while (++j < 30);
                  }

                  String s = "";
                  if (byte0 == 13) {
                     s = " ";
                  }

                  if (this.aflk) {
                     this.drawcs(300, "" + this.names[byte0] + "" + s + " has been unlocked!", 176, 196, 0, 3);
                  } else {
                     this.drawcs(300, "" + this.names[byte0] + "" + s + " has been unlocked!", 247, 255, 165, 3);
                  }

                  this.pin = 180;
               }

               this.rd.setFont(new Font("SansSerif", 1, 11));
               this.ftm = this.rd.getFontMetrics();
               this.drawcs(140 + this.pin, "GAME SAVED", 230, 167, 0, 3);
               if (this.pin == 60) {
                  this.pin = 30;
               } else {
                  this.pin = 0;
               }
            } else {
               this.rd.setFont(new Font("SansSerif", 1, 13));
               this.ftm = this.rd.getFontMetrics();
               if (this.aflk) {
                  this.drawcs(90, "Woohoooo you finished the game!!!", 144, 167, 255, 3);
               } else {
                  this.drawcs(90, "Woohoooo you finished the game!!!", 228, 240, 255, 3);
               }

               if (this.aflk) {
                  this.drawcs(140, "Your Awesome!", 144, 167, 255, 3);
               } else {
                  this.drawcs(142, "Your Awesome!", 228, 240, 255, 3);
               }

               if (this.aflk) {
                  this.drawcs(190, "You're truly a RADICAL GAMER!", 144, 167, 255, 3);
               } else {
                  this.drawcs(190, "You're truly a RADICAL GAMER!", 255, 100, 100, 3);
               }

               this.rd.setColor(new Color(0, 0, 0));
               this.rd.fillRect(0, 205, 670, 62);
               this.rd.drawImage(this.radicalplay, this.radpx + (int)(8.0 * Math.random() - 4.0), 205, null);
               if (this.radpx != 147) {
                  this.radpx += 40;
                  if (this.radpx > 670) {
                     this.radpx = -453;
                  }
               }

               if (this.flipo == 40) {
                  this.radpx = 148;
               }

               this.flipo++;
               if (this.flipo == 70) {
                  this.flipo = 0;
               }

               if (this.radpx == 147) {
                  this.rd.setFont(new Font("SansSerif", 1, 11));
                  this.ftm = this.rd.getFontMetrics();
                  if (this.aflk) {
                     this.drawcs(259, "A Game by Radicalplay.com, modified by DragShot", 144, 167, 255, 3);
                  } else {
                     this.drawcs(259, "A Game by Radicalplay.com, modified by DragShot", 228, 240, 255, 3);
                  }
               }

               if (this.aflk) {
                  this.drawcs(300, "Now get up and dance!", 144, 167, 255, 3);
               } else {
                  this.drawcs(300, "Now get up and dance!", 228, 240, 255, 3);
               }

               this.pin = 0;
            }

            if (this.aflk) {
               this.aflk = false;
            } else {
               this.aflk = true;
            }
         } else {
            this.pin = 30;
            this.rd.drawImage(this.congrd, 200, 87, null);
            this.drawcs(137, "Stage " + checkpoints.stage + " Completed!", 170, 170, 170, 3);
            this.drawcs(154, "" + checkpoints.name + "", 128, 128, 128, 3);
         }
      } else {
         this.pin = 30;
         this.rd.drawImage(this.gameov, 250, 117, null);
         this.drawcs(167, "Failed to Complete Stage " + checkpoints.stage + "!", 170, 170, 170, 3);
         this.drawcs(184, "" + checkpoints.name + "", 128, 128, 128, 3);
      }

      this.rd.drawImage(this.contin[this.pcontin], 290, 350 - this.pin, null);
      if (control.enter || control.handb) {
         this.fase = 10;
         if (this.loadedt[checkpoints.stage - 1]) {
            this.stracks[checkpoints.stage - 1].stop();
         }

         if (checkpoints.stage == this.unlocked && this.winner && this.unlocked != 17) {
            checkpoints.stage++;
            this.unlocked++;
         }

         this.flipo = 0;
         control.enter = false;
         control.handb = false;
      }
   }

   public void sortcars(int i) {
      if (i != 0) {
         int i_98_ = 1;

         do {
            this.sc[i_98_] = -1;
         } while (++i_98_ < 7);

         boolean[] bools = new boolean[7];
         if (this.unlocked == i && this.unlocked != 17) {
            this.sc[6] = 7 + (i + 1) / 2;
            int i_99_ = 1;

            do {
               bools[i_99_] = false;
            } while (++i_99_ < 6);

            if (i == 14) {
               if (this.sc[0] != 12) {
                  this.sc[5] = 12;
               } else {
                  this.sc[5] = 1;
               }

               if (this.sc[0] != 10) {
                  this.sc[4] = 10;
               } else {
                  this.sc[4] = 1;
               }

               bools[4] = true;
               bools[5] = true;
               i_99_ = (int)(Math.random() * 3.0 + 1.0);
               if (this.sc[0] != 9) {
                  this.sc[i_99_] = 9;
                  bools[i_99_] = true;
                  if (++i_99_ == 4) {
                     i_99_ = 1;
                  }
               }

               if (this.sc[0] != 5) {
                  this.sc[i_99_] = 5;
                  bools[i_99_] = true;
                  if (++i_99_ == 4) {
                     i_99_ = 1;
                  }
               }

               if (this.sc[0] != 8) {
                  this.sc[i_99_] = 8;
                  bools[i_99_] = true;
                  if (++i_99_ == 4) {
                     boolean var15 = true;
                  }
               }
            }

            if (i == 16) {
               int var12 = 4;
               int i_100_ = 5;
               int i_101_ = 1;
               int i_102_ = 2;
               if (Math.random() > Math.random()) {
                  var12 = 5;
                  i_100_ = 4;
               }

               if (Math.random() < Math.random()) {
                  i_101_ = 2;
                  i_102_ = 1;
               }

               if (this.sc[0] != 12) {
                  this.sc[var12] = 12;
               } else {
                  this.sc[var12] = 14;
               }

               if (this.sc[0] != 10) {
                  this.sc[i_100_] = 10;
               } else {
                  this.sc[i_100_] = 14;
               }

               if (this.sc[0] != 11) {
                  this.sc[i_101_] = 11;
               } else {
                  this.sc[i_101_] = 14;
               }

               if (this.sc[0] != 13) {
                  this.sc[i_102_] = 13;
               } else {
                  this.sc[i_102_] = 14;
               }

               if (this.sc[0] <= 9) {
                  this.sc[3] = 14;
               } else {
                  this.sc[3] = 9;
               }

               int i_103_ = 1;

               do {
                  bools[i_103_] = true;
               } while (++i_103_ < 6);
            }

            i_99_ = 1;

            label367:
            while (true) {
               while (bools[i_99_]) {
                  if (++i_99_ >= 6) {
                     if (i == 15) {
                        boolean bool = false;
                        int i_105_ = 0;

                        do {
                           if (this.sc[i_105_] == 13) {
                              bool = true;
                           }
                        } while (++i_105_ < 6);

                        if (!bool && Math.random() > Math.random()) {
                           if (Math.random() > Math.random()) {
                              this.sc[1] = 13;
                           } else {
                              this.sc[2] = 13;
                           }
                        }
                     }

                     if (i == 12) {
                        boolean bool = false;
                        int i_106_ = 0;

                        do {
                           if (this.sc[i_106_] == 11) {
                              bool = true;
                           }
                        } while (++i_106_ < 6);

                        if (!bool) {
                           this.sc[2] = 11;
                        }
                     }

                     if (i == 8) {
                        boolean bool = false;
                        int i_107_ = 0;

                        do {
                           if (this.sc[i_107_] == 9) {
                              bool = true;
                           }
                        } while (++i_107_ < 6);

                        if (!bool) {
                           this.sc[5] = 9;
                        }

                        bool = false;
                        i_107_ = 0;

                        do {
                           if (this.sc[i_107_] == 8) {
                              bool = true;
                           }
                        } while (++i_107_ < 6);

                        if (!bool) {
                           this.sc[4] = 8;
                        }

                        bool = false;
                        i_107_ = 0;

                        do {
                           if (this.sc[i_107_] == 10) {
                              bool = true;
                           }
                        } while (++i_107_ < 6);

                        if (!bool) {
                           this.sc[2] = 10;
                        }
                     }

                     if (i != 9) {
                        break label367;
                     }

                     boolean bool = false;
                     int i_108_ = 0;

                     do {
                        if (this.sc[i_108_] == 10) {
                           bool = true;
                        }
                     } while (++i_108_ < 6);

                     if (bool) {
                        if (this.sc[5] == 10) {
                           break label367;
                        }

                        bool = false;
                        i_108_ = 0;

                        do {
                           if (this.sc[i_108_] == 5) {
                              bool = true;
                           }
                        } while (++i_108_ < 6);

                        if (bool) {
                           if (this.sc[5] == 5) {
                              break label367;
                           }

                           bool = false;
                           i_108_ = 0;

                           do {
                              if (this.sc[i_108_] == 9) {
                                 bool = true;
                              }
                           } while (++i_108_ < 6);

                           if (!bool) {
                              this.sc[5] = 9;
                           }
                           break label367;
                        }

                        this.sc[5] = 5;
                        break label367;
                     }

                     this.sc[5] = 10;
                     break label367;
                  }
               }

               this.sc[i_99_] = (int)(Math.random() * (7 + (i + 1) / 2));
               bools[i_99_] = true;
               int i_104_ = 0;

               do {
                  if (i_99_ != i_104_ && this.sc[i_99_] == this.sc[i_104_]) {
                     bools[i_99_] = false;
                  }
               } while (++i_104_ < 7);

               if (Math.random() < this.proba[this.sc[i_99_]]) {
                  bools[i_99_] = false;
               }

               if (i == 10) {
                  if (this.sc[0] != 11) {
                     if (this.sc[i_99_] == 2 || this.sc[i_99_] == 4 || this.sc[i_99_] == 11) {
                        bools[i_99_] = false;
                     }
                  } else if (this.sc[i_99_] == 9) {
                     bools[i_99_] = false;
                  }
               }

               if (i == 11
                  && (this.sc[i_99_] == 0 || this.sc[i_99_] == 1 || this.sc[i_99_] == 2 || this.sc[i_99_] == 3 || this.sc[i_99_] == 4 || this.sc[i_99_] == 7)) {
                  bools[i_99_] = false;
               }

               if ((i == 12 || i == 15) && this.sc[i_99_] <= 4) {
                  bools[i_99_] = false;
               }

               if (i != 11 && i != 12 && i_99_ != 1 && i_99_ != 2 && this.sc[i_99_] == 13) {
                  bools[i_99_] = false;
               }
            }
         } else {
            int i_109_ = 7;
            if (this.sc[0] != 7 + (i + 1) / 2 && i != 17) {
               this.sc[6] = 7 + (i + 1) / 2;
               i_109_ = 6;
            }

            for (int i_110_ = 1; i_110_ < i_109_; i_110_++) {
               bools[i_110_] = false;

               while (!bools[i_110_]) {
                  int i_111_ = this.unlocked;
                  if (i_111_ == 17) {
                     i_111_ = 16;
                  }

                  this.sc[i_110_] = (int)(Math.random() * (8 + (i_111_ + 1) / 2));
                  bools[i_110_] = true;
                  int i_112_ = 0;

                  do {
                     if (i_110_ != i_112_ && this.sc[i_110_] == this.sc[i_112_]) {
                        bools[i_110_] = false;
                     }
                  } while (++i_112_ < 7);

                  float f = this.proba[this.sc[i_110_]];
                  if (i - this.sc[i_110_] > 4 && i != 17) {
                     f += (i - this.sc[i_110_] - 4) / 10.0F;
                     if (f > 0.9) {
                        f = 0.9F;
                     }
                  }

                  if (i == 16 && this.sc[i_110_] <= 8 && f < 0.9) {
                     f = 0.9F;
                  }

                  if (Math.random() < f) {
                     bools[i_110_] = false;
                  }

                  if (i != 11 && i != 12 && i_110_ != 1 && i_110_ != 2 && this.sc[i_110_] == 13 && bools[i_110_]) {
                     bools[i_110_] = false;
                     if (Math.random() > Math.random() * 1.6 && i != 14 || i == 16 && Math.random() > Math.random()) {
                        if (Math.random() > Math.random()) {
                           this.sc[1] = 13;
                        } else {
                           this.sc[2] = 13;
                        }
                     }
                  }
               }
            }
         }

         if (i == 12) {
            boolean bool = false;
            int i_113_ = 0;

            do {
               if (this.sc[i_113_] == 11) {
                  bool = true;
               }
            } while (++i_113_ < 6);

            if (!bool) {
               this.sc[2] = 11;
            }
         }
      }
   }

   public void sparkeng(int i) {
      i++;
      int j = 0;

      do {
         if (i == j) {
            if (!this.pengs[j]) {
               this.engs[this.enginsignature[this.sc[0]]][j].loop();
               this.pengs[j] = true;
            }
         } else if (this.pengs[j]) {
            this.engs[this.enginsignature[this.sc[0]]][j].stop();
            this.pengs[j] = false;
         }
      } while (++j < 5);
   }

   public void drawcs(int i, String s, int j, int k, int l, int i1) {
      if (i1 != 3 && i1 != 4) {
         j = (int)(j + j * (this.m.snap[0] / 100.0F));
         if (j > 255) {
            j = 255;
         }

         if (j < 0) {
            j = 0;
         }

         k = (int)(k + k * (this.m.snap[1] / 100.0F));
         if (k > 255) {
            k = 255;
         }

         if (k < 0) {
            k = 0;
         }

         l = (int)(l + l * (this.m.snap[2] / 100.0F));
         if (l > 255) {
            l = 255;
         }

         if (l < 0) {
            l = 0;
         }
      }

      if (i1 == 4) {
         j = (int)(j - j * (this.m.snap[0] / 100.0F));
         if (j > 255) {
            j = 255;
         }

         if (j < 0) {
            j = 0;
         }

         k = (int)(k - k * (this.m.snap[1] / 100.0F));
         if (k > 255) {
            k = 255;
         }

         if (k < 0) {
            k = 0;
         }

         l = (int)(l - l * (this.m.snap[2] / 100.0F));
         if (l > 255) {
            l = 255;
         }

         if (l < 0) {
            l = 0;
         }
      }

      if (i1 == 1) {
         this.rd.setColor(new Color(0, 0, 0));
         this.rd.drawString(s, 335 - this.ftm.stringWidth(s) / 2 + 1, i + 1);
      }

      if (i1 == 2) {
         j = (j * 2 + this.m.csky[0] * 1) / 3;
         if (j > 255) {
            j = 255;
         }

         if (j < 0) {
            j = 0;
         }

         k = (k * 2 + this.m.csky[1] * 1) / 3;
         if (k > 255) {
            k = 255;
         }

         if (k < 0) {
            k = 0;
         }

         l = (l * 2 + this.m.csky[2] * 1) / 3;
         if (l > 255) {
            l = 255;
         }

         if (l < 0) {
            l = 0;
         }
      }

      this.rd.setColor(new Color(j, k, l));
      this.rd.drawString(s, 335 - this.ftm.stringWidth(s) / 2, i);
   }

   public int py(int i, int j, int k, int l) {
      return (i - j) * (i - j) + (k - l) * (k - l);
   }

   public void trackbg(boolean flag) {
      int i = 0;
      this.trkl++;
      if (this.trkl > this.trklim) {
         i = 1;
         this.trklim = (int)(Math.random() * 40.0);
         this.trkl = 0;
      }

      if (flag) {
         i = 0;
      }

      int j = 0;

      do {
         this.rd.drawImage(this.trackbg[i][j], this.trkx[j], 0, null);
         this.trkx[j]--;
         if (this.trkx[j] <= -670) {
            this.trkx[j] = 670;
         }
      } while (++j < 2);
   }

   public void stageselect(CheckPoints checkpoints, Control control) {
      this.rd.drawImage(this.br, 0, 0, null);
      this.rd.drawImage(this.select, 273, 45, null);
      if (checkpoints.stage != 1) {
         this.rd.drawImage(this.back[this.pback], 50, 110, null);
      }

      if (checkpoints.stage != 17) {
         this.rd.drawImage(this.next[this.pnext], 560, 110, null);
      }

      this.rd.setFont(new Font("SansSerif", 1, 13));
      this.ftm = this.rd.getFontMetrics();
      if (checkpoints.stage != 17) {
         this.drawcs(80, "Stage " + checkpoints.stage + "  >", 255, 255, 255, 3);
      } else {
         this.drawcs(80, "Final Party Stage  >", 255, 255, 255, 3);
      }

      this.drawcs(100, "| " + checkpoints.name + " |", 210, 210, 210, 3);
      this.rd.drawImage(this.contin[this.pcontin], 290, 325, null);
      this.rd.setFont(new Font("SansSerif", 1, 11));
      this.ftm = this.rd.getFontMetrics();
      this.drawcs(396, "You can also use Keyboard Arrows and Enter to navigate.", 82, 90, 0, 3);
      if (control.handb || control.enter) {
         this.dmflk = false;
         this.asay = "Stage " + checkpoints.stage + ":  " + checkpoints.name + " ";
         this.dudo = 150;
         this.m.trk = false;
         this.m.focus_point = 400;
         this.fase = 5;
         control.handb = false;
         control.enter = false;
         this.stages.stop();
         this.stages.unloadMod();
      }

      if (control.right && checkpoints.stage != 17) {
         if (checkpoints.stage != this.unlocked) {
            checkpoints.stage++;
            this.fase = 2;
            control.right = false;
         } else {
            this.fase = 4;
            this.lockcnt = 100;
            control.right = false;
         }
      }

      if (control.left && checkpoints.stage != 1) {
         checkpoints.stage--;
         this.fase = 2;
         control.left = false;
      }
   }

   public void snap(int i) {
      this.dmg = this.loadsnap(this.odmg);
      this.pwr = this.loadsnap(this.opwr);
      this.was = this.loadsnap(this.owas);
      this.lap = this.loadsnap(this.olap);
      this.pos = this.loadsnap(this.opos);
      int j = 0;

      do {
         this.rank[j] = this.loadsnap(this.orank[j]);
      } while (++j < 7);

      j = 0;

      do {
         this.cntdn[j] = this.loadsnap(this.ocntdn[j]);
      } while (++j < 4);

      this.yourwasted = this.loadsnap(this.oyourwasted);
      this.youlost = this.loadsnap(this.oyoulost);
      this.youwon = this.loadsnap(this.oyouwon);
      this.youwastedem = this.loadsnap(this.oyouwastedem);
      this.gameh = this.loadsnap(this.ogameh);
      this.loadingmusic = this.loadopsnap(this.oloadingmusic, i, 76);
      this.star[0] = this.loadopsnap(this.ostar[0], i, 0);
      this.star[1] = this.loadopsnap(this.ostar[1], i, 0);
      this.flaot = this.loadopsnap(this.oflaot, i, 1);
   }

   private Image loadsnap(Image image) {
      int i = image.getHeight(this.ob);
      int j = image.getWidth(this.ob);
      int[] ai = new int[j * i];
      PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, j, i, ai, 0, j);

      try {
         pixelgrabber.grabPixels();
      } catch (InterruptedException var12) {
      }

      for (int k = 0; k < j * i; k++) {
         if (ai[k] != -4144960 && ai[k] != ai[j * i - 1]) {
            Color color = new Color(ai[k]);
            int l = (int)(color.getRed() + color.getRed() * (this.m.snap[0] / 100.0F));
            if (l > 225) {
               l = 225;
            }

            if (l < 0) {
               l = 0;
            }

            int i1 = (int)(color.getGreen() + color.getGreen() * (this.m.snap[1] / 100.0F));
            if (i1 > 225) {
               i1 = 225;
            }

            if (i1 < 0) {
               i1 = 0;
            }

            int j1 = (int)(color.getBlue() + color.getBlue() * (this.m.snap[2] / 100.0F));
            if (j1 > 225) {
               j1 = 225;
            }

            if (j1 < 0) {
               j1 = 0;
            }

            Color color2 = new Color(l, i1, j1);
            ai[k] = color2.getRGB();
         } else if (ai[k] == -4144960) {
            int r = this.m.csky[0];
            int g = this.m.csky[1];
            int b = this.m.csky[2];
            if (this.m.darksky) {
               r += 30;
               g += 30;
               b += 30;
            }

            if (r > 255) {
               r = 255;
            }

            if (g > 255) {
               g = 255;
            }

            if (b > 255) {
               b = 255;
            }

            Color color1 = new Color(r, g, b);
            ai[k] = color1.getRGB();
         }
      }

      return this.createImage(new MemoryImageSource(j, i, ai, 0, j));
   }

   public void resetstat(int i) {
      this.arrace = false;
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
      this.cntwis = 0;
      this.bfskid = 0;
      this.pwait = 7;
      this.holdcnt = 0;
      this.holdit = false;
      this.winner = false;
      this.wasted = 0;
      int j = 0;

      do {
         this.dested[j] = 0;
      } while (++j < 7);

      this.sortcars(i);
   }

   public void drawstat(int i, int j, boolean flag, float f) {
      int[] ai = new int[4];
      int[] ai1 = new int[4];
      if (flag) {
         ai[0] = 78;
         ai1[0] = 351;
         ai[1] = 78;
         ai1[1] = 359;
         ai[2] = 175;
         ai1[2] = 359;
         ai[3] = 175;
         ai1[3] = 351;
         this.rd.setColor(new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]));
         this.rd.fillPolygon(ai, ai1, 4);
      }

      if (j > i) {
         j = i;
      }

      int k = (int)(98.0F * ((float)j / i));
      ai[0] = 77;
      ai1[0] = 351;
      ai[1] = 77;
      ai1[1] = 360;
      ai[2] = 77 + k;
      ai1[2] = 360;
      ai[3] = 77 + k;
      ai1[3] = 351;
      int l = 244;
      int i1 = 244;
      int j1 = 11;
      if (k > 33) {
         i1 = (int)(244.0F - 233.0F * ((k - 33) / 65.0F));
      }

      if (k > 70) {
         if (this.dmcnt < 10) {
            if (this.dmflk) {
               i1 = 170;
               this.dmflk = false;
            } else {
               this.dmflk = true;
            }
         }

         this.dmcnt++;
         if (this.dmcnt > 167.0 - k * 1.5) {
            this.dmcnt = 0;
         }
      }

      l = (int)(l + l * (this.m.snap[0] / 100.0F));
      if (l > 255) {
         l = 255;
      }

      if (l < 0) {
         l = 0;
      }

      i1 = (int)(i1 + i1 * (this.m.snap[1] / 100.0F));
      if (i1 > 255) {
         i1 = 255;
      }

      if (i1 < 0) {
         i1 = 0;
      }

      j1 = (int)(j1 + j1 * (this.m.snap[2] / 100.0F));
      if (j1 > 255) {
         j1 = 255;
      }

      if (j1 < 0) {
         j1 = 0;
      }

      this.rd.setColor(new Color(l, i1, j1));
      this.rd.fillPolygon(ai, ai1, 4);
      ai[0] = 77;
      ai1[0] = 371;
      ai[1] = 77;
      ai1[1] = 380;
      ai[2] = (int)(77.0F + f);
      ai1[2] = 380;
      ai[3] = (int)(77.0F + f);
      ai1[3] = 371;
      int var12 = 128;
      if (f == 98.0F) {
         var12 = 64;
      }

      i1 = (int)(190.0 + f * 0.37);
      int var18 = 244;
      if (this.auscnt < 45 && this.aflk) {
         var12 = 128;
         i1 = 244;
         var18 = 244;
      }

      var12 = (int)(var12 + var12 * (this.m.snap[0] / 100.0F));
      if (var12 > 255) {
         var12 = 255;
      }

      if (var12 < 0) {
         var12 = 0;
      }

      i1 = (int)(i1 + i1 * (this.m.snap[1] / 100.0F));
      if (i1 > 255) {
         i1 = 255;
      }

      if (i1 < 0) {
         i1 = 0;
      }

      var18 = (int)(var18 + var18 * (this.m.snap[2] / 100.0F));
      if (var18 > 255) {
         var18 = 255;
      }

      if (var18 < 0) {
         var18 = 0;
      }

      this.rd.setColor(new Color(var12, i1, var18));
      this.rd.fillPolygon(ai, ai1, 4);
      if (!this.holdit && j > i * 0.8) {
         if (this.dmflk) {
            this.rd.setColor(new Color(255, 140, 10));
            if (!this.mutes) {
               this.warnp.play();
            }
         } else {
            this.rd.setColor(new Color(255, 10, 10));
         }

         this.rd.drawString("WARNING: damage over 80%!", 27, 340);
      }
   }

   private Image bressed(Image image) {
      int i = image.getHeight(this.ob);
      int j = image.getWidth(this.ob);
      int[] ai = new int[j * i];
      PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, j, i, ai, 0, j);

      try {
         pixelgrabber.grabPixels();
      } catch (InterruptedException var8) {
      }

      Color color = new Color(247, 255, 165);

      for (int k = 0; k < j * i; k++) {
         if (ai[k] != ai[j * i - 1]) {
            ai[k] = color.getRGB();
         }
      }

      return this.createImage(new MemoryImageSource(j, i, ai, 0, j));
   }

   public void loading() {
      this.rd.setColor(new Color(0, 0, 0));
      this.rd.fillRect(0, 0, 670, 400);
      this.rd.drawImage(this.sign, 297, 10, this);
      this.rd.drawImage(this.hello, 60, 80, this);
      this.rd.setColor(new Color(198, 214, 255));
      this.rd.fillRoundRect(185, 315, 300, 80, 30, 70);
      this.rd.setColor(new Color(128, 167, 255));
      this.rd.drawRoundRect(185, 315, 300, 80, 30, 70);
      this.rd.drawImage(this.loadbar, 216, 340, this);
      this.rd.setFont(new Font("SansSerif", 1, 11));
      this.ftm = this.rd.getFontMetrics();
      this.drawcs(333, "Loading game files, please wait.", 0, 0, 0, 3);
      this.rd.setColor(new Color(255, 255, 255));
      this.rd.fillRect(230, 373, 210, 17);
      this.shload = this.shload + (this.dnload + 10.0F - this.shload) / 100.0F;
      if (this.shload > this.kbload) {
         this.shload = this.kbload;
      }

      if (this.dnload == this.kbload) {
         this.shload = this.kbload;
      }

      this.drawcs(
         385,
         "" + (int)((26.0F + this.shload / this.kbload * 200.0F) / 226.0F * 100.0F) + " % loaded    |    " + (this.kbload - (int)this.shload) + " KB remaining",
         32,
         64,
         128,
         3
      );
      this.rd.setColor(new Color(32, 64, 128));
      this.rd.fillRect(222, 346, 26 + (int)(this.shload / this.kbload * 200.0F), 10);
   }

   public xtGraphics(Medium medium, Graphics g, Applet applet) {
      this.fase = 111;
      this.oldfase = 0;
      this.starcnt = 0;
      this.unlocked = 1;
      this.lockcnt = 0;
      this.opselect = 1;
      this.shaded = false;
      this.flipo = 0;
      this.nextc = false;
      this.gatey = 0;
      this.looped = 1;
      this.sc = new int[7];
      this.holdit = false;
      this.holdcnt = 0;
      this.winner = false;
      this.flexpix = new int[268000];
      this.smokey = new int[94132];
      this.flatrstart = 0;
      this.runtyp = 0;
      this.trackbg = new Image[2][2];
      this.dude = new Image[3];
      this.duds = 0;
      this.dudo = 0;
      this.next = new Image[2];
      this.back = new Image[2];
      this.contin = new Image[2];
      this.ostar = new Image[2];
      this.star = new Image[3];
      this.pcontin = 0;
      this.pnext = 0;
      this.pback = 0;
      this.pstar = 0;
      this.orank = new Image[7];
      this.rank = new Image[7];
      this.ocntdn = new Image[4];
      this.cntdn = new Image[4];
      this.gocnt = 0;
      this.engs = new AudioClip[5][5];
      this.pengs = new boolean[5];
      this.air = new AudioClip[6];
      this.aird = false;
      this.grrd = false;
      this.crash = new AudioClip[3];
      this.lowcrash = new AudioClip[3];
      this.pwastd = false;
      this.skid = new AudioClip[3];
      this.dustskid = new AudioClip[3];
      this.mutes = false;
      this.stracks = new RadicalMod[17];
      this.loadedt = new boolean[17];
      this.lastload = -1;
      this.mutem = false;
      this.sunny = false;
      this.macn = false;
      this.arrace = false;
      this.ana = 0;
      this.cntan = 0;
      this.cntovn = 0;
      this.flk = false;
      this.tcnt = 30;
      this.tflk = false;
      this.say = "";
      this.wasay = false;
      this.clear = 0;
      this.posit = 0;
      this.wasted = 0;
      this.laps = 0;
      this.dested = new int[7];
      this.dmcnt = 0;
      this.dmflk = false;
      this.pwcnt = 0;
      this.pwflk = false;
      this.loop = "";
      this.spin = "";
      this.asay = "";
      this.auscnt = 45;
      this.aflk = false;
      this.kbload = 0;
      this.dnload = 0;
      this.shload = 0.0F;
      this.radpx = 147;
      this.pin = 60;
      this.trkl = 0;
      this.trklim = (int)(Math.random() * 40.0);
      this.flkat = (int)(60.0 + 140.0 * Math.random());
      this.movly = (int)(100.0 + 100.0 * Math.random());
      this.xdu = 272;
      this.ydu = 2;
      this.gxdu = 0;
      this.gydu = 0;
      this.pgady = new int[9];
      this.pgas = new boolean[9];
      this.lxm = -10;
      this.lym = -10;
      this.pwait = 7;
      this.stopcnt = 0;
      this.cntwis = 0;
      this.crshturn = 0;
      this.bfcrash = 0;
      this.bfskid = 0;
      this.crashup = false;
      this.skidup = false;
      this.skflg = 0;
      this.dskflg = 0;
      this.flatr = 0;
      this.flyr = 0;
      this.flyrdest = 0;
      this.flang = 0;
      this.flangados = 0;
      this.blackn = 0.0F;
      this.blacknados = 0.0F;
      this.m = medium;
      this.app = applet;
      this.rd = g;
      MediaTracker mediatracker = new MediaTracker(this.app);
      this.hello = Toolkit.getDefaultToolkit().getImage(xtGraphics.class.getResource("hello.gif"));
      mediatracker.addImage(this.hello, 0);

      try {
         mediatracker.waitForID(0);
      } catch (Exception var8) {
      }

      this.sign = Toolkit.getDefaultToolkit().getImage(xtGraphics.class.getResource("sign.gif"));
      mediatracker.addImage(this.sign, 0);

      try {
         mediatracker.waitForID(0);
      } catch (Exception var7) {
      }

      this.loadbar = Toolkit.getDefaultToolkit().getImage(xtGraphics.class.getResource("loadbar.gif"));
      mediatracker.addImage(this.loadbar, 0);

      try {
         mediatracker.waitForID(0);
      } catch (Exception var6) {
      }

      int i = 0;

      do {
         this.loadedt[i] = false;
      } while (++i < 17);
   }

   public void maini(Control control) {
      if (this.lastload >= 0 && this.loadedt[this.lastload]) {
         this.stracks[this.lastload].unloadMod();
      }

      if (this.flipo == 0) {
         this.bgmy[0] = 0;
         this.bgmy[1] = 400;
         this.app.setCursor(new Cursor(0));
      }

      int i = 0;

      do {
         this.rd.drawImage(this.bgmain, 0, this.bgmy[i], null);
         this.bgmy[i] = this.bgmy[i] - 20;
         if (this.bgmy[i] <= -400) {
            this.bgmy[i] = 400;
         }
      } while (++i < 2);

      if (this.flipo > this.flkat) {
         this.rd.drawImage(this.logomadbg, 67 + (int)(4.0 - Math.random() * 8.0), 143 + (int)(4.0 - Math.random() * 8.0), null);
      } else {
         this.rd.drawImage(this.logomadbg, 67, 143, null);
      }

      this.rd.drawImage(this.dude[0], this.xdu, this.ydu, null);
      this.rd.drawImage(this.logocars, 12, 28, null);
      if (this.flipo > this.flkat) {
         this.rd.drawImage(this.logomadnes, 99 + (int)(4.0 - Math.random() * 8.0), 148 + (int)(4.0 - Math.random() * 8.0), null);
      } else {
         this.rd.drawImage(this.logomadnes, 99, 148, null);
      }

      this.flipo++;
      if (this.flipo > this.flkat + 36) {
         this.flipo = 1;
         this.flkat = (int)(60.0 + 140.0 * Math.random());
      }

      if (this.movly <= 10) {
         if (this.movly == 10 || this.movly == 8 || this.movly == 6 || this.movly == 4 || this.movly == 2) {
            this.gxdu = (int)(this.xdu + 200 - 400.0 * Math.random());
            this.gydu = (int)(this.ydu + 200 - 400.0 * Math.random());
            if (this.movly == 2) {
               this.gxdu = 272;
               this.gydu = 2;
            }

            this.movly--;
         }

         this.xdu = this.xdu + (this.gxdu - this.xdu) / 15;
         this.ydu = this.ydu + (this.gydu - this.ydu) / 15;
         if (this.movly != 1) {
            if (this.pys(this.xdu, this.gxdu, this.ydu, this.gydu) < 20.0F) {
               this.movly--;
            }
         } else {
            if (this.xdu > this.gxdu) {
               this.xdu--;
            } else {
               this.xdu++;
            }

            if (this.ydu > this.gydu) {
               this.ydu--;
            } else {
               this.ydu++;
            }

            if (this.pys(this.xdu, this.gxdu, this.ydu, this.gydu) < 2.0F) {
               this.movly--;
            }
         }

         if (this.movly == 0) {
            this.xdu = 272;
            this.ydu = 2;
            this.movly = (int)(100.0 + 100.0 * Math.random());
         }
      } else if (this.flipo >= this.movly) {
         this.movly = 10;
      }

      this.rd.drawImage(this.opback, 179, 212, null);
      this.rd.drawImage(this.nfmcoms, 237, 195, null);
      this.rd.drawImage(this.byrd, 264, 383, null);
      if (control.up) {
         this.opselect--;
         if (this.opselect == -1) {
            this.opselect = 2;
         }

         control.up = false;
      }

      if (control.down) {
         this.opselect++;
         if (this.opselect == 3) {
            this.opselect = 0;
         }

         control.down = false;
      }

      if (this.opselect == 0) {
         if (this.shaded) {
            this.rd.setColor(new Color(140, 70, 0));
            this.rd.fillRect(278, 246, 110, 22);
            this.aflk = false;
         }

         if (this.aflk) {
            this.rd.setColor(new Color(200, 255, 0));
            this.aflk = false;
         } else {
            this.rd.setColor(new Color(255, 128, 0));
            this.aflk = true;
         }

         this.rd.drawRoundRect(278, 246, 110, 22, 7, 20);
      } else {
         this.rd.setColor(new Color(0, 0, 0));
         this.rd.drawRoundRect(278, 246, 110, 22, 7, 20);
      }

      if (this.opselect == 1) {
         if (this.shaded) {
            this.rd.setColor(new Color(140, 70, 0));
            this.rd.fillRect(234, 275, 196, 22);
            this.aflk = false;
         }

         if (this.aflk) {
            this.rd.setColor(new Color(200, 128, 0));
            this.aflk = false;
         } else {
            this.rd.setColor(new Color(255, 128, 0));
            this.aflk = true;
         }

         this.rd.drawRoundRect(234, 275, 196, 22, 7, 20);
      } else {
         this.rd.setColor(new Color(0, 0, 0));
         this.rd.drawRoundRect(234, 275, 196, 22, 7, 20);
      }

      if (this.opselect == 2) {
         if (this.shaded) {
            this.rd.setColor(new Color(140, 70, 0));
            this.rd.fillRect(290, 306, 85, 22);
            this.aflk = false;
         }

         if (this.aflk) {
            this.rd.setColor(new Color(200, 0, 0));
            this.aflk = false;
         } else {
            this.rd.setColor(new Color(255, 128, 0));
            this.aflk = true;
         }

         this.rd.drawRoundRect(290, 306, 85, 22, 7, 20);
      } else {
         this.rd.setColor(new Color(0, 0, 0));
         this.rd.drawRoundRect(290, 306, 85, 22, 7, 20);
      }

      this.rd.drawImage(this.opti, 241, 250, null);
      if (control.enter || control.handb) {
         if (this.opselect == 0) {
            if (this.unlocked == 1 && this.oldfase == 0) {
               this.oldfase = -9;
               this.fase = 11;
            } else {
               this.fase = -9;
            }
         }

         if (this.opselect == 1) {
            this.oldfase = 10;
            this.fase = 11;
         }

         if (this.opselect == 2) {
            this.spl = 0;
            this.fase = 8;
            this.dslog.flush();
         }

         this.flipo = 0;
         control.enter = false;
         control.handb = false;
      }

      if (this.shaded) {
         this.app.repaint();

         try {
            Thread.sleep(100L);
         } catch (InterruptedException var4) {
         }
      }
   }

   public void musicomp(int i, Control control) {
      this.hipnoload(i, true);
      if (control.handb || control.enter) {
         System.gc();
         this.fase = 0;
         control.handb = false;
         control.enter = false;
      }
   }

   public void drawSmokeCarsbg() {
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
         this.flangados = (int)(this.m.random() * 6.0F + 2.0F);
         this.blackn = 0.0F;
         this.blacknados = this.m.random() * 0.4F;
      }

      int i = 0;

      do {
         int j = 0;

         do {
            if (this.smokey[i + j * 466] != this.smokey[0]) {
               float f = this.pys(i, 233, j, this.flyr);
               int k = (int)((i - 233) / f * this.flatr);
               int l = (int)((j - this.flyr) / f * this.flatr);
               int i1 = i + k + 100 + (j + l + 110) * 670;
               if (i + k + 100 < 670 && i + k + 100 > 0 && j + l + 110 < 400 && j + l + 110 > 0 && i1 < 268000 && i1 >= 0) {
                  Color color = new Color(this.flexpix[i1]);
                  Color color1 = new Color(this.smokey[i + j * 466]);
                  float f1 = (255.0F - color1.getRed()) / 255.0F;
                  int j1 = (int)((color.getRed() * (this.flang * f1) + color1.getRed() * (1.0F - f1)) / (this.flang * f1 + (1.0F - f1) + this.blackn));
                  if (j1 > 255) {
                     j1 = 255;
                  }

                  if (j1 < 0) {
                     j1 = 0;
                  }

                  Color color2 = new Color(j1, j1, j1);
                  this.flexpix[i1] = color2.getRGB();
               }
            }
         } while (++j < 202);
      } while (++i < 466);

      this.blackn = this.blackn + this.blacknados;
      this.flang = this.flang + this.flangados;
      this.flatr = this.flatr + 10 + this.flatrstart * 2;
      Image image = this.createImage(new MemoryImageSource(670, 400, this.flexpix, 0, 670));
      this.rd.drawImage(image, 0, 0, null);
   }

   public void loaddata(int i) {
      this.kbload = 641;
      this.sunny = false;
      String s = "default/";
      String s1 = "au";
      if (i == 2) {
         this.kbload = 966;
         this.sunny = true;
         s = "JavaNew/";
         s1 = "wav";
      }

      String s2 = System.getProperty("os.name");
      if (!s2.startsWith("Win")) {
         this.macn = true;
      }

      this.runtyp = 176;
      this.runner = new Thread(this);
      this.runner.start();
      this.loadimages();
      this.cars = new RadicalMod("music/cars.radq", this.app);
      this.dnload += 27;
      int j = 0;

      do {
         int k = 0;

         do {
            this.engs[k][j] = this.getSound("sounds/" + s + "" + k + "" + j + ".au");
            this.dnload += 3;
         } while (++k < 5);

         this.pengs[j] = false;
      } while (++j < 5);

      this.stages = new RadicalMod("music/stages.radq", this.app);
      this.dnload += 91;
      j = 0;

      do {
         this.air[j] = this.getSound("sounds/" + s + "air" + j + ".au");
         this.dnload += 2;
      } while (++j < 6);

      j = 0;

      do {
         this.crash[j] = this.getSound("sounds/" + s + "crash" + (j + 1) + "." + s1);
         if (i == 2) {
            this.dnload += 10;
         } else {
            this.dnload += 7;
         }
      } while (++j < 3);

      j = 0;

      do {
         this.lowcrash[j] = this.getSound("sounds/" + s + "lowcrash" + (j + 1) + "." + s1);
         if (i == 2) {
            this.dnload += 10;
         } else {
            this.dnload += 3;
         }
      } while (++j < 3);

      this.tires = this.getSound("sounds/" + s + "tires." + s1);
      if (i == 2) {
         this.dnload += 24;
      } else {
         this.dnload += 4;
      }

      this.checkpoint = this.getSound("sounds/" + s + "checkpoint." + s1);
      if (i == 2) {
         this.dnload += 24;
      } else {
         this.dnload += 6;
      }

      this.carfixed = this.getSound("sounds/" + s + "carfixed." + s1);
      if (i == 2) {
         this.dnload += 24;
      } else {
         this.dnload += 10;
      }

      this.powerup = this.getSound("sounds/" + s + "powerup." + s1);
      if (i == 2) {
         this.dnload += 42;
      } else {
         this.dnload += 8;
      }

      this.three = this.getSound("sounds/" + s + "three." + s1);
      if (i == 2) {
         this.dnload += 24;
      } else {
         this.dnload += 4;
      }

      this.two = this.getSound("sounds/" + s + "two." + s1);
      if (i == 2) {
         this.dnload += 24;
      } else {
         this.dnload += 2;
      }

      this.one = this.getSound("sounds/" + s + "one." + s1);
      if (i == 2) {
         this.dnload += 24;
      } else {
         this.dnload += 4;
      }

      this.go = this.getSound("sounds/" + s + "go." + s1);
      if (i == 2) {
         this.dnload += 24;
      } else {
         this.dnload += 4;
      }

      this.wastd = this.getSound("sounds/" + s + "wasted." + s1);
      if (i == 2) {
         this.dnload += 24;
      } else {
         this.dnload += 4;
      }

      this.warnp = this.getSound("sounds/pitch.wav");
      this.dnload += 16;
      this.firewasted = this.getSound("sounds/" + s + "firewasted." + s1);
      if (i == 2) {
         this.dnload += 24;
      } else {
         this.dnload += 10;
      }

      j = 0;

      do {
         this.skid[j] = this.getSound("sounds/" + s + "skid" + (j + 1) + "." + s1);
         if (i == 2) {
            this.dnload += 22;
         } else {
            this.dnload += 6;
         }
      } while (++j < 3);

      j = 0;

      do {
         this.dustskid[j] = this.getSound("sounds/" + s + "dustskid" + (j + 1) + "." + s1);
         if (i == 2) {
            this.dnload += 22;
         } else {
            this.dnload += 7;
         }
      } while (++j < 3);
   }

   public void clicknow() {
      this.rd.setColor(new Color(198, 214, 255));
      this.rd.fillRoundRect(185, 315, 300, 80, 30, 70);
      this.rd.setColor(new Color(128, 167, 255));
      this.rd.drawRoundRect(185, 315, 300, 80, 30, 70);
      if (this.aflk) {
         this.drawcs(355, "Click here to let the madness begin!", 0, 0, 0, 3);
         this.aflk = false;
      } else {
         this.drawcs(355, "Click here to let the madness begin!", 0, 67, 200, 3);
         this.aflk = true;
      }
   }

   private Image loadimage(byte[] abyte0, MediaTracker mediatracker, Toolkit toolkit) {
      Image image = toolkit.createImage(abyte0);
      mediatracker.addImage(image, 0);

      try {
         mediatracker.waitForID(0);
      } catch (Exception var6) {
      }

      return image;
   }

   public void rad(int i) {
      if (i == 0) {
         this.powerup.play();
         this.radpx = 147;
         this.pin = 0;
      }

      this.trackbg(false);
      this.rd.setColor(new Color(0, 0, 0));
      this.rd.fillRect(0, 110, 670, 59);
      if (this.pin != 0) {
         this.rd.drawImage(this.radicalplay, this.radpx + (int)(8.0 * Math.random() - 4.0), 110, null);
      } else {
         this.rd.drawImage(this.radicalplay, 147, 110, null);
      }

      if (this.radpx != 147) {
         this.radpx += 40;
         if (this.radpx > 670) {
            this.radpx = -453;
         }
      } else if (this.pin != 0) {
         this.pin--;
      }

      if (i == 40) {
         this.radpx = 148;
         this.pin = 7;
      }

      if (this.radpx == 147) {
         this.rd.setFont(new Font("SansSerif", 1, 11));
         this.ftm = this.rd.getFontMetrics();
         this.drawcs(160 + (int)(5.0F * this.m.random()), "Radicalplay.com", 112, 120, 143, 3);
      }

      this.rd.setFont(new Font("SansSerif", 1, 11));
      this.ftm = this.rd.getFontMetrics();
      if (this.aflk) {
         this.drawcs(190, "And we are never going to find the new unless we get a little crazy...", 112, 120, 143, 3);
         this.aflk = false;
      } else {
         this.drawcs(192, "And we are never going to find the new unless we get a little crazy...", 150, 150, 150, 3);
         this.aflk = true;
      }

      this.rd.drawImage(this.rpro, 210, 240, null);
   }

   public void skid(int i, float f) {
      if (this.bfcrash == 0 && this.bfskid == 0 && f > 150.0F) {
         if (i == 0) {
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

   public int xs(int i, int j) {
      if (j < 50) {
         j = 50;
      }

      return (j - this.m.focus_point) * (this.m.cx - i) / j + i;
   }

   public void cantreply() {
      this.rd.setColor(new Color(64, 143, 223));
      this.rd.fillRoundRect(135, 73, 400, 23, 7, 20);
      this.rd.setColor(new Color(0, 89, 223));
      this.rd.drawRoundRect(135, 73, 400, 23, 7, 20);
      this.drawcs(89, "There's not enough replay data to play available, please try again later.", 255, 255, 255, 1);
   }

   public void stopallnow() {
      int i = 0;

      do {
         if (this.loadedt[i]) {
            this.stracks[i].unloadAll();
            this.stracks[i] = null;
         }
      } while (++i < 17);

      i = 0;

      do {
         this.engs[0][i].stop();
         this.engs[1][i].stop();
      } while (++i < 5);

      i = 0;

      do {
         this.air[i].stop();
      } while (++i < 6);

      this.wastd.stop();
      this.cars.unloadAll();
      this.stages.unloadAll();
   }

   public void inishcarselect() {
      this.carsbginflex();
      this.flatrstart = 0;
      this.m.lightson = false;
      this.cars.loadMod(200, 7900, 125, this.sunny, this.macn);
      this.pnext = 0;
      this.pback = 0;
   }

   public void carselect(Control control, ContO[] aconto, Madness madness) {
      this.cars.play();
      if (this.flatrstart == 6) {
         this.rd.drawImage(this.carsbg, 0, 0, null);
      } else if (this.flatrstart <= 1) {
         this.drawSmokeCarsbg();
      } else {
         this.rd.setColor(new Color(255, 255, 255));
         this.rd.fillRect(0, 0, 670, 400);
         this.carsbginflex();
         this.flatrstart = 6;
      }

      this.rd.drawImage(this.selectcar, 256, 12, null);
      this.m.crs = true;
      this.m.x = -335;
      this.m.y = -500;
      this.m.z = -50;
      this.m.xz = 0;
      this.m.zy = 10;
      this.m.ground = 470;
      aconto[this.sc[0]].d(this.rd);
      if (this.flipo == 0) {
         this.rd.setFont(new Font("SansSerif", 1, 13));
         this.ftm = this.rd.getFontMetrics();
         byte byte0 = 0;
         if (this.flatrstart < 6) {
            byte0 = 2;
         }

         if (this.aflk) {
            this.drawcs(70 + byte0, this.names[this.sc[0]], 240, 240, 240, 3);
            this.aflk = false;
         } else {
            this.drawcs(70, this.names[this.sc[0]], 176, 176, 176, 3);
            this.aflk = true;
         }

         aconto[this.sc[0]].z = 950;
         if (this.sc[0] == 13) {
            aconto[this.sc[0]].z = 1000;
         }

         aconto[this.sc[0]].y = -34 - aconto[this.sc[0]].grat;
         aconto[this.sc[0]].x = 0;
         aconto[this.sc[0]].xz += 5;
         aconto[this.sc[0]].zy = 0;
         aconto[this.sc[0]].wzy -= 10;
         if (aconto[this.sc[0]].wzy < -45) {
            aconto[this.sc[0]].wzy += 45;
         }

         if (this.sc[0] != 0) {
            this.rd.drawImage(this.back[this.pback], 30, 250, null);
         }

         if (this.sc[0] != 15) {
            this.rd.drawImage(this.next[this.pnext], 580, 250, null);
         }

         if ((this.sc[0] - 7) * 2 >= this.unlocked) {
            if (this.gatey == 300) {
               int i = 0;

               do {
                  this.pgas[i] = false;
                  this.pgady[i] = 0;
               } while (++i < 9);

               this.pgas[0] = true;
            }

            int j = 0;

            do {
               this.rd.drawImage(this.pgate, this.pgatx[j], this.pgaty[j] + this.pgady[j] - this.gatey, null);
               if (this.flatrstart == 6) {
                  if (this.pgas[j]) {
                     this.pgady[j] = this.pgady[j] - (80 + 100 / (j + 1) - Math.abs(this.pgady[j])) / 3;
                     if (this.pgady[j] < -(70 + 100 / (j + 1))) {
                        this.pgas[j] = false;
                        if (j != 8) {
                           this.pgas[j + 1] = true;
                        }
                     }
                  } else {
                     this.pgady[j] = this.pgady[j] + (80 + 100 / (j + 1) - Math.abs(this.pgady[j])) / 3;
                     if (this.pgady[j] > 0) {
                        this.pgady[j] = 0;
                     }
                  }
               }
            } while (++j < 9);

            if (this.gatey != 0) {
               this.gatey -= 100;
            }

            if (this.flatrstart == 6) {
               this.drawcs(335, "[ Car Locked ]", 210, 210, 210, 3);
               this.drawcs(355, "This car unlocks when stage " + (this.sc[0] - 7) * 2 + " is completed...", 181, 120, 40, 3);
            }
         } else {
            if (this.flatrstart == 6) {
               this.rd.setFont(new Font("SansSerif", 1, 11));
               this.ftm = this.rd.getFontMetrics();
               this.rd.setColor(new Color(181, 120, 40));
               this.rd.drawString("Top Speed:", 33, 318);
               this.rd.drawImage(this.statb, 97, 312, null);
               this.rd.drawString("Acceleration:", 23, 333);
               this.rd.drawImage(this.statb, 97, 327, null);
               this.rd.drawString("Handling:", 45, 348);
               this.rd.drawImage(this.statb, 97, 342, null);
               this.rd.drawString("Stunts:", 430, 318);
               this.rd.drawImage(this.statb, 471, 312, null);
               this.rd.drawString("Strength:", 418, 333);
               this.rd.drawImage(this.statb, 471, 327, null);
               this.rd.drawString("Endurance:", 408, 348);
               this.rd.drawImage(this.statb, 471, 342, null);
               this.rd.setColor(new Color(0, 0, 0));
               float f = (madness.swits[this.sc[0]][2] - 220) / 90.0F;
               if (f < 0.2) {
                  f = 0.2F;
               }

               this.rd.fillRect((int)(97.0F + 156.0F * f), 312, (int)(156.0F * (1.0F - f) + 1.0F), 7);
               f = madness.acelf[this.sc[0]][1] * madness.acelf[this.sc[0]][0] * madness.acelf[this.sc[0]][2] * madness.grip[this.sc[0]] / 7700.0F;
               if (f > 1.0F) {
                  f = 1.0F;
               }

               this.rd.fillRect((int)(97.0F + 156.0F * f), 327, (int)(156.0F * (1.0F - f) + 1.0F), 7);
               f = this.dishandle[this.sc[0]];
               this.rd.fillRect((int)(97.0F + 156.0F * f), 342, (int)(156.0F * (1.0F - f) + 1.0F), 7);
               f = (madness.airc[this.sc[0]] * madness.airs[this.sc[0]] * madness.bounce[this.sc[0]] + 28.0F) / 139.0F;
               if (f > 1.0F) {
                  f = 1.0F;
               }

               this.rd.fillRect((int)(471.0F + 156.0F * f), 312, (int)(156.0F * (1.0F - f) + 1.0F), 7);
               float f1 = 0.5F;
               if (this.sc[0] == 9) {
                  f1 = 0.8F;
               }

               f = (madness.moment[this.sc[0]] + f1) / 2.6F;
               if (f > 1.0F) {
                  f = 1.0F;
               }

               this.rd.fillRect((int)(471.0F + 156.0F * f), 327, (int)(156.0F * (1.0F - f) + 1.0F), 7);
               f = this.outdam[this.sc[0]];
               this.rd.fillRect((int)(471.0F + 156.0F * f), 342, (int)(156.0F * (1.0F - f) + 1.0F), 7);
               this.rd.drawImage(this.statbo, 97, 312, null);
               this.rd.drawImage(this.statbo, 97, 327, null);
               this.rd.drawImage(this.statbo, 97, 342, null);
               this.rd.drawImage(this.statbo, 471, 312, null);
               this.rd.drawImage(this.statbo, 471, 327, null);
               this.rd.drawImage(this.statbo, 471, 342, null);
            }

            this.rd.drawImage(this.contin[this.pcontin], 290, 360, null);
         }
      } else {
         this.pback = 0;
         this.pnext = 0;
         this.gatey = 300;
         if (this.flipo > 10) {
            aconto[this.sc[0]].y -= 100;
            if (this.nextc) {
               aconto[this.sc[0]].zy += 20;
            } else {
               aconto[this.sc[0]].zy -= 20;
            }
         } else {
            if (this.flipo == 10) {
               if (this.nextc) {
                  this.sc[0]++;
               } else {
                  this.sc[0]--;
               }

               aconto[this.sc[0]].z = 950;
               aconto[this.sc[0]].y = -34 - aconto[this.sc[0]].grat - 1100;
               aconto[this.sc[0]].x = 0;
               aconto[this.sc[0]].zy = 0;
            }

            aconto[this.sc[0]].y += 100;
         }

         this.flipo--;
      }

      this.rd.setFont(new Font("SansSerif", 1, 11));
      this.ftm = this.rd.getFontMetrics();
      this.drawcs(396, "You can also use Keyboard Arrows and Enter to navigate.", 82, 90, 0, 3);
      if (control.right) {
         control.right = false;
         if (this.sc[0] != 15 && this.flipo == 0) {
            if (this.flatrstart > 1) {
               this.flatrstart = 0;
            }

            this.nextc = true;
            this.flipo = 20;
         }
      }

      if (control.left) {
         control.left = false;
         if (this.sc[0] != 0 && this.flipo == 0) {
            if (this.flatrstart > 1) {
               this.flatrstart = 0;
            }

            this.nextc = false;
            this.flipo = 20;
         }
      }

      if (control.handb || control.enter) {
         if (this.flipo == 0 && (this.sc[0] - 7) * 2 < this.unlocked) {
            this.lastload = -11;
            this.cars.stop();
            this.cars.unloadMod();
            this.m.crs = false;
            this.fase = 2;
         }

         control.handb = false;
         control.enter = false;
      }
   }

   public void ctachm(int i, int j, int k, Control control) {
      if (this.fase == 1) {
         if (k == 1) {
            if (this.over(this.next[0], i, j, 560, 110)) {
               this.pnext = 1;
            }

            if (this.over(this.back[0], i, j, 50, 110)) {
               this.pback = 1;
            }

            if (this.over(this.contin[0], i, j, 290, 325)) {
               this.pcontin = 1;
            }
         }

         if (k == 2) {
            if (this.pnext == 1) {
               control.right = true;
            }

            if (this.pback == 1) {
               control.left = true;
            }

            if (this.pcontin == 1) {
               control.enter = true;
            }
         }
      }

      if (this.fase == 3) {
         if (k == 1 && this.over(this.contin[0], i, j, 290, 325)) {
            this.pcontin = 1;
         }

         if (k == 2 && this.pcontin == 1) {
            control.enter = true;
            this.pcontin = 0;
         }
      }

      if (this.fase == 4) {
         if (k == 1 && this.over(this.back[0], i, j, 305, 320)) {
            this.pback = 1;
         }

         if (k == 2 && this.pback == 1) {
            control.enter = true;
            this.pback = 0;
         }
      }

      if (this.fase == 6) {
         if (k == 1 && (this.over(this.star[0], i, j, 294, 360) || this.over(this.star[0], i, j, 294, 270))) {
            this.pstar = 2;
         }

         if (k == 2 && this.pstar == 2) {
            control.enter = true;
            this.pstar = 1;
         }
      }

      if (this.fase == 7) {
         if (k == 1) {
            if (this.over(this.next[0], i, j, 580, 250)) {
               this.pnext = 1;
            }

            if (this.over(this.back[0], i, j, 30, 250)) {
               this.pback = 1;
            }

            if (this.over(this.contin[0], i, j, 290, 360)) {
               this.pcontin = 1;
            }
         }

         if (k == 2) {
            if (this.pnext == 1) {
               control.right = true;
            }

            if (this.pback == 1) {
               control.left = true;
            }

            if (this.pcontin == 1) {
               control.enter = true;
               this.pcontin = 0;
            }
         }
      }

      if (this.fase == -5) {
         this.lxm = i;
         this.lym = j;
         if (k == 1 && this.over(this.contin[0], i, j, 290, 350 - this.pin)) {
            this.pcontin = 1;
         }

         if (k == 2 && this.pcontin == 1) {
            control.enter = true;
            this.pcontin = 0;
         }
      }

      if (this.fase == -7) {
         if (k == 1) {
            if (this.overon(264, 45, 137, 22, i, j)) {
               this.opselect = 0;
               this.shaded = true;
            }

            if (this.overon(255, 73, 155, 22, i, j)) {
               this.opselect = 1;
               this.shaded = true;
            }

            if (this.overon(238, 99, 190, 22, i, j)) {
               this.opselect = 2;
               this.shaded = true;
            }

            if (this.overon(276, 125, 109, 22, i, j)) {
               this.opselect = 3;
               this.shaded = true;
            }
         }

         if (k == 2 && this.shaded) {
            control.enter = true;
            this.shaded = false;
         }

         if (k == 0 && (i != this.lxm || j != this.lym)) {
            if (this.overon(264, 45, 137, 22, i, j)) {
               this.opselect = 0;
            }

            if (this.overon(255, 73, 155, 22, i, j)) {
               this.opselect = 1;
            }

            if (this.overon(238, 99, 190, 22, i, j)) {
               this.opselect = 2;
            }

            if (this.overon(276, 125, 109, 22, i, j)) {
               this.opselect = 3;
            }

            this.lxm = i;
            this.lym = j;
         }
      }

      if (this.fase == 10) {
         if (k == 1) {
            if (this.overon(278, 246, 110, 22, i, j)) {
               this.opselect = 0;
               this.shaded = true;
            }

            if (this.overon(234, 275, 196, 22, i, j)) {
               this.opselect = 1;
               this.shaded = true;
            }

            if (this.overon(290, 306, 85, 22, i, j)) {
               this.opselect = 2;
               this.shaded = true;
            }
         }

         if (k == 2 && this.shaded) {
            control.enter = true;
            this.shaded = false;
         }

         if (k == 0 && (i != this.lxm || j != this.lym)) {
            if (this.overon(278, 246, 110, 22, i, j)) {
               this.opselect = 0;
            }

            if (this.overon(234, 275, 196, 22, i, j)) {
               this.opselect = 1;
            }

            if (this.overon(290, 306, 85, 22, i, j)) {
               this.opselect = 2;
            }

            this.lxm = i;
            this.lym = j;
         }
      }

      if (this.fase == 11) {
         if (this.flipo >= 1 && this.flipo <= 13) {
            if (k == 1 && this.over(this.next[0], i, j, 600, 370)) {
               this.pnext = 1;
            }

            if (k == 2 && this.pnext == 1) {
               control.right = true;
               this.pnext = 0;
            }
         }

         if (this.flipo >= 3 && this.flipo <= 15) {
            if (k == 1 && this.over(this.back[0], i, j, 10, 370)) {
               this.pback = 1;
            }

            if (k == 2 && this.pback == 1) {
               control.left = true;
               this.pback = 0;
            }
         }

         if (this.flipo == 15) {
            if (k == 1 && this.over(this.contin[0], i, j, 500, 370)) {
               this.pcontin = 1;
            }

            if (k == 2 && this.pcontin == 1) {
               control.enter = true;
               this.pcontin = 0;
            }
         }
      }

      if (this.fase == 8) {
         if (k == 1 && this.over(this.next[0], i, j, 600, 370)) {
            this.pnext = 1;
         }

         if (k == 2 && this.pnext == 1) {
            control.enter = true;
            this.pnext = 0;
         }
      }
   }

   public void stopairs() {
      int i = 0;

      do {
         this.air[i].stop();
      } while (++i < 6);
   }

   @Override
   public void run() {
      while (this.runtyp != 0) {
         if (this.runtyp >= 1 && this.runtyp <= 17) {
            this.hipnoload(this.runtyp, false);
         }

         if (this.runtyp == 176) {
            this.loading();
         }

         this.app.repaint();

         try {
            Thread.sleep(20L);
         } catch (InterruptedException var2) {
         }
      }
   }

   public void loadingfailed(CheckPoints chk, Control control) {
      this.trackbg(false);
      this.rd.drawImage(this.select, 273, 45, null);
      if (chk.stage != 1) {
         this.rd.drawImage(this.back[this.pback], 50, 110, null);
      }

      if (chk.stage != 17) {
         this.rd.drawImage(this.next[this.pnext], 560, 110, null);
      }

      this.rd.setFont(new Font("SansSerif", 1, 13));
      this.ftm = this.rd.getFontMetrics();
      this.drawcs(140, "Error Loading Stage " + chk.stage, 200, 0, 0, 3);
      this.drawcs(170, "Please check the file " + chk.stage + ".txt at tracks folder", 177, 177, 177, 3);
      this.drawcs(190, "This file may be damaged or it isn't there", 177, 177, 177, 3);
      this.drawcs(240, "Press Enter to try again.", 177, 177, 177, 3);
      this.rd.drawImage(this.contin[this.pcontin], 290, 325, null);
      this.rd.drawImage(this.br, 0, 0, null);
      this.rd.setFont(new Font("SansSerif", 1, 11));
      this.ftm = this.rd.getFontMetrics();
      this.drawcs(396, "You can also use Keyboard Arrows and Enter to navigate.", 82, 90, 0, 3);
      if (control.handb || control.enter) {
         this.fase = 2;
         control.handb = false;
         control.enter = false;
      }

      if (control.right && chk.stage != 17) {
         if (chk.stage != this.unlocked) {
            chk.stage++;
            this.fase = 2;
            control.right = false;
         } else {
            this.fase = 4;
            this.lockcnt = 100;
            control.right = false;
         }
      }

      if (control.left && chk.stage != 1) {
         chk.stage--;
         this.fase = 2;
         control.left = false;
      }
   }

   public void hipnoload(int i, boolean flag) {
      int j = (int)(230.0F - 230.0F * (this.m.snap[0] / (100.0F * this.hipno[i - 1])));
      if (j > 255) {
         j = 255;
      }

      if (j < 0) {
         j = 0;
      }

      int l = (int)(230.0F - 230.0F * (this.m.snap[1] / (100.0F * this.hipno[i - 1])));
      if (l > 255) {
         l = 255;
      }

      if (l < 0) {
         l = 0;
      }

      int j1 = (int)(230.0F - 230.0F * (this.m.snap[2] / (100.0F * this.hipno[i - 1])));
      if (j1 > 255) {
         j1 = 255;
      }

      if (j1 < 0) {
         j1 = 0;
      }

      if (i == 1) {
         j = 230;
         l = 230;
         j1 = 230;
      }

      this.rd.setColor(new Color(j, l, j1));
      this.rd.fillRect(0, 0, 670, 400);
      this.rd.setFont(new Font("SansSerif", 1, 13));
      this.ftm = this.rd.getFontMetrics();
      this.drawcs(25, this.asay, 0, 0, 0, 3);
      byte byte0 = -90;
      if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 7 || i == 8 || i == 9 || i == 10 || i == 12 || i == 13 || i == 14 || i == 16) {
         byte0 = 0;
      }

      if (byte0 == 0) {
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

         this.rd.drawImage(this.dude[this.duds], 30, 10, null);
         this.rd.drawImage(this.flaot, 127, 42, null);
         int k = (int)(80.0F - 80.0F * (this.m.snap[0] / (50.0F * this.hipno[i - 1])));
         if (k > 255) {
            k = 255;
         }

         if (k < 0) {
            k = 0;
         }

         int i1 = (int)(80.0F - 80.0F * (this.m.snap[1] / (50.0F * this.hipno[i - 1])));
         if (i1 > 255) {
            i1 = 255;
         }

         if (i1 < 0) {
            i1 = 0;
         }

         int k1 = (int)(80.0F - 80.0F * (this.m.snap[2] / (50.0F * this.hipno[i - 1])));
         if (k1 > 255) {
            k1 = 255;
         }

         if (k1 < 0) {
            k1 = 0;
         }

         if (i == 1) {
            k = 80;
            i1 = 80;
            k1 = 80;
         }

         this.rd.setColor(new Color(k, i1, k1));
         this.rd.setFont(new Font("SansSerif", 1, 13));
         if (i == 1) {
            this.rd.drawString("And don't forget, to complete a lap you must pass in order", 197, 67);
            this.rd.drawString("through all checkpoints in the track!", 197, 87);
         }

         if (i == 2) {
            this.rd.drawString("Remember, when you get more power your car gets faster", 197, 67);
            this.rd.drawString("and stronger.", 197, 87);
            this.rd.drawString("Now, go for that Mazda!", 197, 127);
         }

         if (i == 3) {
            this.rd.drawString("Watch out!  Look out!  The policeman might be out to get you!", 197, 67);
            this.rd.drawString("Don't upset him or you'll be arrested!", 197, 87);
            this.rd.drawString("Better run, run, run!", 197, 127);
         }

         if (i == 4) {
            this.rd.drawString("Don't waste your time.  Waste them instead!", 197, 67);
            this.rd.drawString("Try a taste of sweet revenge here (if you can)!", 197, 87);
            this.rd.drawString("Press [ A ] to make the guidance arrow point to cars instead of to", 197, 127);
            this.rd.drawString("the track.", 197, 147);
         }

         if (i == 5) {
            this.rd.drawString("Welcome to the Fantasy Desert!", 197, 67);
            this.rd.drawString("A place where the Mustang Rider is one of the bests.", 197, 87);
            this.rd.drawString("You have to demonstrate who is the true boss here, so,", 197, 127);
            this.rd.drawString("do you think you can beat its record?", 197, 147);
         }

         if (i == 7) {
            this.rd.drawString("Welcome to the realm of the King...", 197, 67);
            this.rd.drawString("The key word here is 'POWER'.  The more you have of it the faster", 197, 107);
            this.rd.drawString("and STRONGER you car will be!", 197, 127);
         }

         if (i == 8) {
            this.rd.drawString("Watch out, Armoured King is out to get you now!", 197, 67);
            this.rd.drawString("He seems to be seeking revenge?", 197, 87);
            this.rd.drawString("(To fly longer distances in the air try drifting your car on the ramp", 197, 127);
            this.rd.drawString("before take off).", 197, 147);
         }

         if (i == 9) {
            this.rd.drawString("Seems like you got the POWER!", 197, 67);
            this.rd.drawString("It’s good to be the king, don't you think?", 197, 87);
         }

         if (i == 10) {
            this.rd.drawString("Remember, forward loops give your car a push forwards in the air", 197, 67);
            this.rd.drawString("and help in racing.", 197, 87);
            this.rd.drawString("(You may need to do more forward loops here.  Also try keeping", 197, 127);
            this.rd.drawString("your power at maximum at all times.  Try not to miss a ramp).", 197, 147);
         }

         if (i == 12) {
            this.rd.drawString("Watch out!  Beware!  Take care!", 197, 67);
            this.rd.drawString("The Machine is hiding out there somewhere, don't get smashed now!", 197, 87);
         }

         if (i == 13) {
            this.rd.drawString("Anyone for a game of Digger?!", 197, 67);
            this.rd.drawString("You can have fun using the DS Wasting Machine here!", 197, 87);
            this.rd.drawString("And people say dumps are boring...", 197, 127);
         }

         if (i == 14) {
            this.rd.drawString("Prepare for the Challenge!", 197, 67);
            this.rd.drawString("Use only your best guns to run here!", 197, 87);
         }

         if (i == 16) {
            this.rd.drawString("This is it!  This is the toughest stage in this game!", 197, 67);
            this.rd.drawString("This track is actually a 4D object projected onto the 3D world.", 197, 107);
            this.rd.drawString("It's been broken down, separated and, in many ways, it is also a", 197, 127);
            this.rd.drawString("maze... Also, there is no arrow to help you! GOOD LUCK!", 197, 147);
         }
      }

      this.rd.drawImage(this.loadingmusic, 224, 180 + byte0, null);
      this.rd.setFont(new Font("SansSerif", 1, 11));
      this.ftm = this.rd.getFontMetrics();
      if (!flag) {
         this.drawcs(315 + byte0, "About " + this.sndsize[i - 1] + " KB", 0, 0, 0, 3);
         this.drawcs(350 + byte0, " Please Wait...", 0, 0, 0, 3);
      } else {
         this.drawcs(330 + byte0, "Loading complete!  Press Start to begin...", 0, 0, 0, 3);
         this.drawcs(350 + byte0, "Soundtrack name: " + this.sndtrck[i - 1], 0, 0, 0, 3);
         this.rd.drawImage(this.star[this.pstar], 294, 360 + byte0, null);
         if (this.pstar != 2) {
            if (this.pstar == 0) {
               this.pstar = 1;
            } else {
               this.pstar = 0;
            }
         }
      }
   }

   private Image loadopsnap(Image image, int i, int j) {
      int k = image.getHeight(this.ob);
      int l = image.getWidth(this.ob);
      int[] ai = new int[l * k];
      PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, l, k, ai, 0, l);

      try {
         pixelgrabber.grabPixels();
      } catch (InterruptedException var15) {
      }

      int i1 = 0;
      if (j == 1) {
         i1 = ai['\uf229'];
      }

      for (int j1 = 0; j1 < l * k; j1++) {
         if (ai[j1] != ai[j]) {
            Color color = new Color(ai[j1]);
            int k1 = 0;
            int l1 = 0;
            int i2 = 0;
            if (j == 1 && ai[j1] == i1) {
               k1 = (int)(237.0F - 237.0F * (this.m.snap[0] / (150.0F * this.hipno[i - 1])));
               if (k1 > 255) {
                  k1 = 255;
               }

               if (k1 < 0) {
                  k1 = 0;
               }

               l1 = (int)(237.0F - 237.0F * (this.m.snap[1] / (150.0F * this.hipno[i - 1])));
               if (l1 > 255) {
                  l1 = 255;
               }

               if (l1 < 0) {
                  l1 = 0;
               }

               i2 = (int)(237.0F - 237.0F * (this.m.snap[2] / (150.0F * this.hipno[i - 1])));
               if (i2 > 255) {
                  i2 = 255;
               }

               if (i2 < 0) {
                  i2 = 0;
               }

               if (i == 1) {
                  k1 = 250;
                  l1 = 250;
                  i2 = 250;
               }
            } else {
               k1 = (int)(color.getRed() - color.getRed() * (this.m.snap[0] / (50.0F * this.hipno[i - 1])));
               if (k1 > 255) {
                  k1 = 255;
               }

               if (k1 < 0) {
                  k1 = 0;
               }

               l1 = (int)(color.getGreen() - color.getGreen() * (this.m.snap[1] / (50.0F * this.hipno[i - 1])));
               if (l1 > 255) {
                  l1 = 255;
               }

               if (l1 < 0) {
                  l1 = 0;
               }

               i2 = (int)(color.getBlue() - color.getBlue() * (this.m.snap[2] / (50.0F * this.hipno[i - 1])));
               if (i2 > 255) {
                  i2 = 255;
               }

               if (i2 < 0) {
                  i2 = 0;
               }

               if (i == 1) {
                  k1 = color.getRed();
                  l1 = color.getGreen();
                  i2 = color.getBlue();
               }
            }

            Color color1 = new Color(k1, l1, i2);
            ai[j1] = color1.getRGB();
         }
      }

      return this.createImage(new MemoryImageSource(l, k, ai, 0, l));
   }

   private AudioClip getSound(String s) {
      AudioClip audioclip = this.app.getAudioClip(this.app.getCodeBase(), s);
      if (s.startsWith("sounds/default")) {
         audioclip.play();
         Thread.yield();
         audioclip.stop();
      }

      return audioclip;
   }

   public void carsbginflex() {
      this.flatr = 0;
      this.flyr = (int)(this.m.random() * 160.0F - 80.0F);
      this.flyrdest = (int)(this.flyr + this.m.random() * 160.0F - 80.0F);
      this.flang = 1;
      this.flangados = (int)(this.m.random() * 6.0F + 2.0F);
      this.blackn = 0.0F;
      this.blacknados = this.m.random() * 0.4F;
      PixelGrabber pixelgrabber = new PixelGrabber(this.carsbg, 0, 0, 670, 400, this.flexpix, 0, 670);

      try {
         pixelgrabber.grabPixels();
      } catch (InterruptedException var3) {
      }
   }
}
