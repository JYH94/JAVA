<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Spring01_MVC02 MemberList **</title>
</head>
<body>
	<h2>** Spring01_MVC02 MemberList **</h2>
	<hr>
	<c:if test="${!empty requestScope.massage}">
	=> ${requestScope.massage}	
	<hr>
	</c:if>
	<table border="1" style="width: 100%">
		<tr bgcolor="DeepSkyBlue" style="font-weight: bold;">
			<th>ID</th><th>Password</th><th>Name</th><th>Age</th><th>Jno</th>
			<th>Info</th><th>Point</th><th>Birthday</th><th>추천인</th>
		</tr>
		<c:choose>
			<c:when test="${!empty requestScope.banana}">
				<c:forEach var="s" items="${requestScope.banana}">
					<tr>
						<td>${s.id}</td>
						<td>${s.password}</td>
						<td>${s.name}</td>
						<td>${s.age}</td>
						<td>${s.jno}</td>
						<td>${s.info}</td>
						<td>${s.point}</td>
						<td>${s.birthday}</td>
						<td>${s.rid}</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="9" style="text-align: center;">memberList 결과가 1건도 없음</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
	<hr>
	&nbsp;<a href="home">Home</a>&nbsp;
	&nbsp;<a href="javascript:history.back();">이전으로</a>&nbsp;
</body>
</html>