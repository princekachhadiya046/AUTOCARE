<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">

    <title>Login - AUTOCARE</title>

    <style>

        * {
            box-sizing: border-box;
        }

        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background: #f4f6f8;
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .login-container {
            width: 400px;
            background: white;
            padding: 35px;
            border-radius: 12px;
            box-shadow: 0 5px 20px rgba(0,0,0,0.12);
        }

        .logo {
            text-align: center;
            font-size: 30px;
            font-weight: bold;
            margin-bottom: 8px;
        }

        .subtitle {
            text-align: center;
            color: #777;
            font-size: 14px;
            margin-bottom: 30px;
        }

        h2 {
            text-align: center;
            margin-bottom: 25px;
        }

        label {
            display: block;
            font-weight: bold;
            margin-top: 15px;
            margin-bottom: 6px;
        }

        input {
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 14px;
        }

        input:focus {
            outline: none;
            border-color: #111;
        }

        button {
            width: 100%;
            padding: 13px;
            margin-top: 25px;
            background: #111;
            color: white;
            border: none;
            border-radius: 6px;
            font-size: 15px;
            font-weight: bold;
            cursor: pointer;
        }

        button:hover {
            background: #333;
        }

        .message {
            text-align: center;
            margin-top: 15px;
            color: #d00;
            font-size: 14px;
        }

        .back {
            display: block;
            text-align: center;
            margin-top: 20px;
            color: #222;
            text-decoration: none;
            font-size: 14px;
        }

        .back:hover {
            text-decoration: underline;
        }

    </style>

</head>

<body>

<div class="login-container">

    <div class="logo">
        AUTOCARE
    </div>

    <div class="subtitle">
        Vehicle Service & Garage Management System
    </div>

    <h2>Login</h2>

    <form action="login" method="post">

        <label>Email</label>

        <input type="email"
               name="email"
               placeholder="Enter your email"
               required>


        <label>Password</label>

        <input type="password"
               name="password"
               placeholder="Enter your password"
               required>


        <button type="submit">
            Login
        </button>

    </form>


    <%
        String error = request.getParameter("error");

        if ("invalid".equals(error)) {
    %>

        <div class="message">
            Invalid email or password!
        </div>

    <%
        }
    %>


    <a class="back" href="index.jsp">
        ← Back to Home
    </a>

</div>

</body>
</html>