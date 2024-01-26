<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" 
		href="/spring02/resources/myLib/myStyle.css" >
</head>
<style>
	* {
		text-align: center;
	}

	th {
		background-color: aqua;
	}
	

</style>
<body>
<h2>** 조 List **</h2>
<form action="detail" method="get">
	<table border=1>
		<tr>
			<th>Jno</th>
			<th>Jname</th>
			<th>Captain</th>
			<th>조장명</th>
			<th>Project</th>
			<th>Slogan</th>
		</tr>
		
	<c:if test="${!empty requestScope.banana }">
	<c:forEach var="test" items="${requestScope.banana}">
		<tr>
						
					<td><a href="detail?jno=${test.jno}">${test.jno}</a></td>
					
				<td>${test.jname}</td>
				<td>${test.captain}</td>
				<td>${test.cname}</td>
				<td>${test.project}</td>
				<td>${test.slogan}</td>
		</tr>
	</c:forEach>
	</c:if>
	<c:if test="${empty requestScope.banana}">
		<tr>
			<td colspan="5" style="text-align: center;">memberList 결과가 1건도 없음</td>
		</tr>
	</c:if>
	
	
	</table>
</form>

<hr>
<c:if test="${!empty requestScope.message }">
	${requestScope.message }
</c:if>
<c:if test="${!empty requestScope.jmessage }">
	${requestScope.jmessage }
</c:if>
<hr>
	<br>
	<a href="/spring02/home">Home</a><br>
	<a href="javascript:history.back(-1);">이전으로</a>
	
</body>
</html>