package ex09_binding;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/BindingServlet1")
public class BindingServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		  	1. stateless(상태없음)
		  		1. 상태 없음
		  		2. 웹 페이지간의 이동은 stateless한 이동이다.
		  		3. 현재 페이지에는 이전 페이지의 정보가 없다
		  		
		  	2. binding
		  		1. 값을 저장할 수 있는 영역에 속성(Attribute)의 형태로 값을 저장하는 것을 말함
		  		2. 저장 영역은 서버가 제공
		  		3. 3개 영역
		  			1.HttpServletRequest : 하나의 요청 내에서 값을 저장할 수 있다 (1회용)
		  			2.HttpSession : 웹 브라우저 종료 전까지 값을 저장할 수 있다.(시간 지정)
		  			3.ServletContext : 컨텍스트(프로젝트, 애플리케이션) 종료 전까지 값을 저장할 수있음
		  		4. 속성(Attribute) 관련 메소드
		  			1. getAttribute('속성')		: 값 가져오기(캐스팅 필요할 수 있음)
		  			2. setAttribute('속성', 값)	: 값 저장하기(Object 타입으로 저장한다)
		  			4. removeAttribute('속성') 	: 값 제거하기 
		  		 
		 */
		
		// HttpServletRequest에 저장하기
		request.setAttribute("a", 100);
		
		// HttpSession에 저장하기 <- request는 만드는것부터 해야함 
		HttpSession session = request.getSession();//세션의 이름은 거의 session을 주로 슴
		session.setAttribute("a", 200); //같은이름으로 저장해도 저장소가 다르니까 가능 
		
		// ServletContext에 저장하기 
		ServletContext ctx = request.getServletContext();
		//ServletContext ctx = getServletContext(); 이렇게 해도 됨 (어플리케이션 자체가 주인이기 떄문에 가능)
		ctx.setAttribute("a", 300);
		
		// 페이지 이동 redirect forward
		
		// 1. HttpServletRequest의 전달이 없는 이동 :redirect , <a href=""> , location.href=""	
		// response.sendRedirect("/01_Servlet/BindingServlet2");// forward 실행할거면 주석으로 만들고 할 것 
		
		// 2. HttpServletRequest의 전달이 있는 이동 : forward
		request.getRequestDispatcher("/BindingServlet2").forward(request, response); //Server 내부 이동이라 contextpath 적으면 안됨 서블릿 이름만 적으면 됨
		//회사 내부이동이라고 생각 내부이동하는데 회사이름은 안 적어도 되지 
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
