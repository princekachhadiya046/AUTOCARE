<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">

    <title>AUTOCARE - Vehicle Service & Garage Management</title>

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
            padding: 20px 50px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .logo {
            font-size: 28px;
            font-weight: bold;
        }

        .header span {
            font-size: 14px;
            color: #ccc;
        }

        .hero {
            min-height: 75vh;
            display: flex;
            justify-content: center;
            align-items: center;
            text-align: center;
            padding: 40px 20px;
        }

        .content {
            max-width: 800px;
        }

        .content h1 {
            font-size: 48px;
            margin-bottom: 15px;
        }

        .content h2 {
            font-size: 24px;
            font-weight: normal;
            color: #555;
            margin-bottom: 20px;
        }

        .content p {
            font-size: 17px;
            line-height: 1.6;
            color: #666;
            margin-bottom: 35px;
        }

        .buttons {
            display: flex;
            justify-content: center;
            gap: 15px;
            flex-wrap: wrap;
        }

        .button {
            display: inline-block;
            padding: 13px 28px;
            border-radius: 6px;
            text-decoration: none;
            font-weight: bold;
            font-size: 15px;
        }

        .primary {
            background: #111;
            color: white;
        }

        .primary:hover {
            background: #333;
        }

        .secondary {
            background: white;
            color: #111;
            border: 2px solid #111;
        }

        .secondary:hover {
            background: #eee;
        }

        .features {
            width: 90%;
            max-width: 1100px;
            margin: 0 auto 50px;
            display: grid;
            grid-template-columns: repeat(4, 1fr);
            gap: 20px;
        }

        .feature {
            background: white;
            padding: 25px;
            text-align: center;
            border-radius: 10px;
            box-shadow: 0 3px 12px rgba(0,0,0,0.08);
        }

        .feature h3 {
            margin-bottom: 10px;
        }

        .feature p {
            color: #666;
            font-size: 14px;
            line-height: 1.5;
        }

        .footer {
            background: #111;
            color: #ccc;
            text-align: center;
            padding: 18px;
            font-size: 13px;
        }

        @media (max-width: 900px) {

            .features {
                grid-template-columns: repeat(2, 1fr);
            }

        }

        @media (max-width: 600px) {

            .header {
                flex-direction: column;
                gap: 8px;
                text-align: center;
            }

            .content h1 {
                font-size: 36px;
            }

            .features {
                grid-template-columns: 1fr;
            }

        }

    </style>

</head>

<body>


<!-- HEADER -->

<div class="header">

    <div class="logo">
        AUTOCARE
    </div>

    <span>
        Vehicle Service & Garage Management System
    </span>

</div>


<!-- HERO SECTION -->

<div class="hero">

    <div class="content">

        <h1>
            AUTOCARE
        </h1>

        <h2>
            Smart Vehicle Service & Garage Management
        </h2>

        <p>
            Manage customers, vehicles, mechanics, service requests
            and invoices from one centralized garage management system.
        </p>


        <div class="buttons">

            <!-- DASHBOARD BUTTON -->

            <a href="dashboard"
               class="button primary">
                Open Dashboard
            </a>


            <!-- CUSTOMER BUTTON -->

            <a href="addCustomer.jsp"
               class="button secondary">
                Add Customer
            </a>

        </div>

    </div>

</div>


<!-- FEATURES -->

<div class="features">


    <div class="feature">

        <h3>
            👤 Customers
        </h3>

        <p>
            Manage customer information and contact details.
        </p>

    </div>


    <div class="feature">

        <h3>
            🚗 Vehicles
        </h3>

        <p>
            Track customer vehicles and their details.
        </p>

    </div>


    <div class="feature">

        <h3>
            🔧 Mechanics
        </h3>

        <p>
            Manage mechanics, specialization and experience.
        </p>

    </div>


    <div class="feature">

        <h3>
            🧾 Billing
        </h3>

        <p>
            Create and manage service invoices and payments.
        </p>

    </div>


</div>


<!-- FOOTER -->

<div class="footer">

    © 2026 AUTOCARE |
    Vehicle Service & Garage Management System

</div>


</body>
</html>