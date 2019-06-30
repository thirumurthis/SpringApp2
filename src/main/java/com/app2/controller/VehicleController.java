package com.app2.controller;

import com.app2.service.vehicle.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    //@Autowired
    //setter injection
    /*public void setVehicleService(VehicleService vehicleService){
        this.vehicleService = vehicleService;
    }*/


    public String printVehicleType(){
        return vehicleService.vehicleType();
    }
}
