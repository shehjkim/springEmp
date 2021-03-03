<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateEmp.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		//이메일 중복 체크
		$("#btnEmail").on("click", function() {
			var param = "email=" + $("[name=email]").val()

/*
			$.ajax({
				url : "/jsp/EmailCheck",
				data: param,		//서버에 보낼 파라미터
				success : function(response) {
					//span 태그에 출력
					$("#emailResult").append(response);
				}
			})
*/
			
//JSON			
/*			$.ajax({
				url : "/jsp/EmailCheck",
				data: param,		//서버에 보낼 파라미터
				dataType: "json",
				success : function(response) {
					//span 태그에 출력
					$("#emailResult").append(response.email);
					if(response.email == true){
						$("#emailResult").html("<font color='blue'>사용가능</font>");
						
					}else{
						$("#emailResult").html("<font color='red'>사용불가능</font>");

					}
				}
			})
*/
			
//XML			
			$.ajax({
				url : "/jsp/EmailCheck",
				data: param,		//서버에 보낼 파라미터
				//dataType: "xml", 	//데이터 타입은 안적어도 자동인식하지만 출력은 꼭 같은방식으로 해줘야함.
				success : function(response) {
					//span 태그에 출력
					$("#emailResult").html( $(response).find("email").text() );
					}
				})
			})

		});
</script>
</head>
<body>
<div><h1>사원정보수정</h1></div>
<form action="updateEmp" method="post" name="frm">
		employee_id <input type="number" name="employee_id" value="${empVO.employee_id }">
						<c:if test="${not empty empVO.employee_id}"></c:if><br>
		first_name <input name="first_name" value="${empVO.first_name }"><br> 
		last_name <input name="last_name" value="${empVO.last_name }"><br> 
		email <input type="email" name="email">
			<button type="button" id="btnEmail">중복체크</button>
			<span id="emailResult"></span><br> 
		phone_number<input type="text" name="phone_number" ><br>
		hire_date <input type="date" name="hire_date" value="${empVO.hire_date }"><br> 
		job_id
			<select name="job_id">
			<option value="AC_ACCOUNT">Accountion Manager</option>
			</select>
			<br>
		department_id 
			<input type="radio" name="department_id" value="10">기획
			<c:forEach items="${deptList }" var="dept">
			<input type="radio" name="department_id" value="${dept.department_id }"
				<c:if test="${dept.department_id == empVO.department_id }">checkde="checked"</c:if>>
				${dept.department_name }
			</c:forEach>
<%-- 		<br> manager_id <input type="text" name="manager_id" value="${empVO.manager_id }"> 
		
		<input
			type="text" name="name">
		<button type="button">사원검색</button>
		<br> --%>

		<button type="submit">등록</button>
		<button type="reset">초기화</button>
	</form>
</body>
</html>