package com.college.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.college.dao.StudentDAO;
import com.college.dao.CourseDAO;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        StudentDAO studentDAO = new StudentDAO();
        CourseDAO courseDAO = new CourseDAO();

        request.setAttribute("totalStudents", studentDAO.countStudents());
        request.setAttribute("totalCourses", courseDAO.countCourses());
        request.setAttribute("totalFaculty", 0); // we’ll add later

        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

    }
    
}
