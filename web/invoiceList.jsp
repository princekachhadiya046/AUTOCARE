<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Invoice" %>

<!DOCTYPE html>
<html>
<head>

    <title>Invoices - AUTOCARE</title>

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

    <h2>Invoices</h2>

    <a class="add-button" href="addInvoice.jsp">
        + Create Invoice
    </a>


    <table>

        <tr>

            <th>ID</th>

            <th>Service ID</th>

            <th>Vehicle Number</th>

            <th>Mechanic</th>

            <th>Service Type</th>

            <th>Invoice Date</th>

            <th>Subtotal</th>

            <th>Tax</th>

            <th>Discount</th>

            <th>Total</th>

            <th>Payment Status</th>

            <th>Payment Method</th>

            <th>Actions</th>

        </tr>


        <%

            List<Invoice> invoices =
                    (List<Invoice>)
                    request.getAttribute("invoices");


            if (invoices != null && !invoices.isEmpty()) {

                for (Invoice invoice : invoices) {

        %>


        <tr>

            <!-- Invoice ID -->

            <td>
                <%= invoice.getInvoiceId() %>
            </td>


            <!-- Service ID -->

            <td>
                <%= invoice.getServiceId() %>
            </td>


            <!-- Vehicle -->

            <td>
                <%= invoice.getVehicleNumber() %>
            </td>


            <!-- Mechanic -->

            <td>
                <%= invoice.getMechanicName() == null
                        ? "Not Assigned"
                        : invoice.getMechanicName() %>
            </td>


            <!-- Service Type -->

            <td>
                <%= invoice.getServiceType() %>
            </td>


            <!-- Invoice Date -->

            <td>
                <%= invoice.getInvoiceDate() %>
            </td>


            <!-- Subtotal -->

            <td>
                ₹ <%= String.format("%.2f",
                        invoice.getSubtotal()) %>
            </td>


            <!-- Tax -->

            <td>
                ₹ <%= String.format("%.2f",
                        invoice.getTaxAmount()) %>
            </td>


            <!-- Discount -->

            <td>
                ₹ <%= String.format("%.2f",
                        invoice.getDiscountAmount()) %>
            </td>


            <!-- Total -->

            <td>
                <strong>
                    ₹ <%= String.format("%.2f",
                            invoice.getTotalAmount()) %>
                </strong>
            </td>


            <!-- Payment Status -->

            <td>
                <%= invoice.getPaymentStatus() %>
            </td>


            <!-- Payment Method -->

            <td>
                <%= invoice.getPaymentMethod() == null
                        ? "-"
                        : invoice.getPaymentMethod() %>
            </td>


            <!-- Actions -->

            <td>

                <a href="editInvoice?id=<%= invoice.getInvoiceId() %>">
                    Edit
                </a>

                &nbsp; | &nbsp;

                <a href="deleteInvoice?id=<%= invoice.getInvoiceId() %>"
                   onclick="return confirm('Are you sure you want to delete this invoice?');">
                    Delete
                </a>

            </td>

        </tr>


        <%

                }

            } else {

        %>


        <tr>

            <td colspan="13">
                No invoices found.
            </td>

        </tr>


        <%

            }

        %>

    </table>

</body>

</html>