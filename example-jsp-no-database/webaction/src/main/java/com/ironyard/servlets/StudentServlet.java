package com.ironyard.servlets;

import com.ironyard.data.Student;
import com.ironyard.service.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by jasonskipper on 9/19/16.
 */
@WebServlet(name = "StudentServlet")
public class StudentServlet extends HttpServlet {

    // the expected request parm for navigation control
    public static final String NAVIGATION_PARAM = "nav";

    // the expected request value for NAVIGATION_PARAM when
    // trying to get to the details page
    public static final String LOCATION_STUDENT_LIST = "list";
    private static final String LOCATION_STUDENT_DETAIL = "detail";

    // place we put student list for display
    public static final String REQUEST_SCOPE_STUDENTS = "students";

    public static final String JSP_DEST_STUDENT_LIST = "/studentList.jsp";


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // figure out where they are going
        String nextPage = request.getParameter(NAVIGATION_PARAM);

        StudentService studentSrv = new StudentService();

        if( nextPage == null || nextPage.equalsIgnoreCase(LOCATION_STUDENT_LIST)){

            // 1) get list of students
            List<Student> all = studentSrv.createDummyStudentData();

            // 2) put list in request scope
            request.setAttribute(REQUEST_SCOPE_STUDENTS, all);
            // 3) forward to list page
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(JSP_DEST_STUDENT_LIST);
            dispatcher.forward(request,response);
        } else if(nextPage.equalsIgnoreCase(LOCATION_STUDENT_DETAIL)) {
            // 1) get list of students
            List<Student> all = studentSrv.createDummyStudentData();

            long idThatWasClicked = Long.parseLong(request.getParameter("stu"));
            for(Student aStudent: all){
               if(aStudent.getId() == idThatWasClicked){
                   request.setAttribute("student", aStudent);
                   break;
               }
            }
            // 3) forward to list page
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/studentDetail.jsp");
            dispatcher.forward(request,response);
        }


    }
}
