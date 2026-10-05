<%@ page import="java.util.List" %>
<%@ page import="model.Vehicle" %>

<!DOCTYPE html>
<html>

<head>

    <title>Vehicle List - AUTOCARE</title>

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

    </style>

</head>

<body>

    <h1>AUTOCARE</h1>

    <h2>Vehicle List</h2>

    <a href="addVehicle.jsp">
        + Add New Vehicle
    </a>

    <table>

        <tr>

            <th>ID</th>
            <th>Customer ID</th>
            <th>Vehicle Number</th>
            <th>Brand</th>
            <th>Model</th>
            <th>Type</th>
            <th>Year</th>
            <th>Customer</th>
            <th>Actions</th>

        </tr>

        <%

            List<Vehicle> vehicles =
                    (List<Vehicle>)
                    request.getAttribute("vehicles");

            if (vehicles != null && !vehicles.isEmpty()) {

                for (Vehicle vehicle : vehicles) {

        %>

        <tr>

            <td>
                <%= vehicle.getVehicleId() %>
            </td>

            <td>
                <%= vehicle.getCustomerId() %>
            </td>

            <td>
                <%= vehicle.getVehicleNumber() %>
            </td>

            <td>
                <%= vehicle.getBrand() %>
            </td>

            <td>
                <%= vehicle.getModel() %>
            </td>

            <td>
                <%= vehicle.getVehicleType() %>
            </td>

            <td>
                <%= vehicle.getManufacturingYear() %>
            </td>

            <td>
                <%= vehicle.getCustomerName() %>
            </td>
            <td>
                <a href="editVehicle?id=<%= vehicle.getVehicleId() %>">
                    Edit
                </a>

                &nbsp; | &nbsp;

                <a href="deleteVehicle?id=<%= vehicle.getVehicleId() %>"
                    onclick="return confirm('Are you sure you want to delete this vehicle?');">
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
                No vehicles found.
            </td>

        </tr>

        <%

            }

        %>

    </table>

</body>

</html>