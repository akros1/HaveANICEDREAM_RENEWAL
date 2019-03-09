<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>International Blockchain Evaluation Forum</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="shortcut icon" href="resource/favicon.ico">
<style>
@import url(https://fonts.googleapis.com/earlyaccess/notosanskr.css);


.navbar {
	margin-bottom: 0;
	background-color: #0070C0;
	z-index: 9999;
	border: 0;
	font-size: 12px !important;
	line-height: 1.42857143 !important;
	letter-spacing: 4px;
	border-radius: 0;
	font-family: 'Noto Sans KR', sans-serif;
}

.navbar li a, .navbar .navbar-brand {
	color: #fff !important;
}

.navbar-nav li a:hover, .navbar-nav li.active a {
	color: #0070C0 !important;
	background-color: #fff !important;
}

.navbar-default .navbar-toggle {
	border-color: transparent;
	color: #fff !important;
}

footer .glyphicon {
	font-size: 20px;
	margin-bottom: 20px;
	color: #0070C0;
}
@
keyframes slide { 0% {
	opacity: 0;
	transform: translateY(70%);
}

100%
{
opacity






:






1;
transform






:translateY






(0%);
}
}
@
-webkit-keyframes slide { 0% {
	opacity: 0;
	-webkit-transform: translateY(70%);
}

100%
{
opacity






:






1;
-webkit-transform






:translateY



 



(0%);
}
}
div.col-md-6>.form-control {
	margin-top: 10px;
}

div.bg>img {
	width: 25%;
	height: auto;
	margin-top: 20px;
	margin-bottom: 20px;
}

#junemeetup{
display: none;
}
#junetitle {
	display: block;
}

@media screen and (max-width: 768px) {
	.col-sm-4 {
		text-align: center;
		margin: 25px 0;
	}
	.btn-lg {
		width: 100%;
		margin-bottom: 35px;
	}
	#junetitle {
	margin-top: 35px;
	display: block;
}
}

@media screen and (max-width: 480px) {
	.logo {
		font-size: 150px;
	}
	div.bg>img {
		width: 90%;
	}
	#junemeetup{
	 display: block;
	}
}

@media ( max-width : 991px) {
	.navbar-header {
		float: none;
	}
	.navbar-toggle {
		display: block;
	}
	.navbar-collapse {
		border-top: 1px solid transparent;
		box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.1);
	}
	.navbar-collapse.collapse {
		display: none !important;
	}
	.navbar-nav {
		float: none !important;
		margin: 7.5px -15px;
	}
	.navbar-nav>li {
		float: none;
	}
	.navbar-nav>li>a {
		padding-top: 10px;
		padding-bottom: 10px;
	}
	.navbar-text {
		float: none;
		margin: 15px 0;
	}
	/* since 3.1.0 */
	.navbar-collapse.collapse.in {
		display: block !important;
	}
	.collapsing {
		overflow: hidden !important;
	}
	div.form-group>div.col-md-6.text-right, div.form-group>div.col-md-6.text-right>label
		{
		text-align: left;
	}
}
</style>
</head>
<body>
<!--  top -->
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a href="http://www.ibeforum.org"><!-- 여기부분 -->
					<img alt="" src="resource/logo_sm1.png" style="height: 40px; width: auto; margin: 5px" class="navbar-left">
				</a>
				<a class="navbar-brand" href="http://www.ibeforum.org">IBEForum</a>
				<a class="navbar-brand" href="/event.jsp" id="junemeetup" style="color:red;">June-EVENT</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav navbar-right">
					<li>
						<a href="http://www.ibeforum.org/#about">ABOUT</a>
					</li>
					<li>
						<a href="http://www.ibeforum.org/#organization">ORGANIZATION</a>
					</li>
					<li>
						<a href="http://www.ibeforum.org/#portfolio">PRESS</a>
					</li>
					<li>
						<a href="http://www.ibeforum.org/event.jsp">June-EVENT</a>
					</li>
					<li>
						<a href="http://www.ibeforum.org/#register">REGISTRATION</a>
					</li>
					<li>
						<a href="http://www.ibeforum.org/#contact">CONTACT</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<!--start meet-up------>
	<br>
	<br>
	<div id="meet-up" class="container-fluid bg-grey">
		<form class="form-horizontal col-sm-offset-1 col-sm-10 slideanim" action="/Meetup.do" method="post" onsubmit="alert('Transmitting. Please wait.');">
		<br>
			<h2 class="text-center" id="junetitle">6/27 Meet-up Application </h2>
		
			<img  alt="" src="resource/forum.jpg" class="img-responsive center-block" style="height: 800px; width: 600px">
		
	
		<br>
			<div class="row ">
				<div class="form-group">
					<div class="col-sm-2">
						<label class="control-label " for="duration">Duration of Meeting</label>
					</div>
					<div class="col-sm-10">
						<label class="control-label " for="duration">6월 27일(수) 오후 7시</label>
						<input type="hidden" class="form-control" id="duration" name="duration" value="6월 27일(수) 오후 7시">
					</div>
				</div>
					<div class="form-group">
					<div class="col-sm-2">
						<label class="control-label " for="loc">Meeting Location</label>
					</div>
					<div class="col-sm-10">
						<label class="control-label " for="loc">한양대 제성토목관 103호</label>
						<input type="hidden" class="form-control" id="loc" name="loc" value="한양대 제성토목관 103호">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-2">
						<label class="control-label " for="recruitment">Available Capacity</label>
					</div>
					<div class="col-sm-10">
						<label class="control-label " for="recruitment">선착순 100명</label>
						<input type="hidden" class="form-control" id="recruitment" name="recruitment">
					</div>
				</div>
			</div>
			<br>
			<p class="text-center">Applicant Information</p>
			<br>
			<div class="row ">
				<div class="form-group">
					<div class="col-sm-2">
						<label class="control-label " for="name1">Name</label>
					</div>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="name1" name="name1" placeholder="이름" required="required">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-2">
						<label class="control-label " for="tel1">Contact Number</label>
					</div>
					<div class="col-sm-10">
						<input type="tel" class="form-control" id="tel1" name="tel1" placeholder="연락처">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-2">
						<label class="control-label " for="email1">E-mail</label>
					</div>
					<div class="col-sm-10">
						<input type="email" class="form-control" id="email1" name="email1" placeholder="전자우편" required="required">
					</div>
				</div>
			</div>
		 
			<div class="form-group">
				<button class="btn btn-default pull-right" >Send</button>
			</div> 
		</form>
	</div>
	
		<footer class="container-fluid text-center">
		<a href="#myPage" title="To Top">
			<span class="glyphicon glyphicon-chevron-up"></span>
		</a>
		<p>
			Bootstrap Theme Made By
			<a href="https://www.w3schools.com" title="Visit w3schools">www.w3schools.com</a>
		</p>
	</footer>
</body>
</html>