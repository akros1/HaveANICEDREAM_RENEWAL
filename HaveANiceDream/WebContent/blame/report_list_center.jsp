
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
		$("#center").val(i);
		popup = window.open("Answer_list.jsp", "num",
				"width=1000,height=700,left=100 top=50");
		num++;
	}
	$(document).ready(function() {
		$("#search").keyup(function() {
			var k = $(this).val();
			$("#table > tbody > tr").hide();
			var temp = $("#table > tbody > tr > td:contains('" + k + "')");

			$(temp).parent().show();
		});
	});
</script>
</head>

<body>
	<%
		ArrayList<BlameDTO> list = (ArrayList) request.getAttribute("blamelist");
	%>

	<h3>
		<i class="fa fa-angle-right"></i>
		신고 접수내역
	</h3>
	<div class="row mt">

		<div class="col-md-12">
			<div class="content-panel">
				<form class="form-horizontal style-form" method="get" name="form">
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label"
							style="text-align: right;">검색 : </label>
						<div class="col-sm-8">
							<input type="text" class="form-control" id="search">
						</div>
						<input type="hidden" name="list" id="center">
						<!-- <div class="col-sm-2">
							<button type="button"
								class="btn btn-round btn-primary form-control" >검색</button>
						</div> -->
					</div>
				</form>
				<table class="table table-striped table-advance table-hover"
					id="table">
					<thead>
						<tr>
							<th>NO</th>
							<th>신고날짜</th>
							<th>신고분류</th>
							<th>신고자ID</th>
							<th>상대방ID</th>
							<th>제목</th>

						</tr>
					</thead>
					<tbody>
						<%
							if (list != null) {
								int size = list.size();
								for (int i = 0; i < size; i++) {
									BlameDTO dept = list.get(i);
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
