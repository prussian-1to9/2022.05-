/*// Javascript 방식
document.getElementById('hbtn').onclick = function(){
	location.href = '/whistle/test/';
};

// 로그인버튼 기능
document.getElementById('lbtn').onclick = function(){
	// 데이터 유효성 검사
	var sid = document.frm.id.value;	// name 속성으로 접근
	if(!sid){
		alert('아이디를 입력하세요.');
		document.frm.id.focus();
		return;
	}
	var spw = document.frm.pw.value;
	if(!spw){
		alert('비밀번호를 입력하세요.');
		document.frm.pw.focus();
		return;	
	}
	
	// 통과했다면 정규식 검사
	var idPat = /^[a-zA-Z0-9]{4,10}$/;
	var pwPat = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#-*_$])([a-zA-Z0-9!@#-*_$]{4,10})$/;
	
	var idRs = idPat.test(sid);
	var pwRs = pwPat.test(spw);
	
	if(!idRs){
		alert('형식에 맞지 않는 ID 입니다.')
		document.frm.id.value = '';
		document.frm.id.focus();
		return;
	} else if(!pwRs){
		alert('형식에 맞지 않는 PW 입니다.')
		document.frm.pw.value = '';
		document.frm.pw.focus();
		return;
	}
	
	// 모든 테스트 통과시 제출.
	document.frm.setAttribute('action', '/whistle/test/loginProc.dream');
	document.getElementById('frm').submit();
};
*/

// jQuery
$('#hbtn').click(function(){
	$(location).attr('href', '/whistle/test/');
});

// 로그인버튼 기능
$('#lbtn').click(function(){
	// 데이터 유효성 검사
	var sid = $('#id').val();
	if(!sid){
		alert('아이디를 입력하세요.');
		$('#id').focus();
		return; 
	}
	var spw = $('#pw').val();
	if(!spw){
		alert('비밀번호를 입력하세요.');
		$('#pw').focus();
		return;
	}
	
	// 정규식 검사
	var idPat = /^[a-zA-Z0-9]{4,10}$/;
	var pwPat = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#-*_$])([a-zA-Z0-9!@#-*_$]{4,10})$/;
	
	var idRs = idPat.test(sid);
	var pwRs = pwPat.test(spw);

/*	if(!idRs){
		alert('형식에 맞지 않는 ID 입니다.')
		document.frm.id.value = '';
		document.frm.id.focus();
		return;
	} else if(!pwRs){
		alert('형식에 맞지 않는 PW 입니다.')
		document.frm.pw.value = '';				// 테스트용 계정은 yellow_3to3, 0323 이기 때문에 테스트중엔 주석처리
		document.frm.pw.focus();
		return;
	}*/

	// 유효성검사 통과시 제출
	alert(sid + ' 회원 로그인 성공');
	$('#frm').attr('action', '/whistle/test/loginProc.dream');
	$('#frm').submit();
});

// Ajax 버튼 기능 추가
$('#abtn').click(function(){
	// 데이터 유효성 검사
	var sid = $('#id').val();
	if(!sid){
		alert('아이디를 입력하세요.');
		$('#id').focus();
		return;
	}
	var spw = $('#pw').val();
	if(!spw){
		alert('비밀번호를 입력하세요.');
		$('#pw').focus();
		return;
	}
	
	// 정규식 검사
	var idPat = /^[a-zA-Z0-9]{4,10}$/;
	var pwPat = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#-*_$])([a-zA-Z0-9!@#-*_$]{4,10})$/;
	
	var idRs = idPat.test(sid);
	var pwRs = pwPat.test(spw);
	
	/*	if(!idRs){
		alert('형식에 맞지 않는 ID 입니다.')
		document.frm.id.value = '';
		document.frm.id.focus();
		return;
	} else if(!pwRs){
		alert('형식에 맞지 않는 PW 입니다.')
		document.frm.pw.value = '';				// 테스트용 계정은 yellow_3to3, 0323 이기 때문에 테스트중엔 주석처리
		document.frm.pw.focus();
		return;
	}*/

	// 유효성검사 통과시 비동기통신으로 폼 전송
	$.ajax({
		url: '/whistle/test/loginAjax.dream',
		type: 'post',
		dataType: 'json',
		data: {
			id: sid,
			pw: spw
		},
		success: function(obj){
			// var obj={"result": "OK"} 또는 {"result": "NO"} 의 형태일 것
			var result = obj.result;
			if(result=='OK'){
				// 로그인 해야됨!
				alert(sid + ' 회원 로그인 성공');
				
				// 홈페이지로 이동
				$(location).attr('href', '/whistle/test/');
				
			}else{
				// ajax에 없는 아이디
				alert('로그인 실패');
				
				// 재로그인
				document.frm.reset();
				$('#id').focus();
			}
		},
		error: function(){
			alert('통신 에러 발생');
		}
	});
});

// 리셋버튼 기능
$('#rbtn').click(function(){
	$('input').val('');
});