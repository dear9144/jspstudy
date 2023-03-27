package ex09_binding;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BindingServlet2")
public class BindingServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// HttpServletRequest에 저장된 속성 확인
		System.out.println(request.getAttribute("a"));
		//System.out.println((int)request.getAttribute("a")); -> 이게 (int)null 이런거나 마찬가지 인트를 없애자  

		// HttpSession에 저장된 속성 확인
		System.out.println((int)request.getSession().getAttribute("a"));
		
		// ServletContext에 저장된 속성 확인
		System.out.println((int)request.getServletContext().getAttribute("a"));
		
		//           
	}
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
