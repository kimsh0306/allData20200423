<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>a2.jsp[include를 action태그로 처리하는 방법]</title>
</head>
<body>
include도 요청을 계속 유지하고 있는 것으로 판단한다.<br>
<br>
첫째<br>
둘째<br>
<jsp:include page="b2.jsp" flush="true">
	<jsp:param value="haha" name="id"/>
</jsp:include>
넷째<br>
다섯째<br>
</body>
</html>