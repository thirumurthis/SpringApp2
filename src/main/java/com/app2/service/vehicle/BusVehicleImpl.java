package com.app2.service.vehicle;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/*@Component
@Profile("bus")
 */
public class BusVehicleImpl implements VehicleService {
    @Override
    public String vehicleType() {
        return "Bus";
    }
}
