<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">

    <title>Payment Report - AUTOCARE</title>

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
            width: 90%;
            max-width: 1100px;
            margin: 35px auto;
        }

        h1 {
            margin-bottom: 25px;
        }

        .cards {
            display: grid;
            grid-template-columns: repeat(3, 1fr);
            gap: 18px;
            margin-bottom: 25px;
        }

        .card {
            background: white;
            padding: 25px;
            border-radius: 8px;
            box-shadow: 0 3px 12px rgba(0,0,0,0.08);
            text-align: center;
        }

        .card-title {
            font-size: 14px;
            margin-bottom: 12px;
            color: #555;
        }

        .card-value {
            font-size: 27px;
            font-weight: bold;
        }

        .summary {
            background: white;
            padding: 25px;
            border-radius: 8px;
            box-shadow: 0 3px 12px rgba(0,0,0,0.08);
        }

        .summary h2 {
            margin-top: 0;
            margin-bottom: 20px;
        }

        .row {
            display: flex;
            justify-content: space-between;
            padding: 14px 0;
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

        @media (max-width: 800px) {

            .cards {
                grid-template-columns: 1fr;
            }

            .nav {
                gap: 8px;
            }

            .nav a {
                font-size: 11px;
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

            <a href="dashboard">Dashboard</a>
            <a href="customers">Customers</a>
            <a href="vehicles">Vehicles</a>
            <a href="mechanics">Mechanics</a>
            <a href="services">Services</a>
            <a href="invoices">Invoices</a>
            <a href="users">Users</a>
            <a href="reports">Reports</a>
            <a href="revenueReport">Revenue</a>
            <a href="logout">Logout</a>

        </div>

    </div>


    <div class="container">

        <h1>Payment Report</h1>


        <div class="cards">

            <div class="card">

                <div class="card-title">
                    Total Invoices
                </div>

                <div class="card-value">
                    <%= request.getAttribute("totalInvoices") %>
                </div>

            </div>


            <div class="card">

                <div class="card-title">
                    Paid Invoices
                </div>

                <div class="card-value">
                    <%= request.getAttribute("paidInvoices") %>
                </div>

            </div>


            <div class="card">

                <div class="card-title">
                    Unpaid Invoices
                </div>

                <div class="card-value">
                    <%= request.getAttribute("unpaidInvoices") %>
                </div>

            </div>


            <div class="card">

                <div class="card-title">
                    Paid Amount
                </div>

                <div class="card-value">
                    ₹ <%= String.format("%.2f",
                            request.getAttribute("paidAmount")) %>
                </div>

            </div>


            <div class="card">

                <div class="card-title">
                    Unpaid Amount
                </div>

                <div class="card-value">
                    ₹ <%= String.format("%.2f",
                            request.getAttribute("unpaidAmount")) %>
                </div>

            </div>


            <div class="card">

                <div class="card-title">
                    Cash Payments
                </div>

                <div class="card-value">
                    ₹ <%= String.format("%.2f",
                            request.getAttribute("cashAmount")) %>
                </div>

            </div>

        </div>


        <div class="summary">

            <h2>Payment Method Summary</h2>


            <div class="row">

                <span class="label">
                    Cash Payments
                </span>

                <span class="value">
                    ₹ <%= String.format("%.2f",
                            request.getAttribute("cashAmount")) %>
                </span>

            </div>


            <div class="row">

                <span class="label">
                    Card Payments
                </span>

                <span class="value">
                    ₹ <%= String.format("%.2f",
                            request.getAttribute("cardAmount")) %>
                </span>

            </div>


            <div class="row">

                <span class="label">
                    Online Payments
                </span>

                <span class="value">
                    ₹ <%= String.format("%.2f",
                            request.getAttribute("onlineAmount")) %>
                </span>

            </div>


            <div class="row">

                <span class="label">
                    Total Paid Amount
                </span>

                <span class="value">
                    ₹ <%= String.format("%.2f",
                            request.getAttribute("paidAmount")) %>
                </span>

            </div>


            <div class="buttons">

                <a href="reports" class="btn">
                    ← Service Reports
                </a>

                <a href="revenueReport" class="btn">
                    Revenue Report
                </a>

                <a href="dashboard" class="btn">
                    Dashboard
                </a>

            </div>

        </div>

    </div>

</body>
</html>