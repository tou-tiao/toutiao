<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>风景区</title>
	<style>
        .nav{float:right}
	</style>
</head>
<body>
	<c:if test="${!empty error}">
		<font color="red"><c:out value="${error}" /></font>
    </c:if>
	<div class="nav">
	    <form action="<c:url value="/admin/login.html"/>" method="post">
    		用户名:
    		<input type="text" name="userName">
    		<br>
    		密码:
    		<input type="password" name="password">
    		<br>
    		<input type="submit" value="登录">
    		<input type="reset" value="重置">
    	</form>
	</div>
</body>
</html>
