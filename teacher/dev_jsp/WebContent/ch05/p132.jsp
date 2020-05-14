<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jsp.ch05.Sonata" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>객체의 영역[SCOPE에 관해서]</title>
</head>
<body>
<jsp:useBean id="himCar" scope="request" class="jsp.ch05.Sonata"/>
<%
	out.print(himCar.carColor);
	request.setAttribute("carColor", himCar.carColor);
	request.setAttribute("wheelNum", 4);
	RequestDispatcher view = request.getRequestDispatcher("p132_1.jsp");
	view.forward(request, response);
%>
</body>
</html>