<!-- import도 위로 올려야 한다. -->
<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 
contentType="text/xml로 지정하려면 trimDirectiveWhitespaces="true"를 써줘야 한다.
상단의 공백이 있으면 안되니까.
xml은 공백이 있으면 xml문서로 읽지 못하기 때문이다.
-->

<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>현재시간</title>
</head>
<body>
현재 시간:<%= new Date() %>
</body>
</html>