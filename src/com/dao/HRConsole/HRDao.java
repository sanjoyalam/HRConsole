package com.dao.HRConsole;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.domain.HRConsole.Employee;
import com.domain.HRConsole.LogRecord;

public class HRDao {
	public static boolean validateUser(String name, String pass) {
		boolean status = false;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			ConnectDB con = ConnectDB.getInstance();
			conn = con.getConnection();
			pst = conn.prepareStatement("select * from user where username=? and password=?");
			pst.setString(1, name);
			pst.setString(2, pass);

			rs = pst.executeQuery();
			status = rs.next();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return status;
	}

	public static boolean addDivision(String divName) {
		boolean status = false;
		Connection conn = null;
		PreparedStatement pst = null;
		int count = 0;

		try {
			ConnectDB con = ConnectDB.getInstance();
			conn = con.getConnection();
			pst = conn.prepareStatement("insert into division (divName) values (?)");
			pst.setString(1, divName);

			count = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		if (count > 0) {
			status = true;
		}
		return status;
	}
	
	public static boolean addEmployee(Employee emp) {
		boolean status = false;
		Connection conn = null;
		PreparedStatement pst = null;
		int count = 0;

		try {
			ConnectDB con = ConnectDB.getInstance();
			conn = con.getConnection();
			pst = conn.prepareStatement("insert into employee (empName,salary,gradeId,empType,departId,designation) values (?,?,?,?,?,?)");
			pst.setString(1, emp.getName());
			pst.setDouble(2, emp.getSalary());
			pst.setString(3, emp.getGrade());
			pst.setString(4, emp.getEmpType());
			pst.setInt(5, emp.getDeptId());
			pst.setString(6, emp.getDesig());

			count = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		if (count > 0) {
			status = true;
		}
		return status;
	}
	
	public static boolean addTimeLog(LogRecord logRecord) {
		boolean status = false;
		Connection conn = null;
		PreparedStatement pst = null;
		int count = 0;

		try {
			ConnectDB con = ConnectDB.getInstance();
			conn = con.getConnection();
			pst = conn.prepareStatement("insert into emp_logs (empId, logIn, logOut, logType) values (?,?,?,?)");
			pst.setInt(1, logRecord.getEmpId());
			pst.setDate(2, new Date(logRecord.getLogin().getTime()));
			pst.setDate(3, new Date(logRecord.getLogout().getTime()));
			pst.setString(4, logRecord.getLogType().toString());

			count = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		if (count > 0) {
			status = true;
		}
		return status;
	}
}
