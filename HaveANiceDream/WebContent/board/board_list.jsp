<%@page import="java.sql.Date"%>
<%@page import="board.dto.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <script type="text/javascript">
	function setPath(url,boardNo) {
		if(boardNo!=null){
			location.href = "/HaveANiceDream/board/read.do?url=" + url+"&boardNo="+boardNo;
		}else{
			location.href = "/HaveANiceDream/board/replywrite.do?url=" + url;
		}
	}
	function boardWritePath(url,state){
		location.href = "/HaveANiceDream/board/replywrite.do?url=" + url+"&state="+state;
	}
</script>

</head>

<body>


	<div class="col-md-12">
		<h4>
			<i class="fa fa-angle-right"></i> 게시판 목록
		</h4>
		<hr>
		<div class="content-panel">
			<div class="form-group">
				<form name="form1" method="post" action="${path}/board/list.do">
					<div class="col-sm-2">
						<select class="form-control">
							<option value="all">제목+작성자</option>
							<option value="writer">작성자</option>
							<option value="title">제목</option>
						</select>
					</div>
					<div class="col-sm-3">
						<input type="text" class="form-control">
					</div>
					<div class="col-sm-6">
						<button type="submit" class="btn btn-default">조회</button>
					</div>
				</form>
			</div>
			
			
			<div class="form-group">
				<h5 class="col-sm-12">0개의 게시물이 있습니다.</h5>
			</div>

			<table class="table table-hover">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일자</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
				<%
				ArrayList<BoardDTO> boardlist = (ArrayList<BoardDTO>)request.getAttribute("boardlist");
				
				int size = boardlist.size();
				BoardDTO board = null;
				int boardNo = 0;
				String boardTitle = "";
				String boardId = "";
				Date boardDate = null;
				int boardViCount = 0;
				String boardType = "";
				int parentBoardNo = 0;
				
				BoardDTO board2 = null;
				int boardNo2 = 0;
				String boardTitle2 = "";
				String boardId2 = "";
				Date boardDate2 = null;
				int boardViCount2 = 0;
				String boardType2 = "";
				int parentBoardNo2 = 0;
				
				if(boardlist!=null){
				
				for(int i=0;i<size;i++){
					board = boardlist.get(i);
					boardNo = board.getBoardNo();
					boardTitle = board.getBoardTitle();
					boardId = board.getUserId();
					boardDate = board.getWriteDate();
					boardViCount = board.getBoardCount();
					boardType = board.getBoardType1();
					
					
			
					if(boardType.equals("공지사항")){
					%>		
					
					<tr>
						<td><span class="badge bg-important"><i
								class="fa fa-bullhorn"></i> 공지사항</span></td>
						<td><a href="javascript:setPath('../board/board_list_Read.jsp',<%=boardNo%>)" ><%=boardTitle%></a></td>
						<td><%=boardId%></td>
						<td><%=boardDate %></td>
						<td><%=boardViCount%></td>
					</tr>
					<%
						} 
					}
				
				}%>
			<%if(boardlist!=null){
				for(int i=0;i<size;i++){
					board = boardlist.get(i);
					boardNo = board.getBoardNo();
					boardTitle = board.getBoardTitle();
					boardId = board.getUserId();
					boardDate = board.getWriteDate();
					boardViCount = board.getBoardCount();
					boardType = board.getBoardType1();
					parentBoardNo = board.getBoardParentNo();
					if(!boardType.equals("공지사항")){
						if(parentBoardNo==0){
					%>
									<tr>
										<td><%=boardNo %></td>
										<td>
										<a style=" margin-left: 5px;rfloat: left; color: black;" href="javascript:setPath('../board/board_list_Read.jsp',<%=boardNo%>)">
										<%=boardTitle%></a>
										</td>
										<td><%=boardId%></td>
										<td><%=boardDate %></td>
										<td><%=boardViCount%></td>
									</tr>
			<%			}
							for(int j=0;j<size;j++){
								board2 = boardlist.get(j);
								boardNo2 = board2.getBoardNo();
								boardTitle2 = board2.getBoardTitle();
								boardId2 = board2.getUserId();
								boardDate2 = board2.getWriteDate();
								boardViCount2 = board2.getBoardCount();
								boardType2 = board2.getBoardType1();
								parentBoardNo2 = board2.getBoardParentNo();
								
								if(boardNo==parentBoardNo2){
			%>
		
									<tr>
										<td></td>
										<td><span class="reply-icon"></span>
										<a style=" margin-left: 5px;rfloat: left; color: black;" href="javascript:setPath('../board/board_list_Read.jsp',<%=boardNo2%>)">
										<%=boardTitle2%></a>
										</td>
										<td><%=boardId2%></td>
										<td><%=boardDate2 %></td>
										<td><%=boardViCount2%></td>
									</tr>
											
			<%
							 	}
							}
						
					}
				}
			}else{
				
			String com = "작성된 글이 없습니다";
			
			%>
					<tr>
						<td colspan="5" style="text-align: center;"><%=com%></td>
					</tr>
			<%
			}	
			%>
				</tbody>
			</table>
			<hr />
			<a class="btn btn-default pull-right" href="javascript:boardWritePath('../board/board_write.jsp',0)"><i
				class=" fa fa-edit"></i>글쓰기</a>
			<div class="text-center">
				<ul class="pagination">
					<li class="previous"><a href="#">이전</a></li>
					<li><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li class="next"><a href="#">다음</a></li>
				</ul>
			</div>
		</div>
	</div>


</body>
</html>
