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

<script type="text/javascript">
	function setPath(url) {

		location.href = "/HaveANiceDream/view.html?url=" + url;
	}
</script>

</head>

<body>
	<%
		MemberDTO user = (MemberDTO) session.getAttribute("user");
		//System.out.println(user);
	%>


	<!-- **********************************************************************************************************************************************************
      MAIN SIDEBAR MENU
      *********************************************************************************************************************************************************** -->
	<!--sidebar start-->
	<aside>
		<div id="sidebar" class="nav-collapse">
			<!-- sidebar menu start-->
			<ul class="sidebar-menu" id="nav-accordion">
				<%
					if (user != null) {
				%>
				<p class="centered">
					<a
						href="/HaveANiceDream/user/select.do?userId=<%=user.getUserId()%>&state=SHOWMYPAGE">
						<img
							src="/HaveANiceDream/uploadresources/user/<%=user.getUserImage()%>"
							class="img-circle" width="60">
					</a>
				</p>
				<h5 class="centered"><%=user.getUserName()%></h5>

				<li class="sub-menu">
					<a href="javascript:;">
						<i class="fa fa-desktop"></i>
						<span>My page</span>
					</a>
					<ul class="sub">
						<li>
							<a href="/HaveANiceDream/trade/list.do">거래내역 조회</a>
						</li>
						<li>
							<a href="/HaveANiceDream/point/list.do">포인트 조회</a>
						</li>
						<li>
							<a href="/HaveANiceDream/attendance/list.do">출석체크</a>
						</li>

					</ul>
				</li>

				<%
					}
				%>
				<li class="sub-menu">
					<a href="javascript:;">
						<i class="fa fa-cogs"></i>
						<span>거래</span>
					</a>
					<ul class="sub">
						<li>
							<%
								if (user != null) {
							%><a href="/HaveANiceDream/category/read.do">물품등록</a>
							<%
								} else {
							%><a href="/HaveANiceDream/user/login.html">물품등록</a>
							<%
								}
							%>
						</li>
						<li>
							<a href="/HaveANiceDream/product_list.do?state=ALL&paging=1">물품검색</a>
						</li>
					</ul>
				</li>
				<li class="sub-menu">
					<a href="javascript:;">
						<i class="fa fa-book"></i>
						<span>커뮤니티</span>
					</a>
					<ul class="sub">
						<li>
							<a
								href="/HaveANiceDream/board/list.do?url=../board/board_list.jsp">자유게시판</a>
						</li>
					</ul>
				</li>
				<li class="sub-menu">
					<a href="javascript:;">
						<i class="fa fa-th"></i>
						<span>신고</span>
					</a>
					<ul class="sub">
						<li>
							<%
								if (user != null) {
							%>
							<a href="javascript:setPath('../blame/report_boss.jsp')">신고하기</a>
							<%
								} else {
							%><a href="/HaveANiceDream/user/login.html">신고하기</a>
							<%
								}
							%>
						</li>
						<li>
							<%
								if (user != null) {
							%>
							<a href="/HaveANiceDream/blame/list.do?state=1">신고내역조회</a>
							<%
								} else {
							%><a href="/HaveANiceDream/user/login.html">신고내역조회</a>
							<%
								}
							%>
						</li>

					</ul>
				</li>
				<%
					if (user != null && user.getUserType().equals("관리자")) {
				%>
				<li class="sub-menu">
					<a href="javascript:;">
						<i class=" fa fa-bar-chart-o"></i>
						<span>관리자</span>
					</a>
					<ul class="sub">
						<li>
							<a href="/HaveANiceDream/user/list.do">회원 조회</a>
						</li>
						<li>
							<a href="/HaveANiceDream/user/block/list.do">차단유저 조회</a>
						</li>
						<li>
							<a href="/HaveANiceDream/blame/list.do?state=2">신고접수내역</a>
						</li>

					</ul>
					<%
						}
					%>
				
			</ul>
			<!-- sidebar menu end-->
		</div>
	</aside>
	<!--sidebar end-->



</body>
</html>
