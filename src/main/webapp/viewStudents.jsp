<%@ page import="java.util.List" %>
<%@ page import="com.college.model.Student" %>

<!DOCTYPE html>
<html>
<head>
    <title>View Students</title>

    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background-color: #f4f6f9;
        }

        /* NAVBAR */
        .navbar {
            background-color: #1f2933;
            color: white;
            padding: 15px 30px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .navbar a {
            color: #cbd5e1;
            margin-left: 20px;
            text-decoration: none;
            font-weight: 500;
        }

        .navbar a:hover {
            color: white;
        }

        /* PAGE */
        .container {
            padding: 40px;
        }

        .card {
            background-color: white;
            padding: 25px;
            border-radius: 8px;
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
        }

        h2 {
            margin-top: 0;
            margin-bottom: 20px;
        }

        /* TABLE */
        table {
            width: 100%;
            border-collapse: collapse;
        }

        th {
            background-color: #2563eb;
            color: white;
            padding: 12px;
            text-align: left;
        }

        td {
            padding: 12px;
            border-bottom: 1px solid #e5e7eb;
        }

        tr:hover {
            background-color: #f1f5f9;
        }

        /* BUTTONS */
        .btn {
            padding: 6px 12px;
            border-radius: 5px;
            font-size: 14px;
            text-decoration: none;
            margin-right: 6px;
            display: inline-block;
        }

        .btn-edit {
            background-color: #2563eb;
            color: white;
        }

        .btn-delete {
            background-color: #dc2626;
            color: white;
        }

        .btn-edit:hover {
            background-color: #1e40af;
        }

        .btn-delete:hover {
            background-color: #991b1b;
        }

        .empty {
            text-align: center;
            color: #6b7280;
            padding: 20px;
        }
    </style>
</head>

<body>

<!-- NAVBAR -->
<div class="navbar">
    <div><strong>College Management System</strong></div>
    <div>
        <a href="addStudent">Add Student</a>
        <a href="viewStudents">View Students</a>
    </div>
</div>

<!-- CONTENT -->
<div class="container">
    <div class="card">
        <h2>Student List</h2>

        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Course</th>
                <th>Semester</th>
                <th>Actions</th>
            </tr>

            <%
                List<Student> students = (List<Student>) request.getAttribute("studentList");

                if (students != null && !students.isEmpty()) {
                    for (Student s : students) {
            %>
            <tr>
                <td><%= s.getStudentId() %></td>
                <td><%= s.getName() %></td>
                <td><%= s.getEmail() %></td>
                <td><%= s.getCourseId() %></td>
                <td><%= s.getSemester() %></td>
                <td>
                    <a class="btn btn-edit" href="editStudent?id=<%= s.getStudentId() %>">Edit</a>
                    <a class="btn btn-delete"
                       href="deleteStudent?id=<%= s.getStudentId() %>"
                       onclick="return confirm('Are you sure you want to delete this student?');">
                       Delete
                    </a>
                </td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="6" class="empty">No students found</td>
            </tr>
            <%
                }
            %>
        </table>
    </div>
</div>

</body>
</html>
