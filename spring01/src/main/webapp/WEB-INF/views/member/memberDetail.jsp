<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** MyInfo **</title>
<style type="text/css">

	tbody, tr {
		display: flex;
	}
	tr {
		flex-direction: column;
	}
	th,td {
		
		height: 40px;
		display:flex;
		align-items: center;
	}
	th {
		width: 10vw;
		justify-content: center;
		text-align: center;
	}
	td {
		width: 40vw;
		padding-left: 10px;
	}
	input {
		border: none;
		height: 30px;
		font-size: 18px;
		width: 37vw;
	}
	input:focus {
		outline:none;
	}
</style>
</head>
<body>
	<h2>** MyInfo **</h2>
	<table border=1>
		<tr bgcolor="Aquamarine" style="font-weight: bold;">
			<th>ID</th><th>Password</th><th>Name</th><th>Age</th><th>Jno</th>
			<th>Info</th><th>Point</th><th>Birthday</th><th>추천인</th>
		</tr>
		<c:choose>
			<c:when test="${!empty requestScope.dto}">
				<tr>
					<td>${dto.id}</td><td>${dto.password}</td>
					<td>${dto.name}</td><td>${dto.age}</td>
					<td>${dto.jno}</td><td>${dto.info}</td>
					<td>${dto.point}</td><td>${dto.birthday}</td>
					<td>${dto.rid}</td>
				</tr>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="9">MyInfo 결과가 1건도 없음
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
	<hr>
	&nbsp;<a href="/web02/home.jsp">Home</a>&nbsp;
	&nbsp;<a href="javascript:history.back();">이전으로</a>&nbsp;
</body>
</html>