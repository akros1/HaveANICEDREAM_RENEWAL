<%@page import="user.dto.MemberDTO"%>
<%@page import="attendance.dto.AttendanceDTO"%>
<%@page import="java.sql.Date"%>

<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	
<%MemberDTO dto = (MemberDTO) session.getAttribute("user");%>
	$(document).ready(function() {
		$("#click").on("click", function() {
			location.href = "/HaveANiceDream/attendance/insert.do";
		});
	});
</script>
</head>
<body>
	<%
		ArrayList<Date> date = (ArrayList) request.getAttribute("attDate");
	%>
	<h3 style="margin-left: 30px;">
		<i class="fa fa-angle-right"></i>
		출석체크
	</h3>
	<div class="form-panel-calendar" style="width: 700px;">
		<div class="row mt">
			<div class="col-lg-12 calender-board">
				<div class="page">
					<div style="width: 100%; max-width: 600px; display: inline-block;">
						<div class="monthly" id="mycalendar"></div>
					</div>

				</div>
			</div>

			<div class="col-lg-12" style="margin-left: 10px;">
				<br />
				<br />
				<br />
				<br />
				<%
					if (!(boolean) session.getAttribute("attFlag")) {
				%>
				<button class="btn btn-primary" type="button" name="check"
					id="click">출석체크</button>

				<%
					}
				%>
			</div>

		</div>
	</div>



</body>
</html>