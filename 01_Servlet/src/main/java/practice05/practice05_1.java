package practice05;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/practice05_1")
public class practice05_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String model = request.getParameter("model");
		System.out.println("Practice05_1 :" + model);
		
		//응답할 URL의 인코딩이 필요하다 
		response.sendRedirect("/01_Servlet/practice05_2?model=" + URLEncoder.encode(model, "UTF-8"));
		//응답 내보낼때 인코딩이 빠져서 오류가 난 것임 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
