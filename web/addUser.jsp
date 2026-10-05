<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Add User - AUTOCARE</title>

    <style>

        * {
            box-sizing: border-box;
        }

        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background: #f4f6f8;
            color: #222;
        }

        .header {
            background: #111;
            color: white;
            padding: 18px 40px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .logo {
            font-size: 26px;
            font-weight: bold;
        }

        .nav {
            display: flex;
            gap: 20px;
        }

        .nav a {
            color: white;
            text-decoration: none;
            font-size: 14px;
            font-weight: bold;
        }

        .nav a:hover {
            color: #ccc;
        }

        .container {
            width: 90%;
            max-width: 600px;
            margin: 50px auto;
        }

        .form-box {
            background: white;
            padding: 35px;
            border-radius: 12px;
            box-shadow: 0 3px 15px rgba(0,0,0,0.08);
        }

        h1 {
            margin-top: 0;
            margin-bottom: 25px;
            text-align: center;
        }

        label {
            display: block;
            font-weight: bold;
            margin-top: 15px;
            margin-bottom: 7px;
        }

        input,
        select {
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 14px;
        }

        input:focus,
        select:focus {
            outline: none;
            border-color: #111;
        }

        .buttons {
            display: flex;
            gap: 12px;
            margin-top: 25px;
        }

        button,
        .cancel {
            flex: 1;
            padding: 12px;
            border-radius: 6px;
            font-weight: bold;
            text-align: center;
            text-decoration: none;
            cursor: pointer;
            font-size: 14px;
        }

        button {
            background: #111;
            color: white;
            border: none;
        }

        button:hover {
            background: #333;
        }

        .cancel {
            background: white;
            color: #111;
            border: 1px solid #111;
        }

        .cancel:hover {
            background: #eee;
        }

    </style>

</head>

<body>


<div class="header">

    <div class="logo">
        AUTOCARE
    </div>

    <div class="nav">

        <a href="dashboard">Dashboard</a>

        <a href="users">Users</a>

        <a href="logout">Logout</a>

    </div>

</div>


<div class="container">

    <div class="form-box">

        <h1>
            Add User
        </h1>


        <form action="addUser" method="post">

            <label>
                Full Name
            </label>

            <input type="text"
                   name="fullName"
                   placeholder="Enter full name"
                   required>


            <label>
                Email
            </label>

            <input type="email"
                   name="email"
                   placeholder="Enter email"
                   required>


            <label>
                Password
            </label>

            <input type="password"
                   name="password"
                   placeholder="Enter password"
                   required>


            <label>
                Role
            </label>

            <select name="role" required>

                <option value="">
                    Select Role
                </option>

                <option value="ADMIN">
                    ADMIN
                </option>

                <option value="USER">
                    USER
                </option>

            </select>


            <div class="buttons">

                <button type="submit">
                    Add User
                </button>

                <a href="users"
                   class="cancel">
                    Cancel
                </a>

            </div>

        </form>

    </div>

</div>


</body>

</html>