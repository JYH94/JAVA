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

	<table border="1" style="width: 100%">
		<tr bgcolor="DeepSkyBlue" style="font-weight: bold;">
			<th>Seq</th>
			<th>Title</th>
			<th>내용</th>
			<th>ID</th>
			<th>RegDate</th>
			<th>조회수</th>
		</tr>
		<tr>
			<td>${sessionScope.apple.seq}</td>
			<td>${sessionScope.apple.title}</td>
			<td>${sessionScope.apple.content}</td>
			<td>${sessionScope.apple.id}</td>
			<td>${sessionScope.apple.regdate}</td>
			<td>${sessionScope.apple.cnt}</td>
		</tr>
	</table>
	<c:if test="${sessionScope.loginId == apple.id}">
		<a href="boardUpdate?seq=${apple.seq}">글 수정하기</a>&nbsp;
	</c:if>
	&nbsp;<a href="javascript:history.back();">이전으로</a>&nbsp;
</body>
</html>