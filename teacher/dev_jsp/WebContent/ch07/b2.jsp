<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>b2.jsp[a2.jsp에 포함될 내용 포함]</title>
</head>
<body>
첫째<br>
둘째<br>
<%
	String id = request.getParameter("id");
    out.print("id: "+id);
%>
셋째<br>
</body>
</html>