package servlet02_form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/check")
public class Ex03_Check extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ex03_Check() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1 요청 분석
		// request 처리 : 한글, Parameter
		request.setCharacterEncoding("UTF-8");

		// form 이 전달할 수 있는 데이터는 단일값, 복수값 2가지
		// 쿼리스트링으로 전달되는 Parameter를
		// 배열의 형태로 Parameter의 value 값을 저장
		String[] gift = request.getParameterValues("gift");

		// 2 Service, 결과 처리
		// response 한글처리, 출력객체 생성
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		// 선택여부 확인
		if (gift != null && gift.length > 0) {
			for (String s : gift) {
				out.printf("<h3>%s</h3>", s);
			}
		} else {
			out.print("<h3> 선택이 필요합니다 </h3>");
		}
		out.print("<br><br><h2><a href='javascript:history.go(-1)'>다시 입력하기</a></h2><br>");

	} // doGet

} // class
