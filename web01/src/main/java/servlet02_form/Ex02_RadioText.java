package servlet02_form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex01_Adder
 */
@WebServlet("/radio")
public class Ex02_RadioText extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ex02_RadioText() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		boolean gender1 = true;
		if (request.getParameter("gender").equals("여성")){
			gender1=true;
		}
		if (request.getParameter("gender").equals("남성")){
			gender1=false;
		}
		
		String mail = request.getParameter("mailcheck");
		String str = request.getParameter("content");
		
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.print("<html><body>");
		out.print("<p> 성별 : " + (gender1 ? "여성" : "남성"));
		out.print("</p>");
		out.printf("<p> 메일수신 : %s </p>" ,  mail);
		out.printf("<p> 가입인사 : %s </p>", str);
//		out.print("<p> 가입인사 : "+ str + "</p>");
		out.print("</body></html>");
		
	} // doGet

}
