package com.app2.config;

import com.app2.service.vehicle.BusVehicleImpl;
import com.app2.service.vehicle.CarVehicleImpl;
import com.app2.service.vehicle.VehicleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class VehicleConfig {

    @Bean
    @Profile("bus")
    public VehicleService busService(){
        return new BusVehicleImpl();
    }

    @Bean
    @Profile({"default","car"})
    public VehicleService carService(){
        return new CarVehicleImpl();
    }
}
