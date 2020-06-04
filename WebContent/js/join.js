

var isCheckedUsername = false;

// juso.go.kr 라이브러리 함수 (시작)-----------------------

function goPopup(){
	window.open("/blog/juso/jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
}

function jusoCallBack(roadFullAddr){
	var tfAddress = document.querySelector("#address");
	tfAddress.value = roadFullAddr;
	// document.form.roadFullAddr.value = roadFullAddr;		
}
// juso.go.kr 라이브러리 함수 (끝) --------------------


// 데이터베이스에 ajax 요청을 해서 중복 유저네임이 있는지 확인 
// 있으면 1을 리턴, 없으면 0을 리턴, 오류가 나면 -1을 리턴

function validate() {
		if(!isCheckedUsername){
				alert('username 중복체크를 해주세요');
			}
		return isCheckedUsername;
} 

function usernameCheck(){
		//성공 (ajax)
		var tfUsername =  $('#username').val();
//		alert(tfUsername);
		console.log(tfUsername);
		//ajax는 거의 비동기!
		$.ajax({
				type: 'get',
				url: `/blog/user?cmd=usernameCheck&username=${tfUsername}`
			}).done(function(result){
					console.log(result);			
					if(result ==1){
						alert('아이디가 중복되었습니다.')
					}else if(result == 0){
						alert('사용 가능한 아이디입니다.')
						isCheckedUsername = true;
					}else {
						console.log('서버오류')
						}
				}).fail(function(error){
						console.log(error);
					});
			
}
