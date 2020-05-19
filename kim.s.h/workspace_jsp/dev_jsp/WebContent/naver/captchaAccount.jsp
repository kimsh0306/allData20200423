<%@page import="java.net.*"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String user = request.getParameter("user");
	String key = request.getParameter("key");

	String clientId = "fzKnHTaXVyoY7OjvxISh"; //애플리케이션 클라이언트 아이디값";
	String clientSecret = "VwrOns36ly"; //애플리케이션 클라이언트 시크릿값";	
	try{
		String code="1";//키 발급 시 0, 캡차이미지 비교할 때는 1로 바꿔준다.
		String apiURL = "https://openapi.naver.com/v1/captcha/nkey?code=" +code+"&key="+key+"&value="+user;

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
        out.print(res.toString());
	}catch(Exception e){
		e.printStackTrace();
	}
%>