<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** UpdateForm **</title>
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
		width: 37vw;
	}
	input:focus {
		outline:none;
	}
	div {
		width: 50vw;
		padding: 10px;
		text-align: center;
	}
	div>input {
		width: 20vw;
	}
	select {
		width: 15vw;
		height: 30px;
		font-size: 18px;
	}
</style>
</head>
<body>
<h2>** UpdateForm **</h2>
<c:set value="${requestScope.dto}" var="dto"></c:set>
<form action="/web02/mupdate" method="post">
	<table border=1>
		<tr bgcolor="MediumOrchid" style="font-weight: bold;">
			<th>ID</th><th>Password</th><th>Name</th><th>Age</th><th>Jno</th>
			<th>Info</th><th>Point</th><th>Birthday</th><th>추천인</th>
		</tr>
		<c:choose>
			<c:when test="${!empty dto}">
				<tr>
					<td><input readonly id="id" name="id" value="${dto.id}"></td>
					<td><input type="password" id="password" name="password" value="${dto.password}"></td>
					<td><input id="name" name="name" value="${dto.name}"></td>
					<td><input id="age" name="age" value="${dto.age}"></td>
					<td><select id="jno" name="jno">
						<option value="1" ${dto.jno == 1 ? "selected":""}>1조:Business</option>
						<option value="2" ${dto.jno == 2 ? "selected":""}>2조:static</option>
						<option value="3" ${dto.jno == 3 ? "selected":""}>3조:칭찬해조</option>
						<option value="4" ${dto.jno == 4 ? "selected":""}>4조:카톡으로얘기하조</option>
						<option value="7" ${dto.jno == 7 ? "selected":""}>7조:칠면조(관리팀)</option>
					</select></td>
					<td><input id="info" name="info" value="${dto.info}"></td>
					<td><input id="point" name="point" value="${dto.point}"></td>
					<td><input id="birthday" name="birthday" value="${dto.birthday}"></td>
					<td><input id="rid" name="rid" value="${dto.rid}"></td>
				</tr>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="9" style="text-align: center;">MyInfo 결과가 1건도 없음
					</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
	<div>
		<input type="submit" value="수정">&nbsp;&nbsp;&nbsp;
		<input type="reset" value="취소">
	</div>
</form>
<hr>
<c:if test="${not empty requestScope.message}">
=> ${requestScope.message}<br>
</c:if>
<hr>
	&nbsp;<a href="/web02/home.jsp">Home</a>&nbsp;
	&nbsp;<a href="javascript:history.back();">이전으로</a>&nbsp;
<hr>
</body>
</html>