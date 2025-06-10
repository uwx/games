
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;

class Exp {

 Mdm M;
 Path2D pth;
 int p;
 long rads[];
 long[] drtn;
 long dam[];

 Exp(Mdm m) {
  rads = new long[3];
  drtn = new long[3];
  dam = new long[3];
  M = m;
  rads[0] = 10;
  drtn[0] = 3;
  dam[0] = 250;
  rads[1] = 10;
  drtn[1] = 5;
  dam[1] = 250;
  rads[2] = 0;
  drtn[2] = 5;
  dam[2] = 0;
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
  int b = 4;
  double[] x0 = new double[b];
  double[] y0 = new double[b];
  double[] z0 = new double[b];
  if (typ <= 1) {
   b = 3;
   x0[0] = (Math.random() * 1500) - (Math.random() * 1500);
   y0[0] = (Math.random() * 1500) - (Math.random() * 1500);
   z0[0] = 0;
   x0[1] = (Math.random() * 1500) - (Math.random() * 1500);
   y0[1] = 0;
   z0[1] = (Math.random() * 1500) - (Math.random() * 1500);
   x0[2] = 0;
   y0[2] = (Math.random() * 1500) - (Math.random() * 1500);
   z0[2] = (Math.random() * 1500) - (Math.random() * 1500);
   dt(gs, x0, y0, z0, x, y, z, xz, zy, xy, b, ht, 255, 255, 200);
   b = 3;
   x0[0] = (Math.random() * 1500) - (Math.random() * 1500);
   y0[0] = (Math.random() * 1500) - (Math.random() * 1500);
   z0[0] = 0;
   x0[1] = (Math.random() * 1500) - (Math.random() * 1500);
   y0[1] = 0;
   z0[1] = (Math.random() * 1500) - (Math.random() * 1500);
   x0[2] = 0;
   y0[2] = (Math.random() * 1500) - (Math.random() * 1500);
   z0[2] = (Math.random() * 1500) - (Math.random() * 1500);
   dt(gs, x0, y0, z0, x, y, z, xz, zy, xy, b, ht, 255, 255, 200);
   b = 3;
   x0[0] = (Math.random() * 1500) - (Math.random() * 1500);
   y0[0] = (Math.random() * 1500) - (Math.random() * 1500);
   z0[0] = 0;
   x0[1] = (Math.random() * 1500) - (Math.random() * 1500);
   y0[1] = 0;
   z0[1] = (Math.random() * 1500) - (Math.random() * 1500);
   x0[2] = 0;
   y0[2] = (Math.random() * 1500) - (Math.random() * 1500);
   z0[2] = (Math.random() * 1500) - (Math.random() * 1500);
   dt(gs, x0, y0, z0, x, y, z, xz, zy, xy, b, ht, 255, 255, 200);
   b = 3;
   x0[0] = (Math.random() * 1500) - (Math.random() * 1500);
   y0[0] = (Math.random() * 1500) - (Math.random() * 1500);
   z0[0] = 0;
   x0[1] = (Math.random() * 1500) - (Math.random() * 1500);
   y0[1] = 0;
   z0[1] = (Math.random() * 1500) - (Math.random() * 1500);
   x0[2] = 0;
   y0[2] = (Math.random() * 1500) - (Math.random() * 1500);
   z0[2] = (Math.random() * 1500) - (Math.random() * 1500);
   dt(gs, x0, y0, z0, x, y, z, xz, zy, xy, b, ht, 255, 255, 200);
   b = 3;
   x0[0] = (Math.random() * 1500) - (Math.random() * 1500);
   y0[0] = (Math.random() * 1500) - (Math.random() * 1500);
   z0[0] = 0;
   x0[1] = (Math.random() * 1500) - (Math.random() * 1500);
   y0[1] = 0;
   z0[1] = (Math.random() * 1500) - (Math.random() * 1500);
   x0[2] = 0;
   y0[2] = (Math.random() * 1500) - (Math.random() * 1500);
   z0[2] = (Math.random() * 1500) - (Math.random() * 1500);
   dt(gs, x0, y0, z0, x, y, z, xz, zy, xy, b, ht, 255, 255, 200);
   b = 3;
   x0[0] = (Math.random() * 1500) - (Math.random() * 1500);
   y0[0] = (Math.random() * 1500) - (Math.random() * 1500);
   z0[0] = 0;
   x0[1] = (Math.random() * 1500) - (Math.random() * 1500);
   y0[1] = 0;
   z0[1] = (Math.random() * 1500) - (Math.random() * 1500);
   x0[2] = 0;
   y0[2] = (Math.random() * 1500) - (Math.random() * 1500);
   z0[2] = (Math.random() * 1500) - (Math.random() * 1500);
   dt(gs, x0, y0, z0, x, y, z, xz, zy, xy, b, ht, 255, 255, 200);
   b = 3;
   x0[0] = (Math.random() * 1500) - (Math.random() * 1500);
   y0[0] = (Math.random() * 1500) - (Math.random() * 1500);
   z0[0] = 0;
   x0[1] = (Math.random() * 1500) - (Math.random() * 1500);
   y0[1] = 0;
   z0[1] = (Math.random() * 1500) - (Math.random() * 1500);
   x0[2] = 0;
   y0[2] = (Math.random() * 1500) - (Math.random() * 1500);
   z0[2] = (Math.random() * 1500) - (Math.random() * 1500);
   dt(gs, x0, y0, z0, x, y, z, xz, zy, xy, b, ht, 255, 255, 200);
  }
  if (typ == 2) {
   b = 4;
   x0[0] = (Math.random() * 10000) - (Math.random() * 10000);
   y0[0] = (Math.random() * 10000) - (Math.random() * 10000);
   z0[0] = 0;
   x0[1] = (Math.random() * 10000) - (Math.random() * 10000);
   y0[1] = (Math.random() * 10000) - (Math.random() * 10000);
   z0[1] = 0;
   x0[2] = (Math.random() * 10000) - (Math.random() * 10000);
   y0[2] = (Math.random() * 10000) - (Math.random() * 10000);
   z0[2] = 0;
   x0[3] = (Math.random() * 10000) - (Math.random() * 10000);
   y0[3] = (Math.random() * 10000) - (Math.random() * 10000);
   z0[3] = 0;
   dt(gs, x0, y0, z0, x, y, z, xz, zy, xy, b, ht, 255, 255, 255);
   b = 4;
   x0[0] = (Math.random() * 10000) - (Math.random() * 10000);
   y0[0] = 0;
   z0[0] = (Math.random() * 10000) - (Math.random() * 10000);
   x0[1] = (Math.random() * 10000) - (Math.random() * 10000);
   y0[1] = 0;
   z0[1] = (Math.random() * 10000) - (Math.random() * 10000);
   x0[2] = (Math.random() * 10000) - (Math.random() * 10000);
   y0[2] = 0;
   z0[2] = (Math.random() * 10000) - (Math.random() * 10000);
   x0[3] = (Math.random() * 10000) - (Math.random() * 10000);
   y0[3] = 0;
   z0[3] = (Math.random() * 10000) - (Math.random() * 10000);
   dt(gs, x0, y0, z0, x, y, z, xz, zy, xy, b, ht, 255, 255, 255);
   b = 4;
   x0[0] = 0;
   y0[0] = (Math.random() * 10000) - (Math.random() * 10000);
   z0[0] = (Math.random() * 10000) - (Math.random() * 10000);
   x0[1] = 0;
   y0[1] = (Math.random() * 10000) - (Math.random() * 10000);
   z0[1] = (Math.random() * 10000) - (Math.random() * 10000);
   x0[2] = 0;
   y0[2] = (Math.random() * 10000) - (Math.random() * 10000);
   z0[2] = (Math.random() * 10000) - (Math.random() * 10000);
   x0[3] = 0;
   y0[3] = (Math.random() * 10000) - (Math.random() * 10000);
   z0[3] = (Math.random() * 10000) - (Math.random() * 10000);
   dt(gs, x0, y0, z0, x, y, z, xz, zy, xy, b, ht, 255, 255, 255);
  }
 }
}
