<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String pbm_no = request.getParameter("bm_no");
	String pbm_pw = request.getParameter("bm_pw");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글삭제</title>
</head>
<body>
	<div style="margin-bottom:20px">
		<input id="u_pw" name="u_pw" class="easyui-textbox" label="비밀번호:" style="width:200px;height:25px">
	</div>
</body>
</html>