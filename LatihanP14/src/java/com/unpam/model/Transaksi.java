/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unpam.model;

/**
 *
 * @author Hadi
 */
public class Transaksi {

    private String noTransaksi;
    private String tanggal;
    private String namaBarang;
    private int jumlah;
    private int total;

    public String getNoTransaksi() {
        return noTransaksi;
    }

    public void setNoTransaksi(String noTransaksi) {
        this.noTransaksi = noTransaksi;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    // =========================
    // METHOD SIMPAN
    // =========================

    public boolean simpan() {
        try {
            java.sql.Connection c = new Koneksi().getConnection();
            String sql = "INSERT INTO tbtransaksi VALUES (?,?,?,?,?)";
            java.sql.PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, noTransaksi);
            ps.setString(2, tanggal);
            ps.setString(3, namaBarang);
            ps.setInt(4, jumlah);
            ps.setInt(5, total);
            ps.executeUpdate();
            ps.close();
            c.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    // =========================
    // METHOD UPDATE
    // =========================

    public boolean update() {
        try {
            java.sql.Connection c = new Koneksi().getConnection();
            String sql = "UPDATE tbtransaksi SET tanggal=?, nama_barang=?, jumlah=?, total_bayar=? WHERE no_transaksi=?";
            java.sql.PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, tanggal);
            ps.setString(2, namaBarang);
            ps.setInt(3, jumlah);
            ps.setInt(4, total);
            ps.setString(5, noTransaksi);
            ps.executeUpdate();
            ps.close();
            c.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    // =========================
    // METHOD DELETE
    // =========================

    public boolean delete() {
        try {
            java.sql.Connection c = new Koneksi().getConnection();
            String sql = "DELETE FROM tbtransaksi WHERE no_transaksi=?";
            java.sql.PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, noTransaksi);
            ps.executeUpdate();
            ps.close();
            c.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    // =========================
    // METHOD TAMPIL
    // =========================

    public java.util.List<Transaksi> tampil() {
        java.util.List<Transaksi> data = new java.util.ArrayList<>();
        try {
            java.sql.Connection c = new Koneksi().getConnection();
            String sql = "SELECT * FROM tbtransaksi";
            java.sql.PreparedStatement ps = c.prepareStatement(sql);
            java.sql.ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Transaksi b = new Transaksi();
                b.setNoTransaksi(rs.getString("no_transaksi"));
                b.setTanggal(rs.getString("tanggal"));
                b.setNamaBarang(rs.getString("nama_barang"));
                b.setJumlah(rs.getInt("jumlah"));
                b.setTotal(rs.getInt("total_bayar"));
                data.add(b);
            }
            rs.close();
            ps.close();
            c.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return data;
    }

    // =========================
    // METHOD GET BY KODE
    // =========================

    public void getByKode(String kode) {
        try {
            java.sql.Connection c = new Koneksi().getConnection();
            String sql = "SELECT * FROM tbtransaksi WHERE no_transaksi=?";
            java.sql.PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, kode);
            java.sql.ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                this.noTransaksi = rs.getString("no_transaksi");
                this.tanggal = rs.getString("tanggal");
                this.namaBarang = rs.getString("nama_barang");
                this.jumlah = rs.getInt("jumlah");
                this.total = rs.getInt("total_bayar");
            }
            rs.close();
            ps.close();
            c.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
