package orm.dao;

import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

public class SqlMapEmpDao {
	Logger logger = Logger.getLogger(SqlMapEmpDao.class);
	SqlSessionFactory sqlMapper = null;
	String resource = "orm/mybatis/Configuration.xml"; 
	//INSERT INTO emp VALUES(?,?,?,?,?,?,?,?)
	/**********************************************************************
	 * 사원등록 구현하기
	 * sql문 INSERT INTO emp VALUES(?,?,?,?,?,?,?,?)
	 * @param pMap(사원번호,사원명,job,그룹코드,입사일자,급여,인센티브,부서번호)
	 * @return int
	 *********************************************************************/
	public int empINS(Map<String,Object> pMap) {
		logger.info("empINS 호출");
		int result = 0;
		try {
			Reader reader = Resources.getResourceAsReader(resource); 
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			//sql문을 요청하기 위한  SqlSession객체 생성하기
			SqlSession sqlSes = sqlMapper.openSession();			
			//result=sqlSes.update("empINS2",pMap);
			result=sqlSes.insert("empINS",pMap);
			//오토커밋모드가 꺼진 상태이므로 반드시 커밋 해주어야 함.
			sqlSes.commit();
			logger.info("result:"+result);//executeUpdate():int
		} catch (Exception e) {
			e.printStackTrace();//힌트가 많아
		}
		return result;
	}
	public List<Map<String,Object>> empList(Map<String,Object> pMap){
		logger.info("empList 호출 성공");
		//logger.debug("debug");
		//logger.warn("warn");
		//logger.error("error");
		//logger.fatal("fatal");
		
		List<Map<String,Object>> elist = null;
		try {
			Reader reader = Resources.getResourceAsReader(resource); 
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			//sql문을 요청하기 위한  SqlSession객체 생성하기
			SqlSession sqlSes = sqlMapper.openSession();
			elist = sqlSes.selectList("empList",pMap);
			System.out.println("조회한 로우 수 : "+elist.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return elist;
	}
	public static void main(String args[]) {
		SqlMapEmpDao eDao = new SqlMapEmpDao();
		//eDao.empList(null);
		java.util.Map<String,Object> pMap = new java.util.HashMap<>();
		pMap.put("empno",9010);
		int result = eDao.empINS(pMap);
		System.out.println("result:"+result);
	}
}
