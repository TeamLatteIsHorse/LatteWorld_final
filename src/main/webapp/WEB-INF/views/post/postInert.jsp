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

.insertArea {
	position: absolute;
	top: 30px;
	left: 30px;
	width: 665px;
	height: 645px;
	border: 1px solid black;
}
</style>
</head>
<body>
	<jsp:include page="../minihome/miniHomeMenubar.jsp" />
		<div class="centerArea">
			<div class="subContent"></div>
			<div class="mainContent">
			<form action="postInsert.do" method="post">
				<div class="insertArea">
					<input name="homepyNo" type="hidden" value="${homepyNo }">
					<input name="folderNo" type="hidden" value="${folderNo }">
					
					<label>제목 : </label><input name="postTitle" type="text" >
					<hr>
					&nbsp;&nbsp;&nbsp;&nbsp;<label>내용 </label>
					<br>
					&nbsp;&nbsp;&nbsp;&nbsp;<textarea name="postContent" rows="35" cols="85"></textarea>
				</div>
				<button type="submit">작성완료</button>
			</form>
			</div>
		</div>
	
	<%@ include file="../minihome/miniHomefooter.jsp"%>
</body>
</html>