package com.app2.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import com.vehicle.test.services.BusVehicleImpl;
import com.vehicle.test.services.CarVehicleImpl;
import com.vehicle.test.services.VehicleService;

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
