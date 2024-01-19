package controllerM;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.MemberDTO;
import service.MemberService;

/**
 * Servlet implementation class C03_mDetail
 */
@WebServlet("/C03_mDetail")
public class C03_mDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public C03_mDetail() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		
		
		String id = (String) request.getSession().getAttribute("loginId");
		String url = "member/memberDetail.jsp";
		if("U".equals(request.getParameter("jCode"))) {
			url="member/updateForm.jsp";
		}
		
		MemberService ms = new MemberService();
		MemberDTO dto = ms.selectOne(id);
		request.setAttribute("apple", dto);
		
		response.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher(url).forward(request, response);
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
