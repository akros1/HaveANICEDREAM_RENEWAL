<%@page import="board.dto.BoardDTO"%>
<%@page import="user.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

<title>DASHGUM - Bootstrap Admin Template</title>

<link href="/HaveANiceDream/Theme/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
<!-- Custom styles for this template -->
<script src="/HaveANiceDream/Theme/assets/js/jquery.js"></script>
<script src="/HaveANiceDream/Theme/assets/js/Filechose.js"></script>
<script src="//cdn.ckeditor.com/4.8.0/standard/ckeditor.js"></script>


</head>

<body>
	<%
	BoardDTO parentBoardDTO = (BoardDTO)request.getAttribute("parentBoardDTO"); 
	MemberDTO user = (MemberDTO) session.getAttribute("user");
	String parentBoardNo = (String)request.getAttribute("parentBoardNo"); 
	String state = (String)request.getAttribute("state"); 
	%>

	<h4>
		<i class="fa fa-angle-right"></i> 게시글 작성하기
	</h4>
	<hr>
	<div class="row mt">
		<div class="col-lg-12">
			<div class="form-panel">
				<h4 class="mb">
					<i class="fa fa-angle-right"></i> 게시판 제목
				</h4>
			<%	if(parentBoardNo!=null){
					Integer.parseInt(parentBoardNo);%>
			
				<form class="form-horizontal style-form" enctype="multipart/form-data" 
				action="/HaveANiceDream/board/insert.do?userId=<%=user.getUserId()%>&parentBoardNo=<%=parentBoardNo%>" method="post">
			<% }else{%>
				<form class="form-horizontal style-form" enctype="multipart/form-data" 
				action="/HaveANiceDream/board/insert.do?userId=<%=user.getUserId()%>" method="post">
			<% }%>
		
					<div class="form-group" style="border: 1px solid #eff2f7;">
						<label class="col-sm-2 col-sm-2 control-label">작성자</label>
						<div class="col-sm-10">
						
							<p class="form-control-static"><%=user.getUserId() %></p>
						</div>
					</div>
				
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label">게시글 유형</label>
					
						<div class="col-sm-10">
					<%if(state.equals("1")){ %>	
							 <select class="form-control" name="boardType1">
								<option><%=parentBoardDTO.getBoardType1()%></option>
							</select>
					<%}else{ %>
							<select class="form-control" name="boardType1">
								<option>공지사항</option>
								<option>구매후기</option>
								<option>1:1맞춤상담</option>
								<option>질문과 답변</option>
								<option>자유게시판</option>
							</select>
					<%} %>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label">게시글 종류</label>
						<div class="col-sm-10">
					<%if(state.equals("1")){ %>	
							 <select class="form-control" name="boardType1">
								<option>답글</option>
							</select>
					<%}else{ %>
							<select class="form-control" name="boardType2">
								<option>물품</option>
								<option>이용</option>
								<option>구매</option>
								<option>판매</option>
								<option>인증</option>
								<option>기타</option>
							</select>
					<%}%>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label">제목</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="boardTitle"> <span
								class="help-block">게시글 유형에 맞는 내용으로 작성 부탁드립니다. </span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label">내용</label>
						<div class="col-sm-10">
							<textarea id="editor1"
								style="width: 100%; border: 1; overflow: visible; text-overflow: ellipsis;"
								rows=15 name="boardContent">글작성</textarea>
							<script>
								//요기가  ck에디터를 만들어주는 곳이다!!!!!!
								// Replace the <textarea id="editor1"> with a CKEditor
								// instance, using default configuration.
								CKEDITOR.replace('editor1');
							</script>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label">업로드</label>
						<div class="col-sm-10">
							<div class="filebox bs3-primary preview-image">
								 <label for="input_file">파일찾기</label>
								<input type="file" id="input_file" class="upload-hidden" name="boardImg">
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-lg-4 text-center"></div>
						<div class="col-lg-2 text-center">
							<button type="submit" class="btn btn-success"
								style="width: 100px; background-color: #0ea006">작성완료</button>
						</div>
						<div class="col-lg-2 text-center">
							<button type="reset" class="btn btn-default"
								style="width: 100px; background-color: #9a9a9a">취소</button>
						</div>
						<div class="col-lg-4 text-center"></div>
					</div>
				</form>
			</div>
		</div>
		<!-- col-lg-12-->
	</div>
	<!-- /row -->


</body>
</html>

