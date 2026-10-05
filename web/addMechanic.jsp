<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Add Mechanic - AUTOCARE</title>

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
    <h2>Add Mechanic</h2>

    <form action="addMechanic" method="post">

        <label>Full Name</label>

        <input type="text"
               name="fullName"
               placeholder="Enter mechanic name"
               required>


        <label>Phone</label>

        <input type="text"
               name="phone"
               placeholder="Enter phone number"
               maxlength="15"
               required>


        <label>Email</label>

        <input type="email"
               name="email"
               placeholder="Enter email address">


        <label>Specialization</label>

        <select name="specialization" required>

            <option value="">-- Select Specialization --</option>

            <option value="Engine Specialist">
                Engine Specialist
            </option>

            <option value="Brake Specialist">
                Brake Specialist
            </option>

            <option value="AC Specialist">
                AC Specialist
            </option>

            <option value="Electrical Specialist">
                Electrical Specialist
            </option>

            <option value="Transmission Specialist">
                Transmission Specialist
            </option>

            <option value="General Mechanic">
                General Mechanic
            </option>

        </select>


        <label>Experience (Years)</label>

        <input type="number"
               name="experienceYears"
               min="0"
               max="99"
               placeholder="Enter experience"
               required>


        <label>Status</label>

        <select name="status" required>

            <option value="ACTIVE">
                ACTIVE
            </option>

            <option value="INACTIVE">
                INACTIVE
            </option>

        </select>


        <button type="submit">
            Add Mechanic
        </button>

        <a href="mechanics">
            Cancel
        </a>

    </form>

</body>
</html>