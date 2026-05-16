/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unpam.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Hadi
 */
public class Koneksi {

    private static final String driver = "com.mysql.cj.jdbc.Driver";

    private static final String database =
            "jdbc:mysql://localhost:3306/dbpenjualan?useSSL=false&allowPublicKeyRetrieval=true";

    private static final String user = "root";

    private static final String password = "";

    private Connection connection;

    private String pesanKesalahan;

    public String getPesanKesalahan() {
        return pesanKesalahan;
    }

    public Connection getConnection() {

        connection = null;

        pesanKesalahan = "";

        try {

            Class.forName(driver);

        } catch (ClassNotFoundException ex) {

            pesanKesalahan =
                    "JDBC Driver tidak ditemukan atau rusak\n" + ex;
        }

        if (pesanKesalahan.equals("")) {

            try {

                connection = DriverManager.getConnection(
                        database,
                        user,
                        password
                );

            } catch (SQLException ex) {

                pesanKesalahan =
                        "Koneksi ke " + database + " gagal\n" + ex;
            }
        }

        return connection;
    }
}