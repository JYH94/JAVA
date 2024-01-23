<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** LoginForm **</title>
</head>
<body>
	<form action="/web02/login" method="post">
		아이디 <input type="text" name="id" id="id"/><br>
		비밀번호 <input type="password" name="password" id="password"/><br>
		<input type="submit">
		<input type="reset" value="취소"/>
	</form>
	
	
	<a href="/web02/home.jsp">홈으로</a>
	
	<br>
	
	<c:if test="${requestScope.loginId == null }">
		${requestScope.message}
	</c:if>
	<c:if test="${sessionScope.jMessage != null }">
		${sessionScope.jMessage}
	</c:if>
	<!-- 이렇게하면 파라미터에 아이디 비밀번호가 뜨고
	getParameter 해서 그걸 session에 저장시키고
	해당 정보를 가지고 판단해서 로그인상태를 확인한다 -->
</body>
</html>