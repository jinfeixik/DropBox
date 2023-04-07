<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>layui</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="layui/css/layui.css"  media="all">
</head>
<body>
  
  <div id="target">
  tree
  </div>     

 
<div class="site-demo-button" id="layerDemo" style="margin-bottom: 0;">
  
  <a style="text-decoration:none" class="ml-5"
	onClick="fileMove('移动到','fileMove.jsp?fileId=18')"
	href="javascript:;" title="移动"><i class="Hui-iconfont">移动</i>
 </a>
 
 <a style="text-decoration:none" class="ml-5"
	onClick="fileCopy('复制到','fileCopy.jsp?fileId=18')"
	href="javascript:;" title="复制"><i class="Hui-iconfont">复制</i>
 </a>
 
</div>
<script type="text/javascript" src="H-ui/lib/jquery/1.9.1/jquery.js"></script>
<script src="layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->

<script>
	

	function fileMove(title,url){
	 var div = $('#target') ;
	 console.log(div);
		var index = layer.open({
			type: 1,
			title: title,
			area: ['500px','300px'],
			content: $('#target'),
			//content: $("#target"), 
			 btn: ['继续弹出', '全部关闭'],
			yes: function(){
			  
			},
			btn2:()=>{
				layer.closeAll();
			},
			end:function(){
				window.location='listAllFile.form';
		  }
	   });
	//layer.full(index);
	}
	
	function fileCopy(title,url){
		var index = layer.open({
			type: 2,
			title: title,
			area: ['500px','300px'],
			content: url, 
			btn: '关闭',
			yes: function(){
			  layer.closeAll();
			},
			end:function(){
				window.location='listAllFile.form';
		  }
	   });
	//layer.full(index);
	}
	
	
	
	layui.use('layer', function(){ //独立版的layer无需执行这一句
  		var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句
  		$('#layerDemo .layui-btn').on('click', function(){
    		var othis = $(this), method = othis.data('method');
    		active[method] ? active[method].call(this, othis) : '';
  		});
	});
</script>


</body>
</html>