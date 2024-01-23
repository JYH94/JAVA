<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Login Form **</title>
<style type="text/css">
	tr {
		height: 40px;
	}
	table tr:nth-child(1) td:nth-child(1)
	,table tr:nth-child(2) td:nth-child(1) {
		background-color: aqua;
	}
</style>
</head>
<body>
<h2>** Login Form **</h2>
<form action="/web02/login" method="post">
<table>
	<tr>
		<td><label for="id">I D</label></td>
		<td><input type="text" id="id" name="id" size="18"></td>
	</tr>
	<tr>
		<td><label for="password">비밀번호</label></td>
		<td><input type="password" id="password" name="password" size="18"></td>
	</tr>
	<tr><td></td>
		<td>
			<input type="submit" value="로그인">&nbsp;&nbsp;&nbsp;
			<input type="reset" value="취소">
		</td>
	</tr>
</table>
</form>
<hr>

<c:if test="${not empty requestScope.message}">
=> ${requestScope.message}<br>
</c:if>	
<hr>
	&nbsp;<a href="/web02/home.jsp">Home</a>&nbsp;
	&nbsp;<a href="javascript:history.back();">이전으로</a>&nbsp;	
</body>
</html>