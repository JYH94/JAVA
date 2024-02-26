<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
=> ${requestScope.message}<br><hr>
</c:if>
<div id="mBox"></div>
<table border="1" sytle="width:100%">
<tr bgcolor="hotpink">
	<th>ID</th><!-- <th>Password</th> --><th>Name</th><th>Age</th><th>Jno</th>
	<th>Info</th><th>Point</th><th>Birthday</th><th>추천인</th><th>Image</th><th>Delete</th>				
</tr>
<c:if test="${!empty requestScope.apple}">
	<c:forEach var="v" items="${requestScope.apple}">
		<tr><td><span class="textlink" onclick=idbList('${v.id}')>${v.id}</span></td><%-- <td>${v.password}</td> --%><td>${v.name}</td><td>${v.age}</td><td onmouseleave="mouseLeave()" onmouseover="mouseOver(event,'${v.jno}')">${v.jno}</td>
			<td>${v.info}</td><td>${v.point}</td><td>${v.birthday}</td><td>${v.rid}</td>
			<td><img alt="myImage" src="/resources/images/${v.uploadfile}" width="50" height="50"></td>
			<td><span class="textlink" onclick="axiDelete('${v.id}',this)">삭제</span><td>
		</tr>
	</c:forEach>
</c:if>
<c:if test="${empty requestScope.apple}">
	<tr>
	<td colspan="10">~~ 출력 자료가 1건도 없습니다 .~~</td>
	</tr>
</c:if>
<c:if test="${!empty requestScope.message}">
=> ${requestScope.message}
</c:if>
<hr>
</table>
<hr>
&nbsp;<a href="/home">HOME</a>&nbsp;
&nbsp;<a href="javascript:history.go(-1)">이전으로</a>&nbsp;


</body>
</html>