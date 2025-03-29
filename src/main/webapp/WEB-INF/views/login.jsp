<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String errorMessage = (String) request.getAttribute("errorMessage"); // Get error message from request
%>
<html>
<head>
    <title>User Login</title>
</head>
<body>
    <h2>Login</h2>

    <% if (errorMessage != null) { %>
        <p style="color: red;"><%= errorMessage %></p>
    <% } %>

    <form action="login" method="post">
        <label>Email:</label> <input type="email" name="email" required /><br>
        <label>Password:</label> <input type="password" name="password" required /><br>
        <button type="submit">Login</button>
    </form>
</body>
</html>
