<%@page import="grade.dto.GradeDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="user.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
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
<title>Insert title here</title>


<link href="/HaveANiceDream/Theme/assets/css/bootstrap.css"
	rel="stylesheet">

<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">


<style type="text/css">
.card {
	padding-top: 20px;
	margin: 10px 0 20px 0;
	background-color: rgba(214, 224, 226, 0.2);
	border-top-width: 0;
	border-bottom-width: 2px;
	-webkit-border-radius: 3px;
	-moz-border-radius: 3px;
	border-radius: 3px;
	-webkit-box-shadow: none;
	-moz-box-shadow: none;
	box-shadow: none;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
}

.card .card-heading {
	padding: 0 20px;
	margin: 0;
}

.card .card-heading.simple {
	font-size: 20px;
	font-weight: 300;
	color: #777;
	border-bottom: 1px solid #e5e5e5;
}

.card .card-heading.image img {
	display: inline-block;
	width: 46px;
	height: 46px;
	margin-right: 15px;
	vertical-align: top;
	border: 0;
	-webkit-border-radius: 50%;
	-moz-border-radius: 50%;
	border-radius: 50%;
}

.card .card-heading.image .card-heading-header {
	display: inline-block;
	vertical-align: top;
}

.card .card-heading.image .card-heading-header h3 {
	margin: 0;
	font-size: 14px;
	line-height: 16px;
	color: #262626;
}

.card .card-heading.image .card-heading-header span {
	font-size: 12px;
	color: #999999;
}

.card .card-body {
	padding: 0 20px;
	margin-top: 20px;
}

.card .card-media {
	padding: 0 20px;
	margin: 0 -14px;
}

.card .card-media img {
	max-width: 100%;
	max-height: 100%;
}

.card .card-actions {
	min-height: 30px;
	padding: 0 20px 20px 20px;
	margin: 20px 0 0 0;
}

.card .card-comments {
	padding: 20px;
	margin: 0;
	background-color: #f8f8f8;
}

.card .card-comments .comments-collapse-toggle {
	padding: 0;
	margin: 0 20px 12px 20px;
}

.card .card-comments .comments-collapse-toggle a, .card .card-comments .comments-collapse-toggle span
	{
	padding-right: 5px;
	overflow: hidden;
	font-size: 12px;
	color: #999;
	text-overflow: ellipsis;
	white-space: nowrap;
}

.card-comments .media-heading {
	font-size: 13px;
	font-weight: bold;
}

.card.people {
	position: relative;
	display: inline-block;
	width: 170px;
	height: 300px;
	padding-top: 0;
	margin-left: 20px;
	overflow: hidden;
	vertical-align: top;
}

.card.people:first-child {
	margin-left: 0;
}

.card.people .card-top {
	position: absolute;
	top: 0;
	left: 0;
	display: inline-block;
	width: 170px;
	height: 150px;
	background-color: #ffffff;
}

.card.people .card-top.green {
	background-color: #53a93f;
}

.card.people .card-top.blue {
	background-color: #427fed;
}

.card.people .card-info {
	position: absolute;
	top: 150px;
	display: inline-block;
	width: 100%;
	height: 101px;
	overflow: hidden;
	background: #ffffff;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
}

.card.people .card-info .title {
	display: block;
	margin: 8px 14px 0 14px;
	overflow: hidden;
	font-size: 16px;
	font-weight: bold;
	line-height: 18px;
	color: #404040;
}

.card.people .card-info .desc {
	display: block;
	margin: 8px 14px 0 14px;
	overflow: hidden;
	font-size: 12px;
	line-height: 16px;
	color: #737373;
	text-overflow: ellipsis;
}

.card.people .card-bottom {
	position: absolute;
	bottom: 0;
	left: 0;
	display: inline-block;
	width: 100%;
	padding: 10px 20px;
	line-height: 29px;
	text-align: center;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
}

.card.hovercard {
	position: relative;
	padding-top: 0;
	overflow: hidden;
	text-align: center;
	background-color: rgba(214, 224, 226, 0.2);
}

.card.hovercard .cardheader {
	background: #424a5d;
	background-size: cover;
	height: 135px;
}

.card.hovercard .avatar {
	position: relative;
	top: -50px;
	margin-bottom: -50px;
}

.card.hovercard .avatar img {
	width: 100px;
	height: 100px;
	max-width: 100px;
	max-height: 100px;
	-webkit-border-radius: 50%;
	-moz-border-radius: 50%;
	border-radius: 50%;
	border: 5px solid rgba(255, 255, 255, 0.5);
}

.card.hovercard .info {
	padding: 4px 8px 10px;
}

.card.hovercard .info .title {
	margin-bottom: 4px;
	font-size: 24px;
	line-height: 1;
	color: #262626;
	vertical-align: middle;
}

.card.hovercard .info .desc {
	overflow: hidden;
	font-size: 12px;
	line-height: 20px;
	color: #737373;
	text-overflow: ellipsis;
}

.card.hovercard .bottom {
	padding: 0 20px;
	margin-bottom: 17px;
}

.btn {
	border-radius: 50%;
	width: 32px;
	height: 32px;
	line-height: 18px;
}

.no-mg-no-pd {
	margin: 0;
	padding: 0;
}

.btn-comment {
	color: #fff;
	background-color: #5193ea;
	border-color: #2775e2;
}

.btn-comment:hover, .btn-comment:focus, .btn-comment:active,
	.btn-comment.active, .open .dropdown-toggle.btn-comment {
	color: #fff;
	background-color: #2775e2;
	border-color: #2775e2;
}

.btn {
	margin-bottom: 5px;
}
</style>

</head>
<body>
	<%
		ArrayList<GradeDTO> gradeBuyTypelist = (ArrayList<GradeDTO>) request.getAttribute("gradeBuyTypelist");
		ArrayList<GradeDTO> gradeSellTypelist = (ArrayList<GradeDTO>) request.getAttribute("gradeSellTypelist");
		GradeDTO gradedto = null;
		int buytypesize = gradeBuyTypelist.size();
		int selltypesize = gradeSellTypelist.size();
	%>


	<div class="container"
		style="overflow: auto; width: 320px; height: 500px;">
		<div class="row">
			<div class="col-lg-3 col-sm-6">
				<div class="card hovercard">
					<div class="cardheader"></div>
					<div class="avatar">
						<img alt="" src="" id="userImage">
					</div>
					<div class="info">
						<div class="title">
							<p id="userName"></p>
						</div>
						<div class="desc" id="userId"></div>
						<div class="desc" id="userEmail"></div>
						<div class="desc" id="userAddr"></div>
						<div class="desc" id="userAddrDetail"></div>
						<div class="desc" id="userTel"></div>
						<div class="desc" id="userType"></div>
					</div>
					<div>
					<button class="btn btn-primary" type="button" onclick="chatstart()" style="border: 1px solid;">
						<i class="fa fa-comment"></i>
					
					</button>
					</div>
					<ul id="myTab" class="nav nav-tabs" role="tablist">
						<li role="presentation" class="active">
							<a data-target="#home" id="home-tab" role="tab" data-toggle="tab"
								aria-controls="home" aria-expanded="true">판매평가</a>
						</li>
						<li role="presentation" class="">
							<a data-target="#profile" role="tab" id="profile-tab"
								data-toggle="tab" aria-controls="profile" aria-expanded="false">구매평가</a>
						</li>
						<li role="presentation" class="dropdown"></li>
					</ul>
					<div id="myTabContent"
						class="tab-content col-lg-12 col-md-12 col-sm-12 col-xs-12 no-mg-no-pd"
						style="width: 270px; text-align: justify;">
						<div role="tabpanel"
							class="tab-pane fade active in col-lg-12 col-md-12 col-sm-12 col-xs-12 no-mg-no-pd"
							id="home" aria-labelledby="home-tab">
							<%
								for (int i = 0; i < buytypesize; i++) {
									gradedto = gradeBuyTypelist.get(i);
							%>
							<p class="col-lg-6 col-md-6 col-sm-6 col-xs-6 no-mg-no-pd">
								평가자 :
								<%=gradedto.getGradeUserId()%>
							</p>
							<p class="col-lg-6 col-md-6 col-sm-6 col-xs-6 no-mg-no-pd"
								style="text-align: right;"><%=gradedto.getGradeDate()%>
							</p>
							<p class="col-lg-6 col-md-6 col-sm-6 col-xs-6 no-mg-no-pd"
								style="border-bottom: 1px solid #e6e6e6;">
								거래번호 :
								<%=gradedto.getTradeNo()%></p>
							<%
								if (gradedto.getGrade().equals("매우만족")) {
							%>
							<p class="col-lg-6 col-md-6 col-sm-6 col-xs-6 no-mg-no-pd"
								style="text-align: right; border-bottom: 1px solid #e6e6e6;">
								<i class="fa fa-smile-o" style="color: green;"></i><%=gradedto.getGrade()%>
							</p>
							<%
								} else if (gradedto.getGrade().equals("만족")) {
							%>
							<p class="col-lg-6 col-md-6 col-sm-6 col-xs-6 no-mg-no-pd"
								style="text-align: right; border-bottom: 1px solid #e6e6e6;">
								<i class="fa fa-smile-o" style="color: skyblue;"></i><%=gradedto.getGrade()%>
							</p>
							<%
								} else if (gradedto.getGrade().equals("보통")) {
							%>
							<p class="col-lg-6 col-md-6 col-sm-6 col-xs-6 no-mg-no-pd"
								style="text-align: right; border-bottom: 1px solid #e6e6e6;">
								<i class="fa fa-meh-o" style="color: yellow;"></i><%=gradedto.getGrade()%>
							</p>
							<%
								} else if (gradedto.getGrade().equals("불만족")) {
							%>
							<p class="col-lg-6 col-md-6 col-sm-6 col-xs-6 no-mg-no-pd"
								style="text-align: right; border-bottom: 1px solid #e6e6e6;">
								<i class="fa fa-frown-o" style="color: purple;"></i><%=gradedto.getGrade()%>
							</p>
							<%
								} else if (gradedto.getGrade().equals("매우불만족")) {
							%>
							<p class="col-lg-6 col-md-6 col-sm-6 col-xs-6 no-mg-no-pd"
								style="text-align: right; border-bottom: 1px solid #e6e6e6;">
								<i class="fa fa-frown-o" style="color: red;"></i><%=gradedto.getGrade()%>
							</p>
							<%
								}
							%>
							<p class="col-lg-12 col-md-12 col-sm-12 col-xs-12 no-mg-no-pd"
								style="border-bottom: 1px solid gray; margin-bottom: 10px; padding: 10px;"><%=gradedto.getGradeContent()%>
							</p>

							<%
								}
							%>
							<%
								if (gradedto == null) {
							%>

							<p class="col-lg-12 col-md-12 col-sm-12 col-xs-12 no-mg-no-pd"
								style="border-bottom: 1px solid gray; padding: 20px; text-align: center;">받은
								평가가 없습니다</p>
							<%
								} else {
									gradedto = null;
								}
							%>

						</div>
						<div role="tabpanel"
							class="tab-pane fade col-lg-12 col-md-12 col-sm-12 col-xs-12 no-mg-no-pd"
							id="profile" aria-labelledby="profile-tab">

							<%
								for (int i = 0; i < selltypesize; i++) {
									gradedto = gradeSellTypelist.get(i);
							%>

							<p class="col-lg-6 col-md-6 col-sm-6 col-xs-6 no-mg-no-pd">
								평가자 :
								<%=gradedto.getGradeUserId()%>
							</p>
							<p class="col-lg-6 col-md-6 col-sm-6 col-xs-6 no-mg-no-pd"
								style="text-align: right;"><%=gradedto.getGradeDate()%>
							</p>
							<p class="col-lg-6 col-md-6 col-sm-6 col-xs-6 no-mg-no-pd"
								style="border-bottom: 1px solid #e6e6e6;">
								거래번호 :
								<%=gradedto.getTradeNo()%></p>
							<%
								if (gradedto.getGrade().equals("매우만족")) {
							%>
							<p class="col-lg-6 col-md-6 col-sm-6 col-xs-6 no-mg-no-pd"
								style="text-align: right; border-bottom: 1px solid #e6e6e6;">
								<i class="fa fa-smile-o" style="color: green;"></i><%=gradedto.getGrade()%>
							</p>
							<%
								} else if (gradedto.getGrade().equals("만족")) {
							%>
							<p class="col-lg-6 col-md-6 col-sm-6 col-xs-6 no-mg-no-pd"
								style="text-align: right; border-bottom: 1px solid #e6e6e6;">
								<i class="fa fa-smile-o" style="color: skyblue;"></i><%=gradedto.getGrade()%>
							</p>
							<%
								} else if (gradedto.getGrade().equals("보통")) {
							%>
							<p class="col-lg-6 col-md-6 col-sm-6 col-xs-6 no-mg-no-pd"
								style="text-align: right; border-bottom: 1px solid #e6e6e6;">
								<i class="fa fa-meh-o" style="color: yellow;"></i><%=gradedto.getGrade()%>
							</p>
							<%
								} else if (gradedto.getGrade().equals("불만족")) {
							%>
							<p class="col-lg-6 col-md-6 col-sm-6 col-xs-6 no-mg-no-pd"
								style="text-align: right; border-bottom: 1px solid #e6e6e6;">
								<i class="fa fa-frown-o" style="color: purple;"></i><%=gradedto.getGrade()%>
							</p>
							<%
								} else if (gradedto.getGrade().equals("매우불만족")) {
							%>
							<p class="col-lg-6 col-md-6 col-sm-6 col-xs-6 no-mg-no-pd"
								style="text-align: right; border-bottom: 1px solid #e6e6e6;">
								<i class="fa fa-frown-o" style="color: red;"></i><%=gradedto.getGrade()%>
							</p>
							<%
								}
							%>
							<p class="col-lg-12 col-md-12 col-sm-12 col-xs-12 no-mg-no-pd"
								style="border-bottom: 1px solid gray; margin-bottom: 10px; padding: 10px;"><%=gradedto.getGradeContent()%>
							</p>

							<%
								}
							%>
							<%
								if (gradedto == null) {
							%>

							<p class="col-lg-12 col-md-12 col-sm-12 col-xs-12 no-mg-no-pd"
								style="border-bottom: 1px solid gray; padding: 20px; text-align: center;">받은
								평가가 없습니다</p>
							<%
								} else {
									gradedto = null;
								}
							%>
						</div>
					</div>

				</div>

			</div>

		</div>

	</div>

	<script src="/HaveANiceDream/Theme/assets/js/jquery.js"></script>
	<script src="/HaveANiceDream/Theme/assets/js/bootstrap.min.js"></script>
	<script src="/HaveANiceDream/Theme/assets/js/jquery.scrollTo.min.js"></script>
	<script src="/HaveANiceDream/Theme/assets/js/jquery.nicescroll.js"
		type="text/javascript"></script>


	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							$
									.ajax({
										url : "/HaveANiceDream/user/select.do",
										type : "GET",
										data : {
											"userId" : opener.document.itisform.selUserID.value,
											"state" : "USERLIST"
										},
										dataType : "json",
										success : function(resp) {
											$("#userName").text(resp.userName);
											$("#userImage").attr(
													"src",
													"/HaveANiceDream/uploadresources/user/"
															+ resp.userImage);
											$("#userId").text(resp.userId);
											$("#userEmail")
													.text(resp.userEmail);
											$("#userZipcode").text(
													resp.userZipcode);
											$("#userAddr").text(
													"(" + resp.userZipcode
															+ ")"
															+ resp.userAddr);
											$("#userAddrDetail").text(
													resp.userAddrDetail);
											$("#userTel").text(resp.userTel);
											$("#userType").text(resp.userType);
										}
									});
						});
		function chatstart() {
			opener.showTalkList($("#userId").text(), $("#userName").text());
		}
	</script>

</body>
</html>