<%@ page import="java.util.List" %>
<%@ page import="model.Customer" %>

<!DOCTYPE html>
<html>

<head>

    <title>Customer List - AUTOCARE</title>

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
        }
        

    </style>
    

</head>

<body>

    <h1>AUTOCARE</h1>

    <h2>Customer List</h2>

    <a href="addCustomer.jsp">
        + Add New Customer
    </a>

    <table>

        <tr>
            <th>ID</th>
            <th>Full Name</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Address</th>
            <th>Action</th>
        </tr>

        <%

            List<Customer> customers =
                (List<Customer>) request.getAttribute("customers");

            if (customers != null && !customers.isEmpty()) {

                for (Customer customer : customers) {

        %>

        <tr>

            <td>
                <%= customer.getCustomerId() %>
            </td>

            <td>
                <%= customer.getFullName() %>
            </td>

            <td>
                <%= customer.getPhone() %>
            </td>

            <td>
                <%= customer.getEmail() %>
            </td>

            <td>
                <%= customer.getAddress() %>
            </td>
           <td>

            <a href="editCustomer?id=<%= customer.getCustomerId() %>">
                Edit
            </a>

            &nbsp; | &nbsp;

            <a href="deleteCustomer?id=<%= customer.getCustomerId() %>"
                onclick="return confirm('Are you sure you want to delete this customer?');">
                Delete
            </a>

            </td>

        </tr>

        <%

                }

            } else {

        %>

        <tr>

            <td colspan="5">
                No customers found.
            </td>

        </tr>

        <%

            }

        %>

    </table>

</body>

</html>