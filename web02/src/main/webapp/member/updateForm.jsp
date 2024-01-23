<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Update Form **</title>
</head>
<body>

	<h3>** Update Form **</h3>
<form action="/web02/mupdate" method="post">
	<div>
		아이디
		<input type="text" id="id" name="id" value="${requestScope.apple.id}" readonly/>
		<!-- <input type="submit" value="중복검사"/><br> -->
	</div>
	<div>
		비밀번호
		<input type="password" id="password" name="password" value="${requestScope.apple.password}" required/>
	</div>
	<div>
		이름
		<input type="text" id="name" name="name" value="${requestScope.apple.name }"/>
	</div>
	<div>
		나이
		<input type="number" id="age" name="age" value="${requestScope.apple.age }"/>
	</div>
	<div>
		조번호
		<select name="jno" >
			<option value="1" ${requestScope.apple.jno == 1 ? "selected" : ""}>1조 : Business</option>
			<option value="2" ${requestScope.apple.jno == 2 ? "selected" : ""}>2조 : static</option>
			<option value="3" ${requestScope.apple.jno == 3 ? "selected" : ""}>3조 : 칭찬해조</option>
			<option value="4" ${requestScope.apple.jno == 4 ? "selected" : ""}>4조 : 카톡으로얘기하조</option>
			<option value="7" ${requestScope.apple.jno == 7 ? "selected" : ""}>7조 : 칠면조</option>
		</select>
	</div>
	<div>
		소개
		<input type="text" id="info" name="info" placeholder="자기소개" value="${requestScope.apple.info }"/>
	</div>
	<div>
		포인트
		<input type="text" id="point" name="point" placeholder="실수 입력" value="${requestScope.apple.point }" />
	</div>
	<div>
		생년월일
		<input type="date" id="birthday" name="birthday" value="${requestScope.apple.birthday }" />
	</div>
	<div>
		추천인 아이디
		<input type="text" id="rid" name="rid" value="${requestScope.apple.rid }"/>
	</div>
	<input type="submit" value="제출">
</form>

<c:if test="${requestScope.message != null }">
	${requestScope.message}
</c:if>



</body>
</html>