package com.parkiran.service;

import com.parkiran.model.ModelParkiran;
import com.parkiran.repository.ParkiranRepository;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkiranService {

    @Autowired
    private ParkiranRepository parkiranRepository;

    public void masukParkir(ModelParkiran park) {
        parkiranRepository.save(park);
    }

    public String keluarParkir(String platNomor) {
        Optional<ModelParkiran> optionalParkiran = parkiranRepository.findByPlatNomor(platNomor);
        if (optionalParkiran.isPresent()) {
            ModelParkiran parkiran = optionalParkiran.get();
            LocalDateTime waktuKeluar = LocalDateTime.now();

            // Hitung durasi parkir
            Duration durasi = Duration.between(parkiran.getWaktuMasuk(), waktuKeluar);
            long jamParkir = durasi.toHours();
            if (durasi.toMinutesPart() > 0) {
                jamParkir++; // pembulatan ke atas jika ada menit lebih
            }

            // Hitung biaya parkir
            int tarifPerJam = (parkiran.getJenisKendaraan() == 1) ? 5000 : 10000;
            long totalBiaya = jamParkir * tarifPerJam;
            String total = totalBiaya + "";

            // Hapus data parkir dari database
            parkiranRepository.delete(parkiran);

            // Return informasi biaya parkir
            return total;
        } else {
            return "Kendaraan dengan plat nomor " + platNomor + " tidak ditemukan.";
        }
    }
    
    public List<ModelParkiran> getAllParkiran() {
        return parkiranRepository.findAll();
    }
}
