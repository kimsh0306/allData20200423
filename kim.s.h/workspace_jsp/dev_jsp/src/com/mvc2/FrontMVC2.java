package com.mvc2;

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
		logger.info("requestURI:"+requestURI);// ==> /member/memberList.mvc2
		// ==> dev_jsp
		String contextPath = req.getContextPath();
		logger.info("contextPath:"+contextPath);// ==> 
		// ==> dev_jsp/member/memberList.mvc2
		String command = requestURI.substring(contextPath.length()+1);//부서 정보
		// ==> member/memberList.mvc2
		//logger.info("command:"+command);
		
		//인터페이스 선언
		Controller controller = null;
		
		//crud는 create,read,update,delete의 약자로 데이터를 생성하고 읽고 지우는 처리 전반을 일컫는 용어이다. 
		String crud = null;
		crud = req.getParameter("crud");//실제로 처리할 업무에 대한 정보
		
		
		//여기서 인스턴스화를 해야 한다.그리고 process()메소드를 호출해야 한다.
		
		try {
			
			//ControllerMapper.getController()메소드가 하는 일은?
			//FrontMVC2가 ControllerMapper에게 구현체 클래스를 인스턴화 하라고 시키는 것이다.
			//  - 구현체클래스: Controller(I)를 Implements한 클래스 ==> MemberController
			
			//command별로 업무를 처리할 구현체 클래스를 생성하면서 crud를 파라미터로 넘겨 준다.
			//Controller 인터페이스를 MemberController 구현체로 인스턴스화 하는 것이다.***
			//Controller에는 crud의 값을 갖고 있는 MemberController객체가 들어가는 것이다.***
			controller = ControllerMapper.getController(command, crud);//목적지 설정
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		//인스턴스화 된 변수가 해당 객체에 포함되는지 확인하기 위해 instanceOf를 사용한다.
		
		//만약에 controller가 MemberController라면
		if(controller instanceof MemberController) {//설정된 목적지로 보내기
			//logger.info("MemberController 타입이면... 회원관리 업무임.");
			
			//MemberController를 사용하는 위치***
			String path = controller.process(req, res);
			
			String pageMove[] = null;
			
			//forward인지 redirect인지 구분하기.
			pageMove = path.split(":");
			
			//배열 출력
//			for(int i=0;i<pageMove.length;i++) {
//				logger.info("pageMove:"+pageMove[i]);
//			}

			//
			if(pageMove != null) {
				String path2 = pageMove[1];
				
				if("redirect".equals(pageMove[0])) {
					res.sendRedirect(path2);
				}
				else {
					RequestDispatcher view = req.getRequestDispatcher(path2);
					//forward는 Request객체를 가지고 간다.
					//그래서 도착지에서 req.getParameter()를 사용할 수 있다.
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
