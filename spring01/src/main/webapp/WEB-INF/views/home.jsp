<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>** Hello Spring !!!</h1>

<P>  The time on the server is ${serverTime}. </P>
<hr>
<c:set value="${sessionScope.sname}" var="sname"/>
	<c:choose>
		<c:when test="${!empty sessionScope.sname}">
			<h3>${sessionScope.sname}님 안녕하세요.</h3>
		</c:when>
		<c:otherwise>
			<h3>로그인을 해주세요.</h3>
		</c:otherwise>
	</c:choose>
	
	<c:if test="${requestScope.nMessage != null}">
		<hr><h4>${requestScope.nMessage}</h4>
	</c:if>
	
	<hr>
	<img alt="" src="resources/images/a1.png" width="400" height="300">
	<hr>
	<c:choose>
		<c:when test="${!empty sname}">
			&nbsp;<a href = "/web02/mdetail">MyInfo</a>&nbsp;
			&nbsp;<a href = "/web02/mdetail?jCode=U">내정보수정</a>&nbsp;
			&nbsp;<a href = "/web02/logout">logout</a>&nbsp;
			&nbsp;<a href = "/web02/member/deleteForm.jsp">회원탈퇴</a>&nbsp;
		</c:when>
		<c:otherwise>
			&nbsp;<a href = "/web02/member/loginForm.jsp">Login</a>&nbsp;
			&nbsp;<a href = "/web02/member/joinForm.jsp">Join</a>&nbsp;
		</c:otherwise>
	</c:choose>
	<hr>
	
	
	&nbsp;<a href = "mlist">MList</a>&nbsp;
	&nbsp;<a href = "mdetail">MDetail</a>&nbsp;
	<br>
	&nbsp;<a href = "mlistsp">MListSp</a>&nbsp;
	&nbsp;<a href = "mdetailsp">MDetailSp</a>&nbsp;
</body>
</html>
