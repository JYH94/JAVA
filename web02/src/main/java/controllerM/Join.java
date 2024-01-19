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
 * Servlet implementation class Join
 */
@WebServlet("/mJoin")
public class Join extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Join() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		String check = request.getParameter("id");

		MemberService ms = new MemberService();
		MemberDTO dto = ms.selectOne(check);
		
		if (dto == null && check.length() < 10) {
			
			MemberDTO newMember = new MemberDTO();
			newMember.setId(request.getParameter("id"));
			newMember.setPassword(request.getParameter("password"));
			newMember.setName(request.getParameter("name"));
			newMember.setAge(Integer.parseInt(request.getParameter("age")));
			newMember.setJno(Integer.parseInt(request.getParameter("jno")));
			newMember.setInfo(request.getParameter("info"));
			newMember.setPoint(Double.parseDouble(request.getParameter("point")));
			newMember.setBirthday(request.getParameter("birthday"));
			newMember.setRid(request.getParameter("rid"));
			ms.insert(newMember);
			
//			request.getSession().setAttribute("jMessage", "환영합니다 로그인 하세요.");
//			response.sendRedirect("member/loginForm.jsp");
			request.setAttribute("jMessage", "환영합니다 로그인 하세요.");
			request.getRequestDispatcher("member/loginForm.jsp").forward(request, response);
		} else {
			request.getSession().setAttribute("message", "아이디가 중복되거나 아이디 길이 체크. ");
			response.sendRedirect("member/joinForm.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
		
	}

}
