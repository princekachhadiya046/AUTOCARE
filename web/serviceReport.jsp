<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Service Reports - AUTOCARE</title>

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

        h1 {
            margin-bottom: 30px;
        }

        .cards {
            display: grid;
            grid-template-columns:
                repeat(5, 1fr);

            gap: 20px;
            margin-bottom: 35px;
        }

        .card {
            background: white;
            padding: 25px;
            border-radius: 10px;
            text-align: center;
            box-shadow:
                0 3px 12px
                rgba(0,0,0,0.08);
        }

        .card h3 {
            margin: 0 0 12px;
            font-size: 15px;
            color: #555;
        }

        .number {
            font-size: 32px;
            font-weight: bold;
        }

        .report-box {
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow:
                0 3px 12px
                rgba(0,0,0,0.08);
        }

        .report-box h2 {
            margin-top: 0;
        }

        .row {
            display: flex;
            justify-content: space-between;
            padding: 15px 0;
            border-bottom: 1px solid #ddd;
        }

        .row:last-child {
            border-bottom: none;
        }

        .label {
            font-weight: bold;
        }

        .value {
            font-weight: bold;
        }

        .back-button {
            display: inline-block;
            margin-top: 25px;
            padding: 11px 20px;
            background: #111;
            color: white;
            text-decoration: none;
            border-radius: 6px;
            font-weight: bold;
        }

        .back-button:hover {
            background: #333;
        }

        @media (max-width: 1000px) {

            .cards {
                grid-template-columns:
                    repeat(3, 1fr);
            }

        }

        @media (max-width: 650px) {

            .header {
                flex-direction: column;
                gap: 12px;
                text-align: center;
            }

            .nav {
                flex-wrap: wrap;
                justify-content: center;
            }

            .cards {
                grid-template-columns: 1fr;
            }

        }

    </style>

</head>

<body>


<div class="header">

    <div class="logo">
        AUTOCARE
    </div>

    <div class="nav">

        <a href="dashboard">
            Dashboard
        </a>

        <a href="customers">
            Customers
        </a>

        <a href="vehicles">
            Vehicles
        </a>

        <a href="mechanics">
            Mechanics
        </a>

        <a href="services">
            Services
        </a>

        <a href="invoices">
            Invoices
        </a>

        <a href="users">
            Users
        </a>

        <a href="logout">
            Logout
        </a>

    </div>

</div>


<div class="container">

    <h1>
        Service Reports
    </h1>


    <div class="cards">


        <div class="card">

            <h3>
                Total Services
            </h3>

            <div class="number">
                <%= request.getAttribute(
                        "totalServices") %>
            </div>

        </div>


        <div class="card">

            <h3>
                Pending
            </h3>

            <div class="number">
                <%= request.getAttribute(
                        "pendingServices") %>
            </div>

        </div>


        <div class="card">

            <h3>
                In Progress
            </h3>

            <div class="number">
                <%= request.getAttribute(
                        "inProgressServices") %>
            </div>

        </div>


        <div class="card">

            <h3>
                Completed
            </h3>

            <div class="number">
                <%= request.getAttribute(
                        "completedServices") %>
            </div>

        </div>


        <div class="card">

            <h3>
                Cancelled
            </h3>

            <div class="number">
                <%= request.getAttribute(
                        "cancelledServices") %>
            </div>

        </div>


    </div>


    <div class="report-box">

        <h2>
            Service Status Summary
        </h2>


        <div class="row">

            <span class="label">
                Total Services
            </span>

            <span class="value">
                <%= request.getAttribute(
                        "totalServices") %>
            </span>

        </div>


        <div class="row">

            <span class="label">
                Pending Services
            </span>

            <span class="value">
                <%= request.getAttribute(
                        "pendingServices") %>
            </span>

        </div>


        <div class="row">

            <span class="label">
                In Progress Services
            </span>

            <span class="value">
                <%= request.getAttribute(
                        "inProgressServices") %>
            </span>

        </div>


        <div class="row">

            <span class="label">
                Completed Services
            </span>

            <span class="value">
                <%= request.getAttribute(
                        "completedServices") %>
            </span>

        </div>


        <div class="row">

            <span class="label">
                Cancelled Services
            </span>

            <span class="value">
                <%= request.getAttribute(
                        "cancelledServices") %>
            </span>

        </div>


        <a href="dashboard"
           class="back-button">
            ← Back to Dashboard
        </a>

    </div>

</div>


</body>

</html>