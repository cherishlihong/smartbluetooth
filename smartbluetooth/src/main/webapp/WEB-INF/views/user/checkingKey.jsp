<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<meta content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0;"name="viewport"/>
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/reset.css'/> "/>
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/findKey.css'/> "/>
	<title>秘钥查询</title>
</head>
<body>
	<div class="mainContent">
	<c:forEach items="${applications}" var="application"  >
	
		<div class="list_item"> 
			<div class="list_item_img">
			<img src='<c:url value="/resources/pictures/key_gray.png" />' width="98%" height="98%">
			</div>
			<div class="list_item_word">
				<p id="address">${application.openAddress }</p>
				<p>到期之间：<a id="time">${application.leaveTime}</a></p>
				<p>请求次数：<a id="count">${application.openCount}</a></p>
				<a id="message">申请审核中，请耐心等待。。。</a>
			</div>
		</div>
		
	</c:forEach>
	</div>
</body>
</html>