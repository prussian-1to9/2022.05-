$(document).ready(function(){
	$(document.frm.gen).change(function(){
		// 아바타들 감추기
		$('#avtfr').stop().slideUp();
		
		var sgen = $(this).val();
// 확인	alert(sgen);

		if(sgen=='F'){
			$('#mavt').css('display', 'none');
			$('#favt').css('display', 'block');
			$('#avtfr').stop().slideDown(1000);
		} else{
			$('#favt').css('display', 'none');
			$('#mavt').css('display', 'block');
			$('#avtfr').stop().slideDown(1000);
		}
	});
});