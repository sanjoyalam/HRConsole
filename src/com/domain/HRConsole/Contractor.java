package com.domain.HRConsole;

import java.util.Date;

public class Contractor extends Employee{
	
	private float hourlyRate;
	private Date contFromDate;
	private Date contThruDate;
	
	public float getHourlyRate() {
		return hourlyRate;
	}
	public void setHourlyRate(float hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
	public Date getContFromDate() {
		return contFromDate;
	}
	public void setContFromDate(Date contFromDate) {
		this.contFromDate = contFromDate;
	}
	public Date getContThruDate() {
		return contThruDate;
	}
	public void setContThruDate(Date contThruDate) {
		this.contThruDate = contThruDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((contFromDate == null) ? 0 : contFromDate.hashCode());
		result = prime * result + ((contThruDate == null) ? 0 : contThruDate.hashCode());
		result = prime * result + Float.floatToIntBits(hourlyRate);
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
		Contractor other = (Contractor) obj;
		if (contFromDate == null) {
			if (other.contFromDate != null)
				return false;
		} else if (!contFromDate.equals(other.contFromDate))
			return false;
		if (contThruDate == null) {
			if (other.contThruDate != null)
				return false;
		} else if (!contThruDate.equals(other.contThruDate))
			return false;
		if (Float.floatToIntBits(hourlyRate) != Float.floatToIntBits(other.hourlyRate))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Contractor [hourlyRate=" + hourlyRate + ", contFromDate=" + contFromDate + ", contThruDate="
				+ contThruDate + "]";
	}

	
	
}