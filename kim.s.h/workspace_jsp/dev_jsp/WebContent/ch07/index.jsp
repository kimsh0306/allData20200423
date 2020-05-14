<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String menu = null;
	if(request.getParameter("menu")!=null){
		menu = request.getParameter("menu");//intro or login or board
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>온라인 시험 솔루션 개발 Ver1.0</title>
</head>
<!-- 
include 디렉티브를 사용해 보자.
 -->
<body>
	<center>
		<table width="1000px" height="500px">
			<!--===================== top 시작 -->
			<tr>
				<td width="1000px" height="50px">
				<%@include file="top.jsp" %>
				</td>
			</tr>
			<!--===================== top 끝 -->
			
			<!--===================== main 시작 -->
			<tr>
				<td valign="top">
				<table border="1" borderColor="green">
					<tr>
						<td width="250px" height="450">
						<%@include file="menu.jsp" %>
						</td>
						<td width="750px" height="450">
						<%//시작페이지 화면
						if(menu==null || "intro".equals(menu)){
						%>
							<%@include file="intro.jsp" %>
						<%//로그인 화면
						}
						else if("login".equals(menu)){
						
						%>
							<%@include file="login.jsp" %>
						<%//계층형 게시판 화면
						}
						else if("board".equals(menu)){
						
						%>
							<%@include file="board.jsp" %>
						<%
						}
						%>
						</td>
					</tr>
				</table>
				</td>
			</tr>
			<!--===================== main 끝 -->
		</table>
	</center>
</body>
</html>