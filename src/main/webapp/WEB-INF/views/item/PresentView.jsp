<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<style>
	#presentArea{
		width : 1000px;
		height : 750px;
		border : 1px solid green;
		text-align : center;
		margin-right : auto;
		margin-left : auto;
	}
	#imgArea{
		width : 200px;
		height : 230px;
		align : center;
		border : 1px solid blue;
		margin-right : auto;
		margin-left : auto;
	}
	.content {
	    margin-left: 423px;
	    margin-top: 4px;
	    margin-bottom: 4px;
	    padding : 0 !important;
	  	width : 1300px !important; 
	  	height : auto !important; 
	  	border : 1px solid red;
	  	
	}
	#presentContent{
		border : 1px solid yellowgreen;
		width : 350px;
		height : 250px;
		text-align : center;
		margin-right : auto;
		margin-left : auto;
	}
	#imgArea img{
		border : 1px solid black;
	}
</style>
</head>
<body>
	<jsp:include page="../common/mainMenuBar.jsp"/>
	
	<div class = "content">
	<h1>선물하기</h1>
		<form action="insertPresent.do" method = "post">
			<div id = "presentArea">
			<br>
				아이디 입력 : <input id = "presentUserId" type="text" size = "20" name = "presentUserId"> &nbsp;
				<button onclick = "checkId()">아이디 확인</button>
				<br><br>
				<div id = "imgArea">
					<input id = "hide_itemNo" type = "hidden" value = "${item.itemNo}" name = "itmeNo">
					<img src="${contextPath}/resources/itemImages/${item.itemLink}">
					<p>
						[${item.itemCategory}]<br>
						${item.itemName}<br>
						가격 : ${item.price}
					</p>
				</div>
				<br>
				
				<div id = "presentContent">
					<p>				
						내용 작성<br>
					</p>
					<textarea id="Content" rows="6" cols="50" style = "resize : none" name="presentContent"></textarea>
				</div>
				<br>
				<button id = "submit_btn" type = "button">선물하기</button>
				<button onclick = "location.href='history.go(-1)'">이전으로</button>
				
				<div id = "warningText" align = "center" style = "display : none">
					<p style = "width : 300px; height : 100px; border : 1px solid blue; margin : auto;">
						<br><br>
						보유하고 있는 잣이 부족합니다!
					</p>
					<button type = "button" onclick = "location.href='chargingPoint.do'">충전하기</button><!-- 충전 뷰 페이지로 이동 -->
				</div>
			</div>
		</form>
	</div>
	
	<script>
		$(function(){
			$("#submit_btn").click(function(){
				var presentUserId = $("#presentUserId").val();
				var itemNo = $("#hide_itemNo").val();
				var presentContent = $("#Content").val();
				
				$.ajax({
					url:"insertPresent.do",
					type:"post",
					data:{presentUserId:presentUserId, itemNo:itemNo, presentContent:presentContent},
					success:function(data){
						if(data == "haveItem"){
							alert("선물받는 유저가 이미 해당 아이템을 가지고 있습니다.");
						}else if(data == "haveGift"){
							alert("선물받는 유저의 선물함에 해당 아이템이 있습니다.");
						}else if(data == "lackPoint"){
							$("#warningText").show();
							$("#submit_btn").attr('disabled', false);									
						}else if(data == "success"){
							alert("선물하기 성공!");
							location.href = "itemStoreList.do";
						}
						
					},error:function(request, status, errorData){
						alert("error code : "+request.status + "\n" + 
								"message : " + request.responseText + 
								"error : " + errorData);
					}
				})
			});
		});
	</script>
	<jsp:include page="../common/footer.jsp"/>
	
</body>
</html>