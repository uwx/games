import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.util.Random;

public class ContO {
   Medium m;
   Trackers t;
   Plane[] p;
   int npl = 0;
   int x = 0;
   int y = 0;
   int z = 0;
   int xz = 0;
   int xy = 0;
   int zy = 0;
   int wxz = 0;
   int wzy = 0;
   int dist = 0;
   int maxR = 0;
   int disp = 0;
   int disline = 14;
   boolean shadow = false;
   boolean noline = false;
   boolean decor = false;
   float grounded = 1.0F;
   int grat = 0;
   int[] keyx = new int[4];
   int[] keyz = new int[4];
   int sprkat = 0;
   int[] txy;
   int[] tzy;
   int[][] tc;
   int[] tradx;
   int[] tradz;
   int[] trady;
   int[] tx;
   int[] ty;
   int[] tz;
   int[] skd;
   int[] dam;
   boolean[] notwall;
   int tnt = 0;
   int[] stg;
   int[] sx;
   int[] sy;
   int[] sz;
   int[] scx;
   int[] scz;
   float[] osmag;
   int[] sav;
   float[][] smag;
   int[][] srgb;
   float[] sbln;
   int ust = 0;
   int srx = 0;
   int sry = 0;
   int srz = 0;
   float rcx = 0.0F;
   float rcy = 0.0F;
   float rcz = 0.0F;
   int sprk = 0;
   int[] rtg;
   boolean[] rbef;
   int[] rx;
   int[] ry;
   int[] rz;
   float[] vrx;
   float[] vry;
   float[] vrz;
   boolean elec = false;
   boolean roted = false;
   int[] edl = new int[4];
   int[] edr = new int[4];
   int[] elc = new int[]{0, 0, 0, 0};
   boolean fix = false;
   int fcnt = 0;
   int checkpoint = 0;
   int[] fcol = new int[]{0, 0, 0};
   int[] scol = new int[]{0, 0, 0};
   int colok = 0;
   boolean errd = false;
   String err = "";
   int roofat = 0;
   int wh = 0;

   public ContO(byte[] var1, Medium var2, Trackers var3) {
      this.m = var2;
      this.t = var3;
      this.p = new Plane[286];
      int[] var4 = new int[286];

      for (int var5 = 0; var5 < 286; var5++) {
         var4[var5] = 0;
      }

      if (this.m.loadnew) {
         for (int var56 = 0; var56 < 4; var56++) {
            this.keyz[var56] = 0;
         }

         this.shadow = true;
      }

      String var6 = "";
      boolean var7 = false;
      boolean var8 = false;
      int var9 = 0;
      float var10 = 1.0F;
      float var11 = 1.0F;
      float[] var12 = new float[]{1.0F, 1.0F, 1.0F};
      int[] var13 = new int[100];
      int[] var14 = new int[100];
      int[] var15 = new int[100];
      int[] var16 = new int[]{0, 0, 0};
      boolean var17 = false;
      Wheels var18 = new Wheels();
      boolean var19 = false;
      int var20 = 0;
      int var21 = 1;
      int var22 = 0;
      int var23 = 0;
      byte var24 = 0;
      byte var25 = 0;
      boolean var26 = false;
      boolean var27 = false;

      try {
         DataInputStream var28 = new DataInputStream(new ByteArrayInputStream(var1));

         String var57;
         while ((var57 = var28.readLine()) != null) {
            var6 = "" + var57.trim();
            if (this.npl < 210) {
               if (var6.startsWith("<p>")) {
                  var7 = true;
                  var9 = 0;
                  var21 = 0;
                  var22 = 0;
                  var24 = 0;
                  var4[this.npl] = 1;
                  if (!var27) {
                     var26 = false;
                  }
               }

               if (var7) {
                  if (var6.startsWith("gr(")) {
                     var21 = this.getvalue("gr", var6, 0);
                  }

                  if (var6.startsWith("fs(")) {
                     var22 = this.getvalue("fs", var6, 0);
                     var4[this.npl] = 2;
                  }

                  if (var6.startsWith("c(")) {
                     var25 = 0;
                     var16[0] = this.getvalue("c", var6, 0);
                     var16[1] = this.getvalue("c", var6, 1);
                     var16[2] = this.getvalue("c", var6, 2);
                  }

                  if (var6.startsWith("glass")) {
                     var25 = 1;
                  }

                  if (var6.startsWith("gshadow")) {
                     var25 = 2;
                  }

                  if (var6.startsWith("lightF")) {
                     var24 = 1;
                  }

                  if (var6.startsWith("light")) {
                     var24 = 1;
                  }

                  if (var6.startsWith("lightB")) {
                     var24 = 2;
                  }

                  if (var6.startsWith("noOutline")) {
                     var26 = true;
                  }

                  if (var6.startsWith("p(")) {
                     var13[var9] = (int)(this.getvalue("p", var6, 0) * var10 * var11 * var12[0]);
                     var14[var9] = (int)(this.getvalue("p", var6, 1) * var10 * var12[1]);
                     var15[var9] = (int)(this.getvalue("p", var6, 2) * var10 * var12[2]);
                     int var29 = (int)Math.sqrt(var13[var9] * var13[var9] + var14[var9] * var14[var9] + var15[var9] * var15[var9]);
                     if (var29 > this.maxR) {
                        this.maxR = var29;
                     }

                     var9++;
                  }
               }

               if (var6.startsWith("</p>")) {
                  this.p[this.npl] = new Plane(
                     this.m, this.t, var13, var15, var14, var9, var16, var25, var21, var22, 0, 0, 0, this.disline, 0, var17, var24, var26
                  );
                  if (var16[0] == this.fcol[0] && var16[1] == this.fcol[1] && var16[2] == this.fcol[2] && var25 == 0) {
                     this.p[this.npl].colnum = 1;
                  }

                  if (var16[0] == this.scol[0] && var16[1] == this.scol[1] && var16[2] == this.scol[2] && var25 == 0) {
                     this.p[this.npl].colnum = 2;
                  }

                  this.npl++;
                  var7 = false;
               }
            }

            if (var6.startsWith("rims(")) {
               var18.setrims(
                  this.getvalue("rims", var6, 0),
                  this.getvalue("rims", var6, 1),
                  this.getvalue("rims", var6, 2),
                  this.getvalue("rims", var6, 3),
                  this.getvalue("rims", var6, 4)
               );
            }

            if (var6.startsWith("w(") && var20 < 4) {
               this.keyx[var20] = (int)(this.getvalue("w", var6, 0) * var10 * var12[0]);
               this.keyz[var20] = (int)(this.getvalue("w", var6, 2) * var10 * var12[2]);
               var18.make(
                  this.m,
                  this.t,
                  this.p,
                  this.npl,
                  (int)(this.getvalue("w", var6, 0) * var10 * var11 * var12[0]),
                  (int)(this.getvalue("w", var6, 1) * var10 * var12[1]),
                  (int)(this.getvalue("w", var6, 2) * var10 * var12[2]),
                  this.getvalue("w", var6, 3),
                  (int)(this.getvalue("w", var6, 4) * var10 * var11),
                  (int)(this.getvalue("w", var6, 5) * var10),
                  var23
               );
               this.npl += 19;
               if (this.m.loadnew) {
                  this.wh = this.wh + (int)(this.getvalue("w", var6, 5) * var10);
                  if (var18.ground > 140) {
                     String var61 = "FRONT";
                     if (this.keyz[var20] < 0) {
                        var61 = "BACK";
                     }

                     this.err = "Wheels Error:\n"
                        + var61
                        + " Wheels floor is too far below the center of Y Axis of the car!    \n\nPlease decrease the Y value of the "
                        + var61
                        + " Wheels or decrease its height.     \n \n";
                     this.errd = true;
                     this.keyz[var20] = 0;
                     this.keyx[var20] = 0;
                  }

                  if (var18.ground < -100) {
                     String var62 = "FRONT";
                     if (this.keyz[var20] < 0) {
                        var62 = "BACK";
                     }

                     this.err = "Wheels Error:\n"
                        + var62
                        + " Wheels floor is too far above the center of Y Axis of the car!    \n\nPlease increase the Y value of the "
                        + var62
                        + " Wheels or increase its height.     \n \n";
                     this.errd = true;
                     this.keyz[var20] = 0;
                     this.keyx[var20] = 0;
                  }

                  if (Math.abs(this.keyx[var20]) > 400) {
                     String var63 = "FRONT";
                     if (this.keyz[var20] < 0) {
                        var63 = "BACK";
                     }

                     this.err = "Wheels Error:\n"
                        + var63
                        + " Wheels are too far apart!    \n\nPlease decrease the ±X value of the "
                        + var63
                        + " Wheels.     \n \n";
                     this.errd = true;
                     this.keyz[var20] = 0;
                     this.keyx[var20] = 0;
                  }

                  if (Math.abs(this.keyz[var20]) > 700) {
                     if (this.keyz[var20] < 0) {
                        this.err = "Wheels Error:\nBACK Wheels are too far backwards from the center of the Z Axis!    \n\nPlease increase the -Z value of the BACK Wheels.     \n \n";
                     } else {
                        this.err = "Wheels Error:\nFRONT Wheels are too far forwards from the center of the Z Axis!    \n\nPlease decrease the +Z value of the FRONT Wheels.     \n \n";
                     }

                     this.errd = true;
                     this.keyz[var20] = 0;
                     this.keyx[var20] = 0;
                  }

                  if ((int)(this.getvalue("w", var6, 4) * var10 * var11) > 300) {
                     String var64 = "FRONT";
                     if (this.keyz[var20] < 0) {
                        var64 = "BACK";
                     }

                     this.err = "Wheels Error:\nWidth of the "
                        + var64
                        + " Wheels is too large!    \n\nPlease decrease the width of the "
                        + var64
                        + " Wheels.     \n \n";
                     this.errd = true;
                     this.keyz[var20] = 0;
                     this.keyx[var20] = 0;
                  }
               }

               var20++;
            }

            if (var6.startsWith("tracks")) {
               int var65 = this.getvalue("tracks", var6, 0);
               this.txy = new int[var65];
               this.tzy = new int[var65];
               this.tc = new int[var65][3];
               this.tradx = new int[var65];
               this.tradz = new int[var65];
               this.trady = new int[var65];
               this.tx = new int[var65];
               this.ty = new int[var65];
               this.tz = new int[var65];
               this.skd = new int[var65];
               this.dam = new int[var65];
               this.notwall = new boolean[var65];
               var19 = true;
            }

            if (var19) {
               if (var6.startsWith("<track>")) {
                  var8 = true;
                  this.notwall[this.tnt] = false;
                  this.dam[this.tnt] = 1;
                  this.skd[this.tnt] = 0;
                  this.ty[this.tnt] = 0;
                  this.tx[this.tnt] = 0;
                  this.tz[this.tnt] = 0;
                  this.txy[this.tnt] = 0;
                  this.tzy[this.tnt] = 0;
                  this.trady[this.tnt] = 0;
                  this.tradx[this.tnt] = 0;
                  this.tradz[this.tnt] = 0;
                  this.tc[this.tnt][0] = 0;
                  this.tc[this.tnt][1] = 0;
                  this.tc[this.tnt][2] = 0;
               }

               if (var8) {
                  if (var6.startsWith("c")) {
                     this.tc[this.tnt][0] = this.getvalue("c", var6, 0);
                     this.tc[this.tnt][1] = this.getvalue("c", var6, 1);
                     this.tc[this.tnt][2] = this.getvalue("c", var6, 2);
                  }

                  if (var6.startsWith("xy")) {
                     this.txy[this.tnt] = this.getvalue("xy", var6, 0);
                  }

                  if (var6.startsWith("zy")) {
                     this.tzy[this.tnt] = this.getvalue("zy", var6, 0);
                  }

                  if (var6.startsWith("radx")) {
                     this.tradx[this.tnt] = (int)(this.getvalue("radx", var6, 0) * var10);
                  }

                  if (var6.startsWith("rady")) {
                     this.trady[this.tnt] = (int)(this.getvalue("rady", var6, 0) * var10);
                  }

                  if (var6.startsWith("radz")) {
                     this.tradz[this.tnt] = (int)(this.getvalue("radz", var6, 0) * var10);
                  }

                  if (var6.startsWith("ty")) {
                     this.ty[this.tnt] = (int)(this.getvalue("ty", var6, 0) * var10);
                  }

                  if (var6.startsWith("tx")) {
                     this.tx[this.tnt] = (int)(this.getvalue("tx", var6, 0) * var10);
                  }

                  if (var6.startsWith("tz")) {
                     this.tz[this.tnt] = (int)(this.getvalue("tz", var6, 0) * var10);
                  }

                  if (var6.startsWith("skid")) {
                     this.skd[this.tnt] = this.getvalue("skid", var6, 0);
                  }

                  if (var6.startsWith("dam")) {
                     this.dam[this.tnt] = 3;
                  }

                  if (var6.startsWith("notwall")) {
                     this.notwall[this.tnt] = true;
                  }
               }

               if (var6.startsWith("</track>")) {
                  var8 = false;
                  this.tnt++;
               }
            }

            if (var6.startsWith("disp(")) {
               this.disp = this.getvalue("disp", var6, 0);
            }

            if (var6.startsWith("disline(")) {
               this.disline = this.getvalue("disline", var6, 0) * 2;
            }

            if (var6.startsWith("shadow")) {
               this.shadow = true;
            }

            if (var6.startsWith("stonecold")) {
               this.noline = true;
            }

            if (var6.startsWith("newstone")) {
               this.noline = true;
               var26 = true;
               var27 = true;
            }

            if (var6.startsWith("decorative")) {
               this.decor = true;
            }

            if (var6.startsWith("road")) {
               var17 = true;
            }

            if (var6.startsWith("notroad")) {
               var17 = false;
            }

            if (var6.startsWith("grounded(")) {
               this.grounded = this.getvalue("grounded", var6, 0) / 100.0F;
            }

            if (var6.startsWith("div(")) {
               var10 = this.getvalue("div", var6, 0) / 10.0F;
            }

            if (var6.startsWith("idiv(")) {
               var10 = this.getvalue("idiv", var6, 0) / 100.0F;
            }

            if (var6.startsWith("iwid(")) {
               var11 = this.getvalue("iwid", var6, 0) / 100.0F;
            }

            if (var6.startsWith("ScaleX(")) {
               var12[0] = this.getvalue("ScaleX", var6, 0) / 100.0F;
            }

            if (var6.startsWith("ScaleY(")) {
               var12[1] = this.getvalue("ScaleY", var6, 0) / 100.0F;
            }

            if (var6.startsWith("ScaleZ(")) {
               var12[2] = this.getvalue("ScaleZ", var6, 0) / 100.0F;
            }

            if (var6.startsWith("gwgr(")) {
               var23 = this.getvalue("gwgr", var6, 0);
               if (this.m.loadnew) {
                  if (var23 > 40) {
                     var23 = 40;
                  }

                  if (var23 < 0 && var23 >= -15) {
                     var23 = -16;
                  }

                  if (var23 < -40) {
                     var23 = -40;
                  }
               }
            }

            if (var6.startsWith("1stColor(")) {
               this.fcol[0] = this.getvalue("1stColor", var6, 0);
               this.fcol[1] = this.getvalue("1stColor", var6, 1);
               this.fcol[2] = this.getvalue("1stColor", var6, 2);
               this.colok++;
            }

            if (var6.startsWith("2ndColor(")) {
               this.scol[0] = this.getvalue("2ndColor", var6, 0);
               this.scol[1] = this.getvalue("2ndColor", var6, 1);
               this.scol[2] = this.getvalue("2ndColor", var6, 2);
               this.colok++;
            }
         }

         var28.close();
      } catch (Exception var55) {
         if (!this.errd) {
            this.err = "Error While Loading 3D Model\n\nLine:     " + var6 + "\n\nError Detail:\n" + var55 + "           \n \n";
            System.out.println(this.err);
            this.errd = true;
         }
      }

      this.grat = var18.ground;
      this.sprkat = var18.sparkat;
      if (this.shadow) {
         this.stg = new int[20];
         this.rtg = new int[100];

         for (int var58 = 0; var58 < 20; var58++) {
            this.stg[var58] = 0;
         }

         for (int var59 = 0; var59 < 100; var59++) {
            this.rtg[var59] = 0;
         }
      }

      if (this.m.loadnew) {
         if (var20 != 0) {
            this.wh /= var20;
         }

         boolean var60 = false;

         for (int var66 = 0; var66 < this.npl; var66++) {
            byte var30 = 0;
            int var31 = this.p[var66].ox[0];
            int var32 = this.p[var66].ox[0];
            int var33 = this.p[var66].oy[0];
            int var34 = this.p[var66].oy[0];
            int var35 = this.p[var66].oz[0];
            int var36 = this.p[var66].oz[0];

            for (int var37 = 0; var37 < this.p[var66].n; var37++) {
               if (this.p[var66].ox[var37] > var31) {
                  var31 = this.p[var66].ox[var37];
               }

               if (this.p[var66].ox[var37] < var32) {
                  var32 = this.p[var66].ox[var37];
               }

               if (this.p[var66].oy[var37] > var33) {
                  var33 = this.p[var66].oy[var37];
               }

               if (this.p[var66].oy[var37] < var34) {
                  var34 = this.p[var66].oy[var37];
               }

               if (this.p[var66].oz[var37] > var35) {
                  var35 = this.p[var66].oz[var37];
               }

               if (this.p[var66].oz[var37] < var36) {
                  var36 = this.p[var66].oz[var37];
               }
            }

            if (Math.abs(var31 - var32) <= Math.abs(var33 - var34) && Math.abs(var31 - var32) <= Math.abs(var35 - var36)) {
               var30 = 1;
            }

            if (Math.abs(var33 - var34) <= Math.abs(var31 - var32) && Math.abs(var33 - var34) <= Math.abs(var35 - var36)) {
               var30 = 2;
            }

            if (Math.abs(var35 - var36) <= Math.abs(var31 - var32) && Math.abs(var35 - var36) <= Math.abs(var33 - var34)) {
               var30 = 3;
            }

            if (var30 == 2 && (!var60 || (var33 + var34) / 2 < this.roofat)) {
               this.roofat = (var33 + var34) / 2;
               var60 = true;
            }

            if (var4[var66] == 1) {
               int var67 = 1000;
               int var38 = 0;

               for (int var39 = 0; var39 < this.p[var66].n; var39++) {
                  int var40 = var39 + 1;
                  if (var40 >= this.p[var66].n) {
                     var40 -= this.p[var66].n;
                  }

                  int var41 = var39 + 2;
                  if (var41 >= this.p[var66].n) {
                     var41 -= this.p[var66].n;
                  }

                  if (var30 == 1) {
                     int var42 = Math.abs(
                        (int)(
                           Math.atan((double)(this.p[var66].oz[var39] - this.p[var66].oz[var40]) / (this.p[var66].oy[var39] - this.p[var66].oy[var40]))
                              / (Math.PI / 180.0)
                        )
                     );
                     int var43 = Math.abs(
                        (int)(
                           Math.atan((double)(this.p[var66].oz[var41] - this.p[var66].oz[var40]) / (this.p[var66].oy[var41] - this.p[var66].oy[var40]))
                              / (Math.PI / 180.0)
                        )
                     );
                     if (var42 > 45) {
                        var42 = 90 - var42;
                     } else {
                        var43 = 90 - var43;
                     }

                     if (var42 + var43 < var67) {
                        var67 = var42 + var43;
                        var38 = var39;
                     }
                  }

                  if (var30 == 2) {
                     int var75 = Math.abs(
                        (int)(
                           Math.atan((double)(this.p[var66].oz[var39] - this.p[var66].oz[var40]) / (this.p[var66].ox[var39] - this.p[var66].ox[var40]))
                              / (Math.PI / 180.0)
                        )
                     );
                     int var81 = Math.abs(
                        (int)(
                           Math.atan((double)(this.p[var66].oz[var41] - this.p[var66].oz[var40]) / (this.p[var66].ox[var41] - this.p[var66].ox[var40]))
                              / (Math.PI / 180.0)
                        )
                     );
                     if (var75 > 45) {
                        var75 = 90 - var75;
                     } else {
                        var81 = 90 - var81;
                     }

                     if (var75 + var81 < var67) {
                        var67 = var75 + var81;
                        var38 = var39;
                     }
                  }

                  if (var30 == 3) {
                     int var76 = Math.abs(
                        (int)(
                           Math.atan((double)(this.p[var66].oy[var39] - this.p[var66].oy[var40]) / (this.p[var66].ox[var39] - this.p[var66].ox[var40]))
                              / (Math.PI / 180.0)
                        )
                     );
                     int var82 = Math.abs(
                        (int)(
                           Math.atan((double)(this.p[var66].oy[var41] - this.p[var66].oy[var40]) / (this.p[var66].ox[var41] - this.p[var66].ox[var40]))
                              / (Math.PI / 180.0)
                        )
                     );
                     if (var76 > 45) {
                        var76 = 90 - var76;
                     } else {
                        var82 = 90 - var82;
                     }

                     if (var76 + var82 < var67) {
                        var67 = var76 + var82;
                        var38 = var39;
                     }
                  }
               }

               if (var38 != 0) {
                  int[] var68 = new int[this.p[var66].n];
                  int[] var70 = new int[this.p[var66].n];
                  int[] var72 = new int[this.p[var66].n];

                  for (int var77 = 0; var77 < this.p[var66].n; var77++) {
                     var68[var77] = this.p[var66].ox[var77];
                     var70[var77] = this.p[var66].oy[var77];
                     var72[var77] = this.p[var66].oz[var77];
                  }

                  for (int var78 = 0; var78 < this.p[var66].n; var78++) {
                     int var83 = var78 + var38;
                     if (var83 >= this.p[var66].n) {
                        var83 -= this.p[var66].n;
                     }

                     this.p[var66].ox[var78] = var68[var83];
                     this.p[var66].oy[var78] = var70[var83];
                     this.p[var66].oz[var78] = var72[var83];
                  }
               }

               if (var30 == 1) {
                  if (Math.abs(this.p[var66].oz[0] - this.p[var66].oz[1]) > Math.abs(this.p[var66].oy[0] - this.p[var66].oy[1])) {
                     if (this.p[var66].oz[0] > this.p[var66].oz[1]) {
                        if (this.p[var66].oy[1] > this.p[var66].oy[2]) {
                           this.p[var66].fs = 1;
                        } else {
                           this.p[var66].fs = -1;
                        }
                     } else if (this.p[var66].oy[1] > this.p[var66].oy[2]) {
                        this.p[var66].fs = -1;
                     } else {
                        this.p[var66].fs = 1;
                     }
                  } else if (this.p[var66].oy[0] > this.p[var66].oy[1]) {
                     if (this.p[var66].oz[1] > this.p[var66].oz[2]) {
                        this.p[var66].fs = -1;
                     } else {
                        this.p[var66].fs = 1;
                     }
                  } else if (this.p[var66].oz[1] > this.p[var66].oz[2]) {
                     this.p[var66].fs = 1;
                  } else {
                     this.p[var66].fs = -1;
                  }
               }

               if (var30 == 2) {
                  if (Math.abs(this.p[var66].oz[0] - this.p[var66].oz[1]) > Math.abs(this.p[var66].ox[0] - this.p[var66].ox[1])) {
                     if (this.p[var66].oz[0] > this.p[var66].oz[1]) {
                        if (this.p[var66].ox[1] > this.p[var66].ox[2]) {
                           this.p[var66].fs = -1;
                        } else {
                           this.p[var66].fs = 1;
                        }
                     } else if (this.p[var66].ox[1] > this.p[var66].ox[2]) {
                        this.p[var66].fs = 1;
                     } else {
                        this.p[var66].fs = -1;
                     }
                  } else if (this.p[var66].ox[0] > this.p[var66].ox[1]) {
                     if (this.p[var66].oz[1] > this.p[var66].oz[2]) {
                        this.p[var66].fs = 1;
                     } else {
                        this.p[var66].fs = -1;
                     }
                  } else if (this.p[var66].oz[1] > this.p[var66].oz[2]) {
                     this.p[var66].fs = -1;
                  } else {
                     this.p[var66].fs = 1;
                  }
               }

               if (var30 == 3) {
                  if (Math.abs(this.p[var66].oy[0] - this.p[var66].oy[1]) > Math.abs(this.p[var66].ox[0] - this.p[var66].ox[1])) {
                     if (this.p[var66].oy[0] > this.p[var66].oy[1]) {
                        if (this.p[var66].ox[1] > this.p[var66].ox[2]) {
                           this.p[var66].fs = 1;
                        } else {
                           this.p[var66].fs = -1;
                        }
                     } else if (this.p[var66].ox[1] > this.p[var66].ox[2]) {
                        this.p[var66].fs = -1;
                     } else {
                        this.p[var66].fs = 1;
                     }
                  } else if (this.p[var66].ox[0] > this.p[var66].ox[1]) {
                     if (this.p[var66].oy[1] > this.p[var66].oy[2]) {
                        this.p[var66].fs = -1;
                     } else {
                        this.p[var66].fs = 1;
                     }
                  } else if (this.p[var66].oy[1] > this.p[var66].oy[2]) {
                     this.p[var66].fs = 1;
                  } else {
                     this.p[var66].fs = -1;
                  }
               }

               boolean var69 = false;
               boolean var71 = false;

               for (int var73 = 0; var73 < this.npl; var73++) {
                  if (var73 != var66 && var4[var73] != 0) {
                     boolean var79 = false;
                     int var84 = this.p[var73].ox[0];
                     int var44 = this.p[var73].ox[0];
                     int var45 = this.p[var73].oy[0];
                     int var46 = this.p[var73].oy[0];
                     int var47 = this.p[var73].oz[0];
                     int var48 = this.p[var73].oz[0];

                     for (int var49 = 0; var49 < this.p[var73].n; var49++) {
                        if (this.p[var73].ox[var49] > var84) {
                           var84 = this.p[var73].ox[var49];
                        }

                        if (this.p[var73].ox[var49] < var44) {
                           var44 = this.p[var73].ox[var49];
                        }

                        if (this.p[var73].oy[var49] > var45) {
                           var45 = this.p[var73].oy[var49];
                        }

                        if (this.p[var73].oy[var49] < var46) {
                           var46 = this.p[var73].oy[var49];
                        }

                        if (this.p[var73].oz[var49] > var47) {
                           var47 = this.p[var73].oz[var49];
                        }

                        if (this.p[var73].oz[var49] < var48) {
                           var48 = this.p[var73].oz[var49];
                        }
                     }

                     int var92 = (var84 + var44) / 2;
                     int var50 = (var45 + var46) / 2;
                     int var51 = (var47 + var48) / 2;
                     int var52 = (var31 + var32) / 2;
                     int var53 = (var33 + var34) / 2;
                     int var54 = (var35 + var36) / 2;
                     if (var30 == 1
                        && (
                           var50 <= var33 && var50 >= var34 && var51 <= var35 && var51 >= var36
                              || var53 <= var45 && var53 >= var46 && var54 <= var47 && var54 >= var48
                        )) {
                        if (var84 < var32) {
                           var69 = true;
                        }

                        if (var44 > var31) {
                           var71 = true;
                        }
                     }

                     if (var30 == 2
                        && (
                           var92 <= var31 && var92 >= var32 && var51 <= var35 && var51 >= var36
                              || var52 <= var84 && var52 >= var44 && var54 <= var47 && var54 >= var48
                        )) {
                        if (var45 < var34) {
                           var69 = true;
                        }

                        if (var46 > var33) {
                           var71 = true;
                        }
                     }

                     if (var30 == 3
                        && (
                           var92 <= var31 && var92 >= var32 && var50 <= var33 && var50 >= var34
                              || var52 <= var84 && var52 >= var44 && var53 <= var45 && var53 >= var46
                        )) {
                        if (var47 < var36) {
                           var69 = true;
                        }

                        if (var48 > var35) {
                           var71 = true;
                        }
                     }
                  }

                  if (var69 && var71) {
                     break;
                  }
               }

               boolean var74 = false;
               if (var69 && !var71) {
                  var74 = true;
               }

               if (var71 && !var69) {
                  this.p[var66].fs *= -1;
                  var74 = true;
               }

               if (var69 && var71) {
                  this.p[var66].fs = 0;
                  this.p[var66].gr = 40;
                  var74 = true;
               }

               if (!var74) {
                  int var80 = 0;
                  int var85 = 0;
                  if (var30 == 1) {
                     var80 = (var31 + var32) / 2;
                     var85 = var80;
                  }

                  if (var30 == 2) {
                     var80 = (var33 + var34) / 2;
                     var85 = var80;
                  }

                  if (var30 == 3) {
                     var80 = (var35 + var36) / 2;
                     var85 = var80;
                  }

                  for (int var86 = 0; var86 < this.npl; var86++) {
                     if (var86 != var66) {
                        boolean var87 = false;
                        boolean[] var88 = new boolean[this.p[var86].n];

                        for (int var89 = 0; var89 < this.p[var86].n; var89++) {
                           var88[var89] = false;

                           for (int var91 = 0; var91 < this.p[var66].n; var91++) {
                              if (this.p[var66].ox[var91] == this.p[var86].ox[var89]
                                 && this.p[var66].oy[var91] == this.p[var86].oy[var89]
                                 && this.p[var66].oz[var91] == this.p[var86].oz[var89]) {
                                 var88[var89] = true;
                                 var87 = true;
                              }
                           }
                        }

                        if (var87) {
                           for (int var90 = 0; var90 < this.p[var86].n; var90++) {
                              if (!var88[var90]) {
                                 if (var30 == 1) {
                                    if (this.p[var86].ox[var90] > var80) {
                                       var80 = this.p[var86].ox[var90];
                                    }

                                    if (this.p[var86].ox[var90] < var85) {
                                       var85 = this.p[var86].ox[var90];
                                    }
                                 }

                                 if (var30 == 2) {
                                    if (this.p[var86].oy[var90] > var80) {
                                       var80 = this.p[var86].oy[var90];
                                    }

                                    if (this.p[var86].oy[var90] < var85) {
                                       var85 = this.p[var86].oy[var90];
                                    }
                                 }

                                 if (var30 == 3) {
                                    if (this.p[var86].oz[var90] > var80) {
                                       var80 = this.p[var86].oz[var90];
                                    }

                                    if (this.p[var86].oz[var90] < var85) {
                                       var85 = this.p[var86].oz[var90];
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }

                  if (var30 == 1) {
                     if ((var80 + var85) / 2 > (var31 + var32) / 2) {
                        this.p[var66].fs *= -1;
                     } else if ((var80 + var85) / 2 == (var31 + var32) / 2 && (var31 + var32) / 2 < 0) {
                        this.p[var66].fs *= -1;
                     }
                  }

                  if (var30 == 2) {
                     if ((var80 + var85) / 2 > (var33 + var34) / 2) {
                        this.p[var66].fs *= -1;
                     } else if ((var80 + var85) / 2 == (var33 + var34) / 2 && (var33 + var34) / 2 < 0) {
                        this.p[var66].fs *= -1;
                     }
                  }

                  if (var30 == 3) {
                     if ((var80 + var85) / 2 > (var35 + var36) / 2) {
                        this.p[var66].fs *= -1;
                     } else if ((var80 + var85) / 2 == (var35 + var36) / 2 && (var35 + var36) / 2 < 0) {
                        this.p[var66].fs *= -1;
                     }
                  }
               }

               this.p[var66].deltafntyp();
            }
         }
      }
   }

   public ContO(ContO var1, int var2, int var3, int var4, int var5) {
      this.m = var1.m;
      this.t = var1.t;
      this.npl = var1.npl;
      this.maxR = var1.maxR;
      this.disp = var1.disp;
      this.disline = var1.disline;
      this.noline = var1.noline;
      this.shadow = var1.shadow;
      this.grounded = var1.grounded;
      this.decor = var1.decor;
      if (this.m.loadnew && (var5 == 90 || var5 == -90)) {
         this.grounded += 10000.0F;
      }

      this.grat = var1.grat;
      this.sprkat = var1.sprkat;
      this.p = new Plane[var1.npl];

      for (int var6 = 0; var6 < this.npl; var6++) {
         if (var1.p[var6].master == 1) {
            var1.p[var6].n = 20;
         }

         this.p[var6] = new Plane(
            this.m,
            this.t,
            var1.p[var6].ox,
            var1.p[var6].oz,
            var1.p[var6].oy,
            var1.p[var6].n,
            var1.p[var6].oc,
            var1.p[var6].glass,
            var1.p[var6].gr,
            var1.p[var6].fs,
            var1.p[var6].wx,
            var1.p[var6].wy,
            var1.p[var6].wz,
            var1.disline,
            var1.p[var6].bfase,
            var1.p[var6].road,
            var1.p[var6].light,
            var1.p[var6].solo
         );
      }

      this.x = var2;
      this.y = var3;
      this.z = var4;
      this.xz = 0;
      this.xy = 0;
      this.zy = 0;

      for (int var8 = 0; var8 < this.npl; var8++) {
         this.p[var8].colnum = var1.p[var8].colnum;
         this.p[var8].master = var1.p[var8].master;
         this.p[var8].rot(this.p[var8].ox, this.p[var8].oz, 0, 0, var5, this.p[var8].n);
         this.p[var8].loadprojf();
      }

      if (var1.tnt != 0) {
         for (int var9 = 0; var9 < var1.tnt; var9++) {
            this.t.xy[this.t.nt] = (int)(var1.txy[var9] * this.m.cos(var5) - var1.tzy[var9] * this.m.sin(var5));
            this.t.zy[this.t.nt] = (int)(var1.tzy[var9] * this.m.cos(var5) + var1.txy[var9] * this.m.sin(var5));

            for (int var7 = 0; var7 < 3; var7++) {
               this.t.c[this.t.nt][var7] = (int)(var1.tc[var9][var7] + var1.tc[var9][var7] * (this.m.snap[var7] / 100.0F));
               if (this.t.c[this.t.nt][var7] > 255) {
                  this.t.c[this.t.nt][var7] = 255;
               }

               if (this.t.c[this.t.nt][var7] < 0) {
                  this.t.c[this.t.nt][var7] = 0;
               }
            }

            this.t.x[this.t.nt] = (int)(this.x + var1.tx[var9] * this.m.cos(var5) - var1.tz[var9] * this.m.sin(var5));
            this.t.z[this.t.nt] = (int)(this.z + var1.tz[var9] * this.m.cos(var5) + var1.tx[var9] * this.m.sin(var5));
            this.t.y[this.t.nt] = this.y + var1.ty[var9];
            this.t.skd[this.t.nt] = var1.skd[var9];
            this.t.dam[this.t.nt] = var1.dam[var9];
            this.t.notwall[this.t.nt] = var1.notwall[var9];
            if (this.decor) {
               this.t.decor[this.t.nt] = true;
            } else {
               this.t.decor[this.t.nt] = false;
            }

            int var13 = Math.abs(var5);
            if (var13 == 180) {
               var13 = 0;
            }

            this.t.radx[this.t.nt] = (int)Math.abs(var1.tradx[var9] * this.m.cos(var13) + var1.tradz[var9] * this.m.sin(var13));
            this.t.radz[this.t.nt] = (int)Math.abs(var1.tradx[var9] * this.m.sin(var13) + var1.tradz[var9] * this.m.cos(var13));
            this.t.rady[this.t.nt] = var1.trady[var9];
            this.t.nt++;
         }
      }

      for (int var10 = 0; var10 < 4; var10++) {
         this.keyx[var10] = var1.keyx[var10];
         this.keyz[var10] = var1.keyz[var10];
      }

      if (this.shadow) {
         this.stg = new int[20];
         this.sx = new int[20];
         this.sy = new int[20];
         this.sz = new int[20];
         this.scx = new int[20];
         this.scz = new int[20];
         this.osmag = new float[20];
         this.sav = new int[20];
         this.smag = new float[20][8];
         this.srgb = new int[20][3];
         this.sbln = new float[20];
         this.ust = 0;

         for (int var11 = 0; var11 < 20; var11++) {
            this.stg[var11] = 0;
         }

         this.rtg = new int[100];
         this.rbef = new boolean[100];
         this.rx = new int[100];
         this.ry = new int[100];
         this.rz = new int[100];
         this.vrx = new float[100];
         this.vry = new float[100];
         this.vrz = new float[100];

         for (int var12 = 0; var12 < 100; var12++) {
            this.rtg[var12] = 0;
         }
      }
   }

   public ContO(int var1, int var2, int var3, Medium var4, Trackers var5, int var6, int var7, int var8) {
      this.m = var4;
      this.t = var5;
      this.x = var6;
      this.z = var7;
      this.y = var8;
      this.xz = 0;
      this.xy = 0;
      this.zy = 0;
      this.grat = 0;
      this.sprkat = 0;
      this.disline = 4;
      this.noline = true;
      this.shadow = false;
      this.grounded = 115.0F;
      this.decor = true;
      this.npl = 5;
      this.p = new Plane[5];
      Random var9 = new Random(var1);
      int[] var10 = new int[8];
      int[] var11 = new int[8];
      int[] var12 = new int[8];
      int[] var13 = new int[8];
      int[] var14 = new int[8];
      float var15 = var2;
      float var16 = var3;
      if (var16 < 2.0F) {
         var16 = 2.0F;
      }

      if (var16 > 6.0F) {
         var16 = 6.0F;
      }

      if (var15 < 2.0F) {
         var15 = 2.0F;
      }

      if (var15 > 6.0F) {
         var15 = 6.0F;
      }

      var15 /= 1.5F;
      var16 /= 1.5F;
      var16 *= 1.0F + (var15 - 2.0F) * 0.1786F;
      float var17 = (float)(50.0 + 100.0 * var9.nextDouble());
      var10[0] = -((int)(var17 * var15 * 0.7071F));
      var11[0] = (int)(var17 * var15 * 0.7071F);
      var17 = (float)(50.0 + 100.0 * var9.nextDouble());
      var10[1] = 0;
      var11[1] = (int)(var17 * var15);
      var17 = (float)(50.0 + 100.0 * var9.nextDouble());
      var10[2] = (int)(var17 * var15 * 0.7071);
      var11[2] = (int)(var17 * var15 * 0.7071);
      var17 = (float)(50.0 + 100.0 * var9.nextDouble());
      var10[3] = (int)(var17 * var15);
      var11[3] = 0;
      var17 = (float)(50.0 + 100.0 * var9.nextDouble());
      var10[4] = (int)(var17 * var15 * 0.7071);
      var11[4] = -((int)(var17 * var15 * 0.7071));
      var17 = (float)(50.0 + 100.0 * var9.nextDouble());
      var10[5] = 0;
      var11[5] = -((int)(var17 * var15));
      var17 = (float)(50.0 + 100.0 * var9.nextDouble());
      var10[6] = -((int)(var17 * var15 * 0.7071));
      var11[6] = -((int)(var17 * var15 * 0.7071));
      var17 = (float)(50.0 + 100.0 * var9.nextDouble());
      var10[7] = -((int)(var17 * var15));
      var11[7] = 0;

      for (int var18 = 0; var18 < 8; var18++) {
         var12[var18] = (int)(var10[var18] * (0.2 + 0.4 * var9.nextDouble()));
         var13[var18] = (int)(var11[var18] * (0.2 + 0.4 * var9.nextDouble()));
         var14[var18] = -((int)((10.0 + 15.0 * var9.nextDouble()) * var16));
      }

      this.maxR = 0;

      for (int var40 = 0; var40 < 8; var40++) {
         int var19 = var40 - 1;
         if (var19 == -1) {
            var19 = 7;
         }

         int var20 = var40 + 1;
         if (var20 == 8) {
            var20 = 0;
         }

         var10[var40] = ((var10[var19] + var10[var20]) / 2 + var10[var40]) / 2;
         var11[var40] = ((var11[var19] + var11[var20]) / 2 + var11[var40]) / 2;
         var12[var40] = ((var12[var19] + var12[var20]) / 2 + var12[var40]) / 2;
         var13[var40] = ((var13[var19] + var13[var20]) / 2 + var13[var40]) / 2;
         var14[var40] = ((var14[var19] + var14[var20]) / 2 + var14[var40]) / 2;
         int var21 = (int)Math.sqrt(var10[var40] * var10[var40] + var11[var40] * var11[var40]);
         if (var21 > this.maxR) {
            this.maxR = var21;
         }

         var21 = (int)Math.sqrt(var12[var40] * var12[var40] + var14[var40] * var14[var40] + var13[var40] * var13[var40]);
         if (var21 > this.maxR) {
            this.maxR = var21;
         }
      }

      this.disp = this.maxR / 17;
      int[] var41 = new int[3];
      float var42 = -1.0F;
      float var43 = (var15 / var16 - 0.33F) / 33.4F;
      if (var43 < 0.005) {
         var43 = 0.0F;
      }

      if (var43 > 0.057) {
         var43 = 0.057F;
      }

      for (int var45 = 0; var45 < 4; var45++) {
         int var22 = var45 * 2;
         int var23 = var22 + 2;
         if (var23 == 8) {
            var23 = 0;
         }

         int[] var24 = new int[6];
         int[] var25 = new int[6];
         int[] var26 = new int[6];
         var24[0] = var10[var22];
         var24[1] = var10[var22 + 1];
         var24[2] = var10[var23];
         var24[5] = var12[var22];
         var24[4] = var12[var22 + 1];
         var24[3] = var12[var23];
         var26[0] = var11[var22];
         var26[1] = var11[var22 + 1];
         var26[2] = var11[var23];
         var26[5] = var13[var22];
         var26[4] = var13[var22 + 1];
         var26[3] = var13[var23];
         var25[0] = 0;
         var25[1] = 0;
         var25[2] = 0;
         var25[5] = var14[var22];
         var25[4] = var14[var22 + 1];
         var25[3] = var14[var23];
         var17 = (float)((0.17 - var43) * var9.nextDouble());

         while (Math.abs(var42 - var17) < 0.03 - var43 * 0.176F) {
            var17 = (float)((0.17 - var43) * var9.nextDouble());
         }

         var42 = var17;

         for (int var27 = 0; var27 < 3; var27++) {
            if (this.m.trk == 2) {
               var41[var27] = (int)(390.0F / (2.2F + var17 - var43));
            } else {
               var41[var27] = (int)((this.m.cpol[var27] + this.m.cgrnd[var27]) / (2.2F + var17 - var43));
            }
         }

         this.p[var45] = new Plane(this.m, this.t, var24, var26, var25, 6, var41, 3, -8, 0, 0, 0, 0, this.disline, 0, true, 0, false);
      }

      var17 = (float)(0.02 * var9.nextDouble());

      for (int var46 = 0; var46 < 3; var46++) {
         if (this.m.trk == 2) {
            var41[var46] = (int)(390.0F / (2.15F + var17));
         } else {
            var41[var46] = (int)((this.m.cpol[var46] + this.m.cgrnd[var46]) / (2.15F + var17));
         }
      }

      this.p[4] = new Plane(this.m, this.t, var12, var13, var14, 8, var41, 3, -8, 0, 0, 0, 0, this.disline, 0, true, 0, false);
      int[] var47 = new int[2];
      int[] var48 = new int[2];

      for (int var49 = 0; var49 < 4; var49++) {
         int var52 = var49 * 2 + 1;
         this.t.y[this.t.nt] = var14[var52] / 2;
         this.t.rady[this.t.nt] = Math.abs(var14[var52] / 2);
         if (var49 != 0 && var49 != 2) {
            this.t.x[this.t.nt] = (var10[var52] + var12[var52]) / 2;
            this.t.radx[this.t.nt] = Math.abs(this.t.x[this.t.nt] - var10[var52]);
            var52 = var49 * 2 + 2;
            if (var52 == 8) {
               var52 = 0;
            }

            this.t.z[this.t.nt] = (var11[var49 * 2] + var11[var52]) / 2;
            this.t.radz[this.t.nt] = Math.abs(this.t.z[this.t.nt] - var11[var49 * 2]);
         } else {
            this.t.z[this.t.nt] = (var11[var52] + var13[var52]) / 2;
            this.t.radz[this.t.nt] = Math.abs(this.t.z[this.t.nt] - var11[var52]);
            var52 = var49 * 2 + 2;
            if (var52 == 8) {
               var52 = 0;
            }

            this.t.x[this.t.nt] = (var10[var49 * 2] + var10[var52]) / 2;
            this.t.radx[this.t.nt] = Math.abs(this.t.x[this.t.nt] - var10[var49 * 2]);
         }

         if (var49 == 0) {
            var48[0] = this.t.z[this.t.nt] - this.t.radz[this.t.nt];
            this.t.zy[this.t.nt] = (int)(Math.atan((double)this.t.rady[this.t.nt] / this.t.radz[this.t.nt]) / (Math.PI / 180.0));
            if (this.t.zy[this.t.nt] > 40) {
               this.t.zy[this.t.nt] = 40;
            }

            this.t.xy[this.t.nt] = 0;
         }

         if (var49 == 1) {
            var47[0] = this.t.x[this.t.nt] - this.t.radx[this.t.nt];
            this.t.xy[this.t.nt] = (int)(Math.atan((double)this.t.rady[this.t.nt] / this.t.radx[this.t.nt]) / (Math.PI / 180.0));
            if (this.t.xy[this.t.nt] > 40) {
               this.t.xy[this.t.nt] = 40;
            }

            this.t.zy[this.t.nt] = 0;
         }

         if (var49 == 2) {
            var48[1] = this.t.z[this.t.nt] + this.t.radz[this.t.nt];
            this.t.zy[this.t.nt] = -((int)(Math.atan((double)this.t.rady[this.t.nt] / this.t.radz[this.t.nt]) / (Math.PI / 180.0)));
            if (this.t.zy[this.t.nt] < -40) {
               this.t.zy[this.t.nt] = -40;
            }

            this.t.xy[this.t.nt] = 0;
         }

         if (var49 == 3) {
            var47[1] = this.t.x[this.t.nt] + this.t.radx[this.t.nt];
            this.t.xy[this.t.nt] = -((int)(Math.atan((double)this.t.rady[this.t.nt] / this.t.radx[this.t.nt]) / (Math.PI / 180.0)));
            if (this.t.xy[this.t.nt] < -40) {
               this.t.xy[this.t.nt] = -40;
            }

            this.t.zy[this.t.nt] = 0;
         }

         this.t.x[this.t.nt] = this.t.x[this.t.nt] + this.x;
         this.t.z[this.t.nt] = this.t.z[this.t.nt] + this.z;
         this.t.y[this.t.nt] = this.t.y[this.t.nt] + this.y;

         for (int var55 = 0; var55 < 3; var55++) {
            this.t.c[this.t.nt][var55] = this.p[var49].oc[var55];
         }

         this.t.skd[this.t.nt] = 2;
         this.t.dam[this.t.nt] = 1;
         this.t.notwall[this.t.nt] = false;
         this.t.decor[this.t.nt] = true;
         this.t.rady[this.t.nt] = this.t.rady[this.t.nt] + 10;
         this.t.nt++;
      }

      this.t.y[this.t.nt] = 0;

      for (int var50 = 0; var50 < 8; var50++) {
         this.t.y[this.t.nt] = this.t.y[this.t.nt] + var14[var50];
      }

      this.t.y[this.t.nt] = this.t.y[this.t.nt] / 8;
      this.t.y[this.t.nt] = this.t.y[this.t.nt] + this.y;
      this.t.rady[this.t.nt] = 200;
      this.t.radx[this.t.nt] = var47[0] - var47[1];
      this.t.radz[this.t.nt] = var48[0] - var48[1];
      this.t.x[this.t.nt] = (var47[0] + var47[1]) / 2 + this.x;
      this.t.z[this.t.nt] = (var48[0] + var48[1]) / 2 + this.z;
      this.t.zy[this.t.nt] = 0;
      this.t.xy[this.t.nt] = 0;

      for (int var51 = 0; var51 < 3; var51++) {
         this.t.c[this.t.nt][var51] = this.p[4].oc[var51];
      }

      this.t.skd[this.t.nt] = 4;
      this.t.dam[this.t.nt] = 1;
      this.t.notwall[this.t.nt] = false;
      this.t.decor[this.t.nt] = true;
      this.t.nt++;
   }

   public void d(Graphics2D var1) {
      if (this.dist != 0) {
         this.dist = 0;
      }

      int var2 = this.m.cx + (int)((this.x - this.m.x - this.m.cx) * this.m.cos(this.m.xz) - (this.z - this.m.z - this.m.cz) * this.m.sin(this.m.xz));
      int var3 = this.m.cz + (int)((this.x - this.m.x - this.m.cx) * this.m.sin(this.m.xz) + (this.z - this.m.z - this.m.cz) * this.m.cos(this.m.xz));
      int var4 = this.m.cz + (int)((this.y - this.m.y - this.m.cy) * this.m.sin(this.m.zy) + (var3 - this.m.cz) * this.m.cos(this.m.zy));
      int var5 = this.xs(var2 + this.maxR, var4) - this.xs(var2 - this.maxR, var4);
      if (this.xs(var2 + this.maxR * 2, var4) > this.m.iw
         && this.xs(var2 - this.maxR * 2, var4) < this.m.w
         && var4 > -this.maxR
         && (var4 < this.m.fade[this.disline] + this.maxR || this.m.trk != 0)
         && (var5 > this.disp || this.m.trk != 0)
         && (!this.decor || this.m.resdown != 2 && this.m.trk != 1)) {
         if (this.shadow) {
            if (!this.m.crs) {
               if (var4 >= 2000) {
                  this.lowshadow(var1, var4);
               } else {
                  boolean var11 = false;
                  if (this.t.ncx != 0 || this.t.ncz != 0) {
                     int var7 = (this.x - this.t.sx) / 3000;
                     if (var7 > this.t.ncx) {
                        var7 = this.t.ncx;
                     }

                     if (var7 < 0) {
                        var7 = 0;
                     }

                     int var8 = (this.z - this.t.sz) / 3000;
                     if (var8 > this.t.ncz) {
                        var8 = this.t.ncz;
                     }

                     if (var8 < 0) {
                        var8 = 0;
                     }

                     for (int var9 = this.t.sect[var7][var8].length - 1; var9 >= 0; var9--) {
                        int var10 = this.t.sect[var7][var8][var9];
                        if (Math.abs(this.t.zy[var10]) != 90
                           && Math.abs(this.t.xy[var10]) != 90
                           && Math.abs(this.x - this.t.x[var10]) < this.t.radx[var10] + this.maxR
                           && Math.abs(this.z - this.t.z[var10]) < this.t.radz[var10] + this.maxR
                           && (!this.t.decor[var10] || this.m.resdown != 2)) {
                           var11 = true;
                           break;
                        }
                     }
                  }

                  if (var11) {
                     for (int var15 = 0; var15 < this.npl; var15++) {
                        this.p[var15].s(var1, this.x - this.m.x, this.y - this.m.y, this.z - this.m.z, this.xz, this.xy, this.zy, 0);
                     }
                  } else {
                     int var16 = this.m.cy + (int)((this.m.ground - this.m.cy) * this.m.cos(this.m.zy) - (var3 - this.m.cz) * this.m.sin(this.m.zy));
                     int var19 = this.m.cz + (int)((this.m.ground - this.m.cy) * this.m.sin(this.m.zy) + (var3 - this.m.cz) * this.m.cos(this.m.zy));
                     if (this.ys(var16 + this.maxR, var19) > 0 && this.ys(var16 - this.maxR, var19) < this.m.h) {
                        for (int var21 = 0; var21 < this.npl; var21++) {
                           this.p[var21].s(var1, this.x - this.m.x, this.y - this.m.y, this.z - this.m.z, this.xz, this.xy, this.zy, 1);
                        }
                     }
                  }

                  this.m.addsp(this.x - this.m.x, this.z - this.m.z, (int)(this.maxR * 0.8));
               }
            } else {
               for (int var6 = 0; var6 < this.npl; var6++) {
                  this.p[var6].s(var1, this.x - this.m.x, this.y - this.m.y, this.z - this.m.z, this.xz, this.xy, this.zy, 2);
               }
            }
         }

         int var12 = this.m.cy + (int)((this.y - this.m.y - this.m.cy) * this.m.cos(this.m.zy) - (var3 - this.m.cz) * this.m.sin(this.m.zy));
         if (this.ys(var12 + this.maxR, var4) > this.m.ih && this.ys(var12 - this.maxR, var4) < this.m.h) {
            if (this.elec && this.m.noelec == 0) {
               this.electrify(var1);
            }

            if (this.fix) {
               this.fixit(var1);
            }

            if (this.checkpoint != 0 && this.checkpoint - 1 == this.m.checkpoint) {
               var5 = -1;
            }

            if (this.shadow) {
               this.dist = (int)Math.sqrt(
                  (this.m.x + this.m.cx - this.x) * (this.m.x + this.m.cx - this.x)
                     + (this.m.z - this.z) * (this.m.z - this.z)
                     + (this.m.y + this.m.cy - this.y) * (this.m.y + this.m.cy - this.y)
               );

               for (int var17 = 0; var17 < 20; var17++) {
                  if (this.stg[var17] != 0) {
                     this.pdust(var17, var1, true);
                  }
               }

               this.dsprk(var1, true);
            }

            int[] var18 = new int[this.npl];
            int[] var20 = new int[this.npl];

            for (int var22 = 0; var22 < this.npl; var22++) {
               var18[var22] = 0;
            }

            for (int var23 = 0; var23 < this.npl; var20[var18[var23]] = var23++) {
               for (int var26 = var23 + 1; var26 < this.npl; var26++) {
                  if (this.p[var23].av != this.p[var26].av) {
                     if (this.p[var23].av < this.p[var26].av) {
                        var18[var23]++;
                     } else {
                        var18[var26]++;
                     }
                  } else if (var23 > var26) {
                     var18[var23]++;
                  } else {
                     var18[var26]++;
                  }
               }
            }

            for (int var24 = 0; var24 < this.npl; var24++) {
               this.p[var20[var24]]
                  .d(var1, this.x - this.m.x, this.y - this.m.y, this.z - this.m.z, this.xz, this.xy, this.zy, this.wxz, this.wzy, this.noline, var5);
            }

            if (this.shadow) {
               for (int var25 = 0; var25 < 20; var25++) {
                  if (this.stg[var25] != 0) {
                     this.pdust(var25, var1, false);
                  }
               }

               this.dsprk(var1, false);
            }

            this.dist = (int)(
               Math.sqrt(
                     (int)Math.sqrt(
                        (this.m.x + this.m.cx - this.x) * (this.m.x + this.m.cx - this.x)
                           + (this.m.z - this.z) * (this.m.z - this.z)
                           + (this.m.y + this.m.cy - this.y) * (this.m.y + this.m.cy - this.y)
                     )
                  )
                  * this.grounded
            );
         }
      }

      if (this.shadow && this.dist == 0) {
         for (int var13 = 0; var13 < 20; var13++) {
            if (this.stg[var13] != 0) {
               this.stg[var13] = 0;
            }
         }

         for (int var14 = 0; var14 < 100; var14++) {
            if (this.rtg[var14] != 0) {
               this.rtg[var14] = 0;
            }
         }

         if (this.sprk != 0) {
            this.sprk = 0;
         }
      }
   }

   public void lowshadow(Graphics2D var1, int var2) {
      int[] var3 = new int[4];
      int[] var4 = new int[4];
      int[] var5 = new int[4];
      byte var6 = 1;
      int var7 = Math.abs(this.zy);

      while (var7 > 270) {
         var7 -= 360;
      }

      var7 = Math.abs(var7);
      if (var7 > 90) {
         var6 = -1;
      }

      var3[0] = (int)(this.keyx[0] * 1.2 + this.x - this.m.x);
      var5[0] = (int)((this.keyz[0] + 30) * var6 * 1.2 + this.z - this.m.z);
      var3[1] = (int)(this.keyx[1] * 1.2 + this.x - this.m.x);
      var5[1] = (int)((this.keyz[1] + 30) * var6 * 1.2 + this.z - this.m.z);
      var3[2] = (int)(this.keyx[3] * 1.2 + this.x - this.m.x);
      var5[2] = (int)((this.keyz[3] - 30) * var6 * 1.2 + this.z - this.m.z);
      var3[3] = (int)(this.keyx[2] * 1.2 + this.x - this.m.x);
      var5[3] = (int)((this.keyz[2] - 30) * var6 * 1.2 + this.z - this.m.z);
      this.rot(var3, var5, this.x - this.m.x, this.z - this.m.z, this.xz, 4);
      int var8 = (int)(this.m.crgrnd[0] / 1.5);
      int var9 = (int)(this.m.crgrnd[1] / 1.5);
      int var10 = (int)(this.m.crgrnd[2] / 1.5);

      for (int var11 = 0; var11 < 4; var11++) {
         var4[var11] = this.m.ground;
      }

      if (this.t.ncx != 0 || this.t.ncz != 0) {
         int var18 = (this.x - this.t.sx) / 3000;
         if (var18 > this.t.ncx) {
            var18 = this.t.ncx;
         }

         if (var18 < 0) {
            var18 = 0;
         }

         int var12 = (this.z - this.t.sz) / 3000;
         if (var12 > this.t.ncz) {
            var12 = this.t.ncz;
         }

         if (var12 < 0) {
            var12 = 0;
         }

         for (int var13 = this.t.sect[var18][var12].length - 1; var13 >= 0; var13--) {
            int var14 = this.t.sect[var18][var12][var13];
            int var15 = 0;

            for (int var16 = 0; var16 < 4; var16++) {
               if (Math.abs(this.t.zy[var14]) != 90
                  && Math.abs(this.t.xy[var14]) != 90
                  && this.t.rady[var14] != 801
                  && Math.abs(var3[var16] - (this.t.x[var14] - this.m.x)) < this.t.radx[var14]
                  && Math.abs(var5[var16] - (this.t.z[var14] - this.m.z)) < this.t.radz[var14]
                  && (!this.t.decor[var14] || this.m.resdown != 2)) {
                  var15++;
               }
            }

            if (var15 > 2) {
               for (int var24 = 0; var24 < 4; var24++) {
                  var4[var24] = this.t.y[var14] - this.m.y;
                  if (this.t.zy[var14] != 0) {
                     var4[var24] = (int)(
                        var4[var24]
                           + (
                              (var5[var24] - (this.t.z[var14] - this.m.z - this.t.radz[var14]))
                                    * this.m.sin(this.t.zy[var14])
                                    / this.m.sin(90 - this.t.zy[var14])
                                 - this.t.radz[var14] * this.m.sin(this.t.zy[var14]) / this.m.sin(90 - this.t.zy[var14])
                           )
                     );
                  }

                  if (this.t.xy[var14] != 0) {
                     var4[var24] = (int)(
                        var4[var24]
                           + (
                              (var3[var24] - (this.t.x[var14] - this.m.x - this.t.radx[var14]))
                                    * this.m.sin(this.t.xy[var14])
                                    / this.m.sin(90 - this.t.xy[var14])
                                 - this.t.radx[var14] * this.m.sin(this.t.xy[var14]) / this.m.sin(90 - this.t.xy[var14])
                           )
                     );
                  }
               }

               var8 = (int)(this.t.c[var14][0] / 1.5);
               var9 = (int)(this.t.c[var14][1] / 1.5);
               var10 = (int)(this.t.c[var14][2] / 1.5);
               break;
            }
         }
      }

      this.rot(var3, var5, this.m.cx, this.m.cz, this.m.xz, 4);
      this.rot(var4, var5, this.m.cy, this.m.cz, this.m.zy, 4);
      boolean var19 = true;
      int var20 = 0;
      int var21 = 0;
      int var22 = 0;
      int var23 = 0;

      for (int var25 = 0; var25 < 4; var25++) {
         var3[var25] = this.xs(var3[var25], var5[var25]);
         var4[var25] = this.ys(var4[var25], var5[var25]);
         if (var4[var25] < this.m.ih || var5[var25] < 10) {
            var20++;
         }

         if (var4[var25] > this.m.h || var5[var25] < 10) {
            var21++;
         }

         if (var3[var25] < this.m.iw || var5[var25] < 10) {
            var22++;
         }

         if (var3[var25] > this.m.w || var5[var25] < 10) {
            var23++;
         }
      }

      if (var22 == 4 || var20 == 4 || var21 == 4 || var23 == 4) {
         var19 = false;
      }

      if (var19) {
         for (int var26 = 0; var26 < 16; var26++) {
            if (var2 > this.m.fade[var26]) {
               var8 = (var8 * this.m.fogd + this.m.cfade[0]) / (this.m.fogd + 1);
               var9 = (var9 * this.m.fogd + this.m.cfade[1]) / (this.m.fogd + 1);
               var10 = (var10 * this.m.fogd + this.m.cfade[2]) / (this.m.fogd + 1);
            }
         }

         var1.setColor(new Color(var8, var9, var10));
         var1.fillPolygon(var3, var4, 4);
      }
   }

   public void fixit(Graphics2D var1) {
      if (this.fcnt == 1) {
         for (int var2 = 0; var2 < this.npl; var2++) {
            this.p[var2].hsb[0] = 0.57F;
            this.p[var2].hsb[2] = 0.8F;
            this.p[var2].hsb[1] = 0.8F;
            Color var3 = Color.getHSBColor(this.p[var2].hsb[0], this.p[var2].hsb[1], this.p[var2].hsb[2]);
            int var4 = (int)(var3.getRed() + var3.getRed() * (this.m.snap[0] / 100.0F));
            if (var4 > 255) {
               var4 = 255;
            }

            if (var4 < 0) {
               var4 = 0;
            }

            int var5 = (int)(var3.getGreen() + var3.getGreen() * (this.m.snap[1] / 100.0F));
            if (var5 > 255) {
               var5 = 255;
            }

            if (var5 < 0) {
               var5 = 0;
            }

            int var6 = (int)(var3.getBlue() + var3.getBlue() * (this.m.snap[2] / 100.0F));
            if (var6 > 255) {
               var6 = 255;
            }

            if (var6 < 0) {
               var6 = 0;
            }

            Color.RGBtoHSB(var4, var5, var6, this.p[var2].hsb);
            this.p[var2].flx = 1;
         }
      }

      if (this.fcnt == 2) {
         for (int var14 = 0; var14 < this.npl; var14++) {
            this.p[var14].flx = 1;
         }
      }

      if (this.fcnt == 4) {
         for (int var15 = 0; var15 < this.npl; var15++) {
            this.p[var15].flx = 3;
         }
      }

      if ((this.fcnt == 1 || this.fcnt > 2) && this.fcnt != 9) {
         int[] var16 = new int[8];
         int[] var17 = new int[8];
         int[] var18 = new int[4];

         for (int var19 = 0; var19 < 4; var19++) {
            var16[var19] = this.keyx[var19] + this.x - this.m.x;
            var17[var19] = this.grat + this.y - this.m.y;
            var18[var19] = this.keyz[var19] + this.z - this.m.z;
         }

         this.rot(var16, var17, this.x - this.m.x, this.y - this.m.y, this.xy, 4);
         this.rot(var17, var18, this.y - this.m.y, this.z - this.m.y, this.zy, 4);
         this.rot(var16, var18, this.x - this.m.x, this.z - this.m.z, this.xz, 4);
         this.rot(var16, var18, this.m.cx, this.m.cz, this.m.xz, 4);
         this.rot(var17, var18, this.m.cy, this.m.cz, this.m.zy, 4);
         int var20 = 0;
         int var21 = 0;
         int var7 = 0;

         for (int var8 = 0; var8 < 4; var8++) {
            for (int var9 = 0; var9 < 4; var9++) {
               if (Math.abs(var16[var8] - var16[var9]) > var20) {
                  var20 = Math.abs(var16[var8] - var16[var9]);
               }

               if (Math.abs(var17[var8] - var17[var9]) > var21) {
                  var21 = Math.abs(var17[var8] - var17[var9]);
               }

               if (this.py(var16[var8], var16[var9], var17[var8], var17[var9]) > var7) {
                  var7 = this.py(var16[var8], var16[var9], var17[var8], var17[var9]);
               }
            }
         }

         var7 = (int)(Math.sqrt(var7) / 1.5);
         if (var20 < var7) {
            var20 = var7;
         }

         if (var21 < var7) {
            var21 = var7;
         }

         int var23 = this.m.cx + (int)((this.x - this.m.x - this.m.cx) * this.m.cos(this.m.xz) - (this.z - this.m.z - this.m.cz) * this.m.sin(this.m.xz));
         int var24 = this.m.cz + (int)((this.x - this.m.x - this.m.cx) * this.m.sin(this.m.xz) + (this.z - this.m.z - this.m.cz) * this.m.cos(this.m.xz));
         int var10 = this.m.cy + (int)((this.y - this.m.y - this.m.cy) * this.m.cos(this.m.zy) - (var24 - this.m.cz) * this.m.sin(this.m.zy));
         var24 = this.m.cz + (int)((this.y - this.m.y - this.m.cy) * this.m.sin(this.m.zy) + (var24 - this.m.cz) * this.m.cos(this.m.zy));
         var16[0] = this.xs((int)(var23 - var20 / 0.8 - this.m.random() * (var20 / 2.4)), var24);
         var17[0] = this.ys((int)(var10 - var21 / 1.92 - this.m.random() * (var21 / 5.67)), var24);
         var16[1] = this.xs((int)(var23 - var20 / 0.8 - this.m.random() * (var20 / 2.4)), var24);
         var17[1] = this.ys((int)(var10 + var21 / 1.92 + this.m.random() * (var21 / 5.67)), var24);
         var16[2] = this.xs((int)(var23 - var20 / 1.92 - this.m.random() * (var20 / 5.67)), var24);
         var17[2] = this.ys((int)(var10 + var21 / 0.8 + this.m.random() * (var21 / 2.4)), var24);
         var16[3] = this.xs((int)(var23 + var20 / 1.92 + this.m.random() * (var20 / 5.67)), var24);
         var17[3] = this.ys((int)(var10 + var21 / 0.8 + this.m.random() * (var21 / 2.4)), var24);
         var16[4] = this.xs((int)(var23 + var20 / 0.8 + this.m.random() * (var20 / 2.4)), var24);
         var17[4] = this.ys((int)(var10 + var21 / 1.92 + this.m.random() * (var21 / 5.67)), var24);
         var16[5] = this.xs((int)(var23 + var20 / 0.8 + this.m.random() * (var20 / 2.4)), var24);
         var17[5] = this.ys((int)(var10 - var21 / 1.92 - this.m.random() * (var21 / 5.67)), var24);
         var16[6] = this.xs((int)(var23 + var20 / 1.92 + this.m.random() * (var20 / 5.67)), var24);
         var17[6] = this.ys((int)(var10 - var21 / 0.8 - this.m.random() * (var21 / 2.4)), var24);
         var16[7] = this.xs((int)(var23 - var20 / 1.92 - this.m.random() * (var20 / 5.67)), var24);
         var17[7] = this.ys((int)(var10 - var21 / 0.8 - this.m.random() * (var21 / 2.4)), var24);
         if (this.fcnt == 3) {
            this.rot(var16, var17, this.xs(var23, var24), this.ys(var10, var24), 22, 8);
         }

         if (this.fcnt == 4) {
            this.rot(var16, var17, this.xs(var23, var24), this.ys(var10, var24), 22, 8);
         }

         if (this.fcnt == 5) {
            this.rot(var16, var17, this.xs(var23, var24), this.ys(var10, var24), 0, 8);
         }

         if (this.fcnt == 6) {
            this.rot(var16, var17, this.xs(var23, var24), this.ys(var10, var24), -22, 8);
         }

         if (this.fcnt == 7) {
            this.rot(var16, var17, this.xs(var23, var24), this.ys(var10, var24), -22, 8);
         }

         int var11 = (int)(191.0F + 191.0F * (this.m.snap[0] / 350.0F));
         if (var11 > 255) {
            var11 = 255;
         }

         if (var11 < 0) {
            var11 = 0;
         }

         int var12 = (int)(232.0F + 232.0F * (this.m.snap[1] / 350.0F));
         if (var12 > 255) {
            var12 = 255;
         }

         if (var12 < 0) {
            var12 = 0;
         }

         int var13 = (int)(255.0F + 255.0F * (this.m.snap[2] / 350.0F));
         if (var13 > 255) {
            var13 = 255;
         }

         if (var13 < 0) {
            var13 = 0;
         }

         var1.setColor(new Color(var11, var12, var13));
         var1.fillPolygon(var16, var17, 8);
         var16[0] = this.xs((int)(var23 - var20 - this.m.random() * (var20 / 4)), var24);
         var17[0] = this.ys((int)(var10 - var21 / 2.4 - this.m.random() * (var21 / 9.6)), var24);
         var16[1] = this.xs((int)(var23 - var20 - this.m.random() * (var20 / 4)), var24);
         var17[1] = this.ys((int)(var10 + var21 / 2.4 + this.m.random() * (var21 / 9.6)), var24);
         var16[2] = this.xs((int)(var23 - var20 / 2.4 - this.m.random() * (var20 / 9.6)), var24);
         var17[2] = this.ys((int)(var10 + var21 + this.m.random() * (var21 / 4)), var24);
         var16[3] = this.xs((int)(var23 + var20 / 2.4 + this.m.random() * (var20 / 9.6)), var24);
         var17[3] = this.ys((int)(var10 + var21 + this.m.random() * (var21 / 4)), var24);
         var16[4] = this.xs((int)(var23 + var20 + this.m.random() * (var20 / 4)), var24);
         var17[4] = this.ys((int)(var10 + var21 / 2.4 + this.m.random() * (var21 / 9.6)), var24);
         var16[5] = this.xs((int)(var23 + var20 + this.m.random() * (var20 / 4)), var24);
         var17[5] = this.ys((int)(var10 - var21 / 2.4 - this.m.random() * (var21 / 9.6)), var24);
         var16[6] = this.xs((int)(var23 + var20 / 2.4 + this.m.random() * (var20 / 9.6)), var24);
         var17[6] = this.ys((int)(var10 - var21 - this.m.random() * (var21 / 4)), var24);
         var16[7] = this.xs((int)(var23 - var20 / 2.4 - this.m.random() * (var20 / 9.6)), var24);
         var17[7] = this.ys((int)(var10 - var21 - this.m.random() * (var21 / 4)), var24);
         var11 = (int)(213.0F + 213.0F * (this.m.snap[0] / 350.0F));
         if (var11 > 255) {
            var11 = 255;
         }

         if (var11 < 0) {
            var11 = 0;
         }

         var12 = (int)(239.0F + 239.0F * (this.m.snap[1] / 350.0F));
         if (var12 > 255) {
            var12 = 255;
         }

         if (var12 < 0) {
            var12 = 0;
         }

         var13 = (int)(255.0F + 255.0F * (this.m.snap[2] / 350.0F));
         if (var13 > 255) {
            var13 = 255;
         }

         if (var13 < 0) {
            var13 = 0;
         }

         var1.setColor(new Color(var11, var12, var13));
         var1.fillPolygon(var16, var17, 8);
      }

      if (this.fcnt > 7) {
         this.fcnt = 0;
         this.fix = false;
      } else {
         this.fcnt++;
      }
   }

   public void electrify(Graphics2D var1) {
      for (int var2 = 0; var2 < 4; var2++) {
         if (this.elc[var2] == 0) {
            this.edl[var2] = (int)(380.0F - this.m.random() * 760.0F);
            this.edr[var2] = (int)(380.0F - this.m.random() * 760.0F);
            this.elc[var2] = 1;
         }

         int var3 = (int)(this.edl[var2] + (190.0F - this.m.random() * 380.0F));
         int var4 = (int)(this.edr[var2] + (190.0F - this.m.random() * 380.0F));
         int var5 = (int)(this.m.random() * 126.0F);
         int var6 = (int)(this.m.random() * 126.0F);
         int[] var7 = new int[8];
         int[] var8 = new int[8];
         int[] var9 = new int[8];

         for (int var10 = 0; var10 < 8; var10++) {
            var9[var10] = this.z - this.m.z;
         }

         var7[0] = this.x - this.m.x - 504;
         var8[0] = this.y - this.m.y - this.edl[var2] - 5 - (int)(this.m.random() * 5.0F);
         var7[1] = this.x - this.m.x - 252 + var6;
         var8[1] = this.y - this.m.y - var3 - 5 - (int)(this.m.random() * 5.0F);
         var7[2] = this.x - this.m.x + 252 - var5;
         var8[2] = this.y - this.m.y - var4 - 5 - (int)(this.m.random() * 5.0F);
         var7[3] = this.x - this.m.x + 504;
         var8[3] = this.y - this.m.y - this.edr[var2] - 5 - (int)(this.m.random() * 5.0F);
         var7[4] = this.x - this.m.x + 504;
         var8[4] = this.y - this.m.y - this.edr[var2] + 5 + (int)(this.m.random() * 5.0F);
         var7[5] = this.x - this.m.x + 252 - var5;
         var8[5] = this.y - this.m.y - var4 + 5 + (int)(this.m.random() * 5.0F);
         var7[6] = this.x - this.m.x - 252 + var6;
         var8[6] = this.y - this.m.y - var3 + 5 + (int)(this.m.random() * 5.0F);
         var7[7] = this.x - this.m.x - 504;
         var8[7] = this.y - this.m.y - this.edl[var2] + 5 + (int)(this.m.random() * 5.0F);
         if (this.roted) {
            this.rot(var7, var9, this.x - this.m.x, this.z - this.m.z, 90, 8);
         }

         this.rot(var7, var9, this.m.cx, this.m.cz, this.m.xz, 8);
         this.rot(var8, var9, this.m.cy, this.m.cz, this.m.zy, 8);
         boolean var20 = true;
         int var11 = 0;
         int var12 = 0;
         int var13 = 0;
         int var14 = 0;
         int[] var15 = new int[8];
         int[] var16 = new int[8];

         for (int var17 = 0; var17 < 8; var17++) {
            var15[var17] = this.xs(var7[var17], var9[var17]);
            var16[var17] = this.ys(var8[var17], var9[var17]);
            if (var16[var17] < this.m.ih || var9[var17] < 10) {
               var11++;
            }

            if (var16[var17] > this.m.h || var9[var17] < 10) {
               var12++;
            }

            if (var15[var17] < this.m.iw || var9[var17] < 10) {
               var13++;
            }

            if (var15[var17] > this.m.w || var9[var17] < 10) {
               var14++;
            }
         }

         if (var13 == 8 || var11 == 8 || var12 == 8 || var14 == 8) {
            var20 = false;
         }

         if (var20) {
            int var21 = (int)(160.0F + 160.0F * (this.m.snap[0] / 500.0F));
            if (var21 > 255) {
               var21 = 255;
            }

            if (var21 < 0) {
               var21 = 0;
            }

            int var18 = (int)(238.0F + 238.0F * (this.m.snap[1] / 500.0F));
            if (var18 > 255) {
               var18 = 255;
            }

            if (var18 < 0) {
               var18 = 0;
            }

            int var19 = (int)(255.0F + 255.0F * (this.m.snap[2] / 500.0F));
            if (var19 > 255) {
               var19 = 255;
            }

            if (var19 < 0) {
               var19 = 0;
            }

            var21 = (var21 * 2 + 214 * (this.elc[var2] - 1)) / (this.elc[var2] + 1);
            var18 = (var18 * 2 + 236 * (this.elc[var2] - 1)) / (this.elc[var2] + 1);
            if (this.m.trk == 1) {
               var21 = 255;
               var18 = 128;
               var19 = 0;
            }

            var1.setColor(new Color(var21, var18, var19));
            var1.fillPolygon(var15, var16, 8);
            if (var9[0] < 4000) {
               var21 = (int)(150.0F + 150.0F * (this.m.snap[0] / 500.0F));
               if (var21 > 255) {
                  var21 = 255;
               }

               if (var21 < 0) {
                  var21 = 0;
               }

               var18 = (int)(227.0F + 227.0F * (this.m.snap[1] / 500.0F));
               if (var18 > 255) {
                  var18 = 255;
               }

               if (var18 < 0) {
                  var18 = 0;
               }

               var19 = (int)(255.0F + 255.0F * (this.m.snap[2] / 500.0F));
               if (var19 > 255) {
                  var19 = 255;
               }

               if (var19 < 0) {
                  var19 = 0;
               }

               var1.setColor(new Color(var21, var18, var19));
               var1.drawPolygon(var15, var16, 8);
            }
         }

         if (this.elc[var2] > this.m.random() * 60.0F) {
            this.elc[var2] = 0;
         } else {
            this.elc[var2]++;
         }
      }

      if (this.roted && this.xz == 0) {
         this.zy += 11;
         if (this.zy > 360) {
            this.zy -= 360;
         }
      } else {
         this.xy += 11;
         if (this.xy > 360) {
            this.xy -= 360;
         }
      }
   }

   public void dust(int var1, float var2, float var3, float var4, int var5, int var6, float var7, int var8, boolean var9) {
      boolean var10 = false;
      if (var8 > 5 && (var1 == 0 || var1 == 2)) {
         var10 = true;
      }

      if (var8 < -5 && (var1 == 1 || var1 == 3)) {
         var10 = true;
      }

      float var11 = (float)((Math.sqrt(var5 * var5 + var6 * var6) - 40.0) / 160.0);
      if (var11 > 1.0F) {
         var11 = 1.0F;
      }

      if (var11 > 0.2 && !var10) {
         this.ust++;
         if (this.ust == 20) {
            this.ust = 0;
         }

         if (!var9) {
            float var12 = this.m.random();
            this.sx[this.ust] = (int)((var2 + this.x * var12) / (1.0F + var12));
            this.sz[this.ust] = (int)((var4 + this.z * var12) / (1.0F + var12));
            this.sy[this.ust] = (int)((var3 + this.y * var12) / (1.0F + var12));
         } else {
            this.sx[this.ust] = (int)((var2 + (this.x + var5)) / 2.0F);
            this.sz[this.ust] = (int)((var4 + (this.z + var6)) / 2.0F);
            this.sy[this.ust] = (int)var3;
         }

         if (this.sy[var1] > 250) {
            this.sy[var1] = 250;
         }

         this.osmag[this.ust] = var7 * var11;
         this.scx[this.ust] = var5;
         this.scz[this.ust] = var6;
         this.stg[this.ust] = 1;
      }
   }

   public void pdust(int var1, Graphics2D var2, boolean var3) {
      if (var3) {
         this.sav[var1] = (int)Math.sqrt(
            (this.m.x + this.m.cx - this.sx[var1]) * (this.m.x + this.m.cx - this.sx[var1])
               + (this.m.y + this.m.cy - this.sy[var1]) * (this.m.y + this.m.cy - this.sy[var1])
               + (this.m.z - this.sz[var1]) * (this.m.z - this.sz[var1])
         );
      }

      if (var3 && this.sav[var1] > this.dist || !var3 && this.sav[var1] <= this.dist) {
         if (this.stg[var1] == 1) {
            this.sbln[var1] = 0.6F;
            boolean var4 = false;
            int[] var5 = new int[3];

            for (int var6 = 0; var6 < 3; var6++) {
               var5[var6] = (int)(255.0F + 255.0F * (this.m.snap[var6] / 100.0F));
               if (var5[var6] > 255) {
                  var5[var6] = 255;
               }

               if (var5[var6] < 0) {
                  var5[var6] = 0;
               }
            }

            int var21 = (this.x - this.t.sx) / 3000;
            if (var21 > this.t.ncx) {
               var21 = this.t.ncx;
            }

            if (var21 < 0) {
               var21 = 0;
            }

            int var7 = (this.z - this.t.sz) / 3000;
            if (var7 > this.t.ncz) {
               var7 = this.t.ncz;
            }

            if (var7 < 0) {
               var7 = 0;
            }

            for (int var8 = 0; var8 < this.t.sect[var21][var7].length; var8++) {
               int var9 = this.t.sect[var21][var7][var8];
               if (Math.abs(this.t.zy[var9]) != 90
                  && Math.abs(this.t.xy[var9]) != 90
                  && Math.abs(this.sx[var1] - this.t.x[var9]) < this.t.radx[var9]
                  && Math.abs(this.sz[var1] - this.t.z[var9]) < this.t.radz[var9]) {
                  if (this.t.skd[var9] == 0) {
                     this.sbln[var1] = 0.2F;
                  }

                  if (this.t.skd[var9] == 1) {
                     this.sbln[var1] = 0.4F;
                  }

                  if (this.t.skd[var9] == 2) {
                     this.sbln[var1] = 0.45F;
                  }

                  for (int var10 = 0; var10 < 3; var10++) {
                     this.srgb[var1][var10] = (this.t.c[var9][var10] + var5[var10]) / 2;
                  }

                  var4 = true;
               }
            }

            if (!var4) {
               for (int var24 = 0; var24 < 3; var24++) {
                  this.srgb[var1][var24] = (this.m.crgrnd[var24] + var5[var24]) / 2;
               }
            }

            float var25 = (float)(0.1 + this.m.random());
            if (var25 > 1.0F) {
               var25 = 1.0F;
            }

            this.scx[var1] = (int)(this.scx[var1] * var25);
            this.scz[var1] = (int)(this.scx[var1] * var25);

            for (int var27 = 0; var27 < 8; var27++) {
               this.smag[var1][var27] = this.osmag[var1] * this.m.random() * 50.0F;
            }

            for (int var28 = 0; var28 < 8; var28++) {
               int var31 = var28 - 1;
               if (var31 == -1) {
                  var31 = 7;
               }

               int var11 = var28 + 1;
               if (var11 == 8) {
                  var11 = 0;
               }

               this.smag[var1][var28] = ((this.smag[var1][var31] + this.smag[var1][var11]) / 2.0F + this.smag[var1][var28]) / 2.0F;
            }

            this.smag[var1][6] = this.smag[var1][7];
         }

         int var18 = this.m.cx
            + (int)((this.sx[var1] - this.m.x - this.m.cx) * this.m.cos(this.m.xz) - (this.sz[var1] - this.m.z - this.m.cz) * this.m.sin(this.m.xz));
         int var19 = this.m.cz
            + (int)((this.sx[var1] - this.m.x - this.m.cx) * this.m.sin(this.m.xz) + (this.sz[var1] - this.m.z - this.m.cz) * this.m.cos(this.m.xz));
         int var22 = this.m.cy
            + (int)((this.sy[var1] - this.m.y - this.m.cy - this.smag[var1][7]) * this.m.cos(this.m.zy) - (var19 - this.m.cz) * this.m.sin(this.m.zy));
         var19 = this.m.cz
            + (int)((this.sy[var1] - this.m.y - this.m.cy - this.smag[var1][7]) * this.m.sin(this.m.zy) + (var19 - this.m.cz) * this.m.cos(this.m.zy));
         this.sx[var1] = this.sx[var1] + this.scx[var1] / (this.stg[var1] + 1);
         this.sz[var1] = this.sz[var1] + this.scz[var1] / (this.stg[var1] + 1);
         int[] var23 = new int[8];
         int[] var26 = new int[8];
         var23[0] = this.xs((int)(var18 + this.smag[var1][0] * 0.9238F * 1.5F), var19);
         var26[0] = this.ys((int)(var22 + this.smag[var1][0] * 0.3826F * 1.5F), var19);
         var23[1] = this.xs((int)(var18 + this.smag[var1][1] * 0.9238F * 1.5F), var19);
         var26[1] = this.ys((int)(var22 - this.smag[var1][1] * 0.3826F * 1.5F), var19);
         var23[2] = this.xs((int)(var18 + this.smag[var1][2] * 0.3826F), var19);
         var26[2] = this.ys((int)(var22 - this.smag[var1][2] * 0.9238F), var19);
         var23[3] = this.xs((int)(var18 - this.smag[var1][3] * 0.3826F), var19);
         var26[3] = this.ys((int)(var22 - this.smag[var1][3] * 0.9238F), var19);
         var23[4] = this.xs((int)(var18 - this.smag[var1][4] * 0.9238F * 1.5F), var19);
         var26[4] = this.ys((int)(var22 - this.smag[var1][4] * 0.3826F * 1.5F), var19);
         var23[5] = this.xs((int)(var18 - this.smag[var1][5] * 0.9238F * 1.5F), var19);
         var26[5] = this.ys((int)(var22 + this.smag[var1][5] * 0.3826F * 1.5F), var19);
         var23[6] = this.xs((int)(var18 - this.smag[var1][6] * 0.3826F * 1.7F), var19);
         var26[6] = this.ys((int)(var22 + this.smag[var1][6] * 0.9238F), var19);
         var23[7] = this.xs((int)(var18 + this.smag[var1][7] * 0.3826F * 1.7F), var19);
         var26[7] = this.ys((int)(var22 + this.smag[var1][7] * 0.9238F), var19);

         for (int var29 = 0; var29 < 7; var29++) {
            this.smag[var1][var29] = this.smag[var1][var29] + (5.0F + this.m.random() * 15.0F);
         }

         this.smag[var1][7] = this.smag[var1][6];
         boolean var30 = true;
         int var32 = 0;
         int var33 = 0;
         int var12 = 0;
         int var13 = 0;

         for (int var14 = 0; var14 < 8; var14++) {
            if (var26[var14] < this.m.ih || var19 < 10) {
               var32++;
            }

            if (var26[var14] > this.m.h || var19 < 10) {
               var33++;
            }

            if (var23[var14] < this.m.iw || var19 < 10) {
               var12++;
            }

            if (var23[var14] > this.m.w || var19 < 10) {
               var13++;
            }
         }

         if (var12 == 4 || var32 == 4 || var33 == 4 || var13 == 4) {
            var30 = false;
         }

         if (var30) {
            int var34 = this.srgb[var1][0];
            int var15 = this.srgb[var1][1];
            int var16 = this.srgb[var1][2];

            for (int var17 = 0; var17 < 16; var17++) {
               if (this.sav[var1] > this.m.fade[var17]) {
                  var34 = (var34 * this.m.fogd + this.m.cfade[0]) / (this.m.fogd + 1);
                  var15 = (var15 * this.m.fogd + this.m.cfade[1]) / (this.m.fogd + 1);
                  var16 = (var16 * this.m.fogd + this.m.cfade[2]) / (this.m.fogd + 1);
               }
            }

            var2.setColor(new Color(var34, var15, var16));
            float var35 = this.sbln[var1] - this.stg[var1] * (this.sbln[var1] / 8.0F);
            var2.setComposite(AlphaComposite.getInstance(3, var35));
            var2.fillPolygon(var23, var26, 8);
            var2.setComposite(AlphaComposite.getInstance(3, 1.0F));
         }

         if (this.stg[var1] == 7) {
            this.stg[var1] = 0;
         } else {
            this.stg[var1]++;
         }
      }
   }

   public void sprk(float var1, float var2, float var3, float var4, float var5, float var6, int var7) {
      if (var7 != 1) {
         this.srx = (int)(var1 - this.sprkat * this.m.sin(this.xz));
         this.sry = (int)(var2 - this.sprkat * this.m.cos(this.zy) * this.m.cos(this.xy));
         this.srz = (int)(var3 + this.sprkat * this.m.cos(this.xz));
         this.sprk = 1;
      } else {
         this.sprk++;
         if (this.sprk == 4) {
            this.srx = (int)(this.x + var4);
            this.sry = (int)var2;
            this.srz = (int)(this.z + var6);
            this.sprk = 5;
         } else {
            this.srx = (int)var1;
            this.sry = (int)var2;
            this.srz = (int)var3;
         }
      }

      if (var7 == 2) {
         this.sprk = 6;
      }

      this.rcx = var4;
      this.rcy = var5;
      this.rcz = var6;
   }

   public void dsprk(Graphics2D var1, boolean var2) {
      if (var2 && this.sprk != 0) {
         int var3 = (int)(Math.sqrt(this.rcx * this.rcx + this.rcy * this.rcy + this.rcz * this.rcz) / 10.0);
         if (var3 > 5) {
            boolean var4 = false;
            if (this.dist
               < Math.sqrt(
                  (this.m.x + this.m.cx - this.srx) * (this.m.x + this.m.cx - this.srx)
                     + (this.m.y + this.m.cy - this.sry) * (this.m.y + this.m.cy - this.sry)
                     + (this.m.z - this.srz) * (this.m.z - this.srz)
               )) {
               var4 = true;
            }

            if (var3 > 33) {
               var3 = 33;
            }

            int var5 = 0;

            for (int var6 = 0; var6 < 100; var6++) {
               if (this.rtg[var6] == 0) {
                  this.rtg[var6] = 1;
                  this.rbef[var6] = var4;
                  var5++;
               }

               if (var5 == var3) {
                  break;
               }
            }
         }
      }

      for (int var18 = 0; var18 < 100; var18++) {
         if (this.rtg[var18] != 0 && (this.rbef[var18] && var2 || !this.rbef[var18] && !var2)) {
            if (this.rtg[var18] == 1) {
               if (this.sprk < 5) {
                  this.rx[var18] = this.srx + 3 - (int)(this.m.random() * 6.7);
                  this.ry[var18] = this.sry + 3 - (int)(this.m.random() * 6.7);
                  this.rz[var18] = this.srz + 3 - (int)(this.m.random() * 6.7);
               } else {
                  this.rx[var18] = this.srx + 10 - (int)(this.m.random() * 20.0F);
                  this.ry[var18] = this.sry - (int)(this.m.random() * 4.0F);
                  this.rz[var18] = this.srz + 10 - (int)(this.m.random() * 20.0F);
               }

               int var19 = (int)Math.sqrt(this.rcx * this.rcx + this.rcy * this.rcy + this.rcz * this.rcz);
               float var21 = 0.2F + 0.4F * this.m.random();
               float var24 = this.m.random() * this.m.random() * this.m.random();
               float var7 = 1.0F;
               if (this.m.random() > this.m.random()) {
                  if (this.m.random() > this.m.random()) {
                     var7 *= -1.0F;
                  }

                  this.vrx[var18] = -((this.rcx + var19 * (1.0F - this.rcx / var19) * var24 * var7) * var21);
               }

               if (this.m.random() > this.m.random()) {
                  if (this.m.random() > this.m.random()) {
                     var7 *= -1.0F;
                  }

                  if (this.sprk == 5) {
                     var7 = 1.0F;
                  }

                  this.vry[var18] = -((this.rcy + var19 * (1.0F - this.rcy / var19) * var24 * var7) * var21);
               }

               if (this.m.random() > this.m.random()) {
                  if (this.m.random() > this.m.random()) {
                     var7 *= -1.0F;
                  }

                  this.vrz[var18] = -((this.rcz + var19 * (1.0F - this.rcz / var19) * var24 * var7) * var21);
               }
            }

            this.rx[var18] = (int)(this.rx[var18] + this.vrx[var18]);
            this.ry[var18] = (int)(this.ry[var18] + this.vry[var18]);
            this.rz[var18] = (int)(this.rz[var18] + this.vrz[var18]);
            int var20 = this.m.cx
               + (int)((this.rx[var18] - this.m.x - this.m.cx) * this.m.cos(this.m.xz) - (this.rz[var18] - this.m.z - this.m.cz) * this.m.sin(this.m.xz));
            int var22 = this.m.cz
               + (int)((this.rx[var18] - this.m.x - this.m.cx) * this.m.sin(this.m.xz) + (this.rz[var18] - this.m.z - this.m.cz) * this.m.cos(this.m.xz));
            int var25 = this.m.cy + (int)((this.ry[var18] - this.m.y - this.m.cy) * this.m.cos(this.m.zy) - (var22 - this.m.cz) * this.m.sin(this.m.zy));
            var22 = this.m.cz + (int)((this.ry[var18] - this.m.y - this.m.cy) * this.m.sin(this.m.zy) + (var22 - this.m.cz) * this.m.cos(this.m.zy));
            int var26 = this.m.cx
               + (int)(
                  (this.rx[var18] - this.m.x - this.m.cx + this.vrx[var18]) * this.m.cos(this.m.xz)
                     - (this.rz[var18] - this.m.z - this.m.cz + this.vrz[var18]) * this.m.sin(this.m.xz)
               );
            int var8 = this.m.cz
               + (int)(
                  (this.rx[var18] - this.m.x - this.m.cx + this.vrx[var18]) * this.m.sin(this.m.xz)
                     + (this.rz[var18] - this.m.z - this.m.cz + this.vrz[var18]) * this.m.cos(this.m.xz)
               );
            int var9 = this.m.cy
               + (int)((this.ry[var18] - this.m.y - this.m.cy + this.vry[var18]) * this.m.cos(this.m.zy) - (var8 - this.m.cz) * this.m.sin(this.m.zy));
            var8 = this.m.cz
               + (int)((this.ry[var18] - this.m.y - this.m.cy + this.vry[var18]) * this.m.sin(this.m.zy) + (var8 - this.m.cz) * this.m.cos(this.m.zy));
            int var10 = this.xs(var20, var22);
            int var11 = this.ys(var25, var22);
            int var12 = this.xs(var26, var8);
            int var13 = this.ys(var9, var8);
            if (var10 < this.m.iw && var12 < this.m.iw) {
               this.rtg[var18] = 0;
            }

            if (var10 > this.m.w && var12 > this.m.w) {
               this.rtg[var18] = 0;
            }

            if (var11 < this.m.ih && var13 < this.m.ih) {
               this.rtg[var18] = 0;
            }

            if (var11 > this.m.h && var13 > this.m.h) {
               this.rtg[var18] = 0;
            }

            if (this.ry[var18] > 250) {
               this.rtg[var18] = 0;
            }

            if (this.rtg[var18] != 0) {
               int var14 = 255;
               int var15 = 197 - 30 * this.rtg[var18];
               int var16 = 0;

               for (int var17 = 0; var17 < 16; var17++) {
                  if (var22 > this.m.fade[var17]) {
                     var14 = (var14 * this.m.fogd + this.m.cfade[0]) / (this.m.fogd + 1);
                     var15 = (var15 * this.m.fogd + this.m.cfade[1]) / (this.m.fogd + 1);
                     var16 = (var16 * this.m.fogd + this.m.cfade[2]) / (this.m.fogd + 1);
                  }
               }

               var1.setColor(new Color(var14, var15, var16));
               var1.drawLine(var10, var11, var12, var13);
               this.vrx[var18] = this.vrx[var18] * 0.8F;
               this.vry[var18] = this.vry[var18] * 0.8F;
               this.vrz[var18] = this.vrz[var18] * 0.8F;
               if (this.rtg[var18] == 3) {
                  this.rtg[var18] = 0;
               } else {
                  this.rtg[var18]++;
               }
            }
         }
      }

      if (this.sprk != 0) {
         this.sprk = 0;
      }
   }

   public int xs(int var1, int var2) {
      if (var2 < 50) {
         var2 = 50;
      }

      return (var2 - this.m.focus_point) * (this.m.cx - var1) / var2 + var1;
   }

   public int ys(int var1, int var2) {
      if (var2 < 50) {
         var2 = 50;
      }

      return (var2 - this.m.focus_point) * (this.m.cy - var1) / var2 + var1;
   }

   public int getvalue(String var1, String var2, int var3) {
      int var5 = 0;
      String var7 = "";

      for (int var4 = var1.length() + 1; var4 < var2.length(); var4++) {
         String var6 = "" + var2.charAt(var4);
         if (var6.equals(",") || var6.equals(")")) {
            var5++;
            var4++;
         }

         if (var5 == var3) {
            var7 = var7 + var2.charAt(var4);
         }
      }

      return Float.valueOf(var7).intValue();
   }

   public int getpy(int var1, int var2, int var3) {
      return (var1 - this.x) / 10 * ((var1 - this.x) / 10) + (var2 - this.y) / 10 * ((var2 - this.y) / 10) + (var3 - this.z) / 10 * ((var3 - this.z) / 10);
   }

   public int py(int var1, int var2, int var3, int var4) {
      return (var1 - var2) * (var1 - var2) + (var3 - var4) * (var3 - var4);
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
}
