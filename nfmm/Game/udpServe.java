import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class udpServe implements Runnable {
   Thread servo;
   DatagramSocket dSocket;
   UDPMistro um;
   int mport = 7060;
   int im = 0;
   int[] lsframe = new int[]{-1, -1, -1, -1, -1, -1, -1, -1};

   public udpServe(UDPMistro var1, int var2) {
      this.um = var1;
      this.im = var2;
      this.mport = 7060 + this.im;
      this.servo = new Thread(this);
      this.servo.start();
   }

   public void stopServe() {
      try {
         this.dSocket.close();
         this.dSocket = null;
      } catch (Exception var2) {
      }

      if (this.servo != null) {
         this.servo.stop();
         this.servo = null;
      }
   }

   @Override
   public void run() {
      try {
         this.dSocket = new DatagramSocket(this.mport);
         byte[] var1 = new byte[128];

         while (true) {
            DatagramPacket var2 = new DatagramPacket(var1, var1.length);
            this.dSocket.receive(var2);
            String var3 = new String(var2.getData());
            String var4 = this.getSvalue(var3, 0);
            int var5 = this.getvalue(var3, 1);
            if (var5 == this.im && this.im < this.um.nplayers && this.um.out[var5] != 76) {
               int var6 = this.getvalue(var3, 2);
               int var7 = 0;

               for (int var8 = 0; var8 < 3; var8++) {
                  if (var6 != this.um.frame[var5][var8]) {
                     var7++;
                  }
               }

               if (var7 == 3) {
                  for (int var16 = 0; var16 < 3; var16++) {
                     if (var6 > this.um.frame[var5][var16]) {
                        for (int var9 = 2; var9 >= var16 + 1; var9--) {
                           this.um.frame[var5][var9] = this.um.frame[var5][var9 - 1];
                           this.um.info[var5][var9] = this.um.info[var5][var9 - 1];
                        }

                        this.um.frame[var5][var16] = var6;
                        this.um.info[var5][var16] = this.getSvalue(var3, 3);
                        var16 = 3;
                     }
                  }
               }

               if (this.um.gocnt[var5] != 0) {
                  int var17 = 0;

                  for (int var20 = 0; var20 < this.um.nplayers; var20++) {
                     if (this.um.frame[var20][0] >= 0) {
                        var17++;
                     }
                  }

                  if (var17 == this.um.nplayers) {
                     var4 = "1111111";
                     this.um.gocnt[var5]--;
                  }
               }

               if (!this.um.go) {
                  int var18 = 0;

                  for (int var21 = 0; var21 < this.um.nplayers; var21++) {
                     if (this.um.frame[var21][0] >= 0) {
                        var18++;
                     }
                  }

                  if (var18 == this.um.nplayers) {
                     this.um.gocnt[0]--;
                  }

                  if (this.um.gocnt[0] <= 1) {
                     this.um.go = true;
                  }
               }
            }

            InetAddress var14 = var2.getAddress();
            int var15 = var2.getPort();

            for (int var19 = 0; var19 < this.um.nplayers; var19++) {
               if (var19 != this.im) {
                  int var22 = -1;

                  for (int var10 = 0; var10 < 3; var10++) {
                     if (this.um.frame[var19][var10] == this.lsframe[var19] + 1) {
                        var22 = var10;
                     }
                  }

                  if (var22 == -1) {
                     for (int var23 = 0; var23 < 3; var23++) {
                        if (this.um.frame[var19][var23] > this.lsframe[var19]) {
                           var22 = var23;
                        }
                     }
                  }

                  if (var22 == -1) {
                     var22 = 0;
                  }

                  this.lsframe[var19] = this.um.frame[var19][var22];
                  String var24 = "" + var4 + "|" + var19 + "|" + this.um.frame[var19][var22] + "|" + this.um.info[var19][var22] + "|";
                  byte[] var11 = var24.getBytes();
                  DatagramPacket var12 = new DatagramPacket(var11, var11.length, var14, var15);
                  this.dSocket.send(var12);
               }
            }
         }
      } catch (Exception var13) {
      }
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
