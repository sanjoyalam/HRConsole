package com.domain.HRConsole;

public abstract class AbstractEmployee {
        protected int empId;
        protected String Name;
        protected double Salary;
        protected String grade;
        protected String empType;
        protected int deptId;
        protected String desig;
        protected String address;
        protected String city;
        protected String state;
        protected int zipcode;
        

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
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public int getZipcode() {
			return zipcode;
		}
		public void setZipcode(int zipcode) {
			this.zipcode = zipcode;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((Name == null) ? 0 : Name.hashCode());
			long temp;
			temp = Double.doubleToLongBits(Salary);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + ((address == null) ? 0 : address.hashCode());
			result = prime * result + ((city == null) ? 0 : city.hashCode());
			result = prime * result + deptId;
			result = prime * result + ((desig == null) ? 0 : desig.hashCode());
			result = prime * result + empId;
			result = prime * result + ((empType == null) ? 0 : empType.hashCode());
			result = prime * result + ((grade == null) ? 0 : grade.hashCode());
			result = prime * result + ((state == null) ? 0 : state.hashCode());
			result = prime * result + zipcode;
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
			if (address == null) {
				if (other.address != null)
					return false;
			} else if (!address.equals(other.address))
				return false;
			if (city == null) {
				if (other.city != null)
					return false;
			} else if (!city.equals(other.city))
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
			if (state == null) {
				if (other.state != null)
					return false;
			} else if (!state.equals(other.state))
				return false;
			if (zipcode != other.zipcode)
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "AbstractEmployee [empId=" + empId + ", Name=" + Name + ", Salary=" + Salary + ", grade=" + grade
					+ ", empType=" + empType + ", deptId=" + deptId + ", desig=" + desig + "]";
		}

}
