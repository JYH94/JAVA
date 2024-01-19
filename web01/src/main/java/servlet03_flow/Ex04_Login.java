package servlet03_flow;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvcTest.StudentDTO;
import mvcTest.StudentService;

@WebServlet("/login")
public class Ex04_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ex04_Login() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1 요청분석
		// 한글, request의 Parameter 처리
		request.setCharacterEncoding("UTF-8");
		int sno = 0;
		if (request.getParameter("sno") != null && request.getParameter("sno").length() > 0) {
			sno = Integer.parseInt(request.getParameter("sno"));
		}
		// 값이 일치하는지 확인하기위해 보관
		// Login할 때 DAO에서 where sno =? and name = ? 을 하지 않는 이유는
		// password 암호화 때문에 직접비교 불가능 하기때문에 비권장
		String name = request.getParameter("name");
		String uri = "home.jsp";

		// 2 Service
		// -> StudentService, StudentDTO 인스턴스 필요
		// -> Service의 selectOne을 이용, sno 확인
		// sno의 성공이면 name 확인
		// -> 성공 : home.jsp
		// -> 실패 : ~~LoginForm.jsp 재로그인 유도
		StudentService service = new StudentService();
		StudentDTO dto = service.selectOne(sno);
		if (dto != null && dto.getName().equals(name)) {
			request.getSession().setAttribute("loginName", name);
			request.getSession().setAttribute("loginID", sno);
			System.out.println(" 로그인 성공 ");
			System.out.println(" 로그인 Student => " + dto);
			response.sendRedirect(uri);
		} else {
			System.out.println(" 로그인 실패 ");
			request.setAttribute("message", " 로그인에 실패하셨습니다 ");
			uri = "servletTestForm/flowEx04_LoginForm.jsp";
			// foward로 하면 url에 쿼리스트링이 남아 새로고침을 할 때 콘솔창에 로그인 성공이 뜬다
			// delete로 했으면 이미 삭제된 데이터를 삭제하려고해 에러 발생
			request.getRequestDispatcher(uri).forward(request, response);
		}

		// 3 View(Response) : Redirect
//		request.getRequestDispatcher(uri).forward(request, response);

	} // doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	} // doPost

} // class