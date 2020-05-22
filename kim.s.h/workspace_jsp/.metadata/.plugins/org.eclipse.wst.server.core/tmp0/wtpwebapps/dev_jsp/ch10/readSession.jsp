<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//저장된 s_name을 읽는다.
	String s_name = (String)session.getAttribute("s_name");
	out.print(s_name);//null
%>