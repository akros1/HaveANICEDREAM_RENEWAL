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

<title>DASHGUM - Bootstrap Admin Template</title>

</head>

<body>
	<h3>
		<i class="fa fa-angle-right"></i>
		내 정보 보기
	</h3>
	<div class="row mt">
		<div class="col-lg-12">
			<div class="form-panel">
				<%
					MemberDTO user = (MemberDTO) session.getAttribute("user");
				%>
				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">아이디</label>
					<div class="col-lg-10">
						<p class="form-control-static"><%=user.getUserId()%></p>
					</div>
				</div>
				<hr>
				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">비밀번호</label>
					<div class="col-sm-8">
						<input type="password" class="form-control" placeholder=""
							value="<%=user.getUserPw()%>">
					</div>
					<div class="col-sm-2">
						<button type="button"
							class="btn btn-round btn-primary form-control"
							data-toggle="modal" data-target="#myModal">변경하기</button>
						<!-- Modal -->
						<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
							aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<form action="/HaveANiceDream/user/updatepass.do" method="post">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">&times;</button>
											<h4 class="modal-title" id="myModalLabel">비밀번호 변경하기</h4>
										</div>
										<div class="modal-body">
											<p>
												<input type="password" id="oldPass" name="oldPass"
													placeholder="현재 비밀번호" autocomplete="off"
													class="form-control placeholder-no-fix">
											</p>
											<p>
												<input type="password" id="newPass" name="newPass"
													placeholder="새로운 비밀번호" autocomplete="off"
													class="form-control placeholder-no-fix">
											</p>
											<p>
												<input type="password" id="newPassConf" placeholder="확인하기"
													autocomplete="off" class="form-control placeholder-no-fix">
											</p>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default"
												data-dismiss="modal">취소</button>
											<button type="submit" class="btn btn-primary">완료</button>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
				<hr>
				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">이름</label>
					<div class="col-lg-10">
						<p class="form-control-static"><%=user.getUserName()%></p>
					</div>
				</div>
				<hr>
				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">주소</label>
					<div class="col-lg-10">
						<p class="form-control-static">
							(<%=user.getUserZipcode()%>)
							<%=user.getUserAddr()%>
							<%=user.getUserAddrDetail()%></p>
					</div>
				</div>
				<hr>
				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">이메일</label>
					<div class="col-lg-10">
						<p class="form-control-static"><%=user.getUserEmail()%></p>
					</div>
				</div>
				<hr>
				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">전화번호</label>
					<div class="col-lg-10">
						<p class="form-control-static"><%=user.getUserTel()%></p>
					</div>
				</div>
				<hr>
				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">포인트</label>
					<div class="col-lg-10">
						<p class="form-control-static"><%=user.getPointTotal()%>점
						</p>
					</div>
				</div>
				<hr>
				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">가입날짜</label>
					<div class="col-lg-10">
						<p class="form-control-static"><%=user.getUserSigdate()%></p>
					</div>
				</div>
				<hr>
				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">최종 방문일</label>
					<div class="col-lg-10">
						<p class="form-control-static"><%=user.getUserLastLoginTime()%></p>
					</div>
				</div>
				<hr>
				<button class="btn btn-theme"
					onclick="location.href='/HaveANiceDream/view.html?url=../user/user_edit_page.jsp'">내
					정보 변경하기</button>
			</div>
		</div>
		<!-- col-lg-12-->
	</div>
	<!-- /row -->

</body>
</html>
