<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>	
    <link href="" rel="stylesheet">
    <script type="text/javascript" src="js/jquery.min.js"></script>
  </head>
<body>


<input type="checkbox" name="test" value="a.xls">a.xls<br/>
<input type="checkbox" name="test" value="dir.png">dir.png<br/>
<input type="checkbox" name="test" value="excel01.png">excel01.png<br/>
请点击下载(选中复选框多个文件,单个文件下载正确，多个文件后台有输出，前台无反应)：<a href="" onclick="fun()" id="a">moni.jpg</a><br><br>
请点击下载(选中复选框多个文件zip)：<a href="" onclick="fun2()" id="b">moni.jpg</a><br><br>

</body>
<script>

function fun(){
var allFileName="";
    obj = document.getElementsByName("test");
    check_val = [];
    for(k in obj){
        if(obj[k].checked){
       allFileName+=obj[k].value+" ";
            }
    }
    alert(allFileName)
  var s=$('#a').attr("href","downlode.form?filename="+allFileName);
  /* $.ajax({
          urlf:"downlode.form",
          data:{allFileName:allFileName},
             type:"post",

             dataType:"json",
          success:function(data){
          console.log(data);              
          },
             });
   
    console.log(allFileName);*/
}
function fun2(){
var allFileName="";
    obj = document.getElementsByName("test");
    check_val = [];
    for(k in obj){
        if(obj[k].checked){
       allFileName+=obj[k].value+" ";
            }
    }
    alert(allFileName)
  var s=$('#b').attr("href","zip.form?filename="+allFileName);
 
}


</script>
</html>

