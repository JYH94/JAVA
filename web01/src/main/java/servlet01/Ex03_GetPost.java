// servlet
package servlet01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//** Get
//- request 의 header 영역의 url 뒤에 쿼리스트링으로 전달,
//- 일반적으로 256 byte 이내로 크기제한이 있는 것으로 알려져 있으나,
// 이 용량은 브라우져 또는 장비에 따라 다를수 있음
//- 결론은 이미지 등 무거운 자료의 전송은 대부분 불가능 하므로 이때는 post로 해야함. 

//** Post
//- request 의 body 영역에 담겨져 전달됨
//- 크기제한 없음, 보안성 유리 

@WebServlet(urlPatterns = { "/getpost" })
public class Ex03_GetPost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ex03_GetPost() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1 request 의 Parameter 처리
		// request 값도 getParameter 처리를 하기 전에 한글 처리를 해줘야함
		// - Tomcat(WAS) 은 Get 방식요청에서는 "UTF-8" 을 default 로 적용함
		// ( html 문서에서 "UTF-8" 작성되었고 , Get 방식으로 전송되면 생략가능
		// 단, post 방식에서는 반드시 처리해야함 )
		request.setCharacterEncoding("UTF-8");

		// name이 id인 inputTag의 value 값을 return
		String id = request.getParameter("id");
		String name = request.getParameter("name");

		// 파라미터가 없으면 null을 return
		// 파라미터가 있지만 값이 없는 경우 null이 아님
		// http://localhost:8080/web01/getpost?id=banana&name=바나나&password=
		String password = request.getParameter("password");
		if (password != null && password.length() > 0) {
			System.out.println("** password => " + password);
		} else {
			System.out.println(" password is null or Empty");
		}

		// 전달된 입력에 대한 한글처리
		// 출력 객체 생성 전에 한글처리
		// 웹브라우저에게 처리할 데이터의 Mine 타입을 알려줌
		// Multipurpose Internet Mail Extensions
		// 데이터 송,수신시 자료의 형식에 대한 정보
		// Jsp의 page 디렉티브의 contentType 속성값과 동일
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("<h2 style ='color:blue;'> ** Get/Post Test **</h2>");
		out.print("<h3> => 전달된 Parameter 확인</h3>");
		out.print("<h3> => Id : " + id + "</h3>");
		out.print("<h3> => Name : " + name + "</h3>");
		out.print("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

} // class