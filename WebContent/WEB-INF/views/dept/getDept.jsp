<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서상세정보</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#btnUpd").on("click",function(){
		location.href="updateDept?department_id=${dept.department_id}"//href나 assign 두가지 모두 같음
		
	});
});	

</script>
</head>
<body>
<div align="center">
 부서번호:${dept.department_id }
/ 부서이름:${dept.department_name }
/ 팀장:${dept.manager_id }
/ 지역:${dept.location_id }<br>
<br>
<button id="btnUpd">수정</button>
<a href="deleteDept?department_id=${dept.department_id }">삭제</a>
<a href="getSearchDept">목록으로</a>
</div>
</body>
</html>