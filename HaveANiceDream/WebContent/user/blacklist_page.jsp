<%@page import="java.text.SimpleDateFormat"%>
<%@page import="user.block.dto.BlockDTO"%>
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
		차단회원 조회
	</h3>
	<div class="row mt">

		<div class="col-md-12">
			<div class="content-panel">
				<form class="form-horizontal style-form" method="get">
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label">차단회원 ID</label>
						<div class="col-sm-8">
							<input type="text" class="form-control">
						</div>
						<div class="col-sm-2">
							<button type="button"
								class="btn btn-round btn-primary form-control">검색</button>
						</div>
					</div>
				</form>
				<table class="table table-striped table-advance table-hover">
					<thead>
						<tr>
							<th>ID</th>
							<th>차단날짜</th>
							<th>차단사유</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<%
							ArrayList<BlockDTO> blacklist = (ArrayList<BlockDTO>) request.getAttribute("blocklist");
							SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
							if (blacklist != null) {
								int size = blacklist.size();
								BlockDTO dto = null;
								for (int i = 0; i < size; i++) {
									dto = blacklist.get(i);
									String Id = dto.getUserId();
						%>
						<tr>
							<td><%=Id%></td>
							<td><%=dateFormat.format(dto.getBlockDate())%></td>
							<td><%=dto.getBlockReason()%></td>
							<td>
								<button class="btn btn-danger btn-xs"
									onclick="location.href ='/HaveANiceDream/user/block/delete.do?userId=<%=Id%>&pageType=blacklist'">해제</button>
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
