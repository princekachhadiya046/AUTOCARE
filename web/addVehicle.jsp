<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="util.DBConnection" %>

<!DOCTYPE html>
<html>

<head>

    <title>Add Vehicle - AUTOCARE</title>

</head>

<body>

    <h1>AUTOCARE</h1>

    <h2>Add Vehicle</h2>

    <form action="addVehicle" method="post">

        <label>Customer:</label>

        <select name="customerId" required>

            <option value="">-- Select Customer --</option>

            <%
                try {

                    Connection con =
                            DBConnection.getConnection();

                    String sql =
                            "SELECT customer_id, full_name "
                          + "FROM customers "
                          + "ORDER BY full_name";

                    PreparedStatement ps =
                            con.prepareStatement(sql);

                    ResultSet rs =
                            ps.executeQuery();

                    while (rs.next()) {
            %>

            <option value="<%= rs.getInt("customer_id") %>">

                <%= rs.getString("full_name") %>

            </option>

            <%
                    }

                    rs.close();
                    ps.close();
                    con.close();

                } catch (Exception e) {

                    e.printStackTrace();
                }
            %>

        </select>

        <br><br>

        <label>Vehicle Number:</label>

        <input type="text"
               name="vehicleNumber"
               placeholder="GJ05AB1234"
               required>

        <br><br>

        <label>Brand:</label>

        <input type="text"
               name="brand"
               placeholder="Toyota"
               required>

        <br><br>

        <label>Model:</label>

        <input type="text"
               name="model"
               placeholder="Innova"
               required>

        <br><br>

        <label>Vehicle Type:</label>

        <select name="vehicleType" required>

            <option value="">-- Select Type --</option>

            <option value="Car">Car</option>
            <option value="Bike">Bike</option>
            <option value="SUV">SUV</option>
            <option value="Truck">Truck</option>
            <option value="Other">Other</option>

        </select>

        <br><br>

        <label>Manufacturing Year:</label>

        <input type="number"
               name="manufacturingYear"
               min="1900"
               max="2026"
               required>

        <br><br>

        <button type="submit">
            Add Vehicle
        </button>

    </form>

    <br>

    <a href="vehicles">View Vehicles</a>

</body>

</html>