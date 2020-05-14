package jsp.dept;

import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

public class DeptDao {
	Logger logger = Logger.getLogger(DeptDao.class);
	String resource = "orm/mybatis/Configuration.xml";
	//Connection - 연결통로 확보 -  resource
	SqlSessionFactory sqlMapper = null;
	public List<Map<String,Object>> deptList(){
		logger.info("deptList 호출");
		List<Map<String,Object>> deptList = null;
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder
		=new SqlSessionFactoryBuilder();
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			sqlMapper =  sqlSessionFactoryBuilder.build(reader); 
			SqlSession sqlSes = sqlMapper.openSession();
			//logger.info("커넥션 얻기 성공===>"+sqlSes);
			deptList = sqlSes.selectList("deptList");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deptList;
	}
	public static void main(String args[]) {
		DeptDao dd = new DeptDao();
		List<Map<String,Object>> deptList=dd.deptList();
		System.out.println(deptList.size());
	}
}
