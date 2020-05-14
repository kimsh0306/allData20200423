<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jsp.ch05.Sonata" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>객체의 영역[SCOPE에 관해서-p132_1.jsp]</title>
</head>
<body>
<jsp:useBean id="himCar" scope="request" class="jsp.ch05.Sonata"/>
<%
	String imsi=(String)request.getAttribute("carColor");
	out.print("carColor: "+imsi);
	out.print("<hr>");
	out.print("carColor: "+request.getAttribute("wheelNum"));
%>
</body>
</html>