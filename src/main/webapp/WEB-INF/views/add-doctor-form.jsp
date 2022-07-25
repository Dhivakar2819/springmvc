<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Doctor</title>
</head>
<body>
<div id="root">
		<div id="form">
			<form:form action="add" method="post" modelAttribute="adddoctor">
				<div>
					<label for="doc_id">Doctor id</label>
					<div>
						<form:input path="doc_id" />
					</div>
				</div>
				<div>
					<label for="doc_name">Doctor Name</label>
					<div>
						<form:input path="doc_name" />
					</div>
				</div>
				<div>
					<label for="dob">Date of Birth</label>
					<div>
						<form:input path="dob" />
					</div>
				</div>
				<div>
					<label for="speciality">Speciality</label>
					<div>
						<form:input path="speciality" />
					</div>
				</div>
				<div>
					<label for="city">City</label>
					<div>
						<form:input path="city" />
					</div>
				</div>
				<div>
					<label for="phone_no">Phone No</label>
					<div>
						<form:input path="phone_no" />
					</div>
				</div>
				<div>
					<label for="fees">Fees</label>
					<div>
						<form:input path="fees" />
					</div>
				</div>
				<div>
					<form:button>Add New</form:button>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>