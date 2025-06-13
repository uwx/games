import java.applet.Applet;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.swing.JOptionPane;

public class CarMaker extends Applet implements Runnable, ActionListener {
   Graphics2D rd;
   Image offImage;
   Thread thredo;
   boolean exwist = false;
   FontMetrics ftm;
   int apx = 0;
   int apy = 0;
   boolean focuson = true;
   Image[] btgame = new Image[2];
   Image logo;
   boolean onbtgame = false;
   int tab = 0;
   int tabed = -1;
   boolean loadedfile = false;
   String carname = "";
   String scar = "";
   String suser = "Horaks";
   String sfont = "Monospaced";
   int sthm = 0;
   int sfase = 0;
   Smenu slcar = new Smenu(2000);
   boolean tutok = false;
   int flk = 0;
   boolean changed = false;
   String lastedo = "";
   boolean prefs = false;
   boolean mirror = false;
   PopupMenu popupMenu;
   TextArea editor = new TextArea(20, 20);
   TextField srch = new TextField("", 15);
   TextField rplc = new TextField("", 15);
   Smenu fontsel = new Smenu(40);
   String cfont = "Monospaced";
   Smenu ctheme = new Smenu(40);
   Color defb;
   Color deff;
   int cthm = 0;
   int cntprf = 0;
   int cntpls = 0;
   int cntchk = 0;
   int npolys = 0;
   boolean tomany = false;
   int ox = 335;
   int oy = 40;
   int oz = 800;
   int oxz = -90;
   int oxy = 0;
   int ozy = 0;
   Medium m = new Medium();
   Trackers t = new Trackers();
   ContO o;
   ContO[] compo = new ContO[16];
   boolean right = false;
   boolean left = false;
   boolean up = false;
   boolean down = false;
   boolean rotl = false;
   boolean rotr = false;
   boolean plus = false;
   boolean minus = false;
   boolean in = false;
   boolean out = false;
   boolean pflk = false;
   boolean breakbond = false;
   int polynum = -1;
   int prflk = 0;
   int bfo = 0;
   int dtab = 0;
   int dtabed = -1;
   int mouseon = -1;
   String fcol = "";
   String ofcol = "";
   String scol = "";
   String oscol = "";
   float[] fhsb = new float[]{0.5F, 0.5F, 0.5F};
   float[] shsb = new float[]{0.5F, 0.5F, 0.5F};
   int[] scale = new int[]{100, 100, 100};
   int[] oscale = new int[]{100, 100, 100};
   Smenu compcar = new Smenu(40);
   int compsel = 0;
   int[] adna = new int[]{276, 276, 276, 276, 276, 276};
   boolean changed2 = false;
   TextField[] wv = new TextField[16];
   boolean defnow = false;
   String aply1 = "";
   String aply2 = "";
   boolean aplyd1 = false;
   boolean aplyd2 = false;
   boolean forwheels = false;
   Smenu cls = new Smenu(40);
   Smenu simcar = new Smenu(40);
   int[] stat = new int[]{100, 100, 100, 100, 100};
   int[] rstat = new int[]{0, 0, 0, 0, 0};
   int[][] carstat = new int[][]{
      {110, 81, 131, 98, 100},
      {200, 200, 88, 16, 16},
      {108, 80, 93, 114, 125},
      {146, 119, 100, 83, 72},
      {109, 85, 141, 96, 93},
      {128, 98, 102, 109, 123},
      {115, 139, 96, 117, 133},
      {120, 81, 145, 126, 128},
      {140, 122, 101, 113, 124},
      {110, 144, 100, 154, 92},
      {133, 122, 144, 115, 126},
      {107, 96, 96, 192, 189},
      {192, 200, 106, 92, 90},
      {88, 104, 88, 200, 200},
      {148, 150, 197, 95, 90},
      {112, 128, 120, 192, 128}
   };
   int carsel = 0;
   int clsel = 0;
   boolean statdef = false;
   int pfase = 0;
   int[] phys = new int[]{50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50};
   int[] rphys = new int[]{50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50};
   int[] crash = new int[]{50, 50, 50};
   int[] rcrash = new int[]{50, 50, 50};
   String[] pname = new String[]{
      "Handbrake",
      "Turning Sensitivity",
      "Tire Grip",
      "Bouncing",
      "Empty",
      "Lifts Others",
      "Gets Lifted",
      "Pushes Others",
      "Gets Pushed",
      "Aerial Rotation Speed",
      "Aerial Control/Gliding"
   };
   int[] pnx = new int[]{62, 20, 76, 71, 60, 38, 44, 20, 33, 320, 324};
   String[] usage = new String[]{
      "Handbrake:\nThis defines the hand braking power of the car.\nThe more handbrake the car has the faster it brakes when you press Spacebar while driving.\nBut also the lesser the Handbrake the more the car can drift when you press Spacebar.\n\n",
      "Turning Sensitivity:\nThis defines how fast the car turns (or how fast the wheels respond to turning).\nThe more turning sensitive the faster the car turns and responds.\n\nWhen designing a fast car that is more racing oriented high turning sensitivity is     \nrecommended for the car to be able to take sharp and quick turns.\nHowever too much turning sensitivity can make the car hard to drive!\n\nWhen designing a slower and bigger car (like El King) lower turning sensitivity is\nrecommended for a more realistic effect.\n\n",
      "Tires Grip:\nThis defines the griping power of the car’s wheels on the ground.\n\nThe more griping the more the cars sticks to track.\nThe less gripping the more the car drifts in the turns.\n\nSome drifting can be helpful as it makes the car drive smoother while less drifting can\nmake the car more irritable, it depends on how you like to drive the car and how it\nfeels for you.\n\n",
      "Bouncing:\nThis defines how the car bounces back when it hits the ground or obstacles.\n\nBouncing can help when performing stunts as when you land up side down\nif the car bounces it can be filliped over before landing again to avoid a 'bad landing'.\n\nHowever bouncing is not helpful in controlling the car and in racing.\n\n",
      "If you can read this then you are decompiling the code! Please don’t bother trying to allow the car maker to give you max stats, the stats get check on the server before the car can be accepted. Just to save you sometime.",
      "Lifts Others:\nThis defines if the car lifts up other cars when it collides with them from the front and\nhow high it can lift them.\n\nDoes the car have a pointy nose like MAX Revenge, Radical One or La Vita Crab, a\npointy nose/front part that can go under the wheels of other cars and lift them?\nIf so then give it some Lifts Others.\n\nIf it has a nose/front part that is a block like most cars then give it 0 Lifts Others.\n\n",
      "Gets Lifted:\nThis defines if the car can get lifted over other cars when it collides with them and how\nhigh it can get lifted.\n\nIs the car higher off the ground like Wow Caninaro or has big wheels like Dr Monstaa,\nshould its jump over cars when it collides with them?\nIf so then give it some Gets Lifted depending on how high it should go.\n\nIf the car is lower to the ground like most cars then it should have 0 Gets Lifted\n\n",
      "Pushes Others:\nThis defines if the car pushes other cars away when it collides with them and how far it\ncan push them.\n\nIs the car a heavy car with a strong body like MASHEEN or El King, where when it\ncollides with other cars it pushes them away?\nOr does the car have special bumpers or body parts for pushing cars away like Sword of\nJustice has?\nIf so then give it some Pushes Others depending how strong you think it can push cars.\n\nIf it is a car like any other car, with an average weight and body strength then you should\ngive it 0 Pushes Others.\n\n",
      "Gets Pushed:\nThis defines if the car gets pushed away when it collides with other cars and how far it\ngets pushed away.\n\nIf the car is lighter then most cars, then it should get pushed away when it collides with\nothers cars.\nGetting pushed can be helpful if the car is week because it gets it away from the danger\n(from the car that hit it) faster, making it take lesser hits and escape better.\nHowever getting pushed is not helpful when racing.\n\n",
      "Aerial Rotation Speed:\nThis adjusts how fast the car can rotate and flip in the air when its performing a stunt.\n\nThis variable also depends on how much the ‘Stunts’ stat of the car is, if the car has a\nhigh Stunts stat then this variable will have a much bigger effect, if it has low Stunts stat\nthe variable will have a lower effect.\n\nIf you think the car is rotating too fast or too slow in the air when performing a stunt use\nthis variable to adjust that.\n\nIf the aerial rotation is too fast it can make the car hard to control in the air as it flips and\nhard to land upright.\n\nIf the car is a big and heavy car like MASHHEN or El King then it should have low\naerial rotation for a realistic effect.\n\n",
      "Aerial Control/Gliding:\nThis adjusts the cars ability to push itself in the air and glide when performing stunts!\n\nIf you don’t know, in the game:\nBackward looping pushes the car upwards. \nForward looping pushes the car forwards. \nLeft and right rolling pushes the car left and right. \n\nThis variable adjust the power if this aerial push.\n\nThe variable also depends on how much the ‘Stunts’ stat of the car is, if the car has a\nhigh Stunts stat then this variable will have a much bigger effect, if it has low Stunts stat\nthe variable will have a lower effect.\n\nIf the car has some kind of wings or fins like Radical One or Kool Kat have then it should\nhave higher aerial control and gliding ability.\n\n",
      "Crash Look Test!\nThis defines how the car will look when it gets damaged.\nOr in other words what the car will look like as it gets damaged until it becomes wasted!\n\nIMPORTANT:\nYou need to perform a 'Normal Crash' test with a 'Roof Crash' test until the car gets totally destroyed (gets wasted and burns).\nYou need to also try a 'Normal Crash' test alone (without the roof crash) until the car gets wasted!\nA 'Roof Crash' happens significantly more when the car falls on its roof from a high jumps.\nA 'Normal Crash' is what happens as the car crashes normally with other cars and obstacles.\n\nClick any of adjustment variable names ‘Radius’, ‘Magnitude’ and ‘Roof Destruction’ to learn about their effect.\n\n>  You must perform the crash test more then once in order to make sure that this is how your want the car to look as it gets damaged\nuntil total destruction.",
      "Crash Radius:\nThe radius around the crash at which the polygons/pieces that lay inside it get\naffected.\n\nOr basically in other words the number of pieces that get affected on collision (the pieces\naround the crash location).\n\nIncreasing the radius will result in more pieces/polygons around the point of collision\ngetting crashed and distorted.\nDecreasing the radius means less pieces/polygons around the collision point getting\ndistorted and crashed.\n\n",
      "Crash Magnitude:\nThe magnitude of the distortion and indentation to occur on the effected pieces/polygons.\n\nOr basically in other words the amount of destruction that happens to each piece when\ncrashed.\n\nHigher magnitude means the piece gets more destructed from an amount of damage,\nlower magnitude means the piece gets less destructed from that same amount of damage.\n\n",
      "Roof Destruction:\nThe amount of destruction to occur on the car’s top.\nThe length of indentation and destruction to happen from above.\n\nTo really see this variable's effect try crashing the roof alone (without a normal crash),\ntry more then once while fixing the car and changing the variable’s value to see the\ndifference.\n\nThe roof crash normally happens in the game when the car lands upside down from a\njump or when a big car like Dr Monstaa steps on it.\n\n"
   };
   int hitmag = 0;
   int actmag = 0;
   int squash = 0;
   boolean crashok = false;
   boolean crashleft = false;
   soundClip[] crashs = new soundClip[3];
   soundClip[] lowcrashs = new soundClip[3];
   Smenu engine = new Smenu(40);
   soundClip[][] engs = new soundClip[5][5];
   int engsel = 0;
   boolean engon = false;
   Smenu witho = new Smenu(40);
   boolean tested = false;
   boolean rateh = false;
   int handling = 140;
   int logged = 0;
   TextField tnick = new TextField("", 15);
   TextField tpass = new TextField("", 15);
   Smenu pubitem = new Smenu(707);
   Smenu pubtyp = new Smenu(40);
   int nmc = 0;
   int roto = 0;
   String[] mycars = new String[20];
   String[] maker = new String[20];
   int[] pubt = new int[20];
   int[] clas = new int[20];
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
   int sls = -1;
   int sle = -1;
   int crshturn = 0;
   boolean crashup = false;
   boolean openm = false;
   boolean mousdr = false;
   boolean waso = false;
   boolean objfacend = false;
   boolean multf10 = false;

   private static final String cmfpath = "/files/";

   @Override
   public void run() {
      this.thredo.setPriority(10);
      this.btgame[0] = this.getImage("" + Madness.fpath + "data/backtogame1.gif");
      this.btgame[1] = this.getImage("" + Madness.fpath + "data/backtogame2.gif");
      this.logo = this.getImage("" + Madness.fpath + "data/carmakerlogo.gif");
      this.m.w = 700;
      this.m.cx = 350;
      this.m.y = -240;
      this.m.z = -400;
      this.m.zy = 4;
      this.m.focus_point = 800;
      this.m.fadfrom(8000);
      this.m.cfade[0] = 187;
      this.m.cfade[1] = 210;
      this.m.cfade[2] = 227;
      this.loadsounds();
      this.loadbase();
      this.m.loadnew = true;
      this.loadsettings();
      this.editor.setFont(new Font(this.cfont, 1, 14));
      this.srch.setFont(new Font(this.cfont, 1, 14));
      this.rplc.setFont(new Font(this.cfont, 1, 14));

      for (int var1 = 0; var1 < 16; var1++) {
         this.wv[var1].setFont(new Font(this.cfont, 1, 14));
      }

      this.setheme();
      if (Madness.testdrive != 0) {
         if (Madness.testcar.equals("Failx12")) {
            JOptionPane.showMessageDialog(null, "Failed to load car! Please make sure car is saved before Test Drive.", "Car Maker", 1);
            this.thredo.stop();
         } else {
            this.carname = Madness.testcar;
            this.loadfile();
            if (this.loadedfile) {
               this.tested = true;
               this.tab = 2;
               this.dtab = 6;
               this.witho.select(Madness.testdrive - 1);
            }
         }

         Madness.testcar = "";
         Madness.testdrive = 0;
      }

      boolean var50 = false;
      if (!this.carname.equals("")) {
         this.tutok = true;
         var50 = true;
      }

      while (!this.exwist) {
         if (this.tab != this.tabed) {
            this.hidefields();
            if (this.tab == 1) {
               this.editor.enable();
            } else {
               this.editor.disable();
            }

            if (this.tabed == 2) {
               if (!this.breakbond) {
                  if (!this.editor.getText().equals(this.lastedo)) {
                     this.editor.setText(this.lastedo);
                  }
               } else {
                  this.breakbond = false;
               }
            }

            this.setCursor(new Cursor(0));
         }

         this.rd.setColor(new Color(225, 225, 225));
         this.rd.fillRect(0, 0, 700, 550);
         this.rd.setColor(new Color(0, 0, 0));
         this.btn = 0;
         byte var2 = 50;
         if (this.tab == 0) {
            if (this.tabed != this.tab) {
               this.slcar.removeAll();
               this.slcar.maxl = 200;
               this.slcar.add(this.rd, "Select a Car                      ");
               String[] var3 = new File("" + cmfpath + "mycars/").list();
               if (var3 != null) {
                  for (int var4 = 0; var4 < var3.length; var4++) {
                     if (var3[var4].toLowerCase().endsWith(".rad")) {
                        this.slcar.add(this.rd, var3[var4].substring(0, var3[var4].length() - 4));
                     }
                  }
               }

               if (this.carname.equals("")) {
                  this.slcar.select(0);
               } else {
                  this.slcar.select(this.carname);
                  if (this.carname.equals(this.slcar.getSelectedItem())) {
                     this.loadfile();
                  }
               }

               this.mouseon = -1;
               this.srch.setText("");
               this.sfase = 0;
            }

            this.rd.setFont(new Font("Arial", 1, 13));
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawImage(this.logo, 214, 35, null);
            if (this.xm > 214 && this.xm < 485 && this.ym > 25 && this.ym < 104 && !this.openm) {
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

            short var51 = 30;
            byte var64 = 0;
            if (this.tutok) {
               var51 = 250;
               var64 = -70;
            }

            if (this.xm > 76 && this.xm < 624 && this.ym > 84 + var51 && this.ym < 167 + var51 && !this.openm) {
               if (this.mouseon == -1) {
                  this.mouseon = 1;
                  this.setCursor(new Cursor(12));
               }
            } else if (this.mouseon == 1) {
               this.mouseon = -1;
               this.setCursor(new Cursor(0));
            }

            byte var5 = 0;
            if (!this.tutok && this.mouseon != 1 && !var50) {
               if (this.flk <= 0) {
                  this.rd.setColor(new Color(255, 0, 0));
                  this.flk--;
                  if (this.flk == -2) {
                     this.flk = 1;
                  }
               } else {
                  this.rd.setColor(new Color(0, 0, 255));
                  var5 = 2;
                  this.flk++;
                  if (this.flk == 3) {
                     this.flk = 0;
                  }
               }
            }

            this.rd.drawLine(76 + var5, 84 + var51, 76 + var5, 167 + var51);
            this.rd.drawLine(76 + var5, 84 + var51, 95 + var5, 84 + var51);
            this.rd.drawLine(76 + var5, 167 + var51, 95 + var5, 167 + var51);
            this.rd.drawLine(624 - var5, 84 + var51, 624 - var5, 167 + var51);
            this.rd.drawLine(624 - var5, 84 + var51, 605 - var5, 84 + var51);
            this.rd.drawLine(624 - var5, 167 + var51, 605 - var5, 167 + var51);
            if (this.mouseon == 1) {
               this.rd.setColor(new Color(0, 64, 128));
            } else {
               this.rd.setColor(new Color(0, 0, 0));
            }

            this.rd.drawString("If this is your first time creating a car please follow the tutorial found at:", 106, 110 + var51);
            this.rd.setColor(new Color(0, 128, 255));
            this.rd.drawString("http://www.needformadness.com/developer/simplecar.html", 106, 130 + var51);
            if (this.mouseon == 1) {
               this.rd.setColor(new Color(0, 128, 255));
            } else {
               this.rd.setColor(new Color(0, 64, 128));
            }

            this.rd.drawLine(106, 131 + var51, 480, 131 + var51);
            if (this.mouseon == 1) {
               this.rd.setColor(new Color(0, 64, 128));
            } else {
               this.rd.setColor(new Color(0, 0, 0));
            }

            this.rd.drawString("It is highly recommended that you follow this tutorial before trying anything!", 106, 150 + var51);
            if (this.mouseon == 1 && this.mouses == -1) {
               this.openlink();
               var50 = true;
            }

            if (this.xm > 200 && this.xm < 500 && this.ym > 467 && this.ym < 504 && !this.openm) {
               if (this.mouseon == -1) {
                  this.mouseon = 2;
                  this.setCursor(new Cursor(12));
               }
            } else if (this.mouseon == 2) {
               this.mouseon = -1;
               this.setCursor(new Cursor(0));
            }

            this.ftm = this.rd.getFontMetrics();
            if (this.mouseon == 2) {
               this.rd.setColor(new Color(0, 64, 128));
            } else {
               this.rd.setColor(new Color(0, 0, 0));
            }

            this.rd
               .drawString(
                  "For the Car Maker Homepage, Development Center and Forums :",
                  350 - this.ftm.stringWidth("For the Car Maker Homepage, Development Center and Forums :") / 2,
                  480
               );
            this.rd.setColor(new Color(0, 128, 255));
            String var6 = "http://www.needformadness.com/developer/";
            this.rd.drawString(var6, 350 - this.ftm.stringWidth(var6) / 2, 500);
            if (this.mouseon == 2) {
               this.rd.setColor(new Color(0, 128, 255));
            } else {
               this.rd.setColor(new Color(0, 64, 128));
            }

            this.rd.drawLine(350 - this.ftm.stringWidth(var6) / 2, 501, 350 + this.ftm.stringWidth(var6) / 2, 501);
            if (this.mouseon == 2 && this.mouses == -1) {
               this.openhlink();
            }

            byte var7 = 0;
            if (this.sfase == 3) {
               var7 = 100;
            }

            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawRect(177 - var7, 202 + var64, 346 + var7 * 2, 167 + var7 / 5);
            if (this.sfase == 0) {
               this.rd.drawString("Select Car to Edit", 350 - this.ftm.stringWidth("Select Car to Edit") / 2, 230 + var64);
               this.slcar.move(250, 240 + var64);
               if (this.slcar.getWidth() != 200) {
                  this.slcar.setSize(200, 21);
               }

               if (!this.slcar.isShowing()) {
                  this.slcar.show();
               }

               this.stringbutton("    Make new Car    ", 430, 296 + var64, 0, true);
               this.stringbutton("     Rename Car     ", 270, 296 + var64, 0, false);
               this.stringbutton("      Delete Car      ", 270, 336 + var64, 0, false);
               this.stringbutton("     Import & Export     ", 430, 336 + var64, 0, false);
               if (this.slcar.getSelectedIndex() != 0) {
                  if (!this.carname.equals(this.slcar.getSelectedItem())) {
                     this.tomany = false;
                     this.carname = this.slcar.getSelectedItem();
                     this.loadfile();
                     this.editor.select(0, 0);
                     this.tested = false;
                     this.requestFocus();
                  }
               } else {
                  this.carname = "";
               }
            }

            if (this.sfase == 1) {
               this.rd.drawString("Make a new Car", 350 - this.ftm.stringWidth("Make a new Car") / 2, 230 + var64);
               this.rd.setFont(new Font("Arial", 1, 12));
               this.rd.drawString("New car name :", 228, 266 + var64);
               this.movefield(this.srch, 335, 250 + var64, 129, 22);
               if (!this.srch.isShowing()) {
                  this.srch.show();
                  this.srch.requestFocus();
               }

               this.fixtext(this.srch);
               this.stringbutton("    Make Car    ", 350, 306 + var64, 0, true);
               this.stringbutton("  Cancel  ", 350, 346 + var64, 0, false);
            }

            if (this.sfase == 2) {
               this.rd.drawString("Rename Car :  " + this.carname + "", 350 - this.ftm.stringWidth("Rename Car :  " + this.carname + "") / 2, 230 + var64);
               this.rd.setFont(new Font("Arial", 1, 12));
               this.rd.drawString("New name :", 239, 266 + var64);
               this.movefield(this.srch, 316, 250 + var64, 129, 22);
               if (!this.srch.isShowing()) {
                  this.srch.show();
                  this.srch.requestFocus();
               }

               this.fixtext(this.srch);
               this.stringbutton("   Rename Car   ", 350, 306 + var64, 0, true);
               this.stringbutton("  Cancel  ", 350, 346 + var64, 0, false);
            }

            if (this.sfase == 3) {
               this.rd.drawString("Import a Wavefront OBJ 3D Model", 350 - this.ftm.stringWidth("Import a Wavefront OBJ 3D Model") / 2, 230 + var64);
               if (this.xm > 116 && this.xm < 584 && this.ym > 246 + var64 && this.ym < 290 + var64) {
                  if (this.mouseon == -1) {
                     this.mouseon = 3;
                     this.setCursor(new Cursor(12));
                  }
               } else if (this.mouseon == 3) {
                  this.mouseon = -1;
                  this.setCursor(new Cursor(0));
               }

               this.ftm = this.rd.getFontMetrics();
               if (this.mouseon == 3) {
                  this.rd.setColor(new Color(0, 64, 128));
               } else {
                  this.rd.setColor(new Color(0, 0, 0));
               }

               this.rd
                  .drawString(
                     "Please read the important information about importing cars found at:",
                     350 - this.ftm.stringWidth("Please read the important information about importing cars, found here :") / 2,
                     260 + var64
                  );
               this.rd.setColor(new Color(0, 128, 255));
               var6 = "http://www.needformadness.com/developer/extras.html";
               this.rd.drawString(var6, 350 - this.ftm.stringWidth(var6) / 2, 280 + var64);
               if (this.mouseon == 3) {
                  this.rd.setColor(new Color(0, 128, 255));
               } else {
                  this.rd.setColor(new Color(0, 64, 128));
               }

               this.rd.drawLine(350 - this.ftm.stringWidth(var6) / 2, 281 + var64, 350 + this.ftm.stringWidth(var6) / 2, 281 + var64);
               if (this.mouseon == 3 && this.mouses == -1) {
                  this.openelink();
               }

               this.stringbutton("     Import Car     ", 350, 326 + var64, 0, true);
               this.stringbutton("  Export >  ", 550, 326 + var64, 0, false);
               this.stringbutton("  Cancel  ", 350, 366 + var64, 0, false);
            }

            if (this.sfase == 4) {
               this.rd.drawString("Select Car to Export", 350 - this.ftm.stringWidth("Select Car to Export") / 2, 230 + var64);
               this.slcar.move(250, 240 + var64);
               if (this.slcar.getWidth() != 200) {
                  this.slcar.setSize(200, 21);
               }

               if (!this.slcar.isShowing()) {
                  this.slcar.show();
               }

               this.stringbutton("     Export Car     ", 350, 306 + var64, 0, true);
               this.stringbutton("  Cancel  ", 350, 346 + var64, 0, false);
               if (this.slcar.getSelectedIndex() != 0) {
                  if (!this.carname.equals(this.slcar.getSelectedItem())) {
                     this.tomany = false;
                     this.carname = this.slcar.getSelectedItem();
                     this.loadfile();
                     this.editor.select(0, 0);
                     this.tested = false;
                     this.requestFocus();
                  }
               } else {
                  this.carname = "";
               }
            }
         }

         if (this.tab == 1) {
            if (this.tabed != this.tab) {
               this.srch.setText("");
               this.rplc.setText("");
               this.cntchk = 1;
               this.npolys = 0;
               this.prefs = false;
            }

            this.movefield(this.editor, 5, 30, 690, 400);
            if (!this.openm) {
               if (!this.editor.isShowing()) {
                  this.editor.show();
                  this.editor.requestFocus();
               }
            } else if (this.editor.isShowing()) {
               this.editor.hide();
            }

            this.rd.setFont(new Font("Arial", 1, 12));
            if (this.prefs) {
               this.rd.drawString("Code Font:", 10, 446);
               this.fontsel.move(76, 430);
               if (!this.fontsel.isShowing()) {
                  this.fontsel.show();
                  this.fontsel.select(this.cfont);
               }

               if (!this.cfont.equals(this.fontsel.getSelectedItem())) {
                  this.cntprf = 0;
                  this.cfont = this.fontsel.getSelectedItem();
                  this.editor.setFont(new Font(this.cfont, 1, 14));
                  this.srch.setFont(new Font(this.cfont, 1, 14));
                  this.rplc.setFont(new Font(this.cfont, 1, 14));

                  for (int var52 = 0; var52 < 16; var52++) {
                     this.wv[var52].setFont(new Font(this.cfont, 1, 14));
                  }

                  this.editor.requestFocus();
               }

               this.rd.drawString("Code Theme:", 190, 446);
               this.ctheme.move(271, 430);
               if (!this.ctheme.isShowing()) {
                  this.ctheme.show();
                  this.ctheme.select(this.cthm);
               }

               if (this.cthm != this.ctheme.getSelectedIndex()) {
                  this.cntprf = 0;
                  this.cthm = this.ctheme.getSelectedIndex();
                  this.setheme();
                  this.editor.requestFocus();
               }

               this.stringbutton("<", 400, 446, 3, false);
               this.cntprf++;
               if (this.cntprf == 200) {
                  this.prefs = false;
               }
            } else {
               this.stringbutton("Preferences", 52, 446, 3, false);
               if (this.ctheme.isShowing()) {
                  this.ctheme.hide();
               }

               if (this.fontsel.isShowing()) {
                  this.fontsel.hide();
               }

               if (this.cntprf != 0) {
                  this.cntprf = 0;
               }

               if (this.cntchk != 0) {
                  this.cntchk--;
               } else {
                  this.npolys = 0;
                  int var53 = 0;
                  boolean var65 = false;

                  while (var53 != -1 && this.mouses != 1) {
                     if (!var65) {
                        var53 = this.editor.getText().indexOf("<p>", var53);
                     } else {
                        var53 = this.editor.getText().indexOf("</p>", var53);
                     }

                     if (var53 != -1) {
                        if (!var65) {
                           var65 = true;
                        } else {
                           var65 = false;
                           this.npolys++;
                        }

                        var53 += 3;
                     }
                  }

                  if (this.mouses == 1) {
                     this.npolys = 0;
                  }

                  this.cntchk = 30;
               }

               if (this.npolys > 210) {
                  this.rd.setColor(new Color(255, 0, 0));
               }

               if (this.npolys != 0) {
                  this.rd.drawString("Number of Polygons :  " + this.npolys + " / 210", 200, 446);
               }
            }

            if (!this.changed && !this.editor.getText().equals(this.lastedo)) {
               this.changed = true;
            }

            this.stringbutton("  Save  ", 490, 455, 0, this.changed);
            this.stringbutton("  Save & Preview  >  ", 600, 455, 0, this.changed);
            this.mirror = false;
            this.polynum = -1;
            this.cntpls = 0;
            String var54 = "";

            try {
               var54 = this.editor.getSelectedText();
            } catch (Exception var44) {
            }

            if (!var54.equals("")) {
               int var66 = var54.indexOf("<p>", 0);

               while (var66 != -1 && var66 + 1 < var54.length()) {
                  if (!this.mirror) {
                     var66 = var54.indexOf("</p>", var66 + 1);
                     if (var66 != -1) {
                        this.mirror = true;
                        this.cntpls++;
                     }
                  }

                  if (this.mirror) {
                     var66 = var54.indexOf("<p>", var66 + 1);
                     if (var66 != -1) {
                        this.mirror = false;
                     }
                  }
               }
            }

            if (!this.mirror) {
               this.rd.setColor(new Color(170, 170, 170));
               this.rd.drawRect(5, 474, 494, 70);
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawString("Text to find:", 18, 500);
               this.movefield(this.srch, 91, 484, 129, 22);
               if (!this.srch.isShowing()) {
                  this.srch.show();
               }

               boolean var67 = false;
               if (!this.srch.getText().equals("")) {
                  var67 = true;
               }

               this.stringbutton(" Find ", 117, 526, 2, var67);
               this.rd.drawString("Replace with:", 255, 500);
               this.movefield(this.rplc, 338, 484, 129, 22);
               if (!this.rplc.isShowing()) {
                  this.rplc.show();
               }

               var67 = false;
               if (!this.srch.getText().equals("") && !this.rplc.getText().equals("")) {
                  var67 = true;
               }

               this.stringbutton(" Replace ", 376, 526, 2, var67);
            } else {
               if (this.srch.isShowing()) {
                  this.srch.hide();
               }

               if (this.rplc.isShowing()) {
                  this.rplc.hide();
               }

               this.rd.setColor(new Color(170, 170, 170));
               this.rd.drawRect(5, 474, 450, 70);
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawString("Mirror [Selected] polygon(s) along:", 18, 490);
               this.stringbutton(" Mirro Along X Axis ", 90, 525, 2, true);
               this.stringbutton(" Mirro Along Y Axis ", 230, 525, 2, false);
               this.stringbutton(" Mirro Along Z Axis ", 370, 525, 2, false);
               this.rd.setColor(new Color(170, 170, 170));
               this.rd.drawRect(465, 474, 230, 70);
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawString("Show [Selected] polygon(s):", 478, 490);
               this.stringbutton(" Show in 3D  > ", 580, 523, 0, true);
            }

            if (this.npolys > 210 && !this.tomany) {
               this.repaint();
               JOptionPane.showMessageDialog(
                  null,
                  "Maximum number of polygons (pieces) allowed has been exceeded!\nThe maximum allowed is 210 polygons, please decrease.\n",
                  "Car Maker",
                  1
               );
               this.tomany = true;
            }
         }

         if (this.tab == 2) {
            if (this.tabed != this.tab) {
               this.setupo();
               this.dtabed = -1;
            }

            this.m.d(this.rd);
            this.o.d(this.rd);
            if (this.dtab == 2) {
               if (this.compsel > 0 && this.compsel <= 16) {
                  this.compo[this.compsel - 1].x = this.o.x;
                  this.compo[this.compsel - 1].y = this.o.y;
                  this.compo[this.compsel - 1].z = this.o.z;
                  this.compo[this.compsel - 1].xz = this.o.xz;
                  this.compo[this.compsel - 1].xy = this.o.xy;
                  this.compo[this.compsel - 1].zy = this.o.zy;
                  this.rd.setComposite(AlphaComposite.getInstance(3, 0.4F));
                  this.compo[this.compsel - 1].d(this.rd);
                  this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
               }

               if (this.xm > 420 && this.xm < 690 && this.ym > 425 && this.ym < 540) {
                  int[] var55 = new int[]{50 + this.adna[0], -50 - this.adna[1], 0, 0, 0, 0};
                  int[] var69 = new int[]{0, 0, 50 + this.adna[2], -50 - this.adna[3], 0, 0};
                  int[] var80 = new int[]{0, 0, 0, 0, 50 + this.adna[4], -50 - this.adna[5]};

                  for (int var88 = 0; var88 < 6; var88++) {
                     var55[var88] += this.o.x - this.m.x;
                     var69[var88] += this.o.y - this.m.y;
                     var80[var88] += this.o.z - this.m.z;
                  }

                  this.rot(var55, var69, this.o.x - this.m.x, this.o.y - this.m.y, this.o.xy, 6);
                  this.rot(var69, var80, this.o.y - this.m.y, this.o.z - this.m.z, this.o.zy, 6);
                  this.rot(var55, var80, this.o.x - this.m.x, this.o.z - this.m.z, this.o.xz, 6);
                  this.rot(var55, var80, this.m.cx, this.m.cz, this.m.xz, 6);
                  this.rot(var69, var80, this.m.cy, this.m.cz, this.m.zy, 6);
                  int[] var89 = new int[6];
                  int[] var128 = new int[6];

                  for (int var8 = 0; var8 < 6; var8++) {
                     var89[var8] = this.xs(var55[var8], var80[var8]);
                     var128[var8] = this.ys(var69[var8], var80[var8]);
                  }

                  this.rd.setColor(new Color(0, 150, 0));
                  this.rd.drawString("X+", var89[0] - 7, var128[0] + 4);
                  this.rd.drawString("-X", var89[1] - 5, var128[1] + 4);
                  this.rd.drawLine(var89[0], var128[0], var89[1], var128[1]);
                  this.rd.setColor(new Color(150, 0, 0));
                  this.rd.drawString("Y+", var89[2] - 7, var128[2] + 4);
                  this.rd.drawString("-Y", var89[3] - 5, var128[3] + 4);
                  this.rd.drawLine(var89[2], var128[2], var89[3], var128[3]);
                  this.rd.setColor(new Color(0, 0, 150));
                  this.rd.drawString("Z+", var89[4] - 7, var128[4] + 4);
                  this.rd.drawString("-Z", var89[5] - 5, var128[5] + 4);
                  this.rd.drawLine(var89[4], var128[4], var89[5], var128[5]);

                  for (int var158 = 0; var158 < 6; var158++) {
                     if (Math.abs(var128[var158] - 207) * 1.91F > Math.abs(var89[var158] - 350)) {
                        if (Math.abs(Math.abs(var128[var158] - 207) - 170) > 10) {
                           if (Math.abs(var128[var158] - 207) < 170) {
                              this.adna[var158] = this.adna[var158] + 10;
                           } else {
                              this.adna[var158] = this.adna[var158] - 10;
                           }
                        }
                     } else if (Math.abs(Math.abs(var89[var158] - 350) - 338) > 10) {
                        if (Math.abs(var89[var158] - 350) < 338) {
                           this.adna[var158] = this.adna[var158] + 10;
                        } else {
                           this.adna[var158] = this.adna[var158] - 10;
                        }
                     }

                     if (this.adna[var158] > 276) {
                        this.adna[var158] = 276;
                     }

                     if (this.adna[var158] < 0) {
                        this.adna[var158] = 0;
                     }
                  }
               }
            }

            this.rd.setColor(new Color(205, 200, 200));
            this.rd.fillRect(0, 390, 700, 20);
            this.rd.setColor(new Color(225, 225, 225));
            this.rd.fillRect(0, 410, 700, 140);
            this.rd.setFont(new Font("Arial", 1, 12));
            this.ftm = this.rd.getFontMetrics();
            String[] var56 = new String[]{"3D Controls", "Color Edit", "Scale & Align", "Wheels", "Stats & Class", "Physics", "Test Drive"};
            int[] var70 = new int[]{0, 0, 100, 90};
            int[] var81 = new int[]{390, 410, 410, 390};

            for (int var90 = 0; var90 < 7; var90++) {
               this.rd.setColor(new Color(170, 170, 170));
               if (this.xm > var70[0] && this.xm < var70[3] && this.ym > 390 && this.ym < 410) {
                  this.rd.setColor(new Color(190, 190, 190));
               }

               if (this.dtab == var90) {
                  this.rd.setColor(new Color(225, 225, 225));
               }

               this.rd.fillPolygon(var70, var81, 4);
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawString(var56[var90], var90 * 100 + 47 - this.ftm.stringWidth(var56[var90]) / 2, 404);
               if (this.xm > var70[0] && this.xm < var70[3] && this.ym > 390 && this.ym < 410 && this.mouses == -1) {
                  this.dtab = var90;
               }

               for (int var129 = 0; var129 < 4; var129++) {
                  var70[var129] += 100;
               }
            }

            if (this.dtabed != this.dtab) {
               if (this.dtabed != -1) {
                  if (!this.editor.getText().equals(this.lastedo)) {
                     this.editor.setText(this.lastedo);
                  }

                  this.setupo();
               }

               this.setCursor(new Cursor(0));
               this.hidefields();
               this.requestFocus();
            }

            this.rd.setColor(new Color(0, 0, 0));
            if (this.dtab == 0) {
               this.rd.drawString("Rotate Car around its X & Z Axis using:  [ Keyboard Arrows ] ", 20, 440);
               this.rd
                  .drawString("Rotate Car fully around the Y Axis using:    [ < ]  &  [ > ]    or    [ A ]  &  [ D ]    or    [ 4 ]  &  [ 6 ]    Keys", 20, 465);
               this.rd.drawString("Move Car Up and Down using:    [ - ]  &  [ + ]    Keys", 20, 490);
               this.rd
                  .drawString(
                     "Move Car Forwards and Backwards using:    [ W ]  &  [ S ]    or    [ 8 ]  &  [ 2 ]    or    [ Enter ]  &  [ Backspace ]    Keys", 20, 515
                  );
            }

            if (this.dtab == 1) {
               if (this.o.colok != 2) {
                  this.rd.setFont(new Font("Arial", 1, 13));
                  this.ftm = this.rd.getFontMetrics();
                  this.rd
                     .drawString(
                        "[  First & Second Color not defined yet  ]", 350 - this.ftm.stringWidth("[  First & Second Color not defined yet  ]") / 2, 450
                     );
                  this.stringbutton(" Define 1st and 2nd Color ", 350, 490, 0, true);
               } else {
                  if (this.dtabed != this.dtab) {
                     this.fcol = "(" + this.o.fcol[0] + "," + this.o.fcol[1] + "," + this.o.fcol[2] + ")";
                     this.srch.setText(this.fcol);
                     this.ofcol = this.fcol;
                     Color.RGBtoHSB(this.o.fcol[0], this.o.fcol[1], this.o.fcol[2], this.fhsb);
                     float var91 = this.fhsb[1];
                     this.fhsb[1] = this.fhsb[2];
                     this.fhsb[2] = var91;
                     this.scol = "(" + this.o.scol[0] + "," + this.o.scol[1] + "," + this.o.scol[2] + ")";
                     this.rplc.setText(this.scol);
                     this.oscol = this.scol;
                     Color.RGBtoHSB(this.o.scol[0], this.o.scol[1], this.o.scol[2], this.shsb);
                     var91 = this.shsb[1];
                     this.shsb[1] = this.shsb[2];
                     this.shsb[2] = var91;
                     this.bfo = 51;
                     this.mouseon = -1;
                  }

                  if (this.mouses != 1) {
                     this.mouseon = -1;
                  }

                  this.rd.setColor(new Color(170, 170, 170));
                  this.rd.drawRect(20, 425, 320, 110);
                  this.rd.setColor(new Color(225, 225, 225));
                  this.rd.fillRect(141, 419, 77, 9);
                  this.rd.setColor(new Color(0, 0, 0));
                  this.rd.drawString("First Color", 151, 428);
                  this.rd.drawString("Hue:", 75, 450);
                  this.rd.drawString("Brightness:", 35, 470);
                  this.rd.drawString("Saturation:", 38, 490);
                  this.rd.drawString("RGB Value:", 38, 520);
                  this.movefield(this.srch, 106, 504, 129, 22);
                  if (this.srch.hasFocus()) {
                     this.focuson = false;
                  }

                  if (!this.srch.isShowing()) {
                     this.srch.show();
                  }

                  for (int var93 = 0; var93 < 200; var93++) {
                     this.rd.setColor(Color.getHSBColor((float)(var93 * 0.005), 1.0F, 1.0F));
                     this.rd.drawLine(110 + var93, 442, 110 + var93, 449);
                  }

                  for (int var94 = 0; var94 < 200; var94++) {
                     this.rd.setColor(Color.getHSBColor(0.0F, 0.0F, 0.2F + (float)(var94 * 0.004)));
                     this.rd.drawLine(110 + var94, 462, 110 + var94, 469);
                  }

                  for (int var95 = 0; var95 < 200; var95++) {
                     this.rd.setColor(Color.getHSBColor(this.fhsb[0], (float)(var95 * 0.005), this.fhsb[1]));
                     this.rd.drawLine(110 + var95, 482, 110 + var95, 489);
                  }

                  for (int var96 = 0; var96 < 3; var96++) {
                     this.rd.setColor(new Color(0, 0, 0));
                     float var130 = this.fhsb[var96] * 200.0F;
                     if (var96 == 1) {
                        var130 = (this.fhsb[var96] - 0.2F) * 250.0F;
                     }

                     this.rd.drawLine((int)(110.0F + var130), 442 + var96 * 20, (int)(110.0F + var130), 449 + var96 * 20);
                     this.rd.drawLine((int)(111.0F + var130), 442 + var96 * 20, (int)(111.0F + var130), 449 + var96 * 20);
                     this.rd.fillRect((int)(109.0F + var130), 450 + var96 * 20, 4, 2);
                     this.rd.drawLine((int)(108.0F + var130), 452 + var96 * 20, (int)(113.0F + var130), 452 + var96 * 20);
                     if (this.xm > 107 && this.xm < 313 && this.ym > 439 + var96 * 20 && this.ym < 452 + var96 * 20 && this.mouses == 1 && this.mouseon == -1) {
                        this.mouseon = var96;
                     }

                     if (this.mouseon == var96) {
                        if (var96 == 1) {
                           this.fhsb[var96] = 0.2F + (this.xm - 110) / 250.0F;
                           if (this.fhsb[var96] < 0.2) {
                              this.fhsb[var96] = 0.2F;
                           }
                        } else {
                           this.fhsb[var96] = (this.xm - 110) / 200.0F;
                        }

                        if (this.fhsb[var96] > 1.0F) {
                           this.fhsb[var96] = 1.0F;
                        }

                        if (this.fhsb[var96] < 0.0F) {
                           this.fhsb[var96] = 0.0F;
                        }
                     }
                  }

                  this.stringbutton(" Save ", 300, 520, 0, !this.fcol.equals(this.ofcol));
                  this.rd.setColor(new Color(170, 170, 170));
                  this.rd.drawRect(360, 425, 320, 110);
                  this.rd.setColor(new Color(225, 225, 225));
                  this.rd.fillRect(472, 419, 95, 9);
                  this.rd.setColor(new Color(0, 0, 0));
                  this.rd.drawString("Second Color", 482, 428);
                  this.rd.drawString("Hue:", 415, 450);
                  this.rd.drawString("Brightness:", 375, 470);
                  this.rd.drawString("Saturation:", 378, 490);
                  this.rd.drawString("RGB Value:", 378, 520);
                  this.movefield(this.rplc, 446, 504, 129, 22);
                  if (this.rplc.hasFocus()) {
                     this.focuson = false;
                  }

                  if (!this.rplc.isShowing()) {
                     this.rplc.show();
                  }

                  for (int var97 = 0; var97 < 200; var97++) {
                     this.rd.setColor(Color.getHSBColor((float)(var97 * 0.005), 1.0F, 1.0F));
                     this.rd.drawLine(450 + var97, 442, 450 + var97, 449);
                  }

                  for (int var98 = 0; var98 < 200; var98++) {
                     this.rd.setColor(Color.getHSBColor(0.0F, 0.0F, 0.2F + (float)(var98 * 0.004)));
                     this.rd.drawLine(450 + var98, 462, 450 + var98, 469);
                  }

                  for (int var99 = 0; var99 < 200; var99++) {
                     this.rd.setColor(Color.getHSBColor(this.shsb[0], (float)(var99 * 0.005), this.shsb[2]));
                     this.rd.drawLine(450 + var99, 482, 450 + var99, 489);
                  }

                  for (int var100 = 0; var100 < 3; var100++) {
                     this.rd.setColor(new Color(0, 0, 0));
                     float var131 = this.shsb[var100] * 200.0F;
                     if (var100 == 1) {
                        var131 = (this.shsb[var100] - 0.2F) * 250.0F;
                     }

                     this.rd.drawLine((int)(450.0F + var131), 442 + var100 * 20, (int)(450.0F + var131), 449 + var100 * 20);
                     this.rd.drawLine((int)(451.0F + var131), 442 + var100 * 20, (int)(451.0F + var131), 449 + var100 * 20);
                     this.rd.fillRect((int)(449.0F + var131), 450 + var100 * 20, 4, 2);
                     this.rd.drawLine((int)(448.0F + var131), 452 + var100 * 20, (int)(453.0F + var131), 452 + var100 * 20);
                     if (this.xm > 447 && this.xm < 653 && this.ym > 439 + var100 * 20 && this.ym < 452 + var100 * 20 && this.mouses == 1 && this.mouseon == -1
                        )
                      {
                        this.mouseon = var100 + 3;
                     }

                     if (this.mouseon == var100 + 3) {
                        if (var100 == 1) {
                           this.shsb[var100] = 0.2F + (this.xm - 450) / 250.0F;
                           if (this.shsb[var100] < 0.2) {
                              this.shsb[var100] = 0.2F;
                           }
                        } else {
                           this.shsb[var100] = (this.xm - 450) / 200.0F;
                        }

                        if (this.shsb[var100] > 1.0F) {
                           this.shsb[var100] = 1.0F;
                        }

                        if (this.shsb[var100] < 0.0F) {
                           this.shsb[var100] = 0.0F;
                        }
                     }
                  }

                  this.stringbutton(" Save ", 640, 520, 0, !this.scol.equals(this.oscol));
                  if (this.fhsb[1] < 0.2) {
                     this.fhsb[1] = 0.2F;
                  }

                  if (this.shsb[1] < 0.2) {
                     this.shsb[1] = 0.2F;
                  }

                  for (int var101 = 0; var101 < this.o.npl; var101++) {
                     if (this.o.p[var101].colnum == 1) {
                        this.o.p[var101].hsb[0] = this.fhsb[0];
                        this.o.p[var101].hsb[1] = this.fhsb[2];
                        this.o.p[var101].hsb[2] = this.fhsb[1];
                     }

                     if (this.o.p[var101].colnum == 2) {
                        this.o.p[var101].hsb[0] = this.shsb[0];
                        this.o.p[var101].hsb[1] = this.shsb[2];
                        this.o.p[var101].hsb[2] = this.shsb[1];
                     }
                  }

                  String var102 = "("
                     + Color.getHSBColor(this.fhsb[0], this.fhsb[2], this.fhsb[1]).getRed()
                     + ","
                     + Color.getHSBColor(this.fhsb[0], this.fhsb[2], this.fhsb[1]).getGreen()
                     + ","
                     + Color.getHSBColor(this.fhsb[0], this.fhsb[2], this.fhsb[1]).getBlue()
                     + ")";
                  if (!this.fcol.equals(var102)) {
                     this.fcol = var102;
                     this.srch.setText(this.fcol);
                  }

                  var102 = "("
                     + Color.getHSBColor(this.shsb[0], this.shsb[2], this.shsb[1]).getRed()
                     + ","
                     + Color.getHSBColor(this.shsb[0], this.shsb[2], this.shsb[1]).getGreen()
                     + ","
                     + Color.getHSBColor(this.shsb[0], this.shsb[2], this.shsb[1]).getBlue()
                     + ")";
                  if (!this.scol.equals(var102)) {
                     this.scol = var102;
                     this.rplc.setText(this.scol);
                  }

                  if (!this.srch.getText().equals(this.fcol) || !this.rplc.getText().equals(this.scol)) {
                     this.bfo = 0;
                     if (!this.srch.getText().equals(this.fcol)) {
                        this.fcol = this.srch.getText();
                        int[] var132 = new int[3];
                        boolean var159 = true;

                        try {
                           int var9 = this.fcol.indexOf(",", 0);
                           int var10 = this.fcol.indexOf(",", var9 + 1);
                           var132[0] = Integer.valueOf(this.fcol.substring(1, var9));
                           if (var132[0] < 0) {
                              var132[0] = 0;
                           }

                           if (var132[0] > 255) {
                              var132[0] = 255;
                           }

                           var132[1] = Integer.valueOf(this.fcol.substring(var9 + 1, var10));
                           if (var132[1] < 0) {
                              var132[1] = 0;
                           }

                           if (var132[1] > 255) {
                              var132[1] = 255;
                           }

                           var132[2] = Integer.valueOf(this.fcol.substring(var10 + 1, this.fcol.length() - 1));
                           if (var132[2] < 0) {
                              var132[2] = 0;
                           }

                           if (var132[2] > 255) {
                              var132[2] = 255;
                           }
                        } catch (Exception var43) {
                           var159 = false;
                        }

                        if (var159) {
                           Color.RGBtoHSB(var132[0], var132[1], var132[2], this.fhsb);
                           float var188 = this.fhsb[1];
                           this.fhsb[1] = this.fhsb[2];
                           this.fhsb[2] = var188;
                        }
                     }

                     if (!this.rplc.getText().equals(this.scol)) {
                        this.scol = this.rplc.getText();
                        int[] var133 = new int[3];
                        boolean var160 = true;

                        try {
                           int var189 = this.scol.indexOf(",", 0);
                           int var203 = this.scol.indexOf(",", var189 + 1);
                           var133[0] = Integer.valueOf(this.scol.substring(1, var189));
                           if (var133[0] < 0) {
                              var133[0] = 0;
                           }

                           if (var133[0] > 255) {
                              var133[0] = 255;
                           }

                           var133[1] = Integer.valueOf(this.scol.substring(var189 + 1, var203));
                           if (var133[1] < 0) {
                              var133[1] = 0;
                           }

                           if (var133[1] > 255) {
                              var133[1] = 255;
                           }

                           var133[2] = Integer.valueOf(this.scol.substring(var203 + 1, this.scol.length() - 1));
                           if (var133[2] < 0) {
                              var133[2] = 0;
                           }

                           if (var133[2] > 255) {
                              var133[2] = 255;
                           }
                        } catch (Exception var42) {
                           var160 = false;
                        }

                        if (var160) {
                           Color.RGBtoHSB(var133[0], var133[1], var133[2], this.shsb);
                           float var190 = this.shsb[1];
                           this.shsb[1] = this.shsb[2];
                           this.shsb[2] = var190;
                        }
                     }
                  } else if (this.bfo < 50) {
                     this.bfo++;
                  } else if (this.bfo == 50) {
                     this.requestFocus();
                     this.bfo = 51;
                  }
               }
            }

            if (this.dtab == 2) {
               if (this.dtabed != this.dtab) {
                  this.lastedo = this.editor.getText();
                  this.scale[0] = 100;
                  int var104 = this.editor.getText().indexOf("\nScaleX(", 0);
                  if (var104 != -1) {
                     var104++;

                     try {
                        this.scale[0] = Integer.valueOf(this.editor.getText().substring(var104 + 7, this.editor.getText().indexOf(")", var104)));
                     } catch (Exception var41) {
                        this.scale[0] = 100;
                     }
                  }

                  this.oscale[0] = this.scale[0];
                  this.scale[1] = 100;
                  var104 = this.editor.getText().indexOf("\nScaleY(", 0);
                  if (var104 != -1) {
                     var104++;

                     try {
                        this.scale[1] = Integer.valueOf(this.editor.getText().substring(var104 + 7, this.editor.getText().indexOf(")", var104)));
                     } catch (Exception var40) {
                        this.scale[1] = 100;
                     }
                  }

                  this.oscale[1] = this.scale[1];
                  this.scale[2] = 100;
                  var104 = this.editor.getText().indexOf("\nScaleZ(", 0);
                  if (var104 != -1) {
                     var104++;

                     try {
                        this.scale[2] = Integer.valueOf(this.editor.getText().substring(var104 + 7, this.editor.getText().indexOf(")", var104)));
                     } catch (Exception var39) {
                        this.scale[2] = 100;
                     }
                  }

                  this.oscale[2] = this.scale[2];
                  this.bfo = 0;
                  this.compsel = 0;
                  this.compcar.select(this.compsel);
                  this.changed2 = false;
               }

               this.rd.setColor(new Color(170, 170, 170));
               this.rd.drawRect(9, 425, 270, 115);
               this.rd.setColor(new Color(225, 225, 225));
               this.rd.fillRect(119, 419, 51, 9);
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawString("Scale", 129, 428);
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawString("Scale X", 25, 450);
               this.stringbutton(" - ", 92, 450, 4, false);
               this.rd.drawString("" + this.scale[0] / 100.0F + "", 126 - this.ftm.stringWidth("" + this.scale[0] / 100.0F + "") / 2, 450);
               this.stringbutton(" + ", 160, 450, 4, false);
               this.rd.drawString("Scale Y", 25, 474);
               this.stringbutton(" - ", 92, 474, 4, false);
               this.rd.drawString("" + this.scale[1] / 100.0F + "", 126 - this.ftm.stringWidth("" + this.scale[1] / 100.0F + "") / 2, 474);
               this.stringbutton(" + ", 160, 474, 4, false);
               this.rd.drawString("Scale Z", 25, 498);
               this.stringbutton(" - ", 92, 498, 4, false);
               this.rd.drawString("" + this.scale[2] / 100.0F + "", 126 - this.ftm.stringWidth("" + this.scale[2] / 100.0F + "") / 2, 498);
               this.stringbutton(" + ", 160, 498, 4, false);
               this.rd.drawString("Scale ALL", 25, 527);
               this.stringbutton(" - ", 106, 527, 2, true);
               this.stringbutton(" + ", 146, 527, 2, true);
               this.stringbutton(
                  "   Save   ", 230, 454, 0, this.oscale[0] != this.scale[0] || this.oscale[1] != this.scale[1] || this.oscale[2] != this.scale[2]
               );
               this.stringbutton(" Reset ", 230, 493, 0, false);
               this.rd.drawString("Compare scale and", 296, 440);
               this.rd.drawString("alignment with:", 308, 455);
               this.compcar.move(288, 462);
               if (this.compcar.hasFocus()) {
                  this.focuson = false;
                  this.bfo++;
                  if (this.bfo == 100) {
                     this.requestFocus();
                  }
               } else {
                  this.bfo = 0;
               }

               if (!this.compcar.isShowing()) {
                  this.compcar.show();
               }

               if (this.compsel != this.compcar.getSelectedIndex()) {
                  this.compsel = this.compcar.getSelectedIndex();
                  this.requestFocus();
               }

               this.rd.setColor(new Color(170, 170, 170));
               this.rd.drawRect(420, 425, 270, 115);
               this.rd.setColor(new Color(225, 225, 225));
               this.rd.fillRect(531, 419, 47, 9);
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawString("Align", 541, 428);
               this.rd.drawString("Align in X", 433, 450);
               this.stringbutton(" Rotate 90° ", 535, 450, 4, false);
               this.stringbutton("+10", 607, 450, 4, false);
               this.stringbutton("-10", 656, 450, 4, false);
               this.rd.drawString("Align in Y", 433, 474);
               this.stringbutton(" Rotate 90° ", 535, 474, 4, false);
               this.stringbutton("+10", 607, 474, 4, false);
               this.stringbutton("-10", 656, 474, 4, false);
               this.rd.drawString("Align in Z", 433, 498);
               this.stringbutton(" Rotate 90° ", 535, 498, 4, false);
               this.stringbutton("+10", 607, 498, 4, false);
               this.stringbutton("-10", 656, 498, 4, false);
               this.stringbutton(" Reset ", 490, 527, 0, false);
               this.stringbutton("      Save      ", 607, 527, 0, this.changed2);
            }

            if (this.dtab == 3) {
               if (this.dtabed != this.dtab) {
                  int var110 = 45;
                  int var134 = 45;
                  int var161 = 15;
                  int var191 = 15;
                  int var204 = 76;
                  int var11 = -76;
                  int var12 = 26;
                  int var13 = 26;
                  int var14 = 20;
                  int var15 = 20;
                  int var16 = 18;
                  int var17 = 18;
                  int var18 = 10;
                  int var19 = 10;
                  int var20 = 0;
                  int var21 = 0;
                  String var22 = "(140,140,140)";
                  String var23 = "(140,140,140)";
                  int var24 = 0;
                  String var25 = "" + this.editor.getText() + "\n";
                  int var26 = 0;
                  int var27 = var25.indexOf("\n", 0);
                  int var28 = 0;
                  int var29 = 15;
                  int var30 = 20;
                  String var31 = "(140,140,140)";

                  while (var27 != -1 && var26 < var25.length()) {
                     String var32 = var25.substring(var26, var27);
                     var32 = var32.trim();
                     var26 = var27 + 1;
                     var27 = var25.indexOf("\n", var26);

                     try {
                        if (var32.startsWith("rims(")) {
                           var31 = "(" + this.getvalue("rims", var32, 0) + "," + this.getvalue("rims", var32, 1) + "," + this.getvalue("rims", var32, 2) + ")";
                           var29 = this.getvalue("rims", var32, 3);
                           var30 = this.getvalue("rims", var32, 4);
                        }

                        if (var32.startsWith("gwgr(")) {
                           var28 = this.getvalue("gwgr", var32, 0);
                        }

                        if (var32.startsWith("w(")) {
                           int var33 = this.getvalue("w", var32, 2);
                           if (var33 > 0) {
                              var110 = Math.abs(this.getvalue("w", var32, 0));
                              var161 = this.getvalue("w", var32, 1);
                              var204 = var33;
                              var12 = Math.abs(this.getvalue("w", var32, 4));
                              var14 = Math.abs(this.getvalue("w", var32, 5));
                              var22 = var31;
                              var16 = var29;
                              var18 = var30;
                              var20 = var28;
                           } else {
                              var134 = Math.abs(this.getvalue("w", var32, 0));
                              var191 = this.getvalue("w", var32, 1);
                              var11 = var33;
                              var13 = Math.abs(this.getvalue("w", var32, 4));
                              var15 = Math.abs(this.getvalue("w", var32, 5));
                              var23 = var31;
                              var17 = var29;
                              var19 = var30;
                              var21 = var28;
                           }

                           var24++;
                        }
                     } catch (Exception var38) {
                     }
                  }

                  if (var24 != 4) {
                     this.defnow = true;
                  } else {
                     this.defnow = false;
                  }

                  this.wv[0].setText("" + var134 + "");
                  this.wv[1].setText("" + var191 + "");
                  this.wv[2].setText("" + var11 + "");
                  this.wv[3].setText("" + var15 + "");
                  this.wv[4].setText("" + var13 + "");
                  this.srch.setText(var23);
                  this.wv[5].setText("" + var17 + "");
                  this.wv[6].setText("" + var19 + "");
                  this.wv[7].setText("" + var21 + "");
                  this.wv[8].setText("" + var110 + "");
                  this.wv[9].setText("" + var161 + "");
                  this.wv[10].setText("" + var204 + "");
                  this.wv[11].setText("" + var14 + "");
                  this.wv[12].setText("" + var12 + "");
                  this.rplc.setText(var22);
                  this.wv[13].setText("" + var16 + "");
                  this.wv[14].setText("" + var18 + "");
                  this.wv[15].setText("" + var20 + "");
                  this.aply1 = ""
                     + this.wv[0].getText()
                     + ""
                     + this.wv[1].getText()
                     + ""
                     + this.wv[2].getText()
                     + ""
                     + this.wv[3].getText()
                     + ""
                     + this.wv[4].getText()
                     + ""
                     + this.srch.getText()
                     + ""
                     + this.wv[5].getText()
                     + ""
                     + this.wv[6].getText()
                     + ""
                     + this.wv[7].getText()
                     + "";
                  this.aply2 = ""
                     + this.wv[8].getText()
                     + ""
                     + this.wv[9].getText()
                     + ""
                     + this.wv[10].getText()
                     + ""
                     + this.wv[11].getText()
                     + ""
                     + this.wv[12].getText()
                     + ""
                     + this.rplc.getText()
                     + ""
                     + this.wv[13].getText()
                     + ""
                     + this.wv[14].getText()
                     + ""
                     + this.wv[15].getText()
                     + "";
                  this.aplyd1 = false;
                  this.aplyd2 = false;
                  this.changed2 = false;
                  this.mouseon = -1;
               }

               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawString("BACK Wheels :", 12, 424);
               this.rd.drawString("±X :", 12, 449);
               this.movefield(this.wv[0], 35, 433, 40, 22);
               this.rd.drawString("Y :", 86, 449);
               this.movefield(this.wv[1], 101, 433, 40, 22);
               this.rd.drawString("Z :", 151, 449);
               this.movefield(this.wv[2], 166, 433, 40, 22);
               this.rd.drawString("Height :", 12, 479);
               this.movefield(this.wv[3], 56, 463, 40, 22);
               this.rd.drawString("Width :", 107, 479);
               this.movefield(this.wv[4], 148, 463, 40, 22);
               this.rd.drawString("Rims RGB Color :", 12, 509);
               this.movefield(this.srch, 109, 493, 129, 22);
               this.rd.drawString("Rims Size :", 12, 539);
               this.movefield(this.wv[5], 76, 523, 40, 22);
               this.rd.drawString("Rims Depth :", 126, 539);
               this.movefield(this.wv[6], 199, 523, 40, 22);
               if (this.xm > 245 && this.xm < 336 && this.ym > 524 && this.ym < 541) {
                  this.rd.setColor(new Color(255, 0, 0));
                  this.rd.drawLine(248, 540, 279, 540);
                  this.rd.drawLine(327, 540, 334, 540);
                  if (this.mouseon == -1) {
                     this.mouseon = 1;
                     this.setCursor(new Cursor(12));
                  }
               } else if (this.mouseon == 1) {
                  this.mouseon = -1;
                  this.setCursor(new Cursor(0));
               }

               this.rd.drawString("Hide :                ?", 249, 539);
               this.movefield(this.wv[7], 282, 523, 40, 22);
               this.stringbutton("   Apply   ", 300, 440, 0, this.aplyd1);
               this.stringbutton("   Save   ", 300, 477, 0, this.changed2);
               this.rd.drawString("FRONT Wheels :", 362, 424);
               this.rd.drawString("±X :", 362, 449);
               this.movefield(this.wv[8], 385, 433, 40, 22);
               this.rd.drawString("Y :", 436, 449);
               this.movefield(this.wv[9], 451, 433, 40, 22);
               this.rd.drawString("Z :", 501, 449);
               this.movefield(this.wv[10], 516, 433, 40, 22);
               this.rd.drawString("Height :", 362, 479);
               this.movefield(this.wv[11], 406, 463, 40, 22);
               this.rd.drawString("Width :", 457, 479);
               this.movefield(this.wv[12], 498, 463, 40, 22);
               this.rd.drawString("Rims RGB Color :", 362, 509);
               this.movefield(this.rplc, 459, 493, 129, 22);
               this.rd.drawString("Rims Size :", 362, 539);
               this.movefield(this.wv[13], 426, 523, 40, 22);
               this.rd.drawString("Rims Depth :", 476, 539);
               this.movefield(this.wv[14], 549, 523, 40, 22);
               if (this.xm > 595 && this.xm < 686 && this.ym > 524 && this.ym < 541) {
                  this.rd.setColor(new Color(255, 0, 0));
                  this.rd.drawLine(598, 540, 629, 540);
                  this.rd.drawLine(677, 540, 684, 540);
                  if (this.mouseon == -1) {
                     this.mouseon = 2;
                     this.setCursor(new Cursor(12));
                  }
               } else if (this.mouseon == 2) {
                  this.mouseon = -1;
                  this.setCursor(new Cursor(0));
               }

               this.rd.drawString("Hide :                ?", 599, 539);
               this.movefield(this.wv[15], 632, 523, 40, 22);
               this.stringbutton("   Apply   ", 650, 440, 0, this.aplyd2);
               this.stringbutton("   Save   ", 650, 477, 0, this.changed2);
               if (this.mouses == -1 && (this.mouseon == 1 || this.mouseon == 2)) {
                  JOptionPane.showMessageDialog(
                     null,
                     "Use this variable to hide the car wheels inside the car if you need to (if they are getting drawn over the car when they\nshould be drawn behind it).\n\nIf you have created a car model with specific places for the wheels go inside them (inside the car), if when you place the\nwheels there they don’t get drawn inside the car (they get drawn over it instead), use this variable to adjust that.\n\nYou can also use this variable to do the opposite, to make the wheels get drawn over the car if they are getting drawn\nbehind it when they shouldn’t.\n\nThe Hide variable takes values from -40 to 40:\nA +ve value from 1 to 40 makes the wheels more hidden, where 40 is the maximum the car wheel can be hidden.\nA -ve value from -1 to -40 does exactly the opposite and makes the wheels more apparent (this if the car wheels appear\ninside the car when they should be outside).\nA 0 value means do nothing.\nMost of the time you will need to use this variable, it will be to enter +ve values from 1-40 for hiding the car wheels.\n\n",
                     "Car Maker",
                     1
                  );
               }

               for (int var111 = 0; var111 < 16; var111++) {
                  if (this.wv[var111].hasFocus()) {
                     this.focuson = false;
                  }

                  if (!this.wv[var111].isShowing()) {
                     this.wv[var111].show();
                  }
               }

               if (this.srch.hasFocus()) {
                  this.focuson = false;
               }

               if (!this.srch.isShowing()) {
                  this.srch.show();
               }

               if (this.rplc.hasFocus()) {
                  this.focuson = false;
               }

               if (!this.rplc.isShowing()) {
                  this.rplc.show();
               }

               if (!this.focuson) {
                  if (!this.aplyd1
                     && !this.aply1
                        .equals(
                           ""
                              + this.wv[0].getText()
                              + ""
                              + this.wv[1].getText()
                              + ""
                              + this.wv[2].getText()
                              + ""
                              + this.wv[3].getText()
                              + ""
                              + this.wv[4].getText()
                              + ""
                              + this.srch.getText()
                              + ""
                              + this.wv[5].getText()
                              + ""
                              + this.wv[6].getText()
                              + ""
                              + this.wv[7].getText()
                              + ""
                        )) {
                     this.aplyd1 = true;
                  }

                  if (!this.aplyd2
                     && !this.aply2
                        .equals(
                           ""
                              + this.wv[8].getText()
                              + ""
                              + this.wv[9].getText()
                              + ""
                              + this.wv[10].getText()
                              + ""
                              + this.wv[11].getText()
                              + ""
                              + this.wv[12].getText()
                              + ""
                              + this.rplc.getText()
                              + ""
                              + this.wv[13].getText()
                              + ""
                              + this.wv[14].getText()
                              + ""
                              + this.wv[15].getText()
                              + ""
                        )) {
                     this.aplyd2 = true;
                  }
               }

               this.rd.setColor(new Color(170, 170, 170));
               this.rd.drawLine(350, 410, 350, 550);
               this.rd.drawLine(300, 409, 400, 409);
            }

            if (this.dtab == 4) {
               if (this.dtabed != this.dtab) {
                  this.changed2 = false;
                  this.statdef = false;
                  String var112 = "" + this.editor.getText() + "\n";
                  int var135 = 0;
                  int var162 = var112.indexOf("\n", 0);

                  while (var162 != -1 && var135 < var112.length()) {
                     String var192 = var112.substring(var135, var162);
                     var192 = var192.trim();
                     var135 = var162 + 1;
                     var162 = var112.indexOf("\n", var135);

                     try {
                        if (var192.startsWith("stat(")) {
                           int var205 = 0;

                           for (int var219 = 0; var219 < 5; var219++) {
                              this.stat[var219] = this.getvalue("stat", var192, var219);
                              if (this.stat[var219] > 200) {
                                 this.stat[var219] = 200;
                              }

                              if (this.stat[var219] < 16) {
                                 this.stat[var219] = 16;
                              }

                              var205 += this.stat[var219];
                           }

                           int var220 = 0;
                           if (var205 > 680) {
                              var220 = 680 - var205;
                              this.changed2 = true;
                           }

                           if (var205 > 640 && var205 < 680) {
                              var220 = 640 - var205;
                              this.changed2 = true;
                           }

                           if (var205 > 600 && var205 < 640) {
                              var220 = 600 - var205;
                              this.changed2 = true;
                           }

                           if (var205 > 560 && var205 < 600) {
                              var220 = 560 - var205;
                              this.changed2 = true;
                           }

                           if (var205 > 520 && var205 < 560) {
                              var220 = 520 - var205;
                              this.changed2 = true;
                           }

                           if (var205 < 520) {
                              var220 = 520 - var205;
                              this.changed2 = true;
                           }

                           while (var220 != 0) {
                              for (int var232 = 0; var232 < 5; var232++) {
                                 if (var220 > 0 && this.stat[var232] < 200) {
                                    this.stat[var232]++;
                                    var220--;
                                 }

                                 if (var220 < 0 && this.stat[var232] > 16) {
                                    this.stat[var232]--;
                                    var220++;
                                 }
                              }
                           }

                           for (int var233 = 0; var233 < 5; var233++) {
                              this.rstat[var233] = this.stat[var233];
                           }

                           this.statdef = true;
                        }
                     } catch (Exception var46) {
                        this.statdef = false;
                     }
                  }

                  if (this.statdef) {
                     if (this.simcar.getItemCount() == 16) {
                        this.simcar.add(this.rd, "   ");
                     }
                  } else if (this.simcar.getItemCount() == 17) {
                     this.simcar.remove("   ");
                  }
               }

               this.rd.setColor(new Color(0, 0, 0));
               if (!this.statdef) {
                  this.rd.setFont(new Font("Arial", 1, 13));
                  this.ftm = this.rd.getFontMetrics();
                  this.rd
                     .drawString(
                        "To start, please select the most similar NFM car to this car",
                        350 - this.ftm.stringWidth("To start, please select the most similar NFM car to this car") / 2,
                        450
                     );
                  this.simcar.move(288, 460);
                  if (!this.simcar.isShowing()) {
                     this.simcar.show();
                  }

                  this.stringbutton("   OK   ", 350, 515, 0, true);
               } else {
                  this.rd.drawString("Car Class", 54, 435);
                  this.cls.move(34, 440);
                  if (!this.cls.isShowing()) {
                     this.cls.show();
                  }

                  boolean var113 = false;
                  int var136 = 0;

                  for (int var163 = 0; var163 < 5; var163++) {
                     var136 += this.stat[var163];
                     if (this.stat[var163] != this.rstat[var163]) {
                        var113 = true;
                     }
                  }

                  if (this.clsel != this.cls.getSelectedIndex()) {
                     this.clsel = this.cls.getSelectedIndex();
                     int var164 = (4 - this.clsel) * 40 + 520 - var136;

                     while (var164 != 0) {
                        for (int var194 = 0; var194 < 5; var194++) {
                           if (var164 > 0 && this.stat[var194] < 200) {
                              this.stat[var194]++;
                              var164--;
                           }

                           if (var164 < 0 && this.stat[var194] > 16) {
                              this.stat[var194]--;
                              var164++;
                           }
                        }
                     }
                  }

                  if (4 - (var136 - 520) / 40 != this.cls.getSelectedIndex()) {
                     this.clsel = 4 - (var136 - 520) / 40;
                     this.cls.select(this.clsel);
                  }

                  this.rd.drawString("Most Similar Car", 36, 490);
                  this.simcar.move(20, 495);
                  if (!this.simcar.isShowing()) {
                     this.simcar.show();
                  }

                  if (this.carsel != this.simcar.getSelectedIndex()) {
                     this.carsel = this.simcar.getSelectedIndex();
                     if (this.carsel != 16) {
                        for (int var165 = 0; var165 < 5; var165++) {
                           this.stat[var165] = this.carstat[this.carsel][var165];
                        }
                     }

                     this.requestFocus();
                  }

                  int var166 = 60;
                  int var195 = 16;

                  for (int var206 = 0; var206 < 16; var206++) {
                     int var221 = 0;

                     for (int var234 = 0; var234 < 5; var234++) {
                        var221 += Math.abs(this.carstat[var206][var234] - this.stat[var234]);
                     }

                     if (var221 < var166) {
                        var195 = var206;
                        var166 = var221;
                     }
                  }

                  if (var195 != this.carsel) {
                     this.carsel = var195;
                     if (this.carsel < this.simcar.getItemCount()) {
                        this.simcar.select(this.carsel);
                     }
                  }

                  this.rd.drawString("Speed :", 196, 435);
                  this.rd.drawString("Acceleration :", 160, 459);
                  this.rd.drawString("Stunts :", 195, 483);
                  this.rd.drawString("Strength :", 183, 507);
                  this.rd.drawString("Endurance :", 171, 531);

                  for (int var207 = 0; var207 < 5; var207++) {
                     for (int var222 = 0; var222 < this.stat[var207]; var222++) {
                        this.rd.setColor(Color.getHSBColor((float)(var222 * 7.0E-4), 1.0F, 1.0F));
                        this.rd.drawLine(250 + var222, 426 + var207 * 24, 250 + var222, 434 + var207 * 24);
                     }

                     this.rd.setColor(new Color(0, 0, 0));
                     this.rd.drawLine(249, 426 + var207 * 24, 249, 434 + var207 * 24);
                     this.rd.drawLine(450, 426 + var207 * 24, 450, 434 + var207 * 24);
                     this.rd.drawLine(249, 435 + var207 * 24, 450, 435 + var207 * 24);

                     for (int var223 = 0; var223 < 7; var223++) {
                        this.rd.drawLine(275 + var223 * 25, 434 + var207 * 24, 275 + var223 * 25, 430 + var207 * 24);
                     }

                     this.stringbutton(" - ", 480, 435 + var207 * 24, 4, false);
                     this.stringbutton(" + ", 520, 435 + var207 * 24, 4, false);
                  }

                  if (this.carsel < 16 && var166 != 0) {
                     this.stringbutton(" Reselect ", 80, 534, 4, true);
                  } else {
                     this.stringbutton(" Reselect ", 80, -1000, 4, true);
                  }

                  this.stringbutton("      Save      ", 620, 459, 0, var113 || this.changed2);
                  this.stringbutton("   Reset   ", 620, 507, 0, false);
               }
            }

            if (this.dtab == 5) {
               if (this.dtabed != this.dtab) {
                  this.mouseon = -1;
                  this.pfase = 0;
                  if (this.o.keyz[0] <= 0 || this.o.keyx[0] >= 0) {
                     this.pfase = -1;
                  }

                  if (this.o.keyz[1] <= 0 || this.o.keyx[1] <= 0) {
                     this.pfase = -1;
                  }

                  if (this.o.keyz[2] >= 0 || this.o.keyx[2] >= 0) {
                     this.pfase = -1;
                  }

                  if (this.o.keyz[3] >= 0 || this.o.keyx[3] <= 0) {
                     this.pfase = -1;
                  }

                  this.crashok = false;
                  if (Math.random() > Math.random()) {
                     this.crashleft = false;
                  } else {
                     this.crashleft = true;
                  }

                  this.engsel = 0;
                  if (this.pfase == 0) {
                     String var114 = "" + this.editor.getText() + "\n";
                     int var137 = 0;
                     int var167 = var114.indexOf("\n", 0);

                     while (var167 != -1 && var137 < var114.length()) {
                        String var196 = var114.substring(var137, var167);
                        var196 = var196.trim();
                        var137 = var167 + 1;
                        var167 = var114.indexOf("\n", var137);

                        try {
                           if (var196.startsWith("physics(")) {
                              for (int var208 = 0; var208 < 11; var208++) {
                                 this.phys[var208] = this.getvalue("physics", var196, var208);
                                 if (this.phys[var208] > 100) {
                                    this.phys[var208] = 100;
                                 }

                                 if (this.phys[var208] < 0) {
                                    this.phys[var208] = 0;
                                 }
                              }

                              for (int var209 = 0; var209 < 11; var209++) {
                                 this.rphys[var209] = this.phys[var209];
                              }

                              for (int var210 = 0; var210 < 3; var210++) {
                                 this.crash[var210] = this.getvalue("physics", var196, var210 + 11);
                                 if (this.crash[var210] > 100) {
                                    this.crash[var210] = 100;
                                 }

                                 if (this.crash[var210] < 0) {
                                    this.crash[var210] = 0;
                                 }
                              }

                              for (int var211 = 0; var211 < 3; var211++) {
                                 this.rcrash[var211] = this.crash[var211];
                              }

                              this.engsel = this.getvalue("physics", var196, 14);
                              if (this.engsel > 4) {
                                 this.engsel = 0;
                              }

                              if (this.engsel < 0) {
                                 this.engsel = 0;
                              }

                              this.crashok = true;
                           }
                        } catch (Exception var45) {
                           this.crashok = false;
                        }
                     }
                  }

                  this.engon = false;
               }

               int var115 = -1;
               if (this.pfase == 0) {
                  for (int var138 = 0; var138 < 4; var138++) {
                     this.rd.setColor(new Color(0, 0, 0));
                     if (this.xm > this.pnx[var138] && this.xm < 230 && this.ym > 433 + var138 * 24 && this.ym < 453 + var138 * 24) {
                        var115 = var138;
                        this.rd.setColor(new Color(176, 64, 0));
                        this.rd.drawLine(this.pnx[var138], 448 + var138 * 24, 128, 448 + var138 * 24);
                     }

                     this.rd.drawString("" + this.pname[var138] + " :", this.pnx[var138], 447 + var138 * 24);
                     this.rd.drawLine(140, 443 + var138 * 24, 230, 443 + var138 * 24);

                     for (int var168 = 1; var168 < 10; var168++) {
                        this.rd.drawLine(140 + 10 * var168, 443 - var168 + var138 * 24, 140 + 10 * var168, 443 + var168 + var138 * 24);
                     }

                     this.rd.setColor(new Color(255, 0, 0));
                     int var169 = (int)(this.phys[var138] / 1.1111F / 10.0F);
                     this.rd.fillRect(138 + (int)(this.phys[var138] / 1.1111F), 443 - var169 + var138 * 24, 5, var169 * 2 + 1);
                     this.rd.setColor(new Color(255, 128, 0));
                     this.rd.drawRect(139 + (int)(this.phys[var138] / 1.1111F), 434 + var138 * 24, 2, 18);
                     this.stringbutton(" - ", 260, 447 + var138 * 24, 4, false);
                     this.stringbutton(" + ", 300, 447 + var138 * 24, 4, false);
                  }

                  this.rd.setColor(new Color(0, 0, 0));
                  this.rd.drawString("<  Click on any variable name to learn about its function & use!", 333, 447);
                  this.stringbutton(" Random ", 380, 496, 0, false);
                  this.stringbutton(" Reset ", 455, 496, 0, false);
                  this.stringbutton("       Next  >       ", 570, 496, 0, true);
               }

               if (this.pfase == 1) {
                  for (int var139 = 0; var139 < 4; var139++) {
                     this.rd.setColor(new Color(0, 0, 0));
                     if (this.xm > this.pnx[var139 + 5] && this.xm < 211 && this.ym > 433 + var139 * 24 && this.ym < 453 + var139 * 24) {
                        var115 = var139 + 5;
                        this.rd.setColor(new Color(176, 64, 0));
                        this.rd.drawLine(this.pnx[var139 + 5], 448 + var139 * 24, 109, 448 + var139 * 24);
                     }

                     this.rd.drawString("" + this.pname[var139 + 5] + " :", this.pnx[var139 + 5], 447 + var139 * 24);
                     this.rd.drawLine(121, 443 + var139 * 24, 211, 443 + var139 * 24);

                     for (int var170 = 1; var170 < 10; var170++) {
                        this.rd.drawLine(121 + 10 * var170, 443 - var170 + var139 * 24, 121 + 10 * var170, 443 + var170 + var139 * 24);
                     }

                     this.rd.setColor(new Color(255, 0, 0));
                     int var171 = (int)(this.phys[var139 + 5] / 1.1111F / 10.0F);
                     this.rd.fillRect(119 + (int)(this.phys[var139 + 5] / 1.1111F), 443 - var171 + var139 * 24, 5, var171 * 2 + 1);
                     this.rd.setColor(new Color(255, 128, 0));
                     this.rd.drawRect(120 + (int)(this.phys[var139 + 5] / 1.1111F), 434 + var139 * 24, 2, 18);
                     this.stringbutton(" - ", 241, 447 + var139 * 24, 4, false);
                     this.stringbutton(" + ", 281, 447 + var139 * 24, 4, false);
                  }

                  for (int var140 = 0; var140 < 2; var140++) {
                     this.rd.setColor(new Color(0, 0, 0));
                     if (this.xm > this.pnx[var140 + 9] && this.xm < 548 && this.ym > 433 + var140 * 24 && this.ym < 453 + var140 * 24) {
                        var115 = var140 + 9;
                        this.rd.setColor(new Color(176, 64, 0));
                        this.rd.drawLine(this.pnx[var140 + 9], 448 + var140 * 24, 446, 448 + var140 * 24);
                     }

                     this.rd.drawString("" + this.pname[var140 + 9] + " :", this.pnx[var140 + 9], 447 + var140 * 24);
                     this.rd.drawLine(458, 443 + var140 * 24, 548, 443 + var140 * 24);

                     for (int var172 = 1; var172 < 10; var172++) {
                        this.rd.drawLine(458 + 10 * var172, 443 - var172 + var140 * 24, 458 + 10 * var172, 443 + var172 + var140 * 24);
                     }

                     this.rd.setColor(new Color(255, 0, 0));
                     int var173 = (int)(this.phys[var140 + 9] / 1.1111F / 10.0F);
                     this.rd.fillRect(456 + (int)(this.phys[var140 + 9] / 1.1111F), 443 - var173 + var140 * 24, 5, var173 * 2 + 1);
                     this.rd.setColor(new Color(255, 128, 0));
                     this.rd.drawRect(457 + (int)(this.phys[var140 + 9] / 1.1111F), 434 + var140 * 24, 2, 18);
                     this.stringbutton(" - ", 578, 447 + var140 * 24, 4, false);
                     this.stringbutton(" + ", 618, 447 + var140 * 24, 4, false);
                  }

                  this.stringbutton(" Random ", 361, 519, 0, false);
                  this.stringbutton(" Reset ", 436, 519, 0, false);
                  this.stringbutton(" <  Back ", 509, 519, 0, false);
                  this.stringbutton("       Next  >       ", 603, 519, 0, true);
               }

               if (this.pfase == 2) {
                  if (this.xm > 40 && this.xm < 670 && this.ym > 416 && this.ym < 436) {
                     var115 = 11;
                     this.rd.setColor(new Color(176, 64, 0));
                     this.rd.drawLine(596, 431, 669, 431);
                  }

                  this.rd
                     .drawString(
                        "[   Crash Test,  Damage :                                       ]                                                     What is this?",
                        180,
                        430
                     );
                  if (this.hitmag < 0) {
                     this.hitmag = 0;
                  }

                  if (this.hitmag > 17000) {
                     this.crashok = true;
                     this.hitmag = 17000;

                     for (int var141 = 0; var141 < this.o.npl; var141++) {
                        if ((this.o.p[var141].wz == 0 || this.o.p[var141].gr == -17 || this.o.p[var141].gr == -16) && this.o.p[var141].embos == 0) {
                           this.o.p[var141].embos = 1;
                        }
                     }
                  }

                  this.rd.setColor(new Color(255, (int)(250.0F - this.hitmag / 68.0F), 0));
                  this.rd.fillRect(322, 423, (int)(this.hitmag / 170.0F), 7);
                  this.rd.setColor(new Color(255, 0, 0));
                  this.rd.drawRect(322, 423, 100, 7);
                  if (var115 != 11) {
                     this.rd.setColor(new Color(170, 170, 170));
                  } else {
                     this.rd.setColor(new Color(176, 64, 0));
                  }

                  this.rd.drawString("Normal Crash", 39, 438);
                  this.rd.drawString("Roof Crash", 501, 438);
                  this.rd.drawLine(125, 426, 179, 426);
                  this.rd.drawLine(125, 426, 125, 440);
                  this.rd.drawLine(491, 426, 437, 426);
                  this.rd.drawLine(491, 426, 491, 440);
                  this.rd.drawRect(19, 440, 276, 91);
                  this.rd.drawRect(339, 440, 312, 67);
                  this.rd.setColor(new Color(0, 0, 0));
                  if (this.xm > 50 && this.xm < 195 && this.ym > 446 && this.ym < 466) {
                     var115 = 12;
                     this.rd.setColor(new Color(176, 64, 0));
                     this.rd.drawLine(50, 461, 94, 461);
                  }

                  this.rd.drawString("Radius :", 50, 460);
                  this.rd.drawLine(105, 456, 195, 456);

                  for (int var142 = 1; var142 < 10; var142++) {
                     this.rd.drawLine(105 + 10 * var142, 456 - var142, 105 + 10 * var142, 456 + var142);
                  }

                  this.rd.setColor(new Color(255, 0, 0));
                  int var143 = (int)(this.crash[0] / 1.1111F / 10.0F);
                  this.rd.fillRect(103 + (int)(this.crash[0] / 1.1111F), 456 - var143, 5, var143 * 2 + 1);
                  this.rd.setColor(new Color(255, 128, 0));
                  this.rd.drawRect(104 + (int)(this.crash[0] / 1.1111F), 447, 2, 18);
                  this.stringbutton(" - ", 225, 460, 4, false);
                  this.stringbutton(" + ", 265, 460, 4, false);
                  this.rd.setColor(new Color(0, 0, 0));
                  if (this.xm > 30 && this.xm < 195 && this.ym > 470 && this.ym < 490) {
                     var115 = 13;
                     this.rd.setColor(new Color(176, 64, 0));
                     this.rd.drawLine(30, 485, 94, 485);
                  }

                  this.rd.drawString("Magnitude :", 30, 484);
                  this.rd.drawLine(105, 480, 195, 480);

                  for (int var174 = 1; var174 < 10; var174++) {
                     this.rd.drawLine(105 + 10 * var174, 480 - var174, 105 + 10 * var174, 480 + var174);
                  }

                  this.rd.setColor(new Color(255, 0, 0));
                  var143 = (int)(this.crash[1] / 1.1111F / 10.0F);
                  this.rd.fillRect(103 + (int)(this.crash[1] / 1.1111F), 480 - var143, 5, var143 * 2 + 1);
                  this.rd.setColor(new Color(255, 128, 0));
                  this.rd.drawRect(104 + (int)(this.crash[1] / 1.1111F), 471, 2, 18);
                  this.stringbutton(" - ", 225, 484, 4, false);
                  this.stringbutton(" + ", 265, 484, 4, false);
                  this.rd.setColor(new Color(0, 0, 0));
                  if (this.xm > 350 && this.xm < 551 && this.ym > 446 && this.ym < 466) {
                     var115 = 14;
                     this.rd.setColor(new Color(176, 64, 0));
                     this.rd.drawLine(350, 461, 450, 461);
                  }

                  this.rd.drawString("Roof Destruction :", 350, 460);
                  this.rd.drawLine(461, 456, 551, 456);

                  for (int var175 = 1; var175 < 10; var175++) {
                     this.rd.drawLine(461 + 10 * var175, 456 - var175, 461 + 10 * var175, 456 + var175);
                  }

                  this.rd.setColor(new Color(255, 0, 0));
                  var143 = (int)(this.crash[2] / 1.1111F / 10.0F);
                  this.rd.fillRect(459 + (int)(this.crash[2] / 1.1111F), 456 - var143, 5, var143 * 2 + 1);
                  this.rd.setColor(new Color(255, 128, 0));
                  this.rd.drawRect(460 + (int)(this.crash[2] / 1.1111F), 447, 2, 18);
                  this.stringbutton(" - ", 581, 460, 4, false);
                  this.stringbutton(" + ", 621, 460, 4, false);
                  this.stringbutton("    CRASH!    ", 143, 516, 0, true);
                  this.stringbutton("  Fix  ", 235, 516, 0, false);
                  this.stringbutton("    CRASH Roof!    ", 484, 492, 0, true);
                  this.stringbutton("  Fix  ", 591, 492, 0, false);
                  this.stringbutton(" Reset ", 435, 535, 0, false);
                  this.stringbutton(" <  Back ", 508, 535, 0, false);
                  this.stringbutton("       Next  >       ", 602, 535, 0, true);
               }

               if (this.pfase == 3) {
                  this.rd.setColor(new Color(0, 0, 0));
                  this.rd.drawString("Select the most suitable engine for your car :", 30, 440);
                  this.engine.move(293, 424);
                  if (!this.engine.isShowing()) {
                     this.engine.show();
                     this.engine.select(this.engsel);
                  }

                  if (this.engsel != this.engine.getSelectedIndex()) {
                     this.engsel = this.engine.getSelectedIndex();

                     for (int var146 = 0; var146 < 5; var146++) {
                        for (int var176 = 0; var176 < 5; var176++) {
                           this.engs[var176][var146].stop();
                           this.engs[var176][var146].checkopen();
                        }
                     }

                     this.engon = false;
                  }

                  if (this.engsel == 0) {
                     this.rd.drawString("Normal Engine:  Like Tornado Shark, Sword of Justice or Radical One's engine.", 30, 470);
                  }

                  if (this.engsel == 1) {
                     this.rd.drawString("V8 Engine:  High speed engine like Formula 7, Drifter X or Might Eight's engine.", 30, 470);
                  }

                  if (this.engsel == 2) {
                     this.rd.drawString("Retro Engine:  Like Wow Caninaro, Lead Oxide or Kool Kat’s engine.", 30, 470);
                  }

                  if (this.engsel == 3) {
                     this.rd.drawString("Power Engine:  Turbo/super charged engine like Max Revenge, High Rider or Dr Monstaa’s engine.", 30, 470);
                  }

                  if (this.engsel == 4) {
                     this.rd.drawString("Diesel Engine:  Big diesel powered engine for big cars like EL King or  M A S H E E N .", 30, 470);
                  }

                  this.rd.drawString("LISTEN :", 30, 500);
                  this.stringbutton(" Idle ", 108, 500, 0, true);
                  this.stringbutton(" RPM 1 ", 170, 500, 0, true);
                  this.stringbutton(" RPM 2 ", 240, 500, 0, true);
                  this.stringbutton(" RPM 3 ", 310, 500, 0, true);
                  this.stringbutton(" RPM MAX ", 389, 500, 0, true);
                  if (this.engon) {
                     this.stringbutton("          Stop Engine          ", 240, 535, 0, true);
                  } else {
                     this.stringbutton("          Stop Engine          ", 240, -2500, 0, true);
                  }

                  this.stringbutton(" <  Back ", 500, 525, 0, false);
                  this.stringbutton("     Save & Finish!     ", 610, 525, 0, true);
               }

               if (this.pfase == 4) {
                  this.rd.drawString("Testing & Setting up Physics...", 265, 470);
                  this.repaint();

                  try {
                     Thread.sleep(100L);
                  } catch (InterruptedException var37) {
                  }

                  for (int var147 = 0; var147 < 4; var147++) {
                     byte var177 = 0;
                     byte var198 = 4;
                     if (var147 == 1) {
                        var198 = 2;
                     }

                     if (var147 == 2) {
                        var177 = 2;
                     }

                     for (int var212 = 0; var212 < 10; var212++) {
                        this.setupo();
                        this.o.xy = 0;
                        this.hitmag = 0;
                        int var224 = 0;
                        this.actmag = 0;
                        int var235 = var177;
                        boolean var239 = false;

                        while (this.hitmag < 17000) {
                           if (var239) {
                              this.regx(var235, (int)(150.0 + 600.0 * Math.random()), true);
                           } else {
                              this.regz(var235, (int)(150.0 + 600.0 * Math.random()), true);
                           }

                           if (++var235 == var198) {
                              this.o.xz += 45;
                              this.o.zy += 45;
                              var235 = 0;
                              if (var239) {
                                 var239 = false;
                              } else {
                                 var239 = true;
                              }

                              if (var224 == this.actmag) {
                                 this.crash[0] = this.crash[0] + 10;
                              }

                              var224 = this.actmag;
                           }
                        }
                     }

                     float var213 = 0.0F;

                     for (int var225 = 0; var225 < 10; var225++) {
                        this.setupo();
                        this.o.xy = 0;
                        this.actmag = 0;
                        this.hitmag = 0;
                        int var236 = var177;
                        boolean var240 = false;

                        while (this.hitmag < 17000) {
                           if (var240) {
                              this.regx(var236, (int)(150.0 + 600.0 * Math.random()), true);
                           } else {
                              this.regz(var236, (int)(150.0 + 600.0 * Math.random()), true);
                           }

                           if (++var236 == var198) {
                              this.o.xz += 45;
                              this.o.zy += 45;
                              var236 = 0;
                              if (var240) {
                                 var240 = false;
                              } else {
                                 var240 = true;
                              }
                           }
                        }

                        var213 += (float)this.actmag / this.hitmag;
                     }

                     var213 /= 10.0F;
                     this.actmag = (int)(this.hitmag * var213);
                     if (this.stat[4] > 200) {
                        this.stat[4] = 200;
                     }

                     if (this.stat[4] < 16) {
                        this.stat[4] = 16;
                     }

                     float var226 = 0.9F + (this.stat[4] - 90) * 0.01F;
                     if (var226 < 0.6) {
                        var226 = 0.6F;
                     }

                     if (this.stat[4] == 200 && this.stat[0] <= 88) {
                        var226 = 3.0F;
                     }

                     int var237 = (int)(this.actmag * var226);

                     for (int var241 = 0; var241 < 12; var241++) {
                        this.setupo();
                        this.o.xy = 0;
                        this.o.xz = 90 * var241;
                        if (this.o.xz >= 360) {
                           this.o.xz -= 360;
                        }

                        this.hitmag = 0;
                        int var245 = 0;
                        this.actmag = 0;
                        int var249 = var177;
                        boolean var253 = false;

                        while (this.actmag < var237) {
                           if (var253) {
                              this.regx(var249, (int)(150.0 + 600.0 * Math.random()), true);
                           } else {
                              this.regz(var249, (int)(150.0 + 600.0 * Math.random()), true);
                           }

                           if (++var249 == var198) {
                              if (var253) {
                                 var253 = false;
                              } else {
                                 var253 = true;
                              }

                              var249 = 0;
                              if (var245 == this.actmag) {
                                 this.crash[0] = this.crash[0] + 10;
                              }

                              var245 = this.actmag;
                           }
                        }
                     }

                     if (var147 == 3) {
                        var213 = 0.0F;

                        for (int var242 = 0; var242 < 10; var242++) {
                           this.setupo();
                           this.o.xy = 0;
                           this.actmag = 0;
                           this.hitmag = 0;
                           int var246 = var177;
                           boolean var250 = false;

                           while (this.hitmag < 17000) {
                              if (var250) {
                                 this.regx(var246, (int)(150.0 + 600.0 * Math.random()), true);
                              } else {
                                 this.regz(var246, (int)(150.0 + 600.0 * Math.random()), true);
                              }

                              if (++var246 == var198) {
                                 this.o.xz += 45;
                                 this.o.zy += 45;
                                 var246 = 0;
                                 if (var250) {
                                    var250 = false;
                                 } else {
                                    var250 = true;
                                 }
                              }
                           }

                           var213 += (float)this.actmag / this.hitmag;
                        }

                        var213 /= 10.0F;
                        this.actmag = (int)(this.hitmag * var213);
                     }
                  }

                  this.setupo();
                  String var148 = "" + this.editor.getText() + "\n";
                  String var178 = "";
                  int var199 = 0;
                  int var217 = var148.indexOf("\n", 0);

                  while (var217 != -1 && var199 < var148.length()) {
                     String var227 = var148.substring(var199, var217);
                     var227 = var227.trim();
                     var199 = var217 + 1;
                     var217 = var148.indexOf("\n", var199);
                     if (!var227.startsWith("physics(")) {
                        var178 = var178 + "" + var227 + "\n";
                     } else {
                        var178 = var178.trim();
                        var178 = var178 + "\n";
                     }
                  }

                  var178 = var178.trim();
                  var178 = var178
                     + "\n\n\nphysics("
                     + this.phys[0]
                     + ","
                     + this.phys[1]
                     + ","
                     + this.phys[2]
                     + ","
                     + this.phys[3]
                     + ","
                     + this.phys[4]
                     + ","
                     + this.phys[5]
                     + ","
                     + this.phys[6]
                     + ","
                     + this.phys[7]
                     + ","
                     + this.phys[8]
                     + ","
                     + this.phys[9]
                     + ","
                     + this.phys[10]
                     + ","
                     + this.crash[0]
                     + ","
                     + this.crash[1]
                     + ","
                     + this.crash[2]
                     + ","
                     + this.engsel
                     + ","
                     + this.actmag
                     + ")\n\n\n\n";
                  this.editor.setText(var178);
                  this.savefile();

                  for (int var229 = 0; var229 < 11; var229++) {
                     this.rphys[var229] = this.phys[var229];
                  }

                  for (int var230 = 0; var230 < 3; var230++) {
                     this.rcrash[var230] = this.crash[var230];
                  }

                  this.pfase = 5;
               }

               if (this.pfase == 5) {
                  this.rd.drawString("Car physics has been successfully set up!", 231, 450);
                  this.rd.drawString("Test drive your car to see the results...", 242, 490);
               }

               if (var115 != -1) {
                  if (this.mouseon == -1) {
                     this.mouseon = var115;
                     this.setCursor(new Cursor(12));
                  }
               } else if (this.mouseon != -1) {
                  this.mouseon = -1;
                  this.setCursor(new Cursor(0));
               }

               if (this.mouses == -1 && var115 != -1) {
                  JOptionPane.showMessageDialog(null, this.usage[var115], "Car Maker", 1);
               }
            }

            if (this.dtab == 6) {
               if (this.dtab != this.dtabed) {
                  String var116 = "" + this.editor.getText() + "\n";
                  int var149 = 0;
                  int var182 = var116.indexOf("\n", 0);

                  while (var182 != -1 && var149 < var116.length()) {
                     String var200 = var116.substring(var149, var182);
                     var200 = var200.trim();
                     var149 = var182 + 1;
                     var182 = var116.indexOf("\n", var149);
                     if (var200.startsWith("handling(")) {
                        try {
                           this.handling = this.getvalue("handling", var200, 0);
                           if (this.handling > 200) {
                              this.handling = 200;
                           }

                           if (this.handling < 50) {
                              this.handling = 50;
                           }
                        } catch (Exception var36) {
                        }
                     }
                  }

                  this.rateh = false;
               }

               if (!this.rateh) {
                  this.rd.setFont(new Font("Arial", 1, 13));
                  this.ftm = this.rd.getFontMetrics();
                  this.rd.drawString("Test Drive the Car", 350 - this.ftm.stringWidth("Test Drive the Car") / 2, 445);
                  this.witho.move(292, 455);
                  if (!this.witho.isShowing()) {
                     this.witho.show();
                  }

                  this.stringbutton("     TEST DRIVE!     ", 350, 505, 0, true);
                  if (this.tested) {
                     this.stringbutton("  Edit Stats & Class  ", 150, 471, 0, false);
                     this.stringbutton("  Edit Physics  ", 150, 505, 0, false);
                     this.stringbutton("     Rate Car Handling     ", 550, 471, 0, true);
                  }
               } else {
                  this.rd.setFont(new Font("Arial", 1, 13));
                  this.ftm = this.rd.getFontMetrics();
                  this.rd
                     .drawString(
                        "Based on you test drive(s), how do your rate " + this.carname + "'s handling?",
                        350 - this.ftm.stringWidth("Based on your test drive(s), how do you rate " + this.carname + "'s handling?") / 2,
                        445
                     );
                  this.rd.setFont(new Font("Arial", 1, 12));
                  this.rd.drawString("Handling :", 183, 483);

                  for (int var117 = 0; var117 < this.handling; var117++) {
                     this.rd.setColor(Color.getHSBColor((float)(var117 * 7.0E-4), 1.0F, 1.0F));
                     this.rd.drawLine(250 + var117, 474, 250 + var117, 482);
                  }

                  this.rd.setColor(new Color(0, 0, 0));
                  this.rd.drawLine(249, 474, 249, 482);
                  this.rd.drawLine(450, 474, 450, 482);
                  this.rd.drawLine(249, 483, 450, 483);

                  for (int var118 = 0; var118 < 7; var118++) {
                     this.rd.drawLine(275 + var118 * 25, 482, 275 + var118 * 25, 478);
                  }

                  this.stringbutton(" - ", 480, 483, 4, false);
                  this.stringbutton(" + ", 520, 483, 4, false);
                  this.stringbutton("       Save       ", 388, 525, 0, true);
                  this.stringbutton(" Cancel ", 298, 525, 0, false);
               }
            }

            if (this.polynum >= 0 && this.cntpls > 0) {
               for (int var119 = 0; var119 < this.o.npl; var119++) {
                  if (var119 >= this.polynum && var119 < this.polynum + this.cntpls) {
                     if (this.pflk) {
                        this.o.p[var119].hsb[2] = 1.0F;
                     } else {
                        this.o.p[var119].hsb[2] = 0.0F;
                        this.o.p[var119].hsb[0] = Math.abs(0.5F - this.o.p[var119].hsb[0]);

                        while (this.o.p[var119].hsb[0] > 1.0F) {
                           this.o.p[var119].hsb[0]--;
                        }
                     }
                  } else if (this.prflk > 6 && this.prflk < 20) {
                     this.o.p[var119].gr = -13;
                  } else {
                     this.o.p[var119].gr = 1;
                  }
               }

               if (this.pflk) {
                  this.pflk = false;
               } else {
                  this.pflk = true;
               }

               if (this.prflk < 40) {
                  this.prflk++;
               }

               this.rd.setFont(new Font("Arial", 1, 12));
               this.rd.setColor(new Color(0, 0, 0));
               this.rd
                  .drawString(
                     "[ Showing " + this.cntpls + " Polygons Selected ]",
                     350 - this.ftm.stringWidth("[ Showing " + this.cntpls + " Polygons Selected ]") / 2,
                     45
                  );
               this.stringbutton("  Stop  ", 350, 67, 5, false);
            }

            var2 = 50;
            if (this.rotr) {
               this.o.xz -= 5;
               var2 = 15;
            }

            if (this.rotl) {
               this.o.xz += 5;
               var2 = 15;
            }

            if (this.left) {
               this.o.xy -= 5;
               var2 = 15;
            }

            if (this.right) {
               this.o.xy += 5;
               var2 = 15;
            }

            if (this.up) {
               this.o.zy -= 5;
               var2 = 15;
            }

            if (this.down) {
               this.o.zy += 5;
               var2 = 15;
            }

            if (this.plus) {
               this.o.y += 5;
               var2 = 15;
            }

            if (this.minus) {
               this.o.y -= 5;
               var2 = 15;
            }

            if (this.in) {
               this.o.z += 10;
               var2 = 15;
            }

            if (this.out) {
               this.o.z -= 10;
               var2 = 15;
            }

            this.ox = this.o.x;
            this.oy = this.o.y;
            this.oz = this.o.z;
            this.oxz = this.o.xz;
            this.oxy = this.o.xy;
            this.ozy = this.o.zy;
            if (this.dtabed != this.dtab) {
               this.dtabed = this.dtab;
            }

            if (this.dtab == 5 && this.pfase == -1) {
               this.repaint();
               JOptionPane.showMessageDialog(
                  null,
                  "Car Wheels not defined or not defined correctly.\nBefore defining the car Physics car Wheels must be defined correctly!\nPlease go to the ‘Wheels’ tab and use  [ Apply ]  and  [ Save ]  to define correctly.\n",
                  "Car Maker",
                  1
               );
               this.dtab = 3;
            }
         }

         if (this.tab == 3) {
            this.rd.setFont(new Font("Arial", 1, 13));
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawString("Publish Car :  [ " + this.carname + " ]", 30, 50);
            this.rd.drawString("Publishing Type :", 30, 80);
            this.pubtyp.move(150, 63);
            if (!this.pubtyp.isShowing()) {
               this.pubtyp.show();
               this.pubtyp.select(1);
            }

            this.stringbutton("       Publish  >       ", 102, 110, 0, true);
            this.pubitem.move(690 - this.pubitem.w, 96);
            if (!this.pubitem.isShowing()) {
               this.pubitem.show();
            }

            if (this.pubitem.sel != 0) {
               boolean var57 = false;

               for (int var71 = 0; var71 < this.nmc; var71++) {
                  if (this.pubitem.getSelectedItem().equals(this.mycars[var71])) {
                     var57 = true;
                  }
               }

               if (!var57) {
                  this.logged = 2;
               }
            }

            this.rd.setColor(new Color(0, 0, 0));
            this.rd.setFont(new Font("Arial", 0, 12));
            if (this.pubtyp.getSelectedIndex() == 0) {
               this.rd.drawString("Private :  This means only you can use your car and no one else can add", 268, 72);
               this.rd.drawString("it to their account to play with it !", 268, 88);
            }

            if (this.pubtyp.getSelectedIndex() == 1) {
               this.rd.drawString("Public :  This means anyone can add this car to their account to play with it,", 268, 72);
               this.rd.drawString("but only you can download it to your Car Maker (no one else can get it’s code).", 268, 88);
            }

            if (this.pubtyp.getSelectedIndex() == 2) {
               this.rd.drawString("Super Public :  This means anyone can add this car to their account to play", 268, 72);
               this.rd.drawString("with it and anyone can also download it to their Car Maker to get its code.", 268, 88);
            }

            this.rd.setFont(new Font("Arial", 1, 12));
            this.ftm = this.rd.getFontMetrics();
            this.rd.drawString("Car Name", 80 - this.ftm.stringWidth("Car Name") / 2, 138);
            this.rd.drawString("Car Class", 200 - this.ftm.stringWidth("Car Class") / 2, 138);
            this.rd.drawString("Created By", 300 - this.ftm.stringWidth("Created By") / 2, 138);
            this.rd.drawString("Added By", 400 - this.ftm.stringWidth("Added By") / 2, 138);
            this.rd.drawString("Publish Type", 500 - this.ftm.stringWidth("Publish Type") / 2, 138);
            this.rd.drawString("Options", 620 - this.ftm.stringWidth("Options") / 2, 138);
            this.rd.drawLine(150, 129, 150, 140);
            this.rd.drawLine(250, 129, 250, 140);
            this.rd.drawLine(350, 129, 350, 140);
            this.rd.drawLine(450, 129, 450, 140);
            this.rd.drawLine(550, 129, 550, 140);
            this.rd.drawRect(10, 140, 680, 402);
            if (this.logged == 0) {
               this.rd.setFont(new Font("Arial", 1, 13));
               this.ftm = this.rd.getFontMetrics();
               this.rd.drawString("Login to Retrieve your Account Cars", 350 - this.ftm.stringWidth("Login to Retrieve your Account Cars") / 2, 220);
               this.rd.drawString("Nickname:", 326 - this.ftm.stringWidth("Nickname:") - 14, 266);
               this.movefield(this.tnick, 326, 250, 129, 22);
               if (!this.tnick.isShowing()) {
                  this.tnick.show();
               }

               this.rd.drawString("Password:", 326 - this.ftm.stringWidth("Password:") - 14, 296);
               this.movefield(this.tpass, 326, 280, 129, 22);
               if (!this.tpass.isShowing()) {
                  this.tpass.show();
               }

               this.stringbutton("       Login       ", 350, 340, 0, true);
               this.rd.setFont(new Font("Arial", 1, 13));
               this.ftm = this.rd.getFontMetrics();
               this.rd
                  .drawString(
                     "Register a full account or if you have a trial account upgrade it!",
                     350 - this.ftm.stringWidth("Register a full account or if you have a trial account upgrade it!") / 2,
                     450
                  );
               this.stringbutton("   Register!   ", 290, 480, 0, true);
               this.stringbutton("   Upgrade!   ", 410, 480, 0, true);
               this.rd.setFont(new Font("Arial", 0, 12));
               this.ftm = this.rd.getFontMetrics();
               this.rd
                  .drawString(
                     "You need a full account to publish your cars to the multiplayer game!",
                     350 - this.ftm.stringWidth("You need a full account to publish your cars to the multiplayer game!") / 2,
                     505
                  );
            }

            if (this.logged == -1) {
               this.rd.setFont(new Font("Arial", 1, 13));
               this.ftm = this.rd.getFontMetrics();
               this.rd.drawString("Ready to publish...", 350 - this.ftm.stringWidth("Ready to publish...") / 2, 220);
               this.rd
                  .drawString(
                     "Click ‘Publish’ above to add car: '" + this.carname + "'.",
                     350 - this.ftm.stringWidth("Click ‘Publish’ above to add car: '" + this.carname + "'.") / 2,
                     280
                  );
            }

            if (this.logged == 2) {
               this.mycars[this.roto] = this.pubitem.getSelectedItem();
               this.rd.setFont(new Font("Arial", 1, 13));
               this.ftm = this.rd.getFontMetrics();
               this.rd.setColor(new Color(225, 225, 225));
               this.rd.fillRect(50, 150, 600, 150);
               this.rd.setColor(new Color(0, 0, 0));
               this.rd
                  .drawString(
                     "Loading " + this.mycars[this.roto] + "‘s info...",
                     350 - this.ftm.stringWidth("Loading " + this.mycars[this.roto] + "‘s info...") / 2,
                     220
                  );
               this.repaint();
               this.maker[this.roto] = "Unkown";
               this.pubt[this.roto] = -1;
               this.clas[this.roto] = 0;
               this.nad[this.roto] = 0;
               String var58 = "";

               try {
                  String var72 = Madness.corsProxy + "http://multiplayer.needformadness.com/cars/" + this.mycars[this.roto] + ".txt?reqlo=" + (int)(Math.random() * 1000.0) + "";
                  var72 = var72.replace(' ', '_');
                  URL var82 = new URL(var72);
                  DataInputStream var120 = new DataInputStream(var82.openStream());

                  while ((var58 = var120.readLine()) != null) {
                     var58 = "" + var58.trim();
                     if (var58.startsWith("details")) {
                        this.maker[this.roto] = this.getSvalue("details", var58, 0);
                        this.pubt[this.roto] = this.getvalue("details", var58, 1);
                        this.clas[this.roto] = this.getvalue("details", var58, 2);
                        boolean var150 = false;

                        while (!var150) {
                           this.addeda[this.roto][this.nad[this.roto]] = this.getSvalue("details", var58, 3 + this.nad[this.roto]);
                           if (this.addeda[this.roto][this.nad[this.roto]].equals("")) {
                              var150 = true;
                           } else {
                              this.nad[this.roto]++;
                           }
                        }
                     }
                  }

                  this.nmc++;
                  if (this.nmc > 20) {
                     this.nmc = 20;
                  }

                  this.roto++;
                  if (this.roto >= 20) {
                     this.roto = 0;
                  }
               } catch (Exception var49) {
               }

               this.logged = 3;
            }

            if (this.logged == 1) {
               this.rd.setFont(new Font("Arial", 1, 13));
               this.ftm = this.rd.getFontMetrics();
               this.rd.drawString("Loading your account car list...", 350 - this.ftm.stringWidth("Loading your account car list...") / 2, 220);
               this.repaint();
               this.pubitem.removeAll();
               this.pubitem.add(this.rd, "Account Cars");
               this.nmc = 0;
               this.roto = 0;
               int var61 = 0;
               String var74 = "";

               try {
                  URL var83 = new URL(
                     Madness.corsProxy + "http://multiplayer.needformadness.com/cars/lists/" + this.tnick.getText() + ".txt?reqlo=" + (int)(Math.random() * 1000.0) + ""
                  );
                  DataInputStream var122 = new DataInputStream(var83.openStream());

                  while ((var74 = var122.readLine()) != null) {
                     var74 = "" + var74.trim();
                     if (var74.startsWith("mycars")) {
                        boolean var151 = true;

                        while (var151 && var61 < 700) {
                           String var183 = this.getSvalue("mycars", var74, var61);
                           if (var183.equals("")) {
                              var151 = false;
                           } else {
                              this.pubitem.add(this.rd, var183);
                              var61++;
                           }
                        }
                     }
                  }

                  this.setCursor(new Cursor(0));
                  this.logged = -1;
                  var122.close();
               } catch (Exception var48) {
                  String var121 = "" + var48;
                  if (var121.indexOf("FileNotFound") != -1) {
                     this.setCursor(new Cursor(0));
                     this.logged = -1;
                  } else {
                     this.logged = 0;
                     JOptionPane.showMessageDialog(null, "Unable to connect to server at this moment, please try again later.", "Car Maker", 1);
                  }
               }

               if (!this.justpubd.equals("")) {
                  this.pubitem.select(this.justpubd);
                  this.justpubd = "";
               }
            }

            if (this.logged == 3) {
               for (int var62 = 0; var62 < this.nmc; var62++) {
                  this.rd.setColor(new Color(235, 235, 235));
                  if (this.xm > 11 && this.xm < 689 && this.ym > 142 + var62 * 20 && this.ym < 160 + var62 * 20) {
                     this.rd.setColor(new Color(255, 255, 255));
                  }

                  this.rd.fillRect(11, 142 + var62 * 20, 678, 18);
                  this.rd.setFont(new Font("Arial", 0, 12));
                  this.ftm = this.rd.getFontMetrics();
                  this.rd.setColor(new Color(0, 0, 0));
                  this.rd.drawString(this.mycars[var62], 80 - this.ftm.stringWidth(this.mycars[var62]) / 2, 156 + var62 * 20);
                  this.rd.setColor(new Color(155, 155, 155));
                  this.rd.drawLine(150, 145 + var62 * 20, 150, 157 + var62 * 20);
                  if (this.pubt[var62] != -1) {
                     this.rd.drawLine(250, 145 + var62 * 20, 250, 157 + var62 * 20);
                     this.rd.drawLine(350, 145 + var62 * 20, 350, 157 + var62 * 20);
                     this.rd.drawLine(450, 145 + var62 * 20, 450, 157 + var62 * 20);
                     this.rd.drawLine(550, 145 + var62 * 20, 550, 157 + var62 * 20);
                     this.rd.setColor(new Color(0, 0, 64));
                     String var77 = "C";
                     if (this.clas[var62] == 1) {
                        var77 = "B & C";
                     }

                     if (this.clas[var62] == 2) {
                        var77 = "B";
                     }

                     if (this.clas[var62] == 3) {
                        var77 = "A & B";
                     }

                     if (this.clas[var62] == 4) {
                        var77 = "A";
                     }

                     this.rd.drawString("Class " + var77 + "", 200 - this.ftm.stringWidth("Class " + var77 + "") / 2, 156 + var62 * 20);
                     boolean var84 = false;
                     if (this.maker[var62].toLowerCase().equals(this.tnick.getText().toLowerCase())) {
                        var84 = true;
                        this.rd.setColor(new Color(0, 64, 0));
                        this.rd.drawString("You", 300 - this.ftm.stringWidth("You") / 2, 156 + var62 * 20);
                     } else {
                        this.rd.drawString(this.maker[var62], 300 - this.ftm.stringWidth(this.maker[var62]) / 2, 156 + var62 * 20);
                     }

                     if (this.nad[var62] > 1) {
                        if (this.ovbutton("" + this.nad[var62] + " Players", 400, 156 + var62 * 20)) {
                           String var123 = "[ " + this.mycars[var62] + " ]  has been added by the following players to their accounts:     \n\n";
                           int var152 = 0;

                           for (int var184 = 0; var184 < this.nad[var62]; var184++) {
                              if (++var152 == 17) {
                                 var123 = var123 + "\n";
                                 var152 = 1;
                              }

                              var123 = var123 + this.addeda[var62][var184];
                              if (var184 != this.nad[var62] - 1) {
                                 if (var184 != this.nad[var62] - 2) {
                                    var123 = var123 + ", ";
                                 } else if (var152 == 16) {
                                    var123 = var123 + "\nand ";
                                    var152 = 0;
                                 } else {
                                    var123 = var123 + " and ";
                                 }
                              }
                           }

                           var123 = var123 + "\n \n \n";
                           JOptionPane.showMessageDialog(null, var123, "Car Maker", 1);
                        }
                     } else {
                        this.rd.setColor(new Color(0, 0, 64));
                        this.rd.drawString("None", 400 - this.ftm.stringWidth("None") / 2, 156 + var62 * 20);
                     }

                     if (this.pubt[var62] == 0) {
                        this.rd.setColor(new Color(0, 0, 64));
                        this.rd.drawString("Private", 500 - this.ftm.stringWidth("Private") / 2, 156 + var62 * 20);
                     }

                     if (this.pubt[var62] == 1) {
                        this.rd.setColor(new Color(0, 0, 64));
                        this.rd.drawString("Public", 500 - this.ftm.stringWidth("Public") / 2, 156 + var62 * 20);
                     }

                     if (this.pubt[var62] == 2) {
                        this.rd.setColor(new Color(0, 64, 0));
                        this.rd.drawString("Super Public", 500 - this.ftm.stringWidth("Super Public") / 2, 156 + var62 * 20);
                     }

                     if ((this.pubt[var62] == 2 || var84) && this.ovbutton("Download", 600, 156 + var62 * 20)) {
                        int var125 = 0;

                        for (int var153 = 0; var153 < this.slcar.getItemCount(); var153++) {
                           if (this.mycars[var62].equals(this.slcar.getItem(var153))) {
                              var125 = JOptionPane.showConfirmDialog(
                                 null, "Replace the local " + this.mycars[var62] + " in your 'mycars' folder with the published online copy?", "Car Maker", 0
                              );
                           }
                        }

                        if (var125 == 0) {
                           this.setCursor(new Cursor(3));
                           this.rd.setFont(new Font("Arial", 1, 13));
                           this.ftm = this.rd.getFontMetrics();
                           this.rd.setColor(new Color(225, 225, 225));
                           this.rd.fillRect(11, 141, 679, 401);
                           this.rd.setColor(new Color(0, 0, 0));
                           this.rd.drawString("Downloading car, please wait...", 350 - this.ftm.stringWidth("Downloading car, please wait...") / 2, 250);
                           this.repaint();

                           try {
                              String var154 = "http://multiplayer.needformadness.com/cars/"
                                 + this.mycars[var62]
                                 + ".radq?reqlo="
                                 + (int)(Math.random() * 1000.0)
                                 + "";
                              var154 = var154.replace(' ', '_');
                              URL var185 = new URL(var154);
                              int var218 = var185.openConnection().getContentLength();
                              DataInputStream var231 = new DataInputStream(var185.openStream());
                              byte[] var238 = new byte[var218];
                              var231.readFully(var238);
                              ZipInputStream var202;
                              if (var238[0] == 80 && var238[1] == 75 && var238[2] == 3) {
                                 var202 = new ZipInputStream(new ByteArrayInputStream(var238));
                              } else {
                                 byte[] var243 = new byte[var218 - 40];

                                 for (int var247 = 0; var247 < var218 - 40; var247++) {
                                    byte var251 = 20;
                                    if (var247 >= 500) {
                                       var251 = 40;
                                    }

                                    var243[var247] = var238[var247 + var251];
                                 }

                                 var202 = new ZipInputStream(new ByteArrayInputStream(var243));
                              }

                              ZipEntry var244 = var202.getNextEntry();
                              if (var244 == null) {
                                 JOptionPane.showMessageDialog(null, "Unable to download car.  Unknown Error!     \nPlease try again later.", "Car Maker", 1);
                              } else {
                                 int var248 = Integer.valueOf(var244.getName());
                                 byte[] var252 = new byte[var248];
                                 int var254 = 0;

                                 while (var248 > 0) {
                                    int var255 = var202.read(var252, var254, var248);
                                    var254 += var255;
                                    var248 -= var255;
                                 }

                                 String var256 = new String(var252);
                                 var256 = var256 + "\n";
                                 String var258 = "";
                                 int var262 = 0;
                                 int var263 = var256.indexOf("\n", 0);

                                 while (var263 != -1 && var262 < var256.length()) {
                                    String var264 = var256.substring(var262, var263);
                                    var264 = var264.trim();
                                    var262 = var263 + 1;
                                    var263 = var256.indexOf("\n", var262);
                                    if (!var264.startsWith("carmaker(") && !var264.startsWith("publish(")) {
                                       var258 = var258 + "" + var264 + "\n";
                                    } else {
                                       var258 = var258.trim();
                                       var258 = var258 + "\n";
                                    }
                                 }

                                 var258 = var258.trim();
                                 var258 = var258 + "\n\n";
                                 File var266 = new File("" + cmfpath + "mycars/");
                                 if (!var266.exists()) {
                                    var266.mkdirs();
                                 }

                                 var266 = new File("" + cmfpath + "mycars/" + this.mycars[var62] + ".rad");
                                 BufferedWriter var268 = new BufferedWriter(new FileWriter(var266));
                                 var268.write(var258);
                                 var268.close();
                                 Object var269 = null;
                                 var202.close();
                                 if (this.carname.equals(this.mycars[var62])) {
                                    this.editor.setText(var258);
                                    this.lastedo = var258;
                                 }

                                 this.setCursor(new Cursor(0));
                                 JOptionPane.showMessageDialog(null, "" + this.mycars[var62] + " has been successfully downloaded!", "Car Maker", 1);
                              }
                           } catch (Exception var47) {
                              JOptionPane.showMessageDialog(null, "Unable to download car.  Unknown Error!     \nPlease try again later.", "Car Maker", 1);
                           }
                        }
                     }
                  } else {
                     this.rd
                        .drawString(
                           "-    Error Loading this car's info!    -",
                           350 - this.ftm.stringWidth("-    Error Loading this car's info!    -") / 2,
                           156 + var62 * 20
                        );
                  }

                  if (this.ovbutton("X", 665, 156 + var62 * 20)
                     && JOptionPane.showConfirmDialog(null, "Remove " + this.mycars[var62] + " from your account?", "Car Maker", 0) == 0) {
                     this.setCursor(new Cursor(3));
                     int var78 = -1;

                     try {
                        Socket var85 = new Socket("69.195.146.194", 7061);
                        BufferedReader var126 = new BufferedReader(new InputStreamReader(var85.getInputStream()));
                        PrintWriter var156 = new PrintWriter(var85.getOutputStream(), true);
                        var156.println("9|" + this.tnick.getText() + "|" + this.tpass.getText() + "|" + this.mycars[var62] + "|");
                        String var186 = var126.readLine();
                        if (var186 != null) {
                           var78 = this.servervalue(var186, 0);
                        }

                        var85.close();
                     } catch (Exception var35) {
                        var78 = -1;
                     }

                     if (var78 == 0) {
                        this.logged = 1;
                     } else {
                        this.setCursor(new Cursor(0));
                        JOptionPane.showMessageDialog(
                           null, "Failed to remove " + this.mycars[var62] + " from your account.  Unknown Error!     \nPlease try again later.", "Car Maker", 1
                        );
                     }
                  }
               }
            }
         }

         if (this.tabed != this.tab) {
            this.tabed = this.tab;
         }

         this.rd.setColor(new Color(0, 0, 0));
         this.rd.fillRect(0, 0, 700, 25);
         if (!this.onbtgame) {
            this.rd.drawImage(this.btgame[0], 520, 0, null);
         } else {
            this.rd.drawImage(this.btgame[1], 520, 0, null);
         }

         this.rd.setFont(new Font("Arial", 1, 13));
         this.ftm = this.rd.getFontMetrics();
         String[] var63 = new String[]{"Car", "Code Edit", "3D Edit", "Publish"};
         int[] var79 = new int[]{0, 0, 100, 90};
         int[] var86 = new int[]{0, 25, 25, 0};
         byte var127 = 4;
         if (this.carname.equals("") || !this.loadedfile || this.sfase != 0) {
            this.tab = 0;
            var127 = 1;
         }

         for (int var157 = 0; var157 < var127; var157++) {
            this.rd.setColor(new Color(170, 170, 170));
            if (this.xm > var79[0] && this.xm < var79[3] && this.ym > 0 && this.ym < 25) {
               this.rd.setColor(new Color(200, 200, 200));
            }

            if (this.tab == var157) {
               this.rd.setColor(new Color(225, 225, 225));
            }

            this.rd.fillPolygon(var79, var86, 4);
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawString(var63[var157], var157 * 100 + 45 - this.ftm.stringWidth(var63[var157]) / 2, 17);
            if (this.xm > var79[0] && this.xm < var79[3] && this.ym > 0 && this.ym < 25 && this.mouses == -1) {
               if (this.tab != var157 && this.tab == 1) {
                  this.savefile();
               }

               this.tab = var157;
            }

            for (int var187 = 0; var187 < 4; var187++) {
               var79[var187] += 100;
            }
         }

         this.drawms();
         this.ctachm();
         this.repaint();
         if (!this.exwist) {
            try {
               Thread.sleep(var2);
            } catch (InterruptedException var34) {
            }
         }
      }

      this.rd.dispose();
      System.gc();
      if (Madness.endadv == 2) {
         Madness.advopen();
      }
   }

   public void ctachm() {
      int var1 = -1;

      for (int var2 = 0; var2 < this.btn; var2++) {
         if (Math.abs(this.xm - this.bx[var2]) < this.bw[var2] / 2 + 12 && Math.abs(this.ym - this.by[var2]) < 14 && this.mouses == 1) {
            this.pessd[var2] = true;
         } else {
            this.pessd[var2] = false;
         }

         if (Math.abs(this.xm - this.bx[var2]) < this.bw[var2] / 2 + 12 && Math.abs(this.ym - this.by[var2]) < 14 && this.mouses == -1) {
            var1 = var2;
         }
      }

      if (this.mouses == -1) {
         this.mouses = 0;
      }

      if (this.tab == 0) {
         if (this.sfase == 0) {
            if (var1 == 0) {
               this.sfase = 1;
               var1 = -1;
               this.hidefields();
            }

            if (var1 == 1) {
               if (!this.carname.equals("")) {
                  this.srch.setText(this.carname);
                  this.sfase = 2;
                  var1 = -1;
                  this.hidefields();
               } else {
                  JOptionPane.showMessageDialog(null, "Please Select a Car to Rename!\n", "Car Maker", 1);
               }
            }

            if (var1 == 2) {
               this.delcar(this.carname);
            }

            if (var1 == 3) {
               this.sfase = 3;
               var1 = -1;
               this.hidefields();
            }
         }

         if (this.sfase == 1) {
            if (var1 == 0) {
               this.newcar(this.srch.getText());
               var1 = -1;
            }

            if (var1 == 1) {
               this.srch.setText("");
               this.sfase = 0;
               var1 = -1;
               this.hidefields();
            }
         }

         if (this.sfase == 2) {
            if (var1 == 0) {
               this.rencar(this.srch.getText());
               var1 = -1;
            }

            if (var1 == 1) {
               this.srch.setText("");
               this.sfase = 0;
               var1 = -1;
               this.hidefields();
            }
         }

         if (this.sfase == 3) {
            if (var1 == 0) {
               File var27 = null;
               FileDialog var3 = new FileDialog(new Frame(), "Car Maker - Wavefront OBJ Import");
               var3.setFile("*.obj");
               var3.setMode(0);
               var3.setVisible(true);

               try {
                  if (var3.getFile() != null) {
                     var27 = new File("" + var3.getDirectory() + "" + var3.getFile() + "");
                  }
               } catch (Exception var23) {
               }

               if (var27 != null) {
                  this.setCursor(new Cursor(3));
                  byte var4 = 0;
                  if (this.tutok) {
                     var4 = -70;
                  }

                  this.rd.setColor(new Color(225, 225, 225));
                  this.rd.fillRect(116, 246 + var4, 468, 50);
                  this.rd.setColor(new Color(0, 0, 0));
                  this.rd.setFont(new Font("Arial", 1, 13));
                  this.ftm = this.rd.getFontMetrics();
                  this.rd
                     .drawString(
                        "Reading " + var27.getName() + ", please wait...",
                        350 - this.ftm.stringWidth("Reading " + var27.getName() + ", please wait...") / 2,
                        276 + var4
                     );
                  this.repaint();
                  int[] var5 = new int[6000];
                  int[] var6 = new int[6000];
                  int[] var7 = new int[6000];
                  int var8 = 0;
                  int[][] var9 = new int[600][100];
                  int[] var10 = new int[600];
                  int var11 = 0;
                  if (var27.exists()) {
                     try {
                        BufferedReader var12 = new BufferedReader(new FileReader(var27));
                        String var13 = null;
                        boolean var14 = false;
                        boolean var15 = false;

                        while ((var13 = var12.readLine()) != null) {
                           if (var13.startsWith("v ")) {
                              if (var8 < 6000) {
                                 this.multf10 = true;
                                 var5[var8] = this.objvalue((String)var13, 0);
                                 var6[var8] = this.objvalue((String)var13, 1);
                                 var7[var8] = this.objvalue((String)var13, 2);
                                 var8++;
                              } else {
                                 var14 = true;
                              }
                           }

                           if (var13.startsWith("f ")) {
                              if (var11 < 600) {
                                 this.multf10 = false;
                                 this.objfacend = false;

                                 for (var10[var11] = 0; !this.objfacend && var10[var11] < 100; var10[var11]++) {
                                    var9[var11][var10[var11]] = this.objvalue((String)var13, var10[var11]);
                                 }

                                 var11++;
                              } else {
                                 var15 = true;
                              }
                           }
                        }

                        if (var14) {
                           JOptionPane.showMessageDialog(
                              null,
                              "Warning!\nThe number of Vertices in file "
                                 + var27.getName()
                                 + " exceeded the maximum of 6000 that the Car Maker can read!     \n\nPlease choose a simpler model to import.\n \n",
                              "Car Maker",
                              0
                           );
                        }

                        if (var15) {
                           JOptionPane.showMessageDialog(
                              null,
                              "Warning!\nThe number of Faces in file "
                                 + var27.getName()
                                 + " exceeded the maximum of 600 that the Car Maker can read!     \n\nPlease choose a simpler model to import.\n \n",
                              "Car Maker",
                              0
                           );
                        }

                        var12.close();
                        Object var200 = null;
                     } catch (Exception var26) {
                        JOptionPane.showMessageDialog(null, "Unable to load file! Error Deatials:\n" + var26, "Car Maker", 1);
                     }

                     this.rd.setColor(new Color(225, 225, 225));
                     this.rd.fillRect(116, 246 + var4, 468, 50);
                     this.rd.setColor(new Color(0, 0, 0));
                     this.rd.setFont(new Font("Arial", 1, 13));
                     this.ftm = this.rd.getFontMetrics();
                     this.rd
                        .drawString(
                           "Importing " + var27.getName() + ", please wait...",
                           350 - this.ftm.stringWidth("Importing " + var27.getName() + ", please wait...") / 2,
                           276 + var4
                        );
                     this.repaint();
                     this.carname = var27.getName();
                     if (this.carname.endsWith(".obj")) {
                        this.carname = this.carname.substring(0, this.carname.length() - 4);
                     }

                     String var201 = "\n// imported car: "
                        + this.carname
                        + "\n---------------------\n\n// Please read the helpful information about importing cars found at:\n// http://www.needformadness.com/developer/extras.html\n\n\n";

                     for (int var209 = 0; var209 < var11; var209++) {
                        var201 = var201 + "<p>\nc(200,200,220)\n\n";

                        for (int var215 = 0; var215 < var10[var209]; var215++) {
                           if (var9[var209][var215] < 6000) {
                              int var221 = var9[var209][var215];
                              var201 = var201 + "p(" + var5[var221] + "," + -var6[var221] + "," + var7[var221] + ")\n";
                           }
                        }

                        var201 = var201 + "</p>\n\n";
                     }

                     var201 = var201 + "\n\n\n\n";
                     var27 = new File("" + cmfpath + "mycars/");
                     if (!var27.exists()) {
                        var27.mkdirs();
                     }

                     var27 = new File("" + cmfpath + "mycars/" + this.carname + ".rad");
                     int var210 = 0;
                     if (var27.exists()) {
                        var210 = JOptionPane.showConfirmDialog(
                           null, "Another car with the name '" + this.carname + "' already exists, replace it?      \n", "Car Maker", 0
                        );
                     }

                     if (var210 == 0) {
                        try {
                           BufferedWriter var216 = new BufferedWriter(new FileWriter(var27));
                           var216.write(var201);
                           var216.close();
                           Object var217 = null;
                           if (var27.exists()) {
                              this.sfase = 0;
                              this.hidefields();
                              this.tabed = -1;
                           } else {
                              this.carname = "";
                              JOptionPane.showMessageDialog(null, "Failed to create car, unknown reason!\n", "Car Maker", 1);
                           }
                        } catch (Exception var22) {
                           this.carname = "";
                           JOptionPane.showMessageDialog(null, "Unable to create file! Error Deatials:\n" + var22, "Car Maker", 1);
                        }
                     }
                  } else {
                     JOptionPane.showMessageDialog(null, "Error, " + var27.getName() + " was not found!", "Car Maker", 1);
                  }

                  this.setCursor(new Cursor(0));
               }
            }

            if (var1 == 1) {
               this.sfase = 4;
               var1 = -1;
            }

            if (var1 == 2) {
               this.sfase = 0;
               var1 = -1;
            }
         }

         if (this.sfase == 4) {
            if (var1 == 0) {
               File var30 = null;
               FileDialog var38 = new FileDialog(new Frame(), "Car Maker - Wavefront OBJ Import");
               var38.setFile("" + this.carname + ".obj");
               var38.setMode(1);
               var38.setVisible(true);

               try {
                  if (var38.getFile() != null) {
                     var30 = new File("" + var38.getDirectory() + "" + var38.getFile() + "");
                  }
               } catch (Exception var21) {
               }

               if (var30 != null) {
                  int var76 = 0;
                  if (var30.exists()) {
                     var76 = JOptionPane.showConfirmDialog(null, "File " + var30.getName() + " already exists, replace it?      \n", "Car Maker", 0);
                  }

                  if (var76 == 0) {
                     this.setCursor(new Cursor(3));
                     this.setupo();
                     int[] var112 = new int[6000];
                     int[] var142 = new int[6000];
                     int[] var156 = new int[6000];
                     int var171 = 0;
                     String var180 = "";

                     for (int var187 = 0; var187 < this.o.npl; var187++) {
                        for (int var195 = 0; var195 < this.o.p[var187].n; var195++) {
                           boolean var204 = false;

                           for (int var211 = 0; var211 < var171; var211++) {
                              if (var112[var211] == this.o.p[var187].ox[var195]
                                 && var142[var211] == this.o.p[var187].oy[var195]
                                 && var156[var211] == this.o.p[var187].oz[var195]) {
                                 var204 = true;
                              }
                           }

                           if (!var204 && var171 < 6000) {
                              var112[var171] = this.o.p[var187].ox[var195];
                              var142[var171] = this.o.p[var187].oy[var195];
                              var156[var171] = this.o.p[var187].oz[var195];
                              var171++;
                           }
                        }
                     }

                     for (int var188 = 0; var188 < var171; var188++) {
                        var180 = var180 + "v " + var112[var188] / 10.0F + " " + -var142[var188] / 10.0F + " " + var156[var188] / 10.0F + "\n";
                     }

                     for (int var189 = 0; var189 < this.o.npl; var189++) {
                        if (this.o.p[var189].wz == 0) {
                           var180 = var180 + "f";

                           for (int var196 = 0; var196 < this.o.p[var189].n; var196++) {
                              var180 = var180 + " ";

                              for (int var205 = 0; var205 < var171; var205++) {
                                 if (var112[var205] == this.o.p[var189].ox[var196]
                                    && var142[var205] == this.o.p[var189].oy[var196]
                                    && var156[var205] == this.o.p[var189].oz[var196]) {
                                    var180 = var180 + "" + (var205 + 1);
                                 }
                              }
                           }

                           var180 = var180 + "\n";
                        }
                     }

                     try {
                        BufferedWriter var190 = new BufferedWriter(new FileWriter(var30));
                        var190.write(var180);
                        var190.close();
                        Object var191 = null;
                        if (var30.exists()) {
                           JOptionPane.showMessageDialog(
                              null, "Car has been successfully exported to:\n" + var30.getAbsolutePath() + "          \n \n", "Car Maker", 1
                           );
                           this.sfase = 0;
                           this.hidefields();
                           this.tabed = -1;
                        } else {
                           JOptionPane.showMessageDialog(null, "Failed to export car, unknown reason!\n", "Car Maker", 1);
                        }
                     } catch (Exception var20) {
                        JOptionPane.showMessageDialog(null, "Unable to create exported file! Error Deatials:\n" + var20, "Car Maker", 1);
                     }

                     this.setCursor(new Cursor(0));
                  }
               }
            }

            if (var1 == 1) {
               this.sfase = 0;
               var1 = -1;
            }
         }
      }

      if (this.tab == 1) {
         if (var1 == 0) {
            if (this.prefs) {
               this.prefs = false;
            } else {
               this.prefs = true;
            }
         }

         if (var1 == 1 || var1 == 2) {
            this.savefile();
            if (var1 == 2) {
               this.tab = 2;
            }
         }

         if (!this.mirror) {
            boolean var34 = false;
            if (var1 == 4) {
               if (this.sls != -1 && this.sle != -1 && this.editor.getSelectedText().equals(this.srch.getText())) {
                  this.editor.replaceText(this.rplc.getText(), this.sls, this.sle);
                  this.sls = -1;
                  this.sle = -1;
                  var34 = true;

                  try {
                     Thread.sleep(100L);
                  } catch (InterruptedException var19) {
                  }
               }

               var1 = 3;
            }

            if (var1 == 3 && !this.srch.getText().equals("")) {
               this.editor.requestFocus();
               this.sls = this.editor.getText().indexOf(this.srch.getText(), this.editor.getSelectionEnd());
               if (this.sls != -1) {
                  this.sle = this.sls + this.srch.getText().length();
                  this.editor.select(this.sls, this.sle);
               } else if (!var34) {
                  JOptionPane.showMessageDialog(null, "Cannot find  '" + this.srch.getText() + "'  from Cursor position    ", "Car Maker", 1);
               }
            }
         } else {
            if (var1 == 3 || var1 == 4 || var1 == 5) {
               String var31 = "" + this.editor.getSelectedText() + "\n";
               String var39 = "\n\n";
               if (this.cntpls == 1) {
                  var39 = var39 + "// Mirror of the polygon above along the ";
               } else {
                  var39 = var39 + "// Mirror of the " + this.cntpls + " polygons above along the ";
               }

               if (var1 == 3) {
                  var39 = var39 + "X axis:";
               }

               if (var1 == 4) {
                  var39 = var39 + "Y axis:";
               }

               if (var1 == 5) {
                  var39 = var39 + "Z axis:";
               }

               var39 = var39 + "\n\n";
               int var77 = 0;
               int var113 = var31.indexOf("\n", 0);

               while (var113 != -1 && var77 < var31.length()) {
                  String var143 = var31.substring(var77, var113);
                  var143 = var143.trim();
                  var77 = var113 + 1;
                  var113 = var31.indexOf("\n", var77);
                  if (var143.startsWith("fs(-")) {
                     var143 = "fs(" + var143.substring(4, var143.length()) + "";
                  } else if (var143.startsWith("fs(")) {
                     var143 = "fs(-" + var143.substring(3, var143.length()) + "";
                  }

                  if (var1 == 3) {
                     if (var143.startsWith("p(-")) {
                        var143 = "p(" + var143.substring(3, var143.length()) + "";
                     } else if (var143.startsWith("p(")) {
                        var143 = "p(-" + var143.substring(2, var143.length()) + "";
                     }
                  }

                  if (var1 == 4 && var143.startsWith("p(")) {
                     int var157 = var143.indexOf(",", 0);
                     if (var157 >= 0) {
                        if (var143.startsWith(",-", var157)) {
                           var143 = "" + var143.substring(0, var157) + "," + var143.substring(var157 + 2, var143.length()) + "";
                        } else if (var143.startsWith(",", var157)) {
                           var143 = "" + var143.substring(0, var157) + ",-" + var143.substring(var157 + 1, var143.length()) + "";
                        }
                     }
                  }

                  if (var1 == 5 && var143.startsWith("p(")) {
                     int var158 = var143.indexOf(",", 0);
                     var158 = var143.indexOf(",", var158 + 1);
                     if (var158 >= 0) {
                        if (var143.startsWith(",-", var158)) {
                           var143 = "" + var143.substring(0, var158) + "," + var143.substring(var158 + 2, var143.length()) + "";
                        } else if (var143.startsWith(",", var158)) {
                           var143 = "" + var143.substring(0, var158) + ",-" + var143.substring(var158 + 1, var143.length()) + "";
                        }
                     }
                  }

                  var39 = var39 + "" + var143 + "\n";
               }

               var39 = var39 + "\n// End of mirror";
               this.editor.insertText(var39, this.editor.getSelectionEnd());
            }

            if (var1 == 6) {
               this.polynum = 0;
               int var33 = this.editor.getText().lastIndexOf("</p>", this.editor.getSelectionStart());

               for (boolean var43 = false; var33 >= 0; var33--) {
                  if (!var43) {
                     var33 = this.editor.getText().lastIndexOf("<p>", var33);
                     if (var33 != -1) {
                        var43 = true;
                        this.polynum++;
                     }
                  } else {
                     var33 = this.editor.getText().lastIndexOf("</p>", var33);
                     if (var33 != -1) {
                        var43 = false;
                     }
                  }
               }

               this.prflk = 0;
               this.tab = 2;
            }
         }

         var1 = -1;
      }

      if (this.tab == 2) {
         byte var35 = 0;
         if (this.dtab == 1) {
            if (this.o.colok != 2) {
               if (var1 == 0) {
                  JOptionPane.showMessageDialog(
                     null,
                     "Car Maker will attempt now to find the first and second colors automatically.\nPlease make sure that they are the correct colors!\n\nPlease note that these are also the colors that will be editable in the multiplayer game.      ",
                     "Car Maker",
                     1
                  );
                  String var46 = "" + this.editor.getText() + "\n";
                  int var80 = 0;
                  int var114 = var46.indexOf("\n", 0);
                  byte var145 = 0;
                  String var160 = "";
                  String var172 = "";

                  while (var114 != -1 && var80 < var46.length() && var145 != 2) {
                     String var182 = var46.substring(var80, var114);
                     var182 = var182.trim();
                     var80 = var114 + 1;
                     var114 = var46.indexOf("\n", var80);
                     if (var182.startsWith("c(")) {
                        String var192 = var182.substring(1, var182.indexOf(")") + 1);
                        if (var145 == 1 && !var192.equals(var172)) {
                           var160 = var160 + "2ndColor" + var192 + "\n\n\n";
                           var145 = 2;
                        }

                        if (var145 == 0) {
                           var172 = var192;
                           var160 = "1stColor" + var192 + "\n";
                           var145 = 1;
                        }
                     }
                  }

                  if (var145 == 0) {
                     var160 = "1stColor(255,0,0)\n2ndColor(0,0,255)\n\n\n";
                     var145 = 2;
                  }

                  if (var145 == 1) {
                     var160 = var160 + "2ndColor(0,0,255)\n\n\n";
                     var145 = 2;
                  }

                  int var184 = this.editor.getText().indexOf("<p>", 0);
                  this.editor.insertText(var160, var184);
                  this.editor.select(var184, var184 + var160.length() - 2);
                  this.breakbond = true;
                  this.tab = 1;
               }

               var35 = 1;
            } else {
               if (var1 == 0) {
                  this.ofcol = "(" + this.o.fcol[0] + "," + this.o.fcol[1] + "," + this.o.fcol[2] + ")";
                  int var44 = this.editor.getText().indexOf(this.ofcol, 0);

                  int var78;
                  for (var78 = var44; var44 != -1; var44 = this.editor.getText().indexOf(this.ofcol, var44 + 1)) {
                     this.editor.replaceText(this.fcol, var44, var44 + this.ofcol.length());
                  }

                  this.ofcol = this.fcol;
                  this.editor.select(var78 - 8, var78 - 8);
                  this.savefile();
                  this.o.fcol[0] = Color.getHSBColor(this.fhsb[0], this.fhsb[2], this.fhsb[1]).getRed();
                  this.o.fcol[1] = Color.getHSBColor(this.fhsb[0], this.fhsb[2], this.fhsb[1]).getGreen();
                  this.o.fcol[2] = Color.getHSBColor(this.fhsb[0], this.fhsb[2], this.fhsb[1]).getBlue();
               }

               if (var1 == 1) {
                  this.oscol = "(" + this.o.scol[0] + "," + this.o.scol[1] + "," + this.o.scol[2] + ")";
                  int var45 = this.editor.getText().indexOf(this.oscol, 0);

                  int var79;
                  for (var79 = var45; var45 != -1; var45 = this.editor.getText().indexOf(this.oscol, var45 + 1)) {
                     this.editor.replaceText(this.scol, var45, var45 + this.oscol.length());
                  }

                  this.oscol = this.scol;
                  this.editor.select(var79 - 8, var79 - 8);
                  this.savefile();
                  this.o.scol[0] = Color.getHSBColor(this.shsb[0], this.shsb[2], this.shsb[1]).getRed();
                  this.o.scol[1] = Color.getHSBColor(this.shsb[0], this.shsb[2], this.shsb[1]).getGreen();
                  this.o.scol[2] = Color.getHSBColor(this.shsb[0], this.shsb[2], this.shsb[1]).getBlue();
               }

               var35 = 2;
            }
         }

         if (this.dtab == 2) {
            if (var1 == 9) {
               this.scale[0] = 100;
               this.scale[1] = 100;
               this.scale[2] = 100;
            }

            if (var1 == 0 || var1 == 1 || var1 == 6 || var1 == 7 || var1 == 9) {
               if (var1 == 0 || var1 == 6) {
                  this.scale[0] = this.scale[0] - 5;
               }

               if (var1 == 1 || var1 == 7) {
                  this.scale[0] = this.scale[0] + 5;
               }

               if (this.scale[0] < 0) {
                  this.scale[0] = 0;
               }

               int var47 = this.editor.getText().indexOf("\nScaleX(", 0);
               if (var47 != -1) {
                  int var81 = this.editor.getText().indexOf(")", ++var47);
                  int var115 = this.editor.getText().indexOf("\n", var47);
                  if (var115 > var81) {
                     this.editor.replaceText("ScaleX(" + this.scale[0] + ")", var47, var81 + 1);
                  } else {
                     this.editor.replaceText("ScaleX(" + this.scale[0] + ")", var47, var115);
                  }
               } else {
                  int var82 = this.editor.getText().indexOf("<p>", 0);
                  int var116 = this.editor.getText().indexOf("\nScale", 0);
                  if (var116 < var82 && var116 != -1) {
                     this.editor.insertText("\nScaleX(" + this.scale[0] + ")", var116);
                  } else {
                     this.editor.insertText("ScaleX(" + this.scale[0] + ")\n\n\n", var82);
                  }
               }
            }

            if (var1 == 2 || var1 == 3 || var1 == 6 || var1 == 7 || var1 == 9) {
               if (var1 == 2 || var1 == 6) {
                  this.scale[1] = this.scale[1] - 5;
               }

               if (var1 == 3 || var1 == 7) {
                  this.scale[1] = this.scale[1] + 5;
               }

               if (this.scale[1] < 0) {
                  this.scale[1] = 0;
               }

               int var49 = this.editor.getText().indexOf("\nScaleY(", 0);
               if (var49 != -1) {
                  int var83 = this.editor.getText().indexOf(")", ++var49);
                  int var117 = this.editor.getText().indexOf("\n", var49);
                  if (var117 > var83) {
                     this.editor.replaceText("ScaleY(" + this.scale[1] + ")", var49, var83 + 1);
                  } else {
                     this.editor.replaceText("ScaleY(" + this.scale[1] + ")", var49, var117);
                  }
               } else {
                  int var84 = this.editor.getText().indexOf("<p>", 0);
                  int var118 = this.editor.getText().indexOf("\nScale", 0);
                  if (var118 < var84 && var118 != -1) {
                     this.editor.insertText("\nScaleY(" + this.scale[1] + ")", var118);
                  } else {
                     this.editor.insertText("ScaleY(" + this.scale[1] + ")\n\n\n", var84);
                  }
               }
            }

            if (var1 == 4 || var1 == 5 || var1 == 6 || var1 == 7 || var1 == 9) {
               if (var1 == 4 || var1 == 6) {
                  this.scale[2] = this.scale[2] - 5;
               }

               if (var1 == 5 || var1 == 7) {
                  this.scale[2] = this.scale[2] + 5;
               }

               if (this.scale[2] < 0) {
                  this.scale[2] = 0;
               }

               int var51 = this.editor.getText().indexOf("\nScaleZ(", 0);
               if (var51 != -1) {
                  int var85 = this.editor.getText().indexOf(")", ++var51);
                  int var119 = this.editor.getText().indexOf("\n", var51);
                  if (var119 > var85) {
                     this.editor.replaceText("ScaleZ(" + this.scale[2] + ")", var51, var85 + 1);
                  } else {
                     this.editor.replaceText("ScaleZ(" + this.scale[2] + ")", var51, var119);
                  }
               } else {
                  int var86 = this.editor.getText().indexOf("<p>", 0);
                  int var120 = this.editor.getText().indexOf("\nScale", 0);
                  if (var120 < var86 && var120 != -1) {
                     this.editor.insertText("\nScaleZ(" + this.scale[2] + ")", var120);
                  } else {
                     this.editor.insertText("ScaleZ(" + this.scale[2] + ")\n\n\n", var86);
                  }
               }
            }

            if (var1 == 0 || var1 == 1 || var1 == 2 || var1 == 3 || var1 == 4 || var1 == 5 || var1 == 6 || var1 == 7 || var1 == 9) {
               this.setupo();
            }

            if (var1 == 8) {
               this.savefile();
               this.oscale[0] = this.scale[0];
               this.oscale[1] = this.scale[1];
               this.oscale[2] = this.scale[2];
            }

            if (var1 == 10 || var1 == 11 || var1 == 12 || var1 == 13 || var1 == 14 || var1 == 15 || var1 == 16 || var1 == 17 || var1 == 18) {
               try {
                  String var53 = "" + this.editor.getText() + "\n";
                  String var87 = "";
                  int var121 = 0;
                  int var147 = var53.indexOf("\n", 0);

                  while (var147 != -1 && var121 < var53.length()) {
                     String var161 = var53.substring(var121, var147);
                     var161 = var161.trim();
                     var121 = var147 + 1;
                     var147 = var53.indexOf("\n", var121);
                     if (var161.startsWith("p(")) {
                        int var173 = var161.indexOf(",", 0);
                        int var185 = var161.indexOf(",", var173 + 1);
                        int var193 = var161.indexOf(")", var185 + 1);
                        if (var173 != -1 && var185 != -1 && var193 != -1) {
                           int var197 = Float.valueOf(var161.substring(2, var173)).intValue();
                           int var206 = Float.valueOf(var161.substring(var173 + 1, var185)).intValue();
                           int var212 = Float.valueOf(var161.substring(var185 + 1, var193)).intValue();
                           if (var1 == 10) {
                              int var218 = var206;
                              var206 = var212;
                              var212 = -var218;
                           }

                           if (var1 == 11) {
                              var197 += 10;
                           }

                           if (var1 == 12) {
                              var197 -= 10;
                           }

                           if (var1 == 13) {
                              int var219 = var197;
                              var197 = -var212;
                              var212 = var219;
                           }

                           if (var1 == 14) {
                              var206 += 10;
                           }

                           if (var1 == 15) {
                              var206 -= 10;
                           }

                           if (var1 == 16) {
                              int var220 = var206;
                              var206 = -var197;
                              var197 = var220;
                           }

                           if (var1 == 17) {
                              var212 += 10;
                           }

                           if (var1 == 18) {
                              var212 -= 10;
                           }

                           var87 = var87 + "p(" + var197 + "," + var206 + "," + var212 + ")" + var161.substring(var193 + 1, var161.length()) + "\n";
                        } else {
                           var87 = var87 + "" + var161 + "\n";
                        }
                     } else {
                        var87 = var87 + "" + var161 + "\n";
                     }
                  }

                  this.editor.setText(var87);
                  this.setupo();
                  this.changed2 = true;
               } catch (Exception var25) {
               }
            }

            if (var1 == 19) {
               this.editor.setText(this.lastedo);
               this.setupo();
               this.changed2 = false;
            }

            if (var1 == 20 && this.changed2) {
               int var54 = JOptionPane.showConfirmDialog(
                  null, "Saving now will permanently change the point locations & numbers entered in the code!      \n\nContinue?", "Car Maker", 0
               );
               if (var54 == 0) {
                  this.editor.setText(this.editor.getText().trim() + "\n\n\n\n");
                  this.savefile();
                  this.changed2 = false;
               }
            }

            var35 = 21;
         }

         if (this.dtab == 3) {
            if (var1 == 0 || var1 == 2 || this.defnow) {
               if (this.defnow) {
                  this.defnow = false;
                  this.repaint();
                  JOptionPane.showMessageDialog(
                     null,
                     "Car Maker will setup default Front and Back Wheels positions and adjustments.\n\nEnter the desired positions and adjustments then press ' Apply ' to view!\nDon't forget to press ' Save ' when finished!",
                     "Car Maker",
                     1
                  );
               }

               byte var55 = 0;

               try {
                  int var88 = Float.valueOf(this.wv[10].getText()).intValue();
                  if (var88 <= 0) {
                     var55 = 1;
                  }

                  var88 = Float.valueOf(this.wv[2].getText()).intValue();
                  if (var88 >= 0) {
                     var55 = 2;
                  }

                  var88 = Float.valueOf(this.wv[8].getText()).intValue();
                  if (var88 <= 0) {
                     var55 = 3;
                  }

                  var88 = Float.valueOf(this.wv[0].getText()).intValue();
                  if (var88 <= 0) {
                     var55 = 4;
                  }

                  var88 = Float.valueOf(this.wv[15].getText()).intValue();
                  if (var88 > 40) {
                     this.wv[15].setText("40");
                  }

                  if (var88 < -40) {
                     this.wv[15].setText("-40");
                  }

                  var88 = Float.valueOf(this.wv[7].getText()).intValue();
                  if (var88 > 40) {
                     this.wv[7].setText("40");
                  }

                  if (var88 < -40) {
                     this.wv[7].setText("-40");
                  }
               } catch (Exception var18) {
               }

               if (var55 == 1) {
                  JOptionPane.showMessageDialog(
                     null,
                     "ERROR:\nThe Z location value of the FRONT Wheels must be greater then zero! (it should have a +ve value)\nZ :  '"
                        + this.wv[10].getText()
                        + "'  is less or equal to zero, where it should have +ve value!",
                     "Car Maker",
                     1
                  );
               }

               if (var55 == 2) {
                  JOptionPane.showMessageDialog(
                     null,
                     "ERROR:\nThe Z location value of the BACK Wheels must be smaller then zero! (it should have a -ve value)\nZ :  '"
                        + this.wv[2].getText()
                        + "'  is bigger or equal to zero, where it should have -ve value!",
                     "Car Maker",
                     1
                  );
               }

               if (var55 == 3) {
                  JOptionPane.showMessageDialog(
                     null,
                     "ERROR:\nThe ±X location value of the FRONT or BACK Wheels must be greater then zero! (it should have a +ve value)\n±X :  '"
                        + this.wv[8].getText()
                        + "'  is less or equal to zero, where it should have +ve value!",
                     "Car Maker",
                     1
                  );
               }

               if (var55 == 4) {
                  JOptionPane.showMessageDialog(
                     null,
                     "ERROR:\nThe ±X location value of the FRONT or BACK Wheels must be greater then zero! (it should have a +ve value)\n±X :  '"
                        + this.wv[0].getText()
                        + "'  is less or equal to zero, whenr it should have +ve value!",
                     "Car Maker",
                     1
                  );
               }

               if (var55 == 0) {
                  String var94 = "" + this.editor.getText() + "\n";
                  String var122 = "";
                  int var148 = 0;
                  int var163 = var94.indexOf("\n", 0);

                  while (var163 != -1 && var148 < var94.length()) {
                     String var174 = var94.substring(var148, var163);
                     var174 = var174.trim();
                     var148 = var163 + 1;
                     var163 = var94.indexOf("\n", var148);
                     if (!var174.startsWith("rims(") && !var174.startsWith("gwgr(") && !var174.startsWith("w(")) {
                        var122 = var122 + "" + var174 + "\n";
                     } else {
                        var122 = var122.trim();
                        var122 = var122 + "\n";
                     }
                  }

                  var122 = var122.trim();
                  var122 = var122 + "\n\n\ngwgr(" + this.wv[15].getText() + ")\n";
                  String var176 = "140,140,140";
                  if (this.rplc.getText().startsWith("(") && this.rplc.getText().endsWith(")")) {
                     var176 = this.rplc.getText().substring(1, this.rplc.getText().length() - 1);
                  }

                  var122 = var122 + "rims(" + var176 + "," + this.wv[13].getText() + "," + this.wv[14].getText() + ")\n";
                  var122 = var122
                     + "w(-"
                     + this.wv[8].getText()
                     + ","
                     + this.wv[9].getText()
                     + ","
                     + this.wv[10].getText()
                     + ",11,"
                     + this.wv[12].getText()
                     + ","
                     + this.wv[11].getText()
                     + ")\n";
                  var122 = var122
                     + "w("
                     + this.wv[8].getText()
                     + ","
                     + this.wv[9].getText()
                     + ","
                     + this.wv[10].getText()
                     + ",11,-"
                     + this.wv[12].getText()
                     + ","
                     + this.wv[11].getText()
                     + ")\n";
                  var122 = var122 + "\ngwgr(" + this.wv[7].getText() + ")\n";
                  var176 = "140,140,140";
                  if (this.srch.getText().startsWith("(") && this.srch.getText().endsWith(")")) {
                     var176 = this.srch.getText().substring(1, this.srch.getText().length() - 1);
                  }

                  var122 = var122 + "rims(" + var176 + "," + this.wv[5].getText() + "," + this.wv[6].getText() + ")\n";
                  var122 = var122
                     + "w(-"
                     + this.wv[0].getText()
                     + ","
                     + this.wv[1].getText()
                     + ","
                     + this.wv[2].getText()
                     + ",0,"
                     + this.wv[4].getText()
                     + ","
                     + this.wv[3].getText()
                     + ")\n";
                  var122 = var122
                     + "w("
                     + this.wv[0].getText()
                     + ","
                     + this.wv[1].getText()
                     + ","
                     + this.wv[2].getText()
                     + ",0,-"
                     + this.wv[4].getText()
                     + ","
                     + this.wv[3].getText()
                     + ")\n\n\n\n";
                  this.editor.setText(var122);
                  this.forwheels = true;
                  this.setupo();
                  this.forwheels = false;
                  this.aply1 = ""
                     + this.wv[0].getText()
                     + ""
                     + this.wv[1].getText()
                     + ""
                     + this.wv[2].getText()
                     + ""
                     + this.wv[3].getText()
                     + ""
                     + this.wv[4].getText()
                     + ""
                     + this.srch.getText()
                     + ""
                     + this.wv[5].getText()
                     + ""
                     + this.wv[6].getText()
                     + ""
                     + this.wv[7].getText()
                     + "";
                  this.aply2 = ""
                     + this.wv[8].getText()
                     + ""
                     + this.wv[9].getText()
                     + ""
                     + this.wv[10].getText()
                     + ""
                     + this.wv[11].getText()
                     + ""
                     + this.wv[12].getText()
                     + ""
                     + this.rplc.getText()
                     + ""
                     + this.wv[13].getText()
                     + ""
                     + this.wv[14].getText()
                     + ""
                     + this.wv[15].getText()
                     + "";
                  this.aplyd1 = false;
                  this.aplyd2 = false;
                  this.changed2 = true;
               }
            }

            if (var1 == 1 || var1 == 3) {
               if (!this.o.errd) {
                  this.savefile();
                  this.changed2 = false;
               } else {
                  JOptionPane.showMessageDialog(null, "Unable to Save, press  [ Apply ]  to find out why!", "Car Maker", 1);
               }
            }

            var35 = 4;
         }

         if (this.dtab == 4) {
            if (!this.statdef) {
               if (var1 == 0) {
                  this.carsel = this.simcar.getSelectedIndex();
                  int var60 = 0;

                  for (int var101 = 0; var101 < 5; var101++) {
                     this.stat[var101] = this.carstat[this.carsel][var101];
                     this.rstat[var101] = this.stat[var101];
                     var60 += this.stat[var101];
                  }

                  this.clsel = 4 - (var60 - 520) / 40;
                  this.cls.select(this.clsel);
                  if (this.simcar.getItemCount() == 16) {
                     this.simcar.add(this.rd, "   ");
                  }

                  this.statdef = true;
                  this.changed2 = true;
               }

               var35 = 1;
            } else {
               for (int var56 = 0; var56 < 5; var56++) {
                  int var95 = 0;
                  if (var1 == 1 + var56 * 2 && this.stat[var56] < 200) {
                     var95 = 200 - this.stat[var56];
                     if (var95 > 4) {
                        var95 = 4;
                     }
                  }

                  if (var1 == var56 * 2 && this.stat[var56] > 16) {
                     var95 = 16 - this.stat[var56];
                     if (var95 < -4) {
                        var95 = -4;
                     }
                  }

                  int var133 = 0;

                  while (var95 != 0 && var133 != 5) {
                     var133 = 0;

                     for (int var149 = 0; var149 < 5; var149++) {
                        if (var56 == var149 || this.stat[var149] > 200 && var95 <= 0 || this.stat[var149] < 16 && var95 >= 0 || var95 == 0) {
                           var133++;
                        } else if (var95 > 0) {
                           this.stat[var56]++;
                           this.stat[var149]--;
                           var95--;
                        } else {
                           this.stat[var56]--;
                           this.stat[var149]++;
                           var95++;
                        }
                     }
                  }
               }

               if (var1 == 10) {
                  this.carsel = this.simcar.getSelectedIndex();
                  int var57 = 0;

                  for (int var96 = 0; var96 < 5; var96++) {
                     this.stat[var96] = this.carstat[this.carsel][var96];
                     var57 += this.stat[var96];
                  }

                  this.clsel = 4 - (var57 - 520) / 40;
                  this.cls.select(this.clsel);
               }

               if (var1 == 11) {
                  String var58 = "" + this.editor.getText() + "\n";
                  String var97 = "";
                  int var134 = 0;
                  int var150 = var58.indexOf("\n", 0);

                  while (var150 != -1 && var134 < var58.length()) {
                     String var164 = var58.substring(var134, var150);
                     var164 = var164.trim();
                     var134 = var150 + 1;
                     var150 = var58.indexOf("\n", var134);
                     if (!var164.startsWith("stat(")) {
                        var97 = var97 + "" + var164 + "\n";
                     } else {
                        var97 = var97.trim();
                        var97 = var97 + "\n";
                     }
                  }

                  var97 = var97.trim();
                  var97 = var97
                     + "\n\n\nstat("
                     + this.stat[0]
                     + ","
                     + this.stat[1]
                     + ","
                     + this.stat[2]
                     + ","
                     + this.stat[3]
                     + ","
                     + this.stat[4]
                     + ")\n\n\n\n";
                  this.editor.setText(var97);
                  this.savefile();

                  for (int var166 = 0; var166 < 5; var166++) {
                     this.rstat[var166] = this.stat[var166];
                  }

                  this.changed2 = false;
               }

               if (var1 == 12) {
                  for (int var59 = 0; var59 < 5; var59++) {
                     this.stat[var59] = this.rstat[var59];
                  }
               }

               var35 = 13;
            }
         }

         if (this.dtab == 5) {
            if (this.pfase == 0) {
               for (int var61 = 0; var61 < 4; var61++) {
                  if (var1 == 1 + var61 * 2) {
                     this.phys[var61] = this.phys[var61] + 2;
                     if (this.phys[var61] > 100) {
                        this.phys[var61] = 100;
                     }
                  }

                  if (var1 == var61 * 2) {
                     this.phys[var61] = this.phys[var61] - 2;
                     if (this.phys[var61] < 0) {
                        this.phys[var61] = 0;
                     }
                  }
               }

               if (var1 == 8) {
                  for (int var62 = 0; var62 < 5; var62++) {
                     this.phys[var62] = (int)(Math.random() * 100.0);
                  }
               }

               if (var1 == 9) {
                  for (int var63 = 0; var63 < 5; var63++) {
                     this.phys[var63] = this.rphys[var63];
                  }
               }

               if (var1 == 10) {
                  this.pfase = 1;
                  var1 = -1;
               }

               var35 = 11;
            }

            if (this.pfase == 1) {
               for (int var64 = 0; var64 < 6; var64++) {
                  if (var1 == 1 + var64 * 2) {
                     this.phys[var64 + 5] = this.phys[var64 + 5] + 2;
                     if (this.phys[var64 + 5] > 100) {
                        this.phys[var64 + 5] = 100;
                     }
                  }

                  if (var1 == var64 * 2) {
                     this.phys[var64 + 5] = this.phys[var64 + 5] - 2;
                     if (this.phys[var64 + 5] < 0) {
                        this.phys[var64 + 5] = 0;
                     }
                  }
               }

               if (var1 == 12) {
                  for (int var65 = 0; var65 < 6; var65++) {
                     this.phys[var65 + 5] = (int)(Math.random() * 100.0);
                  }
               }

               if (var1 == 13) {
                  for (int var66 = 0; var66 < 6; var66++) {
                     this.phys[var66 + 5] = this.rphys[var66 + 5];
                  }
               }

               if (var1 == 14) {
                  this.pfase = 0;
                  var1 = -1;
               }

               if (var1 == 15) {
                  this.pfase = 2;
                  var1 = -1;
               }

               var35 = 16;
            }

            if (this.pfase == 2) {
               for (int var67 = 0; var67 < 3; var67++) {
                  if (var1 == 1 + var67 * 2) {
                     this.crash[var67] = this.crash[var67] + 2;
                     if (this.crash[var67] > 100) {
                        this.crash[var67] = 100;
                     }
                  }

                  if (var1 == var67 * 2) {
                     this.crash[var67] = this.crash[var67] - 2;
                     if (this.crash[var67] < 0) {
                        this.crash[var67] = 0;
                     }
                  }
               }

               if (var1 == 6) {
                  int var68 = (int)(150.0 + 600.0 * Math.random());
                  boolean var102 = false;
                  boolean var135 = false;
                  if (Math.random() > Math.random()) {
                     var102 = true;
                  }

                  if (Math.random() > Math.random()) {
                     var135 = true;
                  }

                  int[] var151 = new int[]{-101, -101, -101, -101};
                  var151[0] = (int)(Math.random() * 4.0);
                  if (Math.random() > Math.random()) {
                     if (var135) {
                        var151[1] = var151[0] + 1;
                     } else {
                        var151[1] = var151[0] - 1;
                     }

                     if (Math.random() > Math.random()) {
                        if (var135) {
                           var151[2] = var151[1] + 1;
                        } else {
                           var151[2] = var151[1] - 1;
                        }

                        if (Math.random() > Math.random()) {
                           if (var135) {
                              var151[3] = var151[2] + 1;
                           } else {
                              var151[3] = var151[2] - 1;
                           }
                        }
                     }
                  }

                  if (Math.random() > Math.random()) {
                     this.crashup = false;
                  } else {
                     this.crashup = true;
                  }

                  for (int var167 = 0; var167 < 4; var167++) {
                     if (var151[var167] != -101) {
                        if (var151[var167] >= 4) {
                           var151[var167] -= 4;
                        }

                        if (var151[var167] <= -1) {
                           var151[var167] += 4;
                        }

                        var68 -= 50 * var167;
                        if (var68 < 150) {
                           var68 = 150;
                        }

                        if (var102) {
                           this.regx(var151[var167], var68, false);
                        } else {
                           this.regz(var151[var167], var68, false);
                        }
                     }
                  }

                  if (this.hitmag < 17000) {
                     if (this.crashleft) {
                        this.o.xz += 22;
                     } else {
                        this.o.xz -= 22;
                     }
                  }
               }

               if (var1 == 8) {
                  if (Math.random() > Math.random()) {
                     this.crashup = false;
                  } else {
                     this.crashup = true;
                  }

                  this.roofsqsh((int)(230.0 + Math.random() * 80.0));
               }

               if (var1 == 9 || var1 == 7) {
                  this.setupo();
                  if (Math.random() > Math.random()) {
                     this.crashleft = false;
                  } else {
                     this.crashleft = true;
                  }
               }

               if (var1 == 10) {
                  for (int var69 = 0; var69 < 3; var69++) {
                     this.crash[var69] = this.rcrash[var69];
                  }
               }

               if (var1 == 11) {
                  this.setupo();
                  this.pfase = 1;
                  var1 = -1;
               }

               if (var1 == 12) {
                  if (this.crashok) {
                     this.setupo();
                     this.pfase = 3;
                     var1 = -1;
                  } else {
                     JOptionPane.showMessageDialog(null, this.usage[11], "Car Maker", 1);
                  }
               }

               var35 = 13;
            }

            if (this.pfase == 3) {
               for (int var70 = 0; var70 < 5; var70++) {
                  if (var1 == var70) {
                     for (int var103 = 0; var103 < 5; var103++) {
                        for (int var136 = 0; var136 < 5; var136++) {
                           this.engs[var136][var103].stop();
                        }
                     }

                     this.engs[this.engsel][var70].loop();
                     this.engon = true;
                  }

                  if (var1 == 5) {
                     for (int var104 = 0; var104 < 5; var104++) {
                        for (int var137 = 0; var137 < 5; var137++) {
                           this.engs[var137][var104].stop();
                        }
                     }

                     this.engon = false;
                  }

                  if (var1 == 6) {
                     this.pfase = 2;
                     var1 = -1;
                     this.engine.hide();
                  }

                  if (var1 == 7) {
                     this.pfase = 4;
                     var1 = -1;
                     this.engine.hide();
                  }
               }

               var35 = 8;
            }
         }

         if (this.dtab == 6) {
            if (!this.rateh) {
               if (var1 == 0 && this.checko("Test Drive")) {
                  Madness.testcar = this.carname;
                  Madness.testdrive = this.witho.getSelectedIndex() + 1;
                  Madness.game();
               }

               var35 = 1;
               if (this.tested) {
                  if (var1 == 1) {
                     this.dtab = 4;
                     var1 = -1;
                  }

                  if (var1 == 2) {
                     this.dtab = 5;
                     var1 = -1;
                  }

                  if (var1 == 3) {
                     this.rateh = true;
                     this.hidefields();
                  }

                  var35 = 4;
               }
            } else {
               if (var1 == 0) {
                  this.handling -= 2;
                  if (this.handling < 50) {
                     this.handling = 50;
                  }
               }

               if (var1 == 1) {
                  this.handling += 2;
                  if (this.handling > 200) {
                     this.handling = 200;
                  }
               }

               if (var1 == 2) {
                  String var71 = "" + this.editor.getText() + "\n";
                  String var105 = "";
                  int var138 = 0;
                  int var152 = var71.indexOf("\n", 0);

                  while (var152 != -1 && var138 < var71.length()) {
                     String var168 = var71.substring(var138, var152);
                     var168 = var168.trim();
                     var138 = var152 + 1;
                     var152 = var71.indexOf("\n", var138);
                     if (!var168.startsWith("handling(")) {
                        var105 = var105 + "" + var168 + "\n";
                     } else {
                        var105 = var105.trim();
                        var105 = var105 + "\n";
                     }
                  }

                  var105 = var105.trim();
                  var105 = var105 + "\n\n\nhandling(" + this.handling + ")\n\n\n\n";
                  this.editor.setText(var105);
                  this.savefile();
                  this.rateh = false;
               }

               if (var1 == 3) {
                  this.rateh = false;
               }

               var35 = 4;
            }
         }

         if (var1 == var35) {
            for (int var72 = 0; var72 < this.o.npl; var72++) {
               Color.RGBtoHSB(this.o.p[var72].c[0], this.o.p[var72].c[1], this.o.p[var72].c[2], this.o.p[var72].hsb);
               if (this.o.p[var72].gr == -13) {
                  this.o.p[var72].gr = 1;
               }
            }

            this.polynum = -1;
         }

         var1 = -1;
      }

      if (this.tab == 3) {
         if (var1 == 0) {
            if (this.logged == 0) {
               JOptionPane.showMessageDialog(null, "Please login to retrieve your account first before publishing!", "Car Maker", 1);
            }

            if ((this.logged == 3 || this.logged == -1) && this.checko("Publishing")) {
               int var36 = 0;

               for (int var73 = 0; var73 < this.pubitem.no; var73++) {
                  if (this.pubitem.opts[var73].equals(this.carname)) {
                     var36 = JOptionPane.showConfirmDialog(null, "Replace your already online car '" + this.carname + "' with this one?", "Car Maker", 0);
                  }
               }

               if (var36 == 0) {
                  this.setCursor(new Cursor(3));
                  this.rd.setFont(new Font("Arial", 1, 13));
                  this.ftm = this.rd.getFontMetrics();
                  this.rd.setColor(new Color(225, 225, 225));
                  this.rd.fillRect(11, 141, 679, 401);
                  this.rd.setColor(new Color(0, 0, 0));
                  this.rd.drawString("Connecting to Server...", 350 - this.ftm.stringWidth("Connecting to Server...") / 2, 250);
                  this.repaint();
                  int var74 = 0;
                  String var109 = "" + this.editor.getText() + "\n";
                  int var139 = 0;

                  for (int var153 = var109.indexOf("\n", 0); var153 != -1 && var139 < var109.length(); var74++) {
                     var139 = var153 + 1;
                     var153 = var109.indexOf("\n", var139);
                  }

                  this.justpubd = this.carname;
                  int var170 = -1;

                  try {
                     Socket var178 = new Socket("69.195.146.194", 7061);
                     BufferedReader var186 = new BufferedReader(new InputStreamReader(var178.getInputStream()));
                     PrintWriter var194 = new PrintWriter(var178.getOutputStream(), true);
                     var194.println("10|" + this.tnick.getText() + "|" + this.tpass.getText() + "|" + this.carname + "|" + this.pubtyp.getSelectedIndex() + "|");
                     String var198 = var186.readLine();
                     if (var198 != null) {
                        var170 = this.servervalue(var198, 0);
                     }

                     if (var170 == 0) {
                        int var207 = 0;
                        var109 = "" + this.editor.getText() + "\n";
                        var139 = 0;
                        int var154 = var109.indexOf("\n", 0);

                        while (var154 != -1 && var139 < var109.length()) {
                           String var213 = var109.substring(var139, var154);
                           var213 = var213.trim();
                           var194.println(var213);
                           var139 = var154 + 1;
                           var154 = var109.indexOf("\n", var139);
                           var207++;
                           this.rd.setColor(new Color(225, 225, 225));
                           this.rd.fillRect(11, 141, 679, 401);
                           this.rd.setColor(new Color(0, 0, 0));
                           this.rd.drawString("Publishing Car...", 350 - this.ftm.stringWidth("Publishing Car...") / 2, 250);
                           this.rd.setColor(new Color(119, 147, 191));
                           this.rd.fillRect(250, 270, (int)((float)var207 / var74 * 200.0F), 7);
                           this.rd.setColor(new Color(0, 0, 0));
                           this.rd.drawRect(250, 270, 200, 7);
                           this.repaint();

                           try {
                              Thread.sleep(10L);
                           } catch (InterruptedException var17) {
                           }
                        }

                        var194.println("QUITX1111");
                        this.rd.setColor(new Color(225, 225, 225));
                        this.rd.fillRect(11, 141, 679, 401);
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawString("Creating the car online...", 350 - this.ftm.stringWidth("Creating the car online...") / 2, 250);
                        this.rd
                           .drawString(
                              "This may take a couple of minutes, please wait...",
                              350 - this.ftm.stringWidth("This may take a couple of minutes, please wait...") / 2,
                              280
                           );
                        this.repaint();
                        var198 = var186.readLine();
                        if (var198 != null) {
                           var170 = this.servervalue(var198, 0);
                        }
                     }

                     var178.close();
                  } catch (Exception var24) {
                     var170 = -1;
                  }

                  this.setCursor(new Cursor(0));
                  boolean var179 = false;
                  if (var170 == 0) {
                     this.logged = 1;
                     var179 = true;
                  }

                  if (var170 == 3) {
                     JOptionPane.showMessageDialog(
                        null,
                        "Unable to publish car.\nReason:\nCar name is too large.  Please rename your car.  Car name must be less then 15 characters.",
                        "Car Maker",
                        1
                     );
                     var179 = true;
                  }

                  if (var170 == 4) {
                     JOptionPane.showMessageDialog(
                        null,
                        "Unable to publish car.\nReason:  Car name used ("
                           + this.carname
                           + ").\nThe name '"
                           + this.carname
                           + "' is already used by another published car.  Please rename your car.",
                        "Car Maker",
                        1
                     );
                     var179 = true;
                  }

                  if (var170 == 6) {
                     JOptionPane.showMessageDialog(null, "Error Creating Car!\nReason:\nError loading 3D model!  Format maybe incorrect!", "Car Maker", 1);
                     var179 = true;
                  }

                  if (var170 == 7) {
                     JOptionPane.showMessageDialog(
                        null,
                        "Error Creating Car!\nReason:\nFirst and Second colors not defined yet!\nPlease go to the 'Color Edit' tab to define the colors.",
                        "Car Maker",
                        1
                     );
                     var179 = true;
                  }

                  if (var170 == 8) {
                     JOptionPane.showMessageDialog(
                        null,
                        "Error Creating Car!\nReason:\nCar Wheels not defined or not defined correctly!\nPlease go to the ‘Wheels’ tab and use  [ Apply ]  and  [ Save ]  to define correctly.",
                        "Car Maker",
                        1
                     );
                     var179 = true;
                  }

                  if (var170 == 9) {
                     JOptionPane.showMessageDialog(
                        null,
                        "Error Creating Car!\nReason:\nNo car seems to be designed!\nYou have not built a car yet please go to the ‘Car’ tab to find the tutorial on how to build a car.",
                        "Car Maker",
                        1
                     );
                     var179 = true;
                  }

                  if (var170 == 10) {
                     JOptionPane.showMessageDialog(
                        null,
                        "Error Creating Car!\nReason:\nCar contains too many polygons (pieces).\nNumber of polygons used need to be less then 210.\nPlease use the counter in the ‘Code Edit’ to decrease the number of polygons (pieces).",
                        "Car Maker",
                        1
                     );
                     var179 = true;
                  }

                  if (var170 == 11) {
                     JOptionPane.showMessageDialog(
                        null,
                        "Error Creating Car!\nReason:\nCar scale size is too large!\nPlease use the ‘Scale All’ option in the ‘Scale & Align’ tab to resize your car to suitable size.       \nCompare it to other NFM cars using the ‘Compare Car...’ option.\nCurrently you car needs to be scaled down by "
                           + (int)((this.o.maxR / 400.0F - 1.0F) * 100.0F)
                           + "%.\n",
                        "Car Maker",
                        1
                     );
                     var179 = true;
                  }

                  if (var170 == 12) {
                     JOptionPane.showMessageDialog(
                        null,
                        "Error Creating Car!\nReason:\nCar scale size is too small!\nPlease use the ‘Scale All’ option in the ‘Scale & Align’ tab to resize your car to suitable size.       \nCompare it to other NFM cars using the ‘Compare Car...’ option.\nCurrently you car needs to be scaled up by "
                           + (int)((120.0F / this.o.maxR - 1.0F) * 100.0F)
                           + "%.\n",
                        "Car Maker",
                        1
                     );
                     var179 = true;
                  }

                  if (var170 == 13) {
                     JOptionPane.showMessageDialog(
                        null,
                        "Error Creating Car!\nReason:\nCar Stats & Class not defined correctly!\nPlease go to the 'Stats & Class' tab to define stats and don't forget to press  [ Save ]  when finished.\n",
                        "Car Maker",
                        1
                     );
                     var179 = true;
                  }

                  if (var170 == 14) {
                     JOptionPane.showMessageDialog(
                        null,
                        "Error Creating Car!\nReason:\nCar Physics not defined correctly!\nPlease go to the 'Physics' tab and complete the car physics definition until it is saved.\n",
                        "Car Maker",
                        1
                     );
                     var179 = true;
                  }

                  if (var170 == 15) {
                     JOptionPane.showMessageDialog(
                        null,
                        "Error Creating Car!\nReason:\nCar Handling not rated.\nPlease Test Drive your car to rate its handling before publishing!\n",
                        "Car Maker",
                        1
                     );
                     var179 = true;
                  }

                  if (var170 > 15) {
                     JOptionPane.showMessageDialog(null, "Unable to publish car fully!  Unknown Error.  Please try again later.\n", "Car Maker", 1);
                     var179 = true;
                  }

                  if (!var179) {
                     JOptionPane.showMessageDialog(null, "Unable to publish car!  Unknown Error.\n", "Car Maker", 1);
                  }
               }
            }
         }

         if (this.logged == 0) {
            if (var1 == 1) {
               this.setCursor(new Cursor(3));
               int var37 = -1;

               try {
                  Socket var75 = new Socket("69.195.146.194", 7061);
                  BufferedReader var111 = new BufferedReader(new InputStreamReader(var75.getInputStream()));
                  PrintWriter var141 = new PrintWriter(var75.getOutputStream(), true);
                  var141.println("1|" + this.tnick.getText().toLowerCase() + "|" + this.tpass.getText() + "|");
                  String var155 = var111.readLine();
                  if (var155 != null) {
                     var37 = this.servervalue(var155, 0);
                  }

                  var75.close();
               } catch (Exception var16) {
                  var37 = -1;
               }

               if (var37 == 0 || var37 == 3 || var37 > 10) {
                  this.tnick.hide();
                  this.tpass.hide();
                  this.logged = 1;
                  this.savesettings();
               }

               if (var37 == 1 || var37 == 2) {
                  this.setCursor(new Cursor(0));
                  JOptionPane.showMessageDialog(null, "Sorry.  Incorrect Nickname or Password!", "Car Maker", 0);
               }

               if (var37 == -167) {
                  this.setCursor(new Cursor(0));
                  JOptionPane.showMessageDialog(null, "Sorry.  Your trial account cannot publish cars.  Please upgrade to a full account!   ", "Car Maker", 0);
               }

               if (var37 == -1) {
                  this.setCursor(new Cursor(0));
                  JOptionPane.showMessageDialog(null, "Unable to connect to server at this moment, please try again later.", "Car Maker", 1);
               }
            }

            if (var1 == 2) {
               Madness.openurl("http://multiplayer.needformadness.com/register.html?ref=game");
            }

            if (var1 == 3) {
               Madness.openurl("http://multiplayer.needformadness.com/edit.pl");
            }
         }
      }
   }

   public void setupo() {
      this.o = new ContO(this.editor.getText().getBytes(), this.m, this.t);
      this.o.x = this.ox;
      this.o.y = this.oy;
      this.o.z = this.oz;
      this.o.xz = this.oxz;
      this.o.xy = this.oxy;
      this.o.zy = this.ozy;
      this.o.shadow = true;
      this.o.tnt = 0;
      this.o.disp = 0;
      this.o.disline = 7;
      this.o.grounded = 1.0F;
      this.o.noline = false;
      this.o.decor = false;
      if (this.o.errd && (!this.o.err.startsWith("Wheels Error:") || this.forwheels)) {
         JOptionPane.showMessageDialog(null, this.o.err, "Car Maker", 0);
      }

      if (this.o.maxR == 0) {
         this.o.maxR = 100;
      }

      this.squash = 0;
      this.hitmag = 0;
   }

   public void loadfile() {
      this.loadedfile = false;
      this.lastedo = "";

      try {
         File var1 = new File("" + cmfpath + "mycars/" + this.carname + ".rad");
         BufferedReader var2 = new BufferedReader(new FileReader(var1));
         Object var3 = null;

         while ((var3 = var2.readLine()) != null) {
            this.lastedo = this.lastedo + "" + var3 + "\n";
         }

         this.loadedfile = true;
         var2.close();
         Object var5 = null;
      } catch (Exception var4) {
         this.loadedfile = false;
         this.lastedo = "";
         JOptionPane.showMessageDialog(null, "Unable to load file! Error Deatials:\n" + var4, "Car Maker", 1);
      }

      this.editor.setText(this.lastedo);
   }

   public void savefile() {
      if (!this.editor.getText().equals("")) {
         try {
            File var1 = new File("" + cmfpath + "mycars/");
            if (!var1.exists()) {
               var1.mkdirs();
            }

            var1 = new File("" + cmfpath + "mycars/" + this.carname + ".rad");
            BufferedWriter var2 = new BufferedWriter(new FileWriter(var1));
            var2.write(this.editor.getText());
            var2.close();
            Object var5 = null;
            this.changed = false;
            this.lastedo = this.editor.getText();
         } catch (Exception var3) {
            JOptionPane.showMessageDialog(null, "Unable to save file! Error Deatials:\n" + var3, "Car Maker", 1);
         }
      }

      this.savesettings();
   }

   public void newcar(String var1) {
      if (var1.equals("")) {
         JOptionPane.showMessageDialog(null, "Please Enter a Car Name!\n", "Car Maker", 1);
      } else {
         String var2 = "\n// car: "
            + var1
            + "\n---------------------\n\n// To start making you car you must start by reading the tutorial at:\n// http://www.needformadness.com/developer/simplecar.html\n\n\n<p>\nc(100,200,100)\n\np(-40,-50,80)\np(-40,-50,-70)\np(40,-50,-70)\np(40,-50,80)\n</p>\n\n<p>\nc(100,150,200)\n\np(-40,-20,-100)\np(-40,-50,-70)\np(40,-50,-70)\np(40,-20,-100)\n</p>\n\n\n\n";

         try {
            File var3 = new File("" + cmfpath + "mycars/");
            if (!var3.exists()) {
               var3.mkdirs();
            }

            this.carname = var1;
            var3 = new File("" + cmfpath + "mycars/" + this.carname + ".rad");
            if (!var3.exists()) {
               BufferedWriter var4 = new BufferedWriter(new FileWriter(var3));
               var4.write(var2);
               var4.close();
               Object var7 = null;
               if (var3.exists()) {
                  this.sfase = 0;
                  this.hidefields();
                  this.tabed = -1;
               } else {
                  JOptionPane.showMessageDialog(null, "Failed to create car, unknown reason!\n", "Car Maker", 1);
               }
            } else {
               JOptionPane.showMessageDialog(null, "A car with the name '" + this.carname + "' already exists, please choose another name!\n", "Car Maker", 1);
            }
         } catch (Exception var5) {
            this.carname = "";
            JOptionPane.showMessageDialog(null, "Unable to create file! Error Deatials:\n" + var5, "Car Maker", 1);
         }
      }
   }

   public void delcar(String var1) {
      if (var1.equals("")) {
         JOptionPane.showMessageDialog(null, "Please Select a Car to Delete!\n", "Car Maker", 1);
      } else {
         int var2 = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete car :  " + var1 + " ?  ", "Car Maker", 0);
         if (var2 == 0) {
            try {
               File var3 = new File("" + cmfpath + "mycars/" + var1 + ".rad");
               var3.delete();
               this.slcar.remove(var1);
               this.slcar.select(0);
            } catch (Exception var4) {
               JOptionPane.showMessageDialog(null, "Unable to delete file! Error Deatials:\n" + var4, "Car Maker", 1);
            }
         }
      }
   }

   public void rencar(String var1) {
      if (var1.equals("")) {
         JOptionPane.showMessageDialog(null, "Please Enter a New Car Name!\n", "Car Maker", 1);
      } else {
         try {
            File var2 = new File("" + cmfpath + "mycars/" + this.carname + ".rad");
            File var3 = new File("" + cmfpath + "mycars/" + var1 + ".rad");
            if (var2.renameTo(var3)) {
               this.carname = var1;
               this.sfase = 0;
               this.hidefields();
               this.tabed = -1;
            } else {
               JOptionPane.showMessageDialog(null, "Unable to rename car to: '" + var1 + "', possible reason: Car name already used!\n", "Car Maker", 1);
            }
         } catch (Exception var4) {
            JOptionPane.showMessageDialog(null, "Unable to rename file! Error Deatials:\n" + var4, "Car Maker", 1);
         }
      }
   }

   public void loadsettings() {
      try {
         File var1 = new File("" + cmfpath + "mycars/settings.data");
         if (var1.exists()) {
            BufferedReader var2 = new BufferedReader(new FileReader(var1));
            String var3 = var2.readLine();
            if (var3 != null) {
               this.scar = var3;
               this.carname = this.scar;
            }

            var3 = var2.readLine();
            if (var3 != null) {
               this.suser = var3;
               if (!this.suser.equals("Horaks")) {
                  this.tnick.setText(this.suser);
               }
            }

            var3 = var2.readLine();
            if (var3 != null) {
               this.sfont = var3;
               this.cfont = this.sfont;
            }

            var3 = var2.readLine();
            if (var3 != null) {
               this.sthm = Float.valueOf(var3).intValue();
               this.cthm = this.sthm;
            }

            var2.close();
            Object var5 = null;
         }
      } catch (Exception var4) {
      }
   }

   public void savesettings() {
      if (!this.scar.equals(this.carname) || !this.suser.equals(this.tnick.getText()) || !this.sfont.equals(this.cfont) || this.cthm != this.sthm) {
         String var1 = "" + this.carname + "\n" + this.tnick.getText() + "\n" + this.cfont + "\n" + this.cthm + "\n\n";
         this.scar = this.carname;
         this.suser = this.tnick.getText();
         this.sfont = this.cfont;
         this.sthm = this.cthm;

         try {
            File var2 = new File("" + cmfpath + "mycars/");
            if (!var2.exists()) {
               var2.mkdirs();
            }

            var2 = new File("" + cmfpath + "mycars/settings.data");
            BufferedWriter var3 = new BufferedWriter(new FileWriter(var2));
            var3.write(var1);
            var3.close();
            Object var6 = null;
         } catch (Exception var4) {
         }
      }
   }

   public boolean checko(String var1) {
      this.loadfile();
      this.setupo();
      if (this.o.colok < 2) {
         JOptionPane.showMessageDialog(
            null,
            "Car is not ready for " + var1 + "!\nReason:\nFirst and Second colors not defined yet!\nPlease go to the 'Color Edit' tab to define the colors.\n",
            "Car Maker",
            1
         );
         return false;
      } else {
         boolean var2 = true;
         if (this.o.keyz[0] <= 0 || this.o.keyx[0] >= 0) {
            var2 = false;
         }

         if (this.o.keyz[1] <= 0 || this.o.keyx[1] <= 0) {
            var2 = false;
         }

         if (this.o.keyz[2] >= 0 || this.o.keyx[2] >= 0) {
            var2 = false;
         }

         if (this.o.keyz[3] >= 0 || this.o.keyx[3] <= 0) {
            var2 = false;
         }

         if (!var2) {
            JOptionPane.showMessageDialog(
               null,
               "Car is not ready for "
                  + var1
                  + "!\nReason:\nCar Wheels not defined or not defined correctly!\nPlease go to the ‘Wheels’ tab and use  [ Apply ]  and  [ Save ]  to define correctly.\n",
               "Car Maker",
               1
            );
            return false;
         } else if (this.o.npl <= 60) {
            JOptionPane.showMessageDialog(
               null,
               "Car is not ready for "
                  + var1
                  + "!\nReason:\nNo car seems to be designed!\nYou have not built a car yet please go to the ‘Car’ tab to find the tutorial on how to build a car.\n",
               "Car Maker",
               1
            );
            return false;
         } else if (this.o.npl > 286) {
            JOptionPane.showMessageDialog(
               null,
               "Car is not ready for "
                  + var1
                  + "!\nReason:\nCar contains too many polygons (pieces).\nNumber of polygons used need to be less then 210.\nPlease use the counter in the ‘Code Edit’ to decrease the number of polygons (pieces).\n",
               "Car Maker",
               1
            );
            return false;
         } else if (this.o.maxR > 400) {
            JOptionPane.showMessageDialog(
               null,
               "Car is not ready for "
                  + var1
                  + "!\nReason:\nCar scale size is too large!\nPlease use the ‘Scale All’ option in the ‘Scale & Align’ tab to resize your car to suitable size.       \nCompare it to other NFM cars using the ‘Compare Car...’ option.\nCurrently you car needs to be scaled down by "
                  + (int)((this.o.maxR / 400.0F - 1.0F) * 100.0F)
                  + "%.\n",
               "Car Maker",
               1
            );
            return false;
         } else if (this.o.maxR < 120) {
            JOptionPane.showMessageDialog(
               null,
               "Car is not ready for "
                  + var1
                  + "!\nReason:\nCar scale size is too small!\nPlease use the ‘Scale All’ option in the ‘Scale & Align’ tab to resize your car to suitable size.       \nCompare it to other NFM cars using the ‘Compare Car...’ option.\nCurrently you car needs to be scaled up by "
                  + (int)((120.0F / this.o.maxR - 1.0F) * 100.0F)
                  + "%.\n",
               "Car Maker",
               1
            );
            return false;
         } else {
            String var3 = "" + this.editor.getText() + "\n";
            int var4 = 0;
            int var5 = var3.indexOf("\n", 0);
            boolean var6 = false;
            boolean var7 = false;
            boolean var8 = false;

            while (var5 != -1 && var4 < var3.length()) {
               String var9 = var3.substring(var4, var5);
               var9 = var9.trim();
               var4 = var5 + 1;
               var5 = var3.indexOf("\n", var4);
               if (var9.startsWith("stat(")) {
                  var6 = true;

                  try {
                     int var10 = 0;

                     for (int var11 = 0; var11 < 5; var11++) {
                        this.stat[var11] = this.getvalue("stat", var9, var11);
                        if (this.stat[var11] > 200) {
                           var6 = false;
                        }

                        if (this.stat[var11] < 16) {
                           var6 = false;
                        }

                        var10 += this.stat[var11];
                     }

                     if (var10 != 680 && var10 != 640 && var10 != 600 && var10 != 560 && var10 != 520) {
                        var6 = false;
                     }
                  } catch (Exception var14) {
                     var6 = false;
                  }
               }

               if (var9.startsWith("physics(")) {
                  var7 = true;

                  try {
                     for (int var16 = 0; var16 < 11; var16++) {
                        this.phys[var16] = this.getvalue("physics", var9, var16);
                        if (this.phys[var16] > 100) {
                           var7 = false;
                        }

                        if (this.phys[var16] < 0) {
                           var7 = false;
                        }
                     }

                     for (int var17 = 0; var17 < 3; var17++) {
                        this.crash[var17] = this.getvalue("physics", var9, var17 + 11);
                        if (var17 != 0 && this.crash[var17] > 100) {
                           var7 = false;
                        }

                        if (this.crash[var17] < 0) {
                           var7 = false;
                        }
                     }

                     this.engsel = this.getvalue("physics", var9, 14);
                     if (this.engsel > 4) {
                        var7 = false;
                     }

                     if (this.engsel < 0) {
                        var7 = false;
                     }
                  } catch (Exception var13) {
                     var7 = false;
                  }
               }

               if (var9.startsWith("handling(")) {
                  var8 = true;

                  try {
                     int var18 = this.getvalue("handling", var9, 0);
                     if (var18 > 200) {
                        var8 = false;
                     }

                     if (var18 < 0) {
                        var8 = false;
                     }
                  } catch (Exception var12) {
                     var8 = false;
                  }
               }
            }

            if (!var6) {
               JOptionPane.showMessageDialog(
                  null,
                  "Car is not ready for "
                     + var1
                     + "!\nReason:\nCar Stats & Class not defined correctly!\nPlease go to the 'Stats & Class' tab to define stats and don't forget to press  [ Save ]  when finished.\n",
                  "Car Maker",
                  1
               );
               return false;
            } else if (!var7) {
               JOptionPane.showMessageDialog(
                  null,
                  "Car is not ready for "
                     + var1
                     + "!\nReason:\nCar Physics not defined correctly!\nPlease go to the 'Physics' tab and complete the car physics definition until it is saved.\n",
                  "Car Maker",
                  1
               );
               return false;
            } else if (!var8 && var1.equals("Publishing")) {
               JOptionPane.showMessageDialog(
                  null,
                  "Car is not ready for " + var1 + "!\nReason:\nCar Handling not rated.\nPlease Test Drive your car to rate its handling before publishing!\n",
                  "Car Maker",
                  1
               );
               return false;
            } else {
               return true;
            }
         }
      }
   }

   public void regx(int var1, float var2, boolean var3) {
      this.hitmag = (int)(this.hitmag + var2);
      if (!var3) {
         this.crash(var2);
      }

      var2 *= 0.3F + this.crash[1] * 0.005F;
      if (Math.abs(var2) > 100.0F) {
         int var4 = (int)(this.crash[0] * this.crash[0] * 1.5);
         if (var4 < 1000) {
            var4 = 1000;
         }

         if (var2 > 100.0F) {
            var2 -= 100.0F;
         }

         if (var2 < -100.0F) {
            var2 += 100.0F;
         }

         for (int var5 = 0; var5 < this.o.npl; var5++) {
            float var6 = 0.0F;

            for (int var7 = 0; var7 < this.o.p[var5].n; var7++) {
               if (this.o.p[var5].wz == 0 && this.py(this.o.keyx[var1], this.o.p[var5].ox[var7], this.o.keyz[var1], this.o.p[var5].oz[var7]) < var4) {
                  var6 = var2 / 20.0F * this.m.random();
                  this.o.p[var5].oz[var7] = (int)(this.o.p[var5].oz[var7] - var6 * this.m.sin(this.o.xz) * this.m.cos(this.o.zy));
                  this.o.p[var5].ox[var7] = (int)(this.o.p[var5].ox[var7] + var6 * this.m.cos(this.o.xz) * this.m.cos(this.o.xy));
                  if (var3) {
                     this.actmag = (int)(this.actmag + Math.abs(var6));
                  }
               }
            }

            if (var6 != 0.0F) {
               if (Math.abs(var6) >= 1.0F) {
                  this.o.p[var5].chip = 1;
                  this.o.p[var5].ctmag = var6;
               }

               if (!this.o.p[var5].nocol && this.o.p[var5].glass != 1) {
                  if (this.o.p[var5].bfase > 20 && this.o.p[var5].hsb[1] > 0.25) {
                     this.o.p[var5].hsb[1] = 0.25F;
                  }

                  if (this.o.p[var5].bfase > 25 && this.o.p[var5].hsb[2] > 0.7) {
                     this.o.p[var5].hsb[2] = 0.7F;
                  }

                  if (this.o.p[var5].bfase > 30 && this.o.p[var5].hsb[1] > 0.15) {
                     this.o.p[var5].hsb[1] = 0.15F;
                  }

                  if (this.o.p[var5].bfase > 35 && this.o.p[var5].hsb[2] > 0.6) {
                     this.o.p[var5].hsb[2] = 0.6F;
                  }

                  if (this.o.p[var5].bfase > 40) {
                     this.o.p[var5].hsb[0] = 0.075F;
                  }

                  if (this.o.p[var5].bfase > 50 && this.o.p[var5].hsb[2] > 0.5) {
                     this.o.p[var5].hsb[2] = 0.5F;
                  }

                  if (this.o.p[var5].bfase > 60) {
                     this.o.p[var5].hsb[0] = 0.05F;
                  }

                  this.o.p[var5].bfase = (int)(this.o.p[var5].bfase + Math.abs(var6));
                  new Color(this.o.p[var5].c[0], this.o.p[var5].c[1], this.o.p[var5].c[2]);
                  Color var9 = Color.getHSBColor(this.o.p[var5].hsb[0], this.o.p[var5].hsb[1], this.o.p[var5].hsb[2]);
                  this.o.p[var5].c[0] = var9.getRed();
                  this.o.p[var5].c[1] = var9.getGreen();
                  this.o.p[var5].c[2] = var9.getBlue();
               }

               if (this.o.p[var5].glass == 1) {
                  this.o.p[var5].gr = (int)(this.o.p[var5].gr + Math.abs(var6 * 1.5));
               }
            }
         }
      }
   }

   public void regz(int var1, float var2, boolean var3) {
      this.hitmag = (int)(this.hitmag + var2);
      if (!var3) {
         this.crash(var2);
      }

      var2 *= 0.3F + this.crash[1] * 0.005F;
      if (Math.abs(var2) > 100.0F) {
         int var4 = (int)(this.crash[0] * this.crash[0] * 1.5);
         if (var4 < 1000) {
            var4 = 1000;
         }

         if (var2 > 100.0F) {
            var2 -= 100.0F;
         }

         if (var2 < -100.0F) {
            var2 += 100.0F;
         }

         for (int var5 = 0; var5 < this.o.npl; var5++) {
            float var6 = 0.0F;

            for (int var7 = 0; var7 < this.o.p[var5].n; var7++) {
               if (this.o.p[var5].wz == 0 && this.py(this.o.keyx[var1], this.o.p[var5].ox[var7], this.o.keyz[var1], this.o.p[var5].oz[var7]) < var4) {
                  var6 = var2 / 20.0F * this.m.random();
                  this.o.p[var5].oz[var7] = (int)(this.o.p[var5].oz[var7] + var6 * this.m.cos(this.o.xz) * this.m.cos(this.o.zy));
                  this.o.p[var5].ox[var7] = (int)(this.o.p[var5].ox[var7] + var6 * this.m.sin(this.o.xz) * this.m.cos(this.o.xy));
                  if (var3) {
                     this.actmag = (int)(this.actmag + Math.abs(var6));
                  }
               }
            }

            if (var6 != 0.0F) {
               if (Math.abs(var6) >= 1.0F) {
                  this.o.p[var5].chip = 1;
                  this.o.p[var5].ctmag = var6;
               }

               if (!this.o.p[var5].nocol && this.o.p[var5].glass != 1) {
                  if (this.o.p[var5].bfase > 20 && this.o.p[var5].hsb[1] > 0.25) {
                     this.o.p[var5].hsb[1] = 0.25F;
                  }

                  if (this.o.p[var5].bfase > 25 && this.o.p[var5].hsb[2] > 0.7) {
                     this.o.p[var5].hsb[2] = 0.7F;
                  }

                  if (this.o.p[var5].bfase > 30 && this.o.p[var5].hsb[1] > 0.15) {
                     this.o.p[var5].hsb[1] = 0.15F;
                  }

                  if (this.o.p[var5].bfase > 35 && this.o.p[var5].hsb[2] > 0.6) {
                     this.o.p[var5].hsb[2] = 0.6F;
                  }

                  if (this.o.p[var5].bfase > 40) {
                     this.o.p[var5].hsb[0] = 0.075F;
                  }

                  if (this.o.p[var5].bfase > 50 && this.o.p[var5].hsb[2] > 0.5) {
                     this.o.p[var5].hsb[2] = 0.5F;
                  }

                  if (this.o.p[var5].bfase > 60) {
                     this.o.p[var5].hsb[0] = 0.05F;
                  }

                  this.o.p[var5].bfase = (int)(this.o.p[var5].bfase + Math.abs(var6));
                  new Color(this.o.p[var5].c[0], this.o.p[var5].c[1], this.o.p[var5].c[2]);
                  Color var9 = Color.getHSBColor(this.o.p[var5].hsb[0], this.o.p[var5].hsb[1], this.o.p[var5].hsb[2]);
                  this.o.p[var5].c[0] = var9.getRed();
                  this.o.p[var5].c[1] = var9.getGreen();
                  this.o.p[var5].c[2] = var9.getBlue();
               }

               if (this.o.p[var5].glass == 1) {
                  this.o.p[var5].gr = (int)(this.o.p[var5].gr + Math.abs(var6 * 1.5));
               }
            }
         }
      }
   }

   public void roofsqsh(float var1) {
      if (var1 > 100.0F) {
         this.crash(var1);
         var1 -= 100.0F;
         int var2 = (int)(2.0 + this.crash[2] / 7.6);
         int var3 = 0;
         int var4 = 1;

         for (int var5 = 0; var5 < this.o.npl; var5++) {
            float var6 = 0.0F;
            if (Math.random() > 0.9) {
               var6 = var1 / 15.0F * this.m.random();
            }

            for (int var7 = 0; var7 < this.o.p[var5].n; var7++) {
               if (this.o.p[var5].wz == 0
                  && (Math.abs(this.o.p[var5].oy[var7] - this.o.roofat - this.squash) < var2 * 3 || this.o.p[var5].oy[var7] < this.o.roofat + this.squash)
                  && this.squash < var2) {
                  var6 = var1 / 15.0F * this.m.random();
                  this.o.p[var5].oy[var7] = (int)(this.o.p[var5].oy[var7] + var6);
                  var3 = (int)(var3 + var6);
                  var4++;
                  this.hitmag = (int)(this.hitmag + Math.abs(var6));
               }
            }

            if (!this.o.p[var5].nocol && this.o.p[var5].glass != 1) {
               if (var6 != 0.0F) {
                  if (this.o.p[var5].bfase > 20 && this.o.p[var5].hsb[1] > 0.25) {
                     this.o.p[var5].hsb[1] = 0.25F;
                  }

                  if (this.o.p[var5].bfase > 25 && this.o.p[var5].hsb[2] > 0.7) {
                     this.o.p[var5].hsb[2] = 0.7F;
                  }

                  if (this.o.p[var5].bfase > 30 && this.o.p[var5].hsb[1] > 0.15) {
                     this.o.p[var5].hsb[1] = 0.15F;
                  }

                  if (this.o.p[var5].bfase > 35 && this.o.p[var5].hsb[2] > 0.6) {
                     this.o.p[var5].hsb[2] = 0.6F;
                  }

                  if (this.o.p[var5].bfase > 40) {
                     this.o.p[var5].hsb[0] = 0.075F;
                  }

                  if (this.o.p[var5].bfase > 50 && this.o.p[var5].hsb[2] > 0.5) {
                     this.o.p[var5].hsb[2] = 0.5F;
                  }

                  if (this.o.p[var5].bfase > 60) {
                     this.o.p[var5].hsb[0] = 0.05F;
                  }

                  this.o.p[var5].bfase = (int)(this.o.p[var5].bfase + var6);
                  new Color(this.o.p[var5].c[0], this.o.p[var5].c[1], this.o.p[var5].c[2]);
                  Color var9 = Color.getHSBColor(this.o.p[var5].hsb[0], this.o.p[var5].hsb[1], this.o.p[var5].hsb[2]);
                  this.o.p[var5].c[0] = var9.getRed();
                  this.o.p[var5].c[1] = var9.getGreen();
                  this.o.p[var5].c[2] = var9.getBlue();
               }
            } else if (this.o.p[var5].glass == 1) {
               this.o.p[var5].gr += 5;
            }

            if (Math.abs(var6) >= 1.0F) {
               this.o.p[var5].chip = 1;
               this.o.p[var5].ctmag = var6;
            }
         }

         this.squash += var3 / var4;
      }
   }

   public void crash(float var1) {
      if (var1 > 100.0F) {
         var1 -= 100.0F;
      }

      if (var1 < -100.0F) {
         var1 += 100.0F;
      }

      if (Math.abs(var1) > 25.0F && Math.abs(var1) < 170.0F) {
         this.lowcrashs[this.crshturn].play();
      }

      if (Math.abs(var1) >= 170.0F) {
         this.crashs[this.crshturn].play();
      }

      if (Math.abs(var1) > 25.0F) {
         if (this.crashup) {
            this.crshturn--;
         } else {
            this.crshturn++;
         }

         if (this.crshturn == -1) {
            this.crshturn = 2;
         }

         if (this.crshturn == 3) {
            this.crshturn = 0;
         }
      }
   }

   public void setheme() {
      if (this.cthm == 0) {
         this.editor.setForeground(this.deff);
         this.editor.setBackground(this.defb);
      }

      if (this.cthm == 1) {
         this.editor.setForeground(new Color(0, 0, 0));
         this.editor.setBackground(new Color(192, 192, 192));
      }

      if (this.cthm == 2) {
         this.editor.setForeground(new Color(192, 192, 192));
         this.editor.setBackground(new Color(0, 0, 0));
      }

      if (this.cthm == 3) {
         this.editor.setForeground(new Color(0, 0, 0));
         this.editor.setBackground(new Color(50, 200, 0));
      }

      if (this.cthm == 4) {
         this.editor.setForeground(new Color(67, 255, 77));
         this.editor.setBackground(new Color(0, 0, 0));
      }

      if (this.cthm == 5) {
         this.editor.setForeground(new Color(0, 172, 255));
         this.editor.setBackground(new Color(210, 234, 255));
      }

      if (this.cthm == 6) {
         this.editor.setForeground(new Color(255, 230, 0));
         this.editor.setBackground(new Color(255, 77, 67));
      }

      if (this.cthm == 7) {
         this.editor.setForeground(new Color(0, 159, 255));
         this.editor.setBackground(new Color(9, 47, 104));
      }
   }

   public int py(int var1, int var2, int var3, int var4) {
      return (var1 - var2) * (var1 - var2) + (var3 - var4) * (var3 - var4);
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

   @Override
   public void init() {
      this.setBackground(new Color(0, 0, 0));
      this.offImage = this.createImage(700, 550);
      if (this.offImage != null) {
         this.rd = (Graphics2D)this.offImage.getGraphics();
      }

      this.rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
      boolean var1 = true;
      if (System.getProperty("java.vendor").toLowerCase().indexOf("apple") != -1 || System.getProperty("java.vendor").toLowerCase().indexOf("sun") != -1) {
         var1 = false;
      }

      this.setLayout(null);
      this.slcar.setFont(new Font("Arial", 1, 13));
      this.slcar.add(this.rd, "Select a Car...         ");
      this.slcar.setForeground(new Color(63, 80, 110));
      this.slcar.setBackground(new Color(209, 217, 230));
      this.fontsel.setFont(new Font("Arial", 1, 12));
      this.fontsel.add(this.rd, "Arial");
      this.fontsel.add(this.rd, "Dialog");
      this.fontsel.add(this.rd, "DialogInput");
      this.fontsel.add(this.rd, "Monospaced");
      this.fontsel.add(this.rd, "Serif");
      this.fontsel.add(this.rd, "SansSerif");
      this.fontsel.add(this.rd, "Verdana");
      this.fontsel.setBackground(new Color(63, 80, 110));
      this.fontsel.setForeground(new Color(209, 217, 230));
      this.ctheme.setFont(new Font("Arial", 1, 12));
      this.ctheme.add(this.rd, "Default");
      this.ctheme.add(this.rd, "Author");
      this.ctheme.add(this.rd, "Dos");
      this.ctheme.add(this.rd, "Green");
      this.ctheme.add(this.rd, "The Matrix");
      this.ctheme.add(this.rd, "Ice Age");
      this.ctheme.add(this.rd, "Fire");
      this.ctheme.add(this.rd, "Ocean");
      this.ctheme.setBackground(new Color(63, 80, 110));
      this.ctheme.setForeground(new Color(209, 217, 230));
      this.compcar.setFont(new Font("Arial", 1, 12));
      this.compcar.add(this.rd, "Compare Car...");
      this.compcar.add(this.rd, "Tornado Shark");
      this.compcar.add(this.rd, "Formula 7");
      this.compcar.add(this.rd, "Wow Caninaro");
      this.compcar.add(this.rd, "La Vita Crab");
      this.compcar.add(this.rd, "Nimi");
      this.compcar.add(this.rd, "MAX Revenge");
      this.compcar.add(this.rd, "Lead Oxide");
      this.compcar.add(this.rd, "Kool Kat");
      this.compcar.add(this.rd, "Drifter X");
      this.compcar.add(this.rd, "Sword of Justice");
      this.compcar.add(this.rd, "High Rider");
      this.compcar.add(this.rd, "EL KING");
      this.compcar.add(this.rd, "Mighty Eight");
      this.compcar.add(this.rd, "M A S H E E N");
      this.compcar.add(this.rd, "Radical One");
      this.compcar.add(this.rd, "DR Monstaa");
      this.compcar.add(this.rd, " -  None  - ");
      this.compcar.setBackground(new Color(63, 80, 110));
      this.compcar.setForeground(new Color(209, 217, 230));
      this.cls.setFont(new Font("Arial", 1, 12));
      this.cls.add(this.rd, "Class A");
      this.cls.add(this.rd, "Class A & B");
      this.cls.add(this.rd, "Class B");
      this.cls.add(this.rd, "Class B & C");
      this.cls.add(this.rd, "Class C");
      this.cls.setBackground(new Color(63, 80, 110));
      this.cls.setForeground(new Color(209, 217, 230));
      this.simcar.setFont(new Font("Arial", 1, 12));
      this.simcar.add(this.rd, "Tornado Shark");
      this.simcar.add(this.rd, "Formula 7");
      this.simcar.add(this.rd, "Wow Caninaro");
      this.simcar.add(this.rd, "La Vita Crab");
      this.simcar.add(this.rd, "Nimi");
      this.simcar.add(this.rd, "MAX Revenge");
      this.simcar.add(this.rd, "Lead Oxide");
      this.simcar.add(this.rd, "Kool Kat");
      this.simcar.add(this.rd, "Drifter X");
      this.simcar.add(this.rd, "Sword of Justice");
      this.simcar.add(this.rd, "High Rider");
      this.simcar.add(this.rd, "EL KING");
      this.simcar.add(this.rd, "Mighty Eight");
      this.simcar.add(this.rd, "M A S H E E N");
      this.simcar.add(this.rd, "Radical One");
      this.simcar.add(this.rd, "DR Monstaa");
      this.simcar.setBackground(new Color(63, 80, 110));
      this.simcar.setForeground(new Color(209, 217, 230));
      this.witho.setFont(new Font("Arial", 1, 12));
      this.witho.add(this.rd, "With other cars");
      this.witho.add(this.rd, "Alone");
      this.witho.setBackground(new Color(63, 80, 110));
      this.witho.setForeground(new Color(209, 217, 230));
      this.engine.setFont(new Font("Arial", 1, 12));
      this.engine.add(this.rd, "Normal Engine");
      this.engine.add(this.rd, "V8 Engine");
      this.engine.add(this.rd, "Retro Engine");
      this.engine.add(this.rd, "Power Engine");
      this.engine.add(this.rd, "Diesel Engine");
      this.engine.setBackground(new Color(63, 80, 110));
      this.engine.setForeground(new Color(209, 217, 230));
      MenuItem var2 = new MenuItem("Cut");
      MenuItem var3 = new MenuItem("Copy");
      MenuItem var4 = new MenuItem("Paste");
      MenuItem var5 = new MenuItem("Select All");
      this.popupMenu = new PopupMenu();
      this.popupMenu.add(var2);
      this.popupMenu.add(var3);
      this.popupMenu.add(var4);
      this.popupMenu.add(var5);
      var2.addActionListener(this);
      var3.addActionListener(this);
      var4.addActionListener(this);
      var5.addActionListener(this);
      this.add(this.popupMenu);

      for (int var6 = 0; var6 < 16; var6++) {
         this.wv[var6] = new TextField("", 2);
         this.wv[var6].setBackground(new Color(255, 255, 255));
         this.wv[var6].setForeground(new Color(0, 0, 0));
         this.wv[var6].setFont(new Font(this.cfont, 1, 14));
         if (var1) {
            this.wv[var6].addMouseListener(new MouseHandler(this.popupMenu, var6));
         }

         this.add(this.wv[var6]);
      }

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
      this.pubitem.add(this.rd, "Account Cars");
      this.pubitem.setBackground(new Color(209, 217, 230));
      this.pubitem.setForeground(new Color(63, 80, 110));
      this.srch.setBackground(new Color(255, 255, 255));
      this.srch.setForeground(new Color(0, 0, 0));
      if (var1) {
         this.srch.addMouseListener(new MouseHandler(this.popupMenu, 16));
      }

      this.rplc.setBackground(new Color(255, 255, 255));
      this.rplc.setForeground(new Color(0, 0, 0));
      if (var1) {
         this.rplc.addMouseListener(new MouseHandler(this.popupMenu, 17));
      }

      if (var1) {
         this.editor.addMouseListener(new MouseHandler(this.popupMenu, 18));
      }

      this.add(this.tnick);
      this.add(this.tpass);
      this.add(this.editor);
      this.add(this.srch);
      this.add(this.rplc);
      this.defb = new Color(255, 255, 255);
      this.deff = new Color(0, 0, 0);
      this.hidefields();
   }

   public void hidefields() {
      this.pubtyp.hide();
      this.pubitem.hide();
      this.tpass.hide();
      this.tnick.hide();
      this.slcar.hide();
      this.witho.hide();

      for (int var1 = 0; var1 < 16; var1++) {
         this.wv[var1].hide();
      }

      this.simcar.hide();
      this.engine.hide();
      this.cls.hide();
      this.compcar.hide();
      this.editor.hide();
      this.fontsel.hide();
      this.ctheme.hide();
      this.srch.hide();
      this.rplc.hide();
   }

   public void movefield(Component var1, int var2, int var3, int var4, int var5) {
      var2 += this.apx;
      var3 += this.apy;
      if (var1.getX() != var2 || var1.getY() != var3 || var1.getWidth() != var4 || var1.getHeight() != var5) {
         var1.setBounds(var2, var3, var4, var5);
      }
   }

   public void drawms() {
      this.openm = false;
      if (this.pubtyp.draw(this.rd, this.xm, this.ym, this.mousdr, 550, false)) {
         this.openm = true;
      }

      if (this.pubitem.draw(this.rd, this.xm, this.ym, this.mousdr, 550, false)) {
         this.openm = true;
      }

      if (this.fontsel.draw(this.rd, this.xm, this.ym, this.mousdr, 550, true)) {
         this.openm = true;
      }

      if (this.ctheme.draw(this.rd, this.xm, this.ym, this.mousdr, 550, true)) {
         this.openm = true;
      }

      if (this.compcar.draw(this.rd, this.xm, this.ym, this.mousdr, 550, true)) {
         this.openm = true;
      }

      if (this.cls.draw(this.rd, this.xm, this.ym, this.mousdr, 550, true)) {
         this.openm = true;
      }

      if (this.simcar.draw(this.rd, this.xm, this.ym, this.mousdr, 550, true)) {
         this.openm = true;
      }

      if (this.engine.draw(this.rd, this.xm, this.ym, this.mousdr, 550, false)) {
         this.openm = true;
      }

      if (this.witho.draw(this.rd, this.xm, this.ym, this.mousdr, 550, true)) {
         this.openm = true;
      }

      if (this.slcar.draw(this.rd, this.xm, this.ym, this.mousdr, 550, false)) {
         this.openm = true;
      }

      if (this.openm) {
         this.waso = true;
         this.mouses = 0;
      }
   }

   public void openlink() {
      Madness.openurl("http://www.needformadness.com/developer/simplecar.html");
   }

   public void openhlink() {
      Madness.openurl("http://www.needformadness.com/developer/");
   }

   public void openelink() {
      Madness.openurl("http://www.needformadness.com/developer/extras.html");
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
      this.apx = this.getWidth() / 2 - 350;
      this.apy = this.getHeight() / 2 - 275;
      var1.drawImage(this.offImage, this.apx, this.apy, this);
   }

   @Override
   public void update(Graphics var1) {
      this.paint(var1);
   }

   @Override
   public boolean mouseUp(Event var1, int var2, int var3) {
      this.xm = var2 - this.apx;
      this.ym = var3 - this.apy;
      if (this.waso) {
         this.waso = false;
      } else {
         this.mouses = -1;
      }

      this.mousdr = false;
      if (this.onbtgame) {
         Madness.game();
      }

      return false;
   }

   @Override
   public boolean mouseDown(Event var1, int var2, int var3) {
      this.xm = var2 - this.apx;
      this.ym = var3 - this.apy;
      this.mouses = 1;
      this.mousdr = true;
      if (this.tab != 1) {
         this.requestFocus();
      }

      return false;
   }

   @Override
   public boolean mouseMove(Event var1, int var2, int var3) {
      this.xm = var2 - this.apx;
      this.ym = var3 - this.apy;
      if (this.xm > 520 && this.xm < 674 && this.ym > 0 && this.ym < 23) {
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
   public boolean lostFocus(Event var1, Object var2) {
      this.focuson = false;
      return false;
   }

   @Override
   public boolean gotFocus(Event var1, Object var2) {
      this.focuson = true;
      return false;
   }

   @Override
   public boolean keyDown(Event var1, int var2) {
      if (this.focuson) {
         if (var2 == 54 || var2 == 46 || var2 == 100 || var2 == 68) {
            this.rotr = true;
         }

         if (var2 == 52 || var2 == 44 || var2 == 97 || var2 == 65) {
            this.rotl = true;
         }

         if (var2 == 43 || var2 == 61) {
            this.plus = true;
         }

         if (var2 == 45) {
            this.minus = true;
         }

         if (var2 == 42 || var2 == 10 || var2 == 56 || var2 == 119 || var2 == 87) {
            this.in = true;
         }

         if (var2 == 47 || var2 == 8 || var2 == 50 || var2 == 115 || var2 == 83) {
            this.out = true;
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
      if (var2 == 54 || var2 == 46 || var2 == 100 || var2 == 68) {
         this.rotr = false;
      }

      if (var2 == 52 || var2 == 44 || var2 == 97 || var2 == 65) {
         this.rotl = false;
      }

      if (var2 == 43 || var2 == 61) {
         this.plus = false;
      }

      if (var2 == 45) {
         this.minus = false;
      }

      if (var2 == 42 || var2 == 10 || var2 == 56 || var2 == 119 || var2 == 97) {
         this.in = false;
      }

      if (var2 == 47 || var2 == 8 || var2 == 50 || var2 == 115 || var2 == 83) {
         this.out = false;
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

   public void loadsounds() {
      try {
         File var1 = new File("" + Madness.fpath + "data/sounds.zip");
         FileInputStream var2 = new FileInputStream(var1);
         ZipInputStream var3 = new ZipInputStream(var2);

         for (ZipEntry var4 = var3.getNextEntry(); var4 != null; var4 = var3.getNextEntry()) {
            int var5 = (int)var4.getSize();
            String var6 = var4.getName();
            byte[] var7 = new byte[var5];
            int var8 = 0;

            while (var5 > 0) {
               int var9 = var3.read(var7, var8, var5);
               var8 += var9;
               var5 -= var9;
            }

            for (int var10 = 0; var10 < 5; var10++) {
               for (int var11 = 0; var11 < 5; var11++) {
                  if (var6.equals("" + var11 + "" + var10 + ".wav")) {
                     this.engs[var11][var10] = new soundClip(var7);
                  }
               }
            }

            for (int var13 = 0; var13 < 3; var13++) {
               if (var6.equals("crash" + (var13 + 1) + ".wav")) {
                  this.crashs[var13] = new soundClip(var7);
               }
            }

            for (int var14 = 0; var14 < 3; var14++) {
               if (var6.equals("lowcrash" + (var14 + 1) + ".wav")) {
                  this.lowcrashs[var14] = new soundClip(var7);
               }
            }
         }

         var2.close();
         var3.close();
      } catch (Exception var12) {
         System.out.println("Error Loading Sounds: " + var12);
      }

      System.gc();
   }

   public void loadbase() {
      String[] var1 = new String[]{
         "2000tornados",
         "formula7",
         "canyenaro",
         "lescrab",
         "nimi",
         "maxrevenge",
         "leadoxide",
         "koolkat",
         "drifter",
         "policecops",
         "mustang",
         "king",
         "audir8",
         "masheen",
         "radicalone",
         "drmonster"
      };

      try {
         File var2 = new File("" + Madness.fpath + "data/models.zip");
         ZipInputStream var3 = new ZipInputStream(new FileInputStream(var2));
         ZipEntry var4 = var3.getNextEntry();

         for (Object var5 = null; var4 != null; var4 = var3.getNextEntry()) {
            int var6 = -1;

            for (int var7 = 0; var7 < 16; var7++) {
               if (var4.getName().startsWith(var1[var7])) {
                  var6 = var7;
               }
            }

            if (var6 != -1) {
               int var12 = (int)var4.getSize();
               var5 = new byte[var12];
               int var8 = 0;

               while (var12 > 0) {
                  int var9 = var3.read((byte[])var5, var8, var12);
                  var8 += var9;
                  var12 -= var9;
               }

               this.compo[var6] = new ContO((byte[])var5, this.m, this.t);
               this.compo[var6].shadow = false;
               this.compo[var6].noline = true;
            }
         }

         var3.close();
      } catch (Exception var10) {
         System.out.println("Error Loading Models from Zip: " + var10);
      }

      System.gc();
   }

   public void fixtext(TextField var1) {
      String var2 = var1.getText();
      var2 = var2.replace('"', '#');
      String var3 = "\\";
      String var4 = "";
      int var5 = 0;

      int var6;
      for (var6 = -1; var5 < var2.length(); var5++) {
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
            && !var7.equals("'")
            && !var7.equals(";")
            && !var7.equals(":")
            && var5 <= 15) {
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

   public int objvalue(String var1, int var2) {
      int var3 = 0;

      try {
         int var4 = 2;
         int var5 = 0;
         byte var6 = 0;
         String var7 = "";
         String var8 = "";

         for (boolean var9 = false; var4 < var1.length() && var6 != 2; var4++) {
            var7 = "" + var1.charAt(var4);
            if (var7.equals(" ")) {
               if (var9) {
                  var5++;
                  var9 = false;
               }

               if (var6 == 1 || var5 > var2) {
                  var6 = 2;
               }
            } else {
               if (var5 == var2) {
                  var8 = var8 + var7;
                  var6 = 1;
               }

               var9 = true;
            }
         }

         if (var4 >= var1.length()) {
            this.objfacend = true;
         }

         if (var8.equals("")) {
            var8 = "0";
         }

         if (this.multf10) {
            var3 = (int)(Float.valueOf(var8) * 10.0F);
         } else {
            int var10 = var8.indexOf("/", 0);
            if (var10 != -1) {
               var8 = var8.substring(0, var10);
            }

            var3 = Float.valueOf(var8).intValue() - 1;
            if (var3 < 0) {
               var3 = 0;
            }
         }
      } catch (Exception var11) {
      }

      return var3;
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

   public void stringbutton(String var1, int var2, int var3, int var4, boolean var5) {
      this.rd.setFont(new Font("Arial", 1, 12));
      this.ftm = this.rd.getFontMetrics();
      if (var1.indexOf("Publish") != -1) {
         this.rd.setFont(new Font("Arial", 1, 13));
         this.ftm = this.rd.getFontMetrics();
      }

      this.bx[this.btn] = var2;
      this.by[this.btn] = var3 - 5;
      this.bw[this.btn] = this.ftm.stringWidth(var1);
      if (!this.pessd[this.btn]) {
         this.rd.setColor(new Color(220, 220, 220));
         if (var5) {
            this.rd.setColor(new Color(230, 230, 230));
         }

         this.rd.fillRect(var2 - this.bw[this.btn] / 2 - 10, var3 - (17 - var4), this.bw[this.btn] + 20, 25 - var4 * 2);
         this.rd.setColor(new Color(240, 240, 240));
         if (var5) {
            this.rd.setColor(new Color(255, 255, 255));
         }

         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 10, var3 - (17 - var4), var2 + this.bw[this.btn] / 2 + 10, var3 - (17 - var4));
         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 10, var3 - (18 - var4), var2 + this.bw[this.btn] / 2 + 10, var3 - (18 - var4));
         this.rd.setColor(new Color(240, 240, 240));
         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 9, var3 - (19 - var4), var2 + this.bw[this.btn] / 2 + 9, var3 - (19 - var4));
         this.rd.setColor(new Color(200, 200, 200));
         if (var5) {
            this.rd.setColor(new Color(192, 192, 192));
         }

         this.rd.drawLine(var2 + this.bw[this.btn] / 2 + 10, var3 - (17 - var4), var2 + this.bw[this.btn] / 2 + 10, var3 + (7 - var4));
         this.rd.drawLine(var2 + this.bw[this.btn] / 2 + 11, var3 - (17 - var4), var2 + this.bw[this.btn] / 2 + 11, var3 + (7 - var4));
         this.rd.setColor(new Color(200, 200, 200));
         this.rd.drawLine(var2 + this.bw[this.btn] / 2 + 12, var3 - (16 - var4), var2 + this.bw[this.btn] / 2 + 12, var3 + (6 - var4));
         if (var5) {
            this.rd.setColor(new Color(192, 192, 192));
         }

         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 10, var3 + (7 - var4), var2 + this.bw[this.btn] / 2 + 10, var3 + (7 - var4));
         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 10, var3 + (8 - var4), var2 + this.bw[this.btn] / 2 + 10, var3 + (8 - var4));
         this.rd.setColor(new Color(200, 200, 200));
         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 9, var3 + (9 - var4), var2 + this.bw[this.btn] / 2 + 9, var3 + (9 - var4));
         this.rd.setColor(new Color(240, 240, 240));
         if (var5) {
            this.rd.setColor(new Color(255, 255, 255));
         }

         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 10, var3 - (17 - var4), var2 - this.bw[this.btn] / 2 - 10, var3 + (7 - var4));
         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 11, var3 - (17 - var4), var2 - this.bw[this.btn] / 2 - 11, var3 + (7 - var4));
         this.rd.setColor(new Color(240, 240, 240));
         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 12, var3 - (16 - var4), var2 - this.bw[this.btn] / 2 - 12, var3 + (6 - var4));
         this.rd.setColor(new Color(0, 0, 0));
         this.rd.drawString(var1, var2 - this.bw[this.btn] / 2, var3);
      } else {
         this.rd.setColor(new Color(220, 220, 220));
         this.rd.fillRect(var2 - this.bw[this.btn] / 2 - 10, var3 - (17 - var4), this.bw[this.btn] + 20, 25 - var4 * 2);
         this.rd.setColor(new Color(192, 192, 192));
         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 10, var3 - (17 - var4), var2 + this.bw[this.btn] / 2 + 10, var3 - (17 - var4));
         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 10, var3 - (18 - var4), var2 + this.bw[this.btn] / 2 + 10, var3 - (18 - var4));
         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 9, var3 - (19 - var4), var2 + this.bw[this.btn] / 2 + 9, var3 - (19 - var4));
         this.rd.setColor(new Color(247, 247, 247));
         this.rd.drawLine(var2 + this.bw[this.btn] / 2 + 10, var3 - (17 - var4), var2 + this.bw[this.btn] / 2 + 10, var3 + (7 - var4));
         this.rd.drawLine(var2 + this.bw[this.btn] / 2 + 11, var3 - (17 - var4), var2 + this.bw[this.btn] / 2 + 11, var3 + (7 - var4));
         this.rd.drawLine(var2 + this.bw[this.btn] / 2 + 12, var3 - (16 - var4), var2 + this.bw[this.btn] / 2 + 12, var3 + (6 - var4));
         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 10, var3 + (7 - var4), var2 + this.bw[this.btn] / 2 + 10, var3 + (7 - var4));
         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 10, var3 + (8 - var4), var2 + this.bw[this.btn] / 2 + 10, var3 + (8 - var4));
         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 9, var3 + (9 - var4), var2 + this.bw[this.btn] / 2 + 9, var3 + (9 - var4));
         this.rd.setColor(new Color(192, 192, 192));
         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 10, var3 - (17 - var4), var2 - this.bw[this.btn] / 2 - 10, var3 + (7 - var4));
         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 11, var3 - (17 - var4), var2 - this.bw[this.btn] / 2 - 11, var3 + (7 - var4));
         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 12, var3 - (16 - var4), var2 - this.bw[this.btn] / 2 - 12, var3 + (6 - var4));
         this.rd.setColor(new Color(0, 0, 0));
         this.rd.drawString(var1, var2 - this.bw[this.btn] / 2 + 1, var3 + 1);
      }

      this.btn++;
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

   @Override
   public void actionPerformed(ActionEvent var1) {
      TextComponent var2 = this.wv[0];
      if (Madness.textid >= 0 && Madness.textid <= 15) {
         var2 = this.wv[Madness.textid];
      }

      if (Madness.textid == 16) {
         var2 = this.srch;
      }

      if (Madness.textid == 17) {
         var2 = this.rplc;
      }

      if (Madness.textid == 18) {
         var2 = this.editor;
      }

      String var3 = var1.getActionCommand();
      if (var3.equals("Cut")) {
         StringSelection var4 = new StringSelection(var2.getSelectedText());
         Toolkit.getDefaultToolkit().getSystemClipboard().setContents(var4, null);
         if (Madness.textid == 18) {
            this.editor.replaceText("", this.editor.getSelectionStart(), this.editor.getSelectionEnd());
         } else {
            var2.setText(var2.getText().substring(0, var2.getSelectionStart()) + var2.getText().substring(var2.getSelectionEnd(), var2.getText().length()));
         }
      }

      if (var3.equals("Copy")) {
         StringSelection var6 = new StringSelection(var2.getSelectedText());
         Toolkit.getDefaultToolkit().getSystemClipboard().setContents(var6, null);
      }

      if (var3.equals("Paste")) {
         try {
            String var7 = (String)Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
            if (Madness.textid == 18) {
               this.editor.replaceText(var7, this.editor.getSelectionStart(), this.editor.getSelectionEnd());
            } else {
               var2.setText(
                  var2.getText().substring(0, var2.getSelectionStart()) + var7 + var2.getText().substring(var2.getSelectionEnd(), var2.getText().length())
               );
            }
         } catch (Exception var5) {
         }
      }

      if (var3.equals("Select All")) {
         var2.selectAll();
      }
   }
}
