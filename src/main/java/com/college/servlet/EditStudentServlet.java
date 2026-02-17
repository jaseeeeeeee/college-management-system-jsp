package com.college.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.college.dao.StudentDAO;
import com.college.model.Student;

@WebServlet("/editStudent")
public class EditStudentServlet extends HttpServlet {

    // LOAD STUDENT DATA (GET)
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        StudentDAO dao = new StudentDAO();
        Student student = dao.getStudentById(id);

        request.setAttribute("student", student);
        request.getRequestDispatcher("editStudent.jsp").forward(request, response);
    }

    // UPDATE STUDENT (POST)
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        int courseId = Integer.parseInt(request.getParameter("courseId"));
        int semester = Integer.parseInt(request.getParameter("semester"));

        StudentDAO dao = new StudentDAO();
        dao.updateStudent(id, name, email, courseId, semester);

        response.sendRedirect("viewStudents");
    }
}
