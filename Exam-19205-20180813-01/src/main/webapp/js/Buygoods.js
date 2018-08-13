$(document).ready(function(){
	var num=1;
	var goodprice=getvl("price");
	var nowprice;
	$("#topbuttonone").click(function(){
		if(num>1){
			num--;
			$("#num").val(num);
			nowprice=num*goodprice;
			$("#price").val(nowprice);
		}
    });
    $("#topbuttontwo").click(function(){
    	num++;
    	$("#num").val(num);
    	nowprice=num*goodprice;
    	$("#price").val(nowprice);
    })
    $("#bottumbuttonone").click(function(){
    	
    })
});
function getvl(name) {
　　var reg = new RegExp("(^|\\?|&)"+ name +"=([^&]*)(\\s|&|$)", "i");
　　if (reg.test(location.href))
　　return unescape(RegExp.$2.replace(/\+/g, " "));
　　return "";
};

