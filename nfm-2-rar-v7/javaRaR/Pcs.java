
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;

public class Pcs {

 Mdm M;
 Track T;
 Path2D pth;
 int p;
 double ox[];
 double oy[];
 double oz[];
 int n;
 double c[];
 double oc[];
 float hsb[];
 long gr;
 long fs;
 String typ;
 boolean flyn;
 boolean nol;
 long flkn;
 double wx;
 double wz;
 double wy;
 double dltf;
 double prjf;
 long av;
 double chip;
 double chmg;
 double cxz;
 double cxy;
 double czy;
 double cox[];
 double coz[];
 double coy[];
 double dx;
 double dy;
 double dz;
 double vx;
 double vy;
 double vz;
 long fir;
 long ltyp;
 int brnt;
 boolean phntm;

 Pcs(Mdm m, Track t, double a_ox[], double a_oz[], double a_oy[], long a_n, double a_oc[], long a_gr, long a_fs, double a_wx, double a_wy, double a_wz, String a_typ, boolean a_nol) {
  c = new double[3];
  oc = new double[3];
  hsb = new float[3];
  dltf = 1;
  prjf = 1;
  cox = new double[3];
  coz = new double[3];
  coy = new double[3];
  M = m;
  T = t;
  n = (int) a_n;
  ox = new double[n];
  oz = new double[n];
  oy = new double[n];
  int c1;
  for (c1 = 0; c1 < n; c1++) {
   ox[c1] = a_ox[c1];
   oy[c1] = a_oy[c1];
   oz[c1] = a_oz[c1];
  }
  for (c1 = 0; c1 < 3; c1++) {
   oc[c1] = a_oc[c1];
  }
  if (a_typ == "drtlnlit") {
   double v1 = Math.random() * 40 - 20;
   double v2 = Math.random() * 40 - 20;
   for (c1 = 0; c1 < n; c1++) {
    ox[c1] += v1;
    oz[c1] += v2;
   }
   double v3 = 185 + (Math.random() * 20);
   a_oc[0] = (217 + v3) * .5;
   a_oc[1] = (189 + v3) * .5;
   a_oc[2] = (132 + v3) * .5;
   for (c1 = 0; c1 < n; c1++) {
    if (Math.random() < .5) {
     ox[c1] += 8 * Math.random() - 4;
    }
    if (Math.random() < .5) {
     oy[c1] += 8 * Math.random() - 4;
    }
    if (Math.random() < .5) {
     oz[c1] += 8 * Math.random() - 4;
    }
   }
  }
  for (c1 = 0; c1 < 3; c1++) {
   c[c1] = Math.max(0, Math.min(a_oc[c1] + a_oc[c1] * (M.snap[c1] * .01), 255));
   if (a_typ.contains("clr")) {
    c[c1] = M.csky[c1];
   }
   if (a_typ == "gshdw") {
    c[c1] = M.crgrnd[c1] * .925;
   }
   if (a_typ == "pil") {
    c[c1] = a_oc[c1];
   }
  }
  Color.RGBtoHSB((int) c[0], (int) c[1], (int) c[2], hsb);
  if (a_typ == "pil") {
   hsb[1] += .05;
   hsb[1] = Math.min(hsb[1], 1);
  }
  typ = a_typ;
  nol = a_nol;
  gr = a_gr;
  fs = a_fs;
  wx = a_wx;
  wy = a_wy;
  wz = a_wz;
  double x0 = Math.abs(ox[2] - ox[1]);
  double y0 = Math.abs(oy[2] - oy[1]);
  double z0 = Math.abs(oz[2] - oz[1]);
  if (y0 <= x0 && y0 <= z0) {
   ltyp = 2;
  }
  if (x0 <= y0 && x0 <= z0) {
   ltyp = 1;
  }
  if (z0 <= x0 && z0 <= y0) {
   ltyp = 3;
  }
  dltf = 1;
  for (c1 = 0; c1 < 3; c1++) {
   for (int c2 = 0; c2 < 3; c2++) {
    if (c2 != c1) {
     dltf *= Math.sqrt(Math.pow(ox[c2] - ox[c1], 2) + Math.pow(oy[c2] - oy[c1], 2) + Math.pow(oz[c2] - oz[c1], 2)) * .01;
    }
   }
  }
  dltf *= .33;
 }

 void lpj(Game G) {
  prjf = 1;
  if (M.grv[G.stg] != 0 && G.stg != 39 && G.stg != 44 && G.stg != 55 && G.stg != 67) {
   for (int a = 0; a < 3; a++) {
    for (int b = 0; b < 3; b++) {
     if (b != a) {
      prjf *= Math.sqrt(Math.pow(ox[a] - ox[b], 2) + Math.pow(oz[a] - oz[b], 2)) * .01;
     }
    }
   }
  }
  prjf *= .33;
 }

 void d(Graphics2D gs, Act a, Game G) {
  int c1;
  int c2;
  double x = a.x - M.x;
  double y = a.y - M.y;
  double z = a.z - M.z;
  double[] x0 = new double[n];
  double[] z0 = new double[n];
  double[] y0 = new double[n];
  boolean ceng = false;
  if ((flkn < 1 || flkn > 2) && M.crs) {
   if (G.flk) {
    flkn = 2;
   } else {
    flkn = 1;
   }
  }
  if (typ == "chwrd" || typ == "chsg" || typ == "fnsh") {
   ceng = a.chk != 0 && a.chk - 1 == M.cp;
  }
  if ((typ == "chwrd" || typ == "chsg" || typ == "fnsh") && M.sgnR) {
   for (c1 = 0; c1 < n; c1++) {
    x0[c1] = -ox[c1] + x;
    y0[c1] = oy[c1] + y;
    z0[c1] = -oz[c1] + z;
   }
  } else {
   for (c1 = 0; c1 < n; c1++) {
    x0[c1] = ox[c1] + x;
    y0[c1] = oy[c1] + y;
    z0[c1] = oz[c1] + z;
   }
  }
  if (fir < Math.random() * 16 && !M.crs) {
   flkn++;
   if (flkn > 2) {
    flkn = 1;
   }
  }
  if (fir > 0) {
   if (fir < 12 && Math.random() < .5) {
    for (c1 = 0; c1 < n; c1++) {
     x0[c1] = (ox[c1] + x) + (15 - Math.random() * 30);
     y0[c1] = (oy[c1] + y) + (15 - Math.random() * 30);
     z0[c1] = (oz[c1] + z) + (15 - Math.random() * 30);
    }
    rot(x0, y0, x, y, a.xy, n);
    rot(y0, z0, y, z, a.zy, n);
    rot(x0, z0, x, z, a.xz, n);
    rot(x0, z0, M.cx, M.cz, M.xz, n);
    rot(y0, z0, M.cy, M.cz, M.zy, n);
    double[] x1 = new double[n];
    double[] y1 = new double[n];
    for (c1 = 0; c1 < n; c1++) {
     x1[c1] = M.xs(x0[c1], z0[c1]);
     y1[c1] = M.ys(y0[c1], z0[c1]);
    }
    gs.setColor(new Color(255, 255, 255));
    pth = new Path2D.Double();
    pth.moveTo(x1[0], y1[0]);
    for (p = 0; p < n; p++) {
     pth.lineTo(x1[p], y1[p]);
    }
    pth.closePath();
    gs.fill(pth);
   }
   if (Math.abs(12 - fir) < 2 && chip <= 0) {
    if (chip < 1) {
     chip = 1;
    }
    chmg = 3;
   }
   if (fir == 16) {
    brnt = (int) (Math.random() * n);
   }
   if (fir > 15 && Math.random() < .5) {
    long mzy = 1;
    long mxy = 1;
    if (Math.abs(a.zy) > 90) {
     mzy = -1;
    }
    if (Math.abs(a.xy) > 90) {
     mxy = -1;
    }
    double[] x1 = new double[3];
    double[] y1 = new double[3];
    x0[0] = ox[brnt] + x;
    y0[0] = oy[brnt] + y;
    z0[0] = oz[brnt] + z;
    x0[1] = x;
    y0[1] = y;
    if (Math.abs(x0[0] - x0[1]) > 100) {
     if (x0[1] > x0[0]) {
      x0[1] -= Math.abs(x0[0] - x0[1]);
     } else {
      x0[1] += Math.abs(x0[0] - x0[1]);
     }
    }
    if (Math.abs(z0[0] - z0[1]) > 100) {
     if (z0[1] > z0[0]) {
      z0[1] -= Math.abs(z0[0] - z0[1]);
     } else {
      z0[1] += Math.abs(z0[0] - z0[1]);
     }
    }
    if (Math.abs(y0[0] - y0[1]) > 100) {
     if (y0[1] > y0[0]) {
      y0[1] -= Math.abs(y0[0] - y0[1]);
     } else {
      y0[1] += Math.abs(y0[0] - y0[1]);
     }
    }
    x0[2] = (x0[0] + x0[1]) * .5 + (Math.random() * 64) - ((Math.random() * 64));
    z0[2] = (z0[0] + z0[1]) * .5 + (Math.random() * 127) - ((Math.random() * 127));
    y0[2] = (y0[0] + y0[1]) * .5 - mzy * mxy * (((Math.abs(x0[0] - x0[1]) + Math.abs(z0[0] - z0[1])) * .66) * ((Math.random() * .5) + .5)) + (Math.random() * 64) - ((Math.random() * 64));
    rot(x0, y0, x, y, a.xy, 3);
    rot(y0, z0, y, z, a.zy, 3);
    rot(x0, z0, x, z, a.xz, 3);
    rot(x0, z0, M.cx, M.cz, M.xz, 3);
    rot(y0, z0, M.cy, M.cz, M.zy, 3);
    for (c1 = 0; c1 < 3; c1++) {
     x1[c1] = M.xs(x0[c1], z0[c1]);
     y1[c1] = M.ys(y0[c1], z0[c1]);
    }
    G.c(255, 128 + (Math.random() * 100), (Math.random() * 64));
    pth = new Path2D.Double();
    pth.moveTo(x1[0], y1[0]);
    for (p = 0; p < 3; p++) {
     pth.lineTo(x1[p], y1[p]);
    }
    pth.closePath();
    gs.fill(pth);
   }
   for (c1 = 0; c1 < n; c1++) {
    if (ltyp == 1) {
     x0[c1] = ox[c1] + x;
    } else {
     x0[c1] = ox[c1] + x;
    }
    if (ltyp == 2) {
     y0[c1] = oy[c1] + y;
    } else {
     y0[c1] = oy[c1] + y;
    }
    if (ltyp == 3) {
     z0[c1] = oz[c1] + z;
    } else {
     z0[c1] = oz[c1] + z;
    }
   }
   fir += G.zz;
   if (fir < Math.random() * 100) {
    fir = 16;
   }
  }
  if (G.stg == 44) {
   fir += G.zz;
   if (fir < Math.random() * 100) {
    fir = 16;
   }
  } else if (M.crs) {
   fir = 0;
  }
  if (wz != 0) {
   if (ox[0] > 0) {
    rot(y0, z0, wy + y, wz + z, a.wrot[0], n);
   }
   if (ox[0] < 0) {
    rot(y0, z0, wy + y, wz + z, a.wrot[1], n);
   }
  }
  if (wx != 0) {
   rot(x0, z0, wx + x, wz + z, a.wxz, n);
  }
  if (chip == 1 && Math.random() > .6) {
   chip = 0;
  }
  if (chip > 0) {
   if (chip == 1) {
    cxz = a.xz;
    cxy = a.xy;
    czy = a.zy;
    c1 = (int) (Math.random() * n);
    cox[0] = ox[c1];
    coz[0] = oz[c1];
    coy[0] = oy[c1];
    if (chmg > 3) {
     chmg = 3;
    }
    if (chmg < -3) {
     chmg = -3;
    }
    cox[1] = cox[0] + chmg * (10 - (Math.random() * 20));
    cox[2] = cox[0] + chmg * (10 - (Math.random() * 20));
    coy[1] = coy[0] + chmg * (10 - (Math.random() * 20));
    coy[2] = coy[0] + chmg * (10 - (Math.random() * 20));
    coz[1] = coz[0] + chmg * (10 - (Math.random() * 20));
    coz[2] = coz[0] + chmg * (10 - (Math.random() * 20));
    dx = 0;
    dy = 0;
    dz = 0;
    vx = chmg * (30 - (Math.random() * 60));
    vz = chmg * (30 - (Math.random() * 60));
    vy = chmg * (30 - (Math.random() * 60));
    chip = 2;
   }
   double[] x1 = new double[3];
   double[] z1 = new double[3];
   double[] y1 = new double[3];
   for (c1 = 0; c1 < 3; c1++) {
    x1[c1] = cox[c1] + x;
    y1[c1] = coy[c1] + y;
    z1[c1] = coz[c1] + z;
   }
   rot(x1, y1, x, y, cxy, 3);
   rot(y1, z1, y, z, czy, 3);
   rot(x1, z1, x, z, cxz, 3);
   for (c1 = 0; c1 < 3; c1++) {
    x1[c1] += dx;
    y1[c1] += dy;
    z1[c1] += dz;
   }
   dx += vx;
   dz += vz;
   dy += vy;
   vy += M.grv[G.stg];
   if (y1[0] > M.grnd) {
    chip = 19;
   }
   rot(x1, z1, M.cx, M.cz, M.xz, 3);
   rot(y1, z1, M.cy, M.cz, M.zy, 3);
   double[] x2 = new double[3];
   double[] y2 = new double[3];
   for (c1 = 0; c1 < 3; c1++) {
    x2[c1] = M.xs(x1[c1], z1[c1]);
    y2[c1] = M.ys(y1[c1], z1[c1]);
   }
   c1 = (int) (Math.random() * 3);
   if (c1 == 0) {
    gs.setColor((new Color((int) Math.max(0, Math.min(c[0], 255)), (int) Math.max(0, Math.min(c[1], 255)), (int) Math.max(0, Math.min(c[2], 255)))).darker());
   }
   if (c1 == 1) {
    G.c(c[0], c[1], c[2]);
   }
   if (c1 == 2) {
    gs.setColor((new Color((int) Math.max(0, Math.min(c[0], 255)), (int) Math.max(0, Math.min(c[1], 255)), (int) Math.max(0, Math.min(c[2], 255)))).brighter());
   }
   pth = new Path2D.Double();
   pth.moveTo(x2[0], y2[0]);
   for (p = 0; p < 3; p++) {
    pth.lineTo(x2[p], y2[p]);
   }
   pth.closePath();
   gs.fill(pth);
   chip += G.zz;
   if (chip > 19) {
    chip = 0;
   }
  }
  rot(x0, y0, x, y, a.xy, n);
  rot(y0, z0, y, z, a.zy, n);
  rot(x0, z0, x, z, a.xz, n);
  if (a.shdo) {
   prjf = 1;
   if (M.grv[G.stg] != 0 && G.stg != 39 && G.stg != 44 && G.stg != 55 && G.stg != 67) {
    for (c1 = 0; c1 < 3; c1++) {
     for (c2 = 0; c2 < 3; c2++) {
      if (c2 != c1) {
       prjf *= Math.sqrt(Math.pow(x0[c1] - x0[c2], 2) + Math.pow(z0[c1] - z0[c2], 2)) * .01;
      }
     }
    }
   }
   prjf *= .33;
  }
  rot(x0, z0, M.cx, M.cz, M.xz, n);
  boolean shdd = false;
  double[] x1 = new double[n];
  double[] y1 = new double[n];
  double v10 = 500;
  for (c1 = 0; c1 < n; c1++) {
   x1[c1] = M.xs(x0[c1], z0[c1]);
   y1[c1] = M.ys(y0[c1], z0[c1]);
  }
  int v11 = 0;
  int v12 = 1;
  for (c1 = 0; c1 < n; c1++) {
   for (c2 = c1; c2 < n; c2++) {
    if (c1 != c2 && Math.abs(x1[c1] - x1[c2]) - Math.abs(y1[c1] - y1[c2]) < v10) {
     v12 = c1;
     v11 = c2;
     v10 = Math.abs(x1[c1] - x1[c2]) - Math.abs(y1[c1] - y1[c2]);
    }
   }
  }
  if (y1[v11] < y1[v12]) {
   int v13 = v11;
   v11 = v12;
   v12 = v13;
  }
  if (cx_y_S(x0[v11], z0[v11]) > cx_y_S(x0[v12], z0[v12])) {
   shdd = true;
   c2 = 0;
   for (c1 = 0; c1 < n; c1++) {
    if (z0[c1] < 50 && y0[c1] > M.cy) {
     shdd = false;
     continue;
    }
    if (y0[c1] == y0[0]) {
     c2++;
    }
   }
   if (c2 >= n && y0[0] > M.cy) {
    shdd = false;
   }
  }
  rot(y0, z0, M.cy, M.cz, M.zy, n);
  boolean dp = true;
  double[] x2 = new double[n];
  double[] y2 = new double[n];
  long[] m = new long[4];
  for (c1 = 0; c1 < n; c1++) {
   x2[c1] = M.xs(x0[c1], z0[c1]);
   y2[c1] = M.ys(y0[c1], z0[c1]);
   if (y2[c1] < 0 || z0[c1] < 10) {
    m[0]++;
   }
   if (y2[c1] > M.h || z0[c1] < 10) {
    m[1]++;
   }
   if (x2[c1] < 0 || z0[c1] < 10) {
    m[2]++;
   }
   if (x2[c1] > M.w || z0[c1] < 10) {
    m[3]++;
   }
  }
  if (m[0] >= n || m[1] >= n || m[2] >= n || m[3] >= n) {
   dp = false;
  }
  if (dp && M.GR > 0 && !ceng && !(M.liton && typ.contains("lit")) && !typ.contains("Lit")) {
   double pdx = 0;
   double pdy = 0;
   for (c1 = 0; c1 < n; c1++) {
    for (c2 = c1; c2 < n; c2++) {
     if (c1 == c2) {
      continue;
     }
     if (Math.abs(x2[c1] - x2[c2]) > pdx) {
      pdx = Math.abs(x2[c1] - x2[c2]);
     }
     if (Math.abs(y2[c1] - y2[c2]) > pdy) {
      pdy = Math.abs(y2[c1] - y2[c2]);
     }
    }
   }
   if (pdx <= M.GR && pdy <= M.GR) {
    dp = false;
   }
  }
  if (dp) {
   long q = 1;
   long mgr = gr;
   if (typ == "chwrd" || typ == "chsg") {
    mgr = -90;
   }
   if (typ == "pvlit" || typ == "drtlnlit") {
    mgr = -50;
   }
   if (typ == "gshdw") {
    mgr = 200;
   }
   if (fs != 0) {
    int b2;
    int b3;
    if (Math.abs(y2[0] - y2[1]) > Math.abs(y2[2] - y2[1])) {
     b2 = 0;
     b3 = 2;
    } else {
     b2 = 2;
     b3 = 0;
     q *= -1;
    }
    if (y2[1] > y2[b2]) {
     q *= -1;
    }
    if (x2[1] > x2[b3]) {
     q *= -1;
    }
    q *= fs;
    if (q == -1) {
     mgr += 40;
     q = 0;
    }
   }
   double v1 = y0[0];
   double v2 = y0[0];
   double v3 = x0[0];
   double v4 = x0[0];
   double v5 = z0[0];
   double v6 = z0[0];
   for (c1 = 0; c1 < n; c1++) {
    if (v1 < y0[c1]) {
     v1 = y0[c1];
    }
    if (v2 > y0[c1]) {
     v2 = y0[c1];
    }
    if (v3 < x0[c1]) {
     v3 = x0[c1];
    }
    if (v4 > x0[c1]) {
     v4 = x0[c1];
    }
    if (v5 < z0[c1]) {
     v5 = z0[c1];
    }
    if (v6 > z0[c1]) {
     v6 = z0[c1];
    }
   }
   double v7 = (v1 + v2) * .5;
   double v8 = (v3 + v4) * .5;
   double v9 = (v5 + v6) * .5;
   av = (long) Math.sqrt(Math.pow(M.cy - v7, 2) + Math.pow(M.cx - v8, 2) + Math.pow(v9, 2) + Math.pow(mgr, 3));
   if (!M.cldon && !M.mnton && !M.stron && M.fd != null) {
    if (av > M.fd[159]) {
     dp = false;
    }
   }
   if (typ == "fnsh" && (!M.fchk || !ceng)) {
    dp = false;
   }
   if ((typ == "chsg" || typ == "pvlit" || typ == "drtlnlit") && (shdd || q == 0)) {
    dp = false;
   }
   if (a.fcnt > 0 && Math.random() > .3) {
    dp = false;
   }
  }
  if (dp) {
   double f1 = (prjf / dltf) + .3;
   if (a.avrg && !nol) {
    boolean litn = false;
    if (f1 > 1) {
     if (f1 >= 1.27) {
      litn = true;
     }
     f1 = 1;
    }
    if (litn) {
     f1 *= .89;
    } else {
     f1 *= .86;
    }
    if (f1 < .37) {
     f1 = .37;
    }
    if (typ == "hp1") {
     f1 = .74;
    }
    if (typ == "hp3") {
     f1 = .62;
    }
    if (!typ.contains("drt") && shdd) {
     f1 = .32;
    }
    if (typ == "hp2") {
     f1 = .55;
    }
    if (gr == -8 || typ == "pvlit" || typ == "drtlnlit") {
     f1 = 1;
    }
    if (typ == "chwrd" || typ == "chsg") {
     f1 = .6;
     if (ceng) {
      if (G.flk) {
       f1 = 1;
      } else {
       f1 = .75;
      }
     }
    }
    if (typ == "fnsh" && ceng) {
     if (G.flk) {
      f1 = 0;
     } else {
      f1 = 1;
     }
    }
   } else {
    f1 = Math.min(f1, 1);
    if (f1 < .6 || (shdd && M.grv[G.stg] != 0 && G.stg != 39 && G.stg != 44 && G.stg != 55 && G.stg != 67)) {
     f1 = .6;
    }
   }
   Color color = Color.getHSBColor(hsb[0], hsb[1], (float) (hsb[2] * f1));
   double r = color.getRed();
   double g = color.getGreen();
   double b = color.getBlue();
   if ((G.X != 0 || G.Z != 0) && !M.nosc) {
    r += M.lAng * .5;
    g += M.lAng * .5;
    b += M.lAng * .5;
   }
   if ((((M.liton && typ.contains("lit")) || typ.contains("Lit")) && fir <= 0) || typ == "chwrd" || typ == "chsg") {
    r = oc[0];
    g = oc[1];
    b = oc[2];
    if (r == g && g == b) {
     r = 255;
     g = 255;
     b = 255;
    }
   }
   if (G.stg == 42) {
    r = Math.random() * 255;
    g = Math.random() * 255;
    b = Math.random() * 255;
   }
   if (M.fd != null) {
    for (c1 = 0; c1 < 160; c1++) {
     if (((!(M.liton && typ.contains("lit")) && !typ.contains("Lit")) || fir > 0) && av > M.fd[c1]) {
      r = (r * M.dnst + M.cfad[0]) / (M.dnst + 1.);
      g = (g * M.dnst + M.cfad[1]) / (M.dnst + 1.);
      b = (b * M.dnst + M.cfad[2]) / (M.dnst + 1.);
     }
    }
   }
   if (phntm) {
    gs.setColor(new Color(255, 255, 255, 32));
   } else {
    G.c(r, g, b);
   }
   if (a.fcnt > 0 || G.stg == 42) {
    r = Math.random() * 255;
    g = Math.random() * 255;
    b = Math.random() * 255;
   }
   if (typ != "nul" && !((typ == "flk1" || typ == "flkLit1") && flkn == 2) && !((typ == "flk2" || typ == "flkLit2") && flkn == 1) && !(typ == "lndngr" && flyn)) {
    pth = new Path2D.Double();
    pth.moveTo(x2[0], y2[0]);
    for (p = 0; p < n; p++) {
     pth.lineTo(x2[p], y2[p]);
    }
    pth.closePath();
    gs.fill(pth);
    if (!(nol || phntm) && a.shdo && av < 3400) {
     double d = Math.max(.8, Math.min(av * .0002857, 1));
     r *= d;
     g *= d;
     b *= d;
     G.c(r, g, b);
     pth = new Path2D.Double();
     pth.moveTo(x2[0], y2[0]);
     for (p = 0; p < n; p++) {
      pth.lineTo(x2[p], y2[p]);
     }
     pth.closePath();
     gs.draw(pth);
    }
   }
   if (typ == "glw" && fir <= 0) {
    gs.setColor(new Color(255, 255, 255));
    pth = new Path2D.Double();
    pth.moveTo(x2[0], y2[0]);
    for (p = 0; p < n; p++) {
     pth.lineTo(x2[p], y2[p]);
    }
    pth.closePath();
    gs.draw(pth);
   }
   if ((typ.contains("blnk") && fir <= 0) || G.stg == 26) {
    int s = (int) (Math.random() * 255);
    gs.setColor(new Color(s, s, s));
    pth = new Path2D.Double();
    pth.moveTo(x2[0], y2[0]);
    for (p = 0; p < n; p++) {
     pth.lineTo(x2[p], y2[p]);
    }
    pth.closePath();
    gs.draw(pth);
   }
  }
 }

 void s(Graphics2D gs, Act a, boolean onT, Game G) {
  if (!phntm && !((typ == "flk1" || typ == "flkLit1") && flkn == 2) && !((typ == "flk2" || typ == "flkLit2") && flkn == 1) && !(typ == "lndngr" && flyn)) {
   int c1;
   int c2;
   double[] x0 = new double[n];
   double[] z0 = new double[n];
   double[] y0 = new double[n];
   for (c1 = 0; c1 < n; c1++) {
    x0[c1] = ox[c1] + (a.x - M.x);
    y0[c1] = oy[c1] + (a.y - M.y);
    z0[c1] = oz[c1] + (a.z - M.z);
   }
   if (wx != 0) {
    rot(x0, z0, wx + a.x - M.x, wz + a.z - M.z, a.wxz, n);
   }
   rot(x0, y0, a.x - M.x, a.y - M.y, a.xy, n);
   rot(y0, z0, a.y - M.y, a.z - M.z, a.zy, n);
   rot(x0, z0, a.x - M.x, a.z - M.z, a.xz, n);
   double r = M.crgrnd[0] * .66;
   double g = M.crgrnd[1] * .66;
   double b = M.crgrnd[2] * .66;
   double h = Math.max(0, (250 - a.y) * .01);
   for (c1 = 0; c1 < n; c1++) {
    y0[c1] = M.grnd;
    if ((G.X != 0 || G.Z != 0) && !M.nosc) {
     x0[c1] += (a.x - G.X) / (-G.Y * .01) * h;
     z0[c1] += (a.z - G.Z) / (-G.Y * .01) * h;
    }
   }
   long[] m1 = new long[4];
   if (onT) {
    double[] m = new double[4];
    for (c1 = 0; c1 < n; c1++) {
     for (c2 = 0; c2 < n; c2++) {
      if (x0[c1] >= x0[c2]) {
       m1[0]++;
      }
      if (x0[c1] <= x0[c2]) {
       m1[1]++;
      }
      if (z0[c1] >= z0[c2]) {
       m1[2]++;
      }
      if (z0[c1] <= z0[c2]) {
       m1[3]++;
      }
     }
     if (m1[0] >= n) {
      m[0] = x0[c1];
     }
     if (m1[1] >= n) {
      m[1] = x0[c1];
     }
     if (m1[2] >= n) {
      m[2] = z0[c1];
     }
     if (m1[3] >= n) {
      m[3] = z0[c1];
     }
    }
    double v1 = (m[0] + m[1]) * .5;
    double v2 = (m[2] + m[3]) * .5;
    int v3 = T.nt - 1;
    while (true) {
     if (v3 < 0) {
      break;
     }
     boolean tf = false;
     if (Math.abs(T.zy[v3]) < 60 && Math.abs(T.xy[v3]) < 60 && Math.abs(v1 - (T.x[v3] - M.x)) < T.radx[v3] && Math.abs(v2 - (T.z[v3] - M.z)) < T.radz[v3] && (!T.scn[v3] || !M.nosc)) {
      tf = true;
     }
     if (tf) {
      for (c1 = 0; c1 < n; c1++) {
       y0[c1] = (T.y[v3] - M.y);
       if (T.zy[v3] != 0) {
        y0[c1] += ((z0[c1] - (T.z[v3] - M.z - T.radz[v3])) * M.sin(T.zy[v3])) / M.sin((90 - T.zy[v3])) - (T.radz[v3] * M.sin(T.zy[v3])) / M.sin((90 - T.zy[v3]));
       }
       if (T.xy[v3] != 0) {
        y0[c1] += ((x0[c1] - (T.x[v3] - M.x - T.radx[v3])) * M.sin(T.xy[v3])) / M.sin((90 - T.xy[v3])) - (T.radx[v3] * M.sin(T.xy[v3])) / M.sin((90 - T.xy[v3]));
       }
      }
      r = T.c[v3][0] * .66;
      g = T.c[v3][1] * .66;
      b = T.c[v3][2] * .66;
      break;
     }
     v3--;
    }
   }
   boolean tf = true;
   double[] x1 = new double[n];
   double[] y1 = new double[n];
   if (tf) {
    rot(x0, z0, M.cx, M.cz, M.xz, n);
    rot(y0, z0, M.cy, M.cz, M.zy, n);
    m1[0] = 0;
    m1[1] = 0;
    m1[2] = 0;
    m1[3] = 0;
    for (c1 = 0; c1 < n; c1++) {
     if (M.fd != null) {
      if (Math.abs(y0[c1] - M.y) > M.fd[159]) {
       tf = false;
      }
     }
     x1[c1] = M.xs(x0[c1], z0[c1]);
     y1[c1] = M.ys(y0[c1], z0[c1]);
     if (y1[c1] < 0 || z0[c1] < 10) {
      m1[0]++;
     }
     if (y1[c1] > M.h || z0[c1] < 10) {
      m1[1]++;
     }
     if (x1[c1] < 0 || z0[c1] < 10) {
      m1[2]++;
     }
     if (x1[c1] > M.w || z0[c1] < 10) {
      m1[3]++;
     }
    }
    if (m1[0] >= n || m1[1] >= n || m1[2] >= n || m1[3] >= n) {
     tf = false;
    }
   }
   if (tf && M.GR > 0) {
    double pdx = 0;
    double pdy = 0;
    for (c1 = 0; c1 < n; c1++) {
     for (c2 = c1; c2 < n; c2++) {
      if (c1 == c2) {
       continue;
      }
      if (Math.abs(x1[c1] - x1[c2]) > pdx) {
       pdx = Math.abs(x1[c1] - x1[c2]);
      }
      if (Math.abs(y1[c1] - y1[c2]) > pdy) {
       pdy = Math.abs(y1[c1] - y1[c2]);
      }
     }
    }
    if (pdx <= M.GR && pdy <= M.GR) {
     tf = false;
    }
   }
   if (tf) {
    if (M.fd != null) {
     for (c1 = 0; c1 < 160; c1++) {
      if (av > M.fd[c1]) {
       r = (r * M.dnst + M.cfad[0]) / (M.dnst + 1.);
       g = (g * M.dnst + M.cfad[1]) / (M.dnst + 1.);
       b = (b * M.dnst + M.cfad[2]) / (M.dnst + 1.);
      }
     }
    }
    if ((G.X != 0 || G.Z != 0) && !M.nosc) {
     r += Math.min(M.lAng, 0) * .5;
     g += Math.min(M.lAng, 0) * .5;
     b += Math.min(M.lAng, 0) * .5;
    }
    G.c(r, g, b);
    pth = new Path2D.Double();
    pth.moveTo(x1[0], y1[0]);
    for (p = 0; p < n; p++) {
     pth.lineTo(x1[p], y1[p]);
    }
    pth.closePath();
    gs.fill(pth);
   }
  }
 }

 void rot(double a[], double b[], double c, double d, double e, long f) {
  if (e != 0) {
   for (int g = 0; g < f; g++) {
    double h = a[g];
    double i = b[g];
    a[g] = c + ((h - c) * M.cos(e) - (i - d) * M.sin(e));
    b[g] = d + ((h - c) * M.sin(e) + (i - d) * M.cos(e));
   }
  }
 }

 double cx_y_S(double x, double y) {
  return Math.sqrt(Math.pow(x - M.cx, 2) + Math.pow(y, 2));
 }
}
