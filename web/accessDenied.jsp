<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">

    <title>Access Denied - AUTOCARE</title>

    <style>

        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background: #f4f6f8;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        .box {
            background: white;
            width: 420px;
            padding: 40px;
            text-align: center;
            border-radius: 12px;
            box-shadow: 0 5px 20px rgba(0,0,0,0.12);
        }

        h1 {
            margin-bottom: 10px;
        }

        p {
            color: #666;
            margin-bottom: 25px;
        }

        a {
            display: inline-block;
            padding: 12px 25px;
            background: #111;
            color: white;
            text-decoration: none;
            border-radius: 6px;
            font-weight: bold;
        }

        a:hover {
            background: #333;
        }

    </style>

</head>

<body>

<div class="box">

    <h1>Access Denied</h1>

    <p>
        You do not have permission to access this page.
    </p>

    <a href="dashboard">
        Back to Dashboard
    </a>

</div>

</body>
</html>