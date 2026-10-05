<%@ page import="model.Vehicle" %>

<%
    Vehicle vehicle =
        (Vehicle) request.getAttribute("vehicle");
%>

<!DOCTYPE html>
<html>

<head>

    <title>Edit Vehicle - AUTOCARE</title>

    <style>

        body {
            font-family: Arial, sans-serif;
            margin: 40px;
        }

        h1 {
            color: #222;
        }

        form {
            width: 450px;
        }

        label {
            display: block;
            margin-top: 15px;
            font-weight: bold;
        }

        input, select {
            width: 100%;
            padding: 9px;
            margin-top: 5px;
            box-sizing: border-box;
        }

        button {
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #222;
            color: white;
            border: none;
            cursor: pointer;
        }

        a {
            margin-left: 15px;
            color: blue;
            text-decoration: none;
        }

    </style>

</head>

<body>

    <h1>AUTOCARE</h1>

    <h2>Edit Vehicle</h2>

    <form action="updateVehicle" method="post">

        <input
            type="hidden"
            name="vehicleId"
            value="<%= vehicle.getVehicleId() %>"
        >

        <label>Customer ID</label>

        <input
            type="number"
            name="customerId"
            value="<%= vehicle.getCustomerId() %>"
            required
        >

        <label>Vehicle Number</label>

        <input
            type="text"
            name="vehicleNumber"
            value="<%= vehicle.getVehicleNumber() %>"
            required
        >

        <label>Brand</label>

        <input
            type="text"
            name="brand"
            value="<%= vehicle.getBrand() %>"
            required
        >

        <label>Model</label>

        <input
            type="text"
            name="model"
            value="<%= vehicle.getModel() %>"
            required
        >

        <label>Vehicle Type</label>

        <input
            type="text"
            name="vehicleType"
            value="<%= vehicle.getVehicleType() %>"
            required
        >

        <label>Manufacturing Year</label>

        <input
            type="number"
            name="manufacturingYear"
            value="<%= vehicle.getManufacturingYear() %>"
            required
        >

        <button type="submit">
            Update Vehicle
        </button>

        <a href="vehicles">
            Cancel
        </a>

    </form>

</body>

</html>