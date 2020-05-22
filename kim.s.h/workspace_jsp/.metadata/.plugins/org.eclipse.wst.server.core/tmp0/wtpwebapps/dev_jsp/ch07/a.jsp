<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>a.jsp[include를 action태그로 처리하는 방법]</title>
</head>
<body>
include도 요청을 계속 유지하고 있는 것으로 판단한다.<br>
클래스가 두 개 생긴다.<br>
	a_jsp.class<br>
	b_jsp.class<br>
<br>
첫째<br>
둘째<br>
<jsp:include page="b.jsp"/>
넷째<br>
다섯째<br>
<%
	String id = "test";
	String name = (String)request.getAttribute("mem_name");
	out.print("name: "+name);
	out.print("<br>");
%>
</body>
</html>