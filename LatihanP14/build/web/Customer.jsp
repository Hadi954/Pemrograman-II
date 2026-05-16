<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.unpam.model.Customer"%>
<%@page import="java.util.List"%>

<%
    // CEK SESSION
    if (session.getAttribute("user") == null) {
        response.sendRedirect("Login.jsp");
    }

    String tombol = request.getParameter("tombol");
    
    // Objek untuk menampung data yang sedang diedit/dipilih
    Customer itemSelected = new Customer();

    if (tombol != null) {

        Customer customer = new Customer();

        customer.setKodeCustomer(request.getParameter("kodeCustomer"));
        customer.setNamaCustomer(request.getParameter("namaCustomer"));
        customer.setAlamat(request.getParameter("alamat"));
        customer.setTelepon(request.getParameter("telepon"));

        if (tombol.equals("Simpan")) {
            if (customer.simpan()) {
                out.println("<script>alert('Data berhasil disimpan');</script>");
            } else {
                out.println("<script>alert('Data gagal disimpan');</script>");
            }
        } else if (tombol.equals("Update")) {
            if (customer.update()) {
                out.println("<script>alert('Data berhasil diupdate');</script>");
            } else {
                out.println("<script>alert('Data gagal diupdate');</script>");
            }
        } else if (tombol.equals("Delete")) {
            if (customer.delete()) {
                out.println("<script>alert('Data berhasil dihapus');</script>");
            } else {
                out.println("<script>alert('Data gagal dihapus');</script>");
            }
        } else if (tombol.equals("Pilih")) {
            String kodeCari = request.getParameter("kodeCustomerPilih");
            if (kodeCari != null) {
                itemSelected.getByKode(kodeCari);
            }
        } else if (tombol.equals("Cari")) {
            itemSelected.getByKode(customer.getKodeCustomer());
        }
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Data Customer</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            display: flex;
            justify-content: flex-start;
            align-items: center;
            min-height: 100vh;
            flex-direction: column;
            padding: 20px;
        }
        h2 { color: #059669; margin-bottom: 20px; }
        .container-form {
            background: white;
            padding: 25px;
            width: 450px;
            border-radius: 12px;
            box-shadow: 0px 4px 15px rgba(0,0,0,0.1);
            margin-bottom: 30px;
        }
        .form-group { margin-bottom: 15px; }
        .form-group label { display: block; margin-bottom: 5px; font-weight: bold; }
        .input-row { display: flex; gap: 10px; }
        input[type=text] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        .btn-group { display: flex; gap: 10px; margin-top: 20px; }
        input[type=submit] {
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 14px;
            transition: 0.3s;
        }
        .btn-cari { background: #64748b; }
        .btn-simpan { background: #6366f1; flex: 1; }
        .btn-update { background: #6366f1; flex: 1; }
        .btn-delete { background: #6366f1; flex: 1; }
        .btn-lihat { background: #6366f1; flex: 1; }
        input[type=submit]:hover { opacity: 0.8; }

        table {
            width: 80%;
            max-width: 800px;
            background: white;
            border-collapse: collapse;
            margin-top: 20px;
            box-shadow: 0px 4px 15px rgba(0,0,0,0.1);
            border-radius: 8px;
            overflow: hidden;
        }
        th, td { padding: 12px 15px; text-align: left; border-bottom: 1px solid #ddd; }
        th { background-color: #059669; color: white; }
        tr:hover { background-color: #f1f5f9; }
        .radio-cell { text-align: center; width: 50px; }
    </style>
</head>
<body>

    <h2>MASTER DATA CUSTOMER</h2>

    <div class="container-form">
        <form method="post">
            <div class="form-group">
                <label>Kode Customer :</label>
                <div class="input-row">
                    <input type="text" name="kodeCustomer" value="<%= (itemSelected.getKodeCustomer() != null) ? itemSelected.getKodeCustomer() : "" %>">
                    <input type="submit" name="tombol" value="Cari" class="btn-cari">
                </div>
            </div>

            <div class="form-group">
                <label>Nama Customer :</label>
                <input type="text" name="namaCustomer" value="<%= (itemSelected.getNamaCustomer() != null) ? itemSelected.getNamaCustomer() : "" %>">
            </div>

            <div class="form-group">
                <label>Alamat :</label>
                <input type="text" name="alamat" value="<%= (itemSelected.getAlamat() != null) ? itemSelected.getAlamat() : "" %>">
            </div>

            <div class="form-group">
                <label>Telepon :</label>
                <input type="text" name="telepon" value="<%= (itemSelected.getTelepon() != null) ? itemSelected.getTelepon() : "" %>">
            </div>

            <div class="btn-group">
                <input type="submit" name="tombol" value="Simpan" class="btn-simpan">
                <input type="submit" name="tombol" value="Update" class="btn-update">
                <input type="submit" name="tombol" value="Delete" class="btn-delete">
                <input type="submit" name="tombol" value="Lihat" class="btn-lihat">
            </div>

            <% if ("Lihat".equals(tombol) || "Pilih".equals(tombol)) { %>
            <div style="margin-top: 30px;">
                <table style="width: 100%; margin-top: 0;">
                    <tr>
                        <th class="radio-cell">Pilih</th>
                        <th>Kode</th>
                        <th>Nama Customer</th>
                    </tr>
                    <%
                        List<Customer> list = new Customer().tampil();
                        for (Customer c : list) {
                    %>
                    <tr>
                        <td class="radio-cell">
                            <input type="radio" name="kodeCustomerPilih" value="<%= c.getKodeCustomer() %>">
                        </td>
                        <td><%= c.getKodeCustomer() %></td>
                        <td><%= c.getNamaCustomer() %></td>
                    </tr>
                    <% } %>
                </table>
                <div style="margin-top: 10px; text-align: center;">
                    <input type="submit" name="tombol" value="Pilih" style="background: #334155; width: 100px;">
                </div>
            </div>
            <% } %>
        </form>
    </div>

    <p><a href="index.jsp">Kembali ke Home</a></p>

</body>
</html>