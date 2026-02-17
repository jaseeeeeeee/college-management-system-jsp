<%@ page import="com.college.model.Student" %>

<%
    Student student = (Student) request.getAttribute("student");
%>
<%@ include file="layout/header.jsp" %>

<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <title>Edit Student</title>
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

<h2>Edit Student</h2>

<form action="editStudent" method="post">

    <input type="hidden" name="id" value="<%= student.getStudentId() %>">

    Name:
    <input type="text" name="name" value="<%= student.getName() %>" required><br><br>

    Email:
    <input type="email" name="email" value="<%= student.getEmail() %>" required><br><br>

    Course ID:
    <input type="number" name="courseId" value="<%= student.getCourseId() %>" required><br><br>

    Semester:
    <input type="number" name="semester" value="<%= student.getSemester() %>" required><br><br>

    <input type="submit" value="Update Student">
</form>

<br>
<a href="viewStudents">Back to Student List</a>

</body>
</html>
<%@ include file="layout/footer.jsp" %>
