<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.*"%>
<%
//이 페이지는 오로지 json 파일을 만들어 주는 역할
//deptList.do를 부르면 
	
	//request.getAttribute()가 나오면 forward라고 생각해라.
	List<Map<String,Object>> deptList = (List<Map<String,Object>>)request.getAttribute("deptList");

	Gson g = new Gson();
	String imsi = g.toJson(deptList);
	out.print(imsi);//json포맷
	
%>