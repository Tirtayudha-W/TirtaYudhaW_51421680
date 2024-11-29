package com.mahasiswaa;
import com.mahasiswa.controller.MahasiswaController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 
/**
 *
 * @author Mega Purwanti
 */

@SpringBootApplication
public class Pertemuan5A implements CommandLineRunner{
 
    @Autowired
    private MahasiswaController mhsController;
    public static void main(String[] args) {
        SpringApplication.run(Pertemuan5A.class, args);
    }
 
    @Override
    public void run(String... args) throws Exception {
        mhsController.tampilkanMenu();
    }
 
}