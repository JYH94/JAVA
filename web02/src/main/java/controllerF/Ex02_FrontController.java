package controllerF;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//** FrontController 패턴 2.
//=> Factory 패턴 적용
// - ServiceFactory
// - 개별컨트롤러(일반클래스) : 일관성을 위해 강제성 부여 ( interface 사용 )

@WebServlet(urlPatterns = { "*.fo" })
public class Ex02_FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ex02_FrontController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1) 요청 분석
		// => url 분석 후 요청명을 확인
		// => 한글처리 (한글처리는 post에서만 한다고 들은거 같은데 아닌가?)
		request.setCharacterEncoding("UTF-8"); // 한글처리
		String uri = request.getRequestURI();
		uri = uri.substring(uri.lastIndexOf("/"));
		// @@ /뒤쪽 스트링 긁어오고 ~

		
	    // 2) Service 실행
	    // => ServiceFactory 에 요청
	    // => uri 를 전달하면 해당 서비스컨트롤러 를 생성해서 인스턴스를 제공  
		
		// Ex03_ServiceFactory sf = new Ex03_ServiceFactory();
		// => 오류 : ~~ Ex03_ServiceFactory() is not visible
		// 앞서 Ex03_ServiceFactory에서 생성자를 private로 지정해뒀기 때문에
		// 외부에서 생성을 허용하지 않는다. (싱글톤 패턴을 유지하기 위해)
		// 싱글턴 패턴 Test
		Ex03_ServiceFactory sf = Ex03_ServiceFactory.getInstance();
//		Ex03_ServiceFactory sf1 = Ex03_ServiceFactory.getInstance();
//		Ex03_ServiceFactory sf2 = Ex03_ServiceFactory.getInstance();
//		System.out.printf("** 싱글턴 패턴 Test : sf = %s, sf1 = %s, sf2 = %s\n",sf,sf1,sf2);
		
		Ex04_Controller controller = sf.getController(uri);
		// @@ 긁어온 뒤쪽스트링을 서비스팩토리에 보내주면 서비스팩토리 속 필드변수인 HashMap에 도달
		// 도달된 값을 키로 써서 ! 밸류를 반환시킨다.
		// 그 밸류는 슈퍼인터페이스에서 구체화된 행동들을 담고있다
		// (ex) mList,mDetail 등)
//		mappings.put("/mlist.fo", new Ex05_mList());
//		mappings.put("/mdetail.fo", new Ex05_mDetail());
		
		uri = controller.doUser(request, response);
		// 위에서 서비스팩토리에서 반환시킨값이 uri가 된다.
		
		// 3) View처리
		request.getRequestDispatcher(uri).forward(request, response);
	} // doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	} // doPost

}
