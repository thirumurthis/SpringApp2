package com.app2.config;

import com.app2.service.birds.BirdFactory;
import com.app2.service.birds.BirdService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class BirdConfig {

    @Bean
    public BirdFactory birdFactory(){
        return new BirdFactory();
    }

    @Bean
    @Profile({"default","crow"})
    @Primary
    public BirdService getCrowService(BirdFactory birdFactory){
        return birdFactory.getBirdService("crow");
    }

    @Bean
    @Profile("sparrow")
    @Primary
    public BirdService getSparrowService(BirdFactory birdFactory){
        return birdFactory.getBirdService("sparrow");
    }

    @Bean
    public BirdService getGreyJayService(BirdFactory birdFactory){
        return birdFactory.getBirdService("greyjay");
    }

    @Bean
    public BirdService getHummingBirdService(BirdFactory birdFactory){
        return birdFactory.getBirdService("hummingbird");
    }
}
