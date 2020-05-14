<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>액션 태그 활용</title>
<jsp:include page="../common/bootStrap4UI.jsp" flush="false"/>
<script type="text/javascript">
	function method(){
		alert("method 호출 성공");
	}
</script>
</head>
<body>
	<div class="card" style="width: 18rem;">
	  <img src="img_avatar1.png" class="card-img-top" alt="Card image" style="width:100%">
	  <div class="card-body">
	    <h5 class="card-title">Card title</h5>
	    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
	    <a href="javascript:method()" class="btn btn-primary">Go somewhere</a>
	  </div>
	</div>
</body>
</html>