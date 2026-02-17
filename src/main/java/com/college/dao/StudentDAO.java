package com.college.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.college.model.Student;
import com.college.util.DBConnection;

public class StudentDAO {

    // =======================
    // ADD STUDENT (CREATE)
    // =======================
    public boolean addStudent(String name, String email, String password,
                              int courseId, int semester) {

        String sql = "INSERT INTO students(name, email, password, course_id, semester) "
                   + "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setInt(4, courseId);
            ps.setInt(5, semester);

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    

    // =======================
    // GET ALL STUDENTS (READ)
    // =======================
    public List<Student> getAllStudents() {

        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Student s = new Student();
                s.setStudentId(rs.getInt("student_id"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                s.setCourseId(rs.getInt("course_id"));
                s.setSemester(rs.getInt("semester"));

                students.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }
 // =======================
 // UPDATE STUDENT
 // =======================
 public boolean updateStudent(int studentId, String name, String email,
                              int courseId, int semester) {

     String sql = "UPDATE students SET name=?, email=?, course_id=?, semester=? "
                + "WHERE student_id=?";

     try (Connection con = DBConnection.getConnection();
          PreparedStatement ps = con.prepareStatement(sql)) {

         ps.setString(1, name);
         ps.setString(2, email);
         ps.setInt(3, courseId);
         ps.setInt(4, semester);
         ps.setInt(5, studentId);

         int rows = ps.executeUpdate();
         return rows > 0;

     } catch (Exception e) {
         e.printStackTrace();
         return false;
     }
 }
 public boolean deleteStudentById(int id) {

	    String sql = "DELETE FROM students WHERE student_id = ?";

	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setInt(1, id);
	        ps.executeUpdate();
	        return true;

	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}
 public Student getStudentById(int id) {
	    Student s = null;
	    String sql = "SELECT * FROM students WHERE student_id=?";

	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            s = new Student();
	            s.setStudentId(rs.getInt("student_id"));
	            s.setName(rs.getString("name"));
	            s.setEmail(rs.getString("email"));
	            s.setCourseId(rs.getInt("course_id"));
	            s.setSemester(rs.getInt("semester"));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return s;
	}
 public boolean deleteStudent(int studentId) {

	    String sql = "DELETE FROM students WHERE student_id = ?";

	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setInt(1, studentId);
	        ps.executeUpdate();
	        return true;

	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}
 public int countStudents() {
	    String sql = "SELECT COUNT(*) FROM students";
	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {

	        if (rs.next()) return rs.getInt(1);

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return 0;
	}

 
}
