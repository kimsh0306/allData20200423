<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>a2.jsp</title>
</head>
<body>

<!-- html영역 로컬PC의 브라우저가 처리 주체-->
<%
//스크립틀릿 - Tomcat이 처리 주체다.
	String name="김유신";
	out.print("이름:"+name);//결정된 정보인 이순신만 보임
	request.setAttribute("name", name);//request저장소에 기록하기
	RequestDispatcher view = 
	request.getRequestDispatcher("b2.jsp");
	view.forward(request, response);
%>
</body>
</html>