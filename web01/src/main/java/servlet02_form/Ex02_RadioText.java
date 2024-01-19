package servlet02_form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/radio")
public class Ex02_RadioText extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ex02_RadioText() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1 요청 분석
		// request 처리 : 한글, Parameter
		request.setCharacterEncoding("UTF-8");
		String gender = request.getParameter("gender");
		String mailcheck = request.getParameter("mailcheck");
		String content = request.getParameter("content");

		if (mailcheck.equals("Yes"))
			mailcheck = "수신동의";
		else
			mailcheck = "수신거절";

		// 2 Service, 결과 처리
		// response 한글처리, 출력객체 생성
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<h2> 성별 : " + gender + "<br>");
		out.print("<h2> 메일 : " + mailcheck + "<br>");
		out.print("<h2> 인사 : " + content + "<br>");
		out.print("<br><br><h2><a href='javascript:history.go(-1)'>다시 입력하기</a></h2><br>");
	} // doGet

} // class
