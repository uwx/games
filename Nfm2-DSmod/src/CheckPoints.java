public class CheckPoints {
   int[] x;
   int[] z;
   int[] y;
   int[] typ;
   int pcs;
   int nsp;
   int n;
   int[] fx;
   int[] fz;
   int[] fy;
   boolean[] roted;
   boolean[] special;
   int fn;
   int stage;
   int nlaps;
   String name;
   int[] pos = new int[]{6, 6, 6, 6, 6, 6, 6};
   int[] clear;
   int[] dested;
   int wasted;
   boolean haltall;
   int pcleared;
   int[] opx;
   int[] opz;
   int[] onscreen;
   int[] omxz;
   int catchfin;
   int postwo;

   public CheckPoints() {
      this.x = new int[10000];
      this.z = new int[10000];
      this.y = new int[10000];
      this.typ = new int[10000];
      this.pcs = 0;
      this.nsp = 0;
      this.n = 0;
      this.fx = new int[5];
      this.fz = new int[5];
      this.fy = new int[5];
      this.roted = new boolean[5];
      this.special = new boolean[5];
      this.fn = 0;
      this.stage = 1;
      this.nlaps = 0;
      this.name = "hogan rewish";
      this.clear = new int[7];
      this.dested = new int[7];
      this.wasted = 0;
      this.haltall = false;
      this.pcleared = 0;
      this.opx = new int[7];
      this.opz = new int[7];
      this.onscreen = new int[7];
      this.omxz = new int[7];
      this.catchfin = 0;
      this.postwo = 0;
   }

   public void checkstat(Madness[] amadness, ContO[] aconto, Record record) {
      if (!this.haltall) {
         this.pcleared = amadness[0].pcleared;
         int i = 0;

         do {
            this.pos[i] = 0;
            this.onscreen[i] = aconto[i].dist;
            this.opx[i] = aconto[i].x;
            this.opz[i] = aconto[i].z;
            this.omxz[i] = amadness[i].mxz;
            if (this.dested[i] == 0) {
               this.clear[i] = amadness[i].clear;
            } else {
               this.clear[i] = -1;
            }
         } while (++i < 7);

         i = 0;

         do {
            for (int l = i + 1; l < 7; l++) {
               if (this.clear[i] != this.clear[l]) {
                  if (this.clear[i] < this.clear[l]) {
                     this.pos[i]++;
                  } else {
                     this.pos[l]++;
                  }
               } else {
                  boolean flk = true;

                  int j1;
                  for (j1 = amadness[i].pcleared + 1; this.typ[j1] <= 0 && flk; flk = j1 < this.typ.length - 1) {
                     if (++j1 == this.n) {
                        j1 = 0;
                     }
                  }

                  if (this.py(aconto[i].x / 100, this.x[j1] / 100, aconto[i].z / 100, this.z[j1] / 100)
                     > this.py(aconto[l].x / 100, this.x[j1] / 100, aconto[l].z / 100, this.z[j1] / 100)) {
                     this.pos[i]++;
                  } else {
                     this.pos[l]++;
                  }
               }
            }
         } while (++i < 7);

         if (this.stage > 2) {
            int j = 0;

            do {
               if (this.clear[j] == this.nlaps * this.nsp && this.pos[j] == 0) {
                  if (j == 0) {
                     int i1 = 0;

                     do {
                        if (this.pos[i1] == 1) {
                           this.postwo = i1;
                        }
                     } while (++i1 < 7);

                     if (this.py(this.opx[0] / 100, this.opx[this.postwo] / 100, this.opz[0] / 100, this.opz[this.postwo] / 100) < 14000
                        && this.clear[0] - this.clear[this.postwo] == 1) {
                        this.catchfin = 30;
                     }
                  } else if (this.pos[0] == 1
                     && this.py(this.opx[0] / 100, this.opx[j] / 100, this.opz[0] / 100, this.opz[j] / 100) < 14000
                     && this.clear[j] - this.clear[0] == 1) {
                     this.catchfin = 30;
                     this.postwo = j;
                  }
               }
            } while (++j < 7);
         }
      }

      this.wasted = 0;
      int k = 1;

      do {
         if (amadness[k].dest) {
            this.wasted++;
         }
      } while (++k < 7);

      if (this.catchfin != 0) {
         this.catchfin--;
         if (this.catchfin == 0) {
            record.cotchinow(this.postwo);
            record.closefinish = this.pos[0] + 1;
         }
      }
   }

   public int py(int i, int j, int k, int l) {
      return (i - j) * (i - j) + (k - l) * (k - l);
   }
}
