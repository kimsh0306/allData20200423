<%@page import="jsp.ch05.Sonata"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>객체의 영역[SCOPE에 관해서]</title>
</head>
<body>

<!-- 스코프를 사용하는 방법은? useBean 태그 안에서 속성으로 -->
<jsp:useBean id="himCar" scope="request" class="jsp.ch05.Sonata">
</jsp:useBean>

<%
	//형변환은 받아주는 쪽으로 맞춰 준다.
	//값을 꺼낼 때 사용하는 메소드
	String imsi = (String)request.getAttribute("carColor");
	out.print("carColor:"+imsi);
	out.print("<hr>");
	out.print("wheelNum:"+request.getAttribute("wheelNum"));

%>
</body>
</html>