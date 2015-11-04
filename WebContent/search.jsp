<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.domain.HRConsole.Employee"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form name="searchRecord">

		<%
			ArrayList<Employee> aList = (ArrayList<Employee>) request.getAttribute("empList");
			int count = 0;
		%>
		<p><%=aList.size()%>
			records match the search
		</p>
		<table BORDER="1">
			<tr>
				<tc>
				<TH>ID</TH>
				</tc>
				<tc>
				<TH>Name</TH>
				</tc>
				<tc>
				<TH>Address</TH>
				</tc>
				<tc>
				<TH>City</TH>
				</tc>
				<tc>
				<TH>State</TH>
				</tc>
				<tc>
				<TH>Zip Code</TH>
				</tc>
			</tr>
			<%
				while (count < aList.size()) {
			%>
			<tr>
				<td> <input type="text" name="id"
					value="<%=aList.get(count).getEmpId()%>"></td>
				<td> <input type="text" name="name"
					value="<%=aList.get(count).getName()%>"></td>
				<td> <input type="text" name="address"
					value="<%=aList.get(count).getAddress()%>"></td>
				<td> <input type="text" name="city"
					value="<%=aList.get(count).getCity()%>"></td>
					<td> <input type="text" name="state"
					value="<%=aList.get(count).getState()%>"></td>
				<td> <input type="text" name="zipcode"
					value="<%=aList.get(count).getZipcode()%>"></td>
			</tr>
			<%
				count++;
				}
			%>
		</table>
	</form>
</body>
</html>