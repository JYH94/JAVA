// servlet
package servlet01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// url 매핑 네임
// 요청과 코드의 일치 여부를 판단하는 요청명, 매핑네임
@WebServlet(urlPatterns = { "/hello", "/안녕", "/123", "/7seven", "/seven7" })
// 상속받음
public class Ex01_HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 생성자
	public Ex01_HelloServlet() {
		super();
	}

	// get 방식으로 요청이 들어왔을 때 자동반응해 실행, Event Driven 실행 방식
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter으로 결과를 출력물을 담는 것
//		response.getWriter().append("Served at: ").append(request.getContextPath()).append("여기는 doGet 메서드 입니다.");

		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("<h2 style ='color:blue;'> ** Hello Servlet **</h2>");
		out.print("<h3> => ContextPath : " + request.getContextPath() + "</h3>");
		out.print("<h3> => 여기는 doGet 메서드 입니다.</h3>");
		out.print("</body></html>");
	}

	// post 방식으로 요청이 들어왔을 때 자동반응해 실행
	// throws로 예외처리를 위임
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath()).append("여기는 doPost 메서드 입니다.");

		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("<h2 style ='color:blue;'> ** Hello Servlet **</h2>");
		out.print("<h3> => ContextPath : " + request.getContextPath() + "</h3>");
		out.print("<h3> => 여기는 doPost 메서드 입니다.</h3>");
		out.print("</body></html>");
	}

} // class