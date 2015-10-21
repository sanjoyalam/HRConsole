package com.domain.HRConsole;

import java.util.Date;

public class LogRecord {

	private int empId;
	private Date login;
	private Date logout;
	private LogType logType;

	public LogType getLogType() {
		return logType;
	}

	public void setLogType(LogType logType) {
		this.logType = logType;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public Date getLogin() {
		return login;
	}

	public void setLogin(Date login) {
		this.login = login;
	}

	public Date getLogout() {
		return logout;
	}

	public void setLogout(Date logout) {
		this.logout = logout;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empId;
		result = prime * result + ((logType == null) ? 0 : logType.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((logout == null) ? 0 : logout.hashCode());
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
		LogRecord other = (LogRecord) obj;
		if (empId != other.empId)
			return false;
		if (logType != other.logType)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (logout == null) {
			if (other.logout != null)
				return false;
		} else if (!logout.equals(other.logout))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LogRecord [empId=" + empId + ", login=" + login + ", logout=" + logout + ", logType=" + logType + "]";
	}

}
