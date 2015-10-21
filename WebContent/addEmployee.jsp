<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Add Employee</h3>
	<form action="EmployeeServlet" method="post">
		<table>
			<tr>
				<td>Name</td>
				<td><input type="text" name="empName" required="required" /></td>
			</tr>
			<tr>
				<td>Salary</td>
				<td><input type="text" name="empSalary" required="required" /></td>
			</tr>

			<tr>
				<td>Grade</td>
				<td><input type="text" name="empGrade" required="required" /></td>
			</tr>
			<tr>
				<tc>
				<td>Employee Type</td>
				</tc>
				<tc>
				<td><input type="radio" name="empType" value="permanent">Permanent</input></td>
				</tc>
				<tc>
				<td><input type="radio" name="empType" value="contractor">Contractor</input></td>
				</tc>
			</tr>
			<tr>
				<td>Department Id</td>
				<td><input type="text" name="empDepart" required="required" /></td>
			</tr>
			<tr>
				<td>Designation</td>
				<td><input type="text" name="empDesig" required="required" /></td>
			</tr>
			<div id="contractorRow">
				<tr>
					<td>Hourly Rate</td>
					<td><input type="text" name="hourlyRate" /></td>
					<td>Contract From Date</td>
					<td><input type="text" name="contFromDate" /></td>
					<td>Contract Thru Date</td>
					<td><input type="text" name="contThruDate" /></td>
				</tr>
			</div>
			<tr><tc>
				<td><input type="submit" name="addEmployee" value="Add" /></td></tc>
				<tc>
				<td><input type="submit" value="Main Menu"
					onclick="goToMainMenu()" /></td>
				</tc>
			</tr>
		</table>
		<script type="text/javascript">
			function goToMainMenu() {
				window.location = 'welcome.jsp';
			}
		</script>
	</form>
</body>

</script>
</html>