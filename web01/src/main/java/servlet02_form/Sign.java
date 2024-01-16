package servlet02_form;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvcTest.StudentDAO;
import mvcTest.StudentDTO;
import mvcTest.StudentService;

@WebServlet("/sign")
public class Sign extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	public Sign() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String userid = request.getParameter("userid");
		String userpw = request.getParameter("userpw");

		
		response.setContentType("text/html; charset=UTF-8");

		
		PrintWriter out = response.getWriter();

		out.print("<html><body>");
		out.println("<p>아이디 :  " + userid + "</p>");
		out.println("<p>비밀번호 :  " + userpw + "</p>");
		out.print("</body></html>");
	}

}
