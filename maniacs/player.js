
var playing=0

document.write('<div style="position:absolute;left: -100 ;top: -100;"><IFRAME SRC="" scrolling="no" name=player WIDTH=10 HEIGHT=10></IFRAME></div>')

if (document.all) 
{ 
document.write('<img id=sam1 src="layer.gif" style="position:absolute; left:-300 ; top:0 ; filter:alpha(opacity=60)">\r'
+'<img id=sam2 src="layer.gif" style="position:absolute; left:-400 ; top:0 ; filter:alpha(opacity=60)">')
}   



function outerLoop()
{
if (document.game.talkToMe()!=0)
{
if (!playing)
{
parent.player.document.write("<html><head><Bgsound src=music/IronMaiden"+(Math.floor(Math.random()*3))+".mid loop=infinite></head></html>")
parent.player.document.close()
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
setTimeout("outerLoop()",1000)
}


function startit()
{
var url=""+top.location
if (url.split("http://")!=url)
{
setTimeout("outerLoop()",60000)
}
else
{
setTimeout("outerLoop()",2000)  
}
}


document.onload=startit()
