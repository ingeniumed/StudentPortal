<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show All Students</title>
<style type="text/css">
      *{
             font-family: cursive;
       }
        </style>
</head>
<body bgcolor="#CDCDCC" font-family="cursive" font-size="20px;" >
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Student ID</th>
				<th>Name</th>
				<th>DOB</th>
				<th>Status</th>
				<th>CPI</th>
				<th colspan="2">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${students}" var="student">
				<tr>
					<td><c:out value="${student.serialId}" /></td>
					<td><c:out value="${student.studentId}" /></td>
					<td><c:out value="${student.name}" /></td>
					<td><c:out value="${student.dob}" /></td>
					<td><c:out value="${student.status}" /></td>
					<td><c:out value="${student.cpi}" /></td>
					<td><a
						href="StudentController.do?action=edit&serialId=<c:out value="${student.serialId }"/>">Update</a></td>
					<td><a
						href="StudentController.do?action=delete&serialId=<c:out value="${student.serialId }"/>">Delete</a></td>
					<td><a
						href="GradeController.do?action=listGrade&id=<c:out value="${student.studentId }"/>">Grades</a></td>
					<td><a
						href="GradeController.do?action=insert&id=<c:out value="${student.studentId }"/>">Add Grade</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>
		<a href="StudentController.do?action=insert">Add Student</a>
	</p>
</body>
</html>