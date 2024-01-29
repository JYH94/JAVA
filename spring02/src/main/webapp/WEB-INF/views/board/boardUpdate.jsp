<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="update" method="post">

	<c:if test="${sessionScope.loginId == requestScope.apple.id }">
		<table border=1>
		<tr>
			<th>seq</th>
			<td><input type=text name="seq" value="${requestScope.apple.seq}" readonly></td>
		</tr>
		<tr>
			<th>id</th>
			<td><input type=text name="id" value="${requestScope.apple.id}" readonly></td>
		</tr>
		<tr>
			<th>title</th>
			<td><input type=text name="title" value="${requestScope.apple.title}" ></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><input type=text name="content" value="${requestScope.apple.content}" readonly></td>
		</tr>
	</table>
		<button>수정</button>
		
		<c:if test="${requestScope.message != null }">
			${requestScope.message }
		</c:if>
	</c:if>
	
	
	<c:if test="${sessionScope.loginId != requestScope.apple.id }">
		<table border=1>
		<tr>
			<th>id</th>
			<td><input type=text value="${requestScope.apple.id}" readonly></td>
		</tr>
		<tr>
			<th>title</th>
			<td><input type=text value="${requestScope.apple.title}" readonly ></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><input type=text value="${requestScope.apple.content}" readonly></td>
		</tr>
	</table>
	&nbsp;<a href="javascript:history.back(-1);">이전으로</a>&nbsp;
	</c:if>
	
</form>
</body>
</html>