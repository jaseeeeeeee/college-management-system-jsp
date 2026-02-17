<%@ page import="java.util.List" %>
<%@ page import="com.college.model.Course" %>
<%@ include file="layout/header.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <title>Add Student</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<!-- NAVBAR -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">College Management System</a>
    <div class="navbar-nav ms-auto">
      <a class="nav-link" href="addStudent">Add Student</a>
      <a class="nav-link" href="viewStudents">View Students</a>
    </div>
  </div>
</nav>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">

            <div class="card shadow">
                <div class="card-header bg-primary text-white">
                    <h4 class="mb-0">Add Student</h4>
                </div>

                <div class="card-body">

                    <!-- ERROR MESSAGE -->
                    <%
                        String error = (String) request.getAttribute("error");
                        String msg = (String) request.getAttribute("msg");
                        if (error != null) {
                    %>
                        <div class="alert alert-danger"><%= error %></div>
                    <%
                        }
                        if (msg != null) {
                    %>
                        <div class="alert alert-success"><%= msg %></div>
                    <%
                        }
                    %>

                    <form action="addStudent" method="post">

                        <div class="mb-3">
                            <label class="form-label">Name</label>
                            <input type="text" name="name" class="form-control" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Email</label>
                            <input type="email" name="email" class="form-control" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Password</label>
                            <input type="password" name="password" class="form-control" required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Course</label>
                            <select name="courseId" class="form-select" required>
                                <option value="">-- Select Course --</option>
                                <%
                                    List<Course> courses = (List<Course>) request.getAttribute("courses");
                                    if (courses != null) {
                                        for (Course c : courses) {
                                %>
                                    <option value="<%= c.getCourseId() %>">
                                        <%= c.getCourseName() %>
                                    </option>
                                <%
                                        }
                                    }
                                %>
                            </select>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Semester</label>
                            <input type="number" name="semester" class="form-control" required>
                        </div>

                        <button type="submit" class="btn btn-success w-100">
                            Add Student
                        </button>

                    </form>
                </div>
            </div>

        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
<%@ include file="layout/footer.jsp" %>
