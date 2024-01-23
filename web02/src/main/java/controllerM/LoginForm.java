package controllerM;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.MemberDTO;
import service.MemberService;

/**
 * Servlet implementation class LoginForm
 */
@WebServlet("/login")
public class LoginForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginForm() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberService ms = new MemberService();
		
		
		MemberDTO check = new MemberDTO();
		check = ms.selectOne(request.getParameter("id"));
		
		String url = "home.jsp";
		
		if (check != null && check.getPassword().equals(request.getParameter("password"))) {
			request.getSession().setAttribute("loginId", request.getParameter("id"));
//			request.getSession().setAttribute("loginPw", request.getParameter("password"));
			
			
			response.sendRedirect(url);
			
		} else {
			
			url = "member/loginForm.jsp";
			
			request.setAttribute("message", "잘못입력했습니다");
			
			RequestDispatcher rd = request.getRequestDispatcher(url);
			
			rd.forward(request, response);
		}
		
	}

}
