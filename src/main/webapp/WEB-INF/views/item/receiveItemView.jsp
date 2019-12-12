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
		<h2 align = "center">받은 선물함</h2>
	
		<form action="">
			<table style = "margin : 20px; border : 1px solid black; text-align : center;">
				<tr>
					<th>받는 사람</th>
					<th>아이템</th>
					<th>카테고리</th>
					<th>이름</th>
					<th>보낸 날짜</th>	
					<th></th>
				</tr>
				
				<c:if test="${empty receiveItem}">
					<tr>	
						<td colspan = "6">받은 선물이 없습니다.</td>
					</tr>
				</c:if>
				
				<c:if test="${!empty receiveItem}">
					<c:forEach var = "receive" items = "${receiveItem}">
					<tr>
						<td>${receive.presentUserId}</td>
						<td id = "imgbox"><img src="${contextPath}/resources/itemImages/${receive.itemLink}"></td>
						<td>[${receive.itemCategory}]</td>
						<td>${receive.itemName}</td>
						<td>${receive.presentDate}</td>
						<td><button id = "receive_btn" value = "${receive.itemNo}">선물받기</button></td>
					</tr>
					</c:forEach>
				</c:if>
			</table>
		</form>
	</div>
	
	<script>
		$("#receive_btn").click(function(){
			var itemNo = $(this).val();
			
		})
	</script>

	<jsp:include page="../common/footer.jsp"/>
</body>
</html>