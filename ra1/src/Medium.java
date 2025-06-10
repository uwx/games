import java.awt.Color;
import java.awt.Graphics;

public class Medium
{

    boolean isun;
    SinCos cs;
    int focus_point;
    int ground;
    int er;
    int eg;
    int eb;
    int jumping;
    int cx;
    int cy;
    int cz;
    int xz;
    int zy;
    int x;
    int y;
    int z;
    int w;
    int h;
    int tart;
    int yart;
    int zart;
    int ztgo;
    boolean td;
    int vxz;
    int adv;
    boolean vert;

    public int ys(int i, int j)
    {
        if(j < 10)
        {
            j = 10;
        }
        return ((j - focus_point) * (cy - i)) / j + i;
    }

    public void infront(ContO conto)
    {
        int i = conto.zy;
        int j = conto.xz;
        for(; i > 360; i -= 360) { }
        for(; i < 0; i += 360) { }
        if(i > 90 && i < 270)
        {
            tart += (180 - tart) / 3;
            yart += (100 - yart) / 3;
        } else
        {
            tart -= tart / 3;
            yart += (-100 - yart) / 3;
        }
        j += tart;
        if(i > 90)
        {
            i = 180 - i;
        }
        if(i < -90)
        {
            i = -180 - i;
        }
        int k = conto.y + (int)((float)((conto.y + yart) - conto.y) * cs.getcos(conto.zy) - (float)((conto.z + 800) - conto.z) * cs.getsin(conto.zy));
        int l = conto.z + (int)((float)((conto.y + yart) - conto.y) * cs.getsin(conto.zy) + (float)((conto.z + 800) - conto.z) * cs.getcos(conto.zy));
        int i1 = conto.x + (int)((float)(-(l - conto.z)) * cs.getsin(conto.xz));
        int j1 = conto.z + (int)((float)(l - conto.z) * cs.getcos(conto.xz));
        zy = i;
        xz = -(j + 180);
        x += (i1 - cx - x) / 3;
        z += (double)(j1 - cz - z) / 1.5D;
        y += (double)(k - cy - y) / 1.5D;
    }

    public Medium()
    {
        isun = false;
        cs = new SinCos();
        focus_point = 400;
        ground = 250;
        er = 0;
        eg = 0;
        eb = 0;
        jumping = 0;
        cx = 250;
        cy = 150;
        cz = 50;
        xz = 0;
        zy = 0;
        x = 3000;
        y = -1000;
        z = -2000;
        w = 500;
        h = 360;
        tart = 0;
        yart = -100;
        zart = 0;
        ztgo = 0;
        td = false;
        vxz = 0;
        adv = -500;
        vert = false;
    }

    public void d(Graphics g)
    {
        if(zy > 90)
        {
            zy = 90;
        }
        if(zy < -90)
        {
            zy = -90;
        }
        if(y > 0)
        {
            y = 0;
        }
        ground = 250 - y;
        int i = 0x11170;
        int j = 250;
        if(zy != 0)
        {
            j = cy + (int)((float)(250 - cy) * cs.getcos(zy) - (float)(0x11170 - cz) * cs.getsin(zy));
            i = cz + (int)((float)(250 - cy) * cs.getsin(zy) + (float)(0x11170 - cz) * cs.getcos(zy));
        }
        int ai[] = new int[4];
        int ai1[] = new int[4];
        ai[0] = 0;
        ai1[0] = 0;
        ai[1] = w;
        ai1[1] = 0;
        ai[2] = w;
        ai1[2] = ys(j, i);
        if(ai1[2] > h)
        {
            ai1[2] = h;
        }
        ai[3] = 0;
        ai1[3] = ai1[2];
        if(ai1[2] > 0)
        {
            if(jumping != 0)
            {
                if(jumping == 3)
                {
                    ai1[2] = h;
                    ai1[3] = h;
                    g.setColor(new Color(240, 240, 240));
                    g.fillPolygon(ai, ai1, 4);
                }
            } else
            {
                if(!isun)
                {
                    g.setColor(new Color(159 + 52 * er, 180 + 56 * eg, 189 + 58 * eb));
                } else
                {
                    g.setColor(new Color(159 + 52 * er, 176 + 56 * eg, 191 + 58 * eb));
                }
                g.fillPolygon(ai, ai1, 4);
            }
        }
        ai[0] = -1;
        ai1[0] = ys(j, i);
        if(ai1[0] < 0)
        {
            ai1[0] = -1;
        }
        ai[1] = -1;
        ai1[1] = h;
        ai[2] = w;
        ai1[2] = h;
        ai[3] = w;
        ai1[3] = ai1[0];
        if(ai1[0] < h && jumping == 0)
        {
            if(!isun)
            {
                g.setColor(new Color(177 + 55 * er, 154 + 50 * eg, 120 + 44 * eb));
            } else
            {
                g.setColor(new Color(175 + 55 * er, 151 + 50 * eg, 112 + 44 * eb));
            }
            g.fillPolygon(ai, ai1, 4);
            ai[1] = -1;
            ai1[1] = ai1[0];
            ai[0] = -1;
            ai1[0] -= 3;
            ai[2] = w;
            ai1[2] = ai1[1];
            ai[3] = w;
            ai1[3] = ai1[0];
            if(!isun)
            {
                g.setColor(new Color(169 + 55 * er, 171 + 50 * eg, 160 + 44 * eb));
            } else
            {
                g.setColor(new Color(167 + 55 * er, 164 + 50 * eg, 151 + 44 * eb));
            }
            g.fillPolygon(ai, ai1, 4);
        }
        if(jumping != 0)
        {
            jumping--;
        }
    }

    public void watch(ContO conto)
    {
        if(!td)
        {
            y = conto.y + (int)((float)(conto.y - 300 - conto.y) * cs.getcos(conto.zy) - (float)((conto.z + 3000) - conto.z) * cs.getsin(conto.zy));
            int i = conto.z + (int)((float)(conto.y - 300 - conto.y) * cs.getsin(conto.zy) + (float)((conto.z + 3000) - conto.z) * cs.getcos(conto.zy));
            x = conto.x + (int)((float)((conto.x + 400) - conto.x) * cs.getcos(conto.xz) - (float)(i - conto.z) * cs.getsin(conto.xz));
            z = conto.z + (int)((float)((conto.x + 400) - conto.x) * cs.getsin(conto.xz) + (float)(i - conto.z) * cs.getcos(conto.xz));
            td = true;
        }
        char c = '\0';
        if(conto.x - x - cx > 0)
        {
            c = '\264';
        }
        int j = -(int)((double)(90 + c) + Math.atan((double)(conto.z - z) / (double)(conto.x - x - cx)) / 0.017453292519943295D);
        c = '\0';
        if(conto.y - y - cy < 0)
        {
            c = '\uFF4C';
        }
        int k = (int)Math.sqrt((conto.z - z) * (conto.z - z) + (conto.x - x - cx) * (conto.x - x - cx));
        int l = (int)((double)(90 + c) - Math.atan((double)k / (double)(conto.y - y - cy)) / 0.017453292519943295D);
        xz = j;
        zy += (l - zy) / 5;
        if((int)Math.sqrt((conto.z - z) * (conto.z - z) + (conto.x - x - cx) * (conto.x - x - cx) + (conto.y - y - cy) * (conto.y - y - cy)) > 3500)
        {
            td = false;
        }
    }

    public void around(ContO conto, int i)
    {
        byte byte0 = 1;
        if(i == 6000)
        {
            byte0 = 2;
        }
        y = conto.y + adv;
        x = conto.x + (int)((float)(((conto.x - i) + adv * byte0) - conto.x) * cs.getcos(vxz));
        z = conto.z + (int)((float)(((conto.x - i) + adv * byte0) - conto.x) * cs.getsin(vxz));
        if(i == 6000)
        {
            if(!vert)
            {
                adv -= 10;
            } else
            {
                adv += 10;
            }
            if(adv < -900)
            {
                vert = true;
            }
            if(adv > 1200)
            {
                vert = false;
            }
        } else
        {
            if(!vert)
            {
                adv -= 2;
            } else
            {
                adv += 2;
            }
            if(adv < -500)
            {
                vert = true;
            }
            if(adv > 150)
            {
                vert = false;
            }
            if(adv > 300)
            {
                adv = 300;
            }
        }
        vxz += 2;
        if(vxz > 360)
        {
            vxz -= 360;
        }
        char c = '\0';
        int j = y;
        if(j > 0)
        {
            j = 0;
        }
        if(conto.y - j - cy < 0)
        {
            c = '\uFF4C';
        }
        int k = (int)Math.sqrt((conto.z - z) * (conto.z - z) + (conto.x - x - cx) * (conto.x - x - cx));
        int l = (int)((double)(90 + c) - Math.atan((double)k / (double)(conto.y - j - cy)) / 0.017453292519943295D);
        xz = -vxz + 90;
        zy += (l - zy) / 10;
    }

    public void left(ContO conto)
    {
        int i = conto.y;
        int j = conto.x + (int)((float)((conto.x + 600) - conto.x) * cs.getcos(conto.xz));
        int k = conto.z + (int)((float)((conto.x + 600) - conto.x) * cs.getsin(conto.xz));
        zy = 0;
        xz = -(conto.xz + 90);
        x += (double)(j - cx - x) / 1.5D;
        z += (double)(k - cz - z) / 1.5D;
        y += (double)(i - cy - y) / 1.5D;
    }

    public void right(ContO conto)
    {
        int i = conto.y;
        int j = conto.x + (int)((float)(conto.x - 600 - conto.x) * cs.getcos(conto.xz));
        int k = conto.z + (int)((float)(conto.x - 600 - conto.x) * cs.getsin(conto.xz));
        zy = 0;
        xz = -(conto.xz - 90);
        x += (j - cx - x) / 3;
        z += (double)(k - cz - z) / 1.5D;
        y += (double)(i - cy - y) / 1.5D;
    }

    public void behinde(ContO conto)
    {
        int i = conto.zy;
        int j = conto.xz;
        for(; i > 360; i -= 360) { }
        for(; i < 0; i += 360) { }
        if(i > 90 && i < 270)
        {
            tart += (180 - tart) / 3;
            yart += (100 - yart) / 4;
        } else
        {
            tart -= tart / 3;
            yart += (-100 - yart) / 4;
        }
        j += tart;
        if(i > 90)
        {
            i = 180 - i;
        }
        if(i < -90)
        {
            i = -180 - i;
        }
        int k = conto.y + (int)((float)((conto.y + yart) - conto.y) * cs.getcos(conto.zy) - (float)(conto.z - 600 - conto.z) * cs.getsin(conto.zy));
        int l = conto.z + (int)((float)((conto.y + yart) - conto.y) * cs.getsin(conto.zy) + (float)(conto.z - 600 - conto.z) * cs.getcos(conto.zy));
        int i1 = conto.x + (int)((float)(-(l - conto.z)) * cs.getsin(conto.xz));
        int j1 = conto.z + (int)((float)(l - conto.z) * cs.getcos(conto.xz));
        zy = -i;
        xz = -j;
        x += (i1 - cx - x) / 3;
        z += (double)(j1 - cz - z) / 1.5D;
        y += (double)(k - cy - y) / 1.5D;
    }
}
