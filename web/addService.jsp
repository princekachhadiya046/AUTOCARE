<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="util.DBConnection" %>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Add Service - AUTOCARE</title>

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
            width: 90%;
            max-width: 700px;
            margin: 40px auto;
        }

        .form-box {
            background: white;
            padding: 35px;
            border-radius: 12px;
            box-shadow: 0 3px 15px rgba(0,0,0,0.08);
        }

        h1 {
            text-align: center;
            margin-top: 0;
            margin-bottom: 30px;
        }

        label {
            display: block;
            font-weight: bold;
            margin-top: 15px;
            margin-bottom: 7px;
        }

        input,
        select,
        textarea {
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 14px;
            font-family: Arial, sans-serif;
        }

        textarea {
            min-height: 100px;
            resize: vertical;
        }

        input:focus,
        select:focus,
        textarea:focus {
            outline: none;
            border-color: #111;
        }

        .buttons {
            display: flex;
            gap: 12px;
            margin-top: 25px;
        }

        button,
        .cancel {
            flex: 1;
            padding: 13px;
            border-radius: 6px;
            font-weight: bold;
            font-size: 14px;
            text-align: center;
            text-decoration: none;
            cursor: pointer;
        }

        button {
            background: #111;
            color: white;
            border: none;
        }

        button:hover {
            background: #333;
        }

        .cancel {
            background: white;
            color: #111;
            border: 1px solid #111;
        }

        .cancel:hover {
            background: #eee;
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

        <a href="logout">
            Logout
        </a>

    </div>

</div>


<div class="container">

    <div class="form-box">

        <h1>
            Add Service Request
        </h1>


        <form action="addService" method="post">


            <!-- VEHICLE -->

            <label>
                Vehicle
            </label>

            <select name="vehicleId" required>

                <option value="">
                    Select Vehicle
                </option>

                <%
                    Connection con = null;
                    PreparedStatement ps = null;
                    ResultSet rs = null;

                    try {

                        con = DBConnection.getConnection();

                        String vehicleSql =
                                "SELECT v.vehicle_id, "
                              + "v.vehicle_number, "
                              + "v.brand, "
                              + "v.model, "
                              + "c.full_name "
                              + "FROM vehicles v "
                              + "JOIN customers c "
                              + "ON v.customer_id = c.customer_id "
                              + "ORDER BY v.vehicle_id";

                        ps = con.prepareStatement(
                                vehicleSql
                        );

                        rs = ps.executeQuery();

                        while (rs.next()) {
                %>

                    <option value="<%= rs.getInt("vehicle_id") %>">

                        <%= rs.getString("vehicle_number") %>
                        -
                        <%= rs.getString("brand") %>
                        <%= rs.getString("model") %>
                        -
                        <%= rs.getString("full_name") %>

                    </option>

                <%
                        }

                    } catch (Exception e) {

                        e.printStackTrace();

                    } finally {

                        try {
                            if (rs != null) rs.close();
                            if (ps != null) ps.close();
                            if (con != null) con.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                %>

            </select>


            <!-- MECHANIC -->

            <label>
                Assign Mechanic
            </label>

            <select name="mechanicId" required>

                <option value="">
                    Select Mechanic
                </option>

                <%
                    Connection mechanicCon = null;
                    PreparedStatement mechanicPs = null;
                    ResultSet mechanicRs = null;

                    try {

                        mechanicCon =
                                DBConnection.getConnection();

                        String mechanicSql =
                                "SELECT mechanic_id, "
                              + "full_name, "
                              + "specialization "
                              + "FROM mechanics "
                              + "WHERE status = 'ACTIVE' "
                              + "ORDER BY full_name";

                        mechanicPs =
                                mechanicCon.prepareStatement(
                                        mechanicSql
                                );

                        mechanicRs =
                                mechanicPs.executeQuery();

                        while (mechanicRs.next()) {
                %>

                    <option value="<%= mechanicRs.getInt("mechanic_id") %>">

                        <%= mechanicRs.getString("full_name") %>

                        -
                        <%= mechanicRs.getString("specialization") %>

                    </option>

                <%
                        }

                    } catch (Exception e) {

                        e.printStackTrace();

                    } finally {

                        try {
                            if (mechanicRs != null)
                                mechanicRs.close();

                            if (mechanicPs != null)
                                mechanicPs.close();

                            if (mechanicCon != null)
                                mechanicCon.close();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                %>

            </select>


            <!-- SERVICE TYPE -->

            <label>
                Service Type
            </label>

            <select name="serviceType" required>

                <option value="">
                    Select Service Type
                </option>

                <option value="General Service">
                    General Service
                </option>

                <option value="Oil Change">
                    Oil Change
                </option>

                <option value="Brake Service">
                    Brake Service
                </option>

                <option value="Engine Repair">
                    Engine Repair
                </option>

                <option value="AC Service">
                    AC Service
                </option>

                <option value="Tyre Service">
                    Tyre Service
                </option>

                <option value="Battery Service">
                    Battery Service
                </option>

                <option value="Other">
                    Other
                </option>

            </select>


            <!-- SERVICE DATE -->

            <label>
                Service Date
            </label>

            <input type="date"
                   name="serviceDate"
                   required>


            <!-- DESCRIPTION -->

            <label>
                Description
            </label>

            <textarea name="description"
                      placeholder="Enter service details"></textarea>


            <!-- STATUS -->

            <label>
                Status
            </label>

            <select name="status" required>

                <option value="PENDING">
                    PENDING
                </option>

                <option value="IN PROGRESS">
                    IN PROGRESS
                </option>

                <option value="COMPLETED">
                    COMPLETED
                </option>

                <option value="CANCELLED">
                    CANCELLED
                </option>

            </select>


            <!-- ESTIMATED COST -->

            <label>
                Estimated Cost
            </label>

            <input type="number"
                   name="estimatedCost"
                   step="0.01"
                   min="0"
                   placeholder="Enter estimated cost"
                   required>


            <!-- BUTTONS -->

            <div class="buttons">

                <button type="submit">
                    Create Service
                </button>

                <a href="services"
                   class="cancel">
                    Cancel
                </a>

            </div>


        </form>

    </div>

</div>


</body>

</html>