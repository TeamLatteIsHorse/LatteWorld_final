<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<style>
	.photoContent{
		border: 1px solid black;
	    width: 500px;
	    height: 530px;
	    margin: auto;
	    padding: 20px;
	}
	#profileSubmit{
		position: relative;
	    float: right;
	    right: 120px;
	    top: 160px;
	}
	#profileCancle{
		position: relative;
	    float: right;
	    top: 160px;
	}
	.photoProfile{
		border : 1px solid black;
		width: 200px;
		height: 230px;
		max-width: 100%;
	}
	
	.fileName{
		position: relative;
   	 	left: 220px;
    	top: 209px
	}
	
	.profileContent{
		margin-top: 50px;
    	margin-left: -90px;
    	resize:none;
		
	}
	.profileMsg{
		position: relative;
    	bottom: 60px;
	}
	
	#image {
		width: auto;
	    max-width: 100%;
	    height: auto;
	    max-height: 100%;
	    display: block;
	    margin: 0px auto;
		
	}
	
	
	
</style>
<script type="text/javascript">

	$(document).ready(function() {
		
		function readURL(input) {
			if (input.files && input.files[0]) {
				var reader = new FileReader(); //파일을 읽기 위한 FileReader객체 생성 
				reader.onload = function(e) { //파일 읽어들이기를 성공했을때 호출되는 이벤트 핸들러
					$('#image').attr('src', e.target.result);
					//이미지 Tag의 SRC속성에 읽어들인 File내용을 지정 
					//(아래 코드에서 읽어들인 dataURL형식) 
				}
				reader.readAsDataURL(input.files[0]); //File내용을 읽어 dataURL형식의 문자열로 저장
			}
		}//readURL()-- //file 양식으로 이미지를 선택(값이 변경) 되었을때 처리하는 코드 
		$("#files").change(function() { //alert(this.value); //선택한 이미지 경로 표시 
			readURL(this);
		});
		
		$("#profileSubmit").on("click", function() {
			nowDate();
		});
		
		var homepyNo = "${MiniHome.homepyNo}";
		   profileImg();
			
			function profileImg() {
				$.ajax({
					url: "profileImg.do",
					type: "get",
					cache: false,
					data: {
						homepyNo: homepyNo
					},
					dataType: "JSON",
					success: function( json ) {
						var result = json.result;
						$( result ).each( function() {
							var profileImg = this.profileImg;
							var profileContent = this.profileContent;
							
							console.log(profileImg);
							
							$(".profileContent").html(profileContent);
							$("#image").attr("src", "./resources/images/" + profileImg );
						});
					}
					
				})
			}
	});
		
	
	function nowDate(){
		var today = new Date();
		var dd = today.getDate();
		var mm = today.getMonth()+1; //January is 0!
		var yyyy = today.getFullYear();

		if(dd<10) {
		    dd='0'+dd
		} 

		if(mm<10) {
		    mm='0'+mm
		} 

		today = yyyy+'-'+mm+'-'+dd;
		
		$(".MinihomeProfile").attr("action", "miniHomeEdit_ok.do");
		$(".MinihomeProfile").find("input[name=profileDate]").val(today);
		$(".MinihomeProfile").submit();
	}
	
	
	  
	 
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body onresize="parent.resizeTo(1420,950)" onload="parent.resizeTo(1420,950)" style="overflow-x:hidden; overflow-y:hidden;">
	<div class = "photoContent">
		<div class = "photoProfile">
			<img id="image" src="#" />
		</div>
		<div >
		<form class="MinihomeProfile" method="post" enctype="Multipart/form-data">
				<input type="hidden" name="id" value="${user.userId }" />
				<input type="hidden" name="profileNum" value="${minihome.profileNum }"/>
				<input type="hidden" name="profileDate"/>
				<input type="hidden" name="homepyNo" value="${minihome.homepyNo }"/>
				<input type="file" id="files" name="profileImg" />
		</div>
		<label for="profileContent" class="profileMsg">상태 메시지</label>
		<textarea id="profileContent" class="profileContent" name = "profileContent" cols="50" rows="3"></textarea>
		<div class="editBtn">
			<input id="profileSubmit" value="등록" />
			<input type="button" id="profileCancle" onclick="location.href='minihome.do?userId=${UserInfo.userId}'" value="취소" />
		</div>
		</div>
		</form>			
	
</body>
</html>