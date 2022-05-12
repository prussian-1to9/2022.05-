/**
	/resources/js/whistle/main.js
*/
// jQuery함수! 이렇게도 쓸 수 이따.
$(function(){
	// join 버튼 기능
	$('#jbtn').click(function(){
		$(location).attr('href', '/whistle/member/join.blp');
	});
	
	// login 버튼 기능
	$('#lbtn').click(function(){
		$(location).attr('href', '/whistle/member/loginProc.blp');
	});
	
	// logout 버튼 기능
});