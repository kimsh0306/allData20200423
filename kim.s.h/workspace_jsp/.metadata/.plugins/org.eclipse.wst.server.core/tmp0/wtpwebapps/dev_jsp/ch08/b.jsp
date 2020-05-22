<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jsp.ch08.Sonata" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
// 	Sonata myCar = new Sonata();
// 	request.getAttribute("myCar");
//	아래와 같이 다른 방식으로 쓸 수도 있다.

	Sonata myCar = (Sonata)request.getAttribute("myCar");
	out.print("myCar: "+myCar);
%>
</body>
</html>