<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = request.getParameter("u_name");
	Cookie cookies = new Cookie(name,"");
	cookies.setMaxAge(0);
	response.addCookie(cookies);
	response.sendRedirect("cookieView.jsp");
%>