<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'folderManger.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<style>
			input.t {border:1px solid #fff;background:#fff;} 
			input.s {border:1px solid #369;background:#fff;} 
	</style>

  </head>
  
  <body>
  
  <form action="">
  
  	<input type="hidden" name="parentId" value="0" >
  	
  	<input type="hidden" name="folderId" value="1" id="folderId" >
  	<div id="div_input" style="width:152px;height:22px;border:1px solid #369;">
			<span style="overflow: hidden;">12123aa</span>
			<input id="folderName" type="text" style="display:none;width:152px;height:22px;overflow: hidden;" name="folderInfoName" value="123">
	</div>
<!--     <input class="t" type="text" id="folderName" name="folderName" style="outline:none;" readonly="readonly" value="aaaa" />
    <input type="submit" value="修改" style="display:none;" id="submit" /> -->
   </form>
  
  <script src="https://cdn.bootcss.com/jquery/2.0.0/jquery.min.js"></script>
  <script type="text/javascript">
  			alert("aaa");
  			var folderId;
  			var folderInfoName;
			$(document).ready(function() {
			 alert(0);
				$("#div_input").dblclick(function() {
					 alert(0);
					//  $(this).hide();
					$("#folderName").val($("span").html());
					$("span").hide();
					$("#folderName").show().focus();
				});
				$("#folderName").blur(function() {
					$("span").html($(this).val()).show();
					folderInfoName = $("#folderName").val()
					
					$("#folderName").hide();
					folderId = $("#folderId").val();
					
					alert("更新文件名" +folderInfoName);
					alert("更新文件名ID" +folderId);
				
					
					$.ajax({
						data:{folderId:folderId, folderInfoName:folderInfoName},
						url:"updateFolderName.form",
						success:function(result){
							alert("修改成功");
					}}); 
					
					
				});
				});
	</script>
  
  </body>
</html>
