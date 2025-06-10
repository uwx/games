import java.awt.*;
import java.applet.*;
import java.awt.image.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.Date;

public class Maniacs extends Applet implements Runnable
{
String outer="";
String stat="";

Graphics rd;
Image offImage;


Image fin[]=new Image[2];
Image checkh[]=new Image[2];
Image chturn;
Image check[]=new Image[2];


int z,n,cnt,tt,tl,w,i,ch,rand;
int itemp; 
int clos[]={1,0,0,0,0,0,0,0};
int clost,closl;
int barow=0;
int rarow=0;
int perc=0 ;
int ecnt=0;

final long DELAY=5;


int carselect[]={1,2,0,0,4,5,0,1}; //selectors


final int cwidth[]= { 60,65,71,70,68,90 };
final int brebo[]={22,26,23,22,22,38};
final int breba[]={13,20,20,20,20,25};  // virtual cars
final int mass[]={15,9,7,5,8,25}; //max 30
final String names[]={"Killer Spike","Hoover Control","Bull Dog","Jet Fuse","Blue Rave","Bad Boy"}; 
final double ml[]={9,8.5,9,9.5,8.5,8}; 
final double g1[]={.3,.3,.3,.3,.3,.3};
final double g2[]={.1,.1,.1,.1,.1,.1};
final double g3[]={.04,.05,.06,.08,.05,.06};//max 0.08


final int stl[][]={{0,0},{40,100,40,100,40,100},{40,100,40,100,40,100},{40,100,40,100,40,100} } ; 
final int stt[][]={{0,0},{-1200,-1160,-1120,-1080,-1040,-1000},{-1200,-1160,-1120,-1080,-1040,-1000},{-1180,-1140,-1100,-1060,-1040,-980} } ;


final int tw[][] = {{0,0},{158,639,1236,1468,1183,300,838,913,913,1148,1500},{206,962,655,1500},{780,597,597,377,476,184,877,109,284,1059,1230,1432} }; 
final int twl[][] ={{0,0},{150,150,0,230,1450,500,628,1374,995,857,0},{216,214,933,0},{-20,233,583,950,1190,982,699,352,591,831 ,172,0} }; 
final int twr[][] ={{0,0},{534,448,87,1347,1500,679,928,1500,1168,1021,1500},{360,358,1500,1500},{184,425,964,978,1388,1314,1387,980,786,1341,1207,1500} } ; 

final int dw[][] = {{0,0},{1036,834,720,440,1029,1029,1029,1234,0},{535,1291,898,0,193},{285,428,127,267,301,796,358,718,1007,612,891,1073,1075,1314,490,0} } ; 
final int dwl[][] ={{0,0},{184,295,158,150,628,995,1374,857,0},{216,214,933,0,943},{113,591,353,950,1121,1197,1430,233,0,583,706,832,699,172,1300,0} } ; 
final int dwr[][] ={{0,0},{316,447,205,679,928,1168,1500,1021,1500},{360,358,1500,1500,1242},{250,787,970,1314,1291,1333,1500,425,183,978,1387,1333,727,1207,1388,1500} } ;

final int lw[][] = {{0,0},{158,158,192,635,1003,1383,866,1458,238,1500},{949,223,221,1500,940},{120,360,958,1130,1437,1197,706,839,1320,598,590,240,179,957,1500} } ; 
final int lwt[][] ={{0,0},{150,631,710,831,905,905,1140,1175,1460,0},{0,200,955,0,648},{0,102,110,260,0,469,870,1052,1059,277,590,590,1223,370,0} } ; 
final int lwd[][] ={{0,0},{452,728,1044,1037,1037,1037,1244,1500,1500,1500},{200,542,1298,1500,905},{292,134,274,308,366,891,1082,1080,1444,435,618,725,1321,612,1500}} ;

final int rw[][] = {{0,0},{530,671,442,310,81,1014,921,1160,1339,0},{1235,353,351,0},{243,782,972,1307,1278,1381,1327,1211,1380,1334,971,418,176,1200,720,0} } ; 
final int rwt[][] ={{0,0},{151,293,631,820,1230,1141,832,906,1459,0},{0,200,955,0},{0,277,103,177,250,469, 476,765,870,1052,369,591,773,1223,877,0} } ; 
final int rwd[][] ={{0,0},{307,447,840,1040,1500,1241,1037,1037,1500,1500},{200,542,1298,1500},{292,435,205,273,308,497,803,891,898,1444,619,725,1014,1321,1082,1500}} ;

final int chtop[][] = {{0,0},{670,120,500,1160,1317},{784,214,211,403,1060,1361} ,{597,241,0,477,891,1055,1290,1240} } ; 
final int chleft[][] ={{0,0},{0,850,1312,1305,255 },{415,76,1045,1362,1353,190}, {471,838,360,1381,1344,720,1200,60} }; 
final int chtype[][] ={{0,0},{0,1,0,0,1},{1,0,1,0,0,1},{0,0,1,0,1,0,0,0} } ;


//


int smover[]={0,0,0,0,0,0}; // real cars
int direct[]={0,0,0,0,0,0};
int indir[]={0,0,0,0,0,0};
int zoned[]={0,0,0,0,0,0};
int prez[]={0,0,0,0,0,0};
int r[]={0,0,0,0,0,0};
int hit[]={0,0,0,0,0,0};
int trns[]={16,16,16,16,16,16};
int chn[]={0,0,0,0,0,0}; 
int x[] = {0,0,0,0,0,0};
int y[] = {0,0,0,0,0,0};
int xc[] = {0,0,0,0,0,0};
int yc[] = {0,0,0,0,0,0};
double cleft[]={40,100,40,100,40,100};
double ctop[]={-1200,-1160,-1120,-1080,-1040,-1000};
int rleft[]={0,0,0,0,0,0};
int rtop[]={0,0,0,0,0,0};
double mover[]={0,0,0,0,0,0};
double tmover=0;
double gear[]={0,0,0,0,0,0}; 
double addt[] = new double[6] ;
double addl[] = new double[6];
double srot[]={8,8,8,8,8,8};
boolean acel[]= { false,false,false,false,false,false  } ;
boolean dacel[]= {false,false,false,false,false,false } ;
boolean cati[][]=new boolean[6][6]; ;
boolean buf[][]=new boolean[6][4];


int loaded=-1;
int screan=0;

String rotate[]={"none","none","none","none","none","none","none","none"};

MediaTracker mt;
AudioClip back;
AudioClip low;
AudioClip side;
AudioClip crash;
AudioClip head;
AudioClip brake;
AudioClip eeee;
AudioClip ooee;
AudioClip exp;
AudioClip bep;
AudioClip clic;

Thread gamer;


//AI vars

int race[]={0,0,0,0,0,0};
int zout[]={0,0,0,0,0,0};
int pout[]={0,0,0,0,0,0};
int abenz[]={0,0,0,0,0,0};
int zget[]={0,0,0,0,0,0};
boolean zflag[]={false,false,false,false,false,false};


boolean got[]={false,false,false,false,false,false};

int getd[]={0,0,0,0,0,0};
int cpre[]={0,0,0,0,0,0};



double randrace[]={0,0,0,0,0,0};
double randz[]={0,0,0,0,0,0};
double randa[]={0,0,0,0,0,0};

boolean getem[]={ false,false,false,false,false,false } ;

boolean inmood[]= {false,false,false,false,false,false } ;


///games vars

int tent=60000;
int ched[]={0,0,0,0,0,0};
int posit[]={0,0,0,0,0,0};
int lap[]={1,1,1,1,1,1};
int was=0;
int out=0;
int sho=100;
int level=1;
int starting=0;
int wait=0;

double health[]={0,0,0,0,0,0};
boolean wasted[]={false,false,false,false,false,false};
boolean loadt[]={false,false,false,false,false};
double fase[]={0,0,0,0,0,0};
boolean music=true;
URL theurl;
URL theurl2;



public void start()
{
if (gamer== null)
gamer = new Thread(this);
gamer.start();
loaded=0 ;
}	

public void distroy() // distroy me
{
rd.dispose();
}

public boolean mouseDown(Event evt, int xm, int ym)
{
if (loaded==1)
{
if (screan==0)
{
for (z=0;z<6;z++){if ((xm>x[z])&&(xm<(x[z]+cwidth[z]))&&(ym>y[z])&&(ym<(y[z]+cwidth[z]))) { perc=0;carselect[0] = z ; clic.play(); }}
autosort();
if (xm>320 && xm<365 && ym>250 && ym<295) { screan=1; clic.play(); }
}
if (screan==1)
{
if (xm>320 && xm<365 && ym>310 && ym<355) { screan=2; clic.play(); }
if (xm>160 && xm<205 && ym>345 && ym<400) { screan=0; clic.play(); }
}
if (screan==2)
{
if (xm>300 && xm<345 && ym>200 && ym<245) { loaded=2; screan=0; clic.play(); }
if (xm>55 && xm<100 && ym>200 && ym<245) { screan=1; clic.play(); }
}
if (xm>300 && xm<377 && ym>370 && ym<400) { loaded=7; brake.play();}
}
if (loaded==7){if (xm>177 && xm<225 && ym>320 && ym<365) { loaded=1;brake.play(); } }
return true;
}

public int talkToMe()
{
if (music)
{
if (loaded==2||loaded==3) { return level; } else { return 0; }
}
else
{
return 0;
}
}


public void paint(Graphics g)
{
g.drawImage(offImage,0,0,this);
}


public void update(Graphics g) 
{
paint(g);
}

public Image rotat(Image im,int w,int h,double an)
{
int pixels[]=new  int[w*h];
int npixels[]=new  int[w*h];
int ix,iy,i,j;
int cx=(w/2);
int cy=(h/2);

PixelGrabber  pg  =new  PixelGrabber(im,  0,  0,  w,  h,  pixels,  0,  w);
try { pg.grabPixels(); }  
catch  (InterruptedException  e)  { }


double a = Math.cos(an*0.017453292519943295D);
double b = Math.sin(an*0.017453292519943295D);
for(i = 0; i < w; i++)
for(j = 0; j < h; j++)
{
                                
ix = cx + (int)Math.round((double)(i - cx) * a - (double)(j - cy) * b);
iy = cy + (int)Math.round((double)(i - cx) * b + (double)(j - cy) * a);
if(ix >= 0 && iy >= 0 && ix < w && iy < h)
{
npixels[w * j + i] = pixels[w * iy + ix];
}
 
}
                    

Image  img  =  createImage(new  MemoryImageSource(w,  h,  npixels,  0,  w));return img;
}


public void spaint() 
{
Dimension d=getSize();
if (rd==null) return;
rd.setColor(Color.black);
rd.fillRect(0,0,d.width, d.height);

if (loaded==0)
{
rd.setColor(Color.white);
outer="Loading Maniac Racers, please wait";
rd.drawString(outer, 110, 110);

rd.setColor(new Color(80,100,120));
rd.drawRect(134,198,133,5);
rd.fillRect(134,198,perc,5);

rd.setColor(Color.gray);
rd.drawString(stat, 150, 300);
}
repaint();
}




public void run()
{
gamer.setPriority(8);

long actat = 0;
int fcnt = 0;
int sec = 0;
Date date1 = new Date();
int fprsec = 10;
boolean skip=false;

Image car[][]=new Image[6][16];
Image turn[]=new Image[16];
Image arowb[]=new Image[9]; 
Image arowr[]=new Image[9]; 
Image track[]=new Image[4];
Image wast[]=new Image[6];
Image dt=getImage("status/dot.gif");
Image het=dt;
Image inter=dt;
Image sel=dt;
Image bar=dt;
Image pla=dt;
Image bac=dt;
Image cre=dt;


while(true)
{
Date date = new Date();
long startat= date.getTime();

if (loaded==1) 
{  
for (w=0;w<6;w++){if (carselect[0]==w) { turn[w] = car[w][perc]; } else  { turn[w] = car[w][0]; }}
if (cnt<3) { cnt++; } else { perc++; cnt=0; }
if(perc==16){perc=0;}
if(perc==-1){perc=15;}
}

if (loaded==2)
{ 
System.gc();
was=0;
out=0;
sho=100;
tent=60000;
starting=1;
for (w=0;w<6;w++)
{
cleft[w]=stl[level][w];
ctop[w]=stt[level][w];
direct[w]=0;
indir[w]=0;
ched[w]=0;
posit[w]=0;
lap[w]=1;
health[w]=0;
wasted[w]=false;
fase[w]=0;
chn[w]=0;
acel[w]=false;
dacel[w]=false;
mover[w]=0;
inmood[w]=false;
}
if (wait<40) { wait++; } else { wait=0;loaded=3;  }
}


if (loaded==3)
{
for (w=0;w<6;w++)
{
xc[w]=(int)cleft[w];
yc[w]=(int)ctop[w];
}
rleft[0]=(int)(200-(cwidth[carselect[0]]/2));
rtop[0]=(int)(200-(cwidth[carselect[0]]/2));
for (w=1;w<6;w++)
{
rleft[w]=(200-xc[w]+xc[0]-(cwidth[carselect[w]]/2));
rtop[w]=(200-yc[w]+yc[0]-(cwidth[carselect[w]]/2));
}

if (starting!=0)
{
if (starting==1) { outer="Stage "+level+", Maniac Racers start you engines..."; }
if (starting==100) { outer="Get Ready!"; bep.play(); }
if (starting==150) { outer="Get SET!"; bep.play(); }
if (starting==200) { outer="GO!!"; bep.play(); starting=0; } else { starting++; }
out=1;
}

for (w=0;w<6;w++)
{
if (starting==0)
{
if ((!wasted[w])&&(lap[0]!=9))
{
if (health[w]<110)
{
if((mover[w]>=0)&&(mover[w]<=2)){gear[w]=g1[carselect[w]]; srot[w]=2; }
if((mover[w]>2)&&(mover[w]<3)){gear[w]=g1[carselect[w]]; srot[w]=2.5; }
if(mover[w]>=3){gear[w]=g3[carselect[w]]; srot[w]=3;};
if(acel[w]){mover[w]+=gear[w];};
if(dacel[w]){if(mover[w]>=-2){mover[w]-=.2;}else{mover[w]-=.02;} ; srot[w]=3 ;   } 
if((!acel[w])&&(!dacel[w])){if(mover[w]>0.1){mover[w]-=.0005;};if(mover[w]<-0.1){mover[w]+=.0005;}}
if (mover[w]>ml[carselect[w]]) { mover[w]=ml[carselect[w]]; }
if (mover[w]<-7) { mover[w]=-7; }
if(rotate[w].equals("right")){if(r[w]>srot[w]){if(mover[w]>0){indir[w]++;};if(mover[w]<0){indir[w]--;};r[w]=0;}r[w]++;}
if(rotate[w].equals("left")){if(r[w]>srot[w]){if(mover[w]>0){indir[w]--;};if(mover[w]<0){indir[w]++;}r[w]=0;}r[w]++;}
if(indir[w]==16){indir[w]=0;}
if(indir[w]==-1){indir[w]=15;}
}
else { if ((!wasted[0])&&(was!=5)) { wasted[w]=true; } }
}
else
{
if (mover[w]>0){mover[w]-=.05;} 
if (mover[w]<0){mover[w]+=.05;}
if (acel[w]) { acel[w]=false; }
if (dacel[w]) { dacel[w]=false; }
}
}

sidesact();
if (indir[w]==2) { direct[w]=1; }
if (indir[w]==6) { direct[w]=3; }
if (indir[w]==10) { direct[w]=5; }
if (indir[w]==14) { direct[w]=7; }
if (indir[w]==15||indir[w]==0||indir[w]==1) { direct[w]=0; }
if (indir[w]==3||indir[w]==4||indir[w]==5) { direct[w]=2; }
if (indir[w]==7||indir[w]==8||indir[w]==9) { direct[w]=4; }
if (indir[w]==11||indir[w]==12||indir[w]==13) { direct[w]=6; }



switch(indir[w])
{
case 0 : addt[w]=mover[w];addl[w]=0;break;
case 1 : addt[w]=(mover[w]*0.923879);addl[w]=-(mover[w]*0.382683);break;
case 2 : addt[w]=(mover[w]/1.414213562);addl[w]=-(mover[w]/1.414213562); break;
case 3 : addt[w]=(mover[w]*0.382683);addl[w]=-(mover[w]*0.923879);break;
case 4 : addt[w]=0;addl[w]=-mover[w];break;
case 5 : addt[w]=-(mover[w]*0.382683);addl[w]=-(mover[w]*0.923879);break;
case 6 : addt[w]=-(mover[w]/1.414213562);addl[w]=-(mover[w]/1.414213562);break;
case 7 : addt[w]=-(mover[w]*0.923879);addl[w]=-(mover[w]*0.382683);break;
case 8 : addt[w]=-mover[w];addl[w]=0;break;
case 9 : addt[w]=-(mover[w]*0.923879);addl[w]=(mover[w]*0.382683);break;
case 10 : addt[w]=-(mover[w]/1.414213562);addl[w]=(mover[w]/1.414213562);break;
case 11 : addt[w]=-(mover[w]*0.382683);addl[w]=(mover[w]*0.923879);break;
case 12 : addt[w]=0;addl[w]=mover[w];break;
case 13 : addt[w]=(mover[w]*0.382683);addl[w]=(mover[w]*0.923879);break;
case 14 : addt[w]=(mover[w]/1.414213562);addl[w]=(mover[w]/1.414213562);break;
case 15 : addt[w]=(mover[w]*0.923879);addl[w]=(mover[w]*0.382683);break;
}
ctop[w]+=addt[w];
cleft[w]+=addl[w];
carstuff();
turn[w] = car[carselect[w]][indir[w]];
if (smover[w]>50) { smover[w]=50; }
if (smover[w]<0) { smover[w]=0; }
if (hit[w]!=0) 
{ 
if (hit[w]==1) { hit[w]++; } 
if (hit[w]==2) { health[w]+=(smover[w]/5); hit[w]=0; }
}
if (wasted[w])
{
if (fase[w]==0) 
{ 
exp.play(); 
ched[w]=-1; 
tent+=30000; 
was++; 
outer=""+names[carselect[w]]+" is wasted !!"; 
out=1;
if (wasted[0]) { outer="YOUR WASTED!"; sho=200;} else
if (was==5) { outer="All cars are wasted !!"; sho=200;}
}
if (fase[w]<5) {fase[w]+=0.25;}
} 
posit[w]=6;
if(!wasted[clos[w]]) {itemp=(int)((ctop[w]-ctop[clos[w]])*(ctop[w]-ctop[clos[w]])+(cleft[w]-cleft[clos[w]])*(cleft[w]-cleft[clos[w]]));} else { itemp=5000000; }
for (n=0;n<6;n++)
{
if(n!=w)
{
if(!wasted[n]) 
{
if(itemp>((ctop[w]-ctop[n])*(ctop[w]-ctop[n])+(cleft[w]-cleft[n])*(cleft[w]-cleft[n]))) { clos[w]=n; }
}
}
if (ched[w]>ched[n]) { posit[w]--; }
}
}
arowsact();

//---  ** AI starts bellow ** ---

for (w=1;w<6;w++)
{

if (race[w]>randrace[w])
{
if (chtype[level][chn[w]]==0)
{
if (((chleft[level][chn[w]]+xc[w]+60)<200)&&((chtop[level][chn[w]]+yc[w]+10)<200)) { getd[w] = 7 ;}   
if (((chleft[level][chn[w]]+xc[w]+60)>200)&&((chtop[level][chn[w]]+yc[w]+10)<200)) { getd[w] = 1 ;}
if (((chleft[level][chn[w]]+xc[w]+60)>200)&&((chtop[level][chn[w]]+yc[w]+10)>200)) { getd[w] = 3 ;}
if (((chleft[level][chn[w]]+xc[w]+60)<200)&&((chtop[level][chn[w]]+yc[w]+10)>200)) { getd[w] = 5 ;}

if (((chleft[level][chn[w]]+xc[w]+60)<200)&&(((chtop[level][chn[w]]+yc[w]-200+10)*(chtop[level][chn[w]]+yc[w]-200+10))<100) ) { getd[w] = 6 ;}   
if (((chleft[level][chn[w]]+xc[w]+60)>200)&&(((chtop[level][chn[w]]+yc[w]-200+10)*(chtop[level][chn[w]]+yc[w]-200+10))<100) ) { getd[w] = 2 ;} 
if (((chtop[level][chn[w]]+yc[w]+10)<200)&&(((chleft[level][chn[w]]+xc[w]-200+60)*(chleft[level][chn[w]]+xc[w]-200+60))<3600) ){ getd[w] = 0 ;} 
if (((chtop[level][chn[w]]+yc[w]+10)>200)&&(((chleft[level][chn[w]]+xc[w]-200+60)*(chleft[level][chn[w]]+xc[w]-200+60))<3600) ){ getd[w] = 4 ;}
}
else
{
if (((chleft[level][chn[w]]+xc[w]+10)<200)&&((chtop[level][chn[w]]+yc[w]+60)<200)) { getd[w] = 7 ;}   
if (((chleft[level][chn[w]]+xc[w]+10)>200)&&((chtop[level][chn[w]]+yc[w]+60)<200)) { getd[w] = 1 ;}
if (((chleft[level][chn[w]]+xc[w]+10)>200)&&((chtop[level][chn[w]]+yc[w]+60)>200)) { getd[w] = 3 ;}
if (((chleft[level][chn[w]]+xc[w]+10)<200)&&((chtop[level][chn[w]]+yc[w]+60)>200)) { getd[w] = 5 ;}
if (((chtop[level][chn[w]]+yc[w]+60)<200)&&(((chleft[level][chn[w]]+xc[w]-200+10)*(chleft[level][chn[w]]+xc[w]-200+10))<100) ){ getd[w] = 0 ;} 
if (((chtop[level][chn[w]]+yc[w]+60)>200)&&(((chleft[level][chn[w]]+xc[w]-200+10)*(chleft[level][chn[w]]+xc[w]-200+10))<100) ){ getd[w] = 4 ;}
if (((chleft[level][chn[w]]+xc[w]+10)<200)&&(((chtop[level][chn[w]]+yc[w]-200+60)*(chtop[level][chn[w]]+yc[w]-200+60))<3600) ) { getd[w] = 6 ;}   
if (((chleft[level][chn[w]]+xc[w]+10)>200)&&(((chtop[level][chn[w]]+yc[w]-200+60)*(chtop[level][chn[w]]+yc[w]-200+60))<3600) ) { getd[w] = 2 ;} 
}
got[w]=false;
randrace[w]=((Math.random()*30)+20);
race[w]=0;
} else { race[w]++; }

if (((ctop[w]-ctop[clos[w]])*(ctop[w]-ctop[clos[w]])+(cleft[w]-cleft[clos[w]])*(cleft[w]-cleft[clos[w]]))<tent)
{
if (posit[0]>=3)
{
if ((getem[w])&&(zget[w]==0))
{
if ((rleft[clos[w]]<rleft[w])&&(rtop[clos[w]]<rtop[w])) { getd[w]=7; }
if ((rleft[clos[w]]<rleft[w])&&(rtop[clos[w]]>rtop[w])) { getd[w]=5; }
if ((rleft[clos[w]]>rleft[w])&&(rtop[clos[w]]<rtop[w])) { getd[w]=1; }
if ((rleft[clos[w]]<rleft[w])&&(rtop[clos[w]]<rtop[w])) { getd[w]=3; }
if ((rtop[clos[w]]<rtop[w])&&(((rleft[w]-rleft[clos[w]])*(rleft[w]-rleft[clos[w]]))<900)) { getd[w]=0 ; }
if ((rtop[clos[w]]>rtop[w])&&(((rleft[w]-rleft[clos[w]])*(rleft[w]-rleft[clos[w]]))<900)) { getd[w]=4 ; }
if ((rleft[clos[w]]<rleft[w])&&(((rtop[w]-rtop[clos[w]])*(rtop[w]-rtop[clos[w]]))<900)) { getd[w]=6 ; }
if ((rleft[clos[w]]>rleft[w])&&(((rtop[w]-rtop[clos[w]])*(rtop[w]-rtop[clos[w]]))<900)) { getd[w]=2 ; }
got[w]=false;
acel[w]=true;
} else { if ((zget[w]==0)&&(zoned[w]==0)) { randrace[w]=0; } }
} 
else 
{
if (zget[w]==0)
{  
acel[w]=true; 
if ((lap[0]>(3/level))&&(zoned[w]==0))
{
if (!inmood[w]) { health[w]-=(20*level); inmood[w]=true;}
if ((rleft[0]<rleft[w])&&(rtop[0]<rtop[w])) { getd[w]=7; }
if ((rleft[0]<rleft[w])&&(rtop[0]>rtop[w])) { getd[w]=5; }
if ((rleft[0]>rleft[w])&&(rtop[0]<rtop[w])) { getd[w]=1; }
if ((rleft[0]<rleft[w])&&(rtop[0]<rtop[w])) { getd[w]=3; }
if ((rtop[0]<rtop[w])&&(((rleft[w]-rleft[0])*(rleft[w]-rleft[0]))<900)) { getd[w]=0 ; }
if ((rtop[0]>rtop[w])&&(((rleft[w]-rleft[0])*(rleft[w]-rleft[0]))<900)) { getd[w]=4 ; }
if ((rleft[0]<rleft[w])&&(((rtop[w]-rtop[0])*(rtop[w]-rtop[0]))<900)) { getd[w]=6 ; }
if ((rleft[0]>rleft[w])&&(((rtop[w]-rtop[0])*(rtop[w]-rtop[0]))<900)) { getd[w]=2 ; }
got[w]=false;
}
}
}
} else { if (getem[w]) { getem[w]=false; } else { getem[w]=true; } }

if (zget[w]!=0) { zget[w]--; }
if (zoned[w]!=0) { zout[w]++; getem[w]=false; acel[w]=true;} else { zout[w]=0 ; }
if (zout[w]>randz[w])
{
if (zoned[w]==1||zoned[w]==4){if(direct[w]==2) { getd[w]=1; } if(direct[w]==6) { getd[w]=7; } }
if (zoned[w]==2||zoned[w]==3){if(direct[w]==2) { getd[w]=3; } if(direct[w]==6) { getd[w]=5; } }
if (zoned[w]==5||zoned[w]==8){if(direct[w]==4) { getd[w]=5; } if(direct[w]==0) { getd[w]=7; } }
if (zoned[w]==6||zoned[w]==7){if(direct[w]==4) { getd[w]=3; } if(direct[w]==0) { getd[w]=1; } }
zget[w]=10;
got[w]=false;
randz[w]=((Math.random()*10)+5);
randrace[w]+=5;
}

if (prez[w]!=0)  
{ 
if (prez[w]==60) { if (zflag[w]) { getd[w]=7; zflag[w]=false; } else { getd[w]=1; zflag[w]=true; }; }
if (prez[w]==61) { if (zflag[w]) { getd[w]=3; zflag[w]=false; } else { getd[w]=5; zflag[w]=true; }; }
if (prez[w]==62||prez[w]==63) { if (zflag[w]) { getd[w]=0; zflag[w]=false; } else { getd[w]=4; zflag[w]=true; }; }
got[w]=false;
randz[w]+=5;
randrace[w]+=5;
}

if (randa[w]<abenz[w]) {  if (Math.random()>.5) { acel[w]=true; } else {  acel[w]=false; } ; abenz[w]=0; randa[w]=((Math.random()*15)+20); }
if (mover[w]<(ml[carselect[w]]/4)) {  acel[w]=true;  } 
abenz[w]++;
getit();
}
if (rotate[0].equals("left")||rotate[0].equals("right")) { ecnt++; } else { ecnt=0; eeee.stop(); }
if (ecnt>15) { eeee.play(); ecnt=-30; }

} //load=3

// ---** AI stops here **---


Dimension d=getSize();
if (rd==null) return;
rd.setColor(Color.black);
rd.fillRect(0,0,d.width, d.height);

if (loaded==-11)
{
rd.setColor(Color.black);
rd.drawImage(inter, 0, 0, this);
outer="Exiting Game....";
rd.drawString(outer, 150, 200);
}

if (loaded==1)
{
if (screan==0)
{
rd.setColor(Color.black);
rd.drawImage(inter, 0, 0, this);
outer="Select your car! (click)";
rd.drawString(outer, 150, 110);
rd.drawImage(sel,((x[carselect[0]])-(40-(cwidth[carselect[0]]/2))),((y[carselect[0]])-(40-(cwidth[carselect[0]]/2))),this);
x[0]=50;x[1]=130;x[2]=210;x[3]=290;x[4]=120;x[5]=190;
y[0]=130;y[1]=130;y[2]=130;y[3]=130;y[4]=200;y[5]=200;
for (n=0;n<6;n++)
{
rd.drawImage(turn[n],x[n],y[n],this);
}
outer="Name: "+names[carselect[0]]+""; rd.drawString(outer, 50, 300);
outer="Speed";        rd.drawString(outer, 50, 320); rd.drawImage(dt,115,315,(int)(ml[carselect[0]]*20),5,this);
outer="Acceleration"; rd.drawString(outer, 50, 340); rd.drawImage(dt,115,335,(int)(g3[carselect[0]]*2500),5,this);
outer="Weight";       rd.drawString(outer, 50, 360); rd.drawImage(dt,115,355,(int)(mass[carselect[0]]*8),5,this);
rd.drawImage(pla,320,250,this);
rd.drawImage(cre,300,370,this);
}

if (screan==1)
{
rd.drawImage(inter, 0, 0, this);
rd.setColor(Color.black);
outer="- Game Instructions -"; rd.drawString(outer, 130, 110);
outer="There are two ways you can finish the race!"; rd.drawString(outer, 40, 130);
outer="1-by racing to the checkpoints and completing 8 laps"; rd.drawString(outer, 40, 145);
outer="2-by wasting and destroying all your opponents!"; rd.drawString(outer, 40, 160);
outer="You can waste your opponents by crashing into them"; rd.drawString(outer, 40, 190);
outer="but watch out your damage will increase" ;rd.drawString(outer, 40, 205);
outer="same goes to your opponent until one car is wasted" ;rd.drawString(outer, 40, 220);
outer="IMPORTANT:";rd.drawString(outer, 40, 250);
outer="To fix your car pass through the checkpoints" ;rd.drawString(outer, 40, 265);
outer="every checkpoint you pass through your damage decreases";rd.drawString(outer,40, 280);
outer="There are two arrows around your car to guide you" ;rd.drawString(outer, 40, 310);
outer="1-the yellow arrow points to the nearest car to you";rd.drawString(outer, 40, 325);
outer="2-the blue arrow points to your next checkpoint!!";rd.drawString(outer, 40, 340);
rd.drawImage(pla,320,310,this);
rd.drawImage(cre,300,370,this);
rd.drawImage(bac,160,345,this);
}

if (screan==2)
{
rd.drawImage(inter, 0, 0, this);
rd.setColor(Color.black);
outer="- Game Controls -"; rd.drawString(outer, 140, 130);
outer="Use the keyboard arows to move your car (up and down for acceleration)"; rd.drawString(outer, 30, 160);
outer="Use the key M to toggel music on/off"; rd.drawString(outer, 30, 180);
rd.drawImage(pla,300,200,this);
rd.drawImage(cre,300,370,this);
rd.drawImage(bac,55,200,this);
}

}

if (loaded==7)
{
rd.drawImage(inter, 0, 0, this);
rd.setColor(Color.black);
outer="Game progamed and directed by Omar Wally" ; rd.drawString(outer, 90, 130);
outer="http://www.radicalplay.com, omar@radicalplay.com" ; rd.drawString(outer, 70, 150);
outer="Race track graphics by Paul Turner" ; rd.drawString(outer, 100, 180);
outer="http://www.maxgameplay.com, razza_snail@hotmail.com" ; rd.drawString(outer, 70, 200);
outer="Car graphics by Timour Farid, Karim El Khadem and Omar Wally" ; rd.drawString(outer, 40, 230);
outer="Music and sound FX were got from sites providing them for freeware use" ; rd.drawString(outer, 20, 260);
outer="We make games for fun, just for fun!" ; rd.drawString(outer, 110, 300);
rd.drawImage(bac,177,320,this);
}


if (loaded>9)
{
rd.drawImage(inter, 0, 0, this);
rd.setColor(Color.black);
outer="Congratulations!!   You have just completed Maniac Racers" ; rd.drawString(outer, 60, 150);
outer="Please wait a moment..." ; rd.drawString(outer,140, 200);
if (loaded<200) { loaded++; } else { getAppletContext().showDocument(theurl); gamer.stop(); }
}



if (loaded==2)
{
rd.setColor(Color.white);
outer="Loading race track "+level+", please wait";
rd.drawString(outer, 123, 200);
}



if (loaded==3)
{
if (!skip)
{

for (w=0;w<6;w++)
{
x[w]=(int)cleft[w];
y[w]=(int)ctop[w];
}

rd.drawImage(track[level], x[0], y[0],this);

for (w=1;w<6;w++)
{
if ( ((200-x[w]+x[0]-(cwidth[carselect[w]]/2))>-100)&&((200-x[w]+x[0]-(cwidth[carselect[w]]/2))<400)&&((200-y[w]+y[0]-(cwidth[carselect[w]]/2))>-100)&&((200-y[w]+y[0]-(cwidth[carselect[w]]/2))<400) )
{
rd.drawImage(turn[w],(200-x[w]+x[0]-(cwidth[carselect[w]]/2)),(200-y[w]+y[0]-(cwidth[carselect[w]]/2)),null); 
if (wasted[w]) { rd.drawImage(wast[(int)fase[w]],(200-x[w]+x[0]-30) ,(200-y[w]+y[0]-25), this); }
}
}
rd.drawImage(turn[0],(200-(cwidth[carselect[0]]/2)),(200-(cwidth[carselect[0]]/2)),null);
if (wasted[0]) { rd.drawImage(wast[(int)fase[0]],(200-30) ,(200-25), this); }
rd.drawImage(chturn, (x[0]+chleft[level][chn[0]]), (y[0]+chtop[level][chn[0]]), this);
rd.drawImage(arowr[rarow], 137, 137, this);
rd.drawImage(arowb[barow], 137, 137, this);
rd.drawImage(bar,0,0, this);

rd.setColor(Color.white);

stat="Damage";
rd.drawString(stat,10, 10);
rd.drawImage(het, 55, 4,(int)health[0],4, this);

stat="Wasted "+was+"/5  Position "+posit[0]+"/6  lap "+lap[0]+"/8";
rd.drawString(stat,200, 10);

if (out!=0)
{
rd.drawString(outer,150, 140);
if (out<sho) { out++; } else 
{ 
out=0; 
if (wasted[0]) { loaded=1; level=1; } else
if (was==5||lap[0]==9) { loaded=2; if (level!=3) { level++; } else { loaded=10;}  } 
}
}
repaint();
skip=true;
} else { skip=false; }
}
else
{
repaint();
}

date=new Date();long endat = date.getTime();Date date2 = new Date();if(sec!=date2.getSeconds()){sec=date2.getSeconds(); if(fcnt!=0) fprsec = (fcnt+ fprsec) / 2; fcnt=0; } else { fcnt++; }

if (loaded==0) 
{
sel = getImage("status/select.gif"); 
stat="Loading needed Images..."; spaint() ;
inter = getImage("status/inter.gif"); perc++; spaint() ;
het = getImage("status/het.gif"); perc++; spaint() ;
bar = getImage("status/bar.gif"); perc++; spaint() ;
pla = getImage("status/play.gif"); perc++; spaint() ;
cre = getImage("status/cred.gif"); perc++; spaint() ;
bac = getImage("status/back.gif"); perc++;
stat="Loading cars...";  spaint() ;
Image cr;
cr=getImage("cars/car.gif");
for (int z=0 ; z < 16 ; z++) { car[0][z] = rotat(cr,cwidth[0],cwidth[0],(-22.5*z)) ; perc++; spaint() ;}

cr=getImage("cars/bac.gif");
for (int z=0 ; z < 16 ; z++) { car[1][z] = rotat(cr,cwidth[1],cwidth[1],(-22.5*z)) ; perc++; spaint() ;}

cr=getImage("cars/bul.gif");
for (int z=0 ; z < 16 ; z++) { car[2][z] = rotat(cr,cwidth[2],cwidth[2],(-22.5*z)) ; perc++; spaint() ;}

cr=getImage("cars/spi.gif");
for (int z=0 ; z < 16 ; z++) { car[3][z] = rotat(cr,cwidth[3],cwidth[3],(-22.5*z)) ; perc++; spaint() ;}

cr=getImage("cars/des.gif");
for (int z=0 ; z < 16 ; z++) { car[4][z] = rotat(cr,cwidth[4],cwidth[4],(-22.5*z)) ; perc++; spaint() ;}

cr=getImage("cars/tuk.gif");
for (int z=0 ; z < 16 ; z++) { car[5][z] = rotat(cr,cwidth[5],cwidth[5],(-22.5*z)) ; perc++; spaint() ;}

stat="Loading check points..."; spaint() ;
for (z=0 ; z < 9 ; z++) { arowb[z] = getImage("status/ar"+z+"b.gif"); arowr[z] = getImage("status/ar"+z+"r.gif");  perc++; spaint() ;}
check[0] = getImage("status/checkn.gif");  perc++; spaint() ;
check[1] = getImage("status/checkr.gif");  perc++; spaint() ;
checkh[0] = getImage("status/checknh.gif");  perc++; spaint() ;
checkh[1] = getImage("status/checkrh.gif");  perc++; spaint() ;
fin[0] = getImage("status/finn.gif");  perc++; spaint() ;
fin[1] = getImage("status/finr.gif");  perc++; spaint() ;
stat="Loading Explosion..."; 
for (z=0;z<6;z++)
{
wast[z] = getImage("cars/exp"+z+".gif");  perc++;  spaint() ;
}
stat="Loading Sound FX..."; spaint() ;
clic = getSound("sounds/klick.au") ;
low = getSound("sounds/low.au"); perc++; spaint() ;
back = getSound("sounds/back.au"); perc++; spaint() ;
side = getSound("sounds/side.au"); perc++; spaint() ;
head = getSound("sounds/head.au"); perc++; spaint() ;
ooee = getSound("sounds/ooee.au"); perc++; spaint() ;
eeee = getSound("sounds/eeee.au"); perc++; spaint() ;
crash = getSound("sounds/crash.au"); perc++; spaint() ;
brake = getSound("sounds/brake.au"); perc++; spaint() ;
exp = getSound("sounds/exp.au"); perc++; spaint() ;
bep = getSound("sounds/bep.au"); perc++; spaint() ;
loaded=1;
perc=0;
}

if (loaded==2) 
{
System.gc();
if (wait==1) 
{ 
if (!loadt[level]) 
{ 
track[level] = getImage("tracks/track"+level+".gif"); 
loadt[level]=true;
} 
} 
}




if((endat-startat)!=0)
{
if ((fprsec/4)>(endat-startat)) { actat=(int)(fprsec/4); } else { actat=5; }
}
else
{
actat=(int)(fprsec/4);
if(actat<5)
actat=5;
}

try 
{

gamer.sleep(actat); 

}
catch(InterruptedException e){ }


}
}





public boolean keyDown(Event e, int key) 
{
if (key==1006) {rotate[0]="left";}
if (key==1007){rotate[0]="right";}
if (key==1005){dacel[0]=true;}
if (key==1004){acel[0]=true;;}
if (key==109) {if (music){music=false;}else{music=true;}  }
return true;
}

public boolean keyUp(Event e, int key) 
{
if (key==1006) {rotate[0]="none";r[0]=0;}
if (key==1007){rotate[0]="none";r[0]=0;}
if (key==1005){dacel[0]=false;}
if (key==1004){acel[0]=false;}


return true;
}

public void exitsmooth()
{
loaded=-11;
getAppletContext().showDocument(theurl2); 
gamer.stop();
}

/////////////// ---------------------------------------------------------------------------///////////////

public void carstuff()
{
for (n=0;n<6;n++)
{
if (w!=n)
{

if (((ctop[w]-ctop[n])*(ctop[w]-ctop[n])+(cleft[w]-cleft[n])*(cleft[w]-cleft[n]))>6000){cati[w][n]=false;} 

///postion up hit direct=0
if ((ctop[w]+brebo[carselect[w]]<ctop[n]-breba[carselect[n]]+40)&&(ctop[w]+brebo[carselect[w]]>ctop[n]-breba[carselect[n]])&&(cleft[w]-breba[carselect[w]]<cleft[n]+brebo[carselect[n]])&&(cleft[w]+breba[carselect[w]]>cleft[n]-brebo[carselect[n]]))
{
if ((direct[w]==0)&&(direct[n]==2||direct[n]==6||direct[n]==0))
{ 
crashem();
if (!cati[w][n]) { smover[n]=(int)(mover[w]*mass[carselect[w]]); hit[n]=1; smover[w]=(int)(mover[n]*mass[carselect[n]]); hit[w]=1; cati[w][n]=true;}
if (zoned[n]==0) { ctop[n]=(ctop[w]+breba[carselect[n]]+brebo[carselect[w]]);  } else {  ctop[w]=(ctop[n]-breba[carselect[n]]-brebo[carselect[w]]-1); mover[w]=0.1;  } 
} 

if ((direct[w]==0)&&(direct[n]==1||direct[n]==7))
{ 
if (!cati[w][n]) 
{ 
smover[n]=(int)(mover[w]*mass[carselect[w]]); hit[n]=1; smover[w]=(int)(mover[n]*mass[carselect[n]]); hit[w]=1; cati[w][n]=true; 
hbackp();
}
indir[n]=0;
tmover=mover[w];
mover[w]=mover[n];
mover[n]=tmover;
} 

if ((direct[w]==1||direct[w]==7)&&(direct[n]==0)) 
{ 
if (!cati[w][n]) { hbackp();smover[n]=(int)(mover[w]*mass[carselect[w]]); hit[n]=1; smover[w]=(int)(mover[n]*mass[carselect[n]]); hit[w]=1; cati[w][n]=true; }
tmover=mover[w];
mover[w]=mover[n];
mover[n]=tmover;
}


if ((direct[w]==0)&&(direct[n]==3)){ if (!cati[w][n]) { smover[n]=(int)(mover[w]*mass[carselect[w]]); hit[n]=1; smover[w]=(int)(mover[n]*mass[carselect[n]]); hit[w]=1; cati[w][n]=true; } indir[n]=2;} 
if ((direct[w]==0)&&(direct[n]==5)){ if (!cati[w][n]) { smover[n]=(int)(mover[w]*mass[carselect[w]]); hit[n]=1; smover[w]=(int)(mover[n]*mass[carselect[n]]); hit[w]=1; cati[w][n]=true; } indir[n]=12;} 

if ((direct[w]==0)&&(direct[n]==4))
{ 
if (!cati[w][n]) { headtohead(); smover[n]=(int)(mover[w]*mass[carselect[w]]); hit[n]=1; smover[w]=(int)(mover[n]*mass[carselect[n]]); hit[w]=1; cati[w][n]=true; if ((((mover[w]+1)*mass[carselect[w]])>((mover[n]+1)*mass[carselect[n]]))&&(prez[n]==0)) { mover[w]=(mover[w]-mover[n]) ; if (mover[w]<0){mover[w]*=-1;}  mover[n]=-mover[w];  }  }
if (mover[w]>mover[n])
{
if (prez[n]==0) { if (!dacel[w]){ctop[n]=(ctop[w]+brebo[carselect[n]]+brebo[carselect[w]]);mover[w]=(mover[w]-mover[n]) ; mover[n]=-mover[w]; } } else { ctop[w]=(ctop[n]-brebo[carselect[n]]-brebo[carselect[w]]-1); mover[w]=0.1;}
}
}
}
//


///postion down hit direct=0
if ((ctop[w]-brebo[carselect[w]]>ctop[n]+breba[carselect[n]]-40)&&(ctop[w]-brebo[carselect[w]]<ctop[n]+breba[carselect[n]])&&(cleft[w]-breba[carselect[w]]<cleft[n]+brebo[carselect[n]])&&(cleft[w]+breba[carselect[w]]>cleft[n]-brebo[carselect[n]]))
{
if ((direct[w]==4)&&(direct[n]==2||direct[n]==6))
{ 
crashem();
if (!cati[w][n]) { smover[n]=(int)(mover[w]*mass[carselect[w]]); hit[n]=1; smover[w]=(int)(mover[n]*mass[carselect[n]]); hit[w]=1; cati[w][n]=true;}
if (zoned[n]==0) { ctop[n]=(ctop[w]-breba[carselect[n]]-brebo[carselect[w]]);  } else {  ctop[w]=(ctop[n]+breba[carselect[n]]+brebo[carselect[w]]+1); mover[w]=0.1;  } 
} 

if ((direct[w]==4)&&(direct[n]==3||direct[n]==5||direct[n]==4))
{ 
if (!cati[w][n]) { hbackp();smover[n]=(int)(mover[w]*mass[carselect[w]]); hit[n]=1; smover[w]=(int)(mover[n]*mass[carselect[n]]); hit[w]=1; cati[w][n]=true; }
indir[n]=8;
tmover=mover[w];
mover[w]=mover[n];
mover[n]=tmover;
} 

if ((direct[w]==3||direct[w]==5)&&(direct[n]==4)) 
{ 
if (!cati[w][n]) { hbackp();smover[n]=(int)(mover[w]*mass[carselect[w]]); hit[n]=1; smover[w]=(int)(mover[n]*mass[carselect[n]]); hit[w]=1; cati[w][n]=true; }
tmover=mover[w];
mover[w]=mover[n];
mover[n]=tmover;
}


if ((direct[w]==4)&&(direct[n]==1)){ if (!cati[w][n]) { smover[n]=(int)(mover[w]*mass[carselect[w]]); hit[n]=1; smover[w]=(int)(mover[n]*mass[carselect[n]]); hit[w]=1; cati[w][n]=true; } indir[n]=2;} 
if ((direct[w]==4)&&(direct[n]==7)){ if (!cati[w][n]) { smover[n]=(int)(mover[w]*mass[carselect[w]]); hit[n]=1; smover[w]=(int)(mover[n]*mass[carselect[n]]); hit[w]=1; cati[w][n]=true; } indir[n]=12;} 

if ((direct[w]==4)&&(direct[n]==0))
{  
if (!cati[w][n]) { headtohead(); smover[n]=(int)(mover[w]*mass[carselect[w]]); hit[n]=1; smover[w]=(int)(mover[n]*mass[carselect[n]]); hit[w]=1; cati[w][n]=true; if ((((mover[w]+1)*mass[carselect[w]])>((mover[n]+1)*mass[carselect[n]]))&&(prez[n]==0)) { mover[w]=(mover[w]-mover[n]) ; if (mover[w]<0){mover[w]*=-1;}  ; mover[n]=-mover[w];  }  }
if (mover[w]>mover[n])
{
if (prez[n]==0) { if (!dacel[w]){ctop[n]=(ctop[w]-brebo[carselect[n]]-brebo[carselect[w]]);mover[w]=(mover[w]-mover[n])  ; mover[n]=-mover[w]; } } else { ctop[w]=(ctop[n]+brebo[carselect[n]]+brebo[carselect[w]]+1);mover[w]=0.1;}
}
}
}
//pss lefters

if ((cleft[w]+brebo[carselect[w]]<cleft[n]-breba[carselect[n]]+40)&&(cleft[w]+brebo[carselect[w]]>cleft[n]-breba[carselect[n]])&&(ctop[w]-breba[carselect[w]]<ctop[n]+brebo[carselect[n]])&&(ctop[w]+breba[carselect[w]]>ctop[n]-brebo[carselect[n]]))
{
if ((direct[w]==6)&&(direct[n]==0||direct[n]==4||direct[n]==6))
{ 
crashem();
if (!cati[w][n]) { smover[n]=(int)(mover[w]*mass[carselect[w]]); hit[n]=1; smover[w]=(int)(mover[n]*mass[carselect[n]]); hit[w]=1; cati[w][n]=true;}
if (zoned[n]==0) { cleft[n]=(cleft[w]+breba[carselect[n]]+brebo[carselect[w]]);  } else {  cleft[w]=(cleft[n]-breba[carselect[n]]-brebo[carselect[w]]-1); mover[w]=0.1;  } 
} 

if ((direct[w]==6)&&(direct[n]==5||direct[n]==7))
{ 
if (!cati[w][n]) { hbackp();smover[n]=(int)(mover[w]*mass[carselect[w]]); hit[n]=1; smover[w]=(int)(mover[n]*mass[carselect[n]]); hit[w]=1; cati[w][n]=true; }
indir[n]=0;
tmover=mover[w];
mover[w]=mover[n];
mover[n]=tmover;
} 

if ((direct[w]==5||direct[w]==7)&&(direct[n]==6)) 
{ 
if (!cati[w][n]) { hbackp();smover[n]=(int)(mover[w]*mass[carselect[w]]); hit[n]=1; smover[w]=(int)(mover[n]*mass[carselect[n]]); hit[w]=1; cati[w][n]=true; }
tmover=mover[w];
mover[w]=mover[n];
mover[n]=tmover;
}


if ((direct[w]==6)&&(direct[n]==1)){ if (!cati[w][n]) { smover[n]=(int)(mover[w]*mass[carselect[w]]); hit[n]=1; smover[w]=(int)(mover[n]*mass[carselect[n]]); hit[w]=1; cati[w][n]=true; } indir[n]=0;} 
if ((direct[w]==6)&&(direct[n]==3)){ if (!cati[w][n]) { smover[n]=(int)(mover[w]*mass[carselect[w]]); hit[n]=1; smover[w]=(int)(mover[n]*mass[carselect[n]]); hit[w]=1; cati[w][n]=true; } indir[n]=8;} 

if ((direct[w]==6)&&(direct[n]==2))
{ 
if (!cati[w][n]) {  smover[n]=(int)(mover[w]*mass[carselect[w]]); hit[n]=1; smover[w]=(int)(mover[n]*mass[carselect[n]]); hit[w]=1; cati[w][n]=true;  if ((((mover[w]+1)*mass[carselect[w]])>((mover[n]+1)*mass[carselect[n]]))&&(prez[n]==0)) { mover[w]=(mover[w]-mover[n])  ;if (mover[w]<0){mover[w]*=-1;}  mover[n]=-mover[w];  }  }
if (mover[w]>mover[n])
{
if (prez[n]==0) { if (!dacel[w]){cleft[n]=(cleft[w]+brebo[carselect[n]]+brebo[carselect[w]]);mover[w]=(mover[w]-mover[n])  ; mover[n]=-mover[w];} } else { cleft[w]=(cleft[n]-brebo[carselect[n]]-brebo[carselect[w]]-1); mover[w]=0.1;}
}
}
}


if ((cleft[w]-brebo[carselect[w]]>cleft[n]+breba[carselect[n]]-40)&&(cleft[w]-brebo[carselect[w]]<cleft[n]+breba[carselect[n]])&&(ctop[w]-breba[carselect[w]]<ctop[n]+brebo[carselect[n]])&&(ctop[w]+breba[carselect[w]]>ctop[n]-brebo[carselect[n]]))
{
if ((direct[w]==2)&&(direct[n]==0||direct[n]==4))
{ 
crashem();
if (!cati[w][n]) { smover[n]=(int)(mover[w]*mass[carselect[w]]); hit[n]=1; smover[w]=(int)(mover[n]*mass[carselect[n]]); hit[w]=1; cati[w][n]=true;}
if (zoned[n]==0) { cleft[n]=(cleft[w]-breba[carselect[n]]-brebo[carselect[w]]);  } else {  cleft[w]=(cleft[n]+breba[carselect[n]]+brebo[carselect[w]]+1); mover[w]=0.1;  } 
} 

if ((direct[w]==2)&&(direct[n]==7||direct[n]==5||direct[n]==2))
{ 
if (!cati[w][n]) { hbackp();smover[n]=(int)(mover[w]*mass[carselect[w]]); hit[n]=1; smover[w]=(int)(mover[n]*mass[carselect[n]]); hit[w]=1; cati[w][n]=true; }
indir[n]=2;
tmover=mover[w];
mover[w]=mover[n];
mover[n]=tmover;
}  

if ((direct[w]==3||direct[w]==1)&&(direct[n]==2)) 
{ 
if (!cati[w][n]) { hbackp();smover[n]=(int)(mover[w]*mass[carselect[w]]); hit[n]=1; smover[w]=(int)(mover[n]*mass[carselect[n]]); hit[w]=1; cati[w][n]=true; }
tmover=mover[w];
mover[w]=mover[n];
mover[n]=tmover;
}

if ((direct[w]==2)&&(direct[n]==7)){ if (!cati[w][n]) { smover[n]=(int)(mover[w]*mass[carselect[w]]); hit[n]=1; smover[w]=(int)(mover[n]*mass[carselect[n]]); hit[w]=1; cati[w][n]=true; } indir[n]=0;} 
if ((direct[w]==2)&&(direct[n]==5)){ if (!cati[w][n]) { smover[n]=(int)(mover[w]*mass[carselect[w]]); hit[n]=1; smover[w]=(int)(mover[n]*mass[carselect[n]]); hit[w]=1; cati[w][n]=true; } indir[n]=8;} 

if ((direct[w]==2)&&(direct[n]==6))
{  
if (!cati[w][n]) {  headtohead(); smover[n]=(int)(mover[w]*mass[carselect[w]]); hit[n]=1; smover[w]=(int)(mover[n]*mass[carselect[n]]); hit[w]=1; cati[w][n]=true; if ((((mover[w]+1)*mass[carselect[w]])>((mover[n]+1)*mass[carselect[n]]))&&(prez[n]==0)) { mover[w]=(mover[w]-mover[n])  ;if (mover[w]<0){mover[w]*=-1;}  mover[n]=-mover[w];  }  }
if (mover[w]>mover[n])
{
if (prez[n]==0) { if (!dacel[w]){cleft[n]=(cleft[w]-brebo[carselect[n]]-brebo[carselect[w]]);mover[w]=(mover[w]-mover[n])  ; mover[n]=-mover[w];} } else { cleft[w]=(cleft[n]+brebo[carselect[n]]+brebo[carselect[w]]+1);mover[w]=0.1;}
}
}
}




if (((ctop[w]-ctop[n])*(ctop[w]-ctop[n])+(cleft[w]-cleft[n])*(cleft[w]-cleft[n]))<2000)
{

if ((direct[w]==3)&&(direct[n]==5)) {   indir[w]=2 ; indir[n]=12; }
if ((direct[w]==1)&&(direct[n]==7)) {   indir[w]=2 ; indir[n]=12; }

if ((direct[w]==1)&&(direct[n]==3)) {   indir[w]=0 ; indir[n]=8; }
if ((direct[w]==5)&&(direct[n]==7)) {   indir[w]=8 ; indir[n]=0; }

if ((direct[w]==1)&&(direct[n]==5)) {   if (Math.random()>.5) { indir[w]=0 ; indir[n]=12; } else { indir[w]=2 ; indir[n]=8; }  }
if ((direct[w]==7)&&(direct[n]==3)) {   if (Math.random()>.5) { indir[w]=12 ; indir[n]=0; } else { indir[w]=8 ; indir[n]=2; } }

if ((direct[w]!=6)&&(direct[w]!=4)&&(direct[w]!=0)&&(direct[w]!=2))
{
if (indir[w]==indir[n]) 
{ 
if (!cati[w][n]) { hbackp();smover[n]=(int)(mover[w]*mass[carselect[w]]); hit[n]=1; smover[w]=(int)(mover[n]*mass[carselect[n]]); hit[w]=1; cati[w][n]=true; }
tmover=mover[w];mover[w]=mover[n];mover[n]=tmover;
}
}

}
}
}

}


public void sidesact()
{

if (indir[w]==1||indir[w]==2||indir[w]==3) { direct[w]=1; }
if (indir[w]==5||indir[w]==6||indir[w]==7) { direct[w]=3; }
if (indir[w]==9||indir[w]==10||indir[w]==11) { direct[w]=5; }
if (indir[w]==13||indir[w]==14||indir[w]==15) { direct[w]=7; }
if (indir[w]==0) { direct[w]=0; }
if (indir[w]==4) { direct[w]=2; }
if (indir[w]==8) { direct[w]=4; }
if (indir[w]==12) { direct[w]=6; }

cnt=0;
for (n=0;n<tw[level].length;n++)
{
if ( ((tw[level][n]+ctop[w])<(200+brebo[carselect[w]])) && ((tw[level][n]+ctop[w]+40)>(200+brebo[carselect[w]])) && ((twl[level][n]+cleft[w])<200) && ((twr[level][n]+cleft[w])>200) ) 
{
if (!buf[w][0]) { playside(4); smover[w]=(int)((mover[w]*mover[w])/6); if (direct[w]==2||direct[w]==6){smover[w]=30;} ; hit[w]=1;  buf[w][0]=true ;  }
if (mover[w]>0)
{
if (direct[w]==3) { mover[w]=(mover[w]/1.25) ; indir[w]=4 ; ctop[w]=(200+breba[carselect[w]]-tw[level][n]);}
if (direct[w]==5) { mover[w]=(mover[w]/1.25) ;indir[w]=12 ;ctop[w]=(200+breba[carselect[w]]-tw[level][n]);}
if (direct[w]==4) { mover[w]=-(mover[w]/20) ; ctop[w]=(200+brebo[carselect[w]]-tw[level][n]); smover[w]*=4 ; prez[w]=60;}
if (direct[w]==2||direct[w]==6){zoned[w]=1;if(prez[w]==60){prez[w]=0;}}
}
if (mover[w]<0)
{
if (direct[w]==7) { mover[w]=(mover[w]/1.25) ;indir[w]=12 ; ctop[w]=(200+breba[carselect[w]]-tw[level][n]);}
if (direct[w]==1) { mover[w]=(mover[w]/1.25) ;indir[w]=4 ;ctop[w]=(200+breba[carselect[w]]-tw[level][n]);}
if (direct[w]==0) { mover[w]=0.1 ; ctop[w]=(200+brebo[carselect[w]]-tw[level][n]-1);prez[w]=60; }
if (direct[w]==2||direct[w]==6){zoned[w]=2;if(prez[w]==60){prez[w]=0;}}

}

}else{cnt++;}
}

if (cnt==tw[level].length)
{ 
if (zoned[w]==1||zoned[w]==2) { zoned[w]=0 ;} 
if (prez[w]==60) { prez[w]=0 ; }
if (buf[w][0]) { buf[w][0]=false; }
}

cnt=0;
for (n=0;n<dw[level].length;n++)
{
if ( ((dw[level][n]+ctop[w])>(200-brebo[carselect[w]])) && ((dw[level][n]+ctop[w]-40)<(200-brebo[carselect[w]])) && ((dwl[level][n]+cleft[w])<200) && ((dwr[level][n]+cleft[w])>200) ) 
{
if (!buf[w][1]) { playside(0); smover[w]=(int)((mover[w]*mover[w])/6) ; if (direct[w]==2||direct[w]==6){smover[w]=30;}  hit[w]=1; buf[w][1]=true ;   }
if (mover[w]>0)
{
if (direct[w]==1) { mover[w]=(mover[w]/1.25) ; indir[w]=4 ; ctop[w]=(200-breba[carselect[w]]-dw[level][n]);}
if (direct[w]==7) { mover[w]=(mover[w]/1.25) ;indir[w]=12 ;ctop[w]=(200-breba[carselect[w]]-dw[level][n]);}
if (direct[w]==0) { mover[w]=-(mover[w]/20) ; ctop[w]=(200-brebo[carselect[w]]-dw[level][n]); smover[w]*=4 ; prez[w]=61; }
if (direct[w]==2||direct[w]==6){zoned[w]=3;if(prez[w]==61){prez[w]=0;}}
}
if (mover[w]<0)
{
if (direct[w]==5) { mover[w]=(mover[w]/1.25) ;indir[w]=12 ; ctop[w]=(200-breba[carselect[w]]-dw[level][n]);}
if (direct[w]==3) { mover[w]=(mover[w]/1.25) ;indir[w]=4 ;ctop[w]=(200-breba[carselect[w]]-dw[level][n]);}
if (direct[w]==4) { mover[w]=0.1 ; ctop[w]=(200-brebo[carselect[w]]-dw[level][n]+1);prez[w]=61; }
if (direct[w]==2||direct[w]==6){zoned[w]=4;if(prez[w]==61){prez[w]=0;}}

}

}else{cnt++;}
}

if (cnt==dw[level].length)
{ 
if (zoned[w]==4||zoned[w]==3) { zoned[w]=0 ;} 
if (prez[w]==61) { prez[w]=0 ; }
if (buf[w][1]) { buf[w][1]=false; }
}


cnt=0;
for (n=0;n<lw[level].length;n++)
{
if ( ((lw[level][n]+cleft[w])<(200+brebo[carselect[w]])) && ((lw[level][n]+cleft[w]+40)>(200+brebo[carselect[w]])) && ((lwt[level][n]+ctop[w])<200) && ((lwd[level][n]+ctop[w])>200) ) 
{
if (!buf[w][2]) { playside(2); smover[w]=(int)((mover[w]*mover[w])/6) ; if (direct[w]==0||direct[w]==4){smover[w]=30;} ; hit[w]=1; buf[w][2]=true ;  }
if (mover[w]>0)
{
if (direct[w]==1) { mover[w]=(mover[w]/1.25) ; indir[w]=0 ; cleft[w]=(200+breba[carselect[w]]-lw[level][n]);}
if (direct[w]==3) { mover[w]=(mover[w]/1.25) ;indir[w]=8 ;cleft[w]=(200+breba[carselect[w]]-lw[level][n]);}
if (direct[w]==2) { mover[w]=-(mover[w]/20) ; cleft[w]=(200+brebo[carselect[w]]-lw[level][n]); smover[w]*=4 ; prez[w]=62; }
if (direct[w]==0||direct[w]==4){zoned[w]=5;if(prez[w]==62){prez[w]=0;}}
}
if (mover[w]<0)
{
if (direct[w]==7) { mover[w]=(mover[w]/1.25) ;indir[w]=0 ; cleft[w]=(200+breba[carselect[w]]-lw[level][n]);}
if (direct[w]==5) { mover[w]=(mover[w]/1.25) ;indir[w]=8 ;cleft[w]=(200+breba[carselect[w]]-lw[level][n]);}
if (direct[w]==6) {  mover[w]=0.1;cleft[w]=(200+brebo[carselect[w]]-lw[level][n]-1); prez[w]=62; }
if (direct[w]==0||direct[w]==4){zoned[w]=6;if(prez[w]==62){prez[w]=0;}}
}
}else{cnt++;}
}

if (cnt==lw[level].length)
{ 
if (zoned[w]==5||zoned[w]==6) { zoned[w]=0 ;} 
if (prez[w]==62) { prez[w]=0 ; }
if (buf[w][2]) { buf[w][2]=false; }
}


cnt=0;
for (n=0;n<rw[level].length;n++)
{
if ( ((rw[level][n]+cleft[w])>(200-brebo[carselect[w]])) && ((rw[level][n]+cleft[w]-40)<(200-brebo[carselect[w]])) && ((rwt[level][n]+ctop[w])<200) && ((rwd[level][n]+ctop[w])>200) ) 
{
if (!buf[w][3]) { playside(6); smover[w]=(int)((mover[w]*mover[w])/6) ; if (direct[w]==0||direct[w]==4){smover[w]=30;}; hit[w]=1; buf[w][3]=true ;   }
if (mover[w]>0)
{
if (direct[w]==5) { mover[w]=(mover[w]/1.25) ; indir[w]=8 ; cleft[w]=(200-breba[carselect[w]]-rw[level][n]);}
if (direct[w]==7) { mover[w]=(mover[w]/1.25) ;indir[w]=0 ;cleft[w]=(200-breba[carselect[w]]-rw[level][n]);}
if (direct[w]==6) { mover[w]=-(mover[w]/20) ; cleft[w]=(200-brebo[carselect[w]]-rw[level][n]); smover[w]*=4 ; prez[w]=63; }
if (direct[w]==4||direct[w]==0){zoned[w]=7;if(prez[w]==63){prez[w]=0;}}
}
if (mover[w]<0)
{
if (direct[w]==1) { mover[w]=(mover[w]/1.25) ;indir[w]=0 ; cleft[w]=(200-breba[carselect[w]]-rw[level][n]);}
if (direct[w]==3) { mover[w]=(mover[w]/1.25) ;indir[w]=8 ;cleft[w]=(200-breba[carselect[w]]-rw[level][n]);}
if (direct[w]==2) {  mover[w]=0.1;cleft[w]=(200-brebo[carselect[w]]-rw[level][n]+1); prez[w]=63; }
if (direct[w]==4||direct[w]==0){zoned[w]=8;if(prez[w]==63){prez[w]=0;}}
}
}else{cnt++;}
}

if (cnt==rw[level].length)
{ 
if (zoned[w]==7||zoned[w]==8) { zoned[w]=0 ;} 
if (prez[w]==63) { prez[w]=0 ; }
if (buf[w][3]) { buf[w][3]=false; }
}


if (zoned[w]==1||zoned[w]==4){if(direct[w]==3) { indir[w]=4; } if(direct[w]==5) { indir[w]=12; } }
if (zoned[w]==2||zoned[w]==3){if(direct[w]==1) { indir[w]=4; } if(direct[w]==7) { indir[w]=12; } }
if (zoned[w]==5||zoned[w]==8){if(direct[w]==3) { indir[w]=8; } if(direct[w]==1) { indir[w]=0; } }
if (zoned[w]==6||zoned[w]==7){if(direct[w]==5) { indir[w]=8; } if(direct[w]==7) { indir[w]=0; } }

}

public void getit()
{
if (getd[w]!=direct[w])
{
if (!got[w])
{
if (direct[w]==0)
{
if (getd[w]==1) { rotate[w]="right" ;}
if (getd[w]==2) { rotate[w]="right" ;}
if (getd[w]==3) { rotate[w]="right" ;}
if (getd[w]==4) { rotate[w]="right" ; }
if (getd[w]==5) { rotate[w]="left" ; }
if (getd[w]==6) { rotate[w]="left" ; }
if (getd[w]==7) { rotate[w]="left" ; }
}

if (direct[w]==1)
{
if (getd[w]==2) { rotate[w]="right" ; }
if (getd[w]==3) { rotate[w]="right" ; }
if (getd[w]==4) { rotate[w]="right" ; }
if (getd[w]==5) { rotate[w]="left" ; }
if (getd[w]==6) { rotate[w]="left" ; }
if (getd[w]==7) { rotate[w]="left" ; }
if (getd[w]==0) { rotate[w]="left" ; }
}

if (direct[w]==2)
{
if (getd[w]==3) { rotate[w]="right" ; }
if (getd[w]==4) { rotate[w]="right" ; }
if (getd[w]==5) { rotate[w]="right" ; }
if (getd[w]==6) { rotate[w]="right" ; }
if (getd[w]==7) { rotate[w]="left" ; }
if (getd[w]==0) { rotate[w]="left" ; }
if (getd[w]==1) { rotate[w]="left" ; }
}

if (direct[w]==3)
{
if (getd[w]==4) { rotate[w]="right" ; }
if (getd[w]==5) { rotate[w]="right" ; }
if (getd[w]==6) { rotate[w]="right" ; }
if (getd[w]==7) { rotate[w]="left" ; }
if (getd[w]==0) { rotate[w]="left" ; }
if (getd[w]==1) { rotate[w]="left" ; }
if (getd[w]==2) { rotate[w]="left" ; }
}

if (direct[w]==4)
{
if (getd[w]==5) { rotate[w]="right" ; }
if (getd[w]==6) { rotate[w]="right" ; }
if (getd[w]==7) { rotate[w]="right" ; }
if (getd[w]==0) { rotate[w]="right" ; }
if (getd[w]==1) { rotate[w]="left" ; }
if (getd[w]==2) { rotate[w]="left" ; }
if (getd[w]==3) { rotate[w]="left" ; }
}

if (direct[w]==5)
{
if (getd[w]==6) { rotate[w]="right" ; }
if (getd[w]==7) { rotate[w]="right" ; }
if (getd[w]==0) { rotate[w]="right" ; }
if (getd[w]==1) { rotate[w]="left" ; }
if (getd[w]==2) { rotate[w]="left" ; }
if (getd[w]==3) { rotate[w]="left" ; }
if (getd[w]==4) { rotate[w]="left" ; }
}

if (direct[w]==6)
{
if (getd[w]==7) { rotate[w]="right" ; }
if (getd[w]==0) { rotate[w]="right" ; }
if (getd[w]==1) { rotate[w]="right" ; }
if (getd[w]==2) { rotate[w]="right" ; }
if (getd[w]==3) { rotate[w]="left" ; }
if (getd[w]==4) { rotate[w]="left" ; }
if (getd[w]==5) { rotate[w]="left" ; }
}

if (direct[w]==7)
{
if (getd[w]==0) { rotate[w]="right" ; }
if (getd[w]==1) { rotate[w]="right" ; }
if (getd[w]==2) { rotate[w]="right" ; }
if (getd[w]==3) { rotate[w]="left" ; }
if (getd[w]==4) { rotate[w]="left" ; }
if (getd[w]==5) { rotate[w]="left" ; }
if (getd[w]==6) { rotate[w]="left" ; }
}
got[w]=true;
}
} 
else { rotate[w]="none";r[w]=0;  }
}

public void arowsact()
{
closl=(int)(200-cleft[clos[0]]+cleft[0]) ;   
clost=(int)(200-ctop[clos[0]]+ctop[0]) ;   

if ( (closl<200)&&(clost<200) ) { rarow = 7 ;}   
if ( (closl>200)&&(clost<200) ) { rarow = 1 ;}
if ( (closl>200)&&(clost>200) ) { rarow = 3 ;}
if ( (closl<200)&&(clost>200) ) { rarow = 5 ;}


if ( (closl<200)&&(((clost-200)*(clost-200))<10000) ) { rarow = 6 ;}   
if ( (closl>200)&&(((clost-200)*(clost-200))<10000) ) { rarow = 2 ;} 
if ( (clost<200)&&(((closl-200)*(closl-200))<10000) ){ rarow = 0 ;} 
if ( (clost>200)&&(((closl-200)*(closl-200))<10000) ){ rarow = 4 ;}
if ( (((closl-200)*(closl-200))+((clost-200)*(clost-200)))<40000 ) { rarow = 8 ; }

chturn=check[chtype[level][chn[0]]];

if ((lap[0]==8)&&(chn[0]==(chtype[level].length-1))) { chturn=fin[chtype[level][chn[0]]]; }
//
for (w=0;w<6;w++)
{
if (chtype[level][chn[w]]==0)
{
if (((chleft[level][chn[w]]+xc[w])<200)&&((chleft[level][chn[w]]+xc[w]+120)>200)&&((chtop[level][chn[w]]+yc[w])<200)&&((chtop[level][chn[w]]+yc[w]+21)>200)) { if (w==0) {chturn = checkh[chtype[level][chn[w]]]; } if (trns[w]==16) { trns[w]=0; } }
}
else
{
if (((chleft[level][chn[w]]+xc[w])<200)&&((chleft[level][chn[w]]+xc[w]+21)>200)&&((chtop[level][chn[w]]+yc[w])<200)&&((chtop[level][chn[w]]+yc[w]+120)>200)) { if (w==0) {chturn = checkh[chtype[level][chn[w]]]; } if (trns[w]==16) { trns[w]=0; } }
}

if (trns[w]!=16) { trns[w]++; }
if (trns[w]==15) { chn[w]++; randrace[w]=0; ched[w]++; if (health[w]>8) { if (w==0) { health[w]-=10; } else { health[w]-=(4.5*level); } } }

if (chn[w]==chtype[level].length) 
{ 
chn[w]=0 ; 
lap[w]++; 

if (w==0)
{
if (lap[0]==8) { out=1; outer="Final Lap!!";}
if (lap[0]==9) { out=1; outer="Race completed!";}
}

} //lap one fini

}
//

if (((chleft[level][chn[0]]+xc[0]+60)<200)&&((chtop[level][chn[0]]+yc[0]+60)<200)) { barow = 7 ;}   
if (((chleft[level][chn[0]]+xc[0]+60)>200)&&((chtop[level][chn[0]]+yc[0]+60)<200)) { barow = 1 ;}
if (((chleft[level][chn[0]]+xc[0]+60)>200)&&((chtop[level][chn[0]]+yc[0]+60)>200)) { barow = 3 ;}
if (((chleft[level][chn[0]]+xc[0]+60)<200)&&((chtop[level][chn[0]]+yc[0]+60)>200)) { barow = 5 ;}


if (((chleft[level][chn[0]]+xc[0]+60)<200)&&(((chtop[level][chn[0]]+yc[0]-200+60)*(chtop[level][chn[0]]+yc[0]-200+60))<10000) ) { barow = 6 ;}   
if (((chleft[level][chn[0]]+xc[0]+60)>200)&&(((chtop[level][chn[0]]+yc[0]-200+60)*(chtop[level][chn[0]]+yc[0]-200+60))<10000) ) { barow = 2 ;} 
if (((chtop[level][chn[0]]+yc[0]+60)<200)&&(((chleft[level][chn[0]]+xc[0]-200+60)*(chleft[level][chn[0]]+xc[0]-200+60))<10000) ){ barow = 0 ;} 
if (((chtop[level][chn[0]]+yc[0]+60)>200)&&(((chleft[level][chn[0]]+xc[0]-200+60)*(chleft[level][chn[0]]+xc[0]-200+60))<10000) ){ barow = 4 ;}
if ((((chleft[level][chn[0]]+xc[0]-200+60)*(chleft[level][chn[0]]+xc[0]-200+60)) + ((chtop[level][chn[0]]+yc[0]-200+60)*(chtop[level][chn[0]]+yc[0]-200+60)) )<40000 ) { barow = 8 ; }
}


public void hbackp(){if (w==0||n==0) { if (((mover[n]-mover[w])*(mover[n]-mover[w]))>6) { back.play(); } else { low.play(); }}}
public void crashem(){if (w==0){if (!cati[0][n]) { crash.play(); } else {if (zoned[n]==0) { ooee.play(); } }}if (n==0){if (!cati[w][0]) { crash.play(); } else {if (zoned[n]==0) { ooee.play(); } }}}
public void headtohead(){if (n==0||w==0){head.play();}}
public void playside(int hd){if (w==0){if (mover[w]>6){if (direct[w]==hd) { brake.play(); } else { side.play(); }}else{low.play();}}}
public void stop(){if (gamer != null)gamer.stop();gamer = null;}	
public void init(){
Dimension thisSize = this.getSize();
offImage=createImage(thisSize.width,thisSize.height);
if (offImage!=null)
rd=offImage.getGraphics();
outer="";stat="";
try{theurl=new URL("http://www.radicalplay.com/maniacs/secret.html");}catch(MalformedURLException e){};

try{theurl2=new URL(getDocumentBase(),"exit.html");}catch(MalformedURLException e){};

for (w=0;w<6;w++){for (z=0;z<6;z++){cati[w][z]=false;}}setBackground(Color.black);cnt=0;for (w=0;w<6;w++){for (z=0;z<4;z++){buf[w][z]=false;}}}

private Image getImage(String name){if(mt == null)mt = new MediaTracker(this);Image img = getImage(getCodeBase(), name);mt.addImage(img, 0);try{mt.waitForID(0);}catch(Exception exception) { }return img;}


private AudioClip getSound(String name){AudioClip ac = getAudioClip(getCodeBase(), name);ac.play();Thread.yield();ac.stop();return ac;}
public void autosort(){z=1;while(z!=6){rand=(int)Math.floor((Math.random()*6));ch=0;for (i=0;i<z;i++){if(rand!=carselect[i]){ch++;}}if (ch==z) { carselect[z]=rand; z++; }}}


}

