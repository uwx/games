import java.applet.Applet;
import java.awt.AlphaComposite;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Event;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.RenderingHints;
import java.awt.TextField;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import javax.swing.JOptionPane;

public class StageMaker extends Applet implements Runnable {
   Graphics2D rd;
   Image offImage;
   Thread thredo;
   boolean exwist = false;
   FontMetrics ftm;
   int apx = 0;
   int apy = 0;
   String sstage = "";
   String suser = "Horaks";
   int tab = 0;
   int tabed = -1;
   Image[] btgame = new Image[2];
   Image logo;
   boolean onbtgame = false;
   boolean focuson = true;
   boolean overcan = false;
   boolean left = false;
   boolean right = false;
   boolean up = false;
   boolean down = false;
   boolean zoomi = false;
   boolean zoomo = false;
   String stagename = "";
   String tstage = "snap(0,0,0)\r\nsky(191,215,255)\r\nclouds(255,255,255,5,-1000)\r\nfog(195,207,230)\r\nground(192,194,202)\r\ntexture(0,0,0,50)\r\nfadefrom(5000)\r\ndensity(5)\n\rmountains("
      + (int)(Math.random() * 100000.0)
      + ")\r\nnlaps(5)\r\n\r\n";
   String bstage = "set(47,0,0,0)\r\nmaxr(11,28500,-5600)\r\nmaxb(9,-8000,-12300)\r\nmaxl(11,-14700,-5600)\r\nmaxt(9,44800,-12300)\r\n";
   String[] undos = new String[5000];
   int nundo = 0;
   Medium m = new Medium();
   CheckPoints cp = new CheckPoints();
   Trackers t = new Trackers();
   ContO[] bco = new ContO[67];
   ContO[] co = new ContO[601];
   int nob = 0;
   int xnob = 0;
   int errd = 0;
   int origfade = 5000;
   int sfase = 0;
   Smenu slstage = new Smenu(2000);
   TextField srch = new TextField("", 38);
   Smenu strtyp = new Smenu(40);
   Smenu ptyp = new Smenu(40);
   Smenu part = new Smenu(40);
   int sptyp = 0;
   int spart = 0;
   int sp = 0;
   int lsp = -1;
   int seq = 0;
   boolean setcur = false;
   boolean epart = false;
   boolean arrng = false;
   int esp = -1;
   int hi = -1;
   int arrcnt = 0;
   int chi = -1;
   boolean seqn = false;
   int rot = 0;
   int adrot = 0;
   Image[] su = new Image[2];
   Image[] sl = new Image[2];
   Image[] sd = new Image[2];
   Image[] sr = new Image[2];
   Image[] zi = new Image[2];
   Image[] zo = new Image[2];
   boolean pgen = false;
   float pwd = (float)(2L + Math.round(Math.random() * 4.0));
   float phd = (float)(2L + Math.round(Math.random() * 4.0));
   int fgen = 0;
   int sx = 0;
   int sz = 1500;
   int sy = -10000;
   TextField fixh = new TextField("2000", 5);
   int hf = 2000;
   int[][] atp = new int[][]{
      {0, 2800, 0, -2800},
      {0, 2800, 0, -2800},
      {1520, 2830, -1520, -2830},
      {-1520, 2830, 1520, -2830},
      {0, -1750, 1750, 0},
      {0, 2800, 0, -2800},
      {0, 2800, 0, -2800},
      {0, -1750, 1750, 0},
      {0, 2800, 0, -2800},
      {0, -1750, 1750, 0},
      {0, 2800, 0, -2800},
      {0, 2800, 0, -2800},
      {0, 560, 0, -560},
      {0, 0, 0, 0},
      {0, 0, 0, 0},
      {385, 980, 385, -980},
      {0, 0, 0, -600},
      {0, 0, 0, 0},
      {0, 2164, 0, -2164},
      {0, 2164, 0, -2164},
      {0, 3309, 0, -1680},
      {0, 1680, 0, -3309},
      {350, 0, -350, 0},
      {0, 0, 0, 0},
      {0, 0, 0, 0},
      {0, 0, 0, 0},
      {1810, 980, 1810, -980},
      {0, 0, 0, 0},
      {0, 500, 0, -500},
      {0, 0, 0, 0},
      {0, 0, 0, 0},
      {0, 0, 0, 0},
      {0, 0, 0, 0},
      {0, 2800, 0, -2800},
      {0, 2800, 0, -2800},
      {0, 1680, 0, -3309},
      {0, 2800, 0, -2800},
      {0, 2800, 0, -2800},
      {0, 2800, 0, -2800},
      {700, 1400, 700, -1400},
      {0, -1480, 0, -1480},
      {0, 0, 0, 0},
      {350, 0, -350, 0},
      {0, 0, 0, 0},
      {700, 0, -700, 0},
      {0, 0, 0, 0},
      {0, -2198, 0, 1482},
      {0, -1319, 0, 1391},
      {0, -1894, 0, 2271},
      {0, -826, 0, 839},
      {0, -1400, 0, 1400},
      {0, -1400, 0, 1400},
      {0, 0, 0, 0},
      {0, 0, 0, 0},
      {0, 0, 0, 0},
      {0, 0, 0, 0},
      {0, 0, 0, 0},
      {0, 0, 0, 0},
      {0, 0, 0, 0},
      {0, 0, 0, 0},
      {0, 0, 0, 0},
      {0, 0, 0, 0},
      {0, 0, 0, 0},
      {0, 0, 0, 0},
      {0, 0, 0, 0},
      {0, 0, 0, 0},
      {0, 0, 0, 0}
   };
   String[] discp = new String[]{
      "NormalRoad :  Basic asphalt road.\nAttaches correctly to the following other parts :\n\n'NormalRoad Turn',  'NormalRoad End',  'NormalRoad TwistedLeft',  'NormalRoad TwistedRight',  'NormalRoad Edged',\n'NormalRoad-Raised Ramp',  'Normal-Off-Road Blend'  and  'Halfpipe-Normal-Road Blend'\n\n",
      "NormalRoad Edged :  Asphalt road with edged side blocks (a destructive road).\nAttaches correctly to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad TwistedLeft',  'NormalRoad TwistedRight',\n'NormalRoad-Raised Ramp',  'Normal-Off-Road Blend'  and  'Halfpipe-Normal-Road Blend'\n\n",
      "NormalRoad TwistedRight :  Asphalt road twisted towards the right.\nAttaches correctly to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad Twistedleft',\n'NormalRoad-Raised Ramp',  'Normal-Off-Road Blend'  and  'Halfpipe-Normal-Road Blend'\n\n",
      "NormalRoad TwistedLeft :  Asphalt road twisted towards the left.\nAttaches correctly to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedRight',\n'NormalRoad-Raised Ramp',  'Normal-Off-Road Blend'  and  'Halfpipe-Normal-Road Blend'\n\n",
      "NormalRoad Turn :  Asphalt corner road turn.\nAttaches correctly to the following other parts :\n\n'NormalRoad',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft',  'NormalRoad TwistedRight',\n'NormalRoad-Raised Ramp', 'Normal-Off-Road Blend'  and  'Halfpipe-Normal-Road Blend'\n\n",
      "OffRoad :  Basic sandy dirt-road.\nAttaches correctly to the following other parts :\n\n'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',  'OffRoad-BumpySides Start',  'Off-Halfpipe-Road Blend'\nand  'Normal-Off-Road Blend'\n\n",
      "OffRoad BumpyGreen :  Dirt-road with bumpy greenery in the middle.\nAttaches correctly to the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad-BumpySides Start',  'Off-Halfpipe-Road Blend'\nand  'Normal-Off-Road Blend'\n\n",
      "OffRoad Turn :  Dirt-road corner turn.\nAttaches correctly to the following other parts :\n\n'OffRoad',  'OffRoad End',  'OffRoad BumpyGreen',  ' OffRoad-BumpySides Start',  'Off-Halfpipe-Road Blend'\nand 'Normal-Off-Road Blend'\n\n",
      "HalfpipeRoad :  Basic road for the half-pipe ramp.\nAttaches correctly to the following other parts :\n\n'Off-Halfpipe-Road Blend',  'HalfpipeRoad',  'HalfpipeRoad Turn',  'HalfpipeRoad-Ramp Filler'\nand  'Halfpipe-Normal-Road Blend'\n\n",
      "HalfpipeRoad Turn :  Half-pipe corner road turn.\nAttaches correctly to the following other parts :\n\n'HalfpipeRoad',  'Off-Halfpipe-Road Blend',  'HalfpipeRoad'  and  'Halfpipe-Normal-Road Blend'\n\n",
      "Normal-Off-Road Blend :  Road blend between the normal asphalt road and the dirt-road.\nAttaches correctly to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft',\n'NormalRoad TwistedRight',  'NormalRoad-Raised Ramp', 'Halfpipe-Normal-Road Blend' 'OffRoad',  'OffRoad Turn',\n'OffRoad End',  'OffRoad BumpyGreen',  ' OffRoad-BumpySides Start'  and  'Off-Halfpipe-Road Blend'\n\n",
      "Off-Halfpipe-Road Blend :  Road blend between the dirt-road and the half-pipe road.\nAttaches correctly to the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',  'OffRoad-BumpySides Start',\n'HalfpipeRoad',  'HalfpipeRoad Turn',  'Halfpipe-Normal-Road Blend'  and  'Normal-Off-Road Blend'\n\n",
      "Halfpipe-Normal-Road Blend :  Road blend between the normal asphalt road and the half-pipe road.\nAttaches correctly to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft',\n'NormalRoad TwistedRight',  'NormalRoad-Raised Ramp',  'HalfpipeRoad',  'Off-Halfpipe-Road Blend',  'HalfpipeRoad'\nand  'Off-Halfpipe-Road Blend'\n\n",
      "NormalRoad End :  The end part of the normal asphalt road.\nAttaches correctly to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad Edged',  'NormalRoad TwistedLeft',  'NormalRoad TwistedRight',\n'NormalRoad-Raised Ramp',  'Normal-Off-Road Blend'  and  'Halfpipe-Normal-Road Blend'\n\n",
      "OffRoad End :  The end part of the dirt-road.\nAttaches correctly to the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad BumpyGreen',  ' OffRoad-BumpySides Start',  'Off-Halfpipe-Road Blend'\nand  'Normal-Off-Road Blend'\n\n",
      "HalfpipeRoad-Ramp Filler :  A part that gets placed between the half-pipe road and the half-pipe ramp to extend the distance in between.\nAttaches correctly to the following other parts :\n\n'HalfpipeRoad'  and  'Halfpipe'\n\n",
      "Basic Ramp :  Basic 30 degree asphalt ramp.\nAttaches correctly over and to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand  'NormalRoad TwistedRight'\n\n",
      "Crash Ramp :  A 35 degree ramp with big side blocks for crashing into.\nAttaches correctly over and to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand  'NormalRoad TwistedRight'\n\n",
      "Two-Way Ramp :  Two way 15 degree inclined ramp.\nAttaches correctly over and to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand  'NormalRoad TwistedRight'\n\n",
      "Two-Way High-Low Ramp :  Two way 15 degree inclined ramp, with peeked side for an optional higher car jump.\nAttaches correctly over and to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand  'NormalRoad TwistedRight'\n\n",
      "Landing Ramp :  A ramp that is both a landing inclination and an obstacle as well, it is usually placed just after another normal ramp.\nAttaches correctly over and to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand   'NormalRoad TwistedRight'\n\n",
      "Big-Takeoff Ramp:  A big takeoff ramp for getting huge heights with the cars.\nAttaches correctly over and to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand   'NormalRoad TwistedRight'\n\n",
      "Small Ramp :  A small ramp that can be placed on either side of the road.\nAttaches correctly over and to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand   'NormalRoad TwistedRight'\n\n",
      "Offroad Bump Ramp :  A small bump ramp that is to be placed over the off-road dirt tracks.\nAttaches correctly over and to the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',  'OffRoad-BumpySides Start'\nand  'OffRoad-BumpySides'\n\n",
      "Offroad Big Ramp :  The big off-road dirt mountain like ramp!\nAttaches correctly over and to the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',  'OffRoad-BumpySides Start'\nand  'OffRoad-BumpySides'\n\n",
      "Offroad Ramp :  Normal sized off-road dirt track ramp!\nAttaches correctly over and to the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',  'OffRoad-BumpySides Start'\nand  'OffRoad-BumpySides'\n\n",
      "Halfpipe :  The Half-pipe ramp, two of these ramps opposite each other create a half-pipe for the cars!\nAttaches correctly over and to the following other parts :\n\n'HalfpipeRoad',  'HalfpipeRoad Turn'  and  'HalfpipeRoad-Ramp Filler'\n\n",
      "Spiky Pillars :  An obstacle that is usually placed after a ramp for the cars to crash onto if they did not jump high or far enough!\nAttaches correctly over following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand  'NormalRoad TwistedRight'\n\n",
      "Rail Doorway :  A rail doorway that works as an obstacle for cars flying above it or cars driving through it!\nAttaches correctly over following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand  'NormalRoad TwistedRight'\n\n",
      "The Wall",
      "Checkpoint :  The checkpoint part that ultimately decides how you stage is raced, place carefully with thought.\n(Any stage must have at least two checkpoints to work).\nMounts correctly over the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft',\n'NormalRoad TwistedRight',  'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',\n'OffRoad-BumpySides Start',  'OffRoad-BumpySides',  'Rollercoaster Start/End'  and  'Rollercoaster Road 2,3,4 and 5'\n\n",
      "Fixing Hoop :  The fixing hoop that fixes a car when it flies through it! You can add a max of 5 fixing hoops per stage.\nPlace it anywhere in the stage at an height your choose, the only important thing is that it needs to be reachable by the cars.",
      "Checkpoint :  The checkpoint part that ultimately decides how you stage is raced, place carefully with thought.\n(Any stage must have at least two checkpoints to work).\nMounts correctly over the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft',\n'NormalRoad TwistedRight',  'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',\n'OffRoad-BumpySides Start',  'OffRoad-BumpySides',  'Rollercoaster Start/End'  and  'Rollercoaster Road 2,3,4 and 5'\n\n",
      "OffRoad BumpySides :  Off-road dirt track with bumpy sandbar sides.\nAttaches correctly to the following other parts :\n\n'OffRoad-BumpySides Start'\n\n",
      "OffRoad-BumpySides Start: The start of the off-road dirt track with bumpy sandbar sides.\nAttaches correctly to the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',  'OffRoad-BumpySides',\n'Off-Halfpipe-Road Blend'  and  'Normal-Off-Road Blend'\n\n",
      "NormalRoad-Raised Ramp:  The start of the raised above the ground road (NormalRoad Raised).\nAttaches correctly to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft',\n'NormalRoad TwistedRight'  and  'NormalRoad Raised'\n\n",
      "NormalRoad Raised :  Normal road raised above the ground, cars must avoid falling off it when driving on it.\nAttaches correctly to the following other parts :\n\n'NormalRoad-Raised Ramp'\n\n",
      "The Start1",
      "The Start2",
      "Tunnel Side Ramp:  A ramp that can be used to create a tunnel like road with an open top or can be used as a wall ramp!\nAttaches correctly over only the 'NormalRoad' part.",
      "Launch Pad Ramp:  A ramp that launches your car fully upwards like a rocket, it also has sides to lock any car climbing it!\nAttaches correctly over following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad TwistedLeft'\nand  'NormalRoad TwistedRight'\n\n",
      "The Net:  An obstacle part that is to be placed in the center of the road right after a ramp, the idea is that the\ncars jumping the ramp should try to go over it or through it without getting caught crashing (without getting\ncaught in it, getting caught in the net!).\nAttaches correctly over following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand  'NormalRoad TwistedRight'\n\n",
      "Speed Ramp:  A ramp that is designed to have the perfect angle to catapult your car the furthest when doing forward loops, it is half the roads width.\nAttaches correctly over following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand  'NormalRoad TwistedRight'\n\n",
      "Offroad Hill Ramp:  An offroad hill ramp that has two different inclines from the front and back to jump.\nAttaches correctly over the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',  'OffRoad-BumpySides Start'\nand  'OffRoad-BumpySides'\n\n",
      "Bump Slide:  A small bump obstacle that is to be placed on the sides of the road or in the center.\nAttaches correctly over the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand  'NormalRoad TwistedRight'\n\n",
      "Offroad Big Hill Ramp:  An offroad big hill ramp that has two different inclines from the front and back to jump.\nAttaches correctly over the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',  'OffRoad-BumpySides Start'\nand  'OffRoad-BumpySides'\n\n",
      "Rollercoaster Start/End:  The ramp that starts the Rollercoaster Road and ends it.\nAttaches correctly over and to following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft',\n 'NormalRoad TwistedRight'  and  'Rollercoaster Start/End'\n\n",
      "Rollercoaster Road1\nAttaches correctly to only 'Rollercoaster Start/End', 'Rollercoaster Road2' and itself.\n\n",
      "Rollercoaster Road3\nAttaches correctly to only 'Rollercoaster Road2', 'Rollercoaster Road4' and itself.\n\n",
      "Rollercoaster Road4\nAttaches correctly to only 'Rollercoaster Road3', 'Rollercoaster Road5' and itself.\n\n",
      "Rollercoaster Road2\nAttaches correctly to only 'Rollercoaster Road1', 'Rollercoaster Road3' and itself.\n\n",
      "Rollercoaster Road5\nAttaches correctly to only 'Rollercoaster Road4' and itself.\n\n",
      "Offroad Dirt-Pile:  A dirt pile obstacle that is to be placed anywhere in the middle of the road.\nAttaches correctly over the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad-BumpySides Start'  and  'OffRoad-BumpySides'\n\n",
      "Offroad Dirt-Pile:  A dirt pile obstacle that is to be placed anywhere in the middle of the road.\nAttaches correctly over the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad-BumpySides Start'  and  'OffRoad-BumpySides'\n\n",
      "Checkpoint :  The checkpoint part that ultimately decides how you stage is raced, place carefully with thought.\n(Any stage must have at least two checkpoints to work).\nMounts correctly over the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft',\n'NormalRoad TwistedRight',  'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',\n'OffRoad-BumpySides Start',  'OffRoad-BumpySides',  'Rollercoaster Start/End'  and  'Rollercoaster Road 2,3,4 and 5'\n\n",
      "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n",
      "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n",
      "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n",
      "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n",
      "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n",
      "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n",
      "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n",
      "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n",
      "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n",
      "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n",
      "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n",
      "Ground Piles are to be paced outside the race track on the ground and NEVER on any road part or ramp!\nThey are to be used as ground decoration and out of race course obstacles (ground obstacles)!\n\n"
   };
   String[] errlo = new String[]{
      "The maximum allocated memory for the stage's part's details has been exerted.\nPlease decrease the amount of parts in the stage that have more details then average.",
      "The maximum amount of road points allowed in the track has been exceeded.\nPlease remove some of the road parts that are in the circler path of the track (the parts that are between the checkpoints).\nOr try to remove some of the extra checkpoints in the track as well.",
      "The maximum allowed area for a track (the area in between its walls) has been exceeded.\nPlease try to place parts only inside the current allowed area, inside the area between the current maximum wall placements.",
      "The maximum number of parts allowed per stage has been exceeded.\nPlease remove some of the already extra parts placed in order to make space.",
      "The maximum number of Fixing Hoops allowed per stage is 5!\nPlease remove the extra Fixing Hoops from your stage to have only 5 main ones left.",
      "Unknown Error, please make sure the stage you are handling is saved correctly.\nPlease go to the 'Build' tab and press 'Save & Preview'.",
      "There needs to be at least 2 checkpoints in the Stage in order for the game to work.\nPlease go to the 'Build' tab and select 'Checkpoint' in the Part Selection menu to add more checkpoints.",
      "The name of the stage is too long!\nPlease go to the 'Stage' tab, click 'Rename Stage' and give your stage a shorter name."
   };
   int[] rcheckp = new int[]{0, 1, 2, 3, 4, 12, 13, 37};
   int[] ocheckp = new int[]{5, 6, 7, 11, 14, 33, 34, 38};
   boolean onoff = false;
   boolean onfly = false;
   int flyh = 0;
   int[] csky = new int[]{170, 220, 255};
   int[] cgrnd = new int[]{205, 200, 200};
   int[] cfade = new int[]{255, 220, 220};
   int[] texture = new int[]{0, 0, 0, 10};
   int[] cldd = new int[]{210, 210, 210, 1, -1000};
   TextField mgen = new TextField("", 10);
   int vxz = 0;
   int vx = 0;
   int vz = 0;
   int vy = 0;
   int dtab = 0;
   int dtabed = -1;
   int mouseon = -1;
   float[][] hsb = new float[][]{{0.5F, 0.875F, 0.5F}, {0.5F, 0.875F, 0.5F}, {0.5F, 0.875F, 0.5F}};
   Checkbox pfog = new Checkbox("Linked Blend");
   int[] snap = new int[]{50, 50, 50};
   int[] fogn = new int[]{60, 0};
   Smenu nlaps = new Smenu(40);
   Smenu tracks = new Smenu(2000);
   String trackname = "";
   String ltrackname = "";
   int trackvol = 200;
   int tracksize = 111;
   RadicalMod track = new RadicalMod();
   int avon = 0;
   Smenu witho = new Smenu(40);
   int logged = 0;
   TextField tnick = new TextField("", 15);
   TextField tpass = new TextField("", 15);
   Smenu pubitem = new Smenu(707);
   Smenu pubtyp = new Smenu(40);
   int nms = 0;
   int roto = 0;
   String[] mystages = new String[20];
   String[] maker = new String[20];
   int[] pubt = new int[20];
   String[][] addeda = new String[20][5000];
   int[] nad = new int[20];
   String justpubd = "";
   boolean[] pessd = new boolean[]{
      false,
      false,
      false,
      false,
      false,
      false,
      false,
      false,
      false,
      false,
      false,
      false,
      false,
      false,
      false,
      false,
      false,
      false,
      false,
      false,
      false,
      false,
      false,
      false
   };
   int[] bx = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
   int[] by = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
   int[] bw = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
   int btn = 0;
   int mouses = 0;
   int xm = 0;
   int ym = 0;
   int lxm = 0;
   int lym = 0;
   int cntout = 0;
   boolean preop = false;
   boolean mousdr = false;
   String ttstage = "";

   private static final String smfpath = "/files/";

   @Override
   public void run() {
      this.thredo.setPriority(10);
      this.btgame[0] = this.getImage("" + Madness.fpath + "data/backtogame1.gif");
      this.btgame[1] = this.getImage("" + Madness.fpath + "data/backtogame2.gif");
      this.logo = this.getImage("" + Madness.fpath + "data/stagemakerlogo.gif");

      for (int var1 = 0; var1 < 2; var1++) {
         this.su[var1] = this.getImage("" + Madness.fpath + "data/su" + (var1 + 1) + ".gif");
         this.sl[var1] = this.getImage("" + Madness.fpath + "data/sl" + (var1 + 1) + ".gif");
         this.sd[var1] = this.getImage("" + Madness.fpath + "data/sd" + (var1 + 1) + ".gif");
         this.sr[var1] = this.getImage("" + Madness.fpath + "data/sr" + (var1 + 1) + ".gif");
         this.zi[var1] = this.getImage("" + Madness.fpath + "data/zi" + (var1 + 1) + ".gif");
         this.zo[var1] = this.getImage("" + Madness.fpath + "data/zo" + (var1 + 1) + ".gif");
      }

      this.loadbase();
      this.loadsettings();
      if (Madness.testdrive != 0) {
         if (!Madness.testcar.equals("Failx12")) {
            this.stagename = Madness.testcar;
            this.errd = 0;
            this.readstage(3);
            if (this.errd == 0) {
               this.tab = 2;
               this.dtab = 6;
               this.witho.select(Madness.testdrive - 3);
            }
         } else {
            JOptionPane.showMessageDialog(null, "Failed to load stage! Please make sure stage is saved properly before Test Drive.", "Stage Maker", 1);
            this.thredo.stop();
         }

         Madness.testcar = "";
         Madness.testdrive = 0;
      }

      this.requestFocus();

      while (!this.exwist) {
         this.rd.setColor(new Color(225, 225, 225));
         this.rd.fillRect(0, 25, 800, 525);
         this.rd.setColor(new Color(0, 0, 0));
         if (this.tab != this.tabed) {
            this.hidefields();
         }

         if (this.tab == 0) {
            if (this.tabed != this.tab) {
               this.slstage.removeAll();
               this.slstage.maxl = 360;
               this.slstage.add(this.rd, "Select a Stage                      ");
               String[] var39 = new File("" + smfpath + "mystages/").list();
               if (var39 != null) {
                  for (int var2 = 0; var2 < var39.length; var2++) {
                     if (var39[var2].toLowerCase().endsWith(".txt")) {
                        this.slstage.add(this.rd, var39[var2].substring(0, var39[var2].length() - 4));
                     }
                  }
               }

               if (!this.stagename.equals("")) {
                  this.slstage.select(this.stagename);
                  if (!this.stagename.equals(this.slstage.getSelectedItem())) {
                     this.stagename = "";
                     this.slstage.select(0);
                  } else {
                     this.readstage(3);
                     this.sx = 0;
                     this.sz = 1500;
                     this.sy = -10000;
                  }
               } else {
                  this.slstage.select(0);
               }

               this.mouseon = -1;
               this.sfase = 0;
            }

            this.rd.drawImage(this.logo, 261, 35, null);
            if (this.xm > 261 && this.xm < 538 && this.ym > 35 && this.ym < 121) {
               if (this.mouseon == -1) {
                  this.mouseon = 3;
                  this.setCursor(new Cursor(12));
               }
            } else if (this.mouseon == 3) {
               this.mouseon = -1;
               this.setCursor(new Cursor(0));
            }

            if (this.mouseon == 3 && this.mouses == -1) {
               this.openhlink();
            }

            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            if (this.xm > 200 && this.xm < 550 && this.ym > 467 && this.ym < 504) {
               if (this.mouseon == -1) {
                  this.mouseon = 2;
                  this.setCursor(new Cursor(12));
               }
            } else if (this.mouseon == 2) {
               this.mouseon = -1;
               this.setCursor(new Cursor(0));
            }

            if (this.mouseon != 2) {
               this.rd.setColor(new Color(0, 0, 0));
            } else {
               this.rd.setColor(new Color(0, 64, 128));
            }

            this.rd
               .drawString(
                  "For the Stage Maker Homepage, Development Center and Forums :",
                  400 - this.ftm.stringWidth("For the Stage Maker Homepage, Development Center and Forums :") / 2,
                  480
               );
            this.rd.setColor(new Color(0, 128, 255));
            String var40 = "http://www.needformadness.com/developer/";
            this.rd.drawString(var40, 400 - this.ftm.stringWidth(var40) / 2, 500);
            if (this.mouseon != 2) {
               this.rd.setColor(new Color(0, 64, 128));
            } else {
               this.rd.setColor(new Color(0, 128, 255));
            }

            this.rd.drawLine(400 - this.ftm.stringWidth(var40) / 2, 501, 400 + this.ftm.stringWidth(var40) / 2, 501);
            if (this.mouseon == 2 && this.mouses == -1) {
               this.openhlink();
            }

            byte var54 = -110;
            if (this.xm > 150 && this.xm < 600 && this.ym > 467 + var54 && this.ym < 504 + var54) {
               if (this.mouseon == -1) {
                  this.mouseon = 1;
                  this.setCursor(new Cursor(12));
               }
            } else if (this.mouseon == 1) {
               this.mouseon = -1;
               this.setCursor(new Cursor(0));
            }

            if (this.mouseon != 1) {
               this.rd.setColor(new Color(0, 0, 0));
            } else {
               this.rd.setColor(new Color(0, 64, 128));
            }

            this.rd
               .drawString(
                  "For help and a detailed step by step description on how to use the Stage Maker :",
                  400 - this.ftm.stringWidth("For help and a detailed step by step description on how to use the Stage Maker :") / 2,
                  480 + var54
               );
            this.rd.setColor(new Color(0, 128, 255));
            var40 = "http://www.needformadness.com/developer/help.html";
            this.rd.drawString(var40, 400 - this.ftm.stringWidth(var40) / 2, 500 + var54);
            if (this.mouseon != 1) {
               this.rd.setColor(new Color(0, 64, 128));
            } else {
               this.rd.setColor(new Color(0, 128, 255));
            }

            this.rd.drawLine(400 - this.ftm.stringWidth(var40) / 2, 501 + var54, 400 + this.ftm.stringWidth(var40) / 2, 501 + var54);
            if (this.mouseon == 1 && this.mouses == -1) {
               this.openlink();
            }

            byte var3 = -60;
            byte var4 = 70;
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawRect(227 - var4, 194 + var3, 346 + var4 * 2, 167 + var4 / 5);
            if (this.sfase == 0) {
               this.rd.drawString("Select Stage to Edit", 400 - this.ftm.stringWidth("Select Stage to Edit") / 2, 230 + var3);
               this.slstage.move(220, 240 + var3);
               if (this.slstage.getWidth() != 360) {
                  this.slstage.setSize(360, 21);
               }

               if (!this.slstage.isShowing()) {
                  this.slstage.show();
               }

               if (this.button("    Make new Stage    ", 400, 296 + var3, 0, true)) {
                  this.srch.setText("");
                  this.slstage.hide();
                  this.sfase = 1;
               }

               if (this.button("     Rename Stage     ", 325, 336 + var3, 0, false)) {
                  if (this.stagename.equals("")) {
                     JOptionPane.showMessageDialog(null, "Please select a stage to rename first.", "Stage Maker", 1);
                  } else {
                     this.slstage.hide();
                     this.srch.setText(this.stagename);
                     this.sfase = 2;
                  }
               }

               if (this.button("      Delete Stage      ", 475, 336 + var3, 0, false)) {
                  if (this.stagename.equals("")) {
                     JOptionPane.showMessageDialog(null, "Please select a stage to delete first.", "Stage Maker", 1);
                  } else if (JOptionPane.showConfirmDialog(
                        null, "Are you sure you want to permanently delete this stage?\n\n" + this.stagename + "\n\n", "Stage Maker", 0
                     )
                     == 0) {
                     this.delstage(this.stagename);
                  }
               }

               if (this.slstage.getSelectedIndex() == 0) {
                  this.stagename = "";
               } else if (!this.stagename.equals(this.slstage.getSelectedItem())) {
                  this.stagename = this.slstage.getSelectedItem();
                  this.readstage(3);
                  this.sx = 0;
                  this.sz = 1500;
                  this.sy = -10000;
                  this.requestFocus();
               }
            }

            if (this.sfase == 1) {
               this.rd.drawString("Make a new Stage", 400 - this.ftm.stringWidth("Make a new Stage") / 2, 220 + var3);
               this.rd.setFont(new Font("Arial", 1, 12));
               this.rd.drawString("New stage name :", 200, 246 + var3);
               this.movefield(this.srch, 310, 231 + var3, 290, 23);
               if (!this.srch.isShowing()) {
                  this.srch.show();
                  this.srch.requestFocus();
               }

               this.fixtext(this.srch);
               this.rd.drawString("Starting line type :", 293, 272 + var3);
               this.strtyp.move(408, 256 + var3);
               if (!this.strtyp.isShowing()) {
                  this.strtyp.show();
               }

               if (this.button("    Make Stage    ", 400, 311 + var3, 0, true)) {
                  this.newstage();
               }

               if (this.button("  Cancel  ", 400, 351 + var3, 0, false)) {
                  this.strtyp.hide();
                  this.srch.hide();
                  this.sfase = 0;
               }
            }

            if (this.sfase == 2) {
               this.rd
                  .drawString("Rename Stage :  " + this.stagename + "", 400 - this.ftm.stringWidth("Rename Stage :  " + this.stagename + "") / 2, 230 + var3);
               this.rd.setFont(new Font("Arial", 1, 12));
               this.rd.drawString("New name :", 218, 266 + var3);
               if (!this.srch.isShowing()) {
                  this.srch.show();
                  this.srch.requestFocus();
               }

               this.movefield(this.srch, 292, 251 + var3, 290, 23);
               this.fixtext(this.srch);
               if (this.button("    Rename Stage    ", 400, 306 + var3, 0, true)) {
                  this.renstage(this.srch.getText());
               }

               if (this.button("  Cancel  ", 400, 346 + var3, 0, false)) {
                  this.srch.hide();
                  this.sfase = 0;
               }
            }
         }

         if (this.tab == 1) {
            if (this.tabed != this.tab) {
               this.m.trk = 2;
               this.readstage(0);
               if (this.sptyp == 0) {
                  this.partroads();
               }

               if (this.sptyp == 1) {
                  this.partramps();
               }

               if (this.sptyp == 2) {
                  this.partobst();
               }

               if (this.sptyp == 5) {
                  this.partrees();
               }

               this.onoff = false;
               this.setCursor(new Cursor(0));
               this.setcur = false;
               this.epart = false;
               this.arrng = false;
               if (this.nob == 1) {
                  this.sptyp = 0;
                  if (this.co[0].colok != 38) {
                     this.spart = 0;
                  } else {
                     this.spart = 9;
                  }
               }

               this.mouseon = -1;
            }

            if (this.sptyp == 0) {
               if (this.spart == 0) {
                  this.sp = 0;
               }

               if (this.spart == 1) {
                  this.sp = 4;
               }

               if (this.spart == 2) {
                  this.sp = 13;
               }

               if (this.spart == 3) {
                  this.sp = 3;
               }

               if (this.spart == 4) {
                  this.sp = 2;
               }

               if (this.spart == 5) {
                  this.sp = 1;
               }

               if (this.spart == 6) {
                  this.sp = 35;
               }

               if (this.spart == 7) {
                  this.sp = 36;
               }

               if (this.spart == 8) {
                  this.sp = 10;
               }

               if (this.spart == 9) {
                  this.sp = 5;
               }

               if (this.spart == 10) {
                  this.sp = 7;
               }

               if (this.spart == 11) {
                  this.sp = 14;
               }

               if (this.spart == 12) {
                  this.sp = 6;
               }

               if (this.spart == 13) {
                  this.sp = 34;
               }

               if (this.spart == 14) {
                  this.sp = 33;
               }

               if (this.spart == 15) {
                  this.sp = 11;
               }

               if (this.spart == 16) {
                  this.sp = 8;
               }

               if (this.spart == 17) {
                  this.sp = 9;
               }

               if (this.spart == 18) {
                  this.sp = 15;
               }

               if (this.spart == 19) {
                  this.sp = 12;
               }

               if (this.spart == 20) {
                  this.sp = 46;
               }

               if (this.spart == 21) {
                  this.sp = 47;
               }

               if (this.spart == 22) {
                  this.sp = 50;
               }

               if (this.spart == 23) {
                  this.sp = 48;
               }

               if (this.spart == 24) {
                  this.sp = 49;
               }

               if (this.spart == 25) {
                  this.sp = 51;
               }
            }

            if (this.sptyp == 1) {
               if (this.spart == 0) {
                  this.sp = 16;
               }

               if (this.spart == 1) {
                  this.sp = 18;
               }

               if (this.spart == 2) {
                  this.sp = 19;
               }

               if (this.spart == 3) {
                  this.sp = 22;
               }

               if (this.spart == 4) {
                  this.sp = 17;
               }

               if (this.spart == 5) {
                  this.sp = 21;
               }

               if (this.spart == 6) {
                  this.sp = 20;
               }

               if (this.spart == 7) {
                  this.sp = 39;
               }

               if (this.spart == 8) {
                  this.sp = 42;
               }

               if (this.spart == 9) {
                  this.sp = 40;
               }

               if (this.spart == 10) {
                  this.sp = 23;
               }

               if (this.spart == 11) {
                  this.sp = 25;
               }

               if (this.spart == 12) {
                  this.sp = 24;
               }

               if (this.spart == 13) {
                  this.sp = 43;
               }

               if (this.spart == 14) {
                  this.sp = 45;
               }

               if (this.spart == 15) {
                  this.sp = 26;
               }
            }

            if (this.sptyp == 2) {
               if (this.spart == 0) {
                  this.sp = 27;
               }

               if (this.spart == 1) {
                  this.sp = 28;
               }

               if (this.spart == 2) {
                  this.sp = 41;
               }

               if (this.spart == 3) {
                  this.sp = 44;
               }

               if (this.spart == 4) {
                  this.sp = 52;
               }

               if (this.spart == 5) {
                  this.sp = 53;
               }
            }

            if (this.sptyp == 3) {
               if (!this.onfly) {
                  if (this.onoff) {
                     this.sp = 32;
                  } else {
                     this.sp = 30;
                  }
               } else {
                  this.sp = 54;
               }
            }

            if (this.sptyp == 4) {
               this.sp = 31;
            }

            if (this.sptyp == 5) {
               if (this.spart == 0) {
                  this.sp = 55;
               }

               if (this.spart == 1) {
                  this.sp = 56;
               }

               if (this.spart == 2) {
                  this.sp = 57;
               }

               if (this.spart == 3) {
                  this.sp = 58;
               }

               if (this.spart == 4) {
                  this.sp = 59;
               }

               if (this.spart == 5) {
                  this.sp = 60;
               }

               if (this.spart == 6) {
                  this.sp = 61;
               }

               if (this.spart == 7) {
                  this.sp = 62;
               }

               if (this.spart == 8) {
                  this.sp = 63;
               }

               if (this.spart == 9) {
                  this.sp = 64;
               }

               if (this.spart == 10) {
                  this.sp = 65;
               }
            }

            if (this.sptyp != 6) {
               if (this.pgen) {
                  this.pgen = false;
                  this.pwd = (float)(2L + Math.round(Math.random() * 4.0));
                  this.phd = (float)(2L + Math.round(Math.random() * 4.0));
               }
            } else {
               if (!this.pgen) {
                  int var42 = (int)(10000.0 * Math.random());
                  if (this.fgen != 0) {
                     var42 = this.fgen;
                     this.fgen = 0;
                  }

                  this.bco[66] = new ContO(var42, (int)this.pwd, (int)this.phd, this.m, this.t, 0, 0, 0);
                  this.bco[66].srz = var42;
                  this.bco[66].srx = (int)this.pwd;
                  this.bco[66].sry = (int)this.phd;
                  this.pgen = true;
                  this.seq = 3;
               }

               this.sp = 66;
               this.rot = 0;
            }

            if (this.sp == 30 || this.sp == 31 || this.sp == 32 || this.sp == 54) {
               if (this.rot == -90) {
                  this.rot = 90;
               }

               if (this.rot == 180) {
                  this.rot = 0;
               }
            }

            this.adrot = 0;
            if (this.sp == 2) {
               this.adrot = -30;
            }

            if (this.sp == 3) {
               this.adrot = 30;
            }

            if (this.sp == 15) {
               this.adrot = 90;
            }

            if (this.sp == 20) {
               this.adrot = 180;
            }

            if (this.sp == 26) {
               this.adrot = 90;
            }

            this.rd.setColor(new Color(200, 200, 200));
            this.rd.fillRect(248, 63, 514, 454);
            this.m.trk = 2;
            this.m.zy = 90;
            this.m.xz = 0;
            this.m.iw = 248;
            this.m.w = 762;
            this.m.ih = 63;
            this.m.h = 517;
            this.m.cx = 505;
            this.m.cy = 290;
            this.m.x = this.sx - this.m.cx;
            this.m.z = this.sz - this.m.cz;
            this.m.y = this.sy;
            int var43 = 0;
            int[] var55 = new int[200];

            for (int var69 = 0; var69 < this.nob; var69++) {
               if (this.co[var69].dist == 0) {
                  this.co[var69].d(this.rd);
               } else {
                  var55[var43] = var69;
                  var43++;
               }
            }

            int[] var70 = new int[var43];

            for (int var83 = 0; var83 < var43; var83++) {
               var70[var83] = 0;
            }

            for (int var84 = 0; var84 < var43; var84++) {
               for (int var5 = var84 + 1; var5 < var43; var5++) {
                  if (this.co[var55[var84]].dist == this.co[var55[var5]].dist) {
                     if (var5 <= var84) {
                        var70[var5]++;
                     } else {
                        var70[var84]++;
                     }
                  } else if (this.co[var55[var84]].dist >= this.co[var55[var5]].dist) {
                     var70[var5]++;
                  } else {
                     var70[var84]++;
                  }
               }
            }

            for (int var85 = 0; var85 < var43; var85++) {
               for (int var114 = 0; var114 < var43; var114++) {
                  if (var70[var114] == var85) {
                     if (var55[var114] == this.hi) {
                        this.m.trk = 3;
                     }

                     if (var55[var114] == this.chi && !this.co[var55[var114]].errd) {
                        int var6 = this.m.cx
                           + (int)(
                              (this.co[var55[var114]].x - this.m.x - this.m.cx) * this.m.cos(this.m.xz)
                                 - (this.co[var55[var114]].z - this.m.z - this.m.cz) * this.m.sin(this.m.xz)
                           );
                        int var7 = this.m.cz
                           + (int)(
                              (this.co[var55[var114]].x - this.m.x - this.m.cx) * this.m.sin(this.m.xz)
                                 + (this.co[var55[var114]].z - this.m.z - this.m.cz) * this.m.cos(this.m.xz)
                           );
                        int var8 = this.m.cy
                           + (int)((this.co[var55[var114]].y - this.m.y - this.m.cy) * this.m.cos(this.m.zy) - (var7 - this.m.cz) * this.m.sin(this.m.zy));
                        int var9 = this.m.cz
                           + (int)((this.co[var55[var114]].y - this.m.y - this.m.cy) * this.m.sin(this.m.zy) + (var7 - this.m.cz) * this.m.cos(this.m.zy));
                        int var10 = 1000000 / Math.abs(this.sy);
                        Graphics2D var11 = this.rd;
                        var11.setComposite(AlphaComposite.getInstance(3, 0.7F));
                        this.rd.setColor(new Color(0, 164, 255));
                        this.rd.fillOval(this.xs(var6, var9) - var10 / 2, this.ys(var8, var9) - var10 / 2, var10, var10);
                        var11.setComposite(AlphaComposite.getInstance(3, 1.0F));
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd
                           .drawString(
                              "NO# " + (this.arrcnt + 1) + "",
                              this.xs(var6, var9) - this.ftm.stringWidth("NO# " + (this.arrcnt + 1) + "") / 2,
                              this.ys(var8, var9) - var10 / 2
                           );
                     }

                     if (this.arrng
                        && (this.co[var55[var114]].colok == 30 || this.co[var55[var114]].colok == 32 || this.co[var55[var114]].colok == 54)
                        && this.co[var55[var114]].errd) {
                        int var136 = this.m.cx
                           + (int)(
                              (this.co[var55[var114]].x - this.m.x - this.m.cx) * this.m.cos(this.m.xz)
                                 - (this.co[var55[var114]].z - this.m.z - this.m.cz) * this.m.sin(this.m.xz)
                           );
                        int var153 = this.m.cz
                           + (int)(
                              (this.co[var55[var114]].x - this.m.x - this.m.cx) * this.m.sin(this.m.xz)
                                 + (this.co[var55[var114]].z - this.m.z - this.m.cz) * this.m.cos(this.m.xz)
                           );
                        int var181 = this.m.cy
                           + (int)((this.co[var55[var114]].y - this.m.y - this.m.cy) * this.m.cos(this.m.zy) - (var153 - this.m.cz) * this.m.sin(this.m.zy));
                        int var204 = this.m.cz
                           + (int)((this.co[var55[var114]].y - this.m.y - this.m.cy) * this.m.sin(this.m.zy) + (var153 - this.m.cz) * this.m.cos(this.m.zy));
                        int var231 = 1000000 / Math.abs(this.sy);
                        Graphics2D var246 = this.rd;
                        var246.setComposite(AlphaComposite.getInstance(3, 0.5F));
                        this.rd.setColor(new Color(255, 128, 0));
                        this.rd.fillOval(this.xs(var136, var204) - var231 / 2, this.ys(var181, var204) - var231 / 2, var231, var231);
                        var246.setComposite(AlphaComposite.getInstance(3, 1.0F));
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd
                           .drawString(
                              "NO# " + this.co[var55[var114]].wh + "",
                              this.xs(var136, var204) - this.ftm.stringWidth("NO# " + this.co[var55[var114]].wh + "") / 2,
                              this.ys(var181, var204) - var231 / 2
                           );
                     }

                     this.co[var55[var114]].d(this.rd);
                     if (this.m.trk == 3) {
                        this.m.trk = 2;
                     }
                  }
               }
            }

            if (this.xm > 248 && this.xm < 762 && this.ym > 63 && this.ym < 517) {
               if (!this.epart && !this.arrng) {
                  this.bco[this.sp].x = (this.xm - 505) * (Math.abs(this.sy) / this.m.focus_point) + this.sx;
                  this.bco[this.sp].z = (290 - this.ym) * (Math.abs(this.sy) / this.m.focus_point) + this.sz;
                  this.bco[this.sp].y = this.m.ground - this.bco[this.sp].grat;
                  this.bco[this.sp].xz = this.rot + this.adrot;
                  int var88 = 200;
                  int var117 = 0;
                  int var139 = 0;
                  int[] var156 = new int[]{this.bco[this.sp].x + this.atp[this.sp][0], this.bco[this.sp].x + this.atp[this.sp][2]};
                  int[] var184 = new int[]{this.bco[this.sp].z + this.atp[this.sp][1], this.bco[this.sp].z + this.atp[this.sp][3]};
                  this.rot(var156, var184, this.bco[this.sp].x, this.bco[this.sp].z, this.rot, 2);
                  int var207 = 0;
                  this.onfly = false;
                  int var232 = 500;

                  for (int var247 = 0; var247 < this.nob; var247++) {
                     int[] var12 = new int[]{this.co[var247].x + this.atp[this.co[var247].colok][0], this.co[var247].x + this.atp[this.co[var247].colok][2]};
                     int[] var13 = new int[]{this.co[var247].z + this.atp[this.co[var247].colok][1], this.co[var247].z + this.atp[this.co[var247].colok][3]};
                     int var14 = this.co[var247].roofat;
                     if (this.co[var247].colok == 2) {
                        var14 += 30;
                     }

                     if (this.co[var247].colok == 3) {
                        var14 -= 30;
                     }

                     if (this.co[var247].colok == 15) {
                        var14 -= 90;
                     }

                     if (this.co[var247].colok == 20) {
                        var14 -= 180;
                     }

                     if (this.co[var247].colok == 26) {
                        var14 -= 90;
                     }

                     this.rot(var12, var13, this.co[var247].x, this.co[var247].z, var14, 2);
                     if (this.sp <= 54) {
                        int var15 = this.py(var12[0], var156[0], var13[0], var184[0]);
                        if (var15 < var88 && var15 != 0) {
                           var88 = var15;
                           var117 = var12[0] - var156[0];
                           var139 = var13[0] - var184[0];
                        }

                        var15 = this.py(var12[1], var156[0], var13[1], var184[0]);
                        if (var15 < var88 && var15 != 0) {
                           var88 = var15;
                           var117 = var12[1] - var156[0];
                           var139 = var13[1] - var184[0];
                        }

                        var15 = this.py(var12[1], var156[1], var13[1], var184[1]);
                        if (var15 < var88 && var15 != 0) {
                           var88 = var15;
                           var117 = var12[1] - var156[1];
                           var139 = var13[1] - var184[1];
                        }

                        var15 = this.py(var12[0], var156[1], var13[0], var184[1]);
                        if (var15 < var88 && var15 != 0) {
                           var88 = var15;
                           var117 = var12[0] - var156[1];
                           var139 = var13[0] - var184[1];
                        }
                     }

                     if (this.sptyp == 3 && this.py(var12[0], var156[0], var13[0], var184[0]) != 0 && this.py(var12[1], var156[0], var13[1], var184[0]) != 0) {
                        for (int var295 = 0; var295 < this.rcheckp.length; var295++) {
                           if (this.co[var247].colok == this.rcheckp[var295]) {
                              if (this.py(var12[0], var156[0], var13[0], var184[0]) <= var207 || var207 == 0) {
                                 var207 = this.py(var12[0], var156[0], var13[0], var184[0]);
                                 this.onoff = false;
                              }

                              if (this.py(var12[1], var156[0], var13[1], var184[0]) <= var207) {
                                 var207 = this.py(var12[1], var156[0], var13[1], var184[0]);
                                 this.onoff = false;
                              }
                           }
                        }

                        for (int var296 = 0; var296 < this.ocheckp.length; var296++) {
                           if (this.co[var247].colok == this.ocheckp[var296]) {
                              if (this.py(var12[0], var156[0], var13[0], var184[0]) <= var207 || var207 == 0) {
                                 var207 = this.py(var12[0], var156[0], var13[0], var184[0]);
                                 this.onoff = true;
                              }

                              if (this.py(var12[1], var156[0], var13[1], var184[0]) <= var207) {
                                 var207 = this.py(var12[1], var156[0], var13[1], var184[0]);
                                 this.onoff = true;
                              }
                           }
                        }
                     }

                     if (this.sp > 12 && this.sp < 33 || this.sp == 35 || this.sp == 36 || this.sp >= 39 && this.sp <= 54) {
                        if ((this.rot == 0 || this.rot == 180 || this.sp == 26 || this.sp == 15)
                           && (var14 == 0 || var14 == 180 || this.sp == 26 || this.sp == 15)) {
                           if (Math.abs(var12[0] - var156[0]) < 200) {
                              var117 = var12[0] - var156[0];
                           }

                           if (Math.abs(var12[0] - var156[1]) < 200) {
                              var117 = var12[0] - var156[1];
                           }

                           if (Math.abs(var12[1] - var156[1]) < 200) {
                              var117 = var12[1] - var156[1];
                           }

                           if (Math.abs(var12[1] - var156[0]) < 200) {
                              var117 = var12[1] - var156[0];
                           }
                        }

                        if ((this.rot == 90 || this.rot == -90 || this.sp == 26 || this.sp == 15)
                           && (var14 == 90 || var14 == -90 || this.sp == 26 || this.sp == 15)) {
                           if (Math.abs(var13[0] - var184[0]) < 200) {
                              var139 = var13[0] - var184[0];
                           }

                           if (Math.abs(var13[0] - var184[1]) < 200) {
                              var139 = var13[0] - var184[1];
                           }

                           if (Math.abs(var13[1] - var184[1]) < 200) {
                              var139 = var13[1] - var184[1];
                           }

                           if (Math.abs(var13[1] - var184[0]) < 200) {
                              var139 = var13[1] - var184[0];
                           }
                        }
                     }

                     if (this.sptyp == 3 && this.co[var247].colok >= 46 && this.co[var247].colok <= 51) {
                        int[] var297 = new int[]{2, 3, 5, 2, 3, 3};
                        if ((Math.abs(this.co[var247].roofat) == 180 || this.co[var247].roofat == 0)
                           && this.rot == 0
                           && Math.abs(this.bco[this.sp].x - this.co[var247].x) < 500
                           && Math.abs(this.bco[this.sp].z - this.co[var247].z) < 3000) {
                           for (int var16 = 0; var16 < var297[this.co[var247].colok - 46]; var16++) {
                              for (int var17 = 0; var17 < this.co[var247].p[var16].n; var17++) {
                                 if (this.py(
                                       this.bco[this.sp].x, this.co[var247].x, this.bco[this.sp].z, this.co[var247].z + this.co[var247].p[var16].oz[var17]
                                    )
                                    < var232) {
                                    var232 = this.py(
                                       this.bco[this.sp].x, this.co[var247].x, this.bco[this.sp].z, this.co[var247].z + this.co[var247].p[var16].oz[var17]
                                    );
                                    this.flyh = this.co[var247].p[var16].oy[var17] - 28 + this.m.ground;
                                    var117 = this.co[var247].x - this.bco[this.sp].x;
                                    var139 = this.co[var247].z + this.co[var247].p[var16].oz[var17] - this.bco[this.sp].z;
                                    this.onfly = true;
                                 }
                              }
                           }
                        }

                        if (Math.abs(this.co[var247].roofat) == 90
                           && this.rot == 90
                           && Math.abs(this.bco[this.sp].z - this.co[var247].z) < 500
                           && Math.abs(this.bco[this.sp].x - this.co[var247].x) < 3000) {
                           for (int var302 = 0; var302 < var297[this.co[var247].colok - 46]; var302++) {
                              for (int var307 = 0; var307 < this.co[var247].p[var302].n; var307++) {
                                 if (this.py(
                                       this.bco[this.sp].z, this.co[var247].z, this.bco[this.sp].x, this.co[var247].x + this.co[var247].p[var302].ox[var307]
                                    )
                                    < var232) {
                                    var232 = this.py(
                                       this.bco[this.sp].z, this.co[var247].z, this.bco[this.sp].x, this.co[var247].x + this.co[var247].p[var302].ox[var307]
                                    );
                                    this.flyh = this.co[var247].p[var302].oy[var307] - 28 + this.m.ground;
                                    var139 = this.co[var247].z - this.bco[this.sp].z;
                                    var117 = this.co[var247].x + this.co[var247].p[var302].ox[var307] - this.bco[this.sp].x;
                                    this.onfly = true;
                                 }
                              }
                           }
                        }
                     }
                  }

                  this.bco[this.sp].x += var117;
                  this.bco[this.sp].z += var139;
                  int var248 = this.bco[this.sp].xy;
                  int var265 = this.bco[this.sp].zy;
                  if (this.sp != 31) {
                     this.bco[this.sp].xy = 0;
                  } else {
                     this.bco[this.sp].y = -this.hf;
                     if (this.bco[this.sp].y > -500) {
                        this.bco[this.sp].y = -500;
                     }
                  }

                  if (this.sp == 54) {
                     this.bco[this.sp].y = this.flyh;
                  }

                  this.bco[this.sp].zy = 0;
                  if (this.cntout != 0) {
                     if (this.lxm != this.bco[this.sp].x && this.lxm != this.bco[this.sp].z) {
                        this.cntout--;
                     }

                     if (this.setcur) {
                        this.setCursor(new Cursor(0));
                        this.setcur = false;
                     }
                  } else if (this.mouseon == -1) {
                     this.bco[this.sp].d(this.rd);
                     if (!this.setcur) {
                        this.setCursor(new Cursor(13));
                        this.setcur = true;
                     }

                     if (this.mouses == -1) {
                        if (this.nundo < 5000) {
                           this.undos[this.nundo] = this.bstage;
                           this.nundo++;
                        }

                        if (this.bco[this.sp].xz == 270) {
                           this.bco[this.sp].xz = -90;
                        }

                        if (this.bco[this.sp].xz == 360) {
                           this.bco[this.sp].xz = 0;
                        }

                        this.errd = 0;
                        boolean var276 = false;
                        if (this.xnob >= 601) {
                           this.errd = 4;
                        } else {
                           if (this.sp != 31 && this.sp != 54 && this.sp != 66) {
                              try {
                                 this.co[this.nob] = new ContO(
                                    this.bco[this.sp], this.bco[this.sp].x, this.m.ground - this.bco[this.sp].grat, this.bco[this.sp].z, this.bco[this.sp].xz
                                 );
                                 this.co[this.nob].roofat = this.bco[this.sp].xz;
                                 this.co[this.nob].colok = this.sp;
                                 this.nob++;
                              } catch (Exception var33) {
                                 this.errd = 1;
                              }
                           }

                           if (this.sp == 31) {
                              if (this.cp.fn >= 5) {
                                 this.errd = 5;
                              } else {
                                 this.co[this.nob] = new ContO(
                                    this.bco[this.sp], this.bco[this.sp].x, this.bco[this.sp].y, this.bco[this.sp].z, this.bco[this.sp].xz
                                 );
                                 this.co[this.nob].roofat = this.bco[this.sp].xz;
                                 this.co[this.nob].colok = this.sp;
                                 this.nob++;
                                 this.fixh.setText("" + Math.abs(this.bco[this.sp].y) + "");
                              }
                           }

                           if (this.sp == 54) {
                              try {
                                 this.co[this.nob] = new ContO(
                                    this.bco[this.sp], this.bco[this.sp].x, this.bco[this.sp].y, this.bco[this.sp].z, this.bco[this.sp].xz
                                 );
                                 this.co[this.nob].roofat = this.bco[this.sp].xz;
                                 this.co[this.nob].colok = this.sp;
                                 this.nob++;
                              } catch (Exception var32) {
                                 this.errd = 1;
                              }
                           }

                           if (this.sp == 66) {
                              this.co[this.nob] = new ContO(
                                 this.bco[66].srz, this.bco[66].srx, this.bco[66].sry, this.m, this.t, this.bco[66].x, this.bco[66].z, this.bco[this.sp].y
                              );
                              this.co[this.nob].srz = this.bco[66].srz;
                              this.co[this.nob].srx = this.bco[66].srx;
                              this.co[this.nob].sry = this.bco[66].sry;
                              this.co[this.nob].colok = this.sp;
                              this.nob++;
                           }
                        }

                        if (this.errd == 0) {
                           this.sortstage();
                           this.readstage(0);
                           var276 = true;
                           if (this.sp == 66) {
                              this.pgen = false;
                           }

                           if (this.sp == 52 || this.sp == 53 || this.sp >= 55 && this.sp <= 65) {
                              this.seq = 3;
                              this.bco[this.sp].xy = 0;
                              this.bco[this.sp].zy = 0;
                              boolean var284 = false;
                              if (this.rot == 0 && !var284) {
                                 this.rot = 90;
                                 var284 = true;
                              }

                              if (this.rot == 90 && !var284) {
                                 this.rot = 180;
                                 var284 = true;
                              }

                              if (this.rot == 180 && !var284) {
                                 this.rot = -90;
                                 var284 = true;
                              }

                              if (this.rot == -90 && !var284) {
                                 this.rot = 0;
                                 var284 = true;
                              }
                           }
                        }

                        if (this.errd != 0) {
                           JOptionPane.showMessageDialog(
                              null, "Error!  Unable to place part!\nReason:\n" + this.errlo[this.errd - 1] + "\n\n", "Stage Maker", 0
                           );
                           if (var276) {
                              this.nundo--;
                              this.bstage = this.undos[this.nundo];
                              this.readstage(0);
                           }
                        }

                        this.lxm = this.bco[this.sp].x;
                        this.lym = this.bco[this.sp].z;
                        this.cntout = 10;
                     }
                  }

                  this.bco[this.sp].xy = var248;
                  this.bco[this.sp].zy = var265;
               } else {
                  if (this.epart) {
                     if (this.esp == -1 && !this.overcan) {
                        this.hi = -1;
                        int var86 = 0;

                        for (int var115 = 0; var115 < this.nob; var115++) {
                           int var137 = this.m.cx
                              + (int)(
                                 (this.co[var115].x - this.m.x - this.m.cx) * this.m.cos(this.m.xz)
                                    - (this.co[var115].z - this.m.z - this.m.cz) * this.m.sin(this.m.xz)
                              );
                           int var154 = this.m.cz
                              + (int)(
                                 (this.co[var115].x - this.m.x - this.m.cx) * this.m.sin(this.m.xz)
                                    + (this.co[var115].z - this.m.z - this.m.cz) * this.m.cos(this.m.xz)
                              );
                           int var182 = this.m.cy
                              + (int)((this.co[var115].y - this.m.y - this.m.cy) * this.m.cos(this.m.zy) - (var154 - this.m.cz) * this.m.sin(this.m.zy));
                           int var205 = this.m.cz
                              + (int)((this.co[var115].y - this.m.y - this.m.cy) * this.m.sin(this.m.zy) + (var154 - this.m.cz) * this.m.cos(this.m.zy));
                           if (this.xm > this.xs(var137 - this.co[var115].maxR, var205)
                              && this.xm < this.xs(var137 + this.co[var115].maxR, var205)
                              && this.ym > this.ys(var182 - this.co[var115].maxR, var205)
                              && this.ym < this.ys(var182 + this.co[var115].maxR, var205)
                              && this.co[var115].colok != 37
                              && this.co[var115].colok != 38) {
                              if (this.hi != -1) {
                                 if (this.py(this.xm, this.xs(var137, var205), this.ym, this.ys(var182, var205)) <= var86) {
                                    this.hi = var115;
                                    var86 = this.py(this.xm, this.xs(var137, var205), this.ym, this.ys(var182, var205));
                                 }
                              } else {
                                 this.hi = var115;
                                 var86 = this.py(this.xm, this.xs(var137, var205), this.ym, this.ys(var182, var205));
                              }
                           }
                        }

                        if (this.hi == -1) {
                           if (this.setcur) {
                              this.setCursor(new Cursor(0));
                              this.setcur = false;
                           }
                        } else {
                           if (!this.setcur) {
                              this.setCursor(new Cursor(13));
                              this.setcur = true;
                           }

                           if (this.mouses == -1) {
                              this.esp = this.hi;
                              this.mouses = 0;
                           }
                        }
                     } else if (this.setcur) {
                        this.setCursor(new Cursor(0));
                        this.setcur = false;
                     }
                  }

                  if (this.arrng) {
                     this.chi = -1;
                     int var87 = 5000;

                     for (int var116 = 0; var116 < this.nob; var116++) {
                        if ((this.co[var116].colok == 30 || this.co[var116].colok == 32 || this.co[var116].colok == 54) && !this.co[var116].errd) {
                           int var138 = this.m.cx
                              + (int)(
                                 (this.co[var116].x - this.m.x - this.m.cx) * this.m.cos(this.m.xz)
                                    - (this.co[var116].z - this.m.z - this.m.cz) * this.m.sin(this.m.xz)
                              );
                           int var155 = this.m.cz
                              + (int)(
                                 (this.co[var116].x - this.m.x - this.m.cx) * this.m.sin(this.m.xz)
                                    + (this.co[var116].z - this.m.z - this.m.cz) * this.m.cos(this.m.xz)
                              );
                           int var183 = this.m.cy
                              + (int)((this.co[var116].y - this.m.y - this.m.cy) * this.m.cos(this.m.zy) - (var155 - this.m.cz) * this.m.sin(this.m.zy));
                           int var206 = this.m.cz
                              + (int)((this.co[var116].y - this.m.y - this.m.cy) * this.m.sin(this.m.zy) + (var155 - this.m.cz) * this.m.cos(this.m.zy));
                           if (this.xm > this.xs(var138 - this.co[var116].maxR, var206)
                              && this.xm < this.xs(var138 + this.co[var116].maxR, var206)
                              && this.ym > this.ys(var183 - this.co[var116].maxR, var206)
                              && this.ym < this.ys(var183 + this.co[var116].maxR, var206)
                              && this.py(this.xm, this.xs(var138, var206), this.ym, this.ys(var183, var206)) <= var87) {
                              this.chi = var116;
                              var87 = this.py(this.xm, this.xs(var138, var206), this.ym, this.ys(var183, var206));
                           }
                        }
                     }

                     if (this.chi == -1) {
                        if (this.setcur) {
                           this.setCursor(new Cursor(0));
                           this.setcur = false;
                        }
                     } else {
                        if (!this.setcur) {
                           this.setCursor(new Cursor(13));
                           this.setcur = true;
                        }

                        if (this.mouses == -1) {
                           this.arrcnt++;
                           this.co[this.chi].wh = this.arrcnt;
                           this.co[this.chi].errd = true;
                           this.mouses = 0;
                        }
                     }
                  }
               }
            } else if (this.setcur) {
               this.setCursor(new Cursor(0));
               this.setcur = false;
            }

            if (this.epart && this.esp != -1) {
               if (this.co[this.esp].dist == 0) {
                  this.esp = -1;
               } else {
                  this.m.cx = 505;
                  this.m.cy = 290;
                  this.m.x = this.sx - this.m.cx;
                  this.m.z = this.sz - this.m.cz;
                  this.m.y = this.sy;
                  int var89 = this.m.cx
                     + (int)(
                        (this.co[this.esp].x - this.m.x - this.m.cx) * this.m.cos(this.m.xz)
                           - (this.co[this.esp].z - this.m.z - this.m.cz) * this.m.sin(this.m.xz)
                     );
                  int var118 = this.m.cz
                     + (int)(
                        (this.co[this.esp].x - this.m.x - this.m.cx) * this.m.sin(this.m.xz)
                           + (this.co[this.esp].z - this.m.z - this.m.cz) * this.m.cos(this.m.xz)
                     );
                  int var140 = this.m.cy
                     + (int)((this.co[this.esp].y - this.m.y - this.m.cy) * this.m.cos(this.m.zy) - (var118 - this.m.cz) * this.m.sin(this.m.zy));
                  int var157 = this.m.cz
                     + (int)((this.co[this.esp].y - this.m.y - this.m.cy) * this.m.sin(this.m.zy) + (var118 - this.m.cz) * this.m.cos(this.m.zy));
                  int var185 = this.xs(var89, var157);
                  int var208 = this.ys(var140, var157);
                  this.rd.setColor(new Color(225, 225, 225));
                  this.rd.fillRect(var185, var208, 90, 88);
                  this.rd.setColor(new Color(138, 147, 160));
                  this.rd.drawRect(var185, var208, 90, 88);
                  if (this.button("   Edit   ", var185 + 45, var208 + 22, 3, false)) {
                     this.copyesp(true);
                     this.removesp();
                     this.lxm = 0;
                     this.lym = 0;
                     this.cntout = 2;
                     this.epart = false;
                  }

                  if (this.button(" Remove ", var185 + 45, var208 + 49, 3, false)) {
                     this.removesp();
                     this.esp = -1;
                     this.mouses = 0;
                  }

                  if (this.button("  Copy  ", var185 + 45, var208 + 76, 3, false)) {
                     this.copyesp(false);
                     this.lxm = 0;
                     this.lym = 0;
                     this.cntout = 2;
                     this.epart = false;
                  }

                  this.rd.setColor(new Color(255, 0, 0));
                  this.rd.drawString("x", var185 + 82, var208 - 2);
                  if (this.xm > 248
                     && this.xm < 762
                     && this.ym > 63
                     && this.ym < 517
                     && this.mouses == 1
                     && (this.xm < var185 || this.xm > var185 + 90 || this.ym < var208 || this.ym > var208 + 88)) {
                     this.esp = -1;
                     this.mouses = 0;
                  }
               }
            }

            this.rd.setColor(new Color(225, 225, 225));
            this.rd.fillRect(248, 25, 514, 38);
            this.rd.fillRect(0, 25, 248, 530);
            this.rd.fillRect(248, 517, 514, 38);
            this.rd.fillRect(762, 25, 38, 530);
            if (this.sptyp == 6) {
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.setFont(new Font("Arial", 1, 12));
               this.rd.drawString("Radius:", 11, 97);
               this.rd.drawString("Height:", 14, 117);
               boolean var90 = false;
               if (this.xm > 57 && this.xm < 204 && this.ym > 90 && this.ym < 99) {
                  var90 = true;
               }

               this.rd.setColor(new Color(136, 148, 170));
               if (var90 || this.mouseon == 1) {
                  this.rd.drawRect(57, 90, 147, 8);
                  this.rd.setColor(new Color(0, 0, 0));
               }

               this.rd.drawLine(57, 94, 204, 94);
               if (this.mouseon == 1) {
                  this.pwd = (this.xm - 57) / 36.75F + 2.0F;
                  if (this.pwd < 2.0F) {
                     this.pwd = 2.0F;
                  }

                  if (this.pwd > 6.0F) {
                     this.pwd = 6.0F;
                  }
               }

               this.rd.drawRect((int)(57.0F + (this.pwd - 2.0F) * 36.75F), 90, 2, 8);
               boolean var119 = false;
               if (this.xm > 57 && this.xm < 204 && this.ym > 110 && this.ym < 119) {
                  var119 = true;
               }

               this.rd.setColor(new Color(136, 148, 170));
               if (var119 || this.mouseon == 2) {
                  this.rd.drawRect(57, 110, 147, 8);
                  this.rd.setColor(new Color(0, 0, 0));
               }

               this.rd.drawLine(57, 114, 204, 114);
               if (this.mouseon == 2) {
                  this.phd = (this.xm - 57) / 36.75F + 2.0F;
                  if (this.phd < 2.0F) {
                     this.phd = 2.0F;
                  }

                  if (this.phd > 6.0F) {
                     this.phd = 6.0F;
                  }
               }

               this.rd.drawRect((int)(57.0F + (this.phd - 2.0F) * 36.75F), 110, 2, 8);
               if (this.mouses != 1) {
                  if (this.mouseon == 1 || this.mouseon == 2) {
                     this.pgen = false;
                  }

                  this.mouseon = -1;
               } else {
                  if (var90) {
                     this.mouseon = 1;
                  }

                  if (var119) {
                     this.mouseon = 2;
                  }
               }
            }

            byte var91 = 0;
            if (this.xm > 482 && this.xm < 529 && this.ym > 35 && this.ym < 61 || this.up) {
               var91 = 1;
               if (this.mouses == 1 || this.up) {
                  this.sz += 500;
               }
            }

            this.rd.drawImage(this.su[var91], 482, 35, null);
            var91 = 0;
            if (this.xm > 482 && this.xm < 529 && this.ym > 519 && this.ym < 545 || this.down) {
               var91 = 1;
               if (this.mouses == 1 || this.down) {
                  this.sz -= 500;
               }
            }

            this.rd.drawImage(this.sd[var91], 482, 519, null);
            var91 = 0;
            if (this.xm > 220 && this.xm < 246 && this.ym > 264 && this.ym < 311 || this.left) {
               var91 = 1;
               if (this.mouses == 1 || this.left) {
                  this.sx -= 500;
               }
            }

            this.rd.drawImage(this.sl[var91], 220, 264, null);
            var91 = 0;
            if (this.xm > 764 && this.xm < 790 && this.ym > 264 && this.ym < 311 || this.right) {
               var91 = 1;
               if (this.mouses == 1 || this.right) {
                  this.sx += 500;
               }
            }

            this.rd.drawImage(this.sr[var91], 764, 264, null);
            var91 = 0;
            if (this.xm > 616 && this.xm < 677 && this.ym > 30 && this.ym < 61 || this.zoomi) {
               var91 = 1;
               if (this.mouses == 1 || this.zoomi) {
                  this.sy += 500;
                  if (this.sy > -2500) {
                     this.sy = -2500;
                  }
               }
            }

            this.rd.drawImage(this.zi[var91], 616, 30, null);
            var91 = 0;
            if (this.xm > 690 && this.xm < 751 && this.ym > 30 && this.ym < 61 || this.zoomo) {
               var91 = 1;
               if (this.mouses == 1 || this.zoomo) {
                  this.sy -= 500;
                  if (this.sy < -55000) {
                     this.sy = -55000;
                  }
               }
            }

            this.rd.drawImage(this.zo[var91], 690, 30, null);
            if ((this.epart || this.arrng) && this.sy < -36000) {
               this.sy = -36000;
            }

            this.rd.setFont(new Font("Arial", 1, 11));
            this.ftm = this.rd.getFontMetrics();
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawString("Part Selection", 11, 47);
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            this.ptyp.move(10, 50);
            if (!this.ptyp.isShowing()) {
               this.ptyp.show();
               this.ptyp.select(this.sptyp);
            }

            if (this.sptyp != this.ptyp.getSelectedIndex()) {
               this.sptyp = this.ptyp.getSelectedIndex();
               if (this.sptyp == 0) {
                  this.partroads();
                  this.part.show();
               }

               if (this.sptyp == 1) {
                  this.partramps();
                  this.part.show();
               }

               if (this.sptyp == 2) {
                  this.partobst();
                  this.part.show();
               }

               if (this.sptyp == 5) {
                  this.partrees();
                  this.part.show();
               }

               this.spart = 0;
               this.part.select(this.spart);
               this.requestFocus();
               this.fixh.setText("2000");
               this.focuson = false;
            }

            this.part.move(10, 80);
            this.part.setSize(200, 21);
            if (this.sptyp != 0 && this.sptyp != 1 && this.sptyp != 2 && this.sptyp != 5) {
               if (this.part.isShowing()) {
                  this.part.hide();
               }
            } else if (!this.part.isShowing()) {
               this.part.show();
               this.part.select(this.spart);
            }

            if (this.spart != this.part.getSelectedIndex()) {
               this.spart = this.part.getSelectedIndex();
               this.focuson = false;
            }

            if (this.sptyp == 3) {
               this.rd.drawString("Checkpoint", 110 - this.ftm.stringWidth("Checkpoint") / 2, 120);
            }

            if (this.sptyp == 4) {
               this.rd.drawString("Fixing Hoop", 110 - this.ftm.stringWidth("Fixing Hoop") / 2, 120);
            }

            if (this.lsp != this.sp) {
               this.seq = 3;
               this.bco[this.sp].xy = 0;
               this.bco[this.sp].zy = 0;
               this.lsp = this.sp;
               this.epart = false;
               this.arrng = false;
            }

            if (this.xm > 10 && this.xm < 210 && this.ym > 130 && this.ym < 334) {
               if (this.seq >= 3) {
                  if (this.seq != 20 && this.seqn) {
                     this.seq++;
                  } else {
                     this.seq = 0;
                     this.bco[this.sp].xy = 0;
                     this.bco[this.sp].zy = 0;
                  }
               }

               this.seqn = true;
               this.rd.setColor(new Color(210, 210, 210));
            } else {
               this.rd.setColor(new Color(200, 200, 200));
               this.seqn = false;
            }

            this.rd.fillRect(10, 130, 200, 200);
            if ((this.sp == 30 || this.sp == 32 || this.sp == 54) && this.button("  Rearrange Checkpoints  >  ", 110, 315, 2, true)) {
               this.mouses = 0;
               this.epart = false;
               if (this.arrng) {
                  this.arrng = false;
               } else {
                  this.arrcnt = 0;

                  for (int var120 = 0; var120 < this.nob; var120++) {
                     if (this.co[var120].colok == 30 || this.co[var120].colok == 32 || this.co[var120].colok == 54) {
                        this.co[var120].errd = false;
                     }
                  }

                  this.arrng = true;
               }
            }

            if (this.seqn && this.mouses == -1) {
               if (this.sp == 66) {
                  this.pgen = false;
                  this.pwd = (float)(2L + Math.round(Math.random() * 4.0));
                  this.phd = (float)(2L + Math.round(Math.random() * 4.0));
               } else {
                  boolean var121 = false;
                  if (this.rot == 0 && !var121) {
                     this.rot = 90;
                     var121 = true;
                  }

                  if (this.rot == 90 && !var121) {
                     this.rot = 180;
                     var121 = true;
                  }

                  if (this.rot == 180 && !var121) {
                     this.rot = -90;
                     var121 = true;
                  }

                  if (this.rot == -90 && !var121) {
                     this.rot = 0;
                     var121 = true;
                  }

                  if (this.sp == 30 || this.sp == 31 || this.sp == 32) {
                     if (this.rot == -90) {
                        this.rot = 90;
                     }

                     if (this.rot == 180) {
                        this.rot = 0;
                     }
                  }

                  this.seq = 5;
                  this.bco[this.sp].xy = 0;
                  this.bco[this.sp].zy = 0;
                  this.epart = false;
                  this.arrng = false;
               }
            }

            if (this.sp != 31) {
               if (this.fixh.isShowing()) {
                  this.fixh.hide();
               }
            } else {
               this.rd.setFont(new Font("Arial", 1, 12));
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawString("Height:", 62, 280);
               this.movefield(this.fixh, 107, 266, 50, 20);
               if (this.fixh.hasFocus()) {
                  this.focuson = false;
               }

               if (!this.fixh.isShowing()) {
                  this.fixh.show();
               }

               this.rd.setFont(new Font("Arial", 0, 11));
               this.ftm = this.rd.getFontMetrics();
               this.rd.drawString("( Height off the ground... )", 110 - this.ftm.stringWidth("( Height off the ground... )") / 2, 300);
               if (this.fixh.getText().equals("")) {
                  this.fixh.setText("0");
                  this.fixh.select(0, 0);
               }

               try {
                  this.hf = Integer.valueOf(this.fixh.getText());
                  if (this.hf > 8000) {
                     this.hf = 8000;
                     this.fixh.setText("8000");
                  }
               } catch (Exception var31) {
                  this.hf = 2000;
                  this.fixh.setText("2000");
               }
            }

            this.m.trk = 2;
            this.m.zy = 90;
            this.m.xz = 0;
            this.m.iw = 10;
            this.m.w = 210;
            this.m.ih = 130;
            this.m.h = 330;
            this.m.cx = 110;
            this.m.cy = 230;
            this.m.x = -110;
            this.m.z = -230;
            this.m.y = -15000;
            if (this.sptyp == 1 && this.sp != 20 && this.sp != 21 && this.sp != 43 && this.sp != 45) {
               this.m.y = -10000;
            }

            if (this.sptyp == 2 && this.sp != 41) {
               this.m.y = -7600;
            }

            if (this.sptyp == 3 || this.sptyp == 4) {
               this.m.y = -5000;
            }

            if (this.sptyp == 5) {
               this.m.y = -3000;
               this.m.z = 150;
            }

            if (this.sptyp == 6) {
               this.m.y = -7600;
            }

            if (this.sp == 31) {
               this.m.z = -500;
               if (this.rot == 0) {
                  this.bco[this.sp].roted = false;
               } else {
                  this.bco[this.sp].roted = true;
               }
            }

            this.bco[this.sp].x = 0;
            this.bco[this.sp].y = 0;
            this.bco[this.sp].z = 0;
            this.bco[this.sp].xz = this.rot + this.adrot;
            this.bco[this.sp].d(this.rd);
            byte var123 = 1;
            if (this.sptyp == 0 || this.sptyp == 1) {
               if (this.sp != 26 && this.sp != 20) {
                  if (this.rot == -90 || this.rot == 0) {
                     var123 = -1;
                  }
               } else {
                  if (this.sp == 26 && (this.rot == -90 || this.rot == 180)) {
                     var123 = -1;
                  }

                  if (this.sp == 20 && (this.rot == 90 || this.rot == 180)) {
                     var123 = -1;
                  }
               }

               if (this.seq == 2) {
                  this.bco[this.sp].xy -= 5 * var123;
                  if (this.bco[this.sp].xy == 0) {
                     this.seq = 3;
                  }
               }

               if (this.seq == 1) {
                  this.seq = 2;
               }

               if (this.seq == 0) {
                  this.bco[this.sp].xy += 5 * var123;
                  if (this.bco[this.sp].xy == 85 * var123) {
                     this.seq = 1;
                  }
               }
            }

            if (this.sptyp == 2 || this.sptyp == 3 || this.sptyp == 4 || this.sptyp == 6) {
               if (this.rot == -90 || this.rot == 180) {
                  var123 = -1;
               }

               if (this.seq == 2) {
                  this.bco[this.sp].zy += 5 * var123;
                  if (this.bco[this.sp].zy == 0) {
                     this.seq = 3;
                  }
               }

               if (this.seq == 1) {
                  this.seq = 2;
               }

               if (this.seq == 0) {
                  this.bco[this.sp].zy -= 5 * var123;
                  if (this.bco[this.sp].zy == -(85 * var123)) {
                     this.seq = 1;
                  }
               }
            }

            if (this.sptyp == 5) {
               if (this.rot == -90 || this.rot == 180) {
                  var123 = -1;
               }

               boolean var141 = false;
               if (this.rot == -90 || this.rot == 90) {
                  var141 = true;
               }

               if (var141) {
                  this.bco[this.sp].zy = 0;
               } else {
                  this.bco[this.sp].xy = 0;
               }

               if (this.seq == 2) {
                  if (var141) {
                     this.bco[this.sp].xy -= 5 * var123;
                     if (this.bco[this.sp].xy == 0) {
                        this.seq = 3;
                     }
                  } else {
                     this.bco[this.sp].zy += 5 * var123;
                     if (this.bco[this.sp].zy == 0) {
                        this.seq = 3;
                     }
                  }
               }

               if (this.seq == 1) {
                  this.seq = 2;
               }

               if (this.seq == 0) {
                  if (var141) {
                     this.bco[this.sp].xy += 5 * var123;
                     if (this.bco[this.sp].xy == 85 * var123) {
                        this.seq = 1;
                     }
                  } else {
                     this.bco[this.sp].zy -= 5 * var123;
                     if (this.bco[this.sp].zy == -(85 * var123)) {
                        this.seq = 1;
                     }
                  }
               }
            }

            if (this.sp == 66) {
               if (this.button("  Generate New  ", 110, 348, 3, true)) {
                  this.pgen = false;
                  this.pwd = (float)(2L + Math.round(Math.random() * 4.0));
                  this.phd = (float)(2L + Math.round(Math.random() * 4.0));
               }
            } else if (this.button("  Rotate  ", 110, 348, 3, true)) {
               boolean var142 = false;
               if (this.rot == 0 && !var142) {
                  this.rot = 90;
                  var142 = true;
               }

               if (this.rot == 90 && !var142) {
                  this.rot = 180;
                  var142 = true;
               }

               if (this.rot == 180 && !var142) {
                  this.rot = -90;
                  var142 = true;
               }

               if (this.rot == -90 && !var142) {
                  this.rot = 0;
                  var142 = true;
               }

               if (this.sp == 30 || this.sp == 31 || this.sp == 32) {
                  if (this.rot == -90) {
                     this.rot = 90;
                  }

                  if (this.rot == 180) {
                     this.rot = 0;
                  }
               }

               this.seq = 3;
               this.bco[this.sp].xy = 0;
               this.bco[this.sp].zy = 0;
               this.epart = false;
               this.arrng = false;
            }

            if (this.button(">", 191, 348, 3, true) && (this.sptyp == 0 || this.sptyp == 1 || this.sptyp == 2 || this.sptyp == 5)) {
               this.spart++;
               if (this.spart == this.part.getItemCount()) {
                  this.spart = 0;
               }

               this.part.select(this.spart);
               this.epart = false;
               this.arrng = false;
            }

            if (this.button("<", 28, 348, 3, true) && (this.sptyp == 0 || this.sptyp == 1 || this.sptyp == 2 || this.sptyp == 5)) {
               this.spart--;
               if (this.spart == -1) {
                  this.spart = this.part.getItemCount() - 1;
               }

               this.part.select(this.spart);
               this.epart = false;
               this.arrng = false;
            }

            if (this.button("   <  Undo   ", 204, 404, 0, true)) {
               this.epart = false;
               this.arrng = false;
               if (this.nundo > 0) {
                  this.nundo--;
                  this.bstage = this.undos[this.nundo];
                  this.readstage(0);
               }
            }

            if (this.button("   Remove / Edit  Part   ", 172, 454, 0, true)) {
               if (this.epart) {
                  this.epart = false;
               } else {
                  this.epart = true;
               }

               this.arrng = false;
               this.esp = -1;
            }

            if (this.button("   Go to >  Startline   ", 175, 504, 0, true)) {
               this.sx = 0;
               this.sz = 1500;
            }

            if (this.button(" About Part ", 164, 66, 3, false)) {
               JOptionPane.showMessageDialog(null, this.discp[this.sp], "Stage Maker", 1);
            }

            if (this.button("  Keyboard Controls  ", 691, 536, 3, false)) {
               JOptionPane.showMessageDialog(
                  null,
                  "Instead of clicking the triangular buttons around the Building Area to scroll, you can use:\n[ Keyboard Arrows ]\n\nYou can also zoom in and out using the following keys:\n[+] & [-]  or  [8] & [2]  or  [Enter] & [Backspace]\n\n",
                  "Stage Maker",
                  1
               );
            }

            if (this.button("  Save  ", 280, 50, 0, false)) {
               this.epart = false;
               this.arrng = false;
               this.savefile();
            }

            if (this.button("  Save & Preview  ", 380, 50, 0, false)) {
               this.epart = false;
               this.arrng = false;
               this.savefile();
               this.hidefields();
               this.tab = 2;
            }

            this.rd.setFont(new Font("Arial", 1, 12));
            this.ftm = this.rd.getFontMetrics();
            this.rd.setColor(new Color(0, 0, 0));
            int var144 = 0;
            byte var158 = 0;
            int var186 = (int)(this.xnob / 601.0F * 200.0F);
            var144 = var186;
            int var209 = (int)(this.t.nt / 6700.0F * 200.0F);
            if (var209 > var186) {
               var144 = var209;
               var158 = 1;
            }

            int var233 = (int)(this.cp.n / 140.0F * 200.0F);
            if (var233 > var144) {
               var144 = var233;
               var158 = 2;
            }

            int var249 = (int)(this.m.nrw * this.m.ncl / 16000.0F * 200.0F);
            if (var249 > var144) {
               var144 = var249;
               var158 = 3;
            }

            if (var144 > 200) {
               var144 = 200;
            }

            if (var144 > 100) {
               this.rd.setColor(new Color(200, 325 - var144, 30));
            } else {
               this.rd.setColor(new Color(100 + var144, 225, 30));
            }

            this.rd.fillRect(167, 531, var144, 9);
            if (this.button("Memory Consumption :", 85, 540, 3, false)) {
               JOptionPane.showMessageDialog(
                  null,
                  "Memory Consumption Details\n\nNumber of Parts:  "
                     + var186 / 2
                     + " %\nPart's Details:  "
                     + var209 / 2
                     + " %\nRoad Points:  "
                     + var233 / 2
                     + " %\nStage Area:  "
                     + var249 / 2
                     + " %\n \n",
                  "Stage Maker",
                  1
               );
            }

            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawRect(167, 531, 200, 9);
            String[] var266 = new String[]{"Number of Parts", "Part's Details", "Road Points", "Stage Area"};
            this.rd.drawString(var266[var158], 267 - this.ftm.stringWidth(var266[var158]) / 2, 540);
            this.rd.drawString("" + var144 / 2 + " %  used", 375, 540);
            if (this.overcan) {
               this.overcan = false;
            }

            if (!this.epart) {
               if (this.hi != -1) {
                  this.hi = -1;
               }

               if (this.esp != -1) {
                  this.esp = -1;
               }
            } else if (this.esp == -1) {
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawString("Click on any part to Edit >", 257, 454);
               if (this.button(" Cancel ", 323, 474, 4, false)) {
                  this.epart = false;
               }
            }

            if (!this.arrng) {
               if (this.chi != -1) {
                  this.chi = -1;
               }
            } else {
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawString("Click on Checkpoint NO# " + (this.arrcnt + 1) + "  >", 257, 80);
               if (this.button(" Cancel ", 330, 100, 4, false)) {
                  this.arrng = false;
               }

               if (this.arrcnt == this.cp.nsp) {
                  this.sortstage();
                  JOptionPane.showMessageDialog(null, "Checkpoints Arranged!\nPress Save and Test Drive to check the new checkpoint order.\n", "Stage Maker", 1);
                  this.arrng = false;
               }
            }
         }

         if (this.tab == 2) {
            if (this.tabed != this.tab) {
               this.m.trk = 0;
               this.readstage(1);
               this.setCursor(new Cursor(0));
               this.setcur = false;
               this.vxz = 0;
               this.vx = this.sx - 400;
               this.vz = this.sz - this.m.cz - 8000;
               this.vy = -1500;
               this.dtabed = -1;
            }

            this.m.trk = 0;
            this.m.zy = 6;
            this.m.iw = 10;
            this.m.w = 790;
            this.m.ih = 35;
            this.m.h = 445;
            this.m.cx = 400;
            this.m.cy = 215;
            this.m.xz = this.vxz;
            this.m.x = this.vx;
            this.m.z = this.vz;
            this.m.y = this.vy;
            this.m.d(this.rd);
            int var44 = 0;
            int[] var56 = new int[200];

            for (int var71 = 0; var71 < this.nob; var71++) {
               if (this.co[var71].dist == 0) {
                  this.co[var71].d(this.rd);
               } else {
                  var56[var44] = var71;
                  var44++;
               }
            }

            int[] var72 = new int[var44];

            for (int var97 = 0; var97 < var44; var97++) {
               var72[var97] = 0;
            }

            for (int var98 = 0; var98 < var44; var98++) {
               for (int var124 = var98 + 1; var124 < var44; var124++) {
                  if (this.co[var56[var98]].dist == this.co[var56[var124]].dist) {
                     if (var124 <= var98) {
                        var72[var124]++;
                     } else {
                        var72[var98]++;
                     }
                  } else if (this.co[var56[var98]].dist >= this.co[var56[var124]].dist) {
                     var72[var124]++;
                  } else {
                     var72[var98]++;
                  }
               }
            }

            for (int var99 = 0; var99 < var44; var99++) {
               for (int var125 = 0; var125 < var44; var125++) {
                  if (var72[var125] == var99) {
                     if (var56[var125] == this.hi) {
                        this.m.trk = 3;
                     }

                     this.co[var56[var125]].d(this.rd);
                     if (this.m.trk == 3) {
                        this.m.trk = 2;
                     }
                  }
               }
            }

            if (this.up) {
               this.vz = (int)(this.vz + 500.0F * this.m.cos(this.m.xz));
               this.vx = (int)(this.vx + 500.0F * this.m.sin(this.m.xz));
            }

            if (this.down) {
               this.vz = (int)(this.vz - 500.0F * this.m.cos(this.m.xz));
               this.vx = (int)(this.vx - 500.0F * this.m.sin(this.m.xz));
            }

            if (this.left) {
               this.vxz -= 5;
            }

            if (this.right) {
               this.vxz += 5;
            }

            if (this.zoomi) {
               this.vy += 100;
               if (this.vy > -500) {
                  this.vy = -500;
               }
            }

            if (this.zoomo) {
               this.vy -= 100;
               if (this.vy < -5000) {
                  this.vy = -5000;
               }
            }

            this.rd.setColor(new Color(225, 225, 225));
            this.rd.fillRect(0, 25, 10, 525);
            this.rd.fillRect(790, 25, 10, 525);
            this.rd.fillRect(10, 25, 780, 10);
            this.rd.fillRect(10, 445, 780, 105);
            this.rd.setFont(new Font("Arial", 1, 12));
            this.ftm = this.rd.getFontMetrics();
            String[] var100 = new String[]{"Controls", "Atmosphere", "Colors", "Scenery", "Laps", "Sound Track", "Test Drive"};
            int[] var126 = new int[]{10, 10, 121, 111};
            int[] var146 = new int[]{425, 445, 445, 425};

            for (int var159 = 0; var159 < 7; var159++) {
               this.rd.setColor(new Color(170, 170, 170));
               if (this.xm > var126[0] && this.xm < var126[3] && this.ym > 425 && this.ym < 445) {
                  this.rd.setColor(new Color(190, 190, 190));
               }

               if (this.dtab == var159) {
                  this.rd.setColor(new Color(225, 225, 225));
               }

               this.rd.fillPolygon(var126, var146, 4);
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawString(var100[var159], var159 * 111 + 62 - this.ftm.stringWidth(var100[var159]) / 2, 439);
               if (this.xm > var126[0] && this.xm < var126[3] && this.ym > 425 && this.ym < 445 && this.mouses == -1 && this.mouseon == -1) {
                  this.dtab = var159;
               }

               for (int var187 = 0; var187 < 4; var187++) {
                  var126[var187] += 111;
               }
            }

            if (this.tabed == this.tab && this.dtab != this.dtabed) {
               if (!this.ttstage.equals("")) {
                  this.tstage = this.ttstage;
                  this.ttstage = "";
               }

               this.readstage(1);
               this.hidefields();
            }

            if (this.dtab == 0) {
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawString("Use the [ Keyboard Arrows ] to navigate through the stage.", 20, 470);
               this.rd.drawString("[Left] & [Right] arrows are for rotating.  [Up] & [Down] arrows are for moving forwards and backwards.", 20, 490);
               this.rd.drawString("For moving vertically down and up use the following keys:  [+] & [-]  or  [8] & [2]  or  [Enter] & [Backspace]", 20, 520);
            }

            if (this.dtab == 2) {
               if (this.dtabed != this.dtab) {
                  Color.RGBtoHSB(this.csky[0], this.csky[1], this.csky[2], this.hsb[0]);
                  Color.RGBtoHSB(this.cfade[0], this.cfade[1], this.cfade[2], this.hsb[1]);
                  Color.RGBtoHSB(this.cgrnd[0], this.cgrnd[1], this.cgrnd[2], this.hsb[2]);

                  for (int var160 = 0; var160 < 3; var160++) {
                     float var188 = this.hsb[var160][1];
                     this.hsb[var160][1] = this.hsb[var160][2];
                     this.hsb[var160][2] = var188;
                  }

                  if (this.hsb[1][1] == (this.hsb[0][1] + this.hsb[2][1]) / 2.0F && this.hsb[1][0] == this.hsb[2][0] && this.hsb[1][2] == this.hsb[2][2]) {
                     this.pfog.setState(true);
                  } else {
                     this.pfog.setState(false);
                  }

                  this.ttstage = "";
                  this.mouseon = -1;
               }

               if (this.mouses != 1) {
                  if ((this.mouseon >= 6 || this.mouseon < 3) && this.mouseon != -1) {
                     if (this.ttstage.equals("")) {
                        this.ttstage = this.tstage;
                     }

                     this.sortop();
                     this.readstage(1);
                  }

                  this.mouseon = -1;
               }

               String[] var161 = new String[]{"Sky", "Dust / Fog", "Ground"};

               for (int var189 = 0; var189 < 3; var189++) {
                  this.rd.setColor(new Color(0, 0, 0));
                  this.rd.drawString(var161[var189], 107 + 195 * var189 - this.ftm.stringWidth(var161[var189]) / 2, 461);

                  for (int var210 = 0; var210 < 150; var210++) {
                     this.rd.setColor(Color.getHSBColor((float)(var210 * 0.006667), 1.0F, 1.0F));
                     this.rd.drawLine(32 + var210 + 195 * var189, 467, 32 + var210 + 195 * var189, 474);
                  }

                  for (int var211 = 0; var211 < 150; var211++) {
                     this.rd.setColor(Color.getHSBColor(0.0F, 0.0F, 0.5F + var211 * 0.00333F));
                     this.rd.drawLine(32 + var211 + 195 * var189, 483, 32 + var211 + 195 * var189, 490);
                  }

                  for (int var212 = 0; var212 < 150; var212++) {
                     this.rd.setColor(Color.getHSBColor(this.hsb[var189][0], 0.0F + (float)(var212 * 0.001667), this.hsb[var189][1]));
                     this.rd.drawLine(32 + var212 + 195 * var189, 499, 32 + var212 + 195 * var189, 506);
                  }

                  for (int var213 = 0; var213 < 3; var213++) {
                     this.rd.setColor(new Color(0, 0, 0));
                     float var234 = this.hsb[var189][var213] * 150.0F;
                     if (var213 == 1) {
                        float var250 = 0.75F;
                        if (var189 == 0) {
                           var250 = 0.85F;
                        }

                        if (var189 == 1) {
                           var250 = 0.8F;
                        }

                        var234 = (this.hsb[var189][var213] - var250) / 0.001F;
                     }

                     if (var213 == 2) {
                        var234 = this.hsb[var189][var213] * 600.0F;
                     }

                     if (var234 < 0.0F) {
                        var234 = 0.0F;
                     }

                     if (var234 > 150.0F) {
                        var234 = 150.0F;
                     }

                     this.rd.drawLine((int)(32 + 195 * var189 + var234), 467 + var213 * 16, (int)(32 + 195 * var189 + var234), 474 + var213 * 16);
                     this.rd.drawLine((int)(33 + 195 * var189 + var234), 467 + var213 * 16, (int)(33 + 195 * var189 + var234), 474 + var213 * 16);
                     this.rd.fillRect((int)(31 + 195 * var189 + var234), 475 + var213 * 16, 4, 2);
                     this.rd.drawLine((int)(30 + 195 * var189 + var234), 477 + var213 * 16, (int)(35 + 195 * var189 + var234), 477 + var213 * 16);
                     if (this.xm > 29 + 195 * var189
                        && this.xm < 185 + 195 * var189
                        && this.ym > 468 + var213 * 16
                        && this.ym < 477 + var213 * 16
                        && this.mouses == 1
                        && this.mouseon == -1) {
                        this.mouseon = var213 + var189 * 3;
                     }

                     if (this.mouseon == var213 + var189 * 3) {
                        if (var213 == 0) {
                           this.hsb[var189][var213] = (this.xm - (32 + 195 * var189)) / 150.0F;
                        }

                        if (var213 == 1) {
                           float var251 = 0.75F;
                           if (var189 == 0) {
                              var251 = 0.85F;
                           }

                           if (var189 == 1) {
                              var251 = 0.8F;
                           }

                           this.hsb[var189][var213] = var251 + (this.xm - (32 + 195 * var189)) * 0.001F;
                           if (this.hsb[var189][var213] < var251) {
                              this.hsb[var189][var213] = var251;
                           }

                           if (this.hsb[var189][var213] > var251 + 0.15F) {
                              this.hsb[var189][var213] = var251 + 0.15F;
                           }
                        }

                        if (var213 == 2) {
                           this.hsb[var189][var213] = (this.xm - (32 + 195 * var189)) / 600.0F;
                           if (this.hsb[var189][var213] > 0.25) {
                              this.hsb[var189][var213] = 0.25F;
                           }
                        }

                        if (this.hsb[var189][var213] > 1.0F) {
                           this.hsb[var189][var213] = 1.0F;
                        }

                        if (this.hsb[var189][var213] < 0.0F) {
                           this.hsb[var189][var213] = 0.0F;
                        }
                     }
                  }
               }

               this.movefield(this.pfog, 258, 511, 200, 23);
               if (!this.pfog.isShowing()) {
                  this.pfog.show();
               }

               if (this.pfog.getState()) {
                  this.rd.setComposite(AlphaComposite.getInstance(3, 0.25F));
                  this.rd.setColor(new Color(0, 0, 0));
                  this.rd.fillRect(215, 464, 175, 47);
                  this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
                  this.hsb[1][1] = (this.hsb[0][1] + this.hsb[2][1]) / 2.0F;
                  this.hsb[1][0] = this.hsb[2][0];
                  this.hsb[1][2] = this.hsb[2][2];
               }

               Color var190 = Color.getHSBColor(this.hsb[0][0], this.hsb[0][2], this.hsb[0][1]);
               this.m.setsky(var190.getRed(), var190.getGreen(), var190.getBlue());
               this.csky[0] = var190.getRed();
               this.csky[1] = var190.getGreen();
               this.csky[2] = var190.getBlue();
               var190 = Color.getHSBColor(this.hsb[1][0], this.hsb[1][2], this.hsb[1][1]);
               this.m.setfade(var190.getRed(), var190.getGreen(), var190.getBlue());
               this.cfade[0] = var190.getRed();
               this.cfade[1] = var190.getGreen();
               this.cfade[2] = var190.getBlue();
               var190 = Color.getHSBColor(this.hsb[2][0], this.hsb[2][2], this.hsb[2][1]);
               this.m.setgrnd(var190.getRed(), var190.getGreen(), var190.getBlue());
               this.cgrnd[0] = var190.getRed();
               this.cgrnd[1] = var190.getGreen();
               this.cgrnd[2] = var190.getBlue();
               if (this.button(" Reset ", 650, 510, 0, true)) {
                  if (!this.ttstage.equals("")) {
                     this.tstage = this.ttstage;
                     this.ttstage = "";
                  }

                  this.readstage(1);
                  this.dtabed = -2;
               }

               if (this.button("        Save        ", 737, 510, 0, true)) {
                  this.sortop();
                  this.ttstage = "";
                  this.savefile();
               }
            }

            if (this.dtab == 3) {
               if (this.dtabed != this.dtab) {
                  Color.RGBtoHSB(this.cldd[0], this.cldd[1], this.cldd[2], this.hsb[0]);
                  Color.RGBtoHSB(this.texture[0], this.texture[1], this.texture[2], this.hsb[1]);
                  this.mgen.setText("" + this.m.mgen + "");
                  this.mouseon = -1;
                  this.ttstage = "";
               }

               if (this.mouses != 1) {
                  if (this.mouseon == 0 || this.mouseon == 1 || this.mouseon == 2 || this.mouseon == 6) {
                     if (this.ttstage.equals("")) {
                        this.ttstage = this.tstage;
                     }

                     this.sortop();
                     this.readstage(1);
                  }

                  this.mouseon = -1;
               }

               this.rd.setFont(new Font("Arial", 1, 12));
               this.ftm = this.rd.getFontMetrics();
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawString("Clouds", 32, 461);

               for (int var162 = 0; var162 < 150; var162++) {
                  this.rd.setColor(Color.getHSBColor(var162 * 0.006667F, 1.0F, 1.0F));
                  this.rd.drawLine(32 + var162 + 0, 467, 32 + var162 + 0, 474);
               }

               for (int var163 = 0; var163 < 150; var163++) {
                  this.rd.setColor(Color.getHSBColor(0.0F, 0.0F, 0.75F + var163 * 0.001667F));
                  this.rd.drawLine(32 + var163 + 0, 483, 32 + var163 + 0, 490);
               }

               for (int var164 = 0; var164 < 150; var164++) {
                  this.rd.setColor(Color.getHSBColor(this.hsb[0][0], var164 * 0.003333F, this.hsb[0][2]));
                  this.rd.drawLine(32 + var164 + 0, 499, 32 + var164 + 0, 506);
               }

               this.rd.setFont(new Font("Arial", 0, 11));
               this.ftm = this.rd.getFontMetrics();
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawString("Blend:", 32, 529);
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.fillRect(70, 522, 112, 2);
               this.rd.fillRect(70, 528, 112, 2);
               float var165 = 0.0F;
               int var193 = 255;

               for (int var214 = 0; var214 < 112; var214++) {
                  var193 = (int)(255.0F / (var165 + 1.0F));
                  if (var193 > 255) {
                     var193 = 255;
                  }

                  if (var193 < 0) {
                     var193 = 0;
                  }

                  var165 += 0.02F;
                  this.rd.setColor(new Color(var193, var193, var193));
                  this.rd.drawLine(70 + var214, 524, 70 + var214, 527);
               }

               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawString("Height", 202 - this.ftm.stringWidth("Height") / 2, 461);
               this.rd.drawLine(202, 467, 202, 530);

               for (int var215 = 0; var215 < 8; var215++) {
                  this.rd.drawLine(202, 466 + var215 * 8, 202 + (8 - var215), 466 + var215 * 8);
               }

               this.rd.setFont(new Font("Arial", 1, 12));
               this.ftm = this.rd.getFontMetrics();
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawString("Ground Texture", 257, 471);

               for (int var216 = 0; var216 < 150; var216++) {
                  this.rd.setColor(Color.getHSBColor(var216 * 0.006667F, 1.0F, 1.0F));
                  this.rd.drawLine(32 + var216 + 225, 477, 32 + var216 + 225, 484);
               }

               for (int var217 = 0; var217 < 150; var217++) {
                  this.rd.setColor(Color.getHSBColor(this.hsb[1][0], var217 * 0.006667F, var217 * 0.006667F));
                  this.rd.drawLine(32 + var217 + 225, 493, 32 + var217 + 225, 500);
               }

               this.rd.setFont(new Font("Arial", 0, 11));
               this.ftm = this.rd.getFontMetrics();
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawString("Blend:", 257, 523);
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.fillRect(295, 516, 112, 2);
               this.rd.fillRect(295, 522, 112, 2);
               var165 = 0.0F;
               int var195 = 255;

               for (int var218 = 0; var218 < 112; var218++) {
                  var195 = (int)(255.0F / (var165 + 1.0F));
                  if (var195 > 255) {
                     var195 = 255;
                  }

                  if (var195 < 0) {
                     var195 = 0;
                  }

                  var165 += 0.02F;
                  this.rd.setColor(new Color(var195, var195, var195));
                  this.rd.drawLine(70 + var218 + 225, 518, 70 + var218 + 225, 521);
               }

               for (int var219 = 0; var219 < 2; var219++) {
                  byte var235 = 3;
                  if (var219 == 1) {
                     var235 = 2;
                  }

                  for (int var252 = 0; var252 < var235; var252++) {
                     int var267 = var252;
                     if (var252 == 1) {
                        var267 = 2;
                     }

                     if (var252 == 2) {
                        var267 = 1;
                     }

                     this.rd.setColor(new Color(0, 0, 0));
                     float var277 = this.hsb[var219][var267] * 150.0F;
                     if (var252 == 1 && var219 == 0) {
                        float var286 = 0.75F;
                        var277 = (this.hsb[var219][var267] - var286) / 0.001667F;
                     }

                     if (var252 == 2 && var219 == 0) {
                        var277 = this.hsb[var219][var267] / 0.003333F;
                     }

                     if (var277 < 0.0F) {
                        var277 = 0.0F;
                     }

                     if (var277 > 150.0F) {
                        var277 = 150.0F;
                     }

                     this.rd
                        .drawLine(
                           (int)(32 + 225 * var219 + var277),
                           467 + var252 * 16 + 10 * var219,
                           (int)(32 + 225 * var219 + var277),
                           474 + var252 * 16 + 10 * var219
                        );
                     this.rd
                        .drawLine(
                           (int)(33 + 225 * var219 + var277),
                           467 + var252 * 16 + 10 * var219,
                           (int)(33 + 225 * var219 + var277),
                           474 + var252 * 16 + 10 * var219
                        );
                     this.rd.fillRect((int)(31 + 225 * var219 + var277), 475 + var252 * 16 + 10 * var219, 4, 2);
                     this.rd
                        .drawLine(
                           (int)(30 + 225 * var219 + var277),
                           477 + var252 * 16 + 10 * var219,
                           (int)(35 + 225 * var219 + var277),
                           477 + var252 * 16 + 10 * var219
                        );
                     if (this.xm > 29 + 225 * var219
                        && this.xm < 185 + 225 * var219
                        && this.ym > 468 + var252 * 16 + 10 * var219
                        && this.ym < 477 + var252 * 16 + 10 * var219
                        && this.mouses == 1
                        && this.mouseon == -1) {
                        this.mouseon = var252 + var219 * 3;
                     }

                     if (this.mouseon == var252 + var219 * 3) {
                        this.hsb[var219][var267] = (this.xm - (32 + 225 * var219)) * 0.006667F;
                        if (var252 == 1 && var219 == 1) {
                           this.hsb[var219][1] = (this.xm - (32 + 225 * var219)) * 0.006667F;
                           if (this.hsb[var219][1] > 1.0F) {
                              this.hsb[var219][1] = 1.0F;
                           }

                           if (this.hsb[var219][1] < 0.0F) {
                              this.hsb[var219][1] = 0.0F;
                           }
                        }

                        if (var252 == 1 && var219 == 0) {
                           float var287 = 0.75F;
                           this.hsb[var219][var267] = var287 + (this.xm - (32 + 225 * var219)) * 0.001667F;
                           if (this.hsb[var219][var267] < var287) {
                              this.hsb[var219][var267] = var287;
                           }
                        }

                        if (var252 == 2 && var219 == 0) {
                           this.hsb[var219][var267] = (this.xm - (32 + 225 * var219)) * 0.003333F;
                           if (this.hsb[var219][var267] > 0.5) {
                              this.hsb[var219][var267] = 0.5F;
                           }
                        }

                        if (this.hsb[var219][var267] > 1.0F) {
                           this.hsb[var219][var267] = 1.0F;
                        }

                        if (this.hsb[var219][var267] < 0.0F) {
                           this.hsb[var219][var267] = 0.0F;
                        }
                     }
                  }

                  this.rd.setColor(new Color(0, 0, 0));
                  float var253 = (this.texture[3] - 20) * 2.8F;
                  if (var219 == 0) {
                     var253 = this.cldd[3] * 11.2F;
                  }

                  if (var253 < 0.0F) {
                     var253 = 0.0F;
                  }

                  if (var253 > 112.0F) {
                     var253 = 112.0F;
                  }

                  this.rd.drawLine((int)(70 + 225 * var219 + var253), 522 - 6 * var219, (int)(70 + 225 * var219 + var253), 529 - 6 * var219);
                  this.rd.drawLine((int)(71 + 225 * var219 + var253), 522 - 6 * var219, (int)(71 + 225 * var219 + var253), 529 - 6 * var219);
                  this.rd.fillRect((int)(69 + 225 * var219 + var253), 530 - 6 * var219, 4, 2);
                  this.rd.drawLine((int)(68 + 225 * var219 + var253), 532 - 6 * var219, (int)(73 + 225 * var219 + var253), 532 - 6 * var219);
                  if (this.xm > 67 + 225 * var219
                     && this.xm < 185 + 225 * var219
                     && this.ym > 522 - 6 * var219
                     && this.ym < 532 - 6 * var219
                     && this.mouses == 1
                     && this.mouseon == -1) {
                     this.mouseon = 6 + var219;
                  }
               }

               if (this.mouseon == 6) {
                  this.cldd[3] = (int)((this.xm - 70) / 11.2F);
                  if (this.cldd[3] < 0) {
                     this.cldd[3] = 0;
                  }

                  if (this.cldd[3] > 10) {
                     this.cldd[3] = 10;
                  }
               }

               if (this.mouseon == 7) {
                  this.texture[3] = (int)((this.xm - 70 - 225) / 2.8 + 20.0);
                  if (this.texture[3] < 20) {
                     this.texture[3] = 20;
                  }

                  if (this.texture[3] > 60) {
                     this.texture[3] = 60;
                  }
               }

               this.rd.setColor(new Color(0, 128, 255));
               float var220 = (1500 - Math.abs(this.cldd[4])) / 15.625F;
               if (var220 > 64.0F) {
                  var220 = 64.0F;
               }

               if (var220 < 0.0F) {
                  var220 = 0.0F;
               }

               this.rd.drawRect(199, (int)(465.0F + var220), 12, 2);
               if (this.xm > 197 && this.xm < 213 && this.ym > 463 && this.ym < 533 && this.mouses == 1 && this.mouseon == -1) {
                  this.mouseon = 8;
               }

               if (this.mouseon == 8) {
                  this.cldd[4] = -((int)((530 - this.ym) * 15.625F + 500.0F));
                  if (this.cldd[4] > -500) {
                     this.cldd[4] = -500;
                  }

                  if (this.cldd[4] < -1500) {
                     this.cldd[4] = -1500;
                  }
               }

               Color var236 = Color.getHSBColor(this.hsb[0][0], this.hsb[0][1], this.hsb[0][2]);
               this.m.setcloads(var236.getRed(), var236.getGreen(), var236.getBlue(), this.cldd[3], this.cldd[4]);
               this.cldd[0] = var236.getRed();
               this.cldd[1] = var236.getGreen();
               this.cldd[2] = var236.getBlue();
               var236 = Color.getHSBColor(this.hsb[1][0], this.hsb[1][1], this.hsb[1][2]);
               this.m.setexture(var236.getRed(), var236.getGreen(), var236.getBlue(), this.texture[3]);
               this.texture[0] = var236.getRed();
               this.texture[1] = var236.getGreen();
               this.texture[2] = var236.getBlue();
               this.rd.setFont(new Font("Arial", 1, 12));
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawString("Mountains", 452, 465);
               this.rd.setFont(new Font("Arial", 0, 11));
               this.rd.drawString("Mountain Generator Key:", 452, 480);
               this.movefield(this.mgen, 452, 484, 120, 20);
               if (this.mgen.hasFocus()) {
                  this.focuson = false;
               }

               if (!this.mgen.isShowing()) {
                  this.mgen.show();
               }

               if (this.button("  Generate New  ", 512, 525, 3, true)) {
                  this.m.mgen = (int)(Math.random() * 100000.0);
                  this.mgen.setText("" + this.m.mgen + "");
                  if (this.ttstage.equals("")) {
                     this.ttstage = this.tstage;
                  }

                  this.sortop();
                  this.readstage(1);
               }

               if (!this.mgen.getText().equals("" + this.m.mgen + "")) {
                  try {
                     int var254 = Integer.valueOf(this.mgen.getText());
                     this.m.mgen = var254;
                     if (this.ttstage.equals("")) {
                        this.ttstage = this.tstage;
                     }

                     this.sortop();
                     this.readstage(1);
                  } catch (Exception var30) {
                     this.mgen.setText("" + this.m.mgen + "");
                  }
               }

               if (this.button(" Reset ", 650, 510, 0, true)) {
                  if (!this.ttstage.equals("")) {
                     this.tstage = this.ttstage;
                     this.ttstage = "";
                  }

                  this.readstage(1);
                  this.dtabed = -2;
               }

               if (this.button("        Save        ", 737, 510, 0, true)) {
                  this.sortop();
                  this.ttstage = "";
                  this.savefile();
               }
            }

            if (this.dtab == 1) {
               if (this.dtabed != this.dtab) {
                  for (int var167 = 0; var167 < 3; var167++) {
                     this.snap[var167] = (int)(this.m.snap[var167] / 1.2F + 50.0F);
                  }

                  this.fogn[0] = (8 - ((this.m.fogd + 1) / 2 - 1)) * 20;
                  this.fogn[1] = (this.m.fade[0] - 5000) / 30;
               }

               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawString("Atmosphere RGB Mask", 20, 461);
               this.rd.setColor(new Color(128, 128, 128));
               this.rd.drawLine(10, 457, 17, 457);
               this.rd.drawLine(260, 457, 152, 457);
               this.rd.drawLine(10, 457, 10, 546);
               this.rd.drawLine(260, 457, 260, 527);
               this.rd.drawLine(260, 527, 360, 527);
               this.rd.drawLine(10, 546, 360, 546);
               this.rd.drawLine(360, 527, 360, 546);
               String[] var168 = new String[]{"Red", "Green", "Blue"};
               int[] var197 = new int[]{32, 20, 29};
               byte var221 = 38;
               int var238 = -70;

               for (int var255 = 0; var255 < 3; var255++) {
                  this.rd.setColor(new Color(0, 0, 0));
                  this.rd.drawString("" + var168[var255] + " :", var197[var255], 447 + var255 * 24 + var221);
                  this.rd.drawLine(140 + var238, 443 + var255 * 24 + var221, 230 + var238, 443 + var255 * 24 + var221);

                  for (int var268 = 1; var268 < 10; var268++) {
                     this.rd
                        .drawLine(
                           140 + 10 * var268 + var238, 443 - var268 + var255 * 24 + var221, 140 + 10 * var268 + var238, 443 + var268 + var255 * 24 + var221
                        );
                  }

                  this.rd.setColor(new Color(255, 0, 0));
                  int var269 = (int)(this.snap[var255] / 1.1111F / 10.0F);
                  this.rd.fillRect(138 + (int)(this.snap[var255] / 1.1111F) + var238, 443 - var269 + var255 * 24 + var221, 5, var269 * 2 + 1);
                  this.rd.setColor(new Color(255, 128, 0));
                  this.rd.drawRect(139 + (int)(this.snap[var255] / 1.1111F) + var238, 434 + var255 * 24 + var221, 2, 18);
                  if (this.button(" - ", 260 + var238, 447 + var255 * 24 + var221, 4, false)) {
                     this.snap[var255] = this.snap[var255] - 2;
                     if (this.snap[var255] < 0) {
                        this.snap[var255] = 0;
                     }
                  }

                  if (this.button(" + ", 300 + var238, 447 + var255 * 24 + var221, 4, false)) {
                     if (this.snap[0] + this.snap[1] + this.snap[2] > 200) {
                        for (int var278 = 0; var278 < 3; var278++) {
                           if (var278 != var255) {
                              this.snap[var278]--;
                              if (this.snap[var278] < 0) {
                                 this.snap[var278] = 0;
                              }
                           }
                        }
                     }

                     this.snap[var255] = this.snap[var255] + 2;
                     if (this.snap[var255] > 100) {
                        this.snap[var255] = 100;
                     }
                  }
               }

               if (this.m.snap[0] != (int)(this.snap[0] * 1.2F - 60.0F)
                  || this.m.snap[1] != (int)(this.snap[1] * 1.2F - 60.0F)
                  || this.m.snap[2] != (int)(this.snap[2] * 1.2F - 60.0F)) {
                  for (int var256 = 0; var256 < 3; var256++) {
                     this.m.snap[var256] = (int)(this.snap[var256] * 1.2F - 60.0F);
                  }

                  this.readstage(2);
               }

               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawString("Car Lights :", 265, 541);
               if (this.snap[0] + this.snap[1] + this.snap[2] <= 110) {
                  this.rd.setColor(new Color(0, 200, 0));
                  this.rd.drawString("On", 335, 541);
                  this.m.lightson = true;
               } else {
                  this.rd.drawString("Off", 335, 541);
                  this.m.lightson = false;
               }

               byte var257 = 33;
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawString("Dust/Fog Properties", 280 + var257, 461);
               this.rd.setColor(new Color(128, 128, 128));
               this.rd.drawLine(270 + var257, 457, 277 + var257, 457);
               this.rd.drawLine(540 + var257, 457, 393 + var257, 457);
               this.rd.drawLine(270 + var257, 457, 270 + var257, 522);
               this.rd.drawLine(540 + var257, 457, 540 + var257, 522);
               this.rd.drawLine(270 + var257, 522, 540 + var257, 522);
               String[] var270 = new String[]{"Density", "Near / Far"};
               int[] var279 = new int[]{292 + var257, 280 + var257};
               int[] var288 = new int[]{20, 10};
               var221 = 38;
               var238 = 210 + var257;

               for (int var298 = 0; var298 < 2; var298++) {
                  this.rd.setColor(new Color(0, 0, 0));
                  this.rd.drawString("" + var270[var298] + " :", var279[var298], 447 + var298 * 24 + var221);
                  this.rd.drawLine(140 + var238, 443 + var298 * 24 + var221, 230 + var238, 443 + var298 * 24 + var221);

                  for (int var303 = 1; var303 < 10; var303++) {
                     this.rd
                        .drawLine(
                           140 + 10 * var303 + var238, 443 - var303 + var298 * 24 + var221, 140 + 10 * var303 + var238, 443 + var303 + var298 * 24 + var221
                        );
                  }

                  this.rd.setColor(new Color(255, 0, 0));
                  int var304 = (int)(this.fogn[var298] / 1.1111F / 10.0F);
                  this.rd.fillRect(138 + (int)(this.fogn[var298] / 1.1111F) + var238, 443 - var304 + var298 * 24 + var221, 5, var304 * 2 + 1);
                  this.rd.setColor(new Color(255, 128, 0));
                  this.rd.drawRect(139 + (int)(this.fogn[var298] / 1.1111F) + var238, 434 + var298 * 24 + var221, 2, 18);
                  if (this.button(" - ", 260 + var238, 447 + var298 * 24 + var221, 4, false)) {
                     this.fogn[var298] = this.fogn[var298] - var288[var298];
                     if (this.fogn[var298] < 0) {
                        this.fogn[var298] = 0;
                     }
                  }

                  if (this.button(" + ", 300 + var238, 447 + var298 * 24 + var221, 4, false)) {
                     this.fogn[var298] = this.fogn[var298] + var288[var298];
                     if (this.fogn[var298] > 100) {
                        this.fogn[var298] = 100;
                     }
                  }
               }

               this.m.fogd = (8 - this.fogn[0] / 20 + 1) * 2 - 1;
               this.m.fadfrom(5000 + this.fogn[1] * 30);
               this.origfade = this.m.fade[0];
               if (this.button(" Reset ", 650, 510, 0, true)) {
                  this.dtabed = -2;
               }

               if (this.button("        Save        ", 737, 510, 0, true)) {
                  this.sortop();
                  this.savefile();
               }
            }

            if (this.dtab == 4) {
               if (this.dtabed != this.dtab && this.cp.nlaps - 1 >= 0 && this.cp.nlaps - 1 <= 14) {
                  this.nlaps.select(this.cp.nlaps - 1);
               }

               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawString("Set the number of laps for this stage:", 130, 496);
               this.nlaps.move(348, 480);
               if (!this.nlaps.isShowing()) {
                  this.nlaps.show();
               }

               if (this.cp.nlaps != this.nlaps.getSelectedIndex() + 1) {
                  this.cp.nlaps = this.nlaps.getSelectedIndex() + 1;
                  this.requestFocus();
               }

               if (this.button(" Reset ", 530, 496, 0, true)) {
                  this.dtabed = -2;
               }

               if (this.button("        Save        ", 617, 496, 0, true)) {
                  this.sortop();
                  this.savefile();
               }
            }

            if (this.dtab == 5) {
               if (this.dtabed != this.dtab) {
                  this.tracks.removeAll();
                  this.tracks.maxl = 200;
                  this.tracks.add(this.rd, "The Play List  -  MOD Tracks");
                  String[] var169 = new File("" + smfpath + "mystages/mymusic/").list();
                  if (var169 != null) {
                     for (int var198 = 0; var198 < var169.length; var198++) {
                        if (var169[var198].toLowerCase().endsWith(".zip")) {
                           this.tracks.add(this.rd, var169[var198].substring(0, var169[var198].length() - 4));
                        }
                     }
                  }

                  if (!this.ltrackname.equals("")) {
                     this.tracks.select(this.ltrackname);
                  } else if (!this.trackname.equals("")) {
                     this.tracks.select(this.trackname);
                  } else {
                     this.tracks.select(0);
                  }

                  this.mouseon = -1;
               }

               this.tracks.move(10, 450);
               if (this.tracks.getWidth() != 200) {
                  this.tracks.setSize(200, 21);
               }

               if (!this.tracks.isShowing()) {
                  this.tracks.show();
               }

               if (this.track.playing && this.track.loaded == 2) {
                  if (this.button("      Stop      ", 110, 495, 2, false)) {
                     this.track.stop();
                  }

                  if (!this.ltrackname.equals(this.tracks.getSelectedItem())) {
                     this.track.stop();
                  }

                  if (this.xm > 10 && this.xm < 210 && this.ym > 516 && this.ym < 534) {
                     if (this.mouses == 1) {
                        this.mouseon = 1;
                     }

                     this.rd.setColor(new Color(0, 164, 242));
                  } else {
                     this.rd.setColor(new Color(120, 210, 255));
                  }

                  this.rd.drawRect(10, 516, 200, 18);
                  this.rd.setColor(new Color(200, 200, 200));
                  this.rd.drawLine(10, 523, 210, 523);
                  this.rd.setColor(new Color(0, 0, 0));
                  this.rd.drawLine(10, 524, 210, 524);
                  this.rd.drawLine(10, 525, 210, 525);
                  this.rd.drawLine(10, 526, 210, 526);
                  this.rd.setColor(new Color(255, 255, 255));
                  this.rd.drawLine(10, 527, 210, 527);
                  int var170 = (int)((1.0F - (float)this.track.sClip.stream.available() / this.avon) * 200.0F);
                  if (this.mouseon == 1) {
                     var170 = this.xm - 10;
                     if (var170 < 0) {
                        var170 = 0;
                     }

                     if (var170 > 200) {
                        var170 = 200;
                     }

                     if (this.mouses != 1) {
                        this.track.sClip.stream.reset();
                        this.track.sClip.stream.skip((long)(var170 / 200.0F * this.avon));
                        this.mouseon = -1;
                     }
                  }

                  this.rd.setColor(new Color(0, 0, 0));
                  this.rd.drawRect(8 + var170, 516, 4, 18);
                  this.rd.setColor(new Color(0, 164, 242));
                  this.rd.drawLine(10 + var170, 520, 10 + var170, 518);
                  this.rd.drawLine(10 + var170, 530, 10 + var170, 532);
               } else if (this.tracks.getSelectedIndex() != 0 && this.button("      Play  >      ", 110, 495, 2, false)) {
                  if (!this.ltrackname.equals(this.tracks.getSelectedItem())) {
                     this.track.unload();
                     this.track = new RadicalMod("mystages/mymusic/" + this.tracks.getSelectedItem() + ".zip", 300, 8000, 125, true, false);
                     if (this.track.loaded != 2) {
                        this.ltrackname = "";
                     } else {
                        this.avon = this.track.sClip.stream.available();
                        this.ltrackname = this.tracks.getSelectedItem();
                     }
                  }

                  if (this.ltrackname.equals("")) {
                     JOptionPane.showMessageDialog(
                        null, "Failed to load '" + this.tracks.getSelectedItem() + "', please make sure it is a valid MOD Track!", "Stage Maker", 1
                     );
                  } else {
                     this.track.play();
                  }
               }

               if (this.tracks.getSelectedIndex() != 0) {
                  if (this.button("   Set as the stage's Sound Track  >   ", 330, 466, 2, false)) {
                     if (!this.ltrackname.equals(this.tracks.getSelectedItem())) {
                        this.track.unload();
                        this.track = new RadicalMod("mystages/mymusic/" + this.tracks.getSelectedItem() + ".zip", 300, 8000, 125, true, false);
                        if (this.track.loaded != 2) {
                           this.ltrackname = "";
                        } else {
                           this.avon = this.track.sClip.stream.available();
                           this.ltrackname = this.tracks.getSelectedItem();
                        }
                     }

                     if (this.ltrackname.equals("")) {
                        JOptionPane.showMessageDialog(
                           null, "Failed to load '" + this.tracks.getSelectedItem() + "', please make sure it is a valid MOD Track!", "Stage Maker", 1
                        );
                     } else {
                        this.trackname = this.ltrackname;
                        this.trackvol = (int)(220.0F / (this.track.rvol / 3750.0F));

                        try {
                           File var171 = new File("" + smfpath + "mystages/mymusic/" + this.trackname + ".zip");
                           this.tracksize = (int)(var171.length() / 1024L);
                           if (this.tracksize > 700) {
                              JOptionPane.showMessageDialog(
                                 null,
                                 "Cannot use '" + this.tracks.getSelectedItem() + "' as the sound track!\nIts file size is bigger then 700KB.\n\n",
                                 "Stage Maker",
                                 1
                              );
                              this.trackname = "";
                           }
                        } catch (Exception var29) {
                           this.tracksize = 111;
                        }
                     }
                  }

                  if (this.button("   X Delete   ", 258, 495, 2, false)
                     && JOptionPane.showConfirmDialog(
                           null,
                           "Are you sure you want to permanently delete this MOD Track from your Play List?\n\n"
                              + this.tracks.getSelectedItem()
                              + "\n\n>  If you delete this Track from the Play List you will not be able to use it for other stages as well!     \n\n",
                           "Stage Maker",
                           0
                        )
                        == 0) {
                     this.deltrack();
                  }
               }

               if (this.button("      Add a new Track from a file . . .     ", 330, 530, 0, false)
                  && JOptionPane.showConfirmDialog(
                        null,
                        "The game only accepts Module format music files for the game ('.mod', '.xm' and '.s3m' file extensions).\nA good place to find Module Tracks is the modarchive.com, all the current Module Tracks\nthat are distributed with the game are from the modarchive.com.\n\nTo find out more about Module Tracks and to learn how to compose & remix your own\nmusic, please read the section of the Stage Maker help about it.\n\nThe Stage Maker accepts only '.mod', '.xm' & '.s3m' files or a '.zip' file containing a Module file.\nThe file size of the Module must be less the 700KB (when compressed as a zip file).\n",
                        "Stage Maker",
                        0
                     )
                     == 0) {
                  File var172 = null;
                  FileDialog var199 = new FileDialog(new Frame(), "Stage Maker - Add MOD Track file to stage sound track play list!");
                  var199.setFile("*.mod;*.xm;*.s3m;*.zip");
                  var199.setMode(0);
                  var199.setVisible(true);

                  try {
                     if (var199.getFile() != null) {
                        var172 = new File("" + var199.getDirectory() + "" + var199.getFile() + "");
                     }
                  } catch (Exception var28) {
                  }

                  if (var172 != null) {
                     try {
                        if (var199.getFile().toLowerCase().endsWith(".mod")
                           || var199.getFile().toLowerCase().endsWith(".xm")
                           || var199.getFile().toLowerCase().endsWith(".s3m")) {
                           File var225 = new File("" + smfpath + "mystages/mymusic/");
                           if (!var225.exists()) {
                              var225.mkdirs();
                           }

                           String var241 = "" + smfpath + "mystages/mymusic/" + var172.getName().substring(0, var172.getName().length() - 4) + ".zip";
                           FileInputStream var259 = new FileInputStream(var172);
                           ZipOutputStream var272 = new ZipOutputStream(new FileOutputStream(var241));
                           ZipEntry var281 = new ZipEntry("" + var172.getName() + "");
                           var281.setSize(var172.length());
                           var272.putNextEntry(var281);
                           byte[] var289 = new byte[1024];

                           int var299;
                           while ((var299 = var259.read(var289)) > 0) {
                              var272.write(var289, 0, var299);
                           }

                           var272.closeEntry();
                           var272.close();
                           var259.close();
                           var225 = new File("" + smfpath + "mystages/mymusic/" + var172.getName() + ".zip");
                           if (var225.length() / 1024L >= 700L) {
                              JOptionPane.showMessageDialog(
                                 null, "The selected file is larger then 700KB in size when zipped and therefore cannot be added!", "Stage Maker", 1
                              );
                              var225.delete();
                           }
                        } else if (var172.length() / 1024L >= 700L) {
                           JOptionPane.showMessageDialog(
                              null, "The selected file is larger then 700KB in size and therefore cannot be added!", "Stage Maker", 1
                           );
                        } else {
                           File var223 = new File("" + smfpath + "mystages/mymusic/");
                           if (!var223.exists()) {
                              var223.mkdirs();
                           }

                           var223 = new File("" + smfpath + "mystages/mymusic/" + var172.getName() + "");
                           FileInputStream var240 = new FileInputStream(var172);
                           FileOutputStream var258 = new FileOutputStream(var223);
                           byte[] var271 = new byte[1024];

                           int var280;
                           while ((var280 = var240.read(var271)) > 0) {
                              var258.write(var271, 0, var280);
                           }

                           var240.close();
                           var258.close();
                        }

                        this.tracks.removeAll();
                        this.tracks.add(this.rd, "Select MOD Track                      ");
                        String[] var227 = new File("" + smfpath + "mystages/mymusic/").list();
                        if (var227 != null) {
                           for (int var242 = 0; var242 < var227.length; var242++) {
                              if (var227[var242].toLowerCase().endsWith(".zip")) {
                                 this.tracks.add(this.rd, var227[var242].substring(0, var227[var242].length() - 4));
                              }
                           }
                        }

                        this.tracks.select(var172.getName().substring(0, var172.getName().length() - 4));
                     } catch (Exception var34) {
                        JOptionPane.showMessageDialog(null, "Unable to copy file! Error Deatials:\n" + var34, "Stage Maker", 1);
                     }
                  }
               }

               short var173 = 200;
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawString("Sound Track", 280 + var173, 461);
               String var200 = this.trackname;
               if (!var200.equals("")) {
                  if (this.button("   <  Remove Track   ", 378, 495, 2, false)) {
                     this.trackname = "";
                  }
               } else {
                  var200 = "No Sound Track set.";
               }

               this.rd.drawString(var200, 629 - this.ftm.stringWidth(var200) / 2, 482);
               this.rd.setColor(new Color(128, 128, 128));
               this.rd.drawLine(270 + var173, 457, 277 + var173, 457);
               this.rd.drawLine(589 + var173, 457, 353 + var173, 457);
               this.rd.drawLine(270 + var173, 457, 270 + var173, 497);
               this.rd.drawLine(589 + var173, 457, 589 + var173, 497);
               this.rd.drawLine(270 + var173, 497, 589 + var173, 497);
               if (this.button(" Reset ", 576, 530, 0, true)) {
                  this.ltrackname = "";
                  this.dtabed = -2;
               }

               if (this.button("        Save        ", 663, 530, 0, true)) {
                  this.sortop();
                  this.savefile();
               }
            }

            if (this.dtab == 6) {
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.setFont(new Font("Arial", 1, 13));
               this.ftm = this.rd.getFontMetrics();
               this.rd.drawString("Test Drive the Stage", 400 - this.ftm.stringWidth("Test Drive the Stage") / 2, 470);
               this.witho.move(342, 480);
               if (!this.witho.isShowing()) {
                  this.witho.show();
               }

               if (this.button("     TEST DRIVE!     ", 400, 530, 0, true)) {
                  this.savefile();
                  this.errd = 0;
                  this.readstage(3);
                  if (this.cp.nsp < 2) {
                     this.errd = 7;
                  }

                  if (this.errd != 0) {
                     JOptionPane.showMessageDialog(
                        null, "Error!  This stage is not ready for a test drive!\nReason:\n" + this.errlo[this.errd - 1] + "\n\n", "Stage Maker", 0
                     );
                  } else {
                     Madness.testcar = this.stagename;
                     Madness.testdrive = this.witho.getSelectedIndex() + 3;
                     Madness.game();
                  }
               }
            }

            if (this.dtabed != this.dtab) {
               if (this.dtabed != -2) {
                  this.dtabed = this.dtab;
               } else {
                  this.dtabed = -1;
               }
            }
         }

         if (this.tab == 3) {
            this.rd.setFont(new Font("Arial", 1, 13));
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawString("Publish Stage :  [ " + this.stagename + " ]", 30, 50);
            this.rd.drawString("Publishing Type :", 30, 80);
            this.pubtyp.move(150, 63);
            if (!this.pubtyp.isShowing()) {
               this.pubtyp.show();
               this.pubtyp.select(1);
            }

            this.pubitem.move(790 - this.pubitem.w, 96);
            if (!this.pubitem.isShowing()) {
               this.pubitem.show();
            }

            if (this.pubitem.sel != 0) {
               boolean var45 = false;

               for (int var57 = 0; var57 < this.nms; var57++) {
                  if (this.pubitem.getSelectedItem().equals(this.mystages[var57])) {
                     var45 = true;
                  }
               }

               if (!var45) {
                  this.logged = 2;
               }
            }

            this.rd.setColor(new Color(0, 0, 0));
            this.rd.setFont(new Font("Arial", 0, 12));
            if (this.pubtyp.getSelectedIndex() == 0) {
               this.rd.drawString("Private :  This means only you can have your stage in your account and no one else can add", 268, 72);
               this.rd.drawString("it to their account to play it!", 268, 88);
            }

            if (this.pubtyp.getSelectedIndex() == 1) {
               this.rd.drawString("Public :  This means anyone can add this stage to their account to play it, but only you can", 268, 72);
               this.rd.drawString("download it to your Stage Maker and edit it (no one else but you can edit it).", 268, 88);
            }

            if (this.pubtyp.getSelectedIndex() == 2) {
               this.rd.drawString("Super Public :  This means anyone can add this stage to their account to play it and can also", 268, 72);
               this.rd.drawString("download it to their stage Maker, edit it and publish it.", 268, 88);
            }

            this.rd.setFont(new Font("Arial", 1, 12));
            this.ftm = this.rd.getFontMetrics();
            this.rd.drawString("Stage Name", 180 - this.ftm.stringWidth("Stage Name") / 2, 138);
            this.rd.drawString("Created By", 400 - this.ftm.stringWidth("Created By") / 2, 138);
            this.rd.drawString("Added By", 500 - this.ftm.stringWidth("Added By") / 2, 138);
            this.rd.drawString("Publish Type", 600 - this.ftm.stringWidth("Publish Type") / 2, 138);
            this.rd.drawString("Options", 720 - this.ftm.stringWidth("Options") / 2, 138);
            this.rd.drawLine(350, 129, 350, 140);
            this.rd.drawLine(450, 129, 450, 140);
            this.rd.drawLine(550, 129, 550, 140);
            this.rd.drawLine(650, 129, 650, 140);
            this.rd.drawRect(10, 140, 780, 402);
            if (this.button("       Publish  >       ", 102, 110, 0, true)) {
               if (this.logged == 0) {
                  JOptionPane.showMessageDialog(null, "Please login to retrieve your account first before publishing!", "Stage Maker", 1);
               }

               if (this.logged == 3 || this.logged == -1) {
                  this.savefile();
                  this.errd = 0;
                  this.readstage(3);
                  if (this.cp.nsp < 2) {
                     this.errd = 7;
                  }

                  this.rd.setFont(new Font("Arial", 1, 12));
                  this.ftm = this.rd.getFontMetrics();
                  if (this.ftm.stringWidth(this.stagename) > 274) {
                     this.errd = 8;
                  }

                  if (this.errd != 0) {
                     JOptionPane.showMessageDialog(
                        null, "Error!  This stage is not ready for publishing!\nReason:\n" + this.errlo[this.errd - 1] + "\n\n", "Stage Maker", 0
                     );
                  } else {
                     int var46 = 0;

                     for (int var58 = 0; var58 < this.pubitem.no; var58++) {
                        if (this.pubitem.opts[var58].equals(this.stagename)) {
                           var46 = JOptionPane.showConfirmDialog(
                              null, "Replace your already online stage '" + this.stagename + "' with this one?", "Stage Maker", 0
                           );
                        }
                     }

                     if (var46 == 0) {
                        this.setCursor(new Cursor(3));
                        this.rd.setFont(new Font("Arial", 1, 13));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.setColor(new Color(225, 225, 225));
                        this.rd.fillRect(11, 141, 779, 401);
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawString("Connecting to Server...", 400 - this.ftm.stringWidth("Connecting to Server...") / 2, 250);
                        this.repaint();
                        this.justpubd = this.stagename;
                        int var59 = -1;

                        try {
                           Socket var73 = new Socket("69.195.146.194", 7061);
                           BufferedReader var101 = new BufferedReader(new InputStreamReader(var73.getInputStream()));
                           PrintWriter var127 = new PrintWriter(var73.getOutputStream(), true);
                           DataOutputStream var147 = null;
                           var127.println(
                              "20|" + this.tnick.getText() + "|" + this.tpass.getText() + "|" + this.stagename + "|" + this.pubtyp.getSelectedIndex() + "|"
                           );
                           String var174 = var101.readLine();
                           if (var174 != null) {
                              var59 = this.servervalue(var174, 0);
                           }

                           if (var59 == 0) {
                              String var201 = " Publishing Stage ";
                              String var228 = "" + this.tstage + "\r\n" + this.bstage + "";
                              DataInputStream var243 = new DataInputStream(new ByteArrayInputStream(var228.getBytes()));
                              String var260 = null;

                              while ((var260 = var243.readLine()) != null) {
                                 var260 = var260.trim();
                                 var127.println(var260);
                                 this.rd.setColor(new Color(225, 225, 225));
                                 this.rd.fillRect(11, 141, 779, 401);
                                 this.rd.setColor(new Color(0, 0, 0));
                                 this.rd.drawString(var201, 400 - this.ftm.stringWidth(var201) / 2, 250);
                                 var201 = "| " + var201 + " |";
                                 if (var201.equals(
                                    "| | | | | | | | | | | | | | | | | | | | | | | |  Publishing Stage  | | | | | | | | | | | | | | | | | | | | | | | |"
                                 )) {
                                    var201 = " Publishing Stage ";
                                 }

                                 this.repaint();

                                 try {
                                    Thread.sleep(10L);
                                 } catch (InterruptedException var27) {
                                 }
                              }

                              var127.println("QUITX1111");
                              this.rd.setColor(new Color(225, 225, 225));
                              this.rd.fillRect(11, 141, 779, 401);
                              this.rd.setColor(new Color(0, 0, 0));
                              this.rd.drawString("Creating the stage online...", 400 - this.ftm.stringWidth("Creating the stage online...") / 2, 250);
                              this.rd
                                 .drawString(
                                    "This may take a couple of minutes, please wait...",
                                    400 - this.ftm.stringWidth("This may take a couple of minutes, please wait...") / 2,
                                    280
                                 );
                              this.repaint();
                              var174 = var101.readLine();
                              if (var174 == null) {
                                 var59 = -1;
                              } else {
                                 var59 = this.servervalue(var174, 0);
                              }

                              if (var59 == 0) {
                                 this.rd.setColor(new Color(225, 225, 225));
                                 this.rd.fillRect(11, 141, 779, 401);
                                 this.rd.setColor(new Color(0, 0, 0));
                                 this.rd
                                    .drawString("Uploading stage's sound track...", 400 - this.ftm.stringWidth("Uploading Stage's Sound Track...") / 2, 250);
                                 this.rd
                                    .drawString(
                                       "This may take a couple of minutes, please wait...",
                                       400 - this.ftm.stringWidth("This may take a couple of minutes, please wait...") / 2,
                                       280
                                    );
                                 this.repaint();
                                 File var273 = new File("" + smfpath + "mystages/mymusic/" + this.trackname + ".zip");
                                 if (!this.trackname.equals("") && var273.exists()) {
                                    int var282 = (int)var273.length();
                                    var127.println("track|" + this.trackname + "|" + var282 + "|");
                                    var174 = var101.readLine();
                                    if (var174 == null) {
                                       var59 = -2;
                                    } else {
                                       var59 = this.servervalue(var174, 0);
                                    }

                                    if (var59 == 0) {
                                       FileInputStream var290 = new FileInputStream(var273);
                                       byte[] var300 = new byte[var282];
                                       var290.read(var300);
                                       var290.close();
                                       var147 = new DataOutputStream(var73.getOutputStream());
                                       var147.write(var300, 0, var282);
                                       var174 = var101.readLine();
                                       if (var174 == null) {
                                          var59 = -2;
                                       } else {
                                          var59 = this.servervalue(var174, 0);
                                       }
                                    }

                                    if (var59 == -67) {
                                       var59 = 0;
                                    }
                                 } else {
                                    var127.println("END");
                                    var174 = var101.readLine();
                                 }
                              }
                           }

                           var73.close();
                        } catch (Exception var38) {
                           var59 = -1;
                        }

                        this.setCursor(new Cursor(0));
                        boolean var74 = false;
                        if (var59 == 0) {
                           this.logged = 1;
                           var74 = true;
                        }

                        if (var59 == 3) {
                           JOptionPane.showMessageDialog(null, "Unable to publish stage.\nReason:\n" + this.errlo[8] + "\n\n", "Stage Maker", 1);
                           var74 = true;
                        }

                        if (var59 == 4) {
                           JOptionPane.showMessageDialog(
                              null,
                              "Unable to publish stage.\nReason:\nStage name used ("
                                 + this.stagename
                                 + ").\nThe name '"
                                 + this.stagename
                                 + "' is already used by another published stage.\nPlease rename your stage.\n\n",
                              "Stage Maker",
                              1
                           );
                           var74 = true;
                        }

                        if (var59 == 5) {
                           JOptionPane.showMessageDialog(null, "Unable to create stage online!  Unknown Error.  Please try again later.", "Stage Maker", 1);
                           var74 = true;
                        }

                        if (var59 > 5) {
                           JOptionPane.showMessageDialog(null, "Unable to publish stage fully!  Unknown Error.  Please try again later.", "Stage Maker", 1);
                           var74 = true;
                        }

                        if (var59 == -4) {
                           this.logged = 1;
                           JOptionPane.showMessageDialog(
                              null,
                              "Unable to upload sound track!\nReason:\nAnother MOD Track is already uploaded with the same name, please rename your Track.\nOpen your 'mystages' folder then open 'mymusic' to find your MOD Track to rename it.\n\n",
                              "Stage Maker",
                              1
                           );
                           var74 = true;
                        }

                        if (var59 == -3) {
                           this.logged = 1;
                           JOptionPane.showMessageDialog(
                              null,
                              "Unable to upload sound track!\nReason:\nYour MOD Track’s file size is too large, Track file size must be less then 700KB to be accepted.\n\n",
                              "Stage Maker",
                              1
                           );
                           var74 = true;
                        }

                        if (var59 == -2) {
                           this.logged = 1;
                           JOptionPane.showMessageDialog(null, "Unable to upload sound track!  Unknown Error.  Please try again later.", "Stage Maker", 1);
                           var74 = true;
                        }

                        if (!var74) {
                           JOptionPane.showMessageDialog(null, "Unable to publish stage!  Unknown Error.", "Stage Maker", 1);
                        }
                     }
                  }
               }
            }

            if (this.logged == 3) {
               for (int var47 = 0; var47 < this.nms; var47++) {
                  this.rd.setColor(new Color(235, 235, 235));
                  if (this.xm > 11 && this.xm < 789 && this.ym > 142 + var47 * 20 && this.ym < 160 + var47 * 20) {
                     this.rd.setColor(new Color(255, 255, 255));
                  }

                  this.rd.fillRect(11, 142 + var47 * 20, 778, 18);
                  this.rd.setFont(new Font("Arial", 0, 12));
                  this.ftm = this.rd.getFontMetrics();
                  this.rd.setColor(new Color(0, 0, 0));
                  this.rd.drawString(this.mystages[var47], 180 - this.ftm.stringWidth(this.mystages[var47]) / 2, 156 + var47 * 20);
                  this.rd.setColor(new Color(155, 155, 155));
                  this.rd.drawLine(350, 145 + var47 * 20, 350, 157 + var47 * 20);
                  if (this.pubt[var47] == -1) {
                     this.rd
                        .drawString(
                           "-    Error Loading this stage's info!    -",
                           550 - this.ftm.stringWidth("-    Error Loading this stage's info!    -") / 2,
                           156 + var47 * 20
                        );
                  } else {
                     this.rd.drawLine(450, 145 + var47 * 20, 450, 157 + var47 * 20);
                     this.rd.drawLine(550, 145 + var47 * 20, 550, 157 + var47 * 20);
                     this.rd.drawLine(650, 145 + var47 * 20, 650, 157 + var47 * 20);
                     boolean var60 = false;
                     if (!this.maker[var47].toLowerCase().equals(this.tnick.getText().toLowerCase())) {
                        this.rd.setColor(new Color(0, 0, 64));
                        this.rd.drawString(this.maker[var47], 400 - this.ftm.stringWidth(this.maker[var47]) / 2, 156 + var47 * 20);
                     } else {
                        var60 = true;
                        this.rd.setColor(new Color(0, 64, 0));
                        this.rd.drawString("You", 400 - this.ftm.stringWidth("You") / 2, 156 + var47 * 20);
                     }

                     if (this.nad[var47] <= 1) {
                        this.rd.setColor(new Color(0, 0, 64));
                        this.rd.drawString("None", 500 - this.ftm.stringWidth("None") / 2, 156 + var47 * 20);
                     } else if (this.ovbutton("" + this.nad[var47] + " Players", 500, 156 + var47 * 20)) {
                        String var75 = "[ " + this.mystages[var47] + " ]  has been added by the following players to their accounts:     \n\n";
                        int var102 = 0;

                        for (int var128 = 0; var128 < this.nad[var47]; var128++) {
                           if (++var102 == 17) {
                              var75 = var75 + "\n";
                              var102 = 1;
                           }

                           var75 = var75 + this.addeda[var47][var128];
                           if (var128 != this.nad[var47] - 1) {
                              if (var128 == this.nad[var47] - 2) {
                                 if (var102 != 16) {
                                    var75 = var75 + " and ";
                                 } else {
                                    var75 = var75 + "\nand ";
                                    var102 = 0;
                                 }
                              } else {
                                 var75 = var75 + ", ";
                              }
                           }
                        }

                        var75 = var75 + "\n \n \n";
                        JOptionPane.showMessageDialog(null, var75, "Stage Maker", 1);
                     }

                     if (this.pubt[var47] == 0) {
                        this.rd.setColor(new Color(0, 0, 64));
                        this.rd.drawString("Private", 600 - this.ftm.stringWidth("Private") / 2, 156 + var47 * 20);
                     }

                     if (this.pubt[var47] == 1) {
                        this.rd.setColor(new Color(0, 0, 64));
                        this.rd.drawString("Public", 600 - this.ftm.stringWidth("Public") / 2, 156 + var47 * 20);
                     }

                     if (this.pubt[var47] == 2) {
                        this.rd.setColor(new Color(0, 64, 0));
                        this.rd.drawString("Super Public", 600 - this.ftm.stringWidth("Super Public") / 2, 156 + var47 * 20);
                     }

                     if ((this.pubt[var47] == 2 || var60) && this.ovbutton("Download", 700, 156 + var47 * 20)) {
                        int var77 = 0;

                        for (int var103 = 0; var103 < this.slstage.getItemCount(); var103++) {
                           if (this.mystages[var47].equals(this.slstage.getItem(var103))) {
                              var77 = JOptionPane.showConfirmDialog(
                                 null,
                                 "Replace the local " + this.mystages[var47] + " in your 'mystages' folder with the published online copy?",
                                 "Stage Maker",
                                 0
                              );
                           }
                        }

                        if (var77 == 0) {
                           this.setCursor(new Cursor(3));
                           this.rd.setFont(new Font("Arial", 1, 13));
                           this.ftm = this.rd.getFontMetrics();
                           this.rd.setColor(new Color(225, 225, 225));
                           this.rd.fillRect(11, 141, 779, 401);
                           this.rd.setColor(new Color(0, 0, 0));
                           this.rd.drawString("Downloading stage, please wait...", 400 - this.ftm.stringWidth("Downloading stage, please wait...") / 2, 250);
                           this.repaint();

                           try {
                              String var104 = "http://multiplayer.needformadness.com/tracks/"
                                 + this.mystages[var47]
                                 + ".radq?reqlo="
                                 + (int)(Math.random() * 1000.0)
                                 + "";
                              var104 = var104.replace(' ', '_');
                              URL var129 = new URL(var104);
                              int var179 = var129.openConnection().getContentLength();
                              DataInputStream var202 = new DataInputStream(var129.openStream());
                              byte[] var229 = new byte[var179];
                              var202.readFully(var229);
                              var202.close();
                              ZipInputStream var149;
                              if (var229[0] == 80 && var229[1] == 75 && var229[2] == 3) {
                                 var149 = new ZipInputStream(new ByteArrayInputStream(var229));
                              } else {
                                 byte[] var244 = new byte[var179 - 40];

                                 for (int var263 = 0; var263 < var179 - 40; var263++) {
                                    byte var274 = 20;
                                    if (var263 >= 500) {
                                       var274 = 40;
                                    }

                                    var244[var263] = var229[var263 + var274];
                                 }

                                 var149 = new ZipInputStream(new ByteArrayInputStream(var244));
                              }

                              ZipEntry var245 = var149.getNextEntry();
                              if (var245 == null) {
                                 JOptionPane.showMessageDialog(
                                    null, "Unable to download stage.  Unknown Error!     \nPlease try again later.", "Stage Maker", 1
                                 );
                              } else {
                                 String var264 = "";
                                 int var275 = Integer.valueOf(var245.getName());
                                 byte[] var283 = new byte[var275];
                                 int var291 = 0;

                                 while (var275 > 0) {
                                    int var301 = var149.read(var283, var291, var275);
                                    var291 += var301;
                                    var275 -= var301;
                                 }

                                 String var305 = new String(var283);
                                 var305 = var305 + "\n";
                                 String var308 = "";
                                 int var18 = 0;
                                 int var19 = var305.indexOf("\n", 0);

                                 while (var19 != -1 && var18 < var305.length()) {
                                    String var20 = var305.substring(var18, var19);
                                    var20 = var20.trim();
                                    var18 = var19 + 1;
                                    var19 = var305.indexOf("\n", var18);
                                    if (!var20.startsWith("stagemaker(") && !var20.startsWith("publish(")) {
                                       var308 = var308 + "" + var20 + "\r\n";
                                    } else {
                                       var308 = var308.trim();
                                       var308 = var308 + "\r\n";
                                    }

                                    if (var20.startsWith("soundtrack")) {
                                       var264 = this.getstring("soundtrack", var20, 0);
                                    }
                                 }

                                 var308 = var308.trim();
                                 var308 = var308 + "\r\n\r\n";
                                 File var313 = new File("" + smfpath + "mystages/");
                                 if (!var313.exists()) {
                                    var313.mkdirs();
                                 }

                                 var313 = new File("" + smfpath + "mystages/" + this.mystages[var47] + ".txt");
                                 BufferedWriter var21 = new BufferedWriter(new FileWriter(var313));
                                 var21.write(var308);
                                 var21.close();
                                 Object var316 = null;
                                 var149.close();
                                 if (!var264.equals("")) {
                                    try {
                                       this.rd.setColor(new Color(0, 0, 0));
                                       this.rd
                                          .drawString(
                                             "Downloading stage's sound track...", 400 - this.ftm.stringWidth("Downloading stage's sound track...") / 2, 280
                                          );
                                       this.repaint();
                                       var104 = "http://multiplayer.needformadness.com/tracks/music/" + var264 + ".zip";
                                       var104 = var104.replace(' ', '_');
                                       var129 = new URL(var104);
                                       var179 = var129.openConnection().getContentLength();
                                       var313 = new File("" + smfpath + "mystages/mymusic/" + var264 + ".zip");
                                       if (var313.exists()) {
                                          if (var313.length() != var179) {
                                             var77 = JOptionPane.showConfirmDialog(
                                                null,
                                                "Another track named '"
                                                   + var264
                                                   + "' already exists in your Sound Tracks folder!\nReplace it with the one attached to this stage?",
                                                "Stage Maker",
                                                0
                                             );
                                          } else {
                                             var77 = 1;
                                          }
                                       }

                                       if (var77 == 0) {
                                          var202 = new DataInputStream(var129.openStream());
                                          var229 = new byte[var179];
                                          var202.readFully(var229);
                                          var202.close();
                                          FileOutputStream var22 = new FileOutputStream(var313);
                                          var22.write(var229);
                                          var22.close();
                                          Object var317 = null;
                                       }
                                    } catch (Exception var26) {
                                    }
                                 }

                                 this.setCursor(new Cursor(0));
                                 JOptionPane.showMessageDialog(null, "" + this.mystages[var47] + " has been successfully downloaded!", "Stage Maker", 1);
                              }
                           } catch (Exception var37) {
                              JOptionPane.showMessageDialog(null, "Unable to download stage.  Unknown Error!     \nPlease try again later.", "Stage Maker", 1);
                           }
                        }
                     }
                  }

                  if (this.ovbutton("X", 765, 156 + var47 * 20)
                     && JOptionPane.showConfirmDialog(null, "Remove " + this.mystages[var47] + " from your account?", "Stage Maker", 0) == 0) {
                     this.setCursor(new Cursor(3));
                     int var61 = -1;

                     try {
                        Socket var78 = new Socket("69.195.146.194", 7061);
                        BufferedReader var108 = new BufferedReader(new InputStreamReader(var78.getInputStream()));
                        PrintWriter var131 = new PrintWriter(var78.getOutputStream(), true);
                        var131.println("19|" + this.tnick.getText() + "|" + this.tpass.getText() + "|" + this.mystages[var47] + "|");
                        String var150 = var108.readLine();
                        if (var150 != null) {
                           var61 = this.servervalue(var150, 0);
                        }

                        var78.close();
                     } catch (Exception var25) {
                        var61 = -1;
                     }

                     if (var61 != 0) {
                        this.setCursor(new Cursor(0));
                        JOptionPane.showMessageDialog(
                           null,
                           "Failed to remove " + this.mystages[var47] + " from your account.  Unknown Error!     \nPlease try again later.",
                           "Stage Maker",
                           1
                        );
                     } else {
                        this.logged = 1;
                     }
                  }
               }
            }

            if (this.logged == 2) {
               this.mystages[this.roto] = this.pubitem.getSelectedItem();
               this.rd.setFont(new Font("Arial", 1, 13));
               this.ftm = this.rd.getFontMetrics();
               this.rd.setColor(new Color(225, 225, 225));
               this.rd.fillRect(50, 150, 600, 150);
               this.rd.setColor(new Color(0, 0, 0));
               this.rd
                  .drawString(
                     "Loading " + this.mystages[this.roto] + "‘s info...",
                     400 - this.ftm.stringWidth("Loading " + this.mystages[this.roto] + "‘s info...") / 2,
                     220
                  );
               this.repaint();
               this.maker[this.roto] = "Unkown";
               this.pubt[this.roto] = -1;
               this.nad[this.roto] = 0;
               String var48 = "";

               try {
                  String var62 = "http://multiplayer.needformadness.com/tracks/"
                     + this.mystages[this.roto]
                     + ".txt?reqlo="
                     + (int)(Math.random() * 1000.0)
                     + "";
                  var62 = var62.replace(' ', '_');
                  URL var79 = new URL(var62);
                  DataInputStream var109 = new DataInputStream(var79.openStream());

                  while ((var48 = var109.readLine()) != null) {
                     var48 = "" + var48.trim();
                     if (var48.startsWith("details")) {
                        this.maker[this.roto] = this.getSvalue("details", var48, 0);
                        this.pubt[this.roto] = this.getvalue("details", var48, 1);
                        boolean var132 = false;

                        while (!var132) {
                           this.addeda[this.roto][this.nad[this.roto]] = this.getSvalue("details", var48, 2 + this.nad[this.roto]);
                           if (!this.addeda[this.roto][this.nad[this.roto]].equals("")) {
                              this.nad[this.roto]++;
                           } else {
                              var132 = true;
                           }
                        }
                     }
                  }

                  this.nms++;
                  if (this.nms > 20) {
                     this.nms = 20;
                  }

                  this.roto++;
                  if (this.roto >= 20) {
                     this.roto = 0;
                  }
               } catch (Exception var36) {
               }

               this.setCursor(new Cursor(0));
               this.logged = 3;
            }

            if (this.logged == -1) {
               this.rd.setFont(new Font("Arial", 1, 13));
               this.ftm = this.rd.getFontMetrics();
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawString("Ready to publish...", 400 - this.ftm.stringWidth("Ready to publish...") / 2, 220);
               this.rd
                  .drawString(
                     "Click ‘Publish’ above to add stage: '" + this.stagename + "'.",
                     400 - this.ftm.stringWidth("Click ‘Publish’ above to add stage: '" + this.stagename + "'.") / 2,
                     280
                  );
            }

            if (this.logged == 1) {
               this.rd.setColor(new Color(225, 225, 225));
               this.rd.fillRect(11, 141, 779, 401);
               this.rd.setFont(new Font("Arial", 1, 13));
               this.ftm = this.rd.getFontMetrics();
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawString("Loading your account's stage list...", 400 - this.ftm.stringWidth("Loading your account's stage list...") / 2, 220);
               this.repaint();
               this.pubitem.removeAll();
               this.pubitem.add(this.rd, "Account Stage");
               this.nms = 0;
               this.roto = 0;
               int var51 = 0;
               String var64 = "";

               try {
                  URL var80 = new URL(
                     "http://multiplayer.needformadness.com/tracks/lists/" + this.tnick.getText() + ".txt?reqlo=" + (int)(Math.random() * 1000.0) + ""
                  );
                  DataInputStream var111 = new DataInputStream(var80.openStream());

                  while ((var64 = var111.readLine()) != null) {
                     var64 = "" + var64.trim();
                     if (var64.startsWith("mystages")) {
                        boolean var133 = true;

                        while (var133 && var51 < 700) {
                           String var151 = this.getSvalue("mystages", var64, var51);
                           if (!var151.equals("")) {
                              this.pubitem.add(this.rd, var151);
                              var51++;
                           } else {
                              var133 = false;
                           }
                        }
                     }
                  }

                  this.setCursor(new Cursor(0));
                  this.logged = -1;
                  var111.close();
               } catch (Exception var35) {
                  String var110 = "" + var35;
                  if (var110.indexOf("FileNotFound") == -1) {
                     this.logged = 0;
                     JOptionPane.showMessageDialog(null, "Unable to connect to server at this moment, please try again later.", "Stage Maker", 1);
                  } else {
                     this.setCursor(new Cursor(0));
                     this.logged = -1;
                  }
               }

               if (!this.justpubd.equals("")) {
                  this.pubitem.select(this.justpubd);
                  this.justpubd = "";
               }
            }

            if (this.logged == 0) {
               this.rd.setFont(new Font("Arial", 1, 13));
               this.ftm = this.rd.getFontMetrics();
               this.rd.drawString("Login to Retrieve your Account Stages", 400 - this.ftm.stringWidth("Login to Retrieve your Account Stages") / 2, 220);
               this.rd.drawString("Nickname:", 376 - this.ftm.stringWidth("Nickname:") - 14, 266);
               if (!this.tnick.isShowing()) {
                  this.tnick.show();
               }

               this.movefield(this.tnick, 376, 250, 129, 23);
               this.rd.drawString("Password:", 376 - this.ftm.stringWidth("Password:") - 14, 296);
               if (!this.tpass.isShowing()) {
                  this.tpass.show();
               }

               this.movefield(this.tpass, 376, 280, 129, 23);
               if (this.button("       Login       ", 400, 340, 0, true)) {
                  this.setCursor(new Cursor(3));
                  int var52 = -1;

                  try {
                     Socket var67 = new Socket("69.195.146.194", 7061);
                     BufferedReader var81 = new BufferedReader(new InputStreamReader(var67.getInputStream()));
                     PrintWriter var112 = new PrintWriter(var67.getOutputStream(), true);
                     var112.println("1|" + this.tnick.getText().toLowerCase() + "|" + this.tpass.getText() + "|");
                     String var134 = var81.readLine();
                     if (var134 != null) {
                        var52 = this.servervalue(var134, 0);
                     }

                     var67.close();
                  } catch (Exception var24) {
                     var52 = -1;
                  }

                  if (var52 == 0 || var52 == 3 || var52 > 10) {
                     this.tnick.hide();
                     this.tpass.hide();
                     this.logged = 1;
                     this.savesettings();
                  }

                  if (var52 == 1 || var52 == 2) {
                     this.setCursor(new Cursor(0));
                     JOptionPane.showMessageDialog(null, "Sorry.  Incorrect Nickname or Password!", "Stage Maker", 0);
                  }

                  if (var52 == -167) {
                     this.setCursor(new Cursor(0));
                     JOptionPane.showMessageDialog(
                        null, "Sorry.  Your trial account cannot publish stages.  Please upgrade to a full account!   ", "Stage Maker", 0
                     );
                  }

                  if (var52 == -1) {
                     this.setCursor(new Cursor(0));
                     JOptionPane.showMessageDialog(null, "Unable to connect to server at this moment, please try again later.", "Stage Maker", 1);
                  }
               }

               this.rd.setFont(new Font("Arial", 1, 13));
               this.ftm = this.rd.getFontMetrics();
               this.rd
                  .drawString(
                     "Register a full account or if you have a trial account upgrade it!",
                     400 - this.ftm.stringWidth("Register a full account or if you have a trial account upgrade it!") / 2,
                     450
                  );
               if (this.button("   Register!   ", 340, 480, 0, true)) {
                  Madness.openurl("http://multiplayer.needformadness.com/register.html?ref=game");
               }

               if (this.button("   Upgrade!   ", 460, 480, 0, true)) {
                  Madness.openurl("http://multiplayer.needformadness.com/edit.pl");
               }

               this.rd.setFont(new Font("Arial", 0, 12));
               this.ftm = this.rd.getFontMetrics();
               this.rd
                  .drawString(
                     "You need a full account to publish your stages to the multiplayer game!",
                     400 - this.ftm.stringWidth("You need a full account to publish your stages to the multiplayer game!") / 2,
                     505
                  );
            }
         }

         if (this.tabed != this.tab) {
            if (this.tabed != -2) {
               this.tabed = this.tab;
            } else {
               this.tabed = -1;
            }
         }

         this.rd.setColor(new Color(0, 0, 0));
         this.rd.fillRect(0, 0, 800, 25);
         if (this.onbtgame) {
            this.rd.drawImage(this.btgame[1], 620, 0, null);
         } else {
            this.rd.drawImage(this.btgame[0], 620, 0, null);
         }

         this.rd.setFont(new Font("Arial", 1, 13));
         this.ftm = this.rd.getFontMetrics();
         String[] var53 = new String[]{"Stage", "Build", "View & Edit", "Publish"};
         int[] var68 = new int[]{0, 0, 100, 90};
         int[] var82 = new int[]{0, 25, 25, 0};
         byte var113 = 4;
         if (this.stagename.equals("") || this.sfase != 0) {
            this.tab = 0;
            var113 = 1;
         }

         for (int var135 = 0; var135 < var113; var135++) {
            this.rd.setColor(new Color(170, 170, 170));
            if (this.xm > var68[0] && this.xm < var68[3] && this.ym > 0 && this.ym < 25) {
               this.rd.setColor(new Color(200, 200, 200));
            }

            if (this.tab == var135) {
               this.rd.setColor(new Color(225, 225, 225));
            }

            this.rd.fillPolygon(var68, var82, 4);
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawString(var53[var135], var135 * 100 + 45 - this.ftm.stringWidth(var53[var135]) / 2, 17);
            if (this.xm > var68[0] && this.xm < var68[3] && this.ym > 0 && this.ym < 25 && this.mouses == -1) {
               this.tab = var135;
            }

            for (int var152 = 0; var152 < 4; var152++) {
               var68[var152] += 100;
            }
         }

         if (this.mouses == -1) {
            this.mouses = 0;
         }

         this.drawms();
         this.repaint();
         if (!this.exwist) {
            try {
               Thread.sleep(40L);
            } catch (InterruptedException var23) {
            }
         }
      }

      this.track.unload();
      this.track = null;
      this.rd.dispose();
      System.gc();
      if (Madness.endadv == 2) {
         Madness.advopen();
      }
   }

   public void removesp() {
      if (this.nundo < 5000) {
         this.undos[this.nundo] = this.bstage;
         this.nundo++;
      }

      String var1 = "";
      if (this.co[this.esp].colok != 30 && this.co[this.esp].colok != 31 && this.co[this.esp].colok != 32 && this.co[this.esp].colok != 66) {
         var1 = "set(" + (this.co[this.esp].colok + 10) + "," + this.co[this.esp].x + "," + this.co[this.esp].z + "," + this.co[this.esp].roofat + ")";
      }

      if (this.co[this.esp].colok == 31) {
         var1 = "fix("
            + (this.co[this.esp].colok + 10)
            + ","
            + this.co[this.esp].x
            + ","
            + this.co[this.esp].z
            + ","
            + this.co[this.esp].y
            + ","
            + this.co[this.esp].roofat
            + ")";
      }

      if (this.co[this.esp].colok == 30 || this.co[this.esp].colok == 32) {
         var1 = "chk(" + (this.co[this.esp].colok + 10) + "," + this.co[this.esp].x + "," + this.co[this.esp].z + "," + this.co[this.esp].roofat + ")";
      }

      if (this.co[this.esp].colok == 54) {
         var1 = "chk("
            + (this.co[this.esp].colok + 10)
            + ","
            + this.co[this.esp].x
            + ","
            + this.co[this.esp].z
            + ","
            + this.co[this.esp].roofat
            + ","
            + this.co[this.esp].y
            + ")";
      }

      if (this.co[this.esp].colok == 66) {
         var1 = "pile("
            + this.co[this.esp].srz
            + ","
            + this.co[this.esp].srx
            + ","
            + this.co[this.esp].sry
            + ","
            + this.co[this.esp].x
            + ","
            + this.co[this.esp].z
            + ")";
      }

      int var2 = this.bstage.indexOf(var1);
      int var3 = var2 + var1.length();
      int var4 = -1;
      int var5 = this.bstage.indexOf("set", var3);
      if (var5 != -1) {
         var4 = var5;
      }

      var5 = this.bstage.indexOf("chk", var3);
      if (var5 != -1 && var5 < var4) {
         var4 = var5;
      }

      var5 = this.bstage.indexOf("fix", var3);
      if (var5 != -1 && var5 < var4) {
         var4 = var5;
      }

      if (var4 == -1) {
         var4 = this.bstage.indexOf("\r\n", var3);
         if (var4 != -1) {
            var4++;
         }
      }

      if (var4 != -1) {
         var3 = var4;
      }

      if (var2 != -1) {
         this.bstage = "" + this.bstage.substring(0, var2) + "" + this.bstage.substring(var3, this.bstage.length()) + "";
      }

      this.readstage(0);
   }

   public void copyesp(boolean var1) {
      this.sp = this.co[this.esp].colok;
      this.rot = this.co[this.esp].roofat;
      if (this.sp == 2) {
         this.rot -= 30;
      }

      if (this.sp == 3) {
         this.rot += 30;
      }

      if (this.sp == 15) {
         this.rot += 90;
      }

      if (this.sp == 20) {
         this.rot += 180;
      }

      if (this.sp == 26) {
         this.rot -= 90;
      }

      if (this.sp == 0) {
         this.sptyp = 0;
         this.spart = 0;
      }

      if (this.sp == 4) {
         this.sptyp = 0;
         this.spart = 1;
      }

      if (this.sp == 13) {
         this.sptyp = 0;
         this.spart = 2;
      }

      if (this.sp == 3) {
         this.sptyp = 0;
         this.spart = 3;
      }

      if (this.sp == 2) {
         this.sptyp = 0;
         this.spart = 4;
      }

      if (this.sp == 1) {
         this.sptyp = 0;
         this.spart = 5;
      }

      if (this.sp == 35) {
         this.sptyp = 0;
         this.spart = 6;
      }

      if (this.sp == 36) {
         this.sptyp = 0;
         this.spart = 7;
      }

      if (this.sp == 10) {
         this.sptyp = 0;
         this.spart = 8;
      }

      if (this.sp == 5) {
         this.sptyp = 0;
         this.spart = 9;
      }

      if (this.sp == 7) {
         this.sptyp = 0;
         this.spart = 10;
      }

      if (this.sp == 14) {
         this.sptyp = 0;
         this.spart = 11;
      }

      if (this.sp == 6) {
         this.sptyp = 0;
         this.spart = 12;
      }

      if (this.sp == 34) {
         this.sptyp = 0;
         this.spart = 13;
      }

      if (this.sp == 33) {
         this.sptyp = 0;
         this.spart = 14;
      }

      if (this.sp == 11) {
         this.sptyp = 0;
         this.spart = 15;
      }

      if (this.sp == 8) {
         this.sptyp = 0;
         this.spart = 16;
      }

      if (this.sp == 9) {
         this.sptyp = 0;
         this.spart = 17;
      }

      if (this.sp == 15) {
         this.sptyp = 0;
         this.spart = 18;
      }

      if (this.sp == 12) {
         this.sptyp = 0;
         this.spart = 19;
      }

      if (this.sp == 46) {
         this.sptyp = 0;
         this.spart = 20;
      }

      if (this.sp == 47) {
         this.sptyp = 0;
         this.spart = 21;
      }

      if (this.sp == 48) {
         this.sptyp = 0;
         this.spart = 23;
      }

      if (this.sp == 49) {
         this.sptyp = 0;
         this.spart = 24;
      }

      if (this.sp == 50) {
         this.sptyp = 0;
         this.spart = 22;
      }

      if (this.sp == 51) {
         this.sptyp = 0;
         this.spart = 25;
      }

      if (this.sp == 16) {
         this.sptyp = 1;
         this.spart = 0;
      }

      if (this.sp == 18) {
         this.sptyp = 1;
         this.spart = 1;
      }

      if (this.sp == 19) {
         this.sptyp = 1;
         this.spart = 2;
      }

      if (this.sp == 22) {
         this.sptyp = 1;
         this.spart = 3;
      }

      if (this.sp == 17) {
         this.sptyp = 1;
         this.spart = 4;
      }

      if (this.sp == 21) {
         this.sptyp = 1;
         this.spart = 5;
      }

      if (this.sp == 20) {
         this.sptyp = 1;
         this.spart = 6;
      }

      if (this.sp == 39) {
         this.sptyp = 1;
         this.spart = 7;
      }

      if (this.sp == 42) {
         this.sptyp = 1;
         this.spart = 8;
      }

      if (this.sp == 40) {
         this.sptyp = 1;
         this.spart = 9;
      }

      if (this.sp == 23) {
         this.sptyp = 1;
         this.spart = 10;
      }

      if (this.sp == 25) {
         this.sptyp = 1;
         this.spart = 11;
      }

      if (this.sp == 24) {
         this.sptyp = 1;
         this.spart = 12;
      }

      if (this.sp == 43) {
         this.sptyp = 1;
         this.spart = 13;
      }

      if (this.sp == 45) {
         this.sptyp = 1;
         this.spart = 14;
      }

      if (this.sp == 26) {
         this.sptyp = 1;
         this.spart = 15;
      }

      if (this.sp == 27) {
         this.sptyp = 2;
         this.spart = 0;
      }

      if (this.sp == 28) {
         this.sptyp = 2;
         this.spart = 1;
      }

      if (this.sp == 41) {
         this.sptyp = 2;
         this.spart = 2;
      }

      if (this.sp == 44) {
         this.sptyp = 2;
         this.spart = 3;
      }

      if (this.sp == 52) {
         this.sptyp = 2;
         this.spart = 4;
      }

      if (this.sp == 53) {
         this.sptyp = 2;
         this.spart = 5;
      }

      if (this.sp == 30 || this.sp == 32 || this.sp == 54) {
         this.sptyp = 3;
         this.spart = 0;
      }

      if (this.sp == 31) {
         this.sptyp = 4;
         this.spart = 0;
      }

      if (this.sp == 55) {
         this.sptyp = 5;
         this.spart = 0;
      }

      if (this.sp == 56) {
         this.sptyp = 5;
         this.spart = 1;
      }

      if (this.sp == 57) {
         this.sptyp = 5;
         this.spart = 2;
      }

      if (this.sp == 58) {
         this.sptyp = 5;
         this.spart = 3;
      }

      if (this.sp == 59) {
         this.sptyp = 5;
         this.spart = 4;
      }

      if (this.sp == 60) {
         this.sptyp = 5;
         this.spart = 5;
      }

      if (this.sp == 61) {
         this.sptyp = 5;
         this.spart = 6;
      }

      if (this.sp == 62) {
         this.sptyp = 5;
         this.spart = 7;
      }

      if (this.sp == 63) {
         this.sptyp = 5;
         this.spart = 8;
      }

      if (this.sp == 64) {
         this.sptyp = 5;
         this.spart = 9;
      }

      if (this.sp == 65) {
         this.sptyp = 5;
         this.spart = 10;
      }

      if (this.sp == 66) {
         if (var1) {
            this.fgen = this.co[this.esp].srz;
         } else {
            this.fgen = 0;
         }

         this.pwd = this.co[this.esp].srx;
         this.phd = this.co[this.esp].sry;
         this.pgen = false;
         this.sptyp = 6;
      }

      if (this.sptyp == 0) {
         this.partroads();
         this.part.show();
      }

      if (this.sptyp == 1) {
         this.partramps();
         this.part.show();
      }

      if (this.sptyp == 2) {
         this.partobst();
         this.part.show();
      }

      if (this.sptyp == 5) {
         this.partrees();
         this.part.show();
      }

      this.ptyp.select(this.sptyp);
      this.part.select(this.spart);
   }

   public void partrees() {
      this.part.removeAll();
      this.part.add(this.rd, "Tree 1");
      this.part.add(this.rd, "Tree 2");
      this.part.add(this.rd, "Tree 3");
      this.part.add(this.rd, "Tree 4");
      this.part.add(this.rd, "Tree 5");
      this.part.add(this.rd, "Palm Tree 1");
      this.part.add(this.rd, "Palm Tree 2");
      this.part.add(this.rd, "Palm Tree 3");
      this.part.add(this.rd, "Cactus 1");
      this.part.add(this.rd, "Cactus 2");
      this.part.add(this.rd, "Cactus 3");
   }

   public void partroads() {
      this.part.removeAll();
      this.part.add(this.rd, "NormalRoad");
      this.part.add(this.rd, "NormalRoad Turn");
      this.part.add(this.rd, "NormalRoad End");
      this.part.add(this.rd, "NormalRoad TwistedLeft");
      this.part.add(this.rd, "NormalRoad TwistedRight");
      this.part.add(this.rd, "NormalRoad Edged");
      this.part.add(this.rd, "NormalRoad-Raised Ramp");
      this.part.add(this.rd, "NormalRoad Raised");
      this.part.add(this.rd, "Normal-Off-Road Blend");
      this.part.add(this.rd, "OffRoad");
      this.part.add(this.rd, "OffRoad Turn");
      this.part.add(this.rd, "OffRoad End");
      this.part.add(this.rd, "OffRoad BumpyGreen");
      this.part.add(this.rd, "OffRoad-BumpySides Start");
      this.part.add(this.rd, "OffRoad BumpySides");
      this.part.add(this.rd, "Off-Halfpipe-Road Blend");
      this.part.add(this.rd, "HalfpipeRoad");
      this.part.add(this.rd, "HalfpipeRoad Turn");
      this.part.add(this.rd, "HalfpipeRoad-Ramp Filler");
      this.part.add(this.rd, "Halfpipe-Normal-Road Blend");
      this.part.add(this.rd, "Rollercoaster Start/End");
      this.part.add(this.rd, "Rollercoaster Road1");
      this.part.add(this.rd, "Rollercoaster Road2");
      this.part.add(this.rd, "Rollercoaster Road3");
      this.part.add(this.rd, "Rollercoaster Road4");
      this.part.add(this.rd, "Rollercoaster Road5");
   }

   public void partramps() {
      this.part.removeAll();
      this.part.add(this.rd, "Basic Ramp");
      this.part.add(this.rd, "Two-Way Ramp");
      this.part.add(this.rd, "Two-Way High-Low Ramp");
      this.part.add(this.rd, "Small Ramp");
      this.part.add(this.rd, "Crash Ramp");
      this.part.add(this.rd, "Big-Takeoff Ramp");
      this.part.add(this.rd, "Landing Ramp");
      this.part.add(this.rd, "Tunnel Side Ramp");
      this.part.add(this.rd, "Speed Ramp");
      this.part.add(this.rd, "Launch Pad Ramp");
      this.part.add(this.rd, "Offroad Bump Ramp");
      this.part.add(this.rd, "Offroad Ramp");
      this.part.add(this.rd, "Offroad Big Ramp");
      this.part.add(this.rd, "Offroad Hill Ramp");
      this.part.add(this.rd, "Offroad Big Hill Ramp");
      this.part.add(this.rd, "Halfpipe");
   }

   public void partobst() {
      this.part.removeAll();
      this.part.add(this.rd, "Spiky Pillars");
      this.part.add(this.rd, "Rail Doorway");
      this.part.add(this.rd, "The Net");
      this.part.add(this.rd, "Bump Slide");
      this.part.add(this.rd, "Offroad Dirt-Pile 1");
      this.part.add(this.rd, "Offroad Dirt-Pile 2");
   }

   @Override
   public void init() {
      this.setBackground(new Color(0, 0, 0));
      this.offImage = this.createImage(800, 550);
      if (this.offImage != null) {
         this.rd = (Graphics2D)this.offImage.getGraphics();
      }

      this.rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
      this.setLayout(null);
      this.slstage.setFont(new Font("Arial", 1, 13));
      this.slstage.add(this.rd, "Select a Stage...         ");
      this.slstage.setForeground(new Color(63, 80, 110));
      this.slstage.setBackground(new Color(209, 217, 230));
      this.srch.setFont(new Font("Arial", 1, 12));
      this.srch.setBackground(new Color(255, 255, 255));
      this.srch.setForeground(new Color(0, 0, 0));
      this.strtyp.setFont(new Font("Arial", 1, 12));
      this.strtyp.add(this.rd, "NormalRoad");
      this.strtyp.add(this.rd, "OffRoad");
      this.strtyp.setBackground(new Color(63, 80, 110));
      this.strtyp.setForeground(new Color(209, 217, 230));
      this.ptyp.setFont(new Font("Arial", 1, 12));
      this.ptyp.add(this.rd, "Roads");
      this.ptyp.add(this.rd, "Ramps");
      this.ptyp.add(this.rd, "Obstacles");
      this.ptyp.add(this.rd, "Checkpoint");
      this.ptyp.add(this.rd, "Fixing Hoop");
      this.ptyp.add(this.rd, "Trees");
      this.ptyp.add(this.rd, "Ground Pile");
      this.ptyp.setBackground(new Color(63, 80, 110));
      this.ptyp.setForeground(new Color(209, 217, 230));
      this.part.setFont(new Font("Arial", 1, 12));
      this.part.add(this.rd, "Halfpipe-Normal-Road Blend");
      this.part.setBackground(new Color(63, 80, 110));
      this.part.setForeground(new Color(209, 217, 230));
      this.fixh.setFont(new Font("Arial", 1, 12));
      this.fixh.setBackground(new Color(255, 255, 255));
      this.fixh.setForeground(new Color(0, 0, 0));
      this.mgen.setFont(new Font("Arial", 1, 12));
      this.mgen.setBackground(new Color(255, 255, 255));
      this.mgen.setForeground(new Color(0, 0, 0));
      this.pfog.setFont(new Font("Arial", 1, 12));
      this.pfog.setBackground(new Color(225, 225, 225));
      this.pfog.setForeground(new Color(0, 0, 0));
      this.nlaps.setFont(new Font("Arial", 1, 12));

      for (int var1 = 0; var1 < 15; var1++) {
         this.nlaps.add(this.rd, " " + (var1 + 1) + " ");
      }

      this.nlaps.setBackground(new Color(63, 80, 110));
      this.nlaps.setForeground(new Color(209, 217, 230));
      this.tracks.setFont(new Font("Arial", 1, 12));
      this.tracks.add(this.rd, "Select MOD Track");
      this.tracks.setForeground(new Color(63, 80, 110));
      this.tracks.setBackground(new Color(209, 217, 230));
      this.witho.setFont(new Font("Arial", 1, 12));
      this.witho.add(this.rd, "With other cars");
      this.witho.add(this.rd, "Alone");
      this.witho.setBackground(new Color(63, 80, 110));
      this.witho.setForeground(new Color(209, 217, 230));
      this.tnick.setFont(new Font("Arial", 1, 13));
      this.tnick.setBackground(new Color(255, 255, 255));
      this.tnick.setForeground(new Color(0, 0, 0));
      this.tpass.setFont(new Font("Arial", 1, 13));
      this.tpass.setEchoCharacter('*');
      this.tpass.setBackground(new Color(255, 255, 255));
      this.tpass.setForeground(new Color(0, 0, 0));
      this.pubtyp.setFont(new Font("Arial", 1, 13));
      this.pubtyp.add(this.rd, "Private");
      this.pubtyp.add(this.rd, "Public");
      this.pubtyp.add(this.rd, "Super Public");
      this.pubtyp.setBackground(new Color(63, 80, 110));
      this.pubtyp.setForeground(new Color(209, 217, 230));
      this.pubitem.setFont(new Font("Arial", 1, 13));
      this.pubitem.add(this.rd, "Account Stages");
      this.pubitem.setBackground(new Color(209, 217, 230));
      this.pubitem.setForeground(new Color(63, 80, 110));
      this.add(this.tnick);
      this.add(this.tpass);
      this.add(this.srch);
      this.add(this.fixh);
      this.add(this.mgen);
      this.add(this.pfog);
      this.hidefields();
   }

   public void hidefields() {
      this.pubtyp.hide();
      this.pubitem.hide();
      this.tpass.hide();
      this.tnick.hide();
      this.witho.hide();
      this.strtyp.hide();
      this.srch.hide();
      this.slstage.hide();
      this.tracks.hide();
      this.nlaps.hide();
      this.pfog.hide();
      this.fixh.hide();
      this.mgen.hide();
      this.ptyp.hide();
      this.part.hide();
   }

   public void movefield(Component var1, int var2, int var3, int var4, int var5) {
      var2 += this.apx;
      var3 += this.apy;
      if (var1.getX() != var2 || var1.getY() != var3 || var1.getWidth() != var4 || var1.getHeight() != var5) {
         var1.setBounds(var2, var3, var4, var5);
      }
   }

   public void drawms() {
      boolean var1 = false;
      if (this.pubtyp.draw(this.rd, this.xm, this.ym, this.mousdr, 550, false)) {
         var1 = true;
      }

      if (this.pubitem.draw(this.rd, this.xm, this.ym, this.mousdr, 550, false)) {
         var1 = true;
      }

      if (this.slstage.draw(this.rd, this.xm, this.ym, this.mousdr, 550, false)) {
         var1 = true;
      }

      if (this.strtyp.draw(this.rd, this.xm, this.ym, this.mousdr, 550, false)) {
         var1 = true;
      }

      short var2 = 0;
      if (this.preop) {
         var2 = -1000;
      }

      if (this.part.draw(this.rd, this.xm, this.ym + var2, this.mousdr && !this.preop, 550, false)) {
         var1 = true;
      }

      if (this.ptyp.draw(this.rd, this.xm, this.ym, this.mousdr, 550, false)) {
         var1 = true;
         this.preop = true;
      } else {
         this.preop = false;
      }

      if (this.nlaps.draw(this.rd, this.xm, this.ym, this.mousdr, 550, true)) {
         var1 = true;
      }

      if (this.tracks.draw(this.rd, this.xm, this.ym, this.mousdr, 550, true)) {
         var1 = true;
      }

      if (this.witho.draw(this.rd, this.xm, this.ym, this.mousdr, 550, true)) {
         var1 = true;
      }

      if (var1) {
         this.mouses = 0;
      }
   }

   @Override
   public void start() {
      if (this.thredo == null) {
         this.thredo = new Thread(this);
      }

      this.thredo.start();
   }

   @Override
   public void stop() {
      this.exwist = true;
   }

   @Override
   public void paint(Graphics var1) {
      this.apx = this.getWidth() / 2 - 400;
      this.apy = this.getHeight() / 2 - 275;
      var1.drawImage(this.offImage, this.apx, this.apy, this);
   }

   @Override
   public void update(Graphics var1) {
      this.paint(var1);
   }

   @Override
   public boolean mouseUp(Event var1, int var2, int var3) {
      this.mousdr = false;
      this.xm = var2 - this.apx;
      this.ym = var3 - this.apy;
      if (this.mouses == 1) {
         this.mouses = -1;
      }

      if (this.onbtgame) {
         Madness.game();
      }

      return false;
   }

   @Override
   public boolean mouseDown(Event var1, int var2, int var3) {
      this.mousdr = true;
      this.xm = var2 - this.apx;
      this.ym = var3 - this.apy;
      this.mouses = 1;
      this.requestFocus();
      this.focuson = true;
      return false;
   }

   @Override
   public boolean mouseMove(Event var1, int var2, int var3) {
      this.xm = var2 - this.apx;
      this.ym = var3 - this.apy;
      if (this.xm > 620 && this.xm < 774 && this.ym > 0 && this.ym < 23) {
         if (!this.onbtgame) {
            this.onbtgame = true;
            this.setCursor(new Cursor(12));
         }
      } else if (this.onbtgame) {
         this.onbtgame = false;
         this.setCursor(new Cursor(0));
      }

      return false;
   }

   @Override
   public boolean mouseDrag(Event var1, int var2, int var3) {
      this.mousdr = true;
      this.xm = var2 - this.apx;
      this.ym = var3 - this.apy;
      return false;
   }

   @Override
   public boolean keyDown(Event var1, int var2) {
      if (this.focuson) {
         if (var2 == 42 || var2 == 10 || var2 == 56 || var2 == 119 || var2 == 87 || var2 == 43 || var2 == 61) {
            this.zoomi = true;
         }

         if (var2 == 47 || var2 == 8 || var2 == 50 || var2 == 115 || var2 == 83 || var2 == 45) {
            this.zoomo = true;
         }

         if (var2 == 1006) {
            this.left = true;
         }

         if (var2 == 1007) {
            this.right = true;
         }

         if (var2 == 1005) {
            this.down = true;
         }

         if (var2 == 1004) {
            this.up = true;
         }
      }

      return false;
   }

   @Override
   public boolean keyUp(Event var1, int var2) {
      if (var2 == 42 || var2 == 10 || var2 == 56 || var2 == 119 || var2 == 87 || var2 == 43 || var2 == 61) {
         this.zoomi = false;
      }

      if (var2 == 47 || var2 == 8 || var2 == 50 || var2 == 115 || var2 == 83 || var2 == 45) {
         this.zoomo = false;
      }

      if (var2 == 1006) {
         this.left = false;
      }

      if (var2 == 1007) {
         this.right = false;
      }

      if (var2 == 1005) {
         this.down = false;
      }

      if (var2 == 1004) {
         this.up = false;
      }

      return false;
   }

   public void loadbase() {
      String[] var1 = new String[]{
         "road",
         "froad",
         "twister2",
         "twister1",
         "turn",
         "offroad",
         "bumproad",
         "offturn",
         "nroad",
         "nturn",
         "roblend",
         "noblend",
         "rnblend",
         "roadend",
         "offroadend",
         "hpground",
         "ramp30",
         "cramp35",
         "dramp15",
         "dhilo15",
         "slide10",
         "takeoff",
         "sramp22",
         "offbump",
         "offramp",
         "sofframp",
         "halfpipe",
         "spikes",
         "rail",
         "thewall",
         "checkpoint",
         "fixpoint",
         "offcheckpoint",
         "sideoff",
         "bsideoff",
         "uprise",
         "riseroad",
         "sroad",
         "soffroad",
         "tside",
         "launchpad",
         "thenet",
         "speedramp",
         "offhill",
         "slider",
         "uphill",
         "roll1",
         "roll2",
         "roll3",
         "roll4",
         "roll5",
         "roll6",
         "opile1",
         "opile2",
         "aircheckpoint",
         "tree1",
         "tree2",
         "tree3",
         "tree4",
         "tree5",
         "tree6",
         "tree7",
         "tree8",
         "cac1",
         "cac2",
         "cac3"
      };

      try {
         File var2 = new File("" + Madness.fpath + "data/models.zip");
         ZipInputStream var3 = new ZipInputStream(new FileInputStream(var2));
         ZipEntry var4 = var3.getNextEntry();

         for (Object var5 = null; var4 != null; var4 = var3.getNextEntry()) {
            int var6 = -1;

            for (int var7 = 0; var7 < 66; var7++) {
               if (var4.getName().startsWith(var1[var7])) {
                  var6 = var7;
               }
            }

            if (var6 != -1) {
               int var13 = (int)var4.getSize();
               var5 = new byte[var13];
               int var8 = 0;

               while (var13 > 0) {
                  int var9 = var3.read((byte[])var5, var8, var13);
                  var8 += var9;
                  var13 -= var9;
               }

               this.bco[var6] = new ContO((byte[])var5, this.m, this.t);

               for (int var10 = 0; var10 < this.bco[var6].npl; var10++) {
                  this.bco[var6].p[var10].loadprojf();
               }

               if (var6 == 31) {
                  this.bco[var6].elec = true;
               }
            }
         }

         var3.close();
         this.bco[66] = new ContO((int)(10000.0 * Math.random()), (int)this.pwd, (int)this.phd, this.m, this.t, 0, 0, 0);
      } catch (Exception var11) {
         JOptionPane.showMessageDialog(null, "Unable to load file 'data/models.zip'!\nError:\n" + var11, "Stage Maker", 1);
      }

      System.gc();
   }

   public void readstage(int var1) {
      this.errd = 0;
      this.trackname = "";
      this.t.nt = 0;
      this.nob = 0;
      this.xnob = 0;
      this.cp.n = 0;
      this.cp.nsp = 0;
      this.cp.fn = 0;
      this.cp.haltall = false;
      this.cp.wasted = 0;
      this.cp.catchfin = 0;
      this.m.ground = 250;
      this.m.lightson = false;
      if (var1 == 0) {
         this.m.snap[0] = 0;
         this.m.snap[1] = 0;
         this.m.snap[2] = 0;
      }

      if (var1 == 3) {
         this.tstage = "";
         this.bstage = "";
      }

      String var2 = this.bstage;
      if (var1 == 1 || var1 == 2) {
         var2 = "" + this.tstage + "\r\n" + this.bstage + "";
      }

      int var3 = 0;
      int var4 = 100;
      int var5 = 0;
      int var6 = 100;
      boolean var7 = true;
      boolean var8 = true;
      String var10 = "";

      try {
         DataInputStream var11 = null;
         if (var1 == 3) {
            File var12 = new File("" + smfpath + "mystages/" + this.stagename + ".txt");
            var11 = new DataInputStream(new FileInputStream(var12));
            this.nundo = 0;
         } else {
            var11 = new DataInputStream(new ByteArrayInputStream(var2.getBytes()));
         }

         String var9;
         while ((var9 = var11.readLine()) != null) {
            var10 = "" + var9.trim();
            if (var10.startsWith("sky")) {
               this.csky[0] = this.getint("sky", var10, 0);
               this.csky[1] = this.getint("sky", var10, 1);
               this.csky[2] = this.getint("sky", var10, 2);
               this.m.setsky(this.csky[0], this.csky[1], this.csky[2]);
               if (var1 == 3) {
                  this.tstage = this.tstage + "" + var10 + "\r\n";
               }
            }

            if (var10.startsWith("ground")) {
               this.cgrnd[0] = this.getint("ground", var10, 0);
               this.cgrnd[1] = this.getint("ground", var10, 1);
               this.cgrnd[2] = this.getint("ground", var10, 2);
               this.m.setgrnd(this.cgrnd[0], this.cgrnd[1], this.cgrnd[2]);
               if (var1 == 3) {
                  this.tstage = this.tstage + "" + var10 + "\r\n";
               }
            }

            if (var10.startsWith("polys")) {
               this.m.setpolys(this.getint("polys", var10, 0), this.getint("polys", var10, 1), this.getint("polys", var10, 2));
               if (var1 == 3) {
                  this.tstage = this.tstage + "" + var10 + "\r\n";
               }
            }

            if (var10.startsWith("fog")) {
               this.cfade[0] = this.getint("fog", var10, 0);
               this.cfade[1] = this.getint("fog", var10, 1);
               this.cfade[2] = this.getint("fog", var10, 2);
               this.m.setfade(this.cfade[0], this.cfade[1], this.cfade[2]);
               if (var1 == 3) {
                  this.tstage = this.tstage + "" + var10 + "\r\n";
               }
            }

            if (var10.startsWith("texture")) {
               this.texture[0] = this.getint("texture", var10, 0);
               this.texture[1] = this.getint("texture", var10, 1);
               this.texture[2] = this.getint("texture", var10, 2);
               this.texture[3] = this.getint("texture", var10, 3);
               this.m.setexture(this.texture[0], this.texture[1], this.texture[2], this.texture[3]);
               if (var1 == 3) {
                  this.tstage = this.tstage + "" + var10 + "\r\n";
               }
            }

            if (var10.startsWith("clouds")) {
               this.cldd[0] = this.getint("clouds", var10, 0);
               this.cldd[1] = this.getint("clouds", var10, 1);
               this.cldd[2] = this.getint("clouds", var10, 2);
               this.cldd[3] = this.getint("clouds", var10, 3);
               this.cldd[4] = this.getint("clouds", var10, 4);
               this.m.setcloads(this.cldd[0], this.cldd[1], this.cldd[2], this.cldd[3], this.cldd[4]);
               if (var1 == 3) {
                  this.tstage = this.tstage + "" + var10 + "\r\n";
               }
            }

            if (var1 != 2 && var10.startsWith("snap")) {
               this.m.setsnap(this.getint("snap", var10, 0), this.getint("snap", var10, 1), this.getint("snap", var10, 2));
               if (var1 == 3) {
                  this.tstage = this.tstage + "" + var10 + "\r\n";
               }
            }

            if (var10.startsWith("density")) {
               this.m.fogd = (this.getint("density", var10, 0) + 1) * 2 - 1;
               if (this.m.fogd < 1) {
                  this.m.fogd = 1;
               }

               if (this.m.fogd > 30) {
                  this.m.fogd = 30;
               }

               if (var1 == 3) {
                  this.tstage = this.tstage + "" + var10 + "\r\n";
               }
            }

            if (var10.startsWith("mountains")) {
               this.m.mgen = this.getint("mountains", var10, 0);
               if (var1 == 3) {
                  this.tstage = this.tstage + "" + var10 + "\r\n";
               }
            }

            if (var10.startsWith("fadefrom")) {
               this.m.fadfrom(this.getint("fadefrom", var10, 0));
               this.origfade = this.m.fade[0];
               if (var1 == 3) {
                  this.tstage = this.tstage + "" + var10 + "\r\n";
               }
            }

            if (var10.startsWith("lightson")) {
               this.m.lightson = true;
               if (var1 == 3) {
                  this.tstage = this.tstage + "" + var10 + "\r\n";
               }
            }

            if (var10.startsWith("nlaps")) {
               this.cp.nlaps = this.getint("nlaps", var10, 0);
               if (this.cp.nlaps < 1) {
                  this.cp.nlaps = 1;
               }

               if (this.cp.nlaps > 15) {
                  this.cp.nlaps = 15;
               }

               if (var1 == 3) {
                  this.tstage = this.tstage + "" + var10 + "\r\n";
               }
            }

            if (var10.startsWith("soundtrack")) {
               this.trackname = this.getstring("soundtrack", var10, 0);
               this.trackvol = this.getint("soundtrack", var10, 1);
               this.tracksize = this.getint("soundtrack", var10, 2);
               if (var1 == 3) {
                  this.tstage = this.tstage + "" + var10 + "\r\n";
               }
            }

            if (var10.startsWith("set")) {
               int var18 = this.getint("set", var10, 0);
               if (var18 >= 10 && var18 <= 25) {
                  this.m.loadnew = true;
               }

               var18 -= 10;
               this.co[this.nob] = new ContO(
                  this.bco[var18],
                  this.getint("set", var10, 1),
                  this.m.ground - this.bco[var18].grat,
                  this.getint("set", var10, 2),
                  this.getint("set", var10, 3)
               );
               this.co[this.nob].roofat = this.getint("set", var10, 3);
               this.co[this.nob].colok = var18;
               if (var10.indexOf(")p") != -1) {
                  this.cp.x[this.cp.n] = this.getint("chk", var10, 1);
                  this.cp.z[this.cp.n] = this.getint("chk", var10, 2);
                  this.cp.y[this.cp.n] = 0;
                  this.cp.typ[this.cp.n] = 0;
                  if (var10.indexOf(")pt") != -1) {
                     this.cp.typ[this.cp.n] = -1;
                  }

                  if (var10.indexOf(")pr") != -1) {
                     this.cp.typ[this.cp.n] = -2;
                  }

                  if (var10.indexOf(")po") != -1) {
                     this.cp.typ[this.cp.n] = -3;
                  }

                  if (var10.indexOf(")ph") != -1) {
                     this.cp.typ[this.cp.n] = -4;
                  }

                  this.cp.n++;
               }

               this.xnob++;
               this.nob++;
               if (var1 == 3) {
                  if (var8) {
                     this.bstage = this.bstage + "\r\n";
                     var8 = false;
                  }

                  this.bstage = this.bstage + "" + var10 + "\r\n";
               }

               if (this.m.loadnew) {
                  this.m.loadnew = false;
               }
            }

            if (var10.startsWith("chk")) {
               int var20 = this.getint("chk", var10, 0);
               var20 -= 10;
               int var13 = this.m.ground - this.bco[var20].grat;
               if (var20 == 54) {
                  var13 = this.getint("chk", var10, 4);
               }

               this.co[this.nob] = new ContO(this.bco[var20], this.getint("chk", var10, 1), var13, this.getint("chk", var10, 2), this.getint("chk", var10, 3));
               this.co[this.nob].roofat = this.getint("chk", var10, 3);
               this.co[this.nob].colok = var20;
               this.cp.x[this.cp.n] = this.getint("chk", var10, 1);
               this.cp.z[this.cp.n] = this.getint("chk", var10, 2);
               this.cp.y[this.cp.n] = var13;
               if (this.getint("chk", var10, 3) == 0) {
                  this.cp.typ[this.cp.n] = 1;
               } else {
                  this.cp.typ[this.cp.n] = 2;
               }

               this.cp.pcs = this.cp.n++;
               this.co[this.nob].checkpoint = this.cp.nsp + 1;
               if (var10.indexOf(")r") != -1) {
                  this.co[this.nob].wh = this.cp.nsp + 1;
               }

               this.cp.nsp++;
               this.xnob++;
               this.nob++;
               if (var1 == 3) {
                  if (var8) {
                     this.bstage = this.bstage + "\r\n";
                     var8 = false;
                  }

                  this.bstage = this.bstage + "" + var10 + "\r\n";
               }
            }

            if (var10.startsWith("fix")) {
               int var22 = this.getint("fix", var10, 0);
               var22 -= 10;
               this.co[this.nob] = new ContO(
                  this.bco[var22], this.getint("fix", var10, 1), this.getint("fix", var10, 3), this.getint("fix", var10, 2), this.getint("fix", var10, 4)
               );
               this.co[this.nob].roofat = this.getint("fix", var10, 4);
               this.co[this.nob].colok = var22;
               this.cp.fx[this.cp.fn] = this.getint("fix", var10, 1);
               this.cp.fz[this.cp.fn] = this.getint("fix", var10, 2);
               this.cp.fy[this.cp.fn] = this.getint("fix", var10, 3);
               this.co[this.nob].elec = true;
               if (this.getint("fix", var10, 4) != 0) {
                  this.cp.roted[this.cp.fn] = true;
                  this.co[this.nob].roted = true;
               } else {
                  this.cp.roted[this.cp.fn] = false;
               }

               if (var10.indexOf(")s") != -1) {
                  this.cp.special[this.cp.fn] = true;
               } else {
                  this.cp.special[this.cp.fn] = false;
               }

               this.cp.fn++;
               this.xnob++;
               this.nob++;
               if (var1 == 3) {
                  if (var8) {
                     this.bstage = this.bstage + "\r\n";
                     var8 = false;
                  }

                  this.bstage = this.bstage + "" + var10 + "\r\n";
               }
            }

            if (var10.startsWith("pile")) {
               this.co[this.nob] = new ContO(
                  this.getint("pile", var10, 0),
                  this.getint("pile", var10, 1),
                  this.getint("pile", var10, 2),
                  this.m,
                  this.t,
                  this.getint("pile", var10, 3),
                  this.getint("pile", var10, 4),
                  this.m.ground
               );
               this.co[this.nob].srz = this.getint("pile", var10, 0);
               this.co[this.nob].srx = this.getint("pile", var10, 1);
               this.co[this.nob].sry = this.getint("pile", var10, 2);
               this.co[this.nob].colok = 66;
               this.xnob++;
               this.nob++;
               if (var1 == 3) {
                  if (var8) {
                     this.bstage = this.bstage + "\r\n";
                     var8 = false;
                  }

                  this.bstage = this.bstage + "" + var10 + "\r\n";
               }
            }

            if (var10.startsWith("maxr")) {
               int var24 = this.getint("maxr", var10, 0);
               int var28 = this.getint("maxr", var10, 1);
               var3 = var28;
               int var14 = this.getint("maxr", var10, 2);

               for (int var15 = 0; var15 < var24; var15++) {
                  this.co[this.nob] = new ContO(this.bco[29], var28, this.m.ground - this.bco[29].grat, var15 * 4800 + var14, 0);
                  if (var1 == 0) {
                     this.xnob++;
                  } else {
                     this.nob++;
                  }
               }

               if (var1 == 3) {
                  if (var7) {
                     this.bstage = this.bstage + "\r\n";
                     var7 = false;
                  }

                  this.bstage = this.bstage + "" + var10 + "\r\n";
               }
            }

            if (var10.startsWith("maxl")) {
               int var25 = this.getint("maxl", var10, 0);
               int var29 = this.getint("maxl", var10, 1);
               var4 = var29;
               int var32 = this.getint("maxl", var10, 2);

               for (int var35 = 0; var35 < var25; var35++) {
                  this.co[this.nob] = new ContO(this.bco[29], var29, this.m.ground - this.bco[29].grat, var35 * 4800 + var32, 180);
                  if (var1 == 0) {
                     this.xnob++;
                  } else {
                     this.nob++;
                  }
               }

               if (var1 == 3) {
                  if (var7) {
                     this.bstage = this.bstage + "\r\n";
                     var7 = false;
                  }

                  this.bstage = this.bstage + "" + var10 + "\r\n";
               }
            }

            if (var10.startsWith("maxt")) {
               int var26 = this.getint("maxt", var10, 0);
               int var30 = this.getint("maxt", var10, 1);
               var5 = var30;
               int var33 = this.getint("maxt", var10, 2);

               for (int var36 = 0; var36 < var26; var36++) {
                  this.co[this.nob] = new ContO(this.bco[29], var36 * 4800 + var33, this.m.ground - this.bco[29].grat, var30, 90);
                  if (var1 == 0) {
                     this.xnob++;
                  } else {
                     this.nob++;
                  }
               }

               if (var1 == 3) {
                  if (var7) {
                     this.bstage = this.bstage + "\r\n";
                     var7 = false;
                  }

                  this.bstage = this.bstage + "" + var10 + "\r\n";
               }
            }

            if (var10.startsWith("maxb")) {
               int var27 = this.getint("maxb", var10, 0);
               int var31 = this.getint("maxb", var10, 1);
               var6 = var31;
               int var34 = this.getint("maxb", var10, 2);

               for (int var37 = 0; var37 < var27; var37++) {
                  this.co[this.nob] = new ContO(this.bco[29], var37 * 4800 + var34, this.m.ground - this.bco[29].grat, var31, -90);
                  if (var1 == 0) {
                     this.xnob++;
                  } else {
                     this.nob++;
                  }
               }

               if (var1 == 3) {
                  if (var7) {
                     this.bstage = this.bstage + "\r\n";
                     var7 = false;
                  }

                  this.bstage = this.bstage + "" + var10 + "\r\n";
               }
            }
         }

         var11.close();
         this.m.newpolys(var4, var3 - var4, var6, var5 - var6, this.t, this.nob);
         this.m.newclouds(var4, var3, var6, var5);
         this.m.newmountains(var4, var3, var6, var5);
         this.m.newstars();
      } catch (Exception var16) {
         System.out.println("Error in stage " + this.stagename);
         System.out.println("" + var16);
         System.out.println("At line: " + var10);
         this.errd = 6;
         if (this.cp.fn >= 5) {
            this.errd = 5;
         }

         if (this.t.nt >= 6700) {
            this.errd = 1;
         }

         if (this.cp.n >= 140) {
            this.errd = 2;
         }

         if (this.nob >= 601) {
            this.errd = 4;
         }
      }

      if (this.m.nrw * this.m.ncl >= 16000) {
         this.errd = 3;
      }

      if (this.xnob >= 602) {
         this.errd = 4;
      }

      if (var1 == 3 && this.bstage.indexOf("set(47,0,0,0)") == -1 && this.bstage.indexOf("set(48,0,0,0)") == -1) {
         this.bstage = this.bstage + "set(47,0,0,0)\r\n";
      }
   }

   public void newstage() {
      if (!this.srch.getText().equals("")) {
         File var1 = new File("" + smfpath + "mystages/" + this.srch.getText() + ".txt");
         if (!var1.exists()) {
            this.stagename = this.srch.getText();
            this.tstage = "snap(0,0,0)\r\nsky(191,215,255)\r\nclouds(255,255,255,5,-1000)\r\nfog(195,207,230)\r\nground(192,194,202)\r\ntexture(0,0,0,50)\r\nfadefrom(5000)\r\ndensity(5)\r\nmountains("
               + (int)(Math.random() * 100000.0)
               + ")\r\nnlaps(5)\r\n\r\n";
            if (this.strtyp.getSelectedIndex() == 1) {
               this.bstage = "set(48,0,0,0)\r\n";
            } else {
               this.bstage = "set(47,0,0,0)\r\n";
            }

            this.bstage = this.bstage + "\r\nmaxl(3,-7200,-4800)\r\nmaxb(3,-7200,-4800)\r\nmaxr(3,7200,-4800)\r\nmaxt(3,7200,-4800)\r\n";
            this.savefile();
            this.strtyp.hide();
            this.srch.hide();
            this.sfase = 0;
            this.tabed = -2;
         } else {
            JOptionPane.showMessageDialog(null, "A stage with that name already exists, please choose another name!", "Stage Maker", 1);
         }
      } else {
         JOptionPane.showMessageDialog(null, "Please enter a stage name first!", "Stage Maker", 1);
      }
   }

   public void sortop() {
      this.tstage = "snap("
         + this.m.snap[0]
         + ","
         + this.m.snap[1]
         + ","
         + this.m.snap[2]
         + ")\r\nsky("
         + this.csky[0]
         + ","
         + this.csky[1]
         + ","
         + this.csky[2]
         + ")\r\nfog("
         + this.cfade[0]
         + ","
         + this.cfade[1]
         + ","
         + this.cfade[2]
         + ")\r\nclouds("
         + this.cldd[0]
         + ","
         + this.cldd[1]
         + ","
         + this.cldd[2]
         + ","
         + this.cldd[3]
         + ","
         + this.cldd[4]
         + ")\r\nground("
         + this.cgrnd[0]
         + ","
         + this.cgrnd[1]
         + ","
         + this.cgrnd[2]
         + ")\r\ntexture("
         + this.texture[0]
         + ","
         + this.texture[1]
         + ","
         + this.texture[2]
         + ","
         + this.texture[3]
         + ")\r\nfadefrom("
         + this.origfade
         + ")\r\ndensity("
         + ((this.m.fogd + 1) / 2 - 1)
         + ")\r\nmountains("
         + this.m.mgen
         + ")\r\nnlaps("
         + this.cp.nlaps
         + ")\r\n";
      if (!this.trackname.equals("")) {
         this.tstage = this.tstage + "soundtrack(" + this.trackname + "," + this.trackvol + "," + this.tracksize + ")\r\n";
      }

      for (int var1 = 0; var1 < 3; var1++) {
         this.snap[var1] = (int)(this.m.snap[var1] / 1.2F + 50.0F);
      }

      if (this.snap[0] + this.snap[1] + this.snap[2] <= 110) {
         this.tstage = this.tstage + "lightson()\r\n";
      }

      this.tstage = this.tstage + "\r\n";
   }

   public void sortstage() {
      int[] var1 = new int[this.nob * 2];
      int[] var2 = new int[this.nob * 2];

      for (int var3 = 0; var3 < this.nob; var3++) {
         var1[var3] = 0;
      }

      int var21 = 0;
      int var4 = 0;
      var2[var4] = 0;
      var4++;
      boolean var5 = false;
      byte var6 = 0;

      while (!var5) {
         int[] var7 = new int[]{this.co[var21].x + this.atp[this.co[var21].colok][0], this.co[var21].x + this.atp[this.co[var21].colok][2]};
         int[] var8 = new int[]{this.co[var21].z + this.atp[this.co[var21].colok][1], this.co[var21].z + this.atp[this.co[var21].colok][3]};
         int var9 = this.co[var21].roofat;
         if (this.co[var21].colok == 2) {
            var9 += 30;
         }

         if (this.co[var21].colok == 3) {
            var9 -= 30;
         }

         if (this.co[var21].colok == 15) {
            var9 -= 90;
         }

         if (this.co[var21].colok == 20) {
            var9 -= 180;
         }

         if (this.co[var21].colok == 26) {
            var9 -= 90;
         }

         this.rot(var7, var8, this.co[var21].x, this.co[var21].z, var9, 2);
         int var10 = -1;
         int var11 = -1;
         if (var6 != 0) {
            for (int var12 = 0; var12 < this.nob; var12++) {
               boolean var13 = false;
               if (var4 == 2 && var12 == 0) {
                  var13 = true;
               }

               if (var21 != var12
                  && !var13
                  && var1[var12] == 0
                  && (this.co[var12].colok <= 14 || this.co[var12].colok >= 33)
                  && (this.co[var12].colok < 39 || this.co[var12].colok >= 46)
                  && this.co[var12].colok < 52) {
                  byte var14 = 0;
                  if (this.co[var12].colok != 2
                     && this.co[var12].colok != 3
                     && this.co[var12].colok != 4
                     && this.co[var12].colok != 7
                     && this.co[var12].colok != 9) {
                     if (var6 == 1
                        && this.co[var12].z > this.co[var21].z
                        && Math.abs(this.co[var12].x - this.co[var21].x) < 1000
                        && (this.co[var12].roofat == 180 || this.co[var12].roofat == 0)) {
                        var14 = 1;
                     }

                     if (var6 == 2
                        && this.co[var12].z < this.co[var21].z
                        && Math.abs(this.co[var12].x - this.co[var21].x) < 1000
                        && (this.co[var12].roofat == 180 || this.co[var12].roofat == 0)) {
                        var14 = 1;
                     }

                     if (var6 == 3
                        && this.co[var12].x > this.co[var21].x
                        && Math.abs(this.co[var12].z - this.co[var21].z) < 1000
                        && (this.co[var12].roofat == 90 || this.co[var12].roofat == -90)) {
                        var14 = 1;
                     }

                     if (var6 == 4
                        && this.co[var12].x < this.co[var21].x
                        && Math.abs(this.co[var12].z - this.co[var21].z) < 1000
                        && (this.co[var12].roofat == 90 || this.co[var12].roofat == -90)) {
                        var14 = 1;
                     }
                  } else {
                     var14 = 2;
                  }

                  if (var14 != 0) {
                     int[] var15 = new int[]{this.co[var12].x + this.atp[this.co[var12].colok][0], this.co[var12].x + this.atp[this.co[var12].colok][2]};
                     int[] var16 = new int[]{this.co[var12].z + this.atp[this.co[var12].colok][1], this.co[var12].z + this.atp[this.co[var12].colok][3]};
                     var9 = this.co[var12].roofat;
                     if (this.co[var12].colok == 2) {
                        var9 += 30;
                     }

                     if (this.co[var12].colok == 3) {
                        var9 -= 30;
                     }

                     if (this.co[var12].colok == 15) {
                        var9 -= 90;
                     }

                     if (this.co[var12].colok == 20) {
                        var9 -= 180;
                     }

                     if (this.co[var12].colok == 26) {
                        var9 -= 90;
                     }

                     this.rot(var15, var16, this.co[var12].x, this.co[var12].z, var9, 2);
                     int var17 = 0;
                     if (var12 != 0) {
                        var17 = this.pyn(var15[0], var7[0], var16[0], var8[0]);
                        if (var17 >= 0 && (var17 < 100 || var14 != 2) && (var17 < var10 || var10 == -1)) {
                           var10 = var17;
                           var11 = var12;
                        }
                     }

                     var17 = this.pyn(var15[1], var7[0], var16[1], var8[0]);
                     if (var17 >= 0 && (var17 < 100 || var14 != 2) && (var17 < var10 || var10 == -1)) {
                        var10 = var17;
                        var11 = var12;
                     }

                     if (var21 != 0) {
                        if (var12 != 0) {
                           var17 = this.pyn(var15[0], var7[1], var16[0], var8[1]);
                           if (var17 >= 0 && (var17 < 100 || var14 != 2) && var17 < var10) {
                              var10 = var17;
                              var11 = var12;
                           }
                        }

                        var17 = this.pyn(var15[1], var7[1], var16[1], var8[1]);
                        if (var17 >= 0 && (var17 < 100 || var14 != 2) && var17 < var10) {
                           var10 = var17;
                           var11 = var12;
                        }
                     }
                  }
               }
            }
         }

         if (var11 == -1) {
            for (int var66 = 0; var66 < this.nob; var66++) {
               boolean var75 = false;
               if (var4 == 2 && var66 == 0) {
                  var75 = true;
               }

               if (var21 != var66
                  && !var75
                  && var1[var66] == 0
                  && (this.co[var66].colok <= 14 || this.co[var66].colok >= 33)
                  && (this.co[var66].colok < 39 || this.co[var66].colok >= 46)
                  && this.co[var66].colok < 52) {
                  int[] var83 = new int[]{this.co[var66].x + this.atp[this.co[var66].colok][0], this.co[var66].x + this.atp[this.co[var66].colok][2]};
                  int[] var85 = new int[]{this.co[var66].z + this.atp[this.co[var66].colok][1], this.co[var66].z + this.atp[this.co[var66].colok][3]};
                  var9 = this.co[var66].roofat;
                  if (this.co[var66].colok == 2) {
                     var9 += 30;
                  }

                  if (this.co[var66].colok == 3) {
                     var9 -= 30;
                  }

                  if (this.co[var66].colok == 15) {
                     var9 -= 90;
                  }

                  if (this.co[var66].colok == 20) {
                     var9 -= 180;
                  }

                  if (this.co[var66].colok == 26) {
                     var9 -= 90;
                  }

                  this.rot(var83, var85, this.co[var66].x, this.co[var66].z, var9, 2);
                  int var88 = 0;
                  if (var66 != 0) {
                     var88 = this.pyn(var83[0], var7[0], var85[0], var8[0]);
                     if (var88 >= 0 && (var88 < var10 || var10 == -1)) {
                        var10 = var88;
                        var11 = var66;
                     }
                  }

                  var88 = this.pyn(var83[1], var7[0], var85[1], var8[0]);
                  if (var88 >= 0 && (var88 < var10 || var10 == -1)) {
                     var10 = var88;
                     var11 = var66;
                  }

                  if (var21 != 0) {
                     if (var66 != 0) {
                        var88 = this.pyn(var83[0], var7[1], var85[0], var8[1]);
                        if (var88 >= 0 && var88 < var10) {
                           var10 = var88;
                           var11 = var66;
                        }
                     }

                     var88 = this.pyn(var83[1], var7[1], var85[1], var8[1]);
                     if (var88 >= 0 && var88 < var10) {
                        var10 = var88;
                        var11 = var66;
                     }
                  }
               }
            }
         }

         if (var11 == -1) {
            var1[0] = 1;
            var5 = true;
         } else {
            var6 = 0;
            if (this.co[var11].colok != 2 && this.co[var11].colok != 3 && this.co[var11].colok != 4 && this.co[var11].colok != 7 && this.co[var11].colok != 9) {
               if ((this.co[var11].roofat == 180 || this.co[var11].roofat == 0) && this.co[var11].z > this.co[var21].z) {
                  var6 = 1;
               }

               if ((this.co[var11].roofat == 180 || this.co[var11].roofat == 0) && this.co[var11].z < this.co[var21].z) {
                  var6 = 2;
               }

               if ((this.co[var11].roofat == 90 || this.co[var11].roofat == -90) && this.co[var11].x > this.co[var21].x) {
                  var6 = 3;
               }

               if ((this.co[var11].roofat == 90 || this.co[var11].roofat == -90) && this.co[var11].x < this.co[var21].x) {
                  var6 = 4;
               }
            }

            if (this.co[var11].colok != 4 && this.co[var11].colok != 7 && this.co[var11].colok != 9) {
               var1[var11] = 1;
            } else {
               var1[var11] = 2;
            }

            if (this.co[var11].colok >= 46 && this.co[var11].colok <= 51) {
               var1[var11] = 6;
            }

            var21 = var11;
            if (var11 == 0) {
               var1[0] = 1;
               var5 = true;
            } else {
               var2[var4] = var11;
               var4++;
            }
         }
      }

      for (int var23 = 0; var23 < this.nob; var23++) {
         if (var1[var23] == 0
            && (this.co[var23].colok <= 14 || this.co[var23].colok >= 33)
            && (this.co[var23].colok < 39 || this.co[var23].colok >= 46)
            && this.co[var23].colok < 52) {
            var2[var4] = var23;
            var4++;
         }
      }

      for (int var24 = 0; var24 < var4; var24++) {
         if (this.co[var2[var24]].colok >= 46 && this.co[var2[var24]].colok <= 51) {
            for (int var26 = var24 + 1; var26 < var4; var26++) {
               int var37 = this.pyn(this.co[var2[var24]].x, this.co[var2[var26]].x, this.co[var2[var24]].z, this.co[var2[var26]].z);
               if (var37 >= 0
                  && (this.co[var2[var26]].colok < 46 || this.co[var2[var24]].colok > 51)
                  && var37 < (this.co[var2[var24]].maxR + this.co[var2[var26]].maxR) / 100 * ((this.co[var2[var24]].maxR + this.co[var2[var26]].maxR) / 100)) {
                  int var45 = var2[var26];

                  for (int var55 = var26; var55 > var24; var55--) {
                     var2[var55] = var2[var55 - 1];
                  }

                  var2[var24] = var45;
                  var1[var2[var24]] = 0;
                  var24++;
               }
            }
         }
      }

      int var25 = 1;

      for (int var27 = 0; var27 < this.cp.nsp; var27++) {
         for (int var38 = 0; var38 < this.nob; var38++) {
            if (this.co[var38].wh == var27 + 1 && (this.co[var38].colok == 30 || this.co[var38].colok == 32 || this.co[var38].colok == 54)) {
               int var46 = -1;
               int var56 = -1;

               for (int var67 = var25; var67 < var4; var67++) {
                  if (this.co[var2[var67]].colok != 30 && this.co[var2[var67]].colok != 32 && this.co[var2[var67]].colok != 54) {
                     int var76 = this.pyn(this.co[var38].x, this.co[var2[var67]].x, this.co[var38].z, this.co[var2[var67]].z);
                     if (var76 >= 0 && (var76 < var46 || var46 == -1)) {
                        var46 = var76;
                        var56 = var67;
                     }
                  }
               }

               if (var56 == -1) {
                  var2[var4] = var38;
                  var25 = var4++;
               } else {
                  var1[var2[var56]] = 0;

                  for (int var68 = var4; var68 > var56; var68--) {
                     var2[var68] = var2[var68 - 1];
                  }

                  var2[var56 + 1] = var38;
                  var25 = var56 + 1;
                  var4++;
               }
            }
         }
      }

      for (int var28 = 0; var28 < this.nob; var28++) {
         if (this.co[var28].wh == 0 && (this.co[var28].colok == 30 || this.co[var28].colok == 32 || this.co[var28].colok == 54)) {
            int var39 = -1;
            int var47 = -1;

            for (int var57 = var25; var57 < var4; var57++) {
               if (this.co[var2[var57]].colok != 30 && this.co[var2[var57]].colok != 32 && this.co[var2[var57]].colok != 54) {
                  int var69 = this.pyn(this.co[var28].x, this.co[var2[var57]].x, this.co[var28].z, this.co[var2[var57]].z);
                  if (var69 >= 0 && (var69 < var39 || var39 == -1)) {
                     var39 = var69;
                     var47 = var57;
                  }
               }
            }

            if (var47 == -1) {
               var2[var4] = var28;
               var4++;
            } else {
               var1[var2[var47]] = 0;

               for (int var58 = var4; var58 > var47; var58--) {
                  var2[var58] = var2[var58 - 1];
               }

               var2[var47 + 1] = var28;
               var4++;
            }
         }
      }

      for (int var29 = 0; var29 < this.nob; var29++) {
         if (this.co[var29].colok == 31) {
            int var40 = -1;
            int var48 = -1;

            for (int var59 = 0; var59 < var4; var59++) {
               int var70 = this.pyn(this.co[var29].x, this.co[var2[var59]].x, this.co[var29].z, this.co[var2[var59]].z);
               if (var70 >= 0 && (var70 < var40 || var40 == -1)) {
                  var40 = var70;
                  var48 = var59;
               }
            }

            if (var48 == -1) {
               var2[var4] = var29;
               var4++;
            } else {
               for (int var60 = var4; var60 > var48; var60--) {
                  var2[var60] = var2[var60 - 1];
               }

               var2[var48] = var29;
               var4++;
            }
         }
      }

      for (int var30 = 0; var30 < this.nob; var30++) {
         if (this.co[var30].colok == 15
            || this.co[var30].colok == 27
            || this.co[var30].colok == 28
            || this.co[var30].colok == 41
            || this.co[var30].colok == 44
            || this.co[var30].colok == 52
            || this.co[var30].colok == 53) {
            int var41 = -1;

            for (int var49 = 0; var49 < var4; var49++) {
               if ((this.co[var2[var49]].colok <= 14 || this.co[var2[var49]].colok >= 33) && this.co[var2[var49]].colok < 39) {
                  int var61 = this.pyn(this.co[var30].x, this.co[var2[var49]].x, this.co[var30].z, this.co[var2[var49]].z);
                  if (var61 >= 0 && var61 < (this.co[var30].maxR + this.co[var2[var49]].maxR) / 100 * ((this.co[var30].maxR + this.co[var2[var49]].maxR) / 100)
                     )
                   {
                     var41 = var49;
                  }
               }
            }

            if (var41 == -1) {
               var2[var4] = var30;
               var4++;
            } else {
               for (int var50 = var4; var50 > var41; var50--) {
                  var2[var50] = var2[var50 - 1];
               }

               var2[var41 + 1] = var30;
               var4++;
            }
         }
      }

      for (int var31 = 0; var31 < this.nob; var31++) {
         if (this.co[var31].colok >= 16 && this.co[var31].colok <= 25
            || this.co[var31].colok == 40
            || this.co[var31].colok == 42
            || this.co[var31].colok == 43
            || this.co[var31].colok == 45) {
            int var42 = -1;

            for (int var51 = 0; var51 < var4; var51++) {
               if ((this.co[var2[var51]].colok <= 14 || this.co[var2[var51]].colok >= 33) && this.co[var2[var51]].colok < 39) {
                  int var62 = this.pyn(this.co[var31].x, this.co[var2[var51]].x, this.co[var31].z, this.co[var2[var51]].z);
                  if (var62 >= 0 && var62 < (this.co[var31].maxR + this.co[var2[var51]].maxR) / 100 * ((this.co[var31].maxR + this.co[var2[var51]].maxR) / 100)
                     )
                   {
                     if (var1[var2[var51]] != 0) {
                        var1[var2[var51]] = 0;
                        if (this.co[var31].colok != 20) {
                           var1[var31] = 3;
                        } else {
                           var1[var31] = 5;
                        }
                     }

                     var42 = var51;
                  }
               }
            }

            if (var42 == -1) {
            }

            if (var42 == -1) {
               var2[var4] = var31;
               var4++;
            } else {
               for (int var52 = var4; var52 > var42; var52--) {
                  var2[var52] = var2[var52 - 1];
               }

               var2[var42 + 1] = var31;
               var4++;
            }
         }
      }

      for (int var32 = 0; var32 < this.nob; var32++) {
         if (this.co[var32].colok == 26 || this.co[var32].colok == 39) {
            boolean var43 = false;
            if (Math.random() > Math.random()) {
               var43 = true;
               if (this.co[var32].colok == 39) {
                  if (Math.random() > Math.random()) {
                     var43 = false;
                  } else if (Math.random() > Math.random()) {
                     var43 = false;
                  }
               }
            }

            int var53 = -1;

            for (int var63 = 0; var63 < var4; var63++) {
               if ((this.co[var2[var63]].colok <= 14 || this.co[var2[var63]].colok >= 33) && this.co[var2[var63]].colok < 39) {
                  int var71 = this.pyn(this.co[var32].x, this.co[var2[var63]].x, this.co[var32].z, this.co[var2[var63]].z);
                  if (var71 >= 0 && var71 < (this.co[var32].maxR + this.co[var2[var63]].maxR) / 100 * ((this.co[var32].maxR + this.co[var2[var63]].maxR) / 100)
                     )
                   {
                     boolean var77 = false;
                     if (this.co[var32].colok == 26) {
                        if (this.co[var32].roofat == 90 && this.co[var2[var63]].x > this.co[var32].x) {
                           var77 = true;
                        }

                        if (this.co[var32].roofat == -90 && this.co[var2[var63]].x < this.co[var32].x) {
                           var77 = true;
                        }

                        if (this.co[var32].roofat == 0 && this.co[var2[var63]].z < this.co[var32].z) {
                           var77 = true;
                        }

                        if (this.co[var32].roofat == 180 && this.co[var2[var63]].z > this.co[var32].z) {
                           var77 = true;
                        }
                     }

                     if (this.co[var32].colok == 39) {
                        if (this.co[var32].roofat == 90 && this.co[var2[var63]].z > this.co[var32].z) {
                           var77 = true;
                        }

                        if (this.co[var32].roofat == -90 && this.co[var2[var63]].z < this.co[var32].z) {
                           var77 = true;
                        }

                        if (this.co[var32].roofat == 0 && this.co[var2[var63]].x > this.co[var32].x) {
                           var77 = true;
                        }

                        if (this.co[var32].roofat == 180 && this.co[var2[var63]].x < this.co[var32].x) {
                           var77 = true;
                        }
                     }

                     if (var77) {
                        if (var1[var2[var63]] == 1 && var43) {
                           var1[var2[var63]] = 0;
                           var1[var32] = 4;
                        }

                        var53 = var63;
                     }
                  }
               }
            }

            if (var53 == -1) {
               var2[var4] = var32;
               var4++;
            } else {
               for (int var64 = var4; var64 > var53; var64--) {
                  var2[var64] = var2[var64 - 1];
               }

               var2[var53 + 1] = var32;
               var4++;
            }
         }
      }

      for (int var33 = 0; var33 < this.nob; var33++) {
         if (this.co[var33].colok >= 55 && this.co[var33].colok <= 65 || this.co[var33].colok == 66) {
            var2[var4] = var33;
            var4++;
         }
      }

      int var34 = 0;
      int var44 = 0;
      int var54 = 0;
      int var65 = 0;
      this.bstage = "";

      for (int var72 = 0; var72 < var4; var72++) {
         if (this.co[var2[var72]].colok != 30
            && this.co[var2[var72]].colok != 31
            && this.co[var2[var72]].colok != 32
            && this.co[var2[var72]].colok != 54
            && this.co[var2[var72]].colok != 66) {
            String var78 = "";
            if (var1[var2[var72]] == 1) {
               var78 = "p";
            }

            if (var1[var2[var72]] == 2) {
               var78 = "pt";
            }

            if (var1[var2[var72]] == 3) {
               var78 = "pr";
            }

            if (var1[var2[var72]] == 4) {
               var78 = "ph";
            }

            if (var1[var2[var72]] == 5) {
               var78 = "pl";
            }

            if (var1[var2[var72]] == 6) {
               var78 = "pr";
            }

            this.bstage = this.bstage
               + "set("
               + (this.co[var2[var72]].colok + 10)
               + ","
               + this.co[var2[var72]].x
               + ","
               + this.co[var2[var72]].z
               + ","
               + this.co[var2[var72]].roofat
               + ")"
               + var78
               + "\r\n";
         }

         if (this.co[var2[var72]].colok == 30 || this.co[var2[var72]].colok == 32) {
            if (this.co[var2[var72]].roofat == 180) {
               this.co[var2[var72]].roofat = 0;
            }

            String var79 = "";
            if (this.co[var2[var72]].wh != 0) {
               var79 = "r";
            }

            this.bstage = this.bstage
               + "chk("
               + (this.co[var2[var72]].colok + 10)
               + ","
               + this.co[var2[var72]].x
               + ","
               + this.co[var2[var72]].z
               + ","
               + this.co[var2[var72]].roofat
               + ")"
               + var79
               + "\r\n";
         }

         if (this.co[var2[var72]].colok == 54) {
            if (this.co[var2[var72]].roofat == 180) {
               this.co[var2[var72]].roofat = 0;
            }

            String var80 = "";
            if (this.co[var2[var72]].wh != 0) {
               var80 = "r";
            }

            this.bstage = this.bstage
               + "chk("
               + (this.co[var2[var72]].colok + 10)
               + ","
               + this.co[var2[var72]].x
               + ","
               + this.co[var2[var72]].z
               + ","
               + this.co[var2[var72]].roofat
               + ","
               + this.co[var2[var72]].y
               + ")"
               + var80
               + "\r\n";
         }

         if (this.co[var2[var72]].colok == 31) {
            this.bstage = this.bstage
               + "fix("
               + (this.co[var2[var72]].colok + 10)
               + ","
               + this.co[var2[var72]].x
               + ","
               + this.co[var2[var72]].z
               + ","
               + this.co[var2[var72]].y
               + ","
               + this.co[var2[var72]].roofat
               + ")\r\n";
         }

         if (this.co[var2[var72]].colok == 66) {
            this.bstage = this.bstage
               + "pile("
               + this.co[var2[var72]].srz
               + ","
               + this.co[var2[var72]].srx
               + ","
               + this.co[var2[var72]].sry
               + ","
               + this.co[var2[var72]].x
               + ","
               + this.co[var2[var72]].z
               + ")\r\n";
         }

         if (this.co[var2[var72]].x + this.co[var2[var72]].maxR > var34) {
            var34 = this.co[var2[var72]].x + this.co[var2[var72]].maxR;
         }

         if (this.co[var2[var72]].x - this.co[var2[var72]].maxR < var54) {
            var54 = this.co[var2[var72]].x - this.co[var2[var72]].maxR;
         }

         if (this.co[var2[var72]].z + this.co[var2[var72]].maxR > var44) {
            var44 = this.co[var2[var72]].z + this.co[var2[var72]].maxR;
         }

         if (this.co[var2[var72]].z - this.co[var2[var72]].maxR < var65) {
            var65 = this.co[var2[var72]].z - this.co[var2[var72]].maxR;
         }
      }

      int var73 = var54 - 0;
      int var81 = var34 + 0;
      int var84 = (int)((var81 - var73) / 4800.0F) + 1;
      int var86 = (var84 * 4800 - (var81 - var73)) / 2;
      var73 -= var86;
      var81 += var86;
      int var93 = var73 + 2400;
      int var98 = var65 - 0;
      int var18 = var44 + 0;
      int var19 = (int)((var18 - var98) / 4800.0F) + 1;
      var86 = (var19 * 4800 - (var18 - var98)) / 2;
      var98 -= var86;
      var18 += var86;
      int var20 = var98 + 2400;
      this.bstage = this.bstage
         + "\r\nmaxl("
         + var19
         + ","
         + var73
         + ","
         + var20
         + ")\r\nmaxb("
         + var84
         + ","
         + var98
         + ","
         + var93
         + ")\r\nmaxr("
         + var19
         + ","
         + var81
         + ","
         + var20
         + ")\r\nmaxt("
         + var84
         + ","
         + var18
         + ","
         + var93
         + ")\r\n";
   }

   public void savefile() {
      try {
         File var1 = new File("" + smfpath + "mystages/");
         if (!var1.exists()) {
            var1.mkdirs();
         }

         var1 = new File("" + smfpath + "mystages/" + this.stagename + ".txt");
         BufferedWriter var2 = new BufferedWriter(new FileWriter(var1));
         var2.write(this.tstage);
         var2.write(this.bstage);
         var2.close();
         Object var5 = null;
      } catch (Exception var3) {
         JOptionPane.showMessageDialog(null, "Unable to save file! Error Deatials:\n" + var3, "Stage Maker", 1);
      }

      this.savesettings();
   }

   public void renstage(String var1) {
      if (var1.equals("")) {
         JOptionPane.showMessageDialog(null, "Please Enter a New Stage Name!\n", "Stage Maker", 1);
      } else {
         try {
            File var2 = new File("" + smfpath + "mystages/" + this.stagename + ".txt");
            File var3 = new File("" + smfpath + "mystages/" + var1 + ".txt");
            if (var2.renameTo(var3)) {
               this.stagename = var1;
               this.sfase = 0;
               this.hidefields();
               this.tabed = -2;
            } else {
               JOptionPane.showMessageDialog(null, "Unable to rename stage to: '" + var1 + "', possible reason: stage name already used!\n", "Stage Maker", 1);
            }
         } catch (Exception var4) {
            JOptionPane.showMessageDialog(null, "Unable to rename file! Error Deatials:\n" + var4, "Stage Maker", 1);
         }
      }
   }

   public void delstage(String var1) {
      try {
         File var2 = new File("" + smfpath + "mystages/" + var1 + ".txt");
         var2.delete();
         this.slstage.remove(var1);
         this.slstage.select(0);
      } catch (Exception var3) {
         JOptionPane.showMessageDialog(null, "Unable to delete file! Error Deatials:\n" + var3, "Stage Maker", 1);
      }
   }

   public void deltrack() {
      try {
         File var1 = new File("" + smfpath + "mystages/mymusic/" + this.tracks.getSelectedItem() + ".zip");
         var1.delete();
         if (this.trackname.equals(this.tracks.getSelectedItem())) {
            this.trackname = "";
            this.sortop();
            this.savefile();
         }

         this.tracks.remove(this.tracks.getSelectedItem());
         this.tracks.select(0);
      } catch (Exception var2) {
         JOptionPane.showMessageDialog(null, "Unable to delete file! Error Deatials:\n" + var2, "Stage Maker", 1);
      }
   }

   public void loadsettings() {
      try {
         File var1 = new File("" + smfpath + "mystages/settings.data");
         if (var1.exists()) {
            BufferedReader var2 = new BufferedReader(new FileReader(var1));
            String var3 = var2.readLine();
            if (var3 != null) {
               this.sstage = var3;
               this.stagename = this.sstage;
            }

            var3 = var2.readLine();
            if (var3 != null) {
               this.suser = var3;
               if (!this.suser.equals("Horaks")) {
                  this.tnick.setText(this.suser);
               }
            }

            var2.close();
            Object var5 = null;
         }
      } catch (Exception var4) {
      }
   }

   public void savesettings() {
      if (!this.sstage.equals(this.stagename) || !this.suser.equals(this.tnick.getText())) {
         String var1 = "" + this.stagename + "\n" + this.tnick.getText() + "\n\n";
         this.sstage = this.stagename;
         this.suser = this.tnick.getText();

         try {
            File var2 = new File("" + smfpath + "mystages/");
            if (!var2.exists()) {
               var2.mkdirs();
            }

            var2 = new File("" + smfpath + "mystages/settings.data");
            BufferedWriter var3 = new BufferedWriter(new FileWriter(var2));
            var3.write(var1);
            var3.close();
            Object var6 = null;
         } catch (Exception var4) {
         }
      }
   }

   public void fixtext(TextField var1) {
      String var2 = var1.getText();
      var2 = var2.replace('"', '#');
      String var3 = "\\";
      String var4 = "";
      int var5 = 0;
      int var6 = -1;
      this.rd.setFont(new Font("Arial", 1, 12));

      for (this.ftm = this.rd.getFontMetrics(); var5 < var2.length(); var5++) {
         String var7 = "" + var2.charAt(var5);
         if (!var7.equals("|")
            && !var7.equals(",")
            && !var7.equals("(")
            && !var7.equals(")")
            && !var7.equals("#")
            && !var7.equals(var3)
            && !var7.equals("!")
            && !var7.equals("?")
            && !var7.equals("~")
            && !var7.equals(".")
            && !var7.equals("@")
            && !var7.equals("$")
            && !var7.equals("%")
            && !var7.equals("^")
            && !var7.equals("&")
            && !var7.equals("*")
            && !var7.equals("+")
            && !var7.equals("=")
            && !var7.equals(">")
            && !var7.equals("<")
            && !var7.equals("/")
            && !var7.equals(";")
            && !var7.equals(":")
            && this.ftm.stringWidth(var4) <= 274) {
            var4 = var4 + var7;
         } else {
            var6 = var5;
         }
      }

      if (var6 != -1) {
         var1.setText(var4);
         var1.select(var6, var6);
      }
   }

   public void rot(int[] var1, int[] var2, int var3, int var4, int var5, int var6) {
      if (var5 != 0) {
         for (int var7 = 0; var7 < var6; var7++) {
            int var8 = var1[var7];
            int var9 = var2[var7];
            var1[var7] = var3 + (int)((var8 - var3) * this.m.cos(var5) - (var9 - var4) * this.m.sin(var5));
            var2[var7] = var4 + (int)((var8 - var3) * this.m.sin(var5) + (var9 - var4) * this.m.cos(var5));
         }
      }
   }

   public int xs(int var1, int var2) {
      if (var2 < this.m.cz) {
         var2 = this.m.cz;
      }

      return (var2 - this.m.focus_point) * (this.m.cx - var1) / var2 + var1;
   }

   public int ys(int var1, int var2) {
      if (var2 < this.m.cz) {
         var2 = this.m.cz;
      }

      return (var2 - this.m.focus_point) * (this.m.cy - var1) / var2 + var1;
   }

   public int py(int var1, int var2, int var3, int var4) {
      return (int)Math.sqrt((var1 - var2) * (var1 - var2) + (var3 - var4) * (var3 - var4));
   }

   public int pyn(int var1, int var2, int var3, int var4) {
      return (var1 - var2) / 100 * ((var1 - var2) / 100) + (var3 - var4) / 100 * ((var3 - var4) / 100);
   }

   public String getstring(String var1, String var2, int var3) {
      int var5 = 0;
      String var7 = "";

      for (int var4 = var1.length() + 1; var4 < var2.length(); var4++) {
         String var6 = "" + var2.charAt(var4);
         if (var6.equals(",") || var6.equals(")")) {
            var5++;
            var4++;
         }

         if (var5 == var3) {
            var7 = var7 + var2.charAt(var4);
         }
      }

      return var7;
   }

   public int getint(String var1, String var2, int var3) {
      int var5 = 0;
      String var7 = "";

      for (int var4 = var1.length() + 1; var4 < var2.length(); var4++) {
         String var6 = "" + var2.charAt(var4);
         if (var6.equals(",") || var6.equals(")")) {
            var5++;
            var4++;
         }

         if (var5 == var3) {
            var7 = var7 + var2.charAt(var4);
         }
      }

      return Integer.valueOf(var7);
   }

   public Image getImage(String var1) {
      Image var2 = Toolkit.getDefaultToolkit().createImage(var1);
      MediaTracker var3 = new MediaTracker(this);
      var3.addImage(var2, 0);

      try {
         var3.waitForID(0);
      } catch (Exception var5) {
      }

      return var2;
   }

   public int servervalue(String var1, int var2) {
      int var3 = -1;

      try {
         int var4 = 0;
         int var5 = 0;
         byte var6 = 0;
         String var7 = "";

         String var8;
         for (var8 = ""; var4 < var1.length() && var6 != 2; var4++) {
            var7 = "" + var1.charAt(var4);
            if (var7.equals("|")) {
               if (var6 == 1 || ++var5 > var2) {
                  var6 = 2;
               }
            } else if (var5 == var2) {
               var8 = var8 + var7;
               var6 = 1;
            }
         }

         if (var8.equals("")) {
            var8 = "-1";
         }

         var3 = Integer.valueOf(var8);
      } catch (Exception var9) {
      }

      return var3;
   }

   public String serverSvalue(String var1, int var2) {
      String var3 = "";

      try {
         int var4 = 0;
         int var5 = 0;
         byte var6 = 0;
         String var7 = "";

         String var8;
         for (var8 = ""; var4 < var1.length() && var6 != 2; var4++) {
            var7 = "" + var1.charAt(var4);
            if (var7.equals("|")) {
               if (var6 == 1 || ++var5 > var2) {
                  var6 = 2;
               }
            } else if (var5 == var2) {
               var8 = var8 + var7;
               var6 = 1;
            }
         }

         var3 = var8;
      } catch (Exception var9) {
      }

      return var3;
   }

   public int getvalue(String var1, String var2, int var3) {
      int var5 = 0;
      String var7 = "";

      for (int var4 = var1.length() + 1; var4 < var2.length(); var4++) {
         String var6 = "" + var2.charAt(var4);
         if (var6.equals(",") || var6.equals(")")) {
            var5++;
            var4++;
         }

         if (var5 == var3) {
            var7 = var7 + var2.charAt(var4);
         }
      }

      return Float.valueOf(var7).intValue();
   }

   public String getSvalue(String var1, String var2, int var3) {
      String var4 = "";
      int var5 = 0;

      for (int var6 = var1.length() + 1; var6 < var2.length() && var5 <= var3; var6++) {
         String var7 = "" + var2.charAt(var6);
         if (var7.equals(",") || var7.equals(")")) {
            var5++;
         } else if (var5 == var3) {
            var4 = var4 + var7;
         }
      }

      return var4;
   }

   public boolean button(String var1, int var2, int var3, int var4, boolean var5) {
      this.rd.setFont(new Font("Arial", 1, 12));
      this.ftm = this.rd.getFontMetrics();
      int var6 = this.ftm.stringWidth(var1);
      boolean var7 = false;
      boolean var8 = false;
      if (var1.equals(" Cancel ") && this.epart && Math.abs(this.xm - var2) < var6 / 2 + 12 && Math.abs(this.ym - var3 + 5) < 10) {
         this.overcan = true;
      }

      if (Math.abs(this.xm - var2) < var6 / 2 + 12 && Math.abs(this.ym - var3 + 5) < 10 && this.mouses == 1) {
         var7 = true;
      } else {
         var7 = false;
      }

      if (Math.abs(this.xm - var2) < var6 / 2 + 12 && Math.abs(this.ym - var3 + 5) < 10 && this.mouses == -1) {
         this.mouses = 0;
         var8 = true;
      }

      boolean var9 = false;
      if (var5) {
         if (this.tab == 0) {
            this.rd.setColor(new Color(207, 207, 207));
         }

         if (this.tab == 1) {
            this.rd.setColor(new Color(200, 200, 200));
         }

         if (this.tab == 2) {
            this.rd.setColor(new Color(170, 170, 170));
         }

         if (this.tab != 3) {
            this.rd.drawRect(var2 - var6 / 2 - 15, var3 - (22 - var4), var6 + 29, 34 - var4 * 2);
            if (var4 == 2 && this.tab == 1) {
               this.rd.setColor(new Color(220, 220, 220));
               this.rd.fillRect(var2 - var6 / 2 - 15, var3 - (22 - var4), var6 + 29, 34 - var4 * 2);
            }
         } else {
            var9 = true;
         }
      }

      if (!var7) {
         this.rd.setColor(new Color(220, 220, 220));
         if (var9) {
            this.rd.setColor(new Color(230, 230, 230));
         }

         this.rd.fillRect(var2 - var6 / 2 - 10, var3 - (17 - var4), var6 + 20, 25 - var4 * 2);
         this.rd.setColor(new Color(240, 240, 240));
         if (var9) {
            this.rd.setColor(new Color(255, 255, 255));
         }

         this.rd.drawLine(var2 - var6 / 2 - 10, var3 - (17 - var4), var2 + var6 / 2 + 10, var3 - (17 - var4));
         this.rd.drawLine(var2 - var6 / 2 - 10, var3 - (18 - var4), var2 + var6 / 2 + 10, var3 - (18 - var4));
         this.rd.setColor(new Color(240, 240, 240));
         this.rd.drawLine(var2 - var6 / 2 - 9, var3 - (19 - var4), var2 + var6 / 2 + 9, var3 - (19 - var4));
         this.rd.setColor(new Color(200, 200, 200));
         if (var9) {
            this.rd.setColor(new Color(192, 192, 192));
         }

         this.rd.drawLine(var2 + var6 / 2 + 10, var3 - (17 - var4), var2 + var6 / 2 + 10, var3 + (7 - var4));
         this.rd.drawLine(var2 + var6 / 2 + 11, var3 - (17 - var4), var2 + var6 / 2 + 11, var3 + (7 - var4));
         this.rd.setColor(new Color(200, 200, 200));
         if (var9) {
            this.rd.setColor(new Color(192, 192, 192));
         }

         this.rd.drawLine(var2 + var6 / 2 + 12, var3 - (16 - var4), var2 + var6 / 2 + 12, var3 + (6 - var4));
         this.rd.drawLine(var2 - var6 / 2 - 10, var3 + (7 - var4), var2 + var6 / 2 + 10, var3 + (7 - var4));
         this.rd.drawLine(var2 - var6 / 2 - 10, var3 + (8 - var4), var2 + var6 / 2 + 10, var3 + (8 - var4));
         this.rd.setColor(new Color(200, 200, 200));
         this.rd.drawLine(var2 - var6 / 2 - 9, var3 + (9 - var4), var2 + var6 / 2 + 9, var3 + (9 - var4));
         this.rd.setColor(new Color(240, 240, 240));
         if (var9) {
            this.rd.setColor(new Color(255, 255, 255));
         }

         this.rd.drawLine(var2 - var6 / 2 - 10, var3 - (17 - var4), var2 - var6 / 2 - 10, var3 + (7 - var4));
         this.rd.drawLine(var2 - var6 / 2 - 11, var3 - (17 - var4), var2 - var6 / 2 - 11, var3 + (7 - var4));
         this.rd.setColor(new Color(240, 240, 240));
         this.rd.drawLine(var2 - var6 / 2 - 12, var3 - (16 - var4), var2 - var6 / 2 - 12, var3 + (6 - var4));
         this.rd.setColor(new Color(0, 0, 0));
         if (var1.equals("  Keyboard Controls  ")) {
            this.rd.setColor(new Color(100, 100, 100));
         }

         this.rd.drawString(var1, var2 - var6 / 2, var3);
      } else {
         this.rd.setColor(new Color(220, 220, 220));
         this.rd.fillRect(var2 - var6 / 2 - 10, var3 - (17 - var4), var6 + 20, 25 - var4 * 2);
         this.rd.setColor(new Color(192, 192, 192));
         this.rd.drawLine(var2 - var6 / 2 - 10, var3 - (17 - var4), var2 + var6 / 2 + 10, var3 - (17 - var4));
         this.rd.drawLine(var2 - var6 / 2 - 10, var3 - (18 - var4), var2 + var6 / 2 + 10, var3 - (18 - var4));
         this.rd.drawLine(var2 - var6 / 2 - 9, var3 - (19 - var4), var2 + var6 / 2 + 9, var3 - (19 - var4));
         this.rd.setColor(new Color(247, 247, 247));
         this.rd.drawLine(var2 + var6 / 2 + 10, var3 - (17 - var4), var2 + var6 / 2 + 10, var3 + (7 - var4));
         this.rd.drawLine(var2 + var6 / 2 + 11, var3 - (17 - var4), var2 + var6 / 2 + 11, var3 + (7 - var4));
         this.rd.drawLine(var2 + var6 / 2 + 12, var3 - (16 - var4), var2 + var6 / 2 + 12, var3 + (6 - var4));
         this.rd.drawLine(var2 - var6 / 2 - 10, var3 + (7 - var4), var2 + var6 / 2 + 10, var3 + (7 - var4));
         this.rd.drawLine(var2 - var6 / 2 - 10, var3 + (8 - var4), var2 + var6 / 2 + 10, var3 + (8 - var4));
         this.rd.drawLine(var2 - var6 / 2 - 9, var3 + (9 - var4), var2 + var6 / 2 + 9, var3 + (9 - var4));
         this.rd.setColor(new Color(192, 192, 192));
         this.rd.drawLine(var2 - var6 / 2 - 10, var3 - (17 - var4), var2 - var6 / 2 - 10, var3 + (7 - var4));
         this.rd.drawLine(var2 - var6 / 2 - 11, var3 - (17 - var4), var2 - var6 / 2 - 11, var3 + (7 - var4));
         this.rd.drawLine(var2 - var6 / 2 - 12, var3 - (16 - var4), var2 - var6 / 2 - 12, var3 + (6 - var4));
         this.rd.setColor(new Color(0, 0, 0));
         if (var1.equals("  Keyboard Controls  ")) {
            this.rd.setColor(new Color(100, 100, 100));
         }

         this.rd.drawString(var1, var2 - var6 / 2 + 1, var3 + 1);
      }

      return var8;
   }

   public boolean ovbutton(String var1, int var2, int var3) {
      this.rd.setFont(new Font("Arial", 0, 12));
      this.ftm = this.rd.getFontMetrics();
      if (var1.equals("X") || var1.equals("Download")) {
         this.rd.setFont(new Font("Arial", 1, 12));
         this.ftm = this.rd.getFontMetrics();
      }

      int var4 = this.ftm.stringWidth(var1);
      byte var5 = 4;
      boolean var6 = false;
      boolean var7 = false;
      if (Math.abs(this.xm - var2) < var4 / 2 + 12 && Math.abs(this.ym - var3 + 5) < 10 && this.mouses == 1) {
         var6 = true;
      } else {
         var6 = false;
      }

      if (Math.abs(this.xm - var2) < var4 / 2 + 12 && Math.abs(this.ym - var3 + 5) < 10 && this.mouses == -1) {
         this.mouses = 0;
         var7 = true;
      }

      if (!var6) {
         this.rd.setColor(new Color(220, 220, 220));
         this.rd.fillRect(var2 - var4 / 2 - 10, var3 - (17 - var5), var4 + 20, 25 - var5 * 2);
         this.rd.setColor(new Color(240, 240, 240));
         this.rd.drawLine(var2 - var4 / 2 - 10, var3 - (17 - var5), var2 + var4 / 2 + 10, var3 - (17 - var5));
         this.rd.drawLine(var2 - var4 / 2 - 10, var3 - (18 - var5), var2 + var4 / 2 + 10, var3 - (18 - var5));
         this.rd.setColor(new Color(240, 240, 240));
         this.rd.drawLine(var2 - var4 / 2 - 9, var3 - (19 - var5), var2 + var4 / 2 + 9, var3 - (19 - var5));
         this.rd.setColor(new Color(200, 200, 200));
         this.rd.drawLine(var2 + var4 / 2 + 10, var3 - (17 - var5), var2 + var4 / 2 + 10, var3 + (7 - var5));
         this.rd.drawLine(var2 + var4 / 2 + 11, var3 - (17 - var5), var2 + var4 / 2 + 11, var3 + (7 - var5));
         this.rd.setColor(new Color(200, 200, 200));
         this.rd.drawLine(var2 + var4 / 2 + 12, var3 - (16 - var5), var2 + var4 / 2 + 12, var3 + (6 - var5));
         this.rd.drawLine(var2 - var4 / 2 - 10, var3 + (7 - var5), var2 + var4 / 2 + 10, var3 + (7 - var5));
         this.rd.drawLine(var2 - var4 / 2 - 10, var3 + (8 - var5), var2 + var4 / 2 + 10, var3 + (8 - var5));
         this.rd.setColor(new Color(200, 200, 200));
         this.rd.drawLine(var2 - var4 / 2 - 9, var3 + (9 - var5), var2 + var4 / 2 + 9, var3 + (9 - var5));
         this.rd.setColor(new Color(240, 240, 240));
         this.rd.drawLine(var2 - var4 / 2 - 10, var3 - (17 - var5), var2 - var4 / 2 - 10, var3 + (7 - var5));
         this.rd.drawLine(var2 - var4 / 2 - 11, var3 - (17 - var5), var2 - var4 / 2 - 11, var3 + (7 - var5));
         this.rd.setColor(new Color(240, 240, 240));
         this.rd.drawLine(var2 - var4 / 2 - 12, var3 - (16 - var5), var2 - var4 / 2 - 12, var3 + (6 - var5));
         this.rd.setColor(new Color(0, 0, 0));
         if (var1.equals("X")) {
            this.rd.setColor(new Color(255, 0, 0));
         }

         if (var1.equals("Download")) {
            this.rd.setColor(new Color(0, 64, 128));
         }

         this.rd.drawString(var1, var2 - var4 / 2, var3);
      } else {
         this.rd.setColor(new Color(220, 220, 220));
         this.rd.fillRect(var2 - var4 / 2 - 10, var3 - (17 - var5), var4 + 20, 25 - var5 * 2);
         this.rd.setColor(new Color(192, 192, 192));
         this.rd.drawLine(var2 - var4 / 2 - 10, var3 - (17 - var5), var2 + var4 / 2 + 10, var3 - (17 - var5));
         this.rd.drawLine(var2 - var4 / 2 - 10, var3 - (18 - var5), var2 + var4 / 2 + 10, var3 - (18 - var5));
         this.rd.drawLine(var2 - var4 / 2 - 9, var3 - (19 - var5), var2 + var4 / 2 + 9, var3 - (19 - var5));
         this.rd.setColor(new Color(247, 247, 247));
         this.rd.drawLine(var2 + var4 / 2 + 10, var3 - (17 - var5), var2 + var4 / 2 + 10, var3 + (7 - var5));
         this.rd.drawLine(var2 + var4 / 2 + 11, var3 - (17 - var5), var2 + var4 / 2 + 11, var3 + (7 - var5));
         this.rd.drawLine(var2 + var4 / 2 + 12, var3 - (16 - var5), var2 + var4 / 2 + 12, var3 + (6 - var5));
         this.rd.drawLine(var2 - var4 / 2 - 10, var3 + (7 - var5), var2 + var4 / 2 + 10, var3 + (7 - var5));
         this.rd.drawLine(var2 - var4 / 2 - 10, var3 + (8 - var5), var2 + var4 / 2 + 10, var3 + (8 - var5));
         this.rd.drawLine(var2 - var4 / 2 - 9, var3 + (9 - var5), var2 + var4 / 2 + 9, var3 + (9 - var5));
         this.rd.setColor(new Color(192, 192, 192));
         this.rd.drawLine(var2 - var4 / 2 - 10, var3 - (17 - var5), var2 - var4 / 2 - 10, var3 + (7 - var5));
         this.rd.drawLine(var2 - var4 / 2 - 11, var3 - (17 - var5), var2 - var4 / 2 - 11, var3 + (7 - var5));
         this.rd.drawLine(var2 - var4 / 2 - 12, var3 - (16 - var5), var2 - var4 / 2 - 12, var3 + (6 - var5));
         this.rd.setColor(new Color(0, 0, 0));
         if (var1.equals("X")) {
            this.rd.setColor(new Color(255, 0, 0));
         }

         if (var1.equals("Download")) {
            this.rd.setColor(new Color(0, 64, 128));
         }

         this.rd.drawString(var1, var2 - var4 / 2 + 1, var3 + 1);
      }

      return var7;
   }

   public void openlink() {
      Madness.openurl("http://www.needformadness.com/developer/help.html");
   }

   public void openhlink() {
      Madness.openurl("http://www.needformadness.com/developer/");
   }
}
