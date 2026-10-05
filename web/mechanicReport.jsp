<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.util.List" %>
<%@ page import="model.Mechanic" %>
<%@ page import="dao.MechanicReportDAO" %>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Mechanic Performance - AUTOCARE</title>

    <style>

        * {
            box-sizing: border-box;
        }

        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background: #f4f6f8;
            color: #111;
        }

        .header {
            background: #111;
            color: white;
            height: 65px;
            display: flex;
            align-items: center;
            justify-content: space-between;
            padding: 0 28px;
        }

        .logo {
            font-size: 22px;
            font-weight: bold;
        }

        .nav {
            display: flex;
            gap: 18px;
        }

        .nav a {
            color: white;
            text-decoration: none;
            font-size: 13px;
            font-weight: bold;
        }

        .nav a:hover {
            text-decoration: underline;
        }

        .container {
            width: 95%;
            max-width: 1250px;
            margin: 35px auto;
        }

        h1 {
            margin-bottom: 25px;
        }

        .table-container {
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 3px 12px rgba(0,0,0,0.08);
            overflow-x: auto;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            min-width: 950px;
        }

        th {
            background: #111;
            color: white;
            padding: 14px 10px;
            text-align: center;
            font-size: 13px;
        }

        td {
            padding: 13px 10px;
            text-align: center;
            border-bottom: 1px solid #ddd;
            font-size: 13px;
        }

        tr:hover {
            background: #f5f5f5;
        }

        .status {
            font-weight: bold;
        }

        .buttons {
            margin-top: 25px;
        }

        .btn {
            display: inline-block;
            background: #111;
            color: white;
            text-decoration: none;
            padding: 11px 18px;
            border-radius: 5px;
            font-size: 14px;
            margin-right: 8px;
        }

        .btn:hover {
            background: #333;
        }

        .empty {
            text-align: center;
            padding: 30px;
            color: #666;
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

            <a href="users">Users</a>

            <a href="reports">Reports</a>

            <a href="revenueReport">Revenue</a>

            <a href="paymentReport">Payment</a>

            <a href="logout">Logout</a>

        </div>

    </div>


    <div class="container">

        <h1>Mechanic Performance Report</h1>


        <div class="table-container">

            <table>

                <thead>

                    <tr>

                        <th>Mechanic ID</th>

                        <th>Mechanic Name</th>

                        <th>Specialization</th>

                        <th>Experience</th>

                        <th>Status</th>

                        <th>Total Services</th>

                        <th>Completed</th>

                        <th>Pending</th>

                        <th>In Progress</th>

                        <th>Cancelled</th>

                    </tr>

                </thead>

                <tbody>

                    <%

                        List<Mechanic> mechanics =
                                (List<Mechanic>)
                                request.getAttribute("mechanics");

                        MechanicReportDAO dao =
                                (MechanicReportDAO)
                                request.getAttribute("dao");

                        if (mechanics != null
                                && !mechanics.isEmpty()) {

                            for (Mechanic mechanic : mechanics) {

                                int mechanicId =
                                        mechanic.getMechanicId();

                                int totalServices =
                                        dao.getTotalServices(
                                                mechanicId
                                        );

                                int completedServices =
                                        dao.getCompletedServices(
                                                mechanicId
                                        );

                                int pendingServices =
                                        dao.getPendingServices(
                                                mechanicId
                                        );

                                int inProgressServices =
                                        dao.getInProgressServices(
                                                mechanicId
                                        );

                                int cancelledServices =
                                        dao.getCancelledServices(
                                                mechanicId
                                        );
                    %>

                    <tr>

                        <td>
                            <%= mechanicId %>
                        </td>

                        <td>
                            <%= mechanic.getFullName() %>
                        </td>

                        <td>
                            <%= mechanic.getSpecialization() %>
                        </td>

                        <td>
                            <%= mechanic.getExperienceYears() %> Years
                        </td>

                        <td class="status">
                            <%= mechanic.getStatus() %>
                        </td>

                        <td>
                            <%= totalServices %>
                        </td>

                        <td>
                            <%= completedServices %>
                        </td>

                        <td>
                            <%= pendingServices %>
                        </td>

                        <td>
                            <%= inProgressServices %>
                        </td>

                        <td>
                            <%= cancelledServices %>
                        </td>

                    </tr>

                    <%

                            }

                        } else {

                    %>

                    <tr>

                        <td colspan="10" class="empty">
                            No mechanic data available.
                        </td>

                    </tr>

                    <%

                        }

                    %>

                </tbody>

            </table>

        </div>


        <div class="buttons">

            <a href="reports" class="btn">
                ← Service Reports
            </a>

            <a href="dashboard" class="btn">
                Dashboard
            </a>

        </div>

    </div>

</body>

</html>