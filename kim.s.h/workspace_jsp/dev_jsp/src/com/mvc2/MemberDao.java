package com.mvc2;

import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import orm.dao.SqlMapEmpDao;

public class MemberDao {
	Logger logger = Logger.getLogger(SqlMapEmpDao.class);
	String resource = "orm/mybatis/Configuration.xml";
	SqlSessionFactory sqlMapper = null;

	public String login(Map<String, Object> pMap) {
		String s_name = null;
		
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			SqlSession sqlSes = sqlMapper.openSession();
			
			//로그인된 유저의 이름을 반환해 준다.
			//selectList가 아니라 selectOne!! 반환값은 String!!
			s_name = sqlSes.selectOne("login", pMap);	
			
			logger.info("s_name: "+s_name);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return s_name;		
	}

	public List<Map<String, Object>> memberList(Map<String, Object> pMap) {
		logger.info("MemberDao memberList 호출 성공");
		List<Map<String, Object>> memList = null;
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			SqlSession sqlSes = sqlMapper.openSession();	
			memList = sqlSes.selectList("memList", pMap);			
			logger.info("memList.size()"+memList.size());
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return memList;
	}
}
