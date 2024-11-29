/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.parkiran;

import com.parkiran.controller.ParkiranController;

import com.parkiran.view.ParkiranGUI2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author ASUS
 */

@SpringBootApplication
public class Parkiran implements ApplicationRunner {
    @Autowired
    private ParkiranController parkController;
    
    public static void main(String[] args){
        System.setProperty("java.awt.headless", "false"); // Disable headless mode
        ApplicationContext context = SpringApplication.run(Parkiran.class, args);
        ParkiranController controller = context.getBean(ParkiranController.class);
        ParkiranGUI2 parkiranGUI = new ParkiranGUI2(controller);
        parkiranGUI.setVisible(true);
        
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        
    }

   
}