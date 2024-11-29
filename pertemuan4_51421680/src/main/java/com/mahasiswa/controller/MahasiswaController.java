package com.mahasiswa.controller;

import com.mahasiswa.model.ModelMahasiswa;
import java.util.List;

/**
 *
 * @author yudha
 */
public interface MahasiswaController {
    // Metode untuk menambah mahasiswa
    public void addMhs(ModelMahasiswa mhs);
    
    // Metode untuk mengambil data mahasiswa berdasarkan ID
    public ModelMahasiswa getMhs(int id);
    
    // Metode untuk memperbarui data mahasiswa
    public void updateMhs(ModelMahasiswa mhs);
    
    // Metode untuk menghapus mahasiswa berdasarkan ID
    public void deleteMhs(int id);
    
    // Metode untuk mengambil semua data mahasiswa
    public List<ModelMahasiswa> getAllMahasiswa();
    
    // Menambahkan metode untuk pencarian mahasiswa berdasarkan nama
    public List<ModelMahasiswa> searchMahasiswa(String keyword);
}
