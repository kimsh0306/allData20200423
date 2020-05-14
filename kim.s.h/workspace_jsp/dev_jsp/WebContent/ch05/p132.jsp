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

<!-- 
forward 방식 
p132를 실행하면 url은 변하지 않고
p132_1의 내용이 보여진다.
교재 135p 참고
-->

<!-- 스코프를 사용하는 방법은? useBean 태그 안에서 속성으로 -->
<jsp:useBean id="himCar" scope="request" class="jsp.ch05.Sonata">
</jsp:useBean>

<%
// 	//이런 경우에는 스코프를 사용할 수 없다.
// 	Sonata myCar = new Sonata();
// 	out.print(myCar.carColor);

	out.print(himCar.carColor);
	//이름으로 주소번지를 저장할 수 있다.
	//두 개 이상 담을 수 있다.
	request.setAttribute("carColor", himCar.carColor);
	request.setAttribute("wheelNum", 4);
	
	RequestDispatcher view = request.getRequestDispatcher("p132_1.jsp");
	view.forward(request, response);

%>
</body>
</html>