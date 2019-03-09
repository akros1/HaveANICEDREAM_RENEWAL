
<%@page import="user.dto.MemberDTO"%>
<%@page import="blame.dto.BlameDTO"%>
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
<script type="text/javascript">
	function windowpopup(i) {
		num = 1;
		$("#back").val(i);
		popup = window.open("Answer_list_user.jsp", "num",
				"width=1000,height=700,left=100 top=50");
		num++;
	}
</script>
</head>

<body>
	<%
		ArrayList<BlameDTO> user_list = (ArrayList) request.getAttribute("user_list");
	%>

	<h3>
		<i class="fa fa-angle-right"></i>
		신고 내역
	</h3>
	<div class="row mt">

		<div class="col-md-12">
			<div class="content-panel">
				<form class="form-horizontal style-form" method="get"
					name="formlist">
					<input type="hidden" name="list" id="back">
				</form>
				<table class="table table-striped table-advance table-hover">
					<thead>
						<tr>
							<th>NO</th>
							<th>신고날짜</th>
							<th>신고분류</th>
							<th>신고자ID</th>
							<th>상대방ID</th>
							<th>제목</th>
							<th>처리현황</th>
						</tr>
					</thead>
					<tbody>
						<%
							if (user_list != null) {
								int size = user_list.size();
								for (int i = 0; i < size; i++) {
									BlameDTO dept = user_list.get(i);
						%>

						<tr>
							<td><%=dept.getBlameNo()%></td>
							<td><%=dept.getBlameDate()%></td>
							<td><%=dept.getBlameType()%></td>
							<td><%=dept.getUserIdBlamere()%></td>
							<td><%=dept.getUserIdBlamee()%></td>

							<td>
								<a href="javascript:windowpopup(<%=dept.getBlameNo()%>)"><%=dept.getBlameTitle()%></a>
							</td>
							<td><%=dept.getBlameanswer()%></td>
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
</body>
</html>
