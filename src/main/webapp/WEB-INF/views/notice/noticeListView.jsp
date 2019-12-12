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
   </style>
</head>
<body>
	
	<br><br>
	
	<c:if test="${!empty loginUser }">
		<div align="center">
			<button onclick="location.href='csListVIew.do'">글쓰기</button>
		</div>
	</c:if>
	<br>
	<div style="border:0px;" align="center">
	<img src="resources/images/Latteworld.png" height="330px" width="360px" align="center"><br>
	<button onclick="location.href='nWriterView.do'">글쓰기</button>
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
	
	
	
	
	
</body>
</html>