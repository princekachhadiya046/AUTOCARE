<%@ page import="model.Customer" %>

<%
    Customer customer =
        (Customer) request.getAttribute("customer");
%>

<!DOCTYPE html>
<html>

<head>

    <title>Edit Customer - AUTOCARE</title>

</head>

<body>

    <h1>AUTOCARE</h1>

    <h2>Edit Customer</h2>

    <form action="updateCustomer" method="post">

        <input type="hidden"
               name="customerId"
               value="<%= customer.getCustomerId() %>">

        <label>Full Name:</label>

        <input type="text"
               name="fullName"
               value="<%= customer.getFullName() %>"
               required>

        <br><br>

        <label>Phone:</label>

        <input type="text"
               name="phone"
               value="<%= customer.getPhone() %>"
               required>

        <br><br>

        <label>Email:</label>

        <input type="email"
               name="email"
               value="<%= customer.getEmail() %>">

        <br><br>

        <label>Address:</label>

        <textarea name="address"><%= customer.getAddress() %></textarea>

        <br><br>

        <button type="submit">
            Update Customer
        </button>

    </form>

    <br>

    <a href="customers">Back to Customer List</a>

</body>

</html>