<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">
<title>Contact Info</title>
</head>
<body class="p-3 mb-2 bg-light text-dark">
<div class="container">
	<h3><ins>Contact Info</ins></h3>
	<br> <b style="color: olive;">${succMsg}</b>
	        <b style="color: red;">${failMsg}</b>
	        <b style="color: fuchsia;">${updateSucc}</b>
	<form:form action="saveContact?contactId=${contact.contactId}" method="POST" modelAttribute="contact">

		<table>
<!-- 			<tr> -->
<%-- 				<td><form:hidden path="contactId" /></td> --%>
<!-- 			</tr> -->
			<tr>
				<td>Name :</td>
				<td><form:input path="contactName" /></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><form:input path="contactEmail" /></td>
			</tr>
			<tr>
				<td>Phno :</td>
				<td><form:input path="contactNo" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Submit" class="btn btn-primary"></td>
			</tr>
		</table>
	</form:form>
	<a href="view-contacts">View All Contacts</a>
	</div>
</body>
</html>