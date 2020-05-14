package jsp.dept;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.sun.org.apache.bcel.internal.classfile.PMGClass;
import com.util.HashMapBinder;
/*
 * 이제 서블릿이라고 하지 않고 Controller로 칭하겠다.
 */

@WebServlet(urlPatterns = "/dept/deptList.kim")
public class DeptControllerVer2 extends HttpServlet {
	Logger logger = Logger.getLogger(DeptController.class);
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{ 
		logger.info("doGet 호출 성공");
		DeptDaoVer2 dDao = new DeptDaoVer2();
		List<Map<String, Object>> deptList = dDao.deptList();
		req.setAttribute("deptList", deptList);
		
		/*
		화면과 로직을 분리하자.
		프레임워크의 첫 단추.
		
		*/
		ActionForward af = new ActionForward();
		af.setRedirect(false);
		af.setPath("jsonDeptList.jsp");
		if(af!=null) {
			if(af.isRedirect()) {
				res.sendRedirect(af.getPath());
		}
		else {
			RequestDispatcher view = req.getRequestDispatcher(af.getPath());
			view.forward(req, res);
			}
		}	
	}
}
