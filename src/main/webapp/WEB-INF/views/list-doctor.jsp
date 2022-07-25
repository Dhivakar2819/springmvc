<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor List</title>
</head>
<body>
	<div id="table root">
		<table>
			<thead>
				<tr>
					<th>Doctor Id</th>
					<th>Doctor Name</th>
					<th>Date of Birth</th>
					<th>Speciality</th>
					<th>City</th>
					<th>Phone No</th>
					<th>Fees</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="Doctor" items="${allDoctors}">
					<tr>
						<td>${Doctor.doc_id}</td>
						<td>${Doctor.doc_name}</td>
						<td>${Doctor.dob}</td>
						<td>${Doctor.speciality}</td>
						<td>${Doctor.city}</td>
						<td>${Doctor.phone_no}</td>
						<td>${Doctor.fees}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>