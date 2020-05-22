<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키생성하기[경로,시간]</title>
</head>
<body>
<%
/*
쿠키는 어디에 저장하는 것인가? 로컬PC에 하는 것이다.
쿠키를 생성한 다음 응답처리를 해야 한다.
response.addCookie(notebook); 
이 과정이 빠지면 쿠키를 읽을 수 없다.
읽기를 하기 위해서 사용하는 것이 배열.
쿠키 배열에 그 값을 읽어서 처리해야 세 가지 정보에 접근할 수 있다.
"삼성노트북" 값에 공백을 주면 500번 오류가 났다.
*/
	Cookie notebook = new Cookie("notebook","삼성노트북");
	//사용자에게 내려보낼 때
	response.addCookie(notebook);//경로가 ch09폴더에서 읽을 수 있음. ch09-1에서 불가.
	
	Cookie hp = new Cookie("hp","휴렛팩커드");
	hp.setMaxAge(60);
	//디폴트가 현재경로이기 때문에 이렇게 ("") 생략해도 적용된다.
	hp.setPath("/ch09");
	response.addCookie(hp);//읽을 수 있음. ch09-1에서 불가.
	
	Cookie coffee = new Cookie("coffee","아이스아메리카노");
	coffee.setMaxAge(80);
	//("/") ==> dev_jsp경로를 바라보게 된다. == 루트 밑에서는 어디서든 읽을 수 있다.
	//[ch09],[ch09-1] 폴더에서 다 읽을 수 있다.
	coffee.setPath("/");//읽기 가능. ch09-1에서 가능.***********
	response.addCookie(coffee);
%>
</body>
</html>