package com.college.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.college.dao.StudentDAO;
import com.college.model.Student;

@WebServlet("/viewStudents")
public class ViewStudentsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        StudentDAO dao = new StudentDAO();
        List<Student> students = dao.getAllStudents();

        request.setAttribute("studentList", students);
        request.getRequestDispatcher("viewStudents.jsp").forward(request, response);
    }
}
