<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String htest3 = request.getParameter("htest3");    
	Cookie chtest3 = new Cookie("chtest3",htest3);
	chtest3.setMaxAge(60*60);
	response.addCookie(chtest3);
%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문제4</title>
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
		//이렇게 이동하기는 redirect의 특징(유지가 안됨,주소가 바뀜,get방식)
		location.href="test2.jsp";
	}	
	//다음문제로 넘길때
	function next(){
		//수험자가 입력한 답안 저장하기
		var temp = 1;
		for(var i=0;i<document.getElementById("f_test1").cb.length;i++){
			if(document.getElementById("f_test1").cb[i].checked==1){
				document.getElementById("f_test1").htest4.value = temp;
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
<form id="f_test1" method="get" action="send.jsp">
<input type="hidden" name="htest4" value="0">
문제4<br>
Bean의 Scope에 대한 설명으로 틀린 것은?<br>
<input type="checkbox" name="cb" onChange="test(0)">
① page: 기본값이며 그 페이지 내에서만 접근할 수 있다.<br>
<input type="checkbox" name="cb" onChange="test(1)">
② request: forward, include에서 사용가능하다.<br>
<input type="checkbox" name="cb" onChange="test(2)">
③ session: 사용자가 로그인 하면 시간에 제약없이 무한히 유지된다.<br>
<input type="checkbox" name="cb" onChange="test(3)">
④ application: 서버를 재기동하기 전까지는  시간에 제약없이 무한히 유지된다.<br>
</form>
<br>
<button onClick="prev()">이전문제</button>
<button onClick="next()">다음문제</button>
</body>
</html>








