package com.unpam.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Barang {

    private String kodeBarang;
    private String namaBarang;
    private int harga;
    private int stok;

    // =========================
    // GETTER & SETTER
    // =========================

    public String getKodeBarang() {
        return kodeBarang;
    }

    public void setKodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    // =========================
    // METHOD SIMPAN
    // =========================

    public boolean simpan() {

        try {

            Connection c = new Koneksi().getConnection();

            String sql =
                    "INSERT INTO tbbarang VALUES (?,?,?,?)";

            PreparedStatement ps =
                    c.prepareStatement(sql);

            ps.setString(1, kodeBarang);
            ps.setString(2, namaBarang);
            ps.setInt(3, harga);
            ps.setInt(4, stok);

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

            Connection c = new Koneksi().getConnection();

            String sql =
                    "UPDATE tbbarang SET nama_barang=?, harga=?, stok=? WHERE kode_barang=?";

            PreparedStatement ps =
                    c.prepareStatement(sql);

            ps.setString(1, namaBarang);
            ps.setInt(2, harga);
            ps.setInt(3, stok);
            ps.setString(4, kodeBarang);

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

            Connection c = new Koneksi().getConnection();

            String sql =
                    "DELETE FROM tbbarang WHERE kode_barang=?";

            PreparedStatement ps =
                    c.prepareStatement(sql);

            ps.setString(1, kodeBarang);

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
    // METHOD TAMPIL (LIST ALL)
    // =========================

    public java.util.List<Barang> tampil() {

        java.util.List<Barang> data = new java.util.ArrayList<>();

        try {

            Connection c = new Koneksi().getConnection();

            String sql = "SELECT * FROM tbbarang";

            PreparedStatement ps = c.prepareStatement(sql);

            java.sql.ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Barang b = new Barang();

                b.setKodeBarang(rs.getString("kode_barang"));
                b.setNamaBarang(rs.getString("nama_barang"));
                b.setHarga(rs.getInt("harga"));
                b.setStok(rs.getInt("stok"));

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
    // METHOD CARI BY KODE
    // =========================

    public void getByKode(String kode) {

        try {

            Connection c = new Koneksi().getConnection();

            String sql = "SELECT * FROM tbbarang WHERE kode_barang=?";

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, kode);

            java.sql.ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                this.kodeBarang = rs.getString("kode_barang");
                this.namaBarang = rs.getString("nama_barang");
                this.harga = rs.getInt("harga");
                this.stok = rs.getInt("stok");
            }

            rs.close();
            ps.close();
            c.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}