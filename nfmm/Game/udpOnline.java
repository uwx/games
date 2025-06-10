import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

public class udpOnline implements Runnable {
   Thread con;
   UDPMistro um;
   int gameport = 7001;
   InetAddress IPAddress;
   DatagramSocket dSocket;
   long sendat = 0L;
   boolean started = false;
   boolean errd = false;
   int nu = 0;

   public udpOnline(UDPMistro var1, String var2, int var3, int var4, int var5) {
      this.um = var1;
      this.gameport = var3;
      this.nu = var4;

      try {
         this.dSocket = new DatagramSocket(7010 + var5 + this.nu);
         this.errd = false;
         this.IPAddress = InetAddress.getByName(var2);
      } catch (Exception var7) {
         System.out.println("Error preparing for UDP Connection: " + var7);
      }
   }

   public void spark() {
      if (this.errd) {
         try {
            this.dSocket = new DatagramSocket(7020 + this.nu);
            this.errd = false;
         } catch (Exception var3) {
         }
      }

      try {
         this.con = new Thread(this);
         this.con.start();
      } catch (Exception var2) {
      }
   }

   public void closeSocket() {
      try {
         this.dSocket.close();
      } catch (Exception var2) {
      }

      this.dSocket = null;
      this.errd = true;
      if (this.con != null) {
         this.con.stop();
         this.con = null;
      }

      this.started = false;
   }

   public void stomp() {
      if (this.con != null) {
         this.con.stop();
         this.con = null;
      }

      this.started = false;
   }

   @Override
   public void run() {
      this.started = true;
      Date var1 = new Date();
      this.sendat = var1.getTime();
      String var2 = "";
      if (!this.um.go) {
         var2 = "MAGNITUDE";
      }

      if (this.nu == 0 && this.um.diledelay == 0) {
         this.um.sendat = this.sendat;
         String var17 = "" + this.sendat;
         var2 = var17.substring(var17.length() - 3, var17.length());
         this.um.sendcheck = var2;
         this.um.diledelay = 100;
      }

      try {
         byte[] var3 = new byte[4];
         DatagramPacket var4 = new DatagramPacket(var3, var3.length, this.IPAddress, this.gameport);
         String var5 = "" + var2 + "|" + this.um.im + "|" + this.um.frame[this.um.im][0] + "|" + this.um.info[this.um.im][0] + "|";
         byte[] var6 = var5.getBytes();
         var4.setData(var6);
         this.dSocket.send(var4);

         for (int var7 = 0; var7 < this.um.nplayers - 1; var7++) {
            this.dSocket.receive(var4);
            String var8 = new String(var4.getData());
            if ((this.nu == 0 || !this.um.go) && var7 == 0) {
               var2 = this.getSvalue(var8, 0);
               if (!this.um.go && var2.equals("1111111")) {
                  this.um.go = true;
               }
            }

            int var9 = this.getvalue(var8, 1);
            if (var9 >= 0 && var9 < this.um.nplayers) {
               int var10 = this.getvalue(var8, 2);
               int var11 = 0;

               for (int var12 = 0; var12 < 3; var12++) {
                  if (var10 != this.um.frame[var9][var12]) {
                     var11++;
                  }
               }

               if (var11 == 3) {
                  for (int var20 = 0; var20 < 3; var20++) {
                     if (var10 > this.um.frame[var9][var20]) {
                        for (int var13 = 2; var13 >= var20 + 1; var13--) {
                           this.um.frame[var9][var13] = this.um.frame[var9][var13 - 1];
                           this.um.info[var9][var13] = this.um.info[var9][var13 - 1];
                        }

                        this.um.frame[var9][var20] = var10;
                        this.um.info[var9][var20] = this.getSvalue(var8, 3);
                        var20 = 3;
                     }
                  }
               }
            }
         }

         if (this.nu == 0 && this.um.diledelay != 0 && this.um.sendcheck.equals(var2)) {
            var1 = new Date();

            for (int var18 = 4; var18 > 0; var18--) {
               this.um.ldelays[var18] = this.um.ldelays[var18 - 1];
            }

            this.um.ldelays[0] = (int)(var1.getTime() - this.um.sendat);
            this.um.delay = 0;

            for (int var19 = 0; var19 < 5; var19++) {
               if (this.um.ldelays[var19] != 0 && (this.um.delay == 0 || this.um.ldelays[var19] < this.um.delay)) {
                  this.um.delay = this.um.ldelays[var19];
               }
            }

            this.um.diledelay = 0;
            if (this.um.diled != 10) {
               this.um.diled++;
            }
         }
      } catch (Exception var15) {
         try {
            this.dSocket.close();
         } catch (Exception var14) {
         }

         this.dSocket = null;
         this.errd = true;
      }

      this.started = false;
      this.con = null;
   }

   public int getvalue(String var1, int var2) {
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

   public String getSvalue(String var1, int var2) {
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
}
