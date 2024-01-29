<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** JoDetail</title>
<link rel="stylesheet" type="text/css" 
		href="/spring02/resources/myLib/myStyle.css" >
</head>
<style>
	th {
		background-color: aqua;
	}
</style>
<body>
<h1>** 조 상세정보 **</h1>
	<table border=1 style="width:90%; margin:0 auto;">
		<tr>
			<th>Jno</th>
			<th>Jname</th>
			<th>Captain</th>
			<th>Project</th>
			<th>Slogan</th>
		</tr>
		<tr>
			<td>${requestScope.apple.jno }</td>
			<td>${requestScope.apple.jname }</td>
			<td>${requestScope.apple.captain }</td>
			<td>${requestScope.apple.project }</td>
			<td>${requestScope.apple.slogan }</td>
		</tr>
	</table>
	
	<br>
	<hr>
	<br>

	
	<%-- <c:if test="${!empty requestScope.test }">
		<table border=1 style="width:90%; margin:0 auto;">
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
			<c:forEach items="${requestScope.test }" var="list">
				<tr>
					<td>${list.id }</td>
					<td>${list.password }</td>
					<td>${list.name }</td>
					<td>${list.age }</td>
					<td>${list.jno }</td>
					<td>${list.info }</td>
					<td>${list.point }</td>
					<td>${list.birthday }</td>
					<td>${list.rid }</td>
				</tr>
			</c:forEach>
		</table>
	</c:if> --%>
	<h1>** 조원 목록 **</h1>
	<c:if test="${!empty requestScope.test2 }">
		<table border=1 style="width:90%; margin:0 auto;">
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
			<c:forEach items="${requestScope.test2 }" var="list">
				<tr>
					<td>${list.id }</td>
					<td>${list.password }</td>
					<td>${list.name }</td>
					<td>${list.age }</td>
					<td>${list.jno }</td>
					<td>${list.info }</td>
					<td>${list.point }</td>
					<td>${list.birthday }</td>
					<td>${list.rid }</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<hr>
		<c:if test="${!empty requestScope.jmessage } }">
		${requestScope.jmessage }
	</c:if>
	<hr>
	
	<a href="/spring02/home">Home</a><br>
	<a href="javascript:history.back(-1);">이전으로</a><br>
	<a href="joUpdate?jno=${requestScope.apple.jno }">조 정보 수정하기</a><br>
		&nbsp;<a href = "joDelete?jno=${requestScope.apple.jno }">조 삭제하기</a>&nbsp;
</body>
</html>