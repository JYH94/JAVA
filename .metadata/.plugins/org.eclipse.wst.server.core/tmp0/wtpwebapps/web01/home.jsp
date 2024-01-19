<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** home **</title>
</head>
<body>
<h2> Dynamic Web Project </h2>
<%
// Jsp 가 간편한 이유는 웹에서 필요한 기본 객체
// request, response, session, page, out 들을 객체화해서 제공해줌
	if(session.getAttribute("loginName") != null){ %>
		<h3><%=session.getAttribute("loginName")%>님 안녕하세요</h3>
<%	} else{ %>
		<h3> 로그인 후 이용하세요 </h3>
<%	}
%>
<hr>
	<form action="getpost" method="get">
		<input type="text" name="id" value="banana" size="10"> &nbsp; <input type="text" name="name" value="바나나" size="10"> &nbsp; <input type="text" value="password" size="10"> <input type="submit" value="Test">
	</form>
	<hr>
<!-- 경로 표기
	절대경로 : / 로 시작, 프로젝트명부터 시작
		/web01/images/letsgo.png
	상대경로 : 현재위치에서 시작
		./ 현재위치, ../ 상위 폴더로
		./images/lestgo.p
-->
	<img alt="" src="images/letsgo.png" width="300" height="200">
	<hr>

	<a href="/web01/servletTestForm/flowEx04_LoginForm.jsp">Login</a>&nbsp;
	<a href="/web01/logout">Logout</a><br>&nbsp;
	<a href="/web01/hello">HelloS</a>&nbsp; &nbsp;
	<a href="/web01/list">MVC01ListS</a>&nbsp; &nbsp;
	<a href="/web01/life">LifeCycle</a>
	<br> &nbsp;
	<a href="/web01/servletTestForm/form01_Adder.html">Adder</a>&nbsp; &nbsp;
	<a href="/web01/servletTestForm/form02_Radio.jsp">Radio</a>&nbsp; &nbsp;
	<a href="/web01/servletTestForm/form03_Check.jsp">Check</a>&nbsp; &nbsp;
	<a href="/web01/servletTestForm/form04_Select.jsp">Select</a>&nbsp; &nbsp;
	<a href="/web01/flow01">Flow01</a>&nbsp;
	<a href="/web01/sessioni">SessionI</a><br>
	<a href="/web01/jsp01/ex01_HelloJsp.jsp">HelloJ</a>
	<a href="/web01/jsp01/ex02_mvc01List.jsp">M01ListJ</a>
	<a href="/web01/list2">M02List</a>
</body>
</html>