package com.servlet.HRConsole;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.HRConsole.HRDao;
import com.domain.HRConsole.LogRecord;
import com.domain.HRConsole.LogType;

public class TimeLogServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String empId = request.getParameter("empId");
		String logIn = request.getParameter("logIn");
		String logOut = request.getParameter("logOut");
		String logType = request.getParameter("logType");

		LogRecord logRecord = new LogRecord();
		logRecord.setEmpId(Integer.parseInt(empId));
		logRecord.setLogin(new java.sql.Date(Long.parseLong(logIn)));
		logRecord.setLogout(new java.sql.Date(Long.parseLong(logOut)));
		
		if(logType.equals("WORK_HOURS"))
			logRecord.setLogType(LogType.WORK_HOURS);
		else if(logType.equals("PTO_HOURS"))
			logRecord.setLogType(LogType.PTO_HOURS);
		else if(logType.equals("SICK_HOURS"))
			logRecord.setLogType(LogType.SICK_HOURS);
		
		if (HRDao.addTimeLog(logRecord)) {
			RequestDispatcher rd = request.getRequestDispatcher("/addTimeLog.jsp");
			out.print("<p style=\"color:red\">TimeLog " + logRecord + " has been added</p>");
			rd.include(request, response);
		} else {
			out.print("<p style=\"color:red\">Invalid Timelog</p>");
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.include(request, response);
		}

		out.close();
	}
}
