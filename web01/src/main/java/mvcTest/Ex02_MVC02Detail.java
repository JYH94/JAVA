package mvcTest;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




// MVC2 방식
//
// 1. home.jsp : 메뉴 Myinfo 를 클릭
//    -> ControllerServlet : 해당하는 Service 처리 -> 결과를 requestScope에 담기 , forward
//	     mvcTest/Ex02_MVC02Detail.java
//
//
//
//    -> View (~jsp) : requestScope의 결과를 확인 & 출력
//	     mvcTestJsp/ex03_MVC02Detail.jsp

@WebServlet("/detail2")
public class Ex02_MVC02Detail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ex02_MVC02Detail() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentService service = new StudentService();
		StudentDTO dto = service.selectOne((int)request.getSession().getAttribute("loginID"));
		
		request.setAttribute("myInfo", dto);
		
		request.getRequestDispatcher("mvcTestJsp/ex03_MVC02Detail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
