<%@page import="java.net.*"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>
<%@page trimDirectiveWhitespaces="true"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String clientId = "fzKnHTaXVyoY7OjvxISh"; //애플리케이션 클라이언트 아이디값";
	String clientSecret = "VwrOns36ly"; //애플리케이션 클라이언트 시크릿값";	
	String key = null;
	try{
		String code="0";//키 발급 시 0, 캡차이미지 비교시 1로 셋팅
		String apiURL = "https://openapi.naver.com/v1/captcha/nkey?code=" + code;

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
        
        
        //String responseBody = get(apiURL, requestHeaders);
		URL url = new URL(apiURL);
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
        //System.out.println(responseBody);
        con.setRequestMethod("GET");
        con.setRequestProperty("X-Naver-Client-Id", clientId);
        con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
        //여기까지가 네이버 서버에 나의 요청을 전달하기 끝
        //응답상태 코드 받기
        BufferedReader br = null;
        int responseCode = con.getResponseCode();//200,204,302,404
        //네이버 서버에서 요청에 대한 응답을 성공처리
        if(200==responseCode){
        	br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        }else{
        	br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        }
        String inputLine = null;
        StringBuilder res = new StringBuilder();
        while((inputLine = br.readLine())!=null){
        	res.append(inputLine);
        }
        br.close();
        key = res.toString();
        key = key.substring(8,24);
        String apiURL2 = "https://openapi.naver.com/v1/captcha/ncaptcha.bin?key="+key;//{"key":"fefsdfdsfsdfwer"}
        //아래 코드가 어렵다. 안 해본 사람
        out.print(apiURL2);
	}catch(Exception e){
		e.printStackTrace();
	}
%>