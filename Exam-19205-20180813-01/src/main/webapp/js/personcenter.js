var revisepassword=document.getElementById("revisepassword");
var revisepalce=document.getElementById("reviseplace");
var seeorder=document.getElementById("seeorder");
var payorder=document.getElementById("payorder");
var deleteorder=document.getElementById("deleteorder");
var rightone=document.getElementById("rightone");
var righttwo=document.getElementById("righttwo");
var rightthree=document.getElementById("righithree");
var rightfour=document.getElementById("rightfour");
var rightfive=document.getElementById("rightfive");
var tabledeletebutton=document.getElementById("tabledeletebutton");
var tablepaybutton=document.getElementById("tablepaybutton");
revisepassword.onclick=function(){
	$("#rightone").slideDown("slow");
	righttwo.style.display="none";
	rightthree.style.display="none";
	rightfour.style.display="none";
	rightfive.style.display="none";
	revisepassword.style.border='10px';
	revisepalce.style.border="";
	seeorder.style.border="";
	payorder.style.border="";
	deleteorder.style.border="";
}
revisepalce.onclick=function(){
	rightone.style.display="none";
	$("#righttwo").slideDown("slow");
	rightthree.style.display="none";
	rightfour.style.display="none";
	rightfive.style.display="none";
	revisepassword.style.border="";
	revisepalce.style.border='10px';
	seeorder.style.border="";
	payorder.style.border="";
	deleteorder.style.border="";
}
seeorder.onclick=function(){
	rightone.style.display="none";
	righttwo.style.display="none";
	$("#righithree").slideDown("slow");
	rightfour.style.display="none";
	rightfive.style.display="none";
	revisepassword.style.border="";
	revisepalce.style.border="";
	seeorder.style.border='10px';
	payorder.style.border="";
	deleteorder.style.border="";
}
payorder.onclick=function(){
	rightone.style.display="none";
	righttwo.style.display="none";
	rightthree.style.display="none";
	$("#rightfour").slideDown("slow");
	rightfive.style.display="none";
	revisepassword.style.border="";
	revisepalce.style.border="";
	seeorder.style.border="";
	payorder.style.border='10px';
	deleteorder.style.border="";
}
deleteorder.onclick=function(){
	rightone.style.display="none";
	righttwo.style.display="none";
	rightthree.style.display="none";
	rightfour.style.display="none";
	$("#rightfive").slideDown("slow");
	revisepassword.style.border="";
	revisepalce.style.border="";
	seeorder.style.border="";
	payorder.style.border="";
	deleteorder.style.border='10px';
}
tabledeletebutton.onclick=function(){
	confirm("你确认删除此订单吗");
}
tablepaybutton.onclick=function(){
	confirm("你确认支付此订单吗");
}
$(document).ready(function(){
	$("#reviseform").validate({
		rules:{
			oldpassword:"required",
			newpassword1:"required",
			newpassword2:{
				required:true,
				equalTo:"#newpassword"
			}
		},
		messages:{
			oldpassword:"原密码不能为空",
			newpassword1:"新密码不能为空",
			newpassword2:{
				required:"新密码不能为空",
				equalTo:"新密码不一致"
			}
		}
	});
});