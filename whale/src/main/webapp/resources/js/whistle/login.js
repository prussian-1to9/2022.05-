$(document).ready(function(){
	$('#lbtn').click(function(){
		var sid = $('#id').val();
		var spw = $('#pw').val();
		
		if(!sid){
			$('#id').focus();
			alert('ID를 입력하세요.');
			return;
		}else if(!spw){
			$('#id').focus();
			alert('PW를 입력하세요.');
			return;
		}
		
		// 통과했다면 경로 설정
		$('#frm').attr('action', '/whistle/member/loginProc.blp');
	});
});