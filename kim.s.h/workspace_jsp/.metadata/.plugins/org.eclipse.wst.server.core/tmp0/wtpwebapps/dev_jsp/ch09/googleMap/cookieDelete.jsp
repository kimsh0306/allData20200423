<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie cookies = new Cookie("name","");
	cookies.setMaxAge(0);
	response.addCookie(cookies);
%>