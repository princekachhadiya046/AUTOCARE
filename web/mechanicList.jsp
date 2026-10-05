<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Mechanic" %>

<!DOCTYPE html>
<html>
<head>
    <title>Mechanic List - AUTOCARE</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 40px;
        }

        h1 {
            color: #222;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #222;
            color: white;
        }

        a {
            text-decoration: none;
            color: blue;
        }

        .add-button {
            display: inline-block;
            padding: 10px 15px;
            background-color: #222;
            color: white;
            text-decoration: none;
        }
    </style>
</head>

<body>

    <h1>AUTOCARE</h1>
    <h2>Mechanic List</h2>

    <a class="add-button" href="addMechanic.jsp">
        + Add New Mechanic
    </a>

    <table>

        <tr>
            <th>ID</th>
            <th>Full Name</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Specialization</th>
            <th>Experience</th>
            <th>Status</th>
            <th>Actions</th>
        </tr>

        <%
            List<Mechanic> mechanics =
                    (List<Mechanic>)
                    request.getAttribute("mechanics");

            if (mechanics != null && !mechanics.isEmpty()) {

                for (Mechanic mechanic : mechanics) {
        %>

        <tr>

            <td>
                <%= mechanic.getMechanicId() %>
            </td>

            <td>
                <%= mechanic.getFullName() %>
            </td>

            <td>
                <%= mechanic.getPhone() %>
            </td>

            <td>
                <%= mechanic.getEmail() %>
            </td>

            <td>
                <%= mechanic.getSpecialization() %>
            </td>

            <td>
                <%= mechanic.getExperienceYears() %> Years
            </td>

            <td>
                <%= mechanic.getStatus() %>
            </td>
            <td>

    <a href="editMechanic?id=<%= mechanic.getMechanicId() %>">
        Edit
    </a>

    &nbsp; | &nbsp;

    <a href="deleteMechanic?id=<%= mechanic.getMechanicId() %>"
       onclick="return confirm('Are you sure you want to delete this mechanic?');">
        Delete
    </a>

</td>

        </tr>

        <%
                }

            } else {
        %>

        <tr>
            <td colspan="8">
                No mechanics found.
            </td>
        </tr>

        <%
            }
        %>

    </table>

</body>
</html>