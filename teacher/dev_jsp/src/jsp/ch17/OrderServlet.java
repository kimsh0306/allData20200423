package jsp.ch17;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
                                         //ch17/shopping2.do
@WebServlet(urlPatterns="/ch17/order.nhn")
public class OrderServlet extends HttpServlet {
	Logger logger = Logger.getLogger(OrderServlet.class);
	ServletConfig config = null;
	public void init(ServletConfig config) throws ServletException{
		logger.info("init 호출 성공");
		this.config = config;
		this.init();
	}
	@Override
	public void doGet(HttpServletRequest req
			                   , HttpServletResponse res) throws ServletException, IOException
	{
		logger.info("doGet 호출 성공");
		String mem_name = req.getParameter("mem_name");
		logger.info("입력한 사람은 "+mem_name);
		//res.sendRedirect("");
		List<Map<String,Object>> olist = new ArrayList<>();
		Map<String,Object> rmap = new HashMap<>();
		rmap.put("deptno",10);
		rmap.put("dname","총무");
		rmap.put("loc","인천");
		olist.add(rmap);
		req.setAttribute("olist", olist);
		RequestDispatcher view 
		= req.getRequestDispatcher("./orderList.jsp");
		view.forward(req, res);
	}
	@Override
	public void doPost(HttpServletRequest req
			, HttpServletResponse res) throws ServletException, IOException
	{
		logger.info("doPost 호출 성공");
		String mem_name = req.getParameter("mem_name");
		logger.info("입력한 사람은 "+mem_name);
	}
}
