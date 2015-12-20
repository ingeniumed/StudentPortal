package dblogicops;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import model.Grade;
import model.Student;
import utilities.DBUtilities;

public class StudentDAOImplementation implements StudentDAO {

	private Connection db_conn;

	public StudentDAOImplementation() {
		db_conn = DBUtilities.getConnection();
	}

	@Override
	public void addStudent(Student student) {
		try{
			String query = "insert into student (studentId, name, dob, status, cpi) values (?,?,?,?,?)";
			PreparedStatement preparedStatement = db_conn.prepareStatement(query);
			preparedStatement.setString(1, student.getStudentId());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setString(3, student.getdob());
			preparedStatement.setString(4, student.getStatus());
			preparedStatement.setDouble(5, student.getCpi());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public void deleteStudent(int serialId) {
		try{
			String query = "delete from student where serialId=?";
			PreparedStatement preparedStatement = db_conn.prepareStatement(query);
			preparedStatement.setInt(1, serialId);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public void updateStudent(Student student) {
		try{
			String query = "update student set studentId=?, name=?, dob=?, status=?, cpi=? where serialId=?";
			PreparedStatement preparedStatement = db_conn.prepareStatement(query);
			preparedStatement.setString(1, student.getStudentId());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setString(3, student.getdob());
			preparedStatement.setString(4, student.getStatus());
			preparedStatement.setDouble(5, student.getCpi());
			preparedStatement.setInt(6, student.getSerialId());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch(SQLException e){
			e.printStackTrace();
		}	
	}

	@Override
	public List<Student> getAllStudents() {
		
		int student_size = 0;
		try{
			Statement statement = db_conn.createStatement();
			ResultSet resultSet = statement.executeQuery( "select count(*) from student" );
			while(resultSet.next()) {
				student_size = resultSet.getInt("count(*)");
			}
			resultSet.close();
			statement.close();
		} catch(SQLException e){
			e.printStackTrace();
		} 
		
		if (student_size == 0){
			Student child;
			Grade child_grade;
			String studentId;
			String year;
			GradeDAO grade_load = new GradeDAOImplementation();
			JSONParser parser = new JSONParser();
			FileReader file = null;

			try {
				file = new FileReader("C:\\Users\\EobardAllen\\Dropbox\\eclipse\\StudentPortal\\src\\student.json");
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}

			try {
				JSONObject jsonobject = (JSONObject) parser.parse(file);

				JSONArray jsonArray = (JSONArray) jsonobject.get("data");

				for(Object o : jsonArray){
					JSONObject student = (JSONObject) o;

					studentId = ((String)student.get("id"));

					child = new Student();
					child.setStudentId(studentId);
					child.setName(((String)student.get("name")));
					child.setdob((String)student.get("dob"));
					child.setStatus((String)student.get("status"));
					child.setCpi((Double)student.get("cpi"));
					
					addStudent(child);

					JSONArray grades = (JSONArray) student.get("grades");
					for (Object object : grades) {
						JSONObject grade = (JSONObject) object;

						year = Long.toString(((Long)grade.get("year")));

						child_grade = new Grade();
						child_grade.setId(studentId);
						child_grade.setYear(year);
						child_grade.setgpi(((Double) grade.get("gpi")));
						child_grade.setYearresult(((String)grade.get("year_result")));
						child_grade.setSubject1(((String)grade.get("subject1")));
						child_grade.setSubject2(((String)grade.get("subject2")));
						child_grade.setSubject3(((String)grade.get("subject3")));
						child_grade.setSubject4(((String)grade.get("subject4")));
						child_grade.setSubject5(((String)grade.get("subject5")));
						
						grade_load.addGrade(child_grade);
					}
				}

			} catch (IOException | ParseException | NullPointerException e) {
				e.printStackTrace();
			}
		}
		
		List<Student> students = new ArrayList<Student>();
		try{
			Statement statement = db_conn.createStatement();
			ResultSet resultSet = statement.executeQuery( "select * from student" );
			while(resultSet.next()) {
				Student student = new Student();
				student.setSerialId( resultSet.getInt( "serialId" ) );
				student.setStudentId( resultSet.getString( "studentId" ) );
				student.setName( resultSet.getString( "name" ) );
				student.setdob( resultSet.getString( "dob" ) );
				student.setStatus( resultSet.getString( "status" ) );
				student.setCpi( resultSet.getDouble( "cpi" ) );
				students.add(student);
			}
			resultSet.close();
			statement.close();
		} catch(SQLException e){
			e.printStackTrace();
		}
		return students;
	}

	@Override
	public Student getStudentById(int serialId) {
		Student student = new Student();
		try{
			String query = "select * from student where serialId=?";
			PreparedStatement preparedStatement = db_conn.prepareStatement( query );
			preparedStatement.setInt(1, serialId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while( resultSet.next() ) {
				student.setSerialId( resultSet.getInt( "serialId" ) );
				student.setStudentId( resultSet.getString( "studentId" ) );
				student.setName( resultSet.getString( "name" ) );
				student.setdob( resultSet.getString( "dob" ) );
				student.setStatus( resultSet.getString( "status" ) );
				student.setCpi( resultSet.getDouble( "cpi" ) );
			}
			resultSet.close();
			preparedStatement.close();
		} catch(SQLException e){
			e.printStackTrace();
		}
		return student;
	}
}
