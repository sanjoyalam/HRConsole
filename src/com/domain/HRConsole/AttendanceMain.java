package com.domain.HRConsole;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class AttendanceMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AttendanceSystem aSystem=AttendanceSystem.getInstance();
		
		HashMap<Employee,Attendance> localSystem= new HashMap<Employee,Attendance>();
		
		Attendance attn = new Attendance();
		
		List<LogRecord> lrecords = new LinkedList<LogRecord>();
		
		Employee emp1 = new Employee();
		emp1.setEmpId(6603);
		emp1.setName("Jess Hoffman");
		emp1.setDeptId(1);
		emp1.setGrade("emp 1 grade");
		emp1.setDesig("Senior Developer");
		emp1.setEmpType("Permanent");
		emp1.setSalary(100000);
		
		LogRecord logRecord1 = new LogRecord();
		logRecord1.setEmpId(6603);
		logRecord1.setLogin(new GregorianCalendar(2015, 10, 01, 8, 00).getTime());
		logRecord1.setLogout(new GregorianCalendar(2015, 10, 01, 16, 30).getTime());
		logRecord1.setLogType(LogType.WORK_HOURS);
		
		lrecords.add(logRecord1);
		
		LogRecord logRecord2 = new LogRecord();
		logRecord2.setEmpId(6603);
		logRecord2.setLogin(new GregorianCalendar(2015, 10, 02, 9, 00).getTime());
		logRecord2.setLogout(new GregorianCalendar(2015, 10, 02, 17, 30).getTime());
		logRecord2.setLogType(LogType.WORK_HOURS);
		
		lrecords.add(logRecord2);
		
		LogRecord logRecord3 = new LogRecord();
		logRecord3.setEmpId(6603);
		logRecord3.setLogin(new GregorianCalendar(2015, 10, 03, 9, 00).getTime());
		logRecord3.setLogout(new GregorianCalendar(2015, 10, 03, 17, 30).getTime());
		logRecord3.setLogType(LogType.PTO_HOURS);
		
		lrecords.add(logRecord3);
		
		attn.setLogRecords(lrecords);
		
		localSystem.put(emp1, attn);
		
		aSystem.setEmployeeAttendance(localSystem);
		//lrecords.clear();
		List<LogRecord> lrecords2 = new LinkedList<LogRecord>();
		
		
		Employee emp2 = new Employee();
		emp2.setEmpId(9246);
		emp2.setName("Sanjoy Alam");
		emp2.setDeptId(2);
		emp2.setGrade("emp 2 grade");
		emp2.setDesig("DEVELOPER");
		emp2.setEmpType("PERMANENT");
		emp2.setSalary(80000);
		
		LogRecord logRecord4 = new LogRecord();
		logRecord4.setEmpId(9246);
		logRecord4.setLogin(new GregorianCalendar(2015, 10, 04, 8, 00).getTime());
		logRecord4.setLogout(new GregorianCalendar(2015, 10, 04, 16, 30).getTime());
		logRecord4.setLogType(LogType.WORK_HOURS);
		
		lrecords2.add(logRecord4);
		
		LogRecord logRecord5 = new LogRecord();
		logRecord5.setEmpId(9246);
		logRecord5.setLogin(new GregorianCalendar(2015, 10, 05, 9, 00).getTime());
		logRecord5.setLogout(new GregorianCalendar(2015, 10, 05, 17, 30).getTime());
		logRecord5.setLogType(LogType.WORK_HOURS);
		
		lrecords2.add(logRecord5);
		
		LogRecord logRecord6 = new LogRecord();
		logRecord6.setEmpId(9246);
		logRecord6.setLogin(new GregorianCalendar(2015, 10, 06, 9, 00).getTime());
		logRecord6.setLogout(new GregorianCalendar(2015, 10, 06, 17, 30).getTime());
		logRecord6.setLogType(LogType.SICK_HOURS);
		
		lrecords2.add(logRecord6);
		Attendance attn2 = new Attendance();
		attn2.setLogRecords(lrecords2);
		localSystem.put(emp2, attn2);
		
		aSystem.setEmployeeAttendance(localSystem);		
		System.out.println(aSystem.GetAttendanceDetailByDate(new GregorianCalendar(2015, 10, 04).getTime()));
		System.out.println(aSystem.GetAttendanceForEmployee(6603, new GregorianCalendar(2015, 9, 30).getTime(),new GregorianCalendar(2015, 10, 07).getTime()));
		System.out.println(aSystem.GetAttendanceForEmployee(9246, new GregorianCalendar(2015, 9, 30).getTime(),new GregorianCalendar(2015, 10, 07).getTime()));
		System.out.println(aSystem.GetAttendanceForDepartment(2,new GregorianCalendar(2015, 9, 30).getTime(),new GregorianCalendar(2015, 10, 7).getTime()));
		System.out.println(aSystem.GetEmployeesOnVacation(new GregorianCalendar(2015, 9, 30).getTime(),new GregorianCalendar(2015, 10, 07).getTime()));
	}
	
	
		

}
