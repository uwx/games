import java.awt.Color;
import java.awt.Graphics;

public class Medium {
   int focus_point;
   int ground;
   int skyline;
   int[] fade = new int[]{3000, 6000, 9000, 12000, 15000, 18000, 21000, 24000};
   int[] csky = new int[]{217, 224, 255};
   int[] cgrnd = new int[]{205, 200, 200};
   int[] cfade = new int[]{255, 220, 220};
   int[] snap;
   int origfade;
   int flex;
   boolean trk;
   boolean crs;
   int cx;
   int cy;
   int cz;
   int xz;
   int zy;
   int x;
   int y;
   int z;
   int w;
   int h;
   int nsp;
   int[] spx;
   int[] spz;
   int[] sprad;
   boolean td;
   int vxz;
   int adv;
   boolean vert;
   int trns;
   float[] tcos;
   float[] tsin;
   int cntrn;
   boolean[] diup;
   int[] rand;
   int trn;
   int hit;
   int ptr;
   int ptcnt;
   int nrnd;
   long trx;
   long trz;

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
         this.cntrn--;
      }

      int j = 0;

      do {
         if (this.diup[j]) {
            this.rand[j]++;
            if (this.rand[j] == 10) {
               this.rand[j] = 0;
            }
         } else {
            this.rand[j]--;
            if (this.rand[j] == -1) {
               this.rand[j] = 9;
            }
         }
      } while (++j < 3);

      this.trn++;
      if (this.trn == 3) {
         this.trn = 0;
      }

      return this.rand[this.trn] / 10.0F;
   }

   public int ys(int i, int j) {
      if (j < 10) {
         j = 10;
      }

      return (j - this.focus_point) * (this.cy - i) / j + i;
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
      this.focus_point = 400;
      this.ground = 250;
      this.skyline = -300;
      this.snap = new int[3];
      this.origfade = 3000;
      this.flex = 0;
      this.trk = false;
      this.crs = false;
      this.cx = 275;
      this.cy = 200;
      this.cz = 50;
      this.xz = 0;
      this.zy = 0;
      this.x = 0;
      this.y = 0;
      this.z = 0;
      this.w = 550;
      this.h = 400;
      this.nsp = 0;
      this.spx = new int[5];
      this.spz = new int[5];
      this.sprad = new int[5];
      this.td = false;
      this.vxz = 180;
      this.adv = 500;
      this.vert = false;
      this.trns = 1;
      this.tcos = new float[360];
      this.tsin = new float[360];
      this.cntrn = 0;
      this.diup = new boolean[3];
      this.rand = new int[3];
      this.trn = 0;
      this.hit = 60000;
      this.ptr = 0;
      this.ptcnt = -10;
      this.nrnd = 0;
      this.trx = 0L;
      this.trz = 0L;
      int i = 0;

      do {
         this.tcos[i] = (float)Math.cos(i * (Math.PI / 180.0));
      } while (++i < 360);

      i = 0;

      do {
         this.tsin[i] = (float)Math.sin(i * (Math.PI / 180.0));
      } while (++i < 360);
   }

   public void setfade(int i, int j, int k) {
      this.cfade[0] = (int)(i + i * (this.snap[0] / 100.0F));
      if (this.cfade[0] > 255) {
         this.cfade[0] = 255;
      }

      if (this.cfade[0] < 0) {
         this.cfade[0] = 0;
      }

      this.cfade[1] = (int)(j + j * (this.snap[1] / 100.0F));
      if (this.cfade[1] > 255) {
         this.cfade[1] = 255;
      }

      if (this.cfade[1] < 0) {
         this.cfade[1] = 0;
      }

      this.cfade[2] = (int)(k + k * (this.snap[2] / 100.0F));
      if (this.cfade[2] > 255) {
         this.cfade[2] = 255;
      }

      if (this.cfade[2] < 0) {
         this.cfade[2] = 0;
      }
   }

   public void d(Graphics g) {
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
      int[] ai = new int[4];
      int[] ai1 = new int[4];
      int i = this.cgrnd[0];
      int j = this.cgrnd[1];
      int k = this.cgrnd[2];
      int l = this.h;
      int i1 = 0;

      do {
         int j1 = this.fade[i1];
         int l1 = this.ground;
         if (this.zy != 0) {
            l1 = this.cy + (int)((this.ground - this.cy) * this.cos(this.zy) - (this.fade[i1] - this.cz) * this.sin(this.zy));
            j1 = this.cz + (int)((this.ground - this.cy) * this.sin(this.zy) + (this.fade[i1] - this.cz) * this.cos(this.zy));
         }

         ai[0] = 0;
         ai1[0] = this.ys(l1, j1);
         if (ai1[0] < 0) {
            ai1[0] = 0;
         }

         ai[1] = 0;
         ai1[1] = l;
         ai[2] = this.w;
         ai1[2] = l;
         ai[3] = this.w;
         ai1[3] = ai1[0];
         l = ai1[0];
         if (i1 > 0) {
            i = (i * 3 + this.cfade[0]) / 4;
            j = (j * 3 + this.cfade[1]) / 4;
            k = (k * 3 + this.cfade[2]) / 4;
         }

         if (ai1[0] < this.h && ai1[1] > 0) {
            g.setColor(new Color(i, j, k));
            g.fillPolygon(ai, ai1, 4);
         }
      } while (++i1 < 8);

      i = this.csky[0];
      j = this.csky[1];
      k = this.csky[2];
      i1 = 0;
      if (this.flex == 2) {
         ai[0] = 200;
         ai1[0] = 45;
         ai[1] = 200;
         ai1[1] = 0;
         ai[2] = 350;
         ai1[2] = 0;
         ai[3] = 350;
         ai1[3] = 45;
         g.setColor(new Color(i, j, k));
         g.fillPolygon(ai, ai1, 4);
         i1 = 45;
      }

      int k1 = 0;

      do {
         int i2 = this.fade[k1];
         int j2 = this.skyline;
         if (this.zy != 0) {
            j2 = this.cy + (int)((this.skyline - this.cy) * this.cos(this.zy) - (this.fade[k1] - this.cz) * this.sin(this.zy));
            i2 = this.cz + (int)((this.skyline - this.cy) * this.sin(this.zy) + (this.fade[k1] - this.cz) * this.cos(this.zy));
         }

         ai[0] = 0;
         ai1[0] = this.ys(j2, i2);
         if (ai1[0] > this.h) {
            ai1[0] = this.h;
         }

         ai[1] = 0;
         ai1[1] = i1;
         ai[2] = this.w;
         ai1[2] = i1;
         ai[3] = this.w;
         ai1[3] = ai1[0];
         i1 = ai1[0];
         if (k1 > 0) {
            i = (i * 3 + this.cfade[0]) / 4;
            j = (j * 3 + this.cfade[1]) / 4;
            k = (k * 3 + this.cfade[2]) / 4;
         }

         if (ai1[0] > 0 && ai1[1] < this.h) {
            g.setColor(new Color(i, j, k));
            g.fillPolygon(ai, ai1, 4);
         }
      } while (++k1 < 8);

      ai[0] = 0;
      ai1[0] = i1;
      ai[1] = 0;
      ai1[1] = l;
      ai[2] = this.w;
      ai1[2] = l;
      ai[3] = this.w;
      ai1[3] = i1;
      if (ai1[0] < this.h && ai1[1] > 0) {
         g.setColor(new Color(this.cfade[0], this.cfade[1], this.cfade[2]));
         g.fillPolygon(ai, ai1, 4);
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

      char c = '\u0000';
      if (conto.x - this.x - this.cx > 0) {
         c = '´';
      }

      int j = -((int)('Z' + c + Math.atan((double)(conto.z - this.z) / (conto.x - this.x - this.cx)) / (Math.PI / 180.0)));
      c = '\u0000';
      if (conto.y - this.y - this.cy < 0) {
         c = 'ｌ';
      }

      int k = (int)Math.sqrt((conto.z - this.z) * (conto.z - this.z) + (conto.x - this.x - this.cx) * (conto.x - this.x - this.cx));
      int l = (int)('Z' + c - Math.atan((double)k / (conto.y - this.y - this.cy)) / (Math.PI / 180.0));
      this.xz = this.xz + (j - this.xz) / this.trns;
      if (this.trns != 1) {
         this.trns--;
      }

      this.zy = this.zy + (l - this.zy) / 5;
      if ((int)Math.sqrt(
            (conto.z - this.z) * (conto.z - this.z)
               + (conto.x - this.x - this.cx) * (conto.x - this.x - this.cx)
               + (conto.y - this.y - this.cy) * (conto.y - this.y - this.cy)
         )
         > 6000) {
         this.td = true;
      }
   }

   public void setsnap(int i, int j, int k) {
      this.snap[0] = i;
      this.snap[1] = j;
      this.snap[2] = k;
   }

   public void around(ContO conto, boolean flag) {
      if (this.flex != 0) {
         this.flex = 0;
      }

      if (!flag) {
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
         this.adv -= 20;
      }

      int i = 500 + this.adv;
      if (i < 1000) {
         i = 1000;
      }

      this.y = conto.y - this.adv;
      if (this.y > 10) {
         this.vert = false;
      }

      this.x = conto.x + (int)((conto.x - i - conto.x) * this.cos(this.vxz));
      this.z = conto.z + (int)((conto.x - i - conto.x) * this.sin(this.vxz));
      if (!flag) {
         this.vxz += 2;
      } else {
         this.vxz += 4;
      }

      char c = 0;
      int j = this.y;
      if (j > 0) {
         j = 0;
      }

      if (conto.y - j - this.cy < 0) {
         c = 'ｌ';
      }

      int k = (int)Math.sqrt((conto.z - this.z + this.cz) * (conto.z - this.z + this.cz) + (conto.x - this.x - this.cx) * (conto.x - this.x - this.cx));
      int l = (int)('Z' + c - Math.atan((double)k / (conto.y - j - this.cy)) / (Math.PI / 180.0));
      this.xz = -this.vxz + 90;
      if (flag) {
         l -= 15;
      }

      this.zy = this.zy + (l - this.zy) / 10;
      if (this.trns != 5) {
         this.trns = 5;
      }
   }

   public void setgrnd(int i, int j, int k) {
      this.cgrnd[0] = (int)(i + i * (this.snap[0] / 100.0F));
      if (this.cgrnd[0] > 255) {
         this.cgrnd[0] = 255;
      }

      if (this.cgrnd[0] < 0) {
         this.cgrnd[0] = 0;
      }

      this.cgrnd[1] = (int)(j + j * (this.snap[1] / 100.0F));
      if (this.cgrnd[1] > 255) {
         this.cgrnd[1] = 255;
      }

      if (this.cgrnd[1] < 0) {
         this.cgrnd[1] = 0;
      }

      this.cgrnd[2] = (int)(k + k * (this.snap[2] / 100.0F));
      if (this.cgrnd[2] > 255) {
         this.cgrnd[2] = 255;
      }

      if (this.cgrnd[2] < 0) {
         this.cgrnd[2] = 0;
      }
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

   public void addsp(int i, int j, int k) {
      if (this.nsp != 5) {
         this.spx[this.nsp] = i;
         this.spz[this.nsp] = j;
         this.sprad[this.nsp] = k;
         this.nsp++;
      }
   }

   public void aroundtrack(CheckPoints checkpoints) {
      if (this.flex != 0) {
         this.flex = 0;
      }

      this.y = -this.hit;
      this.x = this.cx + (int)this.trx + (int)(12000.0F * this.cos(this.vxz));
      this.z = (int)this.trz + (int)(12000.0F * this.sin(this.vxz));
      this.hit -= 3000;
      if (this.hit < 5000) {
         this.hit = 5000;
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

      this.vxz += 2;
      if (this.vxz > 360) {
         this.vxz -= 360;
      }

      this.xz = -this.vxz - 90;
      char c = 0;
      if (-this.y - this.cy < 0) {
         c = 'ｌ';
      }

      int i = (int)Math.sqrt((this.trz - this.z + this.cz) * (this.trz - this.z + this.cz) + (this.trx - this.x - this.cx) * (this.trx - this.x - this.cx));
      if (this.zy >= 30 || this.hit == 57000) {
         this.zy = (int)('Z' + c - Math.atan((double)i / (-this.y - this.cy)) / (Math.PI / 180.0));
      } else if (this.zy > 9) {
         this.zy--;
      } else {
         this.zy = 9;
      }
   }

   public void setsky(int i, int j, int k) {
      this.csky[0] = (int)(i + i * (this.snap[0] / 100.0F));
      if (this.csky[0] > 255) {
         this.csky[0] = 255;
      }

      if (this.csky[0] < 0) {
         this.csky[0] = 0;
      }

      this.csky[1] = (int)(j + j * (this.snap[1] / 100.0F));
      if (this.csky[1] > 255) {
         this.csky[1] = 255;
      }

      if (this.csky[1] < 0) {
         this.csky[1] = 0;
      }

      this.csky[2] = (int)(k + k * (this.snap[2] / 100.0F));
      if (this.csky[2] > 255) {
         this.csky[2] = 255;
      }

      if (this.csky[2] < 0) {
         this.csky[2] = 0;
      }
   }

   public void fadfrom(int i) {
      int j = 0;

      do {
         this.fade[j] = i * (j + 1);
      } while (++j < 8);
   }

   public void follow(ContO conto, int i) {
      this.zy = 10;
      this.xz = -i;
      this.x = conto.x - this.cx + (int)(-(conto.z - 800 - conto.z) * this.sin(i));
      this.z = conto.z - this.cz + (int)((conto.z - 800 - conto.z) * this.cos(i));
      this.y = conto.y - 250 - this.cy;
      if (this.trns != 1) {
         this.trns = 1;
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
