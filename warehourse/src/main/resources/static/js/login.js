$(function() {
					//  $("form").show(500);
					  $("form").slideDown(500)
					// $("form").fadeIn(2000);
				
			});
$(function(){
	$("#second").click(function (){
		var username=$("#username").val();
		$.ajax({
			url : "/sendMail",
			type : "post",
			data : JSON.stringify({username:username}),
			contentType : "application/json;charset=utf-8",
			dataType: "json",
			success : function(data){
			}
		});
		setTime($("#second"))
	});
	var countdown = 60;
	function setTime(obj) {
		if (countdown == 0) {
			obj.prop('disabled', false);
			obj.text("点击获取验证码");
			countdown = 60;//60秒过后button上的文字初始化,计时器初始化;
			return;
		} else {
			obj.prop('disabled', true);
			obj.text("("+countdown+"s)后重新发送") ;
			countdown--;
		}
		setTimeout(function() { setTime(obj) },1000) //每1000毫秒执行一次
	}
});
$(function(){
$("#username").blur(function(){
	if($("#username").val()!=null&&$("#username").val()!="") {
		$("#second").removeAttr("disabled");
		var username = $("#username").val();
		$.ajax({
			url: "/getImgName",
			type: "post",
			data: JSON.stringify({username: username}),
			contentType: "application/json;charset=utf-8",
			dataType: "json",
			success: function (data) {
				if (data != null) {
					$("#div1>img").attr("src", "../resources/static/img/" + data.imgName + "?" + Math.random());
				}
			}
		});
		$("#img1").toggle();
	}
});
});
$(function(){
	$("#put-username").click(function () {
		var username=$("#username-get").val();
		window.location.href="../toUserTable?username="+username;
	})
});
$(function(){
	$("#put-sName").click(function () {
		var sName=$("#sName-get").val();
		window.location.href="../getSupplierList?sName="+sName;
	})
});
$(function(){
	$("#put-gName").click(function () {
		var gName=$("#gName-get").val();
		window.location.href="../getGoodsList?gName="+gName;
	})
});
$(function(){
	$("#put-wName").click(function () {
		var wName=$("#wName-get").val();
		window.location.href="../getWarehouseList?wName="+wName;
	})
});