
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;
import java.util.Random;

class Mdm {

 Game G;
 Path2D pth;
 int p;
 double fcs_pnt;
 double grnd;
 double hrzn;
 long[] fd;
 long cld[] = {210, 210, 210, 1, -1000};
 double clds[] = {210, 210, 210};
 long osky[] = {255, 255, 255};
 double csky[] = {255, 255, 255};
 long ogrnd[] = {200, 200, 200};
 double cgrnd[] = {200, 200, 200};
 long textr[] = {0, 0, 0, 50};
 double cpol[] = {215, 215, 215};
 double crgrnd[] = {200, 200, 200};
 double cfad[] = {255, 255, 255};
 long snap[] = {0, 0, 0};
 double grv[] = {0,
  7, 7, 7, 7, 7, 7, 7, 7, 7, 7,
  7, 7, 7, 7, 7, 7, 7, 7, 7, 7,
  7, 7, 7, 7, 7, 7, 7, 7, 7, 7,
  7, 7, 7, 7, 7, 3.5, 7, 1.1585714285714285714285714285714, 7, 7,
  7, 7, 7, 28, 7, 7, 7, 7, 7, 7,
  7, 7, 7, 7, 7, 7, 7, 7, 7, 7,
  7, 7, 7, 7, 7, 0, 7, 7, 7, 0,
  7};
 double atm[] = {0,
  .999, .998, .998, .999, 1.002, 1.002, .998, 1.002, 1.002, 1.003,
  .999, .998, 1.002, .998, 1, .998, 1.002, .998, 1.002, 1.004,
  1, .998, .998, 1.002, .994, 1, .998, 1.002, .998, .998,
  1, 1, 1, .998, 1.002, 1.002, .998, 1, 1, 1,
  .992, 1, 1.002, 0, 1.002, .998, .998, 1.003, 1, 1.004,
  1, 1.001, 1, .998, 1, 1.002, 1, 1.002, 1, 1.002,
  .998, 1, 1.003, .998, .98, 1, 1, 1, 1.002, 1,
  .98};
 double lAng;
 long dnst;
 long mgen;
 boolean liton;
 boolean cldon;
 boolean mnton;
 boolean stron;
 boolean plon;
 boolean crs;
 double cx;
 double cy;
 double cz;
 double xz;
 double zy;
 double x;
 double y;
 double z;
 double w;
 double h;
 double[] axz;
 double adv;
 boolean vert;
 boolean sgnR;
 long cp;
 boolean fchk;
 int pnt;
 double pcnt;
 long trx;
 long trz;
 long ty;
 double ppx[][];
 double ppz[][];
 double pvr[][];
 double cgpx[];
 double cgpz[];
 double pmx[];
 double pcv[];
 int nrw;
 int ncl;
 int nCl;
 double clx[];
 double clz[];
 double cmx[];
 double cldx[][][];
 double cldy[][][];
 double cldz[][][];
 double clc[][][][];
 double wndx;
 double wndz;
 int nmt;
 int mrd[];
 int nmv[];
 double mtx[][];
 double mty[][];
 double mtz[][];
 double mtc[][][];
 int nst;
 double stx[];
 double stz[];
 double sty[];
 double stc[][][];
 boolean bst[];
 long twn[];
 double snwx[];
 double snwy[];
 double snwvx[];
 double snwvy[];
 int snwsz[];
 long yrt;
 long rnd;
 double mF;
 boolean nosc;
 boolean nofpwr;
 double zm;
 boolean imrtl;
 double maxD;
 long AId;
 long GR;

 Mdm(Game g) {
  fcs_pnt = 500;
  grnd = 250;
  dnst = 30;
  cx = 800;
  cy = 400;
  cz = 50;
  w = 1600;
  h = 800;
  axz = new double[2];
  axz[0] = (Math.random() * 180) - (Math.random() * 180);
  adv = 1000;
  cp = -1;
  fd = null;
  ppx = (double[][]) null;
  ppz = (double[][]) null;
  pvr = (double[][]) null;
  cgpx = null;
  cgpz = null;
  pmx = null;
  pcv = null;
  clx = null;
  clz = null;
  cmx = null;
  cldx = (double[][][]) null;
  cldy = (double[][][]) null;
  cldz = (double[][][]) null;
  clc = (double[][][][]) null;
  mrd = null;
  nmv = null;
  mtx = (double[][]) null;
  mty = (double[][]) null;
  mtz = (double[][]) null;
  mtc = (double[][][]) null;
  stx = null;
  stz = null;
  sty = null;
  stc = (double[][][]) null;
  bst = null;
  twn = null;
  snwx = new double[1000];
  snwy = new double[1000];
  snwvx = new double[1000];
  snwvy = new double[1000];
  snwsz = new int[1000];
  for (int s = 0; s < 1000; s++) {
   snwx[s] = Math.random() * w;
   snwy[s] = Math.random() * h;
   snwsz[s] = 1;
   if (Math.random() < .5) {
    snwsz[s] = 2;
   }
  }
  G = g;
 }

 void wtch(Act a) {
  if (Math.sqrt(Math.pow(z + cz - a.z, 2) + Math.pow(x + cx - a.x, 2) + Math.pow(y + cy - a.y, 2)) > 10000) {
   y = a.y - (Math.random() * 2000);
   if (a.y < -1000) {
    y += Math.random() * 2000;
   }
   y = Math.min(y, -250);
   x = (a.x - cx) + (Math.random() * 9000) - (Math.random() * 9000);
   z = (a.z - cz) + (Math.random() * 9000) - (Math.random() * 9000);
  }
  long c = 0;
  if (a.x - x - cx > 0) {
   c = 180;
  }
  double b = -((90 + c) + Math.atan((a.z - z - cz) / (a.x - x - cx)) * 57.295779513082320876798154814105);
  double d = Math.sqrt(Math.pow(a.z - z - cz, 2) + Math.pow(a.x - x - cx, 2));
  c = -1;
  if (a.y - y - cy > 0) {
   c = 1;
  }
  xz = b;
  zy = (90 * c) - Math.atan(d / (a.y - y - cy)) * 57.295779513082320876798154814105;
 }

 void rndtrck() {
  if (y != ty) {
   y = ty - 5000;
  }
  if (zy != 10) {
   zy = 10;
  }
  x = cx + trx + (17000 * cos(axz[0]));
  z = trz + (17000 * sin(axz[0]));
  if (Math.random() > .999) {
   rnd *= -1;
  }
  axz[0] += rnd * G.zz;
  pcnt += G.zz;
  if (pcnt > 6) {
   pnt++;
   if (pnt >= G.nS) {
    pnt = 0;
   }
   pcnt = 0;
  }
  trx -= (trx - G.x[pnt]) * .1 * G.zz;
  trz -= (trz - G.z[pnt]) * .1 * G.zz;
  ty -= (ty - G.y[pnt]) * .1 * G.zz;
  if (ty > 0) {
   ty = 0;
  }
  if (axz[0] > 180) {
   axz[0] -= 360;
  }
  if (axz[0] < -180) {
   axz[0] += 360;
  }
  xz = -axz[0] - 90;
 }

 void arnd(Act a) {
  if (!vert) {
   adv += 2 * G.zz;
  } else {
   adv -= 2 * G.zz;
  }
  if (adv > 2000) {
   vert = true;
  }
  if (adv < -2000) {
   vert = false;
  }
  double v = 1000 + adv;
  if (v < 2000) {
   v = 2000;
  }
  y = a.y - adv;
  if (y > -250) {
   y = -250;
   if (vert) {
    adv = 0;
   }
   vert = false;
  }
  x = (a.x - cx) + ((a.x - v - a.x) * cos(axz[0]));
  z = (a.z - cz) + ((a.x - v - a.x) * sin(axz[0]));
  if (Math.random() > .999) {
   rnd *= -1;
  }
  axz[0] += 2 * rnd * G.zz;
  if (axz[0] > 180) {
   axz[0] -= 360;
  }
  if (axz[0] < -180) {
   axz[0] += 360;
  }
  double k = Math.sqrt(Math.pow(a.z - z + cz, 2) + Math.pow(a.x - x - cx, 2));
  double l;
  if (a.y - y - cy < 0) {
   l = -90 - Math.atan(k / (a.y - y - cy)) * 57.295779513082320876798154814105;
  } else {
   l = 90 - Math.atan(k / (a.y - y - cy)) * 57.295779513082320876798154814105;
  }
  xz = -axz[0] + 90;
  zy += (l - zy) * .1 * G.zz;
 }

 void folw(Act a, double cxz, long loka, Play py) {
  if (py.typ[py.cN] == 0) {
   if (zy != 10) {
    zy = 10;
   }
   if (loka > 0) {
    axz[1] += 15 * G.zz;
   }
   if (loka < 0) {
    axz[1] -= 15 * G.zz;
   }
   cxz += axz[1];
   xz = -cxz;
   x = (a.x - cx) + ((-(a.z - (800 * G.view) - a.z)) * sin(cxz));
   z = (a.z - cz) + ((a.z - (800 * G.view) - a.z) * cos(cxz));
   y = a.y - (250 * G.view) - cy;
   if (G.cNm[py.cN] == "EL KING" || G.cNm[py.cN] == "M A S H E E N" || G.cNm[py.cN] == "EL ROCKET KING" || G.cNm[py.cN] == "ROCKET M A S H E E N") {
    y = a.y - (300 * G.view) - cy;
   }
   if (G.cNm[py.cN] == "OW SLAMINARO" || G.cNm[py.cN] == "KILL-O-MATIC" || G.cNm[py.cN] == "TRAIN of TERROR") {
    y = a.y - (400 * G.view) - cy;
   }
  }
  double zy1 = a.zy;
  double xz1 = a.xz;
  int r = 1;
  if (py.typ[py.cN] == 1) {
   if (loka != 0) {
    r = -1;
    if (axz[1] != 180) {
     axz[1] = 180;
    }
   } else if (axz[1] != 0) {
    axz[1] = 0;
   }
   if (Math.abs(a.zy) > 90) {
    if (yrt != 250 * G.view) {
     yrt = 250 * G.view;
    }
    xz1 -= 180;
    zy1 *= -1;
    if (a.zy > 90) {
     zy1 += 180;
    } else {
     zy1 -= 180;
    }
   } else if (yrt != -250 * G.view) {
    yrt = -250 * G.view;
   }
   double dy = a.y + (((a.y + yrt) - a.y) * cos(a.zy) - (a.z - (800 * G.view * r) - a.z) * sin(a.zy));
   double dz = a.z + (((a.y + yrt) - a.y) * sin(a.zy) + (a.z - (800 * G.view * r) - a.z) * cos(a.zy));
   double dx = a.x + ((-(dz - a.z)) * sin(a.xz));
   double dz1 = a.z + ((dz - a.z) * cos(a.xz));
   zy = ((10 * r) - zy1) * r;
   xz = -xz1 + axz[1];
   x += dx - cx - x;
   y += dy - cy - y;
   z += dz1 - cz - z;
  }
  if (py.typ[py.cN] == 2) {
   if (loka != 0) {
    r = -1;
    if (axz[1] != 180) {
     axz[1] = 180;
    }
   } else if (axz[1] != 0) {
    axz[1] = 0;
   }
   if (Math.abs(a.zy) > 90) {
    if (yrt != 39 * G.view) {
     yrt = 39 * G.view;
    }
    xz1 -= 180;
    zy1 *= -1;
    if (a.zy > 90) {
     zy1 += 180;
    } else {
     zy1 -= 180;
    }
   } else if (yrt != -39 * G.view) {
    yrt = -39 * G.view;
   }
   long tz = -100;
   if (G.view > 1) {
    tz = 1000;
   }
   double dy = a.y + (((a.y + yrt) - a.y) * cos(a.zy) - (a.z - (tz * r) - a.z) * sin(a.zy));
   double dz = a.z + (((a.y + yrt) - a.y) * sin(a.zy) + (a.z - (tz * r) - a.z) * cos(a.zy));
   double dx = a.x + ((-(dz - a.z)) * sin(a.xz));
   double dz1 = a.z + ((dz - a.z) * cos(a.xz));
   zy = -zy1 * r;
   xz = -xz1 + axz[1];
   x += dx - cx - x;
   y += dy - cy - y;
   z += dz1 - cz - z;
  }
  if (axz[1] < -180) {
   axz[1] += 360;
  }
  if (axz[1] > 180) {
   axz[1] -= 360;
  }
 }

 void nwpoly(long a, long b, long c, long d, Track t) {
  if (plon) {
   int c1;
   int i;
   Random r = new Random((long) ((G.nT + cgrnd[0] + cgrnd[1] + cgrnd[2]) * 1671));
   nrw = (int) (b / 1200 + 9);
   ncl = (int) (d / 1200 + 9);
   ppx = (double[][]) null;
   ppz = (double[][]) null;
   pvr = (double[][]) null;
   cgpx = null;
   cgpz = null;
   pmx = null;
   pcv = null;
   ppx = new double[nrw * ncl][8];
   ppz = new double[nrw * ncl][8];
   pvr = new double[nrw * ncl][8];
   cgpx = new double[nrw * ncl];
   cgpz = new double[nrw * ncl];
   pmx = new double[nrw * ncl];
   pcv = new double[nrw * ncl];
   int v1 = 0;
   int v2 = 0;
   for (i = 0; i < nrw * ncl; i++) {
    cgpx[i] = (a - 4800) + v1 * 1200 + (r.nextDouble() * 1000 - 500);
    cgpz[i] = (c - 4800) + v2 * 1200 + (r.nextDouble() * 1000 - 500);
    for (c1 = 0; c1 < t.nt; c1++) {
     if (t.zy[c1] != 0 || t.xy[c1] != 0) {
      continue;
     }
     if (t.radx[c1] < t.radz[c1] && Math.abs(cgpz[i] - t.z[c1]) < t.radz[c1]) {
      for (; Math.abs(cgpx[i] - t.x[c1]) < t.radx[c1]; cgpx[i] += r.nextDouble() * t.radx[c1] * 2 - t.radx[c1]) {
      }
     }
     if (t.radz[c1] >= t.radx[c1] || Math.abs(cgpx[i] - t.x[c1]) >= t.radx[c1]) {
      continue;
     }
     for (; Math.abs(cgpz[i] - t.z[c1]) < t.radz[c1]; cgpz[i] += r.nextDouble() * t.radz[c1] * 2 - t.radz[c1]) {
     }
    }
    if (++v1 >= nrw) {
     v1 = 0;
     v2++;
    }
   }
   for (i = 0; i < nrw * ncl; i++) {
    double f = .3 + 1.6 * r.nextDouble();
    ppx[i][0] = 0;
    ppz[i][0] = (100 + r.nextDouble() * 760) * f;
    ppx[i][1] = (100 + r.nextDouble() * 760) * .7071 * f;
    ppz[i][1] = ppx[i][1];
    ppx[i][2] = (100 + r.nextDouble() * 760) * f;
    ppz[i][2] = 0;
    ppx[i][3] = (100 + r.nextDouble() * 760) * .7071 * f;
    ppz[i][3] = -ppx[i][3];
    ppx[i][4] = 0;
    ppz[i][4] = -((100 + r.nextDouble() * 760) * f);
    ppx[i][5] = -((100 + r.nextDouble() * 760) * .7071 * f);
    ppz[i][5] = ppx[i][5];
    ppx[i][6] = -((100 + r.nextDouble() * 760) * f);
    ppz[i][6] = 0;
    ppx[i][7] = -((100 + r.nextDouble() * 760) * .7071 * f);
    ppz[i][7] = -ppx[i][7];
    for (c1 = 0; c1 < 8; c1++) {
     int v3 = c1 - 1;
     if (v3 < 0) {
      v3 = 7;
     }
     int v4 = c1 + 1;
     if (v4 > 7) {
      v4 = 0;
     }
     ppx[i][c1] = ((ppx[i][v3] + ppx[i][v4]) * .5 + ppx[i][c1]) * .5;
     ppz[i][c1] = ((ppz[i][v3] + ppz[i][v4]) * .5 + ppz[i][c1]) * .5;
     pvr[i][c1] = 1.1 + r.nextDouble() * .8;
     double d1 = Math.sqrt((Math.pow(ppx[i][c1], 2) * Math.pow(pvr[i][c1], 2)) + (Math.pow(ppz[i][c1], 2) * Math.pow(pvr[i][c1], 2)));
     if (pmx[i] < d1) {
      pmx[i] = d1;
     }
    }
    pcv[i] = .97 + r.nextDouble() * .03;
    if (pcv[i] > 1) {
     pcv[i] = 1;
    }
    if (r.nextDouble() > r.nextDouble()) {
     pcv[i] = 1;
    }
   }
  }
 }

 void dpoly(Graphics2D gs) {
  double[] n = new double[nrw * ncl];
  int c;
  int p1;
  Random rn = new Random((long) ((G.nT + cgrnd[0] + cgrnd[1] + cgrnd[2]) * 1671));
  for (int i = 0; i < nrw * ncl; i++) {
   if (G.x_z((x + cx) * .01, cgpx[i] * .01, (z + cz) * .01, cgpz[i] * .01) < pmx[i] * pmx[i] * pmx[i] * 0.000025) {
    if (G.stg == 44) {
     ppx[i][0] = 0;
     ppz[i][0] = (100 + rn.nextDouble() * 760) * (Math.random() * 2);
     ppx[i][1] = ((100 + rn.nextDouble() * 760) * .7071) * (Math.random() * 2);
     ppz[i][1] = ppx[i][1];
     ppx[i][2] = (100 + rn.nextDouble() * 760) * (Math.random() * 2);
     ppz[i][2] = 0;
     ppx[i][3] = ((100 + rn.nextDouble() * 760) * .7071) * (Math.random() * 2);
     ppz[i][3] = -ppx[i][3];
     ppx[i][4] = 0;
     ppz[i][4] = -(100 + rn.nextDouble() * 760) * (Math.random() * 2);
     ppx[i][5] = -((100 + rn.nextDouble() * 760) * .7071) * (Math.random() * 2);
     ppz[i][5] = ppx[i][5];
     ppx[i][6] = -(100 + rn.nextDouble() * 760) * (Math.random() * 2);
     ppz[i][6] = 0;
     ppx[i][7] = -((100 + rn.nextDouble() * 760) * .7071) * (Math.random() * 2);
     ppz[i][7] = -ppx[i][7];
    }
    n[i] = 0;
    double dx = cx + ((cgpx[i] - x - cx) * cos(xz) - (cgpz[i] - z - cz) * sin(xz));
    double dz = cz + ((cgpx[i] - x - cx) * sin(xz) + (cgpz[i] - z - cz) * cos(xz));
    double dz1 = cz + ((250 - y - cy) * sin(zy) + (dz - cz) * cos(zy));
    if (xs(dx + pmx[i], dz1) <= 0 || xs(dx - pmx[i], dz1) >= w || dz1 <= -pmx[i] || (fd != null && dz1 >= fd[1])) {
     continue;
    }
    n[i] = dz1;
    double[] x0 = new double[8];
    double[] z0 = new double[8];
    double[] y0 = new double[8];
    for (c = 0; c < 8; c++) {
     x0[c] = (ppx[i][c] * pvr[i][c] + cgpx[i]) - x;
     z0[c] = (ppz[i][c] * pvr[i][c] + cgpz[i]) - z;
     y0[c] = grnd;
    }
    rot(x0, z0, cx, cz, xz, 8);
    rot(y0, z0, cy, cz, zy, 8);
    double[] x1 = new double[8];
    double[] y1 = new double[8];
    int[] m = new int[4];
    boolean tf1 = true;
    for (c = 0; c < 8; c++) {
     x1[c] = xs(x0[c], z0[c]);
     y1[c] = ys(y0[c], z0[c]);
     if (y1[c] < 0 || z0[c] < 10) {
      m[0]++;
     }
     if (y1[c] > h || z0[c] < 10) {
      m[1]++;
     }
     if (x1[c] < 0 || z0[c] < 10) {
      m[2]++;
     }
     if (x1[c] > w || z0[c] < 10) {
      m[3]++;
     }
    }
    if (m[0] > 7 || m[1] > 7 || m[2] > 7 || m[3] > 7) {
     tf1 = false;
    }
    if (!tf1) {
     continue;
    }
    double r = (cpol[0] * pcv[i] + cgrnd[0]) * .5;
    double g = (cpol[1] * pcv[i] + cgrnd[1]) * .5;
    double b = (cpol[2] * pcv[i] + cgrnd[2]) * .5;
    if ((G.X != 0 || G.Z != 0) && !nosc) {
     r += lAng * .5;
     g += lAng * .5;
     b += lAng * .5;
    }
    if (fd != null) {
     if (dz1 - pmx[i] > fd[0]) {
      r = (r * 7 + cfad[0]) * .125;
      g = (g * 7 + cfad[1]) * .125;
      b = (b * 7 + cfad[2]) * .125;
     }
     if (dz1 - pmx[i] > fd[1]) {
      r = (r * 7 + cfad[0]) * .125;
      g = (g * 7 + cfad[1]) * .125;
      b = (b * 7 + cfad[2]) * .125;
     }
    }
    G.c(r, g, b);
    pth = new Path2D.Double();
    pth.moveTo(x1[0], y1[0]);
    for (p = 0; p < 8; p++) {
     pth.lineTo(x1[p], y1[p]);
    }
    pth.closePath();
    gs.fill(pth);
    if (n[i] == 0) {
     continue;
    }
    x0 = new double[8];
    z0 = new double[8];
    y0 = new double[8];
    for (c = 0; c < 8; c++) {
     x0[c] = (ppx[i][c] + cgpx[i]) - x;
     z0[c] = (ppz[i][c] + cgpz[i]) - z;
     y0[c] = grnd;
    }
    rot(x0, z0, cx, cz, xz, 8);
    rot(y0, z0, cy, cz, zy, 8);
    double[] x3 = new double[8];
    double[] y3 = new double[8];
    m[0] = 0;
    m[1] = 0;
    m[2] = 0;
    m[3] = 0;
    boolean tf = true;
    for (c = 0; c < 8; c++) {
     x3[c] = xs(x0[c], z0[c]);
     y3[c] = ys(y0[c], z0[c]);
     if (y3[c] < 0 || z0[c] < 10) {
      m[0]++;
     }
     if (y3[c] > h || z0[c] < 10) {
      m[1]++;
     }
     if (x3[c] < 0 || z0[c] < 10) {
      m[2]++;
     }
     if (x3[c] > w || z0[c] < 10) {
      m[3]++;
     }
    }
    if (m[0] > 7 || m[1] > 7 || m[2] > 7 || m[3] > 7) {
     tf = false;
    }
    if (!tf) {
     continue;
    }
    r = cpol[0] * pcv[i];
    g = cpol[1] * pcv[i];
    b = cpol[2] * pcv[i];
    if ((G.X != 0 || G.Z != 0) && !nosc) {
     r += lAng * .5;
     g += lAng * .5;
     b += lAng * .5;
    }
    if (fd != null) {
     if (n[i] - pmx[i] > fd[0]) {
      r = (r * 7 + cfad[0]) * .125;
      g = (g * 7 + cfad[1]) * .125;
      b = (b * 7 + cfad[2]) * .125;
     }
     if (n[i] - pmx[i] > fd[1]) {
      r = (r * 7 + cfad[0]) * .125;
      g = (g * 7 + cfad[1]) * .125;
      b = (b * 7 + cfad[2]) * .125;
     }
    }
    G.c(r, g, b);
    pth = new Path2D.Double();
    pth.moveTo(x3[0], y3[0]);
    for (p1 = 0; p1 < 8; p1++) {
     pth.lineTo(x3[p1], y3[p1]);
    }
    pth.closePath();
    gs.fill(pth);
   }
  }
 }

 void nwcld() {
  if (cldon) {
   int c;
   int c1;
   clx = null;
   clz = null;
   cmx = null;
   cldx = (double[][][]) null;
   cldy = (double[][][]) null;
   cldz = (double[][][]) null;
   clc = (double[][][][]) null;
   nCl = (int) (Math.random() * 500);
   clx = new double[nCl];
   clz = new double[nCl];
   cmx = new double[nCl];
   cldx = new double[nCl][3][12];
   cldy = new double[nCl][3][12];
   cldz = new double[nCl][3][12];
   clc = new double[nCl][2][6][3];
   for (c = 0; c < nCl; c++) {
    clx[c] = (Math.random() - Math.random()) * 50000;
    clz[c] = (Math.random() - Math.random()) * 50000;
    if (G.stg == 50 || G.stg == 54 || G.stg == 62) {
     clx[c] = (Math.random() - Math.random()) * 500000;
     clz[c] = (Math.random() - Math.random()) * 500000;
    }
    double f = .25 + Math.random() * 1.25;
    double f1 = (Math.random() - Math.random()) * 2000 * f;
    cldx[c][0][0] = f1 * .3826;
    cldz[c][0][0] = f1 * .9238;
    cldy[c][0][0] = (25 - Math.random() * 50) * f;
    f1 = (Math.random() - Math.random()) * 2000 * f;
    cldx[c][0][1] = f1 * .7071;
    cldz[c][0][1] = f1 * .7071;
    cldy[c][0][1] = ((25 - Math.random() * 50) * f);
    f1 = (Math.random() - Math.random()) * 2000 * f;
    cldx[c][0][2] = f1 * .9238;
    cldz[c][0][2] = f1 * .3826;
    cldy[c][0][2] = (25 - Math.random() * 50) * f;
    f1 = (Math.random() - Math.random()) * 2000 * f;
    cldx[c][0][3] = f1 * .9238;
    cldz[c][0][3] = -f1 * .3826;
    cldy[c][0][3] = (25 - Math.random() * 50) * f;
    f1 = (Math.random() - Math.random()) * 2000 * f;
    cldx[c][0][4] = f1 * .7071;
    cldz[c][0][4] = -f1 * .7071;
    cldy[c][0][4] = (25 - Math.random() * 50) * f;
    f1 = (Math.random() - Math.random()) * 2000 * f;
    cldx[c][0][5] = f1 * .3826;
    cldz[c][0][5] = -f1 * .9238;
    cldy[c][0][5] = (25 - Math.random() * 50) * f;
    f1 = (Math.random() - Math.random()) * 2000 * f;
    cldx[c][0][6] = -f1 * .3826;
    cldz[c][0][6] = -f1 * .9238;
    cldy[c][0][6] = (25 - Math.random() * 50) * f;
    f1 = (Math.random() - Math.random()) * 2000 * f;
    cldx[c][0][7] = -f1 * .7071;
    cldz[c][0][7] = -f1 * .7071;
    cldy[c][0][7] = (25 - Math.random() * 50) * f;
    f1 = (Math.random() - Math.random()) * 2000 * f;
    cldx[c][0][8] = -f1 * .9238;
    cldz[c][0][8] = -f1 * .3826;
    cldy[c][0][8] = (25 - Math.random() * 50) * f;
    f1 = (Math.random() - Math.random()) * 2000 * f;
    cldx[c][0][9] = -f1 * .9238;
    cldz[c][0][9] = f1 * .3826;
    cldy[c][0][9] = (25 - Math.random() * 50) * f;
    f1 = (Math.random() - Math.random()) * 2000 * f;
    cldx[c][0][10] = -f1 * .7071;
    cldz[c][0][10] = f1 * .7071;
    cldy[c][0][10] = (25 - Math.random() * 50) * f;
    f1 = (Math.random() - Math.random()) * 2000 * f;
    cldx[c][0][11] = -f1 * .3826;
    cldz[c][0][11] = f1 * .9238;
    cldy[c][0][11] = (25 - Math.random() * 50) * f;
    for (c1 = 0; c1 < 12; c1++) {
     int v1 = c1 - 1;
     if (v1 < 0) {
      v1 = 11;
     }
     int v2 = c1 + 1;
     if (v2 > 11) {
      v2 = 0;
     }
     cldx[c][0][c1] = ((cldx[c][0][v1] + cldx[c][0][v2]) * .5 + cldx[c][0][c1]) * .5;
     cldy[c][0][c1] = ((cldy[c][0][v1] + cldy[c][0][v2]) * .5 + cldy[c][0][c1]) * .5;
     cldz[c][0][c1] = ((cldz[c][0][v1] + cldz[c][0][v2]) * .5 + cldz[c][0][c1]) * .5;
    }
    for (c1 = 0; c1 < 12; c1++) {
     double f2 = 1.2 + .6 * Math.random();
     cldx[c][1][c1] = cldx[c][0][c1] * f2;
     cldz[c][1][c1] = cldz[c][0][c1] * f2;
     cldy[c][1][c1] = cldy[c][0][c1] - 100 * Math.random();
     f2 = 1.1 + .3 * Math.random();
     cldx[c][2][c1] = cldx[c][1][c1] * f2;
     cldz[c][2][c1] = cldz[c][1][c1] * f2;
     cldy[c][2][c1] = cldy[c][1][c1] - 240 * Math.random();
    }
    cmx[c] = 0;
    for (c1 = 0; c1 < 12; c1++) {
     int v1 = (c1 - 1);
     if (v1 < 0) {
      v1 = 11;
     }
     int v2 = (c1 + 1);
     if (v2 > 11) {
      v2 = 0;
     }
     cldy[c][1][c1] = ((cldy[c][1][v1] + cldy[c][1][v2]) * .5 + cldy[c][1][c1]) * .5;
     cldy[c][2][c1] = ((cldy[c][2][v1] + cldy[c][2][v2]) * .5 + cldy[c][2][c1]) * .5;
     double d = Math.sqrt(Math.pow(cldx[c][2][c1], 2) + Math.pow(cldz[c][2][c1], 2));
     if (cmx[c] < d) {
      cmx[c] = d;
     }
    }
    for (c1 = 0; c1 < 6; c1++) {
     for (int b = 0; b < 3; b++) {
      double f3 = clds[b] * 1.05 - clds[b];
      clc[c][0][c1][b] = clds[b] + f3 * Math.random();
      clc[c][1][c1][b] = (clds[b] * 1.05) + f3 * Math.random();
     }
    }
   }
  }
 }

 void dcld(Graphics2D gs) {
  int c1;
  int c2;
  wndx += .1 * Math.random() * G.zz;
  wndx -= .1 * Math.random() * G.zz;
  wndz += .1 * Math.random() * G.zz;
  wndz -= .1 * Math.random() * G.zz;
  wndx -= wndx * .0003 * G.zz;
  wndz -= wndz * .0003 * G.zz;
  long d = 50000;
  if (G.stg == 50 || G.stg == 54 || G.stg == 62) {
   d = 500000;
  }
  for (int c = 0; c < nCl; c++) {
   clx[c] += wndx * G.zz;
   clz[c] += wndz * G.zz;
   if (Math.abs(clx[c]) > d) {
    clx[c] *= -1;
   }
   if (Math.abs(clz[c]) > d) {
    clz[c] *= -1;
   }
   double[][] x0 = new double[3][12];
   double[][] y0 = new double[3][12];
   double[][] z0 = new double[3][12];
   double[] x1 = new double[12];
   double[] y1 = new double[12];
   long[] m = new long[4];
   boolean tf;
   for (c1 = 0; c1 < 3; c1++) {
    for (c2 = 0; c2 < 12; c2++) {
     x0[c1][c2] = (cldx[c][c1][c2] + clx[c]) - x * .05;
     z0[c1][c2] = (cldz[c][c1][c2] + clz[c]) - z * .05;
     y0[c1][c2] = (cldy[c][c1][c2] + cld[4]) - y * .05;
    }
    rot(x0[c1], z0[c1], cx, cz, xz, 12);
    rot(y0[c1], z0[c1], cy, cz, zy, 12);
   }
   for (c1 = 0; c1 < 12; c1 += 2) {
    m[0] = 0;
    m[1] = 0;
    m[2] = 0;
    m[3] = 0;
    tf = true;
    for (c2 = 0; c2 < 6; c2++) {
     int v1 = 0;
     int b0 = 1;
     if (c2 == 0) {
      v1 = c1;
     }
     if (c2 == 1) {
      v1 = (c1 + 1);
      if (v1 > 11) {
       v1 -= 12;
      }
     }
     if (c2 == 2) {
      v1 = (c1 + 2);
      if (v1 > 11) {
       v1 -= 12;
      }
     }
     if (c2 == 3) {
      v1 = (c1 + 2);
      if (v1 > 11) {
       v1 -= 12;
      }
      b0 = 2;
     }
     if (c2 == 4) {
      v1 = (c1 + 1);
      if (v1 > 11) {
       v1 -= 12;
      }
      b0 = 2;
     }
     if (c2 == 5) {
      v1 = c1;
      b0 = 2;
     }
     x1[c2] = xs(x0[b0][v1], z0[b0][v1]);
     y1[c2] = ys(y0[b0][v1], z0[b0][v1]);
     if (y1[c2] < 0 || z0[0][c2] < 10) {
      m[0]++;
     }
     if (y1[c2] > h || z0[0][c2] < 10) {
      m[1]++;
     }
     if (x1[c2] < 0 || z0[0][c2] < 10) {
      m[2]++;
     }
     if (x1[c2] > w || z0[0][c2] < 10) {
      m[3]++;
     }
    }
    if (m[0] > 5 || m[1] > 5 || m[2] > 5 || m[3] > 5) {
     tf = false;
    }
    if (!tf) {
     continue;
    }
    G.c(clc[c][1][c1 / 2][0], clc[c][1][c1 / 2][1], clc[c][1][c1 / 2][2]);
    pth = new Path2D.Double();
    pth.moveTo(x1[0], y1[0]);
    for (p = 0; p < 6; p++) {
     pth.lineTo(x1[p], y1[p]);
    }
    pth.closePath();
    gs.fill(pth);
   }
   for (c1 = 0; c1 < 12; c1 += 2) {
    m[0] = 0;
    m[1] = 0;
    m[2] = 0;
    m[3] = 0;
    tf = true;
    for (c2 = 0; c2 < 6; c2++) {
     int v1 = 0;
     int v2 = 0;
     if (c2 == 0) {
      v1 = c1;
     }
     if (c2 == 1) {
      v1 = (c1 + 1);
      if (v1 > 11) {
       v1 -= 12;
      }
     }
     if (c2 == 2) {
      v1 = (c1 + 2);
      if (v1 > 11) {
       v1 -= 12;
      }
     }
     if (c2 == 3) {
      v1 = (c1 + 2);
      if (v1 > 11) {
       v1 -= 12;
      }
      v2 = 1;
     }
     if (c2 == 4) {
      v1 = (c1 + 1);
      if (v1 > 11) {
       v1 -= 12;
      }
      v2 = 1;
     }
     if (c2 == 5) {
      v1 = c1;
      v2 = 1;
     }
     x1[c2] = xs(x0[v2][v1], z0[v2][v1]);
     y1[c2] = ys(y0[v2][v1], z0[v2][v1]);
     if (y1[c2] < 0 || z0[0][c2] < 10) {
      m[0]++;
     }
     if (y1[c2] > h || z0[0][c2] < 10) {
      m[1]++;
     }
     if (x1[c2] < 0 || z0[0][c2] < 10) {
      m[2]++;
     }
     if (x1[c2] > w || z0[0][c2] < 10) {
      m[3]++;
     }
    }
    if (m[0] > 5 || m[1] > 5 || m[2] > 5 || m[3] > 5) {
     tf = false;
    }
    if (!tf) {
     continue;
    }
    G.c(clc[c][0][c1 / 2][0], clc[c][0][c1 / 2][1], clc[c][0][c1 / 2][2]);
    pth = new Path2D.Double();
    pth.moveTo(x1[0], y1[0]);
    for (p = 0; p < 6; p++) {
     pth.lineTo(x1[p], y1[p]);
    }
    pth.closePath();
    gs.fill(pth);
   }
   m[0] = 0;
   m[1] = 0;
   m[2] = 0;
   m[3] = 0;
   tf = true;
   for (c1 = 0; c1 < 12; c1++) {
    x1[c1] = xs(x0[0][c1], z0[0][c1]);
    y1[c1] = ys(y0[0][c1], z0[0][c1]);
    if (y1[c1] < 0 || z0[0][c1] < 10) {
     m[0]++;
    }
    if (y1[c1] > h || z0[0][c1] < 10) {
     m[1]++;
    }
    if (x1[c1] < 0 || z0[0][c1] < 10) {
     m[2]++;
    }
    if (x1[c1] > w || z0[0][c1] < 10) {
     m[3]++;
    }
   }
   if (m[0] > 11 || m[1] > 11 || m[2] > 11 || m[3] > 11) {
    tf = false;
   }
   if (!tf) {
    continue;
   }
   G.c(clds[0], clds[1], clds[2]);
   pth = new Path2D.Double();
   pth.moveTo(x1[0], y1[0]);
   for (p = 0; p < 12; p++) {
    pth.lineTo(x1[p], y1[p]);
   }
   pth.closePath();
   gs.fill(pth);
  }
 }

 void nwmnt(long a, long b, long c, long d) {
  if (mnton) {
   int c1;
   int c2;
   Random r = new Random(mgen);
   nmt = (int) (20 + 10 * r.nextDouble());
   long d1 = (a + b) / 60;
   long d2 = (c + d) / 60;
   long mx = Math.max(b - a, d - c) / 60;
   mrd = null;
   nmv = null;
   mtx = (double[][]) null;
   mty = (double[][]) null;
   mtz = (double[][]) null;
   mtc = (double[][][]) null;
   mrd = new int[nmt];
   nmv = new int[nmt];
   mtx = new double[nmt][];
   mty = new double[nmt][];
   mtz = new double[nmt][];
   mtc = new double[nmt][][];
   double[] d3 = new double[nmt];
   int[] d4 = new int[nmt];
   for (c1 = 0; c1 < nmt; c1++) {
    long rn;
    double f;
    double f1;
    d3[c1] = 10000 + r.nextDouble() * 10000;
    long rn1 = (long) (r.nextDouble() * 360);
    if (r.nextDouble() > r.nextDouble()) {
     f = .2 + r.nextDouble() * .35;
     f1 = .2 + r.nextDouble() * .35;
     nmv[c1] = (int) (f * (24 + 16 * r.nextDouble()));
     rn = (long) (85 + 10 * r.nextDouble());
    } else {
     f = .3 + r.nextDouble() * 1.1;
     f1 = .2 + r.nextDouble() * .35;
     nmv[c1] = (int) (f * (12 + 8 * r.nextDouble()));
     rn = (long) (104 - 10 * r.nextDouble());
    }
    mtx[c1] = new double[nmv[c1] * 2];
    mty[c1] = new double[nmv[c1] * 2];
    mtz[c1] = new double[nmv[c1] * 2];
    mtc[c1] = new double[nmv[c1]][3];
    for (c2 = 0; c2 < nmv[c1]; c2++) {
     mtx[c1][c2] = (((c2 * 500) + (r.nextDouble() * 800 - 400)) - (250 * (nmv[c1] - 1))) * f;
     mtx[c1][c2 + nmv[c1]] = (((c2 * 500) + (r.nextDouble() * 800 - 400)) - (250 * (nmv[c1] - 1))) * f;
     mtx[c1][nmv[c1]] = mtx[c1][0] - (100 + r.nextDouble() * 600) * f;
     mtx[c1][nmv[c1] * 2 - 1] = mtx[c1][nmv[c1] - 1] + (100 + r.nextDouble() * 600) * f;
     if (c2 == 0 || c2 == nmv[c1] - 1) {
      mty[c1][c2] = (-400 - 1200 * r.nextDouble()) * f1 + grnd;
     }
     if (c2 == 1 || c2 == nmv[c1] - 2) {
      mty[c1][c2] = (-1000 - 1450 * r.nextDouble()) * f1 + grnd;
     }
     if (c2 > 1 && c2 < nmv[c1] - 2) {
      mty[c1][c2] = (-1600 - 1700 * r.nextDouble()) * f1 + grnd;
     }
     mty[c1][c2 + nmv[c1]] = grnd + 100;
     mtz[c1][c2] = d2 + mx + d3[c1];
     mtz[c1][c2 + nmv[c1]] = d2 + mx + d3[c1];
     double f2 = .5 + r.nextDouble() * .5;
     mtc[c1][c2][0] = 170 * f2 + 170 * f2 * (snap[0] * .01);
     mtc[c1][c2][1] = rn * f2 + 85 * f2 * (snap[1] * .01);
     mtc[c1][c2][2] = 0;
    }
    for (c2 = 1; c2 < nmv[c1] - 1; c2++) {
     int v1 = c2 - 1;
     int v2 = c2 + 1;
     mty[c1][c2] = ((mty[c1][v1] + mty[c1][v2]) * .5 + mty[c1][c2]) * .5;
    }
    rot(mtx[c1], mtz[c1], d1, d2, rn1, nmv[c1] * 2);
    d4[c1] = 0;
   }
   for (c1 = 0; c1 < nmt; c1++) {
    for (c2 = c1 + 1; c2 < nmt; c2++) {
     if (d3[c1] < d3[c2]) {
      d4[c1]++;
     } else {
      d4[c2]++;
     }
    }
    mrd[d4[c1]] = c1;
   }
  }
 }

 void dmnt(Graphics2D gs) {
  int c;
  int c1;
  for (int i = 0; i < nmt; i++) {
   double d1 = cx + ((mtx[mrd[i]][0] - x / 30. - cx) * cos(xz) - (mtz[mrd[i]][0] - z / 30. - cz) * sin(xz));
   double d2 = cz + ((mtx[mrd[i]][0] - x / 30. - cx) * sin(xz) + (mtz[mrd[i]][0] - z / 30. - cz) * cos(xz));
   double d3 = cz + ((mty[mrd[i]][0] - y / 30. - cy) * sin(zy) + (d2 - cz) * cos(zy));
   double d4 = cx + ((mtx[mrd[i]][nmv[mrd[i]] - 1] - x / 30. - cx) * cos(xz) - (mtz[mrd[i]][nmv[mrd[i]] - 1] - z / 30. - cz) * sin(xz));
   double d5 = cz + ((mtx[mrd[i]][nmv[mrd[i]] - 1] - x / 30. - cx) * sin(xz) + (mtz[mrd[i]][nmv[mrd[i]] - 1] - z / 30. - cz) * cos(xz));
   double d6 = cz + ((mty[mrd[i]][nmv[mrd[i]] - 1] - y / 30. - cy) * sin(zy) + (d5 - cz) * cos(zy));
   if (xs(d4, d6) <= 0 || xs(d1, d3) >= w) {
    continue;
   }
   double[] x0 = new double[nmv[mrd[i]] * 2];
   double[] y0 = new double[nmv[mrd[i]] * 2];
   double[] z0 = new double[nmv[mrd[i]] * 2];
   for (c = 0; c < nmv[mrd[i]] * 2; c++) {
    x0[c] = mtx[mrd[i]][c] - x / 30.;
    y0[c] = (mty[mrd[i]][c] - y / 30.) - 350 + (400 * G.S);
    z0[c] = mtz[mrd[i]][c] - z / 30.;
   }
   rot(x0, z0, cx, cz, xz, nmv[mrd[i]] * 2);
   rot(y0, z0, cy, cz, zy, nmv[mrd[i]] * 2);
   double[] x1 = new double[4];
   double[] y1 = new double[4];
   for (c = 0; c < nmv[mrd[i]] - 1; c++) {
    int[] m = new int[4];
    boolean tf5 = true;
    for (c1 = 0; c1 < 4; c1++) {
     int v1 = c1 + c;
     if (c1 == 2) {
      v1 = c + nmv[mrd[i]] + 1;
     }
     if (c1 == 3) {
      v1 = c + nmv[mrd[i]];
     }
     x1[c1] = xs(x0[v1], z0[v1]);
     y1[c1] = ys(y0[v1], z0[v1]);
     if (y1[c1] < 0 || z0[v1] < 10) {
      m[0]++;
     }
     if (y1[c1] > h || z0[v1] < 10) {
      m[1]++;
     }
     if (x1[c1] < 0 || z0[v1] < 10) {
      m[2]++;
     }
     if (x1[c1] > w || z0[v1] < 10) {
      m[3]++;
     }
    }
    if (m[0] > 3 || m[1] > 3 || m[2] > 3 || m[3] > 3) {
     tf5 = false;
    }
    if (!tf5) {
     continue;
    }
    double r = ((mtc[mrd[i]][c][0] + cgrnd[0]) + csky[0] + cfad[0]) * .25;
    double g = ((mtc[mrd[i]][c][1] + cgrnd[1]) + csky[1] + cfad[1]) * .25;
    double b = ((mtc[mrd[i]][c][2] + cgrnd[2]) + csky[2] + cfad[2]) * .25;
    if ((G.X != 0 || G.Z != 0) && !nosc) {
     r += lAng;
     g += lAng;
     b += lAng;
    }
    G.c(r, g, b);
    pth = new Path2D.Double();
    pth.moveTo(x1[0], y1[0]);
    for (p = 0; p < 4; p++) {
     pth.lineTo(x1[p], y1[p]);
    }
    pth.closePath();
    gs.fill(pth);
   }
  }
 }

 void nwstr() {
  if (stron) {
   stx = null;
   stz = null;
   stc = (double[][][]) null;
   bst = null;
   twn = null;
   nst = 0;
   Random r = new Random((long) (Math.random() * 100000));
   nst = 80;
   if (G.stg == 32 || G.stg == 68) {
    nst = 160;
   }
   if (grv[G.stg] == 0) {
    nst = 4000;
   }
   stx = new double[nst];
   stz = new double[nst];
   sty = new double[nst];
   stc = new double[nst][2][3];
   bst = new boolean[nst];
   twn = new long[nst];
   for (int c = 0; c < nst; c++) {
    stx[c] = (Math.random() * 3000) - (Math.random() * 3000);
    stz[c] = (Math.random() * 3000) - (Math.random() * 3000);
    sty[c] = -200 - (Math.random() * 2000);
    if (grv[G.stg] == 0) {
     sty[c] = (Math.random() * 3000) - (Math.random() * 3000);
    }
    long v1 = (long) (3 * r.nextDouble());
    if (v1 > 2) {
     v1 = 0;
    }
    if (v1 < 0) {
     v1 = 2;
    }
    long v2 = (v1 + 1);
    if (r.nextDouble() > r.nextDouble()) {
     v2 = (v1 - 1);
    }
    if (v2 > 2) {
     v2 = 0;
    }
    if (v2 < 0) {
     v2 = 2;
    }
    for (int b = 0; b < 3; b++) {
     stc[c][0][b] = 200;
     if (v1 == b) {
      stc[c][0][b] += 55 * r.nextDouble();
     }
     if (v2 == b) {
      stc[c][0][b] += 55;
     }
     stc[c][0][b] = (stc[c][0][b] * 2 + csky[b]) * .33;
     stc[c][1][b] = (stc[c][0][b] + csky[b]) * .5;
    }
    twn[c] = (long) (4 * r.nextDouble());
    bst[c] = r.nextDouble() > .8;
   }
  }
 }

 void dstr(Graphics2D gs) {
  int b;
  for (int i = 0; i < nst; i++) {
   double d1 = cx + (stx[i] * cos(xz) - stz[i] * sin(xz));
   double d2 = cz + (stx[i] * sin(xz) + stz[i] * cos(xz));
   double d3 = cy + (sty[i] * cos(zy) - d2 * sin(zy));
   double d4 = cz + (sty[i] * sin(zy) + d2 * cos(zy));
   d1 = xs(d1, d4);
   d3 = ys(d3, d4);
   if (d1 - 1 <= 0 || d1 + 3 >= w || d3 - 1 <= 0 || d3 + 3 >= h) {
    continue;
   }
   if (twn[i] < 1) {
    long r1 = (long) (3 * Math.random());
    if (r1 > 2) {
     r1 = 0;
    }
    if (r1 < 0) {
     r1 = 2;
    }
    long r2 = r1 + 1;
    if (Math.random() < .5) {
     r2 = r1 - 1;
    }
    if (r2 > 2) {
     r2 = 0;
    }
    if (r2 < 0) {
     r2 = 2;
    }
    for (b = 0; b < 3; b++) {
     stc[i][0][b] = 200;
     if (r1 == b) {
      stc[i][0][b] += 55 * Math.random();
     }
     if (r2 == b) {
      stc[i][0][b] += 55;
     }
     stc[i][0][b] = (stc[i][0][b] * 2 + csky[b]) * .33;
     stc[i][1][b] = (stc[i][0][b] + csky[b]) * .5;
    }
    twn[i] = 3;
   } else {
    twn[i]--;
   }
   b = 0;
   if (bst[i]) {
    b = 1;
   }
   G.c(stc[i][1][0], stc[i][1][1], stc[i][1][2]);
   gs.fillRect((int) d1 - 1, (int) d3, 3 + b, 1 + b);
   gs.fillRect((int) d1, (int) d3 - 1, 1 + b, 3 + b);
   G.c(stc[i][0][0], stc[i][0][1], stc[i][0][2]);
   gs.fillRect((int) d1, (int) d3, 1 + b, 1 + b);
  }
 }

 void dF(Graphics2D gs) {
  if (zy > 90) {
   zy = 90;
  }
  if (zy < -90) {
   zy = -90;
  }
  if (xz > 180) {
   xz -= 360;
  }
  if (xz < -180) {
   xz += 360;
  }
  if (y > 0) {
   y = 0;
  }
  if (grnd != 250 - y) {
   grnd = 250 - y;
  }
  mF += G.zz;
  if (mF > 10) {
   mF = 0;
  }
  if (G.X != 0 || G.Z != 0) {
   lAng = (((G.X / (G.Y / 3.)) * sin(xz)) + ((G.Z / (G.Y / 3.)) * cos(xz))) * cos(zy);
  }
  double[] x0 = new double[4];
  double[] y0 = new double[4];
  if (G.stg == 21 || G.stg == 26 || G.stg == 33 || G.stg == 40 || G.stg == 42 || G.stg == 49 || G.stg == 51 || G.stg == 55 || G.stg == 59 || G.stg == 67 || grv[G.stg] == 0) {
   if (G.stg == 42) {
    G.c(Math.random() * 255, Math.random() * 255, Math.random() * 255);
    gs.fillRect(0, 0, (int) w, (int) h);
   } else {
    gs.setColor(new Color(0, 0, 0));
    gs.fillRect(0, 0, (int) w, (int) h);
   }
   if (!nosc && stron && maxD > 2000000000) {
    dstr(gs);
   }
  } else {
   double i = crgrnd[0];
   double j = crgrnd[1];
   double k = crgrnd[2];
   double d = h;
   long n = 1;
   if (fd != null) {
    n = 160;
   }
   int n1;
   for (n1 = 0; n1 < n; n1++) {
    double d1 = grnd * sin(zy);
    double d2 = grnd * cos(zy);
    if (fd != null) {
     d1 += fd[n1] * cos(zy);
     d2 -= fd[n1] * sin(zy);
    }
    d = Math.max(0, Math.min(ys(d2, d1), h));
    if (fd != null && n1 > 0) {
     i = (i * 7 + cfad[0]) * .125;
     j = (j * 7 + cfad[1]) * .125;
     k = (k * 7 + cfad[2]) * .125;
    }
   }
   double r = csky[0];
   double g = csky[1];
   double b = csky[2];
   if ((G.X != 0 || G.Z != 0) && !nosc) {
    r -= lAng;
    g -= lAng;
    b -= lAng;
   }
   double d1 = 0;
   double d2 = 0;
   if (fd != null) {
    hrzn = -4000;
    d1 = cy + ((hrzn - 7000 - cy) * cos(zy) - (7000 - cz) * sin(zy));
    d2 = cz + ((hrzn - 7000 - cy) * sin(zy) + (7000 - cz) * cos(zy));
   } else {
    hrzn = cy;
   }
   d1 = ys(d1, d2);
   double d5 = 0;
   if (fd != null || nosc || atm[G.stg] == 1) {
    for (n1 = 0; n1 < n; n1++) {
     double d3 = cz;
     double d4 = cy;
     if (fd != null && atm[G.stg] != 1) {
      d3 += (-300 - cy) * sin(zy) + (fd[n1] - cz) * cos(zy);
      d4 += (-300 - cy) * cos(zy) - (fd[n1] - cz) * sin(zy);
     } else {
      d3 = hrzn * sin(zy) + 20000 * cos(zy);
      d4 = hrzn * cos(zy) - 20000 * sin(zy);
     }
     x0[0] = 0;
     y0[0] = Math.max(0, Math.min(ys(d4, d3), h));
     x0[1] = 0;
     y0[1] = d5;
     x0[2] = w;
     y0[2] = d5;
     x0[3] = w;
     y0[3] = y0[0];
     d5 = y0[0];
     if (n1 > 0) {
      r = (r * 7 + cfad[0]) * .125;
      g = (g * 7 + cfad[1]) * .125;
      b = (b * 7 + cfad[2]) * .125;
     }
     if (y0[0] > 0 && y0[1] < h) {
      G.c(r, g, b);
      pth = new Path2D.Double();
      pth.moveTo(x0[0], y0[0]);
      for (p = 0; p < 4; p++) {
       pth.lineTo(x0[p], y0[p]);
      }
      pth.closePath();
      gs.fill(pth);
     }
    }
   }
   if (fd != null) {
    x0[0] = 0;
    y0[0] = d5;
    x0[1] = 0;
    y0[1] = d;
    x0[2] = w;
    y0[2] = d;
    x0[3] = w;
    y0[3] = d5;
    if (y0[1] > 0 && y0[0] < h) {
     double f = Math.max(0, Math.min((Math.abs(y) - 250) / (fd[0] * 2.), 1));
     r = (r * (1 - f) + i * (1 + f)) * .5;
     g = (g * (1 - f) + j * (1 + f)) * .5;
     b = (b * (1 - f) + k * (1 + f)) * .5;
     G.c(r, g, b);
     pth = new Path2D.Double();
     pth.moveTo(x0[0], y0[0]);
     for (p = 0; p < 4; p++) {
      pth.lineTo(x0[p], y0[p]);
     }
     pth.closePath();
     gs.fill(pth);
    }
   } else if (!nosc && atm[G.stg] != 1) {
    double fl = Math.random() * .01 - Math.random() * .01;
    if (G.stg == 44) {
     atm[44] += fl;
     atm[44] = Math.max(.75, Math.min(atm[44], 1.05));
    }
    double r0 = r;
    double g0 = g;
    double b0 = b;
    for (n1 = 0; n1 < 100; n1++) {
     double d3 = (hrzn - n1 * 60) * sin(zy) + (20000 * cos(zy));
     double d4 = (hrzn - n1 * 60) * cos(zy) - (20000 * sin(zy));
     x0[0] = 0;
     if (n1 < 99) {
      y0[0] = ys(d4, d3);
      if (y0[0] < 0) {
       y0[0] = 0;
      }
      if (y0[0] > h) {
       y0[0] = h;
      }
     } else {
      y0[0] = 0;
     }
     x0[1] = 0;
     y0[1] = d1;
     x0[2] = w;
     y0[2] = d1;
     x0[3] = w;
     y0[3] = y0[0];
     d1 = y0[0];
     r0 *= atm[G.stg];
     g0 *= atm[G.stg];
     b0 *= atm[G.stg];
     if (y0[1] > 0 && y0[0] < h) {
      G.c(r0, g0, b0);
      pth = new Path2D.Double();
      pth.moveTo(x0[0], y0[0]);
      for (p = 0; p < 4; p++) {
       pth.lineTo(x0[p], y0[p]);
      }
      pth.closePath();
      gs.fill(pth);
     }
    }
   }
   if (!nosc && stron && maxD > 2000000000) {
    dstr(gs);
   }
   r = cgrnd[0];
   g = cgrnd[1];
   b = cgrnd[2];
   if ((G.X != 0 || G.Z != 0) && !nosc) {
    r += lAng * .5;
    g += lAng * .5;
    b += lAng * .5;
   }
   i = crgrnd[0];
   j = crgrnd[1];
   k = crgrnd[2];
   d = h;
   d1 = hrzn * sin(zy) + 20000 * cos(zy);
   d2 = hrzn * cos(zy) - 20000 * sin(zy);
   for (n1 = 0; n1 < n; n1++) {
    if (fd != null) {
     d1 = grnd * sin(zy) + fd[n1] * cos(zy);
     d2 = grnd * cos(zy) - fd[n1] * sin(zy);
    }
    x0[0] = 0;
    y0[0] = Math.max(0, Math.min(ys(d2, d1), h));
    x0[1] = 0;
    y0[1] = d;
    x0[2] = w;
    y0[2] = d;
    x0[3] = w;
    y0[3] = y0[0];
    d = y0[0];
    if (fd != null) {
     if (n1 > 0) {
      i = (i * 7 + cfad[0]) * .125;
      j = (j * 7 + cfad[1]) * .125;
      k = (k * 7 + cfad[2]) * .125;
      if (n1 < 3) {
       r = (r * 7 + cfad[0]) * .125;
       g = (g * 7 + cfad[1]) * .125;
       b = (b * 7 + cfad[2]) * .125;
      } else {
       r = i;
       g = j;
       b = k;
      }
     }
    }
    if (y0[1] > 0 && y0[0] < h) {
     G.c(r, g, b);
     pth = new Path2D.Double();
     pth.moveTo(x0[0], y0[0]);
     for (p = 0; p < 4; p++) {
      pth.lineTo(x0[p], y0[p]);
     }
     pth.closePath();
     gs.fill(pth);
    }
   }
  }
 }

 void dN(Graphics2D gs) {
  if (!nosc) {
   if (mnton && maxD > 1000000 && cld[4] <= -2000) {
    dmnt(gs);
   }
   if (cldon && maxD > 1000000) {
    dcld(gs);
   }
   if (mnton && maxD > 1000000 && cld[4] > -2000) {
    dmnt(gs);
   }
   if (plon && maxD > 5000) {
    dpoly(gs);
   }
  }
  if (G.nCk > 0) {
   for (int c1 = 0; c1 < G.nS; c1++) {
    if (G.typ[c1] == 1 || G.typ[c1] == 2) {
     for (int c2 = 0; c2 < G.nS; c2++) {
      if (G.typ[c2] == 1 || G.typ[c2] == 2) {
       if (c2 != c1 && G.x_z(x + cx, G.x[c2], z + cz, G.z[c2]) < G.x_z(x + cx, G.x[c1], z + cz, G.z[c1])) {
        if ((G.typ[c2] == 1 && z + cz > G.z[c2]) || (G.typ[c2] == 2 && x + cx < G.x[c2])) {
         sgnR = true;
        }
        if ((G.typ[c2] == 1 && z + cz < G.z[c2]) || (G.typ[c2] == 2 && x + cx > G.x[c2])) {
         sgnR = false;
        }
       }
      }
     }
    }
   }
  }
 }

 void snw(Graphics2D gs, double ns) {
  if (!nosc) {
   long sn = 100;
   if (G.stg == 52) {
    sn = 1000;
   }
   for (int n = 0; n < sn; n++) {
    snwvy[n] += cos(zy);
    snwvy[n] += ((Math.random() * 4) - (Math.random() * 4)) * (ns * .02 + 1.);
    snwvx[n] += ((Math.random() * 6) - (Math.random() * 6)) * (ns * .02 + 1.);
    snwvx[n] *= .9;
    snwvy[n] *= .9;
    snwy[n] += snwvy[n] * G.zz;
    snwx[n] += snwvx[n] * G.zz;
    if (snwx[n] < -100) {
     snwx[n] = w + 100;
    }
    if (snwx[n] > w + 100) {
     snwx[n] = -100;
    }
    if (snwy[n] < -100 - Math.random() * 100) {
     snwx[n] = Math.random() * w;
     snwy[n] = h + 100 + (Math.random() * 100);
     snwsz[n] = 1;
     if (Math.random() < .5) {
      snwsz[n] = 2;
     }
    }
    if (snwy[n] > h + 100 + Math.random() * 100) {
     snwx[n] = Math.random() * w;
     snwy[n] = -100 - (Math.random() * 100);
     snwsz[n] = 1;
     if (Math.random() < .5) {
      snwsz[n] = 2;
     }
    }
    double[] x0 = new double[8];
    x0[0] = snwx[n] - snwsz[n];
    x0[1] = snwx[n] + snwsz[n];
    x0[2] = snwx[n] + snwsz[n] * 2.;
    x0[3] = snwx[n] + snwsz[n] * 2.;
    x0[4] = snwx[n] + snwsz[n];
    x0[5] = snwx[n] - snwsz[n];
    x0[6] = snwx[n] - snwsz[n] * 2.;
    x0[7] = snwx[n] - snwsz[n] * 2.;
    double[] y0 = new double[8];
    y0[0] = snwy[n] - snwsz[n] * 2.;
    y0[1] = snwy[n] - snwsz[n] * 2.;
    y0[2] = snwy[n] - snwsz[n];
    y0[3] = snwy[n] + snwsz[n];
    y0[4] = snwy[n] + snwsz[n] * 2.;
    y0[5] = snwy[n] + snwsz[n] * 2.;
    y0[6] = snwy[n] + snwsz[n];
    y0[7] = snwy[n] - snwsz[n];
    gs.setColor(new Color(255, 255, 255));
    pth = new Path2D.Double();
    pth.moveTo(x0[0], y0[0]);
    for (p = 0; p < 8; p++) {
     pth.lineTo(x0[p], y0[p]);
    }
    pth.closePath();
    gs.fill(pth);
   }
  }
 }

 void stsnp(long r, long g, long b) {
  snap[0] = r;
  snap[1] = g;
  snap[2] = b;
 }

 void stsky(long r, long g, long b) {
  osky[0] = r;
  osky[1] = g;
  osky[2] = b;
  for (int c = 0; c < 3; c++) {
   clds[c] = (osky[c] * cld[3] + cld[c]) / (cld[3] + 1);
   clds[c] = clds[c] + clds[c] * (snap[c] * .01);
  }
  csky[0] = r + r * (snap[0] * .01);
  csky[1] = g + g * (snap[1] * .01);
  csky[2] = b + b * (snap[2] * .01);
  if (csky[0] < 0) {
   csky[0] = 0;
  }
  if (csky[0] > 255) {
   csky[0] = 255;
  }
  if (csky[1] < 0) {
   csky[1] = 0;
  }
  if (csky[1] > 255) {
   csky[1] = 255;
  }
  if (csky[2] < 0) {
   csky[2] = 0;
  }
  if (csky[2] > 255) {
   csky[2] = 255;
  }
  float[] c = new float[3];
  Color.RGBtoHSB((int) csky[0], (int) csky[1], (int) csky[2], c);
 }

 void stcld(long r, long g, long b, long t, long h) {
  cld[0] = r;
  cld[1] = g;
  cld[2] = b;
  cld[3] = t;
  cld[4] = h;
  for (int c = 0; c < 3; c++) {
   clds[c] = (osky[c] * cld[3] + cld[c]) / (cld[3] + 1);
   clds[c] = clds[c] + clds[c] * (snap[c] * .01);
  }
 }

 void stgrnd(long r, long g, long b) {
  int c;
  ogrnd[0] = r;
  ogrnd[1] = g;
  ogrnd[2] = b;
  for (c = 0; c < 3; c++) {
   cpol[c] = Math.max(0, Math.min((ogrnd[c] * textr[3] + textr[c]) / (1 + textr[3]), 255));
   cpol[c] = Math.max(0, Math.min(cpol[c] + cpol[c] * (snap[c] * .01), 255));
  }
  cgrnd[0] = Math.max(0, Math.min(r + r * (snap[0] * .01), 255));
  cgrnd[1] = Math.max(0, Math.min(g + g * (snap[1] * .01), 255));
  cgrnd[2] = Math.max(0, Math.min(b + b * (snap[2] * .01), 255));
  for (c = 0; c < 3; c++) {
   crgrnd[c] = (cpol[c] + cgrnd[c]) * .5;
  }
 }

 void stpoly(long r, long g, long b) {
  cpol[0] = Math.max(0, Math.min(r + r * (snap[0] * .01), 255));
  cpol[1] = Math.max(0, Math.min(g + g * (snap[1] * .01), 255));
  cpol[2] = Math.max(0, Math.min(b + b * (snap[2] * .01), 255));
  for (int c = 0; c < 3; c++) {
   crgrnd[c] = (cpol[c] * .99 + cgrnd[c]) * .5;
  }
 }

 void stxtur(long r, long g, long b, long t) {
  textr[0] = r;
  textr[1] = g;
  textr[2] = b;
  textr[3] = t;
  r = (ogrnd[0] * t + r) / (1 + t);
  g = (ogrnd[1] * t + g) / (1 + t);
  b = (ogrnd[2] * t + b) / (1 + t);
  cpol[0] = Math.max(0, Math.min(r + r * (snap[0] * .01), 255));
  cpol[1] = Math.max(0, Math.min(g + g * (snap[1] * .01), 255));
  cpol[2] = Math.max(0, Math.min(b + b * (snap[2] * .01), 255));
  for (int c = 0; c < 3; c++) {
   crgrnd[c] = (cpol[c] * .99 + cgrnd[c]) * .5;
  }
 }

 void setfd(long r, long g, long b) {
  cfad[0] = r + r * (snap[0] * .01);
  cfad[1] = g + g * (snap[1] * .01);
  cfad[2] = b + b * (snap[2] * .01);
 }

 void fdfrm(long d) {
  fd = new long[160];
  for (int b = 1; b < 160; b++) {
   fd[b] = b * (d / 10) + d;
  }
  if (d < 1) {
   fd = null;
   cfad[0] = cgrnd[0];
   cfad[1] = cgrnd[1];
   cfad[2] = cgrnd[2];
  }
 }

 double sin(double s) {
  return Math.sin(s * .01745329251994329576923690768489);
 }

 double cos(double c) {
  return Math.cos(c * .01745329251994329576923690768489);
 }

 void rot(double a[], double b[], double c, double d, double e, long f) {
  if (e != 0) {
   for (int g = 0; g < f; g++) {
    double i = a[g];
    double j = b[g];
    a[g] = c + ((i - c) * cos(e) - (j - d) * sin(e));
    b[g] = d + ((i - c) * sin(e) + (j - d) * cos(e));
   }
  }
 }

 double xs(double a, double b) {
  b = Math.max(.01, b);
  return ((b - (fcs_pnt * zm)) * (cx - a)) / b + a;
 }

 double ys(double a, double b) {
  b = Math.max(.01, b);
  return ((b - (fcs_pnt * zm)) * (cy - a)) / b + a;
 }
}
