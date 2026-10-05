<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

    <title>Create Invoice - AUTOCARE</title>

    <style>

        body {
            font-family: Arial, sans-serif;
            margin: 40px;
        }

        h1 {
            color: #222;
        }

        form {
            width: 500px;
        }

        label {
            display: block;
            margin-top: 15px;
            font-weight: bold;
        }

        input,
        select {
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

    <h2>Create Invoice</h2>


    <form action="addInvoice" method="post">


        <!-- SERVICE -->

        <label>Service Request</label>

        <select name="serviceId" required>

            <option value="">
                -- Select Service Request --
            </option>

            <%
                java.sql.Connection con = null;
                java.sql.PreparedStatement ps = null;
                java.sql.ResultSet rs = null;

                try {

                    con = util.DBConnection.getConnection();

                    String sql =
                            "SELECT s.service_id, "
                          + "v.vehicle_number, "
                          + "s.service_type, "
                          + "m.full_name AS mechanic_name "
                          + "FROM service_requests s "
                          + "JOIN vehicles v "
                          + "ON s.vehicle_id = v.vehicle_id "
                          + "LEFT JOIN mechanics m "
                          + "ON s.mechanic_id = m.mechanic_id "
                          + "ORDER BY s.service_id";

                    ps = con.prepareStatement(sql);

                    rs = ps.executeQuery();

                    while (rs.next()) {
            %>

            <option value="<%= rs.getInt("service_id") %>">

                Service #<%= rs.getInt("service_id") %>
                -
                <%= rs.getString("vehicle_number") %>
                -
                <%= rs.getString("service_type") %>

                -
                <%= rs.getString("mechanic_name") == null
                        ? "Not Assigned"
                        : rs.getString("mechanic_name") %>

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


        <!-- INVOICE DATE -->

        <label>Invoice Date</label>

        <input type="date"
               name="invoiceDate"
               required>


        <!-- SUBTOTAL -->

        <label>Subtotal</label>

        <input type="number"
               name="subtotal"
               step="0.01"
               min="0"
               placeholder="Enter subtotal"
               required>


        <!-- TAX -->

        <label>Tax Amount</label>

        <input type="number"
               name="taxAmount"
               step="0.01"
               min="0"
               value="0"
               required>


        <!-- DISCOUNT -->

        <label>Discount Amount</label>

        <input type="number"
               name="discountAmount"
               step="0.01"
               min="0"
               value="0"
               required>


        <!-- TOTAL -->

        <label>Total Amount</label>

        <input type="number"
               name="totalAmount"
               step="0.01"
               min="0"
               placeholder="Enter total amount"
               required>


        <!-- PAYMENT STATUS -->

        <label>Payment Status</label>

        <select name="paymentStatus" required>

            <option value="UNPAID">
                UNPAID
            </option>

            <option value="PAID">
                PAID
            </option>

            <option value="PARTIAL">
                PARTIAL
            </option>

        </select>


        <!-- PAYMENT METHOD -->

        <label>Payment Method</label>

        <select name="paymentMethod">

            <option value="">
                -- Select Payment Method --
            </option>

            <option value="CASH">
                CASH
            </option>

            <option value="UPI">
                UPI
            </option>

            <option value="CARD">
                CARD
            </option>

            <option value="BANK TRANSFER">
                BANK TRANSFER
            </option>

        </select>


        <button type="submit">
            Create Invoice
        </button>

        <a href="invoices">
            Cancel
        </a>

    </form>

</body>

</html>