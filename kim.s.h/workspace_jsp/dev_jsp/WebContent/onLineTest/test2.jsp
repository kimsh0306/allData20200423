<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문제2</title>
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
	//이전문제로 이동하기
	function prev(){
		//이렇게 이동하는 것은 성격이 주소가 바뀌는 것이기 때문에 redirect이다.
		//redirect의 특징은 유지가 되지 않는다.주소가 바뀐다.get방식이다.
		location.href="test1.jsp";
	}
	//다음문제로 넘길때
	function next(){
		//다음버튼을 눌렀을 때 수험자가 입력한 답안 저장하기
		var temp = 1;
		for(var i=0;i<document.getElementById("f_test1").cb.length;i++){
			if(document.getElementById("f_test1").cb[i].checked==1){
				document.getElementById("f_test1").htest2.value = temp;
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
<form id="f_test1" method="get" action="test3.jsp">
<!--  
hidden 복습하기.

request는 자바의 것.

다음문제 버튼 눌렀을 때 값을 넘긴다.
test3.jsp?htest1=3&htest2=1
-->
<input type="hidden" name="h_no" value=<%=request.getParameter("h_no") %>>
<input type="hidden" name="h_name" value=<%=request.getParameter("h_name") %>>
<input type="hidden" name="htest1" value="<%= request.getParameter("htest1") %>">
<input type="hidden" name="htest2" value="0">
문제2<br>
조회한 결과를 DB서버에서 가져온 후 결과를 List에 담았다.<br>
이것을 화면단에 출력(유지)하고자 할 때 사용할 메소드 이름은 무엇인지 고르시오.<br>
<input type="checkbox" name="cb" onChange="test(0)">
① forward(request, response)<br>
<input type="checkbox" name="cb" onChange="test(1)">
② sendRedirect("페이지 이름")<br>
<input type="checkbox" name="cb" onChange="test(2)">
③ toString()<br>
<input type="checkbox" name="cb" onChange="test(3)">
④ print()<br>
</form>
<br>
<button onClick="prev()">이전문제</button>
<button onClick="next()">다음문제</button>
</body>
</html>








