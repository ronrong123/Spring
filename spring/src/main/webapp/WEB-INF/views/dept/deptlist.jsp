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
<h3>부서목록</h3>
<c:forEach items="${list }" var="dept">
${dept.departmentId } ${dept.departmentName } ${dept.managerId } ${dept.locationId }
</c:forEach>
</body>
</html>