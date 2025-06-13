import java.awt.Color;
import java.awt.Graphics;

public class Medium {
   int focus_point = 400;
   int ground = 250;
   int skyline = -300;
   int[] fade = new int[]{3000, 6000, 9000, 12000, 15000, 18000, 21000, 24000};
   int[] csky = new int[]{170, 220, 255};
   int[] cgrnd = new int[]{205, 200, 200};
   int[] cpol = new int[]{215, 210, 210};
   int[] cfade = new int[]{255, 220, 220};
   int[] snap = new int[3];
   int origfade = 3000;
   int fogd = 3;
   boolean lightson = false;
   boolean darksky = false;
   int lightn = -1;
   int lilo = 217;
   int flex = 0;
   boolean trk = false;
   boolean crs = false;
   int cx = 335;
   int cy = 200;
   int cz = 50;
   int xz = 0;
   int zy = 0;
   int x = 0;
   int y = 0;
   int z = 0;
   int w = 670;
   int h = 400;
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
   int trns = 1;
   int dispolys = 0;
   int[][] ogpx = new int[9500][8];
   int[][] ogpz = new int[9500][8];
   int[] cgpx = new int[9500];
   int[] cgpz = new int[9500];
   int sgpx = 0;
   int sgpz = 0;
   int nrw = 0;
   int ncl = 0;
   float[] tcos = new float[360];
   float[] tsin = new float[360];
   int lastmaf = 0;
   int checkpoint = -1;
   boolean lastcheck = false;
   float elecr = 0.0F;
   boolean cpflik = false;
   boolean nochekflk = false;
   int cntrn = 0;
   boolean[] diup = new boolean[3];
   int[] rand = new int[3];
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

   public float random() {
      if (this.cntrn == 0) {
         int i = 0;

         do {
            this.rand[i] = (int)(10.0 * Math.random());
            if (Math.random() > Math.random()) {
               this.diup[i] = false;
            } else {
               this.diup[i] = true;
            }
         } while (++i < 3);

         this.cntrn = 20;
      } else {
         this.cntrn += -1;
      }

      int i = 0;

      do {
         if (this.diup[i]) {
            this.rand[i]++;
            if (this.rand[i] == 10) {
               this.rand[i] = 0;
            }
         } else {
            this.rand[i] = this.rand[i] + -1;
            if (this.rand[i] == -1) {
               this.rand[i] = 9;
            }
         }
      } while (++i < 3);

      this.trn++;
      if (this.trn == 3) {
         this.trn = 0;
      }

      return this.rand[this.trn] / 10.0F;
   }

   public void groundpolys(Graphics graphics) {
      int i = (this.x - this.sgpx) / 1200 - 7;
      if (i < 0) {
         i = 0;
      }

      int i_0_ = i + 15;
      if (i_0_ > this.nrw) {
         i_0_ = this.nrw;
      }

      int i_1_ = (this.z - this.sgpz) / 1200 - 7;
      if (i_1_ < 0) {
         i_1_ = 0;
      }

      int i_2_ = i_1_ + 15;
      if (i_2_ > this.ncl) {
         i_2_ = this.ncl;
      }

      for (int i_3_ = i; i_3_ < i_0_; i_3_++) {
         for (int i_4_ = i_1_; i_4_ < i_2_; i_4_++) {
            int i_5_ = i_3_ + i_4_ * this.nrw;
            int i_6_ = this.cx + (int)((this.cgpx[i_5_] - this.x - this.cx) * this.cos(this.xz) - (this.cgpz[i_5_] - this.z - this.cz) * this.sin(this.xz));
            int i_7_ = this.cz + (int)((this.cgpx[i_5_] - this.x - this.cx) * this.sin(this.xz) + (this.cgpz[i_5_] - this.z - this.cz) * this.cos(this.xz));
            int i_8_ = this.cz + (int)((250 - this.y - this.cy) * this.sin(this.zy) + (i_7_ - this.cz) * this.cos(this.zy));
            if (this.xs(i_6_ + 700, i_8_) > 0 && this.xs(i_6_ - 700, i_8_) < this.w && i_8_ > -700 && i_8_ < (this.fade[0] + this.fade[1]) / 2) {
               int[] is = new int[8];
               int[] is_9_ = new int[8];
               int[] is_10_ = new int[8];
               int i_11_ = 0;

               do {
                  is[i_11_] = this.ogpx[i_5_][i_11_] + this.cgpx[i_5_] - this.x;
                  is_9_[i_11_] = this.ogpz[i_5_][i_11_] + this.cgpz[i_5_] - this.z;
                  is_10_[i_11_] = this.ground;
               } while (++i_11_ < 8);

               this.rot(is, is_9_, this.cx, this.cz, this.xz, 8);
               this.rot(is_10_, is_9_, this.cy, this.cz, this.zy, 8);
               int[] is_12_ = new int[8];
               int[] is_13_ = new int[8];
               int i_14_ = 0;
               int i_15_ = 0;
               int i_16_ = 0;
               int i_17_ = 0;
               boolean bool = true;
               int i_18_ = 0;

               do {
                  is_12_[i_18_] = this.xs(is[i_18_], is_9_[i_18_]);
                  is_13_[i_18_] = this.ys(is_10_[i_18_], is_9_[i_18_]);
                  if (is_13_[i_18_] < 0 || is_9_[i_18_] < 10) {
                     i_14_++;
                  }

                  if (is_13_[i_18_] > this.h || is_9_[i_18_] < 10) {
                     i_15_++;
                  }

                  if (is_12_[i_18_] < 0 || is_9_[i_18_] < 10) {
                     i_16_++;
                  }

                  if (is_12_[i_18_] > this.w || is_9_[i_18_] < 10) {
                     i_17_++;
                  }
               } while (++i_18_ < 8);

               if (i_16_ == 8 || i_14_ == 8 || i_15_ == 8 || i_17_ == 8) {
                  bool = false;
               }

               if (bool) {
                  i_18_ = this.cpol[0];
                  int i_19_ = this.cpol[1];
                  int i_20_ = this.cpol[2];
                  if (i_8_ > this.fade[0]) {
                     i_18_ = (i_18_ * 3 + this.cfade[0]) / 4;
                     i_19_ = (i_19_ * 3 + this.cfade[1]) / 4;
                     i_20_ = (i_20_ * 3 + this.cfade[2]) / 4;
                  }

                  graphics.setColor(new Color(i_18_, i_19_, i_20_));
                  graphics.fillPolygon(is_12_, is_13_, 8);
               }
            }
         }
      }
   }

   public void setpolys(int i, int i_21_, int i_22_) {
      this.cpol[0] = (int)(i + i * (this.snap[0] / 100.0F));
      if (this.cpol[0] > 255) {
         this.cpol[0] = 255;
      }

      if (this.cpol[0] < 0) {
         this.cpol[0] = 0;
      }

      this.cpol[1] = (int)(i_21_ + i_21_ * (this.snap[1] / 100.0F));
      if (this.cpol[1] > 255) {
         this.cpol[1] = 255;
      }

      if (this.cpol[1] < 0) {
         this.cpol[1] = 0;
      }

      this.cpol[2] = (int)(i_22_ + i_22_ * (this.snap[2] / 100.0F));
      if (this.cpol[2] > 255) {
         this.cpol[2] = 255;
      }

      if (this.cpol[2] < 0) {
         this.cpol[2] = 0;
      }

      this.dispolys = 0;
   }

   public int ys(int i, int i_23_) {
      if (i_23_ < 10) {
         i_23_ = 10;
      }

      return (i_23_ - this.focus_point) * (this.cy - i) / i_23_ + i;
   }

   public float sin(int i) {
      while (i >= 360) {
         i -= 360;
      }

      while (i < 0) {
         i += 360;
      }

      return this.tsin[i];
   }

   public Medium() {
      int i = 0;

      do {
         this.tcos[i] = (float)Math.cos(i * (Math.PI / 180.0));
      } while (++i < 360);

      i = 0;

      do {
         this.tsin[i] = (float)Math.sin(i * (Math.PI / 180.0));
      } while (++i < 360);
   }

   public void setfade(int i, int i_24_, int i_25_) {
      this.cfade[0] = (int)(i + i * (this.snap[0] / 100.0F));
      if (this.cfade[0] > 255) {
         this.cfade[0] = 255;
      }

      if (this.cfade[0] < 0) {
         this.cfade[0] = 0;
      }

      this.cfade[1] = (int)(i_24_ + i_24_ * (this.snap[1] / 100.0F));
      if (this.cfade[1] > 255) {
         this.cfade[1] = 255;
      }

      if (this.cfade[1] < 0) {
         this.cfade[1] = 0;
      }

      this.cfade[2] = (int)(i_25_ + i_25_ * (this.snap[2] / 100.0F));
      if (this.cfade[2] > 255) {
         this.cfade[2] = 255;
      }

      if (this.cfade[2] < 0) {
         this.cfade[2] = 0;
      }
   }

   public void d(Graphics graphics) {
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
      int[] is = new int[4];
      int[] is_26_ = new int[4];
      int i = this.cgrnd[0];
      int i_27_ = this.cgrnd[1];
      int i_28_ = this.cgrnd[2];
      int i_29_ = this.h;
      int i_30_ = 0;

      do {
         int i_31_ = this.fade[i_30_];
         int i_32_ = this.ground;
         if (this.zy != 0) {
            i_32_ = this.cy + (int)((this.ground - this.cy) * this.cos(this.zy) - (this.fade[i_30_] - this.cz) * this.sin(this.zy));
            i_31_ = this.cz + (int)((this.ground - this.cy) * this.sin(this.zy) + (this.fade[i_30_] - this.cz) * this.cos(this.zy));
         }

         is[0] = 0;
         is_26_[0] = this.ys(i_32_, i_31_);
         if (is_26_[0] < 0) {
            is_26_[0] = 0;
         }

         is[1] = 0;
         is_26_[1] = i_29_;
         is[2] = this.w;
         is_26_[2] = i_29_;
         is[3] = this.w;
         is_26_[3] = is_26_[0];
         i_29_ = is_26_[0];
         if (i_30_ > 0) {
            i = (i * 3 + this.cfade[0]) / 4;
            i_27_ = (i_27_ * 3 + this.cfade[1]) / 4;
            i_28_ = (i_28_ * 3 + this.cfade[2]) / 4;
         }

         if (is_26_[0] < this.h && is_26_[1] > 0) {
            graphics.setColor(new Color(i, i_27_, i_28_));
            graphics.fillPolygon(is, is_26_, 4);
         }
      } while (++i_30_ < 8);

      if (this.lightn != -1) {
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

         this.flex = 0;
      }

      i = this.csky[0];
      i_27_ = this.csky[1];
      i_28_ = this.csky[2];
      i_30_ = 0;
      if (this.flex == 2) {
         is[0] = 260;
         is_26_[0] = 45;
         is[1] = 260;
         is_26_[1] = 0;
         is[2] = 410;
         is_26_[2] = 0;
         is[3] = 410;
         is_26_[3] = 45;
         graphics.setColor(new Color(i, i_27_, i_28_));
         graphics.fillPolygon(is, is_26_, 4);
      }

      int i_33_ = 0;

      do {
         int i_34_ = this.fade[i_33_];
         int i_35_ = this.skyline;
         if (this.zy != 0) {
            i_35_ = this.cy + (int)((this.skyline - this.cy) * this.cos(this.zy) - (this.fade[i_33_] - this.cz) * this.sin(this.zy));
            i_34_ = this.cz + (int)((this.skyline - this.cy) * this.sin(this.zy) + (this.fade[i_33_] - this.cz) * this.cos(this.zy));
         }

         is[0] = 0;
         is_26_[0] = this.ys(i_35_, i_34_);
         if (is_26_[0] > this.h) {
            is_26_[0] = this.h;
         }

         is[1] = 0;
         is_26_[1] = i_30_;
         is[2] = this.w;
         is_26_[2] = i_30_;
         is[3] = this.w;
         is_26_[3] = is_26_[0];
         i_30_ = is_26_[0];
         if (i_33_ > 0) {
            i = (i * 3 + this.cfade[0]) / 4;
            i_27_ = (i_27_ * 3 + this.cfade[1]) / 4;
            i_28_ = (i_28_ * 3 + this.cfade[2]) / 4;
         }

         if (is_26_[0] > 0 && is_26_[1] < this.h) {
            graphics.setColor(new Color(i, i_27_, i_28_));
            graphics.fillPolygon(is, is_26_, 4);
         }
      } while (++i_33_ < 8);

      is[0] = 0;
      is_26_[0] = i_30_;
      is[1] = 0;
      is_26_[1] = i_29_;
      is[2] = this.w;
      is_26_[2] = i_29_;
      is[3] = this.w;
      is_26_[3] = i_30_;
      if (is_26_[0] < this.h && is_26_[1] > 0) {
         graphics.setColor(new Color(this.cfade[0], this.cfade[1], this.cfade[2]));
         graphics.fillPolygon(is, is_26_, 4);
      }

      if (this.dispolys != 2) {
         this.groundpolys(graphics);
      }

      if (this.cpflik) {
         this.cpflik = false;
      } else {
         this.cpflik = true;
         this.elecr = this.random() * 15.0F - 6.0F;
      }
   }

   public void watch(ContO conto, int i) {
      if (this.flex != 0) {
         this.flex = 0;
      }

      if (this.td) {
         this.y = (int)(conto.y - 300 - 1100.0F * this.random());
         this.x = conto.x + (int)((conto.x + 400 - conto.x) * this.cos(i) - (conto.z + 5000 - conto.z) * this.sin(i));
         this.z = conto.z + (int)((conto.x + 400 - conto.x) * this.sin(i) + (conto.z + 5000 - conto.z) * this.cos(i));
         this.td = false;
      }

      int i_36_ = 0;
      if (conto.x - this.x - this.cx > 0) {
         i_36_ = 180;
      }

      int i_37_ = -((int)(90 + i_36_ + Math.atan((double)(conto.z - this.z) / (conto.x - this.x - this.cx)) / (Math.PI / 180.0)));
      int var7 = 0;
      if (conto.y - this.y - this.cy < 0) {
         var7 = -180;
      }

      int i_38_ = (int)Math.sqrt((conto.z - this.z) * (conto.z - this.z) + (conto.x - this.x - this.cx) * (conto.x - this.x - this.cx));
      int i_39_ = (int)(90 + var7 - Math.atan((double)i_38_ / (conto.y - this.y - this.cy)) / (Math.PI / 180.0));
      this.xz = this.xz + (i_37_ - this.xz) / this.trns;
      if (this.trns != 1) {
         this.trns += -1;
      }

      this.zy = this.zy + (i_39_ - this.zy) / 5;
      if ((int)Math.sqrt(
            (conto.z - this.z) * (conto.z - this.z)
               + (conto.x - this.x - this.cx) * (conto.x - this.x - this.cx)
               + (conto.y - this.y - this.cy) * (conto.y - this.y - this.cy)
         )
         > 6000) {
         this.td = true;
      }
   }

   public void rot(int[] is, int[] is_40_, int i, int i_41_, int i_42_, int i_43_) {
      if (i_42_ != 0) {
         for (int i_44_ = 0; i_44_ < i_43_; i_44_++) {
            int i_45_ = is[i_44_];
            int i_46_ = is_40_[i_44_];
            is[i_44_] = i + (int)((i_45_ - i) * this.cos(i_42_) - (i_46_ - i_41_) * this.sin(i_42_));
            is_40_[i_44_] = i_41_ + (int)((i_45_ - i) * this.sin(i_42_) + (i_46_ - i_41_) * this.cos(i_42_));
         }
      }
   }

   public void setsnap(int i, int i_47_, int i_48_) {
      this.snap[0] = i;
      this.snap[1] = i_47_;
      this.snap[2] = i_48_;
   }

   public void around(ContO conto, boolean bool) {
      if (this.flex != 0) {
         this.flex = 0;
      }

      if (!bool) {
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
      }

      int i = 500 + this.adv;
      if (bool && i < 1300) {
         i = 1300;
      }

      if (i < 1000) {
         i = 1000;
      }

      this.y = conto.y - this.adv;
      if (this.y > 10) {
         this.vert = false;
      }

      this.x = conto.x + (int)((conto.x - i - conto.x) * this.cos(this.vxz));
      this.z = conto.z + (int)((conto.x - i - conto.x) * this.sin(this.vxz));
      if (!bool) {
         this.vxz += 2;
      } else {
         this.vxz += 4;
      }

      int i_49_ = 0;
      int i_50_ = this.y;
      if (i_50_ > 0) {
         i_50_ = 0;
      }

      if (conto.y - i_50_ - this.cy < 0) {
         i_49_ = -180;
      }

      int i_51_ = (int)Math.sqrt((conto.z - this.z + this.cz) * (conto.z - this.z + this.cz) + (conto.x - this.x - this.cx) * (conto.x - this.x - this.cx));
      int i_52_ = (int)(90 + i_49_ - Math.atan((double)i_51_ / (conto.y - i_50_ - this.cy)) / (Math.PI / 180.0));
      this.xz = -this.vxz + 90;
      if (bool) {
         i_52_ -= 15;
      }

      this.zy = this.zy + (i_52_ - this.zy) / 10;
      if (this.trns != 5) {
         this.trns = 5;
      }
   }

   public void setgrnd(int i, int i_53_, int i_54_) {
      this.cgrnd[0] = (int)(i + i * (this.snap[0] / 100.0F));
      if (this.cgrnd[0] > 255) {
         this.cgrnd[0] = 255;
      }

      if (this.cgrnd[0] < 0) {
         this.cgrnd[0] = 0;
      }

      this.cgrnd[1] = (int)(i_53_ + i_53_ * (this.snap[1] / 100.0F));
      if (this.cgrnd[1] > 255) {
         this.cgrnd[1] = 255;
      }

      if (this.cgrnd[1] < 0) {
         this.cgrnd[1] = 0;
      }

      this.cgrnd[2] = (int)(i_54_ + i_54_ * (this.snap[2] / 100.0F));
      if (this.cgrnd[2] > 255) {
         this.cgrnd[2] = 255;
      }

      if (this.cgrnd[2] < 0) {
         this.cgrnd[2] = 0;
      }

      this.dispolys = 2;
   }

   public int xs(int i, int i_55_) {
      if (i_55_ < this.cz) {
         i_55_ = this.cz;
      }

      return (i_55_ - this.focus_point) * (this.cx - i) / i_55_ + i;
   }

   public void adjstfade(float f) {
      if (f < 15.0F) {
         this.fade[0] = (int)(this.origfade - 1000.0F * (15.0F - f));
         if (this.fade[0] < 3000) {
            this.fade[0] = 3000;
         }

         this.fadfrom(this.fade[0]);
      } else if (this.fade[0] != this.origfade) {
         this.fade[0] = this.fade[0] + 500;
         if (this.fade[0] > this.origfade) {
            this.fade[0] = this.origfade;
         }

         this.fadfrom(this.fade[0]);
      }
   }

   public void addsp(int i, int i_56_, int i_57_) {
      if (this.nsp != 7) {
         this.spx[this.nsp] = i;
         this.spz[this.nsp] = i_56_;
         this.sprad[this.nsp] = i_57_;
         this.nsp++;
      }
   }

   public void aroundtrack(CheckPoints checkpoints) {
      if (this.flex != 0) {
         this.flex = 0;
      }

      this.y = -this.hit;
      this.x = this.cx + (int)this.trx + (int)(17000.0F * this.cos(this.vxz));
      this.z = (int)this.trz + (int)(17000.0F * this.sin(this.vxz));
      if (this.hit > 5000) {
         if (this.hit == 45000) {
            this.fo = 1.0F;
            this.zy = 67;
            this.atrx = (checkpoints.x[0] - this.trx) / 116L;
            this.atrz = (checkpoints.z[0] - this.trz) / 116L;
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
         this.trx = this.trx - (this.trx - checkpoints.x[this.ptr]) / 10L;
         this.trz = this.trz - (this.trz - checkpoints.z[this.ptr]) / 10L;
         if (this.ptcnt == 7) {
            this.ptr++;
            if (this.ptr == checkpoints.n) {
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
      boolean bool = false;
      if (-this.y - this.cy < 0) {
         short var3 = -180;
      }

      Math.sqrt((this.trz - this.z + this.cz) * (this.trz - this.z + this.cz) + (this.trx - this.x - this.cx) * (this.trx - this.x - this.cx));
      if (this.cpflik) {
         this.cpflik = false;
      } else {
         this.cpflik = true;
      }
   }

   public void setsky(int i, int i_58_, int i_59_) {
      this.csky[0] = (int)(i + i * (this.snap[0] / 100.0F));
      if (this.csky[0] > 255) {
         this.csky[0] = 255;
      }

      if (this.csky[0] < 0) {
         this.csky[0] = 0;
      }

      this.csky[1] = (int)(i_58_ + i_58_ * (this.snap[1] / 100.0F));
      if (this.csky[1] > 255) {
         this.csky[1] = 255;
      }

      if (this.csky[1] < 0) {
         this.csky[1] = 0;
      }

      this.csky[2] = (int)(i_59_ + i_59_ * (this.snap[2] / 100.0F));
      if (this.csky[2] > 255) {
         this.csky[2] = 255;
      }

      if (this.csky[2] < 0) {
         this.csky[2] = 0;
      }

      float[] fs = new float[3];
      Color.RGBtoHSB(this.csky[0], this.csky[1], this.csky[2], fs);
      if (fs[2] < 0.6) {
         this.darksky = true;
      } else {
         this.darksky = false;
      }
   }

   public void fadfrom(int i) {
      int i_60_ = 0;

      do {
         this.fade[i_60_] = i * (i_60_ + 1);
      } while (++i_60_ < 8);
   }

   public void follow(ContO conto, int i, int i_61_) {
      this.zy = 10;
      int i_62_ = 2 + (180 - Math.abs(this.bcxz)) / 4;
      if (i_62_ > 20) {
         i_62_ = 20;
      }

      if (i_61_ != 0) {
         if (i_61_ == 1) {
            if (this.bcxz < 180) {
               this.bcxz += i_62_;
            }

            if (this.bcxz > 180) {
               this.bcxz = 180;
            }
         }

         if (i_61_ == -1) {
            if (this.bcxz > -180) {
               this.bcxz -= i_62_;
            }

            if (this.bcxz < -180) {
               this.bcxz = -180;
            }
         }
      } else if (Math.abs(this.bcxz) > i_62_) {
         if (this.bcxz > 0) {
            this.bcxz -= i_62_;
         } else {
            this.bcxz += i_62_;
         }
      } else if (this.bcxz != 0) {
         this.bcxz = 0;
      }

      i += this.bcxz;
      this.xz = -i;
      this.x = conto.x - this.cx + (int)(-(conto.z - 800 - conto.z) * this.sin(i));
      this.z = conto.z - this.cz + (int)((conto.z - 800 - conto.z) * this.cos(i));
      this.y = conto.y - 250 - this.cy;
      if (this.trns != 1) {
         this.trns = 1;
      }
   }

   public void newpolys(int i, int i_63_, int i_64_, int i_65_, Trackers trackers) {
      this.nrw = i_63_ / 1200 + 1;
      this.ncl = i_65_ / 1200 + 1;
      this.sgpx = i;
      this.sgpz = i_64_;
      int i_66_ = 0;
      int i_67_ = 0;

      for (int i_68_ = 0; i_68_ < this.nrw * this.ncl; i_68_++) {
         this.cgpx[i_68_] = i + i_66_ * 1200 + (int)(Math.random() * 1000.0 - 500.0);
         this.cgpz[i_68_] = i_64_ + i_67_ * 1200 + (int)(Math.random() * 1000.0 - 500.0);

         for (int i_69_ = 0; i_69_ < trackers.nt; i_69_++) {
            if (trackers.zy[i_69_] == 0 && trackers.xy[i_69_] == 0) {
               if (trackers.radx[i_69_] < trackers.radz[i_69_] && Math.abs(this.cgpz[i_68_] - trackers.z[i_69_]) < trackers.radz[i_69_]) {
                  while (Math.abs(this.cgpx[i_68_] - trackers.x[i_69_]) < trackers.radx[i_69_]) {
                     this.cgpx[i_68_] = (int)(this.cgpx[i_68_] + (Math.random() * trackers.radx[i_69_] * 2.0 - trackers.radx[i_69_]));
                  }
               }

               if (trackers.radz[i_69_] < trackers.radx[i_69_] && Math.abs(this.cgpx[i_68_] - trackers.x[i_69_]) < trackers.radx[i_69_]) {
                  while (Math.abs(this.cgpz[i_68_] - trackers.z[i_69_]) < trackers.radz[i_69_]) {
                     this.cgpz[i_68_] = (int)(this.cgpz[i_68_] + (Math.random() * trackers.radz[i_69_] * 2.0 - trackers.radz[i_69_]));
                  }
               }
            }
         }

         if (++i_66_ == this.nrw) {
            i_66_ = 0;
            i_67_++;
         }
      }

      for (int i_70_ = 0; i_70_ < this.nrw * this.ncl; i_70_++) {
         this.ogpx[i_70_][0] = 0;
         this.ogpz[i_70_][0] = (int)(100.0 + Math.random() * 600.0);
         this.ogpx[i_70_][1] = (int)((100.0 + Math.random() * 600.0) * 0.7071);
         this.ogpz[i_70_][1] = this.ogpx[i_70_][1];
         this.ogpx[i_70_][2] = (int)(100.0 + Math.random() * 600.0);
         this.ogpz[i_70_][2] = 0;
         this.ogpx[i_70_][3] = (int)((100.0 + Math.random() * 600.0) * 0.7071);
         this.ogpz[i_70_][3] = -this.ogpx[i_70_][3];
         this.ogpx[i_70_][4] = 0;
         this.ogpz[i_70_][4] = -((int)(100.0 + Math.random() * 600.0));
         this.ogpx[i_70_][5] = -((int)((100.0 + Math.random() * 600.0) * 0.7071));
         this.ogpz[i_70_][5] = this.ogpx[i_70_][5];
         this.ogpx[i_70_][6] = -((int)(100.0 + Math.random() * 600.0));
         this.ogpz[i_70_][6] = 0;
         this.ogpx[i_70_][7] = -((int)((100.0 + Math.random() * 600.0) * 0.7071));
         this.ogpz[i_70_][7] = -this.ogpx[i_70_][7];
      }
   }

   public void transaround(ContO conto, ContO conto_71_, int i) {
      if (this.flex != 0) {
         this.flex = 0;
      }

      int i_72_ = (conto.x * (20 - i) + conto_71_.x * i) / 20;
      int i_73_ = (conto.y * (20 - i) + conto_71_.y * i) / 20;
      int i_74_ = (conto.z * (20 - i) + conto_71_.z * i) / 20;
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

      int i_75_ = 500 + this.adv;
      if (i_75_ < 1000) {
         i_75_ = 1000;
      }

      this.y = i_73_ - this.adv;
      if (this.y > 10) {
         this.vert = false;
      }

      this.x = i_72_ + (int)((i_72_ - i_75_ - i_72_) * this.cos(this.vxz));
      this.z = i_74_ + (int)((i_72_ - i_75_ - i_72_) * this.sin(this.vxz));
      this.vxz += 2;
      int i_76_ = 0;
      int i_77_ = this.y;
      if (i_77_ > 0) {
         i_77_ = 0;
      }

      if (i_73_ - i_77_ - this.cy < 0) {
         i_76_ = -180;
      }

      int i_78_ = (int)Math.sqrt((i_74_ - this.z + this.cz) * (i_74_ - this.z + this.cz) + (i_72_ - this.x - this.cx) * (i_72_ - this.x - this.cx));
      int i_79_ = (int)(90 + i_76_ - Math.atan((double)i_78_ / (i_73_ - i_77_ - this.cy)) / (Math.PI / 180.0));
      this.xz = -this.vxz + 90;
      this.zy = this.zy + (i_79_ - this.zy) / 10;
      if (this.trns != 5) {
         this.trns = 5;
      }
   }

   public float cos(int i) {
      while (i >= 360) {
         i -= 360;
      }

      while (i < 0) {
         i += 360;
      }

      return this.tcos[i];
   }
}
