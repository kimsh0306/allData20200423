<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jsp.ch08.Sonata" %>    
<%
	Sonata myCar = new Sonata();
	request.setAttribute("myCar",myCar);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sonataTest</title>
<script type="text/javascript">
	function moveB(){
		location.href="b.jsp";
	}
</script>
</head>
<body>
<%
	out.print(myCar.carColor+", "+myCar.wheelNum);
%>
<button onClick="moveB()">b로 이동</button>
</body>
</html>