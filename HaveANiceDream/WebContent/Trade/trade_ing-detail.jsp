<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="/HaveANiceDream/Theme/assets/js/jquery.js"></script>

<script type="text/javascript">
	$(document).ready(
			function() {
				$.ajax({
					url : "/HaveANiceDream/trade/detail.do",
					type : "GET",
					data : {
						"tradeNo" : opener.document.itisform2.tradeNo.value,
						"productNo" : opener.document.itisform3.productNo.value
					},
					dataType : "json",
					success : function(res) {
						$("#CategoryName").text(res.CategoryName);
						$("#productImg").attr(
								"src",
								"/HaveANiceDream/uploadresources/product/"
										+ res.productImg);
						$("#ProductTitle").text(res.ProductTitle);
						$("#ProductPrice").text(res.ProductPrice);
						$("#userZipcode").text(res.userZipcode);
						$("#ProductDate").text(res.ProductDate);
						$("#ProductName").text(res.ProductName);
						$("#ProductNo").text(res.ProductNo);
						$("#TradeType").text(res.TradeType);
						$("#sellUserId").text(res.sellUserId);
						$("#sellUserTel").text(res.sellUserTel);
						$("#sellUserEmail").text(res.sellUserEmail);
						$("#buyUserId").text(res.buyUserId);
						$("#buyUserTel").text(res.buyUserTel);
						$("#buyUserEmail").text(res.buyUserEmail);
					}
				});
			});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<title>거래상세page</title>

<!-- Bootstrap core CSS -->
<link href="/HaveANiceDream/Theme/assets/css/bootstrap.css"
	rel="stylesheet">
<!--external css-->
<link
	href="/HaveANiceDream/Theme/assets/font-awesome/css/font-awesome.css"
	rel="stylesheet" />
<!-- Custom styles for this template -->
<link href="/HaveANiceDream/Theme/assets/css/style.css" rel="stylesheet">
<link href="/HaveANiceDream/Theme/assets/css/style-responsive.css"
	rel="stylesheet">

</head>

<body>
	<div class="col-md-12 col-sm-12 col-xs-12"
		style="background-color: #ffffff">
		<h4>
			<i class="fa fa-angle-right"></i>
			거래 |
			<span style="color: black; font-weight: 900; font-size: 16pt;">
				거래상세보기</span>
		</h4>
		<hr>
		<div class="col-md-12 col-sm-12 col-xs-12 trade-lookup-con3"
			style="margin-bottom: 15px;">
			<div class="col-md-8 col-sm-8 col-xs-8">
				<div class="col-md-4 col-sm-4 col-xs-4">
					<img class="self-img-full-cont4" id="productImg"
						src="/HaveANiceDream/Theme/assets/img/portfolio/port05.jpg">
				</div>
				<div class="col-md-8 col-sm-8 col-xs-8"
					style="height: 85px; padding-top: 12px">
					<p class="p-font-sty1" id="CategoryName">카테고리 분류 1 > 카테고리 분류 2</p>
					<p id="ProductTitle">물품 등록한 제목을 입력합니다.</p>
				</div>
			</div>
		</div>
		<h4>
			<i class="fa fa-angle-right icon-sty"></i>
			<span style="color: black; font-weight: 900; font-size: 12pt;">
				물품정보</span>
		</h4>
		<div class="col-md-12 col-sm-12 col-xs-12 trade-lookup-con3"
			style="border: none; background-color: white; margin-bottom: 10px;">
			<div class="col-md-2 col-sm-2 col-xs-2 trade-lookup-con4">
				<p>필요 드림 포인트</p>
			</div>
			<div class="col-md-10 col-sm-10 col-xs-10 trade-lookup-con4"
				style="background-color: white; font-weight: 100; color: red;">
				<p id="ProductPrice">3,000포인트</p>
			</div>
			<div class="col-md-2 col-sm-2 col-xs-2 trade-lookup-con4">
				<p>등록일시</p>
			</div>
			<div class="col-md-10 col-sm-10 col-xs-10 trade-lookup-con4"
				style="background-color: white; font-weight: 100;">
				<p id="ProductDate">2018-01-22</p>
			</div>
			<div class="col-md-2 col-sm-2 col-xs-2 trade-lookup-con4">
				<p>물품이름</p>
			</div>
			<div class="col-md-10 col-sm-10 col-xs-10 trade-lookup-con4"
				style="background-color: white; font-weight: 100;">
				<p id="ProductName">구찌가방</p>
			</div>
			<div class="col-md-2 col-sm-2 col-xs-2 trade-lookup-con4">
				<p>물품번호</p>
			</div>
			<div class="col-md-10 col-sm-10 col-xs-10 trade-lookup-con4"
				style="background-color: white; font-weight: 100;">
				<p id="ProductNo">1110</p>
			</div>
			<div class="col-md-2 col-sm-2 col-xs-2 trade-lookup-con4">
				<p>거래방법</p>
			</div>
			<div class="col-md-10 col-sm-10 col-xs-10 trade-lookup-con4"
				style="background-color: white; font-weight: 100;">
				<p id="TradeType">직거래</p>
			</div>
			<div class="col-md-2 col-sm-2 col-xs-2 trade-lookup-con4">
				<p>거래지역</p>
			</div>
			<div class="col-md-10 col-sm-10 col-xs-10 trade-lookup-con4"
				style="background-color: white; font-weight: 100; margin-bottom: 30px;">
				<p>서울 구로구</p>
			</div>
		</div>

		<h4>
			<i class="fa fa-angle-right icon-sty"></i>
			<span style="color: black; font-weight: 900; font-size: 12pt;">판매자
				정보</span>
			<span style="margin-left: 20px;"></span>
		</h4>
		<div class="col-md-12 col-sm-12 col-xs-12 trade-lookup-con3"
			style="border: none; background-color: white; margin-bottom: 10px;">
			<div class="col-md-2 col-sm-2 col-xs-2 trade-lookup-con4">
				<p>판매자 아이디</p>
			</div>
			<div class="col-md-10 col-sm-10 col-xs-10 trade-lookup-con4"
				style="background-color: white; font-weight: 100;">
				<p id="sellUserId">드림왕</p>
			</div>
			<div class="col-md-2 col-sm-2 col-xs-2 trade-lookup-con4">
				<p>판매자 연락처</p>
			</div>
			<div class="col-md-10 col-sm-10 col-xs-10 trade-lookup-con4"
				style="background-color: white; font-weight: 100;">
				<p id="sellUserTel">010-2222-4444</p>
			</div>
			<div class="col-md-2 col-sm-2 col-xs-2 trade-lookup-con4">
				<p>판매자 이메일</p>
			</div>
			<div class="col-md-10 col-sm-10 col-xs-10 trade-lookup-con4"
				style="background-color: white; font-weight: 100; margin-bottom: 30px;">
				<p id="sellUserEmail">campion@google.com</p>
			</div>
		</div>

		<h4>
			<i class="fa fa-angle-right icon-sty"></i>
			<span style="color: black; font-weight: 900; font-size: 12pt;">구매자
				정보</span>
			<span style="margin-left: 20px;"></span>
		</h4>
		<div class="col-md-12 col-sm-12 col-xs-12 trade-lookup-con3"
			style="border: none; background-color: white; margin-bottom: 10px;">
			<div class="col-md-2 col-sm-2 col-xs-2 trade-lookup-con4">
				<p>구매자 아이디</p>
			</div>
			<div class="col-md-10 col-sm-10 col-xs-10 trade-lookup-con4"
				style="background-color: white; font-weight: 100;">
				<p id="buyUserId">나눔왕</p>
			</div>
			<div class="col-md-2 col-sm-2 col-xs-2 trade-lookup-con4">
				<p>구매자 연락처</p>
			</div>
			<div class="col-md-10 col-sm-10 col-xs-10 trade-lookup-con4"
				style="background-color: white; font-weight: 100;">
				<p id="buyUserTel">010-3543-7844</p>
			</div>
			<div class="col-md-2 col-sm-2 col-xs-2 trade-lookup-con4">
				<p>구매자 이메일</p>
			</div>
			<div class="col-md-10 col-sm-10 col-xs-10 trade-lookup-con4"
				style="background-color: white; font-weight: 100; margin-bottom: 30px;">
				<p id="buyUserEmail">dream@google.com</p>
			</div>
		</div>

	</div>

	<!-- js placed at the end of the document so the pages load faster -->
	<script src="/HaveANiceDream/Theme/assets/js/bootstrap.min.js"></script>
	<script src="/HaveANiceDream/Theme/assets/js/jquery.scrollTo.min.js"></script>
	<script src="/HaveANiceDream/Theme/assets/js/jquery.nicescroll.js"
		type="text/javascript"></script>


	<!--common script for all pages-->
	<script src="/HaveANiceDream/Theme/assets/js/common-scripts.js"></script>
</body>
</html>