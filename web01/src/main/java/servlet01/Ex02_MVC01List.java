package servlet01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvcTest.StudentDTO;
import mvcTest.StudentService;

@WebServlet("/list")
public class Ex02_MVC01List extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ex02_MVC01List() {
		super();
	}

	// MVC 패턴1 StudnetList 출력하기
	// 요청을 Service에서 처리
	// 결과 출력
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Controller
		// 요청을 Service 처리
		StudentService service = new StudentService();
//		List<StudentDTO> list = service.selectList();
		service.selectList();

		// view
		// 출력 내용을 Response 객체의 Body 영역에 Write
		// 한글 처리
		response.setContentType("text/html; charset=UTF-8");
		// 출력 객체 생성 및 출력
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("<h2 style ='color:blue;'> ** Servlet_MVC1 StudentList **</h2>");
		out.print("<table border = 1><tr><th>Sno</th><th>Name</th><th>Age</th>");
		out.print("<th>Jno</th><th>Info</th><th>Point</th></tr>");

		if (service.selectList() != null) {
//			for (StudentDTO l : list) {
			for (StudentDTO l : service.selectList()) {
//				out.printf(l + "<br>");

				out.print("<tr><td>" + l.getSno() + "</td>");
				out.print("<td>" + l.getName() + "</td>");
				out.print("<td>" + l.getAge() + "</td>");
				out.print("<td>" + l.getJno() + "</td>");
				out.print("<td>" + l.getInfo() + "</td>");
				out.print("<td>" + l.getPoint() + "</td></tr>");
			}

		} else {
			out.print("<h2> 출력할 DATA가 없습니다. </h2>");
		}
		out.print("</table></body></html>");
	} // doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

} // class
