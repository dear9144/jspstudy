package ex11_upload_download;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 요청 파라미터 
		request.setCharacterEncoding("UTF-8");
		String path = URLDecoder.decode(request.getParameter("path"), "UTF-8");
		
		//다운로드 해야할 File  객체
		File file = new File(path);
		
		// 다운로드 해야 할 파일을 읽어들일 입력 스트림 
		BufferedInputStream in  = new BufferedInputStream(new FileInputStream(file)); //bufferedreader는 text만 읽을 수 있기 떄문에 bufferedinputstream을 상요해야 함 
		
		//다운로드용 응답 헤더 - http메뉴얼에 있음 (노션 참고)
		response.setHeader("Content-Disposition", "attachment; filename=" + path.substring(path.lastIndexOf("\\")+ 1));
		response.setHeader("Content-Length", file.length() + ""); //파일의 크기는 length 메소드로 사용 
		// 근데  header는 String으로 요구하기 때문에 String으로 바꿔줘야 함
		
		//응답 스트림(출력 스트림)
		BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
		// 얼마를 읽어들이든 같은 값을 in -> out으로 보내는 작업 while문으로 실행하면 됨 
		
		//파일 복사(in에서 1024 byte단위로 읽은 다음 out으로 보내기)
		byte [] b = new byte[1024]; //입력 단위 
		int readByte = 0;			//실제로 읽은 바이트
		while((readByte = in.read(b)) != -1) { //b를 out으로 보내는 작업 실행
			out.write(b, 0, readByte); //index0부터 readByte까지만 읽어오겠다 
		}
		
		out.close();
		in.close();
		
			
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
