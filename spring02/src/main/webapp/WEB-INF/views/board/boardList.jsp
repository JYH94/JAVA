<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>** Spring MVC2 BoardList **</title>
</head>
<body>
	<h2>** Spring MVC2 BoardList **</h2>
	<table border="1" style="width: 100%">
		<tr bgcolor="DeepSkyBlue" style="font-weight: bold;">
			<th>Seq</th>
			<th>Title</th>
			<th>ID</th>
			<th>RegDate</th>
			<th>조회수</th>
		</tr>
		<c:if test="${!empty sessionScope.loginId }">
		<form action="delete" method="get">
			<c:forEach var="s" items="${requestScope.banana}">
				<tr>
					<td>${s.seq}</td>
						<td>
						<a href="detail?jCode=U&seq=${s.seq}">
							${s.title}
						</a>
						</td>
					<c:if test="${empty sessionScope.loginId }">
						<td>${s.title}</td>
					</c:if>
					<td>${s.id}</td>
					<td>${s.regdate}</td>
					<td>${s.cnt}</td>
					<c:if test="${s.id == sessionScope.loginId }">
						<td><input type="submit" value="삭제"></td>
					</c:if>
					<c:if test="${s.id != sessionScope.loginId }">
						<td>~~</td>
					</c:if>
				</tr>
			</c:forEach>
		</form>
		</c:if>
		<c:if test="${empty sessionScope.loginId }">
			<h1>로그인 하지 않으면 게시판 못봐</h1>
		</c:if>
	</table>
	<hr><br>
	&nbsp;<a href="/spring02/home">Home</a>&nbsp;
	&nbsp;<a href="javascript:history.back();">이전으로</a>&nbsp;
	&nbsp;<a href="boardInsert">글쓰기</a>&nbsp;
</body>
</html>