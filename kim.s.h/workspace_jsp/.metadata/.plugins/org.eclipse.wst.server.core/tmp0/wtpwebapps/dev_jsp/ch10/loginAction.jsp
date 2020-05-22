<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="project.restaurant.RestaurantDao" %>    
<%
//mapDesign.html문서에서 사용자가 화면에 입력한 아이디 가져오기
	String mem_id = request.getParameter("mem_id");
//mapDesign.html문서에서 사용자가 화면에 입력한 비번 가져오기
	String mem_pw = request.getParameter("mem_pw");
	//out.print("사용자가 입력한 아이디는 "+mem_id);
	RestaurantDao rdao = new RestaurantDao();
	String data = null;
	data = rdao.login(mem_id, mem_pw);
	//out.print를 해줘야 mapDesing2.jsp의 success:function(text)의  text에 (msg)가 담긴다.
	out.print(data);

%>