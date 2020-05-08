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


public class MVCServlet extends HttpServlet{
	Logger logger = Logger.getLogger(MVCServlet.class);
	ServletConfig config = null;
	
	public void init(ServletConfig config) throws ServletException{
		logger.info("init 호출 성공");
		this.config = config;
		this.init();
	}
	
	public void doService(HttpServletRequest req
			 ,HttpServletResponse res) throws ServletException, IOException
	{
		logger.info("doService 호출 성공");
		
		String uri = req.getRequestURI();//member/memberList.kosmo
		String context = req.getContextPath();//server.xml의 context path
		logger.info("uri:"+uri);
		logger.info("context:"+context);
		
		//URI - Path => member/memberList.kosmo
		String command = uri.substring(context.length()+1);
		logger.info("command:"+command);
		
		//.kosmo 지우기 => member/memberList
		int end = command.lastIndexOf('.');
		command = command.substring(0,end);
		
		//member/memberList => member, memberList를 배열에 담는다.
		String imsi[] = null;
		imsi = command.split("/");
//		for(String val : imsi) {
//			logger.info(val);
//		}
		MemberController memCtrl = new MemberController();
		OrderController orderCtrl = new OrderController();
		GoodsController goodsCtrl = new GoodsController();
		
		if() {
			memCtrl.execute(req,res);
		}
		else if() {
			orderCtrl.execute(req,res);
		}
		else if() {
			goodsCtrl.execute(req,res);
		}
		
	}

	@Override
	public void doGet(HttpServletRequest req
					 ,HttpServletResponse res) throws ServletException, IOException
	{
		doService(req,res);
	}
	@Override
	public void doPost(HttpServletRequest req
			,HttpServletResponse res) throws ServletException, IOException
	{
		logger.info("doPost 호출 성공");
		String mem_name = req.getParameter("mem_name");
		logger.info("입력한 사람은 "+mem_name);
	}
}
