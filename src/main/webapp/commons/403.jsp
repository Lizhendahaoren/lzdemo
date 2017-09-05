<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>系统提示</title>
<link rel="stylesheet" href="css/bootstrap-3.2.0/css/bootstrap.min.css"/>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript">
	
</script>
<style type="text/css">
body{
	background-color: #EEEEEE;
}
.tip-panel{
	margin-left: auto;
	margin-right: auto;
	margin-top: 120px;
	width: 720px;
}
.ti-tip{
	margin: 60px;
}
.ti-tip-alert{
	color: #a94442;
	font-size: 20px;
	font-weight: 800;
}
</style>
</head>
<body>

<div>
	<div class="panel panel-primary tip-panel">
		<div class="panel-heading">系统提示</div>
		<div class="panel-body">
			<div class="ti-tip">
			<c:choose>
 
   				<c:when test="${errorCode=='1'}">
   			   		<p class="ti-tip-alert">抱歉! 您的账号已经在另一个地方登陆!</p>
					<p>服务器拒绝了您的浏览请求。</p>
					<p>请您关闭浏览器重新登录。</p>
   				</c:when>
    
  				<c:otherwise> 
					<p class="ti-tip-alert">抱歉! 您没有访问资源的权限!</p>
					<p>服务器拒绝了您的浏览请求。</p>
					<p>请确认您拥有所需的访问权限。</p>
   				</c:otherwise>
			</c:choose>
				
			</div>
		</div>
		<div class="panel-footer"></div>
	</div>
</div>
</body>
</html>