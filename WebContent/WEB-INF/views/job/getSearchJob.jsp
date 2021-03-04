<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직무목록</title>
</head>
<body>
	<div align="center">
		<h1>직무목록</h1>

		<table border="1">
			<tr>
				<th>직무번호</th>
				<th>직무이름</th>
				<th>최소급여</th>
				<th>최대급여</th>
			</tr>
			<c:forEach items="${list }" var="job">
				<tr>

					<td><a href="getJob?job_id=${job.job_id}">${job.job_id }</a></td>
					<td>${job.job_title }</td>
					<td>${job.min_salary}(팀장번호:${job.manager_id })</td>
					<td>${job.max_salary }(지역번호:${job.location_id })</td>

				</tr>
			</c:forEach>
		</table>

		<my:paging paging="${paging}" jsFunc="goPages" />
		<a href="insertJob">부서등록</a>
	</div>
</body>
</html>