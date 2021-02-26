<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>employees.html</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	//이메일중복체크
	$(function(){
		$("#btnEmail").on("click", function(){
			var email = "email=" + $("[name=email]").val();
			$.ajax({
				url: "EmailCheck",
				data:email ,			//서버에 보낼 파라미터
				dataType:"xml",		// 넘어온 결과 타입 (json이면 json이라고 적고 xml이면 xml이라고 적음 html타입이면 적지않아도됨)
				success : function(data){	
					/*
					//json
					if(data.email == true){
						$("#emailResult").html("<font color='blue'>사용가능</font>");						
					}else{
						$("#emailResult").html("<font color='red'>사용불가능</font>");
					}*/
					//xml
					$("#emailResult").html($(data).find("email").text());
				}
			})
		})
	});
	document.addEventListener("DOMContentLoaded", function(){
		var mng = document.getElementById("btn");
		mng.onclick = function(){
			window.open("empSearch", "emp", "width=400, height=300, left=500, top=50");
		}
	});
</script>
</head>
<body>
<h3 id="top">사원등록</h3>

<c:set var="url" value="empInsert" />
<c:if test="${not empty empVO.employee_id }">
<c:set var="url" value="empUpdate" />
</c:if>
<form action="${url }" method="post" name="frm">
	employee_id <input type="number" name="employee_id"  value="${empVO.employee_id }"
				<c:if test="${not empty empVO.employee_id }">readonly="readonly"</c:if> ><br>
	first_name  <input name="first_name" value="${empVO.first_name }"><br>
	last_name   <input name="last_name"><br>
	email       <input type="email" id="email" name="email" value="${empVO.email}"><button type="button" id="btnEmail">중복체크</button>&nbsp;<span id="emailResult"></span><br>
	phone_number<input type="text" name="phone_number" id="btnEmail"><br>
	hire_date   <input type="date" name="hire_date"><br>
	job_id 		<select name="job_id"><c:forEach items="${jobList }" var="job">
				<option value="${job.jobId }" selected="selected">${job.jobTitle }</option>
	</c:forEach></select>   
	<br>
	department_id <c:forEach items="${deptList }" var = "dept">
					<input type="radio" id="department_id" name="department_id" value="${dept.departmentId }"
					<c:if test="${dept.departmentId == empVO.department_id }"> checked = "checked"</c:if> > ${dept.departmentName }
	</c:forEach>
				 <br>
	manager_id 
	<input type="text" name="manager_id">
	<input type="text" name="name">
	<button type="button" id="btn">사원검색</button><br>	

	<button type="submit">등록</button>
	<button type="reset">초기화</button>
</form>
</body>
</html>
