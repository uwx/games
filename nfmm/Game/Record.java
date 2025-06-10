import java.awt.Color;

public class Record {
   Medium m;
   int caught = 0;
   boolean hcaught = false;
   boolean prepit = true;
   ContO[] ocar = new ContO[8];
   int cntf = 50;
   ContO[][] car = new ContO[6][8];
   int[][] squash = new int[6][8];
   int[] fix = new int[8];
   int[] dest = new int[8];
   int[][] x = new int[300][8];
   int[][] y = new int[300][8];
   int[][] z = new int[300][8];
   int[][] xy = new int[300][8];
   int[][] zy = new int[300][8];
   int[][] xz = new int[300][8];
   int[][] wxz = new int[300][8];
   int[][] wzy = new int[300][8];
   int[][] ns = new int[8][20];
   int[][][] sspark = new int[8][20][30];
   int[][][] sx = new int[8][20][30];
   int[][][] sy = new int[8][20][30];
   int[][][] sz = new int[8][20][30];
   float[][][] smag = new float[8][20][30];
   int[][][] scx = new int[8][20][30];
   int[][][] scz = new int[8][20][30];
   int[] nr = new int[8];
   int[][] rspark = new int[8][200];
   int[][] sprk = new int[8][200];
   int[][] srx = new int[8][200];
   int[][] sry = new int[8][200];
   int[][] srz = new int[8][200];
   float[][] rcx = new float[8][200];
   float[][] rcy = new float[8][200];
   float[][] rcz = new float[8][200];
   int[][] nry = new int[8][4];
   int[][][] ry = new int[8][4][7];
   int[][][] magy = new int[8][4][7];
   boolean[][] mtouch = new boolean[8][7];
   int[][] nrx = new int[8][4];
   int[][][] rx = new int[8][4][7];
   int[][][] magx = new int[8][4][7];
   int[][] nrz = new int[8][4];
   int[][][] rz = new int[8][4][7];
   int[][][] magz = new int[8][4][7];
   int[] checkpoint = new int[300];
   boolean[] lastcheck = new boolean[300];
   int wasted = 0;
   int whenwasted = 0;
   int powered = 0;
   int closefinish = 0;
   ContO[] starcar = new ContO[8];
   int[] hsquash = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
   int[] hfix = new int[]{-1, -1, -1, -1, -1, -1, -1, -1};
   int[] hdest = new int[]{-1, -1, -1, -1, -1, -1, -1, -1};
   int[][] hx = new int[300][8];
   int[][] hy = new int[300][8];
   int[][] hz = new int[300][8];
   int[][] hxy = new int[300][8];
   int[][] hzy = new int[300][8];
   int[][] hxz = new int[300][8];
   int[][] hwxz = new int[300][8];
   int[][] hwzy = new int[300][8];
   int[][][] hsspark = new int[8][20][30];
   int[][][] hsx = new int[8][20][30];
   int[][][] hsy = new int[8][20][30];
   int[][][] hsz = new int[8][20][30];
   float[][][] hsmag = new float[8][20][30];
   int[][][] hscx = new int[8][20][30];
   int[][][] hscz = new int[8][20][30];
   int[][] hrspark = new int[8][200];
   int[][] hsprk = new int[8][200];
   int[][] hsrx = new int[8][200];
   int[][] hsry = new int[8][200];
   int[][] hsrz = new int[8][200];
   float[][] hrcx = new float[8][200];
   float[][] hrcy = new float[8][200];
   float[][] hrcz = new float[8][200];
   int[][][] hry = new int[8][4][7];
   int[][][] hmagy = new int[8][4][7];
   int[][][] hrx = new int[8][4][7];
   int[][][] hmagx = new int[8][4][7];
   int[][][] hrz = new int[8][4][7];
   int[][][] hmagz = new int[8][4][7];
   boolean[][] hmtouch = new boolean[8][7];
   int[] hcheckpoint = new int[300];
   boolean[] hlastcheck = new boolean[300];
   int[] cntdest = new int[8];
   int lastfr = 0;

   public Record(Medium var1) {
      this.m = var1;
      this.caught = 0;
      this.cotchinow(0);
   }

   public void reset(ContO[] var1) {
      this.caught = 0;
      this.hcaught = false;
      this.wasted = 0;
      this.whenwasted = 0;
      this.closefinish = 0;
      this.powered = 0;

      for (int var2 = 0; var2 < 8; var2++) {
         if (this.prepit) {
            this.starcar[var2] = new ContO(var1[var2], 0, 0, 0, 0);
         }

         this.fix[var2] = -1;
         this.dest[var2] = -1;
         this.cntdest[var2] = 0;
      }

      for (int var5 = 0; var5 < 6; var5++) {
         for (int var3 = 0; var3 < 8; var3++) {
            this.car[var5][var3] = new ContO(var1[var3], 0, 0, 0, 0);
            this.squash[var5][var3] = 0;
         }
      }

      for (int var6 = 0; var6 < 8; var6++) {
         this.nr[var6] = 0;

         for (int var7 = 0; var7 < 200; var7++) {
            this.rspark[var6][var7] = -1;
         }

         for (int var8 = 0; var8 < 20; var8++) {
            this.ns[var6][var8] = 0;

            for (int var4 = 0; var4 < 30; var4++) {
               this.sspark[var6][var8][var4] = -1;
            }
         }

         for (int var9 = 0; var9 < 4; var9++) {
            this.nry[var6][var9] = 0;
            this.nrx[var6][var9] = 0;
            this.nrz[var6][var9] = 0;

            for (int var10 = 0; var10 < 7; var10++) {
               this.ry[var6][var9][var10] = -1;
               this.rx[var6][var9][var10] = -1;
               this.rz[var6][var9][var10] = -1;
            }
         }
      }

      this.prepit = false;
   }

   public void cotchinow(int var1) {
      if (this.caught >= 300) {
         this.wasted = var1;

         for (int var2 = 0; var2 < 8; var2++) {
            this.starcar[var2] = new ContO(this.car[0][var2], 0, 0, 0, 0);
            this.hsquash[var2] = this.squash[0][var2];
            this.hfix[var2] = this.fix[var2];
            this.hdest[var2] = this.dest[var2];
         }

         for (int var5 = 0; var5 < 300; var5++) {
            for (int var3 = 0; var3 < 8; var3++) {
               this.hx[var5][var3] = this.x[var5][var3];
               this.hy[var5][var3] = this.y[var5][var3];
               this.hz[var5][var3] = this.z[var5][var3];
               this.hxy[var5][var3] = this.xy[var5][var3];
               this.hzy[var5][var3] = this.zy[var5][var3];
               this.hxz[var5][var3] = this.xz[var5][var3];
               this.hwxz[var5][var3] = this.wxz[var5][var3];
               this.hwzy[var5][var3] = this.wzy[var5][var3];
            }

            this.hcheckpoint[var5] = this.checkpoint[var5];
            this.hlastcheck[var5] = this.lastcheck[var5];
         }

         for (int var6 = 0; var6 < 8; var6++) {
            for (int var9 = 0; var9 < 20; var9++) {
               for (int var4 = 0; var4 < 30; var4++) {
                  this.hsspark[var6][var9][var4] = this.sspark[var6][var9][var4];
                  this.hsx[var6][var9][var4] = this.sx[var6][var9][var4];
                  this.hsy[var6][var9][var4] = this.sy[var6][var9][var4];
                  this.hsz[var6][var9][var4] = this.sz[var6][var9][var4];
                  this.hsmag[var6][var9][var4] = this.smag[var6][var9][var4];
                  this.hscx[var6][var9][var4] = this.scx[var6][var9][var4];
                  this.hscz[var6][var9][var4] = this.scz[var6][var9][var4];
               }
            }

            for (int var10 = 0; var10 < 200; var10++) {
               this.hrspark[var6][var10] = this.rspark[var6][var10];
               this.hsprk[var6][var10] = this.sprk[var6][var10];
               this.hsrx[var6][var10] = this.srx[var6][var10];
               this.hsry[var6][var10] = this.sry[var6][var10];
               this.hsrz[var6][var10] = this.srz[var6][var10];
               this.hrcx[var6][var10] = this.rcx[var6][var10];
               this.hrcy[var6][var10] = this.rcy[var6][var10];
               this.hrcz[var6][var10] = this.rcz[var6][var10];
            }
         }

         for (int var7 = 0; var7 < 8; var7++) {
            for (int var11 = 0; var11 < 4; var11++) {
               for (int var13 = 0; var13 < 7; var13++) {
                  this.hry[var7][var11][var13] = this.ry[var7][var11][var13];
                  this.hmagy[var7][var11][var13] = this.magy[var7][var11][var13];
                  this.hrx[var7][var11][var13] = this.rx[var7][var11][var13];
                  this.hmagx[var7][var11][var13] = this.magx[var7][var11][var13];
                  this.hrz[var7][var11][var13] = this.rz[var7][var11][var13];
                  this.hmagz[var7][var11][var13] = this.magz[var7][var11][var13];
               }
            }
         }

         for (int var8 = 0; var8 < 8; var8++) {
            for (int var12 = 0; var12 < 7; var12++) {
               this.hmtouch[var8][var12] = this.mtouch[var8][var12];
            }
         }

         this.hcaught = true;
      }
   }

   public void rec(ContO var1, int var2, int var3, int var4, int var5, int var6) {
      if (var2 == var6) {
         this.caught++;
      }

      if (this.cntf == 50) {
         for (int var7 = 0; var7 < 5; var7++) {
            this.car[var7][var2] = new ContO(this.car[var7 + 1][var2], 0, 0, 0, 0);
            this.squash[var7][var2] = this.squash[var7 + 1][var2];
         }

         this.car[5][var2] = new ContO(var1, 0, 0, 0, 0);
         this.squash[5][var2] = var3;
         this.cntf = 0;
      } else {
         this.cntf++;
      }

      this.fix[var2]--;
      if (var5 != 0) {
         this.dest[var2]--;
      }

      if (this.dest[var2] == 230) {
         if (var2 == var6) {
            this.cotchinow(var6);
            this.whenwasted = 229;
         } else if (var4 != 0) {
            this.cotchinow(var2);
            this.whenwasted = 165 + var4;
         }
      }

      for (int var9 = 0; var9 < 299; var9++) {
         this.x[var9][var2] = this.x[var9 + 1][var2];
         this.y[var9][var2] = this.y[var9 + 1][var2];
         this.z[var9][var2] = this.z[var9 + 1][var2];
         this.zy[var9][var2] = this.zy[var9 + 1][var2];
         this.xy[var9][var2] = this.xy[var9 + 1][var2];
         this.xz[var9][var2] = this.xz[var9 + 1][var2];
         this.wxz[var9][var2] = this.wxz[var9 + 1][var2];
         this.wzy[var9][var2] = this.wzy[var9 + 1][var2];
      }

      this.x[299][var2] = var1.x;
      this.y[299][var2] = var1.y;
      this.z[299][var2] = var1.z;
      this.xy[299][var2] = var1.xy;
      this.zy[299][var2] = var1.zy;
      this.xz[299][var2] = var1.xz;
      this.wxz[299][var2] = var1.wxz;
      this.wzy[299][var2] = var1.wzy;
      if (var2 == var6) {
         for (int var10 = 0; var10 < 299; var10++) {
            this.checkpoint[var10] = this.checkpoint[var10 + 1];
            this.lastcheck[var10] = this.lastcheck[var10 + 1];
         }

         this.checkpoint[299] = var1.m.checkpoint;
         this.lastcheck[299] = var1.m.lastcheck;
      }

      for (int var11 = 0; var11 < 20; var11++) {
         if (var1.stg[var11] == 1) {
            this.sspark[var2][var11][this.ns[var2][var11]] = 300;
            this.sx[var2][var11][this.ns[var2][var11]] = var1.sx[var11];
            this.sy[var2][var11][this.ns[var2][var11]] = var1.sy[var11];
            this.sz[var2][var11][this.ns[var2][var11]] = var1.sz[var11];
            this.smag[var2][var11][this.ns[var2][var11]] = var1.osmag[var11];
            this.scx[var2][var11][this.ns[var2][var11]] = var1.scx[var11];
            this.scz[var2][var11][this.ns[var2][var11]] = var1.scz[var11];
            this.ns[var2][var11]++;
            if (this.ns[var2][var11] == 30) {
               this.ns[var2][var11] = 0;
            }
         }

         for (int var8 = 0; var8 < 30; var8++) {
            this.sspark[var2][var11][var8]--;
         }
      }

      if (var1.sprk != 0) {
         this.rspark[var2][this.nr[var2]] = 300;
         this.sprk[var2][this.nr[var2]] = var1.sprk;
         this.srx[var2][this.nr[var2]] = var1.srx;
         this.sry[var2][this.nr[var2]] = var1.sry;
         this.srz[var2][this.nr[var2]] = var1.srz;
         this.rcx[var2][this.nr[var2]] = var1.rcx;
         this.rcy[var2][this.nr[var2]] = var1.rcy;
         this.rcz[var2][this.nr[var2]] = var1.rcz;
         this.nr[var2]++;
         if (this.nr[var2] == 200) {
            this.nr[var2] = 0;
         }
      }

      for (int var12 = 0; var12 < 200; var12++) {
         this.rspark[var2][var12]--;
      }

      for (int var13 = 0; var13 < 4; var13++) {
         for (int var14 = 0; var14 < 7; var14++) {
            this.ry[var2][var13][var14]--;
            this.rx[var2][var13][var14]--;
            this.rz[var2][var13][var14]--;
         }
      }
   }

   public void play(ContO var1, Mad var2, int var3, int var4) {
      var1.x = this.x[var4][var3];
      var1.y = this.y[var4][var3];
      var1.z = this.z[var4][var3];
      var1.zy = this.zy[var4][var3];
      var1.xy = this.xy[var4][var3];
      var1.xz = this.xz[var4][var3];
      var1.wxz = this.wxz[var4][var3];
      var1.wzy = this.wzy[var4][var3];
      if (var3 == 0) {
         var1.m.checkpoint = this.checkpoint[var4];
         var1.m.lastcheck = this.lastcheck[var4];
      }

      if (var4 == 0) {
         this.cntdest[var3] = 0;
      }

      if (this.dest[var3] == var4) {
         this.cntdest[var3] = 7;
      }

      if (var4 == 0 && this.dest[var3] < -1) {
         for (int var5 = 0; var5 < var1.npl; var5++) {
            if (var1.p[var5].wz == 0 || var1.p[var5].gr == -17 || var1.p[var5].gr == -16) {
               var1.p[var5].embos = 13;
            }
         }
      }

      if (this.cntdest[var3] != 0) {
         for (int var7 = 0; var7 < var1.npl; var7++) {
            if (var1.p[var7].wz == 0 || var1.p[var7].gr == -17 || var1.p[var7].gr == -16) {
               var1.p[var7].embos = 1;
            }
         }

         this.cntdest[var3]--;
      }

      for (int var8 = 0; var8 < 20; var8++) {
         for (int var6 = 0; var6 < 30; var6++) {
            if (this.sspark[var3][var8][var6] == var4) {
               var1.stg[var8] = 1;
               var1.sx[var8] = this.sx[var3][var8][var6];
               var1.sy[var8] = this.sy[var3][var8][var6];
               var1.sz[var8] = this.sz[var3][var8][var6];
               var1.osmag[var8] = this.smag[var3][var8][var6];
               var1.scx[var8] = this.scx[var3][var8][var6];
               var1.scz[var8] = this.scz[var3][var8][var6];
            }
         }
      }

      for (int var9 = 0; var9 < 200; var9++) {
         if (this.rspark[var3][var9] == var4) {
            var1.sprk = this.sprk[var3][var9];
            var1.srx = this.srx[var3][var9];
            var1.sry = this.sry[var3][var9];
            var1.srz = this.srz[var3][var9];
            var1.rcx = this.rcx[var3][var9];
            var1.rcy = this.rcy[var3][var9];
            var1.rcz = this.rcz[var3][var9];
         }
      }

      for (int var10 = 0; var10 < 4; var10++) {
         for (int var11 = 0; var11 < 7; var11++) {
            if (this.ry[var3][var10][var11] == var4) {
               this.regy(var10, this.magy[var3][var10][var11], this.mtouch[var3][var11], var1, var2);
            }

            if (this.rx[var3][var10][var11] == var4) {
               this.regx(var10, this.magx[var3][var10][var11], var1, var2);
            }

            if (this.rz[var3][var10][var11] == var4) {
               this.regz(var10, this.magz[var3][var10][var11], var1, var2);
            }
         }
      }
   }

   public void playh(ContO var1, Mad var2, int var3, int var4, int var5) {
      var1.x = this.hx[var4][var3];
      var1.y = this.hy[var4][var3];
      var1.z = this.hz[var4][var3];
      var1.zy = this.hzy[var4][var3];
      var1.xy = this.hxy[var4][var3];
      var1.xz = this.hxz[var4][var3];
      var1.wxz = this.hwxz[var4][var3];
      var1.wzy = this.hwzy[var4][var3];
      if (var3 == var5) {
         var1.m.checkpoint = this.hcheckpoint[var4];
         var1.m.lastcheck = this.hlastcheck[var4];
      }

      if (var4 == 0) {
         this.cntdest[var3] = 0;
      }

      if (this.hdest[var3] == var4) {
         this.cntdest[var3] = 7;
      }

      if (var4 == 0 && this.hdest[var3] < -1) {
         for (int var6 = 0; var6 < var1.npl; var6++) {
            if (var1.p[var6].wz == 0 || var1.p[var6].gr == -17 || var1.p[var6].gr == -16) {
               var1.p[var6].embos = 13;
            }
         }
      }

      if (this.cntdest[var3] != 0) {
         for (int var8 = 0; var8 < var1.npl; var8++) {
            if (var1.p[var8].wz == 0 || var1.p[var8].gr == -17 || var1.p[var8].gr == -16) {
               var1.p[var8].embos = 1;
            }
         }

         this.cntdest[var3]--;
      }

      for (int var9 = 0; var9 < 20; var9++) {
         for (int var7 = 0; var7 < 30; var7++) {
            if (this.hsspark[var3][var9][var7] == var4) {
               var1.stg[var9] = 1;
               var1.sx[var9] = this.hsx[var3][var9][var7];
               var1.sy[var9] = this.hsy[var3][var9][var7];
               var1.sz[var9] = this.hsz[var3][var9][var7];
               var1.osmag[var9] = this.hsmag[var3][var9][var7];
               var1.scx[var9] = this.hscx[var3][var9][var7];
               var1.scz[var9] = this.hscz[var3][var9][var7];
            }
         }
      }

      for (int var10 = 0; var10 < 200; var10++) {
         if (this.hrspark[var3][var10] == var4) {
            var1.sprk = this.hsprk[var3][var10];
            var1.srx = this.hsrx[var3][var10];
            var1.sry = this.hsry[var3][var10];
            var1.srz = this.hsrz[var3][var10];
            var1.rcx = this.hrcx[var3][var10];
            var1.rcy = this.hrcy[var3][var10];
            var1.rcz = this.hrcz[var3][var10];
         }
      }

      for (int var11 = 0; var11 < 4; var11++) {
         for (int var12 = 0; var12 < 7; var12++) {
            if (this.hry[var3][var11][var12] == var4 && this.lastfr != var4) {
               this.regy(var11, this.hmagy[var3][var11][var12], this.hmtouch[var3][var12], var1, var2);
            }

            if (this.hrx[var3][var11][var12] == var4) {
               if (this.lastfr != var4) {
                  this.regx(var11, this.hmagx[var3][var11][var12], var1, var2);
               } else {
                  this.chipx(var11, this.hmagx[var3][var11][var12], var1, var2);
               }
            }

            if (this.hrz[var3][var11][var12] == var4) {
               if (this.lastfr != var4) {
                  this.regz(var11, this.hmagz[var3][var11][var12], var1, var2);
               } else {
                  this.chipz(var11, this.hmagz[var3][var11][var12], var1, var2);
               }
            }
         }
      }

      this.lastfr = var4;
   }

   public void recy(int var1, float var2, boolean var3, int var4) {
      this.ry[var4][var1][this.nry[var4][var1]] = 300;
      this.magy[var4][var1][this.nry[var4][var1]] = (int)var2;
      this.mtouch[var4][this.nry[var4][var1]] = var3;
      this.nry[var4][var1]++;
      if (this.nry[var4][var1] == 7) {
         this.nry[var4][var1] = 0;
      }
   }

   public void recx(int var1, float var2, int var3) {
      this.rx[var3][var1][this.nry[var3][var1]] = 300;
      this.magx[var3][var1][this.nry[var3][var1]] = (int)var2;
      this.nrx[var3][var1]++;
      if (this.nrx[var3][var1] == 7) {
         this.nrx[var3][var1] = 0;
      }
   }

   public void recz(int var1, float var2, int var3) {
      this.rz[var3][var1][this.nry[var3][var1]] = 300;
      this.magz[var3][var1][this.nry[var3][var1]] = (int)var2;
      this.nrz[var3][var1]++;
      if (this.nrz[var3][var1] == 7) {
         this.nrz[var3][var1] = 0;
      }
   }

   public void regy(int var1, float var2, boolean var3, ContO var4, Mad var5) {
      if (var2 > 100.0F) {
         var2 -= 100.0F;
         byte var6 = 0;
         byte var7 = 0;
         int var8 = var4.zy;
         int var9 = var4.xy;

         while (var8 < 360) {
            var8 += 360;
         }

         while (var8 > 360) {
            var8 -= 360;
         }

         if (var8 < 210 && var8 > 150) {
            var6 = -1;
         }

         if (var8 > 330 || var8 < 30) {
            var6 = 1;
         }

         while (var9 < 360) {
            var9 += 360;
         }

         while (var9 > 360) {
            var9 -= 360;
         }

         if (var9 < 210 && var9 > 150) {
            var7 = -1;
         }

         if (var9 > 330 || var9 < 30) {
            var7 = 1;
         }

         if (var7 * var6 == 0 || var3) {
            for (int var10 = 0; var10 < var4.npl; var10++) {
               float var11 = 0.0F;

               for (int var12 = 0; var12 < var4.p[var10].n; var12++) {
                  if (var4.p[var10].wz == 0
                     && this.py(var4.keyx[var1], var4.p[var10].ox[var12], var4.keyz[var1], var4.p[var10].oz[var12]) < var5.cd.clrad[var5.cn]) {
                     var11 = var2 / 20.0F * this.m.random();
                     var4.p[var10].oz[var12] = (int)(var4.p[var10].oz[var12] + var11 * this.m.sin(var8));
                     var4.p[var10].ox[var12] = (int)(var4.p[var10].ox[var12] - var11 * this.m.sin(var9));
                  }
               }

               if (var11 != 0.0F) {
                  if (Math.abs(var11) >= 1.0F) {
                     var4.p[var10].chip = 1;
                     var4.p[var10].ctmag = var11;
                  }

                  if (!var4.p[var10].nocol && var4.p[var10].glass != 1) {
                     if (var4.p[var10].bfase > 20 && var4.p[var10].hsb[1] > 0.2) {
                        var4.p[var10].hsb[1] = 0.2F;
                     }

                     if (var4.p[var10].bfase > 30) {
                        if (var4.p[var10].hsb[2] < 0.5) {
                           var4.p[var10].hsb[2] = 0.5F;
                        }

                        if (var4.p[var10].hsb[1] > 0.1) {
                           var4.p[var10].hsb[1] = 0.1F;
                        }
                     }

                     if (var4.p[var10].bfase > 40) {
                        var4.p[var10].hsb[1] = 0.05F;
                     }

                     if (var4.p[var10].bfase > 50) {
                        if (var4.p[var10].hsb[2] > 0.8) {
                           var4.p[var10].hsb[2] = 0.8F;
                        }

                        var4.p[var10].hsb[0] = 0.075F;
                        var4.p[var10].hsb[1] = 0.05F;
                     }

                     if (var4.p[var10].bfase > 60) {
                        var4.p[var10].hsb[0] = 0.05F;
                     }

                     var4.p[var10].bfase = (int)(var4.p[var10].bfase + var11);
                     new Color(var4.p[var10].c[0], var4.p[var10].c[1], var4.p[var10].c[2]);
                     Color var18 = Color.getHSBColor(var4.p[var10].hsb[0], var4.p[var10].hsb[1], var4.p[var10].hsb[2]);
                     var4.p[var10].c[0] = var18.getRed();
                     var4.p[var10].c[1] = var18.getGreen();
                     var4.p[var10].c[2] = var18.getBlue();
                  }

                  if (var4.p[var10].glass == 1) {
                     var4.p[var10].gr = (int)(var4.p[var10].gr + Math.abs(var11 * 1.5));
                  }
               }
            }
         }

         if (var7 * var6 == -1) {
            int var16 = 0;
            int var17 = 1;

            for (int var19 = 0; var19 < var4.npl; var19++) {
               float var13 = 0.0F;

               for (int var14 = 0; var14 < var4.p[var19].n; var14++) {
                  if (var4.p[var19].wz == 0) {
                     var13 = var2 / 15.0F * this.m.random();
                     if ((
                           Math.abs(var4.p[var19].oy[var14] - var5.cd.flipy[var5.cn] - this.squash[0][var5.im]) < var5.cd.msquash[var5.cn] * 3
                              || var4.p[var19].oy[var14] < var5.cd.flipy[var5.cn] + this.squash[0][var5.im]
                        )
                        && this.squash[0][var5.im] < var5.cd.msquash[var5.cn]) {
                        var4.p[var19].oy[var14] = (int)(var4.p[var19].oy[var14] + var13);
                        var16 = (int)(var16 + var13);
                        var17++;
                     }
                  }
               }

               if (var4.p[var19].glass == 1) {
                  var4.p[var19].gr += 5;
               } else if (var13 != 0.0F) {
                  var4.p[var19].bfase = (int)(var4.p[var19].bfase + var13);
               }

               if (Math.abs(var13) >= 1.0F) {
                  var4.p[var19].chip = 1;
                  var4.p[var19].ctmag = var13;
               }
            }

            this.squash[0][var5.im] = this.squash[0][var5.im] + var16 / var17;
         }
      }
   }

   public void regx(int var1, float var2, ContO var3, Mad var4) {
      if (Math.abs(var2) > 100.0F) {
         if (var2 > 100.0F) {
            var2 -= 100.0F;
         }

         if (var2 < -100.0F) {
            var2 += 100.0F;
         }

         for (int var5 = 0; var5 < var3.npl; var5++) {
            float var6 = 0.0F;

            for (int var7 = 0; var7 < var3.p[var5].n; var7++) {
               if (var3.p[var5].wz == 0 && this.py(var3.keyx[var1], var3.p[var5].ox[var7], var3.keyz[var1], var3.p[var5].oz[var7]) < var4.cd.clrad[var4.cn]) {
                  var6 = var2 / 20.0F * this.m.random();
                  var3.p[var5].oz[var7] = (int)(var3.p[var5].oz[var7] - var6 * this.m.sin(var3.xz) * this.m.cos(var3.zy));
                  var3.p[var5].ox[var7] = (int)(var3.p[var5].ox[var7] + var6 * this.m.cos(var3.xz) * this.m.cos(var3.xy));
               }
            }

            if (var6 != 0.0F) {
               if (Math.abs(var6) >= 1.0F) {
                  var3.p[var5].chip = 1;
                  var3.p[var5].ctmag = var6;
               }

               if (!var3.p[var5].nocol && var3.p[var5].glass != 1) {
                  if (var3.p[var5].bfase > 20 && var3.p[var5].hsb[1] > 0.2) {
                     var3.p[var5].hsb[1] = 0.2F;
                  }

                  if (var3.p[var5].bfase > 30) {
                     if (var3.p[var5].hsb[2] < 0.5) {
                        var3.p[var5].hsb[2] = 0.5F;
                     }

                     if (var3.p[var5].hsb[1] > 0.1) {
                        var3.p[var5].hsb[1] = 0.1F;
                     }
                  }

                  if (var3.p[var5].bfase > 40) {
                     var3.p[var5].hsb[1] = 0.05F;
                  }

                  if (var3.p[var5].bfase > 50) {
                     if (var3.p[var5].hsb[2] > 0.8) {
                        var3.p[var5].hsb[2] = 0.8F;
                     }

                     var3.p[var5].hsb[0] = 0.075F;
                     var3.p[var5].hsb[1] = 0.05F;
                  }

                  if (var3.p[var5].bfase > 60) {
                     var3.p[var5].hsb[0] = 0.05F;
                  }

                  var3.p[var5].bfase = (int)(var3.p[var5].bfase + Math.abs(var6));
                  new Color(var3.p[var5].c[0], var3.p[var5].c[1], var3.p[var5].c[2]);
                  Color var8 = Color.getHSBColor(var3.p[var5].hsb[0], var3.p[var5].hsb[1], var3.p[var5].hsb[2]);
                  var3.p[var5].c[0] = var8.getRed();
                  var3.p[var5].c[1] = var8.getGreen();
                  var3.p[var5].c[2] = var8.getBlue();
               }

               if (var3.p[var5].glass == 1) {
                  var3.p[var5].gr = (int)(var3.p[var5].gr + Math.abs(var6 * 1.5));
               }
            }
         }
      }
   }

   public void regz(int var1, float var2, ContO var3, Mad var4) {
      if (Math.abs(var2) > 100.0F) {
         if (var2 > 100.0F) {
            var2 -= 100.0F;
         }

         if (var2 < -100.0F) {
            var2 += 100.0F;
         }

         for (int var5 = 0; var5 < var3.npl; var5++) {
            float var6 = 0.0F;

            for (int var7 = 0; var7 < var3.p[var5].n; var7++) {
               if (var3.p[var5].wz == 0 && this.py(var3.keyx[var1], var3.p[var5].ox[var7], var3.keyz[var1], var3.p[var5].oz[var7]) < var4.cd.clrad[var4.cn]) {
                  var6 = var2 / 20.0F * this.m.random();
                  var3.p[var5].oz[var7] = (int)(var3.p[var5].oz[var7] + var6 * this.m.cos(var3.xz) * this.m.cos(var3.zy));
                  var3.p[var5].ox[var7] = (int)(var3.p[var5].ox[var7] + var6 * this.m.sin(var3.xz) * this.m.cos(var3.xy));
               }
            }

            if (var6 != 0.0F) {
               if (Math.abs(var6) >= 1.0F) {
                  var3.p[var5].chip = 1;
                  var3.p[var5].ctmag = var6;
               }

               if (!var3.p[var5].nocol && var3.p[var5].glass != 1) {
                  if (var3.p[var5].bfase > 20 && var3.p[var5].hsb[1] > 0.2) {
                     var3.p[var5].hsb[1] = 0.2F;
                  }

                  if (var3.p[var5].bfase > 30) {
                     if (var3.p[var5].hsb[2] < 0.5) {
                        var3.p[var5].hsb[2] = 0.5F;
                     }

                     if (var3.p[var5].hsb[1] > 0.1) {
                        var3.p[var5].hsb[1] = 0.1F;
                     }
                  }

                  if (var3.p[var5].bfase > 40) {
                     var3.p[var5].hsb[1] = 0.05F;
                  }

                  if (var3.p[var5].bfase > 50) {
                     if (var3.p[var5].hsb[2] > 0.8) {
                        var3.p[var5].hsb[2] = 0.8F;
                     }

                     var3.p[var5].hsb[0] = 0.075F;
                     var3.p[var5].hsb[1] = 0.05F;
                  }

                  if (var3.p[var5].bfase > 60) {
                     var3.p[var5].hsb[0] = 0.05F;
                  }

                  var3.p[var5].bfase = (int)(var3.p[var5].bfase + Math.abs(var6));
                  new Color(var3.p[var5].c[0], var3.p[var5].c[1], var3.p[var5].c[2]);
                  Color var8 = Color.getHSBColor(var3.p[var5].hsb[0], var3.p[var5].hsb[1], var3.p[var5].hsb[2]);
                  var3.p[var5].c[0] = var8.getRed();
                  var3.p[var5].c[1] = var8.getGreen();
                  var3.p[var5].c[2] = var8.getBlue();
               }

               if (var3.p[var5].glass == 1) {
                  var3.p[var5].gr = (int)(var3.p[var5].gr + Math.abs(var6 * 1.5));
               }
            }
         }
      }
   }

   public void chipx(int var1, float var2, ContO var3, Mad var4) {
      if (Math.abs(var2) > 100.0F) {
         if (var2 > 100.0F) {
            var2 -= 100.0F;
         }

         if (var2 < -100.0F) {
            var2 += 100.0F;
         }

         for (int var5 = 0; var5 < var3.npl; var5++) {
            float var6 = 0.0F;

            for (int var7 = 0; var7 < var3.p[var5].n; var7++) {
               if (var3.p[var5].wz == 0 && this.py(var3.keyx[var1], var3.p[var5].ox[var7], var3.keyz[var1], var3.p[var5].oz[var7]) < var4.cd.clrad[var4.cn]) {
                  var6 = var2 / 20.0F * this.m.random();
               }
            }

            if (var6 != 0.0F && Math.abs(var6) >= 1.0F) {
               var3.p[var5].chip = 1;
               var3.p[var5].ctmag = var6;
            }
         }
      }
   }

   public void chipz(int var1, float var2, ContO var3, Mad var4) {
      if (Math.abs(var2) > 100.0F) {
         if (var2 > 100.0F) {
            var2 -= 100.0F;
         }

         if (var2 < -100.0F) {
            var2 += 100.0F;
         }

         for (int var5 = 0; var5 < var3.npl; var5++) {
            float var6 = 0.0F;

            for (int var7 = 0; var7 < var3.p[var5].n; var7++) {
               if (var3.p[var5].wz == 0 && this.py(var3.keyx[var1], var3.p[var5].ox[var7], var3.keyz[var1], var3.p[var5].oz[var7]) < var4.cd.clrad[var4.cn]) {
                  var6 = var2 / 20.0F * this.m.random();
               }
            }

            if (var6 != 0.0F && Math.abs(var6) >= 1.0F) {
               var3.p[var5].chip = 1;
               var3.p[var5].ctmag = var6;
            }
         }
      }
   }

   public int py(int var1, int var2, int var3, int var4) {
      return (var1 - var2) * (var1 - var2) + (var3 - var4) * (var3 - var4);
   }
}
