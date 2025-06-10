public class Trackers {
   int[] x = new int[6700];
   int[] y = new int[6700];
   int[] z = new int[6700];
   int[] xy = new int[6700];
   int[] zy = new int[6700];
   int[] skd = new int[6700];
   int[] dam = new int[6700];
   boolean[] notwall = new boolean[6700];
   boolean[] decor = new boolean[6700];
   int[][] c = new int[6700][3];
   int[] radx = new int[6700];
   int[] radz = new int[6700];
   int[] rady = new int[6700];
   int nt = 0;
   int sx = 0;
   int sz = 0;
   int ncx = 0;
   int ncz = 0;
   int[][][] sect = (int[][][])null;

   public void devidetrackers(int var1, int var2, int var3, int var4) {
      this.sect = (int[][][])null;
      this.sx = var1;
      this.sz = var3;
      this.ncx = var2 / 3000;
      if (this.ncx <= 0) {
         this.ncx = 1;
      }

      this.ncz = var4 / 3000;
      if (this.ncz <= 0) {
         this.ncz = 1;
      }

      this.sect = new int[this.ncx][this.ncz][];

      for (int var5 = 0; var5 < this.ncx; var5++) {
         for (int var6 = 0; var6 < this.ncz; var6++) {
            int var7 = this.sx + var5 * 3000 + 1500;
            int var8 = this.sz + var6 * 3000 + 1500;
            int[] var9 = new int[6700];
            int var10 = 0;

            for (int var11 = 0; var11 < this.nt; var11++) {
               int var12 = this.py(var7, this.x[var11], var8, this.z[var11]);
               if (var12 < 20250000 && var12 > 0 && this.dam[var11] != 167) {
                  var9[var10] = var11;
                  var10++;
               }
            }

            if (var5 == 0 || var6 == 0 || var5 == this.ncx - 1 || var6 == this.ncz - 1) {
               for (int var14 = 0; var14 < this.nt; var14++) {
                  if (this.dam[var14] == 167) {
                     var9[var10] = var14;
                     var10++;
                  }
               }
            }

            if (var10 == 0) {
               var9[var10] = 0;
               var10++;
            }

            this.sect[var5][var6] = new int[var10];

            for (int var15 = 0; var15 < var10; var15++) {
               this.sect[var5][var6][var15] = var9[var15];
            }
         }
      }

      for (int var13 = 0; var13 < this.nt; var13++) {
         if (this.dam[var13] == 167) {
            this.dam[var13] = 1;
         }
      }

      this.ncx--;
      this.ncz--;
   }

   public int py(int var1, int var2, int var3, int var4) {
      return (var1 - var2) * (var1 - var2) + (var3 - var4) * (var3 - var4);
   }
}
