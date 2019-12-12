<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
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
<body>
	<jsp:include page="../common/mainMenuBar.jsp"/>
	
	<div class="content">
	<h1 align="center">공지글 등록 페이지</h1>
	
	<br><br>
	
	<form action="ninsert.do" method="post" enctype="Multipart/form-data">
		<table align="center" border="1" cellspacing="0" width="400">
			<tr>
				<td>제목</td>
				<td>
					<input type="text" size="50" name="nTitle">
				</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>
					<input type="text" name="nWriter" readonly value="${UserInfo.userId }">
				</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<textarea rows="7" cols="50" name="nContent"></textarea>
				</td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td>
					<input type="file" name="uploadFile1">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="등록 허가"> &nbsp;
					<input type="reset" value="등록 취소">					
				</td>
			</tr>			
		</table>
	</form>
	
	<p align="center">
		<a href="home.do">시작 페이지로 이동</a>
		<a href="nlist.do">목록 보기로 이동</a>
	</p>
	</div>
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>