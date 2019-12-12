<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<style type="text/css">
	.topArea{
		width: 1380px;
		height: 50px;
		background: black;
	}
	
	.leftArea{
		width: 50px;
		height: 750px;
		background: black;
		float: left;
	}
	
	.rightArea{
		width: 325px;
		height: 750px;
		background: black;
		float: left;
	}
	
	.menuBtnArea{
		width: 100px;
		height: 150px;
		margin: 45px 0px 0px 0px
	}
	
	.menuBtn{
		width: 100px;
		height: 30px;
	}
	
	.count-titleArea{
		width: 1005px;
		height: 45px;
		background: yellow;
		float: left;
	}
</style>
</head>
<body>
	<div class="topArea"></div>
	<div class="leftArea"></div>
	<div class="count-titleArea">
		total : ${minihome.totalCount } &nbsp;&nbsp;&nbsp;&nbsp; ${minihome.miniHomeTitle }
	</div>
	<div class="rightArea">
		<div class="menuBtnArea">
			<button id="menuBtn1" class="menuBtn">홈</button>
			<button id="menuBtn2" class="menuBtn">다이어리</button>
			<button id="menuBtn3" class="menuBtn">사진첩</button>
			<button id="menuBtn4" class="menuBtn">게시판</button>
			<button id="menuBtn5" class="menuBtn">방명록</button>
		</div>
	</div>
	<script type="text/javascript">
		$("#menuBtn1").click(function() {
			location.href = "minihome.do?userId=${minihome.userId}";
		});
	
		$("#menuBtn4").click(function() {
			location.href = "allList.do?homepyNo=${minihome.homepyNo}&postType=B";
		});
	</script>
</body>
</html>