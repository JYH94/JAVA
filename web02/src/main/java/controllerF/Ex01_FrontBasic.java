package controllerF;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.MemberDTO;
import service.MemberService;

//** FrontController 패턴 1.
//=> 대표 컨트롤러 1개만 서블릿으로 작성
//   모든 요청을 이 대표컨트롤러(FrontController) 가 받도록 함.
//   나머지 컨트롤러는 일반 클래스로 작성 (2단계, Factory 패턴 적용)

//=> 요청에 대한 서비스를 if문으로 서블릿내에서 모두 처리
//   코드가독성, 모듈의 재사용성 떨어짐 (1단계) 


@WebServlet( urlPatterns = {"*.do"} )
// urlPatterns 안에 여러개를 적어주면 어노테이션 명이 이것저것 다 되는거야?
public class Ex01_FrontBasic extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public Ex01_FrontBasic() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1) 요청 분석
		// => url 분석 후 요청명을 확인
		// => 한글처리 (한글처리는 post에서만 한다고 들은거 같은데 아닌가?)
		request.setCharacterEncoding("UTF-8"); // 한글처리
		String uri = request.getRequestURI();
		uri = uri.substring( uri.lastIndexOf("/") );
		
		System.out.println("** URL => " +  request.getRequestURL());
		System.out.println("** URL => " +  request.getRequestURI());
		System.out.println("** uri => " +  uri);
		
		// 2) Service 실행
		MemberService service = new MemberService();
		MemberDTO dto = new MemberDTO();
		
		if ( "/mlist.do".equals(uri) ) {
			// ** Member List
			request.setAttribute("banana", service.selectList());
			uri = "member/memberList.jsp";
		} else if ("/C03_mDetail.do".equals(uri)) {
			// ** Member Detail : Login 후 Test
			request.setAttribute("apple", service.selectOne(uri));
			uri = "member/memberDetail.jsp";
		} else {
			String id = (String)request.getSession().getAttribute("loginId");
			request.setAttribute("message", "요청에 해당하는 기능은 없습니다.");
			uri = "home.jsp";
		}
		// 지금은 하나의 서블릿에서 조건문을 통해 요청을 걸러서 받았다면
		// 다음 단계에선 조건별로 각자 클래스를 만들어서 실행되도록 만들자
		
		// 3) View처리
		request.getRequestDispatcher(uri).forward(request, response);
		
	} // doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	} // doPost

}
