<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="mvcTest.StudentDTO, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> MVC02_List_Java </title>
</head>
<body>

<%
// 컨트롤러에서 Attribute에 request에 담은 list를 꺼내와서 쓰기
	List<StudentDTO> list = (List<StudentDTO>)request.getAttribute("myList");
%>


<table border="1" style="width:100%">
	<tr bgcolor="pink">
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