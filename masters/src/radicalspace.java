import java.awt.*;
import java.applet.*;
import java.net.*;


public class radicalspace extends Applet implements Runnable
{
Graphics rd;
Image offImage;
MediaTracker mt;

Image star;

Image sm;
Image rp;

Image rank[]=new Image[8];

Image ship[]=new Image[8];
Image shipl[]=new Image[8];
Image shipr[]=new Image[8];
Image turn[]=new Image[8];

Image astro[]=new Image[8];
Image aturn[]=new Image[20];

AudioClip intro;
AudioClip load;
AudioClip main;
boolean playing=false; 

AudioClip boot;
AudioClip shipc;
AudioClip turnc;
AudioClip side;
AudioClip rock;


double w[]=new double[40];
double l[]=new double[40];
double t[]=new double[40];
int c[]=new int[40];
int sc=55;

double sleft[]=new double[40];
double stopp[]=new double[40];
double swidth[]=new double[40];

double twidth=10;
double tleft=-200;
double ttop=-200;
double sml=0;
double smt=0;

double vects=14;
boolean out[]=new boolean[8];

boolean noexp=false;

int z,oft,ofl;
int crnti[]=new int[8];
double devt,devl,adx;

boolean go[]=new boolean[20];
boolean draww[]=new boolean[20];
double atop[]=new double[20];
double aleft[]=new double[20];
double awidth[]=new double[20];
double rl[]=new double[20];
double rt[]=new double[20];
int ci[]=new int[20];
int dv[]=new int[20];

int boost=0;

boolean loaded=false; 
boolean gotc[]=new boolean[8];

Color bbb = new Color(0,0,0) ; 
Thread gamer;

int zoom = 4;
int i,n;

String outer="";
String bank[]=new String[8];
String elev[]=new String[8];


double cleft[]=new double[8];
double ctop[]=new double[8];
double width[]=new double[8];
double speed[]=new double[8];

double getl[]=new double[8];
double gett[]=new double[8];

double randl[]=new double[8];
int cntl[]=new int[8];
double randt[]=new double[8];
int cntt[]=new int[8];
boolean done[] =new boolean[20];

double randb[]=new double[8];
int cntb[]=new int[8];

int show1l=500;
int show2l=-500;
int show1t=500;
int cnt=0;

boolean halt;
int posit=2;
int r=5;
int tubes;
int screan=0;
int fase=-1;
int level=1;
int skipat=200;

URL url1,url2,url3;
int over=0;

int choose[]=new int[8];

double xt;

public boolean mouseDown(Event evt, int xm, int ym)
{
if (screan==0){if (over==0){if (fase==3) { initgame(); screan=1; }if (fase==2) { fase=3; intro.stop(); }if (fase==1) {  if ((xm>20)&&(xm<160)&&(ym>210)&&(ym<270))  { choose[0]=0; choose[1]=2; choose[2]=1; fase=2;}if ((xm>180)&&(xm<320)&&(ym>210)&&(ym<270)) { choose[0]=1; choose[1]=2; choose[2]=0; fase=2;}if ((xm>340)&&(xm<480)&&(ym>210)&&(ym<270)) { choose[0]=2; choose[1]=0; choose[2]=1; fase=2;}}if (fase==0) { if (skipat!=30) { if (cnt>(skipat+345)) { fase=1; skipat=30; } } else { fase=1; if (cnt<skipat) { intro.loop(); } } }}else{if (over==1) { }if (over==2) {  }}setCursor(new Cursor(0));}

if (screan==1)
{
if (tubes==0)
{
if (posit==0) { if (level!=5) { level++; initgame();} else { getAppletContext().showDocument(url3); } } else { screan=0; fase=0; speed[0]=50; cnt=0; for (n=0;n<3;n++) {turn[n]=ship[choose[n]];} }
}
}

return true;
}



public void spaint()
{
Dimension d=getSize();
if (rd==null) return;
rd.clearRect(0,0, d.width, d.height);
rd.setColor(Color.black);
rd.fillRect(0,0, d.width, d.height);


if (loaded) 
{
for (i=0;i<z;i++){rd.drawImage(star,(int)sleft[i],(int)stopp[i],(int)(swidth[i]/1.2),(int)(swidth[i]/1.2),this);} 




if (screan==0)
{
if (fase==0){rd.setFont(new Font("MS Sans Serif",Font.PLAIN,12));rd.drawImage(rp,show1l,30,this); rd.setColor(Color.white);outer="Presents";rd.drawString(outer, (show2l+210),120);rd.drawImage(sm,show2l,150,this); outer="";rd.drawString(outer, (show2l+110),240);rd.setColor(new Color(0,170,225));outer="";rd.drawString(outer, (show2l+262),240);rd.setColor(new Color(225,0,0));outer="> click to continue <";rd.drawString(outer,185,(show1t+50));}
if (fase==1){for (n=0;n<3;n++) { if (turn[n]!=ship[n]) { turn[n]=ship[n]; } }rd.setColor(Color.white);rd.drawImage(sm,0,5,this); outer="Select your ship (click)";rd.drawString(outer,185,150);rd.drawImage(turn[0],0,200,this); rd.drawImage(turn[1],160,200,this);rd.drawImage(turn[2],320,200,this);}
if (fase==2){rd.drawImage(sm,0,5,this);rd.setColor(Color.white);outer="Programing";rd.drawString(outer,210,100);outer="Omar Wally, Omar@radicalplay.com";rd.drawString(outer,145,120);rd.setColor(new Color(0,170,225));outer="";rd.drawString(outer,170,140);rd.setColor(Color.white);outer="Graphics";rd.drawString(outer,215,180);outer="Timour Farid and Omar Wally";rd.drawString(outer,160,200);outer="Music";rd.drawString(outer,225,240);outer="RaveWorld DJ'z at mp3.com";rd.drawString(outer,165,260);rd.setColor(new Color(0,170,225));outer="";rd.drawString(outer,60,280);rd.setColor(new Color(225,0,0));outer="> click to continue <";rd.drawString(outer,190,350);}
if (fase==3){rd.setColor(Color.white);outer="Controls:";rd.drawString(outer,20,50);outer="Use the keyboard arrows to move up,down,left and right";rd.drawString(outer,20,70);outer="Use Space Bar to do a space jump";rd.drawString(outer,20,90);outer="How To Play:";rd.drawString(outer,20,140);outer="This is a space racing game";rd.drawString(outer,20,160);outer="your objective is to finish first in order to move to the next level";rd.drawString(outer,20,180);outer="there are 5 different levels complete them to finish the game";rd.drawString(outer,20,200);outer="to win a race you must try flying through the tubes";rd.drawString(outer,20,220);outer="and you must try to avoid bumping into the rocks";rd.drawString(outer,20,240);outer="if you bump into a rock your speed will decrease for a moment";rd.drawString(outer,20,260);outer="use your space jump to accelerate momentarily";rd.drawString(outer,20,280);outer="wait for your space jump to charge in order to use it again";rd.drawString(outer,20,300);outer="if you miss a tube your space jump will not recharge until the tube passes";rd.drawString(outer,20,320);outer="Your are curently at level "+level+"";rd.drawString(outer,175,350);rd.setColor(new Color(225,0,0));outer="> click to continue <";rd.drawString(outer,190,370);}
}

if (screan==1)
{
if ((!out[0])&&(tubes!=0)) { drawTube(rd,tleft,ttop,twidth); }
for (i=9;i>=0;i--) { if (go[i]) {if ((awidth[i]<(width[1]/2))||(awidth[i]<(width[2]/2))) { draww[i]=false; } else { draww[i]=true; }if (!draww[i]) { rd.drawImage(aturn[i],(int)aleft[i],(int)atop[i],(int)(awidth[i]),(int)(awidth[i]),this); }}  }
for (n=1;n<3;n++){if ((width[n]<190)&&(width[n]>4)) {rd.drawImage(turn[n],(int)(cleft[n]-(width[n]/2)),(int)(ctop[n]-(width[n]/6)),(int)width[n],(int)(width[n]/2), this); }}
for (i=9;i>=0;i--) { if ((go[i])&&(draww[i])) { rd.drawImage(aturn[i],(int)aleft[i],(int)atop[i],(int)(awidth[i]),(int)(awidth[i]),this); }}
if ((out[0])&&(tubes!=0)) { drawTube(rd,tleft,ttop,twidth); }
rd.drawImage(turn[0],160,220,this); 
for (n=1;n<3;n++){if ((width[n]>190)&&(width[n]<250)) { rd.drawImage(turn[n],(int)(cleft[n]-(width[n]/2)-(((width[n]/speed[0])/(width[n]/(250-(cleft[n]-(width[n]/2)))))*(width[n]/60))),(int)(ctop[n]-(width[n]/6)-(((width[n]/speed[0])/(width[n]/(200-(ctop[n]-(width[n]/2)))))*(width[n]/60))),(int)width[n],(int)(width[n]/2), this); }}
rd.drawImage(rank[posit],410,10,this); 
rd.setColor(Color.white);
outer="Tubes Remaning "+tubes+"";rd.drawString(outer, 20, 30);

outer="Level "+level+"";rd.drawString(outer, 150, 30);

outer="Space Jump";rd.drawString(outer, 100, 50);rd.setColor(new Color(225,0,0));rd.drawRect(175,40,170,12);rd.setColor(new Color(200,100,0));if (boost==0) { rd.fillRect(176,41,169,11); rd.setColor(new Color(0,0,0));outer="Active";rd.drawString(outer, 240, 51);} else { rd.fillRect(176,41,(boost*2),11); }
if (halt) {if (cnt>0) { outer="Level "+level+", get ready"; }if (cnt>100) { outer="       3"; } if (cnt>150) { outer="       2"; } if (cnt>200) { outer="       1"; } if (cnt>250) { outer="       0"; halt=false;}cnt++;rd.setColor(Color.white);rd.drawString(outer,200,140);}

if (tubes==0) 
{
if (posit==0)
{
if (level!=5)
{
rd.setColor(Color.white);outer="Congratulations!!  You finished first, click to continue";rd.drawString(outer, 105 , 180);
}
else
{
rd.setColor(Color.white);outer="Congratulations!!  You finished the game, click to continue";rd.drawString(outer, 105, 180);
}
}
else
{
rd.setColor(Color.white);outer="You finished in position "+(posit+1)+" better luck next time, click to continue";rd.drawString(outer, 80, 180);
}
}

}
}
else 
{
rd.setColor(Color.white);
rd.drawString(outer, 165, 270);
rd.setColor(new Color(0,120,170));
rd.drawRect(150,300,200,5);
rd.setColor(new Color(0,80,100));
rd.fillRect(151,302,cnt,2);
}
repaint();
}

public void run()
{
gamer.setPriority(5);

long startat,endat,actat;
actat=30;
int sat=30;

load=getSound("loading.au"); 
cnt+=6;
cnt+=6;spaint();
load.loop();

try
{
url1=new URL("http://www.radicalplay.com/");
url2=new URL("http://artists.mp3s.com/artists/136/rave_world_musik__dj_danny.html");
url3=new URL("http://www.radicalplay.com/masters/xsecret.html");
}
catch(Exception e) { }

outer="Loading Sound FX (26.9 kb)";
boot=getSound("sounds/boost.au");cnt+=6;spaint();
shipc=getSound("sounds/ship.au");cnt+=6;spaint();
turnc=getSound("sounds/turn.au");cnt+=6;spaint();
side=getSound("sounds/side.au");cnt+=6;spaint();
rock=getSound("sounds/rock.au");cnt+=6;spaint();


outer="Loading Space Images (14.3 kb)";
star=getImage("space/star.gif");cnt+=6;spaint();
astro[0]=getImage("space/astro1.gif"); cnt+=6;spaint();
astro[1]=getImage("space/astro2.gif");cnt+=6;spaint();
astro[2]=getImage("space/astro3.gif");cnt+=6;spaint();

outer="Loading Intro Music (55.5 kb)";
intro=getSound("music/intro.au");cnt+=15;spaint();
outer="Loading Main Music (109.9 kb)";
main=getSound("music/main.au");cnt+=35;spaint();


outer="Loading Ships Images (25.8 kb)";
for (i=0;i<3;i++)
{
ship[i] = getImage("space/ship"+i+".gif");cnt+=6;spaint();
shipr[i] = getImage("space/ship"+i+"r.gif");cnt+=6;spaint();
shipl[i] = getImage("space/ship"+i+"l.gif");cnt+=6;spaint();
rank[i]=getImage("space/"+(i+1)+".gif");cnt+=6;spaint();
turn[i]=ship[i];
}
outer="Loading Logo Images (12.5 kb)";
sm=getImage("space/sm.gif");cnt+=6;spaint();
rp=getImage("space/rp.gif");cnt+=6;spaint();


load.stop();
loaded=true;
fase=0;
cnt=0;


while(true)
{
startat=System.currentTimeMillis();

if (screan==0)
{
z=19;
if (fase==0)
{
if (speed[0]>12) { speed[0]-=.5; }
if (cnt==skipat) { intro.loop(); }
if ((cnt>skipat)&&(cnt<(skipat+229))) { show1l-=2; bank[0]="left";}
if (cnt==(skipat+229)) { bank[0]=""; }
if ((cnt>(skipat+240))&&(cnt<(skipat+291))) { show2l+=10; bank[0]="right";}
if (cnt==(skipat+291)) { bank[0]=""; }
if ((cnt>(skipat+300))&&(cnt<(skipat+345))) { show1t-=5; elev[0]="up"; }
if (cnt==(skipat+345)) { elev[0]=""; }
cnt++;
}


}

if (screan==1)
{

if ((!halt)&&(tubes!=0)) { if (!playing) { main.loop(); playing=true; } } else { if (playing) { main.stop(); playing=false; } }

for (n=0;n<3;n++){if (speed[n]<vects) { speed[n]+=.5; }if (speed[n]>vects) { speed[n]-=.5; }if (!halt) { if (speed[n]>30) { speed[n]=30; } ;vects=14 ; } else { vects=400; speed[n]=400; twidth=30; tleft=235 ; ttop=185; out[0]=false; }}

if ((boost!=0)&&(!halt)&&(!out[0])){if (boost==1) { if (tubes!=0){speed[0]=5;} boot.play();}if (boost<84) {boost++;} else { boost=0; } } 

adx=(twidth/speed[0]);
twidth+=adx;
devt=(twidth/(200-ttop));
devl=(twidth/(250-tleft));
tleft-=(adx/devl); 
ttop-=(adx/devt); 

posit=0;
for (n=1;n<3;n++)
{
width[n]+=((width[n]/speed[0])-(width[n]/speed[n]));
if (width[n]<40) { speed[n]=15; }
if (width[n]<width[0]) { posit++; }
}

if (out[0]) { xt=20; } else { xt=25; }

if (!halt)
{
if (bank[0].equals("left")) { tleft+=((twidth/40)*(30/speed[0]));sml+=(0.25*(30/speed[0])); for(n=1;n<3;n++) { cleft[n]+=((width[n]/xt)*(30/speed[0])); } if (turn[0]!=shipl[choose[0]]) { turn[0]=shipl[choose[0]]; turnc.play(); } } 
if (bank[0].equals("right")) { tleft-=((twidth/40)*(30/speed[0])); sml-=(0.25*(30/speed[0]));for(n=1;n<3;n++) { cleft[n]-=((width[n]/xt)*(30/speed[0])); } if (turn[0]!=shipr[choose[0]]) { turn[0]=shipr[choose[0]]; turnc.play(); }  } 
if (elev[0].equals("up")) { ttop+=((twidth/40)*(30/speed[0])); smt+=(0.25*(30/speed[0]));for(n=1;n<3;n++) { ctop[n]+=((width[n]/xt)*(30/speed[0])); }} 
if (elev[0].equals("down")) { ttop-=((twidth/40)*(30/speed[0])); smt-=(0.25*(30/speed[0]));for(n=1;n<3;n++) { ctop[n]-=((width[n]/xt)*(30/speed[0])); }} 
if (bank[0].equals("")){ if (turn[0]!=ship[choose[0]]) { turn[0]=ship[choose[0]];} }

for (n=1;n<3;n++)
{
if (bank[n].equals("left")) { cleft[n]-=((width[n]/xt)*(30/speed[n]));  if (turn[n]!=shipl[choose[n]]) { turn[n]=shipl[choose[n]]; } } 
if (bank[n].equals("right")) { cleft[n]+=((width[n]/xt)*(30/speed[n])); if (turn[n]!=shipr[choose[n]]) { turn[n]=shipr[choose[n]]; } } 
if (elev[n].equals("up")) { ctop[n]-=((width[n]/xt)*(30/speed[n])); } 
if (elev[n].equals("down")) { ctop[n]+=((width[n]/xt)*(30/speed[n])); } 
if (bank[n].equals("")){ if (turn[n]!=ship[choose[n]]) { turn[n]=ship[choose[n]];} }
}
}

try
{
for (n=0;n<3;n++){for (i=0;i<3;i++){if (i!=n){if ((width[i]>(width[n]/1.125))&&(width[i]<width[n])&&((cleft[i]+(width[i]/2))>(cleft[n]-(width[n]/2)))&&((cleft[i]-(width[i]/2))<(cleft[n]+(width[n]/2)))&&((ctop[i]+(width[i]/4))>(ctop[n]-(width[n]/4)))&&((ctop[i]-(width[i]/4))<(ctop[n]+(width[n]/4)))) { horzcolide((Math.random()-0.5),2,n,3);vertcolide((Math.random()-0.5),3,n,3); }}}}
}
catch(Exception e) { } 


for (n=0;n<3;n++)
{
if ((crnti[n]==0)&&(w[0]>(width[n]*5))) { if ( ((cleft[n]-(width[n]/2))>l[crnti[n]]) && ((cleft[n]+(width[n]/2))<(l[crnti[n]]+w[crnti[n]])) && ((ctop[n]-(width[n]/4))>t[crnti[n]]) && ((ctop[n]+(width[n]/6))<(t[crnti[n]]+w[crnti[n]])) ) { out[n]=false; } else { out[n]=true; } }

if (!out[n])
{
if (w[0]>(width[n]*5.55))
{
if ( ((cleft[n]-(width[n]/2))<l[crnti[n]]) && ((cleft[n]+(width[n]/2))>l[crnti[n]]) && (cleft[n]>(t[crnti[n]]+(w[crnti[n]]/3.4))) && (cleft[n]<(t[crnti[n]]+(w[crnti[n]]/3.4)+(w[crnti[n]]/2.4))) ) { horzcolide(-1,2,n,1); }
if ( ((cleft[n]-(width[n]/2))<(l[crnti[n]]+(w[crnti[n]]/6))) && ((cleft[n]+(width[n]/2))>(l[crnti[n]]+(w[crnti[n]]/6))) && (cleft[n]>t[crnti[n]]) && (cleft[n]<(t[crnti[n]]+(w[crnti[n]]/3.4))) ) { horzcolide(-1,2,n,1); }
if ( ((cleft[n]-(width[n]/2))<(l[crnti[n]]+(w[crnti[n]]/6))) && ((cleft[n]+(width[n]/2))>(l[crnti[n]]+(w[crnti[n]]/6))) && (cleft[n]>(t[crnti[n]]+(w[crnti[n]]/3.4)+(w[crnti[n]]/2.4))) && (cleft[n]<(t[crnti[n]]+w[crnti[n]])) ) { horzcolide(-1,2,n,1); }
if ( ((cleft[n]+(width[n]/2))>l[crnti[n]]+w[crnti[n]]) && ((cleft[n]-(width[n]/2))<l[crnti[n]]+w[crnti[n]]) && (cleft[n]>(t[crnti[n]]+(w[crnti[n]]/3.4))) && (cleft[n]<(t[crnti[n]]+(w[crnti[n]]/3.4)+(w[crnti[n]]/2.4))) ) { horzcolide(1,2,n,1);}
if ( ((cleft[n]+(width[n]/2))>(l[crnti[n]]+w[crnti[n]]-(w[crnti[n]]/6))) && ((cleft[n]-(width[n]/2))<(l[crnti[n]]+w[crnti[n]]-(w[crnti[n]]/6))) && (cleft[n]>t[crnti[n]]) && (cleft[n]<(t[crnti[n]]+(w[crnti[n]]/3.4))) ) { horzcolide(1,2,n,1); }
if ( ((cleft[n]+(width[n]/2))>(l[crnti[n]]+w[crnti[n]]-(w[crnti[n]]/6))) && ((cleft[n]-(width[n]/2))<(l[crnti[n]]+w[crnti[n]]-(w[crnti[n]]/6))) && (cleft[n]>(t[crnti[n]]+(w[crnti[n]]/3.4)+(w[crnti[n]]/2.4))) && (cleft[n]<(t[crnti[n]]+w[crnti[n]])) ) { horzcolide(1,2,n,1) ; }
if ( ((ctop[n]+(width[n]/5))>(t[crnti[n]]+w[crnti[n]])) && ((ctop[n]-(width[n]/4))<(t[crnti[n]]+w[crnti[n]])) && (ctop[n]>(l[crnti[n]]+(w[crnti[n]]/5))) && (ctop[n]<(l[crnti[n]]+w[crnti[n]]-(w[crnti[n]]/5))) ){ vertcolide(1,2,n,1); }
if ( ((ctop[n]-(width[n]/3))<(t[crnti[n]]+(w[crnti[n]]/15))) && ((ctop[n]+(width[n]/4))>(t[crnti[n]]+(w[crnti[n]]/15))) && (ctop[n]>(l[crnti[n]]+(w[crnti[n]]/5))) && (ctop[n]<(l[crnti[n]]+w[crnti[n]]-(w[crnti[n]]/5))) ){ vertcolide(-1,2,n,1); }
}
}
else
{
if (w[0]>(width[n]*5.55))
{
if ( ((cleft[n]+(width[n]/2))>l[crnti[n]]) && ((cleft[n]-(width[n]/2))<l[crnti[n]]) && (cleft[n]>(t[crnti[n]]+(w[crnti[n]]/3.4))) && (cleft[n]<(t[crnti[n]]+(w[crnti[n]]/3.4)+(w[crnti[n]]/2.4))) ) { horzcolide(1.5,2,n,1); }
if ( ((cleft[n]+(width[n]/2))>(l[crnti[n]]+(w[crnti[n]]/16))) && ((cleft[n]-(width[n]/2))<(l[crnti[n]]+(w[crnti[n]]/16))) && (cleft[n]>t[crnti[n]]) && (cleft[n]<(t[crnti[n]]+(w[crnti[n]]/3.4))) ) { horzcolide(1.5,2,n,1); }
if ( ((cleft[n]+(width[n]/2))>(l[crnti[n]]+(w[crnti[n]]/16))) && ((cleft[n]-(width[n]/2))<(l[crnti[n]]+(w[crnti[n]]/16))) && (cleft[n]>(t[crnti[n]]+(w[crnti[n]]/3.4)+(w[crnti[n]]/2.4))) && (cleft[n]<(t[crnti[n]]+w[crnti[n]])) ) { horzcolide(1.5,2,n,1); }
if ( ((cleft[n]-(width[n]/2))<l[crnti[n]]+w[crnti[n]]) && ((cleft[n]+(width[n]/2))>l[crnti[n]]+w[crnti[n]]) && (cleft[n]>(t[crnti[n]]+(w[crnti[n]]/3.4))) && (cleft[n]<(t[crnti[n]]+(w[crnti[n]]/3.4)+(w[crnti[n]]/2.4))) ) { horzcolide(-1.5,2,n,1);}
if ( ((cleft[n]-(width[n]/2))<(l[crnti[n]]+w[crnti[n]]-(w[crnti[n]]/16))) && ((cleft[n]+(width[n]/2))>(l[crnti[n]]+w[crnti[n]]-(w[crnti[n]]/16))) && (cleft[n]>t[crnti[n]]) && (cleft[n]<(t[crnti[n]]+(w[crnti[n]]/3.4))) ) { horzcolide(-1.5,2,n,1); }
if ( ((cleft[n]-(width[n]/2))<(l[crnti[n]]+w[crnti[n]]-(w[crnti[n]]/16))) && ((cleft[n]+(width[n]/2))>(l[crnti[n]]+w[crnti[n]]-(w[crnti[n]]/16))) && (cleft[n]>(t[crnti[n]]+(w[crnti[n]]/3.4)+(w[crnti[n]]/2.4))) && (cleft[n]<(t[crnti[n]]+w[crnti[n]])) ) { horzcolide(-1.5,2,n,1) ; }
if ( ((ctop[n]-(width[n]/5))<(t[crnti[n]]+(w[crnti[n]]*1.05))) && ((ctop[n]+(width[n]/4))>(t[crnti[n]]+(w[crnti[n]]*1.05))) && (ctop[n]>(l[crnti[n]]+(w[crnti[n]]/5))) && (ctop[n]<(l[crnti[n]]+w[crnti[n]]-(w[crnti[n]]/5))) ){ vertcolide(-1.5,2,n,1); }
if ( ((ctop[n]+(width[n]/3))>(t[crnti[n]]+(w[crnti[n]]/15))) && ((ctop[n]-(width[n]/4))<(t[crnti[n]]+(w[crnti[n]]/15))) && (ctop[n]>(l[crnti[n]]+(w[crnti[n]]/5))) && (ctop[n]<(l[crnti[n]]+w[crnti[n]]-(w[crnti[n]]/5))) ){ vertcolide(1.5,2,n,1); }
}
}
}


for (i=0;i<10;i++){if (go[i]){awidth[i]=(w[ci[i]]/5);if (awidth[i]>105){awidth[i]=105; aleft[i]-=(((awidth[i]/speed[0])/(awidth[i]/(250-aleft[i])))*10); atop[i]-=(((awidth[i]/speed[0])/(awidth[i]/(200-atop[i])))*10); if(aleft[i]<-105||aleft[i]>500||atop[i]<-105||atop[i]>400) { go[i]=false; awidth[i]=1;}}else{aleft[i]=(l[ci[i]]+(w[ci[i]]/rl[i]));atop[i]=(t[ci[i]]+(w[ci[i]]/rt[i]));
for (n=0;n<3;n++){if ((awidth[i]>(width[n]/2))&&(awidth[i]<(width[n]/1.7))){if ( ((aleft[i]+awidth[i])>(cleft[n]-(width[n]/3))) && (aleft[i]<(cleft[n]+(width[n]/3))) && ((atop[i]+awidth[i])>(ctop[n]-(width[n]/6))) && (atop[i]<(ctop[n]+(width[n]/6))) ) { horzcolide(((Math.random()*2)-1),3,n,2);vertcolide(((Math.random()*2)-1),3,n,2);}}}}}}

if (out[0]) { speed[0]=17; }

if ((twidth/400)>400) 
{ 
if (tubes!=0)
{
if (out[0]) { out[0]=false; speed[0]=14; }
tubes--;
twidth=10; tleft=(((Math.random()*(2*(level+5)))+(250-((2*(level+5))/2)))+sml-5); ttop=(((Math.random()*(2*(level+5)))+(200-((2*(level+5))/2)))+smt-5);
for (i=0;i<r;i++){ci[i]=(i+1)*(18/r);dv[i]=1;rl[i]=((Math.random()*3)+1.25);rt[i]=((Math.random()*3)+1.25);aturn[i]=astro[(int)(Math.floor(Math.random()*3))];done[i]=false;go[i]=true; }
}
}

for (n=1;n<3;n++)
{
getl[n]=(l[crnti[n]]+(w[crnti[n]]/2));
gett[n]=(t[crnti[n]]+(w[crnti[n]]/2));

if (tubes==0)
{
getl[n]=(250+(Math.random()*300)-150);
gett[n]=(200+(Math.random()*300)-150);
w[crnti[n]]=10;
}

for (i=0;i<5;i++) { if ((!done[i])&&(go[i])&&(awidth[i]>(width[n]/6))&&(awidth[i]<(width[n]/2))&&((aleft[i]+awidth[i])>(cleft[n]-(width[n]/3))) && (aleft[i]<(cleft[n]+(width[n]/3))) && ((atop[i]+awidth[i])>(ctop[n]-(width[n]/6))) && (atop[i]<(ctop[n]+(width[n]/6)))) { if (Math.random()>.5){if ((cleft[n]-l[crnti[n]])>((l[crnti[n]]+w[crnti[n]])-cleft[n])) { getl[n]=(l[crnti[n]]+(w[crnti[n]]/5)); } else { getl[n]=(l[crnti[n]]+w[crnti[n]]-(w[crnti[n]]/4)); }randl[n]=0;}else{if ((ctop[n]-t[crnti[n]])>((t[crnti[n]]+w[crnti[n]])-ctop[n])) { gett[n]=(t[crnti[n]]+(w[crnti[n]]/5)); } else { gett[n]=(t[crnti[n]]+w[crnti[n]]-(w[crnti[n]]/4)); }randt[n]=0;}done[i]=true;}}

if ((cntb[n]>randb[n])&&(tubes!=0)) 
{
if (n!=0) { speed[n]=5; } else { boost=1; }
if (width[n]<180) { randb[n]=((Math.random()*(95-(level*15)))+60); } else { randb[n]=((Math.random()*(190-(level*30)))+60); }
cntb[n]=0;
} else { cntb[n]++; }

if (cntl[n]>randl[n]){if (((cleft[n]-getl[n])<(w[crnti[n]]/10))&&((cleft[n]-getl[n])>-(w[crnti[n]]/10))){bank[n]="";}else{if (cleft[n]>getl[n]) { bank[n]="left" ; }if (cleft[n]<getl[n]) { bank[n]="right" ; }}randl[n]=((Math.random()*10)+5);cntl[n]=0;} else { cntl[n]++; }
if (cntt[n]>randt[n]){if (((ctop[n]-gett[n])<(w[crnti[n]]/10))&&((ctop[n]-gett[n])>-(w[crnti[n]]/10))){elev[n]="";}else{if (ctop[n]>gett[n]) { elev[n]="up" ; }if (ctop[n]<gett[n]) { elev[n]="down" ; }}randt[n]=((Math.random()*10)+5);cntt[n]=0;} else { cntt[n]++; }
}

} //screan=1;



try
{
for (i=0;i<z;i++){adx=(swidth[i]/speed[0]);swidth[i]+=adx;devt=(swidth[i]/(200-stopp[i]));devl=(swidth[i]/(250-sleft[i]));sleft[i]-=(adx/devl); stopp[i]-=(adx/devt);ofl=0;oft=0;if (bank[0].equals("left")) { sleft[i]+=((swidth[i]/2)*(30/speed[0])); ofl=-15; } if (bank[0].equals("right")) { sleft[i]-=((swidth[i]/2)*(30/speed[0])); ofl=15; } if (elev[0].equals("up")) { stopp[i]+=((swidth[i]/2)*(30/speed[0])); oft=-15;}if (elev[0].equals("down")) { stopp[i]-=((swidth[i]/2)*(30/speed[0])); oft=15;} if (swidth[i]>18) { sleft[i]-=((adx/devl)*4); stopp[i]-=((adx/devt)*4); }if (swidth[i]>((Math.random()*5)+22)||sleft[i]<0||sleft[i]>500||stopp[i]<0||stopp[i]>400){swidth[i]=1; sleft[i]=((Math.random()*60)+220+ofl) ; stopp[i]=((Math.random()*60)+170+oft) ;}}
}
catch(Exception e) { } 

spaint();
endat=System.currentTimeMillis();

if ((endat-startat)!=0)
{
actat=((20+sat)-(endat-startat));
if (actat<5) { actat=5; }
if (sat!=7) { sat--; }
}
else
{
if (sat<40) { sat++; }
}

try 
{

gamer.sleep(actat); 

}
catch(InterruptedException e){ }
}


}


public void init()
{
setBackground(Color.black);
Dimension thisSize = this.getSize();
offImage=createImage(thisSize.width,thisSize.height);
if (offImage!=null)
rd=offImage.getGraphics();
System.gc();
speed[0]=50;

for (n=0;n<3;n++)
{
elev[n]="";
bank[n]="";
}
choose[0]=1;
choose[1]=0;
choose[2]=2;

for (i=0;i<19;i++)
{
swidth[i]=1; sleft[i]=((Math.random()*60)+220) ; stopp[i]=((Math.random()*60)+170) ;
}


}

public void initgame()
{
z=4;

cleft[0]=250;
ctop[0]=250;
width[0]=180;
speed[0]=vects;
out[0]=false;

cleft[1]=190;
ctop[1]=230;
width[1]=140;
speed[1]=vects;
out[1]=false;

cleft[2]=310;
ctop[2]=230;
width[2]=140;
speed[2]=vects;
out[2]=false;

for (n=0;n<3;n++)
{
elev[n]="";
bank[n]="";
turn[n]=ship[choose[n]];
}

halt=true;
boost=0;
tubes=10;

sml=0;
smt=0;

show1l=500;
show2l=-500;
show1t=500;
cnt=0;

for (i=0;i<4;i++) { 

randl[i]=((Math.random()*10)+10);
cntl[i]=0;
randt[i]=((Math.random()*10)+10);
cntt[i]=0;
randb[i]=((Math.random()*40)+70);
cntb[i]=0;

gotc[i]=false; crnti[i]=0; 
}

for (i=0;i<10;i++) { go[i]=false;  }
cnt=0;
}


       


public boolean keyDown(Event e, int key) 
{
if (key==1006) {bank[0]="left";}//left
if (key==1007){bank[0]="right";}//right
if (key==1005){elev[0]="down";}//down
if (key==1004){elev[0]="up";}//up
if (key==32){if (boost==0){boost=1;} } //space bar
if (key==10){
if (screan==0)
{
if (fase==3) { initgame(); screan=1; }
if (fase==2) { fase=3; intro.stop(); }
if (fase==1) { fase=2; } //select
if (fase==0) { if (skipat!=30) { if (cnt>(skipat+345)) { fase=1; skipat=30; } } else { fase=1; if (cnt<skipat) { intro.loop(); } } }
}

if (screan==1)
{
if (tubes==0)
{
if (posit==0) { if (level!=5) { level++; initgame();} else { getAppletContext().showDocument(url3); } } else { screan=0; fase=0; speed[0]=50; cnt=0; for (n=0;n<3;n++) {turn[n]=ship[choose[n]];} }
}
}

} 

return true;
}

public boolean keyUp(Event e, int key) 
{
if (key==1006) {bank[0]="";}
if (key==1007){bank[0]="";}
if (key==1005){elev[0]="";}
if (key==1004){elev[0]="";}
return true;
}

public void paint(Graphics g)
{
g.drawImage(offImage,0,0,this);
}


public void update(Graphics g) 
{
paint(g);
}


public boolean mouseMove(Event evt, int xm, int ym){if (screan==0){over=0;setCursor(new Cursor(0));if ((fase==0)&&(cnt>(skipat+291))&&(xm>260)&&(xm<410)&&(ym>220)&&(ym<250)) { over=1; }if (fase==2){if ((xm>167)&&(xm<320)&&(ym>120)&&(ym<150)) {  over=1; }if ((xm>60)&&(xm<440)&&(ym>260)&&(ym<290)) {  over=2; }}if (fase==1){if ((xm>20)&&(xm<160)&&(ym>210)&&(ym<270)) { setCursor(new Cursor(12)); }if ((xm>180)&&(xm<320)&&(ym>210)&&(ym<270)) { setCursor(new Cursor(12)); }if ((xm>340)&&(xm<480)&&(ym>210)&&(ym<270)) { setCursor(new Cursor(12)); }}}return true;}
public void horzcolide(double d,int mag,int nn, int type){int u;if (nn==0){speed[nn]+=mag;tleft+=(d*(twidth/20)*(30/speed[nn]));for (u=0;u<10;u++) { sleft[u]+=(d*swidth[u]*(30/speed[nn])); }for (u=1;u<3;u++){cleft[u]+=(d*(width[u]/(xt/2))*(30/speed[nn]));}sml+=(d*(30/speed[nn])*(0.5));sc=1;if (type==1) { if (tubes!=0) {side.play();} }if (type==2) { rock.play(); }if (type==3) { shipc.play(); }}else{speed[nn]+=mag;cleft[nn]-=(d*(width[nn]/(xt/2))*(30/speed[0]));sc=1;}}
public void vertcolide(double d,int mag,int nn,int type){int u;if (nn==0){speed[nn]+=mag;ttop+=(d*(twidth/20)*(30/speed[nn]));for (u=0;u<10;u++) { stopp[u]+=(d*swidth[u]*(30/speed[nn])); }for (u=1;u<3;u++){ctop[u]+=(d*(width[u]/(xt/2))*(30/speed[nn]));}smt+=(d*(30/speed[nn])*(0.5));sc=1;if (type==1) { if (tubes!=0) { side.play();} }}else{speed[nn]+=mag;ctop[nn]-=(d*(width[nn]/(xt/2))*(30/speed[0]));sc=1;}}
public void drawTube(Graphics g,double x,double y,double xwidth){l[0]=x;t[0]=y;w[0]=xwidth;for (n=0;n<4;n++) {gotc[n]=false; }c[0]=(int)(w[0]); if (c[0]>200) { c[0]=200; }for (n=0;n<3;n++){if (w[0]<(width[n]*5.55)) { if (!gotc[n]) { crnti[n]=0; gotc[n]=true; } } }if (w[0]<2000){vect(g, l[0]+(w[0]/3.4)+(w[0]/2.4) , t[0], l[0]+(w[0]/3.4)+(w[0]/2.4)+(w[0]/3.4) , t[0]+(w[0]/3.4) , c[0]);vect(g, l[0]+(w[0]/3.4)+(w[0]/2.4)+(w[0]/3.4) , t[0]+(w[0]/3.4)+(w[0]/2.4) , l[0]+(w[0]/3.4)+(w[0]/2.4) , t[0]+(w[0]/3.4)+(w[0]/2.4)+(w[0]/3.4) , c[0]);vect(g, l[0]+(w[0]/3.4) , t[0]+(w[0]/3.4)+(w[0]/2.4)+(w[0]/3.4), l[0] , t[0]+(w[0]/3.4)+(w[0]/2.4),c[0]);vect(g, l[0] , t[0]+(w[0]/3.4) , l[0]+(w[0]/3.4) , t[0] ,c[0]);vect(g, l[0]+(w[0]/3.4) , t[0] , l[0]+(w[0]/3.4)+(w[0]/2.4) , t[0],c[0]); vect(g, l[0]+(w[0]/3.4)+(w[0]/2.4)+(w[0]/3.4) , t[0]+(w[0]/3.4) , l[0]+(w[0]/3.4)+(w[0]/2.4)+(w[0]/3.4) , t[0]+(w[0]/3.4)+(w[0]/2.4) ,c[0]); vect(g, l[0]+(w[0]/3.4) , t[0]+(w[0]/3.4)+(w[0]/2.4)+(w[0]/3.4) , l[0]+(w[0]/3.4)+(w[0]/2.4) , t[0]+(w[0]/3.4)+(w[0]/2.4)+(w[0]/3.4),c[0]); vect(g, l[0] , t[0]+(w[0]/3.4) , l[0] , t[0]+(w[0]/3.4)+(w[0]/2.4),c[0]); }for (i=1;i<19;i++){w[i]=(w[i-1]-(w[i-1]/zoom));l[i]=(250-(((250-l[i-1])*w[i])/w[i-1])); t[i]=(200-(((200-t[i-1])*w[i])/w[i-1]));c[i]=(int)(w[i]); if (c[i]>200) { c[i]=200; }for (n=0;n<3;n++){if (w[i]<(width[n]*5.55)) { if (!gotc[n]) { crnti[n]=i; gotc[n]=true; } } }if (w[i]<2000){vect(g, l[i]+(w[i]/3.4)+(w[i]/2.4) , t[i], l[i]+(w[i]/3.4)+(w[i]/2.4)+(w[i]/3.4) , t[i]+(w[i]/3.4) , c[i]);vect(g, l[i]+(w[i]/3.4)+(w[i]/2.4)+(w[i]/3.4) , t[i]+(w[i]/3.4)+(w[i]/2.4) , l[i]+(w[i]/3.4)+(w[i]/2.4) , t[i]+(w[i]/3.4)+(w[i]/2.4)+(w[i]/3.4) , c[i]);vect(g, l[i]+(w[i]/3.4) , t[i]+(w[i]/3.4)+(w[i]/2.4)+(w[i]/3.4), l[i] , t[i]+(w[i]/3.4)+(w[i]/2.4),c[i]);vect(g, l[i] , t[i]+(w[i]/3.4) , l[i]+(w[i]/3.4) , t[i] ,c[i]);vect(g, l[i]+(w[i]/3.4) , t[i] , l[i]+(w[i]/3.4)+(w[i]/2.4) , t[i],c[i]);vect(g, l[i]+(w[i]/3.4)+(w[i]/2.4)+(w[i]/3.4) , t[i]+(w[i]/3.4) , l[i]+(w[i]/3.4)+(w[i]/2.4)+(w[i]/3.4) , t[i]+(w[i]/3.4)+(w[i]/2.4) ,c[i]);vect(g, l[i]+(w[i]/3.4) , t[i]+(w[i]/3.4)+(w[i]/2.4)+(w[i]/3.4) , l[i]+(w[i]/3.4)+(w[i]/2.4) , t[i]+(w[i]/3.4)+(w[i]/2.4)+(w[i]/3.4),c[i]); vect(g, l[i] , t[i]+(w[i]/3.4) , l[i] , t[i]+(w[i]/3.4)+(w[i]/2.4),c[i]); vect(g, l[i-1]+(w[i-1]/3.4) , t[i-1], l[i]+(w[i]/3.4) , t[i], c[i]);vect(g, l[i-1]+(w[i-1]/3.4)+(w[i-1]/2.4) , t[i-1] , l[i]+(w[i]/3.4)+(w[i]/2.4) , t[i],c[i]);vect(g, l[i-1]+(w[i-1]/3.4)+(w[i-1]/2.4)+(w[i-1]/3.4) , t[i-1]+(w[i-1]/3.4) , l[i]+(w[i]/3.4)+(w[i]/2.4)+(w[i]/3.4) , t[i]+(w[i]/3.4) ,c[i]); vect(g, l[i-1]+(w[i-1]/3.4)+(w[i-1]/2.4)+(w[i-1]/3.4) , t[i-1]+(w[i-1]/3.4)+(w[i-1]/2.4) , l[i]+(w[i]/3.4)+(w[i]/2.4)+(w[i]/3.4) , t[i]+(w[i]/3.4)+(w[i]/2.4) ,c[i]); vect(g, l[i-1]+(w[i-1]/3.4) , t[i-1]+(w[i-1]/3.4)+(w[i-1]/2.4)+(w[i-1]/3.4) ,l[i]+(w[i]/3.4) , t[i]+(w[i]/3.4)+(w[i]/2.4)+(w[i]/3.4),c[i]);vect(g, l[i-1]+(w[i-1]/3.4)+(w[i-1]/2.4) , t[i-1]+(w[i-1]/3.4)+(w[i-1]/2.4)+(w[i-1]/3.4) , l[i]+(w[i]/3.4)+(w[i]/2.4) , t[i]+(w[i]/3.4)+(w[i]/2.4)+(w[i]/3.4),c[i]);vect(g, l[i-1] , t[i-1]+(w[i-1]/3.4) , l[i] , t[i]+(w[i]/3.4),c[i]);vect(g, l[i-1] , t[i-1]+(w[i-1]/3.4)+(w[i-1]/2.4) , l[i] , t[i]+(w[i]/3.4)+(w[i]/2.4),c[i]);}}if (sc==1) { sc=0; }}
private Image getImage(String name){if(mt == null)mt = new MediaTracker(this);Image img = getImage(getCodeBase(), name);mt.addImage(img, 0);try{mt.waitForID(0);}catch(Exception exception) { }return img;}
private AudioClip getSound(String name){AudioClip ac = getAudioClip(getCodeBase(), name);ac.play();Thread.yield();ac.stop();return ac;}

public void vect(Graphics g,double fx,double fy,double tx,double ty,int c){if (sc==1){if (c>100) { Color mm=new Color(0,225,225); g.setColor(mm); }  else { Color mm=new Color(c,c,c); g.setColor(mm); }} else { Color mm=new Color(c,c,c); g.setColor(mm);}g.drawLine((int)(fx),(int)(fy),(int)(tx),(int)(ty)); }


public void start(){if (gamer== null)gamer = new Thread(this);gamer.start();}	
public void stop(){if (gamer != null)gamer.stop();gamer = null; main.stop(); intro.stop(); load.stop();}	


}