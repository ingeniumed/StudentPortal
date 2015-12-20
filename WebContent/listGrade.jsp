<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show All Grades</title>
<style type="text/css">
* {
	font-family: cursive;
}
</style>
</head>
<body bgcolor="#CDCDCC" font-family="cursive" font-size="20px;">
    <table>
        <thead>
            <tr>
                <th>Student ID</th>
                <th>Year</th>
                <th>GPI</th>
                <th>Year Result</th>
                <th>Subject1</th>
                <th>Subject2</th>
                <th>Subject3</th>
                <th>Subject4</th>
                <th>Subject5</th>
                <th colspan="2">Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${grades}" var="grade">
                <tr>
                    <td><c:out value="${grade.id}" /></td>
                    <td><c:out value="${grade.year}" /></td>
                    <td><c:out value="${grade.gpi}" /></td>
                    <td><c:out value="${grade.yearresult}" /></td>
                    <td><c:out value="${grade.subject1}" /></td>
                    <td><c:out value="${grade.subject2}" /></td>
                    <td><c:out value="${grade.subject3}" /></td>
                    <td><c:out value="${grade.subject4}" /></td>
                    <td><c:out value="${grade.subject5}" /></td>
                    <td><a
                        href="GradeController.do?action=edit&id=<c:out value="${grade.id}"/>&year=<c:out value="${grade.year}"/>">Update</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    	<p>
		<a href="StudentController?action=listStudent">Home</a>
	</p>
</body>
</html>