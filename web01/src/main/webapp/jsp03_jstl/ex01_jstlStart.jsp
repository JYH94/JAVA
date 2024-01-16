<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** JSTL START **</title>
</head>
<body>
<h2>** JSTL START **</h2>

<pre><b>
=> Jstl Library 를 정의 (현재문서_Page 가 인식할 수 있도록)
   디렉티브 taglib 에 uri=".." prefix=".."
1. 출력 : out
=> Java의 out객체, 표현식, EL 역할까지
<c:out value="~~ Hello JSTL !!! 안녕 ~~" />
<%-- <c:out value=""></c:out> --%>

2. 변수 정의
=> set태그 : value = 값 / var = 변수명
<c:set value="홍길동" var="name"/>
<c:set value="22" var="age"/>
 
3. 변수 출력 (out_Tag , EL)
=> JSTL 의 out_Tag (+EL)
* name = <c:out value="${name}" />
* age = <c:out value="${age}" />
=> EL 출력
* name = ${name}
* age = ${age}
* age * 100 = ${age*100}

=> Java 는 JSTL 변수와 호환 되는가?  ( X )
<%-- * name = <%=name%> --%>

4. 연산적용
<c:set value="${age + age}" var="add" />
\${add} = ${add}
<c:set value="${name == age}" var="bool" />
\${bool} = ${bool}
<c:set value="${age>add ? age : add }" var="max" />
\${max} = ${max}

5. 변수삭제
=> remove
<c:remove var="add" />
\${empty_ add} = ${empty add}
\${empty_ age} = ${empty age}

=> 정의하지 않은 변수 삭제 : 오류는 발생하지 않는다
<c:remove var="password" />

6. 우선순위
=> JSTL 변수 와 pageScope 의 Attribute 간 우선순위

* Test 1 ) name 정의 순서 : set홍길동(21번줄) -> page_setAttribute(58번줄)
<% // pageScope 에 Attribute 를 정의 후 Test
	pageContext.setAttribute("name", "그린컴");
%>
\${name} = ${name}
=> 일반적인 변수 선언-초기화와 마찬가지로 나중에 정의한 값이 우선된다.


* Test 2 ) set 의 name 을 재정의
<c:set value="new_홍길동" var="name" />
\${name} = ${name}
=> 위와 마찬가지로 나중에 정의한 값이 우선된다.


</b></pre>


</body>
</html>