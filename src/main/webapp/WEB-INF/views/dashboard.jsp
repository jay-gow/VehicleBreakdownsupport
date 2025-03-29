<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.vechicle.breakdown.model.Breakdown" %> <!-- Import your model class -->
<%
    // Retrieve user and breakdown list from session
    Object userObj = session.getAttribute("user");
    List<Breakdown> breakdowns = (List<Breakdown>) session.getAttribute("breakdowns");
%>
<html>
<head>
    <title>User Dashboard</title>
</head>
<body>
	<h2>Welcome, <%= (userObj != null) ? ((com.vechicle.breakdown.model.Users) userObj).getName() : "Guest" %>!</h2>
	<p>Email: <%= (userObj != null) ? ((com.vechicle.breakdown.model.Users) userObj).getEmail() : "N/A" %></p>
	<p>Phone: <%= (userObj != null) ? ((com.vechicle.breakdown.model.Users) userObj).getPhone() : "N/A" %></p>


    <h3>Submit Breakdown Request</h3>
    <form action="submit-breakdown" method="post">
        <label>Location:</label> <input type="text" name="location" required /><br>
        <label>Vehicle Type:</label> <input type="text" name="vehicleType" required /><br>
        <label>Issue:</label> <input type="text" name="issue" required /><br>
        <button type="submit">Submit Request</button>
    </form>

    <h3>Your Breakdown Requests</h3>
    <table border="1">
        <tr>
            <th>Location</th>
            <th>Vehicle Type</th>
            <th>Issue</th>
            <th>Status</th>
        </tr>
        <% if (breakdowns != null) { 
            for (Breakdown breakdown : breakdowns) { %>
                <tr>
                    <td><%= breakdown.getLocation() %></td>
                    <td><%= breakdown.getVehicleType() %></td>
                    <td><%= breakdown.getIssue() %></td>
                    <td><%= breakdown.getStatus() %></td>
                </tr>
        <%  } 
        } else { %>
            <tr><td colspan="4">No breakdown requests found.</td></tr>
        <% } %>
    </table>
 <form action="index.jsp">
 <input type="submit" value="LOGOUT">
 
    </form>
</body>
</html>
