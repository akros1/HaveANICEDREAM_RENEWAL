<%@page import="manager_blame.dto.Manager_BlameDTO"%>
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
<script src="/HaveANiceDream/Theme/assets/js/jquery.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	$(document).ready(function() {
		$.ajax({
			url : "/HaveANiceDream/manager_blame/select1.do",
			type : "GET",
			data : {
				"blameNo" : opener.document.formlist.list.value
			},
			dataType : "json",
			success : function(res) {
				$("#title").text(res.blameTitle);
				$("#content").text(res.blameContent);
				$("#date").text(res.blameDate);
				$("#answertitle").text(res.answerTitle);
				$("#answercontent").text(res.answerContent);
				$("#answerdate").text(res.answerDate);
			},

		});

	});
</script>
</head>
<body>
	<h3>
		<i class="fa fa-angle-right"></i>신고내역
	</h3>
	<div >
		<div class="row mt">
			<div class="col-lg-12">

				<table class="request-view" summary="표" border="1" cellspacing="0" cellpadding="0"
					 style="box-shadow:1px 1px 1px black; margin-top: 50px; border-color:silver;">

					<tbody>
						<tr>
							<td class="first" scope="col" style="border-color: white;">제목</td>
							<td scope="col" style="border-color: white;">문의일시</td>
						</tr>

						<td style="border-color: white;">
							<div class="inner-box">
								<p class="subject">
									<em class="faq-icon">제목: </em> <span class="slideBtn"
										id="title"> </span>
								</p>
								<label class="faq-icon">내용: <span class="inner-view"
									id="content">									
									 </span></label>
							</div>
						</td>

						<td class="linebg" style="border-color: white;">
							<div class="inner-box02" id="date"></div>
						</td>

						<tr>
							<td style="border-color: white;">
								<div class="inner-box">
									<p class="subject">
										<em class="faq-icon type02">제목: </em><span class="input-box"
											id="answertitle"></span>
									</p>
									<label class="faq-icon">내용:<span class="inner-view"
										id="answercontent"> </span></label>
								</div>
							</td>

							<td class="linebg02" style="border-color: white;">
								<div class="inner-box02" name="answerdate" id="answerdate"></div>
							</td>
						</tr>
					</tbody>
				</table>

			</div>
		</div>
	</div>
</body>
</html>