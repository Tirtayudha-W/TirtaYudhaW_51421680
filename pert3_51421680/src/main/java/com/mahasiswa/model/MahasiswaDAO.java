package com.mahasiswa.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MahasiswaDAO {
    private Connection connection;

    public MahasiswaDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mahasiswa", "root", "");
            System.out.println("Koneksi ke database berhasil!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // Driver tidak ditemukan
        } catch (SQLException e) {
            e.printStackTrace(); // Koneksi gagal
        }
    }

    public boolean checkConnection() {
        try {
            return connection != null && !connection.isClosed(); // Koneksi berhasil
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void addMahasiswa(ModelMahasiswa mahasiswa) {
        String sql = "INSERT INTO datamhs (npm, nama, alamat, kota, email) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, mahasiswa.getNpm());
            pstmt.setString(2, mahasiswa.getNama());
            pstmt.setString(3, mahasiswa.getAlamat());
            pstmt.setString(4, mahasiswa.getKota());
            pstmt.setString(5, mahasiswa.getEmail());
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Data berhasil ditambahkan!");
            } else {
                System.out.println("Gagal menambahkan data.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ModelMahasiswa> getAllMahasiswa() {
        List<ModelMahasiswa> mahasiswaList = new ArrayList<>();
        String sql = "SELECT * FROM datamhs";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                mahasiswaList.add(new ModelMahasiswa(
                    rs.getInt("id"),
                    rs.getString("npm"),
                    rs.getString("nama"),
                    rs.getString("alamat"),
                    rs.getString("kota"),
                    rs.getString("email")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mahasiswaList;
    }

    public void updateMahasiswa(ModelMahasiswa mahasiswa) {
        String sql = "UPDATE datamhs SET npm = ?, nama = ?, alamat = ?, kota = ?, email = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, mahasiswa.getNpm());
            pstmt.setString(2, mahasiswa.getNama());
            pstmt.setString(3, mahasiswa.getAlamat());
            pstmt.setString(4, mahasiswa.getKota());
            pstmt.setString(5, mahasiswa.getEmail());
            pstmt.setInt(6, mahasiswa.getId());
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Data berhasil diperbarui!");
            } else {
                System.out.println("Gagal memperbarui data.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMahasiswa(int id) {
        String sql = "DELETE FROM datamhs WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Data berhasil dihapus!");
            } else {
                System.out.println("Gagal menghapus data.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Koneksi berhasil ditutup.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
