import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.UIManager;

public class RunApp extends Panel {
   static Frame frame;
   static GameSparker applet;
   public static ArrayList<Image> icons;

   public static ArrayList<Image> getIcons() {
      if (icons == null) {
         icons = new ArrayList<>();
         int[] resols = new int[]{16, 24, 32, 48, 64};

         for (int res : resols) {
            icons.add(Toolkit.getDefaultToolkit().createImage("data/ico_" + res + ".png"));
         }
      }

      return icons;
   }

   public static void main(String[] strings) {
//      System.runFinalizersOnExit(true);
      System.out.println("Need for Madness 2 - DSmod v1.11");

      try {
         UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      } catch (Exception var2) {
         System.out.println("Could not setup System Look&Feel: " + var2.toString());
      }

      startup();
   }

   public static void restart() {
      applet.stop();
      frame.removeAll();

      try {
         Thread.sleep(200L);
      } catch (Exception var1) {
      }

      applet.destroy();
      applet = null;
      frame.dispose();
      startup();
   }

   static void startup() {
      frame = new Frame("Need for Madness 2 - DSmod: A Nfm2 Modification");
      frame.setBackground(new Color(0, 0, 0));
      frame.setIgnoreRepaint(true);
      frame.setIconImages(getIcons());
      applet = new GameSparker();
      applet.setStub(new DesktopStub());
      frame.addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent windowevent) {
            RunApp.exitsequance();
         }
      });
      applet.setPreferredSize(new Dimension(670, 400));
      frame.add("Center", applet);
      frame.setResizable(false);
      frame.pack();
      frame.setMinimumSize(frame.getSize());
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
      applet.init();
      applet.start();
   }

   public static void exitsequance() {
      applet.stop();
      frame.removeAll();

      try {
         Thread.sleep(200L);
      } catch (Exception var1) {
      }

      applet.destroy();
      applet = null;
      System.exit(0);
   }

   public static String getString(String tag, String str, int id) {
      int k = 0;
      String s3 = "";

      for (int j = tag.length() + 1; j < str.length(); j++) {
         String s2 = "" + str.charAt(j);
         if (s2.equals(",") || s2.equals(")")) {
            k++;
            j++;
         }

         if (k == id) {
            s3 = s3 + str.charAt(j);
         }
      }

      return s3;
   }

   public static int getInt(String tag, String str, int id) {
      return Integer.parseInt(getString(tag, str, id));
   }
}
