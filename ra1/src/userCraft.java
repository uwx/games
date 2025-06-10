import java.awt.Graphics;

public class userCraft
{

    int rspeed;
    float speed;
    int rlift;
    double lift;
    boolean pexp;
    int ltyp;
    int maxspeed[] = {
        120, 100, 90, 80, 76
    };
    int elev[] = {
        1, 2, 1, 1, 1
    };
    int trnn[] = {
        0, 0, 1, 2, 1
    };
    int dnjm[] = {
        7, 5, 4, 3, 4
    };
    String name[] = {
        "E-7 Sky Bullet", "BP-6 Hammer Head", "E-9 Dragon Bird", "EXA-1 Destroyer", "Silver F-51 Legend"
    };
    int njumps;
    int ester;
    int lx[];
    int ly[];
    int lz[];
    int lxz[];
    int lzy[];
    int lxy[];
    int lstage[];
    int lspeed[];
    int lhit[];
    int nl;
    Lasers lsr;
    boolean skip;
    int bulkc;
    int sms[];
    int sx[];
    int sy[];
    int sz[];
    int sxz[];
    int szy[];
    int ns;
    boolean smoke;
    int dms[];
    int dx[];
    int dy[];
    int dz[];
    int dxz[];
    int dzy[];
    int nd;

    public void preform(Control control, ContO conto, ContO aconto[], int ai[], int i)
    {
        int j;
        for(j = Math.abs(conto.zy); j > 360; j -= 360) { }
        byte byte0 = 1;
        if(j > 90 && j < 270)
        {
            byte0 = -1;
        }
        if(conto.y < 207)
        {
            if(control.up)
            {
                conto.zy -= (int)((float)(4 + elev[ltyp]) * conto.m.cs.getcos(conto.xy));
                conto.xz += (int)((float)(byte0 * (2 + elev[ltyp])) * conto.m.cs.getsin(conto.xy));
            }
            if(control.down)
            {
                conto.zy += (int)((float)(4 + elev[ltyp]) * conto.m.cs.getcos(conto.xy));
                conto.xz -= (int)((float)(byte0 * (2 + elev[ltyp])) * conto.m.cs.getsin(conto.xy));
            }
        } else
        {
            int k;
            for(k = Math.abs(conto.zy); k > 90; k -= 180) { }
            int i1;
            for(i1 = Math.abs(conto.xy); i1 > 90; i1 -= 180) { }
            int k1;
            for(k1 = Math.abs(conto.zy); k1 > 270; k1 -= 360) { }
            int i2;
            for(i2 = Math.abs(conto.xy); i2 > 270; i2 -= 360) { }
            boolean flag = Math.abs(k1) < 90 && Math.abs(i2) < 90 || Math.abs(k1) > 90 && Math.abs(i2) > 90;
            boolean flag1 = Math.abs(k) > 30 || Math.abs(i1) > 30;
            if((!flag || flag1) && !conto.exp)
            {
                conto.exp = true;
                conto.y = 170;
                speed = 30F;
                pexp = true;
            }
            int i3;
            for(i3 = Math.abs(conto.zy); i3 > 270; i3 -= 360) { }
            if(i3 > 90)
            {
                conto.xy = 180;
            } else
            {
                conto.xy = 0;
            }
            int l3;
            for(l3 = conto.zy; l3 > 90; l3 -= 180) { }
            for(; l3 < -90; l3 += 180) { }
            if(l3 > 0)
            {
                conto.zy--;
                smoke = true;
            }
            if(l3 < 0)
            {
                conto.zy++;
                smoke = true;
            }
            if(speed > 10F && control.down)
            {
                conto.zy += (int)(5F * conto.m.cs.getcos(conto.xy));
            }
        }
        if(control.left)
        {
            if(conto.y < 207)
            {
                conto.xy -= 10;
            } else
            {
                conto.xz += 2;
            }
        }
        if(control.right)
        {
            if(conto.y < 207)
            {
                conto.xy += 10;
            } else
            {
                conto.xz -= 2;
            }
        }
        int l = (int)((float)(byte0 * (3 + trnn[ltyp])) * conto.m.cs.getsin(conto.xy));
        conto.xz -= l;
        rlift = (int)(speed * (conto.m.cs.getcos(conto.zy) * conto.m.cs.getcos(conto.xy))) - 40;
        if(lift < (double)rlift)
        {
            lift += 0.5D;
        }
        if(lift > (double)rlift)
        {
            lift -= 0.5D;
        }
        if(lift < (double)(-(50F - speed / 2.0F)))
        {
            lift = -(50F - speed / 2.0F);
        }
        int j1 = (int)(5F * (conto.m.cs.getcos(conto.zy) * conto.m.cs.getcos(conto.xy)));
        if(lift > (double)j1)
        {
            lift = j1;
        }
        conto.y -= (int)lift;
        if(conto.x < -40000)
        {
            conto.x = -40000;
            if(l <= 0)
            {
                conto.xz += 5;
            } else
            {
                conto.xz -= 5;
            }
        }
        if(conto.x > 40000)
        {
            conto.x = 40000;
            if(l <= 0)
            {
                conto.xz += 5;
            } else
            {
                conto.xz -= 5;
            }
        }
        if(conto.z > 40000)
        {
            conto.z = 40000;
            if(l <= 0)
            {
                conto.xz += 5;
            } else
            {
                conto.xz -= 5;
            }
        }
        if(conto.z < -40000)
        {
            conto.z = -40000;
            if(l <= 0)
            {
                conto.xz += 5;
            } else
            {
                conto.xz -= 5;
            }
        }
        if(!pexp && conto.exp)
        {
            if(speed > 40F)
            {
                speed = -15F;
                pexp = true;
            } else
            if(conto.nhits > conto.maxhits)
            {
                pexp = true;
            } else
            {
                conto.exp = false;
                speed = -(((float)rspeed + speed) / 2.0F);
            }
        }
        if(pexp)
        {
            if(speed > 0.0F)
            {
                speed -= 0.29999999999999999D;
            }
            if(speed < 0.0F)
            {
                speed += 0.29999999999999999D;
            }
        } else
        {
            if(speed > (float)rspeed)
            {
                if(speed > (float)maxspeed[ltyp])
                {
                    speed -= (speed - (float)rspeed) / 20F;
                } else
                {
                    speed -= 0.5D;
                }
            }
            if(speed < (float)rspeed)
            {
                speed++;
            }
        }
        if(conto.nhits > conto.maxhits - conto.maxhits / 6 && !conto.exp)
        {
            if(speed > 60F)
            {
                speed = 60F;
            }
            conto.xz += (int)(Math.random() * (double)(speed / 10F) - (double)(speed / 20F));
            conto.zy += (int)(Math.random() * (double)(speed / 10F) - (double)(speed / 20F));
        }
        if(control.plus && rspeed < maxspeed[ltyp])
        {
            rspeed += 2;
        }
        if(control.mins && rspeed > 0)
        {
            rspeed -= 2;
        }
        if(control.jump != 0 && njumps != 0)
        {
            if(control.jump == 1)
            {
                speed = 400F;
                control.jump = 2;
                conto.m.jumping = 5;
            }
            if(conto.m.jumping == 0)
            {
                speed = 800F;
                control.jump = 0;
                njumps--;
            }
        }
        if(control.fire && !conto.exp)
        {
            if(skip && bulkc < lsr.srate[ltyp])
            {
                lx[nl] = conto.x;
                ly[nl] = conto.y;
                lz[nl] = conto.z;
                lxz[nl] = conto.xz;
                lzy[nl] = conto.zy;
                lxy[nl] = conto.xy;
                if(ly[nl] > 215)
                {
                    ly[nl] = 215;
                }
                lspeed[nl] = (int)((float)lsr.speed[ltyp] + speed);
                lstage[nl] = 1;
                lhit[nl] = 0;
                nl++;
                if(nl == 20)
                {
                    nl = 0;
                }
                skip = false;
            } else
            if(!skip)
            {
                skip = true;
            }
            bulkc++;
            if(bulkc > 12)
            {
                bulkc = 0;
            }
        }
        int l1 = 0;
        int j2 = 0;
        do
        {
            if(lstage[j2] != 0)
            {
                l1++;
                if(ly[j2] > 240 && lhit[j2] == 0)
                {
                    lhit[j2] = 1;
                }
                if(lhit[j2] == 0)
                {
                    if(lstage[j2] > 10)
                    {
                        int k2 = 22500;
                        int l2 = -1;
                        for(int j3 = 1; j3 < i; j3++)
                        {
                            int i4 = getpy(aconto[ai[j3]].x, aconto[ai[j3]].y, aconto[ai[j3]].z, j2);
                            if(i4 < k2 && i4 > 0 && !aconto[ai[j3]].exp)
                            {
                                k2 = i4;
                                l2 = j3;
                            }
                        }

                        if(l2 != -1)
                        {
                            if(lspeed[j2] > 230)
                            {
                                lspeed[j2] = 230;
                            }
                            int k3 = aconto[ai[l2]].x;
                            int j4 = aconto[ai[l2]].z;
                            int k4 = aconto[ai[l2]].y;
                            char c = '\0';
                            if(k3 - lx[j2] > 0)
                            {
                                c = '\264';
                            }
                            lxz[j2] = (int)((double)(90 + c) + Math.atan((double)(j4 - lz[j2]) / (double)(k3 - lx[j2])) / 0.017453292519943295D);
                            c = '\0';
                            if(k4 - ly[j2] < 0)
                            {
                                c = '\uFF4C';
                            }
                            int l4 = (int)Math.sqrt((j4 - lz[j2]) * (j4 - lz[j2]) + (k3 - lx[j2]) * (k3 - lx[j2]));
                            lzy[j2] = -(int)((double)(90 + c) - Math.atan((double)l4 / (double)(k4 - ly[j2])) / 0.017453292519943295D);
                        }
                    }
                    lx[j2] -= (int)((float)lspeed[j2] * (conto.m.cs.getsin(lxz[j2]) * conto.m.cs.getcos(lzy[j2])));
                    lz[j2] += (int)((float)lspeed[j2] * (conto.m.cs.getcos(lxz[j2]) * conto.m.cs.getcos(lzy[j2])));
                    ly[j2] -= (int)((float)lspeed[j2] * conto.m.cs.getsin(lzy[j2]));
                    lstage[j2]++;
                    if(lstage[j2] > 80)
                    {
                        lstage[j2] = 0;
                    }
                }
            }
        } while(++j2 < 20);
        if(l1 != 0)
        {
            if(!conto.fire)
            {
                conto.fire = true;
            }
        } else
        if(conto.fire)
        {
            conto.fire = false;
            bulkc = 0;
        }
        conto.x -= (int)(speed * (conto.m.cs.getsin(conto.xz) * conto.m.cs.getcos(conto.zy)));
        conto.z += (int)(speed * (conto.m.cs.getcos(conto.xz) * conto.m.cs.getcos(conto.zy)));
        conto.y -= (int)(speed * conto.m.cs.getsin(conto.zy));
        if(conto.y > 215)
        {
            conto.y = 215;
        }
        if(conto.y < -25000)
        {
            conto.y = -25000;
        }
        if(ester == 0)
        {
            if(conto.x > 2800 && conto.x < 3200 && conto.z > -2100 && conto.z < -1900 && conto.y > -30)
            {
                ester = 1;
                conto.nhits = 0;
                control.jump = 0;
                njumps = dnjm[ltyp];
            }
        } else
        {
            if(ester < 13)
            {
                if(ltyp == 0)
                {
                    if(conto.m.er == 0)
                    {
                        conto.m.er = 1;
                    } else
                    {
                        conto.m.er = 0;
                    }
                }
                if(ltyp == 1)
                {
                    if(conto.m.eg == 0)
                    {
                        conto.m.eg = 1;
                    } else
                    {
                        conto.m.eg = 0;
                    }
                }
                if(ltyp == 2)
                {
                    if(conto.m.eb == 0)
                    {
                        conto.m.eb = 1;
                    } else
                    {
                        conto.m.eb = 0;
                    }
                }
                if(ltyp == 3)
                {
                    if(conto.m.er == 0)
                    {
                        conto.m.er = 1;
                        conto.m.eg = 1;
                    } else
                    {
                        conto.m.er = 0;
                        conto.m.eg = 0;
                    }
                }
                if(ltyp == 4)
                {
                    if(conto.m.eb == 0)
                    {
                        conto.m.eb = 1;
                        conto.m.eg = 1;
                    } else
                    {
                        conto.m.eb = 0;
                        conto.m.eg = 0;
                    }
                }
            }
            if(ester == 1)
            {
                conto.wire = true;
            }
            if(ester == 3)
            {
                conto.wire = false;
            }
            ester++;
            if(ester == 45)
            {
                ester = 0;
            }
        }
    }

    public void dosmokes(Graphics g, ContO conto)
    {
        if(!conto.exp)
        {
            if(conto.nhits > conto.maxhits - conto.maxhits / 3)
            {
                if(dms[nd] == -1)
                {
                    dx[nd] = conto.x + (int)(Math.random() * 60D - 30D);
                    dy[nd] = conto.y;
                    dz[nd] = conto.z;
                    dxz[nd] = conto.xz;
                    dzy[nd] = conto.zy;
                    dms[nd] = 0;
                    nd++;
                    if(nd == 4)
                    {
                        nd = 0;
                    }
                }
                int i = 0;
                do
                {
                    if(dms[i] != -1)
                    {
                        if(dms[i] < 4)
                        {
                            lsr.hsmoke(g, dx[i], dy[i], dz[i], dxz[i], dzy[i], dms[i]);
                        }
                        dy[i] -= 15;
                        dms[i]++;
                        if(dms[i] >= 7)
                        {
                            dms[i] = -1;
                        }
                    }
                } while(++i < 4);
            }
            if(smoke && conto.y > 200 && sms[ns] == -1)
            {
                sx[ns] = conto.x + (int)(Math.random() * 80D - 40D);
                sy[ns] = conto.y + 15;
                sz[ns] = conto.z;
                sxz[ns] = conto.xz;
                szy[ns] = conto.zy;
                sms[ns] = 0;
                ns++;
                if(ns == 4)
                {
                    ns = 0;
                }
                smoke = false;
            }
            int j = 0;
            do
            {
                if(sms[j] != -1)
                {
                    if(sms[j] < 4)
                    {
                        lsr.gsmoke(g, sx[j], sy[j], sz[j], sxz[j], szy[j], sms[j]);
                    }
                    sy[j] -= 15;
                    sms[j]++;
                    if(sms[j] == 10)
                    {
                        sms[j] = -1;
                    }
                }
            } while(++j < 4);
        }
    }

    public void reset(int i)
    {
        rspeed = 0;
        speed = 0.0F;
        rlift = 0;
        lift = 0.0D;
        pexp = false;
        ltyp = i;
        njumps = dnjm[i];
        int j = 0;
        do
        {
            lstage[j] = 0;
        } while(++j < 20);
    }

    public userCraft(Medium medium)
    {
        rspeed = 0;
        speed = 0.0F;
        rlift = 0;
        lift = 0.0D;
        pexp = false;
        ltyp = 0;
        njumps = 0;
        ester = 0;
        lx = new int[20];
        ly = new int[20];
        lz = new int[20];
        lxz = new int[20];
        lzy = new int[20];
        lxy = new int[20];
        lstage = new int[20];
        lspeed = new int[20];
        lhit = new int[20];
        nl = 0;
        skip = false;
        bulkc = 0;
        sms = new int[4];
        sx = new int[4];
        sy = new int[4];
        sz = new int[4];
        sxz = new int[4];
        szy = new int[4];
        ns = 0;
        smoke = false;
        dms = new int[4];
        dx = new int[4];
        dy = new int[4];
        dz = new int[4];
        dxz = new int[4];
        dzy = new int[4];
        nd = 0;
        lsr = new Lasers(medium);
        int i = 0;
        do
        {
            sms[i] = -1;
        } while(++i < 4);
        i = 0;
        do
        {
            dms[i] = -1;
        } while(++i < 4);
    }

    public void lasercolid(ContO conto)
    {
        if(!conto.exp && !conto.out)
        {
            int i = 0;
            do
            {
                if(lstage[i] != 0 && lhit[i] == 0)
                {
                    int j = getpy(conto.x, conto.y, conto.z, i);
                    if(j < (conto.maxR / 10) * (conto.maxR / 10) && j > 0)
                    {
                        if(conto.rcol != 0 && j < (conto.maxR / (10 * conto.rcol)) * (conto.maxR / (10 * conto.rcol)) + (lsr.rads[ltyp] / 10) * (lsr.rads[ltyp] / 10))
                        {
                            lhit[i] = 1;
                            if(conto.maxhits != -1)
                            {
                                conto.hit = true;
                                if(Math.random() > 0.5D)
                                {
                                    conto.nhits += lsr.damg[ltyp];
                                } else
                                {
                                    conto.nhits += 2;
                                }
                            }
                        }
                        if(conto.pcol != 0)
                        {
                            for(int k = 0; k < conto.npl; k++)
                            {
                                for(int l = 0; l < conto.p[k].n; l++)
                                {
                                    if(!conto.hit && (lx[i] - (conto.x + conto.p[k].ox[l])) * (lx[i] - (conto.x + conto.p[k].ox[l])) + (ly[i] - (conto.y + conto.p[k].oy[l])) * (ly[i] - (conto.y + conto.p[k].oy[l])) + (lz[i] - (conto.z + conto.p[k].oz[l])) * (lz[i] - (conto.z + conto.p[k].oz[l])) < ((lsr.rads[ltyp] * 10) / conto.pcol) * ((lsr.rads[ltyp] * 10) / conto.pcol))
                                    {
                                        lhit[i] = 1;
                                        if(conto.maxhits != -1)
                                        {
                                            conto.hit = true;
                                            if(Math.random() > 0.5D)
                                            {
                                                conto.nhits += lsr.damg[ltyp];
                                            } else
                                            {
                                                conto.nhits += 2;
                                            }
                                        }
                                    }
                                }

                            }

                        }
                    }
                }
            } while(++i < 20);
        }
    }

    public int getpy(int i, int j, int k, int l)
    {
        return ((i - lx[l]) / 10) * ((i - lx[l]) / 10) + ((j - ly[l]) / 10) * ((j - ly[l]) / 10) + ((k - lz[l]) / 10) * ((k - lz[l]) / 10);
    }

    public void dl(Graphics g)
    {
        int i = 0;
        do
        {
            if(lstage[i] != 0)
            {
                lsr.d(g, ltyp, lx[i], ly[i], lz[i], lxz[i], lzy[i], lxy[i], lhit[i]);
                if(lhit[i] != 0)
                {
                    lhit[i]++;
                    if(lhit[i] > 2)
                    {
                        lstage[i] = 0;
                    }
                }
            }
        } while(++i < 20);
    }
}
