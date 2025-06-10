public class Wheels {
   int ground = 0;
   int mast = 0;

   public void make(Medium medium, Trackers trackers, Plane[] aplane, int i, int j, int k, int l, int i1, int j1, int k1) {
      int[] ai = new int[8];
      int[] ai1 = new int[8];
      int[] ai2 = new int[8];
      int[] ai3 = new int[]{75, 75, 75};
      int l1 = 0;
      float f = j1 / 10.0F;
      float f1 = k1 / 10.0F;
      if (i1 == 11) {
         l1 = (int)(j + 4.0F * f);
      }

      byte byte0 = 1;
      if (Math.abs(j) == 73) {
         byte0 = -1;
      }

      int i2 = 0;

      do {
         ai[i2] = (int)(j - 4.0F * f);
      } while (++i2 < 8);

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
      aplane[i] = new Plane(medium, trackers, ai, ai2, ai1, 8, ai3, false, 0, l1, k, l, 7, 0, false);
      this.mast++;
      aplane[i].master = this.mast;
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
      aplane[i] = new Plane(medium, trackers, ai, ai2, ai1, 4, ai3, false, byte0, l1, k, l, 7, 0, false);
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
      aplane[i] = new Plane(medium, trackers, ai, ai2, ai1, 4, ai3, false, byte0, l1, k, l, 7, 0, false);
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
      aplane[i] = new Plane(medium, trackers, ai, ai2, ai1, 4, ai3, false, byte0, l1, k, l, 7, 0, false);
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
      aplane[i] = new Plane(medium, trackers, ai, ai2, ai1, 4, ai3, false, -1, l1, k, l, 7, 0, false);
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
      aplane[i] = new Plane(medium, trackers, ai, ai2, ai1, 4, ai3, false, -1, l1, k, l, 7, 0, false);
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
      aplane[i] = new Plane(medium, trackers, ai, ai2, ai1, 4, ai3, false, -1, l1, k, l, 7, 0, false);
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
      aplane[i] = new Plane(medium, trackers, ai, ai2, ai1, 4, ai3, false, byte0, l1, k, l, 7, 0, false);
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
      aplane[i] = new Plane(medium, trackers, ai, ai2, ai1, 4, ai3, false, byte0, l1, k, l, 7, 0, false);
      i++;
   }
}
