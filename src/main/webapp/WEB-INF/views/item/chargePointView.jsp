<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<!-- iamport.payment.js -->
  <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.content {
		    margin-left: 423px;
		    margin-top: 4px;
		    margin-bottom: 4px;
		    padding : 0 !important;
		  	width : 1300px !important; 
		  	height : auto !important; 
		  	border : 1px solid red;
		  	
		}
	#selectPointArea{
		text-align : center;
		width : 1000px;
		height : 400px;
		border : 1px solid green;
	}
</style>
</head>
<body>
	<jsp:include page="../common/mainMenuBar.jsp"/>
	
	<div class = "content">
		<h1>충전하기</h1>
		
		<div id = "selectPointArea" align = "center">
			<p>
				충전포인트 선택
			</p>
			<br>
			<input type = "radio" name = "jatpoint" value = "10">&nbsp;잣10개(1000원)
			<input type = "radio" name = "jatpoint" value = "20">&nbsp;잣20개(2000원)
			<input type = "radio" name = "jatpoint" value = "30">&nbsp;잣30개(3000원)
			<input type = "radio" name = "jatpoint" value = "40">&nbsp;잣40개(4000원)
			<input type = "radio" name = "jatpoint" value = "50">&nbsp;잣50개(5000원)
			<input type = "radio" name = "jatpoint" value = "etc">&nbsp;기타 : <input id = "writePoint" type = "text" placeholder = "포인트 입력  : 최소 10부터">
		</div>
		<button id = payment>충전하기</button>
	</div>
	
	<script>
	$(function(){
			var IMP = window.IMP; // 생략해도 괜찮습니다.
	       	IMP.init("imp43659263");
		$("#payment").click(function(){
			

			var checkVal = $("input:radio[name=jatpoint]:checked").val();
			var point = 0;
			var userId = "${loginUser.getUserId()}";
			var userName = "${loginUser.getUserName()}"; 
			var email = "${loginUser.getEmail()}";
			var phone = "${loginUser.getPhone()}";
			if(!$('input:radio[name=jatpoint]').is(':checked')){
				alert("버튼 체크 해주세요");
			}else{
				if(checkVal == "etc"){
					checkVal = Number($("#writePoint").val());
					point = Number($("#writePoint").val()) * 100;
				}else{
					checkVal = Number(checkVal);
					point = Number(checkVal) * 100;
				}
				
				if(checkVal < 10){
					alert("포인트 작성은 10이상부터입니다.");
				}else{
					var check = confirm("가격 : "+point + "\n" + "충전 포인트 : "+checkVal +"\n 충전하시겠습니까?");
					if(check == true){
				        IMP.request_pay({
				             pg : 'html5_inicis',
				             pay_method : 'card',
				             merchant_uid : 'merchant_' + new Date().getTime(),
				             name : '주문명:결제테스트',
				             amount : 100,	//point
				             buyer_email : email,
				             buyer_name : userId,
				             buyer_tel : phone,
				             buyer_addr : '서울특별시 강남구 삼성동',
				             buyer_postcode : '123-456'
				         }, function(rsp) {
				             if ( rsp.success ) {
				            	 alert("결제가 완료되었습니다.");
				                 location.href = "chargePoint.do?userId="+userId+"&checkVal="+checkVal;
				             } else {
				                 var msg = '결제에 실패하였습니다.';
				                 msg += '에러내용 : ' + rsp.error_msg;
				             }
				         });
					}
					
				}
			}
			
		});
	});
		
			
			
	</script>
	
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>