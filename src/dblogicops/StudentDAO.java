package dblogicops;

import java.util.List;

import model.Student;

public interface StudentDAO {
	public void addStudent(Student student);
	public void deleteStudent(int serialId);
	public void updateStudent(Student student);
	public List<Student> getAllStudents();
	public Student getStudentById(int serialId);
}
