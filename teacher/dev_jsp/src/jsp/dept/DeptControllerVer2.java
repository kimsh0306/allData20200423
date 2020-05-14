package jsp.dept;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet(urlPatterns="/dept/deptList.km")
public class DeptControllerVer2 extends HttpServlet {
	Logger logger = Logger.getLogger(DeptController.class);
	public void doGet(HttpServletRequest req
			                   , HttpServletResponse res)
	throws ServletException, IOException
	{
		logger.info("doGet 호출 성공");
		DeptDao dDAO = new DeptDao();
		List<Map<String,Object>> deptList = dDAO.deptList(); 
		req.setAttribute("deptList", deptList);
		//insert here
		ActionForward af = new ActionForward();
		af.setRedirect(false);
		af.setPath("jsonDeptList.jsp");
		if(af !=null) {
			if(af.isRedirect()) {
				res.sendRedirect(af.getPath());
			}
			else {
				RequestDispatcher view = 
						req.getRequestDispatcher(af.getPath());
				view.forward(req, res);
			}
		}
	}
}
