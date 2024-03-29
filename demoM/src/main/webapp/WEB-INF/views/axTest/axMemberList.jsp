<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Web02_MVC02 MemberList **</title>
</head>
<body>
<h2>** Web02_MVC02 MemberList **</h2>
<hr>
<c:if test="${!empty requestScope.message}">
=> ${requestScope.message}<br><hr>
</c:if>
<div id="mBox"></div>
<table border="1" sytle="width:100%">
<tr bgcolor="hotpink">
	<th>ID</th><!-- <th>Password</th> --><th>Name</th><th>Age</th><th>Jno</th>
	<th>Info</th><th>Point</th><th>Birthday</th><th>추천인</th><th>Image</th><th>Delete</th>				
</tr>
<c:if test="${!empty requestScope.apple}">
	<c:forEach var="v" items="${requestScope.apple}">
		<tr>
			<td>
				<%-- <span class="textlink" onclick=idbList('${v.id}')>${v.id}</span> --%>
				<a href="#resultArea2" onclick=idbList('${v.id}')>${v.id}</a>
				<!-- a 태그의 이벤트 적용시 책갈피 기능 활용 
						-> href = "javascript:;" : 이동하지 않음
				-->
			</td>
			<td>${v.name}</td><td align="center">${v.age}</td>
			<td align="center" onmouseleave="hideJoDetail()" onmouseover="showJoDetail(event,'${v.jno}')">${v.jno}</td>
			<td>${v.info}</td><td>${v.point}</td><td>${v.birthday}</td><td>${v.rid}</td>
			<td><img onmouseover="zoomIn(event)" alt="myImage" src="/resources/images/${v.uploadfile}" width="50" height="50"></td>
			   <!--  ** Delete 기능 추가 
            => 선택된 id를 function 에 전달 (매개변수를 활용)
            => 결과는 성공/실패 여부만 전달: RESTController 로 
            => 성공 : Deleted 로 변경, onclick 이벤트 해제 
                     이를 위해 Delete Tag 를 function 에서 인식할수있어야함. 
                     
            ** function 에 이벤트객체 전달
            => 이벤트핸들러의 첫번째 매개변수에 event 라는 이름으로 전달함.
             => a Tag 와 span 사용시 e.target 값 비교
                -> a Tag : "javascript:;" 
                -> span  : [object HTMLSpanElement]          
         -->
			<td><span class="textlink" onclick="axiDelete('${v.id}',this)">삭제</span><td>
		</tr>
	</c:forEach>
</c:if>
<c:if test="${empty requestScope.apple}">
	<tr>
	<td colspan="10">~~ 출력 자료가 1건도 없습니다 .~~</td>
	</tr>
</c:if>
<c:if test="${!empty requestScope.message}">
=> ${requestScope.message}
</c:if>
<hr>
</table>
<hr>
&nbsp;<a href="/home">HOME</a>&nbsp;
&nbsp;<a href="javascript:history.go(-1)">이전으로</a>&nbsp;


</body>
</html>