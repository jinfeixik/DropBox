<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>邮箱快捷登录</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="css/bootstrap.min.css" />
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<style>
.leader {
	width: 1500px;
	height: 60px;
	background: #f2f2f2 no-repeat 0px;
}

.title {
	margin-left: 70px;
}

.header {
	width: auto;
	height: auto;
	margin-left: 50px;
	margin-top: 140px;
}

.light {
	width: 450px;
	height: 450px;
	/*margin-bottom: 20px;
				padding: 0;*/
	border: 1px solid #CED4DA;
	margin-top: 60px;
	margin-left: 400px;
	/*margin-right: 630px;*/
	border-radius: 5%;
	/*	background: #f2f2f2;*/
}

.light legend {
	margin-left: 140px;
	padding: 0 10px;
	font-size: 20px;
	font-weight: 300;
	margin-top: 40px;
}

.form-group {
	margin-left: 70px;
}
</style>

</head>

<body>

	<div class="leader">
		<div class="title">
			<div class="" style="margin-top: 8px;">
				<img src="images/logo2.png">
			</div>

		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-3 column">
				<img src="img/register02.png"
					style="margin-top: 100px;margin-left: -50px;" />
			</div>
			<div class="col-md-9 column">
				<div class="light">
					<legend>
						<font size="5" color="#007bff">邮箱快捷登录</font>
					</legend>
					<form class="form-horizontal" role="form" style="margin-top: 30px;"
						action="login1.form" method="post">
						<div class="form-group" style="margin-top: 50px;">
							<div class="col-sm-10">
								<input type="text" class="form-control" id="inputPassword3"
									name="userEmail" placeholder="邮箱" />
								<!-- <span
									id="ts"></span> -->
							</div>
						</div>

						<div class="form-group" style="margin-top: 20px;">
							<div class="col-sm-10">
								<div class="row">
									<div class="col-lg-7">
										<input type="text" class="form-control" id="inputPassword"
											name="emailcode" placeholder="验证码" /><span id="ts"></span>

									</div>
									<div class="col-lg-2">
										<input type="button" value="获取验证码" onclick="sendEmail()"
											class="btn btn-primary" id="inputPassword4" />
									</div>
								</div>
							</div>
						</div>


						<div class="form-group" style="margin-top: 50px;">
							<div class="col-sm-offset-2 col-sm-10">
								<input type="submit" class="btn btn-primary"
									onclick="inputCode()" style="width: 285px;" value="登录" />
							</div>
						</div>
						<div class="form-group" style="margin-top: 40px;">
							<div class="col-sm-offset-2 col-sm-10">
								<font size="3"> <a href="userNamePasswordLogin.jsp">账号密码登录></a>
								</font> <font size="3"> <a href="RegisterTest.jsp"
									style="margin-left: 105px;">立即注册</a> </font>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
<script type="text/javascript">
	function sendEmail() {
		var mail = $("#inputPassword3").val();
		$.ajax({
			url : "sendEmail.form",
			data : {
				userEmail : mail
			},
			type : "post",
			dataType : "json",
			success : function(data) {
				alter(data);
			}

		})
	}

	function inputCode() {
		var mail = $("#inputPassword").val();
		console.log(mail);
		$.ajax({
			url : "login1.form",
			data : {
				emailcode : mail
			},
			type : "post",
			dataType : "json",
			success : function(data) {
			}

		})
	}
</script>

<script type="text/javascript">
	var Eflag = true;
	var Cflag = true;
	$("#inputPassword3").blur(function() {
		var email = $("#inputPassword3").val();
		/* console.log("email ajax " + email); */
		$.ajax({
			url : "isRegisterEmail.form?userEmail=" + email,
			date : {
				userEmail : email
			},
			contentType: "application/x-www-form-urlencoded",
			type : "post",
			//关键在于下面json->text,json可传递数组链表^(*￣(oo)￣)^
			dataType : "text",
			success : function(data) {
				/* console.log(data); */
				//这里直接使用data，不要data.flag
				if (data == "N") {
				    alert("此邮箱还未注册，请立即前往！");
					Eflag = false;
					/* $("#ts").html("此邮箱还未注册，请立即前往！");
					$("#ts").css("color", "red"); */
				}
			}
		});
	})
	
	
	
	$("#inputPassword").blur(function() {
		var mailcode = $("#inputPassword").val();
		 console.log("emailCode ajax " + mailcode); 
		$.ajax({
			url : "isCheckEmailCode.form?emailcode=" + mailcode,
			date : {
				emailcode : mailcode
			},
			contentType: "application/x-www-form-urlencoded",
			type : "post",
			//关键在于下面json->text,json可传递数组链表^(*￣(oo)￣)^
			dataType : "text",
			success : function(data) {
				/* console.log(data); */
				//这里直接使用data，不要data.flag
				if (data == "N") {
				   /*  alert("验证码输入错误"); */
					Cflag = false;
					$("#ts").html("验证码错误");
					$("#ts").css("color", "red"); 
				}else{
				    Cflag = true;
				    $("#ts").html("验证码输入正确");
					$("#ts").css("color", "green"); 
				}
			}
		});
	})
	
	
</script>



</html>
