<%-- 
    Document   : index
    Created on : Apr 26, 2026, 5:19:09 PM
    Author     : Hadi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Form Nama</title>
</head>
<body>
    <h2>Input Nama</h2>

    <form action="ProsesServlet" method="post">
        Nama: <input type="text" name="nama">
        <br><br>
        <input type="submit" value="Kirim">
    </form>
</body>
</html>
