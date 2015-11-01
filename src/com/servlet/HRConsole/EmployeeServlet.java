package com.servlet.HRConsole;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.el.parser.ParseException;

import com.dao.HRConsole.HRDao;
import com.domain.HRConsole.Contractor;
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
		String empAddress = request.getParameter("empAddress");
		String empCity = request.getParameter("empCity");
		String empState = request.getParameter("empState");
		String empZipcode = request.getParameter("empZipcode");
		String empDivision = request.getParameter("empDivision");
		String hourlyRate = request.getParameter("hourlyRate");
		String contFromDate = request.getParameter("contFromDate");
		String contThruDate = request.getParameter("contThruDate");

		Employee emp;
		Contractor cont;
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
		if (empType.equals("PERMANENT")) {
			emp = new Employee();
			emp.setName(empName);
			emp.setSalary(Double.parseDouble(empSalary));
			emp.setGrade(empGrade);
			emp.setEmpType(empType);
			emp.setDesig(empDesig);
			emp.setDeptId(Integer.parseInt(empDivision));
			emp.setAddress(empAddress);
			emp.setCity(empAddress);
			emp.setState(empAddress);
			emp.setZipcode(Integer.parseInt(empZipcode));
		} else {
			cont = new Contractor();
			cont.setName(empName);
			cont.setSalary(Double.parseDouble(empSalary));
			cont.setGrade(empGrade);
			cont.setEmpType(empType);
			cont.setDesig(empDesig);
			cont.setDeptId(Integer.parseInt(empDivision));
			cont.setAddress(empAddress);
			cont.setCity(empAddress);
			cont.setState(empAddress);
			cont.setZipcode(Integer.parseInt(empZipcode));
			cont.setHourlyRate(Float.parseFloat(hourlyRate));
			try {
				cont.setContFromDate(new java.sql.Date(dateFormat.parse(contFromDate).getTime()));
				cont.setContThruDate(new java.sql.Date(dateFormat.parse(contThruDate).getTime()));
			} catch (java.text.ParseException e) {
				System.out.println(e.getMessage());
			}

			emp = cont;
		}

		if (HRDao.addEmployee(emp)) {
			RequestDispatcher rd = request.getRequestDispatcher("/addEmployee.jsp");
			out.print("<p style=\"color:red\">Employee " + empName + " has been added</p>");
			rd.include(request, response);
		} else {
			out.print("<p style=\"color:red\">Invalid Employee</p>");
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.include(request, response);
		}

		out.close();
	}
}
