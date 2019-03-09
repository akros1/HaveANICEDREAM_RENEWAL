<%@page import="user.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<link rel="stylesheet"
	href="/HaveANiceDream/Theme/assets/css/chatbox.css">

<title>DASHGUM - Bootstrap Admin Template</title>

</head>

<style>
.modal-dialog {
	width: 300px;
}
</style>

<body>
	<%	MemberDTO user = (MemberDTO) session.getAttribute("user"); %>

	<!-- **********************************************************************************************************************************************************
      TOP BAR CONTENT & NOTIFICATIONS
      *********************************************************************************************************************************************************** -->
	<!--header start-->
	<header class="header black-bg"
		style="background-color: white; height: 80px; padding-top: 10px; border-bottom: solid 2px #e8e8e8; padding-top: 10px; border-top: solid 1px #e8e8e8;">
		<div class="sidebar-toggle-box">
			<div class="fa fa-bars tooltips" data-placement="right"
				data-original-title="Toggle Navigation"></div>
		</div>
		<!--logo start-->
		<a href="/HaveANiceDream/index.html" class="logo">
			<b style="color: black; padding-left: 20px">HAVE A NICE DREAM</b>
		</a>
		<!--logo end-->
		<div class="nav notify-row" id="top_menu">
			<!--  notification start -->
			<ul class="nav top-menu">
				<!-- inbox dropdown start-->
				<li id="header_inbox_bar" class="dropdown">
					<a data-toggle="dropdown" class="dropdown-toggle"
						href="index.html#">
						<i class="fa fa-envelope-o"></i>
						<span class="badge bg-theme" id="notenum">0</span>
					</a>
					<ul class="dropdown-menu extended inbox" id="talklist">
						<div class="notify-arrow notify-arrow-green"></div>

					</ul>
				</li>
				<!-- inbox dropdown end -->
				<%if(user!=null) {%>
				<li><%=user.getUserName() %>님 안녕하세요!
				</li>
				<%} %>
			</ul>
			<!--  notification end -->
		</div>
		<div class="top-menu">
			<ul class="nav pull-right top-menu">
				<%
				
					if (user == null) {
				%>

				<li>
					<a class="logout" style="background-color: #d12438; border: none;"
						id='btn_login'>Login</a>
				</li>

				<li>
					<a class="logout"
						href="javascript:setPath('../user/sign_in_page.jsp')"
						style="background-color: #d12438; border: none;">Signup</a>
				</li>
				<%
					} else {
				%>
				<li>
					<a class="logout" href="javascript:logout()"
						style="background-color: #d12438; border: none;">Logout</a>
				</li>
				<%
					}
				%>
			</ul>
		</div>
	</header>
	<% if(user !=null){%>
	<div id="chatarea"></div>
	<%} %>
	<!--header end-->




	<div id="login-page" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content"'>

				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">sign in now</h4>
				</div>

				<div class="modal-body">

					<form action="/HaveANiceDream/user/login.do" method="post"'>

						<input type="hidden" id="logtype" name="logtype" value="기본">
						<input type="text" class="form-control" placeholder="User ID"
							name="id" id="id" required autofocus>
						<br>
						<input type="password" class="form-control" placeholder="Password"
							name="pass" id="pass" required>
						<br>
						<button class="btn btn-theme btn-block" type="submit" id="signin">
							<i class="fa fa-lock"></i>
							SIGN IN
						</button>

						<!-- 카카오 로그인을 위한 숨겨진 input -->
						<input type="hidden" id="SNSid" name="SNSid">
						<input type="hidden" id="SNSemail" name="SNSemail">
						<input type="hidden" id="SNSimg" name="SNSimg">
						<input type="hidden" id="SNSname" name="SNSname">

					</form>
					<label class="checkbox">
						<span class="pull-right">
							<a href="javascript:showpassform()">비밀번호 찾기</a>
						</span>
						<span class="pull-left">
							<a href="javascript:showidform()">ID 찾기</a>
						</span>
					</label>
					<hr>
					<div id="findiddiv" style="display: none;">
						<input type="text" class="form-control"
							placeholder="가입시 사용한 메일주소를 입력해주세요" id="findidmail" required
							autofocus>
						<br>
						<button class="btn btn-theme btn-block" type="button" id="findid">
							ID 찾기</button>
						<br>
					</div>
					<div id="findpassdiv" style="display: none;">
						<form action="/HaveANiceDream/user/findpass.do" method="post">
							<input type="text" class="form-control" placeholder="User ID"
								id="findpassid" required autofocus>
							<br>
							<input type="text" class="form-control"
								placeholder="가입시 사용한 메일주소를 입력해주세요" id="findpassmail" required>
							<br>
							<button class="btn btn-theme btn-block" type="button"
								id="findpass">비밀번호 찾기</button>
							<br>
						</form>
					</div>

					<div class="login-social-link centered" id="social-link-div">
						<p>
							<a id="kakao-login-btn" href="javascript:kakaologin()">
								<img alt=""
									src="/HaveANiceDream/Theme/assets/img/user/kakao_account_login_btn_medium_narrow_ov.png">
							</a>
						</p>
						<div id="naverIdLogin"></div>
						<p>
							<!-- 페이스북 -->
						<div class="fb-login-button" scope="public_profile,email"
							data-max-rows="1" data-size="large" data-button-type="login_with"
							data-show-faces="false" data-auto-logout-link="false"
							data-use-continue-as="false" onlogin="fbLogin();"></div>
						</p>

					</div>
					<div class="registration">
						아직 계정이 없으신가요?
						<br />
						<a class="" href="javascript:setPath('../user/sign_in_page.jsp')">
							가입하기 </a>
					</div>
				</div>
				<!-- modal body -->
			</div>
		</div>
	</div>

	<!-- 카카오 SDK -->
	<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
	<script type="text/javascript">

		function showpassform() {
			$("#findpassdiv").css("display", "block");
			$("#social-link-div").css("display", "none");
			$("#findiddiv").css("display", "none");
		};
		
		function showidform() {
			$("#findpassdiv").css("display", "none");
			$("#social-link-div").css("display", "none");
			$("#findiddiv").css("display", "block");
		};
		
		var wSocket = new WebSocket(
				"ws://192.168.9.50:8088/HaveANiceDream/user/chat");

		function setPath(url) {
			location.href = "/HaveANiceDream/view.html?url=" + url;
		}

		function logout() {
	<%if (user != null) {
				String type = user.getUserLogType();
				if (type.equals("Kakao")) {%>

			Kakao.Auth.logout(function() {
				setTimeout(function() {
					location.href = "/HaveANiceDream/user/logout.do";

				}, 1000);

			});
	<%} else {%>
		location.href = "/HaveANiceDream/user/logout.do";
	<%}
			}%>
		}

		
	<%if (user != null) {%>
	you = "";
	youimg = "";
		$(document).ready(function() {
			
			
			$.ajax({
				url : "/HaveANiceDream/note/getnewnotenum.do",
				type : "GET",
				data : {
					"userId" : "<%=user.getUserId()%>"
				},
				dataType : "text",
				success : function(resp) {
					$("#notenum").text(resp);

				}
			});

			
			$.ajax({
				url : "/HaveANiceDream/note/getyoulist.do",
				type : "GET",
				data : {
					"userId" : "<%=user.getUserId()%>"
				},
				dataType : "json",
				success : function(resp) {
					//alert(resp.list[0].name);
					var size = resp.list.length;
					for(var i=0;i<size;i++){
						var talkunit = "<li><a id='lst"+i+"'> <span class='photo'>"
						+"<img alt='avatar' src='/HaveANiceDream/uploadresources/user/"+resp.list[i].img+"'/></span> "
						+"<span class='subject'> <span class='from'>"+resp.list[i].name+"</span></span></a></li>";
						
						$("#talklist").append(talkunit);
						var temp = "#lst"+i;
						$(temp).on("click", {id : resp.list[i].id,name : resp.list[i].name}, function(e) {
							showTalkList(e.data.id, e.data.name);
						});
					}

				}
			});
			
			chatSet();
			
			

		});

		function chatSet() {
			var $chatbox = $('.chatbox'),
			$chatboxTitle = $('.chatbox__title'),
			$chatboxTitleClose = $('.chatbox__title__close');
			
			$chatboxTitle.on('click', function() {
        		$chatbox.toggleClass('chatbox--tray');
      		});
			
	        $chatboxTitleClose.on('click', function(e) {
	            e.stopPropagation();
	            $chatbox.addClass('chatbox--closed');
	        });
        
        $chatbox.on('transitionend', function() {
            if ($chatbox.hasClass('chatbox--closed')) $chatbox.remove();
        });      
        
        $('.chatbox__message').keypress(function (e) {
            if (e.which == 13){
            	var str = $(this).val();
            	var msg = '<div class="chatbox__body__message chatbox__body__message--right">'
            	+'<img src="'+'/HaveANiceDream/uploadresources/user/<%=user.getUserImage()%>'+'" alt="Picture">'
            	+'<p>'+str+'</p></div>';
            	$(".chatbox__body").append(msg);
            	var data = {
            			"type" : "text",
            			"from" : '<%=user.getUserId()%>',
            			"to" : you+"",
            			"text" : str
            	}
        		wSocket.send(JSON.stringify(data));
            	$(this).val("");
        		$('.chatbox__body').scrollTop($('.chatbox__body').prop('scrollHeight'));
            }
        });
		}
		
		wSocket.onopen = function(e) {
        	var data = {
        			"type" : "info",
        			"id" : '<%=user.getUserId()%>'
        	}
    		wSocket.send(JSON.stringify(data));
		}

		wSocket.onmessage = function(e) {
			//alert(e.data);
			var data = JSON.parse(e.data);
			if(data.from == you && data.to=='<%=user.getUserId()%>'){
        	var msg = '<div class="chatbox__body__message chatbox__body__message--left">'
            	+'<img src="/HaveANiceDream/uploadresources/user/'+youimg+'" alt="Picture">'
            	+'<p>'+data.text+'</p></div>';
		
        $(".chatbox__body").append(msg);
        $('.chatbox__body').scrollTop($('.chatbox__body').prop('scrollHeight'));
			}
			//document.getElementById("ta").value += (e.data+"\n");
		}
		
		function showTalkList(selyou,name) {
			you = selyou;
			//alert('test');
			
        	$("#chatarea").empty();
        	
        	var chatarea = "<div class='chatbox chatbox--tray'><div class='chatbox__title'><h5><a href=#'>"
        	+name+"</a></h5><button class='chatbox__title__tray'><span></span></button>"
        	+"<button class='chatbox__title__close'><span>"
        	+"<svg viewBox='0 0 12 12' width='12px' height='12px'>"
        	+"<line stroke='#FFFFFF' x1='11.75' y1='0.25' x2='0.25' y2='11.75'></line>"
        	+"<line stroke='#FFFFFF' x1='11.75' y1='11.75' x2='0.25' y2='0.25'></line>"
        	+"</svg></span></button></div><div class='chatbox__body'></div>"
        	+"<input type='text' class='chatbox__message' placeholder='Write something interesting'/></div>";

        	$("#chatarea").append(chatarea);
        	
        	chatSet();
        	
			$.ajax({
				url : "/HaveANiceDream/note/talklist.do",
				type : "GET",
				data : {
					"me" : '<%=user.getUserId()%>',
					"you" : you+""
				},
				dataType : "json",
				success : function(resp) {
					var size = resp.list.length;
					youimg = resp.yourimg;
					for(var i=0;i<size;i++){
						var msg = "";
						if (resp.list[i].from == '<%=user.getUserId()%>'){
			            	msg = '<div class="chatbox__body__message chatbox__body__message--right">'
			                	+'<img src="/HaveANiceDream/uploadresources/user/'+'<%=user.getUserImage()%>'+'" alt="Picture">'
			                	+'<p>'+resp.list[i].content+'</p></div>';
						} else if(resp.list[i].from == you){
			            	msg = '<div class="chatbox__body__message chatbox__body__message--left">'
			                	+'<img src="/HaveANiceDream/uploadresources/user/'+youimg+'" alt="Picture">'
			                	+'<p>'+resp.list[i].content+'</p></div>';
						}
			            $(".chatbox__body").append(msg);
			            $('.chatbox__body').scrollTop($('.chatbox__body').prop('scrollHeight'));
					}

				}
			});
		}
	<%}%>
		$('#btn_login').on("click", function() {
			$("#login-page").modal();
		})

		$("#login-page").draggable({
			handle : ".modal-header"
		});

		$("#findid").on("click", function() {
			$.ajax({
				url : "/HaveANiceDream/user/findid.do",
				type : "post",
				data : {
					"mail" : document.getElementById("findidmail").value
				},
				dataType : "text",
				success : function(resp) {
					alert(resp);

				}
			});

		});

		$("#findpass").on("click", function() {
			$.ajax({
				url : "/HaveANiceDream/user/findpass.do",
				type : "post",
				data : {
					"mail" : document.getElementById("findpassmail").value,
					"userid" : document.getElementById("findpassid").value
				},
				dataType : "text",
				success : function(resp) {
					alert(resp);

				}
			});

		});
	</script>
	<!-- 카카오 연동 -->
	<!-- 카카오 SDK -->
	<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
	<script type='text/javascript'>
		//<![CDATA[
		// 사용할 앱의 JavaScript 키를 설정해 주세요.
		Kakao.init('78cecbcfa10a98bcb341599df55a3441');
		// 카카오 로그인 버튼을 생성합니다.

		function kakaologin() {

			Kakao.Auth.loginForm({
				success : function(authObj) {
					//alert(JSON.stringify(authObj));
					Kakao.API.request({
						url : '/v1/user/me',
						success : function(res) {
							//alert(JSON.stringify(res));
							$("#SNSid").val(res.id);
							$("#SNSemail").val(res.kaccount_email);
							$("#SNSimg").val(res.properties.thumbnail_image);
							$("#SNSname").val(res.properties.nickname);
							$("#logtype").val("Kakao");
							$("#id").removeAttr("required");
							$("#pass").removeAttr("required");
							$("#signin").trigger("click");
						},
						fail : function(error) {
							alert(JSON.stringify(error));
						}
					});
				},
				fail : function(err) {
					alert(JSON.stringify(err));
				},
				persistAccessToken : false
			});
		}
		//]]>
	</script>
	<!-- 네이버 연동 코드 -->
	<!-- 네이버SDK -->
	<script type="text/javascript"
		src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js"
		charset="utf-8"></script>
	<!-- 네이버아디디로로그인 초기화 Script -->
	<script type="text/javascript">
		var naverLogin = new naver.LoginWithNaverId(
				{
					clientId : "JaM3SgETDGwc6FCEo9Mw",
					callbackUrl : "http://localhost:8088/HaveANiceDream/user/naver_callback.html",
					isPopup : false, /* 팝업을 통한 연동처리 여부 */
					loginButton : {
						color : "green",
						type : 3,
						height : 49
					}
				/* 로그인 버튼의 타입을 지정 */
				});
		naverLogin.init();
	</script>
	<!-- 페이스북 연동 코드 -->
	<div id="fb-root"></div>

	<script>
		function fbLogin() {
			// 로그인 여부 체크
			FB.getLoginStatus(function(response) {

				if (response.status === 'connected') {
					FB.api('/me', {
						fields : 'email,name,picture'
					}, function(response) {
						// 제일 마지막에 실행 // me가 벌써 토근생성해서  내정보 받아옴acess 엑세스토근을 받아옴..
						$("#SNSid").val(response.id);
						$("#SNSname").val(response.name);
						$("#SNSemail").val(response.email);
						$("#SNSimg").val(response.picture.data.url);
						//picture.data.url
						$("#logtype").val("Facebook");
						$("#id").removeAttr("required");
						$("#pass").removeAttr("required");
						$("#signin").trigger("click");
					});
				} else if (response.status === 'not_authorized') {
					// 사람은 Facebook에 로그인했지만 앱에는 로그인하지 않았습니다.
					alert('앱에 로그인해야 이용가능한 기능입니다.');
				} else {
					// 그 사람은 Facebook에 로그인하지 않았으므로이 앱에 로그인했는지 여부는 확실하지 않습니다.
					alert('페이스북에 로그인해야 이용가능한 기능입니다.');
				}
			}, true); // 중복실행방지
		}
		(function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0];
			if (d.getElementById(id))
				return;
			js = d.createElement(s);
			js.id = id;
			js.src = 'https://connect.facebook.net/ko_KR/sdk.js#xfbml=1&version=v2.12&appId=2119289184970452&autoLogAppEvents=1';
			fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));
	</script>
</body>
</html>
