import java.awt.Graphics;

public class Tank
{

    cControl u;
    int rspeed;
    int ltyp;
    float speed;
    boolean pexp;
    boolean left;
    boolean right;
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
    int ns;
    boolean smoke;
    int turnat;
    int tcnt;
    int gxz;
    int attack;
    boolean responce;
    int trgxz;
    int trgt;

    public void preform(ContO conto, ContO aconto[], int i, int j)
    {
        int k;
        for(k = Math.abs(conto.zy); k > 270; k -= 360) { }
        if(k > 90)
        {
            if(conto.xy < 180)
            {
                conto.xy++;
                smoke = true;
            }
            if(conto.xy > 180)
            {
                conto.xy--;
                smoke = true;
            }
        } else
        {
            if(conto.xy < 0)
            {
                conto.xy++;
                smoke = true;
            }
            if(conto.xy > 0)
            {
                conto.xy--;
                smoke = true;
            }
        }
        int l;
        for(l = conto.zy; l > 90; l -= 180) { }
        for(; l < -90; l += 180) { }
        if(l > 0)
        {
            if(l > 4)
            {
                conto.zy -= 2;
            } else
            {
                conto.zy--;
            }
        }
        if(l < 0)
        {
            if(l < -4)
            {
                conto.zy += 2;
            } else
            {
                conto.zy++;
            }
        }
        if(u.left)
        {
            conto.xz += 5;
            if((conto.xy == 0 || conto.xy == 180) && !left)
            {
                conto.xy += speed / 5F;
                left = true;
            }
        } else
        if(left)
        {
            left = false;
        }
        if(u.right)
        {
            conto.xz -= 5;
            if((conto.xy == 0 || conto.xy == 180) && !right)
            {
                conto.xy -= speed / 5F;
                right = true;
            }
        } else
        if(right)
        {
            right = false;
        }
        if(conto.x < -40000)
        {
            conto.x = -40000;
        }
        if(conto.x > 40000)
        {
            conto.x = 40000;
        }
        if(conto.z > 40000)
        {
            conto.z = 40000;
        }
        if(conto.z < -40000)
        {
            conto.z = -40000;
        }
        if(!pexp && conto.exp)
        {
            if(conto.nhits < conto.maxhits)
            {
                conto.exp = false;
                if(u.left)
                {
                    conto.xz += 5;
                } else
                {
                    conto.xz -= 5;
                }
                conto.xy += 15 - (int)(Math.random() * 30D);
                conto.zy += 5 + (int)(Math.random() * 5D);
                conto.y -= 30 + (int)(Math.random() * 15D);
            } else
            {
                pexp = true;
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
                speed -= 0.20000000000000001D;
            }
            if(speed < (float)rspeed)
            {
                speed++;
            }
            if(conto.y > 240)
            {
                conto.y = 240;
            } else
            if(conto.y > 235)
            {
                conto.y++;
            } else
            {
                conto.y += 5;
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
                lzy[nl] = conto.zy + 10;
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
        int i1 = 0;
        int j1 = 0;
        do
        {
            if(lstage[j1] != 0)
            {
                i1++;
                if(ly[j1] > 240 && lhit[j1] == 0)
                {
                    lhit[j1] = 1;
                }
                if(lhit[j1] == 0)
                {
                    if(lstage[j1] > 10 && nf[j1] < 15)
                    {
                        int i2 = -1;
                        int k2 = -1;
                        if(!aconto[i].exp)
                        {
                            i2 = getpy(aconto[i].x, aconto[i].y, aconto[i].z, j1);
                            k2 = i;
                        }
                        for(int l2 = j; l2 < j + 13; l2++)
                        {
                            int j3 = getpy(aconto[l2].x, aconto[l2].y, aconto[l2].z, j1);
                            if(j3 < i2 && j3 > 0 && !aconto[l2].exp)
                            {
                                i2 = j3;
                                k2 = l2;
                            }
                        }

                        if(i2 < 22500 && i2 > 0)
                        {
                            if(lspeed[j1] > 230)
                            {
                                lspeed[j1] = 230;
                            }
                            int i3 = aconto[k2].x;
                            int k3 = aconto[k2].z;
                            int l3 = aconto[k2].y;
                            char c2 = '\0';
                            if(i3 - lx[j1] > 0)
                            {
                                c2 = '\264';
                            }
                            lxz[j1] = (int)((double)(90 + c2) + Math.atan((double)(k3 - lz[j1]) / (double)(i3 - lx[j1])) / 0.017453292519943295D);
                            c2 = '\0';
                            if(l3 - ly[j1] < 0)
                            {
                                c2 = '\uFF4C';
                            }
                            int i4 = (int)Math.sqrt((k3 - lz[j1]) * (k3 - lz[j1]) + (i3 - lx[j1]) * (i3 - lx[j1]));
                            lzy[j1] = -(int)((double)(90 + c2) - Math.atan((double)i4 / (double)(l3 - ly[j1])) / 0.017453292519943295D);
                            nf[j1]++;
                        }
                    }
                    lx[j1] -= (int)((float)lspeed[j1] * (conto.m.cs.getsin(lxz[j1]) * conto.m.cs.getcos(lzy[j1])));
                    lz[j1] += (int)((float)lspeed[j1] * (conto.m.cs.getcos(lxz[j1]) * conto.m.cs.getcos(lzy[j1])));
                    ly[j1] -= (int)((float)lspeed[j1] * conto.m.cs.getsin(lzy[j1]));
                    lstage[j1]++;
                    if(lstage[j1] > 80)
                    {
                        lstage[j1] = 0;
                    }
                }
            }
        } while(++j1 < 20);
        if(i1 != 0)
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
        if(tcnt > turnat)
        {
            if(trgt != 0)
            {
                trgt = 0;
            }
            char c = '\0';
            if(aconto[j + 4].x - conto.x > 0)
            {
                c = '\264';
            }
            gxz = (int)((double)(90 + c) + Math.atan((double)(aconto[j + 4].z - conto.z) / (double)(aconto[j + 4].x - conto.x)) / 0.017453292519943295D);
            turnat = (int)(Math.random() * 200D);
            int k1 = getcpy(aconto[j + 4], conto);
            if(k1 < 1500 && k1 > 0)
            {
                if(Math.random() > 0.5D)
                {
                    gxz += (int)(70D + Math.random() * 20D);
                } else
                {
                    gxz -= (int)(70D + Math.random() * 20D);
                }
            } else
            {
                gxz += (int)(Math.random() * 40D - 20D);
                trgt = 1;
            }
            k1 = getcpy(aconto[i], conto);
            if(k1 < 15000 && k1 > 0 && !aconto[i].exp)
            {
                if(attack == 0)
                {
                    if(Math.random() > 0.5D)
                    {
                        attack = 1;
                    } else
                    {
                        attack = 2;
                    }
                }
                if(attack == 1)
                {
                    char c1 = '\0';
                    if(aconto[i].x - conto.x > 0)
                    {
                        c1 = '\264';
                    }
                    gxz = (int)((double)(90 + c1) + Math.atan((double)(aconto[i].z - conto.z) / (double)(aconto[i].x - conto.x)) / 0.017453292519943295D);
                    turnat = (int)(Math.random() * 3D);
                    trgt = 2;
                }
            } else
            if(attack != 0)
            {
                attack = 0;
            }
            if(gxz >= 360)
            {
                gxz -= 360;
            }
            if(gxz < 0)
            {
                gxz += 360;
            }
            tcnt = 0;
        } else
        {
            tcnt++;
        }
        if(conto.hit && Math.random() > 0.5D)
        {
            attack = 1;
            turnat = (int)(Math.random() * 10D);
        }
        if(u.fire)
        {
            u.fire = false;
        }
        if(trgt == 1 && trgxz < 90)
        {
            int l1 = getcpy(aconto[j + 4], conto);
            if(l1 > 0 && l1 < 10000)
            {
                u.fire = true;
            }
        }
        if(trgt == 2 && trgxz < 90)
        {
            u.fire = true;
        }
        if(responce)
        {
            if(u.left)
            {
                u.left = false;
            }
            if(u.right)
            {
                u.right = false;
            }
            int j2;
            for(j2 = conto.xz; j2 >= 360; j2 -= 360) { }
            for(; j2 < 0; j2 += 360) { }
            if(Math.abs(j2 - gxz) > 5)
            {
                if(j2 > 270 && gxz < 90)
                {
                    u.left = true;
                    trgxz = (360 - j2) + gxz;
                } else
                if(j2 < 90 && gxz > 270)
                {
                    u.right = true;
                    trgxz = (360 - gxz) + j2;
                } else
                if(j2 < gxz)
                {
                    u.left = true;
                    trgxz = gxz - j2;
                } else
                {
                    u.right = true;
                    trgxz = j2 - gxz;
                }
            }
            responce = false;
        } else
        {
            responce = true;
        }
    }

    public void dosmokes(Graphics g, ContO conto)
    {
        if(conto.y > 200)
        {
            if(smoke && !conto.exp && sms[ns] == -1)
            {
                sx[ns] = conto.x + (int)(Math.random() * 150D - 75D);
                sy[ns] = conto.y + 10;
                sz[ns] = conto.z;
                sxz[ns] = conto.xz;
                sms[ns] = 0;
                ns++;
                if(ns == 4)
                {
                    ns = 0;
                }
                smoke = false;
            }
            int i = 0;
            do
            {
                if(sms[i] != -1)
                {
                    if(sms[i] < 5)
                    {
                        lsr.gsmoke(g, sx[i], sy[i], sz[i], sxz[i], 0, sms[i]);
                    }
                    sy[i] -= 10;
                    sms[i]++;
                    if(sms[i] == 10)
                    {
                        sms[i] = -1;
                    }
                }
            } while(++i < 4);
        }
    }

    public void reset(int i, int j)
    {
        rspeed = i;
        pexp = false;
        ltyp = j;
        int k = 0;
        do
        {
            lstage[k] = 0;
        } while(++k < 20);
    }

    public Tank(Medium medium)
    {
        u = new cControl();
        rspeed = 0;
        ltyp = 0;
        speed = 0.0F;
        pexp = false;
        left = false;
        right = false;
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
        ns = 0;
        smoke = false;
        turnat = (int)(Math.random() * 50D);
        tcnt = 0;
        gxz = 0;
        attack = 0;
        responce = false;
        trgxz = 180;
        trgt = 0;
        lsr = new Lasers(medium);
        int i = 0;
        do
        {
            sms[i] = -1;
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
