public class Wheels {
   int ground = 0;
   int mast = 0;

   public void make(Medium var1, Trackers var2, Plane[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      int[] var11 = new int[8];
      int[] var12 = new int[8];
      int[] var13 = new int[8];
      int[] var14 = new int[]{75, 75, 75};
      int var15 = 0;
      float var16 = var9 / 10.0F;
      float var17 = var10 / 10.0F;
      if (var8 == 11) {
         var15 = (int)(var5 + 4.0F * var16);
      }

      byte var18 = 1;
      if (Math.abs(var5) == 73) {
         var18 = -1;
      }

      int var19 = 0;

      do {
         var11[var19] = (int)(var5 - 4.0F * var16);
      } while (++var19 < 8);

      var12[0] = (int)(var6 - 12.0F * var17);
      var13[0] = (int)(var7 + 5.0F * var17);
      var12[1] = (int)(var6 - 12.0F * var17);
      var13[1] = (int)(var7 - 5.0F * var17);
      var12[2] = (int)(var6 - 5.0F * var17);
      var13[2] = (int)(var7 - 12.0F * var17);
      var12[3] = (int)(var6 + 5.0F * var17);
      var13[3] = (int)(var7 - 12.0F * var17);
      var12[4] = (int)(var6 + 12.0F * var17);
      var13[4] = (int)(var7 - 5.0F * var17);
      var12[5] = (int)(var6 + 12.0F * var17);
      var13[5] = (int)(var7 + 5.0F * var17);
      var12[6] = (int)(var6 + 5.0F * var17);
      var13[6] = (int)(var7 + 12.0F * var17);
      var12[7] = (int)(var6 - 5.0F * var17);
      var13[7] = (int)(var7 + 12.0F * var17);
      var3[var4] = new Plane(var1, var2, var11, var13, var12, 8, var14, false, 0, var15, var6, var7, 7, 0, false);
      this.mast++;
      var3[var4].master = this.mast;
      var4++;
      var11[0] = (int)(var5 - 4.0F * var16);
      var12[0] = (int)(var6 - 12.0F * var17);
      var13[0] = (int)(var7 + 5.0F * var17);
      var11[1] = (int)(var5 - 4.0F * var16);
      var12[1] = (int)(var6 - 12.0F * var17);
      var13[1] = (int)(var7 - 5.0F * var17);
      var11[2] = (int)(var5 + 4.0F * var16);
      var12[2] = (int)(var6 - 12.0F * var17);
      var13[2] = (int)(var7 - 5.0F * var17);
      var11[3] = (int)(var5 + 4.0F * var16);
      var12[3] = (int)(var6 - 12.0F * var17);
      var13[3] = (int)(var7 + 5.0F * var17);
      var3[var4] = new Plane(var1, var2, var11, var13, var12, 4, var14, false, var18, var15, var6, var7, 7, 0, false);
      var4++;
      var11[0] = (int)(var5 - 4.0F * var16);
      var12[0] = (int)(var6 - 5.0F * var17);
      var13[0] = (int)(var7 - 12.0F * var17);
      var11[1] = (int)(var5 - 4.0F * var16);
      var12[1] = (int)(var6 - 12.0F * var17);
      var13[1] = (int)(var7 - 5.0F * var17);
      var11[2] = (int)(var5 + 4.0F * var16);
      var12[2] = (int)(var6 - 12.0F * var17);
      var13[2] = (int)(var7 - 5.0F * var17);
      var11[3] = (int)(var5 + 4.0F * var16);
      var12[3] = (int)(var6 - 5.0F * var17);
      var13[3] = (int)(var7 - 12.0F * var17);
      var3[var4] = new Plane(var1, var2, var11, var13, var12, 4, var14, false, var18, var15, var6, var7, 7, 0, false);
      var4++;
      var11[0] = (int)(var5 - 4.0F * var16);
      var12[0] = (int)(var6 - 5.0F * var17);
      var13[0] = (int)(var7 - 12.0F * var17);
      var11[1] = (int)(var5 - 4.0F * var16);
      var12[1] = (int)(var6 + 5.0F * var17);
      var13[1] = (int)(var7 - 12.0F * var17);
      var11[2] = (int)(var5 + 4.0F * var16);
      var12[2] = (int)(var6 + 5.0F * var17);
      var13[2] = (int)(var7 - 12.0F * var17);
      var11[3] = (int)(var5 + 4.0F * var16);
      var12[3] = (int)(var6 - 5.0F * var17);
      var13[3] = (int)(var7 - 12.0F * var17);
      var3[var4] = new Plane(var1, var2, var11, var13, var12, 4, var14, false, var18, var15, var6, var7, 7, 0, false);
      var4++;
      var11[0] = (int)(var5 - 4.0F * var16);
      var12[0] = (int)(var6 + 12.0F * var17);
      var13[0] = (int)(var7 - 5.0F * var17);
      var11[1] = (int)(var5 - 4.0F * var16);
      var12[1] = (int)(var6 + 5.0F * var17);
      var13[1] = (int)(var7 - 12.0F * var17);
      var11[2] = (int)(var5 + 4.0F * var16);
      var12[2] = (int)(var6 + 5.0F * var17);
      var13[2] = (int)(var7 - 12.0F * var17);
      var11[3] = (int)(var5 + 4.0F * var16);
      var12[3] = (int)(var6 + 12.0F * var17);
      var13[3] = (int)(var7 - 5.0F * var17);
      var3[var4] = new Plane(var1, var2, var11, var13, var12, 4, var14, false, -1, var15, var6, var7, 7, 0, false);
      var4++;
      var11[0] = (int)(var5 - 4.0F * var16);
      var12[0] = (int)(var6 + 12.0F * var17);
      var13[0] = (int)(var7 - 5.0F * var17);
      var11[1] = (int)(var5 - 4.0F * var16);
      var12[1] = (int)(var6 + 12.0F * var17);
      var13[1] = (int)(var7 + 5.0F * var17);
      var11[2] = (int)(var5 + 4.0F * var16);
      var12[2] = (int)(var6 + 12.0F * var17);
      var13[2] = (int)(var7 + 5.0F * var17);
      var11[3] = (int)(var5 + 4.0F * var16);
      var12[3] = (int)(var6 + 12.0F * var17);
      var13[3] = (int)(var7 - 5.0F * var17);
      var3[var4] = new Plane(var1, var2, var11, var13, var12, 4, var14, false, -1, var15, var6, var7, 7, 0, false);
      var4++;
      if (this.ground < (int)(var6 + 12.0F * var17 + 1.0F)) {
         this.ground = (int)(var6 + 12.0F * var17 + 1.0F);
      }

      var11[0] = (int)(var5 - 4.0F * var16);
      var12[0] = (int)(var6 + 5.0F * var17);
      var13[0] = (int)(var7 + 12.0F * var17);
      var11[1] = (int)(var5 - 4.0F * var16);
      var12[1] = (int)(var6 + 12.0F * var17);
      var13[1] = (int)(var7 + 5.0F * var17);
      var11[2] = (int)(var5 + 4.0F * var16);
      var12[2] = (int)(var6 + 12.0F * var17);
      var13[2] = (int)(var7 + 5.0F * var17);
      var11[3] = (int)(var5 + 4.0F * var16);
      var12[3] = (int)(var6 + 5.0F * var17);
      var13[3] = (int)(var7 + 12.0F * var17);
      var3[var4] = new Plane(var1, var2, var11, var13, var12, 4, var14, false, -1, var15, var6, var7, 7, 0, false);
      var4++;
      var11[0] = (int)(var5 - 4.0F * var16);
      var12[0] = (int)(var6 + 5.0F * var17);
      var13[0] = (int)(var7 + 12.0F * var17);
      var11[1] = (int)(var5 - 4.0F * var16);
      var12[1] = (int)(var6 - 5.0F * var17);
      var13[1] = (int)(var7 + 12.0F * var17);
      var11[2] = (int)(var5 + 4.0F * var16);
      var12[2] = (int)(var6 - 5.0F * var17);
      var13[2] = (int)(var7 + 12.0F * var17);
      var11[3] = (int)(var5 + 4.0F * var16);
      var12[3] = (int)(var6 + 5.0F * var17);
      var13[3] = (int)(var7 + 12.0F * var17);
      var3[var4] = new Plane(var1, var2, var11, var13, var12, 4, var14, false, var18, var15, var6, var7, 7, 0, false);
      var4++;
      var11[0] = (int)(var5 - 4.0F * var16);
      var12[0] = (int)(var6 - 12.0F * var17);
      var13[0] = (int)(var7 + 5.0F * var17);
      var11[1] = (int)(var5 - 4.0F * var16);
      var12[1] = (int)(var6 - 5.0F * var17);
      var13[1] = (int)(var7 + 12.0F * var17);
      var11[2] = (int)(var5 + 4.0F * var16);
      var12[2] = (int)(var6 - 5.0F * var17);
      var13[2] = (int)(var7 + 12.0F * var17);
      var11[3] = (int)(var5 + 4.0F * var16);
      var12[3] = (int)(var6 - 12.0F * var17);
      var13[3] = (int)(var7 + 5.0F * var17);
      var3[var4] = new Plane(var1, var2, var11, var13, var12, 4, var14, false, var18, var15, var6, var7, 7, 0, false);
      var4++;
   }
}
