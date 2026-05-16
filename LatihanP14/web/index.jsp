<%-- 
    Document   : index
    Created on : May 15, 2026, 5:59:51 AM
    Author     : Hadi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    // CEK SESSION
    if (session.getAttribute("user") == null) {
        response.sendRedirect("Login.jsp");
    }
%>

<!DOCTYPE html>
<html>

<head>

    <title>Homepage Penjualan Barang</title>

    <style>
        @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap');

        body {
            margin: 0;
            font-family: 'Poppins', sans-serif;
            background: #f0f2f5;
            display: flex;
            flex-direction: column;
            min-height: 100vh;
            color: #1e293b;
        }

        .container {
            flex: 1;
            display: flex;
            flex-direction: column;
        }

        /* HEADER */
        .header {
            background: linear-gradient(135deg, #6366f1 0%, #a855f7 100%);
            color: white;
            text-align: center;
            padding: 40px 20px;
            box-shadow: 0 4px 15px rgba(168, 85, 247, 0.2);
        }

        .header h1 {
            margin: 0;
            font-size: 2.5rem;
            letter-spacing: 2px;
            text-transform: uppercase;
        }

        .header p {
            font-weight: 300;
            opacity: 0.9;
            margin-top: 10px;
        }

        /* MENU */
        .menu {
            background: #1e1b4b;
            position: sticky;
            top: 0;
            z-index: 1000;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        }

        .menu ul {
            margin: 0;
            padding: 0;
            list-style: none;
            text-align: center;
        }

        .menu ul li {
            display: inline-block;
        }

        .menu ul li a {
            display: block;
            color: #e2e8f0;
            text-decoration: none;
            padding: 18px 25px;
            font-weight: 500;
            transition: all 0.3s ease;
        }

        .menu ul li a:hover {
            color: white;
            background: rgba(255,255,255,0.1);
        }

        /* DROPDOWN */
        .dropdown {
            position: relative;
        }

        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #1e1b4b;
            min-width: 180px;
            box-shadow: 0 8px 16px rgba(0,0,0,0.2);
            border-bottom-left-radius: 8px;
            border-bottom-right-radius: 8px;
            overflow: hidden;
        }

        .dropdown-content a {
            color: #e2e8f0;
            padding: 12px 20px;
            text-align: left;
            font-size: 0.9rem;
        }

        .dropdown-content a:hover {
            background-color: #4338ca !important;
        }

        .dropdown:hover .dropdown-content {
            display: block;
        }

        /* CONTENT */
        .content {
            padding: 50px 20px;
            text-align: center;
            max-width: 1100px;
            margin: 0 auto;
            flex: 1;
        }

        .content h2 {
            font-size: 2rem;
            color: #1e1b4b;
            margin-bottom: 20px;
        }

        .welcome-text {
            color: #64748b;
            line-height: 1.6;
            margin-bottom: 40px;
            font-size: 1.1rem;
        }

        .card-container {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
            gap: 30px;
            margin-top: 20px;
        }

        .card {
            background: white;
            padding: 40px 25px;
            border-radius: 20px;
            box-shadow: 0 10px 25px rgba(0,0,0,0.05);
            transition: all 0.4s cubic-bezier(0.175, 0.885, 0.32, 1.275);
            border: 1px solid rgba(0,0,0,0.03);
            text-decoration: none;
            display: block;
        }

        .card:hover {
            transform: translateY(-10px);
            box-shadow: 0 20px 35px rgba(99, 102, 241, 0.15);
            border-color: #6366f1;
        }

        .card i {
            font-size: 3rem;
            color: #6366f1;
            margin-bottom: 20px;
            display: block;
        }

        .card h3 {
            color: #1e1b4b;
            font-size: 1.4rem;
            margin-bottom: 15px;
        }

        .card p {
            color: #64748b;
            font-size: 0.95rem;
        }

        /* FOOTER */
        .footer {
            background: #1e1b4b;
            color: #94a3b8;
            text-align: center;
            padding: 25px;
            margin-top: auto;
            font-size: 0.9rem;
            border-top: 1px solid rgba(255,255,255,0.05);
        }
    </style>

</head>

<body>

<div class="container">

    <!-- HEADER -->

    <div class="header">
        <h1>TOKO Hadi Jaya</h1>
    </div>

    <!-- MENU -->

    <div class="menu">

        <ul>

            <li><a href="index.jsp">Home</a></li>

            <li><a href="Barang.jsp">Barang</a></li>

            <li><a href="Customer.jsp">Customer</a></li>

            <li><a href="Transaksi.jsp">Transaksi</a></li>

            <li class="dropdown">
                <a href="#">Laporan</a>
                <div class="dropdown-content">
                    <a href="Cetak.jsp?jenis=barang" target="_blank">Laporan Barang</a>
                    <a href="Cetak.jsp?jenis=transaksi" target="_blank">Laporan Transaksi</a>
                </div>
            </li>

            <% if (session.getAttribute("user") != null) { %>
                <li><a href="Logout.jsp">Logout (<%= session.getAttribute("user") %>)</a></li>
            <% } else { %>
                <li><a href="Login.jsp">Login</a></li>
            <% } %>

        </ul>

    </div>

    <!-- CONTENT -->

    <div class="content">

        <h1 style="font-size: 3.5rem; color: #1e1b4b; margin-top: 100px;">
            Selamat Datang, <span style="color: #6366f1;"><%= session.getAttribute("nama") %></span>!
        </h1>
        <p style="font-size: 1.2rem; color: #64748b; margin-top: 20px;">
            Sistem Informasi Penjualan Toko Hadi Jaya
        </p>

    </div>

    <!-- FOOTER -->

    <div class="footer">

        <p>Copyright © 2026 Toko Hadi Jaya</p>

    </div>

</div>

</body>

</html>