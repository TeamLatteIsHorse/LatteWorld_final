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
		</div>
		<div class="mainContent">
			<table>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
				<c:if test="${pList != null }">
					<c:forEach var="post" items="${pList }">
						<tr>
							<td>${post.postNo }</td>
							<c:url var="postDetail" value="postDetail.do">
								<c:param name="postNo" value="${post.postNo }"/>
								<c:param name="page" value="${pi.currentPage }"/>
								<c:param name="homepyNo" value="${minihome.homepyNo }" />
							</c:url>
							<td><a href="${postDetail }">${post.postTitle }</a></td>
							<td>${post.postWriter }</td>
							<td>${post.postCreateDT }</td>
							<td>${post.postCount }</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="5">
							<!-- [이전] --> 
							<c:if test="${pi.currentPage <= 1 }">
	 							[이전]&nbsp;
	 						</c:if>
	 						<c:if test="${pi.currentPage > 1 }">
								<c:url var="postListBack" value="/postList.do">
									<c:param name="page" value="${pi.currentPage - 1 }" />
									<c:param name="homepyNo" value="${minihome.homepyNo }" />
									<c:param name="folderNo" value="${fNo }" />
									<c:param name="postType" value="B" />
								</c:url>
								<a href="${postListBack }">[이전]</a>
							</c:if>
							<!-- [번호들] --> 
							<c:forEach var="p" begin="${pi.startPage }"
								end="${pi.endPage }">
								<c:if test="${p eq pi.currentPage }">
									<font color="red" size="4"><b>[${p}]</b></font>
								</c:if>
	
								<c:if test="${p ne pi.currentPage }">
									<c:url var="postListCheck" value="postList.do">
										<c:param name="page" value="${p }" />
										<c:param name="homepyNo" value="${minihome.homepyNo }" />
										<c:param name="folderNo" value="${fNo }" />
										<c:param name="postType" value="B" />
									</c:url>
									<a href="${postListCheck }">${p }</a>
								</c:if>
							</c:forEach>
							<!-- [다음] -->
							<c:if test="${pi.currentPage >= pi.maxPage }">
	 							&nbsp;[다음]
	 						</c:if> 
	 						<c:if test="${pi.currentPage < pi.maxPage }">
								<c:url var="postListEnd" value="postList.do">
									<c:param name="page" value="${pi.currentPage + 1 }" />
									<c:param name="homepyNo" value="${minihome.homepyNo }" />
									<c:param name="folderNo" value="${fNo }" />
									<c:param name="postType" value="B" />
								</c:url>
								<a href="${postListEnd }">&nbsp;[다음]</a>
							</c:if>
						</td>
					</tr>
				</c:if>
				<c:if test="${pList == null }">
					게시글이 없습니다.
				</c:if>
				<tr>
					<td colspan="5"> <button onclick="location.href='posetInsertView.do?homepyNo=${minihome.homepyNo }&postType=B&folderNo=${folderNo }'">글작성</button> </td>
				</tr>
			</table>
		</div>
	</div>
	<%@ include file="../minihome/miniHomefooter.jsp"%>
</body>
</html>

