<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="managerstyle.css">
<link rel="stylesheet" href="/css/Table22.css">
<link rel="shortcut icon" href="/image/HeaderLogo2.png" sizes="180x180">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<style>
div{
	padding:1%;
}

input[type=file]::file-selector-button{
	background-color:#ffffff;
	border-color:#fdcdcd;
	border-radius:10px;
	hover:{
		background:#fdcdcd;
	}
}

</style>
</head>
<body>
<%@include file="managerHeader.jsp"%>
<script type="text/javascript">
function Return(){
		var upd = document.upd;
		upd.action="cakeOption";
		upd.submit();
		upd.method = "post";
		}
function Update(){
		var upd = document.upd;
		var Cek = upd.ko.value;
		console.log(Cek);
		if(Cek == 1){
			upd.action="cakeoptionUpdate";
			upd.method = "post";
			swal("수정이 완료되었습니다",'','success');
			upd.submit();
			return;
		}else if(Cek == 2){
			swal("사용 불가능한 아이디 입니다.",'','warning');
			return;
		}else{
			swal("중복체크해주세요",'','warning');
			return;
		}
}
function Delete(){
		var upd = document.upd;
		upd.action="deleteOption";
		swal("삭제가 완료되었습니다",'','success');
		upd.submit();
		upd.method = "post";
		}
function CHECKOPTION(){
		var upd = document.upd;
		upd.action="checkoptionName2";
		upd.method = "post";
		upd.submit();

}
function previewFile() {
	  var preview = document.querySelector('img#preview');
	  var file = document.querySelector('input[type=file]').files[0];
	  var reader = new FileReader();

	  reader.addEventListener(
	    'load',
	    function () {
	      preview.src = reader.result;
	    },
	    false
	  );

	  if (file) {
	    reader.readAsDataURL(file);
	  }
	}
</script>


	
	<div align="center">
		<form method="post"  enctype="multipart/form-data" name ="upd">
		<h1 align="center">옵션 관리</h1>
		<div style="display: inline-block;width:60%">
		<div align="left" style="width:20%;display:inline-block">	
			카테고리 :
		</div>
		<div align="left" style="width:74%;display:inline-block">
			<div style="width:50%;display:inline-block">
				<select name="cakeoptionCategory"  style="background:#ffffff;border-color:#a87878;color:#a87878">
					<option value="size">size</option>
					<option value="IcingColor">IcingColor</option>
					<option value="BorderColor">BorderColor</option>
					<option value="Flavor">Flavor</option>
					<option value="MassageColor">MassageColor</option>
					<option value="Box">Box</option>
				</select>
			</div>
		</div>
		<div align="left" style="width:20%;display:inline-block">
			CAKE ID :
		</div>
		<div align="left" style="width:74%;height:20%;display:inline-block">
			<div style="width:50%;display:inline-block">
				<input type="text" style="border-color:#FDCDCD" size="30" name="cakeoptionId" value="${dto.cakeoptionId}" readonly/>
			</div>
		</div>
		<div align="left" style="width:20%;display:inline-block">
			옵션 이름 :
		</div>
			<div align="left" style="width:74%;height:20%;display:inline-block">
				<c:if test="${check == null }">
					<input type="hidden" name="ko" value="0"/>
					<input type="text" style="border-color:#FDCDCD" size="30" name="cakeoptionValue" value="${dto.cakeoptionValue}" ></c:if>
				<c:if test="${check == true }">
					<input type="hidden" name="ko" value="2"/>
					<input type="text" style="border-color:#FDCDCD" size="30" name="cakeoptionValue" value="${dto.cakeoptionValue}" >
				<br>
				<span style = " font-size:1.0em;  color: red;"> 사용 불가능한 이름 입니다</span></c:if>
				<c:if test="${check == false }">
				<input type="hidden" name="ko" value="1"/>
				<input type="text" style="border-color:#FDCDCD" size="30" name="cakeoptionValue" value="${dto.cakeoptionValue}" >
		 		<br>
		 		<span style = " font-size:1.0em;  color: blue;"> 사용 가능한 이름 입니다</span></c:if>
			</div>
		<div align="left" style="width:20%;display:inline-block">
			가격 이름 :
		</div>
			<div align="left" style="width:74%;height:20%;display:inline-block">
				<input type="text" style="border-color:#FDCDCD" name="cakeoptionPrice" value="${dto.cakeoptionPrice}" >
			</div>
			<div align="left" style="width:20%;display:inline-block">
				사진
			</div>
			<div align="left" style="width:74%;display:inline-block">
				<input type="file" name="optionImage" onchange="previewFile(event)">
			</div>
		</div>
		<div style="display:inline-block;width:30%;height:50%" align="center">
		<div>
			사진 미리보기
		</div>
		<div>
		<c:if test="${check == null }"> 
		<img src="/Allways/${dto.cakeoptionImage}" id="preview" height="200" width="200" style="display:block;margin:20px;border-radius:10px;">
			<input type="hidden" name="cakeoptionImage2" value="${dto.cakeoptionImage}">
		</c:if>
		<c:if test="${check == true }"> 
		<img src="/Allways/${dto.cakeoptionImage}" id="preview" height="200" width="200" style="display:block;margin:20px;border-radius:10px;">
			<input type="hidden" name="cakeoptionImage2" value="${cakeoptionImage}">
		</c:if>
		<c:if test="${check == false }"> 
		<img src="/Allways/${cakeoptionImage}" id="preview" height="200" width="200" style="display:block;margin:20px;border-radius:10px;">
			<input type="hidden" name="cakeoptionImage2" value="${dto.cakeoptionImage}">	
		</c:if>
		</div>
		<div align="center" style="width:74%;display:inline-block">
			<input type="button" style="background:#ffffff;border-color:#a87878;color:#a87878" value="돌아가기" onclick="Return()">
			<input type="button" style="background:#ffffff;border-color:#a87878;color:#a87878" value="중복체크" onclick="CHECKOPTION()">
			<input type="button" style="background:#ffffff;border-color:#a87878;color:#a87878" value="수정" onclick="Update()">
			<input type="button" style="background:#ffffff;border-color:#a87878;color:#a87878" value="삭제" onclick="Delete()">
		</div>
	</div>
		
	</form>
	</div>
		

</body>
</html>