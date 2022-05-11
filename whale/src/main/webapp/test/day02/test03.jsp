<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP에서 Java 코딩</title>
<link rel="stylesheet" type="text/css" href="/whale/resources/css/w3.css">
<link rel="stylesheet" type="text/css" href="/whale/resources/css/base.css">
</head>
<body>
<%--
	문자열 배열을 만들고, w3.css에 있는 색상 관련 클래스들을 입력해놓자.
--%>
<%
	String[] color = new String[]{
		"w3-pink", "w3-purple", "w3-deep-purple", "w3-indigo",
		"w3-blue", "w3-aqua", "w3-teal", "w3-green"
	};
%>
	<div class="w3-content mx650 w3-center">
		<h1 class="w3-orange w3-padding w3-margin-top">Script let 연습</h1>
		<div class="w3-col w3-padding">
		<%
			for(int i=0; i<color.length; i++){
		%>
			<div class="box wh100 ml10 <%= color[i] %>"><%= color[i] %></div>
		<%
			}
		%>
		</div>
	</div>
</body>
</html>