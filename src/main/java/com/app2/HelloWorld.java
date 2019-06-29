package com.app2;

import com.app2.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloWorld {

    @Autowired
    private LanguageService languageService;

    public String hello(){
        return languageService.printHello();
    }
}
