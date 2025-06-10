import java.awt.Graphics;
import java.io.*;

public class ContO
{

    Medium m;
    Plane p[];
    int npl;
    int x;
    int y;
    int z;
    int xz;
    int xy;
    int zy;
    int dist;
    int maxR;
    int disp;
    boolean shadow;
    boolean loom;
    int grounded;
    boolean colides;
    int rcol;
    int pcol;
    boolean out;
    boolean fire;
    boolean hit;
    int nhits;
    int maxhits;
    boolean wire;
    boolean exp;

    public int ys(int i, int j)
    {
        if(j < 10)
        {
            j = 10;
        }
        return ((j - m.focus_point) * (m.cy - i)) / j + i;
    }

    public void reset()
    {
        exp = false;
        nhits = 0;
        xz = 0;
        xy = 0;
        zy = 0;
    }

    public ContO(byte abyte0[], Medium medium, int i, int j, int k)
    {
        npl = 0;
        x = 0;
        y = 0;
        z = 0;
        xz = 0;
        xy = 0;
        zy = 0;
        dist = 0;
        maxR = 0;
        disp = 0;
        shadow = false;
        loom = false;
        grounded = 1;
        colides = false;
        rcol = 0;
        pcol = 0;
        out = false;
        fire = false;
        hit = false;
        nhits = 0;
        maxhits = -1;
        wire = false;
        exp = false;
        m = medium;
        p = new Plane[100];
        x = i;
        y = j;
        z = k;
        boolean flag = false;
        int l = 0;
        float f = 1.0F;
        int ai[] = new int[100];
        int ai1[] = new int[100];
        int ai2[] = new int[100];
        int ai3[] = {
            50, 50, 50
        };
        try
        {
            DataInputStream datainputstream = new DataInputStream(new ByteArrayInputStream(abyte0));
            String s;
            while((s = datainputstream.readLine()) != null) 
            {
                String s1 = "" + s.trim();
                if(s1.startsWith("<p>"))
                {
                    flag = true;
                    l = 0;
                }
                if(flag)
                {
                    if(s1.startsWith("c"))
                    {
                        ai3[0] = getvalue("c", s1, 0);
                        ai3[1] = getvalue("c", s1, 1);
                        ai3[2] = getvalue("c", s1, 2);
                    }
                    if(s1.startsWith("p"))
                    {
                        ai[l] = (int)((float)getvalue("p", s1, 0) * f);
                        ai1[l] = (int)((float)getvalue("p", s1, 1) * f);
                        ai2[l] = (int)((float)getvalue("p", s1, 2) * f);
                        l++;
                    }
                }
                if(s1.startsWith("</p>"))
                {
                    p[npl] = new Plane(m, ai, ai2, ai1, l, ai3);
                    npl++;
                    flag = false;
                }
                if(s1.startsWith("MaxRadius"))
                {
                    maxR = getvalue("MaxRadius", s1, 0);
                }
                if(s1.startsWith("disp"))
                {
                    disp = getvalue("disp", s1, 0);
                }
                if(s1.startsWith("shadow"))
                {
                    shadow = true;
                }
                if(s1.startsWith("loom"))
                {
                    loom = true;
                }
                if(s1.startsWith("out"))
                {
                    out = true;
                }
                if(s1.startsWith("hits"))
                {
                    maxhits = getvalue("hits", s1, 0);
                }
                if(s1.startsWith("colid"))
                {
                    colides = true;
                    rcol = getvalue("colid", s1, 0);
                    pcol = getvalue("colid", s1, 1);
                }
                if(s1.startsWith("grounded"))
                {
                    grounded = getvalue("grounded", s1, 0);
                }
                if(s1.startsWith("div"))
                {
                    f = (float)getvalue("div", s1, 0) / 10F;
                }
            }
            datainputstream.close();
        }
        catch(Exception _ex) { }
    }

    public ContO(Medium medium, ContO conto, int i, int j, int k)
    {
        npl = 0;
        x = 0;
        y = 0;
        z = 0;
        xz = 0;
        xy = 0;
        zy = 0;
        dist = 0;
        maxR = 0;
        disp = 0;
        shadow = false;
        loom = false;
        grounded = 1;
        colides = false;
        rcol = 0;
        pcol = 0;
        out = false;
        fire = false;
        hit = false;
        nhits = 0;
        maxhits = -1;
        wire = false;
        exp = false;
        m = medium;
        npl = conto.npl;
        maxR = conto.maxR;
        disp = conto.disp;
        loom = conto.loom;
        colides = conto.colides;
        maxhits = conto.maxhits;
        out = conto.out;
        rcol = conto.rcol;
        pcol = conto.pcol;
        shadow = conto.shadow;
        grounded = conto.grounded;
        p = new Plane[conto.npl];
        x = i;
        y = j;
        z = k;
        for(int l = 0; l < npl; l++)
        {
            p[l] = new Plane(m, conto.p[l].ox, conto.p[l].oz, conto.p[l].oy, conto.p[l].n, conto.p[l].c);
        }

    }

    public void d(Graphics g)
    {
        if(dist != 0)
        {
            dist = 0;
        }
        int i = 0;
        for(int j = 0; j < npl; j++)
        {
            if(!exp)
            {
                if(p[j].exp != 0)
                {
                    p[j].exp = 0;
                }
            } else
            if(p[j].exp == 0)
            {
                p[j].exp = 1;
            } else
            if(p[j].exp == 7)
            {
                i++;
            }
        }

        if(!out && i != npl)
        {
            if(fire)
            {
                dist = 1;
            }
            int k = m.cx + (int)((float)(x - m.x - m.cx) * m.cs.getcos(m.xz) - (float)(z - m.z - m.cz) * m.cs.getsin(m.xz));
            int l = m.cz + (int)((float)(x - m.x - m.cx) * m.cs.getsin(m.xz) + (float)(z - m.z - m.cz) * m.cs.getcos(m.xz));
            int i1 = m.cz + (int)((float)(y - m.y - m.cy) * m.cs.getsin(m.zy) + (float)(l - m.cz) * m.cs.getcos(m.zy));
            if(xs(k + maxR, i1) > 0 && xs(k - maxR, i1) < m.w && i1 > -maxR && i1 < 50000 && xs(k + maxR, i1) - xs(k - maxR, i1) > disp || exp)
            {
                if(shadow || exp)
                {
                    int j1 = m.cy + (int)((float)(m.ground - m.cy) * m.cs.getcos(m.zy) - (float)(l - m.cz) * m.cs.getsin(m.zy));
                    int l1 = m.cz + (int)((float)(m.ground - m.cy) * m.cs.getsin(m.zy) + (float)(l - m.cz) * m.cs.getcos(m.zy));
                    if(ys(j1 + maxR, l1) > 0 && ys(j1 - maxR, l1) < m.h || exp)
                    {
                        for(int i2 = 0; i2 < npl; i2++)
                        {
                            p[i2].s(g, x - m.x, y - m.y, z - m.z, xz, xy, zy, loom);
                        }

                    }
                }
                int k1 = m.cy + (int)((float)(y - m.y - m.cy) * m.cs.getcos(m.zy) - (float)(l - m.cz) * m.cs.getsin(m.zy));
                if(ys(k1 + maxR, i1) > 0 && ys(k1 - maxR, i1) < m.h || exp)
                {
                    if(m.jumping != 0 && m.jumping < 4)
                    {
                        hit = true;
                    }
                    int ai[] = new int[npl];
                    for(int j2 = 0; j2 < npl; j2++)
                    {
                        ai[j2] = 0;
                        for(int l2 = 0; l2 < npl; l2++)
                        {
                            if(p[j2].av != p[l2].av)
                            {
                                if(p[j2].av < p[l2].av)
                                {
                                    ai[j2]++;
                                }
                            } else
                            if(j2 > l2)
                            {
                                ai[j2]++;
                            }
                        }

                    }

                    for(int k2 = 0; k2 < npl; k2++)
                    {
                        for(int i3 = 0; i3 < npl; i3++)
                        {
                            if(ai[i3] == k2)
                            {
                                p[i3].d(g, x - m.x, y - m.y, z - m.z, xz, xy, zy, hit, wire, loom);
                            }
                        }

                    }

                    dist = (int)Math.sqrt((int)Math.sqrt(((m.x + m.cx) - x) * ((m.x + m.cx) - x) + (m.z - z) * (m.z - z) + ((m.y + m.cy) - y) * ((m.y + m.cy) - y))) * grounded;
                }
            }
        }
        if(hit)
        {
            hit = false;
            if(m.jumping == 0 && nhits > maxhits)
            {
                exp = true;
            }
        }
    }

    public void tryexp(ContO conto)
    {
        if(!conto.exp && !out && !exp)
        {
            int i = getpy(conto.x, conto.y, conto.z);
            if(i < (maxR / 10) * (maxR / 10) + (conto.maxR / 10) * (conto.maxR / 10) && i > 0)
            {
                if(pcol != 0)
                {
                    for(int j = 0; j < npl; j++)
                    {
                        for(int k = 0; k < p[j].n; k++)
                        {
                            if((conto.x - (x + p[j].ox[k])) * (conto.x - (x + p[j].ox[k])) + (conto.y - (y + p[j].oy[k])) * (conto.y - (y + p[j].oy[k])) + (conto.z - (z + p[j].oz[k])) * (conto.z - (z + p[j].oz[k])) >= ((conto.maxR * 10) / pcol) * ((conto.maxR * 10) / pcol))
                            {
                                continue;
                            }
                            conto.exp = true;
                            break;
                        }

                    }

                }
                if(rcol != 0 && i < (maxR / (10 * rcol)) * (maxR / (10 * rcol)) + (conto.maxR / 10) * (conto.maxR / 10))
                {
                    conto.exp = true;
                }
            }
        }
    }

    public int getpy(int i, int j, int k)
    {
        return ((i - x) / 10) * ((i - x) / 10) + ((j - y) / 10) * ((j - y) / 10) + ((k - z) / 10) * ((k - z) / 10);
    }

    public void loadrots(boolean flag)
    {
        if(!flag)
        {
            reset();
        }
        for(int i = 0; i < npl; i++)
        {
            p[i].rot(p[i].ox, p[i].oy, 0, 0, xy, p[i].n);
            p[i].rot(p[i].oy, p[i].oz, 0, 0, zy, p[i].n);
            p[i].rot(p[i].ox, p[i].oz, 0, 0, xz, p[i].n);
            p[i].loadprojf();
        }

        if(flag)
        {
            reset();
        }
    }

    public int getvalue(String s, String s1, int i)
    {
        int k = 0;
        String s3 = "";
        for(int j = s.length() + 1; j < s1.length(); j++)
        {
            String s2 = "" + s1.charAt(j);
            if(s2.equals(",") || s2.equals(")"))
            {
                k++;
                j++;
            }
            if(k == i)
            {
                s3 += s1.charAt(j);
            }
        }

        return Integer.valueOf(s3).intValue();
    }

    public int xs(int i, int j)
    {
        if(j < 10)
        {
            j = 10;
        }
        return ((j - m.focus_point) * (m.cx - i)) / j + i;
    }
}
