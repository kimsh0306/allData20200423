package jsp.ch13;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
//서블릿 페이지를 추가로 지정해 줄 수 있다.
//url을 정해줘야 자바를 브라우저에서 부를 수 있다.
//url을 배치서술자(web.xml)에 등록해 준다.
	
	@Override
	public void doGet(HttpServletRequest req, 
					  HttpServletResponse res) throws IOException, ServletException
	{
		//<input type="text" id="mem_id" name="mem_id">
		//$("#mem_id") => id의 위치
		//여기 ()는 name을 쓰는 위치이다.
		res.setContentType("text/html;charset=UTF-8)");
		String mem_id = req.getParameter("mem_id");
		PrintWriter out = res.getWriter();
		out.print(mem_id);
	}
}
