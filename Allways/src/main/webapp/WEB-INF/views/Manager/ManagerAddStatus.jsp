<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="managerHeader.jsp"%>
<title>Insert title here</title>
<link rel="stylesheet" href="css/Table22.css">

<script>

	function Return(){
		var RET = document.ADDR;
		RET.action = "orders";
		RET.method = "post";
		RET.submit();
	}

		function Delete2() {
			var DEL = document.ADDR;
			DEL.action = "DeleteOrder.do";
			DEL.method = "post";
			DEL.submit();
		}
	</script>
</head>
<body>
<h1>주문 상태 변환</h1>
	<form method="post" action="alterStatus" name = "ADDR">
	<table border="0">
<thead>
	<tr>
	<td>
	<tr>
		<th>주문 번호 :
		<input type="text" name=ordersId value="${dto.ordersId}" readonly/>
		</th>
	</tr>
	
	<tr>
		<th>
	주문 상태 :
	<input type="text" name="ordersStatus" value="${dto.ordersStatus }" readonly="readonly"></th>
	</tr>
	<tr>
		<th>구매자 :
		<input type="text" name="o_customerId" value="${dto.o_customerId}" readonly="readonly" >
		</th>
	</tr>
	
	<tr>
		<th>케이크번호 :
		<input type="text" name="o_cakeId" value="${dto.o_cakeId}" readonly="readonly">
		</th>
	</tr>
	<tr>
		<th>케이크이름 :
		<input type="text" name="cakeName" value="${dto.cakeName}" readonly="readonly">
		</th>
	</tr>
	
	<tr>
		<th>추가상품번호:
		<input type="text" name="o_goodsId" value="${dto.o_goodsId}" readonly="readonly">
		</th>
	</tr>
	<tr>
		<th>추가상품이름:
		<input type="text" name="goodsName" value="${dto.goodsName}" readonly="readonly">
		</th>
	</tr>
	
	<tr>
		<th>주문가격 :
		<input type="text" name="ordersSalePrice" value="${dto.ordersSalePrice}" readonly="readonly">
		</th>
	</tr>
	<tr>
		<th>주문개수 :
		<input type="text" name="ordersQuantity" value="${dto.ordersQuantity}" readonly="readonly">
		</th>
	</tr>
	<tr>
		<th>포인트 :
		<input type="text" name="ordersPoint" value="${dto.ordersPoint}" readonly="readonly">
		</th>
	</tr>
	<tr>
		<th>
			<input type="button" value="돌아가기" onclick="Return()">
			<input type="button" value="삭제" onclick="Delete()">
			<input type="submit" value="추가">
		</th>
	</tr>
	</table>
		
	</form>
</body>
</html>