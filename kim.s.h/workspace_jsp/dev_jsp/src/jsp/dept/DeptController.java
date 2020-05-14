package jsp.dept;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.util.HashMapBinder;
/*
 * 이제 서블릿이라고 하지 않고 Controller로 칭하겠다.
 */
public class DeptController extends HttpServlet {
	Logger logger = Logger.getLogger(DeptController.class);
	
	public void doService(HttpServletRequest req ,HttpServletResponse res) throws ServletException, IOException
	{
		//
		Map<String,Object> pMap = new HashMap<>();
		
		//서버가 name 값을 알고 있으니까 톰캣 서버가 주입한 req 객체를 통해서 name 값을 가져와 보자.
		String u_no = req.getParameter("u_no");
		
		//DAO에 보낼 Map
		pMap.put("u_no", u_no);
		
		//HashMapBinder binder = new HashMapBinder(req);
		//binder.binder(pMap);
		
		DeptDao dDao = new DeptDao();
		
		//사용자가 입력한 값을 담은 pMap을 파라미터로 보내면서
		//DAO에 가서 deptList를 가져왔다.
		List<Map<String,Object>> deptList = dDao.deptList(pMap);
		
		//pMap을 request에 attribute속성으로 저장해 준다.
		//Attribute는 Map이라고 생각하면 된다.
		//request 내장 객체에 [key:"deptList",value:deptList]를 담았다는 것이다.
		req.setAttribute("deptList", deptList);
		
		//바뀔 내용의 url을 설정한다.
		//url값을 가지고 RequestDispatcher를 생성한 것이다.
		//req.getRequestDispatcher를 가지고 RequestDispatcher를 생성했다는 의미도 된다.
		RequestDispatcher view = req.getRequestDispatcher("./jsonDeptList.jsp");
		
		//url이 유지된다는 건 요청의 흐름이 유지된다는 것이다.
		//forward => url은 그대로이고 내용만 바뀐다.
		//위에서 설정한 url로 내용을 바꿔 줘!
		view.forward(req, res);
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{ 
		logger.info("doGet 호출 성공");
		doService(req,res);
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{ 
		logger.info("doPost 호출 성공");
		doService(req,res);
	}
}
