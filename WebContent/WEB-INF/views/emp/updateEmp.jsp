<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<form:form modelAttribute="empVO" action="updateEmp" method="post" name="frm">
		employee_id <form:input path="employee_id" />
		first_name <form:input path="first_name" /><br> 
		last_name <form:input path="last_name" /><br> 
		email <form:input path="email" />
			<form:button type="button" id="btnEmail"></form:button>
			<span id="emailResult"></span><br> 
		phone_number<form:input type="text" path="phone_number" /><br>
		hire_date <form:input  type="date" path="hire_date" /><br> 
		department_id 
			<form:radiobuttons items="${deptList }" path="department_id" itemLabel="department_name" itemValue="department_id" />
		<br> 	
		 	job_id
			<form:select path="job_id">
				<option value="">선택</option>
				<form:options items="${jobList }" itemLabel="job_title" itemValue="job_id" />
			</form:select>
			<br> 
		manager_id 
		<form:input path="manager_id"/><input type="text" name="name">
		<button type="button" onclick="window.open('empSearch','emp',width=400, hight=500)" >사원검색</button>

		<button type="submit">등록</button>
		<button type="reset">초기화</button>
</form:form>
</body>
</html>