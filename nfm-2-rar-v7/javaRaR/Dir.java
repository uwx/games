
class Dir {

 boolean up;
 boolean down;
 boolean left;
 boolean riht;
 boolean spac;
 boolean fir[];
 boolean bost;
 long loka;
 boolean entr;
 boolean aCrs;
 Mdm M;
 double pan;
 double vpan;
 long racn;
 boolean atak;
 boolean RBOP;
 double[] atpwr;
 long atrng;
 int vic;
 int fpth;
 int fpnt;
 boolean fixn;
 boolean fixD;
 boolean nofix;
 boolean revn;
 boolean TWD;
 boolean trnM;
 long ext;
 double acH;
 double acV;
 long trntyp;
 double aim;
 boolean wal[];
 boolean firn;
 long wtrn;
 long aRot[];
 boolean watn;
 int wpnt;
 long trgt;
 boolean bstn;
 long juk[] = {
  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2700, 0, 2700, 0, 2700,
  0, 0, 0, 0, 0, 0, 0, 1000, 0, 1000, 0, 0, 2700, 0, 2700, 2700, 0, 1000, 2700, 2700, 2700, 2700, 3000, 0, 2700, 2000, 2700, 0, 0, 3000, 0, 2700, 2000, 2000
 };
 double wait;
 double snow;
 int firAt;
 long[] sDist = {
  0, 0, 0, 0, 0, 0, 0, 0, 0, 10000, 0, 0, 0, 0, 0, 0,
  0, 0, 15000, 0, 10000, 0, 0, 15000, 15000, 20000, 0, 0, 0, 0, 0, 0, 0, 10000, 0, 100, Long.MAX_VALUE, 10000, 0, 0, 50000, 0, Long.MAX_VALUE, 0, 100000, 0, Long.MAX_VALUE, Long.MAX_VALUE, Long.MAX_VALUE, Long.MAX_VALUE
 };
 int pnt;

 Dir(Mdm m) {
  fir = new boolean[2];
  aRot = new long[2];
  atpwr = new double[2];
  wal = new boolean[4];
  M = m;
 }

 void act(Play p, Act a, Game g, Play[] ap) {
  up = false;
  down = false;
  left = false;
  riht = false;
  spac = false;
  fir[0] = false;
  fir[1] = false;
  bost = false;
  if (M.AId > 0) {
   if (revn) {
    double d = 2000;
    if (g.typ[pnt] == -1) {
     d = 3.3 * Math.abs(p.spd);
    }
    if (g.typ[pnt] == -2 || g.typ[pnt] == -3) {
     d = 500;
    }
    if (g.x_z(a.x * .01, g.x[pnt] * .01, a.z * .01, g.z[pnt] * .01) < d) {
     pnt--;
    }
    if (pnt < 0) {
     pnt += g.nS;
    }
    if (g.pos[p.im] < 1 && !((g.stg == 39 || g.stg == 49 || g.stg == 67) && g.cNm[p.cN] == "KILL-O-MATIC")) {
     revn = false;
    }
   } else {
    if (g.stg == 29 || g.stg == 39 || g.stg == 41 || g.stg == 50 || g.stg == 67 || g.nCk < 1) {
     pnt = p.pnt;
    } else {
     if (g.typ[pnt] > -2 || g.typ[pnt] == -4) {
      pnt++;
     }
     if (g.typ[pnt] == -2 && (g.x_z(a.x * .01, g.x[pnt] * .01, a.z * .01, g.z[pnt] * .01) < 500 || g.x_z(a.x, g.cx[p.clrL], a.z, g.cz[p.clrL]) < g.x_z(g.x[pnt], g.cx[p.clrL], g.z[pnt], g.cz[p.clrL]) || p.fas == 2)) {
      pnt++;
     }
     if (g.typ[pnt] == -3 && g.x_z(a.x * .01, g.x[pnt] * .01, a.z * .01, g.z[pnt] * .01) < 500) {
      pnt++;
     }
     if (g.nCk > 0) {
      if (p.clrL > 0) {
       if (pnt < g.cLoc[p.clrL - 1]) {
        pnt = g.cLoc[p.clrL - 1];
       }
       if (pnt > g.cLoc[p.clrL]) {
        pnt = g.cLoc[p.clrL];
       }
      } else {
       if (pnt < g.cLoc[g.nCk - 1] && pnt > g.cLoc[0]) {
        pnt = g.cLoc[0];
       }
      }
     }
     if (pnt >= g.nS) {
      pnt = 0;
     }
    }
   }
   int c;
   int b;
   if (racn > -1 && (g.cNm[p.cN] == "EPIC TANK" || g.cNm[p.cN] == "EL KING-OF-WAR" || g.cNm[p.cN] == "KILL-O-MATIC" || g.cNm[p.cN] == "TRAIN of TERROR" || g.cNm[p.cN] == "SuperSonic DeathRay" || p.typ[p.cN] == 2)) {
    racn = -1;
   }
   if (racn < 1 && (g.cNm[p.cN] == "Formula 7" || g.cNm[p.cN] == "La Vit Crab" || g.cNm[p.cN] == "Nimi" || g.cNm[p.cN] == "Mighty Eight" || g.cNm[p.cN] == "Radical One" || g.cNm[p.cN] == "Turbo Dragster" || g.cNm[p.cN] == "Lamborghini Gallardo" || g.cNm[p.cN] == "Radical Racer" || g.cNm[p.cN] == "Bugatti Veyron" || g.cNm[p.cN] == "Mighty Rocket Eight" || g.cNm[p.cN] == "The Awesome Radical One" || g.cNm[p.cN] == "Over=Kill" || g.cNm[p.cN] == "The Phantom" || g.cNm[p.cN] == "Everlast-177" || g.cNm[p.cN] == "Turbo Prop" || g.cNm[p.cN] == "A-1")) {
    racn = 1;
   }
   RBOP = M.AId > 1 && (g.stg == 10 || g.stg == 20 || g.stg == 30 || g.stg == 32 || g.stg == 47 || g.stg == 63 || g.stg == 64 || g.stg == 71 || ((g.stg == 10 || g.stg == 11) && g.cNm[p.cN] == "TRAIN of TERROR")) && g.cNm[p.cN] != "EPIC TANK" && g.cNm[p.cN] != "Tactical Nuke" && p.typ[p.cN] != 2 && g.nCk > 0;
   nofix = g.cNm[p.cN] == "KILL-O-MATIC" || g.cNm[p.cN] == "Tactical Nuke" || p.typ[p.cN] == 2 || (g.cNm[p.cN] == "EPIC TANK" && !fixD) || g.stg == 6 || g.stg == 10 || g.stg == 27 || g.stg == 29 || g.stg == 30 || g.stg == 31 || (g.stg == 35 && p.fas != 2) || (g.stg == 44 && racn > -1) || g.stg == 49 || g.stg == 51 || g.stg == 52 || g.stg == 63 || g.stg == 64 || g.stg == 67 || g.stg == 71 || g.nF < 1 || M.imrtl;
   if (g.nCk < 1 || M.AId < 2 || (revn && p.styp[p.cN] < 0 && p.s2typ[p.cN] < 0) || g.cNm[p.cN] == "Tactical Nuke" || g.stg == 69) {
    if (trgt != g.nC) {
     trgt = g.nC;
    }
   } else {
    if (trgt != 0) {
     trgt = 0;
    }
    if (g.cNm[p.cN] == "The Destroyer" || g.cNm[p.cN] == "TRAIN of TERROR") {
     trgt = g.pos[p.im];
    }
   }
   if (M.AId > 1) {
    if (p.fas == 2 || p.typ[p.cN] == 2) {
     acH = Math.min(g.zz, 1);
     acV = 3 * g.zz;
     if (p.typ[p.cN] == 2) {
      acV = g.zz;
     }
    } else {
     acH = 5;
     acV = 5;
     if (g.stg == 30 || g.stg == 43) {
      acH = 4;
     }
     if (g.stg == 12 || g.stg == 16) {
      acH = 3;
     }
     if (g.stg == 6) {
      acH = 2;
     }
     if (g.cNm[p.cN] == "EPIC TANK" || (g.cNm[p.cN] == "TRAIN of TERROR" && firn) || g.stg == 67) {
      acH = 1;
     }
    }
   } else {
    acH = 5;
    acV = 5;
   }
   trntyp = (long) (Math.random() * 3);
   if (M.AId > 1) {
    if (trntyp != 1 && (g.stg == 13 || g.stg == 17 || g.stg == 29 || g.stg == 39 || g.stg == 43 || g.stg == 67)) {
     trntyp = 1;
    }
    if (trntyp != 0 && (g.stg == 8 || g.stg == 10 || g.stg == 14 || g.stg == 22 || g.stg == 25 || g.stg == 30 || g.stg == 31 || g.stg == 37 || g.stg == 63 || g.stg == 64)) {
     trntyp = 0;
    }
    if (atak) {
     if (g.stg == 9 || g.stg == 11 || g.stg == 13 || g.stg == 17) {
      trntyp = (long) (Math.random() * 3);
     }
     if (trntyp != 0 && g.stg == 16 && p.clr - g.aclr[vic] > 4) {
      trntyp = 0;
     }
    }
    if (trntyp != 2 && (g.stg == 9 || g.stg == 12 || g.stg == 43) && fpth < fpnt + 2 && fixn) {
     trntyp = 2;
    }
    if (trntyp != 1 && ((g.stg == 3 && p.im == 6) || g.cNm[p.cN] == "Drifter X" || g.cNm[p.cN] == "Radical One" || g.cNm[p.cN] == "Turbo Dragster" || g.cNm[p.cN] == "Radical Racer" || g.cNm[p.cN] == "Bugatti Veyron" || g.cNm[p.cN] == "EL ROCKET KING" || g.cNm[p.cN] == "Mighty Rocket Eight" || g.cNm[p.cN] == "Rocket M A S H E E N" || g.cNm[p.cN] == "DR Rocket Monstaa" || g.cNm[p.cN] == "The Phantom" || g.cNm[p.cN] == "F-22 Raptor")) {
     trntyp = 1;
    }
    if (trntyp != 2 && (g.cNm[p.cN] == "Zonich Tank" || g.cNm[p.cN] == "Matlos Tank" || g.cNm[p.cN] == "The Awesome Radical One" || g.cNm[p.cN] == "Over=Kill" || g.cNm[p.cN] == "Lightning Rod" || g.cNm[p.cN] == "The Destroyer" || g.cNm[p.cN] == "Everlast-177" || g.cNm[p.cN] == "TRAIN of TERROR" || g.cNm[p.cN] == "Tactical Nuke" || g.cNm[p.cN] == "A-1" || g.cNm[p.cN] == "SuperSonic DeathRay")) {
     trntyp = 2;
    }
    if (trntyp != 0 && (g.cNm[p.cN] == "M A S H E E N" || g.cNm[p.cN] == "OW SLAMINARO" || g.cNm[p.cN] == "EPIC TANK" || g.cNm[p.cN] == "KILL-O-MATIC" || ((g.cNm[p.cN] == "Everlast-177" || g.cNm[p.cN] == "TRAIN of TERROR") && fixn) || (p.typ[p.cN] == 1 && ap[vic].fas == 2 && atak))) {
     trntyp = 0;
    }
   }
   TWD = g.cNm[p.cN] == "OW SLAMINARO" || (p.typ[p.cN] == 1 && ap[vic].fas == 2 && atak) || ((g.cNm[p.cN] == "Everlast-177" || g.cNm[p.cN] == "TRAIN of TERROR") && fixn) || (g.stg == 3 && p.im == 6 && !atak) || ((g.stg == 6 || g.stg == 7 || g.stg == 8 || g.stg == 10 || g.stg == 11 || g.stg == 12 || g.stg == 14 || g.stg == 16 || g.stg == 20 || g.stg == 21 || g.stg == 25 || g.stg == 26 || g.stg == 30 || g.stg == 33 || g.stg == 36 || g.stg == 37 || g.stg == 40 || g.stg == 44 || g.stg == 45 || g.stg == 46 || g.stg == 48 || g.stg == 51 || g.stg == 52 || g.stg == 54 || g.stg == 63 || g.stg == 64 || g.stg == 68 || g.stg == 69) && g.cNm[p.cN] != "Everlast-177");
   if (!revn && (g.pos[p.im] > 0 || M.AId < 2)) {
    if (g.stg == 16 && (g.cNm[p.cN] == "M A S H E E N" || g.cNm[p.cN] == "KILL-O-MATIC" || (g.cNm[p.cN] == "EL KING" && g.aclr[vic] - p.clr > 0))) {
     pnt = (int) (Math.random() * (g.nS - 1));
     revn = true;
    }
    if ((g.cNm[p.cN] == "M A S H E E N" || g.cNm[p.cN] == "EPIC TANK" || g.cNm[p.cN] == "KILL-O-MATIC") && (g.stg == 2 || g.stg == 3 || g.stg == 4 || g.stg == 5 || g.stg == 8 || g.stg == 10 || g.stg == 13 || g.stg == 49 || g.stg == 50 || g.stg == 63 || g.stg == 64)) {
     pnt = (int) (Math.random() * (g.nS - 1));
     revn = true;
    }
    if (g.stg == 19 || (g.stg == 25 && (racn < 0 || g.cNm[p.cN] == "M A S H E E N")) || ((g.stg == 10 || g.stg == 14 || g.stg == 30 || g.stg == 44 || g.stg == 49 || g.stg == 63 || g.stg == 64 || g.stg == 67) && g.cNm[p.cN] == "KILL-O-MATIC") || ((g.stg == 10 || g.stg == 11) && g.cNm[p.cN] == "TRAIN of TERROR") || ((g.stg == 46 || g.stg == 62) && g.cNm[p.cN] == "EPIC TANK") || ((g.stg == 11 || g.stg == 12) && (g.cNm[p.cN] == "M A S H E E N" || g.cNm[p.cN] == "EPIC TANK" || g.cNm[p.cN] == "KILL-O-MATIC"))) {
     pnt = (int) (Math.random() * (g.nS - 1));
     revn = true;
    }
    if (g.stg == 49 && g.cNm[p.cN] == "KILL-O-MATIC") {
     pnt = g.nS - 7;
    }
   }
   long fdam = 75;
   if (M.AId > 1) {
    if (g.stg == 9) {
     fdam = 70;
    }
    if (g.stg == 15 || g.stg == 33) {
     fdam = 50;
    }
    if (g.stg == 16 && racn > 0 && g.cNm[p.cN] != "High Rider" && g.cNm[p.cN] != "Mighty Eight") {
     fdam = 50;
    }
    if (g.stg == 45) {
     fdam = 60;
    }
    if (g.stg == 68) {
     fdam = 40;
    }
   }
   if (100 * p.dam / p.dura[p.cN] >= fdam && !nofix) {
    if (!fixn) {
     fixn = true;
    }
   } else {
    if (fixn) {
     fixn = false;
    }
    if (fpth != fpnt) {
     fpth = fpnt;
    }
   }
   if (!watn && M.AId > 1 && (g.stg == 12 || g.stg == 16 || g.stg == 34 || g.stg == 50) && (g.cNm[p.cN] == "M A S H E E N" || g.cNm[p.cN] == "EPIC TANK" || g.cNm[p.cN] == "KILL-O-MATIC") && p.pwr > 50) {
    watn = true;
   }
   if (!atak) {
    atpwr[0] = 100;
    if (g.stg == 51) {
     atpwr[0] = Math.random() * 101;
    }
    if (racn > 0 && g.nCk > 0) {
     atpwr[0] = 101;
    }
    if (revn) {
     atpwr[0] = Math.min(atpwr[0], 75);
    }
    if (g.stg == 21 || g.stg == 60 || g.stg == 65 || racn < 0) {
     atpwr[0] = 0;
    }
    if (g.cNm[p.cN] == "OW SLAMINARO") {
     atpwr[0] = 75;
    }
    if (g.cNm[p.cN] == "The Destroyer") {
     atpwr[0] = 100;
    }
    if (g.stg == 60 || g.cNm[p.cN] == "Tactical Nuke") {
     atpwr[0] = 0;
    }
    atpwr[1] = atpwr[0] * .75;
    if (g.cNm[p.cN] == "OW SLAMINARO") {
     atpwr[1] = 50;
    }
    if (revn) {
     atpwr[1] = Math.min(atpwr[1], atpwr[0] * .5);
    }
    if (p.styp[p.cN] >= 0) {
     atpwr[1] = p.slos[p.styp[p.cN]];
    }
    if (p.s2typ[p.cN] >= 0) {
     atpwr[1] = p.s2los[p.s2typ[p.cN]];
    }
    if (RBOP) {
     atrng = 0;
     if (g.aclr[vic] > p.clr) {
      atrng = 2000 * (g.aclr[vic] - p.clr) * (g.aclr[vic] - p.clr);
     }
    } else {
     atrng = Long.MAX_VALUE;
    }
    if (atrng > 10000 && revn && p.styp[p.cN] < 0 && p.s2typ[p.cN] < 0) {
     atrng = 10000;
    }
    if (atrng > 5000 && g.stg == 49 && g.cNm[p.cN] == "KILL-O-MATIC") {
     atrng = 5000;
    }
    if (M.fd != null) {
     if (atrng > M.fd[159] && (g.stg == 10 || g.stg == 20 || g.stg == 39 || g.stg == 67)) {
      atrng = M.fd[159];
     }
    }
    if (vic != p.im && !ap[vic].dest && (g.pos[vic] <= trgt || g.nCk < 1 || g.stg == 69 || ((g.cNm[p.cN] == "M A S H E E N" || g.cNm[p.cN] == "EPIC TANK" || g.cNm[p.cN] == "EL KING-OF-WAR" || g.cNm[p.cN] == "KILL-O-MATIC" || g.cNm[p.cN] == "TRAIN of TERROR" || g.cNm[p.cN] == "Tactical Nuke" || g.cNm[p.cN] == "SuperSonic DeathRay" || p.typ[p.cN] == 2) && g.pos[p.im] < 1)) && g.x_z(a.x * .01, g.opx[vic] * .01, a.z * .01, g.opz[vic] * .01) <= atrng && (p.pwr >= atpwr[0] || p.pwrs[p.cN] < 0)) {
     atak = true;
     aim = 0;
     if (g.stg == 3 && p.im == 6 && Math.random() < .5) {
      aim = 1;
     }
     if (g.stg == 4) {
      if (g.pos[vic] < g.pos[p.im]) {
       aim = 1.5;
      } else {
       aim = Math.random();
      }
     }
     if (g.stg == 5) {
      aim = Math.random() * 1.5;
     }
     if (g.stg == 7 && p.im != 6 && (Math.random() < .5 || g.pos[vic] < g.pos[p.im])) {
      aim = 1;
     }
     if (g.stg == 8 && g.cNm[p.cN] == "EL KING" && Math.random() < .5) {
      aim = .76 + Math.random() * .76;
     }
     if (g.stg == 9) {
      aim = 1;
     }
     if (g.stg == 11) {
      if (revn) {
       aim = .7;
      } else {
       aim = Math.random();
      }
     }
     if (g.stg == 12 && Math.random() < .5) {
      aim = .7;
     }
     if (g.stg == 15 || g.stg == 16 || g.stg == 36) {
      aim = Math.random() * 1.5;
     }
     if (g.stg == 19 || g.stg == 60) {
      aim = Math.random() * ap[vic].spd / 150.;
     }
     if (vic != 0 && !ap[0].dest && (g.stg == 28 || g.stg == 45 || g.stg == 65 || g.stg == 68)) {
      vic = 0;
     }
    }
   }
   if (vic == p.im || (ap[vic].dest && g.dstd < g.nC - 1) || (g.nCk > 0 && g.stg != 69 && g.pos[vic] > trgt && !((g.cNm[p.cN] == "M A S H E E N" || g.cNm[p.cN] == "EPIC TANK" || g.cNm[p.cN] == "EL KING-OF-WAR" || g.cNm[p.cN] == "KILL-O-MATIC" || g.cNm[p.cN] == "TRAIN of TERROR" || g.cNm[p.cN] == "Tactical Nuke" || g.cNm[p.cN] == "SuperSonic DeathRay" || p.typ[p.cN] == 2) && g.pos[p.im] < 1)) || (p.pwrs[p.cN] > -1 && p.pwr < atpwr[1]) || (g.cNm[p.cN] != "Tactical Nuke" && p.styp[p.cN] < 0 && p.s2typ[p.cN] < 0 && g.cNm[g.C[vic]] == "KILL-O-MATIC")) {
    if (atak) {
     atak = false;
    }
    vic = (int) (Math.random() * g.nC);
   }
   if (atak) {
    if (g.cNm[p.cN] == "KILL-O-MATIC" && (g.stg == 67 || (g.stg == 49 && ap[vic].typ[ap[vic].cN] == 2))) {
     atak = false;
    }
    if (g.stg == 16) {
     if ((g.cNm[p.cN] == "M A S H E E N" || g.cNm[p.cN] == "KILL-O-MATIC") && (g.aclr[vic] == 4 || g.aclr[vic] == 13 || g.aclr[vic] == 21)) {
      atak = false;
     }
     if (g.pos[vic] > g.pos[p.im] && p.pwr < 80) {
      atak = false;
     }
     if (g.aclr[vic] - p.clr < 2) {
      atak = false;
     }
    }
    if ((revn || RBOP) && g.x_z(a.x * .01, g.opx[vic] * .01, a.z * .01, g.opz[vic] * .01) > atrng) {
     atak = false;
    }
    if (racn > 0 && g.nCk > 0) {
     atak = false;
    }
    if (ap[vic].dest || fixn) {
     atak = false;
    }
   }
   if (atak) {
    double f = Math.sqrt(g.x_z(a.x, g.opx[vic], a.z, g.opz[vic])) * .5 * aim;
    double px = g.opx[vic];
    double pz = g.opz[vic];
    if (g.cNm[p.cN] != "YottaVolt Particle Disintegrator" && M.AId > 1 && Math.abs(ap[vic].fas) != 1) {
     if (ap[vic].spd > 0 && ap[vic].spd >= p.spd) {
      px -= f * M.sin(ap[vic].txz);
      pz += f * M.cos(ap[vic].txz);
     }
     if (ap[vic].spd < 0 && ap[vic].spd <= p.spd) {
      px += f * M.sin(ap[vic].txz);
      pz -= f * M.cos(ap[vic].txz);
     }
    }
    c = 0;
    if (px - a.x >= 0) {
     c = 180;
    }
    pan = ((90 + c) + Math.atan((pz - a.z) / (px - a.x)) * 57.295779513082320876798154814105);
    if (p.fas == 2 || p.typ[p.cN] == 2) {
     f = g.x_y_z(a.x * .01, g.opx[vic] * .01, a.y * .01, g.opy[vic] * .01, a.z * .01, g.opz[vic] * .01) * .01 * aim;
     double d = Math.sqrt(Math.pow(g.opz[vic] - a.z, 2) + Math.pow(g.opx[vic] - a.x, 2));
     double py = g.opy[vic];
     if (g.cNm[p.cN] != "YottaVolt Particle Disintegrator" && M.AId > 1 && Math.abs(ap[vic].fas) != 1) {
      if (ap[vic].spd > 0 && ap[vic].spd >= p.spd) {
       py -= f * M.sin(ap[vic].tzy);
      }
      if (ap[vic].spd < 0 && ap[vic].spd <= p.spd) {
       py += f * M.sin(ap[vic].tzy);
      }
     }
     if (g.opy[vic] < a.y) {
      vpan = -(-90 - Math.atan(d / (py - a.y)) * 57.295779513082320876798154814105);
     }
     if (g.opy[vic] > a.y) {
      vpan = -(90 - Math.atan(d / (py - a.y)) * 57.295779513082320876798154814105);
     }
     if (Math.abs(vpan - a.zy) > acV) {
      if (vpan > a.zy) {
       up = false;
       down = true;
      }
      if (vpan < a.zy) {
       down = false;
       up = true;
      }
     }
     if (M.AId > 1 && g.cNm[p.cN] == "Gun Turret" && a.y > 20 && a.zy < 0) {
      up = false;
      down = true;
     }
    }
   } else {
    c = 0;
    if (g.x[pnt] - a.x >= 0) {
     c = 180;
    }
    pan = (90 + c) + Math.atan((g.z[pnt] - a.z) / (g.x[pnt] - a.x)) * 57.295779513082320876798154814105;
   }
   if (watn && g.x_z(a.x * .01, g.cx[wpnt] * .01, a.z * .01, g.cz[wpnt] * .01) > 200) {
    c = 0;
    if (g.cx[wpnt] - a.x >= 0) {
     c = 180;
    }
    pan = (90 + c) + Math.atan((g.cz[wpnt] - a.z) / (g.cx[wpnt] - a.x)) * 57.295779513082320876798154814105;
   }
   if (fixn) {
    if (p.fas == 2 || fixD) {
     c = 0;
     if (g.fx[0] - a.x >= 0) {
      c = 180;
     }
     pan = (90 + c) + Math.atan((g.fz[0] - a.z) / (g.fx[0] - a.x)) * 57.295779513082320876798154814105;
    } else if (p.typ[p.cN] == 0) {
     c = 0;
     if (g.x[fpth] - a.x >= 0) {
      c = 180;
     }
     long d = 750;
     if (g.typ[fpth] == -1 || g.typ[fpth] == -2) {
      d = 500;
     }
     if (g.typ[fpth] == -3) {
      d = 250;
     }
     if (g.x_z(a.x * .01, g.x[fpth] * .01, a.z * .01, g.z[fpth] * .01) > d) {
      pan = (90 + c) + Math.atan((g.z[fpth] - a.z) / (g.x[fpth] - a.x)) * 57.295779513082320876798154814105;
     } else {
      fpth++;
      if (fpth > g.nS) {
       fpth = fpnt;
      }
     }
     if (g.x_z(a.x * .01, g.x[fpnt] * .01, a.z * .01, g.z[fpnt] * .01) > 40000 || wal[0] || wal[1] || wal[2] || wal[3]) {
      fpth = fpnt;
     }
    }
   }
   if (p.fas != 1) {
    if (p.fas != 2 && p.typ[p.cN] != 2) {
     up = true;
    }
    while (true) {
     if (Math.abs(a.xz - pan) <= 180) {
      break;
     }
     if (pan > a.xz) {
      pan -= 360;
     } else if (pan < a.xz) {
      pan += 360;
     }
    }
    if (p.fas == 2) {
     if (Math.abs(a.xz - pan) < 90 || wal[0] || wal[1] || wal[2] || wal[3]) {
      ext = 20;
     } else {
      ext = 0;
     }
     if (M.AId > 1) {
      if (trnM && ((a.xz < pan && a.xy < 0) || (a.xz > pan && a.xy > 0)) && !(wal[0] || wal[1] || wal[2] || wal[3])) {
       acH = 90;
       trnM = false;
      }
     }
    }
    if (Math.abs(a.xz - pan) > acH) {
     if (a.xz < pan) {
      left = true;
      trnM = true;
     }
     if (a.xz > pan) {
      riht = true;
      trnM = true;
     }
     if (Math.abs(a.xz - pan) > 50 && p.spd > 50 && trntyp != 0 && p.fas != 2 && p.typ[p.cN] != 2 && !(M.grv[g.stg] == 0 && p.typ[p.cN] == 1 && p.fas == -1)) {
      if (trntyp == 1) {
       down = true;
       if (p.spd > 100) {
        up = false;
       }
       if (p.spd < -100) {
        down = false;
       }
      }
      if (trntyp == 2) {
       if (p.fas != -1) {
        spac = true;
       }
       if (p.spd > 100) {
        up = false;
       }
       if (p.spd < -100) {
        down = false;
       }
      }
      if (!TWD) {
       up = false;
      }
     }
    }
    if (p.typ[p.cN] != 2) {
     if ((wal[0] || wal[1] || wal[2] || wal[3]) && !firn && !((g.stg == 31 || g.stg == 39 || g.stg == 49 || g.stg == 51 || g.stg == 59 || g.stg == 67 || g.stg == 68) && Math.random() < .5)) {
      if (p.fas == 2) {
       up = false;
       down = true;
      }
      if (wtrn == 0 && ((wal[0] && wal[1]) || (wal[2] && wal[3]))) {
       if (Math.random() < .5) {
        wtrn = 1;
       } else {
        wtrn = -1;
       }
      }
      if ((wal[0] || wal[2]) && !(wal[1] || wal[3])) {
       wtrn = 0;
       left = false;
       riht = true;
      }
      if ((wal[1] || wal[3]) && !(wal[0] || wal[2])) {
       wtrn = 0;
       riht = false;
       left = true;
      }
      if (wtrn > 0) {
       riht = false;
       left = true;
      }
      if (wtrn < 0) {
       left = false;
       riht = true;
      }
     }
    }
   }
   if (watn) {
    if (g.x_z(a.x * .01, g.cx[wpnt] * .01, a.z * .01, g.cz[wpnt] * .01) < 100 && g.x_y_z(a.x * .01, g.opx[vic] * .01, a.z * .01, g.opz[vic] * .01, a.y * .01, g.opy[vic] * .01) > 200) {
     up = false;
     down = false;
     spac = true;
    }
    if (p.pwr < 50) {
     wpnt = (int) (Math.random() * (g.nCk - 1));
     watn = false;
    }
   }
   if (p.typ[p.cN] == 0 && Math.abs(p.fas) == 1 && g.stg != 67) {
    if (a.y + a.wG < -p.flpy[p.cN] && Math.sqrt(Math.pow(p.stxy, 2) + Math.pow(p.stxz, 2) + Math.pow(p.stzy, 2)) <= 4000 && (M.AId < 2 || ((g.stg != 29 && p.nvy <= 0) || (g.stg == 29 && (a.y + a.wG > -300000 || a.y + a.wG < -301000))) || (p.ars[p.cN] < .35 && p.pwrs[p.cN] > -1))) {
     spac = true;
     if (M.AId > 1 && (g.stg == 6 || g.stg == 14 || g.stg == 30 || g.stg == 54)) {
      aRot[0] = 1;
     }
     if (aRot[0] > 0) {
      up = true;
     }
     if (aRot[0] < 0) {
      down = true;
     }
     if (aRot[1] > 0) {
      riht = true;
     }
     if (aRot[1] < 0) {
      left = true;
     }
     if (g.stg == 29) {
      up = false;
      down = true;
      left = false;
      riht = false;
     }
    } else if ((p.fas == 1 || p.flp || Math.sqrt(Math.pow(p.stxy, 2) + Math.pow(p.stxz, 2) + Math.pow(p.stzy, 2)) > 4000) && M.AId > 1) {
     if (p.flp) {
      spac = true;
     }
     if (a.xy > 30) {
      left = true;
     }
     if (a.xy < -30) {
      riht = true;
     }
     if (a.zy < -30) {
      down = true;
     }
     if (a.zy > 30) {
      up = true;
     }
    }
    if (g.nF > 0 && M.AId > 1 && p.dam > 0) {
     for (b = g.nF - 1; b > -1; b--) {
      if (g.x_z(a.x * .01, g.fx[b] * .01, a.z * .01, g.fz[b] * .01) < 10000) {
       if (Math.abs(p.nvz) > Math.abs(p.nvx) && ((p.nvz > 0 && g.fz[b] > a.z) || (p.nvz < 0 && g.fz[b] < a.z))) {
        up = false;
        down = g.fy[b] < a.y;
        if (Math.abs(a.zy) < 90) {
         if (Math.abs(a.xz) < 90) {
          riht = g.fx[b] > a.x;
          left = g.fx[b] < a.x;
         }
         if (a.xz > 90 || a.xz < -90) {
          riht = g.fx[b] < a.x;
          left = g.fx[b] > a.x;
         }
        } else {
         if (Math.abs(a.xz) < 90) {
          riht = g.fx[b] < a.x;
          left = g.fx[b] > a.x;
         }
         if (a.xz > 90 || a.xz < -90) {
          riht = g.fx[b] > a.x;
          left = g.fx[b] < a.x;
         }
        }
       }
       if (Math.abs(p.nvx) > Math.abs(p.nvz) && ((p.nvx > 0 && g.fx[b] > a.x) || (p.nvx < 0 && g.fx[b] < a.x))) {
        up = false;
        down = g.fy[b] < a.y;
        if (Math.abs(a.zy) < 90) {
         if (a.xz < 0) {
          riht = g.fz[b] < a.z;
          left = g.fz[b] > a.z;
         }
         if (a.xz > 0) {
          riht = g.fz[b] > a.z;
          left = g.fz[b] < a.z;
         }
        } else {
         if (a.xz < 0) {
          riht = g.fz[b] > a.z;
          left = g.fz[b] < a.z;
         }
         if (a.xz > 0) {
          riht = g.fz[b] < a.z;
          left = g.fz[b] > a.z;
         }
        }
       }
      }
     }
    }
   }
   if (p.fas == 2) {
    long ey = -250;
    if (!(atak || fixn)) {
     double d = Math.sqrt(Math.pow(g.cz[p.clrL] - a.z, 2) + Math.pow(g.cx[p.clrL] - a.x, 2));
     if (g.cy[p.clrL] + ey < a.y) {
      vpan = -(-90 - Math.atan(d / ((g.cy[p.clrL] + ey) - a.y)) * 57.295779513082320876798154814105);
     }
     if (g.cy[p.clrL] + ey > a.y) {
      vpan = -(90 - Math.atan(d / ((g.cy[p.clrL] + ey) - a.y)) * 57.295779513082320876798154814105);
     }
     if (Math.abs(vpan - a.zy) > acV) {
      if (vpan > a.zy) {
       up = false;
       down = true;
      }
      if (vpan < a.zy) {
       down = false;
       up = true;
      }
     }
    }
    if (fixn) {
     double d = Math.sqrt(Math.pow(g.fz[0] - a.z, 2) + Math.pow(g.fx[0] - a.x, 2));
     if (g.fy[0] + ey < a.y) {
      vpan = -(-90 - Math.atan(d / ((g.fy[0] + ey) - a.y)) * 57.295779513082320876798154814105);
     }
     if (g.fy[0] + ey > a.y) {
      vpan = -(90 - Math.atan(d / ((g.fy[0] + ey) - a.y)) * 57.295779513082320876798154814105);
     }
     if (Math.abs(vpan - a.zy) > acV) {
      if (vpan > a.zy) {
       up = false;
       down = true;
      }
      if (vpan < a.zy) {
       down = false;
       up = true;
      }
     }
    }
    if (Math.abs(a.xy) > 80 && Math.abs(a.xy) < 100) {
     if ((a.xz > pan && a.xy < 0) || (a.xz < pan && a.xy > 0)) {
      down = false;
      up = true;
     }
     if ((a.xz < pan && a.xy < 0) || (a.xz > pan && a.xy > 0)) {
      up = false;
      down = true;
     }
    }
    if (g.cNm[p.cN] != "SuperSonic DeathRay") {
     if (up && a.xy > 10 * g.zz && Math.abs(a.xy) > 40) {
      riht = false;
      left = true;
     }
     if (up && a.xy < -10 * g.zz && Math.abs(a.xy) > 40) {
      left = false;
      riht = true;
     }
    }
    if (a.xy >= 60 + ext) {
     riht = false;
    }
    if (a.xy <= -60 - ext) {
     left = false;
    }
    if (g.cNm[p.cN] == "SuperSonic DeathRay") {
     if (a.xy >= 65 + ext) {
      left = true;
     }
     if (a.xy <= -65 - ext) {
      riht = true;
     }
    } else {
     if (a.xy >= 70 + ext) {
      left = true;
     }
     if (a.xy <= -70 - ext) {
      riht = true;
     }
    }
    if (a.zy <= -80) {
     up = false;
    }
    if (a.zy >= 80) {
     down = false;
    }
    if (a.zy <= -90) {
     down = true;
    }
    if (a.zy >= 90) {
     up = true;
    }
    if (g.cNm[p.cN] == "F-22 Raptor") {
     if (M.AId > 1 && p.spd < 400) {
      bstn = true;
     }
     if (p.spd > 600) {
      bstn = false;
     }
     if (bstn || (M.AId > 1 && atak && ap[vic].spd > p.spd)) {
      bost = true;
     }
     if (g.pos[p.im] > 0 && (((a.y > -1000 || a.y > g.fy[0]) && M.AId > 1) || (a.zy < -10 && M.grv[g.stg] > 0)) && Math.abs(a.xy) < 90) {
      up = false;
      down = true;
     }
    }
   }
   if (p.typ[p.cN] == 1) {
    if (M.grv[g.stg] == 0) {
     if (p.fas == -1) {
      spac = g.stg == 66 || (M.AId < 2 && g.stg == 70 && p.spd > Math.random() * 2000 + 1000) || (M.AId > 1 && g.stg == 70 && p.spd > Math.random() * 4000 + 2000);
     }
    } else {
     if (p.fas < 1 && ((M.AId > 1 && atak && g.opy[vic] < a.y - 1000 && p.spd > Math.max(ap[vic].spd, 450)) || (fixn && p.spd > 450) || (g.cNm[p.cN] == "Turbo Prop" && p.spd > 420))) {
      spac = true;
      if (p.fas == 0) {
       down = true;
      }
     }
     if (p.fas == -1 && p.spd > 300 + (Math.random() * 120)) {
      spac = true;
     }
    }
   }
   if (M.AId > 1 && g.cNm[p.cN] == "KILL-O-MATIC" && (revn || g.stg == 9 || g.stg == 17 || g.stg == 47 || g.stg == 49)) {
    if (Math.random() < .05) {
     aim += (Math.random() * 20) - (Math.random() * 20);
    }
    if (aim < 0 || aim > 20) {
     aim = Math.random() * 20;
    }
   }
   if (g.cNm[p.cN] == "Tactical Nuke" && wait > 0) {
    up = false;
    down = false;
    wait -= g.zz;
   }
   for (b = 0; b < g.nC; b++) {
    if ((g.cNm[p.cN] == "Lightning Rod" && M.AId > 1) || (g.cNm[p.cN] == "EL KING-OF-WAR" && trgt > 0)) {
     firAt = b;
    } else {
     firAt = vic;
    }
    if ((atak || (g.cNm[p.cN] == "Lightning Rod" && M.AId > 1)) && (p.fas == 0 || p.fas == 2) && p.styp[p.cN] >= 0 && g.cNm[p.cN] != "F-22 Raptor") {
     if (b != p.im && !ap[b].dest && p.pwr >= p.slos[p.styp[p.cN]] && (g.x_y_z(a.x * .01, g.opx[firAt] * .01, a.z * .01, g.opz[firAt] * .01, a.y * .01, g.opy[firAt] * .01) < sDist[p.cN] || M.AId < 2)) {
      fir[0] = true;
      if (!firn && g.cNm[p.cN] != "Lightning Rod" && g.cNm[p.cN] != "EL KING-OF-WAR") {
       firn = true;
      }
     }
    }
    if ((g.cNm[p.cN] == "EL KING-OF-WAR" || g.cNm[p.cN] == "TRAIN of TERROR") && trgt > 0) {
     firAt = b;
    } else {
     firAt = vic;
    }
    if (atak && (p.fas == 0 || p.fas == 2) && p.s2typ[p.cN] >= 0 && p.s2typ[p.cN] != 2) {
     if (b != p.im && !ap[b].dest && p.pwr >= p.s2los[p.s2typ[p.cN]] && ((g.cNm[p.cN] != "EL KING-OF-WAR" && g.x_y_z(a.x * .01, g.opx[firAt] * .01, a.z * .01, g.opz[firAt] * .01, a.y * .01, g.opy[firAt] * .01) < sDist[p.cN]) || (g.cNm[p.cN] == "EL KING-OF-WAR" && M.AId > 1 && g.x_y_z(a.x * .01, g.opx[firAt] * .01, a.z * .01, g.opz[firAt] * .01, a.y * .01, g.opy[firAt] * .01) >= sDist[p.cN]))) {
      fir[1] = true;
      if (!firn && g.cNm[p.cN] != "EL KING-OF-WAR") {
       firn = true;
      }
     }
    }
   }
   if (g.cNm[p.cN] == "EPIC TANK") {
    fir[1] = false;
    for (b = 0; b < g.nCk; b++) {
     if (!watn && M.AId > 1 && g.x_y_z(a.x * .01, g.cx[b] * .01, a.z * .01, g.cz[b] * .01, a.y * .01, g.cy[b] * .01) < 100 && p.pwr >= p.s2los[p.s2typ[p.cN]]) {
      fir[1] = true;
     }
    }
    if (M.AId > 1) {
     if (fir[0] && (p.pwr < 50 || p.pwr < Math.random() * 2000)) {
      fir[0] = false;
     }
     for (b = 0; b < g.nC; b++) {
      if (b != p.im && !ap[b].dest && g.cNm[g.C[b]] != "Tactical Nuke" && g.x_y_z(a.x * .01, g.opx[b] * .01, a.z * .01, g.opz[b] * .01, a.y * .01, g.opy[b] * .01) < 400 && p.pwr >= p.slos[p.styp[p.cN]]) {
       fir[0] = true;
      }
     }
    }
   }
   if (g.cNm[p.cN] == "SuperSonic DeathRay") {
    fir[0] = false;
    fir[1] = false;
    if (p.pwr >= 100) {
     if (Math.random() > .6) {
      snow = 1;
     } else {
      snow = 2;
     }
    }
    if (atak) {
     if (snow == 1) {
      fir[0] = true;
     }
     if (snow == 2) {
      fir[1] = true;
     }
    }
    if (p.pwr < 5) {
     snow = 0;
    }
   }
   if (g.cNm[p.cN] == "YottaVolt Particle Disintegrator") {
    if (snow > 0) {
     snow -= g.zz;
     if (!ap[vic].dest) {
      fir[0] = true;
     }
    } else {
     fir[0] = false;
     if (p.pwr > Math.random() * 10000 || p.pwr >= 100 || M.AId < 2) {
      snow = p.pwr;
     }
    }
   }
   if (fir[0] && M.AId > 1 && p.pwrs[p.cN] > -1 && Math.abs(a.y - g.opy[vic]) > 1000 && p.styp[p.cN] != 2 && p.fas != 2) {
    fir[0] = false;
   }
   if (fir[0] && (g.cNm[p.cN] == "TRAIN of TERROR" || g.cNm[p.cN] == "Gun Turret") && p.pwr < Math.random() * 1000) {
    fir[0] = false;
   }
   if (fir[0] && g.cNm[p.cN] == "TRAIN of TERROR" && M.AId > 1 && g.opy[vic] <= a.y - 1000 && g.x_z(a.x * .01, g.opx[vic] * .01, a.z * .01, g.opz[vic] * .01) < 10000) {
    fir[0] = false;
   }
   if (fir[1] && ((g.cNm[p.cN] == "TRAIN of TERROR" && (g.opy[vic] > a.y - 1000 || M.AId < 2)) || g.cNm[p.cN] == "Gun Turret") && p.pwr < Math.random() * 1000) {
    fir[1] = false;
   }
   if (watn && g.x_z(a.x * .01, g.cx[wpnt] * .01, a.z * .01, g.cz[wpnt] * .01) > 200) {
    fir[0] = false;
   }
   if (fixn && g.cNm[p.cN] != "Lightning Rod") {
    if (fir[0]) {
     fir[0] = false;
    }
    if (fir[1] && p.s2typ[p.cN] != 2) {
     fir[1] = false;
    }
   }
   if (fir[0] || fir[1]) {
    if (p.styp[p.cN] >= 0 && p.styp[p.cN] != 3) {
     aim = (Math.random() * 5) - 1;
    }
    if (g.cNm[p.cN] == "The Destroyer") {
     aim = (Math.random() * 3) - 1;
    }
    if (g.cNm[p.cN] == "A-1") {
     aim = (Math.random() * 2) - 1;
    }
   }
   if (g.cNm[p.cN] == "OW SLAMINARO") {
    aim = ap[vic].spd / 150;
   }
   if (g.stg == 35 && (g.cNm[p.cN] == "KILL-O-MATIC" || g.cNm[p.cN] == "TRAIN of TERROR")) {
    aim = (Math.random() * 3) - 1;
   }
   if (g.C[vic] == 36 || g.C[vic] == 38) {
    aim *= .5;
   }
   if (p.typ[p.cN] == 2) {
    aim = (ap[vic].spd / 150.) - (2 * Math.random());
   }
   if ((aim != 0 && ap[vic].typ[ap[vic].cN] == 2) || aim < 0) {
    aim = 0;
   }
   if (firn && (!atak || fixn || (p.styp[p.cN] < 0 && p.s2typ[p.cN] < 0))) {
    firn = false;
   }
   if (M.AId > 1 && !M.imrtl) {
    if (g.cNm[p.cN] == "The Phantom") {
     for (b = 0; b < g.nC; b++) {
      if (b != p.im) {
       for (c = 0; c < 192; c++) {
        if (g.x_y_z(ap[b].gx[c] * .01, a.x * .01, ap[b].gy[c] * .01, a.y * .01, ap[b].gz[c] * .01, a.z * .01) < 1000) {
         fir[0] = true;
        }
        if (g.x_y_z(ap[b].g2x[c] * .01, a.x * .01, ap[b].g2y[c] * .01, a.y * .01, ap[b].g2z[c] * .01, a.z * .01) < 1000) {
         fir[0] = true;
        }
       }
       for (c = 0; c < 12; c++) {
        if (g.x_y_z(ap[b].ex[c] * .01, a.x * .01, ap[b].ey[c] * .01, a.y * .01, ap[b].ez[c] * .01, a.z * .01) < 1000) {
         fir[0] = true;
        }
       }
      }
     }
    }
    for (b = 0; b < g.nC; b++) {
     double jp = juk[g.C[b]];
     if (ap[b].DD[g.C[b]] < 3.75) {
      jp *= ap[b].pwr * .01;
     }
     if (b != p.im && !ap[b].dest && g.x_y_z(a.x * .01, g.opx[b] * .01, a.z * .01, g.opz[b] * .01, a.y * .01, g.opy[b] * .01) < jp && (!atak || g.cNm[g.C[b]] == "KILL-O-MATIC" || g.cNm[p.cN] == "Turbo Prop" || g.cNm[p.cN] == "F-22 Raptor") && g.cNm[p.cN] != "Tactical Nuke" && p.typ[p.cN] != 2 && ((g.cNm[p.cN] != "OW SLAMINARO" && g.cNm[p.cN] != "Lightning Rod" && g.cNm[p.cN] != "EPIC TANK" && g.cNm[p.cN] != "KILL-O-MATIC" && g.cNm[p.cN] != "The Destroyer" && g.cNm[p.cN] != "Everlast-177" && g.cNm[p.cN] != "TRAIN of TERROR") || g.cNm[g.C[b]] == "KILL-O-MATIC") && ((g.stg != 29 && g.stg != 30 && g.stg != 31 && g.stg != 35 && g.stg != 39 && g.stg != 49 && g.stg != 51 && g.stg != 63 && g.stg != 64 && g.cNm[p.cN] != "M A S H E E N") || p.DD[g.C[b]] > 3.75) && g.stg != 67) {
      if (p.fas < 2) {
       up = true;
       down = false;
       if (p.fas > -1) {
        spac = false;
       }
      }
      long c1 = 0;
      if (g.opx[b] - a.x >= 0) {
       c1 = 180;
      }
      double u;
      for (u = (90 + c1) + Math.atan((g.opz[b] - a.z) / (g.opx[b] - a.x)) * 57.295779513082320876798154814105; u < 0; u += 360) {
      }
      for (; u > 180; u -= 360) {
      }
      double j = Math.abs(a.xz - u);
      if (j > 180) {
       j = Math.abs(j - 360);
      }
      if (j < 90) {
       if (g.cNm[p.cN] == "The Phantom" && p.pwr >= g.zz) {
        fir[0] = true;
       } else {
        if (g.cNm[p.cN] != "Lightning Rod" && g.cNm[p.cN] != "EPIC TANK" && g.cNm[p.cN] != "EL KING-OF-WAR" && g.cNm[p.cN] != "TRAIN of TERROR" && p.typ[p.cN] != 2) {
         fir[0] = false;
         fir[1] = false;
        }
        if (p.fas != 2 || Math.abs(a.xy) < 90) {
         if (Math.abs(p.nvz) > Math.abs(p.nvx)) {
          if (a.x < g.opx[b] && p.nvz > 0) {
           riht = false;
           left = true;
          }
          if (a.x > g.opx[b] && p.nvz > 0) {
           left = false;
           riht = true;
          }
          if (a.x < g.opx[b] && p.nvz < 0) {
           left = false;
           riht = true;
          }
          if (a.x > g.opx[b] && p.nvz < 0) {
           riht = false;
           left = true;
          }
         }
         if (Math.abs(p.nvx) > Math.abs(p.nvz)) {
          if (a.z < g.opz[b] && p.nvx > 0) {
           left = false;
           riht = true;
          }
          if (a.z > g.opz[b] && p.nvx > 0) {
           riht = false;
           left = true;
          }
          if (a.z < g.opz[b] && p.nvx < 0) {
           riht = false;
           left = true;
          }
          if (a.z > g.opz[b] && p.nvx < 0) {
           left = false;
           riht = true;
          }
         }
        }
        if (p.fas == 2 && Math.abs(a.zy) < 90 && Math.abs(a.xy) < 90) {
         if (a.y > g.opy[b]) {
          down = false;
          up = true;
         }
         if (a.y < g.opy[b]) {
          up = false;
          down = true;
         }
        }
       }
      }
     }
    }
   }
  }
 }

 void reset(Game g) {
  pan = 0;
  vpan = 0;
  atak = false;
  vic = (int) (Math.random() * g.nC);
  snow = 0;
  fixn = false;
  racn = 0;
  revn = false;
  pnt = 0;
  if (Math.random() < .5) {
   aRot[0] = 1;
  } else {
   aRot[0] = -1;
  }
  if (Math.random() < .5) {
   aRot[1] = 1;
  } else {
   aRot[1] = -1;
  }
  RBOP = false;
  int c;
  for (c = 0; c < 4; c++) {
   wal[c] = false;
  }
  watn = false;
  aim = 0;
  wait = Math.random() * 5000;
  firn = false;
  fixD = true;
  for (c = 0; c < g.nS; c++) {
   if (g.typ[c] == -4) {
    fpth = c;
    fpnt = c;
    fixD = false;
   }
  }
  wpnt = (int) (Math.random() * g.nCk);
  loka = 0;
 }

 void fals() {
  up = false;
  down = false;
  left = false;
  riht = false;
  spac = false;
  fir[0] = false;
  fir[1] = false;
  bost = false;
  loka = 0;
  entr = false;
 }
}
