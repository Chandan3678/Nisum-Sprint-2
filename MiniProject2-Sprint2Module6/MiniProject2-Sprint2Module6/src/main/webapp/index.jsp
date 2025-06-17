<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Welcome to Nisum Order Management</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        body {
            background: #222;
            color: #fff;
            font-family: Arial, sans-serif;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            text-align: center;
        }
        .btn-orders {
            margin-top: 30px;
            padding: 15px 35px;
            font-size: 1.2em;
            background: #007bff;
            color: #fff;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            text-decoration: none;
            transition: background 0.2s;
        }
        .btn-orders:hover {
            background: #0056b3;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Welcome to Nisum Order Management Portal</h1>
    <p>Click below to view your orders portal</p>
    <a href="orders" class="btn-orders">Go to Orders</a>
</div>
</body>
</html>
