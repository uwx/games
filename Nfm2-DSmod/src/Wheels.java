public class Wheels {
   int ground;
   int mast;
   int[] rc = new int[]{120, 120, 120};
   float size = 2.0F;
   float depth = 3.0F;

   public Wheels() {
      this.ground = 0;
      this.mast = 0;
   }

   public void setrims(int i, int j, int k, int l, int i1) {
      this.rc[0] = i;
      this.rc[1] = j;
      this.rc[2] = k;
      this.size = l / 10.0F;
      this.depth = i1 / 10.0F;
   }

   public void make(Medium medium, Trackers trackers, Plane[] aplane, int i, int j, int k, int l, int i1, int j1, int k1, int l1) {
      int[] ai = new int[16];
      int[] ai1 = new int[16];
      int[] ai2 = new int[16];
      int[] ai3 = new int[]{45, 45, 45};
      int i2 = 0;
      float f = j1 / 10.0F;
      float f1 = k1 / 10.0F;
      if (i1 == 11) {
         i2 = (int)(j + 4.0F * f);
      }

      byte byte0 = -1;
      if (j < 0) {
         byte0 = 1;
      }

      int j2 = 0;

      do {
         ai[j2] = (int)(j - 4.0F * f);
      } while (++j2 < 16);

      ai1[0] = (int)(k - 12.0F * f1);
      ai2[0] = (int)(l + 5.0F * f1);
      ai1[1] = (int)(k - 12.0F * f1);
      ai2[1] = (int)(l - 5.0F * f1);
      ai1[2] = (int)(k - 5.0F * f1);
      ai2[2] = (int)(l - 12.0F * f1);
      ai1[3] = (int)(k + 5.0F * f1);
      ai2[3] = (int)(l - 12.0F * f1);
      ai1[4] = (int)(k + 12.0F * f1);
      ai2[4] = (int)(l - 5.0F * f1);
      ai1[5] = (int)(k + 12.0F * f1);
      ai2[5] = (int)(l + 5.0F * f1);
      ai1[6] = (int)(k + 5.0F * f1);
      ai2[6] = (int)(l + 12.0F * f1);
      ai1[7] = (int)(k - 5.0F * f1);
      ai2[7] = (int)(l + 12.0F * f1);
      ai1[8] = k;
      ai2[8] = (int)(l + 10.0F * this.size);
      ai1[9] = (int)(k + 8.66 * this.size);
      ai2[9] = (int)(l + 5.0F * this.size);
      ai1[10] = (int)(k + 8.66 * this.size);
      ai2[10] = (int)(l - 5.0F * this.size);
      ai1[11] = k;
      ai2[11] = (int)(l - 10.0F * this.size);
      ai1[12] = (int)(k - 8.66 * this.size);
      ai2[12] = (int)(l - 5.0F * this.size);
      ai1[13] = (int)(k - 8.66 * this.size);
      ai2[13] = (int)(l + 5.0F * this.size);
      ai1[14] = k;
      ai2[14] = (int)(l + 10.0F * this.size);
      ai1[15] = (int)(k - 5.0F * f1);
      ai2[15] = (int)(l + 12.0F * f1);
      aplane[i] = new Plane(medium, trackers, ai, ai2, ai1, 16, ai3, false, l1, 0, i2, k, l, 7, 0, false, 0);
      this.mast++;
      aplane[i].master = this.mast;
      i++;
      ai[2] = (int)(j - this.depth * f);
      ai1[2] = k;
      ai2[2] = l;
      int var36 = -16;
      if (l1 == 21) {
         var36 = -17;
      }

      ai1[0] = k;
      ai2[0] = (int)(l + 10.0F * this.size);
      ai1[1] = (int)(k + 8.66 * this.size);
      ai2[1] = (int)(l + 5.0F * this.size);
      aplane[i] = new Plane(medium, trackers, ai, ai2, ai1, 3, this.rc, false, var36, 0, i2, k, l, 7, 0, false, 0);
      i++;
      ai1[0] = (int)(k + 8.66 * this.size);
      ai2[0] = (int)(l + 5.0F * this.size);
      ai1[1] = (int)(k + 8.66 * this.size);
      ai2[1] = (int)(l - 5.0F * this.size);
      aplane[i] = new Plane(medium, trackers, ai, ai2, ai1, 3, this.rc, false, var36, 0, i2, k, l, 7, 0, false, 0);
      i++;
      ai1[0] = (int)(k + 8.66 * this.size);
      ai2[0] = (int)(l - 5.0F * this.size);
      ai1[1] = k;
      ai2[1] = (int)(l - 10.0F * this.size);
      aplane[i] = new Plane(medium, trackers, ai, ai2, ai1, 3, this.rc, false, var36, 0, i2, k, l, 7, 0, false, 0);
      i++;
      ai1[0] = k;
      ai2[0] = (int)(l - 10.0F * this.size);
      ai1[1] = (int)(k - 8.66 * this.size);
      ai2[1] = (int)(l - 5.0F * this.size);
      aplane[i] = new Plane(medium, trackers, ai, ai2, ai1, 3, this.rc, false, var36, 0, i2, k, l, 7, 0, false, 0);
      i++;
      ai1[0] = (int)(k - 8.66 * this.size);
      ai2[0] = (int)(l - 5.0F * this.size);
      ai1[1] = (int)(k - 8.66 * this.size);
      ai2[1] = (int)(l + 5.0F * this.size);
      aplane[i] = new Plane(medium, trackers, ai, ai2, ai1, 3, this.rc, false, var36, 0, i2, k, l, 7, 0, false, 0);
      i++;
      ai1[0] = (int)(k - 8.66 * this.size);
      ai2[0] = (int)(l + 5.0F * this.size);
      ai1[1] = k;
      ai2[1] = (int)(l + 10.0F * this.size);
      aplane[i] = new Plane(medium, trackers, ai, ai2, ai1, 3, this.rc, false, var36, 0, i2, k, l, 7, 0, false, 0);
      i++;
      ai[0] = (int)(j - 4.0F * f);
      ai1[0] = (int)(k - 12.0F * f1);
      ai2[0] = (int)(l + 5.0F * f1);
      ai[1] = (int)(j - 4.0F * f);
      ai1[1] = (int)(k - 12.0F * f1);
      ai2[1] = (int)(l - 5.0F * f1);
      ai[2] = (int)(j + 4.0F * f);
      ai1[2] = (int)(k - 12.0F * f1);
      ai2[2] = (int)(l - 5.0F * f1);
      ai[3] = (int)(j + 4.0F * f);
      ai1[3] = (int)(k - 12.0F * f1);
      ai2[3] = (int)(l + 5.0F * f1);
      aplane[i] = new Plane(medium, trackers, ai, ai2, ai1, 4, ai3, false, l1, -1 * byte0, i2, k, l, 7, 0, false, 0);
      i++;
      ai[0] = (int)(j - 4.0F * f);
      ai1[0] = (int)(k - 5.0F * f1);
      ai2[0] = (int)(l - 12.0F * f1);
      ai[1] = (int)(j - 4.0F * f);
      ai1[1] = (int)(k - 12.0F * f1);
      ai2[1] = (int)(l - 5.0F * f1);
      ai[2] = (int)(j + 4.0F * f);
      ai1[2] = (int)(k - 12.0F * f1);
      ai2[2] = (int)(l - 5.0F * f1);
      ai[3] = (int)(j + 4.0F * f);
      ai1[3] = (int)(k - 5.0F * f1);
      ai2[3] = (int)(l - 12.0F * f1);
      aplane[i] = new Plane(medium, trackers, ai, ai2, ai1, 4, ai3, false, l1, 1 * byte0, i2, k, l, 7, 0, false, 0);
      i++;
      ai[0] = (int)(j - 4.0F * f);
      ai1[0] = (int)(k - 5.0F * f1);
      ai2[0] = (int)(l - 12.0F * f1);
      ai[1] = (int)(j - 4.0F * f);
      ai1[1] = (int)(k + 5.0F * f1);
      ai2[1] = (int)(l - 12.0F * f1);
      ai[2] = (int)(j + 4.0F * f);
      ai1[2] = (int)(k + 5.0F * f1);
      ai2[2] = (int)(l - 12.0F * f1);
      ai[3] = (int)(j + 4.0F * f);
      ai1[3] = (int)(k - 5.0F * f1);
      ai2[3] = (int)(l - 12.0F * f1);
      aplane[i] = new Plane(medium, trackers, ai, ai2, ai1, 4, ai3, false, l1, -1 * byte0, i2, k, l, 7, 0, false, 0);
      i++;
      ai[0] = (int)(j - 4.0F * f);
      ai1[0] = (int)(k + 12.0F * f1);
      ai2[0] = (int)(l - 5.0F * f1);
      ai[1] = (int)(j - 4.0F * f);
      ai1[1] = (int)(k + 5.0F * f1);
      ai2[1] = (int)(l - 12.0F * f1);
      ai[2] = (int)(j + 4.0F * f);
      ai1[2] = (int)(k + 5.0F * f1);
      ai2[2] = (int)(l - 12.0F * f1);
      ai[3] = (int)(j + 4.0F * f);
      ai1[3] = (int)(k + 12.0F * f1);
      ai2[3] = (int)(l - 5.0F * f1);
      aplane[i] = new Plane(medium, trackers, ai, ai2, ai1, 4, ai3, false, l1, 1 * byte0, i2, k, l, 7, 0, false, 0);
      i++;
      ai[0] = (int)(j - 4.0F * f);
      ai1[0] = (int)(k + 12.0F * f1);
      ai2[0] = (int)(l - 5.0F * f1);
      ai[1] = (int)(j - 4.0F * f);
      ai1[1] = (int)(k + 12.0F * f1);
      ai2[1] = (int)(l + 5.0F * f1);
      ai[2] = (int)(j + 4.0F * f);
      ai1[2] = (int)(k + 12.0F * f1);
      ai2[2] = (int)(l + 5.0F * f1);
      ai[3] = (int)(j + 4.0F * f);
      ai1[3] = (int)(k + 12.0F * f1);
      ai2[3] = (int)(l - 5.0F * f1);
      aplane[i] = new Plane(medium, trackers, ai, ai2, ai1, 4, ai3, false, l1, -1 * byte0, i2, k, l, 7, 0, false, 0);
      i++;
      if (this.ground < (int)(k + 12.0F * f1 + 1.0F)) {
         this.ground = (int)(k + 12.0F * f1 + 1.0F);
      }

      ai[0] = (int)(j - 4.0F * f);
      ai1[0] = (int)(k + 5.0F * f1);
      ai2[0] = (int)(l + 12.0F * f1);
      ai[1] = (int)(j - 4.0F * f);
      ai1[1] = (int)(k + 12.0F * f1);
      ai2[1] = (int)(l + 5.0F * f1);
      ai[2] = (int)(j + 4.0F * f);
      ai1[2] = (int)(k + 12.0F * f1);
      ai2[2] = (int)(l + 5.0F * f1);
      ai[3] = (int)(j + 4.0F * f);
      ai1[3] = (int)(k + 5.0F * f1);
      ai2[3] = (int)(l + 12.0F * f1);
      aplane[i] = new Plane(medium, trackers, ai, ai2, ai1, 4, ai3, false, l1, 1 * byte0, i2, k, l, 7, 0, false, 0);
      i++;
      ai[0] = (int)(j - 4.0F * f);
      ai1[0] = (int)(k + 5.0F * f1);
      ai2[0] = (int)(l + 12.0F * f1);
      ai[1] = (int)(j - 4.0F * f);
      ai1[1] = (int)(k - 5.0F * f1);
      ai2[1] = (int)(l + 12.0F * f1);
      ai[2] = (int)(j + 4.0F * f);
      ai1[2] = (int)(k - 5.0F * f1);
      ai2[2] = (int)(l + 12.0F * f1);
      ai[3] = (int)(j + 4.0F * f);
      ai1[3] = (int)(k + 5.0F * f1);
      ai2[3] = (int)(l + 12.0F * f1);
      aplane[i] = new Plane(medium, trackers, ai, ai2, ai1, 4, ai3, false, l1, -1 * byte0, i2, k, l, 7, 0, false, 0);
      i++;
      ai[0] = (int)(j - 4.0F * f);
      ai1[0] = (int)(k - 12.0F * f1);
      ai2[0] = (int)(l + 5.0F * f1);
      ai[1] = (int)(j - 4.0F * f);
      ai1[1] = (int)(k - 5.0F * f1);
      ai2[1] = (int)(l + 12.0F * f1);
      ai[2] = (int)(j + 4.0F * f);
      ai1[2] = (int)(k - 5.0F * f1);
      ai2[2] = (int)(l + 12.0F * f1);
      ai[3] = (int)(j + 4.0F * f);
      ai1[3] = (int)(k - 12.0F * f1);
      ai2[3] = (int)(l + 5.0F * f1);
      aplane[i] = new Plane(medium, trackers, ai, ai2, ai1, 4, ai3, false, l1, 1 * byte0, i2, k, l, 7, 0, false, 0);
      i++;
   }
}
