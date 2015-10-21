package com.servlet.HRConsole;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("addEmp") != null) {
			RequestDispatcher rd = request.getRequestDispatcher("/addEmployee.jsp");
			rd.forward(request, response);
		} else if (request.getParameter("addTimeLog") != null) {
			RequestDispatcher rd = request.getRequestDispatcher("/addTimeLog.jsp");
			rd.forward(request, response);
		} else if(request.getParameter("addTimeLog") != null){
			RequestDispatcher rd = request.getRequestDispatcher("/addDivision.jsp");
			rd.forward(request, response);
		}
	}
}
