package controllerM;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.MemberDTO;
import service.MemberService;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/rdelete")
public class rDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public rDelete() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		if(request.getSession().getAttribute("loginPw").equals(request.getParameter("checkPw")) )  {
//			
//			MemberService ms = new MemberService();
//			
//			ms.delete((String)request.getSession().getAttribute("loginId"));
//			
//			request.getSession().invalidate();
//			request.setAttribute("dMessage", "탈퇴성공 재가입하세요"); 
//			request.getRequestDispatcher("/home.jsp").forward(request, response);
//			
//		} else {
//			request.setAttribute("dMessage", "탈퇴실패 비밀번호 오류");
//			request.getRequestDispatcher("member/delete.jsp").forward(request, response);
//		}
		
		
		MemberService ms = new MemberService();
		MemberDTO dto = ms.selectOne((String) request.getSession().getAttribute("loginId"));

		if ( dto.getPassword().equals(request.getParameter("checkPw") )) {
			ms.delete(dto.getId());

			request.getSession().invalidate();
			request.setAttribute("dMessage", "탈퇴성공 재가입하세요");
			request.getRequestDispatcher("home.jsp").forward(request, response);
		} else {
			request.setAttribute("dMessage", "탈퇴실패 비밀번호 오류");
			request.getRequestDispatcher("member/delete.jsp").forward(request, response);
		}
		
		
		
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
