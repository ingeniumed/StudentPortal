package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dblogicops.GradeDAO;
import dblogicops.GradeDAOImplementation;
import model.Grade;

/**
 * Servlet implementation class StudentController
 */
@WebServlet("/GradController")
public class GradeController extends HttpServlet {
	
	private GradeDAO dao;
	private static final long serialVersionUID = 1L;
	public static final String lIST_GRADE = "/listGrade.jsp";
	public static final String INSERT_OR_EDIT = "/grade.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GradeController() {
        dao = new GradeDAOImplementation();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
        String action = request.getParameter( "action" );
 
        if( action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            String studentId = request.getParameter("id");
            String year = request.getParameter("year");
            Grade grade = dao.getGradeByIdYear(studentId, year);
            request.setAttribute("grade", grade);
        }
        else if(action.equalsIgnoreCase("insert")) {
            forward = INSERT_OR_EDIT;
            String studentId = request.getParameter("id");
            Grade grade = new Grade();
            grade.setId(studentId);
            grade.setYear("0000");
            grade.setgpi(0.00);
            grade.setYearresult("");
            grade.setSubject1("");
            grade.setSubject2("");
            grade.setSubject3("");
            grade.setSubject4("");
            grade.setSubject5("");
            request.setAttribute("grade", grade);
        }
        else {
            forward = lIST_GRADE;
            String studentId = request.getParameter("id");
            request.setAttribute("grades", dao.getGradesStudent(studentId));
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Grade grade = new Grade();
        grade.setgpi(Double.parseDouble(request.getParameter("gpi")));
        grade.setYearresult(request.getParameter("yearresult"));
        grade.setSubject1(request.getParameter("subject1"));
        grade.setSubject2(request.getParameter("subject2"));
        grade.setSubject3(request.getParameter("subject3"));
        grade.setSubject4(request.getParameter("subject4"));
        grade.setSubject5(request.getParameter("subject5"));
        String studentId = request.getParameter("id");
        String year = request.getParameter("year");
        
        boolean flag = dao.checkGradeExists(studentId, year);
 
        if(flag){
            grade.setId(studentId);
            grade.setYear(year);
            dao.updateGrade(grade);
        } else {
        	grade.setId(studentId);
            grade.setYear(year);
            dao.addGrade(grade);
        }
        
        RequestDispatcher view = request.getRequestDispatcher(lIST_GRADE);
        request.setAttribute("grades", dao.getGradesStudent(studentId));
        view.forward(request, response);
	}
}
