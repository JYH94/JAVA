<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" 
		href="/spring02/resources/myLib/myStyle.css" >
</head>
<body>
<h2>** 조 수정하기 **</h2>
<form action="joUpdate" method="post">
<label for="jno">
	조번호<input type=text name="jno" id="jno" value="${requestScope.apple.jno}" readonly placeholder="조">
</label>
<br>
<label for="jname">
	조이름<input type=text name="jname" id="jname" value="${requestScope.apple.jname}">
</label>
<br>
<label for="captain">
	조장<input type=text name="captain" id="captain" value="${requestScope.apple.captain}">
</label>
<br>
<label for="project">
	프로젝트<input type=text name="project" id="project" value="${requestScope.apple.project}">
</label>
<br>
<label for="slogan">
	목표<input type=text name="slogan" id="slogan"  value="${requestScope.apple.slogan}">
</label>
<br>
<input type=submit value="수정">
<input type=reset value="리셋">
</form>
<br>
<a href="/spring02/home">Home</a>
<a href="javascript:history.back(-1);">이전으로</a>
</body>
</html>