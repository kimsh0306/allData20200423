package com.mvc2;

import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

public class MemberDao {
	Logger logger = Logger.getLogger(MemberDao.class);
	String resource="orm/mybatis/Configuration.xml";
	SqlSessionFactory sqlMapper = null;
	public MemberDao() {
		sqlMapper = MyBatisCommonFactory.getSqlSessionFactory();
	}
	public String login(Map<String, Object> pMap) {
		String s_name = null;
		try {
			Reader reader = Resources.getResourceAsReader(resource); 
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			SqlSession sqlSes = sqlMapper.openSession();
			s_name = sqlSes.selectOne("login",pMap);
			logger.info("s_name"+s_name);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return s_name;
	}
	public List<Map<String, Object>> memberList(Map<String, Object> pMap) {
		logger.info("MemberDao memberList호출 성공");
		List<Map<String, Object>> memList = null;
		try {
			SqlSession sqlSes = sqlMapper.openSession();
			memList = sqlSes.selectList("memberList",pMap);
			logger.info("memList.size()"+memList.size());
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return memList;
	}
	public int memberAdd(Map<String, Object> pMap) {
		logger.info("MemberDao memberAdd호출 성공");
		int result = 0;
		try {
			SqlSession sqlSes = sqlMapper.openSession();
			result = sqlSes.insert("memberAdd",pMap);
			logger.info("result:"+result);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}

}
