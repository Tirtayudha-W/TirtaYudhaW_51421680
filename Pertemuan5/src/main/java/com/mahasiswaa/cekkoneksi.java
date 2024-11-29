package com.mahasiswaa;
import java.sql.Connection;
import java.sql.DriverManager;

public class cekkoneksi {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/spring_db";
        String username = "root"; // Ganti dengan username Anda
        String password = "";     // Ganti dengan password Anda

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            if (conn != null) {
                System.out.println("Koneksi berhasil!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
