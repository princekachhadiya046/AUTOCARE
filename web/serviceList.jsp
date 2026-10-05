<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.ServiceRequest" %>

<!DOCTYPE html>
<html>
<head>
    <title>Service Requests - AUTOCARE</title>

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

        .add-button {
            display: inline-block;
            padding: 10px 15px;
            background-color: #222;
            color: white;
            text-decoration: none;
        }
    </style>
</head>

<body>

    <h1>AUTOCARE</h1>
    <h2>Service Requests</h2>

    <a class="add-button" href="addService.jsp">
        + Add Service Request
    </a>

    <table>

        <tr>
            <th>ID</th>
            <th>Vehicle ID</th>
            <th>Vehicle Number</th>
            <th>Assigned Mechanic</th>
            <th>Service Type</th>
            <th>Service Date</th>
            <th>Description</th>
            <th>Status</th>
            <th>Estimated Cost</th>
            <th>Actions</th>
        </tr>

        <%
            List<ServiceRequest> services =
                    (List<ServiceRequest>)
                    request.getAttribute("services");

            if (services != null && !services.isEmpty()) {

                for (ServiceRequest service : services) {
        %>

        <tr>

            <!-- ID -->
            <td>
                <%= service.getServiceId() %>
            </td>

            <!-- Vehicle ID -->
            <td>
                <%= service.getVehicleId() %>
            </td>

            <!-- Vehicle Number -->
            <td>
                <%= service.getVehicleNumber() %>
            </td>

            <!-- Assigned Mechanic -->
            <td>
                <%= service.getMechanicName() == null
                        ? "Not Assigned"
                        : service.getMechanicName() %>
            </td>

            <!-- Service Type -->
            <td>
                <%= service.getServiceType() %>
            </td>

            <!-- Service Date -->
            <td>
                <%= service.getServiceDate() %>
            </td>

            <!-- Description -->
            <td>
                <%= service.getDescription() %>
            </td>

            <!-- Status -->
            <td>
                <%= service.getStatus() %>
            </td>

            <!-- Estimated Cost -->
            <td>
                ₹ <%= String.format("%.2f",
                        service.getEstimatedCost()) %>
            </td>

            <!-- Actions -->
            <td>
                <a href="editService?id=<%= service.getServiceId() %>">
                    Edit
                </a>

                &nbsp; | &nbsp;

                <a href="deleteService?id=<%= service.getServiceId() %>"
                   onclick="return confirm('Are you sure you want to delete this service request?');">
                    Delete
                </a>
            </td>

        </tr>

        <%
                }

            } else {
        %>

        <tr>
            <td colspan="10">
                No service requests found.
            </td>
        </tr>

        <%
            }
        %>

    </table>

</body>
</html>