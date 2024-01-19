<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/web02/rdelete" method="post">
		비밀번호 확인<input type="text" name="checkPw" id="checkPw">
		<input type=submit>
	</form>
	 
	

	<c:if test="${requestScope.dMessage != null }">
		${requestScope.dMessage}
	</c:if>

</body>
</html>