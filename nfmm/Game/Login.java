import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.TextField;
import java.awt.image.ImageObserver;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.util.Date;

public class Login implements Runnable {
   Graphics2D rd;
   xtGraphics xt;
   Medium m;
   FontMetrics ftm;
   ImageObserver ob;
   GameSparker gs;
   int nmsgs = 0;
   int nconf = 0;
   int nfreq = 0;
   int ncreq = 0;
   int fclan = 0;
   int fplayer = 0;
   String clanapv = "";
   boolean justlog = false;
   int cntgame = 0;
   int gamec = -1;
   int groom = 0;
   String gmaker = "";
   String gservern = "";
   Thread connector;
   int fase = 0;
   Socket socket;
   BufferedReader din;
   PrintWriter dout;
   boolean[] pessd = new boolean[]{false, false, false, false, false, false};
   int[] bx = new int[]{0, 0, 0, 0, 0, 0};
   int[] by = new int[]{0, 0, 0, 0, 0, 0};
   int[] bw = new int[]{0, 0, 0, 0, 0, 0};
   int btn = 0;
   int nflk = 0;
   int ncnt = 0;
   int errcnt = 0;
   int lrgfase = 0;
   String msg = "";
   String lnick = "";
   String lpass = "";
   String lemail = "";
   boolean onf = false;
   boolean nickero = false;
   boolean jflk = false;
   boolean ond = false;
   int opselect = 0;
   int trans = 0;
   int cntcl = 0;
   boolean contrb = false;
   int nservers = 1;
   String[] servers = new String[]{"69.195.146.194", "avenger.needformadness.com", "ghostrider.needformadness.com"};
   InetAddress[] IPAddress = new InetAddress[3];
   DatagramSocket[] dSocket = new DatagramSocket[3];
   int[] serverdone = new int[]{-1, -1, -1};
   long[] servestart = new long[]{0L, 0L, 0L};
   String[] snames = new String[]{"Dominion", "Avenger", "Ghostrider"};
   boolean socketson = false;
   int srvtrn = 0;
   int[] rmps = new int[]{0, 0, 0, 0, 0};
   int[] rmwt = new int[]{0, 0, 0, 0, 0};
   int recom = 0;
   boolean resofaso = false;
   boolean checknote = false;
   int pend = 0;
   boolean pendb = false;
   boolean gotcai = false;
   int cax = 0;
   int cay = 0;
   boolean btroom = false;
   boolean showtf = false;
   int[] bgmy = new int[]{0, 400, 800};
   int flipo = 0;
   int xrl = 0;
   int xrr = 0;
   boolean onr = false;
   int oxm = 0;
   int oym = 0;
   int lxm = 0;
   int lym = 0;

   public Login(Medium var1, Graphics2D var2, xtGraphics var3, GameSparker var4) {
      this.m = var1;
      this.rd = var2;
      this.xt = var3;
      this.gs = var4;
      if (this.xt.playingame != -1) {
         this.fase = 18;
      }

      if (this.xt.nofull) {
         this.nservers = 1;
      }
   }

   public void inishmulti() {
      this.gs.tnick.hide();
      this.gs.tnick.enable();
      this.gs.tnick.setForeground(new Color(0, 0, 0));
      this.gs.tnick.setBackground(this.color2k(240, 240, 240));
      this.gs.tpass.hide();
      this.gs.tpass.enable();
      this.gs.tpass.setForeground(new Color(0, 0, 0));
      this.gs.tpass.setBackground(this.color2k(240, 240, 240));
      this.gs.temail.hide();
      this.gs.temail.enable();
      this.gs.temail.setForeground(new Color(0, 0, 0));
      this.gs.temail.setBackground(this.color2k(240, 240, 240));
      this.gs.keplo.hide();
      this.gs.keplo.enable();
      this.gs.keplo.setForeground(new Color(0, 0, 0));
      this.gs.keplo.setBackground(new Color(193, 181, 142));
      this.gs.requestFocus();
      if (this.gs.tnick.getText().equals("")) {
         this.gs.tnick.setText("Nickname");
      }

      for (int var1 = 0; var1 < 6; var1++) {
         this.pessd[var1] = false;
      }

      this.nflk = 0;
      this.ncnt = 0;
      this.errcnt = 0;
      this.onf = false;
      this.ond = false;
      this.msg = "";
      this.btroom = false;
      this.gotcai = false;
      this.m.crs = true;
      this.m.x = -335;
      this.m.y = 0;
      this.m.z = -50;
      this.m.xz = 0;
      this.m.zy = 20;
      this.m.ground = -2000;
      this.pend = 0;
      this.pendb = false;
      this.resofaso = false;

      for (int var2 = 0; var2 < this.nservers; var2++) {
         this.serverdone[var2] = -1;
         this.servestart[var2] = 0L;
      }

      this.checknote = false;
      if (this.xt.gotlog) {
         this.checknote = true;
         this.socketson = false;
         this.fase = 12;
         this.connector = new Thread(this);
         this.connector.start();
      } else {
         this.msg = "Login to access the multiplayer madness!";
         this.gs.tnick.setText(this.xt.nickname);
         this.fase = 3;
      }
   }

   public void exitfromlobby() {
      if (!this.xt.lan) {
         this.opselect = 0;
      } else {
         this.opselect = 1;
      }

      for (int var1 = 0; var1 < this.nservers; var1++) {
         this.serverdone[var1] = -1;
         this.servestart[var1] = 0L;
      }

      for (int var2 = 0; var2 < 6; var2++) {
         this.pessd[var2] = false;
      }

      this.gotcai = false;
      this.btroom = false;
      this.m.crs = true;
      this.m.x = -335;
      this.m.y = 0;
      this.m.z = -50;
      this.m.xz = 0;
      this.m.zy = 20;
      this.m.ground = -2000;
      this.pend = 0;
      this.pendb = false;
      this.gamec = -1;
      this.socketson = false;
      if (!this.xt.lan) {
         this.msg = "| Connecting to Servers |";
         this.trans = 0;
         this.fase = 13;
         this.nflk = 0;
      } else {
         this.fase = 12;
      }

      System.gc();
      this.connector = new Thread(this);
      this.connector.start();
   }

   public void endcons() {
      for (int var1 = 0; var1 < this.nservers; var1++) {
         try {
            this.dSocket[var1].close();
            this.dSocket[var1] = null;
         } catch (Exception var4) {
         }
      }

      try {
         this.socket.close();
         this.socket = null;
         this.din.close();
         this.din = null;
         this.dout.close();
         this.dout = null;
      } catch (Exception var3) {
      }
   }

   public void checknotifcations() {
      int var1 = 0;
      int var2 = 0;
      int var3 = 0;
      int var4 = 0;
      int var5 = 0;
      String var6 = "";
      int var7 = 0;

      try {
         URL var8 = new URL("http://multiplayer.needformadness.com/profiles/" + this.xt.nickname + "/notify.txt?req=" + (int)(Math.random() * 1000.0) + "");
         var8.openConnection().setConnectTimeout(2000);
         String var9 = var8.openConnection().getContentType();
         if (var9.equals("text/plain")) {
            DataInputStream var10 = new DataInputStream(var8.openStream());
            String var11 = "";

            for (int var12 = 0; (var11 = var10.readLine()) != null && var12 < 5; var12++) {
               var11 = var11.trim();
               if (var12 == 0) {
                  for (String var13 = this.getSvalue(var11, var1); !var13.equals(""); var13 = this.getSvalue(var11, ++var1)) {
                     if (var13.startsWith("clan: ")) {
                        var2++;
                     } else if (!var13.startsWith("your clan")) {
                        var3++;
                     }
                  }
               }

               if (var12 == 1) {
                  int var20 = 0;

                  try {
                     var20 = Integer.valueOf(var11);
                  } catch (Exception var16) {
                     var20 = 0;
                  }

                  var4 = var20;
               }

               if (var12 == 2) {
                  int var22 = 0;

                  try {
                     var22 = Integer.valueOf(var11);
                  } catch (Exception var15) {
                     var22 = 0;
                  }

                  var5 = var22;
               }

               if (var12 == 3) {
                  var6 = this.getSvalue(var11, 0);
               }

               if (var12 == 4) {
                  String var24 = this.getSvalue(var11, var7);

                  while (!var24.equals("")) {
                     var24 = this.getSvalue(var11, ++var7);
                  }
               }
            }

            var10.close();
         }
      } catch (Exception var17) {
      }

      this.nmsgs = var1;
      this.fclan = var2;
      this.fplayer = var3;
      this.nfreq = var4;
      this.nconf = var5;
      this.clanapv = var6;
      this.ncreq = var7;
   }

   public void gamealert() {
      try {
         this.socket = new Socket(this.servers[0], 7061);
         this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
         this.dout = new PrintWriter(this.socket.getOutputStream(), true);
         this.dout.println("101|20|" + this.xt.nickname + "|" + this.xt.nickey + "|" + this.xt.servername + "|" + (this.xt.servport - 7070) + "|");
         String var1 = this.din.readLine();
         this.socket.close();
         this.din.close();
         this.dout.close();
      } catch (Exception var2) {
      }
   }

   public void checkgamealerts() {
      try {
         this.socket = new Socket(this.servers[0], 7061);
         this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
         this.dout = new PrintWriter(this.socket.getOutputStream(), true);
         this.dout.println("101|21|");
         String var1 = this.din.readLine();
         if (var1 != null) {
            int var2 = this.getvalue(var1, 0);
            if (var2 != -1 && var2 != this.gamec) {
               String var3 = this.getSvalue(var1, 2);
               int var4 = this.getvalue(var1, 3);
               boolean var5 = false;
               if (!var3.equals(this.xt.servername) || var4 != this.xt.servport - 7070) {
                  for (int var6 = 0; var6 < this.nservers; var6++) {
                     if (var3.equals(this.snames[var6]) && this.xt.delays[var6] < 300) {
                        var5 = true;
                     }
                  }
               }

               if (var5) {
                  this.gmaker = this.getSvalue(var1, 1);
                  if (this.gmaker.equals(this.xt.nickname)) {
                     this.gmaker = "You";
                  }

                  this.groom = var4;
                  this.gservern = var3;
                  this.gamec = var2;
                  this.cntgame = 0;
               }
            }
         }

         this.socket.close();
         this.din.close();
         this.dout.close();
      } catch (Exception var7) {
      }
   }

   @Override
   public void run() {
      if (this.checknote) {
         this.checknotifcations();
         this.checknote = false;
      }

      if (this.fase == 2) {
         this.gs.setCursor(new Cursor(3));
         int var1 = -1;
         int var2 = -1;

         try {
            this.socket = new Socket(this.servers[0], 7061);
            this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            this.dout = new PrintWriter(this.socket.getOutputStream(), true);
            this.dout.println("0|" + this.gs.tnick.getText() + "|");
            String var3 = this.din.readLine();
            if (var3 != null) {
               var1 = this.getvalue(var3, 0);
               if (var1 == 0) {
                  var2 = this.getvalue(var3, 1);
                  this.xt.hours = this.getvalue(var3, 2);
                  this.xt.nickey = this.getSvalue(var3, 3);
               }
            }

            this.socket.close();
            this.din.close();
            this.dout.close();
         } catch (Exception var19) {
         }

         this.gs.tnick.enable();
         if (var1 == -1) {
            this.msg = "Unable to connect to any server at this moment.  Please try again later.";
            this.fase = 1;
         }

         if (var1 == 0) {
            this.xt.nickname = this.gs.tnick.getText();
            if (var2 != -1) {
               this.xt.nfreeplays = var2;
            }

            this.gs.tnick.hide();
            this.gs.tpass.hide();
            this.gs.temail.hide();
            this.gs.keplo.hide();
            this.gs.requestFocus();
            this.xt.logged = false;
            this.fase = 12;
            System.gc();
         }

         if (var1 == 1) {
            this.msg = "This Nickname is being used by someone else right now.  Please use another.";
            this.nickero = true;
            this.gs.tnick.setForeground(new Color(255, 0, 0));
            this.gs.tnick.requestFocus();
            this.errcnt = 30;
            this.fase = 1;
         }

         if (var1 == 2) {
            this.msg = "Nickname registerd.  Please use another or click 'Login' bellow to login to this Nickname.";
            this.nickero = true;
            this.gs.tnick.setForeground(new Color(255, 0, 0));
            this.gs.tnick.requestFocus();
            this.errcnt = 30;
            this.fase = 1;
         }

         this.gs.setCursor(new Cursor(0));
      }

      if (this.fase == 4) {
         this.gs.setCursor(new Cursor(3));
         int var21 = -1;
         int var29 = -1;
         String var34 = "";

         try {
            this.socket = new Socket(this.servers[0], 7061);
            this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            this.dout = new PrintWriter(this.socket.getOutputStream(), true);
            this.dout.println("1|" + this.gs.tnick.getText() + "|" + this.gs.tpass.getText() + "|");
            var34 = this.din.readLine();
            if (var34 != null) {
               var21 = this.getvalue(var34, 0);
               if (var21 == 0 || var21 == 3 || var21 > 10 || var21 == -167) {
                  this.xt.nickey = this.getSvalue(var34, 1);
                  if (var21 != -167) {
                     this.xt.clan = this.getSvalue(var34, 2);
                     this.xt.clankey = this.getSvalue(var34, 3);
                  } else {
                     this.xt.clan = "";
                     this.xt.clankey = "";
                     var29 = this.getvalue(var34, 2);
                     this.xt.hours = this.getvalue(var34, 3);
                  }
               }
            }

            this.socket.close();
            this.din.close();
            this.dout.close();
         } catch (Exception var20) {
            var20.printStackTrace();
         }

         this.gs.tnick.enable();
         this.gs.tpass.enable();
         this.gs.keplo.enable();
         if (var21 == -1) {
            this.msg = "Unable to connect to server at this moment.  Please try again later.";
            this.fase = 3;
         }

         if (var21 == 0 || var21 == 3 || var21 > 10 || var21 == -167 || var21 == 111) {
            this.xt.nickname = this.gs.tnick.getText();
            this.showtf = false;
            this.gs.tnick.hide();
            this.gs.tpass.hide();
            this.gs.temail.hide();
            this.gs.keplo.hide();
            this.gs.requestFocus();
            this.gs.setloggedcookie();
            this.btroom = false;
            this.xt.logged = true;
            this.xt.gotlog = true;
            if (var21 == 0) {
               this.xt.acexp = 0;
            }

            if (var21 > 10) {
               this.xt.acexp = var21 - 10;
            }

            if (var21 == 3) {
               this.xt.acexp = -1;
            }

            if (var21 == -167) {
               this.xt.logged = false;
               if (var29 != -1) {
                  this.xt.nfreeplays = var29;
               }
            }

            if (this.xt.logged) {
               this.xt.backlog = this.xt.nickname;
            }

            this.fase = 12;
            this.justlog = true;
            this.checknotifcations();
            System.gc();
         }

         if (var21 == 1) {
            this.msg = "Sorry.  The Nickname you have entered is incorrect or does not exist.";
            this.gs.tnick.setForeground(new Color(255, 0, 0));
            this.gs.tnick.requestFocus();
            this.errcnt = 40;
            this.fase = 3;
         }

         if (var21 == 2) {
            this.msg = "Sorry.  The Password you have entered is incorrect.";
            this.gs.tpass.setForeground(new Color(255, 0, 0));
            this.gs.tpass.requestFocus();
            this.errcnt = 40;
            this.fase = 3;
         }

         this.gs.setCursor(new Cursor(0));
      }

      if (this.fase == 8) {
         this.gs.setCursor(new Cursor(3));
         int var22 = -1;

         try {
            this.socket = new Socket(this.servers[0], 7061);
            this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            this.dout = new PrintWriter(this.socket.getOutputStream(), true);
            this.dout.println("2|" + this.gs.temail.getText().toLowerCase() + "|");
            String var30 = this.din.readLine();
            if (var30 != null) {
               var22 = this.getvalue(var30, 0);
            }

            this.socket.close();
            this.din.close();
            this.dout.close();
         } catch (Exception var18) {
            var18.printStackTrace();
         }

         this.gs.temail.enable();
         if (var22 == -1) {
            this.msg = "Unable to connect to server at this moment.  Please try again later.";
            this.fase = 7;
         }

         if (var22 == 0) {
            this.showtf = false;
            this.gs.temail.hide();
            this.msg = "Please check your Email: " + this.gs.temail.getText() + " to login.";
            this.gs.temail.setText("");
            this.gs.tnick.setText("");
            this.gs.tpass.setText("");
            this.fase = 3;
         }

         if (var22 == 1) {
            this.msg = "Sorry.  This Email Address does not exist in our system!";
            this.gs.temail.setForeground(new Color(255, 0, 0));
            this.errcnt = 40;
            this.fase = 7;
         }

         this.gs.setCursor(new Cursor(0));
      }

      if ((this.fase == 12 || this.fase == 13 || this.fase == 14 || this.fase == 15) && !this.socketson) {
         for (int var23 = 0; var23 < this.nservers; var23++) {
            try {
               this.serverdone[var23] = -1;
               this.IPAddress[var23] = InetAddress.getByName(this.servers[var23]);
               this.dSocket[var23] = new DatagramSocket(7001 + var23);
            } catch (Exception var17) {
               this.serverdone[var23] = 5;
            }
         }

         this.srvtrn = 0;
         this.socketson = true;
      }

      while (this.fase == 12 || this.fase == 13 || this.fase == 14 || this.fase == 15) {
         if (this.srvtrn < this.nservers) {
            for (; this.serverdone[this.srvtrn] < this.xt.cntptrys; this.serverdone[this.srvtrn]++) {
               if (this.serverdone[this.srvtrn] == -1) {
                  this.serverdone[this.srvtrn] = 0;
               }

               Date var25 = new Date();
               this.servestart[this.srvtrn] = var25.getTime();

               try {
                  byte[] var32 = new byte[4];
                  DatagramPacket var37 = new DatagramPacket(var32, var32.length, this.IPAddress[this.srvtrn], 7000);
                  String var4 = "" + this.xt.nickname + "|";
                  byte[] var5 = var4.getBytes();
                  var37.setData(var5);
                  this.dSocket[this.srvtrn].send(var37);
                  this.dSocket[this.srvtrn].receive(var37);
                  String var6 = new String(var37.getData());
                  if (var6.startsWith("OK")) {
                     var25 = new Date();
                     if (var25.getTime() - this.servestart[this.srvtrn] < this.xt.delays[this.srvtrn]) {
                        this.xt.delays[this.srvtrn] = (int)(var25.getTime() - this.servestart[this.srvtrn]);
                     }
                  }
               } catch (Exception var16) {
                  this.xt.delays[this.srvtrn] = 600;
                  this.serverdone[this.srvtrn] = 5;
               }
            }

            this.srvtrn++;
         } else if (this.fase == 13) {
            int var24 = -1;
            boolean var31 = false;

            for (int var36 = 0; var36 < this.nservers; var36++) {
               if (this.xt.delays[var36] < var24 || var24 == -1) {
                  var24 = this.xt.delays[var36];
                  this.opselect = var36;
               }

               if (this.xt.delays[var36] >= 600) {
                  var31 = true;
               }
            }

            if (!var31) {
               this.xt.cntptrys -= 2;
               if (this.xt.cntptrys < 1) {
                  this.xt.cntptrys = 1;
               }
            }

            this.fase = 14;
         }

         try {
            Thread.sleep(5L);
         } catch (InterruptedException var15) {
         }
      }

      if (this.fase != 12 && this.fase != 13 && this.fase != 14 && this.fase != 15 && this.fase != 5 && this.socketson) {
         for (int var27 = 0; var27 < this.nservers; var27++) {
            try {
               this.dSocket[var27].close();
               this.dSocket[var27] = null;
            } catch (Exception var14) {
            }
         }

         this.socketson = false;
      }

      if (this.fase == 16 || this.fase == 17) {
         boolean var28 = false;
         int var33 = 0;
         int var38 = -1;
         this.recom = 0;

         try {
            this.socket = new Socket(this.xt.server, 7067);
            this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            this.dout = new PrintWriter(this.socket.getOutputStream(), true);
         } catch (Exception var13) {
         }

         while ((this.fase == 16 || this.fase == 17) && var33 != 3) {
            String var39 = "";
            if (!var28) {
               try {
                  this.dout.println("10|");
                  String var40 = this.din.readLine();
                  if (var40 == null) {
                     var28 = true;
                  } else {
                     var39 = var40;
                  }
               } catch (Exception var12) {
                  var28 = true;
               }

               if (var28) {
                  try {
                     this.socket.close();
                     this.socket = null;
                     this.din.close();
                     this.din = null;
                     this.dout.close();
                     this.dout = null;
                  } catch (Exception var11) {
                  }

                  try {
                     this.socket = new Socket(this.xt.server, 7067);
                     this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                     this.dout = new PrintWriter(this.socket.getOutputStream(), true);
                     this.dout.println("10|");
                     String var41 = this.din.readLine();
                     if (var41 != null) {
                        var28 = false;
                     } else {
                        var39 = var41;
                     }
                  } catch (Exception var10) {
                     var28 = true;
                  }
               }

               if (var28) {
                  try {
                     this.socket.close();
                     this.socket = null;
                  } catch (Exception var9) {
                  }
               }
            }

            if (var28) {
               this.msg = "Failed to connect to this Server!";
               var33++;
            } else {
               for (int var42 = 0; var42 < 5; var42++) {
                  this.rmps[var42] = this.getvalue(var39, var42 * 2);
                  this.rmwt[var42] = this.getvalue(var39, 1 + var42 * 2);
               }

               int var43 = 1000;

               for (int var44 = 0; var44 < 5; var44++) {
                  if (Math.abs(this.rmps[var44] - 6) < var43) {
                     this.recom = var44;
                     var43 = Math.abs(this.rmps[var44] - 6);
                  }
               }

               if (this.recom != var38) {
                  this.opselect = this.recom;
                  var38 = this.recom;
               }

               if (this.fase == 16) {
                  this.fase = 17;
               }
            }

            if (var33 != 3) {
               try {
                  Thread.sleep(2000L);
               } catch (InterruptedException var8) {
               }
            }
         }

         try {
            this.socket.close();
            this.socket = null;
            this.din.close();
            this.din = null;
            this.dout.close();
            this.dout = null;
         } catch (Exception var7) {
         }

         if (var33 == 3) {
            this.resofaso = true;
         }
      }
   }

   public void stopallnow() {
      if (this.connector != null) {
         this.connector.stop();
         this.connector = null;
      }

      this.endcons();
   }

   public void multimode(ContO[] var1) {
      this.btn = 0;
      this.xt.mainbg(4);

      for (int var2 = 0; var2 < 3; var2++) {
         this.rd.drawImage(this.xt.bgmain, 65, this.bgmy[var2], null);
         this.bgmy[var2] = this.bgmy[var2] - 4;
         if (this.bgmy[var2] <= -400) {
            this.bgmy[var2] = 800;
         }
      }

      this.rd.setComposite(AlphaComposite.getInstance(3, 0.2F));
      this.rd.drawImage(this.xt.bggo, 0, 0, null);
      this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
      this.rd.setColor(new Color(0, 0, 0));
      this.rd.fillRect(65, 425, 670, 25);
      this.rd.fillRect(0, 0, 65, 450);
      this.rd.fillRect(735, 0, 65, 450);
      float var10 = 1.0F - (this.flipo - 10) / 80.0F;
      if (var10 > 1.0F) {
         var10 = 1.0F;
      }

      if (var10 < 0.0F) {
         var10 = 0.0F;
      }

      this.rd.setComposite(AlphaComposite.getInstance(3, var10));
      if (this.flipo > 10) {
         this.rd.drawImage(this.xt.logomadnes, 96 + (int)(2.0 - Math.random() * 4.0), 11 + (int)(2.0 - Math.random() * 4.0), null);
      } else {
         this.rd.drawImage(this.xt.logomadnes, 96, 11, null);
      }

      this.flipo++;
      if (this.flipo > 50) {
         this.flipo = 0;
      }

      this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
      this.drawSbutton(this.xt.exit, 690, 17);
      this.rd.setComposite(AlphaComposite.getInstance(3, 0.25F));
      this.rd.setColor(new Color(203, 227, 253));
      this.rd.fillRoundRect(319, 83, 180, 96, 20, 20);
      this.rd.fillRoundRect(173, 83, 132, 32, 20, 20);
      this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
      this.rd.setColor(this.color2k(90, 90, 90));
      this.rd.drawRoundRect(319, 83, 180, 96, 20, 20);
      this.rd.drawRoundRect(173, 83, 132, 32, 20, 20);
      if (!this.gotcai) {
         int var3 = var1[this.xt.sc[0]].p[0].oz[0];
         int var4 = var3;
         int var5 = var1[this.xt.sc[0]].p[0].oy[0];
         int var6 = var5;

         for (int var7 = 0; var7 < var1[this.xt.sc[0]].npl; var7++) {
            for (int var8 = 0; var8 < var1[this.xt.sc[0]].p[var7].n; var8++) {
               if (var1[this.xt.sc[0]].p[var7].oz[var8] < var3) {
                  var3 = var1[this.xt.sc[0]].p[var7].oz[var8];
               }

               if (var1[this.xt.sc[0]].p[var7].oz[var8] > var4) {
                  var4 = var1[this.xt.sc[0]].p[var7].oz[var8];
               }

               if (var1[this.xt.sc[0]].p[var7].oy[var8] < var5) {
                  var5 = var1[this.xt.sc[0]].p[var7].oy[var8];
               }

               if (var1[this.xt.sc[0]].p[var7].oy[var8] > var6) {
                  var6 = var1[this.xt.sc[0]].p[var7].oy[var8];
               }
            }
         }

         this.cax = (var4 + var3) / 2;
         this.cay = (var6 + var5) / 2;
         this.gotcai = true;
      }

      var1[this.xt.sc[0]].z = 1500;
      var1[this.xt.sc[0]].y = 380 - this.cay;
      var1[this.xt.sc[0]].x = 100 - this.cax;
      var1[this.xt.sc[0]].zy = 0;
      var1[this.xt.sc[0]].xz = -90;
      var1[this.xt.sc[0]].xy = this.pend;
      this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
      var1[this.xt.sc[0]].d(this.rd);
      this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      if (!this.pendb) {
         this.pend += 2;
         if (this.pend > 80) {
            this.pendb = true;
         }
      } else {
         this.pend -= 2;
         if (this.pend < -10) {
            this.pendb = false;
         }
      }

      this.rd.setFont(new Font("Arial", 1, 13));
      this.ftm = this.rd.getFontMetrics();
      this.rd.setColor(new Color(0, 0, 0));
      this.rd.drawString(this.xt.nickname, 239 - this.ftm.stringWidth(this.xt.nickname) / 2, 105);
      this.rd.setColor(this.color2k(90, 90, 90));
      this.rd.drawString("" + this.xt.cd.names[this.xt.sc[0]] + "", 409 - this.ftm.stringWidth("" + this.xt.cd.names[this.xt.sc[0]] + "") / 2, 81);
      this.rd.drawString("Nickname", 239 - this.ftm.stringWidth("Nickname") / 2, 81);
      this.drawbutton(this.xt.change, 570, 98);
      this.drawSbutton(this.xt.logout, 239, 135);
      this.rd.setColor(new Color(98, 56, 0));
      this.rd.drawString("Edit my Account", 239 - this.ftm.stringWidth("Edit my Account") / 2, 168);
      if (this.ond) {
         this.rd
            .drawLine(
               239 - this.ftm.stringWidth("Edit my Account") / 2,
               169,
               239 - this.ftm.stringWidth("Edit my Account") / 2 + this.ftm.stringWidth("Edit my Account"),
               169
            );
      }

      if (this.fase == 12 || this.fase == 13 || this.fase == 14 || this.fase == 15) {
         int var11 = this.srvtrn;
         if (var11 < this.nservers && this.serverdone[var11] != -1) {
            Date var14 = new Date();
            if (var14.getTime() - this.servestart[var11] > 1500L) {
               if (this.connector != null) {
                  this.connector.stop();
                  this.connector = null;
               }

               this.xt.delays[var11] = 600;
               this.serverdone[var11] = 5;
               this.connector = new Thread(this);
               this.connector.start();
            }
         }
      }

      if (this.fase == 12) {
         if (this.xt.acexp != 0 && !this.contrb) {
            this.rd.setComposite(AlphaComposite.getInstance(3, 0.25F));
            this.rd.setColor(new Color(203, 227, 253));
            this.rd.fillRoundRect(165, 219, 470, 135, 20, 20);
            this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
            this.rd.setColor(this.color2k(90, 90, 90));
            this.rd.drawRoundRect(165, 219, 470, 135, 20, 20);
            if (this.xt.acexp > 0) {
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawString("Dear " + this.xt.nickname + ",", 185, 245);
               this.rd.drawString("Your account is due to expire in " + this.xt.acexp + " days.", 185, 265);
               this.rd.drawString("Renew your registration soon!", 185, 295);
               this.stringbutton("Renew my Account Registration now!", 345, 332, 0);
               this.stringbutton("Renew Later", 524, 332, 0);
            }

            if (this.xt.acexp == -1) {
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawString("Dear " + this.xt.nickname + ",", 185, 245);
               this.rd.drawString("Your Need for Madness account registration has expired.", 185, 265);
               this.rd.drawString("Please renew your registration.", 185, 295);
               this.stringbutton("Renew my account registration now!", 362, 332, 0);
               this.stringbutton("Cancel", 524, 332, 0);
            }

            if (this.xt.acexp == -2) {
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawString("Dear " + this.xt.nickname + ",", 185, 245);
               this.rd.drawString("Trial accounts are not allowed to access the downloaded game.", 185, 265);
               this.rd.drawString("You can only play the game online using your trial account.", 185, 295);
               this.stringbutton("Play the multiplayer online!", 362, 332, 0);
               this.stringbutton("Cancel", 524, 332, 0);
            }

            if (this.xt.acexp == -3) {
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawString("Some one else is already logged in the game with your account.", 185, 245);
               this.rd.drawString("If you where just in the game then quitted it suddenly, it could just", 185, 265);
               this.rd.drawString("be your 'ghost entry', if so please wait a few minutes and try again.", 185, 285);
               this.rd.drawString("Otherwise please consider changing your password.", 185, 305);
               this.stringbutton("Change Password", 332, 336, 0);
               this.stringbutton("Try Again", 494, 336, 0);
            }
         } else {
            this.rd.setComposite(AlphaComposite.getInstance(3, 0.25F));
            this.rd.setColor(new Color(203, 227, 253));
            this.rd.fillRoundRect(205, 225, 390, 120, 20, 20);
            this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
            this.rd.setColor(this.color2k(90, 90, 90));
            this.rd.drawString("Multiplayer Mode", 400 - this.ftm.stringWidth("Multiplayer Mode") / 2, 220);
            this.rd.drawRoundRect(205, 225, 390, 120, 20, 20);
            if (this.opselect == 0 && !this.pessd[3]) {
               this.rd.setComposite(AlphaComposite.getInstance(3, 0.25F));
               this.rd.setColor(new Color(203, 227, 253));
               this.rd.fillRect(387 - this.xt.pon.getWidth(this.ob) / 2, 242, this.xt.pon.getWidth(this.ob) + 26, 26);
               this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
            }

            this.drawbutton(this.xt.pon, 400, 255);
            if (this.opselect == 1 && !this.pessd[4]) {
               this.rd.setComposite(AlphaComposite.getInstance(3, 0.25F));
               this.rd.setColor(new Color(203, 227, 253));
               this.rd.fillRect(387 - this.xt.pln.getWidth(this.ob) / 2, 302, this.xt.pln.getWidth(this.ob) + 26, 26);
               this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
            }

            this.drawbutton(this.xt.pln, 400, 315);
            if (!this.xt.logged) {
               this.rd.setColor(new Color(30, 70, 110));
               this.rd
                  .drawString(
                     "You can play 5 multiplayer turns per day to try the game with your trial account.",
                     400 - this.ftm.stringWidth("You can play 1 multiplayer turn per day to try the game with your trial account.") / 2,
                     368
                  );
               this.rd
                  .drawString(
                     "Upgrade your account to purchase the game.",
                     400 - this.ftm.stringWidth("You can play 1 multiplayer turn per day to try the game with your trial account.") / 2,
                     385
                  );
               this.drawSbutton(this.xt.upgrade, 400, 406);
            }
         }
      }

      if (this.fase == 13 || this.fase == 14 || this.fase == 16 || this.fase == 17) {
         if (this.trans < 40) {
            this.rd.drawImage(this.xt.pon, 400 - this.xt.pon.getWidth(this.ob) / 2, 255 - this.xt.pon.getHeight(this.ob) / 2 - 12 - this.trans, null);
         } else {
            this.rd.drawImage(this.xt.pon, 400 - this.xt.pon.getWidth(this.ob) / 2, 215 - this.xt.pon.getHeight(this.ob) / 2 - 12, null);
         }

         if (this.trans >= 40) {
            this.rd.setComposite(AlphaComposite.getInstance(3, 0.25F));
            this.rd.setColor(new Color(203, 227, 253));
            this.rd.fillRoundRect(165, 219, 470, 150, 20, 20);
            this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
            this.rd.setColor(this.color2k(90, 90, 90));
            this.rd.drawRoundRect(165, 219, 470, 150, 20, 20);
            this.drawbutton(this.xt.cancel, 583, 395);
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            if (this.fase == 13) {
               this.rd.drawString(this.msg, 400 - this.ftm.stringWidth(this.msg) / 2, 295);
               if (this.msg.equals(". . . | Connecting to Servers | . . .") && this.ncnt == 0) {
                  this.msg = "| Connecting to Servers |";
                  this.ncnt = 5;
               }

               if (this.msg.equals(". . | Connecting to Servers | . .") && this.ncnt == 0) {
                  this.msg = ". . . | Connecting to Servers | . . .";
                  this.ncnt = 5;
               }

               if (this.msg.equals(". | Connecting to Servers | .") && this.ncnt == 0) {
                  this.msg = ". . | Connecting to Servers | . .";
                  this.ncnt = 5;
               }

               if (this.msg.equals("| Connecting to Servers |") && this.ncnt == 0) {
                  this.msg = ". | Connecting to Servers | .";
                  this.ncnt = 5;
               }

               if (this.ncnt != 0) {
                  this.ncnt--;
               }
            }

            if (this.fase == 16) {
               this.rd.drawString(this.msg, 400 - this.ftm.stringWidth(this.msg) / 2, 295);
               if (this.msg.equals(". . . | Finding Rooms | . . .") && this.ncnt == 0) {
                  this.msg = "| Finding Rooms |";
                  this.ncnt = 5;
               }

               if (this.msg.equals(". . | Finding Rooms | . .") && this.ncnt == 0) {
                  this.msg = ". . . | Finding Rooms | . . .";
                  this.ncnt = 5;
               }

               if (this.msg.equals(". | Finding Rooms | .") && this.ncnt == 0) {
                  this.msg = ". . | Finding Rooms | . .";
                  this.ncnt = 5;
               }

               if (this.msg.equals("| Finding Rooms |") && this.ncnt == 0) {
                  this.msg = ". | Finding Rooms | .";
                  this.ncnt = 5;
               }

               if (this.ncnt != 0) {
                  this.ncnt--;
               }
            }

            if (this.fase == 14) {
               this.msg = "";
               int var12 = 0;
               if (!this.xt.nofull) {
                  for (int var15 = 0; var15 < this.nservers; var15++) {
                     if (this.xt.delays[var15] >= 400) {
                        var12++;
                     }
                  }
               }

               if (var12 != this.nservers) {
                  boolean var16 = false;
                  byte var18 = 0;

                  for (int var19 = 0; var19 < this.nservers; var19++) {
                     this.rd.setColor(new Color(0, 0, 0));
                     if (this.opselect == var19) {
                        this.rd.setColor(new Color(98, 56, 0));
                        this.rd.fillRoundRect(175, 230 + var19 * 20, 450, 20, 14, 14);
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawRoundRect(175, 230 + var19 * 20, 450, 20, 14, 14);
                        this.rd.setColor(this.color2k(255, 255, 255));
                        if (this.xt.delays[var19] >= 400) {
                           this.msg = "Your connection to this server is too slow!";
                           var18 = 1;
                        }

                        if (this.xt.delays[var19] == 600) {
                           this.msg = "This server is not responding!";
                           var18 = 1;
                        }

                        if (this.xt.delays[var19] < 400) {
                           for (int var20 = 0; var20 < this.nservers; var20++) {
                              if (this.xt.delays[var20] < this.xt.delays[var19] && var19 != var20) {
                                 var16 = true;
                              }
                           }

                           if (var16) {
                              this.msg = "It is recommended to choose the fastest server.";
                           } else if (this.xt.delays[var19] >= 300) {
                              this.msg = "Your connection speed is not perfect.  You may encounter delay!";
                           }
                        }
                     }

                     this.rd.drawString("Server Name :", 195, 245 + var19 * 20);
                     this.rd.drawString("|   Delay/Speed :", 385, 245 + var19 * 20);
                     int var21 = 0;
                     int var22 = 0;
                     String var9 = "" + this.xt.delays[var19] + "/";
                     if (this.xt.delays[var19] < 75) {
                        var9 = var9 + "EXCELENT *****";
                        var21 = 62;
                        var22 = 100;
                     }

                     if (this.xt.delays[var19] >= 75 && this.xt.delays[var19] < 150) {
                        var9 = var9 + "Perfect ****";
                        var21 = 62;
                        var22 = 100;
                     }

                     if (this.xt.delays[var19] >= 150 && this.xt.delays[var19] < 250) {
                        var9 = var9 + "Good ***";
                        var21 = 81;
                        var22 = 100;
                     }

                     if (this.xt.delays[var19] >= 250 && this.xt.delays[var19] < 400) {
                        var9 = var9 + "Acceptable **";
                        var21 = 100;
                        var22 = 100;
                     }

                     if (this.xt.delays[var19] >= 400 && this.xt.delays[var19] < 600) {
                        var9 = var9 + "Poor";
                        var21 = 100;
                        var22 = 0;
                     }

                     if (this.xt.delays[var19] == 600) {
                        var9 = "Not Responding";
                     }

                     if (this.opselect == var19) {
                        var21 = (int)(var21 * 2.55F);
                        var22 = (int)(var22 * 2.55F);
                     }

                     if (var21 > 255) {
                        var21 = 255;
                     }

                     if (var21 < 0) {
                        var21 = 0;
                     }

                     if (var22 > 255) {
                        var22 = 255;
                     }

                     if (var22 < 0) {
                        var22 = 0;
                     }

                     this.rd.setColor(new Color(var21, var22, 0));
                     this.rd.drawString("" + this.snames[var19] + "", 294, 245 + var19 * 20);
                     this.rd.drawString(var9, 497, 245 + var19 * 20);
                  }

                  if (!this.xt.logged && this.xt.nfreeplays - this.xt.ndisco >= 5 && var18 == 0) {
                     this.msg = "You have played your 5 games today, please upgrade your account.";
                     var18 = 2;
                  }

                  if (this.xt.nofull) {
                     if (this.nflk % 4 != 0 || this.nflk == 0) {
                        this.rd.setFont(new Font("Arial", 0, 13));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.setColor(new Color(200, 0, 0));
                        this.rd.drawString("Warning! You did not allow the game full permissions when you started it.", 175, 275);
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawString("(You didn't click 'Run' at the prompt that came up at the start of the game).", 175, 292);
                        this.rd.drawString("Because of this you will be able to connect to ONLY the game's main server:", 175, 309);
                        this.rd.drawString("'" + this.snames[0] + "', which is not necessarily the fastest server you can connect to.", 175, 326);
                        this.rd.drawString("Please allow Java full permissions next time to be able to play on all servers!", 175, 343);
                        this.rd.setFont(new Font("Arial", 1, 13));
                        this.ftm = this.rd.getFontMetrics();
                     }
                  } else {
                     if (var18 == 0) {
                        this.rd.setColor(new Color(98, 56, 0));
                     }

                     if (var18 == 1) {
                        this.rd.setColor(new Color(200, 0, 0));
                     }

                     if (var18 == 2) {
                        this.rd.setColor(new Color(30, 70, 110));
                     }

                     if (this.nflk % 4 != 0 || this.nflk == 0) {
                        this.rd.drawString(this.msg, 400 - this.ftm.stringWidth(this.msg) / 2, 360);
                     }

                     if (this.nflk != 0) {
                        this.nflk--;
                     }
                  }
               } else {
                  if (this.nflk % 4 != 0 || this.nflk == 0) {
                     this.rd.setColor(new Color(200, 0, 0));
                     this.rd
                        .drawString(
                           "Sorry.  Your connection is currently not fast enough to play online!",
                           400 - this.ftm.stringWidth("Sorry.  Your connection is currently not fast enough to play online!") / 2,
                           242
                        );
                  }

                  if (this.nflk != 0) {
                     this.nflk--;
                  }

                  this.rd.setColor(new Color(0, 0, 0));
                  this.rd.setFont(new Font("Arial", 0, 13));
                  this.ftm = this.rd.getFontMetrics();
                  this.rd.drawString("Please make sure you or anyone else using this connection is not slowing", 181, 265);
                  this.rd.drawString("it down right now by downloading or streaming.", 181, 282);
                  this.rd.drawString("Also please make sure you don't have any other programs running on your", 181, 299);
                  this.rd.drawString("computer that maybe consuming your bandwidth.", 181, 316);
                  this.rd.drawString("Otherwise you may need to upgrade your connection speed to play!", 181, 333);
                  this.rd.setFont(new Font("Arial", 1, 13));
                  this.ftm = this.rd.getFontMetrics();
                  this.rd
                     .drawString(
                        "Press 'Cancel' to try again or to try playing a Lan game instead.",
                        400 - this.ftm.stringWidth("Press 'Cancel' to try again or to try playing a Lan game instead.") / 2,
                        357
                     );
               }

               this.drawbutton(this.xt.play, 400, 395);
            }

            if (this.fase == 17) {
               byte var13 = 14;
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.drawString(": :   " + this.xt.servername + "   : :", 400 - this.ftm.stringWidth(": :   " + this.xt.servername + "   : :") / 2, 239);

               for (int var17 = 0; var17 < 5; var17++) {
                  if (this.opselect == var17) {
                     this.rd.setColor(new Color(98, 56, 0));
                     this.rd.fillRoundRect(300, 230 + var17 * 20 + var13, 200, 20, 14, 14);
                     this.rd.setColor(new Color(0, 0, 0));
                     this.rd.drawRoundRect(300, 230 + var17 * 20 + var13, 200, 20, 14, 14);
                     this.rd.setColor(this.color2k(255, 255, 255));
                  }

                  this.rd.drawString("Room " + (var17 + 1) + " :", 329, 245 + var17 * 20 + var13);
                  this.rd
                     .drawString("" + this.rmps[var17] + "  Players", 471 - this.ftm.stringWidth("" + this.rmps[var17] + "  Players"), 245 + var17 * 20 + var13);
                  if (var17 == this.recom) {
                     if (this.opselect != var17) {
                        this.rd.setColor(new Color(125, 200, 0));
                     } else {
                        this.rd.setColor(new Color(160, 255, 0));
                     }
                  }

                  this.rd.setColor(new Color(0, 0, 0));
               }

               this.drawbutton(this.xt.play, 400, 395);
            }
         } else {
            this.trans += 8;
         }
      }

      if (this.fase == 15) {
         if (this.trans < 100) {
            this.rd.drawImage(this.xt.pln, 400 - this.xt.pln.getWidth(this.ob) / 2, 315 - this.xt.pln.getHeight(this.ob) / 2 - 12 - this.trans, null);
         } else {
            this.rd.drawImage(this.xt.pln, 400 - this.xt.pln.getWidth(this.ob) / 2, 215 - this.xt.pln.getHeight(this.ob) / 2 - 12, null);
         }

         if (this.trans >= 100) {
            this.rd.setColor(this.color2k(255, 255, 255));
            this.rd.fillRoundRect(165, 219, 470, 150, 20, 20);
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawRoundRect(165, 219, 470, 150, 20, 20);
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            if (!this.xt.nofull) {
               this.rd.drawString("Play a multiplayer game across your Local Area Network (LAN).", 179, 245);
               this.rd.drawString("Experience the game live with zero delay and 100% real-time action!", 179, 262);
               this.rd.setFont(new Font("Arial", 0, 13));
               this.ftm = this.rd.getFontMetrics();
               this.rd.drawString("This is for if there is more then one computer connected to your network or", 179, 292);
               this.rd.drawString("if you are in a computer lab or in an internet café.", 179, 309);
               this.rd.drawString("You can also invite your friends to come over with their Laptop PCs or Macs", 179, 335);
               this.rd.drawString("to log on to your internet connection/network and play with you!", 179, 352);
            } else {
               if (this.nflk % 4 != 0 || this.nflk == 0) {
                  this.rd.setFont(new Font("Arial", 1, 13));
                  this.ftm = this.rd.getFontMetrics();
                  this.rd.setColor(new Color(200, 0, 0));
                  this.rd.drawString("Sorry. You did not allow the game full permissions when you started it.", 175, 242);
                  this.rd.setFont(new Font("Arial", 0, 13));
                  this.ftm = this.rd.getFontMetrics();
                  this.rd.setColor(new Color(0, 0, 0));
                  this.rd.drawString("(You didn't click 'Run' at the prompt that came up at the start of the game).", 175, 262);
                  this.rd.drawString("Because of this the game will not be able to create LAN connections!", 175, 288);
                  this.rd.setFont(new Font("Arial", 1, 13));
                  this.ftm = this.rd.getFontMetrics();
                  this.rd.drawString("Please restart the game and allow Java full permissions to be able to", 175, 315);
                  this.rd.drawString("play LAN games!", 175, 332);
                  this.rd.setFont(new Font("Arial", 0, 13));
                  this.ftm = this.rd.getFontMetrics();
                  this.rd.drawString("( Close ALL browser windows including this one then", 295, 332);
                  this.rd.drawString("start the game again but click 'Run' when asked to 'run this application'. )", 175, 349);
               }

               if (this.nflk != 0) {
                  this.nflk--;
               }
            }

            this.drawbutton(this.xt.cancel, 583, 395);
            this.drawbutton(this.xt.play, 400, 395);
         } else {
            this.trans += 10;
         }
      }

      if (this.resofaso) {
         this.resofaso = false;
         if (this.connector != null) {
            this.connector.stop();
            this.connector = null;
         }

         this.socketson = false;
         this.msg = "| Connecting to Servers |";
         this.fase = 13;
         this.connector = new Thread(this);
         this.connector.start();
      }
   }

   public void multistart(ContO[] var1, int var2, int var3, boolean var4) {
      this.btn = 0;
      this.xt.mainbg(4);

      for (int var5 = 0; var5 < 3; var5++) {
         this.rd.drawImage(this.xt.bgmain, 65, this.bgmy[var5], null);
         this.bgmy[var5] = this.bgmy[var5] - 4;
         if (this.bgmy[var5] <= -400) {
            this.bgmy[var5] = 800;
         }
      }

      this.rd.setComposite(AlphaComposite.getInstance(3, 0.2F));
      this.rd.drawImage(this.xt.bggo, 0, 0, null);
      this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
      this.rd.setColor(new Color(0, 0, 0));
      this.rd.fillRect(65, 425, 670, 25);
      this.rd.fillRect(0, 0, 65, 450);
      this.rd.fillRect(735, 0, 65, 450);
      float var13 = 1.0F - (this.flipo - 10) / 80.0F;
      if (var13 > 1.0F) {
         var13 = 1.0F;
      }

      if (var13 < 0.0F) {
         var13 = 0.0F;
      }

      this.rd.setComposite(AlphaComposite.getInstance(3, var13));
      if (this.flipo > 10) {
         this.rd.drawImage(this.xt.logomadnes, 96 + (int)(2.0 - Math.random() * 4.0), 11 + (int)(2.0 - Math.random() * 4.0), null);
      } else {
         this.rd.drawImage(this.xt.logomadnes, 96, 11, null);
      }

      this.flipo++;
      if (this.flipo > 50) {
         this.flipo = 0;
      }

      this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
      byte var6 = 0;
      if (var2 != this.oxm || var3 != this.oym) {
         var6 = 1;
         this.oxm = var2;
         this.oym = var3;
      }

      if (var4) {
         var6 = 2;
      }

      this.rd.setComposite(AlphaComposite.getInstance(3, 0.3F));
      this.rd.drawImage(this.xt.dude[var6], 87, 76, null);
      this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
      this.rd.drawImage(this.xt.redy, 445, 153, null);
      this.drawSbutton(this.xt.exit, 690, 17);
      this.rd.setFont(new Font("Arial", 1, 13));
      this.ftm = this.rd.getFontMetrics();
      if (this.fase != 5) {
         this.rd.setComposite(AlphaComposite.getInstance(3, 0.25F));
         this.rd.setColor(new Color(203, 227, 253));
         this.rd.fillRoundRect(246, 83, 180, 96, 20, 20);
         this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
         this.rd.setColor(this.color2k(90, 90, 90));
         this.rd.drawString("" + this.xt.cd.names[this.xt.sc[0]] + "", 336 - this.ftm.stringWidth("" + this.xt.cd.names[this.xt.sc[0]] + "") / 2, 81);
         this.rd.drawRoundRect(246, 83, 180, 96, 20, 20);
         if (!this.gotcai) {
            int var7 = var1[this.xt.sc[0]].p[0].oz[0];
            int var8 = var7;
            int var9 = var1[this.xt.sc[0]].p[0].oy[0];
            int var10 = var9;

            for (int var11 = 0; var11 < var1[this.xt.sc[0]].npl; var11++) {
               for (int var12 = 0; var12 < var1[this.xt.sc[0]].p[var11].n; var12++) {
                  if (var1[this.xt.sc[0]].p[var11].oz[var12] < var7) {
                     var7 = var1[this.xt.sc[0]].p[var11].oz[var12];
                  }

                  if (var1[this.xt.sc[0]].p[var11].oz[var12] > var8) {
                     var8 = var1[this.xt.sc[0]].p[var11].oz[var12];
                  }

                  if (var1[this.xt.sc[0]].p[var11].oy[var12] < var9) {
                     var9 = var1[this.xt.sc[0]].p[var11].oy[var12];
                  }

                  if (var1[this.xt.sc[0]].p[var11].oy[var12] > var10) {
                     var10 = var1[this.xt.sc[0]].p[var11].oy[var12];
                  }
               }
            }

            this.cax = (var8 + var7) / 2;
            this.cay = (var10 + var9) / 2;
            this.gotcai = true;
         }

         var1[this.xt.sc[0]].z = 1500;
         var1[this.xt.sc[0]].y = 380 - this.cay;
         var1[this.xt.sc[0]].x = -170 - this.cax;
         var1[this.xt.sc[0]].zy = 0;
         var1[this.xt.sc[0]].xz = -90;
         var1[this.xt.sc[0]].xy = this.pend;
         this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
         var1[this.xt.sc[0]].d(this.rd);
         this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
         if (!this.pendb) {
            this.pend += 2;
            if (this.pend > 80) {
               this.pendb = true;
            }
         } else {
            this.pend -= 2;
            if (this.pend < -10) {
               this.pendb = false;
            }
         }

         this.drawbutton(this.xt.change, 497, 98);
      }

      if (this.fase == 1 || this.fase == 2) {
         this.rd.setColor(new Color(0, 0, 0));
         this.rd.drawString(this.msg, 400 - this.ftm.stringWidth(this.msg) / 2, 205);
         this.rd.drawString("Enter a Nickname:", 400 - this.ftm.stringWidth("Enter a Nickname:") - 14, 241);
         if (this.fase == 2) {
            if (this.msg.equals(". . . | Checking Nickname | . . .") && this.ncnt == 0) {
               this.msg = "| Checking Nickname |";
               this.ncnt = 5;
            }

            if (this.msg.equals(". . | Checking Nickname | . .") && this.ncnt == 0) {
               this.msg = ". . . | Checking Nickname | . . .";
               this.ncnt = 5;
            }

            if (this.msg.equals(". | Checking Nickname | .") && this.ncnt == 0) {
               this.msg = ". . | Checking Nickname | . .";
               this.ncnt = 5;
            }

            if (this.msg.equals("| Checking Nickname |") && this.ncnt == 0) {
               this.msg = ". | Checking Nickname | .";
               this.ncnt = 5;
            }

            if (this.ncnt != 0) {
               this.ncnt--;
            }

            this.pessd[2] = true;
         }

         if (this.fase == 1 && !this.gs.tnick.isShowing()) {
            this.gs.tnick.show();
            this.gs.tnick.requestFocus();
            if (this.gs.tnick.getText().equals("Nickname")) {
               this.gs.tnick.select(8, 8);
            }
         }

         if (this.errcnt != 0) {
            this.errcnt--;
            if (this.errcnt == 0) {
               this.gs.tnick.setForeground(new Color(0, 0, 0));
            }
         }

         this.drawbutton(this.xt.play, 400, 285);
         if (this.nflk > 0) {
            if (this.gs.tnick.getText().equals("")) {
               this.gs.tnick.setText("Nickname");
               if (this.nflk == 1) {
                  this.gs.tnick.select(8, 8);
               }
            } else {
               this.gs.tnick.setText("");
            }

            this.nflk--;
         }

         this.drawbutton(this.xt.login, 400, 340);
         this.drawbutton(this.xt.register, 400, 395);
         this.gs.movefield(this.gs.tnick, 400, 225, 129, 23);

         while (this.ftm.stringWidth(this.gs.tnick.getText()) > 86) {
            this.gs.tnick.setText(this.gs.tnick.getText().substring(0, this.gs.tnick.getText().length() - 1));
            this.gs.tnick.select(this.gs.tnick.getText().length(), this.gs.tnick.getText().length());
         }

         if (!this.gs.tnick.getText().equals(this.lnick)) {
            this.fixtext(this.gs.tnick);
            this.lnick = this.gs.tnick.getText();
         }

         if (this.xt.msgcheck(this.gs.tnick.getText())) {
            this.gs.tnick.setText("");
         }

         if (this.gs.tnick.getText().toLowerCase().indexOf("madbot") != -1) {
            this.gs.tnick.setText("");
         }
      }

      if (this.fase == 3 || this.fase == 4) {
         this.rd.drawImage(this.xt.ntrg, 97, 388, null);
         this.rd.setComposite(AlphaComposite.getInstance(3, 0.25F));
         this.rd.setColor(new Color(203, 227, 253));
         this.rd.fillRoundRect(246, 212, 308, 142, 20, 20);
         this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
         this.rd.setColor(this.color2k(90, 90, 90));
         this.rd.drawRoundRect(246, 212, 308, 142, 20, 20);
         this.rd.setColor(new Color(0, 0, 0));
         if (this.nflk % 4 != 0 || this.nflk == 0) {
            this.rd.drawString(this.msg, 400 - this.ftm.stringWidth(this.msg) / 2, 205);
         }

         if (this.nflk != 0) {
            this.nflk--;
         }

         this.rd.drawString("Nickname:", 376 - this.ftm.stringWidth("Nickname:") - 14, 237);
         this.rd.drawString("Password:", 376 - this.ftm.stringWidth("Password:") - 14, 267);
         if (this.fase == 4) {
            if (this.msg.equals(". . . | Logging In | . . .") && this.ncnt == 0) {
               this.msg = "| Logging In |";
               this.ncnt = 5;
            }

            if (this.msg.equals(". . | Logging In | . .") && this.ncnt == 0) {
               this.msg = ". . . | Logging In | . . .";
               this.ncnt = 5;
            }

            if (this.msg.equals(". | Logging In | .") && this.ncnt == 0) {
               this.msg = ". . | Logging In | . .";
               this.ncnt = 5;
            }

            if (this.msg.equals("| Logging In |") && this.ncnt == 0) {
               this.msg = ". | Logging In | .";
               this.ncnt = 5;
            }

            if (this.ncnt != 0) {
               this.ncnt--;
            }

            this.pessd[2] = true;
         }

         if (this.fase == 3) {
            this.showtf = true;
            if (!this.gs.applejava) {
               if (!this.gs.tpass.isShowing()) {
                  this.gs.tpass.show();
                  if (!this.gs.tnick.getText().equals("")) {
                     this.gs.tpass.requestFocus();
                  }
               }

               if (!this.gs.tnick.isShowing()) {
                  this.gs.tnick.show();
                  if (this.gs.tnick.getText().equals("")) {
                     this.gs.tnick.requestFocus();
                  }
               }
            }
         }

         if (this.errcnt != 0) {
            this.errcnt--;
            if (this.errcnt == 0) {
               this.gs.tpass.setText("");
               this.gs.tnick.setForeground(new Color(0, 0, 0));
               this.gs.tpass.setForeground(new Color(0, 0, 0));
            }
         }

         this.drawbutton(this.xt.login, 400, 315);
         if (this.onf) {
            this.rd.setColor(this.color2k(0, 72, 255));
         } else {
            this.rd.setColor(this.color2k(120, 120, 120));
         }

         this.rd.setFont(new Font("Arial", 1, 11));
         this.ftm = this.rd.getFontMetrics();
         this.rd.drawString("Forgot your nickname or password?", 400 - this.ftm.stringWidth("Forgot your nickname or password?") / 2, 345);
         this.rd.setColor(new Color(0, 0, 0));
         this.rd.setFont(new Font("Arial", 1, 12));
         this.ftm = this.rd.getFontMetrics();
         String var14 = "Register a full account here!";
         this.xrl = 400 - this.ftm.stringWidth(var14) / 2;
         this.xrr = this.xrl + this.ftm.stringWidth(var14);
         this.rd.drawString(var14, this.xrl, 371);
         this.rd.drawLine(this.xrl, 372, this.xrr, 372);
         this.drawbutton(this.xt.register, 400, 395);
         this.gs.movefieldd(this.gs.tnick, 376, 221, 129, 23, this.showtf);
         if (!this.gs.tnick.getText().equals(this.lnick)) {
            this.fixtext(this.gs.tnick);
            this.lnick = this.gs.tnick.getText();
         }

         this.gs.movefieldd(this.gs.tpass, 376, 251, 129, 23, this.showtf);
         if (!this.gs.tpass.getText().equals(this.lpass)) {
            this.fixtext(this.gs.tpass);
            this.lpass = this.gs.tpass.getText();
         }

         if (this.fase == 3 && (!this.gs.tpass.getText().equals("") && !this.gs.tnick.getText().equals("") || !this.gs.applejava) && !this.gs.keplo.isShowing()
            )
          {
            this.gs.keplo.show();
         }

         this.gs.movefield(this.gs.keplo, 376, 275, 129, 23);
      }

      if (this.fase == 5) {
         this.rd.setColor(new Color(0, 0, 0));
         this.rd.drawString("Nickname:", 376 - this.ftm.stringWidth("Nickname:") - 14, 141);
         this.gs.movefield(this.gs.tnick, 376, 125, 129, 23);

         while (this.ftm.stringWidth(this.gs.tnick.getText()) > 86) {
            this.gs.tnick.setText(this.gs.tnick.getText().substring(0, this.gs.tnick.getText().length() - 1));
            this.gs.tnick.select(this.gs.tnick.getText().length(), this.gs.tnick.getText().length());
         }

         if (!this.gs.tnick.getText().equals(this.lnick)) {
            this.fixtext(this.gs.tnick);
            this.lnick = this.gs.tnick.getText();
         }

         if (!this.gs.tnick.isShowing()) {
            this.gs.tnick.show();
         }

         this.drawbutton(this.xt.register, 400, 325);
         this.drawbutton(this.xt.cancel, 400, 375);
      }

      if (this.fase == 7 || this.fase == 8) {
         this.rd.setColor(new Color(0, 0, 0));
         if (this.nflk % 4 != 0 || this.nflk == 0) {
            this.rd.drawString(this.msg, 400 - this.ftm.stringWidth(this.msg) / 2, 205);
         }

         if (this.nflk != 0) {
            this.nflk--;
         }

         this.rd.drawString("Your Email:", 344 - this.ftm.stringWidth("Your Email:") - 14, 241);
         if (this.fase == 8) {
            if (this.msg.equals(". . . | Checking Email | . . .") && this.ncnt == 0) {
               this.msg = "| Checking Email |";
               this.ncnt = 5;
            }

            if (this.msg.equals(". . | Checking Email | . .") && this.ncnt == 0) {
               this.msg = ". . . | Checking Email | . . .";
               this.ncnt = 5;
            }

            if (this.msg.equals(". | Checking Email | .") && this.ncnt == 0) {
               this.msg = ". . | Checking Email | . .";
               this.ncnt = 5;
            }

            if (this.msg.equals("| Checking Email |") && this.ncnt == 0) {
               this.msg = ". | Checking Email | .";
               this.ncnt = 5;
            }

            if (this.ncnt != 0) {
               this.ncnt--;
            }

            this.pessd[2] = true;
         }

         if (this.fase == 7) {
            this.showtf = true;
            if (!this.gs.applejava && !this.gs.temail.isShowing()) {
               this.gs.temail.show();
               this.gs.temail.requestFocus();
            }
         }

         if (this.errcnt != 0) {
            this.errcnt--;
            if (this.errcnt == 0) {
               this.gs.temail.setForeground(new Color(0, 0, 0));
            }
         }

         this.drawbutton(this.xt.sdets, 400, 280);
         this.drawbutton(this.xt.cancel, 400, 375);
         this.gs.movefieldd(this.gs.temail, 344, 225, 199, 23, this.showtf);
         if (!this.gs.temail.getText().equals(this.lemail)) {
            this.fixtext(this.gs.temail);
            this.lemail = this.gs.temail.getText();
         }
      }
   }

   public void ctachm(int var1, int var2, int var3, Control var4, Lobby var5) {
      int var6 = -1;
      if (this.fase != 2 && this.fase != 4 && this.fase != 6 && this.fase != 8 && this.fase != 9) {
         for (int var7 = 0; var7 < this.btn; var7++) {
            if (Math.abs(var1 - this.bx[var7]) >= this.bw[var7] / 2 + 12 || Math.abs(var2 - this.by[var7]) >= 14 || var3 != 1 && var3 != 11) {
               this.pessd[var7] = false;
            } else {
               this.pessd[var7] = true;
            }

            if (Math.abs(var1 - this.bx[var7]) < this.bw[var7] / 2 + 12 && Math.abs(var2 - this.by[var7]) < 14 && var3 <= -1) {
               this.gs.mouses = 0;
               var6 = var7;
            }

            if (this.fase == 12
               && Math.abs(var1 - this.bx[var7]) < this.bw[var7] / 2 + 12
               && Math.abs(var2 - this.by[var7]) < 14
               && (var7 == 3 || var7 == 4)
               && (var1 != this.lxm || var2 != this.lym)) {
               this.opselect = var7 - 3;
            }
         }
      }

      if (var6 == 0) {
         this.gs.tnick.hide();
         this.gs.tpass.hide();
         this.gs.keplo.hide();
         this.gs.temail.hide();
         this.gs.requestFocus();
         this.xt.fase = 24;
      }

      if (var6 == 1 && this.fase != 5) {
         this.gs.tnick.hide();
         this.gs.tpass.hide();
         this.gs.keplo.hide();
         this.gs.temail.hide();
         this.gs.requestFocus();
         this.xt.fase = 23;
      }

      byte var14 = 2;
      if (this.fase == 12 || this.fase == 13 || this.fase == 14 || this.fase == 15 || this.fase == 16 || this.fase == 17) {
         if (var1 > 176 && var2 > 152 && var1 < 296 && var2 < 174) {
            if (!this.ond) {
               this.ond = true;
               this.gs.setCursor(new Cursor(12));
            }
         } else if (this.ond) {
            this.ond = false;
            this.gs.setCursor(new Cursor(0));
         }

         if (this.cntcl == 0) {
            if (this.ond && var3 == 11) {
               this.gs.editlink(this.xt.nickname, false);
               this.cntcl = 10;
            }
         } else {
            this.cntcl--;
         }

         if (var6 == var14) {
            var6 = -1;
            if (this.xt.sc[0] >= 16) {
               this.xt.sc[0] = 15;
               this.gotcai = false;
            }

            this.xt.logged = false;
            this.xt.gotlog = false;
            this.gs.keplo.setState(false);
            this.gs.setloggedcookie();
            this.xt.cd.msloaded = 0;
            this.xt.cd.lastload = 0;
            this.msg = "Login to access the multiplayer madness!";
            this.fase = 3;
         }
      }

      if (this.fase == 12) {
         if (this.xt.acexp != 0 && !this.contrb) {
            if (this.xt.acexp > 0) {
               if (var6 == var14 + 1 || var4.enter) {
                  this.gs.editlink(this.xt.nickname, false);
                  var6 = -1;
               }

               if (var6 == var14 + 2) {
                  this.opselect = 0;
                  this.contrb = true;
                  var6 = -1;
               }
            }

            if (this.xt.acexp == -1) {
               if (var6 == var14 + 1 || var4.enter) {
                  this.gs.editlink(this.xt.nickname, false);
                  var6 = -1;
               }

               if (var6 == var14 + 2) {
                  var6 = -1;
                  if (this.xt.sc[0] >= 16) {
                     this.xt.sc[0] = 15;
                     this.gotcai = false;
                  }

                  this.xt.logged = false;
                  this.xt.cd.lastload = 0;
                  this.msg = "Login to access the multiplayer madness!";
                  this.fase = 3;
               }
            }

            if (this.xt.acexp == -2) {
               if (var6 == var14 + 1 || var4.enter) {
                  this.gs.multlink();
                  var6 = -1;
               }

               if (var6 == var14 + 2) {
                  var6 = -1;
                  if (this.xt.sc[0] >= 16) {
                     this.xt.sc[0] = 15;
                     this.gotcai = false;
                  }

                  this.xt.logged = false;
                  this.xt.cd.lastload = 0;
                  this.msg = "Login to access the multiplayer madness!";
                  this.fase = 3;
               }
            }

            if (this.xt.acexp == -3) {
               if (var6 == var14 + 1 || var4.enter) {
                  this.gs.editlink(this.xt.nickname, false);
                  var6 = -1;
               }

               if (var6 == var14 + 2) {
                  var6 = -1;
                  if (this.xt.sc[0] >= 16) {
                     this.xt.sc[0] = 15;
                     this.gotcai = false;
                  }

                  this.xt.logged = false;
                  this.xt.cd.lastload = 0;
                  this.msg = "Login to access the multiplayer madness!";
                  this.fase = 3;
               }
            }
         } else {
            if (var4.up) {
               this.opselect--;
               if (this.opselect == -1) {
                  this.opselect = 1;
               }

               var4.up = false;
            }

            if (var4.down) {
               this.opselect++;
               if (this.opselect == 2) {
                  this.opselect = 0;
               }

               var4.down = false;
            }

            if (var4.enter) {
               var6 = this.opselect + 3;
               var4.enter = false;
            }

            if (var6 == var14 + 1) {
               this.msg = "| Connecting to Servers |";
               this.opselect = 0;
               this.trans = 0;
               this.fase = 13;
               this.nflk = 0;
               var6 = -1;
            }

            if (var6 == var14 + 2) {
               this.trans = 0;
               this.fase = 15;
               var6 = -1;
            }

            if (!this.xt.logged && var6 == var14 + 3) {
               this.gs.editlink(this.xt.nickname, true);
            }
         }
      }

      if (this.fase == 13 || this.fase == 14 || this.fase == 15 || this.fase == 16 || this.fase == 17) {
         if (var4.exit) {
            var6 = 3;
         }

         if (var6 == var14 + 1) {
            if (this.fase == 15) {
               this.opselect = 1;
            } else {
               this.opselect = 0;
            }

            if (this.fase == 16 || this.fase == 17) {
               if (this.connector != null) {
                  this.connector.stop();
                  this.connector = null;
               }

               try {
                  this.socket.close();
                  this.socket = null;
                  this.din.close();
                  this.din = null;
                  this.dout.close();
                  this.dout = null;
               } catch (Exception var13) {
               }

               this.fase = 12;
               this.connector = new Thread(this);
               this.connector.start();
            }

            if (this.fase == 14) {
               if (this.connector != null) {
                  this.connector.stop();
                  this.connector = null;
               }

               for (int var8 = 0; var8 < this.nservers; var8++) {
                  try {
                     this.dSocket[var8].close();
                     this.dSocket[var8] = null;
                  } catch (Exception var12) {
                  }
               }

               this.socketson = false;
               this.fase = 12;
               this.connector = new Thread(this);
               this.connector.start();
            }

            this.fase = 12;
            this.gs.setCursor(new Cursor(0));
         }
      }

      if (this.fase == 14) {
         if (var4.enter) {
            var6 = 4;
            this.pessd[4] = true;
         }

         if (var4.up) {
            this.opselect--;
            if (this.opselect == -1) {
               this.opselect = this.nservers - 1;
            }

            var4.up = false;
         }

         if (var4.down) {
            this.opselect++;
            if (this.opselect == this.nservers) {
               this.opselect = 0;
            }

            var4.down = false;
         }

         for (int var15 = 0; var15 < this.nservers; var15++) {
            if (var1 > 175 && var2 > 230 + var15 * 20 && var1 < 625 && var2 < 250 + var15 * 20 && var3 == 1) {
               this.opselect = var15;
            }
         }

         if (var6 == var14 + 2) {
            if (this.xt.delays[this.opselect] >= 400 && !this.xt.nickname.equals("Fyre")) {
               this.nflk = 30;
            } else {
               this.xt.server = this.servers[this.opselect];
               this.xt.servername = this.snames[this.opselect];
               this.msg = "| Finding Rooms |";
               this.opselect = 0;
               this.nflk = 0;
               var6 = -1;
               this.fase = 16;
            }
         }
      }

      if (this.fase == 15) {
         if (var4.enter) {
            var6 = 4;
            this.pessd[4] = true;
         }

         if (var6 == var14 + 2) {
            if (this.xt.nofull) {
               this.nflk = 30;
            } else {
               this.xt.server = this.servers[1];
               this.xt.servername = this.snames[1];
               this.xt.servport = 7067;
               this.xt.lan = true;
               var6 = -1;
               this.fase = 18;
               var5.fase = 0;
            }
         }
      }

      if (this.fase == 17) {
         if (var4.enter) {
            var6 = 4;
            this.pessd[4] = true;
         }

         if (var4.up) {
            this.opselect--;
            if (this.opselect == -1) {
               this.opselect = 4;
            }

            var4.up = false;
         }

         if (var4.down) {
            this.opselect++;
            if (this.opselect == 5) {
               this.opselect = 0;
            }

            var4.down = false;
         }

         for (int var16 = 0; var16 < 5; var16++) {
            if (var1 > 175 && var2 > 230 + var16 * 20 + 14 && var1 < 625 && var2 < 250 + var16 * 20 + 14 && var3 == 1) {
               this.opselect = var16;
            }
         }

         if (var6 == var14 + 2) {
            this.xt.servport = 7071 + this.opselect;
            this.xt.lan = false;
            var6 = -1;
            this.fase = 18;
            var5.fase = 0;
         }
      }

      if (this.fase == 3) {
         if (var1 > 295 && var2 > 334 && var1 < 505 && var2 < 348) {
            if (!this.onf) {
               this.onf = true;
               this.gs.setCursor(new Cursor(12));
            }
         } else if (this.onf) {
            this.onf = false;
            this.gs.setCursor(new Cursor(0));
         }

         if (this.onf && var3 == 11) {
            this.msg = "Please enter your Email Address to recover your account details.";
            this.gs.tnick.setForeground(new Color(0, 0, 0));
            this.gs.tpass.setForeground(new Color(0, 0, 0));
            this.gs.tnick.hide();
            this.gs.tpass.hide();
            this.gs.keplo.hide();
            this.onf = false;
            this.gs.setCursor(new Cursor(0));
            this.fase = 7;
         }

         if (var1 > this.xrl && var1 < this.xrr && var2 > 360 && var2 < 373) {
            if (!this.onr) {
               this.onr = true;
               this.gs.setCursor(new Cursor(12));
            }
         } else if (this.onr) {
            this.onr = false;
            this.gs.setCursor(new Cursor(0));
         }

         if (this.onr && var3 == 11) {
            this.gs.reglink();
            this.gs.mouses = 0;
         }
      }

      if (this.fase == 1) {
         if (var4.enter) {
            var6 = 2;
            this.pessd[2] = true;
         }

         if (var6 == 2) {
            if (!this.gs.tnick.getText().equals("Fyre") && !this.gs.tnick.getText().equals("Nickname") && !this.gs.tnick.getText().equals("")) {
               this.msg = "| Checking Nickname |";
               this.gs.tnick.disable();
               this.fase = 2;
               this.connector = new Thread(this);
               this.connector.start();
            } else {
               this.msg = "Type in any Nickname to play...";
               this.gs.tnick.setText("Nickname");
               this.nflk = 30;
            }
         }

         if (var6 == 3) {
            if (this.gs.tnick.getText().equals("Nickname") || this.msg.startsWith("This")) {
               this.gs.tnick.setText("");
            }

            this.msg = "Login to access the multiplayer madness!";
            this.gs.tnick.setForeground(new Color(0, 0, 0));
            this.fase = 3;
            var6 = -1;
         }

         if (var6 == 4) {
            if (this.nickero || this.gs.tnick.getText().equals("Nickname")) {
               this.gs.tnick.setText("");
               this.nickero = false;
            }

            this.gs.tnick.setForeground(new Color(0, 0, 0));
            this.gs.reglink();
         }
      }

      if (this.fase == 3) {
         if (var4.enter || this.xt.autolog) {
            var6 = 2;
            this.pessd[2] = true;
            this.xt.autolog = false;
         }

         if (var4.exit) {
            var6 = 3;
         }

         if (var6 == 2) {
            if (this.gs.tnick.getText().equals("")) {
               this.msg = "Enter your Nickname!";
               this.nflk = 30;
            } else if (this.gs.tpass.getText().equals("")) {
               this.msg = "Enter your Password!";
               this.nflk = 30;
            } else {
               this.msg = "| Logging In |";
               this.gs.tnick.disable();
               this.gs.tpass.disable();
               this.gs.keplo.disable();
               this.fase = 4;
               this.connector = new Thread(this);
               this.connector.start();
            }
         }

         if (var6 == 3) {
            this.gs.regnew();
         }
      }

      if (this.fase == 5) {
         if (var4.enter) {
            var6 = 1;
            this.pessd[1] = true;
         }

         if (var4.exit) {
            var6 = 2;
         }

         if (var6 == 1) {
         }

         if (var6 == 2) {
            this.fase = this.lrgfase;
            if (this.fase == 12) {
               this.gs.tnick.hide();
               this.connector = new Thread(this);
               this.connector.start();
            }
         }
      }

      if (this.fase == 7) {
         if (var4.enter) {
            var6 = 2;
            this.pessd[2] = true;
         }

         if (var4.exit) {
            var6 = 3;
         }

         if (var6 == 2) {
            this.nflk = 0;
            if (this.gs.temail.getText().equals("")) {
               this.msg = "Please type in your Email Address!";
               this.nflk = 30;
            }

            if (this.nflk == 0) {
               String var17 = this.gs.temail.getText();
               int var9 = 0;

               byte var10;
               for (var10 = 0; var9 < var17.length(); var9++) {
                  String var11 = "" + var17.charAt(var9);
                  if (var11.equals("@") && var10 == 0 && var9 != 0) {
                     var10 = 1;
                  }

                  if (var11.equals(".") && var10 == 1 && var9 != var17.length() - 1) {
                     var10 = 2;
                  }
               }

               if (var10 != 2) {
                  this.msg = "Please type in your Email Address correctly!";
                  this.nflk = 30;
                  this.errcnt = 40;
                  this.gs.temail.setForeground(new Color(255, 0, 0));
               }
            }

            if (this.nflk == 0) {
               this.msg = "| Checking Email |";
               this.gs.temail.disable();
               this.fase = 8;
               this.connector = new Thread(this);
               this.connector.start();
            }
         }

         if (var6 == 3) {
            this.inishmulti();
            this.gs.temail.setText("");
            this.gs.tpass.setText("");
         }
      }

      this.lxm = var1;
      this.lym = var2;
      var4.enter = false;
      var4.exit = false;
   }

   public void drawSbutton(Image var1, int var2, int var3) {
      this.bx[this.btn] = var2;
      this.by[this.btn] = var3;
      this.bw[this.btn] = var1.getWidth(this.ob);
      if (!this.pessd[this.btn]) {
         this.rd.drawImage(var1, var2 - this.bw[this.btn] / 2, var3 - var1.getHeight(this.ob) / 2 - 1, null);
         this.rd.drawImage(this.xt.bols, var2 - this.bw[this.btn] / 2 - 15, var3 - 13, null);
         this.rd.drawImage(this.xt.bors, var2 + this.bw[this.btn] / 2 + 9, var3 - 13, null);
         this.rd.drawImage(this.xt.bot, var2 - this.bw[this.btn] / 2 - 9, var3 - 13, this.bw[this.btn] + 18, 3, null);
         this.rd.drawImage(this.xt.bob, var2 - this.bw[this.btn] / 2 - 9, var3 + 10, this.bw[this.btn] + 18, 3, null);
      } else {
         this.rd.drawImage(var1, var2 - this.bw[this.btn] / 2 + 1, var3 - var1.getHeight(this.ob) / 2, null);
         this.rd.drawImage(this.xt.bolps, var2 - this.bw[this.btn] / 2 - 15, var3 - 13, null);
         this.rd.drawImage(this.xt.borps, var2 + this.bw[this.btn] / 2 + 9, var3 - 13, null);
         this.rd.drawImage(this.xt.bob, var2 - this.bw[this.btn] / 2 - 9, var3 - 13, this.bw[this.btn] + 18, 3, null);
         this.rd.drawImage(this.xt.bot, var2 - this.bw[this.btn] / 2 - 9, var3 + 10, this.bw[this.btn] + 18, 3, null);
      }

      this.btn++;
   }

   public void drawbutton(Image var1, int var2, int var3) {
      this.bx[this.btn] = var2;
      this.by[this.btn] = var3;
      this.bw[this.btn] = var1.getWidth(this.ob);
      if (!this.pessd[this.btn]) {
         this.rd.drawImage(var1, var2 - this.bw[this.btn] / 2, var3 - var1.getHeight(this.ob) / 2, null);
         this.rd.drawImage(this.xt.bol, var2 - this.bw[this.btn] / 2 - 15, var3 - 16, null);
         this.rd.drawImage(this.xt.bor, var2 + this.bw[this.btn] / 2 + 9, var3 - 16, null);
         this.rd.drawImage(this.xt.bot, var2 - this.bw[this.btn] / 2 - 9, var3 - 16, this.bw[this.btn] + 18, 3, null);
         this.rd.drawImage(this.xt.bob, var2 - this.bw[this.btn] / 2 - 9, var3 + 13, this.bw[this.btn] + 18, 3, null);
      } else {
         this.rd.drawImage(var1, var2 - this.bw[this.btn] / 2 + 1, var3 - var1.getHeight(this.ob) / 2 + 1, null);
         this.rd.drawImage(this.xt.bolp, var2 - this.bw[this.btn] / 2 - 15, var3 - 16, null);
         this.rd.drawImage(this.xt.borp, var2 + this.bw[this.btn] / 2 + 9, var3 - 16, null);
         this.rd.drawImage(this.xt.bob, var2 - this.bw[this.btn] / 2 - 9, var3 - 16, this.bw[this.btn] + 18, 3, null);
         this.rd.drawImage(this.xt.bot, var2 - this.bw[this.btn] / 2 - 9, var3 + 13, this.bw[this.btn] + 18, 3, null);
      }

      this.btn++;
   }

   public void stringbutton(String var1, int var2, int var3, int var4) {
      this.rd.setFont(new Font("Arial", 1, 12));
      this.ftm = this.rd.getFontMetrics();
      this.bx[this.btn] = var2;
      this.by[this.btn] = var3 - 5;
      this.bw[this.btn] = this.ftm.stringWidth(var1);
      if (!this.pessd[this.btn]) {
         this.rd.setColor(this.color2k(220, 220, 220));
         this.rd.fillRect(var2 - this.bw[this.btn] / 2 - 10, var3 - (17 - var4), this.bw[this.btn] + 20, 25 - var4 * 2);
         this.rd.setColor(this.color2k(240, 240, 240));
         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 10, var3 - (17 - var4), var2 + this.bw[this.btn] / 2 + 10, var3 - (17 - var4));
         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 10, var3 - (18 - var4), var2 + this.bw[this.btn] / 2 + 10, var3 - (18 - var4));
         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 9, var3 - (19 - var4), var2 + this.bw[this.btn] / 2 + 9, var3 - (19 - var4));
         this.rd.setColor(this.color2k(200, 200, 200));
         this.rd.drawLine(var2 + this.bw[this.btn] / 2 + 10, var3 - (17 - var4), var2 + this.bw[this.btn] / 2 + 10, var3 + (7 - var4));
         this.rd.drawLine(var2 + this.bw[this.btn] / 2 + 11, var3 - (17 - var4), var2 + this.bw[this.btn] / 2 + 11, var3 + (7 - var4));
         this.rd.drawLine(var2 + this.bw[this.btn] / 2 + 12, var3 - (16 - var4), var2 + this.bw[this.btn] / 2 + 12, var3 + (6 - var4));
         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 10, var3 + (7 - var4), var2 + this.bw[this.btn] / 2 + 10, var3 + (7 - var4));
         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 10, var3 + (8 - var4), var2 + this.bw[this.btn] / 2 + 10, var3 + (8 - var4));
         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 9, var3 + (9 - var4), var2 + this.bw[this.btn] / 2 + 9, var3 + (9 - var4));
         this.rd.setColor(this.color2k(240, 240, 240));
         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 10, var3 - (17 - var4), var2 - this.bw[this.btn] / 2 - 10, var3 + (7 - var4));
         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 11, var3 - (17 - var4), var2 - this.bw[this.btn] / 2 - 11, var3 + (7 - var4));
         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 12, var3 - (16 - var4), var2 - this.bw[this.btn] / 2 - 12, var3 + (6 - var4));
         this.rd.setColor(new Color(0, 0, 0));
         this.rd.drawString(var1, var2 - this.bw[this.btn] / 2, var3);
      } else {
         this.rd.setColor(this.color2k(210, 210, 210));
         this.rd.fillRect(var2 - this.bw[this.btn] / 2 - 10, var3 - (17 - var4), this.bw[this.btn] + 20, 25 - var4 * 2);
         this.rd.setColor(this.color2k(200, 200, 200));
         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 10, var3 - (17 - var4), var2 + this.bw[this.btn] / 2 + 10, var3 - (17 - var4));
         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 10, var3 - (18 - var4), var2 + this.bw[this.btn] / 2 + 10, var3 - (18 - var4));
         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 9, var3 - (19 - var4), var2 + this.bw[this.btn] / 2 + 9, var3 - (19 - var4));
         this.rd.drawLine(var2 + this.bw[this.btn] / 2 + 10, var3 - (17 - var4), var2 + this.bw[this.btn] / 2 + 10, var3 + (7 - var4));
         this.rd.drawLine(var2 + this.bw[this.btn] / 2 + 11, var3 - (17 - var4), var2 + this.bw[this.btn] / 2 + 11, var3 + (7 - var4));
         this.rd.drawLine(var2 + this.bw[this.btn] / 2 + 12, var3 - (16 - var4), var2 + this.bw[this.btn] / 2 + 12, var3 + (6 - var4));
         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 10, var3 + (7 - var4), var2 + this.bw[this.btn] / 2 + 10, var3 + (7 - var4));
         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 10, var3 + (8 - var4), var2 + this.bw[this.btn] / 2 + 10, var3 + (8 - var4));
         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 9, var3 + (9 - var4), var2 + this.bw[this.btn] / 2 + 9, var3 + (9 - var4));
         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 10, var3 - (17 - var4), var2 - this.bw[this.btn] / 2 - 10, var3 + (7 - var4));
         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 11, var3 - (17 - var4), var2 - this.bw[this.btn] / 2 - 11, var3 + (7 - var4));
         this.rd.drawLine(var2 - this.bw[this.btn] / 2 - 12, var3 - (16 - var4), var2 - this.bw[this.btn] / 2 - 12, var3 + (6 - var4));
         this.rd.setColor(new Color(0, 0, 0));
         this.rd.drawString(var1, var2 - this.bw[this.btn] / 2 + 1, var3);
      }

      this.btn++;
   }

   public Color color2k(int var1, int var2, int var3) {
      Color var4 = new Color(var1, var2, var3);
      float[] var5 = new float[3];
      Color.RGBtoHSB(var4.getRed(), var4.getGreen(), var4.getBlue(), var5);
      var5[0] = 0.13F;
      var5[1] = 0.35F;
      return Color.getHSBColor(var5[0], var5[1], var5[2]);
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
            && !var7.equals(" ")
            && !var7.equals("~")
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
            && !var7.equals(" ")) {
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
