<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<th>ID</th>
			<th>RegDate</th>
			<th>조회수</th>
		</tr>
		<tr>
			<td>${apple.seq}</td>
			<td>${apple.title}</td>
			<td>${apple.id}</td>
			<td>${apple.regdate}</td>
			<td>${apple.cnt}</td>
		</tr>
	</table>
</body>
</html>