<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** JoinForm **</title>
</head>
<body>

	<h3>회원가입</h3>
<form action="/web02/mJoin" method="post">
	<div>
		아이디
		<input type="text" id="id" name="id" placeholder="4~10글자" required/>
		<!-- <input type="submit" value="중복검사"/><br> -->
	</div>
	<div>
		비밀번호
		<input type="password" id="password" name="password" placeholder="특수문자사용" required/>
	</div>
	<div>
		이름
		<input type="text" id="name" name="name" />
	</div>
	<div>
		나이
		<input type="number" id="age" name="age" />
	</div>
	<div>
		조번호
		<select name="jno">
			<option value="1">1조 : Business</option>
			<option value="2">2조 : static</option>
			<option value="3" >3조 : 칭찬해조</option>
			<option value="4" >4조 : 카톡으로얘기하조</option>
			<option value="7" >7조 : 칠면조</option>
		</select>
	</div>
	<div>
		소개
		<input type="text" id="info" name="info" placeholder="자기소개"/>
	</div>
	<div>
		포인트
		<input type="text" id="point" name="point" placeholder="실수 입력" />
	</div>
	<div>
		생년월일
		<input type="date" id="birthday" name="birthday" />
	</div>
	<div>
		추천인 아이디
		<input type="text" id="rid" name="rid" />
	</div>
	<input type="submit" value="제출">
</form>

<c:if test="${sessionScope.message != null }">
	${sessionScope.message}
</c:if>



</body>
</html>