<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>b.jsp</title>
</head>
<body>
<!-- 
b에서 b2를 인클루드 처리해 보자 
body 내용 중간에 b2를 만났을 때를 확인해 보자.
-->

내용1<br>
<jsp:include page = "b2.jsp" flush="true"/>
내용3<br>
</body>
</html>