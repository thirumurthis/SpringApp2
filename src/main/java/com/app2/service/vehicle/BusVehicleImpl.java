package com.app2.service.vehicle;

import org.springframework.stereotype.Component;

@Component
public class BusVehicleImpl implements VehicleService {
    @Override
    public String vehicleType() {
        return "Bus";
    }
}
