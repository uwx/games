import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class UDPMistro implements Runnable {
   Thread runner;
   int runon = 0;
   udpOnline[] udpc = new udpOnline[20];
   int porturn = 0;
   udpServe[] usrv = new udpServe[13];
   int diledelay = 0;
   long sendat = 0L;
   String sendcheck = "";
   int delay = 0;
   int[] ldelays = new int[5];
   int diled = 0;
   int rate = 30;
   float freg = 0.0F;
   boolean go = false;
   int im = 0;
   int nplayers = 0;
   String[][] info = new String[14][3];
   int[][] frame = new int[14][3];
   int[] lframe = new int[8];
   int[] force = new int[8];
   int[] lcframe = new int[8];
   boolean[] isbot = new boolean[8];
   Socket socket;
   BufferedReader din;
   PrintWriter dout;
   int[] gocnt = new int[8];
   int[] out = new int[8];
   String xtserver = "";
   int xtservport = 0;
   int pgame = 0;
   int wx = 0;

   public void UDPConnectOnline(String var1, int var2, int var3, int var4) {
      this.diledelay = 0;
      this.delay = 0;

      for (int var5 = 0; var5 < 5; var5++) {
         this.ldelays[var5] = 0;
      }

      this.diled = 0;
      this.go = false;
      this.freg = 0.0F;
      this.im = var4;
      this.nplayers = var3;

      for (int var7 = 0; var7 < 8; var7++) {
         for (int var6 = 0; var6 < 3; var6++) {
            this.frame[var7][var6] = -1;
            this.info[var7][var6] = "";
         }

         this.isbot[var7] = false;
         this.lframe[var7] = 0;
         this.force[var7] = 0;
         this.lcframe[var7] = 0;
      }

      for (int var8 = 0; var8 < 20; var8++) {
         this.udpc[var8] = new udpOnline(this, var1, var2 + this.im, var8, this.porturn);
      }

      if (this.porturn == 0) {
         this.porturn = 20;
      } else {
         this.porturn = 0;
      }

      if (this.im >= this.nplayers) {
         this.frame[this.im][0] = 11111;
         this.info[this.im][0] = "watching";

         while (this.info[this.im][0].length() < 110) {
            this.info[this.im][0] = this.info[this.im][0] + "|";
         }

         this.nplayers++;
         this.go = true;
      }

      this.runon = 1;
      this.runner = new Thread(this);
      this.runner.start();
   }

   public void UDPConnectLan(String var1, int var2, int var3) {
      this.diledelay = 0;
      this.delay = 0;

      for (int var4 = 0; var4 < 5; var4++) {
         this.ldelays[var4] = 0;
      }

      this.diled = 0;
      this.go = false;
      this.freg = 0.0F;
      this.im = var3;
      this.nplayers = var2;

      for (int var7 = 0; var7 < 8; var7++) {
         for (int var5 = 0; var5 < 3; var5++) {
            this.frame[var7][var5] = -1;
            this.info[var7][var5] = "";
         }

         this.isbot[var7] = false;
         this.lframe[var7] = 0;
         this.force[var7] = 0;
         this.lcframe[var7] = 0;
      }

      if (this.im != 0) {
         for (int var8 = 0; var8 < 20; var8++) {
            this.udpc[var8] = new udpOnline(this, var1, 7060 + this.im, var8, this.porturn);
         }

         if (this.porturn == 0) {
            this.porturn = 20;
         } else {
            this.porturn = 0;
         }

         if (this.im >= this.nplayers) {
            this.frame[this.im][0] = 11111;
            this.info[this.im][0] = "watching";

            while (this.info[this.im][0].length() < 110) {
               this.info[this.im][0] = this.info[this.im][0] + "|";
            }

            this.nplayers++;
            this.go = true;
         }

         this.runon = 1;
      } else {
         try {
            this.socket = new Socket(this.xtserver, this.xtservport);
            this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            this.dout = new PrintWriter(this.socket.getOutputStream(), true);
         } catch (Exception var6) {
         }

         this.runon = 4;
      }

      this.runner = new Thread(this);
      this.runner.start();
   }

   public void UDPLanServer(int var1, String var2, int var3, int var4) {
      this.xtserver = var2;
      this.xtservport = var3;
      this.pgame = var4;

      for (int var5 = 0; var5 < 8; var5++) {
         this.gocnt[var5] = 3;
         this.out[var5] = 0;

         for (int var6 = 0; var6 < 3; var6++) {
            this.frame[var5][var6] = -1;
            this.info[var5][var6] = "";
         }

         this.lframe[var5] = 0;
         this.force[var5] = 0;
         this.lcframe[var5] = 0;
      }

      for (int var7 = 0; var7 < this.nplayers + 5; var7++) {
         this.usrv[var7] = new udpServe(this, var7 + 1);
      }
   }

   public void UDPquit() {
      if (this.runon == 1) {
         this.runon = 2;
      }

      if (this.runon == 4) {
         this.runon = 5;
      }
   }

   @Override
   public void run() {
      int var1 = 0;

      while (this.runon == 1) {
         if (!this.udpc[0].started) {
            this.udpc[0].spark();
            var1 = 1;
         } else {
            Date var2 = new Date();
            if (var1 > this.delay / this.rate && var2.getTime() - this.udpc[0].sendat > this.rate - 5) {
               this.udpc[0].spark();
               var1 = 1;
            }
         }

         if (this.delay > this.rate && var1 <= this.delay / this.rate && var1 >= 1 && var1 < 20) {
            Date var16 = new Date();
            long var3 = var16.getTime() - this.udpc[var1 - 1].sendat;
            if (var3 >= this.rate - 5 && var3 < this.rate * 2) {
               this.udpc[var1].spark();
               var1++;
            }
         }

         if (this.diled == 10) {
            for (int var17 = 0; var17 < 20; var17++) {
               if (this.udpc[var17].started) {
                  Date var19 = new Date();
                  long var4 = var19.getTime() - this.udpc[var17].sendat;
                  if (var4 > this.delay * 1.5 && var4 > this.rate) {
                     this.udpc[var17].stomp();
                  }
               }
            }
         }

         if (this.diledelay > 0) {
            this.diledelay--;
         }

         try {
            Thread.sleep(5L);
         } catch (InterruptedException var15) {
         }
      }

      byte var18 = 0;
      int var20 = 0;

      while (this.runon == 4) {
         for (int var21 = 0; var21 < this.nplayers; var21++) {
            boolean var5 = false;
            if (this.info[var21][0].length() > 16) {
               String var6 = "" + this.info[var21][0].charAt(15);
               if (!var6.equals("0")) {
                  var5 = true;
               }
            }

            if (!var5 && this.out[var21] == 77) {
               this.out[var21] = 0;
            }

            if (this.out[var21] < 76) {
               if (this.frame[var21][0] > 6) {
                  if (this.lcframe[var21] != this.frame[var21][0] && !var5) {
                     this.lcframe[var21] = this.frame[var21][0];
                     this.out[var21] = 0;
                  } else {
                     if (this.out[var21] < 70) {
                        this.out[var21] = 71;
                     }

                     this.out[var21]++;
                     if (var5) {
                        this.out[var21] = 77;
                     }

                     if (this.out[var21] == 76) {
                        this.info[var21][0] = "disco";
                        this.frame[var21][0] = this.frame[var21][0] + 10;
                     }
                  }
               } else {
                  this.out[var21]++;
                  if (this.out[var21] == 30) {
                     this.frame[var21][0] = 7;
                  }
               }
            }
         }

         if (var20 == 10) {
            String var22 = "3|" + this.pgame + "|alive|";
            String var24 = "";
            if (var18 == 0) {
               try {
                  this.dout.println(var22);
                  var24 = this.din.readLine();
                  if (var24 == null) {
                     var18 = 1;
                  }
               } catch (Exception var14) {
                  var18 = 1;
               }
            }

            if (var18 == 1) {
               try {
                  this.socket.close();
                  this.socket = null;
                  this.din.close();
                  this.din = null;
                  this.dout.close();
                  this.dout = null;
               } catch (Exception var13) {
               }

               try {
                  this.socket = new Socket(this.xtserver, this.xtservport);
                  this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                  this.dout = new PrintWriter(this.socket.getOutputStream(), true);
                  this.dout.println(var22);
                  var24 = this.din.readLine();
                  if (var24 != null) {
                     var18 = 0;
                  }
               } catch (Exception var12) {
               }
            }

            if (var18 == 1) {
               try {
                  this.socket.close();
                  this.socket = null;
               } catch (Exception var11) {
               }

               var18 = 2;
            }

            var20 = 0;
         } else {
            var20++;
         }

         try {
            Thread.sleep(1000L);
         } catch (InterruptedException var10) {
         }
      }

      int var23 = 0;

      while (this.runon == 2) {
         int var27 = 0;

         for (int var30 = 0; var30 < 20; var30++) {
            if (!this.udpc[var30].started) {
               var27++;
            }
         }

         if (var27 != 20) {
            var23++;
         }

         if (var23 == 400 || var27 == 20) {
            for (int var31 = 0; var31 < 20; var31++) {
               this.udpc[var31].closeSocket();
               this.udpc[var31] = null;
            }

            this.runon = 3;
         }

         try {
            Thread.sleep(5L);
         } catch (InterruptedException var9) {
         }
      }

      if (this.runon == 3) {
         System.gc();
         System.runFinalization();
         this.runon = 0;
         this.runner = null;
      }

      if (this.runon == 5) {
         for (int var28 = 0; var28 < this.nplayers + 2; var28++) {
            try {
               this.usrv[var28].stopServe();
               this.usrv[var28] = null;
            } catch (Exception var8) {
            }
         }

         String var29 = "3|" + this.pgame + "|finish|";

         try {
            this.dout.println(var29);
            String var32 = this.din.readLine();
            this.socket.close();
            this.socket = null;
            this.din.close();
            this.din = null;
            this.dout.close();
            this.dout = null;
         } catch (Exception var7) {
         }

         System.gc();
         System.runFinalization();
         this.runon = 0;
         this.runner = null;
      }
   }

   public void readinfo(Mad var1, ContO var2, Control var3, int var4, int[] var5) {
      if (this.go && this.force[var4] != 7 && !this.isbot[var4]) {
         this.freg = (float)(this.freg + 0.05);
         int var6 = -1;
         if (var6 == -1) {
            for (int var7 = 0; var7 < 3; var7++) {
               if (this.frame[var4][var7] == this.lframe[var4] + 1) {
                  var6 = var7;
                  if (var7 == 1) {
                     this.freg = (float)(this.freg - 0.1);
                  }

                  if (var7 == 2) {
                     this.freg = (float)(this.freg - 0.15);
                  }
               }
            }
         }

         if (var6 == -1) {
            int var10 = 0;

            for (int var8 = 0; var8 < 3; var8++) {
               if (this.frame[var4][var8] > this.lframe[var4] + 1) {
                  var10++;
               }
            }

            if (var10 == 3) {
               var6 = 2;
            }
         }

         if (var6 == -1 && this.force[var4] == 1) {
            for (int var11 = 0; var11 < 3; var11++) {
               if (this.frame[var4][var11] >= this.lframe[var4]) {
                  var6 = var11;
               }
            }

            if (var6 == -1) {
               this.freg = (float)(this.freg + 0.2);
            }
         }

         if (this.freg < -15.0F) {
            this.freg = -15.0F;
         }

         if (this.freg > 0.0F) {
            this.freg = 0.0F;
         }

         if (var6 != -1) {
            this.force[var4] = 0;
            String var12 = this.info[var4][var6];
            String var13 = this.getSvalue(var12, 0);
            if (var13.length() == 16) {
               String var9 = "";
               var9 = "" + var13.charAt(0);
               if (var9.equals("0")) {
                  var3.left = false;
               } else {
                  var3.left = true;
               }

               var9 = "" + var13.charAt(1);
               if (var9.equals("0")) {
                  var3.right = false;
               } else {
                  var3.right = true;
               }

               var9 = "" + var13.charAt(2);
               if (var9.equals("0")) {
                  var3.up = false;
               } else {
                  var3.up = true;
               }

               var9 = "" + var13.charAt(3);
               if (var9.equals("0")) {
                  var3.down = false;
               } else {
                  var3.down = true;
               }

               var9 = "" + var13.charAt(4);
               if (var9.equals("0")) {
                  var3.handb = false;
               } else {
                  var3.handb = true;
               }

               var9 = "" + var13.charAt(5);
               if (var9.equals("0")) {
                  var1.newcar = false;
               } else {
                  var1.newcar = true;
               }

               var9 = "" + var13.charAt(6);
               if (var9.equals("0")) {
                  var1.mtouch = false;
               } else {
                  var1.mtouch = true;
               }

               var9 = "" + var13.charAt(7);
               if (var9.equals("0")) {
                  var1.wtouch = false;
               } else {
                  var1.wtouch = true;
               }

               var9 = "" + var13.charAt(8);
               if (var9.equals("0")) {
                  var1.pushed = false;
               } else {
                  var1.pushed = true;
               }

               var9 = "" + var13.charAt(9);
               if (var9.equals("0")) {
                  var1.gtouch = false;
               } else {
                  var1.gtouch = true;
               }

               var9 = "" + var13.charAt(10);
               if (var9.equals("0")) {
                  var1.pl = false;
               } else {
                  var1.pl = true;
               }

               var9 = "" + var13.charAt(11);
               if (var9.equals("0")) {
                  var1.pr = false;
               } else {
                  var1.pr = true;
               }

               var9 = "" + var13.charAt(12);
               if (var9.equals("0")) {
                  var1.pd = false;
               } else {
                  var1.pd = true;
               }

               var9 = "" + var13.charAt(13);
               if (var9.equals("0")) {
                  var1.pu = false;
               } else {
                  var1.pu = true;
               }

               var9 = "" + var13.charAt(14);
               if (var9.equals("0")) {
                  var1.dest = false;
               } else {
                  var1.dest = true;
               }
            } else if (var13.equals("disco")) {
               var5[var4] = 3;
               var1.hitmag = var1.cd.maxmag[var1.cn] + 100;
               this.force[var4] = 7;
            }

            if (this.force[var4] != 7) {
               int var29 = this.getncoms(var12);
               this.wx = 0;
               if (var29 > 1) {
                  var2.x = this.getvalue(var12, 1);
               }

               if (var29 > 2) {
                  var2.y = this.getvalue(var12, 0);
               }

               if (var29 > 3) {
                  var2.z = this.getvalue(var12, 0);
               }

               if (var29 > 4) {
                  var2.xz = this.getvalue(var12, 0);
               }

               if (var29 > 5) {
                  var2.xy = this.getvalue(var12, 0);
               }

               if (var29 > 6) {
                  var2.zy = this.getvalue(var12, 0);
               }

               if (var29 > 7) {
                  var1.speed = this.getvalue(var12, 0) / 100.0F;
               }

               if (var29 > 8) {
                  var1.power = this.getvalue(var12, 0) / 100.0F;
               }

               if (var29 > 9) {
                  var1.mxz = this.getvalue(var12, 0);
               }

               if (var29 > 10) {
                  var1.pzy = this.getvalue(var12, 0);
               }

               if (var29 > 11) {
                  var1.pxy = this.getvalue(var12, 0);
               }

               if (var29 > 12) {
                  var1.txz = this.getvalue(var12, 0);
               }

               if (var29 > 13) {
                  var1.loop = this.getvalue(var12, 0);
               }

               if (var29 > 14) {
                  var2.wxz = this.getvalue(var12, 0);
               }

               if (var29 > 15) {
                  var1.pcleared = this.getvalue(var12, 0);
               }

               if (var29 > 16) {
                  var1.clear = this.getvalue(var12, 0);
               }

               if (var29 > 17) {
                  var1.nlaps = this.getvalue(var12, 0);
               }

               if (var29 > 18) {
                  var1.hitmag = (int)(this.getvalue(var12, 0) / 100.0F * var1.cd.maxmag[var1.cn]);
               }
            }

            this.lframe[var4] = this.frame[var4][var6];
         } else if (this.force[var4] == 0) {
            this.lframe[var4]++;
            this.force[var4] = 1;
         }
      }
   }

   public void readContOinfo(ContO var1, int var2) {
      if (this.go && this.force[var2] == 1 && !this.isbot[var2]) {
         int var3 = -2;
         if (var3 == -2) {
            for (int var4 = 0; var4 < 3; var4++) {
               if (this.frame[var2][var4] == this.lframe[var2] + 1) {
                  var3 = -1;
               }
            }
         }

         if (var3 == -1) {
            for (int var6 = 0; var6 < 3; var6++) {
               if (this.frame[var2][var6] == this.lframe[var2]) {
                  var3 = var6;
               }
            }
         }

         if (var3 > 0) {
            String var7 = this.info[var2][var3];
            int var5 = this.getncoms(var7);
            this.wx = 0;
            if (var5 > 1) {
               var1.x = this.getvalue(var7, 1);
            }

            if (var5 > 1) {
               var1.y = this.getvalue(var7, 0);
            }

            if (var5 > 1) {
               var1.z = this.getvalue(var7, 0);
            }

            if (var5 > 1) {
               var1.xz = this.getvalue(var7, 0);
            }

            if (var5 > 1) {
               var1.xy = this.getvalue(var7, 0);
            }

            if (var5 > 1) {
               var1.zy = this.getvalue(var7, 0);
            }
         }
      }
   }

   public void setinfo(Mad var1, ContO var2, Control var3, int var4, float var5, boolean var6, int var7) {
      this.info[var7][0] = "";
      if (var3.left) {
         this.info[var7][0] = this.info[var7][0] + "1";
      } else {
         this.info[var7][0] = this.info[var7][0] + "0";
      }

      if (var3.right) {
         this.info[var7][0] = this.info[var7][0] + "1";
      } else {
         this.info[var7][0] = this.info[var7][0] + "0";
      }

      if (var3.up) {
         this.info[var7][0] = this.info[var7][0] + "1";
      } else {
         this.info[var7][0] = this.info[var7][0] + "0";
      }

      if (var3.down) {
         this.info[var7][0] = this.info[var7][0] + "1";
      } else {
         this.info[var7][0] = this.info[var7][0] + "0";
      }

      if (var3.handb) {
         this.info[var7][0] = this.info[var7][0] + "1";
      } else {
         this.info[var7][0] = this.info[var7][0] + "0";
      }

      if (var1.newcar) {
         this.info[var7][0] = this.info[var7][0] + "1";
      } else {
         this.info[var7][0] = this.info[var7][0] + "0";
      }

      if (var1.mtouch) {
         this.info[var7][0] = this.info[var7][0] + "1";
      } else {
         this.info[var7][0] = this.info[var7][0] + "0";
      }

      if (var1.wtouch) {
         this.info[var7][0] = this.info[var7][0] + "1";
      } else {
         this.info[var7][0] = this.info[var7][0] + "0";
      }

      if (var1.pushed) {
         this.info[var7][0] = this.info[var7][0] + "1";
      } else {
         this.info[var7][0] = this.info[var7][0] + "0";
      }

      if (var1.gtouch) {
         this.info[var7][0] = this.info[var7][0] + "1";
      } else {
         this.info[var7][0] = this.info[var7][0] + "0";
      }

      if (var1.pl) {
         this.info[var7][0] = this.info[var7][0] + "1";
      } else {
         this.info[var7][0] = this.info[var7][0] + "0";
      }

      if (var1.pr) {
         this.info[var7][0] = this.info[var7][0] + "1";
      } else {
         this.info[var7][0] = this.info[var7][0] + "0";
      }

      if (var1.pd) {
         this.info[var7][0] = this.info[var7][0] + "1";
      } else {
         this.info[var7][0] = this.info[var7][0] + "0";
      }

      if (var1.pu) {
         this.info[var7][0] = this.info[var7][0] + "1";
      } else {
         this.info[var7][0] = this.info[var7][0] + "0";
      }

      if (var1.dest) {
         this.info[var7][0] = this.info[var7][0] + "1";
      } else {
         this.info[var7][0] = this.info[var7][0] + "0";
      }

      if (var6) {
         this.info[var7][0] = this.info[var7][0] + "1";
      } else {
         this.info[var7][0] = this.info[var7][0] + "0";
      }

      this.info[var7][0] = this.info[var7][0]
         + ","
         + var2.x
         + ","
         + var2.y
         + ","
         + var2.z
         + ","
         + var2.xz
         + ","
         + var2.xy
         + ","
         + var2.zy
         + ","
         + (int)(var1.speed * 100.0F)
         + ","
         + (int)(var1.power * 100.0F)
         + ","
         + var1.mxz
         + ","
         + var1.pzy
         + ","
         + var1.pxy
         + ","
         + var1.txz
         + ","
         + var1.loop
         + ","
         + var2.wxz
         + ","
         + var1.pcleared
         + ","
         + var1.clear
         + ","
         + var1.nlaps
         + ","
         + (int)(var5 * 100.0F)
         + ","
         + var4
         + ",";

      while (this.info[var7][0].length() < 110) {
         this.info[var7][0] = this.info[var7][0] + "|";
      }

      if (this.runon == 2) {
         var1.hitmag = var1.cd.maxmag[var1.cn] + 100;
      }

      this.frame[var7][0]++;
   }

   public int getvalue(String var1, int var2) {
      int var3 = -1;

      try {
         int var4 = 0;
         byte var5 = 0;
         String var6 = "";
         String var7 = "";

         while (this.wx < var1.length() && var5 != 2) {
            var6 = "" + var1.charAt(this.wx);
            if (var6.equals(",")) {
               if (var5 == 1 || ++var4 > var2) {
                  var5 = 2;
               }
            } else if (var4 == var2) {
               var7 = var7 + var6;
               var5 = 1;
            }

            this.wx++;
         }

         if (var7.equals("")) {
            var7 = "-1";
         }

         var3 = Integer.valueOf(var7);
      } catch (Exception var8) {
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
            if (var7.equals(",")) {
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

   public int getncoms(String var1) {
      int var2 = 0;
      int var3 = 0;

      for (String var4 = ""; var3 < var1.length(); var3++) {
         var4 = "" + var1.charAt(var3);
         if (var4.equals(",")) {
            var2++;
         }
      }

      return var2;
   }
}
