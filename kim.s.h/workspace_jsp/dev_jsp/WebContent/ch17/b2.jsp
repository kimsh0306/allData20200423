<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>b2.jsp</title>
</head>
<body>
<%
// 	request.getAttribute("name");
// 	out.print(request.getAttribute("name"));
	
	String name = (String)request.getAttribute("name");
	out.print("이름:  "+name);
	
%>
</body>
</html>