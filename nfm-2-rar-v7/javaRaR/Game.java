
import java.applet.Applet;
import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.image.VolatileImage;
import java.io.*;
import java.util.zip.*;

class Game extends Applet implements Runnable {

 Graphics2D gs;
 VolatileImage theImage;
 Thread Game;
 FontMetrics FM;
 Dir D[];
 Path2D pth;
 int p;
 double S;
 double mS;
 boolean mous;
 boolean msC;
 double xm;
 double oxm;
 double ym;
 long gmspd;
 long RR;
 int nT;
 long view;
 int im;
 boolean mutM;
 boolean mutS;
 String fas;
 String ofas;
 double cntd;
 long slop;
 long sct;
 String cNm[] = {"Tornado Shark", "Formula 7", "Wow Caninaro", "La Vit Crab", "Nimi", "MAX Revenge", "Lead Oxide", "Kool Kat", "Drifter X", "Sword of Justice", "High Rider", "EL KING", "Mighty Eight", "M A S H E E N", "Radical One", "DR Monstaa", "Basic Racer", "Turbo Dragster", "Desert Humvee", "Lamborghini Gallardo", "Armored Corvette", "Radical Racer", "Saleen S7 Twin Turbo", "Sting Rod", "Zonich Tank", "Matlos Tank", "Air Rebound", "Bugatti Veyron", "EL ROCKET KING", "Mighty Rocket Eight", "ROCKET M A S H E E N", "DR Rocket Monstaa", "The Awesome Radical One", "Over=Kill", "OW SLAMINARO", "Lightning Rod", "EPIC TANK", "EL KING-OF-WAR", "KILL-O-MATIC", "The Phantom", "The Destroyer", "Everlast-177", "TRAIN of TERROR", "Turbo Prop", "F-22 Raptor", "Tactical Nuke", "A-1", "SuperSonic DeathRay", "Gun Turret", "YottaVolt Particle Disintegrator"};
 String handl[] = {"Alright", "Great", "Alright", "Good", "Alright", "Good", "Good", "Alright", "Drifty", "Good", "Great", "Poor", "Good", "Poor", "Great", "Good",
  "Alright", "Great", "Alright", "Good", "Alright", "Maxed", "Good", "Alright", "Maxed", "Maxed", "Alright", "Wild", "Poor", "Good", "Poor", "Good", "Maxed", "Awesome", "Poor", "Maxed", "Aims Well", "Poor", "Bad", "Maxed", "Insane", "Poor", "Aims Well", "Good", "Good", "Maxed", "The Best", "Poor", "N/A", "N/A"};
 boolean aCrs;
 long clr;
 String adj[][] = {{"Cool", "Alright", "Nice", "Good", "Great", "Not Bad", "Sucessful", "Tight"}, {"Wicked", "Amazing", "Super", "Hardcore", "Sick", "Remarkable", "Fantastic", "Impressive"}, {"Awesome", "Ripping", "Radical", "Incredible", "Unbelieveable", "Pro", "Epic", "Extreme"}, {"What the...?!", "You're a super star!!!!", "Who are you again...?", "!?!?!!?!?!?!???!", "HOLY ****!", "....DUDE!", "WOO-HAA!", "Again!...Again!"}, {"half-ramp", "off the edge", "bounce back"}
 };
 String ex[] = {"!", "!!", "!!!"};
 String lop;
 String spn;
 double scnt;
 boolean flk;
 long tm;
 long ts;
 double tt;
 boolean HUD;
 boolean lok1;
 boolean lok2;
 boolean u1;
 boolean u2;
 long end;
 int nC;
 long onC;
 long crs;
 int mMax;
 double tcnt;
 long[] sdtyp;
 String say;
 boolean wasay;
 String ssay;
 int[] C;
 int op;
 long xst[];
 long yst[];
 long zst[];
 long eco[] = {0,
  0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
  0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
  0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
  0, 0, 350, 0, 0, 0, 0, 0, 350, 0,
  0, 300, 0, 0, 0, 0, 0, 0, 250, 0,
  0, 0, 0, 0, 0, 0, 0, 0, 400, 0,
  0, 0, 0, 0, 0, 0, 200, 0, 0, 0,
  0};
 double pnts;
 boolean dr;
 int[] tSiz;
 int[] sSiz;
 int[] cSiz;
 int[] fSiz;
 long[] x;
 long[] y;
 long[] z;
 long cx[];
 long cy[];
 long cz[];
 int cLoc[];
 long X;
 long Y;
 long Z;
 boolean suny;
 int typ[];
 int nCk;
 int nS;
 long fx[];
 long fy[];
 long fz[];
 boolean ang[];
 int nF;
 int stg;
 long lapn;
 long pos[];
 long aclr[];
 long[] dtyp;
 long dstd;
 double opx[];
 double opy[];
 double opz[];
 boolean DWC;
 int wn;
 double zz;

 Sound cp;
 Sound pwr;
 Sound[] cnt;
 Sound[] ps;
 Sound out;
 Music trk;
 static Frame frm;
 static Game G;

 public static void main(String[] s) {
  System.out.println("NFM RaR");
  frm = new Frame("Need for Madness Revised and Recharged (Pan-Java Edition)");
  frm.setBackground(new Color(0, 0, 0));
  frm.setUndecorated(true);
  frm.setIgnoreRepaint(true);
  G = new Game();
  frm.addWindowListener(new Exit());
  frm.add("Center", G);
  frm.setVisible(true);
  G.init();
  G.start();
 }

 static void exit() {
  G.stop();
  frm.removeAll();
  G.destroy();
  G = null;
  System.exit(0);
 }

 public boolean keyDown(Event e, int k) {
  if (k == 1004) {
   D[0].up = true;
   if (DWC) {
    D[0].down = false;
    D[0].left = false;
    D[0].riht = false;
    D[0].spac = false;
    DWC = false;
   }
  }
  if (k == 1005) {
   D[0].down = true;
   if (DWC) {
    D[0].up = false;
    D[0].left = false;
    D[0].riht = false;
    D[0].spac = false;
    DWC = false;
   }
  }
  if (k == 1007) {
   D[0].riht = true;
   if (DWC) {
    D[0].up = false;
    D[0].down = false;
    D[0].spac = false;
    DWC = false;
   }
  }
  if (k == 1006) {
   D[0].left = true;
   if (DWC) {
    D[0].up = false;
    D[0].down = false;
    D[0].spac = false;
    DWC = false;
   }
  }
  if (k == 32) {
   D[0].spac = true;
   if (DWC) {
    D[0].up = false;
    D[0].down = false;
    D[0].left = false;
    D[0].riht = false;
    DWC = false;
   }
  }
  if (k == 118 || k == 86) {
   D[0].fir[0] = true;
  }
  if (k == 102) {
   D[0].fir[1] = true;
  }
  if (k == 98) {
   D[0].bost = true;
  }
  if (k == 103) {
   HUD = !HUD;
  }
  if (k == 120 || k == 88) {
   D[0].loka = -1;
   lok1 = true;
  }
  if (k == 122 || k == 90) {
   D[0].loka = 1;
   lok2 = true;
  }
  if (k == 10 || k == 80 || k == 112 || k == 27) {
   D[0].entr = true;
  }
  if (k == 77 || k == 109) {
   mutM = !mutM;
  }
  if (k == 78 || k == 110) {
   mutS = !mutS;
  }
  if (k == 97 || k == 65) {
   D[0].aCrs = !D[0].aCrs;
  }
  if (k == 99) {
   view++;
   if (view > 3 && view < 10) {
    view = 10;
   }
   if (view > 10) {
    view = 1;
   }
  }
  if (k == 100) {
   if (im < nC - 1) {
    im++;
   } else {
    im = 0;
   }
   u1 = true;
  }
  if (k == 115) {
   if (im > 0) {
    im--;
   } else {
    im = nC - 1;
   }
   u2 = true;
  }
  if (k == 43 || k == 61) {
   mS += .0025 * zz;
  }
  if (k == 45 || k == 8) {
   mS -= .0025 * zz;
  }
  return false;
 }

 public boolean keyUp(Event e, int k) {
  if (k == 1004) {
   D[0].up = false;
  }
  if (k == 1005) {
   D[0].down = false;
  }
  if (k == 1007) {
   D[0].riht = false;
  }
  if (k == 1006) {
   D[0].left = false;
  }
  if (k == 32) {
   D[0].spac = false;
  }
  if (k == 118 || k == 86) {
   D[0].fir[0] = false;
  }
  if (k == 102) {
   D[0].fir[1] = false;
  }
  if (k == 98) {
   D[0].bost = false;
  }
  if (k == 100 || k == 115) {
   u1 = false;
   u2 = false;
  }
  if (k == 120 || k == 88 || k == 122 || k == 90) {
   D[0].loka = 0;
   lok1 = false;
   lok2 = false;
  }
  if (k == 43 || k == 61 || k == 45 || k == 8) {
   mS = 0;
  }
  return false;
 }

 public void stop() {
  gs.dispose();
  if (Game != null) {
   System.gc();
   Game = null;
  }
 }

 String gtStrng(String a, String b) {
  int d = 0;
  String s = "";
  for (int e = a.length() + 1; e < b.length(); e++) {
   String s1 = "" + b.charAt(e);
   if (s1.equals(",") || s1.equals(")")) {
    d++;
    e++;
   }
   if (d == 0) {
    s += b.charAt(e);
   }
  }
  return s;
 }

 long gtVal(String a, String b, int c) {
  int d = 0;
  String s = "";
  for (int e = a.length() + 1; e < b.length(); e++) {
   String s2 = "" + b.charAt(e);
   if (s2.equals(",") || s2.equals(")")) {
    d++;
    e++;
   }
   if (d == c) {
    s += b.charAt(e);
   }
  }
  return Long.valueOf(s);
 }

 Game() {
  nC = 1;
  crs = 50;
  D = new Dir[1];
  fas = "init";
  ofas = "go";
  lop = "";
  spn = "";
  scnt = 45;
  gmspd = 40;
  RR = 1;
  HUD = true;
  mMax = 120;
  C = new int[mMax];
  say = "";
  tcnt = 30;
  sdtyp = new long[1];
  ssay = "";
  tSiz = new int[72];
  sSiz = new int[72];
  cSiz = new int[72];
  fSiz = new int[72];
  for (int b = 0; b < 72; b++) {
   tSiz[b] = 10000;
  }
  typ = new int[1000];
  x = new long[1000];
  z = new long[1000];
  y = new long[1000];
  cx = new long[100];
  cz = new long[100];
  cy = new long[100];
  cLoc = new int[100];
  fx = new long[50];
  fz = new long[50];
  fy = new long[50];
  ang = new boolean[50];
  pos = new long[1];
  aclr = new long[1];
  dtyp = new long[1];
  opx = new double[1];
  opz = new double[1];
  opy = new double[1];
  cnt = new Sound[2];
  ps = new Sound[2];
 }

 void base(Act aa[], Mdm m, Track t) {
  String s[] = {
   "shark", "formula", "caninaro", "lcrab", "nimi", "maxrev", "oxide", "kolkat", "driftx", "justice", "mustang", "king", "audir8", "mash", "radical1", "monsta", "basic", "drags", "humve", "lambo", "corvet", "radicalrac", "salens7", "stingr", "zonich", "matlos", "rebound", "bugati", "rocketking", "rocketaudir8", "rocketmash", "rocketmonsta", "awesome", "overkil", "slamow", "lightnin", "tank", "warking", "kilo", "phntm", "destroy", "ever", "train", "prop", "raptor", "nuke", "A-1", "deathray", "turet", "yota",
   "prod", "prodw", "prodb2", "prodb1", "prodt", "drod", "grod", "drodt", "nrod", "nrodt",
   "mixpd", "mixnd", "mixpn", "prode", "drode", "pipg", "prmp", "prmpc", "prmpg", "prmpm",
   "prmpw", "prmpb", "prmps", "dbmp", "drmpb", "drmps", "pipe", "spikes", "rail", "brdr",
   "chk", "fix", "dchk", "drodb", "drodbb", "bprmpup", "prmpup", "start", "wall", "fenc",
   "prmpl", "net", "prmpspd", "drmpg", "tiny", "dhil", "stunl", "tunl", "lift", "mountn",
   "mass", "cres", "pile1", "pile2", "brdr2", "tre1", "tre2", "tre3", "tre4", "tre5",
   "tre6", "tre7", "tre8", "cac1", "cac2", "cac3", "blok", "full", "pyrmd", "tub"
  };
  try {
   ZipInputStream zi = new ZipInputStream(new FileInputStream("/app/games/nfm-2-rar-v7/models.zip"));
   ZipEntry e = zi.getNextEntry();
   for (; e != null; e = zi.getNextEntry()) {
    int a = 0;
    int b;
    for (b = 0; b < mMax; b++) {
     if (e.getName().startsWith(s[b])) {
      a = b;
     }
    }
    b = (int) e.getSize();
    byte[] v = new byte[b];
    int c = 0;
    int d;
    for (; b > 0; b -= d) {
     d = zi.read(v, c, b);
     c += d;
    }
    aa[a] = new Act(v, m, t, this);
   }
   zi.close();
  } catch (Exception e) {
   System.out.println("Error Reading Models: " + e);
  }
  System.gc();
 }

 public void update(Graphics g) {
  g.drawImage(theImage, 0, 0, this);
 }

 public void init() {
  theImage = createVolatileImage(1600, 800);
  gs = (Graphics2D) theImage.getGraphics();
 }

 public void start() {
  if (Game == null) {
   Game = new Thread(this);
  }
  Game.setPriority(10);
  Game.start();
 }

 public boolean mouseMove(Event e, int x, int y) {
  xm = x / S;
  ym = y / S;
  return false;
 }

 public boolean mouseDown(Event e, int x, int y) {
  xm = x / S;
  ym = y / S;
  if (!msC) {
   mous = true;
  }
  return false;
 }

 public boolean mouseUp(Event e, int x, int y) {
  xm = x / S;
  ym = y / S;
  msC = false;
  mous = false;
  return false;
 }

 void ldstg(Act aa[], Act aa1[], Mdm m, Track tr, Play[] ap) {
  if (sSiz[stg] > 0) {
   typ = new int[sSiz[stg]];
   x = new long[sSiz[stg]];
   z = new long[sSiz[stg]];
   y = new long[sSiz[stg]];
  }
  if (cSiz[stg] > 0) {
   cx = new long[cSiz[stg]];
   cz = new long[cSiz[stg]];
   cy = new long[cSiz[stg]];
   cLoc = new int[cSiz[stg]];
  }
  if (fSiz[stg] > 0) {
   fx = new long[fSiz[stg]];
   fz = new long[fSiz[stg]];
   fy = new long[fSiz[stg]];
   ang = new boolean[fSiz[stg]];
  }
  int r = tSiz[stg];
  tr.x = new double[r];
  tr.y = new double[r];
  tr.z = new double[r];
  tr.xy = new long[r];
  tr.zy = new long[r];
  tr.skd = new long[r];
  tr.dam = new long[r];
  tr.scn = new boolean[r];
  tr.c = new double[r][3];
  tr.radx = new double[r];
  tr.radz = new double[r];
  tr.rady = new double[r];
  tr.nt = 0;
  X = 0;
  Y = 0;
  Z = 0;
  nT = nC;
  nS = 0;
  nCk = 0;
  nF = 0;
  dstd = 0;
  suny = false;
  m.liton = false;
  m.cldon = false;
  m.mnton = false;
  m.stron = false;
  m.plon = false;
  m.grnd = 250;
  if (view != 1 && view != 10) {
   view = 1;
  }
  long a = 0;
  long b = 100;
  long c = 0;
  long d = 100;
  String s1 = "";
  try {
   BufferedReader i = new BufferedReader(new InputStreamReader(new FileInputStream("/app/games/nfm-2-rar-v7/stages/" + stg + ".txt")));
   while (true) {
    String s;
    if ((s = i.readLine()) == null) {
     break;
    }
    s1 = "" + s.trim();
    if (s1.startsWith("snap")) {
     m.stsnp(gtVal("snap", s1, 0), gtVal("snap", s1, 1), gtVal("snap", s1, 2));
    }
    if (s1.startsWith("sky")) {
     m.stsky(gtVal("sky", s1, 0), gtVal("sky", s1, 1), gtVal("sky", s1, 2));
    }
    if (s1.startsWith("ground")) {
     m.stgrnd(gtVal("ground", s1, 0), gtVal("ground", s1, 1), gtVal("ground", s1, 2));
    }
    if (s1.startsWith("fog")) {
     m.setfd(gtVal("fog", s1, 0), gtVal("fog", s1, 1), gtVal("fog", s1, 2));
    }
    if (s1.startsWith("fadefrom")) {
     m.fdfrm(gtVal("fadefrom", s1, 0));
    }
    if (s1.startsWith("lights")) {
     m.liton = true;
    }
    if (s1.startsWith("texture")) {
     m.stxtur(gtVal("texture", s1, 0), gtVal("texture", s1, 1), gtVal("texture", s1, 2), gtVal("texture", s1, 3));
    }
    int ext = 40;
    long rndx = (long) (Math.random() * 120000) - (long) (Math.random() * 120000);
    long rndy = (long) (Math.random() * 1000000) - (long) (Math.random() * 1000000) - 1000000000;
    long rndz = (long) (Math.random() * 120000) - (long) (Math.random() * 120000);
    if (stg == 19) {
     rndx = (long) (Math.random() * 25000) - (long) (Math.random() * 25000);
     rndz = (long) (Math.random() * 25000) - (long) (Math.random() * 25000);
    }
    if (stg == 33) {
     rndx = -7050 + (long) (Math.random() * 14050) - (long) (Math.random() * 14050);
     rndz = 6800 + (long) (Math.random() * 13800) - (long) (Math.random() * 13800);
    }
    if (stg == 37) {
     if (Math.random() < .5) {
      rndx = 4500;
     } else {
      rndx = -4500;
     }
     if (Math.random() < .5) {
      rndz = 4500;
     } else {
      rndz = -4500;
     }
    }
    if (stg == 40) {
     rndx = (long) (Math.random() * 5) - (long) (Math.random() * 5);
     rndz = (long) (Math.random() * 100) - (long) (Math.random() * 100);
     rndx *= 1000;
     rndz *= 10000;
    }
    if (stg == 70) {
     rndx = (long) (Math.random() * 1000000) - (long) (Math.random() * 1000000);
     rndz = (long) (Math.random() * 1000000) - (long) (Math.random() * 1000000);
    }
    int t;
    if (s1.startsWith("set")) {
     t = (int) gtVal("set", s1, 0);
     t += ext;
     if (stg == 19 || (stg == 33 && t - ext == 37) || stg == 40 || (stg == 48 && (t - ext == 60 || t - ext == 78)) || (stg == 53 && t - ext > 64) || stg == 70) {
      if (stg == 70) {
       aa[nT] = new Act(aa1[t], rndx, rndy, rndz, gtVal("set", s1, 4));
      } else {
       aa[nT] = new Act(aa1[t], rndx, gtVal("set", s1, 3), rndz, gtVal("set", s1, 4));
      }
     } else {
      aa[nT] = new Act(aa1[t], gtVal("set", s1, 1), gtVal("set", s1, 3), gtVal("set", s1, 2), gtVal("set", s1, 4));
     }
     if (t - ext == 61 || t - ext == 77) {
      X = gtVal("set", s1, 1);
      Z = gtVal("set", s1, 2);
      Y = gtVal("set", s1, 3);
      suny = true;
     }
     if (s1.contains(")p")) {
      if (stg == 19) {
       x[nS] = rndx;
       z[nS] = rndz;
      } else {
       x[nS] = gtVal("set", s1, 1);
       z[nS] = gtVal("set", s1, 2);
      }
      y[nS] = gtVal("set", s1, 3);
      typ[nS] = 0;
      if (s1.contains(")pt")) {
       typ[nS] = -1;
      }
      if (s1.contains(")pr")) {
       typ[nS] = -2;
      }
      if (s1.contains(")pa")) {
       typ[nS] = -3;
      }
      if (s1.contains(")pf")) {
       typ[nS] = -4;
      }
      nS++;
     }
     nT++;
    }
    long rndr = (long) (Math.random() * 180) - (long) (Math.random() * 180);
    if (s1.startsWith("chk")) {
     t = 0;
     if (stg != 57) {
      t = (int) gtVal("chk", s1, 0);
     }
     t += ext;
     if (stg != 37 && stg != 40 && stg != 48 && stg != 53 && stg != 57 && stg != 70) {
      aa[nT] = new Act(aa1[t], gtVal("chk", s1, 1), gtVal("chk", s1, 3), gtVal("chk", s1, 2), gtVal("chk", s1, 4));
      x[nS] = gtVal("chk", s1, 1);
      z[nS] = gtVal("chk", s1, 2);
      y[nS] = gtVal("chk", s1, 3);
      cx[nCk] = gtVal("chk", s1, 1);
      cz[nCk] = gtVal("chk", s1, 2);
      cy[nCk] = gtVal("chk", s1, 3);
      if (Math.abs(gtVal("chk", s1, 4)) < 45) {
       typ[nS] = 1;
      } else {
       typ[nS] = 2;
      }
     }
     if (stg == 37 || stg == 40 || stg == 48) {
      aa[nT] = new Act(aa1[t], rndx, gtVal("chk", s1, 3), rndz, gtVal("chk", s1, 4));
      x[nS] = rndx;
      z[nS] = rndz;
      y[nS] = gtVal("chk", s1, 3);
      cx[nCk] = rndx;
      cz[nCk] = rndz;
      cy[nCk] = gtVal("chk", s1, 3);
      if (Math.abs(gtVal("chk", s1, 4)) < 45) {
       typ[nS] = 1;
      } else {
       typ[nS] = 2;
      }
     }
     if (stg == 53) {
      rndx = (long) ((Math.random() * 60000) - (Math.random() * 60000));
      rndz = (long) ((Math.random() * 60000) - (Math.random() * 60000));
      aa[nT] = new Act(aa1[t], rndx, gtVal("chk", s1, 3), rndz, gtVal("chk", s1, 4));
      x[nS] = rndx;
      z[nS] = rndz;
      y[nS] = gtVal("chk", s1, 3);
      cx[nCk] = rndx;
      cz[nCk] = rndz;
      cy[nCk] = gtVal("chk", s1, 3);
      if (Math.abs(gtVal("chk", s1, 4)) < 45) {
       typ[nS] = 1;
      } else {
       typ[nS] = 2;
      }
     }
     if (stg == 57) {
      rndx = (long) ((Math.random() * 30000) - (Math.random() * 30000));
      rndz = (long) ((Math.random() * 30000) - (Math.random() * 30000));
      aa[nT] = new Act(aa1[nCk], rndx, 250 - aa1[nCk].wG, rndz, rndr);
      x[nS] = rndx;
      z[nS] = rndz;
      y[nS] = 250;
      cx[nCk] = rndx;
      cz[nCk] = rndz;
      cy[nCk] = 250;
      typ[nS] = 3;
     }
     if (stg == 70) {
      aa[nT] = new Act(aa1[t], rndx, rndy, rndz, gtVal("chk", s1, 4));
      x[nS] = rndx;
      z[nS] = rndz;
      y[nS] = rndy;
      cx[nCk] = rndx;
      cz[nCk] = rndz;
      cy[nCk] = rndy;
      if (Math.abs(gtVal("chk", s1, 4)) < 45) {
       typ[nS] = 1;
      } else {
       typ[nS] = 2;
      }
     }
     cLoc[nCk] = nS;
     nS++;
     aa[nT].chk = (nCk + 1);
     nCk++;
     nT++;
    }
    if (s1.startsWith("fix")) {
     t = (int) gtVal("fix", s1, 0);
     t += ext;
     if (stg == 70) {
      fy[nF] = rndy;
     } else {
      fy[nF] = gtVal("fix", s1, 3);
     }
     if (stg == 40 || stg == 48 || stg == 53 || stg == 70) {
      if (stg == 48 || stg == 53) {
       rndx = (long) ((Math.random() * 60000) - (Math.random() * 60000));
       rndz = (long) ((Math.random() * 60000) - (Math.random() * 60000));
      }
      if (stg == 70) {
       aa[nT] = new Act(aa1[t], rndx, rndy, rndz, rndr);
      } else {
       aa[nT] = new Act(aa1[t], rndx, gtVal("fix", s1, 3), rndz, rndr);
      }
      fx[nF] = rndx;
      fz[nF] = rndz;
     } else {
      aa[nT] = new Act(aa1[t], gtVal("fix", s1, 1), gtVal("fix", s1, 3), gtVal("fix", s1, 2), gtVal("fix", s1, 4));
      fx[nF] = gtVal("fix", s1, 1);
      fz[nF] = gtVal("fix", s1, 2);
     }
     aa[nT].elec = true;
     ang[nF] = false;
     aa[nT].rtd = false;
     if (Math.abs(gtVal("fix", s1, 4)) > 45) {
      ang[nF] = true;
      aa[nT].rtd = true;
     }
     nF++;
     nT++;
    }
    if (s1.startsWith("polys")) {
     m.stpoly(gtVal("polys", s1, 0), gtVal("polys", s1, 1), gtVal("polys", s1, 2));
     m.plon = true;
    }
    if (s1.startsWith("clouds")) {
     m.stcld(gtVal("clouds", s1, 0), gtVal("clouds", s1, 1), gtVal("clouds", s1, 2), gtVal("clouds", s1, 3), gtVal("clouds", s1, 4));
     m.cldon = true;
    }
    if (s1.startsWith("mountains")) {
     m.mgen = gtVal("mountains", s1, 0);
     m.mnton = true;
    }
    if (s1.startsWith("stars")) {
     m.stron = true;
    }
    if (s1.startsWith("pile")) {
     if (stg == 53) {
      aa[nT] = new Act((long) (Math.random() * 10000), Math.random() * 6, 6, m, tr, this, (Math.random() * 120000) - (Math.random() * 120000), (Math.random() * 120000) - (Math.random() * 120000));
     } else {
      aa[nT] = new Act(gtVal("pile", s1, 0), gtVal("pile", s1, 1), gtVal("pile", s1, 2), m, tr, this, gtVal("pile", s1, 3), gtVal("pile", s1, 4));
     }
     nT++;
    }
    if (s1.startsWith("nlaps")) {
     lapn = gtVal("nlaps", s1, 0);
    }
    if (s1.startsWith("name")) {
     if (stg == 28) {
      say = nC - 1 + " " + gtStrng("name", s1).replace('|', ',');
     } else {
      say = gtStrng("name", s1).replace('|', ',');
     }
    }
    long l;
    long m1;
    long m2;
    long m3;
    int w = ext + 39;
    if (s1.startsWith("maxr")) {
     m1 = gtVal("maxr", s1, 0);
     m2 = gtVal("maxr", s1, 1);
     a = m2;
     m3 = gtVal("maxr", s1, 2);
     for (l = 0; l < m1; l++) {
      aa[nT] = new Act(aa1[w], m2, m.grnd - aa1[w].wG, l * 4800 + m3, -90);
      nT++;
     }
     tr.nt++;
    }
    if (s1.startsWith("maxl")) {
     m1 = gtVal("maxl", s1, 0);
     m2 = gtVal("maxl", s1, 1);
     b = m2;
     m3 = gtVal("maxl", s1, 2);
     for (l = 0; l < m1; l++) {
      aa[nT] = new Act(aa1[w], m2, m.grnd - aa1[w].wG, l * 4800 + m3, 90);
      nT++;
     }
     tr.nt++;
    }
    if (s1.startsWith("maxt")) {
     m1 = gtVal("maxt", s1, 0);
     m2 = gtVal("maxt", s1, 1);
     c = m2;
     m3 = gtVal("maxt", s1, 2);
     for (l = 0; l < m1; l++) {
      aa[nT] = new Act(aa1[w], l * 4800 + m3, m.grnd - aa1[w].wG, m2, 0);
      nT++;
     }
     tr.nt++;
    }
    if (s1.startsWith("maxb")) {
     m1 = gtVal("maxb", s1, 0);
     m2 = gtVal("maxb", s1, 1);
     d = m2;
     m3 = gtVal("maxb", s1, 2);
     for (l = 0; l < m1; l++) {
      aa[nT] = new Act(aa1[w], l * 4800 + m3, m.grnd - aa1[w].wG, m2, 180);
      nT++;
     }
     tr.nt++;
    }
    if (s1.startsWith("maaxr")) {
     m1 = gtVal("maaxr", s1, 0);
     m2 = gtVal("maaxr", s1, 1);
     a = m2;
     m3 = gtVal("maaxr", s1, 2);
     for (l = 0; l < m1; l++) {
      aa[nT] = new Act(aa1[w + 25], m2, m.grnd - aa1[w + 25].wG, l * 4800 + m3, -90);
      nT++;
     }
     tr.nt++;
    }
    if (s1.startsWith("maaxl")) {
     m1 = gtVal("maaxl", s1, 0);
     m2 = gtVal("maaxl", s1, 1);
     b = m2;
     m3 = gtVal("maaxl", s1, 2);
     for (l = 0; l < m1; l++) {
      aa[nT] = new Act(aa1[w + 25], m2, m.grnd - aa1[w + 25].wG, l * 4800 + m3, 90);
      nT++;
     }
     tr.nt++;
    }
    if (s1.startsWith("maaxt")) {
     m1 = gtVal("maaxt", s1, 0);
     m2 = gtVal("maaxt", s1, 1);
     c = m2;
     m3 = gtVal("maaxt", s1, 2);
     for (l = 0; l < m1; l++) {
      aa[nT] = new Act(aa1[w + 25], l * 4800 + m3, m.grnd - aa1[w + 25].wG, m2, 0);
      nT++;
     }
     tr.nt++;
    }
    if (s1.startsWith("maaxb")) {
     m1 = gtVal("maaxb", s1, 0);
     m2 = gtVal("maaxb", s1, 1);
     d = m2;
     m3 = gtVal("maaxb", s1, 2);
     for (l = 0; l < m1; l++) {
      aa[nT] = new Act(aa1[w + 25], l * 4800 + m3, m.grnd - aa1[w + 25].wG, m2, 180);
      nT++;
     }
     tr.nt++;
    }
   }
   i.close();
   if (tSiz[stg] != tr.nt) {
    tSiz[stg] = tr.nt;
   }
   if (sSiz[stg] != nS + 1) {
    sSiz[stg] = nS + 1;
   }
   if (cSiz[stg] != nCk + 1) {
    cSiz[stg] = nCk + 1;
   }
   if (fSiz[stg] != nF + 1) {
    fSiz[stg] = nF + 1;
   }
   m.nwpoly(b, a - b, d, c - d, tr);
   if (stg == 6) {
    c *= .25;
   }
   m.nwcld();
   m.nwmnt(b, a, d, c);
   if (stg == 50) {
    m.nwmnt(b * 5, a * 5, d * 5, c * 5);
   }
   m.nwstr();
  } catch (Exception e) {
   tSiz[stg] = 10000;
   sSiz[stg] = 1000;
   cSiz[stg] = 100;
   fSiz[stg] = 50;
   fas = "nostg";
   System.out.println("Error in stage " + stg);
   System.out.println("" + e);
   System.out.println("At line: " + s1);
  }
  if (fas == "stgq") {
   m.pnt = 0;
   m.pcnt = 0;
   if (Math.random() < .5) {
    m.rnd = 1;
   } else {
    m.rnd = -1;
   }
   fas = "stgs";
  }
  for (r = 0; r < nC; r++) {
   D[r].reset(this);
  }
  reset();
  sort();
  for (r = 0; r < nC; r++) {
   aa[r] = new Act(aa1[C[r]], xst[r], yst[r] - aa1[C[r]].wG, zst[r], 0);
   ap[r].reset(C[r], aa[r]);
  }
  System.gc();
 }

 public void run() {
  Mdm md = new Mdm(this);
  String s1;
  md.maxD = Double.POSITIVE_INFINITY;
  int c;
  int c1;
  try {
   BufferedReader d = new BufferedReader(new InputStreamReader(new FileInputStream("/app/games/nfm-2-rar-v7/DefaultSettings.txt")));
   while (true) {
    String s;
    if ((s = d.readLine()) == null) {
     break;
    }
    s1 = "" + s.trim();
    if (s1.startsWith("GameSpeed")) {
     gmspd = gtVal("GameSpeed", s1, 0);
    }
    if (s1.startsWith("RefreshRate")) {
     RR = gtVal("RefreshRate", s1, 0);
    }
    if (s1.startsWith("GameScenery(OFF)")) {
     md.nosc = true;
    }
    if (s1.startsWith("Firepower(OFF)")) {
     md.nofpwr = true;
    }
    if (s1.startsWith("MaxDistance")) {
     md.maxD = gtVal("MaxDistance", s1, 0);
    }
    if (s1.startsWith("Zoom")) {
     md.zm = gtVal("Zoom", s1, 0);
     md.zm *= .01;
    }
    if (s1.startsWith("Immortality(ON)")) {
     md.imrtl = true;
    }
    if (s1.startsWith("Difficulty")) {
     md.AId = gtVal("Difficulty", s1, 0);
    }
    if (s1.startsWith("GraphicsReduction")) {
     md.GR = gtVal("GraphicsReduction", s1, 0);
    }
    if (s1.startsWith("#ofCars")) {
     nC = (int) gtVal("#ofCars", s1, 0);
    }
    if (s1.startsWith("ScreenSize")) {
     S = gtVal("ScreenSize", s1, 0);
     S *= .01;
    }
    if (s1.startsWith("Music(OFF)")) {
     mutM = true;
    }
    xst = new long[nC];
    yst = new long[nC];
    zst = new long[nC];
    pos = new long[nC];
    aclr = new long[nC];
    dtyp = new long[nC];
    opx = new double[nC];
    opz = new double[nC];
    opy = new double[nC];
    sdtyp = new long[nC];
    D = new Dir[nC];
   }
   d.close();
  } catch (Exception e) {
   System.out.println("Error Loading Default Settings: " + e);
  }
  Track tr = new Track();
  Turret t = new Turret(md);
  gts();
  pwr.ply(0);
  Act aa[] = new Act[mMax];
  base(aa, md, tr);
  Act aa1[] = new Act[3000];
  Play[] ap = new Play[nC];
  for (int a = 0; a < nC; a++) {
   ap[a] = new Play(md, this, a);
   D[a] = new Dir(md);
  }
  stg = (int) ((Math.random() * 71) + 1);
  slop = 0;
  C[0] = (int) (Math.random() * crs);
  op = (int) (Math.random() * crs);
  int[] mmry = new int[800];
  Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
  frm.setBounds((int) (dm.width * .5 - (800 * S)), (int) (dm.height * .5 - (400 * S)), (int) (1600 * S), (int) (800 * S));
  System.gc();
  while (true) {
   try {
    double d1 = System.nanoTime();
    if (theImage.contentsLost()) {
     theImage = createVolatileImage((int) (1600 * S), (int) (800 * S));
     gs = (Graphics2D) theImage.getGraphics();
    }
    if (mS != 0) {
     S += mS;
     if (S < .01) {
      S = .01;
     }
     frm.setBounds((int) (dm.width * .5 - (800 * S)), (int) (dm.height * .5 - (400 * S)), (int) (1600 * S), (int) (800 * S));
     theImage = createVolatileImage((int) (1600 * S), (int) (800 * S));
     gs = (Graphics2D) theImage.getGraphics();
     if (fas == "main") {
      gs.setColor(new Color(0, 0, 0));
      frct(0, 0, 1600, 800);
     }
     f("SansSerif", 1, 22);
     l(400, S * 100 + "%", Math.random() * 255, Math.random() * 255, Math.random() * 255);
     oxm = xm;
    }
    if (md.cx != 800 * S) {
     md.cx = 800 * S;
    }
    if (md.cy != 400 * S) {
     md.cy = 400 * S;
    }
    if (md.cz != 50 * S) {
     md.cz = 50 * S;
    }
    if (md.fcs_pnt != 500 * S) {
     md.fcs_pnt = 500 * S;
    }
    if (md.w != 1600 * S) {
     md.w = 1600 * S;
    }
    if (md.h != 800 * S) {
     md.h = 800 * S;
    }
    if (onC != nC) {
     xst = new long[nC];
     yst = new long[nC];
     zst = new long[nC];
     pos = new long[nC];
     aclr = new long[nC];
     dtyp = new long[nC];
     opx = new double[nC];
     opz = new double[nC];
     opy = new double[nC];
     sdtyp = new long[nC];
     ap = new Play[nC];
     D = new Dir[nC];
     for (int b = 0; b < nC; b++) {
      ap[b] = new Play(md, this, b);
      D[b] = new Dir(md);
     }
     onC = nC;
    }
    if (mutM && trk != null) {
     trk.stp();
    }
    if (end > 0) {
     end++;
     if (end > 2) {
      fas = "main";
      end = 0;
     }
    }
    if (fas == "init") {
     D[0].fals();
     gs.setColor(new Color(0, 0, 0));
     frct(0, 0, 1600, 800);
     gs.setColor(new Color(255, 255, 255));
     f("SansSerif", 1, 22);
     l(420, "Screen too big/small?", 255, 255, 255);
     l(450, "Hit + or - keys to change it!", 255, 255, 255);
     fas = "main";
    }
    if (fas == "crdts") {
     crdts();
     clck();
    }
    if (fas == "main") {
     main();
     clck();
    }
    if (fas == "opts") {
     opts(md);
     clck();
    }
    if (fas == "inst") {
     inst();
     clck();
    }
    if (fas.contains("cars")) {
     md.snap[0] = 0;
     md.snap[1] = 0;
     md.snap[2] = 0;
     cars(aa, ap[0], md, t);
     if (stg == 37 || stg == 52) {
      md.snw(gs, 0);
     }
     clck();
    }
    if (fas == "strt") {
     gstrt(true);
     if (D[0].spac || D[0].entr) {
      System.gc();
      fas = "go";
      D[0].spac = false;
      D[0].entr = false;
     }
     clck();
    }
    if (fas == "ldmus") {
     if (!mutM) {
      ldmus();
     } else {
      fas = "strt";
     }
    }
    if (fas == "nostg") {
     nostg();
     clck();
    }
    if (fas == "stgj") {
     stgj();
     clck();
    }
    if (fas == "stgq") {
     stgq();
     ldstg(aa1, aa, md, tr, ap);
     mmry = new int[nT];
     D[0].fals();
     zz = 0;
     d1 = System.nanoTime();
    }
    if (fas == "stgs") {
     md.dF(gs);
     for (c = 0; c < nT; c++) {
      aa1[c].dSM(gs);
     }
     md.dN(gs);
     md.rndtrck();
     for (int b = 0; b < nC; b++) {
      ap[b].db(gs, aa1[b]);
     }
     int n = 0;
     for (c = 0; c < nT; c++) {
      if (aa1[c].dist != 0) {
       mmry[n] = c;
       n++;
      } else {
       aa1[c].d(gs);
      }
     }
     int ai5[] = new int[n];
     for (c = 0; c < n; c++) {
      ai5[c] = 0;
     }
     for (c = 0; c < n; c++) {
      for (c1 = c + 1; c1 < n; c1++) {
       if (aa1[mmry[c]].dist != aa1[mmry[c1]].dist) {
        if (aa1[mmry[c]].dist < aa1[mmry[c1]].dist) {
         ai5[c]++;
        } else {
         ai5[c1]++;
        }
        continue;
       }
       if (c1 > c) {
        ai5[c]++;
       } else {
        ai5[c1]++;
       }
      }
     }
     for (c = 0; c < n; c++) {
      for (c1 = 0; c1 < n; c1++) {
       if (ai5[c1] == c) {
        aa1[mmry[c1]].d(gs);
       }
      }
     }
     if (stg == 37 || stg == 52) {
      md.snw(gs, 0);
     }
     clck();
     stgs(md);
    }
    if (fas == "gstrt") {
     gstrt(false);
     D[0].entr = false;
     D[0].spac = false;
     if (!mutM) {
      if (trk == null) {
       gtm(stg + "");
      }
      trk.lop();
     }
     setCursor(new Cursor(1));
     fas = "strt";
    }
    if (fas == "go" || fas == "psd" || fas == "opt") {
     for (c = 0; c < nC; c++) {
      if (ap[c].newcr) {
       double oxz = aa1[c].xz;
       double oxy = aa1[c].xy;
       double ozy = aa1[c].zy;
       double owxz = aa1[c].wxz;
       aa1[c] = new Act(aa[ap[c].cN], aa1[c].x, aa1[c].y, aa1[c].z, 0);
       aa1[c].xz = oxz;
       aa1[c].xy = oxy;
       aa1[c].zy = ozy;
       aa1[c].wxz = owxz;
       ap[c].newcr = false;
      }
     }
     md.dF(gs);
     for (c = 0; c < nT; c++) {
      aa1[c].dSM(gs);
     }
     md.dN(gs);
     int n = 0;
     for (c = 0; c < nT; c++) {
      if (aa1[c].dist != 0) {
       mmry[n] = c;
       n++;
      } else {
       aa1[c].d(gs);
      }
     }
     int[] v1 = new int[n];
     int[] v2 = new int[n];
     for (c = 0; c < n; c++) {
      v1[c] = 0;
     }
     for (c = 0; c < n; c++) {
      for (c1 = c + 1; c1 < n; c1++) {
       if (aa1[mmry[c]].dist != aa1[mmry[c1]].dist) {
        if (aa1[mmry[c]].dist < aa1[mmry[c1]].dist) {
         v1[c]++;
        } else {
         v1[c1]++;
        }
        continue;
       }
       if (c1 > c) {
        v1[c]++;
       } else {
        v1[c1]++;
       }
      }
      v2[v1[c]] = c;
     }
     for (c = 0; c < n; c++) {
      for (c1 = 0; c1 < nC; c1++) {
       ap[c1].db(gs, aa1[c1]);
      }
      aa1[mmry[v2[c]]].d(gs);
     }
     for (c = 0; c < nC; c++) {
      ap[c].xtra(aa1[c], D[c]);
     }
     if (cntd <= 0) {
      if (end < 1 && fas == "go") {
       if (mS == 0) {
        if (!D[0].left && oxm > xm) {
         D[0].riht = false;
         D[0].left = true;
         if (!DWC) {
          DWC = true;
         }
        }
        if (!D[0].riht && oxm < xm) {
         D[0].left = false;
         D[0].riht = true;
         if (!DWC) {
          DWC = true;
         }
        }
        if (DWC) {
         if ((D[0].left || D[0].riht) && oxm == xm) {
          D[0].left = false;
          D[0].riht = false;
         }
         if (ym > 550) {
          D[0].up = false;
          D[0].down = true;
         }
         if (ym < 450) {
          D[0].down = false;
          D[0].up = true;
         }
         if ((D[0].up || D[0].down || D[0].spac) == Math.abs(ym - 500) <= 50) {
          D[0].up = false;
          D[0].down = false;
         }
         D[0].spac = mous;
        }
       } else {
        DWC = false;
       }
       for (c = 0; c < nC; c++) {
        for (c1 = 0; c1 < nC; c1++) {
         if (c1 != c) {
          ap[c].hit(aa1[c], ap[c1], aa1[c1], D[c]);
         }
        }
       }
       for (c = 0; c < nC; c++) {
        ap[c].act(D[c], aa1[c], tr);
       }
       chkst(ap, aa1);
       if (nC > 1) {
        for (c = 1; c < nC; c++) {
         D[c].act(ap[c], aa1[c], this, ap);
        }
       }
      }
      for (c = 0; c < nC; c++) {
       ap[c].dexp(gs);
       ap[c].ds(gs);
       ap[c].ds2(gs);
      }
      for (c = 0; c < nC; c++) {
       if (cNm[ap[c].cN] == "Tactical Nuke" && !ap[c].dest && ap[c].dam > ap[c].dura[ap[c].cN]) {
        int r = (int) (Math.random() * 255);
        gs.setColor(new Color(255, 255, 255, r));
        frct(0, 0, 1600, 800);
       }
      }
     } else {
      if (cntd == 40) {
       if (Math.random() < .5) {
        md.rnd = 1;
       } else {
        md.rnd = -1;
       }
       md.adv = 1000;
       md.axz[1] = 0;
       im = 0;
       cntd = 39;
      }
      if (cntd == 39) {
       f("SansSerif", 1, 12);
       if (flk) {
        l(200, "Press Space or Enter to begin", 0, 0, 0);
       } else {
        l(200, "Press Space or Enter to begin", 255, 255, 255);
       }
      }
      if (fas == "go" && cntd > 0 && cntd < 39) {
       cntd -= zz;
       if (DWC) {
        DWC = false;
       }
      }
     }
     if (stg == 37 || stg == 52) {
      if (view == 3) {
       md.snw(gs, 0);
      } else {
       md.snw(gs, Math.sqrt(Math.pow(ap[im].nvx, 2) + Math.pow(ap[im].nvy, 2) + Math.pow(ap[im].nvz, 2)));
      }
     }
     if (cntd < 38) {
      if (view < 2 || view > 3) {
       md.folw(aa1[im], ap[im].cxz, D[0].loka, ap[im]);
      }
      if (view == 2) {
       md.arnd(aa1[im]);
      }
      if (view == 3) {
       md.wtch(aa1[im]);
      }
      if (end < 1) {
       stat(ap, aa1[im], md);
      }
     } else {
      md.arnd(aa1[im]);
      if (D[0].entr || D[0].spac) {
       cntd = 38;
       D[0].entr = false;
       D[0].spac = false;
      }
      if (cntd == 38) {
       md.vert = false;
       chkst(ap, aa1);
      }
     }
     if (md.axz[1] != 0 && lok1 && lok2) {
      md.axz[1] = 0;
     }
     if (im != 0 && u1 && u2) {
      im = 0;
     }
    }
    if (fas == "psd") {
     psd();
     clck();
    }
    if (fas == "opt") {
     opts(md);
     clck();
    }
    repaint();
    if (oxm != xm) {
     oxm = xm;
    }
    flk = !flk;
    if (msC) {
     mous = false;
     D[0].left = false;
     D[0].riht = false;
     D[0].entr = false;
    }
    if (mous && (fas != "go" || cntd >= 39)) {
     if (xm < 600) {
      D[0].left = true;
     }
     if (xm > 1000) {
      D[0].riht = true;
     }
     if (Math.abs(800 - xm) <= 200) {
      D[0].entr = true;
     }
     if (!(fas.contains("cars") || fas.contains("stg")) || Math.abs(800 - xm) <= 200) {
      msC = true;
     }
    }
    if (RR > 0) {
     try {
      Game.sleep(RR);
     } catch (Exception e) {
     }
    }
    zz = (System.nanoTime() - d1 + 500000) * gmspd * .000000001;
   } catch (Exception e) {
    System.out.println("An Exception has occurred: " + e);
    fas = "main";
    f("Arial", 1, 100);
    l(425, "An  ERROR  has  occurred!", 255, 0, 0);
    f("Arial", 1, 50);
    l(725, "(Game has Reset)", 0, 255, 255);
    for (c = 0; c < nC; c++) {
     ap[c].stpS();
    }
   }
  }
 }

 void cars(Act aa[], Play py, Mdm m, Turret t) {
  gs.setColor(new Color(0, 0, 0));
  frct(0, 0, 1600, 800);
  f("Impact", 0, 40);
  int v;
  if (fas == "ocars") {
   l(35, "SELECT OPPONENT", 255, 255, 255);
   v = op;
  } else {
   l(35, "SELECT YOUR CAR", 255, 255, 255);
   v = C[0];
  }
  m.crs = true;
  m.x = -800 * S;
  m.y = -700 * S;
  m.z = 1900;
  m.xz = 180;
  m.zy = 10;
  if (py.typ[v] == 2) {
   t.d(gs, 0, 150, 800);
  }
  aa[v].d(gs);
  aa[v].z = 950;
  aa[v].y = (-34 - aa[v].wG) * S;
  aa[v].x = 0;
  aa[v].xz += (800 - xm) * .02 * zz;
  if (py.typ[v] == 2) {
   aa[v].zy -= (400 - ym) * .02 * zz;
   aa[v].zy = Math.max(-90, Math.min(aa[v].zy, 90));
  }
  if (aa[v].zy != 0 && py.typ[v] != 2) {
   aa[v].zy = 0;
  }
  f("SansSerif", 1, 13);
  gs.setColor(new Color(255, 255, 255));
  d("BACK", 200, 600);
  d("NEXT", 1400, 600);
  l(700, "CONTINUE", 255, 255, 255);
  f("SansSerif", 1, 20);
  if (flk) {
   l(90, cNm[v], 255, 255, 255);
  } else {
   l(90, cNm[v], 192, 192, 192);
  }
  double c = 150 + Math.random() * 20;
  c(c, c, c);
  info(v, c);
  f("SansSerif", 0, 13);
  dr("Top Speed*:", 190, 623);
  if (cNm[v] != "A-1" && py.typ[v] != 2) {
   dl("Mph: " + (long) (py.spds[v][2] / 3.) + "", 210, 623);
   dl("Kph: " + (long) (py.spds[v][2] * 0.53644667) + "", 280, 623);
  }
  if (cNm[v] == "A-1") {
   dl("Light Speed", 210, 623);
  }
  if (py.typ[v] == 2) {
   dl("N/A", 210, 623);
  }
  dr("Acceleration Ratings*:", 190, 643);
  if (py.typ[v] == 2) {
   dl("N/A", 210, 643);
  } else {
   dl("+" + py.acel[v][0] + ",  +" + py.acel[v][1] + ",  +" + py.acel[v][2] + "", 210, 643);
  }
  dr("Handling Description:", 190, 663);
  dl("" + handl[v] + "", 210, 663);
  dr("Weapon/Special:", 190, 683);
  if (py.styp[v] < 0 && py.s2typ[v] < 0) {
   dl("None", 210, 683);
  }
  if (py.styp[v] > -1 && py.s2typ[v] < 0) {
   dl("Primary", 210, 683);
  }
  if (py.styp[v] > -1 && py.s2typ[v] > -1) {
   dl("Primary/Secondary", 210, 683);
  }
  dr("Stunts:", 1390, 623);
  if (py.typ[v] == 0) {
   dl("" + py.ars[v] + "", 1410, 623);
  } else {
   dl("N/A", 1410, 623);
  }
  dr("Damage Dealt:", 1390, 643);
  if (cNm[v] == "Lightning Rod") {
   dl("'Inconsistent'", 1410, 643);
  } else {
   dl("" + (long) (py.DD[v] * 10000) + " N", 1410, 643);
  }
  dr("Durability Rating:", 1390, 663);
  dl("" + py.dura[v], 1410, 663);
  dr("Power Savings:", 1390, 683);
  if (py.pwrs[v] > 0) {
   dl("" + py.pwrs[v] / 100 + "", 1410, 683);
  }
  if (py.pwrs[v] == 0) {
   dl("Infinity", 1410, 683);
  }
  if (py.pwrs[v] < 0) {
   dl("Self-generating", 1410, 683);
  }
  dr("Speed Boost:", 1390, 703);
  if (py.bost[v] > 0) {
   dl("Yes", 1410, 703);
  } else {
   dl("No", 1410, 703);
  }
  l(750, "*May be greater with Speed Boost", c, c, c);
  f("SansSerif", 1, 11);
  if (fas == "ocars") {
   if (D[0].riht) {
    op++;
    if (op > 49) {
     op = 0;
    }
    D[0].riht = false;
   }
   if (D[0].left) {
    op--;
    if (op < 0) {
     op = 49;
    }
    D[0].left = false;
   }
  } else {
   if (D[0].riht) {
    C[0]++;
    if (C[0] > 49) {
     C[0] = 0;
    }
    D[0].riht = false;
   }
   if (D[0].left) {
    C[0]--;
    if (C[0] < 0) {
     C[0] = 49;
    }
    D[0].left = false;
   }
  }
  if (D[0].spac || D[0].entr) {
   if (fas == "ocars") {
    fas = "stgj";
   } else {
    if (nC == 2) {
     fas = "ocars";
    } else {
     fas = "stgj";
    }
   }
   m.crs = false;
   D[0].spac = false;
   D[0].entr = false;
  }
 }

 void sort() {
  int b;
  for (b = 1; b < nC; b++) {
   C[b] = (int) (Math.random() * crs);
  }
  xst[0] = 0;
  if (nC > 1) {
   xst[1] = 0;
  }
  if (nC > 2) {
   xst[2] = 350;
  }
  if (nC > 3) {
   xst[3] = -350;
  }
  if (nC > 4) {
   xst[4] = -350;
  }
  if (nC > 5) {
   xst[5] = 350;
  }
  if (nC > 6) {
   xst[6] = 0;
  }
  if (nC > 7) {
   xst[7] = 700;
  }
  if (nC > 8) {
   xst[8] = 700;
  }
  if (nC > 9) {
   xst[9] = 700;
  }
  if (nC > 10) {
   xst[10] = -700;
  }
  if (nC > 11) {
   xst[11] = -700;
  }
  if (nC > 12) {
   xst[12] = -700;
  }
  for (b = 0; b < nC; b++) {
   yst[b] = 250;
  }
  zst[0] = 0;
  if (nC > 1) {
   zst[1] = -760;
  }
  if (nC > 2) {
   zst[2] = -380;
  }
  if (nC > 3) {
   zst[3] = -380;
  }
  if (nC > 4) {
   zst[4] = 380;
  }
  if (nC > 5) {
   zst[5] = 380;
  }
  if (nC > 6) {
   zst[6] = 760;
  }
  if (nC > 7) {
   zst[7] = 760;
  }
  if (nC > 8) {
   zst[8] = 0;
  }
  if (nC > 9) {
   zst[9] = -760;
  }
  if (nC > 10) {
   zst[10] = -760;
  }
  if (nC > 11) {
   zst[11] = 0;
  }
  if (nC > 12) {
   zst[12] = 760;
  }
  for (b = 13; b < nC; b++) {
   xst[b] = (long) (Math.random() * 50000) - (long) (Math.random() * 50000);
   yst[b] = 250;
   zst[b] = (long) (Math.random() * 50000) - (long) (Math.random() * 50000);
  }
  for (b = 0; b < nC; b++) {
   if (cNm[C[b]] == "Tactical Nuke") {
    xst[b] = (long) (Math.random() * 250000) - (long) (Math.random() * 250000);
    zst[b] = (long) (Math.random() * 250000) - (long) (Math.random() * 250000);
   }
   if (cNm[C[b]] == "KILL-O-MATIC" || cNm[C[b]] == "Gun Turret" || cNm[C[b]] == "YottaVolt Particle Disintegrator") {
    xst[b] = (long) (Math.random() * 50000) - (long) (Math.random() * 50000);
    if (stg == 71) {
     xst[b] += 135000;
    }
    zst[b] = (long) (Math.random() * 50000) - (long) (Math.random() * 50000);
   }
  }
  if (nC > 6) {
   if (stg == 2) {
    ci(6, "Drifter X");
   }
   if (stg == 3 || stg == 4) {
    ci(6, "Sword of Justice");
   }
   if (stg == 5 || stg == 6) {
    ci(6, "High Rider");
   }
   if (stg == 7 || stg == 8 || stg == 25) {
    ci(6, "EL KING");
   }
   if (stg == 9 || stg == 10) {
    ci(6, "Mighty Eight");
   }
   if (stg == 11 || stg == 12) {
    ci(6, "M A S H E E N");
   }
   if (stg == 13 || stg == 14) {
    ci(6, "Radical One");
   }
   if (stg == 15 || stg == 16 || stg == 20) {
    ci(6, "DR Monstaa");
   }
  }
  if (stg == 19) {
   for (b = 0; b < nC; b++) {
    xst[b] = (long) (Math.random() * 25000) - (long) (Math.random() * 25000);
    zst[b] = (long) (Math.random() * 25000) - (long) (Math.random() * 25000);
   }
  }
  if (stg == 21 || stg == 45 || stg == 48 || stg == 55 || stg == 60 || stg == 69) {
   for (b = 0; b < nC; b++) {
    xst[b] = (long) (Math.random() * 50000) - (long) (Math.random() * 50000);
    zst[b] = (long) (Math.random() * 50000) - (long) (Math.random() * 50000);
   }
  }
  if (stg == 24) {
   for (b = 0; b < nC; b++) {
    yst[b] = -5000;
   }
  }
  if (stg == 29) {
   for (b = 0; b < nC; b++) {
    yst[b] = -300000;
   }
  }
  if (stg == 33) {
   for (b = 0; b < nC; b++) {
    yst[b] = -9000;
   }
  }
  if (stg == 35) {
   ci(1, "TRAIN of TERROR");
  }
  if (stg == 40) {
   for (b = 0; b < nC; b++) {
    xst[b] = (long) (Math.random() * 5000) - (long) (Math.random() * 5000);
    zst[b] = (long) (Math.random() * 1000000) - (long) (Math.random() * 1000000);
   }
  }
  if (stg == 42) {
   for (b = 0; b < nC; b++) {
    xst[b] += 1540;
   }
  }
  if (stg == 49) {
   if (nC > 1) {
    ci(1, "KILL-O-MATIC");
    xst[1] = 0;
    zst[1] = -30000;
   }
   for (b = 2; b < nC; b++) {
    if (cNm[C[b]] == "KILL-O-MATIC") {
     xst[b] = 0;
     zst[b] = (long) (Math.random() * 30000) - (long) (Math.random() * 30000);
    }
   }
  }
  if (stg == 52) {
   for (b = 0; b < nC; b++) {
    yst[b] = -830;
   }
  }
  if (stg == 53) {
   for (b = 0; b < nC; b++) {
    xst[b] = (long) (Math.random() * 60000) - (long) (Math.random() * 60000);
    zst[b] = (long) (Math.random() * 60000) - (long) (Math.random() * 60000);
   }
  }
  if (stg == 54) {
   for (b = 0; b < nC; b++) {
    if (cNm[C[b]] == "Gun Turret" || cNm[C[b]] == "YottaVolt Particle Disintegrator") {
     zst[b] += 1000000;
    }
   }
  }
  if (stg == 55) {
   ci(1, "Sword of Justice");
   ci(2, "Desert Humvee");
   ci(3, "Armored Corvette");
   ci(4, "Sting Rod");
   ci(5, "Zonich Tank");
   ci(6, "Matlos Tank");
   ci(7, "Over=Kill");
   ci(8, "Lightning Rod");
   ci(9, "EL KING-OF-WAR");
   ci(10, "The Destroyer");
   ci(11, "A-1");
   if (Math.random() < .5) {
    ci(12, "YottaVolt Particle Disintegrator");
   } else {
    ci(12, "Gun Turret");
   }
  }
  if (stg == 57) {
   for (b = 0; b < nC; b++) {
    xst[b] = (long) (Math.random() * 30000) - (long) (Math.random() * 30000);
    zst[b] = (long) (Math.random() * 30000) - (long) (Math.random() * 30000);
   }
  }
  if (stg == 65) {
   for (b = 1; b < nC; b++) {
    ci(b, "Tactical Nuke");
    xst[b] = (long) (Math.random() * 250000) - (long) (Math.random() * 250000);
    zst[b] = (long) (Math.random() * 250000) - (long) (Math.random() * 250000);
   }
  }
  if (stg == 66) {
   if (Math.random() < .5) {
    ci(1, "YottaVolt Particle Disintegrator");
   } else {
    ci(1, "Gun Turret");
   }
   if (nC > 2) {
    ci(2, "Tactical Nuke");
    xst[2] = 0;
    zst[2] = 100500;
   }
   if (nC > 3) {
    ci(3, "SuperSonic DeathRay");
    xst[3] = 0;
    zst[3] = -6000;
   }
   if (nC > 4) {
    ci(4, "A-1");
    xst[4] = 0;
    zst[4] = 3000;
   }
   if (nC > 5) {
    ci(5, "A-1");
    xst[5] = 0;
    zst[5] = 2000;
   }
   if (nC > 6) {
    ci(6, "A-1");
    xst[6] = 190;
    zst[6] = 1000;
   }
   if (nC > 7) {
    ci(7, "A-1");
    xst[7] = -190;
    zst[7] = 1000;
   }
   if (nC > 8) {
    ci(8, "A-1");
    xst[8] = 380;
    zst[8] = -1000;
   }
   if (nC > 9) {
    ci(9, "A-1");
    xst[9] = -380;
    zst[9] = -1000;
   }
   if (nC > 10) {
    ci(10, "A-1");
    xst[10] = 570;
    zst[10] = -3000;
   }
   if (nC > 11) {
    ci(11, "A-1");
    xst[11] = -570;
    zst[11] = -3000;
   }
   if (nC > 12) {
    ci(12, "A-1");
    xst[12] = 0;
    zst[12] = -4000;
   }
   zst[0] = -3000;
   for (b = 0; b < nC; b++) {
    yst[b] = -100000000;
   }
   for (b = 0; b < nC; b++) {
    if (cNm[C[b]] == "Gun Turret" || cNm[C[b]] == "YottaVolt Particle Disintegrator") {
     xst[b] = (long) (Math.random() * 50000) - (long) (Math.random() * 50000);
     yst[b] += (Math.random() * 50000) - (Math.random() * 50000);
     zst[b] = (long) (Math.random() * 50000) - (long) (Math.random() * 50000);
    }
   }
  }
  if (stg == 67) {
   if (nC > 7) {
    xst[7] = 350;
    zst[7] += 1900;
   }
   if (nC > 8) {
    xst[8] = 350;
    zst[8] += 1900;
   }
   if (nC > 9) {
    xst[9] = 350;
    zst[9] += 1900;
   }
   if (nC > 10) {
    xst[10] = -350;
    zst[10] += 1900;
   }
   if (nC > 11) {
    xst[11] = -350;
    zst[11] += 1900;
   }
   if (nC > 12) {
    xst[12] = -350;
    zst[12] += 1900;
   }
  }
  if (stg == 68) {
   for (b = 1; b < nC; b++) {
    xst[b] = (long) (Math.random() * 500000) - (long) (Math.random() * 500000);
    zst[b] = (long) (Math.random() * 500000) - (long) (Math.random() * 500000);
   }
  }
  if (stg == 69) {
   ci(1, "EPIC TANK");
   ci(2, "EPIC TANK");
   ci(3, "EL KING-OF-WAR");
   ci(4, "EL KING-OF-WAR");
   ci(5, "KILL-O-MATIC");
   ci(6, "The Destroyer");
   ci(7, "The Destroyer");
   ci(8, "TRAIN of TERROR");
   ci(9, "F-22 Raptor");
   ci(10, "SuperSonic DeathRay");
   ci(11, "Gun Turret");
   ci(12, "YottaVolt Particle Disintegrator");
  }
  if (stg == 70) {
   for (b = 0; b < nC; b++) {
    zst[b] = 0;
   }
   if (nC > 1) {
    yst[1] = -1000000000;
    if (Math.random() < .5) {
     ci(1, "YottaVolt Particle Disintegrator");
    } else {
     ci(1, "Gun Turret");
    }
   }
   if (nC > 2) {
    ci(2, "Tactical Nuke");
    xst[2] = (long) (Math.random() * 1000000) - (long) (Math.random() * 1000000);
    yst[2] = (long) (Math.random() * 1000000) - (long) (Math.random() * 1000000) - 1000000000;
    zst[2] = (long) (Math.random() * 1000000) - (long) (Math.random() * 1000000);
   }
   if (nC > 3) {
    ci(3, "SuperSonic DeathRay");
    xst[3] = 0;
    yst[3] = -999999240;
   }
   if (nC > 4) {
    ci(4, "A-1");
    xst[4] = 380;
    yst[4] = -1000000380;
   }
   if (nC > 5) {
    ci(5, "A-1");
    xst[5] = 380;
    yst[5] = -999999620;
   }
   if (nC > 6) {
    ci(6, "A-1");
    xst[6] = -380;
    yst[6] = -999999620;
   }
   if (nC > 7) {
    ci(7, "A-1");
    xst[7] = -380;
    yst[7] = -1000000380;
   }
   if (nC > 8) {
    ci(8, "A-1");
    xst[8] = 0;
    yst[8] = -1000000760;
   }
   if (nC > 9) {
    ci(9, "A-1");
    xst[9] = -760;
    yst[9] = -1000000000;
   }
   if (nC > 10) {
    ci(10, "A-1");
    xst[10] = 760;
    yst[10] = -1000000000;
   }
   if (nC > 11) {
    ci(11, "A-1");
    xst[11] = 0;
    zst[11] = 760;
    yst[11] = -1000000000;
   }
   if (nC > 12) {
    ci(12, "A-1");
    xst[12] = 0;
    zst[12] = -760;
    yst[12] = -1000000000;
   }
   yst[0] = -1000000000;
   for (b = 0; b < nC; b++) {
    if (cNm[C[b]] == "Gun Turret" || cNm[C[b]] == "YottaVolt Particle Disintegrator") {
     xst[b] = (long) (Math.random() * 500000) - (long) (Math.random() * 500000);
     yst[b] += (Math.random() * 500000) - (Math.random() * 500000);
     zst[b] = (long) (Math.random() * 500000) - (long) (Math.random() * 500000);
    }
   }
   for (b = 13; b < nC; b++) {
    xst[b] = (long) (Math.random() * 50000) - (long) (Math.random() * 50000);
    yst[b] = (long) (Math.random() * 50000) - (long) (Math.random() * 50000) - 1000000000;
    zst[b] = (long) (Math.random() * 50000) - (long) (Math.random() * 50000);
   }
  }
  if (stg == 71) {
   for (b = 0; b < nC; b++) {
    if (cNm[C[b]] != "Gun Turret" && cNm[C[b]] != "YottaVolt Particle Disintegrator") {
     xst[b] = (long) (Math.random() * 25000) - (long) (Math.random() * 25000);
     zst[b] = (long) (Math.random() * 25000) - (long) (Math.random() * 25000);
     xst[b] += 67500;
    }
   }
  }
  if ((stg == 19 || stg == 21 || stg == 28 || stg == 33 || stg == 40 || stg == 45 || stg == 51) && Math.random() > .875) {
   for (b = 1; b < nC; b++) {
    C[b] = C[0];
   }
  }
  if ((stg == 30 || stg == 50 || stg == 54 || stg == 63 || stg == 64) && Math.random() > .75) {
   for (b = 1; b < nC; b++) {
    C[b] = C[0];
   }
  }
  if (nC == 2) {
   C[1] = op;
   if (cNm[C[1]] == "Tactical Nuke") {
    xst[1] = (long) (Math.random() * 250000) - (long) (Math.random() * 250000);
    zst[1] = (long) (Math.random() * 250000) - (long) (Math.random() * 250000);
   }
   if ((cNm[C[1]] == "KILL-O-MATIC" && stg != 49) || cNm[C[1]] == "Gun Turret" || cNm[C[1]] == "YottaVolt Particle Disintegrator") {
    xst[1] = (long) (Math.random() * 50000) - (long) (Math.random() * 50000);
    if (stg == 71) {
     xst[1] += 135000;
    }
    zst[1] = (long) (Math.random() * 50000) - (long) (Math.random() * 50000);
   }
  }
 }

 void ci(int c, String s) {
  for (int tc = 0; tc < crs; tc++) {
   if (s == cNm[tc]) {
    C[c] = tc;
   }
  }
 }

 void d(String s, double x, long y) {
  gs.drawString(s, (float) ((x * S) - (FM.stringWidth(s) * .5)), (float) (y * S));
 }

 void dl(String s, double x, long y) {
  gs.drawString(s, (float) (x * S), (float) (y * S));
 }

 void dr(String s, double x, long y) {
  gs.drawString(s, (float) ((x * S) - FM.stringWidth(s)), (float) (y * S));
 }

 void l(long y, String s, double r, double g, double b) {
  gs.setColor(new Color((int) Math.max(0, Math.min(r, 255)), (int) Math.max(0, Math.min(g, 255)), (int) Math.max(0, Math.min(b, 255))));
  gs.drawString(s, (float) ((800 * S) - (FM.stringWidth(s) * .5)), (float) (y * S));
 }

 void c(double r, double g, double b) {
  gs.setColor(new Color((int) Math.max(0, Math.min(r, 255)), (int) Math.max(0, Math.min(g, 255)), (int) Math.max(0, Math.min(b, 255))));
 }

 void ct(double r, double g, double b, double t) {
  gs.setColor(new Color((int) Math.max(0, Math.min(r, 255)), (int) Math.max(0, Math.min(g, 255)), (int) Math.max(0, Math.min(b, 255)), (int) Math.max(0, Math.min(t, 255))));
 }

 void frct(long x, long y, long w, long h) {
  gs.fillRect((int) (x * S), (int) (y * S), (int) (w * S), (int) (h * S));
 }

 void drct(long x, long y, long w, long h) {
  gs.drawRect((int) (x * S), (int) (y * S), (int) (w * S), (int) (h * S));
 }

 void f(String s, int w, long sz) {
  gs.setFont(new Font(s, w, (int) (sz * S)));
  FM = gs.getFontMetrics();
 }

 void clck() {
  if (fas == "inst") {
   gs.setColor(new Color(255, 255, 255));
   f("SansSerif", 1, 13);
   d("BACK", 200, 600);
   d("NEXT", 1400, 600);
  }
  if (fas == "psd") {
   if (Math.abs(355 - ym) < 13) {
    slop = 0;
   }
   if (Math.abs(385 - ym) < 13) {
    slop = 1;
   }
   if (Math.abs(415 - ym) < 13) {
    slop = 2;
   }
   if (Math.abs(445 - ym) < 13) {
    slop = 3;
   }
  }
  if (fas == "main") {
   if (Math.abs(557 - ym) < 13) {
    slop = 0;
   }
   if (Math.abs(586 - ym) < 13) {
    slop = 1;
   }
   if (Math.abs(615 - ym) < 13) {
    slop = 2;
   }
   if (Math.abs(645 - ym) < 13) {
    slop = 3;
   }
  }
  if (fas.contains("opt")) {
   if (Math.abs(256 - ym) < 13) {
    slop = 0;
   }
   if (Math.abs(286 - ym) < 13) {
    slop = 1;
   }
   if (Math.abs(316 - ym) < 13) {
    slop = 2;
   }
   if (Math.abs(346 - ym) < 13) {
    slop = 3;
   }
   if (Math.abs(376 - ym) < 13) {
    slop = 4;
   }
   if (Math.abs(406 - ym) < 13) {
    slop = 5;
   }
   if (Math.abs(436 - ym) < 13) {
    slop = 6;
   }
   if (Math.abs(466 - ym) < 13) {
    slop = 7;
   }
   if (Math.abs(496 - ym) < 13) {
    slop = 8;
   }
   if (fas == "opts" && Math.abs(526 - ym) < 13) {
    slop = 9;
   }
   if (Math.abs(746 - ym) < 13) {
    slop = 10;
   }
  }
 }

 void nostg() {
  setCursor(new Cursor(1));
  gs.setColor(new Color(0, 0, 0));
  frct(0, 0, 1600, 800);
  f("Impact", 0, 40);
  l(35, "SELECT STAGE", 255, 255, 255);
  f("SansSerif", 1, 30);
  d("BACK", 200, 600);
  d("NEXT", 1400, 600);
  l(700, "CONTINUE", 255, 255, 255);
  l(380, "Error Loading Stage " + stg, 255, 0, 0);
  l(420, "Hit Continue or Enter--stage should load normally the 2nd time", 255, 255, 255);
  f("SansSerif", 1, 11);
  l(796, "You can also use Keyboard Arrows and Enter to navigate.", 82, 90, 0);
  if (D[0].spac || D[0].entr) {
   fas = "stgq";
   D[0].spac = false;
   D[0].entr = false;
  }
  if (D[0].riht) {
   stg++;
   if (stg > 71) {
    stg = 1;
   }
   fas = "stgq";
   D[0].riht = false;
  }
  if (D[0].left) {
   stg--;
   if (stg < 1) {
    stg = 71;
   }
   fas = "stgq";
   D[0].left = false;
  }
 }

 void stgs(Mdm m) {
  setCursor(new Cursor(1));
  f("Impact", 0, 40);
  l(35, "SELECT STAGE", -m.csky[0] + 255, -m.csky[1] + 255, -m.csky[2] + 255);
  f("SansSerif", 1, 13);
  d("BACK", 200, 600);
  d("NEXT", 1400, 600);
  l(700, "CONTINUE", -m.cgrnd[0] + 255, -m.cgrnd[1] + 255, -m.cgrnd[2] + 255);
  l(100, "< Stage " + stg + "  >", -m.csky[0] + 255, -m.csky[1] + 255, -m.csky[2] + 255);
  if (nF < 1) {
   l(140, "(No Fixing!)", -m.csky[0] + 255, -m.csky[1] + 255, -m.csky[2] + 255);
  }
  l(120, "| " + say + " |", -m.csky[0] + 255, -m.csky[1] + 255, -m.csky[2] + 255);
  f("SansSerif", 1, 11);
  l(796, "You can also use Keyboard Arrows and Enter to navigate.", -m.cgrnd[0] + 255, -m.cgrnd[1] + 255, -m.cgrnd[2] + 255);
  if (D[0].spac || D[0].entr) {
   fas = "ldmus";
   D[0].spac = false;
   D[0].entr = false;
  }
  f("SansSerif", 1, 22);
  if (nCk < 1 && stg != 45) {
   l(676, "WASTE-ONLY STAGE!", 255, 0, 0);
  }
  if (D[0].riht) {
   stg++;
   if (stg > 71) {
    stg = 1;
   }
   fas = "stgj";
   D[0].riht = false;
  }
  if (D[0].left) {
   stg--;
   if (stg < 1) {
    stg = 71;
   }
   fas = "stgj";
   D[0].left = false;
  }
 }

 void stgj() {
  setCursor(new Cursor(1));
  gs.setColor(new Color(0, 0, 0));
  frct(0, 0, 1600, 800);
  f("SansSerif", 1, 40);
  gs.setColor(new Color(255, 255, 255));
  l(200, "Jump to Stage:", 255, 255, 255);
  d("BACK", 200, 600);
  d("NEXT", 1400, 600);
  l(700, "CONTINUE", 255, 255, 255);
  f("SansSerif", 1, 100);
  l(400, "--------->          <---------", Math.random() * 255, Math.random() * 255, Math.random() * 255);
  l(400, "" + stg, 255, 255, 255);
  f("SansSerif", 1, 11);
  l(796, "You can also use Keyboard Arrows and Enter to navigate.", 150, 150, 150);
  if (D[0].riht) {
   stg++;
   if (stg > 71) {
    stg = 1;
   }
   D[0].riht = false;
  }
  if (D[0].left) {
   stg--;
   if (stg < 1) {
    stg = 71;
   }
   D[0].left = false;
  }
  if (D[0].entr || D[0].spac) {
   fas = "stgq";
   D[0].spac = false;
   D[0].entr = false;
  }
 }

 void stgq() {
  setCursor(new Cursor(3));
  gs.setColor(new Color(0, 0, 0));
  frct(0, 0, 1600, 800);
  f("SansSerif", 1, 30);
  l(380, "Loading Stage " + stg + ", please wait...", 255, 255, 255);
  l(420, "(This may take a while, depending on the stage and # of cars selected)", 255, 255, 255);
  f("SansSerif", 1, 11);
  l(796, "You can also use Keyboard Arrows and Enter to navigate.", 150, 150, 150);
  repaint();
 }

 void inst() {
  if (sct < 1) {
   sct = 1;
  }
  gs.setColor(new Color(0, 0, 0));
  frct(0, 0, 1600, 800);
  gs.setColor(new Color(255, 255, 255));
  f("SansSerif", 1, 22);
  l(520, "Screen too big/small?", 255, 255, 255);
  l(550, "Hit + or - keys to change it!", 255, 255, 255);
  f("SansSerif", 1, 13);
  long s = 255;
  if (sct == 1) {
   l(20, "Main Game Controls", s, s, s);
   l(70, "Drive your car using the Arrow Keys", s, s, s);
   l(90, "On the GROUND Spacebar is the Handbrake", s, s, s);
   l(120, "----------------------------------------------------------------------------------------------------------------------------------------------------", s, s, s);
   l(150, "To perform stunts/enter Flying mode", s, s, s);
   l(170, "In the AIR press combo Spacebar + Arrow Keys", s, s, s);
   l(190, "If you're on the ground and using a flying vehicle, you can also press combo Spacebar + Down Arrow to Take-off at any time", s, s, s);
   l(210, "Hit V and/or F to use weapon(s)/specials if your vehicle has them (for most cars this will consume some power--stunts are key!)", s, s, s);
   l(250, "----------Cursor Controls----------", 128, s, 128);
   l(270, "Raise the cursor to go forward, lower it to Reverse", s, s, s);
   l(290, "Move the Cursor Left and Right to Turn", s, s, s);
   l(310, "Click to engage Handbrake or perform Stunts", s, s, s);
  }
  if (sct == 2) {
   l(60, "Welcome to the world of Need For Madness", s, s, s);
   l(80, "REVISED AND RECHARGED!", s, s, s);
   l(100, "In this game there are two ways to win.", s, s, s);
   l(120, "One is by racing and finishing in first place.", s, s, s);
   l(140, "The other is by wasting and destroying all the other cars in the stage!", s, s, s);
   l(290, "Drive your car using the Arrow Keys and Spacebar", s, s, s);
   l(320, "Or use the Cursor", s, s, s);
  }
  if (sct == 3) {
   l(60, "While racing, you will need to focus on passing through the checkpoints while avoiding obstacles and dangers.", s, s, s);
   l(80, "You must pass through all checkpoints in the track to complete a lap.", s, s, s);
   l(120, "While wasting, you will need to destroy all opponents--one way or another.", s, s, s);
   l(290, "Drive your car using the Arrow Keys and Spacebar", s, s, s);
   l(320, "Or use the Cursor", s, s, s);
  }
  if (sct == 4) {
   l(60, "Whether you are racing/wasting the other cars,", s, s, s);
   l(80, "you will need to power up yours (not an issue for some cars).", s, s, s);
   l(100, "More 'Power' equals a faster and stronger car!", s, s, s);
   l(120, "To power up your car (and keep it powered up) you will need to perform stunts!", s, s, s);
   l(285, "To perform stunts--when your car is in the AIR", s, s, s);
   l(305, "Press combo Spacebar + Arrow Keys", s, s, s);
   l(325, "Or click and use the Cursor", s, s, s);
   l(345, "Speed Boost also helps in the air", s, s, s);
  }
  if (sct == 5) {
   l(60, "The better the stunt the more power you get!", s, s, s);
   l(100, "Forward looping pushes your car forwards in the air and helps when racing.", s, s, s);
   l(120, "Backward looping pushes your car upwards making it easier to control its landing.", s, s, s);
   l(140, "Left and right rolls shift your car in the air left and right.", s, s, s);
   l(160, "A few cars can't stunt well or at all but don't worry--most of these vehicles power up on their own.", s, s, s);
   l(180, "You can also score Power by doing a 'Perfect Landing' if your car's within an angular degree of being perfectly flat when landing.", s, s, s);
   l(285, "To perform stunts--when your car is in the AIR", s, s, s);
   l(305, "Press combo Spacebar + Arrow Keys", s, s, s);
   l(325, "Or click and use the Cursor", s, s, s);
   l(345, "Speed Boost also helps in the air", s, s, s);
  }
  if (sct == 6) {
   l(80, "Press [ A ] to toggle the guidance arrow between pointing to the track or cars", s, s, s);
   l(100, "(The guidance arrow is unavailable in some stages.)", s, s, s);
   l(140, "When your car is damaged, fix it (and reset its 'Damage') by passing through the electrified hoop", s, s, s);
   l(160, "(not all stages have fix hoops).", s, s, s);
   l(200, "You will find that in some stages it's easier to waste the other cars", s, s, s);
   l(220, "and in others it's easier to race and finish in first place.", s, s, s);
   l(240, "(In some stages you can only waste, and if Immortality is on, you can only race!)", s, s, s);
   l(260, "And remember, 'Power' is key to this game.", s, s, s);
   l(280, "You will need it in all situations!", s, s, s);
   l(320, "One more thing--this game is as much a strategy game as an action game.", s, s, s);
   l(340, "Your smarts and ability to outsmart the opponents will get you far--with any vehicle.", s, s, s);
  }
  if (sct == 7) {
   l(120, "Other Key Controls :", s, s, s);
   l(160, "Z or X = To look around you while driving (>>Critical if you hear big gun fire!<<).", s, s, s);
   l(180, "(Press Z and X simultaneously to look forward again)", 128, s, 128);
   l(200, "C = Change Views", s, s, s);
   l(220, "V = Use Primary Weapon/Special (if available)", s, s, s);
   l(240, "F = Use Secondary Weapon/Special (if available)", s, s, s);
   l(260, "Enter or P = Pause Game", s, s, s);
   l(280, "M = Mute Music", s, s, s);
   l(300, "N = Mute Sound Effects", s, s, s);
   l(320, "S or D = Change Car Perspective (See what the opponents are doing)", s, s, s);
   l(340, "(Press S and D simultaneously to view yourself again)", 128, s, 128);
   l(360, "B = Boost Speed/Change Aerial Velocity (if available)", s, s, s);
   l(380, "G = Heads-up Display ON/OFF", s, s, s);
   l(400, "+ and - = Change Screen Size anytime", s, s, s);
  }
  if (D[0].riht) {
   sct++;
   if (sct > 7) {
    sct = 0;
    fas = ofas;
    f("SansSerif", 1, 11);
    gs.setColor(new Color(0, 0, 0));
    frct(0, 0, 1600, 800);
   }
  }
  if (D[0].left) {
   sct--;
   if (sct < 1) {
    sct = 0;
    fas = ofas;
    f("SansSerif", 1, 11);
    gs.setColor(new Color(0, 0, 0));
    frct(0, 0, 1600, 800);
   }
  }
  if (D[0].entr) {
   sct = 0;
   fas = ofas;
   f("SansSerif", 1, 11);
   gs.setColor(new Color(0, 0, 0));
   frct(0, 0, 1600, 800);
  }
  D[0].entr = false;
  D[0].left = false;
  D[0].riht = false;
 }

 void crdts() {
  if (!mutM) {
   if (trk == null) {
    gtm("crdts");
   }
   trk.lop();
  }
  if (sct == 0) {
   if (!mutS) {
    if (Math.random() < .5) {
     ps[1].ply(0);
    } else {
     ps[0].ply(0);
    }
   }
   sct = 1;
  }
  if (sct == 1) {
   gs.setColor(new Color(0, 0, 0));
   frct(0, 0, 1600, 800);
   f("Impact", 0, 80);
   l(80, "CREDITS", Math.random() * 255, Math.random() * 255, Math.random() * 255);
   f("SansSerif", 1, 26);
   l(200, "Original Game by Omar Waly at Radicalplay.com", Math.random() * 255, Math.random() * 255, Math.random() * 255);
   l(280, "All changes to the original game are made by By NeedForMadnessExpert/N.F.M.E./Ryan Albano,", Math.random() * 255, Math.random() * 255, Math.random() * 255);
   l(310, "whatever you call me!", Math.random() * 255, Math.random() * 255, Math.random() * 255);
   l(360, "Thanks for Game Testing", Math.random() * 255, Math.random() * 255, Math.random() * 255);
   f("SansSerif", 1, 22);
   l(400, "Soufy H Abutaleb, Sherif Abouzeid, Kareem Mansour, Youssef Wahby, Taymour Farid, ", Math.random() * 255, Math.random() * 255, Math.random() * 255);
   l(430, "Mahmoud Waly, Mahmoud Ezzeldin (Turbo), N.F.M.E. (most definitely), and everyone else who played the game and reported issues ", Math.random() * 255, Math.random() * 255, Math.random() * 255);
   l(490, "I thank Rory McHenry for teaching me how to Java hack. I couldn't have done so without him.", Math.random() * 255, Math.random() * 255, Math.random() * 255);
   l(520, "Special thanks to Mace Hussain for the car position/damage indicator", Math.random() * 255, Math.random() * 255, Math.random() * 255);
   l(550, "Thank Dany Fernández Diaz for insight on modernizing the game", Math.random() * 255, Math.random() * 255, Math.random() * 255);
   l(590, "Music edited to fit the game by Omar and me. Only Stage 21 was composed by me.", Math.random() * 255, Math.random() * 255, Math.random() * 255);
   l(620, "E-mail RyanAlbano1@gmail.com for more info about the music", Math.random() * 255, Math.random() * 255, Math.random() * 255);
   f("SansSerif", 1, 40);
   l(680, "Most of all, thanks to all my fans and everyone who gave me their ideas for RaR!", Math.random() * 255, Math.random() * 255, Math.random() * 255);
   l(740, "This would have never happened without your support!", Math.random() * 255, Math.random() * 255, Math.random() * 255);
  }
  if (sct == 2) {
   gs.setColor(new Color(0, 0, 0));
   frct(0, 0, 1600, 800);
   if (dr) {
    pnts *= .99;
   } else {
    pnts *= 1.01;
   }
   if (pnts > 2000) {
    dr = true;
   }
   if (pnts < 1) {
    dr = false;
    pnts = 1;
   }
   double[] xc = new double[(int) pnts];
   double[] yc = new double[(int) pnts];
   for (int d = 0; d < (long) pnts; d++) {
    xc[d] = (800 * S) + Math.pow(Math.random() * 90000000000l * S, .25) - Math.pow(Math.random() * 90000000000l * S, .25);
    yc[d] = (400 * S) + Math.pow(Math.random() * 60000000000l * S, .25) - Math.pow(Math.random() * 60000000000l * S, .25);
   }
   gs.setColor(new Color(255, 255, 255));
   pth = new Path2D.Double();
   pth.moveTo(xc[0], yc[0]);
   for (p = 0; p < (long) pnts; p++) {
    pth.lineTo(xc[p], yc[p]);
   }
   pth.closePath();
   gs.fill(pth);
   f("Impact", 0, 40);
   long c = 0;
   l(170, "REVISED AND RECHARGED", c, c, c);
   f("SansSerif", 1, 13);
   l(200, "Changes to the Game:", c, c, c);
   l(240, "More cars--More stages", c, c, c);
   l(260, "Diverse Vehicles with unique Abilities", c, c, c);
   l(280, "Game Modernized with better Graphics/Sound Rendering", c, c, c);
   l(300, "Fight your Own kind", c, c, c);
   l(320, "Resizable Screen with unlimited Resolution", c, c, c);
   l(340, "New Concepts", c, c, c);
   l(360, "A total Overhaul in 64-bit", c, c, c);
   l(380, "Frame rate can be 60+ FPS (depends on computer and gameplay)", c, c, c);
   l(400, "More Challenging Gameplay", c, c, c);
   l(420, "(Much!) Smarter AI", c, c, c);
   l(440, "A total of " + crs + " Cars and 71 Stages", c, c, c);
   l(460, "(Includes all the classic cars and stages as well)", c, c, c);
   l(480, "Plenty of Action and Strategy", c, c, c);
   l(500, "Nearly all notorious Glitches fixed!", c, c, c);
   l(520, "(You can report encountered glitches or send suggestions to RyanAlbano1@gmail.com)", c, c, c);
   l(540, "Most importantly--MORE EPIC!", c, c, c);
  }
  if (D[0].left) {
   sct--;
   if (sct < 1) {
    sct = 0;
    if (trk != null) {
     trk.stp();
    }
    fas = "init";
   }
   D[0].left = false;
  }
  if (D[0].riht) {
   sct++;
   if (sct > 2) {
    sct = 0;
    if (trk != null) {
     trk.stp();
    }
    fas = "init";
   }
   D[0].riht = false;
  }
  if (D[0].entr || D[0].spac || D[0].riht) {
   sct = 0;
   if (trk != null) {
    trk.stp();
   }
   fas = "init";
   D[0].entr = false;
   D[0].spac = false;
  }
  gs.setColor(new Color(192, 192, 192));
  f("SansSerif", 1, 13);
  d("BACK", 200, 600);
  d("NEXT", 1400, 600);
 }

 void psd() {
  if (D[0].up) {
   slop--;
   if (slop < 0) {
    slop = 3;
   }
   xm = 0;
   ym = 0;
   D[0].up = false;
  }
  if (D[0].down) {
   slop++;
   if (slop > 3) {
    slop = 0;
   }
   xm = 0;
   ym = 0;
   D[0].down = false;
  }
  if (D[0].entr || D[0].spac) {
   if (slop == 0) {
    fas = "go";
   }
   if (slop == 1) {
    fas = "opt";
   }
   if (slop == 2) {
    ofas = "psd";
    fas = "inst";
   }
   if (slop == 3) {
    if (trk != null) {
     trk.stp();
    }
    fas = "go";
    end = 1;
    slop = 0;
   }
   D[0].entr = false;
   D[0].spac = false;
  }
  if (end < 1) {
   if (slop == 0) {
    if (flk) {
     gs.setColor(new Color(255, 255, 255));
     drct(732, 345, 137, 22);
    } else {
     gs.setColor(new Color(0, 0, 0));
     drct(732, 345, 137, 22);
    }
   }
   if (slop == 1) {
    if (flk) {
     gs.setColor(new Color(255, 255, 255));
     drct(725, 375, 150, 22);
    } else {
     gs.setColor(new Color(0, 0, 0));
     drct(725, 375, 150, 22);
    }
   }
   if (slop == 2) {
    if (flk) {
     gs.setColor(new Color(255, 255, 255));
     drct(705, 405, 190, 22);
    } else {
     gs.setColor(new Color(0, 0, 0));
     drct(705, 405, 190, 22);
    }
   }
   if (slop == 3) {
    if (flk) {
     gs.setColor(new Color(255, 255, 255));
     drct(745, 435, 109, 22);
    } else {
     gs.setColor(new Color(0, 0, 0));
     drct(745, 435, 109, 22);
    }
   }
   f("SansSerif", 1, 30);
   l(298, "GAME PAUSED", 0, 0, 0);
   l(300, "GAME PAUSED", 255, 255, 255);
   f("SansSerif", 1, 16);
   l(362, "RESUME GAME", 255, 255, 255);
   l(392, "GAME OPTIONS", 255, 255, 255);
   l(422, "GAME INSTRUCTIONS", 255, 255, 255);
   l(452, "END GAME", 255, 255, 255);
  }
 }

 void main() {
  if (trk != null) {
   trk = null;
  }
  if (sct == 0) {
   setCursor(new Cursor(1));
  }
  if (D[0].up) {
   slop--;
   if (slop < 0) {
    slop = 3;
   }
   xm = 0;
   ym = 0;
   D[0].up = false;
  }
  if (D[0].down) {
   slop++;
   if (slop > 3) {
    slop = 0;
   }
   xm = 0;
   ym = 0;
   D[0].down = false;
  }
  gs.setColor(new Color(0, 0, 0));
  frct(745, 546, 110, 22);
  if (slop == 0) {
   if (flk) {
    gs.setColor(new Color(255, 255, 255));
   } else {
    gs.setColor(new Color(0, 0, 0));
   }
   frct(745, 546, 110, 22);
  }
  gs.setColor(new Color(0, 0, 0));
  frct(702, 575, 196, 22);
  if (slop == 1) {
   if (flk) {
    gs.setColor(new Color(0, 255, 0));
   } else {
    gs.setColor(new Color(0, 0, 0));
   }
   frct(702, 575, 196, 22);
  }
  gs.setColor(new Color(0, 0, 0));
  frct(758, 606, 85, 22);
  if (slop == 2) {
   if (flk) {
    gs.setColor(new Color(255, 0, 0));
   } else {
    gs.setColor(new Color(0, 0, 0));
   }
   frct(758, 606, 85, 22);
  }
  gs.setColor(new Color(0, 0, 0));
  frct(725, 635, 148, 22);
  if (slop == 3) {
   if (flk) {
    gs.setColor(new Color(0, 0, 255));
   } else {
    gs.setColor(new Color(0, 0, 0));
   }
   frct(725, 635, 148, 22);
  }
  if (D[0].entr || D[0].spac) {
   if (slop == 0) {
    fas = "cars";
   }
   if (slop == 1) {
    ofas = "main";
    fas = "inst";
   }
   if (slop == 2) {
    fas = "crdts";
   }
   if (slop == 3) {
    fas = "opts";
    slop = 10;
   }
   sct = 0;
   D[0].entr = false;
   D[0].spac = false;
  }
  f("Impact", 0, 50);
  l(48, "N    E    E    D         F    O    R         M    A    D    N    E    S    S", 0, 0, 0);
  l(49, "N    E    E    D         F    O    R         M    A    D    N    E    S    S", 128, 128, 128);
  l(52, "N    E    E    D         F    O    R         M    A    D    N    E    S    S", 0, 0, 0);
  l(51, "N    E    E    D         F    O    R         M    A    D    N    E    S    S", 128, 128, 128);
  l(50, "N    E    E    D         F    O    R         M    A    D    N    E    S    S", 255, 255, 255);
  l(248, "R    E    V    I    S    E    D         A    N    D         R    E    C    H    A    R    G    E    D", 0, 0, 0);
  l(252, "R    E    V    I    S    E    D         A    N    D         R    E    C    H    A    R    G    E    D", 0, 0, 0);
  l(249, "R    E    V    I    S    E    D         A    N    D         R    E    C    H    A    R    G    E    D", 128, 128, 128);
  l(251, "R    E    V    I    S    E    D         A    N    D         R    E    C    H    A    R    G    E    D", 128, 128, 128);
  l(250, "R    E    V    I    S    E    D         A    N    D         R    E    C    H    A    R    G    E    D", 255, 255, 255);
  f("SansSerif", 1, 16);
  l(563, "NEW GAME", 255, 255, 255);
  l(592, "GAME INSTRUCTIONS", 255, 255, 255);
  l(623, "CREDITS", 255, 255, 255);
  l(652, "GAME OPTIONS", 255, 255, 255);
 }

 void opts(Mdm m) {
  if (fas == "opts") {
   gs.setColor(new Color(0, 0, 0));
   frct(0, 0, 1600, 800);
  }
  f("Impact", 0, 40);
  l(125, "OPTIONS", 255, 255, 255);
  f("SansSerif", 1, 20);
  l(160, "Current Screen Size: " + S * 100 + "%", 255, 255, 255);
  gs.setColor(new Color(255, 255, 255));
  f("SansSerif", 1, 16);
  l(260, "Game Speed (" + gmspd + ")", 255, 255, 255);
  l(290, "Refresh Rate (" + RR + ")", 255, 255, 255);
  if (!m.nosc) {
   l(320, "Game Scenery (ON)", 128, 255, 128);
  } else {
   l(320, "Game Scenery (OFF)", 128, 128, 128);
  }
  if (!m.nofpwr) {
   l(350, "Firepower (ON)", 128, 255, 128);
  } else {
   l(350, "Firepower (OFF)", 128, 128, 128);
  }
  l(380, "Max Distance (" + m.maxD + ")", 255, 255, 255);
  l(410, "Zoom (" + m.zm + ")", 128, 255, 128);
  if (!m.imrtl) {
   l(440, "Immortality (OFF)", 128, 128, 128);
  } else {
   l(440, "Immortality (ON)", 128, 255, 128);
  }
  if (m.AId < 1) {
   l(470, "Difficulty (Dummy-Mode)", 128, 128, 128);
  }
  if (m.AId == 1) {
   l(470, "Difficulty (EASIER)", 128, 255, 128);
  }
  if (m.AId > 1) {
   l(470, "Difficulty (HARDER)", 255, 128, 128);
  }
  l(500, "Graphics Reduction (" + m.GR + ")", 255, 255, 255);
  if (fas == "opts") {
   l(530, "# of Cars (" + nC + ")", 255, 255, 255);
  }
  l(750, "CONTINUE", 255, 255, 255);
  if (D[0].up) {
   if (fas == "opt" && slop > 8) {
    slop = 8;
   } else {
    slop--;
   }
   if (slop < 0) {
    slop = 10;
   }
   xm = 0;
   ym = 0;
   D[0].up = false;
  }
  if (D[0].down) {
   slop++;
   if (slop > 10) {
    slop = 0;
   }
   xm = 0;
   ym = 0;
   D[0].down = false;
  }
  if (slop == 0) {
   if (flk) {
    gs.setColor(new Color(255, 255, 255));
   } else {
    gs.setColor(new Color(0, 0, 0));
   }
   drct(-2, 244, 1602, 22);
   if (D[0].left && gmspd > 0) {
    gmspd--;
   }
   if (D[0].riht) {
    gmspd++;
   }
   l(600, "Slower <----------                                                                                ----------> Faster", 255, 255, 255);
  }
  if (slop == 1) {
   if (flk) {
    gs.setColor(new Color(255, 255, 255));
   } else {
    gs.setColor(new Color(0, 0, 0));
   }
   drct(-2, 274, 1602, 22);
   if (D[0].left) {
    if (RR > 0) {
     RR--;
    } else {
     RR = 100;
    }
   }
   if (D[0].riht) {
    if (RR < 100) {
     RR++;
    } else {
     RR = 0;
    }
   }
   l(600, "Smoother Animation <----------                                                                                ----------> Less Flickering", 255, 255, 255);
   l(670, "# of intended Milliseconds between Frames--does not affect Game Speed", 255, 255, 255);
   l(690, "Increase if the screen flickers during gameplay", 255, 255, 255);
  }
  if (slop == 2) {
   if (flk) {
    gs.setColor(new Color(255, 255, 255));
   } else {
    gs.setColor(new Color(0, 0, 0));
   }
   drct(-2, 304, 1602, 22);
  }
  if (slop == 3) {
   if (flk) {
    gs.setColor(new Color(255, 255, 255));
   } else {
    gs.setColor(new Color(0, 0, 0));
   }
   drct(-2, 334, 1602, 22);
  }
  if (slop == 4) {
   if (flk) {
    gs.setColor(new Color(255, 255, 255));
   } else {
    gs.setColor(new Color(0, 0, 0));
   }
   drct(-2, 364, 1602, 22);
   if (D[0].left) {
    m.maxD *= .5;
   }
   if (D[0].riht) {
    m.maxD *= 2;
   }
   if (D[0].left && m.maxD > Integer.MAX_VALUE) {
    m.maxD = Integer.MAX_VALUE;
   }
   if (D[0].riht && m.maxD > Integer.MAX_VALUE) {
    m.maxD = Double.POSITIVE_INFINITY;
   }
   if (m.maxD < 1) {
    m.maxD = 1;
   }
   l(600, "Nearer <----------                                                                                ----------> Farther", 255, 255, 255);
   l(670, "Reduce if the game still lags", 255, 255, 255);
  }
  if (slop == 5) {
   if (flk) {
    gs.setColor(new Color(255, 255, 255));
   } else {
    gs.setColor(new Color(0, 0, 0));
   }
   drct(-2, 394, 1602, 22);
   if (D[0].left) {
    m.zm *= .99;
   }
   if (D[0].riht) {
    m.zm *= 1.01;
   }
   l(600, "Less <----------                                                                                ----------> More", 255, 255, 255);
  }
  if (slop == 6) {
   if (flk) {
    gs.setColor(new Color(255, 255, 255));
   } else {
    gs.setColor(new Color(0, 0, 0));
   }
   drct(-2, 424, 1602, 22);
  }
  if (slop == 7) {
   if (flk) {
    gs.setColor(new Color(255, 255, 255));
   } else {
    gs.setColor(new Color(0, 0, 0));
   }
   drct(-2, 454, 1602, 22);
   l(650, "(Based on Opponents' intelligence)", 255, 255, 255);
  }
  if (slop == 8) {
   if (flk) {
    gs.setColor(new Color(255, 255, 255));
   } else {
    gs.setColor(new Color(0, 0, 0));
   }
   drct(-2, 484, 1602, 22);
   if (D[0].left) {
    if (m.GR > 0) {
     m.GR--;
    } else {
     m.GR = 128;
    }
   }
   if (D[0].riht) {
    if (m.GR < 128) {
     m.GR++;
    } else {
     m.GR = 0;
    }
   }
   l(600, "More Detail & Lag <----------                                                                                ----------> Less Detail & Lag ", 255, 255, 255);
  }
  if (slop == 9) {
   if (fas == "opts") {
    if (flk) {
     gs.setColor(new Color(255, 255, 255));
    } else {
     gs.setColor(new Color(0, 0, 0));
    }
    drct(-2, 514, 1602, 22);
    if (D[0].left) {
     if (nC > 1) {
      nC--;
     } else {
      nC = mMax;
     }
    }
    if (D[0].riht) {
     if (nC < mMax) {
      nC++;
     } else {
      nC = 1;
     }
    }
    l(670, "More cars = More lag", 255, 255, 255);
    l(690, "(Setting this to '2' allows for Opponent Selection)", 255, 255, 255);
   } else {
    slop++;
   }
  }
  if (slop == 10) {
   if (flk) {
    gs.setColor(new Color(255, 255, 255));
   } else {
    gs.setColor(new Color(0, 0, 0));
   }
   drct(-2, 734, 1602, 22);
  }
  if (slop == 0 || slop == 1 || slop == 4 || slop == 5 || slop == 8 || (slop == 9 && fas == "opts")) {
   l(650, "Use Left and Right arrow keys to Adjust", 255, 255, 255);
  }
  if (slop == 2) {
   l(650, "De-activating this may reduce lag", 255, 255, 255);
  }
  if (D[0].entr || D[0].spac) {
   if (slop == 2) {
    m.nosc = !m.nosc;
   }
   if (slop == 3) {
    m.nofpwr = !m.nofpwr;
   }
   if (slop == 6) {
    m.imrtl = !m.imrtl;
   }
   if (slop == 7) {
    m.AId++;
    if (m.AId > 2) {
     m.AId = 0;
    }
   }
   if (slop == 10) {
    if (fas == "opt") {
     fas = "psd";
    }
    if (fas == "opts") {
     fas = "init";
    }
    slop = 0;
   }
   sct = 0;
   D[0].entr = false;
   D[0].spac = false;
  }
 }

 void ldmus() {
  gstrt(false);
  setCursor(new Cursor(3));
  repaint();
  System.gc();
  if (!mutM) {
   gtm(stg + "");
  }
  setCursor(new Cursor(1));
  fas = "gstrt";
 }

 void stat(Play[] py, Act a, Mdm m) {
  int c;
  int c1;
  f("SansSerif", 1, 12);
  if (wn < 0 && fas == "go" && cntd <= 0) {
   tt += 5 * zz;
   if (tt >= 100) {
    ts++;
    tt = 0;
   }
   if (ts > 59) {
    tm++;
    ts = 0;
   }
  }
  if (D[0].entr && fas == "go") {
   D[0].up = false;
   D[0].down = false;
   D[0].entr = false;
   slop = 0;
   fas = "psd";
  }
  if (HUD) {
   for (c = 0; c < nC; c++) {
    for (c1 = 0; c1 < nC; c1++) {
     if (pos[c1] == c && dtyp[c1] < 1) {
      c(-m.csky[0] + 255, -m.csky[1] + 255, -m.csky[2] + 255);
      if (nCk > 0) {
       if (c < 1) {
        dr("1st", 1590, 182 + 40 * c);
       }
       if (c == 1) {
        dr("2nd", 1590, 182 + 40 * c);
       }
       if (c == 2) {
        dr("3rd", 1590, 182 + 40 * c);
       }
       if (c > 2) {
        dr(c + 1 + "th", 1590, 182 + 40 * c);
       }
      }
      dr(cNm[C[c1]], 1590, 171 + 40 * c);
      double b = py[c1].dam / (double) py[c1].dura[C[c1]];
      double g1 = 255 - (255 * b);
      c(255, g1, 0);
      frct(1540, 175 + 40 * c, (long) (b * 60), 5);
     }
    }
   }
   if (cntd <= 0 && stg != 20 && stg != 67) {
    if (aCrs != D[0].aCrs) {
     aCrs = D[0].aCrs;
     if (aCrs) {
      wasay = false;
      say = "Arrow now pointing at Cars";
      tcnt = -5;
     } else {
      wasay = false;
      say = "Arrow now pointing at Track";
      tcnt = -5;
     }
    }
    arow(py[im].pnt, m);
   }
   gs.setColor(new Color(0, 255, 0));
   if (nCk > 0) {
    dl("Lap: " + (py[im].lapn + 1) + " / " + lapn, 10, 20);
    c(-m.csky[0] + 255, -m.csky[1] + 255, -m.csky[2] + 255);
    dl("POSITION:", 10, 39);
    f("SansSerif", 1, 24);
    dl("" + (pos[py[im].im] + 1), 80, 43);
   }
   f("SansSerif", 1, 12);
   c(-m.csky[0] + 255, -m.csky[1] + 255, -m.csky[2] + 255);
   dl("Elapsed Time: " + tm + ":" + ts + ":" + (long) tt, 10, 60);
   dr("DAMAGE:", 1490, 20);
   dr("POWER:", 1490, 40);
   f("SansSerif", 1, 23);
   drwst(py[im].dam / (double) py[im].dura[py[im].cN], py[im].pwr);
   c(-m.csky[0] + 255, -m.csky[1] + 255, -m.csky[2] + 255);
   d(100 * py[im].dam / py[im].dura[py[im].cN] + " %", 1550, 23);
   d((long) py[im].pwr + " %", 1550, 43);
   c(-m.cgrnd[0] + 255, -m.cgrnd[1] + 255, -m.cgrnd[2] + 255);
   f("SansSerif", 1, 13);
   if (py[im].typ[py[im].cN] != 2) {
    dl("Mph: " + (long) (py[im].spd / 3.), 10, 660);
    dl("Kph: " + (long) (py[im].spd * 0.53644667), 10, 675);
   }
   f("SansSerif", 1, 12);
   dl("X: " + (long) a.x, 10, 750);
   dl("Y: " + (long) a.y, 10, 765);
   dl("Z: " + (long) a.z, 10, 780);
   dl("Car #:", 10, 400);
   if (im == 0) {
    dl(im + " (You)", 10, 420);
   } else {
    dl(im + "", 10, 420);
   }
   if (py[im].fas == 2 && m.grv[stg] != 0 && m.sin(a.zy) > 0 && py[im].nvy + py[im].fy > 0) {
    l(770, "STALL", -m.csky[0] + 255, -m.csky[1] + 255, -m.csky[2] + 255);
   }
   gs.setColor(new Color(255, 0, 0));
   dl("Wasted: " + dstd + " / " + nC, 80, 20);
  }
  if (cntd > 0 && cntd < 36) {
   f("Impact", 0, 40);
  }
  if (fas == "go" && Math.abs(36 - cntd) < 2) {
   say = "3";
   l(69, "" + say + "", 0, 0, 0);
   l(71, "" + say + "", 0, 0, 0);
   l(70, "" + say + "", 255, 255, 255);
   if (!mutS) {
    cnt[1].lop(0);
   }
  } else if (cnt[1].clp.isRunning()) {
   cnt[1].stp();
  }
  if (fas == "go" && Math.abs(24 - cntd) < 2) {
   say = "2";
   l(69, "" + say + "", 0, 0, 0);
   l(71, "" + say + "", 0, 0, 0);
   l(70, "" + say + "", 255, 255, 255);
   if (!mutS) {
    cnt[1].lop(0);
   }
  } else if (cntd < 34 && cnt[1].clp.isRunning()) {
   cnt[1].stp();
  }
  if (fas == "go" && Math.abs(13 - cntd) < 2) {
   say = "1";
   l(69, "" + say + "", 0, 0, 0);
   l(71, "" + say + "", 0, 0, 0);
   l(70, "" + say + "", 255, 255, 255);
   if (!mutS) {
    cnt[1].lop(0);
   }
  } else if (cntd < 22 && cnt[1].clp.isRunning()) {
   cnt[1].stp();
  }
  if (fas == "go" && Math.abs(2 - cntd) < 2) {
   say = "GO!";
   l(69, "" + say + "", 0, 0, 0);
   l(71, "" + say + "", 0, 0, 0);
   l(70, "" + say + "", 255, 255, 255);
   if (!mutS) {
    cnt[0].lop(0);
   }
  } else if (cntd < 11 && cnt[0].clp.isRunning()) {
   cnt[1].stp();
   cnt[0].stp();
  }
  f("SansSerif", 1, 12);
  if (tcnt < 30) {
   if (flk) {
    l(115, say, 0, 0, 0);
   } else {
    l(115, say, 255, 255, 255);
   }
   if (fas == "go") {
    tcnt += zz;
   }
  } else if (wasay) {
   wasay = false;
  }
  if (py[im].flp && py[im].flpcnt > 0) {
   if (flk) {
    l(100, "Bad Landing!", 0, 0, 0);
   } else {
    l(100, "Bad Landing!", 255, 255, 255);
   }
  } else if (scnt < 45) {
   if (flk) {
    l(100, ssay, 255, 255, 255);
   } else {
    l(100, ssay, 0, 255, 0);
   }
   if (fas == "go") {
    scnt += zz;
   }
  }
  if (py[im].stcnt > 8 && py[im].pwrp > 0 && !(py[im].flp || py[im].stnd)) {
   lop = "";
   spn = "";
   ssay = "";
   long j;
   for (j = 0; py[im].stzy > 225; j++) {
    py[im].stzy -= 360;
   }
   while (py[im].stzy < -225) {
    py[im].stzy += 360;
    j--;
   }
   if (j == 1) {
    lop = "Forward loop";
   }
   if (j == 2) {
    lop = "double Forward";
   }
   if (j == 3) {
    lop = "triple Forward";
   }
   if (j == 4) {
    lop = "quadruple Forward";
   }
   if (j > 4) {
    lop = "massive Forward looping";
   }
   if (j == -1) {
    lop = "Backloop";
   }
   if (j == -2) {
    lop = "double Back";
   }
   if (j == -3) {
    lop = "triple Back";
   }
   if (j == -4) {
    lop = "quadruple Back";
   }
   if (j < -4) {
    lop = "massive Back looping";
   }
   if (j == 0) {
    if (py[im].tbltp[1] && py[im].tbltp[2]) {
     lop = "Tabletop and reversed Tabletop";
    } else if (py[im].tbltp[1] || py[im].tbltp[2]) {
     lop = "Tabletop";
    }
   }
   if (j > 0 && py[im].tbltp[2]) {
    lop = "Hanged " + lop;
   }
   if (j < 0 && py[im].tbltp[1]) {
    lop = "Hanged " + lop;
   }
   if (lop != "") {
    ssay += " " + lop;
   }
   j = 0;
   for (py[im].stxy = Math.abs(py[im].stxy); py[im].stxy > 270;) {
    py[im].stxy -= 360;
    j++;
   }
   if (j == 0 && py[im].tbltp[0]) {
    if (lop == "") {
     spn = "Tabletop";
    } else {
     spn = "Flipside";
    }
   }
   if (j == 1) {
    spn = "Rollspin";
   }
   if (j == 2) {
    spn = "double Rollspin";
   }
   if (j == 3) {
    spn = "triple Rollspin";
   }
   if (j == 4) {
    spn = "quadruple Rollspin";
   }
   if (j > 4) {
    spn = "massive Roll spinning";
   }
   j = 0;
   boolean tf1 = false;
   for (py[im].stxz = Math.abs(py[im].stxz); py[im].stxz > 90;) {
    py[im].stxz -= 180;
    if ((j += 180) > 900) {
     j = 900;
     tf1 = true;
    }
   }
   if (j != 0) {
    if (lop == "" && spn == "") {
     ssay += " " + j;
     if (tf1) {
      ssay += " and beyond";
     }
    } else {
     if (spn != "") {
      if (lop == "") {
       ssay += " " + spn;
      } else {
       ssay += " with " + spn;
      }
     }
     ssay += " by " + j;
     if (tf1) {
      ssay += " and beyond";
     }
    }
   } else if (spn != "") {
    if (lop == "") {
     ssay += " " + spn;
    } else {
     ssay += " by " + spn;
    }
   }
   if (ssay != "") {
    scnt -= 15;
   }
   if (lop != "") {
    scnt -= 25;
   }
   if (spn != "") {
    scnt -= 25;
   }
   if (j != 0) {
    scnt -= 25;
   }
   if (fas == "go" && scnt < 45) {
    if (!mutS) {
     pwr.ply(0);
    }
    if (scnt < -20) {
     scnt = -20;
    }
    int b0 = 0;
    if (py[im].pwrp > 20) {
     b0 = 1;
    }
    if (py[im].pwrp > 40) {
     b0 = 2;
    }
    if (py[im].pwrp > 150) {
     b0 = 3;
    }
    if (py[im].edg) {
     ssay = " " + adj[4][(int) (Math.random() * 3)] + ssay;
    }
    if (b0 != 3) {
     ssay = adj[b0][(int) (Math.random() * 8)] + ssay + ex[b0];
    } else {
     ssay = adj[b0][(int) (Math.random() * 8)];
    }
    if (!wasay) {
     tcnt = scnt;
     if (py[im].pwr < 100) {
      say = "Power Up " + (long) py[im].pwrp + "%";
     } else {
      say = "Power Up " + (long) py[im].pwrp + "% (MAX)";
     }
    }
   }
  }
  if (a.fcnt > 0 && a.fcnt < 1) {
   if (!wasay && cntd <= 0) {
    say = "Car Fixed";
    tcnt = 0;
   }
  }
  if (clr != py[im].clr && py[im].clr > 0) {
   if (!wasay) {
    say = "Checkpoint!";
    tcnt = 15;
   }
   if (!mutS) {
    cp.ply(0);
   }
   clr = py[im].clr;
  }
  if (nC > 1 && dstd == nC - 1 && !py[im].dest && py[im].dam <= py[im].dura[py[im].cN]) {
   f("Impact", 0, 40);
   l(169, "YOU WASTED 'EM!", 0, 0, 0);
   l(171, "YOU WASTED 'EM!", 0, 0, 0);
   l(170, "YOU WASTED 'EM!", 255, 255, 255);
   f("SansSerif", 1, 12);
   if (flk) {
    l(185, "All cars have been destroyed!", 0, 0, 0);
   } else {
    l(185, "All cars have been destroyed!", 0, 255, 0);
   }
   if (im == 0) {
    l(750, "Press  [ Enter ]  to continue", -m.cgrnd[0] + 255, -m.cgrnd[1] + 255, -m.cgrnd[2] + 255);
   }
  }
  if (py[im].dest && py[im].dcnt > 7) {
   f("Impact", 0, 40);
   if (dstd >= nC && nC > 1) {
    l(169, "YOU'RE ALL WASTED!", 0, 0, 0);
    l(171, "YOU'RE ALL WASTED!", 0, 0, 0);
    l(170, "YOU'RE ALL WASTED!", 255, 255, 255);
   } else {
    l(169, "YOU'RE WASTED!", 0, 0, 0);
    l(171, "YOU'RE WASTED!", 0, 0, 0);
    l(170, "YOU'RE WASTED!", 255, 255, 255);
   }
   f("SansSerif", 1, 12);
   if (dstd >= nC && nC > 1) {
    if (flk) {
     l(185, "Everyone's been destroyed!", 0, 0, 0);
    } else {
     l(185, "Everyone's been destroyed!", 255, 0, 0);
    }
   } else {
    if (flk) {
     l(185, "You have been destroyed!", 0, 0, 0);
    } else {
     l(185, "You have been destroyed!", 255, 0, 0);
    }
   }
   if (im == 0) {
    l(750, "Press  [ Enter ]  to continue", -m.cgrnd[0] + 255, -m.cgrnd[1] + 255, -m.cgrnd[2] + 255);
   }
  }
  if (stg == 45 && tm > 4 && py[0].dam <= py[0].dura[py[0].cN] && im == 0) {
   f("Impact", 0, 40);
   l(69, "YOU SURVIVED!", 0, 0, 0);
   l(71, "YOU SURVIVED!", 0, 0, 0);
   l(70, "YOU SURVIVED!", 255, 255, 255);
   f("SansSerif", 1, 12);
   if (flk) {
    l(85, "You survived 5 minutes--you win!", 255, 255, 255);
   } else {
    l(85, "You survived 5 minutes--you win!", 0, 255, 0);
   }
   l(750, "Press  [ Enter ]  to continue", -m.cgrnd[0] + 255, -m.cgrnd[1] + 255, -m.cgrnd[2] + 255);
  }
  if (wn < 0) {
   if (nCk > 0) {
    for (c = 0; c < nC; c++) {
     if (aclr[c] >= lapn * nCk) {
      if (!mutS) {
       if (c == im) {
        ps[0].ply(0);
       } else {
        ps[1].ply(0);
       }
      }
      wn = c;
     }
    }
   }
  } else {
   if (wn == im) {
    f("Impact", 0, 40);
    l(69, "YOU WON!", 0, 0, 0);
    l(71, "YOU WON!", 0, 0, 0);
    l(70, "YOU WON!", 255, 255, 255);
    f("SansSerif", 1, 12);
    if (flk) {
     l(85, "You finished first--well done!", 255, 255, 255);
    } else {
     l(85, "You finished first--well done!", 0, 255, 0);
    }
   } else {
    f("Impact", 0, 40);
    l(69, "YOU LOST!", 0, 0, 0);
    l(71, "YOU LOST!", 0, 0, 0);
    l(70, "YOU LOST!", 255, 255, 255);
    f("SansSerif", 1, 12);
    if (flk) {
     l(85, "" + cNm[C[wn]] + " finished first--race over!", 255, 255, 255);
    } else {
     l(85, "" + cNm[C[wn]] + " finished first--race over!", 255, 0, 0);
    }
   }
   if (im == 0) {
    l(750, "Press  [ Enter ]  to continue", -m.cgrnd[0] + 255, -m.cgrnd[1] + 255, -m.cgrnd[2] + 255);
   }
  }
 }

 void chkst(Play[] ap, Act aa[]) {
  dstd = 0;
  int a;
  for (a = 0; a < nC; a++) {
   if (opx[a] != aa[a].x) {
    opx[a] = aa[a].x;
   }
   if (opz[a] != aa[a].z) {
    opz[a] = aa[a].z;
   }
   if (opy[a] != aa[a].y) {
    opy[a] = aa[a].y;
   }
   if (ap[a].dest) {
    dstd++;
   }
   if (nCk > 0) {
    pos[a] = 0;
    if (dtyp[a] < 1) {
     if (aclr[a] != ap[a].clr) {
      aclr[a] = ap[a].clr;
     }
    } else if (aclr[a] > -1) {
     aclr[a] = -1;
    }
   } else {
    pos[a] = a;
   }
  }
  if (nCk > 0) {
   for (a = 0; a < nC; a++) {
    for (int b = a + 1; b < nC; b++) {
     if (aclr[a] != aclr[b]) {
      if (aclr[a] < aclr[b]) {
       pos[a]++;
      } else {
       pos[b]++;
      }
      continue;
     }
     if (x_y_z(aa[a].x, cx[ap[a].clrL], aa[a].z, cz[ap[a].clrL], aa[a].y, cy[ap[a].clrL]) > x_y_z(aa[b].x, cx[ap[a].clrL], aa[b].z, cz[ap[a].clrL], aa[b].y, cy[ap[a].clrL])) {
      pos[a]++;
     }
     if (x_y_z(aa[a].x, cx[ap[a].clrL], aa[a].z, cz[ap[a].clrL], aa[a].y, cy[ap[a].clrL]) < x_y_z(aa[b].x, cx[ap[a].clrL], aa[b].z, cz[ap[a].clrL], aa[b].y, cy[ap[a].clrL])) {
      pos[b]++;
     }
    }
   }
  }
 }

 void arow(int pnt, Mdm m) {
  double[] x0 = new double[7];
  double[] y0 = new double[7];
  double[] v = new double[7];
  double c = 800 * S;
  double c1 = 850 * S;
  int c2;
  for (c2 = 0; c2 < 7; c2++) {
   y0[c2] = -90;
  }
  x0[0] = c;
  v[0] = c1 + 110;
  x0[1] = c - 35;
  v[1] = c1 + 50;
  x0[2] = c - 15;
  v[2] = c1 + 50;
  x0[3] = c - 15;
  v[3] = c1 - 50;
  x0[4] = c + 15;
  v[4] = c1 - 50;
  x0[5] = c + 15;
  v[5] = c1 + 50;
  x0[6] = c + 35;
  v[6] = c1 + 50;
  int t = im;
  double d;
  if (!aCrs) {
   d = 90 + Math.atan((z[pnt] - opz[im]) / (x[pnt] - opx[im])) * 57.295779513082320876798154814105;
   if (x[pnt] - opx[im] >= 0) {
    d += 180;
   }
  } else {
   double nd = -1;
   for (c2 = 0; c2 < nC; c2++) {
    if (c2 != im && dtyp[c2] < 1 && (x_y_z(opx[im], opx[c2], opz[im], opz[c2], opy[im], opy[c2]) < nd || nd < 0)) {
     t = c2;
     nd = x_y_z(opx[im], opx[c2], opz[im], opz[c2], opy[im], opy[c2]);
    }
   }
   d = 90 + Math.atan((opz[t] - opz[im]) / (opx[t] - opx[im])) * 57.295779513082320876798154814105;
   if (opx[t] - opx[im] >= 0) {
    d += 180;
   }
   if (stg == 42) {
    l(13, "[ " + cNm[C[t]] + " ]", Math.random() * 255, Math.random() * 255, Math.random() * 255);
   } else {
    l(13, "[ " + cNm[C[t]] + " ]", -m.csky[0] + 255, -m.csky[1] + 255, -m.csky[2] + 255);
   }
   if (im == 0) {
    D[0].vic = t;
   }
  }
  for (d += m.xz; d < -180; d += 360) {
  }
  for (; d > 180; d -= 360) {
  }
  if (aCrs && (nC < 2 || t == im)) {
   d = 0;
  }
  m.rot(x0, v, c, c1, d, 7);
  if (!aCrs) {
   if (d != 0) {
    d = Math.abs(d);
    for (c2 = 0; c2 < 7; c2++) {
     x0[c2] = m.xs(x0[c2], v[c2]);
     y0[c2] = m.ys(y0[c2], v[c2]);
    }
    d *= 2;
    ct(-m.csky[0] + 255, -m.csky[1] + 255, -m.csky[2] + 255, d);
    pth = new Path2D.Double();
    pth.moveTo(x0[0], y0[0]);
    for (p = 0; p < 7; p++) {
     pth.lineTo(x0[p], y0[p]);
    }
    pth.closePath();
    gs.fill(pth);
   }
  } else {
   for (c2 = 0; c2 < 7; c2++) {
    x0[c2] = m.xs(x0[c2], v[c2]);
    y0[c2] = m.ys(y0[c2], v[c2]);
   }
   if (stg == 42) {
    c(Math.random() * 255, Math.random() * 255, Math.random() * 255);
   } else {
    gs.setColor(new Color(0, 0, 0));
   }
   pth = new Path2D.Double();
   pth.moveTo(x0[0], y0[0]);
   for (p = 0; p < 7; p++) {
    pth.lineTo(x0[p], y0[p]);
   }
   pth.closePath();
   gs.fill(pth);
   if (stg == 42) {
    c(Math.random() * 255, Math.random() * 255, Math.random() * 255);
   } else {
    gs.setColor(new Color(255, 255, 255));
   }
   pth = new Path2D.Double();
   pth.moveTo(x0[0], y0[0]);
   for (p = 0; p < 7; p++) {
    pth.lineTo(x0[p], y0[p]);
   }
   pth.closePath();
   gs.draw(pth);
  }
  if (m.grv[stg] == 0 && (Math.abs(opy[im] - y[pnt]) > 1000 || aCrs)) {
   double[] x1 = new double[7];
   double[] y1 = new double[7];
   if ((!aCrs && opy[im] < y[pnt]) || (aCrs && opy[im] < opy[t])) {
    x1[0] = 800 * S;
    x1[1] = 810 * S;
    x1[2] = 805 * S;
    x1[3] = 805 * S;
    x1[4] = 795 * S;
    x1[5] = 795 * S;
    x1[6] = 790 * S;
    y1[0] = 120 * S;
    y1[1] = 100 * S;
    y1[2] = 100 * S;
    y1[3] = 60 * S;
    y1[4] = 60 * S;
    y1[5] = 100 * S;
    y1[6] = 100 * S;
   }
   if ((!aCrs && opy[im] > y[pnt]) || (aCrs && opy[im] > opy[t])) {
    x1[0] = 800 * S;
    x1[1] = 810 * S;
    x1[2] = 805 * S;
    x1[3] = 805 * S;
    x1[4] = 795 * S;
    x1[5] = 795 * S;
    x1[6] = 790 * S;
    y1[0] = 60 * S;
    y1[1] = 80 * S;
    y1[2] = 80 * S;
    y1[3] = 120 * S;
    y1[4] = 120 * S;
    y1[5] = 80 * S;
    y1[6] = 80 * S;
   }
   ct(255, 255, 255, Math.abs(opy[im] - y[pnt]) * .01);
   if (aCrs) {
    gs.setColor(new Color(0, 0, 0));
   }
   for (c2 = 0; c2 < 7; c2++) {
    x1[c2] -= 100.;
   }
   pth = new Path2D.Double();
   pth.moveTo(x1[0], y1[0]);
   for (p = 0; p < 7; p++) {
    pth.lineTo(x1[p], y1[p]);
   }
   pth.closePath();
   gs.fill(pth);
   if (aCrs) {
    gs.setColor(new Color(255, 255, 255));
    pth = new Path2D.Double();
    pth.moveTo(x1[0], y1[0]);
    for (p = 0; p < 7; p++) {
     pth.lineTo(x1[p], y1[p]);
    }
    pth.closePath();
    gs.draw(pth);
   }
   for (c2 = 0; c2 < 7; c2++) {
    x1[c2] += 200.;
   }
   if (aCrs) {
    gs.setColor(new Color(0, 0, 0));
   }
   pth = new Path2D.Double();
   pth.moveTo(x1[0], y1[0]);
   for (p = 0; p < 7; p++) {
    pth.lineTo(x1[p], y1[p]);
   }
   pth.closePath();
   gs.fill(pth);
   if (aCrs) {
    gs.setColor(new Color(255, 255, 255));
    pth = new Path2D.Double();
    pth.moveTo(x1[0], y1[0]);
    for (p = 0; p < 7; p++) {
     pth.lineTo(x1[p], y1[p]);
    }
    pth.closePath();
    gs.draw(pth);
   }
  }
 }

 void drwst(double dmdra, double pwr) {
  double[] x1 = new double[4];
  double[] y1 = new double[4];
  x1[0] = 1500 * S;
  y1[0] = 11 * S;
  x1[1] = 1500 * S;
  y1[1] = 20 * S;
  x1[2] = (1500 + (100 * dmdra)) * S;
  y1[2] = 20 * S;
  x1[3] = (1500 + (100 * dmdra)) * S;
  y1[3] = 11 * S;
  double g = 255;
  g -= 255 * dmdra;
  c(255, g, 0);
  pth = new Path2D.Double();
  pth.moveTo(x1[0], y1[0]);
  for (p = 0; p < 4; p++) {
   pth.lineTo(x1[p], y1[p]);
  }
  pth.closePath();
  gs.fill(pth);
  x1[0] = 1500 * S;
  y1[0] = 31 * S;
  x1[1] = 1500 * S;
  y1[1] = 40 * S;
  x1[2] = (1500 + pwr) * S;
  y1[2] = 40 * S;
  x1[3] = (1500 + pwr) * S;
  y1[3] = 31 * S;
  int r = 128;
  if (pwr >= 100) {
   r = 64;
  }
  g = 190 + pwr * .37;
  if (scnt < 45 && flk) {
   r = 128;
   g = 255;
  }
  c(r, g, 255);
  pth = new Path2D.Double();
  pth.moveTo(x1[0], y1[0]);
  for (p = 0; p < 4; p++) {
   pth.lineTo(x1[p], y1[p]);
  }
  pth.closePath();
  gs.fill(pth);
 }

 void gstrt(boolean tf) {
  gs.setColor(new Color(0, 0, 0));
  frct(0, 0, 1600, 800);
  f("SansSerif", 1, 13);
  long c = 255;
  l(25, "Stage " + stg + ":  " + say, c, c, c);
  if (stg == 1) {
   l(80, "Remember to pass through all checkpoints in the track!", c, c, c);
  }
  if (stg == 2) {
   l(80, "Remember--the more power you have the faster your car will be!", c, c, c);
  }
  if (stg == 4) {
   l(80, "Don't waste your time. Waste them instead!", c, c, c);
   l(100, "Try a taste of sweet revenge here (if you can)!", c, c, c);
   l(120, "Press [ A ] to make the guidance arrow point to cars instead of the track.", c, c, c);
  }
  if (stg == 7) {
   l(80, "Welcome to the realm of the king...", c, c, c);
   l(100, "The key word here is 'POWER'.", c, c, c);
   l(120, "The more of it you have, the faster and STRONGER your car will be!", c, c, c);
  }
  if (stg == 8) {
   l(80, "Watch out, EL KING is out to get you now!", c, c, c);
   l(100, "He seems to be seeking revenge?", c, c, c);
   l(120, "(To fly longer distances in the air try drifting your car on ramps before take off).", c, c, c);
  }
  if (stg == 9) {
   l(80, "It's good to be the king!", c, c, c);
  }
  if (stg == 10) {
   l(80, "Remember--forward loops give your car a push forwards in the air and help in racing.", c, c, c);
   l(100, "(You may need to do more forward loops here. Also try keeping your power maximized at all times. Try not to miss a ramp).", c, c, c);
  }
  if (stg == 12) {
   l(80, "Watch out! Beware!", c, c, c);
   l(100, "Someone is hiding out there somewhere, don't get mashed now!", c, c, c);
  }
  if (stg == 13) {
   l(80, "Anyone for a game of Digger?!", c, c, c);
   l(100, "You can have fun using M A S H E E N (or anyone else for that matter) here!", c, c, c);
  }
  if (stg == 16) {
   l(80, "This track is actually a 4D object projected onto the 3D world.", c, c, c);
   l(100, "It's been broken down, separated and, in many ways, it is also a maze!  GOOD LUCK!", c, c, c);
  }
  if (stg == 18) {
   l(80, "It's the jungle gym of NFM!", c, c, c);
   l(100, "(See if you can reach the floating checkpoint)", c, c, c);
  }
  if (stg == 19) {
   l(80, "Plan A: Waste 'Em!", c, c, c);
   l(100, "Plan B: Waste 'Em!", c, c, c);
  }
  if (stg == 20 || stg == 67) {
   l(80, "Note: Guidance Arrow is disabled in this stage!", c, c, c);
  }
  if (stg == 21) {
   l(80, "The Slaughterhouse of NFM", c, c, c);
  }
  if (stg == 23) {
   l(80, "Note: This is harder than it looks!", c, c, c);
  }
  if (stg == 26) {
   l(80, "NOTE: This stage contains a slight gravitational field.", c, c, c);
   l(100, "All cars are pulled towards the starting point (fix hoop!)", c, c, c);
  }
  if (stg == 27) {
   l(80, "The only way to complete this stage is to find the fix hoop.", c, c, c);
   l(100, "Enjoy the trip!", c, c, c);
  }
  if (stg == 28) {
   l(80, "NOTE: It's you v.s. them here!", c, c, c);
   l(100, "Do you have what it takes to waste them all?", c, c, c);
  }
  if (stg == 29) {
   l(80, "This is one of those tracks where you really don't want to miss a ramp!", c, c, c);
   l(100, "When stunting, press Up + Down simultaneously to get more air!", c, c, c);
  }
  if (stg == 31) {
   l(80, "Oh Yes there WILL be head-on collisions!", c, c, c);
  }
  if (stg == 35) {
   l(80, "Don't forget to look behind you!", c, c, c);
  }
  if (stg == 37) {
   l(80, "Hint: Use whatever bit of road is available to get more traction.", c, c, c);
   l(100, "Hmmmmm... some cars are seemingly immune to the slipperiness!", c, c, c);
  }
  if (stg == 38) {
   l(80, "The reduced gravity may help with stunts, but not racing!", c, c, c);
  }
  if (stg == 39) {
   l(80, "How much damage can you take--or avoid taking?", c, c, c);
   l(100, "This stage has 4 laps and no fix hoop.", c, c, c);
   l(120, "It is critical to avoid getting damaged here--whether you're racing or wasting.", c, c, c);
  }
  if (stg == 40) {
   l(80, "WOO-HAA!", c, c, c);
  }
  if (stg == 43) {
   l(80, "..or freak out for that matter..", c, c, c);
  }
  if (stg == 45) {
   l(80, "To win:", c, c, c);
   l(100, "Survive for 5 minutes", c, c, c);
   l(120, "Or try wasting them instead!", c, c, c);
  }
  if (stg == 47) {
   l(80, "(Good driving practice!)", c, c, c);
  }
  if (stg == 54) {
   l(80, "This could very well be the fastest paced race in the game!", c, c, c);
  }
  if (stg == 55) {
   l(80, "Remember to check your damage bar!", c, c, c);
  }
  if (stg == 56) {
   l(80, "The keys to this stage are Aerial Control and patience", c, c, c);
  }
  if (stg == 58) {
   l(80, "162 platforms--41 checkpoints,", c, c, c);
   l(100, "all scrambled in no order whatsoever.", c, c, c);
   l(120, "Take your time here--don't rush!", c, c, c);
   l(140, "Also--use a car with high grip and low bounce.", c, c, c);
  }
  if (stg == 60) {
   l(80, "There's no track?!", c, c, c);
   l(100, "Win any way you can.", c, c, c);
  }
  if (stg == 65) {
   l(80, "They're coming to get you...", c, c, c);
  }
  if (stg == 66) {
   l(80, "If this's the first time you've seen an NFM stage in the middle of outer space, there are a few things you should know:", c, c, c);
   l(100, "Checkpoints, other track parts, opponents may be above or below you!", c, c, c);
   l(120, "To change speed, land on any road platform.", c, c, c);
   l(140, "Regular cars are probably useless here, but anything's possible.", c, c, c);
  }
  if (stg == 68) {
   l(80, "You are in danger", c, c, c);
   l(100, "Beware!", c, c, c);
  }
  if (stg == 69) {
   l(80, "This is all out war!", c, c, c);
   l(100, "Can you come out on top?", c, c, c);
   l(120, "If you're really daring, you can try racing this too!", c, c, c);
  }
  if (stg == 70) {
   l(80, "This is truly a 3D stage!", c, c, c);
   l(100, "It will push your flying skills to the MAX!", c, c, c);
   l(100, "No matter what vehicle you use, this stage will be hard!", c, c, c);
  }
  if (stg == 71) {
   l(80, "Have Fun!", c, c, c);
  }
  if (!tf && !mutM) {
   f("Impact", 2, 24);
   l(300, "< LOADING STAGE SOUND TRACK >", Math.random() * 255, Math.random() * 255, Math.random() * 255);
   f("SansSerif", 1, 11);
   l(350, "...Please Wait...", c, c, c);
  } else {
   l(400, "Loading complete!  Press Start to begin...", c, c, c);
   f("Impact", 0, 40);
   if (flk) {
    l(500, "START", 255, 255, 255);
   } else {
    l(500, "START", Math.random() * 255, Math.random() * 255, Math.random() * 255);
   }
  }
 }

 void info(int v, double c) {
  long y1 = 600;
  long y2 = 620;
  long y3 = 640;
  f("SansSerif", 1, 18);
  if (v < 16) {
   if (v == 3) {
    l(y1, "Similar to the original La Vita Crab", c, c, c);
   } else {
    l(y1, "Similar to the original " + cNm[v], c, c, c);
   }
  }
  if (v == 0) {
   l(y2, "General stat boosts for RaR", c, c, c);
  }
  if (v == 1) {
   l(y2, "The most noticeable difference being the improvement in Speed", c, c, c);
  }
  if (v == 2) {
   l(y2, "Mostly Strength and Durability improvements", c, c, c);
  }
  if (v == 3) {
   l(y2, "Better Speed mostly", c, c, c);
  }
  if (v == 4) {
   l(y2, "Better Power Savings mostly", c, c, c);
  }
  if (v == 5) {
   l(y2, "General stat boosts for RaR", c, c, c);
  }
  if (v == 6) {
   l(y2, "General stat boosts for RaR", c, c, c);
  }
  if (v == 7) {
   l(y2, "Deals more damage now, but still quite a brittle car", c, c, c);
  }
  if (v == 8) {
   l(y2, "Major upgrades are in Speed, Acceleration, and Speed Boost", c, c, c);
  }
  if (v == 9) {
   l(y2, "The only original car to get Weaponry", c, c, c);
  }
  if (v == 10) {
   l(y2, "Improved Speed and Acceleration", c, c, c);
  }
  if (v == 11) {
   l(y2, "Though much more Durable now and a slight Strength advantage over DR Monstaa", c, c, c);
  }
  if (v == 12) {
   l(y2, "But way Faster than before!", c, c, c);
  }
  if (v == 13) {
   l(y2, "Almost identical, really", c, c, c);
  }
  if (v == 14) {
   l(y2, "Now with better Turning and Speed", c, c, c);
  }
  if (v == 15) {
   l(y2, "Slightly Faster than the original", c, c, c);
  }
  if (v == 16) {
   l(y1, "A standard vehicle with balanced abilities", c, c, c);
  }
  if (v == 17) {
   l(y1, "This one delivers a short burst of high Speed before needing to be repowered", c, c, c);
   l(y2, "Most Fragile vehicle in the game. Don't crash!", c, c, c);
  }
  if (v == 18) {
   l(y1, "Good Durability and Endurance. This one's built to last.", c, c, c);
  }
  if (v == 19) {
   l(y1, "Good street racer. Don't get in a brawl with it though", c, c, c);
  }
  if (v == 20) {
   l(y1, "This one boasts Speed, Strength, and a gun. Beware of poor Acceleration caused by the extra weight", c, c, c);
  }
  if (v == 21) {
   l(y1, "This one's very light, with super Speed, Handling, and Stunting.", c, c, c);
   l(y2, "Does very little self-damage, but cannot tolerate serious collisions or any weapon fire.", c, c, c);
  }
  if (v == 22) {
   l(y1, "Much like a racer, but also doubles with Stunts and Bouncing, which may (not) help in racing.", c, c, c);
  }
  if (v == 23) {
   l(y1, "Here's a bully that deals some damage and fires pretty heavy as well.", c, c, c);
  }
  if (v == 24) {
   l(y1, "Straight out of Radical Aces, this little tank will drive the wasters crazy", c, c, c);
  }
  if (v == 25) {
   l(y1, "Straight out of Radical Aces, Zonich's big brother has homing weapons that won't be evaded!", c, c, c);
  }
  if (v == 26) {
   l(y1, "Stunt and Bounce master. Also 1 of 2 cars that drives on either side and never fails a stunt!", c, c, c);
   l(y2, "(The other vehicle that can do this is Everlast-177)", c, c, c);
  }
  if (v == 27) {
   l(y1, "This car's for the pros. With practice, this one will be both fun and rewarding", c, c, c);
  }
  if (v == 28) {
   l(y1, "Basically a much faster version of EL KING", c, c, c);
   l(y2, "The handling's still that of a truck though--don't expect control at 500+ mph!", c, c, c);
  }
  if (v == 29) {
   l(y1, "A much faster version of Mighty Eight", c, c, c);
   l(y2, "This one should meet your need for speed, topping it at 1000 mph!", c, c, c);
  }
  if (v == 30) {
   l(y1, "The extra Speed + the Strength and Durability of  M A S H E E N  may serve you well", c, c, c);
  }
  if (v == 31) {
   l(y1, "DR Monstaa with rockets. This one will 'drive' you mad!", c, c, c);
  }
  if (v == 32) {
   l(y1, "Perfect, predictable control and performance only possible in the virtual world.", c, c, c);
   l(y2, "This car will be your best option for racing and setting new records", c, c, c);
  }
  if (v == 33) {
   l(y1, "A stark contrast to the Awesome Radical One", c, c, c);
   l(y2, "This is one thrilling, untamed beast!", c, c, c);
  }
  if (v == 34) {
   l(y1, "The name says it all", c, c, c);
   l(y2, "This one chews 'em up and spits 'em out!", c, c, c);
  }
  if (v == 35) {
   l(y1, "Here's one bizarre and irritating contraption", c, c, c);
   l(y2, "Its unlimited energy will ruin everyone's plans", c, c, c);
  }
  if (v == 36) {
   l(y1, "It's probably too slow to reach most fix hoops, but you won't need to", c, c, c);
   l(y2, "This thing was built to take it all. And its artillery and land mines will lead you to victory", c, c, c);
  }
  if (v == 37) {
   l(y1, "Looking to deal some damage? This war machine self-generates all the power you need", c, c, c);
   l(y2, "Blazing miniguns on all sides, and homing missiles that don't forgive", c, c, c);
   l(y3, "And even if you do die, the thing blows up very good!", c, c, c);
  }
  if (v == 38) {
   l(y1, "The strongest vehicle in the game!", c, c, c);
   l(y2, "If you crash into it, YOU WILL BE DESTROYED!", c, c, c);
   l(y3, "It can only be destroyed by very heavy weaponry or another KILL-O-MATIC", c, c, c);
  }
  if (v == 39) {
   l(y1, "It's back!", c, c, c);
   l(y2, "It may not be unstoppable as before, but the Phantom will have many special abilities", c, c, c);
   l(y3, "The primary special provides temporary shielding from the cars and track", c, c, c);
   l(660, "(Secondary special has not yet been created)", c, c, c);
  }
  if (v == 40) {
   l(y1, "The perfect hybrid of Speed, Handling, Stunts, Strength, Weapons, everything!", c, c, c);
   l(y2, "An ideal Racer/Waster", c, c, c);
  }
  if (v == 41) {
   l(y1, "Your ultimate survival vehicle", c, c, c);
   l(y2, "Fast enough to race, yet will take nearly anything thrown at it", c, c, c);
   l(y3, "Like Air Rebound, this one's two-sided, making stunts actually quite easy", c, c, c);
  }
  if (v == 42) {
   l(y1, "Power, weaponry, and destruction like you couldn't believe", c, c, c);
   l(y2, "If you're competing against it--you better be afraid!", c, c, c);
  }
  if (v == 43) {
   l(y1, "Your first flying vehicle", c, c, c);
   l(y2, "Handles great and never loses Speed--this thing was built to fly", c, c, c);
  }
  if (v == 44) {
   l(y1, "This is how you maintain air superiority in RaR", c, c, c);
   l(y2, "Guns, missiles, afterburner (Speed Boost)--it has everything you need", c, c, c);
  }
  if (v == 45) {
   l(y1, "The most infamous piece of this game!", c, c, c);
   l(y2, "It's the factor that won't be ignored!", c, c, c);
  }
  if (v == 46) {
   l(y1, "Perfect--Flawless", c, c, c);
   l(y2, "There's no limit with this flying dream", c, c, c);
   l(y3, "Will break records and reach other dimensions--it will blow your mind", c, c, c);
  }
  if (v == 47) {
   l(y1, "The flying equivalent of TRAIN of TERROR", c, c, c);
   l(y2, "Not a graceful vehicle, but it too will bring utter annihilation!", c, c, c);
  }
  if (v == 48) {
   l(y1, "Stand your ground!", c, c, c);
   l(y2, "Don't be deceived by its size--this unrelenting cannon's going to endure", c, c, c);
  }
  if (v == 49) {
   l(y1, "This cutting-edge weapon may very well be the most effective", c, c, c);
   l(y2, "Its effects are widespread, invisible, silent, immediate, and surprisingly devastating", c, c, c);
   l(y3, "Yet, despite its futuristic approach, it doesn't do too well against a good old smash-up!", c, c, c);
  }
 }

 void gts() {
  try {
   String fil = ".au";
   FileInputStream fi = new FileInputStream("/app/games/nfm-2-rar-v7/sound.zip");
   ZipInputStream zi = new ZipInputStream(fi);
   ZipEntry ze = zi.getNextEntry();
   while (ze != null) {
    int i = (int) ze.getSize();
    String s = ze.getName();
    byte[] ab = new byte[i];
    int j = 0;
    int k;
    for (; i > 0; i -= k) {
     k = zi.read(ab, j, i);
     j += k;
    }
    if (s.equals("cp" + fil)) {
     cp = new Sound(ab, this);
    }
    if (s.equals("pwr" + fil)) {
     pwr = new Sound(ab, this);
    }
    if (s.equals("out" + fil)) {
     out = new Sound(ab, this);
    }
    int b;
    for (b = 0; b < 2; b++) {
     if (s.equals("cnt" + b + fil)) {
      cnt[b] = new Sound(ab, this);
     }
     if (s.equals("ps" + b + fil)) {
      ps[b] = new Sound(ab, this);
     }
    }
    ze = zi.getNextEntry();
   }
   fi.close();
   zi.close();
  } catch (Exception e) {
   System.out.println("Error Loading Sounds: " + e);
  }
  System.gc();
 }

 void gtm(String x) {
  try {
   FileInputStream fi = new FileInputStream("/app/nfm-2-rar-v7-music/" + x + ".zip");
   ZipInputStream zi = new ZipInputStream(fi);
   ZipEntry ze = zi.getNextEntry();
   while (ze != null) {
    int i = (int) ze.getSize();
    byte[] ab = new byte[i];
    int j = 0;
    int k;
    for (; i > 0; i -= k) {
     k = zi.read(ab, j, i);
     j += k;
    }
    trk = new Music(ab);
   }
   fi.close();
   zi.close();
  } catch (Exception e) {
   System.out.println("Error Loading Music: " + e);
  }
  System.gc();
 }

 void reset() {
  clr = 0;
  scnt = 45;
  cntd = 40;
  tm = 0;
  ts = 0;
  tt = 0;
  tcnt = 30;
  for (int d = 0; d < nC; d++) {
   sdtyp[d] = 0;
  }
  wn = -1;
 }

 double x_z(double x1, double x2, double z1, double z2) {
  return (x1 - x2) * (x1 - x2) + (z1 - z2) * (z1 - z2);
 }

 double x_y_z(double x1, double x2, double y1, double y2, double z1, double z2) {
  return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) + (z1 - z2) * (z1 - z2);
 }
}
