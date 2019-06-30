package com.app2.service.birds;

public class BirdFactory {

    public BirdService getBirdService(String birdName){

        BirdService birdService = null;
        birdName = birdName.toUpperCase();
        switch (birdName){
            case "CROW" : birdService = new CrowImpl();break;
            case "GREYJAY" : birdService = new GreyJayImpl();break;
            case "SPARROW" : birdService = new SparrowImpl();break;
            case "HUMMINGBIRD" : birdService = new HummingBirdImpl();break;
            default: birdService= new CrowImpl();
        }
        return birdService;
    }
}
