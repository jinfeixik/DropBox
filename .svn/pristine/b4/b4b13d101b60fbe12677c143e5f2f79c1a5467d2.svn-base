<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
      
   <link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">
   <link rel="stylesheet" href="css/transfer_right_content.css" type="text/css">

  </head>
  
  <body>
 
	 <c:forEach items="${fileTransferLsit}" var="fileLsit"> 
	  <div class="right_list">
	  	<div class="right_list_img">
	  	 <c:if test="${fileLsit.fileType==1}">
			<img src="images/img.png"/>
		</c:if>
		 <c:if test="${fileLsit.fileType==2}">
			<img src="images/wendang.png"/>
		</c:if>
		 <c:if test="${fileLsit.fileType==3}">
			<img src="images/video.png"/>
		</c:if>
	  	 <c:if test="${fileLsit.fileType==4}">
			<img src="images/zhongzhi.png"/>
		</c:if>
	    <c:if test="${fileLsit.fileType==5}">
			<img src="images/music.png"/>
		</c:if>
		<c:if test="${fileLsit.fileType==0}">
			<img src="images/other.png"/>
		</c:if>
	   </div>
		<div class="right_list_file_information">
			<div class="right_list_file_information_filename">${fileLsit.fileName}</div><div  class="right_list_file_information_filesize">65MB</div>
		</div>
		<div class="right_list_file_time">
			<font>${fileLsit.fileTime}</font>
		</div>
		<div class="right_list_flag">
		<c:if test="${fileLsit.transferUploadaAndDownloadFlag==2}">
			<i class="fa fa-arrow-down" style="color: rgb(6,168,255)"></i><font>下载完成</font>
        </c:if>
        <c:if test="${fileLsit.transferUploadaAndDownloadFlag==1}">
        <i class="fa fa-arrow-up" style="color: rgb(6,168,255)"></i><font>下载完成</font>
        </c:if>
           <button onclick=openFileIIs("C:\Users")>333</button> 
		   <a href=""><img src="images/qinchu.png" style="width:15px;height:15px;"></a>
		</div>
		</div>
       </c:forEach>
      

  </body>
<script>
function openFileIIs(filename){        
        try{ 
            var obj=new ActiveXObject("wscript.shell"); 
            if(obj){ 
                obj.Run("\""+filename+"\"", 1, false );
                //obj.run("osk");/*打开屏幕键盘*/
                //obj.Run('"'+filename+'"'); 
                obj=null; 
            } 
        }catch(e){ 
            alert("请确定是否存在该盘符或文件"); 
        } 
        
    }
</script>
</html>
