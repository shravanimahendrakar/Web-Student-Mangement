<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Student Info</title>
	<link type="text/css" rel="stylesheet" href="css/style.css"/>
</head>
<body>

<div id="wrapper">
	<div id="header">
		<h2>ABC School</h2>
	</div>
</div>

<div id="container">
	<div id="content">
	
	<input type="button" value="Add Student" onclick="window.location.href='addStudent.jsp';return false;"
		class="add-student-button" />
		<table border="1">
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Action</th>
		    </tr>
		   <c:forEach var="s" items="${list}"> 
			   	<c:url var="updateLink" value="StudentControllerServlet">
			   		<c:param name="command" value="LOAD"/>
			   		<c:param name="studentId" value="${s.id}" />
			   	</c:url>
			   	<c:url var="deleteLink" value="StudentControllerServlet">
			   		<c:param name="command" value="DELETE"/>
			   		<c:param name="studentId" value="${s.id}" />
			   	</c:url>
		    	<tr>
		    		<td>${s.name }</td>
		    		<td>${s.email}</td>
		    		<td><a href="${updateLink}">Update</a> | <a href="${deleteLink}" 
		    		onclick="if(!(confirm('Are you sure want to delete?'))) return false;">Delete</a></td>
		    	</tr>
		    
		   </c:forEach>
		</table>
	</div>
</div>

</body>
</html>