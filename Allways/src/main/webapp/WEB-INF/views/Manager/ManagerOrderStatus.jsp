<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>주문현황</title>
<%@include file="managerHeader.jsp"%>
<link rel="stylesheet" href="css/Table22.css">
</head>
<body>
<script type="text/javascript">
	function Final(){
			RET.action = "MorderStatus.do";
			RET.method = "post";
			RET.submit();
			
			}
		
</script>
<hr/><h1>주문접수</h1><hr/>
<form name="orderList" method="post">
<table border="1" >
<thead>
		<tr>
			<th>주문번호</th>
			<th>주문상태</th>
			<th>구매자</th>
			<th>케이크번호</th>
			<th>케이크이름</th>
			<th>추가상품번호</th>
			<th>추가상품이름</th>
			<th>주문가격</th>
			<th>주문개수</th>
			<th>포인트가격</th>
			<th>제작선택</th>
			<th>주문취소</th>
		</tr>	
		</thead>
			<c:forEach items = "${dto}" var = "dto">
		<tr>
			<td>${dto.ordersId}</td>
			<td>${dto.ordersStatus}</td>
			<td>${dto.o_customerId}</td>
			<td>${dto.o_cakeId}</td>
			<td>${dto.cakeName}</td>
			<td>${dto.o_goodsId}</td>
			<td>${dto.goodsName}</td>
			<td>${dto.ordersSalePrice}</td>
			<td>${dto.ordersQuantity}</td>
			<td>${dto.ordersPoint}</td>
			<td><a href="ordersDetail?ordersId=${dto.ordersId}&ordersStatus=구매"><input type="button" value="선택"></a></td>
			<td><a href="deleteOrder?ordersId=${dto.ordersId}"><input type="button" value="취소"></a></td>
		</tr>
			</c:forEach>
			
</table>
</form>

<hr/><h1>제작중</h1>
<table border="1" >
<thead>
		<tr>
			<th>주문번호</th>
			<th>주문상태</th>
			<th>구매자</th>
			<th>케이크번호</th>
			<th>케이크이름</th>
			<th>추가상품번호</th>
			<th>추가상품이름</th>
			<th>주문가격</th>
			<th>주문개수</th>
			<th>포인트가격</th>
			<th>제작선택</th>
			<th>주문취소</th>
		</tr>	
		</thead>
			<c:forEach items = "${dto2}" var = "dto2">
		<tr>
			<td>${dto2.ordersId}</td>
			<td>${dto2.ordersStatus}</td>
			<td>${dto2.o_customerId}</td>
			<td>${dto2.o_cakeId}</td>
			<td>${dto2.cakeName}</td>
			<td>${dto2.o_goodsId}</td>
			<td>${dto2.goodsName}</td>
			<td>${dto2.ordersSalePrice}</td>
			<td>${dto2.ordersQuantity}</td>
			<td>${dto2.ordersPoint}</td>
			<td><a href="ordersDetail?ordersId=${dto2.ordersId}&ordersStatus=제작중"><input type="button" value="선택"></a></td>
			<td><a href="deleteOrder?ordersId=${dto2.ordersId}"><input type="button" value="취소"></a></td>
		</tr>
			</c:forEach>
			
</table>
<hr/><h1>제작완료</h1>
<div class="tablediv">
<table border="1" >
<thead>
		<tr>
			<th>주문번호</th>
			<th>주문상태</th>
			<th>구매자</th>
			<th>케이크번호</th>
			<th>케이크이름</th>
			<th>추가상품번호</th>
			<th>추가상품이름</th>
			<th>주문가격</th>
			<th>주문개수</th>
			<th>포인트가격</th>
			<th>제작선택</th>
		</tr>	
		</thead>
			<c:forEach items = "${dto3}" var = "dto3">
		<tr>
			<td>${dto3.ordersId}</td>
			<td>${dto3.ordersStatus}</td>
			<td>${dto3.o_customerId}</td>
			<td>${dto3.o_cakeId}</td>
			<td>${dto3.cakeName}</td>
			<td>${dto3.o_goodsId}</td>
			<td>${dto3.goodsName}</td>
			<td>${dto3.ordersSalePrice}</td>
			<td>${dto3.ordersQuantity}</td>
			<td>${dto3.ordersPoint}</td>
			<td><a href="ordersDetail?ordersId=${dto3.ordersId}"><input type="button" value="선택"></a></td>
		</tr>
			</c:forEach>
			<tr>
			</tr>
			
</table>
</div>
</body>
</html>