<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	String c_name = request.getParameter("c_name");
	String c_val = request.getParameter("c_val");
	out.print("name:"+c_name+", "+"val:"+c_val);
	Cookie cookies = new Cookie(c_name, c_val);
	response.addCookie(cookies);
	response.sendRedirect("cookieView.jsp");
%>