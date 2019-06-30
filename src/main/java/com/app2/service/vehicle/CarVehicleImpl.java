package com.app2.service.vehicle;

import org.springframework.stereotype.Component;

@Component
public class CarVehicleImpl implements VehicleService{
    @Override
    public String vehicleType() {
        return "Car";
    }
}
