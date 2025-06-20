<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Update Student</title>
	<link type="text/css" rel="stylesheet" href="css/style.css"/>
	<link type="text/css" rel="stylesheet" href="css/add-student-style.css"/>
</head>
<body>
<div id="wrapper">
	<div id="header">
		<h2>ABC School </h2>
	</div>
</div>
<div id="container">
	<h2>Update Student</h2>
	<form action="StudentControllerServlet" method="GET">
		<input type="hidden" value="UPDATE" name="command" />
		<input type="hidden" value="${student.id}" name="studentId" />
		<table>
			<tbody>
				<tr>
				 	<td><label> Name </label></td>
				 	<td><input type="text" name="name" value="${student.name }"/>
				</tr>
				<tr>
				 	<td><label> Email </label></td>
				 	<td><input type="text" name="email" value="${student.email }"/>
				</tr>
				<tr>
				 	<td><label> </label></td>
				 	<td><input type="submit" value="Update" class="save"/>
				</tr>
				
			</tbody>
		</table>
		
	</form>	
</div>
<div style="clear:both;">
	<a href="StudentControllerServlet">Back to list</a>
</div>

</body>
</html>