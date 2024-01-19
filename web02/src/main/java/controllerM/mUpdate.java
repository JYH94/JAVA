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
 * Servlet implementation class mUpdate
 */
@WebServlet("/mupdate")
public class mUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public mUpdate() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청분석
		// 2. 리퀘스트의 한글(post시 필수) & parameter 처리
		
		
		String uri = "member/memberDetail.jsp";
		request.setCharacterEncoding("UTF-8");
		
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
		
		// => 결과 출력을 위해 apple에 보관
		request.setAttribute("apple", newMember);
		System.out.println(newMember);
		MemberService ms = new MemberService();
		if( ms.update(newMember) > 0) {
			request.getSession().setAttribute("loginName", newMember.getName());
			request.setAttribute("message", "회원정보 수정 성공");
		} else {
			request.setAttribute("message", "회원정보 수정 실패");
			uri = "member/updateForm.jsp";
		}
		request.getRequestDispatcher(uri).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
