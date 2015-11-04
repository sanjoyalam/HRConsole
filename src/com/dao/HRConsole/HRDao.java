package com.dao.HRConsole;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.domain.HRConsole.Contractor;
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
			pst = conn.prepareStatement(
					"insert into employee (empName,salary,gradeId,empType,departId,designation,address,city,state,zipcode) values (?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1, emp.getName());
			pst.setDouble(2, emp.getSalary());
			pst.setString(3, emp.getGrade());
			pst.setString(4, emp.getEmpType());
			pst.setInt(5, emp.getDeptId());
			pst.setString(6, emp.getDesig());
			pst.setString(7, emp.getAddress());
			pst.setString(8, emp.getCity());
			pst.setString(9, emp.getState());
			pst.setInt(10, emp.getZipcode());

			if (emp.getEmpType().equals("CONTRACTOR")) {
				Contractor cont = (Contractor) emp;
				pst = conn.prepareStatement(
						"insert into contractor (empId,hourly_rate, cont_from, cont_thru) values (?,?,?,?)");
				pst.setInt(1, cont.getEmpId());
				pst.setFloat(2, cont.getHourlyRate());
				pst.setDate(3, new Date(cont.getContFromDate().getTime()));
				pst.setDate(4, new Date(cont.getContThruDate().getTime()));
			}

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

	public static ArrayList<Employee> searchEmpByName(String empName) {
		boolean status = false;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int count = 0;
		ArrayList<Employee> empList = new ArrayList<Employee>();
		Employee emp;

		try {
			ConnectDB con = ConnectDB.getInstance();
			conn = con.getConnection();
			String sql = "select * from employee where empName like ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, "%" + empName + "%");
			rs = pst.executeQuery();

			try {
				while (rs.next()) {
					emp=new Employee();
					emp.setEmpId(rs.getInt(1));
					emp.setName(rs.getString(2));
					emp.setAddress(rs.getString(3));
					emp.setCity(rs.getString(4));
					emp.setState(rs.getString(5));
					emp.setZipcode(rs.getInt(6));
					emp.setDeptId(rs.getInt(7));
					emp.setSalary(rs.getDouble(8));
					emp.setGrade(rs.getString(9));
					emp.setEmpType(rs.getString(10));
					emp.setDesig(rs.getString(11));
					empList.add(emp);
				}
			} catch (Exception e) {
				System.out.println(e);
			}

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
	
		return empList;
	}

}
