<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 
<title>Add New Grade</title>
<style type="text/css">
* {
	font-family: cursive;
}
</style>
<script type="text/javascript">
	function validate() {
		var numbers = /^[0-9](\.[0-9]{1,2})$/;
		var time = /^\b\d{4}\b$/;
		
		if (document.frm.year.value == "") {
			alert("Year should not be left blank");
			document.frm.year.focus();
			return false;
		}
		if (document.frm.gpi.value == "") {
			alert("GPI should not be left blank");
			document.frm.gpi.focus();
			return false;
		}
		if (document.frm.yearresult.value == "") {
			alert("Year Result should not be left blank");
			document.frm.yearresult.focus();
			return false;
		}
		if (document.frm.subject1.value == "") {
			alert("Subject 1 should not be left blank");
			document.frm.subject1.focus();
			return false;
		}
		if (document.frm.subject2.value == "") {
			alert("Subject 2 should not be left blank");
			document.frm.subject2.focus();
			return false;
		}
		if (document.frm.subject3.value == "") {
			alert("Subject 3 should not be left blank");
			document.frm.subject3.focus();
			return false;
		}
		if (document.frm.subject4.value == "") {
			alert("Subject 4 should not be left blank");
			document.frm.subject4.focus();
			return false;
		}
		if (document.frm.subject5.value == "") {
			alert("Subject 5 should not be left blank");
			document.frm.subject5.focus();
			return false;
		}
		
		if (!document.frm.gpi.value.match(numbers)) {
			alert("GPI should be in the form of 0.00 only");
			document.frm.gpi.focus();
			return false;
		}
		
		if (!document.frm.year.value.match(time)) {
			alert("Invalid Year entered!");
			document.frm.year.focus();
			return false;
		}
		return true;
	}
</script>
</head>
<body bgcolor="#CDCDCC" font-family="cursive" font-size="20px;">
    <form name ="frm" action="GradeController.do" method="post" onsubmit="return validate();">
        <fieldset>
            <div>
                <label for="id">Student ID</label> <input type="text"
                    name="id" value="<c:out value="${grade.id}" />"
                    placeholder="Student ID" />
            </div>
            <div>
                <label for="year">Year</label> <input type="text"
                    name="year" value="<c:out value="${grade.year}" />"
                    placeholder="Year" />
            </div>
            <div>
                <label for="gpi">GPI</label> <input type="text"
                    name="gpi" value="<c:out value="${grade.gpi}" />"
                    placeholder="GPI" />
            </div>
            <div>
                <label for="yearresult">Year Result</label> <input type="text" 
                    name="yearresult" value="<c:out value="${grade.yearresult}" />" 
                    placeholder="Year Result" />
            </div>
			<div>
				<label for="subject1">Subject 1</label> <input type="text"
					name="subject1" value="<c:out value="${grade.subject1}" />"
					placeholder="Subject 1" />
			</div>
			<div>
				<label for="subject2">Subject 2</label> <input type="text"
					name="subject2" value="<c:out value="${grade.subject2}" />"
					placeholder="Subject 2" />
			</div>
			<div>
				<label for="subject3">Subject 3</label> <input type="text"
					name="subject3" value="<c:out value="${grade.subject3}" />"
					placeholder="Subject 3" />
			</div>
			<div>
				<label for="subject4">Subject 1</label> <input type="text"
					name="subject4" value="<c:out value="${grade.subject4}" />"
					placeholder="Subject 4" />
			</div>
			<div>
				<label for="subject5">Subject 5</label> <input type="text"
					name="subject5" value="<c:out value="${grade.subject5}" />"
					placeholder="Subject 5" />
			</div>
			<div>
                <input type="submit" value="Submit" />
            </div>
        </fieldset>
    </form>
</body>
</html>