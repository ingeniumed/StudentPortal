<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Add New Student</title>
<style type="text/css">
* {
	font-family: cursive;
}
</style>
<script type="text/javascript">
	function validate() {
		var numbers = /^[0-9](\.[0-9]{1,2})$/;
		if (document.frm.studentId.value == "") {
			alert("Student ID should not be left blank");
			document.frm.studentId.focus();
			return false;
		}
		if (document.frm.name.value == "") {
			alert("Name should not be left blank");
			document.frm.name.focus();
			return false;
		}
		if (document.frm.dob.value == "") {
			alert("Date of Birth should not be left blank");
			document.frm.dob.focus();
			return false;
		}
		if (document.frm.status.value == "") {
			alert("Status should not be left blank");
			document.frm.status.focus();
			return false;
		}
		if (document.frm.cpi.value == "") {
			alert("CPI should not be left blank");
			document.frm.cpi.focus();
			return false;
		}
		if (!document.frm.cpi.value.match(numbers)) {
			alert("CPI should be in the form of 0.00 only");
			document.frm.cpi.focus();
			return false;
		}
		return true;
	}
</script>
</head>
<body bgcolor="#CDCDCC" font-family="cursive" font-size="20px;">
	<form name ="frm" action="StudentController.do" method="post"
		onsubmit="return validate();">
		<fieldset>
			<div>
				<label for="serialId">Serial ID</label> <input type="text"
					name="serialId" value="<c:out value="${student.serialId}" />"
					readonly="readonly" placeholder="Serial ID" />
			</div>
			<div>
				<label for="studentId">Student ID</label> <input type="text"
					name="studentId" value="<c:out value="${student.studentId}" />"
					placeholder="Student ID" />
			</div>
			<div>
				<label for="name">Name</label> <input type="text" name="name"
					value="<c:out value="${student.name}" />" placeholder="Name" />
			</div>
			<div>
				<label for="dob">Date of Birth</label> <input type="text" name="dob"
					value="<c:out value="${student.dob}" />"
					placeholder="Date of Birth" />
			</div>
			<div>
				<label for="status">Status</label> <input type="text" name="status"
					value="<c:out value="${student.status}" />" placeholder="Status" />
			</div>
			<div>
				<label for="cpi">CPI</label> <input type="text" name="cpi"
					value="<c:out value="${student.cpi}" />" placeholder="CPI" />
			</div>
			<div>
				<input type="submit" value="Submit" />
			</div>
		</fieldset>
	</form>
</body>
</html>