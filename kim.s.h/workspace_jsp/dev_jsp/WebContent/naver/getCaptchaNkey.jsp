<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.net.*" %>
<%
	String clientId = "fzKnHTaXVyoY7OjvxISh"; //애플리케이션 클라이언트 아이디값";
	String clientSecret = "VwrOns36ly"; //애플리케이션 클라이언트 시크릿값";
	try{
        String code = "0"; // 키 발급시 0,  캡차 이미지 비교시 1로 세팅
        String apiUrl = "https://openapi.naver.com/v1/captcha/nkey?code=" + code;		
        ////////////////////////////////////////////////////////////여기까지 변수 선언
        URL url = new URL(apiUrl);
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("X-Naver-Client-Id", clientId);
        con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
        int responseCode = con.getResponseCode();
        BufferedReader br = null;
        if(? == 200){
        	
        }
        else{
        	
        }
        String line = null;
        
	}catch(Exception e){
		out.print(e.toString());
	}
%>