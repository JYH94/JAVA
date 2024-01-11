package servlet01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvcTest.StudentDTO;
import mvcTest.StudentService;

/**
 * Servlet implementation class Ex02_MVC01List
 */
@WebServlet("/list")
public class Ex02_MVC01List extends HttpServlet {
	private static final long serialVersionUID = 1L;

	StudentDTO dto = new StudentDTO();
	
	
    public Ex02_MVC01List() {
        super();
    }
    
    
    
    // **MVC 패턴1 StudentList 출력하기
    // => 요청 Service를 처리하고
    // => 결과를 출력하자
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // => 요청 Service를 처리하고
		StudentService sc = new StudentService();
		List<StudentDTO> arr = new ArrayList<>();
		
		
		// => 결과 출력 : 출력내용을 Response 객체의 Body영역에 Write
		//		- 한글 처리
		//		- 출력객체 생성 & 출력
		response.setContentType("text/html; charset=utf-8");
		arr=sc.selectList();
		
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("<h2 style='color:blue;'>** Servlet_MvC1 StudentList **</h2>");
		if(arr != null) {
			out.print("<table border=1>");
			out.print("<thead>");
			out.print("<tr>");
			out.print("<th>번호</th>");
			out.print("<th>이름</th>");
			out.print("<th>나이</th>");
			out.print("<th>조번호</th>");
			out.print("<th>정보</th>");
			out.print("<th>포인트</th>");
			out.print("</tr>");
			out.print("</thead>");
			out.print("<tbody>");
			
			for (int i = 0; i < arr.size(); i++) {
				out.printf("<tr>");
				out.printf("<td>" + arr.get(i).getSno()+"</td>");
				out.printf("<td>" + arr.get(i).getName()+"</td>");
				out.printf("<td>" + arr.get(i).getAge()+"</td>");
				out.printf("<td>" + arr.get(i).getJno()+"</td>");
				out.printf("<td>" + arr.get(i).getInfo()+"</td>");
				out.printf("<td>" + arr.get(i).getPoint()+"</td>");
				out.printf("</tr>");
			}
			
			out.print("</tbody>");
			out.print("</table>");
			out.print("<form>");
			out.print("<input type=\"submit\" value=\"마지막학생 제거\" >");
			out.print("</form>");
			out.print("</body></html>");
			
		} else {
			out.print("<h2>~~ 출력할 Data 가 없습니다. ~~</h2>");
		}

		
	} // doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
} // class
