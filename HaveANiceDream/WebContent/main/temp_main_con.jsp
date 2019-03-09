<%@page import="product.dto.ProductDTO"%>
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

	<!--이미지 넘어가는 버튼 예시-->
	<div class="container mt mb" style="width: 700px;">
		<div id="myCarousel" class="carousel slide" data-ride="carousel"
			style="width: 100%">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner">

				<div class="item active">
					<img src="/HaveANiceDream/Theme/assets/img/kim/mainview.jpg"
						alt="Los Angeles" style="width: 100%;">
					<div class="carousel-caption">
						<h3>즐거운 나눔의 실천</h3>
						<p>Have a nice dream</p>
					</div>
				</div>

				<div class="item">
					<img src="/HaveANiceDream/Theme/assets/img/kim/event.jpg"
						alt="Chicago" style="width: 100%;">
					<div class="carousel-caption">
						<h4 style="color: black;">출석?! 그게뭔데? 이벤트!</h4>
					</div>
				</div>

				<div class="item">
					<img src="/HaveANiceDream/Theme/assets/img/kim/event2.jpg"
						alt="New York" style="width: 100%;">
					<div class="carousel-caption">
						<h4 style="color: black;">너의 그 즐거운 에너지 까지 나눠버린다!!</h4>

					</div>
				</div>
			</div>

			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span>
				<span class="sr-only">Previous</span>
			</a>
			<a class="right carousel-control" href="#myCarousel"
				data-slide="next">
				<span class="glyphicon glyphicon-chevron-right"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
	</div>
	<!--이미지 넘어가는 벝 END-->

	<!--검색창 만들기  start-->
	<form class="form-horizontal style-form" method="post"
		enctype="multipart/form-data"
		action="/HaveANiceDream/product_list.do?state=MAIN&paging=1'">
		<!-- 어떻게해야넘어갈까.. 고민해보자 -->
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6 mt">
				<div id="custom-search-input">
					<div class="input-group col-md-12 centered">
						<input type="text" class="form-control input-lg" name="title"
							id="title" placeholder="검색할물건" />
						<span class="input-group-btn">
							<button class="btn btn-info btn-lg" type="submit">
								<i class="glyphicon glyphicon-search"></i>
							</button>
						</span>
					</div>
				</div>
			</div>
		</div>
	</form>
	<!--검색창 만들기 end-->
	<%
		ArrayList<ProductDTO> productlist = (ArrayList<ProductDTO>) request.getAttribute("productlist");
	%>
	<!-- 메인 추천 이미지 생성 부분 -->
	<h3 class="ml">
		<i class="fa fa-angle-right"></i>
		메인추천
	</h3>
	<hr>
	<div class="row mt">
		<%
			if (productlist != null) {
		%>
		<%
			for (int i = 0; i < productlist.size(); i++) {
					ProductDTO product = productlist.get(i);
					String grade = "";
					String trade = "";
					if (product.getTradeType().equals("delivery_trade")) {
						trade = "택배거래";
					} else if (product.getTradeType().equals("trade")) {
						trade = "직거래";
					}
					if (product.getProduct_Grade().equals("high")) {
						grade = "상";

					} else if (product.getProduct_Grade().equals("middle")) {
						grade = "중";

					} else if (product.getProduct_Grade().equals("low")) {
						grade = "하";

					}
		%>
		<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 desc"
			style="margin-bottom: 20px;">
			<div class="project-wrapper">
				<div class="project">
					<div class="photo-wrapper photo-wrapper-background-color ml">
						<div class="photo">

							<a class="fancybox"
								href="/HaveANiceDream/product_search.do?productNo=<%=product.getProductNo()%>&state=BUY">
								<img class="self-img-full-cont2"
									src="/HaveANiceDream/uploadresources/product/<%=product.getImageSrc()%>"
									alt="">
							</a>
							<div class="col-xs-12 mainview-content-title-font">
								<%=product.getProductTitle()%>
							</div>
							<div class="col-xs-12">
								<label class="label label-warning">강력추천</label>
								<label class="label label-primary">new</label>
							</div>
							<div class="col-xs-12">
								상태 :
								<%=grade%>
							</div>
							<div class="col-xs-12 mainview-price">
								필요 포인트 :
								<%=product.getProductPrice()%>
							</div>
							<div class="col-xs-12">
								거래방법 :
								<%=trade%>
							</div>
							<div class="col-xs-12">
								등록일자 :
								<%=product.getProductDate()%>
							</div>
							<div class="col-xs-12">
								아이디 :
								<%=product.getUserId()%>
							</div>
						</div>

						<div class="overlay"></div>
					</div>
				</div>
			</div>
		</div>
		<!-- col-lg-4 -->
		<%
			}
			}
		%>
	</div>
	<!-- /row -->
</body>
</html>
