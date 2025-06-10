import java.awt.Color;

public class Madness {
   Medium m;
   Record rpd;
   xtGraphics xt;
   int cn;
   int im;
   int mxz;
   int cxz;
   float[][] acelf = new float[][]{
      {11.0F, 5.0F, 3.0F},
      {8.0F, 7.0F, 5.0F},
      {10.0F, 5.0F, 3.5F},
      {11.0F, 6.0F, 3.5F},
      {10.0F, 5.0F, 3.5F},
      {12.0F, 6.0F, 3.0F},
      {7.0F, 9.0F, 4.0F},
      {9.0F, 5.0F, 3.0F},
      {11.0F, 7.0F, 4.0F},
      {12.0F, 6.0F, 3.5F},
      {11.0F, 5.0F, 3.0F},
      {22.0F, 14.0F, 10.0F},
      {10.0F, 7.0F, 3.5F},
      {11.0F, 6.0F, 3.5F},
      {10.0F, 5.0F, 3.5F},
      {11.0F, 6.0F, 3.5F},
      {10.0F, 7.0F, 3.0F},
      {7.0F, 9.0F, 4.0F},
      {10.0F, 10.0F, 10.0F},
      {9.0F, 6.0F, 3.0F},
      {9.0F, 6.0F, 3.0F},
      {9.0F, 6.0F, 3.0F},
      {12.0F, 10.0F, 10.0F},
      {20.0F, 20.0F, 20.0F},
      {5.0F, 5.0F, 5.0F},
      {20.0F, 20.0F, 20.0F},
      {3.0F, 3.0F, 3.0F},
      {9.0F, 10.0F, 6.0F},
      {22.0F, 14.0F, 14.0F},
      {30.0F, 30.0F, 30.0F}
   };
   int[][] swits = new int[][]{
      {50, 180, 280},
      {50, 200, 310},
      {60, 180, 275},
      {70, 190, 295},
      {70, 170, 275},
      {60, 200, 290},
      {60, 170, 280},
      {50, 160, 270},
      {80, 200, 300},
      {70, 210, 290},
      {50, 180, 282},
      {50, 200, 400},
      {60, 180, 280},
      {70, 250, 340},
      {70, 170, 1000},
      {70, 190, 350},
      {60, 250, 325},
      {60, 170, 290},
      {60, 170, 278},
      {60, 170, 280},
      {60, 170, 270},
      {50, 160, 250},
      {70, 210, 285},
      {80, 200, 300},
      {80, 200, 317},
      {80, 200, 317},
      {200, 200, 200},
      {50, 160, 875},
      {80, 200, 1000},
      {70, 210, 320}
   };
   int[] handb = new int[]{7, 10, 7, 15, 12, 8, 9, 10, 7, 7, 7, 20, 14, 15, 30, 15, 18, 30, 14, 10, 10, 10, 17, 30, 6, 30, 3, 10, 30, 60, 7};
   float[] airs = new float[]{
      1.0F,
      1.2F,
      0.95F,
      1.0F,
      1.5F,
      1.0F,
      0.9F,
      0.8F,
      1.3F,
      1.0F,
      1.0F,
      1.2F,
      0.95F,
      1.0F,
      1.5F,
      1.2F,
      1.25F,
      1.0F,
      0.9F,
      1.5F,
      1.0F,
      0.8F,
      1.0F,
      2.0F,
      0.8F,
      0.8F,
      0.3F,
      0.8F,
      2.0F,
      2.0F
   };
   int[] airc = new int[]{70, 30, 40, 40, 30, 50, 40, 10, 100, 60, 70, 30, 50, 40, 600, 0, 75, 40, 40, 0, 25, 10, 64, 200, 50, 50, 0, 10, 100, 60};
   float[] drag = new float[]{
      0.5F,
      0.5F,
      0.5F,
      0.5F,
      0.5F,
      0.5F,
      0.5F,
      0.5F,
      0.5F,
      0.5F,
      0.5F,
      0.5F,
      0.5F,
      0.5F,
      0.0F,
      0.5F,
      0.5F,
      0.5F,
      0.45F,
      0.5F,
      0.5F,
      0.25F,
      0.475F,
      0.5F,
      0.5F,
      0.5F,
      0.1F,
      0.5F,
      0.5F,
      0.375F
   };
   int[] turn = new int[]{6, 9, 5, 7, 6, 7, 5, 4, 7, 6, 8, 14, 6, 9, 100, 13, 11, 13, 6, 10, 10, 10, 12, 7, 8, 8, 4, 4, 100, 100};
   float[] grip = new float[]{
      20.0F,
      27.0F,
      18.0F,
      22.0F,
      15.0F,
      20.0F,
      25.0F,
      25.0F,
      25.0F,
      27.0F,
      20.0F,
      50.0F,
      22.0F,
      22.0F,
      Float.POSITIVE_INFINITY,
      32.0F,
      30.0F,
      30.0F,
      27.0F,
      39.0F,
      39.0F,
      39.0F,
      34.0F,
      25.0F,
      35.0F,
      35.0F,
      Float.POSITIVE_INFINITY,
      25.0F,
      100.0F,
      Float.POSITIVE_INFINITY
   };
   float[] bounce = new float[]{
      1.2F,
      1.05F,
      1.3F,
      1.15F,
      1.3F,
      1.2F,
      1.15F,
      0.8F,
      1.1F,
      1.15F,
      1.2F,
      0.8F,
      1.25F,
      1.15F,
      0.3F,
      1.15F,
      1.3F,
      0.8F,
      1.15F,
      1.25F,
      0.8F,
      0.8F,
      1.4F,
      0.8F,
      0.8F,
      0.8F,
      0.3F,
      0.8F,
      1.1F,
      1.15F
   };
   float[] simag = new float[]{
      0.9F,
      0.85F,
      1.05F,
      0.9F,
      0.85F,
      0.9F,
      1.05F,
      1.1F,
      0.9F,
      1.15F,
      0.9F,
      0.85F,
      1.05F,
      0.9F,
      0.01F,
      0.9F,
      0.9F,
      1.05F,
      1.05F,
      1.1F,
      1.1F,
      1.1F,
      1.15F,
      0.9F,
      1.2F,
      1.2F,
      1.5F,
      1.1F,
      0.9F,
      1.15F
   };
   float[] moment = new float[]{
      1.2F,
      0.75F,
      1.4F,
      1.0F,
      0.85F,
      1.25F,
      1.4F,
      2.0F,
      1.5F,
      2.0F,
      1.2F,
      0.75F,
      1.5F,
      1.0F,
      85000.0F,
      1.0F,
      1.25F,
      1.4F,
      1.6F,
      1.0F,
      1.5F,
      4.0F,
      2.0F,
      1.0F,
      1.75F,
      1.0F,
      850.0F,
      2.0F,
      1.5F,
      2.0F
   };
   float[] comprad = new float[]{
      0.5F,
      0.4F,
      0.8F,
      0.5F,
      0.5F,
      0.5F,
      0.5F,
      1.5F,
      0.5F,
      0.8F,
      0.5F,
      0.4F,
      0.8F,
      0.5F,
      1.0F,
      0.5F,
      0.5F,
      0.5F,
      0.5F,
      0.5F,
      0.5F,
      2.0F,
      0.5F,
      10.5F,
      0.5F,
      0.5F,
      7.5F,
      1.5F,
      0.5F,
      0.8F
   };
   int[] push = new int[]{2, 2, 3, 3, 2, 2, 2, 4, 2, 2, 2, 2, 3, 3, Integer.MAX_VALUE, 3, 2, 2, 3, 1, 2, 4, 3, -2, 2, 2, 1, 4, 2, 3};
   int[] revpush = new int[]{2, 3, 2, 2, 2, 2, 2, 1, 2, 1, 2, 3, 2, 2, 0, 2, 2, 2, 2, 1, 1, 1, 1, -2, 1, 1, 0, 1, 2, 1};
   int[] lift = new int[]{0, 30, 0, 20, 0, 30, 0, 0, 30, 0, 0, 30, 0, 20, 100, 30, 30, 0, 0, 10, 10, 10, 0, 60, 15, 15, 0, 0, 30, 0};
   int[] revlift = new int[]{0, 0, 15, 0, 0, 0, 0, 0, 0, 32, 0, 0, 10, 0, 0, 0, 30, 0, 0, 0, 0, 0, 100, 0, 0, 0, 0, 0, 0, 32};
   int[] powerloss = new int[]{
      2500000,
      2500000,
      3500000,
      2500000,
      2500000,
      2500000,
      3200000,
      4500000,
      3000000,
      5500000,
      5200000,
      4000000,
      5700000,
      4200000,
      6500000,
      3000000,
      5000000,
      5500000,
      5000000,
      4000000,
      5000000,
      5500000,
      4500000,
      5500000,
      3500000,
      3500000,
      1000000,
      2500000,
      4100000,
      Integer.MAX_VALUE
   };
   int[] flipy = new int[]{
      -50, -26, -90, -41, -55, -53, -54, -85, -60, -127, -50, -26, -90, -61, -255, -21, -53, -54, -54, -85, -85, -85, -50, -255, -70, -60, -50, -85, -30, -127
   };
   int[] msquash = new int[]{7, 3, 7, 2, 3, 3, 6, 10, 3, 8, 7, 3, 7, 2, 0, 2, 3, 6, 6, 10, 10, 10, 0, 3, 3, 3, 1, 10, 3, 0};
   int[] clrad = new int[]{
      3300,
      1500,
      4700,
      3000,
      1700,
      2100,
      3500,
      7000,
      4000,
      4000,
      3300,
      1500,
      3500,
      3000,
      0,
      3000,
      2100,
      3500,
      3500,
      3750,
      4500,
      7000,
      12000,
      8000,
      4000,
      4000,
      0,
      7000,
      4000,
      0
   };
   int[] maxmag = new int[]{
      3500,
      1700,
      7500,
      5000,
      3000,
      4100,
      6000,
      9000,
      4400,
      9500,
      3500,
      2000,
      8800,
      7000,
      Integer.MAX_VALUE,
      5000,
      7100,
      6000,
      9000,
      4400,
      4400,
      10000,
      4000,
      4400,
      5000,
      0,
      Integer.MAX_VALUE,
      10000,
      4400,
      Integer.MAX_VALUE
   };
   float[] dammult = new float[]{
      1.0F,
      2.028F,
      0.9375F,
      1.1791F,
      1.0F,
      0.9066F,
      1.0F,
      0.6969F,
      0.8266F,
      0.7667F,
      1.0F,
      0.96F,
      0.75F,
      0.9066F,
      1.0F,
      1.1791F,
      0.9066F,
      0.9F,
      0.9F,
      0.6969F,
      0.6969F,
      0.6969F,
      0.501F,
      0.8266F,
      0.7667F,
      0.7667F,
      0.5F,
      0.6969F,
      0.8266F,
      0.7667F
   };
   int[] outdam = new int[]{
      77, 35, 80, 67, 55, 75, 81, 100, 75, 90, 77, 35, 80, 77, Integer.MAX_VALUE, 67, 75, 81, 81, 80, 80, 1000, 60, 75, 75, 75, Integer.MAX_VALUE, 100, 75, 90
   };
   boolean[] dominate;
   boolean[] caught;
   int pzy;
   int pxy;
   float speed;
   float forca;
   float[] scy;
   float[] scz;
   float[] scx;
   boolean mtouch;
   boolean wtouch;
   int cntouch;
   boolean capsized;
   int txz;
   int fxz;
   int pmlt;
   int nmlt;
   int dcnt;
   int skid;
   boolean pushed;
   boolean gtouch;
   boolean pl;
   boolean pr;
   boolean pd;
   boolean pu;
   int loop;
   float ucomp;
   float dcomp;
   float lcomp;
   float rcomp;
   int lxz;
   int travxy;
   int travzy;
   int travxz;
   int trcnt;
   int capcnt;
   int srfcnt;
   boolean rtab;
   boolean ftab;
   boolean btab;
   boolean surfer;
   float powerup;
   int xtpower;
   float tilt;
   int squash;
   int nbsq;
   int hitmag;
   int cntdest;
   boolean dest;
   boolean newcar;
   int pan;
   int pcleared;
   int clear;
   int nlaps;
   int focus;
   float power;
   int missedcp;
   int lastcolido;
   int point;
   boolean nofocus;
   boolean colidim;

   public int py(int i, int j, int k, int l) {
      return (i - j) * (i - j) + (k - l) * (k - l);
   }

   public void regy(int i, float f, ContO conto) {
      f *= this.dammult[this.cn];
      if (f > 100.0F) {
         this.rpd.recy(i, f, this.mtouch, this.im);
         f -= 100.0F;
         byte byte0 = 0;
         byte byte1 = 0;
         int j = conto.zy;
         int k = conto.xy;

         while (j < 360) {
            j += 360;
         }

         while (j > 360) {
            j -= 360;
         }

         if (j < 210 && j > 150) {
            byte0 = -1;
         }

         if (j > 330 || j < 30) {
            byte0 = 1;
         }

         while (k < 360) {
            k += 360;
         }

         while (k > 360) {
            k -= 360;
         }

         if (k < 210 && k > 150) {
            byte1 = -1;
         }

         if (k > 330 || k < 30) {
            byte1 = 1;
         }

         if (this.im == 0 || this.colidim) {
            this.xt.crash(f, byte1 * byte0);
         }

         if (byte1 * byte0 == 0 || this.mtouch) {
            for (int l = 0; l < conto.npl; l++) {
               float f1 = 0.0F;

               for (int k1 = 0; k1 < conto.p[l].n; k1++) {
                  if (conto.p[l].wz == 0 && this.py(conto.keyx[i], conto.p[l].ox[k1], conto.keyz[i], conto.p[l].oz[k1]) < this.clrad[this.cn]) {
                     f1 = f / 20.0F * this.m.random();
                     conto.p[l].oz[k1] = (int)(conto.p[l].oz[k1] + f1 * this.m.sin(j));
                     conto.p[l].ox[k1] = (int)(conto.p[l].ox[k1] - f1 * this.m.sin(k));
                     this.hitmag = (int)(this.hitmag + Math.abs(f1));
                  }
               }

               if (f1 != 0.0F) {
                  if (Math.abs(f1) >= 1.0F) {
                     conto.p[l].chip = 1;
                     conto.p[l].ctmag = f1;
                  }

                  if (!conto.p[l].nocol && !conto.p[l].glass) {
                     if (conto.p[l].bfase > 20 && conto.p[l].hsb[1] > 0.2) {
                        conto.p[l].hsb[1] = 0.2F;
                     }

                     if (conto.p[l].bfase > 30) {
                        if (conto.p[l].hsb[2] < 0.5) {
                           conto.p[l].hsb[2] = 0.5F;
                        }

                        if (conto.p[l].hsb[1] > 0.1) {
                           conto.p[l].hsb[1] = 0.1F;
                        }
                     }

                     if (conto.p[l].bfase > 40) {
                        conto.p[l].hsb[1] = 0.05F;
                     }

                     if (conto.p[l].bfase > 50) {
                        if (conto.p[l].hsb[2] > 0.8) {
                           conto.p[l].hsb[2] = 0.8F;
                        }

                        conto.p[l].hsb[0] = 0.075F;
                        conto.p[l].hsb[1] = 0.05F;
                     }

                     if (conto.p[l].bfase > 60) {
                        conto.p[l].hsb[0] = 0.05F;
                     }

                     conto.p[l].bfase = (int)(conto.p[l].bfase + f1);
                     new Color(conto.p[l].c[0], conto.p[l].c[1], conto.p[l].c[2]);
                     Color color = Color.getHSBColor(conto.p[l].hsb[0], conto.p[l].hsb[1], conto.p[l].hsb[2]);
                     conto.p[l].c[0] = color.getRed();
                     conto.p[l].c[1] = color.getGreen();
                     conto.p[l].c[2] = color.getBlue();
                  }

                  if (conto.p[l].glass) {
                     conto.p[l].gr = (int)(conto.p[l].gr - Math.abs(f1 * 1.5));
                  }
               }
            }
         }

         if (byte1 * byte0 == -1) {
            if (this.nbsq > 0) {
               int i1 = 0;
               int j1 = 1;

               for (int l1 = 0; l1 < conto.npl; l1++) {
                  float f2 = 0.0F;

                  for (int i2 = 0; i2 < conto.p[l1].n; i2++) {
                     if (conto.p[l1].wz == 0) {
                        f2 = f / 15.0F * this.m.random();
                        if ((
                              Math.abs(conto.p[l1].oy[i2] - this.flipy[this.cn] - this.squash) < this.msquash[this.cn] * 3
                                 || conto.p[l1].oy[i2] < this.flipy[this.cn] + this.squash
                           )
                           && this.squash < this.msquash[this.cn]) {
                           conto.p[l1].oy[i2] = (int)(conto.p[l1].oy[i2] + f2);
                           i1 = (int)(i1 + f2);
                           j1++;
                           this.hitmag = (int)(this.hitmag + Math.abs(f2));
                        }
                     }
                  }

                  if (conto.p[l1].glass) {
                     conto.p[l1].gr -= 5;
                  } else if (f2 != 0.0F) {
                     conto.p[l1].bfase = (int)(conto.p[l1].bfase + f2);
                  }

                  if (Math.abs(f2) >= 1.0F) {
                     conto.p[l1].chip = 1;
                     conto.p[l1].ctmag = f2;
                  }
               }

               this.squash += i1 / j1;
               this.nbsq = 0;
            } else {
               this.nbsq++;
            }
         }
      }
   }

   public Madness(Medium medium, Record record, xtGraphics xtgraphics, int i) {
      this.cn = 0;
      this.im = 0;
      this.mxz = 0;
      this.cxz = 0;
      this.dominate = new boolean[5];
      this.caught = new boolean[5];
      this.pzy = 0;
      this.pxy = 0;
      this.speed = 0.0F;
      this.forca = 0.0F;
      this.scy = new float[4];
      this.scz = new float[4];
      this.scx = new float[4];
      this.mtouch = false;
      this.wtouch = false;
      this.cntouch = 0;
      this.capsized = false;
      this.txz = 0;
      this.fxz = 0;
      this.pmlt = 1;
      this.nmlt = 1;
      this.dcnt = 0;
      this.skid = 0;
      this.pushed = false;
      this.gtouch = false;
      this.pl = false;
      this.pr = false;
      this.pd = false;
      this.pu = false;
      this.loop = 0;
      this.ucomp = 0.0F;
      this.dcomp = 0.0F;
      this.lcomp = 0.0F;
      this.rcomp = 0.0F;
      this.lxz = 0;
      this.travxy = 0;
      this.travzy = 0;
      this.travxz = 0;
      this.trcnt = 0;
      this.capcnt = 0;
      this.srfcnt = 0;
      this.rtab = false;
      this.ftab = false;
      this.btab = false;
      this.surfer = false;
      this.powerup = 0.0F;
      this.xtpower = 0;
      this.tilt = 0.0F;
      this.squash = 0;
      this.nbsq = 0;
      this.hitmag = 0;
      this.cntdest = 0;
      this.dest = false;
      this.newcar = false;
      this.pan = 0;
      this.pcleared = 0;
      this.clear = 0;
      this.nlaps = 0;
      this.focus = -1;
      this.power = 75.0F;
      this.missedcp = 0;
      this.lastcolido = 0;
      this.point = 0;
      this.nofocus = false;
      this.colidim = false;
      this.m = medium;
      this.rpd = record;
      this.xt = xtgraphics;
      this.im = i;
   }

   public int rpy(float f, float f1, float f2, float f3, float f4, float f5) {
      return (int)((f - f1) * (f - f1) + (f2 - f3) * (f2 - f3) + (f4 - f5) * (f4 - f5));
   }

   public void regz(int i, float f, ContO conto) {
      f *= this.dammult[this.cn];
      if (Math.abs(f) > 100.0F) {
         this.rpd.recz(i, f, this.im);
         if (f > 100.0F) {
            f -= 100.0F;
         }

         if (f < -100.0F) {
            f += 100.0F;
         }

         if (this.im == 0 || this.colidim) {
            this.xt.crash(f, 0);
         }

         for (int j = 0; j < conto.npl; j++) {
            float f1 = 0.0F;

            for (int k = 0; k < conto.p[j].n; k++) {
               if (conto.p[j].wz == 0 && this.py(conto.keyx[i], conto.p[j].ox[k], conto.keyz[i], conto.p[j].oz[k]) < this.clrad[this.cn]) {
                  f1 = f / 20.0F * this.m.random();
                  conto.p[j].oz[k] = (int)(conto.p[j].oz[k] + f1 * this.m.cos(conto.xz) * this.m.cos(conto.zy));
                  conto.p[j].ox[k] = (int)(conto.p[j].ox[k] + f1 * this.m.sin(conto.xz) * this.m.cos(conto.xy));
                  this.hitmag = (int)(this.hitmag + Math.abs(f1));
               }
            }

            if (f1 != 0.0F) {
               if (Math.abs(f1) >= 1.0F) {
                  conto.p[j].chip = 1;
                  conto.p[j].ctmag = f1;
               }

               if (!conto.p[j].nocol && !conto.p[j].glass) {
                  if (conto.p[j].bfase > 20 && conto.p[j].hsb[1] > 0.2) {
                     conto.p[j].hsb[1] = 0.2F;
                  }

                  if (conto.p[j].bfase > 30) {
                     if (conto.p[j].hsb[2] < 0.5) {
                        conto.p[j].hsb[2] = 0.5F;
                     }

                     if (conto.p[j].hsb[1] > 0.1) {
                        conto.p[j].hsb[1] = 0.1F;
                     }
                  }

                  if (conto.p[j].bfase > 40) {
                     conto.p[j].hsb[1] = 0.05F;
                  }

                  if (conto.p[j].bfase > 50) {
                     if (conto.p[j].hsb[2] > 0.8) {
                        conto.p[j].hsb[2] = 0.8F;
                     }

                     conto.p[j].hsb[0] = 0.075F;
                     conto.p[j].hsb[1] = 0.05F;
                  }

                  if (conto.p[j].bfase > 60) {
                     conto.p[j].hsb[0] = 0.05F;
                  }

                  conto.p[j].bfase = (int)(conto.p[j].bfase + Math.abs(f1));
                  new Color(conto.p[j].c[0], conto.p[j].c[1], conto.p[j].c[2]);
                  Color color = Color.getHSBColor(conto.p[j].hsb[0], conto.p[j].hsb[1], conto.p[j].hsb[2]);
                  conto.p[j].c[0] = color.getRed();
                  conto.p[j].c[1] = color.getGreen();
                  conto.p[j].c[2] = color.getBlue();
               }

               if (conto.p[j].glass) {
                  conto.p[j].gr = (int)(conto.p[j].gr - Math.abs(f1 * 1.5));
               }
            }
         }
      }
   }

   public void rot(float[] af, float[] af1, int i, int j, int k, int l) {
      if (k != 0) {
         for (int i1 = 0; i1 < l; i1++) {
            float f = af[i1];
            float f1 = af1[i1];
            af[i1] = i + ((f - i) * this.m.cos(k) - (f1 - j) * this.m.sin(k));
            af1[i1] = j + ((f - i) * this.m.sin(k) + (f1 - j) * this.m.cos(k));
         }
      }
   }

   public void colide(ContO conto, Madness madness, ContO conto1) {
      float[] af = new float[4];
      float[] af1 = new float[4];
      float[] af2 = new float[4];
      float[] af3 = new float[4];
      float[] af4 = new float[4];
      float[] af5 = new float[4];
      int i = 0;

      do {
         af[i] = conto.x + conto.keyx[i];
         if (this.capsized) {
            af1[i] = conto.y + this.flipy[this.cn] + this.squash;
         } else {
            af1[i] = conto.y + conto.grat;
         }

         af2[i] = conto.z + conto.keyz[i];
         af3[i] = conto1.x + conto1.keyx[i];
         if (this.capsized) {
            af4[i] = conto1.y + madness.flipy[madness.cn] + madness.squash;
         } else {
            af4[i] = conto1.y + conto1.grat;
         }

         af5[i] = conto1.z + conto1.keyz[i];
      } while (++i < 4);

      this.rot(af, af1, conto.x, conto.y, conto.xy, 4);
      this.rot(af1, af2, conto.y, conto.z, conto.zy, 4);
      this.rot(af, af2, conto.x, conto.z, conto.xz, 4);
      this.rot(af3, af4, conto1.x, conto1.y, conto1.xy, 4);
      this.rot(af4, af5, conto1.y, conto1.z, conto1.zy, 4);
      this.rot(af3, af5, conto1.x, conto1.z, conto1.xz, 4);
      if (this.rpy(conto.x, conto1.x, conto.y, conto1.y, conto.z, conto1.z) < (conto.maxR * conto.maxR + conto1.maxR * conto1.maxR) * 1.5) {
         if (!this.caught[madness.im] && (this.speed != 0.0F || madness.speed != 0.0F)) {
            if (Math.abs(this.power * this.speed * this.moment[this.cn]) != Math.abs(madness.power * madness.speed * madness.moment[madness.cn])) {
               if (Math.abs(this.power * this.speed * this.moment[this.cn]) > Math.abs(madness.power * madness.speed * madness.moment[madness.cn])) {
                  this.dominate[madness.im] = true;
               } else {
                  this.dominate[madness.im] = false;
               }
            } else if (this.moment[this.cn] > madness.moment[madness.cn]) {
               this.dominate[madness.im] = true;
            } else {
               this.dominate[madness.im] = false;
            }

            this.caught[madness.im] = true;
         }
      } else if (this.caught[madness.im]) {
         this.caught[madness.im] = false;
      }

      if (this.dominate[madness.im]) {
         int j = (int)(
            (
                  (this.scz[0] - madness.scz[0] + this.scz[1] - madness.scz[1] + this.scz[2] - madness.scz[2] + this.scz[3] - madness.scz[3])
                        * (this.scz[0] - madness.scz[0] + this.scz[1] - madness.scz[1] + this.scz[2] - madness.scz[2] + this.scz[3] - madness.scz[3])
                     + (this.scx[0] - madness.scx[0] + this.scx[1] - madness.scx[1] + this.scx[2] - madness.scx[2] + this.scx[3] - madness.scx[3])
                        * (this.scx[0] - madness.scx[0] + this.scx[1] - madness.scx[1] + this.scx[2] - madness.scx[2] + this.scx[3] - madness.scx[3])
               )
               / 16.0F
         );
         int k = 0;

         do {
            int l = 0;

            do {
               if (this.rpy(af[k], af3[l], af1[k], af4[l], af2[k], af5[l]) < (j + 7000) * (this.comprad[madness.cn] + this.comprad[this.cn])) {
                  if (Math.abs(this.scx[k] * this.moment[this.cn]) > Math.abs(madness.scx[l] * madness.moment[madness.cn])) {
                     float f = madness.scx[l] * this.revpush[this.cn];
                     if (f > 300.0F) {
                        f = 300.0F;
                     }

                     if (f < -300.0F) {
                        f = -300.0F;
                     }

                     float f2 = this.scx[k] * this.push[this.cn];
                     if (f2 > 300.0F) {
                        f2 = 300.0F;
                     }

                     if (f2 < -300.0F) {
                        f2 = -300.0F;
                     }

                     madness.scx[l] = madness.scx[l] + f2;
                     if (this.im == 0) {
                        madness.colidim = true;
                     }

                     madness.regx(l, f2 * this.moment[this.cn], conto1);
                     if (madness.colidim) {
                        madness.colidim = false;
                     }

                     this.scx[k] = this.scx[k] - f;
                     this.regx(k, -f * madness.moment[this.cn], conto);
                     this.scy[k] = this.scy[k] - this.revlift[this.cn];
                     if (this.im == 0) {
                        madness.colidim = true;
                     }

                     madness.regy(l, this.revlift[this.cn] * 7, conto1);
                     if (madness.colidim) {
                        madness.colidim = false;
                     }
                  }

                  if (Math.abs(this.scz[k] * this.moment[this.cn]) > Math.abs(madness.scz[l] * madness.moment[madness.cn])) {
                     float f1 = madness.scz[l] * this.revpush[this.cn];
                     if (f1 > 300.0F) {
                        f1 = 300.0F;
                     }

                     if (f1 < -300.0F) {
                        f1 = -300.0F;
                     }

                     float f3 = this.scz[k] * this.push[this.cn];
                     if (f3 > 300.0F) {
                        f3 = 300.0F;
                     }

                     if (f3 < -300.0F) {
                        f3 = -300.0F;
                     }

                     madness.scz[l] = madness.scz[l] + f3;
                     if (this.im == 0) {
                        madness.colidim = true;
                     }

                     madness.regz(l, f3 * this.moment[this.cn], conto1);
                     if (madness.colidim) {
                        madness.colidim = false;
                     }

                     this.scz[k] = this.scz[k] - f1;
                     this.regz(k, -f1 * madness.moment[this.cn], conto);
                     this.scy[k] = this.scy[k] - this.revlift[this.cn];
                     if (this.im == 0) {
                        madness.colidim = true;
                     }

                     madness.regy(l, this.revlift[this.cn] * 7, conto1);
                     if (madness.colidim) {
                        madness.colidim = false;
                     }
                  }

                  if (this.im == 0) {
                     madness.lastcolido = 70;
                  }

                  if (madness.im == 0) {
                     this.lastcolido = 70;
                  }

                  madness.scy[l] = madness.scy[l] - this.lift[this.cn];
               }
            } while (++l < 4);
         } while (++k < 4);
      }
   }

   public void distruct(ContO conto) {
      for (int i = 0; i < conto.npl; i++) {
         if (conto.p[i].wz == 0) {
            conto.p[i].embos = 1;
         }
      }
   }

   public void reseto(int i, ContO conto, CheckPoints checkpoints) {
      this.cn = i;
      int j = 0;

      do {
         this.dominate[j] = false;
         this.caught[j] = false;
      } while (++j < 5);

      if (this.cn == 7 && this.im == 0) {
         if (checkpoints.stage == 10) {
            this.moment[this.cn] = 1.7F;
         } else {
            this.moment[this.cn] = 2.0F;
         }
      }

      this.mxz = 0;
      this.cxz = 0;
      this.pzy = 0;
      this.pxy = 0;
      this.speed = 0.0F;
      j = 0;

      do {
         this.scy[j] = 0.0F;
         this.scx[j] = 0.0F;
         this.scz[j] = 0.0F;
      } while (++j < 4);

      this.forca = (
            (float)Math.sqrt(conto.keyz[0] * conto.keyz[0] + conto.keyx[0] * conto.keyx[0])
               + (float)Math.sqrt(conto.keyz[1] * conto.keyz[1] + conto.keyx[1] * conto.keyx[1])
               + (float)Math.sqrt(conto.keyz[2] * conto.keyz[2] + conto.keyx[2] * conto.keyx[2])
               + (float)Math.sqrt(conto.keyz[3] * conto.keyz[3] + conto.keyx[3] * conto.keyx[3])
         )
         / 10000.0F
         * (float)(this.bounce[this.cn] - 0.3);
      this.mtouch = false;
      this.wtouch = false;
      this.txz = 0;
      this.fxz = 0;
      this.pmlt = 1;
      this.nmlt = 1;
      this.dcnt = 0;
      this.skid = 0;
      this.pushed = false;
      this.gtouch = false;
      this.pl = false;
      this.pr = false;
      this.pd = false;
      this.pu = false;
      this.loop = 0;
      this.ucomp = 0.0F;
      this.dcomp = 0.0F;
      this.lcomp = 0.0F;
      this.rcomp = 0.0F;
      this.lxz = 0;
      this.travxy = 0;
      this.travzy = 0;
      this.travxz = 0;
      this.rtab = false;
      this.ftab = false;
      this.btab = false;
      this.powerup = 0.0F;
      this.xtpower = 0;
      this.trcnt = 0;
      this.capcnt = 0;
      this.tilt = 0.0F;
      this.pan = 0;
      this.pcleared = checkpoints.pcs;
      this.clear = 0;
      this.nlaps = 0;
      this.focus = -1;
      this.missedcp = 0;
      this.nofocus = false;
      this.power = Float.POSITIVE_INFINITY;
      this.lastcolido = 0;
      checkpoints.dested[this.im] = 0;
      this.squash = 0;
      this.nbsq = 0;
      this.hitmag = 0;
      this.cntdest = 0;
      this.dest = false;
      this.newcar = false;
   }

   public void regx(int i, float f, ContO conto) {
      f *= this.dammult[this.cn];
      if (Math.abs(f) > 100.0F) {
         this.rpd.recx(i, f, this.im);
         if (f > 100.0F) {
            f -= 100.0F;
         }

         if (f < -100.0F) {
            f += 100.0F;
         }

         if (this.im == 0 || this.colidim) {
            this.xt.crash(f, 0);
         }

         for (int j = 0; j < conto.npl; j++) {
            float f1 = 0.0F;

            for (int k = 0; k < conto.p[j].n; k++) {
               if (conto.p[j].wz == 0 && this.py(conto.keyx[i], conto.p[j].ox[k], conto.keyz[i], conto.p[j].oz[k]) < this.clrad[this.cn]) {
                  f1 = f / 20.0F * this.m.random();
                  conto.p[j].oz[k] = (int)(conto.p[j].oz[k] - f1 * this.m.sin(conto.xz) * this.m.cos(conto.zy));
                  conto.p[j].ox[k] = (int)(conto.p[j].ox[k] + f1 * this.m.cos(conto.xz) * this.m.cos(conto.xy));
                  this.hitmag = (int)(this.hitmag + Math.abs(f1));
               }
            }

            if (f1 != 0.0F) {
               if (Math.abs(f1) >= 1.0F) {
                  conto.p[j].chip = 1;
                  conto.p[j].ctmag = f1;
               }

               if (!conto.p[j].nocol && !conto.p[j].glass) {
                  if (conto.p[j].bfase > 20 && conto.p[j].hsb[1] > 0.2) {
                     conto.p[j].hsb[1] = 0.2F;
                  }

                  if (conto.p[j].bfase > 30) {
                     if (conto.p[j].hsb[2] < 0.5) {
                        conto.p[j].hsb[2] = 0.5F;
                     }

                     if (conto.p[j].hsb[1] > 0.1) {
                        conto.p[j].hsb[1] = 0.1F;
                     }
                  }

                  if (conto.p[j].bfase > 40) {
                     conto.p[j].hsb[1] = 0.05F;
                  }

                  if (conto.p[j].bfase > 50) {
                     if (conto.p[j].hsb[2] > 0.8) {
                        conto.p[j].hsb[2] = 0.8F;
                     }

                     conto.p[j].hsb[0] = 0.075F;
                     conto.p[j].hsb[1] = 0.05F;
                  }

                  if (conto.p[j].bfase > 60) {
                     conto.p[j].hsb[0] = 0.05F;
                  }

                  conto.p[j].bfase = (int)(conto.p[j].bfase + Math.abs(f1));
                  new Color(conto.p[j].c[0], conto.p[j].c[1], conto.p[j].c[2]);
                  Color color = Color.getHSBColor(conto.p[j].hsb[0], conto.p[j].hsb[1], conto.p[j].hsb[2]);
                  conto.p[j].c[0] = color.getRed();
                  conto.p[j].c[1] = color.getGreen();
                  conto.p[j].c[2] = color.getBlue();
               }

               if (conto.p[j].glass) {
                  conto.p[j].gr = (int)(conto.p[j].gr - Math.abs(f1 * 1.5));
               }
            }
         }
      }
   }

   public void drive(Control control, ContO conto, Trackers trackers, CheckPoints checkpoints) {
      int i = 1;
      int j = 1;
      boolean flag = false;
      boolean flag1 = false;
      boolean flag2 = false;
      this.capsized = false;
      int k = Math.abs(this.pzy);

      while (k > 270) {
         k -= 360;
      }

      k = Math.abs(k);
      if (k > 90) {
         flag = true;
      }

      boolean flag3 = false;
      int l = Math.abs(this.pxy);

      while (l > 270) {
         l -= 360;
      }

      l = Math.abs(l);
      if (l > 90) {
         flag3 = true;
         j = -1;
      }

      int i1 = conto.grat;
      if (flag) {
         if (flag3) {
            flag3 = false;
            flag1 = true;
         } else {
            flag3 = true;
            this.capsized = true;
         }

         i = -1;
      } else if (flag3) {
         this.capsized = true;
      }

      if (this.capsized) {
         i1 = this.flipy[this.cn] + this.squash;
      }

      control.zyinv = flag;
      float f = 0.0F;
      float f1 = 0.0F;
      float f2 = 0.0F;
      if (this.mtouch) {
         this.loop = 0;
      }

      if (this.wtouch) {
         if (this.loop == 2 || this.loop == -1) {
            this.loop = -1;
            if (control.left) {
               this.pl = true;
            }

            if (control.right) {
               this.pr = true;
            }

            if (control.up) {
               this.pu = true;
            }

            if (control.down) {
               this.pd = true;
            }
         }

         this.ucomp = 0.0F;
         this.dcomp = 0.0F;
         this.lcomp = 0.0F;
         this.rcomp = 0.0F;
      }

      if (control.handb) {
         if (!this.pushed) {
            if (!this.wtouch) {
               if (this.loop == 0) {
                  this.loop = 1;
               }
            } else if (this.gtouch) {
               this.pushed = true;
            }
         }
      } else {
         this.pushed = false;
      }

      if (this.loop == 1) {
         float f3 = (this.scy[0] + this.scy[1] + this.scy[2] + this.scy[3]) / 4.0F;
         int j1 = 0;

         do {
            this.scy[j1] = f3;
         } while (++j1 < 4);

         this.loop = 2;
      }

      if (!this.dest) {
         if (this.loop == 2) {
            if (control.up) {
               if (this.ucomp == 0.0F) {
                  this.ucomp = 10.0F + (this.scy[0] + 50.0F) / 20.0F;
                  if (this.ucomp < 5.0F) {
                     this.ucomp = 5.0F;
                  }

                  if (this.ucomp > 10.0F) {
                     this.ucomp = 10.0F;
                  }

                  this.ucomp = this.ucomp * this.airs[this.cn];
               }

               if (this.ucomp < 20.0F) {
                  this.ucomp = (float)(this.ucomp + 0.5 * this.airs[this.cn]);
               }

               f = -this.airc[this.cn] * this.m.sin(conto.xz) * j;
               f1 = this.airc[this.cn] * this.m.cos(conto.xz) * j;
            } else if (this.ucomp != 0.0F && this.ucomp > -2.0F) {
               this.ucomp = (float)(this.ucomp - 0.5 * this.airs[this.cn]);
            }

            if (control.down) {
               if (this.dcomp == 0.0F) {
                  this.dcomp = 10.0F + (this.scy[0] + 50.0F) / 20.0F;
                  if (this.dcomp < 5.0F) {
                     this.dcomp = 5.0F;
                  }

                  if (this.dcomp > 10.0F) {
                     this.dcomp = 10.0F;
                  }

                  this.dcomp = this.dcomp * this.airs[this.cn];
               }

               if (this.dcomp < 20.0F) {
                  this.dcomp = (float)(this.dcomp + 0.5 * this.airs[this.cn]);
               }

               f2 = -this.airc[this.cn];
            } else if (this.dcomp != 0.0F && this.ucomp > -2.0F) {
               this.dcomp = (float)(this.dcomp - 0.5 * this.airs[this.cn]);
            }

            if (control.left) {
               if (this.lcomp == 0.0F) {
                  this.lcomp = 5.0F;
               }

               if (this.lcomp < 20.0F) {
                  this.lcomp = this.lcomp + 2.0F * this.airs[this.cn];
               }

               f = -this.airc[this.cn] * this.m.cos(conto.xz) * i;
               f1 = -this.airc[this.cn] * this.m.sin(conto.xz) * i;
            } else if (this.lcomp > 0.0F) {
               this.lcomp = this.lcomp - 2.0F * this.airs[this.cn];
            }

            if (control.right) {
               if (this.rcomp == 0.0F) {
                  this.rcomp = 5.0F;
               }

               if (this.rcomp < 20.0F) {
                  this.rcomp = this.rcomp + 2.0F * this.airs[this.cn];
               }

               f = this.airc[this.cn] * this.m.cos(conto.xz) * i;
               f1 = this.airc[this.cn] * this.m.sin(conto.xz) * i;
            } else if (this.rcomp > 0.0F) {
               this.rcomp = this.rcomp - 2.0F * this.airs[this.cn];
            }

            this.pzy = (int)(this.pzy + (this.dcomp - this.ucomp) * this.m.cos(this.pxy));
            if (flag) {
               conto.xz = (int)(conto.xz + (this.dcomp - this.ucomp) * this.m.sin(this.pxy));
            } else {
               conto.xz = (int)(conto.xz - (this.dcomp - this.ucomp) * this.m.sin(this.pxy));
            }

            this.pxy = (int)(this.pxy + (this.rcomp - this.lcomp));
         } else {
            float f4 = this.power;
            if (f4 < 40.0F) {
               f4 = 40.0F;
            }

            if (this.im == 0 && this.power != Float.POSITIVE_INFINITY) {
               if (checkpoints.stage != 6 && checkpoints.stage != 8) {
                  f4 = (float)(f4 * 0.76);
               } else if (checkpoints.stage != 6) {
                  f4 = (float)(f4 * 0.9);
               }
            }

            if (control.down) {
               if (this.speed > 0.0F) {
                  this.speed = this.speed - this.handb[this.cn] / 2;
               } else {
                  int k1 = 0;
                  int j2 = 0;

                  do {
                     if (this.speed <= -(this.swits[this.cn][j2] / 2 + f4 * this.swits[this.cn][j2] / 196.0F)) {
                        k1++;
                     }
                  } while (++j2 < 2);

                  if (k1 != 2) {
                     this.speed = this.speed - (this.acelf[this.cn][k1] / 2.0F + f4 * this.acelf[this.cn][k1] / 196.0F);
                  } else {
                     this.speed = -(this.swits[this.cn][1] / 2 + f4 * this.swits[this.cn][1] / 196.0F);
                  }
               }
            }

            if (control.up) {
               if (this.speed < 0.0F) {
                  this.speed = this.speed + this.handb[this.cn];
               } else {
                  int l1 = 0;
                  int k2 = 0;

                  do {
                     if (this.speed >= this.swits[this.cn][k2] / 2 + f4 * this.swits[this.cn][k2] / 196.0F) {
                        l1++;
                     }
                  } while (++k2 < 3);

                  if (l1 != 3) {
                     this.speed = this.speed + (this.acelf[this.cn][l1] / 2.0F + f4 * this.acelf[this.cn][l1] / 196.0F);
                  } else {
                     this.speed = this.swits[this.cn][2] / 2 + f4 * this.swits[this.cn][2] / 196.0F;
                  }
               }
            }

            if (control.handb && Math.abs(this.speed) > this.handb[this.cn]) {
               if (this.speed < 0.0F) {
                  this.speed = this.speed + this.handb[this.cn];
               } else {
                  this.speed = this.speed - this.handb[this.cn];
               }
            }

            if (this.loop == -1 && conto.y < 100) {
               if (control.left) {
                  if (!this.pl) {
                     if (this.lcomp == 0.0F) {
                        this.lcomp = 5.0F * this.airs[this.cn];
                     }

                     if (this.lcomp < 20.0F) {
                        this.lcomp = this.lcomp + 2.0F * this.airs[this.cn];
                     }
                  }
               } else {
                  if (this.lcomp > 0.0F) {
                     this.lcomp = this.lcomp - 2.0F * this.airs[this.cn];
                  }

                  this.pl = false;
               }

               if (control.right) {
                  if (!this.pr) {
                     if (this.rcomp == 0.0F) {
                        this.rcomp = 5.0F * this.airs[this.cn];
                     }

                     if (this.rcomp < 20.0F) {
                        this.rcomp = this.rcomp + 2.0F * this.airs[this.cn];
                     }
                  }
               } else {
                  if (this.rcomp > 0.0F) {
                     this.rcomp = this.rcomp - 2.0F * this.airs[this.cn];
                  }

                  this.pr = false;
               }

               if (control.up) {
                  if (!this.pu) {
                     if (this.ucomp == 0.0F) {
                        this.ucomp = 5.0F * this.airs[this.cn];
                     }

                     if (this.ucomp < 20.0F) {
                        this.ucomp = this.ucomp + 2.0F * this.airs[this.cn];
                     }
                  }
               } else {
                  if (this.ucomp > 0.0F) {
                     this.ucomp = this.ucomp - 2.0F * this.airs[this.cn];
                  }

                  this.pu = false;
               }

               if (control.down) {
                  if (!this.pd) {
                     if (this.dcomp == 0.0F) {
                        this.dcomp = 5.0F * this.airs[this.cn];
                     }

                     if (this.dcomp < 20.0F) {
                        this.dcomp = this.dcomp + 2.0F * this.airs[this.cn];
                     }
                  }
               } else {
                  if (this.dcomp > 0.0F) {
                     this.dcomp = this.dcomp - 2.0F * this.airs[this.cn];
                  }

                  this.pd = false;
               }

               this.pzy = (int)(this.pzy + (this.dcomp - this.ucomp) * this.m.cos(this.pxy));
               if (flag) {
                  conto.xz = (int)(conto.xz + (this.dcomp - this.ucomp) * this.m.sin(this.pxy));
               } else {
                  conto.xz = (int)(conto.xz - (this.dcomp - this.ucomp) * this.m.sin(this.pxy));
               }

               this.pxy = (int)(this.pxy + (this.rcomp - this.lcomp));
            }
         }
      }

      float f5 = 20.0F * this.speed / (154.0F * this.simag[this.cn]);
      if (f5 > 20.0F) {
         f5 = 20.0F;
      }

      conto.wzy = (int)(conto.wzy - f5);
      if (conto.wzy < -45) {
         conto.wzy += 45;
      }

      if (conto.wzy > 45) {
         conto.wzy -= 45;
      }

      if (control.right) {
         conto.wxz = conto.wxz - this.turn[this.cn];
         if (conto.wxz < -36) {
            conto.wxz = -36;
         }
      }

      if (control.left) {
         conto.wxz = conto.wxz + this.turn[this.cn];
         if (conto.wxz > 36) {
            conto.wxz = 36;
         }
      }

      if (conto.wxz != 0 && !control.left && !control.right) {
         if (Math.abs(this.speed) < 10.0F) {
            if (Math.abs(conto.wxz) == 1) {
               conto.wxz = 0;
            }

            if (conto.wxz > 0) {
               conto.wxz--;
            }

            if (conto.wxz < 0) {
               conto.wxz++;
            }
         } else {
            if (Math.abs(conto.wxz) < this.turn[this.cn] * 2) {
               conto.wxz = 0;
            }

            if (conto.wxz > 0) {
               conto.wxz = conto.wxz - this.turn[this.cn] * 2;
            }

            if (conto.wxz < 0) {
               conto.wxz = conto.wxz + this.turn[this.cn] * 2;
            }
         }
      }

      int i2 = (int)(0.0F / (this.speed * this.speed));
      if (i2 < 5) {
         i2 = 5;
      }

      if (this.speed < 0.0F) {
         i2 = -i2;
      }

      if (this.wtouch) {
         if (!this.capsized) {
            if (!control.handb) {
               this.fxz = conto.wxz / (i2 * 3);
            } else {
               this.fxz = conto.wxz / i2;
            }

            conto.xz = conto.xz + conto.wxz / i2;
         }

         this.wtouch = false;
         this.gtouch = false;
      } else {
         conto.xz = conto.xz + this.fxz;
      }

      if (this.speed > 30.0F || this.speed < -100.0F) {
         while (Math.abs(this.mxz - this.cxz) > 180) {
            if (this.cxz > this.mxz) {
               this.cxz -= 360;
            } else if (this.cxz < this.mxz) {
               this.cxz += 360;
            }
         }

         if (Math.abs(this.mxz - this.cxz) < 30) {
            this.cxz = (int)(this.cxz + (this.mxz - this.cxz) / 4.0F);
         } else {
            if (this.cxz > this.mxz) {
               this.cxz -= 10;
            }

            if (this.cxz < this.mxz) {
               this.cxz += 10;
            }
         }
      }

      float[] af = new float[4];
      float[] af1 = new float[4];
      float[] af2 = new float[4];
      int l2 = 0;

      do {
         af[l2] = conto.keyx[l2] + conto.x;
         af2[l2] = i1 + conto.y;
         af1[l2] = conto.z + conto.keyz[l2];
         this.scy[l2] = this.scy[l2] + 7.0F;
      } while (++l2 < 4);

      this.rot(af, af2, conto.x, conto.y, this.pxy, 4);
      this.rot(af2, af1, conto.y, conto.z, this.pzy, 4);
      this.rot(af, af1, conto.x, conto.z, conto.xz, 4);
      boolean flag4 = false;
      double d = 0.0;
      int i3 = (int)((this.scx[0] + this.scx[1] + this.scx[2] + this.scx[3]) / 4.0F);
      int j3 = (int)((this.scz[0] + this.scz[1] + this.scz[2] + this.scz[3]) / 4.0F);
      int k3 = 0;

      do {
         if (this.scx[k3] - i3 > 200.0F) {
            this.scx[k3] = 200 + i3;
         }

         if (this.scx[k3] - i3 < -200.0F) {
            this.scx[k3] = i3 - 200;
         }

         if (this.scz[k3] - j3 > 200.0F) {
            this.scz[k3] = 200 + j3;
         }

         if (this.scz[k3] - j3 < -200.0F) {
            this.scz[k3] = j3 - 200;
         }
      } while (++k3 < 4);

      k3 = 0;

      do {
         af2[k3] += this.scy[k3];
         af[k3] += (this.scx[0] + this.scx[1] + this.scx[2] + this.scx[3]) / 4.0F;
         af1[k3] += (this.scz[0] + this.scz[1] + this.scz[2] + this.scz[3]) / 4.0F;
      } while (++k3 < 4);

      k3 = 1;

      for (int l3 = 0; l3 < trackers.nt; l3++) {
         if (Math.abs(trackers.zy[l3]) != 90
            && Math.abs(trackers.xy[l3]) != 90
            && Math.abs(conto.x - trackers.x[l3]) < trackers.radx[l3]
            && Math.abs(conto.z - trackers.z[l3]) < trackers.radz[l3]) {
            k3 = trackers.skd[l3];
         }
      }

      if (this.mtouch) {
         float f6 = this.grip[this.cn];
         f6 -= Math.abs(this.txz - conto.xz) * this.speed / 250.0F;
         if (control.handb) {
            f6 -= Math.abs(this.txz - conto.xz) * 4;
         }

         if (f6 < this.grip[this.cn]) {
            if (this.skid != 2) {
               this.skid = 1;
            }

            this.speed = this.speed - this.speed / 100.0F;
         } else if (this.skid == 1) {
            this.skid = 2;
         }

         if (k3 == 1) {
            f6 = (float)(f6 * 0.75);
         }

         if (k3 == 2) {
            f6 = (float)(f6 * 0.55);
         }

         int j4 = -((int)(this.speed * this.m.sin(conto.xz) * this.m.cos(this.pzy)));
         int k4 = (int)(this.speed * this.m.cos(conto.xz) * this.m.cos(this.pzy));
         int i5 = -((int)(this.speed * this.m.sin(this.pzy)));
         if (this.capsized || this.dest || checkpoints.haltall) {
            j4 = 0;
            k4 = 0;
            i5 = 0;
            f6 = this.grip[this.cn] / 5.0F;
            if (this.speed > 0.0F) {
               this.speed -= 2.0F;
            } else {
               this.speed += 2.0F;
            }
         }

         if (Math.abs(this.speed) > this.drag[this.cn]) {
            if (this.speed > 0.0F) {
               this.speed = this.speed - this.drag[this.cn];
            } else {
               this.speed = this.speed + this.drag[this.cn];
            }
         } else {
            this.speed = 0.0F;
         }

         if (f6 < 1.0F) {
            f6 = 1.0F;
         }

         float f9 = 0.0F;
         float f10 = 0.0F;
         int l6 = 0;

         do {
            if (Math.abs(this.scx[l6] - j4) > f6) {
               if (this.scx[l6] < j4) {
                  this.scx[l6] = this.scx[l6] + f6;
               } else {
                  this.scx[l6] = this.scx[l6] - f6;
               }
            } else {
               this.scx[l6] = j4;
            }

            if (Math.abs(this.scz[l6] - k4) > f6) {
               if (this.scz[l6] < k4) {
                  this.scz[l6] = this.scz[l6] + f6;
               } else {
                  this.scz[l6] = this.scz[l6] - f6;
               }
            } else {
               this.scz[l6] = k4;
            }

            if (Math.abs(this.scy[l6] - i5) > f6) {
               if (this.scy[l6] < i5) {
                  this.scy[l6] = this.scy[l6] + f6;
               } else {
                  this.scy[l6] = this.scy[l6] - f6;
               }
            } else {
               this.scy[l6] = i5;
            }

            if (f6 < this.grip[this.cn]) {
               if (this.txz != conto.xz) {
                  this.dcnt++;
               } else if (this.dcnt != 0) {
                  this.dcnt = 0;
               }

               if (!(this.dcnt > 40.0F * f6 / this.grip[this.cn]) && !this.capsized) {
                  if (k3 == 1 && this.m.random() > 0.85) {
                     conto.dust(l6, af[l6], af2[l6], af1[l6], this.scx[l6], this.scz[l6], 1.1F * this.simag[this.cn], false, (int)this.tilt);
                  }

                  if ((k3 == 2 || k3 == 3) && this.m.random() > 0.7) {
                     conto.dust(l6, af[l6], af2[l6], af1[l6], this.scx[l6], this.scz[l6], 1.15F * this.simag[this.cn], false, (int)this.tilt);
                  }
               } else {
                  float f11 = 1.0F;
                  if (k3 != 0) {
                     f11 = 1.2F;
                  }

                  if (this.m.random() > 0.75) {
                     conto.dust(l6, af[l6], af2[l6], af1[l6], this.scx[l6], this.scz[l6], f11 * this.simag[this.cn], true, (int)this.tilt);
                     if (this.im == 0 && !this.capsized) {
                        this.xt.skid(k3, (float)Math.sqrt(this.scx[l6] * this.scx[l6] + this.scz[l6] * this.scz[l6]));
                     }
                  }
               }
            } else if (this.dcnt != 0) {
               this.dcnt -= 2;
               if (this.dcnt < 0) {
                  this.dcnt = 0;
               }
            }

            if (k3 == 3) {
               int k7 = (int)(this.m.random() * 4.0F);
               this.scy[k7] = (float)(-100.0F * this.m.random() * (this.speed / this.swits[this.cn][2]) * (this.bounce[this.cn] - 0.3));
            }

            f9 += this.scx[l6];
            f10 += this.scz[l6];
         } while (++l6 < 4);

         this.txz = conto.xz;
         byte var41;
         if (f9 > 0.0F) {
            var41 = -1;
         } else {
            var41 = 1;
         }

         double d1 = f10 / Math.sqrt(f9 * f9 + f10 * f10);
         this.mxz = (int)(Math.acos(d1) / (Math.PI / 180.0) * var41);
         if (this.skid == 2) {
            if (!this.capsized) {
               f9 /= 4.0F;
               f10 /= 4.0F;
               if (flag1) {
                  this.speed = -((float)Math.sqrt(f9 * f9 + f10 * f10) * this.m.cos(this.mxz - conto.xz));
               } else {
                  this.speed = (float)Math.sqrt(f9 * f9 + f10 * f10) * this.m.cos(this.mxz - conto.xz);
               }
            }

            this.skid = 0;
         }

         if (this.capsized && f9 == 0.0F && f10 == 0.0F) {
            k3 = 0;
         }

         this.mtouch = false;
         flag4 = true;
      } else if (this.skid != 2) {
         this.skid = 2;
      }

      int i4 = 0;
      boolean[] aflag = new boolean[4];
      int l4 = 0;

      do {
         if (af2[l4] > 245.0F) {
            i4++;
            this.wtouch = true;
            this.gtouch = true;
            if (!flag4 && this.scy[l4] != 7.0F) {
               float f7 = this.scy[l4] / 333.33F;
               if (f7 > 0.3) {
                  f7 = 0.3F;
               }

               if (k3 == 0) {
                  f7 = (float)(f7 + 1.1);
               } else {
                  f7 = (float)(f7 + 1.2);
               }

               conto.dust(l4, af[l4], af2[l4], af1[l4], this.scx[l4], this.scz[l4], f7 * this.simag[this.cn], true, 0);
            }

            af2[l4] = 250.0F;
            float f8 = 0.0F;
            int iiii = 0;

            do {
               if (l4 != f8 && af2[iiii] <= 245.0F) {
                  af2[iiii] -= af2[l4] - 250.0F;
               }
            } while (++f8 < 4.0F);

            f8 = Math.abs(this.m.sin(this.pxy)) + Math.abs(this.m.sin(this.pzy));
            f8 /= 3.0F;
            if (f8 > 0.4) {
               f8 = 0.4F;
            }

            f8 += this.bounce[this.cn];
            if (f8 < 1.1) {
               f8 = 1.1F;
            }

            this.regy(l4, Math.abs(this.scy[l4] * f8), conto);
            if (this.scy[l4] > 0.0F) {
               this.scy[l4] = this.scy[l4] - Math.abs(this.scy[l4] * f8);
            }
         }

         aflag[l4] = false;
      } while (++l4 < 4);

      l4 = 0;

      for (int j5 = 0; j5 < trackers.nt; j5++) {
         int l5 = 0;
         int j6 = 0;
         int i7 = 0;

         do {
            if (!aflag[i7]
               && af[i7] > trackers.x[j5] - trackers.radx[j5]
               && af[i7] < trackers.x[j5] + trackers.radx[j5]
               && af1[i7] > trackers.z[j5] - trackers.radz[j5]
               && af1[i7] < trackers.z[j5] + trackers.radz[j5]
               && af2[i7] > trackers.y[j5] - trackers.rady[j5]
               && af2[i7] < trackers.y[j5] + trackers.rady[j5]) {
               if (trackers.xy[j5] == 0 && trackers.zy[j5] == 0 && trackers.y[j5] != 250 && af2[i7] > trackers.y[j5] - 5) {
                  j6++;
                  this.wtouch = true;
                  this.gtouch = true;
                  if (!flag4 && this.scy[i7] != 7.0F) {
                     float f12 = this.scy[i7] / 333.33F;
                     if (f12 > 0.3) {
                        f12 = 0.3F;
                     }

                     if (k3 == 0) {
                        f12 = (float)(f12 + 1.1);
                     } else {
                        f12 = (float)(f12 + 1.2);
                     }

                     conto.dust(i7, af[i7], af2[i7], af1[i7], this.scx[i7], this.scz[i7], f12 * this.simag[this.cn], true, 0);
                  }

                  af2[i7] = trackers.y[j5];
                  float f13 = 0.0F;
                  int iiii = 0;

                  do {
                     if (i7 != f13 && af2[iiii] <= trackers.y[j5] - 5) {
                        af2[iiii] -= af2[i7] - trackers.y[j5];
                     }
                  } while (++f13 < 4.0F);

                  f13 = Math.abs(this.m.sin(this.pxy)) + Math.abs(this.m.sin(this.pzy));
                  f13 /= 3.0F;
                  if (f13 > 0.4) {
                     f13 = 0.4F;
                  }

                  f13 += this.bounce[this.cn];
                  if (f13 < 1.1) {
                     f13 = 1.1F;
                  }

                  this.regy(i7, Math.abs(this.scy[i7] * f13), conto);
                  if (this.scy[i7] > 0.0F) {
                     this.scy[i7] = this.scy[i7] - Math.abs(this.scy[i7] * f13);
                  }

                  aflag[i7] = true;
               }

               if (trackers.zy[j5] == -90 && af1[i7] < trackers.z[j5] + trackers.radz[j5] && this.scz[i7] < 0.0F) {
                  af1[i7] = trackers.z[j5] + trackers.radz[j5];
                  float f14 = 0.0F;
                  int iiii = 0;

                  do {
                     if (i7 != f14 && af1[iiii] >= trackers.z[j5] + trackers.radz[j5]) {
                        af1[iiii] -= af1[i7] - (trackers.z[j5] + trackers.radz[j5]);
                     }
                  } while (++f14 < 4.0F);

                  f14 = Math.abs(this.m.cos(this.pxy)) + Math.abs(this.m.cos(this.pzy));
                  f14 /= 4.0F;
                  if (f14 > 0.3) {
                     f14 = 0.3F;
                  }

                  if (flag4) {
                     f14 = 0.0F;
                  }

                  f14 = (float)(f14 + (this.bounce[this.cn] - 0.2));
                  if (f14 < 1.1) {
                     f14 = 1.1F;
                  }

                  this.regz(i7, Math.abs(this.scz[i7] * f14 * trackers.dam[j5]), conto);
                  this.scz[i7] = this.scz[i7] + Math.abs(this.scz[i7] * f14);
                  this.skid = 2;
                  flag2 = true;
                  aflag[i7] = true;
                  control.wall = j5;
               }

               if (trackers.zy[j5] == 90 && af1[i7] > trackers.z[j5] - trackers.radz[j5] && this.scz[i7] > 0.0F) {
                  af1[i7] = trackers.z[j5] - trackers.radz[j5];
                  float f15 = 0.0F;
                  int iiii = 0;

                  do {
                     if (i7 != f15 && af1[iiii] <= trackers.z[j5] - trackers.radz[j5]) {
                        af1[iiii] -= af1[i7] - (trackers.z[j5] - trackers.radz[j5]);
                     }
                  } while (++f15 < 4.0F);

                  f15 = Math.abs(this.m.cos(this.pxy)) + Math.abs(this.m.cos(this.pzy));
                  f15 /= 4.0F;
                  if (f15 > 0.3) {
                     f15 = 0.3F;
                  }

                  if (flag4) {
                     f15 = 0.0F;
                  }

                  f15 = (float)(f15 + (this.bounce[this.cn] - 0.2));
                  if (f15 < 1.1) {
                     f15 = 1.1F;
                  }

                  this.regz(i7, -Math.abs(this.scz[i7] * f15 * trackers.dam[j5]), conto);
                  this.scz[i7] = this.scz[i7] - Math.abs(this.scz[i7] * f15);
                  this.skid = 2;
                  flag2 = true;
                  aflag[i7] = true;
                  control.wall = j5;
               }

               if (trackers.xy[j5] == -90 && af[i7] < trackers.x[j5] + trackers.radx[j5] && this.scx[i7] < 0.0F) {
                  af[i7] = trackers.x[j5] + trackers.radx[j5];
                  float f16 = 0.0F;
                  int iiii = 0;

                  do {
                     if (i7 != f16 && af[iiii] >= trackers.x[j5] + trackers.radx[j5]) {
                        af[iiii] -= af[i7] - (trackers.x[j5] + trackers.radx[j5]);
                     }
                  } while (++f16 < 4.0F);

                  f16 = Math.abs(this.m.cos(this.pxy)) + Math.abs(this.m.cos(this.pzy));
                  f16 /= 4.0F;
                  if (f16 > 0.3) {
                     f16 = 0.3F;
                  }

                  if (flag4) {
                     f16 = 0.0F;
                  }

                  f16 = (float)(f16 + (this.bounce[this.cn] - 0.2));
                  if (f16 < 1.1) {
                     f16 = 1.1F;
                  }

                  this.regx(i7, Math.abs(this.scx[i7] * f16 * trackers.dam[j5]), conto);
                  this.scx[i7] = this.scx[i7] + Math.abs(this.scx[i7] * f16);
                  this.skid = 2;
                  flag2 = true;
                  aflag[i7] = true;
                  control.wall = j5;
               }

               if (trackers.xy[j5] == 90 && af[i7] > trackers.x[j5] - trackers.radx[j5] && this.scx[i7] > 0.0F) {
                  af[i7] = trackers.x[j5] - trackers.radx[j5];
                  float f17 = 0.0F;
                  int iiii = 0;

                  do {
                     if (i7 != f17 && af[iiii] <= trackers.x[j5] - trackers.radx[j5]) {
                        af[iiii] -= af[i7] - (trackers.x[j5] - trackers.radx[j5]);
                     }
                  } while (++f17 < 4.0F);

                  f17 = Math.abs(this.m.cos(this.pxy)) + Math.abs(this.m.cos(this.pzy));
                  f17 /= 4.0F;
                  if (f17 > 0.3) {
                     f17 = 0.3F;
                  }

                  if (flag4) {
                     f17 = 0.0F;
                  }

                  f17 = (float)(f17 + (this.bounce[this.cn] - 0.2));
                  if (f17 < 1.1) {
                     f17 = 1.1F;
                  }

                  this.regx(i7, -Math.abs(this.scx[i7] * f17 * trackers.dam[j5]), conto);
                  this.scx[i7] = this.scx[i7] - Math.abs(this.scx[i7] * f17);
                  this.skid = 2;
                  flag2 = true;
                  aflag[i7] = true;
                  control.wall = j5;
               }

               if (trackers.zy[j5] != 0 && trackers.zy[j5] != 90 && trackers.zy[j5] != -90) {
                  int l7 = 90 + trackers.zy[j5];
                  float f19 = 1.0F + (50 - Math.abs(trackers.zy[j5])) / 30.0F;
                  if (f19 < 1.0F) {
                     f19 = 1.0F;
                  }

                  float f21 = trackers.y[j5] + ((af2[i7] - trackers.y[j5]) * this.m.cos(l7) - (af1[i7] - trackers.z[j5]) * this.m.sin(l7));
                  float f23 = trackers.z[j5] + ((af2[i7] - trackers.y[j5]) * this.m.sin(l7) + (af1[i7] - trackers.z[j5]) * this.m.cos(l7));
                  if (f23 > trackers.z[j5] && f23 < trackers.z[j5] + 200) {
                     this.scy[i7] = this.scy[i7] - (f23 - trackers.z[j5]) / f19;
                     f23 = trackers.z[j5];
                  }

                  if (f23 > trackers.z[j5] - 30) {
                     if (trackers.skd[j5] == 2) {
                        l5++;
                     } else {
                        l4++;
                     }

                     this.wtouch = true;
                     this.gtouch = false;
                     if (!flag4 && k3 != 0) {
                        float f25 = 1.4F;
                        conto.dust(i7, af[i7], af2[i7], af1[i7], this.scx[i7], this.scz[i7], f25 * this.simag[this.cn], true, 0);
                     }
                  }

                  af2[i7] = trackers.y[j5] + ((f21 - trackers.y[j5]) * this.m.cos(-l7) - (f23 - trackers.z[j5]) * this.m.sin(-l7));
                  af1[i7] = trackers.z[j5] + ((f21 - trackers.y[j5]) * this.m.sin(-l7) + (f23 - trackers.z[j5]) * this.m.cos(-l7));
                  aflag[i7] = true;
               }

               if (trackers.xy[j5] != 0 && trackers.xy[j5] != 90 && trackers.xy[j5] != -90) {
                  int i8 = 90 + trackers.xy[j5];
                  float f20 = 1.0F + (50 - Math.abs(trackers.xy[j5])) / 30.0F;
                  if (f20 < 1.0F) {
                     f20 = 1.0F;
                  }

                  float f22 = trackers.y[j5] + ((af2[i7] - trackers.y[j5]) * this.m.cos(i8) - (af[i7] - trackers.x[j5]) * this.m.sin(i8));
                  float f24 = trackers.x[j5] + ((af2[i7] - trackers.y[j5]) * this.m.sin(i8) + (af[i7] - trackers.x[j5]) * this.m.cos(i8));
                  if (f24 > trackers.x[j5] && f24 < trackers.x[j5] + 200) {
                     this.scy[i7] = this.scy[i7] - (f24 - trackers.x[j5]) / f20;
                     f24 = trackers.x[j5];
                  }

                  if (f24 > trackers.x[j5] - 30) {
                     if (trackers.skd[j5] == 2) {
                        l5++;
                     } else {
                        l4++;
                     }

                     this.wtouch = true;
                     this.gtouch = false;
                     if (!flag4 && k3 != 0) {
                        float f26 = 1.4F;
                        conto.dust(i7, af[i7], af2[i7], af1[i7], this.scx[i7], this.scz[i7], f26 * this.simag[this.cn], true, 0);
                     }
                  }

                  af2[i7] = trackers.y[j5] + ((f22 - trackers.y[j5]) * this.m.cos(-i8) - (f24 - trackers.x[j5]) * this.m.sin(-i8));
                  af[i7] = trackers.x[j5] + ((f22 - trackers.y[j5]) * this.m.sin(-i8) + (f24 - trackers.x[j5]) * this.m.cos(-i8));
                  aflag[i7] = true;
               }
            }
         } while (++i7 < 4);

         if (l5 == 4) {
            this.mtouch = true;
         }

         if (j6 == 4) {
            i4 = 4;
         }
      }

      if (l4 == 4) {
         this.mtouch = true;
      }

      int k5 = 0;
      int i6 = 0;
      int k6 = 0;
      int j7 = 0;
      if (this.scy[2] != this.scy[0]) {
         byte var42;
         if (this.scy[2] < this.scy[0]) {
            var42 = -1;
         } else {
            var42 = 1;
         }

         double d2 = Math.sqrt((af1[0] - af1[2]) * (af1[0] - af1[2]) + (af2[0] - af2[2]) * (af2[0] - af2[2]) + (af[0] - af[2]) * (af[0] - af[2]))
            / (Math.abs(conto.keyz[0]) + Math.abs(conto.keyz[2]));
         if (d2 >= 0.9998) {
            k5 = var42;
         } else {
            k5 = (int)(Math.acos(d2) / (Math.PI / 180.0) * var42);
         }
      }

      if (this.scy[3] != this.scy[1]) {
         byte var43;
         if (this.scy[3] < this.scy[1]) {
            var43 = -1;
         } else {
            var43 = 1;
         }

         double d3 = Math.sqrt((af1[1] - af1[3]) * (af1[1] - af1[3]) + (af2[1] - af2[3]) * (af2[1] - af2[3]) + (af[1] - af[3]) * (af[1] - af[3]))
            / (Math.abs(conto.keyz[1]) + Math.abs(conto.keyz[3]));
         if (d3 >= 0.9998) {
            i6 = var43;
         } else {
            i6 = (int)(Math.acos(d3) / (Math.PI / 180.0) * var43);
         }
      }

      if (this.scy[1] != this.scy[0]) {
         byte var44;
         if (this.scy[1] < this.scy[0]) {
            var44 = -1;
         } else {
            var44 = 1;
         }

         double d4 = Math.sqrt((af1[0] - af1[1]) * (af1[0] - af1[1]) + (af2[0] - af2[1]) * (af2[0] - af2[1]) + (af[0] - af[1]) * (af[0] - af[1]))
            / (Math.abs(conto.keyx[0]) + Math.abs(conto.keyx[1]));
         if (d4 >= 0.9998) {
            k6 = var44;
         } else {
            k6 = (int)(Math.acos(d4) / (Math.PI / 180.0) * var44);
         }
      }

      if (this.scy[3] != this.scy[2]) {
         byte var45;
         if (this.scy[3] < this.scy[2]) {
            var45 = -1;
         } else {
            var45 = 1;
         }

         double d5 = Math.sqrt((af1[2] - af1[3]) * (af1[2] - af1[3]) + (af2[2] - af2[3]) * (af2[2] - af2[3]) + (af[2] - af[3]) * (af[2] - af[3]))
            / (Math.abs(conto.keyx[2]) + Math.abs(conto.keyx[3]));
         if (d5 >= 0.9998) {
            j7 = var45;
         } else {
            j7 = (int)(Math.acos(d5) / (Math.PI / 180.0) * var45);
         }
      }

      if (flag2) {
         int j8 = Math.abs(conto.xz + 45);

         while (j8 > 180) {
            j8 -= 360;
         }

         if (Math.abs(j8) > 90) {
            this.pmlt = 1;
         } else {
            this.pmlt = -1;
         }

         j8 = Math.abs(conto.xz - 45);

         while (j8 > 180) {
            j8 -= 360;
         }

         if (Math.abs(j8) > 90) {
            this.nmlt = 1;
         } else {
            this.nmlt = -1;
         }
      }

      conto.xz = (int)(
         conto.xz
            + this.forca
               * (
                  this.scz[0] * this.nmlt
                     - this.scz[1] * this.pmlt
                     + this.scz[2] * this.pmlt
                     - this.scz[3] * this.nmlt
                     + this.scx[0] * this.pmlt
                     + this.scx[1] * this.nmlt
                     - this.scx[2] * this.nmlt
                     - this.scx[3] * this.pmlt
               )
      );
      if (Math.abs(i6) > Math.abs(k5)) {
         k5 = i6;
      }

      if (Math.abs(j7) > Math.abs(k6)) {
         k6 = j7;
      }

      if (!flag) {
         this.pzy += k5;
      } else {
         this.pzy -= k5;
      }

      if (!flag3) {
         this.pxy += k6;
      } else {
         this.pxy -= k6;
      }

      if (i4 == 4) {
         int k8;
         for (k8 = 0; this.pzy < 360; conto.zy += 360) {
            this.pzy += 360;
         }

         while (this.pzy > 360) {
            this.pzy -= 360;
            conto.zy -= 360;
         }

         if (this.pzy < 190 && this.pzy > 170) {
            this.pzy = 180;
            conto.zy = 180;
            k8++;
         }

         if (this.pzy > 350 || this.pzy < 10) {
            this.pzy = 0;
            conto.zy = 0;
            k8++;
         }

         while (this.pxy < 360) {
            this.pxy += 360;
            conto.xy += 360;
         }

         while (this.pxy > 360) {
            this.pxy -= 360;
            conto.xy -= 360;
         }

         if (this.pxy < 190 && this.pxy > 170) {
            this.pxy = 180;
            conto.xy = 180;
            k8++;
         }

         if (this.pxy > 350 || this.pxy < 10) {
            this.pxy = 0;
            conto.xy = 0;
            k8++;
         }

         if (k8 == 2) {
            this.mtouch = true;
         }
      }

      if (this.mtouch || !this.wtouch) {
         this.cntouch = 0;
      } else if (this.cntouch == 10) {
         this.mtouch = true;
      } else {
         this.cntouch++;
      }

      conto.y = (int)((af2[0] + af2[1] + af2[2] + af2[3]) / 4.0F - i1 * this.m.cos(this.pzy) * this.m.cos(this.pxy) + f2);
      byte var46;
      if (flag) {
         var46 = -1;
      } else {
         var46 = 1;
      }

      conto.x = (int)(
         (
                  af[0]
                     - conto.keyx[0] * this.m.cos(conto.xz)
                     + var46 * conto.keyz[0] * this.m.sin(conto.xz)
                     + af[1]
                     - conto.keyx[1] * this.m.cos(conto.xz)
                     + var46 * conto.keyz[1] * this.m.sin(conto.xz)
                     + af[2]
                     - conto.keyx[2] * this.m.cos(conto.xz)
                     + var46 * conto.keyz[2] * this.m.sin(conto.xz)
                     + af[3]
                     - conto.keyx[3] * this.m.cos(conto.xz)
                     + var46 * conto.keyz[3] * this.m.sin(conto.xz)
               )
               / 4.0F
            + i1 * this.m.sin(this.pxy) * this.m.cos(conto.xz)
            - i1 * this.m.sin(this.pzy) * this.m.sin(conto.xz)
            + f
      );
      conto.z = (int)(
         (
                  af1[0]
                     - var46 * conto.keyz[0] * this.m.cos(conto.xz)
                     - conto.keyx[0] * this.m.sin(conto.xz)
                     + af1[1]
                     - var46 * conto.keyz[1] * this.m.cos(conto.xz)
                     - conto.keyx[1] * this.m.sin(conto.xz)
                     + af1[2]
                     - var46 * conto.keyz[2] * this.m.cos(conto.xz)
                     - conto.keyx[2] * this.m.sin(conto.xz)
                     + af1[3]
                     - var46 * conto.keyz[3] * this.m.cos(conto.xz)
                     - conto.keyx[3] * this.m.sin(conto.xz)
               )
               / 4.0F
            + i1 * this.m.sin(this.pxy) * this.m.sin(conto.xz)
            - i1 * this.m.sin(this.pzy) * this.m.cos(conto.xz)
            + f1
      );
      if (Math.abs(this.speed) > 10.0F || !this.mtouch) {
         if (Math.abs(this.pxy - conto.xy) >= 4) {
            if (this.pxy > conto.xy) {
               conto.xy = conto.xy + 2 + (this.pxy - conto.xy) / 2;
            } else {
               conto.xy = conto.xy - (2 + (conto.xy - this.pxy) / 2);
            }
         } else {
            conto.xy = this.pxy;
         }

         if (Math.abs(this.pzy - conto.zy) >= 4) {
            if (this.pzy > conto.zy) {
               conto.zy = conto.zy + 2 + (this.pzy - conto.zy) / 2;
            } else {
               conto.zy = conto.zy - (2 + (conto.zy - this.pzy) / 2);
            }
         } else {
            conto.zy = this.pzy;
         }
      }

      if (this.wtouch && !this.capsized) {
         float f18 = (float)(this.speed / this.swits[this.cn][2] * 0.0F * (this.bounce[this.cn] - 0.4));
         if (control.left && this.tilt < f18 && this.tilt >= 0.0F) {
            this.tilt = (float)(this.tilt + 0.4);
         } else if (control.right && this.tilt > -f18 && this.tilt <= 0.0F) {
            this.tilt = (float)(this.tilt - 0.4);
         } else if (Math.abs(this.tilt) > 3.0 * (this.bounce[this.cn] - 0.4)) {
            if (this.tilt > 0.0F) {
               this.tilt = (float)(this.tilt - 3.0 * (this.bounce[this.cn] - 0.3));
            } else {
               this.tilt = (float)(this.tilt + 3.0 * (this.bounce[this.cn] - 0.3));
            }
         } else {
            this.tilt = 0.0F;
         }

         conto.xy = (int)(conto.xy + this.tilt);
         if (this.gtouch) {
            conto.y = (int)(conto.y - this.tilt / 1.5);
         }
      } else if (this.tilt != 0.0F) {
         this.tilt = 0.0F;
      }

      if (this.wtouch && k3 == 2) {
         conto.zy = conto.zy
            + (int)((this.m.random() * 6.0F * this.speed / this.swits[this.cn][2] - 3.0F * this.speed / this.swits[this.cn][2]) * (this.bounce[this.cn] - 0.3));
         conto.xy = conto.xy
            + (int)((this.m.random() * 6.0F * this.speed / this.swits[this.cn][2] - 3.0F * this.speed / this.swits[this.cn][2]) * (this.bounce[this.cn] - 0.3));
      }

      if (this.wtouch && k3 == 1) {
         conto.zy = conto.zy
            + (int)((this.m.random() * 4.0F * this.speed / this.swits[this.cn][2] - 2.0F * this.speed / this.swits[this.cn][2]) * (this.bounce[this.cn] - 0.3));
         conto.xy = conto.xy
            + (int)((this.m.random() * 4.0F * this.speed / this.swits[this.cn][2] - 2.0F * this.speed / this.swits[this.cn][2]) * (this.bounce[this.cn] - 0.3));
      }

      if (this.hitmag > this.maxmag[this.cn] && !this.dest) {
         this.distruct(conto);
         if (this.cntdest == 7) {
            this.dest = true;
         } else {
            this.cntdest++;
         }

         if (this.cntdest == 1) {
            this.rpd.dest[this.im] = 300;
         }
      }

      if (conto.dist == 0) {
         for (int l8 = 0; l8 < conto.npl; l8++) {
            if (conto.p[l8].chip != 0) {
               conto.p[l8].chip = 0;
            }

            if (conto.p[l8].embos != 0) {
               conto.p[l8].embos = 13;
            }
         }
      }

      int i9 = 0;
      int j9 = 0;
      int k9 = 0;
      byte var47;
      if (this.nofocus) {
         var47 = 1;
      } else {
         var47 = 7;
      }

      for (int i10 = 0; i10 < checkpoints.n; i10++) {
         if (checkpoints.typ[i10] > 0) {
            k9++;
            if (checkpoints.typ[i10] == 1) {
               if (this.clear == k9 + this.nlaps * checkpoints.nsp) {
                  var47 = 1;
               }

               if (Math.abs(conto.z - checkpoints.z[i10]) < 60.0F + Math.abs(this.scz[0] + this.scz[1] + this.scz[2] + this.scz[3]) / 4.0F
                  && Math.abs(conto.x - checkpoints.x[i10]) < 700
                  && Math.abs(conto.y - checkpoints.y[i10]) < 800
                  && this.clear == k9 + this.nlaps * checkpoints.nsp - 1) {
                  this.clear = k9 + this.nlaps * checkpoints.nsp;
                  this.pcleared = i10;
                  this.focus = -1;
               }
            }

            if (checkpoints.typ[i10] == 2) {
               if (this.clear == k9 + this.nlaps * checkpoints.nsp) {
                  var47 = 1;
               }

               if (Math.abs(conto.x - checkpoints.x[i10]) < 60.0F + Math.abs(this.scx[0] + this.scx[1] + this.scx[2] + this.scx[3]) / 4.0F
                  && Math.abs(conto.z - checkpoints.z[i10]) < 700
                  && Math.abs(conto.y - checkpoints.y[i10]) < 800
                  && this.clear == k9 + this.nlaps * checkpoints.nsp - 1) {
                  this.clear = k9 + this.nlaps * checkpoints.nsp;
                  this.pcleared = i10;
                  this.focus = -1;
               }
            }
         }

         if (this.py(conto.x / 100, checkpoints.x[i10] / 100, conto.z / 100, checkpoints.z[i10] / 100) * var47 < j9 || j9 == 0) {
            i9 = i10;
            j9 = this.py(conto.x / 100, checkpoints.x[i10] / 100, conto.z / 100, checkpoints.z[i10] / 100) * var47;
         }
      }

      if (this.clear == k9 + this.nlaps * checkpoints.nsp) {
         this.nlaps++;
      }

      if (this.focus == -1) {
         if (this.im == 0) {
            i9 += 2;
         } else {
            i9++;
         }

         if (!this.nofocus) {
            int l9 = this.pcleared + 1;

            while (checkpoints.typ[l9] <= 0) {
               if (++l9 == checkpoints.n) {
                  l9 = 0;
               }
            }

            if (i9 > l9 && (this.clear != this.nlaps * checkpoints.nsp || i9 < this.pcleared)) {
               i9 = l9;
               this.focus = l9;
            }
         }

         if (i9 >= checkpoints.n) {
            i9 -= checkpoints.n;
         }

         if (checkpoints.typ[i9] == -3) {
            i9 = 0;
         }

         if (this.im == 0) {
            if (this.missedcp != -1) {
               this.missedcp = -1;
            }
         } else if (this.missedcp != 0) {
            this.missedcp = 0;
         }
      } else {
         i9 = this.focus;
         if (this.im == 0) {
            if (this.missedcp == 0
               && this.mtouch
               && Math.sqrt(this.py(conto.x / 10, checkpoints.x[this.focus] / 10, conto.z / 10, checkpoints.z[this.focus] / 10)) > 800.0) {
               this.missedcp = 1;
            }

            if (this.missedcp == -2 && Math.sqrt(this.py(conto.x / 10, checkpoints.x[this.focus] / 10, conto.z / 10, checkpoints.z[this.focus] / 10)) < 400.0) {
               this.missedcp = 0;
            }

            if (this.missedcp != 0
               && this.mtouch
               && Math.sqrt(this.py(conto.x / 10, checkpoints.x[this.focus] / 10, conto.z / 10, checkpoints.z[this.focus] / 10)) < 250.0) {
               this.missedcp = 68;
            }
         } else {
            this.missedcp = 1;
         }

         if (this.nofocus) {
            this.focus = -1;
            this.missedcp = 0;
         }
      }

      if (this.nofocus) {
         this.nofocus = false;
      }

      this.point = i9;

      for (int j10 = 0; j10 < checkpoints.fn; j10++) {
         if (!checkpoints.roted[j10]) {
            if (Math.abs(conto.z - checkpoints.fz[j10]) < 200
               && this.py(conto.x / 100, checkpoints.fx[j10] / 100, conto.y / 100, checkpoints.fy[j10] / 100) < 30) {
               if (conto.dist == 0) {
                  conto.fcnt = 8;
               } else {
                  if (this.im == 0 && !conto.fix && !this.xt.mutes) {
                     this.xt.carfixed.play();
                  }

                  conto.fix = true;
               }

               this.rpd.fix[this.im] = 300;
            }
         } else if (Math.abs(conto.x - checkpoints.fx[j10]) < 200
            && this.py(conto.z / 100, checkpoints.fz[j10] / 100, conto.y / 100, checkpoints.fy[j10] / 100) < 30) {
            if (conto.dist == 0) {
               conto.fcnt = 8;
            } else {
               if (this.im == 0 && !conto.fix && !this.xt.mutes) {
                  this.xt.carfixed.play();
               }

               conto.fix = true;
            }

            this.rpd.fix[this.im] = 300;
         }
      }

      if (conto.fcnt == 7 || conto.fcnt == 8) {
         this.squash = 0;
         this.nbsq = 0;
         this.hitmag = 0;
         this.cntdest = 0;
         this.dest = false;
         this.newcar = true;
      }

      if (!this.mtouch) {
         if (this.trcnt != 1) {
            this.trcnt = 1;
            this.lxz = conto.xz;
         }

         if (this.loop == 2 || this.loop == -1) {
            this.travxy = (int)(this.travxy + (this.rcomp - this.lcomp));
            if (Math.abs(this.travxy) > 135) {
               this.rtab = true;
            }

            this.travzy = (int)(this.travzy + (this.ucomp - this.dcomp));
            if (this.travzy > 135) {
               this.ftab = true;
            }

            if (this.travzy < -135) {
               this.btab = true;
            }
         }

         if (this.lxz != conto.xz) {
            this.travxz = this.travxz + (this.lxz - conto.xz);
            this.lxz = conto.xz;
         }

         if (this.srfcnt < 10) {
            if (control.wall != -1) {
               this.surfer = true;
            }

            this.srfcnt++;
         }
      } else if (!this.dest) {
         if (!this.capsized) {
            if (this.capcnt != 0) {
               this.capcnt = 0;
            }

            if (this.gtouch && this.trcnt != 0) {
               if (this.trcnt == 9) {
                  this.powerup = 0.0F;
                  if (Math.abs(this.travxy) > 90) {
                     this.powerup = this.powerup + Math.abs(this.travxy) / 24.0F;
                  } else if (this.rtab) {
                     this.powerup += 30.0F;
                  }

                  if (Math.abs(this.travzy) > 90) {
                     this.powerup = this.powerup + Math.abs(this.travzy) / 18.0F;
                  } else {
                     if (this.ftab) {
                        this.powerup += 40.0F;
                     }

                     if (this.btab) {
                        this.powerup += 40.0F;
                     }
                  }

                  if (Math.abs(this.travxz) > 90) {
                     this.powerup = this.powerup + Math.abs(this.travxz) / 18.0F;
                  }

                  if (this.surfer) {
                     this.powerup += 30.0F;
                  }

                  this.power = this.power + this.powerup;
                  if (this.im == 0 && (int)this.powerup > this.rpd.powered && this.rpd.wasted == 0 && this.powerup > 60.0F) {
                     this.rpd.cotchinow(0);
                     if (this.rpd.hcaught) {
                        this.rpd.whenwasted = 225;
                        this.rpd.powered = (int)this.powerup;
                     }
                  }

                  if (this.power > Float.POSITIVE_INFINITY) {
                     this.power = Float.POSITIVE_INFINITY;
                     if (this.powerup > 150.0F) {
                        this.xtpower = 200;
                     } else {
                        this.xtpower = 100;
                     }
                  }
               }

               if (this.trcnt == 10) {
                  this.travxy = 0;
                  this.travzy = 0;
                  this.travxz = 0;
                  this.ftab = false;
                  this.rtab = false;
                  this.btab = false;
                  this.trcnt = 0;
                  this.srfcnt = 0;
                  this.surfer = false;
               } else {
                  this.trcnt++;
               }
            }
         } else {
            if (this.trcnt != 0) {
               this.travxy = 0;
               this.travzy = 0;
               this.travxz = 0;
               this.ftab = false;
               this.rtab = false;
               this.btab = false;
               this.trcnt = 0;
               this.srfcnt = 0;
               this.surfer = false;
            }

            if (this.capcnt == 0) {
               int k10 = 0;
               int l10 = 0;

               do {
                  if (Math.abs(this.scz[l10]) < 70.0F && Math.abs(this.scx[l10]) < 70.0F) {
                     k10++;
                  }
               } while (++l10 < 4);

               if (k10 == 4) {
                  this.capcnt = 1;
               }
            } else {
               this.capcnt++;
               if (this.capcnt == 30) {
                  this.speed = 0.0F;
                  conto.y = conto.y + this.flipy[this.cn];
                  this.pxy += 180;
                  conto.xy += 180;
                  this.capcnt = 0;
               }
            }
         }

         if (this.trcnt == 0) {
            if (this.xtpower == 0) {
               if (this.power > 0.0F) {
                  this.power = this.power - this.power * this.power * this.power / this.powerloss[this.cn];
               } else {
                  this.power = 0.0F;
               }
            } else {
               this.xtpower--;
            }
         }
      }

      if (this.im == 0) {
         if (control.wall != -1) {
            control.wall = -1;
         }
      } else if (this.lastcolido != 0 && !this.dest) {
         this.lastcolido--;
      }

      if (this.dest) {
         if (checkpoints.dested[this.im] == 0) {
            if (this.lastcolido == 0) {
               checkpoints.dested[this.im] = 1;
            } else {
               checkpoints.dested[this.im] = 2;
            }
         }
      } else if (checkpoints.dested[this.im] != 0) {
         checkpoints.dested[this.im] = 0;
      }
   }
}
