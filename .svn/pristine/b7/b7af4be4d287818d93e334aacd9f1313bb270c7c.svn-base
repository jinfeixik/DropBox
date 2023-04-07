<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>传输列表</title>
<link rel="stylesheet" href="css/common.css" type="text/css" />
<link rel="stylesheet" href="css/index.css" type="text/css" />
<link rel="stylesheet" href="css/lajixiang.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="page/base.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="page/pageGroup.css" type="text/css"
	media="screen" />
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="css/transfer/transfer.css" rel="stylesheet">
<link href="css/transfer/basic.css" rel="stylesheet" type="text/css">
<link href="css/transfer/style.css" rel="stylesheet" type="text/css">
<script src="js/transfer/jquery.min.js"></script>
<script src="js/transfer/index.js"></script>

<link rel="stylesheet"
	href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">
<link rel="stylesheet" href="css/transfer_right_content.css"
	type="text/css">

<link rel="stylesheet"
	href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">


</head>
<body>
	<!--顶部-->
	<div class="nav">
		<div class="nav cl">
			<div class="nav_z z" style="margin-top: 8px;">
				<img src="images/logo2.png">
			</div>

			<div class="nav_st z">
				<input type="text" name="search" placeholder="搜索.."
					class="seafch-input">
			</div>

			<div class="nav_y y">
				<a href="http://www.bootstrapmb.com/">关于我们</a> <span>丨</span> <a
					href="">联系我们</a>
			</div>
			<div class="userNumber y">
				<div class="dropdown">
					<a href="" id="dropdownMenu1" onmouseover="display()"
						onmouseout="disappear()" data-toggle="dropdown"> <img
						src="images/timg.jpg" class="touxiang" />&nbsp;&nbsp;&nbsp; <font
						size="3" color="#009688" style="font-family: KaiTi_GB2312  ;">用户名</font>&nbsp;&nbsp;&nbsp;
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
				<div id="left-small" class="cruent">
					<div class="left-menu-top-small1">
						<span class="glyphicon glyphicon-file"
							style="color: rgb(97, 154, 251);">&nbsp;<a
							href="index.jsp">全部文件</a> </span>
					</div>
				</div> </a> <a href="javascript:void(0)">
				<div id="left-small">
					<div class="left-menu-top-small">图片</div>
				</div> </a> <a href="">
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
				</div> </a> <a href="transfer.jsp">
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

	<div id="right-content" class="right-content"
		style="background-color: white;margin-left: 200px;margin-top:-120px;width:100%;">
		<div style="padding:5px 0px 5px 20px;width:85%;">
			<font size="3">共传输完成 <font color="#518cf7">${sum}</font>个文件！</font>
			<div style="float: right;padding-right:60px">
				<a href="delUserAllTransferList.form">清除所有记录</a>
			</div>
		</div>
		<hr style="margin: 0px">
		<c:forEach items="${fileTransferLsit}" var="fileLsit">
			<div class="right_list">
				<div class="right_list_img">
					<c:if test="${fileLsit.fileType==1}">
						<img src="images/img.png" />
					</c:if>
					<c:if test="${fileLsit.fileType==2}">
						<img src="images/wendang.png" />
					</c:if>
					<c:if test="${fileLsit.fileType==3}">
						<img src="images/video.png" />
					</c:if>
					<c:if test="${fileLsit.fileType==4}">
						<img src="images/zhongzhi.png" />
					</c:if>
					<c:if test="${fileLsit.fileType==5}">
						<img src="images/music.png" />
					</c:if>
					<c:if test="${fileLsit.fileType==0}">
						<img src="images/other.png" />
					</c:if>
				</div>
				<div class="right_list_file_information">
					<div class="right_list_file_information_filename">${fileLsit.fileName}</div>
					<c:if test="${fileLsit.fileSize==-1.0}">
						<div class="right_list_file_information_filesize">压缩文件</div>
					</c:if>
					<c:if test="${fileLsit.fileSize!=-1.0}">
						<div class="right_list_file_information_filesize">${fileLsit.fileSize}MB</div>
					</c:if>
				</div>
				<div class="right_list_file_time">
					<font>${fileLsit.fileTime}</font>
				</div>
				<div class="right_list_flag">
					<c:if test="${fileLsit.transferUploadaAndDownloadFlag==2}">
						<i class="fa fa-arrow-down" style="color: rgb(6,168,255)"></i>
						<font>下载完成</font>
					</c:if>
					<c:if test="${fileLsit.transferUploadaAndDownloadFlag==1}">
						<i class="fa fa-arrow-up" style="color: rgb(6,168,255)"></i>
						<font>上载完成</font>
					</c:if>

					<a
						href="delTransferList.form?fileTransferLsitId=${fileLsit.fileTransferLsitId}"><img
						src="images/qinchu.png" style="width:15px;height:15px;"> </a>
				</div>
			</div>
		</c:forEach>
	</div>

</body>
<script>
	function openFileIIs(filename) {
		try {
			var obj = new ActiveXObject("wscript.shell");
			if (obj) {
				obj.Run("\"" + filename + "\"", 1, false);
				//obj.run("osk");/*打开屏幕键盘*/
				//obj.Run('"'+filename+'"'); 
				obj = null;
			}
		} catch (e) {
			alert("请确定是否存在该盘符或文件");
		}

	}
</script>

</html>