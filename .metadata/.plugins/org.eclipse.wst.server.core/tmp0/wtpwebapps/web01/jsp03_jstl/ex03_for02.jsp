<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** JSTL forEach begin, end, step Test **</title>
</head>
<body>
<h2>** JSTL forEach begin, end, step Test **</h2>
<pre>
=> 구간반복: StartIndex(begin), LastIndex(end), 증감값(step) 적용하기
=> step 의 default 값은 1
=> 실습 1)
   1 ~ 10 까지를 다음처럼 출력하세요 ~~
   -> 1, 2, 3, .....10         
   -> java의 예 : for (int i=1; i<11; i++) { ......  }   
=> 결과
</pre>
<b>

<c:forEach begin="1" end="10" var="number" step="1" varStatus="vs">
	${number}
	${vs.last ? "" : ", " }
</c:forEach>

<hr><pre>
=> 실습 2)
   1 ~ 10 중에서 짝수만, index, count 출력하기
   단, table 을 이용해서 출력하세요 ~~
   ex03_for01 의 table 과 비교해 보세요 ~~    
=> count : 반복횟수 
=> index : 배열등 index가 존재하는 경우에는 index 값을 출력
           반복자(iterator) 의 값   
           step 을 지정하지 않으면 1씩 증가     
</pre>

** 스텝이 2일 때 **
<table border=1; style="text-align:center; "width:90%;>
<tr>
	<th>숫자</th>
	<th>인덱스</th>
	<th>카운트</th>
</tr>
<c:forEach var="num" step="2" begin="2" end="10" varStatus="Q">
	<tr>
		<td>${num}</td>
		<td>${Q.index}</td>
		<td>${Q.count}</td>
	</tr>
</c:forEach>
</table> 

<br>
<br>

** 스텝이 1일 때 **
<table border=1 style="text-align:center; "width:90%;>
<tr>
	<th>숫자</th>
	<th>인덱스</th>
	<th>카운트</th>
</tr>
<c:forEach var="num" begin="1" end="10" varStatus="Q">
	<tr>
		<c:if test="${num%2 == 0}">
			<td>${num}</td>
			<td>${Q.index}</td>
			<td>${Q.count}</td>
		</c:if>
		
		<c:if test="${num%2 != 0}"></c:if>
		
	</tr>
</c:forEach>
<!-- 
위 반복문을 돌리면 숫자가 2,4,6,8,10 이 찍히고
인덱스도 2,4,6,8,10이 찍히는 모습을 볼 수 있다.
그 이유는 시작점이 1 / 종료점이 10일 뿐이지 배열이 아니기 때문이다.
forEach반복문이 1부터 돌면서 조건문을 통해 건너뛰기 때문에
인덱스가 1,2,3,4,5가 아닌 2,4,6,8,10이 찍힌다.
 -->
</table>

=> 실습 3) 1~30 을 다음처럼 1행에 5개씩 출력하세요~<br>
<!-- 
1,2,3,4,5
6,7,8,9,10
11,12,13,14,15
...
............30 -->
<br>

** 중첩 FOR문 **<br>
<c:forEach var="num1" begin="0" end="5" varStatus="vs1">
	<c:forEach var="num2" begin="${5*num1 + 1}" end="${5*num1 + 5}" varStatus="vs2">
		<%-- <c:if test="${vs2.last == false}">
			${num2},
		</c:if>
		<c:if test="${vs2.last}">
			${num2}<br>
		</c:if>
		 --%>
		 <!-- 삼항연산자 사용하는 방법 -->
		${num2}
		${vs2.last ? "<br>" : ", "}
	</c:forEach>
</c:forEach>


<br>

** FOR문 + 조건문 **<br>
<c:forEach var="i" begin="1" end="30" step="1" varStatus="vs">
<%-- 	<c:choose>
		<c:when test="${i %5 != 0}">
			${i},
		</c:when>
		
		<c:when test="${i %5 == 0}">
			${i}
			<br>
		</c:when>
	</c:choose>
	 --%>
	 <!-- 삼항연산자 사용 -->
	${i}
	${i%5 == 0 ? "<br>" : ", " }
	
</c:forEach>






</b>
</body>
</html>