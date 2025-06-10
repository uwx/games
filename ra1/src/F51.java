import java.applet.*;
import java.awt.*;
import java.awt.Desktop.Action;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class F51 extends Panel
    implements Runnable
{

    Graphics rd;
    Image offImage;
    Thread gamer;
    boolean mon;
    String moner;
    String obj[];
    String sndfrm;
    boolean nounif;
    Control u;
    boolean tab;
    int view;
    int maxco;
    int maxmo;
    Clip upl;
    Clip low;
    Clip med;
    Clip downl;
    Clip ljump;
    Clip grnd;
    Clip exp;
    Clip exph;
    Clip hit;
    Clip hitl;
    Clip charged;
    Clip into;
    Clip miso;
    Clip mano;
    Clip selo;
    Clip las[];
    Clip mtrak[];
    boolean loadet[];
    boolean plow;
    boolean pmed;
    boolean pexph;
    boolean pint;
    boolean pmis;
    boolean pman;
    boolean psel;
    boolean nomusic;
    boolean nosound;
    boolean enterd;
    boolean sosun;
    int pgrnd;
    int pdownl;
    int pupl;
    int lascnt;
    int crntt;
    int plcnt;
    int frags;
    int dnload;

    Set<Integer> viewOneKeys = new HashSet<>();
    Set<Integer> viewTwoKeys = new HashSet<>();
    Set<Integer> viewThreeKeys = new HashSet<>();
    Set<Integer> viewFourKeys = new HashSet<>();
    Set<Integer> viewFiveKeys = new HashSet<>();
    Set<Integer> nomusicKeys = new HashSet<>();
    Set<Integer> switchmusicKeys = new HashSet<>();
    Set<Integer> nosoundKeys = new HashSet<>();
    Set<Integer> radarKeys = new HashSet<>();
    Set<Integer> tabKeys = new HashSet<>();
    Set<Integer> plusKeys = new HashSet<>();
    Set<Integer> minsKeys = new HashSet<>();
    Set<Integer> jumpKeys = new HashSet<>();
    Set<Integer> enterKeys = new HashSet<>();
    Set<Integer> fireKeys = new HashSet<>();
    Set<Integer> leftKeys = new HashSet<>();
    Set<Integer> rightKeys = new HashSet<>();
    Set<Integer> downKeys = new HashSet<>();
    Set<Integer> upKeys = new HashSet<>();
    
    Set<Integer> viewOnePressedKeys = new HashSet<>();
    Set<Integer> viewTwoPressedKeys = new HashSet<>();
    Set<Integer> viewThreePressedKeys = new HashSet<>();
    Set<Integer> viewFourPressedKeys = new HashSet<>();
    Set<Integer> viewFivePressedKeys = new HashSet<>();
    Set<Integer> radarPressedKeys = new HashSet<>();
    Set<Integer> plusPressedKeys = new HashSet<>();
    Set<Integer> minsPressedKeys = new HashSet<>();
    Set<Integer> enterPressedKeys = new HashSet<>();
    Set<Integer> tabPressedKeys = new HashSet<>();
    Set<Integer> firePressedKeys = new HashSet<>();
    Set<Integer> leftPressedKeys = new HashSet<>();
    Set<Integer> rightPressedKeys = new HashSet<>();
    Set<Integer> downPressedKeys = new HashSet<>();
    Set<Integer> upPressedKeys = new HashSet<>();
    
    
    public void stop()
    {
        into.stop();
        miso.stop();
        selo.stop();
        mano.stop();
        upl.stop();
        downl.stop();
        low.stop();
        med.stop();
        ljump.stop();
        grnd.stop();
        exp.stop();
        exph.stop();
        hit.stop();
        hitl.stop();
        charged.stop();
        int i = 0;
        do
        {
            las[i].stop();
        } while(++i < 5);
        i = 0;
        do
        {
            if(loadet[i])
            {
                mtrak[i].stop();
            }
        } while(++i < 7);
        if(gamer != null)
        {
            gamer.stop();
        }
        gamer = null;
        rd.dispose();
    }

    public boolean lostFocus(Event event, Object obj1)
    {
        if(!nounif)
        {
            mon = true;
        }
        if(maxmo != -1)
        {
            view = 0;
            u.radar = false;
            u.plus = false;
            u.mins = false;
            enterd = false;
            tab = false;
            u.fire = false;
            u.left = false;
            u.right = false;
            u.down = false;
            u.up = false;
        }
        return false;
    }

    public void playsounds(userCraft usercraft, ContO conto, boolean flag, xtGraphics xtgraphics)
    {
        if(!flag)
        {
            if(!nosound)
            {
                if(!conto.exp && usercraft.speed > 10F && !pmed)
                {
                    if(!plow)
                    {
                        low.loop(Clip.LOOP_CONTINUOUSLY);
                        plow = true;
                    }
                } else
                if(plow)
                {
                    low.stop();
                    plow = false;
                }
                if(usercraft.speed > 65F)
                {
                    if(!pmed)
                    {
                        med.loop(Clip.LOOP_CONTINUOUSLY);
                        pmed = true;
                    }
                } else
                if(pmed)
                {
                    med.stop();
                    pmed = false;
                }
                if(usercraft.speed > 65F && u.up)
                {
                    if(pupl == 0)
                    {
                        pupl = 70;
                        upl.setFramePosition(0);
                        upl.start();
                    }
                } else
                if(pupl != 0)
                {
                    pupl--;
                }
                if(usercraft.speed > 65F && u.down)
                {
                    if(pdownl == 0)
                    {
                        pdownl = 70;
                        downl.setFramePosition(0);
                        downl.start();
                    }
                } else
                if(pdownl != 0)
                {
                    pdownl--;
                }
                if(usercraft.speed == 400F)
                {
                    ljump.setFramePosition(0);
                    ljump.start();
                }
                if(usercraft.ester == 1)
                {
                    charged.setFramePosition(0);
                    charged.start();
                }
                if(conto.hit && frags == 0)
                {
                    hit.setFramePosition(0);
                    hit.start();
                    if(sosun)
                    {
                        frags = 3;
                    }
                }
                if(sosun && frags != 0)
                {
                    frags--;
                }
                if(u.fire && !conto.exp)
                {
                    if(lascnt == 0)
                    {
                        las[usercraft.ltyp].setFramePosition(0);
                        las[usercraft.ltyp].start();
                        lascnt = 14;
                    } else
                    {
                        lascnt--;
                    }
                } else
                if(lascnt != 0)
                {
                    lascnt = 0;
                }
                if(pgrnd == 0)
                {
                    if(!conto.exp && conto.y > 200 && (usercraft.sms[0] == 1 || usercraft.sms[1] == 1 || usercraft.sms[2] == 1 || usercraft.sms[3] == 1))
                    {
                        grnd.setFramePosition(0);
                        grnd.start();
                        pgrnd = 2;
                    }
                } else
                {
                    pgrnd--;
                }
                if(conto.exp)
                {
                    if(!pexph)
                    {
                        exph.setFramePosition(0);
                        exph.start();
                        pexph = true;
                        //shake();
                    }
                } else
                if(pexph)
                {
                    pexph = false;
                }
            } else
            {
                if(pmed)
                {
                    med.stop();
                    pmed = false;
                }
                if(plow)
                {
                    low.stop();
                    plow = false;
                }
            }
            if(psel)
            {
                selo.stop();
                psel = false;
            }
            if(plcnt == 100)
            {
                crntt++;
                if(crntt == 7)
                {
                    crntt = 0;
                }
                if(loadet[crntt])
                {
                    mtrak[crntt].loop(Clip.LOOP_CONTINUOUSLY);
                } else
                {
                    crntt = -1;
                    int i = 6;
                    do
                    {
                        if(loadet[i])
                        {
                            crntt = i;
                        }
                    } while(--i >= 0);
                    if(crntt != -1)
                    {
                        mtrak[crntt].loop(Clip.LOOP_CONTINUOUSLY);
                    }
                }
            }
            if(plcnt != 2000)
            {
                if(!nomusic)
                {
                    plcnt++;
                }
            } else
            {
                plcnt = 80;
                mtrak[crntt].stop();
            }
        } else
        {
            if(pmed)
            {
                med.stop();
                pmed = false;
            }
            if(plow)
            {
                low.stop();
                plow = false;
            }
            if(plcnt != 0 && crntt != -1 && xtgraphics.fase != -4 && xtgraphics.fase != 1 && xtgraphics.fase != 2)
            {
                if(plcnt >= 100)
                {
                    mtrak[crntt].stop();
                }
                if(xtgraphics.fase == 3 && plcnt >= 100)
                {
                    crntt--;
                }
                plcnt = 0;
            }
            if(xtgraphics.fase == -8 && xtgraphics.cnty < 351 && !nomusic)
            {
                if(!pint)
                {
                    into.loop(Clip.LOOP_CONTINUOUSLY);
                    pint = true;
                }
            } else
            {
                if(pint)
                {
                    into.stop();
                    pint = false;
                }
                if(xtgraphics.cnty == 352)
                {
                    hit.setFramePosition(0);
                    hit.start();
                    xtgraphics.cnty = 353;
                }
            }
            if((xtgraphics.fase == -5 || xtgraphics.fase == 7) && !nomusic)
            {
                if(!pman)
                {
                    mano.loop(Clip.LOOP_CONTINUOUSLY);
                    pman = true;
                }
            } else
            if(pman)
            {
                mano.stop();
                pman = false;
            }
            if(xtgraphics.fase == -1 && !nomusic)
            {
                if(!pmis)
                {
                    miso.loop(Clip.LOOP_CONTINUOUSLY);
                    pmis = true;
                }
            } else
            if(pmis)
            {
                miso.stop();
                pmis = false;
            }
            if((xtgraphics.fase == 0 || xtgraphics.fase == 5 || xtgraphics.fase == 6) && !nomusic)
            {
                if(!psel)
                {
                    selo.loop(Clip.LOOP_CONTINUOUSLY);
                    psel = true;
                }
            } else
            if(psel)
            {
                selo.stop();
                psel = false;
            }
            if(xtgraphics.fase == 7)
            {
                if(pupl == 0)
                {
                    pupl = 30;
                    upl.setFramePosition(0);
                    upl.start();
                } else
                {
                    pupl--;
                }
            }
        }
    }

    private Clip getSound(String s)
    {
        Clip clip = null;
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("/app/games/ra1/" + s));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clip;
    }

    public String getstring(String s, String s1, int i)
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

        return s3;
    }

    public int getint(String s, String s1, int i)
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

    public void paint(Graphics g)
    {
        g.drawImage(offImage, 0, 0, this);
    }

    public F51()
    {
        mon = true;
        moner = "Click here to Start";
        obj = new String[53];
        sndfrm = "default";
        nounif = false;
        u = new Control();
        tab = false;
        view = 0;
        maxco = 0;
        maxmo = -1;
        las = new Clip[5];
        mtrak = new Clip[7];
        loadet = new boolean[7];
        plow = false;
        pmed = false;
        pexph = false;
        pint = false;
        pmis = false;
        pman = false;
        psel = false;
        nomusic = false;
        nosound = false;
        enterd = false;
        sosun = false;
        pgrnd = 0;
        pdownl = 0;
        pupl = 0;
        lascnt = 0;
        crntt = -1;
        plcnt = 0;
        frags = 0;
        dnload = 0;
    }

    public void savegame(ContO aconto[], xtGraphics xtgraphics, int i)
    {
        try
        {
            savecookie("radxv", String.valueOf(xtgraphics.level));
            for(int j = i; j < i + 13; j++)
            {
                savecookie("radnhits" + String.valueOf(j), String.valueOf(aconto[j].nhits));
            }

            int k = 0;
            do
            {
                savecookie("raddest" + String.valueOf(k), String.valueOf(xtgraphics.dest[k] ? 1 : 0));
            } while(++k < 5);
            xtgraphics.sgame = 1;
        }
        catch(Exception _ex) { }
    }

    public void destroy()
    {
        if(gamer != null)
        {
            gamer.stop();
        }
        gamer = null;
    }

    public void loadrots(ContO aconto[], boolean flag)
    {
        for(int i = 0; i < maxco; i++)
        {
            aconto[i].loadrots(flag);
        }

    }
    
    private Image getImage(String s) {
        Image image = null;
        try {
            image = ImageIO.read(new File("/app/games/ra1/" + s));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }

    public void loadbase(ContO aconto[], Medium medium)
    {
        try
        {
            File file = new File("/app/games/ra1/graphics/models.zrad");
            DataInputStream datainputstream = new DataInputStream(new FileInputStream(file));
            ZipInputStream zipinputstream = new ZipInputStream(datainputstream);
            ZipEntry zipentry = zipinputstream.getNextEntry();
            Object obj1 = null;
            int i = 0;
            for(; zipentry != null; zipentry = zipinputstream.getNextEntry())
            {
                int j = (int)zipentry.getSize();
                byte abyte0[] = new byte[j];
                int k = 0;
                int l;
                for(; j > 0; j -= l)
                {
                    l = zipinputstream.read(abyte0, k, j);
                    k += l;
                }

                aconto[i] = new ContO(abyte0, medium, 0, 0, 0);
                obj[i] = zipentry.getName();
                i++;
            }

            zipinputstream.close();
            datainputstream.close();
        }
        catch(Exception exception)
        {
            System.out.println("Error Reading Models: " + exception);
        }
        System.gc();
    }

    public void update(Graphics g)
    {
        paint(g);
    }

    public void loadmovers(int ai[], int ai1[], ContO aconto[], Craft acraft[], Tank atank[], userCraft usercraft, xtGraphics xtgraphics)
    {
        for(int i = 1; i < maxmo; i++)
        {
            aconto[ai[i]].out = true;
        }

        maxmo = 1;
        xtgraphics.nb = 0;
        xtgraphics.mcomp = false;
        try
        {
            File file = new File("/app/games/ra1/levels/" + xtgraphics.level + ".txt");
            DataInputStream datainputstream = new DataInputStream(new FileInputStream(file));
            String s;
            while((s = datainputstream.readLine()) != null) 
            {
                String s1 = "" + s.trim();
                if(s1.startsWith("craft"))
                {
                    ai[maxmo] = getint("craft", s1, 0);
                    ai1[maxmo] = 0;
                }
                if(s1.startsWith("tank"))
                {
                    ai[maxmo] = getint("tank", s1, 0);
                    ai1[maxmo] = 1;
                }
                if(s1.startsWith("name"))
                {
                    xtgraphics.mname[maxmo - 1] = getstring("name", s1, 0);
                    xtgraphics.cnte[maxmo - 1] = 0;
                }
                if(s1.startsWith("l"))
                {
                    aconto[ai[maxmo]].x = getint("l", s1, 0) * 10;
                    aconto[ai[maxmo]].y = getint("l", s1, 1) * 10;
                    aconto[ai[maxmo]].z = getint("l", s1, 2) * 10;
                    aconto[ai[maxmo]].out = false;
                    aconto[ai[maxmo]].reset();
                }
                if(s1.startsWith("prompt"))
                {
                    if(getstring("prompt", s1, 0).equals("tank"))
                    {
                        xtgraphics.tnk[xtgraphics.nb] = true;
                    } else
                    {
                        xtgraphics.tnk[xtgraphics.nb] = false;
                    }
                    xtgraphics.ob[xtgraphics.nb] = getint("prompt", s1, 1);
                    xtgraphics.nam[xtgraphics.nb] = getstring("prompt", s1, 2).replace('|', ',');
                    xtgraphics.nb++;
                }
                if(s1.startsWith("stat"))
                {
                    if(ai1[maxmo] == 0)
                    {
                        acraft[maxmo].reset(getint("stat", s1, 0), getint("stat", s1, 1), getint("stat", s1, 2), getint("stat", s1, 3), getint("stat", s1, 4), getint("stat", s1, 5));
                    } else
                    {
                        atank[maxmo].reset(getint("stat", s1, 0), getint("stat", s1, 1));
                    }
                    maxmo++;
                }
            }
            datainputstream.close();
        }
        catch(Exception _ex) { }
        System.gc();
    }

    public void set0()
    {
        try
        {
            savecookie("radxv", "0");
        }
        catch(Exception _ex) { }
    }

    public boolean keyUp(Event event, int i)
    {
        if (viewOnePressedKeys.contains(i)) {
            viewOnePressedKeys.remove(i);
            if (viewOnePressedKeys.isEmpty() && view == 1)
                view = 0;
        }
        if (viewTwoPressedKeys.contains(i)) {
            viewTwoPressedKeys.remove(i);
            if (viewTwoPressedKeys.isEmpty() && view == 2)
                view = 0;
        }
        if (viewThreePressedKeys.contains(i)) {
            viewThreePressedKeys.remove(i);
            if (viewThreePressedKeys.isEmpty() && view == 3)
                view = 0;
        }
        if (viewFourPressedKeys.contains(i)) {
            viewFourPressedKeys.remove(i);
            if (viewFourPressedKeys.isEmpty() && view == 4)
                view = 0;
        }
        if (viewFivePressedKeys.contains(i)) {
            viewFivePressedKeys.remove(i);
            if (viewFivePressedKeys.isEmpty() && view == 5)
                view = 0;
        }
        if(radarPressedKeys.contains(i))
        {
            radarPressedKeys.remove(i);
            if(radarPressedKeys.isEmpty())
                u.radar = false;
        }
        if(plusPressedKeys.contains(i))
        {
            plusPressedKeys.remove(i);
            if(plusPressedKeys.isEmpty())
                u.plus = false;
        }
        if(minsPressedKeys.contains(i))
        {
            minsPressedKeys.remove(i);
            if(minsPressedKeys.isEmpty())
                u.mins = false;
        }
        if(enterKeys.contains(i))
        {
            enterPressedKeys.remove(i);
            if(enterPressedKeys.isEmpty())
                enterd = false;
        }
        if(tabPressedKeys.contains(i))
        {
            tabPressedKeys.remove(i);
            if(tabPressedKeys.isEmpty())
                tab = false;
        }
        if(firePressedKeys.contains(i))
        {
            firePressedKeys.remove(i);
            if(firePressedKeys.isEmpty())
                u.fire = false;
        }
        if(leftPressedKeys.contains(i))
        {
            leftPressedKeys.remove(i);
            if(leftPressedKeys.isEmpty())
                u.left = false;
        }
        if(rightPressedKeys.contains(i))
        {
            rightPressedKeys.remove(i);
            if(rightPressedKeys.isEmpty())
                u.right = false;
        }
        if(downPressedKeys.contains(i))
        {
            downPressedKeys.remove(i);
            if(downPressedKeys.isEmpty())
                u.down = false;
        }
        if(upPressedKeys.contains(i))
        {
            upPressedKeys.remove(i);
            if(upPressedKeys.isEmpty())
                u.up = false;
        }
        return false;
    }

    public void start()
    {
        if(gamer == null)
        {
            gamer = new Thread(this);
        }
        gamer.start();
    }

    public void downloadall(xtGraphics xtgraphics)
    {
        xtgraphics.radar = getImage("graphics/radar.gif");
        lstat("Loading Images...", 1);
        xtgraphics.stube = getImage("graphics/stube.gif");
        lstat("Loading Images...", 2);
        xtgraphics.sback = getImage("graphics/select.jpg");
        lstat("Loading Images...", 18);
        xtgraphics.destr = getImage("graphics/destroyed.gif");
        lstat("Loading Images...", 2);
        xtgraphics.saveit(getImage("graphics/failed.jpg"), xtgraphics.bpix);
        lstat("Loading Images...", 31);
        xtgraphics.saveit(getImage("graphics/mission.jpg"), xtgraphics.mpix);
        lstat("Loading Images...", 22);
        xtgraphics.saveit(getImage("graphics/over.jpg"), xtgraphics.opix);
        lstat("Loading Images...", 21);
        xtgraphics.saveit(getImage("graphics/paused.jpg"), xtgraphics.ppix);
        lstat("Loading Images...", 10);
        xtgraphics.lay = getImage("graphics/layout.gif");
        lstat("Loading Images...", 1);
        xtgraphics.complete = getImage("graphics/comp.gif");
        lstat("Loading Images...", 2);
        xtgraphics.main = getImage("graphics/main.gif");
        lstat("Loading Images...", 32);
        xtgraphics.rad = getImage("graphics/radicalplay.gif");
        lstat("Loading Images...", 2);
        int i = 0;
        do
        {
            xtgraphics.as[i] = getImage("graphics/a" + i + ".gif");
            lstat("Loading Images...", 1);
        } while(++i < 5);
        xtgraphics.inst1 = getImage("graphics/inst1.gif");
        lstat("Loading Images...", 10);
        xtgraphics.inst2 = getImage("graphics/inst2.gif");
        lstat("Loading Images...", 11);
        xtgraphics.inst3 = getImage("graphics/inst3.gif");
        lstat("Loading Images...", 4);
        xtgraphics.text = getImage("graphics/text.gif");
        lstat("Loading Images...", 6);
        xtgraphics.mars = getImage("graphics/mars.jpg");
        lstat("Loading Images...", 15);
        into = getSound("music/intro.wav");
        lstat("Loading Music...", 24);
        miso = getSound("music/mission.wav");
        lstat("Loading Music...", 29);
        selo = getSound("music/select.wav");
        lstat("Loading Music...", 52);
        mano = getSound("music/main.wav");
        lstat("Loading Music...", 50);
        upl = getSound("sounds/" + sndfrm + "/up.wav");
        lstat("Loading Sound Effects...", 11);
        hitl = getSound("sounds/" + sndfrm + "/hitl.wav");
        lstat("Loading Sound Effects...", 7);
        downl = getSound("sounds/" + sndfrm + "/down.wav");
        lstat("Loading Sound Effects...", 10);
        low = getSound("sounds/" + sndfrm + "/low.wav");
        lstat("Loading Sound Effects...", 11);
        med = getSound("sounds/" + sndfrm + "/med.wav");
        lstat("Loading Sound Effects...", 6);
        ljump = getSound("sounds/" + sndfrm + "/jump.wav");
        lstat("Loading Sound Effects...", 25);
        grnd = getSound("sounds/" + sndfrm + "/grnd.wav");
        lstat("Loading Sound Effects...", 5);
        exp = getSound("sounds/" + sndfrm + "/exp.wav");
        lstat("Loading Sound Effects...", 10);
        exph = getSound("sounds/" + sndfrm + "/exph.wav");
        lstat("Loading Sound Effects...", 12);
        hit = getSound("sounds/" + sndfrm + "/hit.wav");
        lstat("Loading Sound Effects...", 25);
        i = 0;
        do
        {
            las[i] = getSound("sounds/" + sndfrm + "/l" + i + ".wav");
            lstat("Loading Sound Effects...", 9);
        } while(++i < 5);
        charged = getSound("sounds/" + sndfrm + "/charged.wav");
        lstat("Loading Sound Effects...", 12);
    }

    public boolean mouseDown(Event event, int i, int j)
    {
        if(maxmo != -1)
        {
            mon = false;
            if(moner.equals("Click here to Start"))
            {
                moner = "Click here to Continue";
            }
        }
        if(u.canclick)
        {
            u.space = true;
        }
        return true;
    }

    public void setmover(int ai[], ContO aconto[], userCraft usercraft, xtGraphics xtgraphics)
    {
        int i = 0;
        do
        {
            aconto[i].out = true;
            aconto[i].wire = false;
        } while(++i < 5);
        ai[0] = xtgraphics.selected;
        aconto[ai[0]].x = 3000;
        aconto[ai[0]].y = 250;
        aconto[ai[0]].z = -500;
        aconto[ai[0]].out = false;
        usercraft.reset(ai[0]);
        aconto[ai[0]].reset();
        aconto[ai[0]].xz = 360;
        u.jump = 0;
        xtgraphics.creset();
    }

    public void loadobjects(ContO aconto[], ContO aconto1[], Medium medium, String s)
    {
        try
        {
            File file = new File("/app/games/ra1/siters/" + s + ".txt");
            DataInputStream datainputstream = new DataInputStream(new FileInputStream(file));
            boolean flag = false;
            String s1;
            while((s1 = datainputstream.readLine()) != null) 
            {
                String s2 = "" + s1.trim();
                if(s2.startsWith("l"))
                {
                    String s3 = getstring("l", s2, 0);
                    int i;
                    int j;
                    int k;
                    if(!flag)
                    {
                        i = getint("l", s2, 1) * 10;
                        j = getint("l", s2, 2) * 10;
                        k = getint("l", s2, 3) * 10;
                    } else
                    {
                        i = getint("l", s2, 1);
                        j = getint("l", s2, 2);
                        k = getint("l", s2, 3);
                    }
                    int l = 0;
                    do
                    {
                        if(obj[l].equals(s3 + ".rad"))
                        {
                            aconto[maxco] = new ContO(medium, aconto1[l], i, j, k);
                            maxco++;
                        }
                    } while(++l < 53);
                }
                if(s2.startsWith("xy"))
                {
                    aconto[maxco - 1].xy = getint("xy", s2, 0);
                }
                if(s2.startsWith("xz"))
                {
                    aconto[maxco - 1].xz = getint("xz", s2, 0);
                }
                if(s2.startsWith("zy"))
                {
                    aconto[maxco - 1].zy = getint("zy", s2, 0);
                }
                if(s2.startsWith("xmult"))
                {
                    if(flag)
                    {
                        flag = false;
                    } else
                    {
                        flag = true;
                    }
                }
            }
            datainputstream.close();
        }
        catch(Exception _ex) { }
        System.gc();
    }

    public void run()
    {
        gamer.setPriority(10);
        Medium medium = new Medium();
        xtGraphics xtgraphics = new xtGraphics(medium, rd);
        int i = 5;
        String s = System.getProperty("java.version");
        String s1 = "";
        if(s1.startsWith("sun."))
        {
            if(s.startsWith("1.3"))
            {
                xtgraphics.goodsun = true;
            } else
            if(s.startsWith("1.4"))
            {
                sosun = true;
            } else
            {
                sosun = true;
                sndfrm = "newsun";
            }
            i = 15;
        }
        lstat("Preparing for loading...", 0);
        ContO aconto[] = new ContO[53];
        ContO aconto1[] = new ContO[3000];
        userCraft usercraft = new userCraft(medium);
        Tank atank[] = new Tank[20];
        int j = 0;
        do
        {
            atank[j] = new Tank(medium);
        } while(++j < 20);
        Craft acraft[] = new Craft[20];
        int k = 0;
        do
        {
            acraft[k] = new Craft(medium);
        } while(++k < 20);
        loadbase(aconto, medium);
        lstat("Loading 3D Models...", 17);
        k = 0;
        loadobjects(aconto1, aconto, medium, "aces");
        lstat("Loading 3D Models...", 1);
        k = maxco;
        loadobjects(aconto1, aconto, medium, "base");
        lstat("Loading 3D Models...", 2);
        loadobjects(aconto1, aconto, medium, "smap");
        lstat("Loading 3D Models...", 44);
        loadobjects(aconto1, aconto, medium, "clmap" + (int)(Math.random() * 5D) + "");
        lstat("Loading 3D Models...", 1);
        loadrots(aconto1, true);
        int l = 0;
        int ai[] = new int[600];
        for(int i1 = 0; i1 < maxco; i1++)
        {
            if(aconto1[i1].colides)
            {
                ai[l] = i1;
                l++;
            }
        }

        int ai1[] = new int[20];
        int ai2[] = new int[20];
        int j1 = 0;
        do
        {
            loadet[j1] = false;
        } while(++j1 < 7);
        downloadall(xtgraphics);
        Date date = new Date();
        long l1 = 0L;
        long l3 = date.getTime();
        float f = 30F;
        float f1 = 35F;
        boolean flag = false;
        int k1 = 0;
        int i2 = 0;
        boolean flag1 = true;
        maxmo = 0;
        do
        {
            Date date1 = new Date();
            long l4 = date1.getTime();
            if(!mon)
            {
                if(!flag1)
                {
                    medium.d(rd);
                    int j2 = 0;
                    int ai3[] = new int[100];
                    for(int j3 = 0; j3 < maxco; j3++)
                    {
                        if(aconto1[j3].dist != 0)
                        {
                            ai3[j2] = j3;
                            j2++;
                        } else
                        {
                            aconto1[j3].d(rd);
                        }
                    }

                    int ai5[] = new int[j2];
                    for(int i4 = 0; i4 < j2; i4++)
                    {
                        ai5[i4] = 0;
                        for(int k6 = 0; k6 < j2; k6++)
                        {
                            if(aconto1[ai3[i4]].dist != aconto1[ai3[k6]].dist)
                            {
                                if(aconto1[ai3[i4]].dist < aconto1[ai3[k6]].dist)
                                {
                                    ai5[i4]++;
                                }
                            } else
                            if(k6 > i4)
                            {
                                ai5[i4]++;
                            }
                        }

                    }

                    for(int j4 = 0; j4 < j2; j4++)
                    {
                        for(int l6 = 0; l6 < j2; l6++)
                        {
                            if(ai5[l6] == j4)
                            {
                                if(aconto1[ai3[l6]].fire)
                                {
                                    if(ai3[l6] == ai1[0])
                                    {
                                        usercraft.dl(rd);
                                    } else
                                    {
                                        for(int k8 = 1; k8 < maxmo; k8++)
                                        {
                                            if(ai3[l6] == ai1[k8])
                                            {
                                                if(ai2[k8] == 0)
                                                {
                                                    acraft[k8].dl(rd);
                                                }
                                                if(ai2[k8] == 1)
                                                {
                                                    atank[k8].dl(rd);
                                                }
                                            }
                                        }

                                    }
                                }
                                aconto1[ai3[l6]].d(rd);
                            }
                        }

                    }

                    if(xtgraphics.level < 6)
                    {
                        for(int k4 = 0; k4 < l; k4++)
                        {
                            for(int i7 = 0; i7 < maxmo; i7++)
                            {
                                if(ai1[i7] != ai[k4])
                                {
                                    aconto1[ai[k4]].tryexp(aconto1[ai1[i7]]);
                                    if(aconto1[ai1[i7]].fire)
                                    {
                                        if(i7 == 0)
                                        {
                                            usercraft.lasercolid(aconto1[ai[k4]]);
                                        } else
                                        {
                                            if(ai2[i7] == 0)
                                            {
                                                acraft[i7].lasercolid(aconto1[ai[k4]]);
                                            }
                                            if(ai2[i7] == 1)
                                            {
                                                atank[i7].lasercolid(aconto1[ai[k4]]);
                                            }
                                        }
                                    }
                                }
                            }

                        }

                    } else
                    {
                        for(int i5 = l - 1; i5 >= 0; i5--)
                        {
                            for(int j7 = 0; j7 < maxmo; j7++)
                            {
                                if(ai1[j7] != ai[i5])
                                {
                                    if(xtgraphics.level != 15 || j7 != 1)
                                    {
                                        aconto1[ai[i5]].tryexp(aconto1[ai1[j7]]);
                                    }
                                    if(aconto1[ai1[j7]].fire)
                                    {
                                        if(j7 == 0)
                                        {
                                            usercraft.lasercolid(aconto1[ai[i5]]);
                                        } else
                                        {
                                            if(ai2[j7] == 0)
                                            {
                                                acraft[j7].lasercolid(aconto1[ai[i5]]);
                                            }
                                            if(ai2[j7] == 1)
                                            {
                                                atank[j7].lasercolid(aconto1[ai[i5]]);
                                            }
                                        }
                                    }
                                }
                            }

                        }

                    }
                    for(int j5 = 1; j5 < maxmo; j5++)
                    {
                        if(ai2[j5] == 0)
                        {
                            acraft[j5].dosmokes(rd, aconto1[ai1[j5]]);
                            acraft[j5].preform(aconto1[ai1[j5]], aconto1, ai, l, ai1[0], k);
                            if(aconto1[ai1[j5]].exp)
                            {
                                if(!nosound)
                                {
                                    exp.setFramePosition(0);
                                    exp.start();
                                }
                                ai2[j5] = -1;
                            }
                            if(aconto1[ai1[j5]].hit && !nosound && frags == 0)
                            {
                                hitl.setFramePosition(0);
                                hitl.start();
                                if(sosun)
                                {
                                    frags = 3;
                                }
                            }
                        }
                        if(ai2[j5] == 1)
                        {
                            atank[j5].dosmokes(rd, aconto1[ai1[j5]]);
                            atank[j5].preform(aconto1[ai1[j5]], aconto1, ai1[0], k);
                            if(aconto1[ai1[j5]].exp)
                            {
                                if(!nosound)
                                {
                                    exp.setFramePosition(0);
                                    exp.start();
                                }
                                ai2[j5] = -1;
                            }
                            if(aconto1[ai1[j5]].hit && !nosound && frags == 0)
                            {
                                hitl.setFramePosition(0);
                                hitl.start();
                                if(sosun)
                                {
                                    frags = 3;
                                }
                            }
                        }
                    }

                    usercraft.dosmokes(rd, aconto1[ai1[0]]);
                    usercraft.preform(u, aconto1[ai1[0]], aconto1, ai1, maxmo);
                    int k5 = 0;
                    if(tab)
                    {
                        k5 = xtgraphics.cl;
                    } else
                    if(view != 4 && view != 5)
                    {
                        xtgraphics.dtrakers(rd, ai2, ai1, maxmo, aconto1, usercraft, u);
                    }
                    if(view == 0)
                    {
                        medium.behinde(aconto1[ai1[k5]]);
                    }
                    if(view == 1)
                    {
                        medium.right(aconto1[ai1[k5]]);
                    }
                    if(view == 2)
                    {
                        medium.infront(aconto1[ai1[k5]]);
                    }
                    if(view == 3)
                    {
                        medium.left(aconto1[ai1[k5]]);
                    }
                    if(view == 4)
                    {
                        medium.around(aconto1[ai1[k5]], 800);
                    }
                    if(view == 5)
                    {
                        medium.watch(aconto1[ai1[k5]]);
                    } else
                    if(medium.td)
                    {
                        medium.td = false;
                    }
                    if(aconto1[ai1[0]].exp)
                    {
                        int k7 = 0;
                        for(int l8 = 0; l8 < aconto1[ai1[0]].npl; l8++)
                        {
                            if(aconto1[ai1[0]].p[l8].exp == 7)
                            {
                                k7++;
                            }
                        }

                        if(k7 == aconto1[ai1[0]].npl)
                        {
                            flag1 = true;
                            xtgraphics.dest[ai1[0]] = true;
                            if(xtgraphics.alldest())
                            {
                                xtgraphics.fase = 2;
                                xtgraphics.drawovimg(offImage);
                            } else
                            {
                                xtgraphics.fase = 1;
                                xtgraphics.drawefimg(offImage);
                            }
                        }
                        if(u.space)
                        {
                            u.space = false;
                        }
                    } else
                    {
                        if(xtgraphics.mcomp)
                        {
                            if(u.space)
                            {
                                if(xtgraphics.level != 15)
                                {
                                    xtgraphics.fase = -4;
                                    xtgraphics.level++;
                                } else
                                {
                                    xtgraphics.fase = 4;
                                    xtgraphics.oldfase = 7;
                                }
                                flag1 = true;
                                u.space = false;
                            }
                        } else
                        if(u.space)
                        {
                            flag1 = true;
                            xtgraphics.drawpimg(offImage);
                            xtgraphics.fase = 3;
                            u.space = false;
                            xtgraphics.select = 0;
                        }
                        int l7 = 0;
                        for(int i9 = k; i9 < k + 13; i9++)
                        {
                            if(aconto1[i9].exp)
                            {
                                l7++;
                            }
                        }

                        if(l7 == 13)
                        {
                            flag1 = true;
                            xtgraphics.drawovimg(offImage);
                            xtgraphics.fase = 2;
                        }
                    }
                } else
                {
                    if(xtgraphics.fase == -4)
                    {
                        medium.d(rd);
                        int k2 = 0;
                        int ai4[] = new int[100];
                        for(int k3 = 0; k3 < maxco; k3++)
                        {
                            if(aconto1[k3].dist != 0)
                            {
                                ai4[k2] = k3;
                                k2++;
                            } else
                            {
                                aconto1[k3].d(rd);
                            }
                        }

                        int ai6[] = new int[k2];
                        for(int i6 = 0; i6 < k2; i6++)
                        {
                            ai6[i6] = 0;
                            for(int i8 = 0; i8 < k2; i8++)
                            {
                                if(aconto1[ai4[i6]].dist != aconto1[ai4[i8]].dist)
                                {
                                    if(aconto1[ai4[i6]].dist < aconto1[ai4[i8]].dist)
                                    {
                                        ai6[i6]++;
                                    }
                                } else
                                if(i8 > i6)
                                {
                                    ai6[i6]++;
                                }
                            }

                        }

                        for(int j6 = 0; j6 < k2; j6++)
                        {
                            for(int j8 = 0; j8 < k2; j8++)
                            {
                                if(ai6[j8] == j6)
                                {
                                    aconto1[ai4[j8]].d(rd);
                                }
                            }

                        }

                        medium.around(aconto1[k + 4], 6000);
                        if(u.space)
                        {
                            xtgraphics.drawl(rd, offImage);
                        }
                    }
                    xtgraphics.denter(rd, k, aconto1, usercraft, u);
                    if(xtgraphics.fase == -5 && u.space)
                    {
                        if(xtgraphics.select == 0)
                        {
                            loadrots(aconto1, false);
                            for(int i3 = k; i3 < k + 13; i3++)
                            {
                                aconto1[i3].out = false;
                            }

                            xtgraphics.reset();
                            xtgraphics.fase = -4;
                        }
                        if(xtgraphics.select == 1 && xtgraphics.sgame == 1)
                        {
                            loadrots(aconto1, false);
                            xtgraphics.reset();
                            loadsaved(aconto1, xtgraphics, k);
                            xtgraphics.fase = -4;
                        }
                        if(xtgraphics.select == 4)
                        {
                            moner = "Exiting game...";
                            mon = true;
                        }
                        u.space = false;
                    }
                    if(xtgraphics.fase == 4)
                    {
                        //shake();
                    }
                    if(xtgraphics.fase == -33)
                    {
                        if(xtgraphics.frst && xtgraphics.select == 0)
                        {
                            savegame(aconto1, xtgraphics, k);
                        } else
                        if(!xtgraphics.frst)
                        {
                            xtgraphics.frst = true;
                        }
                        while(i2 != 7)
                        {
                            if(xtgraphics.goodsun)
                            {
                                nounif = true;
                            }
                            mtrak[i2] = getSound("music/" + i2 + ".wav");
                            loadet[i2] = true;
                            i2++;
                        }
                        if(xtgraphics.goodsun)
                        {
                            xtgraphics.goodsun = false;
                        }
                        loadmovers(ai1, ai2, aconto1, acraft, atank, usercraft, xtgraphics);
                        nounif = false;
                        xtgraphics.fase = -2;
                    }
                    if(xtgraphics.fase == -3)
                    {
                        xtgraphics.fase = -33;
                    }
                    if(xtgraphics.fase == 0 && u.space)
                    {
                        if(!xtgraphics.dest[xtgraphics.selected])
                        {
                            setmover(ai1, aconto1, usercraft, xtgraphics);
                            flag1 = false;
                            view = 0;
                        }
                        u.space = false;
                    }
                    if(xtgraphics.fase == 2 && xtgraphics.sgame == 1 && !xtgraphics.alldest())
                    {
                        set0();
                        xtgraphics.sgame = 0;
                    }
                    if(xtgraphics.fase == 3 && u.space)
                    {
                        if(xtgraphics.select == 0)
                        {
                            System.gc();
                            flag1 = false;
                        }
                        u.space = false;
                    }
                    if(xtgraphics.fase == -8)
                    {
                        if(xtgraphics.sgame == -1)
                        {
                            getslevel(xtgraphics);
                        }
                        if(xtgraphics.cnty == 351)
                        {
                            xtgraphics.drawop(rd, offImage);
                            xtgraphics.cnty = 352;
                        }
                    }
                    if(xtgraphics.fase == 7 && u.space)
                    {
                        moner = "One moment...";
                        mon = true;
                        u.space = false;
                    }
                }
            } else
            {
                if(u.space)
                {
                    u.space = false;
                }
                rd.setColor(new Color(223, 223, 223));
                rd.fillRect(0, 0, 500, 360);
                xtgraphics.drawcs(rd, 170, moner, 0, 0, 0, false);
                if(moner.equals("Exiting game..."))
                {
                    repaint();
                    System.gc();
                    /*try
                    {
                        //open("web/exit.html");
                    }
                    catch(Exception _ex) { }*/
                    System.gc();
                    System.exit(0);
                }
                if(moner.equals("One moment..."))
                {
                    repaint();
                    System.gc();
                    //unloadit();
                    try
                    {
                        open("winner/index.html");
                    }
                    catch(Exception _ex) { }
                    System.gc();
                    System.exit(0);
                }
            }
            repaint();
            if(!mon)
            {
                playsounds(usercraft, aconto1[ai1[0]], flag1, xtgraphics);
            }
            date1 = new Date();
            long l5 = date1.getTime();
            if(!flag1)
            {
                if(!flag)
                {
                    f = f1;
                    flag = true;
                    k1 = 0;
                }
                if(k1 == 10)
                {
                    if(l5 - l3 < 560L)
                    {
                        f = (float)((double)f + 0.5D);
                    } else
                    {
                        f = (float)((double)f - 0.5D);
                        if(f < 5F)
                        {
                            f = 5F;
                        }
                    }
                    l3 = l5;
                    k1 = 0;
                } else
                {
                    k1++;
                }
            } else
            {
                if(flag)
                {
                    f1 = f;
                    flag = false;
                    k1 = 0;
                }
                if(k1 == 10)
                {
                    if(l5 - l3 < 400L)
                    {
                        f = (float)((double)f + 3.5D);
                    } else
                    {
                        f = (float)((double)f - 3.5D);
                        if(f < 5F)
                        {
                            f = 5F;
                        }
                    }
                    l3 = l5;
                    k1 = 0;
                } else
                {
                    k1++;
                }
            }
            long l2 = (long)Math.round(f) - (l5 - l4);
            if(l2 < (long)i)
            {
                l2 = i;
            }
            try
            {
                Thread.sleep(l2);
            }
            catch(InterruptedException _ex) { }
        } while(true);
    }

    public void lstat(String s, int i)
    {
        dnload += i;
        rd.setColor(new Color(223, 223, 223));
        rd.fillRect(0, 0, 500, 360);
        rd.setColor(new Color(174, 185, 198));
        rd.drawRect(150, 200, 200, 5);
        rd.fillRect(150, 200, 24 + (int)(((float)dnload / 594F) * 176F), 5);
        rd.setColor(new Color(151, 166, 183));
        rd.drawString(s, 290, 220);
        rd.drawString("Remaining: " + (594 - dnload) + " KB", 202, 250);
        rd.setColor(new Color(0, 0, 0));
        rd.drawString("Loading " + (int)(((float)(24 + (int)(((float)dnload / 594F) * 176F)) / 200F) * 100F) + "%", 103, 194);
        repaint();
    }

    public void init()
    {
        offImage = createImage(500, 360);
        if(offImage != null)
        {
            rd = offImage.getGraphics();
        }
        rd.setFont(new Font("SansSerif", 1, 11));
        cookieDir();
        if (!initKeySettings())
            initDefaultKeySettings();
        setFocusTraversalKeysEnabled(false);
    }

    public void getslevel(xtGraphics xtgraphics)
    {
        try
        {
            int i = readcookie("radxv");
            if(i == 0)
            {
                xtgraphics.sgame = 0;
            } else
            {
                xtgraphics.sgame = 1;
                xtgraphics.select = 1;
            }
        }
        catch(Exception _ex) { }
    }

    public void loadsaved(ContO aconto[], xtGraphics xtgraphics, int i)
    {
        try
        {
            xtgraphics.level = readcookie("radxv");
            for(int j = i; j < i + 13; j++)
            {
                aconto[j].nhits = readcookie("radnhits" + String.valueOf(j));
                if(aconto[j].nhits >= aconto[j].maxhits)
                {
                    aconto[j].exp = true;
                    aconto[j].out = true;
                } else
                {
                    aconto[j].out = false;
                }
            }

            int k = 0;
            do
            {
                int i1 = readcookie("raddest" + String.valueOf(k));
                if(i1 == 0)
                {
                    xtgraphics.dest[k] = false;
                } else
                {
                    xtgraphics.dest[k] = true;
                }
            } while(++k < 5);
        }
        catch(Exception _ex) { }
    }
    
    public boolean keyDown(Event event, int i)
    {
        if(viewOneKeys.contains(i))
        {
            viewOnePressedKeys.add(i);
            view = 1;
        }
        if(viewTwoKeys.contains(i))
        {
            viewTwoPressedKeys.add(i);
            view = 2;
        }
        if(viewThreeKeys.contains(i))
        {
            viewThreePressedKeys.add(i);
            view = 3;
        }
        if(viewFourKeys.contains(i))
        {
            viewFourPressedKeys.add(i);
            view = 4;
        }
        if(viewFiveKeys.contains(i))
        {
            viewFivePressedKeys.add(i);
            view = 5;
        }
        if(nomusicKeys.contains(i))
        {
            if(nomusic)
            {
                nomusic = false;
            } else
            {
                nomusic = true;
                if(plcnt >= 100 && crntt != -1)
                {
                    mtrak[crntt].stop();
                    crntt--;
                    plcnt = 95;
                }
            }
        }
        if(switchmusicKeys.contains(i))
        {
            if(plcnt >= 100)
            {
                mtrak[crntt].stop();
            }
            plcnt = 95;
        }
        if(nosoundKeys.contains(i))
        {
            if(nosound)
            {
                nosound = false;
            } else
            {
                nosound = true;
            }
        }
        if(radarKeys.contains(i))
        {
            radarPressedKeys.add(i);
            u.radar = true;
        }
        if(tabKeys.contains(i))
        {
            tabPressedKeys.add(i);
            tab = true;
        }
        if(plusKeys.contains(i))
        {
            plusPressedKeys.add(i);
            u.plus = true;
        }
        if(minsKeys.contains(i))
        {
            minsPressedKeys.add(i);
            u.mins = true;
        }
        if(jumpKeys.contains(i) && u.jump == 0)
        {
            u.jump = 1;
            if(!u.jade)
            {
                u.jade = true;
            }
        }
        if(enterKeys.contains(i) && !enterd)
        {
            enterPressedKeys.add(i);
            u.space = true;
            enterd = true;
        }
        if(fireKeys.contains(i))
        {
            firePressedKeys.add(i);
            u.fire = true;
        }
        if(leftKeys.contains(i))
        {
            leftPressedKeys.add(i);
            u.left = true;
        }
        if(rightKeys.contains(i))
        {
            rightPressedKeys.add(i);
            u.right = true;
        }
        if(downKeys.contains(i))
        {
            downPressedKeys.add(i);
            u.down = true;
        }
        if(upKeys.contains(i))
        {
            upPressedKeys.add(i);
            u.up = true;
        }
        return false;
    }

    public void savecookie(String s, String s1)
    {
        try
        {
            PrintWriter pw = new PrintWriter(new File("/files/ra1/cookies/" + s));
            pw.println(s1);
            pw.flush();
            pw.close();
        }
        catch(Exception _ex) { }
    }

    public int readcookie(String s)
    {
        int i = 0;
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(new File("/files/ra1/cookies/" + s)));
            i = Integer.parseInt(br.readLine());
        }
        catch(Exception _ex) { }
        return i;
    }
    
    public boolean cookieDir() {
        File f = new File("/files/ra1/cookies");
        if (f.exists() && f.isDirectory())
            return true;
        return f.mkdir();
    }
    
    public void open(String url) {
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)){
            Desktop desktop = Desktop.getDesktop();
            try {
                File file = new File(url);
                if (file.exists())
                    desktop.browse(file.toURI());
                else
                    desktop.browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        } else{
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("xdg-open " + url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public boolean initKeySettings() {
        try {
            File file = new File("/files/ra1/KeySettings.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String string;
            while((string = br.readLine()) != null) {
                if(string.startsWith("viewOne("))
                    viewOneKeys.add(getint("viewOne", string, 0));
                if(string.startsWith("viewTwo("))
                    viewTwoKeys.add(getint("viewTwo", string, 0));
                if(string.startsWith("viewThree("))
                    viewThreeKeys.add(getint("viewThree", string, 0));
                if(string.startsWith("viewFour("))
                    viewFourKeys.add(getint("viewFour", string, 0));
                if(string.startsWith("viewFive("))
                    viewFiveKeys.add(getint("viewFive", string, 0));
                if(string.startsWith("nomusic("))
                    nomusicKeys.add(getint("nomusic", string, 0));
                if(string.startsWith("switchmusic("))
                    switchmusicKeys.add(getint("switchmusic", string, 0));
                if(string.startsWith("nosound("))
                    nosoundKeys.add(getint("nosound", string, 0));
                if(string.startsWith("radar("))
                    radarKeys.add(getint("radar", string, 0));
                if(string.startsWith("tab("))
                    tabKeys.add(getint("tab", string, 0));
                if(string.startsWith("plus("))
                    plusKeys.add(getint("plus", string, 0));
                if(string.startsWith("mins("))
                    minsKeys.add(getint("mins", string, 0));
                if(string.startsWith("jump("))
                    jumpKeys.add(getint("jump", string, 0));
                if(string.startsWith("enter("))
                    enterKeys.add(getint("enter", string, 0));
                if(string.startsWith("fire("))
                    fireKeys.add(getint("fire", string, 0));
                if(string.startsWith("left("))
                    leftKeys.add(getint("left", string, 0));
                if(string.startsWith("right("))
                    rightKeys.add(getint("right", string, 0));
                if(string.startsWith("down("))
                    downKeys.add(getint("down", string, 0));
                if(string.startsWith("up("))
                    upKeys.add(getint("up", string, 0));
            }
        } catch (IOException ex) {
            return false;
        }
        return true;
    }
    
    public void initDefaultKeySettings() {
        viewOneKeys.add(49);
        viewTwoKeys.add(50);
        viewThreeKeys.add(51);
        viewFourKeys.add(52);
        viewFiveKeys.add(53);
        nomusicKeys.add(109);
        nomusicKeys.add(77);
        switchmusicKeys.add(116);
        switchmusicKeys.add(84);
        nosoundKeys.add(115);
        nosoundKeys.add(83);
        radarKeys.add(114);
        radarKeys.add(82);
        tabKeys.add(9);
        plusKeys.add(43);
        plusKeys.add(61);
        minsKeys.add(45);
        minsKeys.add(8);
        jumpKeys.add(106);
        jumpKeys.add(74);
        enterKeys.add(10);
        enterKeys.add(27);
        fireKeys.add(32);
        leftKeys.add(1006);
        rightKeys.add(1007);
        downKeys.add(1005);
        upKeys.add(1004);
    }
    
    public static void main(String args[]) {
        Frame f = new Frame();
        f.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            };
        });
        
        F51 f51 = new F51();
        f51.setPreferredSize(new Dimension(500, 360));
        f.add(f51);
        f.pack();
        f.setTitle("RADICAL ACES");
        f.setIconImage(Toolkit.getDefaultToolkit().getImage("graphics/icon.png"));
        f.show();
        f51.init();
        f51.start();
    }
}
