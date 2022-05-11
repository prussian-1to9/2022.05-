$(document).ready(function(){
	$('#obtn').click(function(){
		alert('로그아웃 되었습니다.');
		$(location).attr('href', '/whale/test/logout.dream');
	});
	
	$('#ibtn').click(function(){
		$('#info').css('display', 'block');
	});
	
	// 아바타 데이터 꺼내오기
	var txt = $('#ano').html();
	$.ajax({
		url: '/whale/test/avtInfo.dream',
		type: 'post',
		dataType: 'json',
		data: {
			ano : txt					
		},
		success: function(data){
			var sname = data.savename;
			var gen = ((data.gen == 'M')?'남자':'여자');
			
			// 넣어주기
			$('#avtimg').attr('src', '/whale/resources/img/avatar/' + sname);
			$('#gen').html(gen);
		},
		error: function(){
			alert('통신 에러 발생');
		}
	});
});