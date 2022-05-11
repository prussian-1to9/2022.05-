<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Whale</title>
<link rel="stylesheet" type="text/css" href="/whale/resources/css/w3.css">
<link rel="stylesheet" type="text/css" href="/whale/resources/css/base.css">
<script type="text/javascript" src="/whale/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="whale//resources/js/test/index.js"></script>
<style type="text/css">
	p{
		margin-top: 2px;
		margin-bottom: 2px;
	}
</style>
</head>
<body>
	<div class="w3-content mx650" style="height:200px;">
		<c:if test="${not empty SID}">
			<h1 class="w3-sand w3-text-blue" style="text-align:center;">Hello ${SID}</h1>
		</c:if>
		<c:if test="${empty SID}">
			<h1 class="w3-sand w3-text-blue" style="text-align:center;">Hello JSP</h1>
		</c:if>
		<div class="w3-col m2 w3-button w3-pale-yellow w3-text-blue" id="obtn">Logout</div>
		<div class="w3-col m8"><p></p></div>
		<div class="w3-col m2 w3-button w3-blue" id="ibtn">MyInfo</div>
	</div>
	<div class="w3-content mx650 w3-center" id="info" style="display: none;">
		<h1 class="w3-blue"> ${SID} Info</h1>
		<div class="w3-content" style="border:1px solid #2196F3; height:200px;">
			<div class="w3-col m4 w3-border-right" style="height:200px;">
				<!-- 아바타 이미지 기본값 : noimage.jpg -->
				<p style="display:none;" id="ano">${SAVT}</p>
				<img src="/whale/resources/img/avatar/noimage.jpg" width="170px" height="170px"
					class="w3-border w3-margin" id="avtimg">
			</div>
			<div class="w3-col m8">
				<p class="w3-col m3 w3-right-align">회원번호 : </p>
				<p class="w3-col m9 w3-left-align">  ${MNO}</p>
				<p class="w3-col m3 w3-right-align">회원이름 : </p>
				<p class="w3-col m9 w3-left-align">  ${SNAME}</p>
				<p class="w3-col m3 w3-right-align">아이디 : </p>
				<p class="w3-col m9 w3-left-align">  ${SID}</p>
				<p class="w3-col m3 w3-right-align">메일 : </p>
				<p class="w3-col m9 w3-left-align">  ${SMAIL}</p>
				<p class="w3-col m3 w3-right-align">전화번호 : </p>
				<p class="w3-col m9 w3-left-align">  ${STEL}</p>
				<p class="w3-col m3 w3-right-align">가입일 : </p>
				<p class="w3-col m9 w3-left-align">  ${JDATE}</p>
				<p class="w3-col m3 w3-right-align">성별 : </p>
				<p class="w3-col m9 w3-left-align" id="gen"></p>
			</div>
		</div>
	</div>
</body>
</html>