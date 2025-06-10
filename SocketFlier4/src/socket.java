import java.awt.*;
import java.applet.*;
import java.net.*;

public class socket extends Applet implements Runnable
{
Image     offI;
Graphics  offG;
MediaTracker mt;
Thread gamer;

Image lay1,lay2,lay3,lay4,ship,laser,base,sockt,gm,con;
Image bz[]=new Image[5];
Image ali[]=new Image[5];
Image boss[]=new Image[5];
Image ex[]=new Image[5];
Image wam[]=new Image[5];

AudioClip les;
AudioClip hit;
AudioClip ep;
AudioClip wm;
AudioClip nochance;
AudioClip belong;
AudioClip haha;

int top1=0;
int top2=-400;
int top3=0;
int top4=-300;
int top5=0;
int top6=-300;
int hcnt=0;

int stal[]=new int[4];
int stat[]=new int[4];


int bank,goin,shipl,shoot,hitl,hitr,hitin,basecnt,wamflg,shakewild,bhealth,bexp,bexflg,baset,sexp,sflg,bbang,health,sptime,hah;
double speed,add;

int level=1;
int perc=0;
int loaded=0;
int prom=1;

boolean lgo[]=new boolean[10];
int ltop[]=new int[10];
int lleft[]=new int[10];
int aleft[]=new int[10];
int atop[]=new int[10];
boolean ago[]=new boolean[10];
int mag[]=new int[10];
double randact[]=new double[10];
int randc[]=new int[10];
int exp[]=new int[10];
int flg[]=new int[10];
boolean wgo[]=new boolean[10];
int wtop[]=new int[10];
int wleft[]=new int[10];
int scnt[]=new int[10];
int wan[]=new int[10];
int wflg[]=new int[10];


double bact;
int btop,bleft,bcnt,magt,magl;
boolean bgo;

String outer="";

String left="";

public void paint(Graphics g)
{
int i;
int ctemp;

if ((loaded==1)&&(prom==1))
{
if (top1>=200) { top1=top2-400; }if (top1>=-400) { g.drawImage(lay1,0,top1,this); } if (top2>=200) { top2=top1-400; }if (top2>=-400) { g.drawImage(lay1,0,top2,this); } if (top3>=200) { top3=top4-300; }if (top3>=-300) { g.drawImage(lay2,0,top3,this); } if (top4>=200) { top4=top3-300; }if (top4>=-300) { g.drawImage(lay2,0,top4,this); } 

if ((baset>-200)&&(baset<210)) 
{ 
g.drawImage(base,0,baset,this); 
if ((baset+200)>170)
{
g.drawImage(ex[bbang],50,(baset+40),this);
g.drawImage(ex[bbang],100,(baset+40),this);
g.drawImage(ex[bbang],150,(baset+40),this);
g.drawImage(ex[bbang],200,(baset+40),this);
g.drawImage(ex[bbang],50,(baset+100),this);
g.drawImage(ex[bbang],100,(baset+100),this);
g.drawImage(ex[bbang],150,(baset+100),this);
g.drawImage(ex[bbang],200,(baset+100),this);
g.drawImage(wam[bbang],(int)(Math.random()*200),(baset+50),this);
if (bbang!=4) { bbang++; } else { bbang=0; }
if (bbang==0)
{
gethit((int)(50+Math.random()*200),(int)(baset+(Math.random()*150)),g,0);
gethit((int)(50+Math.random()*200),(int)(baset+(Math.random()*150)),g,1);
gethit((int)(50+Math.random()*200),(int)(baset+(Math.random()*150)),g,2);
if (Math.random()>.6){ep.play();}
}
}
}


for (i=0;i<10;i++){ if (lgo[i]) { g.drawImage(laser,lleft[i],ltop[i],this); } ; if (wgo[i]) { g.drawImage(wam[wan[i]],(wleft[i]-50),(wtop[i]-50),this); } }

if (basecnt>300) { if (sexp==-1){ g.drawImage(ship,(shipl-15),150,this); } else { if (sexp!=5) { g.drawImage(ex[sexp],(shipl-25),150,this); if(sexp==0){ep.play();}if(sflg==0){sexp++;sflg=3;}else{sflg--;} } else { 
if (baset<-210)
{ 
if (health==0) { basecnt=-4; } 
if (sptime<5) { basecnt=-3; } 
}
 } }  }//ebd

if (hitl!=0) { hitl=gethit((int)(shipl+(Math.random()*20)),(int)(140+(Math.random()*10)),g,0); }
if (hitr!=0) { hitr=gethit((int)(shipl-(Math.random()*20)),(int)(140+(Math.random()*10)),g,0); }


if (bgo) { if (bhealth!=0) { g.drawImage(boss[(level-1)],(bleft-70),(btop-35),this); } else { if (bexp!=5) { g.drawImage(ex[bexp],(bleft-50),(btop-25),this); g.drawImage(ex[bexp],bleft,(btop-25),this); if(bexp==0){ep.play();} if(bexflg==0){bexp++;bexflg=2;}else{bexflg--;}} else { bgo=false; } } }

for (i=0;i<10;i++){ 

if ((getpy(lleft[i],bleft,ltop[i],btop)<2000)&&(lgo[i])&&(bgo)) { if (Math.random()>.5) { gethit(lleft[i],(btop-20),g,0); } else { gethit(lleft[i],(btop-20),g,1); } if(bhealth!=0) {bhealth--;} } 

if (ago[i]) { if (exp[i]==-1) { g.drawImage(ali[(level-1)],(aleft[i]-17),atop[i],this); } else { g.drawImage(ex[exp[i]],(aleft[i]-25),atop[i],this); if(exp[i]==0) { ep.play(); } if(flg[i]==0){exp[i]++;flg[i]=2;}else{flg[i]--;} if (exp[i]==5) { exp[i]=-1; ago[i]=false; } } } }




if (hitin!=0) { hitin=gethit((int)(shipl+(Math.random()*40)-20),(int)(140+(Math.random()*10)),g,2); }


ctemp=(int)(150+speed);
g.setColor(new Color(ctemp,ctemp,ctemp)); 
for (i=0;i<4;i++){g.drawLine(stal[i],stat[i],stal[i],(stat[i]-(int)speed));}



if (top5>=200) { top5=top6-300; }if (top5>=-300) { g.drawImage(lay3,0,top5,this); g.drawImage(lay4,245,top5,this); } if (top6>=200) { top6=top5-300; }if (top6>=-300) { g.drawImage(lay3,0,top6,this); g.drawImage(lay4,245,top6,this); } 

if ( ((basecnt>400)&&(basecnt<405))||((basecnt>410)&&(basecnt<415))||((basecnt>420)&&(basecnt<425))||((basecnt>430)&&(basecnt<435))||((basecnt>440)&&(basecnt<445)) ) 
{ 
g.setColor(new Color(180,180,180));
outer="Level "+level;
g.drawString(outer,130, 80);
}

if (baset>150)
{
if (level!=3)
{
g.drawImage(con,69,20,this);
g.setColor(Color.white);
outer="You finished level "+level+" !" ;
g.drawString(outer,97, 70);
outer="press Enter to play level "+(level+1) ;
g.drawString(outer,80, 150);
}
else
{
g.drawImage(con,69,20,this);
g.setColor(Color.white);
outer="You finished the game!" ;
g.drawString(outer,97, 70);
outer="vist us at www.radicalplay.com for more" ;
g.drawString(outer,60, 150);
}
}


if (basecnt==-4)
{
g.drawImage(gm,94,20,this);
g.setColor(Color.white);
outer="Your ship was destroyed!" ;
g.drawString(outer,95, 70);
outer="press Enter to continue" ;
g.drawString(outer,100, 150);
if (hah==30) { haha.play(); }
hah++;
}

if (basecnt==-3)
{
g.drawImage(gm,94,20,this);
g.setColor(Color.white);
outer="You space time has expired!" ;
g.drawString(outer,85, 70);
outer="hint: the faster you move the less"; 
g.drawString(outer,75, 95);
outer="space time you consume" ;
g.drawString(outer,95, 110);
outer="press Enter to continue" ;
g.drawString(outer,100, 150);
if (hah==30) { haha.play(); }
hah++;
}


if (basecnt==-1) 
{
g.drawImage(sockt,45,15,this);
g.setColor(Color.white);
outer="You mission: destroy aliens and reach the end" ;
g.drawString(outer,30, 80);
outer="before you exceed the space time limit.";
g.drawString(outer,30, 95);
outer="Use the Up/Down arrows to increase/decrease speed,";
g.drawString(outer,30, 115);
outer="the Left and Right arrows to navigate your ship,";
g.drawString(outer,30, 130);
outer="and space bar to shoot";
g.drawString(outer,30, 145);
outer="Press S to Start";
g.drawString(outer,110, 170);

}
else
{
g.setColor(Color.white);
outer="Health";
g.drawString(outer,30, 197);

outer="S-Time";
g.drawString(outer,155, 197);

g.setColor(new Color(50,225,70));
g.drawRect(64,187,75,10); 
g.fillRect(64,187,(health/2),10); 

g.setColor(new Color(50,70,225));
g.drawRect(190,187,75,10); 
g.fillRect(190,187,(sptime/54),10); 
}

} 

else
{
outer="Loading, please wait";
g.drawString(outer,100, 70);

g.drawRect(93,100,114,10); 
g.fillRect(93,100,(perc*3),10); 
}

}

public void run()
{
gamer.setPriority(10);
int i,j;
base=getImage("interface/base.gif"); perc++; repaint(); 
con=getImage("interface/congrat.gif"); perc++; repaint();
gm=getImage("interface/gameover.gif"); perc++; repaint();
lay1=getImage("interface/lay1.gif"); perc++; repaint();
lay2=getImage("interface/lay2.gif"); perc++; repaint();
lay3=getImage("interface/lay3.gif"); perc++; repaint();
lay4=getImage("interface/lay4.gif"); perc++; repaint();
sockt=getImage("interface/socket.gif"); perc++; repaint();
ship=getImage("ships/ship.gif"); perc++; repaint();
laser=getImage("effects/laser.gif"); perc++; repaint();
les=getSound("effects/laser.au"); perc++; repaint();
hit=getSound("effects/hit.au"); perc++; repaint();
ep=getSound("effects/exp.au"); perc++; repaint();
wm=getSound("effects/wam.au"); perc++; repaint();
haha=getSound("effects/haha.au"); perc++; repaint();
nochance=getSound("effects/nochance.au"); perc++; repaint();
belong=getSound("effects/belong.au"); perc++; repaint();
for (i=0;i<5;i++)
{
ex[i]=getImage("effects/ex"+i+".gif"); perc++; repaint();
bz[i]=getImage("effects/bz"+i+".gif"); perc++; repaint();
wam[i]=getImage("effects/wam"+i+".gif"); perc++; repaint();
}
for (i=0;i<3;i++)
{
ali[i]=getImage("ships/ali"+(i+1)+".gif"); perc++; repaint();
boss[i]=getImage("ships/boss"+(i+1)+".gif"); perc++; repaint();
}

loaded=1;

while(true)
{
if (basecnt>300)
{
if (goin==2) { speed+=0.3; }if (goin==1) { speed-=0.6; }
}

if (speed<2) { speed=2; }if (speed>25) { speed=25; }
if ((baset+200)>150) { speed=1; if(sexp==-1){sexp=0;} }

add=(speed/1.3);

if (add>15) { add=15; }
if (add<2) { add=2; }

if (basecnt>300)
{
if (left.equals("jam1")) { shipl-=(int)add; }if (left.equals("jam2")) { shipl+=(int)add; }
}

top1+=(int)(speed/4);top2+=(int)(speed/4);top3+=(int)(speed/2);top4+=(int)(speed/2);top5+=(int)speed;top6+=(int)speed;
for (i=0;i<4;i++){if ((stat[i]-speed)>200) { stat[i]=(int)-speed; stal[i]=(int)((Math.random()*250)+25); }stat[i]+=speed;}


if (shoot==1) { lgo[0]=true; }
for (i=0;i<10;i++)
{
if (lgo[i]) { if (ltop[i]==150) { lleft[i]=(shipl-9); if (i==0){les.play();} } ltop[i]-=10; if (ltop[i]>-10){if ((ltop[i]<100)&&(shoot==1)&&(i!=9)) { lgo[i+1]=true; }} else { lgo[i]=false; ltop[i]=150; }}

if (atop[i]>300) { ago[i]=false; }
if (ago[i]) 
{ 
if (aleft[i]<50) { mag[i]=-mag[i]; }
if (aleft[i]>250) { mag[i]=-mag[i]; }
atop[i]+=(int)(speed/2); 
aleft[i]+=mag[i]; 
}

for(j=0;j<10;j++)
{
if ((getpy(lleft[i],aleft[j],ltop[i],atop[j])<1000)&&(lgo[i])&&(ago[j])&&(exp[j]==-1)) { exp[j]=0; }
}

if ((getpy(shipl,aleft[i],170,atop[i])<1000)&&(ago[i])&&(exp[i]<1)) { hitin=1; }



}

for (i=0;i<(2+level);i++)
{
if (randc[i]>randact[i])
{
if ((!ago[i])&&(basecnt<1000||basecnt>1500)&&(basecnt<2100||basecnt>10100)&&(basecnt>500)&&(basecnt<10400)) { ago[i]=true; atop[i]=-50;mag[i]=(int)((Math.random()*30)-15); aleft[i]=(int)(50+(Math.random()*200));} 
else
{
if (shipl>aleft[i]) { mag[i]=(int)(Math.random()*15); } else { mag[i]=(int)(Math.random()*-15); }
}
randc[i]=0;
randact[i]=(10+(Math.random()*20));
} else { randc[i]++; }

}

for (i=0;i<level;i++)
{

if ((basecnt>1150)&&(basecnt<2000))
{
if (scnt[i]>(60*i)) {if (i==0){if(wamflg==0){wm.play();wamflg=1;}else{wamflg=0;}}  scnt[i]=0; wgo[i]=true; wtop[i]=(int)((Math.random()*20)); wleft[i]=(int)(50+(Math.random()*200)); } else { scnt[i]++; }
if (wgo[i])
{
scnt[i]=0;
if (wtop[i]>250) { wan[i]=0;wgo[i]=false; }
wtop[i]+=(int)((speed/3)+1);

if (getpy(shipl,wleft[i],170,wtop[i])<1500) { hitin=1; }

if(wflg[i]==0){if (wan[i]!=4){wan[i]++;}else {wan[i]=0;wgo[i]=false;} wflg[i]=5;}else{wflg[i]--;}
}
} else { wgo[i]=false; }

}

if (basecnt>2250) { if (basecnt<9999) { if (bhealth!=0) { bgo=true; } else { basecnt=10000; } } }
if (bgo)
{
if (bcnt>bact)
{
if (shipl<bleft) { magl=(int)((Math.random()*-5)-5); } else { magl=(int)((Math.random()*5)+5); }
if (btop>150) { magt=(int)((Math.random()*-(5*level))-5); }
if (btop<50) { magt=(int)((Math.random()*(5*level))+5); }
bcnt=0;
bact=(10+(Math.random()*20));
} else { bcnt++; }

if (getpy(shipl,bleft,170,btop)<1500) { hitin=1; }
if (bhealth!=0)
{
btop+=magt;
bleft+=magl;
}
}


if (basecnt>10400) { baset+=speed; }


if (basecnt==1050) { nochance.play(); }
if (basecnt==2150) { belong.play(); }

if (shipl<27) { shipl=30; hitl=1; }
if (shipl>273) { shipl=270; hitr=1; }

if (basecnt>300) { basecnt++; if (baset<-200) { sptime-=(int)((50-speed)/20); } }

if (sptime<1) { if (sexp==-1){sexp=0;} }
if ((hitin==1)||(hitl==1)||(hitr==1)) { if (health!=0) { health--; } else { if (sexp==-1){sexp=0;} } } 

repaint();
try {gamer.sleep(30); }
catch(InterruptedException e){ }
}
}


public int gethit(int where,int when,Graphics g,int type)
{
if (hcnt==0) { hit.play(); }
g.drawImage(bz[hcnt+type],(where-10),when,this); 
if (hcnt==2) { hcnt=0; return 0; } else { hcnt++; return 1; }
}


public void init()
{
trueint();
}

public void trueint()
{
int i;
bank=0;
goin=0;
speed=2;
add=0;
shipl=150;
shoot=0;
hitl=0;
hitr=0;
hitin=0;
basecnt=-1;
wamflg=0;
shakewild=0;
bact=(10+(Math.random()*20));
btop=-100;
bleft=150;
bcnt=0;
bgo=false;
magl=0;
magt=10;
bhealth=600;
bexp=0;
bexflg=0;
baset=-250;
sexp=-1;
sflg=0;
bbang=0;
health=150;
sptime=4050;
hah=0;

for (i=0;i<4;i++){stat[i]=(i*-50);stal[i]=(int)((Math.random()*250)+25);}

for (i=0;i<10;i++)
{
ltop[i]=150;
lleft[i]=(shipl-9);
lgo[i]=false;
atop[i]=-50;
aleft[i]=(int)(50+(Math.random()*200));
scnt[i]=0;
wtop[i]=-100;
wleft[i]=(int)(50+(Math.random()*200));
wgo[i]=false;
ago[i]=false;
mag[i]=0;
randact[i]=(100+(Math.random()*200));
randc[i]=0;
exp[i]=-1;
flg[i]=0;
wan[i]=0;
wflg[i]=0;
}
}

public boolean keyDown(Event e, int key) 
{
if (key==1006) {left="jam1";}
if (key==1007){left="jam2";}
if (key==1005){goin=1;}
if (key==1004){goin=2;}
if (key==32){if (sexp==-1){shoot=1;}}


if ((key==115)||(key==83)){ if (basecnt==-1) { basecnt=400; } }
if (key==10){ if ((basecnt==-3)||(basecnt==-4)) { trueint(); level=1; } else { if ((baset>150)&&(level!=3)) { trueint(); basecnt=400; level++;  } } }

return true;
}

public boolean keyUp(Event e, int key) 
{
if (key==1006) {left="";}
if (key==1007){left="";}
if (key==1005){goin=0;}
if (key==1004){goin=0;}
if (key==32){shoot=0;}
return true;
}

public int amhit()
{
if ((hitin==1)||(hitl==1)||(hitr==1)) { return 1; } else { return 0; }
}


public int explode()
{
if ((bbang!=0)&&(baset<190)) { return 1; } else { return 0; }
}

public int musicyes()
{
return basecnt;
}

public void promp()
{
prom=1;
}

public void destroy()
{
int i;
base.flush();
con.flush();
gm.flush();
lay1.flush();
lay2.flush();
lay3.flush();
lay4.flush();
sockt.flush();
ship.flush();
laser.flush();
les.stop();
hit.stop();
ep.stop();
wm.stop();
haha.stop();
nochance.stop();
belong.stop();

for (i=0;i<5;i++)
{
ex[i].flush();
bz[i].flush();
wam[i].flush();
}
for (i=0;i<3;i++)
{
ali[i].flush();
boss[i].flush();
}

}

public void update(Graphics g){Dimension d = this.size();if(offI == null){offI = createImage(d.width, d.height);offG = offI.getGraphics();}offG.clearRect(0, 0, d.width, d.height);paint(offG);g.drawImage(offI, 0, 0, null);}
private Image getImage(String name){if(mt == null)mt = new MediaTracker(this);Image img = getImage(getCodeBase(), name);mt.addImage(img, 0);try{mt.waitForID(0);}catch(Exception exception) { }return img;}
private AudioClip getSound(String name){AudioClip ac = getAudioClip(getCodeBase(), name);ac.play();Thread.yield();ac.stop();return ac;}
public int getpy(int x1,int x2,int y1,int y2){return (((x1-x2)*(x1-x2))+((y1-y2)*(y1-y2)));}

public void start(){if (gamer== null)gamer = new Thread(this);gamer.start();}	

public void stop(){if (gamer != null)gamer.stop();gamer = null;}	

}

