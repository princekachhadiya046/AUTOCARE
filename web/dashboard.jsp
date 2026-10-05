<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">

    <title>AUTOCARE - Dashboard</title>

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
            padding: 20px 35px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .header h1 {
            margin: 0;
            font-size: 28px;
        }

        .header span {
            font-size: 14px;
            color: #ccc;
        }

        .container {
            width: 92%;
            margin: 30px auto;
        }

        .welcome {
            margin-bottom: 25px;
        }

        .welcome h2 {
            margin: 0 0 8px;
        }

        .welcome p {
            color: #666;
            margin: 0;
        }

        .cards {
            display: grid;
            grid-template-columns: repeat(4, 1fr);
            gap: 20px;
        }

        .card {
            background: white;
            padding: 25px;
            border-radius: 12px;
            box-shadow: 0 3px 12px rgba(0,0,0,0.08);
        }

        .card h3 {
            margin: 0;
            font-size: 15px;
            color: #777;
        }

        .number {
            font-size: 32px;
            font-weight: bold;
            margin-top: 12px;
        }

        .revenue {
            color: #111;
        }

        .section {
            margin-top: 35px;
        }

        .section h2 {
            margin-bottom: 20px;
        }

        .actions {
            display: grid;
            grid-template-columns: repeat(4, 1fr);
            gap: 15px;
        }

        .action {
            background: #111;
            color: white;
            text-decoration: none;
            text-align: center;
            padding: 15px;
            border-radius: 8px;
            font-weight: bold;
        }

        .action:hover {
            background: #333;
        }

        .back {
            display: inline-block;
            margin-top: 25px;
            color: #222;
            text-decoration: none;
            font-weight: bold;
        }

        @media (max-width: 900px) {

            .cards {
                grid-template-columns: repeat(2, 1fr);
            }

            .actions {
                grid-template-columns: repeat(2, 1fr);
            }
        }

        @media (max-width: 600px) {

            .cards,
            .actions {
                grid-template-columns: 1fr;
            }
        }
.logo {
    font-size: 26px;
    font-weight: bold;
}

.nav {
    display: flex;
    gap: 25px;
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
        <a href="reports">Reports</a>
        <a href="revenueReport">Revenue</a>
        <a href="paymentReport">Payment</a>
        <a href="mechanicReport">Mechanic</a>
        <a href="logout"
   onclick="return confirm('Are you sure you want to logout?');">
    Logout
</a>

    </div>

</div>

<div class="container">

    <div class="welcome">

        <h2>Dashboard</h2>

        <p>
            Overview of your garage management system
        </p>

    </div>


    <!-- STATISTICS -->

    <div class="cards">

        <div class="card">

            <h3>Total Customers</h3>

            <div class="number">
                <%= request.getAttribute("totalCustomers") %>
            </div>

        </div>


        <div class="card">

            <h3>Total Vehicles</h3>

            <div class="number">
                <%= request.getAttribute("totalVehicles") %>
            </div>

        </div>


        <div class="card">

            <h3>Total Mechanics</h3>

            <div class="number">
                <%= request.getAttribute("totalMechanics") %>
            </div>

        </div>


        <div class="card">

            <h3>Total Services</h3>

            <div class="number">
                <%= request.getAttribute("totalServices") %>
            </div>

        </div>


        <div class="card">

            <h3>Pending Services</h3>

            <div class="number">
                <%= request.getAttribute("pendingServices") %>
            </div>

        </div>


        <div class="card">

            <h3>Completed Services</h3>

            <div class="number">
                <%= request.getAttribute("completedServices") %>
            </div>

        </div>


        <div class="card">

            <h3>Total Invoices</h3>

            <div class="number">
                <%= request.getAttribute("totalInvoices") %>
            </div>

        </div>


        <div class="card">

            <h3>Total Revenue</h3>

            <div class="number revenue">
                ₹ <%= String.format("%.2f",
                        request.getAttribute("totalRevenue")) %>
            </div>

        </div>

    </div>


    <!-- QUICK ACTIONS -->

    <div class="section">

        <h2>Quick Actions</h2>

        <div class="actions">

            <a class="action" href="addCustomer.jsp">
                + Add Customer
            </a>

            <a class="action" href="addVehicle.jsp">
                + Add Vehicle
            </a>

            <a class="action" href="addMechanic.jsp">
                + Add Mechanic
            </a>

            <a class="action" href="addService.jsp">
                + New Service
            </a>

            <a class="action" href="addInvoice.jsp">
                + Create Invoice
            </a>

            <a class="action" href="customers">
                Customer List
            </a>

            <a class="action" href="vehicles">
                Vehicle List
            </a>

            <a class="action" href="services">
                Service List
            </a>

        </div>

    </div>


    <a class="back" href="index.jsp">
        ← Back to Home
    </a>

</div>

</body>
</html>