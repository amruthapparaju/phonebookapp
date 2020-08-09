<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
 <script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
 <script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
 <script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
  <script language="JavaScript"  src="js"></script>

<meta charset="ISO-8859-1">
<title>Contact page</title>

<link href="css/style.css"
        rel="stylesheet">
 <script type="text/javascript">
  jQuery.validator.setDefaults({
   debug: true,
   success: "valid"
 });
 $( "#myform" ).validate({
   rules: {
     field: {
       required: true,
       step: 10
     }
   }
 });
 </script>

 
 
 </script>

</head>
<body>
	<c:if test="${not empty succMag}">
		<strong>${succMag}</strong>
	</c:if>
	<c:if test="${not empty errMag}">
		<strong>${errMag}</strong>
	</c:if>
    <script language="JavaScript"  src="js/validation.js"></script>

	<form:form action="login.htm"  method="post" modelAttribute="Contactcmd" id="myform"
		 onsubmit="return validate(this)">



		<table border="1">


			<form:input path="contactId" type="hidden" />

			<tr>
	
				<td>Contact Name</td>
				<td><form:input path="contactName" /> <form:errors
						path="contactName" /><span id="contactNameErr"></td>
			</tr>

			<tr>

				<td>Contact Email</td>
				<td><form:input path="contactEmail" /> <form:errors
						path="contactEmail" /><span id="emailErr"></td>
			</tr>
			<tr>

				<td>Contact Number</td>
				<td><form:input path="contactNumber" /> <form:errors
						path="contactNumber" /><span id="contactNumErr"></td>
			</tr>
			<tr>

				<td><input type="reset" value="reset"></td>
				<td><input type="submit" value="submit"></td>
			</tr>


		</table>


		<a href="viewContacts"> View Contacts</a>


	</form:form>




</body>
</html>