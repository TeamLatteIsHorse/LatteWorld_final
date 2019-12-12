<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

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

* {
  box-sizing: border-box;
}

/* Create two equal columns that floats next to each other */
.column {
  float: left;
  width: 50%;
  padding: 10px;
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}
</style>
</head>
<body>
<jsp:include page="../common/mainMenuBar.jsp"/>
<div class="content">
<c:forEach var="cs" items="${list}">
<form action = "updateCsReply.do" method = "post">
<div class="row">
	<input type = "hidden" name = "csListNum" value = "${cs.csListNum}">
  <div class="column" style="background-color:#aaa;">
  <hr>
    <div class="csdate" ><h1>${cs.csDate}</h1></div>    
    <div class="cstype" >${cs.csType}</div>
    <div class="cswriter">${cs.csWriter}</div>
    <div class="csdetail">${cs.csDetail }</div>
    <div class="csReply" align="center" width="500">${cs.csReply }</div>
    <br>
    	<c:if test="${UserInfo.userType eq 2}">
		<c:if test="${empty cs.csReply}">
    	<table align="center" width="500" border="1" cellspacing="0">
		<tr>
			<td><textarea cols="55" rows="3" name = "csReply"></textarea></td>
			<td>
				<button type = "submit" id="rSubmit">등록하기</button>
			</td>
		</tr>
		</table>
		</c:if>
		</c:if>
  </div>
  <!-- 답글 등록하기 -->

  
</div>
</form>
</c:forEach>
</div>
<jsp:include page="../common/footer.jsp"/>

</body>
</html>