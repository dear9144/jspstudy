package practice06;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URLEncoder;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CreateFileServlet")
public class CreateFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 	1. 파일 만들기
		 		파일명 : yyyy-mm-dd-작성자-제목.txt
		 		파일경로 : Real Path에 storage 디렉토리 만들어서 저장
		 		파일내용 : 내용 그대로 추가 
		 */
		request.setCharacterEncoding("UTF-8");
		
				String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		String filename = LocalDate.now().toString() + "-" + writer + "-" + title + ".txt";
		
		//디렉토리 잡기
		File dir = new File(request.getServletContext().getRealPath("storage"));
		if(dir.exists() == false) {
			dir.mkdirs();z
		}
		
		File file = new File(dir, filename);
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		bw.write(content);
		bw.flush();
		bw.close();
		
		
	
			
		
		
		/*
		 	2. FileResponseServlet으로 리다이렉트 
		 		파일명 전달하기 
		 */
		response.sendRedirect("/01_Servlet/FileResponseServlet?filename=" + URLEncoder.encode(filename, "UTF-8"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
