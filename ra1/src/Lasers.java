import java.awt.Color;
import java.awt.Graphics;

public class Lasers
{

    Medium m;
    int speed[];
    int rads[];
    int srate[];
    int damg[];

    public int ys(int i, int j)
    {
        if(j < 10)
        {
            j = 10;
        }
        return ((j - m.focus_point) * (m.cy - i)) / j + i;
    }

    public Lasers(Medium medium)
    {
        speed = new int[12];
        rads = new int[12];
        srate = new int[12];
        damg = new int[12];
        m = medium;
        speed[0] = 200;
        rads[0] = 200;
        srate[0] = 8;
        damg[0] = 3;
        speed[1] = 150;
        rads[1] = 200;
        srate[1] = 8;
        damg[1] = 2;
        speed[2] = 120;
        rads[2] = 300;
        srate[2] = 10;
        damg[2] = 2;
        speed[3] = 120;
        rads[3] = 300;
        srate[3] = 10;
        damg[3] = 3;
        speed[4] = 100;
        rads[4] = 200;
        srate[4] = 8;
        damg[4] = 2;
        speed[5] = 100;
        rads[5] = 150;
        srate[5] = 6;
        damg[5] = 1;
        speed[6] = 140;
        rads[6] = 160;
        srate[6] = 8;
        damg[6] = 1;
        speed[7] = 100;
        rads[7] = 160;
        srate[7] = 6;
        damg[7] = 2;
        speed[8] = 150;
        rads[8] = 160;
        srate[8] = 10;
        damg[8] = 2;
        speed[9] = 120;
        rads[9] = 200;
        srate[9] = 10;
        damg[9] = 2;
        speed[10] = 150;
        rads[10] = 200;
        srate[10] = 10;
        damg[10] = 3;
        speed[11] = 150;
        rads[11] = 300;
        srate[11] = 10;
        damg[11] = 7;
    }

    public void dt(Graphics g, int ai[], int ai1[], int ai2[], int i, int j, int k, 
            int l, int i1, int j1, int k1, int l1, int i2, int j2, 
            int k2)
    {
        for(int l2 = 0; l2 < k1; l2++)
        {
            if(l1 == 0)
            {
                ai[l2] += i - m.x;
                ai1[l2] += j - m.y;
                ai2[l2] += k - m.z;
            } else
            {
                ai[l2] += (double)(i - m.x) + (Math.random() * 50D - 25D);
                ai1[l2] += (double)(j - m.y) + (Math.random() * 50D - 25D);
                ai2[l2] += (double)(k - m.z) + (Math.random() * 50D - 25D);
            }
        }

        rot(ai, ai1, i - m.x, j - m.y, j1, k1);
        rot(ai1, ai2, j - m.y, k - m.z, i1, k1);
        rot(ai, ai2, i - m.x, k - m.z, l, k1);
        rot(ai, ai2, m.cx, m.cz, m.xz, k1);
        rot(ai1, ai2, m.cy, m.cz, m.zy, k1);
        int ai3[] = new int[k1];
        int ai4[] = new int[k1];
        boolean flag = false;
        for(int i3 = 0; i3 < k1; i3++)
        {
            ai3[i3] = xs(ai[i3], ai2[i3]);
            ai4[i3] = ys(ai1[i3], ai2[i3]);
            if(ai4[i3] > 0 && ai4[i3] < m.h && ai3[i3] > 0 && ai3[i3] < m.w && ai2[i3] > 10)
            {
                flag = true;
            }
        }

        if(flag)
        {
            if(l1 != 0)
            {
                if(l1 == 1)
                {
                    i2 = 255;
                    j2 = 235;
                    k2 = 120;
                } else
                {
                    i2 = 255;
                    j2 = 220;
                    k2 = 111;
                }
            }
            g.setColor(new Color(i2, j2, k2));
            g.fillPolygon(ai3, ai4, k1);
        }
    }

    public void d(Graphics g, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1)
    {
        byte byte0 = 4;
        int ai[] = new int[byte0];
        int ai1[] = new int[byte0];
        int ai2[] = new int[byte0];
        if(i == 0)
        {
            byte byte1 = 4;
            ai[0] = 3;
            ai1[0] = 3;
            ai2[0] = 0;
            ai[1] = -3;
            ai1[1] = 3;
            ai2[1] = 0;
            ai[2] = -3;
            ai1[2] = 3;
            ai2[2] = -100;
            ai[3] = 3;
            ai1[3] = 3;
            ai2[3] = -100;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, 0, byte1, l1, 200, 255, 240);
            byte1 = 4;
            ai[0] = 0;
            ai1[0] = -3;
            ai2[0] = 0;
            ai[1] = 0;
            ai1[1] = 3;
            ai2[1] = 0;
            ai[2] = 0;
            ai1[2] = 3;
            ai2[2] = -100;
            ai[3] = 0;
            ai1[3] = -3;
            ai2[3] = -100;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, 0, byte1, l1, 200, 255, 240);
            byte1 = 4;
            ai[0] = -3;
            ai1[0] = -3;
            ai2[0] = -100;
            ai[1] = -3;
            ai1[1] = 3;
            ai2[1] = -100;
            ai[2] = 3;
            ai1[2] = 3;
            ai2[2] = -100;
            ai[3] = 3;
            ai1[3] = -3;
            ai2[3] = -100;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, 0, byte1, l1, 200, 255, 240);
        }
        if(i == 1)
        {
            byte byte2 = 4;
            ai[0] = 20;
            ai1[0] = 0;
            ai2[0] = -10;
            ai[1] = -20;
            ai1[1] = 0;
            ai2[1] = -10;
            ai[2] = -30;
            ai1[2] = 0;
            ai2[2] = 30;
            ai[3] = 30;
            ai1[3] = 0;
            ai2[3] = 30;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte2, l1, 149, 255, 205);
            byte2 = 3;
            ai[0] = 0;
            ai1[0] = 0;
            ai2[0] = 30;
            ai[1] = 0;
            ai1[1] = -3;
            ai2[1] = -10;
            ai[2] = 0;
            ai1[2] = 0;
            ai2[2] = -10;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte2, l1, 149, 255, 205);
            byte2 = 4;
            ai[0] = -20;
            ai1[0] = 0;
            ai2[0] = -10;
            ai[1] = -20;
            ai1[1] = -3;
            ai2[1] = -10;
            ai[2] = 20;
            ai1[2] = -3;
            ai2[2] = -10;
            ai[3] = 20;
            ai1[3] = 0;
            ai2[3] = -10;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte2, l1, 0, 232, 215);
        }
        if(i == 2)
        {
            byte byte3 = 4;
            ai[0] = -87 + (int)(Math.random() * 10D);
            ai1[0] = 2 + (int)(Math.random() * 20D - 10D);
            ai2[0] = 30 + (int)(Math.random() * 50D - 25D);
            ai[1] = -93 - (int)(Math.random() * 10D);
            ai1[1] = 2 + (int)(Math.random() * 20D - 10D);
            ai2[1] = 30 + (int)(Math.random() * 50D - 25D);
            ai[2] = -93 - (int)(Math.random() * 10D);
            ai1[2] = 2 + (int)(Math.random() * 20D - 10D);
            ai2[2] = -100 + (int)(Math.random() * 50D - 25D);
            ai[3] = -87 + (int)(Math.random() * 10D);
            ai1[3] = 2 + (int)(Math.random() * 20D - 10D);
            ai2[3] = -100 + (int)(Math.random() * 50D - 25D);
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte3, l1, 193, 224, 255);
            byte3 = 4;
            ai[0] = -90;
            ai1[0] = -2;
            ai2[0] = 30;
            ai[1] = -90;
            ai1[1] = 2;
            ai2[1] = 30;
            ai[2] = -90;
            ai1[2] = 2;
            ai2[2] = -100;
            ai[3] = -90;
            ai1[3] = -2;
            ai2[3] = -100;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte3, l1, 255, 240, 240);
            byte3 = 3;
            ai[0] = -90;
            ai1[0] = -2;
            ai2[0] = -100;
            ai[1] = -93;
            ai1[1] = 2;
            ai2[1] = -100;
            ai[2] = -87;
            ai1[2] = 2;
            ai2[2] = -100;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte3, l1, 255, 240, 240);
            byte3 = 4;
            ai[0] = 87 - (int)(Math.random() * 10D);
            ai1[0] = 2 + (int)(Math.random() * 20D - 10D);
            ai2[0] = 30 + (int)(Math.random() * 50D - 25D);
            ai[1] = 93 + (int)(Math.random() * 10D);
            ai1[1] = 2 + (int)(Math.random() * 20D - 10D);
            ai2[1] = 30 + (int)(Math.random() * 50D - 25D);
            ai[2] = 93 + (int)(Math.random() * 10D);
            ai1[2] = 2 + (int)(Math.random() * 20D - 10D);
            ai2[2] = -100 + (int)(Math.random() * 50D - 25D);
            ai[3] = 87 - (int)(Math.random() * 10D);
            ai1[3] = 2 + (int)(Math.random() * 20D - 10D);
            ai2[3] = -100 + (int)(Math.random() * 50D - 25D);
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte3, l1, 193, 224, 255);
            byte3 = 4;
            ai[0] = 90;
            ai1[0] = -2;
            ai2[0] = 30;
            ai[1] = 90;
            ai1[1] = 2;
            ai2[1] = 30;
            ai[2] = 90;
            ai1[2] = 2;
            ai2[2] = -100;
            ai[3] = 90;
            ai1[3] = -2;
            ai2[3] = -100;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte3, l1, 255, 240, 240);
            byte3 = 3;
            ai[0] = 90;
            ai1[0] = -2;
            ai2[0] = -100;
            ai[1] = 93;
            ai1[1] = 2;
            ai2[1] = -100;
            ai[2] = 87;
            ai1[2] = 2;
            ai2[2] = -100;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte3, l1, 255, 240, 240);
        }
        if(i == 3)
        {
            int i2 = (int)(Math.random() * 100D);
            byte byte4 = 4;
            ai[0] = 80;
            ai1[0] = 0;
            ai2[0] = -75;
            ai[1] = 40;
            ai1[1] = 0;
            ai2[1] = -50;
            ai[2] = 10 - i2;
            ai1[2] = 0;
            ai2[2] = 0;
            ai[3] = 80 + i2;
            ai1[3] = 0;
            ai2[3] = -30;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte4, l1, 255, 200, 255);
            byte4 = 3;
            ai[0] = 60;
            ai1[0] = 0;
            ai2[0] = 0;
            ai[1] = 60;
            ai1[1] = -3;
            ai2[1] = -60;
            ai[2] = 60;
            ai1[2] = 0;
            ai2[2] = -60;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte4, l1, 255, 221, 255);
            byte4 = 4;
            ai[0] = 40;
            ai1[0] = 0;
            ai2[0] = -50;
            ai[1] = 40;
            ai1[1] = -3;
            ai2[1] = -50;
            ai[2] = 80;
            ai1[2] = -3;
            ai2[2] = -75;
            ai[3] = 80;
            ai1[3] = 0;
            ai2[3] = -75;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte4, l1, 255, 221, 255);
            i2 = (int)(Math.random() * 100D);
            byte4 = 4;
            ai[0] = -80;
            ai1[0] = 0;
            ai2[0] = -75;
            ai[1] = -40;
            ai1[1] = 0;
            ai2[1] = -50;
            ai[2] = -10 + i2;
            ai1[2] = 0;
            ai2[2] = 0;
            ai[3] = -80 - i2;
            ai1[3] = 0;
            ai2[3] = -30;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte4, l1, 255, 200, 255);
            byte4 = 3;
            ai[0] = -60;
            ai1[0] = 0;
            ai2[0] = 0;
            ai[1] = -60;
            ai1[1] = -3;
            ai2[1] = -60;
            ai[2] = -60;
            ai1[2] = 0;
            ai2[2] = -60;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte4, l1, 255, 221, 255);
            byte4 = 4;
            ai[0] = -40;
            ai1[0] = 0;
            ai2[0] = -50;
            ai[1] = -40;
            ai1[1] = -3;
            ai2[1] = -50;
            ai[2] = -80;
            ai1[2] = -3;
            ai2[2] = -75;
            ai[3] = -80;
            ai1[3] = 0;
            ai2[3] = -75;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte4, l1, 255, 221, 255);
        }
        if(i == 4)
        {
            byte byte5 = 4;
            ai[0] = 3;
            ai1[0] = 3;
            ai2[0] = 0;
            ai[1] = -3;
            ai1[1] = 3;
            ai2[1] = 0;
            ai[2] = -3;
            ai1[2] = 3;
            ai2[2] = -100;
            ai[3] = 3;
            ai1[3] = 3;
            ai2[3] = -100;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, 0, byte5, l1, 255, 255, 177);
            byte5 = 4;
            ai[0] = 0;
            ai1[0] = -3;
            ai2[0] = 0;
            ai[1] = 0;
            ai1[1] = 3;
            ai2[1] = 0;
            ai[2] = 0;
            ai1[2] = 3;
            ai2[2] = -100;
            ai[3] = 0;
            ai1[3] = -3;
            ai2[3] = -100;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, 0, byte5, l1, 255, 255, 177);
            byte5 = 4;
            ai[0] = -3;
            ai1[0] = -3;
            ai2[0] = -100;
            ai[1] = -3;
            ai1[1] = 3;
            ai2[1] = -100;
            ai[2] = 3;
            ai1[2] = 3;
            ai2[2] = -100;
            ai[3] = 3;
            ai1[3] = -3;
            ai2[3] = -100;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, 0, byte5, l1, 255, 255, 177);
        }
        if(i == 5)
        {
            byte byte6 = 4;
            ai[0] = 11;
            ai1[0] = 3;
            ai2[0] = 0;
            ai[1] = 5;
            ai1[1] = 3;
            ai2[1] = 0;
            ai[2] = 5;
            ai1[2] = 3;
            ai2[2] = -100;
            ai[3] = 11;
            ai1[3] = 3;
            ai2[3] = -100;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte6, l1, 255, 240, 177);
            byte6 = 4;
            ai[0] = 8;
            ai1[0] = -3;
            ai2[0] = 0;
            ai[1] = 8;
            ai1[1] = 3;
            ai2[1] = 0;
            ai[2] = 8;
            ai1[2] = 3;
            ai2[2] = -100;
            ai[3] = 8;
            ai1[3] = -3;
            ai2[3] = -100;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte6, l1, 255, 240, 177);
            byte6 = 3;
            ai[0] = 8;
            ai1[0] = -3;
            ai2[0] = -100;
            ai[1] = 5;
            ai1[1] = 3;
            ai2[1] = -100;
            ai[2] = 11;
            ai1[2] = 3;
            ai2[2] = -100;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte6, l1, 255, 240, 177);
            byte6 = 4;
            ai[0] = -11;
            ai1[0] = 3;
            ai2[0] = 0;
            ai[1] = -5;
            ai1[1] = 3;
            ai2[1] = 0;
            ai[2] = -5;
            ai1[2] = 3;
            ai2[2] = -100;
            ai[3] = -11;
            ai1[3] = 3;
            ai2[3] = -100;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte6, l1, 255, 240, 177);
            byte6 = 4;
            ai[0] = -8;
            ai1[0] = -3;
            ai2[0] = 0;
            ai[1] = -8;
            ai1[1] = 3;
            ai2[1] = 0;
            ai[2] = -8;
            ai1[2] = 3;
            ai2[2] = -100;
            ai[3] = -8;
            ai1[3] = -3;
            ai2[3] = -100;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte6, l1, 255, 240, 177);
            byte6 = 3;
            ai[0] = -8;
            ai1[0] = -3;
            ai2[0] = -100;
            ai[1] = -5;
            ai1[1] = 3;
            ai2[1] = -100;
            ai[2] = -11;
            ai1[2] = 3;
            ai2[2] = -100;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte6, l1, 255, 240, 177);
        }
        if(i == 6)
        {
            byte byte7 = 4;
            ai[0] = 103;
            ai1[0] = 3;
            ai2[0] = -100;
            ai[1] = 97;
            ai1[1] = 3;
            ai2[1] = -100;
            ai[2] = 97;
            ai1[2] = 3;
            ai2[2] = -200;
            ai[3] = 103;
            ai1[3] = 3;
            ai2[3] = -200;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte7, l1, 177, 255, 177);
            byte7 = 4;
            ai[0] = 100;
            ai1[0] = -3;
            ai2[0] = -100;
            ai[1] = 100;
            ai1[1] = 3;
            ai2[1] = -100;
            ai[2] = 100;
            ai1[2] = 3;
            ai2[2] = -200;
            ai[3] = 100;
            ai1[3] = -3;
            ai2[3] = -200;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte7, l1, 177, 255, 177);
            byte7 = 3;
            ai[0] = 100;
            ai1[0] = -3;
            ai2[0] = -200;
            ai[1] = 97;
            ai1[1] = 3;
            ai2[1] = -200;
            ai[2] = 103;
            ai1[2] = 3;
            ai2[2] = -200;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte7, l1, 177, 255, 177);
            byte7 = 4;
            ai[0] = -103;
            ai1[0] = 3;
            ai2[0] = -100;
            ai[1] = -97;
            ai1[1] = 3;
            ai2[1] = -100;
            ai[2] = -97;
            ai1[2] = 3;
            ai2[2] = -200;
            ai[3] = -103;
            ai1[3] = 3;
            ai2[3] = -200;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte7, l1, 177, 255, 177);
            byte7 = 4;
            ai[0] = -100;
            ai1[0] = -3;
            ai2[0] = -100;
            ai[1] = -100;
            ai1[1] = 3;
            ai2[1] = -100;
            ai[2] = -100;
            ai1[2] = 3;
            ai2[2] = -200;
            ai[3] = -100;
            ai1[3] = -3;
            ai2[3] = -200;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte7, l1, 177, 255, 177);
            byte7 = 3;
            ai[0] = -100;
            ai1[0] = -3;
            ai2[0] = -200;
            ai[1] = -97;
            ai1[1] = 3;
            ai2[1] = -200;
            ai[2] = -103;
            ai1[2] = 3;
            ai2[2] = -200;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte7, l1, 177, 255, 177);
        }
        if(i == 7)
        {
            byte byte8 = 4;
            ai[0] = 10;
            ai1[0] = 0;
            ai2[0] = -50;
            ai[1] = -10;
            ai1[1] = 0;
            ai2[1] = -50;
            ai[2] = -10;
            ai1[2] = 0;
            ai2[2] = -100;
            ai[3] = 10;
            ai1[3] = 0;
            ai2[3] = -100;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte8, l1, 255, 255, 255);
            byte8 = 3;
            ai[0] = 0;
            ai1[0] = -10;
            ai2[0] = -50;
            ai[1] = 0;
            ai1[1] = 0;
            ai2[1] = -50;
            ai[2] = 0;
            ai1[2] = 0;
            ai2[2] = -100;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte8, l1, 175, 240, 255);
            byte8 = 3;
            ai[0] = 0;
            ai1[0] = -10;
            ai2[0] = -50;
            ai[1] = -10;
            ai1[1] = 0;
            ai2[1] = -50;
            ai[2] = 10;
            ai1[2] = 0;
            ai2[2] = -50;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte8, l1, 175, 240, 255);
        }
        if(i == 8)
        {
            byte byte9 = 4;
            ai[0] = 10;
            ai1[0] = 0;
            ai2[0] = 0;
            ai[1] = -10;
            ai1[1] = 0;
            ai2[1] = 0;
            ai[2] = -10;
            ai1[2] = 0;
            ai2[2] = -100;
            ai[3] = 10;
            ai1[3] = 0;
            ai2[3] = -100;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte9, l1, 255, 255, 255);
            byte9 = 3;
            ai[0] = 0;
            ai1[0] = -10;
            ai2[0] = 0;
            ai[1] = 0;
            ai1[1] = 0;
            ai2[1] = 0;
            ai[2] = 0;
            ai1[2] = 0;
            ai2[2] = -100;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte9, l1, 200, 200, 200);
            byte9 = 3;
            ai[0] = 0;
            ai1[0] = -10;
            ai2[0] = 0;
            ai[1] = -10;
            ai1[1] = 0;
            ai2[1] = 0;
            ai[2] = 10;
            ai1[2] = 0;
            ai2[2] = 0;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte9, l1, 200, 200, 200);
        }
        if(i == 9)
        {
            byte byte10 = 4;
            ai[0] = 69;
            ai1[0] = 3;
            ai2[0] = 0;
            ai[1] = 63;
            ai1[1] = 3;
            ai2[1] = 0;
            ai[2] = 63;
            ai1[2] = 3;
            ai2[2] = -100;
            ai[3] = 69;
            ai1[3] = 3;
            ai2[3] = -100;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte10, l1, 200, 240, 255);
            byte10 = 4;
            ai[0] = 66;
            ai1[0] = -3;
            ai2[0] = 0;
            ai[1] = 66;
            ai1[1] = 3;
            ai2[1] = 0;
            ai[2] = 66;
            ai1[2] = 3;
            ai2[2] = -100;
            ai[3] = 66;
            ai1[3] = -3;
            ai2[3] = -100;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte10, l1, 200, 240, 255);
            byte10 = 3;
            ai[0] = 66;
            ai1[0] = -3;
            ai2[0] = -100;
            ai[1] = 63 - (int)(Math.random() * 30D);
            ai1[1] = 3;
            ai2[1] = -100;
            ai[2] = 69 + (int)(Math.random() * 30D);
            ai1[2] = 3;
            ai2[2] = -100;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte10, l1, 255, 240, 177);
            byte10 = 4;
            ai[0] = -69;
            ai1[0] = 3;
            ai2[0] = 0;
            ai[1] = -63;
            ai1[1] = 3;
            ai2[1] = 0;
            ai[2] = -63;
            ai1[2] = 3;
            ai2[2] = -100;
            ai[3] = -69;
            ai1[3] = 3;
            ai2[3] = -100;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte10, l1, 200, 240, 255);
            byte10 = 4;
            ai[0] = -66;
            ai1[0] = -3;
            ai2[0] = 0;
            ai[1] = -66;
            ai1[1] = 3;
            ai2[1] = 0;
            ai[2] = -66;
            ai1[2] = 3;
            ai2[2] = -100;
            ai[3] = -66;
            ai1[3] = -3;
            ai2[3] = -100;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte10, l1, 200, 240, 255);
            byte10 = 3;
            ai[0] = -66;
            ai1[0] = -3;
            ai2[0] = -100;
            ai[1] = -63 + (int)(Math.random() * 30D);
            ai1[1] = 3;
            ai2[1] = -100;
            ai[2] = -69 - (int)(Math.random() * 30D);
            ai1[2] = 3;
            ai2[2] = -100;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte10, l1, 255, 240, 177);
        }
        if(i == 10)
        {
            byte byte11 = 4;
            ai[0] = -8;
            ai1[0] = 0;
            ai2[0] = 56;
            ai[1] = -58;
            ai1[1] = 20;
            ai2[1] = 24;
            ai[2] = -55;
            ai1[2] = 20;
            ai2[2] = 0;
            ai[3] = -8;
            ai1[3] = 0;
            ai2[3] = 14;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte11, l1, 200, 200, 255);
            byte11 = 4;
            ai[0] = -8;
            ai1[0] = 0;
            ai2[0] = 14;
            ai[1] = -49;
            ai1[1] = -20;
            ai2[1] = -25;
            ai[2] = -45;
            ai1[2] = -20;
            ai2[2] = -45;
            ai[3] = -8;
            ai1[3] = 0;
            ai2[3] = -33;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte11, l1, 230, 230, 255);
            byte11 = 4;
            ai[0] = 8;
            ai1[0] = 0;
            ai2[0] = 56;
            ai[1] = 58;
            ai1[1] = 20;
            ai2[1] = 24;
            ai[2] = 55;
            ai1[2] = 20;
            ai2[2] = 0;
            ai[3] = 8;
            ai1[3] = 0;
            ai2[3] = 14;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte11, l1, 200, 200, 255);
            byte11 = 4;
            ai[0] = 8;
            ai1[0] = 0;
            ai2[0] = 14;
            ai[1] = 49;
            ai1[1] = -20;
            ai2[1] = -25;
            ai[2] = 45;
            ai1[2] = -20;
            ai2[2] = -45;
            ai[3] = 8;
            ai1[3] = 0;
            ai2[3] = -33;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte11, l1, 230, 230, 255);
        }
        if(i == 11)
        {
            byte byte12 = 4;
            ai[0] = -87 + (int)(Math.random() * 10D);
            ai1[0] = 2 + (int)(Math.random() * 20D - 10D);
            ai2[0] = 30 + (int)(Math.random() * 50D - 25D);
            ai[1] = -93 - (int)(Math.random() * 10D);
            ai1[1] = 2 + (int)(Math.random() * 20D - 10D);
            ai2[1] = 30 + (int)(Math.random() * 50D - 25D);
            ai[2] = -93 - (int)(Math.random() * 10D);
            ai1[2] = 2 + (int)(Math.random() * 20D - 10D);
            ai2[2] = -100 + (int)(Math.random() * 50D - 25D);
            ai[3] = -87 + (int)(Math.random() * 10D);
            ai1[3] = 2 + (int)(Math.random() * 20D - 10D);
            ai2[3] = -100 + (int)(Math.random() * 50D - 25D);
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte12, l1, 190, 190, 190);
            byte12 = 4;
            ai[0] = -90;
            ai1[0] = -2;
            ai2[0] = 30;
            ai[1] = -90;
            ai1[1] = 2;
            ai2[1] = 30;
            ai[2] = -90;
            ai1[2] = 2;
            ai2[2] = -100;
            ai[3] = -90;
            ai1[3] = -2;
            ai2[3] = -100;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte12, l1, 200, 230, 255);
            byte12 = 3;
            ai[0] = -90;
            ai1[0] = -2;
            ai2[0] = -100;
            ai[1] = -93;
            ai1[1] = 2;
            ai2[1] = -100;
            ai[2] = -87;
            ai1[2] = 2;
            ai2[2] = -100;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte12, l1, 200, 230, 255);
            byte12 = 4;
            ai[0] = 87 - (int)(Math.random() * 10D);
            ai1[0] = 2 + (int)(Math.random() * 20D - 10D);
            ai2[0] = 30 + (int)(Math.random() * 50D - 25D);
            ai[1] = 93 + (int)(Math.random() * 10D);
            ai1[1] = 2 + (int)(Math.random() * 20D - 10D);
            ai2[1] = 30 + (int)(Math.random() * 50D - 25D);
            ai[2] = 93 + (int)(Math.random() * 10D);
            ai1[2] = 2 + (int)(Math.random() * 20D - 10D);
            ai2[2] = -100 + (int)(Math.random() * 50D - 25D);
            ai[3] = 87 - (int)(Math.random() * 10D);
            ai1[3] = 2 + (int)(Math.random() * 20D - 10D);
            ai2[3] = -100 + (int)(Math.random() * 50D - 25D);
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte12, l1, 190, 190, 190);
            byte12 = 4;
            ai[0] = 90;
            ai1[0] = -2;
            ai2[0] = 30;
            ai[1] = 90;
            ai1[1] = 2;
            ai2[1] = 30;
            ai[2] = 90;
            ai1[2] = 2;
            ai2[2] = -100;
            ai[3] = 90;
            ai1[3] = -2;
            ai2[3] = -100;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte12, l1, 200, 230, 255);
            byte12 = 3;
            ai[0] = 90;
            ai1[0] = -2;
            ai2[0] = -100;
            ai[1] = 93;
            ai1[1] = 2;
            ai2[1] = -100;
            ai[2] = 87;
            ai1[2] = 2;
            ai2[2] = -100;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte12, l1, 200, 230, 255);
            byte12 = 4;
            ai[0] = 143;
            ai1[0] = 20;
            ai2[0] = -100;
            ai[1] = 137;
            ai1[1] = 20;
            ai2[1] = -100;
            ai[2] = 137;
            ai1[2] = 20;
            ai2[2] = -200;
            ai[3] = 143;
            ai1[3] = 20;
            ai2[3] = -200;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte12, l1, 180, 180, 180);
            byte12 = 4;
            ai[0] = 140;
            ai1[0] = 17;
            ai2[0] = -100;
            ai[1] = 140;
            ai1[1] = 20;
            ai2[1] = -100;
            ai[2] = 140;
            ai1[2] = 20;
            ai2[2] = -200;
            ai[3] = 140;
            ai1[3] = 17;
            ai2[3] = -200;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte12, l1, 180, 180, 180);
            byte12 = 3;
            ai[0] = 140;
            ai1[0] = 17;
            ai2[0] = -200;
            ai[1] = 137;
            ai1[1] = 20;
            ai2[1] = -200;
            ai[2] = 143;
            ai1[2] = 20;
            ai2[2] = -200;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte12, l1, 180, 180, 180);
            byte12 = 4;
            ai[0] = -143;
            ai1[0] = 20;
            ai2[0] = -100;
            ai[1] = -137;
            ai1[1] = 20;
            ai2[1] = -100;
            ai[2] = -137;
            ai1[2] = 20;
            ai2[2] = -200;
            ai[3] = -143;
            ai1[3] = 20;
            ai2[3] = -200;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte12, l1, 180, 180, 180);
            byte12 = 4;
            ai[0] = -140;
            ai1[0] = 17;
            ai2[0] = -100;
            ai[1] = -140;
            ai1[1] = 20;
            ai2[1] = -100;
            ai[2] = -140;
            ai1[2] = 20;
            ai2[2] = -200;
            ai[3] = -140;
            ai1[3] = 17;
            ai2[3] = -200;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte12, l1, 180, 180, 180);
            byte12 = 3;
            ai[0] = -140;
            ai1[0] = 17;
            ai2[0] = -200;
            ai[1] = -137;
            ai1[1] = 20;
            ai2[1] = -200;
            ai[2] = -143;
            ai1[2] = 20;
            ai2[2] = -200;
            dt(g, ai, ai1, ai2, j, k, l, i1, j1, k1, byte12, l1, 180, 180, 180);
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

    public void gsmoke(Graphics g, int i, int j, int k, int l, int i1, int j1)
    {
        int ai[] = new int[8];
        int ai1[] = new int[8];
        int ai2[] = new int[8];
        ai[0] = (-5 + (int)(Math.random() * 5D)) - j1 * 2;
        ai1[0] = (-12 + (int)(Math.random() * 12D)) - j1 * 6;
        ai2[0] = -50;
        ai[1] = (5 - (int)(Math.random() * 5D)) + j1 * 2;
        ai1[1] = (-12 + (int)(Math.random() * 12D)) - j1 * 6;
        ai2[1] = -50;
        ai[2] = (12 - (int)(Math.random() * 12D)) + j1 * 6;
        ai1[2] = (-5 + (int)(Math.random() * 5D)) - j1 * 2;
        ai2[2] = -50;
        ai[3] = (12 - (int)(Math.random() * 12D)) + j1 * 6;
        ai1[3] = (5 - (int)(Math.random() * 5D)) + j1 * 2;
        ai2[3] = -50;
        ai[4] = (5 - (int)(Math.random() * 5D)) + j1 * 2;
        ai1[4] = (12 - (int)(Math.random() * 12D)) + j1 * 6;
        ai2[4] = -50;
        ai[5] = (-5 + (int)(Math.random() * 5D)) - j1 * 2;
        ai1[5] = (12 - (int)(Math.random() * 12D)) + j1 * 6;
        ai2[5] = -50;
        ai[6] = (-12 + (int)(Math.random() * 12D)) - j1 * 6;
        ai1[6] = (5 - (int)(Math.random() * 5D)) + j1 * 2;
        ai2[6] = -50;
        ai[7] = (-12 + (int)(Math.random() * 12D)) - j1 * 6;
        ai1[7] = (-5 + (int)(Math.random() * 5D)) - j1 * 2;
        ai2[7] = -50;
        if(j1 > 3)
        {
            j1 = 3;
        }
        dt(g, ai, ai1, ai2, i, j, k, l, i1, 0, 8, 0, 249 - j1 * 25, 251 - j1 * 25, 240 - j1 * 25);
    }

    public int xs(int i, int j)
    {
        if(j < 10)
        {
            j = 10;
        }
        return ((j - m.focus_point) * (m.cx - i)) / j + i;
    }

    public void hsmoke(Graphics g, int i, int j, int k, int l, int i1, int j1)
    {
        int ai[] = new int[8];
        int ai1[] = new int[8];
        int ai2[] = new int[8];
        ai[0] = (-5 + (int)(Math.random() * 5D)) - j1;
        ai1[0] = (-12 + (int)(Math.random() * 12D)) - j1 * 2;
        ai2[0] = -50;
        ai[1] = (5 - (int)(Math.random() * 5D)) + j1;
        ai1[1] = (-12 + (int)(Math.random() * 12D)) - j1 * 2;
        ai2[1] = -50;
        ai[2] = (12 - (int)(Math.random() * 12D)) + j1 * 2;
        ai1[2] = (-5 + (int)(Math.random() * 5D)) - j1;
        ai2[2] = -50;
        ai[3] = (12 - (int)(Math.random() * 12D)) + j1 * 2;
        ai1[3] = (5 - (int)(Math.random() * 5D)) + j1;
        ai2[3] = -50;
        ai[4] = (5 - (int)(Math.random() * 5D)) + j1;
        ai1[4] = (12 - (int)(Math.random() * 12D)) + j1 * 2;
        ai2[4] = -50;
        ai[5] = (-5 + (int)(Math.random() * 5D)) - j1;
        ai1[5] = (12 - (int)(Math.random() * 12D)) + j1 * 2;
        ai2[5] = -50;
        ai[6] = (-12 + (int)(Math.random() * 12D)) - j1 * 2;
        ai1[6] = (5 - (int)(Math.random() * 5D)) + j1;
        ai2[6] = -50;
        ai[7] = (-12 + (int)(Math.random() * 12D)) - j1 * 2;
        ai1[7] = (-5 + (int)(Math.random() * 5D)) - j1;
        ai2[7] = -50;
        if(j1 > 3)
        {
            j1 = 3;
        }
        dt(g, ai, ai1, ai2, i, j, k, l, i1, 0, 8, 0, 89 + j1 * 20, 91 + j1 * 20, 80 + j1 * 20);
    }
}
