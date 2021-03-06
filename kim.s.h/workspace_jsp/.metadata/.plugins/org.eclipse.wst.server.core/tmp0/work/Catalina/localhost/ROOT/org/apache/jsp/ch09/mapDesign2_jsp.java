/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.31
 * Generated at: 2020-05-20 04:11:11 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.ch09;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class mapDesign2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');

/*
쿠키 값을 갖고 있니?
쿠키를 읽어오는 시점은 어느 때인가?
지금은 쿠키를 읽어와야 하는 순간이다.

자바 코드는 서버에서 실행되고 먼저 실행되기 때문에 위치를 위에 두는 것이다.
*/	
	Cookie cs[]	= request.getCookies();
	//쿠키에서 가져온 이름
	String c_name = null;
	for(int i=0;i<cs.length;i++){
		out.print(cs[i].getName()+", "+cs[i].getValue()+"<br>");
		//JSessionID,C_name,A23423423,이순신
		c_name = "이순신";
	}			

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("\t<style type=\"text/css\">\r\n");
      out.write("\t\tdiv#d_resList {\r\n");
      out.write("\t\t\tborder: thin dotted red;\r\n");
      out.write("\t\t\tpadding: 5px;\r\n");
      out.write("\t\t\ttext-align: left;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</style>\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"https://www.jeasyui.com/easyui/themes/default/easyui.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"https://www.jeasyui.com/easyui/themes/icon.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"https://www.jeasyui.com/easyui/themes/color.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"https://www.jeasyui.com/easyui/demo/demo.css\">\r\n");
      out.write("    <script src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyA-FKKja8sdfgMggjEvEa5agaP6D9wBd6s\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"https://code.jquery.com/jquery-1.9.1.min.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"https://www.jeasyui.com/easyui/jquery.easyui.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t//쿠키 정보를 담을 전역변수 선언하기\r\n");
      out.write("\t\tvar c_name = null;\r\n");
      out.write("\t\tfunction login(){\r\n");
      out.write("\t\t\tvar u_id = $(\"#tb_id\").val();\r\n");
      out.write("\t\t    var u_pw = $(\"#tb_pw\").val();\r\n");
      out.write("\t\t    //사용자가 입력한 아이디와 비번 확인하기\r\n");
      out.write("\t\t    //alert(\"사용자가 입력한 아이디:\"+u_id+\", 비번:\"+u_pw);\r\n");
      out.write("\t\t\t//$(\"#f_login\").attr(\"action\",\"loginAction.jsp\");//자바코드를 사용함.\r\n");
      out.write("\t\t\t//$(\"#f_login\").submit();\r\n");
      out.write("\t\t\tfetch(\"loginAction.jsp?mem_id=\"+u_id+\"&mem_pw=\"+u_pw,{\r\n");
      out.write("\t\t\t\tmethod: \"GET\"\r\n");
      out.write("//\t\t\t}).then(res => res.text()).then(res => console.log(res));\r\n");
      out.write("\t\t\t}).then(res => res.text()).then(function(text){\r\n");
      out.write("\t\t\t\t//alert(\"text: \"+text);\r\n");
      out.write("\t\t\t\tif(\"비밀번호가 틀립니다.\" ==text.trim()){//비밀번호가 틀립니다.\r\n");
      out.write("\t\t\t\t\talert(\"비밀번호가 틀립니다.\");\r\n");
      out.write("\t\t\t\t\t$(\"#d_login\").show();\r\n");
      out.write("\t\t\t\t\t$(\"#d_logout\").hide();\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\telse if(\"아이디가 존재하지 않습니다.\" ==text.trim()){//비밀번호가 틀립니다.\r\n");
      out.write("\t\t\t\t\talert(\"비밀번호가 틀립니다.\");\r\n");
      out.write("\t\t\t\t\t$(\"#d_login\").show();\r\n");
      out.write("\t\t\t\t\t$(\"#d_logout\").hide();\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\telse{\r\n");
      out.write("\t\t\t\t\tc_name = text.trim();\r\n");
      out.write("\t\t\t\t\t$.cookie('c_name','");
      out.print(c_name);
      out.write("');\r\n");
      out.write("\t\t\t\t\t//로그인 화면은 숨기기\r\n");
      out.write("\t\t\t\t\t$(\"#d_login\").hide();\r\n");
      out.write("\t\t\t\t\t//로그아웃 화면을 보여주기\r\n");
      out.write("\t\t\t\t\t$(\"#d_logout\").show();\r\n");
      out.write("\t\t\t\t\t$(\"#logok\").text(c_name+\"님\");\r\n");
      out.write("\t\t\t\t\t//식당 목록을 보여주기\r\n");
      out.write("\t\t\t\t\t$('#d_resList').show();\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction logout(){\r\n");
      out.write("\t\t\t$.cookie('c_name',null);\r\n");
      out.write("\t\t\tu_id = $(\"#tb_id\").textbox('setValue','');\r\n");
      out.write("\t\t\tu_pw = $(\"#tb_pw\").textbox('setValue','');\r\n");
      out.write("\t\t\t$('#d_login').show();\r\n");
      out.write("\t\t\t$('#d_logout').hide();\r\n");
      out.write("\t\t\t$('#d_resList').hide();\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction like(u_num){\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl:'likeAction.jsp?res_num='+u_num\r\n");
      out.write("\t\t\t   ,method: 'get'\r\n");
      out.write("\t\t\t   ,success:function(data){\r\n");
      out.write("\t\t\t\t   if(data==1){\r\n");
      out.write("\t\t\t\t\t   fetch('jsonMapList.jsp',{\r\n");
      out.write("\t\t\t\t\t\t  method:\"post\" \r\n");
      out.write("\t\t\t\t\t   }).then(res => res.text()).then(function(text){\r\n");
      out.write("\t\t\t\t\t\t   var imsi = text.trim();\r\n");
      out.write("\t\t\t\t\t\t   alert(\"imsi==>\"+ imsi);\r\n");
      out.write("\t\t\t\t\t\t   var resDoc = JSON.parse(imsi);\r\n");
      out.write("\t\t\t\t\t\t   var resList = '<table>';\r\n");
      out.write("\t\t\t\t\t\t   for(var i=0;i<resDoc.length;i++){\r\n");
      out.write("\t\t\t\t\t\t\t   resList += '<tr><td>';\r\n");
      out.write("\t\t\t\t\t\t\t   resList += resDoc[i].res_name+'<br>';\r\n");
      out.write("\t\t\t\t\t\t\t   resList += '<img src=like.png width=20 height=20/>'+resDoc[i].res_like;\r\n");
      out.write("\t\t\t\t\t\t\t   resList += '&nbsp;&nbsp;&nbsp;';\r\n");
      out.write("\t\t\t\t\t\t\t   resList += '<img src=hate.png width=20 height=20/>'+resDoc[i].res_hate;\r\n");
      out.write("\t\t\t\t\t\t\t   resList += '</td></tr>';\r\n");
      out.write("\t\t\t\t\t\t   }\r\n");
      out.write("\t\t\t\t\t\t   resList += '</table>';\r\n");
      out.write("\t\t\t\t\t\t   $(\"#d_resList\").html(resList);\r\n");
      out.write("\t\t\t\t\t   });///end of fetch\r\n");
      out.write("\t\t\t\t   }//////오라클 서버에 반영이 되었을때\r\n");
      out.write("\t\t\t   }//////////end of success\r\n");
      out.write("\t\t\t});///////////end of ajax\r\n");
      out.write("\t\t}/////////////////end of like\r\n");
      out.write("\t\tfunction hate(u_num){\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl:'hateAction.jsp?res_num='+u_num\r\n");
      out.write("\t\t\t\t   ,method: 'get'\r\n");
      out.write("\t\t\t\t   ,success:function(data){\r\n");
      out.write("\t\t\t\t\t   if(data==1){\r\n");
      out.write("\t\t\t\t\t\t   fetch('jsonMapList.jsp',{\r\n");
      out.write("\t\t\t\t\t\t\t  method:\"post\" \r\n");
      out.write("\t\t\t\t\t\t   }).then(res => res.text()).then(function(text){\r\n");
      out.write("\t\t\t\t\t\t\t   var imsi = text.trim();\r\n");
      out.write("\t\t\t\t\t\t\t   alert(\"imsi==>\"+ imsi);\r\n");
      out.write("\t\t\t\t\t\t\t   var resDoc = JSON.parse(imsi);\r\n");
      out.write("\t\t\t\t\t\t\t   var resList = '<table>';\r\n");
      out.write("\t\t\t\t\t\t\t   for(var i=0;i<resDoc.length;i++){\r\n");
      out.write("\t\t\t\t\t\t\t\t   resList += '<tr><td>';\r\n");
      out.write("\t\t\t\t\t\t\t\t   resList += resDoc[i].res_name+'<br>';\r\n");
      out.write("\t\t\t\t\t\t\t\t   resList += '<img src=like.png width=20 height=20/>'+resDoc[i].res_like;\r\n");
      out.write("\t\t\t\t\t\t\t\t   resList += '&nbsp;&nbsp;&nbsp;';\r\n");
      out.write("\t\t\t\t\t\t\t\t   resList += '<img src=hate.png width=20 height=20/>'+resDoc[i].res_hate;\r\n");
      out.write("\t\t\t\t\t\t\t\t   resList += '</td></tr>';\r\n");
      out.write("\t\t\t\t\t\t\t   }\r\n");
      out.write("\t\t\t\t\t\t\t   resList += '</table>';\r\n");
      out.write("\t\t\t\t\t\t\t   $(\"#d_resList\").html(resList);\r\n");
      out.write("\t\t\t\t\t\t   });///end of fetch\r\n");
      out.write("\t\t\t\t\t   }//////오라클 서버에 반영이 되었을때\r\n");
      out.write("\t\t\t\t   }//////////end of success\t\t\t\t\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("//DOM구성이 완료 되었을때 - 크롬브라우저가 mapDesign2.html문서에 들어있는 태그들에 대한 스캔이 완료\r\n");
      out.write("\t$(document).ready(function (){\r\n");
      out.write("\t\tif(c_name !=null && c_name.length() > 0){//쿠키값이 존재하니? 네:로그인을 했어요, 아니:로그인 안했음.\r\n");
      out.write("\t\t\t$('#d_login').hide();\r\n");
      out.write("\t\t\t$('#d_logout').show();\r\n");
      out.write("\t\t\t$('#d_resList').show();\t\t\t\t\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\t$('#d_login').show();\r\n");
      out.write("\t\t\t$('#d_logout').hide();\r\n");
      out.write("\t\t\t$('#d_resList').hide();\t\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("<table border=\"1\" align=\"center\" width=\"900\" height=\"600\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td width=\"700\">\r\n");
      out.write("\t\t<div id=\"d_map\" style=\"width:695px; height:600px;\"></div>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td width=\"200\" valign=\"top\">\r\n");
      out.write("<!--======================== 로그인 화면 시작 ======================-->\t\t\r\n");
      out.write("\t\t<div id=\"d_login\">\r\n");
      out.write("\t\t\t<form id=\"f_login\">\r\n");
      out.write("\t\t\t<table width=\"100%\" border=\"0\" borderColor=\"blue\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<input id=\"tb_id\" name=\"mem_id\" class=\"easyui-textbox\" prompt=\"아이디\" data-options=\"iconCls:'icon-man'\" style=\"width:110px\">\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td rowspan=\"2\">\r\n");
      out.write("\t\t\t\t\t<a id=\"btn\" style=\"height:60px\" href=\"javascript:login()\" class=\"easyui-linkbutton\">로그인</a>\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<input id=\"tb_pw\" name=\"mem_pw\" class=\"easyui-passwordbox\" prompt=\"비밀번호\" iconWidth=\"28\" style=\"width:110px;padding:10px\">\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("<!--====================== 로그인 화면  끝  ======================-->\t\t\r\n");
      out.write("<!--======================== 로그아웃 화면 시작 ======================-->\t\t\r\n");
      out.write("\t\t<div id=\"d_logout\">\r\n");
      out.write("\t\t\t<form id=\"f_logout\">\r\n");
      out.write("\t\t\t<table width=\"100%\" border=\"0\" borderColor=\"blue\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td style=\"width:110px\">\r\n");
      out.write("\t\t\t\t\t\t<span id=\"logok\"></span>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<a id=\"btn_logout\" style=\"height:30px\"\r\n");
      out.write("\t\t\t\t\t   href=\"javascript:logout()\" class=\"easyui-linkbutton\">로그아웃</a>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("<!--====================== 로그 아웃 화면  끝  ======================-->\t\t\r\n");
      out.write("<!--###################### 식당 목록 시작  ######################-->\r\n");
      out.write("\t<div id=\"d_resList\">식당목록</div>\r\n");
      out.write("<!--###################### 식당 목록  끝    ######################-->\r\n");
      out.write("\t\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t$(document).ready(function(){\r\n");
      out.write("\t\t\t$(\"#d_login\").show();\r\n");
      out.write("\t\t\t$(\"#d_logout\").hide();\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar map = new google.maps.Map(document.getElementById('d_map'),{\r\n");
      out.write("\t\t\t zoom: 14\r\n");
      out.write("\t\t    ,center: new google.maps.LatLng(37.478513,126.877800)\r\n");
      out.write("\t\t    ,mapTypeId: google.maps.MapTypeId.ROADMAP\r\n");
      out.write("\t\t});////////////end of map\r\n");
      out.write("\t\tvar infowindow = new google.maps.InfoWindow();//말풍선을 클릭했을 때 열리는 창\r\n");
      out.write("\t\tvar marker;//5개가 출력(json으로 스캔-jsonMapList.jsp)\r\n");
      out.write("\t\tvar i;//마커 생성시 부여한 인덱스값 0~4\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\turl: 'jsonMapList.jsp'\r\n");
      out.write("\t\t   ,dataType: 'json'\r\n");
      out.write("\t\t   ,success:function(data){\r\n");
      out.write("\t\t\t   //alert(data);\r\n");
      out.write("\t\t\t   //$(\"#d_map\").text(data);[object Object]\r\n");
      out.write("\t\t\t   //insert here\r\n");
      out.write("\t\t\t   var result = JSON.stringify(data);//직관적인 정보로 변환(구조체-덩어리)-알아봄.\r\n");
      out.write("\t\t\t   //$(\"#d_map\").text(result);\r\n");
      out.write("\t\t\t   var jsonDoc = JSON.parse(result);//배열로 전환-다시 객체화처리됨.(배열)\r\n");
      out.write("\t\t\t   for(var i=0;i<jsonDoc.length;i++){\r\n");
      out.write("\t\t\t\t   //alert(jsonDoc[i].res_name);//배열.속성이름으로 꺼낸다.\r\n");
      out.write("\t\t\t\t   marker = new google.maps.Marker({\r\n");
      out.write("\t\t\t\t\t  id: i//0,1,2,3,4 - 마커의 인덱스 정보\r\n");
      out.write("\t\t\t\t\t  //포지션값도 배열로 변경됨.\r\n");
      out.write("\t\t\t\t\t ,position: new google.maps.LatLng(jsonDoc[i].lat,jsonDoc[i].lng)\r\n");
      out.write("\t\t\t\t     ,map: map//지도는 하나\r\n");
      out.write("\t\t\t\t     ,title: jsonDoc[i].res_name// 마커가 5개이므로 식당이름 5개 분류\r\n");
      out.write("\t\t\t\t   });////////////////end of marker\r\n");
      out.write("\t\t\t\t   //마커 5개가 for문 안에서 객체 생성되니까 이벤트도 안에서 건다.\r\n");
      out.write("\t\t\t\t   google.maps.event.addListener(marker, 'click',(function(marker,i){\r\n");
      out.write("\t\t\t\t\t//addListener 함수의 리턴값이 변수가 아닌 함수임.\r\n");
      out.write("\t\t\t\t\t//자바스크립트에서는 값에 싱글 쿼테이션이나 더블 쿼테이션이 없으면 변수로 취급하여\r\n");
      out.write("\t\t\t\t\t//undefine XXXX오류 메시지 출력\r\n");
      out.write("\t\t\t\t\t   return function() {//함수의 결과는 윈도우창을 열어줌.(click된 마커마다 다르게)\r\n");
      out.write("\t\t\t\t\t\t   var content = '<b>식당이름 : '+jsonDoc[i].res_name+'</b>';\r\n");
      out.write("\t\t\t\t\t\t   content += '<br>';\r\n");
      out.write("\t\t\t\t\t\t   content += '<b>전화번호 : '+jsonDoc[i].res_tel+'</b>';\r\n");
      out.write("\t\t\t\t\t\t   content += '<br>';\r\n");
      out.write("\t\t\t\t\t\t   content += '좋아요<a href=\"javascript:like('+jsonDoc[i].res_num+')\"><img src=like.png width=20 height=20/></a>';\r\n");
      out.write("\t\t\t\t\t\t   content += '&nbsp;&nbsp;';\t\t\t\t\t\t   \r\n");
      out.write("\t\t\t\t\t\t   content += ',싫어요<a href=\"javascript:hate('+jsonDoc[i].res_num+')\"><img src=hate.png width=20 height=20/></a>';\r\n");
      out.write("\t\t\t\t\t\t   infowindow.setContent(content);\r\n");
      out.write("\t\t\t\t\t\t   infowindow.open(map,marker);\r\n");
      out.write("\t\t\t\t\t   }//end of 반환함수\r\n");
      out.write("\t\t\t\t   })(marker,i));////////////end of addLitener\r\n");
      out.write("\t\t\t\t   //마커를 생성했을때 click이벤트 처리하기\r\n");
      out.write("\t\t\t\t   if(marker){//자바스크립트 에서는 0이 아니면 모두 true\r\n");
      out.write("\t\t\t\t\t   marker.addListener('click', function(){\r\n");
      out.write("\t\t\t\t\t\t  map.setZoom(16);//상세보기 처리(14->15)\r\n");
      out.write("\t\t\t\t\t\t  map.setCenter(this.getPosition());\r\n");
      out.write("\t\t\t\t\t   });\r\n");
      out.write("\t\t\t\t   }/////////////////////////end of if\r\n");
      out.write("\t\t\t   }///////////////end of for\r\n");
      out.write("\t\t   }///////////////////end of success\r\n");
      out.write("\t\t});////////////////////end of ajax\r\n");
      out.write("\t\t});////////////////////end of ready\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
