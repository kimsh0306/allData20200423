<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>표현언어</title>
</head>
<body>
<!-- 
url에 파라미터 a, b를 입력하고 결과값을 확인했다.
http://localhost:5000/ch03/elTest.jsp?a=10&b=2 
-->

	a*b=${param.a * param.b}
</body>
</html>