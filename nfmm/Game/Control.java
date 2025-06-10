public class Control {
   boolean left = false;
   boolean right = false;
   boolean up = false;
   boolean down = false;
   boolean handb = false;
   int lookback = 0;
   boolean enter = false;
   boolean exit = false;
   boolean arrace = false;
   boolean mutem = false;
   boolean mutes = false;
   boolean radar = false;
   int chatup = 0;
   int multion = 0;
   Medium m;
   int pan = 0;
   int attack = 0;
   int acr = 0;
   boolean afta = false;
   int[] fpnt = new int[5];
   int trfix = 0;
   boolean forget = false;
   boolean bulistc = false;
   int runbul = 0;
   int acuracy = 0;
   int upwait = 0;
   boolean agressed = false;
   float skiplev = 1.0F;
   int clrnce = 5;
   int rampp = 0;
   int turntyp = 0;
   float aim = 0.0F;
   int saftey = 30;
   boolean perfection = false;
   float mustland = 0.5F;
   boolean usebounce = false;
   float trickprf = 0.5F;
   int stuntf = 0;
   boolean zyinv = false;
   boolean lastl = false;
   boolean wlastl = false;
   int hold = 0;
   int wall = -1;
   int lwall = -1;
   int stcnt = 0;
   int statusque = 0;
   int turncnt = 0;
   int randtcnt = 0;
   int upcnt = 0;
   int trickfase = 0;
   int swat = 0;
   boolean udcomp = false;
   boolean lrcomp = false;
   boolean udbare = false;
   boolean lrbare = false;
   boolean onceu = false;
   boolean onced = false;
   boolean oncel = false;
   boolean oncer = false;
   int lrdirect = 0;
   int uddirect = 0;
   int lrstart = 0;
   int udstart = 0;
   int oxy = 0;
   int ozy = 0;
   int flycnt = 0;
   boolean lrswt = false;
   boolean udswt = false;
   boolean gowait = false;
   int actwait = 0;
   int cntrn = 0;
   int revstart = 0;
   int oupnt = 0;
   int wtz = 0;
   int wtx = 0;
   int frx = 0;
   int frz = 0;
   int frad = 0;
   int apunch = 0;
   boolean exitattack = false;
   int avoidnlev = 0;

   public Control(Medium var1) {
      this.m = var1;
   }

   public void falseo(int var1) {
      this.left = false;
      this.right = false;
      this.up = false;
      this.down = false;
      this.handb = false;
      this.lookback = 0;
      this.enter = false;
      this.exit = false;
      if (var1 != 1) {
         this.radar = false;
         this.arrace = false;
         this.chatup = 0;
         if (var1 != 2) {
            this.multion = 0;
         }

         if (var1 != 3) {
            this.mutem = false;
            this.mutes = false;
         }
      }
   }

   public void reset(CheckPoints var1, int var2) {
      this.pan = 0;
      this.attack = 0;
      this.acr = 0;
      this.afta = false;
      this.trfix = 0;
      this.acuracy = 0;
      this.upwait = 0;
      this.forget = false;
      this.bulistc = false;
      this.runbul = 0;
      this.revstart = 0;
      this.oupnt = 0;
      this.gowait = false;
      this.apunch = 0;
      this.exitattack = false;
      if (var1.stage == 16 || var1.stage == 18) {
         this.hold = 50;
      }

      if (var1.stage == 17) {
         this.hold = 10;
      }

      if (var1.stage == 20) {
         this.hold = 30;
      }

      if (var1.stage == 21) {
         if (var2 != 13) {
            this.hold = 35;
            this.revstart = 25;
         } else {
            this.hold = 5;
         }

         this.statusque = 0;
      }

      if (var1.stage == 22) {
         if (var2 != 13) {
            this.hold = (int)(20.0F + 10.0F * this.m.random());
            this.revstart = (int)(10.0F + 10.0F * this.m.random());
         } else {
            this.hold = 5;
         }

         this.statusque = 0;
      }

      if (var1.stage == 24) {
         this.hold = 30;
         this.statusque = 0;
         if (var2 != 14) {
            this.revstart = 1;
         }
      }

      if (var1.stage == 25) {
         this.hold = 40;
      }

      if (var1.stage == 26) {
         this.hold = 20;
      }

      if (var1.stage != 19 && var1.stage != 26) {
         for (int var3 = 0; var3 < var1.fn; var3++) {
            int var4 = -10;

            for (int var5 = 0; var5 < var1.n; var5++) {
               if (this.py(var1.fx[var3] / 100, var1.x[var5] / 100, var1.fz[var3] / 100, var1.z[var5] / 100) < var4 || var4 == -10) {
                  var4 = this.py(var1.fx[var3] / 100, var1.x[var5] / 100, var1.fz[var3] / 100, var1.z[var5] / 100);
                  this.fpnt[var3] = var5;
               }
            }
         }

         for (int var6 = 0; var6 < var1.fn; var6++) {
            this.fpnt[var6] = this.fpnt[var6] - 4;
            if (this.fpnt[var6] < 0) {
               this.fpnt[var6] = this.fpnt[var6] + var1.nsp;
            }
         }
      } else {
         if (var1.stage == 19) {
            this.fpnt[0] = 14;
            this.fpnt[1] = 36;
         }

         if (var1.stage == 26) {
            this.fpnt[3] = 39;
         }
      }

      this.left = false;
      this.right = false;
      this.up = false;
      this.down = false;
      this.handb = false;
      this.lookback = 0;
      this.arrace = false;
      this.mutem = false;
      this.mutes = false;
   }

   public void preform(Mad var1, ContO var2, CheckPoints var3, Trackers var4) {
      this.left = false;
      this.right = false;
      this.up = false;
      this.down = false;
      this.handb = false;
      if (!var1.dest) {
         if (var1.mtouch) {
            if (this.stcnt > this.statusque) {
               int var5 = var3.stage;
               if (var5 > 10) {
                  var5 -= 10;
               }

               this.acuracy = (7 - var3.pos[var1.im]) * var3.pos[0] * (6 - var5 * 2);
               if (this.acuracy < 0 || var3.stage == -1) {
                  this.acuracy = 0;
               }

               this.clrnce = 5;
               if (var3.stage == 16 || var3.stage == 21) {
                  this.clrnce = 2;
               }

               if (var3.stage == 22 && (var1.pcleared == 27 || var1.pcleared == 17)) {
                  this.clrnce = 3;
               }

               if (var3.stage == 26 && var1.pcleared == 33) {
                  this.clrnce = 3;
               }

               float var6 = 0.0F;
               if (var3.stage == 1) {
                  var6 = 2.0F;
               }

               if (var3.stage == 2) {
                  var6 = 1.5F;
               }

               if (var3.stage == 3 && var1.cn != 6) {
                  var6 = 0.5F;
               }

               if (var3.stage == 4) {
                  var6 = 0.5F;
               }

               if (var3.stage == 11) {
                  var6 = 2.0F;
               }

               if (var3.stage == 12) {
                  var6 = 1.5F;
               }

               if (var3.stage == 13 && var1.cn != 9) {
                  var6 = 0.5F;
               }

               if (var3.stage == 14) {
                  var6 = 0.5F;
               }

               this.upwait = (int)((var3.pos[0] - var3.pos[var1.im]) * (var3.pos[0] - var3.pos[var1.im]) * (var3.pos[0] - var3.pos[var1.im]) * var6);
               if (this.upwait > 80) {
                  this.upwait = 80;
               }

               if ((var3.stage == 11 || var3.stage == 1) && this.upwait < 20) {
                  this.upwait = 20;
               }

               var6 = 0.0F;
               if (var3.stage == 1 || var3.stage == 2) {
                  var6 = 1.0F;
               }

               if (var3.stage == 4) {
                  var6 = 0.5F;
               }

               if (var3.stage == 7) {
                  var6 = 0.5F;
               }

               if (var3.stage == 10) {
                  var6 = 0.5F;
               }

               if (var3.stage == 11 || var3.stage == 12) {
                  var6 = 1.0F;
               }

               if (var3.stage == 13) {
                  var6 = 0.5F;
               }

               if (var3.stage == 14) {
                  var6 = 0.5F;
               }

               if (var3.stage == 15) {
                  var6 = 0.2F;
               }

               if (var3.pos[var1.im] - var3.pos[0] >= -1) {
                  this.skiplev = (float)(this.skiplev - 0.1);
                  if (this.skiplev < 0.0F) {
                     this.skiplev = 0.0F;
                  }
               } else {
                  this.skiplev = (float)(this.skiplev + 0.2);
                  if (this.skiplev > var6) {
                     this.skiplev = var6;
                  }
               }

               if (var3.stage == 18) {
                  if (var1.pcleared >= 10 && var1.pcleared <= 24) {
                     this.skiplev = 1.0F;
                  } else {
                     this.skiplev = 0.0F;
                  }
               }

               if (var3.stage == 21) {
                  this.skiplev = 0.0F;
                  if (var1.pcleared == 5) {
                     this.skiplev = 1.0F;
                  }

                  if (var1.pcleared == 28 || var1.pcleared == 35) {
                     this.skiplev = 0.5F;
                  }
               }

               if (var3.stage == 23) {
                  this.skiplev = 0.5F;
               }

               if (var3.stage == 24 || var3.stage == 22) {
                  this.skiplev = 1.0F;
               }

               if (var3.stage == 26 || var3.stage == 25 || var3.stage == 20) {
                  this.skiplev = 0.0F;
               }

               this.rampp = (int)(this.m.random() * 4.0F - 2.0F);
               if (var1.power == 98.0F) {
                  this.rampp = -1;
               }

               if (var1.power < 75.0F && this.rampp == -1) {
                  this.rampp = 0;
               }

               if (var1.power < 60.0F) {
                  this.rampp = 1;
               }

               if (var3.stage == 6) {
                  this.rampp = 2;
               }

               if (var3.stage == 18 && var1.pcleared >= 45) {
                  this.rampp = 2;
               }

               if (var3.stage == 22 && var1.pcleared == 17) {
                  this.rampp = 2;
               }

               if (var3.stage == 25 || var3.stage == 26) {
                  this.rampp = 0;
               }

               if (this.cntrn == 0) {
                  this.agressed = false;
                  this.turntyp = (int)(this.m.random() * 4.0F);
                  if (var3.stage == 3 && var1.cn == 6) {
                     this.turntyp = 1;
                     if (this.attack == 0) {
                        this.agressed = true;
                     }
                  }

                  if (var3.stage == 9 && var1.cn == 15) {
                     this.turntyp = 1;
                     if (this.attack == 0) {
                        this.agressed = true;
                     }
                  }

                  if (var3.stage == 13 && var1.cn == 9) {
                     this.turntyp = 1;
                     if (this.attack == 0) {
                        this.agressed = true;
                     }
                  }

                  if (var3.pos[0] - var3.pos[var1.im] < 0) {
                     this.turntyp = (int)(this.m.random() * 2.0F);
                  }

                  if (var3.stage == 10) {
                     this.turntyp = 2;
                  }

                  if (var3.stage == 18) {
                     this.turntyp = 2;
                  }

                  if (var3.stage == 20) {
                     this.turntyp = 0;
                  }

                  if (var3.stage == 23) {
                     this.turntyp = 1;
                  }

                  if (var3.stage == 24) {
                     this.turntyp = 0;
                  }

                  if (this.attack != 0) {
                     this.turntyp = 2;
                     if (var3.stage == 9 || var3.stage == 10 || var3.stage == 19 || var3.stage == 21 || var3.stage == 23 || var3.stage == 27) {
                        this.turntyp = (int)(this.m.random() * 3.0F);
                     }

                     if (var3.stage == 26 && var3.clear[var1.im] - var3.clear[0] >= 5) {
                        this.turntyp = 0;
                     }
                  }

                  if (var3.stage == 6) {
                     this.turntyp = 1;
                     this.agressed = true;
                  }

                  if (var3.stage == 7
                     || var3.stage == 9
                     || var3.stage == 10
                     || var3.stage == 16
                     || var3.stage == 17
                     || var3.stage == 19
                     || var3.stage == 20
                     || var3.stage == 21
                     || var3.stage == 22
                     || var3.stage == 24
                     || var3.stage == 26
                     || var3.stage == 27) {
                     this.agressed = true;
                  }

                  if (var3.stage == -1) {
                     if (this.m.random() > this.m.random()) {
                        this.agressed = true;
                     } else {
                        this.agressed = false;
                     }
                  }

                  this.cntrn = 5;
               } else {
                  this.cntrn--;
               }

               this.saftey = (int)((98.0F - var1.power) / 2.0F * (this.m.random() / 2.0F + 0.5));
               if (this.saftey > 20) {
                  this.saftey = 20;
               }

               var6 = 0.0F;
               if (var3.stage == 1 || var3.stage == 11) {
                  var6 = 0.9F;
               }

               if (var3.stage == 2 || var3.stage == 12) {
                  var6 = 0.7F;
               }

               if (var3.stage == 4 || var3.stage == 13) {
                  var6 = 0.4F;
               }

               this.mustland = var6 + (float)(this.m.random() / 2.0F - 0.25);
               var6 = 1.0F;
               if (var3.stage == 1 || var3.stage == 11) {
                  var6 = 5.0F;
               }

               if (var3.stage == 2 || var3.stage == 12) {
                  var6 = 2.0F;
               }

               if (var3.stage == 4 || var3.stage == 13) {
                  var6 = 1.5F;
               }

               if (var1.power > 50.0F) {
                  if (var3.pos[0] - var3.pos[var1.im] > 0) {
                     this.saftey = (int)(this.saftey * var6);
                  } else {
                     this.mustland = 0.0F;
                  }
               } else {
                  this.mustland -= 0.5F;
               }

               if (var3.stage == 18 || var3.stage == 20 || var3.stage == 22 || var3.stage == 24) {
                  this.mustland = 0.0F;
               }

               this.stuntf = 0;
               if (var3.stage == 8) {
                  this.stuntf = 17;
               }

               if (var3.stage == 18 && var1.pcleared == 57) {
                  this.stuntf = 1;
               }

               if (var3.stage == 19 && var1.pcleared == 3) {
                  this.stuntf = 2;
               }

               if (var3.stage == 20) {
                  if (var3.pos[0] >= var3.pos[var1.im] && Math.abs(var3.clear[0] - var1.clear) < 2 && var1.clear >= 2) {
                     this.stuntf = 3;
                  } else {
                     this.stuntf = 4;
                     this.saftey = 10;
                  }
               }

               if (var3.stage == 21 && var1.pcleared == 21) {
                  this.stuntf = 1;
               }

               if (var3.stage == 24) {
                  this.saftey = 10;
                  if (var1.pcleared >= 4 && var1.pcleared < 70) {
                     this.stuntf = 4;
                  } else if (var1.cn == 12 || var1.cn == 8) {
                     this.stuntf = 2;
                  }

                  if (var1.cn == 14) {
                     this.stuntf = 6;
                  }
               }

               if (var3.stage == 26) {
                  this.mustland = 0.0F;
                  this.saftey = 10;
                  if ((var1.pcleared == 15 || var1.pcleared == 51) && (this.m.random() > 0.4 || this.trfix != 0)) {
                     this.stuntf = 7;
                  }

                  if (var1.pcleared == 42) {
                     this.stuntf = 1;
                  }

                  if (var1.pcleared == 77) {
                     this.stuntf = 7;
                  }

                  this.avoidnlev = (int)(2700.0F * this.m.random());
               }

               this.trickprf = (var1.power - 38.0F) / 50.0F - this.m.random() / 2.0F;
               if (var1.power < 60.0F) {
                  this.trickprf = -1.0F;
               }

               if (var3.stage == 6 && this.trickprf > 0.5) {
                  this.trickprf = 0.5F;
               }

               if (var3.stage == 3 && var1.cn == 6 && this.trickprf > 0.7) {
                  this.trickprf = 0.7F;
               }

               if (var3.stage == 13 && var1.cn == 9 && this.trickprf > 0.7) {
                  this.trickprf = 0.7F;
               }

               if (var3.stage == 16 && this.trickprf > 0.3) {
                  this.trickprf = 0.3F;
               }

               if (var3.stage == 18 && this.trickprf > 0.2) {
                  this.trickprf = 0.2F;
               }

               if (var3.stage == 19) {
                  if (this.trickprf > 0.5) {
                     this.trickprf = 0.5F;
                  }

                  if ((var1.im == 6 || var1.im == 5) && this.trickprf > 0.3) {
                     this.trickprf = 0.3F;
                  }
               }

               if (var3.stage == 21 && this.trickprf != -1.0F) {
                  this.trickprf *= 0.75F;
               }

               if (var3.stage == 22 && (var1.pcleared == 55 || var1.pcleared == 7)) {
                  this.trickprf = -1.0F;
                  this.stuntf = 5;
               }

               if (var3.stage == 23 && this.trickprf > 0.4) {
                  this.trickprf = 0.4F;
               }

               if (var3.stage == 24 && this.trickprf > 0.5) {
                  this.trickprf = 0.5F;
               }

               if (var3.stage == 27) {
                  this.trickprf = -1.0F;
               }

               if (this.m.random() > var1.power / 100.0F) {
                  this.usebounce = true;
               } else {
                  this.usebounce = false;
               }

               if (var3.stage == 9) {
                  this.usebounce = false;
               }

               if (var3.stage == 14 || var3.stage == 16) {
                  this.usebounce = true;
               }

               if (var3.stage == 20 || var3.stage == 24) {
                  this.usebounce = false;
               }

               if (this.m.random() > (float)var1.hitmag / var1.cd.maxmag[var1.cn]) {
                  this.perfection = false;
               } else {
                  this.perfection = true;
               }

               if (100.0F * var1.hitmag / var1.cd.maxmag[var1.cn] > 60.0F) {
                  this.perfection = true;
               }

               if (var3.stage == 3 && var1.cn == 6) {
                  this.perfection = true;
               }

               if (var3.stage == 6
                  || var3.stage == 8
                  || var3.stage == 9
                  || var3.stage == 10
                  || var3.stage == 16
                  || var3.stage == 18
                  || var3.stage == 19
                  || var3.stage == 20
                  || var3.stage == 21
                  || var3.stage == 22
                  || var3.stage == 24
                  || var3.stage == 26
                  || var3.stage == 27) {
                  this.perfection = true;
               }

               if (this.attack == 0) {
                  boolean var7 = true;
                  if (var3.stage == 3
                     || var3.stage == 1
                     || var3.stage == 4
                     || var3.stage == 9
                     || var3.stage == 13
                     || var3.stage == 11
                     || var3.stage == 14
                     || var3.stage == 19
                     || var3.stage == 23
                     || var3.stage == 26) {
                     var7 = this.afta;
                  }

                  if (var3.stage == 8 || var3.stage == 6 || var3.stage == 18 || var3.stage == 16 || var3.stage == 20 || var3.stage == 24) {
                     var7 = false;
                  }

                  if (var3.stage == 3 && var1.cn == 6) {
                     var7 = false;
                  }

                  if (var3.stage == -1 && this.m.random() > this.m.random()) {
                     var7 = false;
                  }

                  boolean var8 = false;
                  if (var3.stage == 13 && var1.cn == 9) {
                     var8 = true;
                  }

                  if (var3.stage == 18 && var1.cn == 11) {
                     var8 = true;
                  }

                  if (var3.stage == 19 && var3.clear[0] >= 20) {
                     var8 = true;
                  }

                  if (var3.stage == 4 || var3.stage == 10 || var3.stage == 21 || var3.stage == 22 || var3.stage == 23 || var3.stage == 25 || var3.stage == 26) {
                     var8 = true;
                  }

                  if (var3.stage == 3 && var1.cn == 6) {
                     var8 = true;
                  }

                  byte var9 = 60;
                  if (var3.stage == 5) {
                     var9 = 40;
                  }

                  if (var3.stage == 6 && this.bulistc) {
                     var9 = 40;
                  }

                  if (var3.stage == 9 && this.bulistc) {
                     var9 = 30;
                  }

                  if (var3.stage == 3 || var3.stage == 13 || var3.stage == 21 || var3.stage == 27 || var3.stage == 20 || var3.stage == 18) {
                     var9 = 30;
                  }

                  if ((var3.stage == 12 || var3.stage == 23) && var1.cn == 13) {
                     var9 = 50;
                  }

                  if (var3.stage == 14) {
                     var9 = 20;
                  }

                  if (var3.stage == 15 && var1.im != 6) {
                     var9 = 40;
                  }

                  if (var3.stage == 17) {
                     var9 = 40;
                  }

                  if (var3.stage == 18 && var1.cn == 11) {
                     var9 = 40;
                  }

                  if (var3.stage == 19 && var8) {
                     var9 = 30;
                  }

                  if (var3.stage == 21 && this.bulistc) {
                     var9 = 30;
                  }

                  if (var3.stage == 22) {
                     var9 = 50;
                  }

                  if (var3.stage == 25 && this.bulistc) {
                     var9 = 40;
                  }

                  if (var3.stage == 26) {
                     if (var1.cn == 11 && var3.clear[0] == 27) {
                        var9 = 0;
                     }

                     if (var1.cn == 15 || var1.cn == 9) {
                        var9 = 50;
                     }

                     if (var1.cn == 11) {
                        var9 = 40;
                     }

                     if (var3.pos[0] > var3.pos[var1.im]) {
                        var9 = 80;
                     }
                  }

                  for (int var10 = 0; var10 < 7; var10++) {
                     if (var10 != var1.im && var3.clear[var10] != -1) {
                        int var11 = var2.xz;
                        if (this.zyinv) {
                           var11 += 180;
                        }

                        while (var11 < 0) {
                           var11 += 360;
                        }

                        while (var11 > 180) {
                           var11 -= 360;
                        }

                        short var12 = 0;
                        if (var3.opx[var10] - var2.x >= 0) {
                           var12 = 180;
                        }

                        int var13 = (int)(90 + var12 + Math.atan((double)(var3.opz[var10] - var2.z) / (var3.opx[var10] - var2.x)) / (Math.PI / 180.0));

                        while (var13 < 0) {
                           var13 += 360;
                        }

                        while (var13 > 180) {
                           var13 -= 360;
                        }

                        int var14 = Math.abs(var11 - var13);
                        if (var14 > 180) {
                           var14 = Math.abs(var14 - 360);
                        }

                        int var15 = 2000 * (Math.abs(var3.clear[var10] - var1.clear) + 1);
                        if ((var3.stage == 6 || var3.stage == 9) && this.bulistc) {
                           var15 = 6000;
                        }

                        if (var3.stage == 3 && var1.cn == 6 && var3.wasted < 2 && var15 > 4000) {
                           var15 = 4000;
                        }

                        if (var3.stage == 13 && var1.cn == 9 && var15 < 12000) {
                           var15 = 12000;
                        }

                        if (var3.stage == 14 && var15 < 4000) {
                           var15 = 4000;
                        }

                        if (var3.stage == 18 && var1.cn == 11) {
                           if (var15 < 12000) {
                              var15 = 12000;
                           }

                           var14 = 10;
                        }

                        if (var3.stage == 19 && (var1.pcleared == 13 || var1.pcleared == 33 || var8) && var15 < 12000) {
                           var15 = 12000;
                        }

                        if (var3.stage == 21) {
                           if (this.bulistc) {
                              var15 = 8000;
                              var14 = 10;
                              this.afta = true;
                           } else if (var15 < 6000) {
                              var15 = 6000;
                           }
                        }

                        if (var3.stage == 22 && this.bulistc) {
                           var15 = 6000;
                           var14 = 10;
                        }

                        if (var3.stage == 23) {
                           var15 = 21000;
                        }

                        if (var3.stage == 25) {
                           var15 *= Math.abs(var3.clear[var10] - var1.clear) + 1;
                           if (this.bulistc) {
                              var15 = 4000 * (Math.abs(var3.clear[var10] - var1.clear) + 1);
                              var14 = 10;
                           }
                        }

                        if (var3.stage == 20) {
                           var15 = 16000;
                        }

                        if (var3.stage == 26) {
                           if (var1.cn == 13 && this.bulistc) {
                              if (this.oupnt == 33) {
                                 var15 = 17000;
                              }

                              if (this.oupnt == 51) {
                                 var15 = 30000;
                              }

                              if (this.oupnt == 15 && var3.clear[0] >= 14) {
                                 var15 = 60000;
                              }

                              var14 = 10;
                           }

                           if (var1.cn == 15 || var1.cn == 9) {
                              var15 *= Math.abs(var3.clear[var10] - var1.clear) + 1;
                           }

                           if (var1.cn == 11) {
                              var15 = 4000 * (Math.abs(var3.clear[var10] - var1.clear) + 1);
                           }
                        }

                        int var16 = 85 + 15 * (Math.abs(var3.clear[var10] - var1.clear) + 1);
                        if (var3.stage == 23) {
                           var16 = 45;
                        }

                        if (var3.stage == 26 && (var1.cn == 15 || var1.cn == 9 || var1.cn == 11 || var1.cn == 14)) {
                           var16 = 50 + 70 * Math.abs(var3.clear[var10] - var1.clear);
                        }

                        if (var14 < var16
                           && this.py(var2.x / 100, var3.opx[var10] / 100, var2.z / 100, var3.opz[var10] / 100) < var15
                           && this.afta
                           && var1.power > var9) {
                           float var17 = 35 - Math.abs(var3.clear[var10] - var1.clear) * 10;
                           if (var17 < 1.0F) {
                              var17 = 1.0F;
                           }

                           float var18 = (var3.pos[var1.im] + 1) * (5 - var3.pos[var10]) / var17;
                           if (var3.stage != 27 && var18 > 0.7) {
                              var18 = 0.7F;
                           }

                           if (var10 != 0 && var3.pos[0] < var3.pos[var1.im]) {
                              var18 = 0.0F;
                           }

                           if (var10 != 0 && var8) {
                              var18 = 0.0F;
                           }

                           if (var8 && var3.stage == 3 && var10 == 0) {
                              if (var3.wasted >= 2) {
                                 var18 *= 0.5F;
                              } else {
                                 var18 = 0.0F;
                              }
                           }

                           if ((var3.stage == 3 || var3.stage == 9) && var10 == 4) {
                              var18 = 0.0F;
                           }

                           if (var3.stage == 6) {
                              var18 = 0.0F;
                              if (this.bulistc && var10 == 0) {
                                 var18 = 1.0F;
                              }
                           }

                           if (var3.stage == 8) {
                              var18 = 0.0F;
                              if (this.bulistc && var1.cn != 11 && var1.cn != 13) {
                                 var18 = 1.0F;
                              }
                           }

                           if (var3.stage == 9 && var1.cn == 15) {
                              var18 = 0.0F;
                           }

                           if (var3.stage == 9 && this.bulistc) {
                              if (var10 == 0) {
                                 var18 = 1.0F;
                              } else {
                                 var18 = 0.0F;
                              }
                           }

                           if (var3.stage == 9 && (var3.pos[var10] == 4 || var3.pos[var10] == 3)) {
                              var18 = 0.0F;
                           }

                           if (var3.stage == 13) {
                              if (var1.cn != 9 && (var1.cn != 13 || !this.bulistc)) {
                                 var18 *= 0.5F;
                              } else {
                                 var18 *= 2.0F;
                              }
                           }

                           if (var3.stage == 16) {
                              var18 = 0.0F;
                           }

                           if (var3.stage == 17 && var1.im == 6 && var10 == 0) {
                              var18 = (float)(var18 * 1.5);
                           }

                           if (var3.stage == 18) {
                              if (var1.cn != 11 && (var1.cn != 13 || !this.bulistc)) {
                                 var18 = 0.0F;
                              } else {
                                 var18 *= 1.5F;
                              }
                           }

                           if (var3.stage == 19) {
                              if (var10 != 0) {
                                 var18 = (float)(var18 * 0.5);
                              }

                              if (var1.pcleared != 13 && var1.pcleared != 33 && !var8) {
                                 var18 *= 0.5F;
                              }

                              if ((var1.im == 6 || var1.im == 5) && var10 != 0) {
                                 var18 = 0.0F;
                              }
                           }

                           if (var3.stage == 20) {
                              var18 = 0.0F;
                              if (this.bulistc && var1.cn != 11 && var1.cn != 13) {
                                 var18 = 1.0F;
                              }
                           }

                           if (var3.stage == 21 && this.bulistc && var10 == 0) {
                              var18 = 1.0F;
                           }

                           if (var3.stage == 22) {
                              if (var1.cn != 11 && var1.cn != 13) {
                                 var18 = 0.0F;
                              }

                              if (var1.cn == 13 && var10 == 0) {
                                 var18 = 1.0F;
                              }
                           }

                           if (var3.stage == 24) {
                              var18 = 0.0F;
                           }

                           if (var3.stage == 25) {
                              if (var3.pos[var1.im] == 0) {
                                 var18 = (float)(var18 * 0.5);
                              }

                              if (var3.pos[0] < var3.pos[var1.im]) {
                                 var18 *= 2.0F;
                              }

                              if (this.bulistc && var10 == 0) {
                                 var18 = 1.0F;
                              }
                           }

                           if (var3.stage == 26) {
                              if (var1.cn != 14) {
                                 if (var3.pos[0] < var3.pos[var1.im] && var3.clear[0] - var3.clear[var1.im] != 1) {
                                    var18 *= 2.0F;
                                 }
                              } else {
                                 var18 = (float)(var18 * 0.5);
                              }

                              if (var1.cn == 13 && var10 == 0) {
                                 var18 = 1.0F;
                              }

                              if (var3.pos[var1.im] == 0 || var3.pos[var1.im] == 1 && var3.pos[0] == 0) {
                                 var18 = 0.0F;
                              }

                              if (var3.clear[var1.im] - var3.clear[0] >= 5 && var10 == 0) {
                                 var18 = 1.0F;
                              }

                              if (var1.cn == 10 || var1.cn == 12) {
                                 var18 = 0.0F;
                              }
                           }

                           if (this.m.random() < var18) {
                              this.attack = 40 * (Math.abs(var3.clear[var10] - var1.clear) + 1);
                              if (this.attack > 500) {
                                 this.attack = 500;
                              }

                              this.aim = 0.0F;
                              if (var3.stage == 13 && var1.cn == 9 && this.m.random() > this.m.random()) {
                                 this.aim = 1.0F;
                              }

                              if (var3.stage == 14) {
                                 if (var10 == 0 && var3.pos[0] < var3.pos[var1.im]) {
                                    this.aim = 1.5F;
                                 } else {
                                    this.aim = this.m.random();
                                 }
                              }

                              if (var3.stage == 15) {
                                 this.aim = this.m.random() * 1.5F;
                              }

                              if (var3.stage == 17 && var1.im != 6 && (this.m.random() > this.m.random() || var3.pos[0] < var3.pos[var1.im])) {
                                 this.aim = 1.0F;
                              }

                              if (var3.stage == 18 && var1.cn == 11 && this.m.random() > this.m.random()) {
                                 this.aim = 0.76F + this.m.random() * 0.76F;
                              }

                              if (var3.stage == 19 && (var1.pcleared == 13 || var1.pcleared == 33)) {
                                 this.aim = 1.0F;
                              }

                              if (var3.stage == 21) {
                                 if (this.bulistc) {
                                    this.aim = 0.7F;
                                    if (this.attack > 150) {
                                       this.attack = 150;
                                    }
                                 } else {
                                    this.aim = this.m.random();
                                 }
                              }

                              if (var3.stage == 22) {
                                 if (this.m.random() > this.m.random()) {
                                    this.aim = 0.7F;
                                 }

                                 if (this.bulistc && this.attack > 150) {
                                    this.attack = 150;
                                 }
                              }

                              if (var3.stage == 23 && this.attack > 60) {
                                 this.attack = 60;
                              }

                              if (var3.stage == 25) {
                                 this.aim = this.m.random() * 1.5F;
                                 this.attack /= 2;
                                 if (this.m.random() > this.m.random()) {
                                    this.exitattack = true;
                                 } else {
                                    this.exitattack = false;
                                 }
                              }

                              if (var3.stage == 26) {
                                 if (var1.cn == 13) {
                                    this.aim = 0.76F;
                                    this.attack = 150;
                                 } else {
                                    this.aim = this.m.random() * 1.5F;
                                    if (Math.abs(var3.clear[var10] - var1.clear) <= 2 || var1.cn == 14) {
                                       this.attack /= 3;
                                    }
                                 }
                              }

                              if (var3.stage == -1 && this.m.random() > this.m.random()) {
                                 this.aim = this.m.random() * 1.5F;
                              }

                              this.acr = var10;
                              this.turntyp = (int)(1.0F + this.m.random() * 2.0F);
                           }
                        }

                        if (var7
                           && var14 > 100
                           && this.py(var2.x / 100, var3.opx[var10] / 100, var2.z / 100, var3.opz[var10] / 100) < 300
                           && this.m.random() > 0.6 - var3.pos[var1.im] / 10.0F) {
                           this.clrnce = 0;
                           this.acuracy = 0;
                        }
                     }
                  }
               }

               boolean var32 = false;
               if (var3.stage == 6 || var3.stage == 8) {
                  var32 = true;
               }

               if (var3.stage == 9 && var1.cn == 15) {
                  var32 = true;
               }

               if (var3.stage == 16 || var3.stage == 20 || var3.stage == 21 || var3.stage == 27) {
                  var32 = true;
               }

               if (var3.stage == 18 && var1.pcleared != 73) {
                  var32 = true;
               }

               if (var3.stage == -1 && this.m.random() > this.m.random()) {
                  var32 = true;
               }

               if (this.trfix != 3) {
                  this.trfix = 0;
                  byte var37 = 50;
                  if (var3.stage == 26) {
                     var37 = 40;
                  }

                  if (100.0F * var1.hitmag / var1.cd.maxmag[var1.cn] > var37) {
                     this.trfix = 1;
                  }

                  if (!var32) {
                     byte var47 = 80;
                     if (var3.stage == 18 && var1.cn != 11) {
                        var47 = 50;
                     }

                     if (var3.stage == 19) {
                        var47 = 70;
                     }

                     if (var3.stage == 25 && var1.pcleared == 91) {
                        var47 = 50;
                     }

                     if (var3.stage == 26 && var3.clear[var1.im] - var3.clear[0] >= 5 && var1.cn != 10 && var1.cn != 12) {
                        var47 = 50;
                     }

                     if (100.0F * var1.hitmag / var1.cd.maxmag[var1.cn] > var47) {
                        this.trfix = 2;
                     }
                  }
               } else {
                  this.upwait = 0;
                  this.acuracy = 0;
                  this.skiplev = 1.0F;
                  this.clrnce = 2;
               }

               if (!this.bulistc) {
                  if (var3.stage == 18 && var1.cn == 11 && var1.pcleared == 35) {
                     var1.pcleared = 73;
                     var1.clear = 0;
                     this.bulistc = true;
                     this.runbul = (int)(100.0F * this.m.random());
                  }

                  if (var3.stage == 21 && var1.cn == 13) {
                     this.bulistc = true;
                  }

                  if (var3.stage == 22 && var1.cn == 13) {
                     this.bulistc = true;
                  }

                  if (var3.stage == 25 && var3.clear[0] - var1.clear >= 3 && this.trfix == 0) {
                     this.bulistc = true;
                     this.oupnt = -1;
                  }

                  if (var3.stage == 26) {
                     if (var1.cn == 13 && var3.pcleared == 8) {
                        this.bulistc = true;
                        this.attack = 0;
                     }

                     if (var1.cn == 11 && var3.clear[0] - var1.clear >= 2 && this.trfix == 0) {
                        this.bulistc = true;
                        this.oupnt = -1;
                     }
                  }

                  if ((
                        var3.stage == 6
                           || var3.stage == 8
                           || var3.stage == 12
                           || var3.stage == 13
                           || var3.stage == 14
                           || var3.stage == 15
                           || var3.stage == 18
                           || var3.stage == 20
                           || var3.stage == 23
                     )
                     && var1.cn == 13
                     && Math.abs(var3.clear[0] - var1.clear) >= 2) {
                     this.bulistc = true;
                  }

                  if ((var3.stage == 8 || var3.stage == 20) && var1.cn == 11 && Math.abs(var3.clear[0] - var1.clear) >= 1) {
                     this.bulistc = true;
                  }

                  if (var3.stage == 6 && var1.cn == 11) {
                     this.bulistc = true;
                  }

                  if (var3.stage == 9 && this.afta && (var3.pos[var1.im] == 4 || var3.pos[var1.im] == 3) && var1.cn != 15 && this.trfix != 0) {
                     this.bulistc = true;
                  }
               } else if (var3.stage == 18) {
                  this.runbul--;
                  if (var1.pcleared == 10) {
                     this.runbul = 0;
                  }

                  if (this.runbul <= 0) {
                     this.bulistc = false;
                  }
               }

               this.stcnt = 0;
               this.statusque = (int)(20.0F * this.m.random());
            } else {
               this.stcnt++;
            }
         }

         boolean var19 = false;
         if (this.usebounce) {
            var19 = var1.wtouch;
         } else {
            var19 = var1.mtouch;
         }

         if (var19) {
            if (this.trickfase != 0) {
               this.trickfase = 0;
            }

            if (this.trfix == 2 || this.trfix == 3) {
               this.attack = 0;
            }

            if (this.attack == 0) {
               if (this.upcnt < 30) {
                  if (this.revstart <= 0) {
                     this.up = true;
                  } else {
                     this.down = true;
                     this.revstart--;
                  }
               }

               if (this.upcnt < 25 + this.actwait) {
                  this.upcnt++;
               } else {
                  this.upcnt = 0;
                  this.actwait = this.upwait;
               }

               int var25 = var1.point;
               byte var34 = 50;
               if (var3.stage == 9) {
                  var34 = 20;
               }

               if (var3.stage == 18) {
                  var34 = 20;
               }

               if (var3.stage == 25) {
                  var34 = 40;
               }

               if (var3.stage == 26) {
                  var34 = 20;
               }

               if (this.bulistc && this.trfix != 2 && this.trfix != 3 && this.trfix != 4 && !(var1.power < var34)) {
                  if (var3.stage != 25 && var3.stage != 26 || this.runbul == 0) {
                     var25 -= 2;
                     if (var25 < 0) {
                        var25 += var3.n;
                     }

                     if (var3.stage == 9 && var25 > 76) {
                        var25 = 76;
                     }

                     while (var3.typ[var25] == -4) {
                        if (--var25 < 0) {
                           var25 += var3.n;
                        }
                     }
                  }

                  if (var3.stage == 21) {
                     if (var25 >= 14 && var25 <= 19) {
                        var25 = 13;
                     }

                     if (this.oupnt == 72 && var25 != 56) {
                        var25 = 57;
                     } else if (this.oupnt == 54 && var25 != 52) {
                        var25 = 53;
                     } else if (this.oupnt == 39 && var25 != 37) {
                        var25 = 38;
                     } else {
                        this.oupnt = var25;
                     }
                  }

                  if (var3.stage == 22) {
                     if (!this.gowait) {
                        if (var3.clear[0] == 0) {
                           this.wtx = -3500;
                           this.wtz = 19000;
                           this.frx = -3500;
                           this.frz = 39000;
                           this.frad = 12000;
                           this.oupnt = 37;
                           this.gowait = true;
                           this.afta = false;
                        }

                        if (var3.clear[0] == 7) {
                           this.wtx = -44800;
                           this.wtz = 40320;
                           this.frx = -44800;
                           this.frz = 34720;
                           this.frad = 30000;
                           this.oupnt = 27;
                           this.gowait = true;
                           this.afta = false;
                        }

                        if (var3.clear[0] == 10) {
                           this.wtx = 0;
                           this.wtz = 48739;
                           this.frx = 0;
                           this.frz = 38589;
                           this.frad = 90000;
                           this.oupnt = 55;
                           this.gowait = true;
                           this.afta = false;
                        }

                        if (var3.clear[0] == 14) {
                           this.wtx = -3500;
                           this.wtz = 19000;
                           this.frx = -14700;
                           this.frz = 39000;
                           this.frad = 45000;
                           this.oupnt = 37;
                           this.gowait = true;
                           this.afta = false;
                        }

                        if (var3.clear[0] == 18) {
                           this.wtx = -48300;
                           this.wtz = -4550;
                           this.frx = -48300;
                           this.frz = 5600;
                           this.frad = 90000;
                           this.oupnt = 17;
                           this.gowait = true;
                           this.afta = false;
                        }
                     }

                     if (this.gowait) {
                        if (this.py(var2.x / 100, this.wtx / 100, var2.z / 100, this.wtz / 100) < 10000 && var1.speed > 50.0F) {
                           this.up = false;
                        }

                        if (this.py(var2.x / 100, this.wtx / 100, var2.z / 100, this.wtz / 100) < 200) {
                           this.up = false;
                           this.handb = true;
                        }

                        if (var3.pcleared == this.oupnt && this.py(var3.opx[0] / 100, this.frx / 100, var3.opz[0] / 100, this.frz / 100) < this.frad) {
                           this.afta = true;
                           this.gowait = false;
                        }

                        if (this.py(var2.x / 100, var3.opx[0] / 100, var2.z / 100, var3.opz[0] / 100) < 25) {
                           this.afta = true;
                           this.gowait = false;
                           this.attack = 200;
                           this.acr = 0;
                        }
                     }
                  }

                  if (var3.stage == 25) {
                     if (this.oupnt == -1) {
                        int var42 = -10;

                        for (int var51 = 0; var51 < var3.n; var51++) {
                           if ((var3.typ[var51] == -2 || var3.typ[var51] == -4)
                              && (var51 < 50 || var51 > 54)
                              && (this.py(var2.x / 100, var3.x[var51] / 100, var2.z / 100, var3.z[var51] / 100) < var42 || var42 == -10)) {
                              var42 = this.py(var2.x / 100, var3.x[var51] / 100, var2.z / 100, var3.z[var51] / 100);
                              this.oupnt = var51;
                           }
                        }

                        this.oupnt--;
                        if (var25 < 0) {
                           this.oupnt = this.oupnt + var3.n;
                        }
                     }

                     if (this.oupnt >= 0 && this.oupnt < var3.n) {
                        var25 = this.oupnt;
                        if (this.py(var2.x / 100, var3.x[var25] / 100, var2.z / 100, var3.z[var25] / 100) < 800) {
                           this.oupnt = -((int)(75.0F + this.m.random() * 200.0F));
                           this.runbul = (int)(50.0F + this.m.random() * 100.0F);
                        }
                     }

                     if (this.oupnt < -1) {
                        this.oupnt++;
                     }

                     if (this.runbul != 0) {
                        this.runbul--;
                     }
                  }

                  if (var3.stage == 26) {
                     boolean var43 = false;
                     if (var1.cn == 13) {
                        if (!this.gowait) {
                           if (var3.clear[0] == 1) {
                              if (this.m.random() > 0.5) {
                                 this.wtx = -14000;
                                 this.wtz = 48000;
                                 this.frx = -5600;
                                 this.frz = 47600;
                                 this.frad = 88000;
                                 this.oupnt = 33;
                              } else {
                                 this.wtx = -5600;
                                 this.wtz = 8000;
                                 this.frx = -7350;
                                 this.frz = -4550;
                                 this.frad = 22000;
                                 this.oupnt = 15;
                              }

                              this.gowait = true;
                              this.afta = false;
                           }

                           if (var3.clear[0] == 4) {
                              this.wtx = -12700;
                              this.wtz = 14000;
                              this.frx = -31000;
                              this.frz = 1050;
                              this.frad = 11000;
                              this.oupnt = 51;
                              this.gowait = true;
                              this.afta = false;
                           }

                           if (var3.clear[0] == 14) {
                              this.wtx = -35350;
                              this.wtz = 6650;
                              this.frx = -48300;
                              this.frz = 54950;
                              this.frad = 11000;
                              this.oupnt = 15;
                              this.gowait = true;
                              this.afta = false;
                           }

                           if (var3.clear[0] == 17) {
                              this.wtx = -42700;
                              this.wtz = 41000;
                              this.frx = -40950;
                              this.frz = 49350;
                              this.frad = 7000;
                              this.oupnt = 42;
                              this.gowait = true;
                              this.afta = false;
                           }

                           if (var3.clear[0] == 21) {
                              this.wtx = -1750;
                              this.wtz = -15750;
                              this.frx = -25900;
                              this.frz = -14000;
                              this.frad = 11000;
                              this.oupnt = 125;
                              this.gowait = true;
                              this.afta = false;
                           }
                        }

                        if (this.gowait) {
                           if (this.py(var2.x / 100, this.wtx / 100, var2.z / 100, this.wtz / 100) < 10000 && var1.speed > 50.0F) {
                              this.up = false;
                           }

                           if (this.py(var2.x / 100, this.wtx / 100, var2.z / 100, this.wtz / 100) < 200) {
                              this.up = false;
                              this.handb = true;
                           }

                           if (var3.pcleared == this.oupnt && this.py(var3.opx[0] / 100, this.frx / 100, var3.opz[0] / 100, this.frz / 100) < this.frad) {
                              this.runbul = 0;
                              this.afta = true;
                              this.gowait = false;
                           }

                           if (this.py(var2.x / 100, var3.opx[0] / 100, var2.z / 100, var3.opz[0] / 100) < 25) {
                              this.afta = true;
                              this.gowait = false;
                              this.attack = 200;
                              this.acr = 0;
                           }

                           if (var3.clear[0] == 21 && this.oupnt != 125) {
                              this.gowait = false;
                           }
                        }

                        if (var3.clear[0] >= 11 && !this.gowait || var1.power < 60.0F && var3.clear[0] < 21) {
                           var43 = true;
                           if (!this.exitattack) {
                              this.oupnt = -1;
                              this.exitattack = true;
                           }
                        } else if (this.exitattack) {
                           this.exitattack = false;
                        }
                     }

                     if (var1.cn == 11) {
                        var43 = true;
                     }

                     if (var43) {
                        if (this.oupnt == -1) {
                           int var52 = -10;

                           for (int var58 = 0; var58 < var3.n; var58++) {
                              if (var3.typ[var58] == -4
                                 && (
                                    this.py(var2.x / 100, var3.x[var58] / 100, var2.z / 100, var3.z[var58] / 100) < var52 && this.m.random() > 0.6
                                       || var52 == -10
                                 )) {
                                 var52 = this.py(var2.x / 100, var3.x[var58] / 100, var2.z / 100, var3.z[var58] / 100);
                                 this.oupnt = var58;
                              }
                           }

                           this.oupnt--;
                           if (var25 < 0) {
                              this.oupnt = this.oupnt + var3.n;
                           }
                        }

                        if (this.oupnt >= 0 && this.oupnt < var3.n) {
                           var25 = this.oupnt;
                           if (this.py(var2.x / 100, var3.x[var25] / 100, var2.z / 100, var3.z[var25] / 100) < 800) {
                              this.oupnt = -((int)(75.0F + this.m.random() * 200.0F));
                              this.runbul = (int)(50.0F + this.m.random() * 100.0F);
                           }
                        }

                        if (this.oupnt < -1) {
                           this.oupnt++;
                        }

                        if (this.runbul != 0) {
                           this.runbul--;
                        }
                     }
                  }

                  var1.nofocus = true;
               } else {
                  if (this.rampp == 1 && var3.typ[var25] <= 0) {
                     int var39 = var25 + 1;
                     if (var39 >= var3.n) {
                        var39 = 0;
                     }

                     if (var3.typ[var39] == -2) {
                        var25 = var39;
                     }
                  }

                  if (this.rampp == -1 && var3.typ[var25] == -2) {
                     if (++var25 >= var3.n) {
                        var25 = 0;
                     }
                  }

                  if (!(this.m.random() > this.skiplev)) {
                     if (this.m.random() > this.skiplev) {
                        while (var3.typ[var25] == -1) {
                           if (++var25 >= var3.n) {
                              var25 = 0;
                           }
                        }
                     }
                  } else {
                     int var40 = var25;
                     boolean var49 = false;
                     if (var3.typ[var25] > 0) {
                        int var55 = 0;

                        for (int var60 = 0; var60 < var3.n; var60++) {
                           if (var3.typ[var60] > 0 && var60 < var40) {
                              var55++;
                           }
                        }

                        var49 = var1.clear != var55 + var1.nlaps * var3.nsp;
                     }

                     while (var3.typ[var40] == 0 || var3.typ[var40] == -1 || var3.typ[var40] == -3 || var49) {
                        var25 = var40++;
                        if (var40 >= var3.n) {
                           var40 = 0;
                        }

                        var49 = false;
                        if (var3.typ[var40] > 0) {
                           int var56 = 0;

                           for (int var61 = 0; var61 < var3.n; var61++) {
                              if (var3.typ[var61] > 0 && var61 < var40) {
                                 var56++;
                              }
                           }

                           var49 = var1.clear != var56 + var1.nlaps * var3.nsp;
                        }
                     }
                  }

                  if (var3.stage == 18 && var1.pcleared == 73 && this.trfix == 0 && var1.clear != 0) {
                     var25 = 10;
                  }

                  if (var3.stage == 19 && var1.pcleared == 18 && this.trfix == 0) {
                     var25 = 27;
                  }

                  if (var3.stage == 21) {
                     if (var1.pcleared == 5 && this.trfix == 0 && var1.power < 70.0F) {
                        if (var25 <= 16) {
                           var25 = 16;
                        } else {
                           var25 = 21;
                        }
                     }

                     if (var1.pcleared == 50) {
                        var25 = 57;
                     }
                  }

                  if (var3.stage == 22 && (var1.pcleared == 27 || var1.pcleared == 37)) {
                     while (var3.typ[var25] == -1) {
                        if (++var25 >= var3.n) {
                           var25 = 0;
                        }
                     }
                  }

                  if (var3.stage == 23) {
                     while (var3.typ[var25] == -1) {
                        if (++var25 >= var3.n) {
                           var25 = 0;
                        }
                     }
                  }

                  if (var3.stage == 24) {
                     while (var3.typ[var25] == -1) {
                        if (++var25 >= var3.n) {
                           var25 = 0;
                        }
                     }

                     if (!var1.gtouch) {
                        while (var3.typ[var25] == -2) {
                           if (++var25 >= var3.n) {
                              var25 = 0;
                           }
                        }
                     }

                     if (this.oupnt >= 68) {
                        var25 = 70;
                     } else {
                        this.oupnt = var25;
                     }
                  }

                  if (var3.stage == 25) {
                     if (var1.pcleared != 91 && var3.pos[0] < var3.pos[var1.im] && var1.cn != 13
                        || var3.pos[var1.im] == 0 && (var1.clear == 12 || var1.clear == 20)) {
                        while (var3.typ[var25] == -4) {
                           if (++var25 >= var3.n) {
                              var25 = 0;
                           }
                        }
                     }

                     if (var1.pcleared == 9) {
                        if (this.py(var2.x / 100, 297, var2.z / 100, 347) < 400) {
                           this.oupnt = 1;
                        }

                        if (this.oupnt == 1 && var25 < 22) {
                           var25 = 22;
                        }
                     }

                     if (var1.pcleared == 67) {
                        if (this.py(var2.x / 100, 28, var2.z / 100, 494) < 4000) {
                           this.oupnt = 2;
                        }

                        if (this.oupnt == 2) {
                           var25 = 76;
                        }
                     }

                     if (var1.pcleared == 76) {
                        if (this.py(var2.x / 100, -50, var2.z / 100, 0) < 2000) {
                           this.oupnt = 3;
                        }

                        if (this.oupnt == 3) {
                           var25 = 91;
                        } else {
                           var25 = 89;
                        }
                     }
                  }

                  if (var3.stage == 26) {
                     if (var1.pcleared == 128) {
                        if (this.py(var2.x / 100, 0, var2.z / 100, 229) < 1500 || var2.z > 23000) {
                           this.oupnt = 128;
                        }

                        if (this.oupnt != 128) {
                           var25 = 3;
                        }
                     }

                     if (var1.pcleared == 8) {
                        if (this.py(var2.x / 100, -207, var2.z / 100, 549) < 1500 || var2.x < -20700) {
                           this.oupnt = 8;
                        }

                        if (this.oupnt != 8) {
                           var25 = 12;
                        }
                     }

                     if (var1.pcleared == 33) {
                        if (this.py(var2.x / 100, -60, var2.z / 100, 168) < 250 || var2.z > 17000) {
                           this.oupnt = 331;
                        }

                        if (this.py(var2.x / 100, -112, var2.z / 100, 414) < 10000 || var2.z > 40000) {
                           this.oupnt = 332;
                        }

                        if (this.oupnt != 331 && this.oupnt != 332) {
                           if (this.trfix != 1) {
                              var25 = 38;
                           } else {
                              var25 = 39;
                           }
                        }

                        if (this.oupnt == 331) {
                           var25 = 71;
                        }
                     }

                     if (var1.pcleared == 42) {
                        if (this.py(var2.x / 100, -269, var2.z / 100, 493) < 100 || var2.x < -27000) {
                           this.oupnt = 142;
                        }

                        if (this.oupnt != 142) {
                           var25 = 47;
                        }
                     }

                     if (var1.pcleared == 51) {
                        if (this.py(var2.x / 100, -352, var2.z / 100, 260) < 100 || var2.z < 25000) {
                           this.oupnt = 511;
                        }

                        if (this.py(var2.x / 100, -325, var2.z / 100, 10) < 2000 || var2.x > -32000) {
                           this.oupnt = 512;
                        }

                        if (this.oupnt != 511 && this.oupnt != 512) {
                           var25 = 80;
                        }

                        if (this.oupnt == 511) {
                           var25 = 61;
                        }
                     }

                     if (var1.pcleared == 77) {
                        if (this.py(var2.x / 100, -371, var2.z / 100, 319) < 100 || var2.z < 31000) {
                           this.oupnt = 77;
                        }

                        if (this.oupnt != 77) {
                           var25 = 78;
                           var1.nofocus = true;
                        }
                     }

                     if (var1.pcleared == 105) {
                        if (this.py(var2.x / 100, -179, var2.z / 100, 10) < 2300 || var2.z < 1050) {
                           this.oupnt = 105;
                        }

                        if (this.oupnt != 105) {
                           var25 = 65;
                        } else {
                           var25 = 125;
                        }
                     }

                     if (this.trfix == 3) {
                        if (this.py(var2.x / 100, -52, var2.z / 100, 448) < 100 || var2.z > 45000) {
                           this.oupnt = 176;
                        }

                        if (this.oupnt != 176) {
                           var25 = 41;
                        } else {
                           var25 = 43;
                        }
                     }

                     if (var3.clear[var1.im] - var3.clear[0] >= 2
                        && this.py(var2.x / 100, var3.opx[0] / 100, var2.z / 100, var3.opz[0] / 100) < 1000 + this.avoidnlev) {
                        int var50 = var2.xz;
                        if (this.zyinv) {
                           var50 += 180;
                        }

                        while (var50 < 0) {
                           var50 += 360;
                        }

                        while (var50 > 180) {
                           var50 -= 360;
                        }

                        short var57 = 0;
                        if (var3.opx[0] - var2.x >= 0) {
                           var57 = 180;
                        }

                        int var62 = (int)(90 + var57 + Math.atan((double)(var3.opz[0] - var2.z) / (var3.opx[0] - var2.x)) / (Math.PI / 180.0));

                        while (var62 < 0) {
                           var62 += 360;
                        }

                        while (var62 > 180) {
                           var62 -= 360;
                        }

                        int var64 = Math.abs(var50 - var62);
                        if (var64 > 180) {
                           var64 = Math.abs(var64 - 360);
                        }

                        if (var64 < 90) {
                           this.wall = 0;
                        }
                     }
                  }

                  if (this.rampp == 2) {
                     int var41 = var25 + 1;
                     if (var41 >= var3.n) {
                        var41 = 0;
                     }

                     if (var3.typ[var41] == -2 && var25 != var1.point) {
                        if (--var25 < 0) {
                           var25 += var3.n;
                        }
                     }
                  }

                  if (this.bulistc) {
                     var1.nofocus = true;
                     if (this.gowait) {
                        this.gowait = false;
                     }
                  }
               }

               if (var3.stage != 27) {
                  if (var3.stage == 10 || var3.stage == 19 || var3.stage == 18 && var1.pcleared == 73 || var3.stage == 26) {
                     this.forget = true;
                  }

                  if ((var1.missedcp == 0 || this.forget || this.trfix == 4) && this.trfix != 0) {
                     byte var44 = 0;
                     if (var3.stage == 25 || var3.stage == 26) {
                        var44 = 3;
                     }

                     if (this.trfix == 2) {
                        int var53 = -10;
                        int var59 = 0;

                        for (int var63 = var44; var63 < var3.fn; var63++) {
                           if (this.py(var2.x / 100, var3.x[this.fpnt[var63]] / 100, var2.z / 100, var3.z[this.fpnt[var63]] / 100) < var53 || var53 == -10) {
                              var53 = this.py(var2.x / 100, var3.x[this.fpnt[var63]] / 100, var2.z / 100, var3.z[this.fpnt[var63]] / 100);
                              var59 = var63;
                           }
                        }

                        if (var3.stage == 18 || var3.stage == 22) {
                           var59 = 1;
                        }

                        var25 = this.fpnt[var59];
                        if (var3.special[var59]) {
                           this.forget = true;
                        } else {
                           this.forget = false;
                        }
                     }

                     for (int var54 = var44; var54 < var3.fn; var54++) {
                        if (this.py(var2.x / 100, var3.x[this.fpnt[var54]] / 100, var2.z / 100, var3.z[this.fpnt[var54]] / 100) < 2000) {
                           this.forget = false;
                           this.actwait = 0;
                           this.upwait = 0;
                           this.turntyp = 2;
                           this.randtcnt = -1;
                           this.acuracy = 0;
                           this.rampp = 0;
                           this.trfix = 3;
                        }
                     }

                     if (this.trfix == 3) {
                        var1.nofocus = true;
                     }
                  }
               }

               if (this.turncnt > this.randtcnt) {
                  if (!this.gowait) {
                     short var45 = 0;
                     if (var3.x[var25] - var2.x >= 0) {
                        var45 = 180;
                     }

                     this.pan = (int)(90 + var45 + Math.atan((double)(var3.z[var25] - var2.z) / (var3.x[var25] - var2.x)) / (Math.PI / 180.0));
                  } else {
                     short var46 = 0;
                     if (this.wtx - var2.x >= 0) {
                        var46 = 180;
                     }

                     this.pan = (int)(90 + var46 + Math.atan((double)(this.wtz - var2.z) / (this.wtx - var2.x)) / (Math.PI / 180.0));
                  }

                  this.turncnt = 0;
                  this.randtcnt = (int)(this.acuracy * this.m.random());
               } else {
                  this.turncnt++;
               }
            } else {
               this.up = true;
               short var24 = 0;
               int var33 = (int)(this.pys(var2.x, var3.opx[this.acr], var2.z, var3.opz[this.acr]) / 2.0F * this.aim);
               int var38 = (int)(var3.opx[this.acr] - var33 * this.m.sin(var3.omxz[this.acr]));
               int var48 = (int)(var3.opz[this.acr] + var33 * this.m.cos(var3.omxz[this.acr]));
               if (var38 - var2.x >= 0) {
                  var24 = 180;
               }

               this.pan = (int)(90 + var24 + Math.atan((double)(var48 - var2.z) / (var38 - var2.x)) / (Math.PI / 180.0));
               this.attack--;
               if (this.attack <= 0) {
                  this.attack = 0;
               }

               if (var3.stage == 25 && this.exitattack && !this.bulistc && var1.missedcp != 0) {
                  this.attack = 0;
               }

               if (var3.stage == 26 && var1.cn == 13 && (var3.clear[0] == 4 || var3.clear[0] == 13 || var3.clear[0] == 21)) {
                  this.attack = 0;
               }

               if (var3.stage == 26 && var1.missedcp != 0 && (var3.pos[var1.im] == 0 || var3.pos[var1.im] == 1 && var3.pos[0] == 0)) {
                  this.attack = 0;
               }

               if (var3.stage == 26 && var3.pos[0] > var3.pos[var1.im] && var1.power < 80.0F) {
                  this.attack = 0;
               }
            }

            int var26 = var2.xz;
            if (this.zyinv) {
               var26 += 180;
            }

            while (var26 < 0) {
               var26 += 360;
            }

            while (var26 > 180) {
               var26 -= 360;
            }

            while (this.pan < 0) {
               this.pan += 360;
            }

            while (this.pan > 180) {
               this.pan -= 360;
            }

            if (this.wall != -1 && this.hold == 0) {
               this.clrnce = 0;
            }

            if (this.hold == 0) {
               if (Math.abs(var26 - this.pan) < 180) {
                  if (Math.abs(var26 - this.pan) > this.clrnce) {
                     if (var26 < this.pan) {
                        this.left = true;
                        this.lastl = true;
                     } else {
                        this.right = true;
                        this.lastl = false;
                     }

                     if (Math.abs(var26 - this.pan) > 50 && var1.speed > var1.cd.swits[var1.cn][0] && this.turntyp != 0) {
                        if (this.turntyp == 1) {
                           this.down = true;
                        }

                        if (this.turntyp == 2) {
                           this.handb = true;
                        }

                        if (!this.agressed) {
                           this.up = false;
                        }
                     }
                  }
               } else if (Math.abs(var26 - this.pan) < 360 - this.clrnce) {
                  if (var26 < this.pan) {
                     this.right = true;
                     this.lastl = false;
                  } else {
                     this.left = true;
                     this.lastl = true;
                  }

                  if (Math.abs(var26 - this.pan) < 310 && var1.speed > var1.cd.swits[var1.cn][0] && this.turntyp != 0) {
                     if (this.turntyp == 1) {
                        this.down = true;
                     }

                     if (this.turntyp == 2) {
                        this.handb = true;
                     }

                     if (!this.agressed) {
                        this.up = false;
                     }
                  }
               }
            }

            if (var3.stage == 24 && this.wall != -1) {
               if (var4.dam[this.wall] == 0 || var1.pcleared == 45) {
                  this.wall = -1;
               }

               if (var1.pcleared == 58 && var3.opz[var1.im] < 36700) {
                  this.wall = -1;
                  this.hold = 0;
               }
            }

            if (this.wall != -1) {
               if (this.lwall != this.wall) {
                  if (this.lastl) {
                     this.left = true;
                  } else {
                     this.right = true;
                  }

                  this.wlastl = this.lastl;
                  this.lwall = this.wall;
               } else if (this.wlastl) {
                  this.left = true;
               } else {
                  this.right = true;
               }

               if (var4.dam[this.wall] != 0) {
                  byte var35 = 1;
                  if (var4.skd[this.wall] == 1) {
                     var35 = 3;
                  }

                  this.hold += var35;
                  if (this.hold > 10 * var35) {
                     this.hold = 10 * var35;
                  }
               } else {
                  this.hold = 1;
               }

               this.wall = -1;
            } else if (this.hold != 0) {
               this.hold--;
            }
         } else {
            if (this.trickfase == 0) {
               int var27 = (int)((var1.scy[0] + var1.scy[1] + var1.scy[2] + var1.scy[3]) * (var2.y - 300) / 4000.0F);
               byte var36 = 3;
               if (var3.stage == 25) {
                  var36 = 10;
               }

               if (var27 > 7
                  && (
                     this.m.random() > this.trickprf / var36
                        || this.stuntf == 4
                        || this.stuntf == 3
                        || this.stuntf == 5
                        || this.stuntf == 6
                        || var3.stage == 26
                  )) {
                  this.oxy = var1.pxy;
                  this.ozy = var1.pzy;
                  this.flycnt = 0;
                  this.uddirect = 0;
                  this.lrdirect = 0;
                  this.udswt = false;
                  this.lrswt = false;
                  this.trickfase = 1;
                  if (var27 < 16) {
                     if (this.stuntf != 6) {
                        this.uddirect = -1;
                        this.udstart = 0;
                        this.udswt = false;
                     } else if (this.oupnt != 70) {
                        this.uddirect = 1;
                        this.udstart = 0;
                        this.udswt = false;
                     }
                  } else if ((!(this.m.random() > this.m.random()) || this.stuntf == 1)
                     && this.stuntf != 4
                     && this.stuntf != 6
                     && this.stuntf != 7
                     && this.stuntf != 17) {
                     if (this.m.random() > this.m.random()) {
                        this.lrdirect = -1;
                     } else {
                        this.lrdirect = 1;
                     }

                     this.lrstart = (int)(10.0F * this.m.random() * this.trickprf);
                     if (this.m.random() > 0.75 && var3.stage != 26) {
                        this.lrswt = true;
                     }

                     if (this.m.random() > this.trickprf + 0.3F) {
                        if (this.m.random() > this.m.random()) {
                           this.uddirect = -1;
                        } else {
                           this.uddirect = 1;
                        }

                        this.udstart = (int)(30.0F * this.m.random());
                        if (this.m.random() > 0.85) {
                           this.udswt = true;
                        }
                     }
                  } else {
                     if ((this.m.random() > this.m.random() || this.stuntf == 2 || this.stuntf == 7) && this.stuntf != 4 && this.stuntf != 6) {
                        this.uddirect = -1;
                     } else {
                        this.uddirect = 1;
                     }

                     this.udstart = (int)(10.0F * this.m.random() * this.trickprf);
                     if (this.stuntf == 6) {
                        this.udstart = 0;
                     }

                     if (var3.stage == 26) {
                        this.udstart = 0;
                     }

                     if (var3.stage == 24 && (this.oupnt == 68 || this.oupnt == 69)) {
                        this.apunch = 20;
                        this.oupnt = 70;
                     }

                     if (this.m.random() > 0.85 && this.stuntf != 4 && this.stuntf != 3 && this.stuntf != 6 && this.stuntf != 17 && var3.stage != 26) {
                        this.udswt = true;
                     }

                     if (this.m.random() > this.trickprf + 0.3F && this.stuntf != 4 && this.stuntf != 6) {
                        if (this.m.random() > this.m.random()) {
                           this.lrdirect = -1;
                        } else {
                           this.lrdirect = 1;
                        }

                        this.lrstart = (int)(30.0F * this.m.random());
                        if (this.m.random() > 0.75) {
                           this.lrswt = true;
                        }
                     }
                  }

                  if (this.trfix == 3 || this.trfix == 4) {
                     if (var3.stage != 18 && var3.stage != 8) {
                        if (var3.stage != 25 && this.lrdirect == -1) {
                           if (var3.stage != 19) {
                              this.uddirect = -1;
                           } else {
                              this.uddirect = 1;
                           }
                        }

                        this.lrdirect = 0;
                        if ((var3.stage == 19 || var3.stage == 25) && this.uddirect == -1) {
                           this.uddirect = 1;
                        }

                        if (var1.power < 60.0F) {
                           this.uddirect = -1;
                        }
                     } else {
                        if (this.uddirect != 0) {
                           this.uddirect = -1;
                        }

                        this.lrdirect = 0;
                     }

                     if (var3.stage == 20) {
                        this.uddirect = 1;
                        this.lrdirect = 0;
                     }

                     if (var3.stage == 26) {
                        this.uddirect = -1;
                        this.lrdirect = 0;
                        if (var1.cn != 11 && var1.cn != 13) {
                           this.udstart = 7;
                           if (var1.cn == 14 && var1.power > 30.0F) {
                              this.udstart = 14;
                           }
                        } else {
                           this.udstart = 0;
                        }

                        if (var1.cn == 11) {
                           this.lrdirect = -1;
                           this.lrstart = 0;
                        }
                     }
                  }
               } else {
                  this.trickfase = -1;
               }

               if (!this.afta) {
                  this.afta = true;
               }

               if (this.trfix == 3) {
                  this.trfix = 4;
                  this.statusque += 30;
               }
            }

            if (this.trickfase == 1) {
               this.flycnt++;
               if (this.lrdirect != 0 && this.flycnt > this.lrstart) {
                  if (this.lrswt && Math.abs(var1.pxy - this.oxy) > 180) {
                     if (this.lrdirect == -1) {
                        this.lrdirect = 1;
                     } else {
                        this.lrdirect = -1;
                     }

                     this.lrswt = false;
                  }

                  if (this.lrdirect == -1) {
                     this.handb = true;
                     this.left = true;
                  } else {
                     this.handb = true;
                     this.right = true;
                  }
               }

               if (this.uddirect != 0 && this.flycnt > this.udstart) {
                  if (this.udswt && Math.abs(var1.pzy - this.ozy) > 180) {
                     if (this.uddirect == -1) {
                        this.uddirect = 1;
                     } else {
                        this.uddirect = -1;
                     }

                     this.udswt = false;
                  }

                  if (this.uddirect == -1) {
                     this.handb = true;
                     this.down = true;
                  } else {
                     this.handb = true;
                     this.up = true;
                     if (this.apunch > 0) {
                        this.down = true;
                        this.apunch--;
                     }
                  }
               }

               if ((var1.scy[0] + var1.scy[1] + var1.scy[2] + var1.scy[3]) * 100.0F / (var2.y - 300) < -this.saftey) {
                  this.onceu = false;
                  this.onced = false;
                  this.oncel = false;
                  this.oncer = false;
                  this.lrcomp = false;
                  this.udcomp = false;
                  this.udbare = false;
                  this.lrbare = false;
                  this.trickfase = 2;
                  this.swat = 0;
               }
            }

            if (this.trickfase == 2) {
               if (this.swat == 0) {
                  if (var1.dcomp != 0.0F || var1.ucomp != 0.0F) {
                     this.udbare = true;
                  }

                  if (var1.lcomp != 0.0F || var1.rcomp != 0.0F) {
                     this.lrbare = true;
                  }

                  this.swat = 1;
               }

               if (var1.wtouch) {
                  if (this.swat == 1) {
                     this.swat = 2;
                  }
               } else if (this.swat == 2) {
                  if (var1.capsized && this.m.random() > this.mustland) {
                     if (this.udbare) {
                        this.lrbare = true;
                        this.udbare = false;
                     } else if (this.lrbare) {
                        this.udbare = true;
                        this.lrbare = false;
                     }
                  }

                  this.swat = 3;
               }

               if (this.udbare) {
                  int var28 = var1.pzy + 90;

                  while (var28 < 0) {
                     var28 += 360;
                  }

                  while (var28 > 180) {
                     var28 -= 360;
                  }

                  var28 = Math.abs(var28);
                  if (var1.lcomp - var1.rcomp < 5.0F && (this.onced || this.onceu)) {
                     this.udcomp = true;
                  }

                  if (var1.dcomp > var1.ucomp) {
                     if (var1.capsized) {
                        if (this.udcomp) {
                           if (var28 > 90) {
                              this.up = true;
                           } else {
                              this.down = true;
                           }
                        } else if (!this.onced) {
                           this.down = true;
                        }
                     } else {
                        if (this.udcomp) {
                           if (this.perfection && Math.abs(var28 - 90) > 30) {
                              if (var28 > 90) {
                                 this.up = true;
                              } else {
                                 this.down = true;
                              }
                           }
                        } else if (this.m.random() > this.mustland) {
                           this.up = true;
                        }

                        this.onced = true;
                     }
                  } else if (var1.capsized) {
                     if (this.udcomp) {
                        if (var28 > 90) {
                           this.up = true;
                        } else {
                           this.down = true;
                        }
                     } else if (!this.onceu) {
                        this.up = true;
                     }
                  } else {
                     if (this.udcomp) {
                        if (this.perfection && Math.abs(var28 - 90) > 30) {
                           if (var28 > 90) {
                              this.up = true;
                           } else {
                              this.down = true;
                           }
                        }
                     } else if (this.m.random() > this.mustland) {
                        this.down = true;
                     }

                     this.onceu = true;
                  }
               }

               if (this.lrbare) {
                  int var30 = var1.pxy + 90;
                  if (this.zyinv) {
                     var30 += 180;
                  }

                  while (var30 < 0) {
                     var30 += 360;
                  }

                  while (var30 > 180) {
                     var30 -= 360;
                  }

                  var30 = Math.abs(var30);
                  if (var1.lcomp - var1.rcomp < 10.0F && (this.oncel || this.oncer)) {
                     this.lrcomp = true;
                  }

                  if (var1.lcomp > var1.rcomp) {
                     if (var1.capsized) {
                        if (this.lrcomp) {
                           if (var30 > 90) {
                              this.left = true;
                           } else {
                              this.right = true;
                           }
                        } else if (!this.oncel) {
                           this.left = true;
                        }
                     } else {
                        if (this.lrcomp) {
                           if (this.perfection && Math.abs(var30 - 90) > 30) {
                              if (var30 > 90) {
                                 this.left = true;
                              } else {
                                 this.right = true;
                              }
                           }
                        } else if (this.m.random() > this.mustland) {
                           this.right = true;
                        }

                        this.oncel = true;
                     }
                  } else if (var1.capsized) {
                     if (this.lrcomp) {
                        if (var30 > 90) {
                           this.left = true;
                        } else {
                           this.right = true;
                        }
                     } else if (!this.oncer) {
                        this.right = true;
                     }
                  } else {
                     if (this.lrcomp) {
                        if (this.perfection && Math.abs(var30 - 90) > 30) {
                           if (var30 > 90) {
                              this.left = true;
                           } else {
                              this.right = true;
                           }
                        }
                     } else if (this.m.random() > this.mustland) {
                        this.left = true;
                     }

                     this.oncer = true;
                  }
               }
            }
         }
      }
   }

   public int py(int var1, int var2, int var3, int var4) {
      return (var1 - var2) * (var1 - var2) + (var3 - var4) * (var3 - var4);
   }

   public int pys(int var1, int var2, int var3, int var4) {
      return (int)Math.sqrt((var1 - var2) * (var1 - var2) + (var3 - var4) * (var3 - var4));
   }
}
