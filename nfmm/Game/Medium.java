import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Medium {
   int focus_point = 400;
   int ground = 250;
   int skyline = -300;
   int[] fade = new int[]{3000, 4500, 6000, 7500, 9000, 10500, 12000, 13500, 15000, 16500, 18000, 19500, 21000, 22500, 24000, 25500};
   int[] cldd = new int[]{210, 210, 210, 1, -1000};
   int[] clds = new int[]{210, 210, 210};
   int[] osky = new int[]{170, 220, 255};
   int[] csky = new int[]{170, 220, 255};
   int[] ogrnd = new int[]{205, 200, 200};
   int[] cgrnd = new int[]{205, 200, 200};
   int[] texture = new int[]{0, 0, 0, 50};
   int[] cpol = new int[]{215, 210, 210};
   int[] crgrnd = new int[]{205, 200, 200};
   int[] cfade = new int[]{255, 220, 220};
   int[] snap = new int[]{0, 0, 0};
   int fogd = 7;
   int mgen = (int)(Math.random() * 100000.0);
   boolean loadnew = false;
   boolean lightson = false;
   boolean darksky = false;
   int lightn = -1;
   int lilo = 217;
   boolean lton = false;
   int noelec = 0;
   int trk = 0;
   boolean crs = false;
   int cx = 400;
   int cy = 225;
   int cz = 50;
   int xz = 0;
   int zy = 0;
   int x = 0;
   int y = 0;
   int z = 0;
   int iw = 0;
   int ih = 0;
   int w = 800;
   int h = 450;
   int nsp = 0;
   int[] spx = new int[7];
   int[] spz = new int[7];
   int[] sprad = new int[7];
   boolean td = false;
   int bcxz = 0;
   boolean bt = false;
   int vxz = 180;
   int adv = 500;
   boolean vert = false;
   float[] tcos = new float[360];
   float[] tsin = new float[360];
   int lastmaf = 0;
   int checkpoint = -1;
   boolean lastcheck = false;
   float elecr = 0.0F;
   boolean cpflik = false;
   boolean nochekflk = false;
   int cntrn = 0;
   boolean[] diup = new boolean[]{false, false, false};
   int[] rand = new int[]{0, 0, 0};
   int trn = 0;
   int hit = 45000;
   int ptr = 0;
   int ptcnt = -10;
   int nrnd = 0;
   long trx = 0L;
   long trz = 0L;
   long atrx = 0L;
   long atrz = 0L;
   int fallen = 0;
   float fo = 1.0F;
   float gofo = (float)(0.33F + Math.random() * 1.34);
   int fvect = 200;
   int[][] ogpx = (int[][])null;
   int[][] ogpz = (int[][])null;
   float[][] pvr = (float[][])null;
   int[] cgpx = null;
   int[] cgpz = null;
   int[] pmx = null;
   float[] pcv = null;
   int sgpx = 0;
   int sgpz = 0;
   int nrw = 0;
   int ncl = 0;
   int noc = 0;
   int[] clx = null;
   int[] clz = null;
   int[] cmx = null;
   int[][][] clax = (int[][][])null;
   int[][][] clay = (int[][][])null;
   int[][][] claz = (int[][][])null;
   int[][][][] clc = (int[][][][])null;
   int nmt = 0;
   int[] mrd = null;
   int[] nmv = null;
   int[][] mtx = (int[][])null;
   int[][] mty = (int[][])null;
   int[][] mtz = (int[][])null;
   int[][][] mtc = (int[][][])null;
   int nst = 0;
   int[] stx = null;
   int[] stz = null;
   int[][][] stc = (int[][][])null;
   boolean[] bst = null;
   int[] twn = null;
   int resdown = 0;
   int rescnt = 5;

   public Medium() {
      for (int var1 = 0; var1 < 360; var1++) {
         this.tcos[var1] = (float)Math.cos(var1 * (Math.PI / 180.0));
      }

      for (int var2 = 0; var2 < 360; var2++) {
         this.tsin[var2] = (float)Math.sin(var2 * (Math.PI / 180.0));
      }
   }

   public float random() {
      if (this.cntrn == 0) {
         for (int var1 = 0; var1 < 3; var1++) {
            this.rand[var1] = (int)(10.0 * Math.random());
            if (Math.random() > Math.random()) {
               this.diup[var1] = false;
            } else {
               this.diup[var1] = true;
            }
         }

         this.cntrn = 20;
      } else {
         this.cntrn--;
      }

      for (int var2 = 0; var2 < 3; var2++) {
         if (this.diup[var2]) {
            this.rand[var2]++;
            if (this.rand[var2] == 10) {
               this.rand[var2] = 0;
            }
         } else {
            this.rand[var2]--;
            if (this.rand[var2] == -1) {
               this.rand[var2] = 9;
            }
         }
      }

      this.trn++;
      if (this.trn == 3) {
         this.trn = 0;
      }

      return this.rand[this.trn] / 10.0F;
   }

   public void watch(ContO var1, int var2) {
      if (this.td) {
         this.y = (int)(var1.y - 300 - 1100.0F * this.random());
         this.x = var1.x + (int)((var1.x + 400 - var1.x) * this.cos(var2) - (var1.z + 5000 - var1.z) * this.sin(var2));
         this.z = var1.z + (int)((var1.x + 400 - var1.x) * this.sin(var2) + (var1.z + 5000 - var1.z) * this.cos(var2));
         this.td = false;
      }

      short var3 = 0;
      if (var1.x - this.x - this.cx > 0) {
         var3 = 180;
      }

      int var4 = -((int)(90 + var3 + Math.atan((double)(var1.z - this.z) / (var1.x - this.x - this.cx)) / (Math.PI / 180.0)));
      var3 = 0;
      if (var1.y - this.y - this.cy < 0) {
         var3 = -180;
      }

      int var5 = (int)Math.sqrt((var1.z - this.z) * (var1.z - this.z) + (var1.x - this.x - this.cx) * (var1.x - this.x - this.cx));
      int var6 = (int)(90 + var3 - Math.atan((double)var5 / (var1.y - this.y - this.cy)) / (Math.PI / 180.0));

      while (var4 < 0) {
         var4 += 360;
      }

      while (var4 > 360) {
         var4 -= 360;
      }

      this.xz = var4;
      this.zy = this.zy + (var6 - this.zy) / 5;
      if ((int)Math.sqrt(
            (var1.z - this.z) * (var1.z - this.z)
               + (var1.x - this.x - this.cx) * (var1.x - this.x - this.cx)
               + (var1.y - this.y - this.cy) * (var1.y - this.y - this.cy)
         )
         > 6000) {
         this.td = true;
      }
   }

   public void aroundtrack(CheckPoints var1) {
      this.y = -this.hit;
      this.x = this.cx + (int)this.trx + (int)(17000.0F * this.cos(this.vxz));
      this.z = (int)this.trz + (int)(17000.0F * this.sin(this.vxz));
      if (this.hit > 5000) {
         if (this.hit == 45000) {
            this.fo = 1.0F;
            this.zy = 67;
            this.atrx = (var1.x[0] - this.trx) / 116L;
            this.atrz = (var1.z[0] - this.trz) / 116L;
            this.focus_point = 400;
         }

         if (this.hit == 20000) {
            this.fallen = 500;
            this.fo = 1.0F;
            this.zy = 67;
            this.atrx = (var1.x[0] - this.trx) / 116L;
            this.atrz = (var1.z[0] - this.trz) / 116L;
            this.focus_point = 400;
         }

         this.hit = this.hit - this.fallen;
         this.fallen += 7;
         this.trx = this.trx + this.atrx;
         this.trz = this.trz + this.atrz;
         if (this.hit < 17600) {
            this.zy -= 2;
         }

         if (this.fallen > 500) {
            this.fallen = 500;
         }

         if (this.hit <= 5000) {
            this.hit = 5000;
            this.fallen = 0;
         }

         this.vxz += 3;
      } else {
         this.focus_point = (int)(400.0F * this.fo);
         if (Math.abs(this.fo - this.gofo) > 0.005) {
            if (this.fo < this.gofo) {
               this.fo += 0.005F;
            } else {
               this.fo -= 0.005F;
            }
         } else {
            this.gofo = (float)(0.35F + Math.random() * 1.3);
         }

         this.vxz++;
         this.trx = this.trx - (this.trx - var1.x[this.ptr]) / 10L;
         this.trz = this.trz - (this.trz - var1.z[this.ptr]) / 10L;
         if (this.ptcnt == 7) {
            this.ptr++;
            if (this.ptr == var1.n) {
               this.ptr = 0;
               this.nrnd++;
            }

            this.ptcnt = 0;
         } else {
            this.ptcnt++;
         }
      }

      if (this.vxz > 360) {
         this.vxz -= 360;
      }

      this.xz = -this.vxz - 90;
      short var2 = 0;
      if (-this.y - this.cy < 0) {
         var2 = -180;
      }

      int var3 = (int)Math.sqrt((this.trz - this.z + this.cz) * (this.trz - this.z + this.cz) + (this.trx - this.x - this.cx) * (this.trx - this.x - this.cx));
      if (this.cpflik) {
         this.cpflik = false;
      } else {
         this.cpflik = true;
      }
   }

   public void around(ContO var1, boolean var2) {
      if (!var2) {
         if (!this.vert) {
            this.adv += 2;
         } else {
            this.adv -= 2;
         }

         if (this.adv > 900) {
            this.vert = true;
         }

         if (this.adv < -500) {
            this.vert = false;
         }
      } else {
         this.adv -= 14;
         if (this.adv < 617) {
            this.adv = 617;
         }
      }

      int var3 = 500 + this.adv;
      if (var2 && var3 < 1300) {
         var3 = 1300;
      }

      if (var3 < 1000) {
         var3 = 1000;
      }

      this.y = var1.y - this.adv;
      if (this.y > 10) {
         this.vert = false;
      }

      this.x = var1.x + (int)((var1.x - var3 - var1.x) * this.cos(this.vxz));
      this.z = var1.z + (int)((var1.x - var3 - var1.x) * this.sin(this.vxz));
      if (!var2) {
         this.vxz += 2;
      } else {
         this.vxz += 4;
      }

      short var4 = 0;
      int var5 = this.y;
      if (var5 > 0) {
         var5 = 0;
      }

      if (var1.y - var5 - this.cy < 0) {
         var4 = -180;
      }

      int var6 = (int)Math.sqrt((var1.z - this.z + this.cz) * (var1.z - this.z + this.cz) + (var1.x - this.x - this.cx) * (var1.x - this.x - this.cx));
      int var7 = (int)(90 + var4 - Math.atan((double)var6 / (var1.y - var5 - this.cy)) / (Math.PI / 180.0));
      this.xz = -this.vxz + 90;
      if (var2) {
         var7 -= 15;
      }

      this.zy = this.zy + (var7 - this.zy) / 10;
   }

   public void getaround(ContO var1) {
      if (!this.vert) {
         this.adv += 2;
      } else {
         this.adv -= 2;
      }

      if (this.adv > 1700) {
         this.vert = true;
      }

      if (this.adv < -500) {
         this.vert = false;
      }

      if (var1.y - this.adv > 10) {
         this.vert = false;
      }

      int var2 = 500 + this.adv;
      if (var2 < 1000) {
         var2 = 1000;
      }

      int var3 = var1.y - this.adv;
      int var4 = var1.x + (int)((var1.x - var2 - var1.x) * this.cos(this.vxz));
      int var5 = var1.z + (int)((var1.x - var2 - var1.x) * this.sin(this.vxz));
      int var6 = 0;
      if (Math.abs(var3 - this.y) > this.fvect) {
         if (this.y < var3) {
            this.y = this.y + this.fvect;
         } else {
            this.y = this.y - this.fvect;
         }
      } else {
         this.y = var3;
         var6++;
      }

      if (Math.abs(var4 - this.x) > this.fvect) {
         if (this.x < var4) {
            this.x = this.x + this.fvect;
         } else {
            this.x = this.x - this.fvect;
         }
      } else {
         this.x = var4;
         var6++;
      }

      if (Math.abs(var5 - this.z) > this.fvect) {
         if (this.z < var5) {
            this.z = this.z + this.fvect;
         } else {
            this.z = this.z - this.fvect;
         }
      } else {
         this.z = var5;
         var6++;
      }

      if (var6 == 3) {
         this.fvect = 200;
      } else {
         this.fvect += 2;
      }

      this.vxz += 2;

      while (this.vxz > 360) {
         this.vxz -= 360;
      }

      int var7 = -this.vxz + 90;
      short var8 = 0;
      if (var1.x - this.x - this.cx > 0) {
         var8 = 180;
      }

      int var9 = -((int)(90 + var8 + Math.atan((double)(var1.z - this.z) / (var1.x - this.x - this.cx)) / (Math.PI / 180.0)));
      int var10 = this.y;
      var8 = 0;
      if (var10 > 0) {
         var10 = 0;
      }

      if (var1.y - var10 - this.cy < 0) {
         var8 = -180;
      }

      int var11 = (int)Math.sqrt((var1.z - this.z + this.cz) * (var1.z - this.z + this.cz) + (var1.x - this.x - this.cx) * (var1.x - this.x - this.cx));
      int var12 = 25;
      if (var11 != 0) {
         var12 = (int)(90 + var8 - Math.atan((double)var11 / (var1.y - var10 - this.cy)) / (Math.PI / 180.0));
      }

      while (var7 < 0) {
         var7 += 360;
      }

      while (var7 > 360) {
         var7 -= 360;
      }

      while (var9 < 0) {
         var9 += 360;
      }

      while (var9 > 360) {
         var9 -= 360;
      }

      if ((Math.abs(var7 - var9) < 30 || Math.abs(var7 - var9) > 330) && var6 == 3) {
         if (Math.abs(var7 - this.xz) <= 7 || Math.abs(var7 - this.xz) >= 353) {
            this.xz = var7;
         } else if (Math.abs(var7 - this.xz) > 180) {
            if (this.xz > var7) {
               this.xz += 7;
            } else {
               this.xz -= 7;
            }
         } else if (this.xz < var7) {
            this.xz += 7;
         } else {
            this.xz -= 7;
         }
      } else if (Math.abs(var9 - this.xz) <= 6 || Math.abs(var9 - this.xz) >= 354) {
         this.xz = var9;
      } else if (Math.abs(var9 - this.xz) > 180) {
         if (this.xz > var9) {
            this.xz += 3;
         } else {
            this.xz -= 3;
         }
      } else if (this.xz < var9) {
         this.xz += 3;
      } else {
         this.xz -= 3;
      }

      this.zy = this.zy + (var12 - this.zy) / 10;
   }

   public void transaround(ContO var1, ContO var2, int var3) {
      int var4 = (var1.x * (20 - var3) + var2.x * var3) / 20;
      int var5 = (var1.y * (20 - var3) + var2.y * var3) / 20;
      int var6 = (var1.z * (20 - var3) + var2.z * var3) / 20;
      if (!this.vert) {
         this.adv += 2;
      } else {
         this.adv -= 2;
      }

      if (this.adv > 900) {
         this.vert = true;
      }

      if (this.adv < -500) {
         this.vert = false;
      }

      int var7 = 500 + this.adv;
      if (var7 < 1000) {
         var7 = 1000;
      }

      this.y = var5 - this.adv;
      if (this.y > 10) {
         this.vert = false;
      }

      this.x = var4 + (int)((var4 - var7 - var4) * this.cos(this.vxz));
      this.z = var6 + (int)((var4 - var7 - var4) * this.sin(this.vxz));
      this.vxz += 2;
      short var8 = 0;
      int var9 = this.y;
      if (var9 > 0) {
         var9 = 0;
      }

      if (var5 - var9 - this.cy < 0) {
         var8 = -180;
      }

      int var10 = (int)Math.sqrt((var6 - this.z + this.cz) * (var6 - this.z + this.cz) + (var4 - this.x - this.cx) * (var4 - this.x - this.cx));
      int var11 = (int)(90 + var8 - Math.atan((double)var10 / (var5 - var9 - this.cy)) / (Math.PI / 180.0));
      this.xz = -this.vxz + 90;
      this.zy = this.zy + (var11 - this.zy) / 10;
   }

   public void follow(ContO var1, int var2, int var3) {
      this.zy = 10;
      int var4 = 2 + Math.abs(this.bcxz) / 4;
      if (var4 > 20) {
         var4 = 20;
      }

      if (var3 != 0) {
         if (var3 == 1) {
            if (this.bcxz < 180) {
               this.bcxz += var4;
            }

            if (this.bcxz > 180) {
               this.bcxz = 180;
            }
         }

         if (var3 == -1) {
            if (this.bcxz > -180) {
               this.bcxz -= var4;
            }

            if (this.bcxz < -180) {
               this.bcxz = -180;
            }
         }
      } else if (Math.abs(this.bcxz) > var4) {
         if (this.bcxz > 0) {
            this.bcxz -= var4;
         } else {
            this.bcxz += var4;
         }
      } else if (this.bcxz != 0) {
         this.bcxz = 0;
      }

      var2 += this.bcxz;
      this.xz = -var2;
      this.x = var1.x - this.cx + (int)(-(var1.z - 800 - var1.z) * this.sin(var2));
      this.z = var1.z - this.cz + (int)((var1.z - 800 - var1.z) * this.cos(var2));
      this.y = var1.y - 250 - this.cy;
   }

   public void getfollow(ContO var1, int var2, int var3) {
      this.zy = 10;
      int var4 = 2 + Math.abs(this.bcxz) / 4;
      if (var4 > 20) {
         var4 = 20;
      }

      if (var3 != 0) {
         if (var3 == 1) {
            if (this.bcxz < 180) {
               this.bcxz += var4;
            }

            if (this.bcxz > 180) {
               this.bcxz = 180;
            }
         }

         if (var3 == -1) {
            if (this.bcxz > -180) {
               this.bcxz -= var4;
            }

            if (this.bcxz < -180) {
               this.bcxz = -180;
            }
         }
      } else if (Math.abs(this.bcxz) > var4) {
         if (this.bcxz > 0) {
            this.bcxz -= var4;
         } else {
            this.bcxz += var4;
         }
      } else if (this.bcxz != 0) {
         this.bcxz = 0;
      }

      var2 += this.bcxz;
      this.xz = -var2;
      int var5 = var1.x - this.cx + (int)(-(var1.z - 800 - var1.z) * this.sin(var2));
      int var6 = var1.z - this.cz + (int)((var1.z - 800 - var1.z) * this.cos(var2));
      int var7 = var1.y - 250 - this.cy;
      int var8 = 0;
      if (Math.abs(var7 - this.y) > this.fvect) {
         if (this.y < var7) {
            this.y = this.y + this.fvect;
         } else {
            this.y = this.y - this.fvect;
         }
      } else {
         this.y = var7;
         var8++;
      }

      if (Math.abs(var5 - this.x) > this.fvect) {
         if (this.x < var5) {
            this.x = this.x + this.fvect;
         } else {
            this.x = this.x - this.fvect;
         }
      } else {
         this.x = var5;
         var8++;
      }

      if (Math.abs(var6 - this.z) > this.fvect) {
         if (this.z < var6) {
            this.z = this.z + this.fvect;
         } else {
            this.z = this.z - this.fvect;
         }
      } else {
         this.z = var6;
         var8++;
      }

      if (var8 == 3) {
         this.fvect = 200;
      } else {
         this.fvect += 2;
      }
   }

   public void newpolys(int var1, int var2, int var3, int var4, Trackers var5, int var6) {
      Random var7 = new Random((var6 + this.cgrnd[0] + this.cgrnd[1] + this.cgrnd[2]) * 1671);
      this.nrw = var2 / 1200 + 9;
      this.ncl = var4 / 1200 + 9;
      this.sgpx = var1 - 4800;
      this.sgpz = var3 - 4800;
      this.ogpx = (int[][])null;
      this.ogpz = (int[][])null;
      this.pvr = (float[][])null;
      this.cgpx = null;
      this.cgpz = null;
      this.pmx = null;
      this.pcv = null;
      this.ogpx = new int[this.nrw * this.ncl][8];
      this.ogpz = new int[this.nrw * this.ncl][8];
      this.pvr = new float[this.nrw * this.ncl][8];
      this.cgpx = new int[this.nrw * this.ncl];
      this.cgpz = new int[this.nrw * this.ncl];
      this.pmx = new int[this.nrw * this.ncl];
      this.pcv = new float[this.nrw * this.ncl];
      int var8 = 0;
      int var9 = 0;

      for (int var10 = 0; var10 < this.nrw * this.ncl; var10++) {
         this.cgpx[var10] = this.sgpx + var8 * 1200 + (int)(var7.nextDouble() * 1000.0 - 500.0);
         this.cgpz[var10] = this.sgpz + var9 * 1200 + (int)(var7.nextDouble() * 1000.0 - 500.0);
         if (var5 != null) {
            for (int var11 = 0; var11 < var5.nt; var11++) {
               if (var5.zy[var11] == 0 && var5.xy[var11] == 0) {
                  if (var5.radx[var11] < var5.radz[var11] && Math.abs(this.cgpz[var10] - var5.z[var11]) < var5.radz[var11]) {
                     while (Math.abs(this.cgpx[var10] - var5.x[var11]) < var5.radx[var11]) {
                        this.cgpx[var10] = (int)(this.cgpx[var10] + (var7.nextDouble() * var5.radx[var11] * 2.0 - var5.radx[var11]));
                     }
                  }

                  if (var5.radz[var11] < var5.radx[var11] && Math.abs(this.cgpx[var10] - var5.x[var11]) < var5.radx[var11]) {
                     while (Math.abs(this.cgpz[var10] - var5.z[var11]) < var5.radz[var11]) {
                        this.cgpz[var10] = (int)(this.cgpz[var10] + (var7.nextDouble() * var5.radz[var11] * 2.0 - var5.radz[var11]));
                     }
                  }
               }
            }
         }

         if (++var8 == this.nrw) {
            var8 = 0;
            var9++;
         }
      }

      for (int var16 = 0; var16 < this.nrw * this.ncl; var16++) {
         float var17 = (float)(0.3 + 1.6 * var7.nextDouble());
         this.ogpx[var16][0] = 0;
         this.ogpz[var16][0] = (int)((100.0 + var7.nextDouble() * 760.0) * var17);
         this.ogpx[var16][1] = (int)((100.0 + var7.nextDouble() * 760.0) * 0.7071 * var17);
         this.ogpz[var16][1] = this.ogpx[var16][1];
         this.ogpx[var16][2] = (int)((100.0 + var7.nextDouble() * 760.0) * var17);
         this.ogpz[var16][2] = 0;
         this.ogpx[var16][3] = (int)((100.0 + var7.nextDouble() * 760.0) * 0.7071 * var17);
         this.ogpz[var16][3] = -this.ogpx[var16][3];
         this.ogpx[var16][4] = 0;
         this.ogpz[var16][4] = -((int)((100.0 + var7.nextDouble() * 760.0) * var17));
         this.ogpx[var16][5] = -((int)((100.0 + var7.nextDouble() * 760.0) * 0.7071 * var17));
         this.ogpz[var16][5] = this.ogpx[var16][5];
         this.ogpx[var16][6] = -((int)((100.0 + var7.nextDouble() * 760.0) * var17));
         this.ogpz[var16][6] = 0;
         this.ogpx[var16][7] = -((int)((100.0 + var7.nextDouble() * 760.0) * 0.7071 * var17));
         this.ogpz[var16][7] = -this.ogpx[var16][7];

         for (int var12 = 0; var12 < 8; var12++) {
            int var13 = var12 - 1;
            if (var13 == -1) {
               var13 = 7;
            }

            int var14 = var12 + 1;
            if (var14 == 8) {
               var14 = 0;
            }

            this.ogpx[var16][var12] = ((this.ogpx[var16][var13] + this.ogpx[var16][var14]) / 2 + this.ogpx[var16][var12]) / 2;
            this.ogpz[var16][var12] = ((this.ogpz[var16][var13] + this.ogpz[var16][var14]) / 2 + this.ogpz[var16][var12]) / 2;
            this.pvr[var16][var12] = (float)(1.1 + var7.nextDouble() * 0.8);
            int var15 = (int)Math.sqrt(
               (int)(
                  this.ogpx[var16][var12] * this.ogpx[var16][var12] * this.pvr[var16][var12] * this.pvr[var16][var12]
                     + this.ogpz[var16][var12] * this.ogpz[var16][var12] * this.pvr[var16][var12] * this.pvr[var16][var12]
               )
            );
            if (var15 > this.pmx[var16]) {
               this.pmx[var16] = var15;
            }
         }

         this.pcv[var16] = (float)(0.97 + var7.nextDouble() * 0.03);
         if (this.pcv[var16] > 1.0F) {
            this.pcv[var16] = 1.0F;
         }

         if (var7.nextDouble() > var7.nextDouble()) {
            this.pcv[var16] = 1.0F;
         }
      }
   }

   public void groundpolys(Graphics2D var1) {
      int var2 = (this.x - this.sgpx) / 1200 - 12;
      if (var2 < 0) {
         var2 = 0;
      }

      int var3 = var2 + 25;
      if (var3 > this.nrw) {
         var3 = this.nrw;
      }

      if (var3 < var2) {
         var3 = var2;
      }

      int var4 = (this.z - this.sgpz) / 1200 - 12;
      if (var4 < 0) {
         var4 = 0;
      }

      int var5 = var4 + 25;
      if (var5 > this.ncl) {
         var5 = this.ncl;
      }

      if (var5 < var4) {
         var5 = var4;
      }

      int[][] var6 = new int[var3 - var2][var5 - var4];

      for (int var7 = var2; var7 < var3; var7++) {
         for (int var8 = var4; var8 < var5; var8++) {
            var6[var7 - var2][var8 - var4] = 0;
            int var9 = var7 + var8 * this.nrw;
            if (this.resdown < 2 || var9 % 2 == 0) {
               int var10 = this.cx + (int)((this.cgpx[var9] - this.x - this.cx) * this.cos(this.xz) - (this.cgpz[var9] - this.z - this.cz) * this.sin(this.xz));
               int var11 = this.cz + (int)((this.cgpx[var9] - this.x - this.cx) * this.sin(this.xz) + (this.cgpz[var9] - this.z - this.cz) * this.cos(this.xz));
               int var12 = this.cz + (int)((250 - this.y - this.cy) * this.sin(this.zy) + (var11 - this.cz) * this.cos(this.zy));
               if (this.xs(var10 + this.pmx[var9], var12) > 0
                  && this.xs(var10 - this.pmx[var9], var12) < this.w
                  && var12 > -this.pmx[var9]
                  && var12 < this.fade[2]) {
                  var6[var7 - var2][var8 - var4] = var12;
                  int[] var13 = new int[8];
                  int[] var14 = new int[8];
                  int[] var15 = new int[8];

                  for (int var16 = 0; var16 < 8; var16++) {
                     var13[var16] = (int)(this.ogpx[var9][var16] * this.pvr[var9][var16] + this.cgpx[var9] - this.x);
                     var14[var16] = (int)(this.ogpz[var9][var16] * this.pvr[var9][var16] + this.cgpz[var9] - this.z);
                     var15[var16] = this.ground;
                  }

                  this.rot(var13, var14, this.cx, this.cz, this.xz, 8);
                  this.rot(var15, var14, this.cy, this.cz, this.zy, 8);
                  int[] var36 = new int[8];
                  int[] var17 = new int[8];
                  int var18 = 0;
                  int var19 = 0;
                  int var20 = 0;
                  int var21 = 0;
                  boolean var22 = true;

                  for (int var23 = 0; var23 < 8; var23++) {
                     var36[var23] = this.xs(var13[var23], var14[var23]);
                     var17[var23] = this.ys(var15[var23], var14[var23]);
                     if (var17[var23] < 0 || var14[var23] < 10) {
                        var18++;
                     }

                     if (var17[var23] > this.h || var14[var23] < 10) {
                        var19++;
                     }

                     if (var36[var23] < 0 || var14[var23] < 10) {
                        var20++;
                     }

                     if (var36[var23] > this.w || var14[var23] < 10) {
                        var21++;
                     }
                  }

                  if (var20 == 8 || var18 == 8 || var19 == 8 || var21 == 8) {
                     var22 = false;
                  }

                  if (var22) {
                     int var45 = (int)((this.cpol[0] * this.pcv[var9] + this.cgrnd[0]) / 2.0F);
                     int var24 = (int)((this.cpol[1] * this.pcv[var9] + this.cgrnd[1]) / 2.0F);
                     int var25 = (int)((this.cpol[2] * this.pcv[var9] + this.cgrnd[2]) / 2.0F);
                     if (var12 - this.pmx[var9] > this.fade[0]) {
                        var45 = (var45 * 7 + this.cfade[0]) / 8;
                        var24 = (var24 * 7 + this.cfade[1]) / 8;
                        var25 = (var25 * 7 + this.cfade[2]) / 8;
                     }

                     if (var12 - this.pmx[var9] > this.fade[1]) {
                        var45 = (var45 * 7 + this.cfade[0]) / 8;
                        var24 = (var24 * 7 + this.cfade[1]) / 8;
                        var25 = (var25 * 7 + this.cfade[2]) / 8;
                     }

                     var1.setColor(new Color(var45, var24, var25));
                     var1.fillPolygon(var36, var17, 8);
                  }
               }
            }
         }
      }

      for (int var26 = var2; var26 < var3; var26++) {
         for (int var27 = var4; var27 < var5; var27++) {
            if (var6[var26 - var2][var27 - var4] != 0) {
               int var28 = var26 + var27 * this.nrw;
               int[] var29 = new int[8];
               int[] var30 = new int[8];
               int[] var31 = new int[8];

               for (int var32 = 0; var32 < 8; var32++) {
                  var29[var32] = this.ogpx[var28][var32] + this.cgpx[var28] - this.x;
                  var30[var32] = this.ogpz[var28][var32] + this.cgpz[var28] - this.z;
                  var31[var32] = this.ground;
               }

               this.rot(var29, var30, this.cx, this.cz, this.xz, 8);
               this.rot(var31, var30, this.cy, this.cz, this.zy, 8);
               int[] var33 = new int[8];
               int[] var34 = new int[8];
               int var35 = 0;
               int var37 = 0;
               int var38 = 0;
               int var39 = 0;
               boolean var40 = true;

               for (int var41 = 0; var41 < 8; var41++) {
                  var33[var41] = this.xs(var29[var41], var30[var41]);
                  var34[var41] = this.ys(var31[var41], var30[var41]);
                  if (var34[var41] < 0 || var30[var41] < 10) {
                     var35++;
                  }

                  if (var34[var41] > this.h || var30[var41] < 10) {
                     var37++;
                  }

                  if (var33[var41] < 0 || var30[var41] < 10) {
                     var38++;
                  }

                  if (var33[var41] > this.w || var30[var41] < 10) {
                     var39++;
                  }
               }

               if (var38 == 8 || var35 == 8 || var37 == 8 || var39 == 8) {
                  var40 = false;
               }

               if (var40) {
                  int var42 = (int)(this.cpol[0] * this.pcv[var28]);
                  int var43 = (int)(this.cpol[1] * this.pcv[var28]);
                  int var44 = (int)(this.cpol[2] * this.pcv[var28]);
                  if (var6[var26 - var2][var27 - var4] - this.pmx[var28] > this.fade[0]) {
                     var42 = (var42 * 7 + this.cfade[0]) / 8;
                     var43 = (var43 * 7 + this.cfade[1]) / 8;
                     var44 = (var44 * 7 + this.cfade[2]) / 8;
                  }

                  if (var6[var26 - var2][var27 - var4] - this.pmx[var28] > this.fade[1]) {
                     var42 = (var42 * 7 + this.cfade[0]) / 8;
                     var43 = (var43 * 7 + this.cfade[1]) / 8;
                     var44 = (var44 * 7 + this.cfade[2]) / 8;
                  }

                  var1.setColor(new Color(var42, var43, var44));
                  var1.fillPolygon(var33, var34, 8);
               }
            }
         }
      }
   }

   public void newclouds(int var1, int var2, int var3, int var4) {
      this.clx = null;
      this.clz = null;
      this.cmx = null;
      this.clax = (int[][][])null;
      this.clay = (int[][][])null;
      this.claz = (int[][][])null;
      this.clc = (int[][][][])null;
      var1 = var1 / 20 - 10000;
      var2 = var2 / 20 + 10000;
      var3 = var3 / 20 - 10000;
      var4 = var4 / 20 + 10000;
      this.noc = (var2 - var1) * (var4 - var3) / 16666667;
      this.clx = new int[this.noc];
      this.clz = new int[this.noc];
      this.cmx = new int[this.noc];
      this.clax = new int[this.noc][3][12];
      this.clay = new int[this.noc][3][12];
      this.claz = new int[this.noc][3][12];
      this.clc = new int[this.noc][2][6][3];

      for (int var5 = 0; var5 < this.noc; var5++) {
         this.clx[var5] = (int)(var1 + (var2 - var1) * Math.random());
         this.clz[var5] = (int)(var3 + (var4 - var3) * Math.random());
         float var6 = (float)(0.25 + Math.random() * 1.25);
         float var7 = (float)((200.0 + Math.random() * 700.0) * var6);
         this.clax[var5][0][0] = (int)(var7 * 0.3826);
         this.claz[var5][0][0] = (int)(var7 * 0.9238);
         this.clay[var5][0][0] = (int)((25.0 - Math.random() * 50.0) * var6);
         var7 = (float)((200.0 + Math.random() * 700.0) * var6);
         this.clax[var5][0][1] = (int)(var7 * 0.7071);
         this.claz[var5][0][1] = (int)(var7 * 0.7071);
         this.clay[var5][0][1] = (int)((25.0 - Math.random() * 50.0) * var6);
         var7 = (float)((200.0 + Math.random() * 700.0) * var6);
         this.clax[var5][0][2] = (int)(var7 * 0.9238);
         this.claz[var5][0][2] = (int)(var7 * 0.3826);
         this.clay[var5][0][2] = (int)((25.0 - Math.random() * 50.0) * var6);
         var7 = (float)((200.0 + Math.random() * 700.0) * var6);
         this.clax[var5][0][3] = (int)(var7 * 0.9238);
         this.claz[var5][0][3] = -((int)(var7 * 0.3826));
         this.clay[var5][0][3] = (int)((25.0 - Math.random() * 50.0) * var6);
         var7 = (float)((200.0 + Math.random() * 700.0) * var6);
         this.clax[var5][0][4] = (int)(var7 * 0.7071);
         this.claz[var5][0][4] = -((int)(var7 * 0.7071));
         this.clay[var5][0][4] = (int)((25.0 - Math.random() * 50.0) * var6);
         var7 = (float)((200.0 + Math.random() * 700.0) * var6);
         this.clax[var5][0][5] = (int)(var7 * 0.3826);
         this.claz[var5][0][5] = -((int)(var7 * 0.9238));
         this.clay[var5][0][5] = (int)((25.0 - Math.random() * 50.0) * var6);
         var7 = (float)((200.0 + Math.random() * 700.0) * var6);
         this.clax[var5][0][6] = -((int)(var7 * 0.3826));
         this.claz[var5][0][6] = -((int)(var7 * 0.9238));
         this.clay[var5][0][6] = (int)((25.0 - Math.random() * 50.0) * var6);
         var7 = (float)((200.0 + Math.random() * 700.0) * var6);
         this.clax[var5][0][7] = -((int)(var7 * 0.7071));
         this.claz[var5][0][7] = -((int)(var7 * 0.7071));
         this.clay[var5][0][7] = (int)((25.0 - Math.random() * 50.0) * var6);
         var7 = (float)((200.0 + Math.random() * 700.0) * var6);
         this.clax[var5][0][8] = -((int)(var7 * 0.9238));
         this.claz[var5][0][8] = -((int)(var7 * 0.3826));
         this.clay[var5][0][8] = (int)((25.0 - Math.random() * 50.0) * var6);
         var7 = (float)((200.0 + Math.random() * 700.0) * var6);
         this.clax[var5][0][9] = -((int)(var7 * 0.9238));
         this.claz[var5][0][9] = (int)(var7 * 0.3826);
         this.clay[var5][0][9] = (int)((25.0 - Math.random() * 50.0) * var6);
         var7 = (float)((200.0 + Math.random() * 700.0) * var6);
         this.clax[var5][0][10] = -((int)(var7 * 0.7071));
         this.claz[var5][0][10] = (int)(var7 * 0.7071);
         this.clay[var5][0][10] = (int)((25.0 - Math.random() * 50.0) * var6);
         var7 = (float)((200.0 + Math.random() * 700.0) * var6);
         this.clax[var5][0][11] = -((int)(var7 * 0.3826));
         this.claz[var5][0][11] = (int)(var7 * 0.9238);
         this.clay[var5][0][11] = (int)((25.0 - Math.random() * 50.0) * var6);

         for (int var8 = 0; var8 < 12; var8++) {
            int var9 = var8 - 1;
            if (var9 == -1) {
               var9 = 11;
            }

            int var10 = var8 + 1;
            if (var10 == 12) {
               var10 = 0;
            }

            this.clax[var5][0][var8] = ((this.clax[var5][0][var9] + this.clax[var5][0][var10]) / 2 + this.clax[var5][0][var8]) / 2;
            this.clay[var5][0][var8] = ((this.clay[var5][0][var9] + this.clay[var5][0][var10]) / 2 + this.clay[var5][0][var8]) / 2;
            this.claz[var5][0][var8] = ((this.claz[var5][0][var9] + this.claz[var5][0][var10]) / 2 + this.claz[var5][0][var8]) / 2;
         }

         for (int var32 = 0; var32 < 12; var32++) {
            var7 = (float)(1.2 + 0.6 * Math.random());
            this.clax[var5][1][var32] = (int)(this.clax[var5][0][var32] * var7);
            this.claz[var5][1][var32] = (int)(this.claz[var5][0][var32] * var7);
            this.clay[var5][1][var32] = (int)(this.clay[var5][0][var32] - 100.0 * Math.random());
            var7 = (float)(1.1 + 0.3 * Math.random());
            this.clax[var5][2][var32] = (int)(this.clax[var5][1][var32] * var7);
            this.claz[var5][2][var32] = (int)(this.claz[var5][1][var32] * var7);
            this.clay[var5][2][var32] = (int)(this.clay[var5][1][var32] - 240.0 * Math.random());
         }

         this.cmx[var5] = 0;

         for (int var33 = 0; var33 < 12; var33++) {
            int var35 = var33 - 1;
            if (var35 == -1) {
               var35 = 11;
            }

            int var37 = var33 + 1;
            if (var37 == 12) {
               var37 = 0;
            }

            this.clay[var5][1][var33] = ((this.clay[var5][1][var35] + this.clay[var5][1][var37]) / 2 + this.clay[var5][1][var33]) / 2;
            this.clay[var5][2][var33] = ((this.clay[var5][2][var35] + this.clay[var5][2][var37]) / 2 + this.clay[var5][2][var33]) / 2;
            int var11 = (int)Math.sqrt(this.clax[var5][2][var33] * this.clax[var5][2][var33] + this.claz[var5][2][var33] * this.claz[var5][2][var33]);
            if (var11 > this.cmx[var5]) {
               this.cmx[var5] = var11;
            }
         }

         for (int var34 = 0; var34 < 6; var34++) {
            double var36 = Math.random();
            double var38 = Math.random();

            for (int var13 = 0; var13 < 3; var13++) {
               var7 = this.clds[var13] * 1.05F - this.clds[var13];
               this.clc[var5][0][var34][var13] = (int)(this.clds[var13] + var7 * var36);
               if (this.clc[var5][0][var34][var13] > 255) {
                  this.clc[var5][0][var34][var13] = 255;
               }

               if (this.clc[var5][0][var34][var13] < 0) {
                  this.clc[var5][0][var34][var13] = 0;
               }

               this.clc[var5][1][var34][var13] = (int)(this.clds[var13] * 1.05F + var7 * var38);
               if (this.clc[var5][1][var34][var13] > 255) {
                  this.clc[var5][1][var34][var13] = 255;
               }

               if (this.clc[var5][1][var34][var13] < 0) {
                  this.clc[var5][1][var34][var13] = 0;
               }
            }
         }
      }
   }

   public void drawclouds(Graphics2D var1) {
      for (int var2 = 0; var2 < this.noc; var2++) {
         int var3 = this.cx
            + (int)((this.clx[var2] - this.x / 20 - this.cx) * this.cos(this.xz) - (this.clz[var2] - this.z / 20 - this.cz) * this.sin(this.xz));
         int var4 = this.cz
            + (int)((this.clx[var2] - this.x / 20 - this.cx) * this.sin(this.xz) + (this.clz[var2] - this.z / 20 - this.cz) * this.cos(this.xz));
         int var5 = this.cz + (int)((this.cldd[4] - this.y / 20 - this.cy) * this.sin(this.zy) + (var4 - this.cz) * this.cos(this.zy));
         int var6 = this.xs(var3 + this.cmx[var2], var5);
         int var7 = this.xs(var3 - this.cmx[var2], var5);
         if (var6 > 0 && var7 < this.w && var5 > -this.cmx[var2] && var6 - var7 > 20) {
            int[][] var8 = new int[3][12];
            int[][] var9 = new int[3][12];
            int[][] var10 = new int[3][12];
            int[] var11 = new int[12];
            int[] var12 = new int[12];
            int var13 = 0;
            int var14 = 0;
            int var15 = 0;
            int var16 = 0;
            boolean var17 = true;
            int var18 = 0;
            int var19 = 0;
            int var20 = 0;

            for (int var21 = 0; var21 < 3; var21++) {
               for (int var22 = 0; var22 < 12; var22++) {
                  var8[var21][var22] = this.clax[var2][var21][var22] + this.clx[var2] - this.x / 20;
                  var10[var21][var22] = this.claz[var2][var21][var22] + this.clz[var2] - this.z / 20;
                  var9[var21][var22] = this.clay[var2][var21][var22] + this.cldd[4] - this.y / 20;
               }

               this.rot(var8[var21], var10[var21], this.cx, this.cz, this.xz, 12);
               this.rot(var9[var21], var10[var21], this.cy, this.cz, this.zy, 12);
            }

            for (byte var60 = 0; var60 < 12; var60 += 2) {
               var13 = 0;
               var14 = 0;
               var15 = 0;
               var16 = 0;
               var17 = true;
               var18 = 0;
               var19 = 0;
               var20 = 0;

               for (int var64 = 0; var64 < 6; var64++) {
                  int var23 = 0;
                  byte var24 = 1;
                  if (var64 == 0) {
                     var23 = var60;
                  }

                  if (var64 == 1) {
                     var23 = var60 + 1;
                     if (var23 >= 12) {
                        var23 -= 12;
                     }
                  }

                  if (var64 == 2) {
                     var23 = var60 + 2;
                     if (var23 >= 12) {
                        var23 -= 12;
                     }
                  }

                  if (var64 == 3) {
                     var23 = var60 + 2;
                     if (var23 >= 12) {
                        var23 -= 12;
                     }

                     var24 = 2;
                  }

                  if (var64 == 4) {
                     var23 = var60 + 1;
                     if (var23 >= 12) {
                        var23 -= 12;
                     }

                     var24 = 2;
                  }

                  if (var64 == 5) {
                     var23 = var60;
                     var24 = 2;
                  }

                  var11[var64] = this.xs(var8[var24][var23], var10[var24][var23]);
                  var12[var64] = this.ys(var9[var24][var23], var10[var24][var23]);
                  var19 += var8[var24][var23];
                  var18 += var9[var24][var23];
                  var20 += var10[var24][var23];
                  if (var12[var64] < 0 || var10[0][var64] < 10) {
                     var13++;
                  }

                  if (var12[var64] > this.h || var10[0][var64] < 10) {
                     var14++;
                  }

                  if (var11[var64] < 0 || var10[0][var64] < 10) {
                     var15++;
                  }

                  if (var11[var64] > this.w || var10[0][var64] < 10) {
                     var16++;
                  }
               }

               if (var15 == 6 || var13 == 6 || var14 == 6 || var16 == 6) {
                  var17 = false;
               }

               if (var17) {
                  var19 /= 6;
                  var18 /= 6;
                  var20 /= 6;
                  int var65 = (int)Math.sqrt((this.cy - var18) * (this.cy - var18) + (this.cx - var19) * (this.cx - var19) + var20 * var20);
                  if (var65 < this.fade[7]) {
                     int var69 = this.clc[var2][1][var60 / 2][0];
                     int var73 = this.clc[var2][1][var60 / 2][1];
                     int var25 = this.clc[var2][1][var60 / 2][2];

                     for (int var26 = 0; var26 < 16; var26++) {
                        if (var65 > this.fade[var26]) {
                           var69 = (var69 * this.fogd + this.cfade[0]) / (this.fogd + 1);
                           var73 = (var73 * this.fogd + this.cfade[1]) / (this.fogd + 1);
                           var25 = (var25 * this.fogd + this.cfade[2]) / (this.fogd + 1);
                        }
                     }

                     var1.setColor(new Color(var69, var73, var25));
                     var1.fillPolygon(var11, var12, 6);
                  }
               }
            }

            for (byte var61 = 0; var61 < 12; var61 += 2) {
               var13 = 0;
               var14 = 0;
               var15 = 0;
               var16 = 0;
               var17 = true;
               var18 = 0;
               var19 = 0;
               var20 = 0;

               for (int var66 = 0; var66 < 6; var66++) {
                  int var70 = 0;
                  byte var74 = 0;
                  if (var66 == 0) {
                     var70 = var61;
                  }

                  if (var66 == 1) {
                     var70 = var61 + 1;
                     if (var70 >= 12) {
                        var70 -= 12;
                     }
                  }

                  if (var66 == 2) {
                     var70 = var61 + 2;
                     if (var70 >= 12) {
                        var70 -= 12;
                     }
                  }

                  if (var66 == 3) {
                     var70 = var61 + 2;
                     if (var70 >= 12) {
                        var70 -= 12;
                     }

                     var74 = 1;
                  }

                  if (var66 == 4) {
                     var70 = var61 + 1;
                     if (var70 >= 12) {
                        var70 -= 12;
                     }

                     var74 = 1;
                  }

                  if (var66 == 5) {
                     var70 = var61;
                     var74 = 1;
                  }

                  var11[var66] = this.xs(var8[var74][var70], var10[var74][var70]);
                  var12[var66] = this.ys(var9[var74][var70], var10[var74][var70]);
                  var19 += var8[var74][var70];
                  var18 += var9[var74][var70];
                  var20 += var10[var74][var70];
                  if (var12[var66] < 0 || var10[0][var66] < 10) {
                     var13++;
                  }

                  if (var12[var66] > this.h || var10[0][var66] < 10) {
                     var14++;
                  }

                  if (var11[var66] < 0 || var10[0][var66] < 10) {
                     var15++;
                  }

                  if (var11[var66] > this.w || var10[0][var66] < 10) {
                     var16++;
                  }
               }

               if (var15 == 6 || var13 == 6 || var14 == 6 || var16 == 6) {
                  var17 = false;
               }

               if (var17) {
                  var19 /= 6;
                  var18 /= 6;
                  var20 /= 6;
                  int var67 = (int)Math.sqrt((this.cy - var18) * (this.cy - var18) + (this.cx - var19) * (this.cx - var19) + var20 * var20);
                  if (var67 < this.fade[7]) {
                     int var71 = this.clc[var2][0][var61 / 2][0];
                     int var75 = this.clc[var2][0][var61 / 2][1];
                     int var77 = this.clc[var2][0][var61 / 2][2];

                     for (int var79 = 0; var79 < 16; var79++) {
                        if (var67 > this.fade[var79]) {
                           var71 = (var71 * this.fogd + this.cfade[0]) / (this.fogd + 1);
                           var75 = (var75 * this.fogd + this.cfade[1]) / (this.fogd + 1);
                           var77 = (var77 * this.fogd + this.cfade[2]) / (this.fogd + 1);
                        }
                     }

                     var1.setColor(new Color(var71, var75, var77));
                     var1.fillPolygon(var11, var12, 6);
                  }
               }
            }

            var13 = 0;
            var14 = 0;
            var15 = 0;
            var16 = 0;
            var17 = true;
            var18 = 0;
            var19 = 0;
            var20 = 0;

            for (int var62 = 0; var62 < 12; var62++) {
               var11[var62] = this.xs(var8[0][var62], var10[0][var62]);
               var12[var62] = this.ys(var9[0][var62], var10[0][var62]);
               var19 += var8[0][var62];
               var18 += var9[0][var62];
               var20 += var10[0][var62];
               if (var12[var62] < 0 || var10[0][var62] < 10) {
                  var13++;
               }

               if (var12[var62] > this.h || var10[0][var62] < 10) {
                  var14++;
               }

               if (var11[var62] < 0 || var10[0][var62] < 10) {
                  var15++;
               }

               if (var11[var62] > this.w || var10[0][var62] < 10) {
                  var16++;
               }
            }

            if (var15 == 12 || var13 == 12 || var14 == 12 || var16 == 12) {
               var17 = false;
            }

            if (var17) {
               var19 /= 12;
               var18 /= 12;
               var20 /= 12;
               int var63 = (int)Math.sqrt((this.cy - var18) * (this.cy - var18) + (this.cx - var19) * (this.cx - var19) + var20 * var20);
               if (var63 < this.fade[7]) {
                  int var68 = this.clds[0];
                  int var72 = this.clds[1];
                  int var76 = this.clds[2];

                  for (int var78 = 0; var78 < 16; var78++) {
                     if (var63 > this.fade[var78]) {
                        var68 = (var68 * this.fogd + this.cfade[0]) / (this.fogd + 1);
                        var72 = (var72 * this.fogd + this.cfade[1]) / (this.fogd + 1);
                        var76 = (var76 * this.fogd + this.cfade[2]) / (this.fogd + 1);
                     }
                  }

                  var1.setColor(new Color(var68, var72, var76));
                  var1.fillPolygon(var11, var12, 12);
               }
            }
         }
      }
   }

   public void newmountains(int var1, int var2, int var3, int var4) {
      Random var5 = new Random(this.mgen);
      this.nmt = (int)(20.0 + 10.0 * var5.nextDouble());
      int var6 = (var1 + var2) / 60;
      int var7 = (var3 + var4) / 60;
      int var8 = Math.max(var2 - var1, var4 - var3) / 60;
      this.mrd = null;
      this.nmv = null;
      this.mtx = (int[][])null;
      this.mty = (int[][])null;
      this.mtz = (int[][])null;
      this.mtc = (int[][][])null;
      this.mrd = new int[this.nmt];
      this.nmv = new int[this.nmt];
      this.mtx = new int[this.nmt][];
      this.mty = new int[this.nmt][];
      this.mtz = new int[this.nmt][];
      this.mtc = new int[this.nmt][][];
      int[] var9 = new int[this.nmt];
      int[] var10 = new int[this.nmt];

      for (int var11 = 0; var11 < this.nmt; var11++) {
         int var12 = 85;
         float var13 = 0.5F;
         float var14 = 0.5F;
         var9[var11] = (int)(10000.0 + var5.nextDouble() * 10000.0);
         int var15 = (int)(var5.nextDouble() * 360.0);
         if (var5.nextDouble() > var5.nextDouble()) {
            var13 = (float)(0.2 + var5.nextDouble() * 0.35);
            var14 = (float)(0.2 + var5.nextDouble() * 0.35);
            this.nmv[var11] = (int)(var13 * (24.0 + 16.0 * var5.nextDouble()));
            var12 = (int)(85.0 + 10.0 * var5.nextDouble());
         } else {
            var13 = (float)(0.3 + var5.nextDouble() * 1.1);
            var14 = (float)(0.2 + var5.nextDouble() * 0.35);
            this.nmv[var11] = (int)(var13 * (12.0 + 8.0 * var5.nextDouble()));
            var12 = (int)(104.0 - 10.0 * var5.nextDouble());
         }

         this.mtx[var11] = new int[this.nmv[var11] * 2];
         this.mty[var11] = new int[this.nmv[var11] * 2];
         this.mtz[var11] = new int[this.nmv[var11] * 2];
         this.mtc[var11] = new int[this.nmv[var11]][3];

         for (int var16 = 0; var16 < this.nmv[var11]; var16++) {
            this.mtx[var11][var16] = (int)((var16 * 500 + (var5.nextDouble() * 800.0 - 400.0) - 250 * (this.nmv[var11] - 1)) * var13);
            this.mtx[var11][var16 + this.nmv[var11]] = (int)((var16 * 500 + (var5.nextDouble() * 800.0 - 400.0) - 250 * (this.nmv[var11] - 1)) * var13);
            this.mtx[var11][this.nmv[var11]] = (int)(this.mtx[var11][0] - (100.0 + var5.nextDouble() * 600.0) * var13);
            this.mtx[var11][this.nmv[var11] * 2 - 1] = (int)(this.mtx[var11][this.nmv[var11] - 1] + (100.0 + var5.nextDouble() * 600.0) * var13);
            if (var16 == 0 || var16 == this.nmv[var11] - 1) {
               this.mty[var11][var16] = (int)((-400.0 - 1200.0 * var5.nextDouble()) * var14 + this.ground);
            }

            if (var16 == 1 || var16 == this.nmv[var11] - 2) {
               this.mty[var11][var16] = (int)((-1000.0 - 1450.0 * var5.nextDouble()) * var14 + this.ground);
            }

            if (var16 > 1 && var16 < this.nmv[var11] - 2) {
               this.mty[var11][var16] = (int)((-1600.0 - 1700.0 * var5.nextDouble()) * var14 + this.ground);
            }

            this.mty[var11][var16 + this.nmv[var11]] = this.ground - 70;
            this.mtz[var11][var16] = var7 + var8 + var9[var11];
            this.mtz[var11][var16 + this.nmv[var11]] = var7 + var8 + var9[var11];
            float var17 = (float)(0.5 + var5.nextDouble() * 0.5);
            this.mtc[var11][var16][0] = (int)(170.0F * var17 + 170.0F * var17 * (this.snap[0] / 100.0F));
            if (this.mtc[var11][var16][0] > 255) {
               this.mtc[var11][var16][0] = 255;
            }

            if (this.mtc[var11][var16][0] < 0) {
               this.mtc[var11][var16][0] = 0;
            }

            this.mtc[var11][var16][1] = (int)(var12 * var17 + 85.0F * var17 * (this.snap[1] / 100.0F));
            if (this.mtc[var11][var16][1] > 255) {
               this.mtc[var11][var16][1] = 255;
            }

            if (this.mtc[var11][var16][1] < 1) {
               this.mtc[var11][var16][1] = 0;
            }

            this.mtc[var11][var16][2] = 0;
         }

         for (int var24 = 1; var24 < this.nmv[var11] - 1; var24++) {
            int var25 = var24 - 1;
            int var18 = var24 + 1;
            this.mty[var11][var24] = ((this.mty[var11][var25] + this.mty[var11][var18]) / 2 + this.mty[var11][var24]) / 2;
         }

         this.rot(this.mtx[var11], this.mtz[var11], var6, var7, var15, this.nmv[var11] * 2);
         var10[var11] = 0;
      }

      for (int var19 = 0; var19 < this.nmt; this.mrd[var10[var19]] = var19++) {
         for (int var21 = var19 + 1; var21 < this.nmt; var21++) {
            if (var9[var19] < var9[var21]) {
               var10[var19]++;
            } else {
               var10[var21]++;
            }
         }
      }
   }

   public void drawmountains(Graphics2D var1) {
      for (int var2 = 0; var2 < this.nmt; var2++) {
         int var3 = this.mrd[var2];
         int var4 = this.cx
            + (int)((this.mtx[var3][0] - this.x / 30 - this.cx) * this.cos(this.xz) - (this.mtz[var3][0] - this.z / 30 - this.cz) * this.sin(this.xz));
         int var5 = this.cz
            + (int)((this.mtx[var3][0] - this.x / 30 - this.cx) * this.sin(this.xz) + (this.mtz[var3][0] - this.z / 30 - this.cz) * this.cos(this.xz));
         int var6 = this.cz + (int)((this.mty[var3][0] - this.y / 30 - this.cy) * this.sin(this.zy) + (var5 - this.cz) * this.cos(this.zy));
         int var7 = this.cx
            + (int)(
               (this.mtx[var3][this.nmv[var3] - 1] - this.x / 30 - this.cx) * this.cos(this.xz)
                  - (this.mtz[var3][this.nmv[var3] - 1] - this.z / 30 - this.cz) * this.sin(this.xz)
            );
         int var8 = this.cz
            + (int)(
               (this.mtx[var3][this.nmv[var3] - 1] - this.x / 30 - this.cx) * this.sin(this.xz)
                  + (this.mtz[var3][this.nmv[var3] - 1] - this.z / 30 - this.cz) * this.cos(this.xz)
            );
         int var9 = this.cz + (int)((this.mty[var3][this.nmv[var3] - 1] - this.y / 30 - this.cy) * this.sin(this.zy) + (var8 - this.cz) * this.cos(this.zy));
         if (this.xs(var7, var9) > 0 && this.xs(var4, var6) < this.w) {
            int[] var10 = new int[this.nmv[var3] * 2];
            int[] var11 = new int[this.nmv[var3] * 2];
            int[] var12 = new int[this.nmv[var3] * 2];

            for (int var13 = 0; var13 < this.nmv[var3] * 2; var13++) {
               var10[var13] = this.mtx[var3][var13] - this.x / 30;
               var11[var13] = this.mty[var3][var13] - this.y / 30;
               var12[var13] = this.mtz[var3][var13] - this.z / 30;
            }

            int var26 = (int)Math.sqrt(var10[this.nmv[var3] / 4] * var10[this.nmv[var3] / 4] + var12[this.nmv[var3] / 4] * var12[this.nmv[var3] / 4]);
            this.rot(var10, var12, this.cx, this.cz, this.xz, this.nmv[var3] * 2);
            this.rot(var11, var12, this.cy, this.cz, this.zy, this.nmv[var3] * 2);
            int[] var14 = new int[4];
            int[] var15 = new int[4];
            int var16 = 0;
            int var17 = 0;
            int var18 = 0;
            int var19 = 0;
            boolean var20 = true;

            for (int var21 = 0; var21 < this.nmv[var3] - 1; var21++) {
               var16 = 0;
               var17 = 0;
               var18 = 0;
               var19 = 0;
               var20 = true;

               for (int var22 = 0; var22 < 4; var22++) {
                  int var23 = var22 + var21;
                  if (var22 == 2) {
                     var23 = var21 + this.nmv[var3] + 1;
                  }

                  if (var22 == 3) {
                     var23 = var21 + this.nmv[var3];
                  }

                  var14[var22] = this.xs(var10[var23], var12[var23]);
                  var15[var22] = this.ys(var11[var23], var12[var23]);
                  if (var15[var22] < 0 || var12[var23] < 10) {
                     var16++;
                  }

                  if (var15[var22] > this.h || var12[var23] < 10) {
                     var17++;
                  }

                  if (var14[var22] < 0 || var12[var23] < 10) {
                     var18++;
                  }

                  if (var14[var22] > this.w || var12[var23] < 10) {
                     var19++;
                  }
               }

               if (var18 == 4 || var16 == 4 || var17 == 4 || var19 == 4) {
                  var20 = false;
               }

               if (var20) {
                  float var32 = var26 / 2500.0F + (8000.0F - this.fade[0]) / 1000.0F - 2.0F - (Math.abs(this.y) - 250.0F) / 5000.0F;
                  if (var32 > 0.0F && var32 < 10.0F) {
                     if (var32 < 3.5) {
                        var32 = 3.5F;
                     }

                     int var33 = (int)((this.mtc[var3][var21][0] + this.cgrnd[0] + this.csky[0] * var32 + this.cfade[0] * var32) / (2.0F + var32 * 2.0F));
                     int var24 = (int)((this.mtc[var3][var21][1] + this.cgrnd[1] + this.csky[1] * var32 + this.cfade[1] * var32) / (2.0F + var32 * 2.0F));
                     int var25 = (int)((this.mtc[var3][var21][2] + this.cgrnd[2] + this.csky[2] * var32 + this.cfade[2] * var32) / (2.0F + var32 * 2.0F));
                     var1.setColor(new Color(var33, var24, var25));
                     var1.fillPolygon(var14, var15, 4);
                  }
               }
            }
         }
      }
   }

   public void newstars() {
      this.stx = null;
      this.stz = null;
      this.stc = (int[][][])null;
      this.bst = null;
      this.twn = null;
      this.nst = 0;
      if (this.lightson) {
         Random var1 = new Random((long)(Math.random() * 100000.0));
         this.nst = 40;
         this.stx = new int[this.nst];
         this.stz = new int[this.nst];
         this.stc = new int[this.nst][2][3];
         this.bst = new boolean[this.nst];
         this.twn = new int[this.nst];

         for (int var2 = 0; var2 < this.nst; var2++) {
            this.stx[var2] = (int)(2000.0 * var1.nextDouble() - 1000.0);
            this.stz[var2] = (int)(2000.0 * var1.nextDouble() - 1000.0);
            int var3 = (int)(3.0 * var1.nextDouble());
            if (var3 >= 3) {
               var3 = 0;
            }

            if (var3 <= -1) {
               var3 = 2;
            }

            int var4 = var3 + 1;
            if (var1.nextDouble() > var1.nextDouble()) {
               var4 = var3 - 1;
            }

            if (var4 == 3) {
               var4 = 0;
            }

            if (var4 == -1) {
               var4 = 2;
            }

            for (int var5 = 0; var5 < 3; var5++) {
               this.stc[var2][0][var5] = 200;
               if (var3 == var5) {
                  this.stc[var2][0][var5] = this.stc[var2][0][var5] + (int)(55.0 * var1.nextDouble());
               }

               if (var4 == var5) {
                  this.stc[var2][0][var5] = this.stc[var2][0][var5] + 55;
               }

               this.stc[var2][0][var5] = (this.stc[var2][0][var5] * 2 + this.csky[var5]) / 3;
               this.stc[var2][1][var5] = (this.stc[var2][0][var5] + this.csky[var5]) / 2;
            }

            this.twn[var2] = (int)(4.0 * var1.nextDouble());
            if (var1.nextDouble() > 0.8) {
               this.bst[var2] = true;
            } else {
               this.bst[var2] = false;
            }
         }
      }
   }

   public void drawstars(Graphics2D var1) {
      for (int var2 = 0; var2 < this.nst; var2++) {
         int var3 = this.cx + (int)(this.stx[var2] * this.cos(this.xz) - this.stz[var2] * this.sin(this.xz));
         int var4 = this.cz + (int)(this.stx[var2] * this.sin(this.xz) + this.stz[var2] * this.cos(this.xz));
         int var5 = this.cy + (int)(-200.0F * this.cos(this.zy) - var4 * this.sin(this.zy));
         int var6 = this.cz + (int)(-200.0F * this.sin(this.zy) + var4 * this.cos(this.zy));
         var3 = this.xs(var3, var6);
         var5 = this.ys(var5, var6);
         if (var3 - 1 > this.iw && var3 + 3 < this.w && var5 - 1 > this.ih && var5 + 3 < this.h) {
            if (this.twn[var2] == 0) {
               int var7 = (int)(3.0 * Math.random());
               if (var7 >= 3) {
                  var7 = 0;
               }

               if (var7 <= -1) {
                  var7 = 2;
               }

               int var8 = var7 + 1;
               if (Math.random() > Math.random()) {
                  var8 = var7 - 1;
               }

               if (var8 == 3) {
                  var8 = 0;
               }

               if (var8 == -1) {
                  var8 = 2;
               }

               for (int var9 = 0; var9 < 3; var9++) {
                  this.stc[var2][0][var9] = 200;
                  if (var7 == var9) {
                     this.stc[var2][0][var9] = this.stc[var2][0][var9] + (int)(55.0 * Math.random());
                  }

                  if (var8 == var9) {
                     this.stc[var2][0][var9] = this.stc[var2][0][var9] + 55;
                  }

                  this.stc[var2][0][var9] = (this.stc[var2][0][var9] * 2 + this.csky[var9]) / 3;
                  this.stc[var2][1][var9] = (this.stc[var2][0][var9] + this.csky[var9]) / 2;
               }

               this.twn[var2] = 3;
            } else {
               this.twn[var2]--;
            }

            byte var12 = 0;
            if (this.bst[var2]) {
               var12 = 1;
            }

            var1.setColor(new Color(this.stc[var2][1][0], this.stc[var2][1][1], this.stc[var2][1][2]));
            var1.fillRect(var3 - 1, var5, 3 + var12, 1 + var12);
            var1.fillRect(var3, var5 - 1, 1 + var12, 3 + var12);
            var1.setColor(new Color(this.stc[var2][0][0], this.stc[var2][0][1], this.stc[var2][0][2]));
            var1.fillRect(var3, var5, 1 + var12, 1 + var12);
         }
      }
   }

   public void d(Graphics2D var1) {
      this.nsp = 0;
      if (this.zy > 90) {
         this.zy = 90;
      }

      if (this.zy < -90) {
         this.zy = -90;
      }

      if (this.xz > 360) {
         this.xz -= 360;
      }

      if (this.xz < 0) {
         this.xz += 360;
      }

      if (this.y > 0) {
         this.y = 0;
      }

      this.ground = 250 - this.y;
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      int var4 = this.cgrnd[0];
      int var5 = this.cgrnd[1];
      int var6 = this.cgrnd[2];
      int var7 = this.crgrnd[0];
      int var8 = this.crgrnd[1];
      int var9 = this.crgrnd[2];
      int var10 = this.h;

      for (int var11 = 0; var11 < 16; var11++) {
         int var12 = this.fade[var11];
         int var13 = this.ground;
         if (this.zy != 0) {
            var13 = this.cy + (int)((this.ground - this.cy) * this.cos(this.zy) - (this.fade[var11] - this.cz) * this.sin(this.zy));
            var12 = this.cz + (int)((this.ground - this.cy) * this.sin(this.zy) + (this.fade[var11] - this.cz) * this.cos(this.zy));
         }

         var2[0] = this.iw;
         var3[0] = this.ys(var13, var12);
         if (var3[0] < this.ih) {
            var3[0] = this.ih;
         }

         if (var3[0] > this.h) {
            var3[0] = this.h;
         }

         var2[1] = this.iw;
         var3[1] = var10;
         var2[2] = this.w;
         var3[2] = var10;
         var2[3] = this.w;
         var3[3] = var3[0];
         var10 = var3[0];
         if (var11 > 0) {
            var7 = (var7 * 7 + this.cfade[0]) / 8;
            var8 = (var8 * 7 + this.cfade[1]) / 8;
            var9 = (var9 * 7 + this.cfade[2]) / 8;
            if (var11 < 3) {
               var4 = (var4 * 7 + this.cfade[0]) / 8;
               var5 = (var5 * 7 + this.cfade[1]) / 8;
               var6 = (var6 * 7 + this.cfade[2]) / 8;
            } else {
               var4 = var7;
               var5 = var8;
               var6 = var9;
            }
         }

         if (var3[0] < this.h && var3[1] > this.ih) {
            var1.setColor(new Color(var4, var5, var6));
            var1.fillPolygon(var2, var3, 4);
         }
      }

      if (this.lightn != -1 && this.lton) {
         if (this.lightn < 16) {
            if (this.lilo > this.lightn + 217) {
               this.lilo -= 3;
            } else {
               this.lightn = (int)(16.0F + 16.0F * this.random());
            }
         } else if (this.lilo < this.lightn + 217) {
            this.lilo += 7;
         } else {
            this.lightn = (int)(16.0F * this.random());
         }

         this.csky[0] = (int)(this.lilo + this.lilo * (this.snap[0] / 100.0F));
         if (this.csky[0] > 255) {
            this.csky[0] = 255;
         }

         if (this.csky[0] < 0) {
            this.csky[0] = 0;
         }

         this.csky[1] = (int)(this.lilo + this.lilo * (this.snap[1] / 100.0F));
         if (this.csky[1] > 255) {
            this.csky[1] = 255;
         }

         if (this.csky[1] < 0) {
            this.csky[1] = 0;
         }

         this.csky[2] = (int)(this.lilo + this.lilo * (this.snap[2] / 100.0F));
         if (this.csky[2] > 255) {
            this.csky[2] = 255;
         }

         if (this.csky[2] < 0) {
            this.csky[2] = 0;
         }
      }

      var4 = this.csky[0];
      var5 = this.csky[1];
      var6 = this.csky[2];
      int var26 = var4;
      int var27 = var5;
      int var28 = var6;
      int var14 = this.cy + (int)((this.skyline - 700 - this.cy) * this.cos(this.zy) - (7000 - this.cz) * this.sin(this.zy));
      int var15 = this.cz + (int)((this.skyline - 700 - this.cy) * this.sin(this.zy) + (7000 - this.cz) * this.cos(this.zy));
      var14 = this.ys(var14, var15);
      int var16 = this.ih;

      for (int var17 = 0; var17 < 16; var17++) {
         int var18 = this.fade[var17];
         int var19 = this.skyline;
         if (this.zy != 0) {
            var19 = this.cy + (int)((this.skyline - this.cy) * this.cos(this.zy) - (this.fade[var17] - this.cz) * this.sin(this.zy));
            var18 = this.cz + (int)((this.skyline - this.cy) * this.sin(this.zy) + (this.fade[var17] - this.cz) * this.cos(this.zy));
         }

         var2[0] = this.iw;
         var3[0] = this.ys(var19, var18);
         if (var3[0] > this.h) {
            var3[0] = this.h;
         }

         if (var3[0] < this.ih) {
            var3[0] = this.ih;
         }

         var2[1] = this.iw;
         var3[1] = var16;
         var2[2] = this.w;
         var3[2] = var16;
         var2[3] = this.w;
         var3[3] = var3[0];
         var16 = var3[0];
         if (var17 > 0) {
            var4 = (var4 * 7 + this.cfade[0]) / 8;
            var5 = (var5 * 7 + this.cfade[1]) / 8;
            var6 = (var6 * 7 + this.cfade[2]) / 8;
         }

         if (var3[1] < var14) {
            var26 = var4;
            var27 = var5;
            var28 = var6;
         }

         if (var3[0] > this.ih && var3[1] < this.h) {
            var1.setColor(new Color(var4, var5, var6));
            var1.fillPolygon(var2, var3, 4);
         }
      }

      var2[0] = this.iw;
      var3[0] = var16;
      var2[1] = this.iw;
      var3[1] = var10;
      var2[2] = this.w;
      var3[2] = var10;
      var2[3] = this.w;
      var3[3] = var16;
      if (var3[0] < this.h && var3[1] > this.ih) {
         float var30 = (Math.abs(this.y) - 250.0F) / (this.fade[0] * 2);
         if (var30 < 0.0F) {
            var30 = 0.0F;
         }

         if (var30 > 1.0F) {
            var30 = 1.0F;
         }

         var4 = (int)((var4 * (1.0F - var30) + var7 * (1.0F + var30)) / 2.0F);
         var5 = (int)((var5 * (1.0F - var30) + var8 * (1.0F + var30)) / 2.0F);
         var6 = (int)((var6 * (1.0F - var30) + var9 * (1.0F + var30)) / 2.0F);
         var1.setColor(new Color(var4, var5, var6));
         var1.fillPolygon(var2, var3, 4);
      }

      if (this.resdown != 2) {
         for (int var31 = 1; var31 < 20; var31++) {
            int var32 = 7000;
            int var33 = this.skyline - 700 - var31 * 70;
            if (this.zy != 0 && var31 != 19) {
               var33 = this.cy + (int)((this.skyline - 700 - var31 * 70 - this.cy) * this.cos(this.zy) - (7000 - this.cz) * this.sin(this.zy));
               var32 = this.cz + (int)((this.skyline - 700 - var31 * 70 - this.cy) * this.sin(this.zy) + (7000 - this.cz) * this.cos(this.zy));
            }

            var2[0] = this.iw;
            if (var31 != 19) {
               var3[0] = this.ys(var33, var32);
               if (var3[0] > this.h) {
                  var3[0] = this.h;
               }

               if (var3[0] < this.ih) {
                  var3[0] = this.ih;
               }
            } else {
               var3[0] = this.ih;
            }

            var2[1] = this.iw;
            var3[1] = var14;
            var2[2] = this.w;
            var3[2] = var14;
            var2[3] = this.w;
            var3[3] = var3[0];
            var14 = var3[0];
            var26 = (int)(var26 * 0.991);
            var27 = (int)(var27 * 0.991);
            var28 = (int)(var28 * 0.998);
            if (var3[1] > this.ih && var3[0] < this.h) {
               var1.setColor(new Color(var26, var27, var28));
               var1.fillPolygon(var2, var3, 4);
            }
         }

         if (this.lightson) {
            this.drawstars(var1);
         }

         this.drawmountains(var1);
         this.drawclouds(var1);
      }

      this.groundpolys(var1);
      if (this.noelec != 0) {
         this.noelec--;
      }

      if (this.cpflik) {
         this.cpflik = false;
      } else {
         this.cpflik = true;
         this.elecr = this.random() * 15.0F - 6.0F;
      }
   }

   public void addsp(int var1, int var2, int var3) {
      if (this.nsp != 7) {
         this.spx[this.nsp] = var1;
         this.spz[this.nsp] = var2;
         this.sprad[this.nsp] = var3;
         this.nsp++;
      }
   }

   public void setsnap(int var1, int var2, int var3) {
      this.snap[0] = var1;
      this.snap[1] = var2;
      this.snap[2] = var3;
   }

   public void setsky(int var1, int var2, int var3) {
      this.osky[0] = var1;
      this.osky[1] = var2;
      this.osky[2] = var3;

      for (int var4 = 0; var4 < 3; var4++) {
         this.clds[var4] = (this.osky[var4] * this.cldd[3] + this.cldd[var4]) / (this.cldd[3] + 1);
         this.clds[var4] = (int)(this.clds[var4] + this.clds[var4] * (this.snap[var4] / 100.0F));
         if (this.clds[var4] > 255) {
            this.clds[var4] = 255;
         }

         if (this.clds[var4] < 0) {
            this.clds[var4] = 0;
         }
      }

      this.csky[0] = (int)(var1 + var1 * (this.snap[0] / 100.0F));
      if (this.csky[0] > 255) {
         this.csky[0] = 255;
      }

      if (this.csky[0] < 0) {
         this.csky[0] = 0;
      }

      this.csky[1] = (int)(var2 + var2 * (this.snap[1] / 100.0F));
      if (this.csky[1] > 255) {
         this.csky[1] = 255;
      }

      if (this.csky[1] < 0) {
         this.csky[1] = 0;
      }

      this.csky[2] = (int)(var3 + var3 * (this.snap[2] / 100.0F));
      if (this.csky[2] > 255) {
         this.csky[2] = 255;
      }

      if (this.csky[2] < 0) {
         this.csky[2] = 0;
      }

      float[] var5 = new float[3];
      Color.RGBtoHSB(this.csky[0], this.csky[1], this.csky[2], var5);
      if (var5[2] < 0.6) {
         this.darksky = true;
      } else {
         this.darksky = false;
      }
   }

   public void setcloads(int var1, int var2, int var3, int var4, int var5) {
      if (var4 < 0) {
         var4 = 0;
      }

      if (var4 > 10) {
         var4 = 10;
      }

      if (var5 < -1500) {
         var5 = -1500;
      }

      if (var5 > -500) {
         var5 = -500;
      }

      this.cldd[0] = var1;
      this.cldd[1] = var2;
      this.cldd[2] = var3;
      this.cldd[3] = var4;
      this.cldd[4] = var5;

      for (int var6 = 0; var6 < 3; var6++) {
         this.clds[var6] = (this.osky[var6] * this.cldd[3] + this.cldd[var6]) / (this.cldd[3] + 1);
         this.clds[var6] = (int)(this.clds[var6] + this.clds[var6] * (this.snap[var6] / 100.0F));
         if (this.clds[var6] > 255) {
            this.clds[var6] = 255;
         }

         if (this.clds[var6] < 0) {
            this.clds[var6] = 0;
         }
      }
   }

   public void setgrnd(int var1, int var2, int var3) {
      this.ogrnd[0] = var1;
      this.ogrnd[1] = var2;
      this.ogrnd[2] = var3;

      for (int var4 = 0; var4 < 3; var4++) {
         this.cpol[var4] = (this.ogrnd[var4] * this.texture[3] + this.texture[var4]) / (1 + this.texture[3]);
         this.cpol[var4] = (int)(this.cpol[var4] + this.cpol[var4] * (this.snap[var4] / 100.0F));
         if (this.cpol[var4] > 255) {
            this.cpol[var4] = 255;
         }

         if (this.cpol[var4] < 0) {
            this.cpol[var4] = 0;
         }
      }

      this.cgrnd[0] = (int)(var1 + var1 * (this.snap[0] / 100.0F));
      if (this.cgrnd[0] > 255) {
         this.cgrnd[0] = 255;
      }

      if (this.cgrnd[0] < 0) {
         this.cgrnd[0] = 0;
      }

      this.cgrnd[1] = (int)(var2 + var2 * (this.snap[1] / 100.0F));
      if (this.cgrnd[1] > 255) {
         this.cgrnd[1] = 255;
      }

      if (this.cgrnd[1] < 0) {
         this.cgrnd[1] = 0;
      }

      this.cgrnd[2] = (int)(var3 + var3 * (this.snap[2] / 100.0F));
      if (this.cgrnd[2] > 255) {
         this.cgrnd[2] = 255;
      }

      if (this.cgrnd[2] < 0) {
         this.cgrnd[2] = 0;
      }

      for (int var5 = 0; var5 < 3; var5++) {
         this.crgrnd[var5] = (int)((this.cpol[var5] * 0.99 + this.cgrnd[var5]) / 2.0);
      }
   }

   public void setexture(int var1, int var2, int var3, int var4) {
      if (var4 < 20) {
         var4 = 20;
      }

      if (var4 > 60) {
         var4 = 60;
      }

      this.texture[0] = var1;
      this.texture[1] = var2;
      this.texture[2] = var3;
      this.texture[3] = var4;
      var1 = (this.ogrnd[0] * var4 + var1) / (1 + var4);
      var2 = (this.ogrnd[1] * var4 + var2) / (1 + var4);
      var3 = (this.ogrnd[2] * var4 + var3) / (1 + var4);
      this.cpol[0] = (int)(var1 + var1 * (this.snap[0] / 100.0F));
      if (this.cpol[0] > 255) {
         this.cpol[0] = 255;
      }

      if (this.cpol[0] < 0) {
         this.cpol[0] = 0;
      }

      this.cpol[1] = (int)(var2 + var2 * (this.snap[1] / 100.0F));
      if (this.cpol[1] > 255) {
         this.cpol[1] = 255;
      }

      if (this.cpol[1] < 0) {
         this.cpol[1] = 0;
      }

      this.cpol[2] = (int)(var3 + var3 * (this.snap[2] / 100.0F));
      if (this.cpol[2] > 255) {
         this.cpol[2] = 255;
      }

      if (this.cpol[2] < 0) {
         this.cpol[2] = 0;
      }

      for (int var5 = 0; var5 < 3; var5++) {
         this.crgrnd[var5] = (int)((this.cpol[var5] * 0.99 + this.cgrnd[var5]) / 2.0);
      }
   }

   public void setpolys(int var1, int var2, int var3) {
      this.cpol[0] = (int)(var1 + var1 * (this.snap[0] / 100.0F));
      if (this.cpol[0] > 255) {
         this.cpol[0] = 255;
      }

      if (this.cpol[0] < 0) {
         this.cpol[0] = 0;
      }

      this.cpol[1] = (int)(var2 + var2 * (this.snap[1] / 100.0F));
      if (this.cpol[1] > 255) {
         this.cpol[1] = 255;
      }

      if (this.cpol[1] < 0) {
         this.cpol[1] = 0;
      }

      this.cpol[2] = (int)(var3 + var3 * (this.snap[2] / 100.0F));
      if (this.cpol[2] > 255) {
         this.cpol[2] = 255;
      }

      if (this.cpol[2] < 0) {
         this.cpol[2] = 0;
      }

      for (int var4 = 0; var4 < 3; var4++) {
         this.crgrnd[var4] = (int)((this.cpol[var4] * 0.99 + this.cgrnd[var4]) / 2.0);
      }
   }

   public void setfade(int var1, int var2, int var3) {
      this.cfade[0] = (int)(var1 + var1 * (this.snap[0] / 100.0F));
      if (this.cfade[0] > 255) {
         this.cfade[0] = 255;
      }

      if (this.cfade[0] < 0) {
         this.cfade[0] = 0;
      }

      this.cfade[1] = (int)(var2 + var2 * (this.snap[1] / 100.0F));
      if (this.cfade[1] > 255) {
         this.cfade[1] = 255;
      }

      if (this.cfade[1] < 0) {
         this.cfade[1] = 0;
      }

      this.cfade[2] = (int)(var3 + var3 * (this.snap[2] / 100.0F));
      if (this.cfade[2] > 255) {
         this.cfade[2] = 255;
      }

      if (this.cfade[2] < 0) {
         this.cfade[2] = 0;
      }
   }

   public void fadfrom(int var1) {
      if (var1 > 8000) {
         var1 = 8000;
      }

      for (int var2 = 1; var2 < 17; var2++) {
         this.fade[var2 - 1] = var1 / 2 * (var2 + 1);
      }
   }

   public void adjstfade(float var1, float var2, int var3, GameSparker var4) {
      if (this.resdown != 2) {
         if (var1 == 5.0F) {
            if (this.resdown == 0 && this.rescnt == 0) {
               var4.moto = 0;
               Madness.anti = 0;
               this.fade[0] = 3000;
               this.fadfrom(this.fade[0]);
               this.resdown = 1;
               this.rescnt = 10;
            }

            if (this.resdown == 1 && this.rescnt == 0) {
               this.resdown = 2;
            }

            if ((var3 == 0 || this.resdown == 0) && var2 <= -20.0F) {
               this.rescnt--;
            }
         } else if (this.resdown == 0) {
            this.rescnt = 5;
         } else {
            this.rescnt = 10;
         }
      }
   }

   public int xs(int var1, int var2) {
      if (var2 < this.cz) {
         var2 = this.cz;
      }

      return (var2 - this.focus_point) * (this.cx - var1) / var2 + var1;
   }

   public int ys(int var1, int var2) {
      if (var2 < 10) {
         var2 = 10;
      }

      return (var2 - this.focus_point) * (this.cy - var1) / var2 + var1;
   }

   public float cos(int var1) {
      while (var1 >= 360) {
         var1 -= 360;
      }

      while (var1 < 0) {
         var1 += 360;
      }

      return this.tcos[var1];
   }

   public float sin(int var1) {
      while (var1 >= 360) {
         var1 -= 360;
      }

      while (var1 < 0) {
         var1 += 360;
      }

      return this.tsin[var1];
   }

   public void rot(int[] var1, int[] var2, int var3, int var4, int var5, int var6) {
      if (var5 != 0) {
         for (int var7 = 0; var7 < var6; var7++) {
            int var8 = var1[var7];
            int var9 = var2[var7];
            var1[var7] = var3 + (int)((var8 - var3) * this.cos(var5) - (var9 - var4) * this.sin(var5));
            var2[var7] = var4 + (int)((var8 - var3) * this.sin(var5) + (var9 - var4) * this.cos(var5));
         }
      }
   }
}
