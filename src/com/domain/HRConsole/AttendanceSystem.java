package com.domain.HRConsole;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AttendanceSystem {

	private HashMap<Employee, Attendance> employeeAttendance;
	
	public static AttendanceSystem getAttendanceSystem() {
		return attendanceSystem;
	}

	public static void setAttendanceSystem(AttendanceSystem attendanceSystem) {
		AttendanceSystem.attendanceSystem = attendanceSystem;
	}

	private static AttendanceSystem attendanceSystem;
	
	private AttendanceSystem(){
        employeeAttendance = new HashMap<Employee, Attendance>();   
    }

    public static AttendanceSystem getInstance(){
       if(attendanceSystem == null){
    	   attendanceSystem = new AttendanceSystem();
       }
       return attendanceSystem;
    }

	public HashMap<Employee, Attendance> getEmployeeAttendance() {
		return employeeAttendance;
	}

	public void setEmployeeAttendance(HashMap<Employee, Attendance> employeeAttendance) {
		this.employeeAttendance = employeeAttendance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employeeAttendance == null) ? 0 : employeeAttendance.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AttendanceSystem other = (AttendanceSystem) obj;
		if (employeeAttendance == null) {
			if (other.employeeAttendance != null)
				return false;
		} else if (!employeeAttendance.equals(other.employeeAttendance))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AttendanceSystem [employeeAttendance=" + employeeAttendance + "]";
	}

	public List<LogRecord> GetAttendanceDetailByDate(Date attendanceDate) {
		List<LogRecord> logRecords = new LinkedList<LogRecord>();
		Iterator it = employeeAttendance.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Employee, Attendance> pair = (Map.Entry) it.next();
			List<LogRecord> empAttd = pair.getValue().getLogRecords();
			for (int i = 0; i < empAttd.size(); i++) {
				if (empAttd.get(i).getLogin().getDay() == attendanceDate.getDay() &&
						empAttd.get(i).getLogin().getMonth() == attendanceDate.getMonth() &&
						empAttd.get(i).getLogin().getYear() == attendanceDate.getYear()) {
					logRecords.add(empAttd.get(i));
				}
			}
		}
		return logRecords;
	}

	public List<LogRecord> GetAttendanceForEmployee(int employeeId, Date startDate, Date endDate) {
		List<LogRecord> logRecords = new LinkedList<LogRecord>();
		Iterator it = employeeAttendance.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Employee, Attendance> pair = (Map.Entry) it.next();
			if (pair.getKey().empId == employeeId) {
				List<LogRecord> empAttd = pair.getValue().getLogRecords();
				for (int i = 0; i < empAttd.size(); i++) {
					
					if (empAttd.get(i).getLogin().after(startDate)
							&& empAttd.get(i).getLogin().before(endDate)) {
						logRecords.add(empAttd.get(i));
					}
				}
			}
		}
		return logRecords;
	}

	public List<LogRecord> GetAttendanceForDepartment(int departmentId, Date startDate, Date endDate) {
		List<LogRecord> logRecords = new LinkedList<LogRecord>();
		Iterator it = employeeAttendance.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Employee, Attendance> pair = (Map.Entry) it.next();
			if (pair.getKey().getDeptId() == departmentId) {
				List<LogRecord> empAttd = pair.getValue().getLogRecords();
				for (int i = 0; i < empAttd.size(); i++) {
					if (empAttd.get(i).getLogin().after(startDate)
							&& empAttd.get(i).getLogin().before(endDate)) {
						logRecords.add(empAttd.get(i));
					}
				}
			}
		}
		return logRecords;
	}

	public List<LogRecord> GetEmployeesOnVacation(Date startDate, Date endDate) {
		List<LogRecord> logRecords = new LinkedList<LogRecord>();
		Iterator it = employeeAttendance.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Employee, Attendance> pair = (Map.Entry) it.next();
			List<LogRecord> empAttd = pair.getValue().getLogRecords();
			for (int i = 0; i < empAttd.size(); i++) {
				if (empAttd.get(i).getLogType() == LogType.PTO_HOURS &&
				    empAttd.get(i).getLogin().after(startDate) &&
					empAttd.get(i).getLogin().before(endDate)) {
					logRecords.add(empAttd.get(i));
				}
			}
		}
		return logRecords;
	}

}
