package com.college.test;

import com.college.dao.CourseDAO;

public class CourseTestt {

    public static void main(String[] args) {
        CourseDAO dao = new CourseDAO();
        dao.addCourse("Computer Engineering", 3);
    }
}
