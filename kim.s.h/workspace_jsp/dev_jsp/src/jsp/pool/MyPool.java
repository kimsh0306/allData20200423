package jsp.pool;
import javax.sql.*;
import javax.naming.*;


public class MyPool {
	public static void main(String[] args) {
		try {
			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/dbPool");
			System.out.println(ds);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}
