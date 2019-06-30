package com.app2.controller;

import com.app2.service.birds.BirdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class BirdController {

    @Autowired
    private BirdService birdService;

    private BirdService greyJayService;

    @Autowired
    @Qualifier("getGreyJayService")
    //@Qualifier("getSparrowService") //- uncommenting this will through exception
    //since the use of @Profile 
    //By default the crow is set to this case though the @Primary is used
    //either use the concrete implemeter of SparrowImpl class in the parameter
    // or use @Qualifier for making the appropriate object - in this case sparrow impl
    // @Qualifier will make sure to call the appropriate @Bean(name="") or
    // using the method name by default.
    public void setSparrowService(BirdService greyJayService){
        this.greyJayService = greyJayService;
    }

    public void printBirdType(){
        System.out.println(birdService.birdType());
    }

    public void printGreyJayType(){
        System.out.println(greyJayService.birdType());
    }
}
