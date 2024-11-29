/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parkiran.model;
import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 *
 * @author Dimas
 */
public class ModelTabelParkiran extends AbstractTableModel{
    private List<ModelParkiran> parkiranList;
    private String[] columnNames = {"Jenis Kendaraan", "Nomor Plat", "Waktu Masuk"};

    public ModelTabelParkiran(List<ModelParkiran> parkiranList) {
        this.parkiranList = parkiranList;
    }

    @Override
    public int getRowCount() {
        return parkiranList.size(); // Jumlah baris sesuai dengan jumlah data mahasiswa
    }

    @Override
    public int getColumnCount() {
        return columnNames.length; // Jumlah kolom sesuai dengan jumlah elemen dalam columnNames
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ModelParkiran parkiran = parkiranList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                int jenis = parkiran.getJenisKendaraan();
                String jenis_kendaraan;
                if (jenis == 1){
                    jenis_kendaraan = "Motor";
                } else {
                    jenis_kendaraan = "Mobil";
                }
                return jenis_kendaraan;
            case 1:
                return parkiran.getPlatNomor();
            case 2:
                return parkiran.getWaktuMasuk();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column]; // Mengatur nama kolom
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false; // Semua sel tidak dapat diedit
    }

    // Method untuk menambahkan atau memodifikasi data, jika dibutuhkan
    public void setParkiranList(List<ModelParkiran> parkiranList) {
        this.parkiranList = parkiranList;
        fireTableDataChanged(); // Memberitahu JTable bahwa data telah berubah
    }
}
