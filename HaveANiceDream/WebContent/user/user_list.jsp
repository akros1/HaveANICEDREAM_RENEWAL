<%@page import="java.text.SimpleDateFormat"%>
<%@page import="user.dto.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
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
		회원 조회
	</h3>
	<div class="row mt">

		<div class="col-md-12">
			<div class="content-panel">
				<form class="form-horizontal style-form" method="get"
					action="/HaveANiceDream/user/list.do">
					<div class="form-group">
						<div class="col-sm-2 ">
							<select class="form-control" name="searchType">
								<option value="1">회원 ID</option>
								<option value="2">회원 이름</option>
							</select>
						</div>
						<div class="col-sm-8">
							<input type="text" class="form-control" name="searchCondi">
						</div>
						<div class="col-sm-2">
							<button type="submit"
								class="btn btn-round btn-primary form-control">검색</button>
						</div>
					</div>
				</form>
				<table class="table table-striped table-advance table-hover">
					<thead>
						<tr>
							<th>ID</th>
							<th>마지막 접속 날짜</th>
							<th>로그인 방법</th>
							<th>회원종류</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<%
							ArrayList<MemberDTO> userList = (ArrayList<MemberDTO>) request.getAttribute("userlist");
							if (userList != null) {
								int size = userList.size();
								for (int i = 0; i < size; i++) {
									MemberDTO user = userList.get(i);
									String Id = user.getUserId();
									String type = user.getUserType();
						%>
						<tr>
							<td>
								<a href="javascript:showUserInfo('<%=Id%>')"><%=Id%></a>
							</td>
							<td><%=user.getUserLastLoginTime()%></td>
							<td><%=user.getUserLogType()%></td>
							<td><%=type%></td>
							<td>
								<%
									if (type.equals("일반회원")) {
								%>

								<button class="btn btn-danger btn-xs"
									onclick="location.href ='/HaveANiceDream/user/block/insert.do?userId=<%=Id%>'">차단</button>
								<button class="btn btn-primary btn-xs"
									onclick="javascript:urserTypeUpdate('<%=Id%>','관리자')">관리자</button>

								<%
									} else if (type.equals("차단회원")) {
								%>

								<button class="btn btn-danger btn-xs"
									onclick="location.href ='/HaveANiceDream/user/block/delete.do?userId=<%=Id%>&pageType=userlist'">해제</button>

								<%
									} else if (type.equals("관리자")) {
								%>

								<button class="btn btn-primary btn-xs"
									onclick="javascript:urserTypeUpdate('<%=Id%>','일반회원')">일반회원</button>

								<%
									}
								%>
								<button class="btn btn-warning btn-xs"
									onclick="location.href ='/HaveANiceDream/user/delete.do?userId=<%=Id%>'">탈퇴</button>
							</td>
						</tr>
						<%
							}
							}
						%>
					</tbody>
				</table>
			</div>
			<!-- /content-panel -->
		</div>
		<!-- /col-md-12 -->
	</div>
	<form action="" name="itisform">
		<input type="hidden" name="selUserID" id="selUserID">
	</form>
	<script type="text/javascript">
		function urserTypeUpdate(id, type) {
			_type = encodeURIComponent(type);
			location.href = '/HaveANiceDream/user/updatetype.do?userId=' + id
					+ '&userType=' + _type;
		}
		function showUserInfo(id) {
			num = 1;
			$("#selUserID").val(id);
			url = "/HaveANiceDream/grade/list.do?id=" + id;
			popup = window.open(url, num,
					"width=400,height=700,left=100 top=50");
			num++;
		}
	</script>

</body>
</html>
