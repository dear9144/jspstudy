package ex05_redirect;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RedirectServlet2")
public class RedirectServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//리다이렉트 이후 (두 번째 요청) 파라미터 확인
		//요청 : /01_Servlet/RedirectServlet2 <- 두번째 요청에 파라미터가 붙어있지 않기 떄문에 null이 나온것 
		String model = request.getParameter("model");
		System.out.println("RedirectServlet2: " + model);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
