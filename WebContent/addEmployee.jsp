<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*"%>
<%@ page import="com.dao.HRConsole.ConnectDB"%>
<%
	ResultSet resultset = null;
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">

<script src="//code.jquery.com/jquery-1.10.2.js"></script>

<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

<link rel="stylesheet" href="/resources/demos/style.css">

<script>
	$(function() {

		$("#contFromDate").datepicker();

	});

	$(function() {

		$("#contThruDate").datepicker();

	});
</script>

</head>
<body>
	<h3>Add Employee</h3>
	<form action="EmployeeServlet" method="post">
		<table id="empTbl">
			<tr>
				<td>Name</td>
				<td><input type="text" name="empName" required="required" /></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="empAddress" required="required" /></td>
			</tr>
			<tr>
				<td>City</td>
				<td><input type="text" name="empCity" required="required" /></td>
			</tr>
			<tr>
				<td>State</td>
				<td><input type="text" name="empState" required="required" /></td>
			</tr>
			<tr>
				<td>Zip Code</td>
				<td><input type="text" name="empZipcode" required="required" /></td>
			</tr>
			<tr>
				<%
					try {
						Connection conn = null;
						ConnectDB con = ConnectDB.getInstance();
						conn = con.getConnection();

						Statement statement = conn.createStatement();

						resultset = statement.executeQuery("select * from division");
				%>
				<td>Division</td>
				<td><select name="empDivision">
						<%
							while (resultset.next()) {
						%>
						<option value=<%=resultset.getString(1)%>>
							<%=resultset.getString(2)%></option>
						<%
							}
						%>
				</td>
				</select>
				<%
					} catch (Exception e) {
						out.println("wrong entry" + e);
					}
				%>
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
				<td><input type="radio" name="empType" id="permanent" value="PERMANENT"
					onclick="ShowHideDiv()" checked>Permanent </input></td>
				<td><input type="radio" name="empType" id="contractor" value="CONTRACTOR"
					onclick="ShowHideDiv()">Contractor </input></td>
			</tr>
			<tr>
				<td>Designation</td>
				<td><input type="text" name="empDesig" required="required" /></td>
			</tr>
			<tr id="contractorRow" style="visibility:hidden;">
				<td>Hourly Rate</td>
				<td><input type="text" name="hourlyRate" /></td>
				<td>Contract From Date</td>
				<td><input type="text" id="contFromDate" name="contFromDate" /></td>
				<td>Contract Thru Date</td>
				<td><input type="text" id="contThruDate" name="contThruDate" /></td>
			</tr>
			<tr>
				<td><input type="submit" name="addEmployee" value="Add" /></td>
				<td><input type="button" value="Main Menu"
					onclick="goToMainMenu()" /></td>
			</tr>
		</table>
		<script type="text/javascript">
			function goToMainMenu() {
				window.location = 'welcome.jsp';
			}

			function ShowHideDiv() {

				var permanent = document.getElementById("permanent");

				var divContractor = document.getElementById("contractorRow");

				divContractor.style.visibility = permanent.checked ? "hidden"
						: "visible";

			}
		</script>
	</form>
</body>

</script>
</html>