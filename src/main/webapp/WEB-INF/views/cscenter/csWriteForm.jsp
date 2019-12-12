<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}

input[type=submit] {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

.btn{
	  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}

#cancel{
	
}

</style>
</head>
<body>

<h1>1:1 Q&A</h1>

<div class="container">
  <form action="csinsert.do" method="post">
   	<label for="question">질문유형</label>
    <select id="question" name="csType">
      <option value="결제관련">결제관련</option>
      <option value="적립금관련">적립금관련</option>
      <option value="시스템관련">시스템관련</option>
      <option value="회원관련">회원관련</option>
      <option value="기타문의">기타문의</option>
    </select>  

    <label for="Qname">작성자</label>
    <input type="text" id="Qname" name="csWriter" placeholder="문의주시는 회원님의 성함을 입력해주세용">



    <label for="detail">상세내용</label>
    <textarea name="csDetail" placeholder="상세내역을 입력해 주세요:)" style="height:200px"></textarea>


    <input class="btn" type="button" onclick="location.href ='csCenter.do'" value="취소하기">
    <input class="btn" type="submit" value="작성하기">
  </form>
</div>

</body>
</html>
