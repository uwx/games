import java.awt.*;
import java.awt.image.MemoryImageSource;
import java.awt.image.PixelGrabber;

public class xtGraphics extends Panel
{

    Medium m;
    FontMetrics ftm;
    boolean goodsun;
    int cl;
    Image radar;
    Image stube;
    Image sback;
    Image destr;
    Image mback;
    Image lay;
    Image complete;
    Image main;
    Image rad;
    Image inst1;
    Image inst2;
    Image inst3;
    Image mars;
    Image text;
    Image as[];
    int pix[];
    int bpix[];
    int mpix[];
    int opix[];
    int ppix[];
    int cnt;
    boolean flik;
    int cnts;
    String mname[];
    int cnte[];
    int cntf;
    boolean left;
    int wcnt;
    int rcnt;
    int cnty;
    int fase;
    int selected;
    int select;
    int ws[] = {
        62, 73, 59, 40, 50
    };
    boolean frst;
    int oldfase;
    int nb;
    int ob[];
    String nam[];
    boolean tnk[];
    int obx[];
    int oby[];
    int obz[];
    int sgame;
    int level;
    boolean dest[];
    boolean mcomp;
    int tcnt;

    public void denter(Graphics g, int i, ContO aconto[], userCraft usercraft, Control control)
    {
        if(fase == 4)
        {
            int j = 0;
            do
            {
                aconto[j].out = false;
                aconto[j].wire = true;
                aconto[j].x = 0;
                aconto[j].y = 180;
                aconto[j].z = 0;
                aconto[j].xy = 90;
            } while(++j < 5);
            m.x = -100;
            m.y = 0;
            m.ground = 950 - m.y;
            m.z = -50;
            m.xz = -90;
            m.zy = 0;
            aconto[0].zy = 0;
            g.setColor(new Color(255, 255, 0));
            j = 0;
            do
            {
                g.drawLine(j * 2, 0, j * 2, 360);
            } while(++j < 250);
            if(oldfase == 7)
            {
                fase = 7;
                oldfase = 0;
                cnt = 0;
            } else
            {
                fase = 5;
            }
        }
        if(fase == -8)
        {
            if(cnty < 351)
            {
                g.drawImage(mars, 0, 0, null);
                g.drawImage(text, 10, 380 - cnty, null);
                if(cnty != 350)
                {
                    cnty++;
                } else
                {
                    drawcs(g, 345, "Press Enter to continue", 225, 225, 225, true);
                    cnty = 351;
                }
            }
            if(control.space)
            {
                fase = -5;
                if(sgame == 1)
                {
                    select = 1;
                } else
                {
                    select = 2;
                }
                control.space = false;
            }
        }
        if(fase == -7)
        {
            g.drawImage(inst1, 0, 0, null);
            drawcs(g, 354, "Press Enter to continue >", 170, 170, 170, false);
            if(control.space)
            {
                fase = -6;
                control.space = false;
            }
        }
        if(fase == -6)
        {
            g.drawImage(inst2, 0, 0, null);
            drawcs(g, 354, "Press Enter to continue >", 170, 170, 170, false);
            if(control.space)
            {
                fase = -55;
                control.space = false;
            }
        }
        if(fase == -55)
        {
            g.drawImage(inst3, 0, 0, null);
            drawcs(g, 354, "Press Enter to continue >", 170, 170, 170, false);
            if(control.space)
            {
                fase = oldfase;
                control.space = false;
            }
        }
        if(fase == -5)
        {
            g.drawImage(main, 0, 0, null);
            if(cnt < 7)
            {
                g.drawImage(as[select], 25, 283, null);
                g.drawImage(as[select], 423, 283, null);
                cnt++;
            } else
            {
                cnt = 0;
            }
            g.setColor(new Color(225, 230, 255));
            int k = 50 + (int)(Math.random() * 150D);
            g.drawLine((int)(Math.random() * 400D), k, (int)(Math.random() * 200D), k);
            k = 50 + (int)(Math.random() * 150D);
            g.drawLine(500 - (int)(Math.random() * 400D), k, 500 - (int)(Math.random() * 200D), k);
            if(cnts < -900)
            {
                cnts = 0;
                cntf = (int)(Math.random() * 150D);
            } else
            {
                cnts -= 7;
            }
            if(control.space)
            {
                cnts = 10;
            }
            g.drawImage(rad, 500 + cnts, 50 + cntf, null);
            drawcs(g, 274, "Start New Game", 0, 0, 0, false);
            if(sgame != 0)
            {
                drawcs(g, 289, "Resume Saved Game", 0, 0, 0, false);
            } else
            {
                if(control.space && select == 1)
                {
                    wcnt = 20;
                }
                if(wcnt != 0)
                {
                    drawcs(g, 289, "No Saved Game!", 100, 0, 0, false);
                    wcnt--;
                } else
                {
                    drawcs(g, 289, "Resume Saved Game", 200, 200, 200, false);
                }
            }
            drawcs(g, 304, "Game Controls", 0, 0, 0, false);
            drawcs(g, 319, "Credits", 0, 0, 0, false);
            drawcs(g, 334, "Exit Game", 0, 0, 0, false);
            if(!flik)
            {
                g.setColor(new Color(225, 230, 255));
                flik = true;
                g.drawLine(250 - ws[select], 271 + 15 * select, 250 + ws[select], 271 + 15 * select);
                g.drawRect(250 - ws[select], 264 + 15 * select, ws[select] * 2, 11);
                g.setColor(new Color(0, 0, 0));
                g.drawLine(251 - ws[select], 271 + 15 * select, 255 - ws[select], 271 + 15 * select);
                g.drawLine(245 + ws[select], 271 + 15 * select, 249 + ws[select], 271 + 15 * select);
            } else
            {
                g.setColor(new Color(168, 183, 255));
                g.drawRect(250 - ws[select], 264 + 15 * select, ws[select] * 2, 11);
                flik = false;
            }
            if(control.down)
            {
                select++;
                control.down = false;
            }
            if(control.up)
            {
                select--;
                control.up = false;
            }
            if(select == 5)
            {
                select = 0;
            }
            if(select == -1)
            {
                select = 4;
            }
            if(control.space)
            {
                if(select == 2)
                {
                    fase = -7;
                    oldfase = -5;
                    control.space = false;
                }
                if(select == 3)
                {
                    fase = 4;
                    control.space = false;
                }
            }
            drawcs(g, 354, "( use keyboard arrows to select and press Enter )", 170, 170, 170, false);
            if(frst)
            {
                frst = false;
            }
        }
        if(fase == -4)
        {
            if(control.space)
            {
                fase = -3;
                control.space = false;
            } else
            {
                int l = 0;
                int j3 = 0;
                for(int k3 = i; k3 < i + 13; k3++)
                {
                    l += aconto[k3].nhits;
                    j3 += aconto[k3].maxhits;
                }

                if(l > j3)
                {
                    l = j3;
                }
                int l3 = (int)(((float)l / (float)j3) * 100F);
                drawcs(g, 30, "The Mars Station..", 255, 255, 255, true);
                if(l3 < 90 || flik)
                {
                    drawcs(g, 60, "Damage status:  " + l3 + "%", 0, 0, 0, false);
                    flik = false;
                } else
                {
                    drawcs(g, 60, "Damage status:  " + l3 + "%", 255, 0, 0, false);
                    flik = true;
                }
                if(!frst)
                {
                    drawcs(g, 340, "Press Enter to continue", 255, 255, 255, false);
                } else
                {
                    drawcs(g, 300, "Mission " + level + " completed, do you wish to save game here?", 255, 255, 255, false);
                    if(select == 0)
                    {
                        g.setColor(new Color(255, 255, 255));
                        g.fillRect(220, 319, 29, 14);
                        g.setColor(new Color(192, 192, 192));
                        g.drawRect(220, 319, 29, 14);
                    }
                    if(select != 0)
                    {
                        g.setColor(new Color(255, 255, 255));
                        g.fillRect(256, 319, 22, 14);
                        g.setColor(new Color(192, 192, 192));
                        g.drawRect(256, 319, 22, 14);
                    }
                    if(control.up || control.down || control.left || control.right)
                    {
                        if(select == 0)
                        {
                            select = 1;
                        } else
                        {
                            select = 0;
                        }
                        control.up = false;
                        control.down = false;
                        control.left = false;
                        control.right = false;
                    }
                    drawcs(g, 330, "Yes     No", 0, 0, 0, false);
                }
            }
        }
        if(fase == -3)
        {
            g.setColor(new Color(225, 230, 255));
            g.drawRect(1, 1, 497, 357);
            drawcs(g, 180, "Loading Mission " + (level + 1) + " ...", 225, 230, 255, true);
        }
        if(fase == -2)
        {
            rcnt = 0;
            int i1 = 0;
            do
            {
                aconto[i1].reset();
                aconto[i1].out = false;
                aconto[i1].x = (i1 - selected) * 500;
                aconto[i1].y = 180;
                aconto[i1].z = 0;
            } while(++i1 < 5);
            m.x = -m.cx;
            m.y = 0;
            m.ground = 250 - m.y;
            m.z = -620;
            m.xz = 0;
            m.zy = 0;
            aconto[0].zy = 15;
            aconto[0].xy = -15;
            aconto[2].xy = -30;
            aconto[3].zy = -15;
            aconto[1].zy = 30;
            for(int j1 = 0; j1 < nb; j1++)
            {
                obx[j1] = aconto[ob[j1]].x;
                oby[j1] = aconto[ob[j1]].y;
                obz[j1] = aconto[ob[j1]].z;
                aconto[ob[j1]].x = -525;
                if(tnk[j1])
                {
                    aconto[ob[j1]].y = 95 + 305 * j1;
                    aconto[ob[j1]].zy = 0;
                } else
                {
                    aconto[ob[j1]].y = 55 + 305 * j1;
                    aconto[ob[j1]].zy = 20;
                }
                aconto[ob[j1]].z = 1000;
                aconto[ob[j1]].xy = 0;
                aconto[ob[j1]].xz = (int)(Math.random() * 270D);
                aconto[ob[j1]].out = false;
            }

            cmback(nb);
            fase = -1;
        }
        if(fase == 0)
        {
            if(!dest[selected])
            {
                if(wcnt < 5)
                {
                    aconto[selected].wire = true;
                } else
                {
                    aconto[selected].wire = false;
                }
                if(wcnt > 9)
                {
                    wcnt = 0;
                } else
                {
                    wcnt++;
                }
            }
            if(rcnt == 0)
            {
                if(control.left)
                {
                    left = true;
                    rcnt = 1;
                }
                if(control.right)
                {
                    left = false;
                    rcnt = 1;
                }
            } else
            {
                int k1 = 0;
                do
                {
                    if(aconto[k1].x == 2000)
                    {
                        aconto[k1].x = -500;
                    }
                    if(aconto[k1].x == -2000)
                    {
                        aconto[k1].x = 500;
                    }
                    if(left)
                    {
                        aconto[k1].x -= 100;
                    } else
                    {
                        aconto[k1].x += 100;
                    }
                } while(++k1 < 5);
                aconto[selected].wire = false;
                rcnt++;
                if(rcnt == 6)
                {
                    wcnt = 7;
                    rcnt = 0;
                    if(left)
                    {
                        if(selected != 4)
                        {
                            selected++;
                        } else
                        {
                            selected = 0;
                        }
                    } else
                    if(selected != 0)
                    {
                        selected--;
                    } else
                    {
                        selected = 4;
                    }
                    aconto[selected].hit = true;
                    aconto[selected].nhits = 0;
                }
            }
            if(control.space)
            {
                aconto[selected].wire = false;
            }
            g.drawImage(sback, 0, 0, null);
            int l1 = 0;
            do
            {
                aconto[l1].d(g);
                aconto[l1].xz += 2;
            } while(++l1 < 5);
            if(dest[selected] && rcnt == 0)
            {
                g.drawImage(destr, 117, 103, null);
            }
            drawcs(g, 16, "Select your Ship", 255, 255, 255, false);
            drawcs(g, 354, "( use keyboard arrows to select )", 150, 150, 160, false);
            drawcs(g, 265, usercraft.name[selected], 190, 200, 255, false);
            if(control.space && dest[selected])
            {
                drawcs(g, 80, "Cannot Select Ship!", 255, 230, 230, true);
            }
            int ai[] = new int[3];
            int ai1[] = new int[3];
            g.setColor(new Color(100, 100, 100));
            if(rcnt == 1 && left)
            {
                g.setColor(new Color(225, 225, 225));
            }
            ai[0] = 50;
            ai1[0] = 255;
            ai[1] = 75;
            ai1[1] = 250;
            ai[2] = 75;
            ai1[2] = 260;
            g.fillPolygon(ai, ai1, 3);
            g.setColor(new Color(100, 100, 100));
            if(rcnt == 1 && !left)
            {
                g.setColor(new Color(225, 225, 225));
            }
            ai[0] = 450;
            ai1[0] = 255;
            ai[1] = 425;
            ai1[1] = 250;
            ai[2] = 425;
            ai1[2] = 260;
            g.fillPolygon(ai, ai1, 3);
            g.setColor(new Color(225, 225, 255));
            g.drawString("Max Speed", 57, 300);
            g.setColor(new Color(190, 200, 255));
            g.fillRect(125, 295, (int)(100F * ((float)usercraft.maxspeed[selected] / 120F)), 4);
            g.setColor(new Color(225, 225, 255));
            g.drawString(" Fire Power", 57, 315);
            g.setColor(new Color(190, 200, 255));
            g.fillRect(125, 310, (int)(100F * ((float)(usercraft.lsr.damg[selected] + 2) / 6F)), 4);
            g.setColor(new Color(225, 225, 255));
            g.drawString("  Tolerance", 57, 330);
            g.setColor(new Color(190, 200, 255));
            g.fillRect(125, 325, (int)(100F * ((float)aconto[selected].maxhits / 300F)), 4);
            g.setColor(new Color(225, 225, 255));
            g.drawString("       Turning", 285, 300);
            g.setColor(new Color(190, 200, 255));
            g.fillRect(355, 295, (int)(100F * ((float)(usercraft.trnn[selected] + 3) / 5F)), 4);
            g.setColor(new Color(225, 225, 255));
            g.drawString("     Elevation", 285, 315);
            g.setColor(new Color(190, 200, 255));
            g.fillRect(355, 310, (int)(100F * ((float)(usercraft.elev[selected] + 3) / 5F)), 4);
            g.setColor(new Color(225, 225, 255));
            g.drawString("Light Speed Jumps:  " + usercraft.dnjm[selected], 285, 330);
        }
        if(fase == -1)
        {
            g.drawImage(mback, 0, 0, null);
            if(level == 15)
            {
                drawcs(g, 30, "Final Mission !", 255, 255, 255, true);
            } else
            {
                drawcs(g, 30, "Mission " + (level + 1), 255, 255, 255, true);
            }
            drawcs(g, 60, "Incoming Enemies:", 240, 240, 220, false);
            for(int i2 = 0; i2 < nb; i2++)
            {
                g.drawImage(lay, 79, 90 + 80 * i2, null);
                aconto[ob[i2]].d(g);
                aconto[ob[i2]].xz += 7 + i2;
                drawcs(g, 125 + 80 * i2, nam[i2], 0, 0, 0, false);
            }

            if(nb == 0)
            {
                drawcs(g, 180, "- Error loading mission " + (level + 1) + " -", 255, 255, 255, false);
                drawcs(g, 200, "Connection Error!", 255, 255, 255, false);
                drawcs(g, 280, "Click screen or Press Enter to continue >", 180, 180, 150, true);
            } else
            if(goodsun)
            {
                if(flik)
                {
                    drawcs(g, 110 + 80 * nb, "Click Screen to Continue >", 180, 180, 150, true);
                    flik = false;
                } else
                {
                    drawcs(g, 110 + 80 * nb, "Click Screen to Continue >", 255, 255, 240, true);
                    flik = true;
                }
            } else
            {
                drawcs(g, 110 + 80 * nb, "Click screen or Press Enter to continue >", 180, 180, 150, true);
            }
            if(!control.canclick)
            {
                control.canclick = true;
            }
            if(control.space)
            {
                control.canclick = false;
                if(nb != 0)
                {
                    for(int j2 = 0; j2 < nb; j2++)
                    {
                        aconto[ob[j2]].x = obx[j2];
                        aconto[ob[j2]].y = oby[j2];
                        aconto[ob[j2]].z = obz[j2];
                    }

                    fase = 0;
                } else
                {
                    fase = -5;
                    if(sgame == 1)
                    {
                        select = 1;
                    } else
                    {
                        select = 0;
                    }
                }
                control.space = false;
            }
        }
        if(fase == 1)
        {
            g.drawImage(mback, 0, 0, null);
            if(frst)
            {
                frst = false;
            }
            if(control.space)
            {
                fase = -3;
                control.space = false;
                drawcs(g, 230, "Loading Mission " + (level + 1) + " again...", 255, 255, 255, true);
            } else
            {
                if(!control.jade)
                {
                    drawcs(g, 250, "Don't forget to press the  [J]  key to escape lasers...", 225, 225, 225, false);
                }
                drawcs(g, 300, "Press Enter to continue", 225, 225, 225, false);
            }
        }
        if(fase == 2)
        {
            g.drawImage(mback, 0, 0, null);
            if(alldest())
            {
                drawcs(g, 180, "All your ships were destroyed!", 255, 255, 255, true);
            } else
            {
                drawcs(g, 180, "The mars station was destroyed!", 255, 255, 255, true);
            }
            drawcs(g, 320, "Press Enter to continue", 225, 225, 225, true);
            if(control.space)
            {
                fase = -5;
                if(alldest() && sgame == 1)
                {
                    select = 1;
                } else
                {
                    select = 0;
                }
                control.space = false;
            }
        }
        if(fase == 3)
        {
            g.drawImage(mback, 0, 0, null);
            drawcs(g, 163, "Resume Game", 255, 255, 255, false);
            drawcs(g, 183, "Game Controls", 255, 255, 255, false);
            drawcs(g, 203, "Quit Game", 255, 255, 255, false);
            if(flik)
            {
                g.setColor(new Color(255, 0, 0));
                flik = false;
            } else
            {
                g.setColor(new Color(0, 128, 255));
                flik = true;
            }
            g.drawRect(190, 153 + select * 20, 120, 11);
            if(control.down)
            {
                select++;
                control.down = false;
            }
            if(control.up)
            {
                select--;
                control.up = false;
            }
            if(select == 3)
            {
                select = 0;
            }
            if(select == -1)
            {
                select = 2;
            }
            if(control.space)
            {
                if(select == 1)
                {
                    fase = -7;
                    oldfase = 3;
                    control.space = false;
                }
                if(select == 2)
                {
                    fase = -5;
                    if(sgame == 1)
                    {
                        select = 1;
                    } else
                    {
                        select = 0;
                    }
                    control.space = false;
                }
            }
            drawcs(g, 354, "( use keyboard arrows to select )", 210, 210, 210, false);
        }
        if(fase == 5 || fase == 6 || fase == 7)
        {
            g.setColor(new Color(255, 255, 255));
            g.fillRect(80, 60, 340, 190);
            aconto[(int)(Math.random() * 5D)].d(g);
            int k2 = 0;
            do
            {
                aconto[k2].zy += 5;
                aconto[k2].xy--;
            } while(++k2 < 5);
            if(aconto[0].zy == 360)
            {
                aconto[0].zy = 0;
                g.setColor(new Color(255, 255, 0));
                int l2 = 0;
                do
                {
                    g.drawLine(l2 * 2, 0, l2 * 2, 360);
                } while(++l2 < 250);
            }
            g.drawImage(rad, 93, 32, null);
            if(fase == 5)
            {
                drawcs(g, 84, "Wild Polygons 3D engine by:", 0, 0, 0, false);
                drawcs(g, 96, "Omar Waly", 100, 100, 100, false);
                drawcs(g, 114, "3D models by:", 0, 0, 0, false);
                drawcs(g, 126, "Omar Waly", 100, 100, 100, false);
                drawcs(g, 144, "Game programming by:", 0, 0, 0, false);
                drawcs(g, 156, "Omar Waly", 100, 100, 100, false);
                drawcs(g, 174, "Graphics by:", 0, 0, 0, false);
                drawcs(g, 186, "Omar Waly", 100, 100, 100, false);
                drawcs(g, 204, "This version of the game was updated and is maintained by:", 0, 0, 0, false);
                drawcs(g, 216, "Jaroslav Paska (Phyrexian)", 100, 100, 100, false);
            }
            if(fase == 6)
            {
                drawcs(g, 80, "Music was obtained from FlashKit.com", 0, 0, 0, false);
                drawcs(g, 92, "and by the following artists:", 0, 0, 0, false);
                drawcs(g, 118, ".::Dj Hemp::.", 100, 100, 100, false);
                drawcs(g, 130, "Gen A Dee", 100, 100, 100, false);
                drawcs(g, 142, "Alex Volkmar", 100, 100, 100, false);
                drawcs(g, 154, "Empty", 100, 100, 100, false);
                drawcs(g, 166, "[BoD]Raven", 100, 100, 100, false);
                drawcs(g, 178, "Jeff Heysen", 100, 100, 100, false);
                drawcs(g, 190, "Degz", 100, 100, 100, false);
                drawcs(g, 202, "Justin Perkins", 100, 100, 100, false);
                drawcs(g, 214, "and Vika", 100, 100, 100, false);
            }
            if(fase == 7)
            {
                if(flik)
                {
                    drawcs(g, 140, "G a m e   C o m p l e t e !", 255, 0, 0, false);
                    flik = false;
                } else
                {
                    drawcs(g, 140, "G a m e   C o m p l e t e !", 0, 128, 255, true);
                    flik = true;
                }
                drawcs(g, 180, ">  Press Enter to continue  >", 150, 150, 150, false);
                cnt++;
                if(cnt > 140)
                {
                    control.space = true;
                }
            } else
            {
                drawcs(g, 246, "Press Enter to continue >", 150, 150, 150, false);
            }
            drawcs(g, 354, "Copyright \251 RadicalPlay.com", 255, 255, 255, true);
            if(control.space && fase != 7)
            {
                if(fase == 5)
                {
                    fase = 6;
                } else
                {
                    int i3 = 0;
                    do
                    {
                        aconto[i3].out = true;
                        aconto[i3].wire = false;
                    } while(++i3 < 5);
                    fase = -5;
                }
                control.space = false;
            }
        }
    }

    public void drawefimg(Image image)
    {
        saveit(image, pix);
        int i = 0;
        do
        {
            Color color = new Color(pix[i]);
            Color color1 = new Color(bpix[i]);
            int j = (color.getRed() + color1.getRed()) / 2;
            if(j > 225)
            {
                j = 225;
            }
            if(j < 0)
            {
                j = 0;
            }
            int k = (color.getGreen() + color1.getGreen()) / 2;
            if(k > 225)
            {
                k = 225;
            }
            if(k < 0)
            {
                k = 0;
            }
            int l = (color.getBlue() + color1.getBlue()) / 2;
            if(l > 225)
            {
                l = 225;
            }
            if(l < 0)
            {
                l = 0;
            }
            Color color2 = new Color(j, k, l);
            pix[i] = color2.getRGB();
        } while(++i < 0x2bf20);
        mback = createImage(new MemoryImageSource(500, 360, pix, 0, 500));
    }

    public boolean alldest()
    {
        int i = 0;
        int j = 0;
        do
        {
            if(dest[j])
            {
                i++;
            }
        } while(++j < 5);
        return i == 5;
    }

    public void drawpimg(Image image)
    {
        saveit(image, pix);
        int i = 0;
        do
        {
            int j = 0;
            do
            {
                Color color = new Color(pix[i + j * 500]);
                Color color1 = new Color(ppix[i + j * 500]);
                int k = 0;
                int l = 0;
                int i1 = 0;
                if(i > 150 && i < 350 && j > 130 && j < 230)
                {
                    k = (color.getRed() + color1.getRed()) / 4;
                    if(k > 225)
                    {
                        k = 225;
                    }
                    if(k < 0)
                    {
                        k = 0;
                    }
                    l = (color.getGreen() + color1.getGreen()) / 4;
                    if(l > 225)
                    {
                        l = 225;
                    }
                    if(l < 0)
                    {
                        l = 0;
                    }
                    i1 = (color.getBlue() + color1.getBlue()) / 4;
                    if(i1 > 225)
                    {
                        i1 = 225;
                    }
                    if(i1 < 0)
                    {
                        i1 = 0;
                    }
                } else
                {
                    k = (color.getRed() + color1.getRed()) / 2;
                    if(k > 225)
                    {
                        k = 225;
                    }
                    if(k < 0)
                    {
                        k = 0;
                    }
                    l = (color.getGreen() + color1.getGreen()) / 2;
                    if(l > 225)
                    {
                        l = 225;
                    }
                    if(l < 0)
                    {
                        l = 0;
                    }
                    i1 = (color.getBlue() + color1.getBlue()) / 2;
                    if(i1 > 225)
                    {
                        i1 = 225;
                    }
                    if(i1 < 0)
                    {
                        i1 = 0;
                    }
                }
                Color color2 = new Color(k, l, i1);
                pix[i + j * 500] = color2.getRGB();
            } while(++j < 360);
        } while(++i < 500);
        mback = createImage(new MemoryImageSource(500, 360, pix, 0, 500));
    }

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
        int i = 0;
        do
        {
            dest[i] = false;
        } while(++i < 5);
        level = 0;
    }

    public void creset()
    {
        cnt = 0;
        flik = false;
        cnts = 10;
        cntf = 0;
        left = false;
        wcnt = 0;
        rcnt = 0;
        cnty = 0;
    }

    public xtGraphics(Medium medium, Graphics g)
    {
        goodsun = false;
        cl = 1;
        as = new Image[5];
        pix = new int[0x2bf20];
        bpix = new int[0x2bf20];
        mpix = new int[0x2bf20];
        opix = new int[0x2bf20];
        ppix = new int[0x2bf20];
        cnt = 0;
        flik = false;
        cnts = 10;
        mname = new String[19];
        cnte = new int[19];
        cntf = 0;
        left = false;
        wcnt = 0;
        rcnt = 0;
        cnty = 0;
        fase = -8;
        selected = 4;
        select = 0;
        frst = false;
        oldfase = -5;
        nb = 0;
        ob = new int[3];
        nam = new String[3];
        tnk = new boolean[3];
        obx = new int[3];
        oby = new int[3];
        obz = new int[3];
        sgame = -1;
        level = 0;
        dest = new boolean[10];
        mcomp = false;
        tcnt = 1;
        m = medium;
        ftm = g.getFontMetrics();
    }

    public void saveit(Image image, int ai[])
    {
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, 500, 360, ai, 0, 500);
        try
        {
            pixelgrabber.grabPixels();
        }
        catch(InterruptedException _ex) { }
    }

    public int xs(int i, int j)
    {
        if(j < 10)
        {
            j = 10;
        }
        return ((j - m.focus_point) * (m.cx - i)) / j + i;
    }

    public int getcpy(ContO conto, ContO conto1)
    {
        return ((conto.x - conto1.x) / 100) * ((conto.x - conto1.x) / 100) + ((conto.y - conto1.y) / 100) * ((conto.y - conto1.y) / 100) + ((conto.z - conto1.z) / 100) * ((conto.z - conto1.z) / 100);
    }

    public void drawop(Graphics g, Image image)
    {
        saveit(image, pix);
        int i = 0;
        do
        {
            Color color = new Color(pix[i]);
            int j = Math.abs(255 - color.getRed());
            if(j > 255)
            {
                j = 255;
            }
            if(j < 0)
            {
                j = 0;
            }
            int k = Math.abs(255 - color.getGreen());
            if(k > 255)
            {
                k = 255;
            }
            if(k < 0)
            {
                k = 0;
            }
            int l = Math.abs(255 - color.getBlue());
            if(l > 255)
            {
                l = 255;
            }
            if(l < 0)
            {
                l = 0;
            }
            Color color1 = new Color(j, k, l);
            pix[i] = color1.getRGB();
        } while(++i < 0x2bf20);
        g.drawImage(createImage(new MemoryImageSource(500, 360, pix, 0, 500)), 0, 0, null);
    }

    public void cmback(int i)
    {
        int j = 0;
        do
        {
            int k = 0;
            do
            {
                pix[j + k * 500] = mpix[j + k * 500];
                for(int l = 0; l < i; l++)
                {
                    if(j > 82 && j < 416 && k > 95 + l * 80 && k < 147 + l * 80)
                    {
                        Color color = new Color(222, 184, 34);
                        Color color1 = new Color(pix[j + k * 500]);
                        int i1 = (color.getRed() + color1.getRed()) / 2;
                        if(i1 > 225)
                        {
                            i1 = 225;
                        }
                        if(i1 < 0)
                        {
                            i1 = 0;
                        }
                        int j1 = (color.getGreen() + color1.getGreen()) / 2;
                        if(j1 > 225)
                        {
                            j1 = 225;
                        }
                        if(j1 < 0)
                        {
                            j1 = 0;
                        }
                        int k1 = (color.getBlue() + color1.getBlue()) / 2;
                        if(k1 > 225)
                        {
                            k1 = 225;
                        }
                        if(k1 < 0)
                        {
                            k1 = 0;
                        }
                        Color color2 = new Color(i1, j1, k1);
                        pix[j + k * 500] = color2.getRGB();
                    }
                }

            } while(++k < 360);
        } while(++j < 500);
        mback = createImage(new MemoryImageSource(500, 360, pix, 0, 500));
    }

    public void drawl(Graphics g, Image image)
    {
        saveit(image, pix);
        int i = 0;
        do
        {
            Color color = new Color(pix[i]);
            int j = Math.abs((color.getRed() - 15) / 2);
            if(j > 225)
            {
                j = 225;
            }
            if(j < 0)
            {
                j = 0;
            }
            int k = Math.abs((color.getGreen() - 10) / 2);
            if(k > 225)
            {
                k = 225;
            }
            if(k < 0)
            {
                k = 0;
            }
            int l = Math.abs((color.getBlue() + 20) / 2);
            if(l > 225)
            {
                l = 225;
            }
            if(l < 0)
            {
                l = 0;
            }
            Color color1 = new Color(j, k, l);
            pix[i] = color1.getRGB();
        } while(++i < 0x2bf20);
        g.drawImage(createImage(new MemoryImageSource(500, 360, pix, 0, 500)), 0, 0, null);
    }

    public void drawovimg(Image image)
    {
        saveit(image, pix);
        int i = 0;
        do
        {
            Color color = new Color(pix[i]);
            Color color1 = new Color(opix[i]);
            int j = (int)(((double)color.getRed() / 1.7D + (double)color1.getRed()) / 2D);
            if(j > 225)
            {
                j = 225;
            }
            if(j < 0)
            {
                j = 0;
            }
            int k = (int)(((double)color.getGreen() / 1.7D + (double)color1.getGreen()) / 2D);
            if(k > 225)
            {
                k = 225;
            }
            if(k < 0)
            {
                k = 0;
            }
            int l = (int)(((double)color.getBlue() / 1.7D + (double)color1.getBlue()) / 2D);
            if(l > 225)
            {
                l = 225;
            }
            if(l < 0)
            {
                l = 0;
            }
            Color color2 = new Color(j, k, l);
            pix[i] = color2.getRGB();
        } while(++i < 0x2bf20);
        mback = createImage(new MemoryImageSource(500, 360, pix, 0, 500));
    }

    public void dtrakers(Graphics g, int ai[], int ai1[], int i, ContO aconto[], userCraft usercraft, Control control)
    {
        cl = 1;
        int j = getcpy(aconto[ai1[0]], aconto[ai1[1]]);
        for(int l = 2; l < i; l++)
        {
            if(j == 0 || aconto[ai1[cl]].exp)
            {
                cl = l;
                j = getcpy(aconto[ai1[0]], aconto[ai1[l]]);
            } else
            {
                int i1 = getcpy(aconto[ai1[0]], aconto[ai1[l]]);
                if((i1 > 0 || j == 0) && i1 < j && !aconto[ai1[l]].exp)
                {
                    j = i1;
                    cl = l;
                }
            }
        }

        int ai2[] = new int[4];
        int ai3[] = new int[4];
        boolean flag = false;
        boolean flag1 = false;
        int j1 = 0;
        for(int k1 = 1; k1 < i; k1++)
        {
            char c = '\u03E8';
            if(ai[k1] == 1)
            {
                c = '\u0FA0';
            }
            int k = getcpy(aconto[ai1[0]], aconto[ai1[k1]]);
            if(k > c && !aconto[ai1[k1]].exp)
            {
                int l2 = m.cx + (int)((float)(aconto[ai1[k1]].x - m.x - m.cx) * m.cs.getcos(m.xz) - (float)(aconto[ai1[k1]].z - m.z - m.cz) * m.cs.getsin(m.xz));
                int k3 = m.cz + (int)((float)(aconto[ai1[k1]].x - m.x - m.cx) * m.cs.getsin(m.xz) + (float)(aconto[ai1[k1]].z - m.z - m.cz) * m.cs.getcos(m.xz));
                int j4 = m.cz + (int)((float)(aconto[ai1[k1]].y - m.y - m.cy) * m.cs.getsin(m.zy) + (float)(k3 - m.cz) * m.cs.getcos(m.zy));
                if(j4 > 100)
                {
                    int i5 = m.cy + (int)((float)(aconto[ai1[k1]].y - m.y - m.cy) * m.cs.getcos(m.zy) - (float)(k3 - m.cz) * m.cs.getsin(m.zy));
                    int k5 = xs(l2, j4);
                    int i6 = ys(i5, j4);
                    if(k5 > 0 && k5 < m.w && i6 > 0 && i6 < m.h)
                    {
                        if(!flag && k != 0 && k < 10000)
                        {
                            flag = true;
                        }
                        if(ai[k1] == 0)
                        {
                            if(!aconto[ai1[k1]].fire)
                            {
                                g.setColor(new Color(164, 209, 255));
                            } else
                            {
                                g.setColor(new Color(164, 229, 255));
                            }
                        } else
                        if(!aconto[ai1[k1]].fire)
                        {
                            g.setColor(new Color(255, 150, 100));
                        } else
                        {
                            g.setColor(new Color(255, 180, 100));
                        }
                        ai2[0] = k5 - 10;
                        ai3[0] = i6 - 10;
                        ai2[1] = k5 + 10;
                        ai3[1] = i6 - 10;
                        ai2[2] = k5 + 10;
                        ai3[2] = i6 + 10;
                        ai2[3] = k5 - 10;
                        ai3[3] = i6 + 10;
                        g.drawPolygon(ai2, ai3, 4);
                    }
                }
            }
            if(aconto[ai1[k1]].exp)
            {
                if(cnte[k1 - 1] < 20 && !flag1)
                {
                    if(cntf < 2)
                    {
                        if(aconto[ai1[k1]].nhits >= aconto[ai1[k1]].maxhits)
                        {
                            drawcs(g, 120, mname[k1 - 1] + " distroyd!", 255, 255, 128, false);
                        } else
                        {
                            drawcs(g, 120, mname[k1 - 1] + " Crashed!", 255, 255, 128, false);
                        }
                    } else
                    if(aconto[ai1[k1]].nhits >= aconto[ai1[k1]].maxhits)
                    {
                        drawcs(g, 120, mname[k1 - 1] + " distroyd!", 186, 223, 57, false);
                    } else
                    {
                        drawcs(g, 120, mname[k1 - 1] + " Crashed!", 186, 223, 57, false);
                    }
                    if(cntf < 2)
                    {
                        cntf++;
                    } else
                    {
                        cntf = 0;
                    }
                    cnte[k1 - 1]++;
                    flag1 = true;
                } else
                {
                    j1++;
                }
            }
        }

        if(!mcomp && j1 == i - 1)
        {
            mcomp = true;
            select = 0;
        }
        if(mcomp && !aconto[ai1[0]].exp)
        {
            if(rcnt == 0)
            {
                rcnt = 1;
            } else
            {
                g.setColor(new Color(50 + (int)(Math.random() * 200D), 50 + (int)(Math.random() * 200D), 50 + (int)(Math.random() * 200D)));
                g.fillRect(110, 67, 270, 13);
                rcnt = 0;
            }
            g.drawImage(complete, 105, 60, null);
            drawcs(g, 300, "Press Enter to continue", 0, 0, 0, false);
        }
        if(!flag && !aconto[ai1[cl]].exp)
        {
            boolean flag2 = false;
            int j2 = m.cx + (int)((float)(aconto[ai1[cl]].x - m.x - m.cx) * m.cs.getcos(m.xz) - (float)(aconto[ai1[cl]].z - m.z - m.cz) * m.cs.getsin(m.xz));
            int i3 = m.cz + (int)((float)(aconto[ai1[cl]].x - m.x - m.cx) * m.cs.getsin(m.xz) + (float)(aconto[ai1[cl]].z - m.z - m.cz) * m.cs.getcos(m.xz));
            int l3 = m.cz + (int)((float)(aconto[ai1[cl]].y - m.y - m.cy) * m.cs.getsin(m.zy) + (float)(i3 - m.cz) * m.cs.getcos(m.zy));
            int k4 = m.cy + (int)((float)(aconto[ai1[cl]].y - m.y - m.cy) * m.cs.getcos(m.zy) - (float)(i3 - m.cz) * m.cs.getsin(m.zy));
            int j5 = ys(k4, l3);
            int l5 = xs(j2, l3);
            if(l5 < m.w && l5 > 0)
            {
                if(j5 > m.h || j5 < 0)
                {
                    if(l5 > m.w - 10)
                    {
                        l5 = m.w - 50;
                    }
                    if(l5 < 5)
                    {
                        l5 = 50;
                    }
                    if(k4 > m.cy)
                    {
                        ai2[0] = l5;
                        ai3[0] = m.h - 1;
                        ai2[1] = l5 - 5;
                        ai3[1] = m.h - 20;
                        ai2[2] = l5 + 5;
                        ai3[2] = m.h - 20;
                        flag2 = true;
                    } else
                    {
                        ai3[0] = 1;
                        ai2[0] = l5;
                        ai3[1] = 20;
                        ai2[1] = l5 - 5;
                        ai3[2] = 20;
                        ai2[2] = l5 + 5;
                        flag2 = true;
                    }
                }
            } else
            {
                if(j5 > m.h - 10)
                {
                    j5 = m.h - 50;
                }
                if(j5 < 5)
                {
                    j5 = 50;
                }
                if(j2 > m.cx)
                {
                    ai2[0] = m.w - 1;
                    ai3[0] = j5;
                    ai2[1] = m.w - 20;
                    ai3[1] = j5 - 5;
                    ai2[2] = m.w - 20;
                    ai3[2] = j5 + 5;
                    flag2 = true;
                } else
                {
                    ai2[0] = 1;
                    ai3[0] = j5;
                    ai2[1] = 20;
                    ai3[1] = j5 - 5;
                    ai2[2] = 20;
                    ai3[2] = j5 + 5;
                    flag2 = true;
                }
            }
            if(flag2)
            {
                if(ai[cl] == 0)
                {
                    g.setColor(new Color(164, 209, 255));
                } else
                {
                    g.setColor(new Color(255, 180, 100));
                }
                g.fillPolygon(ai2, ai3, 3);
            }
        }
        if(aconto[ai1[0]].nhits > aconto[ai1[0]].maxhits - aconto[ai1[0]].maxhits / 3 && !aconto[ai1[0]].exp && !mcomp)
        {
            if(cnt > 90)
            {
                if(flik)
                {
                    drawcs(g, 300, "Recharge Ship !", 255, 255, 255, false);
                    flik = false;
                } else
                {
                    drawcs(g, 300, "Recharge Ship !", 200, 200, 200, false);
                    flik = true;
                }
            } else
            {
                drawcs(g, 300, "Damage Critical", 255, 0, 0, false);
            }
            cnt++;
            if(cnt == 130)
            {
                cnt = 0;
            }
        }
        if(control.jump >= 1 && usercraft.njumps == 0)
        {
            drawcs(g, 330, "Light speed jumps expired - Recharge Ship !", 255, 255, 255, false);
            control.jump++;
            if(control.jump == 40)
            {
                control.jump = 0;
            }
        }
        if(usercraft.ester != 0 && !aconto[ai1[0]].exp && !mcomp)
        {
            drawcs(g, 300, "Ship Recharged !", 255 * m.er, 255 - m.eg * 100, 64 + m.eb * 191, false);
        }
        if(control.radar && !mcomp)
        {
            g.drawImage(radar, 200, 60, null);
            int l1 = aconto[ai1[0]].zy;
            int k2 = -aconto[ai1[0]].xz;
            for(; l1 > 360; l1 -= 360) { }
            for(; l1 < 0; l1 += 360) { }
            if(l1 > 90 && l1 < 270)
            {
                k2 += 180;
            }
            for(int j3 = 1; j3 < i; j3++)
            {
                if(!aconto[ai1[j3]].exp)
                {
                    int i4 = m.cx + (int)((float)(aconto[ai1[j3]].x - m.x - m.cx) * m.cs.getcos(k2) - (float)(aconto[ai1[j3]].z - m.z - m.cz) * m.cs.getsin(k2));
                    int l4 = m.cz + (int)((float)(aconto[ai1[j3]].x - m.x - m.cx) * m.cs.getsin(k2) + (float)(aconto[ai1[j3]].z - m.z - m.cz) * m.cs.getcos(k2));
                    g.setColor(new Color(0, 255, 128));
                    i4 = i4 / 400 + 249;
                    l4 = -l4 / 400 + 109;
                    if(i4 < 204)
                    {
                        i4 = 204;
                    }
                    if(i4 > 296)
                    {
                        i4 = 296;
                    }
                    if(l4 < 64)
                    {
                        l4 = 64;
                    }
                    if(l4 > 156)
                    {
                        l4 = 156;
                    }
                    g.fillRect(i4, l4, 2, 2);
                }
            }

        }
        if(control.plus || control.mins || cnts < 10)
        {
            g.setColor(new Color(0, 0, 0));
            g.drawString("" + usercraft.rspeed + " zic/tes", 50, 55);
            g.drawImage(stube, 50, 60, null);
            int i2 = (int)(260F - (float)usercraft.rspeed * (200F / (float)usercraft.maxspeed[usercraft.ltyp]));
            g.setColor(new Color(255, i2 - 10, 0));
            g.fillRect(61, i2, 12, 260 - i2);
            if(control.plus || control.mins)
            {
                cnts = 0;
            } else
            {
                cnts++;
            }
        }
        if(tcnt != 0)
        {
            if(usercraft.rspeed == 0)
            {
                tcnt++;
            } else
            {
                tcnt = 0;
            }
            if(!control.space)
            {
                if(tcnt > 90)
                {
                    drawcs(g, 80, "Press Enter for game controls and to pause game!", 255, 255, 255, false);
                }
            } else
            {
                tcnt = 0;
            }
        }
    }

    public void drawcs(Graphics g, int i, String s, int j, int k, int l, boolean flag)
    {
        if(flag)
        {
            g.setColor(new Color(0, 0, 0));
            g.drawString(s, (250 - ftm.stringWidth(s) / 2) + 1, i + 1);
        }
        g.setColor(new Color(j, k, l));
        g.drawString(s, 250 - ftm.stringWidth(s) / 2, i);
    }
}
