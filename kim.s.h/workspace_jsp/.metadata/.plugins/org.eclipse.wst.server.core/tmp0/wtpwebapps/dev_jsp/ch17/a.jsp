<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>a.jsp</title>
</head>
<body>
<!-- html영역은 로컬 PC의 브라우저가 처리 주체이다. -->
<%
//스크립틀릿 영역의 주체는? Tomcat이 처리 주체이다.
	String name = "이순신";
	//결정된 정보인 이순신만 보인다. 자바코드는 보이지 않는다. 처리가 톰캣 안에서 끝났다는 것이다.
	out.print("이름:"+name);
	response.sendRedirect("b.jsp");
%>
</body>
</html>