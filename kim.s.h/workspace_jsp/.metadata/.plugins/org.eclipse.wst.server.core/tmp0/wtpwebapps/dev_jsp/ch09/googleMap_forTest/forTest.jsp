<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function for_table(){
		var imsi = ""; 
			imsi += '<table border="1px" borderColor="green">'
			imsi += "<tr><td> 1열 </td><td> 2열 </td><td> 3열 </td></tr>"
		for(var i=0;i<3;i++){
			imsi += "<tr><td>"+(i+1)+"</td><td>"+(i+2)+"</td><td>"+(i+3)+"</td></tr>";			
		}
			imsi += '</table>'
		//div의 자식태그에 html 태그로 넣어 준다.
		document.getElementById("tb").innerHTML = imsi;
	}
</script>

</head>
<body>
	<div id="tb">
	테이블자리
	</div>
	<button onclick="for_table()">테이블생성</button>
</body>
</html>