package jsp.ch17;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.istack.internal.logging.Logger;

@WebServlet(urlPatterns="/ch17/shopping.do")
public class FrontServlet extends HttpServlet{
	Logger logger = Logger.getLogger(FrontServlet.class);
	public void doService(HttpServletRequest req
			,HttpServletResponse res) throws ServletException, IOException
	{
		//url pattern의 이름이 shopping.do라고 했을 때 ?mode=order
		String mode = req.getParameter("mode");
		//주문관리인지?
		if("order".equals(mode)) {
			System.out.println("주문관리");
			logger.info("주문관리");
			res.sendRedirect("./orderList.jsp");
		}
		//회원관리인지?
		else if("member".equals(mode)) {
			System.out.println("회원관리");
			logger.info("회원관리");
		}
	}
	@Override
	public void doGet(HttpServletRequest req
					 ,HttpServletResponse res) throws ServletException, IOException
	{
		doService(req,res);
	}
	
}
