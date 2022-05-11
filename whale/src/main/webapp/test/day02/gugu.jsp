<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단</title>
<link rel="stylesheet" type="text/css" href="/whale/resources/css/w3.css">
<link rel="stylesheet" type="text/css" href="/whale/resources/css/base.css">
<style type="text/css">
	h3{
		margin:0px;
	}
	h4{
		margin:5px 0px;
	}
</style>
</head>
<body>
<%	// 사용할 색깔 배열 생성
	String[] color = new String[]{
			"w3-pink", "w3-purple", "w3-deep-purple", "w3-indigo", 
			"w3-blue", "w3-aqua","w3-teal","w3-green"
	};  
%>
	<div class="w3-content mx650 w3-center">
		<h1 class="w3-blue w3-padding w3-card-4">구구단</h1>
		<div class="w3-col w3-margin-top">
		<!-- 스크립트 릿 방식 이용하여 구구단 출력 -->
<%
	for(int dan=2; dan<10; dan++){
%>
			<div class="box w135 w3-card-4 ml10">
				<h3 class="w3-col <%= color[dan-2]%> w3-padding"><%= dan %> 단</h3>
				<div class="w3-col w3-border">
	<%
		for(int gop=1; gop<10; gop++){
	%>
					<h4><%= dan %> X <%= gop %> = <%= dan*gop %></h4>
	<%
		}
	%>
				</div>
			</div>
<%
	}
%>
		</div>
	</div>
</body>
</html>