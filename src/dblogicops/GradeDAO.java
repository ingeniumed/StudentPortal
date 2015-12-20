package dblogicops;

import java.util.List;

import model.Grade;

public interface GradeDAO {
	public void addGrade(Grade grade);
	public void updateGrade(Grade grade);
	public boolean checkGradeExists(String studentId, String year);
	public List<Grade> getGradesStudent(String studentId);
	public Grade getGradeByIdYear(String studentId, String year);
}
