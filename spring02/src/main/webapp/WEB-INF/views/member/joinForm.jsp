<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Join Form **</title>
<style type="text/css">
	tbody, tr {
		display: flex;
	}
	tr {
		flex-direction: column;
	}
	th,td {
		height: 40px;
		display:flex;
		align-items: center;
	}
	th {
		width: 10vw;
		justify-content: center;
		text-align: center;
	}
	td {
		width: 40vw;
		padding-left: 10px;
	}
	input {
		border: none;
		height: 30px;
		font-size: 18px;
		width: 20vw;
	}
	input:focus {
		outline:none;
	}
	div {
		width: 50vw;
		padding: 10px;
		text-align: center;
	}
	input {
		width: 20vw;
	}
	select {
		width: 10vw;
		height: 30px;
		font-size: 18px;
	}
</style>
</head>
<body>
<h2>** Spring MVC02 Join Form **</h2>
<form action="join" method="post">
<table border=1>
	<tr bgcolor="Aquamarine" style="font-weight: bold;">
		<th>ID</th><th>비밀번호</th><th>비밀번호 확인</th><th>이름</th><th>나이</th><th>조</th>
		<th>Info</th><th>Point</th><th>생일(YYYY-MM-DD)</th><th>추천인</th>
	</tr>
	<tr>
		<td><input type="text" id="id" name="id" placeholder="영문과 숫자로 4~10글자" value=""><button id="idCk" name="idCk" value="false">중복체크</button></td>
		<td><input type="password" id="password" placeholder="특수문자 필수" name="password" value=""></td>
		<td><input type="password" id="passwordCk" placeholder="비밀번호와 동일" name="passwordCk" value=""></td>
		<td><input type="text" id="name" name="name" value=""></td>
		<td><input type="text" id="age" name="age" value=""></td>
		<td><select id="jno" name="jno">
			<option value="0">조를 선택하세요</option>
			<option value="1">1조:Business</option>
			<option value="2">2조:static</option>
			<option value="3">3조:칭찬해조</option>
			<option value="4">4조:카톡으로얘기하조</option>
			<option value="7">7조:칠면조(관리팀)</option>
		</select></td>
		<td><input type="text" id="info" name="info" placeholder="자기소개 & 희망사항" value=""></td>
		<td><input type="text" id="point" name="point" placeholder="실수 입력" value=""></td>
		<td><input type="date" id="birthday" name="birthday" value=""></td>
		<td><input type="text" id="rid" name="rid" value=""></td>
	</tr>
</table>
<div>
	<input type="submit" value="가입">&nbsp;&nbsp;&nbsp;
	<input type="reset" value="취소">
</div>
</form>
<hr>
<c:if test="${not empty requestScope.message}">
=> ${requestScope.message}<br>
</c:if>
<hr>
	&nbsp;<a href="/spring02/home">Home</a>&nbsp;
	&nbsp;<a href="javascript:history.back(-1);">이전으로</a>&nbsp;
</body>
</html>