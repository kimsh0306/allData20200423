package com_mvc2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class FrontMVC2 extends HttpServlet {
	Logger logger = Logger.getLogger(MemberController.class);
	public void doService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		logger.info("doGet 호출 성공");
		// ==> dev_jsp/member/memberList.mvc2?crud=sel
		String requestURI = req.getRequestURI();
		logger.info("requestURI:"+requestURI);
		// ==> dev_jsp
		String contextPath = req.getContextPath();
		logger.info("contextPath:"+contextPath);
		// ==> member/memberList.mvc2
		String command = requestURI.substring(contextPath.length()+1);
		logger.info("command:"+command);
		
		
		//crud는 create,read,update,delete의 약자로 데이터를 생성하고 읽고 지우는 처리 전반을 일컫는 용어이다. 
		String crud = null;
		crud = req.getParameter("crud");
		
		//인터페이스 선언
		Controller controller = null;
		
		//여기서 인스턴스화를 해야 한다.그리고 process()메소드를 호출해야 한다.
		
		try {
			//ControllerMapper.getController()메소드가 하는 일은
			//command별로 업무를 처리할 구현체 클래스를 생성하면서 crud를 파라미터로 넘겨 준다.
			controller = ControllerMapper.getController(command, crud);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//인스턴스화 된 변수가 해당 객체에 포함되는지 확인하기 위해 instanceOf를 사용한다.
		if(controller instanceof MemberController) {
			logger.info("MemberController 타입이면... 회원관리 업무임.");
			String path = controller.process(req, res);
			String pageMove[] = null;
			pageMove = path.split(":");
			for(int i=0;i<pageMove.length;i++) {
				logger.info("pageMove:"+pageMove[i]);
			}
			if(pageMove != null) {
				String path2 = pageMove[1];
				if("redirect".equals(pageMove[0])) {
					res.sendRedirect(path2);
				}
				else {
					RequestDispatcher view = req.getRequestDispatcher(path2);
					view.forward(req, res);
				}
			}
		}
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		logger.info("doGet 호출 성공");
		doService(req,res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		logger.info("doPost 호출 성공");
		doService(req,res);
	}
}
