<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.google.gson.Gson" %>    
<%@ page import="java.util.*" %>    
<%
	List<Map<String,Object>> deptList = 
			(List<Map<String,Object>>)request.getAttribute("deptList");
	Gson g = new Gson();
	String imsi = g.toJson(deptList);
	out.print(imsi);//json포맷
%>