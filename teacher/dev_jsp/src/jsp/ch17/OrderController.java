package jsp.ch17;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class OrderController {
	Logger logger = Logger.getLogger(OrderController.class);
	OrderDao mDao = new OrderDao();
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		logger.info("execute 호출");
		//너 회원가입할거야?
		if(1==1) {
			
		}
		//너 회원조회할거니?
		else if(1==1) {
			
		}
		//너 회원탈퇴 하려구?
		else if(1==1) {
			
		}
		//너 이사갔다며?
		else if(1==1) {
			
		}
	}

}
