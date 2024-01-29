<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" type="text/css" 
		href="/spring02/resources/myLib/myStyle.css" >
</head>

<body>
<h2>** Hello Spring_MVC02 !!!</h2>
<P> * Home_time : ${serverTime} </P>
<hr>

<!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
<c:if test="${!empty sessionScope.loginName }">
	<b>${sessionScope.loginName} 님 안녕하세요 ~~</b><br>
</c:if>
<c:if test="${empty sessionScope.loginId}">
	<b>로그인 후 이용하세요 ~~</b><br>
	<c:if test="${!empty requestScope.dMessage}">
		<hr>=> ${requestScope.dMessage}<br>
	</c:if>
</c:if>
<!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
<c:if test="${!empty requestScope.message}">
	<hr>=> ${requestScope.message}<br>
</c:if>
<!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
<hr>
	<img alt="mainImage" src="/spring02/resources/images/tulips.png" width="300" height="200">
<hr>


<!-- =========== Login 전 =============== -->
<c:if test="${empty sessionScope.loginId }">
	<!-- &nbsp;<a href = "loginForm">LoginF</a>&nbsp; -->
	&nbsp;<a href = "member/loginForm">LoginF</a>&nbsp;
	<!-- Controller에서 메서드를 void로 정의할때 -->
	&nbsp;<a href = "member/joinForm">JoinF</a>&nbsp;
</c:if>
<!-- ============= Login 후 ============= -->
<c:if test="${!empty sessionScope.loginId }">
	&nbsp;<a href = "member/detail?jCode=D">내정보</a>&nbsp;
	&nbsp;<a href = "member/detail?jCode=U">내정보수정</a>&nbsp;
	&nbsp;<a href = "member/logout">Logout</a>&nbsp;
	&nbsp;<a href = "member/delete">탈퇴</a>&nbsp;
</c:if>
<br><hr>
	&nbsp;<a href = "member/memberList">MList</a>&nbsp;
	<br>
	&nbsp;<a href = "jo/joList">JList</a>&nbsp;
	&nbsp;<a href = "jo/joInsert">조 추가</a>&nbsp;

<br><br>
<c:if test="${!empty requestScope.dMessage }">
	${requestScope.dMessage}
</c:if>
	
	<br><br>
	&nbsp;<a href = "board/boardList">BList</a>&nbsp;
</body>
</html>
