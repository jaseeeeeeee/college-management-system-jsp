package com.college.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.college.dao.StudentDAO;

@WebServlet("/deleteStudent")
public class DeleteStudentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int studentId = Integer.parseInt(request.getParameter("id"));

        StudentDAO dao = new StudentDAO();
        dao.deleteStudent(studentId);

        response.sendRedirect("viewStudents");
    }
}
