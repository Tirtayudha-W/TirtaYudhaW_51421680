package com.mahasiswa.view;

import com.mahasiswa.controller.MahasiswaController;
import com.mahasiswa.model.MahasiswaDAO;
import java.util.Scanner;

public class MahasiswaView {
    public static void main(String[] args) {
        MahasiswaDAO mahasiswaDAO = new MahasiswaDAO();
        MahasiswaController mahasiswaController = new MahasiswaController(mahasiswaDAO);
        
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        
        while (true) {
            System.out.println("Menu: ");
            System.out.println("1. Tampilkan seluruh biodata ");
            System.out.println("2. Tambahkan biodata mahasiswa");
            System.out.println("3. Update biodata");
            System.out.println("4. Hapus biodata");
            System.out.println("5. Cek Koneksi ");
            System.out.println("6. Keluar");
            System.out.print("PILIH OPSI: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();
            
            switch (pilihan) {
                case 1:
                    mahasiswaController.displayAllMahasiswa();
                    break;
                case 2:
                    System.out.print("Masukkan NPM: ");
                    String npm = scanner.nextLine();
                    System.out.print("Masukkan Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Masukkan Alamat: ");
                    String alamat = scanner.nextLine();
                    System.out.print("Masukkan Kota: ");
                    String kota = scanner.nextLine();
                    
                    mahasiswaController.addMahasiswa(npm, nama, alamat, kota, email);
                    break;
                case 3:
                    System.out.print("Masukkan ID Mahasiswa: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    
                    System.out.print("Masukkan NPM: ");
                    String npmBaru = scanner.nextLine();
                    System.out.print("Masukkan Nama: ");
                    String namaBaru = scanner.nextLine();
                    System.out.print("Masukkan Email: ");
                    String emailBaru = scanner.nextLine();
                    System.out.print("Masukkan Alamat: ");
                    String alamatBaru = scanner.nextLine();
                    System.out.print("Masukkan Kota: ");
                    String kotaBaru = scanner.nextLine();
                    
                    mahasiswaController.updateMahasiswa(id, npmBaru, namaBaru, alamatBaru, kotaBaru, emailBaru);
                    break;
                case 4:
                    System.out.print("Masukkan ID Mahasiswa: ");
                    int idHapus = scanner.nextInt();
                    mahasiswaController.deleteMahasiswa(idHapus);
                    break;
                case 5:
                    mahasiswaController.checkDatabaseConnection();
                    break;
                case 6:
                    mahasiswaController.closeConnection();
                    System.out.println("Program Selesai");
                    return;
                default:
                    System.out.println("Input tidak valid");
            }
        }
    }
}
