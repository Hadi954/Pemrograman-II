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
public class Customer {

    private String kodeCustomer;
    private String namaCustomer;
    private String alamat;
    private String telepon;

    public String getKodeCustomer() {
        return kodeCustomer;
    }

    public void setKodeCustomer(String kodeCustomer) {
        this.kodeCustomer = kodeCustomer;
    }

    public String getNamaCustomer() {
        return namaCustomer;
    }

    public void setNamaCustomer(String namaCustomer) {
        this.namaCustomer = namaCustomer;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    // =========================
    // METHOD SIMPAN
    // =========================

    public boolean simpan() {
        try {
            java.sql.Connection c = new Koneksi().getConnection();
            String sql = "INSERT INTO tbcustomer VALUES (?,?,?,?)";
            java.sql.PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, kodeCustomer);
            ps.setString(2, namaCustomer);
            ps.setString(3, alamat);
            ps.setString(4, telepon);
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
            String sql = "UPDATE tbcustomer SET nama_customer=?, alamat=?, telepon=? WHERE kode_customer=?";
            java.sql.PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, namaCustomer);
            ps.setString(2, alamat);
            ps.setString(3, telepon);
            ps.setString(4, kodeCustomer);
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
            String sql = "DELETE FROM tbcustomer WHERE kode_customer=?";
            java.sql.PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, kodeCustomer);
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

    public java.util.List<Customer> tampil() {
        java.util.List<Customer> data = new java.util.ArrayList<>();
        try {
            java.sql.Connection c = new Koneksi().getConnection();
            String sql = "SELECT * FROM tbcustomer";
            java.sql.PreparedStatement ps = c.prepareStatement(sql);
            java.sql.ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Customer b = new Customer();
                b.setKodeCustomer(rs.getString("kode_customer"));
                b.setNamaCustomer(rs.getString("nama_customer"));
                b.setAlamat(rs.getString("alamat"));
                b.setTelepon(rs.getString("telepon"));
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
            String sql = "SELECT * FROM tbcustomer WHERE kode_customer=?";
            java.sql.PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, kode);
            java.sql.ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                this.kodeCustomer = rs.getString("kode_customer");
                this.namaCustomer = rs.getString("nama_customer");
                this.alamat = rs.getString("alamat");
                this.telepon = rs.getString("telepon");
            }
            rs.close();
            ps.close();
            c.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
