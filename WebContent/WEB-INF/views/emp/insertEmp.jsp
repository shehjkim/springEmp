<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<div align="center"><h1>사원등록</h1>
<form action="insertEmp" method="post" name="frm">


		사원번호 <input type="number" name="employee_id" value="${empVO.employee_id }">
						<c:if test="${not empty empVO.employee_id}"></c:if><br>
		이름 <input name="last_name" value="${empVO.last_name }"><br> 
		이메일 <input type="email" name="email">
			<button type="button" id="btnEmail">중복체크</button>
			<span id="emailResult"></span><br> 
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