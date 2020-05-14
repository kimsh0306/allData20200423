<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String menu = null;
	if(request.getParameter("menu")!=null){
		menu = request.getParameter("menu");//intro or login or board
	}
%>

<!-- 
html 위에 자바코드(스크립틀릿)를 배치하자. 
왜냐하면 스크립틀릿의 처리 주체가 톰캣이기 때문에 서버에서 처리되고
html에 대한 처리 주체는 브라우저이기 때문에 로컬에서 처리된다.
스크립틀릿은 선처리 후다운이기 때문이다.
스크립틀릿과 html 사이에는 시점의 문제가 있다. 시차가 있다. 
문제를 발생시키지 않기 위해서 이런 것들을 고려해야 한다.
일단은 맨 위에 작성을 한다.
-->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<!--
(jsp:include) 액션 태그를 사용해 보자  
  -->
<body>
	<center>
		<table width="1000px" height="500px">
			<!--===================== top 시작 -->
			<tr>
				<td width="1000px" height="50px">
				<jsp:include page="a_top.jsp" flush="false"/>
				</td>
			</tr>
			<!--===================== top 끝 -->
			
			<!--===================== main 시작 -->
			<tr>
				<td valign="top">
				<table border="1" borderColor="blue">
					<tr>
						<td width="250px" height="450">
							<jsp:include page="a_menu.jsp"></jsp:include>
						</td>
						
						<td width="750px" height="450">
							<%//시작페이지 화면
							if(menu==null || "intro".equals(menu)){
							%>
								<jsp:include page="a_intro.jsp"/>
							<%//로그인 화면
							}
							else if("login".equals(menu)){
							%>
								<jsp:include page="a_login.jsp"/>
							<%//계층형 게시판 화면
							}
							else if("board".equals(menu)){
							%>
								<jsp:include page="a_board.jsp"/>
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