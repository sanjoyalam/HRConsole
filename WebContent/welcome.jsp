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
				<td><input type="submit" name="addEmployee"
					value="Add Employee" onclick = "goToAddEmployeeJsp()"/></td>
				</tc>
				<tc>
				<td><input type="submit" name="addTimeLog"
					value="Add Time Logs" onclick="goToAddTimeLogJsp()"/></td>
				</tc>
				<tc>
				<td><input type="submit" name="addDivision"
					value="Add Division" onclick="goToAddDivisionJsp()"/></td>
				</tc>
			</tr>
		</table>

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
