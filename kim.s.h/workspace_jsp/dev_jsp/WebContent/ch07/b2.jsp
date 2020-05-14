<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>b2.jsp[a2.jsp에 포함될 내용 포함]</title>
</head>
<body>
b_첫째<br>
b_둘째<br>
<%
	String id = request.getParameter("id");
	out.print("id: "+id);
%>
b_셋째<br>
</body>
</html>