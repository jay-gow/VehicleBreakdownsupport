<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String errorMessage = (String) request.getAttribute("errorMessage");
    String successMessage = (String) request.getAttribute("successMessage");
%>
<!DOCTYPE html>
<html>
<head>
    <title>User Registration</title>
</head>
<body>
    <h2>Register</h2>

    <% if (errorMessage != null) { %>
        <p style="color: red;"><%= errorMessage %></p>
    <% } %>

    <% if (successMessage != null) { %>
        <p style="color: green;"><%= successMessage %></p>
        <script>
            // Redirect to login page after 2 seconds
            setTimeout(function() {
                window.location.href = "<%= request.getContextPath() %>/login";
            }, 2000);
        </script>
    <% } %>

    <form action="<%= request.getContextPath() %>/users/register" method="post">
        <label>Name:</label> <input type="text" name="name" required /><br>
        <label>Email:</label> <input type="email" name="email" required /><br>
        <label>Phone:</label> <input type="text" name="phone" required /><br>
        <label>Password:</label> <input type="password" name="password" required /><br>
        <label>Confirm Password:</label> <input type="password" name="confirmPassword" required /><br>
        <button type="submit">Register</button>
    </form>

    <p>Already have an account? <a href="<%= request.getContextPath() %>/login">Login here</a></p>
</body>
</html>
