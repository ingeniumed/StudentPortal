package model;

public class Student {
	private int serialId;
	private String studentId;
	private String name;
	private String dob;
	private String status;
	private double cpi;
	
	public int getSerialId() {
		return serialId;
	}
	
	public void setSerialId(int serialId) {
		this.serialId = serialId;
	}
	
	public String getStudentId() {
		return studentId;
	}
	
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getdob() {
		return dob;
	}
	
	public void setdob(String dob) {
		this.dob = dob;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public double getCpi() {
		return cpi;
	}
	
	public void setCpi(double cpi) {
		this.cpi = cpi;
	}

	@Override
	public String toString() {
		return "Student [serialId=" + serialId + ",studentId=" + studentId + ", Name=" + name
				+ ", dob=" + dob + ", Status=" + status + ", cpi="
				+ cpi +"]";
	}
}
