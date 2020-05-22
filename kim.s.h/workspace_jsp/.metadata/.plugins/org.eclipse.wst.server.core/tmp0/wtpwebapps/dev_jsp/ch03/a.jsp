<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>a.jsp</title>
</head>
<body>
<%	
	//선언하지 않았지만 문제삼지 않는다. 
	//response.setContentType()로 mimeType을 json으로 설정했기 때문에
	//아래있는 mimeType이 우선한다.
	response.setContentType("application/json;charset=UTF-8");
	String id = request.getParameter("mem_id");
	out.print("테스트");
%>
</body>
</html>