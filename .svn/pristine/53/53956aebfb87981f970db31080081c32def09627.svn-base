<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
<head>

<title>修改密码</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<link rel="stylesheet" href="css/index.css" type="text/css" />
</head>

<body>


	<form action="personalInfo.form" method="post" id="formatsubmit" style="padding:80px 470px">
		<a href="#" class="list-group-item active" style="width:400px">
			修改密码 </a><br> <input type="password" name="userPassword"
			id="password1" class="list-group-item"
			style="width:400px;height:45px;" placeholder="原密码"><span
			id="p1">&nbsp;</span><br />
		<input type="password" name="password2" id="password2"
			class="list-group-item" placeholder="新密码"
			style="width:400px;height:45px;"><span id="p2">&nbsp;</span><br />
		<input type="password" name="password3" id="password3"
			onkeyup="checkPwd()" class="list-group-item" placeholder="确认新密码"
			style="width:400px;height:45px;"><span id="p3">&nbsp;</span>
		<br /> 
		<input type="button" value="取消"
			onclick="returnPre()" class="btn btn-default" style="width:100px"/>
			<input type="button" value="提交修改" onclick="sub()"  style="margin-left: 170px;width:120px" 
			class="btn btn-primary" />
			
			
	</form>


</body>
<script type="text/javascript">
	var pp = false;
	var ppp = false;
	var p4 = false;
	$("#password1").blur(function() {
		var p1 = $("#password1").val();
		$.ajax({
			url : "checkP1.form?userPassword=" + p1,
			data : {
				userPassword : p1
			},
			contentType : "application/x-www-form-urlencoded",
			type : "post",
			dataType : "text",
			success : function(data) {
				console.log(data);
				if (data == 'Y') {
					ppp = true;
					$("#p1").html("");
				} else {
					ppp = false;
					$("#p1").html("原密码输入错误！");
					$("#p1").css("color", "red");
				}
			}
		});
	})

	$("#password2").blur(function() {
		var pp2 = $("#password2").val();
		$.ajax({
			url : "checkPwd.form?password2=" + pp2,
			data : {
				password2 : pp2
			},
			contentType : "application/x-www-form-urlencoded",
			type : "post",
			dataType : "text",
			success : function(data) {
				console.log(data);
				if (data == 'S') {
					pp = false;
					$("#p2").html("密码格式错误，由6-14为字符组成");
					$("#p2").css("color", "red");
				} else {
					pp = true;
					$("#p2").html("");
				}
			}
		});
	})

	function checkPwd() {
		var p2 = $("#password2").val();
		var p3 = $("#password3").val();
		if (p2 == p3) {
			p4 = true;
			$("#p3").html("");
		} else {
			p4 = false;
			$("#p3").html("两次密码不一致");
			$("#p3").css("color", "red");
		}

	}

	function sub() {
		if (pp == true && ppp == true && p4 == true) {
			$("#formatsubmit").submit();
		}
	}

	function returnPre() {
		history.back();
	}
</script>
</html>
