import java.applet.Applet;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URI;
import java.net.URL;
import java.util.Date;
import javax.swing.JOptionPane;

public class Madness extends Panel {
   static Frame frame;
   static Applet applet;
   static String fpath = "";
   static boolean fullscreen = false;
   static int anti = 0;
   static GraphicsDevice myDevice;
   static DisplayMode defdisp;
   static DisplayMode fulldisp;
   static int testdrive = 0;
   static String testcar = "";
   static int textid = 0;
   static int updateon = 0;
   static String upfile = "";
   static boolean inisetup = false;
   static int endadv = 0;
   static long advtime = 0L;

   public static void main(String[] var0) {
//      System.runFinalizersOnExit(true);
      frame = new Frame("Need for Madness");
      frame.setBackground(new Color(0, 0, 0));
      frame.setIgnoreRepaint(true);
      fpath = "";
      boolean var1 = false;

      for (String var5 : var0) {
         if (!var1) {
            fpath = fpath + var5;
            var1 = true;
         } else {
            fpath = fpath + " " + var5;
         }
      }

      if (!fpath.equals("")) {
         if (fpath.equals("manar")) {
            fpath = "";

            try {
               File var7 = new File("data/manar.ok");
               if (!var7.exists()) {
                  BufferedWriter var10 = new BufferedWriter(new FileWriter(var7));
                  var10.write("" + (int)(Math.random() * 1000.0) + "");
                  var10.newLine();
                  var10.close();
                  Object var11 = null;
               }
            } catch (Exception var6) {
            }
         } else {
            File var8 = new File("" + fpath + "data/models.zip");
            if (!var8.exists()) {
               fpath = "";
            }
         }
      }

      fpath = "/app/games/nfmm/";

      frame.setIconImage(Toolkit.getDefaultToolkit().createImage("" + fpath + "data/icon.png"));
      applet = new GameSparker();
      frame.addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent var1) {
            Madness.exitsequance();
         }
      });
      frame.add("Center", applet);
      frame.show();
      frame.setMinimumSize(new Dimension(930, 586));
      frame.setSize(930, 586);
      frame.setExtendedState(6);
      applet.init();
      applet.start();
      GraphicsEnvironment var9 = GraphicsEnvironment.getLocalGraphicsEnvironment();
      myDevice = var9.getDefaultScreenDevice();
      defdisp = myDevice.getDisplayMode();
//      checknupdate(36);
   }

   public static void gofullscreen() {
      DisplayMode[] var0 = myDevice.getDisplayModes();
      String[] var1 = new String[100];
      int[] var2 = new int[100];
      int var3 = 0;
      float var4 = (float)defdisp.getWidth() / defdisp.getHeight();
      float var5 = -1.0F;
      int var6 = 0;

      for (int var7 = 0; var7 < var0.length; var7++) {
         if (var0[var7].getWidth() >= 800 && var0[var7].getBitDepth() >= 16 && var6 < 100) {
            if (var0[var7].getWidth() < 900) {
               float var8 = (float)var0[var7].getWidth() / var0[var7].getHeight();
               var8 = Math.abs(var4 - var8);
               if (var8 <= var5 || var5 == -1.0F) {
                  var3 = var6;
                  var5 = var8;
               }
            }

            var1[var6] = ""
               + var0[var7].getWidth()
               + " x "
               + var0[var7].getHeight()
               + " Resolution   -   "
               + var0[var7].getBitDepth()
               + " Bits   -   "
               + var0[var7].getRefreshRate()
               + " Refresh Rate";
            var2[var6] = var7;
            var6++;
         }
      }

      if (var5 != -1.0F) {
         var1[var3] = var1[var3] + "     <  Recommended";
      }

      try {
         File var18 = new File("" + fpath + "data/full_screen.data");
         if (var18.exists()) {
            BufferedReader var21 = new BufferedReader(new FileReader(var18));
            String var9 = null;

            for (boolean var10 = false; (var9 = var21.readLine()) != null && !var10; var10 = true) {
               var9 = var9.trim();

               int var11;
               try {
                  var11 = Integer.valueOf(var9);
               } catch (Exception var16) {
                  var11 = var3;
               }

               var3 = var11;
               if (var11 < 0) {
                  var3 = 0;
               }

               if (var3 > var6 - 1) {
                  var3 = var6 - 1;
               }
            }

            var21.close();
            Object var22 = null;
         }
      } catch (Exception var17) {
      }

      String[] var19 = new String[var6];

      for (int var23 = 0; var23 < var6; var23++) {
         var19[var23] = var1[var23];
      }

      String[] var24 = var19;
      Object var27 = JOptionPane.showInputDialog(
         null,
         "Choose a screen resolution setting below and click OK to try it.\nExit Fullscreen by pressing [Esc].\n\nIMPORTANT: If the game does not display properly in Fullscreen press [Esc]      \nand try a different resolution setting below,",
         "Fullscreen Options",
         1,
         null,
         var19,
         var19[var3]
      );
      int var28 = -1;
      if (var27 != null) {
         for (int var29 = 0; var29 < var6; var29++) {
            if (var27.equals(var24[var29])) {
               var28 = var2[var29];
               var3 = var29;
               break;
            }
         }
      }

      if (var28 != -1) {
         try {
            File var30 = new File("" + fpath + "data/full_screen.data");
            BufferedWriter var12 = new BufferedWriter(new FileWriter(var30));
            var12.write("" + var3 + "");
            var12.newLine();
            var12.close();
            Object var31 = null;
         } catch (Exception var15) {
         }

         fullscreen = true;
         frame.dispose();
         frame = new Frame("Fullscreen Need for Madness");
         frame.setBackground(new Color(0, 0, 0));
         frame.setUndecorated(true);
         frame.setResizable(false);
         frame.setExtendedState(6);
         frame.setIgnoreRepaint(true);
         frame.add("Center", applet);
         frame.show();
         if (myDevice.isFullScreenSupported()) {
            try {
               myDevice.setFullScreenWindow(frame);
            } catch (Exception var14) {
            }

            if (myDevice.isDisplayChangeSupported()) {
               try {
                  myDevice.setDisplayMode(var0[var28]);
               } catch (Exception var13) {
               }
            }
         }

         applet.requestFocus();
      }
   }

   public static void exitfullscreen() {
      frame.dispose();
      frame = new Frame("Need for Madness");
      frame.setBackground(new Color(0, 0, 0));
      frame.setIgnoreRepaint(true);
      frame.setIconImage(Toolkit.getDefaultToolkit().createImage("" + fpath + "data/icon.gif"));
      frame.addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent var1) {
            Madness.exitsequance();
         }
      });
      frame.add("Center", applet);
      frame.show();
      if (myDevice.isFullScreenSupported()) {
         try {
            myDevice.setDisplayMode(defdisp);
         } catch (Exception var2) {
         }

         if (myDevice.isDisplayChangeSupported()) {
            try {
               myDevice.setFullScreenWindow(null);
            } catch (Exception var1) {
            }
         }
      }

      frame.setMinimumSize(new Dimension(930, 586));
      frame.setSize(800, 586);
      frame.setExtendedState(6);
      applet.requestFocus();
      fullscreen = false;
   }

   public static void exitsequance() {
      if (updateon == 0 || updateon == 3) {
         if (endadv == 1) {
            endadv = 2;
         }

         if (updateon != 3) {
            applet.stop();
         }

         frame.removeAll();

         try {
            Thread.sleep(200L);
         } catch (Exception var1) {
         }

         applet.destroy();
         applet = null;
         System.exit(0);
      }
   }

   public static void checknupdate(int var0) {
      String var1 = "";
      boolean var2 = true;
      boolean var3 = false;
      String var4 = "";
      int var5 = 0;
      String[] var6 = new String[100];
      String[] var7 = new String[100];

      while (var2) {
         var2 = false;

         try {
            URL var8 = new URL("http://multiplayer.needformadness.com/update/" + var0 + ".txt");
            var8.openConnection().setConnectTimeout(5000);
            var1 = var8.openConnection().getContentType();
            if (var1.equals("text/plain")) {
               DataInputStream var9 = new DataInputStream(var8.openStream());
               String var10 = "";

               while ((var10 = var9.readLine()) != null) {
                  var10 = var10.trim();
                  if (var10.startsWith("maddapp")) {
                     var4 = getfuncSvalue("maddapp", var10, 0);
                     var3 = true;
                     var2 = true;
                  }

                  if (var10.startsWith("file") && var5 < 100) {
                     var6[var5] = getfuncSvalue("file", var10, 0);
                     var7[var5] = getfuncSvalue("file", var10, 1);
                     var5++;
                     var2 = true;
                  }
               }
            }

            var0++;
         } catch (Exception var19) {
            var1 = "";
         }
      }

      if (var3 || var5 != 0) {
         updateon = 1;
         frame.dispose();

         while (inisetup) {
         }

         applet.stop();
         applet.destroy();
         if (fullscreen && myDevice.isFullScreenSupported()) {
            try {
               myDevice.setDisplayMode(defdisp);
            } catch (Exception var18) {
            }

            if (myDevice.isDisplayChangeSupported()) {
               try {
                  myDevice.setFullScreenWindow(null);
               } catch (Exception var17) {
               }
            }
         }

         frame = new Frame("Updating Need for Madness...");
         frame.setBackground(new Color(234, 240, 247));
         frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent var1) {
               Madness.exitsequance();
            }
         });
         applet = new update();
         frame.add("Center", applet);
         frame.show();
         frame.setSize(800, 300);
         frame.setResizable(false);
         frame.setLocation(
            (int)((Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 800.0) / 2.0),
            (int)((Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 300.0) / 2.0)
         );
         applet.init();
         applet.start();
         if (var5 != 0) {
            for (int var22 = 0; var22 < var5; var22++) {
               try {
                  upfile = "Downloading and updating file: " + var7[var22] + "";
                  updateon = 2;
                  URL var24 = new URL(var6[var22]);
                  int var28 = var24.openConnection().getContentLength();
                  DataInputStream var11 = new DataInputStream(var24.openStream());
                  byte[] var12 = new byte[var28];
                  var11.readFully(var12);
                  File var13 = new File("" + fpath + "" + var7[var22] + "");
                  FileOutputStream var14 = new FileOutputStream(var13);
                  var14.write(var12);
                  var14.close();
                  Object var51 = null;
                  var11.close();
                  Object var31 = null;
               } catch (Exception var16) {
               }
            }
         }

         if (var3) {
            try {
               upfile = "Downloading and updating game's code";
               updateon = 2;
               URL var23 = new URL(var4);
               int var25 = var23.openConnection().getContentLength();
               DataInputStream var29 = new DataInputStream(var23.openStream());
               byte[] var32 = new byte[var25];
               var29.readFully(var32);
               File var33 = new File("" + fpath + "madapp.jar");
               if (var33.exists()) {
                  FileOutputStream var39 = new FileOutputStream(var33);
                  var39.write(var32);
                  var39.close();
                  Object var40 = null;
               }

               var33 = new File("" + fpath + "madapps.jar");
               if (var33.exists()) {
                  FileOutputStream var41 = new FileOutputStream(var33);
                  var41.write(var32);
                  var41.close();
                  Object var42 = null;
               }

               var33 = new File("" + fpath + "data/madapp.jar");
               if (var33.exists()) {
                  FileOutputStream var43 = new FileOutputStream(var33);
                  var43.write(var32);
                  var43.close();
                  Object var44 = null;
               }

               var33 = new File("" + fpath + "data/madapps.jar");
               if (var33.exists()) {
                  FileOutputStream var45 = new FileOutputStream(var33);
                  var45.write(var32);
                  var45.close();
                  Object var46 = null;
               }

               var33 = new File("" + fpath + "Madness.app/Contents/Java/madapp.jar");
               if (var33.exists()) {
                  FileOutputStream var47 = new FileOutputStream(var33);
                  var47.write(var32);
                  var47.close();
                  Object var48 = null;
               }

               var33 = new File("" + fpath + "Game.jar");
               FileOutputStream var49 = new FileOutputStream(var33);
               var49.write(var32);
               var49.close();
               Object var50 = null;
               var29.close();
               Object var30 = null;
            } catch (Exception var15) {
            }
         }

         updateon = 3;
      }
   }

   public static void carmaker() {
      applet.stop();
      frame.removeAll();

      try {
         Thread.sleep(400L);
      } catch (Exception var2) {
      }

      applet.destroy();
      applet = null;
      System.gc();
      System.runFinalization();

      try {
         Thread.sleep(400L);
      } catch (Exception var1) {
      }

      applet = new CarMaker();
      frame.add("Center", applet);
      frame.show();
      applet.init();
      applet.start();
   }

   public static void stagemaker() {
      applet.stop();
      frame.removeAll();

      try {
         Thread.sleep(400L);
      } catch (Exception var2) {
      }

      applet.destroy();
      applet = null;
      System.gc();
      System.runFinalization();

      try {
         Thread.sleep(400L);
      } catch (Exception var1) {
      }

      applet = new StageMaker();
      frame.add("Center", applet);
      frame.show();
      applet.init();
      applet.start();
   }

   public static void game() {
      applet.stop();
      frame.removeAll();

      try {
         Thread.sleep(400L);
      } catch (Exception var2) {
      }

      applet.destroy();
      applet = null;
      System.gc();
      System.runFinalization();

      try {
         Thread.sleep(400L);
      } catch (Exception var1) {
      }

      applet = new GameSparker();
      frame.add("Center", applet);
      frame.show();
      applet.init();
      applet.start();
   }

   public static void advopen() {
      try {
         File var0 = new File("" + fpath + "data/user.data");
         if (var0.exists()) {
            Date var1 = new Date();
            long var2 = var1.getTime();
            if (advtime == 0L || var2 - advtime > 120000L) {
               String var4 = System.getProperty("os.name").toLowerCase();
               if (var4.indexOf("win") != -1) {
                  File var5 = new File("" + fpath + "data/adv.bat");
                  boolean var6 = false;
                  if (!var5.exists()) {
                     var6 = true;
                  } else if (var5.length() != 81L) {
                     var6 = true;
                  }

                  if (var6) {
                     BufferedWriter var7 = new BufferedWriter(new FileWriter(var5));
                     var7.write("cd %programfiles%\\Internet Explorer");
                     var7.newLine();
                     var7.write("iexplore -k http://www.needformadness.com/");
                     var7.newLine();
                     var7.close();
                     Object var10 = null;
                  }

                  Process var11 = Runtime.getRuntime().exec(var5.getAbsolutePath());
                  DataInputStream var8 = new DataInputStream(var11.getInputStream());

                  while (var8.readLine() != null) {
                  }
               } else {
                  openurl("http://www.needformadness.com/");
               }

               advtime = var2;
               endadv = 1;
            }
         }
      } catch (Exception var9) {
      }
   }

   public static String urlopen() {
      String var0 = "explorer";
      String var1 = System.getProperty("os.name").toLowerCase();
      if (var1.indexOf("linux") != -1 || var1.indexOf("unix") != -1 || var1.equals("aix")) {
         var0 = "xdg-open";
      }

      if (var1.indexOf("mac") != -1) {
         var0 = "open";
      }

      return var0;
   }

   public static void openurl(String var0) {
      if (Desktop.isDesktopSupported()) {
         try {
            Desktop.getDesktop().browse(new URI(var0));
         } catch (Exception var3) {
         }
      } else {
         try {
            Runtime.getRuntime().exec("" + urlopen() + " " + var0 + "");
         } catch (Exception var2) {
         }
      }
   }

   public static String getfuncSvalue(String var0, String var1, int var2) {
      String var3 = "";
      int var4 = 0;

      for (int var5 = var0.length() + 1; var5 < var1.length() && var4 <= var2; var5++) {
         String var6 = "" + var1.charAt(var5);
         if (var6.equals(",") || var6.equals(")")) {
            var4++;
         } else if (var4 == var2) {
            var3 = var3 + var6;
         }
      }

      return var3;
   }
}
