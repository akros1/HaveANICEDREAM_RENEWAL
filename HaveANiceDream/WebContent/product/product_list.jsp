<%@page import="java.io.Console"%>
<%@page import="user.dto.MemberDTO"%>
<%@page import="category.dto.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="product.dto.*"%>
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

<script type="text/javascript">
        //카테고리 디테일넘버에 카테고리NO를 통해 검색할수 있도록 하는 함수
        function myform(myform){
        	index = myform.categoryDetailNo.selectedIndex;
        	detailNo = myform.categoryDetailNo[index];
        	detailNoval= $(detailNo).attr("value");
        	$("#categoryDetailNohidden").attr("value",detailNoval);
        	
        };
$(document).ready(function(){
/* 	$("#search1").on("clcick",function(){ //왜 동작안할까.. 고민
		var no = $("#categoryDetailNo").val();
		//alert("셀렉트탴그 값:"+ no);
		//alert("히든값"+detailNoval);
		if(no==null)
			{
			alert("리스트를 선택해주세요.")
			return false;
			}
		
	}); */
	
	$("#categoryNo").on("click",function(){
		var name = $(this).val();//.val() 텍스트상자(옵션태그의) 속성값
		selectNum=	$("#categoryNohidden").attr("value",name);
		$.ajax({
			url:"/HaveANiceDream/category/DeatilSearchAJAX.do?state=SEARCH",//categoryDeatilSearchAJAX.do
			type:"get",
			data:{"categoryNo":name},
			dataType:"json",
			success:function(data){//jquery로 ajax요청하면 json파싱되어 리턴
				$("#categoryDetailNo").empty();
				for(i=0 ;i<data.category_detail.length;i++){ 
					var str="<option value='" + data.category_detail[i].categoryDetailNo+"'>"+data.category_detail[i].categoryDetailName+"</option>";
					 categorydetailname=$(str);
					$("#categoryDetailNo").append(categorydetailname);
				}                           
			}
		})
		$("#categoryDetailNohidden").attr("value",$("#categoryDetailNo").val());
	});
	 
});

</script>
</head>

<body>
	<%
		MemberDTO user = (MemberDTO) session.getAttribute("user");//로그인한 유저의 세션을 가지고 있음.
	%>
	<h3>
		<i class="fa fa-angle-right"></i> 나눔공간
	</h3>
	<div class="row mt">
		<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">



			<div class="content-panel">
				<h4>
					<i class="fa fa-angle-right"></i>물품리스트
				</h4>
				<form  class="form-horizontal style-form" method="post" 
					action="/HaveANiceDream/product_list.do?state=SEARCH">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

					<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
					<input type="hidden" id="categoryNohidden" name="categoryNohidden"    />
						<select  class="form-control"
									name="categoryNo" id=categoryNo  required="required" 
									style="width: 100%">
						<option >선택해주세요
						 <%
							  ArrayList<CategoryDTO> category_list =(ArrayList<CategoryDTO>) request.getAttribute("category_list");
								   
								 if(category_list!=null){
								  for(int i =0;i<category_list.size();i++){
								%>
								     <% CategoryDTO dto = category_list.get(i) ;%>
								     
									<option value="<%=dto.getCategoryNo()%>"><%=dto.getCategoryName()%>
									<%}} %> 
						</select>
					</div>

					<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
					<input type="hidden" id="categoryDetailNohidden" name="categoryDetailNohidden"     /><!-- 히든태그선언 이름을 넘기면 등록할떄 제한사항이 생기므로 hidden 태그에서해결 -->
					 <select 
									class="form-control" name="categoryDetailNo" onchange="myform(this.form)" required="required"
									id="categoryDetailNo"  style="width: 100%" >
								<option >선택해주세요

						</select>
					</div>
					<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
						<ul>


							<li><input type="text" class="form-control" name="title" id="title"
								value=""  
								style="width: 100%"/></li>
						</ul>
					</div>
					<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
						<ul>
							<!-- <li><input type="image" name="btnSearch" value="검색"
								src="/HaveANiceDream/product_list.do?state=SEARCH"
								class="g_image" style="width: auto;" /></li> -->
								<li><button type="submit" class="btn btn-default" id="search1">검색</button></li>
						</ul>
					</div>
				</div>
				</form>
				<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
				</div>
				<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
					<select id="goods_list" name="goods_list"
						 class=" form-control pull-right mb">
						<option value="10">10개</option>
						<option value="15">15개</option>
						<option value="20">20개</option>
					</select>
				</div>
				<section id="unseen">
					<table class="table table-bordered table-striped table-condensed">
						<thead>
							<tr class="trade-ing-line pd-con">
								<th>종류</th>
								<th>이미지</th>
								<th class="numeric">물품제목</th>
								<th class="numeric">거래금액</th>
								<th class="numeric">등록시간</th>
							</tr>
						</thead>
						<tbody>
							<%
								ArrayList<ProductDTO> productlist = (ArrayList<ProductDTO>) request.getAttribute("productlist");
								int size = productlist.size();
							   
								for (int i = 0; i < size; i++) {
									ProductDTO dto = productlist.get(i);
									//검색간...   해당물품 검색 DB접근해서 서블릿요청
									//이미지 실버 물품이미지넣을거고... 거레상태는 표시할예정
							%>
							
							<tr> <!--  종류 부분 수정 ( 대분류 .. 내용 (이름 받아와야함.category_no로 name받아서) -->
								<td><%=dto.getCategoryName() %></td>
								<td><img
									src="/HaveANiceDream/uploadresources/product/<%=dto.getImageSrc()%>"
									width='100' height='100' alt='실버' /></td>
								<td class="numeric"><!-- 이미지 추가...... -->
								<a	href="/HaveANiceDream/product_search.do?productNo=<%=dto.getProductNo()%>&state=BUY" >
									 <%=dto.getProductTitle()%></a></td>

								<td class="numeric"><%=dto.getProductPrice()%></td>
								<td class="numeric"><%=dto.getProductDate()%></td>
							</tr>
							<%} %>
				

						</tbody>
					</table>
				</section>
				<%
				
				 int totalCount =(Integer) request.getAttribute("totalCount");

				 int countPage = 10;
				int paging =(int)Math.ceil(totalCount/countPage);
			
				%>
				<div class="text-center">
				<ul class="pagination">
					<li class="previous"><a href="#">이전</a></li>
					<% for(int i=0; i< paging+1;i++){ %>
					<li><a href="/HaveANiceDream//product_list.do?state=ALL&paging=<%=i+1%>"><%=i+1%></a></li>
					<%} %>
					<li class="next"><a href="#">다음</a></li>
				</ul>
			</div>

			</div>
			<!-- /content-panel -->
		</div>
		<!-- /col-lg-4 -->
	</div>
	<!-- /row -->


</body>
</html>
