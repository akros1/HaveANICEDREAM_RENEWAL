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

<script src="/HaveANiceDream/Theme/assets/js/jquery.js"></script>
<title>DASHGUM - Bootstrap Admin Template</title>
<script src="/HaveANiceDream/Theme/assets/js/Filechose.js"></script>

</head>

<body>
	<%
		MemberDTO user = (MemberDTO) session.getAttribute("user");
	%>
	<h3 style="margin-left: 30px;">
		<i class="fa fa-angle-right"></i>신고하기
	</h3>
	<div class="form-panel-panel">
		<div class="row mt">
			<div class="col-lg-12">

				<form action="/HaveANiceDream/blame/insert.do" method="post" enctype="multipart/form-data">
					<table summary="신고정보" height="600" border="1"
						style="margin-left: 150px; border-color: silver;">
						<colgroup>
							<col style="width: 14%;">
							<col>
						</colgroup>
						<tbody>
							<tr>
								<th>신고</th>
								<td>신고분류 <select name="blameType">
										<option selected="selected" value="NONE">선택해주세요</option>
										<option value="사기글신고">사기글신고</option>
										<option value="허위신고">허위신고</option>
										<option value="지나친폭언신고">지나친폭언신고</option>
										<option value="광고성글신고">광고성글신고</option>
								</select>
								</td>
							</tr>

							<tr>
								<th>상세정보</th>
								<td>
									<dl>
										<dt>
											<label style="margin-left: 100px;">신고자ID: </label>
											<%=user.getUserId()%>
											<label style="margin-left: 170px;">상대방ID</label>
											<%
												String userIdBlamee = (String) request.getAttribute("userIdBlamee");
												if (userIdBlamee != null) {
											%>
											<span class="input-box"><input name="userIdBlamee"
												type="text" id="auctionno2" class="txt" maxlength="15"
												style="width: 133px;" value="<%=userIdBlamee%>"
												readonly="readonly" /></span>
											<%
												} else {
											%>
											<span class="input-box"><input name="userIdBlamee"
												type="text" id="auctionno2" class="txt" maxlength="15"
												style="width: 133px;" /></span>
											<%
												}
											%>
										</dt>
									</dl>
								</td>
							</tr>
							<tr>
								<th>첨부파일</th>
								<td class="tleft">
									<ul class="inputfile">
										<li>
											<div class="form-group">

												<div class="col-sm-10">
													<div class="filebox bs3-primary preview-image">
														<label for="input_file">파일찾기</label> <input type="file"
															id="input_file" class="upload-hidden" name="boardImg">
													</div>
												</div>
											</div>
										</li>
									</ul>
								</td>
							</tr>
							<tr>
								<th>제목</th>
								<td><span class="input-box"><input name="blameTitle"
										type="text" id="mailtitle" class="txt" title="제목"
										style="width: 440px;" /> <input name="Mcategorybox"
										type="text" value="M0401" id="Mcategorybox"
										style="border-style: None; width: 0px; DISPLAY: none" /> <input
										name="CCodeBox" type="text" id="CCodeBox"
										style="border-style: None; width: 0px; DISPLAY: none" /> </span></td>
							</tr>
							<tr>
								<th>내용</th>
								<td>
									<div>
										<div>
											<textarea name="blameContent" id="mailcontent" rows="100"
												cols="100" title="평가글" maxlength="4000" class="insert-text"
												style="height: 102px;" onfocus="onFocusContent()"></textarea>
										</div>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
			</div>
			<div class="request-bottom" style="margin-left: 750px;">
				<div class="btnbox tright">
					<span class="btn-border"><input type="Submit"
						class="btn btn-primary" value="신고하기" title="신고하기" /></span> <span
						class="btn-border type02"><input type="Submit"
						class="btn btn-primary" value="취소" title="취소" /></span>
				</div>
			</div>
			</form>
		</div>
	</div>
</body>
</html>
