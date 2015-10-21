package com.domain.HRConsole;

import java.util.List;

public class Manager extends AbstractEmployee {

	private List<Employee> empList;

	public List<Employee> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((empList == null) ? 0 : empList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manager other = (Manager) obj;
		if (empList == null) {
			if (other.empList != null)
				return false;
		} else if (!empList.equals(other.empList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Manager [empList=" + empList + "]";
	}
	
	
}
