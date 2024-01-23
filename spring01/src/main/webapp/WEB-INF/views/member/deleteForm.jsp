<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Delete **</title>
</head>
<body>
<h2>정말로 탈퇴 하시겠습니까??</h2>
<form action="/web02/mdelete" method="post">
	<input type="submit" value="삭제">&nbsp;&nbsp;&nbsp;
	<input type="reset" value="취소" onClick="location.href='/web02/home.jsp'">
</form>
<c:if test="${not empty requestScope.message}">
=> ${requestScope.message}<br>
</c:if>
</body>
</html>