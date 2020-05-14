package jsp.dept;

import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import orm.dao.SqlMapDeptDao;

public class DeptDaoVer2{
	Logger logger = Logger.getLogger(DeptDao.class);
	String resource = "orm/mybatis/Configuration.xml";
	//Connection과 관련있다. - 연결통로 확보 - 정보는 resource에서 얻어 온다.
	SqlSessionFactory sqlMapper = null;
	
	public List<Map<String,Object>> deptList(){
		logger.info("deptList 호출");
		List<Map<String,Object>> deptList = null;
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		//IO를 써야 하니까 try catch 안에 쓴다.
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			
			sqlMapper = sqlSessionFactoryBuilder.build(reader);
			//아래의 방식으로 사용해왔지만 위의 방식으로도 가능하다.
			//sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			
			SqlSession sqlSes = sqlMapper.openSession();	//sql문을 요청하기 위한 SqlSession객체 생성하기
			logger.info("커넥션 얻기 성공==> "+sqlSes);
			
			deptList = sqlSes.selectList("deptList");	//로우 값을 하나씩 가져와서 dlist에 담는다.
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deptList;
	}
	
	//테스트하기 위해서 메인메소드를 만든다.
	public static void main(String[] args) {
		DeptDao dd = new DeptDao();
		List<Map<String,Object>> deptList = dd.deptList(null);
		System.out.println(deptList.size());
	}	
}
