<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String h_no = request.getParameter("h_no");
	Cookie c_hno = new Cookie("c_hno",h_no);
	c_hno.setMaxAge(60*60);
	c_hno.setPath("/");
	response.addCookie(c_hno);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문제1</title>
<%@ include file="../common/jEasyUICommon.jsp" %>
<script type="text/javascript">
	//수험자가 선택한 답안을 
	function test(dap){
		//alert("당신이 선택한 답안은 "+dap+" 입니다.");
		for(var i=0;i<document.getElementById("f_test1").cb.length;i++){
			if(dap == i){
				document.getElementById("f_test1").cb[i].checked = 1;
			}else{
				document.getElementById("f_test1").cb[i].checked = 0;				
			}
		}
	}
	//다음문제로 넘길때
	function next(){
		//수험자가 입력한 답안 저장하기
		var temp = 1;
		for(var i=0;i<document.getElementById("f_test1").cb.length;i++){
			if(document.getElementById("f_test1").cb[i].checked==1){
				document.getElementById("f_test1").htest1.value = temp;
			}
			else{
				temp = temp + 1;
			}
		}
		//alert("temp:"+temp);
		document.getElementById("f_test1").submit();
		//$("#f_test1")
	}
</script>
</head>
<body>
<form id="f_test1" method="get" action="test2.jsp">
<input type="hidden" name="htest1" value="0">
문제1
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
<br>
<button onClick="next()">다음문제</button>
</body>
</html>








