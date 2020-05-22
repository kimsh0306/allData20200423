<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 에러 페이지 지정하기 143p -->
<%@ page errorPage="/error/viewErrorMessage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파라미터 출력</title>
</head>
<body>

<!-- 
에러 페이지를 지정해 줬고
NullPointerException이 발생하도록 메소드를 만들었다.
에러가 발생하면 viewErrorMessage.jsp로 이동한다.

.toUpperCase() ==> 대문자로 바꿔주세요.
 -->

name 파라미터 값: <%=request.getParameter("name").toUpperCase() %>
</body>
</html>