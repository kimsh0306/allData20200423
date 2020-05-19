<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.net.*" %>    
<%
	String clientId = "5NNeHasY7KCWoMGm0suJ"; //애플리케이션 클라이언트 아이디값";
	String clientSecret = "4zvlywLkoc"; //애플리케이션 클라이언트 시크릿값";
	try{
		String code = "0"; // 키 발급시 0,  캡차 이미지 비교시 1로 세팅
        String apiUrl = "https://openapi.naver.com/v1/captcha/nkey?code=" + code;
        URL url = new URL(apiUrl);
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("X-Naver-Client-Id", clientId);
        con.setRequestProperty("X-Nave0r-Client-Secret", clientSecret);        
		int responseCode = con.getResponseCode();
		BufferedReader br = null;
		if(responseCode == 200){
			br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		}
		else{
			br = new BufferedReader(new InputStreamReader(con.getErrorStream()));			
		}
		String line = null;
		StringBuffer sb_line = new StringBuffer();
		while((line=br.readLine()) !=null){
			sb_line.append(line);
		}
		//사용한 자원 반납하기
		br.close();
		out.println(sb_line.toString());//{"key":""}
	}catch(Exception e){
		out.print(e.toString());
	}
%>









