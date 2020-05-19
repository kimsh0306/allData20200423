<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.net.URLEncoder" %>
<%
//쿠키 생성하기

	//생성할 쿠키 정보를 담고 있는 Cookie 객체를 생성한다.
	//URLEncoder클래스를 사용해서 쿠키 값을 인코딩한다.
	Cookie cookie = new Cookie("name4", URLEncoder.encode("김혜림","utf-8"));
	//response 기본 객체의 addCookie() 메서드를 사용하여 쿠키를 추가한다.
	//응답 데이터에 쿠키를 추가한다.
	response.addCookie(cookie);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%= cookie.getName() %> 쿠키의 값 = "<%= cookie.getValue() %>"

</body>
</html>