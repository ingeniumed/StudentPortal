package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dblogicops.StudentDAO;
import dblogicops.StudentDAOImplementation;
import model.Student;

/**
 * Servlet implementation class StudentController
 */
@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	
	private StudentDAO dao;
	private static final long serialVersionUID = 1L;
	public static final String lIST_STUDENT = "/listStudent.jsp";
	public static final String INSERT_OR_EDIT = "/student.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
        dao = new StudentDAOImplementation();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
        String action = request.getParameter( "action" );
 
        if( action.equalsIgnoreCase("delete")) {
            forward = lIST_STUDENT;
            int serialId = Integer.parseInt(request.getParameter("serialId"));
            dao.deleteStudent(serialId);
            request.setAttribute("students", dao.getAllStudents());
        }
        else if( action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int serialId = Integer.parseInt(request.getParameter("serialId"));
            Student student = dao.getStudentById(serialId);
            request.setAttribute("student", student);
        }
        else if( action.equalsIgnoreCase("insert")) {
            forward = INSERT_OR_EDIT;
        }
        else {
            forward = lIST_STUDENT;
            request.setAttribute("students", dao.getAllStudents() );
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
        }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student student = new Student();
		student.setStudentId(request.getParameter("studentId"));
        student.setName(request.getParameter("name"));
        student.setdob(request.getParameter("dob"));
        student.setStatus(request.getParameter("status"));
        student.setCpi(Double.parseDouble(request.getParameter("cpi")));
        
        String serialId = request.getParameter("serialId");
 
        if(serialId == null || serialId.isEmpty())
            dao.addStudent(student);
        else {
            student.setSerialId(Integer.parseInt(serialId));
            dao.updateStudent(student);
        }
        RequestDispatcher view = request.getRequestDispatcher(lIST_STUDENT);
        request.setAttribute("students", dao.getAllStudents());
        view.forward(request, response);
	}
}
