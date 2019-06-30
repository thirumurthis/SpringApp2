package com.app2.service.vehicle;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/*@Component
@Profile({"default","car"})
 */
public class CarVehicleImpl implements VehicleService{
    @Override
    public String vehicleType() {
        return "Car";
    }
}
