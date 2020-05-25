<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키생성하기[경로, 시간]</title>
</head>
<body>
<%
	Cookie notebook = new Cookie("notebook","삼성노트북");
	response.addCookie(notebook);// ch09 - 읽을 수 있음, 불가
	Cookie hp = new Cookie("hp","아이폰12");
	hp.setMaxAge(60);
	hp.setPath("/ch09");
	response.addCookie(hp);//읽을 수 있음, 불가
	Cookie coffee = new Cookie("coffee","아이스아메리카노");
	coffee.setMaxAge(80);
	coffee.setPath("/");//읽기가능, 가능
	response.addCookie(coffee);
%>
</body>
</html>