<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 목록</title>
</head>
<body>

<%
//쿠키 값 읽어오기

	//request.getCookies()메서드는 Cookie 배열을 리턴한다.
	Cookie[] cookies = request.getCookies();
	if(cookies != null&&cookies.length > 0){
		for(int i =0;i<cookies.length;i++){
%>
	<%= cookies[i].getName() %> =
	<!-- 인코딩해서 값을 저장했으므로, 디코딩해서 값을 읽는다. -->
	<%= URLDecoder.decode(cookies[i].getValue(),"utf-8") %><br>
<%			
		}
	}else{
%>
쿠키가 존재하지 않습니다.
<%
	}
%>
</body>
</html>