import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class xtGraphics extends Panel
    implements Runnable
{

    Graphics rd;
    Medium m;
    FontMetrics ftm;
    ImageObserver ob;
    Panel pane;
    int fase;
    int oldfase;
    int starcnt;
    int unlocked;
    int lockcnt;
    int opselect;
    boolean shaded;
    int flipo;
    boolean nextc;
    int gatey;
    int looped;
    int sc[];
    int xstart[] = {
        0, -350, 350, 0, -350, 350, 0
    };
    int zstart[] = {
        -760, -380, -380, 0, 380, 380, 760
    };
    float proba[] = {
        0.6F, 0.7F, 0.4F, 0.3F, 0.8F, 0, 0.3F, 0.3F, 0.3F, 0.1F, 
        0.1F, 0.5F, 0, 0, 0, 0
    };
    float dishandle[] = {
        0.65F, 0.6F, 0.55F, 0.77F, 0.62F, 0.9F, 0.6F, 0.72F, 0.45F, 0.8F, 
        0.95F, 0.4F, 0.87F, 0.42F, 1.0F, 0.95F
    };
    float outdam[] = {
        0.67F, 0.35F, 0.8F, 0.5F, 0.42F, 0.76F, 0.82F, 0.76F, 0.72F, 0.62F, 
        0.79F, 0.95F, 0.77F, 1.0F, 0.85F, 1.0F
    };
    boolean holdit;
    int holdcnt;
    boolean winner;
    int flexpix[];
    int smokey[];
    Image fleximg;
    int flatrstart;
    Thread runner;
    int runtyp;
    Image odmg;
    Image opwr;
    Image opos;
    Image owas;
    Image olap;
    Image oyourwasted;
    Image oyoulost;
    Image oyouwon;
    Image oyouwastedem;
    Image ogameh;
    Image oloadingmusic;
    Image oflaot;
    Image dmg;
    Image pwr;
    Image pos;
    Image was;
    Image lap;
    Image br;
    Image select;
    Image loadingmusic;
    Image yourwasted;
    Image youlost;
    Image youwon;
    Image youwastedem;
    Image gameh;
    Image congrd;
    Image gameov;
    Image carsbg;
    Image pgate;
    Image selectcar;
    Image statb;
    Image statbo;
    Image mdness;
    Image paused;
    Image radicalplay;
    Image logocars;
    Image logomadnes;
    Image logomadbg;
    Image byrd;
    Image opback;
    Image nfmcoms;
    Image opti;
    Image bgmain;
    Image rpro;
    Image nfmcom;
    Image flaot;
    Image fixhoop;
    Image sarrow;
    Image stunts;
    Image racing;
    Image wasting;
    Image plus;
    Image space;
    Image arrows;
    Image chil;
    Image ory;
    Image kz;
    Image kx;
    Image kv;
    Image kp;
    Image km;
    Image kn;
    Image kenter;
    Image nfm;
    Image trackbg[][];
    Image dude[];
    Image dudeb[];
    int duds;
    int dudo;
    Image next[];
    Image back[];
    Image contin[];
    Image ostar[];
    Image star[];
    int pcontin;
    int pnext;
    int pback;
    int pstar;
    Image orank[];
    Image rank[];
    Image ocntdn[];
    Image cntdn[];
    int gocnt;
    Clip engs[][];
    boolean pengs[];
    int enginsignature[] = {
        0, 1, 2, 1, 0, 3, 2, 2, 1, 0, 
        3, 4, 1, 4, 0, 3
    };
    Clip air[];
    boolean aird;
    boolean grrd;
    Clip crash[];
    Clip lowcrash[];
    Clip tires;
    Clip checkpoint;
    Clip carfixed;
    Clip powerup;
    Clip three;
    Clip two;
    Clip one;
    Clip go;
    Clip wastd;
    Clip firewasted;
    boolean pwastd;
    Clip skid[];
    Clip dustskid[];
    boolean mutes;
    RadicalMod stages;
    RadicalMod cars;
    RadicalMod stracks[];
    boolean loadedt[];
    int lastload;
    boolean mutem;
    boolean sunny;
    boolean macn;
    boolean arrace;
    int ana;
    int cntan;
    int cntovn;
    boolean flk;
    int tcnt;
    boolean tflk;
    String say;
    boolean wasay;
    int clear;
    int posit;
    int wasted;
    int laps;
    int dested[];
    String names[] = {
        "Tornado Shark", "Formula 7", "Wow Caninaro", "La Vita Crab", "Nimi", "MAX Revenge", "Lead Oxide", "Kool Kat", "Drifter X", "Sword of Justice", 
        "High Rider", "EL KING", "Mighty Eight", "M A S H E E N", "Radical One", "DR Monstaa"
    };
    int dmcnt;
    boolean dmflk;
    int pwcnt;
    boolean pwflk;
    String adj[][] = {
        {
            "Cool", "Alright", "Nice"
        }, {
            "Wicked", "Amazing", "Super"
        }, {
            "Awesome", "Ripping", "Radical"
        }, {
            "What the...?", "Your a super star!!!!", "Who are you again...?"
        }, {
            "surf style", "off the lip", "bounce back"
        }
    };
    String exlm[] = {
        "!", "!!", "!!!"
    };
    String loop;
    String spin;
    String asay;
    int auscnt;
    boolean aflk;
    int sndsize[] = {
        106, 76, 56, 116, 92, 208, 70, 80, 152, 102, 
        27, 65, 52, 30, 151, 129, 70
    };
    Image hello;
    Image sign;
    Image loadbar;
    int kbload;
    int dnload;
    float shload;
    int radpx;
    int pin;
    int bgmy[] = {
        0, 400
    };
    int trkx[] = {
        0, 670
    };
    int trkl;
    int trklim;
    float hipno[] = {
        1.0F, 1.0F, 3F, 1.0F, 1.2F, 1.0F, 1.7F, 1.0F, 1.0F, 8F, 
        1.5F, 2.0F, 1.2F, 10F, 1.8F, 1.4F, 2.0F
    };
    int flkat;
    int movly;
    int xdu;
    int ydu;
    int gxdu;
    int gydu;
    int pgatx[] = {
        146, 175, 215, 267, 334, 401, 452, 493, 521
    };
    int pgaty[] = {
        168, 188, 201, 212, 219, 214, 203, 189, 171
    };
    int pgady[];
    boolean pgas[];
    int lxm;
    int lym;
    int pwait;
    int stopcnt;
    int cntwis;
    int crshturn;
    int bfcrash;
    int bfskid;
    boolean crashup;
    boolean skidup;
    int skflg;
    int dskflg;
    int flatr;
    int flyr;
    int flyrdest;
    int flang;
    int flangados;
    float blackn;
    float blacknados;

    public boolean over(Image image, int i, int j, int k, int l)
    {
        int i1 = image.getHeight(ob);
        int j1 = image.getWidth(ob);
        return i > k - 5 && i < k + j1 + 5 && j > l - 5 && j < l + i1 + 5;
    }

    public void cantgo(Control control)
    {
        pnext = 0;
        trackbg(false);
        rd.setFont(new Font("SansSerif", 1, 13));
        ftm = rd.getFontMetrics();
        drawcs(110, "This stage will be unlocked when stage " + unlocked + " is complete!", 177, 177, 177, 3);
        int i = 0;
        do
        {
            rd.drawImage(pgate, 212 + i * 30, 190, null);
        } while(++i < 9);
        rd.setFont(new Font("SansSerif", 1, 11));
        ftm = rd.getFontMetrics();
        if(aflk)
        {
            drawcs(160, "[ Stage " + (unlocked + 1) + " Locked ]", 255, 128, 0, 3);
            aflk = false;
        } else
        {
            drawcs(160, "[ Stage " + (unlocked + 1) + " Locked ]", 255, 0, 0, 3);
            aflk = true;
        }
        rd.drawImage(select, 273, 45, null);
        rd.drawImage(br, 0, 0, null);
        rd.drawImage(back[pback], 305, 320, null);
        rd.setFont(new Font("SansSerif", 1, 11));
        ftm = rd.getFontMetrics();
        drawcs(396, "You can also use Keyboard Arrows and Enter to navigate.", 82, 90, 0, 3);
        lockcnt--;
        if(lockcnt == 0 || control.enter || control.handb || control.left)
        {
            control.left = false;
            control.handb = false;
            control.enter = false;
            fase = 1;
        }
    }

    public void loadingstage(int i)
    {
        trackbg(true);
        rd.setColor(new Color(177, 177, 177));
        rd.fillRoundRect(200, 150, 270, 52, 20, 40);
        rd.setColor(new Color(120, 120, 120));
        rd.drawRoundRect(200, 150, 270, 52, 20, 40);
        rd.setFont(new Font("SansSerif", 1, 13));
        ftm = rd.getFontMetrics();
        drawcs(180, "Loading Stage " + i + ", please wait...", 0, 0, 0, 3);
        rd.drawImage(select, 273, 45, null);
        rd.drawImage(br, 0, 0, null);
        rd.setFont(new Font("SansSerif", 1, 11));
        ftm = rd.getFontMetrics();
        drawcs(396, "You can also use Keyboard Arrows and Enter to navigate.", 82, 90, 0, 3);
        pane.repaint();
        if(lastload != -22)
        {
            stages.loadMod(135, 7800, 125, sunny, macn);
            lastload = -22;
        } else
        {
            stages.stop();
        }
    }

    public void inst(Control control)
    {
        if(flipo == 0)
        {
            flipo = 1;
            bgmy[0] = 0;
            bgmy[1] = 400;
        }
        if(flipo == 2)
        {
            flipo = 3;
            dudo = 200;
        }
        if(flipo == 4)
        {
            flipo = 5;
            dudo = 250;
        }
        if(flipo == 6)
        {
            flipo = 7;
            dudo = 200;
        }
        if(flipo == 8)
        {
            flipo = 9;
            dudo = 250;
        }
        if(flipo == 10)
        {
            flipo = 11;
            dudo = 200;
        }
        if(flipo == 12)
        {
            flipo = 13;
            dudo = 200;
        }
        if(flipo == 14)
        {
            flipo = 15;
            dudo = 100;
        }
        int i = 0;
        do
        {
            rd.drawImage(bgmain, 0, bgmy[i], null);
            bgmy[i] -= 2;
            if(bgmy[i] <= -400)
            {
                bgmy[i] = 400;
            }
        } while(++i < 2);
        if(aflk)
        {
            aflk = false;
        } else
        {
            aflk = true;
        }
        if(flipo != 1)
        {
            if(dudo > 0)
            {
                if(aflk)
                {
                    if(Math.random() > Math.random())
                    {
                        duds = (int)(Math.random() * 3D);
                    } else
                    {
                        duds = (int)(Math.random() * 2D);
                    }
                }
                dudo--;
            } else
            {
                duds = 0;
            }
            rd.drawImage(dude[duds], 30, -10, null);
            rd.drawImage(oflaot, 127, 17, null);
        }
        rd.setColor(new Color(0, 0, 0));
        rd.setFont(new Font("SansSerif", 1, 13));
        if(flipo == 3 || flipo == 5)
        {
            if(flipo == 3)
            {
                rd.drawString("Hello!  Welcome to the world of", 197, 42);
                rd.drawString("!", 592, 42);
                rd.drawImage(nfm, 404, 30, null);
                rd.drawString("In this game there are two ways to complete a stage.", 197, 82);
                rd.drawString("One is by racing and finishing in first place, the other is by", 197, 102);
                rd.drawString("wasting and crashing all the other cars in the stage!", 197, 122);
            } else
            {
                rd.setColor(new Color(100, 100, 100));
                rd.drawString("While racing, you will need to focus on going fast and passing", 197, 42);
                rd.drawString("through all the checkpoints in the track. To complete a lap, you", 197, 62);
                rd.drawString("must not miss a checkpoint.", 197, 82);
                rd.drawString("While wasting, you will just need to chase the other cars and", 197, 102);
                rd.drawString("crash into them (without worrying about track and checkpoints).", 197, 122);
                rd.setColor(new Color(0, 0, 0));
            }
            rd.drawImage(racing, 100, 160, null);
            rd.drawImage(ory, 364, 210, null);
            rd.drawImage(wasting, 427, 160, null);
            rd.setFont(new Font("SansSerif", 1, 11));
            rd.drawString("Checkpoint", 327, 164);
            rd.setFont(new Font("SansSerif", 1, 13));
            rd.drawString("Drive your car using the Arrow Keys and Spacebar :", 60, 295);
            rd.drawImage(space, 106, 330, null);
            rd.drawImage(arrows, 440, 298, null);
            rd.setFont(new Font("SansSerif", 1, 11));
            rd.drawString("(When your car is on the ground Spacebar is for Handbrake)", 60, 316);
            rd.drawString("Accelerate", 450, 294);
            rd.drawString("Brake/Reverse", 441, 372);
            rd.drawString("Turn left", 389, 350);
            rd.drawString("Turn right", 525, 350);
            rd.drawString("Handbrake", 182, 349);
        }
        if(flipo == 7 || flipo == 9)
        {
            if(flipo == 7)
            {
                rd.drawString("Whether you are racing or wasting the other cars you will need", 197, 42);
                rd.drawString("to power up your car.", 197, 62);
                rd.drawString("=> More 'Power' makes your car become faster and stronger!", 197, 82);
                rd.drawString("To power up your car (and keep it powered up) you will need to", 197, 102);
                rd.drawString("perform stunts!", 197, 122);
                rd.drawImage(chil, 102, 270, null);
            } else
            {
                rd.drawString("The better the stunt the more power you get!", 197, 42);
                rd.setColor(new Color(100, 100, 100));
                rd.drawString("Forward looping pushes your car forwards in the air and helps", 197, 62);
                rd.drawString("when racing. Backward looping pushes your car upwards giving it", 197, 82);
                rd.drawString("more hang time in the air making it easier to control its landing.", 197, 102);
                rd.drawString("Left and right rolls shift your car in the air left and right slightly.", 197, 122);
                if(aflk || dudo < 150)
                {
                    rd.drawImage(chil, 102, 270, null);
                }
                rd.setColor(new Color(0, 0, 0));
            }
            rd.drawImage(stunts, 40, 150, null);
            rd.drawImage(opwr, 475, 228, null);
            rd.setFont(new Font("SansSerif", 1, 13));
            rd.drawString("To perform stunts. When your car is in the AIR;", 60, 285);
            rd.drawString("Press combo Spacebar + Arrow Keys :", 60, 305);
            rd.drawImage(space, 120, 330, null);
            rd.drawImage(plus, 340, 333, null);
            rd.drawImage(arrows, 426, 298, null);
            rd.setFont(new Font("SansSerif", 1, 11));
            rd.setColor(new Color(0, 0, 0));
            rd.drawString("Forward Loop", 427, 294);
            rd.drawString("Backward Loop", 425, 372);
            rd.drawString("Left Roll", 378, 350);
            rd.drawString("Right Roll", 511, 350);
            rd.drawString("Spacebar", 201, 349);
            rd.setColor(new Color(140, 243, 244));
            rd.fillRect(537, 232, 76, 9);
        }
        if(flipo == 11 || flipo == 13)
        {
            if(flipo == 11)
            {
                rd.drawString("When wasting cars, to help you find the other cars in the stage,", 197, 42);
                rd.drawString("press [ A ] to toggle the guidance arrow from pointing to the track", 197, 62);
                rd.drawString("to pointing to the cars.", 197, 82);
                rd.drawString("When your car is damaged. You fix it (and reset its 'Damage') by", 197, 102);
                rd.drawString("jumping through the electrified hoop.", 197, 122);
            } else
            {
                rd.setColor(new Color(100, 100, 100));
                rd.drawString("You will find that in some stages it's easier to waste the other cars", 197, 42);
                rd.drawString("and in some others it's easier to race and finish in first place.", 197, 62);
                rd.drawString("It is up to you to decide when to waste and when to race.", 197, 82);
                rd.drawString("And remember, 'Power' is an important factor in the game. You", 197, 102);
                rd.drawString("will need it whether you are racing or wasting!", 197, 122);
                rd.setColor(new Color(0, 0, 0));
            }
            rd.drawImage(fixhoop, 120, 193, null);
            rd.drawImage(sarrow, 320, 203, null);
            rd.setFont(new Font("SansSerif", 1, 11));
            rd.drawString("The Electrified Hoop", 127, 191);
            rd.drawString("Jumping through it fixes your car.", 93, 313);
            rd.drawString("Make guidance arrow point to cars.", 320, 191);
        }
        if(flipo == 15)
        {
            rd.drawString("There is a total of 17 stages!", 197, 42);
            rd.drawString("Every two stages completed a new car will be unlocked!", 197, 62);
            rd.drawString("I am Coach Insano by the way.", 197, 102);
            rd.drawString("I am your coach and narrator in this game!  Good Luck!", 197, 122);
            rd.drawString("Other Controls :", 90, 180);
            rd.setFont(new Font("SansSerif", 1, 11));
            rd.drawImage(kz, 100, 200, null);
            rd.drawString("OR", 141, 226);
            rd.drawImage(kx, 160, 200, null);
            rd.drawString("=> To look behind you while driving.", 202, 226);
            rd.drawImage(kv, 100, 250, null);
            rd.drawString("Change Views", 142, 276);
            rd.drawImage(kp, 100, 300, null);
            rd.drawString("OR", 141, 326);
            rd.drawImage(kenter, 160, 300, null);
            rd.drawString("Pause Game", 287, 326);
            rd.drawImage(km, 420, 200, null);
            rd.drawString("Mute Music", 462, 226);
            rd.drawImage(kn, 420, 250, null);
            rd.drawString("Mute Sound Effects", 462, 276);
        }
        if(flipo == 1)
        {
            rd.setFont(new Font("SansSerif", 1, 13));
            ftm = rd.getFontMetrics();
            drawcs(20, "Main Game Controls", 0, 0, 0, 3);
            rd.drawString("Drive your car using the Arrow Keys:", 60, 55);
            rd.drawString("On the GROUND Spacebar is for Handbrake", 60, 76);
            rd.drawImage(space, 106, 90, null);
            rd.drawImage(arrows, 440, 58, null);
            rd.setFont(new Font("SansSerif", 1, 11));
            ftm = rd.getFontMetrics();
            rd.drawString("Accelerate", 450, 54);
            rd.drawString("Brake/Reverse", 441, 132);
            rd.drawString("Turn left", 389, 110);
            rd.drawString("Turn right", 525, 110);
            rd.drawString("Handbrake", 182, 109);
            drawcs(150, "--------------------------------------------------------------------------------" +
"--------------------------------------------------------------------"
, 0, 0, 0, 3);
            rd.setFont(new Font("SansSerif", 1, 13));
            ftm = rd.getFontMetrics();
            rd.drawString("To perform stunts:", 60, 175);
            rd.drawString("In the AIR press combo Spacebar + Arrow Keys :", 60, 195);
            rd.drawImage(space, 120, 220, null);
            rd.drawImage(plus, 340, 223, null);
            rd.drawImage(arrows, 426, 188, null);
            rd.setFont(new Font("SansSerif", 1, 11));
            ftm = rd.getFontMetrics();
            rd.setColor(new Color(0, 0, 0));
            rd.drawString("Forward Loop", 427, 184);
            rd.drawString("Backward Loop", 425, 262);
            rd.drawString("Left Roll", 378, 240);
            rd.drawString("Right Roll", 511, 240);
            rd.drawString("Spacebar", 201, 239);
            rd.drawImage(stunts, 60, 260, null);
        }
        if(flipo >= 1 && flipo <= 13)
        {
            rd.drawImage(next[pnext], 600, 370, null);
        }
        if(flipo >= 3 && flipo <= 15)
        {
            rd.drawImage(back[pback], 10, 370, null);
        }
        if(flipo == 15)
        {
            rd.drawImage(contin[pcontin], 500, 370, null);
        }
        if(control.enter || control.right)
        {
            if(flipo >= 1 && flipo <= 13)
            {
                flipo++;
            }
            if(control.enter && flipo == 15)
            {
                flipo = 0;
                fase = oldfase;
                rd.setFont(new Font("SansSerif", 1, 11));
                ftm = rd.getFontMetrics();
            }
            control.enter = false;
            control.right = false;
        }
        if(control.left)
        {
            if(flipo >= 3 && flipo <= 15)
            {
                flipo -= 3;
            }
            control.left = false;
        }
    }

    public void fleximage(Image image, int i, int j)
    {
        if(i == 0)
        {
            PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, 670, 400, flexpix, 0, 670);
            try
            {
                pixelgrabber.grabPixels();
            }
            catch(InterruptedException _ex) { }
        }
        int k = 0;
        int l = 0;
        int i1 = 0;
        int j1 = 0;
        int k1 = (int)(Math.random() * 128D);
        int l1 = (int)(5D + Math.random() * 15D);
        int i2 = 0;
        do
        {
            Color color = new Color(flexpix[i2]);
            int j2 = 0;
            int k2 = 0;
            int l2 = 0;
            if(k == 0)
            {
                j2 = color.getRed();
                l = j2;
                k2 = color.getGreen();
                i1 = k2;
                l2 = color.getBlue();
                j1 = l2;
            } else
            {
                j2 = (int)(((float)color.getRed() + (float)l * 0.38F * (float)i) / (1.0F + 0.38F * (float)i));
                l = j2;
                k2 = (int)(((float)color.getGreen() + (float)i1 * 0.38F * (float)i) / (1.0F + 0.38F * (float)i));
                i1 = k2;
                l2 = (int)(((float)color.getBlue() + (float)j1 * 0.38F * (float)i) / (1.0F + 0.38F * (float)i));
                j1 = l2;
            }
            if(++k == 670)
            {
                k = 0;
            }
            int i3 = (j2 * 17 + k2 + l2 + k1) / 22;
            int j3 = (k2 * 17 + j2 + l2 + k1) / 22;
            int k3 = (l2 * 17 + j2 + k2 + k1) / 22;
            if(j == 17)
            {
                i3 = (j2 * 17 + k2 + l2 + k1) / 22;
                j3 = (k2 * 17 + j2 + l2 + k1) / 21;
                k3 = (l2 * 17 + j2 + k2 + k1) / 20;
            }
            if(--l1 == 0)
            {
                k1 = (int)(Math.random() * 128D);
                l1 = (int)(5D + Math.random() * 15D);
            }
            Color color1 = new Color(i3, j3, k3);
            flexpix[i2] = color1.getRGB();
        } while(++i2 < 0x416e0);
        fleximg = createImage(new MemoryImageSource(670, 400, flexpix, 0, 670));
        rd.drawImage(fleximg, 0, 0, null);
    }

    public void arrow(int i, int j, CheckPoints checkpoints, boolean flag)
    {
        int ai[] = new int[7];
        int ai1[] = new int[7];
        int ai2[] = new int[7];
        char c = '\u014F';
        byte byte0 = -90;
        char c1 = '\u02BC';
        int k = 0;
        do
        {
            ai1[k] = byte0;
        } while(++k < 7);
        ai[0] = c;
        ai2[0] = c1 + 110;
        ai[1] = c - 35;
        ai2[1] = c1 + 50;
        ai[2] = c - 15;
        ai2[2] = c1 + 50;
        ai[3] = c - 15;
        ai2[3] = c1 - 50;
        ai[4] = c + 15;
        ai2[4] = c1 - 50;
        ai[5] = c + 15;
        ai2[5] = c1 + 50;
        ai[6] = c + 35;
        ai2[6] = c1 + 50;
        k = 0;
        if(!flag)
        {
            char c2 = '\0';
            if(checkpoints.x[i] - checkpoints.opx[0] >= 0)
            {
                c2 = '\264';
            }
            k = (int)((double)(90 + c2) + Math.atan((double)(checkpoints.z[i] - checkpoints.opz[0]) / (double)(checkpoints.x[i] - checkpoints.opx[0])) / 0.017453292519943295D);
        } else
        {
            int l = 0;
            int k1 = -1;
            boolean flag1 = false;
            int l2 = 1;
            do
            {
                if((py(checkpoints.opx[0] / 100, checkpoints.opx[l2] / 100, checkpoints.opz[0] / 100, checkpoints.opz[l2] / 100) < k1 || k1 == -1) && (!flag1 || checkpoints.onscreen[l2] != 0) && checkpoints.dested[l2] == 0)
                {
                    l = l2;
                    k1 = py(checkpoints.opx[0] / 100, checkpoints.opx[l2] / 100, checkpoints.opz[0] / 100, checkpoints.opz[l2] / 100);
                    if(checkpoints.onscreen[l2] != 0)
                    {
                        flag1 = true;
                    }
                }
            } while(++l2 < 7);
            l2 = 0;
            if(checkpoints.opx[l] - checkpoints.opx[0] >= 0)
            {
                l2 = 180;
            }
            k = (int)((double)(90 + l2) + Math.atan((double)(checkpoints.opz[l] - checkpoints.opz[0]) / (double)(checkpoints.opx[l] - checkpoints.opx[0])) / 0.017453292519943295D);
            drawcs(13, "[                                ]", 76, 67, 240, 0);
            drawcs(13, names[sc[l]], 0, 0, 0, 0);
        }
        for(k += m.xz; k < 0; k += 360) { }
        for(; k > 180; k -= 360) { }
        if(!flag)
        {
            if(k > 130)
            {
                k = 130;
            }
            if(k < -130)
            {
                k = -130;
            }
        } else
        {
            if(k > 100)
            {
                k = 100;
            }
            if(k < -100)
            {
                k = -100;
            }
        }
        if(Math.abs(ana - k) < 180)
        {
            if(Math.abs(ana - k) < 10)
            {
                ana = k;
            } else
            if(ana < k)
            {
                ana += 10;
            } else
            {
                ana -= 10;
            }
        } else
        {
            if(k < 0)
            {
                ana += 15;
                if(ana > 180)
                {
                    ana -= 360;
                }
            }
            if(k > 0)
            {
                ana -= 15;
                if(ana < -180)
                {
                    ana += 360;
                }
            }
        }
        rot(ai, ai2, c, c1, ana, 7);
        k = Math.abs(ana);
        if(!flag)
        {
            if(k > 7 || j > 0 || j == -2 || cntan != 0)
            {
                int i1 = 0;
                do
                {
                    ai[i1] = xs(ai[i1], ai2[i1]);
                    ai1[i1] = ys(ai1[i1], ai2[i1]);
                } while(++i1 < 7);
                i1 = (int)(190F + 190F * ((float)m.snap[0] / 100F));
                if(i1 > 255)
                {
                    i1 = 255;
                }
                if(i1 < 0)
                {
                    i1 = 0;
                }
                int l1 = (int)(255F + 255F * ((float)m.snap[1] / 100F));
                if(l1 > 255)
                {
                    l1 = 255;
                }
                if(l1 < 0)
                {
                    l1 = 0;
                }
                int j2 = 0;
                if(j <= 0)
                {
                    if(k <= 45 && j != -2 && cntan == 0)
                    {
                        i1 = (i1 * k + m.csky[0] * (45 - k)) / 45;
                        l1 = (l1 * k + m.csky[1] * (45 - k)) / 45;
                        j2 = (j2 * k + m.csky[2] * (45 - k)) / 45;
                    }
                    if(k >= 90)
                    {
                        int i3 = (int)(255F + 255F * ((float)m.snap[0] / 100F));
                        if(i3 > 255)
                        {
                            i3 = 255;
                        }
                        if(i3 < 0)
                        {
                            i3 = 0;
                        }
                        i1 = (i1 * (140 - k) + i3 * (k - 90)) / 50;
                        if(i1 > 255)
                        {
                            i1 = 255;
                        }
                    }
                } else
                if(flk)
                {
                    i1 = (int)(255F + 255F * ((float)m.snap[0] / 100F));
                    if(i1 > 255)
                    {
                        i1 = 255;
                    }
                    if(i1 < 0)
                    {
                        i1 = 0;
                    }
                    flk = false;
                } else
                {
                    i1 = (int)(255F + 255F * ((float)m.snap[0] / 100F));
                    if(i1 > 255)
                    {
                        i1 = 255;
                    }
                    if(i1 < 0)
                    {
                        i1 = 0;
                    }
                    l1 = (int)(220F + 220F * ((float)m.snap[1] / 100F));
                    if(l1 > 255)
                    {
                        l1 = 255;
                    }
                    if(l1 < 0)
                    {
                        l1 = 0;
                    }
                    flk = true;
                }
                rd.setColor(new Color(i1, l1, j2));
                rd.fillPolygon(ai, ai1, 7);
                i1 = (int)(115F + 115F * ((float)m.snap[0] / 100F));
                if(i1 > 255)
                {
                    i1 = 255;
                }
                if(i1 < 0)
                {
                    i1 = 0;
                }
                l1 = (int)(170F + 170F * ((float)m.snap[1] / 100F));
                if(l1 > 255)
                {
                    l1 = 255;
                }
                if(l1 < 0)
                {
                    l1 = 0;
                }
                j2 = 0;
                if(j <= 0)
                {
                    if(k <= 45 && j != -2 && cntan == 0)
                    {
                        i1 = (i1 * k + m.csky[0] * (45 - k)) / 45;
                        l1 = (l1 * k + m.csky[1] * (45 - k)) / 45;
                        j2 = (j2 * k + m.csky[2] * (45 - k)) / 45;
                    }
                } else
                if(flk)
                {
                    i1 = (int)(255F + 255F * ((float)m.snap[0] / 100F));
                    if(i1 > 255)
                    {
                        i1 = 255;
                    }
                    if(i1 < 0)
                    {
                        i1 = 0;
                    }
                    l1 = 0;
                }
                rd.setColor(new Color(i1, l1, j2));
                rd.drawPolygon(ai, ai1, 7);
            }
        } else
        {
            int j1 = 0;
            do
            {
                ai[j1] = xs(ai[j1], ai2[j1]);
                ai1[j1] = ys(ai1[j1], ai2[j1]);
            } while(++j1 < 7);
            j1 = (int)(159F + 159F * ((float)m.snap[0] / 100F));
            if(j1 > 255)
            {
                j1 = 255;
            }
            if(j1 < 0)
            {
                j1 = 0;
            }
            int i2 = (int)(207F + 207F * ((float)m.snap[1] / 100F));
            if(i2 > 255)
            {
                i2 = 255;
            }
            if(i2 < 0)
            {
                i2 = 0;
            }
            int k2 = (int)(255F + 255F * ((float)m.snap[2] / 100F));
            if(k2 > 255)
            {
                k2 = 255;
            }
            if(k2 < 0)
            {
                k2 = 0;
            }
            rd.setColor(new Color(j1, i2, k2));
            rd.fillPolygon(ai, ai1, 7);
            j1 = (int)(120F + 120F * ((float)m.snap[0] / 100F));
            if(j1 > 255)
            {
                j1 = 255;
            }
            if(j1 < 0)
            {
                j1 = 0;
            }
            i2 = (int)(114F + 114F * ((float)m.snap[1] / 100F));
            if(i2 > 255)
            {
                i2 = 255;
            }
            if(i2 < 0)
            {
                i2 = 0;
            }
            k2 = (int)(255F + 255F * ((float)m.snap[2] / 100F));
            if(k2 > 255)
            {
                k2 = 255;
            }
            if(k2 < 0)
            {
                k2 = 0;
            }
            rd.setColor(new Color(j1, i2, k2));
            rd.drawPolygon(ai, ai1, 7);
        }
    }

    public void levelhigh(int i, int j, int k, int l, int i1)
    {
        rd.drawImage(gameh, 236, 20, null);
        byte byte0 = 16;
        char c = '0';
        char c1 = '`';
        if(l < 50)
        {
            if(aflk)
            {
                byte0 = 106;
                c = '\260';
                c1 = '\377';
                aflk = false;
            } else
            {
                aflk = true;
            }
        }
        if(i != 0)
        {
            if(k == 0)
            {
                drawcs(60, "You Wasted 'em!", byte0, c, c1, 0);
            } else
            if(k == 1)
            {
                drawcs(60, "Close Finish!", byte0, c, c1, 0);
            } else
            {
                drawcs(60, "Close Finish!  Almost got it!", byte0, c, c1, 0);
            }
        } else
        if(j == 229)
        {
            drawcs(60, "Wasted!", byte0, c, c1, 0);
        } else
        if(i1 > 2)
        {
            drawcs(60, "Stunts!", byte0, c, c1, 0);
        } else
        {
            drawcs(60, "Best Stunt!", byte0, c, c1, 0);
        }
        drawcs(380, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
    }

    public void playsounds(Madness madness, Control control, int i)
    {
        if(fase == 0 && starcnt < 35 && cntwis != 8 && !mutes)
        {
            boolean flag = control.up && madness.speed > 0.0F || control.down && madness.speed < 10F;
            boolean flag1 = madness.skid == 1 && control.handb || Math.abs(madness.scz[0] - (madness.scz[1] + madness.scz[0] + madness.scz[2] + madness.scz[3]) / 4F) > 1.0F || Math.abs(madness.scx[0] - (madness.scx[1] + madness.scx[0] + madness.scx[2] + madness.scx[3]) / 4F) > 1.0F;
            boolean flag2 = false;
            if(control.up && madness.speed < 10F)
            {
                flag1 = true;
                flag = true;
                flag2 = true;
            }
            if(flag && madness.mtouch)
            {
                if(!madness.capsized)
                {
                    if(!flag1)
                    {
                        if(madness.power != 98F)
                        {
                            if(Math.abs(madness.speed) > 0.0F && Math.abs(madness.speed) <= (float)madness.swits[madness.cn][0])
                            {
                                int j = (int)((3F * Math.abs(madness.speed)) / (float)madness.swits[madness.cn][0]);
                                if(j == 2)
                                {
                                    if(pwait == 0)
                                    {
                                        j = 0;
                                    } else
                                    {
                                        pwait--;
                                    }
                                } else
                                {
                                    pwait = 7;
                                }
                                sparkeng(j);
                            }
                            if(Math.abs(madness.speed) > (float)madness.swits[madness.cn][0] && Math.abs(madness.speed) <= (float)madness.swits[madness.cn][1])
                            {
                                int k = (int)((3F * (Math.abs(madness.speed) - (float)madness.swits[madness.cn][0])) / (float)(madness.swits[madness.cn][1] - madness.swits[madness.cn][0]));
                                if(k == 2)
                                {
                                    if(pwait == 0)
                                    {
                                        k = 0;
                                    } else
                                    {
                                        pwait--;
                                    }
                                } else
                                {
                                    pwait = 7;
                                }
                                sparkeng(k);
                            }
                            if(Math.abs(madness.speed) > (float)madness.swits[madness.cn][1] && Math.abs(madness.speed) <= (float)madness.swits[madness.cn][2])
                            {
                                int l = (int)((3F * (Math.abs(madness.speed) - (float)madness.swits[madness.cn][1])) / (float)(madness.swits[madness.cn][2] - madness.swits[madness.cn][1]));
                                sparkeng(l);
                            }
                        } else
                        {
                            byte byte0 = 2;
                            if(pwait == 0)
                            {
                                if(Math.abs(madness.speed) > (float)madness.swits[madness.cn][1])
                                {
                                    byte0 = 3;
                                }
                            } else
                            {
                                pwait--;
                            }
                            sparkeng(byte0);
                        }
                    } else
                    {
                        sparkeng(-1);
                        if(flag2)
                        {
                            if(stopcnt <= 0)
                            {
                                air[5].loop(Clip.LOOP_CONTINUOUSLY);
                                stopcnt = 10;
                            }
                        } else
                        if(stopcnt <= -2)
                        {
                            air[2 + (int)(m.random() * 3F)].loop(Clip.LOOP_CONTINUOUSLY);
                            stopcnt = 7;
                        }
                    }
                } else
                {
                    sparkeng(3);
                }
                grrd = false;
                aird = false;
            } else
            {
                pwait = 15;
                if(!madness.mtouch && !grrd && (double)m.random() > 0.40000000000000002D)
                {
                    air[(int)(m.random() * 4F)].loop(Clip.LOOP_CONTINUOUSLY);
                    stopcnt = 5;
                    grrd = true;
                }
                if(!madness.wtouch && !aird)
                {
                    stopairs();
                    air[(int)(m.random() * 4F)].loop(Clip.LOOP_CONTINUOUSLY);
                    stopcnt = 10;
                    aird = true;
                }
                sparkeng(-1);
            }
            if(madness.cntdest != 0 && cntwis < 7)
            {
                if(!pwastd)
                {
                    wastd.loop(Clip.LOOP_CONTINUOUSLY);
                    pwastd = true;
                }
            } else
            {
                if(pwastd)
                {
                    wastd.stop();
                    pwastd = false;
                }
                if(cntwis == 7 && !mutes)
                {
                    firewasted.setFramePosition(0);
                    firewasted.start();
                }
            }
        } else
        {
            sparkeng(-2);
            if(pwastd)
            {
                wastd.stop();
                pwastd = false;
            }
        }
        if(stopcnt != -20)
        {
            if(stopcnt == 1)
            {
                stopairs();
            }
            stopcnt--;
        }
        if(bfcrash != 0)
        {
            bfcrash--;
        }
        if(bfskid != 0)
        {
            bfskid--;
        }
        if(madness.newcar)
        {
            cntwis = 0;
        }
        if(fase == 0 || fase == 6 || fase == -1 || fase == -2 || fase == -3 || fase == -4 || fase == -5)
        {
            if(mutes != control.mutes)
            {
                mutes = control.mutes;
            }
            if(control.mutem != mutem)
            {
                mutem = control.mutem;
                if(mutem)
                {
                    if(loadedt[i - 1])
                    {
                        stracks[i - 1].stop();
                    }
                } else
                if(loadedt[i - 1])
                {
                    stracks[i - 1].resume();
                }
            }
        }
        if(madness.cntdest != 0 && cntwis < 7)
        {
            if(madness.dest)
            {
                cntwis++;
            }
        } else
        {
            if(madness.cntdest == 0)
            {
                cntwis = 0;
            }
            if(cntwis == 7)
            {
                cntwis = 8;
            }
        }
    }

    public void crash(float f, int i)
    {
        if(bfcrash == 0)
        {
            if(i == 0)
            {
                if(Math.abs(f) > 25F && Math.abs(f) < 170F)
                {
                    if(!mutes)
                    {
                        lowcrash[crshturn].setFramePosition(0);
                        lowcrash[crshturn].start();
                    }
                    bfcrash = 2;
                }
                if(Math.abs(f) >= 170F)
                {
                    if(!mutes)
                    {
                        crash[crshturn].setFramePosition(0);
                        crash[crshturn].start();
                    }
                    bfcrash = 2;
                }
                if(Math.abs(f) > 25F)
                {
                    if(crashup)
                    {
                        crshturn--;
                    } else
                    {
                        crshturn++;
                    }
                    if(crshturn == -1)
                    {
                        crshturn = 2;
                    }
                    if(crshturn == 3)
                    {
                        crshturn = 0;
                    }
                }
            }
            if(i == -1)
            {
                if(Math.abs(f) > 25F && Math.abs(f) < 170F)
                {
                    if(!mutes)
                    {
                        lowcrash[2].setFramePosition(0);
                        lowcrash[2].start();
                    }
                    bfcrash = 2;
                }
                if(Math.abs(f) > 170F)
                {
                    if(!mutes)
                    {
                        crash[2].setFramePosition(0);
                        crash[2].start();
                    }
                    bfcrash = 2;
                }
            }
            if(i == 1)
            {
                if(!mutes)
                {
                    tires.setFramePosition(0);
                    tires.start();
                }
                bfcrash = 3;
            }
        }
    }

    public int ys(int i, int j)
    {
        if(j < 50)
        {
            j = 50;
        }
        return ((j - m.focus_point) * (m.cy - i)) / j + i;
    }

    public void replyn()
    {
        if(aflk)
        {
            drawcs(30, "Replay  > ", 0, 0, 0, 0);
            aflk = false;
        } else
        {
            drawcs(30, "Replay  >>", 0, 128, 255, 0);
            aflk = true;
        }
    }

    private Image pressed(Image image)
    {
        int i = image.getHeight(ob);
        int j = image.getWidth(ob);
        int ai[] = new int[j * i];
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, j, i, ai, 0, j);
        try
        {
            pixelgrabber.grabPixels();
        }
        catch(InterruptedException _ex) { }
        for(int k = 0; k < j * i; k++)
        {
            if(ai[k] != ai[j * i - 1])
            {
                ai[k] = 0xff000000;
            }
        }

        Image image1 = createImage(new MemoryImageSource(j, i, ai, 0, j));
        return image1;
    }

    private Image dodgen(Image image)
    {
        int i = image.getHeight(ob);
        int j = image.getWidth(ob);
        int ai[] = new int[j * i];
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, j, i, ai, 0, j);
        try
        {
            pixelgrabber.grabPixels();
        }
        catch(InterruptedException _ex) { }
        for(int k = 0; k < j * i; k++)
        {
            Color color = new Color(ai[k]);
            int l = color.getRed() * 3 + 90;
            if(l > 255)
            {
                l = 255;
            }
            if(l < 0)
            {
                l = 0;
            }
            int i1 = color.getGreen() * 3 + 90;
            if(i1 > 255)
            {
                i1 = 255;
            }
            if(i1 < 0)
            {
                i1 = 0;
            }
            int j1 = color.getBlue() * 3 + 90;
            if(j1 > 255)
            {
                j1 = 255;
            }
            if(j1 < 0)
            {
                j1 = 0;
            }
            Color color1 = new Color(l, i1, j1);
            ai[k] = color1.getRGB();
        }

        Image image1 = createImage(new MemoryImageSource(j, i, ai, 0, j));
        return image1;
    }

    private void smokeypix(byte abyte0[], MediaTracker mediatracker, Toolkit toolkit)
    {
        Image image = toolkit.createImage(abyte0);
        mediatracker.addImage(image, 0);
        try
        {
            mediatracker.waitForID(0);
        }
        catch(Exception _ex) { }
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, 466, 202, smokey, 0, 466);
        try
        {
            pixelgrabber.grabPixels();
        }
        catch(InterruptedException _ex) { }
    }

    public void stoploading()
    {
        loading();
        pane.repaint();
        runner.stop();
        runner = null;
        runtyp = 0;
    }

    public void nofocus()
    {
        rd.setColor(new Color(255, 255, 255));
        rd.fillRect(0, 0, 670, 20);
        rd.fillRect(0, 0, 20, 400);
        rd.fillRect(0, 380, 670, 20);
        rd.fillRect(650, 0, 20, 400);
        rd.setColor(new Color(192, 192, 192));
        rd.drawRect(20, 20, 630, 360);
        rd.setColor(new Color(0, 0, 0));
        rd.drawRect(22, 22, 626, 356);
        rd.setFont(new Font("SansSerif", 1, 11));
        ftm = rd.getFontMetrics();
        drawcs(14, "Game lost its focus.   Click screen with mouse to continue.", 100, 100, 100, 3);
        drawcs(395, "Game lost its focus.   Click screen with mouse to continue.", 100, 100, 100, 3);
    }

    public void rot(int ai[], int ai1[], int i, int j, int k, int l)
    {
        if(k != 0)
        {
            for(int i1 = 0; i1 < l; i1++)
            {
                int j1 = ai[i1];
                int k1 = ai1[i1];
                ai[i1] = i + (int)((float)(j1 - i) * m.cos(k) - (float)(k1 - j) * m.sin(k));
                ai1[i1] = j + (int)((float)(j1 - i) * m.sin(k) + (float)(k1 - j) * m.cos(k));
            }

        }
    }

    public boolean overon(int i, int j, int k, int l, int i1, int j1)
    {
        return i1 > i && i1 < i + k && j1 > j && j1 < j + l;
    }

    public void pauseimage(Image image)
    {
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, 670, 400, flexpix, 0, 670);
        try
        {
            pixelgrabber.grabPixels();
        }
        catch(InterruptedException _ex) { }
        int i = 0;
        int j = 0;
        int k = 0;
        int l = 0;
        int i1 = 0;
        do
        {
            Color color = new Color(flexpix[i1]);
            int j1 = 0;
            if(l == 0)
            {
                j1 = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
                k = j1;
            } else
            {
                j1 = (color.getRed() + color.getGreen() + color.getBlue() + k * 30) / 33;
                k = j1;
            }
            if(++l == 670)
            {
                l = 0;
            }
            if(i1 > 670 * (8 + j) + 216 && j < 188)
            {
                int k1 = (j1 + 60) / 3;
                int l1 = (j1 + 135) / 3;
                int i2 = (j1 + 220) / 3;
                if(++i == 237)
                {
                    j++;
                    i = 0;
                }
                Color color2 = new Color(k1, l1, i2);
                flexpix[i1] = color2.getRGB();
            } else
            {
                Color color1 = new Color(j1, j1, j1);
                flexpix[i1] = color1.getRGB();
            }
        } while(++i1 < 0x416e0);
        fleximg = createImage(new MemoryImageSource(670, 400, flexpix, 0, 670));
        rd.drawImage(fleximg, 0, 0, null);
        m.flex = 0;
    }

    public void loadmusic(int i, int j)
    {
        hipnoload(i, false);
        pane.setCursor(new Cursor(3));
        pane.repaint();
        boolean flag = false;
        if(i == unlocked && (i == 1 || i == 2 || i == 3 || i == 4 || i == 7 || i == 8 || i == 9 || i == 10 || i == 12 || i == 13 || i == 16))
        {
            flag = true;
        }
        if(flag)
        {
            runtyp = i;
            runner = new Thread(this);
            runner.start();
        }
        if(!loadedt[i - 1])
        {
            stracks[i - 1] = new RadicalMod("music/stage" + i + ".radq");
            if(stracks[i - 1].loaded == 1)
            {
                loadedt[i - 1] = true;
            }
        }
        if(i == 1)
        {
            stracks[0].loadMod(130, 8000, 125, sunny, macn);
        }
        if(i == 2)
        {
            stracks[1].loadMod(260, 7200, 125, sunny, macn);
        }
        if(i == 3)
        {
            stracks[2].loadMod(270, 8000, 125, sunny, macn);
        }
        if(i == 4)
        {
            stracks[3].loadMod(190, 8000, 125, sunny, macn);
        }
        if(i == 5)
        {
            stracks[4].loadMod(162, 7800, 125, sunny, macn);
        }
        if(i == 6)
        {
            stracks[5].loadMod(220, 7600, 125, sunny, macn);
        }
        if(i == 7)
        {
            stracks[6].loadMod(300, 7500, 125, sunny, macn);
        }
        if(i == 8)
        {
            stracks[7].loadMod(200, 7900, 125, sunny, macn);
        }
        if(i == 9)
        {
            stracks[8].loadMod(200, 7900, 125, sunny, macn);
        }
        if(i == 10)
        {
            stracks[9].loadMod(232, 7300, 125, sunny, macn);
        }
        if(i == 11)
        {
            stracks[10].loadMod(370, 7900, 125, sunny, macn);
        }
        if(i == 12)
        {
            stracks[11].loadMod(290, 7900, 125, sunny, macn);
        }
        if(i == 13)
        {
            stracks[12].loadMod(222, 7600, 125, sunny, macn);
        }
        if(i == 14)
        {
            stracks[13].loadMod(230, 8000, 125, sunny, macn);
        }
        if(i == 15)
        {
            stracks[14].loadMod(220, 8000, 125, sunny, macn);
        }
        if(i == 16)
        {
            stracks[15].loadMod(261, 8000, 125, sunny, macn);
        }
        if(i == 17)
        {
            stracks[16].loadMod(400, 7600, 125, sunny, macn);
        }
        if(flag)
        {
            runner.stop();
            runner = null;
            runtyp = 0;
        }
        System.gc();
        lastload = i - 1;
        if(j == 0)
        {
            if(loadedt[i - 1])
            {
                stracks[i - 1].play();
            }
            pane.setCursor(new Cursor(0));
            fase = 6;
        } else
        {
            fase = 176;
        }
        pcontin = 0;
        mutem = false;
        mutes = false;
    }

    public void loadimages()
    {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        MediaTracker mediatracker = new MediaTracker(pane);
        dnload += 12;
        try
        {
            File file = new File("/app/games/nfm2/data/images.radq");
            DataInputStream datainputstream = new DataInputStream(new FileInputStream(file));
            ZipInputStream zipinputstream = new ZipInputStream(datainputstream);
            for(ZipEntry zipentry = zipinputstream.getNextEntry(); zipentry != null; zipentry = zipinputstream.getNextEntry())
            {
                int i = (int)zipentry.getSize();
                String s = zipentry.getName();
                byte abyte0[] = new byte[i];
                int j = 0;
                int k;
                for(; i > 0; i -= k)
                {
                    k = zipinputstream.read(abyte0, j, i);
                    j += k;
                }

                if(s.equals("cars.gif"))
                {
                    carsbg = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("smokey.gif"))
                {
                    smokeypix(abyte0, mediatracker, toolkit);
                }
                if(s.equals("1.gif"))
                {
                    orank[0] = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("gameh.gif"))
                {
                    ogameh = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("gameov.gif"))
                {
                    gameov = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("lap.gif"))
                {
                    olap = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("paused.gif"))
                {
                    paused = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("select.gif"))
                {
                    select = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("yourwasted.gif"))
                {
                    oyourwasted = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("youwastedem.gif"))
                {
                    oyouwastedem = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("d1.gif"))
                {
                    dude[0] = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("d2.gif"))
                {
                    dude[1] = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("d3.gif"))
                {
                    dude[2] = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("float.gif"))
                {
                    oflaot = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("1c.gif"))
                {
                    ocntdn[1] = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("2c.gif"))
                {
                    ocntdn[2] = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("3c.gif"))
                {
                    ocntdn[3] = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("2.gif"))
                {
                    orank[1] = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("3.gif"))
                {
                    orank[2] = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("4.gif"))
                {
                    orank[3] = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("5.gif"))
                {
                    orank[4] = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("6.gif"))
                {
                    orank[5] = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("7.gif"))
                {
                    orank[6] = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("bgmain.jpg"))
                {
                    bgmain = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("br.gif"))
                {
                    br = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("loadingmusic.gif"))
                {
                    oloadingmusic = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("radicalplay.gif"))
                {
                    radicalplay = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("back.gif"))
                {
                    back[0] = loadimage(abyte0, mediatracker, toolkit);
                    back[1] = bressed(back[0]);
                }
                if(s.equals("continue2.gif"))
                {
                    contin[0] = loadimage(abyte0, mediatracker, toolkit);
                    contin[1] = bressed(contin[0]);
                }
                if(s.equals("next.gif"))
                {
                    next[0] = loadimage(abyte0, mediatracker, toolkit);
                    next[1] = bressed(next[0]);
                }
                if(s.equals("pgate.gif"))
                {
                    pgate = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("rpro.gif"))
                {
                    rpro = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("selectcar.gif"))
                {
                    selectcar = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("track1.jpg"))
                {
                    trackbg[0][0] = loadimage(abyte0, mediatracker, toolkit);
                    trackbg[1][0] = dodgen(trackbg[0][0]);
                }
                if(s.equals("track2.jpg"))
                {
                    trackbg[0][1] = loadimage(abyte0, mediatracker, toolkit);
                    trackbg[1][1] = dodgen(trackbg[0][1]);
                }
                if(s.equals("youlost.gif"))
                {
                    oyoulost = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("youwon.gif"))
                {
                    oyouwon = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("0c.gif"))
                {
                    ocntdn[0] = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("damage.gif"))
                {
                    odmg = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("power.gif"))
                {
                    opwr = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("position.gif"))
                {
                    opos = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("wasted.gif"))
                {
                    owas = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("start1.gif"))
                {
                    ostar[0] = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("start2.gif"))
                {
                    ostar[1] = loadimage(abyte0, mediatracker, toolkit);
                    star[2] = pressed(ostar[1]);
                }
                if(s.equals("congrad.gif"))
                {
                    congrd = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("statb.gif"))
                {
                    statb = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("statbo.gif"))
                {
                    statbo = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("madness.gif"))
                {
                    mdness = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("fixhoop.gif"))
                {
                    fixhoop = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("arrow.gif"))
                {
                    sarrow = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("stunts.gif"))
                {
                    stunts = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("racing.gif"))
                {
                    racing = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("wasting.gif"))
                {
                    wasting = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("plus.gif"))
                {
                    plus = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("space.gif"))
                {
                    space = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("arrows.gif"))
                {
                    arrows = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("chil.gif"))
                {
                    chil = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("ory.gif"))
                {
                    ory = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("kz.gif"))
                {
                    kz = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("kx.gif"))
                {
                    kx = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("kv.gif"))
                {
                    kv = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("kp.gif"))
                {
                    kp = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("km.gif"))
                {
                    km = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("kn.gif"))
                {
                    kn = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("kenter.gif"))
                {
                    kenter = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("nfm.gif"))
                {
                    nfm = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("options.gif"))
                {
                    opti = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("opback.gif"))
                {
                    opback = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("logocars.gif"))
                {
                    logocars = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("logomadmess.gif"))
                {
                    logomadnes = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("logomadbg.gif"))
                {
                    logomadbg = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("byrd.gif"))
                {
                    byrd = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("nfmcoms.gif"))
                {
                    nfmcoms = loadimage(abyte0, mediatracker, toolkit);
                }
                if(s.equals("nfmcom.gif"))
                {
                    nfmcom = loadimage(abyte0, mediatracker, toolkit);
                }
                dnload += 3;
            }

            datainputstream.close();
            zipinputstream.close();
        }
        catch(Exception exception)
        {
            System.out.println("Error Loading Images: " + exception);
        }
        System.gc();
    }

    public void pausedgame(int i, Control control, Record record)
    {
        rd.drawImage(fleximg, 0, 0, null);
        if(control.up)
        {
            opselect--;
            if(opselect == -1)
            {
                opselect = 3;
            }
            control.up = false;
        }
        if(control.down)
        {
            opselect++;
            if(opselect == 4)
            {
                opselect = 0;
            }
            control.down = false;
        }
        if(opselect == 0)
        {
            rd.setColor(new Color(64, 143, 223));
            rd.fillRoundRect(264, 45, 137, 22, 7, 20);
            if(shaded)
            {
                rd.setColor(new Color(225, 200, 255));
            } else
            {
                rd.setColor(new Color(0, 89, 223));
            }
            rd.drawRoundRect(264, 45, 137, 22, 7, 20);
        }
        if(opselect == 1)
        {
            rd.setColor(new Color(64, 143, 223));
            rd.fillRoundRect(255, 73, 155, 22, 7, 20);
            if(shaded)
            {
                rd.setColor(new Color(225, 200, 255));
            } else
            {
                rd.setColor(new Color(0, 89, 223));
            }
            rd.drawRoundRect(255, 73, 155, 22, 7, 20);
        }
        if(opselect == 2)
        {
            rd.setColor(new Color(64, 143, 223));
            rd.fillRoundRect(238, 99, 190, 22, 7, 20);
            if(shaded)
            {
                rd.setColor(new Color(225, 200, 255));
            } else
            {
                rd.setColor(new Color(0, 89, 223));
            }
            rd.drawRoundRect(238, 99, 190, 22, 7, 20);
        }
        if(opselect == 3)
        {
            rd.setColor(new Color(64, 143, 223));
            rd.fillRoundRect(276, 125, 109, 22, 7, 20);
            if(shaded)
            {
                rd.setColor(new Color(225, 200, 255));
            } else
            {
                rd.setColor(new Color(0, 89, 223));
            }
            rd.drawRoundRect(276, 125, 109, 22, 7, 20);
        }
        rd.drawImage(paused, 216, 8, null);
        if(control.enter || control.handb)
        {
            if(opselect == 0)
            {
                if(loadedt[i - 1] && !mutem)
                {
                    stracks[i - 1].resume();
                }
                fase = 0;
            }
            if(opselect == 1)
            {
                if(record.caught >= 300)
                {
                    if(loadedt[i - 1] && !mutem)
                    {
                        stracks[i - 1].resume();
                    }
                    fase = -1;
                } else
                {
                    fase = -8;
                }
            }
            if(opselect == 2)
            {
                if(loadedt[i - 1])
                {
                    stracks[i - 1].stop();
                }
                oldfase = -7;
                fase = 11;
            }
            if(opselect == 3)
            {
                if(loadedt[i - 1])
                {
                    stracks[i - 1].stop();
                }
                fase = 10;
                opselect = 0;
            }
            control.enter = false;
            control.handb = false;
        }
    }

    public void credits(Control control)
    {
        if(flipo == 0)
        {
            powerup.setFramePosition(0);
            powerup.start();
            flipo = 1;
            bgmy[0] = 0;
            bgmy[1] = 400;
        }
        if(flipo >= 1 && flipo <= 100)
        {
            rad(flipo);
            flipo++;
            if(flipo == 100)
            {
                flipo = 1;
            }
        }
        if(flipo == 101)
        {
            int i = 0;
            do
            {
                rd.drawImage(bgmain, 0, bgmy[i], null);
                bgmy[i] -= 10;
                if(bgmy[i] <= -400)
                {
                    bgmy[i] = 400;
                }
            } while(++i < 2);
            rd.drawImage(mdness, 218, 7, null);
            rd.setFont(new Font("SansSerif", 1, 13));
            ftm = rd.getFontMetrics();
            drawcs(65, "At Radicalplay.com", 0, 0, 0, 3);
            drawcs(100, "Cartoon 3D Engine, Game Programming, 3D Models, Graphics and Sound Effects", 0, 0, 0, 3);
            drawcs(120, "Everything By Omar Waly", 70, 70, 70, 3);
            drawcs(153, "This version of the game was updated and is maintained", 0, 0, 0, 3);
            drawcs(173, "By Jaroslav Paska (Phyrexian)", 70, 70, 70, 3);
            rd.setFont(new Font("SansSerif", 1, 13));
            ftm = rd.getFontMetrics();
            drawcs(210, "Thanks for Game Testing", 0, 0, 0, 3);
            rd.setFont(new Font("SansSerif", 1, 11));
            ftm = rd.getFontMetrics();
            drawcs(230, "Soufy H Abutaleb, Sherif Abouzeid,", 90, 90, 90, 3);
            drawcs(245, "Kareem Mansour, Youssef Wahby,", 90, 90, 90, 3);
            drawcs(260, "Taymour Farid, Mahmoud Waly", 90, 90, 90, 3);
            drawcs(275, "and Mahmou7d Ezzeldin (Turbo)", 90, 90, 90, 3);
            rd.setFont(new Font("SansSerif", 1, 13));
            ftm = rd.getFontMetrics();
            drawcs(340, "Music was obtained from the ModArchive.org", 0, 0, 0, 3);
            rd.setFont(new Font("SansSerif", 1, 11));
            ftm = rd.getFontMetrics();
            drawcs(380, "For any comments: youtube.com/user/PhyrexianNFM", 90, 90, 90, 3);
        }
        if(flipo == 102)
        {
            int j = 0;
            do
            {
                rd.drawImage(bgmain, 0, bgmy[j], null);
                bgmy[j] -= 16;
                if(bgmy[j] <= -400)
                {
                    bgmy[j] = 400;
                }
            } while(++j < 2);
            rd.drawImage(nfmcom, 125, 170, null);
        }
        rd.drawImage(next[pnext], 600, 370, null);
        if(control.enter || control.handb || control.right)
        {
            if(flipo >= 1 && flipo <= 100)
            {
                flipo = 101;
                pane.setCursor(new Cursor(0));
            } else
            {
                flipo++;
            }
            if(flipo == 103)
            {
                flipo = 0;
                fase = 10;
            }
            control.enter = false;
            control.handb = false;
            control.right = false;
        }
    }

    public float pys(int i, int j, int k, int l)
    {
        return (float)Math.sqrt((i - j) * (i - j) + (k - l) * (k - l));
    }

    public void stat(Madness madness, CheckPoints checkpoints, Control control, boolean flag)
    {
        if(holdit)
        {
            holdcnt++;
            if(m.flex != 0)
            {
                m.flex = 0;
            }
            if(control.enter || holdcnt > 250)
            {
                fase = -2;
                control.enter = false;
            }
        } else
        {
            if(holdcnt != 0)
            {
                holdcnt = 0;
            }
            if(control.enter)
            {
                if(loadedt[checkpoints.stage - 1])
                {
                    stracks[checkpoints.stage - 1].stop();
                }
                fase = -6;
                control.enter = false;
            }
        }
        if(fase != -2)
        {
            holdit = false;
            if(checkpoints.wasted == 6)
            {
                if(m.flex != 2)
                {
                    rd.setColor(new Color(m.csky[0], m.csky[1], m.csky[2]));
                    rd.fillRect(226, 70, youwastedem.getWidth(ob), youwastedem.getHeight(ob));
                    rd.setColor(new Color(m.cfade[0], m.cfade[1], m.cfade[2]));
                    rd.drawRect(226, 70, youwastedem.getWidth(ob), youwastedem.getHeight(ob));
                }
                rd.drawImage(youwastedem, 226, 70, null);
                if(aflk)
                {
                    drawcs(120, "You Won, all cars have been wasted!", 0, 0, 0, 0);
                    aflk = false;
                } else
                {
                    drawcs(120, "You Won, all cars have been wasted!", 0, 128, 255, 0);
                    aflk = true;
                }
                drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
                checkpoints.haltall = true;
                holdit = true;
                winner = true;
            }
            if(!holdit && madness.dest && cntwis == 8)
            {
                if(m.flex != 2)
                {
                    rd.setColor(new Color(m.csky[0], m.csky[1], m.csky[2]));
                    rd.fillRect(232, 70, yourwasted.getWidth(ob), yourwasted.getHeight(ob));
                    rd.setColor(new Color(m.cfade[0], m.cfade[1], m.cfade[2]));
                    rd.drawRect(232, 70, yourwasted.getWidth(ob), yourwasted.getHeight(ob));
                }
                rd.drawImage(yourwasted, 232, 70, null);
                drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
                holdit = true;
                winner = false;
            }
            if(!holdit)
            {
                int i = 0;
                do
                {
                    if(checkpoints.clear[i] == checkpoints.nlaps * checkpoints.nsp && checkpoints.pos[i] == 0)
                    {
                        if(i == 0)
                        {
                            if(m.flex != 2)
                            {
                                rd.setColor(new Color(m.csky[0], m.csky[1], m.csky[2]));
                                rd.fillRect(268, 70, youwon.getWidth(ob), youwon.getHeight(ob));
                                rd.setColor(new Color(m.cfade[0], m.cfade[1], m.cfade[2]));
                                rd.drawRect(268, 70, youwon.getWidth(ob), youwon.getHeight(ob));
                            }
                            rd.drawImage(youwon, 268, 70, null);
                            if(aflk)
                            {
                                drawcs(120, "You finished first, nice job!", 0, 0, 0, 0);
                                aflk = false;
                            } else
                            {
                                drawcs(120, "You finished first, nice job!", 0, 128, 255, 0);
                                aflk = true;
                            }
                            winner = true;
                        } else
                        {
                            if(m.flex != 2)
                            {
                                rd.setColor(new Color(m.csky[0], m.csky[1], m.csky[2]));
                                rd.fillRect(271, 70, youlost.getWidth(ob), youlost.getHeight(ob));
                                rd.setColor(new Color(m.cfade[0], m.cfade[1], m.cfade[2]));
                                rd.drawRect(271, 70, youlost.getWidth(ob), youlost.getHeight(ob));
                            }
                            rd.drawImage(youlost, 271, 70, null);
                            if(aflk)
                            {
                                drawcs(120, "" + names[sc[i]] + " finished first, race over!", 0, 0, 0, 0);
                                aflk = false;
                            } else
                            {
                                drawcs(120, "" + names[sc[i]] + " finished first, race over!", 0, 128, 255, 0);
                                aflk = true;
                            }
                            winner = false;
                        }
                        drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
                        checkpoints.haltall = true;
                        holdit = true;
                    }
                } while(++i < 7);
            }
            if(flag)
            {
                if(checkpoints.stage != 110 && arrace != control.arrace)
                {
                    arrace = control.arrace;
                    if(arrace)
                    {
                        wasay = true;
                        say = " Arrow now pointing at  Cars  <";
                        tcnt = -5;
                    }
                    if(!arrace)
                    {
                        wasay = false;
                        say = " Arrow now pointing at  Track  <";
                        tcnt = -5;
                        cntan = 20;
                    }
                }
                if(!holdit && fase != -6 && starcnt == 0)
                {
                    arrow(madness.point, madness.missedcp, checkpoints, arrace);
                    if(!arrace && auscnt == 45 && madness.capcnt == 0)
                    {
                        if(madness.missedcp > 0)
                        {
                            if(madness.missedcp > 15 && madness.missedcp < 50)
                            {
                                if(flk)
                                {
                                    drawcs(70, "Checkpoint Missed!", 255, 0, 0, 0);
                                } else
                                {
                                    drawcs(70, "Checkpoint Missed!", 255, 150, 0, 2);
                                }
                            }
                            madness.missedcp++;
                            if(madness.missedcp == 70)
                            {
                                madness.missedcp = -2;
                            }
                        } else
                        if(madness.mtouch && cntovn < 70)
                        {
                            if(Math.abs(ana) > 100)
                            {
                                cntan++;
                            } else
                            if(cntan != 0)
                            {
                                cntan--;
                            }
                            if(cntan > 40)
                            {
                                cntovn++;
                                cntan = 40;
                                if(flk)
                                {
                                    drawcs(70, "Wrong Way!", 255, 150, 0, 0);
                                    flk = false;
                                } else
                                {
                                    drawcs(70, "Wrong Way!", 255, 0, 0, 2);
                                    flk = true;
                                }
                            }
                        }
                    }
                }
                if(m.flex != 2)
                {
                    rd.drawImage(dmg, 470, 7, null);
                    rd.drawImage(pwr, 470, 27, null);
                    rd.drawImage(lap, 19, 7, null);
                    rd.setColor(new Color(0, 0, 100));
                    rd.drawString("" + (madness.nlaps + 1) + " / " + checkpoints.nlaps + "", 51, 18);
                    rd.drawImage(was, 92, 7, null);
                    rd.setColor(new Color(0, 0, 100));
                    rd.drawString("" + checkpoints.wasted + " / 6", 150, 18);
                    rd.drawImage(pos, 42, 27, null);
                    rd.drawImage(rank[checkpoints.pos[madness.im]], 110, 28, null);
                    m.flex++;
                } else
                {
                    if(posit != checkpoints.pos[madness.im])
                    {
                        rd.drawImage(rank[checkpoints.pos[madness.im]], 110, 28, null);
                        posit = checkpoints.pos[madness.im];
                    }
                    if(wasted != checkpoints.wasted)
                    {
                        rd.setColor(new Color(m.csky[0], m.csky[1], m.csky[2]));
                        rd.fillRect(150, 8, 30, 10);
                        rd.setColor(new Color(0, 0, 100));
                        rd.drawString("" + checkpoints.wasted + " / 6", 150, 18);
                        wasted = checkpoints.wasted;
                    }
                    if(laps != madness.nlaps)
                    {
                        rd.setColor(new Color(m.csky[0], m.csky[1], m.csky[2]));
                        rd.fillRect(51, 8, 40, 10);
                        rd.setColor(new Color(0, 0, 100));
                        rd.drawString("" + (madness.nlaps + 1) + " / " + checkpoints.nlaps + "", 51, 18);
                        laps = madness.nlaps;
                    }
                }
                drawstat(madness.maxmag[madness.cn], madness.hitmag, madness.newcar, madness.power);
            }
            if(!holdit)
            {
                if(starcnt != 0 && starcnt <= 35)
                {
                    if(starcnt == 35 && !mutes)
                    {
                        three.setFramePosition(0);
                        three.start();
                    }
                    if(starcnt == 24)
                    {
                        gocnt = 2;
                        if(!mutes)
                        {
                            two.setFramePosition(0);
                            two.start();
                        }
                    }
                    if(starcnt == 13)
                    {
                        gocnt = 1;
                        if(!mutes)
                        {
                            one.setFramePosition(0);
                            one.start();
                        }
                    }
                    if(starcnt == 2)
                    {
                        gocnt = 0;
                        if(!mutes)
                        {
                            go.setFramePosition(0);
                            go.start();
                        }
                    }
                    duds = 0;
                    if(starcnt <= 37 && starcnt > 32)
                    {
                        duds = 1;
                    }
                    if(starcnt <= 26 && starcnt > 21)
                    {
                        duds = 1;
                    }
                    if(starcnt <= 15 && starcnt > 10)
                    {
                        duds = 1;
                    }
                    if(starcnt <= 4)
                    {
                        duds = 2;
                        m.flex = 0;
                    }
                    if(dudo != -1)
                    {
                        rd.drawImage(dudeb[duds], dudo, 0, null);
                    }
                    if(gocnt != 0)
                    {
                        rd.drawImage(cntdn[gocnt], 320, 50, null);
                    } else
                    {
                        rd.drawImage(cntdn[gocnt], 298, 50, null);
                    }
                }
                if(looped != 0 && madness.loop == 2)
                {
                    looped = 0;
                }
                if(madness.power < 45F)
                {
                    if(tcnt == 30 && auscnt == 45 && madness.mtouch && madness.capcnt == 0)
                    {
                        if(looped != 2)
                        {
                            if(pwcnt < 70 || pwcnt < 160 && looped != 0)
                            {
                                if(pwflk)
                                {
                                    drawcs(110, "Power low, perform stunt!", 0, 0, 200, 0);
                                    pwflk = false;
                                } else
                                {
                                    drawcs(110, "Power low, perform stunt!", 255, 100, 0, 0);
                                    pwflk = true;
                                }
                            }
                        } else
                        if(pwcnt < 250)
                        {
                            if(pwflk)
                            {
                                drawcs(105, "> >  Press Enter for GAME INSTRUCTIONS!  < <", 0, 0, 200, 0);
                                drawcs(120, "To learn how to preform STUNTS!", 0, 0, 200, 0);
                                pwflk = false;
                            } else
                            {
                                drawcs(105, "> >  Press Enter for GAME INSTRUCTIONS!  < <", 255, 100, 0, 0);
                                drawcs(120, "To learn how to preform STUNTS!", 255, 100, 0, 0);
                                pwflk = true;
                            }
                        }
                        pwcnt++;
                        if(pwcnt == 300)
                        {
                            pwcnt = 0;
                            if(looped != 0)
                            {
                                looped++;
                                if(looped == 3)
                                {
                                    looped = 1;
                                }
                            }
                        }
                    }
                } else
                if(pwcnt != 0)
                {
                    pwcnt = 0;
                }
                if(madness.capcnt == 0)
                {
                    if(tcnt < 30)
                    {
                        if(tflk)
                        {
                            if(!wasay)
                            {
                                drawcs(105, say, 0, 0, 0, 0);
                            } else
                            {
                                drawcs(105, say, 0, 0, 0, 0);
                            }
                            tflk = false;
                        } else
                        {
                            if(!wasay)
                            {
                                drawcs(105, say, 0, 128, 255, 0);
                            } else
                            {
                                drawcs(105, say, 255, 128, 0, 0);
                            }
                            tflk = true;
                        }
                        tcnt++;
                    } else
                    if(wasay)
                    {
                        wasay = false;
                    }
                    if(auscnt < 45)
                    {
                        if(aflk)
                        {
                            drawcs(85, asay, 98, 176, 255, 0);
                            aflk = false;
                        } else
                        {
                            drawcs(85, asay, 0, 128, 255, 0);
                            aflk = true;
                        }
                        auscnt++;
                    }
                } else
                if(tflk)
                {
                    drawcs(110, "Bad Landing!", 0, 0, 200, 0);
                    tflk = false;
                } else
                {
                    drawcs(110, "Bad Landing!", 255, 100, 0, 0);
                    tflk = true;
                }
                if(madness.trcnt == 10)
                {
                    loop = "";
                    spin = "";
                    asay = "";
                    int j;
                    for(j = 0; madness.travzy > 225; j++)
                    {
                        madness.travzy -= 360;
                    }

                    while(madness.travzy < -225) 
                    {
                        madness.travzy += 360;
                        j--;
                    }
                    if(j == 1)
                    {
                        loop = "Forward loop";
                    }
                    if(j == 2)
                    {
                        loop = "double Forward";
                    }
                    if(j == 3)
                    {
                        loop = "triple Forward";
                    }
                    if(j >= 4)
                    {
                        loop = "massive Forward looping";
                    }
                    if(j == -1)
                    {
                        loop = "Backloop";
                    }
                    if(j == -2)
                    {
                        loop = "double Back";
                    }
                    if(j == -3)
                    {
                        loop = "triple Back";
                    }
                    if(j <= -4)
                    {
                        loop = "massive Back looping";
                    }
                    if(j == 0)
                    {
                        if(madness.ftab && madness.btab)
                        {
                            loop = "Tabletop and reversed Tabletop";
                        } else
                        if(madness.ftab || madness.btab)
                        {
                            loop = "Tabletop";
                        }
                    }
                    if(j > 0 && madness.btab)
                    {
                        loop = "Hanged " + loop;
                    }
                    if(j < 0 && madness.ftab)
                    {
                        loop = "Hanged " + loop;
                    }
                    if(loop != "")
                    {
                        asay += " " + loop;
                    }
                    j = 0;
                    for(madness.travxy = Math.abs(madness.travxy); madness.travxy > 270;)
                    {
                        madness.travxy -= 360;
                        j++;
                    }

                    if(j == 0 && madness.rtab)
                    {
                        if(loop == "")
                        {
                            spin = "Tabletop";
                        } else
                        {
                            spin = "Flipside";
                        }
                    }
                    if(j == 1)
                    {
                        spin = "Rollspin";
                    }
                    if(j == 2)
                    {
                        spin = "double Rollspin";
                    }
                    if(j == 3)
                    {
                        spin = "triple Rollspin";
                    }
                    if(j >= 4)
                    {
                        spin = "massive Roll spinning";
                    }
                    j = 0;
                    boolean flag1 = false;
                    for(madness.travxz = Math.abs(madness.travxz); madness.travxz > 90;)
                    {
                        madness.travxz -= 180;
                        if((j += 180) > 900)
                        {
                            j = 900;
                            flag1 = true;
                        }
                    }

                    if(j != 0)
                    {
                        if(loop == "" && spin == "")
                        {
                            asay += " " + j;
                            if(flag1)
                            {
                                asay += " and beyond";
                            }
                        } else
                        {
                            if(spin != "")
                            {
                                if(loop == "")
                                {
                                    asay += " " + spin;
                                } else
                                {
                                    asay += " with " + spin;
                                }
                            }
                            asay += " by " + j;
                            if(flag1)
                            {
                                asay += " and beyond";
                            }
                        }
                    } else
                    if(spin != "")
                    {
                        if(loop == "")
                        {
                            asay += " " + spin;
                        } else
                        {
                            asay += " by " + spin;
                        }
                    }
                    if(asay != "")
                    {
                        auscnt -= 15;
                    }
                    if(loop != "")
                    {
                        auscnt -= 25;
                    }
                    if(spin != "")
                    {
                        auscnt -= 25;
                    }
                    if(j != 0)
                    {
                        auscnt -= 25;
                    }
                    if(auscnt < 45)
                    {
                        if(!mutes)
                        {
                            powerup.setFramePosition(0);
                            powerup.start();
                        }
                        if(auscnt < -20)
                        {
                            auscnt = -20;
                        }
                        byte byte0 = 0;
                        if(madness.powerup > 20F)
                        {
                            byte0 = 1;
                        }
                        if(madness.powerup > 40F)
                        {
                            byte0 = 2;
                        }
                        if(madness.powerup > 150F)
                        {
                            byte0 = 3;
                        }
                        if(madness.surfer)
                        {
                            asay = " " + adj[4][(int)(m.random() * 3F)] + asay;
                        }
                        if(byte0 != 3)
                        {
                            asay = adj[byte0][(int)(m.random() * 3F)] + asay + exlm[byte0];
                        } else
                        {
                            asay = adj[byte0][(int)(m.random() * 3F)];
                        }
                        if(!wasay)
                        {
                            tcnt = auscnt;
                            if(madness.power != 98F)
                            {
                                say = "Power Up " + (int)((100F * madness.powerup) / 98F) + "%";
                            } else
                            {
                                say = "Power To The MAX";
                            }
                            if(skidup)
                            {
                                skidup = false;
                            } else
                            {
                                skidup = true;
                            }
                        }
                    }
                }
                if(madness.newcar)
                {
                    if(!wasay)
                    {
                        say = "Car Fixed";
                        tcnt = 0;
                    }
                    if(crashup)
                    {
                        crashup = false;
                    } else
                    {
                        crashup = true;
                    }
                }
                if(clear != madness.clear && madness.clear != 0)
                {
                    if(!wasay)
                    {
                        say = "Checkpoint!";
                        tcnt = 15;
                    }
                    clear = madness.clear;
                    if(!mutes)
                    {
                        checkpoint.setFramePosition(0);
                        checkpoint.start();
                    }
                    cntovn = 0;
                    if(cntan != 0)
                    {
                        cntan = 0;
                    }
                }
                int k = 1;
                do
                {
                    if(dested[k] != checkpoints.dested[k])
                    {
                        dested[k] = checkpoints.dested[k];
                        if(dested[k] == 1)
                        {
                            wasay = true;
                            say = "" + names[sc[k]] + " has been wasted!";
                            tcnt = -15;
                        }
                        if(dested[k] == 2)
                        {
                            wasay = true;
                            say = "You wasted " + names[sc[k]] + "!";
                            tcnt = -15;
                        }
                    }
                } while(++k < 7);
            }
        }
    }

    public void finish(CheckPoints checkpoints, ContO aconto[], Control control)
    {
        rd.drawImage(fleximg, 0, 0, null);
        if(winner)
        {
            if(checkpoints.stage == unlocked)
            {
                if(checkpoints.stage != 17)
                {
                    rd.drawImage(congrd, 200, 30, null);
                    drawcs(80, "Stage " + checkpoints.stage + " Completed!", 170, 170, 170, 3);
                } else
                {
                    rd.drawImage(congrd, 195 + (int)(m.random() * 10F), 30, null);
                }
                byte byte0 = 0;
                int i = 0;
                pin = 60;
                if(checkpoints.stage == 2)
                {
                    byte0 = 8;
                    i = 265;
                    pin = 0;
                    sc[0] = 8;
                }
                if(checkpoints.stage == 4)
                {
                    byte0 = 9;
                    i = 240;
                    pin = 0;
                    sc[0] = 9;
                }
                if(checkpoints.stage == 6)
                {
                    byte0 = 10;
                    i = 290;
                    pin = 0;
                    sc[0] = 10;
                }
                if(checkpoints.stage == 8)
                {
                    byte0 = 11;
                    i = 226;
                    pin = 0;
                    sc[0] = 11;
                }
                if(checkpoints.stage == 10)
                {
                    byte0 = 12;
                    i = 200;
                    pin = 0;
                    sc[0] = 12;
                }
                if(checkpoints.stage == 12)
                {
                    byte0 = 13;
                    i = 200;
                    pin = 0;
                    sc[0] = 13;
                }
                if(checkpoints.stage == 14)
                {
                    byte0 = 14;
                    i = 270;
                    pin = 0;
                    sc[0] = 14;
                }
                if(checkpoints.stage == 16)
                {
                    byte0 = 15;
                    i = 290;
                    pin = 0;
                    sc[0] = 15;
                }
                if(checkpoints.stage != 17)
                {
                    rd.setFont(new Font("SansSerif", 1, 13));
                    ftm = rd.getFontMetrics();
                    if(aflk)
                    {
                        drawcs(120 + pin, "Stage " + (checkpoints.stage + 1) + " is now unlocked!", 176, 196, 0, 3);
                    } else
                    {
                        drawcs(120 + pin, "Stage " + (checkpoints.stage + 1) + " is now unlocked!", 247, 255, 165, 3);
                    }
                    if(byte0 != 0)
                    {
                        if(aflk)
                        {
                            drawcs(140, "And:", 176, 196, 0, 3);
                        } else
                        {
                            drawcs(140, "And:", 247, 255, 165, 3);
                        }
                        rd.setColor(new Color(236, 226, 202));
                        float f = (float)Math.random();
                        if((double)f < 0.69999999999999996D)
                        {
                            rd.drawRect(160, 150, 349, 126);
                        } else
                        {
                            rd.fillRect(160, 150, 350, 127);
                        }
                        rd.setColor(new Color(255, 209, 89));
                        rd.fillRect(161, 151, 348, 4);
                        rd.fillRect(161, 151, 4, 125);
                        rd.fillRect(161, 272, 348, 4);
                        rd.fillRect(505, 151, 4, 125);
                        aconto[byte0].y = i;
                        m.crs = true;
                        m.x = -335;
                        m.y = 0;
                        m.z = -50;
                        m.xz = 0;
                        m.zy = 0;
                        m.ground = 2470;
                        aconto[byte0].z = 1000;
                        aconto[byte0].x = 0;
                        aconto[byte0].xz += 5;
                        aconto[byte0].zy = 0;
                        aconto[byte0].wzy -= 10;
                        aconto[byte0].d(rd);
                        if((double)f < 0.10000000000000001D)
                        {
                            rd.setColor(new Color(236, 226, 202));
                            int j = 0;
                            do
                            {
                                rd.drawLine(165, 155 + 4 * j, 504, 155 + 4 * j);
                            } while(++j < 30);
                        }
                        String s = "";
                        if(byte0 == 13)
                        {
                            s = " ";
                        }
                        if(aflk)
                        {
                            drawcs(300, "" + names[byte0] + "" + s + " has been unlocked!", 176, 196, 0, 3);
                        } else
                        {
                            drawcs(300, "" + names[byte0] + "" + s + " has been unlocked!", 247, 255, 165, 3);
                        }
                        pin = 180;
                    }
                    rd.setFont(new Font("SansSerif", 1, 11));
                    ftm = rd.getFontMetrics();
                    drawcs(140 + pin, "GAME SAVED", 230, 167, 0, 3);
                    if(pin == 60)
                    {
                        pin = 30;
                    } else
                    {
                        pin = 0;
                    }
                } else
                {
                    rd.setFont(new Font("SansSerif", 1, 13));
                    ftm = rd.getFontMetrics();
                    if(aflk)
                    {
                        drawcs(90, "Woohoooo you finished the game!!!", 144, 167, 255, 3);
                    } else
                    {
                        drawcs(90, "Woohoooo you finished the game!!!", 228, 240, 255, 3);
                    }
                    if(aflk)
                    {
                        drawcs(140, "Your Awesome!", 144, 167, 255, 3);
                    } else
                    {
                        drawcs(142, "Your Awesome!", 228, 240, 255, 3);
                    }
                    if(aflk)
                    {
                        drawcs(190, "You're truly a RADICAL GAMER!", 144, 167, 255, 3);
                    } else
                    {
                        drawcs(190, "You're truly a RADICAL GAMER!", 255, 100, 100, 3);
                    }
                    rd.setColor(new Color(0, 0, 0));
                    rd.fillRect(0, 205, 670, 62);
                    rd.drawImage(radicalplay, radpx + (int)(8D * Math.random() - 4D), 205, null);
                    if(radpx != 147)
                    {
                        radpx += 40;
                        if(radpx > 670)
                        {
                            radpx = -453;
                        }
                    }
                    if(flipo == 40)
                    {
                        radpx = 148;
                    }
                    flipo++;
                    if(flipo == 70)
                    {
                        flipo = 0;
                    }
                    if(radpx == 147)
                    {
                        rd.setFont(new Font("SansSerif", 1, 11));
                        ftm = rd.getFontMetrics();
                        if(aflk)
                        {
                            drawcs(259, "A Game by Radicalplay.com", 144, 167, 255, 3);
                        } else
                        {
                            drawcs(259, "A Game by Radicalplay.com", 228, 240, 255, 3);
                        }
                    }
                    if(aflk)
                    {
                        drawcs(300, "Now get up and dance!", 144, 167, 255, 3);
                    } else
                    {
                        drawcs(300, "Now get up and dance!", 228, 240, 255, 3);
                    }
                    pin = 0;
                }
                if(aflk)
                {
                    aflk = false;
                } else
                {
                    aflk = true;
                }
            } else
            {
                pin = 30;
                rd.drawImage(congrd, 200, 87, null);
                drawcs(137, "Stage " + checkpoints.stage + " Completed!", 170, 170, 170, 3);
                drawcs(154, "" + checkpoints.name + "", 128, 128, 128, 3);
            }
        } else
        {
            pin = 30;
            rd.drawImage(gameov, 250, 117, null);
            drawcs(167, "Failed to Complete Stage " + checkpoints.stage + "!", 170, 170, 170, 3);
            drawcs(184, "" + checkpoints.name + "", 128, 128, 128, 3);
        }
        rd.drawImage(contin[pcontin], 290, 350 - pin, null);
        if(control.enter || control.handb)
        {
            fase = 10;
            if(loadedt[checkpoints.stage - 1])
            {
                stracks[checkpoints.stage - 1].stop();
            }
            if(checkpoints.stage == unlocked && winner && unlocked != 17)
            {
                checkpoints.stage++;
                unlocked++;
            }
            flipo = 0;
            control.enter = false;
            control.handb = false;
        }
    }

    public void sortcars(int i)
    {
        if(i != 0)
        {
            int j = 1;
            do
            {
                sc[j] = -1;
            } while(++j < 7);
            boolean aflag[] = new boolean[7];
            if(unlocked == i && unlocked != 17)
            {
                sc[6] = 7 + (i + 1) / 2;
                int k = 1;
                do
                {
                    aflag[k] = false;
                } while(++k < 6);
                if(i == 14)
                {
                    if(sc[0] != 12)
                    {
                        sc[5] = 12;
                    } else
                    {
                        sc[5] = 1;
                    }
                    if(sc[0] != 10)
                    {
                        sc[4] = 10;
                    } else
                    {
                        sc[4] = 1;
                    }
                    aflag[4] = true;
                    aflag[5] = true;
                    k = (int)(Math.random() * 3D + 1.0D);
                    if(sc[0] != 9)
                    {
                        sc[k] = 9;
                        aflag[k] = true;
                        if(++k == 4)
                        {
                            k = 1;
                        }
                    }
                    if(sc[0] != 5)
                    {
                        sc[k] = 5;
                        aflag[k] = true;
                        if(++k == 4)
                        {
                            k = 1;
                        }
                    }
                    if(sc[0] != 8)
                    {
                        sc[k] = 8;
                        aflag[k] = true;
                        if(++k == 4)
                        {
                            k = 1;
                        }
                    }
                }
                if(i == 16)
                {
                    k = 4;
                    byte byte1 = 5;
                    byte byte2 = 1;
                    byte byte3 = 2;
                    if(Math.random() > Math.random())
                    {
                        k = 5;
                        byte1 = 4;
                    }
                    if(Math.random() < Math.random())
                    {
                        byte2 = 2;
                        byte3 = 1;
                    }
                    if(sc[0] != 12)
                    {
                        sc[k] = 12;
                    } else
                    {
                        sc[k] = 14;
                    }
                    if(sc[0] != 10)
                    {
                        sc[byte1] = 10;
                    } else
                    {
                        sc[byte1] = 14;
                    }
                    if(sc[0] != 11)
                    {
                        sc[byte2] = 11;
                    } else
                    {
                        sc[byte2] = 14;
                    }
                    if(sc[0] != 13)
                    {
                        sc[byte3] = 13;
                    } else
                    {
                        sc[byte3] = 14;
                    }
                    if(sc[0] <= 9)
                    {
                        sc[3] = 14;
                    } else
                    {
                        sc[3] = 9;
                    }
                    int j3 = 1;
                    do
                    {
                        aflag[j3] = true;
                    } while(++j3 < 6);
                }
                k = 1;
                do
                {
                    while(!aflag[k]) 
                    {
                        sc[k] = (int)(Math.random() * (double)(7 + (i + 1) / 2));
                        aflag[k] = true;
                        int l = 0;
                        do
                        {
                            if(k != l && sc[k] == sc[l])
                            {
                                aflag[k] = false;
                            }
                        } while(++l < 7);
                        if(Math.random() < (double)proba[sc[k]])
                        {
                            aflag[k] = false;
                        }
                        if(i == 10)
                        {
                            if(sc[0] != 11)
                            {
                                if(sc[k] == 2 || sc[k] == 4 || sc[k] == 11)
                                {
                                    aflag[k] = false;
                                }
                            } else
                            if(sc[k] == 9)
                            {
                                aflag[k] = false;
                            }
                        }
                        if(i == 11 && (sc[k] == 0 || sc[k] == 1 || sc[k] == 2 || sc[k] == 3 || sc[k] == 4 || sc[k] == 7))
                        {
                            aflag[k] = false;
                        }
                        if((i == 12 || i == 15) && sc[k] <= 4)
                        {
                            aflag[k] = false;
                        }
                        if(i != 11 && i != 12 && k != 1 && k != 2 && sc[k] == 13)
                        {
                            aflag[k] = false;
                        }
                    }
                } while(++k < 6);
                if(i == 15)
                {
                    boolean flag = false;
                    int i1 = 0;
                    do
                    {
                        if(sc[i1] == 13)
                        {
                            flag = true;
                        }
                    } while(++i1 < 6);
                    if(!flag && Math.random() > Math.random())
                    {
                        if(Math.random() > Math.random())
                        {
                            sc[1] = 13;
                        } else
                        {
                            sc[2] = 13;
                        }
                    }
                }
                if(i == 12)
                {
                    boolean flag1 = false;
                    int j1 = 0;
                    do
                    {
                        if(sc[j1] == 11)
                        {
                            flag1 = true;
                        }
                    } while(++j1 < 6);
                    if(!flag1)
                    {
                        sc[2] = 11;
                    }
                }
                if(i == 8)
                {
                    boolean flag2 = false;
                    int k1 = 0;
                    do
                    {
                        if(sc[k1] == 9)
                        {
                            flag2 = true;
                        }
                    } while(++k1 < 6);
                    if(!flag2)
                    {
                        sc[5] = 9;
                    }
                    flag2 = false;
                    k1 = 0;
                    do
                    {
                        if(sc[k1] == 8)
                        {
                            flag2 = true;
                        }
                    } while(++k1 < 6);
                    if(!flag2)
                    {
                        sc[4] = 8;
                    }
                    flag2 = false;
                    k1 = 0;
                    do
                    {
                        if(sc[k1] == 10)
                        {
                            flag2 = true;
                        }
                    } while(++k1 < 6);
                    if(!flag2)
                    {
                        sc[2] = 10;
                    }
                }
                if(i == 9)
                {
                    boolean flag3 = false;
                    int l1 = 0;
                    do
                    {
                        if(sc[l1] == 10)
                        {
                            flag3 = true;
                        }
                    } while(++l1 < 6);
                    if(flag3)
                    {
                        if(sc[5] != 10)
                        {
                            boolean flag4 = false;
                            int i2 = 0;
                            do
                            {
                                if(sc[i2] == 5)
                                {
                                    flag4 = true;
                                }
                            } while(++i2 < 6);
                            if(flag4)
                            {
                                if(sc[5] != 5)
                                {
                                    boolean flag5 = false;
                                    int j2 = 0;
                                    do
                                    {
                                        if(sc[j2] == 9)
                                        {
                                            flag5 = true;
                                        }
                                    } while(++j2 < 6);
                                    if(!flag5)
                                    {
                                        sc[5] = 9;
                                    }
                                }
                            } else
                            {
                                sc[5] = 5;
                            }
                        }
                    } else
                    {
                        sc[5] = 10;
                    }
                }
            } else
            {
                byte byte0 = 7;
                if(sc[0] != 7 + (i + 1) / 2 && i != 17)
                {
                    sc[6] = 7 + (i + 1) / 2;
                    byte0 = 6;
                }
                for(int k2 = 1; k2 < byte0; k2++)
                {
                    for(aflag[k2] = false; !aflag[k2];)
                    {
                        int i3 = unlocked;
                        if(i3 == 17)
                        {
                            i3 = 16;
                        }
                        sc[k2] = (int)(Math.random() * (double)(8 + (i3 + 1) / 2));
                        aflag[k2] = true;
                        int i1 = 0;
                        do
                        {
                            if(k2 != i1 && sc[k2] == sc[i1])
                            {
                                aflag[k2] = false;
                            }
                        } while(++i1 < 7);
                        float f = proba[sc[k2]];
                        if(i - sc[k2] > 4 && i != 17)
                        {
                            f += (float)(i - sc[k2] - 4) / 10F;
                            if((double)f > 0.90000000000000002D)
                            {
                                f = 0.9F;
                            }
                        }
                        if(i == 16 && sc[k2] <= 8 && (double)f < 0.90000000000000002D)
                        {
                            f = 0.9F;
                        }
                        if(Math.random() < (double)f)
                        {
                            aflag[k2] = false;
                        }
                        if(i != 11 && i != 12 && k2 != 1 && k2 != 2 && sc[k2] == 13 && aflag[k2])
                        {
                            aflag[k2] = false;
                            if(Math.random() > Math.random() * 1.6000000000000001D && i != 14 || i == 16 && Math.random() > Math.random())
                            {
                                if(Math.random() > Math.random())
                                {
                                    sc[1] = 13;
                                } else
                                {
                                    sc[2] = 13;
                                }
                            }
                        }
                    }

                }

            }
            if(i == 12)
            {
                boolean flag6 = false;
                int l2 = 0;
                do
                {
                    if(sc[l2] == 11)
                    {
                        flag6 = true;
                    }
                } while(++l2 < 6);
                if(!flag6)
                {
                    sc[2] = 11;
                }
            }
        }
    }

    public void sparkeng(int i)
    {
        i++;
        int j = 0;
        do
        {
            if(i == j)
            {
                if(!pengs[j])
                {
                    engs[enginsignature[sc[0]]][j].loop(Clip.LOOP_CONTINUOUSLY);
                    pengs[j] = true;
                }
            } else
            if(pengs[j])
            {
                engs[enginsignature[sc[0]]][j].stop();
                pengs[j] = false;
            }
        } while(++j < 5);
    }

    public void drawcs(int i, String s, int j, int k, int l, int i1)
    {
        if(i1 != 3 && i1 != 4)
        {
            j = (int)((float)j + (float)j * ((float)m.snap[0] / 100F));
            if(j > 255)
            {
                j = 255;
            }
            if(j < 0)
            {
                j = 0;
            }
            k = (int)((float)k + (float)k * ((float)m.snap[1] / 100F));
            if(k > 255)
            {
                k = 255;
            }
            if(k < 0)
            {
                k = 0;
            }
            l = (int)((float)l + (float)l * ((float)m.snap[2] / 100F));
            if(l > 255)
            {
                l = 255;
            }
            if(l < 0)
            {
                l = 0;
            }
        }
        if(i1 == 4)
        {
            j = (int)((float)j - (float)j * ((float)m.snap[0] / 100F));
            if(j > 255)
            {
                j = 255;
            }
            if(j < 0)
            {
                j = 0;
            }
            k = (int)((float)k - (float)k * ((float)m.snap[1] / 100F));
            if(k > 255)
            {
                k = 255;
            }
            if(k < 0)
            {
                k = 0;
            }
            l = (int)((float)l - (float)l * ((float)m.snap[2] / 100F));
            if(l > 255)
            {
                l = 255;
            }
            if(l < 0)
            {
                l = 0;
            }
        }
        if(i1 == 1)
        {
            rd.setColor(new Color(0, 0, 0));
            rd.drawString(s, (335 - ftm.stringWidth(s) / 2) + 1, i + 1);
        }
        if(i1 == 2)
        {
            j = (j * 2 + m.csky[0] * 1) / 3;
            if(j > 255)
            {
                j = 255;
            }
            if(j < 0)
            {
                j = 0;
            }
            k = (k * 2 + m.csky[1] * 1) / 3;
            if(k > 255)
            {
                k = 255;
            }
            if(k < 0)
            {
                k = 0;
            }
            l = (l * 2 + m.csky[2] * 1) / 3;
            if(l > 255)
            {
                l = 255;
            }
            if(l < 0)
            {
                l = 0;
            }
        }
        rd.setColor(new Color(j, k, l));
        rd.drawString(s, 335 - ftm.stringWidth(s) / 2, i);
    }

    public int py(int i, int j, int k, int l)
    {
        return (i - j) * (i - j) + (k - l) * (k - l);
    }

    public void trackbg(boolean flag)
    {
        int i = 0;
        trkl++;
        if(trkl > trklim)
        {
            i = 1;
            trklim = (int)(Math.random() * 40D);
            trkl = 0;
        }
        if(flag)
        {
            i = 0;
        }
        int j = 0;
        do
        {
            rd.drawImage(trackbg[i][j], trkx[j], 0, null);
            trkx[j]--;
            if(trkx[j] <= -670)
            {
                trkx[j] = 670;
            }
        } while(++j < 2);
    }

    public void stageselect(CheckPoints checkpoints, Control control)
    {
        stages.play();
        rd.drawImage(br, 0, 0, null);
        rd.drawImage(select, 273, 45, null);
        if(checkpoints.stage != 1)
        {
            rd.drawImage(back[pback], 50, 110, null);
        }
        if(checkpoints.stage != 17)
        {
            rd.drawImage(next[pnext], 560, 110, null);
        }
        rd.setFont(new Font("SansSerif", 1, 13));
        ftm = rd.getFontMetrics();
        if(checkpoints.stage != 17)
        {
            drawcs(80, "Stage " + checkpoints.stage + "  >", 255, 255, 255, 3);
        } else
        {
            drawcs(80, "Final Party Stage  >", 255, 255, 255, 3);
        }
        drawcs(100, "| " + checkpoints.name + " |", 210, 210, 210, 3);
        rd.drawImage(contin[pcontin], 290, 325, null);
        rd.setFont(new Font("SansSerif", 1, 11));
        ftm = rd.getFontMetrics();
        drawcs(396, "You can also use Keyboard Arrows and Enter to navigate.", 82, 90, 0, 3);
        if(control.handb || control.enter)
        {
            asay = "Stage " + checkpoints.stage + ":  " + checkpoints.name + " ";
            dudo = 150;
            m.trk = false;
            m.focus_point = 400;
            fase = 5;
            control.handb = false;
            control.enter = false;
            stages.stop();
            stages.unloadMod();
        }
        if(control.right && checkpoints.stage != 17)
        {
            if(checkpoints.stage != unlocked)
            {
                checkpoints.stage++;
                fase = 2;
                control.right = false;
            } else
            {
                fase = 4;
                lockcnt = 100;
                control.right = false;
            }
        }
        if(control.left && checkpoints.stage != 1)
        {
            checkpoints.stage--;
            fase = 2;
            control.left = false;
        }
    }

    public void snap(int i)
    {
        dmg = loadsnap(odmg);
        pwr = loadsnap(opwr);
        was = loadsnap(owas);
        lap = loadsnap(olap);
        pos = loadsnap(opos);
        int j = 0;
        do
        {
            rank[j] = loadsnap(orank[j]);
        } while(++j < 7);
        j = 0;
        do
        {
            cntdn[j] = loadsnap(ocntdn[j]);
        } while(++j < 4);
        yourwasted = loadsnap(oyourwasted);
        youlost = loadsnap(oyoulost);
        youwon = loadsnap(oyouwon);
        youwastedem = loadsnap(oyouwastedem);
        gameh = loadsnap(ogameh);
        loadingmusic = loadopsnap(oloadingmusic, i, 76);
        star[0] = loadopsnap(ostar[0], i, 0);
        star[1] = loadopsnap(ostar[1], i, 0);
        flaot = loadopsnap(oflaot, i, 1);
    }

    private Image loadsnap(Image image)
    {
        int i = image.getHeight(ob);
        int j = image.getWidth(ob);
        int ai[] = new int[j * i];
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, j, i, ai, 0, j);
        try
        {
            pixelgrabber.grabPixels();
        }
        catch(InterruptedException _ex) { }
        for(int k = 0; k < j * i; k++)
        {
            if(ai[k] != 0xffc0c0c0 && ai[k] != ai[j * i - 1])
            {
                Color color = new Color(ai[k]);
                int l = (int)((float)color.getRed() + (float)color.getRed() * ((float)m.snap[0] / 100F));
                if(l > 225)
                {
                    l = 225;
                }
                if(l < 0)
                {
                    l = 0;
                }
                int i1 = (int)((float)color.getGreen() + (float)color.getGreen() * ((float)m.snap[1] / 100F));
                if(i1 > 225)
                {
                    i1 = 225;
                }
                if(i1 < 0)
                {
                    i1 = 0;
                }
                int j1 = (int)((float)color.getBlue() + (float)color.getBlue() * ((float)m.snap[2] / 100F));
                if(j1 > 225)
                {
                    j1 = 225;
                }
                if(j1 < 0)
                {
                    j1 = 0;
                }
                Color color2 = new Color(l, i1, j1);
                ai[k] = color2.getRGB();
            } else
            if(ai[k] == 0xffc0c0c0)
            {
                Color color1 = new Color(m.csky[0], m.csky[1], m.csky[2]);
                ai[k] = color1.getRGB();
            }
        }

        Image image1 = createImage(new MemoryImageSource(j, i, ai, 0, j));
        return image1;
    }

    public void resetstat(int i)
    {
        arrace = false;
        ana = 0;
        cntan = 0;
        cntovn = 0;
        tcnt = 30;
        wasay = false;
        clear = 0;
        dmcnt = 0;
        pwcnt = 0;
        auscnt = 45;
        pnext = 0;
        pback = 0;
        starcnt = 130;
        gocnt = 3;
        grrd = true;
        aird = true;
        bfcrash = 0;
        cntwis = 0;
        bfskid = 0;
        pwait = 7;
        holdcnt = 0;
        holdit = false;
        winner = false;
        wasted = 0;
        int j = 0;
        do
        {
            dested[j] = 0;
        } while(++j < 7);
        sortcars(i);
    }

    public void drawstat(int i, int j, boolean flag, float f)
    {
        int ai[] = new int[4];
        int ai1[] = new int[4];
        if(flag)
        {
            ai[0] = 533;
            ai1[0] = 11;
            ai[1] = 533;
            ai1[1] = 19;
            ai[2] = 630;
            ai1[2] = 19;
            ai[3] = 630;
            ai1[3] = 11;
            rd.setColor(new Color(m.csky[0], m.csky[1], m.csky[2]));
            rd.fillPolygon(ai, ai1, 4);
        }
        if(j > i)
        {
            j = i;
        }
        int k = (int)(98F * ((float)j / (float)i));
        ai[0] = 532;
        ai1[0] = 11;
        ai[1] = 532;
        ai1[1] = 20;
        ai[2] = 532 + k;
        ai1[2] = 20;
        ai[3] = 532 + k;
        ai1[3] = 11;
        int l = 244;
        int i1 = 244;
        int j1 = 11;
        if(k > 33)
        {
            i1 = (int)(244F - 233F * ((float)(k - 33) / 65F));
        }
        if(k > 70)
        {
            if(dmcnt < 10)
            {
                if(dmflk)
                {
                    i1 = 170;
                    dmflk = false;
                } else
                {
                    dmflk = true;
                }
            }
            dmcnt++;
            if((double)dmcnt > 167D - (double)k * 1.5D)
            {
                dmcnt = 0;
            }
        }
        l = (int)((float)l + (float)l * ((float)m.snap[0] / 100F));
        if(l > 255)
        {
            l = 255;
        }
        if(l < 0)
        {
            l = 0;
        }
        i1 = (int)((float)i1 + (float)i1 * ((float)m.snap[1] / 100F));
        if(i1 > 255)
        {
            i1 = 255;
        }
        if(i1 < 0)
        {
            i1 = 0;
        }
        j1 = (int)((float)j1 + (float)j1 * ((float)m.snap[2] / 100F));
        if(j1 > 255)
        {
            j1 = 255;
        }
        if(j1 < 0)
        {
            j1 = 0;
        }
        rd.setColor(new Color(l, i1, j1));
        rd.fillPolygon(ai, ai1, 4);
        ai[0] = 532;
        ai1[0] = 31;
        ai[1] = 532;
        ai1[1] = 40;
        ai[2] = (int)(532F + f);
        ai1[2] = 40;
        ai[3] = (int)(532F + f);
        ai1[3] = 31;
        l = 128;
        if(f == 98F)
        {
            l = 64;
        }
        i1 = (int)(190D + (double)f * 0.37D);
        j1 = 244;
        if(auscnt < 45 && aflk)
        {
            l = 128;
            i1 = 244;
            j1 = 244;
        }
        l = (int)((float)l + (float)l * ((float)m.snap[0] / 100F));
        if(l > 255)
        {
            l = 255;
        }
        if(l < 0)
        {
            l = 0;
        }
        i1 = (int)((float)i1 + (float)i1 * ((float)m.snap[1] / 100F));
        if(i1 > 255)
        {
            i1 = 255;
        }
        if(i1 < 0)
        {
            i1 = 0;
        }
        j1 = (int)((float)j1 + (float)j1 * ((float)m.snap[2] / 100F));
        if(j1 > 255)
        {
            j1 = 255;
        }
        if(j1 < 0)
        {
            j1 = 0;
        }
        rd.setColor(new Color(l, i1, j1));
        rd.fillPolygon(ai, ai1, 4);
        if(m.flex == 2 && f != 98F)
        {
            ai[0] = (int)(532F + f);
            ai1[0] = 31;
            ai[1] = (int)(532F + f);
            ai1[1] = 39;
            ai[2] = 630;
            ai1[2] = 39;
            ai[3] = 630;
            ai1[3] = 31;
            rd.setColor(new Color(m.csky[0], m.csky[1], m.csky[2]));
            rd.fillPolygon(ai, ai1, 4);
        }
    }

    private Image bressed(Image image)
    {
        int i = image.getHeight(ob);
        int j = image.getWidth(ob);
        int ai[] = new int[j * i];
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, j, i, ai, 0, j);
        try
        {
            pixelgrabber.grabPixels();
        }
        catch(InterruptedException _ex) { }
        Color color = new Color(247, 255, 165);
        for(int k = 0; k < j * i; k++)
        {
            if(ai[k] != ai[j * i - 1])
            {
                ai[k] = color.getRGB();
            }
        }

        Image image1 = createImage(new MemoryImageSource(j, i, ai, 0, j));
        return image1;
    }

    public void loading()
    {
        rd.setColor(new Color(0, 0, 0));
        rd.fillRect(0, 0, 670, 400);
        rd.drawImage(sign, 297, 10, this);
        rd.drawImage(hello, 60, 80, this);
        rd.setColor(new Color(198, 214, 255));
        rd.fillRoundRect(185, 315, 300, 80, 30, 70);
        rd.setColor(new Color(128, 167, 255));
        rd.drawRoundRect(185, 315, 300, 80, 30, 70);
        rd.drawImage(loadbar, 216, 340, this);
        rd.setFont(new Font("SansSerif", 1, 11));
        ftm = rd.getFontMetrics();
        drawcs(333, "Loading game, please wait.", 0, 0, 0, 3);
        rd.setColor(new Color(255, 255, 255));
        rd.fillRect(230, 373, 210, 17);
        shload += (((float)dnload + 10F) - shload) / 100F;
        if(shload > (float)kbload)
        {
            shload = kbload;
        }
        if(dnload == kbload)
        {
            shload = kbload;
        }
        drawcs(385, "" + (int)(((26F + (shload / (float)kbload) * 200F) / 226F) * 100F) + " % loaded    |    " + (kbload - (int)shload) + " KB remaining", 32, 64, 128, 3);
        rd.setColor(new Color(32, 64, 128));
        rd.fillRect(222, 346, 26 + (int)((shload / (float)kbload) * 200F), 10);
    }

    public xtGraphics(Medium medium, Graphics g, Panel panel)
    {
        fase = 111;
        oldfase = 0;
        starcnt = 0;
        unlocked = 1;
        lockcnt = 0;
        opselect = 1;
        shaded = false;
        flipo = 0;
        nextc = false;
        gatey = 0;
        looped = 1;
        sc = new int[7];
        holdit = false;
        holdcnt = 0;
        winner = false;
        flexpix = new int[0x416e0];
        smokey = new int[0x16fb4];
        flatrstart = 0;
        runtyp = 0;
        trackbg = new Image[2][2];
        dude = new Image[3];
        dudeb = new Image[3];
        duds = 0;
        dudo = 0;
        next = new Image[2];
        back = new Image[2];
        contin = new Image[2];
        ostar = new Image[2];
        star = new Image[3];
        pcontin = 0;
        pnext = 0;
        pback = 0;
        pstar = 0;
        orank = new Image[7];
        rank = new Image[7];
        ocntdn = new Image[4];
        cntdn = new Image[4];
        gocnt = 0;
        engs = new Clip[5][5];
        pengs = new boolean[5];
        air = new Clip[6];
        aird = false;
        grrd = false;
        crash = new Clip[3];
        lowcrash = new Clip[3];
        pwastd = false;
        skid = new Clip[3];
        dustskid = new Clip[3];
        mutes = false;
        stracks = new RadicalMod[17];
        loadedt = new boolean[17];
        lastload = -1;
        mutem = false;
        sunny = false;
        macn = false;
        arrace = false;
        ana = 0;
        cntan = 0;
        cntovn = 0;
        flk = false;
        tcnt = 30;
        tflk = false;
        say = "";
        wasay = false;
        clear = 0;
        posit = 0;
        wasted = 0;
        laps = 0;
        dested = new int[7];
        dmcnt = 0;
        dmflk = false;
        pwcnt = 0;
        pwflk = false;
        loop = "";
        spin = "";
        asay = "";
        auscnt = 45;
        aflk = false;
        kbload = 0;
        dnload = 0;
        shload = 0.0F;
        radpx = 147;
        pin = 60;
        trkl = 0;
        trklim = (int)(Math.random() * 40D);
        flkat = (int)(60D + 140D * Math.random());
        movly = (int)(100D + 100D * Math.random());
        xdu = 272;
        ydu = 2;
        gxdu = 0;
        gydu = 0;
        pgady = new int[9];
        pgas = new boolean[9];
        lxm = -10;
        lym = -10;
        pwait = 7;
        stopcnt = 0;
        cntwis = 0;
        crshturn = 0;
        bfcrash = 0;
        bfskid = 0;
        crashup = false;
        skidup = false;
        skflg = 0;
        dskflg = 0;
        flatr = 0;
        flyr = 0;
        flyrdest = 0;
        flang = 0;
        flangados = 0;
        blackn = 0.0F;
        blacknados = 0.0F;
        m = medium;
        pane = panel;
        rd = g;
        MediaTracker mediatracker = new MediaTracker(pane);
        hello = getImage("data/hello.gif");
        mediatracker.addImage(hello, 0);
        try
        {
            mediatracker.waitForID(0);
        }
        catch(Exception _ex) { }
        sign = getImage("data/sign.gif");
        mediatracker.addImage(sign, 0);
        try
        {
            mediatracker.waitForID(0);
        }
        catch(Exception _ex) { }
        loadbar = getImage("data/loadbar.gif");
        mediatracker.addImage(loadbar, 0);
        try
        {
            mediatracker.waitForID(0);
        }
        catch(Exception _ex) { }
        int i = 0;
        do
        {
            loadedt[i] = false;
        } while(++i < 17);
    }

    public void maini(Control control)
    {
        if(lastload >= 0 && loadedt[lastload])
        {
            stracks[lastload].unloadMod();
        }
        if(flipo == 0)
        {
            bgmy[0] = 0;
            bgmy[1] = 400;
            pane.setCursor(new Cursor(0));
        }
        int i = 0;
        do
        {
            rd.drawImage(bgmain, 0, bgmy[i], null);
            bgmy[i] -= 20;
            if(bgmy[i] <= -400)
            {
                bgmy[i] = 400;
            }
        } while(++i < 2);
        if(flipo > flkat)
        {
            rd.drawImage(logomadbg, 67 + (int)(4D - Math.random() * 8D), 143 + (int)(4D - Math.random() * 8D), null);
        } else
        {
            rd.drawImage(logomadbg, 67, 143, null);
        }
        rd.drawImage(dude[0], xdu, ydu, null);
        rd.drawImage(logocars, 12, 28, null);
        if(flipo > flkat)
        {
            rd.drawImage(logomadnes, 99 + (int)(4D - Math.random() * 8D), 148 + (int)(4D - Math.random() * 8D), null);
        } else
        {
            rd.drawImage(logomadnes, 99, 148, null);
        }
        flipo++;
        if(flipo > flkat + 36)
        {
            flipo = 1;
            flkat = (int)(60D + 140D * Math.random());
        }
        if(movly <= 10)
        {
            if(movly == 10 || movly == 8 || movly == 6 || movly == 4 || movly == 2)
            {
                gxdu = (int)((double)(xdu + 200) - 400D * Math.random());
                gydu = (int)((double)(ydu + 200) - 400D * Math.random());
                if(movly == 2)
                {
                    gxdu = 272;
                    gydu = 2;
                }
                movly--;
            }
            xdu += (gxdu - xdu) / 15;
            ydu += (gydu - ydu) / 15;
            if(movly != 1)
            {
                if(pys(xdu, gxdu, ydu, gydu) < 20F)
                {
                    movly--;
                }
            } else
            {
                if(xdu > gxdu)
                {
                    xdu--;
                } else
                {
                    xdu++;
                }
                if(ydu > gydu)
                {
                    ydu--;
                } else
                {
                    ydu++;
                }
                if(pys(xdu, gxdu, ydu, gydu) < 2.0F)
                {
                    movly--;
                }
            }
            if(movly == 0)
            {
                xdu = 272;
                ydu = 2;
                movly = (int)(100D + 100D * Math.random());
            }
        } else
        if(flipo >= movly)
        {
            movly = 10;
        }
        rd.drawImage(opback, 179, 212, null);
        rd.drawImage(nfmcoms, 237, 195, null);
        rd.drawImage(byrd, 264, 383, null);
        if(control.up)
        {
            opselect--;
            if(opselect == -1)
            {
                opselect = 2;
            }
            control.up = false;
        }
        if(control.down)
        {
            opselect++;
            if(opselect == 3)
            {
                opselect = 0;
            }
            control.down = false;
        }
        if(opselect == 0)
        {
            if(shaded)
            {
                rd.setColor(new Color(140, 70, 0));
                rd.fillRect(278, 246, 110, 22);
                aflk = false;
            }
            if(aflk)
            {
                rd.setColor(new Color(200, 255, 0));
                aflk = false;
            } else
            {
                rd.setColor(new Color(255, 128, 0));
                aflk = true;
            }
            rd.drawRoundRect(278, 246, 110, 22, 7, 20);
        } else
        {
            rd.setColor(new Color(0, 0, 0));
            rd.drawRoundRect(278, 246, 110, 22, 7, 20);
        }
        if(opselect == 1)
        {
            if(shaded)
            {
                rd.setColor(new Color(140, 70, 0));
                rd.fillRect(234, 275, 196, 22);
                aflk = false;
            }
            if(aflk)
            {
                rd.setColor(new Color(200, 128, 0));
                aflk = false;
            } else
            {
                rd.setColor(new Color(255, 128, 0));
                aflk = true;
            }
            rd.drawRoundRect(234, 275, 196, 22, 7, 20);
        } else
        {
            rd.setColor(new Color(0, 0, 0));
            rd.drawRoundRect(234, 275, 196, 22, 7, 20);
        }
        if(opselect == 2)
        {
            if(shaded)
            {
                rd.setColor(new Color(140, 70, 0));
                rd.fillRect(290, 306, 85, 22);
                aflk = false;
            }
            if(aflk)
            {
                rd.setColor(new Color(200, 0, 0));
                aflk = false;
            } else
            {
                rd.setColor(new Color(255, 128, 0));
                aflk = true;
            }
            rd.drawRoundRect(290, 306, 85, 22, 7, 20);
        } else
        {
            rd.setColor(new Color(0, 0, 0));
            rd.drawRoundRect(290, 306, 85, 22, 7, 20);
        }
        rd.drawImage(opti, 241, 250, null);
        if(control.enter || control.handb)
        {
            if(opselect == 0)
            {
                if(unlocked == 1 && oldfase == 0)
                {
                    oldfase = -9;
                    fase = 11;
                } else
                {
                    fase = -9;
                }
            }
            if(opselect == 1)
            {
                oldfase = 10;
                fase = 11;
            }
            if(opselect == 2)
            {
                fase = 8;
            }
            flipo = 0;
            control.enter = false;
            control.handb = false;
        }
        if(shaded)
        {
            pane.repaint();
            try
            {
                Thread.sleep(100L);
            }
            catch(InterruptedException _ex) { }
        }
    }

    public void blendude(Image image)
    {
        if(!macn)
        {
            if(Math.random() > Math.random())
            {
                dudo = 217;
            } else
            {
                dudo = 331;
            }
            int ai[] = new int[19520];
            PixelGrabber pixelgrabber = new PixelGrabber(image, dudo, 0, 122, 160, ai, 0, 122);
            try
            {
                pixelgrabber.grabPixels();
            }
            catch(InterruptedException _ex)
            {
                dudo = -1;
            }
            int j = 0;
            do
            {
                int ai1[] = new int[19520];
                PixelGrabber pixelgrabber1 = new PixelGrabber(dude[j], 0, 10, 122, 160, ai1, 0, 122);
                try
                {
                    pixelgrabber1.grabPixels();
                }
                catch(InterruptedException _ex)
                {
                    dudo = -1;
                }
                if(dudo != -1)
                {
                    int k = 0;
                    do
                    {
                        if(ai1[k] != ai1[0])
                        {
                            Color color = new Color(ai1[k]);
                            Color color1 = new Color(ai[k]);
                            int l = (color.getRed() + color1.getRed() * 3) / 4;
                            if(l > 255)
                            {
                                l = 255;
                            }
                            if(l < 0)
                            {
                                l = 0;
                            }
                            int i1 = (color.getGreen() + color1.getGreen() * 3) / 4;
                            if(i1 > 255)
                            {
                                i1 = 255;
                            }
                            if(i1 < 0)
                            {
                                i1 = 0;
                            }
                            int j1 = (color.getBlue() + color1.getBlue() * 3) / 4;
                            if(j1 > 255)
                            {
                                j1 = 255;
                            }
                            if(j1 < 0)
                            {
                                j1 = 0;
                            }
                            Color color2 = new Color(l, i1, j1);
                            ai1[k] = color2.getRGB();
                        }
                    } while(++k < 19520);
                    dudeb[j] = createImage(new MemoryImageSource(122, 160, ai1, 0, 122));
                }
            } while(++j < 3);
        } else
        {
            if(Math.random() > Math.random())
            {
                dudo = 176;
            } else
            {
                dudo = 372;
            }
            int i = 0;
            do
            {
                dudeb[i] = dude[i];
            } while(++i < 3);
        }
    }

    public void musicomp(int i, Control control)
    {
        hipnoload(i, true);
        if(control.handb || control.enter)
        {
            System.gc();
            fase = 0;
            control.handb = false;
            control.enter = false;
        }
    }

    public void drawSmokeCarsbg()
    {
        if(Math.abs(flyr - flyrdest) > 20)
        {
            if(flyr > flyrdest)
            {
                flyr -= 20;
            } else
            {
                flyr += 20;
            }
        } else
        {
            flyr = flyrdest;
            flyrdest = (int)(((float)flyr + m.random() * 160F) - 80F);
        }
        if(flyr > 160)
        {
            flyr = 160;
        }
        if(flatr > 170)
        {
            flatrstart++;
            flatr = flatrstart * 3;
            flyr = (int)(m.random() * 160F - 80F);
            flyrdest = (int)(((float)flyr + m.random() * 160F) - 80F);
            flang = 1;
            flangados = (int)(m.random() * 6F + 2.0F);
            blackn = 0.0F;
            blacknados = m.random() * 0.4F;
        }
        int i = 0;
        do
        {
            int j = 0;
            do
            {
                if(smokey[i + j * 466] != smokey[0])
                {
                    float f = pys(i, 233, j, flyr);
                    int k = (int)(((float)(i - 233) / f) * (float)flatr);
                    int l = (int)(((float)(j - flyr) / f) * (float)flatr);
                    int i1 = i + k + 100 + (j + l + 110) * 670;
                    if(i + k + 100 < 670 && i + k + 100 > 0 && j + l + 110 < 400 && j + l + 110 > 0 && i1 < 0x416e0 && i1 >= 0)
                    {
                        Color color = new Color(flexpix[i1]);
                        Color color1 = new Color(smokey[i + j * 466]);
                        float f1 = (255F - (float)color1.getRed()) / 255F;
                        int j1 = (int)(((float)color.getRed() * ((float)flang * f1) + (float)color1.getRed() * (1.0F - f1)) / ((float)flang * f1 + (1.0F - f1) + blackn));
                        if(j1 > 255)
                        {
                            j1 = 255;
                        }
                        if(j1 < 0)
                        {
                            j1 = 0;
                        }
                        Color color2 = new Color(j1, j1, j1);
                        flexpix[i1] = color2.getRGB();
                    }
                }
            } while(++j < 202);
        } while(++i < 466);
        blackn += blacknados;
        flang += flangados;
        flatr += 10 + flatrstart * 2;
        Image image = createImage(new MemoryImageSource(670, 400, flexpix, 0, 670));
        rd.drawImage(image, 0, 0, null);
    }

    public void loaddata(int i)
    {
        kbload = 625;
        sunny = false;
        String s = "default/";
        String s1 = "wav";
        if(i == 2)
        {
            kbload = 950;
            sunny = true;
            s = "JavaNew/";
            s1 = "wav";
        }
        String s2 = System.getProperty("os.name");
        if(!s2.startsWith("Win"))
        {
            macn = true;
        }
        runtyp = 176;
        runner = new Thread(this);
        runner.start();
        loadimages();
        cars = new RadicalMod("music/cars.radq");
        dnload += 27;
        int j = 0;
        do
        {
            int k = 0;
            do
            {
                engs[k][j] = getSound("sounds/" + s + "" + k + "" + j + ".wav");
                dnload += 3;
            } while(++k < 5);
            pengs[j] = false;
        } while(++j < 5);
        stages = new RadicalMod("music/stages.radq");
        dnload += 91;
        j = 0;
        do
        {
            air[j] = getSound("sounds/" + s + "air" + j + ".wav");
            dnload += 2;
        } while(++j < 6);
        j = 0;
        do
        {
            crash[j] = getSound("sounds/" + s + "crash" + (j + 1) + "." + s1);
            if(i == 2)
            {
                dnload += 10;
            } else
            {
                dnload += 7;
            }
        } while(++j < 3);
        j = 0;
        do
        {
            lowcrash[j] = getSound("sounds/" + s + "lowcrash" + (j + 1) + "." + s1);
            if(i == 2)
            {
                dnload += 10;
            } else
            {
                dnload += 3;
            }
        } while(++j < 3);
        tires = getSound("sounds/" + s + "tires." + s1);
        if(i == 2)
        {
            dnload += 24;
        } else
        {
            dnload += 4;
        }
        checkpoint = getSound("sounds/" + s + "checkpoint." + s1);
        if(i == 2)
        {
            dnload += 24;
        } else
        {
            dnload += 6;
        }
        carfixed = getSound("sounds/" + s + "carfixed." + s1);
        if(i == 2)
        {
            dnload += 24;
        } else
        {
            dnload += 10;
        }
        powerup = getSound("sounds/" + s + "powerup." + s1);
        if(i == 2)
        {
            dnload += 42;
        } else
        {
            dnload += 8;
        }
        three = getSound("sounds/" + s + "three." + s1);
        if(i == 2)
        {
            dnload += 24;
        } else
        {
            dnload += 4;
        }
        two = getSound("sounds/" + s + "two." + s1);
        if(i == 2)
        {
            dnload += 24;
        } else
        {
            dnload += 2;
        }
        one = getSound("sounds/" + s + "one." + s1);
        if(i == 2)
        {
            dnload += 24;
        } else
        {
            dnload += 4;
        }
        go = getSound("sounds/" + s + "go." + s1);
        if(i == 2)
        {
            dnload += 24;
        } else
        {
            dnload += 4;
        }
        wastd = getSound("sounds/" + s + "wasted." + s1);
        if(i == 2)
        {
            dnload += 24;
        } else
        {
            dnload += 4;
        }
        firewasted = getSound("sounds/" + s + "firewasted." + s1);
        if(i == 2)
        {
            dnload += 24;
        } else
        {
            dnload += 10;
        }
        j = 0;
        do
        {
            skid[j] = getSound("sounds/" + s + "skid" + (j + 1) + "." + s1);
            if(i == 2)
            {
                dnload += 22;
            } else
            {
                dnload += 6;
            }
        } while(++j < 3);
        j = 0;
        do
        {
            dustskid[j] = getSound("sounds/" + s + "dustskid" + (j + 1) + "." + s1);
            if(i == 2)
            {
                dnload += 22;
            } else
            {
                dnload += 7;
            }
        } while(++j < 3);
    }

    public void clicknow()
    {
        rd.setColor(new Color(198, 214, 255));
        rd.fillRoundRect(185, 315, 300, 80, 30, 70);
        rd.setColor(new Color(128, 167, 255));
        rd.drawRoundRect(185, 315, 300, 80, 30, 70);
        if(aflk)
        {
            drawcs(355, "Click here to Start", 0, 0, 0, 3);
            aflk = false;
        } else
        {
            drawcs(355, "Click here to Start", 0, 67, 200, 3);
            aflk = true;
        }
    }

    private Image loadimage(byte abyte0[], MediaTracker mediatracker, Toolkit toolkit)
    {
        Image image = toolkit.createImage(abyte0);
        mediatracker.addImage(image, 0);
        try
        {
            mediatracker.waitForID(0);
        }
        catch(Exception _ex) { }
        return image;
    }

    public void rad(int i)
    {
        if(i == 0)
        {
            powerup.setFramePosition(0);
            powerup.start();
            radpx = 147;
            pin = 0;
        }
        trackbg(false);
        rd.setColor(new Color(0, 0, 0));
        rd.fillRect(0, 110, 670, 59);
        if(pin != 0)
        {
            rd.drawImage(radicalplay, radpx + (int)(8D * Math.random() - 4D), 110, null);
        } else
        {
            rd.drawImage(radicalplay, 147, 110, null);
        }
        if(radpx != 147)
        {
            radpx += 40;
            if(radpx > 670)
            {
                radpx = -453;
            }
        } else
        if(pin != 0)
        {
            pin--;
        }
        if(i == 40)
        {
            radpx = 148;
            pin = 7;
        }
        if(radpx == 147)
        {
            rd.setFont(new Font("SansSerif", 1, 11));
            ftm = rd.getFontMetrics();
            drawcs(160 + (int)(5F * m.random()), "Radicalplay.com", 112, 120, 143, 3);
        }
        rd.setFont(new Font("SansSerif", 1, 11));
        ftm = rd.getFontMetrics();
        if(aflk)
        {
            drawcs(190, "And we are never going to find the new unless we get a little crazy...", 112, 120, 143, 3);
            aflk = false;
        } else
        {
            drawcs(192, "And we are never going to find the new unless we get a little crazy...", 150, 150, 150, 3);
            aflk = true;
        }
        rd.drawImage(rpro, 210, 240, null);
    }

    public void skid(int i, float f)
    {
        if(bfcrash == 0 && bfskid == 0 && f > 150F)
        {
            if(i == 0)
            {
                if(!mutes)
                {
                    skid[skflg].setFramePosition(0);
                    skid[skflg].start();
                }
                if(skidup)
                {
                    skflg++;
                } else
                {
                    skflg--;
                }
                if(skflg == 3)
                {
                    skflg = 0;
                }
                if(skflg == -1)
                {
                    skflg = 2;
                }
            } else
            {
                if(!mutes)
                {
                    dustskid[dskflg].setFramePosition(0);
                    dustskid[dskflg].start();
                }
                if(skidup)
                {
                    dskflg++;
                } else
                {
                    dskflg--;
                }
                if(dskflg == 3)
                {
                    dskflg = 0;
                }
                if(dskflg == -1)
                {
                    dskflg = 2;
                }
            }
            bfskid = 35;
        }
    }

    public int xs(int i, int j)
    {
        if(j < 50)
        {
            j = 50;
        }
        return ((j - m.focus_point) * (m.cx - i)) / j + i;
    }

    public void cantreply()
    {
        rd.setColor(new Color(64, 143, 223));
        rd.fillRoundRect(135, 73, 400, 23, 7, 20);
        rd.setColor(new Color(0, 89, 223));
        rd.drawRoundRect(135, 73, 400, 23, 7, 20);
        drawcs(89, "Sorry not enough replay data to play available, please try again later.", 255, 255, 255, 1);
    }

    public void stopallnow()
    {
        int i = 0;
        do
        {
            if(loadedt[i])
            {
                stracks[i].unloadAll();
                stracks[i] = null;
            }
        } while(++i < 17);
        i = 0;
        do
        {
            engs[0][i].stop();
            engs[1][i].stop();
        } while(++i < 5);
        i = 0;
        do
        {
            air[i].stop();
        } while(++i < 6);
        wastd.stop();
        cars.unloadAll();
        stages.unloadAll();
    }

    public void inishcarselect()
    {
        carsbginflex();
        flatrstart = 0;
        m.lightson = false;
        cars.loadMod(200, 7900, 125, sunny, macn);
        pnext = 0;
        pback = 0;
    }

    public void carselect(Control control, ContO aconto[], Madness madness)
    {
        cars.play();
        if(flatrstart == 6)
        {
            rd.drawImage(carsbg, 0, 0, null);
        } else
        if(flatrstart <= 1)
        {
            drawSmokeCarsbg();
        } else
        {
            rd.setColor(new Color(255, 255, 255));
            rd.fillRect(0, 0, 670, 400);
            carsbginflex();
            flatrstart = 6;
        }
        rd.drawImage(selectcar, 256, 12, null);
        m.crs = true;
        m.x = -335;
        m.y = -500;
        m.z = -50;
        m.xz = 0;
        m.zy = 10;
        m.ground = 470;
        aconto[sc[0]].d(rd);
        if(flipo == 0)
        {
            rd.setFont(new Font("SansSerif", 1, 13));
            ftm = rd.getFontMetrics();
            byte byte0 = 0;
            if(flatrstart < 6)
            {
                byte0 = 2;
            }
            if(aflk)
            {
                drawcs(70 + byte0, names[sc[0]], 240, 240, 240, 3);
                aflk = false;
            } else
            {
                drawcs(70, names[sc[0]], 176, 176, 176, 3);
                aflk = true;
            }
            aconto[sc[0]].z = 950;
            if(sc[0] == 13)
            {
                aconto[sc[0]].z = 1000;
            }
            aconto[sc[0]].y = -34 - aconto[sc[0]].grat;
            aconto[sc[0]].x = 0;
            aconto[sc[0]].xz += 5;
            aconto[sc[0]].zy = 0;
            aconto[sc[0]].wzy -= 10;
            if(aconto[sc[0]].wzy < -45)
            {
                aconto[sc[0]].wzy += 45;
            }
            if(sc[0] != 0)
            {
                rd.drawImage(back[pback], 30, 250, null);
            }
            if(sc[0] != 15)
            {
                rd.drawImage(next[pnext], 580, 250, null);
            }
            if((sc[0] - 7) * 2 >= unlocked)
            {
                if(gatey == 300)
                {
                    int i = 0;
                    do
                    {
                        pgas[i] = false;
                        pgady[i] = 0;
                    } while(++i < 9);
                    pgas[0] = true;
                }
                int j = 0;
                do
                {
                    rd.drawImage(pgate, pgatx[j], (pgaty[j] + pgady[j]) - gatey, null);
                    if(flatrstart == 6)
                    {
                        if(pgas[j])
                        {
                            pgady[j] -= ((80 + 100 / (j + 1)) - Math.abs(pgady[j])) / 3;
                            if(pgady[j] < -(70 + 100 / (j + 1)))
                            {
                                pgas[j] = false;
                                if(j != 8)
                                {
                                    pgas[j + 1] = true;
                                }
                            }
                        } else
                        {
                            pgady[j] += ((80 + 100 / (j + 1)) - Math.abs(pgady[j])) / 3;
                            if(pgady[j] > 0)
                            {
                                pgady[j] = 0;
                            }
                        }
                    }
                } while(++j < 9);
                if(gatey != 0)
                {
                    gatey -= 100;
                }
                if(flatrstart == 6)
                {
                    drawcs(335, "[ Car Locked ]", 210, 210, 210, 3);
                    drawcs(355, "This car unlocks when stage " + (sc[0] - 7) * 2 + " is completed...", 181, 120, 40, 3);
                }
            } else
            {
                if(flatrstart == 6)
                {
                    rd.setFont(new Font("SansSerif", 1, 11));
                    ftm = rd.getFontMetrics();
                    rd.setColor(new Color(181, 120, 40));
                    rd.drawString("Top Speed:", 33, 318);
                    rd.drawImage(statb, 97, 312, null);
                    rd.drawString("Acceleration:", 23, 333);
                    rd.drawImage(statb, 97, 327, null);
                    rd.drawString("Handling:", 45, 348);
                    rd.drawImage(statb, 97, 342, null);
                    rd.drawString("Stunts:", 430, 318);
                    rd.drawImage(statb, 471, 312, null);
                    rd.drawString("Strength:", 418, 333);
                    rd.drawImage(statb, 471, 327, null);
                    rd.drawString("Endurance:", 408, 348);
                    rd.drawImage(statb, 471, 342, null);
                    rd.setColor(new Color(0, 0, 0));
                    float f = (float)(madness.swits[sc[0]][2] - 220) / 90F;
                    if((double)f < 0.20000000000000001D)
                    {
                        f = 0.2F;
                    }
                    rd.fillRect((int)(97F + 156F * f), 312, (int)(156F * (1.0F - f) + 1.0F), 7);
                    f = (madness.acelf[sc[0]][1] * madness.acelf[sc[0]][0] * madness.acelf[sc[0]][2] * madness.grip[sc[0]]) / 7700F;
                    if(f > 1.0F)
                    {
                        f = 1.0F;
                    }
                    rd.fillRect((int)(97F + 156F * f), 327, (int)(156F * (1.0F - f) + 1.0F), 7);
                    f = dishandle[sc[0]];
                    rd.fillRect((int)(97F + 156F * f), 342, (int)(156F * (1.0F - f) + 1.0F), 7);
                    f = ((float)madness.airc[sc[0]] * madness.airs[sc[0]] * madness.bounce[sc[0]] + 28F) / 139F;
                    if(f > 1.0F)
                    {
                        f = 1.0F;
                    }
                    rd.fillRect((int)(471F + 156F * f), 312, (int)(156F * (1.0F - f) + 1.0F), 7);
                    float f1 = 0.5F;
                    if(sc[0] == 9)
                    {
                        f1 = 0.8F;
                    }
                    f = (madness.moment[sc[0]] + f1) / 2.6F;
                    if(f > 1.0F)
                    {
                        f = 1.0F;
                    }
                    rd.fillRect((int)(471F + 156F * f), 327, (int)(156F * (1.0F - f) + 1.0F), 7);
                    f = outdam[sc[0]];
                    rd.fillRect((int)(471F + 156F * f), 342, (int)(156F * (1.0F - f) + 1.0F), 7);
                    rd.drawImage(statbo, 97, 312, null);
                    rd.drawImage(statbo, 97, 327, null);
                    rd.drawImage(statbo, 97, 342, null);
                    rd.drawImage(statbo, 471, 312, null);
                    rd.drawImage(statbo, 471, 327, null);
                    rd.drawImage(statbo, 471, 342, null);
                }
                rd.drawImage(contin[pcontin], 290, 360, null);
            }
        } else
        {
            pback = 0;
            pnext = 0;
            gatey = 300;
            if(flipo > 10)
            {
                aconto[sc[0]].y -= 100;
                if(nextc)
                {
                    aconto[sc[0]].zy += 20;
                } else
                {
                    aconto[sc[0]].zy -= 20;
                }
            } else
            {
                if(flipo == 10)
                {
                    if(nextc)
                    {
                        sc[0]++;
                    } else
                    {
                        sc[0]--;
                    }
                    aconto[sc[0]].z = 950;
                    aconto[sc[0]].y = -34 - aconto[sc[0]].grat - 1100;
                    aconto[sc[0]].x = 0;
                    aconto[sc[0]].zy = 0;
                }
                aconto[sc[0]].y += 100;
            }
            flipo--;
        }
        rd.setFont(new Font("SansSerif", 1, 11));
        ftm = rd.getFontMetrics();
        drawcs(396, "You can also use Keyboard Arrows and Enter to navigate.", 82, 90, 0, 3);
        if(control.right)
        {
            control.right = false;
            if(sc[0] != 15 && flipo == 0)
            {
                if(flatrstart > 1)
                {
                    flatrstart = 0;
                }
                nextc = true;
                flipo = 20;
            }
        }
        if(control.left)
        {
            control.left = false;
            if(sc[0] != 0 && flipo == 0)
            {
                if(flatrstart > 1)
                {
                    flatrstart = 0;
                }
                nextc = false;
                flipo = 20;
            }
        }
        if(control.handb || control.enter)
        {
            if(flipo == 0 && (sc[0] - 7) * 2 < unlocked)
            {
                lastload = -11;
                cars.stop();
                cars.unloadMod();
                m.crs = false;
                fase = 2;
            }
            control.handb = false;
            control.enter = false;
        }
    }

    public void ctachm(int i, int j, int k, Control control)
    {
        if(fase == 1)
        {
            if(k == 1)
            {
                if(over(next[0], i, j, 560, 110))
                {
                    pnext = 1;
                }
                if(over(back[0], i, j, 50, 110))
                {
                    pback = 1;
                }
                if(over(contin[0], i, j, 290, 325))
                {
                    pcontin = 1;
                }
            }
            if(k == 2)
            {
                if(pnext == 1)
                {
                    control.right = true;
                }
                if(pback == 1)
                {
                    control.left = true;
                }
                if(pcontin == 1)
                {
                    control.enter = true;
                }
            }
        }
        if(fase == 3)
        {
            if(k == 1 && over(contin[0], i, j, 290, 325))
            {
                pcontin = 1;
            }
            if(k == 2 && pcontin == 1)
            {
                control.enter = true;
                pcontin = 0;
            }
        }
        if(fase == 4)
        {
            if(k == 1 && over(back[0], i, j, 305, 320))
            {
                pback = 1;
            }
            if(k == 2 && pback == 1)
            {
                control.enter = true;
                pback = 0;
            }
        }
        if(fase == 6)
        {
            if(k == 1 && (over(star[0], i, j, 294, 360) || over(star[0], i, j, 294, 270)))
            {
                pstar = 2;
            }
            if(k == 2 && pstar == 2)
            {
                control.enter = true;
                pstar = 1;
            }
        }
        if(fase == 7)
        {
            if(k == 1)
            {
                if(over(next[0], i, j, 580, 250))
                {
                    pnext = 1;
                }
                if(over(back[0], i, j, 30, 250))
                {
                    pback = 1;
                }
                if(over(contin[0], i, j, 290, 360))
                {
                    pcontin = 1;
                }
            }
            if(k == 2)
            {
                if(pnext == 1)
                {
                    control.right = true;
                }
                if(pback == 1)
                {
                    control.left = true;
                }
                if(pcontin == 1)
                {
                    control.enter = true;
                    pcontin = 0;
                }
            }
        }
        if(fase == -5)
        {
            lxm = i;
            lym = j;
            if(k == 1 && over(contin[0], i, j, 290, 350 - pin))
            {
                pcontin = 1;
            }
            if(k == 2 && pcontin == 1)
            {
                control.enter = true;
                pcontin = 0;
            }
        }
        if(fase == -7)
        {
            if(k == 1)
            {
                if(overon(264, 45, 137, 22, i, j))
                {
                    opselect = 0;
                    shaded = true;
                }
                if(overon(255, 73, 155, 22, i, j))
                {
                    opselect = 1;
                    shaded = true;
                }
                if(overon(238, 99, 190, 22, i, j))
                {
                    opselect = 2;
                    shaded = true;
                }
                if(overon(276, 125, 109, 22, i, j))
                {
                    opselect = 3;
                    shaded = true;
                }
            }
            if(k == 2 && shaded)
            {
                control.enter = true;
                shaded = false;
            }
            if(k == 0 && (i != lxm || j != lym))
            {
                if(overon(264, 45, 137, 22, i, j))
                {
                    opselect = 0;
                }
                if(overon(255, 73, 155, 22, i, j))
                {
                    opselect = 1;
                }
                if(overon(238, 99, 190, 22, i, j))
                {
                    opselect = 2;
                }
                if(overon(276, 125, 109, 22, i, j))
                {
                    opselect = 3;
                }
                lxm = i;
                lym = j;
            }
        }
        if(fase == 10)
        {
            if(k == 1)
            {
                if(overon(278, 246, 110, 22, i, j))
                {
                    opselect = 0;
                    shaded = true;
                }
                if(overon(234, 275, 196, 22, i, j))
                {
                    opselect = 1;
                    shaded = true;
                }
                if(overon(290, 306, 85, 22, i, j))
                {
                    opselect = 2;
                    shaded = true;
                }
            }
            if(k == 2 && shaded)
            {
                control.enter = true;
                shaded = false;
            }
            if(k == 0 && (i != lxm || j != lym))
            {
                if(overon(278, 246, 110, 22, i, j))
                {
                    opselect = 0;
                }
                if(overon(234, 275, 196, 22, i, j))
                {
                    opselect = 1;
                }
                if(overon(290, 306, 85, 22, i, j))
                {
                    opselect = 2;
                }
                lxm = i;
                lym = j;
            }
        }
        if(fase == 11)
        {
            if(flipo >= 1 && flipo <= 13)
            {
                if(k == 1 && over(next[0], i, j, 600, 370))
                {
                    pnext = 1;
                }
                if(k == 2 && pnext == 1)
                {
                    control.right = true;
                    pnext = 0;
                }
            }
            if(flipo >= 3 && flipo <= 15)
            {
                if(k == 1 && over(back[0], i, j, 10, 370))
                {
                    pback = 1;
                }
                if(k == 2 && pback == 1)
                {
                    control.left = true;
                    pback = 0;
                }
            }
            if(flipo == 15)
            {
                if(k == 1 && over(contin[0], i, j, 500, 370))
                {
                    pcontin = 1;
                }
                if(k == 2 && pcontin == 1)
                {
                    control.enter = true;
                    pcontin = 0;
                }
            }
        }
        if(fase == 8)
        {
            if(k == 1 && over(next[0], i, j, 600, 370))
            {
                pnext = 1;
            }
            if(k == 2 && pnext == 1)
            {
                control.enter = true;
                pnext = 0;
            }
        }
    }

    public void stopairs()
    {
        int i = 0;
        do
        {
            air[i].stop();
        } while(++i < 6);
    }

    public void run()
    {
        while(runtyp != 0) 
        {
            if(runtyp >= 1 && runtyp <= 17)
            {
                hipnoload(runtyp, false);
            }
            if(runtyp == 176)
            {
                loading();
            }
            pane.repaint();
            try
            {
                Thread.sleep(20L);
            }
            catch(InterruptedException _ex) { }
        }
    }

    public void loadingfailed(int i, Control control)
    {
        trackbg(false);
        rd.drawImage(select, 273, 45, null);
        rd.setFont(new Font("SansSerif", 1, 13));
        ftm = rd.getFontMetrics();
        drawcs(140, "Error Loading Stage " + i, 200, 0, 0, 3);
        drawcs(170, "Your internet connection may have been lost...", 177, 177, 177, 3);
        drawcs(220, "Press Enter to try again.", 177, 177, 177, 3);
        rd.drawImage(contin[pcontin], 290, 325, null);
        rd.drawImage(br, 0, 0, null);
        rd.setFont(new Font("SansSerif", 1, 11));
        ftm = rd.getFontMetrics();
        drawcs(396, "You can also use Keyboard Arrows and Enter to navigate.", 82, 90, 0, 3);
        if(control.handb || control.enter)
        {
            fase = 2;
            control.handb = false;
            control.enter = false;
        }
    }

    public void hipnoload(int i, boolean flag)
    {
        int j = (int)(230F - 230F * ((float)m.snap[0] / (100F * hipno[i - 1])));
        if(j > 255)
        {
            j = 255;
        }
        if(j < 0)
        {
            j = 0;
        }
        int l = (int)(230F - 230F * ((float)m.snap[1] / (100F * hipno[i - 1])));
        if(l > 255)
        {
            l = 255;
        }
        if(l < 0)
        {
            l = 0;
        }
        int j1 = (int)(230F - 230F * ((float)m.snap[2] / (100F * hipno[i - 1])));
        if(j1 > 255)
        {
            j1 = 255;
        }
        if(j1 < 0)
        {
            j1 = 0;
        }
        if(i == 1)
        {
            j = 230;
            l = 230;
            j1 = 230;
        }
        rd.setColor(new Color(j, l, j1));
        rd.fillRect(0, 0, 670, 400);
        rd.setFont(new Font("SansSerif", 1, 13));
        ftm = rd.getFontMetrics();
        drawcs(25, asay, 0, 0, 0, 3);
        byte byte0 = -90;
        if(i == unlocked && (i == 1 || i == 2 || i == 3 || i == 4 || i == 7 || i == 8 || i == 9 || i == 10 || i == 12 || i == 13 || i == 16))
        {
            byte0 = 0;
        }
        if(byte0 == 0)
        {
            if(dudo > 0)
            {
                if(aflk)
                {
                    if(Math.random() > Math.random())
                    {
                        duds = (int)(Math.random() * 3D);
                    } else
                    {
                        duds = (int)(Math.random() * 2D);
                    }
                    aflk = false;
                } else
                {
                    aflk = true;
                }
                dudo--;
            } else
            {
                duds = 0;
            }
            rd.drawImage(dude[duds], 30, 10, null);
            rd.drawImage(flaot, 127, 42, null);
            int k = (int)(80F - 80F * ((float)m.snap[0] / (50F * hipno[i - 1])));
            if(k > 255)
            {
                k = 255;
            }
            if(k < 0)
            {
                k = 0;
            }
            int i1 = (int)(80F - 80F * ((float)m.snap[1] / (50F * hipno[i - 1])));
            if(i1 > 255)
            {
                i1 = 255;
            }
            if(i1 < 0)
            {
                i1 = 0;
            }
            int k1 = (int)(80F - 80F * ((float)m.snap[2] / (50F * hipno[i - 1])));
            if(k1 > 255)
            {
                k1 = 255;
            }
            if(k1 < 0)
            {
                k1 = 0;
            }
            if(i == 1)
            {
                k = 80;
                i1 = 80;
                k1 = 80;
            }
            rd.setColor(new Color(k, i1, k1));
            rd.setFont(new Font("SansSerif", 1, 13));
            if(i == 1)
            {
                rd.drawString("Hey!  Don't forget, to complete a lap you must pass through", 197, 67);
                rd.drawString("all checkpoints in the track!", 197, 87);
            }
            if(i == 2)
            {
                rd.drawString("Remember, the more power you have the faster your car will be!", 197, 67);
            }
            if(i == 3)
            {
                rd.drawString("Watch out!  Look out!  The policeman might be out to get you!", 197, 67);
                rd.drawString("Don't upset him or you'll be arrested!", 197, 87);
                rd.drawString("Better run, run, run.", 197, 127);
            }
            if(i == 4)
            {
                rd.drawString("Don't waste your time.  Waste them instead!", 197, 67);
                rd.drawString("Try a taste of sweet revenge here (if you can)!", 197, 87);
                rd.drawString("Press [ A ] to make the guidance arrow point to cars instead of to", 197, 127);
                rd.drawString("the track.", 197, 147);
            }
            if(i == 7)
            {
                rd.drawString("Welcome to the realm of the king...", 197, 67);
                rd.drawString("The key word here is 'POWER'.  The more you have of it the faster", 197, 107);
                rd.drawString("and STRONGER you car will be!", 197, 127);
            }
            if(i == 8)
            {
                rd.drawString("Watch out, EL KING is out to get you now!", 197, 67);
                rd.drawString("He seems to be seeking revenge?", 197, 87);
                rd.drawString("(To fly longer distances in the air try drifting your car on the ramp", 197, 127);
                rd.drawString("before take off).", 197, 147);
            }
            if(i == 9)
            {
                rd.drawString("It\u2019s good to be the king!", 197, 67);
            }
            if(i == 10)
            {
                rd.drawString("Remember, forward loops give your car a push forwards in the air", 197, 67);
                rd.drawString("and help in racing.", 197, 87);
                rd.drawString("(You may need to do more forward loops here.  Also try keeping", 197, 127);
                rd.drawString("your power at maximum at all times.  Try not to miss a ramp).", 197, 147);
            }
            if(i == 12)
            {
                rd.drawString("Watch out!  Beware!  Take care!", 197, 67);
                rd.drawString("MASHEEN is hiding out there some where, don't get mashed now!", 197, 87);
            }
            if(i == 13)
            {
                rd.drawString("Anyone for a game of Digger?!", 197, 67);
                rd.drawString("You can have fun using MASHEEN here!", 197, 87);
            }
            if(i == 16)
            {
                rd.drawString("This is it!  This is the toughest stage in the game!", 197, 67);
                rd.drawString("This track is actually a 4D object projected onto the 3D world.", 197, 107);
                rd.drawString("It's been broken down, separated and, in many ways, it is also a", 197, 127);
                rd.drawString("maze!  GOOD LUCK!", 197, 147);
            }
        }
        rd.drawImage(loadingmusic, 224, 180 + byte0, null);
        rd.setFont(new Font("SansSerif", 1, 11));
        ftm = rd.getFontMetrics();
        if(!flag)
        {
            drawcs(315 + byte0, "" + sndsize[i - 1] + " KB", 0, 0, 0, 3);
            drawcs(350 + byte0, " Please Wait...", 0, 0, 0, 3);
        } else
        {
            drawcs(340 + byte0, "Loading complete!  Press Start to begin...", 0, 0, 0, 3);
            rd.drawImage(star[pstar], 294, 360 + byte0, null);
            if(pstar != 2)
            {
                if(pstar == 0)
                {
                    pstar = 1;
                } else
                {
                    pstar = 0;
                }
            }
        }
    }

    private Image loadopsnap(Image image, int i, int j)
    {
        int k = image.getHeight(ob);
        int l = image.getWidth(ob);
        int ai[] = new int[l * k];
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, l, k, ai, 0, l);
        try
        {
            pixelgrabber.grabPixels();
        }
        catch(InterruptedException _ex) { }
        int i1 = 0;
        if(j == 1)
        {
            i1 = ai[61993];
        }
        for(int j1 = 0; j1 < l * k; j1++)
        {
            if(ai[j1] != ai[j])
            {
                Color color = new Color(ai[j1]);
                int k1 = 0;
                int l1 = 0;
                int i2 = 0;
                if(j == 1 && ai[j1] == i1)
                {
                    k1 = (int)(237F - 237F * ((float)m.snap[0] / (150F * hipno[i - 1])));
                    if(k1 > 255)
                    {
                        k1 = 255;
                    }
                    if(k1 < 0)
                    {
                        k1 = 0;
                    }
                    l1 = (int)(237F - 237F * ((float)m.snap[1] / (150F * hipno[i - 1])));
                    if(l1 > 255)
                    {
                        l1 = 255;
                    }
                    if(l1 < 0)
                    {
                        l1 = 0;
                    }
                    i2 = (int)(237F - 237F * ((float)m.snap[2] / (150F * hipno[i - 1])));
                    if(i2 > 255)
                    {
                        i2 = 255;
                    }
                    if(i2 < 0)
                    {
                        i2 = 0;
                    }
                    if(i == 1)
                    {
                        k1 = 250;
                        l1 = 250;
                        i2 = 250;
                    }
                } else
                {
                    k1 = (int)((float)color.getRed() - (float)color.getRed() * ((float)m.snap[0] / (50F * hipno[i - 1])));
                    if(k1 > 255)
                    {
                        k1 = 255;
                    }
                    if(k1 < 0)
                    {
                        k1 = 0;
                    }
                    l1 = (int)((float)color.getGreen() - (float)color.getGreen() * ((float)m.snap[1] / (50F * hipno[i - 1])));
                    if(l1 > 255)
                    {
                        l1 = 255;
                    }
                    if(l1 < 0)
                    {
                        l1 = 0;
                    }
                    i2 = (int)((float)color.getBlue() - (float)color.getBlue() * ((float)m.snap[2] / (50F * hipno[i - 1])));
                    if(i2 > 255)
                    {
                        i2 = 255;
                    }
                    if(i2 < 0)
                    {
                        i2 = 0;
                    }
                    if(i == 1)
                    {
                        k1 = color.getRed();
                        l1 = color.getGreen();
                        i2 = color.getBlue();
                    }
                }
                Color color1 = new Color(k1, l1, i2);
                ai[j1] = color1.getRGB();
            }
        }

        Image image1 = createImage(new MemoryImageSource(l, k, ai, 0, l));
        return image1;
    }

    private Clip getSound(String s)
    {
        Clip clip = null;
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("/app/games/nfm2/" + s));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clip;
    }
    
    private Image getImage(String s) {
        Image image = null;
        try {
            image = ImageIO.read(new File("/app/games/nfm2/" + s));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }

    public void carsbginflex()
    {
        flatr = 0;
        flyr = (int)(m.random() * 160F - 80F);
        flyrdest = (int)(((float)flyr + m.random() * 160F) - 80F);
        flang = 1;
        flangados = (int)(m.random() * 6F + 2.0F);
        blackn = 0.0F;
        blacknados = m.random() * 0.4F;
        PixelGrabber pixelgrabber = new PixelGrabber(carsbg, 0, 0, 670, 400, flexpix, 0, 670);
        try
        {
            pixelgrabber.grabPixels();
        }
        catch(InterruptedException _ex) { }
    }
}
