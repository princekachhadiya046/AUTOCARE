<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Mechanic" %>

<%
    Mechanic mechanic =
            (Mechanic) request.getAttribute("mechanic");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Mechanic - AUTOCARE</title>

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
    <h2>Edit Mechanic</h2>

    <form action="updateMechanic" method="post">

        <input type="hidden"
               name="mechanicId"
               value="<%= mechanic.getMechanicId() %>">


        <label>Full Name</label>

        <input type="text"
               name="fullName"
               value="<%= mechanic.getFullName() %>"
               required>


        <label>Phone</label>

        <input type="text"
               name="phone"
               value="<%= mechanic.getPhone() %>"
               maxlength="15"
               required>


        <label>Email</label>

        <input type="email"
               name="email"
               value="<%= mechanic.getEmail() == null
                       ? "" : mechanic.getEmail() %>">


        <label>Specialization</label>

        <select name="specialization" required>

            <option value="Engine Specialist"
                <%= "Engine Specialist".equals(mechanic.getSpecialization())
                        ? "selected" : "" %>>
                Engine Specialist
            </option>

            <option value="Brake Specialist"
                <%= "Brake Specialist".equals(mechanic.getSpecialization())
                        ? "selected" : "" %>>
                Brake Specialist
            </option>

            <option value="AC Specialist"
                <%= "AC Specialist".equals(mechanic.getSpecialization())
                        ? "selected" : "" %>>
                AC Specialist
            </option>

            <option value="Electrical Specialist"
                <%= "Electrical Specialist".equals(mechanic.getSpecialization())
                        ? "selected" : "" %>>
                Electrical Specialist
            </option>

            <option value="Transmission Specialist"
                <%= "Transmission Specialist".equals(mechanic.getSpecialization())
                        ? "selected" : "" %>>
                Transmission Specialist
            </option>

            <option value="General Mechanic"
                <%= "General Mechanic".equals(mechanic.getSpecialization())
                        ? "selected" : "" %>>
                General Mechanic
            </option>

        </select>


        <label>Experience (Years)</label>

        <input type="number"
               name="experienceYears"
               value="<%= mechanic.getExperienceYears() %>"
               min="0"
               max="99"
               required>


        <label>Status</label>

        <select name="status" required>

            <option value="ACTIVE"
                <%= "ACTIVE".equals(mechanic.getStatus())
                        ? "selected" : "" %>>
                ACTIVE
            </option>

            <option value="INACTIVE"
                <%= "INACTIVE".equals(mechanic.getStatus())
                        ? "selected" : "" %>>
                INACTIVE
            </option>

        </select>


        <button type="submit">
            Update Mechanic
        </button>

        <a href="mechanics">
            Cancel
        </a>

    </form>

</body>
</html>