<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.net.*" %>    
<%
	String clientId = "fzKnHTaXVyoY7OjvxISh"; //애플리케이션 클라이언트 아이디값";
	String clientSecret = "VwrOns36ly"; //애플리케이션 클라이언트 시크릿값";
	try{
		String code = "0"; // 키 발급시 0,  캡차 이미지 비교 시 1로 세팅
        String apiUrl = "https://openapi.naver.com/v1/captcha/nkey?code=" + code;
        URL url = new URL(apiUrl);
        
        /*
		이미지를 서버에서 가져오기 위한 방법 => url로 가져오는 방법
		생성자가 protected로 선언되어있기 때문에 기본적으로는 개발자가 직접 HttpURLConnection 객체를 생성할 수 없다.
		URL 객체의 openConnection() 메서드가 리턴하는 URLConnection 객체는 HttpURLConnection의 인스턴스가 될 수 있기 때문에, 
		리턴된 URLConnection을 다음처럼 HttpURLConnection으로 캐스팅해서 사용한다.
		간단하게 말하자면, url 객체를 HttpURLConnection으로 형변환한다는 것이다.
        */
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
		out.println(sb_line.toString());
	}catch(Exception e){
		out.print(e.toString());
	}
%>









