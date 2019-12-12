<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css?family=Press+Start+2P" rel="stylesheet">
<title>공지사항</title>
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
   </style>
</head>
<body>
	<jsp:include page="../common/mainMenuBar.jsp"/>	
	<div class="content">
	<br><br>	
	<br>
	<div style="border:0px;" align="center">
	<img src="resources/images/Latteworld.png" height="330px" width="360px" align="center"><br>
	<c:if test="${UserInfo.userType eq 2}">
	<div align="center">
	<button onclick="location.href='nWriterView.do'">글쓰기</button>
	</div>
	</c:if>
	</div>
	<table align="center" width="600" border="1" cellspacing="0" style="clear:right;" id="td">
		<tr bgcolor="#99ccff">
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>올린날짜</th>
			<th>첨부파일</th>
		</tr>
		
		<c:forEach var="n" items="${list}">
			<tr>
				<td align="center">${n.nId }</td>
				<td>
					<c:if test="${!empty UserInfo }">
						<!-- 이따가 작성 -->
						<c:url var="noticeDetailView" value="noticeDetailView.do">
							<c:param name="nId" value="${n.nId }"/>
						</c:url>
						<a href="${noticeDetailView }">${n.nTitle }</a>
					</c:if>
					<c:if test="${empty UserInfo }">
						${n.nTitle }
					</c:if>
				</td>
				
				<td align="center">${n.nWriter }</td>
				<td align="center">${n.nCreateDate }</td>
				
				<td align="center">
					<!-- 이따가 작성 -->
					<c:if test="${!empty n.filePath }">
						★
					</c:if>
					<c:if test="${empty n.filePath }">
						&nbsp;
					</c:if>
				</td>
			</tr>
		</c:forEach>	
	</table>
	<div align="center" style="border:0px">
	<p class= align="center">
		<c:url var="home" value="home.do"/>
		<a href="${home }">시작 페이지로 이동</a>&nbsp;
		<c:url var="nlist" value="noticeListView.do"/>
		<a href="${nlist }">목록 전체 보기</a>
	</p>
</div>
</div>
	<jsp:include page="../common/footer.jsp"/>
	
	
	
	
</body>
</html>