<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>layui</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="layui/css/layui.css"  media="all">
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<div>
<div id="test9" class="demo-tree demo-tree-box"></div>
<form action="" id="form1" method="post">
 <input type="hidden" name="fileId" value="20" >
<input type="hidden" name="parentId" vlaue="0" id="parentId" >
<input type="button" value="确定" id="button1">
</form>

</div>

<script type="text/javascript" src="H-ui/lib/jquery/1.9.1/jquery.js"></script>
<script src="layui/layui.js" charset="utf-8"></script>
<script>
var parentId;
$.ajax({
    type: "GET",  //请求的方式
    url: "findFolderInfoYY.form", //请求的地址
    dataType: "json",   //数据返回的类型
    success: function (dataTree) {   //成功  方法  data返回是数据
    	layui.use(['tree', 'util'], function(){
  		var tree = layui.tree ,layer = layui.layer ,util = layui.util
    	  console.log(dataTree);  
    	    tree.render({
    			elem: '#test9',
    			data: dataTree
    			,edit: ['add', 'update', 'del'] //操作节点的图标
    			,click: function(obj){
      			layer.msg(JSON.stringify(obj.data.title));
      			 parentId = obj.data.id;
      			 console.log("parentId = " + parentId); 
    		}
  		}); 
  		});
    },
     error: function (jqXHR, textStatus, errorThrown) {  //错误 方法  jqXHR变量，textStatus  errorThrown文本 
         alert("返回失败");
         alert(jqXHR + "\n\r ErrorMessage:" + textStatus + "\n\r HTTP Error:" + errorThrown);
    }
});


$("#button1").click(function(){
  	/* console.log("parentId" +parentId); */
  	/* if(parentId == null) {
  		 alert("请选择文件夹");
  	} else {
  		$("#parentId").val(parentId);
		$("#form1").attr("action","updateParentId.form");
    	$("#form1").submit(); 
    	alert("添加成功");
    } */
    if(parentId == null) {
  		 alert("请选择文件夹");
  	} else {
    	$.ajax({
    	type: "GET",  //请求的方式
    	url: "copyFileInfo.form", //请求的地址
    	dataType: "json",   //数据返回的类型
    	success: function (data) {
    		if(data == "Y") {
    			alert("修改成功");
    		} else {
    			alert("修改失败")；
    		}

    	}

    });
    )
     
});
</script>

</body>
</html>