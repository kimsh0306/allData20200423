<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../common/jEasyUICommon.jsp" %>
<script type="text/javascript">
	var g_key;
	//아래에서 키값이 결정된다.
	function getCaptchaKey(){
		$.ajax({
			 method:"get"
			 //getCaptcaImage.jsp
			,url:"getCaptchaImage.jsp"
			,success:function(result){
				//alert("result:"+result);
				var imsi = result.split("?");
				var key = imsi[1];
				g_key = key.substring(4,20);
				//alert("g_key:"+g_key);
				$("#captchaIMG").attr("src",result);
			}
		});
	}
	//getCaptchaKey함수에서 결정된 키가 여기서 필요함. 그렇다면 전역인가|지변인가
	function captchaAccount(){
		var user = $("#user").val();//사용자가 입력한 값
		$.ajax({
			 method:"get"
			,url:"captchaAccount.jsp?=user"+user+"&key="+g_key
			,success:function(data){
				alert("data:"+data);
				var isOk = JSON.parse(data).result;
				if(isOk == true){
					alert("일치");
				}else{
					alert("불일치");
				}
			}
		});
	}
</script>
</head>
<!-- 첫페이지에서 보고 싶다. -->
<body onLoad="getCaptchaKey()">
<img id="captchaIMG" width="200px" height="90px">
<button onClick="getCaptchaKey()">새로고침</button>
<hr>
<input type="text" name="user" id="user">
<button onClick="captchaAccount()">판정</button>
</body>
</html>