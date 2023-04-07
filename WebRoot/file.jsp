<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>分享的文件</title>
	<link rel="stylesheet" href="css/common.css" type="text/css" />
	<link rel="stylesheet" href="css/buttons.css" type="text/css" />
	<link rel="stylesheet" href="css/index.css" type="text/css" />
	<link rel="stylesheet" href="css/lajixiang.css" type="text/css"
		media="screen" />
	<link rel="stylesheet" href="page/base.css" type="text/css"
		media="screen" />
	<link rel="stylesheet" href="page/pageGroup.css" type="text/css"
		media="screen" />
	<link rel="stylesheet"
		href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script
		src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript" language="javascript">
		function display() {
			document.getElementById("box").style.display = "block";
		}
	
		function disappear() {
			document.getElementById("box").style.display = "none";
		}
	</script>
	<style>
		.recyclebtn{
			width: 20px;height: 20px;margin: 15px 20px 0 0;
		}
	</style>
</head>
<body>
	
	<!--菜单右边的iframe页面-->
	<div id="right-content" class="right-content"
		style="margin: -200px 0px 0px 120px;">
		<div class="content">
			<div id="page_content">
				<span style="margin-left:24px;color: #999;font-size: 14px;"></span>
				<br />
				<div class="">

					<div class="zuijinTitle cl" style="margin: 20px 0 0px -9px;height:50px;">
						<p class="z name" style="margin: 10px 0 0 33px;">文件名</p>
						<a href="javascript:void(0);" class="button button-glow button-border button-rounded button-primary" style="margin-left: 20px;height:40px;display:none" id="reductionAll">还原所有文件</a>
						<a href="javascript:void(0);" class="button button-glow button-border button-rounded button-primary" style="margin-left: 20px;display:none" id="deleteAll">清空回收站</a>
						<p class="y time"
							style="margin:10px 115px 0 0;color: #505458;font-size: 14px;">分享时间</p>
						<p class="y size"
							style="margin:10px 60px 0 0;color: #505458;font-size: 14px;">大小</p>
						<p class="y size"
							style="margin:10px 60px 0 0;color: #505458;font-size: 14px;">下载</p>
					</div>
					<div class="content cl">
						<c:forEach items="${fileShares }" var="fileShare">
							<div class="template cl" data-click="no">
								<c:if test="${fileShare.fileInfo.fileType == 1}">
									<img src="images/img.png" class="z iconImg" alt="">
								</c:if>
								<c:if test="${fileShare.fileInfo.fileType == 2}">
									<img src="images/document.png" class="z iconImg" alt="">
								</c:if>
								<c:if test="${fileShare.fileInfo.fileType == 3}">
									<img src="images/video.png" class="z iconImg" alt="">
								</c:if>
								<c:if test="${fileShare.fileInfo.fileType == 4}">
									<img src="images/music.png" class="z iconImg" alt="">
								</c:if>
								<c:if test="${fileShare.fileInfo.fileType == 0}">
									<img src="images/other.png" class="z iconImg" alt="">
								</c:if>
								<p class="z name" style="margin-top: 15px;">${fileShare.fileInfo.fileName }</p>
								<p class="y time" style="margin-top: 15px;">${fileShare.shareTime }</p>
								<p class="y size" style="margin: 15px 60px 0 0;font-size:14px;">${fileShare.fileInfo.fileSize }K</p>
								<div id="operation" style="display: inherit;">
									<a href="downlode.form?filename=${fileShare.fileInfo.fileName}&fileId=${fileShare.fileInfo.fileId}" id="download">
										<img src="images/download.png" class="y iconImg" style="width: 20px;height: 20px;margin: 15px 60px 0 0;" alt="下载"> 
										<input type="hidden" value="${fileShare.fileId }" /> 
									</a>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>

				<div class="huanyuanBox" style="display:none">
					<div class="huanyuanTitle">
						<span>还原文件</span>
					</div>
					<div class="close">+</div>
					<div class="content">
						<img src="images/selectC.png" class="hintIcon" alt="">
						<p class="p1">确定要还原选中的文件吗？</p>
						<p class="p2">文件将还原至删除前所在的文件夹</p>
					</div>
					<input type="button" class="y quxiao" value="取消"> <input
						type="button" class="y ok" value="确定">
				</div>

			</div>
		</div>

	</div>

	<script type="text/javascript" src="js/jquery-2.2.3.min.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
	<script>
		$(".sousouInput").blur(function() {
			$(".sousuo").css({
				border : "1px solid #ccc"
			});
			$(".ss1").removeClass("focusState");
		});
		$(".sousouInput").focus(function() {
			$(".sousuo").css({
				border : "1px solid #9cf"
			});
			$(".ss1").addClass("focusState");
		});
		$(".zuijinTitle").css({
			width : $(window).width() - 237
		});

		/*********点击下载*****/
		/* $("#download").click(function() {
			var fileId = $(this).children("input").val();
			console.log("fileId " + fileId);
			$.ajax({
				url : "deleteShare.form",
				type : "post",
				data : {
					fileId : fileId
				}
			});
		});  */
					
		$(".huanyuan").click(function() {
			$(".huanyuanBox").show();
		});
		$(".quxiao,.ok,.close").click(function() {
			$(".huanyuanBox").hide();
		});
	</script>
</body>

</html>