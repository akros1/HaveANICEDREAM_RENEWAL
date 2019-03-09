<%@page import="grade.dto.GradeDTO"%>
<%@page import="javafx.scene.control.Alert"%>
<%@page import="trade.dto.TradeDTO"%>
<%@page import="product.dto.ProductDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="user.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

<script>
	$.datepicker.setDefaults({
		dateFormat : 'yy-mm-dd',
		prevText : '이전 달',
		nextText : '다음 달',
		monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월',
				'10월', '11월', '12월' ],
		monthNamesShort : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월',
				'9월', '10월', '11월', '12월' ],
		dayNames : [ '일', '월', '화', '수', '목', '금', '토' ],
		dayNamesShort : [ '일', '월', '화', '수', '목', '금', '토' ],
		dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ],
		showMonthAfterYear : true,
		yearSuffix : '년'
	});

	$(function() {
		$("#datepicker1, #datepicker2").datepicker();
	});
</script>

<!-- 추가한 부분 입니다                                                             -->

<script type="text/javascript">
	
	function setPath(url) {

		location.href = "/HaveANiceDream/view.html?url=" + url;
	}
	function popup(){
   		window.open("/HaveANiceDream/Trade/trade_ing-detail.jsp", "button", "width=1000, height=600, left=100, top=50")
   		
   	}
	function popup2(){
   		window.open("/HaveANiceDream/Trade/trade_gread.jsp", "a", "width=700, height=500, left=100, top=50")
   		
   	}
	
	function showUserInfo(id) {
		num = 1;
		$("#selUserID").val(id);
		url = "/HaveANiceDream/grade/list.do?id="+id;
		popup = window.open(url,num,"width=350,height=600,left=100 top=50");
		num++;
	}
	
	function detailview(tradeNo,productNo){
		num2 = 1;
		$("#tradeNo").val(tradeNo);
		$("#productNo").val(productNo);//팝업의 이름 
		popup =	window.open("/HaveANiceDream/Trade/trade_ing-detail.jsp", num2, "width=1000, height=600, left=100, top=50");
		num2++;
	}
	function statePath(tradeNo,productNo){
		location.href = "/HaveANiceDream/trade/stateupdate.do?productNo="+productNo+"&tradeNo="+tradeNo;
	}
	
	function gradePath(tradeNo,productNo,state){
		url = "/HaveANiceDream/Trade/trade_gread.jsp?productNo="+productNo+"&tradeNo="+tradeNo+"&state="+state;
		window.open(url , "a", "width=700, height=500, left=100, top=50");
		
	}
	function delPath(tradeNo,productPrice){
		location.href = "/HaveANiceDream/trade/delete.do?tradeNo="+tradeNo+"&productPrice="+productPrice;
	}
	function reportPath(url) {

		location.href = "/HaveANiceDream/view.html?url=" + url;
	}
</script>
</head>

<body>
	<%
		MemberDTO user = (MemberDTO) session.getAttribute("user");
		ArrayList<TradeDTO> tradelist = (ArrayList<TradeDTO>) request.getAttribute("tradelist");
		ArrayList<ProductDTO> productlist = (ArrayList<ProductDTO>) request.getAttribute("productlist");
		ArrayList<GradeDTO> gradelist = (ArrayList<GradeDTO>) request.getAttribute("gradelist");
		int gradesize = gradelist.size();
		int size = tradelist.size();
		int gradechk = 0;
		TradeDTO tradedto = null;
		ProductDTO productdto = null;
		GradeDTO gradedto = null;
	%>
	<div class="col-md-12 col-sm-12 col-xs-12"
		style="background-color: #ffffff">
		<h4>
			<i class="fa fa-angle-right"></i>
			거래 |
			<span style="color: black; font-weight: 900; font-size: 16pt;">드림
				내역 확인</span>
		</h4>
		<hr>
		<!-- <div class="col-md-2 col-sm-2 col-xs-2 trade-lookup-con"
			style="border-right: none; text-align: right;">기간별조회</div>
		<div class="col-md-3 col-sm-3 col-xs-3 trade-lookup-con no-mg-no-pd"
			style="border-left: none; border-right: none; text-align: left;">
			<div class="btn-group">
				<button type="button"
					class="btn btn-default btn-sm btn-pointer-height">1개월</button>
				<button type="button"
					class="btn btn-default btn-sm btn-pointer-height">2개월</button>
				<button type="button"
					class="btn btn-default btn-sm btn-pointer-height">6개월</button>
			</div>
		</div>
		<div class="col-md-6 col-sm-6 col-xs-6 no-mg-no-pd" style="text-align: left;">
			<div class="col-md-3 col-sm-3 col-xs-3 trade-lookup-con2">
				<form class="demo-3">
					<input type="text" id="datepicker1"
						class="form-control text-height-con"> <i
						class="fa fa-calendar"></i>
				</form>
			</div>
			<div class="col-md-1 col-sm-1 col-xs-1 trade-lookup-con2 centered">~</div>
			<div class="col-md-3 col-sm-3 col-xs-3 trade-lookup-con2">
				<form class="demo-3">
					<input type="text" id="datepicker2"
						class="form-control text-height-con"> <i
						class="fa fa-calendar"></i>
				</form>
			</div>
			<div class="col-md-2 col-sm-2 col-xs-2 trade-lookup-con2">
				<button class="btn btn-default btn-sm" style="padding-top: 0">조회하기
					▶</button>
			</div>
			<div class="col-md-3 col-sm-3 col-xs-3 trade-lookup-con2"></div>
		</div> 
		<div class="col-md-1 col-sm-1 col-xs-1 trade-lookup-con no-mg-no-pd"
			style="border-left: none;"></div>-->
		<div class="content-panel">
			<div class="col-md-12 col-sm-12 col-xs-12 trade-ing-line pd-con">

				<div class="col-md-2 col-sm-2 col-xs-2">거래 날짜</div>
				<div class="col-md-5 col-sm-5 col-xs-5">드림 정보</div>
				<div class="col-md-3 col-sm-3 col-xs-3">상태</div>
				<div class="col-md-2 col-sm-2 col-xs-2">취소 및 신고</div>
			</div>

			<%
				for (int i = 0; i < size; i++) {
					tradedto = tradelist.get(i);
					productdto = productlist.get(i);
					gradechk = 0;
					if (!tradedto.getTradeState().equals("거래취소")) {
			%>
			<div class="col-md-12 col-sm-12 col-xs-12 pd-con"
				style="border-bottom: 1px solid black;">
				<div class="col-md-2 col-sm-2 col-xs-2 trade-ing-date height-sort">
					<p><%=tradedto.getTradeStartDate()%></p>
					<div class="col-md-12 col-sm-12 col-xs-12">
						<button class="label label-default trade-btn-height"
							onclick="javascript:detailview(<%=tradedto.getTradeNo()%>,<%=productdto.getProductNo()%>)">거래상세보기</button>
					</div>
				</div>
				<div class="col-md-5 col-sm-5 col-xs-5">
					<div class="col-md-3 col-sm-3 col-xs-3">
						<img class="self-img-full-cont2"
							src="/HaveANiceDream/uploadresources/product/<%=productdto.getImageSrc()%>">
					</div>
					<div class="col-md-9 col-sm-9 col-xs-9">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<ul class="no-mg-no-pd">
								<li id="header_inbox_bar" class="dropdown">
									<i class="fa fa-user mr" style="color: #1f85e2"></i>
									<a data-toggle="dropdown" href="index.html#"><%=tradedto.getUserIdSell()%></a>
									<%
										if (tradedto.getUserIdBuy().equals(user.getUserId())) {
									%>

									<%
										} else {
									%>
									<label style="margin-left: 5px">(내가등록한물품)</label>
									<button class="label label-default trade-btn-height2"
										style="width: 95px;"
										onclick="javascript:showUserInfo('<%=tradedto.getUserIdBuy()%>')">상대방
										정보 확인</button>
									<%
										}
									%>
									<ul class="dropdown-menu dropdown-kk inbox">
										<li>
											<a
												href="javascript:showUserInfo('<%=tradedto.getUserIdSell()%>')">프로필
												보기</a>
										</li>

										<li>
											<a
												href="javascript:showTalkList('<%=tradedto.getUserIdSell()%>','<%=tradedto.getUserIdSell()%>')">1:1채팅</a>
										</li>

									</ul>
								</li>
							</ul>
						</div>
						<div class="col-md-12 col-sm-12 col-xs-12">
							글제목 :
							<a><%=productdto.getProductTitle()%></a>
						</div>
						<div class="col-md-12 col-sm-12 col-xs-12">
							거래번호:
							<%=tradedto.getTradeNo()%></div>
						<div class="col-md-12 col-sm-12 col-xs-12">
							거래 포인트 :
							<label class="text-price-point-state"><%=productdto.getProductPrice()%></label>
							포인트
						</div>
					</div>
				</div>
				<div class="col-md-3 col-sm-3 col-xs-3 centered height-sort">
					<div class="col-md-12 col-sm-12 col-xs-12">
						<%
							if (tradedto.getTradeState().equals("거래대기")) {
						%>
						<label class="text-price-point-state"
							style="margin-bottom: 10px; color: #dd2b4e"><%=tradedto.getTradeState()%>
						</label>
						<%
							} else if (tradedto.getTradeState().equals("거래중")) {
						%>
						<label class="text-price-point-state"
							style="margin-bottom: 10px; color: #1290c3"><%=tradedto.getTradeState()%>
						</label>
						<%
							} else {
						%>
						<label class="text-price-point-state" style="margin-bottom: 10px;">거래완료
						</label>
						<%
							}
						%>
					</div>
					<%
						if (tradedto.getTradeState().equals("거래대기")) {
									if (tradedto.getUserIdBuy().equals(user.getUserId())) {
					%>
					<div class="col-md-12 col-sm-12 col-xs-12">
						<label>인계 대기 중 </label>
					</div>
					<%
						} else {
					%>
					<div class="col-md-12 col-sm-12 col-xs-12">
						<a id="add-regular" class="btn btn-default btn-sm"
							href="javascript:;">필수확인</a>


						<button class="btn btn-primary btn-sm" data-toggle="modal"
							data-target="#myModal<%=tradedto.getTradeNo()%>">인계확인</button>

						<!-- Modal -->
						<div class="modal fade" id="myModal<%=tradedto.getTradeNo()%>"
							tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
							aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-hidden="true"></button>
										<h4 class="modal-title"
											id="myModalLabel<%=tradedto.getTradeNo()%>">인계 완료</h4>
									</div>
									<div class="modal-body">물품을 인계하시겠습니까?</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default"
											data-dismiss="modal">아니요</button>
										<button type="button" class="btn btn-primary"
											onclick="javascript:statePath
										(<%=tradedto.getTradeNo()%>,<%=productdto.getProductNo()%>)"
											data-dismiss="modal">예</button>
									</div>
								</div>
							</div>
						</div>
						<!-- end Modal -->
					</div>


					<%
						}
								} else if (tradedto.getTradeState().equals("거래중")) {
									if (tradedto.getUserIdBuy().equals(user.getUserId())) {
					%>
					<div class="col-md-12 col-sm-12 col-xs-12">
						<a id="add-regular" class="btn btn-default btn-sm"
							href="javascript:;">필수확인</a>


						<button class="btn btn-primary btn-sm" data-toggle="modal"
							data-target="#myModal<%=tradedto.getTradeNo()%>">인수확인</button>

						<!-- Modal -->
						<div class="modal fade" id="myModal<%=tradedto.getTradeNo()%>"
							tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
							aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-hidden="true"></button>
										<h4 class="modal-title"
											id="myModalLabel<%=tradedto.getTradeNo()%>">인수 완료</h4>
									</div>
									<div class="modal-body">물품을 인수받았나요?</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default"
											data-dismiss="modal">아니요</button>
										<button type="button" class="btn btn-primary"
											onclick="javascript:statePath
											(<%=tradedto.getTradeNo()%>,<%=productdto.getProductNo()%>)"
											data-dismiss="modal">예</button>
									</div>
								</div>
							</div>
						</div>
						<!-- end Modal -->
					</div>
					<%
						} else {
					%>
					<div class="col-md-12 col-sm-12 col-xs-12">
						<label>인수 기다리는 중 </label>
					</div>

					<%
						}
								} else if (tradedto.getTradeState().equals("거래완료")) {
									if (tradedto.getUserIdBuy().equals(user.getUserId())) { //구매자라면?
					%>
					<div class="col-md-12 col-sm-12 col-xs-12">
						<button class="btn btn-default btn-sm"
							onclick="javascript:gradePath
												(<%=tradedto.getTradeNo()%>,<%=productdto.getProductNo()%>,'1')">판매자
							평가</button>
					</div>
					<%
						} else { //판매자라면?
					%>
					<div class="col-md-12 col-sm-12 col-xs-12">
						<button class="btn btn-default btn-sm"
							onclick="javascript:gradePath
												(<%=tradedto.getTradeNo()%>,<%=productdto.getProductNo()%>,'2')">구매자
							평가</button>
					</div>
					<%
						}
								} else if (tradedto.getTradeState().equals("댓글완료1")) {
									if (tradedto.getUserIdBuy().equals(user.getUserId())) {//구매자
					%>
					<div class="col-md-12 col-sm-12 col-xs-12"></div>
					<%
						} else { //판매자라면?
					%>
					<div class="col-md-12 col-sm-12 col-xs-12">
						<button class="btn btn-default btn-sm"
							onclick="javascript:gradePath
												(<%=tradedto.getTradeNo()%>,<%=productdto.getProductNo()%>,'4')">구매자
							평가</button>
					</div>
					<%
						}
								} else if (tradedto.getTradeState().equals("댓글완료2")) {
									if (tradedto.getUserIdBuy().equals(user.getUserId())) {//구매자
					%>
					<div class="col-md-12 col-sm-12 col-xs-12">
						<button class="btn btn-default btn-sm"
							onclick="javascript:gradePath
												(<%=tradedto.getTradeNo()%>,<%=productdto.getProductNo()%>,'3')">판매자
							평가</button>
					</div>
					<%
						} else { //판매자라면?
					%>
					<div class="col-md-12 col-sm-12 col-xs-12"></div>
					<%
						}
								} else if (tradedto.getTradeState().equals("댓글완료3") || tradedto.getTradeState().equals("댓글완료4")) {
									if (tradedto.getUserIdBuy().equals(user.getUserId())) {//구매자
					%>
					<div class="col-md-12 col-sm-12 col-xs-12"></div>
					<%
						} else { //판매자라면?
					%>
					<div class="col-md-12 col-sm-12 col-xs-12"></div>
					<%
						}
								}
					%>

				</div>

				<div class="col-md-2 col-sm-2 col-xs-2 centered height-sort">
					<%
						if (tradedto.getTradeState().equals("거래대기") || tradedto.getTradeState().equals("거래중")) {
									if (tradedto.getUserIdSell().equals(user.getUserId())) {
										int modalnum = 100 + i;
					%>
					<div class="col-md-12 col-sm-12 col-xs-12">
						<button type="button" class="btn btn-warning btn-sm"
							style="margin-bottom: 10px;" data-toggle="modal"
							data-target="#myModal<%=modalnum%>">거래취소</button>
						<!-- Modal -->
						<div class="modal fade" id="myModal<%=modalnum%>" tabindex="-1"
							role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header" style="background-color: #dd2b4e">
										<button type="button" class="close" data-dismiss="modal"
											aria-hidden="true"></button>
										<h4 class="modal-title" id="myModalLabel<%=modalnum%>">거래
											취소</h4>
									</div>
									<div class="modal-body">거래를 취소하겠습니까?</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default"
											data-dismiss="modal">아니요</button>
										<button type="button" class="btn btn-primary"
											onclick="javascript:delPath(<%=tradedto.getTradeNo()%>,<%=productdto.getProductPrice()%>)"
											data-dismiss="modal">예</button>
									</div>
								</div>
							</div>
						</div>
						<!-- end Modal -->
					</div>
					<%
						}
					%>

					<%
						}
					%>
					<div class="col-md-12 col-sm-12 col-xs-12">
						<button type="button" class="btn btn-danger btn-sm"
							onclick="javascript:reportPath('../blame/report_boss.jsp')">신고</button>
					</div>
				</div>
			</div>
			<%
				}
				}
			%>
			<%
				if (tradedto == null) {
			%>
			<div class="col-md-12 col-sm-12 col-xs-12 centered height-sort"
				style="text-align: center;">
				<div class="col-md-12 col-sm-12 col-xs-12"
					style="text-align: center;">
					<label class="text-price-point-state" style="margin-bottom: 10px;">드림
						내역이 없습니다!</label>
				</div>
			</div>
			<%
				}
			%>
		</div>
		<div class="col-md-12 col-sm-12 col-xs-12 text-center">
			<ul class="pagination">
				<li class="previous">
					<a href="#">이전</a>
				</li>
				<li>
					<a href="#">1</a>
				</li>
				<li>
					<a href="#">2</a>
				</li>
				<li>
					<a href="#">3</a>
				</li>
				<li>
					<a href="#">4</a>
				</li>
				<li>
					<a href="#">5</a>
				</li>
				<li class="next">
					<a href="#">다음</a>
				</li>
			</ul>
		</div>
	</div>

	<form action="" name="itisform">
		<input type="hidden" name="selUserID" id="selUserID">
	</form>
	<form action="" name="itisform2">
		<input type="hidden" name="tradeNo" id="tradeNo">
	</form>
	<form action="" name="itisform3">
		<input type="hidden" name="productNo" id="productNo">
	</form>
</body>
</html>
