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
@WebServlet("/select")
public class Ex04_Select extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ex04_Select() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
		
		
		String job = request.getParameter("job");
		String[] interest = request.getParameterValues("interest");
		
		
		response.setContentType("text/html; charset=UTF-8");
		
		
		PrintWriter out = response.getWriter();
		
		out.print("<html><body>");
		out.printf("<p>직업 : %s </p>", job);
		out.printf("<p>관심분야 : ");
		for (String i : interest) {
			out.printf(i + " ");
		}
		out.printf("</p>");
		
		out.print("</body></html>");
		
		
	} // doGet

}
