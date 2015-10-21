package com.domain.HRConsole;

import java.util.List;

public class Attendance {

	private List<LogRecord> logRecords;

	public List<LogRecord> getLogRecords() {
		return logRecords;
	}
	public void setLogRecords(List<LogRecord> logRecords) {
		this.logRecords = logRecords;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((logRecords == null) ? 0 : logRecords.hashCode());
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
		Attendance other = (Attendance) obj;
		if (logRecords == null) {
			if (other.logRecords != null)
				return false;
		} else if (!logRecords.equals(other.logRecords))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Attendance [logRecords=" + logRecords + "]";
	}
	
	
}
