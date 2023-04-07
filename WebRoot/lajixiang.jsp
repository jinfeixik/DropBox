<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<title>回收站</title>
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
.recyclebtn {
	width: 20px;
	height: 20px;
	margin: 15px 20px 0 0;
}
</style>
</head>
<body>
	<!--顶部-->
	<div class="nav">
		<div class="nav cl">
			<div class="nav_z z" style="margin-top: 8px;">
				<img src="images/logo2.png">
			</div>

			<div class="nav_st z" style="margin-top: 7px;"></div>

			<div class="nav_st z" style="margin-top: 10px;">
				<input type="text" name="search" placeholder="搜索.."
					class="seafch-input">
			</div>

			<div class="nav_y y">
				<a href="http://www.bootstrapmb.com/">关于我们</a> <span>丨</span> <a
					href="">联系我们</a>
			</div>
			<div class="userNumber y" style="margin-top: 20px;">
				<div class="dropdown" style="z-index:99999">
					<a href="" id="dropdownMenu1" onmouseover="display()"
						onmouseout="disappear()" data-toggle="dropdown"> <img
						src="${user.userAvatar}" class="touxiang" />&nbsp;&nbsp;&nbsp; <font
						size="3" color="#009688" style="font-family: KaiTi_GB2312  ;">${user.userName}</font>&nbsp;&nbsp;&nbsp;
						<span class="caret"></span> </a>
					<ul class="dropdown-menu" role="menu"
						aria-labelledby="dropdownMenu1" id="box" onmouseover="display()"
						onmouseout="disappear()">
						<li role="presentation" style="height: 60px;"><a
							role="menuitem" tabindex="-1" href="#">
								<div class="col-md-4">
									<img src="images/timg.jpg" class="touxiang1"
										style="margin-top: 0px;margin-left: -20px;" />&nbsp;&nbsp;&nbsp;
								</div>
								<div class="col-md-8" style="margin-top: 5px;">
									<font size="3" color="#009688">用户名</font>&nbsp;&nbsp;&nbsp;<br />
									<font size="2" color="#000" style="margin-top: -40px;">会员等级</font>&nbsp;&nbsp;&nbsp;
								</div> </a>
						</li>
						<li role="presentation" class="divider"></li>
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="#">个人中心</a>
						</li>
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="#">退出</a>
						</li>
					</ul>
				</div>
			</div>

		</div>

	</div>
	<!--顶部结束-->
	<!--菜单-->
	<div class="left-menu">
		<div class="left-menu-top">
			<a href="listAllFile.form">
				<div id="left-small">
					<div class="left-menu-top-small1">
						<span class="glyphicon glyphicon-file"
							style="color: rgb(97, 154, 251);">&nbsp;全部文件</span>
					</div>
				</div> </a> <a href="javascript:void(0)">
				<div id="left-small">
					<div class="left-menu-top-small">图片</div>
				</div> </a> <a href="javascript:void(0)">
				<div id="left-small">
					<div class="left-menu-top-small">文档</div>
				</div> </a> <a href="javascript:void(0)">
				<div id="left-small">
					<div class="left-menu-top-small">视频</div>
				</div> </a> <a href="javascript:void(0)">
				<div id="left-small">
					<div class="left-menu-top-small">音乐</div>
				</div> </a> <a href="javascript:void(0)">
				<div id="left-small">
					<div class="left-menu-top-small">其他</div>
				</div> </a> <a href="getAllShare.form">
				<div id="left-small">
					<div class="left-menu-top-small2">
						<span class="glyphicon glyphicon-share"
							style="color: rgb(97, 154, 251);">&nbsp;我的分享</span>
					</div>
				</div> </a> <a href="getAllRecycle.form">
				<div id="left-small">
					<div class="left-menu-top-small2">
						<span class="glyphicon glyphicon-trash"
							style="color: rgb(97, 154, 251);">&nbsp;回收站</span>
					</div>
				</div> </a><a href="transferList.form">
				<div id="left-small">
					<div class="left-menu-top-small2">
						<span class="glyphicon glyphicon-sort"
							style="color: rgb(97, 154, 251);">&nbsp;传输列表</span>
					</div>
				</div> </a>
		</div>

		<div class="left-menu-four">
			<div class="left-menu-four-small">
				<div class="left-menu-four-small-new"></div>
			</div>
		</div>
		<div class="contain_four">
			<div class="contain_four_main">
				<span>容量：</span> <span class="cont">5</span>M&nbsp;&nbsp;&nbsp;&nbsp;可用
				<span class="use">${5-volume}</span>M
			</div>
			<div class="max_add">
				<a href="personalInfo.form"> <font color="blue">我要扩容</font> </a>
			</div>

		</div>
	</div>

	<!--菜单end-->
	<!--菜单右边的iframe页面-->
	<div id="right-content" class="right-content"
		style="margin-top: -120px;">
		<div class="content">
			<div id="page_content">
				<span style="margin-left:24px;color: #999;font-size: 14px;">提示：回收站不占用网盘空间，文件保存10天后将被自动清除，开通会员延长至30天。</span>
				<br />
				<div class="">

					<div class="zuijinTitle cl"
						style="margin: 20px 0 0px -9px;height:50px;">
						<img src="images/select.png" data-all="no"
							class="z allIcon allSelect" alt="">
						<div class="z allSelect" style="margin: 10px 0 0 5px;">全选</div>
						<p class="z name" style="margin: 10px 0 0 15px;">文件名</p>
						<a href="javascript:void(0);"
							class="button button-glow button-border button-rounded button-primary"
							style="margin-left: 20px;height:40px;display:none"
							id="reductionAll">还原所有文件</a> <a href="javascript:void(0);"
							class="button button-glow button-border button-rounded button-primary"
							style="margin-left: 20px;display:none" id="deleteAll">清空回收站</a>
						<p class="y time"
							style="margin:10px 115px 0 0;color: #505458;font-size: 14px;">删除时间</p>
						<p class="y size"
							style="margin:10px 32px 0 0;color: #505458;font-size: 14px;">大小</p>
					</div>
					<div class="content cl">
						<c:forEach items="${fileInfos }" var="fileInfo">
							<div class="template cl" data-click="no">
								<img src="images/select.png" class="z templateState" alt="">
								<c:if test="${fileInfo.fileType == 1}">
									<img src="images/img.png" class="z iconImg" alt="">
								</c:if>
								<c:if test="${fileInfo.fileType == 2}">
									<img src="images/document.png" class="z iconImg" alt="">
								</c:if>
								<c:if test="${fileInfo.fileType == 3}">
									<img src="images/video.png" class="z iconImg" alt="">
								</c:if>
								<c:if test="${fileInfo.fileType == 4}">
									<img src="images/music.png" class="z iconImg" alt="">
								</c:if>
								<c:if test="${fileInfo.fileType == 0}">
									<img src="images/other.png" class="z iconImg" alt="">
								</c:if>
								<p class="z name" style="margin-top: 15px;">${fileInfo.fileName
									}</p>
								<p class="y time" style="margin-top: 15px;">${fileInfo.uploadTime
									}</p>
								<p class="y size" style="margin-top: 15px;font-size:14px;">${fileInfo.fileSize
									}K</p>
								<div id="operation" style="display: none;">
									<a href="javascript:void(0);" id="delete"> <img
										src="images/delete.png" class="y iconImg"
										style="width: 20px;height: 20px;margin: 15px 20px 0 0;"
										alt="删除"> <input type="hidden"
										value="${fileInfo.fileId }" /> </a> <a href="javascript:void(0);"
										id="reduction"> <img src="images/reduction.png"
										class="y iconImg"
										style="width: 20px;height: 20px;margin: 15px 20px 0 0;"
										alt="还原"> <input type="hidden"
										value="${fileInfo.fileId }" /> </a>
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

		<div id="pageGro" class="cb">
			<div class="pageUp">上一页</div>
			<div class="pageList">
				<ul>
					<li>1</li>
					<li>2</li>
					<li>3</li>
					<li>4</li>
					<li>5</li>
				</ul>
			</div>
			<div class="pageDown">下一页</div>
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
		/* 清空回收站 */
		$("#deleteAll").click(function() {
			console.log("清空回收站");
			$.ajax({
				url : "clearRecycle.form",
				type : "post",
			});
			window.location = "getAllShare.form";
			location.reload();
		});
		/******点击全选*****/
		$(".allSelect").click(function() {
			if ($(".allIcon").attr("data-all") == "no") {
				$(".template").attr("data-click", "yes");
				$(".templateState").attr("src", "images/selectC.png");
				$(".allIcon").attr("data-all", "yes");
				$(".allIcon").attr("src", "images/selectC.png");
				$("#reductionAll").css("display", "inline-block");
				$("#deleteAll").css("display", "inline-block");
			} else {
				$(".template").attr("data-click", "no");
				$(".templateState").attr("src", "images/select.png");
				$(".allIcon").attr("data-all", "no");
				$(".allIcon").attr("src", "images/select.png");
				$("#reductionAll").css("display", "none");
				$("#deleteAll").css("display", "none");
			}
		});

		bindClick();
		/*********某一个点击*****/
		function bindClick() {
			$(".content .template")
					.each(
							function(e) {
								$(this)
										.click(
												function() {
													if ($(this).attr(
															"data-click") == "yes") {
														$(".allIcon").attr(
																"data-all",
																"no");
														$(".allIcon")
																.attr("src",
																		"images/select.png");
														$(this).attr(
																"data-click",
																"no");
														$(this)
																.find(
																		".templateState")
																.attr("src",
																		"images/select.png");
													} else {
														$(this).attr(
																"data-click",
																"yes");
														$(this)
																.find(
																		".templateState")
																.attr("src",
																		"images/selectC.png");
													}
												});
								/* 显示or隐藏 删除or还原按钮 */
								$(this)
										.hover(
												function() {
													var that = $(this);
													//console.log("inherit");
													$(this).find("#operation")
															.css("display",
																	"inherit");
													/* 删除选中的文件 */
													$(this)
															.find("#delete")
															.click(
																	function() {
																		var fileId = $(
																				this)
																				.children(
																						"input")
																				.val();
																		console
																				.log("fileId "
																						+ fileId);
																		$
																				.ajax({
																					url : "deleteRecycle.form",
																					type : "post",
																					data : {
																						fileId : fileId
																					}
																				});
																		that
																				.remove();
																	});
													/* 还原选中的文件 */
													$(this)
															.find("#reduction")
															.click(
																	function() {
																		var fileId = $(
																				this)
																				.children(
																						"input")
																				.val();
																		console
																				.log("fileId "
																						+ fileId);
																		$
																				.ajax({
																					url : "moveOutOfRecycle.form",
																					type : "post",
																					data : {
																						fileId : fileId
																					}
																				});
																		that
																				.remove();
																	});
												});
								$(this).mouseleave(
										function() {
											//console.log("none");
											$(this).find("#operation").css(
													"display", "none");
										});
							});
		}
		$(".huanyuan").click(function() {
			$(".huanyuanBox").show();
		});
		$(".quxiao,.ok,.close").click(function() {
			$(".huanyuanBox").hide();
		});
	</script>
</body>

</html>
