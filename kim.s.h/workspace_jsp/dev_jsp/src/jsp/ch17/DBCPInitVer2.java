package jsp.ch17;

import java.sql.DriverManager;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.apache.log4j.Logger;
/*
 * servlet으로 정의한 클래스를 web.xml문서에 등록하는 것만으로
 * 서버 기동 시 해당 객체를 주입받을 수 있다.
 * xml 문서에 작성한 값들을 자바 코드에서 사용할 수 있다.
 * 이때 내가 직접 객체를 생성하는 것이 아니라 xml문서에 미리 선언해 두면 
 * 톰캣이 내가 필요로 할 때 대신 주입해 준다. => 이것을 제어역전이라고 칭한다.
 * 
 * loC(Inversion Of Control)
 * :적절한 위치에서 톰캣에게 위임하여 처리하는 방식
 * 기존의 전통적인 개발 방식
 * :적절한 위치에서 개발자가 개발 코드를 이용해서 필요한 객체를 생성해서
 * 사용하는 방식
 * 
 * loC의 개념을 적용함으로 인해 얻을 수 있는 장점은?
 * :객체 간의 결합도를 떨어뜨릴 수 있음.
 * 
 * 제어:객체에 대한 제어를 의미
 * 
 * 결합도:
 * :소프트웨어 코드의 한 요소가 다른 것과 얼마나 강력하게 연결되어 있는지를 나타냄.
 * 
 * 
 */
public class DBCPInitVer2 extends HttpServlet {
	Logger logger = Logger.getLogger(DBCPInit.class);
	@Override
	public void init() throws ServletException {
		logger.info("init 호출 성공");
		loadJDBCDriver();
		initConnectionPool();
	}

	private void loadJDBCDriver() {
		String _DRIVER = getInitParameter("jdbcdriver");
		try {
			Class.forName(_DRIVER);
		} catch (ClassNotFoundException ex) {
			throw new RuntimeException("fail to load JDBC Driver", ex);
		}
	}

	private void initConnectionPool() {
		try {
			//web.xml의 <param-name>
			String jdbcUrl = getInitParameter("jdbcUrl");
			String username = getInitParameter("username");
			String pw = getInitParameter("pw");

			ConnectionFactory connFactory = 
					new DriverManagerConnectionFactory(jdbcUrl, username, pw);

			PoolableConnectionFactory poolableConnFactory = 
					new PoolableConnectionFactory(connFactory, null);
			poolableConnFactory.setValidationQuery("select 1");

			GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
			poolConfig.setTimeBetweenEvictionRunsMillis(1000L * 60L * 5L);
			poolConfig.setTestWhileIdle(true);
			poolConfig.setMinIdle(4);
			poolConfig.setMaxTotal(50);

			GenericObjectPool<PoolableConnection> connectionPool = 
					new GenericObjectPool<>(poolableConnFactory, poolConfig);
			poolableConnFactory.setPool(connectionPool);
			
			Class.forName("org.apache.commons.dbcp2.PoolingDriver");
			PoolingDriver driver = 
					//getDriver => 어떤 회사 제품인지 알 수 있다. 이 부분 관심있게 봐야한다.
					(PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");
					//그 드라이버의 그 풀의 이름을 등록해라.
			String poolName = getInitParameter("poolName");
			driver.registerPool(poolName, connectionPool);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

