<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src = "http://code.jquery.com/jquery-3.4.1.min.js"></script>
<style>
	table th,td{
		border :1px solid black;
	}
	#imgbox{
		width : 100px !important;
		height : 100px !important;
	}
</style>
</head>
<body>
	<jsp:include page="../common/mainMenuBar.jsp"/>
	
	<div class = "content">
		<h2 align = "center">찜목록</h2>
			<table style = "margin : 20px; border : 1px solid black; text-align : center;">
			<c:if test="${empty kipItemList}">
				<tr>
					<td colspan="6">찜한 아이템이 없습니다.</td>
				</tr>
			</c:if>
			<c:if test="${!empty kipItemList}">
				<tr>
					<th><input type = "checkbox" id = "allCheck"></th>
					<th>아이템</th>
					<th>카테고리</th>
					<th>이름</th>
					<th>가격</th>	
					<th></th>
				</tr>
				<c:forEach var = "kip" items = "${kipItemList}">
					<tr>
						<td>${kip.itemNo}<input type = "checkbox" name = "plusPoint" class = "plusPoint" value="${kip.itemNo}"></td>
						<td id = "imgbox"><img src="${contextPath}/resources/itemImages/${kip.itemLink}"></td>
						<td>${kip.itemCategory}</td>
						<td>${kip.itemName}</td>
						<td>잣 ${kip.price}개 <input type = "hidden" class = "jatPoint" value = "${kip.price}"></td>
						<td><button class = "del_kipItem_btn" type = 'button' align = "center" value = '${kip.itemNo}'>삭제하기</button></td>
					</tr>
				</c:forEach>
			</c:if>
			</table>
		<div id = "warningText" align = "center" style = "display : none">
			<p style = "width : 300px; height : 100px; border : 1px solid blue; margin : auto;">
				<br><br>
				보유하고 있는 잣이 부족합니다!
			</p>
			<button type = "button" onclick = "location.href='chargingPoint.do'">충전하기</button><!-- 충전 뷰 페이지로 이동 -->
		</div><br>
		<c:if test="${!empty kipItemList}">
			<button id = "kipItemPayment">구매하기</button>
		</c:if>
	</div>
	
	<script>
	$(function(){
		$(".del_kipItem_btn").on("click", function(){
			var itemNo = $(this).val();
			
			$.ajax({
				url:"delKipItem.do",
				data:{itemNo:itemNo},
				type:"post",
				success:function(data){
					if(data == "success"){
						alert("삭제되었습니다.")
						location.reload(); 
					}
						
				},
				error:function(request, status, errorData){
					alert("error code : "+request.status + "\n" + 
							"message : " + request.responseText + 
							"error : " + errorData);
				}
			})
			
		})
	});
	
	$(function(){
		var allpoint = 0;
		var itemPrice = 0;
		var list = [];
		
		$("#allCheck").click(function(){	// 전체선택 클릭할때 발생되는 이벤트(다 체크되는지 다 해제되는지)	
			if($("#allCheck").prop("checked")){
				$(".plusPoint").prop("checked", true);
					list=[];
					// 전체 선택할때 값을 비워줘야 
					// 전체선택한 후에 아무 아이템 체크해제하고 다시 전체선택할때도 남아있는 값이 없어진다.
				$(".plusPoint").each(function(i){	//each함수로 아이템 리스트 for문처럼 돌려서 값 넣어주기
					var allcheck = $(".plusPoint").eq(i).val();	//
					list.push(allcheck);
				})
				$.ajax({
					url:"checkPoint.do",
					dataType:"json",
					type:"post",
					data:{list:list},
					success:function(data){
						if(data.text == "warning"){
							$("#warningText").show();
							$("#kipItemPayment").attr('disabled', true);
						}
						if(data.text == "hidewarning"){
							$("#warningText").hide();
							$("#kipItemPayment").attr('disabled', false);
						}
						
					},
					error:function(request, status, errorData){
						alert("error code : "+request.status + "\n" + 
								"message : " + request.responseText + 
								"error : " + errorData);
					}
				})
			}else{
				$(".plusPoint").prop("checked", false);
				$(".plusPoint").each(function(){
					list.pop();	// 리스트 전체pop(리스트 값 전부 빼내기)
				})
				$.ajax({
					url:"checkPoint.do",
					dataType:"json",
					type:"post",
					data:{list:list},
					success:function(data){
						if(data.text == "warning"){
							$("#warningText").show();
							$("#kipItemPayment").attr('disabled', true);
						}
						if(data.text == "hidewarning"){
							$("#warningText").hide();
							$("#kipItemPayment").attr('disabled', false);
						}
						
					},
					error:function(request, status, errorData){
						alert("error code : "+request.status + "\n" + 
								"message : " + request.responseText + 
								"error : " + errorData);
					}
				})
			}
			console.log(list);
		})	// 전체 체크 이벤트 종료
		
		$(".plusPoint").click(function(){	// 전체 체크 제외 클릭 했을때
	         if($(".plusPoint:checked").length =="#"){	// 다 체크된 상태에서 전체선택 말고 하위애들 체크 해제시 전체 선택 해제
	            $("#allCheck").prop("checked",true);
	         }else{
	            $("#allCheck").prop("checked",false);
	         } // 여기까지가 선택 해제 이벤트
	         
	         // 클릭한 아이템 보낼list에 넣거나 빼기
	         var addPoint = $(this).val();
	         if($(this).prop("checked")){
	 	 		list.push(addPoint);
	 	 		
	 	 		$.ajax({
					url:"checkPoint.do",
					dataType:"json",
					type:"post",
					data:{list:list},
					success:function(data){
						if(data.text == "warning"){
							$("#warningText").show();
							$("#kipItemPayment").attr('disabled', true);
						}
						if(data.text == "hidewarning"){
							$("#warningText").hide();
							$("#kipItemPayment").attr('disabled', false);
						}
						
					},
					error:function(request, status, errorData){
						alert("error code : "+request.status + "\n" + 
								"message : " + request.responseText + 
								"error : " + errorData);
					}
				})
	         }else{
	        	 list=[];
	        	 $("[class=plusPoint]:checked").each(function(i){
					var plusCheck = $(this).val();
					
					console.log("plusCheck = "+plusCheck);
					list.push(plusCheck);
				})
				$.ajax({
					url:"checkPoint.do",
					dataType:"json",
					type:"post",
					data:{list:list},
					success:function(data){
						if(data.text == "warning"){
							$("#warningText").show();
							$("#kipItemPayment").attr('disabled', true);
						}
						if(data.text == "hidewarning"){
							$("#warningText").hide();
							$("#kipItemPayment").attr('disabled', false);
						}
						
					},
					error:function(request, status, errorData){
						alert("error code : "+request.status + "\n" + 
								"message : " + request.responseText + 
								"error : " + errorData);
					}
				})
	         }
	         console.log(list);
	     });	// 해당 아이템 체크 이벤트 종료

		$("#kipItemPayment").click(function(){
			var check = confirm("구매 하시겠습니까?");
			
			if(check == true){
				$.ajax({
					url:"buyKipList.do",
					data:{list:list},
					type:"post",
					success:function(data){
						if(data == "nullList"){
							alert("선택한 아이템이 없습니다!");
						}
						if(data == "success"){
							alert("구매하였습니다.");
							location.reload();
						}
						if(data == "fail"){
							alert("실패..");
						}
					},
					error:function(request, status, errorData){
						alert("error code : "+request.status + "\n" + 
								"message : " + request.responseText + 
								"error : " + errorData);
					}	
				})
			}
		})
	})// 전체 익명함수 종료
	
	</script>
      
	
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>