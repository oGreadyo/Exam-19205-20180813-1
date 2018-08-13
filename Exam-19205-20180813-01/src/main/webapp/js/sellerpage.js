
var addgoods=document.getElementById("addgoods");
var groupgoods=document.getElementById("groupgoods");
var deletegoods=document.getElementById("deletegoods");
var manageorder=document.getElementById("manageorder");
var rightone=document.getElementById("rightone");
var righttwo=document.getElementById("righttwo");
var rightthree=document.getElementById("rightthree");
var rightfour=document.getElementById("rightfour");
addgoods.onclick=function(){
	$("#rightone").slideDown("slow");
	righttwo.style.display="none";
	rightthree.style.display="none";
	rightfour.style.display="none";
	addgoods.style.border='10px'; 
	groupgoods.style.border="";
	deletegoods.style.border="";
	manageorder.style.border="";
}
groupgoods.onclick=function(){
	rightone.style.display="none";
	$("#righttwo").slideDown("slow");
	rightthree.style.display="none";
	rightfour.style.display="none";
	addgoods.style.border=""; 
	groupgoods.style.border='10px';
	deletegoods.style.border="";
	manageorder.style.border="";
}
deletegoods.onclick=function(){
	rightone.style.display="none";
	righttwo.style.display="none";
	$("#rightthree").slideDown("slow");
	rightfour.style.display="none";
	addgoods.style.border=""; 
	groupgoods.style.border="";
	deletegoods.style.border='10px';
	manageorder.style.border="";
}
manageorder.onclick=function(){
	rightone.style.display="none";
	righttwo.style.display="none";
	rightthree.style.display="none";
	$("#rightfour").slideDown("slow");
	addgoods.style.border=""; 
	groupgoods.style.border="";
	deletegoods.style.border="";
	manageorder.style.border='10px';
}
