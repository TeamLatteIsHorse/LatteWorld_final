<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.centerArea {
	position: relative;
	width: 1005px;
	height: 705px;
	background: red;
	margin: 45px 0px 0px 50px;
	color: black;
}

.subContent {
	position: absolute;
	top: 0px;
	left: 0px;
	width: 280px;
	height: 705px;
	background: yellow;
	width: 280px
}

.mainContent {
	position: absolute;
	top: 0px;
	left: 280px;
	width: 725px;
	height: 705px;
	background: yellowgreen;
	width: 725px;
}

#contentHistoryBtn {
	margin-top: 300px;
	margin-right: 10px;
	float: right;
}

#contentEditBtn{
	margin-top: 300px;
    margin-right: 10px;
    float: right;
}

#imgs{
	width: 25px;
    position: relative;
    top: 6px;
    left: 70px;
}
#EmotionBox{
	position:relative;
	left:160px;
}

#image{
	width:100px;
}
</style>
</head>
<body>
<jsp:include page="../minihome/miniHomeMenubar.jsp" />
<div class="centerArea">
	<div class="subContent">
		test
	</div>
	<div class="mainContent"></div>
</div>
<%@ include file="../minihome/miniHomefooter.jsp" %>
</body>
</html>