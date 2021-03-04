<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>insertOrder</title>
</head>
<body>
	<form action="insertOrder" method="post">
		<table border="1">
			<tr>
				<td>이름</td>
				<td><input name="name" /></input></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input name="tel" /></input></td>
			</tr>
			<tr>
				<td>배송지</td>
				<td><input name="addr" /></input></td>
			</tr>
			<tr>
				<td><input name="ords[0].no" /></td>
				<td><input name="ords[0].cnt" /></input></td>
			</tr>
			<tr>
				<td><input name="ords[1].no" /></td>
				<td><input name="ords[1].cnt" /></input></td>
			</tr>
			<tr>
				<td><input name="ords[2].no" /></td>
				<td><input name="ords[2].cnt" /></input></td>
			</tr>

		</table>

		<button>주문하기</button>

	</form>
</body>
</html>