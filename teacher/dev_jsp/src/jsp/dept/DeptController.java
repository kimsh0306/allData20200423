package jsp.dept;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class DeptController extends HttpServlet {
	Logger logger = Logger.getLogger(DeptController.class);
	public void doGet(HttpServletRequest req
			                   , HttpServletResponse res)
	throws ServletException, IOException
	{
		logger.info("doGet 호출 성공");
		DeptDao dDAO = new DeptDao();
		List<Map<String,Object>> deptList = dDAO.deptList(); 
		req.setAttribute("deptList", deptList);
		RequestDispatcher view = 
				req.getRequestDispatcher("jsonDeptList.jsp");
		view.forward(req, res);
	}
}
