<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//쿠키에 저장
	String name = request.getParameter("c_name");
	Cookie c_name = new Cookie("name",name);	
	c_name.setMaxAge(60*5);
	c_name.setPath("/ch09/googleMap");
	response.addCookie(c_name);
	out.print(name);
%>