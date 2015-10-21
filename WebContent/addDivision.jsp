<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Division</title>
</head>
<body>
	<form action="DivisionServlet" method="post">
		<fieldset style="width: 400px">
			<table>
				<tc>
				<td>Division Name</td>
				<td><input type="text" name="divName" required="required" /></td>
				</tc>
				<tc>
				<td><input type="submit" value="Add" /></td>
				</tc>
				<tc>
				<td><input type="submit" value="Main Menu" onclick="goToMainMenu()" /></td>
				</tc>
			</table>

			<script type="text/javascript">
				function goToMainMenu() {
					window.location = 'welcome.jsp';
				}
			</script>
		</fieldset>
	</form>
</body>