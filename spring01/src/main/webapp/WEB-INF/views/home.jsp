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
	
	<c:if test="${requestScope.nMessage != null}">
		<hr><h4>${requestScope.nMessage}</h4>
	</c:if>
	
	<hr>
	<img alt="" src="resources/images/a1.png" width="400" height="300">
	<hr>

	<hr>
	
	
	&nbsp;<a href = "mlist">MList</a>&nbsp;
	&nbsp;<a href = "mdetail">MDetail</a>&nbsp;
	<br>
	&nbsp;<a href = "mlistsp">MListSp</a>&nbsp;
	&nbsp;<a href = "mdetailsp">MDetailSp</a>&nbsp;
</body>
</html>
