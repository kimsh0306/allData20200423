<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String h_no = request.getParameter("h_no");
	Cookie c_hno = new Cookie("c_hno",h_no);
	c_hno.setMaxAge(60*60);
	
	//담은 것을 꺼낼 때
	c_hno.getName();//c_hno
	c_hno.getValue();//h_no => 여기가 수험번호이다.
	
	response.addCookie(c_hno);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문제1</title>
<%@ include file="../common/jEasyUICommon.jsp" %>
<script type="text/javascript">
	function test(dap){
		//처음에는 다중 체크가 됐던 상태에서 내가 체크한 박스만 체크가 되고 다른 박스는 체크되지 않도록 만드는 메소드
		//한 개를 체크하면 1, 나머지는 0이 된다.
		for(var i=0;i<document.getElementById("f_test1").cb.length;i++){
			if(dap == i){
				document.getElementById("f_test1").cb[i].checked=1;
			}else{
				document.getElementById("f_test1").cb[i].checked=0;
			}
		}
	}
	/*
	document => form접근: getElementById("f_test1") => htest1.value = 여기 값은 temp에 담았다.
	*/
		
	//다음 문제로 넘길 때
	function next(){
		//getElementById()는 document객체에서 제공하는 함수.
		//다음버튼을 눌렀을 때 수험자가 입력한 답안 저장하기
		var temp = 1;
		for(var i=0;i<document.getElementById("f_test1").cb.length;i++){
			if(document.getElementById("f_test1").cb[i].checked == 1){
				document.getElementById("f_test1").htest1.value = temp;
			}
			else{
				temp = temp+1;
			}
		}
		//다음버튼을 눌렀을 때 temp 값 확인하기.
		//alert("temp:"+temp);
		
		//폼 전송이 일어날 수 있도록 submit()메소드를 호출.
		//네임과 값이 Map에 담기듯이 담겨서 서버로 전송된다.
		document.getElementById("f_test1").submit();
		
// 		위 문장을 제이쿼리에서는 어떻게 쓸까?
// 		$("#f_test1")

		}
</script>
</head>
<body>
<form id="f_test1" method="get" action="test2.jsp">
<input type="hidden" name="htest1" value="0">
문제1<br>
서블릿 메소드의 호출 순서로 맞는 것은?<br>

<!-- 1번을 체크하면 => 파라미터에 1을 담아서  test(1) 메소드를 호출한다. -->
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
<button onClick="javascript:next()">다음문제</button>
</body>
</html>