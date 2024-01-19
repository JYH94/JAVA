package servlet03_flow;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/01set")
public class Ex02_01setAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ex02_01setAttribute() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1 request 처리
		// -> form없이 queryString
		// ~~/01set?id=banana&name=홍길동&age=22
		// -> 한글처리(Post 요청시 필수)
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		// get 처리오류 때문 불편
//		int age = Integer.parseInt(request.getParameter("age"));
		String age = request.getParameter("age");

		// 데이터가 전달됐는지 확인
		System.out.println(" setAttribute Test ");
		System.out.printf(" Parameter id = %s, name = %s, age = %s\n", id, name, age);

		// 2 setAttribute 처리
		// -> 보관 가능한 객체 Scope : Page, Request, Session, Application
		// setAttribute(변수명, value)

		// 2-1 request 에 보관
		request.setAttribute("rid", id);
		request.setAttribute("rname", name);
		request.setAttribute("rage", age);

		// 2-2 session 에 보관
		// HttpSession : 인스턴스 Http 세션 생성
		// request 로 인스턴스 세션 받아오기
		HttpSession session = request.getSession();
		session.setAttribute("sid", id);
		session.setAttribute("sname", name);
		session.setAttribute("sage", age);

		// 3 flow 후 getAttribute
		// 3-1 Forward
		String uri = "02get";
		request.getRequestDispatcher(uri).forward(request, response);

		// 3-2 Redirect
//		response.sendRedirect(uri);

	} // doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

} // class
