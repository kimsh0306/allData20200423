package com.mvc3;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.mvc2.Controller;
import com.mvc2.ControllerMapper;
import com.util.HashMapBinder;

public class ActionSupport extends HttpServlet {
	Logger logger = Logger.getLogger(ActionSupport.class);
	public void doService(HttpServletRequest req
            , HttpServletResponse res)
    throws ServletException, IOException
	{
		String requestURI = req.getRequestURI();
		logger.info("requestURI : "+requestURI);
		//  ==> dev_jsp
		String contextPath = req.getContextPath(); 
		logger.info("contextPath : "+contextPath);
		// ==> /member/memberList.mvc2	
		String command = 
				requestURI.substring(contextPath.length()+1);
		// ==> member/memberList.mvc2	
		logger.info("before command : "+command);
		int end = command.lastIndexOf(".");
		String requestName = null;
		requestName = command.substring(0,end);
		logger.info("requestName: "+requestName);
		
		Controller2020 controller = null;
		logger.info("aftter command : "+requestName); 
		//insert here - 인스턴스화 and process call
		String cud = req.getParameter("cud");
		Map<String,Object> cudMap = new HashMap<>();
		HashMapBinder hmb = new HashMapBinder(req);
		hmb.multiBind(cudMap);
		logger.info("cud: "+cudMap.get("cud"));
		try {
			controller = 
					ControllerMapper3.getController(requestName);
;		} catch (Exception e) {
			// TODO: handle exception
		}	
		if(controller!=null) {
			String pageMove[] = null;
			try {
				//Object에 오는 타입이 두 가지 이다. 
				//하나는 ModelAndView 나머지 하나는 String
				Object robj = null;
				if(cudMap.get("cud")==null) {
					logger.info("cud가 null일때 로 처리");
					robj = controller.process(requestName, req, res);
				}
				else {//입력이야? 수정할거니? 삭제하려구해
					logger.info("cud가 null이 아닐때 로 처리");
					robj = controller.process(req, res);					
				}
				//ModelAndView인지 아니면 String인지 찍어보자.
				logger.info("robj : "+robj);
				if(robj instanceof String) {
					pageMove = robj.toString().split(":");
					logger.info("pageMove[0]="+pageMove[0]+", pageMove[1]="+pageMove[1]);
				}
				else if(robj instanceof ModelAndView) {
					ModelAndView mav = (ModelAndView)robj;
					pageMove = new String[2];
					pageMove[0] = "forward";
					pageMove[1] = mav.getViewName();
				}
			} catch (Exception e) {
				logger.info("Exception : "+e.toString());
			}
			//insert here - redirect인 경우와 forward인 경우를 쪼개기
			//힌트 : return "redirect:/member/memberList.mvc3
			if(pageMove !=null) {
				String path =pageMove[1];
				if("redirect".equals(pageMove[0])) {//너 redirect 할거야?
					res.sendRedirect(path);
				}
				else {//너 forward할려구 그래?
					if("forward".equals(pageMove[0])) {
						RequestDispatcher view = 
								req.getRequestDispatcher(path);
						view.forward(req, res);
					}else {
						res.sendRedirect("/error/pageMoveFail.jsp");
					}
				}
			}
		}//////////////////////end of Controller가 널이 아닐때
	}/////////////////////////end of doService/////////////////////////
	public void doGet(HttpServletRequest req
			, HttpServletResponse res)
					throws ServletException, IOException
	{
		logger.info("doGet 호출 성공");
		doService(req,res);
	}
	public void doPost(HttpServletRequest req
			, HttpServletResponse res)
					throws ServletException, IOException
	{
		logger.info("doPost 호출 성공");
		doService(req,res);
	}
}
