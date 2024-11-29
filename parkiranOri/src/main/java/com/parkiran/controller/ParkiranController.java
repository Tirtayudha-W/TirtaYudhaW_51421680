/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parkiran.controller;

import com.parkiran.model.ModelParkiran;
import com.parkiran.repository.ParkiranRepository;
import com.parkiran.service.ParkiranService;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author ASUS
 */

@Controller
public class ParkiranController {
    
    @Autowired
    private ParkiranService parkiranService;
    
    public void masukParkir(ModelParkiran park){
       parkiranService.masukParkir(park);
    }
    
    public String keluarParkir(String platNomorKeluar) {
        return parkiranService.keluarParkir(platNomorKeluar);
    }
    
    public List<ModelParkiran> getAllParkiran() {
        return parkiranService.getAllParkiran();
    }

    
}
