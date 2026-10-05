<!DOCTYPE html>
<html>
<head>

    <title>Add Customer - AUTOCARE</title>

</head>

<body>

    <h1>AUTOCARE</h1>

    <h2>Add Customer</h2>

    <form action="addCustomer" method="post">

        <label>Full Name:</label>
        <input type="text" name="fullName" required>

        <br><br>

        <label>Phone:</label>
        <input type="text" name="phone" required>

        <br><br>

        <label>Email:</label>
        <input type="email" name="email">

        <br><br>

        <label>Address:</label>
        <textarea name="address"></textarea>

        <br><br>

        <button type="submit">
            Add Customer
        </button>

    </form>

</body>
</html>