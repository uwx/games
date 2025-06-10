import java.awt.Graphics;

public class Craft
{

    cControl u;
    int rspeed;
    float speed;
    int rlift;
    double lift;
    boolean pexp;
    int ltyp;
    int lx[];
    int ly[];
    int lz[];
    int lxz[];
    int lzy[];
    int lxy[];
    int lstage[];
    int lspeed[];
    int lhit[];
    int nf[];
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
    int gxz;
    int gzy;
    boolean responce;
    int trgxz;
    int trgzy;
    int out;
    int turnat;
    int tcnt;
    boolean engage;
    int enx;
    int eny;
    int enz;
    int ens;
    boolean targeting;
    int mode;
    int m3o;
    int m3cnt;
    int m1cnt;
    int relax;
    int runn;
    int liftup;
    boolean dracs;

    public void preform(ContO conto, ContO aconto[], int ai[], int i, int j, int k)
    {
        int l;
        for(l = Math.abs(conto.zy); l > 360; l -= 360) { }
        byte byte0 = 1;
        if(l > 90 && l < 270)
        {
            byte0 = -1;
        }
        if(conto.y < 207)
        {
            if(u.up)
            {
                conto.zy -= (int)(5F * conto.m.cs.getcos(conto.xy));
                conto.xz += (int)((float)(byte0 * 3) * conto.m.cs.getsin(conto.xy));
            }
            if(u.down)
            {
                conto.zy += (int)(5F * conto.m.cs.getcos(conto.xy));
                conto.xz -= (int)((float)(byte0 * 3) * conto.m.cs.getsin(conto.xy));
            }
        } else
        {
            int i1;
            for(i1 = Math.abs(conto.zy); i1 > 90; i1 -= 180) { }
            int k1;
            for(k1 = Math.abs(conto.xy); k1 > 90; k1 -= 180) { }
            int i2;
            for(i2 = Math.abs(conto.zy); i2 > 270; i2 -= 360) { }
            int k2;
            for(k2 = Math.abs(conto.xy); k2 > 270; k2 -= 360) { }
            boolean flag = Math.abs(i2) < 90 && Math.abs(k2) < 90 || Math.abs(i2) > 90 && Math.abs(k2) > 90;
            boolean flag1 = Math.abs(i1) > 30 || Math.abs(k1) > 30;
            if((!flag || flag1) && !conto.exp)
            {
                conto.exp = true;
                conto.y = 170;
                speed = 30F;
                pexp = true;
            }
            int i5;
            for(i5 = Math.abs(conto.zy); i5 > 270; i5 -= 360) { }
            if(i5 > 90)
            {
                conto.xy = 180;
            } else
            {
                conto.xy = 0;
            }
            int i6;
            for(i6 = conto.zy; i6 > 90; i6 -= 180) { }
            for(; i6 < -90; i6 += 180) { }
            if(i6 > 0)
            {
                conto.zy--;
                smoke = true;
            }
            if(i6 < 0)
            {
                conto.zy++;
                smoke = true;
            }
            if(speed > 10F && u.down)
            {
                conto.zy += (int)(5F * conto.m.cs.getcos(conto.xy));
            }
        }
        if(u.left)
        {
            if(conto.y < 207)
            {
                if(conto.xy > -90)
                {
                    conto.xy -= 10;
                }
            } else
            {
                conto.xz += 2;
            }
        }
        if(u.right)
        {
            if(conto.y < 207)
            {
                if(conto.xy < 90)
                {
                    conto.xy += 10;
                }
            } else
            {
                conto.xz -= 2;
            }
        }
        int j1 = (int)((float)(byte0 * 4) * conto.m.cs.getsin(conto.xy));
        conto.xz -= j1;
        if(conto.nhits > conto.maxhits - conto.maxhits / 6 && !conto.exp)
        {
            if(rspeed > 60)
            {
                rspeed = 60;
                speed = 60F;
            }
            conto.xz += (int)(Math.random() * (double)(speed / 10F) - (double)(speed / 20F));
            conto.zy += (int)(Math.random() * (double)(speed / 10F) - (double)(speed / 20F));
        }
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
        int l1 = (int)(5F * (conto.m.cs.getcos(conto.zy) * conto.m.cs.getcos(conto.xy)));
        if(lift > (double)l1)
        {
            lift = l1;
        }
        conto.y -= (int)lift;
        if(conto.x < -40000)
        {
            conto.x = -40000;
            if(j1 <= 0)
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
            if(j1 <= 0)
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
            if(j1 <= 0)
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
            if(j1 <= 0)
            {
                conto.xz += 5;
            } else
            {
                conto.xz -= 5;
            }
        }
        if(!pexp && conto.exp)
        {
            if(speed > 30F)
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
                speed -= 0.5D;
            }
            if(speed < (float)rspeed)
            {
                speed++;
            }
        }
        if(u.fire && !conto.exp)
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
                nf[nl] = 0;
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
        int j2 = 0;
        int l2 = 0;
        do
        {
            if(lstage[l2] != 0)
            {
                j2++;
                if(ly[l2] > 240 && lhit[l2] == 0)
                {
                    lhit[l2] = 1;
                }
                if(lhit[l2] == 0)
                {
                    if(lstage[l2] > 10 && nf[l2] < 15)
                    {
                        int i3 = -1;
                        int k3 = -1;
                        if(!aconto[j].exp)
                        {
                            i3 = getpy(aconto[j].x, aconto[j].y, aconto[j].z, l2);
                            k3 = j;
                        }
                        for(int j5 = k; j5 < k + 13; j5++)
                        {
                            int j6 = getpy(aconto[j5].x, aconto[j5].y, aconto[j5].z, l2);
                            if(j6 < i3 && j6 > 0 && !aconto[j5].exp)
                            {
                                i3 = j6;
                                k3 = j5;
                            }
                        }

                        if(i3 < 22500 && i3 > 0)
                        {
                            if(lspeed[l2] > 230)
                            {
                                lspeed[l2] = 230;
                            }
                            int k5 = aconto[k3].x;
                            int k6 = aconto[k3].z;
                            int i7 = aconto[k3].y;
                            char c4 = '\0';
                            if(k5 - lx[l2] > 0)
                            {
                                c4 = '\264';
                            }
                            lxz[l2] = (int)((double)(90 + c4) + Math.atan((double)(k6 - lz[l2]) / (double)(k5 - lx[l2])) / 0.017453292519943295D);
                            c4 = '\0';
                            if(i7 - ly[l2] < 0)
                            {
                                c4 = '\uFF4C';
                            }
                            int k7 = (int)Math.sqrt((k6 - lz[l2]) * (k6 - lz[l2]) + (k5 - lx[l2]) * (k5 - lx[l2]));
                            lzy[l2] = -(int)((double)(90 + c4) - Math.atan((double)k7 / (double)(i7 - ly[l2])) / 0.017453292519943295D);
                            nf[l2]++;
                        }
                    }
                    lx[l2] -= (int)((float)lspeed[l2] * (conto.m.cs.getsin(lxz[l2]) * conto.m.cs.getcos(lzy[l2])));
                    lz[l2] += (int)((float)lspeed[l2] * (conto.m.cs.getcos(lxz[l2]) * conto.m.cs.getcos(lzy[l2])));
                    ly[l2] -= (int)((float)lspeed[l2] * conto.m.cs.getsin(lzy[l2]));
                    lstage[l2]++;
                    if(lstage[l2] > 80)
                    {
                        lstage[l2] = 0;
                    }
                }
            }
        } while(++l2 < 20);
        if(j2 != 0)
        {
            if(!conto.fire)
            {
                conto.fire = true;
            }
        } else
        if(conto.fire)
        {
            conto.fire = false;
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
        if(tcnt > turnat)
        {
            if(targeting)
            {
                targeting = false;
            }
            if(mode != 1 && mode != 3)
            {
                if(engage)
                {
                    char c = '\0';
                    if(aconto[k + ens].x - conto.x > 0)
                    {
                        c = '\264';
                    }
                    gxz = (int)((double)(90 + c) + Math.atan((double)(aconto[k + ens].z - conto.z) / (double)(aconto[k + ens].x - conto.x)) / 0.017453292519943295D);
                    c = '\0';
                    if(aconto[k + ens].y - conto.y < 0)
                    {
                        c = '\uFF4C';
                    }
                    int l3 = (int)Math.sqrt((aconto[k + ens].z - conto.z) * (aconto[k + ens].z - conto.z) + (aconto[k + ens].x - conto.x) * (aconto[k + ens].x - conto.x));
                    gzy = -(int)((double)(90 + c) - Math.atan((double)l3 / (double)(aconto[k + ens].y - conto.y)) / 0.017453292519943295D);
                    l2 = getcpy(conto, aconto[k + ens]);
                    if(l2 > 0 && l2 < 15000)
                    {
                        targeting = true;
                    }
                    if(l2 > 0 && l2 < 200 && Math.random() > 0.69999999999999996D)
                    {
                        if(Math.random() > 0.5D)
                        {
                            enx = -6800 + (int)(2000D + 30000D * Math.random());
                        } else
                        {
                            enx = -6800 - (int)(2000D + 30000D * Math.random());
                        }
                        if(Math.random() > 0.5D)
                        {
                            enz = -1150 + (int)(2000D + 30000D * Math.random());
                        } else
                        {
                            enz = -1150 - (int)(2000D + 30000D * Math.random());
                        }
                        if(Math.random() > 0.69999999999999996D)
                        {
                            eny = 0;
                        } else
                        {
                            eny = -(int)(Math.random() * 23000D);
                        }
                        engage = false;
                        targeting = false;
                    }
                } else
                {
                    char c1 = '\0';
                    if(enx - conto.x > 0)
                    {
                        c1 = '\264';
                    }
                    gxz = (int)((double)(90 + c1) + Math.atan((double)(enz - conto.z) / (double)(enx - conto.x)) / 0.017453292519943295D);
                    c1 = '\0';
                    if(eny - conto.y < 0)
                    {
                        c1 = '\uFF4C';
                    }
                    int i4 = (int)Math.sqrt((enz - conto.z) * (enz - conto.z) + (enx - conto.x) * (enx - conto.x));
                    gzy = -(int)((double)(90 + c1) - Math.atan((double)i4 / (double)(eny - conto.y)) / 0.017453292519943295D);
                    l2 = getepy(conto);
                    if(l2 > 0 && l2 < 500)
                    {
                        ens = 4 + (int)(Math.random() * 5D);
                        engage = true;
                    }
                }
                turnat = (int)(Math.random() * 50D);
            }
            l2 = getcpy(aconto[j], conto);
            if(l2 > 0)
            {
                if(l2 < 20000 && !aconto[j].exp)
                {
                    if(mode == 0 && mode != 3)
                    {
                        if(Math.random() > 0.5D && conto.maxR != 151)
                        {
                            mode = 2;
                        } else
                        {
                            mode = 1;
                            m1cnt = 0;
                        }
                    }
                } else
                if(mode != 0)
                {
                    mode = 0;
                }
            }
            if(mode == 1)
            {
                char c2 = '\0';
                if(aconto[j].x - conto.x > 0)
                {
                    c2 = '\264';
                }
                gxz = (int)((double)(90 + c2) + Math.atan((double)(aconto[j].z - conto.z) / (double)(aconto[j].x - conto.x)) / 0.017453292519943295D);
                c2 = '\0';
                if(aconto[j].y - conto.y < 0)
                {
                    c2 = '\uFF4C';
                }
                int j4 = (int)Math.sqrt((aconto[j].z - conto.z) * (aconto[j].z - conto.z) + (aconto[j].x - conto.x) * (aconto[j].x - conto.x));
                gzy = -(int)((double)(90 + c2) - Math.atan((double)j4 / (double)(aconto[j].y - conto.y)) / 0.017453292519943295D);
                turnat = (int)(Math.random() * 3D);
                if(l2 < 7000)
                {
                    targeting = true;
                }
                m1cnt++;
                if(m1cnt > relax)
                {
                    mode = 0;
                }
            }
            if(mode == 3)
            {
                char c3 = '\0';
                if(aconto[m3o].x - conto.x > 0)
                {
                    c3 = '\264';
                }
                gxz = (int)((double)(90 + c3) + Math.atan((double)(aconto[m3o].z - conto.z) / (double)(aconto[m3o].x - conto.x)) / 0.017453292519943295D);
                c3 = '\0';
                if(aconto[m3o].y - conto.y < 0)
                {
                    c3 = '\uFF4C';
                }
                int k4 = (int)Math.sqrt((aconto[m3o].z - conto.z) * (aconto[m3o].z - conto.z) + (aconto[m3o].x - conto.x) * (aconto[m3o].x - conto.x));
                gzy = -(int)((double)(90 + c3) - Math.atan((double)k4 / (double)(aconto[m3o].y - conto.y)) / 0.017453292519943295D);
                turnat = (int)(Math.random() * 10D);
                m3cnt++;
                if(m3cnt == runn)
                {
                    mode = 0;
                }
            }
            tcnt = 0;
        } else
        {
            tcnt++;
        }
        if(mode != 3 && conto.hit && Math.random() > 0.84999999999999998D)
        {
            if(Math.random() > 0.5D)
            {
                m3o = nearst(aconto, ai, i, j, conto);
                mode = 3;
                m3cnt = 0;
            } else
            if(mode == 2)
            {
                if(conto.zy < 15 && Math.random() < 0.5D && conto.maxR != 151)
                {
                    turnat = 20;
                    gzy = 80;
                    mode = 0;
                } else
                {
                    mode = 1;
                    m1cnt = 0;
                }
            } else
            if(conto.zy < 15 && Math.random() < 0.5D)
            {
                turnat = 20;
                gzy = 80;
                mode = 0;
            } else
            {
                mode = 2;
            }
        }
        l2 = 0;
        if((float)conto.y > 100F + (float)liftup * conto.m.cs.getsin(conto.zy))
        {
            l2 = 1;
        }
        int j3 = conto.y + (int)((float)(-((conto.z + 1000) - conto.z)) * conto.m.cs.getsin(conto.zy));
        int l4 = conto.z + (int)((float)((conto.z + 1000) - conto.z) * conto.m.cs.getcos(conto.zy));
        int l5 = conto.x + (int)((float)(-(l4 - conto.z)) * conto.m.cs.getsin(conto.xz));
        int l6 = conto.z + (int)((float)(l4 - conto.z) * conto.m.cs.getcos(conto.xz));
        if(myway(aconto, ai, i, j, l5, j3, l6))
        {
            l2 = 2;
        }
        if(u.left)
        {
            u.left = false;
        }
        if(u.right)
        {
            u.right = false;
        }
        if(u.up)
        {
            u.up = false;
        }
        if(u.down)
        {
            u.down = false;
        }
        if(l2 != 2)
        {
            int j7;
            for(j7 = conto.xz; j7 >= 360; j7 -= 360) { }
            for(; j7 < 0; j7 += 360) { }
            if(Math.abs(j7 - gxz) > 5 && l2 == 0)
            {
                if(j7 > 270 && gxz < 90)
                {
                    u.left = true;
                    trgxz = (360 - j7) + gxz;
                } else
                if(j7 < 90 && gxz > 270)
                {
                    u.right = true;
                    trgxz = (360 - gxz) + j7;
                } else
                if(j7 < gxz)
                {
                    u.left = true;
                    trgxz = gxz - j7;
                } else
                {
                    u.right = true;
                    trgxz = j7 - gxz;
                }
                if(dracs && Math.abs(conto.xy) > 80)
                {
                    u.down = true;
                }
            } else
            {
                if(conto.xy > 0)
                {
                    u.left = true;
                }
                if(conto.xy < 0)
                {
                    u.right = true;
                }
                if(l2 == 1 && Math.abs(conto.xy) < 30 && conto.zy < -30)
                {
                    gzy = 20;
                }
            }
            if(Math.abs(conto.zy - gzy) > 5 && Math.abs(conto.xy) < 45)
            {
                if(gzy < conto.zy)
                {
                    u.up = true;
                }
                if(gzy > conto.zy)
                {
                    u.down = true;
                }
                trgzy = Math.abs(conto.zy - gzy);
            }
        } else
        if(Math.abs(conto.xy) < 60 || conto.zy < 10)
        {
            if(conto.xy > 0)
            {
                u.left = true;
            }
            if(conto.xy < 0)
            {
                u.right = true;
            }
            if(conto.zy < 80)
            {
                u.down = true;
                gzy = 80;
            }
            tcnt = 0;
            turnat = (int)(Math.random() * 6D + 4D);
        } else
        {
            if(conto.xy > 0)
            {
                u.right = true;
            }
            if(conto.xy < 0)
            {
                u.left = true;
            }
            if(conto.zy < 80)
            {
                u.down = true;
            }
            tcnt = 0;
            turnat = (int)(Math.random() * 4D + 3D);
        }
        if(trgxz < 90 && trgzy < 40 && targeting)
        {
            if(!u.fire)
            {
                u.fire = true;
            }
        } else
        if(u.fire)
        {
            u.fire = false;
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
            if(conto.y > 200)
            {
                if(smoke && sms[ns] == -1)
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
    }

    public int nearst(ContO aconto[], int ai[], int i, int j, ContO conto)
    {
        int k = getcpy(aconto[ai[0]], conto);
        int l = ai[0];
        for(int i1 = 0; i1 < i; i1++)
        {
            if(ai[i1] != j)
            {
                int j1 = getcpy(aconto[ai[i1]], conto);
                if(j1 > 0 && j1 < k && !aconto[ai[i1]].exp || k < 0)
                {
                    k = j1;
                    l = ai[i1];
                }
            }
        }

        return l;
    }

    public void reset(int i, int j, int k, int l, int i1, int j1)
    {
        rspeed = i;
        speed = i;
        rlift = 0;
        lift = 0.0D;
        pexp = false;
        ltyp = j;
        mode = 0;
        relax = k;
        runn = l;
        liftup = i1;
        if(j1 == 1)
        {
            dracs = true;
        } else
        {
            dracs = false;
        }
        int k1 = 0;
        do
        {
            lstage[k1] = 0;
        } while(++k1 < 20);
    }

    public Craft(Medium medium)
    {
        u = new cControl();
        rspeed = 0;
        speed = 0.0F;
        rlift = 0;
        lift = 0.0D;
        pexp = false;
        ltyp = 3;
        lx = new int[20];
        ly = new int[20];
        lz = new int[20];
        lxz = new int[20];
        lzy = new int[20];
        lxy = new int[20];
        lstage = new int[20];
        lspeed = new int[20];
        lhit = new int[20];
        nf = new int[20];
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
        gxz = 0;
        gzy = 0;
        responce = false;
        trgxz = 0;
        trgzy = 0;
        out = 0;
        turnat = (int)(Math.random() * 50D);
        tcnt = 0;
        engage = true;
        enx = 0;
        eny = 0;
        enz = 0;
        ens = 4;
        targeting = false;
        mode = 0;
        m3o = 0;
        m3cnt = 0;
        m1cnt = 0;
        relax = 50;
        runn = 30;
        liftup = 500;
        dracs = false;
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
                                conto.nhits += lsr.damg[ltyp];
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
                                            conto.nhits += lsr.damg[ltyp];
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

    public int getcpy(ContO conto, ContO conto1)
    {
        return ((conto.x - conto1.x) / 100) * ((conto.x - conto1.x) / 100) + ((conto.y - conto1.y) / 100) * ((conto.y - conto1.y) / 100) + ((conto.z - conto1.z) / 100) * ((conto.z - conto1.z) / 100);
    }

    public boolean myway(ContO aconto[], int ai[], int i, int j, int k, int l, int i1)
    {
        boolean flag = false;
        for(int k1 = 0; k1 < i; k1++)
        {
            if(ai[k1] != j)
            {
                int l1 = (aconto[ai[k1]].maxR / 20) * (aconto[ai[k1]].maxR / 20);
                if(l1 < 5000)
                {
                    l1 = 5000;
                }
                int j1 = ((aconto[ai[k1]].x - k) / 10) * ((aconto[ai[k1]].x - k) / 10) + ((aconto[ai[k1]].y - l) / 10) * ((aconto[ai[k1]].y - l) / 10) + ((aconto[ai[k1]].z - i1) / 10) * ((aconto[ai[k1]].z - i1) / 10);
                if(j1 > 0 && j1 < l1 && !aconto[ai[k1]].exp && aconto[ai[k1]].maxR > 75)
                {
                    return true;
                }
            }
        }

        return false;
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

    public int getepy(ContO conto)
    {
        return ((conto.x - enx) / 100) * ((conto.x - enx) / 100) + ((conto.y - eny) / 100) * ((conto.y - eny) / 100) + ((conto.z - enz) / 100) * ((conto.z - enz) / 100);
    }
}
