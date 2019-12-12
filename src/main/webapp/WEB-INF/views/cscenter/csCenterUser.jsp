<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
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
	
	#content{
		max-width:1000px;
		padding:30px 20px 56px;
		margin: 10px auto;
		width:70%;
		border: 3px solid #ACADA8;
}
.show{
	display:block;
	}
	#myBtn{
		border:none;
		font-weight:bold;
		font-size:18px;
		position:relative;
		right:30px;
		bottom:130px;
	}
	
		ul{
		list-style:none; 
		float:right; 
	}
		#content2{
		max-width:800px;
		padding:30px 20px 56px;
		margin: 10px auto;
		width:70%;
		box-sizing:border-box;
		display:none;
	}
	#content3{
		max-width:800px;
		padding:30px 20px 56px;
		margin: 10px auto;
		width:70%;
		box-sizing:border-box;
		display:none;
		}
	#content4{
		max-width:800px;
		padding:30px 20px 56px;
		margin: 10px auto;
		width:70%;
		box-sizing:border-box;
		display:none;
		}
	#content5{
		max-width:800px;
		padding:30px 20px 56px;
		margin: 10px auto;
		width:70%;
		box-sizing:border-box;
		display:none;
		}
</style>
<body>
<jsp:include page="../common/mainMenuBar.jsp"/>
<div class="content">
<div id = "content">
	<div id = "title">고객센터</div>
	<div>
<p id="p2">운영시간:평일 10~17시 (점심시간 12~13시) <br>
이메일:kh@naver.com<br>
전화:02)1234-5678
</p>
</div>
	<div class="abc">
<input type="button" onclick="location.href='csWriteForm.do'" name="commit" value = "1:1문의하기" class="button1">
		<ul>
		<li><button id = "myBtn" class="awd1">배송은 얼마나 걸리나요?</button></li>
		<li><button id = "myBtn" class="awd2">주문 취소는 어떻게 하나요?</button></li>
		<li><button id = "myBtn" class="awd3">제품의 자세한 정보를 알고 싶어요.</button></li>
		<li><button id = "myBtn" class="awd4">제품이 불량일 때는?</button></li>
		<li><button id = "myBtn" class="awd5" onclick="location.href='csListVIew.do'">문의내역 보기</button></li>
	</ul>
		</div>	
		<br>
		<div id = "content2">
	<div class="QA">Q</div> 배송은 얼마나 걸리나요? <br>
	<br>
	<div class="QA">A</div> 상품 배송 기간은 배송 유형에 따라 출고 일자 차이가 있습니다.<br>
	자세한 사항은 구매하신 상품의 상세 페이지에서 확인 가능하며, <br>
	배송 유형 별 기본 출고 기간은 아래와 같습니다.<br><br>
	∙ 일반 택배 / 화물 택배 : 결제 후 1~3 영업일 이내 출고됩니다.<br>
	∙ 업체 직접 배송 : 배송 지역에 따라 배송 일자가 상이할 수 있으므로<br>
	상품 상세 페이지에서 확인 해주세요.<br><br>
	※ 영업일은 주말, 공휴일을 제외한 기간입니다.<br>
	※ 제조사의 사정에 따라 출고일은 지연될 수 있는 점 양해 부탁드립니다.<br>
	<br><hr>
</div>
		<div id = "content3">
	<div class="QA">Q</div> 주문 취소는 어떻게 하나요?
	<br><br>
	<div class="QA">A</div> 판매처에서 주문을 확인하기 전이라면언제든 취소하실 수 있으며,<br>[나의 쇼핑>주문배송내역 조회>주문상세보기]에서<br>
	직접 주문취소하실 수 있습니다.<br>
	※이미 판매처에서 상품을 확인해 준비 중이라면, 직접취소가 어렵습니다.<br>
	상세 페이지에 확인되는 판매자 연락처 또는 라떼월드 고객센터로 문의 부탁드립니다.<br>
	<br><hr>
</div>

<div id = "content4">
	<div class="QA">Q</div> "좋아요"를 누른 콘텐츠(사진/집들이/노하우/등)들은 어디서 볼 수 있나요?
	<br><br>
	<div class="QA">A</div> 각 제품의 상세 페이지에서 확인 가능하며, 더욱 자세한 정보는 <br>
	제품상세페이지 내 문의하기를 통해	판매 업체에 문의 가능합니다.<br>
	<br><hr>
</div>

<div id = "content5">
	<div class="QA">Q</div> 제품이 불량입니다. 반품 혹은 교환은 어떻게 하나요?
	<br><br>
	<div class="QA">A</div> 업체(브랜드)마다 발송처 및 반품절차가 다릅니다.<br><br>
	-우측 상단 프로필 사진을 클릭 후 [나의쇼핑]페이지에서 원하는 주문의<br>
	상세보기 버튼을 클릭 후 교환/반품 접수 후 진행 할 수 있습니다.<br>
	교환/반품 접수 없이 임의로 반송한 경우에는 처리가 늦어질 수 있습니다.<br><br>
	-교환/반품 접수 시 원활한 처리를 위해 불량 사진이 필요하오니,<br>
	가급적 사진을 첨부하여 주시기 바랍니다.<br>
	단,구매확정 이후 교환/반품을 원하시는 경우 <br>
	판매 업체에 교환/반품 가능 여부를 먼저 문의 부탁드립니다.<br>
	<br><hr>
</div>
	</div>
</div>
<script>
	$(function(){
		$(".awd1").click(function(){
			$("#content2").toggle();
		});		
	});
	
	$(function(){
		$(".awd2").click(function(){
			$("#content3").toggle();
		});		
	});
	
	$(function(){
		$(".awd3").click(function(){
			$("#content4").toggle();
		});		
	});
	
	$(function(){
		$(".awd4").click(function(){
			$("#content5").toggle();
		});		
	});	
</script>
<jsp:include page="../common/footer.jsp"/>
</body>
</html>