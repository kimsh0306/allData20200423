<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서 목록</title>
<%@include file="../common/jEasyUICommon.jsp" %>

<script type="text/javascript">
	function empList(){
		//alert("조회 버튼 성공"); 
		var u_no = $("#u_no").val();
		alert(u_no);
		$("#dg_dept").datagrid({
			//서버가 name과 name의 값을 기억하는 것이다. name=n_no 값=u_no
			url:"./deptList.do?u_no="+u_no
		});
	}
</script>
</head>
<body>
	
	<script type="text/javascript">
		$(document).ready(function(){
			$("#dg_dept").datagrid({
				 toolbar:'#tb_list'
				,width:'1100px'
				//forward로 넘겨줬기 때문에
				//url은 deptList.do(DeptController)이지만 내용은 jsonDeptList이다. 
				//,url:"./deptList.do"
			    ,columns:[[
			        {field:'DEPTNO',title:'부서번호',width:100},
			        {field:'DNAME',title:'부서명',width:100},
			        {field:'LOC',title:'지역',width:100}
			    ]]
			});
		});
	</script>

	<table id="dg_dept" class="easyui-datagrid" title="부서목록" url="jsonDeptList.jsp"></table>
	<div id="tb_list">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="empList()">조회</a>
		<input id="u_no" type="text"/>
	</div>
</body>
</html>