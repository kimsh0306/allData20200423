package com.mvc2;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class MemberLogic {
	Logger logger = Logger.getLogger(MemberLogic.class);
	
	MemberDao mDao = new MemberDao();
	
	public String login(Map<String,Object> pMap) {
		String s_name = mDao.login(pMap);
		return s_name;
	}
	public List<Map<String, Object>> memberList(Map<String, Object> pMap) {
		logger.info("MemberLogic memberList 호출 성공");
		List<Map<String, Object>> memList = null;
		memList = mDao.memberList(pMap);
		return memList;
	}
	
}
