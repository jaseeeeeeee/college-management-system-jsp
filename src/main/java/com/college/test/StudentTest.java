package com.college.test;

import com.college.dao.StudentDAO;

public class StudentTest {

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();

        dao.addStudent(
            "Amit Sharma",
            "amit@gmail.com",
            "1234",
            1,   // course_id from courses table
            5
        );
    }
}

