import java.applet.Applet;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Event;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

public class update extends Applet implements Runnable {
   Graphics2D rd;
   FontMetrics ftm;
   Image offImage;
   Thread gamer;
   int xm = 0;
   int ym = 0;
   boolean moused = false;
   int scur = 0;

   @Override
   public void run() {
      int var1 = 0;
      int var2 = 0;
      boolean var3 = false;

      while (!var3) {
         byte var4 = 0;
         this.rd.setColor(new Color(234, 240, 247));
         this.rd.fillRect(0, 0, 800, 300);
         this.rd.setColor(new Color(0, 0, 0));
         this.rd.setFont(new Font("Arial", 1, 15));
         this.ftm = this.rd.getFontMetrics();
         this.rd.drawString("Need for Madness Update", 400 - this.ftm.stringWidth("Need for Madness Update") / 2, 30);
         this.rd.setFont(new Font("Arial", 1, 13));
         if (Madness.updateon == 1 || Madness.updateon == 2) {
            this.rd.drawString("The game has just been updated!  Please wait while the game updates itself.", 30, 70);
         }

         if (Madness.updateon == 3) {
            this.rd.drawString("Successfully finished updating.  Now you can close this window and start the game again.", 30, 70);
         }

         if (Madness.updateon == 2) {
            this.rd.setFont(new Font("Arial", 0, 13));
            this.rd.drawString(Madness.upfile, 30, 95);
            this.rd.setColor(new Color(71, 95, 120));
            this.rd.drawRect(50, 105, 700, 20);
            this.rd.fillRect(52, 107, var1, 17);
            if (++var1 > 697) {
               var1 = 0;
            }
         }

         if (Madness.updateon == 3) {
            this.rd.setFont(new Font("Arial", 0, 13));
            this.rd.drawString("Game update complete.", 30, 95);
            this.rd.setColor(new Color(71, 95, 120));
            this.rd.drawRect(50, 105, 700, 20);
            this.rd.fillRect(52, 107, 697, 17);
         }

         this.rd.setColor(new Color(0, 0, 0));
         this.rd.setFont(new Font("Arial", 1, 13));
         this.ftm = this.rd.getFontMetrics();
         this.rd.drawString("To learn more about this update, visit the game's development blog!", 30, 210);
         this.rd.setColor(new Color(71, 95, 120));
         this.rd.drawString("http://multiplayer.needformadness.com/development.html", 30, 232);
         int var5 = this.ftm.stringWidth("http://multiplayer.needformadness.com/development.html") + 30;
         this.rd.drawLine(30, 235, var5, 235);
         if (this.xm > 30 && this.xm < var5 && this.ym > 218 && this.ym < 237) {
            var4 = 12;
            if (this.moused) {
               Madness.openurl("http://multiplayer.needformadness.com/development.html");
            }
         }

         if (Madness.updateon == 3) {
            this.rd.drawString("Close updater to finish >", 400 - this.ftm.stringWidth("Close updater to finish >") / 2, 165);
            int var6 = 400 - this.ftm.stringWidth("Close updater to finish >") / 2;
            var5 = this.ftm.stringWidth("Close updater to finish >") + var6;
            this.rd.drawLine(var6, 167, var5, 167);
            if (this.xm > var6 && this.xm < var5 && this.ym > 150 && this.ym < 169) {
               var4 = 12;
               if (this.moused) {
                  Madness.exitsequance();
                  var3 = true;
               }
            }
         } else {
            this.rd.drawString(":: : : : : : : : : : : : : : : : : : : ::", 400 - this.ftm.stringWidth(":: : : : : : : : : : : : : : : : : : : ::") / 2, 165);
         }

         if (Madness.updateon == 3) {
            if (++var2 == 1000) {
               Madness.exitsequance();
            }
         }

         if (var4 != this.scur) {
            this.setCursor(new Cursor(var4));
            this.scur = var4;
         }

         if (this.moused) {
            this.moused = false;
         }

         this.repaint();

         try {
            Thread.sleep(10L);
         } catch (InterruptedException var7) {
         }
      }
   }

   @Override
   public void init() {
      this.offImage = this.createImage(800, 300);
      if (this.offImage != null) {
         this.rd = (Graphics2D)this.offImage.getGraphics();
      }

      this.rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
   }

   @Override
   public boolean mouseMove(Event var1, int var2, int var3) {
      this.xm = var2;
      this.ym = var3;
      return false;
   }

   @Override
   public boolean mouseUp(Event var1, int var2, int var3) {
      this.xm = var2;
      this.ym = var3;
      this.moused = true;
      return false;
   }

   @Override
   public void start() {
      if (this.gamer == null) {
         this.gamer = new Thread(this);
      }

      this.gamer.start();
   }

   @Override
   public void stop() {
      if (this.gamer != null) {
         this.gamer.stop();
      }

      this.gamer = null;
   }

   @Override
   public void paint(Graphics var1) {
      var1.drawImage(this.offImage, 0, 0, this);
   }

   @Override
   public void update(Graphics var1) {
      this.paint(var1);
   }
}
