/// hahahaha i am the man!!! this script was written by me Omar wally www.radicalplay.com...

if (document.all) 
{ 
document.write('<div style="position:absolute;left: -100 ;top: -100;"><IFRAME SRC="effects/music.html" scrolling="no" name=player WIDTH=10 HEIGHT=10></IFRAME></div>\r' 
+'<img id=sam1 src="interface/lay1.gif" style="position:absolute; left:-300 ; top:0 ; filter:alpha(opacity=60)">\r'
+'<img id=sam2 src="interface/lay1.gif" style="position:absolute; left:400 ; top:0 ; filter:alpha(opacity=60)">')
}   

var playing=0
var shakes=0
var shakeb=0

var ar = new Array(-2,2,2,-2,2,-2,2,-2)
var b=7;
var a=0;
var ar2 = new Array(-5,5,5,-5,5,-5,5,-5)
var b2=7;
var a2=0;


function startup()
{
if (document.all)
{
parent.player.document.write("")
parent.player.document.close()
macheck()
startsam()
} else { document.ma.promp() }
}

var left1=-300
var left2=400

function startsam()
{
document.all.sam1.style.pixelLeft=left1
document.all.sam2.style.pixelLeft=left2
if (left2>-300)
{
left1+=10
left2-=10
setTimeout("startsam()",10)
}
else
{
document.ma.promp()
}
}

function macheck()
{
if (document.ma.isActive()) { loopit() } else { setTimeout("macheck()",100) }
}

function loopit()
{

if (document.ma.musicyes()>300) 
{ 
if (!playing)
{
parent.player.document.write("<html><head><Bgsound src=effects/track.mid loop=infinite></head><body></body></html>")
parent.player.document.close();
playing=1
}
}
else 
{
if (playing)
{
parent.player.document.write("")
parent.player.document.close()
playing=0
}
}

if ((!shakes)&&(document.ma.amhit())) { shakes=1 ; shakesmall(); }

if ((!shakeb)&&(document.ma.explode())) { shakeb=1 ; shakebig(); }

setTimeout("loopit()",10)
}


function shakesmall()
{
if (a<8)
{ 
self.moveBy(ar[a],ar[b]);
b--
a++
setTimeout("shakesmall()",10)
}
else
{
b=7
a=0
shakes=0
}
}

function shakebig()
{
if (a2<8)
{ 
self.moveBy(ar2[a2],ar2[b2]);
b2--
a2++
setTimeout("shakebig()",10)
}
else
{
b2=7
a2=0
shakeb=0
}
}

