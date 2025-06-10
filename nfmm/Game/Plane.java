import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class Plane {
   Medium m;
   Trackers t;
   int[] ox;
   int[] oy;
   int[] oz;
   int n;
   int[] c = new int[3];
   int[] oc = new int[3];
   float[] hsb = new float[3];
   int glass = 0;
   int gr = 0;
   int fs = 0;
   int disline = 7;
   boolean road = false;
   boolean solo = false;
   int light = 0;
   int master = 0;
   int wx = 0;
   int wz = 0;
   int wy = 0;
   float deltaf = 1.0F;
   float projf = 1.0F;
   int av = 0;
   int bfase = 0;
   boolean nocol = false;
   int chip = 0;
   float ctmag = 0.0F;
   int cxz = 0;
   int cxy = 0;
   int czy = 0;
   int[] cox = new int[3];
   int[] coz = new int[3];
   int[] coy = new int[3];
   int dx = 0;
   int dy = 0;
   int dz = 0;
   int vx = 0;
   int vy = 0;
   int vz = 0;
   int embos = 0;
   int typ = 0;
   int pa = 0;
   int pb = 0;
   int flx = 0;
   int colnum = 0;

   public Plane(
      Medium var1,
      Trackers var2,
      int[] var3,
      int[] var4,
      int[] var5,
      int var6,
      int[] var7,
      int var8,
      int var9,
      int var10,
      int var11,
      int var12,
      int var13,
      int var14,
      int var15,
      boolean var16,
      int var17,
      boolean var18
   ) {
      this.m = var1;
      this.t = var2;
      this.n = var6;
      this.ox = new int[this.n];
      this.oz = new int[this.n];
      this.oy = new int[this.n];

      for (int var19 = 0; var19 < this.n; var19++) {
         this.ox[var19] = var3[var19];
         this.oy[var19] = var5[var19];
         this.oz[var19] = var4[var19];
      }

      for (int var22 = 0; var22 < 3; var22++) {
         this.oc[var22] = var7[var22];
      }

      if (var9 == -15) {
         if (var7[0] == 211) {
            int var23 = (int)(Math.random() * 40.0 - 20.0);
            int var20 = (int)(Math.random() * 40.0 - 20.0);

            for (int var21 = 0; var21 < this.n; var21++) {
               this.ox[var21] = this.ox[var21] + var23;
               this.oz[var21] = this.oz[var21] + var20;
            }
         }

         int var24 = (int)(185.0 + Math.random() * 20.0);
         var7[0] = (217 + var24) / 2;
         if (var7[0] == 211) {
            var7[0] = 210;
         }

         var7[1] = (189 + var24) / 2;
         var7[2] = (132 + var24) / 2;

         for (int var29 = 0; var29 < this.n; var29++) {
            if (Math.random() > Math.random()) {
               this.ox[var29] = this.ox[var29] + (int)(8.0 * Math.random() - 4.0);
            }

            if (Math.random() > Math.random()) {
               this.oy[var29] = this.oy[var29] + (int)(8.0 * Math.random() - 4.0);
            }

            if (Math.random() > Math.random()) {
               this.oz[var29] = this.oz[var29] + (int)(8.0 * Math.random() - 4.0);
            }
         }
      }

      if (var7[0] == var7[1] && var7[1] == var7[2]) {
         this.nocol = true;
      }

      if (var8 == 0) {
         for (int var25 = 0; var25 < 3; var25++) {
            this.c[var25] = (int)(var7[var25] + var7[var25] * (this.m.snap[var25] / 100.0F));
            if (this.c[var25] > 255) {
               this.c[var25] = 255;
            }

            if (this.c[var25] < 0) {
               this.c[var25] = 0;
            }
         }
      }

      if (var8 == 1) {
         for (int var26 = 0; var26 < 3; var26++) {
            this.c[var26] = (this.m.csky[var26] * this.m.fade[0] * 2 + this.m.cfade[var26] * 3000) / (this.m.fade[0] * 2 + 3000);
         }
      }

      if (var8 == 2) {
         for (int var27 = 0; var27 < 3; var27++) {
            this.c[var27] = (int)(this.m.crgrnd[var27] * 0.925F);
         }
      }

      if (var8 == 3) {
         for (int var28 = 0; var28 < 3; var28++) {
            this.c[var28] = var7[var28];
         }
      }

      this.disline = var14;
      this.bfase = var15;
      this.glass = var8;
      Color.RGBtoHSB(this.c[0], this.c[1], this.c[2], this.hsb);
      if (var8 == 3 && this.m.trk != 2) {
         this.hsb[1] = this.hsb[1] + 0.05F;
         if (this.hsb[1] > 1.0F) {
            this.hsb[1] = 1.0F;
         }
      }

      if (!this.nocol && this.glass != 1) {
         if (this.bfase > 20 && this.hsb[1] > 0.25) {
            this.hsb[1] = 0.25F;
         }

         if (this.bfase > 25 && this.hsb[2] > 0.7) {
            this.hsb[2] = 0.7F;
         }

         if (this.bfase > 30 && this.hsb[1] > 0.15) {
            this.hsb[1] = 0.15F;
         }

         if (this.bfase > 35 && this.hsb[2] > 0.6) {
            this.hsb[2] = 0.6F;
         }

         if (this.bfase > 40) {
            this.hsb[0] = 0.075F;
         }

         if (this.bfase > 50 && this.hsb[2] > 0.5) {
            this.hsb[2] = 0.5F;
         }

         if (this.bfase > 60) {
            this.hsb[0] = 0.05F;
         }
      }

      this.road = var16;
      this.light = var17;
      this.solo = var18;
      this.gr = var9;
      this.fs = var10;
      this.wx = var11;
      this.wy = var12;
      this.wz = var13;
      this.deltafntyp();
   }

   public void deltafntyp() {
      int var1 = Math.abs(this.ox[2] - this.ox[1]);
      int var2 = Math.abs(this.oy[2] - this.oy[1]);
      int var3 = Math.abs(this.oz[2] - this.oz[1]);
      if (var2 <= var1 && var2 <= var3) {
         this.typ = 2;
      }

      if (var1 <= var2 && var1 <= var3) {
         this.typ = 1;
      }

      if (var3 <= var1 && var3 <= var2) {
         this.typ = 3;
      }

      this.deltaf = 1.0F;

      for (int var4 = 0; var4 < 3; var4++) {
         for (int var5 = 0; var5 < 3; var5++) {
            if (var5 != var4) {
               this.deltaf = this.deltaf
                  * (float)(
                     Math.sqrt(
                           (this.ox[var5] - this.ox[var4]) * (this.ox[var5] - this.ox[var4])
                              + (this.oy[var5] - this.oy[var4]) * (this.oy[var5] - this.oy[var4])
                              + (this.oz[var5] - this.oz[var4]) * (this.oz[var5] - this.oz[var4])
                        )
                        / 100.0
                  );
            }
         }
      }

      this.deltaf /= 3.0F;
   }

   public void loadprojf() {
      this.projf = 1.0F;

      for (int var1 = 0; var1 < 3; var1++) {
         for (int var2 = 0; var2 < 3; var2++) {
            if (var2 != var1) {
               this.projf = this.projf
                  * (float)(
                     Math.sqrt(
                           (this.ox[var1] - this.ox[var2]) * (this.ox[var1] - this.ox[var2])
                              + (this.oz[var1] - this.oz[var2]) * (this.oz[var1] - this.oz[var2])
                        )
                        / 100.0
                  );
            }
         }
      }

      this.projf /= 3.0F;
   }

   public void d(Graphics2D var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, boolean var10, int var11) {
      if (this.master == 1) {
         if (this.av > 1500 && !this.m.crs) {
            this.n = 12;
         } else {
            this.n = 20;
         }
      }

      int[] var12 = new int[this.n];
      int[] var13 = new int[this.n];
      int[] var14 = new int[this.n];
      if (this.embos == 0) {
         for (int var15 = 0; var15 < this.n; var15++) {
            var12[var15] = this.ox[var15] + var2;
            var14[var15] = this.oy[var15] + var3;
            var13[var15] = this.oz[var15] + var4;
         }

         if ((this.gr == -11 || this.gr == -12 || this.gr == -13) && this.m.lastmaf == 1) {
            for (int var40 = 0; var40 < this.n; var40++) {
               var12[var40] = -this.ox[var40] + var2;
               var14[var40] = this.oy[var40] + var3;
               var13[var40] = -this.oz[var40] + var4;
            }
         }
      } else {
         if (this.embos <= 11 && this.m.random() > 0.5 && this.glass != 1) {
            for (int var41 = 0; var41 < this.n; var41++) {
               var12[var41] = (int)(this.ox[var41] + var2 + (15.0F - this.m.random() * 30.0F));
               var14[var41] = (int)(this.oy[var41] + var3 + (15.0F - this.m.random() * 30.0F));
               var13[var41] = (int)(this.oz[var41] + var4 + (15.0F - this.m.random() * 30.0F));
            }

            this.rot(var12, var14, var2, var3, var6, this.n);
            this.rot(var14, var13, var3, var4, var7, this.n);
            this.rot(var12, var13, var2, var4, var5, this.n);
            this.rot(var12, var13, this.m.cx, this.m.cz, this.m.xz, this.n);
            this.rot(var14, var13, this.m.cy, this.m.cz, this.m.zy, this.n);
            int[] var42 = new int[this.n];
            int[] var16 = new int[this.n];

            for (int var17 = 0; var17 < this.n; var17++) {
               var42[var17] = this.xs(var12[var17], var13[var17]);
               var16[var17] = this.ys(var14[var17], var13[var17]);
            }

            var1.setColor(new Color(230, 230, 230));
            var1.fillPolygon(var42, var16, this.n);
         }

         float var43 = 1.0F;
         if (this.embos <= 4) {
            var43 = 1.0F + this.m.random() / 5.0F;
         }

         if (this.embos > 4 && this.embos <= 7) {
            var43 = 1.0F + this.m.random() / 4.0F;
         }

         if (this.embos > 7 && this.embos <= 9) {
            var43 = 1.0F + this.m.random() / 3.0F;
            if (this.hsb[2] > 0.7) {
               this.hsb[2] = 0.7F;
            }
         }

         if (this.embos > 9 && this.embos <= 10) {
            var43 = 1.0F + this.m.random() / 2.0F;
            if (this.hsb[2] > 0.6) {
               this.hsb[2] = 0.6F;
            }
         }

         if (this.embos > 10 && this.embos <= 12) {
            var43 = 1.0F + this.m.random() / 1.0F;
            if (this.hsb[2] > 0.5) {
               this.hsb[2] = 0.5F;
            }
         }

         if (this.embos == 12) {
            this.chip = 1;
            this.ctmag = 2.0F;
            this.bfase = -7;
         }

         if (this.embos == 13) {
            this.hsb[1] = 0.2F;
            this.hsb[2] = 0.4F;
         }

         if (this.embos == 16) {
            this.pa = (int)(this.m.random() * this.n);
            this.pb = (int)(this.m.random() * this.n);

            while (this.pa == this.pb) {
               this.pb = (int)(this.m.random() * this.n);
            }
         }

         if (this.embos >= 16) {
            byte var48 = 1;
            byte var53 = 1;
            int var18 = Math.abs(var7);

            while (var18 > 270) {
               var18 -= 360;
            }

            var18 = Math.abs(var18);
            if (var18 > 90) {
               var48 = -1;
            }

            int var19 = Math.abs(var6);

            while (var19 > 270) {
               var19 -= 360;
            }

            var19 = Math.abs(var19);
            if (var19 > 90) {
               var53 = -1;
            }

            int[] var20 = new int[3];
            int[] var21 = new int[3];
            var12[0] = this.ox[this.pa] + var2;
            var14[0] = this.oy[this.pa] + var3;
            var13[0] = this.oz[this.pa] + var4;
            var12[1] = this.ox[this.pb] + var2;
            var14[1] = this.oy[this.pb] + var3;
            var13[1] = this.oz[this.pb] + var4;

            while (Math.abs(var12[0] - var12[1]) > 100) {
               if (var12[1] > var12[0]) {
                  var12[1] -= 30;
               } else {
                  var12[1] += 30;
               }
            }

            while (Math.abs(var13[0] - var13[1]) > 100) {
               if (var13[1] > var13[0]) {
                  var13[1] -= 30;
               } else {
                  var13[1] += 30;
               }
            }

            int var22 = (int)(Math.abs(var12[0] - var12[1]) / 3 * (0.5 - this.m.random()));
            int var23 = (int)(Math.abs(var13[0] - var13[1]) / 3 * (0.5 - this.m.random()));
            var12[2] = (var12[0] + var12[1]) / 2 + var22;
            var13[2] = (var13[0] + var13[1]) / 2 + var23;
            int var24 = (int)((Math.abs(var12[0] - var12[1]) + Math.abs(var13[0] - var13[1])) / 1.5 * (this.m.random() / 2.0F + 0.5));
            var14[2] = (var14[0] + var14[1]) / 2 - var48 * var53 * var24;
            this.rot(var12, var14, var2, var3, var6, 3);
            this.rot(var14, var13, var3, var4, var7, 3);
            this.rot(var12, var13, var2, var4, var5, 3);
            this.rot(var12, var13, this.m.cx, this.m.cz, this.m.xz, 3);
            this.rot(var14, var13, this.m.cy, this.m.cz, this.m.zy, 3);

            for (int var25 = 0; var25 < 3; var25++) {
               var20[var25] = this.xs(var12[var25], var13[var25]);
               var21[var25] = this.ys(var14[var25], var13[var25]);
            }

            int var78 = (int)(255.0F + 255.0F * (this.m.snap[0] / 400.0F));
            if (var78 > 255) {
               var78 = 255;
            }

            if (var78 < 0) {
               var78 = 0;
            }

            int var26 = (int)(169.0F + 169.0F * (this.m.snap[1] / 300.0F));
            if (var26 > 255) {
               var26 = 255;
            }

            if (var26 < 0) {
               var26 = 0;
            }

            int var27 = (int)(89.0F + 89.0F * (this.m.snap[2] / 200.0F));
            if (var27 > 255) {
               var27 = 255;
            }

            if (var27 < 0) {
               var27 = 0;
            }

            var1.setColor(new Color(var78, var26, var27));
            var1.fillPolygon(var20, var21, 3);
            var12[0] = this.ox[this.pa] + var2;
            var14[0] = this.oy[this.pa] + var3;
            var13[0] = this.oz[this.pa] + var4;
            var12[1] = this.ox[this.pb] + var2;
            var14[1] = this.oy[this.pb] + var3;
            var13[1] = this.oz[this.pb] + var4;

            while (Math.abs(var12[0] - var12[1]) > 100) {
               if (var12[1] > var12[0]) {
                  var12[1] -= 30;
               } else {
                  var12[1] += 30;
               }
            }

            while (Math.abs(var13[0] - var13[1]) > 100) {
               if (var13[1] > var13[0]) {
                  var13[1] -= 30;
               } else {
                  var13[1] += 30;
               }
            }

            var12[2] = (var12[0] + var12[1]) / 2 + var22;
            var13[2] = (var13[0] + var13[1]) / 2 + var23;
            var24 = (int)(var24 * 0.8);
            var14[2] = (var14[0] + var14[1]) / 2 - var48 * var53 * var24;
            this.rot(var12, var14, var2, var3, var6, 3);
            this.rot(var14, var13, var3, var4, var7, 3);
            this.rot(var12, var13, var2, var4, var5, 3);
            this.rot(var12, var13, this.m.cx, this.m.cz, this.m.xz, 3);
            this.rot(var14, var13, this.m.cy, this.m.cz, this.m.zy, 3);

            for (int var28 = 0; var28 < 3; var28++) {
               var20[var28] = this.xs(var12[var28], var13[var28]);
               var21[var28] = this.ys(var14[var28], var13[var28]);
            }

            var78 = (int)(255.0F + 255.0F * (this.m.snap[0] / 400.0F));
            if (var78 > 255) {
               var78 = 255;
            }

            if (var78 < 0) {
               var78 = 0;
            }

            var26 = (int)(207.0F + 207.0F * (this.m.snap[1] / 300.0F));
            if (var26 > 255) {
               var26 = 255;
            }

            if (var26 < 0) {
               var26 = 0;
            }

            var27 = (int)(136.0F + 136.0F * (this.m.snap[2] / 200.0F));
            if (var27 > 255) {
               var27 = 255;
            }

            if (var27 < 0) {
               var27 = 0;
            }

            var1.setColor(new Color(var78, var26, var27));
            var1.fillPolygon(var20, var21, 3);
         }

         for (int var49 = 0; var49 < this.n; var49++) {
            if (this.typ == 1) {
               var12[var49] = (int)(this.ox[var49] * var43 + var2);
            } else {
               var12[var49] = this.ox[var49] + var2;
            }

            if (this.typ == 2) {
               var14[var49] = (int)(this.oy[var49] * var43 + var3);
            } else {
               var14[var49] = this.oy[var49] + var3;
            }

            if (this.typ == 3) {
               var13[var49] = (int)(this.oz[var49] * var43 + var4);
            } else {
               var13[var49] = this.oz[var49] + var4;
            }
         }

         if (this.embos != 70) {
            this.embos++;
         } else {
            this.embos = 16;
         }
      }

      if (this.wz != 0) {
         this.rot(var14, var13, this.wy + var3, this.wz + var4, var9, this.n);
      }

      if (this.wx != 0) {
         this.rot(var12, var13, this.wx + var2, this.wz + var4, var8, this.n);
      }

      if (this.chip == 1 && (this.m.random() > 0.6 || this.bfase == 0)) {
         this.chip = 0;
         if (this.bfase == 0 && this.nocol) {
            this.bfase = 1;
         }
      }

      if (this.chip != 0) {
         if (this.chip == 1) {
            this.cxz = var5;
            this.cxy = var6;
            this.czy = var7;
            int var44 = (int)(this.m.random() * this.n);
            this.cox[0] = this.ox[var44];
            this.coz[0] = this.oz[var44];
            this.coy[0] = this.oy[var44];
            if (this.ctmag > 3.0F) {
               this.ctmag = 3.0F;
            }

            if (this.ctmag < -3.0F) {
               this.ctmag = -3.0F;
            }

            this.cox[1] = (int)(this.cox[0] + this.ctmag * (10.0F - this.m.random() * 20.0F));
            this.cox[2] = (int)(this.cox[0] + this.ctmag * (10.0F - this.m.random() * 20.0F));
            this.coy[1] = (int)(this.coy[0] + this.ctmag * (10.0F - this.m.random() * 20.0F));
            this.coy[2] = (int)(this.coy[0] + this.ctmag * (10.0F - this.m.random() * 20.0F));
            this.coz[1] = (int)(this.coz[0] + this.ctmag * (10.0F - this.m.random() * 20.0F));
            this.coz[2] = (int)(this.coz[0] + this.ctmag * (10.0F - this.m.random() * 20.0F));
            this.dx = 0;
            this.dy = 0;
            this.dz = 0;
            if (this.bfase != -7) {
               this.vx = (int)(this.ctmag * (30.0F - this.m.random() * 60.0F));
               this.vz = (int)(this.ctmag * (30.0F - this.m.random() * 60.0F));
               this.vy = (int)(this.ctmag * (30.0F - this.m.random() * 60.0F));
            } else {
               this.vx = (int)(this.ctmag * (10.0F - this.m.random() * 20.0F));
               this.vz = (int)(this.ctmag * (10.0F - this.m.random() * 20.0F));
               this.vy = (int)(this.ctmag * (10.0F - this.m.random() * 20.0F));
            }

            this.chip = 2;
         }

         int[] var45 = new int[3];
         int[] var50 = new int[3];
         int[] var54 = new int[3];

         for (int var57 = 0; var57 < 3; var57++) {
            var45[var57] = this.cox[var57] + var2;
            var54[var57] = this.coy[var57] + var3;
            var50[var57] = this.coz[var57] + var4;
         }

         this.rot(var45, var54, var2, var3, this.cxy, 3);
         this.rot(var54, var50, var3, var4, this.czy, 3);
         this.rot(var45, var50, var2, var4, this.cxz, 3);

         for (int var58 = 0; var58 < 3; var58++) {
            var45[var58] += this.dx;
            var54[var58] += this.dy;
            var50[var58] += this.dz;
         }

         this.dx = this.dx + this.vx;
         this.dz = this.dz + this.vz;
         this.dy = this.dy + this.vy;
         this.vy += 7;
         if (var54[0] > this.m.ground) {
            this.chip = 19;
         }

         this.rot(var45, var50, this.m.cx, this.m.cz, this.m.xz, 3);
         this.rot(var54, var50, this.m.cy, this.m.cz, this.m.zy, 3);
         int[] var59 = new int[3];
         int[] var62 = new int[3];

         for (int var65 = 0; var65 < 3; var65++) {
            var59[var65] = this.xs(var45[var65], var50[var65]);
            var62[var65] = this.ys(var54[var65], var50[var65]);
         }

         int var66 = (int)(this.m.random() * 3.0F);
         if (this.bfase != -7) {
            if (var66 == 0) {
               var1.setColor(new Color(this.c[0], this.c[1], this.c[2]).darker());
            }

            if (var66 == 1) {
               var1.setColor(new Color(this.c[0], this.c[1], this.c[2]));
            }

            if (var66 == 2) {
               var1.setColor(new Color(this.c[0], this.c[1], this.c[2]).brighter());
            }
         } else {
            var1.setColor(Color.getHSBColor(this.hsb[0], this.hsb[1], this.hsb[2]));
         }

         var1.fillPolygon(var59, var62, 3);
         this.chip++;
         if (this.chip == 20) {
            this.chip = 0;
         }
      }

      this.rot(var12, var14, var2, var3, var6, this.n);
      this.rot(var14, var13, var3, var4, var7, this.n);
      this.rot(var12, var13, var2, var4, var5, this.n);
      if ((var6 != 0 || var7 != 0 || var5 != 0) && this.m.trk != 2) {
         this.projf = 1.0F;

         for (int var46 = 0; var46 < 3; var46++) {
            for (int var51 = 0; var51 < 3; var51++) {
               if (var51 != var46) {
                  this.projf = this.projf
                     * (float)(
                        Math.sqrt((var12[var46] - var12[var51]) * (var12[var46] - var12[var51]) + (var13[var46] - var13[var51]) * (var13[var46] - var13[var51]))
                           / 100.0
                     );
               }
            }
         }

         this.projf /= 3.0F;
      }

      this.rot(var12, var13, this.m.cx, this.m.cz, this.m.xz, this.n);
      boolean var47 = false;
      int[] var52 = new int[this.n];
      int[] var55 = new int[this.n];
      int var60 = 500;

      for (int var63 = 0; var63 < this.n; var63++) {
         var52[var63] = this.xs(var12[var63], var13[var63]);
         var55[var63] = this.ys(var14[var63], var13[var63]);
      }

      int var64 = 0;
      int var67 = 1;

      for (int var68 = 0; var68 < this.n; var68++) {
         for (int var72 = var68; var72 < this.n; var72++) {
            if (var68 != var72 && Math.abs(var52[var68] - var52[var72]) - Math.abs(var55[var68] - var55[var72]) < var60) {
               var67 = var68;
               var64 = var72;
               var60 = Math.abs(var52[var68] - var52[var72]) - Math.abs(var55[var68] - var55[var72]);
            }
         }
      }

      if (var55[var64] < var55[var67]) {
         int var69 = var64;
         var64 = var67;
         var67 = var69;
      }

      if (this.spy(var12[var64], var13[var64]) > this.spy(var12[var67], var13[var67])) {
         var47 = true;
         int var70 = 0;

         for (int var73 = 0; var73 < this.n; var73++) {
            if (var13[var73] < 50 && var14[var73] > this.m.cy) {
               var47 = false;
            } else if (var14[var73] == var14[0]) {
               var70++;
            }
         }

         if (var70 == this.n && var14[0] > this.m.cy) {
            var47 = false;
         }
      }

      this.rot(var14, var13, this.m.cy, this.m.cz, this.m.zy, this.n);
      boolean var71 = true;
      int[] var74 = new int[this.n];
      int[] var75 = new int[this.n];
      int var77 = 0;
      int var80 = 0;
      int var82 = 0;
      int var84 = 0;
      int var85 = 0;

      for (int var29 = 0; var29 < this.n; var29++) {
         var74[var29] = this.xs(var12[var29], var13[var29]);
         var75[var29] = this.ys(var14[var29], var13[var29]);
         if (var75[var29] < this.m.ih || var13[var29] < 10) {
            var77++;
         }

         if (var75[var29] > this.m.h || var13[var29] < 10) {
            var80++;
         }

         if (var74[var29] < this.m.iw || var13[var29] < 10) {
            var82++;
         }

         if (var74[var29] > this.m.w || var13[var29] < 10) {
            var84++;
         }

         if (var13[var29] < 10) {
            var85++;
         }
      }

      if (var82 == this.n || var77 == this.n || var80 == this.n || var84 == this.n) {
         var71 = false;
      }

      if ((this.m.trk == 1 || this.m.trk == 4) && (var82 != 0 || var77 != 0 || var80 != 0 || var84 != 0)) {
         var71 = false;
      }

      if (this.m.trk == 3 && var85 != 0) {
         var71 = false;
      }

      if (var85 != 0) {
         var10 = true;
      }

      if (var71 && var11 != -1) {
         int var86 = 0;
         int var30 = 0;

         for (int var31 = 0; var31 < this.n; var31++) {
            for (int var32 = var31; var32 < this.n; var32++) {
               if (var31 != var32) {
                  if (Math.abs(var74[var31] - var74[var32]) > var86) {
                     var86 = Math.abs(var74[var31] - var74[var32]);
                  }

                  if (Math.abs(var75[var31] - var75[var32]) > var30) {
                     var30 = Math.abs(var75[var31] - var75[var32]);
                  }
               }
            }
         }

         if (var86 == 0 || var30 == 0) {
            var71 = false;
         } else if (var86 < 3 && var30 < 3 && (var11 / var86 > 15 && var11 / var30 > 15 || var10) && (!this.m.lightson || this.light == 0)) {
            var71 = false;
         }
      }

      if (var71) {
         int var87 = 1;
         int var89 = this.gr;
         if (var89 < 0 && var89 >= -15) {
            var89 = 0;
         }

         if (this.gr == -11) {
            var89 = -90;
         }

         if (this.gr == -12) {
            var89 = -75;
         }

         if (this.gr == -14 || this.gr == -15) {
            var89 = -50;
         }

         if (this.glass == 2) {
            var89 = 200;
         }

         if (this.fs != 0) {
            byte var92 = 1;
            byte var105 = 1;
            if (Math.abs(var75[0] - var75[1]) > Math.abs(var75[2] - var75[1])) {
               var92 = 0;
               var105 = 2;
            } else {
               var92 = 2;
               var105 = 0;
               var87 *= -1;
            }

            if (var75[1] > var75[var92]) {
               var87 *= -1;
            }

            if (var74[1] > var74[var105]) {
               var87 *= -1;
            }

            if (this.fs != 22) {
               var87 *= this.fs;
               if (var87 == -1) {
                  var89 += 40;
                  var87 = -111;
               }
            }
         }

         if (this.m.lightson && this.light == 2) {
            var89 -= 40;
         }

         int var94 = var14[0];
         int var107 = var14[0];
         int var33 = var12[0];
         int var34 = var12[0];
         int var35 = var13[0];
         int var36 = var13[0];

         for (int var37 = 0; var37 < this.n; var37++) {
            if (var14[var37] > var94) {
               var94 = var14[var37];
            }

            if (var14[var37] < var107) {
               var107 = var14[var37];
            }

            if (var12[var37] > var33) {
               var33 = var12[var37];
            }

            if (var12[var37] < var34) {
               var34 = var12[var37];
            }

            if (var13[var37] > var35) {
               var35 = var13[var37];
            }

            if (var13[var37] < var36) {
               var36 = var13[var37];
            }
         }

         int var128 = (var94 + var107) / 2;
         int var38 = (var33 + var34) / 2;
         int var39 = (var35 + var36) / 2;
         this.av = (int)Math.sqrt(
            (this.m.cy - var128) * (this.m.cy - var128) + (this.m.cx - var38) * (this.m.cx - var38) + var39 * var39 + var89 * var89 * var89
         );
         if (this.m.trk == 0 && (this.av > this.m.fade[this.disline] || this.av == 0)) {
            var71 = false;
         }

         if (var87 == -111 && this.av > 4500 && !this.road) {
            var71 = false;
         }

         if (var87 == -111 && this.av > 1500) {
            var10 = true;
         }

         if (this.av > 3000 && this.m.adv <= 900) {
            var10 = true;
         }

         if (this.fs == 22 && this.av < 11200) {
            this.m.lastmaf = var87;
         }

         if (this.gr == -13 && (!this.m.lastcheck || var11 != -1)) {
            var71 = false;
         }

         if (this.master == 2 && this.av > 1500 && !this.m.crs) {
            var71 = false;
         }

         if ((this.gr == -14 || this.gr == -15 || this.gr == -12)
            && (this.av > 11000 || var47 || var87 == -111 || this.m.resdown == 2)
            && this.m.trk != 2
            && this.m.trk != 3) {
            var71 = false;
         }

         if (this.gr == -11 && this.av > 11000 && this.m.trk != 2 && this.m.trk != 3) {
            var71 = false;
         }

         if (this.glass == 2 && (this.m.trk != 0 || this.av > 6700)) {
            var71 = false;
         }

         if (this.flx != 0 && this.m.random() > 0.3 && this.flx != 77) {
            var71 = false;
         }
      }

      if (var71) {
         float var88 = (float)(this.projf / this.deltaf + 0.3);
         if (var10 && !this.solo) {
            boolean var90 = false;
            if (var88 > 1.0F) {
               if (var88 >= 1.27) {
                  var90 = true;
               }

               var88 = 1.0F;
            }

            if (var90) {
               var88 = (float)(var88 * 0.89);
            } else {
               var88 = (float)(var88 * 0.86);
            }

            if (var88 < 0.37) {
               var88 = 0.37F;
            }

            if (this.gr == -9) {
               var88 = 0.7F;
            }

            if (this.gr == -4) {
               var88 = 0.74F;
            }

            if (this.gr != -7 && this.m.trk == 0 && var47) {
               var88 = 0.32F;
            }

            if (this.gr == -8 || this.gr == -14 || this.gr == -15) {
               var88 = 1.0F;
            }

            if (this.gr == -11 || this.gr == -12) {
               var88 = 0.6F;
               if (var11 == -1) {
                  if (!this.m.cpflik && (!this.m.nochekflk || this.m.lastcheck)) {
                     var88 = 0.76F;
                  } else {
                     var88 = 1.0F;
                  }
               }
            }

            if (this.gr == -13 && var11 == -1) {
               if (this.m.cpflik) {
                  var88 = 0.0F;
               } else {
                  var88 = 0.76F;
               }
            }

            if (this.gr == -6) {
               var88 = 0.62F;
            }

            if (this.gr == -5) {
               var88 = 0.55F;
            }
         } else {
            if (var88 > 1.0F) {
               var88 = 1.0F;
            }

            if (var88 < 0.6 || var47) {
               var88 = 0.6F;
            }
         }

         Color var91 = Color.getHSBColor(this.hsb[0], this.hsb[1], this.hsb[2] * var88);
         if (this.m.trk == 1) {
            float[] var95 = new float[3];
            Color.RGBtoHSB(this.oc[0], this.oc[1], this.oc[2], var95);
            var95[0] = 0.15F;
            var95[1] = 0.3F;
            var91 = Color.getHSBColor(var95[0], var95[1], var95[2] * var88 + 0.0F);
         }

         if (this.m.trk == 3) {
            float[] var96 = new float[3];
            Color.RGBtoHSB(this.oc[0], this.oc[1], this.oc[2], var96);
            var96[0] = 0.6F;
            var96[1] = 0.14F;
            var91 = Color.getHSBColor(var96[0], var96[1], var96[2] * var88 + 0.0F);
         }

         int var97 = var91.getRed();
         int var108 = var91.getGreen();
         int var117 = var91.getBlue();
         if (this.m.lightson && (this.light != 0 || (this.gr == -11 || this.gr == -12) && var11 == -1)) {
            var97 = this.oc[0];
            if (var97 > 255) {
               var97 = 255;
            }

            if (var97 < 0) {
               var97 = 0;
            }

            var108 = this.oc[1];
            if (var108 > 255) {
               var108 = 255;
            }

            if (var108 < 0) {
               var108 = 0;
            }

            var117 = this.oc[2];
            if (var117 > 255) {
               var117 = 255;
            }

            if (var117 < 0) {
               var117 = 0;
            }
         }

         if (this.m.trk == 0) {
            for (int var125 = 0; var125 < 16; var125++) {
               if (this.av > this.m.fade[var125]) {
                  var97 = (var97 * this.m.fogd + this.m.cfade[0]) / (this.m.fogd + 1);
                  var108 = (var108 * this.m.fogd + this.m.cfade[1]) / (this.m.fogd + 1);
                  var117 = (var117 * this.m.fogd + this.m.cfade[2]) / (this.m.fogd + 1);
               }
            }
         }

         var1.setColor(new Color(var97, var108, var117));
         var1.fillPolygon(var74, var75, this.n);
         if (this.m.trk != 0 && this.gr == -10) {
            var10 = false;
         }

         if (!var10) {
            if (this.flx == 0) {
               if (!this.solo) {
                  var97 = 0;
                  var108 = 0;
                  var117 = 0;
                  if (this.m.lightson && this.light != 0) {
                     var97 = this.oc[0] / 2;
                     if (var97 > 255) {
                        var97 = 255;
                     }

                     if (var97 < 0) {
                        var97 = 0;
                     }

                     var108 = this.oc[1] / 2;
                     if (var108 > 255) {
                        var108 = 255;
                     }

                     if (var108 < 0) {
                        var108 = 0;
                     }

                     var117 = this.oc[2] / 2;
                     if (var117 > 255) {
                        var117 = 255;
                     }

                     if (var117 < 0) {
                        var117 = 0;
                     }
                  }

                  if (Madness.anti == 1) {
                     var1.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                  }

                  var1.setColor(new Color(var97, var108, var117));
                  var1.drawPolygon(var74, var75, this.n);
                  if (Madness.anti == 1) {
                     var1.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
                  }
               }
            } else {
               if (this.flx == 2) {
                  var1.setColor(new Color(0, 0, 0));
                  var1.drawPolygon(var74, var75, this.n);
               }

               if (this.flx == 1) {
                  byte var99 = 0;
                  var108 = (int)(223.0F + 223.0F * (this.m.snap[1] / 100.0F));
                  if (var108 > 255) {
                     var108 = 255;
                  }

                  if (var108 < 0) {
                     var108 = 0;
                  }

                  var117 = (int)(255.0F + 255.0F * (this.m.snap[2] / 100.0F));
                  if (var117 > 255) {
                     var117 = 255;
                  }

                  if (var117 < 0) {
                     var117 = 0;
                  }

                  var1.setColor(new Color(var99, var108, var117));
                  var1.drawPolygon(var74, var75, this.n);
                  this.flx = 2;
               }

               if (this.flx == 3) {
                  byte var100 = 0;
                  var108 = (int)(255.0F + 255.0F * (this.m.snap[1] / 100.0F));
                  if (var108 > 255) {
                     var108 = 255;
                  }

                  if (var108 < 0) {
                     var108 = 0;
                  }

                  var117 = (int)(223.0F + 223.0F * (this.m.snap[2] / 100.0F));
                  if (var117 > 255) {
                     var117 = 255;
                  }

                  if (var117 < 0) {
                     var117 = 0;
                  }

                  var1.setColor(new Color(var100, var108, var117));
                  var1.drawPolygon(var74, var75, this.n);
                  this.flx = 2;
               }

               if (this.flx == 77) {
                  var1.setColor(new Color(16, 198, 255));
                  var1.drawPolygon(var74, var75, this.n);
                  this.flx = 0;
               }
            }
         } else if (this.road && this.av <= 3000 && this.m.trk == 0 && this.m.fade[0] > 4000) {
            var97 -= 10;
            if (var97 < 0) {
               var97 = 0;
            }

            var108 -= 10;
            if (var108 < 0) {
               var108 = 0;
            }

            var117 -= 10;
            if (var117 < 0) {
               var117 = 0;
            }

            var1.setColor(new Color(var97, var108, var117));
            var1.drawPolygon(var74, var75, this.n);
         }

         if (this.gr == -10) {
            if (this.m.trk != 0) {
               if (this.m.cpflik && this.m.hit == 5000) {
                  var108 = (int)(Math.random() * 115.0);
                  var97 = var108 * 2 - 54;
                  if (var97 < 0) {
                     var97 = 0;
                  }

                  if (var97 > 255) {
                     var97 = 255;
                  }

                  var117 = 202 + var108 * 2;
                  if (var117 < 0) {
                     var117 = 0;
                  }

                  if (var117 > 255) {
                     var117 = 255;
                  }

                  var108 += 101;
                  if (var108 < 0) {
                     var108 = 0;
                  }

                  if (var108 > 255) {
                     var108 = 255;
                  }

                  var1.setColor(new Color(var97, var108, var117));
                  var1.drawPolygon(var74, var75, this.n);
               }
            } else {
               var97 = this.c[0];
               var108 = this.c[1];
               var117 = this.c[2];
               if (var11 == -1 && this.m.cpflik) {
                  var97 = (int)(var97 * 1.6);
                  if (var97 > 255) {
                     var97 = 255;
                  }

                  var108 = (int)(var108 * 1.6);
                  if (var108 > 255) {
                     var108 = 255;
                  }

                  var117 = (int)(var117 * 1.6);
                  if (var117 > 255) {
                     var117 = 255;
                  }
               }

               for (int var126 = 0; var126 < 16; var126++) {
                  if (this.av > this.m.fade[var126]) {
                     var97 = (var97 * this.m.fogd + this.m.cfade[0]) / (this.m.fogd + 1);
                     var108 = (var108 * this.m.fogd + this.m.cfade[1]) / (this.m.fogd + 1);
                     var117 = (var117 * this.m.fogd + this.m.cfade[2]) / (this.m.fogd + 1);
                  }
               }

               var1.setColor(new Color(var97, var108, var117));
               var1.drawPolygon(var74, var75, this.n);
            }
         }

         if (this.gr == -18 && this.m.trk == 0) {
            var97 = this.c[0];
            var108 = this.c[1];
            var117 = this.c[2];
            if (this.m.cpflik && this.m.elecr >= 0.0F) {
               var97 = (int)(25.5F * this.m.elecr);
               if (var97 > 255) {
                  var97 = 255;
               }

               var108 = (int)(128.0F + 12.8F * this.m.elecr);
               if (var108 > 255) {
                  var108 = 255;
               }

               var117 = 255;
            }

            for (int var127 = 0; var127 < 16; var127++) {
               if (this.av > this.m.fade[var127]) {
                  var97 = (var97 * this.m.fogd + this.m.cfade[0]) / (this.m.fogd + 1);
                  var108 = (var108 * this.m.fogd + this.m.cfade[1]) / (this.m.fogd + 1);
                  var117 = (var117 * this.m.fogd + this.m.cfade[2]) / (this.m.fogd + 1);
               }
            }

            var1.setColor(new Color(var97, var108, var117));
            var1.drawPolygon(var74, var75, this.n);
         }
      }
   }

   public void s(Graphics2D var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int[] var9 = new int[this.n];
      int[] var10 = new int[this.n];
      int[] var11 = new int[this.n];

      for (int var12 = 0; var12 < this.n; var12++) {
         var9[var12] = this.ox[var12] + var2;
         var11[var12] = this.oy[var12] + var3;
         var10[var12] = this.oz[var12] + var4;
      }

      this.rot(var9, var11, var2, var3, var6, this.n);
      this.rot(var11, var10, var3, var4, var7, this.n);
      this.rot(var9, var10, var2, var4, var5, this.n);
      int var27 = (int)(this.m.crgrnd[0] / 1.5);
      int var13 = (int)(this.m.crgrnd[1] / 1.5);
      int var14 = (int)(this.m.crgrnd[2] / 1.5);

      for (int var15 = 0; var15 < this.n; var15++) {
         var11[var15] = this.m.ground;
      }

      if (var8 == 0) {
         int var28 = 0;
         int var16 = 0;
         int var17 = 0;
         int var18 = 0;

         for (int var19 = 0; var19 < this.n; var19++) {
            int var20 = 0;
            int var21 = 0;
            int var22 = 0;
            int var23 = 0;

            for (int var24 = 0; var24 < this.n; var24++) {
               if (var9[var19] >= var9[var24]) {
                  var20++;
               }

               if (var9[var19] <= var9[var24]) {
                  var21++;
               }

               if (var10[var19] >= var10[var24]) {
                  var22++;
               }

               if (var10[var19] <= var10[var24]) {
                  var23++;
               }
            }

            if (var20 == this.n) {
               var28 = var9[var19];
            }

            if (var21 == this.n) {
               var16 = var9[var19];
            }

            if (var22 == this.n) {
               var17 = var10[var19];
            }

            if (var23 == this.n) {
               var18 = var10[var19];
            }
         }

         int var35 = (var28 + var16) / 2;
         int var38 = (var17 + var18) / 2;
         int var40 = (var35 - this.t.sx + this.m.x) / 3000;
         if (var40 > this.t.ncx) {
            var40 = this.t.ncx;
         }

         if (var40 < 0) {
            var40 = 0;
         }

         int var42 = (var38 - this.t.sz + this.m.z) / 3000;
         if (var42 > this.t.ncz) {
            var42 = this.t.ncz;
         }

         if (var42 < 0) {
            var42 = 0;
         }

         for (int var44 = this.t.sect[var40][var42].length - 1; var44 >= 0; var44--) {
            int var45 = this.t.sect[var40][var42][var44];
            int var25 = 0;
            if (Math.abs(this.t.zy[var45]) != 90
               && Math.abs(this.t.xy[var45]) != 90
               && this.t.rady[var45] != 801
               && Math.abs(var35 - (this.t.x[var45] - this.m.x)) < this.t.radx[var45]
               && Math.abs(var38 - (this.t.z[var45] - this.m.z)) < this.t.radz[var45]
               && (!this.t.decor[var45] || this.m.resdown != 2)) {
               var25++;
            }

            if (var25 != 0) {
               for (int var26 = 0; var26 < this.n; var26++) {
                  var11[var26] = this.t.y[var45] - this.m.y;
                  if (this.t.zy[var45] != 0) {
                     var11[var26] = (int)(
                        var11[var26]
                           + (
                              (var10[var26] - (this.t.z[var45] - this.m.z - this.t.radz[var45]))
                                    * this.m.sin(this.t.zy[var45])
                                    / this.m.sin(90 - this.t.zy[var45])
                                 - this.t.radz[var45] * this.m.sin(this.t.zy[var45]) / this.m.sin(90 - this.t.zy[var45])
                           )
                     );
                  }

                  if (this.t.xy[var45] != 0) {
                     var11[var26] = (int)(
                        var11[var26]
                           + (
                              (var9[var26] - (this.t.x[var45] - this.m.x - this.t.radx[var45]))
                                    * this.m.sin(this.t.xy[var45])
                                    / this.m.sin(90 - this.t.xy[var45])
                                 - this.t.radx[var45] * this.m.sin(this.t.xy[var45]) / this.m.sin(90 - this.t.xy[var45])
                           )
                     );
                  }
               }

               var27 = (int)(this.t.c[var45][0] / 1.5);
               var13 = (int)(this.t.c[var45][1] / 1.5);
               var14 = (int)(this.t.c[var45][2] / 1.5);
               break;
            }
         }
      }

      boolean var29 = true;
      int[] var30 = new int[this.n];
      int[] var31 = new int[this.n];
      if (var8 == 2) {
         var27 = 87;
         var13 = 85;
         var14 = 57;
      } else {
         for (int var32 = 0; var32 < this.m.nsp; var32++) {
            for (int var36 = 0; var36 < this.n; var36++) {
               if (Math.abs(var9[var36] - this.m.spx[var32]) < this.m.sprad[var32] && Math.abs(var10[var36] - this.m.spz[var32]) < this.m.sprad[var32]) {
                  var29 = false;
               }
            }
         }
      }

      if (var29) {
         this.rot(var9, var10, this.m.cx, this.m.cz, this.m.xz, this.n);
         this.rot(var11, var10, this.m.cy, this.m.cz, this.m.zy, this.n);
         int var33 = 0;
         int var37 = 0;
         int var39 = 0;
         int var41 = 0;

         for (int var43 = 0; var43 < this.n; var43++) {
            var30[var43] = this.xs(var9[var43], var10[var43]);
            var31[var43] = this.ys(var11[var43], var10[var43]);
            if (var31[var43] < this.m.ih || var10[var43] < 10) {
               var33++;
            }

            if (var31[var43] > this.m.h || var10[var43] < 10) {
               var37++;
            }

            if (var30[var43] < this.m.iw || var10[var43] < 10) {
               var39++;
            }

            if (var30[var43] > this.m.w || var10[var43] < 10) {
               var41++;
            }
         }

         if (var39 == this.n || var33 == this.n || var37 == this.n || var41 == this.n) {
            var29 = false;
         }
      }

      if (var29) {
         for (int var34 = 0; var34 < 16; var34++) {
            if (this.av > this.m.fade[var34]) {
               var27 = (var27 * this.m.fogd + this.m.cfade[0]) / (this.m.fogd + 1);
               var13 = (var13 * this.m.fogd + this.m.cfade[1]) / (this.m.fogd + 1);
               var14 = (var14 * this.m.fogd + this.m.cfade[2]) / (this.m.fogd + 1);
            }
         }

         var1.setColor(new Color(var27, var13, var14));
         var1.fillPolygon(var30, var31, this.n);
      }
   }

   public int xs(int var1, int var2) {
      if (var2 < this.m.cz) {
         var2 = this.m.cz;
      }

      return (var2 - this.m.focus_point) * (this.m.cx - var1) / var2 + var1;
   }

   public int ys(int var1, int var2) {
      if (var2 < this.m.cz) {
         var2 = this.m.cz;
      }

      return (var2 - this.m.focus_point) * (this.m.cy - var1) / var2 + var1;
   }

   public void rot(int[] var1, int[] var2, int var3, int var4, int var5, int var6) {
      if (var5 != 0) {
         for (int var7 = 0; var7 < var6; var7++) {
            int var8 = var1[var7];
            int var9 = var2[var7];
            var1[var7] = var3 + (int)((var8 - var3) * this.m.cos(var5) - (var9 - var4) * this.m.sin(var5));
            var2[var7] = var4 + (int)((var8 - var3) * this.m.sin(var5) + (var9 - var4) * this.m.cos(var5));
         }
      }
   }

   public int spy(int var1, int var2) {
      return (int)Math.sqrt((var1 - this.m.cx) * (var1 - this.m.cx) + var2 * var2);
   }
}
