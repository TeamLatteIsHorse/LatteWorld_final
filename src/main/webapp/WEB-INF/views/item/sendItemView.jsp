<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table th,td{
		border :1px solid black;
	}
	#imgbox{
		width : 100px !important;
		height : 100px !important;
	}
</style>
</head>
<body>
	<jsp:include page="../common/mainMenuBar.jsp"/>
	
	<div class = "content">
		<h2 align = "center">보낸 선물함</h2>
	
		<form action="">
			<table style = "margin : 20px; border : 1px solid black; text-align : center;">
				<tr>
					<th>받는 사람</th>
					<th>아이템</th>
					<th>카테고리</th>
					<th>이름</th>
					<th>보낸 날짜</th>	
					<th>받은 상태</th>
				</tr>
				
				<c:if test="${empty sendList}">
					<tr>	
						<td colspan = "6">보낸 선물이 없습니다.</td>
					</tr>
				</c:if>
				
				<c:if test="${!empty sendList}">
					<c:forEach var = "send" items = "${sendList}">
					<tr>
						<td>${send.presentUserId}</td>
						<td id = "imgbox"><img src="${contextPath}/resources/itemImages/${send.itemLink}"></td>
						<td>[${send.itemCategory}]</td>
						<td>${send.itemName}</td>
						<td>${send.presentDate}</td>
						<td>${send.presentStatus}</td>
					</tr>
					</c:forEach>
				</c:if>
			</table>
		</form>
		
	</div>

	<jsp:include page="../common/footer.jsp"/>
</body>
</html>