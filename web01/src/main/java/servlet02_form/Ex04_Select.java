package servlet02_form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/select")
public class Ex04_Select extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ex04_Select() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1 요청 분석
		// request 처리 : 한글, Parameter
		request.setCharacterEncoding("UTF-8");
		String job = request.getParameter("job");
		String[] interest = request.getParameterValues("interest");

		// 2 Service, 결과 처리
		// response 한글처리, 출력객체 생성
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		// 선택여부를 확인하고 출력
		// 선택하지 않아도 Parameter job은 존재, 그러나 value는 ㅇ벗음
		if (job != null && job.length() > 0) {
			out.print("<h3>" + job + "</h3>");
		} else {
			out.print("<h3> 직업을 선택해주세요 </h3>");
		}

		// 아무것도 선택하지 않으면 Parameter가 없음(null return)
		// ( != null만 비교해도 가능하지만, 길이도 확인)
		if (interest != null && interest.length > 0) {
			for (String i : interest) {
				out.print("<h3>" + i + "&nbsp;<h3>");
			}
		} else {
			out.print("<h3> 관심분야를 선택해주세요 </h3>");
		}
		out.print("<br><br><h2><a href='javascript:history.go(-1)'>다시 입력하기</a></h2><br>");

	} // doGet

} // class
