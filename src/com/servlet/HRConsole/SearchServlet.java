package com.servlet.HRConsole;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.HRConsole.HRDao;
import com.domain.HRConsole.Employee;

public class SearchServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ArrayList<Employee> empList = new ArrayList<Employee>();

		String searchBox = request.getParameter("searchBox");
		String searchParam = request.getParameter("searchParam");
		
		if(searchBox.equals("1"))
			empList=HRDao.searchEmpByName(searchParam);
			 request.setAttribute("empList", empList); 
		if ( HRDao.searchEmpByName(searchParam).size()>0) {
			RequestDispatcher rd = request.getRequestDispatcher("/search.jsp");
			rd.forward(request, response);
			
		} else {
			out.print("<p style=\"color:red\">No records found</p>");
			RequestDispatcher rd = request.getRequestDispatcher("/welcome.jsp");
			rd.include(request, response);
		}

		out.close();
	}
}
