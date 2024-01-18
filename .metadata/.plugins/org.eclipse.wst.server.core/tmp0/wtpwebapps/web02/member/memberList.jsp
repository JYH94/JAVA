<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Web02_MVC02 MemberList **</title>
</head>
<body>
<h2>** Web02_MVC02 MemberList **</h2>

<hr>
<c:if test="${!empty requestScope.message}">
	=> ${requestScope.message}<br>
	<hr>
</c:if>

<table>
	<tr>
		<td>id</td>
		<td>password</td>
		<td>name</td>
		<td>age</td>
		<td>jno</td>
		<td>info</td>
		<td>point</td>
		<td>birthday</td>
		<td>rid</td>
	</tr>
	
	<c:if test="${!empty requestScope.banana}">
		<c:forEach var="list"  items="${requestScope.banana}">
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
	</c:if>
	<c:if test="${empty requestScope.banana}">
		<tr>
			<td colspan="9">~~ 출력 자료가 1건도 없다.</td>
		</tr>
	</c:if>
</table>
<hr>

&nbsp; <a href="/web02/home.jsp">Home</a>&nbsp; 
&nbsp; <a href="/web02/member/memberList.jsp">이전으로</a>&nbsp; 


<% request.getAttribute("banana"); %>
	
	
	
</body>
</html>