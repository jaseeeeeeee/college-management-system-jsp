<%@ page contentType="text/html;charset=UTF-8" %>
<%
    com.college.model.User u =
        (com.college.model.User) session.getAttribute("user");
    if (u != null) {
%>
    <span class="navbar-text text-light me-3">
        Welcome, <strong><%= u.getName() %></strong>
    </span>
<%
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>College Management System</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="dashboard">College Management System</a>
    <div class="navbar-nav ms-auto">
      <a class="nav-link" href="addStudent">Add Student</a>
      <a class="nav-link" href="viewStudents">View Students</a>
      <a class="nav-link" href="viewCourses">Courses</a>
      <a class="nav-link" href="dashboard">Dashboard</a>
      <a class="nav-link text-danger" href="logout">Logout</a>
      
    </div>
  </div>
</nav>

<div class="container mt-5">
