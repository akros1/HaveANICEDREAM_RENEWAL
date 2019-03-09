<%@page import="user.dto.MemberDTO"%>
<%@page import="board.dto.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title>게시판</title>

<script type="text/javascript">
   	
/* 	function boardListPath() {
		location.href = "/HaveANiceDream/board/list.do";
	} */
	function setPath(url,boardNo) {
		if(boardNo!=null){
			location.href = "/HaveANiceDream/board/list.do?url=" + url+"&boardNo="+boardNo;
		}else{
			location.href = "/HaveANiceDream/board/list.do?url=" + url;
		}
	}
	function reBoardPath(url,parentBoardNo,state) {
		location.href = "/HaveANiceDream/board/replywrite.do?url=" + url+"&parentBoardNo="+parentBoardNo+"&state="+state;

	}
	function DelPath(url,boardNo){
		location.href = "/HaveANiceDream/board/delete.do?url=" + url+"&boardNo="+boardNo;
	}
	function reportPath(url) {

		location.href = "/HaveANiceDream/view.html?url=" + url;
	}
   </script>
   <script type="text/javascript">
	$(document).ready(function(){
		boardNo = $("#boardNo1").val();
		replylistdata="";
		replyNode = $("#replyCon");
		$.ajax({
			url : "/HaveANiceDream/reply/list.do",
			type : "GET",
			data : {
				"boardNo" : boardNo 
			},
			dataType : "json", 
		       success : function(data) {	
					//$("#replylist").text(data.replylist);
					$("#replycount").text(data.replylist.length);
					$("#replycount2").text(data.replylist.length);
					for(i in data.replylist){
						
						$(replyNode).append("<div class='col-xs-12 col-md-12 mb col-sm-12 border-reply-mid'>"+
								"<div class='col-xs-8 col-md-8 col-sm-8'>아이디:&nbsp;"+replylistdata+data.replylist[i].UserId+
								"</div>"+
								"<div class='col-xs-4 col-md-4 col-sm-4 mb' style='text-align: right;'>"+" 작성일 :"+replylistdata+data.replylist[i].ReplyEditDate+
								"</div>"+
								"<div class='col-xs-12 col-md-12 mb col-sm-12 border-content-detail'>"+replylistdata+data.replylist[i].ReplyContent+
								"</div>"+
								"</div>" );
		
					}
				}
		});
		$("#replyInsert").on("click", rplyInsert);
		$("#replyRe").on("click", replySelect);

	});
	
	function rplyInsert() {
		var content = $("#replyContentwrite").val();
		var boardNo1 = $("#boardNo1").val();
		if (content=="") {
			alert("댓글을 입력해주세요");
		}else{
			$.ajax({
				url : "/HaveANiceDream/reply/insert.do",
				type : "POST",
				data : {
					"replyContent" : content,
					"boardNo" : boardNo1
				},
				dataType : "text",
				success : function(resp) {
					rplyList();
				}
			});	 
		}
		$("#replyContentwrite").val("");
		
	}
	function rplyList() {
			var boardNo = $("#boardNo1").val();
			var replylistdata="";
			var replyNode = $("#replyCon");
			$.ajax({
				url : "/HaveANiceDream/reply/list.do",
				type : "GET",
				data : {
					"boardNo" : boardNo 
				},
				dataType : "json", 
				success : function(data) {				

					//$("#replylist").text(data.replylist);
					var size = data.replylist.length;
					if(size!=0){
					$("#replycount").text(size);
						$(replyNode).append("<div class='col-xs-12 col-md-12 mb col-sm-12 border-reply-mid'>"+
								"<div class='col-xs-8 col-md-8 col-sm-8 id-list-font'>아이디:&nbsp;"+replylistdata+data.replylist[size-1].UserId+
								"</div>"+
								"<div class='col-xs-4 col-md-4 col-sm-4 mb' style='text-align: right'>"+" 작성일 :"+replylistdata+data.replylist[size-1].ReplyEditDate+
								"</div>"+
								"<div class='col-xs-12 col-md-12 mb col-sm-12 border-content-detail'>"+replylistdata+data.replylist[size-1].ReplyContent+
								"</div>"+
								"</div>" );
		
					}
				}
			});
	}
	</script>
   
</head>

<body>
	<%BoardDTO boardRead = (BoardDTO)request.getAttribute("boardRead"); 
	  MemberDTO user = (MemberDTO) session.getAttribute("user");
	%>
	<div class="col-md-12">
		<h4>
			<i class="fa fa-angle-right"></i>커뮤니티
		</h4>
		<hr>
		<div class="content-panel">
			<div class="col-md-12">
				<h3>
					<i class="fa fa-angle-right"></i>자유게시판
				</h3>
			</div>
			<div class="form-group">
				<div class="col-md-2 border-title">게시글 번호 : <%=boardRead.getBoardNo()%></div>
				<div class="col-md-2 border-title">아이디 : <%=boardRead.getUserId() %></div>
				<div class="col-md-6 border-title">작성일자 : <%=boardRead.getWriteDate() %></div>
				<div class="col-md-2 border-title">조회수 :<%=boardRead.getBoardCount() %></div>
			</div>
			<div class="form-group">
				<h5 class="col-sm-2" style="text-align: center;"><%=boardRead.getBoardType1() %>><%=boardRead.getBoardType2() %></h5>
				<div class="col-sm-8"></div>
				<h5 class="col-sm-2" style="text-align: center;" >
					 댓글(<span id="replycount"></span>)
				</h5>
			</div>
			<div class="form-group">
				<h2 class="col-sm-12 border-title-content"><%=boardRead.getBoardTitle() %></h2>
			</div>
			<div class="form-group mb" style="height: auto;">
				
				<div class="col-sm-12 border-content-detail"><%=boardRead.getBoardContent()%></div>
				<div style="padding-left: 30px; color: black;"> 첨부된 이미지</div>
				<div class="no-mg-no-pd" style="padding-left: 30px;"> <img class="reply-img-full-cont2 " alt="" src="/HaveANiceDream/uploadresources/board/<%=boardRead.getBoardimageSrc()%>" > </div>
				<div style="padding-right: 20px; height: auto; text-align: right;"><button type="button" class="btn btn-danger btn-sm" onclick="javascript:reportPath('../blame/report_boss.jsp')">게시글 신고하기</button></div>
			</div>

			
			<div class="form-group">
				<div class="col-md-12 border-foot mb">
				<%if(boardRead.getUserId().equals(user.getUserId())){%>
				
					<button type="button" class="btn btn-round btn-default mr" onclick="javascript:DelPath('../board/board_list.jsp',<%=boardRead.getBoardNo()%>)">삭제</button>
					<button type="button" class="btn btn-round btn-default mr" >수정</button>
				<%} %>
					<button type="button" class="btn btn-round btn-default mr" onclick="javascript:reBoardPath('../board/board_write.jsp',<%=boardRead.getBoardNo()%>,'1','<%=boardRead.getBoardType1()%>')">답글</button>
					<button type="button" class="btn btn-round btn-default mr" onclick="javascript:setPath('../board/board_list.jsp')">목록</button>
				</div>
			</div>
			<!-- 답글 폼 스타트!! -->
			<div class="form-group">
				<div class="col-md-12 border-reply-top mb">
					<!-- 답글 최상위 페이지!! -->
					<h4 style="color: black; margin-bottom: 10px;">
						<i class="fa fa-angle-right"></i>댓글달기
					</h4>
					<h5 class="col-sm-2" style="text-align: center;">
						댓글갯수&nbsp;(<span id="replycount2"></span>)
					</h5>
					<div class="col-xs-8 col-sm-8 col-md-8"></div>
					<h5 class="col-xs-2 col-sm-2 col-md-2" style="text-align: center;">
						새로고침&nbsp;<a id="replyRe"><i class="fa fa-history"></i></a>
					</h5>
					
					<div class="col-xs-12 col-sm-12 col-md-12 border-reply-mid no-mg-no-pd" id="replyCon">
						
						
					</div>
					
					
					<div class="col-xs-12 col-sm-12 col-md-12 border-reply-back">
						<span class="col-xs-3 col-sm-3 col-md-3 border-reply-id-font"><i class="fa fa-user" style="color: #1290c3;"></i> <a><%=user.getUserId()%></a> 
							<span class="col-xs-12 col-sm-12 col-md-12"><img class="reply-img-full-cont" src="/HaveANiceDream/uploadresources/user/<%=user.getUserImage()%>"></span>
						</span> 
						<span class="col-xs-7 col-sm-7 col-md-7">
							<textarea name="replyContent" id="replyContentwrite" style="width: 100%; border: 1; overflow: visible; text-overflow: ellipsis;" rows=5></textarea>
						</span> 
						<span class="col-xs-2 col-sm-2 col-md-2"> <a class="btn btn-default border-reply-btn-size" id="replyInsert" ><i class=" fa fa-edit"></i>등록</a>	</span>
					</div>
				</div>
			</div>
		</div>
	</div>
	<form action="thisform">
		<input type="hidden" name="boardNo1" id="boardNo1" value="<%=boardRead.getBoardNo()%>" >
	</form>
</body>
</html>
