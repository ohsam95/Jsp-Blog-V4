<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
div {
		border: 1px solid black;
		margin: 5px;
		padding: 5px;
}
</style>
</head>
<body>
<div id ="reply-box">
	<div id ="reply-1">
		첫번째 댓글입니다.
	</div>
</div>
<input type="text" id="tf-reply"/> <br/>
<button onclick="start()">댓글쓰기</button>

<script>
var num = 1;
function start(){
	num++;
	var a = $('#tf-reply').val();

	var data = {
			username:"ssar",
			content:a
			}
	
	//통신 성공 시 아래 로직 실행
	$.ajax({
			type: 'post',
			url: 'AjaxResponseTest.jsp', //필수값임
			data: JSON.stringify(data),
			contentType: 'application/json; charset=utf-8', //보내는 data의 타입
			dataType: 'json'  //응답 받을 데이터의 타입 (받을 데이터를 어떻게 파싱할까를 정의) //text, json 만 있음
	}).done(function(result){
			console.log(result)		
			$('#reply-box').prepend("<div id='reply-"+num+"'>"+a+"</div>") 
	}).fail(function(error){

			console.log(error)
		});	
 
}
</script>
</body>
</html>