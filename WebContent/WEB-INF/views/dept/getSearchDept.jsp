<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서목록</title>
<script type="text/javascript">
	function goPages(p) {
		location.href = "getSearchDept?page=" + p;
	}
</script>

</head>
<body>
	<div align="center">
		<h1>부서목록</h1>

		<table border="1">
			<tr>
				<th>부서번호</th>
				<th>부서이름</th>
				<th>매니저</th>
				<th>지역</th>
			</tr>
			<c:forEach items="${list }" var="dept">
				<tr>

					<td><a href="getDept?department_id=${dept.department_id}">${dept.department_id }</a></td>
					<td>${dept.department_name }</td>
					<td>${dept.last_name}(팀장번호:${dept.manager_id })</td>
					<td>${dept.city }(지역번호:${dept.location_id })</td>

				</tr>
			</c:forEach>
		</table>

		<my:paging paging="${paging}" jsFunc="goPages" />
		<a href="insertDept">부서등록</a>
	</div>
</body>
</html>