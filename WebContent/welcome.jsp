<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome <%=session.getAttribute("name")%></title>
</head>
<body>
	<h3>Login successful!!!</h3>
	<h4>
		Hello,
		<%=session.getAttribute("name")%></h4>
	<table>
		<tr>
			<tc>
			<td><input type="button" name="addEmployee" value="Add Employee"
				onclick="goToAddEmployeeJsp()" /></td>
			</tc>
			<tc>
			<td><input type="button" name="addTimeLog" value="Add Time Logs"
				onclick="goToAddTimeLogJsp()" /></td>
			</tc>
			<tc>
			<td><input type="button" name="addDivision" value="Add Division"
				onclick="goToAddDivisionJsp()" /></td>
			</tc>
		</tr>
	</table>
	</br>
	<form action="SearchServlet" method="post">
		<select name="searchBox">
			<option value=1>Search Employee by Name</option>
			<option value=2>Search Employee by Division</option>
			<option value=3>Search Employee by Division Name</option>
		</select> <input type="text" name="searchParam" /> <input type="submit"
			name="searchEmp" value="Search" />
	</form>

	
	<script type="text/javascript">
		function goToAddEmployeeJsp() {
			window.location = 'addEmployee.jsp';
		}

		function goToAddTimeLogJsp() {
			window.location = 'addTimeLog.jsp';
		}

		function goToAddDivisionJsp() {
			window.location = 'addDivision.jsp';
		}
	</script>
</body>
</html>
