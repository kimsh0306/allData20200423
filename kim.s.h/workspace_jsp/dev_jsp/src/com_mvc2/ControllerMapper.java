package com_mvc2;

import org.apache.log4j.Logger;

public class ControllerMapper {
/*
ControllerMapper의 역할은?
*/
	//인터페이스를 객체 주입해줄 수 있는 메소드
	public static Controller getController(String command, String crud) {
		Logger logger = Logger.getLogger(ControllerMapper.class);
		logger.info("command:"+command+", crud"+crud);
		
		
		Controller controller = null;
		
		
		//member/memberlist.mvc2
		String commands[] = command.split("/");
		
		//배열 안에 뭐가 들었는지 찍어보자
		for(String str:commands) {
			logger.info("str:"+str);
		}
		if(commands.length==2) {
			//업무 부서이름
			String work = commands[0];
			//실제 업무이름
			String requestName = commands[1];
			if("member".equals(work)) {
				
				
				//command별로 업무를 처리할 구현체 클래스를 생성하면서 crud를 파라미터로 넘겨 준다.***
				controller = new MemberController(crud);
			
			
			}
			else if("order".equals(work)) {
				//controller = new OrderController(crud);
			}
		}
		
		return controller;
	}///////////////////////end of getController
}
