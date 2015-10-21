package com.servlet.HRConsole;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.HRConsole.HRDao;

public class DivisionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String n = request.getParameter("divName");

		if (HRDao.addDivision(n)) {
			RequestDispatcher rd = request.getRequestDispatcher("/addDivision.jsp");
			out.print("<p style=\"color:red\">Division "+ n + " has been added</p>");
			rd.include(request, response);
		} else {
			out.print("<p style=\"color:red\">Invalid Division</p>");
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.include(request, response);
		}

		out.close();
	}
}
