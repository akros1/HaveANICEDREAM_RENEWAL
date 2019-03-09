
<%@page import="point.dto.PointDTO"%>
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
		포인트 내역
	</h3>
	<div class="row mt">
		<div class="col-lg-12">
			<div class="content-panel">
				<section id="unseen">
					<table class="table table-bordered table-striped table-condensed">
						<thead>
							<tr>
								<th>No.</th>
								<th>날짜</th>
								<th>내용</th>
								<th class="numeric">사용포인트</th>
								<th class="numeric">생성포인트</th>
								<th class="numeric">남은포인트</th>
							</tr>
						</thead>
						<tbody>
							<%
								ArrayList<PointDTO> pointlist = (ArrayList<PointDTO>) request.getAttribute("pointlist");

								if (pointlist != null) {
									int size = pointlist.size();

									int total = 0;
									int point = 0;
									int usedPoint = 0;
									int getPoint = 0;

									PointDTO dto = null;

									for (int i = 0; i < size; i++) {
										dto = pointlist.get(i);
										point = dto.getPoint();
										total += point;

										if (point > 0) {
											usedPoint = 0;
											getPoint = point;

										} else {
											usedPoint = getPoint * (-1);
											getPoint = 0;
										}
							%>
							<tr>
								<td><%=dto.getPointNo()%></td>
								<td><%=dto.getPointDate()%></td>
								<td><%=dto.getPointType()%></td>
								<td class="numeric"><%=usedPoint%></td>
								<td class="numeric"><%=getPoint%></td>
								<td class="numeric"><%=total%></td>
							</tr>
							<%
								}
								}
							%>
						</tbody>
					</table>
				</section>
			</div>
			<!-- /content-panel -->
		</div>
		<!-- /col-lg-4 -->
	</div>


</body>
</html>
