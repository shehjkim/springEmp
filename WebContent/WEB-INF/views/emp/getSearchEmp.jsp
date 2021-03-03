<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원목록 / getSearchEmp</title>
</head>
<body>
<div align="center">
<h1>사원목록</h1>
<c:forEach items="${list }" var="emp">
	사원번호: ${emp.employee_id } 
	/ 이름:<a href="getEmp?employee_id=${emp.employee_id}">${emp.first_name }</a>
	/ 급여:  ${emp.salary }
	/ 직무:  ${emp.job_id }
	/ 입사일: ${emp.hire_date }
	/ 부서번호: ${emp.department_id }
	/ 부서이름: ${emp.department_name }
	/ 직무명: ${emp.job_title }
	<br>
</c:forEach>
</div>
<br>
<hr>
<br>
<div align="center">
<button type="button" onclick="location.href='insertEmp'">사원등록</button>
</div>
</body>
</html>