package dblogicops;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Grade;
import utilities.DBUtilities;

public class GradeDAOImplementation implements GradeDAO {

	private Connection db_conn;

	public GradeDAOImplementation() {
		db_conn = DBUtilities.getConnection();
	}

	@Override
	public void addGrade(Grade grad) {
		try{
			String query = "insert into grade (id, year, gpi, year_result, subject1,subject2,subject3,subject4,subject5) values (?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = db_conn.prepareStatement(query);
            preparedStatement.setString(1, grad.getId());
            preparedStatement.setString(2, grad.getYear());
            preparedStatement.setDouble(3, grad.getgpi());
            preparedStatement.setString(4, grad.getYearresult());
            preparedStatement.setString(5, grad.getSubject1());
            preparedStatement.setString(6, grad.getSubject2());
            preparedStatement.setString(7, grad.getSubject3());
            preparedStatement.setString(8, grad.getSubject4());
            preparedStatement.setString(9, grad.getSubject5());
            preparedStatement.executeUpdate();
            preparedStatement.close();
		} catch(SQLException e){
			e.printStackTrace();
		}	
	}

	@Override
	public void updateGrade(Grade grad) {
		try{
			String query = "update grade set gpi=?, year_result=?, subject1=?,subject2=?,subject3=?,subject4=?,subject5=? where id=? and year=?";
			PreparedStatement preparedStatement = db_conn.prepareStatement(query);
            preparedStatement.setDouble(1, grad.getgpi());
            preparedStatement.setString(2, grad.getYearresult());
            preparedStatement.setString(3, grad.getSubject1());
            preparedStatement.setString(4, grad.getSubject2());
            preparedStatement.setString(5, grad.getSubject3());
            preparedStatement.setString(6, grad.getSubject4());
            preparedStatement.setString(7, grad.getSubject5());
            preparedStatement.setString(8, grad.getId());
            preparedStatement.setString(9, grad.getYear());
            preparedStatement.executeUpdate();
            preparedStatement.close();
		} catch(SQLException e){
			e.printStackTrace();
		}	
	}

	@Override
	public List<Grade> getGradesStudent(String studentId) {
		List<Grade> grades = new ArrayList<Grade>();
		try{
			Statement statement = db_conn.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from grade where id='" + studentId + "'");
			while(resultSet.next()) {
				Grade grade = new Grade();
				grade.setId(resultSet.getString("id"));
				grade.setYear(resultSet.getString("year"));
				grade.setgpi(resultSet.getDouble("gpi"));
				grade.setYearresult(resultSet.getString("year_result"));
				grade.setSubject1(resultSet.getString("subject1"));
				grade.setSubject2(resultSet.getString("subject2"));
				grade.setSubject3(resultSet.getString("subject3"));
				grade.setSubject4(resultSet.getString("subject4"));
				grade.setSubject5(resultSet.getString("subject5"));
				grades.add(grade);
			}
			resultSet.close();
			statement.close();
		} catch(SQLException e){
			e.printStackTrace();
		}
		return grades;
	}

	@Override
	public boolean checkGradeExists(String studentId, String year) {
		int row_counter = 0;
		boolean flag = false;
		try{
			Statement statement = db_conn.createStatement();
			ResultSet resultSet = statement.executeQuery("select count(*) from grade where id='" + studentId + "' and year='" + year + "'");
			while(resultSet.next()) {
				row_counter = resultSet.getInt("count(*)");
			}
			if (row_counter > 0){
				flag = true;
			}
			resultSet.close();
			statement.close();
		} catch(SQLException e){
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Grade getGradeByIdYear(String studentId, String year) {
		Grade grade = new Grade();
		try{
			String query = "select * from grade where id=? and year=?";
			PreparedStatement preparedStatement = db_conn.prepareStatement(query);
			preparedStatement.setString(1, studentId);
			preparedStatement.setString(2, year);
			ResultSet resultSet = preparedStatement.executeQuery();
			while( resultSet.next() ) {
				grade.setId(resultSet.getString("id"));
				grade.setYear(resultSet.getString("year"));
				grade.setgpi(resultSet.getDouble("gpi"));
				grade.setYearresult(resultSet.getString("year_result"));
				grade.setSubject1(resultSet.getString("subject1"));
				grade.setSubject2(resultSet.getString("subject2"));
				grade.setSubject3(resultSet.getString("subject3"));
				grade.setSubject4(resultSet.getString("subject4"));
				grade.setSubject5(resultSet.getString("subject5"));
			}
			resultSet.close();
			preparedStatement.close();
		} catch(SQLException e){
			e.printStackTrace();
		}
		return grade;
	}
}
