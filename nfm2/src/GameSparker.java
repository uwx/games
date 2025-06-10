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

public class GameSparker extends Panel
    implements Runnable
{

    Graphics rd;
    Image offImage;
    Thread gamer;
    Control u[];
    int mouses;
    int xm;
    int ym;
    boolean lostfcs;
    boolean exwist;
    int nob;
    int notb;
    int view;

    Set<Integer> upKeys = new HashSet<>();
    Set<Integer> downKeys = new HashSet<>();
    Set<Integer> rightKeys = new HashSet<>();
    Set<Integer> leftKeys = new HashSet<>();
    Set<Integer> handbKeys = new HashSet<>();
    Set<Integer> xKeys = new HashSet<>();
    Set<Integer> zKeys = new HashSet<>();
    Set<Integer> enterKeys = new HashSet<>();
    Set<Integer> arraceKeys = new HashSet<>();
    Set<Integer> mutemKeys = new HashSet<>();
    Set<Integer> mutesKeys = new HashSet<>();
    Set<Integer> viewKeys = new HashSet<>();
    
    Set<Integer> upPressedKeys = new HashSet<>();
    Set<Integer> downPressedKeys = new HashSet<>();
    Set<Integer> rightPressedKeys = new HashSet<>();
    Set<Integer> leftPressedKeys = new HashSet<>();
    Set<Integer> handbPressedKeys = new HashSet<>();
    Set<Integer> xPressedKeys = new HashSet<>();
    Set<Integer> zPressedKeys = new HashSet<>();
    Set<Integer> enterPressedKeys = new HashSet<>();

    public boolean keyDown(Event event, int i)
    {
        if(!exwist)
        {
            if(upKeys.contains(i))
            {
                upPressedKeys.add(i);
                u[0].up = true;
            }
            if(downKeys.contains(i))
            {
                downPressedKeys.add(i);
                u[0].down = true;
            }
            if(rightKeys.contains(i))
            {
                rightPressedKeys.add(i);
                u[0].right = true;
            }
            if(leftKeys.contains(i))
            {
                leftPressedKeys.add(i);
                u[0].left = true;
            }
            if(handbKeys.contains(i))
            {
                handbPressedKeys.add(i);
                u[0].handb = true;
            }
            if(xKeys.contains(i))
            {
                xPressedKeys.add(i);
                u[0].lookback = -1;
            }
            if(zKeys.contains(i))
            {
                zPressedKeys.add(i);
                u[0].lookback = 1;
            }
            if(enterKeys.contains(i))
            {
                enterPressedKeys.add(i);
                u[0].enter = true;
            }
            if (arraceKeys.contains(i))
                u[0].arrace = !u[0].arrace;
            if (mutemKeys.contains(i))
                u[0].mutem = !u[0].mutem;
            if (mutesKeys.contains(i))
                u[0].mutes = !u[0].mutes;
            if (viewKeys.contains(i))
                view = (view + 1) % 3;
        }
        return false;
    }

    public void stop()
    {
        if(exwist && gamer != null)
        {
            System.gc();
            gamer.stop();
            gamer = null;
        }
        exwist = true;
    }

    public boolean lostFocus(Event event, Object obj)
    {
        if(!exwist && !lostfcs)
        {
            lostfcs = true;
            mouses = 0;
            u[0].falseo();
            setCursor(new Cursor(0));
        }
        return false;
    }

    public boolean gotFocus(Event event, Object obj)
    {
        if(!exwist && lostfcs)
        {
            lostfcs = false;
        }
        return false;
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

    public int readcookie(String s)
    {
        int i = -1;
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(new File("/files/nfm2/cookies/" + s)));
            i = Integer.parseInt(br.readLine());
        }
        catch(Exception _ex) { }
        return i;
    }

    public void paint(Graphics g)
    {
        g.drawImage(offImage, 0, 0, this);
    }

    public GameSparker()
    {
        u = new Control[7];
        mouses = 0;
        xm = 0;
        ym = 0;
        lostfcs = false;
        exwist = true;
        nob = 0;
        notb = 0;
        view = 0;
    }

    public void loadbase(ContO aconto[], Medium medium, Trackers trackers, xtGraphics xtgraphics)
    {
        String as[] = {
            "2000tornados", "formula7", "canyenaro", "lescrab", "nimi", "maxrevenge", "leadoxide", "koolkat", "drifter", "policecops", 
            "mustang", "king", "audir8", "masheen", "radicalone", "drmonster", "road", "froad", "twister2", "twister1", 
            "turn", "offroad", "bumproad", "offturn", "nroad", "nturn", "roblend", "noblend", "rnblend", "roadend", 
            "offroadend", "hpground", "ramp30", "cramp35", "dramp15", "dhilo15", "slide10", "takeoff", "sramp22", "offbump", 
            "offramp", "sofframp", "halfpipe", "spikes", "rail", "thewall", "checkpoint", "fixpoint", "offcheckpoint", "sideoff", 
            "bsideoff", "uprise", "riseroad", "sroad", "soffroad"
        };
        xtgraphics.dnload += 6;
        try
        {
            File file = new File("/app/games/nfm2/data/models.radq");
            DataInputStream datainputstream = new DataInputStream(new FileInputStream(file));
            ZipInputStream zipinputstream = new ZipInputStream(datainputstream);
            ZipEntry zipentry = zipinputstream.getNextEntry();
            Object obj = null;
            for(; zipentry != null; zipentry = zipinputstream.getNextEntry())
            {
                int i = 0;
                int j = 0;
                do
                {
                    if(zipentry.getName().startsWith(as[j]))
                    {
                        i = j;
                    }
                } while(++j < 55);
                j = (int)zipentry.getSize();
                byte abyte0[] = new byte[j];
                int k = 0;
                int l;
                for(; j > 0; j -= l)
                {
                    l = zipinputstream.read(abyte0, k, j);
                    k += l;
                }

                aconto[i] = new ContO(abyte0, medium, trackers);
                xtgraphics.dnload++;
            }

            datainputstream.close();
            zipinputstream.close();
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

    public boolean keyUp(Event event, int i)
    {
        if(!exwist)
        {
            if(upPressedKeys.contains(i))
            {
                upPressedKeys.remove(i);
                if (upPressedKeys.isEmpty())
                    u[0].up = false;
            }
            if(downPressedKeys.contains(i))
            {
                downPressedKeys.remove(i);
                if (downPressedKeys.isEmpty())
                    u[0].down = false;
            }
            if(rightPressedKeys.contains(i))
            {
                rightPressedKeys.remove(i);
                if (rightPressedKeys.isEmpty())
                    u[0].right = false;
            }
            if(leftPressedKeys.contains(i))
            {
                leftPressedKeys.remove(i);
                if (leftPressedKeys.isEmpty())
                    u[0].left = false;
            }
            if(handbPressedKeys.contains(i))
            {
                handbPressedKeys.remove(i);
                if (handbPressedKeys.isEmpty())
                    u[0].handb = false;
            }
            if (xPressedKeys.contains(i)) {
                xPressedKeys.remove(i);
                if (xPressedKeys.isEmpty())
                    u[0].lookback = 0;
            }
            if (zPressedKeys.contains(i)) {
                zPressedKeys.remove(i);
                if (zPressedKeys.isEmpty())
                    u[0].lookback = 0;
            }
            if(enterPressedKeys.contains(i))
            {
                enterPressedKeys.remove(i);
                if (enterPressedKeys.isEmpty())
                    u[0].enter = false;
            }
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

    public boolean mouseDown(Event event, int i, int j)
    {
        if(!exwist && mouses == 0)
        {
            xm = i;
            ym = j;
            mouses = 1;
        }
        return false;
    }

    public void loadstage(ContO aconto[], ContO aconto1[], Medium medium, Trackers trackers, CheckPoints checkpoints, xtGraphics xtgraphics, Madness amadness[], 
            Record record)
    {
        trackers.nt = 0;
        nob = 7;
        notb = 0;
        checkpoints.n = 0;
        checkpoints.nsp = 0;
        checkpoints.fn = 0;
        checkpoints.haltall = false;
        checkpoints.wasted = 0;
        checkpoints.catchfin = 0;
        medium.lightson = false;
        medium.ground = 250;
        view = 0;
        int i = 0;
        int j = 100;
        int k = 0;
        int l = 100;
        if(!trackers.tracksReady)
        {
            TracksSetup(trackers);
        }
        String s1 = "";
        try
        {
            File file = new File("/app/games/nfm2/tracks/" + checkpoints.stage + ".txt");
            DataInputStream datainputstream = new DataInputStream(new FileInputStream(file));
            String s;
            while((s = datainputstream.readLine()) != null) 
            {
                s1 = "" + s.trim();
                if(s1.startsWith("snap"))
                {
                    medium.setsnap(getint("snap", s1, 0), getint("snap", s1, 1), getint("snap", s1, 2));
                }
                if(s1.startsWith("sky"))
                {
                    medium.setsky(getint("sky", s1, 0), getint("sky", s1, 1), getint("sky", s1, 2));
                    xtgraphics.snap(checkpoints.stage);
                }
                if(s1.startsWith("ground"))
                {
                    medium.setgrnd(getint("ground", s1, 0), getint("ground", s1, 1), getint("ground", s1, 2));
                }
                if(s1.startsWith("polys"))
                {
                    medium.setpolys(getint("polys", s1, 0), getint("polys", s1, 1), getint("polys", s1, 2));
                }
                if(s1.startsWith("fog"))
                {
                    medium.setfade(getint("fog", s1, 0), getint("fog", s1, 1), getint("fog", s1, 2));
                }
                if(s1.startsWith("density"))
                {
                    medium.fogd = getint("density", s1, 0);
                }
                if(s1.startsWith("fadefrom"))
                {
                    medium.fadfrom(getint("fadefrom", s1, 0));
                    medium.origfade = medium.fade[0];
                }
                if(s1.startsWith("lightson"))
                {
                    medium.lightson = true;
                }
                if(s1.startsWith("set"))
                {
                    int k1 = getint("set", s1, 0);
                    k1 += 6;
                    aconto[nob] = new ContO(aconto1[k1], getint("set", s1, 1), medium.ground - aconto1[k1].grat, getint("set", s1, 2), getint("set", s1, 3));
                    if(s1.indexOf(")p") != -1)
                    {
                        checkpoints.x[checkpoints.n] = getint("chk", s1, 1);
                        checkpoints.z[checkpoints.n] = getint("chk", s1, 2);
                        checkpoints.y[checkpoints.n] = 0;
                        checkpoints.typ[checkpoints.n] = 0;
                        if(s1.indexOf(")pt") != -1)
                        {
                            checkpoints.typ[checkpoints.n] = -1;
                        }
                        if(s1.indexOf(")pr") != -1)
                        {
                            checkpoints.typ[checkpoints.n] = -2;
                        }
                        if(s1.indexOf(")po") != -1)
                        {
                            checkpoints.typ[checkpoints.n] = -3;
                        }
                        if(s1.indexOf(")ph") != -1)
                        {
                            checkpoints.typ[checkpoints.n] = -4;
                        }
                        if(s1.indexOf("out") != -1)
                        {
                            System.out.println("out: " + checkpoints.n);
                        }
                        checkpoints.n++;
                        notb = nob + 1;
                    }
                    nob++;
                }
                if(s1.startsWith("chk"))
                {
                    int l1 = getint("chk", s1, 0);
                    l1 += 6;
                    aconto[nob] = new ContO(aconto1[l1], getint("chk", s1, 1), medium.ground - aconto1[l1].grat, getint("chk", s1, 2), getint("chk", s1, 3));
                    checkpoints.x[checkpoints.n] = getint("chk", s1, 1);
                    checkpoints.z[checkpoints.n] = getint("chk", s1, 2);
                    checkpoints.y[checkpoints.n] = medium.ground - aconto1[l1].grat;
                    if(getint("chk", s1, 3) == 0)
                    {
                        checkpoints.typ[checkpoints.n] = 1;
                    } else
                    {
                        checkpoints.typ[checkpoints.n] = 2;
                    }
                    checkpoints.pcs = checkpoints.n;
                    checkpoints.n++;
                    aconto[nob].checkpoint = checkpoints.nsp + 1;
                    checkpoints.nsp++;
                    nob++;
                    notb = nob;
                }
                if(s1.startsWith("fix"))
                {
                    int i2 = getint("fix", s1, 0);
                    i2 += 6;
                    aconto[nob] = new ContO(aconto1[i2], getint("fix", s1, 1), getint("fix", s1, 3), getint("fix", s1, 2), getint("fix", s1, 4));
                    checkpoints.fx[checkpoints.fn] = getint("fix", s1, 1);
                    checkpoints.fz[checkpoints.fn] = getint("fix", s1, 2);
                    checkpoints.fy[checkpoints.fn] = getint("fix", s1, 3);
                    aconto[nob].elec = true;
                    if(getint("fix", s1, 4) != 0)
                    {
                        checkpoints.roted[checkpoints.fn] = true;
                        aconto[nob].roted = true;
                    } else
                    {
                        checkpoints.roted[checkpoints.fn] = false;
                    }
                    if(s1.indexOf(")s") != -1)
                    {
                        checkpoints.special[checkpoints.fn] = true;
                    } else
                    {
                        checkpoints.special[checkpoints.fn] = false;
                    }
                    checkpoints.fn++;
                    nob++;
                    notb = nob;
                }
                if(s1.startsWith("nlaps"))
                {
                    checkpoints.nlaps = getint("nlaps", s1, 0);
                }
                if(s1.startsWith("name"))
                {
                    checkpoints.name = getstring("name", s1, 0).replace('|', ',');
                }
                if(s1.startsWith("maxr"))
                {
                    int j2 = getint("maxr", s1, 0);
                    int j3 = getint("maxr", s1, 1);
                    i = j3;
                    int j4 = getint("maxr", s1, 2);
                    for(int j5 = 0; j5 < j2; j5++)
                    {
                        aconto[nob] = new ContO(aconto1[45], j3, medium.ground - aconto1[45].grat, j5 * 4800 + j4, 0);
                        nob++;
                    }

                    trackers.y[trackers.nt] = -5000;
                    trackers.rady[trackers.nt] = 7100;
                    trackers.x[trackers.nt] = j3 + 500;
                    trackers.radx[trackers.nt] = 600;
                    trackers.z[trackers.nt] = ((j2 * 4800) / 2 + j4) - 2400;
                    trackers.radz[trackers.nt] = (j2 * 4800) / 2;
                    trackers.xy[trackers.nt] = 90;
                    trackers.zy[trackers.nt] = 0;
                    trackers.dam[trackers.nt] = 1;
                    trackers.nt++;
                }
                if(s1.startsWith("maxl"))
                {
                    int k2 = getint("maxl", s1, 0);
                    int k3 = getint("maxl", s1, 1);
                    j = k3;
                    int k4 = getint("maxl", s1, 2);
                    for(int k5 = 0; k5 < k2; k5++)
                    {
                        aconto[nob] = new ContO(aconto1[45], k3, medium.ground - aconto1[45].grat, k5 * 4800 + k4, 0);
                        nob++;
                    }

                    trackers.y[trackers.nt] = -5000;
                    trackers.rady[trackers.nt] = 7100;
                    trackers.x[trackers.nt] = k3 - 500;
                    trackers.radx[trackers.nt] = 600;
                    trackers.z[trackers.nt] = ((k2 * 4800) / 2 + k4) - 2400;
                    trackers.radz[trackers.nt] = (k2 * 4800) / 2;
                    trackers.xy[trackers.nt] = -90;
                    trackers.zy[trackers.nt] = 0;
                    trackers.dam[trackers.nt] = 1;
                    trackers.nt++;
                }
                if(s1.startsWith("maxt"))
                {
                    int l2 = getint("maxt", s1, 0);
                    int l3 = getint("maxt", s1, 1);
                    k = l3;
                    int l4 = getint("maxt", s1, 2);
                    for(int l5 = 0; l5 < l2; l5++)
                    {
                        aconto[nob] = new ContO(aconto1[45], l5 * 4800 + l4, medium.ground - aconto1[45].grat, l3, 90);
                        nob++;
                    }

                    trackers.y[trackers.nt] = -5000;
                    trackers.rady[trackers.nt] = 7100;
                    trackers.z[trackers.nt] = l3 + 500;
                    trackers.radz[trackers.nt] = 600;
                    trackers.x[trackers.nt] = ((l2 * 4800) / 2 + l4) - 2400;
                    trackers.radx[trackers.nt] = (l2 * 4800) / 2;
                    trackers.zy[trackers.nt] = 90;
                    trackers.xy[trackers.nt] = 0;
                    trackers.dam[trackers.nt] = 1;
                    trackers.nt++;
                }
                if(s1.startsWith("maxb"))
                {
                    int i3 = getint("maxb", s1, 0);
                    int i4 = getint("maxb", s1, 1);
                    l = i4;
                    int i5 = getint("maxb", s1, 2);
                    for(int i6 = 0; i6 < i3; i6++)
                    {
                        aconto[nob] = new ContO(aconto1[45], i6 * 4800 + i5, medium.ground - aconto1[45].grat, i4, 90);
                        nob++;
                    }

                    trackers.y[trackers.nt] = -5000;
                    trackers.rady[trackers.nt] = 7100;
                    trackers.z[trackers.nt] = i4 - 500;
                    trackers.radz[trackers.nt] = 600;
                    trackers.x[trackers.nt] = ((i3 * 4800) / 2 + i5) - 2400;
                    trackers.radx[trackers.nt] = (i3 * 4800) / 2;
                    trackers.zy[trackers.nt] = -90;
                    trackers.xy[trackers.nt] = 0;
                    trackers.dam[trackers.nt] = 1;
                    trackers.nt++;
                }
            }
            datainputstream.close();
        }
        catch(Exception exception)
        {
            xtgraphics.fase = 3;
            System.out.println("Error in stage " + checkpoints.stage);
            System.out.println("" + exception);
            System.out.println("At line: " + s1);
        }
        if(checkpoints.stage == 16)
        {
            medium.lightn = 0;
        } else
        {
            medium.lightn = -1;
        }
        if(checkpoints.stage == 1)
        {
            medium.nochekflk = false;
        } else
        {
            medium.nochekflk = true;
        }
        medium.newpolys(j, i - j, l, k - l, trackers);
        if(xtgraphics.fase == 2)
        {
            medium.trx = 0L;
            medium.trz = 0L;
            if(trackers.nt >= 4)
            {
                int i1 = 4;
                do
                {
                    medium.trx += trackers.x[trackers.nt - i1];
                    medium.trz += trackers.z[trackers.nt - i1];
                } while(--i1 > 0);
            }
            medium.trx = medium.trx / 4L;
            medium.trz = medium.trz / 4L;
            medium.ptr = 0;
            medium.ptcnt = -10;
            medium.hit = 45000;
            medium.fallen = 0;
            medium.nrnd = 0;
            medium.trk = true;
            xtgraphics.fase = 1;
            mouses = 0;
        }
        int j1 = 0;
        do
        {
            u[j1].reset(checkpoints, xtgraphics.sc[j1]);
        } while(++j1 < 7);
        xtgraphics.resetstat(checkpoints.stage);
        j1 = 0;
        do
        {
            aconto[j1] = new ContO(aconto1[xtgraphics.sc[j1]], xtgraphics.xstart[j1], 250 - aconto1[xtgraphics.sc[j1]].grat, xtgraphics.zstart[j1], 0);
            amadness[j1].reseto(xtgraphics.sc[j1], aconto[j1], checkpoints);
        } while(++j1 < 7);
        record.reset(aconto);
        System.gc();
    }

    public void TracksSetup(Trackers trackers)
    {
        try
        {
            trackers.tracksReady = false;
            String s1 = "";
            int j = 0;
            if(s1.startsWith(trackers.sequ[1].substring(34, 40)))
            {
                for(; j < s1.length() - 1; j++)
                {
                    if(s1.startsWith(trackers.sequ[2].substring(15, 30), j) && trackers.sequ[2].length() == 43)
                    {
                        trackers.tracksReady = true;
                    }
                }

            } else
            {
                trackers.tracksReady = true;
            }
            if(!trackers.tracksReady)
            {
                rd.setColor(new Color(0, 0, 0));
                rd.fillRect(0, 0, 670, 400);
                rd.setColor(new Color(255, 255, 255));
                rd.drawString(trackers.sequ[0], 30, 50);
                rd.drawString(trackers.sequ[1], 30, 100);
                rd.drawString("" + s1, 30, 120);
                rd.drawString(trackers.sequ[2], 30, 200);
                repaint();
                gamer.stop();
            }
        }
        catch(Exception _ex)
        {
            trackers.tracksReady = false;
            String s = "";
            int i = 0;
            if(s.startsWith(trackers.sequ[1].substring(34, 40)))
            {
                for(; i < s.length() - 1; i++)
                {
                    if(s.startsWith(trackers.sequ[2].substring(15, 30), i) && trackers.sequ[2].length() == 43)
                    {
                        trackers.tracksReady = true;
                    }
                }

            } else
            {
                trackers.tracksReady = true;
            }
            if(!trackers.tracksReady)
            {
                rd.setColor(new Color(0, 0, 0));
                rd.fillRect(0, 0, 670, 400);
                rd.setColor(new Color(255, 255, 255));
                rd.drawString(trackers.sequ[0], 30, 50);
                rd.drawString(trackers.sequ[1], 30, 100);
                rd.drawString("" + s, 30, 120);
                rd.drawString(trackers.sequ[2], 30, 200);
                repaint();
                gamer.stop();
            }
        }
    }

    public void run()
    {
        rd.setColor(new Color(0, 0, 0));
        rd.fillRect(0, 0, 670, 400);
        repaint();
        Trackers trackers = new Trackers();
        TracksSetup(trackers);
        Medium medium = new Medium();
        int i = 5;
        int j = 530;
        int k = 0;
        if(k != 0)
        {
            i = 15;
        }
        if(k != 2)
        {
            j = 500;
        }
        CheckPoints checkpoints = new CheckPoints();
        xtGraphics xtgraphics = new xtGraphics(medium, rd, this);
        xtgraphics.loaddata(k);
        Record record = new Record(medium);
        ContO aconto[] = new ContO[55];
        loadbase(aconto, medium, trackers, xtgraphics);
        ContO aconto1[] = new ContO[330];
        Madness amadness[] = new Madness[7];
        int l = 0;
        do
        {
            amadness[l] = new Madness(medium, record, xtgraphics, l);
            u[l] = new Control(medium);
        } while(++l < 7);
        l = 0;
        float f = 35F;
        int i1 = 80;
        l = readcookie("unlocked");
        if(l >= 1 && l <= 17)
        {
            xtgraphics.unlocked = l;
            if(xtgraphics.unlocked != 17)
            {
                checkpoints.stage = xtgraphics.unlocked;
            } else
            {
                checkpoints.stage = (int)(Math.random() * 17D) + 1;
            }
            xtgraphics.opselect = 0;
        }
        l = readcookie("usercar");
        if(l >= 0 && l <= 15)
        {
            xtgraphics.sc[0] = l;
        }
        l = readcookie("gameprfact");
        if(l != -1)
        {
            f = readcookie("gameprfact");
            i1 = 0;
        }
        boolean flag = false;
        xtgraphics.stoploading();
        System.gc();
        Date date = new Date();
        long l1 = 0L;
        long l3 = date.getTime();
        float f1 = 30F;
        boolean flag1 = false;
        int j1 = 0;
        int k1 = 0;
        int i2 = 0;
        int j2 = 0;
        int k2 = 0;
        boolean flag2 = false;
        exwist = false;
        do
        {
            Date date1 = new Date();
            long l4 = date1.getTime();
            if(xtgraphics.fase == 111)
            {
                if(mouses == 1)
                {
                    i2 = 800;
                }
                if(i2 < 800)
                {
                    xtgraphics.clicknow();
                    i2++;
                } else
                {
                    i2 = 0;
                    xtgraphics.fase = 9;
                    mouses = 0;
                    lostfcs = false;
                }
            }
            if(xtgraphics.fase == 9)
            {
                if(i2 < 200)
                {
                    xtgraphics.rad(i2);
                    catchlink(0);
                    if(mouses == 2)
                    {
                        mouses = 0;
                    }
                    if(mouses == 1)
                    {
                        mouses = 2;
                    }
                    i2++;
                } else
                {
                    i2 = 0;
                    xtgraphics.fase = 10;
                    mouses = 0;
                    u[0].falseo();
                }
            }
            if(xtgraphics.fase == -9)
            {
                if(i2 < 2)
                {
                    rd.setColor(new Color(0, 0, 0));
                    rd.fillRect(0, 0, 670, 400);
                    i2++;
                } else
                {
                    xtgraphics.inishcarselect();
                    i2 = 0;
                    xtgraphics.fase = 7;
                    mouses = 0;
                }
            }
            if(xtgraphics.fase == 8)
            {
                xtgraphics.credits(u[0]);
                xtgraphics.ctachm(xm, ym, mouses, u[0]);
                if(xtgraphics.flipo <= 100)
                {
                    catchlink(0);
                }
                if(mouses == 2)
                {
                    mouses = 0;
                }
                if(mouses == 1)
                {
                    mouses = 2;
                }
            }
            if(xtgraphics.fase == 10)
            {
                xtgraphics.maini(u[0]);
                xtgraphics.ctachm(xm, ym, mouses, u[0]);
                if(mouses == 2)
                {
                    mouses = 0;
                }
                if(mouses == 1)
                {
                    mouses = 2;
                }
            }
            if(xtgraphics.fase == 11)
            {
                xtgraphics.inst(u[0]);
                xtgraphics.ctachm(xm, ym, mouses, u[0]);
                if(mouses == 2)
                {
                    mouses = 0;
                }
                if(mouses == 1)
                {
                    mouses = 2;
                }
            }
            if(xtgraphics.fase == -5)
            {
                xtgraphics.finish(checkpoints, aconto, u[0]);
                if(flag)
                {
                    if(checkpoints.stage == xtgraphics.unlocked && xtgraphics.winner && xtgraphics.unlocked != 17)
                    {
                        savecookie("unlocked", "" + (xtgraphics.unlocked + 1));
                    }
                    savecookie("gameprfact", "" + (int)f);
                    savecookie("usercar", "" + xtgraphics.sc[0]);
                    flag = false;
                }
                xtgraphics.ctachm(xm, ym, mouses, u[0]);
                if(checkpoints.stage == 17 && xtgraphics.winner)
                {
                    catchlink(1);
                }
                if(mouses == 2)
                {
                    mouses = 0;
                }
                if(mouses == 1)
                {
                    mouses = 2;
                }
            }
            if(xtgraphics.fase == 7)
            {
                xtgraphics.carselect(u[0], aconto, amadness[0]);
                xtgraphics.ctachm(xm, ym, mouses, u[0]);
                if(mouses == 2)
                {
                    mouses = 0;
                }
                if(mouses == 1)
                {
                    mouses = 2;
                }
            }
            if(xtgraphics.fase == 6)
            {
                xtgraphics.musicomp(checkpoints.stage, u[0]);
                xtgraphics.ctachm(xm, ym, mouses, u[0]);
                if(mouses == 2)
                {
                    mouses = 0;
                }
                if(mouses == 1)
                {
                    mouses = 2;
                }
            }
            if(xtgraphics.fase == 5)
            {
                xtgraphics.loadmusic(checkpoints.stage, i1);
                if(!flag)
                {
                    savecookie("usercar", "" + xtgraphics.sc[0]);
                    flag = true;
                }
            }
            if(xtgraphics.fase == 4)
            {
                xtgraphics.cantgo(u[0]);
                xtgraphics.ctachm(xm, ym, mouses, u[0]);
                if(mouses == 2)
                {
                    mouses = 0;
                }
                if(mouses == 1)
                {
                    mouses = 2;
                }
            }
            if(xtgraphics.fase == 3)
            {
                xtgraphics.loadingfailed(checkpoints.stage, u[0]);
                xtgraphics.ctachm(xm, ym, mouses, u[0]);
                if(mouses == 2)
                {
                    mouses = 0;
                }
                if(mouses == 1)
                {
                    mouses = 2;
                }
            }
            if(xtgraphics.fase == 2)
            {
                xtgraphics.loadingstage(checkpoints.stage);
                loadstage(aconto1, aconto, medium, trackers, checkpoints, xtgraphics, amadness, record);
                u[0].falseo();
            }
            if(xtgraphics.fase == 1)
            {
                xtgraphics.trackbg(false);
                medium.aroundtrack(checkpoints);
                int i3 = 0;
                int ai[] = new int[200];
                for(int k5 = 7; k5 < notb; k5++)
                {
                    if(aconto1[k5].dist != 0)
                    {
                        ai[i3] = k5;
                        i3++;
                    } else
                    {
                        aconto1[k5].d(rd);
                    }
                }

                int ai5[] = new int[i3];
                for(int j7 = 0; j7 < i3; j7++)
                {
                    ai5[j7] = 0;
                }

                for(int k7 = 0; k7 < i3; k7++)
                {
                    for(int i11 = k7 + 1; i11 < i3; i11++)
                    {
                        if(aconto1[ai[k7]].dist != aconto1[ai[i11]].dist)
                        {
                            if(aconto1[ai[k7]].dist < aconto1[ai[i11]].dist)
                            {
                                ai5[k7]++;
                            } else
                            {
                                ai5[i11]++;
                            }
                        } else
                        if(i11 > k7)
                        {
                            ai5[k7]++;
                        } else
                        {
                            ai5[i11]++;
                        }
                    }

                }

                for(int l7 = 0; l7 < i3; l7++)
                {
                    for(int j11 = 0; j11 < i3; j11++)
                    {
                        if(ai5[j11] == l7)
                        {
                            aconto1[ai[j11]].d(rd);
                        }
                    }

                }

                xtgraphics.ctachm(xm, ym, mouses, u[0]);
                if(mouses == 2)
                {
                    mouses = 0;
                }
                if(mouses == 1)
                {
                    mouses = 2;
                }
                xtgraphics.stageselect(checkpoints, u[0]);
            }
            if(xtgraphics.fase == 176)
            {
                medium.d(rd);
                int j3 = 0;
                int ai1[] = new int[200];
                for(int i6 = 0; i6 < nob; i6++)
                {
                    if(aconto1[i6].dist != 0)
                    {
                        ai1[j3] = i6;
                        j3++;
                    } else
                    {
                        aconto1[i6].d(rd);
                    }
                }

                int ai6[] = new int[j3];
                for(int i8 = 0; i8 < j3; i8++)
                {
                    ai6[i8] = 0;
                }

                for(int j8 = 0; j8 < j3; j8++)
                {
                    for(int k11 = j8 + 1; k11 < j3; k11++)
                    {
                        if(aconto1[ai1[j8]].dist != aconto1[ai1[k11]].dist)
                        {
                            if(aconto1[ai1[j8]].dist < aconto1[ai1[k11]].dist)
                            {
                                ai6[j8]++;
                            } else
                            {
                                ai6[k11]++;
                            }
                        } else
                        if(k11 > j8)
                        {
                            ai6[j8]++;
                        } else
                        {
                            ai6[k11]++;
                        }
                    }

                }

                for(int k8 = 0; k8 < j3; k8++)
                {
                    for(int l11 = 0; l11 < j3; l11++)
                    {
                        if(ai6[l11] == k8)
                        {
                            aconto1[ai1[l11]].d(rd);
                        }
                    }

                }

                medium.follow(aconto1[0], 0, 0);
                xtgraphics.hipnoload(checkpoints.stage, false);
                if(i1 != 0)
                {
                    i1--;
                } else
                {
                    u[0].enter = false;
                    u[0].handb = false;
                    if(xtgraphics.loadedt[checkpoints.stage - 1])
                    {
                        xtgraphics.stracks[checkpoints.stage - 1].play();
                    }
                    setCursor(new Cursor(0));
                    xtgraphics.fase = 6;
                }
            }
            if(xtgraphics.fase == 0)
            {
                int k3 = 0;
                do
                {
                    if(amadness[k3].newcar)
                    {
                        int j5 = aconto1[k3].xz;
                        int j6 = aconto1[k3].xy;
                        int l8 = aconto1[k3].zy;
                        aconto1[k3] = new ContO(aconto[amadness[k3].cn], aconto1[k3].x, aconto1[k3].y, aconto1[k3].z, 0);
                        aconto1[k3].xz = j5;
                        aconto1[k3].xy = j6;
                        aconto1[k3].zy = l8;
                        amadness[k3].newcar = false;
                    }
                } while(++k3 < 7);
                medium.d(rd);
                k3 = 0;
                int ai2[] = new int[200];
                for(int k6 = 0; k6 < nob; k6++)
                {
                    if(aconto1[k6].dist != 0)
                    {
                        ai2[k3] = k6;
                        k3++;
                    } else
                    {
                        aconto1[k6].d(rd);
                    }
                }

                int ai7[] = new int[k3];
                int ai10[] = new int[k3];
                for(int i12 = 0; i12 < k3; i12++)
                {
                    ai7[i12] = 0;
                }

                for(int j12 = 0; j12 < k3; j12++)
                {
                    for(int i14 = j12 + 1; i14 < k3; i14++)
                    {
                        if(aconto1[ai2[j12]].dist != aconto1[ai2[i14]].dist)
                        {
                            if(aconto1[ai2[j12]].dist < aconto1[ai2[i14]].dist)
                            {
                                ai7[j12]++;
                            } else
                            {
                                ai7[i14]++;
                            }
                        } else
                        if(i14 > j12)
                        {
                            ai7[j12]++;
                        } else
                        {
                            ai7[i14]++;
                        }
                    }

                    ai10[ai7[j12]] = j12;
                }

                for(int k12 = 0; k12 < k3; k12++)
                {
                    aconto1[ai2[ai10[k12]]].d(rd);
                }

                if(xtgraphics.starcnt == 0)
                {
                    int l12 = 0;
                    do
                    {
                        int j14 = 0;
                        do
                        {
                            if(j14 != l12)
                            {
                                amadness[l12].colide(aconto1[l12], amadness[j14], aconto1[j14]);
                            }
                        } while(++j14 < 7);
                    } while(++l12 < 7);
                    l12 = 0;
                    do
                    {
                        amadness[l12].drive(u[l12], aconto1[l12], trackers, checkpoints);
                    } while(++l12 < 7);
                    l12 = 0;
                    do
                    {
                        record.rec(aconto1[l12], l12, amadness[l12].squash, amadness[l12].lastcolido, amadness[l12].cntdest);
                    } while(++l12 < 7);
                    checkpoints.checkstat(amadness, aconto1, record);
                    l12 = 1;
                    do
                    {
                        u[l12].preform(amadness[l12], aconto1[l12], checkpoints, trackers);
                    } while(++l12 < 7);
                } else
                {
                    if(xtgraphics.starcnt == 130)
                    {
                        medium.adv = 1900;
                        medium.zy = 40;
                        medium.vxz = 70;
                        rd.setColor(new Color(255, 255, 255));
                        rd.fillRect(0, 0, 670, 400);
                    }
                    if(xtgraphics.starcnt != 0)
                    {
                        xtgraphics.starcnt--;
                    }
                }
                if(xtgraphics.starcnt < 38)
                {
                    if(view == 0)
                    {
                        medium.follow(aconto1[0], amadness[0].cxz, u[0].lookback);
                        xtgraphics.stat(amadness[0], checkpoints, u[0], true);
                    }
                    if(view == 1)
                    {
                        medium.around(aconto1[0], false);
                        xtgraphics.stat(amadness[0], checkpoints, u[0], false);
                    }
                    if(view == 2)
                    {
                        medium.watch(aconto1[0], amadness[0].mxz);
                        xtgraphics.stat(amadness[0], checkpoints, u[0], false);
                    }
                    if(mouses == 1)
                    {
                        u[0].enter = true;
                        mouses = 0;
                    }
                    if(xtgraphics.starcnt == 36)
                    {
                        repaint();
                        xtgraphics.blendude(offImage);
                    }
                } else
                {
                    medium.around(aconto1[3], true);
                    if(u[0].enter || u[0].handb)
                    {
                        xtgraphics.starcnt = 38;
                        u[0].enter = false;
                        u[0].handb = false;
                    }
                    if(xtgraphics.starcnt == 38)
                    {
                        mouses = 0;
                        medium.vert = false;
                        medium.adv = 900;
                        medium.vxz = 180;
                        checkpoints.checkstat(amadness, aconto1, record);
                        medium.follow(aconto1[0], amadness[0].cxz, 0);
                        xtgraphics.stat(amadness[0], checkpoints, u[0], true);
                        rd.setColor(new Color(255, 255, 255));
                        rd.fillRect(0, 0, 670, 400);
                    }
                }
            }
            if(xtgraphics.fase == -1)
            {
                if(k1 == 0)
                {
                    int i4 = 0;
                    do
                    {
                        record.ocar[i4] = new ContO(aconto1[i4], 0, 0, 0, 0);
                        aconto1[i4] = new ContO(record.car[0][i4], 0, 0, 0, 0);
                    } while(++i4 < 7);
                }
                medium.d(rd);
                int j4 = 0;
                int ai3[] = new int[100];
                for(int l6 = 0; l6 < nob; l6++)
                {
                    if(aconto1[l6].dist != 0)
                    {
                        ai3[j4] = l6;
                        j4++;
                    } else
                    {
                        aconto1[l6].d(rd);
                    }
                }

                int ai8[] = new int[j4];
                for(int i9 = 0; i9 < j4; i9++)
                {
                    ai8[i9] = 0;
                }

                for(int j9 = 0; j9 < j4; j9++)
                {
                    for(int i13 = j9 + 1; i13 < j4; i13++)
                    {
                        if(aconto1[ai3[j9]].dist != aconto1[ai3[i13]].dist)
                        {
                            if(aconto1[ai3[j9]].dist < aconto1[ai3[i13]].dist)
                            {
                                ai8[j9]++;
                            } else
                            {
                                ai8[i13]++;
                            }
                        } else
                        if(i13 > j9)
                        {
                            ai8[j9]++;
                        } else
                        {
                            ai8[i13]++;
                        }
                    }

                }

                for(int k9 = 0; k9 < j4; k9++)
                {
                    for(int j13 = 0; j13 < j4; j13++)
                    {
                        if(ai8[j13] == k9)
                        {
                            aconto1[ai3[j13]].d(rd);
                        }
                    }

                }

                if(u[0].enter || u[0].handb || mouses == 1)
                {
                    k1 = 299;
                    u[0].enter = false;
                    u[0].handb = false;
                    mouses = 0;
                }
                int l9 = 0;
                do
                {
                    if(record.fix[l9] == k1)
                    {
                        if(aconto1[l9].dist == 0)
                        {
                            aconto1[l9].fcnt = 8;
                        } else
                        {
                            aconto1[l9].fix = true;
                        }
                    }
                    if(aconto1[l9].fcnt == 7 || aconto1[l9].fcnt == 8)
                    {
                        aconto1[l9] = new ContO(aconto[amadness[l9].cn], 0, 0, 0, 0);
                        record.cntdest[l9] = 0;
                    }
                    if(k1 == 299)
                    {
                        aconto1[l9] = new ContO(record.ocar[l9], 0, 0, 0, 0);
                    }
                    record.play(aconto1[l9], amadness[l9], l9, k1);
                } while(++l9 < 7);
                if(++k1 == 300)
                {
                    k1 = 0;
                    xtgraphics.fase = -6;
                } else
                {
                    xtgraphics.replyn();
                }
                medium.around(aconto1[0], false);
            }
            if(xtgraphics.fase == -2)
            {
                if(record.hcaught && record.wasted == 0 && record.whenwasted != 229 && checkpoints.stage <= 2 && xtgraphics.looped != 0)
                {
                    record.hcaught = false;
                }
                if(record.hcaught)
                {
                    if((double)medium.random() > 0.45000000000000001D)
                    {
                        medium.vert = false;
                    } else
                    {
                        medium.vert = true;
                    }
                    medium.adv = (int)(900F * medium.random());
                    medium.vxz = (int)(360F * medium.random());
                    k1 = 0;
                    xtgraphics.fase = -3;
                    i2 = 0;
                    j2 = 0;
                } else
                {
                    k1 = -2;
                    xtgraphics.fase = -4;
                }
            }
            if(xtgraphics.fase == -3)
            {
                if(k1 == 0)
                {
                    if(record.wasted == 0)
                    {
                        if(record.whenwasted == 229)
                        {
                            k2 = 67;
                            medium.vxz += 90;
                        } else
                        {
                            k2 = (int)(medium.random() * 4F);
                            if(k2 == 1 || k2 == 3)
                            {
                                k2 = 69;
                            }
                            if(k2 == 2 || k2 == 4)
                            {
                                k2 = 30;
                            }
                        }
                    } else
                    if(record.closefinish != 0 && j2 != 0)
                    {
                        medium.vxz += 90;
                    }
                    int k4 = 0;
                    do
                    {
                        aconto1[k4] = new ContO(record.starcar[k4], 0, 0, 0, 0);
                    } while(++k4 < 7);
                }
                medium.d(rd);
                int i5 = 0;
                int ai4[] = new int[100];
                for(int i7 = 0; i7 < nob; i7++)
                {
                    if(aconto1[i7].dist != 0)
                    {
                        ai4[i5] = i7;
                        i5++;
                    } else
                    {
                        aconto1[i7].d(rd);
                    }
                }

                int ai9[] = new int[i5];
                for(int i10 = 0; i10 < i5; i10++)
                {
                    ai9[i10] = 0;
                }

                for(int j10 = 0; j10 < i5; j10++)
                {
                    for(int k13 = j10 + 1; k13 < i5; k13++)
                    {
                        if(aconto1[ai4[j10]].dist != aconto1[ai4[k13]].dist)
                        {
                            if(aconto1[ai4[j10]].dist < aconto1[ai4[k13]].dist)
                            {
                                ai9[j10]++;
                            } else
                            {
                                ai9[k13]++;
                            }
                        } else
                        if(k13 > j10)
                        {
                            ai9[j10]++;
                        } else
                        {
                            ai9[k13]++;
                        }
                    }

                }

                for(int k10 = 0; k10 < i5; k10++)
                {
                    for(int l13 = 0; l13 < i5; l13++)
                    {
                        if(ai9[l13] == k10)
                        {
                            aconto1[ai4[l13]].d(rd);
                        }
                    }

                }

                int l10 = 0;
                do
                {
                    if(record.hfix[l10] == k1)
                    {
                        if(aconto1[l10].dist == 0)
                        {
                            aconto1[l10].fcnt = 8;
                        } else
                        {
                            aconto1[l10].fix = true;
                        }
                    }
                    if(aconto1[l10].fcnt == 7 || aconto1[l10].fcnt == 8)
                    {
                        aconto1[l10] = new ContO(aconto[amadness[l10].cn], 0, 0, 0, 0);
                        record.cntdest[l10] = 0;
                    }
                    record.playh(aconto1[l10], amadness[l10], l10, k1);
                } while(++l10 < 7);
                if(j2 == 2 && k1 == 299)
                {
                    u[0].enter = true;
                }
                if(u[0].enter || u[0].handb)
                {
                    xtgraphics.fase = -4;
                    u[0].enter = false;
                    u[0].handb = false;
                    k1 = -7;
                } else
                {
                    xtgraphics.levelhigh(record.wasted, record.whenwasted, record.closefinish, k1, checkpoints.stage);
                    if(k1 == 0 || k1 == 1 || k1 == 2)
                    {
                        rd.setColor(new Color(0, 0, 0));
                        rd.fillRect(0, 0, 670, 400);
                    }
                    if(record.wasted != 0)
                    {
                        if(record.closefinish == 0)
                        {
                            if(i2 == 9 || i2 == 11)
                            {
                                rd.setColor(new Color(255, 255, 255));
                                rd.fillRect(0, 0, 670, 400);
                            }
                            if(i2 == 0)
                            {
                                medium.around(aconto1[0], false);
                            }
                            if(i2 > 0 && i2 < 20)
                            {
                                medium.transaround(aconto1[0], aconto1[record.wasted], i2);
                            }
                            if(i2 == 20)
                            {
                                medium.around(aconto1[record.wasted], false);
                            }
                            if(k1 > record.whenwasted && i2 != 20)
                            {
                                i2++;
                            }
                            if((i2 == 0 || i2 == 20) && ++k1 == 300)
                            {
                                k1 = 0;
                                i2 = 0;
                                j2++;
                            }
                        } else
                        if(record.closefinish == 1)
                        {
                            if(i2 == 0)
                            {
                                medium.around(aconto1[0], false);
                            }
                            if(i2 > 0 && i2 < 20)
                            {
                                medium.transaround(aconto1[0], aconto1[record.wasted], i2);
                            }
                            if(i2 == 20)
                            {
                                medium.around(aconto1[record.wasted], false);
                            }
                            if(i2 > 20 && i2 < 40)
                            {
                                medium.transaround(aconto1[record.wasted], aconto1[0], i2 - 20);
                            }
                            if(i2 == 40)
                            {
                                medium.around(aconto1[0], false);
                            }
                            if(i2 > 40 && i2 < 60)
                            {
                                medium.transaround(aconto1[0], aconto1[record.wasted], i2 - 40);
                            }
                            if(i2 == 60)
                            {
                                medium.around(aconto1[record.wasted], false);
                            }
                            if(k1 > 160 && i2 < 20)
                            {
                                i2++;
                            }
                            if(k1 > 230 && i2 < 40)
                            {
                                i2++;
                            }
                            if(k1 > 280 && i2 < 60)
                            {
                                i2++;
                            }
                            if((i2 == 0 || i2 == 20 || i2 == 40 || i2 == 60) && ++k1 == 300)
                            {
                                k1 = 0;
                                i2 = 0;
                                j2++;
                            }
                        } else
                        {
                            if(i2 == 0)
                            {
                                medium.around(aconto1[0], false);
                            }
                            if(i2 > 0 && i2 < 20)
                            {
                                medium.transaround(aconto1[0], aconto1[record.wasted], i2);
                            }
                            if(i2 == 20)
                            {
                                medium.around(aconto1[record.wasted], false);
                            }
                            if(i2 > 20 && i2 < 40)
                            {
                                medium.transaround(aconto1[record.wasted], aconto1[0], i2 - 20);
                            }
                            if(i2 == 40)
                            {
                                medium.around(aconto1[0], false);
                            }
                            if(i2 > 40 && i2 < 60)
                            {
                                medium.transaround(aconto1[0], aconto1[record.wasted], i2 - 40);
                            }
                            if(i2 == 60)
                            {
                                medium.around(aconto1[record.wasted], false);
                            }
                            if(i2 > 60 && i2 < 80)
                            {
                                medium.transaround(aconto1[record.wasted], aconto1[0], i2 - 60);
                            }
                            if(i2 == 80)
                            {
                                medium.around(aconto1[0], false);
                            }
                            if(k1 > 90 && i2 < 20)
                            {
                                i2++;
                            }
                            if(k1 > 160 && i2 < 40)
                            {
                                i2++;
                            }
                            if(k1 > 230 && i2 < 60)
                            {
                                i2++;
                            }
                            if(k1 > 280 && i2 < 80)
                            {
                                i2++;
                            }
                            if((i2 == 0 || i2 == 20 || i2 == 40 || i2 == 60 || i2 == 80) && ++k1 == 300)
                            {
                                k1 = 0;
                                i2 = 0;
                                j2++;
                            }
                        }
                    } else
                    {
                        if(k2 == 67 && (i2 == 3 || i2 == 31 || i2 == 66))
                        {
                            rd.setColor(new Color(255, 255, 255));
                            rd.fillRect(0, 0, 670, 400);
                        }
                        if(k2 == 69 && (i2 == 3 || i2 == 5 || i2 == 31 || i2 == 33 || i2 == 66 || i2 == 68))
                        {
                            rd.setColor(new Color(255, 255, 255));
                            rd.fillRect(0, 0, 670, 400);
                        }
                        if(k2 == 30 && i2 >= 1 && i2 < 30)
                        {
                            if(i2 % (int)(2.0F + medium.random() * 3F) == 0 && !flag2)
                            {
                                rd.setColor(new Color(255, 255, 255));
                                rd.fillRect(0, 0, 670, 400);
                                flag2 = true;
                            } else
                            {
                                flag2 = false;
                            }
                        }
                        if(k1 > record.whenwasted && i2 != k2)
                        {
                            i2++;
                        }
                        medium.around(aconto1[0], false);
                        if((i2 == 0 || i2 == k2) && ++k1 == 300)
                        {
                            k1 = 0;
                            i2 = 0;
                            j2++;
                        }
                    }
                }
            }
            if(xtgraphics.fase == -4)
            {
                if(k1 <= 0)
                {
                    rd.drawImage(xtgraphics.mdness, 224, 30, null);
                    rd.drawImage(xtgraphics.dude[0], 70, 10, null);
                }
                if(k1 >= 0)
                {
                    xtgraphics.fleximage(offImage, k1, checkpoints.stage);
                }
                k1++;
                if(checkpoints.stage == 17 && k1 == 10)
                {
                    xtgraphics.fase = -5;
                }
                if(k1 == 12)
                {
                    xtgraphics.fase = -5;
                }
            }
            if(xtgraphics.fase == -6)
            {
                repaint();
                xtgraphics.pauseimage(offImage);
                xtgraphics.fase = -7;
                mouses = 0;
            }
            if(xtgraphics.fase == -7)
            {
                xtgraphics.pausedgame(checkpoints.stage, u[0], record);
                if(k1 != 0)
                {
                    k1 = 0;
                }
                xtgraphics.ctachm(xm, ym, mouses, u[0]);
                if(mouses == 2)
                {
                    mouses = 0;
                }
                if(mouses == 1)
                {
                    mouses = 2;
                }
            }
            if(xtgraphics.fase == -8)
            {
                xtgraphics.cantreply();
                if(++k1 == 150 || u[0].enter || u[0].handb || mouses == 1)
                {
                    xtgraphics.fase = -7;
                    mouses = 0;
                    u[0].enter = false;
                    u[0].handb = false;
                }
            }
            if(lostfcs && xtgraphics.fase != 176 && xtgraphics.fase != 111)
            {
                if(xtgraphics.fase == 0)
                {
                    u[0].enter = true;
                } else
                {
                    xtgraphics.nofocus();
                }
                if(mouses == 1 || mouses == 2)
                {
                    lostfcs = false;
                }
            }
            repaint();
            xtgraphics.playsounds(amadness[0], u[0], checkpoints.stage);
            date1 = new Date();
            long l5 = date1.getTime();
            if(xtgraphics.fase == 0 || xtgraphics.fase == -1 || xtgraphics.fase == -3)
            {
                if(!flag1)
                {
                    f1 = f;
                    flag1 = true;
                    j1 = 0;
                }
                if(j1 == 10)
                {
                    if(l5 - l3 < (long)j)
                    {
                        f1 = (float)((double)f1 + 0.5D);
                    } else
                    {
                        f1 = (float)((double)f1 - 0.5D);
                        if(f1 < 5F)
                        {
                            f1 = 5F;
                        }
                    }
                    if(xtgraphics.starcnt == 0)
                    {
                        medium.adjstfade(f1);
                    }
                    l3 = l5;
                    j1 = 0;
                } else
                {
                    j1++;
                }
            } else
            {
                if(flag1)
                {
                    f = f1;
                    flag1 = false;
                    j1 = 0;
                }
                if(i1 == 0 || xtgraphics.fase != 176)
                {
                    if(j1 == 10)
                    {
                        if(l5 - l3 < 400L)
                        {
                            f1 = (float)((double)f1 + 3.5D);
                        } else
                        {
                            f1 = (float)((double)f1 - 3.5D);
                            if(f1 < 5F)
                            {
                                f1 = 5F;
                            }
                        }
                        l3 = l5;
                        j1 = 0;
                    } else
                    {
                        j1++;
                    }
                } else
                {
                    if(i1 == 79)
                    {
                        f1 = f;
                        l3 = l5;
                        j1 = 0;
                    }
                    if(j1 == 10)
                    {
                        if(l5 - l3 < (long)j)
                        {
                            f1 += 5F;
                        } else
                        {
                            f1 -= 5F;
                            if(f1 < 5F)
                            {
                                f1 = 5F;
                            }
                        }
                        l3 = l5;
                        j1 = 0;
                    } else
                    {
                        j1++;
                    }
                    if(i1 == 1)
                    {
                        f = f1;
                    }
                }
            }
            if(exwist)
            {
                rd.dispose();
                xtgraphics.stopallnow();
                System.gc();
                gamer.stop();
                gamer = null;
            }
            long l2 = (long)Math.round(f1) - (l5 - l4);
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

    public void init()
    {
        offImage = createImage(670, 400);
        if(offImage != null)
        {
            rd = offImage.getGraphics();
        }
        cookieDir();
        if (!initKeySettings())
            initDefaultKeySettings();
        setFocusTraversalKeysEnabled(false);
    }

    public void savecookie(String s, String s1)
    {
        try
        {
            PrintWriter pw = new PrintWriter(new File("/files/nfm2/cookies/" + s));
            pw.println(s1);
            pw.flush();
            pw.close();
        }
        catch(Exception _ex) { }
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

    public void catchlink(int i)
    {
        if (!lostfcs) {
            if (i == 0) {
                if (xm >= 0 && xm < 670 && ym > 110 && ym < 169 || xm > 210 && xm < 460 && ym > 240 && ym < 259) {
                    setCursor(new Cursor(12));
                    if (mouses == 2) {
                        open("www.radicalplay.com");
                    }
                }
            }
            if (i == 1) {
                if (xm >= 0 && xm < 670 && ym > 205 && ym < 267) {
                    setCursor(new Cursor(12));
                    if (mouses == 2) {
                        open("www.radicalplay.com");
                    }
                }
            }
        }
    }

    public boolean mouseMove(Event event, int i, int j)
    {
        if(!exwist && !lostfcs)
        {
            xm = i;
            ym = j;
        }
        return false;
    }
    
    public boolean cookieDir() {
        File f = new File("/files/nfm2/cookies");
        if (f.exists() && f.isDirectory())
            return true;
        return f.mkdir();
    }
    
    public boolean initKeySettings() {
        try {
            File file = new File("/files/nfm2/KeySettings.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String string;
            while((string = br.readLine()) != null) {
                if (string.startsWith("up("))
                    upKeys.add(getint("up", string, 0));
                if (string.startsWith("down("))
                    downKeys.add(getint("down", string, 0));
                if (string.startsWith("right("))
                    rightKeys.add(getint("right", string, 0));
                if (string.startsWith("left("))
                    leftKeys.add(getint("left", string, 0));
                if (string.startsWith("handb("))
                    handbKeys.add(getint("handb", string, 0));
                if (string.startsWith("x("))
                    xKeys.add(getint("x", string, 0));
                if (string.startsWith("z("))
                    zKeys.add(getint("z", string, 0));
                if (string.startsWith("enter("))
                    enterKeys.add(getint("enter", string, 0));
                if (string.startsWith("arrace("))
                    arraceKeys.add(getint("arrace", string, 0));
                if (string.startsWith("mutem("))
                    mutemKeys.add(getint("mutem", string, 0));
                if (string.startsWith("mutes("))
                    mutesKeys.add(getint("mutes", string, 0));
                if (string.startsWith("view("))
                    viewKeys.add(getint("view", string, 0));
            }
        } catch (IOException ex) {
            return false;
        }
        return true;
    }
    
    public void initDefaultKeySettings() {
        upKeys.add(1004);
        downKeys.add(1005);
        rightKeys.add(1007);
        leftKeys.add(1006);
        handbKeys.add(32);
        xKeys.add(120);
        xKeys.add(88);
        zKeys.add(122);
        zKeys.add(90);
        enterKeys.add(10);
        enterKeys.add(80);
        enterKeys.add(112);
        enterKeys.add(27);
        arraceKeys.add(65);
        arraceKeys.add(97);
        mutemKeys.add(77);
        mutemKeys.add(109);
        mutesKeys.add(78);
        mutesKeys.add(110);
        viewKeys.add(86);
        viewKeys.add(118);
    }
    
    public static void main(String args[]) {
        Frame f = new Frame();
        f.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            };
        });
        
        GameSparker gs = new GameSparker();
        gs.setPreferredSize(new Dimension(670, 400));
        f.add(gs);
        f.pack();
        f.setTitle("NEED FOR MADNESS 2");
        f.setIconImage(Toolkit.getDefaultToolkit().getImage("data/icon.png"));
        f.show();
        gs.init();
        gs.start();
    }
}
