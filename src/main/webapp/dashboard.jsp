<%@ include file="layout/header.jsp" %>

<div class="container mt-4">
    <h2 class="mb-4">Dashboard</h2>

    <div class="row g-4">

        <!-- Students -->
        <div class="col-md-4">
            <div class="card shadow-sm border-0">
                <div class="card-body text-center">
                    <h5>Total Students</h5>
                    <h2 class="text-primary">${totalStudents}</h2>
                </div>
            </div>
        </div>

        <!-- Courses -->
        <div class="col-md-4">
            <div class="card shadow-sm border-0">
                <div class="card-body text-center">
                    <h5>Total Courses</h5>
                    <h2 class="text-success">${totalCourses}</h2>
                </div>
            </div>
        </div>

        <!-- Faculty -->
        <div class="col-md-4">
            <div class="card shadow-sm border-0">
                <div class="card-body text-center">
                    <h5>Total Faculty</h5>
                    <h2 class="text-warning">${totalFaculty}</h2>
                </div>
            </div>
        </div>

    </div>

    <!-- Quick Actions -->
    <div class="mt-5">
        <h4>Quick Actions</h4>
        <a href="addStudent" class="btn btn-primary me-2">Add Student</a>
        <a href="viewStudents" class="btn btn-outline-primary">View Students</a>
    </div>
</div>

<%@ include file="layout/footer.jsp" %>
