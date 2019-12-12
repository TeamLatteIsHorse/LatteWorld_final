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
	left: 0px;
	width : 280px;
	height: 705px;
	background: yellow;
	width: 280px
}

.addBoard {
	position: absolute;
	top: 675px;
	left: 0px;
	width: 280px;
	height: 30px;
	background: #FFB2F5;
}
.mainContent {
	position: absolute;
	top: 0px;
	left: 280px; width : 725px;
	width: 725px;
	height: 705px;
	background: yellowgreen;
}

.folderList {
	position: absolute;
	top: 40px;
	left: 40px;
	width: 280px;
	height: 530px;
	background: gray;
}

.btnArea1 {
	position: absolute;
	top: 575px;
	left: 40px;
}
 
.addFolder {
	position: absolute;
	top: 40px;
	left: 370px;
	width: 280px;
	height: 280px;
}

.btnArea2 {
	position: absolute;
	top: 655px;
	left: 625px;
	width: 100px;
	height: 50px;
	background: gray;
}
</style>
</head>
<body>
	<jsp:include page="../minihome/miniHomeMenubar.jsp" />
	<div class="centerArea">
		<div class="subContent">
			<a href="allList.do?homepyNo=${minihome.homepyNo}&postType=B">전체 게시글 보기</a>
			<p>-------------------</p>
			<c:forEach var="folder" items="${fList }">
				<c:set var="folderNo" value="${folder.folderNo }"/>
				<c:url var="postList" value="postList.do">
					<c:param name="folderNo" value="${folder.folderNo }" />
					<c:param name="homepyNo" value="${minihome.homepyNo }" />
					<c:param name="postType" value="B"/>
				</c:url>
				<a href="${postList} ">${folder.folderName }</a>
				<br>				
			</c:forEach>
			<div class="folderSettingArea">
				<c:url var="settingFolder" value="settingFolder.do">
					<c:param name="homepyNo" value="${minihome.homepyNo }" />
					<c:param name="postType" value="B"/>
				</c:url>
				<a href="${settingFolder }">게시판 관리하기</a>
			</div>
		</div>
		<div class="mainContent">
			<div id="folderList" class="folderList">
				<c:forEach var="folder" items="${fList }">
					<p>${folder.folderName }</p>
				</c:forEach>
			</div>
			<div class="btnArea1"> 
				<button>수정</button>
				<button>삭제</button>
			</div>
			
			<div class="addFolder">
				<input id="folderName" type="text" style="width: 210px; height: 30px;">
				<button id="addFolder">확인</button>
				<br><br>
				<label>공개 설정 : </label>
				<select>
					<option>공개</option>
					<option>비공개</option>
				</select>
			</div>
			<div class="btnArea2">
				<button style="width: 80px; height: 30px;">확인</button>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		// 게시판 목록 추가하는 ajax
		$("#addFolder").on("click", function(){
			var folderName = $("#folderName").val();
			var postType = "B";
			var homepyNo = ${minihome.homepyNo };
			var folderNo = ${folderNo} + 1;
			
			$.ajax({
				url:"addFolder.do",
				data:{folderName:folderName, postType:postType, homepyNo:homepyNo, folderNo:folderNo},
				
				success:function(data){
					if(data=="success"){
						$("#folderName").val("");
						location.reload();
					}
				},
				error:function(request, status, errorData){
					alert("error code: " + request.status + "\n"
							+"message: " + request.responseText
							+"error: " + errorData);
				}	
			});
		}); 
	</script>
	<%@ include file="../minihome/miniHomefooter.jsp"%>
</body>
</html>