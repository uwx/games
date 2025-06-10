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
   int[] pos = new int[]{4, 4, 4, 4, 4};
   int[] clear;
   int[] dested;
   int wasted;
   boolean haltall;
   int[] opx;
   int[] opz;
   int[] onscreen;

   public CheckPoints() {
      this.x = new int[140];
      this.z = new int[140];
      this.y = new int[140];
      this.typ = new int[140];
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
      this.clear = new int[5];
      this.dested = new int[5];
      this.wasted = 0;
      this.haltall = false;
      this.opx = new int[5];
      this.opz = new int[5];
      this.onscreen = new int[5];
   }

   public void checkstat(Madness[] amadness, ContO[] aconto) {
      if (!this.haltall) {
         int i = 0;

         do {
            this.pos[i] = 0;
            this.onscreen[i] = aconto[i].dist;
            this.opx[i] = aconto[i].x;
            this.opz[i] = aconto[i].z;
            if (this.dested[i] == 0) {
               this.clear[i] = amadness[i].clear;
            } else {
               this.clear[i] = -1;
            }
         } while (++i < 5);

         i = 0;

         do {
            for (int k = i + 1; k < 5; k++) {
               if (this.clear[i] != this.clear[k]) {
                  if (this.clear[i] < this.clear[k]) {
                     this.pos[i]++;
                  } else {
                     this.pos[k]++;
                  }
               } else {
                  int l = amadness[i].pcleared + 1;

                  while (this.typ[l] <= 0) {
                     if (++l == this.n) {
                        l = 0;
                     }
                  }

                  if (this.py(aconto[i].x / 100, this.x[l] / 100, aconto[i].z / 100, this.z[l] / 100)
                     > this.py(aconto[k].x / 100, this.x[l] / 100, aconto[k].z / 100, this.z[l] / 100)) {
                     this.pos[i]++;
                  } else {
                     this.pos[k]++;
                  }
               }
            }
         } while (++i < 5);
      }

      this.wasted = 0;
      int j = 1;

      do {
         if (amadness[j].dest) {
            this.wasted++;
         }
      } while (++j < 5);
   }

   public int py(int i, int j, int k, int l) {
      return (i - j) * (i - j) + (k - l) * (k - l);
   }
}
