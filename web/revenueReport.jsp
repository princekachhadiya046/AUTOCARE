<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">

    <title>Revenue Report - AUTOCARE</title>

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
            gap: 20px;
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

            <a href="logout">Logout</a>

        </div>

    </div>


    <div class="container">

        <h1>Revenue Report</h1>


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
                    Total Revenue
                </div>

                <div class="card-value">
                    ₹ <%= String.format("%.2f",
                            request.getAttribute("totalRevenue")) %>
                </div>

            </div>


            <div class="card">

                <div class="card-title">
                    Paid Revenue
                </div>

                <div class="card-value">
                    ₹ <%= String.format("%.2f",
                            request.getAttribute("paidRevenue")) %>
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
                    Total Discount
                </div>

                <div class="card-value">
                    ₹ <%= String.format("%.2f",
                            request.getAttribute("totalDiscount")) %>
                </div>

            </div>


            <div class="card">

                <div class="card-title">
                    Total Tax
                </div>

                <div class="card-value">
                    ₹ <%= String.format("%.2f",
                            request.getAttribute("totalTax")) %>
                </div>

            </div>

        </div>


        <div class="summary">

            <h2>Revenue Summary</h2>


            <div class="row">

                <span class="label">
                    Total Invoices
                </span>

                <span class="value">
                    <%= request.getAttribute("totalInvoices") %>
                </span>

            </div>


            <div class="row">

                <span class="label">
                    Total Revenue
                </span>

                <span class="value">
                    ₹ <%= String.format("%.2f",
                            request.getAttribute("totalRevenue")) %>
                </span>

            </div>


            <div class="row">

                <span class="label">
                    Paid Revenue
                </span>

                <span class="value">
                    ₹ <%= String.format("%.2f",
                            request.getAttribute("paidRevenue")) %>
                </span>

            </div>


            <div class="row">

                <span class="label">
                    Unpaid Amount
                </span>

                <span class="value">
                    ₹ <%= String.format("%.2f",
                            request.getAttribute("unpaidAmount")) %>
                </span>

            </div>


            <div class="row">

                <span class="label">
                    Total Discount
                </span>

                <span class="value">
                    ₹ <%= String.format("%.2f",
                            request.getAttribute("totalDiscount")) %>
                </span>

            </div>


            <div class="row">

                <span class="label">
                    Total Tax
                </span>

                <span class="value">
                    ₹ <%= String.format("%.2f",
                            request.getAttribute("totalTax")) %>
                </span>

            </div>


            <div class="buttons">

                <a href="reports" class="btn">
                    ← Service Reports
                </a>

                <a href="dashboard" class="btn">
                    Back to Dashboard
                </a>

            </div>

        </div>

    </div>

</body>
</html>