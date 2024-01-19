<!-- page directive에 import 설정 가능 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="mvcTest.StudentService, mvcTest.StudentDTO" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Jsp StudentList_MVC01 </title>
</head>
<body>
<h2> Jsp StudentList_MVC01 </h2>
<h3>=> Service 처리 -> 결과 -> 출력 </h3>
<%
StudentService service = new StudentService();
List<StudentDTO> list = service.selectList();
%>
<table border="1" style="width:100%">
	<tr bgcolor="Lime">
		<th>Sno</th><th>Name</th><th>Age</th><th>Jno</th><th>Info</th><th>Point</th>
	</tr>
	<% // List 출력 구문
	if (list != null) {
		for (StudentDTO l : list) { %>
			<tr>
				<td><%= l.getSno() %></td><td><%= l.getName() %></td><td><%= l.getAge() %></td>
				<td><%= l.getJno() %></td><td><%= l.getInfo() %></td><td><%= l.getPoint() %></td>
			</tr>
<%		}
	} else { %>
		<h3> 출력할 자료가 없습니다. </h3>
<%	}
	%>

</table>
</body>
</html>