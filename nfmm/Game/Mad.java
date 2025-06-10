import java.awt.Color;

public class Mad {
   Medium m;
   Record rpd;
   xtGraphics xt;
   int cn = 0;
   int im = 0;
   int mxz = 0;
   int cxz = 0;
   CarDefine cd;
   boolean[] dominate = new boolean[8];
   boolean[] caught = new boolean[8];
   int pzy = 0;
   int pxy = 0;
   float speed = 0.0F;
   float forca = 0.0F;
   float[] scy = new float[4];
   float[] scz = new float[4];
   float[] scx = new float[4];
   float drag = 0.5F;
   boolean mtouch = false;
   boolean wtouch = false;
   int cntouch = 0;
   boolean capsized = false;
   int txz = 0;
   int fxz = 0;
   int pmlt = 1;
   int nmlt = 1;
   int dcnt = 0;
   int skid = 0;
   boolean pushed = false;
   boolean gtouch = false;
   boolean pl = false;
   boolean pr = false;
   boolean pd = false;
   boolean pu = false;
   int loop = 0;
   float ucomp = 0.0F;
   float dcomp = 0.0F;
   float lcomp = 0.0F;
   float rcomp = 0.0F;
   int lxz = 0;
   int travxy = 0;
   int travzy = 0;
   int travxz = 0;
   int trcnt = 0;
   int capcnt = 0;
   int srfcnt = 0;
   boolean rtab = false;
   boolean ftab = false;
   boolean btab = false;
   boolean surfer = false;
   float powerup = 0.0F;
   int xtpower = 0;
   float tilt = 0.0F;
   int[][] crank = new int[4][4];
   int[][] lcrank = new int[4][4];
   int squash = 0;
   int nbsq = 0;
   int hitmag = 0;
   int cntdest = 0;
   boolean dest = false;
   boolean newcar = false;
   int pan = 0;
   int pcleared = 0;
   int clear = 0;
   int nlaps = 0;
   int focus = -1;
   float power = 75.0F;
   int missedcp = 0;
   int lastcolido = 0;
   int point = 0;
   boolean nofocus = false;
   int rpdcatch = 0;
   int newedcar = 0;
   int fixes = -1;
   int shakedam = 0;
   int outshakedam = 0;
   boolean colidim = false;

   public Mad(CarDefine var1, Medium var2, Record var3, xtGraphics var4, int var5) {
      this.cd = var1;
      this.m = var2;
      this.rpd = var3;
      this.xt = var4;
      this.im = var5;
   }

   public void reseto(int var1, ContO var2, CheckPoints var3) {
      this.cn = var1;

      for (int var4 = 0; var4 < 8; var4++) {
         this.dominate[var4] = false;
         this.caught[var4] = false;
      }

      this.mxz = 0;
      this.cxz = 0;
      this.pzy = 0;
      this.pxy = 0;
      this.speed = 0.0F;

      for (int var6 = 0; var6 < 4; var6++) {
         this.scy[var6] = 0.0F;
         this.scx[var6] = 0.0F;
         this.scz[var6] = 0.0F;
      }

      this.forca = (
            (float)Math.sqrt(var2.keyz[0] * var2.keyz[0] + var2.keyx[0] * var2.keyx[0])
               + (float)Math.sqrt(var2.keyz[1] * var2.keyz[1] + var2.keyx[1] * var2.keyx[1])
               + (float)Math.sqrt(var2.keyz[2] * var2.keyz[2] + var2.keyx[2] * var2.keyx[2])
               + (float)Math.sqrt(var2.keyz[3] * var2.keyz[3] + var2.keyx[3] * var2.keyx[3])
         )
         / 10000.0F
         * (float)(this.cd.bounce[this.cn] - 0.3);
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

      for (int var7 = 0; var7 < 4; var7++) {
         for (int var5 = 0; var5 < 4; var5++) {
            this.crank[var7][var5] = 0;
            this.lcrank[var7][var5] = 0;
         }
      }

      this.pan = 0;
      this.pcleared = var3.pcs;
      this.clear = 0;
      this.nlaps = 0;
      this.focus = -1;
      this.missedcp = 0;
      this.nofocus = false;
      this.power = 98.0F;
      this.lastcolido = 0;
      var3.dested[this.im] = 0;
      this.squash = 0;
      this.nbsq = 0;
      this.hitmag = 0;
      this.cntdest = 0;
      this.dest = false;
      this.newcar = false;
      if (this.im == this.xt.im) {
         this.m.checkpoint = -1;
         this.m.lastcheck = false;
      }

      this.rpdcatch = 0;
      this.newedcar = 0;
      this.fixes = -1;
      if (var3.nfix == 1) {
         this.fixes = 4;
      }

      if (var3.nfix == 2) {
         this.fixes = 3;
      }

      if (var3.nfix == 3) {
         this.fixes = 2;
      }

      if (var3.nfix == 4) {
         this.fixes = 1;
      }
   }

   public void drive(Control var1, ContO var2, Trackers var3, CheckPoints var4) {
      byte var5 = 1;
      byte var6 = 1;
      boolean var7 = false;
      boolean var8 = false;
      boolean var9 = false;
      this.capsized = false;
      int var10 = Math.abs(this.pzy);

      while (var10 > 270) {
         var10 -= 360;
      }

      var10 = Math.abs(var10);
      if (var10 > 90) {
         var7 = true;
      }

      boolean var11 = false;
      int var12 = Math.abs(this.pxy);

      while (var12 > 270) {
         var12 -= 360;
      }

      var12 = Math.abs(var12);
      if (var12 > 90) {
         var11 = true;
         var6 = -1;
      }

      int var13 = var2.grat;
      if (var7) {
         if (var11) {
            var11 = false;
            var8 = true;
         } else {
            var11 = true;
            this.capsized = true;
         }

         var5 = -1;
      } else if (var11) {
         this.capsized = true;
      }

      if (this.capsized) {
         var13 = this.cd.flipy[this.cn] + this.squash;
      }

      var1.zyinv = var7;
      float var14 = 0.0F;
      float var15 = 0.0F;
      float var16 = 0.0F;
      if (this.mtouch) {
         this.loop = 0;
      }

      if (this.wtouch) {
         if (this.loop == 2 || this.loop == -1) {
            this.loop = -1;
            if (var1.left) {
               this.pl = true;
            }

            if (var1.right) {
               this.pr = true;
            }

            if (var1.up) {
               this.pu = true;
            }

            if (var1.down) {
               this.pd = true;
            }
         }

         this.ucomp = 0.0F;
         this.dcomp = 0.0F;
         this.lcomp = 0.0F;
         this.rcomp = 0.0F;
      }

      if (var1.handb) {
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
         float var17 = (this.scy[0] + this.scy[1] + this.scy[2] + this.scy[3]) / 4.0F;

         for (int var18 = 0; var18 < 4; var18++) {
            this.scy[var18] = var17;
         }

         this.loop = 2;
      }

      if (!this.dest) {
         if (this.loop == 2) {
            if (var1.up) {
               if (this.ucomp == 0.0F) {
                  this.ucomp = 10.0F + (this.scy[0] + 50.0F) / 20.0F;
                  if (this.ucomp < 5.0F) {
                     this.ucomp = 5.0F;
                  }

                  if (this.ucomp > 10.0F) {
                     this.ucomp = 10.0F;
                  }

                  this.ucomp = this.ucomp * this.cd.airs[this.cn];
               }

               if (this.ucomp < 20.0F) {
                  this.ucomp = (float)(this.ucomp + 0.5 * this.cd.airs[this.cn]);
               }

               var14 = -this.cd.airc[this.cn] * this.m.sin(var2.xz) * var6;
               var15 = this.cd.airc[this.cn] * this.m.cos(var2.xz) * var6;
            } else if (this.ucomp != 0.0F && this.ucomp > -2.0F) {
               this.ucomp = (float)(this.ucomp - 0.5 * this.cd.airs[this.cn]);
            }

            if (var1.down) {
               if (this.dcomp == 0.0F) {
                  this.dcomp = 10.0F + (this.scy[0] + 50.0F) / 20.0F;
                  if (this.dcomp < 5.0F) {
                     this.dcomp = 5.0F;
                  }

                  if (this.dcomp > 10.0F) {
                     this.dcomp = 10.0F;
                  }

                  this.dcomp = this.dcomp * this.cd.airs[this.cn];
               }

               if (this.dcomp < 20.0F) {
                  this.dcomp = (float)(this.dcomp + 0.5 * this.cd.airs[this.cn]);
               }

               var16 = -this.cd.airc[this.cn];
            } else if (this.dcomp != 0.0F && this.ucomp > -2.0F) {
               this.dcomp = (float)(this.dcomp - 0.5 * this.cd.airs[this.cn]);
            }

            if (var1.left) {
               if (this.lcomp == 0.0F) {
                  this.lcomp = 5.0F;
               }

               if (this.lcomp < 20.0F) {
                  this.lcomp = this.lcomp + 2.0F * this.cd.airs[this.cn];
               }

               var14 = -this.cd.airc[this.cn] * this.m.cos(var2.xz) * var5;
               var15 = -this.cd.airc[this.cn] * this.m.sin(var2.xz) * var5;
            } else if (this.lcomp > 0.0F) {
               this.lcomp = this.lcomp - 2.0F * this.cd.airs[this.cn];
            }

            if (var1.right) {
               if (this.rcomp == 0.0F) {
                  this.rcomp = 5.0F;
               }

               if (this.rcomp < 20.0F) {
                  this.rcomp = this.rcomp + 2.0F * this.cd.airs[this.cn];
               }

               var14 = this.cd.airc[this.cn] * this.m.cos(var2.xz) * var5;
               var15 = this.cd.airc[this.cn] * this.m.sin(var2.xz) * var5;
            } else if (this.rcomp > 0.0F) {
               this.rcomp = this.rcomp - 2.0F * this.cd.airs[this.cn];
            }

            this.pzy = (int)(this.pzy + (this.dcomp - this.ucomp) * this.m.cos(this.pxy));
            if (var7) {
               var2.xz = (int)(var2.xz + (this.dcomp - this.ucomp) * this.m.sin(this.pxy));
            } else {
               var2.xz = (int)(var2.xz - (this.dcomp - this.ucomp) * this.m.sin(this.pxy));
            }

            this.pxy = (int)(this.pxy + (this.rcomp - this.lcomp));
         } else {
            float var55 = this.power;
            if (var55 < 40.0F) {
               var55 = 40.0F;
            }

            if (var1.down) {
               if (this.speed > 0.0F) {
                  this.speed = this.speed - this.cd.handb[this.cn] / 2;
               } else {
                  int var57 = 0;

                  for (int var19 = 0; var19 < 2; var19++) {
                     if (this.speed <= -(this.cd.swits[this.cn][var19] / 2 + var55 * this.cd.swits[this.cn][var19] / 196.0F)) {
                        var57++;
                     }
                  }

                  if (var57 != 2) {
                     this.speed = this.speed - (this.cd.acelf[this.cn][var57] / 2.0F + var55 * this.cd.acelf[this.cn][var57] / 196.0F);
                  } else {
                     this.speed = -(this.cd.swits[this.cn][1] / 2 + var55 * this.cd.swits[this.cn][1] / 196.0F);
                  }
               }
            }

            if (var1.up) {
               if (this.speed < 0.0F) {
                  this.speed = this.speed + this.cd.handb[this.cn];
               } else {
                  int var58 = 0;

                  for (int var60 = 0; var60 < 3; var60++) {
                     if (this.speed >= this.cd.swits[this.cn][var60] / 2 + var55 * this.cd.swits[this.cn][var60] / 196.0F) {
                        var58++;
                     }
                  }

                  if (var58 != 3) {
                     this.speed = this.speed + (this.cd.acelf[this.cn][var58] / 2.0F + var55 * this.cd.acelf[this.cn][var58] / 196.0F);
                  } else {
                     this.speed = this.cd.swits[this.cn][2] / 2 + var55 * this.cd.swits[this.cn][2] / 196.0F;
                  }
               }
            }

            if (var1.handb && Math.abs(this.speed) > this.cd.handb[this.cn]) {
               if (this.speed < 0.0F) {
                  this.speed = this.speed + this.cd.handb[this.cn];
               } else {
                  this.speed = this.speed - this.cd.handb[this.cn];
               }
            }

            if (this.loop == -1 && var2.y < 100) {
               if (var1.left) {
                  if (!this.pl) {
                     if (this.lcomp == 0.0F) {
                        this.lcomp = 5.0F * this.cd.airs[this.cn];
                     }

                     if (this.lcomp < 20.0F) {
                        this.lcomp = this.lcomp + 2.0F * this.cd.airs[this.cn];
                     }
                  }
               } else {
                  if (this.lcomp > 0.0F) {
                     this.lcomp = this.lcomp - 2.0F * this.cd.airs[this.cn];
                  }

                  this.pl = false;
               }

               if (var1.right) {
                  if (!this.pr) {
                     if (this.rcomp == 0.0F) {
                        this.rcomp = 5.0F * this.cd.airs[this.cn];
                     }

                     if (this.rcomp < 20.0F) {
                        this.rcomp = this.rcomp + 2.0F * this.cd.airs[this.cn];
                     }
                  }
               } else {
                  if (this.rcomp > 0.0F) {
                     this.rcomp = this.rcomp - 2.0F * this.cd.airs[this.cn];
                  }

                  this.pr = false;
               }

               if (var1.up) {
                  if (!this.pu) {
                     if (this.ucomp == 0.0F) {
                        this.ucomp = 5.0F * this.cd.airs[this.cn];
                     }

                     if (this.ucomp < 20.0F) {
                        this.ucomp = this.ucomp + 2.0F * this.cd.airs[this.cn];
                     }
                  }
               } else {
                  if (this.ucomp > 0.0F) {
                     this.ucomp = this.ucomp - 2.0F * this.cd.airs[this.cn];
                  }

                  this.pu = false;
               }

               if (var1.down) {
                  if (!this.pd) {
                     if (this.dcomp == 0.0F) {
                        this.dcomp = 5.0F * this.cd.airs[this.cn];
                     }

                     if (this.dcomp < 20.0F) {
                        this.dcomp = this.dcomp + 2.0F * this.cd.airs[this.cn];
                     }
                  }
               } else {
                  if (this.dcomp > 0.0F) {
                     this.dcomp = this.dcomp - 2.0F * this.cd.airs[this.cn];
                  }

                  this.pd = false;
               }

               this.pzy = (int)(this.pzy + (this.dcomp - this.ucomp) * this.m.cos(this.pxy));
               if (var7) {
                  var2.xz = (int)(var2.xz + (this.dcomp - this.ucomp) * this.m.sin(this.pxy));
               } else {
                  var2.xz = (int)(var2.xz - (this.dcomp - this.ucomp) * this.m.sin(this.pxy));
               }

               this.pxy = (int)(this.pxy + (this.rcomp - this.lcomp));
            }
         }
      }

      float var56 = 20.0F * this.speed / (154.0F * this.cd.simag[this.cn]);
      if (var56 > 20.0F) {
         var56 = 20.0F;
      }

      var2.wzy = (int)(var2.wzy - var56);
      if (var2.wzy < -30) {
         var2.wzy += 30;
      }

      if (var2.wzy > 30) {
         var2.wzy -= 30;
      }

      if (var1.right) {
         var2.wxz = var2.wxz - this.cd.turn[this.cn];
         if (var2.wxz < -36) {
            var2.wxz = -36;
         }
      }

      if (var1.left) {
         var2.wxz = var2.wxz + this.cd.turn[this.cn];
         if (var2.wxz > 36) {
            var2.wxz = 36;
         }
      }

      if (var2.wxz != 0 && !var1.left && !var1.right) {
         if (Math.abs(this.speed) < 10.0F) {
            if (Math.abs(var2.wxz) == 1) {
               var2.wxz = 0;
            }

            if (var2.wxz > 0) {
               var2.wxz--;
            }

            if (var2.wxz < 0) {
               var2.wxz++;
            }
         } else {
            if (Math.abs(var2.wxz) < this.cd.turn[this.cn] * 2) {
               var2.wxz = 0;
            }

            if (var2.wxz > 0) {
               var2.wxz = var2.wxz - this.cd.turn[this.cn] * 2;
            }

            if (var2.wxz < 0) {
               var2.wxz = var2.wxz + this.cd.turn[this.cn] * 2;
            }
         }
      }

      int var59 = (int)(3600.0F / (this.speed * this.speed));
      if (var59 < 5) {
         var59 = 5;
      }

      if (this.speed < 0.0F) {
         var59 = -var59;
      }

      if (this.wtouch) {
         if (!this.capsized) {
            if (!var1.handb) {
               this.fxz = var2.wxz / (var59 * 3);
            } else {
               this.fxz = var2.wxz / var59;
            }

            var2.xz = var2.xz + var2.wxz / var59;
         }

         this.wtouch = false;
         this.gtouch = false;
      } else {
         var2.xz = var2.xz + this.fxz;
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

      float[] var61 = new float[4];
      float[] var20 = new float[4];
      float[] var21 = new float[4];

      for (int var22 = 0; var22 < 4; var22++) {
         var61[var22] = var2.keyx[var22] + var2.x;
         var21[var22] = var13 + var2.y;
         var20[var22] = var2.z + var2.keyz[var22];
         this.scy[var22] = this.scy[var22] + 7.0F;
      }

      this.rot(var61, var21, var2.x, var2.y, this.pxy, 4);
      this.rot(var21, var20, var2.y, var2.z, this.pzy, 4);
      this.rot(var61, var20, var2.x, var2.z, var2.xz, 4);
      boolean var62 = false;
      double var23 = 0.0;
      int var25 = (int)((this.scx[0] + this.scx[1] + this.scx[2] + this.scx[3]) / 4.0F);
      int var26 = (int)((this.scz[0] + this.scz[1] + this.scz[2] + this.scz[3]) / 4.0F);

      for (int var27 = 0; var27 < 4; var27++) {
         if (this.scx[var27] - var25 > 200.0F) {
            this.scx[var27] = 200 + var25;
         }

         if (this.scx[var27] - var25 < -200.0F) {
            this.scx[var27] = var25 - 200;
         }

         if (this.scz[var27] - var26 > 200.0F) {
            this.scz[var27] = 200 + var26;
         }

         if (this.scz[var27] - var26 < -200.0F) {
            this.scz[var27] = var26 - 200;
         }
      }

      for (int var68 = 0; var68 < 4; var68++) {
         var21[var68] += this.scy[var68];
         var61[var68] += (this.scx[0] + this.scx[1] + this.scx[2] + this.scx[3]) / 4.0F;
         var20[var68] += (this.scz[0] + this.scz[1] + this.scz[2] + this.scz[3]) / 4.0F;
      }

      int var69 = (var2.x - var3.sx) / 3000;
      if (var69 > var3.ncx) {
         var69 = var3.ncx;
      }

      if (var69 < 0) {
         var69 = 0;
      }

      int var28 = (var2.z - var3.sz) / 3000;
      if (var28 > var3.ncz) {
         var28 = var3.ncz;
      }

      if (var28 < 0) {
         var28 = 0;
      }

      int var29 = 1;

      for (int var30 = 0; var30 < var3.sect[var69][var28].length; var30++) {
         int var31 = var3.sect[var69][var28][var30];
         if (Math.abs(var3.zy[var31]) != 90
            && Math.abs(var3.xy[var31]) != 90
            && Math.abs(var2.x - var3.x[var31]) < var3.radx[var31]
            && Math.abs(var2.z - var3.z[var31]) < var3.radz[var31]
            && (!var3.decor[var31] || this.m.resdown != 2 || this.xt.multion != 0)) {
            var29 = var3.skd[var31];
         }
      }

      if (this.mtouch) {
         float var70 = this.cd.grip[this.cn];
         var70 -= Math.abs(this.txz - var2.xz) * this.speed / 250.0F;
         if (var1.handb) {
            var70 -= Math.abs(this.txz - var2.xz) * 4;
         }

         if (var70 < this.cd.grip[this.cn]) {
            if (this.skid != 2) {
               this.skid = 1;
            }

            this.speed = this.speed - this.speed / 100.0F;
         } else if (this.skid == 1) {
            this.skid = 2;
         }

         if (var29 == 1) {
            var70 = (float)(var70 * 0.75);
         }

         if (var29 == 2) {
            var70 = (float)(var70 * 0.55);
         }

         int var73 = -((int)(this.speed * this.m.sin(var2.xz) * this.m.cos(this.pzy)));
         int var32 = (int)(this.speed * this.m.cos(var2.xz) * this.m.cos(this.pzy));
         int var33 = -((int)(this.speed * this.m.sin(this.pzy)));
         if (this.capsized || this.dest || var4.haltall) {
            var73 = 0;
            var32 = 0;
            var33 = 0;
            var70 = this.cd.grip[this.cn] / 5.0F;
            if (this.speed > 0.0F) {
               this.speed -= 2.0F;
            } else {
               this.speed += 2.0F;
            }
         }

         if (Math.abs(this.speed) > this.drag) {
            if (this.speed > 0.0F) {
               this.speed = this.speed - this.drag;
            } else {
               this.speed = this.speed + this.drag;
            }
         } else {
            this.speed = 0.0F;
         }

         if (this.cn == 8 && var70 < 5.0F) {
            var70 = 5.0F;
         }

         if (var70 < 1.0F) {
            var70 = 1.0F;
         }

         float var34 = 0.0F;
         float var35 = 0.0F;

         for (int var36 = 0; var36 < 4; var36++) {
            if (Math.abs(this.scx[var36] - var73) > var70) {
               if (this.scx[var36] < var73) {
                  this.scx[var36] = this.scx[var36] + var70;
               } else {
                  this.scx[var36] = this.scx[var36] - var70;
               }
            } else {
               this.scx[var36] = var73;
            }

            if (Math.abs(this.scz[var36] - var32) > var70) {
               if (this.scz[var36] < var32) {
                  this.scz[var36] = this.scz[var36] + var70;
               } else {
                  this.scz[var36] = this.scz[var36] - var70;
               }
            } else {
               this.scz[var36] = var32;
            }

            if (Math.abs(this.scy[var36] - var33) > var70) {
               if (this.scy[var36] < var33) {
                  this.scy[var36] = this.scy[var36] + var70;
               } else {
                  this.scy[var36] = this.scy[var36] - var70;
               }
            } else {
               this.scy[var36] = var33;
            }

            if (var70 < this.cd.grip[this.cn]) {
               if (this.txz != var2.xz) {
                  this.dcnt++;
               } else if (this.dcnt != 0) {
                  this.dcnt = 0;
               }

               if (!(this.dcnt > 40.0F * var70 / this.cd.grip[this.cn]) && !this.capsized) {
                  if (var29 == 1 && this.m.random() > 0.8) {
                     var2.dust(
                        var36,
                        var61[var36],
                        var21[var36],
                        var20[var36],
                        (int)this.scx[var36],
                        (int)this.scz[var36],
                        1.1F * this.cd.simag[this.cn],
                        (int)this.tilt,
                        this.capsized && this.mtouch
                     );
                  }

                  if ((var29 == 2 || var29 == 3) && this.m.random() > 0.6) {
                     var2.dust(
                        var36,
                        var61[var36],
                        var21[var36],
                        var20[var36],
                        (int)this.scx[var36],
                        (int)this.scz[var36],
                        1.15F * this.cd.simag[this.cn],
                        (int)this.tilt,
                        this.capsized && this.mtouch
                     );
                  }
               } else {
                  float var37 = 1.0F;
                  if (var29 != 0) {
                     var37 = 1.2F;
                  }

                  if (this.m.random() > 0.65) {
                     var2.dust(
                        var36,
                        var61[var36],
                        var21[var36],
                        var20[var36],
                        (int)this.scx[var36],
                        (int)this.scz[var36],
                        var37 * this.cd.simag[this.cn],
                        (int)this.tilt,
                        this.capsized && this.mtouch
                     );
                     if (this.im == this.xt.im && !this.capsized) {
                        this.xt.skid(var29, (float)Math.sqrt(this.scx[var36] * this.scx[var36] + this.scz[var36] * this.scz[var36]));
                     }
                  }
               }
            } else if (this.dcnt != 0) {
               this.dcnt -= 2;
               if (this.dcnt < 0) {
                  this.dcnt = 0;
               }
            }

            if (var29 == 3) {
               int var90 = (int)(this.m.random() * 4.0F);
               this.scy[var90] = (float)(-100.0F * this.m.random() * (this.speed / this.cd.swits[this.cn][2]) * (this.cd.bounce[this.cn] - 0.3));
            }

            if (var29 == 4) {
               int var91 = (int)(this.m.random() * 4.0F);
               this.scy[var91] = (float)(-150.0F * this.m.random() * (this.speed / this.cd.swits[this.cn][2]) * (this.cd.bounce[this.cn] - 0.3));
            }

            var34 += this.scx[var36];
            var35 += this.scz[var36];
         }

         this.txz = var2.xz;
         if (var34 > 0.0F) {
            var5 = -1;
         } else {
            var5 = 1;
         }

         var23 = var35 / Math.sqrt(var34 * var34 + var35 * var35);
         this.mxz = (int)(Math.acos(var23) / (Math.PI / 180.0) * var5);
         if (this.skid == 2) {
            if (!this.capsized) {
               var34 /= 4.0F;
               var35 /= 4.0F;
               if (var8) {
                  this.speed = -((float)Math.sqrt(var34 * var34 + var35 * var35) * this.m.cos(this.mxz - var2.xz));
               } else {
                  this.speed = (float)Math.sqrt(var34 * var34 + var35 * var35) * this.m.cos(this.mxz - var2.xz);
               }
            }

            this.skid = 0;
         }

         if (this.capsized && var34 == 0.0F && var35 == 0.0F) {
            var29 = 0;
         }

         this.mtouch = false;
         var62 = true;
      } else if (this.skid != 2) {
         this.skid = 2;
      }

      int var72 = 0;
      boolean[] var74 = new boolean[4];
      boolean[] var75 = new boolean[4];
      boolean[] var76 = new boolean[4];
      float var77 = 0.0F;

      for (int var79 = 0; var79 < 4; var79++) {
         var75[var79] = false;
         var76[var79] = false;
         if (var21[var79] > 245.0F) {
            var72++;
            this.wtouch = true;
            this.gtouch = true;
            if (!var62 && this.scy[var79] != 7.0F) {
               float var82 = this.scy[var79] / 333.33F;
               if (var82 > 0.3) {
                  var82 = 0.3F;
               }

               if (var29 == 0) {
                  var82 = (float)(var82 + 1.1);
               } else {
                  var82 = (float)(var82 + 1.2);
               }

               var2.dust(
                  var79,
                  var61[var79],
                  var21[var79],
                  var20[var79],
                  (int)this.scx[var79],
                  (int)this.scz[var79],
                  var82 * this.cd.simag[this.cn],
                  0,
                  this.capsized && this.mtouch
               );
            }

            var21[var79] = 250.0F;
            var76[var79] = true;
            var77 += var21[var79] - 250.0F;
            float var84 = Math.abs(this.m.sin(this.pxy)) + Math.abs(this.m.sin(this.pzy));
            var84 /= 3.0F;
            if (var84 > 0.4) {
               var84 = 0.4F;
            }

            var84 += this.cd.bounce[this.cn];
            if (var84 < 1.1) {
               var84 = 1.1F;
            }

            this.regy(var79, Math.abs(this.scy[var79] * var84), var2);
            if (this.scy[var79] > 0.0F) {
               this.scy[var79] = this.scy[var79] - Math.abs(this.scy[var79] * var84);
            }

            if (this.capsized) {
               var75[var79] = true;
            }
         }

         var74[var79] = false;
      }

      if (var72 != 0) {
         var77 /= var72;

         for (int var80 = 0; var80 < 4; var80++) {
            if (!var76[var80]) {
               var21[var80] -= var77;
            }
         }
      }

      int var81 = 0;

      for (int var87 = 0; var87 < var3.sect[var69][var28].length; var87++) {
         int var92 = var3.sect[var69][var28][var87];
         int var38 = 0;
         int var39 = 0;

         for (int var40 = 0; var40 < 4; var40++) {
            if (var75[var40]
               && (var3.skd[var92] == 0 || var3.skd[var92] == 1)
               && var61[var40] > var3.x[var92] - var3.radx[var92]
               && var61[var40] < var3.x[var92] + var3.radx[var92]
               && var20[var40] > var3.z[var92] - var3.radz[var92]
               && var20[var40] < var3.z[var92] + var3.radz[var92]) {
               var2.sprk(var61[var40], var21[var40], var20[var40], this.scx[var40], this.scy[var40], this.scz[var40], 1);
               if (this.im == this.xt.im) {
                  this.xt.gscrape((int)this.scx[var40], (int)this.scy[var40], (int)this.scz[var40]);
               }
            }

            if (!var74[var40]
               && var61[var40] > var3.x[var92] - var3.radx[var92]
               && var61[var40] < var3.x[var92] + var3.radx[var92]
               && var20[var40] > var3.z[var92] - var3.radz[var92]
               && var20[var40] < var3.z[var92] + var3.radz[var92]
               && var21[var40] > var3.y[var92] - var3.rady[var92]
               && var21[var40] < var3.y[var92] + var3.rady[var92]
               && (!var3.decor[var92] || this.m.resdown != 2 || this.xt.multion != 0)) {
               if (var3.xy[var92] == 0 && var3.zy[var92] == 0 && var3.y[var92] != 250 && var21[var40] > var3.y[var92] - 5) {
                  var39++;
                  this.wtouch = true;
                  this.gtouch = true;
                  if (!var62 && this.scy[var40] != 7.0F) {
                     float var41 = this.scy[var40] / 333.33F;
                     if (var41 > 0.3) {
                        var41 = 0.3F;
                     }

                     if (var29 == 0) {
                        var41 = (float)(var41 + 1.1);
                     } else {
                        var41 = (float)(var41 + 1.2);
                     }

                     var2.dust(
                        var40,
                        var61[var40],
                        var21[var40],
                        var20[var40],
                        (int)this.scx[var40],
                        (int)this.scz[var40],
                        var41 * this.cd.simag[this.cn],
                        0,
                        this.capsized && this.mtouch
                     );
                  }

                  var21[var40] = var3.y[var92];
                  if (this.capsized && (var3.skd[var92] == 0 || var3.skd[var92] == 1)) {
                     var2.sprk(var61[var40], var21[var40], var20[var40], this.scx[var40], this.scy[var40], this.scz[var40], 1);
                     if (this.im == this.xt.im) {
                        this.xt.gscrape((int)this.scx[var40], (int)this.scy[var40], (int)this.scz[var40]);
                     }
                  }

                  float var105 = Math.abs(this.m.sin(this.pxy)) + Math.abs(this.m.sin(this.pzy));
                  var105 /= 3.0F;
                  if (var105 > 0.4) {
                     var105 = 0.4F;
                  }

                  var105 += this.cd.bounce[this.cn];
                  if (var105 < 1.1) {
                     var105 = 1.1F;
                  }

                  this.regy(var40, Math.abs(this.scy[var40] * var105), var2);
                  if (this.scy[var40] > 0.0F) {
                     this.scy[var40] = this.scy[var40] - Math.abs(this.scy[var40] * var105);
                  }

                  var74[var40] = true;
               }

               if (var3.zy[var92] == -90 && var20[var40] < var3.z[var92] + var3.radz[var92] && (this.scz[var40] < 0.0F || var3.radz[var92] == 287)) {
                  for (int var108 = 0; var108 < 4; var108++) {
                     if (var40 != var108 && var20[var108] >= var3.z[var92] + var3.radz[var92]) {
                        var20[var108] -= var20[var40] - (var3.z[var92] + var3.radz[var92]);
                     }
                  }

                  var20[var40] = var3.z[var92] + var3.radz[var92];
                  if (var3.skd[var92] != 2) {
                     this.crank[0][var40]++;
                  }

                  if (var3.skd[var92] == 5 && this.m.random() > this.m.random()) {
                     this.crank[0][var40]++;
                  }

                  if (this.crank[0][var40] > 1) {
                     var2.sprk(var61[var40], var21[var40], var20[var40], this.scx[var40], this.scy[var40], this.scz[var40], 0);
                     if (this.im == this.xt.im) {
                        this.xt.scrape((int)this.scx[var40], (int)this.scy[var40], (int)this.scz[var40]);
                     }
                  }

                  float var109 = Math.abs(this.m.cos(this.pxy)) + Math.abs(this.m.cos(this.pzy));
                  var109 /= 4.0F;
                  if (var109 > 0.3) {
                     var109 = 0.3F;
                  }

                  if (var62) {
                     var109 = 0.0F;
                  }

                  var109 = (float)(var109 + (this.cd.bounce[this.cn] - 0.2));
                  if (var109 < 1.1) {
                     var109 = 1.1F;
                  }

                  this.regz(var40, Math.abs(this.scz[var40] * var109 * var3.dam[var92]), var2);
                  this.scz[var40] = this.scz[var40] + Math.abs(this.scz[var40] * var109);
                  this.skid = 2;
                  var9 = true;
                  var74[var40] = true;
                  if (!var3.notwall[var92]) {
                     var1.wall = var92;
                  }
               }

               if (var3.zy[var92] == 90 && var20[var40] > var3.z[var92] - var3.radz[var92] && (this.scz[var40] > 0.0F || var3.radz[var92] == 287)) {
                  for (int var112 = 0; var112 < 4; var112++) {
                     if (var40 != var112 && var20[var112] <= var3.z[var92] - var3.radz[var92]) {
                        var20[var112] -= var20[var40] - (var3.z[var92] - var3.radz[var92]);
                     }
                  }

                  var20[var40] = var3.z[var92] - var3.radz[var92];
                  if (var3.skd[var92] != 2) {
                     this.crank[1][var40]++;
                  }

                  if (var3.skd[var92] == 5 && this.m.random() > this.m.random()) {
                     this.crank[1][var40]++;
                  }

                  if (this.crank[1][var40] > 1) {
                     var2.sprk(var61[var40], var21[var40], var20[var40], this.scx[var40], this.scy[var40], this.scz[var40], 0);
                     if (this.im == this.xt.im) {
                        this.xt.scrape((int)this.scx[var40], (int)this.scy[var40], (int)this.scz[var40]);
                     }
                  }

                  float var113 = Math.abs(this.m.cos(this.pxy)) + Math.abs(this.m.cos(this.pzy));
                  var113 /= 4.0F;
                  if (var113 > 0.3) {
                     var113 = 0.3F;
                  }

                  if (var62) {
                     var113 = 0.0F;
                  }

                  var113 = (float)(var113 + (this.cd.bounce[this.cn] - 0.2));
                  if (var113 < 1.1) {
                     var113 = 1.1F;
                  }

                  this.regz(var40, -Math.abs(this.scz[var40] * var113 * var3.dam[var92]), var2);
                  this.scz[var40] = this.scz[var40] - Math.abs(this.scz[var40] * var113);
                  this.skid = 2;
                  var9 = true;
                  var74[var40] = true;
                  if (!var3.notwall[var92]) {
                     var1.wall = var92;
                  }
               }

               if (var3.xy[var92] == -90 && var61[var40] < var3.x[var92] + var3.radx[var92] && (this.scx[var40] < 0.0F || var3.radx[var92] == 287)) {
                  for (int var116 = 0; var116 < 4; var116++) {
                     if (var40 != var116 && var61[var116] >= var3.x[var92] + var3.radx[var92]) {
                        var61[var116] -= var61[var40] - (var3.x[var92] + var3.radx[var92]);
                     }
                  }

                  var61[var40] = var3.x[var92] + var3.radx[var92];
                  if (var3.skd[var92] != 2) {
                     this.crank[2][var40]++;
                  }

                  if (var3.skd[var92] == 5 && this.m.random() > this.m.random()) {
                     this.crank[2][var40]++;
                  }

                  if (this.crank[2][var40] > 1) {
                     var2.sprk(var61[var40], var21[var40], var20[var40], this.scx[var40], this.scy[var40], this.scz[var40], 0);
                     if (this.im == this.xt.im) {
                        this.xt.scrape((int)this.scx[var40], (int)this.scy[var40], (int)this.scz[var40]);
                     }
                  }

                  float var117 = Math.abs(this.m.cos(this.pxy)) + Math.abs(this.m.cos(this.pzy));
                  var117 /= 4.0F;
                  if (var117 > 0.3) {
                     var117 = 0.3F;
                  }

                  if (var62) {
                     var117 = 0.0F;
                  }

                  var117 = (float)(var117 + (this.cd.bounce[this.cn] - 0.2));
                  if (var117 < 1.1) {
                     var117 = 1.1F;
                  }

                  this.regx(var40, Math.abs(this.scx[var40] * var117 * var3.dam[var92]), var2);
                  this.scx[var40] = this.scx[var40] + Math.abs(this.scx[var40] * var117);
                  this.skid = 2;
                  var9 = true;
                  var74[var40] = true;
                  if (!var3.notwall[var92]) {
                     var1.wall = var92;
                  }
               }

               if (var3.xy[var92] == 90 && var61[var40] > var3.x[var92] - var3.radx[var92] && (this.scx[var40] > 0.0F || var3.radx[var92] == 287)) {
                  for (int var120 = 0; var120 < 4; var120++) {
                     if (var40 != var120 && var61[var120] <= var3.x[var92] - var3.radx[var92]) {
                        var61[var120] -= var61[var40] - (var3.x[var92] - var3.radx[var92]);
                     }
                  }

                  var61[var40] = var3.x[var92] - var3.radx[var92];
                  if (var3.skd[var92] != 2) {
                     this.crank[3][var40]++;
                  }

                  if (var3.skd[var92] == 5 && this.m.random() > this.m.random()) {
                     this.crank[3][var40]++;
                  }

                  if (this.crank[3][var40] > 1) {
                     var2.sprk(var61[var40], var21[var40], var20[var40], this.scx[var40], this.scy[var40], this.scz[var40], 0);
                     if (this.im == this.xt.im) {
                        this.xt.scrape((int)this.scx[var40], (int)this.scy[var40], (int)this.scz[var40]);
                     }
                  }

                  float var121 = Math.abs(this.m.cos(this.pxy)) + Math.abs(this.m.cos(this.pzy));
                  var121 /= 4.0F;
                  if (var121 > 0.3) {
                     var121 = 0.3F;
                  }

                  if (var62) {
                     var121 = 0.0F;
                  }

                  var121 = (float)(var121 + (this.cd.bounce[this.cn] - 0.2));
                  if (var121 < 1.1) {
                     var121 = 1.1F;
                  }

                  this.regx(var40, -Math.abs(this.scx[var40] * var121 * var3.dam[var92]), var2);
                  this.scx[var40] = this.scx[var40] - Math.abs(this.scx[var40] * var121);
                  this.skid = 2;
                  var9 = true;
                  var74[var40] = true;
                  if (!var3.notwall[var92]) {
                     var1.wall = var92;
                  }
               }

               if (var3.zy[var92] != 0 && var3.zy[var92] != 90 && var3.zy[var92] != -90) {
                  int var124 = 90 + var3.zy[var92];
                  float var42 = 1.0F + (50 - Math.abs(var3.zy[var92])) / 30.0F;
                  if (var42 < 1.0F) {
                     var42 = 1.0F;
                  }

                  float var43 = var3.y[var92] + ((var21[var40] - var3.y[var92]) * this.m.cos(var124) - (var20[var40] - var3.z[var92]) * this.m.sin(var124));
                  float var44 = var3.z[var92] + ((var21[var40] - var3.y[var92]) * this.m.sin(var124) + (var20[var40] - var3.z[var92]) * this.m.cos(var124));
                  if (var44 > var3.z[var92] && var44 < var3.z[var92] + 200) {
                     this.scy[var40] = this.scy[var40] - (var44 - var3.z[var92]) / var42;
                     var44 = var3.z[var92];
                  }

                  if (var44 > var3.z[var92] - 30) {
                     if (var3.skd[var92] == 2) {
                        var38++;
                     } else {
                        var81++;
                     }

                     this.wtouch = true;
                     this.gtouch = false;
                     if (this.capsized && (var3.skd[var92] == 0 || var3.skd[var92] == 1)) {
                        var2.sprk(var61[var40], var21[var40], var20[var40], this.scx[var40], this.scy[var40], this.scz[var40], 1);
                        if (this.im == this.xt.im) {
                           this.xt.gscrape((int)this.scx[var40], (int)this.scy[var40], (int)this.scz[var40]);
                        }
                     }

                     if (!var62 && var29 != 0) {
                        float var45 = 1.4F;
                        var2.dust(
                           var40,
                           var61[var40],
                           var21[var40],
                           var20[var40],
                           (int)this.scx[var40],
                           (int)this.scz[var40],
                           var45 * this.cd.simag[this.cn],
                           0,
                           this.capsized && this.mtouch
                        );
                     }
                  }

                  var21[var40] = var3.y[var92] + ((var43 - var3.y[var92]) * this.m.cos(-var124) - (var44 - var3.z[var92]) * this.m.sin(-var124));
                  var20[var40] = var3.z[var92] + ((var43 - var3.y[var92]) * this.m.sin(-var124) + (var44 - var3.z[var92]) * this.m.cos(-var124));
                  var74[var40] = true;
               }

               if (var3.xy[var92] != 0 && var3.xy[var92] != 90 && var3.xy[var92] != -90) {
                  int var125 = 90 + var3.xy[var92];
                  float var127 = 1.0F + (50 - Math.abs(var3.xy[var92])) / 30.0F;
                  if (var127 < 1.0F) {
                     var127 = 1.0F;
                  }

                  float var130 = var3.y[var92] + ((var21[var40] - var3.y[var92]) * this.m.cos(var125) - (var61[var40] - var3.x[var92]) * this.m.sin(var125));
                  float var135 = var3.x[var92] + ((var21[var40] - var3.y[var92]) * this.m.sin(var125) + (var61[var40] - var3.x[var92]) * this.m.cos(var125));
                  if (var135 > var3.x[var92] && var135 < var3.x[var92] + 200) {
                     this.scy[var40] = this.scy[var40] - (var135 - var3.x[var92]) / var127;
                     var135 = var3.x[var92];
                  }

                  if (var135 > var3.x[var92] - 30) {
                     if (var3.skd[var92] == 2) {
                        var38++;
                     } else {
                        var81++;
                     }

                     this.wtouch = true;
                     this.gtouch = false;
                     if (this.capsized && (var3.skd[var92] == 0 || var3.skd[var92] == 1)) {
                        var2.sprk(var61[var40], var21[var40], var20[var40], this.scx[var40], this.scy[var40], this.scz[var40], 1);
                        if (this.im == this.xt.im) {
                           this.xt.gscrape((int)this.scx[var40], (int)this.scy[var40], (int)this.scz[var40]);
                        }
                     }

                     if (!var62 && var29 != 0) {
                        float var137 = 1.4F;
                        var2.dust(
                           var40,
                           var61[var40],
                           var21[var40],
                           var20[var40],
                           (int)this.scx[var40],
                           (int)this.scz[var40],
                           var137 * this.cd.simag[this.cn],
                           0,
                           this.capsized && this.mtouch
                        );
                     }
                  }

                  var21[var40] = var3.y[var92] + ((var130 - var3.y[var92]) * this.m.cos(-var125) - (var135 - var3.x[var92]) * this.m.sin(-var125));
                  var61[var40] = var3.x[var92] + ((var130 - var3.y[var92]) * this.m.sin(-var125) + (var135 - var3.x[var92]) * this.m.cos(-var125));
                  var74[var40] = true;
               }
            }
         }

         if (var38 == 4) {
            this.mtouch = true;
         }

         if (var39 == 4) {
            var72 = 4;
         }
      }

      if (var81 == 4) {
         this.mtouch = true;
      }

      for (int var88 = 0; var88 < 4; var88++) {
         for (int var93 = 0; var93 < 4; var93++) {
            if (this.crank[var88][var93] == this.lcrank[var88][var93]) {
               this.crank[var88][var93] = 0;
            }

            this.lcrank[var88][var93] = this.crank[var88][var93];
         }
      }

      int var89 = 0;
      int var94 = 0;
      int var95 = 0;
      int var96 = 0;
      if (this.scy[2] != this.scy[0]) {
         if (this.scy[2] < this.scy[0]) {
            var5 = -1;
         } else {
            var5 = 1;
         }

         var23 = Math.sqrt(
               (var20[0] - var20[2]) * (var20[0] - var20[2]) + (var21[0] - var21[2]) * (var21[0] - var21[2]) + (var61[0] - var61[2]) * (var61[0] - var61[2])
            )
            / (Math.abs(var2.keyz[0]) + Math.abs(var2.keyz[2]));
         if (var23 >= 0.9998) {
            var89 = var5;
         } else {
            var89 = (int)(Math.acos(var23) / (Math.PI / 180.0) * var5);
         }
      }

      if (this.scy[3] != this.scy[1]) {
         if (this.scy[3] < this.scy[1]) {
            var5 = -1;
         } else {
            var5 = 1;
         }

         var23 = Math.sqrt(
               (var20[1] - var20[3]) * (var20[1] - var20[3]) + (var21[1] - var21[3]) * (var21[1] - var21[3]) + (var61[1] - var61[3]) * (var61[1] - var61[3])
            )
            / (Math.abs(var2.keyz[1]) + Math.abs(var2.keyz[3]));
         if (var23 >= 0.9998) {
            var94 = var5;
         } else {
            var94 = (int)(Math.acos(var23) / (Math.PI / 180.0) * var5);
         }
      }

      if (this.scy[1] != this.scy[0]) {
         if (this.scy[1] < this.scy[0]) {
            var5 = -1;
         } else {
            var5 = 1;
         }

         var23 = Math.sqrt(
               (var20[0] - var20[1]) * (var20[0] - var20[1]) + (var21[0] - var21[1]) * (var21[0] - var21[1]) + (var61[0] - var61[1]) * (var61[0] - var61[1])
            )
            / (Math.abs(var2.keyx[0]) + Math.abs(var2.keyx[1]));
         if (var23 >= 0.9998) {
            var95 = var5;
         } else {
            var95 = (int)(Math.acos(var23) / (Math.PI / 180.0) * var5);
         }
      }

      if (this.scy[3] != this.scy[2]) {
         if (this.scy[3] < this.scy[2]) {
            var5 = -1;
         } else {
            var5 = 1;
         }

         var23 = Math.sqrt(
               (var20[2] - var20[3]) * (var20[2] - var20[3]) + (var21[2] - var21[3]) * (var21[2] - var21[3]) + (var61[2] - var61[3]) * (var61[2] - var61[3])
            )
            / (Math.abs(var2.keyx[2]) + Math.abs(var2.keyx[3]));
         if (var23 >= 0.9998) {
            var96 = var5;
         } else {
            var96 = (int)(Math.acos(var23) / (Math.PI / 180.0) * var5);
         }
      }

      if (var9) {
         int var97 = Math.abs(var2.xz + 45);

         while (var97 > 180) {
            var97 -= 360;
         }

         if (Math.abs(var97) > 90) {
            this.pmlt = 1;
         } else {
            this.pmlt = -1;
         }

         var97 = Math.abs(var2.xz - 45);

         while (var97 > 180) {
            var97 -= 360;
         }

         if (Math.abs(var97) > 90) {
            this.nmlt = 1;
         } else {
            this.nmlt = -1;
         }
      }

      var2.xz = (int)(
         var2.xz
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
      if (Math.abs(var94) > Math.abs(var89)) {
         var89 = var94;
      }

      if (Math.abs(var96) > Math.abs(var95)) {
         var95 = var96;
      }

      if (!var7) {
         this.pzy += var89;
      } else {
         this.pzy -= var89;
      }

      if (!var11) {
         this.pxy += var95;
      } else {
         this.pxy -= var95;
      }

      if (var72 == 4) {
         int var99;
         for (var99 = 0; this.pzy < 360; var2.zy += 360) {
            this.pzy += 360;
         }

         while (this.pzy > 360) {
            this.pzy -= 360;
            var2.zy -= 360;
         }

         if (this.pzy < 190 && this.pzy > 170) {
            this.pzy = 180;
            var2.zy = 180;
            var99++;
         }

         if (this.pzy > 350 || this.pzy < 10) {
            this.pzy = 0;
            var2.zy = 0;
            var99++;
         }

         while (this.pxy < 360) {
            this.pxy += 360;
            var2.xy += 360;
         }

         while (this.pxy > 360) {
            this.pxy -= 360;
            var2.xy -= 360;
         }

         if (this.pxy < 190 && this.pxy > 170) {
            this.pxy = 180;
            var2.xy = 180;
            var99++;
         }

         if (this.pxy > 350 || this.pxy < 10) {
            this.pxy = 0;
            var2.xy = 0;
            var99++;
         }

         if (var99 == 2) {
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

      var2.y = (int)((var21[0] + var21[1] + var21[2] + var21[3]) / 4.0F - var13 * this.m.cos(this.pzy) * this.m.cos(this.pxy) + var16);
      if (var7) {
         var5 = -1;
      } else {
         var5 = 1;
      }

      var2.x = (int)(
         (
                  var61[0]
                     - var2.keyx[0] * this.m.cos(var2.xz)
                     + var5 * var2.keyz[0] * this.m.sin(var2.xz)
                     + var61[1]
                     - var2.keyx[1] * this.m.cos(var2.xz)
                     + var5 * var2.keyz[1] * this.m.sin(var2.xz)
                     + var61[2]
                     - var2.keyx[2] * this.m.cos(var2.xz)
                     + var5 * var2.keyz[2] * this.m.sin(var2.xz)
                     + var61[3]
                     - var2.keyx[3] * this.m.cos(var2.xz)
                     + var5 * var2.keyz[3] * this.m.sin(var2.xz)
               )
               / 4.0F
            + var13 * this.m.sin(this.pxy) * this.m.cos(var2.xz)
            - var13 * this.m.sin(this.pzy) * this.m.sin(var2.xz)
            + var14
      );
      var2.z = (int)(
         (
                  var20[0]
                     - var5 * var2.keyz[0] * this.m.cos(var2.xz)
                     - var2.keyx[0] * this.m.sin(var2.xz)
                     + var20[1]
                     - var5 * var2.keyz[1] * this.m.cos(var2.xz)
                     - var2.keyx[1] * this.m.sin(var2.xz)
                     + var20[2]
                     - var5 * var2.keyz[2] * this.m.cos(var2.xz)
                     - var2.keyx[2] * this.m.sin(var2.xz)
                     + var20[3]
                     - var5 * var2.keyz[3] * this.m.cos(var2.xz)
                     - var2.keyx[3] * this.m.sin(var2.xz)
               )
               / 4.0F
            + var13 * this.m.sin(this.pxy) * this.m.sin(var2.xz)
            - var13 * this.m.sin(this.pzy) * this.m.cos(var2.xz)
            + var15
      );
      if (Math.abs(this.speed) > 10.0F || !this.mtouch) {
         if (Math.abs(this.pxy - var2.xy) >= 4) {
            if (this.pxy > var2.xy) {
               var2.xy = var2.xy + 2 + (this.pxy - var2.xy) / 2;
            } else {
               var2.xy = var2.xy - (2 + (var2.xy - this.pxy) / 2);
            }
         } else {
            var2.xy = this.pxy;
         }

         if (Math.abs(this.pzy - var2.zy) >= 4) {
            if (this.pzy > var2.zy) {
               var2.zy = var2.zy + 2 + (this.pzy - var2.zy) / 2;
            } else {
               var2.zy = var2.zy - (2 + (var2.zy - this.pzy) / 2);
            }
         } else {
            var2.zy = this.pzy;
         }
      }

      if (this.wtouch && !this.capsized) {
         float var100 = (float)(this.speed / this.cd.swits[this.cn][2] * 14.0F * (this.cd.bounce[this.cn] - 0.4));
         if (var1.left && this.tilt < var100 && this.tilt >= 0.0F) {
            this.tilt = (float)(this.tilt + 0.4);
         } else if (var1.right && this.tilt > -var100 && this.tilt <= 0.0F) {
            this.tilt = (float)(this.tilt - 0.4);
         } else if (Math.abs(this.tilt) > 3.0 * (this.cd.bounce[this.cn] - 0.4)) {
            if (this.tilt > 0.0F) {
               this.tilt = (float)(this.tilt - 3.0 * (this.cd.bounce[this.cn] - 0.3));
            } else {
               this.tilt = (float)(this.tilt + 3.0 * (this.cd.bounce[this.cn] - 0.3));
            }
         } else {
            this.tilt = 0.0F;
         }

         var2.xy = (int)(var2.xy + this.tilt);
         if (this.gtouch) {
            var2.y = (int)(var2.y - this.tilt / 1.5);
         }
      } else if (this.tilt != 0.0F) {
         this.tilt = 0.0F;
      }

      if (this.wtouch && var29 == 2) {
         var2.zy = var2.zy
            + (int)(
               (this.m.random() * 6.0F * this.speed / this.cd.swits[this.cn][2] - 3.0F * this.speed / this.cd.swits[this.cn][2])
                  * (this.cd.bounce[this.cn] - 0.3)
            );
         var2.xy = var2.xy
            + (int)(
               (this.m.random() * 6.0F * this.speed / this.cd.swits[this.cn][2] - 3.0F * this.speed / this.cd.swits[this.cn][2])
                  * (this.cd.bounce[this.cn] - 0.3)
            );
      }

      if (this.wtouch && var29 == 1) {
         var2.zy = var2.zy
            + (int)(
               (this.m.random() * 4.0F * this.speed / this.cd.swits[this.cn][2] - 2.0F * this.speed / this.cd.swits[this.cn][2])
                  * (this.cd.bounce[this.cn] - 0.3)
            );
         var2.xy = var2.xy
            + (int)(
               (this.m.random() * 4.0F * this.speed / this.cd.swits[this.cn][2] - 2.0F * this.speed / this.cd.swits[this.cn][2])
                  * (this.cd.bounce[this.cn] - 0.3)
            );
      }

      if (this.hitmag >= this.cd.maxmag[this.cn] && !this.dest) {
         this.distruct(var2);
         if (this.cntdest == 7) {
            this.dest = true;
         } else {
            this.cntdest++;
         }

         if (this.cntdest == 1) {
            this.rpd.dest[this.im] = 300;
         }
      }

      if (var2.dist == 0) {
         for (int var101 = 0; var101 < var2.npl; var101++) {
            if (var2.p[var101].chip != 0) {
               var2.p[var101].chip = 0;
            }

            if (var2.p[var101].embos != 0) {
               var2.p[var101].embos = 13;
            }
         }
      }

      int var102 = 0;
      int var126 = 0;
      int var128 = 0;
      if (this.nofocus) {
         var6 = 1;
      } else {
         var6 = 7;
      }

      for (int var131 = 0; var131 < var4.n; var131++) {
         if (var4.typ[var131] > 0) {
            var128++;
            if (var4.typ[var131] == 1) {
               if (this.clear == var128 + this.nlaps * var4.nsp) {
                  var6 = 1;
               }

               if (Math.abs(var2.z - var4.z[var131]) < 60.0F + Math.abs(this.scz[0] + this.scz[1] + this.scz[2] + this.scz[3]) / 4.0F
                  && Math.abs(var2.x - var4.x[var131]) < 700
                  && Math.abs(var2.y - var4.y[var131] + 350) < 450
                  && this.clear == var128 + this.nlaps * var4.nsp - 1) {
                  this.clear = var128 + this.nlaps * var4.nsp;
                  this.pcleared = var131;
                  this.focus = -1;
               }
            }

            if (var4.typ[var131] == 2) {
               if (this.clear == var128 + this.nlaps * var4.nsp) {
                  var6 = 1;
               }

               if (Math.abs(var2.x - var4.x[var131]) < 60.0F + Math.abs(this.scx[0] + this.scx[1] + this.scx[2] + this.scx[3]) / 4.0F
                  && Math.abs(var2.z - var4.z[var131]) < 700
                  && Math.abs(var2.y - var4.y[var131] + 350) < 450
                  && this.clear == var128 + this.nlaps * var4.nsp - 1) {
                  this.clear = var128 + this.nlaps * var4.nsp;
                  this.pcleared = var131;
                  this.focus = -1;
               }
            }
         }

         if (this.py(var2.x / 100, var4.x[var131] / 100, var2.z / 100, var4.z[var131] / 100) * var6 < var126 || var126 == 0) {
            var102 = var131;
            var126 = this.py(var2.x / 100, var4.x[var131] / 100, var2.z / 100, var4.z[var131] / 100) * var6;
         }
      }

      if (this.clear == var128 + this.nlaps * var4.nsp) {
         this.nlaps++;
         if (this.xt.multion == 1 && this.im == this.xt.im) {
            if (this.xt.laptime < this.xt.fastestlap || this.xt.fastestlap == 0) {
               this.xt.fastestlap = this.xt.laptime;
            }

            this.xt.laptime = 0;
         }
      }

      if (this.im == this.xt.im) {
         if (this.xt.multion == 1 && this.xt.starcnt == 0) {
            this.xt.laptime++;
         }

         this.m.checkpoint = this.clear;

         while (this.m.checkpoint >= var4.nsp) {
            this.m.checkpoint = this.m.checkpoint - var4.nsp;
         }

         if (this.clear == var4.nlaps * var4.nsp - 1) {
            this.m.lastcheck = true;
         }

         if (var4.haltall) {
            this.m.lastcheck = false;
         }
      }

      if (this.focus == -1) {
         if (this.im == this.xt.im) {
            var102 += 2;
         } else {
            var102++;
         }

         if (!this.nofocus) {
            var128 = this.pcleared + 1;
            if (var128 >= var4.n) {
               var128 = 0;
            }

            while (var4.typ[var128] <= 0) {
               if (++var128 >= var4.n) {
                  var128 = 0;
               }
            }

            if (var102 > var128 && (this.clear != this.nlaps * var4.nsp || var102 < this.pcleared)) {
               var102 = var128;
               this.focus = var128;
            }
         }

         if (var102 >= var4.n) {
            var102 -= var4.n;
         }

         if (var4.typ[var102] == -3) {
            var102 = 0;
         }

         if (this.im == this.xt.im) {
            if (this.missedcp != -1) {
               this.missedcp = -1;
            }
         } else if (this.missedcp != 0) {
            this.missedcp = 0;
         }
      } else {
         var102 = this.focus;
         if (this.im == this.xt.im) {
            if (this.missedcp == 0 && this.mtouch && Math.sqrt(this.py(var2.x / 10, var4.x[this.focus] / 10, var2.z / 10, var4.z[this.focus] / 10)) > 800.0) {
               this.missedcp = 1;
            }

            if (this.missedcp == -2 && Math.sqrt(this.py(var2.x / 10, var4.x[this.focus] / 10, var2.z / 10, var4.z[this.focus] / 10)) < 400.0) {
               this.missedcp = 0;
            }

            if (this.missedcp != 0 && this.mtouch && Math.sqrt(this.py(var2.x / 10, var4.x[this.focus] / 10, var2.z / 10, var4.z[this.focus] / 10)) < 250.0) {
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

      this.point = var102;
      if (this.fixes != 0) {
         if (this.m.noelec == 0) {
            for (int var132 = 0; var132 < var4.fn; var132++) {
               if (!var4.roted[var132]) {
                  if (Math.abs(var2.z - var4.fz[var132]) < 200 && this.py(var2.x / 100, var4.fx[var132] / 100, var2.y / 100, var4.fy[var132] / 100) < 30) {
                     if (var2.dist == 0) {
                        var2.fcnt = 8;
                     } else {
                        if (this.im == this.xt.im && !var2.fix && !this.xt.mutes) {
                           this.xt.carfixed.play();
                        }

                        var2.fix = true;
                     }

                     this.rpd.fix[this.im] = 300;
                  }
               } else if (Math.abs(var2.x - var4.fx[var132]) < 200 && this.py(var2.z / 100, var4.fz[var132] / 100, var2.y / 100, var4.fy[var132] / 100) < 30) {
                  if (var2.dist == 0) {
                     var2.fcnt = 8;
                  } else {
                     if (this.im == this.xt.im && !var2.fix && !this.xt.mutes) {
                        this.xt.carfixed.play();
                     }

                     var2.fix = true;
                  }

                  this.rpd.fix[this.im] = 300;
               }
            }
         }
      } else {
         for (int var133 = 0; var133 < var4.fn; var133++) {
            if (this.rpy(var2.x / 100, var4.fx[var133] / 100, var2.y / 100, var4.fy[var133] / 100, var2.z / 100, var4.fz[var133] / 100) < 760) {
               this.m.noelec = 2;
            }
         }
      }

      if (var2.fcnt == 7 || var2.fcnt == 8) {
         this.squash = 0;
         this.nbsq = 0;
         this.hitmag = 0;
         this.cntdest = 0;
         this.dest = false;
         this.newcar = true;
         var2.fcnt = 9;
         if (this.fixes > 0) {
            this.fixes--;
         }
      }

      if (this.newedcar != 0) {
         this.newedcar--;
         if (this.newedcar == 10) {
            this.newcar = false;
         }
      }

      if (!this.mtouch) {
         if (this.trcnt != 1) {
            this.trcnt = 1;
            this.lxz = var2.xz;
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

         if (this.lxz != var2.xz) {
            this.travxz = this.travxz + (this.lxz - var2.xz);
            this.lxz = var2.xz;
         }

         if (this.srfcnt < 10) {
            if (var1.wall != -1) {
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
                  if (this.im == this.xt.im
                     && (int)this.powerup > this.rpd.powered
                     && this.rpd.wasted == 0
                     && (this.powerup > 60.0F || var4.stage == 1 || var4.stage == 2)) {
                     this.rpdcatch = 30;
                     if (this.rpd.hcaught) {
                        this.rpd.powered = (int)this.powerup;
                     }

                     if (this.xt.multion == 1 && this.powerup > this.xt.beststunt) {
                        this.xt.beststunt = (int)this.powerup;
                     }
                  }

                  if (this.power > 98.0F) {
                     this.power = 98.0F;
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

            if (this.capcnt != 0) {
               this.capcnt++;
               if (this.capcnt == 30) {
                  this.speed = 0.0F;
                  var2.y = var2.y + this.cd.flipy[this.cn];
                  this.pxy += 180;
                  var2.xy += 180;
                  this.capcnt = 0;
               }
            } else {
               int var134 = 0;

               for (int var136 = 0; var136 < 4; var136++) {
                  if (Math.abs(this.scz[var136]) < 70.0F && Math.abs(this.scx[var136]) < 70.0F) {
                     var134++;
                  }
               }

               if (var134 == 4) {
                  this.capcnt = 1;
               }
            }
         }

         if (this.trcnt == 0 && this.speed != 0.0F) {
            if (this.xtpower == 0) {
               if (this.power > 0.0F) {
                  this.power = this.power - this.power * this.power * this.power / this.cd.powerloss[this.cn];
               } else {
                  this.power = 0.0F;
               }
            } else {
               this.xtpower--;
            }
         }
      }

      if (this.im == this.xt.im) {
         if (var1.wall != -1) {
            var1.wall = -1;
         }
      } else if (this.lastcolido != 0 && !this.dest) {
         this.lastcolido--;
      }

      if (this.dest) {
         if (var4.dested[this.im] == 0) {
            if (this.lastcolido == 0) {
               var4.dested[this.im] = 1;
            } else {
               var4.dested[this.im] = 2;
            }
         }
      } else if (var4.dested[this.im] != 0 && var4.dested[this.im] != 3) {
         var4.dested[this.im] = 0;
      }

      if (this.im == this.xt.im && this.rpd.wasted == 0 && this.rpdcatch != 0) {
         this.rpdcatch--;
         if (this.rpdcatch == 0) {
            this.rpd.cotchinow(this.im);
            if (this.rpd.hcaught) {
               this.rpd.whenwasted = (int)(185.0F + this.m.random() * 20.0F);
            }
         }
      }
   }

   public void distruct(ContO var1) {
      for (int var2 = 0; var2 < var1.npl; var2++) {
         if (var1.p[var2].wz == 0 || var1.p[var2].gr == -17 || var1.p[var2].gr == -16) {
            var1.p[var2].embos = 1;
         }
      }
   }

   public int regy(int var1, float var2, ContO var3) {
      int var4 = 0;
      boolean var5 = true;
      if (this.xt.multion == 1 && this.xt.im != this.im) {
         var5 = false;
      }

      if (this.xt.multion >= 2) {
         var5 = false;
      }

      if (this.xt.lan && this.xt.multion >= 1 && this.xt.isbot[this.im]) {
         var5 = true;
      }

      var2 *= this.cd.dammult[this.cn];
      if (var2 > 100.0F) {
         this.rpd.recy(var1, var2, this.mtouch, this.im);
         var2 -= 100.0F;
         byte var6 = 0;
         byte var7 = 0;
         int var8 = var3.zy;
         int var9 = var3.xy;

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

         if (var7 * var6 == 0) {
            this.shakedam = (int)((Math.abs(var2) + this.shakedam) / 2.0F);
         }

         if (this.im == this.xt.im || this.colidim) {
            this.xt.crash(var2, var7 * var6);
         }

         if (var7 * var6 == 0 || this.mtouch) {
            for (int var10 = 0; var10 < var3.npl; var10++) {
               float var11 = 0.0F;

               for (int var12 = 0; var12 < var3.p[var10].n; var12++) {
                  if (var3.p[var10].wz == 0
                     && this.py(var3.keyx[var1], var3.p[var10].ox[var12], var3.keyz[var1], var3.p[var10].oz[var12]) < this.cd.clrad[this.cn]) {
                     var11 = var2 / 20.0F * this.m.random();
                     var3.p[var10].oz[var12] = (int)(var3.p[var10].oz[var12] + var11 * this.m.sin(var8));
                     var3.p[var10].ox[var12] = (int)(var3.p[var10].ox[var12] - var11 * this.m.sin(var9));
                     if (var5) {
                        this.hitmag = (int)(this.hitmag + Math.abs(var11));
                        var4 = (int)(var4 + Math.abs(var11));
                     }
                  }
               }

               if (var11 != 0.0F) {
                  if (Math.abs(var11) >= 1.0F) {
                     var3.p[var10].chip = 1;
                     var3.p[var10].ctmag = var11;
                  }

                  if (!var3.p[var10].nocol && var3.p[var10].glass != 1) {
                     if (var3.p[var10].bfase > 20 && var3.p[var10].hsb[1] > 0.25) {
                        var3.p[var10].hsb[1] = 0.25F;
                     }

                     if (var3.p[var10].bfase > 25 && var3.p[var10].hsb[2] > 0.7) {
                        var3.p[var10].hsb[2] = 0.7F;
                     }

                     if (var3.p[var10].bfase > 30 && var3.p[var10].hsb[1] > 0.15) {
                        var3.p[var10].hsb[1] = 0.15F;
                     }

                     if (var3.p[var10].bfase > 35 && var3.p[var10].hsb[2] > 0.6) {
                        var3.p[var10].hsb[2] = 0.6F;
                     }

                     if (var3.p[var10].bfase > 40) {
                        var3.p[var10].hsb[0] = 0.075F;
                     }

                     if (var3.p[var10].bfase > 50 && var3.p[var10].hsb[2] > 0.5) {
                        var3.p[var10].hsb[2] = 0.5F;
                     }

                     if (var3.p[var10].bfase > 60) {
                        var3.p[var10].hsb[0] = 0.05F;
                     }

                     var3.p[var10].bfase = (int)(var3.p[var10].bfase + var11);
                     new Color(var3.p[var10].c[0], var3.p[var10].c[1], var3.p[var10].c[2]);
                     Color var19 = Color.getHSBColor(var3.p[var10].hsb[0], var3.p[var10].hsb[1], var3.p[var10].hsb[2]);
                     var3.p[var10].c[0] = var19.getRed();
                     var3.p[var10].c[1] = var19.getGreen();
                     var3.p[var10].c[2] = var19.getBlue();
                  }

                  if (var3.p[var10].glass == 1) {
                     var3.p[var10].gr = (int)(var3.p[var10].gr + Math.abs(var11 * 1.5));
                  }
               }
            }
         }

         if (var7 * var6 == -1) {
            if (this.nbsq > 0) {
               int var17 = 0;
               int var18 = 1;

               for (int var20 = 0; var20 < var3.npl; var20++) {
                  float var13 = 0.0F;

                  for (int var14 = 0; var14 < var3.p[var20].n; var14++) {
                     if (var3.p[var20].wz == 0) {
                        var13 = var2 / 15.0F * this.m.random();
                        if ((
                              Math.abs(var3.p[var20].oy[var14] - this.cd.flipy[this.cn] - this.squash) < this.cd.msquash[this.cn] * 3
                                 || var3.p[var20].oy[var14] < this.cd.flipy[this.cn] + this.squash
                           )
                           && this.squash < this.cd.msquash[this.cn]) {
                           var3.p[var20].oy[var14] = (int)(var3.p[var20].oy[var14] + var13);
                           var17 = (int)(var17 + var13);
                           var18++;
                           if (var5) {
                              this.hitmag = (int)(this.hitmag + Math.abs(var13));
                              var4 = (int)(var4 + Math.abs(var13));
                           }
                        }
                     }
                  }

                  if (var3.p[var20].glass == 1) {
                     var3.p[var20].gr += 5;
                  } else if (var13 != 0.0F) {
                     var3.p[var20].bfase = (int)(var3.p[var20].bfase + var13);
                  }

                  if (Math.abs(var13) >= 1.0F) {
                     var3.p[var20].chip = 1;
                     var3.p[var20].ctmag = var13;
                  }
               }

               this.squash += var17 / var18;
               this.nbsq = 0;
            } else {
               this.nbsq++;
            }
         }
      }

      return var4;
   }

   public int regx(int var1, float var2, ContO var3) {
      int var4 = 0;
      boolean var5 = true;
      if (this.xt.multion == 1 && this.xt.im != this.im) {
         var5 = false;
      }

      if (this.xt.multion >= 2) {
         var5 = false;
      }

      if (this.xt.lan && this.xt.multion >= 1 && this.xt.isbot[this.im]) {
         var5 = true;
      }

      var2 *= this.cd.dammult[this.cn];
      if (Math.abs(var2) > 100.0F) {
         this.rpd.recx(var1, var2, this.im);
         if (var2 > 100.0F) {
            var2 -= 100.0F;
         }

         if (var2 < -100.0F) {
            var2 += 100.0F;
         }

         this.shakedam = (int)((Math.abs(var2) + this.shakedam) / 2.0F);
         if (this.im == this.xt.im || this.colidim) {
            this.xt.crash(var2, 0);
         }

         for (int var6 = 0; var6 < var3.npl; var6++) {
            float var7 = 0.0F;

            for (int var8 = 0; var8 < var3.p[var6].n; var8++) {
               if (var3.p[var6].wz == 0 && this.py(var3.keyx[var1], var3.p[var6].ox[var8], var3.keyz[var1], var3.p[var6].oz[var8]) < this.cd.clrad[this.cn]) {
                  var7 = var2 / 20.0F * this.m.random();
                  var3.p[var6].oz[var8] = (int)(var3.p[var6].oz[var8] - var7 * this.m.sin(var3.xz) * this.m.cos(var3.zy));
                  var3.p[var6].ox[var8] = (int)(var3.p[var6].ox[var8] + var7 * this.m.cos(var3.xz) * this.m.cos(var3.xy));
                  if (var5) {
                     this.hitmag = (int)(this.hitmag + Math.abs(var7));
                     var4 = (int)(var4 + Math.abs(var7));
                  }
               }
            }

            if (var7 != 0.0F) {
               if (Math.abs(var7) >= 1.0F) {
                  var3.p[var6].chip = 1;
                  var3.p[var6].ctmag = var7;
               }

               if (!var3.p[var6].nocol && var3.p[var6].glass != 1) {
                  if (var3.p[var6].bfase > 20 && var3.p[var6].hsb[1] > 0.25) {
                     var3.p[var6].hsb[1] = 0.25F;
                  }

                  if (var3.p[var6].bfase > 25 && var3.p[var6].hsb[2] > 0.7) {
                     var3.p[var6].hsb[2] = 0.7F;
                  }

                  if (var3.p[var6].bfase > 30 && var3.p[var6].hsb[1] > 0.15) {
                     var3.p[var6].hsb[1] = 0.15F;
                  }

                  if (var3.p[var6].bfase > 35 && var3.p[var6].hsb[2] > 0.6) {
                     var3.p[var6].hsb[2] = 0.6F;
                  }

                  if (var3.p[var6].bfase > 40) {
                     var3.p[var6].hsb[0] = 0.075F;
                  }

                  if (var3.p[var6].bfase > 50 && var3.p[var6].hsb[2] > 0.5) {
                     var3.p[var6].hsb[2] = 0.5F;
                  }

                  if (var3.p[var6].bfase > 60) {
                     var3.p[var6].hsb[0] = 0.05F;
                  }

                  var3.p[var6].bfase = (int)(var3.p[var6].bfase + Math.abs(var7));
                  new Color(var3.p[var6].c[0], var3.p[var6].c[1], var3.p[var6].c[2]);
                  Color var10 = Color.getHSBColor(var3.p[var6].hsb[0], var3.p[var6].hsb[1], var3.p[var6].hsb[2]);
                  var3.p[var6].c[0] = var10.getRed();
                  var3.p[var6].c[1] = var10.getGreen();
                  var3.p[var6].c[2] = var10.getBlue();
               }

               if (var3.p[var6].glass == 1) {
                  var3.p[var6].gr = (int)(var3.p[var6].gr + Math.abs(var7 * 1.5));
               }
            }
         }
      }

      return var4;
   }

   public int regz(int var1, float var2, ContO var3) {
      int var4 = 0;
      boolean var5 = true;
      if (this.xt.multion == 1 && this.xt.im != this.im) {
         var5 = false;
      }

      if (this.xt.multion >= 2) {
         var5 = false;
      }

      if (this.xt.lan && this.xt.multion >= 1 && this.xt.isbot[this.im]) {
         var5 = true;
      }

      var2 *= this.cd.dammult[this.cn];
      if (Math.abs(var2) > 100.0F) {
         this.rpd.recz(var1, var2, this.im);
         if (var2 > 100.0F) {
            var2 -= 100.0F;
         }

         if (var2 < -100.0F) {
            var2 += 100.0F;
         }

         this.shakedam = (int)((Math.abs(var2) + this.shakedam) / 2.0F);
         if (this.im == this.xt.im || this.colidim) {
            this.xt.crash(var2, 0);
         }

         for (int var6 = 0; var6 < var3.npl; var6++) {
            float var7 = 0.0F;

            for (int var8 = 0; var8 < var3.p[var6].n; var8++) {
               if (var3.p[var6].wz == 0 && this.py(var3.keyx[var1], var3.p[var6].ox[var8], var3.keyz[var1], var3.p[var6].oz[var8]) < this.cd.clrad[this.cn]) {
                  var7 = var2 / 20.0F * this.m.random();
                  var3.p[var6].oz[var8] = (int)(var3.p[var6].oz[var8] + var7 * this.m.cos(var3.xz) * this.m.cos(var3.zy));
                  var3.p[var6].ox[var8] = (int)(var3.p[var6].ox[var8] + var7 * this.m.sin(var3.xz) * this.m.cos(var3.xy));
                  if (var5) {
                     this.hitmag = (int)(this.hitmag + Math.abs(var7));
                     var4 = (int)(var4 + Math.abs(var7));
                  }
               }
            }

            if (var7 != 0.0F) {
               if (Math.abs(var7) >= 1.0F) {
                  var3.p[var6].chip = 1;
                  var3.p[var6].ctmag = var7;
               }

               if (!var3.p[var6].nocol && var3.p[var6].glass != 1) {
                  if (var3.p[var6].bfase > 20 && var3.p[var6].hsb[1] > 0.25) {
                     var3.p[var6].hsb[1] = 0.25F;
                  }

                  if (var3.p[var6].bfase > 25 && var3.p[var6].hsb[2] > 0.7) {
                     var3.p[var6].hsb[2] = 0.7F;
                  }

                  if (var3.p[var6].bfase > 30 && var3.p[var6].hsb[1] > 0.15) {
                     var3.p[var6].hsb[1] = 0.15F;
                  }

                  if (var3.p[var6].bfase > 35 && var3.p[var6].hsb[2] > 0.6) {
                     var3.p[var6].hsb[2] = 0.6F;
                  }

                  if (var3.p[var6].bfase > 40) {
                     var3.p[var6].hsb[0] = 0.075F;
                  }

                  if (var3.p[var6].bfase > 50 && var3.p[var6].hsb[2] > 0.5) {
                     var3.p[var6].hsb[2] = 0.5F;
                  }

                  if (var3.p[var6].bfase > 60) {
                     var3.p[var6].hsb[0] = 0.05F;
                  }

                  var3.p[var6].bfase = (int)(var3.p[var6].bfase + Math.abs(var7));
                  new Color(var3.p[var6].c[0], var3.p[var6].c[1], var3.p[var6].c[2]);
                  Color var10 = Color.getHSBColor(var3.p[var6].hsb[0], var3.p[var6].hsb[1], var3.p[var6].hsb[2]);
                  var3.p[var6].c[0] = var10.getRed();
                  var3.p[var6].c[1] = var10.getGreen();
                  var3.p[var6].c[2] = var10.getBlue();
               }

               if (var3.p[var6].glass == 1) {
                  var3.p[var6].gr = (int)(var3.p[var6].gr + Math.abs(var7 * 1.5));
               }
            }
         }
      }

      return var4;
   }

   public void colide(ContO var1, Mad var2, ContO var3) {
      float[] var4 = new float[4];
      float[] var5 = new float[4];
      float[] var6 = new float[4];
      float[] var7 = new float[4];
      float[] var8 = new float[4];
      float[] var9 = new float[4];

      for (int var10 = 0; var10 < 4; var10++) {
         var4[var10] = var1.x + var1.keyx[var10];
         if (this.capsized) {
            var5[var10] = var1.y + this.cd.flipy[this.cn] + this.squash;
         } else {
            var5[var10] = var1.y + var1.grat;
         }

         var6[var10] = var1.z + var1.keyz[var10];
         var7[var10] = var3.x + var3.keyx[var10];
         if (this.capsized) {
            var8[var10] = var3.y + this.cd.flipy[var2.cn] + var2.squash;
         } else {
            var8[var10] = var3.y + var3.grat;
         }

         var9[var10] = var3.z + var3.keyz[var10];
      }

      this.rot(var4, var5, var1.x, var1.y, var1.xy, 4);
      this.rot(var5, var6, var1.y, var1.z, var1.zy, 4);
      this.rot(var4, var6, var1.x, var1.z, var1.xz, 4);
      this.rot(var7, var8, var3.x, var3.y, var3.xy, 4);
      this.rot(var8, var9, var3.y, var3.z, var3.zy, 4);
      this.rot(var7, var9, var3.x, var3.z, var3.xz, 4);
      if (this.rpy(var1.x, var3.x, var1.y, var3.y, var1.z, var3.z) < (var1.maxR * var1.maxR + var3.maxR * var3.maxR) * 1.5) {
         if (!this.caught[var2.im] && (this.speed != 0.0F || var2.speed != 0.0F)) {
            if (Math.abs(this.power * this.speed * this.cd.moment[this.cn]) != Math.abs(var2.power * var2.speed * this.cd.moment[var2.cn])) {
               if (Math.abs(this.power * this.speed * this.cd.moment[this.cn]) > Math.abs(var2.power * var2.speed * this.cd.moment[var2.cn])) {
                  this.dominate[var2.im] = true;
               } else {
                  this.dominate[var2.im] = false;
               }
            } else if (this.cd.moment[this.cn] > this.cd.moment[var2.cn]) {
               this.dominate[var2.im] = true;
            } else {
               this.dominate[var2.im] = false;
            }

            this.caught[var2.im] = true;
         }
      } else if (this.caught[var2.im]) {
         this.caught[var2.im] = false;
      }

      int var19 = 0;
      int var11 = 0;
      if (this.dominate[var2.im]) {
         int var12 = (int)(
            (
                  (this.scz[0] - var2.scz[0] + this.scz[1] - var2.scz[1] + this.scz[2] - var2.scz[2] + this.scz[3] - var2.scz[3])
                        * (this.scz[0] - var2.scz[0] + this.scz[1] - var2.scz[1] + this.scz[2] - var2.scz[2] + this.scz[3] - var2.scz[3])
                     + (this.scx[0] - var2.scx[0] + this.scx[1] - var2.scx[1] + this.scx[2] - var2.scx[2] + this.scx[3] - var2.scx[3])
                        * (this.scx[0] - var2.scx[0] + this.scx[1] - var2.scx[1] + this.scx[2] - var2.scx[2] + this.scx[3] - var2.scx[3])
               )
               / 16.0F
         );
         short var13 = 7000;
         float var14 = 1.0F;
         if (this.xt.multion != 0) {
            var13 = 28000;
            var14 = 1.27F;
         }

         for (int var15 = 0; var15 < 4; var15++) {
            for (int var16 = 0; var16 < 4; var16++) {
               if (this.rpy(var4[var15], var7[var16], var5[var15], var8[var16], var6[var15], var9[var16])
                  < (var12 + var13) * (this.cd.comprad[var2.cn] + this.cd.comprad[this.cn])) {
                  if (Math.abs(this.scx[var15] * this.cd.moment[this.cn]) > Math.abs(var2.scx[var16] * this.cd.moment[var2.cn])) {
                     float var17 = var2.scx[var16] * this.cd.revpush[this.cn];
                     if (var17 > 300.0F) {
                        var17 = 300.0F;
                     }

                     if (var17 < -300.0F) {
                        var17 = -300.0F;
                     }

                     float var18 = this.scx[var15] * this.cd.push[this.cn];
                     if (var18 > 300.0F) {
                        var18 = 300.0F;
                     }

                     if (var18 < -300.0F) {
                        var18 = -300.0F;
                     }

                     var2.scx[var16] = var2.scx[var16] + var18;
                     if (this.im == this.xt.im) {
                        var2.colidim = true;
                     }

                     var19 += var2.regx(var16, var18 * this.cd.moment[this.cn] * var14, var3);
                     if (var2.colidim) {
                        var2.colidim = false;
                     }

                     this.scx[var15] = this.scx[var15] - var17;
                     var11 += this.regx(var15, -var17 * this.cd.moment[this.cn] * var14, var1);
                     this.scy[var15] = this.scy[var15] - this.cd.revlift[this.cn];
                     if (this.im == this.xt.im) {
                        var2.colidim = true;
                     }

                     var19 += var2.regy(var16, this.cd.revlift[this.cn] * 7, var3);
                     if (var2.colidim) {
                        var2.colidim = false;
                     }

                     if (this.m.random() > this.m.random()) {
                        var3.sprk(
                           (var4[var15] + var7[var16]) / 2.0F,
                           (var5[var15] + var8[var16]) / 2.0F,
                           (var6[var15] + var9[var16]) / 2.0F,
                           (var2.scx[var16] + this.scx[var15]) / 4.0F,
                           (var2.scy[var16] + this.scy[var15]) / 4.0F,
                           (var2.scz[var16] + this.scz[var15]) / 4.0F,
                           2
                        );
                     }
                  }

                  if (Math.abs(this.scz[var15] * this.cd.moment[this.cn]) > Math.abs(var2.scz[var16] * this.cd.moment[var2.cn])) {
                     float var22 = var2.scz[var16] * this.cd.revpush[this.cn];
                     if (var22 > 300.0F) {
                        var22 = 300.0F;
                     }

                     if (var22 < -300.0F) {
                        var22 = -300.0F;
                     }

                     float var23 = this.scz[var15] * this.cd.push[this.cn];
                     if (var23 > 300.0F) {
                        var23 = 300.0F;
                     }

                     if (var23 < -300.0F) {
                        var23 = -300.0F;
                     }

                     var2.scz[var16] = var2.scz[var16] + var23;
                     if (this.im == this.xt.im) {
                        var2.colidim = true;
                     }

                     var19 += var2.regz(var16, var23 * this.cd.moment[this.cn] * var14, var3);
                     if (var2.colidim) {
                        var2.colidim = false;
                     }

                     this.scz[var15] = this.scz[var15] - var22;
                     var11 += this.regz(var15, -var22 * this.cd.moment[this.cn] * var14, var1);
                     this.scy[var15] = this.scy[var15] - this.cd.revlift[this.cn];
                     if (this.im == this.xt.im) {
                        var2.colidim = true;
                     }

                     var19 += var2.regy(var16, this.cd.revlift[this.cn] * 7, var3);
                     if (var2.colidim) {
                        var2.colidim = false;
                     }

                     if (this.m.random() > this.m.random()) {
                        var3.sprk(
                           (var4[var15] + var7[var16]) / 2.0F,
                           (var5[var15] + var8[var16]) / 2.0F,
                           (var6[var15] + var9[var16]) / 2.0F,
                           (var2.scx[var16] + this.scx[var15]) / 4.0F,
                           (var2.scy[var16] + this.scy[var15]) / 4.0F,
                           (var2.scz[var16] + this.scz[var15]) / 4.0F,
                           2
                        );
                     }
                  }

                  if (this.im == this.xt.im) {
                     var2.lastcolido = 70;
                  }

                  if (var2.im == this.xt.im) {
                     this.lastcolido = 70;
                  }

                  var2.scy[var16] = var2.scy[var16] - this.cd.lift[this.cn];
               }
            }
         }
      }

      if (this.xt.multion == 1) {
         if (var2.im == this.xt.im && var19 != 0) {
            this.xt.dcrashes[this.im] = this.xt.dcrashes[this.im] + var19;
         }

         if (this.im == this.xt.im && var11 != 0) {
            this.xt.dcrashes[var2.im] = this.xt.dcrashes[var2.im] + var11;
         }
      }
   }

   public void rot(float[] var1, float[] var2, int var3, int var4, int var5, int var6) {
      if (var5 != 0) {
         for (int var7 = 0; var7 < var6; var7++) {
            float var8 = var1[var7];
            float var9 = var2[var7];
            var1[var7] = var3 + ((var8 - var3) * this.m.cos(var5) - (var9 - var4) * this.m.sin(var5));
            var2[var7] = var4 + ((var8 - var3) * this.m.sin(var5) + (var9 - var4) * this.m.cos(var5));
         }
      }
   }

   public int rpy(float var1, float var2, float var3, float var4, float var5, float var6) {
      return (int)((var1 - var2) * (var1 - var2) + (var3 - var4) * (var3 - var4) + (var5 - var6) * (var5 - var6));
   }

   public int py(int var1, int var2, int var3, int var4) {
      return (var1 - var2) * (var1 - var2) + (var3 - var4) * (var3 - var4);
   }
}
