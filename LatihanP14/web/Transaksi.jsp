<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.unpam.model.Transaksi"%>
<%@page import="java.util.List"%>

<%
    // CEK SESSION
    if (session.getAttribute("user") == null) {
        response.sendRedirect("Login.jsp");
    }

    String tombol = request.getParameter("tombol");
    
    // Objek untuk menampung data yang sedang diedit/dipilih
    Transaksi itemSelected = new Transaksi();

    if (tombol != null) {

        Transaksi transaksi = new Transaksi();

        transaksi.setNoTransaksi(request.getParameter("noTransaksi"));
        transaksi.setTanggal(request.getParameter("tanggal"));
        transaksi.setNamaBarang(request.getParameter("namaBarang"));
        
        String jumlahStr = request.getParameter("jumlah");
        String totalStr = request.getParameter("total");

        if (jumlahStr != null && !jumlahStr.isEmpty()) {
            transaksi.setJumlah(Integer.parseInt(jumlahStr));
        }

        if (totalStr != null && !totalStr.isEmpty()) {
            transaksi.setTotal(Integer.parseInt(totalStr));
        }

        if (tombol.equals("Simpan")) {
            if (transaksi.simpan()) {
                out.println("<script>alert('Data berhasil disimpan');</script>");
            } else {
                out.println("<script>alert('Data gagal disimpan');</script>");
            }
        } else if (tombol.equals("Update")) {
            if (transaksi.update()) {
                out.println("<script>alert('Data berhasil diupdate');</script>");
            } else {
                out.println("<script>alert('Data gagal diupdate');</script>");
            }
        } else if (tombol.equals("Delete")) {
            if (transaksi.delete()) {
                out.println("<script>alert('Data berhasil dihapus');</script>");
            } else {
                out.println("<script>alert('Data gagal dihapus');</script>");
            }
        } else if (tombol.equals("Pilih")) {
            String kodeCari = request.getParameter("noTransaksiPilih");
            if (kodeCari != null) {
                itemSelected.getByKode(kodeCari);
            }
        } else if (tombol.equals("Cari")) {
            itemSelected.getByKode(transaksi.getNoTransaksi());
        }
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Data Transaksi</title>
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
        h2 { color: #dc2626; margin-bottom: 20px; }
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
        th { background-color: #dc2626; color: white; }
        tr:hover { background-color: #f1f5f9; }
        .radio-cell { text-align: center; width: 50px; }
    </style>
</head>
<body>

    <h2>MASTER DATA TRANSAKSI</h2>

    <div class="container-form">
        <form method="post">
            <div class="form-group">
                <label>No Transaksi :</label>
                <div class="input-row">
                    <input type="text" name="noTransaksi" value="<%= (itemSelected.getNoTransaksi() != null) ? itemSelected.getNoTransaksi() : "" %>">
                    <input type="submit" name="tombol" value="Cari" class="btn-cari">
                </div>
            </div>

            <div class="form-group">
                <label>Tanggal :</label>
                <%
                    String tanggalHariIni = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
                    String tglTampil = (itemSelected.getTanggal() != null && !itemSelected.getTanggal().isEmpty()) 
                                       ? itemSelected.getTanggal() : tanggalHariIni;
                %>
                <input type="date" name="tanggal" value="<%= tglTampil %>" style="width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 5px; box-sizing: border-box;">
            </div>

            <div class="form-group">
                <label>Nama Barang :</label>
                <input type="text" name="namaBarang" value="<%= (itemSelected.getNamaBarang() != null) ? itemSelected.getNamaBarang() : "" %>">
            </div>

            <div class="form-group">
                <label>Jumlah :</label>
                <input type="text" name="jumlah" value="<%= (itemSelected.getJumlah() != 0) ? itemSelected.getJumlah() : "" %>">
            </div>

            <div class="form-group">
                <label>Total :</label>
                <input type="text" name="total" value="<%= (itemSelected.getTotal() != 0) ? itemSelected.getTotal() : "" %>">
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
                        <th>No Transaksi</th>
                        <th>Barang</th>
                        <th>Total</th>
                    </tr>
                    <%
                        List<Transaksi> list = new Transaksi().tampil();
                        for (Transaksi t : list) {
                    %>
                    <tr>
                        <td class="radio-cell">
                            <input type="radio" name="noTransaksiPilih" value="<%= t.getNoTransaksi() %>">
                        </td>
                        <td><%= t.getNoTransaksi() %></td>
                        <td><%= t.getNamaBarang() %></td>
                        <td><%= t.getTotal() %></td>
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