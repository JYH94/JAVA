package servlet02_form;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex05_RequestInfo")
public class Ex05_RequestInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ex05_RequestInfo() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 화면 출력
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<h2> Request Information </h2");
		out.print("<h3> 주요 메서드 </h3>");

		out.print("<h3> 1) Request Header Names & Values</h3>");
		out.print("<h3> 2) ContextPath: 웹애플리케이션의 최상위 경로 </h3>");
		out.print("<h3> 3) RealPath: 웹애플리케이션의 실행위치</h3>");
		out.print("<h3> 4) 기타등등 </h3>");
		out.print("<h3> => Console 창에서 확인하세요 ~~~</h3>");
		out.print("<br><br><h2><a href='javascript:history.go(-1)'>다시 입력하기</a></h2><br>");

		// console 출력
		System.out.println(" 1 Request Header Names & Values ");

		// Enumeration : 반복문을 처리할 수 있게 해주는 자료 형식의 객체
		// Iterator 반복자와 동일
		// Enum 은 상수를 클래스로 만들어 편하게 사용할 수 있게 해주는 것
		Enumeration<String> hNames = request.getHeaderNames();
		// isNext = hasMoreElements
		while (hNames.hasMoreElements()) {
			String hName = hNames.nextElement();
			System.out.printf("%s = %s\n", hName, request.getHeader(hName));
			// 요청한 화면에 대한 정보 accept 에 담겨있다
		} // while

		// 주소 8080을 찾아가 어플리케이션을 실행시키는 최상위 경로
		System.out.println("** 2) ContextPath => " + request.getContextPath());
		// 더이상 지원하지 않아 검은색 - 표시됨, 사용은 가능
		System.out.println("** 3) RealPath => " + request.getRealPath("/"));
		System.out.println("** 4) 기타등등 **");
		System.out.println("=> RemoteAddress: " + request.getRemoteAddr());
		System.out.println("=> Method: " + request.getMethod());
		System.out.println("=> RequestURL: " + request.getRequestURL());
		System.out.println("=> RequestURI: " + request.getRequestURI());
		System.out.println("=> ServerName: " + request.getServerName());
		System.out.println("=> ServerPort: " + request.getServerPort());
		System.out.println("=> ServletPath: " + request.getServletPath());
	} // doGet

} // class
