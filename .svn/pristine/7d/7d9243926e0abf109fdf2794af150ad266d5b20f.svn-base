<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
<head>

<title>编辑用户信息</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<link rel="stylesheet" href="css/index.css" type="text/css" />
</head>

<body>


	<form action="updateUserInfo.form?userName=${user.userName}&&userEmail=${user.userEmail}" method="post" id="formatsubmit" enctype="multipart/form-data" style="padding:80px 470px">
		<a href="#" class="list-group-item active" style="width:400px">
			编辑用户信息</a><br>
		<img src="${image}" class="touxiang">
		<input type="file" name="some"
			id="image"  value="上传"><br /><br />
		用户名：<input type="text" name="userName" value="${user.userName}"
			id="name" class="list-group-item"
			style="width:400px;height:45px;" placeholder="用户名"><span
			id="p1">&nbsp;</span><br />
		邮箱：<input type="email" name="userEmail" id="mail" value="${user.userEmail}"
			class="list-group-item" placeholder="邮箱"
			style="width:400px;height:45px;"><span id="p2">&nbsp;</span><br />
		<input type="button" value="取消"
			onclick="returnPre()" class="btn btn-default" style="width:100px"/>
			<input type="submit" value="保存修改"  style="margin-left: 170px;width:120px" 
			class="btn btn-primary" />
	</form>


</body>
<script type="text/javascript">
/* 	$("#name").blur(function(){
	  var na = $("#name").val();
	  $.ajax({
	   url:"updateUserInfo.form",
	   data:{
	   },
	   type:,
	   dataType:,
	   success : function(data){
	   
	   }
	  });
	}) */

	function returnPre() {
		history.back();
	}
</script>
</html>
