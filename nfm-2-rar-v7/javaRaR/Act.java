
import java.awt.*;
import java.awt.geom.Path2D;
import java.io.*;
import java.util.Random;

class Act {

 Mdm M;
 Track T;
 Game G;
 Pcs P[];
 Path2D pth;
 int p;
 int np;
 double x;
 double y;
 double z;
 double xz;
 double xy;
 double zy;
 double wxz;
 double[] wrot;
 long dist;
 double mxR;
 double htR;
 boolean shdo;
 boolean avrg;
 boolean scn;
 boolean S_M;
 double prsnc;
 double wG;
 double[] wpx;
 double[] wpz;
 double sprkp;
 long txy[];
 long tzy[];
 long tc[][];
 double[] trdx;
 double[] trdz;
 double[] trdy;
 double tx[];
 double ty[];
 double tz[];
 long skd[];
 long dam[];
 int tnt;
 double[] dstg;
 double[] dsx;
 double[] dsy;
 double[] dsz;
 double dvx[];
 double dvz[];
 double[] odmag;
 double[] dvp;
 double[][] dmag;
 double[][] dc;
 double[] dbln;
 int ust;
 double[] sstg;
 double[] smx;
 double[] smy;
 double[] smz;
 double[] som;
 double[] svp;
 double[][] smag;
 double[] sbln;
 int smk;
 double smka;
 double jstg[];
 double jx[];
 double jy[];
 double jz[];
 double ojmag[];
 double[] jvp;
 double jmag[][];
 int jt;
 double srx;
 double sry;
 double srz;
 double rcx;
 double rcy;
 double rcz;
 long sprk;
 int rtg[];
 boolean rbef[];
 double rx[];
 double ry[];
 double rz[];
 double vrx[];
 double vry[];
 double vrz[];
 boolean elec;
 boolean rtd;
 double edl[];
 double edr[];
 int elc[] = {
  0, 0, 0, 0
 };
 boolean fix;
 double fcnt;
 long chk;

 Act(byte a[], Mdm m, Track t, Game g) {
  int np1;
  int np2;
  prsnc = 1;
  wpx = new double[14];
  wpz = new double[14];
  wrot = new double[2];
  edl = new double[4];
  edr = new double[4];
  G = g;
  M = m;
  T = t;
  P = new Pcs[1000];
  String s1 = "";
  boolean pc = false;
  boolean tp = false;
  int n = 0;
  double f = 1;
  double f1 = 1;
  double[] xyz = {
   1, 1, 1
  };
  double[] x0 = new double[170];
  double[] y0 = new double[170];
  double[] z0 = new double[170];
  double[] c = {
   0, 0, 0
  };
  Wheel wl = new Wheel();
  int w = 0;
  long gr = 1;
  long fs = 0;
  long wgr = 0;
  String typ = "";
  String wtyp = "";
  boolean nol = false;
  double[] xMxP = new double[2];
  double[] xMxM = new double[2];
  double[] yMxP = new double[2];
  double[] yMxM = new double[2];
  double[] zMxP = new double[2];
  double[] zMxM = new double[2];
  try {
   BufferedReader d = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(a)));
   while (true) {
    String s;
    if ((s = d.readLine()) == null) {
     break;
    }
    s1 = "" + s.trim();
    {
     if (s1.startsWith("<p>")) {
      pc = true;
      n = 0;
      gr = 0;
      fs = 0;
      typ = "";
      nol = false;
     }
     if (pc) {
      if (s1.startsWith("gr(")) {
       gr = G.gtVal("gr", s1, 0);
      }
      if (s1.startsWith("fs(")) {
       fs = G.gtVal("fs", s1, 0);
      }
      if (s1.startsWith("c(")) {
       c[0] = G.gtVal("c", s1, 0);
       c[1] = G.gtVal("c", s1, 1);
       c[2] = G.gtVal("c", s1, 2);
      }
      if (s1.startsWith("clr")) {
       typ = "clr";
      }
      if (s1.startsWith("gshadow")) {
       typ = "gshdw";
      }
      if (s1.startsWith("lit")) {
       typ = "lit";
      }
      if (s1.startsWith("ltclr")) {
       typ = "litclr";
      }
      if (s1.startsWith("plit")) {
       typ = "pvlit";
      }
      if (s1.startsWith("dlit")) {
       typ = "drtlit";
      }
      if (s1.startsWith("dlin")) {
       typ = "drtlnlit";
      }
      if (s1.startsWith("Lit")) {
       typ = "Lit";
      }
      if (s1.startsWith("glw")) {
       typ = "glw";
      }
      if (s1.startsWith("blnk")) {
       typ = "blnk";
      }
      if (s1.startsWith("flk1")) {
       typ = "flk1";
      }
      if (s1.startsWith("flk2")) {
       typ = "flk2";
      }
      if (s1.startsWith("flkLit1")) {
       typ = "flkLit1";
      }
      if (s1.startsWith("flkLit2")) {
       typ = "flkLit2";
      }
      if (s1.startsWith("lg")) {
       typ = "lndngr";
      }
      if (s1.startsWith("drt")) {
       typ = "drt";
      }
      if (s1.startsWith("chwrd")) {
       typ = "chwrd";
      }
      if (s1.startsWith("chsg")) {
       typ = "chsg";
      }
      if (s1.startsWith("fnsh")) {
       typ = "fnsh";
      }
      if (s1.startsWith("hp1")) {
       typ = "hp1";
      }
      if (s1.startsWith("hp2")) {
       typ = "hp2";
      }
      if (s1.startsWith("hp3")) {
       typ = "hp3";
      }
      if (s1.startsWith("nol")) {
       nol = true;
      }
      if (s1.startsWith("p(")) {
       x0[n] = G.gtVal("p", s1, 0) * f * f1 * xyz[0];
       y0[n] = G.gtVal("p", s1, 1) * f * xyz[1];
       z0[n] = G.gtVal("p", s1, 2) * f * xyz[2];
       double mnR = Math.sqrt(Math.pow(x0[n], 2) + Math.pow(y0[n], 2) + Math.pow(z0[n], 2));
       mxR = Math.max(mxR, mnR);
       xMxM[0] = Math.min(xMxM[0], x0[n]);
       xMxP[0] = Math.max(xMxP[0], x0[n]);
       yMxM[0] = Math.min(yMxM[0], y0[n]);
       yMxP[0] = Math.max(yMxP[0], y0[n]);
       zMxM[0] = Math.min(zMxM[0], z0[n]);
       zMxP[0] = Math.max(zMxP[0], z0[n]);
       n++;
      }
     }
     for (np1 = 0; np1 < n; np1++) {
      for (np2 = 0; np2 < n; np2++) {
       if (np2 != np1) {
        if (xMxM[1] > x0[np1] - x0[np2]) {
         xMxM[1] = x0[np1] - x0[np2];
        }
        if (xMxP[1] < x0[np1] - x0[np2]) {
         xMxP[1] = x0[np1] - x0[np2];
        }
        if (yMxM[1] > y0[np1] - y0[np2]) {
         yMxM[1] = y0[np1] - y0[np2];
        }
        if (yMxP[1] < y0[np1] - y0[np2]) {
         yMxP[1] = y0[np1] - y0[np2];
        }
        if (zMxM[1] > z0[np1] - z0[np2]) {
         zMxM[1] = z0[np1] - z0[np2];
        }
        if (zMxP[1] < z0[np1] - z0[np2]) {
         zMxP[1] = z0[np1] - z0[np2];
        }
       }
      }
     }
     if (s1.startsWith("</p>")) {
      P[np] = new Pcs(M, T, x0, z0, y0, n, c, gr, fs, 0, 0, 0, typ, nol);
      np++;
      pc = false;
     }
    }
    if (s1.startsWith("rims(")) {
     wl.rims(G.gtVal("rims", s1, 0), G.gtVal("rims", s1, 1), G.gtVal("rims", s1, 2), G.gtVal("rims", s1, 3), G.gtVal("rims", s1, 4));
    }
    if (s1.startsWith("lndngr(")) {
     wtyp = "lndngr";
    }
    if (s1.startsWith("nul(")) {
     wtyp = "nul";
    }
    if (s1.startsWith("w(")) {
     wpx[w] = G.gtVal("w", s1, 0) * f * xyz[0];
     wpz[w] = G.gtVal("w", s1, 2) * f * xyz[2];
     wl.d(M, T, P, np, G.gtVal("w", s1, 0) * f * f1 * xyz[0], G.gtVal("w", s1, 1) * f * xyz[1], G.gtVal("w", s1, 2) * f * xyz[2], G.gtVal("w", s1, 3), G.gtVal("w", s1, 4) * f * f1, G.gtVal("w", s1, 5) * f, wgr, wtyp);
     np += 19;
     w++;
    }
    if (s1.startsWith("tracks")) {
     int v1 = (int) G.gtVal("tracks", s1, 0);
     txy = new long[v1];
     tzy = new long[v1];
     tc = new long[v1][3];
     trdx = new double[v1];
     trdz = new double[v1];
     trdy = new double[v1];
     tx = new double[v1];
     ty = new double[v1];
     tz = new double[v1];
     skd = new long[v1];
     dam = new long[v1];
    }
    if (s1.startsWith("<track>")) {
     tp = true;
     dam[tnt] = 1;
     skd[tnt] = 0;
     ty[tnt] = 0;
     tx[tnt] = 0;
     tz[tnt] = 0;
     txy[tnt] = 0;
     tzy[tnt] = 0;
     trdy[tnt] = 0;
     trdx[tnt] = 0;
     trdz[tnt] = 0;
     tc[tnt][0] = 0;
     tc[tnt][1] = 0;
     tc[tnt][2] = 0;
    }
    if (tp) {
     if (s1.startsWith("c")) {
      tc[tnt][0] = G.gtVal("c", s1, 0);
      tc[tnt][1] = G.gtVal("c", s1, 1);
      tc[tnt][2] = G.gtVal("c", s1, 2);
     }
     if (s1.startsWith("xy")) {
      txy[tnt] = G.gtVal("xy", s1, 0);
     }
     if (s1.startsWith("zy")) {
      tzy[tnt] = G.gtVal("zy", s1, 0);
     }
     if (s1.startsWith("radx")) {
      trdx[tnt] = G.gtVal("radx", s1, 0) * f;
     }
     if (s1.startsWith("rady")) {
      trdy[tnt] = G.gtVal("rady", s1, 0) * f;
     }
     if (s1.startsWith("radz")) {
      trdz[tnt] = G.gtVal("radz", s1, 0) * f;
     }
     if (s1.startsWith("ty")) {
      ty[tnt] = G.gtVal("ty", s1, 0) * f;
     }
     if (s1.startsWith("tx")) {
      tx[tnt] = G.gtVal("tx", s1, 0) * f;
     }
     if (s1.startsWith("tz")) {
      tz[tnt] = G.gtVal("tz", s1, 0) * f;
     }
     if (s1.startsWith("skid")) {
      skd[tnt] = G.gtVal("skid", s1, 0);
     }
     if (s1.startsWith("dam")) {
      dam[tnt] = G.gtVal("dam", s1, 0);
     }
    }
    if (s1.startsWith("</track>")) {
     tp = false;
     tnt++;
    }
    if (s1.startsWith("shadow")) {
     shdo = true;
    }
    if (s1.startsWith("avrg")) {
     avrg = true;
    }
    if (s1.startsWith("decor")) {
     scn = true;
    }
    if (s1.startsWith("sm")) {
     S_M = true;
    }
    if (s1.startsWith("prsnc(")) {
     prsnc = G.gtVal("prsnc", s1, 0) * .01;
    }
    if (s1.startsWith("div(")) {
     f = G.gtVal("div", s1, 0) * .1;
    }
    if (s1.startsWith("idiv(")) {
     f = G.gtVal("idiv", s1, 0) * .01;
    }
    if (s1.startsWith("iwid(")) {
     f1 = G.gtVal("iwid", s1, 0) * .01;
    }
    if (s1.startsWith("ScaleX(")) {
     xyz[0] = G.gtVal("ScaleX", s1, 0) * .01;
    }
    if (s1.startsWith("ScaleY(")) {
     xyz[1] = G.gtVal("ScaleY", s1, 0) * .01;
    }
    if (s1.startsWith("ScaleZ(")) {
     xyz[2] = G.gtVal("ScaleZ", s1, 0) * .01;
    }
    if (s1.startsWith("gwgr(")) {
     wgr = G.gtVal("gwgr", s1, 0);
    }
   }
   d.close();
  } catch (Exception e) {
   System.out.println("Model-Loading Error: " + e);
   System.out.println("At File: " + a + ".rad");
   System.out.println("At Line: " + s1);
   System.out.println("--------------------");
  }
  wG = wl.grnd;
  sprkp = wl.sprkp;
  if (shdo) {
   dstg = new double[40];
   sstg = new double[20];
   jstg = new double[20];
   rtg = new int[100];
  }
  htR = (Math.abs(xMxM[0]) + Math.abs(xMxP[0]) + Math.abs(yMxM[0]) + Math.abs(yMxP[0]) + Math.abs(zMxM[0]) + Math.abs(zMxP[0]) + Math.abs(xMxM[1]) + Math.abs(xMxP[1]) + Math.abs(yMxM[1]) + Math.abs(yMxP[1]) + Math.abs(zMxM[1]) + Math.abs(zMxP[1])) * .15;
 }

 Act(Act a, double b, double c, double d, long e) {
  prsnc = 1;
  wpx = new double[4];
  wpz = new double[4];
  wrot = new double[2];
  edl = new double[4];
  edr = new double[4];
  M = a.M;
  T = a.T;
  G = a.G;
  np = a.np;
  mxR = a.mxR;
  htR = a.htR;
  avrg = a.avrg;
  shdo = a.shdo;
  prsnc = a.prsnc;
  S_M = a.S_M;
  scn = a.scn;
  wG = a.wG;
  sprkp = a.sprkp;
  P = new Pcs[a.np];
  int c1;
  for (c1 = 0; c1 < np; c1++) {
   P[c1] = new Pcs(M, T, a.P[c1].ox, a.P[c1].oz, a.P[c1].oy, a.P[c1].n, a.P[c1].oc, a.P[c1].gr, a.P[c1].fs, a.P[c1].wx, a.P[c1].wy, a.P[c1].wz, a.P[c1].typ, a.P[c1].nol);
  }
  x = b;
  y = c;
  z = d;
  for (c1 = 0; c1 < np; c1++) {
   P[c1].rot(P[c1].ox, P[c1].oz, 0, 0, e, P[c1].n);
   P[c1].lpj(G);
  }
  if (a.tnt != 0) {
   for (c1 = 0; c1 < a.tnt; c1++) {
    T.xy[T.nt] = (long) (a.txy[c1] * M.cos(e) - a.tzy[c1] * M.sin(e));
    T.zy[T.nt] = (long) (a.tzy[c1] * M.cos(e) + a.txy[c1] * M.sin(e));
    for (int b1 = 0; b1 < 3; b1++) {
     T.c[T.nt][b1] = a.tc[c1][b1] + a.tc[c1][b1] * (M.snap[b1] * .01);
    }
    T.x[T.nt] = (x + a.tx[c1] * M.cos(e)) - a.tz[c1] * M.sin(e);
    T.z[T.nt] = z + a.tz[c1] * M.cos(e) + a.tx[c1] * M.sin(e);
    T.y[T.nt] = y + a.ty[c1];
    T.skd[T.nt] = a.skd[c1];
    T.dam[T.nt] = a.dam[c1];
    T.scn[T.nt] = scn;
    long l2 = Math.abs(e);
    if (l2 == 180) {
     l2 = 0;
    }
    T.radx[T.nt] = Math.abs(a.trdx[c1] * M.cos(l2) + a.trdz[c1] * M.sin(l2));
    T.radz[T.nt] = Math.abs(a.trdx[c1] * M.sin(l2) + a.trdz[c1] * M.cos(l2));
    T.rady[T.nt] = a.trdy[c1];
    T.nt++;
   }
  }
  for (c1 = 0; c1 < 4; c1++) {
   wpx[c1] = a.wpx[c1];
   wpz[c1] = a.wpz[c1];
  }
  if (shdo) {
   dstg = new double[40];
   dsx = new double[40];
   dsy = new double[40];
   dsz = new double[40];
   dvx = new double[40];
   dvz = new double[40];
   odmag = new double[40];
   dvp = new double[40];
   dmag = new double[40][8];
   dc = new double[40][3];
   dbln = new double[40];
   ust = 0;
   rtg = new int[100];
   rbef = new boolean[100];
   rx = new double[100];
   ry = new double[100];
   rz = new double[100];
   vrx = new double[100];
   vry = new double[100];
   vrz = new double[100];
   sstg = new double[20];
   smx = new double[20];
   smy = new double[20];
   smz = new double[20];
   som = new double[20];
   svp = new double[20];
   smag = new double[20][8];
   sbln = new double[20];
   smk = 0;
   jstg = new double[20];
   jx = new double[20];
   jy = new double[20];
   jz = new double[20];
   ojmag = new double[20];
   jvp = new double[20];
   jmag = new double[20][8];
   jt = 0;
  }
 }

 Act(long rnd, double b, double c, Mdm m, Track t, Game g, double ax, double az) {
  prsnc = 1;
  wpx = new double[4];
  wpz = new double[4];
  edl = new double[4];
  edr = new double[4];
  M = m;
  T = t;
  G = g;
  x = ax;
  z = az;
  y = m.grnd;
  avrg = true;
  prsnc = 115;
  scn = true;
  np = 5;
  P = new Pcs[5];
  Random r = new Random(rnd);
  double[] v1 = new double[8];
  double[] v2 = new double[8];
  double[] v3 = new double[8];
  double[] v4 = new double[8];
  double[] v5 = new double[8];
  b = Math.max(2, Math.min(b, 6));
  c = Math.max(2, Math.min(c, 6));
  c = c * (1 + (b - 2) * .1786);
  double i = 50 + 100 * r.nextDouble();
  v1[0] = -(i * b * .7071);
  v2[0] = i * b * .7071;
  i = 50 + 100 * r.nextDouble();
  v1[1] = 0;
  v2[1] = i * b;
  i = 50 + 100 * r.nextDouble();
  v1[2] = (i * b) * .7071;
  v2[2] = (i * b) * .701;
  i = 50 + 100 * r.nextDouble();
  v1[3] = i * b;
  v2[3] = 0;
  i = 50 + 100 * r.nextDouble();
  v1[4] = (i * b) * .7071;
  v2[4] = -((i * b) * .7071);
  i = 50 + 100 * r.nextDouble();
  v1[5] = 0;
  v2[5] = -(i * b);
  i = 50 + 100 * r.nextDouble();
  v1[6] = -((i * b) * .7071);
  v2[6] = -((i * b) * .7071);
  i = 50 + 100 * r.nextDouble();
  v1[7] = -(i * b);
  v2[7] = 0;
  int b1;
  int b2;
  for (b1 = 0; b1 < 8; b1++) {
   v3[b1] = v1[b1] * (.2 + .4 * r.nextDouble());
   v4[b1] = v2[b1] * (.2 + .4 * r.nextDouble());
   v5[b1] = -((10 + 15 * r.nextDouble()) * c);
  }
  for (b1 = 0; b1 < 8; b1++) {
   int v = b1 - 1;
   if (v < 0) {
    v = 7;
   }
   int v0 = b1 + 1;
   if (v0 > 7) {
    v0 = 0;
   }
   v1[b1] = ((v1[v] + v1[v0]) * .5 + v1[b1]) * .5;
   v2[b1] = ((v2[v] + v2[v0]) * .5 + v2[b1]) * .5;
   v3[b1] = ((v3[v] + v3[v0]) * .5 + v3[b1]) * .5;
   v4[b1] = ((v4[v] + v4[v0]) * .5 + v4[b1]) * .5;
   v5[b1] = ((v5[v] + v5[v0]) * .5 + v5[b1]) * .5;
   double mnR = Math.sqrt(Math.pow(v1[b1], 2) + Math.pow(v2[b1], 2));
   mxR = Math.max(mxR, mnR);
   mnR = Math.sqrt(Math.pow(v3[b1], 2) + Math.pow(v5[b1], 2) + Math.pow(v4[b1], 2));
   mxR = Math.max(mxR, mnR);
  }
  double[] v9 = new double[3];
  double f2 = Math.min((b / c - .33) * .03, .057);
  if (f2 < .005) {
   f2 = 0;
  }
  for (b1 = 0; b1 < 4; b1++) {
   int v10 = b1 * 2;
   int v11 = v10 + 2;
   if (v11 > 7) {
    v11 = 0;
   }
   double[] v6 = new double[6];
   double[] v7 = new double[6];
   double[] v8 = new double[6];
   v6[0] = v1[v10];
   v6[1] = v1[v10 + 1];
   v6[2] = v1[v11];
   v6[5] = v3[v10];
   v6[4] = v3[v10 + 1];
   v6[3] = v3[v11];
   v8[0] = v2[v10];
   v8[1] = v2[v10 + 1];
   v8[2] = v2[v11];
   v8[5] = v4[v10];
   v8[4] = v4[v10 + 1];
   v8[3] = v4[v11];
   v7[0] = 0;
   v7[1] = 0;
   v7[2] = 0;
   v7[5] = v5[v10];
   v7[4] = v5[v10 + 1];
   v7[3] = v5[v11];
   for (i = (.17 - f2) * r.nextDouble(); Math.abs(-1 - i) < .03 - (f2 * .176); i = (.17 - f2) * r.nextDouble()) {
   }
   for (b2 = 0; b2 < 3; b2++) {
    v9[b2] = (M.cpol[b2] + M.cgrnd[b2]) / (2.2 + i - f2);
   }
   P[b1] = new Pcs(M, T, v6, v8, v7, 6, v9, -8, 0, 0, 0, 0, "pil", false);
  }
  i = .02 * r.nextDouble();
  for (b1 = 0; b1 < 3; b1++) {
   v9[b1] = (M.cpol[b1] + M.cgrnd[b1]) / (2.15 + i);
  }
  P[4] = new Pcs(M, T, v3, v4, v5, 8, v9, -8, 0, 0, 0, 0, "pil", false);
  double[] x0 = new double[2];
  double[] z0 = new double[2];
  for (b1 = 0; b1 < 4; b1++) {
   b2 = (b1 * 2 + 1);
   T.y[T.nt] = v5[b2] * .5;
   T.rady[T.nt] = Math.abs(v5[b2] * .5);
   if (b1 == 0 || b1 == 2) {
    T.z[T.nt] = (v2[b2] + v4[b2]) * .5;
    T.radz[T.nt] = Math.abs(T.z[T.nt] - v2[b2]);
    b2 = (b1 * 2 + 2);
    if (b2 > 7) {
     b2 = 0;
    }
    T.x[T.nt] = (v1[b1 * 2] + v1[b2]) * .5;
    T.radx[T.nt] = Math.abs(T.x[T.nt] - v1[b1 * 2]);
   } else {
    T.x[T.nt] = (v1[b2] + v3[b2]) * .5;
    T.radx[T.nt] = Math.abs(T.x[T.nt] - v1[b2]);
    b2 = (b1 * 2 + 2);
    if (b2 > 7) {
     b2 = 0;
    }
    T.z[T.nt] = (v2[b1 * 2] + v2[b2]) * .5;
    T.radz[T.nt] = Math.abs(T.z[T.nt] - v2[b1 * 2]);
   }
   if (b1 == 0) {
    z0[0] = T.z[T.nt] - T.radz[T.nt];
    T.zy[T.nt] = (long) (Math.atan(T.rady[T.nt] / T.radz[T.nt]) * 57.295779513082320876798154814105);
    if (T.zy[T.nt] > 40) {
     T.zy[T.nt] = 40;
    }
    T.xy[T.nt] = 0;
   }
   if (b1 == 1) {
    x0[0] = T.x[T.nt] - T.radx[T.nt];
    T.xy[T.nt] = (long) (Math.atan(T.rady[T.nt] / T.radx[T.nt]) * 57.295779513082320876798154814105);
    if (T.xy[T.nt] > 40) {
     T.xy[T.nt] = 40;
    }
    T.zy[T.nt] = 0;
   }
   if (b1 == 2) {
    z0[1] = T.z[T.nt] + T.radz[T.nt];
    T.zy[T.nt] = (long) -(Math.atan(T.rady[T.nt] / T.radz[T.nt]) * 57.295779513082320876798154814105);
    if (T.zy[T.nt] < -40) {
     T.zy[T.nt] = -40;
    }
    T.xy[T.nt] = 0;
   }
   if (b1 == 3) {
    x0[1] = T.x[T.nt] + T.radx[T.nt];
    T.xy[T.nt] = (long) -(Math.atan(T.rady[T.nt] / T.radx[T.nt]) * 57.295779513082320876798154814105);
    if (T.xy[T.nt] < -40) {
     T.xy[T.nt] = -40;
    }
    T.zy[T.nt] = 0;
   }
   T.x[T.nt] += x;
   T.z[T.nt] += z;
   T.y[T.nt] += y;
   for (b2 = 0; b2 < 3; b2++) {
    T.c[T.nt][b2] = P[b1].oc[b2];
   }
   T.skd[T.nt] = 2;
   T.dam[T.nt] = 1;
   T.scn[T.nt] = true;
   T.rady[T.nt] += 10;
   T.nt++;
  }
  T.y[T.nt] = 0;
  for (b1 = 0; b1 < 8; b1++) {
   T.y[T.nt] += v5[b1];
  }
  T.y[T.nt] = T.y[T.nt] * .125;
  T.y[T.nt] += y;
  T.rady[T.nt] = 200;
  T.radx[T.nt] = x0[0] - x0[1];
  T.radz[T.nt] = z0[0] - z0[1];
  T.x[T.nt] = (x0[0] + x0[1]) * .5 + x;
  T.z[T.nt] = (z0[0] + z0[1]) * .5 + z;
  T.zy[T.nt] = 0;
  T.xy[T.nt] = 0;
  for (b1 = 0; b1 < 3; b1++) {
   T.c[T.nt][b1] = P[4].oc[b1];
  }
  T.skd[T.nt] = 4;
  T.dam[T.nt] = 1;
  T.scn[T.nt] = true;
  T.nt++;
 }

 void d(Graphics2D gs) {
  if (!S_M) {
   int c;
   if (dist != 0) {
    dist = 0;
   }
   double dx = M.cx + ((x - M.x - M.cx) * M.cos(M.xz) - (z - M.z - M.cz) * M.sin(M.xz));
   double dz = M.cz + ((x - M.x - M.cx) * M.sin(M.xz) + (z - M.z - M.cz) * M.cos(M.xz));
   double vp = M.cz + ((y - M.y - M.cy) * M.sin(M.zy) + (dz - M.cz) * M.cos(M.zy));
   if (((M.xs(dx + mxR * 2, vp) > 0 && M.xs(dx - mxR * 2, vp) < M.w && vp > -mxR && vp > -mxR) || shdo) && ((M.fd != null && vp < M.fd[159] + mxR) || M.cldon || M.mnton || M.stron || M.fd == null) && vp <= M.maxD && (!scn || !M.nosc)) {
    if (shdo && !M.crs && M.grv[G.stg] != 0 && G.stg != 39 && G.stg != 40 && G.stg != 42 && G.stg != 44 && G.stg != 51 && G.stg != 55 && G.stg != 59 && G.stg != 67) {
     if (G.suny) {
      boolean tf = false;
      int n = T.nt - 1;
      while (true) {
       if (n < 0) {
        break;
       }
       if (y < T.y[n] && Math.abs(T.zy[n]) != 90 && Math.abs(T.xy[n]) != 90 && Math.abs(x - T.x[n]) < T.radx[n] + mxR && Math.abs(z - T.z[n]) < T.radz[n] + mxR && (!T.scn[n] || !M.nosc)) {
        tf = true;
        break;
       }
       n--;
      }
      if (tf) {
       for (c = 0; c < np; c++) {
        P[c].s(gs, this, true, G);
       }
      } else {
       double dy = M.cy + ((M.grnd - M.cy) * M.cos(M.zy) - (dz - M.cz) * M.sin(M.zy));
       double dz1 = M.cz + ((M.grnd - M.cy) * M.sin(M.zy) + (dz - M.cz) * M.cos(M.zy));
       if (M.ys(dy + mxR, dz1) > 0) {
        for (c = 0; c < np; c++) {
         P[c].s(gs, this, false, G);
        }
       }
      }
     } else {
      bshd(gs, vp);
     }
    }
    double dy = M.cy + ((y - M.y - M.cy) * M.cos(M.zy) - (dz - M.cz) * M.sin(M.zy));
    if ((M.ys(dy + mxR, vp) > 0 && M.ys(dy - mxR, vp) < M.h) || shdo) {
     if (elec) {
      shok(gs);
     }
     if (fix) {
      fix(gs);
     }
     if (shdo) {
      dist = (long) Math.sqrt(Math.pow(M.x + M.cx - x, 2) + Math.pow(M.z + M.cz - z, 2) + Math.pow(M.y + M.cy - y, 2));
      for (c = 0; c < 40; c++) {
       if (dstg[c] != 0) {
        ddust(c, gs, true);
       }
      }
      for (c = 0; c < 20; c++) {
       if (sstg[c] != 0) {
        dsmk(c, gs, true);
       }
       if (jstg[c] != 0) {
        djt(c, gs, true);
       }
      }
      dsprk(gs, true);
     }
     int[] n = new int[np];
     int[] n1 = new int[np];
     for (c = 0; c < np; c++) {
      n[c] = 0;
     }
     for (c = 0; c < np; c++) {
      for (int c1 = c + 1; c1 < np; c1++) {
       if (P[c].av != P[c1].av) {
        if (P[c].av < P[c1].av) {
         n[c]++;
        } else {
         n[c1]++;
        }
        continue;
       }
       if (c > c1) {
        n[c]++;
       } else {
        n[c1]++;
       }
      }
      n1[n[c]] = c;
     }
     for (c = 0; c < np; c++) {
      P[n1[c]].d(gs, this, G);
     }
     if (shdo) {
      for (c = 0; c < 40; c++) {
       if (dstg[c] != 0) {
        ddust(c, gs, false);
       }
      }
      for (c = 0; c < 20; c++) {
       if (sstg[c] != 0) {
        dsmk(c, gs, false);
       }
       if (jstg[c] != 0) {
        djt(c, gs, false);
       }
      }
      dsprk(gs, false);
     }
     if (shdo) {
      dist = (long) (Math.pow(Math.pow(M.x + M.cx - x, 2) + Math.pow(M.z + M.cz - z, 2) + Math.pow(M.y + M.cy - y, 2), .25) * prsnc);
     } else {
      dist = (long) Math.abs(1000 + (vp * prsnc));
     }
    }
   }
   if (shdo && dist == 0) {
    for (c = 0; c < 40; c++) {
     if (dstg[c] != 0) {
      dstg[c] = 0;
     }
    }
    for (c = 0; c < 20; c++) {
     if (sstg[c] != 0) {
      sstg[c] = 0;
     }
    }
    for (c = 0; c < 100; c++) {
     if (rtg[c] != 0) {
      rtg[c] = 0;
     }
    }
    if (sprk != 0) {
     sprk = 0;
    }
   }
  }
 }

 void dSM(Graphics2D gs) {
  if (S_M && !M.nosc) {
   double dz = M.cz + ((x - M.x - M.cx) * M.sin(M.xz) + (z - M.z - M.cz) * M.cos(M.xz));
   double vp = M.cz + ((y - M.y - M.cy) * M.sin(M.zy) + (dz - M.cz) * M.cos(M.zy));
   double dy = M.cy + ((y - M.y - M.cy) * M.cos(M.zy) - (dz - M.cz) * M.sin(M.zy));
   if (M.ys(dy + mxR, vp) > - 100 && M.ys(dy - mxR, vp) < M.h + 100 && vp <= M.maxD) {
    for (int c = 0; c < np; c++) {
     P[c].d(gs, this, G);
    }
   }
  }
 }

 void bshd(Graphics2D gs, double vp) {
  double[] x0 = new double[4];
  double[] y0 = new double[4];
  double[] z0 = new double[4];
  int n;
  int n1;
  long v = 1;
  if (Math.abs(zy) > 90) {
   v = -1;
  }
  double h = Math.max(1, Math.abs(y - (250 - wG)) * .005);
  double ext = wG * .5;
  x0[0] = ((wpx[0] - ext) + x) - M.x;
  z0[0] = (((wpz[0] + ext) * v) + z) - M.z;
  x0[1] = ((wpx[1] + ext) + x) - M.x;
  z0[1] = (((wpz[1] + ext) * v) + z) - M.z;
  x0[2] = ((wpx[3] + ext) + x) - M.x;
  z0[2] = (((wpz[3] - ext) * v) + z) - M.z;
  x0[3] = ((wpx[2] - ext) + x) - M.x;
  z0[3] = (((wpz[2] - ext) * v) + z) - M.z;
  M.rot(x0, z0, x - M.x, z - M.z, xz, 4);
  for (n = 0; n < 4; n++) {
   y0[n] = M.grnd;
  }
  n = T.nt - 1;
  while (true) {
   if (n < 0) {
    break;
   }
   v = 0;
   for (n1 = 0; n1 < 4; n1++) {
    if (Math.abs(T.zy[n]) != 90 && Math.abs(T.xy[n]) != 90 && Math.abs(x0[n1] - (T.x[n] - M.x)) < T.radx[n] && Math.abs(z0[n1] - (T.z[n] - M.z)) < T.radz[n] && (!T.scn[n] || !M.nosc)) {
     v++;
    }
   }
   if (v > 1) {
    for (n1 = 0; n1 < 4; n1++) {
     y0[n1] = T.y[n] - M.y;
     if (T.zy[n] != 0) {
      y0[n1] += ((z0[n1] - (T.z[n] - M.z - T.radz[n])) * M.sin(T.zy[n])) / M.sin(90 - T.zy[n]) - (T.radz[n] * M.sin(T.zy[n])) / M.sin(90 - T.zy[n]);
     }
     if (T.xy[n] != 0) {
      y0[n1] += ((x0[n1] - (T.x[n] - M.x - T.radx[n])) * M.sin(T.xy[n])) / M.sin(90 - T.xy[n]) - (T.radx[n] * M.sin(T.xy[n])) / M.sin(90 - T.xy[n]);
     }
    }
    h = Math.max(1, Math.abs(y - T.y[n]) * .005);
    break;
   }
   n--;
  }
  M.rot(x0, z0, M.cx, M.cz, M.xz, 4);
  M.rot(y0, z0, M.cy, M.cz, M.zy, 4);
  boolean tf = true;
  long[] m = new long[4];
  for (n = 0; n < 4; n++) {
   x0[n] = M.xs(x0[n], z0[n]);
   y0[n] = M.ys(y0[n], z0[n]);
   if (y0[n] < 0 || z0[n] < 10) {
    m[0]++;
   }
   if (y0[n] > M.h || z0[n] < 10) {
    m[1]++;
   }
   if (x0[n] < 0 || z0[n] < 10) {
    m[2]++;
   }
   if (x0[n] > M.w || z0[n] < 10) {
    m[3]++;
   }
  }
  if (m[0] > 3 || m[1] > 3 || m[2] > 3 || m[3] > 3) {
   tf = false;
  }
  if (tf) {
   double r = 0;
   double g = 0;
   double b = 0;
   if (M.fd != null) {
    for (n = 0; n < 160; n++) {
     if (vp > M.fd[n]) {
      r = (r * M.dnst + M.cfad[0]) / (M.dnst + 1);
      g = (g * M.dnst + M.cfad[1]) / (M.dnst + 1);
      b = (b * M.dnst + M.cfad[2]) / (M.dnst + 1);
     }
    }
   }
   G.ct(r, g, b, 24 / h);
   pth = new Path2D.Double();
   pth.moveTo(x0[0], y0[0]);
   for (p = 0; p < 4; p++) {
    pth.lineTo(x0[p], y0[p]);
   }
   pth.closePath();
   gs.fill(pth);
  }
  v = 1;
  if (Math.abs(zy) > 90) {
   v = -1;
  }
  h = Math.max(1, Math.abs(y - (250 - wG)) * .005);
  ext = wG;
  x0[0] = ((wpx[0] - ext) + x) - M.x;
  z0[0] = (((wpz[0] + ext) * v) + z) - M.z;
  x0[1] = ((wpx[1] + ext) + x) - M.x;
  z0[1] = (((wpz[1] + ext) * v) + z) - M.z;
  x0[2] = ((wpx[3] + ext) + x) - M.x;
  z0[2] = (((wpz[3] - ext) * v) + z) - M.z;
  x0[3] = ((wpx[2] - ext) + x) - M.x;
  z0[3] = (((wpz[2] - ext) * v) + z) - M.z;
  M.rot(x0, z0, x - M.x, z - M.z, xz, 4);
  for (n = 0; n < 4; n++) {
   y0[n] = M.grnd;
  }
  n = T.nt - 1;
  while (true) {
   if (n < 0) {
    break;
   }
   v = 0;
   for (n1 = 0; n1 < 4; n1++) {
    if (Math.abs(T.zy[n]) != 90 && Math.abs(T.xy[n]) != 90 && Math.abs(x0[n1] - (T.x[n] - M.x)) < T.radx[n] && Math.abs(z0[n1] - (T.z[n] - M.z)) < T.radz[n] && (!T.scn[n] || !M.nosc)) {
     v++;
    }
   }
   if (v > 1) {
    for (n1 = 0; n1 < 4; n1++) {
     y0[n1] = T.y[n] - M.y;
     if (T.zy[n] != 0) {
      y0[n1] += ((z0[n1] - (T.z[n] - M.z - T.radz[n])) * M.sin(T.zy[n])) / M.sin(90 - T.zy[n]) - (T.radz[n] * M.sin(T.zy[n])) / M.sin(90 - T.zy[n]);
     }
     if (T.xy[n] != 0) {
      y0[n1] += ((x0[n1] - (T.x[n] - M.x - T.radx[n])) * M.sin(T.xy[n])) / M.sin(90 - T.xy[n]) - (T.radx[n] * M.sin(T.xy[n])) / M.sin(90 - T.xy[n]);
     }
    }
    h = Math.max(1, Math.abs(y - T.y[n]) * .005);
    break;
   }
   n--;
  }
  M.rot(x0, z0, M.cx, M.cz, M.xz, 4);
  M.rot(y0, z0, M.cy, M.cz, M.zy, 4);
  tf = true;
  m = new long[4];
  for (n = 0; n < 4; n++) {
   x0[n] = M.xs(x0[n], z0[n]);
   y0[n] = M.ys(y0[n], z0[n]);
   if (y0[n] < 0 || z0[n] < 10) {
    m[0]++;
   }
   if (y0[n] > M.h || z0[n] < 10) {
    m[1]++;
   }
   if (x0[n] < 0 || z0[n] < 10) {
    m[2]++;
   }
   if (x0[n] > M.w || z0[n] < 10) {
    m[3]++;
   }
  }
  if (m[0] > 3 || m[1] > 3 || m[2] > 3 || m[3] > 3) {
   tf = false;
  }
  if (tf) {
   double r = 0;
   double g = 0;
   double b = 0;
   if (M.fd != null) {
    for (n = 0; n < 160; n++) {
     if (vp > M.fd[n]) {
      r = (r * M.dnst + M.cfad[0]) / (M.dnst + 1);
      g = (g * M.dnst + M.cfad[1]) / (M.dnst + 1);
      b = (b * M.dnst + M.cfad[2]) / (M.dnst + 1);
     }
    }
   }
   G.ct(r, g, b, 16 / h);
   pth = new Path2D.Double();
   pth.moveTo(x0[0], y0[0]);
   for (p = 0; p < 4; p++) {
    pth.lineTo(x0[p], y0[p]);
   }
   pth.closePath();
   gs.fill(pth);
  }
  v = 1;
  if (Math.abs(zy) > 90) {
   v = -1;
  }
  h = Math.max(1, Math.abs(y - (250 - wG)) * .005);
  ext = wG * 1.5;
  x0[0] = ((wpx[0] - ext) + x) - M.x;
  z0[0] = (((wpz[0] + ext) * v) + z) - M.z;
  x0[1] = ((wpx[1] + ext) + x) - M.x;
  z0[1] = (((wpz[1] + ext) * v) + z) - M.z;
  x0[2] = ((wpx[3] + ext) + x) - M.x;
  z0[2] = (((wpz[3] - ext) * v) + z) - M.z;
  x0[3] = ((wpx[2] - ext) + x) - M.x;
  z0[3] = (((wpz[2] - ext) * v) + z) - M.z;
  M.rot(x0, z0, x - M.x, z - M.z, xz, 4);
  for (n = 0; n < 4; n++) {
   y0[n] = M.grnd;
  }
  n = T.nt - 1;
  while (true) {
   if (n < 0) {
    break;
   }
   v = 0;
   for (n1 = 0; n1 < 4; n1++) {
    if (Math.abs(T.zy[n]) != 90 && Math.abs(T.xy[n]) != 90 && Math.abs(x0[n1] - (T.x[n] - M.x)) < T.radx[n] && Math.abs(z0[n1] - (T.z[n] - M.z)) < T.radz[n] && (!T.scn[n] || !M.nosc)) {
     v++;
    }
   }
   if (v > 1) {
    for (n1 = 0; n1 < 4; n1++) {
     y0[n1] = T.y[n] - M.y;
     if (T.zy[n] != 0) {
      y0[n1] += ((z0[n1] - (T.z[n] - M.z - T.radz[n])) * M.sin(T.zy[n])) / M.sin(90 - T.zy[n]) - (T.radz[n] * M.sin(T.zy[n])) / M.sin(90 - T.zy[n]);
     }
     if (T.xy[n] != 0) {
      y0[n1] += ((x0[n1] - (T.x[n] - M.x - T.radx[n])) * M.sin(T.xy[n])) / M.sin(90 - T.xy[n]) - (T.radx[n] * M.sin(T.xy[n])) / M.sin(90 - T.xy[n]);
     }
    }
    h = Math.max(1, Math.abs(y - T.y[n]) * .005);
    break;
   }
   n--;
  }
  M.rot(x0, z0, M.cx, M.cz, M.xz, 4);
  M.rot(y0, z0, M.cy, M.cz, M.zy, 4);
  tf = true;
  m = new long[4];
  for (n = 0; n < 4; n++) {
   x0[n] = M.xs(x0[n], z0[n]);
   y0[n] = M.ys(y0[n], z0[n]);
   if (y0[n] < 0 || z0[n] < 10) {
    m[0]++;
   }
   if (y0[n] > M.h || z0[n] < 10) {
    m[1]++;
   }
   if (x0[n] < 0 || z0[n] < 10) {
    m[2]++;
   }
   if (x0[n] > M.w || z0[n] < 10) {
    m[3]++;
   }
  }
  if (m[0] > 3 || m[1] > 3 || m[2] > 3 || m[3] > 3) {
   tf = false;
  }
  if (tf) {
   double r = 0;
   double g = 0;
   double b = 0;
   if (M.fd != null) {
    for (n = 0; n < 160; n++) {
     if (vp > M.fd[n]) {
      r = (r * M.dnst + M.cfad[0]) / (M.dnst + 1);
      g = (g * M.dnst + M.cfad[1]) / (M.dnst + 1);
      b = (b * M.dnst + M.cfad[2]) / (M.dnst + 1);
     }
    }
   }
   G.ct(r, g, b, 8 / h);
   pth = new Path2D.Double();
   pth.moveTo(x0[0], y0[0]);
   for (p = 0; p < 4; p++) {
    pth.lineTo(x0[p], y0[p]);
   }
   pth.closePath();
   gs.fill(pth);
  }
 }

 void fix(Graphics2D g) {
  int c;
  double[] x0 = new double[8];
  double[] y0 = new double[8];
  double[] z0 = new double[4];
  for (c = 0; c < 4; c++) {
   x0[c] = (wpx[c] + x) - M.x;
   y0[c] = (wG + y) - M.y;
   z0[c] = (wpz[c] + z) - M.z;
  }
  M.rot(x0, y0, x - M.x, y - M.y, xy, 4);
  M.rot(y0, z0, y - M.y, z - M.y, zy, 4);
  M.rot(x0, z0, x - M.x, z - M.z, xz, 4);
  M.rot(x0, z0, M.cx, M.cz, M.xz, 4);
  M.rot(y0, z0, M.cy, M.cz, M.zy, 4);
  double pdx = 0;
  double pdy = 0;
  double v = 0;
  for (c = 0; c < 4; c++) {
   for (int c1 = 0; c1 < 4; c1++) {
    if (Math.abs(x0[c] - x0[c1]) > pdx) {
     pdx = Math.abs(x0[c] - x0[c1]);
    }
    if (Math.abs(y0[c] - y0[c1]) > pdy) {
     pdy = Math.abs(y0[c] - y0[c1]);
    }
    if (v < G.x_z(x0[c], x0[c1], y0[c], y0[c1])) {
     v = G.x_z(x0[c], x0[c1], y0[c], y0[c1]);
    }
   }
  }
  v = Math.sqrt(v) * .66;
  pdx = Math.max(pdx, v);
  pdy = Math.max(pdy, v);
  double dx = M.cx + ((x - M.x - M.cx) * M.cos(M.xz) - (z - M.z - M.cz) * M.sin(M.xz));
  double dz = M.cz + ((x - M.x - M.cx) * M.sin(M.xz) + (z - M.z - M.cz) * M.cos(M.xz));
  double dy = M.cy + ((y - M.y - M.cy) * M.cos(M.zy) - (dz - M.cz) * M.sin(M.zy));
  dz = M.cz + ((y - M.y - M.cy) * M.sin(M.zy) + (dz - M.cz) * M.cos(M.zy));
  x0[0] = M.xs(dx - pdx * 1.25 - Math.random() * (pdx / 2.4), dz);
  y0[0] = M.ys(dy - pdy / 1.92 - Math.random() * (pdy / 5.67), dz);
  x0[1] = M.xs(dx - pdx * 1.25 - Math.random() * (pdx / 2.4), dz);
  y0[1] = M.ys(dy + pdy / 1.92 + Math.random() * (pdy / 5.67), dz);
  x0[2] = M.xs(dx - pdx / 1.92 - Math.random() * (pdx / 5.67), dz);
  y0[2] = M.ys(dy + pdy * 1.25 + Math.random() * (pdy / 2.4), dz);
  x0[3] = M.xs(dx + pdx / 1.92 + Math.random() * (pdx / 5.67), dz);
  y0[3] = M.ys(dy + pdy * 1.25 + Math.random() * (pdy / 2.4), dz);
  x0[4] = M.xs(dx + pdx * 1.25 + Math.random() * (pdx / 2.4), dz);
  y0[4] = M.ys(dy + pdy / 1.92 + Math.random() * (pdy / 5.67), dz);
  x0[5] = M.xs(dx + pdx * 1.25 + Math.random() * (pdx / 2.4), dz);
  y0[5] = M.ys(dy - pdy / 1.92 - Math.random() * (pdy / 5.67), dz);
  x0[6] = M.xs(dx + pdx / 1.92 + Math.random() * (pdx / 5.67), dz);
  y0[6] = M.ys(dy - pdy * 1.25 - Math.random() * (pdy / 2.4), dz);
  x0[7] = M.xs(dx - pdx / 1.92 - Math.random() * (pdx / 5.67), dz);
  y0[7] = M.ys(dy - pdy * 1.25 - Math.random() * (pdy / 2.4), dz);
  if (fcnt > 2.5 && fcnt < 3.5) {
   M.rot(x0, y0, M.xs(dx, dz), M.ys(dy, dz), 22, 8);
  }
  if (fcnt > 3.5 && fcnt < 4.5) {
   M.rot(x0, y0, M.xs(dx, dz), M.ys(dy, dz), 22, 8);
  }
  if (fcnt > 4.5 && fcnt < 5.5) {
   M.rot(x0, y0, M.xs(dx, dz), M.ys(dy, dz), 0, 8);
  }
  if (fcnt > 5.5 && fcnt < 6.5) {
   M.rot(x0, y0, M.xs(dx, dz), M.ys(dy, dz), -22, 8);
  }
  if (fcnt > 6.5 && fcnt < 7.5) {
   M.rot(x0, y0, M.xs(dx, dz), M.ys(dy, dz), -22, 8);
  }
  g.setColor(new Color(255, 255, 255));
  pth = new Path2D.Double();
  pth.moveTo(x0[0], y0[0]);
  for (p = 0; p < 8; p++) {
   pth.lineTo(x0[p], y0[p]);
  }
  pth.closePath();
  g.fill(pth);
  x0[0] = M.xs((dx - pdx) - Math.random() * (pdx * .25), dz);
  y0[0] = M.ys(dy - pdy / 2.4 - Math.random() * (pdy / 9.6), dz);
  x0[1] = M.xs((dx - pdx) - Math.random() * (pdx * .25), dz);
  y0[1] = M.ys(dy + pdy / 2.4 + Math.random() * (pdy / 9.6), dz);
  x0[2] = M.xs(dx - pdx / 2.4 - Math.random() * (pdx / 9.6), dz);
  y0[2] = M.ys((dy + pdy) + Math.random() * (pdy * .25), dz);
  x0[3] = M.xs(dx + pdx / 2.4 + Math.random() * (pdx / 9.6), dz);
  y0[3] = M.ys((dy + pdy) + Math.random() * (pdy * .25), dz);
  x0[4] = M.xs((dx + pdx) + Math.random() * (pdx * .25), dz);
  y0[4] = M.ys(dy + pdy / 2.4 + Math.random() * (pdy / 9.6), dz);
  x0[5] = M.xs((dx + pdx) + Math.random() * (pdx * .25), dz);
  y0[5] = M.ys(dy - pdy / 2.4 - Math.random() * (pdy / 9.6), dz);
  x0[6] = M.xs(dx + pdx / 2.4 + Math.random() * (pdx / 9.6), dz);
  y0[6] = M.ys((dy - pdy) - Math.random() * (pdy * .25), dz);
  x0[7] = M.xs(dx - pdx / 2.4 - Math.random() * (pdx / 9.6), dz);
  y0[7] = M.ys((dy - pdy) - Math.random() * (pdy * .25), dz);
  g.setColor(new Color(0, 0, 0));
  pth = new Path2D.Double();
  pth.moveTo(x0[0], y0[0]);
  for (p = 0; p < 8; p++) {
   pth.lineTo(x0[p], y0[p]);
  }
  pth.closePath();
  g.fill(pth);
  fcnt += G.zz;
  if (fcnt > 7) {
   fix = false;
   fcnt = 0;
  }
 }

 void shok(Graphics2D gs) {
  for (int i = 0; i < 4; i++) {
   int c;
   if (elc[i] < 1) {
    edl[i] = 380 - Math.random() * 760;
    edr[i] = 380 - Math.random() * 760;
    elc[i] = 1;
   }
   double vl = edl[i] + (190 - Math.random() * 380);
   double vr = edr[i] + (190 - Math.random() * 380);
   double[] x0 = new double[8];
   double[] y0 = new double[8];
   double[] z0 = new double[8];
   for (c = 0; c < 8; c++) {
    z0[c] = z - M.z;
   }
   x0[0] = x - M.x - 504;
   y0[0] = y - M.y - edl[i] - 5 - (Math.random() * 5);
   x0[1] = (x - M.x - 252) + (Math.random() * 126);
   y0[1] = y - M.y - vl - 5 - (Math.random() * 5);
   x0[2] = ((x - M.x) + 252) - (Math.random() * 126);
   y0[2] = y - M.y - vr - 5 - (Math.random() * 5);
   x0[3] = (x - M.x) + 504;
   y0[3] = y - M.y - edr[i] - 5 - (Math.random() * 5);
   x0[4] = (x - M.x) + 504;
   y0[4] = (y - M.y - edr[i]) + 5 + (Math.random() * 5);
   x0[5] = ((x - M.x) + 252) - (Math.random() * 126);
   y0[5] = (y - M.y - vr) + 5 + (Math.random() * 5);
   x0[6] = (x - M.x - 252) + (Math.random() * 126);
   y0[6] = (y - M.y - vl) + 5 + (Math.random() * 5);
   x0[7] = x - M.x - 504;
   y0[7] = (y - M.y - edl[i]) + 5 + (Math.random() * 5);
   if (rtd) {
    M.rot(x0, z0, x - M.x, z - M.z, 90, 8);
   }
   M.rot(x0, z0, M.cx, M.cz, M.xz, 8);
   M.rot(y0, z0, M.cy, M.cz, M.zy, 8);
   boolean tf = true;
   int[] m = new int[4];
   double[] x1 = new double[8];
   double[] y1 = new double[8];
   for (c = 0; c < 8; c++) {
    x1[c] = M.xs(x0[c], z0[c]);
    y1[c] = M.ys(y0[c], z0[c]);
    if (y1[c] < 0 || z0[c] < 10) {
     m[0]++;
    }
    if (y1[c] > M.h || z0[c] < 10) {
     m[1]++;
    }
    if (x1[c] < 0 || z0[c] < 10) {
     m[2]++;
    }
    if (x1[c] > M.w || z0[c] < 10) {
     m[3]++;
    }
   }
   if (m[0] > 7 || m[1] > 7 || m[2] > 7 || m[3] > 7) {
    tf = false;
   }
   if (tf) {
    gs.setColor(new Color(255, 255, 255));
    pth = new Path2D.Double();
    pth.moveTo(x1[0], y1[0]);
    for (p = 0; p < 8; p++) {
     pth.lineTo(x1[p], y1[p]);
    }
    pth.closePath();
    gs.fill(pth);
   }
   if (elc[i] > Math.random() * 60) {
    elc[i] = 0;
   } else {
    elc[i]++;
   }
  }
  if (!rtd || xz != 0) {
   if (Math.random() < .5) {
    xy += 22.5;
   } else {
    xy -= 22.5;
   }
   if (Math.abs(xy) > 22.5) {
    xy = 0;
   }
  } else {
   if (Math.random() < .5) {
    zy += 22.5;
   } else {
    zy -= 22.5;
   }
   if (Math.abs(zy) > 22.5) {
    zy = 0;
   }
  }
 }

 void dust(int w, double cvx, double cvz, double siz, double spd, boolean flp) {
  double d = Math.abs(Math.abs(spd) - Math.sqrt(Math.pow(cvx, 2) + Math.pow(cvz, 2)));
  if (flp && d > 1) {
   d = Math.sqrt(Math.pow(cvx, 2) + Math.pow(cvz, 2)) * .1;
  }
  if (d > 10 + Math.random() * 5 || (!flp && Math.abs(spd) > 50 + Math.random() * 50)) {
   ust += Math.max(1, G.zz);
   if (ust > 39) {
    ust = 0;
   }
   dsx[ust] = x + (((Math.random() * Math.sqrt(Math.pow(cvx, 2) + Math.pow(cvz, 2))) - (Math.random() * Math.sqrt(Math.pow(cvx, 2) + Math.pow(cvz, 2)))) * siz);
   dsz[ust] = z + (((Math.random() * Math.sqrt(Math.pow(cvx, 2) + Math.pow(cvz, 2))) - (Math.random() * Math.sqrt(Math.pow(cvx, 2) + Math.pow(cvz, 2)))) * siz);
   dsy[ust] = y + wG;
   dsy[w] = Math.min(dsy[w], 250);
   odmag[ust] = siz + (Math.sqrt(d) * .1);
   dvx[ust] = d * 2;
   dvz[ust] = d * 2;
   dstg[ust] = 1;
  }
 }

 void smk(double siz, double emit, long dam, long dura) {
  if (smka != 100 * dam / dura) {
   smka = 100 * dam / dura;
  }
  if (smka < 10) {
   smka = 0;
  }
  smk += Math.max(1, G.zz);
  if (smk > 19) {
   smk = 0;
  }
  smx[smk] = (x + (emit * M.sin(xz) * (M.cos(zy)))) + (Math.random() * 100) - (Math.random() * 100);
  smz[smk] = (z - (emit * M.cos(xz) * (M.cos(zy)))) + (Math.random() * 100) - (Math.random() * 100);
  smy[smk] = (y + (emit * M.sin(zy))) + (Math.random() * 100) - (Math.random() * 100);
  som[smk] = siz;
  sstg[smk] = 1;
 }

 void jet(double siz, long emit) {
  jt += Math.max(1, G.zz);
  if (jt > 19) {
   jt = 0;
  }
  if (G.fas == "go") {
   jx[jt] = x + (emit * M.sin(xz) * (M.cos(zy))) + (Math.random() * 100) - (Math.random() * 100);
   jz[jt] = z - (emit * M.cos(xz) * (M.cos(zy))) + (Math.random() * 100) - (Math.random() * 100);
   jy[jt] = y + (emit * M.sin(zy)) + (Math.random() * 100) - (Math.random() * 100);
   jx[jt] += (Math.random() * 127) - (Math.random() * 127);
   jz[jt] += (Math.random() * 127) - (Math.random() * 127);
   jy[jt] += (Math.random() * 127) - (Math.random() * 127);
  }
  ojmag[jt] = siz;
  jstg[jt] = 1;
 }

 void ddust(int i, Graphics2D gs, boolean tf) {
  if (tf) {
   dvp[i] = Math.sqrt(Math.pow(M.x + M.cx - dsx[i], 2) + Math.pow(M.y + M.cy - dsy[i], 2) + Math.pow(M.z + M.cz - dsz[i], 2));
  }
  if ((tf && dvp[i] > dist) || (!tf && dvp[i] <= dist)) {
   int c;
   if (dstg[i] == 1) {
    dbln[i] = .6;
    boolean tf1 = false;
    double[] c1 = new double[3];
    for (c = 0; c < 3; c++) {
     c1[c] = 255 + 255 * M.snap[c] * .01;
    }
    for (c = 0; c < T.nt; c++) {
     if (Math.abs(T.zy[c]) == 90 || Math.abs(T.xy[c]) == 90 || Math.abs(dsx[i] - T.x[c]) >= T.radx[c] || Math.abs(dsz[i] - T.z[c]) >= T.radz[c]) {
      continue;
     }
     if (T.skd[c] < 1) {
      dbln[i] = .2;
     }
     if (T.skd[c] == 1) {
      dbln[i] = .4;
     }
     if (T.skd[c] == 2) {
      dbln[i] = .45;
     }
     for (int b1 = 0; b1 < 3; b1++) {
      dc[i][b1] = (T.c[c][b1] + c1[b1]) * .5;
     }
     tf1 = true;
    }
    if (!tf1) {
     for (c = 0; c < 3; c++) {
      dc[i][c] = (M.crgrnd[c] + c1[c]) * .5;
     }
    }
    for (c = 0; c < 8; c++) {
     dmag[i][c] = 40 + odmag[i] * Math.random() * 50 * G.zz;
    }
    dmag[i][6] = dmag[i][7];
   }
   double dx = M.cx + ((dsx[i] - M.x - M.cx) * M.cos(M.xz) - (dsz[i] - M.z - M.cz) * M.sin(M.xz));
   double dz = M.cz + ((dsx[i] - M.x - M.cx) * M.sin(M.xz) + (dsz[i] - M.z - M.cz) * M.cos(M.xz));
   double dy = M.cy + (((dsy[i] - M.y - M.cy) - dmag[i][7]) * M.cos(M.zy) - (dz - M.cz) * M.sin(M.zy));
   dz = M.cz + (((dsy[i] - M.y - M.cy) - dmag[i][7]) * M.sin(M.zy) + (dz - M.cz) * M.cos(M.zy));
   dsx[i] += (Math.random() * dvx[i]) - (Math.random() * dvx[i]);
   dsz[i] += (Math.random() * dvz[i]) - (Math.random() * dvz[i]);
   double[] x0 = new double[8];
   double[] y0 = new double[8];
   x0[0] = M.xs(dx + dmag[i][0] * .9238 * 1.5, dz);
   y0[0] = M.ys(dy + dmag[i][0] * .3826 * 1.5, dz);
   x0[1] = M.xs(dx + dmag[i][1] * .9238 * 1.5, dz);
   y0[1] = M.ys(dy - dmag[i][1] * .3826 * 1.5, dz);
   x0[2] = M.xs(dx + dmag[i][2] * .3826, dz);
   y0[2] = M.ys(dy - dmag[i][2] * .9238, dz);
   x0[3] = M.xs(dx - dmag[i][3] * .3826, dz);
   y0[3] = M.ys(dy - dmag[i][3] * .9238, dz);
   x0[4] = M.xs(dx - dmag[i][4] * .9238 * 1.5, dz);
   y0[4] = M.ys(dy - dmag[i][4] * .3826 * 1.5, dz);
   x0[5] = M.xs(dx - dmag[i][5] * .9238 * 1.5, dz);
   y0[5] = M.ys(dy + dmag[i][5] * .3826 * 1.5, dz);
   x0[6] = M.xs(dx - dmag[i][6] * .3826 * 1.7, dz);
   y0[6] = M.ys(dy + dmag[i][6] * .9238, dz);
   x0[7] = M.xs(dx + dmag[i][7] * .3826 * 1.7, dz);
   y0[7] = M.ys(dy + dmag[i][7] * .9238, dz);
   for (c = 0; c < 7; c++) {
    dmag[i][c] += 5 + (Math.random() * 15) * G.zz;
   }
   dmag[i][7] = dmag[i][6];
   boolean tf2 = true;
   long[] m = new long[4];
   for (c = 0; c < 8; c++) {
    if (y0[c] < 0 || dz < 10) {
     m[0]++;
    }
    if (y0[c] > M.h || dz < 10) {
     m[1]++;
    }
    if (x0[c] < 0 || dz < 10) {
     m[2]++;
    }
    if (x0[c] > M.w || dz < 10) {
     m[3]++;
    }
   }
   if (m[0] > 3 || m[1] > 3 || m[2] > 3 || m[3] > 3) {
    tf2 = false;
   }
   if (tf2) {
    double r = dc[i][0];
    double g = dc[i][1];
    double b = dc[i][2];
    if (M.fd != null) {
     for (c = 0; c < 160; c++) {
      if (dvp[i] > M.fd[c]) {
       r = (r * M.dnst + M.cfad[0]) / (M.dnst + 1);
       g = (g * M.dnst + M.cfad[1]) / (M.dnst + 1);
       b = (b * M.dnst + M.cfad[2]) / (M.dnst + 1);
      }
     }
    }
    double f1 = dbln[i] - dstg[i] * dbln[i] * .125;
    G.ct(r, g, b, f1 * 255);
    pth = new Path2D.Double();
    pth.moveTo(x0[0], y0[0]);
    for (p = 0; p < 8; p++) {
     pth.lineTo(x0[p], y0[p]);
    }
    pth.closePath();
    gs.fill(pth);
   }
   if (dstg[i] > 30 * Math.random()) {
    dstg[i] = 0;
   } else {
    dstg[i] += G.zz;
   }
  }
 }

 void dsmk(int i, Graphics2D gs, boolean tf) {
  int c;
  if (tf) {
   svp[i] = Math.sqrt(Math.pow(M.x + M.cx - smx[i], 2) + Math.pow(M.y + M.cy - smy[i], 2) + Math.pow(M.z + M.cz - smz[i], 2));
  }
  for (c = 0; c < 20; c++) {
   smy[c] -= M.grv[G.stg] * .125 * G.zz;
  }
  if (((tf && svp[i] > dist) || (!tf && svp[i] <= dist)) && smka > 0) {
   if (sstg[i] == 1) {
    sbln[i] = Math.max(0, Math.min(smka * .01, 1));
    for (c = 0; c < 8; c++) {
     smag[i][c] = 30 + som[i] * Math.random() * 50 * G.zz;
    }
   }
   double dx = M.cx + ((smx[i] - M.x - M.cx) * M.cos(M.xz) - (smz[i] - M.z - M.cz) * M.sin(M.xz));
   double dz = M.cz + ((smx[i] - M.x - M.cx) * M.sin(M.xz) + (smz[i] - M.z - M.cz) * M.cos(M.xz));
   double dy = M.cy + ((smy[i] - M.y - M.cy) * M.cos(M.zy) - (dz - M.cz) * M.sin(M.zy));
   dz = M.cz + ((smy[i] - M.y - M.cy) * M.sin(M.zy) + (dz - M.cz) * M.cos(M.zy));
   double[] x0 = new double[8];
   double[] y0 = new double[8];
   x0[0] = M.xs(dx + smag[i][0] * .9238 * 1.5, dz);
   y0[0] = M.ys(dy + smag[i][0] * .3826 * 1.5, dz);
   x0[1] = M.xs(dx + smag[i][1] * .9238 * 1.5, dz);
   y0[1] = M.ys(dy - smag[i][1] * .3826 * 1.5, dz);
   x0[2] = M.xs(dx + smag[i][2] * .3826, dz);
   y0[2] = M.ys(dy - smag[i][2] * .9238, dz);
   x0[3] = M.xs(dx - smag[i][3] * .3826, dz);
   y0[3] = M.ys(dy - smag[i][3] * .9238, dz);
   x0[4] = M.xs(dx - smag[i][4] * .9238 * 1.5, dz);
   y0[4] = M.ys(dy - smag[i][4] * .3826 * 1.5, dz);
   x0[5] = M.xs(dx - smag[i][5] * .9238 * 1.5, dz);
   y0[5] = M.ys(dy + smag[i][5] * .3826 * 1.5, dz);
   x0[6] = M.xs(dx - smag[i][6] * .3826, dz);
   y0[6] = M.ys(dy + smag[i][6] * .9238, dz);
   x0[7] = M.xs(dx + smag[i][7] * .3826, dz);
   y0[7] = M.ys(dy + smag[i][7] * .9238, dz);
   for (c = 0; c < 8; c++) {
    smag[i][c] += 5 + (Math.random() * 15) * G.zz;
   }
   boolean tf2 = true;
   long[] m = new long[4];
   for (c = 0; c < 8; c++) {
    if (y0[c] < 0 || dz < 10) {
     m[0]++;
    }
    if (y0[c] > M.h || dz < 10) {
     m[1]++;
    }
    if (x0[c] < 0 || dz < 10) {
     m[2]++;
    }
    if (x0[c] > M.w || dz < 10) {
     m[3]++;
    }
   }
   if (m[0] > 3 || m[1] > 3 || m[2] > 3 || m[3] > 3) {
    tf2 = false;
   }
   if (tf2) {
    double r = 255 - (smka * 2.55);
    double g = 255 - (smka * 2.55);
    double b = 255 - (smka * 2.55);
    if (M.fd != null) {
     for (c = 0; c < 160; c++) {
      if (svp[i] > M.fd[c]) {
       r = (r * M.dnst + M.cfad[0]) / (M.dnst + 1);
       g = (g * M.dnst + M.cfad[1]) / (M.dnst + 1);
       b = (b * M.dnst + M.cfad[2]) / (M.dnst + 1);
      }
     }
    }
    r = r + r * (M.snap[0] * .01);
    g = g + g * (M.snap[0] * .01);
    b = b + b * (M.snap[0] * .01);
    double f1 = sbln[i] - sstg[i] * sbln[i] * .125;
    G.ct(r, g, b, f1 * 255);
    pth = new Path2D.Double();
    pth.moveTo(x0[0], y0[0]);
    for (p = 0; p < 8; p++) {
     pth.lineTo(x0[p], y0[p]);
    }
    pth.closePath();
    gs.fill(pth);
   }
   if (sstg[i] > Math.min(20, 6 / G.zz)) {
    sstg[i] = 0;
   } else {
    sstg[i] += G.zz;
   }
  }
 }

 void djt(int i, Graphics2D gs, boolean tf) {
  int c;
  if (tf) {
   jvp[i] = Math.sqrt(Math.pow(M.x + M.cx - jx[i], 2) + Math.pow(M.y + M.cy - jy[i], 2) + Math.pow(M.z + M.cz - jz[i], 2));
  }
  if ((tf && jvp[i] > dist) || (!tf && jvp[i] <= dist)) {
   if (jstg[i] == 1) {
    for (c = 0; c < 8; c++) {
     jmag[i][c] = ojmag[i] * Math.random() * 50;
    }
   }
   double dx = M.cx + ((jx[i] - M.x - M.cx) * M.cos(M.xz) - (jz[i] - M.z - M.cz) * M.sin(M.xz));
   double dz = M.cz + ((jx[i] - M.x - M.cx) * M.sin(M.xz) + (jz[i] - M.z - M.cz) * M.cos(M.xz));
   double dy = M.cy + ((jy[i] - M.y - M.cy) * M.cos(M.zy) - (dz - M.cz) * M.sin(M.zy));
   dz = M.cz + ((jy[i] - M.y - M.cy) * M.sin(M.zy) + (dz - M.cz) * M.cos(M.zy));
   double[] x0 = new double[8];
   double[] y0 = new double[8];
   x0[0] = M.xs(dx + jmag[i][0] * .9238, dz);
   y0[0] = M.ys(dy + jmag[i][0] * .3826, dz);
   x0[1] = M.xs(dx + jmag[i][1] * .9238, dz);
   y0[1] = M.ys(dy - jmag[i][1] * .3826, dz);
   x0[2] = M.xs(dx + jmag[i][2] * .3826, dz);
   y0[2] = M.ys(dy - jmag[i][2] * .9238, dz);
   x0[3] = M.xs(dx - jmag[i][3] * .3826, dz);
   y0[3] = M.ys(dy - jmag[i][3] * .9238, dz);
   x0[4] = M.xs(dx - jmag[i][4] * .9238, dz);
   y0[4] = M.ys(dy - jmag[i][4] * .3826, dz);
   x0[5] = M.xs(dx - jmag[i][5] * .9238, dz);
   y0[5] = M.ys(dy + jmag[i][5] * .3826, dz);
   x0[6] = M.xs(dx - jmag[i][6] * .3826, dz);
   y0[6] = M.ys(dy + jmag[i][6] * .9238, dz);
   x0[7] = M.xs(dx + jmag[i][7] * .3826, dz);
   y0[7] = M.ys(dy + jmag[i][7] * .9238, dz);
   for (c = 0; c < 8; c++) {
    jmag[i][c] += (5 + (Math.random() * 15)) * G.zz;
   }
   boolean tf2 = true;
   long[] m = new long[4];
   for (c = 0; c < 8; c++) {
    if (y0[c] < 0 || dz < 10) {
     m[0]++;
    }
    if (y0[c] > M.h || dz < 10) {
     m[1]++;
    }
    if (x0[c] < 0 || dz < 10) {
     m[2]++;
    }
    if (x0[c] > M.w || dz < 10) {
     m[3]++;
    }
   }
   if (m[0] > 3 || m[1] > 3 || m[2] > 3 || m[3] > 3) {
    tf2 = false;
   }
   if (tf2) {
    G.c(255 - (5 * jstg[i] / Math.sqrt(G.zz)), 255 - (10 * jstg[i] / Math.sqrt(G.zz)), 0);
    pth = new Path2D.Double();
    pth.moveTo(x0[0], y0[0]);
    for (p = 0; p < 8; p++) {
     pth.lineTo(x0[p], y0[p]);
    }
    pth.closePath();
    gs.fill(pth);
   }
   if (jstg[i] > 19 || jstg[i] > (Math.random() * 40) / G.zz) {
    jstg[i] = 0;
   } else {
    jstg[i] += G.zz;
   }
  }
 }

 void sprk(double x0, double y0, double z0, double cvx, double cvy, double cvz, long flp) {
  if (flp != 1) {
   srx = x0 - sprkp * M.sin(xz);
   sry = y0 - sprkp * M.cos(zy) * M.cos(xy);
   srz = z0 + sprkp * M.cos(xz);
   sprk = 1;
  } else {
   sprk++;
   if (sprk == 4) {
    srx = x + cvx;
    sry = y0;
    srz = z + cvz;
    sprk = 5;
   } else {
    srx = x0;
    sry = y0;
    srz = z0;
   }
  }
  if (flp == 2) {
   sprk = 6;
  }
  rcx = cvx;
  rcy = cvy;
  rcz = cvz;
 }

 void dsprk(Graphics2D gs, boolean tf) {
  if (tf && sprk != 0) {
   double v1 = Math.min(Math.sqrt(Math.pow(rcx, 2) + Math.pow(rcy, 2) + Math.pow(rcz, 2)) * .1, 33);
   if (v1 > 5) {
    boolean tf1 = false;
    if (dist < Math.sqrt(Math.pow(M.x + M.cx - srx, 2) + Math.pow(M.y + M.cy - sry, 2) + Math.pow(M.z + M.cz - srz, 2))) {
     tf1 = true;
    }
    long d = 0;
    int c = 0;
    while (true) {
     if (c > 99) {
      break;
     }
     if (rtg[c] == 0) {
      rtg[c] = 1;
      rbef[c] = tf1;
      d++;
     }
     if (d >= v1) {
      break;
     }
     c++;
    }
   }
  }
  for (int n = 0; n < 100; n++) {
   if (rtg[n] == 0 || (!rbef[n] || !tf) && (rbef[n] || tf)) {
    continue;
   }
   if (rtg[n] == 1) {
    if (sprk < 5) {
     rx[n] = (srx + 3) - (Math.random() * 6.7);
     ry[n] = (sry + 3) - (Math.random() * 6.7);
     rz[n] = (srz + 3) - (Math.random() * 6.7);
    } else {
     rx[n] = (srx + 10) - (Math.random() * 20);
     ry[n] = sry - (Math.random() * 4);
     rz[n] = (srz + 10) - (Math.random() * 20);
    }
    double v1 = Math.sqrt(Math.pow(rcx, 2) + Math.pow(rcy, 2) + Math.pow(rcz, 2));
    double f = .2 + .4 * Math.random();
    double f1 = Math.random() * Math.random() * Math.random();
    long f2 = 1;
    if (Math.random() < .5) {
     if (Math.random() < .5) {
      f2 *= -1;
     }
     vrx[n] = -((rcx + v1 * (1 - rcx / v1) * f1 * f2) * f);
    }
    if (Math.random() < .5) {
     if (Math.random() < .5) {
      f2 *= -1;
     }
     if (sprk == 5) {
      f2 = 1;
     }
     vry[n] = -((rcy + v1 * (1 - rcy / v1) * f1 * f2) * f);
    }
    if (Math.random() < .5) {
     if (Math.random() < .5) {
      f2 *= -1;
     }
     vrz[n] = -((rcz + v1 * (1 - rcz / v1) * f1 * f2) * f);
    }
   }
   rx[n] += vrx[n];
   ry[n] += vry[n];
   rz[n] += vrz[n];
   double dx = M.cx + ((rx[n] - M.x - M.cx) * M.cos(M.xz) - (rz[n] - M.z - M.cz) * M.sin(M.xz));
   double dz = M.cz + ((rx[n] - M.x - M.cx) * M.sin(M.xz) + (rz[n] - M.z - M.cz) * M.cos(M.xz));
   double dy = M.cy + ((ry[n] - M.y - M.cy) * M.cos(M.zy) - (dz - M.cz) * M.sin(M.zy));
   dz = M.cz + ((ry[n] - M.y - M.cy) * M.sin(M.zy) + (dz - M.cz) * M.cos(M.zy));
   double dx1 = M.cx + (((rx[n] - M.x - M.cx) + vrx[n]) * M.cos(M.xz) - ((rz[n] - M.z - M.cz) + vrz[n]) * M.sin(M.xz));
   double dz1 = M.cz + (((rx[n] - M.x - M.cx) + vrx[n]) * M.sin(M.xz) + ((rz[n] - M.z - M.cz) + vrz[n]) * M.cos(M.xz));
   double dy1 = M.cy + (((ry[n] - M.y - M.cy) + vry[n]) * M.cos(M.zy) - (dz1 - M.cz) * M.sin(M.zy));
   dz1 = M.cz + (((ry[n] - M.y - M.cy) + vry[n]) * M.sin(M.zy) + (dz1 - M.cz) * M.cos(M.zy));
   double[] m = new double[4];
   m[0] = M.xs(dx, dz);
   m[1] = M.ys(dy, dz);
   m[2] = M.xs(dx1, dz1);
   m[3] = M.ys(dy1, dz1);
   if (m[0] < 0 && m[2] < 0) {
    rtg[n] = 0;
   }
   if (m[0] > M.w && m[2] > M.w) {
    rtg[n] = 0;
   }
   if (m[1] < 0 && m[3] < 0) {
    rtg[n] = 0;
   }
   if (m[1] > M.h && m[3] > M.h) {
    rtg[n] = 0;
   }
   if (ry[n] > 250) {
    rtg[n] = 0;
   }
   if (rtg[n] == 0) {
    continue;
   }
   double r = 255;
   double g = 197 - 30 * rtg[n];
   double b = 0;
   if (M.fd != null) {
    for (int v1 = 0; v1 < 160; v1++) {
     if (dz > M.fd[v1]) {
      r = (r * M.dnst + M.cfad[0]) / (M.dnst + 1);
      g = (g * M.dnst + M.cfad[1]) / (M.dnst + 1);
      b = (b * M.dnst + M.cfad[2]) / (M.dnst + 1);
     }
    }
   }
   G.c(r, g, b);
   gs.drawLine((int) m[0], (int) m[1], (int) m[2], (int) m[3]);
   vrx[n] = vrx[n] * .8;
   vry[n] = vry[n] * .8;
   vrz[n] = vrz[n] * .8;
   if (rtg[n] > 2) {
    rtg[n] = 0;
   } else {
    rtg[n]++;
   }
  }
  if (sprk != 0) {
   sprk = 0;
  }
 }
}
