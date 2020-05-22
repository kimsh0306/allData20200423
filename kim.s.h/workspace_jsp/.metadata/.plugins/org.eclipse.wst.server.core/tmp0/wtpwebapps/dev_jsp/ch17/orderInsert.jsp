<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>orderInsert.jsp</title>
</head>
<body>
<form method="post" action="/ch17/orderInsert.do">
	<input type="text" name="mem_name">
	<!-- type="submit" ==> 버튼을 만들 필요 없이 즉시 전송이 일어난다. -->
	<input type="submit" value="전송">
	<input type="button" value="전송" onClick="send();">
</form>
</body>
</html>