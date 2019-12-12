<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src = "http://code.jquery.com/jquery-3.3.1.min.js"></script>
<style>
	#buyArea{
		width : "1000px";
		height : 500px;
		border : 1px solid red;
		test-align : "center";
	}
</style>
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/mainMenuBar.jsp"/>
	
	<div class = "content">
		<div id = "buyArea">
			<table style = "margin : 20px; border : 1px solid black;" text-align = "center">
				<tr>
					<th>아이템</th>
					<th>카테고리</th>
					<th>이름</th>
					<th>가격</th>	
				</tr>
				<tr>
					<td><img src="${contextPath}/resources/itemImages/${item.itemLink}"></td>
					<td>${item.itemCategory}</td>
					<td>${item.itemName}</td>
					<td>${item.price}</td>
					<td><button id = "payment_btn" type = 'button' align = "center" onclick = "payment()">구매하기</button></td>
				</tr>
			</table>
			<br>
			<!-- 이 버튼은 나중에 회원가입 완성되고 하면 보유 잣이랑 비교해서 가격이 더 높으면 비활성화되게 -->
			<div id = "warningText" align = "center" style = "display : none">
				<p style = "width : 300px; height : 100px; border : 1px solid blue; margin : auto;">
					<br><br>
					보유하고 있는 잣이 부족합니다!
				</p>
				<button type = "button" onclick = "location.href='chargingPoint.do'">충전하기</button><!-- 충전 뷰 페이지로 이동 -->
			</div>
		</div>
	</div>
	
	<script>
		function payment(){
			var itemNo=${item.itemNo}
			
			var check = confirm("구매 하시겠습니까?");
			console.log(check);
			if(check == true){
				$.ajax({
					url:"buyItem.do",
					type:"post",
					data:{itemNo:itemNo},
					success:function(data){
						if(data == "lackPoint"){
							$("#warningText").show();
							$("#payment_btn").attr('disabled', true);
						}else if(data == "success"){
							alert("구매가 완료되었습니다.");
							location.href="itemStoreList.do";						
						}
					},
					error:function(request, status, errorData){
						alert("error code : "+request.status + "\n" + 
								"message : " + request.responseText + 
								"error : " + errorData);
					}
				})
			}
		}
		
		
	</script>
	
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>