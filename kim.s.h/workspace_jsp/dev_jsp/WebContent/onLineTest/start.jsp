<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function start(){
		location.href="test1.jsp";	
	}
	function cdelete(){
		location.href="deleteCookie.jsp";
	}
</script>
</head>
<body>
<br>
<button onClick="deleteCookie.jsp">쿠키삭제</button>
<form method="get" action="test1.jsp">
	<input type="hidden" name="h_no" value="20200515001">
	<input type="hidden" name="h_name" value="이순신">
	<input type="submit" value="시험시작">
</form>

<!--  
버튼 태그 안에서 메소드를 호출해서 이동하는 방법말고
input 태그 type에 submit으로 메소드를 만들지 않고 바로 이동하는 방법이 있다.
-->
</body>
</html>