<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>    
<%
	List<Map<String,Object>> memList = 
			(List<Map<String,Object>>)request.getAttribute("memList");
	if(memList==null){
		memList = new ArrayList<>();
	}
	out.print("memList.size():"+memList.size());
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록(memberLIist3.jsp)-MVC3단계</title>
<%@ include file="../common/jEasyUICommon.jsp" %>
</head>
<body>
    
</body>
</html>