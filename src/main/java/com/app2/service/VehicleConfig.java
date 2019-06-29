package com.app2.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import vehicle.test.services.BusVehicleImpl;
import vehicle.test.services.CarVehicleImpl;
import vehicle.test.services.VehicleService;

@Configuration
public class VehicleConfig {

    @Bean
    @Profile("bus")
    public VehicleService busService(){
        return new BusVehicleImpl();
    }

    @Bean
    @Profile("car")
    public VehicleService carService(){
        return new CarVehicleImpl();
    }
}
