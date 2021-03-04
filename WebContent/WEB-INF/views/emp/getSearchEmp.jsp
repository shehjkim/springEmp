<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원목록 / getSearchEmp</title>

<script type="text/javascript">
	function goPage(p) {
		//location.href = "getSearchEmp?page=" + p;
		searchFrm.page.value=p;
		searchFrm.submit();
</script>

</head>

<body>
	<div align="center">
		<h1>사원목록</h1>
		<form action="getSearchEmp" name="searchFrm">
			<input type="hidden" name="page" value="1"> 
			부서 <input name="department_id" value="${empSearchVO.department_id }"> 
				직무 <input name="job_id" value="${empSearchVO.job_id }"> 
				이름 <input name="last_name" value="${empSearchVO.last_name }">
			<button>검색</button>
		</form>
		<br>
		<table border="1">
			<tr>
				<td>사원번호</td>
				<td>이름</td>
				<td>급여</td>
				<td>이메일</td>
				<td>직무번호</td>
				<td>입사일</td>
				<td>부서번호</td>
				<td>부서이름</td>
				<td>직무</td>
			</tr>
			<c:forEach items="${list }" var="emp">
				<tr>
					<td>${emp.employee_id }</td>
					<td><a href="getEmp?employee_id=${emp.employee_id}">${emp.last_name }</a></td>
					<td>${emp.salary }</td>
					<td>${emp.email }</td>
					<td>${emp.job_id }</td>
					<td>${emp.hire_date }</td>
					<td>${emp.department_id }</td>
					<td>${emp.department_name }</td>
					<td>${emp.job_title }</td>
				</tr>
			</c:forEach>
		</table>
		<my:paging paging="${paging}" jsFunc="goPage" />

	</div>
	<br>
	<hr>
	<br>
	<div align="center">
		<button type="button" onclick="location.href='insertEmp'">사원등록</button>
	</div>
</body>
</html>