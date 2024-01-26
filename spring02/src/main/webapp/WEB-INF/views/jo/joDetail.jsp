<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" 
		href="/spring02/resources/myLib/myStyle.css" >
</head>
<style>
	th {
		background-color: aqua;
	}
</style>
<body>
<h2>** 조 상세정보 **</h2>
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
	<br>
	<c:if test="${!empty requestScope.jmessage } }">
		${requestScope.jmessage }
	</c:if>
	
	<a href="/spring02/home">Home</a><br>
	<a href="javascript:history.back(-1);">이전으로</a><br>
	<a href="joUpdate?jno=${requestScope.apple.jno }">조 정보 수정하기</a><br>
		&nbsp;<a href = "joDelete?jno=${requestScope.apple.jno }">조 삭제하기</a>&nbsp;
</body>
</html>