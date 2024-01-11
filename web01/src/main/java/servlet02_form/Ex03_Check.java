package servlet02_form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex01_Adder
 */
@WebServlet("/check")
public class Ex03_Check extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ex03_Check() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String[] gift = request.getParameterValues("gift");

		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		out.print("<html><body>");
		out.print("선택한 항목들 : ");

		for (String g : gift) {
			switch (g) {
			case "shoes":
				out.print("신발 ");
				break;
			case "hats":
				out.print("모자 ");
				break;
			case "belt":
				out.print("벨트 ");
				break;
			case "bag":
				out.print("가방 ");
				break;
			default:
				out.print(g + " ");
			}

		}
		out.print("</body></html>");

	} // doGet

}
