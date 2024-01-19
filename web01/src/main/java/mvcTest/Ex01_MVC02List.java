package mvcTest;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list2")
public class Ex01_MVC02List extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ex01_MVC02List() {
		super();
	}

	// MVC 패턴2 StudnetList 출력하기
	// 요청을 Service에서 처리
	// 결과 출력 (Java 스크립트)
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Controller
		// 요청을 Service 처리
		StudentService service = new StudentService();
		List<StudentDTO> list = service.selectList();

		// view
		// 결과 출력을 Jsp, Java 스크립트
		// service 결과물 List를 Jsp가 출력할 수 있도록 Attribute를 만들어 보관
		// request.setAttribute
		request.setAttribute("myList", list);
		// Forward로 전달
		request.getRequestDispatcher("mvcTestJsp/ex01_MVC02List.jsp").forward(request, response);
	} // doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

} // class
