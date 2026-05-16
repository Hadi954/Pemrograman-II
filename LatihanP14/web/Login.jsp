<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.unpam.model.User"%>

<%
    String pesan = "";
    String tombol = request.getParameter("tombol");

    if (tombol != null) {
        
        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));

        if (user.login()) {
            // Jika berhasil, buat session
            session.setAttribute("user", user.getUsername());
            session.setAttribute("nama", user.getNama());
            
            // Redirect ke halaman utama
            response.sendRedirect("index.jsp");
        } else {
            pesan = "Username atau Password salah!";
        }
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Login System</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #1e3a8a;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .login-box {
            background: white;
            padding: 40px;
            width: 300px;
            border-radius: 15px;
            box-shadow: 0px 10px 25px rgba(0,0,0,0.3);
            text-align: center;
        }
        h2 { color: #1e3a8a; margin-bottom: 30px; }
        input[type=text], input[type=password] {
            width: 100%;
            padding: 12px;
            margin-bottom: 20px;
            border: 1px solid #ddd;
            border-radius: 8px;
            box-sizing: border-box;
        }
        input[type=submit] {
            background: #2563eb;
            color: white;
            width: 100%;
            padding: 12px;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            font-size: 16px;
            font-weight: bold;
        }
        input[type=submit]:hover { background: #1d4ed8; }
        .error { color: red; margin-bottom: 15px; font-size: 14px; }
    </style>
</head>
<body>

    <div class="login-box">
        <h2>LOGIN</h2>
        
        <% if (!pesan.equals("")) { %>
            <div class="error"><%= pesan %></div>
        <% } %>

        <form method="post">
            <input type="text" name="username" placeholder="Username" required>
            <input type="password" name="password" placeholder="Password" required>
            <input type="submit" name="tombol" value="Login">
        </form>
    </div>

</body>
</html>
