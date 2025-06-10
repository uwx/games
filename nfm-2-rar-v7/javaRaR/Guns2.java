
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;

class Guns2 {

 Mdm M;
 Path2D pth;
 int p;
 long spd[];
 double rads[];
 long dam[];

 Guns2(Mdm m) {
  spd = new long[4];
  rads = new double[4];
  dam = new long[4];
  M = m;
  spd[0] = 1250;
  rads[0] = 2;
  dam[0] = 250;
  spd[1] = 2000;
  rads[1] = 2.25;
  dam[1] = 150;
  spd[2] = 0;
  rads[2] = 20;
  dam[2] = 4000;
  spd[3] = 250;
  rads[3] = 2.5;
  dam[3] = 1000;
 }

 void dt(Graphics2D gs, double[] x0, double[] y0, double[] z0, double x, double y, double z, double xz, double zy, double xy, int n, long ht, double r, double g, double b) {
  int c;
  for (c = 0; c < n; c++) {
   if (ht == 0) {
    x0[c] += x - M.x;
    y0[c] += y - M.y;
    z0[c] += z - M.z;
   } else {
    x0[c] += (x - M.x) + (Math.random() * 50 - 25);
    y0[c] += (y - M.y) + (Math.random() * 50 - 25);
    z0[c] += (z - M.z) + (Math.random() * 50 - 25);
   }
  }
  M.rot(x0, y0, x - M.x, y - M.y, xy, n);
  M.rot(y0, z0, y - M.y, z - M.z, zy, n);
  M.rot(x0, z0, x - M.x, z - M.z, xz, n);
  M.rot(x0, z0, M.cx, M.cz, M.xz, n);
  M.rot(y0, z0, M.cy, M.cz, M.zy, n);
  double[] x1 = new double[n];
  double[] y1 = new double[n];
  boolean tf = false;
  for (c = 0; c < n; c++) {
   x1[c] = M.xs(x0[c], z0[c]);
   y1[c] = M.ys(y0[c], z0[c]);
   if (y1[c] > 0 && y1[c] < M.h && x1[c] > 0 && x1[c] < M.w && z0[c] > 10) {
    tf = true;
   }
  }
  if (tf) {
   if (ht != 0) {
    if (ht == 1) {
     r = 255;
     g = 235;
     b = 120;
    } else {
     r = 255;
     g = 220;
     b = 111;
    }
   }
   gs.setColor(new Color((int) Math.max(0, Math.min(r, 255)), (int) Math.max(0, Math.min(g, 255)), (int) Math.max(0, Math.min(b, 255))));
   pth = new Path2D.Double();
   pth.moveTo(x1[0], y1[0]);
   for (p = 0; p < n; p++) {
    pth.lineTo(x1[p], y1[p]);
   }
   pth.closePath();
   gs.fill(pth);
  }
 }

 void d(Graphics2D gs, int typ, double x, double y, double z, double xz, double zy, double xy, long ht) {
  int b = 8;
  double[] x0 = new double[b];
  double[] y0 = new double[b];
  double[] z0 = new double[b];
  double c = Math.random() * 255;
  if (typ == 0) {
   b = 3;
   x0[0] = (Math.random() * 15) - (Math.random() * 15);
   y0[0] = (Math.random() * 15) - (Math.random() * 15);
   z0[0] = (Math.random() * 15) - (Math.random() * 15);
   x0[1] = (Math.random() * 15) - (Math.random() * 15);
   y0[1] = (Math.random() * 15) - (Math.random() * 15);
   z0[1] = (Math.random() * 15) - (Math.random() * 15);
   x0[2] = (Math.random() * 15) - (Math.random() * 15);
   y0[2] = (Math.random() * 15) - (Math.random() * 15);
   z0[2] = (Math.random() * 15) - (Math.random() * 15);
   dt(gs, x0, y0, z0, x, y, z, xz, zy, xy, b, ht, 255, 255, 255);
   b = 3;
   x0[0] = (Math.random() * 15) - (Math.random() * 15);
   y0[0] = (Math.random() * 15) - (Math.random() * 15);
   z0[0] = (Math.random() * 15) - (Math.random() * 15);
   x0[1] = (Math.random() * 15) - (Math.random() * 15);
   y0[1] = (Math.random() * 15) - (Math.random() * 15);
   z0[1] = (Math.random() * 15) - (Math.random() * 15);
   x0[2] = (Math.random() * 15) - (Math.random() * 15);
   y0[2] = (Math.random() * 15) - (Math.random() * 15);
   z0[2] = (Math.random() * 15) - (Math.random() * 15);
   dt(gs, x0, y0, z0, x, y, z, xz, zy, xy, b, ht, 255, 255, 255);
   b = 3;
   x0[0] = (Math.random() * 15) - (Math.random() * 15);
   y0[0] = (Math.random() * 15) - (Math.random() * 15);
   z0[0] = (Math.random() * 15) - (Math.random() * 15);
   x0[1] = (Math.random() * 15) - (Math.random() * 15);
   y0[1] = (Math.random() * 15) - (Math.random() * 15);
   z0[1] = (Math.random() * 15) - (Math.random() * 15);
   x0[2] = (Math.random() * 15) - (Math.random() * 15);
   y0[2] = (Math.random() * 15) - (Math.random() * 15);
   z0[2] = (Math.random() * 15) - (Math.random() * 15);
   dt(gs, x0, y0, z0, x, y, z, xz, zy, xy, b, ht, 255, 255, 255);
  }
  if (typ == 1) {
   b = 4;
   x0[0] = 6;
   y0[0] = 0;
   z0[0] = 50;
   x0[1] = -6;
   y0[1] = 0;
   z0[1] = 50;
   x0[2] = -6;
   y0[2] = 0;
   z0[2] = -50;
   x0[3] = 6;
   y0[3] = 0;
   z0[3] = -50;
   dt(gs, x0, y0, z0, x, y, z, xz, zy, xy, b, ht, c, c, c);
   b = 4;
   x0[0] = 0;
   y0[0] = -3;
   z0[0] = 50;
   x0[1] = 0;
   y0[1] = 3;
   z0[1] = 50;
   x0[2] = 0;
   y0[2] = 3;
   z0[2] = -50;
   x0[3] = 0;
   y0[3] = -3;
   z0[3] = -50;
   dt(gs, x0, y0, z0, x, y, z, xz, zy, xy, b, ht, c, c, c);
  }
  if (typ == 2) {
   b = 8;
   x0[0] = 30;
   y0[0] = 0;
   z0[0] = 60;
   x0[1] = 60;
   y0[1] = 0;
   z0[1] = 30;
   x0[2] = 60;
   y0[2] = 0;
   z0[2] = -30;
   x0[3] = 30;
   y0[3] = 0;
   z0[3] = -60;
   x0[4] = -30;
   y0[4] = 0;
   z0[4] = -60;
   x0[5] = -60;
   y0[5] = 0;
   z0[5] = -30;
   x0[6] = -60;
   y0[6] = 0;
   z0[6] = 30;
   x0[7] = -30;
   y0[7] = 0;
   z0[7] = 60;
   dt(gs, x0, y0, z0, x, y, z, xz, zy, xy, b, ht, 50 + (M.snap[0] * .5), 50 + (M.snap[1] * .5), 50 + (M.snap[2] * .5));
   b = 8;
   x0[0] = 3;
   y0[0] = 0;
   z0[0] = 6;
   x0[1] = 6;
   y0[1] = 0;
   z0[1] = 3;
   x0[2] = 6;
   y0[2] = 0;
   z0[2] = -3;
   x0[3] = 3;
   y0[3] = 0;
   z0[3] = -6;
   x0[4] = -3;
   y0[4] = 0;
   z0[4] = -6;
   x0[5] = -6;
   y0[5] = 0;
   z0[5] = -3;
   x0[6] = -6;
   y0[6] = 0;
   z0[6] = 3;
   x0[7] = -3;
   y0[7] = 0;
   z0[7] = 6;
   if (M.mF > 8) {
    dt(gs, x0, y0, z0, x, y, z, xz, zy, xy, b, ht, 255, 255, 255);
   }
  }
  if (typ == 3) {
   b = 4;
   x0[0] = 0;
   y0[0] = -7;
   z0[0] = 21;
   x0[1] = 0;
   y0[1] = 7;
   z0[1] = 21;
   x0[2] = 0;
   y0[2] = 7;
   z0[2] = -80;
   x0[3] = 0;
   y0[3] = -7;
   z0[3] = -80;
   dt(gs, x0, y0, z0, x, y, z, xz, zy, xy, b, ht, 50, 50, 50);
   b = 4;
   x0[0] = -7;
   y0[0] = 0;
   z0[0] = 21;
   x0[1] = 7;
   y0[1] = 0;
   z0[1] = 21;
   x0[2] = 7;
   y0[2] = 0;
   z0[2] = -80;
   x0[3] = -7;
   y0[3] = 0;
   z0[3] = -80;
   dt(gs, x0, y0, z0, x, y, z, xz, zy, xy, b, ht, 50, 50, 50);
   b = 3;
   x0[0] = (Math.random() * 32) - (Math.random() * 32);
   y0[0] = (Math.random() * 32) - (Math.random() * 32);
   z0[0] = -100 + (Math.random() * 32) - (Math.random() * 32);
   x0[1] = 0;
   y0[1] = 8;
   z0[1] = -80;
   x0[2] = 0;
   y0[2] = -8;
   z0[2] = -80;
   dt(gs, x0, y0, z0, x, y, z, xz, zy, xy, b, ht, 255, 128 + (Math.random() * 100), Math.random() * 64);
   b = 3;
   x0[0] = (Math.random() * 32) - (Math.random() * 32);
   y0[0] = (Math.random() * 32) - (Math.random() * 32);
   z0[0] = -100 + (Math.random() * 32) - (Math.random() * 32);
   x0[1] = 8;
   y0[1] = 0;
   z0[1] = -80;
   x0[2] = -8;
   y0[2] = 0;
   z0[2] = -80;
   dt(gs, x0, y0, z0, x, y, z, xz, zy, xy, b, ht, 255, 128 + (Math.random() * 100), Math.random() * 64);
   b = 3;
   x0[0] = (Math.random() * 32) - (Math.random() * 32);
   y0[0] = (Math.random() * 32) - (Math.random() * 32);
   z0[0] = -100 + (Math.random() * 32) - (Math.random() * 32);
   x0[1] = 0;
   y0[1] = 8;
   z0[1] = -80;
   x0[2] = 0;
   y0[2] = -8;
   z0[2] = -80;
   dt(gs, x0, y0, z0, x, y, z, xz, zy, xy, b, ht, 255, 128 + (Math.random() * 100), Math.random() * 64);
   b = 3;
   x0[0] = (Math.random() * 32) - (Math.random() * 32);
   y0[0] = (Math.random() * 32) - (Math.random() * 32);
   z0[0] = -100 + (Math.random() * 32) - (Math.random() * 32);
   x0[1] = 8;
   y0[1] = 0;
   z0[1] = -80;
   x0[2] = -8;
   y0[2] = 0;
   z0[2] = -80;
   dt(gs, x0, y0, z0, x, y, z, xz, zy, xy, b, ht, 255, 128 + (Math.random() * 100), Math.random() * 64);
   b = 3;
   x0[0] = 0;
   y0[0] = 7;
   z0[0] = -21;
   x0[1] = 0;
   y0[1] = 7;
   z0[1] = -80;
   x0[2] = 0;
   y0[2] = 26;
   z0[2] = -80;
   dt(gs, x0, y0, z0, x, y, z, xz, zy, xy, b, ht, 200, 200, 200);
   b = 3;
   x0[0] = 7;
   y0[0] = 0;
   z0[0] = -21;
   x0[1] = 7;
   y0[1] = 0;
   z0[1] = -80;
   x0[2] = 26;
   y0[2] = 0;
   z0[2] = -80;
   dt(gs, x0, y0, z0, x, y, z, xz, zy, xy, b, ht, 200, 200, 200);
   b = 3;
   x0[0] = -7;
   y0[0] = 0;
   z0[0] = -21;
   x0[1] = -7;
   y0[1] = 0;
   z0[1] = -80;
   x0[2] = -26;
   y0[2] = 0;
   z0[2] = -80;
   dt(gs, x0, y0, z0, x, y, z, xz, zy, xy, b, ht, 200, 200, 200);
   b = 3;
   x0[0] = 0;
   y0[0] = -7;
   z0[0] = -21;
   x0[1] = 0;
   y0[1] = -7;
   z0[1] = -80;
   x0[2] = 0;
   y0[2] = -26;
   z0[2] = -80;
   dt(gs, x0, y0, z0, x, y, z, xz, zy, xy, b, ht, 200, 200, 200);
   b = 3;
   x0[0] = -7;
   y0[0] = 0;
   z0[0] = 21;
   x0[1] = 7;
   y0[1] = 0;
   z0[1] = 21;
   x0[2] = 0;
   y0[2] = 0;
   z0[2] = 80;
   dt(gs, x0, y0, z0, x, y, z, xz, zy, xy, b, ht, 200, 200, 200);
   b = 3;
   x0[0] = 0;
   y0[0] = -7;
   z0[0] = 21;
   x0[1] = 0;
   y0[1] = 7;
   z0[1] = 21;
   x0[2] = 0;
   y0[2] = 0;
   z0[2] = 80;
   dt(gs, x0, y0, z0, x, y, z, xz, zy, xy, b, ht, 200, 200, 200);
  }
 }
}
