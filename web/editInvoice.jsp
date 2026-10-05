<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ page import="model.Invoice"%>

<%
    Invoice invoice =
            (Invoice) request.getAttribute("invoice");

    if (invoice == null) {
        response.sendRedirect("invoices");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">

    <title>Edit Invoice - AUTOCARE</title>

    <style>

        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 40px;
        }

        .container {
            width: 550px;
            margin: auto;
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px #ccc;
        }

        h2 {
            text-align: center;
            margin-bottom: 25px;
        }

        label {
            font-weight: bold;
            display: block;
            margin-top: 15px;
        }

        input,
        select {
            width: 100%;
            padding: 10px;
            margin-top: 6px;
            box-sizing: border-box;
        }

        button {
            width: 100%;
            padding: 12px;
            margin-top: 25px;
            background: #222;
            color: white;
            border: none;
            cursor: pointer;
            border-radius: 5px;
        }

        button:hover {
            background: #444;
        }

        .back {
            display: block;
            text-align: center;
            margin-top: 15px;
            text-decoration: none;
            color: #222;
        }

    </style>

</head>

<body>

<div class="container">

    <h2>Edit Invoice</h2>

    <form action="updateInvoice" method="post">

        <input type="hidden"
               name="invoiceId"
               value="<%= invoice.getInvoiceId() %>">

        <label>Service ID</label>

        <input type="number"
               name="serviceId"
               value="<%= invoice.getServiceId() %>"
               readonly>

        <label>Invoice Date</label>

        <input type="date"
               name="invoiceDate"
               value="<%= invoice.getInvoiceDate() %>"
               required>

        <label>Subtotal</label>

        <input type="number"
               step="0.01"
               name="subtotal"
               value="<%= invoice.getSubtotal() %>"
               required>

        <label>Tax Amount</label>

        <input type="number"
               step="0.01"
               name="taxAmount"
               value="<%= invoice.getTaxAmount() %>"
               required>

        <label>Discount Amount</label>

        <input type="number"
               step="0.01"
               name="discountAmount"
               value="<%= invoice.getDiscountAmount() %>"
               required>

        <label>Total Amount</label>

        <input type="number"
               step="0.01"
               name="totalAmount"
               value="<%= invoice.getTotalAmount() %>"
               required>

        <label>Payment Status</label>

        <select name="paymentStatus">

            <option value="UNPAID"
                <%= "UNPAID".equals(invoice.getPaymentStatus())
                    ? "selected" : "" %>>
                UNPAID
            </option>

            <option value="PAID"
                <%= "PAID".equals(invoice.getPaymentStatus())
                    ? "selected" : "" %>>
                PAID
            </option>

            <option value="PARTIAL"
                <%= "PARTIAL".equals(invoice.getPaymentStatus())
                    ? "selected" : "" %>>
                PARTIAL
            </option>

        </select>

        <label>Payment Method</label>

        <select name="paymentMethod">

            <option value=""
                <%= invoice.getPaymentMethod() == null
                    ? "selected" : "" %>>
                Select Payment Method
            </option>

            <option value="CASH"
                <%= "CASH".equals(invoice.getPaymentMethod())
                    ? "selected" : "" %>>
                CASH
            </option>

            <option value="UPI"
                <%= "UPI".equals(invoice.getPaymentMethod())
                    ? "selected" : "" %>>
                UPI
            </option>

            <option value="CARD"
                <%= "CARD".equals(invoice.getPaymentMethod())
                    ? "selected" : "" %>>
                CARD
            </option>

            <option value="BANK TRANSFER"
                <%= "BANK TRANSFER".equals(invoice.getPaymentMethod())
                    ? "selected" : "" %>>
                BANK TRANSFER
            </option>

        </select>

        <button type="submit">
            Update Invoice
        </button>

    </form>

    <a class="back" href="invoices">
        ← Back to Invoice List
    </a>

</div>

</body>
</html>