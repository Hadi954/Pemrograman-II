package com.unpam.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class User {

    private String username;
    private String password;
    private String nama;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public boolean login() {

        try {

            Connection c = new Koneksi().getConnection();

            String sql = "SELECT * FROM tbuser WHERE username=? AND password=?";

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                this.nama = rs.getString("nama");
                return true;
            }

            rs.close();
            ps.close();
            c.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return false;
    }
}
