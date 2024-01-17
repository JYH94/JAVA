<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** MyInfo **</title>
</head>
<body>
<h3>** MyInfo **</h3>
	<table border=1; style="text-align:center">
	<tr>
		<th>SNO</th>
		<th>NAME</th>
		<th>AGE</th>
		<th>JNO</th>
		<th>INFO</th>
		<th>POINT</th>
	</tr>
	
	<c:set value="${requestScope.myInfo}" var="s" ></c:set>
	<tr>		
		<td>${s.sno }</td>
		<td>${requestScope.myInfo.name }</td>
		<td>${requestScope.myInfo.age }</td>
		<td>${requestScope.myInfo.jno }</td>
		<td>${requestScope.myInfo.info }</td>
		<td>${requestScope.myInfo.point }</td>
	</tr>
	
	</table>
</body>
</html>