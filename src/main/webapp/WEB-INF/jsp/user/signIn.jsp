<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="wrap" class="container">
	<section>
		<h3 class="logo">로그인</h3>
		<form id="loginForm" method="post" action="/user/sign_in">
			<div class="content">
				<div class="user-info">
						<div class="img-1 d-flex justify-content-center align-items-center">
							<img alt="" src="/static/image/userId.jpg">
						</div>
					<input type="text" id="loginId" name="loginId" class="input-1">
						<div class="img-1 d-flex justify-content-center align-items-center">
							<img alt="" src="/static/image/password.jpg">
						</div>
					<input type="text" id="password" name="password" class="input-1">
					
				</div>
				<div class="buttons d-flex">
					<input type="submit" id="loginBtn" class="btn btn-block sign-up" value="회원가입">
					<input type="submit" id="loginBtn" class="btn btn-block sign-in" value="로그인">
				</div>
			</div>
		</form>
	</section>
</div>
<script>
	$(document).ready(function() {
		//로그인
		$('#loginForm').on('submit', function(e){ 
			e.preventDefault(); // form submit 중단
			
			let loginId = $('input[name=loginId]').val().trim();
			let password = $('#password').val();
			
			if (!loginId) {
				alert("아이디를 입력하세요");
				return flase;
			}
			if (!password) {
				alert("비밀번호를 입력하세요");
				return false;
			}
			
			let url = $(this).attr('action');
			console.log(url);
			let params = $(this).serialize();	// name 속성이 반드시 있어야함
			console.log(params);
			
			$.post(url,params)	// request
			.done(function(data) {	//response
				if (data.code == 1) {
					// 성공
					location.href = "/post/post_list_view"; //글 목록으로 이동
				} else {
					// 로직 실패
					alert(data.errorMessage);
				}
			});
		});
	});
</script>