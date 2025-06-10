public class CheckPoints {
   int[] x = new int[140];
   int[] z = new int[140];
   int[] y = new int[140];
   int[] typ = new int[140];
   int pcs = 0;
   int nsp = 0;
   int n = 0;
   int[] fx = new int[5];
   int[] fz = new int[5];
   int[] fy = new int[5];
   boolean[] roted = new boolean[5];
   boolean[] special = new boolean[5];
   int fn = 0;
   int stage = (int)(Math.random() * 27.0) + 1;
   int nlaps = 0;
   int nfix = 0;
   boolean notb = false;
   String name = "hogan rewish";
   String maker = "";
   int pubt = 0;
   String trackname = "";
   int trackvol = 200;
   int top20 = 0;
   int nto = 0;
   int[] pos = new int[]{7, 7, 7, 7, 7, 7, 7, 7};
   int[] clear = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
   int[] dested = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
   float[] magperc = new float[]{0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F};
   int wasted = 0;
   boolean haltall = false;
   int pcleared = 0;
   int[] opx = new int[8];
   int[] opz = new int[8];
   int[] onscreen = new int[8];
   int[] omxz = new int[8];
   int catchfin = 0;
   int postwo = 0;
   float prox = 0.0F;

   public void checkstat(Mad[] var1, ContO[] var2, Record var3, int var4, int var5, int var6) {
      if (!this.haltall) {
         this.pcleared = var1[var5].pcleared;

         for (int var7 = 0; var7 < var4; var7++) {
            this.magperc[var7] = (float)var1[var7].hitmag / var1[var7].cd.maxmag[var1[var7].cn];
            if (this.magperc[var7] > 1.0F) {
               this.magperc[var7] = 1.0F;
            }

            this.pos[var7] = 0;
            this.onscreen[var7] = var2[var7].dist;
            this.opx[var7] = var2[var7].x;
            this.opz[var7] = var2[var7].z;
            this.omxz[var7] = var1[var7].mxz;
            if (this.dested[var7] == 0) {
               this.clear[var7] = var1[var7].clear;
            } else {
               this.clear[var7] = -1;
            }

            var1[var7].outshakedam = var1[var7].shakedam;
            var1[var7].shakedam = 0;
         }

         for (int var10 = 0; var10 < var4; var10++) {
            for (int var8 = var10 + 1; var8 < var4; var8++) {
               if (this.clear[var10] != this.clear[var8]) {
                  if (this.clear[var10] < this.clear[var8]) {
                     this.pos[var10]++;
                  } else {
                     this.pos[var8]++;
                  }
               } else {
                  int var9 = var1[var10].pcleared + 1;
                  if (var9 >= this.n) {
                     var9 = 0;
                  }

                  while (this.typ[var9] <= 0) {
                     if (++var9 >= this.n) {
                        var9 = 0;
                     }
                  }

                  if (this.py(var2[var10].x / 100, this.x[var9] / 100, var2[var10].z / 100, this.z[var9] / 100)
                     > this.py(var2[var8].x / 100, this.x[var9] / 100, var2[var8].z / 100, this.z[var9] / 100)) {
                     this.pos[var10]++;
                  } else {
                     this.pos[var8]++;
                  }
               }
            }
         }

         if (this.stage > 2) {
            for (int var11 = 0; var11 < var4; var11++) {
               if (this.clear[var11] == this.nlaps * this.nsp && this.pos[var11] == 0) {
                  if (var11 != var5) {
                     if (this.pos[var5] == 1
                        && this.py(this.opx[var5] / 100, this.opx[var11] / 100, this.opz[var5] / 100, this.opz[var11] / 100) < 14000
                        && this.clear[var11] - this.clear[var5] == 1) {
                        this.catchfin = 30;
                        this.postwo = var11;
                     }
                  } else {
                     for (int var13 = 0; var13 < var4; var13++) {
                        if (this.pos[var13] == 1) {
                           this.postwo = var13;
                        }
                     }

                     if (this.py(this.opx[var5] / 100, this.opx[this.postwo] / 100, this.opz[var5] / 100, this.opz[this.postwo] / 100) < 14000
                        && this.clear[var5] - this.clear[this.postwo] == 1) {
                        this.catchfin = 30;
                     }
                  }
               }
            }
         }
      }

      this.wasted = 0;

      for (int var12 = 0; var12 < var4; var12++) {
         if ((var5 != var12 || var6 >= 2) && var1[var12].dest) {
            this.wasted++;
         }
      }

      if (this.catchfin != 0 && var6 < 2) {
         this.catchfin--;
         if (this.catchfin == 0) {
            var3.cotchinow(this.postwo);
            var3.closefinish = this.pos[var5] + 1;
         }
      }
   }

   public void calprox() {
      int var1 = 0;

      for (int var2 = 0; var2 < this.n - 1; var2++) {
         for (int var3 = var2 + 1; var3 < this.n; var3++) {
            if (Math.abs(this.x[var2] - this.x[var3]) > var1) {
               var1 = Math.abs(this.x[var2] - this.x[var3]);
            }

            if (Math.abs(this.z[var2] - this.z[var3]) > var1) {
               var1 = Math.abs(this.z[var2] - this.z[var3]);
            }
         }
      }

      this.prox = var1 / 90.0F;
   }

   public int py(int var1, int var2, int var3, int var4) {
      return (var1 - var2) * (var1 - var2) + (var3 - var4) * (var3 - var4);
   }
}
