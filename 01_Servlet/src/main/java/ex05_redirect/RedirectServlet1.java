package ex05_redirect;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RedirectServlet1")
public class RedirectServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 확인 해볼 것 , 리다이렉트 이전 (첫번째 요청)
		//첫번째 요청 : /01_Servlet/RedirectServlet1?model=TV
		String model = request.getParameter("model");
		System.out.println("RedirectServlet1 : " + model);
		
		//redirect를 이용해서 다른 서블릿(서버 경로)으로 이동하기 
		response.sendRedirect("/01_Servlet/RedirectServlet2?model=TV"); //어디로 전화 해야하는지 알려줘야지 -> redirectServlet2ㅇ번으로 다시 이동하세요
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
