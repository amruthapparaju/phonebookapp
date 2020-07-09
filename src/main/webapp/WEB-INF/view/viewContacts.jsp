<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>

<script>
	$(document).ready(function() {
		$('#contactTbl').DataTable({
			"pagingType" : "full_numbers"
		});
	});
</script>

</head>

<body>
<script>
	function deleteConfirm(){
		return confirm("Are you sure, you want to delete?");
	}
</script>
<!-- <a href="login.htm"> Add new Contact</a>
 -->
 
 <a href="login.htm"  class="btn btn-primary btn-sm mb-3"> Add new Contact</a>

	<div id="container">
	
		<div id="content">

	<table border="1"  id="contactTbl">

		<thead>
			<tr>
				<th>S.NO</th>
				<th>Name</th>
				<th>EMAIL</th>
				<th>PHONE NUMBERR</th>
				<th>ACTION</th>

			</tr>

		</thead>

		<tbody>
			<c:forEach var="c" items="${contacts}" varStatus="index">
				<tr>
					<td>${index.count }</td>
					<td>${c.contactName }</td>
					<td>${c.contactEmail }</td>
					<td>${c.contactNumber }</td>
				
					
					<td><%-- <a href="editcontact/${c.contactId}">Edit</a> --%>
					<a href="editcontact?contactId=${c.contactId}" >Edit</a>|
					
<a href="deletecontact?contactId=${c.contactId}"  onclick="deleteConfirm()">Delete</a>
					
					</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>
			</div>
	
	</div>
	
</body>
</html>