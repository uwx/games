import java.awt.Color;

public class Record {
   Medium m;
   int caught;
   boolean hcaught;
   boolean prepit;
   ContO[] ocar;
   int cntf;
   ContO[][] car;
   int[][] squash;
   int[] fix;
   int[] dest;
   int[][] x;
   int[][] y;
   int[][] z;
   int[][] xy;
   int[][] zy;
   int[][] xz;
   int[][] wxz;
   int[][] wzy;
   int[][] ns;
   int[][][] sspark;
   int[][][] sx;
   int[][][] sy;
   int[][][] sz;
   float[][][] smag;
   int[][][] scx;
   int[][][] scz;
   boolean[][][] fulls;
   int[][] nry;
   int[][][] ry;
   int[][][] magy;
   boolean[][] mtouch;
   int[][] nrx;
   int[][][] rx;
   int[][][] magx;
   int[][] nrz;
   int[][][] rz;
   int[][][] magz;
   int[] checkpoint;
   boolean[] lastcheck;
   int wasted;
   int whenwasted;
   int powered;
   int closefinish;
   ContO[] starcar;
   int[] hsquash;
   int[] hfix = new int[]{-1, -1, -1, -1, -1, -1, -1};
   int[] hdest = new int[]{-1, -1, -1, -1, -1, -1, -1};
   int[][] hx;
   int[][] hy;
   int[][] hz;
   int[][] hxy;
   int[][] hzy;
   int[][] hxz;
   int[][] hwxz;
   int[][] hwzy;
   int[][] hns;
   int[][][] hsspark;
   int[][][] hsx;
   int[][][] hsy;
   int[][][] hsz;
   float[][][] hsmag;
   int[][][] hscx;
   int[][][] hscz;
   boolean[][][] hfulls;
   int[][] hnry;
   int[][][] hry;
   int[][][] hmagy;
   int[][] hnrx;
   int[][][] hrx;
   int[][][] hmagx;
   int[][] hnrz;
   int[][][] hrz;
   int[][][] hmagz;
   boolean[][] hmtouch;
   int[] hcheckpoint;
   boolean[] hlastcheck;
   int[] cntdest;
   int lastfr;

   public void regy(int i, float f, boolean flag, ContO conto, Madness madness) {
      if (f > 100.0F) {
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

         if (byte1 * byte0 == 0 || flag) {
            for (int l = 0; l < conto.npl; l++) {
               float f1 = 0.0F;

               for (int k1 = 0; k1 < conto.p[l].n; k1++) {
                  if (conto.p[l].wz == 0 && this.py(conto.keyx[i], conto.p[l].ox[k1], conto.keyz[i], conto.p[l].oz[k1]) < madness.clrad[madness.cn]) {
                     f1 = f / 20.0F * this.m.random();
                     conto.p[l].oz[k1] = (int)(conto.p[l].oz[k1] + f1 * this.m.sin(j));
                     conto.p[l].ox[k1] = (int)(conto.p[l].ox[k1] - f1 * this.m.sin(k));
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
                     conto.p[l].gr = (int)(conto.p[l].gr + Math.abs(f1 * 1.5));
                  }
               }
            }
         }

         if (byte1 * byte0 == -1) {
            int i1 = 0;
            int j1 = 1;

            for (int l1 = 0; l1 < conto.npl; l1++) {
               float f2 = 0.0F;

               for (int i2 = 0; i2 < conto.p[l1].n; i2++) {
                  if (conto.p[l1].wz == 0) {
                     f2 = f / 15.0F * this.m.random();
                     if ((
                           Math.abs(conto.p[l1].oy[i2] - madness.flipy[madness.cn] - this.squash[0][madness.im]) < madness.msquash[madness.cn] * 3
                              || conto.p[l1].oy[i2] < madness.flipy[madness.cn] + this.squash[0][madness.im]
                        )
                        && this.squash[0][madness.im] < madness.msquash[madness.cn]) {
                        conto.p[l1].oy[i2] = (int)(conto.p[l1].oy[i2] + f2);
                        i1 = (int)(i1 + f2);
                        j1++;
                     }
                  }
               }

               if (conto.p[l1].glass) {
                  conto.p[l1].gr += 5;
               } else if (f2 != 0.0F) {
                  conto.p[l1].bfase = (int)(conto.p[l1].bfase + f2);
               }

               if (Math.abs(f2) >= 1.0F) {
                  conto.p[l1].chip = 1;
                  conto.p[l1].ctmag = f2;
               }
            }

            this.squash[0][madness.im] = this.squash[0][madness.im] + i1 / j1;
         }
      }
   }

   public void reset(ContO[] aconto) {
      this.caught = 0;
      this.hcaught = false;
      this.wasted = 0;
      this.whenwasted = 0;
      this.closefinish = 0;
      this.powered = 0;
      int i = 0;

      do {
         if (this.prepit) {
            this.starcar[i] = new ContO(aconto[i], 0, 0, 0, 0);
         }

         this.fix[i] = -1;
         this.dest[i] = -1;
         this.cntdest[i] = 0;
      } while (++i < 7);

      i = 0;

      do {
         int j = 0;

         do {
            this.car[i][j] = new ContO(aconto[j], 0, 0, 0, 0);
            this.squash[i][j] = 0;
         } while (++j < 7);
      } while (++i < 6);

      i = 0;

      do {
         int k = 0;

         do {
            int l = 0;

            do {
               this.sspark[i][k][l] = -1;
               this.ns[i][k] = 0;
            } while (++l < 30);

            l = 0;

            do {
               this.ry[i][k][l] = -1;
               this.nry[i][k] = 0;
               this.rx[i][k][l] = -1;
               this.nrx[i][k] = 0;
               this.rz[i][k][l] = -1;
               this.nrz[i][k] = 0;
            } while (++l < 7);
         } while (++k < 4);
      } while (++i < 7);

      this.prepit = false;
   }

   public Record(Medium medium) {
      this.caught = 0;
      this.hcaught = false;
      this.prepit = true;
      this.ocar = new ContO[7];
      this.cntf = 50;
      this.car = new ContO[6][7];
      this.squash = new int[6][7];
      this.fix = new int[7];
      this.dest = new int[7];
      this.x = new int[300][7];
      this.y = new int[300][7];
      this.z = new int[300][7];
      this.xy = new int[300][7];
      this.zy = new int[300][7];
      this.xz = new int[300][7];
      this.wxz = new int[300][7];
      this.wzy = new int[300][7];
      this.ns = new int[7][4];
      this.sspark = new int[7][4][30];
      this.sx = new int[7][4][30];
      this.sy = new int[7][4][30];
      this.sz = new int[7][4][30];
      this.smag = new float[7][4][30];
      this.scx = new int[7][4][30];
      this.scz = new int[7][4][30];
      this.fulls = new boolean[7][4][30];
      this.nry = new int[7][4];
      this.ry = new int[7][4][7];
      this.magy = new int[7][4][7];
      this.mtouch = new boolean[7][7];
      this.nrx = new int[7][4];
      this.rx = new int[7][4][7];
      this.magx = new int[7][4][7];
      this.nrz = new int[7][4];
      this.rz = new int[7][4][7];
      this.magz = new int[7][4][7];
      this.checkpoint = new int[300];
      this.lastcheck = new boolean[300];
      this.wasted = 0;
      this.whenwasted = 0;
      this.powered = 0;
      this.closefinish = 0;
      this.starcar = new ContO[7];
      this.hsquash = new int[7];
      this.hx = new int[300][7];
      this.hy = new int[300][7];
      this.hz = new int[300][7];
      this.hxy = new int[300][7];
      this.hzy = new int[300][7];
      this.hxz = new int[300][7];
      this.hwxz = new int[300][7];
      this.hwzy = new int[300][7];
      this.hns = new int[7][4];
      this.hsspark = new int[7][4][30];
      this.hsx = new int[7][4][30];
      this.hsy = new int[7][4][30];
      this.hsz = new int[7][4][30];
      this.hsmag = new float[7][4][30];
      this.hscx = new int[7][4][30];
      this.hscz = new int[7][4][30];
      this.hfulls = new boolean[7][4][30];
      this.hnry = new int[7][4];
      this.hry = new int[7][4][7];
      this.hmagy = new int[7][4][7];
      this.hnrx = new int[7][4];
      this.hrx = new int[7][4][7];
      this.hmagx = new int[7][4][7];
      this.hnrz = new int[7][4];
      this.hrz = new int[7][4][7];
      this.hmagz = new int[7][4][7];
      this.hmtouch = new boolean[7][7];
      this.hcheckpoint = new int[300];
      this.hlastcheck = new boolean[300];
      this.cntdest = new int[7];
      this.lastfr = 0;
      this.m = medium;
      this.caught = 0;
      this.cotchinow(0);
   }

   public void playh(ContO conto, Madness madness, int i, int j) {
      conto.x = this.hx[j][i];
      conto.y = this.hy[j][i];
      conto.z = this.hz[j][i];
      conto.zy = this.hzy[j][i];
      conto.xy = this.hxy[j][i];
      conto.xz = this.hxz[j][i];
      conto.wxz = this.hwxz[j][i];
      conto.wzy = this.hwzy[j][i];
      if (i == 0) {
         conto.m.checkpoint = this.hcheckpoint[j];
         conto.m.lastcheck = this.hlastcheck[j];
      }

      if (j == 0) {
         this.cntdest[i] = 0;
      }

      if (this.hdest[i] == j) {
         this.cntdest[i] = 7;
      }

      if (j == 0 && this.hdest[i] < -1) {
         for (int k = 0; k < conto.npl; k++) {
            if (conto.p[k].wz == 0 || conto.p[k].gr == -17 || conto.p[k].gr == -16) {
               conto.p[k].embos = 13;
            }
         }
      }

      if (this.cntdest[i] != 0) {
         for (int l = 0; l < conto.npl; l++) {
            if (conto.p[l].wz == 0 || conto.p[l].gr == -17 || conto.p[l].gr == -16) {
               conto.p[l].embos = 1;
            }
         }

         this.cntdest[i]--;
      }

      int i1 = 0;

      do {
         int j1 = 0;

         do {
            if (this.hsspark[i][i1][j1] == j) {
               conto.stg[i1] = 1;
               conto.dov[i1] = -1;
               conto.sx[i1] = this.hsx[i][i1][j1];
               conto.sy[i1] = this.hsy[i][i1][j1];
               conto.sz[i1] = this.hsz[i][i1][j1];
               conto.smag[i1] = this.hsmag[i][i1][j1];
               conto.scx[i1] = this.hscx[i][i1][j1];
               conto.scz[i1] = this.hscz[i][i1][j1];
               conto.fulls[i1] = this.hfulls[i][i1][j1];
            }
         } while (++j1 < 30);

         j1 = 0;

         do {
            if (this.hry[i][i1][j1] == j && this.lastfr != j) {
               this.regy(i1, this.hmagy[i][i1][j1], this.hmtouch[i][j1], conto, madness);
            }

            if (this.hrx[i][i1][j1] == j) {
               if (this.lastfr != j) {
                  this.regx(i1, this.hmagx[i][i1][j1], conto, madness);
               } else {
                  this.chipx(i1, this.hmagx[i][i1][j1], conto, madness);
               }
            }

            if (this.hrz[i][i1][j1] == j) {
               if (this.lastfr != j) {
                  this.regz(i1, this.hmagz[i][i1][j1], conto, madness);
               } else {
                  this.chipz(i1, this.hmagz[i][i1][j1], conto, madness);
               }
            }
         } while (++j1 < 7);
      } while (++i1 < 4);

      this.lastfr = j;
   }

   public void chipz(int i, float f, ContO conto, Madness madness) {
      if (Math.abs(f) > 100.0F) {
         if (f > 100.0F) {
            f -= 100.0F;
         }

         if (f < -100.0F) {
            f += 100.0F;
         }

         for (int j = 0; j < conto.npl; j++) {
            float f1 = 0.0F;

            for (int k = 0; k < conto.p[j].n; k++) {
               if (conto.p[j].wz == 0 && this.py(conto.keyx[i], conto.p[j].ox[k], conto.keyz[i], conto.p[j].oz[k]) < madness.clrad[madness.cn]) {
                  f1 = f / 20.0F * this.m.random();
               }
            }

            if (f1 != 0.0F && Math.abs(f1) >= 1.0F) {
               conto.p[j].chip = 1;
               conto.p[j].ctmag = f1;
            }
         }
      }
   }

   public void regz(int i, float f, ContO conto, Madness madness) {
      if (Math.abs(f) > 100.0F) {
         if (f > 100.0F) {
            f -= 100.0F;
         }

         if (f < -100.0F) {
            f += 100.0F;
         }

         for (int j = 0; j < conto.npl; j++) {
            float f1 = 0.0F;

            for (int k = 0; k < conto.p[j].n; k++) {
               if (conto.p[j].wz == 0 && this.py(conto.keyx[i], conto.p[j].ox[k], conto.keyz[i], conto.p[j].oz[k]) < madness.clrad[madness.cn]) {
                  f1 = f / 20.0F * this.m.random();
                  conto.p[j].oz[k] = (int)(conto.p[j].oz[k] + f1 * this.m.cos(conto.xz) * this.m.cos(conto.zy));
                  conto.p[j].ox[k] = (int)(conto.p[j].ox[k] + f1 * this.m.sin(conto.xz) * this.m.cos(conto.xy));
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
                  conto.p[j].gr = (int)(conto.p[j].gr + Math.abs(f1 * 1.5));
               }
            }
         }
      }
   }

   public void play(ContO conto, Madness madness, int i, int j) {
      conto.x = this.x[j][i];
      conto.y = this.y[j][i];
      conto.z = this.z[j][i];
      conto.zy = this.zy[j][i];
      conto.xy = this.xy[j][i];
      conto.xz = this.xz[j][i];
      conto.wxz = this.wxz[j][i];
      conto.wzy = this.wzy[j][i];
      if (i == 0) {
         conto.m.checkpoint = this.checkpoint[j];
         conto.m.lastcheck = this.lastcheck[j];
      }

      if (j == 0) {
         this.cntdest[i] = 0;
      }

      if (this.dest[i] == j) {
         this.cntdest[i] = 7;
      }

      if (j == 0 && this.dest[i] < -1) {
         for (int k = 0; k < conto.npl; k++) {
            if (conto.p[k].wz == 0 || conto.p[k].gr == -17 || conto.p[k].gr == -16) {
               conto.p[k].embos = 13;
            }
         }
      }

      if (this.cntdest[i] != 0) {
         for (int l = 0; l < conto.npl; l++) {
            if (conto.p[l].wz == 0 || conto.p[l].gr == -17 || conto.p[l].gr == -16) {
               conto.p[l].embos = 1;
            }
         }

         this.cntdest[i]--;
      }

      int i1 = 0;

      do {
         int j1 = 0;

         do {
            if (this.sspark[i][i1][j1] == j) {
               conto.stg[i1] = 1;
               conto.dov[i1] = -1;
               conto.sx[i1] = this.sx[i][i1][j1];
               conto.sy[i1] = this.sy[i][i1][j1];
               conto.sz[i1] = this.sz[i][i1][j1];
               conto.smag[i1] = this.smag[i][i1][j1];
               conto.scx[i1] = this.scx[i][i1][j1];
               conto.scz[i1] = this.scz[i][i1][j1];
               conto.fulls[i1] = this.fulls[i][i1][j1];
            }
         } while (++j1 < 30);

         j1 = 0;

         do {
            if (this.ry[i][i1][j1] == j) {
               this.regy(i1, this.magy[i][i1][j1], this.mtouch[i][j1], conto, madness);
            }

            if (this.rx[i][i1][j1] == j) {
               this.regx(i1, this.magx[i][i1][j1], conto, madness);
            }

            if (this.rz[i][i1][j1] == j) {
               this.regz(i1, this.magz[i][i1][j1], conto, madness);
            }
         } while (++j1 < 7);
      } while (++i1 < 4);
   }

   public void rec(ContO conto, int i, int j, int k, int l) {
      if (i == 0) {
         this.caught++;
      }

      if (this.cntf == 50) {
         int i1 = 0;

         do {
            this.car[i1][i] = new ContO(this.car[i1 + 1][i], 0, 0, 0, 0);
            this.squash[i1][i] = this.squash[i1 + 1][i];
         } while (++i1 < 5);

         this.car[5][i] = new ContO(conto, 0, 0, 0, 0);
         this.squash[5][i] = j;
         this.cntf = 0;
      } else {
         this.cntf++;
      }

      this.fix[i]--;
      if (l != 0) {
         this.dest[i]--;
      }

      if (this.dest[i] == 230) {
         if (i == 0) {
            this.cotchinow(0);
            this.whenwasted = 229;
         } else if (k != 0) {
            this.cotchinow(i);
            this.whenwasted = 165 + k;
         }
      }

      int j1 = 0;

      do {
         this.x[j1][i] = this.x[j1 + 1][i];
         this.y[j1][i] = this.y[j1 + 1][i];
         this.z[j1][i] = this.z[j1 + 1][i];
         this.zy[j1][i] = this.zy[j1 + 1][i];
         this.xy[j1][i] = this.xy[j1 + 1][i];
         this.xz[j1][i] = this.xz[j1 + 1][i];
         this.wxz[j1][i] = this.wxz[j1 + 1][i];
         this.wzy[j1][i] = this.wzy[j1 + 1][i];
      } while (++j1 < 299);

      this.x[299][i] = conto.x;
      this.y[299][i] = conto.y;
      this.z[299][i] = conto.z;
      this.xy[299][i] = conto.xy;
      this.zy[299][i] = conto.zy;
      this.xz[299][i] = conto.xz;
      this.wxz[299][i] = conto.wxz;
      this.wzy[299][i] = conto.wzy;
      if (i == 0) {
         j1 = 0;

         do {
            this.checkpoint[j1] = this.checkpoint[j1 + 1];
            this.lastcheck[j1] = this.lastcheck[j1 + 1];
         } while (++j1 < 299);

         this.checkpoint[299] = conto.m.checkpoint;
         this.lastcheck[299] = conto.m.lastcheck;
      }

      j1 = 0;

      do {
         if (conto.stg[j1] == 1) {
            this.sspark[i][j1][this.ns[i][j1]] = 300;
            this.sx[i][j1][this.ns[i][j1]] = conto.sx[j1];
            this.sy[i][j1][this.ns[i][j1]] = conto.sy[j1];
            this.sz[i][j1][this.ns[i][j1]] = conto.sz[j1];
            this.smag[i][j1][this.ns[i][j1]] = conto.smag[j1];
            this.scx[i][j1][this.ns[i][j1]] = conto.scx[j1];
            this.scz[i][j1][this.ns[i][j1]] = conto.scz[j1];
            this.fulls[i][j1][this.ns[i][j1]] = conto.fulls[j1];
            this.ns[i][j1]++;
            if (this.ns[i][j1] == 30) {
               this.ns[i][j1] = 0;
            }
         }

         int k1 = 0;

         do {
            this.sspark[i][j1][k1]--;
         } while (++k1 < 30);

         k1 = 0;

         do {
            this.ry[i][j1][k1]--;
            this.rx[i][j1][k1]--;
            this.rz[i][j1][k1]--;
         } while (++k1 < 7);
      } while (++j1 < 4);
   }

   public void recx(int i, float f, int j) {
      this.rx[j][i][this.nry[j][i]] = 300;
      this.magx[j][i][this.nry[j][i]] = (int)f;
      this.nrx[j][i]++;
      if (this.nrx[j][i] == 7) {
         this.nrx[j][i] = 0;
      }
   }

   public void recy(int i, float f, boolean flag, int j) {
      this.ry[j][i][this.nry[j][i]] = 300;
      this.magy[j][i][this.nry[j][i]] = (int)f;
      this.mtouch[j][this.nry[j][i]] = flag;
      this.nry[j][i]++;
      if (this.nry[j][i] == 7) {
         this.nry[j][i] = 0;
      }
   }

   public void cotchinow(int i) {
      if (this.caught >= 300) {
         this.wasted = i;
         int j = 0;

         do {
            this.starcar[j] = new ContO(this.car[0][j], 0, 0, 0, 0);
            this.hsquash[j] = this.squash[0][j];
            this.hfix[j] = this.fix[j];
            this.hdest[j] = this.dest[j];
         } while (++j < 7);

         j = 0;

         do {
            int k = 0;

            do {
               this.hx[j][k] = this.x[j][k];
               this.hy[j][k] = this.y[j][k];
               this.hz[j][k] = this.z[j][k];
               this.hxy[j][k] = this.xy[j][k];
               this.hzy[j][k] = this.zy[j][k];
               this.hxz[j][k] = this.xz[j][k];
               this.hwxz[j][k] = this.wxz[j][k];
               this.hwzy[j][k] = this.wzy[j][k];
            } while (++k < 7);

            this.hcheckpoint[j] = this.checkpoint[j];
            this.hlastcheck[j] = this.lastcheck[j];
         } while (++j < 300);

         j = 0;

         do {
            int l = 0;

            do {
               this.hns[j][l] = this.ns[j][l];
               int k1 = 0;

               do {
                  this.hsspark[j][l][k1] = this.sspark[j][l][k1];
                  this.hsx[j][l][k1] = this.sx[j][l][k1];
                  this.hsy[j][l][k1] = this.sy[j][l][k1];
                  this.hsz[j][l][k1] = this.sz[j][l][k1];
                  this.hsmag[j][l][k1] = this.smag[j][l][k1];
                  this.hscx[j][l][k1] = this.scx[j][l][k1];
                  this.hscz[j][l][k1] = this.scz[j][l][k1];
                  this.hfulls[j][l][k1] = this.fulls[j][l][k1];
               } while (++k1 < 30);
            } while (++l < 4);
         } while (++j < 7);

         j = 0;

         do {
            int i1 = 0;

            do {
               this.hnry[j][i1] = this.nry[j][i1];
               this.hnrx[j][i1] = this.nrx[j][i1];
               this.hnrz[j][i1] = this.nrz[j][i1];
               int l1 = 0;

               do {
                  this.hry[j][i1][l1] = this.ry[j][i1][l1];
                  this.hmagy[j][i1][l1] = this.magy[j][i1][l1];
                  this.hrx[j][i1][l1] = this.rx[j][i1][l1];
                  this.hmagx[j][i1][l1] = this.magx[j][i1][l1];
                  this.hrz[j][i1][l1] = this.rz[j][i1][l1];
                  this.hmagz[j][i1][l1] = this.magz[j][i1][l1];
               } while (++l1 < 7);
            } while (++i1 < 4);
         } while (++j < 7);

         j = 0;

         do {
            int j1 = 0;

            do {
               this.hmtouch[j][j1] = this.mtouch[j][j1];
            } while (++j1 < 7);
         } while (++j < 7);

         this.hcaught = true;
      }
   }

   public void chipx(int i, float f, ContO conto, Madness madness) {
      if (Math.abs(f) > 100.0F) {
         if (f > 100.0F) {
            f -= 100.0F;
         }

         if (f < -100.0F) {
            f += 100.0F;
         }

         for (int j = 0; j < conto.npl; j++) {
            float f1 = 0.0F;

            for (int k = 0; k < conto.p[j].n; k++) {
               if (conto.p[j].wz == 0 && this.py(conto.keyx[i], conto.p[j].ox[k], conto.keyz[i], conto.p[j].oz[k]) < madness.clrad[madness.cn]) {
                  f1 = f / 20.0F * this.m.random();
               }
            }

            if (f1 != 0.0F && Math.abs(f1) >= 1.0F) {
               conto.p[j].chip = 1;
               conto.p[j].ctmag = f1;
            }
         }
      }
   }

   public void regx(int i, float f, ContO conto, Madness madness) {
      if (Math.abs(f) > 100.0F) {
         if (f > 100.0F) {
            f -= 100.0F;
         }

         if (f < -100.0F) {
            f += 100.0F;
         }

         for (int j = 0; j < conto.npl; j++) {
            float f1 = 0.0F;

            for (int k = 0; k < conto.p[j].n; k++) {
               if (conto.p[j].wz == 0 && this.py(conto.keyx[i], conto.p[j].ox[k], conto.keyz[i], conto.p[j].oz[k]) < madness.clrad[madness.cn]) {
                  f1 = f / 20.0F * this.m.random();
                  conto.p[j].oz[k] = (int)(conto.p[j].oz[k] - f1 * this.m.sin(conto.xz) * this.m.cos(conto.zy));
                  conto.p[j].ox[k] = (int)(conto.p[j].ox[k] + f1 * this.m.cos(conto.xz) * this.m.cos(conto.xy));
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
                  conto.p[j].gr = (int)(conto.p[j].gr + Math.abs(f1 * 1.5));
               }
            }
         }
      }
   }

   public void recz(int i, float f, int j) {
      this.rz[j][i][this.nry[j][i]] = 300;
      this.magz[j][i][this.nry[j][i]] = (int)f;
      this.nrz[j][i]++;
      if (this.nrz[j][i] == 7) {
         this.nrz[j][i] = 0;
      }
   }

   public int py(int i, int j, int k, int l) {
      return (i - j) * (i - j) + (k - l) * (k - l);
   }
}
