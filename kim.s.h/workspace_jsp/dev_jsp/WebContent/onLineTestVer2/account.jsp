<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie[] cookies = request.getCookies();
	String h_no = null;
	if(cookies!=null&&cookies.length>0){
		for(int i=0;i<cookies.length;i++){
			if("c_hno".equals(cookies[i].getName())){
				h_no = cookies[i].getValue();
			}
		}
	}
	out.print("h_no:"+h_no);
	String daps[] = {"1","1","2","3"};

	//파라미터로 받는 값들은 다 String이다. 그래서 String에 담은 것이다.
	String htest1 = request.getParameter("htest1");
	String htest2 = request.getParameter("htest2");
	String htest3 = request.getParameter("htest3");
	String htest4 = request.getParameter("htest4");
// 	String h_no 	= request.getParameter("h_no");
// 	String h_name 	= request.getParameter("h_name");	
	//수험자가 입력한 값
	String users[]	= new String[4];
	//배열의 초기화
	users[0] = htest1;
	users[1] = htest2;
	users[2] = htest3;
	users[3] = htest4;
	for(String s:users){
		out.print(s);
		out.print(" ");
	}
	out.print("<hr>");
	int jumsu = 0;
	for(int i=0;i<users.length;i++){
		for(int j=0;j<daps.length;j++){
			if(daps[i].equals(users[j])){
				if(i==j){
					jumsu += 25;
				}
			}
		}
	}
	out.print(jumsu);
	//out.print( "수험번호:"+h_no+", "+"수험자: "+h_name+"의 점수는 "+jumsu+"입니다.");
%>
