<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="model.User" %>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>User Management - AUTOCARE</title>

    <style>

        * {
            box-sizing: border-box;
        }

        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background: #f4f6f8;
            color: #222;
        }

        .header {
            background: #111;
            color: white;
            padding: 18px 40px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .logo {
            font-size: 26px;
            font-weight: bold;
        }

        .nav {
            display: flex;
            gap: 20px;
            align-items: center;
        }

        .nav a {
            color: white;
            text-decoration: none;
            font-size: 14px;
            font-weight: bold;
        }

        .nav a:hover {
            color: #ccc;
        }

        .container {
            width: 92%;
            max-width: 1200px;
            margin: 40px auto;
        }

        .top-section {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 25px;
        }

        h1 {
            margin: 0;
        }

        .add-button {
            background: #111;
            color: white;
            text-decoration: none;
            padding: 11px 20px;
            border-radius: 6px;
            font-weight: bold;
        }

        .add-button:hover {
            background: #333;
        }

        .table-container {
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 3px 12px rgba(0,0,0,0.08);
            overflow-x: auto;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th {
            background: #111;
            color: white;
            padding: 13px;
            text-align: left;
        }

        td {
            padding: 12px;
            border-bottom: 1px solid #ddd;
        }

        tr:hover {
            background: #f7f7f7;
        }

        .edit {
            color: #0066cc;
            text-decoration: none;
            font-weight: bold;
        }

        .delete {
            color: #d00000;
            text-decoration: none;
            font-weight: bold;
        }

        .empty {
            text-align: center;
            color: #777;
            padding: 25px;
        }

    </style>

</head>

<body>


<div class="header">

    <div class="logo">
        AUTOCARE
    </div>

    <div class="nav">

        <a href="dashboard">Dashboard</a>

        <a href="customers">Customers</a>

        <a href="vehicles">Vehicles</a>

        <a href="mechanics">Mechanics</a>

        <a href="services">Services</a>

        <a href="invoices">Invoices</a>

        <a href="logout">Logout</a>

    </div>

</div>


<div class="container">

    <div class="top-section">

        <h1>User Management</h1>

        <a href="addUser.jsp"
           class="add-button">
            + Add User
        </a>

    </div>


    <div class="table-container">

        <table>

            <thead>

                <tr>

                    <th>ID</th>

                    <th>Full Name</th>

                    <th>Email</th>

                    <th>Role</th>

                    <th>Actions</th>

                </tr>

            </thead>


            <tbody>

            <%
                List<User> users =
                        (List<User>) request.getAttribute("users");

                if (users != null && !users.isEmpty()) {

                    for (User user : users) {
            %>

                <tr>

                    <td>
                        <%= user.getUserId() %>
                    </td>

                    <td>
                        <%= user.getFullName() %>
                    </td>

                    <td>
                        <%= user.getEmail() %>
                    </td>

                    <td>
                        <%= user.getRole() %>
                    </td>

                    <td>

                        <a class="edit"
                           href="editUser?id=<%= user.getUserId() %>">
                            Edit
                        </a>

                        &nbsp; | &nbsp;

                        <a class="delete"
                           href="deleteUser?id=<%= user.getUserId() %>"
                           onclick="return confirm('Are you sure you want to delete this user?');">
                            Delete
                        </a>

                    </td>

                </tr>

            <%
                    }

                } else {
            %>

                <tr>

                    <td colspan="5"
                        class="empty">

                        No users found.

                    </td>

                </tr>

            <%
                }
            %>

            </tbody>

        </table>

    </div>

</div>


</body>

</html>