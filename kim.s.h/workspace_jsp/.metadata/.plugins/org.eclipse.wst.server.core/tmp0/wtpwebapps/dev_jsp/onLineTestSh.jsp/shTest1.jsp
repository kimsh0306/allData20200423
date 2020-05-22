<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test1</title>
<%@include file="../common/jEasyUICommon.jsp" %>
<script type="text/javascript">
	function test(dap){
		for(var i=0;i<document.getElementbyId("f_test").cb.lenght;i++){
			if(dap==i){
				document.getElementById("f_test").cb[i].checked=1;
			}else{
				document.getElementById("f_test").cb[i].checked=0;
			}
		}
	}
	function next(){
		var temp = 1;
		for(var i=0;i<document.getElementById("f_test").cb[i].length;i++){
			if(document.getElementById("f_test").cb[i].checked==1){
				document.getElementById("f_test").htest1.value = temp;
			}
			else{
				temp = temp+1;
			}
		}
		document.getElementById("f_test").submit();
	}
</script>

</head>
<body>
<form id="f_test" action="shTest2.jsp" method="get">
<input type="hidden" name="h_no" value="<%=request.getParameter("h_no") %>">
<input type="hidden" name="h_name" value="<%=request.getParameter("h_name") %>">
<input type="hidden" name="h_test1" value="0">
문제1<br>
서블릿 메소드의 호출 순서로 맞는 것은?<br>

<input type="checkbox" name="cb" onChange="test(0)">
① init() - service() - destroy()<br>

<input type="checkbox" name="cb" onChange="test(1)">
② service() - destroy() - init()<br>

<input type="checkbox" name="cb" onChange="test(2)">
③ destroy() - init() - service()<br>

<input type="checkbox" name="cb" onChange="test(3)">
④ doGet() - destroy() - init() - service()<br>

</form>
<button onClick="next()">다음문제</button>

</body>
</html>