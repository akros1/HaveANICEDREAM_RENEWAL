<%@page import="user.dto.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="product.dao.productDAO"%>
<%@page import="product.dto.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">


    <title>trade</title>

    <style>
    	ul{
			list-style: none outside none;
		    padding-left: 0;
            margin: 0;
		}
        .demo .item{
            margin-bottom: 60px;
        }
		.content-slider li{
		    background-color: #ed3020;
		    text-align: center;
		    color: #FFF;
		}
		.content-slider h3 {
		    margin: 0;
		    padding: 70px 0;
		}
		.demo{
			width: 800px;
		}
    </style>
    <script src="/HaveANiceDream/Theme/assets/js/lightslider.js"></script>
     <link rel="stylesheet"  href="/HaveANiceDream/Theme/assets/css/lightslider.css"/>
    <script>
    	 $(document).ready(function() {
			$("#content-slider").lightSlider({
                loop:true,
                keyPress:true
            });
            $('#image-gallery').lightSlider({
                gallery:true,
                item:1,
                thumbItem:9,
                slideMargin: 0,
                speed:500,
                auto:true,
                loop:true,
                onSliderLoad: function() {
                    $('#image-gallery').removeClass('cS-hidden');
                }  
            });
		});
    	 
    	 
    </script>
    
    
    
    
  </head>

  <body>
        
      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
      <!--main content start-->
    				  <%
    				  MemberDTO user = (MemberDTO) session.getAttribute("user");
					    ProductDTO product = (ProductDTO)  request.getAttribute("product");
    				   ArrayList<String> file1 =(ArrayList<String>) request.getAttribute("file1");
    				    String grade="";
    				    String trade="";
    				    if(product.getTradeType().equals("delivery_trade")){
    				    	trade="택배거래";
    				    }else if(product.getTradeType().equals("trade")){
    				    	trade="직거래";
    				    }
    				    if(product.getProduct_Grade().equals("high")){
    				    	grade="상";
    				    	
    				    }else if(product.getProduct_Grade().equals("middle")){
    				    	grade="중";
    				    	
    				    }else if(product.getProduct_Grade().equals("low")){
    				    	grade="하";
    				    	
    				    }
					%>
		<section id="popup-size" >
		
				<h3>
					<i class="fa fa-angle-right"></i> 거래하기
				</h3>
				<! -- 3RD ROW OF PANELS -->
				<!-- Product Panel -->
				<form class="form-horizontal style-form" method="post" enctype="multipart/form-data"
					action="/HaveANiceDream/trade/insert.do?productNo=<%=product.getProductNo()%>">
				<div class="row" style="margin-top: 30px;" >
					<div class="col-md-4 col-sm-4 col-xs-4 no-pd plus-padding-left">
					<%-- <%for(int i=0 ;i<file1.size();i++){ %>
						 <div class="self-img-full-cont"> <img  src="/HaveANiceDream/uploadresources/product/<%=file1.get(i)%>" width='250' height='250'/> </div> 
						 <%} %> --%>
							<ul id="image-gallery" class="gallery list-unstyled cS-hidden">  <%=product.getUserName()%>
								<%for(int i=0 ;i<file1.size();i++){ %>
								<li data-thumb="/HaveANiceDream/uploadresources/product/<%=file1.get(i)%>"><img
									class="self-img-full-cont" src="/HaveANiceDream/uploadresources/product/<%=file1.get(i)%>" /></li>
									 <%} %>
							</ul>
					</div>
					<div class="col-md-8 col-sm-8 col-xs-8 no-pd plus-padding-left">
					
						<div class="product-trade-title-font"></div>
						<div class="col-md-2 col-sm-2 col-xs-2 product-trade-content-title-font" >아이디</div><div class="col-sm-10 product-trade-content-con-font"><%=product.getUserId() %></div>
						<div class="col-md-2 col-sm-2 col-xs-2 product-trade-content-title-font" >물품이름</div><div class="col-sm-10 product-trade-content-con-font"><%=product.getProductName() %></div>
						<div class="col-md-2 col-sm-2 col-xs-2 product-trade-content-title-font" >필요 드림포인트</div><div class="col-sm-10 product-trade-content-con-font" ><label class="pt-font"><%=product.getProductPrice() %></label>포인트</div>
						<div class="col-md-2 col-sm-2 col-xs-2 product-trade-content-title-font">거래방법</div><div class="col-sm-10 product-trade-content-con-font" ><%=trade %></div>					
						<div class="col-md-2 col-sm-2 col-xs-2 product-trade-content-title-font">지역</div><div class="col-sm-10 product-trade-content-con-font" >서울(차후에 구현예정)</div>
						<div class="col-md-2 col-sm-2 col-xs-2 product-trade-content-title-font">물품상태</div><div class="col-sm-10 product-trade-content-con-font" ><%=grade %></div>
						<div class="col-md-2 col-sm-2 col-xs-2 product-trade-content-title-font">사용기간</div><div class="col-sm-10 product-trade-content-con-font" >5개월(차후에 구현예정))</div>
						<div class="col-md-2 col-sm-2 col-xs-2 product-trade-content-title-font">등록일자</div><div class="col-sm-10 product-trade-content-con-font" ><%=product.getProductDate() %></div>
						<div class="col-md-2 col-sm-2 col-xs-2 next-line-hr">
						
						</div>
					</div>
				</div>
				<div class="col-md-12 col-sm-12 col-xs-12 " style="border: 2px solid black;">
					<h5><i class="fa fa-angle-right"></i> 상세내용 </h5>
						<div class="col-md-12 col-sm-12 col-xs-12 product-trade-content-title-font trade-popup-content" >
						<%=product.getProductContent()%>
						</div>
				</div>
				<div class="col-md-12 col-sm-12 col-xs-12 trade-popup-btn">
					<div class="form-group" align="center">
						<button type="button"
							class="btn btn-default btn-lg btn-style-line mr ml"
							data-toggle="modal" data-target="#myModal">거래신청</button>
							<!-- 모달시작 -->
							<% int total =user.getPointTotal();
							int price =product.getProductPrice();%>
						<%if(total>=price){ %>
							
						<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
							aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									      
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">&times;</button>
											<h4 class="modal-title" id="myModalLabel">거래신청</h4>
										</div>
							<div class="modal-body">
								<p>보유중인 포인트:<%=user.getPointTotal()%></p>
								<p>물품 가격:<%=product.getProductPrice()%></p>
								<p>구매후 남는포인트:<%=user.getPointTotal()-product.getProductPrice()%></p>
							</div>
										
										<div class="modal-footer">
											<button type="submit" class="btn btn-primary" >거래신청</button>
											<button type="button" class="btn btn-default"
												data-dismiss="modal">취소</button>
											
										</div>
									
								</div>
							</div>
						</div>
						<%} %><%else{ %>
							
						<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
							aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									      
										<div class="modal-header" style="background-color:red;">
											<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true" >&times;</button>
											<h4 class="modal-title" id="myModalLabel">잔액부족</h4>
										</div>
							<div class="modal-body">
								<p>보유중인 포인트:<%=user.getPointTotal()%></p>
								<p>물품 가격:<%=product.getProductPrice()%></p>
								<p style="color: red;">구매후 남는포인트:<%=user.getPointTotal()-product.getProductPrice()%></p>
							</div>
										
										<div class="modal-footer">
											<button type="button" class="btn btn-default"
												data-dismiss="modal">확인</button>
											
										</div>
									
								</div>
							</div>
						</div>
						<%} %>
						<!--  모달종료 -->
					<button class="btn btn-default btn-lg btn-style-line mr ml" onclick="javascript:showTalkList('<%=product.getUserId()%>','<%=product.getUserId()%>')">1:1채팅</button>
				</div>
				</form>
		</section>
		<!-- /MAIN CONTENT -->
								
		<!--main content end-->
 

</body>
</html>