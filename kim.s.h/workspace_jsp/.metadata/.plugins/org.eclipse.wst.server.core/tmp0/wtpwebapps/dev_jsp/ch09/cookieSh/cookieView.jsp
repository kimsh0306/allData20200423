<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function c_make(){
		var name = document.getElementById("u_name").value;
		var val = document.getElementById("u_val").value;
		//alert(name+", "+val);
		location.href="cookieMake.jsp?c_name="+name+"&c_val="+val;
	}
	function c_delete(){
//		제이쿼리로 해보자.
//		$("#id").attr("속성","속성값");
//		js의 내장객체로 해보자.
//		setAttribute("속성","속성값");
//		예를 들자면, <form>태그 안에 사용할 수 있는 속성 action=""을 메소드 안에서 사용하기 위한 방식이다.
		document.getElementById("f_coo").setAttribute("action","cookieDelete.jsp");
		document.getElementById("f_coo").submit();
	}
</script>
</head>
<body>
<form id="f_coo">
	<label>쿠키 이름</label>
	<input type="text" id="u_name" name="u_name"><br>
	<label>쿠키 값</label>
	<input type="text" id="u_val" name="u_val"><br>
</form>
	<button onClick="c_make()">쿠키만들기</button><br>
	<button onClick="c_delete()">쿠키지우기</button> 
</body>
</html>