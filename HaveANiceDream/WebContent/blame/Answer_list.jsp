<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="java.util.Enumeration"%>
<%@page import="product.dto.ProductDTO"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="blame.dto.BlameDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="user.dto.MemberDTO"%>
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
			url : "/HaveANiceDream/blame/select.do",
			type : "GET",
			data : {
				"blameNo" : opener.document.form.list.value,
			},
			dataType : "json",
			success : function(res) {
				$("#title").text(res.blameTitle);
				$("#content").text(res.blameContent);
				$("#img").attr("src","/HaveANiceDream/uploadresources/blame/"+res.blamefile);
				$("#date").text(res.blameDate);
				$("#blameNo").val(res.blameNo);
				//alert(res.blameNo);
			}
		});

		$("#click").on("click", function() {
			window.close();
			self.close();
		});
	});
</script>
</head>
<body>
	<h3>
		<i class="fa fa-angle-right"></i>신고내역
	</h3>
	<%
		MemberDTO user = (MemberDTO) session.getAttribute("user");
		
	
	%>
	<div class="row mt">
		<div class="col-lg-12">
			<div class="form-panel">
				<form action="/HaveANiceDream/manager_blame/insert.do" method="get">
					<input type="hidden" name="blameNo" value="" id="blameNo">
					<input type="hidden" name="userId" value="<%=user.getUserId()%>"
						id="userId">
					<table class="request-view" cellspacing="0" cellpadding="0"
						style="box-shadow: 1px 1px 1px black; margin-top: 50px; border-color: silver;"
						summary="표" border="1">
						<colgroup>
							<col style="" />
							<col style="width: 103px;" />
							<col style="width: 95px;" />
						</colgroup>
						<thead>
							<tr>
								<th class="first" scope="col" style="border-color: white;">제목</th>
								<th scope="col" style="border-color: white;">문의일시</th>

							</tr>
						</thead>
						<tbody>
							<tr class="bg-type">
								<td style="border-color: white;">
									<div class="inner-box">
										<p class="subject">
											<em class="faq-icon">제목: </em> <span class="slideBtn"
												id="title"> </span>
										</p>
										<div class="inner-view" id="content">내용:</div>
										
										<img alt="picture" id="img"/>
																	
									</div>
								</td>
								<td class="linebg" style="border-color: white;">
									<div class="inner-box" id="date"></div>
								</td>

							</tr>
							<tr>
								<td style="border-color: white;">
									<div class="inner-box">
										<div class="inner-view">
											<p class="subject">
												<em class="faq-icon type02">제목: </em><span class="input-box"
													id="answertitle"><input name="answerTitle"
													type="text" class="txt" style="width: 440px;" /> </span>
											</p>
											<div class="inner-view">내용:</div>
											<textarea name="answerContent" rows="60" cols="60"
												title="평가글" maxlength="4000" class="insert-text"
												style="height: 120px;" id="answercontent"></textarea>
										</div>
									</div>

								</td>
								<td class="linebg02" style="border-color: white;">
									<div class="inner-box02" name="answerDate" id="answerdate"></div>
								</td>

							</tr>
						</tbody>
					</table>
					<div class="request-bottom">
						<div class="btnbox tright">
							<span class="btn-border"><input type="Submit"
								class="btn btn-primary" value="답변등록" title="답변등록" id="click" /></span>
							<span class="btn-border type02"><input type="Submit"
								class="btn btn-primary" value="취소" title="취소" /></span>
						</div>
					</div>
				</form>
			</div>

		</div>
	</div>

</body>
</html>