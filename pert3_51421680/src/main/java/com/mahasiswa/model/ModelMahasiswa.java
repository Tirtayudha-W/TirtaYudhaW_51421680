package com.mahasiswa.model;

public class ModelMahasiswa {
    private int id;
    private String npm;
    private String nama;
    private String email;
    private String alamat;
    private String kota;

    public ModelMahasiswa(int id, String npm, String nama, String alamat, String kota, String email) {
        this.id = id;
        this.npm = npm;
        this.nama = nama;
        this.email = email;
        this.alamat = alamat;
        this.kota = kota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

}
