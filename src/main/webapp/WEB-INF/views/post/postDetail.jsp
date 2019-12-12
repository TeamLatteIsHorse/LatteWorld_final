<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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
	left: 0px; width : 280px;
	height: 705px;
	background: yellow;
	width: 280px
}

.mainContent {
	position: absolute;
	top: 0px;
	left: 280px; width : 725px;
	height: 705px;
	background: yellowgreen;
	width: 725px;
}
</style>
</head>
<body>
	<jsp:include page="../minihome/miniHomeMenubar.jsp" />
	<div class="centerArea">
		<div class="subContent">
			<a href="allList.do?homepyNo=${post.homepyNo}&postType=B">전체 게시글 보기</a>
			<p>-------------------</p>
		</div>
		<div class="mainContent">
			<table>
				<tr> 
					<th> ${post.postNo }</th>
					<th> ${post.postTitle }</th>
				</tr>
				<tr>
					<td> ${post.postWriter }</td>
					<td> ${post.postCreateDT } &nbsp; ${post.postCount }</td>
				</tr>
				<tr>
					<td colspan="2">
						${post.postContent }
					</td>
				</tr>
			</table>
		</div>
	</div>
	<%@ include file="../minihome/miniHomefooter.jsp"%>
</body>
</html>
