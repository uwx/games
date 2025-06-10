public class Wheels {
   int ground = 0;
   int mast = 0;
   int sparkat = 0;
   int[] rc = new int[]{120, 120, 120};
   float size = 2.0F;
   float depth = 3.0F;

   public Wheels() {
      this.sparkat = 0;
      this.ground = 0;
   }

   public void setrims(int var1, int var2, int var3, int var4, int var5) {
      this.rc[0] = var1;
      this.rc[1] = var2;
      this.rc[2] = var3;
      this.size = var4 / 10.0F;
      if (this.size < 0.0F) {
         this.size = 0.0F;
      }

      this.depth = var5 / 10.0F;
      if (this.depth / this.size > 41.0F) {
         this.depth = this.size * 41.0F;
      }

      if (this.depth / this.size < -25.0F) {
         this.depth = -(this.size * 25.0F);
      }
   }

   public void make(Medium var1, Trackers var2, Plane[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      int[] var12 = new int[20];
      int[] var13 = new int[20];
      int[] var14 = new int[20];
      int[] var15 = new int[]{45, 45, 45};
      int var16 = 0;
      float var17 = var9 / 10.0F;
      float var18 = var10 / 10.0F;
      if (var8 == 11) {
         var16 = (int)(var5 + 4.0F * var17);
      }

      this.sparkat = (int)(var18 * 24.0F);
      this.ground = (int)(var6 + 13.0F * var18);
      byte var19 = -1;
      if (var5 < 0) {
         var19 = 1;
      }

      for (int var20 = 0; var20 < 20; var20++) {
         var12[var20] = (int)(var5 - 4.0F * var17);
      }

      var13[0] = (int)(var6 - 9.1923F * var18);
      var14[0] = (int)(var7 + 9.1923F * var18);
      var13[1] = (int)(var6 - 12.557F * var18);
      var14[1] = (int)(var7 + 3.3646F * var18);
      var13[2] = (int)(var6 - 12.557F * var18);
      var14[2] = (int)(var7 - 3.3646F * var18);
      var13[3] = (int)(var6 - 9.1923F * var18);
      var14[3] = (int)(var7 - 9.1923F * var18);
      var13[4] = (int)(var6 - 3.3646F * var18);
      var14[4] = (int)(var7 - 12.557F * var18);
      var13[5] = (int)(var6 + 3.3646F * var18);
      var14[5] = (int)(var7 - 12.557F * var18);
      var13[6] = (int)(var6 + 9.1923F * var18);
      var14[6] = (int)(var7 - 9.1923F * var18);
      var13[7] = (int)(var6 + 12.557F * var18);
      var14[7] = (int)(var7 - 3.3646F * var18);
      var13[8] = (int)(var6 + 12.557F * var18);
      var14[8] = (int)(var7 + 3.3646F * var18);
      var13[9] = (int)(var6 + 9.1923F * var18);
      var14[9] = (int)(var7 + 9.1923F * var18);
      var13[10] = (int)(var6 + 3.3646F * var18);
      var14[10] = (int)(var7 + 12.557F * var18);
      var13[11] = (int)(var6 - 3.3646F * var18);
      var14[11] = (int)(var7 + 12.557F * var18);
      var13[12] = var6;
      var14[12] = (int)(var7 + 10.0F * this.size);
      var13[13] = (int)(var6 + 8.66 * this.size);
      var14[13] = (int)(var7 + 5.0F * this.size);
      var13[14] = (int)(var6 + 8.66 * this.size);
      var14[14] = (int)(var7 - 5.0F * this.size);
      var13[15] = var6;
      var14[15] = (int)(var7 - 10.0F * this.size);
      var13[16] = (int)(var6 - 8.66 * this.size);
      var14[16] = (int)(var7 - 5.0F * this.size);
      var13[17] = (int)(var6 - 8.66 * this.size);
      var14[17] = (int)(var7 + 5.0F * this.size);
      var13[18] = var6;
      var14[18] = (int)(var7 + 10.0F * this.size);
      var13[19] = (int)(var6 - 3.3646F * var18);
      var14[19] = (int)(var7 + 12.557F * var18);
      var3[var4] = new Plane(var1, var2, var12, var14, var13, 20, var15, 0, var11, 0, var16, var6, var7, 7, 0, false, 0, false);
      var3[var4].master = 1;
      var4++;
      var12[2] = (int)(var5 - this.depth * var17);
      var13[2] = var6;
      var14[2] = var7;
      int var40 = (int)(var11 - this.depth / this.size * 4.0F);
      if (var40 < -16) {
         var40 = -16;
      }

      var13[0] = var6;
      var14[0] = (int)(var7 + 10.0F * this.size);
      var13[1] = (int)(var6 + 8.66 * this.size);
      var14[1] = (int)(var7 + 5.0F * this.size);
      var3[var4] = new Plane(var1, var2, var12, var14, var13, 3, this.rc, 0, var40, 0, var16, var6, var7, 7, 0, false, 0, false);
      if (this.depth / this.size < 7.0F) {
         var3[var4].master = 2;
      }

      var4++;
      var13[0] = (int)(var6 + 8.66 * this.size);
      var14[0] = (int)(var7 + 5.0F * this.size);
      var13[1] = (int)(var6 + 8.66 * this.size);
      var14[1] = (int)(var7 - 5.0F * this.size);
      var3[var4] = new Plane(var1, var2, var12, var14, var13, 3, this.rc, 0, var40, 0, var16, var6, var7, 7, 0, false, 0, false);
      if (this.depth / this.size < 7.0F) {
         var3[var4].master = 2;
      }

      var4++;
      var13[0] = (int)(var6 + 8.66 * this.size);
      var14[0] = (int)(var7 - 5.0F * this.size);
      var13[1] = var6;
      var14[1] = (int)(var7 - 10.0F * this.size);
      var3[var4] = new Plane(var1, var2, var12, var14, var13, 3, this.rc, 0, var40, 0, var16, var6, var7, 7, 0, false, 0, false);
      if (this.depth / this.size < 7.0F) {
         var3[var4].master = 2;
      }

      var4++;
      var13[0] = var6;
      var14[0] = (int)(var7 - 10.0F * this.size);
      var13[1] = (int)(var6 - 8.66 * this.size);
      var14[1] = (int)(var7 - 5.0F * this.size);
      var3[var4] = new Plane(var1, var2, var12, var14, var13, 3, this.rc, 0, var40, 0, var16, var6, var7, 7, 0, false, 0, false);
      if (this.depth / this.size < 7.0F) {
         var3[var4].master = 2;
      }

      var4++;
      var13[0] = (int)(var6 - 8.66 * this.size);
      var14[0] = (int)(var7 - 5.0F * this.size);
      var13[1] = (int)(var6 - 8.66 * this.size);
      var14[1] = (int)(var7 + 5.0F * this.size);
      var3[var4] = new Plane(var1, var2, var12, var14, var13, 3, this.rc, 0, var40, 0, var16, var6, var7, 7, 0, false, 0, false);
      if (this.depth / this.size < 7.0F) {
         var3[var4].master = 2;
      }

      var4++;
      var13[0] = (int)(var6 - 8.66 * this.size);
      var14[0] = (int)(var7 + 5.0F * this.size);
      var13[1] = var6;
      var14[1] = (int)(var7 + 10.0F * this.size);
      var3[var4] = new Plane(var1, var2, var12, var14, var13, 3, this.rc, 0, var40, 0, var16, var6, var7, 7, 0, false, 0, false);
      if (this.depth / this.size < 7.0F) {
         var3[var4].master = 2;
      }

      var4++;
      var12[0] = (int)(var5 - 4.0F * var17);
      var13[0] = (int)(var6 - 12.557F * var18);
      var14[0] = (int)(var7 + 3.3646F * var18);
      var12[1] = (int)(var5 - 4.0F * var17);
      var13[1] = (int)(var6 - 12.557F * var18);
      var14[1] = (int)(var7 - 3.3646F * var18);
      var12[2] = (int)(var5 + 4.0F * var17);
      var13[2] = (int)(var6 - 12.557F * var18);
      var14[2] = (int)(var7 - 3.3646F * var18);
      var12[3] = (int)(var5 + 4.0F * var17);
      var13[3] = (int)(var6 - 12.557F * var18);
      var14[3] = (int)(var7 + 3.3646F * var18);
      var3[var4] = new Plane(var1, var2, var12, var14, var13, 4, var15, 0, var11, -1 * var19, var16, var6, var7, 7, 0, false, 0, true);
      var4++;
      var12[0] = (int)(var5 - 4.0F * var17);
      var13[0] = (int)(var6 - 9.1923F * var18);
      var14[0] = (int)(var7 - 9.1923F * var18);
      var12[1] = (int)(var5 - 4.0F * var17);
      var13[1] = (int)(var6 - 12.557F * var18);
      var14[1] = (int)(var7 - 3.3646F * var18);
      var12[2] = (int)(var5 + 4.0F * var17);
      var13[2] = (int)(var6 - 12.557F * var18);
      var14[2] = (int)(var7 - 3.3646F * var18);
      var12[3] = (int)(var5 + 4.0F * var17);
      var13[3] = (int)(var6 - 9.1923F * var18);
      var14[3] = (int)(var7 - 9.1923F * var18);
      var3[var4] = new Plane(var1, var2, var12, var14, var13, 4, var15, 0, var11, 1 * var19, var16, var6, var7, 7, 0, false, 0, true);
      var4++;
      var12[0] = (int)(var5 - 4.0F * var17);
      var13[0] = (int)(var6 - 9.1923F * var18);
      var14[0] = (int)(var7 - 9.1923F * var18);
      var12[1] = (int)(var5 - 4.0F * var17);
      var13[1] = (int)(var6 - 3.3646F * var18);
      var14[1] = (int)(var7 - 12.557F * var18);
      var12[2] = (int)(var5 + 4.0F * var17);
      var13[2] = (int)(var6 - 3.3646F * var18);
      var14[2] = (int)(var7 - 12.557F * var18);
      var12[3] = (int)(var5 + 4.0F * var17);
      var13[3] = (int)(var6 - 9.1923F * var18);
      var14[3] = (int)(var7 - 9.1923F * var18);
      var3[var4] = new Plane(var1, var2, var12, var14, var13, 4, var15, 0, var11, 1 * var19, var16, var6, var7, 7, 0, false, 0, true);
      var4++;
      var12[0] = (int)(var5 - 4.0F * var17);
      var13[0] = (int)(var6 - 3.3646F * var18);
      var14[0] = (int)(var7 - 12.557F * var18);
      var12[1] = (int)(var5 - 4.0F * var17);
      var13[1] = (int)(var6 + 3.3646F * var18);
      var14[1] = (int)(var7 - 12.557F * var18);
      var12[2] = (int)(var5 + 4.0F * var17);
      var13[2] = (int)(var6 + 3.3646F * var18);
      var14[2] = (int)(var7 - 12.557F * var18);
      var12[3] = (int)(var5 + 4.0F * var17);
      var13[3] = (int)(var6 - 3.3646F * var18);
      var14[3] = (int)(var7 - 12.557F * var18);
      var3[var4] = new Plane(var1, var2, var12, var14, var13, 4, var15, 0, var11, -1 * var19, var16, var6, var7, 7, 0, false, 0, true);
      var4++;
      var12[0] = (int)(var5 - 4.0F * var17);
      var13[0] = (int)(var6 + 9.1923F * var18);
      var14[0] = (int)(var7 - 9.1923F * var18);
      var12[1] = (int)(var5 - 4.0F * var17);
      var13[1] = (int)(var6 + 3.3646F * var18);
      var14[1] = (int)(var7 - 12.557F * var18);
      var12[2] = (int)(var5 + 4.0F * var17);
      var13[2] = (int)(var6 + 3.3646F * var18);
      var14[2] = (int)(var7 - 12.557F * var18);
      var12[3] = (int)(var5 + 4.0F * var17);
      var13[3] = (int)(var6 + 9.1923F * var18);
      var14[3] = (int)(var7 - 9.1923F * var18);
      var3[var4] = new Plane(var1, var2, var12, var14, var13, 4, var15, 0, var11, 1 * var19, var16, var6, var7, 7, 0, false, 0, true);
      var4++;
      var12[0] = (int)(var5 - 4.0F * var17);
      var13[0] = (int)(var6 + 9.1923F * var18);
      var14[0] = (int)(var7 - 9.1923F * var18);
      var12[1] = (int)(var5 - 4.0F * var17);
      var13[1] = (int)(var6 + 12.557F * var18);
      var14[1] = (int)(var7 - 3.3646F * var18);
      var12[2] = (int)(var5 + 4.0F * var17);
      var13[2] = (int)(var6 + 12.557F * var18);
      var14[2] = (int)(var7 - 3.3646F * var18);
      var12[3] = (int)(var5 + 4.0F * var17);
      var13[3] = (int)(var6 + 9.1923F * var18);
      var14[3] = (int)(var7 - 9.1923F * var18);
      var3[var4] = new Plane(var1, var2, var12, var14, var13, 4, var15, 0, var11, 1 * var19, var16, var6, var7, 7, 0, false, 0, true);
      var4++;
      var12[0] = (int)(var5 - 4.0F * var17);
      var13[0] = (int)(var6 + 12.557F * var18);
      var14[0] = (int)(var7 - 3.3646F * var18);
      var12[1] = (int)(var5 - 4.0F * var17);
      var13[1] = (int)(var6 + 12.557F * var18);
      var14[1] = (int)(var7 + 3.3646F * var18);
      var12[2] = (int)(var5 + 4.0F * var17);
      var13[2] = (int)(var6 + 12.557F * var18);
      var14[2] = (int)(var7 + 3.3646F * var18);
      var12[3] = (int)(var5 + 4.0F * var17);
      var13[3] = (int)(var6 + 12.557F * var18);
      var14[3] = (int)(var7 - 3.3646F * var18);
      var3[var4] = new Plane(var1, var2, var12, var14, var13, 4, var15, 0, var11, -1 * var19, var16, var6, var7, 7, 0, false, 0, true);
      var4++;
      var12[0] = (int)(var5 - 4.0F * var17);
      var13[0] = (int)(var6 + 9.1923F * var18);
      var14[0] = (int)(var7 + 9.1923F * var18);
      var12[1] = (int)(var5 - 4.0F * var17);
      var13[1] = (int)(var6 + 12.557F * var18);
      var14[1] = (int)(var7 + 3.3646F * var18);
      var12[2] = (int)(var5 + 4.0F * var17);
      var13[2] = (int)(var6 + 12.557F * var18);
      var14[2] = (int)(var7 + 3.3646F * var18);
      var12[3] = (int)(var5 + 4.0F * var17);
      var13[3] = (int)(var6 + 9.1923F * var18);
      var14[3] = (int)(var7 + 9.1923F * var18);
      var3[var4] = new Plane(var1, var2, var12, var14, var13, 4, var15, 0, var11, 1 * var19, var16, var6, var7, 7, 0, false, 0, true);
      var4++;
      var12[0] = (int)(var5 - 4.0F * var17);
      var13[0] = (int)(var6 + 9.1923F * var18);
      var14[0] = (int)(var7 + 9.1923F * var18);
      var12[1] = (int)(var5 - 4.0F * var17);
      var13[1] = (int)(var6 + 3.3646F * var18);
      var14[1] = (int)(var7 + 12.557F * var18);
      var12[2] = (int)(var5 + 4.0F * var17);
      var13[2] = (int)(var6 + 3.3646F * var18);
      var14[2] = (int)(var7 + 12.557F * var18);
      var12[3] = (int)(var5 + 4.0F * var17);
      var13[3] = (int)(var6 + 9.1923F * var18);
      var14[3] = (int)(var7 + 9.1923F * var18);
      var3[var4] = new Plane(var1, var2, var12, var14, var13, 4, var15, 0, var11, 1 * var19, var16, var6, var7, 7, 0, false, 0, true);
      var4++;
      var12[0] = (int)(var5 - 4.0F * var17);
      var13[0] = (int)(var6 + 3.3646F * var18);
      var14[0] = (int)(var7 + 12.557F * var18);
      var12[1] = (int)(var5 - 4.0F * var17);
      var13[1] = (int)(var6 - 3.3646F * var18);
      var14[1] = (int)(var7 + 12.557F * var18);
      var12[2] = (int)(var5 + 4.0F * var17);
      var13[2] = (int)(var6 - 3.3646F * var18);
      var14[2] = (int)(var7 + 12.557F * var18);
      var12[3] = (int)(var5 + 4.0F * var17);
      var13[3] = (int)(var6 + 3.3646F * var18);
      var14[3] = (int)(var7 + 12.557F * var18);
      var3[var4] = new Plane(var1, var2, var12, var14, var13, 4, var15, 0, var11, -1 * var19, var16, var6, var7, 7, 0, false, 0, true);
      var4++;
      var12[0] = (int)(var5 - 4.0F * var17);
      var13[0] = (int)(var6 - 9.1923F * var18);
      var14[0] = (int)(var7 + 9.1923F * var18);
      var12[1] = (int)(var5 - 4.0F * var17);
      var13[1] = (int)(var6 - 3.3646F * var18);
      var14[1] = (int)(var7 + 12.557F * var18);
      var12[2] = (int)(var5 + 4.0F * var17);
      var13[2] = (int)(var6 - 3.3646F * var18);
      var14[2] = (int)(var7 + 12.557F * var18);
      var12[3] = (int)(var5 + 4.0F * var17);
      var13[3] = (int)(var6 - 9.1923F * var18);
      var14[3] = (int)(var7 + 9.1923F * var18);
      var3[var4] = new Plane(var1, var2, var12, var14, var13, 4, var15, 0, var11, 1 * var19, var16, var6, var7, 7, 0, false, 0, true);
      var4++;
      var12[0] = (int)(var5 - 4.0F * var17);
      var13[0] = (int)(var6 - 9.1923F * var18);
      var14[0] = (int)(var7 + 9.1923F * var18);
      var12[1] = (int)(var5 - 4.0F * var17);
      var13[1] = (int)(var6 - 12.557F * var18);
      var14[1] = (int)(var7 + 3.3646F * var18);
      var12[2] = (int)(var5 + 4.0F * var17);
      var13[2] = (int)(var6 - 12.557F * var18);
      var14[2] = (int)(var7 + 3.3646F * var18);
      var12[3] = (int)(var5 + 4.0F * var17);
      var13[3] = (int)(var6 - 9.1923F * var18);
      var14[3] = (int)(var7 + 9.1923F * var18);
      var3[var4] = new Plane(var1, var2, var12, var14, var13, 4, var15, 0, var11, 1 * var19, var16, var6, var7, 7, 0, false, 0, true);
      var4++;
   }
}
