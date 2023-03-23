package ex07_ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.json.XML;

@WebServlet("/XMLServlet")
public class XMLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청 인코딩
		request.setCharacterEncoding("UTF-8");
		
		//요청 파라미터
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String strPrice = request.getParameter("price");
		
		int price = 0;
		if(strPrice != null && strPrice.isEmpty() == false) {
			price = Integer.parseInt(strPrice);
		}
		
		//응답할 XML 만들기(JSONObject를 ㅁ너저 만든 뒤 XML 변환)
		
		/*
		 	<book>
		 		<title>제목</title>
		 		<author>저자</author>
		 		<price>가격</price>
		 	</book>
		  이렇게 만들려면 모두 프로퍼티로 만들어져 있어야 함
		  title author price 이걸 만들려면 
		  -> 이게필요 JSONobject obj
		  obj.put("title")
		  obj.put("author")
		  obj.put("price")
		  근데 book도 필요함 
		  그래서 또다른 JSONObject obj2
		  obj2.put("book")이 필요한데
		  최종적으론 obj2가 필요함 
		 */
		JSONObject obj = new JSONObject();
		obj.put("title", title);
		obj.put("author", author);
		obj.put("price", price);
		JSONObject obj2 = new JSONObject();
		obj2.put("book", obj);
		
		String resData = XML.toString(obj2);
		
		//응답 데이터 타입
		response.setContentType("application/xml; charset=UTF-8");
		
		//출력 스트림 생성
		PrintWriter out = response.getWriter();
		
		//출력
		out.println(resData);
		out.flush();
		out.close();
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
