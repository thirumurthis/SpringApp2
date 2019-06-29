package com.app2.service;

import org.springframework.context.annotation.Configuration;
import vehicle.test.services.BusVehicleImpl;
import vehicle.test.services.CarVehicleImpl;
import vehicle.test.services.VehicleService;

@Configuration
public class VehicleConfig {

    public VehicleService busService(){
        return new BusVehicleImpl();
    }

    public VehicleService carService(){
        return new CarVehicleImpl();
    }
}
