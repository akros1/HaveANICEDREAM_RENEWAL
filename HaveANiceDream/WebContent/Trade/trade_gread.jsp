<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

<title>평가하기!</title>

<!-- Bootstrap core CSS -->
<link href="/HaveANiceDream/Theme/assets/css/bootstrap.css"
	rel="stylesheet">

<link href="/HaveANiceDream/Theme/assets/css/style.css" rel="stylesheet">

<script src="/HaveANiceDream/Theme/assets/js/jquery.js"></script>
<script src="/HaveANiceDream/Theme/assets/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
    //라디오 요소처럼 동작시킬 체크박스 그룹 셀렉터
    $('input[type="checkbox"][name="group"]').click(function(){
        //클릭 이벤트 발생한 요소가 체크 상태인 경우
        if ($(this).prop('checked')) {
            //체크박스 그룹의 요소 전체를 체크 해제후 클릭한 요소 체크 상태지정
            $('input[type="checkbox"][name="group"]').prop('checked', false);
            $(this).prop('checked', true);
        }
    });
});
</script>
<script type="text/javascript">
	function insertPath(productNo,tradeNo,state){
		location.href = "/HaveANiceDream/grade/insert.do?productNo="+productNo+"&tradeNo="+tradeNo+"&state="+state;
		opener.location.href="/HaveANiceDream/trade/list.do";
		window.close();
	}

</script>
</head>

<body>
	<%
		String productNo = request.getParameter("productNo");
		String tradeNo = request.getParameter("tradeNo");
		String state = request.getParameter("state");//'1'= 구매자 -----> 판매자평가,  '2'= 판매자 -----> 구매자평가
	%>

	<div class="col-md-1 col-sm-1 col-xs-1"></div>
	<div class="col-md-10 col-sm-10 col-xs-10">
		<%
			if (state.equals("1")) {
		%>
		<div class="col-md-12 col-sm-12 col-xs-12"
			style="color: black; padding-top: 25px;">
			<h3>평가하기(판매자)</h3>
		</div>
		<%
			} else {
		%>
		<div class="col-md-12 col-sm-12 col-xs-12"
			style="color: black; padding-top: 25px;">
			<h3>평가하기(구매자)</h3>
		</div>
		<%
			}
		%>
		<form role="form" class="form-horizontal"
			action="/HaveANiceDream/grade/insert.do?productNo=<%=productNo%>&tradeNo=<%=tradeNo%>&state=<%=state%>"
			method="post">
			<div class="col-md-12 col-sm-12 col-xs-12 steps pn no-mg-no-pd"
				style="background-color: #d5e1ed; height: auto;">
				<div class="ccol-md-3 col-sm-3 col-xs-3 no-mg-no-pd">
					<input id='op1' name="group" type='checkbox' value="매우만족" checked />
					<label for='op1'>매우만족</label>
				</div>
				<div class="col-md-2 col-sm-2 col-xs-2 no-mg-no-pd">
					<input id='op2' name="group" type='checkbox' value="만족" />
					<label for='op2'>만족</label>
				</div>
				<div class="col-md-2 col-sm-2 col-xs-2 no-mg-no-pd">
					<input id='op3' name="group" type='checkbox' value="보통" />
					<label for='op3'>보통</label>
				</div>
				<div class="col-md-2 col-sm-2 col-xs-2 no-mg-no-pd">
					<input id='op4' name="group" type='checkbox' value="불만족" />
					<label for='op4'>불만족</label>
				</div>
				<div class="col-md-3 col-sm-3 col-xs-3 no-mg-no-pd">
					<input id='op5' name="group" type='checkbox' value="매우불만족" />
					<label for='op5'>매우불만족</label>
				</div>
				<div class="col-md-1 col-sm-1 col-xs-1 no-mg-no-pd"></div>
				<div class="col-md-11 col-sm-11 col-xs-11 no-mg-no-pd"
					style="height: 20px; margin-top: 10px; margin-bottom: 10px; color: #2f78bd;">
					내용작성</div>

				<div class="col-md-1 col-sm-1 col-xs-1 no-mg-no-pd"
					style="height: 120px;"></div>
				<div class="col-md-10 col-sm-10 col-xs-10 no-mg-no-pd"
					style="height: 120px;">
					<textarea
						style="width: 100%; border: 1; overflow: visible; text-overflow: ellipsis; border: #8b929e"
						rows=6 name="gradeContent"></textarea>
				</div>
				<div class="col-md-1 col-sm-1 col-xs-1 no-mg-no-pd"
					style="height: 120px;"></div>
				<div class="col-md-6 col-sm-6 col-xs-6 no-mg-no-pd">
					<input type='submit' value='취소' id='submit'
						onclick="window.close()" />
				</div>
				<div class="col-md-6 col-sm-6 col-xs-6 no-mg-no-pd">
					<input type='submit' value='평가하기' id='submit'
						onclick="javascript:insertPath
								(<%=productNo%>,<%=tradeNo%>,<%=state%>)" />
				</div>
			</div>
		</form>
	</div>
	<div class="col-md-1 col-sm-1 col-xs-1"></div>
</body>
</html>
