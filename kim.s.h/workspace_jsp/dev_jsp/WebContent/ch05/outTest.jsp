<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//서블릿에서는 아래처럼 인스턴스화 해서 사용해야 하지만 여기서는 
	//jsp가 제공하는 기본 객체이기 때문에 바로 사용할 수 있다. 114p
	//PrintWriter out1 = res.getWriter();
	//out1.print("<태그>");
	out.print("<태그>");
	out.print("<br>");
	out.print("줄바뀜");
%>