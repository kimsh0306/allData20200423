package com.mvc3;

import org.apache.log4j.Logger;

public class ControllerMapper3 {
	public static Controller2020 getController(String command) {
		Logger logger = Logger.getLogger(ControllerMapper3.class);
		logger.info("command:"+command);
		Controller2020 controller = null;
		String commands[] = command.split("/");
		for(String str:commands) {
			logger.info("str: "+str);
		}
		if(commands.length==2) {
			String work = commands[0];
			logger.info("commands[1]:"+commands[1]);
			String requestName = commands[1];
			if("member".equals(work)) {
				logger.info("work: "+work);
				controller = new MemberController3(requestName);
			}
			//계층형 게시판 컨트롤러 생성하기
			else if("board".equals(work)) {
				logger.info("board: "+work);
				controller = new BoardController(requestName);
				
			}
		}
		return controller;
	}////////////////end of Controller
}
