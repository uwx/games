
import java.awt.Graphics2D;
import java.io.FileInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

class Play {

 Mdm M;
 Game GM;
 Guns G;
 Guns2 G2;
 Exp E;
 Turret T;
 int cN;
 int im;
 int typ[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2};
 long acel[][] = {{11, 7, 5}, {14, 13, 12}, {10, 5, 4}, {11, 7, 5}, {10, 6, 4}, {13, 6, 6}, {10, 9, 4}, {11, 6, 3}, {14, 8, 6}, {11, 7, 4}, {13, 9, 6}, {9, 5, 3}, {13, 7, 6}, {7, 3, 3}, {12, 7, 4}, {10, 5, 3},
 {10, 6, 3}, {22, 14, 10}, {11, 6, 3}, {11, 7, 5}, {5, 5, 5}, {11, 10, 9}, {10, 7, 4}, {10, 10, 10}, {15, 15, 15}, {15, 15, 15}, {9, 7, 5}, {10, 10, 10}, {9, 9, 9}, {13, 13, 13}, {7, 7, 7}, {10, 10, 10}, {22, 16, 14}, {30, 30, 30}, {7, 6, 5}, {9, 8, 7}, {9, 6, 3}, {9, 5, 3}, {3, 2, 1}, {10, 9, 8}, {11, 10, 9}, {3, 3, 3}, {1, 1, 1}, {7, 6, 5}, {30, 20, 10}, {20, 20, 20}, {30, 30, 30}, {5, 4, 3}, {0, 0, 0}, {0, 0, 0}};
 long spds[][] = {{50, 180, 360}, {100, 200, 669}, {60, 180, 330}, {200, 200, 500}, {70, 170, 360}, {60, 200, 450}, {60, 170, 400}, {60, 180, 340}, {90, 210, 500}, {90, 190, 360}, {70, 200, 440}, {50, 160, 270}, {90, 200, 600}, {50, 130, 210}, {80, 200, 525}, {70, 210, 350},
 {50, 180, 350}, {100, 200, 800}, {60, 180, 320}, {70, 250, 600}, {80, 200, 420}, {70, 190, 620}, {60, 250, 525}, {60, 170, 300}, {60, 170, 360}, {60, 170, 305}, {70, 210, 330}, {20, 250, 750}, {50, 160, 2000}, {90, 200, 3000}, {50, 130, 1000}, {70, 210, 2000}, {80, 200, 3000}, {200, 300, 1000}, {50, 100, 255}, {310, 310, 450}, {75, 125, 175}, {50, 160, 270}, {50, 100, 150}, {90, 180, 360}, {70, 210, 500}, {100, 100, 330}, {100, 100, 300}, {0, 225, 600}, {0, 100, 3000}, {0, 150, 3000}, {0, 1000, Long.MAX_VALUE}, {0, 50, 2100}, {0, 0, 0}, {0, 0, 0}};
 long brak[] = {7, 15, 7, 15, 12, 8, 9, 10, 11, 7, 8, 10, 14, 12, 7, 7,
  7, 30, 14, 15, 6, 20, 18, 14, 30, 30, 17, 20, 10, 14, 12, 7, 75, 50, 5, 40, 10, 10, 3, 20, 20, 3, 2, 10, 10, 40, 50, 5, 0, 0};
 double ars[] = {1, 1.2, .95, 1, 2.2, 1, .9, .8, 1, .9, 1.15, .8, 1, .3, 1.3, 1,
  1, 1.2, .95, 1, .8, Double.POSITIVE_INFINITY, 1.25, .9, 1, 1.5, 1, 1, .8, 1, .3, 1, Double.POSITIVE_INFINITY, 1.3, .4, 3, .3, .25, .25, 2, 2, .3, 0, 0, 0, 0, 0, 0, 0, 0};
 long arc[] = {70, 30, 40, 40, 30, 50, 40, 90, 40, 50, 75, 10, 50, 0, 100, 60,
  40, 30, 50, 40, 50, 125, 75, 40, 75, 100, 64, 50, 10, 50, 0, 60, 100, 300, 80, 200, 5, 10, 0, 100, 60, 0, 0, 0, 0, 0, 0, 0, 0, 0};
 double drg[] = {.5, .5, .5, .5, .5, .5, .5, .5, .5, .5, .5, .5, .5, .5, .5, .5,
  .5, .5, .5, .5, .5, .5, .5, .45, .5, .5, .475, .5, .5, .5, .5, .5, .25, .5, .4, .5, .625, .3, .1, .5, .375, .5, .1, 0, .25, .25, .25, .125, .5, .5};
 long trn[] = {8, 12, 6, 9, 9, 8, 7, 6, 9, 7, 9, 4, 7, 5, 18, 6,
  8, 20, 6, 9, 8, 0, 10, 5, 0, 0, 10, 12, 4, 7, 5, 6, 0, 18, 4, 36, 9, 4, 3, 13, 18, 4, 6, 11, 8, 0, 0, 9, 9, 0};
 long grip[] = {24, 35, 20, 25, 25, 27, 30, 21, 16, 30, 25, 25, 35, 27, 40, 30,
  23, 75, 25, 35, 35, 50, 30, 27, Long.MAX_VALUE, Long.MAX_VALUE, 32, 30, 25, 35, 27, 30, Long.MAX_VALUE, 100, 25, Long.MAX_VALUE, Long.MAX_VALUE, 25, Long.MAX_VALUE, Long.MAX_VALUE, Long.MAX_VALUE, Long.MAX_VALUE, Long.MAX_VALUE, 27, 35, Long.MAX_VALUE, Long.MAX_VALUE, Long.MAX_VALUE, Long.MAX_VALUE, Long.MAX_VALUE};
 double bonc[] = {.5, .2, .6, .25, .4, .4, .3, .4, .35, .4, .6, .25, .3, .25, .3, .55,
  .4, .15, .3, .25, .2, .4, .8, .5, .75, .5, 1, .25, .25, .3, .25, .55, 0, .5, .95, .7, 0, .25, 0, 0, .4, 0, 0, .6, .5, 0, 0, 0, 0, 0};
 double siz[] = {.9, .85, 1.05, .9, .85, .9, 1.05, 1, .95, 1.05, .9, 1.2, .9, 1.3, .9, 1.15,
  .9, .85, 1.05, .9, 1.2, .25, .9, 1.05, 1, 1, 1.15, 1, 1.2, .9, 1.3, 1.15, .9, 1.5, 1.75, .9, 1.5, 1.4, 2, 1, 1.15, 1.5, 2, 1, 1.1, .01, .5, 1.5, .5, .5};
 double[] DD = {1.3, 1, 1.6, 1, 1.1, 1.3, 1.4, 1.5, 1.2, 1.45, 1.375, 2.5, 1.3, 3, 1, 2,
  1.3, 1, 1.6, 1.25, 1.75, .1, 1.4, 1.9, 1.1, 1.5, 1.5, 1.4, 2.5, 1.3, 3, 2, 1.1, 2, 4, .6, 5, 3.5, 100, 1.4, 2, 2, 6, 1.4, 1.5, 100, 1.5, 3.5, 1.5, 1.25};
 double hitr[] = {.5, .4, .8, .5, .3, .5, .5, .5, .5, .8, .5, 1, .5, .6, .5, .8,
  .5, .4, .8, .5, .5, .1, .5, .5, .5, .5, .5, 1, 1, .5, .6, .8, .5, .25, 5, 2, 2, 1, 7.5, .75, .8, 1, 2, .6, .6, 1, .75, 1, 2, 2};
 long psht[] = {2, 2, 3, 3, 2, 2, 2, 4, 2, 2, 2, 4, 2, 2, 2, 2,
  2, 2, 3, 3, 2, 3, 2, 3, 1, 2, 3, 3, 4, 2, 2, 2, 2, 3, 6, 2, 1, 5, 100, 2, 3, 2, 7, 2, 2, 100, 3, 5, 1, 1};
 long pshu[] = {2, 3, 2, 2, 2, 2, 2, 1, 2, 1, 2, 1, 2, 0, 2, 1,
  2, 2, 2, 2, 1, 3, 2, 2, 1, 1, 1, 2, 1, 2, 0, 1, 2, 1, 0, -2, 0, 1, 0, 2, 1, 0, 0, 2, 2, 2, 1, 1, 0, 0};
 long lift[] = {0, 30, 0, 20, 0, 30, 0, 0, 20, 0, 0, 0, 10, 0, 30, 0,
  0, 30, 0, 20, 15, 30, 30, 0, 10, 10, 0, 10, 0, 10, 0, 0, 30, 0, 0, 10, 0, 0, 0, 15, 0, 0, 0, 0, 0, 0, 10, 0, 0, 0};
 long lifu[] = {0, 0, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32,
  0, 0, 0, 0, 0, 0, 30, 0, 0, 0, 100, 0, 0, 0, 0, 32, 0, 0, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
 long pwrs[] = {3500, 2500, 5500, 3000, 10000, 3000, 5000, 4000, 2750, 3500, 2750, 10000, 3500, 20000, 3000, 4000,
  3500, 100, 7000, 4200, 3500, 3000, 4000, 8000, 0, 0, 4500, 5000, 5000, 1750, 2000, 2000, 4100, 2000, 15000, -1, -1, -1, -1, 0, 0, 3000, -1, 5000, -1, 6500, 0, -1, -1, -1};
 long flpy[] = {50, 60, 92, 44, 60, 57, 54, 60, 77, 57, 82, 85, 28, 100, 63, 127,
  50, 26, 90, 61, 70, 21, 53, 54, 45, 55, 0, 45, 85, 28, 100, 127, 30, 60, 170, 25, 85, 140, 70, 40, 70, 0, 150, 30, 30, 0, 60, 90, 0, 0};
 long[] cRad = {3300, 1700, 4700, 3000, 2000, 4500, 3500, 5000, 10000, 15000, 4000, 7000, 10000, 20000, 5500, 5000,
  3300, 1500, 3500, 3000, 2000, 3000, 2100, 3500, 3750, 4000, 12000, 2000, 7000, 10000, 20000, 5000, 4000, 5000, 10000, 5000, 3000, 25000, 0, 5000, 10000, 4000, 10000, 10000, 10000, 1000, 5000, 25000, 2500, 2500};
 double[] damM = {.6, .875, .55, .75, .6, .6, .72, .8, .6, .46, .67, .5, .6, .4, .4, .46,
  .6, 1, .4, .7, .6, .3, .65, .6, .5, .5, .5, .65, .5, .6, .4, .46, .5, 1, .6, .2, .2, .8, 2, .6, .5, .1, .5, .9, .9, 1, .75, .75, .25, 2};
 long dura[] = {2250, 1000, 3000, 1300, 1300, 2000, 2800, 2900, 2000, 2750, 2250, 4000, 2000, 6000, 1500, 3600,
  2500, 500, 3500, 1500, 2750, 200, 1600, 4000, 1660, 1750, 3000, 2000, 4000, 2000, 6000, 3600, 1250, 2500, 7500, 1500, 20000, 9000, 25000, 2500, 6000, 22500, 15000, 2000, 2000, 490, 3000, 10000, 12500, 2500};
 long bost[] = {0, 0, 0, 0, 0, 0, 0, 0, 15, 0, 0, 0, 0, 0, 0, 0,
  0, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 50, 10, 0, 0, 0, 0, 0, 25, 0, 0, 0, 25, 0, 0, 0, 0, 0};
 long emit[] = {0, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
  0, 200, 0, 0, 0, 50, 0, 0, 0, 0, 0, 0, 400, 300, 400, 400, 300, 50, 0, 0, 0, 0, 0, 0, 500, 0, 0, 0, 500, 250, 500, 1000, 0, 0};
 double spn[] = {.00005, .00005, 0.00004, .00005, .00005, .00005, 0.00004, 0.00004, .00005, 0.00004, .00005, 0.00001, .00005, 0.00001, 0.000035, .00005,
  .00005, 0.00001, 0.00002, .00005, 0.00002, 0.00002, .00005, 0.00001, 0, 0, .00005, 0.00002, 0.00001, .00005, 0.00001, .00005, 0, 0.00001, 0.00001, 0, 0, 0, 0, 0.00004, 0, 0, 0, .00005, .000025, 0, 0, 0, 0, 0};
 long lAng[] = {0, 170, 0, 0, 0, 0, 120, 0, 0, 0, 0, 112, 0, 115, 0, 100,
  0, 0, 0, 0, 0, 0, 0, 0, 105, 0, 0, 0, 112, 0, 115, 100, 0, 0, 140, 0, 0, 95, 0, 0, 0, 0, 112, 175, 0, 0, 0, 0, 0, 0};
 long trndrg[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0,
  0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0};
 long ttyp[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
  1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0};
 int engn[] = {0, 1, 2, 1, 0, 3, 2, 2, 1, 0, 3, 4, 1, 4, 0, 3,
  0, 3, 0, 1, 3, 1, 1, 3, 5, 5, 3, 1, 6, 6, 6, 6, 6, 8, 10, 0, 4, 11, 7, 2, 3, 4, 7, 12, 6, 6, 9, 9, 13, 13};
 long lndtyp[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
  0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 2, 0, 0, 2, 2, 1, 1, 2, 1, 0, 2, 2};
 long rev[] = {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0,
  0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
 long sktyp[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
  0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1};
 long maxt[] = {36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36,
  36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 24, 36, 36, 36, 36, 36, 18, 36, 36};
 int[] styp = {-1, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, -1, -1, -1, -1, -1,
  -1, -1, 1, -1, 0, -1, -1, 1, 1, 2, -1, -1, -1, -1, -1, -1, -1, 9, -1, 3, 4, 9, -1, 11, 5, -1, 6, -1, 9, -1, 7, 8, 10, 12};
 int[] s2typ = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
  -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2, 3, -1, -1, -1, -1, 0, -1, 3, -1, -1, 1, 0, -1};
 int extyp[] = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
  -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, -1, -1, -1, -1, -1, -1, 1, 2, -1, -1, -1, -1};
 long gny[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
  0, 0, 86, 0, 37, 0, 0, 14, 5, -9, 0, 0, 0, 0, 0, 0, 0, 50, 0, 0, 80, 0, 0, 0, 0, 0, 24, 0, 0, 0, 0, 0, 0, 0};
 long spsh[] = {2, 1, 10, 2000, 1000, 50, 2000, 0, 2000, 0, 2000};
 long s2psh[] = {100, 50, 500, 1000};
 long[] slos = {2, 1, 10, 10, 10, 2, 30, 5, 100, 1, 30, 1, 5};
 double[] s2los = {3.5, 4, 40, 100};
 long expsh[] = {500, 250, 500};
 long sdam[] = {4, 2, 9, 13, 25, 10, 25, 0, 25, 2, 25, 0};
 long s2dam[] = {10, 5, 30, 25};
 long exdam[] = {10, 10, 25};
 double spd;
 double cxz;
 double forc;
 double[] vx;
 double[] vy;
 double[] vz;
 double wzy;
 double fy;
 double nvx;
 double nvy;
 double nvz;
 double dmx;
 double dmy;
 double dmz;
 long fas;
 boolean flp;
 double txz;
 double tzy;
 double fxz;
 long pmlt;
 long nmlt;
 double aRot[];
 double stxy;
 double stzy;
 double stxz;
 double stcnt;
 boolean stnd;
 double flpcnt;
 double edgcnt;
 boolean[] tbltp;
 boolean edg;
 double pwrp;
 double xtpwr;
 double tlt;
 long prk[][];
 long lprk[][];
 long dam;
 boolean dest;
 double dcnt;
 boolean newcr;
 long clr;
 long lapn;
 int clrL;
 double pwr;
 double spdpwr;
 double lsthit[];
 int pnt;
 double kiln;
 double gx[];
 double gy[];
 double gz[];
 double gxz[];
 double gzy[];
 double gxy[];
 double gstg[];
 double gspd[];
 long ghit[];
 int ng;
 double gcnt;
 double g2x[];
 double g2y[];
 double g2z[];
 double g2xz[];
 double g2zy[];
 double g2xy[];
 double g2stg[];
 double g2spd[];
 long g2hit[];
 int ng2;
 double[] hmxz;
 double[] hmzy;
 double g2cnt;
 double[] ex;
 double[] ey;
 double[] ez;
 double[] exz;
 double[] ezy;
 double[] exy;
 double[] estg;
 double exspd[];
 long[] ehit;
 int nex;
 double yvx;
 double yvy;
 double yvz;
 boolean[] spcl;
 boolean[] ang;
 double[] wpzy;
 double[] wpxy;
 double sD_v_o;
 double[] sD_v_trj;
 long r;
 long wait;
 double vcnt;
 double fcnt;
 boolean grd;
 double crshn;
 double skdn;
 double lndn;
 double scrpn;
 int vsnd;
 long spdm;
 double scspd;

 Sound fix;
 Sound[] eng;
 Sound[] m;
 Sound[] crash;
 Sound[] crsh;
 Sound[] wst;
 Sound[] exp;
 Sound[] kilo;
 Sound[] nuk;
 Sound sp;
 Sound sp2;
 Sound[] ht;
 Sound[] hit;
 Sound[] f;
 Sound[] scr;
 Sound[] skd;
 Sound[] ch;
 Sound[] fly;
 Sound lnd;
 Sound sb;
 Sound stb;
 Sound[] trt;
 Sound[] brn;

 Play(Mdm md, Game g, int v) {
  vy = new double[4];
  vz = new double[4];
  vx = new double[4];
  pmlt = 1;
  nmlt = 1;
  aRot = new double[2];
  prk = new long[4][4];
  lprk = new long[4][4];
  tbltp = new boolean[3];
  ang = new boolean[4];
  wpzy = new double[4];
  wpxy = new double[4];
  sD_v_trj = new double[192];
  M = md;
  GM = g;
  lsthit = new double[g.nC];
  im = v;
  gx = new double[192];
  gy = new double[192];
  gz = new double[192];
  gxz = new double[192];
  gzy = new double[192];
  gxy = new double[192];
  gstg = new double[192];
  gspd = new double[192];
  ghit = new long[192];
  g2x = new double[192];
  g2y = new double[192];
  g2z = new double[192];
  g2xz = new double[192];
  g2zy = new double[192];
  g2xy = new double[192];
  g2stg = new double[192];
  g2spd = new double[192];
  g2hit = new long[192];
  hmxz = new double[192];
  hmzy = new double[192];
  ex = new double[12];
  ey = new double[12];
  ez = new double[12];
  exz = new double[12];
  ezy = new double[12];
  exy = new double[12];
  estg = new double[12];
  exspd = new double[12];
  ehit = new long[12];
  G = new Guns(md);
  G2 = new Guns2(md);
  E = new Exp(md);
  T = new Turret(md);
  eng = new Sound[5];
  m = new Sound[6];
  crsh = new Sound[3];
  crash = new Sound[3];
  ch = new Sound[5];
  fly = new Sound[2];
  kilo = new Sound[2];
  nuk = new Sound[2];
  ht = new Sound[10];
  hit = new Sound[9];
  exp = new Sound[2];
  wst = new Sound[2];
  brn = new Sound[2];
  f = new Sound[5];
  trt = new Sound[2];
  skd = new Sound[6];
  scr = new Sound[6];
  spdm = 2;
  wait = 7;
  spcl = new boolean[2];
 }

 void clx(int i, double f, Act a) {
  f *= damM[cN];
  if (Math.abs(f) > 10) {
   if (cRad[cN] > 0) {
    dam += Math.abs(f * 1.5);
    for (int c = 0; c < a.np; c++) {
     for (int c1 = 0; c1 < a.P[c].n; c1++) {
      if (a.P[c].wz == 0 && GM.x_z(a.wpx[i], a.P[c].ox[c1], a.wpz[i], a.P[c].oz[c1]) < cRad[cN]) {
       a.P[c].oz[c1] -= f * .33 * M.sin(a.xz) * M.cos(a.zy) * Math.random();
       a.P[c].ox[c1] += f * .33 * M.cos(a.xz) * M.cos(a.xy) * Math.random();
      }
     }
     if (a.P[c].chip < 1) {
      a.P[c].chip = 1;
      a.P[c].chmg = f * .1;
     }
    }
   }
   if (!GM.mutS) {
    crsh(f);
   }
  }
 }

 void cly(int i, double f, Act a) {
  f *= damM[cN];
  if (f > 10) {
   boolean b = false;
   if (Math.abs(a.zy) > 30 || Math.abs(a.xy) > 30) {
    b = true;
   }
   if (Math.abs(a.zy) > 150 && Math.abs(a.xy) > 150) {
    b = false;
   }
   if (b) {
    if (cRad[cN] > 0) {
     dam += Math.abs(f * 1.5);
     for (int c = 0; c < a.np; c++) {
      for (int c1 = 0; c1 < a.P[c].n; c1++) {
       if (a.P[c].wz == 0) {
        if (GM.x_z(a.wpx[i], a.P[c].ox[c1], a.wpz[i], a.P[c].oz[c1]) < cRad[cN]) {
         a.P[c].oz[c1] += f * .33 * M.sin(a.zy) * Math.random();
         a.P[c].ox[c1] -= f * .33 * M.sin(a.xy) * Math.random();
         if (a.P[c].oy[c1] < 0) {
          a.P[c].oy[c1] += Math.abs(f) * .33 * Math.abs(M.cos(a.xy)) * Math.abs(M.cos(a.zy)) * Math.random();
         }
        }
       }
      }
      if (a.P[c].chip < 1) {
       a.P[c].chip = 1;
       a.P[c].chmg = f * .1;
      }
     }
    }
    if (!GM.mutS) {
     crsh(f);
    }
   }
  }
 }

 void clz(int i, double f, Act a) {
  f *= damM[cN];
  if (Math.abs(f) > 10) {
   if (cRad[cN] > 0) {
    dam += Math.abs(f * 1.5);
    for (int c = 0; c < a.np; c++) {
     for (int c1 = 0; c1 < a.P[c].n; c1++) {
      if (a.P[c].wz == 0 && GM.x_z(a.wpx[i], a.P[c].ox[c1], a.wpz[i], a.P[c].oz[c1]) < cRad[cN]) {
       a.P[c].oz[c1] += f * .33 * M.cos(a.xz) * M.cos(a.zy) * Math.random();
       a.P[c].ox[c1] += f * .33 * M.sin(a.xz) * M.cos(a.xy) * Math.random();
      }
     }
     if (a.P[c].chip < 1) {
      a.P[c].chip = 1;
      a.P[c].chmg = f * .1;
     }
    }
   }
   if (!GM.mutS) {
    crsh(f);
   }
  }
 }

 void rot(double a[], double b[], double c, double d, double e) {
  if (e != 0) {
   for (int i = 0; i < 4; i++) {
    double g = a[i];
    double h = b[i];
    a[i] = c + ((g - c) * M.cos(e) - (h - d) * M.sin(e));
    b[i] = d + ((g - c) * M.sin(e) + (h - d) * M.cos(e));
   }
  }
 }

 void hit(Act a, Play op, Act a1, Dir dr) {
  int c;
  if (!((GM.cNm[cN] == "The Phantom" && spcl[0]) || (GM.cNm[op.cN] == "The Phantom" && op.spcl[0]))) {
   sD_v_o = Math.sqrt(Math.sqrt(GM.x_y_z(GM.opx[im] * .01, (M.x + M.cx) * .01, GM.opy[im] * .01, (M.y + M.cy) * .01, GM.opz[im] * .01, (M.z + M.cz) * .01)));
   int c1;
   int c2;
   int c3;
   double[] ux = new double[4];
   double[] uy = new double[4];
   double[] uz = new double[4];
   double[] tx = new double[4];
   double[] ty = new double[4];
   double[] tz = new double[4];
   for (c = 0; c < 4; c++) {
    ux[c] = a.x + a.wpx[c];
    if (flp) {
     uy[c] = a.y - flpy[cN];
    } else {
     uy[c] = a.y + a.wG;
    }
    uz[c] = a.z + a.wpz[c];
    tx[c] = a1.x + a1.wpx[c];
    if (flp) {
     ty[c] = a1.y - op.flpy[op.cN];
    } else {
     ty[c] = a1.y + a1.wG;
    }
    tz[c] = a1.z + a1.wpz[c];
   }
   rot(ux, uy, a.x, a.y, a.xy);
   rot(uy, uz, a.y, a.z, a.zy);
   rot(ux, uz, a.x, a.z, a.xz);
   rot(tx, ty, a1.x, a1.y, a1.xy);
   rot(ty, tz, a1.y, a1.z, a1.zy);
   rot(tx, tz, a1.x, a1.z, a1.xz);
   for (c = 0; c < 4; c++) {
    for (c1 = 0; c1 < 4; c1++) {
     dmx = 0;
     dmz = 0;
     dmy = 0;
     if (dam <= dura[cN]) {
      dmx = (vx[c] - op.vx[c1]) * pwr * .00075;
      dmz = (vz[c] - op.vz[c1]) * pwr * .00075;
      dmy = (vy[c] - op.vy[c1]) * pwr * .00075;
     }
     if (GM.x_y_z(ux[c] * .01, tx[c1] * .01, uy[c] * .01, ty[c1] * .01, uz[c] * .01, tz[c1] * .01) < hitr[cN] + hitr[op.cN] && lifu[cN] > 0 && a.y < a1.y) {
      vy[c] -= M.grv[GM.stg] * 1.5 * GM.zz;
     }
     if (GM.x_y_z(ux[c], tx[c1], uy[c], ty[c1], uz[c], tz[c1]) < (Math.sqrt(Math.pow(vx[c], 2) + Math.pow(vy[c], 2) + Math.pow(vz[c], 2)) + Math.sqrt(Math.pow(op.vx[c1], 2) + Math.pow(op.vy[c1], 2) + Math.pow(op.vz[c1], 2))) * 100 * (hitr[cN] + hitr[op.cN])) {
      double pxt = 0;
      if (op.dam <= op.dura[op.cN]) {
       pxt = pshu[cN] * op.vx[c1] * .0025 * op.pwr;
      }
      double pxu = 0;
      if (dam <= dura[cN]) {
       pxu = psht[cN] * vx[c] * .0025 * pwr;
      }
      op.vx[c1] += pxu;
      op.clx(c1, dmx * DD[cN], a1);
      vx[c] -= pxt;
      clx(c, -op.dmx * op.DD[op.cN], a);
      double pzt = 0;
      if (op.dam <= op.dura[op.cN]) {
       pzt = pshu[cN] * op.vz[c1] * .0025 * op.pwr;
      }
      double pzu = 0;
      if (dam <= dura[cN]) {
       pzu = psht[cN] * vz[c] * .0025 * pwr;
      }
      op.vz[c1] += pzu;
      op.clz(c1, dmz * DD[cN], a1);
      vz[c] -= pzt;
      clz(c, -op.dmz * op.DD[op.cN], a);
      if (a.y < a1.y) {
       vy[c] -= lifu[cN] * .0025 * Math.sqrt(Math.pow(nvx, 2) + Math.pow(nvz, 2));
      }
      if (a.y > a1.y) {
       vy[c] += lifu[cN] * .0025 * Math.sqrt(Math.pow(nvx, 2) + Math.pow(nvz, 2));
      }
      op.cly(c1, dmy * DD[cN], a1);
      cly(c, -op.dmy * op.DD[op.cN], a);
      if (!GM.mutS && vy[c] < -100) {
       lnd(a);
      }
      if (GM.cNm[op.cN] != "KILL-O-MATIC" && GM.cNm[op.cN] != "Everlast-177" && GM.cNm[op.cN] != "TRAIN of TERROR" && typ[cN] != 2) {
       if (a1.y < a.y) {
        op.vy[c1] -= lift[cN];
       }
       if (a1.y > a.y) {
        op.vy[c1] += lift[cN];
       }
      }
      if (!op.dest) {
       op.lsthit[op.im] = 8;
      }
      if (!dest) {
       lsthit[im] = 8;
      }
      if (GM.cNm[cN] == "Tactical Nuke" && !dest && !op.dest) {
       dam += 100000;
       op.dam += 100000;
      }
      if (GM.cNm[cN] == "KILL-O-MATIC" && !dest && kiln <= 0 && (dr.up || dr.down)) {
       op.dam += 100000;
       if (!GM.mutS) {
        kilo[(int) (Math.random() * 2)].ply(sD_v_o);
       }
       kiln = Math.random() * 5;
       for (c2 = 0; c2 < a1.np; c2++) {
        for (c3 = 0; c3 < a1.P[c2].n; c3++) {
         if (a1.P[c2].wz == 0) {
          a1.P[c2].oz[c3] += (Math.random() * 20) - (Math.random() * 20);
          a1.P[c2].ox[c3] += (Math.random() * 20) - (Math.random() * 20);
          a1.P[c2].oy[c3] += (Math.random() * 20) - (Math.random() * 20);
         }
         if (a1.P[c2].chip < 1) {
          a1.P[c2].chip = 1;
          a1.P[c2].chmg = (Math.random() * 3) - (Math.random() * 3);
         }
        }
       }
      }
     }
    }
   }
   G2.rads[2] = Math.min((Math.abs(op.nvx) + Math.abs(op.nvy) + Math.abs(op.nvz)) * .05, 20);
   for (c = 0; c < 192; c++) {
    if (styp[cN] > -1 && gstg[c] > 0 && ghit[c] < 1) {
     sD_v_trj[c] = Math.sqrt(Math.sqrt(GM.x_y_z(gx[c] * .01, (M.x + M.cx) * .01, gy[c] * .01, (M.y + M.cy) * .01, gz[c] * .01, (M.z + M.cz) * .01)));
     if (GM.x_y_z(gx[c], a1.x, gy[c], a1.y, gz[c], a1.z) < a1.htR * a1.htR * 3 * G.rads[styp[cN]]) {
      if ((styp[cN] < 6 || styp[cN] == 9) && styp[cN] != 3) {
       ghit[c] = 1;
      }
      op.dam += G.dam[styp[cN]];
      if (!op.dest) {
       op.lsthit[op.im] = 8;
      }
      if (!dest) {
       lsthit[im] = 8;
      }
      for (c1 = 0; c1 < 4; c1++) {
       op.vx[c1] += (Math.random() * spsh[styp[cN]]) - (Math.random() * spsh[styp[cN]]);
       op.vz[c1] += (Math.random() * spsh[styp[cN]]) - (Math.random() * spsh[styp[cN]]);
       if ((styp[cN] == 3 || styp[cN] == 4) && GM.cNm[op.cN] != "EPIC TANK" && GM.cNm[op.cN] != "KILL-O-MATIC" && GM.cNm[op.cN] != "Everlast-177" && GM.cNm[op.cN] != "TRAIN of TERROR" && op.cN < 46) {
        op.vy[c1] += (Math.random() * spsh[styp[cN]]) - (Math.random() * spsh[styp[cN]]);
       }
      }
      for (c1 = 0; c1 < a1.np; c1++) {
       for (c2 = 0; c2 < a1.P[c1].n; c2++) {
        if (a1.P[c1].wz == 0 && GM.cNm[op.cN] != "Gun Turret") {
         a1.P[c1].oz[c2] += (Math.random() * sdam[styp[cN]]) - (Math.random() * sdam[styp[cN]]);
         a1.P[c1].ox[c2] += (Math.random() * sdam[styp[cN]]) - (Math.random() * sdam[styp[cN]]);
         a1.P[c1].oy[c2] += (Math.random() * sdam[styp[cN]] * .5) - (Math.random() * sdam[styp[cN]] * .5);
        }
        if (a1.P[c1].chip < 1 && styp[cN] < 11) {
         a1.P[c1].chip = 1;
         a1.P[c1].chmg = (Math.random() * 3) - (Math.random() * 3);
        }
       }
      }
      if (!GM.mutS) {
       if (styp[cN] < 3 || styp[cN] == 5 || styp[cN] == 7 || styp[cN] == 9) {
        ht[(int) (Math.random() * 10)].ply(sD_v_trj[c]);
       }
       if (styp[cN] == 5) {
        ht[(int) (Math.random() * 5)].ply(sD_v_trj[c]);
       }
       if (styp[cN] == 4 || styp[cN] == 6 || styp[cN] == 8 || styp[cN] == 10) {
        hit[(int) (Math.random() * 8)].ply(sD_v_trj[c]);
       }
       if (styp[cN] == 3) {
        crash[(int) (Math.random() * 3)].ply(sD_v_o);
        crsh[(int) (Math.random() * 3)].ply(sD_v_o);
        crash[(int) (Math.random() * 3)].ply(sD_v_o);
        crsh[(int) (Math.random() * 3)].ply(sD_v_o);
       }
      }
     }
    }
    if (s2typ[cN] > -1 && g2stg[c] > 0 && g2hit[c] < 1) {
     sD_v_trj[c] = Math.sqrt(Math.sqrt(GM.x_y_z(g2x[c] * .01, (M.x + M.cx) * .01, g2y[c] * .01, (M.y + M.cy) * .01, g2z[c] * .01, (M.z + M.cz) * .01)));
     if (GM.x_y_z(g2x[c], a1.x, g2y[c], a1.y, g2z[c], a1.z) < 3 * a1.htR * a1.htR * G2.rads[s2typ[cN]] && (s2typ[cN] != 2 || op.dam <= op.dura[op.cN])) {
      if (s2typ[cN] > 0) {
       g2hit[c] = 1;
      }
      op.dam += G2.dam[s2typ[cN]];
      if (!op.dest) {
       op.lsthit[op.im] = 8;
      }
      if (!dest) {
       lsthit[im] = 8;
      }
      for (c1 = 0; c1 < 4; c1++) {
       op.vx[c1] += (Math.random() * s2psh[s2typ[cN]]) - (Math.random() * s2psh[s2typ[cN]]);
       op.vz[c1] += (Math.random() * s2psh[s2typ[cN]]) - (Math.random() * s2psh[s2typ[cN]]);
      }
      if (s2typ[cN] == 2 && GM.cNm[op.cN] != "EPIC TANK" && GM.cNm[op.cN] != "KILL-O-MATIC" && GM.cNm[op.cN] != "Everlast-177" && GM.cNm[op.cN] != "TRAIN of TERROR" && op.cN < 46) {
       op.vx[(int) (Math.random()) * 4] += (Math.random() * s2psh[s2typ[cN]]) - (Math.random() * s2psh[s2typ[cN]]);
       op.vy[(int) (Math.random()) * 4] += (Math.random() * s2psh[s2typ[cN]]) - (Math.random() * s2psh[s2typ[cN]]);
       op.vz[(int) (Math.random()) * 4] += (Math.random() * s2psh[s2typ[cN]]) - (Math.random() * s2psh[s2typ[cN]]);
      }
      for (c1 = 0; c1 < a1.np; c1++) {
       for (c2 = 0; c2 < a1.P[c1].n; c2++) {
        if (a1.P[c1].wz == 0 && GM.cNm[op.cN] != "Gun Turret") {
         a1.P[c1].oz[c2] += (Math.random() * s2dam[s2typ[cN]]) - (Math.random() * s2dam[s2typ[cN]]);
         a1.P[c1].ox[c2] += (Math.random() * s2dam[s2typ[cN]]) - (Math.random() * s2dam[s2typ[cN]]);
         a1.P[c1].oy[c2] += (Math.random() * s2dam[s2typ[cN]] * .5) - (Math.random() * s2dam[s2typ[cN]] * .5);
        }
        if (a1.P[c1].chip < 1) {
         a1.P[c1].chip = 1;
         a1.P[c1].chmg = (Math.random() * 3) - (Math.random() * 3);
        }
       }
      }
      if (!GM.mutS) {
       if (s2typ[cN] > 1) {
        hit[(int) (Math.random() * 8)].ply(sD_v_trj[c]);
       } else {
        ht[(int) (Math.random() * 10)].ply(sD_v_trj[c]);
        ht[(int) (Math.random() * 5)].ply(sD_v_trj[c]);
       }
       if (s2typ[cN] == 2) {
        hit[8].ply(sD_v_trj[c]);
       }
      }
     }
    }
    if (styp[cN] == 2) {
     if (GM.opx[dr.vic] < gx[c]) {
      hmxz[c] = 90 + Math.atan((GM.opz[dr.vic] - gz[c]) / (GM.opx[dr.vic] - gx[c])) * 57.295779513082320876798154814105;
     }
     if (GM.opx[dr.vic] > gx[c]) {
      hmxz[c] = -90 + Math.atan((GM.opz[dr.vic] - gz[c]) / (GM.opx[dr.vic] - gx[c])) * 57.295779513082320876798154814105;
     }
     while (true) {
      if (Math.abs(gxz[c] - hmxz[c]) <= 180) {
       break;
      }
      if (hmxz[c] > gxz[c]) {
       hmxz[c] -= 360;
      } else if (hmxz[c] < gxz[c]) {
       hmxz[c] += 360;
      }
     }
     if (gxz[c] > hmxz[c]) {
      gxz[c] -= Math.abs(hmxz[c] - gxz[c]) * .25;
     }
     if (gxz[c] < hmxz[c]) {
      gxz[c] += Math.abs(hmxz[c] - gxz[c]) * .25;
     }
     double d = Math.sqrt(Math.pow(GM.opz[dr.vic] - gz[c], 2) + Math.pow(GM.opx[dr.vic] - gx[c], 2));
     if (GM.opy[dr.vic] < gy[c]) {
      hmzy[c] = -(-90 - Math.atan(d / (GM.opy[dr.vic] - gy[c])) * 57.295779513082320876798154814105);
     }
     if (GM.opy[dr.vic] > gy[c]) {
      hmzy[c] = -(90 - Math.atan(d / (GM.opy[dr.vic] - gy[c])) * 57.295779513082320876798154814105);
     }
     if (hmzy[c] > gzy[c] || gy[c] > 250 - a.wG) {
      gzy[c] += Math.abs(hmzy[c] - gzy[c]) * .25;
     } else if (hmzy[c] < gzy[c]) {
      gzy[c] -= Math.abs(hmzy[c] - gzy[c]) * .25;
     }
    }
    if (s2typ[cN] == 3) {
     if (GM.opx[dr.vic] < g2x[c]) {
      hmxz[c] = 90 + Math.atan((GM.opz[dr.vic] - g2z[c]) / (GM.opx[dr.vic] - g2x[c])) * 57.295779513082320876798154814105;
     }
     if (GM.opx[dr.vic] > g2x[c]) {
      hmxz[c] = -90 + Math.atan((GM.opz[dr.vic] - g2z[c]) / (GM.opx[dr.vic] - g2x[c])) * 57.295779513082320876798154814105;
     }
     while (true) {
      if (Math.abs(g2xz[c] - hmxz[c]) <= 180) {
       break;
      }
      if (hmxz[c] > g2xz[c]) {
       hmxz[c] -= 360;
      } else if (hmxz[c] < g2xz[c]) {
       hmxz[c] += 360;
      }
     }
     if (g2xz[c] > hmxz[c]) {
      g2xz[c] -= 3 * GM.zz;
     }
     if (g2xz[c] < hmxz[c]) {
      g2xz[c] += 3 * GM.zz;
     }
     double d = Math.sqrt(Math.pow(GM.opz[dr.vic] - g2z[c], 2) + Math.pow(GM.opx[dr.vic] - g2x[c], 2));
     if (GM.opy[dr.vic] < g2y[c]) {
      hmzy[c] = -(-90 - Math.atan(d / (GM.opy[dr.vic] - g2y[c])) * 57.295779513082320876798154814105);
     }
     if (GM.opy[dr.vic] > g2y[c]) {
      hmzy[c] = -(90 - Math.atan(d / (GM.opy[dr.vic] - g2y[c])) * 57.295779513082320876798154814105);
     }
     if (hmzy[c] > g2zy[c] || g2y[c] > 250 - a.wG) {
      g2zy[c] += 3 * GM.zz;
     } else if (hmzy[c] < g2zy[c]) {
      g2zy[c] -= 3 * GM.zz;
     }
    }
   }
   E.rads[2] = (long) (Math.random() * 700);
   E.dam[2] = (long) (2500 + (Math.random() * 5000));
   for (c = 0; c < 12; c++) {
    if (extyp[cN] > -1 && estg[c] > 0 && ehit[c] < 1) {
     {
      if (GM.x_y_z(ex[c], a1.x, ey[c], a1.y, ez[c], a1.z) < 3 * a1.htR * a1.htR * E.rads[extyp[cN]]) {
       op.dam += E.dam[extyp[cN]];
       if (!op.dest) {
        op.lsthit[op.im] = 8;
       }
       if (!dest) {
        lsthit[im] = 8;
       }
       for (c1 = 0; c1 < 4; c1++) {
        op.vx[c1] += (Math.random() * expsh[extyp[cN]]) - (Math.random() * expsh[extyp[cN]]);
        op.vz[c1] += (Math.random() * expsh[extyp[cN]]) - (Math.random() * expsh[extyp[cN]]);
        if (GM.cNm[op.cN] != "EPIC TANK" && GM.cNm[op.cN] != "KILL-O-MATIC" && GM.cNm[op.cN] != "Everlast-177" && GM.cNm[op.cN] != "TRAIN of TERROR" && op.cN < 46) {
         op.vy[c1] += (Math.random() * expsh[extyp[cN]]) - (Math.random() * expsh[extyp[cN]]);
        }
       }
       for (c1 = 0; c1 < a1.np; c1++) {
        for (c2 = 0; c2 < a1.P[c1].n; c2++) {
         if (a1.P[c1].wz == 0 && GM.cNm[op.cN] != "Gun Turret") {
          a1.P[c1].oz[c2] += (Math.random() * exdam[extyp[cN]]) - (Math.random() * exdam[extyp[cN]]);
          a1.P[c1].ox[c2] += (Math.random() * exdam[extyp[cN]]) - (Math.random() * exdam[extyp[cN]]);
          a1.P[c1].oy[c2] += (Math.random() * exdam[extyp[cN]] * .5) - (Math.random() * exdam[extyp[cN]] * .5);
         }
         if (a1.P[c1].chip < 1) {
          a1.P[c1].chip = 1;
          a1.P[c1].chmg = (Math.random() * 3) - (Math.random() * 3);
         }
        }
       }
       if (!GM.mutS && extyp[cN] == 2) {
        hit[(int) (Math.random() * 8)].ply(sD_v_o);
       }
      }
     }
    }
   }
   if (typ[cN] == 2) {
    if (GM.x_y_z(a.x, a1.x, 128 + a.y, a1.y, a.z, a1.z) < 2 * a1.htR * a1.htR) {
     if (cRad[cN] > 0) {
      op.dam += 150;
     }
     if (!op.dest) {
      op.lsthit[op.im] = 8;
     }
     if (!dest) {
      lsthit[im] = 8;
     }
     for (c = 0; c < 4; c++) {
      op.vx[c] *= -1;
      op.vz[c] *= -1;
      op.vy[c] *= -1;
      op.vx[c] += (Math.random() * 500) - (Math.random() * 500);
      op.vz[c] += (Math.random() * 500) - (Math.random() * 500);
      op.vy[c] += (Math.random() * 100) - (Math.random() * 100);
     }
     for (c = 0; c < a1.np; c++) {
      for (c1 = 0; c1 < a1.P[c].n; c1++) {
       if (a1.P[c].wz == 0 && GM.cNm[op.cN] != "KILL-O-MATIC" && GM.cNm[op.cN] != "Gun Turret") {
        a1.P[c].oz[c1] += (Math.random() * 10) - (Math.random() * 10);
        a1.P[c].ox[c1] += (Math.random() * 10) - (Math.random() * 10);
        a1.P[c].oy[c1] += (Math.random() * 10) - (Math.random() * 10);
       }
       if (a1.P[c].chip < 1) {
        a1.P[c].chip = 1;
        a1.P[c].chmg = (Math.random() * 3) - (Math.random() * 3);
       }
      }
     }
     if (!GM.mutS) {
      crash[(int) (Math.random() * 3)].ply(sD_v_o);
      crash[(int) (Math.random() * 3)].ply(sD_v_o);
      crash[(int) (Math.random() * 3)].ply(sD_v_o);
     }
    }
   }
   if (GM.cNm[cN] == "YottaVolt Particle Disintegrator") {
    yvx = Double.MAX_VALUE * M.sin(-a.xz) * M.cos(-a.zy);
    yvy = Double.MAX_VALUE * M.sin(-a.zy);
    yvz = Double.MAX_VALUE * M.cos(a.xz) * M.cos(-a.zy);
    if (!dest && spcl[0] && !M.nofpwr && ((a1.y <= a.y && a1.y >= yvy) || (a1.y >= a.y && a1.y <= yvy)) && ((a1.x <= a.x && a1.x >= yvx) || (a1.x >= a.x && a1.x <= yvx)) && ((a1.z <= a.z && a1.z >= yvz) || (a1.z >= a.z && a1.z <= yvz))) {
     if (!op.dest) {
      op.lsthit[op.im] = 8;
     }
     if (!dest) {
      lsthit[im] = 8;
     }
     op.dam += 100;
    }
   }
   if (dest) {
    if (GM.dtyp[im] < 1) {
     if (lsthit[im] <= 0) {
      GM.dtyp[im] = 1;
     }
     if (lsthit[im] > 0 && op.lsthit[op.im] > 0) {
      GM.dtyp[im] = 2;
     }
    }
   } else if (GM.dtyp[im] != 0) {
    GM.dtyp[im] = 0;
   }
   for (c = 0; c < GM.nC; c++) {
    if (GM.sdtyp[c] != GM.dtyp[c]) {
     GM.sdtyp[c] = GM.dtyp[c];
     if (GM.sdtyp[c] < 1) {
      GM.wasay = true;
      if (c == GM.im) {
       GM.say = "You have been resurrected!";
      } else {
       GM.say = GM.cNm[GM.C[c]] + " has been resurrected!";
      }
      GM.tcnt = -15;
     }
     if (GM.sdtyp[c] == 1 && c != GM.im) {
      GM.wasay = true;
      GM.say = GM.cNm[GM.C[c]] + " has been destroyed!";
      GM.tcnt = -15;
     }
     if (GM.sdtyp[c] > 1) {
      GM.wasay = true;
      if (op.im == GM.im) {
       GM.say = "You destroyed " + GM.cNm[GM.C[c]] + "!";
      } else {
       GM.say = "" + GM.cNm[op.cN] + " has destroyed " + GM.cNm[GM.C[c]] + "!";
      }
      GM.tcnt = -15;
     }
    }
   }
  }
 }

 void reset(long c, Act a) {
  int n;
  cN = (int) c;
  for (n = 0; n < GM.nC; n++) {
   lsthit[n] = 0;
  }
  cxz = 0;
  if (GM.stg == 19 || GM.stg == 21 || GM.stg == 27 || GM.stg == 40 || GM.stg == 45 || GM.stg == 48 || GM.stg == 53 || GM.stg == 55 || GM.stg == 57 || GM.stg == 60 || GM.stg == 65 || GM.stg == 69 || GM.stg == 71) {
   a.xz = (Math.random() * 180) - (Math.random() * 180);
   cxz = a.xz;
  }
  spd = 0;
  for (n = 0; n < 4; n++) {
   vy[n] = 0;
   vx[n] = 0;
   vz[n] = 0;
   wpxy[n] = 0;
   wpzy[n] = 0;
  }
  nvx = 0;
  nvy = 0;
  nvz = 0;
  forc = (Math.sqrt(Math.pow(a.wpz[0], 2) + Math.pow(a.wpx[0], 2)) + Math.sqrt(Math.pow(a.wpz[1], 2) + Math.pow(a.wpx[1], 2)) + Math.sqrt(Math.pow(a.wpz[2], 2) + Math.pow(a.wpx[2], 2)) + Math.sqrt(Math.pow(a.wpz[3], 2) + Math.pow(a.wpx[3], 2))) * spn[cN] * bonc[cN];
  fas = 0;
  txz = 0;
  fxz = 0;
  pmlt = 1;
  nmlt = 1;
  aRot[0] = 0;
  aRot[1] = 0;
  stxy = 0;
  stzy = 0;
  stxz = 0;
  for (n = 0; n < 3; n++) {
   tbltp[n] = false;
  }
  pwrp = 0;
  xtpwr = 0;
  stcnt = 0;
  flpcnt = 0;
  tlt = 0;
  for (n = 0; n < 4; n++) {
   prk[n][n] = 0;
   lprk[n][n] = 0;
  }
  clr = 0;
  lapn = 0;
  clrL = 0;
  pwr = 0;
  GM.dtyp[im] = 0;
  dam = 0;
  dest = false;
  dcnt = 0;
  newcr = false;
  for (n = 0; n < 192; n++) {
   gstg[n] = 0;
   ghit[n] = 0;
   g2stg[n] = 0;
   g2hit[n] = 0;
   hmxz[n] = 0;
   hmzy[n] = 0;
   sD_v_trj[n] = 0;
  }
  for (n = 0; n < 12; n++) {
   estg[n] = 0;
   ehit[n] = 0;
  }
  a.smka = 0;
  M.cp = -1;
  M.fchk = false;
  pnt = 0;
  wait = 7;
  gcnt = 0;
  grd = true;
  spdm = 0;
  scspd = 0;
  gts();
 }

 void act(Dir dr, Act a, Track t) {
  sD_v_o = Math.sqrt(Math.sqrt(GM.x_y_z(GM.opx[im] * .01, (M.x + M.cx) * .01, GM.opy[im] * .01, (M.y + M.cy) * .01, GM.opz[im] * .01, (M.z + M.cz) * .01)));
  int c;
  int b;
  if (kiln > 0) {
   kiln -= GM.zz;
  }
  if (lsthit[im] > 0) {
   lsthit[im] -= GM.zz;
  }
  nvx = (vx[0] + vx[1] + vx[2] + vx[3]) * .25;
  nvy = (vy[0] + vy[1] + vy[2] + vy[3]) * .25;
  nvz = (vz[0] + vz[1] + vz[2] + vz[3]) * .25;
  if (Math.abs(a.zy) > 90) {
   if (r > -1) {
    r = -1;
   }
  } else if (r < 1) {
   r = 1;
  }
  if ((Math.abs(a.xy) > 90 && Math.abs(a.zy) <= 90) || (Math.abs(a.zy) > 90 && Math.abs(a.xy) <= 90)) {
   if (!flp) {
    flp = true;
   }
  } else if (flp) {
   flp = false;
  }
  double h = a.wG;
  if (flp) {
   h = -flpy[cN];
  }
  if (fas == 0) {
   if (aRot[0] != 0) {
    aRot[0] = 0;
   }
   if (aRot[1] != 0) {
    aRot[1] = 0;
   }
  }
  if (typ[cN] != 2 && dr.spac && !dest) {
   if (fas < 0) {
    fas = typ[cN] + 1;
   }
   if (typ[cN] == 1 && (fas == 0 && dr.down)) {
    a.y -= 10;
    fas = 2;
   }
  }
  if (!dest) {
   if (fas == 1) {
    for (c = 0; c < 4; c++) {
     vy[c] = nvy;
    }
    if (dr.up) {
     if (ars[cN] < Double.POSITIVE_INFINITY) {
      aRot[0] -= .1 * ars[cN] * GM.zz;
     }
     if (aRot[0] < -1 || ars[cN] == Double.POSITIVE_INFINITY) {
      aRot[0] = -1;
     }
    }
    if (dr.down) {
     if (ars[cN] < Double.POSITIVE_INFINITY) {
      aRot[0] += .1 * ars[cN] * GM.zz;
     }
     if (aRot[0] > 1 || ars[cN] == Double.POSITIVE_INFINITY) {
      aRot[0] = 1;
     }
    }
    if (!(dr.up || dr.down)) {
     if (ars[cN] < Double.POSITIVE_INFINITY) {
      if (aRot[0] > 0) {
       aRot[0] -= .1 * ars[cN] * GM.zz;
      }
      if (aRot[0] < 0) {
       aRot[0] += .1 * ars[cN] * GM.zz;
      }
     }
     if (Math.abs(aRot[0]) < .1 * ars[cN] || ars[cN] == Double.POSITIVE_INFINITY) {
      aRot[0] = 0;
     }
    }
    if (aRot[0] < 0) {
     if (Math.abs(a.xy) > 90) {
      a.x -= -arc[cN] * M.sin(a.xz) * -aRot[0] * GM.zz;
      a.z -= arc[cN] * M.cos(a.xz) * -aRot[0] * GM.zz;
     } else {
      a.x += -arc[cN] * M.sin(a.xz) * -aRot[0] * GM.zz;
      a.z += arc[cN] * M.cos(a.xz) * -aRot[0] * GM.zz;
     }
    }
    if (aRot[0] > 0) {
     a.y -= arc[cN] * aRot[0] * GM.zz;
    }
    if (dr.left && !dr.riht) {
     if (aRot[1] == 0 && GM.cNm[cN] != "OW SLAMINARO" && GM.cNm[cN] != "Lightning Rod" && GM.cNm[cN] != "EPIC TANK" && GM.cNm[cN] != "KILL-O-MATIC" && GM.cNm[cN] != "Everlast-177" && GM.cNm[cN] != "TRAIN of TERROR") {
      aRot[1] -= .25 * GM.zz;
     }
     if (ars[cN] < Double.POSITIVE_INFINITY) {
      aRot[1] -= .1 * ars[cN] * GM.zz;
     }
     if (aRot[1] < -1 || ars[cN] == Double.POSITIVE_INFINITY) {
      aRot[1] = -1;
     }
    }
    if (dr.riht && !dr.left) {
     if (aRot[1] == 0 && GM.cNm[cN] != "OW SLAMINARO" && GM.cNm[cN] != "Lightning Rod" && GM.cNm[cN] != "EPIC TANK" && GM.cNm[cN] != "KILL-O-MATIC" && GM.cNm[cN] != "Everlast-177" && GM.cNm[cN] != "TRAIN of TERROR") {
      aRot[1] += .25 * GM.zz;
     }
     if (ars[cN] < Double.POSITIVE_INFINITY) {
      aRot[1] += .1 * ars[cN] * GM.zz;
     }
     if (aRot[1] > 1 || ars[cN] == Double.POSITIVE_INFINITY) {
      aRot[1] = 1;
     }
    }
    if (!(dr.left || dr.riht)) {
     if (ars[cN] < Double.POSITIVE_INFINITY) {
      if (aRot[1] > 0) {
       aRot[1] -= .1 * ars[cN] * GM.zz;
      }
      if (aRot[1] < 0) {
       aRot[1] += .1 * ars[cN] * GM.zz;
      }
     }
     if (Math.abs(aRot[1]) < .1 * ars[cN] || ars[cN] == Double.POSITIVE_INFINITY) {
      aRot[1] = 0;
     }
    }
    if (GM.cNm[cN] != "Lightning Rod") {
     a.zy += 20 * aRot[0] * M.cos(a.xy) * GM.zz;
     if (Math.abs(a.zy) > 90) {
      a.xz += 20 * aRot[0] * M.sin(a.xy) * GM.zz;
     } else {
      a.xz -= 20 * aRot[0] * M.sin(a.xy) * GM.zz;
     }
     a.xy += 20 * aRot[1] * GM.zz;
    }
    a.x += arc[cN] * M.cos(a.xz) * r * aRot[1] * GM.zz;
    a.z += arc[cN] * M.sin(a.xz) * r * aRot[1] * GM.zz;
   } else {
    spdpwr = pwr;
    if (spdpwr < 40) {
     spdpwr = 40;
    }
    if (dr.down && fas != 2 && spd > -spds[cN][1]) {
     if (spd > 0) {
      spd -= brak[cN] * .5 * GM.zz;
     } else {
      int d = 0;
      for (int d0 = 0; d0 < 2; d0++) {
       if (spd <= -((spds[cN][d0] * .5) + (spdpwr * spds[cN][d0]) * .005)) {
        d++;
       }
      }
      if (d != 2) {
       spd -= (acel[cN][d] * .5 + (spdpwr * acel[cN][d]) * .005) * GM.zz;
      }
     }
    }
    if (dr.up && fas != 2 && spd < spds[cN][2]) {
     if (spd < 0) {
      spd += brak[cN] * GM.zz;
     } else {
      int u = 0;
      for (int u0 = 0; u0 < 3; u0++) {
       if (spd >= (spds[cN][u0] * .5) + (spdpwr * spds[cN][u0]) * .005) {
        u++;
       }
      }
      if (u != 3) {
       spd += (acel[cN][u] * .5 + (spdpwr * acel[cN][u]) * .005) * GM.zz;
      }
     }
    }
    if (dr.spac && fas != 2 && spd != 0) {
     if (spd < 0) {
      spd += brak[cN] * GM.zz;
     }
     if (spd > 0) {
      spd -= brak[cN] * GM.zz;
     }
     if (spd < brak[cN] * GM.zz && spd > -brak[cN] * GM.zz) {
      spd = 0;
     }
    }
   }
  }
  double ws = 40 * Math.sqrt(Math.abs(spd * (spd / .75))) / (154 * siz[cN]);
  double wt = 100 * a.wxz / (154 * siz[cN]);
  if (ws > 44 / GM.zz) {
   ws = 44 / GM.zz;
  }
  if (ws < -44 / GM.zz) {
   ws = -44 / GM.zz;
  }
  if (typ[cN] != 2) {
   if (spd < 0) {
    a.wrot[0] += ws * GM.zz;
    a.wrot[1] += ws * GM.zz;
    if (ttyp[cN] == 0) {
     a.wrot[0] += wt * GM.zz;
     a.wrot[1] -= wt * GM.zz;
    }
   } else {
    a.wrot[0] -= ws * GM.zz;
    a.wrot[1] -= ws * GM.zz;
    if (ttyp[cN] == 0) {
     a.wrot[0] -= wt * GM.zz;
     a.wrot[1] += wt * GM.zz;
    }
   }
   if (Math.abs(a.wrot[0]) > 60) {
    a.wrot[0] = 0;
   }
   if (Math.abs(a.wrot[1]) > 60) {
    a.wrot[1] = 0;
   }
  }
  double rt = 0;
  if (GM.cNm[cN] == "The Awesome Radical One") {
   rt = Math.random() * 5;
  }
  if (GM.cNm[cN] == "A-1") {
   rt = Math.random() * 10;
  }
  if (dr.riht && !dr.left) {
   a.wxz -= trn[cN] * GM.zz;
   if (a.wxz < -maxt[cN] - rt || trn[cN] == 0) {
    a.wxz = -maxt[cN] - rt;
   }
   if (a.wxz > 0) {
    a.wxz -= trn[cN] * GM.zz;
   }
  }
  if (dr.left && !dr.riht) {
   a.wxz += trn[cN] * GM.zz;
   if (a.wxz > maxt[cN] + rt || trn[cN] == 0) {
    a.wxz = maxt[cN] + rt;
   }
   if (a.wxz < 0) {
    a.wxz += trn[cN] * GM.zz;
   }
  }
  if (a.wxz != 0 && !(dr.left || dr.riht)) {
   if (Math.abs(a.wxz) < trn[cN] * 2 * GM.zz || trn[cN] == 0) {
    a.wxz = 0;
   }
   if (a.wxz > 0) {
    a.wxz -= trn[cN] * 2 * GM.zz;
   }
   if (a.wxz < 0) {
    a.wxz += trn[cN] * 2 * GM.zz;
   }
  }
  if (fas == 2 || typ[cN] == 2) {
   if (dr.up) {
    wzy -= trn[cN] * GM.zz;
    if (wzy < -maxt[cN] || trn[cN] == 0) {
     wzy = -maxt[cN];
    }
    if (wzy > 0) {
     wzy -= trn[cN] * GM.zz;
    }
   }
   if (dr.down) {
    wzy += trn[cN] * GM.zz;
    if (wzy > maxt[cN] || trn[cN] == 0) {
     wzy = maxt[cN];
    }
    if (wzy < 0) {
     wzy += trn[cN] * GM.zz;
    }
   }
   if (wzy != 0 && !(dr.up || dr.down)) {
    if (Math.abs(wzy) < trn[cN] * 2 * GM.zz || trn[cN] == 0) {
     wzy = 0;
    }
    if (wzy > 0) {
     wzy -= trn[cN] * 2 * GM.zz;
    }
    if (wzy < 0) {
     wzy += trn[cN] * 2 * GM.zz;
    }
   }
  }
  double tmag = Math.max(Math.sqrt(Math.pow(nvx, 2) + Math.pow(nvy, 2) + Math.pow(nvz, 2)), Math.abs(spd)) * .025;
  if (tmag > 1 || ttyp[cN] == 0) {
   tmag = 1;
  }
  if (spd < 0 && typ[cN] != 2) {
   tmag *= -1;
  }
  if (fas == 0) {
   if (!flp) {
    if (!dr.spac) {
     fxz = a.wxz * tmag * 0.0625;
    } else {
     fxz = a.wxz * tmag * .2;
    }
    a.xz += a.wxz * tmag * .2 * GM.zz;
    if (typ[cN] == 2) {
     a.zy += wzy * tmag * .2 * GM.zz;
    }
   }
  } else if (fas != 2) {
   a.xz += fxz * GM.zz;
   stxz += fxz * GM.zz;
  }
  if (fas == 2) {
   a.zy += wzy * .135 * M.cos(a.xy) * GM.zz;
   a.xz -= wzy * .135 * M.sin(a.xy) * r * GM.zz;
   stzy -= wzy * .135 * M.cos(a.xy) * GM.zz;
   stxz -= wzy * .135 * M.sin(a.xy) * r * GM.zz;
   a.xy -= a.wxz * .27 * GM.zz;
   stxy -= a.wxz * .27 * GM.zz;
   if (spd < 0) {
    a.xz += 5 * M.sin(a.xy) * r * GM.zz;
    stxz += 5 * M.sin(a.xy) * r * GM.zz;
   } else {
    a.xz -= 5 * M.sin(a.xy) * r * GM.zz;
    stxz -= 5 * M.sin(a.xy) * r * GM.zz;
   }
   for (c = 0; c < 4; c++) {
    vx[c] = -spd * M.sin(a.xz) * M.cos(a.zy);
    vz[c] = spd * M.cos(a.xz) * M.cos(a.zy);
    vy[c] = -spd * M.sin(a.zy) + fy;
   }
   fy += M.grv[GM.stg] * GM.zz;
   if (Math.abs(spd) > 0 && fy > 0) {
    fy -= (Math.abs(spd) * .02) * GM.zz;
   }
   if (GM.cNm[cN] == "Turbo Prop" && Math.abs(spd) > 0 && fy > 0) {
    fy -= (Math.abs(spd) * .02) * GM.zz;
   }
   if (GM.stg != 29 && GM.cNm[cN] != "A-1" && GM.cNm[cN] != "SuperSonic DeathRay") {
    fy -= a.y * .00005 * GM.zz;
   }
   if (GM.stg == 5) {
    fy *= Math.min(.95 * GM.zz, 1);
   }
   if (fy != 0 && M.grv[GM.stg] == 0) {
    fy = 0;
   }
  } else if (fy != nvy) {
   fy = nvy;
  }
  if (M.grv[GM.stg] != 0) {
   if (spd > 0 && ((fas == 0 && (!dr.up && !dr.down)) || fas != 0 || spd > acel[cN][2] * .5 + (spdpwr * acel[cN][2]) * .005)) {
    spd -= drg[cN] * GM.zz;
    if (GM.cNm[cN] == "EPIC TANK") {
     spd -= drg[cN] * 3 * GM.zz;
    }
   }
   if (spd < 0 && ((fas == 0 && (!dr.up && !dr.down)) || fas != 0 || spd < acel[cN][2] * .5 + (spdpwr * acel[cN][2]) * .005)) {
    spd += drg[cN] * GM.zz;
    if (GM.cNm[cN] == "EPIC TANK") {
     spd += drg[cN] * 3 * GM.zz;
    }
   }
   if (Math.abs(spd) < drg[cN] * GM.zz) {
    spd = 0;
   }
   if (GM.cNm[cN] == "EPIC TANK" && Math.abs(spd) < drg[cN] * 3 * GM.zz) {
    spd = 0;
   }
  }
  double[] x0 = new double[4];
  double[] z0 = new double[4];
  double[] y0 = new double[4];
  int wc;
  for (wc = 0; wc < 4; wc++) {
   x0[wc] = a.x + a.wpx[wc];
   y0[wc] = a.y + h;
   z0[wc] = a.z + a.wpz[wc];
   if (!ang[wc]) {
    vy[wc] += M.grv[GM.stg] * GM.zz;
   }
  }
  rot(x0, y0, a.x, a.y, a.xy);
  rot(y0, z0, a.y, a.z, a.zy);
  rot(x0, z0, a.x, a.z, a.xz);
  if (fas != 2) {
   for (wc = 0; wc < 4; wc++) {
    if (vx[wc] - nvx > 200) {
     vx[wc] = 200 + nvx;
    }
    if (vx[wc] - nvx < -200) {
     vx[wc] = nvx - 200;
    }
    if (vz[wc] - nvz > 200) {
     vz[wc] = 200 + nvz;
    }
    if (vz[wc] - nvz < -200) {
     vz[wc] = nvz - 200;
    }
    x0[wc] += (vx[0] + vx[1] + vx[2] + vx[3]) * .25 * GM.zz;
    z0[wc] += (vz[0] + vz[1] + vz[2] + vz[3]) * .25 * GM.zz;
    y0[wc] += vy[wc] * GM.zz;
   }
  }
  wc = 1;
  for (c = 0; c < t.nt; c++) {
   if (Math.abs(t.zy[c]) != 90 && Math.abs(t.xy[c]) != 90 && Math.abs(a.x - t.x[c]) < t.radx[c] && Math.abs(a.z - t.z[c]) < t.radz[c] && (!t.scn[c] || !M.nosc)) {
    wc = (int) t.skd[c];
   }
  }
  boolean atch = false;
  if (fas == 0) {
   if (trndrg[cN] == 0 && grip[cN] > 100 && (dr.left || dr.riht)) {
    spd -= spd * .01 * GM.zz;
   }
   double g = grip[cN];
   g -= Math.abs(txz - a.xz) * spd * 0.004;
   if (dr.spac && GM.stg != 59) {
    g -= 4 * Math.abs(txz - a.xz);
   }
   if (wc == 1) {
    g *= .75;
    if (GM.stg == 37) {
     g *= .075;
    }
   }
   if (wc == 2) {
    g *= .55;
   }
   if (GM.cNm[cN] == "Drifter X" && g < 5) {
    g = 5;
   }
   g = Math.max(g * GM.zz, 0);
   double v1 = -(spd * M.sin(a.xz) * M.cos(a.zy));
   double v2 = spd * M.cos(a.xz) * M.cos(a.zy);
   double v3 = -(spd * M.sin(a.zy));
   if (dest) {
    if (spd != 0) {
     spd *= .9;
    }
    if (spd > 0) {
     spd -= 2;
    }
    if (spd < 0) {
     spd += 2;
    }
    if (spd != 0 && Math.abs(spd) < 2) {
     spd = 0;
    }
   }
   for (c = 0; c < 4; c++) {
    if (flp) {
     g = grip[cN] * .2;
     if (GM.stg == 37 && wc == 1) {
      g *= .1;
     }
     if (vx[c] > g) {
      vx[c] -= g;
     } else {
      if (vx[c] > -g) {
       vx[c] = 0;
      }
     }
     if (vx[c] < -g) {
      vx[c] += g;
     } else {
      if (vx[c] < g) {
       vx[c] = 0;
      }
     }
     if (vz[c] > g) {
      vz[c] -= g;
     } else {
      if (vz[c] > -g) {
       vz[c] = 0;
      }
     }
     if (vz[c] < -g) {
      vz[c] += g;
     } else {
      if (vz[c] < g) {
       vz[c] = 0;
      }
     }
    } else {
     if (Math.abs(vx[c] - v1) > g) {
      if (vx[c] < v1) {
       vx[c] += g;
      }
      if (vx[c] > v1) {
       vx[c] -= g;
      }
     } else {
      vx[c] = v1;
     }
     if (Math.abs(vz[c] - v2) > g) {
      if (vz[c] < v2) {
       vz[c] += g;
      }
      if (vz[c] > v2) {
       vz[c] -= g;
      }
     } else {
      vz[c] = v2;
     }
     if (Math.abs(vy[c] - v3) > g) {
      if (vy[c] < v3) {
       vy[c] += g;
      }
      if (vy[c] > v3) {
       vy[c] -= g;
      }
     } else if (!(ang[0] || ang[1] || ang[2] || ang[3])) {
      vy[c] = v3;
     }
    }
    double f11 = 1.2;
    if (wc < 1) {
     f11 = 1;
    }
    if (Math.abs(Math.abs(spd) - Math.sqrt(Math.pow(vx[c], 2) + Math.pow(vz[c], 2))) > Math.abs(spd) * .5 || (sktyp[cN] == 0 && a.wxz * a.wxz > (Math.random() * 400000 + 100000) / Math.sqrt(Math.pow(vx[c], 2) + Math.pow(vz[c], 2)))) {
     if (!flp && grip[cN] <= 100 && Math.abs(spd) > Math.sqrt(Math.pow(vx[c], 2) + Math.pow(vz[c], 2))) {
      spd -= Math.abs(Math.abs(spd) - Math.sqrt(Math.pow(vx[c], 2) + Math.pow(vz[c], 2))) * spd * .0002;
     }
     if (a.wxz * a.wxz > (Math.random() * 400000 + 100000) / Math.sqrt(Math.pow(vx[c], 2) + Math.pow(vz[c], 2)) || (engn[cN] != 6 && engn[cN] != 9 && engn[cN] != 12)) {
      a.dust(c, vx[c], vz[c], f11 * siz[cN], spd, flp);
      if (!GM.mutS && sktyp[cN] == 0 && !flp) {
       skd(wc, Math.abs(spd) - Math.sqrt(Math.pow(vx[c], 2) + Math.pow(vz[c], 2)));
      }
     }
    } else {
     if (wc == 1 && Math.random() > .8) {
      a.dust(c, vx[c], vz[c], 1.1 * siz[cN], spd, flp);
     }
     if ((wc == 2 || wc == 3) && Math.random() > .6) {
      a.dust(c, vx[c], vz[c], 1.15 * siz[cN], spd, flp);
     }
    }
    if (wc == 3) {
     vy[(int) (Math.random() * 4)] -= .004 * Math.random() * spd * a.wG * bonc[cN];
    }
    if (wc == 4) {
     vy[(int) (Math.random() * 4)] -= .006 * Math.random() * spd * a.wG * bonc[cN];
    }
   }
   fas = -1;
   atch = true;
  }
  txz = a.xz;
  double by = Math.min(Math.abs(M.sin(a.xy)) + Math.abs(M.sin(a.zy)), 1);
  double bxz = Math.min(Math.abs(M.cos(a.xy)) + Math.abs(M.cos(a.zy)), 1);
  boolean atf1[] = new boolean[4];
  for (c = 0; c < 4; c++) {
   atf1[c] = false;
   if (y0[c] > 245) {
    fas = 0;
    if (!atch && vy[c] != M.grv[GM.stg] && a.y + a.wG > 100) {
     double f8 = Math.min(vy[c] * .003, .3);
     if (wc < 1) {
      f8 = f8 + 1.1;
     } else {
      f8 = f8 + 1.2;
     }
     a.dust(c, vx[c], vz[c], f8 * siz[cN], spd, flp);
    }
    y0[c] = 250;
    double fd = Math.abs(M.sin(a.xy)) + Math.abs(M.sin(a.zy));
    if ((Math.abs(a.xy) > 90 && Math.abs(a.zy) <= 90) || (Math.abs(a.zy) > 90 && Math.abs(a.xy) <= 90)) {
     fd = 1;
    }
    cly(c, Math.abs(vy[c] * fd) * .1, a);
    if (!GM.mutS && vy[c] > 100) {
     lnd(a);
    }
    if (vy[c] > 0) {
     vy[c] *= -bonc[cN] * by;
    }
    if (flp) {
     atf1[c] = true;
    }
    wpxy[c] -= wpxy[c] * .25;
    wpzy[c] -= wpzy[c] * .25;
   }
   if (GM.stg == 5) {
    vx[c] -= vx[c] * .01 * GM.zz;
    vy[c] -= vy[c] * .1 * GM.zz;
    vz[c] -= vz[c] * .01 * GM.zz;
   }
   if (dr.wal[c]) {
    dr.wal[c] = false;
   }
   if (ang[c]) {
    ang[c] = false;
   }
  }
  if (!(GM.cNm[cN] == "The Phantom" && spcl[0])) {
   long tch = 0;
   int b0;
   for (c = 0; c < t.nt; c++) {
    long xy90 = 90 + t.xy[c];
    long zy90 = 90 + t.zy[c];
    for (b = 0; b < 4; b++) {
     if (atf1[b] && t.skd[c] < 2 && x0[b] > (t.x[c] - t.radx[c]) && x0[b] < (t.x[c] + t.radx[c]) && z0[b] > (t.z[c] - t.radz[c]) && z0[b] < (t.z[c] + t.radz[c])) {
      a.sprk(x0[b], y0[b], z0[b], vx[b], vy[b], vz[b], 1);
      if (!GM.mutS) {
       gscr(vx[b], vy[b], vz[b]);
      }
     }
     if (x0[b] <= (t.x[c] - t.radx[c]) || x0[b] >= (t.x[c] + t.radx[c]) || z0[b] <= (t.z[c] - t.radz[c]) || z0[b] >= (t.z[c] + t.radz[c]) || y0[b] <= (t.y[c] - t.rady[c]) || y0[b] >= (t.y[c] + t.rady[c]) || (t.scn[c] && M.nosc)) {
      continue;
     }
     if (t.xy[c] == 0 && t.zy[c] == 0 && t.y[c] < 250 && y0[b] > t.y[c] - 5) {
      fas = 0;
      if (!atch && vy[b] != M.grv[GM.stg]) {
       double f13 = Math.min(vy[b] * .003, .3);
       if (wc == 0) {
        f13 = f13 + 1.1;
       } else {
        f13 = f13 + 1.2;
       }
       a.dust(b, vx[b], vz[b], f13 * siz[cN], spd, flp);
      }
      y0[b] = t.y[c];
      if (flp) {
       if (t.skd[c] < 2) {
        a.sprk(x0[b], y0[b], z0[b], vx[b], vy[b], vz[b], 1);
        if (!GM.mutS) {
         gscr(vx[b], vy[b], vz[b]);
        }
       }
      }
      double fd = Math.abs(M.sin(a.xy)) + Math.abs(M.sin(a.zy));
      if ((Math.abs(a.xy) > 90 && Math.abs(a.zy) <= 90) || (Math.abs(a.zy) > 90 && Math.abs(a.xy) <= 90)) {
       fd = 1;
      }
      cly(b, Math.abs(vy[b] * fd) * .1, a);
      if (!GM.mutS && vy[b] > 100) {
       lnd(a);
      }
      if (vy[b] > 0) {
       vy[b] *= -bonc[cN] * by;
      }
      wpxy[b] -= wpxy[b] * .25;
      wpzy[b] -= wpzy[b] * .25;
     }
     if (t.zy[c] == -90 && z0[b] < t.z[c] + t.radz[c] && vz[b] < 0 && t.skd[c] < 127) {
      for (b0 = 0; b0 < 4; b0++) {
       if (b != b0 && z0[b0] >= t.z[c] + t.radz[c]) {
        z0[b0] -= z0[b] - (t.z[c] + t.radz[c]);
       }
      }
      z0[b] = t.z[c] + t.radz[c];
      if (t.skd[c] != 2) {
       prk[0][b]++;
      }
      if (t.skd[c] == 5 && Math.random() < .5) {
       prk[0][b]++;
      }
      if (prk[0][b] > 1) {
       a.sprk(x0[b], y0[b], z0[b], vx[b], vy[b], vz[b], 0);
       if (!GM.mutS) {
        scr(vx[b], vy[b], vz[b]);
       }
      }
      clz(b, Math.abs(vz[b] * t.dam[c]) * .1, a);
      vz[b] += Math.abs(vz[b]) * bonc[cN] * bxz;
      dr.wal[b] = true;
     }
     if (t.zy[c] == 90 && z0[b] > t.z[c] - t.radz[c] && vz[b] > 0 && t.skd[c] < 127) {
      for (b0 = 0; b0 < 4; b0++) {
       if (b != b0 && z0[b0] <= t.z[c] - t.radz[c]) {
        z0[b0] -= z0[b] - (t.z[c] - t.radz[c]);
       }
      }
      z0[b] = t.z[c] - t.radz[c];
      if (t.skd[c] != 2) {
       prk[1][b]++;
      }
      if (t.skd[c] == 5 && Math.random() < .5) {
       prk[1][b]++;
      }
      if (prk[1][b] > 1) {
       a.sprk(x0[b], y0[b], z0[b], vx[b], vy[b], vz[b], 0);
       if (!GM.mutS) {
        scr(vx[b], vy[b], vz[b]);
       }
      }
      clz(b, -Math.abs(vz[b] * t.dam[c]) * .1, a);
      vz[b] -= Math.abs(vz[b]) * bonc[cN] * bxz;
      dr.wal[b] = true;
     }
     if (t.xy[c] == -90 && x0[b] < t.x[c] + t.radx[c] && vx[b] < 0 && t.skd[c] < 127) {
      for (b0 = 0; b0 < 4; b0++) {
       if (b != b0 && x0[b0] >= t.x[c] + t.radx[c]) {
        x0[b0] -= x0[b] - (t.x[c] + t.radx[c]);
       }
      }
      x0[b] = t.x[c] + t.radx[c];
      if (t.skd[c] != 2) {
       prk[2][b]++;
      }
      if (t.skd[c] == 5 && Math.random() < .5) {
       prk[2][b]++;
      }
      if (prk[2][b] > 1) {
       a.sprk(x0[b], y0[b], z0[b], vx[b], vy[b], vz[b], 0);
       if (!GM.mutS) {
        scr(vx[b], vy[b], vz[b]);
       }
      }
      clx(b, Math.abs(vx[b] * t.dam[c]) * .1, a);
      vx[b] += Math.abs(vx[b]) * bonc[cN] * bxz;
      dr.wal[b] = true;
     }
     if (t.xy[c] == 90 && x0[b] > t.x[c] - t.radx[c] && vx[b] > 0 && t.skd[c] < 127) {
      for (b0 = 0; b0 < 4; b0++) {
       if (b != b0 && x0[b0] <= t.x[c] - t.radx[c]) {
        x0[b0] -= x0[b] - (t.x[c] - t.radx[c]);
       }
      }
      x0[b] = t.x[c] - t.radx[c];
      if (t.skd[c] != 2) {
       prk[3][b]++;
      }
      if (t.skd[c] == 5 && Math.random() < .5) {
       prk[3][b]++;
      }
      if (prk[3][b] > 1) {
       a.sprk(x0[b], y0[b], z0[b], vx[b], vy[b], vz[b], 0);
       if (!GM.mutS) {
        scr(vx[b], vy[b], vz[b]);
       }
      }
      clx(b, -Math.abs(vx[b] * t.dam[c]) * .1, a);
      vx[b] -= Math.abs(vx[b]) * bonc[cN] * bxz;
      dr.wal[b] = true;
     }
     if (t.skd[c] == 127) {
      if (Math.abs(t.zy[c]) == 90) {
       vz[b] *= 3;
      }
      if (Math.abs(t.xy[c]) == 90) {
       vx[b] *= 3;
      }
      if (!GM.mutS && (vx[b] != 0 || vz[b] != 0)) {
       stb.ply(sD_v_o);
      }
     }
     if (t.zy[c] != 0 && t.zy[c] != 90 && t.zy[c] != -90) {
      double f19 = Math.max((50 - Math.abs(t.zy[c])) * 0.03125, 1);
      double f21 = t.y[c] + ((y0[b] - t.y[c]) * M.cos(zy90) - (z0[b] - t.z[c]) * M.sin(zy90));
      double f23 = t.z[c] + ((y0[b] - t.y[c]) * M.sin(zy90) + (z0[b] - t.z[c]) * M.cos(zy90));
      if (f23 > t.z[c] && f23 < t.z[c] + 200) {
       vy[b] -= Math.max((f23 - t.z[c]) / f19, 0);
       f23 = t.z[c];
      }
      if (f23 > t.z[c] - 30) {
       ang[b] = true;
       tch++;
       fas = 0;
       if (flp) {
        if (t.skd[c] < 2) {
         a.sprk(x0[b], y0[b], z0[b], vx[b], vy[b], vz[b], 1);
         if (!GM.mutS) {
          gscr(vx[b], vy[b], vz[b]);
         }
        }
       }
       if (!atch && wc != 0) {
        a.dust(b, vx[b], vz[b], 1.4 * siz[cN], spd, flp);
       }
      }
      y0[b] = t.y[c] + ((f21 - t.y[c]) * M.cos(-zy90) - (f23 - t.z[c]) * M.sin(-zy90));
      z0[b] = t.z[c] + ((f21 - t.y[c]) * M.sin(-zy90) + (f23 - t.z[c]) * M.cos(-zy90));
      wpzy[b] += (-t.zy[c] * M.cos(a.xz) - wpzy[b]) * .25;
      wpxy[b] += (t.zy[c] * M.sin(a.xz) - wpxy[b]) * .25;
     }
     if (t.xy[c] != 0 && t.xy[c] != 90 && t.xy[c] != -90) {
      double f20 = Math.max((50 - Math.abs(t.xy[c])) * 0.03125, 1);
      double f22 = t.y[c] + ((y0[b] - t.y[c]) * M.cos(xy90) - (x0[b] - t.x[c]) * M.sin(xy90));
      double f24 = t.x[c] + ((y0[b] - t.y[c]) * M.sin(xy90) + (x0[b] - t.x[c]) * M.cos(xy90));
      if (f24 > t.x[c] && f24 < t.x[c] + 200) {
       vy[b] -= Math.max((f24 - t.x[c]) / f20, 0);
       f24 = t.x[c];
      }
      if (f24 > t.x[c] - 30) {
       ang[b] = true;
       tch++;
       fas = 0;
       if (flp) {
        if (t.skd[c] < 2) {
         a.sprk(x0[b], y0[b], z0[b], vx[b], vy[b], vz[b], 1);
         if (!GM.mutS) {
          gscr(vx[b], vy[b], vz[b]);
         }
        }
       }
       if (!atch && wc != 0) {
        a.dust(b, vx[b], vz[b], 1.4 * siz[cN], spd, flp);
       }
      }
      y0[b] = t.y[c] + ((f22 - t.y[c]) * M.cos(-xy90) - (f24 - t.x[c]) * M.sin(-xy90));
      x0[b] = t.x[c] + ((f22 - t.y[c]) * M.sin(-xy90) + (f24 - t.x[c]) * M.cos(-xy90));
      wpzy[b] += (t.xy[c] * M.sin(a.xz) - wpzy[b]) * .25;
      wpxy[b] += (t.xy[c] * M.cos(a.xz) - wpxy[b]) * .25;
     }
    }
   }
   for (c = 0; c < 4; c++) {
    for (b = 0; b < 4; b++) {
     if (prk[c][b] == lprk[c][b]) {
      prk[c][b] = 0;
     }
     lprk[c][b] = prk[c][b];
    }
   }
   if (tch > 3) {
    fas = 0;
   }
   if (typ[cN] != 2) {
    if (fas == 0 && (ang[0] || ang[1] || ang[2] || ang[3])) {
     long fxy = 0;
     long fzy = 0;
     if (Math.abs(a.xy) > 90) {
      fxy = 180;
     }
     if (Math.abs(a.zy) > 90) {
      fzy = 180;
     }
     a.xy = fxy + (wpxy[0] + wpxy[1] + wpxy[2] + wpxy[3]) * .25;
     a.zy = fzy + (wpzy[0] + wpzy[1] + wpzy[2] + wpzy[3]) * .25;
    }
    double l = Math.max(Math.abs(a.wpz[0] - a.wpz[2]), Math.abs(a.wpz[1] - a.wpz[3]));
    double w = Math.max(Math.abs(a.wpx[0] - a.wpx[1]), Math.abs(a.wpx[2] - a.wpx[3]));
    if (Math.abs(a.xy) > 90) {
     a.xy += vy[0] * GM.zz / w;
     a.xy -= vy[1] * GM.zz / w;
     a.xy += vy[2] * GM.zz / w;
     a.xy -= vy[3] * GM.zz / w;
    } else {
     a.xy -= vy[0] * GM.zz / w;
     a.xy += vy[1] * GM.zz / w;
     a.xy -= vy[2] * GM.zz / w;
     a.xy += vy[3] * GM.zz / w;
    }
    if (Math.abs(a.zy) > 90) {
     a.zy += vy[0] * GM.zz / l;
     a.zy += vy[1] * GM.zz / l;
     a.zy -= vy[2] * GM.zz / l;
     a.zy -= vy[3] * GM.zz / l;
    } else {
     a.zy -= vy[0] * GM.zz / l;
     a.zy -= vy[1] * GM.zz / l;
     a.zy += vy[2] * GM.zz / l;
     a.zy += vy[3] * GM.zz / l;
    }
   }
   if (dr.wal[0] || dr.wal[1] || dr.wal[2] || dr.wal[3]) {
    double v1;
    for (v1 = Math.abs(a.xz + 45); v1 > 180; v1 -= 360) {
    }
    if (Math.abs(v1) > 90) {
     pmlt = 1;
    } else {
     pmlt = -1;
    }
    for (v1 = Math.abs(a.xz - 45); v1 > 180; v1 -= 360) {
    }
    if (Math.abs(v1) > 90) {
     nmlt = 1;
    } else {
     nmlt = -1;
    }
   }
   a.xz += forc * ((((vz[0] * nmlt - vz[1] * pmlt) + vz[2] * pmlt - vz[3] * nmlt) + vx[0] * pmlt + vx[1] * nmlt) - vx[2] * nmlt - vx[3] * pmlt);
  }
  if (dr.bost && bost[cN] > 0 && pwr > 1 && !dest) {
   for (c = 0; c < 4; c++) {
    vx[c] -= bost[cN] * M.sin(a.xz) * r * GM.zz;
    vz[c] += bost[cN] * M.cos(a.xz) * r * GM.zz;
    vy[c] -= bost[cN] * M.sin(a.zy) * GM.zz;
    if (GM.cNm[cN] == "The Destroyer" && fas == 0) {
     vx[c] -= 20 * bost[cN] * M.sin(a.xz) * r * GM.zz;
     vz[c] += 20 * bost[cN] * M.cos(a.xz) * r * GM.zz;
     vy[c] -= 20 * bost[cN] * M.sin(a.zy) * GM.zz;
    }
   }
   if (GM.cNm[cN] != "The Destroyer") {
    spd += bost[cN] * GM.zz;
   }
   pwr -= GM.zz;
   if (GM.cNm[cN] != "F-22 Raptor") {
    pwr -= GM.zz;
   }
  }
  if (fas == 0) {
   a.y = (y0[0] + y0[1] + y0[2] + y0[3]) * .25 - (h * M.cos(a.zy) * M.cos(a.xy));
  } else {
   a.y += (vy[0] + vy[1] + vy[2] + vy[3]) * .25 * GM.zz;
  }
  if (nvx != 0 && (GM.cNm[cN] != "EPIC TANK" || Math.abs(nvx) > 2)) {
   if (dr.wal[0] || dr.wal[1] || dr.wal[2] || dr.wal[3]) {
    a.x = (x0[0] - a.wpx[0] * M.cos(a.xz) + r * a.wpz[0] * M.sin(a.xz) + x0[1] - a.wpx[1] * M.cos(a.xz) + r * a.wpz[1] * M.sin(a.xz) + x0[2] - a.wpx[2] * M.cos(a.xz) + r * a.wpz[2] * M.sin(a.xz) + x0[3] - a.wpx[3] * M.cos(a.xz) + r * a.wpz[3] * M.sin(a.xz)) * .25 + h * M.sin(a.xy) * M.cos(a.xz) - h * M.sin(a.zy) * M.sin(a.xz);
   } else {
    a.x += (vx[0] + vx[1] + vx[2] + vx[3]) * .25 * GM.zz;
   }
  }
  if (nvz != 0 && (GM.cNm[cN] != "EPIC TANK" || Math.abs(nvz) > 2)) {
   if (dr.wal[0] || dr.wal[1] || dr.wal[2] || dr.wal[3]) {
    a.z = (z0[0] - r * a.wpz[0] * M.cos(a.xz) - a.wpx[0] * M.sin(a.xz) + z0[1] - r * a.wpz[1] * M.cos(a.xz) - a.wpx[1] * M.sin(a.xz) + z0[2] - r * a.wpz[2] * M.cos(a.xz) - a.wpx[2] * M.sin(a.xz) + z0[3] - r * a.wpz[3] * M.cos(a.xz) - a.wpx[3] * M.sin(a.xz)) * .25 + h * M.sin(a.xy) * M.sin(a.xz) - h * M.sin(a.zy) * M.cos(a.xz);
   } else {
    a.z += (vz[0] + vz[1] + vz[2] + vz[3]) * .25 * GM.zz;
   }
  }
  if (GM.stg == 26) {
   a.x *= .995 / Math.max(GM.zz, 1);
   if (a.y < 0) {
    a.y *= .995 / Math.max(GM.zz, 1);
   }
   a.z *= .995 / Math.max(GM.zz, 1);
  }
  if (typ[cN] != 2 && fas == 0 && !(ang[0] || ang[1] || ang[2] || ang[3])) {
   if (Math.abs(a.zy) <= 90) {
    if (a.zy > 0) {
     a.zy -= GM.zz;
    }
    if (a.zy < 0) {
     a.zy += GM.zz;
    }
   }
   if (a.zy > 90 && a.zy < 180 - GM.zz) {
    a.zy += GM.zz;
   }
   if (a.zy < -90 && a.zy > -180 + GM.zz) {
    a.zy -= GM.zz;
   }
   if (Math.abs(a.xy) <= 90) {
    if (a.xy > 0) {
     a.xy -= GM.zz;
    }
    if (a.xy < 0) {
     a.xy += GM.zz;
    }
   }
   if (lAng[cN] == 0) {
    if (a.xy > 90 && a.xy < 180 - GM.zz) {
     a.xy += GM.zz;
    }
    if (a.xy < -90 && a.xy > -180 + GM.zz) {
     a.xy -= GM.zz;
    }
   } else {
    if ((a.xy > 90 && a.xy < lAng[cN]) || (a.xy < -lAng[cN] && a.xy > -(lAng[cN] + 30))) {
     a.xy += Math.random() * 3 * GM.zz;
    }
    if ((a.xy < -90 && a.xy > -lAng[cN]) || (a.xy > lAng[cN] && a.xy < lAng[cN] + 30)) {
     a.xy -= Math.random() * 3 * GM.zz;
    }
    if (Math.abs(a.xy) >= lAng[cN] + 30) {
     if (a.xy > -180 + GM.zz) {
      a.xy -= GM.zz;
     }
     if (a.xy < 180 - GM.zz) {
      a.xy += GM.zz;
     }
    }
   }
   if (a.xy != 0 && Math.abs(a.xy) <= 90) {
    a.xy *= .25;
   }
   if (a.zy != 0 && Math.abs(a.zy) <= 90) {
    a.zy *= .25;
   }
  }
  if (fas == 0) {
   if (Math.abs(a.zy) > 90 && Math.abs(a.xy) > 90) {
    if (Math.random() < .5) {
     a.xy += 180;
     a.zy += 180;
     a.xz += 180;
    } else {
     a.xy -= 180;
     a.zy -= 180;
     a.xz -= 180;
    }
   }
   if ((GM.cNm[cN] == "Air Rebound" || GM.cNm[cN] == "Everlast-177") && flp) {
    if (Math.abs(a.zy) > 90 && Math.abs(a.xy) < 90) {
     if (Math.random() < .5) {
      a.xz += 180;
     } else {
      a.xz -= 180;
     }
    }
    a.xy = 0;
    a.zy = 0;
   }
   if (GM.cNm[cN] != "Zonich Tank" && GM.cNm[cN] != "Matlos Tank") {
    if (!flp && typ[cN] == 0 && bonc[cN] > 0) {
     tlt = (spd * a.wG * 0.0000133) * bonc[cN] * a.wxz;
     if (spd < 0) {
      tlt *= -1;
     }
     if (Math.abs(a.xy) > 10) {
      tlt *= .5;
     }
     a.xy += tlt;
    }
    if (bonc[cN] > 0 && GM.cNm[cN] != "Lightning Rod") {
     double j = Math.sqrt(Math.pow(nvx, 2) + Math.pow(nvy, 2) + Math.pow(nvz, 2));
     if (wc == 1 && j > Math.random() * 100) {
      a.zy += Math.random() * .00015 * j * a.wG * bonc[cN];
      a.zy -= Math.random() * .00015 * j * a.wG * bonc[cN];
      a.xy += Math.random() * .00015 * j * a.wG * bonc[cN];
      a.xy -= Math.random() * .00015 * j * a.wG * bonc[cN];
     }
     if (wc == 2 && j > Math.random() * 50) {
      a.zy += Math.random() * .0003 * j * a.wG * bonc[cN];
      a.zy -= Math.random() * .0003 * j * a.wG * bonc[cN];
      a.xy += Math.random() * .0003 * j * a.wG * bonc[cN];
      a.xy -= Math.random() * .0003 * j * a.wG * bonc[cN];
     }
    }
   }
  } else if (tlt != 0) {
   tlt = 0;
  }
  if (engn[cN] == 8 && !dest) {
   if (Math.random() < .5) {
    if (Math.random() < .5) {
     a.xy++;
    } else {
     a.xy--;
    }
   }
  }
  if (dam > dura[cN]) {
   if (dcnt <= 0) {
    for (c = 0; c < a.np; c++) {
     a.P[c].fir = 1;
    }
    if (!GM.mutS) {
     exp[0].ply(sD_v_o);
     if (GM.cNm[cN] == "EPIC TANK" || GM.cNm[cN] == "EL KING-OF-WAR" || GM.cNm[cN] == "KILL-O-MATIC" || GM.cNm[cN] == "TRAIN of TERROR" || GM.cNm[cN] == "SuperSonic DeathRay") {
      exp[1].ply(sD_v_o);
     }
     if (GM.cNm[cN] == "Tactical Nuke") {
      nuk[(int) (Math.random() * 2)].ply(sD_v_o);
     }
    }
   }
   if (dcnt < 8) {
    dcnt += GM.zz;
   } else {
    dest = true;
   }
   if (dest) {
    for (c = 0; c < a.np; c++) {
     if (a.P[c].fir < Math.random() * 100) {
      a.P[c].fir++;
     } else {
      a.P[c].fir = 16;
     }
    }
    if (!GM.mutS) {
     brn[0].lop(sD_v_o);
     brn[1].lop(sD_v_o);
    }
   }
  } else {
   if (dest) {
    dest = false;
   }
   if (dcnt != 0) {
    dcnt = 0;
   }
   if (GM.stg != 44) {
    for (c = 0; c < a.np; c++) {
     if (a.P[c].fir != 0) {
      a.P[c].fir = 0;
     }
    }
   }
  }
  if (a.dist == 0) {
   for (c = 0; c < a.np; c++) {
    if (a.P[c].chip != 0) {
     a.P[c].chip = 0;
    }
    if (a.P[c].fir > 0 && a.P[c].fir < 13) {
     a.P[c].fir = 13;
    }
   }
  }
  long d = 2000;
  if (GM.typ[pnt] == -1) {
   d = 1000;
  }
  if (GM.typ[pnt] == -2) {
   d = 500;
  }
  if (GM.typ[pnt] == -3) {
   d = 250;
   if (GM.x_y_z(a.x * .01, GM.x[pnt] * .01, a.y * .01, GM.y[pnt] * .01, a.z * .01, GM.z[pnt] * .01) < d) {
    pnt++;
   }
  } else if (GM.nCk > 0) {
   if (GM.x_z(a.x * .01, GM.x[pnt] * .01, a.z * .01, GM.z[pnt] * .01) < d || GM.x_z(a.x, GM.cx[clrL], a.z, GM.cz[clrL]) < GM.x_z(GM.x[pnt], GM.cx[clrL], GM.z[pnt], GM.cz[clrL])) {
    pnt++;
   }
  }
  if (GM.nCk > 0) {
   long cc = 0;
   for (c = 0; c < GM.nS; c++) {
    if (GM.typ[c] > 0) {
     cc++;
     if (GM.typ[c] == 1 || GM.typ[c] == 3) {
      if (Math.abs(a.z - GM.z[c]) < 60 + Math.abs(vz[0] + vz[1] + vz[2] + vz[3]) * .25 * GM.zz && Math.abs(a.x - GM.x[c]) < 700 && Math.abs((a.y - GM.y[c]) + 350) < 450 && clr == (cc + lapn * GM.nCk) - 1) {
       clr++;
       clrL++;
      }
     }
     if (GM.typ[c] == 2 || GM.typ[c] == 3) {
      if (Math.abs(a.x - GM.x[c]) < 60 + Math.abs(vx[0] + vx[1] + vx[2] + vx[3]) * .25 * GM.zz && Math.abs(a.z - GM.z[c]) < 700 && Math.abs((a.y - GM.y[c]) + 350) < 450 && clr == (cc + lapn * GM.nCk) - 1) {
       clr++;
       clrL++;
      }
     }
    }
   }
   if (clr == cc + lapn * GM.nCk) {
    lapn++;
    clrL = 0;
   }
   if (clrL > 0) {
    if (pnt < GM.cLoc[clrL - 1]) {
     pnt = GM.cLoc[clrL - 1];
    }
    if (pnt > GM.cLoc[clrL]) {
     pnt = GM.cLoc[clrL];
    }
   } else {
    if (pnt < GM.cLoc[GM.nCk - 1] && pnt > GM.cLoc[0]) {
     pnt = GM.cLoc[0];
    }
   }
   if (im == GM.im) {
    for (M.cp = clr; M.cp >= GM.nCk; M.cp -= GM.nCk) {
    }
    M.fchk = clr == GM.lapn * GM.nCk - 1;
   }
  }
  if (pnt >= GM.nS) {
   pnt = 0;
  }
  if (GM.wn > -1) {
   M.fchk = false;
  }
  if (fas == 0) {
   if (stcnt > 8) {
    if (!stnd) {
     stxy = 0;
     stzy = 0;
     stxz = 0;
     tbltp[0] = false;
     tbltp[1] = false;
     tbltp[2] = false;
     edgcnt = 0;
     edg = false;
     if (Math.random() < .5) {
      dr.aRot[0] = 1;
     } else {
      dr.aRot[0] = -1;
     }
     if (Math.random() < .5) {
      dr.aRot[1] = 1;
     } else {
      dr.aRot[1] = -1;
     }
     stnd = true;
    }
   } else {
    stcnt += GM.zz;
   }
  }
  if (fas != 0) {
   if (stcnt != 0) {
    stcnt = 0;
   }
   stnd = false;
   if (fas == 1 || typ[cN] == 1) {
    if (GM.cNm[cN] != "Lightning Rod") {
     stxy += 20 * aRot[1] * GM.zz;
    }
    if (Math.abs(stxy) > 135) {
     tbltp[0] = true;
    }
    if (GM.cNm[cN] != "Lightning Rod") {
     stzy -= 20 * aRot[0] * GM.zz;
    }
    if (stzy > 135) {
     tbltp[1] = true;
    }
    if (stzy < -135) {
     tbltp[2] = true;
    }
   }
   if (edgcnt < 10) {
    if (dr.wal[0] || dr.wal[1] || dr.wal[2] || dr.wal[3]) {
     edg = true;
    }
    edgcnt += GM.zz;
   }
  } else if (!dest) {
   if (!flp || GM.cNm[cN] == "Air Rebound" || GM.cNm[cN] == "Everlast-177") {
    if (flpcnt != 0) {
     flpcnt = 0;
    }
    if (stcnt > 8 && !stnd) {
     pwrp = 0;
     if (Math.abs(stxy) > 90) {
      pwrp += Math.abs(stxy) * .042;
     } else if (tbltp[0]) {
      pwrp += 30;
     }
     if (Math.abs(stzy) > 90) {
      pwrp += Math.abs(stzy) * .055;
     } else {
      if (tbltp[1]) {
       pwrp += 40;
      }
      if (tbltp[2]) {
       pwrp += 40;
      }
     }
     if (Math.abs(stxz) > 90) {
      pwrp += Math.abs(stxz) * .055;
     }
     if (edg) {
      pwrp += 30;
     }
     pwr += pwrp;
     xtpwr += pwrp * 1.5;
     pwr = Math.min(pwr, 100);
    }
   } else {
    flpcnt += GM.zz;
    if (flpcnt > 39) {
     spd = 0;
     a.xy = 0;
     if (Math.abs(a.zy) > 90) {
      if (Math.random() < .5) {
       a.xz -= 180;
      } else {
       a.xz += 180;
      }
     }
     a.zy = 0;
     flpcnt = 0;
    }
   }
  }
  if (GM.fas == "go" && a.y > 250 - a.wG - nvy && nvy > 0 && Math.abs(a.xy) < 1 && Math.abs(a.zy) < 1 && fas != 0 && !flp) {
   pwr += 10;
   if (im == GM.im) {
    GM.say = "Perfect Landing!";
    GM.tcnt = 10;
    if (!GM.mutS) {
     GM.pwr.ply(0);
    }
   }
  }
  if (!dest && (dr.up || dr.down || ((dr.left || dr.riht) && ttyp[cN] == 0) || fas > 0)) {
   if (xtpwr > 100) {
    xtpwr -= GM.zz;
   } else if (pwr > 0 && pwrs[cN] > 0) {
    pwr -= Math.pow(pwr, 3) / (pwrs[cN] * 1000.) * GM.zz;
   }
  }
  if ((dr.wal[0] || dr.wal[1] || dr.wal[2] || dr.wal[3]) && (grip[cN] > 100 || fas == 2) && M.grv[GM.stg] != 0) {
   spd *= .95;
  }
  if (GM.cNm[cN] == "Tactical Nuke") {
   if (dest) {
    if (lift[44] != 0) {
     lift[44] = 0;
    }
   } else if (lift[44] != 100) {
    lift[44] = 100;
   }
  }
  if (!dest && pwr < 100) {
   if (GM.cNm[cN] == "EPIC TANK" || GM.cNm[cN] == "KILL-O-MATIC" || GM.cNm[cN] == "F-22 Raptor") {
    pwr += .1 * GM.zz;
   }
   if (GM.cNm[cN] == "Lightning Rod" || GM.cNm[cN] == "EL KING-OF-WAR") {
    pwr += .5 * GM.zz;
   }
   if (GM.cNm[cN] == "TRAIN of TERROR" || GM.cNm[cN] == "SuperSonic DeathRay" || typ[cN] == 2) {
    pwr += .25 * GM.zz;
   }
  }
  if (typ[cN] == 2) {
   a.zy = Math.max(-90, Math.min(a.zy, 90));
   if (fas != 0) {
    fas = 0;
   }
   if (a.xy != 0) {
    a.xy = 0;
   }
   if (flp) {
    flp = false;
   }
   if (a.y > 22) {
    a.y = 22;
    for (b = 0; b < 4; b++) {
     if (vy[b] > 0) {
      vy[b] = 0;
     }
    }
   }
  }
  spcl[0] = false;
  if (gcnt <= 0) {
   if (dr.fir[0] && !dest && styp[cN] > -1 && (!M.nofpwr || GM.cNm[cN] == "The Phantom")) {
    if (pwr >= slos[styp[cN]]) {
     if (!GM.mutS && GM.cNm[cN] != "YottaVolt Particle Disintegrator") {
      if (GM.cNm[cN] == "The Phantom") {
       sp.lop(sD_v_o);
      } else {
       sp.ply(sD_v_o);
      }
     }
     if (styp[cN] == 0) {
      gcnt = 4;
     }
     if (styp[cN] == 1) {
      gcnt = 1;
     }
     if (styp[cN] == 2) {
      gcnt = 5;
     }
     if (styp[cN] == 3) {
      gcnt = 20;
     }
     if (styp[cN] == 4) {
      gcnt = 30;
     }
     if (styp[cN] == 5) {
      gcnt = 1;
     }
     if (styp[cN] == 6 || styp[cN] == 10) {
      gcnt = 50;
     }
     if (styp[cN] == 7 || styp[cN] >= 11) {
      gcnt = 0;
     }
     if (styp[cN] == 8) {
      gcnt = 50;
     }
     if (styp[cN] == 9) {
      gcnt = 0;
     }
     if (GM.cNm[cN] == "The Phantom") {
      pwr -= slos[styp[cN]] * GM.zz;
     } else {
      pwr -= slos[styp[cN]];
     }
     if (GM.cNm[cN] != "Sting Rod" && GM.cNm[cN] != "Over=Kill" && GM.cNm[cN] != "The Phantom" && GM.cNm[cN] != "EL KING-OF-WAR" && GM.cNm[cN] != "F-22 Raptor" && GM.cNm[cN] != "SuperSonic DeathRay" && GM.cNm[cN] != "YottaVolt Particle Disintegrator") {
      gx[ng] = a.x;
      gy[ng] = a.y - (gny[cN] * M.cos(a.xy) - (gny[cN] * M.sin(a.zy))) * r;
      gz[ng] = a.z;
      gxz[ng] = a.xz;
      gzy[ng] = a.zy;
      gxy[ng] = a.xy;
      gspd[ng] = G.spd[styp[cN]] + spd;
      gstg[ng] = 1;
      ghit[ng] = 0;
      ng++;
      if (ng == 192) {
       ng = 0;
      }
     }

     if (GM.cNm[cN] == "Sting Rod") {
      gx[ng] = (a.x + (13 * M.cos(a.xz))) + (Math.random() * 50) - (Math.random() * 50);
      gy[ng] = (a.y - (gny[cN] * M.cos(a.xy) - (gny[cN] * M.sin(a.zy))) * r) + (Math.random() * 50) - (Math.random() * 50);
      gz[ng] = (a.z + (13 * M.sin(a.xz))) + (Math.random() * 50) - (Math.random() * 50);
      gxz[ng] = a.xz + Math.random() - Math.random();
      gzy[ng] = a.zy + Math.random() - Math.random();
      gxy[ng] = a.xy + Math.random() - Math.random();
      gspd[ng] = (G.spd[styp[cN]] + spd) + (Math.random() * 5) - (Math.random() * 5);
      gstg[ng] = 1;
      ghit[ng] = 0;
      ng++;
      if (ng == 192) {
       ng = 0;
      }
     }
     if (GM.cNm[cN] == "Sting Rod") {
      gx[ng] = (a.x - (13 * M.cos(a.xz))) + (Math.random() * 50) - (Math.random() * 50);
      gy[ng] = (a.y - (gny[cN] * M.cos(a.xy) - (gny[cN] * M.sin(a.zy))) * r) + (Math.random() * 50) - (Math.random() * 50);
      gz[ng] = (a.z - (13 * M.sin(a.xz))) + (Math.random() * 50) - (Math.random() * 50);
      gxz[ng] = a.xz + Math.random() - Math.random();
      gzy[ng] = a.zy + Math.random() - Math.random();
      gxy[ng] = a.xy + Math.random() - Math.random();
      gspd[ng] = (G.spd[styp[cN]] + spd) + (Math.random() * 5) - (Math.random() * 5);
      gstg[ng] = 1;
      ghit[ng] = 0;
      ng++;
      if (ng == 192) {
       ng = 0;
      }
     }
     if (GM.cNm[cN] == "Over=Kill") {
      gx[ng] = a.x + (Math.random() * 15) - (Math.random() * 15);
      gy[ng] = a.y - (gny[cN] * M.cos(a.xy) - (gny[cN] * M.sin(a.zy))) + (Math.random() * 15) - (Math.random() * 15);
      gz[ng] = a.z + (Math.random() * 15) - (Math.random() * 15);
      gxz[ng] = a.xz + Math.random() - Math.random();
      gzy[ng] = a.zy + Math.random() - Math.random();
      gxy[ng] = a.xy + Math.random() - Math.random();
      gspd[ng] = (G.spd[styp[cN]] + spd) + (Math.random() * 5 - (Math.random() * 5));
      gstg[ng] = 1;
      ghit[ng] = 0;
      ng++;
      if (ng == 192) {
       ng = 0;
      }
     }
     if (GM.cNm[cN] == "EL KING-OF-WAR") {
      gx[ng] = (a.x + (79 * M.cos(a.xz) * M.cos(a.xy) + (41 * M.sin(a.xy)))) + (Math.random() * 50) - (Math.random() * 50);
      gy[ng] = (a.y + (79 * M.sin(a.xy) - (41 * M.cos(a.xy))) * r) + (Math.random() * 50) - (Math.random() * 50);
      gz[ng] = (a.z + (79 * M.sin(a.xz)) * r) + (Math.random() * 50) - (Math.random() * 50);
      gxz[ng] = a.xz + (Math.random() * 5) - (Math.random() * 5);
      gzy[ng] = a.zy + (Math.random() * 5) - (Math.random() * 5);
      gxy[ng] = a.xy + (Math.random() * 5) - (Math.random() * 5);
      gspd[ng] = (G.spd[styp[cN]] + spd) + (Math.random() * 5) - (Math.random() * 5);
      gstg[ng] = 1;
      ghit[ng] = 0;
      ng++;
      if (ng == 192) {
       ng = 0;
      }
     }
     if (GM.cNm[cN] == "EL KING-OF-WAR") {
      gx[ng] = (a.x - (79 * M.cos(a.xz) * M.cos(a.xy) - (41 * M.sin(a.xy)))) + (Math.random() * 50) - (Math.random() * 50);
      gy[ng] = (a.y - (79 * M.sin(a.xy) + (41 * M.cos(a.xy))) * r) + (Math.random() * 50) - (Math.random() * 50);
      gz[ng] = (a.z - (79 * M.sin(a.xz)) * r) + (Math.random() * 50) - (Math.random() * 50);
      gxz[ng] = a.xz + (Math.random() * 5) - (Math.random() * 5);
      gzy[ng] = a.zy + (Math.random() * 5) - (Math.random() * 5);
      gxy[ng] = a.xy + (Math.random() * 5) - (Math.random() * 5);
      gspd[ng] = (G.spd[styp[cN]] + spd) + (Math.random() * 5) - (Math.random() * 5);
      gstg[ng] = 1;
      ghit[ng] = 0;
      ng++;
      if (ng == 192) {
       ng = 0;
      }
     }
     if (GM.cNm[cN] == "EL KING-OF-WAR") {
      gx[ng] = (a.x + (91 * M.cos(a.xz) * M.cos(a.xy) + (34 * M.sin(a.xy)))) + (Math.random() * 50) - (Math.random() * 50);
      gy[ng] = (a.y + (91 * M.sin(a.xy) - (34 * M.cos(a.xy))) * r) + (Math.random() * 50) - (Math.random() * 50);
      gz[ng] = (a.z + (91 * M.sin(a.xz)) * r) + (Math.random() * 50) - (Math.random() * 50);
      gxz[ng] = a.xz + (Math.random() * 5) - (Math.random() * 5);
      gzy[ng] = a.zy + (Math.random() * 5) - (Math.random() * 5);
      gxy[ng] = a.xy + (Math.random() * 5) - (Math.random() * 5);
      gspd[ng] = -(G.spd[styp[cN]] - spd) + (Math.random() * 5) - (Math.random() * 5);
      gstg[ng] = 1;
      ghit[ng] = 0;
      ng++;
      if (ng == 192) {
       ng = 0;
      }
     }
     if (GM.cNm[cN] == "EL KING-OF-WAR") {
      gx[ng] = (a.x - (91 * M.cos(a.xz) * M.cos(a.xy) - (34 * M.sin(a.xy)))) + (Math.random() * 50) - (Math.random() * 50);
      gy[ng] = (a.y - (91 * M.sin(a.xy) + (34 * M.cos(a.xy))) * r) + (Math.random() * 50) - (Math.random() * 50);
      gz[ng] = (a.z - (91 * M.sin(a.xz)) * r) + (Math.random() * 50) - (Math.random() * 50);
      gxz[ng] = a.xz + (Math.random() * 5) - (Math.random() * 5);
      gzy[ng] = a.zy + (Math.random() * 5) - (Math.random() * 5);
      gxy[ng] = a.xy + (Math.random() * 5) - (Math.random() * 5);
      gspd[ng] = -(G.spd[styp[cN]] - spd) + (Math.random() * 5) - (Math.random() * 5);
      gstg[ng] = 1;
      ghit[ng] = 0;
      ng++;
      if (ng == 192) {
       ng = 0;
      }
     }
     if (GM.cNm[cN] == "EL KING-OF-WAR") {
      gx[ng] = (a.x + (22 * M.sin(a.xz)) * r) + (Math.random() * 50) - (Math.random() * 50);
      gy[ng] = (a.y - (4 * M.cos(a.xy) - (4 * M.sin(a.zy))) * r) + (Math.random() * 50) - (Math.random() * 50);
      gz[ng] = (a.z - (22 * M.cos(a.xz)) * r) + (Math.random() * 50) - (Math.random() * 50);
      gxz[ng] = a.xz + 90 + (Math.random() * 5) - (Math.random() * 5);
      gzy[ng] = a.zy + (Math.random() * 5) - (Math.random() * 5);
      gxy[ng] = a.xy + (Math.random() * 5) - (Math.random() * 5);
      gspd[ng] = -G.spd[styp[cN]] + (Math.random() * 5) - (Math.random() * 5);
      gstg[ng] = 1;
      ghit[ng] = 0;
      ng++;
      if (ng == 192) {
       ng = 0;
      }
     }
     if (GM.cNm[cN] == "EL KING-OF-WAR") {
      gx[ng] = (a.x + (22 * M.sin(a.xz)) * r) + (Math.random() * 50) - (Math.random() * 50);
      gy[ng] = (a.y - (4 * M.cos(a.xy) - (4 * M.sin(a.zy))) * r) + (Math.random() * 50) - (Math.random() * 50);
      gz[ng] = (a.z - (22 * M.cos(a.xz)) * r) + (Math.random() * 50) - (Math.random() * 50);
      gxz[ng] = a.xz - 90 + (Math.random() * 5) - (Math.random() * 5);
      gzy[ng] = a.zy + (Math.random() * 5) - (Math.random() * 5);
      gxy[ng] = a.xy + (Math.random() * 5) - (Math.random() * 5);
      gspd[ng] = -G.spd[styp[cN]] + (Math.random() * 5) - (Math.random() * 5);
      gstg[ng] = 1;
      ghit[ng] = 0;
      ng++;
      if (ng == 192) {
       ng = 0;
      }
     }
     if (GM.cNm[cN] == "EL KING-OF-WAR") {
      gx[ng] = (a.x + (240 * M.sin(a.xz) + 172 * M.sin(a.xy)) * r) + (Math.random() * 50) - (Math.random() * 50);
      gy[ng] = (a.y - (172 * M.cos(a.xy)) * r) + (Math.random() * 50) - (Math.random() * 50);
      gz[ng] = (a.z - (240 * M.cos(a.xz) + (240 * M.sin(a.zy))) * r) + (Math.random() * 50) - (Math.random() * 50);
      gxz[ng] = (a.xz - (25 * M.sin(a.xy)) * r) + (Math.random() * 5) - (Math.random() * 5);
      gzy[ng] = (a.zy + (25 * M.cos(a.xy))) + (Math.random() * 5) - (Math.random() * 5);
      gxy[ng] = a.xy + (Math.random() * 5) - (Math.random() * 5);
      gspd[ng] = (G.spd[styp[cN]] + spd) + (Math.random() * 5) - (Math.random() * 5);
      gstg[ng] = 1;
      ghit[ng] = 0;
      ng++;
      if (ng == 192) {
       ng = 0;
      }
     }
     if (GM.cNm[cN] == "F-22 Raptor") {
      gx[ng] = a.x + (196 * M.cos(a.xz) * M.cos(a.xy) + (4 * M.sin(a.xy)));
      gy[ng] = a.y + (196 * M.sin(a.xy) - (4 * M.cos(a.xy))) * r;
      gz[ng] = a.z + (196 * M.sin(a.xz)) * r;
      gxz[ng] = a.xz;
      gzy[ng] = a.zy;
      gxy[ng] = a.xy;
      gspd[ng] = (G.spd[styp[cN]] + spd) + (Math.random() * 50) - (Math.random() * 50);
      gstg[ng] = 1;
      ghit[ng] = 0;
      ng++;
      if (ng == 192) {
       ng = 0;
      }
     }
     if (GM.cNm[cN] == "F-22 Raptor") {
      gx[ng] = a.x - (196 * M.cos(a.xz) * M.cos(a.xy) - (4 * M.sin(a.xy)));
      gy[ng] = a.y - (196 * M.sin(a.xy) + (4 * M.cos(a.xy))) * r;
      gz[ng] = a.z - (196 * M.sin(a.xz)) * r;
      gxz[ng] = a.xz;
      gzy[ng] = a.zy;
      gxy[ng] = a.xy;
      gspd[ng] = (G.spd[styp[cN]] + spd) + (Math.random() * 50) - (Math.random() * 50);
      gstg[ng] = 1;
      ghit[ng] = 0;
      ng++;
      if (ng == 192) {
       ng = 0;
      }
     }
     if (GM.cNm[cN] == "SuperSonic DeathRay") {
      gx[ng] = a.x;
      gy[ng] = a.y - (gny[cN] * M.cos(a.xy) - (gny[cN] * M.sin(a.zy))) * r;
      gz[ng] = a.z;
      gxz[ng] = a.xz;
      gzy[ng] = a.zy;
      gxy[ng] = a.xy;
      gspd[ng] = G.spd[styp[cN]] + spd;
      gstg[ng] = 1;
      ghit[ng] = 0;
      ng++;
      if (ng == 192) {
       ng = 0;
      }
     }
     if (GM.cNm[cN] == "SuperSonic DeathRay") {
      for (c = 0; c < 40; c++) {
       gx[ng] = a.x;
       gy[ng] = a.y - (gny[cN] * M.cos(a.xy) - (gny[cN] * M.sin(a.zy))) * r;
       gz[ng] = a.z;
       gxz[ng] = a.xz;
       gzy[ng] = a.zy;
       gxy[ng] = a.xy;
       gxz[ng] += (Math.random() * 15) - (Math.random() * 15);
       gzy[ng] += (Math.random() * 15) - (Math.random() * 15);
       gxy[ng] += (Math.random() * 15) - (Math.random() * 15);
       gspd[ng] = (G.spd[styp[cN]] + spd) + (Math.random() * 250) - (Math.random() * 250);
       gstg[ng] = 1;
       ghit[ng] = 0;
       ng++;
       if (ng == 192) {
        ng = 0;
       }
      }
     }
     spcl[0] = true;
    } else {
     if (!GM.mutS && styp[cN] != 8 && styp[cN] < 11 && im == GM.im) {
      GM.out.ply(sD_v_o);
     }
     if (styp[cN] == 0) {
      gcnt = 4;
     }
     if (styp[cN] == 1) {
      gcnt = 1;
     }
     if (styp[cN] == 2) {
      gcnt = 5;
     }
     if (styp[cN] == 3) {
      gcnt = 20;
     }
     if (styp[cN] == 4) {
      gcnt = 30;
     }
     if (styp[cN] == 5) {
      gcnt = 1;
     }
     if (styp[cN] == 6 || styp[cN] == 10) {
      gcnt = 50;
     }
     if (styp[cN] == 7 || styp[cN] == 9 || styp[cN] >= 11) {
      gcnt = 0;
     }
    }
   }
  } else {
   gcnt -= GM.zz;
  }
  if (g2cnt <= 0) {
   if (dr.fir[1] && !dest && s2typ[cN] > -1 && !M.nofpwr) {
    if (pwr >= s2los[s2typ[cN]]) {
     if (!GM.mutS) {
      sp2.ply(sD_v_o);
     }
     if (s2typ[cN] == 0) {
      g2cnt = 10;
     }
     if (s2typ[cN] == 1) {
      g2cnt = 1;
     }
     if (s2typ[cN] == 2) {
      g2cnt = 60;
      g2x[ng2] = a.x;
      g2y[ng2] = a.y + (100 * M.cos(a.xy) + (100 * M.sin(a.zy))) * r;
      g2z[ng2] = a.z;
      g2xz[ng2] = a.xz;
      g2zy[ng2] = a.zy;
      g2xy[ng2] = a.xy;
      g2spd[ng2] = 0;
      g2stg[ng2] = 1;
      g2hit[ng2] = 0;
      ng2++;
      if (ng2 == 192) {
       ng2 = 0;
      }
     }
     if (s2typ[cN] == 3) {
      gcnt = 0;
     }
     pwr -= s2los[s2typ[cN]];
     if (GM.cNm[cN] == "EL KING-OF-WAR") {
      g2x[ng2] = a.x + (96 * M.cos(a.xz) * M.cos(a.xy) + (119 * M.sin(a.xy)));
      g2y[ng2] = a.y + (96 * M.sin(a.xy) - (119 * M.cos(a.xy))) * r;
      g2z[ng2] = a.z + (96 * M.sin(a.xz)) * r;
      g2xz[ng2] = a.xz - 5;
      g2zy[ng2] = a.zy;
      g2xy[ng2] = a.xy;
      g2spd[ng2] = G2.spd[s2typ[cN]] + spd;
      g2stg[ng2] = 1;
      g2hit[ng2] = 0;
      ng2++;
      if (ng2 == 192) {
       ng2 = 0;
      }
     }
     if (GM.cNm[cN] == "EL KING-OF-WAR") {
      g2x[ng2] = a.x - (96 * M.cos(a.xz) * M.cos(a.xy) - (119 * M.sin(a.xy)));
      g2y[ng2] = a.y - (96 * M.sin(a.xy) + (119 * M.cos(a.xy))) * r;
      g2z[ng2] = a.z - (96 * M.sin(a.xz)) * r;
      g2xz[ng2] = a.xz + 5;
      g2zy[ng2] = a.zy;
      g2xy[ng2] = a.xy;
      g2spd[ng2] = G2.spd[s2typ[cN]] + spd;
      g2stg[ng2] = 1;
      g2hit[ng2] = 0;
      ng2++;
      if (ng2 == 192) {
       ng2 = 0;
      }
     }
     if (GM.cNm[cN] == "TRAIN of TERROR") {
      g2x[ng2] = a.x;
      g2y[ng2] = a.y + (42 * M.cos(a.xy) + (42 * M.sin(a.zy))) * r;
      g2z[ng2] = a.z;
      g2xz[ng2] = a.xz;
      g2zy[ng2] = a.zy;
      g2xy[ng2] = a.xy;
      g2spd[ng2] = G2.spd[s2typ[cN]] + spd;
      g2stg[ng2] = 1;
      g2hit[ng2] = 0;
      ng2++;
      if (ng2 == 192) {
       ng2 = 0;
      }
     }
     if (GM.cNm[cN] == "TRAIN of TERROR") {
      g2x[ng2] = a.x + (-150 * M.sin(a.xz)) * r;
      g2y[ng2] = a.y + (12 * M.cos(a.xy) + (12 * M.sin(a.zy))) * r;
      g2z[ng2] = a.z - (-150 * M.cos(a.xz)) * r;
      g2xz[ng2] = a.xz + 90;
      g2zy[ng2] = a.zy;
      g2xy[ng2] = a.xy;
      g2spd[ng2] = -G2.spd[s2typ[cN]];
      g2stg[ng2] = 1;
      g2hit[ng2] = 0;
      ng2++;
      if (ng2 == 192) {
       ng2 = 0;
      }
     }
     if (GM.cNm[cN] == "TRAIN of TERROR") {
      g2x[ng2] = a.x + (-150 * M.sin(a.xz)) * r;
      g2y[ng2] = a.y + (12 * M.cos(a.xy) + (12 * M.sin(a.zy))) * r;
      g2z[ng2] = a.z - (-150 * M.cos(a.xz)) * r;
      g2xz[ng2] = a.xz - 90;
      g2zy[ng2] = a.zy;
      g2xy[ng2] = a.xy;
      g2spd[ng2] = -G2.spd[s2typ[cN]];
      g2stg[ng2] = 1;
      g2hit[ng2] = 0;
      ng2++;
      if (ng2 == 192) {
       ng2 = 0;
      }
     }
     if (GM.cNm[cN] == "TRAIN of TERROR") {
      g2x[ng2] = a.x + (170 * M.sin(a.xz)) * r;
      g2y[ng2] = a.y;
      g2z[ng2] = a.z - (170 * M.cos(a.xz)) * r;
      g2xz[ng2] = a.xz;
      g2zy[ng2] = a.zy + (90 * r);
      g2xy[ng2] = a.xy;
      g2spd[ng2] = G2.spd[s2typ[cN]];
      g2stg[ng2] = 1;
      g2hit[ng2] = 0;
      ng2++;
      if (ng2 == 192) {
       ng2 = 0;
      }
     }
     if (GM.cNm[cN] == "TRAIN of TERROR") {
      g2x[ng2] = a.x + (15 * M.cos(a.xz));
      g2y[ng2] = a.y - (100 * M.cos(a.xy) - (100 * M.sin(a.zy))) * r;
      g2z[ng2] = a.z + (15 * M.sin(a.xz));
      g2xz[ng2] = a.xz;
      g2zy[ng2] = a.zy + (14 * r);
      g2xy[ng2] = a.xy;
      g2spd[ng2] = G2.spd[s2typ[cN]] + spd;
      g2stg[ng2] = 1;
      g2hit[ng2] = 0;
      ng2++;
      if (ng2 == 192) {
       ng2 = 0;
      }
     }
     if (GM.cNm[cN] == "TRAIN of TERROR") {
      g2x[ng2] = a.x - (15 * M.cos(a.xz));
      g2y[ng2] = a.y - (100 * M.cos(a.xy) - (100 * M.sin(a.zy))) * r;
      g2z[ng2] = a.z - (15 * M.sin(a.xz));
      g2xz[ng2] = a.xz;
      g2zy[ng2] = a.zy + (14 * r);
      g2xy[ng2] = a.xy;
      g2spd[ng2] = G2.spd[s2typ[cN]] + spd;
      g2stg[ng2] = 1;
      g2hit[ng2] = 0;
      ng2++;
      if (ng2 == 192) {
       ng2 = 0;
      }
     }
     if (GM.cNm[cN] == "TRAIN of TERROR") {
      g2x[ng2] = a.x + (90 * M.sin(a.xz)) * r;
      g2y[ng2] = a.y + (12 * M.cos(a.xy) + (12 * M.sin(a.zy))) * r;
      g2z[ng2] = a.z - (90 * M.cos(a.xz)) * r;
      g2xz[ng2] = a.xz + 90;
      g2zy[ng2] = a.zy;
      g2xy[ng2] = a.xy;
      g2spd[ng2] = -G2.spd[s2typ[cN]];
      g2stg[ng2] = 1;
      g2hit[ng2] = 0;
      ng2++;
      if (ng2 == 192) {
       ng2 = 0;
      }
     }
     if (GM.cNm[cN] == "TRAIN of TERROR") {
      g2x[ng2] = a.x + (90 * M.sin(a.xz)) * r;
      g2y[ng2] = a.y + (12 * M.cos(a.xy) + (12 * M.sin(a.zy))) * r;
      g2z[ng2] = a.z - (90 * M.cos(a.xz)) * r;
      g2xz[ng2] = a.xz - 90;
      g2zy[ng2] = a.zy;
      g2xy[ng2] = a.xy;
      g2spd[ng2] = -G2.spd[s2typ[cN]];
      g2stg[ng2] = 1;
      g2hit[ng2] = 0;
      ng2++;
      if (ng2 == 192) {
       ng2 = 0;
      }
     }
     if (GM.cNm[cN] == "F-22 Raptor") {
      g2x[ng2] = a.x + (130 * M.cos(a.xz) * M.cos(a.xy) - (14 * M.sin(a.xy)));
      g2y[ng2] = a.y + (130 * M.sin(a.xy) + (14 * M.cos(a.xy))) * r;
      g2z[ng2] = a.z + (130 * M.sin(a.xz)) * r;
      g2xz[ng2] = a.xz;
      g2zy[ng2] = a.zy;
      g2xy[ng2] = a.xy;
      g2spd[ng2] = G2.spd[s2typ[cN]] + spd;
      g2stg[ng2] = 1;
      g2hit[ng2] = 0;
      ng2++;
      if (ng2 == 192) {
       ng2 = 0;
      }
     }
     if (GM.cNm[cN] == "F-22 Raptor") {
      g2x[ng2] = a.x - (130 * M.cos(a.xz) * M.cos(a.xy) + (14 * M.sin(a.xy)));
      g2y[ng2] = a.y - (130 * M.sin(a.xy) - (14 * M.cos(a.xy))) * r;
      g2z[ng2] = a.z - (130 * M.sin(a.xz)) * r;
      g2xz[ng2] = a.xz;
      g2zy[ng2] = a.zy;
      g2xy[ng2] = a.xy;
      g2spd[ng2] = G2.spd[s2typ[cN]] + spd;
      g2stg[ng2] = 1;
      g2hit[ng2] = 0;
      ng2++;
      if (ng2 == 192) {
       ng2 = 0;
      }
     }
     if (GM.cNm[cN] == "SuperSonic DeathRay") {
      g2x[ng2] = a.x + (210 * M.cos(a.xz) * M.cos(a.xy) + (40 * M.sin(a.xy)));
      g2y[ng2] = a.y + (210 * M.sin(a.xy) - (40 * M.cos(a.xy))) * r;
      g2z[ng2] = a.z + (210 * M.sin(a.xz)) * r;
      g2xz[ng2] = a.xz;
      g2zy[ng2] = a.zy;
      g2xy[ng2] = a.xy;
      g2spd[ng2] = (G2.spd[s2typ[cN]] + spd) - (Math.random() * 500);
      g2stg[ng2] = 1;
      g2hit[ng2] = 0;
      ng2++;
      if (ng2 == 192) {
       ng2 = 0;
      }
     }
     if (GM.cNm[cN] == "SuperSonic DeathRay") {
      g2x[ng2] = a.x - (210 * M.cos(a.xz) * M.cos(a.xy) - (40 * M.sin(a.xy)));
      g2y[ng2] = a.y - (210 * M.sin(a.xy) + (40 * M.cos(a.xy))) * r;
      g2z[ng2] = a.z - (210 * M.sin(a.xz)) * r;
      g2xz[ng2] = a.xz;
      g2zy[ng2] = a.zy;
      g2xy[ng2] = a.xy;
      g2spd[ng2] = (G2.spd[s2typ[cN]] + spd) - (Math.random() * 500);
      g2stg[ng2] = 1;
      g2hit[ng2] = 0;
      ng2++;
      if (ng2 == 192) {
       ng2 = 0;
      }
     }
     if (GM.cNm[cN] == "SuperSonic DeathRay") {
      g2x[ng2] = a.x + (300 * M.cos(a.xz) * M.cos(a.xy) + (40 * M.sin(a.xy)));
      g2y[ng2] = a.y + (300 * M.sin(a.xy) - (40 * M.cos(a.xy))) * r;
      g2z[ng2] = a.z + (300 * M.sin(a.xz)) * r;
      g2xz[ng2] = a.xz;
      g2zy[ng2] = a.zy;
      g2xy[ng2] = a.xy;
      g2spd[ng2] = (G2.spd[s2typ[cN]] + spd) - (Math.random() * 500);
      g2stg[ng2] = 1;
      g2hit[ng2] = 0;
      ng2++;
      if (ng2 == 192) {
       ng2 = 0;
      }
     }
     if (GM.cNm[cN] == "SuperSonic DeathRay") {
      g2x[ng2] = a.x - (300 * M.cos(a.xz) * M.cos(a.xy) - (40 * M.sin(a.xy)));
      g2y[ng2] = a.y - (300 * M.sin(a.xy) + (40 * M.cos(a.xy))) * r;
      g2z[ng2] = a.z - (300 * M.sin(a.xz)) * r;
      g2xz[ng2] = a.xz;
      g2zy[ng2] = a.zy;
      g2xy[ng2] = a.xy;
      g2spd[ng2] = (G2.spd[s2typ[cN]] + spd) - (Math.random() * 500);
      g2stg[ng2] = 1;
      g2hit[ng2] = 0;
      ng2++;
      if (ng2 == 192) {
       ng2 = 0;
      }
     }
     if (GM.cNm[cN] == "Gun Turret") {
      g2x[ng2] = a.x + (89 * M.cos(a.xz));
      g2y[ng2] = a.y;
      g2z[ng2] = a.z + (89 * M.sin(a.xz));
      g2xz[ng2] = a.xz;
      g2zy[ng2] = a.zy;
      g2xy[ng2] = a.xy;
      g2spd[ng2] = G2.spd[s2typ[cN]] + spd;
      g2stg[ng2] = 1;
      g2hit[ng2] = 0;
      ng2++;
      if (ng2 == 192) {
       ng2 = 0;
      }
     }
     if (GM.cNm[cN] == "Gun Turret") {
      g2x[ng2] = a.x - (89 * M.cos(a.xz));
      g2y[ng2] = a.y;
      g2z[ng2] = a.z - (89 * M.sin(a.xz));
      g2xz[ng2] = a.xz;
      g2zy[ng2] = a.zy;
      g2xy[ng2] = a.xy;
      g2spd[ng2] = G2.spd[s2typ[cN]] + spd;
      g2stg[ng2] = 1;
      g2hit[ng2] = 0;
      ng2++;
      if (ng2 == 192) {
       ng2 = 0;
      }
     }
    } else {
     if (!GM.mutS && s2typ[cN] != 3 && im == GM.im) {
      GM.out.ply(sD_v_o);
     }
     if (s2typ[cN] == 0) {
      g2cnt = 10;
     }
     if (s2typ[cN] == 1) {
      g2cnt = 1;
     }
     if (s2typ[cN] == 2) {
      g2cnt = 40;
     }
     if (s2typ[cN] == 3) {
      g2cnt = 0;
     }
    }
   }
  } else {
   g2cnt -= GM.zz;
  }
  for (c = 0; c < 192; c++) {
   if (gstg[c] != 0 && styp[cN] >= 0) {
    if (gy[c] > 250 && ghit[c] == 0 && styp[cN] < 11) {
     ghit[c] = 1;
    }
    if (ghit[c] == 0) {
     gx[c] -= gspd[c] * (M.sin(gxz[c]) * M.cos(gzy[c])) * GM.zz;
     gz[c] += gspd[c] * (M.cos(gxz[c]) * M.cos(gzy[c])) * GM.zz;
     gy[c] -= gspd[c] * M.sin(gzy[c]) * GM.zz;
     gstg[c]++;
     if (GM.cNm[cN] == "Lightning Rod" && gstg[c] > 2) {
      gstg[c] = 0;
     }
    }
   }
   sD_v_trj[c] = Math.sqrt(Math.sqrt(GM.x_y_z(gx[c] * .01, (M.x + M.cx) * .01, gy[c] * .01, (M.y + M.cy) * .01, gz[c] * .01, (M.z + M.cz) * .01)));
   if (styp[cN] == 4 && ghit[c] == 1) {
    ex[nex] = gx[c];
    ey[nex] = gy[c];
    ez[nex] = gz[c];
    exz[nex] = gxz[c];
    ezy[nex] = gzy[c];
    exy[nex] = gxy[c];
    exspd[nex] = gspd[c];
    estg[nex] = 1;
    ehit[nex] = 0;
    nex++;
    if (nex == 12) {
     nex = 0;
    }
    if (!GM.mutS) {
     hit[(int) (Math.random() * 3)].ply(sD_v_trj[c]);
    }
   }
   if (g2stg[c] != 0 && s2typ[cN] >= 0) {
    if (s2typ[cN] != 2 && g2y[c] > 250 && g2hit[c] == 0) {
     g2hit[c] = 1;
    }
    if (g2hit[c] == 0) {
     g2x[c] -= g2spd[c] * (M.sin(g2xz[c]) * M.cos(g2zy[c])) * GM.zz;
     g2z[c] += g2spd[c] * (M.cos(g2xz[c]) * M.cos(g2zy[c])) * GM.zz;
     g2y[c] -= g2spd[c] * M.sin(g2zy[c]) * GM.zz;
     g2stg[c]++;
    }
    sD_v_trj[c] = Math.sqrt(Math.sqrt(GM.x_y_z(g2x[c] * .01, (M.x + M.cx) * .01, g2y[c] * .01, (M.y + M.cy) * .01, g2z[c] * .01, (M.z + M.cz) * .01)));
    if (s2typ[cN] == 2 && g2hit[c] == 1) {
     for (b = 0; b < 4; b++) {
      ex[nex] = g2x[c] + (Math.random() * 2000) - (Math.random() * 2000);
      ey[nex] = g2y[c] + (Math.random() * 2000) - (Math.random() * 2000);
      ez[nex] = g2z[c] + (Math.random() * 2000) - (Math.random() * 2000);
      exz[nex] = g2xz[c];
      ezy[nex] = g2zy[c];
      exy[nex] = g2xy[c];
      exspd[nex] = g2spd[c];
      estg[nex] = 1;
      ehit[nex] = 0;
      nex++;
      if (nex == 12) {
       nex = 0;
      }
     }
     if (!GM.mutS) {
      hit[(int) (Math.random() * 3)].ply(sD_v_trj[c]);
     }
    }
    if (s2typ[cN] == 3 && g2hit[c] == 1) {
     ex[nex] = g2x[c];
     ey[nex] = g2y[c];
     ez[nex] = g2z[c];
     exz[nex] = g2xz[c];
     ezy[nex] = g2zy[c];
     exy[nex] = g2xy[c];
     exspd[nex] = g2spd[c];
     estg[nex] = 1;
     ehit[nex] = 0;
     nex++;
     if (nex == 12) {
      nex = 0;
     }
     if (!GM.mutS) {
      hit[(int) (Math.random() * 3)].ply(sD_v_trj[c]);
     }
    }
   }
  }
  if (dam > dura[cN] && !dest) {
   if (GM.cNm[cN] == "EL KING-OF-WAR") {
    ex[nex] = a.x + (Math.random() * 150) - (Math.random() * 150);
    ey[nex] = a.y + (Math.random() * 150) - (Math.random() * 150);
    ez[nex] = a.z + (Math.random() * 150) - (Math.random() * 150);
    exz[nex] = a.xz;
    ezy[nex] = a.zy;
    exy[nex] = a.xy;
    exspd[nex] = spd;
    estg[nex] = 1;
    ehit[nex] = 0;
    nex++;
    if (nex == 12) {
     nex = 0;
    }
    if (!GM.mutS) {
     exp[(int) (Math.random() * 2)].ply(sD_v_o);
    }
   }
   if (GM.cNm[cN] == "Tactical Nuke") {
    ex[nex] = a.x;
    ey[nex] = a.y;
    ez[nex] = a.z;
    exz[nex] = a.xz;
    ezy[nex] = a.zy;
    exy[nex] = a.xy;
    exspd[nex] = spd;
    estg[nex] = 1;
    ehit[nex] = 0;
    nex++;
    if (nex == 12) {
     nex = 0;
    }
   }
  }
  for (c = 0; c < 12; c++) {
   if (estg[c] != 0 && extyp[cN] > -1) {
    if (ey[c] > 250 && ehit[c] == 0) {
     ehit[c] = 1;
    }
    if (ehit[c] == 0) {
     ex[c] -= exspd[c] * (M.sin(exz[c]) * M.cos(ezy[c]));
     ez[c] += exspd[c] * (M.cos(exz[c]) * M.cos(ezy[c]));
     ey[c] -= exspd[c] * M.sin(ezy[c]);
     estg[c]++;
     if (estg[c] > E.drtn[extyp[cN]]) {
      estg[c] = 0;
     }
    }
   }
  }
  if (!(GM.cNm[cN] == "Turbo Prop" || GM.cNm[cN] == "A-1") && M.grv[GM.stg] != 0) {
   spd -= spd * Math.abs(spd) * .0000001 * GM.zz;
  }
  if (GM.stg == 40) {
   if (Math.abs(a.x) > 5000) {
    vx[(int) (Math.random() * 4)] = 0;
    vz[(int) (Math.random() * 4)] = 0;
    a.x = Math.max(-5000, Math.min(a.x, 5000));
   }
   if (Math.abs(a.y) > 5000) {
    vy[(int) (Math.random() * 4)] = 0;
    a.y = Math.max(-5000, Math.min(a.y, 5000));
   }
   if (Math.abs(a.z) > 1000000) {
    vx[(int) (Math.random() * 4)] = 0;
    vz[(int) (Math.random() * 4)] = 0;
    a.z = Math.max(-1000000, Math.min(a.z, 1000000));
   }
  }
  if (GM.stg == 67) {
   a.y = Math.max(-2000, Math.min(a.y, 2000));
   a.z = Math.max(-18500, Math.min(a.z, 12500));
   a.x = Math.max(-19500, Math.min(a.x, 14500));
  }
  if (fas > 0) {
   if (dest || (typ[cN] != 1 && fas == 2) || (typ[cN] != 0 && fas == 1)) {
    fas = -1;
   }
  }
  dam = Math.min(dam, dura[cN] + 1);
  if (pwr < 100 && xtpwr > pwr) {
   xtpwr = pwr;
  }
  if (xtpwr < pwr) {
   xtpwr = pwr;
  }
  pwr = Math.max(0, Math.min(pwr, 100));
  if (fas == 0 && typ[cN] == 0) {
   while (true) {
    if (Math.abs(a.xz - cxz) <= 180) {
     break;
    }
    if (cxz > a.xz) {
     cxz -= 360;
    } else if (cxz < a.xz) {
     cxz += 360;
    }
   }
   cxz += (a.xz - cxz) * .25 * Math.pow(GM.zz, .75);
  }
  if (a.zy < -180) {
   a.zy += 360;
  }
  if (a.zy > 180) {
   a.zy -= 360;
  }
  if (a.xy < -180) {
   a.xy += 360;
  }
  if (a.xy > 180) {
   a.xy -= 360;
  }
  if (a.xz < -180) {
   a.xz += 360;
  }
  if (a.xz > 180) {
   a.xz -= 360;
  }
  if (txz != a.xz) {
   txz = a.xz;
  }
  if (tzy != a.zy) {
   tzy = a.zy;
  }
 }

 void xtra(Act a, Dir d) {
  int c;
  sD_v_o = Math.sqrt(Math.sqrt(GM.x_y_z(GM.opx[im] * .01, (M.x + M.cx) * .01, GM.opy[im] * .01, (M.y + M.cy) * .01, GM.opz[im] * .01, (M.z + M.cz) * .01)));
  if (a.fcnt > 0) {
   dam = 0;
   dcnt = 0;
   dest = false;
   newcr = true;
  } else {
   for (c = 0; c < GM.nF; c++) {
    if (!GM.ang[c]) {
     if (Math.abs(a.x - GM.fx[c]) <= 500 && Math.abs(a.y - GM.fy[c]) <= 500 && Math.abs(a.z - GM.fz[c]) <= 200 + (Math.abs(vz[0] + vz[1] + vz[2] + vz[3]) * .25 * GM.zz)) {
      a.fix = true;
      if (!GM.mutS && GM.fas == "go" && GM.cntd <= 0) {
       fix.ply(sD_v_o);
      }
     }
    }
    if (GM.ang[c]) {
     if (Math.abs(a.y - GM.fy[c]) <= 500 && Math.abs(a.z - GM.fz[c]) <= 500 && Math.abs(a.x - GM.fx[c]) <= 200 + (Math.abs(vx[0] + vx[1] + vx[2] + vx[3]) * .25 * GM.zz)) {
      a.fix = true;
      if (!GM.mutS && GM.fas == "go" && GM.cntd <= 0) {
       fix.ply(sD_v_o);
      }
     }
    }
   }
   if (M.imrtl && dest) {
    a.fix = true;
    if (!GM.mutS && GM.fas == "go" && GM.cntd <= 0) {
     fix.ply(sD_v_o);
    }
   }
  }
  a.smk(siz[cN] * siz[cN], emit[cN] * .5, dam, dura[cN]);
  if (!dest && (engn[cN] == 6 || engn[cN] == 9 || (d.bost && bost[cN] > 0 && pwr > 1))) {
   a.jet(siz[cN] * siz[cN], emit[cN]);
  }
  if (GM.fas != "go") {
   for (c = 0; c < a.np; c++) {
    if (a.P[c].chip > 0) {
     a.P[c].chip--;
    }
    a.P[c].vx = 0;
    a.P[c].vy = 0;
    a.P[c].vz = 0;
   }
  } else if (engn[cN] == 8 && GM.cntd > 0 && GM.cntd < 39) {
   if (Math.random() < .5) {
    if (Math.random() < .5) {
     a.xy++;
    }
   } else {
    if (Math.random() < .5) {
     a.xy--;
    }
   }
   a.xy = Math.max(-1, Math.min((a.xy), 1));
  }
  for (c = 0; c < a.np; c++) {
   if (a.P[c].flyn != (fas == 2)) {
    a.P[c].flyn = fas == 2;
   }
   if (GM.cNm[cN] == "The Phantom") {
    if (spcl[0] && Math.random() < .5) {
     a.P[c].phntm = true;
    } else if (!spcl[0]) {
     sp.stp();
     a.P[c].phntm = false;
    }
   }
  }
  if (GM.end < 1) {
   if (scspd < 250) {
    spdm = 2;
   }
   if (scspd >= 250) {
    spdm = 3;
   }
   if (scspd >= 500) {
    spdm = 4;
   }
   if (scspd >= 1000) {
    spdm = 5;
   }
   if (GM.fas == "go" && GM.cntd < 35 && dcnt < 8 && !GM.mutS) {
    if (vcnt <= 0 && (GM.cNm[cN] == "EL KING-OF-WAR" || GM.cNm[cN] == "TRAIN of TERROR") && (d.up || d.down) && Math.abs(spd) < 1) {
     if (GM.cNm[cN] == "EL KING-OF-WAR") {
      ch[(int) (Math.random() * 5)].ply(sD_v_o);
      ch[(int) (Math.random() * 5)].ply(sD_v_o);
     } else {
      ch[(int) (Math.random() * 4)].ply(sD_v_o);
      ch[(int) (Math.random() * 4)].ply(sD_v_o);
     }
     vcnt = 22;
    }
    if (fas == 2 && vcnt <= 0 && GM.cNm[cN] != "Tactical Nuke" && (d.up || d.down || d.left || d.riht)) {
     fly[(int) (Math.random() * 2)].ply(sD_v_o);
     vcnt = 8;
    }
    if (GM.cntd <= 0 && (d.up || d.down) && fas < 1 && typ[cN] != 2) {
     if (spd == 0) {
      c = 0;
      if (typ[cN] == 0 && ttyp[cN] == 0 && fas < 1 && (d.left || d.riht)) {
       c = 1;
      }
      engo(c);
     }
     int v;
     if (pwr >= 100 || spd > spds[cN][2]) {
      if (!(flp && fas == 0) && (engn[cN] == 6 || engn[cN] == 9 || engn[cN] == 12) && d.up) {
       engo(4);
      } else {
       v = 3;
       if (Math.abs(spd) > spds[cN][2] * .75) {
        v = 4;
       }
       engo(v);
      }
     } else {
      if (Math.abs(spd) > 0 && Math.abs(spd) <= spds[cN][0]) {
       v = (int) ((3 * Math.abs(spd) / spds[cN][0]) + 1);
       if (v == 3) {
        if (wait < 1) {
         v = 1;
        } else {
         wait--;
        }
       } else {
        wait = 7;
       }
       engo(v);
      }
      if (Math.abs(spd) > spds[cN][0] && Math.abs(spd) <= spds[cN][1]) {
       v = (int) ((3 * (Math.abs(spd) - spds[cN][0])) / (spds[cN][1] - spds[cN][0]) + 1);
       if (v == 3) {
        if (wait < 1) {
         v = 1;
        } else {
         wait--;
        }
       } else {
        wait = 7;
       }
       engo(v);
      }
      if (Math.abs(spd) > spds[cN][1] && Math.abs(spd) <= spds[cN][2]) {
       v = (int) ((3 * (Math.abs(spd) - spds[cN][1])) / (spds[cN][2] - spds[cN][1]) + 1);
       engo(v);
      }
     }
     if (((d.up && spd < 10) || (d.down && spd > -10)) && rev[cN] == 0 && !m[5].clp.isRunning()) {
      m[5].ply(sD_v_o);
     }
     if (fas == 0 && (Math.abs(vz[(int) (Math.random() * 4)] - (vz[0] + vz[1] + vz[2] + vz[3]) * .25) > 1 || Math.abs(vx[(int) (Math.random() * 4)] - (vx[0] + vx[1] + vx[2] + vx[3]) * .25) > 1) && vcnt <= 0 && rev[cN] == 0) {
      m[(int) (Math.random() * 5)].ply(sD_v_o);
      vcnt = 7;
     }
     grd = false;
    } else if (typ[cN] != 2) {
     wait = 15;
     if (fas > 0 && !grd) {
      m[(int) (Math.random() * 4)].ply(sD_v_o);
      grd = true;
     }
     c = 0;
     if (typ[cN] == 0 && ttyp[cN] == 0 && fas < 1 && (d.left || d.riht)) {
      c = 1;
     }
     engo(c);
    }
    if (!GM.mutS) {
     if (dcnt > 0 && dcnt < 1) {
      wst[0].ply(sD_v_o);
     }
     if (dcnt > 6 && !dest) {
      wst[1].ply(sD_v_o);
     }
    }
   } else if (typ[cN] != 2) {
    engo(-1);
   }
   if (bost[cN] > 0) {
    if (d.bost && GM.fas == "go" && !dest && (pwr > 1 || GM.cNm[cN] == "F-22 Raptor")) {
     if (!GM.mutS) {
      f[((int) (Math.random() * 2) + 3)].ply(sD_v_o);
     }
     if (!GM.mutS) {
      sb.lop(sD_v_o);
     }
    } else {
     sb.stp();
    }
   }
   scspd = Math.sqrt(Math.pow(nvx, 2) + Math.pow(nvy, 2) + Math.pow(nvz, 2));
   fcnt += Math.random() * scspd * .0625 * GM.zz;
   if (typ[cN] == 2 && GM.fas == "go") {
    if (vcnt <= 0 && (d.left || d.riht || d.up || d.down) && !(GM.mutS || dest)) {
     trt[1].lop(sD_v_o);
    }
    if (!(d.left || d.riht || d.up || d.down) || dest) {
     trt[1].stp();
    }
   }
   if (GM.fas == "go" && fas == 0 && (d.left || d.riht) && !(GM.mutS || flp) && spdm < 3 && ttyp[cN] == 0 && typ[cN] != 2) {
    f[(int) (Math.random() * 2)].ply(sD_v_o);
    fcnt = 0;
   }
   if (GM.fas == "go" && Math.abs(fcnt) > 50) {
    if (!GM.mutS) {
     f[(int) (Math.random() * spdm)].ply(sD_v_o);
    }
    fcnt = 0;
   }
   if (vcnt > 0) {
    vcnt -= GM.zz;
   }
   if (crshn > 0) {
    crshn -= GM.zz;
   }
   if (scrpn > 0) {
    scrpn -= GM.zz;
   }
   if (skdn > 0) {
    skdn -= GM.zz;
   }
   if (lndn > 0) {
    lndn -= GM.zz;
   }
   if (!GM.mutM) {
    if (GM.trk == null) {
     GM.gtm(GM.stg + "");
    }
    if (GM.fas == "go") {
     GM.trk.lop();
    }
   }
   if (!dest || GM.fas != "go" || GM.mutS) {
    brn[0].stp();
    brn[1].stp();
   }
   if (typ[cN] == 2) {
    if (GM.fas == "go" && GM.cntd < 36 && !(GM.mutS || dest)) {
     trt[0].lop(sD_v_o);
    } else {
     trt[0].stp();
    }
   }
  }
  if (GM.fas != "go") {
   stpS();
  }
 }

 void engo(int c) {
  for (int e = 0; e < 5; e++) {
   if (eng[e] != eng[Math.max(c, 0)] || GM.fas != "go" || c < 0) {
    eng[e].stp();
   }
  }
  if (c > -1) {
   eng[c].lop(sD_v_o);
  }
 }

 void crsh(double f) {
  if (crshn < 1) {
   if (Math.random() < .5) {
    vsnd += Math.max(1, Math.random() * 2);
   } else {
    vsnd -= Math.max(1, Math.random() * 2);
   }
   if (vsnd > 2) {
    vsnd = 0;
   }
   if (vsnd < 0) {
    vsnd = 2;
   }
   if (Math.abs(f) > 30) {
    crash[vsnd].ply(sD_v_o);
   } else {
    crsh[vsnd].ply(sD_v_o);
   }
   if (GM.cNm[cN] == "OW SLAMINARO") {
    lnd.ply(sD_v_o);
   }
   crshn = 2;
  }
 }

 void lnd(Act a) {
  if (lndn < 1) {
   if ((Math.abs(a.zy) < 30 && Math.abs(a.xy) < 30) || (Math.abs(a.zy) > 150 && Math.abs(a.xy) > 150)) {
    if (lndtyp[cN] == 2) {
     crash[(int) (Math.random() * 3)].ply(sD_v_o);
    } else {
     lnd.ply(sD_v_o);
    }
   } else {
    if (lndtyp[cN] == 2) {
     crash[(int) (Math.random() * 3)].ply(sD_v_o);
    } else {
     crsh[(int) (Math.random() * 3)].ply(sD_v_o);
    }
   }
   lndn = 5;
  }
 }

 void skd(long sk, double d) {
  if (skdn <= 0 && (Math.abs(d) > 10 + Math.random() * 5 || Math.abs(spd) > 300 + Math.random() * 500)) {
   if (Math.random() < .5) {
    vsnd += Math.max(1, Math.random() * 2);
   } else {
    vsnd -= Math.max(1, Math.random() * 2);
   }
   if (vsnd > 2) {
    vsnd = 0;
   }
   if (vsnd < 0) {
    vsnd = 2;
   }
   if (sk < 1) {
    skd[vsnd].ply(sD_v_o);
   } else {
    skd[vsnd + 3].ply(sD_v_o);
   }
   skdn = 5 + (Math.random() * 5);
  }
 }

 void scr(double cvx, double cvy, double cvz) {
  if (scrpn < 1 && Math.sqrt(Math.pow(cvx, 2) + Math.pow(cvy, 2) + Math.pow(cvz, 2)) > 100) {
   if (Math.random() < .5) {
    vsnd += Math.max(1, Math.random() * 2);
   } else {
    vsnd -= Math.max(1, Math.random() * 2);
   }
   if (vsnd > 2) {
    vsnd = 0;
   }
   if (vsnd < 0) {
    vsnd = 2;
   }
   scr[vsnd].ply(sD_v_o);
   scrpn = 5;
  }
 }

 void gscr(double cvx, double cvy, double cvz) {
  if (scrpn < 1 && Math.sqrt(Math.pow(cvx, 2) + Math.pow(cvy, 2) + Math.pow(cvz, 2)) > 150) {
   scr[((int) (Math.random() * 2) + 3)].ply(sD_v_o);
   scrpn = 6;
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
    if (s.equals("fix" + fil)) {
     fix = new Sound(ab, GM);
    }
    if (bost[cN] > 0 && s.equals("sb" + fil)) {
     sb = new Sound(ab, GM);
    }
    if (s.equals("stb" + fil)) {
     stb = new Sound(ab, GM);
    }
    if (s.equals("s" + styp[cN] + fil)) {
     sp = new Sound(ab, GM);
    }
    if (s.equals("2s" + s2typ[cN] + fil)) {
     sp2 = new Sound(ab, GM);
    }
    if (lndtyp[cN] < 2 && s.equals("lnd" + lndtyp[cN] + fil)) {
     lnd = new Sound(ab, GM);
    }
    int b;
    for (b = 0; b < 2; b++) {
     if (s.equals("exp" + b + fil)) {
      exp[b] = new Sound(ab, GM);
     }
     if (typ[cN] == 1 && GM.cNm[cN] != "Tactical Nuke" && s.equals("fly" + b + fil)) {
      fly[b] = new Sound(ab, GM);
     }
     if (s.equals("wst" + b + fil)) {
      wst[b] = new Sound(ab, GM);
     }
     if (s.equals("brn" + b + fil)) {
      brn[b] = new Sound(ab, GM);
     }
     if (GM.cNm[cN] == "KILL-O-MATIC" && s.equals("kilo" + b + fil)) {
      kilo[b] = new Sound(ab, GM);
     }
     if (GM.cNm[cN] == "Tactical Nuke" && s.equals("nuk" + b + fil)) {
      nuk[b] = new Sound(ab, GM);
     }
     if (typ[cN] == 2 && s.equals("trt" + b + fil)) {
      trt[b] = new Sound(ab, GM);
     }
    }
    for (b = 0; b < 3; b++) {
     if (s.equals("crsh" + b + fil)) {
      crsh[b] = new Sound(ab, GM);
     }
     if (s.equals("crash" + b + fil)) {
      crash[b] = new Sound(ab, GM);
     }
    }
    for (b = 0; b < 5; b++) {
     if (typ[cN] != 2 && s.equals(engn[cN] + "" + b + "" + fil)) {
      eng[b] = new Sound(ab, GM);
     }
     if (s.equals("f" + b + fil)) {
      f[b] = new Sound(ab, GM);
     }
     if ((GM.cNm[cN] == "EL KING-OF-WAR" || GM.cNm[cN] == "TRAIN of TERROR") && s.equals("ch" + b + fil)) {
      ch[b] = new Sound(ab, GM);
     }
    }
    for (b = 0; b < 6; b++) {
     if (typ[cN] != 2 && s.equals("m" + b + fil)) {
      m[b] = new Sound(ab, GM);
     }
     if (s.equals("skd" + b + fil)) {
      skd[b] = new Sound(ab, GM);
     }
     if (s.equals("scr" + b + fil)) {
      scr[b] = new Sound(ab, GM);
     }
    }
    for (b = 0; b < 9; b++) {
     if (s.equals("hit" + b + fil)) {
      hit[b] = new Sound(ab, GM);
     }
    }
    for (b = 0; b < 10; b++) {
     if (s.equals("ht" + b + fil)) {
      ht[b] = new Sound(ab, GM);
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

 void stpS() {
  if (GM.trk != null) {
   GM.trk.stp();
  }
  GM.cnt[0].stp();
  GM.cnt[1].stp();
  if (GM.cNm[cN] == "The Phantom") {
   sp.stp();
  }
  int n;
  if (typ[cN] == 2) {
   trt[0].stp();
   trt[1].stp();
  } else {
   for (n = 0; n < 5; n++) {
    eng[n].stp();
   }
  }
 }

 void ds(Graphics2D g) {
  for (int s = 0; s < 192; s++) {
   if (gstg[s] > 0) {
    G.d(g, styp[cN], gx[s], gy[s], gz[s], gxz[s], gzy[s], gxy[s], ghit[s]);
    if (ghit[s] != 0) {
     ghit[s]++;
     if (ghit[s] > 2) {
      gstg[s] = 0;
     }
    }
   }
  }
 }

 void ds2(Graphics2D g) {
  for (int s = 0; s < 192; s++) {
   if (g2stg[s] > 0) {
    G2.d(g, s2typ[cN], g2x[s], g2y[s], g2z[s], g2xz[s], g2zy[s], g2xy[s], g2hit[s]);
    if (g2hit[s] != 0) {
     g2hit[s]++;
     if (g2hit[s] > 2) {
      g2stg[s] = 0;
     }
    }
   }
  }
 }

 void dexp(Graphics2D g) {
  for (int e = 0; e < 12; e++) {
   if (estg[e] > 0) {
    E.d(g, extyp[cN], ex[e], ey[e], ez[e], exz[e], ezy[e], exy[e], ehit[e]);
    if (ehit[e] != 0) {
     ehit[e]++;
     if (ehit[e] > 2) {
      estg[e] = 0;
     }
    }
   }
  }
 }

 void db(Graphics2D gs, Act a) {
  if (typ[cN] == 2) {
   T.d(gs, a.x, 128 + a.y, a.z);
  }
 }
}
