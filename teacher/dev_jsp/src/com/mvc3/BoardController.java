package com.mvc3;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.util.HashMapBinder;

public class BoardController implements Controller2020 {
	Logger logger = Logger.getLogger(BoardController.class);
	String requestName = null;
	BoardLogic bLogic = null;
	public BoardController(String requestName) {
		this.requestName = requestName;//유지|공유
		bLogic = new BoardLogic();
	}
	/*************************************************************
	 * @param ActionSupport에서 넘겨 준 주소번지를 사용함.
	 * @return String
	 * 예시) "redirect:XXX.jsp"하거나 , forward:XXX.jsp"하면 됨.
	 ************************************************************/
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("process:String 호출 성공");
		String path = null;
		//너 조회버튼 누른거야?
		if("boardList".equals(requestName)) {
			List<Map<String,Object>> mList = null;
			Map<String,Object> pMap = new HashMap<>();
			
			mList = bLogic.boardList(pMap);
			//mList = bLogic.proc_boardList(pMap);
			req.setAttribute("boardList", mList);
			path = "forward:list.jsp";//pageMove[]
		}
		//너 제목을  클릭했을때?
		else if("boardDetail".equals(requestName)) {
			List<Map<String,Object>> mList = null;
			Map<String,Object> pMap = new HashMap<>();
			pMap.put("bm_no",req.getParameter("bm_no"));
			mList = bLogic.boardList(pMap);
			//mList = bLogic.proc_boardList(pMap);
			req.setAttribute("boardDetail", mList);
			path = "forward:read.jsp";//pageMove[]
		}
		//updateView.mvc3
		else if("updateView".equals(requestName)) {
			logger.info("updateView 호출 성공");
			List<Map<String,Object>> mList = null;
			Map<String,Object> pMap = new HashMap<>();
			pMap.put("bm_no",req.getParameter("bm_no"));
			mList = bLogic.boardList(pMap);
			//mList = bLogic.proc_boardList(pMap);
			req.setAttribute("updateView", mList);
			path = "forward:boardUpdForm.jsp";//pageMove[]
		}
		//너 입력하려구?
		else if("boardINS".equals(requestName)) {
			int result =0; 
			Map<String,Object> pMap = new HashMap<>();
			HashMapBinder hmb = new HashMapBinder(req);
			hmb.multiBind(pMap);
			result = bLogic.boardINS(pMap);
			if(result==1) path="redirect:boardInsOk.jsp";
			else if(result ==0) path="redirect:boardInsFail.jsp";
		}
		//너 수정하려구?
		else if("boardUPD".equals(requestName)) {
			int result =0;
			Map<String,Object> pMap = new HashMap<>();
			result = bLogic.boardUPD(pMap);
			if(result==1) path="redirect:boardUpdOk.jsp";
			else if(result ==0) path="redirect:boardUpdFail.jsp";			
		}
		//너 삭제하려구?
		else if("boardDEL".equals(requestName)) {
			int result =0;
			Map<String,Object> pMap = new HashMap<>();
			pMap.put("bm_no", req.getParameter("bm_no"));
			result = bLogic.boardDEL(pMap);
			if(result==1) path="redirect:boardDelOk.jsp";
			else if(result ==0) path="redirect:boardDelFail.jsp";			
		}
		
		return path;
	}

	@Override
	public ModelAndView process(String work, HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		logger.info("process:ModelAndView 호출 성공");
		return null;
	}
	@Override
	public String process(Map<String, Object> cudMap, HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		logger.info("process cudMap:String 호출 성공");
		String path = null;
		//너 조회버튼 누른거야?
		if("boardList".equals(requestName)) {
			List<Map<String,Object>> mList = null;
			//Map<String,Object> pMap = new HashMap<>();
			mList = bLogic.boardList(cudMap);
			//mList = bLogic.proc_boardList(pMap);
			req.setAttribute("boardList", mList);
			path = "forward:list.jsp";//pageMove[]
		}
		//너 제목을  클릭했을때?
		else if("boardDetail".equals(requestName)) {
			List<Map<String,Object>> mList = null;
			//Map<String,Object> pMap = new HashMap<>();
			cudMap.put("bm_no",req.getParameter("bm_no"));
			mList = bLogic.boardList(cudMap);
			//mList = bLogic.proc_boardList(pMap);
			req.setAttribute("boardDetail", mList);
			path = "forward:read.jsp";//pageMove[]
		}
		//updateView.mvc3
		else if("updateView".equals(requestName)) {
			logger.info("updateView 호출 성공");
			List<Map<String,Object>> mList = null;
			//Map<String,Object> pMap = new HashMap<>();
			cudMap.put("bm_no",req.getParameter("bm_no"));
			mList = bLogic.boardList(cudMap);
			//mList = bLogic.proc_boardList(pMap);
			req.setAttribute("updateView", mList);
			path = "forward:boardUpdForm.jsp";//pageMove[]
		}
		//너 입력하려구?
		else if("boardINS".equals(requestName)) {
			int result =0; 
			//Map<String,Object> pMap = new HashMap<>();
			result = bLogic.boardINS(cudMap);
			if(result==1) path="redirect:boardInsOk.jsp";
			else if(result ==0) path="redirect:boardInsFail.jsp";
		}
		//너 수정하려구?
		else if("boardUPD".equals(requestName)) {
			int result =0;
			//Map<String,Object> pMap = new HashMap<>();
			result = bLogic.boardUPD(cudMap);
			if(result==1) path="redirect:boardUpdOk.jsp";
			else if(result ==0) path="redirect:boardUpdFail.jsp";			
		}
		//너 삭제하려구?
		else if("boardDEL".equals(requestName)) {
			int result =0;
			//Map<String,Object> pMap = new HashMap<>();
			cudMap.put("bm_no", req.getParameter("bm_no"));
			result = bLogic.boardDEL(cudMap);
			if(result==1) path="redirect:boardDelOk.jsp";
			else if(result ==0) path="redirect:boardDelFail.jsp";			
		}
		
		return path;
	}

}
