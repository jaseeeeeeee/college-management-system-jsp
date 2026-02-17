package com.college.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.college.dao.CourseDAO;
import com.college.dao.StudentDAO;
import com.college.model.Course;

@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {

    // ==========================
    // LOAD ADD STUDENT PAGE
    // ==========================
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        CourseDAO courseDAO = new CourseDAO();
        List<Course> courseList = courseDAO.getAllCourses();

        // send course list to JSP
        request.setAttribute("courses", courseList);

        request.getRequestDispatcher("/addStudent.jsp").forward(request, response);

    }

    // ==========================
    // HANDLE FORM SUBMIT
    // ==========================
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            int courseId = Integer.parseInt(request.getParameter("courseId"));
            int semester = Integer.parseInt(request.getParameter("semester"));

            StudentDAO dao = new StudentDAO();
            boolean isAdded = dao.addStudent(name, email, password, courseId, semester);

            if (isAdded) {
                // redirect to view students
                response.sendRedirect("viewStudents");
            } else {
                request.setAttribute("error", "Failed to add student");
                doGet(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Something went wrong");
            doGet(request, response);
        }
    }
}
