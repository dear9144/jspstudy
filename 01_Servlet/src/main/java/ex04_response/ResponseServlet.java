package ex04_response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ResponseServlet")
public class ResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ResponseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청 파라미터 처리하기
		
		request.setCharacterEncoding("UTF-8");
		
		String model = request.getParameter("model");
		String strPrice = request.getParameter("price");
		
		int price = 0;
		if(strPrice != null && strPrice.isEmpty() == false) {
			price = Integer.parseInt(strPrice);
		}
		
		/*응답
		 1. 서버 -> 클라이언트로 보내는 것이 응답이다 
		 2. 응답처리 -> HttpServletResponse클래스가 응답을 처리 
		 3. 어떤 MIME 타입으로 응답할 것인지 결정해야 한다 (네가 응답할게 이미지냐 파일이냐 html xml이냐?어떤거냐)
		    반환타입 비슷한 것 
			1) HTML : 태그를 만들어서 태그를 반환, text/html		(태그를 만들어서 반환하는 경우)
			2) XML : application/xml						(ajax 응답이 XML인 경우) 
			3) JSON : application/json						(ajax 응답이 JSON인 경우)
			
		*/
		
		//응답 만들기
		// 1. 응답할 데이터으 ㅣMIME 타입과 UTF-8 인코딩
		response.setContentType("text/html; charset=UTF-8");
		
		// 2. 응답 스트림 생성(IOException 처리가 필요 -> 이미 처리되어 있다 ) 
		PrintWriter out = response.getWriter(); // PrintWriter 출력 메소드 : append(), writer(), print(), println() 등 
		// 3. 응답 만들기 
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"ko\">");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>나의 첫 응답</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>모델명: " + model + "</h1>");
		out.println("<h1>가격: " + price + "</h1>");
		out.println("</body>");
		out.println("</html>");
		out.flush(); // 호ㅓㄱ시 출력 스트림에 남아있는 데이터를 모두 내보내기
		out.close();                                                                  
		
		
	}
		
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
