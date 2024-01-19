<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="a" value="${requestScope.apple}"></c:set>
	<table border="1">
		<tr>
			<th>id</th>
			<th>password</th>
			<th>name</th>
			<th>age</th>
			<th>jno</th>
			<th>info</th>
			<th>point</th>
			<th>birthday</th>
			<th>rid</th>
		</tr>
		<tr>
			<td>${requestScope.apple.id }</td>
			<td>${requestScope.apple.password }</td>
			<td>${requestScope.apple.name }</td>
			<td>${requestScope.apple.age }</td>
			<td>${requestScope.apple.jno }</td>
			<td>${requestScope.apple.info }</td>
			<td>${requestScope.apple.point }</td>
			<td>${requestScope.apple.birthday }</td>
			<td>${requestScope.apple.rid }</td>
		</tr>
		<tr>
			<td>${a.id }</td>
			<td>${a.password }</td>
			<td>${a.name }</td>
			<td>${a.age }</td>
			<td>${a.jno }</td>
			<td>${a.info }</td>
			<td>${a.point }</td>
			<td>${a.birthday }</td>
			<td>${a.rid }</td>
		</tr>
		
	</table>
	
	<a href="home.jsp">Home</a>
</body>
</html>