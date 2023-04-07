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
	<div id="target" style="display:none">
		<div id="testMove" class="demo-tree demo-tree-box"></div>
	</div>
	<%-- <form action="" id="form1" method="post">
	 <input type="hidden" name="fileId" value="${param.fileId }" >
	<input type="hidden" name="parentId" vlaue="0" id="parentId" >
	<input type="button" value="确定" id="button1">
	</form> --%>

	<input type="hidden" name="fileId" id="fileId" value="20">
	<button onclick="move()" >移动</button>
	<button onclick="copy()">复制</button>
	
</div>

<script type="text/javascript" src="H-ui/lib/jquery/1.9.1/jquery.js"></script>
<script src="layui/layui.js" charset="utf-8"></script>
<script>

var fileId = $("#fileId").val();
var parentId;
var title;


function test() {
	alert("test");
}


function move(){
    $("target").show();
    alert("aaa");
	layer.open({
				type: 1,
				title: '选择',
				area: ['500px','300px'],
				content: $('#target'),
				//content: $("#target"), 
				 btn: ['确定', '全部关闭'],
				yes: function(){
				  	sureMove();
				},
				btn2:()=>{
					layer.closeAll();
					$("target").hide();
				},
				 end:function(){
					window.location='listAllFile.form';
			  } 
		  });
}


function sureMove(){
	$.ajax({
		type: "GET",  //请求的方式
    	url: "updateParentId.form", //请求的地址
    	data: {parentId: parentId},
    	dataType: "json",   //数据返回的类型
    	success: function (data) { 
    		if(data == "Y") {
    			layer.closeAll();
				$("target").hide();
    		}else{
    			 layer.msg("请重新选择当前文件夹");
    		}
    	}
	});
	layer.closeAll();
	$("target").hide();
}

function copy(){
alert(fileId);
	$("target").show();
	layer.open({
				type: 1,
				title: '选择',
				area: ['500px','300px'],
				content: $('#target'),
				//content: $("#target"), 
				 btn: ['确定', '全部关闭'],
				yes: function(){
				  	sureCopy();
				},
				btn2:()=>{
					layer.closeAll();
					$("target").hide();
				},
				end:function(){
					window.location='listAllFile.form';
			   },
	  });
}


function sureCopy(){
	
	$.ajax({
		type: "GET",  //请求的方式
    	url: "copyFileInfo.form", //请求的地址
    	data: {parentId: parentId},
    	dataType: "json",   //数据返回的类型
    	success: function (data) { 
    		if(data == "Y") {
    			layer.closeAll();
				$("target").hide();
    		}else{
    			 layer.msg("请重新选择当前文件夹");
    		}
    	}
	});
	layer.closeAll();
	$("target").hide();
}





$.ajax({
    type: "GET",  //请求的方式
    url: "findFolderInfoYY.form", //请求的地址
    dataType: "json",   //数据返回的类型
    success: function (dataTree) {   //成功  方法  data返回是数据
    	layui.use(['tree', 'util'], function(){
  		var tree = layui.tree ,layer = layui.layer ,util = layui.util
    	  console.log(dataTree);  
    	    tree.render({
    			elem: '#testMove',
    			data: dataTree
    			/* ,edit: ['add', 'update', 'del'] */ //操作节点的图标
    			,click: function(obj){
      			//layer.msg(JSON.stringify(obj.data.title));
      			 parentId = obj.data.id;
      			 title = obj.data.title;
      			 layer.msg("选择" +title +"文件夹");
    		}
  		}); 
  		});
    },
     error: function (jqXHR, textStatus, errorThrown) {  //错误 方法  jqXHR变量，textStatus  errorThrown文本 
         alert("返回失败");
         alert(jqXHR + "\n\r ErrorMessage:" + textStatus + "\n\r HTTP Error:" + errorThrown);
    }
});

</script>

</body>
</html>