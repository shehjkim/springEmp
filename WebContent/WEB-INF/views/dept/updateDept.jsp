<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h1>부서정보수정</h1>

<form action="updateDept" method="post" name="frm">
부서번호: <input id="department_id" name="department_name" value="${deptVO.department_id }" readonly="readonly"><br>
부서이름: <input id="deptName" name="deptName" value="${deptVO.department_name }" readonly="readonly"><br>
팀장: <input id="deptManager" name="deptManager"><br>
지역: <input id="deptLocation" name="deptLocation"><br>

<button type="submit">등록</button>
<button type="reset">초기화</button>
</form>
</div>
</body>
</html>