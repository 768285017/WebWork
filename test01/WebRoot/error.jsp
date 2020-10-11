<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body onload="outTime()">
	<h1><span id="txt"></span>秒后自动返回登录页面</h2>
	  ${info}
	  <a href="http://localhost:8080/test/login.html">点击跳转</a>
     <br>
  </body>
  <script type="text/javascript">
	  var c = 6;
	  function outTime(){
		document.getElementById("txt").innerHTML = c;
	  	if(c === 0){
			window.location = "login.html"
			// window.setTimeout("window.location='index.html'",0);
		}else{
			c--;		
			setTimeout('outTime()',1000);
		}
	  }
	  
	//   window.setTimeout("window.location='login.html'",3000);
  </script>
</html>
