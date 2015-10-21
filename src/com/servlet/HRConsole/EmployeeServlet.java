package com.servlet.HRConsole;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.HRConsole.HRDao;
import com.domain.HRConsole.Employee;

public class EmployeeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String empName = request.getParameter("empName");
		String empSalary = request.getParameter("empSalary");
		String empGrade = request.getParameter("empGrade");
		String empType = request.getParameter("empType");
		String empDesig = request.getParameter("empDesig");
		String empDepart=request.getParameter("empDepart");
		String hourlyRate = request.getParameter("hourlyRate");
		String contFromDate = request.getParameter("contFromRate");
		String contThruDate = request.getParameter("contThruDate");
		
		Employee emp = new Employee();
		emp.setName(empName);
		emp.setSalary(Double.parseDouble(empSalary));
		emp.setGrade(empGrade);
		emp.setEmpType(empType);
		emp.setDesig(empDesig);
		emp.setDeptId(Integer.parseInt(empDepart));

		if (HRDao.addEmployee(emp)) {
			RequestDispatcher rd = request.getRequestDispatcher("/addEmployee.jsp");
			out.print("<p style=\"color:red\">Employee "+ empName + " has been added</p>");
			rd.include(request, response);
		} else {
			out.print("<p style=\"color:red\">Invalid Employee</p>");
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.include(request, response);
		}

		out.close();
	}
}
