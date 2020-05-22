<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>b.jsp[a.jsp에 포함될 내용 포함]</title>
</head>
<body>
b_첫째<br>
b_둘째<br>
<%
	out.print("id: "+id);
	//map과 비슷하다.
	request.setAttribute("mem_name", "이순신");
%>
b_셋째<br>
</body>
</html>