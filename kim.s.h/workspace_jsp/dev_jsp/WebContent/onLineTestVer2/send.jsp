<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String htest4 = request.getParameter("htest4");
	Cookie chtest4 = new Cookie("chtest4", htest4);
	chtest4.setMaxAge(60*60);
	response.addCookie(chtest4);
%>

<form method="get" action="account.jsp">
	<input type="hidden" name="htest4" value="<%= htest4 %>">
	<input type="submit" value="채점하기">
</form>