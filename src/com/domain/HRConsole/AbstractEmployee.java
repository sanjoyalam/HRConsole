package com.domain.HRConsole;

public abstract class AbstractEmployee {
        protected int empId;
        protected String Name;
        protected double Salary;
        protected String grade;
        protected String empType;
        protected int deptId;
        protected String desig;
        

		public int getEmpId() {
			return empId;
		}
		public void setEmpId(int empId) {
			this.empId = empId;
		}
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public double getSalary() {
			return Salary;
		}
		public void setSalary(double salary) {
			Salary = salary;
		}
		public String getGrade() {
			return grade;
		}
		public void setGrade(String grade) {
			this.grade = grade;
		}
		public String getEmpType() {
			return empType;
		}
		public void setEmpType(String empType) {
			this.empType = empType;
		}
		public int getDeptId() {
			return deptId;
		}
		public void setDeptId(int deptId) {
			this.deptId = deptId;
		}
		public String getDesig() {
			return desig;
		}
		public void setDesig(String desig) {
			this.desig = desig;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((Name == null) ? 0 : Name.hashCode());
			long temp;
			temp = Double.doubleToLongBits(Salary);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + deptId;
			result = prime * result + ((desig == null) ? 0 : desig.hashCode());
			result = prime * result + empId;
			result = prime * result + ((empType == null) ? 0 : empType.hashCode());
			result = prime * result + ((grade == null) ? 0 : grade.hashCode());
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
			AbstractEmployee other = (AbstractEmployee) obj;
			if (Name == null) {
				if (other.Name != null)
					return false;
			} else if (!Name.equals(other.Name))
				return false;
			if (Double.doubleToLongBits(Salary) != Double.doubleToLongBits(other.Salary))
				return false;
			if (deptId != other.deptId)
				return false;
			if (desig == null) {
				if (other.desig != null)
					return false;
			} else if (!desig.equals(other.desig))
				return false;
			if (empId != other.empId)
				return false;
			if (empType == null) {
				if (other.empType != null)
					return false;
			} else if (!empType.equals(other.empType))
				return false;
			if (grade == null) {
				if (other.grade != null)
					return false;
			} else if (!grade.equals(other.grade))
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "AbstractEmployee [empId=" + empId + ", Name=" + Name + ", Salary=" + Salary + ", grade=" + grade
					+ ", empType=" + empType + ", deptId=" + deptId + ", desig=" + desig + "]";
		}

}
