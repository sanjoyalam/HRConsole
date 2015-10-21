<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Division</title>
</head>
<body>
	<form action="TimeLogServlet" method="post">
		<fieldset style="width: 400px">
			<table>
				<tr>
				<td>Employee Id</td>
				<td><input type="text" name="empId" required="required" /></td>
				</tr>
				<tr><td>Log In</td>
				<td><input type="date" name="logIn" required="required" /></td>
				</tr>
				<tr><td>Log Out</td>
				<td><input type="date" name="logOut" required="required" /></td>
				</tr>
				<tr>
				<td>Log Type</td>
				<td><select name="logType">
						<option value="WORK_HOURS" selected>Work Hours</option>
						<option value="PTO_HOURS">Pto Hours</option>
						<option value="SICK_HOURS">Sick Hours</option>
				</select></td>
				</tr>
				<tr>
				<td><input type="submit" value="Add" /></td>
				<td><input type="submit" value="Main Menu"
					onclick="goToMainMenu()" /></td>
				<tr>
			</table>

			<script type="text/javascript">
				function goToMainMenu() {
					window.location = 'welcome.jsp';
				}
			</script>
		</fieldset>
	</form>
</body>