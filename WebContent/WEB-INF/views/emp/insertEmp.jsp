<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center"><h1>사원등록</h1>
<form action="updateEmp" method="post" name="frm">
		사원번호 <input type="number" name="employee_id" value="${empVO.employee_id }">
						<c:if test="${not empty empVO.employee_id}"></c:if><br>
		이름 <input name="first_name" value="${empVO.first_name }"><br> 
		이름 <input name="last_name" value="${empVO.last_name }"><br> 
		이메일 <input type="email" name="email">
			<button type="button" id="btnEmail">중복체크</button>
			<span id="emailResult"></span><br> 
		연락처 <input type="text" name="phone_number" ><br>
		입사일 <input type="date" name="hire_date" value="${empVO.hire_date }"><br> 
		직무
			<select name="job_id">
			<option value="AC_ACCOUNT">Accountion Manager</option>
			</select>
			<br>
		부서번호 
			<input type="radio" name="department_id" value="10">기획
	<br>
		<button type="submit">등록</button>
		<button type="reset">초기화</button>
	</form>
</div>
</body>
</html>