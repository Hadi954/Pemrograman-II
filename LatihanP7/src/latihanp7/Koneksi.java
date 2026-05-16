package latihanp7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Hadi
 */


public class Koneksi {
    private static Connection mysqlconfig;
    public static Connection configDB() throws SQLException {
        try {
            String url = "jdbc:mysql://localhost:3306/db_lottemart"; //sesuaikan dengan nama database anda
            String user = "root"; //sesuaikan dengan username database anda
            String pass = ""; //sesuaikan dengan password database anda
            Class.forName("com.mysql.cj.jdbc.Driver");
            mysqlconfig = DriverManager.getConnection(url, user, pass);            
        } catch (Exception e) {
            System.err.println("koneksi gagal: " + e.getMessage()); //perintah menampilkan pesan error
            mysqlconfig = null;
        }
        return mysqlconfig;
    }    
}
