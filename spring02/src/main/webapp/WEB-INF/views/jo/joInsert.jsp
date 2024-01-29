<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" 
		href="/spring02/resources/myLib/myStyle.css" >
</head>
<body>

<h2>** 조 추가하기 **</h2>
<form action="joInsert" method="post">
	<label for="jno">조번호
		<input type=text name="jno" id="jno">
	</label>
	<br>
	<label for="jname">조이름
		<input type=text name="jname" id="jname">
	</label>
	<br>
	<label for="captain">조장
		<input type=text name="captain" id="captain">
	</label>
	<br>
	<label for="project">프로젝트명
		<input type=text name="project" id="project">
	</label>
	<br>
	<label for="slogan">목표
		<input type=text name="slogan" id="slogan">
	</label>
	<br>
	<button>추가</button>
	<br><br>
	<hr>
		<c:if test="${!empty requestScope.jmessage }">
			${requestScope.jmessage }
		</c:if>
	<hr>
	
	<a href="/spring02/home">Home</a>
	<a href="javascript:history.back(-1);">이전으로</a>
</form>
</body>
</html>