package model;

public class Grade {
	private String id;
	private String year;
	private double gpi;
	private String yearresult;
	private String subject1;
	private String subject2;
	private String subject3;
	private String subject4;
	private String subject5;
	
	public String getId() {
		return id;
	}
	
	public void setId(String studentId) {
		this.id = studentId;
	}

	public String getYear() {
		return year;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	public double getgpi() {
		return gpi;
	}
	
	public void setgpi(double gpi) {
		this.gpi = gpi;
	}

	public String getYearresult() {
		return yearresult;
	}
	
	public void setYearresult(String year_result) {
		this.yearresult = year_result;
	}

	public String getSubject1() {
		return subject1;
	}
	
	public void setSubject1(String subject) {
	this.subject1 = subject;
	}

	public String getSubject2() {
		return subject2;
	}

	public void setSubject2(String subject) {
		this.subject2 = subject;
	}

	public String getSubject3() {
		return subject3;
	}

	public void setSubject3(String subject) {
		this.subject3 = subject;
	}

	public String getSubject4() {
		return subject4;
	}

	public void setSubject4(String subject) {
		this.subject4 = subject;
	}

	public String getSubject5() {
		return subject5;
	}

	public void setSubject5(String subject) {
		this.subject5 = subject;
	}
	
	// helps if you want to print the 
	// current state of an instance, using 
	// a logging framework or not
	@Override
	public String toString() {
		return "Grad [studentId=" + id + ", Year=" + year
				+ ", gpi=" + gpi + ", YearResult=" + yearresult + ", subject1="
				+ subject1 + ", subject2=" + subject2 + ", subject3="
				+ subject3 + ", subject4=" + subject4 + ", subject5=" 
				+ subject5 +"]";
	}

}
