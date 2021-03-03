<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세정보 / getEmp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#btnUpd").on("click",function(){
		location.href="updateEmp?employee_id=${emp.employee_id}"//href나 assign 두가지 모두 같음
		//location.assign(updateEmp?employee_id=${emp.employee_id});
		
	});
});	



</script>
</head>
<body>
<div align="center">
	사번: ${emp.employee_id }<br>
	이름: ${emp.first_name }<br>
	급여: ${emp.salary }<br>
	입사일: ${emp.hire_date }<br>
	이메일: ${emp.email }<br>
<button id="btnUpd">수정</button>
<a href="deleteEmp?employee_id=${emp.employee_id }">삭제</a>
<a href="getSearchEmp">목록으로</a>
</div>
</body>
</html>