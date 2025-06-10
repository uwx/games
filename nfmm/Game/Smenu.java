import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

public class Smenu {
   int sel = 0;
   String[] opts;
   String[] sopts;
   int no = 0;
   int x = 0;
   int y = 0;
   Font font = new Font("Arial", 1, 13);
   Color bcol = new Color(255, 255, 255);
   Color fcol = new Color(0, 0, 0);
   int w = 0;
   int h = 0;
   FontMetrics ftm;
   boolean show = false;
   boolean open = false;
   boolean dis = false;
   int maxl = 0;
   boolean rooms = false;
   int[] iroom;
   int kmoused = 0;
   boolean alphad = false;
   boolean revup = false;
   boolean carsel = false;
   boolean flksel = false;
   boolean om = false;
   boolean onsc = false;
   int scro = 0;
   int scra = 0;

   public Smenu(int var1) {
      this.opts = new String[var1];
      this.sopts = new String[var1];
   }

   public void add(Graphics2D var1, String var2) {
      var1.setFont(this.font);
      this.ftm = var1.getFontMetrics();
      if ((!this.rooms || this.no == 0) && this.ftm.stringWidth(var2) + 30 > this.w) {
         this.w = this.ftm.stringWidth(var2) + 30;
      }

      if (this.rooms) {
         this.iroom = new int[7];

         for (int var3 = 0; var3 < 7; var3++) {
            this.iroom[var3] = 0;
         }
      }

      this.opts[this.no] = var2;
      if (this.maxl != 0) {
         int var5 = var2.length();

         while (this.ftm.stringWidth(var2.substring(0, var5)) + 30 > this.maxl) {
            var5--;
         }

         if (var5 != var2.length()) {
            var2 = var2.substring(0, var5 - 3);
            var2 = var2 + "...";
         }
      }

      this.sopts[this.no] = var2;
      if (this.no < this.opts.length - 1) {
         this.no++;
      }
   }

   public void addw(String var1, String var2) {
      this.w = 300;
      this.opts[this.no] = var2;
      this.sopts[this.no] = var1;
      if (this.no < this.opts.length - 1) {
         this.no++;
      }
   }

   public void addstg(String var1) {
      if (this.ftm.stringWidth(var1) + 30 > this.w) {
         this.w = this.ftm.stringWidth(var1) + 30;
      }

      this.no++;
      if (this.no > 701) {
         this.no = 701;
      }

      for (int var2 = this.no - 1; var2 > 1; var2--) {
         this.opts[var2] = this.opts[var2 - 1];
         this.sopts[var2] = this.sopts[var2 - 1];
      }

      this.opts[1] = var1;
      this.sopts[1] = var1;
   }

   public void removeAll() {
      this.no = 0;
      this.w = 0;
      this.sel = 0;
   }

   public void select(int var1) {
      if (var1 >= 0 && var1 < this.no) {
         this.sel = var1;
      }
   }

   public void select(String var1) {
      for (int var2 = 0; var2 < this.no; var2++) {
         if (this.opts[var2].equals(var1)) {
            this.sel = var2;
            break;
         }
      }
   }

   public int getSelectedIndex() {
      return this.sel;
   }

   public String getSelectedItem() {
      return this.opts[this.sel];
   }

   public String getItem(int var1) {
      String var2 = "";
      if (var1 >= 0 && var1 < this.no) {
         var2 = this.opts[var1];
      }

      return var2;
   }

   public int getItemCount() {
      return this.no;
   }

   public void remove(String var1) {
      for (int var2 = 0; var2 < this.no; var2++) {
         if (this.opts[var2].equals(var1)) {
            for (int var3 = var2; var3 < this.no; var3++) {
               if (var3 != this.no - 1) {
                  this.opts[var3] = this.opts[var3 + 1];
                  this.sopts[var3] = this.sopts[var3 + 1];
               }
            }

            this.no--;
            break;
         }
      }
   }

   public void setSize(int var1, int var2) {
      this.w = var1;
      this.h = var2;
   }

   public int getWidth() {
      return this.w;
   }

   public void setFont(Font var1) {
      this.font = var1;
   }

   public void setBackground(Color var1) {
      this.bcol = var1;
   }

   public void setForeground(Color var1) {
      this.fcol = var1;
   }

   public Color getBackground() {
      return this.bcol;
   }

   public Color getForeground() {
      return this.fcol;
   }

   public void hide() {
      this.show = false;
      this.open = false;
   }

   public void show() {
      this.show = true;
   }

   public boolean isShowing() {
      return this.show;
   }

   public void move(int var1, int var2) {
      this.x = var1;
      this.y = var2;
   }

   public boolean hasFocus() {
      return false;
   }

   public void disable() {
      this.dis = true;
   }

   public void enable() {
      this.dis = false;
   }

   public boolean isEnabled() {
      return !this.dis;
   }

   public boolean draw(Graphics2D var1, int var2, int var3, boolean var4, int var5, boolean var6) {
      boolean var7 = false;
      if (this.revup) {
         if (var6) {
            var6 = false;
         } else {
            var6 = true;
         }

         this.revup = false;
      }

      if (this.show) {
         if (this.alphad) {
            var1.setComposite(AlphaComposite.getInstance(3, 0.7F));
         }

         boolean var8 = false;
         if (var4) {
            if (!this.om) {
               this.om = true;
               var8 = true;
            }
         } else if (this.om) {
            this.om = false;
         }

         boolean var9 = false;
         if ((this.bcol.getRed() + this.bcol.getGreen() + this.bcol.getBlue()) / 3 > (this.fcol.getRed() + this.fcol.getGreen() + this.fcol.getBlue()) / 3) {
            var9 = true;
         }

         boolean var10 = false;
         if (var2 > this.x && var2 < this.x + this.w && var3 > this.y + 1 && var3 < this.y + 22 && !this.open && !this.dis) {
            var10 = true;
         }

         if (!this.open && var10 && var8 && !this.dis) {
            this.open = true;
            var8 = false;
         }

         var1.setFont(this.font);
         this.ftm = var1.getFontMetrics();
         if (!this.open) {
            if (this.scro != 0) {
               this.scro = 0;
            }

            if (this.scra != 0) {
               this.scra = 0;
            }
         } else {
            int var11 = 4 + (this.ftm.getHeight() + 2) * this.no;
            if (!var6) {
               byte var12 = 0;
               var1.setColor(this.bcol);
               var1.fillRect(this.x, this.y + 23, this.w, var11);
               var1.setColor(
                  new Color(
                     (this.fcol.getRed() + this.bcol.getRed()) / 2,
                     (this.fcol.getGreen() + this.bcol.getGreen()) / 2,
                     (this.fcol.getBlue() + this.bcol.getBlue()) / 2
                  )
               );
               var1.drawRect(this.x, this.y + 23, this.w, var11);
               if (this.y + 23 + var11 > var5) {
                  var1.drawLine(this.x + this.w - 18, this.y + 17, this.x + this.w - 18, var5);
                  if (var9) {
                     var1.setColor(new Color((this.bcol.getRed() + 510) / 3, (this.bcol.getGreen() + 510) / 3, (this.bcol.getBlue() + 510) / 3));
                  } else {
                     var1.setColor(new Color((this.fcol.getRed() + 510) / 3, (this.fcol.getGreen() + 510) / 3, (this.fcol.getBlue() + 510) / 3));
                  }

                  var1.fillRect(this.x + this.w - 15, this.y + 25 + this.scra, 13, 30);
                  var1.setColor(this.fcol);
                  var1.drawRect(this.x + this.w - 15, this.y + 25 + this.scra, 12, 30);
                  var1.setColor(new Color(0, 0, 0));
                  var1.drawLine(this.x + this.w - 12, this.y + 9 + 29 + this.scra, this.x + this.w - 12, this.y + 10 + 29 + this.scra);
                  var1.drawLine(this.x + this.w - 11, this.y + 10 + 29 + this.scra, this.x + this.w - 11, this.y + 11 + 29 + this.scra);
                  var1.drawLine(this.x + this.w - 10, this.y + 11 + 29 + this.scra, this.x + this.w - 10, this.y + 12 + 29 + this.scra);
                  var1.drawLine(this.x + this.w - 9, this.y + 12 + 29 + this.scra, this.x + this.w - 9, this.y + 13 + 29 + this.scra);
                  var1.drawLine(this.x + this.w - 8, this.y + 11 + 29 + this.scra, this.x + this.w - 8, this.y + 12 + 29 + this.scra);
                  var1.drawLine(this.x + this.w - 7, this.y + 10 + 29 + this.scra, this.x + this.w - 7, this.y + 11 + 29 + this.scra);
                  var1.drawLine(this.x + this.w - 6, this.y + 9 + 29 + this.scra, this.x + this.w - 6, this.y + 10 + 29 + this.scra);
                  var12 = -18;
                  if (var4) {
                     if (var2 > this.x + this.w - 18 && var2 < this.x + this.w && var3 > this.y + 25 && var3 < var5) {
                        var8 = false;
                        this.onsc = true;
                     }
                  } else if (this.onsc) {
                     this.onsc = false;
                  }

                  if (this.onsc) {
                     this.scra = var3 - (this.y + 25) - 15;
                     if (this.scra < 0) {
                        this.scra = 0;
                     }

                     int var13 = var5 - (this.y + 25) - 33;
                     if (this.scra > var13) {
                        this.scra = var13;
                     }

                     int var14 = this.no * (this.ftm.getHeight() + 2) - var13 - this.ftm.getHeight() / 2;
                     this.scro = -((int)(this.scra * ((float)var14 / var13)));
                  }
               }

               for (int var16 = 0; var16 < this.no; var16++) {
                  if (Math.abs(this.scro) < (var16 + 1) * (this.ftm.getHeight() + 2)) {
                     var1.setColor(this.fcol);
                     if (var2 > this.x
                        && var2 < this.x + this.w
                        && var3 > this.y + 25 + this.scro + var16 * (this.ftm.getHeight() + 2)
                        && var3 < this.y + 25 + this.scro + (var16 + 1) * (this.ftm.getHeight() + 2)) {
                        if (var9) {
                           var1.setColor(
                              new Color(
                                 (this.fcol.getRed() + this.bcol.getRed()) / 2,
                                 (this.fcol.getGreen() + this.bcol.getGreen()) / 2,
                                 (this.fcol.getBlue() + this.bcol.getBlue()) / 2
                              )
                           );
                        } else {
                           var1.setColor(this.fcol);
                        }

                        var1.fillRect(this.x + 1, this.y + 25 + this.scro + var16 * (this.ftm.getHeight() + 2), this.w - 1 + var12, this.ftm.getHeight() + 2);
                        var1.setColor(this.bcol);
                        if (var8) {
                           if (this.rooms && this.opts[var16].equals("full")) {
                              this.kmoused = 20;
                           } else {
                              this.sel = var16;
                              if (this.rooms && var16 != 0) {
                                 this.sopts[var16] = " ";
                              }
                           }

                           this.open = false;
                        }
                     }

                     if (this.rooms && this.sopts[var16].indexOf("10 / 10") != -1) {
                        var1.setColor(new Color(255, 0, 0));
                     }

                     var1.drawString(this.sopts[var16], this.x + 4, this.y + 38 + this.scro + var16 * (this.ftm.getHeight() + 2));
                  }
               }

               if (var12 != 0) {
                  var1.setColor(
                     new Color(
                        (this.fcol.getRed() + this.bcol.getRed()) / 2,
                        (this.fcol.getGreen() + this.bcol.getGreen()) / 2,
                        (this.fcol.getBlue() + this.bcol.getBlue()) / 2
                     )
                  );
                  var1.drawLine(this.x, var5 - 1, this.x + this.w, var5 - 1);
               }
            } else {
               byte var15 = 0;
               var1.setColor(this.bcol);
               var1.fillRect(this.x, this.y - var11, this.w, var11);
               var1.setColor(
                  new Color(
                     (this.fcol.getRed() + this.bcol.getRed()) / 2,
                     (this.fcol.getGreen() + this.bcol.getGreen()) / 2,
                     (this.fcol.getBlue() + this.bcol.getBlue()) / 2
                  )
               );
               var1.drawRect(this.x, this.y - var11, this.w, var11);
               if (this.y - var11 < 0) {
                  var1.drawLine(this.x + this.w - 18, 0, this.x + this.w - 18, this.y);
                  if (var9) {
                     var1.setColor(new Color((this.bcol.getRed() + 510) / 3, (this.bcol.getGreen() + 510) / 3, (this.bcol.getBlue() + 510) / 3));
                  } else {
                     var1.setColor(new Color((this.fcol.getRed() + 510) / 3, (this.fcol.getGreen() + 510) / 3, (this.fcol.getBlue() + 510) / 3));
                  }

                  var1.fillRect(this.x + this.w - 15, this.y - this.scra - 33, 13, 30);
                  var1.setColor(this.fcol);
                  var1.drawRect(this.x + this.w - 15, this.y - this.scra - 33, 12, 30);
                  var1.setColor(new Color(0, 0, 0));
                  var1.drawLine(this.x + this.w - 12, this.y + 13 - 29 - this.scra, this.x + this.w - 12, this.y + 12 - 29 - this.scra);
                  var1.drawLine(this.x + this.w - 11, this.y + 12 - 29 - this.scra, this.x + this.w - 11, this.y + 11 - 29 - this.scra);
                  var1.drawLine(this.x + this.w - 10, this.y + 11 - 29 - this.scra, this.x + this.w - 10, this.y + 10 - 29 - this.scra);
                  var1.drawLine(this.x + this.w - 9, this.y + 10 - 29 - this.scra, this.x + this.w - 9, this.y + 9 - 29 - this.scra);
                  var1.drawLine(this.x + this.w - 8, this.y + 11 - 29 - this.scra, this.x + this.w - 8, this.y + 10 - 29 - this.scra);
                  var1.drawLine(this.x + this.w - 7, this.y + 12 - 29 - this.scra, this.x + this.w - 7, this.y + 11 - 29 - this.scra);
                  var1.drawLine(this.x + this.w - 6, this.y + 13 - 29 - this.scra, this.x + this.w - 6, this.y + 12 - 29 - this.scra);
                  var15 = -18;
                  if (var4) {
                     if (var2 > this.x + this.w - 18 && var2 < this.x + this.w && var3 > 0 && var3 < this.y - 3) {
                        var8 = false;
                        this.onsc = true;
                     }
                  } else if (this.onsc) {
                     this.onsc = false;
                  }

                  if (this.onsc) {
                     this.scra = this.y - 3 - 15 - var3;
                     if (this.scra < 0) {
                        this.scra = 0;
                     }

                     int var17 = this.y - 35;
                     if (this.scra > var17) {
                        this.scra = var17;
                     }

                     int var19 = this.no * (this.ftm.getHeight() + 2) - var17 - this.ftm.getHeight() / 2;
                     this.scro = (int)(this.scra * ((float)var19 / var17));
                  }
               }

               for (int var18 = 0; var18 < this.no; var18++) {
                  if (Math.abs(this.scro) < (var18 + 1) * (this.ftm.getHeight() + 2)) {
                     var1.setColor(this.fcol);
                     if (var2 > this.x
                        && var2 < this.x + this.w
                        && var3 < this.y - 18 + this.scro - (var18 - 1) * (this.ftm.getHeight() + 2)
                        && var3 > this.y - 18 + this.scro - var18 * (this.ftm.getHeight() + 2)) {
                        if (var9) {
                           var1.setColor(
                              new Color(
                                 (this.fcol.getRed() + this.bcol.getRed()) / 2,
                                 (this.fcol.getGreen() + this.bcol.getGreen()) / 2,
                                 (this.fcol.getBlue() + this.bcol.getBlue()) / 2
                              )
                           );
                        } else {
                           var1.setColor(this.fcol);
                        }

                        var1.fillRect(this.x + 1, this.y - 18 + this.scro - var18 * (this.ftm.getHeight() + 2), this.w - 1 + var15, this.ftm.getHeight() + 2);
                        var1.setColor(this.bcol);
                        if (var8) {
                           this.sel = var18;
                           this.open = false;
                        }
                     }

                     var1.drawString(this.sopts[var18], this.x + 4, this.y - 5 + this.scro - var18 * (this.ftm.getHeight() + 2));
                  }
               }

               if (var15 != 0) {
                  var1.setColor(
                     new Color(
                        (this.fcol.getRed() + this.bcol.getRed()) / 2,
                        (this.fcol.getGreen() + this.bcol.getGreen()) / 2,
                        (this.fcol.getBlue() + this.bcol.getBlue()) / 2
                     )
                  );
                  var1.drawLine(this.x, 0, this.x + this.w, 0);
               }
            }

            var7 = true;
            if (var8) {
               this.open = false;
            }
         }

         if (var10) {
            if (var9) {
               var1.setColor(
                  new Color(
                     (this.fcol.getRed() + this.bcol.getRed()) / 2,
                     (this.fcol.getGreen() + this.bcol.getGreen()) / 2,
                     (this.fcol.getBlue() + this.bcol.getBlue()) / 2
                  )
               );
            } else {
               var1.setColor(this.fcol);
            }
         } else {
            var1.setColor(this.bcol);
         }

         var1.fillRect(this.x, this.y + 1, this.w, 21);
         var1.setColor(
            new Color(
               (this.fcol.getRed() + this.bcol.getRed()) / 2,
               (this.fcol.getGreen() + this.bcol.getGreen()) / 2,
               (this.fcol.getBlue() + this.bcol.getBlue()) / 2
            )
         );
         var1.drawRect(this.x, this.y + 1, this.w, 21);
         if (var9) {
            var1.setColor(new Color((this.bcol.getRed() + 255) / 2, (this.bcol.getGreen() + 255) / 2, (this.bcol.getBlue() + 255) / 2));
         } else {
            var1.setColor(new Color((this.fcol.getRed() + 255) / 2, (this.fcol.getGreen() + 255) / 2, (this.fcol.getBlue() + 255) / 2));
         }

         var1.drawRect(this.x + 1, this.y + 2, this.w - 2, 19);
         var1.drawLine(this.x + this.w - 17, this.y + 3, this.x + this.w - 17, this.y + 20);
         var1.setColor(this.fcol);
         if (this.dis) {
            var1.setColor(
               new Color(
                  (this.fcol.getRed() + this.bcol.getRed() * 2) / 3,
                  (this.fcol.getGreen() + this.bcol.getGreen() * 2) / 3,
                  (this.fcol.getBlue() + this.bcol.getBlue() * 2) / 3
               )
            );
         }

         var1.drawRect(this.x + this.w - 16, this.y + 3, 14, 17);
         if (var9) {
            var1.setColor(new Color((this.bcol.getRed() + 510) / 3, (this.bcol.getGreen() + 510) / 3, (this.bcol.getBlue() + 510) / 3));
         } else {
            var1.setColor(new Color((this.fcol.getRed() + 510) / 3, (this.fcol.getGreen() + 510) / 3, (this.fcol.getBlue() + 510) / 3));
         }

         var1.fillRect(this.x + this.w - 15, this.y + 4, 13, 16);
         var1.setColor(new Color(0, 0, 0));
         if (this.dis) {
            var1.setColor(
               new Color(
                  (this.fcol.getRed() + this.bcol.getRed() * 2) / 3,
                  (this.fcol.getGreen() + this.bcol.getGreen() * 2) / 3,
                  (this.fcol.getBlue() + this.bcol.getBlue() * 2) / 3
               )
            );
         }

         var1.drawLine(this.x + this.w - 12, this.y + 9, this.x + this.w - 12, this.y + 10);
         var1.drawLine(this.x + this.w - 11, this.y + 10, this.x + this.w - 11, this.y + 11);
         var1.drawLine(this.x + this.w - 10, this.y + 11, this.x + this.w - 10, this.y + 12);
         var1.drawLine(this.x + this.w - 9, this.y + 12, this.x + this.w - 9, this.y + 13);
         var1.drawLine(this.x + this.w - 8, this.y + 11, this.x + this.w - 8, this.y + 12);
         var1.drawLine(this.x + this.w - 7, this.y + 10, this.x + this.w - 7, this.y + 11);
         var1.drawLine(this.x + this.w - 6, this.y + 9, this.x + this.w - 6, this.y + 10);
         if (var10) {
            var1.setColor(this.bcol);
         } else {
            var1.setColor(this.fcol);
         }

         if (this.dis) {
            var1.setColor(
               new Color(
                  (this.fcol.getRed() + this.bcol.getRed() * 2) / 3,
                  (this.fcol.getGreen() + this.bcol.getGreen() * 2) / 3,
                  (this.fcol.getBlue() + this.bcol.getBlue() * 2) / 3
               )
            );
         }

         if (this.carsel && !var10) {
            if (this.flksel) {
               var1.setColor(new Color(240, 240, 240));
               this.flksel = false;
            } else {
               this.flksel = true;
            }
         }

         var1.drawString(this.sopts[this.sel], this.x + 4, this.y + this.ftm.getHeight() + 2);
         if (this.alphad) {
            var1.setComposite(AlphaComposite.getInstance(3, 1.0F));
         }
      } else {
         if (this.scro != 0) {
            this.scro = 0;
         }

         if (this.scra != 0) {
            this.scra = 0;
         }
      }

      return var7;
   }
}
