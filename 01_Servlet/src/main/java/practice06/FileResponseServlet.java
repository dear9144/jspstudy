package practice06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FileResponseServlet")
public class FileResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		  1.전달 받은 파일을 이용해서 경고창 만들기(alert)
		  예시) 2023-03-17-민경태-금요일이다.txt 파일이 생성되었습니다.
		  */
		
		request.setCharacterEncoding("UTF-8");
		
		String filename= request.getParameter("filename");
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('"+ filename + " 파일이 생성되었습니다.')"); 
		 // 2.작성 화면으로 돌아가기client.html로 이동하기 
		out.println("location.href='/01_Servlet/practice06/client.html'"); //실제 패턴에선 이러한 경로로 이동하는 경우는 거의 없다고 보면 됨 
		out.println("</script>");
		//이 자리에선 redirect로 이동하거나 forward로 이동하는건 가능할지 ? 아직은 안됨
		//why? 응답이 끝난 곳이어서 (/script)
		out.flush();
		out.close();
		//println 시 ln을 없애면 안돈다 (한줄로 만들어지기 떄문에) 근데 굳이 만들겠다 싶으면 세미콜론을 찍어주면 됨 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
