import java.awt.Color;
import java.awt.Graphics;

public class Plane
{

    Medium m;
    int ox[];
    int oy[];
    int oz[];
    int n;
    int c[];
    float deltaf;
    float projf;
    int av;
    int exp;
    int ofx;
    int adx;
    int ofy;
    int adz;
    int ofz;
    double ady;
    int ofcx;
    int ofcy;
    int ofcz;
    int nx;
    int ny;
    int nz;
    int ezy;
    int exy;
    int azy;
    int axy;
    int sx[];
    int sy[];
    int sz[];
    int sdx;
    int sdz;
    double sdy;
    int sr;
    int sg;

    public void loadprojf()
    {
        projf = 1.0F;
        int i = 0;
        do
        {
            int j = 0;
            do
            {
                if(j != i)
                {
                    projf *= (float)(Math.sqrt((ox[i] - ox[j]) * (ox[i] - ox[j]) + (oz[i] - oz[j]) * (oz[i] - oz[j])) / 100D);
                }
            } while(++j < 3);
        } while(++i < 3);
        projf = projf / 3F;
    }

    public int ys(int i, int j)
    {
        if(j < 10)
        {
            j = 10;
        }
        return ((j - m.focus_point) * (m.cy - i)) / j + i;
    }

    public Plane(Medium medium, int ai[], int ai1[], int ai2[], int i, int ai3[])
    {
        c = new int[3];
        deltaf = 1.0F;
        projf = 1.0F;
        av = 0;
        exp = 0;
        ofx = 0;
        adx = 0;
        ofy = 0;
        adz = 0;
        ofz = 0;
        ady = 0.0D;
        ofcx = 0;
        ofcy = 0;
        ofcz = 0;
        nx = 0;
        ny = 0;
        nz = 0;
        ezy = 0;
        exy = 0;
        azy = 0;
        axy = 0;
        sx = new int[4];
        sy = new int[4];
        sz = new int[4];
        sdx = 0;
        sdz = 0;
        sdy = 0.0D;
        sr = 255;
        sg = 220;
        m = medium;
        n = i;
        ox = new int[n];
        oz = new int[n];
        oy = new int[n];
        for(int j = 0; j < n; j++)
        {
            ox[j] = ai[j];
            oy[j] = ai2[j];
            oz[j] = ai1[j];
        }

        int k = 0;
        do
        {
            c[k] = ai3[k];
        } while(++k < 3);
        k = 0;
        do
        {
            int l = 0;
            do
            {
                if(l != k)
                {
                    deltaf *= (float)(Math.sqrt((ox[l] - ox[k]) * (ox[l] - ox[k]) + (oy[l] - oy[k]) * (oy[l] - oy[k]) + (oz[l] - oz[k]) * (oz[l] - oz[k])) / 100D);
                }
            } while(++l < 3);
        } while(++k < 3);
        deltaf = deltaf / 3F;
    }

    public void d(Graphics g, int i, int j, int k, int l, int i1, int j1, 
            boolean flag, boolean flag1, boolean flag2)
    {
        if(exp != 7)
        {
            int ai[] = new int[n];
            int ai1[] = new int[n];
            int ai2[] = new int[n];
            for(int k1 = 0; k1 < n; k1++)
            {
                ai[k1] = ox[k1] + i;
                ai2[k1] = oy[k1] + j;
                ai1[k1] = oz[k1] + k;
            }

            rot(ai, ai2, i, j, i1, n);
            rot(ai2, ai1, j, k, j1, n);
            rot(ai, ai1, i, k, l, n);
            if(exp == 2)
            {
                sdx = (int)(Math.random() * 100D - 50D);
                sdz = (int)(Math.random() * 100D - 50D);
                sdy = Math.random() * 100D - 50D;
                sx[0] = (ofcx + ai[nx] + 2) - i;
                sx[1] = (ofcx + ai[nx]) - 2 - i;
                sy[0] = (ofcy + ai2[ny] + 2) - j;
                sy[1] = (ofcy + ai2[ny]) - 2 - j;
                sz[0] = (ofcz + ai1[nx] + 2) - k;
                sz[1] = (ofcz + ai1[nx]) - 2 - k;
                sx[2] = sx[1] - sdx;
                sx[3] = sx[0] - sdx;
                sy[2] = (int)((double)sy[1] - sdy);
                sy[3] = (int)((double)sy[0] - sdy);
                sz[2] = sz[1] - sdz;
                sz[3] = sz[0] - sdz;
                sr = 255;
                sg = 220;
                exp = 3;
            }
            if(exp != 0)
            {
                ofx += adx;
                ofz += adz;
                ofy += (int)ady;
                for(int l1 = 0; l1 < n; l1++)
                {
                    ai[l1] += ofx;
                    ai1[l1] += ofz;
                    ai2[l1] += ofy;
                }

                rot(ai2, ai1, ofcy + ai2[ny], ofcz + ai1[nx], ezy, n);
                rot(ai, ai2, ofcx + ai[nx], ofcy + ai2[ny], exy, n);
                for(int i2 = 0; i2 < n; i2++)
                {
                    if(ai2[i2] > m.ground)
                    {
                        exp = 7;
                    }
                }

                ezy += azy;
                exy += axy;
                ady += 0.5D;
                if(sy[3] < m.ground)
                {
                    int ai3[] = new int[4];
                    int ai4[] = new int[4];
                    int ai6[] = new int[4];
                    int l2 = 0;
                    do
                    {
                        if(exp < 6)
                        {
                            ai3[l2] = sx[l2] + i + (int)(Math.random() * 50D - 25D);
                            ai4[l2] = sy[l2] + j + (int)(Math.random() * 50D - 25D);
                            ai6[l2] = sz[l2] + k + (int)(Math.random() * 50D - 25D);
                            if(exp >= 4)
                            {
                                exp++;
                            }
                        } else
                        {
                            ai3[l2] = sx[l2] + i;
                            ai4[l2] = sy[l2] + j;
                            ai6[l2] = sz[l2] + k;
                        }
                        sx[l2] += sdx;
                        sy[l2] += sdy;
                        sz[l2] += sdz;
                    } while(++l2 < 4);
                    sdy += 0.5D;
                    rot(ai3, ai6, m.cx, m.cz, m.xz, 4);
                    rot(ai4, ai6, m.cy, m.cz, m.zy, 4);
                    int ai8[] = new int[4];
                    int ai9[] = new int[4];
                    boolean flag4 = false;
                    int i4 = 0;
                    do
                    {
                        ai8[i4] = xs(ai3[i4], ai6[i4]);
                        ai9[i4] = ys(ai4[i4], ai6[i4]);
                        if(ai9[i4] > 0 && ai9[i4] < m.h && ai8[i4] > 0 && ai8[i4] < m.w && ai6[i4] > 10 && ai4[i4] < m.ground)
                        {
                            flag4 = true;
                        }
                    } while(++i4 < 4);
                    if(flag4 && sr > 111)
                    {
                        g.setColor(new Color(sr, sg, 111));
                        if(exp == 3)
                        {
                            g.setColor(new Color(255, 255, 255));
                            exp = 4;
                        }
                        g.fillPolygon(ai8, ai9, 4);
                        if(sr > 111)
                        {
                            sr -= 2;
                        }
                        if(sg > 111)
                        {
                            sg -= 2;
                        }
                    }
                }
            }
            if(i1 != 0 || j1 != 0 || exp != 0 || l != 0)
            {
                projf = 1.0F;
                int j2 = 0;
                do
                {
                    int k2 = 0;
                    do
                    {
                        if(k2 != j2)
                        {
                            projf *= (float)(Math.sqrt((ai[j2] - ai[k2]) * (ai[j2] - ai[k2]) + (ai1[j2] - ai1[k2]) * (ai1[j2] - ai1[k2])) / 100D);
                        }
                    } while(++k2 < 3);
                } while(++j2 < 3);
                projf = projf / 3F;
            }
            rot(ai, ai1, m.cx, m.cz, m.xz, n);
            boolean flag3 = false;
            int ai5[] = new int[n];
            int ai7[] = new int[n];
            int i3 = 500;
            for(int j3 = 0; j3 < n; j3++)
            {
                ai5[j3] = xs(ai[j3], ai1[j3]);
                ai7[j3] = ys(ai2[j3], ai1[j3]);
            }

            int k3 = 0;
            int l3 = 1;
            for(int j4 = 0; j4 < n; j4++)
            {
                for(int i5 = 0; i5 < n; i5++)
                {
                    if(j4 != i5 && Math.abs(ai5[j4] - ai5[i5]) - Math.abs(ai7[j4] - ai7[i5]) < i3)
                    {
                        l3 = j4;
                        k3 = i5;
                        i3 = Math.abs(ai5[j4] - ai5[i5]) - Math.abs(ai7[j4] - ai7[i5]);
                    }
                }

            }

            if(ai7[k3] < ai7[l3])
            {
                int k4 = k3;
                k3 = l3;
                l3 = k4;
            }
            if(spy(ai[k3], ai1[k3]) > spy(ai[l3], ai1[l3]))
            {
                flag3 = true;
                int l4 = 0;
                for(int j5 = 0; j5 < n; j5++)
                {
                    if(ai1[j5] < 50 && ai2[j5] > m.cy)
                    {
                        flag3 = false;
                    } else
                    if(ai2[j5] == ai2[0])
                    {
                        l4++;
                    }
                }

                if(l4 == n && ai2[0] > m.cy)
                {
                    flag3 = false;
                }
            }
            rot(ai2, ai1, m.cy, m.cz, m.zy, n);
            boolean flag5 = true;
            boolean flag6 = false;
            int ai10[] = new int[n];
            int ai11[] = new int[n];
            int k5 = 0;
            int l5 = 0;
            int i6 = 0;
            int j6 = 0;
            int k6 = 0;
            for(int l6 = 0; l6 < n; l6++)
            {
                ai10[l6] = xs(ai[l6], ai1[l6]);
                ai11[l6] = ys(ai2[l6], ai1[l6]);
                if(ai11[l6] < 0 || ai1[l6] < 10)
                {
                    k5++;
                }
                if(ai11[l6] > m.h || ai1[l6] < 10)
                {
                    l5++;
                }
                if(ai10[l6] < 0 || ai1[l6] < 10)
                {
                    i6++;
                }
                if(ai10[l6] > m.w || ai1[l6] < 10)
                {
                    j6++;
                }
                if(ai1[l6] > 50000)
                {
                    k6++;
                }
            }

            if(i6 == n || k5 == n || l5 == n || j6 == n || k6 == n)
            {
                flag5 = false;
            }
            if(i6 != 0 || k5 != 0 || l5 != 0 || j6 != 0 || ai1[0] > 2000)
            {
                flag6 = true;
            }
            if(flag5)
            {
                float f = (float)((double)(projf / deltaf) + 0.5D);
                if((double)f > 1.2D)
                {
                    f = 1.2F;
                }
                if(!flag2)
                {
                    if((double)f < 0.5D || flag3)
                    {
                        f = 0.5F;
                    }
                } else
                if((double)f < 0.90000000000000002D || flag3)
                {
                    f = 0.9F;
                }
                int j7;
                int k7;
                int l7;
                if(!flag)
                {
                    if(m.er == 0)
                    {
                        j7 = (int)((float)c[0] * f);
                    } else
                    {
                        j7 = c[0];
                    }
                    if(j7 > 225)
                    {
                        j7 = 225;
                    }
                    if(m.eg == 0)
                    {
                        k7 = (int)((float)c[1] * f);
                    } else
                    {
                        k7 = c[1];
                    }
                    if(k7 > 225)
                    {
                        k7 = 225;
                    }
                    if(m.eb == 0)
                    {
                        l7 = (int)((float)c[2] * f);
                    } else
                    {
                        l7 = c[2];
                    }
                    if(l7 > 225)
                    {
                        l7 = 225;
                    }
                } else
                {
                    j7 = (int)(400F * f);
                    if(j7 > 255)
                    {
                        j7 = 255;
                    }
                    k7 = (int)(400F * f);
                    if(k7 > 255)
                    {
                        k7 = 255;
                    }
                    l7 = (int)(400F * f);
                    if(l7 > 255)
                    {
                        l7 = 255;
                    }
                }
                g.setColor(new Color(j7, k7, l7));
                if(!flag1)
                {
                    g.fillPolygon(ai10, ai11, n);
                }
                if(!flag6)
                {
                    if(!flag1)
                    {
                        if((j7 -= 15) < 0)
                        {
                            j7 = 0;
                        }
                        if((k7 -= 15) < 0)
                        {
                            k7 = 0;
                        }
                        if((l7 -= 15) < 0)
                        {
                            l7 = 0;
                        }
                        g.setColor(new Color(j7, k7, l7));
                    } else
                    {
                        g.setColor(new Color(j7 / 2, (k7 + 255) / 2, l7 / 2));
                    }
                    g.drawPolygon(ai10, ai11, n);
                }
            }
            av = 0;
            for(int i7 = 0; i7 < n; i7++)
            {
                av += (int)Math.sqrt((m.cy - ai11[i7]) * (m.cy - ai11[i7]) + (m.cx - ai10[i7]) * (m.cx - ai10[i7]) + ai1[i7] * ai1[i7]);
            }

            av = av / n;
        }
    }

    public void rot(int ai[], int ai1[], int i, int j, int k, int l)
    {
        if(k != 0)
        {
            for(int i1 = 0; i1 < l; i1++)
            {
                int j1 = ai[i1];
                int k1 = ai1[i1];
                ai[i1] = i + (int)((float)(j1 - i) * m.cs.getcos(k) - (float)(k1 - j) * m.cs.getsin(k));
                ai1[i1] = j + (int)((float)(j1 - i) * m.cs.getsin(k) + (float)(k1 - j) * m.cs.getcos(k));
            }

        }
    }

    public int xs(int i, int j)
    {
        if(j < 10)
        {
            j = 10;
        }
        return ((j - m.focus_point) * (m.cx - i)) / j + i;
    }

    public void s(Graphics g, int i, int j, int k, int l, int i1, int j1, 
            boolean flag)
    {
        if(exp != 7)
        {
            int ai[] = new int[n];
            int ai1[] = new int[n];
            int ai2[] = new int[n];
            for(int k1 = 0; k1 < n; k1++)
            {
                ai[k1] = ox[k1] + i;
                ai2[k1] = oy[k1] + j;
                ai1[k1] = oz[k1] + k;
            }

            rot(ai, ai2, i, j, i1, n);
            rot(ai2, ai1, j, k, j1, n);
            rot(ai, ai1, i, k, l, n);
            if(exp == 1)
            {
                adx = (int)(Math.random() * 30D - 15D);
                adz = (int)(Math.random() * 30D - 15D);
                ady = -(Math.random() * 20D);
                ofcx = (int)(Math.random() * 10D - 5D);
                ofcy = (int)(Math.random() * 10D - 5D);
                ofcz = (int)(Math.random() * 10D - 5D);
                nx = (int)(Math.random() * (double)n);
                ny = (int)(Math.random() * (double)n);
                nz = (int)(Math.random() * (double)n);
                azy = (int)(Math.random() * 30D - 15D);
                axy = (int)(Math.random() * 30D - 15D);
                exy = 0;
                ezy = 0;
                ofx = 0;
                ofy = 0;
                ofz = 0;
                exp = 2;
            }
            if(exp != 0)
            {
                ofx += adx;
                ofz += adz;
                ofy += (int)ady;
                for(int l1 = 0; l1 < n; l1++)
                {
                    ai[l1] += ofx;
                    ai1[l1] += ofz;
                    ai2[l1] += ofy;
                }

                rot(ai2, ai1, ofcy + ai2[ny], ofcz + ai1[nz], ezy, n);
                rot(ai, ai2, ofcx + ai[nx], ofcy + ai2[nx], exy, n);
            }
            int i2 = 0;
            for(int j2 = 0; j2 < n; j2++)
            {
                if(ai2[j2] >= m.ground)
                {
                    i2++;
                } else
                {
                    ai2[j2] = m.ground;
                }
            }

            if(i2 != n)
            {
                rot(ai, ai1, m.cx, m.cz, m.xz, n);
                rot(ai2, ai1, m.cy, m.cz, m.zy, n);
                boolean flag1 = false;
                int ai3[] = new int[n];
                int ai4[] = new int[n];
                for(int k2 = 0; k2 < n; k2++)
                {
                    ai3[k2] = xs(ai[k2], ai1[k2]);
                    ai4[k2] = ys(ai2[k2], ai1[k2]);
                    if(ai4[k2] > 0 && ai4[k2] < m.h && ai3[k2] > 0 && ai3[k2] < m.w && ai1[k2] > 10 && ai1[k2] < 50000)
                    {
                        flag1 = true;
                    }
                }

                if(flag1)
                {
                    if(!flag)
                    {
                        g.setColor(new Color(60, 54, 42));
                    } else
                    {
                        g.setColor(new Color(60, 60, 60));
                    }
                    g.fillPolygon(ai3, ai4, n);
                }
            }
        }
    }

    public int spy(int i, int j)
    {
        return (int)Math.sqrt((i - m.cx) * (i - m.cx) + j * j);
    }
}
