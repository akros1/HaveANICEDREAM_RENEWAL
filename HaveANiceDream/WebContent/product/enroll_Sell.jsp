<%@page import="java.util.ArrayList"%>
<%@page import="category.dto.*"%>
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
	<script src="/HaveANiceDream/Theme/assets/js/Filechose.js"></script>
<script type="text/javascript">
	function getCategoryDetail(){  //카테고리디테일부분 검색. 
		//alert("안녕");
	var name = $("#categoryDetailNameSearch").val();//.val() 텍스트상자의 값을 읽어올떄 사용하는 메소드
			
	$.ajax({
		url:"/HaveANiceDream//category/DeatilSearchAJAX.do?state=ENROLL",//categoryDeatilSearchAJAX.do
		type:"get",
		data:{"categoryName":name,"selectNum":selectNum},
		dataType:"json",
		success:function(data){//jquery로 ajax요청하면 json파싱되어 리턴
			//alert("안녕");
			$("#categoryDetailName").empty();//항상 비워줌
			for(i=0 ;i<data.category_detail.length;i++){ 
			if(selectNum==data.category_detail[i].categoryNo){//전부다 가져오는데 셀렉트NO과 카테고리 NO 같은것만 출력 사실 해당코드는 쿼리에 포함되어있는코드여야함;
				var str="<option value='"+ data.category_detail[i].categoryDetailNo+"'>"+data.category_detail[i].categoryDetailName+"</option>";
				 categorydetailname=$(str);
				$("#categoryDetailName").append(categorydetailname);
			}
			//dom을 활용한 방법 jquery방법이 간단하니 해당방법을 사용할것
			//옵션태그를 객체로 생성해서  value는 속성값으로 부여하고 텍스트노드를 추가
			//옵션태그를 부모노드인 셀렉트태그에 붙임.
			 //$("categoryDetailNameSearch").val(categoryname.attr("value"));
			/* 	str=data.categoryDetailName[i];
				textnode = document.createTextNode(str);
				 var createOption=document.createElement("option");
				 createOption.appendChild(textnode);
				 parentNode=document.getElementById("categoryDetailName");
				 parentNode.appendChild(createOption); */
				 //jquery로 간단하게 할것
			}
			  
			                           
		}
	})
	};
	
	




	selectNum=""
		//카테고리디테일로 셀렉트 태그의 함수
		//클릭한 인덱스를 받아와 텍스트필드에 text를 입력 하고 히든태그에는 categoryDetailNo를 입력하는코드
      function getDetailName(myform){
    	  index = myform.categoryDetailName.selectedIndex;
    	 $("#categoryDetailNameSearch").val(myform.categoryDetailName[index].text);
    	 selectDNumObj = myform.categoryDetailName[index];
    	 selectDNum = $(selectDNumObj).attr("value");
    	 $("#categoryDetailNohidden").attr("value",selectDNum);
    	             
      }
	//카테고리 셀렉트 태그의 함수
	//클릭한 인덱스를 받아와 텍스트필드에 text를 입력 하고 히든태그에는 categoryNo를 입력하는코드
      function getName(myform){
    	  index = myform.categoryName.selectedIndex;//select태그내에서 선택된 옵션의 인덱스가 몇번인지 구하는 코드 
    	 $("#categoryNameSearch").val(myform.categoryName[index].text);//텍스트필드에 값을 세팅 (셀렉트태그하위의  <option>태그의 선택된Index의 text값)
    	  // 옵션태그를 객체로 받아서
    	   selectNumObj  =	myform.categoryName[index];//Index번째의 <option>태그를 selectNumObj객체로 생성.
    	   //selectNumObj객체의 속성값(AJAX통신을 통해 얻어온 categoryNo)를 저장한 selectNum 변수 생성
    	   selectNum  =  $(selectNumObj).attr("value"); //생성된 객체의 속성(인덱스 : 즉 categoryNo)을 저장
    	   $("#categoryNohidden").attr("value",selectNum);//히든태그에 categoryNo을 저장함  submit할떄 함께 전달.
    	   $("#categoryDetailNameSearch").val("");//고민해보자 어떻게 하면 뜰까..?
    	   getCategoryDetail();
    			   
      }
     $(document).ready(function(){
    	 $("#enroll").on("click",function(){
    		 //제이쿼리를 이용 radio박스가 체크가 되있으면 실행 아니면 return false
    		 //:input태그로 정의된 속성에 사용할수 있음
    		 //:라디오버튼 그룹이 체크가 되있으면 true 아니면 false를 리턴
    		 tchk =$("input:radio[name='tradeType']").is(":checked");//input태그의 라디오버튼중 이름 tradetype인것에 대한 정보 (true ,false 리턴)
    		 gchk =$("input:radio[name='productGrade']").is(":checked");
    		 if(tchk & gchk){//둘다체크가 되있다면
    		 }else{
    			 if(tchk){
    				 alert("물품등급을 상태를 선택해주세요");
    			 }else if(gchk){
    				 alert("거래방식을 선택해주세요");
    			 }else{
    				 alert("물품등급 및 거래방식을 선택해주세요")
    			 }
    			 return false;//하나라도 안되있으면 실행을 안함..
    		 }
    		 
    		  
    		  
    	 });
    	 //enroll에서 대분류 검색(AJAX통신)
    	 $("#categoryNameSearch").on("keyup",function(){
     		var name = $(this).val();
     		$.ajax({
     			url:"/HaveANiceDream//category/SearchAJAX.do", // categorySearchAJAX.do
 				type:"get",
 				data:{"categoryName":name},
 				dataType:"json",
 				success:function(data){//jquery로 ajax요청하면 json파싱되어 리턴
 					$("#categoryName").empty();
 					for(i=0 ;i<data.category.length;i++){ 					
 						var str="<option value='"+data.category[i].categoryNo+"'>"+data.category[i].categoryName+"</option>";
 						//옵션태그에서 카테고리 넘버를 value로 설정한 것을 객체로 생성해서  셀렉트태그에 붙이는 과정. 
 						 categoryname=$(str);//객체생성해서 셀렉트태그에 붙이ㅡㄴ 과정
 						$("#categoryName").append(categoryname);
 					}   
 				}
     		})
	
     	});

    	$("#categoryDetailNameSearch").on("keyup",function(){
    		getCategoryDetail();
    	});
    	 
     });
</script>

<title>DASHGUM - Bootstrap Admin Template</title>

<link rel="stylesheet" type="text/css"
	href="/HaveANiceDream/Theme/assets/js/bootstrap-datepicker/css/datepicker.css" />
<link rel="stylesheet" type="text/css"
	href="/HaveANiceDream/Theme/assets/js/bootstrap-daterangepicker/daterangepicker.css" />

</head>

<body>

	<h3>
		<i class="fa fa-angle-right"></i> 물품등록
	</h3>

	<!-- BASIC FORM ELELEMNTS -->
	<div class="row mt">
		<div class="col-lg-12">
			<div class="form-panel">
				<h4 class="mb">
					<i class="fa fa-angle-right"></i> 판매 등록
				</h4>
				<form class="form-horizontal style-form" method="post" enctype="multipart/form-data"
					action="/HaveANiceDream/product_enroll.do?state=ENROLL">
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label">카테고리</label>
						<div class="col-sm-10">
							<div class="col-sm-5">
								<input type="hidden" id="categoryNohidden" name="categoryNohidden"   />
								<input type="text"  id="categoryNameSearch" name="categoryNameSearch"class="form-control" value="" required="required">
								<br /> <select multiple class="form-control"  required="required"
									name="categoryName" id=categoryName size="8" onclick="getName(this.form)"
									style="width: 100%">
								  <%
							  ArrayList<CategoryDTO> category_list =(ArrayList<CategoryDTO>) request.getAttribute("category_list");
								   
								 if(category_list.size()!=0){
								  for(int i =0;i<category_list.size();i++){
								%>
								     <% CategoryDTO dto = category_list.get(i) ;%>
								     
									<option value="<%=dto.getCategoryNo()%>"><%=dto.getCategoryName()%>
									<%}} %> 
								</select>
							</div>
							<div class="col-sm-5">
						<input type="hidden" id="categoryDetailNohidden" name="categoryDetailNohidden"     /><!-- 히든태그선언 이름을 넘기면 등록할떄 제한사항이 생기므로 hidden 태그에서해결 -->
								<input type="text" class="form-control" id="categoryDetailNameSearch" name="categoryDetailNameSearch" required="required"
									value=""> <br /> <select multiple
									class="form-control" name="categoryDetailName" required="required"
									id="categoryDetailName" size="8" style="width: 100%" onclick="getDetailName(this.form)">
								</select>
							</div>


						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label">드림포인트</label>
						<div class="col-sm-10">
							<input type="number" class="form-control" id="productPrice" name="productPrice" required="required"> <span
								class="help-block" >드림하고자 하는 포인트을 숫자로 입력해주세요.</span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label">상품명</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="productName" name="productName" required="required" > 
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label">거래방식</label>
						<div class="col-sm-10">
								   <input type="radio" name="tradeType"  id="trade" value="trade">직거래
	   							   <input type="radio" name="tradeType"  id="delivery_trade" value="delivery_trade">택배거래
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label">물품상태</label>
						<div class="col-sm-10">
								   <input type="radio" name="productGrade"  id="high" value="high">상
	   							   <input type="radio" name="productGrade"  id="middle" value="middle">중
	   							   <input type="radio" name="productGrade"  id="low" value="low">하
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label">물품제목</label>
						<div class="col-sm-10">
							<input class="form-control" type="text" id="productTitle" name="productTitle" required="required"
								value="">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label">상세설명</label>
						<div class="col-sm-10">
							<textarea rows="10" cols="100%" id="productContent" name="productContent" required="required"></textarea>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label">업로드</label>
						<div class="col-sm-10">
							<div >
								<div class="filebox bs3-primary preview-image">
								 <label for="input_file1">파일찾기</label>
								<input type="file" id="input_file1" class="upload-hidden" name="boardImg1" required="required">
								</div>
							<div class="filebox bs3-primary preview-image">
								 <label for="input_file2">파일찾기</label>
								<input type="file" id="input_file2" class="upload-hidden" name="boardImg2">
							</div>
								<div class="filebox bs3-primary preview-image">
								 <label for="input_file3">파일찾기</label>
								<input type="file" id="input_file3" class="upload-hidden" name="boardImg3">
							</div>
							<!-- 	<input type="file" name="uploadFile1"  /><br/>
								<input type="file" name="uploadFile2"  /><br/>
								<input type="file" name="uploadFile3"  /><br/>  -->
								<!-- <textarea rows="3" cols="100%"></textarea>
								<button type="button" class="btn btn-default">+추가</button>
								<button type="button" class="btn btn-default">-삭제</button> -->
							</div>
						</div>
					</div>
					
					<div class="form-group" align="center">
						<button type="button"
							class="btn btn-round btn btn-round btn-default"
							data-toggle="modal" data-target="#myModal">등록하기</button>
							<!-- 모달시작 -->
								<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
							aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									      
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">&times;</button>
											<h4 class="modal-title" id="myModalLabel">게시글등록</h4>
										</div>
										
										<div class="modal-footer">
											<button type="submit" class="btn btn-primary" id="enroll">등록하기</button>
											<button type="button" class="btn btn-default"
												data-dismiss="modal">취소</button>
											
										</div>
								</div>
							</div>
						</div>
						<!--  모달종료 -->
							<button class="btn btn-round btn btn-round btn-default" data-toggle="modal" data-target="#myModal2"
									>취소하기</button>
						<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
							aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									      
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">&times;</button>
											<h4 class="modal-title" id="myModalLabel">정말취소하시겠습니까? 작성중인 글은 사라집니다.</h4>
										</div>
										
										<div class="modal-footer">
											<button type="submit" class="btn btn-primary" onclick="location.href ='/HaveANiceDream//product_list.do?state=ALL&paging=1'">취소하기</button>
											<button type="button" class="btn btn-default"
												data-dismiss="modal">계속작성</button>
											
										</div>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- col-lg-12-->



	<!--script for this page-->
	<script
		src="/HaveANiceDream/Theme/assets/js/jquery-ui-1.9.2.custom.min.js"></script>

	<!--custom switch-->
	<script src="/HaveANiceDream/Theme/assets/js/bootstrap-switch.js"></script>

	<!--custom tagsinput-->
	<script src="/HaveANiceDream/Theme/assets/js/jquery.tagsinput.js"></script>

	<!--custom checkbox & radio-->

	<script type="text/javascript"
		src="/HaveANiceDream/Theme/assets/js/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
	<script type="text/javascript"
		src="/HaveANiceDream/Theme/assets/js/bootstrap-daterangepicker/date.js"></script>
	<script type="text/javascript"
		src="/HaveANiceDream/Theme/assets/js/bootstrap-daterangepicker/daterangepicker.js"></script>

	<script type="text/javascript"
		src="/HaveANiceDream/Theme/assets/js/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>


	<script src="/HaveANiceDream/Theme/assets/js/form-component.js"></script>


</body>
</html>
