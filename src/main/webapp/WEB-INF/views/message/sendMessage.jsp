<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src = "http://code.jquery.com/jquery-3.4.1.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>받는이 : </td>
			<td>
				<select id="receiveId" name="receiveId">
				
					<option>------</option>	
					<option>gtmxha1</option>
					<option>gtmxha2</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>내용</td>
		</tr>
		<tr>
			<td>
			<textarea id="messageContent" name="messageContent" cols="40" rows="5" onKeyUp="javascript:fnChkByte(this,'400')"></textarea>
			<span id="byteInfo">0</span>자 / 최대400자
			</td>
		</tr>
		<tr>
			<td>
			<button id="sendM"type="button" >전송</button>
			<button onclick="closeR()">닫기</button>	
			</td>
		</tr>
		
	</table>
	
	<script>
	
	//전송하기
	$("#sendM").click(function(){
		var receiveId = $("#receiveId").val();
		var messageContent=$("#messageContent").val();
		
		$.ajax({
			url : 'sendMessage.do',
			data : {receiveId:receiveId, messageContent:messageContent},
			type:"post",
			success:function(data){
				if(data=="success"){
					window.close();
				}
			}
		});
	});
	
	//글자 수 제한
	function fnChkByte(obj, maxByte){
		var str = obj.value;
		var str_len = str.length;
		
		var rbyte=0;
		var rlen=0;
		var one_char="";
		var str2="";
		
		for(var i=0;i<str_len;i++){
			one_char = str.charAt(i);
			if(escape(one_char).length>4){
				rbyte+=2;	//한글2바이트
			}else{
				rbyte++;	//영어 등 나머지 1바이트
			}
			
			if(rbyte <= maxByte){
				rlen = i+1;	//return할 문자열 갯수
			}
		}
		
		if(rbyte>maxByte){
			alert("한글" +(maxByte/2)+"자 / 영문"+maxByte+"자를 초과할 수 없습니다");
			str2=str.substr(0,rlen);
			obj.value=str2;
			fnChkByte(obj,maxByte);
		}else{
			document.getElementById('byteInfo').innerText = rbyte;
		}
		
	}
		
		function closeR(){
			window.close();	
		}
		
		
	</script>
</body>
</html>