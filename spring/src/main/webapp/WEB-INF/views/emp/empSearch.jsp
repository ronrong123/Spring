<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function(){
	$(".btnSelect").on("click", function(){
		var empid = $(this).closest("tr").find("td").first().text();
		var firstName = $(this).closest("tr").find("td").eq(1).text();
		opener.document.frm.manager_id.value= empid;
		opener.document.frm.name.value= firstName;
		//opener : 부모창
		window.close();
	});
});
</script>
</head>
<body>
<h2>사원검색</h2>
<hr>
<table>
<c:forEach items="${list }" var="emp">
<tr>
	<td>${emp.employee_id }</td>
	<td>${emp.first_name}</td>
	<td>${emp.department_id }</td>
	<td><button type="button" class="btnSelect">선택</button></td>
</tr>
</c:forEach>
</table>
</body>
</html>