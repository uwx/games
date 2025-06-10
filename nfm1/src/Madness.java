 

import java.applet.AudioClip;
import java.awt.Color;

// Referenced classes of package mad:
//            Record, ContO, xtGraphics, Plane, 
//            Medium, CheckPoints, Control, Trackers

public class Madness
{

    Medium m;
    Record rpd;
    xtGraphics xt;
    int cn;
    int im;
    int mxz;
    int cxz;
    float acelf[][] = {
        {
            11F, 5F, 3F
        }, {
            8F, 7F, 5F
        }, {
            10F, 5F, 3.5F
        }, {
            11F, 6F, 3.5F
        }, {
            10F, 5F, 3.5F
        }, {
            12F, 6F, 3F
        }, {
            7F, 9F, 4F
        }, {
            9F, 5F, 3F
        }, {
            11F, 7F, 4F
        }, {
            12F, 6F, 3.5F
        }
    };
    int swits[][] = {
        {
            50, 180, 280
        }, {
            50, 200, 310
        }, {
            60, 180, 275
        }, {
            70, 190, 295
        }, {
            70, 170, 275
        }, {
            60, 200, 290
        }, {
            60, 170, 280
        }, {
            50, 160, 270
        }, {
            80, 200, 300
        }, {
            70, 210, 290
        }
    };
    int handb[] = {
        7, 10, 7, 15, 12, 8, 9, 10, 7, 7, 
        7
    };
    float airs[] = {
        1.0F, 1.2F, 0.95F, 1.0F, 1.5F, 1.0F, 0.9F, 0.8F, 1.3F, 1.0F
    };
    int airc[] = {
        70, 30, 40, 40, 30, 50, 40, 10, 100, 60
    };
    float drag[] = {
        0.5F, 0.5F, 0.5F, 0.5F, 0.5F, 0.5F, 0.5F, 0.5F, 0.5F, 0.5F
    };
    int turn[] = {
        6, 9, 5, 7, 6, 7, 5, 4, 7, 6
    };
    float grip[] = {
        20F, 27F, 18F, 22F, 15F, 20F, 25F, 25F, 25F, 27F
    };
    float bounce[] = {
        1.2F, 1.05F, 1.3F, 1.15F, 1.3F, 1.2F, 1.15F, 0.8F, 1.1F, 1.15F
    };
    float simag[] = {
        0.9F, 0.85F, 1.05F, 0.9F, 0.85F, 0.9F, 1.05F, 1.1F, 0.9F, 1.15F
    };
    float moment[] = {
        1.2F, 0.75F, 1.4F, 1.0F, 0.85F, 1.25F, 1.4F, 2.0F, 1.5F, 2.0F
    };
    float comprad[] = {
        0.5F, 0.4F, 0.8F, 0.5F, 0.5F, 0.5F, 0.5F, 1.5F, 0.5F, 0.8F
    };
    int push[] = {
        2, 2, 3, 3, 2, 2, 2, 4, 2, 2
    };
    int revpush[] = {
        2, 3, 2, 2, 2, 2, 2, 1, 2, 1
    };
    int lift[] = {
        0, 30, 0, 20, 0, 30, 0, 0, 30, 0
    };
    int revlift[] = {
        0, 0, 15, 0, 0, 0, 0, 0, 0, 32
    };
    int powerloss[] = {
        0x2625a0, 0x2625a0, 0x3567e0, 0x2625a0, 0x2625a0, 0x2625a0, 0x30d400, 0x44aa20, 0x2dc6c0, 0x53ec60
    };
    int flipy[] = {
        -50, -26, -90, -41, -55, -53, -54, -85, -60, -127
    };
    int msquash[] = {
        7, 3, 7, 2, 3, 3, 6, 10, 3, 8
    };
    int clrad[] = {
        3300, 1500, 4700, 3000, 1700, 2100, 3500, 7000, 4000, 4000
    };
    int maxmag[] = {
        3500, 1700, 7500, 5000, 3000, 4100, 6000, 9000, 4400, 9500
    };
    float dammult[] = {
        1.0F, 2.028F, 0.9375F, 1.1791F, 1.0F, 0.9066F, 1.0F, 0.6969F, 0.8266F, 0.7667F
    };
    int outdam[] = {
        77, 35, 80, 67, 55, 75, 81, 100, 75, 90
    };
    boolean dominate[];
    boolean caught[];
    int pzy;
    int pxy;
    float speed;
    float forca;
    float scy[];
    float scz[];
    float scx[];
    boolean mtouch;
    boolean wtouch;
    int cntouch;
    boolean capsized;
    int txz;
    int fxz;
    int pmlt;
    int nmlt;
    int dcnt;
    int skid;
    boolean pushed;
    boolean gtouch;
    boolean pl;
    boolean pr;
    boolean pd;
    boolean pu;
    int loop;
    float ucomp;
    float dcomp;
    float lcomp;
    float rcomp;
    int lxz;
    int travxy;
    int travzy;
    int travxz;
    int trcnt;
    int capcnt;
    int srfcnt;
    boolean rtab;
    boolean ftab;
    boolean btab;
    boolean surfer;
    float powerup;
    int xtpower;
    float tilt;
    int squash;
    int nbsq;
    int hitmag;
    int cntdest;
    boolean dest;
    boolean newcar;
    int pan;
    int pcleared;
    int clear;
    int nlaps;
    int focus;
    float power;
    int missedcp;
    int lastcolido;
    int point;
    boolean nofocus;
    boolean colidim;

    public int py(int i, int j, int k, int l)
    {
        return (i - j) * (i - j) + (k - l) * (k - l);
    }

    public void regy(int i, float f, ContO conto)
    {
        f *= dammult[cn];
        if(f > 100F)
        {
            rpd.recy(i, f, mtouch, im);
            f -= 100F;
            byte byte0 = 0;
            byte byte1 = 0;
            int j = conto.zy;
            int k = conto.xy;
            for(; j < 360; j += 360) { }
            for(; j > 360; j -= 360) { }
            if(j < 210 && j > 150)
            {
                byte0 = -1;
            }
            if(j > 330 || j < 30)
            {
                byte0 = 1;
            }
            for(; k < 360; k += 360) { }
            for(; k > 360; k -= 360) { }
            if(k < 210 && k > 150)
            {
                byte1 = -1;
            }
            if(k > 330 || k < 30)
            {
                byte1 = 1;
            }
            if(im == 0 || colidim)
            {
                xt.crash(f, byte1 * byte0);
            }
            if(byte1 * byte0 == 0 || mtouch)
            {
                for(int l = 0; l < conto.npl; l++)
                {
                    float f1 = 0.0F;
                    for(int k1 = 0; k1 < conto.p[l].n; k1++)
                    {
                        if(conto.p[l].wz == 0 && py(conto.keyx[i], conto.p[l].ox[k1], conto.keyz[i], conto.p[l].oz[k1]) < clrad[cn])
                        {
                            f1 = (f / 20F) * m.random();
                            conto.p[l].oz[k1] += f1 * m.sin(j);
                            conto.p[l].ox[k1] -= f1 * m.sin(k);
                            hitmag += Math.abs(f1);
                        }
                    }

                    if(f1 == 0.0F)
                    {
                        continue;
                    }
                    if(Math.abs(f1) >= 1.0F)
                    {
                        conto.p[l].chip = 1;
                        conto.p[l].ctmag = f1;
                    }
                    if(!conto.p[l].nocol && !conto.p[l].glass)
                    {
                        if(conto.p[l].bfase > 20 && (double)conto.p[l].hsb[1] > 0.20000000000000001D)
                        {
                            conto.p[l].hsb[1] = 0.2F;
                        }
                        if(conto.p[l].bfase > 30)
                        {
                            if((double)conto.p[l].hsb[2] < 0.5D)
                            {
                                conto.p[l].hsb[2] = 0.5F;
                            }
                            if((double)conto.p[l].hsb[1] > 0.10000000000000001D)
                            {
                                conto.p[l].hsb[1] = 0.1F;
                            }
                        }
                        if(conto.p[l].bfase > 40)
                        {
                            conto.p[l].hsb[1] = 0.05F;
                        }
                        if(conto.p[l].bfase > 50)
                        {
                            if((double)conto.p[l].hsb[2] > 0.80000000000000004D)
                            {
                                conto.p[l].hsb[2] = 0.8F;
                            }
                            conto.p[l].hsb[0] = 0.075F;
                            conto.p[l].hsb[1] = 0.05F;
                        }
                        if(conto.p[l].bfase > 60)
                        {
                            conto.p[l].hsb[0] = 0.05F;
                        }
                        conto.p[l].bfase += f1;
                        new Color(conto.p[l].c[0], conto.p[l].c[1], conto.p[l].c[2]);
                        Color color = Color.getHSBColor(conto.p[l].hsb[0], conto.p[l].hsb[1], conto.p[l].hsb[2]);
                        conto.p[l].c[0] = color.getRed();
                        conto.p[l].c[1] = color.getGreen();
                        conto.p[l].c[2] = color.getBlue();
                    }
                    if(conto.p[l].glass)
                    {
                        conto.p[l].gr -= Math.abs((double)f1 * 1.5D);
                    }
                }

            }
            if(byte1 * byte0 == -1)
            {
                if(nbsq > 0)
                {
                    int i1 = 0;
                    int j1 = 1;
                    for(int l1 = 0; l1 < conto.npl; l1++)
                    {
                        float f2 = 0.0F;
                        for(int i2 = 0; i2 < conto.p[l1].n; i2++)
                        {
                            if(conto.p[l1].wz != 0)
                            {
                                continue;
                            }
                            f2 = (f / 15F) * m.random();
                            if((Math.abs(conto.p[l1].oy[i2] - flipy[cn] - squash) < msquash[cn] * 3 || conto.p[l1].oy[i2] < flipy[cn] + squash) && squash < msquash[cn])
                            {
                                conto.p[l1].oy[i2] += f2;
                                i1 = (int)((float)i1 + f2);
                                j1++;
                                hitmag += Math.abs(f2);
                            }
                        }

                        if(conto.p[l1].glass)
                        {
                            conto.p[l1].gr -= 5;
                        } else
                        if(f2 != 0.0F)
                        {
                            conto.p[l1].bfase += f2;
                        }
                        if(Math.abs(f2) >= 1.0F)
                        {
                            conto.p[l1].chip = 1;
                            conto.p[l1].ctmag = f2;
                        }
                    }

                    squash += i1 / j1;
                    nbsq = 0;
                } else
                {
                    nbsq++;
                }
            }
        }
    }

    public Madness(Medium medium, Record record, xtGraphics xtgraphics, int i)
    {
        cn = 0;
        im = 0;
        mxz = 0;
        cxz = 0;
        dominate = new boolean[5];
        caught = new boolean[5];
        pzy = 0;
        pxy = 0;
        speed = 0.0F;
        forca = 0.0F;
        scy = new float[4];
        scz = new float[4];
        scx = new float[4];
        mtouch = false;
        wtouch = false;
        cntouch = 0;
        capsized = false;
        txz = 0;
        fxz = 0;
        pmlt = 1;
        nmlt = 1;
        dcnt = 0;
        skid = 0;
        pushed = false;
        gtouch = false;
        pl = false;
        pr = false;
        pd = false;
        pu = false;
        loop = 0;
        ucomp = 0.0F;
        dcomp = 0.0F;
        lcomp = 0.0F;
        rcomp = 0.0F;
        lxz = 0;
        travxy = 0;
        travzy = 0;
        travxz = 0;
        trcnt = 0;
        capcnt = 0;
        srfcnt = 0;
        rtab = false;
        ftab = false;
        btab = false;
        surfer = false;
        powerup = 0.0F;
        xtpower = 0;
        tilt = 0.0F;
        squash = 0;
        nbsq = 0;
        hitmag = 0;
        cntdest = 0;
        dest = false;
        newcar = false;
        pan = 0;
        pcleared = 0;
        clear = 0;
        nlaps = 0;
        focus = -1;
        power = 75F;
        missedcp = 0;
        lastcolido = 0;
        point = 0;
        nofocus = false;
        colidim = false;
        m = medium;
        rpd = record;
        xt = xtgraphics;
        im = i;
    }

    public int rpy(float f, float f1, float f2, float f3, float f4, float f5)
    {
        return (int)((f - f1) * (f - f1) + (f2 - f3) * (f2 - f3) + (f4 - f5) * (f4 - f5));
    }

    public void regz(int i, float f, ContO conto)
    {
        f *= dammult[cn];
        if(Math.abs(f) > 100F)
        {
            rpd.recz(i, f, im);
            if(f > 100F)
            {
                f -= 100F;
            }
            if(f < -100F)
            {
                f += 100F;
            }
            if(im == 0 || colidim)
            {
                xt.crash(f, 0);
            }
            for(int j = 0; j < conto.npl; j++)
            {
                float f1 = 0.0F;
                for(int k = 0; k < conto.p[j].n; k++)
                {
                    if(conto.p[j].wz == 0 && py(conto.keyx[i], conto.p[j].ox[k], conto.keyz[i], conto.p[j].oz[k]) < clrad[cn])
                    {
                        f1 = (f / 20F) * m.random();
                        conto.p[j].oz[k] += f1 * m.cos(conto.xz) * m.cos(conto.zy);
                        conto.p[j].ox[k] += f1 * m.sin(conto.xz) * m.cos(conto.xy);
                        hitmag += Math.abs(f1);
                    }
                }

                if(f1 == 0.0F)
                {
                    continue;
                }
                if(Math.abs(f1) >= 1.0F)
                {
                    conto.p[j].chip = 1;
                    conto.p[j].ctmag = f1;
                }
                if(!conto.p[j].nocol && !conto.p[j].glass)
                {
                    if(conto.p[j].bfase > 20 && (double)conto.p[j].hsb[1] > 0.20000000000000001D)
                    {
                        conto.p[j].hsb[1] = 0.2F;
                    }
                    if(conto.p[j].bfase > 30)
                    {
                        if((double)conto.p[j].hsb[2] < 0.5D)
                        {
                            conto.p[j].hsb[2] = 0.5F;
                        }
                        if((double)conto.p[j].hsb[1] > 0.10000000000000001D)
                        {
                            conto.p[j].hsb[1] = 0.1F;
                        }
                    }
                    if(conto.p[j].bfase > 40)
                    {
                        conto.p[j].hsb[1] = 0.05F;
                    }
                    if(conto.p[j].bfase > 50)
                    {
                        if((double)conto.p[j].hsb[2] > 0.80000000000000004D)
                        {
                            conto.p[j].hsb[2] = 0.8F;
                        }
                        conto.p[j].hsb[0] = 0.075F;
                        conto.p[j].hsb[1] = 0.05F;
                    }
                    if(conto.p[j].bfase > 60)
                    {
                        conto.p[j].hsb[0] = 0.05F;
                    }
                    conto.p[j].bfase += Math.abs(f1);
                    new Color(conto.p[j].c[0], conto.p[j].c[1], conto.p[j].c[2]);
                    Color color = Color.getHSBColor(conto.p[j].hsb[0], conto.p[j].hsb[1], conto.p[j].hsb[2]);
                    conto.p[j].c[0] = color.getRed();
                    conto.p[j].c[1] = color.getGreen();
                    conto.p[j].c[2] = color.getBlue();
                }
                if(conto.p[j].glass)
                {
                    conto.p[j].gr -= Math.abs((double)f1 * 1.5D);
                }
            }

        }
    }

    public void rot(float af[], float af1[], int i, int j, int k, int l)
    {
        if(k != 0)
        {
            for(int i1 = 0; i1 < l; i1++)
            {
                float f = af[i1];
                float f1 = af1[i1];
                af[i1] = (float)i + ((f - (float)i) * m.cos(k) - (f1 - (float)j) * m.sin(k));
                af1[i1] = (float)j + ((f - (float)i) * m.sin(k) + (f1 - (float)j) * m.cos(k));
            }

        }
    }

    public void colide(ContO conto, Madness madness, ContO conto1)
    {
        float af[] = new float[4];
        float af1[] = new float[4];
        float af2[] = new float[4];
        float af3[] = new float[4];
        float af4[] = new float[4];
        float af5[] = new float[4];
        int i = 0;
        do
        {
            af[i] = conto.x + conto.keyx[i];
            if(capsized)
            {
                af1[i] = conto.y + flipy[cn] + squash;
            } else
            {
                af1[i] = conto.y + conto.grat;
            }
            af2[i] = conto.z + conto.keyz[i];
            af3[i] = conto1.x + conto1.keyx[i];
            if(capsized)
            {
                af4[i] = conto1.y + madness.flipy[madness.cn] + madness.squash;
            } else
            {
                af4[i] = conto1.y + conto1.grat;
            }
            af5[i] = conto1.z + conto1.keyz[i];
        } while(++i < 4);
        rot(af, af1, conto.x, conto.y, conto.xy, 4);
        rot(af1, af2, conto.y, conto.z, conto.zy, 4);
        rot(af, af2, conto.x, conto.z, conto.xz, 4);
        rot(af3, af4, conto1.x, conto1.y, conto1.xy, 4);
        rot(af4, af5, conto1.y, conto1.z, conto1.zy, 4);
        rot(af3, af5, conto1.x, conto1.z, conto1.xz, 4);
        if((double)rpy(conto.x, conto1.x, conto.y, conto1.y, conto.z, conto1.z) < (double)(conto.maxR * conto.maxR + conto1.maxR * conto1.maxR) * 1.5D)
        {
            if(!caught[madness.im] && (speed != 0.0F || madness.speed != 0.0F))
            {
                if(Math.abs(power * speed * moment[cn]) != Math.abs(madness.power * madness.speed * madness.moment[madness.cn]))
                {
                    if(Math.abs(power * speed * moment[cn]) > Math.abs(madness.power * madness.speed * madness.moment[madness.cn]))
                    {
                        dominate[madness.im] = true;
                    } else
                    {
                        dominate[madness.im] = false;
                    }
                } else
                if(moment[cn] > madness.moment[madness.cn])
                {
                    dominate[madness.im] = true;
                } else
                {
                    dominate[madness.im] = false;
                }
                caught[madness.im] = true;
            }
        } else
        if(caught[madness.im])
        {
            caught[madness.im] = false;
        }
        if(dominate[madness.im])
        {
            int j = (int)(((((((((scz[0] - madness.scz[0]) + scz[1]) - madness.scz[1]) + scz[2]) - madness.scz[2]) + scz[3]) - madness.scz[3]) * (((((((scz[0] - madness.scz[0]) + scz[1]) - madness.scz[1]) + scz[2]) - madness.scz[2]) + scz[3]) - madness.scz[3]) + (((((((scx[0] - madness.scx[0]) + scx[1]) - madness.scx[1]) + scx[2]) - madness.scx[2]) + scx[3]) - madness.scx[3]) * (((((((scx[0] - madness.scx[0]) + scx[1]) - madness.scx[1]) + scx[2]) - madness.scx[2]) + scx[3]) - madness.scx[3])) / 16F);
            int k = 0;
            do
            {
                int l = 0;
                do
                {
                    if((float)rpy(af[k], af3[l], af1[k], af4[l], af2[k], af5[l]) < (float)(j + 7000) * (comprad[madness.cn] + comprad[cn]))
                    {
                        if(Math.abs(scx[k] * moment[cn]) > Math.abs(madness.scx[l] * madness.moment[madness.cn]))
                        {
                            float f = madness.scx[l] * (float)revpush[cn];
                            if(f > 300F)
                            {
                                f = 300F;
                            }
                            if(f < -300F)
                            {
                                f = -300F;
                            }
                            float f2 = scx[k] * (float)push[cn];
                            if(f2 > 300F)
                            {
                                f2 = 300F;
                            }
                            if(f2 < -300F)
                            {
                                f2 = -300F;
                            }
                            madness.scx[l] += f2;
                            if(im == 0)
                            {
                                madness.colidim = true;
                            }
                            madness.regx(l, f2 * moment[cn], conto1);
                            if(madness.colidim)
                            {
                                madness.colidim = false;
                            }
                            scx[k] -= f;
                            regx(k, -f * madness.moment[cn], conto);
                            scy[k] -= revlift[cn];
                            if(im == 0)
                            {
                                madness.colidim = true;
                            }
                            madness.regy(l, revlift[cn] * 7, conto1);
                            if(madness.colidim)
                            {
                                madness.colidim = false;
                            }
                        }
                        if(Math.abs(scz[k] * moment[cn]) > Math.abs(madness.scz[l] * madness.moment[madness.cn]))
                        {
                            float f1 = madness.scz[l] * (float)revpush[cn];
                            if(f1 > 300F)
                            {
                                f1 = 300F;
                            }
                            if(f1 < -300F)
                            {
                                f1 = -300F;
                            }
                            float f3 = scz[k] * (float)push[cn];
                            if(f3 > 300F)
                            {
                                f3 = 300F;
                            }
                            if(f3 < -300F)
                            {
                                f3 = -300F;
                            }
                            madness.scz[l] += f3;
                            if(im == 0)
                            {
                                madness.colidim = true;
                            }
                            madness.regz(l, f3 * moment[cn], conto1);
                            if(madness.colidim)
                            {
                                madness.colidim = false;
                            }
                            scz[k] -= f1;
                            regz(k, -f1 * madness.moment[cn], conto);
                            scy[k] -= revlift[cn];
                            if(im == 0)
                            {
                                madness.colidim = true;
                            }
                            madness.regy(l, revlift[cn] * 7, conto1);
                            if(madness.colidim)
                            {
                                madness.colidim = false;
                            }
                        }
                        if(im == 0)
                        {
                            madness.lastcolido = 70;
                        }
                        if(madness.im == 0)
                        {
                            lastcolido = 70;
                        }
                        madness.scy[l] -= lift[cn];
                    }
                } while(++l < 4);
            } while(++k < 4);
        }
    }

    public void distruct(ContO conto)
    {
        for(int i = 0; i < conto.npl; i++)
        {
            if(conto.p[i].wz == 0)
            {
                conto.p[i].embos = 1;
            }
        }

    }

    public void reseto(int i, ContO conto, CheckPoints checkpoints)
    {
        cn = i;
        int j = 0;
        do
        {
            dominate[j] = false;
            caught[j] = false;
        } while(++j < 5);
        if(cn == 7 && im == 0)
        {
            if(checkpoints.stage == 10)
            {
                moment[cn] = 1.7F;
            } else
            {
                moment[cn] = 2.0F;
            }
        }
        mxz = 0;
        cxz = 0;
        pzy = 0;
        pxy = 0;
        speed = 0.0F;
        j = 0;
        do
        {
            scy[j] = 0.0F;
            scx[j] = 0.0F;
            scz[j] = 0.0F;
        } while(++j < 4);
        forca = (((float)Math.sqrt(conto.keyz[0] * conto.keyz[0] + conto.keyx[0] * conto.keyx[0]) + (float)Math.sqrt(conto.keyz[1] * conto.keyz[1] + conto.keyx[1] * conto.keyx[1]) + (float)Math.sqrt(conto.keyz[2] * conto.keyz[2] + conto.keyx[2] * conto.keyx[2]) + (float)Math.sqrt(conto.keyz[3] * conto.keyz[3] + conto.keyx[3] * conto.keyx[3])) / 10000F) * (float)((double)bounce[cn] - 0.29999999999999999D);
        mtouch = false;
        wtouch = false;
        txz = 0;
        fxz = 0;
        pmlt = 1;
        nmlt = 1;
        dcnt = 0;
        skid = 0;
        pushed = false;
        gtouch = false;
        pl = false;
        pr = false;
        pd = false;
        pu = false;
        loop = 0;
        ucomp = 0.0F;
        dcomp = 0.0F;
        lcomp = 0.0F;
        rcomp = 0.0F;
        lxz = 0;
        travxy = 0;
        travzy = 0;
        travxz = 0;
        rtab = false;
        ftab = false;
        btab = false;
        powerup = 0.0F;
        xtpower = 0;
        trcnt = 0;
        capcnt = 0;
        tilt = 0.0F;
        pan = 0;
        pcleared = checkpoints.pcs;
        clear = 0;
        nlaps = 0;
        focus = -1;
        missedcp = 0;
        nofocus = false;
        power = 98F;
        lastcolido = 0;
        checkpoints.dested[im] = 0;
        squash = 0;
        nbsq = 0;
        hitmag = 0;
        cntdest = 0;
        dest = false;
        newcar = false;
    }

    public void regx(int i, float f, ContO conto)
    {
        f *= dammult[cn];
        if(Math.abs(f) > 100F)
        {
            rpd.recx(i, f, im);
            if(f > 100F)
            {
                f -= 100F;
            }
            if(f < -100F)
            {
                f += 100F;
            }
            if(im == 0 || colidim)
            {
                xt.crash(f, 0);
            }
            for(int j = 0; j < conto.npl; j++)
            {
                float f1 = 0.0F;
                for(int k = 0; k < conto.p[j].n; k++)
                {
                    if(conto.p[j].wz == 0 && py(conto.keyx[i], conto.p[j].ox[k], conto.keyz[i], conto.p[j].oz[k]) < clrad[cn])
                    {
                        f1 = (f / 20F) * m.random();
                        conto.p[j].oz[k] -= f1 * m.sin(conto.xz) * m.cos(conto.zy);
                        conto.p[j].ox[k] += f1 * m.cos(conto.xz) * m.cos(conto.xy);
                        hitmag += Math.abs(f1);
                    }
                }

                if(f1 == 0.0F)
                {
                    continue;
                }
                if(Math.abs(f1) >= 1.0F)
                {
                    conto.p[j].chip = 1;
                    conto.p[j].ctmag = f1;
                }
                if(!conto.p[j].nocol && !conto.p[j].glass)
                {
                    if(conto.p[j].bfase > 20 && (double)conto.p[j].hsb[1] > 0.20000000000000001D)
                    {
                        conto.p[j].hsb[1] = 0.2F;
                    }
                    if(conto.p[j].bfase > 30)
                    {
                        if((double)conto.p[j].hsb[2] < 0.5D)
                        {
                            conto.p[j].hsb[2] = 0.5F;
                        }
                        if((double)conto.p[j].hsb[1] > 0.10000000000000001D)
                        {
                            conto.p[j].hsb[1] = 0.1F;
                        }
                    }
                    if(conto.p[j].bfase > 40)
                    {
                        conto.p[j].hsb[1] = 0.05F;
                    }
                    if(conto.p[j].bfase > 50)
                    {
                        if((double)conto.p[j].hsb[2] > 0.80000000000000004D)
                        {
                            conto.p[j].hsb[2] = 0.8F;
                        }
                        conto.p[j].hsb[0] = 0.075F;
                        conto.p[j].hsb[1] = 0.05F;
                    }
                    if(conto.p[j].bfase > 60)
                    {
                        conto.p[j].hsb[0] = 0.05F;
                    }
                    conto.p[j].bfase += Math.abs(f1);
                    new Color(conto.p[j].c[0], conto.p[j].c[1], conto.p[j].c[2]);
                    Color color = Color.getHSBColor(conto.p[j].hsb[0], conto.p[j].hsb[1], conto.p[j].hsb[2]);
                    conto.p[j].c[0] = color.getRed();
                    conto.p[j].c[1] = color.getGreen();
                    conto.p[j].c[2] = color.getBlue();
                }
                if(conto.p[j].glass)
                {
                    conto.p[j].gr -= Math.abs((double)f1 * 1.5D);
                }
            }

        }
    }

    public void drive(Control control, ContO conto, Trackers trackers, CheckPoints checkpoints)
    {
        int i = 1;
        int j = 1;
        boolean flag = false;
        boolean flag1 = false;
        boolean flag2 = false;
        capsized = false;
        int k;
        for(k = Math.abs(pzy); k > 270; k -= 360) { }
        k = Math.abs(k);
        if(k > 90)
        {
            flag = true;
        }
        boolean flag3 = false;
        int l;
        for(l = Math.abs(pxy); l > 270; l -= 360) { }
        l = Math.abs(l);
        if(l > 90)
        {
            flag3 = true;
            j = -1;
        }
        int i1 = conto.grat;
        if(flag)
        {
            if(flag3)
            {
                flag3 = false;
                flag1 = true;
            } else
            {
                flag3 = true;
                capsized = true;
            }
            i = -1;
        } else
        if(flag3)
        {
            capsized = true;
        }
        if(capsized)
        {
            i1 = flipy[cn] + squash;
        }
        control.zyinv = flag;
        float f = 0.0F;
        float f1 = 0.0F;
        float f2 = 0.0F;
        if(mtouch)
        {
            loop = 0;
        }
        if(wtouch)
        {
            if(loop == 2 || loop == -1)
            {
                loop = -1;
                if(control.left)
                {
                    pl = true;
                }
                if(control.right)
                {
                    pr = true;
                }
                if(control.up)
                {
                    pu = true;
                }
                if(control.down)
                {
                    pd = true;
                }
            }
            ucomp = 0.0F;
            dcomp = 0.0F;
            lcomp = 0.0F;
            rcomp = 0.0F;
        }
        if(control.handb)
        {
            if(!pushed)
            {
                if(!wtouch)
                {
                    if(loop == 0)
                    {
                        loop = 1;
                    }
                } else
                if(gtouch)
                {
                    pushed = true;
                }
            }
        } else
        {
            pushed = false;
        }
        if(loop == 1)
        {
            float f3 = (scy[0] + scy[1] + scy[2] + scy[3]) / 4F;
            int j1 = 0;
            do
            {
                scy[j1] = f3;
            } while(++j1 < 4);
            loop = 2;
        }
        if(!dest)
        {
            if(loop == 2)
            {
                if(control.up)
                {
                    if(ucomp == 0.0F)
                    {
                        ucomp = 10F + (scy[0] + 50F) / 20F;
                        if(ucomp < 5F)
                        {
                            ucomp = 5F;
                        }
                        if(ucomp > 10F)
                        {
                            ucomp = 10F;
                        }
                        ucomp *= airs[cn];
                    }
                    if(ucomp < 20F)
                    {
                        ucomp += 0.5D * (double)airs[cn];
                    }
                    f = (float)(-airc[cn]) * m.sin(conto.xz) * (float)j;
                    f1 = (float)airc[cn] * m.cos(conto.xz) * (float)j;
                } else
                if(ucomp != 0.0F && ucomp > -2F)
                {
                    ucomp -= 0.5D * (double)airs[cn];
                }
                if(control.down)
                {
                    if(dcomp == 0.0F)
                    {
                        dcomp = 10F + (scy[0] + 50F) / 20F;
                        if(dcomp < 5F)
                        {
                            dcomp = 5F;
                        }
                        if(dcomp > 10F)
                        {
                            dcomp = 10F;
                        }
                        dcomp *= airs[cn];
                    }
                    if(dcomp < 20F)
                    {
                        dcomp += 0.5D * (double)airs[cn];
                    }
                    f2 = -airc[cn];
                } else
                if(dcomp != 0.0F && ucomp > -2F)
                {
                    dcomp -= 0.5D * (double)airs[cn];
                }
                if(control.left)
                {
                    if(lcomp == 0.0F)
                    {
                        lcomp = 5F;
                    }
                    if(lcomp < 20F)
                    {
                        lcomp += 2.0F * airs[cn];
                    }
                    f = (float)(-airc[cn]) * m.cos(conto.xz) * (float)i;
                    f1 = (float)(-airc[cn]) * m.sin(conto.xz) * (float)i;
                } else
                if(lcomp > 0.0F)
                {
                    lcomp -= 2.0F * airs[cn];
                }
                if(control.right)
                {
                    if(rcomp == 0.0F)
                    {
                        rcomp = 5F;
                    }
                    if(rcomp < 20F)
                    {
                        rcomp += 2.0F * airs[cn];
                    }
                    f = (float)airc[cn] * m.cos(conto.xz) * (float)i;
                    f1 = (float)airc[cn] * m.sin(conto.xz) * (float)i;
                } else
                if(rcomp > 0.0F)
                {
                    rcomp -= 2.0F * airs[cn];
                }
                pzy += (dcomp - ucomp) * m.cos(pxy);
                if(flag)
                {
                    conto.xz += (dcomp - ucomp) * m.sin(pxy);
                } else
                {
                    conto.xz -= (dcomp - ucomp) * m.sin(pxy);
                }
                pxy += rcomp - lcomp;
            } else
            {
                float f4 = power;
                if(f4 < 40F)
                {
                    f4 = 40F;
                }
                if(im == 0 && power != 98F)
                {
                    if(checkpoints.stage != 6 && checkpoints.stage != 8)
                    {
                        f4 = (float)((double)f4 * 0.76000000000000001D);
                    } else
                    if(checkpoints.stage != 6)
                    {
                        f4 = (float)((double)f4 * 0.90000000000000002D);
                    }
                }
                if(control.down)
                {
                    if(speed > 0.0F)
                    {
                        speed -= handb[cn] / 2;
                    } else
                    {
                        int k1 = 0;
                        int j2 = 0;
                        do
                        {
                            if(speed <= -((float)(swits[cn][j2] / 2) + (f4 * (float)swits[cn][j2]) / 196F))
                            {
                                k1++;
                            }
                        } while(++j2 < 2);
                        if(k1 != 2)
                        {
                            speed -= acelf[cn][k1] / 2.0F + (f4 * acelf[cn][k1]) / 196F;
                        } else
                        {
                            speed = -((float)(swits[cn][1] / 2) + (f4 * (float)swits[cn][1]) / 196F);
                        }
                    }
                }
                if(control.up)
                {
                    if(speed < 0.0F)
                    {
                        speed += handb[cn];
                    } else
                    {
                        int l1 = 0;
                        int k2 = 0;
                        do
                        {
                            if(speed >= (float)(swits[cn][k2] / 2) + (f4 * (float)swits[cn][k2]) / 196F)
                            {
                                l1++;
                            }
                        } while(++k2 < 3);
                        if(l1 != 3)
                        {
                            speed += acelf[cn][l1] / 2.0F + (f4 * acelf[cn][l1]) / 196F;
                        } else
                        {
                            speed = (float)(swits[cn][2] / 2) + (f4 * (float)swits[cn][2]) / 196F;
                        }
                    }
                }
                if(control.handb && Math.abs(speed) > (float)handb[cn])
                {
                    if(speed < 0.0F)
                    {
                        speed += handb[cn];
                    } else
                    {
                        speed -= handb[cn];
                    }
                }
                if(loop == -1 && conto.y < 100)
                {
                    if(control.left)
                    {
                        if(!pl)
                        {
                            if(lcomp == 0.0F)
                            {
                                lcomp = 5F * airs[cn];
                            }
                            if(lcomp < 20F)
                            {
                                lcomp += 2.0F * airs[cn];
                            }
                        }
                    } else
                    {
                        if(lcomp > 0.0F)
                        {
                            lcomp -= 2.0F * airs[cn];
                        }
                        pl = false;
                    }
                    if(control.right)
                    {
                        if(!pr)
                        {
                            if(rcomp == 0.0F)
                            {
                                rcomp = 5F * airs[cn];
                            }
                            if(rcomp < 20F)
                            {
                                rcomp += 2.0F * airs[cn];
                            }
                        }
                    } else
                    {
                        if(rcomp > 0.0F)
                        {
                            rcomp -= 2.0F * airs[cn];
                        }
                        pr = false;
                    }
                    if(control.up)
                    {
                        if(!pu)
                        {
                            if(ucomp == 0.0F)
                            {
                                ucomp = 5F * airs[cn];
                            }
                            if(ucomp < 20F)
                            {
                                ucomp += 2.0F * airs[cn];
                            }
                        }
                    } else
                    {
                        if(ucomp > 0.0F)
                        {
                            ucomp -= 2.0F * airs[cn];
                        }
                        pu = false;
                    }
                    if(control.down)
                    {
                        if(!pd)
                        {
                            if(dcomp == 0.0F)
                            {
                                dcomp = 5F * airs[cn];
                            }
                            if(dcomp < 20F)
                            {
                                dcomp += 2.0F * airs[cn];
                            }
                        }
                    } else
                    {
                        if(dcomp > 0.0F)
                        {
                            dcomp -= 2.0F * airs[cn];
                        }
                        pd = false;
                    }
                    pzy += (dcomp - ucomp) * m.cos(pxy);
                    if(flag)
                    {
                        conto.xz += (dcomp - ucomp) * m.sin(pxy);
                    } else
                    {
                        conto.xz -= (dcomp - ucomp) * m.sin(pxy);
                    }
                    pxy += rcomp - lcomp;
                }
            }
        }
        float f5 = (20F * speed) / (154F * simag[cn]);
        if(f5 > 20F)
        {
            f5 = 20F;
        }
        conto.wzy -= f5;
        if(conto.wzy < -45)
        {
            conto.wzy += 45;
        }
        if(conto.wzy > 45)
        {
            conto.wzy -= 45;
        }
        if(control.right)
        {
            conto.wxz -= turn[cn];
            if(conto.wxz < -36)
            {
                conto.wxz = -36;
            }
        }
        if(control.left)
        {
            conto.wxz += turn[cn];
            if(conto.wxz > 36)
            {
                conto.wxz = 36;
            }
        }
        if(conto.wxz != 0 && !control.left && !control.right)
        {
            if(Math.abs(speed) < 10F)
            {
                if(Math.abs(conto.wxz) == 1)
                {
                    conto.wxz = 0;
                }
                if(conto.wxz > 0)
                {
                    conto.wxz--;
                }
                if(conto.wxz < 0)
                {
                    conto.wxz++;
                }
            } else
            {
                if(Math.abs(conto.wxz) < turn[cn] * 2)
                {
                    conto.wxz = 0;
                }
                if(conto.wxz > 0)
                {
                    conto.wxz -= turn[cn] * 2;
                }
                if(conto.wxz < 0)
                {
                    conto.wxz += turn[cn] * 2;
                }
            }
        }
        int i2 = (int)(3600F / (speed * speed));
        if(i2 < 5)
        {
            i2 = 5;
        }
        if(speed < 0.0F)
        {
            i2 = -i2;
        }
        if(wtouch)
        {
            if(!capsized)
            {
                if(!control.handb)
                {
                    fxz = conto.wxz / (i2 * 3);
                } else
                {
                    fxz = conto.wxz / i2;
                }
                conto.xz += conto.wxz / i2;
            }
            wtouch = false;
            gtouch = false;
        } else
        {
            conto.xz += fxz;
        }
        if(speed > 30F || speed < -100F)
        {
            do
            {
                if(Math.abs(mxz - cxz) <= 180)
                {
                    break;
                }
                if(cxz > mxz)
                {
                    cxz -= 360;
                } else
                if(cxz < mxz)
                {
                    cxz += 360;
                }
            } while(true);
            if(Math.abs(mxz - cxz) < 30)
            {
                cxz += (float)(mxz - cxz) / 4F;
            } else
            {
                if(cxz > mxz)
                {
                    cxz -= 10;
                }
                if(cxz < mxz)
                {
                    cxz += 10;
                }
            }
        }
        float af[] = new float[4];
        float af1[] = new float[4];
        float af2[] = new float[4];
        int l2 = 0;
        do
        {
            af[l2] = conto.keyx[l2] + conto.x;
            af2[l2] = i1 + conto.y;
            af1[l2] = conto.z + conto.keyz[l2];
            scy[l2] += 7F;
        } while(++l2 < 4);
        rot(af, af2, conto.x, conto.y, pxy, 4);
        rot(af2, af1, conto.y, conto.z, pzy, 4);
        rot(af, af1, conto.x, conto.z, conto.xz, 4);
        boolean flag4 = false;
        double d = 0.0D;
        int i3 = (int)((scx[0] + scx[1] + scx[2] + scx[3]) / 4F);
        int j3 = (int)((scz[0] + scz[1] + scz[2] + scz[3]) / 4F);
        int k3 = 0;
        do
        {
            if(scx[k3] - (float)i3 > 200F)
            {
                scx[k3] = 200 + i3;
            }
            if(scx[k3] - (float)i3 < -200F)
            {
                scx[k3] = i3 - 200;
            }
            if(scz[k3] - (float)j3 > 200F)
            {
                scz[k3] = 200 + j3;
            }
            if(scz[k3] - (float)j3 < -200F)
            {
                scz[k3] = j3 - 200;
            }
        } while(++k3 < 4);
        k3 = 0;
        do
        {
            af2[k3] += scy[k3];
            af[k3] += (scx[0] + scx[1] + scx[2] + scx[3]) / 4F;
            af1[k3] += (scz[0] + scz[1] + scz[2] + scz[3]) / 4F;
        } while(++k3 < 4);
        k3 = 1;
        for(int l3 = 0; l3 < trackers.nt; l3++)
        {
            if(Math.abs(trackers.zy[l3]) != 90 && Math.abs(trackers.xy[l3]) != 90 && Math.abs(conto.x - trackers.x[l3]) < trackers.radx[l3] && Math.abs(conto.z - trackers.z[l3]) < trackers.radz[l3])
            {
                k3 = trackers.skd[l3];
            }
        }

        if(mtouch)
        {
            float f6 = grip[cn];
            f6 -= ((float)Math.abs(txz - conto.xz) * speed) / 250F;
            if(control.handb)
            {
                f6 -= Math.abs(txz - conto.xz) * 4;
            }
            if(f6 < grip[cn])
            {
                if(skid != 2)
                {
                    skid = 1;
                }
                speed -= speed / 100F;
            } else
            if(skid == 1)
            {
                skid = 2;
            }
            if(k3 == 1)
            {
                f6 = (float)((double)f6 * 0.75D);
            }
            if(k3 == 2)
            {
                f6 = (float)((double)f6 * 0.55000000000000004D);
            }
            int j4 = -(int)(speed * m.sin(conto.xz) * m.cos(pzy));
            int k4 = (int)(speed * m.cos(conto.xz) * m.cos(pzy));
            int i5 = -(int)(speed * m.sin(pzy));
            if(capsized || dest || checkpoints.haltall)
            {
                j4 = 0;
                k4 = 0;
                i5 = 0;
                f6 = grip[cn] / 5F;
                if(speed > 0.0F)
                {
                    speed -= 2.0F;
                } else
                {
                    speed += 2.0F;
                }
            }
            if(Math.abs(speed) > drag[cn])
            {
                if(speed > 0.0F)
                {
                    speed -= drag[cn];
                } else
                {
                    speed += drag[cn];
                }
            } else
            {
                speed = 0.0F;
            }
            if(f6 < 1.0F)
            {
                f6 = 1.0F;
            }
            float f9 = 0.0F;
            float f10 = 0.0F;
            int l6 = 0;
            do
            {
                if(Math.abs(scx[l6] - (float)j4) > f6)
                {
                    if(scx[l6] < (float)j4)
                    {
                        scx[l6] += f6;
                    } else
                    {
                        scx[l6] -= f6;
                    }
                } else
                {
                    scx[l6] = j4;
                }
                if(Math.abs(scz[l6] - (float)k4) > f6)
                {
                    if(scz[l6] < (float)k4)
                    {
                        scz[l6] += f6;
                    } else
                    {
                        scz[l6] -= f6;
                    }
                } else
                {
                    scz[l6] = k4;
                }
                if(Math.abs(scy[l6] - (float)i5) > f6)
                {
                    if(scy[l6] < (float)i5)
                    {
                        scy[l6] += f6;
                    } else
                    {
                        scy[l6] -= f6;
                    }
                } else
                {
                    scy[l6] = i5;
                }
                if(f6 < grip[cn])
                {
                    if(txz != conto.xz)
                    {
                        dcnt++;
                    } else
                    if(dcnt != 0)
                    {
                        dcnt = 0;
                    }
                    if((float)dcnt > (40F * f6) / grip[cn] || capsized)
                    {
                        float f11 = 1.0F;
                        if(k3 != 0)
                        {
                            f11 = 1.2F;
                        }
                        if((double)m.random() > 0.75D)
                        {
                            conto.dust(l6, af[l6], af2[l6], af1[l6], scx[l6], scz[l6], f11 * simag[cn], true, (int)tilt);
                            if(im == 0 && !capsized)
                            {
                                xt.skid(k3, (float)Math.sqrt(scx[l6] * scx[l6] + scz[l6] * scz[l6]));
                            }
                        }
                    } else
                    {
                        if(k3 == 1 && (double)m.random() > 0.84999999999999998D)
                        {
                            conto.dust(l6, af[l6], af2[l6], af1[l6], scx[l6], scz[l6], 1.1F * simag[cn], false, (int)tilt);
                        }
                        if((k3 == 2 || k3 == 3) && (double)m.random() > 0.69999999999999996D)
                        {
                            conto.dust(l6, af[l6], af2[l6], af1[l6], scx[l6], scz[l6], 1.15F * simag[cn], false, (int)tilt);
                        }
                    }
                } else
                if(dcnt != 0)
                {
                    dcnt -= 2;
                    if(dcnt < 0)
                    {
                        dcnt = 0;
                    }
                }
                if(k3 == 3)
                {
                    int k7 = (int)(m.random() * 4F);
                    scy[k7] = (float)((double)(-100F * m.random() * (speed / (float)swits[cn][2])) * ((double)bounce[cn] - 0.29999999999999999D));
                }
                f9 += scx[l6];
                f10 += scz[l6];
            } while(++l6 < 4);
            txz = conto.xz;
            if(f9 > 0.0F)
            {
                i = -1;
            } else
            {
                i = 1;
            }
            double d1 = (double)f10 / Math.sqrt(f9 * f9 + f10 * f10);
            mxz = (int)((Math.acos(d1) / 0.017453292519943295D) * (double)i);
            if(skid == 2)
            {
                if(!capsized)
                {
                    f9 /= 4F;
                    f10 /= 4F;
                    if(flag1)
                    {
                        speed = -((float)Math.sqrt(f9 * f9 + f10 * f10) * m.cos(mxz - conto.xz));
                    } else
                    {
                        speed = (float)Math.sqrt(f9 * f9 + f10 * f10) * m.cos(mxz - conto.xz);
                    }
                }
                skid = 0;
            }
            if(capsized && f9 == 0.0F && f10 == 0.0F)
            {
                k3 = 0;
            }
            mtouch = false;
            flag4 = true;
        } else
        if(skid != 2)
        {
            skid = 2;
        }
        int i4 = 0;
        boolean aflag[] = new boolean[4];
        int l4 = 0;
        do
        {
            if(af2[l4] > 245F)
            {
                i4++;
                wtouch = true;
                gtouch = true;
                if(!flag4 && scy[l4] != 7F)
                {
                    float f7 = scy[l4] / 333.33F;
                    if((double)f7 > 0.29999999999999999D)
                    {
                        f7 = 0.3F;
                    }
                    if(k3 == 0)
                    {
                        f7 = (float)((double)f7 + 1.1000000000000001D);
                    } else
                    {
                        f7 = (float)((double)f7 + 1.2D);
                    }
                    conto.dust(l4, af[l4], af2[l4], af1[l4], scx[l4], scz[l4], f7 * simag[cn], true, 0);
                }
                af2[l4] = 250F;
                float f8 = 0.0F;
                do
                {
                    if((float)l4 != f8 && af2[(int)f8] <= 245F)
                    {
                        af2[(int)f8] -= af2[l4] - 250F;
                    }
                } while(++f8 < 4F);
                f8 = Math.abs(m.sin(pxy)) + Math.abs(m.sin(pzy));
                f8 /= 3F;
                if((double)f8 > 0.40000000000000002D)
                {
                    f8 = 0.4F;
                }
                f8 += bounce[cn];
                if((double)f8 < 1.1000000000000001D)
                {
                    f8 = 1.1F;
                }
                regy(l4, Math.abs(scy[l4] * f8), conto);
                if(scy[l4] > 0.0F)
                {
                    scy[l4] -= Math.abs(scy[l4] * f8);
                }
            }
            aflag[l4] = false;
        } while(++l4 < 4);
        l4 = 0;
        for(int j5 = 0; j5 < trackers.nt; j5++)
        {
            int l5 = 0;
            int j6 = 0;
            int i7 = 0;
            do
            {
                if(!aflag[i7] && af[i7] > (float)(trackers.x[j5] - trackers.radx[j5]) && af[i7] < (float)(trackers.x[j5] + trackers.radx[j5]) && af1[i7] > (float)(trackers.z[j5] - trackers.radz[j5]) && af1[i7] < (float)(trackers.z[j5] + trackers.radz[j5]) && af2[i7] > (float)(trackers.y[j5] - trackers.rady[j5]) && af2[i7] < (float)(trackers.y[j5] + trackers.rady[j5]))
                {
                    if(trackers.xy[j5] == 0 && trackers.zy[j5] == 0 && trackers.y[j5] != 250 && af2[i7] > (float)(trackers.y[j5] - 5))
                    {
                        j6++;
                        wtouch = true;
                        gtouch = true;
                        if(!flag4 && scy[i7] != 7F)
                        {
                            float f12 = scy[i7] / 333.33F;
                            if((double)f12 > 0.29999999999999999D)
                            {
                                f12 = 0.3F;
                            }
                            if(k3 == 0)
                            {
                                f12 = (float)((double)f12 + 1.1000000000000001D);
                            } else
                            {
                                f12 = (float)((double)f12 + 1.2D);
                            }
                            conto.dust(i7, af[i7], af2[i7], af1[i7], scx[i7], scz[i7], f12 * simag[cn], true, 0);
                        }
                        af2[i7] = trackers.y[j5];
                        float f13 = 0.0F;
                        do
                        {
                            if((float)i7 != f13 && af2[(int)f13] <= (float)(trackers.y[j5] - 5))
                            {
                                af2[(int)f13] -= af2[i7] - (float)trackers.y[j5];
                            }
                        } while(++f13 < 4F);
                        f13 = Math.abs(m.sin(pxy)) + Math.abs(m.sin(pzy));
                        f13 /= 3F;
                        if((double)f13 > 0.40000000000000002D)
                        {
                            f13 = 0.4F;
                        }
                        f13 += bounce[cn];
                        if((double)f13 < 1.1000000000000001D)
                        {
                            f13 = 1.1F;
                        }
                        regy(i7, Math.abs(scy[i7] * f13), conto);
                        if(scy[i7] > 0.0F)
                        {
                            scy[i7] -= Math.abs(scy[i7] * f13);
                        }
                        aflag[i7] = true;
                    }
                    if(trackers.zy[j5] == -90 && af1[i7] < (float)(trackers.z[j5] + trackers.radz[j5]) && scz[i7] < 0.0F)
                    {
                        af1[i7] = trackers.z[j5] + trackers.radz[j5];
                        float f14 = 0.0F;
                        do
                        {
                            if((float)i7 != f14 && af1[(int)f14] >= (float)(trackers.z[j5] + trackers.radz[j5]))
                            {
                                af1[(int)f14] -= af1[i7] - (float)(trackers.z[j5] + trackers.radz[j5]);
                            }
                        } while(++f14 < 4F);
                        f14 = Math.abs(m.cos(pxy)) + Math.abs(m.cos(pzy));
                        f14 /= 4F;
                        if((double)f14 > 0.29999999999999999D)
                        {
                            f14 = 0.3F;
                        }
                        if(flag4)
                        {
                            f14 = 0.0F;
                        }
                        f14 = (float)((double)f14 + ((double)bounce[cn] - 0.20000000000000001D));
                        if((double)f14 < 1.1000000000000001D)
                        {
                            f14 = 1.1F;
                        }
                        regz(i7, Math.abs(scz[i7] * f14 * (float)trackers.dam[j5]), conto);
                        scz[i7] += Math.abs(scz[i7] * f14);
                        skid = 2;
                        flag2 = true;
                        aflag[i7] = true;
                        control.wall = j5;
                    }
                    if(trackers.zy[j5] == 90 && af1[i7] > (float)(trackers.z[j5] - trackers.radz[j5]) && scz[i7] > 0.0F)
                    {
                        af1[i7] = trackers.z[j5] - trackers.radz[j5];
                        float f15 = 0.0F;
                        do
                        {
                            if((float)i7 != f15 && af1[(int)f15] <= (float)(trackers.z[j5] - trackers.radz[j5]))
                            {
                                af1[(int)f15] -= af1[i7] - (float)(trackers.z[j5] - trackers.radz[j5]);
                            }
                        } while(++f15 < 4F);
                        f15 = Math.abs(m.cos(pxy)) + Math.abs(m.cos(pzy));
                        f15 /= 4F;
                        if((double)f15 > 0.29999999999999999D)
                        {
                            f15 = 0.3F;
                        }
                        if(flag4)
                        {
                            f15 = 0.0F;
                        }
                        f15 = (float)((double)f15 + ((double)bounce[cn] - 0.20000000000000001D));
                        if((double)f15 < 1.1000000000000001D)
                        {
                            f15 = 1.1F;
                        }
                        regz(i7, -Math.abs(scz[i7] * f15 * (float)trackers.dam[j5]), conto);
                        scz[i7] -= Math.abs(scz[i7] * f15);
                        skid = 2;
                        flag2 = true;
                        aflag[i7] = true;
                        control.wall = j5;
                    }
                    if(trackers.xy[j5] == -90 && af[i7] < (float)(trackers.x[j5] + trackers.radx[j5]) && scx[i7] < 0.0F)
                    {
                        af[i7] = trackers.x[j5] + trackers.radx[j5];
                        float f16 = 0.0F;
                        do
                        {
                            if((float)i7 != f16 && af[(int)f16] >= (float)(trackers.x[j5] + trackers.radx[j5]))
                            {
                                af[(int)f16] -= af[i7] - (float)(trackers.x[j5] + trackers.radx[j5]);
                            }
                        } while(++f16 < 4F);
                        f16 = Math.abs(m.cos(pxy)) + Math.abs(m.cos(pzy));
                        f16 /= 4F;
                        if((double)f16 > 0.29999999999999999D)
                        {
                            f16 = 0.3F;
                        }
                        if(flag4)
                        {
                            f16 = 0.0F;
                        }
                        f16 = (float)((double)f16 + ((double)bounce[cn] - 0.20000000000000001D));
                        if((double)f16 < 1.1000000000000001D)
                        {
                            f16 = 1.1F;
                        }
                        regx(i7, Math.abs(scx[i7] * f16 * (float)trackers.dam[j5]), conto);
                        scx[i7] += Math.abs(scx[i7] * f16);
                        skid = 2;
                        flag2 = true;
                        aflag[i7] = true;
                        control.wall = j5;
                    }
                    if(trackers.xy[j5] == 90 && af[i7] > (float)(trackers.x[j5] - trackers.radx[j5]) && scx[i7] > 0.0F)
                    {
                        af[i7] = trackers.x[j5] - trackers.radx[j5];
                        float f17 = 0.0F;
                        do
                        {
                            if((float)i7 != f17 && af[(int)f17] <= (float)(trackers.x[j5] - trackers.radx[j5]))
                            {
                                af[(int)f17] -= af[i7] - (float)(trackers.x[j5] - trackers.radx[j5]);
                            }
                        } while(++f17 < 4F);
                        f17 = Math.abs(m.cos(pxy)) + Math.abs(m.cos(pzy));
                        f17 /= 4F;
                        if((double)f17 > 0.29999999999999999D)
                        {
                            f17 = 0.3F;
                        }
                        if(flag4)
                        {
                            f17 = 0.0F;
                        }
                        f17 = (float)((double)f17 + ((double)bounce[cn] - 0.20000000000000001D));
                        if((double)f17 < 1.1000000000000001D)
                        {
                            f17 = 1.1F;
                        }
                        regx(i7, -Math.abs(scx[i7] * f17 * (float)trackers.dam[j5]), conto);
                        scx[i7] -= Math.abs(scx[i7] * f17);
                        skid = 2;
                        flag2 = true;
                        aflag[i7] = true;
                        control.wall = j5;
                    }
                    if(trackers.zy[j5] != 0 && trackers.zy[j5] != 90 && trackers.zy[j5] != -90)
                    {
                        int l7 = 90 + trackers.zy[j5];
                        float f19 = 1.0F + (float)(50 - Math.abs(trackers.zy[j5])) / 30F;
                        if(f19 < 1.0F)
                        {
                            f19 = 1.0F;
                        }
                        float f21 = (float)trackers.y[j5] + ((af2[i7] - (float)trackers.y[j5]) * m.cos(l7) - (af1[i7] - (float)trackers.z[j5]) * m.sin(l7));
                        float f23 = (float)trackers.z[j5] + ((af2[i7] - (float)trackers.y[j5]) * m.sin(l7) + (af1[i7] - (float)trackers.z[j5]) * m.cos(l7));
                        if(f23 > (float)trackers.z[j5] && f23 < (float)(trackers.z[j5] + 200))
                        {
                            scy[i7] -= (f23 - (float)trackers.z[j5]) / f19;
                            f23 = trackers.z[j5];
                        }
                        if(f23 > (float)(trackers.z[j5] - 30))
                        {
                            if(trackers.skd[j5] == 2)
                            {
                                l5++;
                            } else
                            {
                                l4++;
                            }
                            wtouch = true;
                            gtouch = false;
                            if(!flag4 && k3 != 0)
                            {
                                float f25 = 1.4F;
                                conto.dust(i7, af[i7], af2[i7], af1[i7], scx[i7], scz[i7], f25 * simag[cn], true, 0);
                            }
                        }
                        af2[i7] = (float)trackers.y[j5] + ((f21 - (float)trackers.y[j5]) * m.cos(-l7) - (f23 - (float)trackers.z[j5]) * m.sin(-l7));
                        af1[i7] = (float)trackers.z[j5] + ((f21 - (float)trackers.y[j5]) * m.sin(-l7) + (f23 - (float)trackers.z[j5]) * m.cos(-l7));
                        aflag[i7] = true;
                    }
                    if(trackers.xy[j5] != 0 && trackers.xy[j5] != 90 && trackers.xy[j5] != -90)
                    {
                        int i8 = 90 + trackers.xy[j5];
                        float f20 = 1.0F + (float)(50 - Math.abs(trackers.xy[j5])) / 30F;
                        if(f20 < 1.0F)
                        {
                            f20 = 1.0F;
                        }
                        float f22 = (float)trackers.y[j5] + ((af2[i7] - (float)trackers.y[j5]) * m.cos(i8) - (af[i7] - (float)trackers.x[j5]) * m.sin(i8));
                        float f24 = (float)trackers.x[j5] + ((af2[i7] - (float)trackers.y[j5]) * m.sin(i8) + (af[i7] - (float)trackers.x[j5]) * m.cos(i8));
                        if(f24 > (float)trackers.x[j5] && f24 < (float)(trackers.x[j5] + 200))
                        {
                            scy[i7] -= (f24 - (float)trackers.x[j5]) / f20;
                            f24 = trackers.x[j5];
                        }
                        if(f24 > (float)(trackers.x[j5] - 30))
                        {
                            if(trackers.skd[j5] == 2)
                            {
                                l5++;
                            } else
                            {
                                l4++;
                            }
                            wtouch = true;
                            gtouch = false;
                            if(!flag4 && k3 != 0)
                            {
                                float f26 = 1.4F;
                                conto.dust(i7, af[i7], af2[i7], af1[i7], scx[i7], scz[i7], f26 * simag[cn], true, 0);
                            }
                        }
                        af2[i7] = (float)trackers.y[j5] + ((f22 - (float)trackers.y[j5]) * m.cos(-i8) - (f24 - (float)trackers.x[j5]) * m.sin(-i8));
                        af[i7] = (float)trackers.x[j5] + ((f22 - (float)trackers.y[j5]) * m.sin(-i8) + (f24 - (float)trackers.x[j5]) * m.cos(-i8));
                        aflag[i7] = true;
                    }
                }
            } while(++i7 < 4);
            if(l5 == 4)
            {
                mtouch = true;
            }
            if(j6 == 4)
            {
                i4 = 4;
            }
        }

        if(l4 == 4)
        {
            mtouch = true;
        }
        int k5 = 0;
        int i6 = 0;
        int k6 = 0;
        int j7 = 0;
        if(scy[2] != scy[0])
        {
            if(scy[2] < scy[0])
            {
                i = -1;
            } else
            {
                i = 1;
            }
            double d2 = Math.sqrt((af1[0] - af1[2]) * (af1[0] - af1[2]) + (af2[0] - af2[2]) * (af2[0] - af2[2]) + (af[0] - af[2]) * (af[0] - af[2])) / (double)(Math.abs(conto.keyz[0]) + Math.abs(conto.keyz[2]));
            if(d2 >= 0.99980000000000002D)
            {
                k5 = i;
            } else
            {
                k5 = (int)((Math.acos(d2) / 0.017453292519943295D) * (double)i);
            }
        }
        if(scy[3] != scy[1])
        {
            if(scy[3] < scy[1])
            {
                i = -1;
            } else
            {
                i = 1;
            }
            double d3 = Math.sqrt((af1[1] - af1[3]) * (af1[1] - af1[3]) + (af2[1] - af2[3]) * (af2[1] - af2[3]) + (af[1] - af[3]) * (af[1] - af[3])) / (double)(Math.abs(conto.keyz[1]) + Math.abs(conto.keyz[3]));
            if(d3 >= 0.99980000000000002D)
            {
                i6 = i;
            } else
            {
                i6 = (int)((Math.acos(d3) / 0.017453292519943295D) * (double)i);
            }
        }
        if(scy[1] != scy[0])
        {
            if(scy[1] < scy[0])
            {
                i = -1;
            } else
            {
                i = 1;
            }
            double d4 = Math.sqrt((af1[0] - af1[1]) * (af1[0] - af1[1]) + (af2[0] - af2[1]) * (af2[0] - af2[1]) + (af[0] - af[1]) * (af[0] - af[1])) / (double)(Math.abs(conto.keyx[0]) + Math.abs(conto.keyx[1]));
            if(d4 >= 0.99980000000000002D)
            {
                k6 = i;
            } else
            {
                k6 = (int)((Math.acos(d4) / 0.017453292519943295D) * (double)i);
            }
        }
        if(scy[3] != scy[2])
        {
            if(scy[3] < scy[2])
            {
                i = -1;
            } else
            {
                i = 1;
            }
            double d5 = Math.sqrt((af1[2] - af1[3]) * (af1[2] - af1[3]) + (af2[2] - af2[3]) * (af2[2] - af2[3]) + (af[2] - af[3]) * (af[2] - af[3])) / (double)(Math.abs(conto.keyx[2]) + Math.abs(conto.keyx[3]));
            if(d5 >= 0.99980000000000002D)
            {
                j7 = i;
            } else
            {
                j7 = (int)((Math.acos(d5) / 0.017453292519943295D) * (double)i);
            }
        }
        if(flag2)
        {
            int j8;
            for(j8 = Math.abs(conto.xz + 45); j8 > 180; j8 -= 360) { }
            if(Math.abs(j8) > 90)
            {
                pmlt = 1;
            } else
            {
                pmlt = -1;
            }
            for(j8 = Math.abs(conto.xz - 45); j8 > 180; j8 -= 360) { }
            if(Math.abs(j8) > 90)
            {
                nmlt = 1;
            } else
            {
                nmlt = -1;
            }
        }
        conto.xz += forca * (((((scz[0] * (float)nmlt - scz[1] * (float)pmlt) + scz[2] * (float)pmlt) - scz[3] * (float)nmlt) + scx[0] * (float)pmlt + scx[1] * (float)nmlt) - scx[2] * (float)nmlt - scx[3] * (float)pmlt);
        if(Math.abs(i6) > Math.abs(k5))
        {
            k5 = i6;
        }
        if(Math.abs(j7) > Math.abs(k6))
        {
            k6 = j7;
        }
        if(!flag)
        {
            pzy += k5;
        } else
        {
            pzy -= k5;
        }
        if(!flag3)
        {
            pxy += k6;
        } else
        {
            pxy -= k6;
        }
        if(i4 == 4)
        {
            int k8 = 0;
            while(pzy < 360) 
            {
                pzy += 360;
                conto.zy += 360;
            }
            while(pzy > 360) 
            {
                pzy -= 360;
                conto.zy -= 360;
            }
            if(pzy < 190 && pzy > 170)
            {
                pzy = 180;
                conto.zy = 180;
                k8++;
            }
            if(pzy > 350 || pzy < 10)
            {
                pzy = 0;
                conto.zy = 0;
                k8++;
            }
            while(pxy < 360) 
            {
                pxy += 360;
                conto.xy += 360;
            }
            while(pxy > 360) 
            {
                pxy -= 360;
                conto.xy -= 360;
            }
            if(pxy < 190 && pxy > 170)
            {
                pxy = 180;
                conto.xy = 180;
                k8++;
            }
            if(pxy > 350 || pxy < 10)
            {
                pxy = 0;
                conto.xy = 0;
                k8++;
            }
            if(k8 == 2)
            {
                mtouch = true;
            }
        }
        if(!mtouch && wtouch)
        {
            if(cntouch == 10)
            {
                mtouch = true;
            } else
            {
                cntouch++;
            }
        } else
        {
            cntouch = 0;
        }
        conto.y = (int)(((af2[0] + af2[1] + af2[2] + af2[3]) / 4F - (float)i1 * m.cos(pzy) * m.cos(pxy)) + f2);
        if(flag)
        {
            i = -1;
        } else
        {
            i = 1;
        }
        conto.x = (int)(((((((((((af[0] - (float)conto.keyx[0] * m.cos(conto.xz)) + (float)(i * conto.keyz[0]) * m.sin(conto.xz) + af[1]) - (float)conto.keyx[1] * m.cos(conto.xz)) + (float)(i * conto.keyz[1]) * m.sin(conto.xz) + af[2]) - (float)conto.keyx[2] * m.cos(conto.xz)) + (float)(i * conto.keyz[2]) * m.sin(conto.xz) + af[3]) - (float)conto.keyx[3] * m.cos(conto.xz)) + (float)(i * conto.keyz[3]) * m.sin(conto.xz)) / 4F + (float)i1 * m.sin(pxy) * m.cos(conto.xz)) - (float)i1 * m.sin(pzy) * m.sin(conto.xz)) + f);
        conto.z = (int)((((((((((af1[0] - (float)(i * conto.keyz[0]) * m.cos(conto.xz) - (float)conto.keyx[0] * m.sin(conto.xz)) + af1[1]) - (float)(i * conto.keyz[1]) * m.cos(conto.xz) - (float)conto.keyx[1] * m.sin(conto.xz)) + af1[2]) - (float)(i * conto.keyz[2]) * m.cos(conto.xz) - (float)conto.keyx[2] * m.sin(conto.xz)) + af1[3]) - (float)(i * conto.keyz[3]) * m.cos(conto.xz) - (float)conto.keyx[3] * m.sin(conto.xz)) / 4F + (float)i1 * m.sin(pxy) * m.sin(conto.xz)) - (float)i1 * m.sin(pzy) * m.cos(conto.xz)) + f1);
        if(Math.abs(speed) > 10F || !mtouch)
        {
            if(Math.abs(pxy - conto.xy) >= 4)
            {
                if(pxy > conto.xy)
                {
                    conto.xy += 2 + (pxy - conto.xy) / 2;
                } else
                {
                    conto.xy -= 2 + (conto.xy - pxy) / 2;
                }
            } else
            {
                conto.xy = pxy;
            }
            if(Math.abs(pzy - conto.zy) >= 4)
            {
                if(pzy > conto.zy)
                {
                    conto.zy += 2 + (pzy - conto.zy) / 2;
                } else
                {
                    conto.zy -= 2 + (conto.zy - pzy) / 2;
                }
            } else
            {
                conto.zy = pzy;
            }
        }
        if(wtouch && !capsized)
        {
            float f18 = (float)((double)((speed / (float)swits[cn][2]) * 14F) * ((double)bounce[cn] - 0.40000000000000002D));
            if(control.left && tilt < f18 && tilt >= 0.0F)
            {
                tilt += 0.40000000000000002D;
            } else
            if(control.right && tilt > -f18 && tilt <= 0.0F)
            {
                tilt -= 0.40000000000000002D;
            } else
            if((double)Math.abs(tilt) > 3D * ((double)bounce[cn] - 0.40000000000000002D))
            {
                if(tilt > 0.0F)
                {
                    tilt -= 3D * ((double)bounce[cn] - 0.29999999999999999D);
                } else
                {
                    tilt += 3D * ((double)bounce[cn] - 0.29999999999999999D);
                }
            } else
            {
                tilt = 0.0F;
            }
            conto.xy += tilt;
            if(gtouch)
            {
                conto.y -= (double)tilt / 1.5D;
            }
        } else
        if(tilt != 0.0F)
        {
            tilt = 0.0F;
        }
        if(wtouch && k3 == 2)
        {
            conto.zy += (int)((double)((m.random() * 6F * speed) / (float)swits[cn][2] - (3F * speed) / (float)swits[cn][2]) * ((double)bounce[cn] - 0.29999999999999999D));
            conto.xy += (int)((double)((m.random() * 6F * speed) / (float)swits[cn][2] - (3F * speed) / (float)swits[cn][2]) * ((double)bounce[cn] - 0.29999999999999999D));
        }
        if(wtouch && k3 == 1)
        {
            conto.zy += (int)((double)((m.random() * 4F * speed) / (float)swits[cn][2] - (2.0F * speed) / (float)swits[cn][2]) * ((double)bounce[cn] - 0.29999999999999999D));
            conto.xy += (int)((double)((m.random() * 4F * speed) / (float)swits[cn][2] - (2.0F * speed) / (float)swits[cn][2]) * ((double)bounce[cn] - 0.29999999999999999D));
        }
        if(hitmag > maxmag[cn] && !dest)
        {
            distruct(conto);
            if(cntdest == 7)
            {
                dest = true;
            } else
            {
                cntdest++;
            }
            if(cntdest == 1)
            {
                rpd.dest[im] = 300;
            }
        }
        if(conto.dist == 0)
        {
            for(int l8 = 0; l8 < conto.npl; l8++)
            {
                if(conto.p[l8].chip != 0)
                {
                    conto.p[l8].chip = 0;
                }
                if(conto.p[l8].embos != 0)
                {
                    conto.p[l8].embos = 13;
                }
            }

        }
        int i9 = 0;
        int j9 = 0;
        int k9 = 0;
        if(nofocus)
        {
            j = 1;
        } else
        {
            j = 7;
        }
        for(int i10 = 0; i10 < checkpoints.n; i10++)
        {
            if(checkpoints.typ[i10] > 0)
            {
                k9++;
                if(checkpoints.typ[i10] == 1)
                {
                    if(clear == k9 + nlaps * checkpoints.nsp)
                    {
                        j = 1;
                    }
                    if((float)Math.abs(conto.z - checkpoints.z[i10]) < 60F + Math.abs(scz[0] + scz[1] + scz[2] + scz[3]) / 4F && Math.abs(conto.x - checkpoints.x[i10]) < 700 && Math.abs(conto.y - checkpoints.y[i10]) < 800 && clear == (k9 + nlaps * checkpoints.nsp) - 1)
                    {
                        clear = k9 + nlaps * checkpoints.nsp;
                        pcleared = i10;
                        focus = -1;
                    }
                }
                if(checkpoints.typ[i10] == 2)
                {
                    if(clear == k9 + nlaps * checkpoints.nsp)
                    {
                        j = 1;
                    }
                    if((float)Math.abs(conto.x - checkpoints.x[i10]) < 60F + Math.abs(scx[0] + scx[1] + scx[2] + scx[3]) / 4F && Math.abs(conto.z - checkpoints.z[i10]) < 700 && Math.abs(conto.y - checkpoints.y[i10]) < 800 && clear == (k9 + nlaps * checkpoints.nsp) - 1)
                    {
                        clear = k9 + nlaps * checkpoints.nsp;
                        pcleared = i10;
                        focus = -1;
                    }
                }
            }
            if(py(conto.x / 100, checkpoints.x[i10] / 100, conto.z / 100, checkpoints.z[i10] / 100) * j < j9 || j9 == 0)
            {
                i9 = i10;
                j9 = py(conto.x / 100, checkpoints.x[i10] / 100, conto.z / 100, checkpoints.z[i10] / 100) * j;
            }
        }

        if(clear == k9 + nlaps * checkpoints.nsp)
        {
            nlaps++;
        }
        if(focus == -1)
        {
            if(im == 0)
            {
                i9 += 2;
            } else
            {
                i9++;
            }
            if(!nofocus)
            {
                int l9 = pcleared + 1;
                do
                {
                    if(checkpoints.typ[l9] > 0)
                    {
                        break;
                    }
                    if(++l9 == checkpoints.n)
                    {
                        l9 = 0;
                    }
                } while(true);
                if(i9 > l9 && (clear != nlaps * checkpoints.nsp || i9 < pcleared))
                {
                    i9 = l9;
                    focus = i9;
                }
            }
            if(i9 >= checkpoints.n)
            {
                i9 -= checkpoints.n;
            }
            if(checkpoints.typ[i9] == -3)
            {
                i9 = 0;
            }
            if(im == 0)
            {
                if(missedcp != -1)
                {
                    missedcp = -1;
                }
            } else
            if(missedcp != 0)
            {
                missedcp = 0;
            }
        } else
        {
            i9 = focus;
            if(im == 0)
            {
                if(missedcp == 0 && mtouch && Math.sqrt(py(conto.x / 10, checkpoints.x[focus] / 10, conto.z / 10, checkpoints.z[focus] / 10)) > 800D)
                {
                    missedcp = 1;
                }
                if(missedcp == -2 && Math.sqrt(py(conto.x / 10, checkpoints.x[focus] / 10, conto.z / 10, checkpoints.z[focus] / 10)) < 400D)
                {
                    missedcp = 0;
                }
                if(missedcp != 0 && mtouch && Math.sqrt(py(conto.x / 10, checkpoints.x[focus] / 10, conto.z / 10, checkpoints.z[focus] / 10)) < 250D)
                {
                    missedcp = 68;
                }
            } else
            {
                missedcp = 1;
            }
            if(nofocus)
            {
                focus = -1;
                missedcp = 0;
            }
        }
        if(nofocus)
        {
            nofocus = false;
        }
        point = i9;
        for(int j10 = 0; j10 < checkpoints.fn; j10++)
        {
            if(!checkpoints.roted[j10])
            {
                if(Math.abs(conto.z - checkpoints.fz[j10]) >= 200 || py(conto.x / 100, checkpoints.fx[j10] / 100, conto.y / 100, checkpoints.fy[j10] / 100) >= 30)
                {
                    continue;
                }
                if(conto.dist == 0)
                {
                    conto.fcnt = 8;
                } else
                {
                    if(im == 0 && !conto.fix && !xt.mutes)
                    {
                        xt.carfixed.setFramePosition(0);
                        xt.carfixed.start();
                    }
                    conto.fix = true;
                }
                rpd.fix[im] = 300;
                continue;
            }
            if(Math.abs(conto.x - checkpoints.fx[j10]) >= 200 || py(conto.z / 100, checkpoints.fz[j10] / 100, conto.y / 100, checkpoints.fy[j10] / 100) >= 30)
            {
                continue;
            }
            if(conto.dist == 0)
            {
                conto.fcnt = 8;
            } else
            {
                if(im == 0 && !conto.fix && !xt.mutes)
                {
                    xt.carfixed.setFramePosition(0);
                    xt.carfixed.start();
                }
                conto.fix = true;
            }
            rpd.fix[im] = 300;
        }

        if(conto.fcnt == 7 || conto.fcnt == 8)
        {
            squash = 0;
            nbsq = 0;
            hitmag = 0;
            cntdest = 0;
            dest = false;
            newcar = true;
        }
        if(!mtouch)
        {
            if(trcnt != 1)
            {
                trcnt = 1;
                lxz = conto.xz;
            }
            if(loop == 2 || loop == -1)
            {
                travxy += rcomp - lcomp;
                if(Math.abs(travxy) > 135)
                {
                    rtab = true;
                }
                travzy += ucomp - dcomp;
                if(travzy > 135)
                {
                    ftab = true;
                }
                if(travzy < -135)
                {
                    btab = true;
                }
            }
            if(lxz != conto.xz)
            {
                travxz += lxz - conto.xz;
                lxz = conto.xz;
            }
            if(srfcnt < 10)
            {
                if(control.wall != -1)
                {
                    surfer = true;
                }
                srfcnt++;
            }
        } else
        if(!dest)
        {
            if(!capsized)
            {
                if(capcnt != 0)
                {
                    capcnt = 0;
                }
                if(gtouch && trcnt != 0)
                {
                    if(trcnt == 9)
                    {
                        powerup = 0.0F;
                        if(Math.abs(travxy) > 90)
                        {
                            powerup += (float)Math.abs(travxy) / 24F;
                        } else
                        if(rtab)
                        {
                            powerup += 30F;
                        }
                        if(Math.abs(travzy) > 90)
                        {
                            powerup += (float)Math.abs(travzy) / 18F;
                        } else
                        {
                            if(ftab)
                            {
                                powerup += 40F;
                            }
                            if(btab)
                            {
                                powerup += 40F;
                            }
                        }
                        if(Math.abs(travxz) > 90)
                        {
                            powerup += (float)Math.abs(travxz) / 18F;
                        }
                        if(surfer)
                        {
                            powerup += 30F;
                        }
                        power += powerup;
                        if(im == 0 && (int)powerup > rpd.powered && rpd.wasted == 0 && powerup > 60F)
                        {
                            rpd.cotchinow(0);
                            if(rpd.hcaught)
                            {
                                rpd.whenwasted = 225;
                                rpd.powered = (int)powerup;
                            }
                        }
                        if(power > 98F)
                        {
                            power = 98F;
                            if(powerup > 150F)
                            {
                                xtpower = 200;
                            } else
                            {
                                xtpower = 100;
                            }
                        }
                    }
                    if(trcnt == 10)
                    {
                        travxy = 0;
                        travzy = 0;
                        travxz = 0;
                        ftab = false;
                        rtab = false;
                        btab = false;
                        trcnt = 0;
                        srfcnt = 0;
                        surfer = false;
                    } else
                    {
                        trcnt++;
                    }
                }
            } else
            {
                if(trcnt != 0)
                {
                    travxy = 0;
                    travzy = 0;
                    travxz = 0;
                    ftab = false;
                    rtab = false;
                    btab = false;
                    trcnt = 0;
                    srfcnt = 0;
                    surfer = false;
                }
                if(capcnt == 0)
                {
                    int k10 = 0;
                    int l10 = 0;
                    do
                    {
                        if(Math.abs(scz[l10]) < 70F && Math.abs(scx[l10]) < 70F)
                        {
                            k10++;
                        }
                    } while(++l10 < 4);
                    if(k10 == 4)
                    {
                        capcnt = 1;
                    }
                } else
                {
                    capcnt++;
                    if(capcnt == 30)
                    {
                        speed = 0.0F;
                        conto.y += flipy[cn];
                        pxy += 180;
                        conto.xy += 180;
                        capcnt = 0;
                    }
                }
            }
            if(trcnt == 0)
            {
                if(xtpower == 0)
                {
                    if(power > 0.0F)
                    {
                        power -= (power * power * power) / (float)powerloss[cn];
                    } else
                    {
                        power = 0.0F;
                    }
                } else
                {
                    xtpower--;
                }
            }
        }
        if(im == 0)
        {
            if(control.wall != -1)
            {
                control.wall = -1;
            }
        } else
        if(lastcolido != 0 && !dest)
        {
            lastcolido--;
        }
        if(dest)
        {
            if(checkpoints.dested[im] == 0)
            {
                if(lastcolido == 0)
                {
                    checkpoints.dested[im] = 1;
                } else
                {
                    checkpoints.dested[im] = 2;
                }
            }
        } else
        if(checkpoints.dested[im] != 0)
        {
            checkpoints.dested[im] = 0;
        }
    }
}
