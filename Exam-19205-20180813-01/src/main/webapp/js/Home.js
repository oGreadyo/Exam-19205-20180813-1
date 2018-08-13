var timer;
var num=0;
var left=0;
var right=1;
var buttons=document.getElementById("buttons").getElementsByTagName('span');  
var list=document.getElementById("list");
var midimg=document.getElementById("midimg");
var searchbt=document.getElementById("searchbt");
var index=0;
function buttonshow(n){
	for (var i=0;i<buttons.length;i++){
		if (buttons[i].className='on'){ 
			buttons[i].className='';
		} 
	}
	buttons[n].className='on';
} 
function show(){
	if(num==-4840){ 
		left=1;
		right=0;
	}
	if (num==0 ){
		left=0;
		right=1;
	}
	if(right==1){
		num=num-1210;
		index++;
	}
	if (left==1){
		num=num+1210;
		index--;  
	}
	buttonshow(index);
	var dis=num+'px';
	$("#list").animate({left:dis});
	
}
function play(){
	timer=setInterval(show,1500);
}
function stop(){
	clearInterval(timer);
}
function move(){
	var x=parseInt(this.getAttribute('index'));
	var offset=(index-x+1)*1210;
	buttonshow(x-1);
	list.style.left=num+offset+'px';
	num=num+offset;
	index=x-1;
}
play();
midimg.onmouseover=stop;
midimg.onmouseout=play;
buttons[0].onclick=move;
buttons[1].onclick=move;
buttons[2].onclick=move;
buttons[3].onclick=move;
buttons[4].onclick=move;