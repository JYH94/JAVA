<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="insert" method="post">
	<table border=1>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><input type="text" name="content"></td>
		</tr>
		<tr>
			<th>id</th>
			<td><input type="text" name="id" value="${sessionScope.loginId }" readonly></td>
		</tr>
	</table>
	<input type="submit">
	</form>
	
	<c:if test="${!empty requestScope.message}">
		${requestScope.message}
	</c:if>
</body>
</html>