<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="orm.dao.SqlMapEmpDao" %>    
<%@ page import="java.util.*" %>    
<%@ page import="com.google.gson.*" %>  
<%-- 반드시 jsp주석으로 처리할 것. --%>  
<%
//안녕
//html주석은 사용불가함.-소스보기했을 때 주석이 보이므로 json포맷에 맞지 않음.
	String empno = request.getParameter("empno");
	int iempno = 0;
	if(request.getParameter("empno")!=null){
		iempno = Integer.parseInt(empno);
	}
	SqlMapEmpDao edao = new SqlMapEmpDao();
	Map<String,Object> pmap = new HashMap<>();
	pmap.put("empno",iempno);
	List<Map<String,Object>> elist = edao.empList(pmap);
	Gson g = new Gson();
	String imsi = g.toJson(elist);
	out.print(imsi);
%>