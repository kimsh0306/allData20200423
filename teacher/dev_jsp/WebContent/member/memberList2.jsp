<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>    
<%
	List<Map<String,Object>> memList = 
			(List<Map<String,Object>>)request.getAttribute("memList");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
<%@ include file="../common/jEasyUICommon.jsp" %>
</head>
<body>
<script type="text/javascript">
	$(document).ready(function(){
		//alert("ready");
		$('#dg_member').datagrid({
		    columns:[[
		        {field:'mem_id',title:'아이디',width:120,align:'center'}
		       ,{field:'mem_name',title:'이름',width:160,align:'center'}
		    ]]
		});		
	});
</script>
<%
if(memList!=null){//검색 결과가 있을때
%>
<table id="dg_member" class="easyui-datagrid" title="회원관리">
    <tbody>
<%
	if(memList.size()>0){//검색 결과가 있을때
%>    
    	<tr>
    		<td>&nbsp;</td><td>&nbsp;</td>
    	</tr>
<%
	}
%>
    </tbody>
</table> 
<%
}
else{//검색 결과가 없을때
%> 
<table id="dg_member2" class="easyui-datagrid" title="회원관리">
	<thead>
	<tr>
		<th data-options="field:'code',width:300, align:'center'">검색 결과가 없습니다.</th>
	</tr>
	</thead>
</table>
<%
	}
%>   
</body>
</html>