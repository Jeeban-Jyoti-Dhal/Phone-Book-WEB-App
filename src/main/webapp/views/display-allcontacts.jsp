<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">
<title>Insert title here</title>

<script type="text/javascript">
	function confirmDelete() {
		return confirm("Are you sure,to delete ?");
	}
</script>
</head>
<body class="p-3 mb-2 bg-secondary text-white">
	<h3 align="center">All Contacts</h3>
	<hr>
	<div class="container">
		<a href="load-form" class="btn btn-danger">+Add New Contact</a>
		<b style="color: yellow;">${deletesucc}</b>
		<b style="color: red;">${deletefail}</b>
		<table class="table table-success table-striped">
			<thead>
				<tr>
					<th>Contact ID</th>
					<th>Contact Name</th>
					<th>Contact Email</th>
					<th>Contact NO</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${contacts}" var="contact">
					<tr>
						<td>${contact.contactId}</td>
						<td>${contact.contactName}</td>
						<td>${contact.contactNo}</td>
						<td>${contact.contactEmail}</td>
						<td><a href="edit?cid=${contact.contactId}">Edit</a> <a
							href="delete?cid=${contact.contactId}"
							onclick="return confirmDelete()">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>