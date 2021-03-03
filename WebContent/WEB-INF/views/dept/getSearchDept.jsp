<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h1>부서목록</h1>
<c:forEach items="${list }" var="dept">
 부서번호:<a href="getDept?department_id=${dept.department_id}">${dept.department_id }</a>
/ 부서이름:${dept.department_name }
/ 팀장이름:${dept.last_name}(팀장번호:${dept.manager_id })
/ 지역:${dept.city }(지역번호:${dept.location_id })<br>
</c:forEach>
<a href="insertDept">부서등록</a>
</div>
</body>
</html>